package com.bytedance.sdk.component.MGA.eli.eli.eli;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.MGA.eli.wC;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class aGH extends SQLiteOpenHelper {
    final Context eli;

    public aGH(Context context) {
        super(context, "ttadlog.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.eli = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            eli(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    private void eli(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.MGA.eli.eli.eli.eli.eli.DbA(wC.kb().aGH().DbA()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.MGA.eli.eli.eli.eli.aGH.Os(wC.kb().aGH().eli()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.MGA.eli.eli.eli.eli.kb.Os(wC.kb().aGH().aGH()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.MGA.eli.eli.eli.eli.MGA.eli(wC.kb().aGH().ui()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.MGA.eli.MGA.MGA.DbA());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (i > i2) {
                DbA(sQLiteDatabase);
                eli(sQLiteDatabase);
            } else {
                eli(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }

    private void DbA(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> Os = Os(sQLiteDatabase);
        if (Os == null || Os.size() <= 0) {
            return;
        }
        Iterator<String> it = Os.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    private ArrayList<String> Os(SQLiteDatabase sQLiteDatabase) {
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
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
