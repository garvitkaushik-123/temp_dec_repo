package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class S implements Vf {

    /* renamed from: a, reason: collision with root package name */
    private final String f3036a;
    private final InterfaceC3062e9 b;
    private final boolean c;

    static final class a extends Lambda implements Function0<IronSourceError> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3037a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C3362w5.f3920a.r();
        }
    }

    static final class b extends Lambda implements Function0<IronSourceError> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3038a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C3362w5.f3920a.o();
        }
    }

    static final class c extends Lambda implements Function0<IronSourceError> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f3039a = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C3362w5.f3920a.n();
        }
    }

    static final class d extends Lambda implements Function0<IronSourceError> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f3040a = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C3362w5.f3920a.q();
        }
    }

    static final class e extends Lambda implements Function0<IronSourceError> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f3041a = new e();

        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C3362w5.f3920a.o();
        }
    }

    static final class f extends Lambda implements Function0<IronSourceError> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f3042a = new f();

        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C3362w5.f3920a.g();
        }
    }

    public S(String adm, InterfaceC3062e9 interfaceC3062e9, boolean z) {
        Intrinsics.checkNotNullParameter(adm, "adm");
        this.f3036a = adm;
        this.b = interfaceC3062e9;
        this.c = z;
    }

    @Override // com.ironsource.Vf
    public void a() throws Wd {
        a(this.c, a.f3037a);
        a(this.b != null, b.f3038a);
        InterfaceC3062e9 interfaceC3062e9 = this.b;
        if (interfaceC3062e9 != null) {
            if (interfaceC3062e9.f() == EnumC3096g9.NonBidder) {
                a(this.f3036a.length() == 0, c.f3039a);
            }
            if (interfaceC3062e9.f() == EnumC3096g9.Bidder) {
                a(this.f3036a.length() > 0, d.f3040a);
            }
            a(interfaceC3062e9.f() != EnumC3096g9.NotSupported, e.f3041a);
            a(interfaceC3062e9.e().length() > 0, f.f3042a);
        }
    }
}
