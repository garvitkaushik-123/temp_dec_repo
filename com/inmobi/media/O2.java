package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class O2 {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f2380a = new LinkedHashMap();
    public static final Lazy b = LazyKt.lazy(L2.f2347a);
    public static final AtomicBoolean c = new AtomicBoolean(false);
    public static final AtomicBoolean d = new AtomicBoolean(true);
    public static final ConcurrentHashMap e = new ConcurrentHashMap();
    public static final Lazy f = LazyKt.lazy(K2.f2333a);

    static {
        Uc.f().a(new int[]{2, 1}, H2.f2301a);
        Uc.a(new Runnable() { // from class: com.inmobi.media.O2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                O2.a();
            }
        });
    }

    @JvmStatic
    public static final Config a(String str, String str2, N2 n2) {
        return M2.a(str, str2, n2);
    }

    public static final /* synthetic */ String b() {
        return "ConfigBootstrapHandler";
    }

    public static final /* synthetic */ String f() {
        return "O2";
    }

    @JvmStatic
    public static final void g() {
        M2.a();
    }

    @JvmStatic
    public static final void h() {
        if (c.getAndSet(false)) {
            Intrinsics.checkNotNullExpressionValue(f(), "access$getTAG$cp(...)");
            ((I2) b.getValue()).sendEmptyMessage(5);
        }
    }

    public static final void a() {
        M2.a();
    }
}
