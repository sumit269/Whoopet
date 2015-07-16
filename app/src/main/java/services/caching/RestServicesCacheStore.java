package services.caching;

import android.content.Context;

import services.EncodeDecodeAES;
import services.database.ResponseCacheDao;

public class RestServicesCacheStore {

    public static final String MSISDN_USERNAME = "__msisdn__";
    private Context context;
    private ResponseCacheDao responseCacheDao;

    public RestServicesCacheStore(Context context, EncodeDecodeAES encodeDecodeAES) {
        this.context = context;
        responseCacheDao = new ResponseCacheDao(encodeDecodeAES);
    }

    public void put(CacheData cacheData) {
        responseCacheDao.putCacheData(context, cacheData);
    }

    public CacheData get(String key) {
        return responseCacheDao.getCacheData(context, key);
    }

    public void removeByKey(String cacheKey) {
        responseCacheDao.removeCacheByKey(context, cacheKey);
    }

    public static void removeAllCacheByUser(Context context, String userName) {
        ResponseCacheDao.getInstance().removeCacheWithKeyPrefix(context, userName);
    }
}
