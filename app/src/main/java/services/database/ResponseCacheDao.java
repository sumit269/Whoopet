package services.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.security.GeneralSecurityException;
import java.util.List;

import services.EncodeDecodeAES;
import services.caching.CacheData;

public class ResponseCacheDao extends AbstractDao<CacheData> {

    /**
     * @return ResponseCacheDao instance with default encoder.
     */
    public static ResponseCacheDao getInstance() {
        return new ResponseCacheDao(EncodeDecodeAES.defaultDecoder());
    }

    private EncodeDecodeAES encodeDecodeAES;

    @Override
    protected String getTable() {
        return CacheTableContract.CACHE_TABLE_NAME;
    }

    @Override
    protected String[] getColumns() {
        return new String[]{
                CacheTableContract.CACHE_TABLE_COLUMN_KEY,
                CacheTableContract.CACHE_TABLE_COLUMN_VALUE,
                CacheTableContract.CACHE_TABLE_COLUMN_CREATED,
                CacheTableContract.CACHE_TABLE_COLUMN_TTL
        };
    }

    public ResponseCacheDao(EncodeDecodeAES encodeDecodeAES) {
        super();
        this.encodeDecodeAES = encodeDecodeAES;
    }

//    public synchronized void putCacheData(Context context, CacheData cacheData) {
//        updateEntity(context, buildContentValues(cacheData));
//    }
//
//    public void removeCacheByKey(Context context, String cacheKey) {
//        delete(context, CacheTableContract.CACHE_TABLE_COLUMN_KEY + " = ?", new String[]{cacheKey});
//    }
//
//    public void removeCacheWithKeyPrefix(Context context, String keyPrefix) {
//        delete(context, CacheTableContract.CACHE_TABLE_COLUMN_KEY + " LIKE ? ", new String[]{keyPrefix + "%"});
//    }
//
//    public synchronized CacheData getCacheData(Context context, String key) {
//        List<CacheData> items = getItems(context, CacheTableContract.CACHE_TABLE_COLUMN_KEY + " = ?", new String[]{key}, null);
//        if (items.size() > 0) {
//            return items.get(0);
//        }
//        return new CacheData();
//    }


    @Override
    public String getCreateTableScript() {
        return CacheTableContract.CREATE_CACHE_ENTRY_TABLE;
    }

    @Override
    protected CacheData toEntity(Cursor cursor, Context context) {
        CacheData result = new CacheData();
        result.setKey(cursor.getString(cursor.getColumnIndex(CacheTableContract.CACHE_TABLE_COLUMN_KEY)));
        String decryptedValue = decryptValue(cursor.getString(cursor.getColumnIndex(CacheTableContract.CACHE_TABLE_COLUMN_VALUE)));
        result.setValue(decryptedValue);
        result.setCreated(cursor.getString(cursor.getColumnIndex(CacheTableContract.CACHE_TABLE_COLUMN_CREATED)));
        result.setTimeToLiveInSeconds(cursor.getInt(cursor.getColumnIndex(CacheTableContract.CACHE_TABLE_COLUMN_TTL)));
        return result;
    }

    private ContentValues buildContentValues(CacheData cacheData) {
        ContentValues values = new ContentValues();
        values.put(CacheTableContract.CACHE_TABLE_COLUMN_KEY, cacheData.getKey());
        String encryptedValue = encryptValue(cacheData.getValue());
        values.put(CacheTableContract.CACHE_TABLE_COLUMN_VALUE, encryptedValue);
        values.put(CacheTableContract.CACHE_TABLE_COLUMN_CREATED, CacheData.generateCreationTime());
        values.put(CacheTableContract.CACHE_TABLE_COLUMN_TTL, cacheData.getTimeToLiveInSeconds());
        return values;
    }

    private String decryptValue(String value) {
        String decrypt = null;
        try {
            decrypt = encodeDecodeAES.decrypt(value);
        } catch (GeneralSecurityException e) {
            //Log.e("Telstra24x7", e.getMessage());
        }
        return decrypt;
    }

    private String encryptValue(String value) {
        String encrypt = null;
        try {
            encrypt = encodeDecodeAES.encrypt(value);
        } catch (GeneralSecurityException e) {
            //Log.e("Telstra24x7", e.getMessage());
        }
        return encrypt;
    }

    public static final class CacheTableContract {

        private static final String CREATE_TABLE = "CREATE TABLE ";
        private static final String OPEN_BRACKET = " (";
        private static final String TEXT = " TEXT";
        private static final String PRIMARY_KEY = " PRIMARY KEY";
        private static final String COMMA = ",";
        private static final String INTEGER = " INTEGER";
        private static final String CLOSE_BRACKET = " )";
        private static final String DROP_IF_EXISTS = "DROP TABLE IF EXISTS ";
        private static final String IF_NOT_EXISTS = "IF NOT EXISTS ";


        public static final String CACHE_TABLE_NAME = "cache_entry_table";
        public static final String CACHE_TABLE_COLUMN_TTL = "time_to_live";
        public static final String CACHE_TABLE_COLUMN_CREATED = "created_timestamp";
        public static final String CACHE_TABLE_COLUMN_VALUE = "cache_value";
        public static final String CACHE_TABLE_COLUMN_KEY = "cache_key";

        private static final String CREATE_CACHE_ENTRY_TABLE = new StringBuilder()
                .append(CREATE_TABLE + IF_NOT_EXISTS + CACHE_TABLE_NAME + OPEN_BRACKET)
                .append(CACHE_TABLE_COLUMN_KEY + TEXT + PRIMARY_KEY + COMMA)
                .append(CACHE_TABLE_COLUMN_VALUE + TEXT + COMMA)
                .append(CACHE_TABLE_COLUMN_CREATED + TEXT + COMMA)
                .append(CACHE_TABLE_COLUMN_TTL + INTEGER)
                .append(CLOSE_BRACKET)
                .toString();

        public static final String DROP_CACHE_ENTRY_TABLE = new StringBuilder()
                .append(DROP_IF_EXISTS + CACHE_TABLE_NAME)
                .toString();
    }
}
