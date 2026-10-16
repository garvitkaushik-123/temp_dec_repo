package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UnitIDDao.java */
/* loaded from: classes6.dex */
public class l extends a<com.mbridge.msdk.foundation.entity.h> {

    /* renamed from: a, reason: collision with root package name */
    private static l f4226a;

    private l(f fVar) {
        super(fVar);
    }

    public static l a(f fVar) {
        if (f4226a == null) {
            synchronized (l.class) {
                if (f4226a == null) {
                    f4226a = new l(fVar);
                }
            }
        }
        return f4226a;
    }

    public synchronized void a(String str) {
        if (getWritableDatabase() != null) {
            getWritableDatabase().delete(MBridgeConstans.PROPERTIES_UNIT_ID, "unitId = ?", new String[]{str + ""});
        }
    }

    public synchronized void a(String str, String str2, int i) {
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(AndroidBridgeConstants.PLACEMENT_ID, str);
        contentValues.put("unitId", str2);
        contentValues.put("ad_type", Integer.valueOf(i));
        getWritableDatabase().insert(MBridgeConstans.PROPERTIES_UNIT_ID, null, contentValues);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0055, code lost:
    
        if (r0 != null) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<com.mbridge.msdk.foundation.entity.i> a(int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Cursor cursor = null;
        arrayList2 = null;
        arrayList2 = null;
        cursor = null;
        try {
            try {
                Cursor cursor2 = getReadableDatabase().rawQuery("select * from unit_id WHERE ad_type = ?", new String[]{String.valueOf(i)});
                if (cursor2 != null) {
                    try {
                        try {
                            if (cursor2.getCount() > 0) {
                                arrayList = new ArrayList(cursor2.getCount());
                                while (cursor2.moveToNext()) {
                                    try {
                                        arrayList.add(new com.mbridge.msdk.foundation.entity.i(cursor2.getString(cursor2.getColumnIndex(AndroidBridgeConstants.PLACEMENT_ID)), cursor2.getString(cursor2.getColumnIndex("unitId")), i));
                                    } catch (Exception e) {
                                        e = e;
                                        cursor = cursor2;
                                        e.printStackTrace();
                                        if (cursor == null) {
                                            arrayList2 = arrayList;
                                            return arrayList2;
                                        }
                                        cursor2 = cursor;
                                        arrayList2 = arrayList;
                                        try {
                                            cursor2.close();
                                        } catch (Exception unused) {
                                        }
                                        return arrayList2;
                                    }
                                }
                                arrayList2 = arrayList;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursor2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception unused2) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        arrayList = null;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                arrayList = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return arrayList2;
    }
}
