package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.a3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C2985a3 implements InterfaceC3062e9 {

    /* renamed from: a, reason: collision with root package name */
    private final C3000b1 f3173a;
    private final V2 b;

    public C2985a3(C3000b1 adapterConfig, V2 adFormatConfigurations) {
        Intrinsics.checkNotNullParameter(adapterConfig, "adapterConfig");
        Intrinsics.checkNotNullParameter(adFormatConfigurations, "adFormatConfigurations");
        this.f3173a = adapterConfig;
        this.b = adFormatConfigurations;
    }

    @Override // com.ironsource.InterfaceC3017c1
    public boolean a() {
        return true;
    }

    @Override // com.ironsource.InterfaceC3305t
    public long b() {
        return this.b.b();
    }

    @Override // com.ironsource.InterfaceC3017c1
    public String c() {
        String f = this.f3173a.f();
        Intrinsics.checkNotNullExpressionValue(f, "adapterConfig.providerName");
        return f;
    }

    @Override // com.ironsource.InterfaceC3017c1
    public boolean d() {
        return !this.f3173a.j();
    }

    @Override // com.ironsource.InterfaceC3017c1
    public String e() {
        String a2 = this.f3173a.a();
        Intrinsics.checkNotNullExpressionValue(a2, "adapterConfig.adSourceNameForEvents");
        return a2;
    }

    @Override // com.ironsource.InterfaceC3017c1
    public EnumC3096g9 f() {
        return EnumC3096g9.b.a(this.f3173a.d());
    }
}
