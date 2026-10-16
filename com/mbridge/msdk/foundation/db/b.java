package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BidReplaceCampignDao.java */
/* loaded from: classes6.dex */
public class b extends a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f4215a;

    public b(f fVar) {
        super(fVar);
    }

    public static b a(Context context) {
        if (f4215a == null) {
            synchronized (b.class) {
                if (f4215a == null) {
                    f4215a = new b(g.a(context));
                }
            }
        }
        return f4215a;
    }

    public int b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && getWritableDatabase() != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_replace", (Integer) 1);
                return getWritableDatabase().update("bid_replace_campaign", contentValues, "bid_unit_id = ? AND expect_bid_token = ?", new String[]{str2, str});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public void a(String str, List<CampaignEx> list) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        try {
            String requestId = list.get(0).getRequestId();
            String encryptPrice = list.get(0).getEncryptPrice();
            String campaignUnitId = list.get(0).getCampaignUnitId();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("bid_unit_id", campaignUnitId);
            contentValues.put("expect_bid_token", str);
            contentValues.put("expect_encrypt_price", "");
            contentValues.put("real_request_id", requestId);
            contentValues.put("real_encrypt_price", encryptPrice);
            contentValues.put("real_token_rule", (Integer) 1);
            contentValues.put("is_replace", (Integer) 0);
            writableDatabase.insert("bid_replace_campaign", null, contentValues);
            p0.b("HBOPTIMIZE", "插入数据到对应关系表 期望 bidToken 值" + str + "+ 用于替换期望Offer 的RequestId " + requestId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a2, code lost:
    
        if (r1 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b6, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b4, code lost:
    
        if (0 == 0) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<com.mbridge.msdk.foundation.entity.d> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Cursor cursor = null;
            try {
                try {
                    synchronized (new Object()) {
                        cursor = getReadableDatabase().rawQuery("SELECT * FROM bid_replace_campaign WHERE bid_unit_id = ? AND real_request_id = ?", new String[]{str, str2});
                    }
                    if (cursor != null && cursor.getCount() > 0) {
                        while (cursor.moveToNext()) {
                            com.mbridge.msdk.foundation.entity.d dVar = new com.mbridge.msdk.foundation.entity.d();
                            String string = cursor.getString(cursor.getColumnIndex("bid_unit_id"));
                            String string2 = cursor.getString(cursor.getColumnIndex("expect_bid_token"));
                            String string3 = cursor.getString(cursor.getColumnIndex("expect_encrypt_price"));
                            String string4 = cursor.getString(cursor.getColumnIndex("real_request_id"));
                            String string5 = cursor.getString(cursor.getColumnIndex("real_encrypt_price"));
                            int i = cursor.getInt(cursor.getColumnIndex("real_token_rule"));
                            int i2 = cursor.getInt(cursor.getColumnIndex("is_replace"));
                            dVar.a(string);
                            dVar.b(string2);
                            dVar.c(string3);
                            dVar.e(string4);
                            dVar.d(string5);
                            dVar.b(i);
                            dVar.a(i2);
                            arrayList.add(dVar);
                        }
                    }
                } catch (Exception e) {
                    p0.b("BidReplaceCampaignDao", e.getLocalizedMessage());
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

    public int a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return 0;
            }
            return writableDatabase.delete("bid_replace_campaign", "is_replace = 0", null);
        } catch (Exception e) {
            p0.b("BidReplaceCampaignDao", e.getLocalizedMessage());
            return 0;
        }
    }

    public int a(String str) {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = getWritableDatabase();
        } catch (Exception e) {
            p0.b("BidReplaceCampaignDao", e.getLocalizedMessage());
        }
        if (writableDatabase == null) {
            return 0;
        }
        return writableDatabase.delete("bid_replace_campaign", "real_request_id = ? AND is_replace = 1", new String[]{str});
    }

    public int a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && getWritableDatabase() != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expect_encrypt_price", str3);
                return getWritableDatabase().update("bid_replace_campaign", contentValues, "bid_unit_id = ? AND expect_bid_token = ?", new String[]{str2, str});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
