package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.r0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CacheCampaignDao.java */
/* loaded from: classes6.dex */
public class c extends a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f4216a;

    private c(f fVar) {
        super(fVar);
    }

    public static c a(f fVar) {
        if (f4216a == null) {
            synchronized (c.class) {
                if (f4216a == null) {
                    f4216a = new c(fVar);
                }
            }
        }
        return f4216a;
    }

    public void b(String str, String str2, String str3) {
        if (a(str, str3)) {
            try {
                getWritableDatabase().execSQL("UPDATE CacheCampaign SET show_count = show_count + 1, show_time = ? WHERE rid = ? AND unitid = ? AND state = ?", new Object[]{Long.valueOf(System.currentTimeMillis()), str, str3, "1"});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public long a(String str, String str2, String str3, int i) {
        if (!a(str, str3)) {
            return -1L;
        }
        new ContentValues().put("state", Integer.valueOf(i));
        return getWritableDatabase().update("CacheCampaign", r3, "rid= ? AND unitid = ? AND state = 0", new String[]{str, str3});
    }

    public synchronized boolean a(String str, String str2) {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT rid FROM CacheCampaign WHERE rid= ? AND unitid = ? ", new String[]{str, str2});
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

    public synchronized void a(String str, int i) {
        String str2;
        SQLiteDatabase writableDatabase;
        if (i <= 0) {
            i = 1;
        }
        try {
            str2 = "unitid = ? AND ( (ts + interval_ts) < " + System.currentTimeMillis() + " OR show_count >= ?)";
            writableDatabase = getWritableDatabase();
        } catch (Exception e) {
            p0.b("CacheCampaignDao", e.getLocalizedMessage());
        }
        if (writableDatabase == null) {
            return;
        }
        try {
            writableDatabase.delete("CacheCampaign", str2, new String[]{str, String.valueOf(i)});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public synchronized void a(String str, String str2, String str3) {
        try {
            if (a(str2, str)) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return;
                }
                try {
                    writableDatabase.delete("CacheCampaign", "unitid = ? AND rid = ? ", new String[]{str, str2});
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            p0.b("CampaignDao", e2.getLocalizedMessage());
        }
    }

    public long a(List<CampaignEx> list, String str) {
        CampaignEx campaignEx;
        if (list != null) {
            try {
                if (list.size() == 0 || TextUtils.isEmpty(str) || (campaignEx = list.get(0)) == null) {
                    return 0L;
                }
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("rid", campaignEx.getRequestId());
                contentValues.put("lrid", campaignEx.getLocalRequestId());
                contentValues.put("unitid", str);
                JSONArray jSONArray = new JSONArray();
                Iterator<CampaignEx> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(CampaignEx.campaignToJsonObject(it.next()));
                }
                contentValues.put("campaigns", jSONArray.toString());
                contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
                long candidateCacheTime = campaignEx.getCandidateCacheTime();
                if (candidateCacheTime == 0) {
                    candidateCacheTime = campaignEx.getPlctb();
                    if (candidateCacheTime == 0) {
                        com.mbridge.msdk.setting.g d = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                        if (d == null) {
                            d = com.mbridge.msdk.setting.h.b().a();
                        }
                        candidateCacheTime = d.a0();
                    }
                }
                try {
                    if (r0.a().a("c_e_t", false)) {
                        candidateCacheTime *= 24;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                contentValues.put("interval_ts", Long.valueOf(candidateCacheTime * 1000));
                contentValues.put("ecppv", campaignEx.getEcppv());
                contentValues.put("show_count", Integer.valueOf(campaignEx.getShowCount()));
                contentValues.put("state", (Integer) 0);
                if (a(campaignEx.getRequestId(), str)) {
                    return getWritableDatabase().update("CacheCampaign", contentValues, "rid= ? AND lrid= ? AND unitid = ? AND state = 1", new String[]{campaignEx.getRequestId(), campaignEx.getLocalRequestId(), str});
                }
                return getWritableDatabase().insert("CacheCampaign", null, contentValues);
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1L;
            }
        }
        return 0L;
    }

    public List<com.mbridge.msdk.foundation.cache.b> a(String str, long j) {
        return a(str, 0, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fd, code lost:
    
        if (r6 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x00f5, code lost:
    
        if (r6 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00ff, code lost:
    
        r6.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<com.mbridge.msdk.foundation.cache.b> a(String str, int i, long j) {
        Cursor cursor;
        try {
            cursor = getReadableDatabase().rawQuery("SELECT * FROM CacheCampaign WHERE unitid = ? AND state > ? and (show_time is null or show_time < ? )", new String[]{str, String.valueOf(i), String.valueOf(j)});
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        ArrayList arrayList = new ArrayList();
                        while (cursor.moveToNext()) {
                            com.mbridge.msdk.foundation.cache.b bVar = new com.mbridge.msdk.foundation.cache.b();
                            String string = cursor.getString(cursor.getColumnIndex("campaigns"));
                            JSONArray jSONArray = new JSONArray(string);
                            if (TextUtils.isEmpty(string)) {
                                try {
                                    cursor.close();
                                } catch (Exception unused) {
                                }
                                return null;
                            }
                            if (jSONArray.length() > 0) {
                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                    copyOnWriteArrayList.add(CampaignEx.parseCampaignWithBackData((JSONObject) jSONArray.get(i2)));
                                }
                                bVar.a(copyOnWriteArrayList);
                            }
                            bVar.b(cursor.getString(cursor.getColumnIndex("lrid")));
                            bVar.c(cursor.getString(cursor.getColumnIndex("rid")));
                            bVar.d(cursor.getString(cursor.getColumnIndex("unitid")));
                            bVar.a(cursor.getString(cursor.getColumnIndex("ecppv")));
                            bVar.c(cursor.getLong(cursor.getColumnIndex("ts")));
                            bVar.b(cursor.getInt(cursor.getColumnIndex("state")));
                            bVar.a(cursor.getInt(cursor.getColumnIndex("show_count")));
                            bVar.b(cursor.getLong(cursor.getColumnIndex("show_time")));
                            bVar.a(cursor.getLong(cursor.getColumnIndex("interval_ts")));
                            arrayList.add(bVar);
                        }
                        try {
                            cursor.close();
                        } catch (Exception unused2) {
                        }
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                    } catch (Throwable th2) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        return null;
    }
}
