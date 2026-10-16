package com.ironsource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class H4 extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private static G4 f2894a = new G4();

    public H4(Context context) {
        super(context, "reports", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static void a(M5 m5) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a2 = f2894a.a(true, new H4(C3260q4.d().a()));
            try {
                a2.beginTransaction();
                ContentValues contentValues = new ContentValues();
                String e = m5.e();
                String b = m5.b();
                String d = m5.d();
                contentValues.put("stack_trace", e);
                contentValues.put("crash_date", b);
                contentValues.put("crashType", d);
                a2.insert("REPORTS", null, contentValues);
                a2.setTransactionSuccessful();
                a2.endTransaction();
                a2.close();
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = a2;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                    sQLiteDatabase.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static M5 b(int i) {
        SQLiteDatabase a2;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            a2 = f2894a.a(new H4(C3260q4.d().a()));
        } catch (Throwable th) {
            th = th;
        }
        try {
            Cursor rawQuery = a2.rawQuery("SELECT * FROM REPORTSWHERE id= " + i + ";", null);
            int i2 = rawQuery.getInt(0);
            String string = rawQuery.getString(1);
            String string2 = rawQuery.getString(2);
            String string3 = rawQuery.getString(3);
            rawQuery.close();
            M5 m5 = new M5(i2, string, string2, string3);
            a2.close();
            return m5;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = a2;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    public static Cursor c() {
        H4 h4 = new H4(C3260q4.d().a());
        new ArrayList();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a2 = f2894a.a(h4);
            try {
                Cursor rawQuery = a2.rawQuery("SELECT * FROM REPORTS;", null);
                a2.close();
                return rawQuery;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = a2;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS REPORTS(id INTEGER PRIMARY KEY AUTOINCREMENT , stack_trace TEXT NOT NULL, crash_date TEXT NOT NULL,crashType TEXT NOT NULL );");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public static Cursor a(int i) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a2 = f2894a.a(new H4(C3260q4.d().a()));
            try {
                Cursor rawQuery = a2.rawQuery("SELECT * FROM REPORTSWHERE id= " + i + ";", null);
                a2.close();
                return rawQuery;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = a2;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static List<M5> b() {
        SQLiteDatabase a2;
        H4 h4 = new H4(C3260q4.d().a());
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            a2 = f2894a.a(h4);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Cursor rawQuery = a2.rawQuery("SELECT * FROM REPORTS ;", null);
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(new M5(rawQuery.getInt(0), rawQuery.getString(1), rawQuery.getString(2), rawQuery.getString(3)));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            a2.close();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = a2;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    public static void a() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = f2894a.a(true, new H4(C3260q4.d().a()));
            sQLiteDatabase.execSQL("DELETE FROM REPORTS WHERE id >= 0;");
            sQLiteDatabase.close();
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }
}
