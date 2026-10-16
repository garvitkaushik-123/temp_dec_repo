package com.ironsource;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class U2 {

    /* renamed from: a, reason: collision with root package name */
    private final b f3067a;
    private final Map<String, b> b;

    static final class a extends Lambda implements Function1<JSONObject, b> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3068a = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke(JSONObject it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new b(it);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final JSONObject f3069a;
        private final int b;
        private final boolean c;
        private final long d;
        private final float e;
        private final List<String> f;

        public b(JSONObject features) {
            Intrinsics.checkNotNullParameter(features, "features");
            JSONObject jSONObject = features.has(W2.f3104a) ? features : null;
            JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject(W2.f3104a) : null;
            this.f3069a = optJSONObject;
            int optInt = optJSONObject != null ? optJSONObject.optInt(W2.b, 25000) : 25000;
            this.b = optInt;
            this.c = optJSONObject != null ? optJSONObject.optBoolean("enabled", true) : true;
            this.d = (optJSONObject == null || !optJSONObject.has(W2.d) || optJSONObject.isNull(W2.d)) ? optInt : optJSONObject.optLong(W2.d);
            this.e = features.has(W2.e) ? features.optInt(W2.e) / 100.0f : 0.15f;
            List<String> b = features.has(W2.f) ? V9.b(features.getJSONArray(W2.f)) : CollectionsKt.listOf((Object[]) new String[]{"BANNER", "LEADERBOARD"});
            Intrinsics.checkNotNullExpressionValue(b, "BANNER_CONFIGURATIONS_AD…ZE_LEADERBOARD)\n        }");
            this.f = b;
        }

        public final List<String> a() {
            return this.f;
        }

        public final float b() {
            return this.e;
        }

        public final int c() {
            return this.b;
        }

        public final long d() {
            return this.d;
        }

        public final boolean e() {
            return this.c;
        }
    }

    public U2(JSONObject bannerConfigurations) {
        Intrinsics.checkNotNullParameter(bannerConfigurations, "bannerConfigurations");
        this.f3067a = new b(bannerConfigurations);
        this.b = new X0(bannerConfigurations).a(a.f3068a);
    }

    public final Map<String, b> a() {
        return this.b;
    }

    public final b b() {
        return this.f3067a;
    }
}
