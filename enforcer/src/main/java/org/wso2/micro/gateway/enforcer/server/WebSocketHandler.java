package org.wso2.micro.gateway.enforcer.server;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.wso2.micro.gateway.enforcer.api.*;
import org.wso2.micro.gateway.enforcer.api.config.APIConfig;
import org.wso2.micro.gateway.enforcer.constants.APIConstants;
import org.wso2.micro.gateway.enforcer.websocket.RateLimitRequest;

public class WebSocketHandler implements RequestHandler<RateLimitRequest, WebSocketResponseObject>{
    private static final Logger logger = LogManager.getLogger(WebSocketHandler.class);
    @Override
    public WebSocketResponseObject process(RateLimitRequest request) {
        API<WebSocketMetadata, WebSocketResponseObject> matchedAPI = APIFactory.getInstance().getMatchedAPI(request);
        if(matchedAPI == null){
            return WebSocketResponseObject.UNKNOWN;
        } else if (logger.isDebugEnabled()) {
            APIConfig api = matchedAPI.getAPIConfig();
            logger.debug("API {}/{} found in the cache", api.getBasePath(), api.getVersion());
        }
        WebSocketMetadata webSocketMetadata = buildMetadataContext(matchedAPI, request);

        return matchedAPI.process(webSocketMetadata);
    }

    private WebSocketMetadata buildMetadataContext(API<WebSocketMetadata, WebSocketResponseObject> api, RateLimitRequest rateLimitRequest){
        String streamId = rateLimitRequest.getMetadataContext().getFilterMetadataMap().
                get(APIConstants.EXT_AUTHZ_METADATA).getFieldsMap().get(APIConstants.WEBSOCKET_STREAM_ID).getStringValue();
        return new WebSocketMetadata.Builder(streamId).build();
    }
}
