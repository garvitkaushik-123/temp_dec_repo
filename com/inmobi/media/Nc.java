package com.inmobi.media;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;

/* loaded from: classes4.dex */
public abstract class Nc {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f2375a;
    public static final Lazy b;
    public static final Lazy c;
    public static final Lazy d;
    public static final Lazy e;
    public static final Lazy f;
    public static final Lazy g;

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        f2375a = LazyKt.lazy(lazyThreadSafetyMode, (Function0) Gc.f2297a);
        b = LazyKt.lazy(lazyThreadSafetyMode, (Function0) Hc.f2308a);
        c = LazyKt.lazy(lazyThreadSafetyMode, (Function0) Ic.f2318a);
        d = LazyKt.lazy(lazyThreadSafetyMode, (Function0) Jc.f2328a);
        e = LazyKt.lazy(lazyThreadSafetyMode, (Function0) Kc.f2343a);
        f = LazyKt.lazy(lazyThreadSafetyMode, (Function0) Mc.f2364a);
        g = LazyKt.lazy(lazyThreadSafetyMode, (Function0) Lc.f2354a);
    }

    public static C2755m1 a() {
        return (C2755m1) b.getValue();
    }

    public static C2756m2 b() {
        return (C2756m2) c.getValue();
    }

    public static R5 c() {
        return (R5) e.getValue();
    }

    public static Z6 d() {
        return (Z6) g.getValue();
    }

    public static Vd e() {
        return (Vd) f.getValue();
    }
}
