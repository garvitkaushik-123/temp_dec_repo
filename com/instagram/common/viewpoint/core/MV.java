package com.instagram.common.viewpoint.core;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@MetaExoPlayerCustomization(type = {"NON_FINAL"}, value = "D54147219: For usage in Hero Simple Cache")
/* loaded from: assets/audience_network/classes2.dex */
public final class MV {
    public static byte[] A02;
    public static final String[] A03;
    public String A00;
    public final C5O A01;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 44);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{-91, -123, -53, -66, -54, -62, 125, -79, -94, -75, -79, 125, -83, -81, -90, -86, -98, -81, -74, 125, -88, -94, -74, 125, -85, -84, -79, 125, -85, -78, -87, -87, -119, -55, -62, -53, -60, -47, -59, 125, -90, -85, -79, -94, -92, -94, -81, 125, -85, -84, -79, 125, -85, -78, -87, -87, -119, -55, -66, -48, -47, -68, -47, -52, -46, -64, -59, -68, -47, -58, -54, -62, -48, -47, -66, -54, -51, 125, -90, -85, -79, -94, -92, -94, -81, 125, -85, -84, -79, 125, -85, -78, -87, -87, -122, -98, -83, -96, -100, -81, -96, 123, -81, -100, -99, -89, -96, 123, -25, -11, -14, -13, -61, -9, -28, -27, -17, -24, -61, -20, -23, -61, -24, -5, -20, -10, -9, -10, -61, Byte.MAX_VALUE, -78, -87, -118, -90, -101, -77, -97, -84, 125, -101, -99, -94, -97, Byte.MIN_VALUE, -93, -90, -97, -121, -97, -82, -101, -98, -101, -82, -101, Ascii.CR, 2, Ascii.DC4, Ascii.NAK, 0, Ascii.NAK, Ascii.DLE, Ascii.SYN, 4, 9, 0, Ascii.NAK, 10, Ascii.SO, 6, Ascii.DC4, Ascii.NAK, 2, Ascii.SO, 17, -24, -31, -22, -29, -16, -28, -89, -102, -90, -98, -96, -109, -97, -105, 82, 111, 82, 113};
    }

    static {
        A03();
        A03 = new String[]{A01(181, 4, 13), A01(175, 6, 80), A01(155, 20, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE)};
    }

    public MV(C5O c5o) {
        this.A01 = c5o;
    }

    private Cursor A00() {
        AbstractC07133y.A01(this.A00);
        return this.A01.getReadableDatabase().query(this.A00, A03, null, null, null, null, null);
    }

    public static String A02(String str) {
        return A01(129, 26, 14) + str;
    }

    public static void A04(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL(A01(108, 21, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) + str);
    }

    public final Map<String, MU> A05() throws C5N {
        try {
            Cursor A00 = A00();
            try {
                HashMap hashMap = new HashMap(A00.getCount());
                while (A00.moveToNext()) {
                    hashMap.put((String) AbstractC07133y.A01(A00.getString(0)), new MU(A00.getLong(1), A00.getLong(2)));
                }
                if (A00 != null) {
                    A00.close();
                }
                return hashMap;
            } finally {
            }
        } catch (SQLException e) {
            throw new C5N(e);
        }
    }

    public final void A06(long j) throws C5N {
        try {
            String hexString = Long.toHexString(j);
            String hexUid = A02(hexString);
            this.A00 = hexUid;
            if (C5Q.A00(this.A01.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.A01.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    C5Q.A04(writableDatabase, 2, hexString, 1);
                    String hexUid2 = this.A00;
                    A04(writableDatabase, hexUid2);
                    StringBuilder sb = new StringBuilder();
                    String hexUid3 = A01(95, 13, 47);
                    StringBuilder append = sb.append(hexUid3);
                    String hexUid4 = this.A00;
                    StringBuilder append2 = append.append(hexUid4);
                    String hexUid5 = A01(0, 1, 89);
                    StringBuilder append3 = append2.append(hexUid5);
                    String hexUid6 = A01(1, 94, 49);
                    writableDatabase.execSQL(append3.append(hexUid6).toString());
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
        } catch (SQLException e) {
            throw new C5N(e);
        }
    }

    public final void A07(String str) throws C5N {
        AbstractC07133y.A01(this.A00);
        try {
            this.A01.getWritableDatabase().delete(this.A00, A01(185, 8, 6), new String[]{str});
        } catch (SQLException e) {
            throw new C5N(e);
        }
    }

    public final void A08(String str, long j, long j2) throws C5N {
        AbstractC07133y.A01(this.A00);
        try {
            SQLiteDatabase writableDatabase = this.A01.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(A01(181, 4, 13), str);
            contentValues.put(A01(175, 6, 80), Long.valueOf(j));
            contentValues.put(A01(155, 20, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), Long.valueOf(j2));
            writableDatabase.replaceOrThrow(this.A00, null, contentValues);
        } catch (SQLException e) {
            throw new C5N(e);
        }
    }

    public final void A09(Set<String> set) throws C5N {
        AbstractC07133y.A01(this.A00);
        try {
            SQLiteDatabase writableDatabase = this.A01.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete(this.A00, A01(185, 8, 6), new String[]{it.next()});
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            throw new C5N(e);
        }
    }
}
