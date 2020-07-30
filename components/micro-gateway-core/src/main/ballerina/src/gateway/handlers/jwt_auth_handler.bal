// Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
//
// WSO2 Inc. licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except
// in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

import ballerina/http;
import ballerina/jwt;
import ballerina/runtime;

# Representation of the jwt self validating handler
#
# + jwtAuthProvider - The reference to the jwt auth provider instance
# + remoteUserClaimRetrievalEnabled - true if remoteUserClaimRetrieval is enabled for the issuer
public type JWTAuthHandler object {

    *http:InboundAuthHandler;

    public JwtAuthProvider jwtAuthProvider;

    //todo: remove the redundant config reading at both handlers.
    private boolean enabledJWTGenerator = false;
    private boolean classLoaded = false;
    private int skewTime = 0;
    private boolean enabledCaching = false;
    private boolean remoteUserClaimRetrievalEnabled = false;

    public function __init(JwtAuthProvider jwtAuthProvider, boolean remoteUserClaimRetrievalEnabled) {
        self.jwtAuthProvider = jwtAuthProvider;
        GatewayConf gatewayConf = getGatewayConfInstance();
        // initiating generator class if enabled
        self.enabledJWTGenerator = gatewayConf.jwtGeneratorConfig.jwtGeneratorEnabled;
        if (self.enabledJWTGenerator) {
            // provide backward compatibility for skew time
            self.skewTime = getConfigIntValue(SERVER_CONF_ID, 
                                                SERVER_TIMESTAMP_SKEW, 
                                                DEFAULT_SERVER_TIMESTAMP_SKEW);
            if (self.skewTime == DEFAULT_SERVER_TIMESTAMP_SKEW) {
                self.skewTime = gatewayConf.getKeyManagerConf().timestampSkew;
            }
            self.enabledCaching = gatewayConf.jwtGeneratorConfig.jwtGeneratorCaching.tokenCacheEnable;
            self.classLoaded = jwtGeneratorClassLoaded;
            self.remoteUserClaimRetrievalEnabled = remoteUserClaimRetrievalEnabled;
        }
    }

    # Checks if the request can be authenticated with the Bearer Auth header.
    #
    # + req - The `Request` instance.
    # + return - Returns `true` if can be authenticated. Else, returns `false`.
    public function canProcess(http:Request req) returns @tainted boolean {
        string authHeader = runtime:getInvocationContext().attributes[AUTH_HEADER].toString();
        if (req.hasHeader(authHeader)) {
            string headerValue = req.getHeader(authHeader).toLowerAscii();
            if (headerValue.startsWith(AUTH_SCHEME_BEARER_LOWERCASE)) {
                string credential = headerValue.substring(6, headerValue.length()).trim();
                string[] splitContent = split(credential, "\\.");
                if (splitContent.length() == 3) {
                    printDebug(KEY_AUTHN_FILTER, "Request will authenticated via jwt handler");
                    return true;
                }
            }
        }
        return false;
    }

    # Authenticates the incoming request with the use of credentials passed as the Bearer Auth header.
    #
    # + req - The `Request` instance.
    # + return - Returns `true` if authenticated successfully. Else, returns `false`
    # or the `AuthenticationError` in case of an error.
    public function process(http:Request req) returns @tainted boolean | http:AuthenticationError {
        string authHeader = runtime:getInvocationContext().attributes[AUTH_HEADER].toString();
        string headerValue = req.getHeader(authHeader);
        string credential = headerValue.substring(6, headerValue.length()).trim();
        var authenticationResult = self.jwtAuthProvider.authenticate(credential);
        if (authenticationResult is boolean) {
            string issuer = self.jwtAuthProvider.jwtValidatorConfig?.issuer ?: DEFAULT_JWT_ISSUER;
            boolean backendJWTfromClaim = setBackendJwtHeader(self.jwtAuthProvider.jwtValidatorConfig, credential, req);
            if (!backendJWTfromClaim) {
                boolean generationStatus = generateAndSetBackendJwtHeaderJWT(self.jwtAuthProvider.jwtValidatorConfig,
                                                                            credential,
                                                                            req,
                                                                            self.enabledJWTGenerator,
                                                                            self.classLoaded,
                                                                            self.skewTime,
                                                                            self.enabledCaching,
                                                                            issuer,
                                                                            self.remoteUserClaimRetrievalEnabled);
                if (!generationStatus) {
                    printError(KEY_JWT_AUTH_PROVIDER, "JWT Generation failed");
                }
                return authenticationResult;
            } else {
                printDebug(KEY_JWT_AUTH_PROVIDER, "JWT is set from the payload claim");
                return true;
            }
        } else {
            return prepareAuthenticationError("Failed to authenticate with jwt bearer auth handler.", authenticationResult);
        }
    }

};

# Check whether backendJwt claim is in the payload and set the header if avaialable.
#
# + jwtValidatorConfig - jwtValidatorConfig to access the jwtCache object
# + credential - Credential
# + req - The `Request` instance.
# + issuer - The jwt issuer who issued the token and comes in the iss claim.
# + return - Returns boolean based on backend jwt setting.
public function setBackendJwtHeader(jwt:JwtValidatorConfig jwtValidatorConfig,
                                    string credential,
                                    http:Request req)
                                    returns @tainted boolean {
    (jwt:JwtPayload | error) payload = getDecodedJWTPayload(jwtValidatorConfig, credential);
    if (payload is jwt:JwtPayload) {
        map<json>? customClaims = payload?.customClaims;
        // validate backend jwt claim and set it to jwt header
        if (customClaims is map<json> && customClaims.hasKey(BACKEND_JWT)) {
            printDebug(KEY_JWT_AUTH_PROVIDER, "Set backend jwt header from payload claim.");
            req.setHeader(jwtheaderName, customClaims.get(BACKEND_JWT).toString());
            return true;
        }
    }
    return false;
}

// TODO: Try to merge with the subscription validation method
# Identify the api details from the subscribed apis in the authentication token.
#
# + payload - The payload of the authentication token
# + apiName - name of the current API
# + apiVersion - version of the current API
# + return - Returns map<string> with the extracted details.
public function getAPIDetails(jwt:JwtPayload payload, string apiName, string apiVersion) returns map<string> {
    if (!isSelfContainedToken(payload)) {
        return createAPIDetailsMap();
    }
    map<string> apiDetails = {
        apiName: "",
        apiContext: "",
        apiVersion: "",
        apiTier: "",
        apiPublisher: "",
        subscriberTenantDomain: ""
    };
    json subscribedAPIList = [];
    map<json>? customClaims = payload?.customClaims;
    //get allowed apis
    if (customClaims is map<json> && customClaims.hasKey(SUBSCRIBED_APIS)) {
        printDebug(KEY_JWT_AUTH_PROVIDER, "subscribedAPIs claim found in the jwt.");
        subscribedAPIList = customClaims.get(SUBSCRIBED_APIS);
    }
    if (subscribedAPIList is json[]) {
        if (!(apiName == "" && apiVersion == "")) {
            printDebug(KEY_JWT_AUTH_PROVIDER, "Current API name: " + apiName + ", current version: " + apiVersion);
            int l = subscribedAPIList.length();
            int index = 0;
            while (index < l) {
                var subscription = subscribedAPIList[index];
                if (subscription.name.toString() == apiName && 
                (subscription.'version.toString() == apiVersion || subscription.'version.toString() == "*")) {
                    // API is found in the subscribed APIs
                    if (isDebugEnabled) {
                        printDebug(KEY_JWT_AUTH_PROVIDER, "Found the API in subscribed APIs:" + subscription.name.toString()
                            + " version:" + subscription.'version.toString());
                    }
                    if (subscription.name is json) {
                        apiDetails["apiName"] = subscription.name.toString();
                    }
                    if (subscription.'version is json) {
                        apiDetails["apiVersion"] = apiVersion;
                    }
                    if (subscription.context is json) {
                        apiDetails["apiContext"] = subscription.context.toString();
                    }
                    if (subscription.subscriptionTier is json) {
                        apiDetails["apiTier"] = subscription.subscriptionTier.toString();
                    }
                    if (subscription.publisher is json) {
                        apiDetails["apiPublisher"] = subscription.publisher.toString();
                    }
                    if (subscription.subscriberTenantDomain is json) {
                        apiDetails["subscriberTenantDomain"] = subscription.subscriberTenantDomain.toString();
                    }
                }
                index += 1;
            }
        }
    }
    return apiDetails;
}

# Generate the backend JWT token and set to the header of the outgoing request.
#
# + jwtValidatorConfig - jwtValidatorConfig to access the jwtCache object
# + credential - Credential
# + req - The `Request` instance.
# + enabledJWTGenerator - state of jwt generator
# + classLoaded - whether the class is loaded successfully
# + enabledCaching - jwt generator caching enabled
# + skewTime - skew time to backend
# + issuer - The jwt issuer who issued the token and comes in the iss claim.
# + remoteUserClaimRetrievalEnabled - true if remoteUserClaimRetrieval is enabled
# + return - Returns `true` if the token generation and setting the header completed successfully
# or the `AuthenticationError` in case of an error.
public function generateAndSetBackendJwtHeaderJWT(jwt:JwtValidatorConfig jwtValidatorConfig,
                                                string credential,
                                                http:Request req,
                                                boolean enabledJWTGenerator,
                                                boolean classLoaded,
                                                int skewTime,
                                                boolean enabledCaching,
                                                string issuer,
                                                boolean remoteUserClaimRetrievalEnabled) returns @tainted boolean {
    if (enabledJWTGenerator) {
        if (classLoaded) {
            boolean status = false;
            string apiName = "";
            string apiVersion = "";
            APIConfiguration? apiConfig = apiConfigAnnotationMap[runtime:getInvocationContext().attributes[http:SERVICE_NAME].toString()];
            if (apiConfig is APIConfiguration) {
                apiName = apiConfig.name;
                apiVersion = apiConfig.apiVersion;
            }
            string cacheKey = credential + apiName + apiVersion;
            (jwt:JwtPayload | error) payload = getDecodedJWTPayload(jwtValidatorConfig, credential);
            if (payload is jwt:JwtPayload) {
                printDebug(KEY_JWT_AUTH_PROVIDER, "decoded token credential");
                // get the subscribedAPI details
                map<string> apiDetails = getAPIDetails(payload, apiName, apiVersion);
                BackendJWTGenUserContextDTO tokenContextDTO = {
                    issuer : issuer,
                    remoteUserClaimRetrievalEnabled : remoteUserClaimRetrievalEnabled,
                    payload : payload
                };
                status = setJWTTokenWithCacheCheck(req, cacheKey, skewTime, enabledCaching, tokenContextDTO, apiDetails);
                
            } else {
                printDebug(KEY_JWT_AUTH_PROVIDER, "Failed to read JWT token");
            }
            return status;
        } else {
            printDebug(KEY_JWT_AUTH_PROVIDER, "Class loading failed");
            return false;
        }
    } else {
        printDebug(KEY_JWT_AUTH_PROVIDER, "JWT Generator is disabled");
        return true;
    }
}
