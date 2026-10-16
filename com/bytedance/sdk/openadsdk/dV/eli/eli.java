package com.bytedance.sdk.openadsdk.dV.eli;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.bytedance.sdk.component.utils.Xb;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class eli extends SQLiteOpenHelper {
    private static volatile eli DbA;
    final Context eli;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private static eli Os() {
        if (DbA == null) {
            synchronized (eli.class) {
                if (DbA == null) {
                    DbA = new eli(com.bytedance.sdk.openadsdk.dV.eli.eli());
                }
            }
        }
        return DbA;
    }

    public static SQLiteDatabase eli() {
        try {
            eli Os = Os();
            if (Os == null) {
                return null;
            }
            SQLiteDatabase writableDatabase = Os.getWritableDatabase();
            if (writableDatabase.isOpen()) {
                return writableDatabase;
            }
            return null;
        } catch (Throwable th) {
            Log.i("MonitorSQLiteOpenHelper", th.getMessage());
            return null;
        }
    }

    public static SQLiteDatabase DbA() {
        try {
            eli Os = Os();
            if (Os == null) {
                return null;
            }
            SQLiteDatabase readableDatabase = Os.getReadableDatabase();
            if (readableDatabase.isOpen()) {
                return readableDatabase;
            }
            return null;
        } catch (Throwable th) {
            Log.i("MonitorSQLiteOpenHelper", th.getMessage());
            return null;
        }
    }

    private eli(Context context) {
        super(context, "pag_monitor.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.eli = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS monitor_table (_id INTEGER PRIMARY KEY AUTOINCREMENT,sdk_version TEXT ,scene TEXT ,start_count INTEGER default 0 , success_count INTEGER default 0  , fail_count INTEGER default 0  , rit TEXT  , tag TEXT  , label TEXT  , timestamp INTEGER default 0 ,mediation TEXT  , is_init INTEGER , extra TEXT )");
        } catch (Throwable th) {
            Log.e("MonitorSQLiteOpenHelper", th.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (i > i2) {
                eli(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            } else {
                onCreate(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }

    private void eli(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> DbA2 = DbA(sQLiteDatabase);
        if (DbA2 == null || DbA2.size() <= 0) {
            return;
        }
        Iterator<String> it = DbA2.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    private ArrayList<String> DbA(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                rawQuery.close();
                return arrayList;
            }
        } catch (Exception e) {
            Xb.Os("MonitorSQLiteOpenHelper", e.getMessage());
        }
        return arrayList;
    }
}
