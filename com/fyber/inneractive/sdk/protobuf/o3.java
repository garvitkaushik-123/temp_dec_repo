package com.fyber.inneractive.sdk.protobuf;

/* loaded from: classes4.dex */
public final class o3 {
    public static void a(Object obj, Object obj2) {
        ((z0) obj).unknownFields = (n3) obj2;
    }

    public static boolean a(Object obj, s2 s2Var) {
        int e = s2Var.e();
        int i = e >>> 3;
        int i2 = e & 7;
        if (i2 == 0) {
            ((n3) obj).a(i << 3, Long.valueOf(s2Var.o()));
            return true;
        }
        if (i2 == 1) {
            ((n3) obj).a((i << 3) | 1, Long.valueOf(s2Var.g()));
            return true;
        }
        if (i2 == 2) {
            ((n3) obj).a((i << 3) | 2, s2Var.a());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                int i3 = n1.f1688a;
                throw new m1();
            }
            ((n3) obj).a((i << 3) | 5, Integer.valueOf(s2Var.q()));
            return true;
        }
        n3 n3Var = new n3();
        int i4 = i << 3;
        int i5 = i4 | 4;
        while (s2Var.s() != Integer.MAX_VALUE && a((Object) n3Var, s2Var)) {
        }
        if (i5 == s2Var.e()) {
            n3Var.e = false;
            ((n3) obj).a(i4 | 3, n3Var);
            return true;
        }
        throw new n1("Protocol message end-group tag did not match expected tag.");
    }
}
