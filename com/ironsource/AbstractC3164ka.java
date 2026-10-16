package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.ka, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC3164ka {

    /* renamed from: a, reason: collision with root package name */
    private final C3205n0 f3407a;
    private String b;
    private boolean c;

    public AbstractC3164ka(C3205n0 adTools) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        this.f3407a = adTools;
        this.b = "";
    }

    public final C3205n0 a() {
        return this.f3407a;
    }

    public final String b() {
        return this.b;
    }

    protected final boolean c() {
        return this.c;
    }

    public abstract boolean d();

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void b(Runnable callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f3407a.e(callback);
    }

    protected final void a(boolean z) {
        this.c = z;
    }

    public final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.f3407a.d(runnable);
    }

    public final void a(C3070f0 adProperties) {
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        this.f3407a.e().a(new B0(this.f3407a, adProperties, null, 4, null));
    }
}
