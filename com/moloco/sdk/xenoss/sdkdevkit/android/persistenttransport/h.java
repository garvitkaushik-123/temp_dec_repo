package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import com.moloco.sdk.service_locator.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6371a = "NonPersistentRequest";
    public static final Lazy b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.h$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return h.a();
        }
    });
    public static final long c = 10000;

    public static final g a() {
        return new g(a.i.f5757a.a());
    }

    public static final f b() {
        return c();
    }

    public static final g c() {
        return (g) b.getValue();
    }
}
