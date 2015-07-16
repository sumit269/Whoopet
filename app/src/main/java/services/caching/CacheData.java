package services.caching;

import android.text.TextUtils;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import utils.GsonProvider;

public class CacheData<T> {

    protected static final String CREATION_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(CREATION_DATE_TIME_FORMAT);
    public static Gson gson = GsonProvider.getDefaultGson();

    private String key;
    private String value;
    private int timeToLiveInSeconds = -1;
    private String created;

    public CacheData() {
    }

    public static CacheData emptyCacheData(String key, int timeToLiveInSeconds) {
        return new CacheData(key, null, timeToLiveInSeconds);
    }

    public CacheData(String key, String value, int timeToLiveInSeconds) {
        this.key = key;
        this.value = value;
        this.timeToLiveInSeconds = timeToLiveInSeconds;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreated() {
        return created;
    }

    public Date getCreatedDate() {
        try {
            return (created == null) ? null : DATE_FORMATTER.parse(created);
        } catch (ParseException e) {
            return null;
        }
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getTimeToLiveInSeconds() {
        return timeToLiveInSeconds;
    }

    public void setTimeToLiveInSeconds(int ttl) {
        this.timeToLiveInSeconds = ttl;
    }

    public static String generateCreationTime() {
        Calendar calendar = Calendar.getInstance();
        return DATE_FORMATTER.format(calendar.getTime());
    }

    public boolean isValidAndHasNotExpired() {
        return (hasData() && !hasExpired());
    }

    public boolean isValidAndHasExpired() {
        return (hasData() && hasExpired());
    }

    public boolean hasData() {
        return !TextUtils.isEmpty(getKey())
                && !TextUtils.isEmpty(getValue())
                && getTimeToLiveInSeconds() >= 0;
    }

    public boolean hasExpired() {
        Boolean hasExpired = true;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(CREATION_DATE_TIME_FORMAT);
            Date whenDataWasCreated = formatter.parse(getCreated());
            Calendar whenDataExpires = Calendar.getInstance();
            whenDataExpires.setTime(whenDataWasCreated);
            whenDataExpires.add(Calendar.SECOND, getTimeToLiveInSeconds());
            Date now = getCurrentDateAndTime();
            if (whenDataExpires.getTime().compareTo(now) > 0) {
                hasExpired = false;
            }
        } catch (Exception e) {

        }
        return hasExpired;
    }

    public Date getCurrentDateAndTime() {
        return Calendar.getInstance().getTime();
    }

    public T getDataFromJson(Type type) {
        return (TextUtils.isEmpty(value)) ? null : (T) CacheData.fromJson(value, type);
    }

    public static String toJson(Object object, Type type) {
        try {
            return gson.toJson(object, type);
        } catch (Throwable th) {
            //Log.e(CacheData.class.toString(), th.getMessage() + "\nException trying to parse to json : " + type.toString());
        }
        return null;
    }

    public static <T> T fromJson(String json, Type type) {
        try {
            return gson.fromJson(json, type);
        } catch (Throwable th) {
            //Log.e(CacheData.class.toString(), th.getMessage() + "\nException trying to parse from json string: " + json);
        }
        return null;
    }

}
