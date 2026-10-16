package com.instagram.common.viewpoint.core;

import android.view.View;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.j3, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2067j3 implements N9 {
    public static byte[] A02;
    public static String[] A03 = {"ebJtInVgM8lwtLsL8CqjQvfHZTFWXyTj", "MRT4Iz3aNiJEaKRUIrDApfghDq01n6sB", "qhIcWii6jOsLbVLe4G", "jd0Ec4CahT7YYBjB568owPC0gY4s3zOU", "RPiMcfQYBdHC0SSG6XvNc0NsjlYurq5U", "E74vSWGMqEH8Jt4WlgBEkdQ8nTEO7fKB", "DEVdv4rr1ByH9p4ezSF9ryFdFyWOGnGy", "23RYwIDt1nJrIBpc57"};
    public final /* synthetic */ C08037k A00;
    public final /* synthetic */ Runnable A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 78);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{89, 10, Ascii.SO, 83, 89, 91, 92, 92, 32, 3, Ascii.FF, Ascii.FF, 7, Ascii.DLE, 66, Ascii.VT, Ascii.SI, Ascii.DC2, Ascii.DLE, 7, 17, 17, Ascii.VT, Ascii.CR, Ascii.FF, 66, 4, Ascii.VT, Ascii.DLE, 7, 6, Ascii.FS, Ascii.GS, 49, Ascii.DC2, Ascii.GS, Ascii.GS, Ascii.SYN, 1, 63, Ascii.FS, Ascii.DC4, Ascii.DC4, Ascii.SUB, Ascii.GS, Ascii.DC4, 58, Ascii.RS, 3, 1, Ascii.SYN, 0, 0, Ascii.SUB, Ascii.FS, Ascii.GS};
    }

    static {
        A01();
    }

    public C2067j3(C08037k c08037k, Runnable runnable) {
        this.A00 = c08037k;
        this.A01 = runnable;
    }

    @Override // com.instagram.common.viewpoint.core.N9
    public final void ADC(InterfaceC2125k8 interfaceC2125k8) {
        AnonymousClass76 anonymousClass76;
        anonymousClass76 = this.A00.A02;
        anonymousClass76.A0F().A4a();
        this.A00.A07.A0C();
    }

    @Override // com.instagram.common.viewpoint.core.N9
    public final void ADD(InterfaceC2125k8 interfaceC2125k8, View view) {
        AnonymousClass76 anonymousClass76;
        anonymousClass76 = this.A00.A02;
        anonymousClass76.A0F().A4Z(interfaceC2125k8 == ((AbstractC2064j0) this.A00).A00);
        if (interfaceC2125k8 != ((AbstractC2064j0) this.A00).A00) {
            return;
        }
        this.A00.A0H().removeCallbacks(this.A01);
        N1 n1 = ((AbstractC2064j0) this.A00).A01;
        C08037k c08037k = this.A00;
        String[] strArr = A03;
        if (strArr[6].charAt(14) != strArr[5].charAt(14)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[0] = "gfJNIdbF2FrCa8qL8kuytpSS0QUlrsrj";
        strArr2[1] = "KzSpIsxhAVssntgB7OlLodebxm4ynnXJ";
        ((AbstractC2064j0) c08037k).A01 = interfaceC2125k8;
        this.A00.A01 = view;
        if (!this.A00.A0C) {
            this.A00.A07.A0F(interfaceC2125k8);
        } else {
            this.A00.A07.A0E(view);
            this.A00.A0Q(n1);
        }
    }

    @Override // com.instagram.common.viewpoint.core.N9
    public final void ADE(InterfaceC2125k8 interfaceC2125k8) {
        AnonymousClass76 anonymousClass76;
        AbstractC1412Vy.A05(A00(31, 25, 61), A00(8, 23, 44), A00(0, 8, 37));
        anonymousClass76 = this.A00.A02;
        anonymousClass76.A0F().A4c();
        this.A00.A07.A0D();
        this.A00.A0O();
    }

    @Override // com.instagram.common.viewpoint.core.N9
    public final void AEN(InterfaceC2125k8 interfaceC2125k8, C1401Vm c1401Vm) {
        AnonymousClass76 anonymousClass76;
        anonymousClass76 = this.A00.A02;
        anonymousClass76.A0F().A4b(interfaceC2125k8 == ((AbstractC2064j0) this.A00).A00, c1401Vm.A03().getErrorCode());
        if (interfaceC2125k8 != ((AbstractC2064j0) this.A00).A00) {
            return;
        }
        this.A00.A0H().removeCallbacks(this.A01);
        this.A00.A0Q(interfaceC2125k8);
        this.A00.ADp(c1401Vm);
    }
}
