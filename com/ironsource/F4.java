package com.ironsource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class F4 extends SQLiteOpenHelper implements D7 {
    private static F4 f = null;
    private static final String g = " TEXT";
    private static final String h = " INTEGER";
    private static final String i = ",";

    /* renamed from: a, reason: collision with root package name */
    private final G4 f2859a;
    private final int b;
    private final int c;
    private final String d;
    private final String e;

    static abstract class a implements BaseColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String f2860a = "events";
        public static final int b = 4;
        public static final String c = "eventid";
        public static final String d = "timestamp";
        public static final String e = "type";
        public static final String f = "data";

        a() {
        }
    }

    public F4(Context context, String str, int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        this.f2859a = new G4();
        this.b = 4;
        this.c = 400;
        this.d = "DROP TABLE IF EXISTS events";
        this.e = "CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )";
    }

    public static synchronized F4 a(Context context, String str, int i2) {
        F4 f4;
        synchronized (F4.class) {
            if (f == null) {
                f = new F4(context, str, i2);
            }
            f4 = f;
        }
        return f4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r5.isOpen() != false) goto L17;
     */
    @Override // com.ironsource.D7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(String str) {
        SQLiteDatabase sQLiteDatabase;
        String[] strArr = {str};
        try {
            sQLiteDatabase = a(true);
            try {
                sQLiteDatabase.delete("events", "type = ?", strArr);
            } catch (Throwable th) {
                th = th;
                try {
                    C3260q4.d().a(th);
                    Log.e("IronSource", "Exception while clearing events: ", th);
                } finally {
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        onCreate(sQLiteDatabase);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0034, code lost:
    
        if (r0.isOpen() != false) goto L29;
     */
    @Override // com.ironsource.D7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(List<C3413z5> list, String str) {
        if (list != null) {
            if (!list.isEmpty()) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase sQLiteDatabase2 = a(true);
                    try {
                        Iterator<C3413z5> it = list.iterator();
                        while (it.hasNext()) {
                            ContentValues a2 = a(it.next(), str);
                            if (sQLiteDatabase2 != null && a2 != null) {
                                sQLiteDatabase2.insert("events", null, a2);
                            }
                        }
                        if (sQLiteDatabase2 != null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase = sQLiteDatabase2;
                        try {
                            C3260q4.d().a(th);
                            Log.e("IronSource", "Exception while saving events: ", th);
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase2 = sQLiteDatabase;
                                sQLiteDatabase2.close();
                            }
                        } catch (Throwable th2) {
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0070, code lost:
    
        if (r3.isOpen() != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009a, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0098, code lost:
    
        if (r3.isOpen() != false) goto L40;
     */
    @Override // com.ironsource.D7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized ArrayList<C3413z5> a(String str) {
        ArrayList<C3413z5> arrayList;
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            sQLiteDatabase = a(false);
            try {
                cursor = sQLiteDatabase.query("events", null, "type = ?", new String[]{str}, null, null, "timestamp ASC");
                if (cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()) {
                        int columnIndex = cursor.getColumnIndex("eventid");
                        if (columnIndex >= 0) {
                            int i2 = cursor.getInt(columnIndex);
                            int columnIndex2 = cursor.getColumnIndex("timestamp");
                            if (columnIndex2 >= 0) {
                                long j = cursor.getLong(columnIndex2);
                                int columnIndex3 = cursor.getColumnIndex("data");
                                if (columnIndex3 >= 0) {
                                    arrayList.add(new C3413z5(i2, j, cursor.getString(columnIndex3)));
                                    cursor.moveToNext();
                                }
                            }
                        }
                    }
                    cursor.close();
                }
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    C3260q4.d().a(th);
                    Log.e("IronSource", "Exception while loading events: ", th);
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                    }
                    return arrayList;
                } finally {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
        return arrayList;
    }

    private ContentValues a(C3413z5 c3413z5, String str) {
        if (c3413z5 == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("eventid", Integer.valueOf(c3413z5.c()));
        contentValues.put("timestamp", Long.valueOf(c3413z5.d()));
        contentValues.put("type", str);
        contentValues.put("data", c3413z5.a());
        return contentValues;
    }

    private synchronized SQLiteDatabase a(boolean z) throws Throwable {
        int i2 = 0;
        while (true) {
            try {
                if (z) {
                    return this.f2859a.a(true, this);
                }
                return this.f2859a.a(false, this);
            } finally {
            }
        }
    }
}
