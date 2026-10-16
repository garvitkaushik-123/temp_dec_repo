package com.instagram.common.viewpoint.core;

import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.mj, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2271mj implements H1 {
    public static String[] A03 = {"Qzrb2NyX11iip4M0Dun9HjrVhDBjGiaF", "S4lxERGEQHczdoRlIRLlXReEKfWFWSGc", "txU8e6wljbe290bqTydjfEMDFUDvEmx5", "ZB68ibpDVF3DEFIIdRwQIG37zRUG2jhG", "NKfzuQ6LKFKezVni40AKhLW9Qs", "gUOm4cnsv29C5J2bDVOWEpGrIAhYUn7e", "xRx4EoAOCCZ90h8tA3pJ1YmFxzetviZR", "6LlO7okteSZZNTbDPWq3J1SHLhykMwkf"};
    public final int A00;
    public final HE A01;
    public final HJ A02;

    @Override // com.instagram.common.viewpoint.core.H1
    public final /* synthetic */ void AFs() {
    }

    public C2271mj(HJ hj, int i) {
        this.A02 = hj;
        this.A00 = i;
        this.A01 = new HE();
    }

    private long A00(InterfaceC2280ms interfaceC2280ms) throws IOException {
        while (interfaceC2280ms.A8i() < interfaceC2280ms.A8O() - 6 && !HF.A09(interfaceC2280ms, this.A02, this.A00, this.A01)) {
            String[] strArr = A03;
            if (strArr[1].charAt(7) == strArr[7].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[6] = "MdA2mB0qiCN7NKRKcBY3aVGEnEzRIKP4";
            strArr2[3] = "Kp5wPJFyOGMB7tBJUi3Fl7WX9iQtExSk";
            interfaceC2280ms.A47(1);
        }
        if (interfaceC2280ms.A8i() >= interfaceC2280ms.A8O() - 6) {
            interfaceC2280ms.A47((int) (interfaceC2280ms.A8O() - interfaceC2280ms.A8i()));
            return this.A02.A09;
        }
        return this.A01.A00;
    }

    @Override // com.instagram.common.viewpoint.core.H1
    public final C1032Gz AIw(InterfaceC2280ms interfaceC2280ms, long j) throws IOException {
        long rightFrameFirstSampleNumber = interfaceC2280ms.A8n();
        long leftFrameFirstSampleNumber = A00(interfaceC2280ms);
        long A8i = interfaceC2280ms.A8i();
        interfaceC2280ms.A47(Math.max(6, this.A02.A06));
        long searchPosition = A00(interfaceC2280ms);
        long leftFramePosition = interfaceC2280ms.A8i();
        if (leftFrameFirstSampleNumber <= j && searchPosition > j) {
            return C1032Gz.A03(A8i);
        }
        if (searchPosition <= j) {
            return C1032Gz.A05(searchPosition, leftFramePosition);
        }
        return C1032Gz.A04(leftFrameFirstSampleNumber, rightFrameFirstSampleNumber);
    }
}
