package com.moloco.sdk.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* loaded from: classes6.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f5597a = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.q$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return q.a();
        }
    });

    public static final Json a() {
        return JsonKt.Json$default(null, new Function1() { // from class: com.moloco.sdk.internal.q$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return q.a((JsonBuilder) obj);
            }
        }, 1, null);
    }

    public static final Json b() {
        return c();
    }

    public static final Json c() {
        return (Json) f5597a.getValue();
    }

    public static final Unit a(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setLenient(true);
        Json.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }
}
