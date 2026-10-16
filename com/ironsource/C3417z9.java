package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.z9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3417z9 implements InterfaceC3062e9 {

    /* renamed from: a, reason: collision with root package name */
    private final C3000b1 f3965a;
    private final C3366w9 b;

    public C3417z9(C3000b1 adapterConfig, C3366w9 adFormatConfigurations) {
        Intrinsics.checkNotNullParameter(adapterConfig, "adapterConfig");
        Intrinsics.checkNotNullParameter(adFormatConfigurations, "adFormatConfigurations");
        this.f3965a = adapterConfig;
        this.b = adFormatConfigurations;
    }

    @Override // com.ironsource.InterfaceC3017c1
    public boolean a() {
        return true;
    }

    @Override // com.ironsource.InterfaceC3305t
    public long b() {
        return this.b.e();
    }

    @Override // com.ironsource.InterfaceC3017c1
    public String c() {
        String f = this.f3965a.f();
        Intrinsics.checkNotNullExpressionValue(f, "adapterConfig.providerName");
        return f;
    }

    @Override // com.ironsource.InterfaceC3017c1
    public boolean d() {
        return !this.f3965a.j();
    }

    @Override // com.ironsource.InterfaceC3017c1
    public String e() {
        String a2 = this.f3965a.a();
        Intrinsics.checkNotNullExpressionValue(a2, "adapterConfig.adSourceNameForEvents");
        return a2;
    }

    @Override // com.ironsource.InterfaceC3017c1
    public EnumC3096g9 f() {
        return EnumC3096g9.b.a(this.f3965a.d());
    }
}
