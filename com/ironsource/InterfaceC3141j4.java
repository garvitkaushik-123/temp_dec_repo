package com.ironsource;

import com.ironsource.Ef;
import com.ironsource.InterfaceC3006b7;
import com.ironsource.Y6;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.j4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC3141j4 {

    /* renamed from: a, reason: collision with root package name */
    public static final c f3372a = c.f3374a;

    /* renamed from: com.ironsource.j4$a */
    public static final class a implements InterfaceC3141j4 {
        private final X6 b;
        private final Ef c;
        private final AtomicBoolean d;

        /* renamed from: com.ironsource.j4$a$a, reason: collision with other inner class name */
        public static final class C0290a implements Ef.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f3373a;
            final /* synthetic */ a b;

            C0290a(d dVar, a aVar) {
                this.f3373a = dVar;
                this.b = aVar;
            }

            @Override // com.ironsource.Ef.a
            public void a() {
                this.f3373a.a(new InterfaceC3006b7.a(new Y6.a(this.b.b.b())));
                this.b.d.set(false);
            }
        }

        public a(X6 config, Ef timer) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(timer, "timer");
            this.b = config;
            this.c = timer;
            this.d = new AtomicBoolean(false);
        }

        @Override // com.ironsource.InterfaceC3141j4
        public synchronized void a(d callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (this.d.compareAndSet(false, true)) {
                this.c.a(new C0290a(callback, this));
            }
        }

        @Override // com.ironsource.InterfaceC3141j4
        public synchronized void a() {
            this.c.cancel();
            this.d.set(false);
        }
    }

    /* renamed from: com.ironsource.j4$b */
    public static final class b implements InterfaceC3141j4 {
        public static final b b = new b();

        private b() {
        }

        @Override // com.ironsource.InterfaceC3141j4
        public void a() {
        }

        @Override // com.ironsource.InterfaceC3141j4
        public void a(d callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
        }
    }

    /* renamed from: com.ironsource.j4$d */
    public interface d {
        void a(InterfaceC3006b7 interfaceC3006b7);
    }

    @JvmStatic
    static InterfaceC3141j4 a(Z6 z6) {
        return f3372a.a(z6);
    }

    void a();

    void a(d dVar);

    /* renamed from: com.ironsource.j4$c */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ c f3374a = new c();

        private c() {
        }

        @JvmStatic
        public final InterfaceC3141j4 a(Z6 featureFlag) {
            Intrinsics.checkNotNullParameter(featureFlag, "featureFlag");
            if (!featureFlag.b()) {
                return b.b;
            }
            W6 w6 = new W6(featureFlag);
            Ef.b bVar = new Ef.b();
            bVar.b(w6.a());
            bVar.a(w6.a());
            return new a(w6, new Ef.d().a(bVar));
        }

        public final InterfaceC3141j4 a() {
            return b.b;
        }
    }
}
