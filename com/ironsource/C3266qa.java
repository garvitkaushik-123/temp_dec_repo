package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.qa, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
final class C3266qa implements InterfaceC3215na {

    /* renamed from: a, reason: collision with root package name */
    private final AbstractC3140j3 f3657a;
    private final InterfaceC3232oa b;

    public C3266qa(AbstractC3140j3 legacyStrategy, InterfaceC3232oa listener) {
        Intrinsics.checkNotNullParameter(legacyStrategy, "legacyStrategy");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f3657a = legacyStrategy;
        this.b = listener;
    }

    @Override // com.ironsource.InterfaceC3215na
    public void a(InterfaceC3232oa listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.ironsource.InterfaceC3215na
    public void b() {
        this.f3657a.b();
    }

    @Override // com.ironsource.InterfaceC3215na
    public void c() {
        this.f3657a.c();
    }

    @Override // com.ironsource.InterfaceC3215na
    public void d() {
        this.f3657a.d();
    }

    @Override // com.ironsource.InterfaceC3215na
    public void e() {
        this.f3657a.e();
    }
}
