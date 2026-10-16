package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class P7 implements InterfaceC2914w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T7 f2396a;

    public P7(T7 t7) {
        this.f2396a = t7;
    }

    @Override // com.inmobi.media.InterfaceC2914w
    public final void a() {
        Intrinsics.checkNotNullExpressionValue(this.f2396a.m, "access$getTAG$p(...)");
        P0 p0 = this.f2396a.w;
        if (p0 != null) {
            p0.c();
        }
    }

    @Override // com.inmobi.media.InterfaceC2914w
    public final void b(Object obj) {
        P0 p0 = this.f2396a.w;
        if (p0 != null) {
            p0.b();
        }
        InterfaceC2971z5 interfaceC2971z5 = this.f2396a.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a();
        }
    }

    @Override // com.inmobi.media.InterfaceC2914w
    public final void a(Object obj) {
        P0 p0;
        if (this.f2396a.f() == null || (p0 = this.f2396a.w) == null) {
            return;
        }
        p0.d();
    }
}
