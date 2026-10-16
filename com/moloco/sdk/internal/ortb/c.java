package com.moloco.sdk.internal.ortb;

import com.moloco.sdk.internal.q;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f5439a = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.ortb.c$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return c.b();
        }
    });

    public static final a a() {
        return c();
    }

    public static final b b() {
        return new b(q.b());
    }

    public static final a c() {
        return (a) f5439a.getValue();
    }
}
