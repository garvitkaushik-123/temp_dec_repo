package com.instagram.common.viewpoint.core;

import android.view.View;
import io.bidmachine.media3.common.PlaybackException;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* renamed from: com.facebook.ads.redexgen.X.Ao, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C0869Ao implements SharedViewpointManager {
    public static boolean A07;
    public static byte[] A08;
    public InterfaceC2545rY A00;
    public InterfaceC2533rI A01;
    public C2521r5 A02;
    public final InterfaceC2534rJ A04;
    public final ViewpointQeConfig A05;
    public final LinkedHashMap<Integer, Runnable> A06 = new LinkedHashMap<>();
    public final InterfaceC2533rI A03 = new C0870Ap(this);

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) + PlaybackException.ERROR_CODE_NOT_AVAILABLE_IN_REGION);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A08 = new byte[]{-28};
    }

    static {
        A04();
        A07 = false;
    }

    public C0869Ao(ViewpointQeConfig viewpointQeConfig, InterfaceC2545rY interfaceC2545rY, InterfaceC2534rJ interfaceC2534rJ) {
        this.A05 = viewpointQeConfig;
        this.A00 = interfaceC2545rY;
        this.A04 = interfaceC2534rJ;
    }

    public static C0869Ao A01() {
        return new C0869Ao(new ViewpointQeConfig(), new C0872Ar(), null);
    }

    private void A05(AbstractC2536rL abstractC2536rL, InterfaceC2541rQ interfaceC2541rQ, InterfaceC0867Al interfaceC0867Al, ViewpointAutoOcclusion viewpointAutoOcclusion) {
        this.A02 = C2521r5.A01(this.A05, abstractC2536rL, interfaceC2541rQ, interfaceC0867Al, viewpointAutoOcclusion);
        if (0 != 0) {
            this.A02.A04(null);
        }
        this.A02.A05(this.A03);
    }

    private void A06(DspViewableNode dspViewableNode, C2542rU c2542rU) {
        C2521r5 c2521r5 = this.A02;
        if (c2521r5 != null && dspViewableNode != null) {
            if (this.A05.A00 && c2542rU != null) {
                c2521r5.A07(dspViewableNode, c2542rU);
            } else {
                c2521r5.A06(dspViewableNode);
            }
        }
    }

    private void A07(DspViewableNode dspViewableNode, C2542rU c2542rU, C2538rN c2538rN) {
        C2521r5 c2521r5 = this.A02;
        if (c2521r5 != null && dspViewableNode != null && c2538rN != null) {
            if (this.A05.A00 && c2542rU != null) {
                c2538rN.A02 = dspViewableNode.hashCode() + A02(0, 1, 27) + c2538rN.A08 + c2542rU;
                c2521r5.A08(dspViewableNode, c2542rU, c2538rN);
            } else {
                c2521r5.A09(dspViewableNode, c2538rN);
            }
        }
    }

    public final void A08(View view) {
        A06(view != null ? ViewpointViewNode.A00(view) : null, null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<?, ?> */
    public final void A09(View view, C2538rN<?, ?> c2538rN) {
        A07(view != null ? ViewpointViewNode.A00(view) : null, null, c2538rN);
    }

    public final void A0A(AbstractC2536rL abstractC2536rL, View view) {
        if (abstractC2536rL != null && view != null) {
            A05(abstractC2536rL, new C0871Aq(view, this.A00), new C06611u(null), null);
        }
    }
}
