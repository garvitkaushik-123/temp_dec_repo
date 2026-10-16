package com.ironsource;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.be, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3013be {

    /* renamed from: a, reason: collision with root package name */
    private final C3337ue f3204a;
    private final C3117hd b;
    private final C3150jd c;
    private final V3 d;
    private final N5 e;

    public C3013be(C3337ue fullResponse) {
        Intrinsics.checkNotNullParameter(fullResponse, "fullResponse");
        this.f3204a = fullResponse;
        JSONObject optJSONObject = fullResponse.i().optJSONObject(C3033ce.f3233a);
        this.b = new C3117hd(optJSONObject == null ? new JSONObject() : optJSONObject);
        JSONObject optJSONObject2 = fullResponse.i().optJSONObject(C3033ce.b);
        this.c = new C3150jd(optJSONObject2 == null ? new JSONObject() : optJSONObject2);
        JSONObject optJSONObject3 = fullResponse.i().optJSONObject("configurations");
        this.d = new V3(optJSONObject3 == null ? new JSONObject() : optJSONObject3);
        JSONObject optJSONObject4 = fullResponse.i().optJSONObject(C3033ce.d);
        this.e = new N5(optJSONObject4 == null ? new JSONObject() : optJSONObject4);
    }

    public final V3 a() {
        return this.d;
    }

    public final N5 b() {
        return this.e;
    }

    public final C3337ue c() {
        return this.f3204a;
    }

    public final C3117hd d() {
        return this.b;
    }

    public final C3150jd e() {
        return this.c;
    }
}
