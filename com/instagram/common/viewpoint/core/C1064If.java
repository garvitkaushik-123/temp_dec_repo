package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.If, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1064If implements XN {
    public static String[] A01 = {"72ztA7TlK5AWnMBFqm0ulEGrNikWU87c", "q9jSjTIXJJeud4mNFdEJpcs0aBWF", "6LBG7Z", "4a80CIrFExPHnWcdf8FRxARvXokzjsAY", "hmt020juZcOK2XVUFVfIwXvCI0upMeB5", "bPuxHbTn8HkB22ksZqTc8mW6RF8jNMxu", "KvPASdtvPFN6v", "W7wSubo8j20OAA03KxoOzu7JM99EpBz5"};
    public final /* synthetic */ C07485h A00;

    public C1064If(C07485h c07485h) {
        this.A00 = c07485h;
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void ADS() {
        AbstractC1642c3 abstractC1642c3;
        AbstractC1642c3 abstractC1642c32;
        InterfaceC1749dm interfaceC1749dm;
        AbstractC1642c3 abstractC1642c33;
        InterfaceC1749dm interfaceC1749dm2;
        AbstractC1464Yb abstractC1464Yb;
        InterfaceC1749dm interfaceC1749dm3;
        int i;
        AbstractC1642c3 abstractC1642c34;
        InterfaceC1749dm interfaceC1749dm4;
        AbstractC1464Yb abstractC1464Yb2;
        abstractC1642c3 = this.A00.A01;
        if (abstractC1642c3 instanceof C1112Kc) {
            abstractC1642c34 = this.A00.A01;
            if (abstractC1642c34.A1M()) {
                interfaceC1749dm4 = this.A00.A07;
                interfaceC1749dm4.AFw(true);
                abstractC1464Yb2 = this.A00.A06;
                abstractC1464Yb2.setToolbarActionMode(1);
                interfaceC1749dm3 = this.A00.A07;
                i = this.A00.A03;
                interfaceC1749dm3.ADc(i);
            }
        }
        abstractC1642c32 = this.A00.A01;
        if (abstractC1642c32 instanceof C1092Ji) {
            abstractC1642c33 = this.A00.A01;
            if (abstractC1642c33.A1M()) {
                interfaceC1749dm2 = this.A00.A07;
                interfaceC1749dm2.AFw(true);
                abstractC1464Yb = this.A00.A06;
                abstractC1464Yb.setToolbarActionMode(1);
                interfaceC1749dm3 = this.A00.A07;
                i = this.A00.A03;
                interfaceC1749dm3.ADc(i);
            }
        }
        interfaceC1749dm = this.A00.A07;
        String[] strArr = A01;
        if (strArr[4].charAt(11) == strArr[3].charAt(11)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[5] = "jNYMJATRfaQqNW2YkrgQ7vcVmM2IUm0K";
        strArr2[0] = "cX4sd5TjwRWpCL8J3hPSalfD2n4ZIotM";
        interfaceC1749dm.AFw(false);
        interfaceC1749dm3 = this.A00.A07;
        i = this.A00.A03;
        interfaceC1749dm3.ADc(i);
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void AFV(float f) {
        InterfaceC1749dm interfaceC1749dm;
        int i;
        DZ dz;
        DZ dz2;
        int i2;
        interfaceC1749dm = this.A00.A07;
        i = this.A00.A03;
        interfaceC1749dm.ADw(i - f);
        dz = this.A00.A02;
        if (dz != null) {
            dz2 = this.A00.A02;
            i2 = this.A00.A03;
            dz2.A07((int) (i2 - f));
        }
    }
}
