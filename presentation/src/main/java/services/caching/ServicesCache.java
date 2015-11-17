package services.caching;

public interface ServicesCache {

    public void put(CacheData cacheData);

    public CacheData get(String key);

    public void resetServicesCache();
}
