package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.out.Campaign;

/* compiled from: DailyPlayCapDao.java */
/* loaded from: classes6.dex */
public class h extends a<Campaign> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4222a = "com.mbridge.msdk.foundation.db.h";
    private static h b;

    private h(f fVar) {
        super(fVar);
    }

    public static h a(f fVar) {
        if (b == null) {
            synchronized (h.class) {
                if (b == null) {
                    b = new h(fVar);
                }
            }
        }
        return b;
    }

    private synchronized void c(String str) {
        try {
        } catch (Throwable unused) {
            p0.c(f4222a, "resetTimeAndTimestamp error");
        }
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_insert_timestamp", (Integer) 0);
        contentValues.put("play_time", (Integer) 0);
        getWritableDatabase().update("dailyplaycap", contentValues, "unit_id = ?", new String[]{str});
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ab, code lost:
    
        if (r1 != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b6, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
    
        if (0 == 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(String str) {
        long j;
        long j2;
        long j3;
        Cursor cursor = null;
        try {
            try {
                if (getWritableDatabase() == null) {
                    return;
                }
                ContentValues contentValues = new ContentValues();
                long currentTimeMillis = System.currentTimeMillis();
                if (a(str)) {
                    cursor = getReadableDatabase().rawQuery("SELECT * FROM dailyplaycap where unit_id = ?", new String[]{str});
                    if (cursor == null || cursor.getCount() <= 0) {
                        j = 1;
                        j2 = 0;
                        j3 = 0;
                    } else {
                        cursor.moveToFirst();
                        j3 = cursor.getLong(cursor.getColumnIndex("first_insert_timestamp"));
                        j = 1;
                        j2 = cursor.getInt(cursor.getColumnIndex("play_time"));
                        if (currentTimeMillis - 86400000 > j3) {
                            c(str);
                            j2 = 0;
                        }
                    }
                    if (j3 == 0) {
                        contentValues.put("first_insert_timestamp", Long.valueOf(currentTimeMillis));
                    }
                    contentValues.put("play_time", Long.valueOf(j2 + j));
                    getWritableDatabase().update("dailyplaycap", contentValues, "unit_id = ?", new String[]{str});
                } else {
                    contentValues.put("first_insert_timestamp", Long.valueOf(currentTimeMillis));
                    contentValues.put("play_time", (Long) 1L);
                    contentValues.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                    getWritableDatabase().insert("dailyplaycap", null, contentValues);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }

    public synchronized boolean a(String str) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT play_time FROM dailyplaycap WHERE unit_id= ?", new String[]{str});
            if (rawQuery != null && rawQuery.getCount() > 0) {
                rawQuery.close();
                return true;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
    
        if (r1 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, int i) {
        Cursor cursor = null;
        boolean z = false;
        try {
            cursor = getReadableDatabase().rawQuery("SELECT * FROM dailyplaycap where unit_id = ?", new String[]{str});
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                long j = cursor.getLong(cursor.getColumnIndex("first_insert_timestamp"));
                long j2 = cursor.getInt(cursor.getColumnIndex("play_time"));
                if (j != 0) {
                    if (System.currentTimeMillis() - 86400000 > j) {
                        c(str);
                    } else if (i > 0 && j2 >= i) {
                        z = true;
                    }
                }
            }
            if (cursor == null) {
                return z;
            }
        } catch (Throwable th) {
            try {
                p0.c(f4222a, "isOverCap is error" + th);
            } catch (Throwable th2) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
        try {
            cursor.close();
        } catch (Throwable unused2) {
        }
        return z;
    }
}
