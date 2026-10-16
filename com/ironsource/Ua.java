package com.ironsource;

import com.ironsource.Va;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Ua {

    /* renamed from: a, reason: collision with root package name */
    private final Wa f3076a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private Ua f3077a = new Ua(null);

        public final a a(String adUnitId) {
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            this.f3077a.a(adUnitId);
            return this;
        }

        public final a b(String placementName) {
            Intrinsics.checkNotNullParameter(placementName, "placementName");
            this.f3077a.b(placementName);
            return this;
        }

        public final a a(Ya listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f3077a.a(listener);
            return this;
        }

        public final Ua a() {
            return this.f3077a;
        }
    }

    public /* synthetic */ Ua(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String c() {
        return this.f3076a.i();
    }

    public final String d() {
        return this.f3076a.j();
    }

    public final Va.a e() {
        return this.f3076a.k();
    }

    public final AdapterNativeAdViewBinder f() {
        return this.f3076a.l();
    }

    public final String g() {
        return this.f3076a.m();
    }

    public final void h() {
        this.f3076a.n();
    }

    private Ua() {
        this.f3076a = new Wa(C3347v7.f3910a.a(), this);
    }

    public final void a() {
        this.f3076a.f();
    }

    public final String b() {
        return this.f3076a.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.f3076a.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str) {
        this.f3076a.b(str);
    }

    public final void a(Ya ya) {
        this.f3076a.a(ya);
    }
}
