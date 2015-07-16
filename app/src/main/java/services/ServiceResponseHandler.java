package services;

import java.util.Date;

import services.client.ServiceConstants;

public class ServiceResponseHandler<T> {

    private boolean fromCache = false;

    private Date cachedTime;

    public boolean isFromCache() {
        return fromCache;
    }

    public void setFromCache(boolean wasFromCache) {
        fromCache = wasFromCache;
    }

    public void setCachedTime(Date cachedTime) {
        this.cachedTime = cachedTime;
    }

    public Date getCachedTime() {
        return cachedTime;
    }

//    public TaskResponse handleSuccess(T wrapper) {
//        TaskResponse taskResponse = new TaskResponse(wrapper);
//        taskResponse.setCachedTime(cachedTime);
//        taskResponse.setDataFromCache(fromCache);
//        return taskResponse;
//    }
//
//    public TaskResponse handleFailure(ServiceFailure error) {
//        if (error.isNetworkError()) {
//            return TaskResponse.error(error.getUrl(), error.getMessage(), ServiceConstants.SERVICE_TIMEOUT_ERROR_CODE);
//        } else if (error.getResponse() == null) {
//            return TaskResponse.error(error.getUrl(), error.getMessage(), ServiceConstants.GENERAL_TECH_ERROR_CODE);
//        } else {
//            return TaskResponse.error(error.getUrl(), error.getMessage(), error.getResponse().getStatus());
//        }
//    }
}
