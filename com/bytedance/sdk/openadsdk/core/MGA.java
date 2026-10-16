package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MGA {
    private static final Object Os = new Object();
    private Context DbA;
    private Os eli;

    MGA(Context context) {
        try {
            this.DbA = context == null ? dV.eli() : context.getApplicationContext();
            if (this.eli == null) {
                this.eli = new Os();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context Os() {
        Context context = this.DbA;
        return context == null ? dV.eli() : context;
    }

    public class Os {
        private SQLiteDatabase DbA = null;

        public Os() {
        }

        private synchronized void ui() {
            try {
                synchronized (MGA.Os) {
                    SQLiteDatabase sQLiteDatabase = this.DbA;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        MGA mga = MGA.this;
                        SQLiteDatabase writableDatabase = mga.new eli(mga.Os()).getWritableDatabase();
                        this.DbA = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.Os("DBHelper", th.getMessage());
                if (MGA()) {
                    throw th;
                }
            }
        }

        public SQLiteDatabase eli() {
            ui();
            return this.DbA;
        }

        public synchronized void eli(String str) throws SQLException {
            try {
                ui();
                this.DbA.execSQL(str);
            } catch (Throwable th) {
                if (MGA()) {
                    throw th;
                }
            }
        }

        public synchronized Cursor eli(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursor;
            try {
                ui();
                cursor = this.DbA.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.Os("DBHelper", th.getMessage());
                DbA dbA = new DbA();
                if (MGA()) {
                    throw th;
                }
                cursor = dbA;
            }
            return cursor;
        }

        public synchronized int eli(String str, ContentValues contentValues, String str2, String[] strArr) {
            int i;
            try {
                ui();
                i = this.DbA.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.Xb.Os("DBHelper", e.getMessage());
                if (MGA()) {
                    throw e;
                }
                i = 0;
            }
            return i;
        }

        public synchronized long eli(String str, String str2, ContentValues contentValues) {
            long j;
            try {
                ui();
                j = this.DbA.replace(str, str2, contentValues);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.Xb.Os("DBHelper", e.getMessage());
                if (MGA()) {
                    throw e;
                }
                j = -1;
            }
            return j;
        }

        public synchronized int eli(String str, String str2, String[] strArr) {
            int i;
            try {
                ui();
                i = this.DbA.delete(str, str2, strArr);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.Xb.Os("DBHelper", e.getMessage());
                if (MGA()) {
                    throw e;
                }
                i = 0;
            }
            return i;
        }

        public synchronized void DbA() {
            ui();
            SQLiteDatabase sQLiteDatabase = this.DbA;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.beginTransaction();
        }

        public synchronized void Os() {
            ui();
            SQLiteDatabase sQLiteDatabase = this.DbA;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.setTransactionSuccessful();
        }

        public synchronized void aGH() {
            ui();
            SQLiteDatabase sQLiteDatabase = this.DbA;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        }

        private synchronized boolean MGA() {
            SQLiteDatabase sQLiteDatabase = this.DbA;
            if (sQLiteDatabase != null) {
                if (sQLiteDatabase.inTransaction()) {
                    return true;
                }
            }
            return false;
        }
    }

    private class eli extends SQLiteOpenHelper {
        final Context eli;

        public eli(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 11);
            this.eli = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                eli(sQLiteDatabase, this.eli);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.Os("DBHelper", th.getMessage());
            }
        }

        private void eli(SQLiteDatabase sQLiteDatabase, Context context) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.aGH.aGH.eli());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.aGH.aAs.Os());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.aGH.Dfc.eli());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.aGH.nn.eli());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.Vy.DbA.eli());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.aGH.dV.Os());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.eli.DbA.DbA.Os());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.aAs.eli.Os.Os());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.aGH.aqO.eli());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i > i2) {
                try {
                    Os(sQLiteDatabase);
                    eli(sQLiteDatabase, MGA.this.DbA);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.Xb.Os(th.getMessage(), new Object[0]);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i > i2) {
                try {
                    Os(sQLiteDatabase);
                } catch (Throwable unused) {
                }
            }
            eli(sQLiteDatabase, MGA.this.DbA);
            switch (i) {
                case 1:
                    eli(sQLiteDatabase);
                    break;
                case 2:
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                    eli(sQLiteDatabase);
                    break;
                case 3:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.aGH.Dfc.eli());
                    eli(sQLiteDatabase);
                    break;
                case 4:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.eli.DbA.DbA.Os());
                    eli(sQLiteDatabase);
                    break;
                case 5:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.aGH.nn.eli());
                    eli(sQLiteDatabase);
                    break;
                case 6:
                    eli(sQLiteDatabase);
                    break;
            }
            if (i < 11) {
                try {
                    DbA(sQLiteDatabase);
                    com.bytedance.sdk.openadsdk.Vy.DbA.eli(sQLiteDatabase);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.Xb.Os("DBHelper", th.getMessage());
                }
            }
        }

        private void eli(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.aGH.aGH.DbA());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.aGH.aAs.aGH());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.aGH.Dfc.DbA());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.aGH.nn.DbA());
        }

        private void DbA(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.aAs.eli.Os.aGH());
        }

        private void Os(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> aGH = aGH(sQLiteDatabase);
            if (aGH == null || aGH.size() <= 0) {
                return;
            }
            Iterator<String> it = aGH.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }

        private ArrayList<String> aGH(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayList = new ArrayList<>();
            Cursor cursor = null;
            try {
                cursor = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(0);
                        if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                            arrayList.add(string);
                        }
                    }
                }
                if (cursor != null) {
                    cursor.close();
                    return arrayList;
                }
            } catch (Exception unused) {
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            return arrayList;
        }
    }

    public Os eli() {
        return this.eli;
    }

    private class DbA extends AbstractCursor {
        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }

        private DbA() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }
    }
}
