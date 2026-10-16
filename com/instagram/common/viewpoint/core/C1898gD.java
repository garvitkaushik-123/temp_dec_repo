package com.instagram.common.viewpoint.core;

import android.provider.Settings;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.unity3d.services.UnityAdsConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.gD, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1898gD {
    public static InterfaceC1878ft A00;
    public static byte[] A01;
    public static final Set<String> A02;
    public static final Set<String> A03;
    public static final AtomicBoolean A04;

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 29);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A01 = new byte[]{51, 114, 121, 9, 84, 69, 113, 55, 55, 120, 5, 112, 1, Ascii.EM, 51, Ascii.DC2, 114, 47, Ascii.CAN, 117, 44, 46, 36, 43, 114, 40, 55, 48, 114, Ascii.NAK, 47, 51, 43, 125, 74, 63, 96, 71, 122, 102, 66, Byte.MAX_VALUE, 106, 97, 126, 98, 39, 91, 97, 106, 72, 100, 122, 126, 62, 101, 90, 100, 35, 117, 94, Byte.MAX_VALUE, 49, 6, 81, 35, 43, 66, 103, 86, 39, 106, 95, 80, 119, Byte.MAX_VALUE, 122, 39, 97, 99, 103, 106, 98, 82, 86, 112, 105, 75, 92, 118, 82, 46, Ascii.EM, 88, 115, 98, 97, 121, 100, 125, Byte.MAX_VALUE, 120, 113, 54, 116, 115, 112, 121, 100, 115, 54, Byte.MAX_VALUE, 120, Byte.MAX_VALUE, 98, 55, 83, 81, 83, 66, Base64.padSymbol, 106, 101, 81, 105, 111, SignedBytes.MAX_POWER_OF_TWO, 109, 32, Byte.MAX_VALUE, 106, 94, 89, 111, 101, 114, 94, 67, 62, 98, 123, 108, 70, 54, 1, Ascii.SI, 7, Ascii.FS, Ascii.RS, 2, Ascii.SI, 0, Ascii.VT, 49, 3, 1, 10, Ascii.VT, 49, 1, 0, Ascii.GS, Ascii.SYN, 7, 4, Ascii.FS, 1, Ascii.CAN, 33, 58, Ascii.SI, 103, Ascii.DC2, 7, 59, 7, 63, Ascii.SYN, 108, 5, 96, 3, 3, 0, 49, Ascii.SYN, 37, Ascii.SUB, 39, 19, Ascii.GS, 109, 57, 51, 4, 104, 95};
    }

    static {
        A07();
        A02 = new HashSet();
        A03 = new HashSet();
        A02.add(A05(6, 29, 93));
        A03.add(A05(168, 29, 72));
        A03.add(A05(35, 29, 17));
        A03.add(A05(64, 29, 14));
        A03.add(A05(116, 29, 22));
        A04 = new AtomicBoolean();
    }

    public static InterfaceC1880fv A00(T8 t8) {
        return A03(true, t8);
    }

    public static InterfaceC1880fv A01(T8 t8) {
        return A02(true, t8);
    }

    public static InterfaceC1880fv A02(boolean z, T8 t8) {
        C1884fz c1884fz = new C1884fz();
        C1887g2 networkModuleRequestConfigurationBuilder = A04(t8);
        if (!A0B(t8)) {
            c1884fz.A02(A03);
            c1884fz.A01(A02);
        }
        if (XD.A04()) {
            networkModuleRequestConfigurationBuilder.A08(XD.A02());
        }
        C0925Cv A002 = AbstractC1882fx.A00();
        C1884fz networkModuleConfigurationBuilder = c1884fz.A00(networkModuleRequestConfigurationBuilder.A09());
        return A002.A00(networkModuleConfigurationBuilder.A03(z).A04(t8.A05().AAO()).A05(), t8.A08(), YG.A01());
    }

    public static InterfaceC1880fv A03(boolean z, T8 t8) {
        return AbstractC1882fx.A00().A00(new C1884fz().A03(z).A00(A04(t8).A09()).A04(t8.A05().AAO()).A05(), t8.A08(), YG.A01());
    }

    public static C1887g2 A04(T8 t8) {
        A08(t8);
        C1887g2 c1887g2 = new C1887g2();
        if (A0B(t8) || XD.A04()) {
            c1887g2.A02(360000).A04(UnityAdsConstants.RequestPolicy.RETRY_MAX_DURATION);
        } else {
            c1887g2.A02(C1379Up.A09(t8)).A04(C1379Up.A0B(t8));
        }
        c1887g2.A03(C1379Up.A0A(t8)).A05(C1379Up.A0C(t8)).A06(C1379Up.A0D(t8));
        synchronized (C1898gD.class) {
            if (A00 != null && (A00 instanceof InterfaceC1878ft)) {
                c1887g2.A07(A00);
            }
        }
        return c1887g2;
    }

    public static void A06() {
        A04.set(true);
    }

    public static void A08(T8 t8) {
        if (!A04.get()) {
            t8.A08().ABC(A05(161, 7, 110), AbstractC1341Td.A21, new C1342Te(A05(93, 23, 11)));
        }
    }

    public static synchronized void A09(InterfaceC1878ft interfaceC1878ft) {
        synchronized (C1898gD.class) {
            A00 = interfaceC1878ft;
        }
    }

    public static boolean A0A(T8 t8) {
        return Settings.Global.getInt(t8.getContentResolver(), A05(145, 16, 115), 0) != 0;
    }

    public static boolean A0B(T8 t8) {
        String A9Q = t8.A05().A9Q();
        if (!TextUtils.isEmpty(A9Q)) {
            String urlPrefix = A05(3, 3, 58);
            if (!A9Q.endsWith(urlPrefix)) {
                String urlPrefix2 = A05(0, 3, 0);
                if (A9Q.endsWith(urlPrefix2)) {
                }
            }
            return true;
        }
        return false;
    }
}
