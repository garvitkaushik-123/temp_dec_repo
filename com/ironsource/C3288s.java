package com.ironsource;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* renamed from: com.ironsource.s, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3288s {
    public static final c d = new c(null);
    public static final String e = "capping";
    public static final String f = "pacing";
    public static final String g = "delivery";
    public static final String h = "progressiveLoadingConfig";
    public static final String i = "expiredDurationInMinutes";
    public static final String j = "reward";
    public static final String k = "name";
    public static final String l = "amount";
    public static final String m = "virtualItemName";
    public static final String n = "virtualItemCount";
    public static final long o = 60;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, d> f3684a;
    private final d b;
    private final Map<String, d> c;

    /* renamed from: com.ironsource.s$a */
    static final class a extends Lambda implements Function1<JSONObject, d> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3685a = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d invoke(JSONObject it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new d(it);
        }
    }

    /* renamed from: com.ironsource.s$b */
    static final class b extends Lambda implements Function1<JSONObject, d> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3686a = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d invoke(JSONObject it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new d(it);
        }
    }

    /* renamed from: com.ironsource.s$c */
    public static final class c {
        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private c() {
        }
    }

    /* renamed from: com.ironsource.s$d */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final J3 f3687a;
        private final Kc b;
        private final Q4 c;
        private final Long d;
        private final C3235od e;
        private final C3235od f;
        private final C3066ed g;

        public d(JSONObject features) {
            J3 j3;
            Kc kc;
            Intrinsics.checkNotNullParameter(features, "features");
            C3066ed c3066ed = null;
            if (features.has(C3288s.e)) {
                JSONObject jSONObject = features.getJSONObject(C3288s.e);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "features.getJSONObject(key)");
                j3 = new J3(jSONObject);
            } else {
                j3 = null;
            }
            this.f3687a = j3;
            if (features.has(C3288s.f)) {
                JSONObject jSONObject2 = features.getJSONObject(C3288s.f);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "features.getJSONObject(key)");
                kc = new Kc(jSONObject2);
            } else {
                kc = null;
            }
            this.b = kc;
            this.c = features.has("delivery") ? new Q4(features.getBoolean("delivery")) : null;
            this.d = features.has(C3288s.i) ? Long.valueOf(features.getLong(C3288s.i)) : null;
            JSONObject optJSONObject = features.optJSONObject(C3288s.j);
            this.e = optJSONObject != null ? new C3235od(optJSONObject, "name", "amount") : null;
            C3235od c3235od = new C3235od(features, C3288s.m, C3288s.n);
            String b = c3235od.b();
            this.f = (b == null || b.length() == 0 || c3235od.a() == null) ? null : c3235od;
            if (features.has(C3288s.h)) {
                JSONObject jSONObject3 = features.getJSONObject(C3288s.h);
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "features.getJSONObject(key)");
                c3066ed = new C3066ed(jSONObject3);
            }
            this.g = c3066ed;
        }

        public final C3235od a() {
            return this.e;
        }

        public final J3 b() {
            return this.f3687a;
        }

        public final Q4 c() {
            return this.c;
        }

        public final Long d() {
            return this.d;
        }

        public final Kc e() {
            return this.b;
        }

        public final C3235od f() {
            return this.f;
        }

        public final C3066ed g() {
            return this.g;
        }
    }

    public C3288s(JSONObject configurations) {
        Intrinsics.checkNotNullParameter(configurations, "configurations");
        this.f3684a = new C2995ad(configurations).a(b.f3686a);
        this.b = new d(configurations);
        this.c = new X0(configurations).a(a.f3685a);
    }

    public final Map<String, d> a() {
        return this.c;
    }

    public final d b() {
        return this.b;
    }

    public final Map<String, d> c() {
        return this.f3684a;
    }
}
