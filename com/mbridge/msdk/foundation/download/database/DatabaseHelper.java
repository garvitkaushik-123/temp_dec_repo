package com.mbridge.msdk.foundation.download.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.GlobalComponent;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.tools.p0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class DatabaseHelper implements IDatabaseHelper {
    private volatile SQLiteDatabase database;
    private final IDatabaseOpenHelper databaseOpenHelper;
    private final Handler handler;
    private final String tableName = GlobalComponent.getInstance().getDatabaseTableName();

    public DatabaseHelper(Context context, Handler handler, IDatabaseOpenHelper iDatabaseOpenHelper) {
        this.handler = handler;
        this.databaseOpenHelper = iDatabaseOpenHelper;
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void clear() {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.9
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    return;
                }
                try {
                    if (DatabaseHelper.this.database.isOpen()) {
                        try {
                            DatabaseHelper.this.database.beginTransaction();
                            DatabaseHelper.this.database.delete(DatabaseHelper.this.tableName, null, null);
                            DatabaseHelper.this.database.setTransactionSuccessful();
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                e.printStackTrace();
                            }
                            try {
                                if (DatabaseHelper.this.database.inTransaction()) {
                                    DatabaseHelper.this.database.endTransaction();
                                }
                            } catch (Throwable th) {
                                p0.b(IDatabaseHelper.TAG, th.getMessage());
                            }
                        }
                    }
                } finally {
                    try {
                        if (DatabaseHelper.this.database.inTransaction()) {
                            DatabaseHelper.this.database.endTransaction();
                        }
                    } catch (Throwable th2) {
                        p0.b(IDatabaseHelper.TAG, th2.getMessage());
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void find(final String str, final String str2, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
            /* JADX WARN: Type inference failed for: r0v6 */
            @Override // java.lang.Runnable
            public void run() {
                Cursor cursor;
                IDatabaseHelper.IDatabaseListener iDatabaseListener2;
                ?? r0 = " WHERE download_id = ? AND director_path = ?";
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                DownloadModel downloadModel = null;
                if (!Objects.isNull(DatabaseHelper.this.database)) {
                    try {
                        if (DatabaseHelper.this.database.isOpen()) {
                            try {
                                cursor = DatabaseHelper.this.database.rawQuery("SELECT * FROM " + DatabaseHelper.this.tableName + " WHERE download_id = ? AND director_path = ?", new String[]{str, str2});
                                if (cursor != null) {
                                    try {
                                        if (cursor.moveToFirst()) {
                                            downloadModel = DownloadModel.create(cursor);
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        if (MBridgeConstans.DEBUG) {
                                            e.printStackTrace();
                                        }
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        iDatabaseListener2 = iDatabaseListener;
                                        if (iDatabaseListener2 == null) {
                                            return;
                                        }
                                        iDatabaseListener2.onDatabase(downloadModel);
                                        return;
                                    }
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                iDatabaseListener2 = iDatabaseListener;
                                if (iDatabaseListener2 == null) {
                                    return;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                cursor = null;
                            } catch (Throwable th) {
                                th = th;
                                r0 = 0;
                                if (r0 != 0) {
                                    r0.close();
                                }
                                IDatabaseHelper.IDatabaseListener iDatabaseListener3 = iDatabaseListener;
                                if (iDatabaseListener3 != null) {
                                    iDatabaseListener3.onDatabase(null);
                                }
                                throw th;
                            }
                            iDatabaseListener2.onDatabase(downloadModel);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (Objects.isNotNull(iDatabaseListener)) {
                    iDatabaseListener.onDatabase(null);
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public List<DownloadModel> findAll() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                if (Objects.isNull(this.database)) {
                    this.database = this.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(this.database) && this.database.isOpen()) {
                    cursor = rawQuery("SELECT * FROM " + this.tableName, null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            arrayList.add(DownloadModel.create(cursor));
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                        return arrayList;
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable unused) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return arrayList;
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void findByDownloadUrl(final String str, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.2
            /* JADX WARN: Removed duplicated region for block: B:37:0x0097  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Cursor cursor;
                IDatabaseHelper.IDatabaseListener iDatabaseListener2;
                IDatabaseHelper.IDatabaseListener iDatabaseListener3;
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                DownloadModel downloadModel = null;
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    if (Objects.isNotNull(iDatabaseListener)) {
                        iDatabaseListener.onDatabase(null);
                        return;
                    }
                    return;
                }
                try {
                    cursor = DatabaseHelper.this.database.rawQuery("SELECT * FROM " + DatabaseHelper.this.tableName + " WHERE download_url = ?", new String[]{str});
                    if (cursor != null) {
                        try {
                            try {
                                if (cursor.moveToFirst()) {
                                    downloadModel = DownloadModel.create(cursor);
                                }
                            } catch (Exception e) {
                                e = e;
                                if (MBridgeConstans.DEBUG) {
                                    e.printStackTrace();
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                iDatabaseListener3 = iDatabaseListener;
                                if (iDatabaseListener3 == null) {
                                    return;
                                }
                                iDatabaseListener3.onDatabase(downloadModel);
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            iDatabaseListener2 = iDatabaseListener;
                            if (iDatabaseListener2 != null) {
                                iDatabaseListener2.onDatabase(null);
                            }
                            throw th;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    iDatabaseListener3 = iDatabaseListener;
                    if (iDatabaseListener3 == null) {
                        return;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    if (cursor != null) {
                    }
                    iDatabaseListener2 = iDatabaseListener;
                    if (iDatabaseListener2 != null) {
                    }
                    throw th;
                }
                iDatabaseListener3.onDatabase(downloadModel);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
    
        if (r3 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
    
        if (r3 != null) goto L26;
     */
    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<DownloadModel> getUnwantedModels(long j) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                if (Objects.isNull(this.database)) {
                    this.database = this.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(this.database) && this.database.isOpen()) {
                    cursor = this.database.rawQuery("SELECT * FROM " + this.tableName + " WHERE last_modified_time <= ?", new String[]{String.valueOf(System.currentTimeMillis() - j)});
                    if (cursor != null && cursor.moveToFirst()) {
                        do {
                            arrayList.add(DownloadModel.create(cursor));
                        } while (cursor.moveToNext());
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void insert(final DownloadModel downloadModel) {
        this.handler.postAtFrontOfQueue(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.3
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    try {
                        DatabaseHelper.this.database.beginTransaction();
                        DatabaseHelper.this.database.insert(DatabaseHelper.this.tableName, null, DownloadModel.create(downloadModel));
                        DatabaseHelper.this.database.setTransactionSuccessful();
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                        try {
                            if (DatabaseHelper.this.database.inTransaction()) {
                                DatabaseHelper.this.database.endTransaction();
                            }
                        } catch (Throwable th) {
                            p0.b(IDatabaseHelper.TAG, th.getMessage());
                        }
                    }
                } finally {
                    try {
                        if (DatabaseHelper.this.database.inTransaction()) {
                            DatabaseHelper.this.database.endTransaction();
                        }
                    } catch (Throwable th2) {
                        p0.b(IDatabaseHelper.TAG, th2.getMessage());
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public Cursor rawQuery(String str, String[] strArr) {
        boolean inTransaction;
        try {
            try {
                if (Objects.isNull(this.database)) {
                    this.database = this.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(this.database) && this.database.isOpen()) {
                    this.database.beginTransaction();
                    Cursor rawQuery = this.database.rawQuery(str, strArr);
                    this.database.setTransactionSuccessful();
                    try {
                        if (inTransaction) {
                            return rawQuery;
                        }
                    } catch (Throwable th) {
                    }
                    return rawQuery;
                }
                try {
                    if (this.database.inTransaction()) {
                        this.database.endTransaction();
                        return null;
                    }
                } catch (Throwable th2) {
                    if (MBridgeConstans.DEBUG) {
                        th2.printStackTrace();
                    }
                }
                return null;
            } finally {
                try {
                    if (this.database.inTransaction()) {
                        this.database.endTransaction();
                    }
                } catch (Throwable th3) {
                    if (MBridgeConstans.DEBUG) {
                        th3.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            try {
                if (this.database.inTransaction()) {
                    this.database.endTransaction();
                }
            } catch (Throwable th4) {
                if (MBridgeConstans.DEBUG) {
                    th4.printStackTrace();
                }
            }
            return null;
        }
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void remove(final String str, final String str2) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.6
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE download_id = ? AND director_path = ?", new Object[]{str, str2});
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void update(final DownloadModel downloadModel, final String str) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{downloadModel.getDownloadId(), str});
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void updateProgress(final String str, final String str2, final DownloadModel downloadModel) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.5
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{str, str2});
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void updateUnzipResource(final String str, String str2, long j) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.8
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DownloadModel.DOWNLOAD_ID, str);
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, contentValues, "download_id = ?", new String[]{str});
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void remove(final String str) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.7
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE download_id = ?", new Object[]{str});
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
