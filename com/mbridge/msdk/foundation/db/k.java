package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.p0;
import org.json.JSONObject;

/* compiled from: ReplaceTempDao.java */
/* loaded from: classes6.dex */
public class k extends a {

    /* renamed from: a, reason: collision with root package name */
    private static String f4225a = "ReplaceTempDao";
    private static k b;

    private k(f fVar) {
        super(fVar);
    }

    public static k a(f fVar) {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new k(fVar);
                }
            }
        }
        return b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x005a, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        if (r4 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0058, code lost:
    
        if (r4 != null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject b(String str) {
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM c_replace_temp WHERE d_key = ? ", new String[]{str});
        if (rawQuery != null) {
            try {
                if (rawQuery.getCount() > 0) {
                    jSONObject = new JSONObject();
                    while (rawQuery.moveToNext()) {
                        jSONObject = new JSONObject(rawQuery.getString(rawQuery.getColumnIndex("d_value")));
                    }
                }
            } catch (Throwable th) {
                try {
                    p0.b(f4225a, th.getMessage());
                } catch (Throwable th2) {
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th2;
                }
            }
        }
        if (rawQuery != null) {
            try {
                rawQuery.close();
            } catch (Exception unused2) {
            }
        }
        return jSONObject;
    }

    public void a(String str, JSONObject jSONObject) {
        try {
            if (getWritableDatabase() == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("d_key", str);
            contentValues.put("d_value", jSONObject.toString());
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            if (!a(str)) {
                getWritableDatabase().insert("c_replace_temp", null, contentValues);
            } else {
                getWritableDatabase().update("c_replace_temp", contentValues, "d_key = ? ", new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a(String str) {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT d_value FROM c_replace_temp WHERE d_key= ? ", new String[]{str});
        if (rawQuery != null && rawQuery.getCount() > 0) {
            try {
                rawQuery.close();
            } catch (Exception unused) {
            }
            return true;
        }
        if (rawQuery != null) {
            try {
                rawQuery.close();
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
    
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject a() {
        JSONObject jSONObject;
        a(7);
        JSONObject jSONObject2 = null;
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM c_replace_temp", null);
        if (rawQuery != null) {
            try {
            } catch (Throwable th) {
                JSONObject jSONObject3 = jSONObject2;
                th = th;
                jSONObject = jSONObject3;
            }
            if (rawQuery.getCount() > 0) {
                jSONObject = new JSONObject();
                while (rawQuery.moveToNext()) {
                    try {
                        jSONObject.put(rawQuery.getString(rawQuery.getColumnIndex("d_key")), new JSONObject(rawQuery.getString(rawQuery.getColumnIndex("d_value"))));
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            p0.b(f4225a, th.getMessage());
                        } catch (Throwable th3) {
                            if (rawQuery != null) {
                                try {
                                    rawQuery.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th3;
                        }
                    }
                }
                jSONObject2 = jSONObject;
                if (rawQuery != null) {
                    return jSONObject2;
                }
                jSONObject = jSONObject2;
                try {
                    rawQuery.close();
                } catch (Exception unused2) {
                }
                return jSONObject;
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        if (rawQuery != null) {
        }
    }

    public void a(int i) {
        long currentTimeMillis = System.currentTimeMillis() - (i * 86400000);
        try {
            if (getWritableDatabase() == null) {
                return;
            }
            getWritableDatabase().delete("c_replace_temp", "time<?", new String[]{String.valueOf(currentTimeMillis)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
