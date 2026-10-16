package com.instagram.common.viewpoint.core;

import android.content.Context;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public final class ZR implements TA {
    public static ZR A07;
    public static byte[] A08;
    public InterfaceC1159Lx A00;
    public T1 A01;
    public T9 A02;
    public TP A03;
    public U7 A04;
    public VM A05;
    public CY A06;

    static {
        A07();
    }

    public static String A06(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 118);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A08 = new byte[]{44, 62, 76, 76, 66, 72, 71, -7, Base64.padSymbol, 58, 77, 58, -7, 66, 71, 66, 77, 66, 58, 69, 66, 83, 62, Base64.padSymbol, Ascii.FS, -13, -19, 32, Ascii.ESC, -15, Ascii.FS, Ascii.SI, Ascii.SUB, Ascii.EM, Ascii.FS, Ascii.RS, -3, Ascii.SI, Ascii.GS, Ascii.GS, 19, Ascii.EM, Ascii.CAN, -18, Ascii.VT, Ascii.RS, Ascii.VT, -13, Ascii.CAN, 19, Ascii.RS, 19, Ascii.VT, Ascii.SYN, 19, 36, Ascii.SI, Ascii.SO};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized void A0C(C1925ge c1925ge) {
        if (this.A06 != null) {
            return;
        }
        this.A03 = A01(c1925ge);
        this.A06 = A05(c1925ge, this.A03, A03(c1925ge));
        A09(c1925ge, A00(c1925ge, this.A06));
        A0A(c1925ge, this.A06);
        A0B(c1925ge, this.A06);
        if (this.A06 != null) {
            this.A06.A6d();
        }
    }

    public static SR A00(C1925ge c1925ge, CY cy) {
        if (!C1379Up.A1r(c1925ge) || cy == null) {
            return null;
        }
        return SS.A00().A00(cy);
    }

    public static TP A01(C1925ge c1925ge) {
        return TQ.A00().A00(c1925ge, new C1628bp());
    }

    public static synchronized ZR A02() {
        ZR zr;
        synchronized (ZR.class) {
            if (A07 == null) {
                A07 = new ZR();
            }
            zr = A07;
        }
        return zr;
    }

    public static InterfaceC1880fv A03(C1925ge c1925ge) {
        if (!C1379Up.A1n(c1925ge)) {
            return null;
        }
        return C1898gD.A01(c1925ge);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.TA
    /* renamed from: A04, reason: merged with bridge method [inline-methods] */
    public final synchronized CY A9F() {
        return this.A06;
    }

    public static CY A05(C1925ge c1925ge, TP tp, InterfaceC1880fv interfaceC1880fv) {
        if (!C1379Up.A2m(c1925ge) || interfaceC1880fv == null || ProcessUtils.isRemoteRenderingProcess()) {
            return null;
        }
        return AbstractC1921ga.A00().A00(c1925ge, tp, interfaceC1880fv, WI.A04(c1925ge), new ZW(new WA(c1925ge, A06(0, 0, 9), null, EnumC1404Vq.A08, 0, new C1408Vu(), AbstractC1456Xt.A01(C1379Up.A0N(c1925ge)), null, null, new C2048ij()), c1925ge), C1919gY.A00().A00());
    }

    public static void A08() {
        AbstractC1412Vy.A05(A06(30, 28, 52), A06(0, 24, 99), A06(24, 6, 68));
    }

    public static void A09(C1925ge c1925ge, SR sr) {
        if (!C1379Up.A1r(c1925ge) || sr == null) {
            return;
        }
        SP.A00().A00(sr, c1925ge);
    }

    public static void A0A(C1925ge c1925ge, CY cy) {
        if (!C1379Up.A0m(c1925ge) || cy == null) {
            return;
        }
        new C1324Sm(c1925ge, cy, new C1325Sn(), DynamicLoaderImpl.getBidderTokenProviderApi().A00());
    }

    public static void A0B(C1925ge c1925ge, CY cy) {
        if (cy == null) {
            return;
        }
        AbstractC1383Ut.A00(c1925ge, cy);
    }

    @Override // com.instagram.common.viewpoint.core.TA
    public final VA A6n(C1925ge c1925ge) {
        return WW.A01(c1925ge);
    }

    @Override // com.instagram.common.viewpoint.core.TA
    public final synchronized T9 A74(T8 t8) {
        if (this.A02 == null) {
            this.A02 = new C1495Zg(this);
        }
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.TA
    public final synchronized T1 A7G() {
        if (this.A01 == null) {
            this.A01 = new C1930gj();
        }
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.TA
    public final synchronized TP A7l(T8 t8) {
        if (this.A03 == null) {
            this.A03 = A01(t8.A02());
        }
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.TA
    public final synchronized InterfaceC1340Tc A7n(T8 t8) {
        return new C1823f0(t8);
    }

    @Override // com.instagram.common.viewpoint.core.TA
    public final synchronized TB A7x(final T8 t8) {
        return new AbstractC1627bo(t8) { // from class: com.facebook.ads.redexgen.X.72
            @Override // com.instagram.common.viewpoint.core.TB
            public final boolean A9m() {
                return TextureViewSurfaceTextureListenerC0929Cz.A09();
            }

            @Override // com.instagram.common.viewpoint.core.TB
            public final void ACP() {
                U2.A06(C1302Rp.A09(super.A00));
            }

            @Override // com.instagram.common.viewpoint.core.TB
            public final void ACn() {
                U2.A07(C1302Rp.A09(super.A00));
            }

            @Override // com.instagram.common.viewpoint.core.TB
            public final void ADI(C1925ge c1925ge) {
                OP.A01(c1925ge);
            }
        };
    }

    @Override // com.instagram.common.viewpoint.core.TA
    public final synchronized InterfaceC1159Lx A8C(T8 t8) {
        if (!C1379Up.A13(t8)) {
            return null;
        }
        if (this.A00 == null) {
            this.A00 = AbstractC1160Ly.A00().A00(new C1591bE(t8));
        }
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.TA
    public final synchronized TD A8y(T8 t8) {
        return new C1565ao(t8);
    }

    @Override // com.instagram.common.viewpoint.core.TA
    public final C1925ge A8z(Context context) {
        C1925ge sdkContext = T7.A00();
        if (sdkContext == null) {
            C1925ge sdkContext2 = new C1925ge(context, this);
            T7.A01(sdkContext2);
            return sdkContext2;
        }
        return sdkContext;
    }

    @Override // com.instagram.common.viewpoint.core.TA
    public final synchronized VM A90(C1925ge c1925ge) {
        if (this.A05 == null) {
            this.A05 = new XP(c1925ge);
        }
        return this.A05;
    }

    @Override // com.instagram.common.viewpoint.core.TA
    public final synchronized U7 A96() {
        if (this.A04 == null) {
            this.A04 = new U7();
            A08();
        }
        return this.A04;
    }
}
