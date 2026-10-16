package com.ironsource;

import com.ironsource.mediationsdk.demandOnly.a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ironsource.j2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3139j2 {
    public static final b h = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f3368a;
    private final com.ironsource.mediationsdk.demandOnly.a b;
    private final C3207n2 c;
    private final JSONObject d;
    private final JSONObject e;
    private final C3038d2 f;
    private final C3224o2 g;

    /* renamed from: com.ironsource.j2$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final JSONObject f3369a;
        private final String b;
        private final String c;
        private final com.ironsource.mediationsdk.demandOnly.a d;
        private final C3207n2 e;
        private final JSONObject f;
        private final JSONObject g;
        private final C3038d2 h;
        private final C3224o2 i;

        public a(JSONObject auctionData, String instanceId) {
            Intrinsics.checkNotNullParameter(auctionData, "auctionData");
            Intrinsics.checkNotNullParameter(instanceId, "instanceId");
            this.f3369a = auctionData;
            this.b = instanceId;
            JSONObject a2 = a(auctionData);
            this.c = auctionData.optString("auctionId");
            com.ironsource.mediationsdk.demandOnly.a a3 = a(auctionData, a2);
            this.d = a3;
            this.e = c(a2);
            this.f = d(a2);
            this.g = b(a2);
            this.h = a(a3, instanceId);
            this.i = b(a3, instanceId);
        }

        private final JSONObject d(JSONObject jSONObject) {
            return jSONObject.optJSONObject("genericParams");
        }

        public final C3139j2 a() {
            return new C3139j2(this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        }

        public final JSONObject b() {
            return this.f3369a;
        }

        public final String c() {
            return this.b;
        }

        private final JSONObject b(JSONObject jSONObject) {
            return jSONObject.optJSONObject("configurations");
        }

        private final C3207n2 c(JSONObject jSONObject) {
            return new C3207n2(jSONObject);
        }

        private final C3224o2 b(com.ironsource.mediationsdk.demandOnly.a aVar, String str) {
            C3207n2 a2 = aVar.a(str);
            if (a2 == null) {
                return null;
            }
            String k = a2.k();
            Intrinsics.checkNotNullExpressionValue(k, "it.serverData");
            return new C3224o2(k);
        }

        private final JSONObject a(JSONObject jSONObject) {
            JSONObject optJSONObject = jSONObject.optJSONObject("settings");
            return optJSONObject == null ? new JSONObject() : optJSONObject;
        }

        private final com.ironsource.mediationsdk.demandOnly.a a(JSONObject jSONObject, JSONObject jSONObject2) {
            ArrayList arrayList = new ArrayList();
            JSONObject optJSONObject = jSONObject2.optJSONObject(com.ironsource.mediationsdk.d.d);
            JSONArray optJSONArray = jSONObject.optJSONArray(com.ironsource.mediationsdk.d.h);
            if (optJSONArray != null) {
                IntRange until = RangesKt.until(0, optJSONArray.length());
                ArrayList arrayList2 = new ArrayList();
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    C3207n2 c3207n2 = new C3207n2(optJSONArray.getJSONObject(nextInt), nextInt, optJSONObject);
                    if (!c3207n2.m()) {
                        c3207n2 = null;
                    }
                    if (c3207n2 != null) {
                        arrayList2.add(c3207n2);
                    }
                }
                arrayList.addAll(arrayList2);
            }
            return new a.C0296a(arrayList);
        }

        private final C3038d2 a(com.ironsource.mediationsdk.demandOnly.a aVar, String str) {
            C3207n2 a2 = aVar.a(str);
            if (a2 == null) {
                return null;
            }
            C3038d2 c3038d2 = new C3038d2();
            c3038d2.a(a2.b());
            c3038d2.c(a2.h());
            c3038d2.b(a2.g());
            return c3038d2;
        }
    }

    /* renamed from: com.ironsource.j2$b */
    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Object a(JSONObject auctionData, String instanceId) {
            Intrinsics.checkNotNullParameter(auctionData, "auctionData");
            Intrinsics.checkNotNullParameter(instanceId, "instanceId");
            return a(new a(auctionData, instanceId).a(), instanceId);
        }

        private b() {
        }

        private final Object a(C3139j2 c3139j2, String str) {
            String b = c3139j2.b();
            if (b != null && b.length() != 0) {
                if (c3139j2.i()) {
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m10241constructorimpl(ResultKt.createFailure(new C2990a8(C3362w5.f3920a.f())));
                }
                C3207n2 a2 = c3139j2.a(str);
                if (a2 == null) {
                    Result.Companion companion2 = Result.INSTANCE;
                    return Result.m10241constructorimpl(ResultKt.createFailure(new C2990a8(C3362w5.f3920a.j())));
                }
                String k = a2.k();
                if (k != null && k.length() != 0) {
                    Result.Companion companion3 = Result.INSTANCE;
                    return Result.m10241constructorimpl(c3139j2);
                }
                Result.Companion companion4 = Result.INSTANCE;
                return Result.m10241constructorimpl(ResultKt.createFailure(new C2990a8(C3362w5.f3920a.e())));
            }
            Result.Companion companion5 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(new C2990a8(C3362w5.f3920a.i())));
        }
    }

    public C3139j2(String str, com.ironsource.mediationsdk.demandOnly.a waterfall, C3207n2 genericNotifications, JSONObject jSONObject, JSONObject jSONObject2, C3038d2 c3038d2, C3224o2 c3224o2) {
        Intrinsics.checkNotNullParameter(waterfall, "waterfall");
        Intrinsics.checkNotNullParameter(genericNotifications, "genericNotifications");
        this.f3368a = str;
        this.b = waterfall;
        this.c = genericNotifications;
        this.d = jSONObject;
        this.e = jSONObject2;
        this.f = c3038d2;
        this.g = c3224o2;
    }

    public final String a() {
        C3224o2 c3224o2 = this.g;
        if (c3224o2 != null) {
            return c3224o2.d();
        }
        return null;
    }

    public final String b() {
        return this.f3368a;
    }

    public final C3038d2 c() {
        return this.f;
    }

    public final JSONObject d() {
        return this.e;
    }

    public final C3207n2 e() {
        return this.c;
    }

    public final JSONObject f() {
        return this.d;
    }

    public final C3224o2 g() {
        return this.g;
    }

    public final com.ironsource.mediationsdk.demandOnly.a h() {
        return this.b;
    }

    public final boolean i() {
        return this.b.isEmpty();
    }

    public final C3207n2 a(String providerName) {
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        return a(this.b, providerName);
    }

    private final C3207n2 a(com.ironsource.mediationsdk.demandOnly.a aVar, String str) {
        return aVar.a(str);
    }
}
