package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.v0;

/* compiled from: CampaignClickDao.java */
/* loaded from: classes6.dex */
public class d extends a<JumpLoaderResult> {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4217a = "d";
    private static d b;

    private d(f fVar) {
        super(fVar);
    }

    public static synchronized d a(f fVar) {
        d dVar;
        synchronized (d.class) {
            if (b == null) {
                b = new d(fVar);
            }
            dVar = b;
        }
        return dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0060, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        if (r12 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0048, code lost:
    
        if (r12 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0064, code lost:
    
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a A[Catch: all -> 0x006e, TRY_ENTER, TryCatch #4 {, blocks: (B:20:0x0040, B:11:0x0060, B:34:0x006a, B:35:0x006d), top: B:3:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[Catch: all -> 0x006e, SYNTHETIC, TryCatch #4 {, blocks: (B:20:0x0040, B:11:0x0060, B:34:0x006a, B:35:0x006d), top: B:3:0x0002 }] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized JumpLoaderResult b(String str, String str2) {
        Throwable th;
        Exception exc;
        Cursor cursor;
        ?? r1 = 0;
        try {
            try {
                cursor = getReadableDatabase().query("campaignclick", null, "id=? AND unitid=?", new String[]{str, str2}, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0 && cursor.moveToFirst()) {
                            String string = cursor.getString(cursor.getColumnIndex("result"));
                            if (!TextUtils.isEmpty(string)) {
                                JumpLoaderResult jumpLoaderResult = (JumpLoaderResult) v0.a(string);
                                cursor.close();
                                return jumpLoaderResult;
                            }
                        }
                    } catch (Exception e) {
                        exc = e;
                        if (MBridgeConstans.DEBUG) {
                            p0.b(f4217a, exc.getMessage());
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = str;
                if (r1 != 0) {
                    throw th;
                }
                r1.close();
                throw th;
            }
        } catch (Exception e2) {
            exc = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (r1 != 0) {
            }
        }
    }

    public synchronized boolean c(String str, String str2) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT id FROM campaignclick WHERE id= ? AND unitid= ? AND cti + ts > " + System.currentTimeMillis(), new String[]{str, str2});
            if (rawQuery != null && rawQuery.getCount() > 0) {
                rawQuery.close();
                return true;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return false;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b(f4217a, e.getMessage());
            }
            return false;
        }
    }

    public synchronized void a() {
        try {
            getWritableDatabase().delete("campaignclick", " ( " + System.currentTimeMillis() + " - ts) > cti", null);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b(f4217a, e.getMessage());
            }
        }
    }

    public synchronized long a(CampaignEx campaignEx, String str) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            String a2 = v0.a(campaignEx.getJumpResult());
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", campaignEx.getId());
            contentValues.put("unitid", str);
            contentValues.put("result", a2);
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval() * 1000));
            contentValues.put("package_name", campaignEx.getPackageName());
            com.mbridge.msdk.setting.g d = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            contentValues.put("ts", Long.valueOf(System.currentTimeMillis()));
            if (d != null && d.X() > 0) {
                contentValues.put("cpei", Integer.valueOf(d.X() * 1000));
            }
            if (d != null && d.Y() > 0) {
                contentValues.put("cpoci", Integer.valueOf(d.Y() * 1000));
            }
            if (a(campaignEx.getId(), str)) {
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                return getWritableDatabase().update("campaignclick", contentValues, "id = ? AND unitid = ? ", new String[]{campaignEx.getId(), str});
            }
            return getWritableDatabase().insert("campaignclick", null, contentValues);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b(f4217a, e.getMessage());
            }
            return -1L;
        }
    }

    public synchronized boolean a(String str, String str2) {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT id FROM campaignclick WHERE id= ? AND unitid= ?", new String[]{str, str2});
        if (rawQuery != null && rawQuery.getCount() > 0) {
            rawQuery.close();
            return true;
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return false;
    }
}
