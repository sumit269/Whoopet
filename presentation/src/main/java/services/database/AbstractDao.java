package services.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

abstract class AbstractDao<E> {

    public abstract String getCreateTableScript();

    protected abstract String getTable();

    protected abstract String[] getColumns();

    protected abstract E toEntity(Cursor mCursor, Context context);


//    protected List<Long> batchUpdateEntity(Context applicationContext, List<ContentValues> contentValuesList) {
//        if (contentValuesList != null) {
//            final SQLiteDatabase db
//                    = ServicesDbHelper.getInstance(applicationContext).getWritableDatabase();
//            List<Long> result = new ArrayList<>(contentValuesList.size());
//
//            try {
//                db.beginTransaction();
//
//                for (ContentValues value : contentValuesList) {
//                    result.add(db.replace(getTable(), null, value));
//                }
//                db.setTransactionSuccessful();
//                return result;
//            } catch (Exception e) {
//                Log.e("AbstractDao", e.getMessage());
//                remediateTable(applicationContext, db);
//            } finally {
//                if (db != null) {
//                    db.endTransaction();
//                }
//            }
//
//        }
//        return null;
//    }


//    protected long updateEntity(Context applicationContext, ContentValues contentValues) {
//        SQLiteDatabase db = ServicesDbHelper.getInstance(applicationContext).getWritableDatabase();
//        try {
//            return db.replace(getTable(), null, contentValues);
//        } catch (Exception e) {
//            Timber.e(e.getMessage());
//            remediateTable(applicationContext, db);
//        }
//        return -1;
//    }
//
//    protected void update(Context context, ContentValues values, String where, String[] params) {
//        SQLiteDatabase db = ServicesDbHelper.getInstance(context).getWritableDatabase();
//        db.update(getTable(), values, where, params);
//    }
//
//    protected boolean delete(Context applicationContext, String where, String[] params) {
//        boolean result = false;
//        SQLiteDatabase db = ServicesDbHelper.getInstance(applicationContext).getWritableDatabase();
//        try {
//            db.delete(getTable(), where, params);
//            result = true;
//        } catch (Exception e) {
//            Logger.error(e);
//            remediateTable(applicationContext, db);
//        }
//
//        return result;
//    }
//
//    protected List<E> getItems(Context applicationContext, String where, String[] params, String orderBy) {
//        SQLiteDatabase db = ServicesDbHelper.getInstance(applicationContext).getReadableDatabase();
//        List<E> items = new ArrayList<>();
//        Cursor mCursor = null;
//        try {
//
//            String table = getTable();
//            mCursor = db.query(true, table, getColumns(),
//                    where,
//                    params,
//                    null,
//                    null,
//                    orderBy,
//                    null
//            );
//
//            if ((mCursor != null) && (mCursor.moveToFirst()) && (mCursor.getCount() > 0)) {
//                do {
//                    items.add(toEntity(mCursor, applicationContext));
//                } while (mCursor.moveToNext());
//            }
//
//        } catch (Exception e) {
//            Logger.error(e);
//            remediateTable(applicationContext, db);
//        } finally {
//            if (mCursor != null) {
//                mCursor.close();
//            }
//        }
//        return items;
//    }
//
//    protected void remediateTable(Context context, SQLiteDatabase db) {
//
//        try {
//            if (!isExistentTable(context, db, getTable())
//                    || !areAllColumnsAvailable(context, db, getTable(), getColumns())) {
//
//                if (db == null || !db.isOpen()) {
//                    db = ServicesDbHelper.getInstance(context).getWritableDatabase();
//                }
//
//                if (db != null && db.isOpen()) {
//                    db.execSQL("DROP TABLE IF EXISTS " + getTable());
//                    db.execSQL(getCreateTableScript());
//                }
//            }
//
//        } catch (Exception e) {
//            Logger.error(e, "Error remediating table " + getTable());
//        }
//    }
//
//    private boolean areAllColumnsAvailable(Context context, SQLiteDatabase db, String tableName, String[] columns) {
//        boolean allColumnsExist = false;
//        if (columns == null) {
//            allColumnsExist = true;
//        } else if (context != null && tableName != null) {
//            Cursor cursor = null;
//            try {
//                if (db == null || !db.isOpen()) {
//                    db = ServicesDbHelper.getInstance(context).getReadableDatabase();
//                }
//
//                if (db != null && db.isOpen()) {
//                    cursor = db.rawQuery("SELECT * FROM " + tableName + " LIMIT 0", null);
//                    if (cursor != null && cursor.getCount() > 0) {
//                        String columnName = "";
//                        try {
//                            for (String column : columns) {
//                                columnName = column;
//                                cursor.getColumnIndexOrThrow(columnName);
//                            }
//                            allColumnsExist = true;
//
//                        } catch (IllegalArgumentException e) {
//                            Logger.error(e, "Column " + columnName + " was not found in table " + tableName);
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                Logger.error(e, "Error checking table existence for " + tableName);
//            } finally {
//                if (cursor != null && cursor.isClosed()) {
//                    cursor.close();
//                }
//            }
//        }
//
//        return allColumnsExist;
//    }
//
//    private boolean isExistentTable(Context context, SQLiteDatabase db, String tableName) {
//        boolean exist = false;
//        if (context != null && tableName != null) {
//            Cursor cursor = null;
//            try {
//                if (db == null || !db.isOpen()) {
//                    db = ServicesDbHelper.getInstance(context).getReadableDatabase();
//                }
//
//                if (db != null && db.isOpen()) {
//                    cursor = db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE type='table' AND tbl_name = '" + tableName + "'", null);
//                    if (cursor != null && cursor.getCount() > 0) {
//                        exist = true;
//                    }
//                }
//            } catch (Exception e) {
//                Logger.error(e, "Error checking table existence for " + tableName);
//            } finally {
//                if (cursor != null && cursor.isClosed()) {
//                    cursor.close();
//                }
//            }
//        }
//
//        return exist;
//    }

}
