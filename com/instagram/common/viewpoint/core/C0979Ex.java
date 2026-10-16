package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Ex, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C0979Ex {
    public static String[] A05 = {"LpJTwMN2G", "VgMO4aUKUhad1vQS8qeWccWG6TZwybQB", "ACcLkDhyx", "Vz4L8Yk2qa8xi00BpA99exXw347yn2OW", "M93qmyVYUpuFuHp", "Ixo", "WCFkueysi57ip8GEP7BFiSRGMX4T5ofH", "LFY6A3GYQmBEHARGrOHSwwc2jPi1aXj0"};
    public final int A00;
    public final C2444pY A01;
    public final Object A02;
    public final C08117s[] A03;
    public final InterfaceC2301nE[] A04;

    public C0979Ex(C08117s[] c08117sArr, InterfaceC2301nE[] interfaceC2301nEArr, C2444pY c2444pY, Object obj) {
        this.A03 = c08117sArr;
        this.A04 = (InterfaceC2301nE[]) interfaceC2301nEArr.clone();
        this.A01 = c2444pY;
        this.A02 = obj;
        this.A00 = c08117sArr.length;
    }

    public final boolean A00(int i) {
        return this.A03[i] != null;
    }

    public final boolean A01(C0979Ex c0979Ex, int i) {
        if (c0979Ex == null) {
            return false;
        }
        C08117s[] c08117sArr = this.A03;
        if (A05[5].length() == 3) {
            A05[1] = "2a41zxf8OUQisEdMYeAN8aC4JNcLEgEy";
            if (!C5C.A1E(c08117sArr[i], c0979Ex.A03[i])) {
                return false;
            }
            InterfaceC2301nE interfaceC2301nE = this.A04[i];
            InterfaceC2301nE interfaceC2301nE2 = c0979Ex.A04[i];
            String[] strArr = A05;
            if (strArr[2].length() == strArr[0].length()) {
                A05[4] = "ShAZgc6gkhlm9OR";
                return C5C.A1E(interfaceC2301nE, interfaceC2301nE2);
            }
        }
        throw new RuntimeException();
    }
}
