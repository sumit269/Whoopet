package services;

import java.util.Date;

import retrofit.Callback;

public abstract class BaseCallback<T> implements Callback<T> {

    private boolean fromCache = false;
    private Date cachedTime;

    public void setFromCache(boolean wasFromCache) {
        fromCache = wasFromCache;
    }

    public boolean isFromCache() {
        return fromCache;
    }

    public void setCachedTime(Date cachedTime) {
        this.cachedTime = cachedTime;
    }

    public Date getCachedTime() {
        return cachedTime;
    }

//    public abstract void failure(ServiceFailure failure);
//
//    @Override
//    final public void failure(RetrofitError error) {
//        failure(new ServiceFailure(error));
//    }


}
