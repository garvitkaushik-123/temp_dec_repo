package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.view.WindowManager;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.n2, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2289n2 implements G5 {
    public static byte[] A01;
    public final WindowManager A00;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 115);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-7, -21, -16, -26, -15, -7};
    }

    public C2289n2(WindowManager windowManager) {
        this.A00 = windowManager;
    }

    public static C2289n2 A00(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(A01(0, 6, 15));
        if (windowManager != null) {
            return new C2289n2(windowManager);
        }
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.G5
    public final void AHX(G4 g4) {
        g4.ADd(this.A00.getDefaultDisplay());
    }

    @Override // com.instagram.common.viewpoint.core.G5
    public final void AKW() {
    }
}
