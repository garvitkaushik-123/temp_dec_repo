package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.jf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2096jf implements InterfaceC1585b8 {
    public static String[] A03 = {"JSPFN54Hhto2krin5AXlvtsoUga8f3VN", "TJUa2zQB5Sn7m4BW7AASunbvdXy8BM9T", "6VrbDJWlH8cGoKCi2T6pLfOeL4USL1Zo", "WDYRHsse8CkpPKHQRRahwXj8yQt26EEK", "k2HMJqY12uG3JOOYcYA0rukTMokxTs2q", "JFWFpGWs655aVrqtTe7kn6NDgYp0Sw9v", "lGCVru2Pt3eCAyGNCmn4MueAiTs1TFsk", "y56t9BBTSrVMdPLNMlUp"};
    public final /* synthetic */ int A00;
    public final /* synthetic */ AbstractC2095je A01;
    public final /* synthetic */ UK A02;

    public C2096jf(AbstractC2095je abstractC2095je, int i, UK uk) {
        this.A01 = abstractC2095je;
        this.A00 = i;
        this.A02 = uk;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1585b8
    public final void AE7(C1584b7 c1584b7) {
        AbstractC1873fo abstractC1873fo;
        if (this.A00 == 0) {
            UK uk = this.A02;
            abstractC1873fo = this.A01.A04;
            uk.A1k(abstractC1873fo);
        }
        this.A02.A1o(c1584b7.A00() != null, true);
        if (A03[0].charAt(15) == 'S') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[1] = "iRqOIqAZ6TOb0gQaJ743l8NrEMVcYXI5";
        strArr[4] = "jzrwvLgYYMFr4hfD5uj52ory38hy0fYg";
    }
}
