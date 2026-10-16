package com.bytedance.sdk.component.MGA.eli.eli.eli;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.MGA.eli.wC;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class DbA {
    private Context DbA;
    private C0135DbA eli;

    DbA(Context context) {
        try {
            this.DbA = context.getApplicationContext();
            if (this.eli == null) {
                this.eli = new C0135DbA();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: com.bytedance.sdk.component.MGA.eli.eli.eli.DbA$DbA, reason: collision with other inner class name */
    public class C0135DbA {
        private volatile SQLiteDatabase DbA = null;

        public C0135DbA() {
        }

        private void eli() {
            boolean DbA;
            try {
                if (this.DbA == null || !this.DbA.isOpen()) {
                    synchronized (this) {
                        if (this.DbA == null || !this.DbA.isOpen()) {
                            this.DbA = wC.kb().aGH().eli(wC.kb().MGA());
                            this.DbA.setLockingEnabled(false);
                        }
                    }
                }
            } finally {
                if (!DbA) {
                }
            }
        }

        public void eli(String str) throws SQLException {
            try {
                eli();
                this.DbA.execSQL(str);
            } catch (Throwable th) {
                if (DbA()) {
                    throw th;
                }
            }
        }

        public Cursor eli(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            try {
                eli();
                return this.DbA.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                eli eliVar = new eli();
                if (DbA()) {
                    throw th;
                }
                return eliVar;
            }
        }

        public int eli(String str, ContentValues contentValues, String str2, String[] strArr) {
            try {
                eli();
                return this.DbA.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                if (DbA()) {
                    throw e;
                }
                return 0;
            }
        }

        public long eli(String str, String str2, ContentValues contentValues) {
            try {
                eli();
                return this.DbA.insert(str, str2, contentValues);
            } catch (Exception e) {
                if (DbA()) {
                    throw e;
                }
                return -1L;
            }
        }

        public synchronized void eli(String str, String str2, List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list) {
            JSONObject kb;
            try {
                try {
                    eli();
                    this.DbA.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    for (int i = 0; i < list.size(); i++) {
                        com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar = list.get(i);
                        if (eliVar != null && (kb = eliVar.kb()) != null) {
                            contentValues.put("id", eliVar.Os());
                            String DbA = wC.kb().aqO().DbA(kb.toString());
                            if (!TextUtils.isEmpty(DbA)) {
                                contentValues.put("value", DbA);
                                contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                contentValues.put("retry", (Integer) 0);
                                contentValues.put("encrypt", (Integer) 1);
                                if (com.bytedance.sdk.component.MGA.eli.Os.eli.aGH() && eliVar.aAs() > 0 && (eliVar.aGH() == 0 || eliVar.aGH() == 3)) {
                                    contentValues.put("channel", Integer.valueOf(eliVar.aAs()));
                                }
                                this.DbA.insert(str, str2, contentValues);
                            }
                            contentValues.clear();
                        }
                    }
                    this.DbA.setTransactionSuccessful();
                    new StringBuilder().append(str).append(" insert list size=");
                    list.size();
                    if (this.DbA != null) {
                        this.DbA.endTransaction();
                    }
                } catch (Exception e) {
                    new StringBuilder().append(str).append(" insert list error=");
                    list.size();
                    if (DbA()) {
                        throw e;
                    }
                    if (this.DbA != null) {
                        this.DbA.endTransaction();
                    }
                }
            } catch (Throwable th) {
                if (this.DbA != null) {
                    this.DbA.endTransaction();
                }
                throw th;
            }
        }

        public int eli(String str, String str2, String[] strArr) {
            try {
                eli();
                return this.DbA.delete(str, str2, strArr);
            } catch (Exception e) {
                if (DbA()) {
                    throw e;
                }
                return 0;
            }
        }

        private boolean DbA() {
            SQLiteDatabase sQLiteDatabase = this.DbA;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }
    }

    public C0135DbA eli() {
        return this.eli;
    }

    private class eli extends AbstractCursor {
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

        private eli() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }
    }
}
