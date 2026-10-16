package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Pd, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1242Pd implements InterfaceC1567aq {
    public static byte[] A01;
    public final /* synthetic */ ViewOnClickListenerC07906x A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 72);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-36, -38, -52, -39, -58, -55, -36, -51, -51, -52, -39, -52, -53, -58, -54, -45, -48, -54, -46, -58, -48, -56, -55, -58, -43, -56, -35, -48, -50, -56, -37, -48, -42, -43};
    }

    public C1242Pd(ViewOnClickListenerC07906x viewOnClickListenerC07906x) {
        this.A00 = viewOnClickListenerC07906x;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AF7(String str) {
        this.A00.A0C.setProgress(100);
        ((PZ) this.A00).A05 = false;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AF9(String str) {
        int i;
        ((PZ) this.A00).A05 = true;
        this.A00.A0F.setUrl(str);
        i = this.A00.A00;
        if (i > 1) {
            this.A00.A0I(A00(0, 34, 31));
        }
        ViewOnClickListenerC07906x.A02(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AFY(int i) {
        if (((PZ) this.A00).A05) {
            this.A00.A0C.setProgress(i);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AFb(String str) {
        this.A00.A0F.setTitle(str);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AFe() {
        this.A00.A0B.ADJ(14);
    }
}
