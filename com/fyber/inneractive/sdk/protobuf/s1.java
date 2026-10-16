package com.fyber.inneractive.sdk.protobuf;

import java.util.List;

/* loaded from: classes4.dex */
public final class s1 extends t1 {
    @Override // com.fyber.inneractive.sdk.protobuf.t1
    public final void a(Object obj, long j) {
        ((c) ((k1) x3.e(obj, j))).f1661a = false;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t1
    public final List b(Object obj, long j) {
        k1 k1Var = (k1) x3.e(obj, j);
        if (((c) k1Var).f1661a) {
            return k1Var;
        }
        int size = k1Var.size();
        k1 b = k1Var.b(size == 0 ? 10 : size * 2);
        x3.a(j, obj, b);
        return b;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t1
    public final void a(long j, Object obj, Object obj2) {
        k1 k1Var = (k1) x3.e(obj, j);
        k1 k1Var2 = (k1) x3.e(obj2, j);
        int size = k1Var.size();
        int size2 = k1Var2.size();
        if (size > 0 && size2 > 0) {
            if (!((c) k1Var).f1661a) {
                k1Var = k1Var.b(size2 + size);
            }
            k1Var.addAll(k1Var2);
        }
        if (size > 0) {
            k1Var2 = k1Var;
        }
        x3.a(j, obj, k1Var2);
    }
}
