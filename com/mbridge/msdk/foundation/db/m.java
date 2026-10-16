package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.out.Campaign;

/* compiled from: VideoDao.java */
/* loaded from: classes6.dex */
public class m extends a<Campaign> {

    /* renamed from: a, reason: collision with root package name */
    private static m f4227a;

    private m(f fVar) {
        super(fVar);
    }

    public static synchronized m a(f fVar) {
        m mVar;
        synchronized (m.class) {
            if (f4227a == null) {
                f4227a = new m(fVar);
            }
            mVar = f4227a;
        }
        return mVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a6 A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #3 {all -> 0x00c6, blocks: (B:24:0x001c, B:26:0x0022, B:29:0x0027, B:31:0x002d, B:36:0x00a2, B:38:0x00a6), top: B:5:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized com.mbridge.msdk.foundation.entity.m b(String str) {
        Exception e;
        Cursor cursor;
        Exception e2;
        com.mbridge.msdk.foundation.entity.m mVar;
        ?? r1 = 0;
        r1 = null;
        com.mbridge.msdk.foundation.entity.m mVar2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                cursor = getReadableDatabase().rawQuery("SELECT * FROM video WHERE video_url = ? ", new String[]{str});
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            mVar = new com.mbridge.msdk.foundation.entity.m();
                            while (cursor.moveToNext()) {
                                try {
                                    mVar.b(cursor.getString(cursor.getColumnIndex("video_url")));
                                    mVar.a(cursor.getInt(cursor.getColumnIndex("video_state")));
                                    mVar.b(cursor.getLong(cursor.getColumnIndex("pregeress_size")));
                                    mVar.b(cursor.getInt(cursor.getColumnIndex("total_size")));
                                    mVar.a(cursor.getString(cursor.getColumnIndex("video_path")));
                                    mVar.a(cursor.getLong(cursor.getColumnIndex("video_download_start")) * 1000);
                                } catch (Exception e3) {
                                    e2 = e3;
                                    if (MBridgeConstans.DEBUG) {
                                    }
                                    if (cursor != null) {
                                    }
                                    mVar2 = mVar;
                                    return mVar2;
                                }
                            }
                            mVar2 = mVar;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        e2 = e;
                        mVar = null;
                        if (MBridgeConstans.DEBUG) {
                            p0.b("VideoDao", e2.getLocalizedMessage());
                        }
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e5) {
                                if (MBridgeConstans.DEBUG) {
                                    p0.b("VideoDao", e5.getLocalizedMessage());
                                }
                            }
                        }
                        mVar2 = mVar;
                        return mVar2;
                    }
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e6) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("VideoDao", e6.getLocalizedMessage());
                        }
                    }
                }
            } catch (Exception e7) {
                e = e7;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (Exception e8) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("VideoDao", e8.getLocalizedMessage());
                        }
                    }
                }
                throw th;
            }
            return mVar2;
        } catch (Throwable th2) {
            th = th2;
            r1 = str;
        }
    }

    public synchronized void a(String str) {
        String[] strArr;
        try {
            strArr = new String[]{str};
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("VideoDao", e.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("video", "video_url = ? ", strArr);
    }

    public synchronized void a(String str, long j) {
        if (j == 0) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("video_download_start", Long.valueOf(j / 1000));
            if (a(str, "")) {
                getWritableDatabase().update("video", contentValues, "video_url = ? ", new String[]{str});
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("VideoDao", e.getLocalizedMessage());
            }
        }
    }

    public synchronized long a(CampaignEx campaignEx, long j, String str, int i) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1L;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("unitid", campaignEx.getCampaignUnitId());
            contentValues.put("id", campaignEx.getId());
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
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
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
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put("video_url", campaignEx.getVideoUrlEncode());
            contentValues.put("total_size", Long.valueOf(j));
            contentValues.put("video_state", Integer.valueOf(i));
            contentValues.put("video_download_start", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("ad_bid_token", campaignEx.getBidToken());
            if (!TextUtils.isEmpty(str)) {
                contentValues.put("video_path", str);
            }
            if (a(campaignEx.getVideoUrlEncode(), campaignEx.getId())) {
                return 0L;
            }
            return getWritableDatabase().insert("video", null, contentValues);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("VideoDao", e.getLocalizedMessage());
            }
            return -1L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007f, code lost:
    
        if (r0 != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0094, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0092, code lost:
    
        if (r0 != null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized com.mbridge.msdk.foundation.entity.m b(String str, String str2) {
        com.mbridge.msdk.foundation.entity.m mVar;
        Cursor cursor = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        mVar = new com.mbridge.msdk.foundation.entity.m();
        try {
            try {
                cursor = getReadableDatabase().rawQuery("SELECT * FROM video WHERE video_url = ? ", new String[]{str});
                if (cursor != null && cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        mVar.b(cursor.getString(cursor.getColumnIndex("video_url")));
                        mVar.a(cursor.getInt(cursor.getColumnIndex("video_state")));
                        mVar.b(cursor.getLong(cursor.getColumnIndex("pregeress_size")));
                        mVar.b(cursor.getInt(cursor.getColumnIndex("total_size")));
                        mVar.a(cursor.getString(cursor.getColumnIndex("video_path")));
                        mVar.a(cursor.getLong(cursor.getColumnIndex("video_download_start")) * 1000);
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("VideoDao", e.getLocalizedMessage());
            }
        }
        return mVar;
    }

    public synchronized boolean a(String str, String str2) {
        String str3;
        String[] strArr;
        if (TextUtils.isEmpty(str2)) {
            str3 = "SELECT id FROM video WHERE video_url = ? ";
            strArr = new String[]{str};
        } else {
            String[] strArr2 = {str, str2};
            str3 = "SELECT id FROM video WHERE video_url = ? AND id = ? ";
            strArr = strArr2;
        }
        Cursor rawQuery = getReadableDatabase().rawQuery(str3, strArr);
        if (rawQuery != null && rawQuery.getCount() > 0) {
            try {
                rawQuery.close();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("VideoDao", e.getLocalizedMessage());
                }
            }
            return true;
        }
        if (rawQuery != null) {
            try {
                rawQuery.close();
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("VideoDao", e2.getLocalizedMessage());
                }
            }
        }
        return false;
    }

    public synchronized long b(String str, long j) {
        int i = -1;
        try {
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("VideoDao", e.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("total_size", Long.valueOf(j));
        if (a(str, "")) {
            String[] strArr = {str};
            synchronized (new Object()) {
                i = getWritableDatabase().update("video", contentValues, "video_url = ? ", strArr);
            }
        }
        return i;
    }

    public synchronized long a(String str, long j, int i) {
        int i2 = -1;
        try {
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("VideoDao", e.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("pregeress_size", Long.valueOf(j));
        contentValues.put("video_state", Integer.valueOf(i));
        if (a(str, "")) {
            String[] strArr = {str};
            synchronized (new Object()) {
                i2 = getWritableDatabase().update("video", contentValues, "video_url = ? ", strArr);
            }
        }
        return i2;
    }
}
