package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class p2 {
    public static final p2 c = new p2();
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final x1 f1692a = new x1();

    public final t2 a(Class cls) {
        t2 a2;
        Class cls2;
        Charset charset = l1.f1684a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        t2 t2Var = (t2) this.b.get(cls);
        if (t2Var != null) {
            return t2Var;
        }
        x1 x1Var = this.f1692a;
        x1Var.getClass();
        Class cls3 = u2.f1702a;
        if (!z0.class.isAssignableFrom(cls) && (cls2 = u2.f1702a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        r2 b = x1Var.f1710a.b(cls);
        if ((b.d & 2) == 2) {
            if (z0.class.isAssignableFrom(cls)) {
                a2 = new j2(u2.d, k0.f1681a, b.f1696a);
            } else {
                o3 o3Var = u2.b;
                j0 j0Var = k0.b;
                if (j0Var == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                a2 = new j2(o3Var, j0Var, b.f1696a);
            }
        } else if (z0.class.isAssignableFrom(cls)) {
            a2 = ((b.d & 1) == 1 ? o2.PROTO2 : o2.PROTO3) == o2.PROTO2 ? i2.a(b, l2.b, t1.b, u2.d, k0.f1681a, a2.b) : i2.a(b, l2.b, t1.b, u2.d, (j0) null, a2.b);
        } else {
            if (((b.d & 1) == 1 ? o2.PROTO2 : o2.PROTO3) == o2.PROTO2) {
                k2 k2Var = l2.f1685a;
                r1 r1Var = t1.f1701a;
                o3 o3Var2 = u2.b;
                j0 j0Var2 = k0.b;
                if (j0Var2 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                a2 = i2.a(b, k2Var, r1Var, o3Var2, j0Var2, a2.f1657a);
            } else {
                a2 = i2.a(b, l2.f1685a, t1.f1701a, u2.c, (j0) null, a2.f1657a);
            }
        }
        t2 t2Var2 = (t2) this.b.putIfAbsent(cls, a2);
        return t2Var2 != null ? t2Var2 : a2;
    }
}
