package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.r5, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2521r5 {
    public static C2521r5 A03;
    public static InterfaceC2544rX A04;
    public static byte[] A05;
    public static String[] A06 = {"5DKKU3xZINN65fryyoBt5QQPLIMTkohn", "LFzimA69beWaSFXyztzupLxdNfHOQ", "XSuolM5aqTyza3oApgyv2R2QmsMDCJc3", "zWK24MgLV", "4", "qJClZMWv8", "0fmkfxUqb1vnRdlz6H0UDHtVT1WIbpOa", "oRXxD"};
    public final ViewpointQeConfig A00;
    public final ViewpointRegistry A01;
    public final C2531rF A02;

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = copyOfRange[i4];
            if (A06[4].length() == 19) {
                throw new RuntimeException();
            }
            A06[6] = "At1Zr1oMV19x7NxsOWFoG9shzyjt72Ks";
            copyOfRange[i4] = (byte) ((b - i3) - 7);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{-89, -74, -87, -91, -72, -87};
    }

    static {
        A03();
        A03 = null;
        A04 = null;
    }

    public C2521r5(ViewpointQeConfig viewpointQeConfig, AbstractC2536rL abstractC2536rL, C2531rF c2531rF, ViewpointRegistry viewpointRegistry) {
        this.A00 = viewpointQeConfig;
        this.A01 = viewpointRegistry;
        this.A02 = c2531rF;
        abstractC2536rL.A03(new C0866Aj(c2531rF));
    }

    public static ScanDelayController A00(int i) {
        if (0 == 0) {
            return null;
        }
        throw new NullPointerException(A02(0, 6, 61));
    }

    public static C2521r5 A01(ViewpointQeConfig viewpointQeConfig, AbstractC2536rL abstractC2536rL, InterfaceC2541rQ interfaceC2541rQ, InterfaceC0867Al interfaceC0867Al, ViewpointAutoOcclusion viewpointAutoOcclusion) {
        C2521r5 c2521r5 = A03;
        if (c2521r5 != null) {
            return c2521r5;
        }
        ViewpointRegistry viewpointRegistry = new ViewpointRegistry(viewpointQeConfig);
        CK ck = CK.A00;
        Handler handler = new Handler(Looper.getMainLooper());
        A00(100);
        return new C2521r5(viewpointQeConfig, abstractC2536rL, new C2531rF(viewpointQeConfig, interfaceC2541rQ, ck, interfaceC0867Al, viewpointRegistry, viewpointAutoOcclusion, handler, null), viewpointRegistry);
    }

    public final void A04(InterfaceC2535rK interfaceC2535rK) {
        this.A02.A0H(interfaceC2535rK);
    }

    public final void A05(InterfaceC2533rI interfaceC2533rI) {
        this.A02.A0I(interfaceC2533rI);
    }

    public final void A06(DspViewableNode dspViewableNode) {
        A07(dspViewableNode, null);
    }

    public final void A07(DspViewableNode dspViewableNode, C2542rU c2542rU) {
        if (this.A00.A00 && c2542rU != null) {
            this.A01.A06(dspViewableNode, c2542rU);
        } else {
            this.A01.A05(dspViewableNode);
        }
    }

    public final void A08(DspViewableNode dspViewableNode, C2542rU c2542rU, C2538rN c2538rN) {
        if (this.A00.A00 && c2542rU != null) {
            this.A01.A07(dspViewableNode, c2542rU, c2538rN);
        } else {
            this.A01.A08(dspViewableNode, c2538rN);
        }
    }

    public final void A09(DspViewableNode dspViewableNode, C2538rN c2538rN) {
        A08(dspViewableNode, null, c2538rN);
    }
}
