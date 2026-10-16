package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.a6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C2988a6 implements W9 {

    /* renamed from: a, reason: collision with root package name */
    private final RunnableC3371we f3176a;
    private long b;

    public C2988a6(InterfaceC3144j7 applicationLifecycleService, RunnableC3371we task) {
        Intrinsics.checkNotNullParameter(applicationLifecycleService, "applicationLifecycleService");
        Intrinsics.checkNotNullParameter(task, "task");
        this.f3176a = task;
        applicationLifecycleService.a(this);
        f();
    }

    private final long e() {
        return System.currentTimeMillis() - this.b;
    }

    private final void f() {
        this.b = System.currentTimeMillis();
    }

    @Override // com.ironsource.W9
    public void a() {
        this.f3176a.a(Long.valueOf(e()));
        this.f3176a.run();
    }

    @Override // com.ironsource.W9
    public void b() {
        f();
    }

    @Override // com.ironsource.W9
    public void c() {
    }

    @Override // com.ironsource.W9
    public void d() {
    }
}
