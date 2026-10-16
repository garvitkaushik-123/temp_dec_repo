package com.ironsource;

import com.ironsource.C3337ue;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public class Sd {

    /* renamed from: a, reason: collision with root package name */
    private final C3013be f3052a;

    public Sd(C3013be sdkInitResponse) {
        Intrinsics.checkNotNullParameter(sdkInitResponse, "sdkInitResponse");
        this.f3052a = sdkInitResponse;
    }

    public final K1 a() {
        return this.f3052a.a().b().c();
    }

    public final D1 b() {
        return this.f3052a.a().b().b();
    }

    public final N5 c() {
        return this.f3052a.b();
    }

    public final C3337ue d() {
        return this.f3052a.c();
    }

    public final C3233ob e() {
        return this.f3052a.a().b().e();
    }

    public final C3337ue.a f() {
        C3337ue.a h = this.f3052a.c().h();
        Intrinsics.checkNotNullExpressionValue(h, "sdkInitResponse.fullResponse.origin");
        return h;
    }

    protected final C3013be g() {
        return this.f3052a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Sd(Sd sdkConfig) {
        this(sdkConfig.f3052a);
        Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
    }
}
