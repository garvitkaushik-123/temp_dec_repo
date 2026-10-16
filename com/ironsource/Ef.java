package com.ironsource;

import com.ironsource.Gf;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface Ef {

    public interface a {
        void a();
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private long f2849a;
        private long b;

        public final long a() {
            return this.b;
        }

        public final long b() {
            return this.f2849a;
        }

        public final void a(long j) {
            this.b = j;
        }

        public final void b(long j) {
            this.f2849a = j;
        }
    }

    public interface c {
        Ef a(b bVar);
    }

    public static final class d implements c {
        @Override // com.ironsource.Ef.c
        public Ef a(b timerConfig) {
            Intrinsics.checkNotNullParameter(timerConfig, "timerConfig");
            return new e(new Gf(timerConfig.b()));
        }
    }

    private static final class e implements Ef {

        /* renamed from: a, reason: collision with root package name */
        private final Gf f2850a;

        public static final class a implements Gf.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f2851a;

            a(a aVar) {
                this.f2851a = aVar;
            }

            @Override // com.ironsource.Gf.a
            public void a() {
                this.f2851a.a();
            }
        }

        public e(Gf timer) {
            Intrinsics.checkNotNullParameter(timer, "timer");
            this.f2850a = timer;
        }

        @Override // com.ironsource.Ef
        public void a(a callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f2850a.a((Gf.a) new a(callback));
        }

        @Override // com.ironsource.Ef
        public void cancel() {
            this.f2850a.e();
        }
    }

    void a(a aVar);

    void cancel();
}
