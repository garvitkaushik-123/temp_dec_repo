package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Ma, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1162Ma implements InterfaceC1778eG {
    public static byte[] A01;
    public static String[] A02 = {"eg4OuzmozbdBw8OpfnEQ9S5WXV0sj4Z8", "rcCmLv", "J9fwVwM4lsi34p", "AlJIDEMCKinwW9CsIljPKEg77fEpV28V", "eGLouwRxqegMv8vZbxB0WI", "SMn3POGOAwCpVf", "x8sqAERQ", "K7z6bhBLHSjzf8oEEyEGbL"};
    public final /* synthetic */ MW A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 114);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-22, -24, -38, -25, -40, -31, -34, -40, -32};
    }

    static {
        A01();
    }

    public C1162Ma(MW mw) {
        this.A00 = mw;
    }

    public /* synthetic */ C1162Ma(MW mw, C1174Mm c1174Mm) {
        this(mw);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1778eG
    public final void ADX() {
        this.A00.A0V(true, A00(0, 9, 3));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1778eG
    public final void AEA() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1778eG
    public final void AEh() {
        C1201No c1201No;
        AtomicBoolean atomicBoolean;
        c1201No = this.A00.A0H;
        if (!c1201No.A0b()) {
            this.A00.A0N();
            return;
        }
        MW mw = this.A00;
        String[] strArr = A02;
        if (strArr[3].charAt(22) == strArr[0].charAt(22)) {
            throw new RuntimeException();
        }
        A02[1] = "uysARHPfhmw6aS";
        atomicBoolean = mw.A0S;
        atomicBoolean.set(true);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1778eG
    public final void AFQ() {
        C1780eI c1780eI;
        C1929gi c1929gi;
        this.A00.AFA(false);
        c1780eI = this.A00.A0Q;
        c1780eI.A0E(8);
        c1929gi = this.A00.A0J;
        c1929gi.A0F().AFH();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1778eG
    public final void AGg() {
        InterfaceC1470Yh interfaceC1470Yh;
        interfaceC1470Yh = this.A00.A0O;
        interfaceC1470Yh.ADJ(15);
    }
}
