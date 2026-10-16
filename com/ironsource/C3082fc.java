package com.ironsource;

import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.fc, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3082fc {

    /* renamed from: a, reason: collision with root package name */
    private final C3139j2 f3300a;
    private final boolean b;

    /* renamed from: com.ironsource.fc$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3301a = new a();
        public static final String b = "adm";
        public static final String c = "isOneFlow";
        public static final String d = "isMultipleAdObjects";
        public static final String e = "adsInternalInfo";
        public static final String f = "success";
        public static final String g = "error";
        public static final String h = "data";

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3082fc() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public final HashMap<String, String> a() {
        C3224o2 g;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("isOneFlow", String.valueOf(this.b));
        hashMap.put("isMultipleAdObjects", "true");
        List<N> a2 = C3334ub.s.d().G().a();
        String jSONObject = a2 != null ? new JSONObject().put("success", true).put("data", a2).toString() : new JSONObject().put("success", false).put("error", "Failed to get ad internal info").toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "if (jsonAdInternalInfo !…    .toString()\n        }");
        hashMap.put(a.e, jSONObject);
        C3139j2 c3139j2 = this.f3300a;
        if (c3139j2 != null && (g = c3139j2.g()) != null) {
            hashMap.put("adm", g.a());
            hashMap.putAll(g.b());
        }
        return hashMap;
    }

    public C3082fc(C3139j2 c3139j2, boolean z) {
        this.f3300a = c3139j2;
        this.b = z;
    }

    public /* synthetic */ C3082fc(C3139j2 c3139j2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : c3139j2, (i & 2) != 0 ? false : z);
    }
}
