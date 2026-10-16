package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.Sf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1317Sf {
    public static String A00;
    public static byte[] A01;
    public static String[] A02 = {"jP5DLqFPT2uLfDhjwGtyJ", "b2Kf1V0V33xxSFNxYAUwKzTnuvA5CTmH", "utws2CXgYjyIi4p9N5JN7AtJgUuBwVKL", "iHkd", "J1QCfiNfulUMnwHMV72QByuh5OrpyBC4", "Ilbx2HAT56j3G7gTz5Evg9nZeC6mk12l", "SrkakodA8D", "LiqB"};
    public static final String A03;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static SX A02(T8 t8) {
        Object A002;
        Method A022;
        Object A003;
        Method A023 = AbstractC1318Sg.A02(A00, A04(257, 29, 2), Context.class);
        if (A023 == null || (A002 = AbstractC1318Sg.A00(null, A023, t8)) == null || ((Integer) A002).intValue() != 0 || (A022 = AbstractC1318Sg.A02(A04(65, 57, 83), A04(232, 20, 98), Context.class)) == null || (A003 = AbstractC1318Sg.A00(null, A022, t8)) == null) {
            return null;
        }
        Method A012 = AbstractC1318Sg.A01(A003.getClass(), A04(252, 5, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE), new Class[0]);
        Method A013 = AbstractC1318Sg.A01(A003.getClass(), A04(286, 24, 126), new Class[0]);
        if (A012 == null || A013 == null) {
            return null;
        }
        String str = (String) AbstractC1318Sg.A00(A003, A012, new Object[0]);
        Boolean bool = (Boolean) AbstractC1318Sg.A00(A003, A013, new Object[0]);
        if (str != null) {
            return new SX(str, bool != null && bool.booleanValue(), SW.A06);
        }
        return null;
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 90);
            if (A02[7].length() != 4) {
                throw new RuntimeException();
            }
            A02[0] = "KHgMerLXVce8bYpnKoYEO";
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{102, 68, 75, 75, 74, 81, 5, 66, SignedBytes.MAX_POWER_OF_TWO, 81, 5, 68, 65, 83, SignedBytes.MAX_POWER_OF_TWO, 87, 81, 76, 86, 76, 75, 66, 5, 76, 75, 67, 74, 5, 74, 75, 5, 72, 68, 76, 75, 5, 81, 77, 87, SignedBytes.MAX_POWER_OF_TWO, 68, 65, Ascii.VT, 88, 84, 86, Ascii.NAK, 92, 84, 84, 92, 87, 94, Ascii.NAK, 90, 85, 95, 73, 84, 82, 95, Ascii.NAK, 92, 86, 72, 106, 102, 100, 39, 110, 102, 102, 110, 101, 108, 39, 104, 103, 109, 123, 102, 96, 109, 39, 110, 100, 122, 39, 104, 109, 122, 39, 96, 109, 108, 103, 125, 96, 111, 96, 108, 123, 39, 72, 109, Byte.MAX_VALUE, 108, 123, 125, 96, 122, 96, 103, 110, SignedBytes.MAX_POWER_OF_TWO, 109, 74, 101, 96, 108, 103, 125, 38, 42, 40, 107, 34, 42, 42, 34, 41, 32, 107, 36, 43, 33, 55, 42, 44, 33, 107, 34, 40, 54, 107, 36, 33, 54, 107, 44, 33, 32, 43, 49, 44, 35, 44, 32, 55, 107, 54, 32, 55, 51, 44, 38, 32, 107, Ascii.SYN, 17, 4, Ascii.ETB, 17, 53, 57, 59, 120, 49, 57, 57, 49, 58, 51, 120, 55, 56, 50, 36, 57, 63, 50, 120, 49, 59, 37, 120, 53, 57, 59, 59, 57, 56, 120, 17, 57, 57, 49, 58, 51, 6, 58, 55, 47, 5, 51, 36, 32, 63, 53, 51, 37, 3, 34, 63, 58, 116, 118, 125, 118, 97, 122, 112, 95, 93, 76, 121, 92, 78, 93, 74, 76, 81, 75, 81, 86, 95, 113, 92, 113, 86, 94, 87, 65, 67, 82, 111, 66, 49, 43, Ascii.US, 55, 55, 63, 52, Base64.padSymbol, 8, 52, 57, 33, Ascii.VT, Base64.padSymbol, 42, 46, 49, 59, Base64.padSymbol, 43, Ascii.EM, 46, 57, 49, 52, 57, 58, 52, Base64.padSymbol, 77, 87, 104, 77, 73, 77, 80, 101, SignedBytes.MAX_POWER_OF_TWO, 112, 86, 69, 71, 79, 77, 74, 67, 97, 74, 69, 70, 72, 65, SignedBytes.MAX_POWER_OF_TWO};
    }

    static {
        A05();
        A03 = SX.class.getSimpleName();
        A00 = A04(173, 52, 12);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
    
        if (r3 != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SX A00(T8 t8) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            SX A012 = A01(t8);
            if (A012 != null) {
                boolean isEmpty = TextUtils.isEmpty(A012.A03());
                if (A02[5].charAt(3) != 'x') {
                    throw new RuntimeException();
                }
                A02[0] = "hh0RZKDdPPlAkARzc3g59";
            }
            A012 = A02(t8);
            if (A012 == null || TextUtils.isEmpty(A012.A03())) {
                return A03(t8);
            }
            return A012;
        }
        throw new IllegalStateException(A04(0, 43, 127));
    }

    public static SX A01(T8 t8) {
        TC adId = t8.A05().A8x();
        if (adId != null) {
            return new SX(adId.getId(), adId.AAX(), SW.A02);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.facebook.ads.internal.attribution.GmsAttributionProvider$GoogleAdInfo] */
    public static SX A03(T8 t8) {
        ServiceConnectionC1316Se serviceConnectionC1316Se = new ServiceConnectionC1316Se();
        Intent intent = new Intent(A04(Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, 51, 31));
        intent.setPackage(A04(43, 22, 97));
        if (t8.bindService(intent, serviceConnectionC1316Se, 1)) {
            try {
                final IBinder A022 = serviceConnectionC1316Se.A02();
                ?? r0 = new IInterface(A022) { // from class: com.facebook.ads.internal.attribution.GmsAttributionProvider$GoogleAdInfo
                    public static byte[] A01;
                    public static String[] A02 = {"CGAQp5QWLLSg2Up0KS3Xu0sm6KBD8ljy", "Yp64XCOUL3mdw2EQzsnOwJCP4iXogchF", "0bXbaFV76JbdIHYzvJ", "7kYBXtp0pJ6J2QiQOtBXkhx4Mjb4MhNb", "Pqj6DcWbIXVdg5nys55lljt7m2mFJmbz", "gqs8Z9zjV1B", "yb2LGnYLr1jAVzG6", "kQWFHy19WQfgSFrPEiRm4PYEBX"};
                    public IBinder A00;

                    public static String A00(int i, int i2, int i3) {
                        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
                        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
                            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 103);
                        }
                        return new String(copyOfRange);
                    }

                    public static void A01() {
                        A01 = new byte[]{100, 104, 106, 41, 96, 104, 104, 96, 107, 98, 41, 102, 105, 99, 117, 104, 110, 99, 41, 96, 106, 116, 41, 102, 99, 116, 41, 110, 99, 98, 105, 115, 110, 97, 110, 98, 117, 41, 110, 105, 115, 98, 117, 105, 102, 107, 41, 78, 70, 99, 113, 98, 117, 115, 110, 116, 110, 105, 96, 78, 99, 84, 98, 117, 113, 110, 100, 98};
                    }

                    static {
                        A01();
                    }

                    {
                        this.A00 = A022;
                    }

                    public final String A02() throws RemoteException {
                        Parcel obtain = Parcel.obtain();
                        Parcel obtain2 = Parcel.obtain();
                        try {
                            obtain.writeInterfaceToken(A00(0, 68, 96));
                            this.A00.transact(1, obtain, obtain2, 0);
                            obtain2.readException();
                            String readString = obtain2.readString();
                            if (readString != null) {
                                return readString;
                            }
                            if (A02[2].length() == 16) {
                                throw new RuntimeException();
                            }
                            A02[3] = "0APG8T86KeB7s6esCzOnlOcV6mb8f0OX";
                            return A00(0, 0, 82);
                        } finally {
                            obtain2.recycle();
                            obtain.recycle();
                        }
                    }

                    public final boolean A03() throws RemoteException {
                        Parcel obtain = Parcel.obtain();
                        Parcel obtain2 = Parcel.obtain();
                        try {
                            obtain.writeInterfaceToken(A00(0, 68, 96));
                            boolean z = true;
                            obtain.writeInt(1);
                            this.A00.transact(2, obtain, obtain2, 0);
                            obtain2.readException();
                            if (obtain2.readInt() == 0) {
                                z = false;
                            }
                            return z;
                        } finally {
                            obtain2.recycle();
                            obtain.recycle();
                        }
                    }

                    @Override // android.os.IInterface
                    public final IBinder asBinder() {
                        return this.A00;
                    }
                };
                return new SX(r0.A02(), r0.A03(), SW.A07);
            } catch (Throwable th) {
                try {
                    t8.A08().ABC(A04(Sdk.SDKError.Reason.BIDPAYLOAD_PLACEMENT_ID_MISMATCH_ERROR_VALUE, 7, 73), AbstractC1341Td.A1Q, new C1342Te(th));
                } finally {
                    t8.unbindService(serviceConnectionC1316Se);
                }
            }
        }
        return null;
    }
}
