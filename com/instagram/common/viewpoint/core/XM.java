package com.instagram.common.viewpoint.core;

import android.graphics.Rect;

/* loaded from: assets/audience_network/classes2.dex */
public final class XM {
    public static String[] A02 = {"P6MYZTOvDAaFen8GvswQ7TN6uAA4LWVv", "hYZBnkN7eg3Goj1fCi2fLRcc1xaBLP0T", "hgTfm2gsKyXruwHhjUk", "Xl5p6SNgJSz0NngEgDitAc249tQNQ8ta", "gXDmJbn0MXLGD1TV1woO3x4WUye", "irvXIfdrm7YhWQVUx8qen3XIyPBMomv3", "r42H5ZZ7hG", "IBnhtff"};
    public final Rect A00 = new Rect();
    public final Rect A01 = new Rect();

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    public static boolean A00(C2538rN<C1386Uw, V1> c2538rN) {
        if (c2538rN.A06.A05()) {
            return c2538rN.A07.A07();
        }
        if (!c2538rN.A06.A06()) {
            return true;
        }
        return c2538rN.A07.A06();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
    
        if ((r6.A00.bottom - r6.A00.top) > 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0070, code lost:
    
        r4 = r6.A01.bottom;
        r3 = r6.A00.top;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
    
        if (com.instagram.common.viewpoint.core.XM.A02[7].length() == 7) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0089, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009d, code lost:
    
        com.instagram.common.viewpoint.core.XM.A02[1] = "8dStYXDidh9UFB7oEkGa7ohf6JNszk5F";
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a5, code lost:
    
        if ((r4 - r3) <= 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a7, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009b, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0098, code lost:
    
        if ((r6.A00.bottom - r6.A00.top) > 0) goto L22;
     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean A01(C2538rN<C1386Uw, V1> c2538rN, InterfaceC2529rD interfaceC2529rD) {
        boolean z;
        float f = -1.0f;
        try {
            f = interfaceC2529rD.A9X(c2538rN);
        } catch (IllegalStateException unused) {
        }
        if (A02[6].length() == 7) {
            throw new RuntimeException();
        }
        A02[5] = "l0GJDJ6h98NWCV6pJLy8cxtVoo076bMe";
        if (f > 0.0f && A00(c2538rN)) {
            return true;
        }
        if (c2538rN.A06.A00().getGlobalVisibleRect(this.A01) && this.A01.bottom - this.A01.top > 0 && A00(c2538rN)) {
            return true;
        }
        interfaceC2529rD.A9W(this.A00);
        if (A02[2].length() != 2) {
            A02[2] = "WH3ZGQ";
            interfaceC2529rD.A8D(c2538rN, this.A01);
        } else {
            interfaceC2529rD.A8D(c2538rN, this.A01);
        }
        return z && A00(c2538rN);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    public final void A02(C2538rN<C1386Uw, V1> c2538rN, InterfaceC2529rD interfaceC2529rD) {
        if (c2538rN.A07.A04() && A01(c2538rN, interfaceC2529rD)) {
            c2538rN.A07.A01();
            c2538rN.A06.A02().ABx(c2538rN.A06.A03(), c2538rN.A06.A04());
        }
        if (c2538rN.A07.A05() && C1379Up.A1l(c2538rN.A06.A01())) {
            c2538rN.A07.A02();
            c2538rN.A06.A02().ABL(c2538rN.A06.A03(), c2538rN.A06.A04());
        }
    }
}
