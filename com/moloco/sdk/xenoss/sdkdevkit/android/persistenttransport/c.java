package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.service_locator.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f6363a = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.c$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return c.b();
        }
    });

    public static final a a() {
        return c();
    }

    public static final b b() {
        return d();
    }

    public static final b c() {
        return (b) f6363a.getValue();
    }

    public static final b d() {
        d b;
        try {
            b = a.i.f5757a.c();
        } catch (Exception e) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "BestAttemptHttpRequest", "Failed to create PersistentHttpRequest, invoking NonPersistendHttpRequest", e, false, 8, null);
            b = h.b();
        }
        return new b(b);
    }
}
