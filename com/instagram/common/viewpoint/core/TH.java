package com.instagram.common.viewpoint.core;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Looper;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: assets/audience_network/classes2.dex */
public final class TH {
    public static byte[] A04;
    public static final String A05;
    public static final Lock A06;
    public static final Lock A07;
    public static final ReentrantReadWriteLock A08;
    public SQLiteOpenHelper A00;
    public final C1925ge A01;
    public final C1870fl A03 = new C1870fl(this);
    public final C1877fs A02 = new C1877fs(this);

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 17);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A04 = new byte[]{-82, -53, -82, 109, -117, 109, -116, 85, 118, -120, 120, -102, -64, -52, -55, -57, -102, Byte.MAX_VALUE, -87, -82, -88, -83, Byte.MAX_VALUE, 94, -118, -121, -117, -121, -110, 94, -93, -46, -47, -93, 87, -122, -119, 123, 124, -119, 87, 121, -112, 87, 85, -120, 122, -119, 85, -115, -60, -75, -78, -65, -78, -115, 110, 116, -82, -94, 94, 110, -101, -99, -55, -25, -12, -12, -11, -6, -90, -23, -25, -14, -14, -90, -19, -21, -6, -54, -25, -6, -25, -24, -25, -7, -21, -90, -20, -8, -11, -13, -90, -6, -18, -21, -90, -37, -49, -90, -6, -18, -8, -21, -25, -22, -89, -112, -126, -119, -126, Byte.MIN_VALUE, -111, 93, -79, -84, -88, -94, -85, -80, 107, -64, -69, -81, -84, -65, -80, -117, -29, -32, -13, -32, -31, -32, -14, -28, -112, -95, -112, -103, -97, -98, -116, -121, -125, 125, -122, -117};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized void A0J() {
        for (int i = 0; i < A0M().length; i++) {
        }
        if (this.A00 != null) {
            this.A00.close();
            this.A00 = null;
        }
    }

    static {
        A07();
        StringBuilder append = new StringBuilder().append(A05(107, 14, 44)).append(C1870fl.A03.A01);
        String A052 = A05(58, 2, 113);
        StringBuilder append2 = append.append(A052);
        String A053 = A05(142, 6, 7);
        StringBuilder append3 = append2.append(A053);
        String A054 = A05(60, 1, 31);
        StringBuilder append4 = append3.append(A054).append(C1870fl.A02.A01).append(A052);
        String A055 = A05(136, 6, 26);
        A05 = append4.append(A055).append(A054).append(C1877fs.A04.A01).append(A052).append(A055).append(A054).append(C1877fs.A05.A01).append(A052).append(A055).append(A054).append(C1877fs.A0A.A01).append(A052).append(A055).append(A054).append(C1877fs.A08.A01).append(A052).append(A055).append(A054).append(C1877fs.A07.A01).append(A052).append(A055).append(A054).append(C1877fs.A06.A01).append(A052).append(A055).append(A054).append(C1877fs.A03.A01).append(A052).append(A055).append(A054).append(C1877fs.A02.A01).append(A05(11, 6, 105)).append(A055).append(A05(17, 6, 78)).append(A053).append(A05(30, 4, 114)).append(A055).append(A054).append(C1877fs.A09.A01).append(A05(0, 3, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE)).append(A053).append(A054).append(C1870fl.A03.A01).append(A05(34, 10, 38)).append(A055).append(A054).append(C1877fs.A08.A01).append(A05(7, 4, 36)).toString();
        A08 = new ReentrantReadWriteLock();
        A06 = A08.readLock();
        A07 = A08.writeLock();
    }

    public TH(C1925ge c1925ge) {
        this.A01 = c1925ge;
    }

    private synchronized SQLiteDatabase A00() {
        if (this.A00 == null) {
            this.A00 = new TI(this.A01, this);
        }
        return this.A00.getWritableDatabase();
    }

    private synchronized SQLiteDatabase A01() {
        SQLiteException e = null;
        for (int i = 0; i < 10; i++) {
            try {
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
            }
        }
        this.A01.A08().ABC(A05(128, 8, 110), AbstractC1341Td.A0v, new C1342Te(e));
        throw e;
        return A00();
    }

    public final int A08(int i) {
        A07.lock();
        try {
            return A0E().delete(A05(136, 6, 26), C1877fs.A02.A01 + A05(3, 4, 60), new String[]{String.valueOf(i - 1)});
        } finally {
            A07.unlock();
        }
    }

    public final Cursor A09() {
        A06.lock();
        try {
            return this.A02.A0B();
        } finally {
            A06.unlock();
        }
    }

    public final Cursor A0A() {
        A06.lock();
        try {
            return this.A02.A0C();
        } finally {
            A06.unlock();
        }
    }

    public final Cursor A0B() {
        A06.lock();
        try {
            return this.A03.A0B();
        } finally {
            A06.unlock();
        }
    }

    public final Cursor A0C(int i) {
        A06.lock();
        try {
            return A0E().rawQuery(A05 + A05(23, 7, 45) + String.valueOf(i), null);
        } finally {
            A06.unlock();
        }
    }

    public final Cursor A0D(String str) {
        A06.lock();
        try {
            return this.A02.A0D(str);
        } finally {
            A06.unlock();
        }
    }

    public final SQLiteDatabase A0E() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return A01();
        }
        throw new IllegalStateException(A05(64, 43, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.TK != com.facebook.ads.internal.database.AdDatabaseQuery<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.UO != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<T> */
    public final <T> AsyncTask A0F(TK<T> tk, UO<T> uo) {
        return YD.A00(YG.A07, new TG(this.A01, tk, uo), new Void[0]);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.UO != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<java.lang.String> */
    public final AsyncTask A0G(final String str, final int i, final String str2, final double d, final double d2, final String str3, final Map<String, String> data, UO<String> uo) {
        return A0F(new AbstractC1837fE<String>() { // from class: com.facebook.ads.redexgen.X.75
            public static byte[] A08;
            public static String[] A09 = {"ZKW0rplATEIsE5gjt8qXTQnY", "r6HJdeSoORQdJfGxA0AnZWlkU33wQIlK", "lLZOtDHAe6uwMhK1fYaqg", "CFnqFcdcZfU1FaRsph1ThokBMpi4uqZk", "TONJvFd", "LRRDDC4", "oqOd7Km", ExifInterface.LONGITUDE_EAST};

            public static String A01(int i2, int i3, int i4) {
                byte[] copyOfRange = Arrays.copyOfRange(A08, i2, i2 + i3);
                for (int i5 = 0; i5 < copyOfRange.length; i5++) {
                    copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 122);
                }
                return new String(copyOfRange);
            }

            public static void A02() {
                byte[] bArr = {56, 53, 72, 53, 54, 53, 71, 57};
                if (A09[2].length() == 32) {
                    throw new RuntimeException();
                }
                A09[2] = "0lpDBp9tBU8jLddyd5eWZp";
                A08 = bArr;
            }

            static {
                A02();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.TK
            /* renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final String A03() {
                C1925ge c1925ge;
                Lock lock;
                Lock lock2;
                C1925ge c1925ge2;
                C1925ge c1925ge3;
                Lock lock3;
                C1925ge c1925ge4;
                C1877fs c1877fs;
                C1870fl c1870fl;
                Lock lock4;
                C1925ge c1925ge5;
                String eventId = A01(0, 8, 90);
                c1925ge = TH.this.A01;
                c1925ge.A08().AA3(str2);
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                lock = TH.A07;
                lock.lock();
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        sQLiteDatabase = TH.this.A0E();
                        sQLiteDatabase.beginTransaction();
                        c1877fs = TH.this.A02;
                        c1870fl = TH.this.A03;
                        String A0E = c1877fs.A0E(c1870fl.A0C(str), i, str2, d, d2, str3, data);
                        sQLiteDatabase.setTransactionSuccessful();
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            try {
                                if (sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                            } catch (Exception e) {
                                c1925ge5 = TH.this.A01;
                                c1925ge5.A08().ABC(eventId, AbstractC1341Td.A0z, new C1342Te(e));
                            }
                        }
                        lock4 = TH.A07;
                        lock4.unlock();
                        return A0E;
                    } catch (Exception e2) {
                        A01(TJ.A05);
                        c1925ge3 = TH.this.A01;
                        c1925ge3.A08().ABC(eventId, AbstractC1341Td.A0y, new C1342Te(e2));
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            try {
                                if (sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                            } catch (Exception e3) {
                                c1925ge4 = TH.this.A01;
                                c1925ge4.A08().ABC(eventId, AbstractC1341Td.A0z, new C1342Te(e3));
                            }
                        }
                        lock3 = TH.A07;
                        lock3.unlock();
                        return null;
                    }
                } catch (Throwable th) {
                    if (sQLiteDatabase != null) {
                        boolean isOpen = sQLiteDatabase.isOpen();
                        if (A09[5].length() != 7) {
                            throw new RuntimeException();
                        }
                        A09[2] = "rWG930h";
                        if (isOpen) {
                            try {
                                if (sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                            } catch (Exception e4) {
                                c1925ge2 = TH.this.A01;
                                c1925ge2.A08().ABC(eventId, AbstractC1341Td.A0z, new C1342Te(e4));
                            }
                        }
                    }
                    lock2 = TH.A07;
                    lock2.unlock();
                    throw th;
                }
            }
        }, uo);
    }

    public final void A0H() {
        A07.lock();
        try {
            this.A02.A09();
            this.A03.A09();
        } finally {
            A07.unlock();
        }
    }

    public final void A0I() {
        A07.lock();
        try {
            this.A03.A0D(this.A01);
        } finally {
            A07.unlock();
        }
    }

    public final boolean A0K(String str) {
        A07.lock();
        try {
            return this.A02.A0F(str);
        } finally {
            A07.unlock();
        }
    }

    public final boolean A0L(String str) {
        boolean z;
        A07.lock();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(A05(Sdk.SDKError.Reason.TPAT_ERROR_VALUE, 7, 90)).append(A05(136, 6, 26)).append(A05(44, 5, 36)).append(C1877fs.A02.A01).append(A05(61, 1, 32)).append(C1877fs.A02.A01).append(A05(56, 2, 50)).append(A05(49, 7, 92)).append(C1877fs.A04.A01).append(A05(62, 2, 77));
            A0E().execSQL(sb.toString(), new String[]{str});
            z = true;
        } catch (SQLiteException unused) {
            z = false;
        }
        A07.unlock();
        return z;
    }

    public final TL[] A0M() {
        return new TL[]{this.A03, this.A02};
    }
}
