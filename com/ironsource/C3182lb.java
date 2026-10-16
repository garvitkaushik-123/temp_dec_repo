package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.lb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3182lb implements S5<C3165kb> {

    /* renamed from: a, reason: collision with root package name */
    private final String f3448a;
    private final InterfaceC3100gd b;
    private final InterfaceC3037d1 c;
    private final boolean d;

    public C3182lb(String adm, InterfaceC3100gd providerName, InterfaceC3037d1 adapterConfigs, boolean z) {
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intrinsics.checkNotNullParameter(adapterConfigs, "adapterConfigs");
        this.f3448a = adm;
        this.b = providerName;
        this.c = adapterConfigs;
        this.d = z;
    }

    @Override // com.ironsource.S5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C3165kb a() throws Wd, Exception {
        InterfaceC3062e9 a2 = this.c.a(this.b);
        new S(this.f3448a, a2, this.d).a();
        if (a2 != null) {
            return new C3165kb(a2.f(), a2.e(), a2.b(), a2.d(), false, 16, null);
        }
        return null;
    }
}
