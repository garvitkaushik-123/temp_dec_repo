package com.instagram.common.viewpoint.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Gc, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1009Gc implements InterfaceC1297Rk {
    public static String[] A01 = {"EbGpmssVJ7ns5QL3Rl3UMQ1bkFVQ99jJ", "NZiaRg2dkcqShBYEYgfcfS6cvloj595L", "orBeTHrcfmlzSHmkgrBC5PhD7dWIdW6R", "A0QUoJlw", "r5xapKwo2g0pU1r2itXQ9K5SrPer64wf", "XFka6Ze1I6IepT0r6LvaraMv7MRENHMC", "Xj0im9L41l0kDU7dj2M6tiOB0nkMWcds", "VCdvqSH1BrwZZsOdC7BZghv3f2EYDVkv"};
    public final /* synthetic */ C07384x A00;

    public C1009Gc(C07384x c07384x) {
        this.A00 = c07384x;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1297Rk
    public final boolean AAI() {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.A00.A06;
        if (atomicBoolean.get()) {
            boolean A0l = this.A00.A0l();
            String[] strArr = A01;
            if (strArr[1].charAt(8) == strArr[2].charAt(8)) {
                throw new RuntimeException();
            }
            A01[0] = "O5SuZCLVdBOcw9avK46kWbT1hYIehzyg";
            if (!A0l) {
                return false;
            }
        }
        return true;
    }
}
