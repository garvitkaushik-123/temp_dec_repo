package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.AabEntity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.r0;
import com.mbridge.msdk.out.Campaign;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: CampaignDao.java */
/* loaded from: classes6.dex */
public class e extends com.mbridge.msdk.foundation.db.a<Campaign> {
    private static e r;

    /* renamed from: a, reason: collision with root package name */
    private final String f4218a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;

    /* compiled from: CampaignDao.java */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f4219a;
        final /* synthetic */ String b;

        a(List list, String str) {
            this.f4219a = list;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f4219a.iterator();
            while (it.hasNext()) {
                e.this.a((CampaignEx) it.next(), this.b, 0);
            }
        }
    }

    protected e(f fVar) {
        super(fVar);
        this.f4218a = "rid";
        this.b = "lrid";
        this.c = "cid";
        this.d = CampaignEx.JSON_KEY_PLCT;
        this.e = CampaignEx.JSON_KEY_PLCTB;
        this.f = "timestamp";
        this.g = "ridCount";
        this.h = " WHERE ";
        this.i = " AND ";
        this.j = "SELECT ";
        this.k = "*";
        this.l = " FROM ";
        this.m = " AND readyState = '0'";
        this.n = " AND is_bid_campaign = 1";
        this.o = " order by ts ASC";
        this.p = " group by request_id";
        this.q = " group by bid_token";
    }

    public static synchronized e a(f fVar) {
        e eVar;
        synchronized (e.class) {
            if (r == null) {
                r = new e(fVar);
            }
            eVar = r;
        }
        return eVar;
    }

    public synchronized void b(String str, List<CampaignEx> list) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", (Integer) 0);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, "unitid = ? AND id = ? AND request_id = ? ", new String[]{str, campaignEx.getId(), campaignEx.getRequestId()});
                        }
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("CampaignDao", e.getLocalizedMessage());
                        }
                    }
                }
            }
        }
    }

    public synchronized void d(String str, String str2) {
        try {
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        String[] strArr = {str, str2};
        ContentValues contentValues = new ContentValues();
        contentValues.put("readyState", (Integer) 2);
        getWritableDatabase().update("campaign", contentValues, "id = ? AND request_id = ? ", strArr);
    }

    public synchronized void e(String str, String str2) {
        String[] strArr;
        try {
            strArr = new String[]{str, str2};
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("campaign", "id = ? AND unitid = ? ", strArr);
    }

    public int f(String str, String str2) {
        String[] strArr;
        String str3;
        if (TextUtils.isEmpty(str)) {
            strArr = new String[]{str2};
            str3 = "unitid = ?  AND is_bid_campaign = 1";
        } else {
            strArr = new String[]{str2, str};
            str3 = "unitid = ?  AND request_id = ?  AND is_bid_campaign = 1";
        }
        String concat = str3.concat(" AND readyState = '0'");
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", (Integer) 2);
            return getWritableDatabase().update("campaign", contentValues, concat, strArr);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
            return 0;
        }
    }

    public synchronized List<CampaignEx> c(String str) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM campaign WHERE unitid = ? AND readyState = 2", new String[]{str});
            if (rawQuery == null || rawQuery.getCount() <= 0) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                arrayList.add(a(rawQuery));
            }
            rawQuery.close();
            return arrayList;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
            return null;
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", th.getLocalizedMessage());
            }
            return null;
        }
    }

    public synchronized void a(String str, int i, int i2) {
        String[] strArr;
        try {
            strArr = new String[]{str, String.valueOf(i), String.valueOf(i2)};
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("campaign", "unitid = ? AND level = ? AND adSource = ? ", strArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        if (r1 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0060, code lost:
    
        if (0 == 0) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<String> e(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                try {
                    synchronized (new Object()) {
                        cursor = getReadableDatabase().rawQuery("SELECT local_request_id as lrid FROM campaign WHERE unitid = ? AND readyState = ?", new String[]{str, String.valueOf(2)});
                    }
                    if (cursor != null && cursor.getCount() > 0) {
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("lrid"));
                            if (!TextUtils.isEmpty(string)) {
                                arrayList.add(string);
                            }
                        }
                    }
                } catch (Exception e) {
                    p0.b("CampaignDao", e.getLocalizedMessage());
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c6, code lost:
    
        if (r11 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00de, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00dc, code lost:
    
        if (0 != 0) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<com.mbridge.msdk.foundation.entity.c> d(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            String str2 = "SELECT request_id as rid ,count(*) as ridCount ,vcn,token_r,bid_token,local_request_id,ts as timestamp FROM campaign" + (" WHERE unitid = ? AND level = 0 AND adSource = 1 AND is_bid_campaign = 1 AND readyState = '0' group by request_id order by ts ASC");
            String[] strArr = {str};
            Cursor cursor = null;
            try {
                try {
                    synchronized (new Object()) {
                        cursor = getReadableDatabase().rawQuery(str2, strArr);
                    }
                    if (cursor != null && cursor.getCount() > 0) {
                        while (cursor.moveToNext()) {
                            com.mbridge.msdk.foundation.entity.c cVar = new com.mbridge.msdk.foundation.entity.c();
                            String string = cursor.getString(cursor.getColumnIndex("rid"));
                            if (!TextUtils.isEmpty(string)) {
                                String string2 = cursor.getString(cursor.getColumnIndex("local_request_id"));
                                String string3 = cursor.getString(cursor.getColumnIndex("bid_token"));
                                int i = cursor.getInt(cursor.getColumnIndex("ridCount"));
                                int i2 = cursor.getInt(cursor.getColumnIndex("token_r"));
                                long j = cursor.getLong(cursor.getColumnIndex("timestamp"));
                                int i3 = cursor.getInt(cursor.getColumnIndex("vcn"));
                                cVar.a(string);
                                cVar.a(i);
                                cVar.c(j);
                                cVar.b(i2);
                                cVar.c(i3);
                                cVar.c(string2);
                                if (!TextUtils.isEmpty(string3)) {
                                    cVar.b(string3);
                                }
                                arrayList.add(cVar);
                            }
                        }
                    }
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("CampaignDao", e.getLocalizedMessage());
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
        return arrayList;
    }

    public synchronized void a(String str, int i, int i2, boolean z) {
        String[] strArr;
        try {
            strArr = new String[]{str, String.valueOf(i), String.valueOf(i2), String.valueOf(z ? 1 : 0)};
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("campaign", "unitid = ? AND level = ? AND adSource = ?  AND is_bid_campaign = ? ", strArr);
    }

    public synchronized void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] strArr = {str};
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("campaign", "unitid = ? AND readyState = 2", strArr);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a5, code lost:
    
        if (r2 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c0, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bd, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bb, code lost:
    
        if (0 != 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> f(String str) {
        String[] strArr = {str};
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> concurrentHashMap = new ConcurrentHashMap<>();
        Cursor cursor = null;
        try {
            try {
                synchronized (new Object()) {
                    cursor = getReadableDatabase().rawQuery("SELECT request_id as rid, id as cid, plct as plct, plctb as plctb, ts as timestamp FROM campaign WHERE unitid = ? AND level = 0 AND adSource = 1 AND is_bid_campaign = 1 AND readyState = '0'", strArr);
                }
                if (cursor != null && cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(cursor.getColumnIndex("rid"));
                        String string2 = cursor.getString(cursor.getColumnIndex("cid"));
                        long j = cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCT));
                        long j2 = cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCTB));
                        long j3 = cursor.getLong(cursor.getColumnIndex("timestamp"));
                        if (concurrentHashMap.containsKey(string)) {
                            com.mbridge.msdk.foundation.entity.c cVar = concurrentHashMap.get(string);
                            if (cVar != null) {
                                cVar.a(string);
                                cVar.a(j);
                                cVar.b(j2);
                                cVar.c(j3);
                                if (cVar.c() != null) {
                                    cVar.c().add(string2);
                                }
                            }
                        } else {
                            com.mbridge.msdk.foundation.entity.c cVar2 = new com.mbridge.msdk.foundation.entity.c();
                            cVar2.a(string);
                            cVar2.a(j);
                            cVar2.b(j2);
                            cVar2.c(j3);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(string2);
                            cVar2.a(arrayList);
                            concurrentHashMap.put(string, cVar2);
                        }
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("CampaignDao", e.getLocalizedMessage());
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public synchronized void a(String str, List<CampaignEx> list) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("readyState", (Integer) 2);
                    String str2 = "id = ? AND unitid = ? AND request_id = ?  AND is_bid_campaign = ? ";
                    String[] strArr = new String[4];
                    strArr[0] = campaignEx.getId();
                    strArr[1] = str;
                    strArr[2] = campaignEx.getRequestId();
                    strArr[3] = campaignEx.isBidCampaign() ? "1" : "0";
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, str2, strArr);
                        }
                    } catch (SQLException e) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("CampaignDao", e.getLocalizedMessage());
                        }
                    }
                }
            }
        }
    }

    public synchronized void b(List<CampaignEx> list, String str) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("unitid").append(" = ? AND ").append("id").append(" = ? AND ").append("request_id").append(" = ? ");
                        String[] strArr = {str, campaignEx.getId(), campaignEx.getRequestId()};
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", (Integer) 2);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, sb.toString(), strArr);
                        }
                    } catch (SQLException e) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("CampaignDao", e.getLocalizedMessage());
                        }
                    }
                }
            }
        }
    }

    public synchronized void c(String str, String str2) {
        try {
        } catch (Exception e) {
            p0.b("CampaignDao", e.getLocalizedMessage());
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String str3 = "";
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            str3 = "unitid = ? AND ";
            arrayList.add(str);
        }
        String concat = str3.concat("n_local_request_id = ? AND bid_token IS NOT NULL AND n_local_request_id IS NOT NULL");
        arrayList.add(str2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("readyState", (Integer) 2);
        getWritableDatabase().update("campaign", contentValues, concat, (String[]) arrayList.toArray(new String[0]));
    }

    public synchronized void a(String str, CampaignEx campaignEx, boolean z, String str2) {
        try {
            StringBuilder sb = new StringBuilder();
            if (campaignEx == null && !TextUtils.isEmpty(str2)) {
                sb.append("unitid").append(" = ? AND ").append("request_id").append(" = ?");
            } else if (campaignEx != null && campaignEx.getLoadTimeoutState() == 0) {
                sb.append("unitid").append(" = ? AND ").append("id").append(" = ? AND ").append("request_id").append(" = ?");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            if (campaignEx != null && campaignEx.getLoadTimeoutState() == 0) {
                arrayList.add(String.valueOf(campaignEx.getId()));
                arrayList.add(campaignEx.getRequestId());
            } else {
                arrayList.add(str2);
            }
            if (!TextUtils.isEmpty(sb)) {
                if (r0.a().a("c_n_c_s", true)) {
                    sb.append(" AND readyState").append(" != 0");
                }
                if (z) {
                    sb.append(" AND is_bid_campaign = 1");
                } else {
                    sb.append(" AND is_bid_campaign = 0");
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("readyState", (Integer) 2);
                SQLiteDatabase writableDatabase = getWritableDatabase();
                String[] strArr = (String[]) arrayList.toArray(new String[0]);
                if (writableDatabase != null) {
                    writableDatabase.update("campaign", contentValues, sb.toString(), strArr);
                }
            }
        } catch (SQLException e) {
            p0.b("CampaignDao", e.getLocalizedMessage());
        }
    }

    public synchronized void b(long j, String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = "(plctb>0 and (plctb* 1000+ts)< " + currentTimeMillis + " ) or (plctb<=0 and ts< " + (currentTimeMillis - j) + " ) and unitid=?";
            String[] strArr = {str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", str2, strArr);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
        }
    }

    public synchronized List<CampaignEx> b(String str, int i, int i2, int i3) {
        ArrayList arrayList;
        String str2;
        arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(String.valueOf(i2));
        arrayList.add(String.valueOf(i3));
        str2 = "";
        if (i > 0) {
            str2 = " LIMIT ?";
            arrayList.add(String.valueOf(i));
        }
        return a("SELECT * FROM campaign WHERE unitid = ? AND level = ? AND adSource = ?".concat(str2), (String[]) arrayList.toArray(new String[0]));
    }

    public synchronized void a(String str, List<CampaignEx> list, boolean z) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    a(str, campaignEx, z, campaignEx.getRequestId());
                }
            }
        }
    }

    public synchronized void a(String str, List<CampaignEx> list, String str2, int i) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && !TextUtils.isEmpty(str2)) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            try {
                for (CampaignEx campaignEx : list) {
                    if (campaignEx != null) {
                        String[] strArr = {str, campaignEx.getId(), campaignEx.getRequestId()};
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(str2, Integer.valueOf(i));
                        writableDatabase.update("campaign", contentValues, "unitid = ? AND id = ? AND request_id = ? ", strArr);
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("CampaignDao", e.getLocalizedMessage());
                }
            }
        }
    }

    public synchronized void b(String str, String str2) {
        try {
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = "unitid = ?";
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (!TextUtils.isEmpty(str2)) {
            str3 = "unitid = ? AND bid_token != ?";
            arrayList.add(str2);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("readyState", (Integer) 2);
        getWritableDatabase().update("campaign", contentValues, (str3 + " AND is_bid_campaign = 1") + " AND bid_token IS NOT NULL", (String[]) arrayList.toArray(new String[0]));
    }

    public synchronized void a(String str, List<CampaignEx> list, List<CampaignEx> list2, boolean z) {
        if (getWritableDatabase() == null) {
            return;
        }
        try {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        for (CampaignEx campaignEx : list) {
                            try {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("readyState", (Integer) 0);
                                getWritableDatabase().update("campaign", contentValues, z ? "unitid = ? AND id = ? AND request_id = ?  AND is_bid_campaign = 1" : "unitid = ? AND id = ? AND request_id = ?  AND is_bid_campaign = 0", new String[]{str, campaignEx.getId(), campaignEx.getRequestId()});
                            } catch (Exception e) {
                                if (MBridgeConstans.DEBUG) {
                                    p0.b("CampaignDao", e.getLocalizedMessage());
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("CampaignDao", e2.getLocalizedMessage());
                    }
                }
            }
            if (list2 != null && list2.size() > 0) {
                for (CampaignEx campaignEx2 : list2) {
                    try {
                        if (campaignEx2.getLoadTimeoutState() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("unitid").append(" = ? AND ").append("id").append(" = ? AND ").append("request_id").append(" = ? ");
                            String[] strArr = {str, campaignEx2.getId(), campaignEx2.getRequestId()};
                            if (z) {
                                sb.append(" AND is_bid_campaign = 1");
                            } else {
                                sb.append(" AND is_bid_campaign = 0");
                            }
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("readyState", (Integer) 2);
                            getWritableDatabase().update("campaign", contentValues2, sb.toString(), strArr);
                        }
                    } catch (SQLException e3) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("CampaignDao", e3.getLocalizedMessage());
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<CampaignEx> b(String str, int i, boolean z) {
        Cursor cursor;
        ArrayList arrayList;
        Exception e;
        Cursor cursor2;
        String str2;
        String[] strArr;
        Cursor cursor3 = null;
        r3 = null;
        ArrayList arrayList2 = null;
        try {
            try {
                if (z) {
                    str2 = "placement_id = ? AND ad_type = ? ";
                    strArr = new String[]{str, String.valueOf(i)};
                } else {
                    str2 = "ad_type = ? ";
                    strArr = new String[]{String.valueOf(i)};
                }
                cursor2 = getReadableDatabase().rawQuery("SELECT * FROM campaign WHERE ".concat(str2), strArr);
                if (cursor2 != null) {
                    try {
                        try {
                            if (cursor2.getCount() > 0) {
                                arrayList = new ArrayList();
                                while (cursor2.moveToNext()) {
                                    try {
                                        arrayList.add(a(cursor2));
                                    } catch (Exception e2) {
                                        e = e2;
                                        cursor3 = cursor2;
                                        p0.b("CampaignDao", e.getLocalizedMessage());
                                        if (cursor3 != null) {
                                        }
                                    }
                                }
                                arrayList2 = arrayList;
                            }
                        } catch (Exception e3) {
                            cursor = cursor2;
                            e = e3;
                            cursor3 = cursor;
                            arrayList = null;
                            e = e;
                            p0.b("CampaignDao", e.getLocalizedMessage());
                            if (cursor3 != null) {
                                return arrayList;
                            }
                            cursor2 = cursor3;
                            arrayList2 = arrayList;
                            cursor2.close();
                            return arrayList2;
                        }
                    } catch (Throwable th) {
                        cursor3 = cursor2;
                        th = th;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        throw th;
                    }
                }
                if (cursor2 == null) {
                    return arrayList2;
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            }
            cursor2.close();
            return arrayList2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public synchronized void a(String str, List<CampaignEx> list, String str2) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx campaignEx : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("local_request_id", str2);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update("campaign", contentValues, "unitid = ? AND id = ? AND request_id = ? ", new String[]{str, campaignEx.getId(), campaignEx.getRequestId()});
                        }
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("CampaignDao", e.getLocalizedMessage());
                        }
                    }
                }
            }
        }
    }

    public synchronized void a(String str, String str2, boolean z, String str3) {
        String[] strArr;
        try {
            strArr = new String[4];
            strArr[0] = str;
            strArr[1] = str2;
            strArr[2] = z ? "1" : "0";
            strArr[3] = str3;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("readyState", (Integer) 2);
        getWritableDatabase().update("campaign", contentValues, "id = ? AND unitid = ? AND is_bid_campaign = ? AND request_id = ? ", strArr);
    }

    public synchronized void a(String str, String str2, String str3) {
        try {
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("campaign", "unitid = ? AND (local_request_id = ?  OR local_request_id = ? )", new String[]{str, str2, str3});
    }

    public synchronized void a(String str, String str2, int i, int i2, boolean z) {
        String[] strArr;
        String str3;
        try {
            strArr = new String[]{str, str2, String.valueOf(i), String.valueOf(i2)};
            if (z) {
                str3 = "id = ? AND unitid = ? AND level = ? AND adSource = ?  AND is_bid_campaign = 1";
            } else {
                str3 = "id = ? AND unitid = ? AND level = ? AND adSource = ?  AND is_bid_campaign = 0";
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("campaign", str3, strArr);
    }

    public synchronized void a(String str) {
        String[] strArr;
        try {
            strArr = new String[]{str};
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("campaign", "unitid = ? ", strArr);
    }

    public synchronized void a(String str, int i, boolean z) {
        String str2;
        String[] strArr;
        try {
            if (z) {
                str2 = "placement_id = ? AND ad_type = ? ";
                strArr = new String[]{str, String.valueOf(i)};
            } else {
                str2 = "ad_type = " + i;
                strArr = new String[]{String.valueOf(i)};
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("campaign", str2, strArr);
    }

    public synchronized void a() {
        try {
            String[] strArr = {String.valueOf(System.currentTimeMillis() - 3600000)};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", "ts< ? AND ts>0", strArr);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
        }
    }

    public synchronized void a(long j, String str) {
        try {
            String[] strArr = {String.valueOf(System.currentTimeMillis() - j), str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("campaign", "ts< ? and unitid= ? ", strArr);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
        }
    }

    public synchronized void a(List<CampaignEx> list, String str, String str2, int i) {
        if (list != null) {
            if (list.size() != 0) {
                if (getWritableDatabase() == null) {
                    return;
                }
                Iterator<CampaignEx> it = list.iterator();
                while (it.hasNext()) {
                    a(it.next(), str, str2, i);
                }
            }
        }
    }

    public synchronized long a(CampaignEx campaignEx, String str, String str2, int i) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1L;
            }
            ContentValues contentValues = new ContentValues();
            if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = campaignEx.getPv_urls().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                contentValues.put("pv_urls", jSONArray.toString());
            }
            contentValues.put("id", campaignEx.getId());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            contentValues.put(AndroidBridgeConstants.PLACEMENT_ID, str);
            contentValues.put("unitid", str2);
            contentValues.put("tab", Integer.valueOf(campaignEx.getTab()));
            contentValues.put("package_name", campaignEx.getPackageName());
            contentValues.put("app_name", campaignEx.getAppName());
            contentValues.put("app_desc", campaignEx.getAppDesc());
            contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
            contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
            contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
            contentValues.put(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
            contentValues.put("deeplink_url", campaignEx.getDeepLinkURL());
            contentValues.put(CampaignEx.JSON_KEY_USER_ACTIVATION, Boolean.toString(campaignEx.getUserActivation()));
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I, campaignEx.getNetAddress());
            contentValues.put(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH, Integer.valueOf(campaignEx.getAc_s()));
            contentValues.put(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, campaignEx.getAc());
            contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
            contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
            contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
            contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
            contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
            contentValues.put("star", Double.valueOf(campaignEx.getRating()));
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
            contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
            contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
            contentValues.put("ad_call", campaignEx.getAdCall());
            contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
            contentValues.put("fc_b", Integer.valueOf(campaignEx.getFcb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put("video_url", campaignEx.getVideoUrlEncode());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Integer.valueOf(campaignEx.getVideoSize()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, Integer.valueOf(campaignEx.getVideoLength()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
            contentValues.put(CampaignEx.JSON_KEY_ENDCARD_CLICK, Integer.valueOf(campaignEx.getEndcard_click_result()));
            contentValues.put(CampaignEx.JSON_KEY_WATCH_MILE, Integer.valueOf(campaignEx.getWatchMile()));
            contentValues.put("advImp", campaignEx.getAdvImp());
            contentValues.put("bty", Integer.valueOf(campaignEx.getBty()));
            contentValues.put(CampaignEx.JSON_KEY_T_IMP, Integer.valueOf(campaignEx.getTImp()));
            contentValues.put(CampaignEx.JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
            contentValues.put(CampaignEx.JSON_KEY_OFFER_TYPE, Integer.valueOf(campaignEx.getOfferType()));
            contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
            contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
            contentValues.put("reward_amount", Integer.valueOf(campaignEx.getRewardAmount()));
            contentValues.put("reward_name", campaignEx.getRewardName());
            contentValues.put("reward_play_status", Integer.valueOf(campaignEx.getRewardPlayStatus()));
            contentValues.put("retarget", Integer.valueOf(campaignEx.getRetarget_offer()));
            contentValues.put("native_ad_tracking", campaignEx.getNativeVideoTrackingString());
            contentValues.put(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO, Integer.valueOf(campaignEx.getPlayable_ads_without_video()));
            contentValues.put(CampaignEx.ENDCARD_URL, campaignEx.getendcard_url());
            contentValues.put(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
            contentValues.put(CampaignEx.JSON_KEY_NV_T2, Integer.valueOf(campaignEx.getNvT2()));
            contentValues.put(CampaignEx.JSON_KEY_GIF_URL, campaignEx.getGifUrl());
            if (campaignEx.getRewardTemplateMode() != null) {
                contentValues.put("reward_teamplate", campaignEx.getRewardTemplateMode().d());
            }
            contentValues.put("c_coi", Integer.valueOf(campaignEx.getClickTimeOutInterval()));
            contentValues.put(CampaignEx.JSON_KEY_C_UA, Integer.valueOf(campaignEx.getcUA()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_UA, Integer.valueOf(campaignEx.getImpUA()));
            contentValues.put(CampaignEx.JSON_KEY_JM_PD, Integer.valueOf(campaignEx.getJmPd()));
            contentValues.put("is_deleted", Integer.valueOf(campaignEx.getIsDeleted()));
            contentValues.put("is_click", Integer.valueOf(campaignEx.getIsClick()));
            contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
            contentValues.put("short_ctime", String.valueOf(System.currentTimeMillis()));
            contentValues.put("ia_icon", campaignEx.getKeyIaIcon());
            contentValues.put("ia_url", campaignEx.getKeyIaUrl());
            contentValues.put("ia_rst", Integer.valueOf(campaignEx.getKeyIaRst()));
            contentValues.put("ia_ori", Integer.valueOf(campaignEx.getKeyIaOri()));
            contentValues.put("ad_type", Integer.valueOf(campaignEx.getAdType()));
            contentValues.put(CampaignEx.KEY_IA_EXT1, campaignEx.getIa_ext1());
            contentValues.put(CampaignEx.KEY_IA_EXT2, campaignEx.getIa_ext2());
            contentValues.put(CampaignEx.KEY_IS_DOWNLOAD, Integer.valueOf(campaignEx.getIsDownLoadZip()));
            contentValues.put(CampaignEx.KEY_IA_CACHE, campaignEx.getInteractiveCache());
            contentValues.put(CampaignEx.KEY_OC_TIME, Integer.valueOf(campaignEx.getOc_time()));
            contentValues.put(CampaignEx.KEY_OC_TYPE, Integer.valueOf(campaignEx.getOc_type()));
            contentValues.put(CampaignEx.KEY_T_LIST, campaignEx.getT_list());
            CampaignEx.a adchoice = campaignEx.getAdchoice();
            if (adchoice != null) {
                contentValues.put(CampaignEx.KEY_ADCHOICE, adchoice.a());
                contentValues.put("adchoice_size_height", Integer.valueOf(adchoice.e()));
                contentValues.put("adchoice_size_width", Integer.valueOf(adchoice.f()));
            }
            contentValues.put(CampaignEx.JSON_KEY_PLCT, Long.valueOf(campaignEx.getPlct()));
            contentValues.put(CampaignEx.JSON_KEY_PLCTB, Long.valueOf(campaignEx.getPlctb()));
            contentValues.put(CampaignEx.JSON_KEY_C_C_TIME, Long.valueOf(campaignEx.getCandidateCacheTime()));
            contentValues.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getAdHtml());
            contentValues.put("ad_zip", campaignEx.getAdZip());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_URL, campaignEx.getBannerUrl());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_HTML, campaignEx.getBannerHtml());
            contentValues.put(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(campaignEx.getCreativeId()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID, Long.valueOf(campaignEx.getVidCrtvId()));
            contentValues.put(CampaignEx.JSON_KEY_EC_CREATIVE_ID, Long.valueOf(campaignEx.getEcCrtvId()));
            contentValues.put(CampaignEx.JSON_KEY_EC_TEMP_ID, Long.valueOf(campaignEx.getEcTemplateId()));
            contentValues.put("is_bid_campaign", Boolean.valueOf(campaignEx.isBidCampaign()));
            contentValues.put("bid_token", campaignEx.getBidToken());
            contentValues.put("mraid", campaignEx.getMraid());
            contentValues.put("is_mraid_campaign", Boolean.valueOf(campaignEx.isMraid()));
            contentValues.put(CampaignEx.KEY_OMID, campaignEx.getOmid());
            contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TPLID, Integer.valueOf(campaignEx.getMof_tplid()));
            contentValues.put(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(campaignEx.getReady_rate()));
            contentValues.put(CampaignEx.JSON_KEY_EXT_DATA, campaignEx.getExt_data());
            contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_NSCPT, Integer.valueOf(campaignEx.getNscpt()));
            contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_REQ_EXT_DATA, campaignEx.getReq_ext_data());
            contentValues.put("readyState", Integer.valueOf(campaignEx.getReadyState()));
            contentValues.put("request_id", campaignEx.getRequestId());
            contentValues.put("n_request_id", campaignEx.getNRid());
            contentValues.put("local_request_id", campaignEx.getLocalRequestId());
            contentValues.put("n_local_request_id", campaignEx.getNLRid());
            contentValues.put("err_type_default_ad", Integer.valueOf(campaignEx.getTyped()));
            contentValues.put("err_reason_default_ad", campaignEx.getReasond());
            contentValues.put("load_timeout", Integer.valueOf(campaignEx.getLoadTimeoutState()));
            contentValues.put(CampaignEx.JSON_KEY_MAITVE, Integer.valueOf(campaignEx.getMaitve()));
            contentValues.put(CampaignEx.JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
            contentValues.put(CampaignEx.JSON_KEY_FLB, Integer.valueOf(campaignEx.getFlb()));
            contentValues.put(CampaignEx.JSON_KEY_FLB_SKIP_TIME, Integer.valueOf(campaignEx.getFlbSkipTime()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD, Integer.valueOf(campaignEx.getCbd()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, Integer.valueOf(campaignEx.getVst()));
            contentValues.put(CampaignEx.JSON_KEY_USE_SKIP_TIME, Integer.valueOf(campaignEx.getUseSkipTime()));
            contentValues.put(CampaignEx.JSON_KEY_PROG_BAR, Integer.valueOf(campaignEx.getProgressBarShow()));
            contentValues.put("vcn", Integer.valueOf(campaignEx.getVcn()));
            contentValues.put("token_r", Integer.valueOf(campaignEx.getTokenRule()));
            contentValues.put("encrypt_p", campaignEx.getEncryptPrice());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE, Integer.valueOf(campaignEx.getVideoCheckType()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE, Integer.valueOf(campaignEx.getVideoCtnType()));
            contentValues.put(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRuleString());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME, Integer.valueOf(campaignEx.getVideoCompleteTime()));
            contentValues.put(CampaignEx.JSON_KEY_TP_OFFER, Integer.valueOf(campaignEx.getTpOffer()));
            contentValues.put(CampaignEx.JSON_KEY_FAC, Integer.valueOf(campaignEx.getFac()));
            if (campaignEx.getAabEntity() != null) {
                contentValues.put(CampaignEx.JSON_KEY_AAB, campaignEx.getAabEntity().toJson().toString());
            }
            contentValues.put(CampaignEx.JSON_KEY_PRIVACY_URL, campaignEx.getPrivacyUrl());
            contentValues.put("privacy_button_video", Integer.valueOf(campaignEx.getPrivacyButtonTemplateVisibility()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_REPORT_TYPE, Integer.valueOf(campaignEx.getImpReportType()));
            contentValues.put("auto_minicard", Integer.valueOf(campaignEx.getAutoShowStoreMiniCard()));
            contentValues.put("mincard_trigger_time", Integer.valueOf(campaignEx.getShowStoreMiniCardDelayTime()));
            contentValues.put(CampaignEx.KEY_SECOND_FILTER_AD_SHOW_CALL_STATE, Integer.valueOf(campaignEx.getFilterAdsShowCallState()));
            contentValues.put(CampaignEx.KEY_SECOND_FILTER_AD_VIDEO_CALL_STATE, Integer.valueOf(campaignEx.getFilterAdsVideoCallState()));
            contentValues.put(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(campaignEx.getFilterCallBackState()));
            contentValues.put("r_index", Integer.valueOf(campaignEx.getSecondRequestIndex()));
            contentValues.put("s_show_index", Integer.valueOf(campaignEx.getSecondShowIndex()));
            contentValues.put(CampaignEx.KEY_LOCAL_CHECK_STATE, Integer.valueOf(campaignEx.getLocalCheckShow()));
            contentValues.put(CampaignEx.KEY_LOCAL_ALLOW_TRACK_CLICK, Integer.valueOf(campaignEx.getLocalAllowTrackClick()));
            return getWritableDatabase().insert("campaign", null, contentValues);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
            return -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0722 A[Catch: all -> 0x072d, TRY_LEAVE, TryCatch #5 {all -> 0x072d, blocks: (B:38:0x06d7, B:40:0x06dd, B:42:0x06e5, B:43:0x06fb, B:47:0x06ec, B:48:0x0708, B:26:0x071e, B:28:0x0722, B:33:0x072f), top: B:7:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized long a(CampaignEx campaignEx, String str, int i) {
        Throwable th;
        Exception exc;
        String str2;
        String[] strArr;
        if (campaignEx == null) {
            return 0L;
        }
        try {
            try {
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", campaignEx.getId());
                if (campaignEx.getPv_urls() != null) {
                    try {
                        if (campaignEx.getPv_urls().size() > 0) {
                            JSONArray jSONArray = new JSONArray();
                            Iterator<String> it = campaignEx.getPv_urls().iterator();
                            while (it.hasNext()) {
                                jSONArray.put(it.next());
                            }
                            contentValues.put("pv_urls", jSONArray.toString());
                        }
                    } catch (Exception e) {
                        exc = e;
                        if (MBridgeConstans.DEBUG) {
                        }
                        return -1L;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                contentValues.put("unitid", str);
                contentValues.put("request_id", campaignEx.getRequestId());
                contentValues.put("n_request_id", campaignEx.getNRid());
                contentValues.put("local_request_id", campaignEx.getLocalRequestId());
                contentValues.put("n_local_request_id", campaignEx.getNLRid());
                contentValues.put("err_type_default_ad", Integer.valueOf(campaignEx.getTyped()));
                contentValues.put("err_reason_default_ad", campaignEx.getReasond());
                contentValues.put("tab", Integer.valueOf(campaignEx.getTab()));
                contentValues.put("package_name", campaignEx.getPackageName());
                contentValues.put("app_name", campaignEx.getAppName());
                contentValues.put("app_desc", campaignEx.getAppDesc());
                contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
                contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
                contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
                contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
                contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
                contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
                contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
                contentValues.put(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
                contentValues.put("deeplink_url", campaignEx.getDeepLinkURL());
                contentValues.put(CampaignEx.JSON_KEY_USER_ACTIVATION, Boolean.toString(campaignEx.getUserActivation()));
                contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I, campaignEx.getNetAddress());
                contentValues.put(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH, Integer.valueOf(campaignEx.getAc_s()));
                contentValues.put(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, campaignEx.getAc());
                contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
                contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
                contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
                contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
                contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
                contentValues.put("star", Double.valueOf(campaignEx.getRating()));
                contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
                contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
                contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
                contentValues.put("ad_call", campaignEx.getAdCall());
                contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
                contentValues.put("fc_b", Integer.valueOf(campaignEx.getFcb()));
                contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
                contentValues.put("video_url", campaignEx.getVideoUrlEncode());
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Integer.valueOf(campaignEx.getVideoSize()));
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, Integer.valueOf(campaignEx.getVideoLength()));
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
                contentValues.put(CampaignEx.JSON_KEY_ENDCARD_CLICK, Integer.valueOf(campaignEx.getEndcard_click_result()));
                contentValues.put(CampaignEx.JSON_KEY_WATCH_MILE, Integer.valueOf(campaignEx.getWatchMile()));
                contentValues.put("advImp", campaignEx.getAdvImp());
                contentValues.put("bty", Integer.valueOf(campaignEx.getBty()));
                contentValues.put(CampaignEx.JSON_KEY_T_IMP, Integer.valueOf(campaignEx.getTImp()));
                contentValues.put(CampaignEx.JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
                contentValues.put(CampaignEx.JSON_KEY_OFFER_TYPE, Integer.valueOf(campaignEx.getOfferType()));
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
                contentValues.put("reward_amount", Integer.valueOf(campaignEx.getRewardAmount()));
                contentValues.put("reward_name", campaignEx.getRewardName());
                contentValues.put("reward_play_status", Integer.valueOf(campaignEx.getRewardPlayStatus()));
                contentValues.put("retarget", Integer.valueOf(campaignEx.getRetarget_offer()));
                contentValues.put("native_ad_tracking", campaignEx.getNativeVideoTrackingString());
                contentValues.put(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO, Integer.valueOf(campaignEx.getPlayable_ads_without_video()));
                contentValues.put(CampaignEx.ENDCARD_URL, campaignEx.getendcard_url());
                contentValues.put(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
                contentValues.put(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
                contentValues.put(CampaignEx.JSON_KEY_NV_T2, Integer.valueOf(campaignEx.getNvT2()));
                contentValues.put(CampaignEx.JSON_KEY_GIF_URL, campaignEx.getGifUrl());
                if (campaignEx.getRewardTemplateMode() != null) {
                    contentValues.put("reward_teamplate", campaignEx.getRewardTemplateMode().d());
                }
                contentValues.put("c_coi", Integer.valueOf(campaignEx.getClickTimeOutInterval()));
                contentValues.put(CampaignEx.JSON_KEY_C_UA, Integer.valueOf(campaignEx.getcUA()));
                contentValues.put(CampaignEx.JSON_KEY_IMP_UA, Integer.valueOf(campaignEx.getImpUA()));
                contentValues.put(CampaignEx.JSON_KEY_JM_PD, Integer.valueOf(campaignEx.getJmPd()));
                contentValues.put("is_deleted", Integer.valueOf(campaignEx.getIsDeleted()));
                contentValues.put("is_click", Integer.valueOf(campaignEx.getIsClick()));
                contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
                contentValues.put("short_ctime", String.valueOf(System.currentTimeMillis()));
                contentValues.put("ia_icon", campaignEx.getKeyIaIcon());
                contentValues.put("ia_url", campaignEx.getKeyIaUrl());
                contentValues.put("ia_rst", Integer.valueOf(campaignEx.getKeyIaRst()));
                contentValues.put("ia_ori", Integer.valueOf(campaignEx.getKeyIaOri()));
                contentValues.put("ad_type", Integer.valueOf(campaignEx.getAdType()));
                contentValues.put(CampaignEx.KEY_IA_EXT1, campaignEx.getIa_ext1());
                contentValues.put(CampaignEx.KEY_IA_EXT2, campaignEx.getIa_ext2());
                contentValues.put(CampaignEx.KEY_IS_DOWNLOAD, Integer.valueOf(campaignEx.getIsDownLoadZip()));
                contentValues.put(CampaignEx.KEY_IA_CACHE, campaignEx.getInteractiveCache());
                contentValues.put(CampaignEx.KEY_OC_TIME, Integer.valueOf(campaignEx.getOc_time()));
                contentValues.put(CampaignEx.KEY_OC_TYPE, Integer.valueOf(campaignEx.getOc_type()));
                contentValues.put(CampaignEx.KEY_T_LIST, campaignEx.getT_list());
                CampaignEx.a adchoice = campaignEx.getAdchoice();
                if (adchoice != null) {
                    contentValues.put(CampaignEx.KEY_ADCHOICE, adchoice.a());
                    contentValues.put("adchoice_size_height", Integer.valueOf(adchoice.e()));
                    contentValues.put("adchoice_size_width", Integer.valueOf(adchoice.f()));
                }
                contentValues.put(CampaignEx.JSON_KEY_PLCT, Long.valueOf(campaignEx.getPlct()));
                contentValues.put(CampaignEx.JSON_KEY_PLCTB, Long.valueOf(campaignEx.getPlctb()));
                contentValues.put(CampaignEx.JSON_KEY_C_C_TIME, Long.valueOf(campaignEx.getCandidateCacheTime()));
                contentValues.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getAdHtml());
                contentValues.put("ad_zip", campaignEx.getAdZip());
                contentValues.put(CampaignEx.JSON_KEY_BANNER_URL, campaignEx.getBannerUrl());
                contentValues.put(CampaignEx.JSON_KEY_BANNER_HTML, campaignEx.getBannerHtml());
                contentValues.put(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(campaignEx.getCreativeId()));
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID, Long.valueOf(campaignEx.getVidCrtvId()));
                contentValues.put(CampaignEx.JSON_KEY_EC_CREATIVE_ID, Long.valueOf(campaignEx.getEcCrtvId()));
                contentValues.put(CampaignEx.JSON_KEY_EC_TEMP_ID, Long.valueOf(campaignEx.getEcTemplateId()));
                contentValues.put("is_bid_campaign", Boolean.valueOf(campaignEx.isBidCampaign()));
                contentValues.put("bid_token", campaignEx.getBidToken());
                contentValues.put("mraid", campaignEx.getMraid());
                contentValues.put("is_mraid_campaign", Boolean.valueOf(campaignEx.isMraid()));
                contentValues.put(CampaignEx.KEY_OMID, campaignEx.getOmid());
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TPLID, Integer.valueOf(campaignEx.getMof_tplid()));
                contentValues.put(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(campaignEx.getReady_rate()));
                contentValues.put(CampaignEx.JSON_KEY_EXT_DATA, campaignEx.getExt_data());
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_NSCPT, Integer.valueOf(campaignEx.getNscpt()));
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
                contentValues.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_REQ_EXT_DATA, campaignEx.getReq_ext_data());
                contentValues.put("readyState", Integer.valueOf(campaignEx.getReadyState()));
                contentValues.put("load_timeout", Integer.valueOf(campaignEx.getLoadTimeoutState()));
                contentValues.put(AndroidBridgeConstants.PLACEMENT_ID, campaignEx.getPlacementId());
                contentValues.put(CampaignEx.JSON_KEY_MAITVE, Integer.valueOf(campaignEx.getMaitve()));
                contentValues.put(CampaignEx.JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
                contentValues.put(CampaignEx.JSON_KEY_FLB, Integer.valueOf(campaignEx.getFlb()));
                contentValues.put(CampaignEx.JSON_KEY_FLB_SKIP_TIME, Integer.valueOf(campaignEx.getFlbSkipTime()));
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD, Integer.valueOf(campaignEx.getCbd()));
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, Integer.valueOf(campaignEx.getVst()));
                contentValues.put(CampaignEx.JSON_KEY_USE_SKIP_TIME, Integer.valueOf(campaignEx.getUseSkipTime()));
                contentValues.put(CampaignEx.JSON_KEY_PROG_BAR, Integer.valueOf(campaignEx.getProgressBarShow()));
                contentValues.put("vcn", Integer.valueOf(campaignEx.getVcn()));
                contentValues.put("token_r", Integer.valueOf(campaignEx.getTokenRule()));
                contentValues.put("encrypt_p", campaignEx.getEncryptPrice());
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE, Integer.valueOf(campaignEx.getVideoCheckType()));
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE, Integer.valueOf(campaignEx.getVideoCtnType()));
                contentValues.put(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRuleString());
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME, Integer.valueOf(campaignEx.getVideoCompleteTime()));
                contentValues.put(CampaignEx.JSON_KEY_TP_OFFER, Integer.valueOf(campaignEx.getTpOffer()));
                contentValues.put(CampaignEx.JSON_KEY_FAC, Integer.valueOf(campaignEx.getFac()));
                contentValues.put(CampaignEx.JSON_KEY_PRIVACY_URL, campaignEx.getPrivacyUrl());
                contentValues.put("privacy_button_video", Integer.valueOf(campaignEx.getPrivacyButtonTemplateVisibility()));
                contentValues.put(CampaignEx.JSON_KEY_IMP_REPORT_TYPE, Integer.valueOf(campaignEx.getImpReportType()));
                if (campaignEx.getAabEntity() != null) {
                    contentValues.put(CampaignEx.JSON_KEY_AAB, campaignEx.getAabEntity().toJson().toString());
                }
                contentValues.put("auto_minicard", Integer.valueOf(campaignEx.getAutoShowStoreMiniCard()));
                contentValues.put("mincard_trigger_time", Integer.valueOf(campaignEx.getShowStoreMiniCardDelayTime()));
                contentValues.put(CampaignEx.KEY_SECOND_FILTER_AD_SHOW_CALL_STATE, Integer.valueOf(campaignEx.getFilterAdsShowCallState()));
                contentValues.put(CampaignEx.KEY_SECOND_FILTER_AD_VIDEO_CALL_STATE, Integer.valueOf(campaignEx.getFilterAdsVideoCallState()));
                contentValues.put(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(campaignEx.getFilterCallBackState()));
                contentValues.put("r_index", Integer.valueOf(campaignEx.getSecondRequestIndex()));
                contentValues.put("s_show_index", Integer.valueOf(campaignEx.getSecondShowIndex()));
                contentValues.put(CampaignEx.KEY_LOCAL_CHECK_STATE, Integer.valueOf(campaignEx.getLocalCheckShow()));
                contentValues.put(CampaignEx.KEY_LOCAL_ALLOW_TRACK_CLICK, Integer.valueOf(campaignEx.getLocalAllowTrackClick()));
                try {
                    if (a(campaignEx.getId(), campaignEx.getTab(), str, i, campaignEx.getType(), campaignEx.isBidCampaign())) {
                        if (campaignEx.isBidCampaign()) {
                            str2 = "unitid = ? AND is_bid_campaign = 1";
                            strArr = new String[]{str};
                        } else {
                            String[] strArr2 = {campaignEx.getId(), str};
                            str2 = "id = ? AND unitid = ? AND is_bid_campaign = 0";
                            strArr = strArr2;
                        }
                        return getWritableDatabase().update("campaign", contentValues, str2, strArr);
                    }
                    return getWritableDatabase().insert("campaign", null, contentValues);
                } catch (Exception e2) {
                    e = e2;
                    exc = e;
                    if (MBridgeConstans.DEBUG) {
                        p0.b("CampaignDao", exc.getLocalizedMessage());
                    }
                    return -1L;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public synchronized void a(List<CampaignEx> list, String str) {
        if (list != null) {
            if (list.size() != 0) {
                new Thread(new a(list, str)).start();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006d A[Catch: all -> 0x0078, TRY_LEAVE, TryCatch #2 {all -> 0x0078, blocks: (B:9:0x0035, B:11:0x003b, B:14:0x0042, B:15:0x0046, B:17:0x004c, B:32:0x0069, B:34:0x006d, B:45:0x007a), top: B:3:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int a(String str, long j) {
        Throwable th;
        Exception exc;
        try {
            try {
                com.mbridge.msdk.setting.g d = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                if (d == null) {
                    try {
                        d = com.mbridge.msdk.setting.h.b().a();
                    } catch (Exception e) {
                        exc = e;
                        if (MBridgeConstans.DEBUG) {
                        }
                        return 0;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                long a0 = d.a0() * 1000;
                b(a0, str);
                try {
                    List<CampaignEx> a2 = a(str, 0, 0, 1, false);
                    if (a2 != null && !a2.isEmpty()) {
                        Iterator<CampaignEx> it = a2.iterator();
                        while (it.hasNext()) {
                            if (!it.next().isSpareOffer(j, a0)) {
                                return 0;
                            }
                        }
                        return 1;
                    }
                    return -1;
                } catch (Exception e2) {
                    e = e2;
                    exc = e;
                    if (MBridgeConstans.DEBUG) {
                        p0.b("CampaignDao", exc.getLocalizedMessage());
                    }
                    return 0;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public synchronized boolean a(String str, int i, String str2, int i2, int i3, boolean z) {
        String str3;
        String[] strArr;
        if (z) {
            str3 = "SELECT id FROM campaign WHERE unitid = ? AND is_bid_campaign = 1";
            strArr = new String[]{str2};
        } else {
            String[] strArr2 = {str, String.valueOf(i), str2, String.valueOf(i2), String.valueOf(i3)};
            str3 = "SELECT id FROM campaign WHERE id= ? AND tab= ? AND unitid = ? AND level = ? AND adSource = ? AND is_bid_campaign = 0";
            strArr = strArr2;
        }
        Cursor rawQuery = getReadableDatabase().rawQuery(str3, strArr);
        if (rawQuery != null && rawQuery.getCount() > 0) {
            rawQuery.close();
            return true;
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return false;
    }

    public List<CampaignEx> a(String str, int i, int i2, int i3) {
        String str2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(String.valueOf(i2));
        arrayList.add(String.valueOf(i3));
        if (i <= 0) {
            str2 = "";
        } else {
            arrayList.add(String.valueOf(i));
            str2 = " LIMIT ?";
        }
        return a("SELECT * FROM campaign WHERE unitid = ? AND level = ? AND adSource = ?".concat(str2), (String[]) arrayList.toArray(new String[0]));
    }

    public synchronized List<CampaignEx> a(String str, int i, int i2, int i3, boolean z) {
        ArrayList arrayList;
        String str2;
        String str3;
        arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(String.valueOf(i2));
        arrayList.add(String.valueOf(i3));
        if (z) {
            str2 = " WHERE unitid = ? AND level = ? AND adSource = ? AND is_bid_campaign = 1";
        } else {
            str2 = " WHERE unitid = ? AND level = ? AND adSource = ? AND is_bid_campaign = 0";
        }
        str3 = "";
        if (i > 0) {
            str3 = " LIMIT ?";
            arrayList.add(String.valueOf(i));
        }
        return a("SELECT * FROM campaign" + str2 + str3, (String[]) arrayList.toArray(new String[0]));
    }

    public synchronized List<CampaignEx> a(String str, int i, int i2, int i3, String str2) {
        String str3;
        ArrayList arrayList;
        String str4;
        str3 = " WHERE unitid = ?  AND level = ?  AND adSource = ?  AND is_bid_campaign = 1 AND readyState = '0'";
        arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(String.valueOf(i2));
        arrayList.add(String.valueOf(i3));
        if (!TextUtils.isEmpty(str2)) {
            str3 = " WHERE unitid = ?  AND level = ?  AND adSource = ?  AND is_bid_campaign = 1 AND readyState = '0' AND request_id = ? ";
            arrayList.add(str2);
        }
        str4 = "";
        if (i > 0) {
            str4 = " LIMIT ?";
            arrayList.add(String.valueOf(i));
        }
        return a("SELECT * FROM campaign" + (str3 + " order by ts ASC") + str4, (String[]) arrayList.toArray(new String[0]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0764, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0762, code lost:
    
        if (r8 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x074e, code lost:
    
        if (r8 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0768, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x076d A[Catch: all -> 0x0771, TRY_ENTER, TryCatch #0 {, blocks: (B:39:0x0747, B:10:0x0764, B:52:0x076d, B:53:0x0770), top: B:3:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<CampaignEx> a(String str, String[] strArr) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            cursor = getReadableDatabase().rawQuery(str, strArr);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.getCount() > 0) {
                            ArrayList arrayList = new ArrayList();
                            while (cursor.moveToNext()) {
                                CampaignEx campaignEx = new CampaignEx();
                                String string = cursor.getString(cursor.getColumnIndex("pv_urls"));
                                boolean z = false;
                                if (!TextUtils.isEmpty(string)) {
                                    JSONArray jSONArray = new JSONArray(string);
                                    ArrayList arrayList2 = new ArrayList();
                                    for (int i = 0; i < jSONArray.length(); i++) {
                                        arrayList2.add(jSONArray.getString(i));
                                    }
                                    campaignEx.setPv_urls(arrayList2);
                                }
                                campaignEx.setId(cursor.getString(cursor.getColumnIndex("id")));
                                campaignEx.setTab(cursor.getInt(cursor.getColumnIndex("tab")));
                                campaignEx.setPackageName(cursor.getString(cursor.getColumnIndex("package_name")));
                                campaignEx.setAppName(cursor.getString(cursor.getColumnIndex("app_name")));
                                campaignEx.setAppDesc(cursor.getString(cursor.getColumnIndex("app_desc")));
                                campaignEx.setSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_APP_SIZE)));
                                campaignEx.setImageSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_SIZE)));
                                campaignEx.setIconUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_ICON_URL)));
                                campaignEx.setImageUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_URL)));
                                campaignEx.setImpressionURL(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMPRESSION_URL)));
                                campaignEx.setNoticeUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_NOTICE_URL)));
                                campaignEx.setClickURL(cursor.getString(cursor.getColumnIndex(DownloadModel.DOWNLOAD_URL)));
                                campaignEx.setWtick(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK)));
                                campaignEx.setDeepLinkUrl(cursor.getString(cursor.getColumnIndex("deeplink_url")));
                                campaignEx.setUserActivation(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_USER_ACTIVATION))));
                                campaignEx.setOnlyImpressionURL(cursor.getString(cursor.getColumnIndex("only_impression")));
                                campaignEx.setNetAddress(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I)));
                                campaignEx.setAc(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME)));
                                campaignEx.setAc_s(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH)));
                                campaignEx.setTemplate(cursor.getInt(cursor.getColumnIndex("template")));
                                campaignEx.setLandingType(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_LANDING_TYPE)));
                                campaignEx.setLinkType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_LINK_TYPE)));
                                campaignEx.setClick_mode(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_CLICK_MODE)));
                                campaignEx.setRating(Double.parseDouble(cursor.getString(cursor.getColumnIndex("star"))));
                                campaignEx.setNumberRating(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NUMBER_RATING)));
                                campaignEx.setClickInterval(cursor.getInt(cursor.getColumnIndex("cti")));
                                campaignEx.setTimestamp(cursor.getLong(cursor.getColumnIndex("ts")));
                                campaignEx.setCacheLevel(cursor.getInt(cursor.getColumnIndex("level")));
                                campaignEx.setType(cursor.getInt(cursor.getColumnIndex("adSource")));
                                campaignEx.setAdCall(cursor.getString(cursor.getColumnIndex("ad_call")));
                                campaignEx.setFca(cursor.getInt(cursor.getColumnIndex("fc_a")));
                                campaignEx.setFcb(cursor.getInt(cursor.getColumnIndex("fc_b")));
                                campaignEx.setAd_url_list(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_URL_LIST)));
                                campaignEx.setVideoLength(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_LENGTHL)));
                                campaignEx.setVideoSize(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_SIZE)));
                                campaignEx.setVideoResolution(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_RESOLUTION)));
                                campaignEx.setEndcard_click_result(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_ENDCARD_CLICK)));
                                campaignEx.setVideoUrlEncode(cursor.getString(cursor.getColumnIndex("video_url")));
                                campaignEx.setWatchMile(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WATCH_MILE)));
                                campaignEx.setTImp(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_T_IMP)));
                                campaignEx.setBty(cursor.getInt(cursor.getColumnIndex("bty")));
                                campaignEx.setAdvImp(cursor.getString(cursor.getColumnIndex("advImp")));
                                campaignEx.setLocalRequestId(cursor.getString(cursor.getColumnIndex("local_request_id")));
                                campaignEx.setNRid(cursor.getString(cursor.getColumnIndex("n_request_id")));
                                campaignEx.setNLRid(cursor.getString(cursor.getColumnIndex("n_local_request_id")));
                                campaignEx.setTyped(cursor.getInt(cursor.getColumnIndex("err_type_default_ad")));
                                campaignEx.setReasond(cursor.getString(cursor.getColumnIndex("err_reason_default_ad")));
                                campaignEx.setOfferType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_OFFER_TYPE)));
                                campaignEx.setGuidelines(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
                                campaignEx.setHtmlUrl(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_HTML_URL)));
                                campaignEx.setEndScreenUrl(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_END_SCREEN_URL)));
                                campaignEx.setRewardName(cursor.getString(cursor.getColumnIndex("reward_name")));
                                campaignEx.setRewardAmount(cursor.getInt(cursor.getColumnIndex("reward_amount")));
                                campaignEx.setRewardPlayStatus(cursor.getInt(cursor.getColumnIndex("reward_play_status")));
                                campaignEx.setRetarget_offer(cursor.getInt(cursor.getColumnIndex("retarget")));
                                campaignEx.setCampaignUnitId(cursor.getString(cursor.getColumnIndex("unitid")));
                                campaignEx.setNativeVideoTracking(CampaignEx.TrackingStr2Object(cursor.getString(cursor.getColumnIndex("native_ad_tracking"))));
                                campaignEx.setNativeVideoTrackingString(cursor.getString(cursor.getColumnIndex("native_ad_tracking")));
                                campaignEx.setVideo_end_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.VIDEO_END_TYPE)));
                                campaignEx.setendcard_url(cursor.getString(cursor.getColumnIndex(CampaignEx.ENDCARD_URL)));
                                campaignEx.setPlayable_ads_without_video(cursor.getInt(cursor.getColumnIndex(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO)));
                                campaignEx.setMof_template_url(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TEMPLATE_URL)));
                                campaignEx.setMof_tplid(cursor.getInt(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TPLID)));
                                campaignEx.setRewardTemplateMode(CampaignEx.c.a(cursor.getString(cursor.getColumnIndex("reward_teamplate"))));
                                campaignEx.setVideoMD5Value(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5)));
                                campaignEx.setGifUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GIF_URL)));
                                campaignEx.setNvT2(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NV_T2)));
                                campaignEx.setClickTimeOutInterval(cursor.getInt(cursor.getColumnIndex("c_coi")));
                                campaignEx.setcUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_C_UA)));
                                campaignEx.setImpUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMP_UA)));
                                campaignEx.setOc_time(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TIME)));
                                campaignEx.setOc_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TYPE)));
                                campaignEx.setT_list(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_T_LIST)));
                                campaignEx.setGhId(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_GH_ID)));
                                campaignEx.setGhPath(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_GH_PATH)));
                                campaignEx.setBindId(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_BIND_ID)));
                                String string2 = cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_ADCHOICE));
                                if (!TextUtils.isEmpty(string2)) {
                                    campaignEx.setAdchoice(CampaignEx.a.c(string2));
                                }
                                campaignEx.setAdchoiceSizeHeight(cursor.getInt(cursor.getColumnIndex("adchoice_size_height")));
                                campaignEx.setAdchoiceSizeWidth(cursor.getInt(cursor.getColumnIndex("adchoice_size_width")));
                                campaignEx.setPlct(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCT)));
                                campaignEx.setPlctb(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCTB)));
                                campaignEx.setCandidateCacheTime(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_C_C_TIME)));
                                campaignEx.setAdZip(cursor.getString(cursor.getColumnIndex("ad_zip")));
                                campaignEx.setAdHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_HTML)));
                                campaignEx.setBannerUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_URL)));
                                campaignEx.setBannerHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_HTML)));
                                campaignEx.setCreativeId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_CREATIVE_ID)));
                                campaignEx.setVidCrtvId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID)));
                                campaignEx.setEcCrtvId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_EC_CREATIVE_ID)));
                                campaignEx.setEcTemplateId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_EC_TEMP_ID)));
                                campaignEx.setIsBidCampaign(cursor.getInt(cursor.getColumnIndex("is_bid_campaign")) == 1);
                                campaignEx.setBidToken(cursor.getString(cursor.getColumnIndex("bid_token")));
                                campaignEx.setAdType(cursor.getInt(cursor.getColumnIndex("ad_type")));
                                campaignEx.setFac(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FAC)));
                                campaignEx.setTpOffer(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_TP_OFFER)));
                                campaignEx.setMraid(cursor.getString(cursor.getColumnIndex("mraid")));
                                if (cursor.getInt(cursor.getColumnIndex("is_mraid_campaign")) == 1) {
                                    z = true;
                                }
                                campaignEx.setIsMraid(z);
                                campaignEx.setOmid(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_OMID)));
                                campaignEx.setReady_rate(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_READY_RATE)));
                                campaignEx.setExt_data(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_EXT_DATA)));
                                campaignEx.setNscpt(cursor.getInt(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_NSCPT)));
                                campaignEx.setReq_ext_data(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_REQ_EXT_DATA)));
                                campaignEx.setReadyState(cursor.getInt(cursor.getColumnIndex("readyState")));
                                campaignEx.setLoadTimeoutState(cursor.getInt(cursor.getColumnIndex("load_timeout")));
                                campaignEx.setPlacementId(cursor.getString(cursor.getColumnIndex(AndroidBridgeConstants.PLACEMENT_ID)));
                                campaignEx.setMaitve(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_MAITVE)));
                                campaignEx.setMaitve_src(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_MAITVESRC)));
                                campaignEx.setFlb(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB)));
                                campaignEx.setFlbSkipTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB_SKIP_TIME)));
                                campaignEx.setCbd(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD)));
                                campaignEx.setVst(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST)));
                                campaignEx.setUseSkipTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_USE_SKIP_TIME)));
                                campaignEx.setProgressBarShow(cursor.getColumnIndex(CampaignEx.JSON_KEY_PROG_BAR));
                                campaignEx.setAdSpaceT(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T)));
                                campaignEx.setVcn(cursor.getInt(cursor.getColumnIndex("vcn")));
                                campaignEx.setTokenRule(cursor.getInt(cursor.getColumnIndex("token_r")));
                                campaignEx.setEncryptPrice(cursor.getString(cursor.getColumnIndex("encrypt_p")));
                                campaignEx.setVideoCheckType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE)));
                                campaignEx.setVideoCtnType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE)));
                                campaignEx.setRsIgnoreCheckRuleByString(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE)));
                                campaignEx.setVideoCompleteTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME)));
                                campaignEx.setAabEntity(AabEntity.parser(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AAB))));
                                campaignEx.setPrivacyUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_PRIVACY_URL)));
                                campaignEx.setPrivacyButtonTemplateVisibility(cursor.getInt(cursor.getColumnIndex("privacy_button_video")));
                                campaignEx.setImpReportType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMP_REPORT_TYPE)));
                                campaignEx.setAutoShowStoreMiniCard(cursor.getInt(cursor.getColumnIndex("auto_minicard")));
                                campaignEx.setShowStoreMiniCardDelayTime(cursor.getInt(cursor.getColumnIndex("mincard_trigger_time")));
                                campaignEx.setFilterAdsVideoCallState(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_SECOND_FILTER_AD_VIDEO_CALL_STATE)));
                                campaignEx.setSecondRequestIndex(cursor.getInt(cursor.getColumnIndex("r_index")));
                                campaignEx.setSecondShowIndex(cursor.getInt(cursor.getColumnIndex("s_show_index")));
                                campaignEx.setFilterCallBackState(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE)));
                                campaignEx.setFilterAdsShowCallState(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_SECOND_FILTER_AD_SHOW_CALL_STATE)));
                                campaignEx.setLocalCheckShow(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_LOCAL_CHECK_STATE)));
                                campaignEx.setLocalAllowTrackClick(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_LOCAL_ALLOW_TRACK_CLICK)));
                                arrayList.add(campaignEx);
                            }
                            cursor.close();
                            return arrayList;
                        }
                    } catch (Exception e) {
                        e = e;
                        if (MBridgeConstans.DEBUG) {
                            p0.b("CampaignDao", e.getLocalizedMessage());
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    private CampaignEx a(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        CampaignEx campaignEx = new CampaignEx();
        try {
            String string = cursor.getString(cursor.getColumnIndex("pv_urls"));
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                campaignEx.setPv_urls(arrayList);
            }
        } catch (JSONException e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CampaignDao", e.getLocalizedMessage());
            }
        }
        campaignEx.setId(cursor.getString(cursor.getColumnIndex("id")));
        campaignEx.setTab(cursor.getInt(cursor.getColumnIndex("tab")));
        campaignEx.setPackageName(cursor.getString(cursor.getColumnIndex("package_name")));
        campaignEx.setAppName(cursor.getString(cursor.getColumnIndex("app_name")));
        campaignEx.setAppDesc(cursor.getString(cursor.getColumnIndex("app_desc")));
        campaignEx.setSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_APP_SIZE)));
        campaignEx.setImageSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_SIZE)));
        campaignEx.setIconUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_ICON_URL)));
        campaignEx.setImageUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_URL)));
        campaignEx.setImpressionURL(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMPRESSION_URL)));
        campaignEx.setNoticeUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_NOTICE_URL)));
        campaignEx.setClickURL(cursor.getString(cursor.getColumnIndex(DownloadModel.DOWNLOAD_URL)));
        campaignEx.setWtick(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK)));
        campaignEx.setDeepLinkUrl(cursor.getString(cursor.getColumnIndex("deeplink_url")));
        campaignEx.setUserActivation(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_USER_ACTIVATION))));
        campaignEx.setOnlyImpressionURL(cursor.getString(cursor.getColumnIndex("only_impression")));
        campaignEx.setNetAddress(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I)));
        campaignEx.setAc(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME)));
        campaignEx.setAc_s(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH)));
        campaignEx.setTemplate(cursor.getInt(cursor.getColumnIndex("template")));
        campaignEx.setLandingType(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_LANDING_TYPE)));
        campaignEx.setLinkType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_LINK_TYPE)));
        campaignEx.setClick_mode(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_CLICK_MODE)));
        campaignEx.setRating(Double.parseDouble(cursor.getString(cursor.getColumnIndex("star"))));
        campaignEx.setNumberRating(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NUMBER_RATING)));
        campaignEx.setClickInterval(cursor.getInt(cursor.getColumnIndex("cti")));
        campaignEx.setTimestamp(cursor.getLong(cursor.getColumnIndex("ts")));
        campaignEx.setCacheLevel(cursor.getInt(cursor.getColumnIndex("level")));
        campaignEx.setAdCall(cursor.getString(cursor.getColumnIndex("ad_call")));
        campaignEx.setFcb(cursor.getInt(cursor.getColumnIndex("fc_b")));
        campaignEx.setAd_url_list(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_URL_LIST)));
        campaignEx.setVideoLength(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_LENGTHL)));
        campaignEx.setVideoSize(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_SIZE)));
        campaignEx.setVideoResolution(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_RESOLUTION)));
        campaignEx.setEndcard_click_result(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_ENDCARD_CLICK)));
        campaignEx.setVideoUrlEncode(cursor.getString(cursor.getColumnIndex("video_url")));
        campaignEx.setWatchMile(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WATCH_MILE)));
        campaignEx.setTImp(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_T_IMP)));
        campaignEx.setBty(cursor.getInt(cursor.getColumnIndex("bty")));
        campaignEx.setAdvImp(cursor.getString(cursor.getColumnIndex("advImp")));
        campaignEx.setLocalRequestId(cursor.getString(cursor.getColumnIndex("local_request_id")));
        campaignEx.setNRid(cursor.getString(cursor.getColumnIndex("n_request_id")));
        campaignEx.setNLRid(cursor.getString(cursor.getColumnIndex("n_local_request_id")));
        campaignEx.setTyped(cursor.getInt(cursor.getColumnIndex("err_type_default_ad")));
        campaignEx.setReasond(cursor.getString(cursor.getColumnIndex("err_reason_default_ad")));
        campaignEx.setGuidelines(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
        campaignEx.setOfferType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_OFFER_TYPE)));
        campaignEx.setHtmlUrl(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_HTML_URL)));
        campaignEx.setGuidelines(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
        campaignEx.setHtmlUrl(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_HTML_URL)));
        campaignEx.setEndScreenUrl(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_END_SCREEN_URL)));
        campaignEx.setRewardName(cursor.getString(cursor.getColumnIndex("reward_name")));
        campaignEx.setRewardAmount(cursor.getInt(cursor.getColumnIndex("reward_amount")));
        campaignEx.setRewardPlayStatus(cursor.getInt(cursor.getColumnIndex("reward_play_status")));
        campaignEx.setRetarget_offer(cursor.getInt(cursor.getColumnIndex("retarget")));
        campaignEx.setCampaignUnitId(cursor.getString(cursor.getColumnIndex("unitid")));
        campaignEx.setNativeVideoTracking(CampaignEx.TrackingStr2Object(cursor.getString(cursor.getColumnIndex("native_ad_tracking"))));
        campaignEx.setNativeVideoTrackingString(cursor.getString(cursor.getColumnIndex("native_ad_tracking")));
        campaignEx.setVideo_end_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.VIDEO_END_TYPE)));
        campaignEx.setendcard_url(cursor.getString(cursor.getColumnIndex(CampaignEx.ENDCARD_URL)));
        campaignEx.setPlayable_ads_without_video(cursor.getInt(cursor.getColumnIndex(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO)));
        campaignEx.setMof_template_url(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TEMPLATE_URL)));
        campaignEx.setMof_tplid(cursor.getInt(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TPLID)));
        campaignEx.setRewardTemplateMode(CampaignEx.c.a(cursor.getString(cursor.getColumnIndex("reward_teamplate"))));
        campaignEx.setVideoMD5Value(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5)));
        campaignEx.setGifUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GIF_URL)));
        campaignEx.setNvT2(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NV_T2)));
        campaignEx.setClickTimeOutInterval(cursor.getInt(cursor.getColumnIndex("c_coi")));
        campaignEx.setcUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_C_UA)));
        campaignEx.setImpUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMP_UA)));
        campaignEx.setJmPd(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_JM_PD)));
        campaignEx.setIsDeleted(cursor.getInt(cursor.getColumnIndex("is_deleted")));
        campaignEx.setIsClick(cursor.getInt(cursor.getColumnIndex("is_click")));
        campaignEx.setIsAddSuccesful(cursor.getInt(cursor.getColumnIndex("is_add_sucesful")));
        campaignEx.setIsDownLoadZip(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_IS_DOWNLOAD)));
        campaignEx.setInteractiveCache(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_CACHE)));
        campaignEx.setKeyIaOri(cursor.getInt(cursor.getColumnIndex("ia_ori")));
        campaignEx.setAdType(cursor.getInt(cursor.getColumnIndex("ad_type")));
        campaignEx.setFac(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FAC)));
        campaignEx.setTpOffer(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_TP_OFFER)));
        campaignEx.setIa_ext1(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_EXT1)));
        campaignEx.setIa_ext2(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_EXT2)));
        campaignEx.setKeyIaRst(cursor.getInt(cursor.getColumnIndex("ia_rst")));
        campaignEx.setKeyIaUrl(cursor.getString(cursor.getColumnIndex("ia_url")));
        campaignEx.setKeyIaIcon(cursor.getString(cursor.getColumnIndex("ia_icon")));
        campaignEx.setOc_time(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TIME)));
        campaignEx.setOc_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TYPE)));
        campaignEx.setT_list(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_T_LIST)));
        campaignEx.setGhId(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_GH_ID)));
        campaignEx.setGhPath(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_GH_PATH)));
        campaignEx.setBindId(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_BIND_ID)));
        String string2 = cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_ADCHOICE));
        if (!TextUtils.isEmpty(string2)) {
            campaignEx.setAdchoice(CampaignEx.a.c(string2));
        }
        campaignEx.setAdchoiceSizeHeight(cursor.getInt(cursor.getColumnIndex("adchoice_size_height")));
        campaignEx.setAdchoiceSizeWidth(cursor.getInt(cursor.getColumnIndex("adchoice_size_width")));
        campaignEx.setPlct(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCT)));
        campaignEx.setPlctb(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCTB)));
        campaignEx.setCandidateCacheTime(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_C_C_TIME)));
        campaignEx.setAdZip(cursor.getString(cursor.getColumnIndex("ad_zip")));
        campaignEx.setAdHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_HTML)));
        campaignEx.setBannerUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_URL)));
        campaignEx.setBannerHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_HTML)));
        campaignEx.setCreativeId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_CREATIVE_ID)));
        campaignEx.setVidCrtvId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID)));
        campaignEx.setEcCrtvId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_EC_CREATIVE_ID)));
        campaignEx.setEcTemplateId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_EC_TEMP_ID)));
        campaignEx.setIsBidCampaign(cursor.getInt(cursor.getColumnIndex("is_bid_campaign")) == 1);
        campaignEx.setBidToken(cursor.getString(cursor.getColumnIndex("bid_token")));
        campaignEx.setMraid(cursor.getString(cursor.getColumnIndex("mraid")));
        campaignEx.setIsMraid(cursor.getInt(cursor.getColumnIndex("is_mraid_campaign")) == 1);
        campaignEx.setOmid(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_OMID)));
        campaignEx.setReady_rate(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_READY_RATE)));
        campaignEx.setExt_data(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_EXT_DATA)));
        campaignEx.setNscpt(cursor.getInt(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_NSCPT)));
        campaignEx.setReq_ext_data(cursor.getString(cursor.getColumnIndex(com.mbridge.msdk.foundation.entity.b.JSON_KEY_REQ_EXT_DATA)));
        campaignEx.setReadyState(cursor.getInt(cursor.getColumnIndex("readyState")));
        campaignEx.setLoadTimeoutState(cursor.getInt(cursor.getColumnIndex("load_timeout")));
        campaignEx.setPlacementId(cursor.getString(cursor.getColumnIndex(AndroidBridgeConstants.PLACEMENT_ID)));
        campaignEx.setMaitve(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_MAITVE)));
        campaignEx.setMaitve_src(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_MAITVESRC)));
        campaignEx.setFlb(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB)));
        campaignEx.setFlbSkipTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB_SKIP_TIME)));
        campaignEx.setCbd(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD)));
        campaignEx.setVst(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST)));
        campaignEx.setUseSkipTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_USE_SKIP_TIME)));
        campaignEx.setProgressBarShow(cursor.getColumnIndex(CampaignEx.JSON_KEY_PROG_BAR));
        campaignEx.setAdSpaceT(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T)));
        campaignEx.setVcn(cursor.getInt(cursor.getColumnIndex("vcn")));
        campaignEx.setTokenRule(cursor.getInt(cursor.getColumnIndex("token_r")));
        campaignEx.setEncryptPrice(cursor.getString(cursor.getColumnIndex("encrypt_p")));
        campaignEx.setVideoCheckType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE)));
        campaignEx.setVideoCtnType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE)));
        campaignEx.setRsIgnoreCheckRuleByString(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE)));
        campaignEx.setVideoCompleteTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME)));
        campaignEx.setAabEntity(AabEntity.parser(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AAB))));
        campaignEx.setPrivacyUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_PRIVACY_URL)));
        campaignEx.setPrivacyButtonTemplateVisibility(cursor.getInt(cursor.getColumnIndex("privacy_button_video")));
        campaignEx.setImpReportType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMP_REPORT_TYPE)));
        campaignEx.setAutoShowStoreMiniCard(cursor.getInt(cursor.getColumnIndex("auto_minicard")));
        campaignEx.setShowStoreMiniCardDelayTime(cursor.getInt(cursor.getColumnIndex("mincard_trigger_time")));
        campaignEx.setFilterAdsVideoCallState(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_SECOND_FILTER_AD_VIDEO_CALL_STATE)));
        campaignEx.setSecondRequestIndex(cursor.getInt(cursor.getColumnIndex("r_index")));
        campaignEx.setSecondShowIndex(cursor.getInt(cursor.getColumnIndex("s_show_index")));
        campaignEx.setFilterCallBackState(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE)));
        campaignEx.setFilterAdsShowCallState(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_SECOND_FILTER_AD_SHOW_CALL_STATE)));
        campaignEx.setLocalCheckShow(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_LOCAL_CHECK_STATE)));
        campaignEx.setLocalAllowTrackClick(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_LOCAL_ALLOW_TRACK_CLICK)));
        return campaignEx;
    }

    public synchronized void a(String str, String str2) {
        try {
        } catch (Exception e) {
            p0.b("CampaignDao", e.getLocalizedMessage());
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            String[] strArr = {str, str2};
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", (Integer) 2);
            getWritableDatabase().update("campaign", contentValues, "unitid = ? AND bid_token = ? AND bid_token IS NOT NULL", strArr);
        }
    }
}
