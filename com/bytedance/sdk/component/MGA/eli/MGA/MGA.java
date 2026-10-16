package com.bytedance.sdk.component.MGA.eli.MGA;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class MGA implements ui {
    private Context eli;

    public MGA(Context context) {
        this.eli = context;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.MGA.ui
    public List<aGH> eli() {
        LinkedList linkedList = new LinkedList();
        Cursor eli = com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(this.eli, "trackurl", null, null, null, null, null, null);
        if (eli != null) {
            while (eli.moveToNext()) {
                try {
                    String string = eli.getString(eli.getColumnIndex("id"));
                    String string2 = eli.getString(eli.getColumnIndex("url"));
                    boolean z = eli.getInt(eli.getColumnIndex("replaceholder")) > 0;
                    int i = eli.getInt(eli.getColumnIndex("retry"));
                    int i2 = eli.getInt(eli.getColumnIndex("url_type"));
                    String string3 = eli.getString(eli.getColumnIndex("ad_id"));
                    String string4 = eli.getString(eli.getColumnIndex(AndroidBridgeConstants.ERROR_CODE));
                    String string5 = eli.getString(eli.getColumnIndex("error_msg"));
                    aGH agh = new aGH(string, string2, z, i2, string3);
                    agh.eli(i);
                    if (!TextUtils.isEmpty(string4)) {
                        agh.eli(string4);
                    }
                    if (!TextUtils.isEmpty(string5)) {
                        agh.DbA(string5);
                    }
                    linkedList.add(agh);
                } catch (Throwable unused) {
                    if (eli != null) {
                        try {
                            eli.close();
                            eli = null;
                        } finally {
                            if (eli != null) {
                                eli.close();
                            }
                        }
                    }
                    if (eli != null) {
                        eli.close();
                    }
                }
            }
            if (eli != null) {
                return linkedList;
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.MGA.ui
    public aGH eli(String str) {
        Cursor eli = com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(this.eli, "trackurl", null, "id=?", new String[]{str}, null, null, null);
        if (eli != null && eli.moveToFirst()) {
            try {
                String string = eli.getString(eli.getColumnIndex("id"));
                String string2 = eli.getString(eli.getColumnIndex("url"));
                boolean z = eli.getInt(eli.getColumnIndex("replaceholder")) > 0;
                int i = eli.getInt(eli.getColumnIndex("retry"));
                int i2 = eli.getInt(eli.getColumnIndex("url_type"));
                String string3 = eli.getString(eli.getColumnIndex("ad_id"));
                String string4 = eli.getString(eli.getColumnIndex(AndroidBridgeConstants.ERROR_CODE));
                String string5 = eli.getString(eli.getColumnIndex("error_msg"));
                aGH agh = new aGH(string, string2, z, i2, string3);
                agh.eli(i);
                if (!TextUtils.isEmpty(string4)) {
                    agh.eli(string4);
                }
                if (!TextUtils.isEmpty(string5)) {
                    agh.DbA(string5);
                }
                return agh;
            } catch (Throwable th) {
                try {
                    th.getMessage();
                    eli.close();
                    eli = null;
                } finally {
                    eli.close();
                }
            }
        }
        if (eli != null) {
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.MGA.ui
    public void eli(aGH agh) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", agh.eli());
        contentValues.put("url", agh.DbA());
        contentValues.put("replaceholder", Integer.valueOf(agh.Os() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(agh.aGH()));
        contentValues.put("url_type", Integer.valueOf(agh.ui()));
        contentValues.put("ad_id", agh.MGA());
        contentValues.put(AndroidBridgeConstants.ERROR_CODE, agh.kb());
        contentValues.put("error_msg", agh.FC());
        com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(this.eli, "trackurl", contentValues);
    }

    @Override // com.bytedance.sdk.component.MGA.eli.MGA.ui
    public void DbA(aGH agh) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", agh.eli());
        contentValues.put("url", agh.DbA());
        contentValues.put("replaceholder", Integer.valueOf(agh.Os() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(agh.aGH()));
        contentValues.put(AndroidBridgeConstants.ERROR_CODE, agh.kb());
        contentValues.put("error_msg", agh.FC());
        contentValues.put("url_type", Integer.valueOf(agh.ui()));
        contentValues.put("ad_id", agh.MGA());
        com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(this.eli, "trackurl", contentValues, "id=?", new String[]{agh.eli()});
    }

    @Override // com.bytedance.sdk.component.MGA.eli.MGA.ui
    public void Os(aGH agh) {
        com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(this.eli, "trackurl", "id=?", new String[]{agh.eli()});
    }

    public static String DbA() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0, retry INTEGER default 0)";
    }
}
