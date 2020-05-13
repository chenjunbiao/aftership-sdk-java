package com.aftership.sdk.impl;

import java.util.HashMap;
import java.util.Map;
import com.aftership.sdk.endpoint.AfterShipEndpoint;
import com.aftership.sdk.endpoint.CheckpointEndpoint;
import com.aftership.sdk.lib.UrlUtil;
import com.aftership.sdk.model.checkpoint.GetLastCheckpointParam;
import com.aftership.sdk.model.checkpoint.LastCheckpoint;
import com.aftership.sdk.model.tracking.SingleTrackingParam;
import com.aftership.sdk.rest.ApiRequest;
import com.aftership.sdk.rest.DataEntity;
import com.aftership.sdk.rest.HttpMethod;
import com.aftership.sdk.rest.RequestConfig;

/**
 * CheckpointEndpoint's implementation class
 */
public class CheckpointImpl extends AfterShipEndpoint implements CheckpointEndpoint {

    public CheckpointImpl(ApiRequest request) {
        super(request);
    }

    @Override
    public DataEntity<LastCheckpoint> getLastCheckpoint(SingleTrackingParam param,
                                                        GetLastCheckpointParam optionalParams) {
        Map.Entry<Boolean, DataEntity<LastCheckpoint>> errorOfSingleTrackingParam = errorOfSingleTrackingParam(param);
        if (errorOfSingleTrackingParam.getKey()) {
            return errorOfSingleTrackingParam.getValue();
        }

        Map<String, String> query = this.merge(param.getOptionalParams(), optionalParams);

        String path = UrlUtil.buildTrackingPath(param.getId(), param.getSlug(), param.getTrackingNumber(),
                query, EndpointPath.GET_LAST_CHECKPOINT, null);

        return this.request.makeRequest(new RequestConfig(HttpMethod.GET, path),
                null, LastCheckpoint.class);
    }
}
