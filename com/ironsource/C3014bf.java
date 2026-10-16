package com.ironsource;

import android.os.Handler;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.bf, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3014bf implements Nc {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f3205a;
    private final long b;
    private long c;
    private long d;
    private long e;
    private final b f;

    /* renamed from: com.ironsource.bf$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final long f3206a;
        private final long b;

        public a(long j, long j2) {
            this.f3206a = j;
            this.b = j2;
        }

        public final long a() {
            return this.f3206a;
        }

        public final long b() {
            return this.b;
        }

        public final long c() {
            return this.f3206a;
        }

        public final long d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3206a == aVar.f3206a && this.b == aVar.b;
        }

        public int hashCode() {
            return (Long.hashCode(this.f3206a) * 31) + Long.hashCode(this.b);
        }

        public String toString() {
            return "Status(remainingTime=" + this.f3206a + ", timePassed=" + this.b + ")";
        }

        public final a a(long j, long j2) {
            return new a(j, j2);
        }

        public static /* synthetic */ a a(a aVar, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = aVar.f3206a;
            }
            if ((i & 2) != 0) {
                j2 = aVar.b;
            }
            return aVar.a(j, j2);
        }
    }

    /* renamed from: com.ironsource.bf$b */
    public static final class b extends Pd {
        final /* synthetic */ Runnable b;

        b(Runnable runnable) {
            this.b = runnable;
        }

        @Override // com.ironsource.Pd
        public void a() {
            this.b.run();
        }
    }

    public C3014bf(Handler handler, Runnable task, long j) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(task, "task");
        this.f3205a = handler;
        this.b = j;
        this.f = new b(task);
        this.e = c();
        b();
    }

    private final long c() {
        return System.currentTimeMillis();
    }

    private final long d() {
        return this.b - this.c;
    }

    @Override // com.ironsource.Nc
    public a a() {
        if (!e()) {
            long c = c();
            this.e = c;
            this.c += c - this.d;
            this.f3205a.removeCallbacks(this.f);
        }
        return new a(d(), this.c);
    }

    @Override // com.ironsource.Nc
    public a b() {
        if (e()) {
            this.d = c();
            this.e = 0L;
            this.f3205a.postDelayed(this.f, d());
        }
        return new a(d(), this.c);
    }

    public final boolean e() {
        return this.e > 0;
    }
}
