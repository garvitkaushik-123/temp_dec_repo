package com.ironsource;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.k3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC3157k3 implements InterfaceC3178l7 {

    /* renamed from: com.ironsource.k3$a */
    public static final class a extends AbstractC3157k3 {

        /* renamed from: a, reason: collision with root package name */
        private final b f3385a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b firstReason) {
            super(null);
            Intrinsics.checkNotNullParameter(firstReason, "firstReason");
            this.f3385a = firstReason;
        }

        public final a a(b firstReason) {
            Intrinsics.checkNotNullParameter(firstReason, "firstReason");
            return new a(firstReason);
        }

        public final b d() {
            return this.f3385a;
        }

        public final b e() {
            return this.f3385a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f3385a, ((a) obj).f3385a);
        }

        public int hashCode() {
            return this.f3385a.hashCode();
        }

        public String toString() {
            return "First(firstReason=" + this.f3385a + ")";
        }

        public static /* synthetic */ a a(a aVar, b bVar, int i, Object obj) {
            if ((i & 1) != 0) {
                bVar = aVar.f3385a;
            }
            return aVar.a(bVar);
        }
    }

    /* renamed from: com.ironsource.k3$b */
    public static abstract class b implements InterfaceC3178l7 {

        /* renamed from: com.ironsource.k3$b$a */
        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final a f3386a = new a();

            private a() {
                super(null);
            }
        }

        /* renamed from: com.ironsource.k3$b$b, reason: collision with other inner class name */
        public static final class C0291b extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final C0291b f3387a = new C0291b();

            private C0291b() {
                super(null);
            }
        }

        /* renamed from: com.ironsource.k3$b$c */
        public static final class c extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final c f3388a = new c();

            private c() {
                super(null);
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.ironsource.InterfaceC3178l7
        public String a() {
            if (this instanceof a) {
                return "PublisherLoadFail";
            }
            if (this instanceof C0291b) {
                return "PublisherLoadSuccess";
            }
            if (this instanceof c) {
                return "ResumeAutoRefresh";
            }
            throw new NoWhenBranchMatchedException();
        }

        private b() {
        }
    }

    /* renamed from: com.ironsource.k3$c */
    public static final class c extends AbstractC3157k3 {

        /* renamed from: a, reason: collision with root package name */
        private final long f3389a;
        private final d b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(long j, d recurringReason) {
            super(null);
            Intrinsics.checkNotNullParameter(recurringReason, "recurringReason");
            this.f3389a = j;
            this.b = recurringReason;
        }

        public final c a(long j, d recurringReason) {
            Intrinsics.checkNotNullParameter(recurringReason, "recurringReason");
            return new c(j, recurringReason);
        }

        public final long d() {
            return this.f3389a;
        }

        public final d e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f3389a == cVar.f3389a && Intrinsics.areEqual(this.b, cVar.b);
        }

        public final d f() {
            return this.b;
        }

        public final long g() {
            return this.f3389a;
        }

        public int hashCode() {
            return (Long.hashCode(this.f3389a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Recurring(reloadDuration=" + this.f3389a + ", recurringReason=" + this.b + ")";
        }

        public static /* synthetic */ c a(c cVar, long j, d dVar, int i, Object obj) {
            if ((i & 1) != 0) {
                j = cVar.f3389a;
            }
            if ((i & 2) != 0) {
                dVar = cVar.b;
            }
            return cVar.a(j, dVar);
        }
    }

    /* renamed from: com.ironsource.k3$d */
    public static abstract class d implements InterfaceC3178l7 {

        /* renamed from: com.ironsource.k3$d$a */
        public static final class a extends d {

            /* renamed from: a, reason: collision with root package name */
            public static final a f3390a = new a();

            private a() {
                super(null);
            }
        }

        /* renamed from: com.ironsource.k3$d$b */
        public static final class b extends d {

            /* renamed from: a, reason: collision with root package name */
            public static final b f3391a = new b();

            private b() {
                super(null);
            }
        }

        /* renamed from: com.ironsource.k3$d$c */
        public static final class c extends d {

            /* renamed from: a, reason: collision with root package name */
            public static final c f3392a = new c();

            private c() {
                super(null);
            }
        }

        /* renamed from: com.ironsource.k3$d$d, reason: collision with other inner class name */
        public static final class C0292d extends d {

            /* renamed from: a, reason: collision with root package name */
            public static final C0292d f3393a = new C0292d();

            private C0292d() {
                super(null);
            }
        }

        /* renamed from: com.ironsource.k3$d$e */
        public static final class e extends d {

            /* renamed from: a, reason: collision with root package name */
            public static final e f3394a = new e();

            private e() {
                super(null);
            }
        }

        /* renamed from: com.ironsource.k3$d$f */
        public static final class f extends d {

            /* renamed from: a, reason: collision with root package name */
            private final long f3395a;

            public f(long j) {
                super(null);
                this.f3395a = j;
            }

            public final f a(long j) {
                return new f(j);
            }

            public final long c() {
                return this.f3395a;
            }

            public final long d() {
                return this.f3395a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof f) && this.f3395a == ((f) obj).f3395a;
            }

            public int hashCode() {
                return Long.hashCode(this.f3395a);
            }

            public String toString() {
                return "ResumeVisibility(notVisibleDuration=" + this.f3395a + ")";
            }

            public static /* synthetic */ f a(f fVar, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = fVar.f3395a;
                }
                return fVar.a(j);
            }
        }

        /* renamed from: com.ironsource.k3$d$g */
        public static final class g extends d {

            /* renamed from: a, reason: collision with root package name */
            public static final g f3396a = new g();

            private g() {
                super(null);
            }
        }

        /* renamed from: com.ironsource.k3$d$h */
        public static final class h extends d {

            /* renamed from: a, reason: collision with root package name */
            public static final h f3397a = new h();

            private h() {
                super(null);
            }
        }

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.ironsource.InterfaceC3178l7
        public String a() {
            if (this instanceof f) {
                return "ResumeVisibility";
            }
            if (this instanceof a) {
                return "PublisherLoadFail";
            }
            if (this instanceof b) {
                return "PublisherLoadSuccess";
            }
            if (this instanceof e) {
                return "ResumeAutoRefresh";
            }
            if (this instanceof c) {
                return "ReloadFailAfterTimer";
            }
            if (this instanceof C0292d) {
                return "ReloadSuccessAfterTimer";
            }
            if (this instanceof g) {
                return "TimerAfterReloadFail";
            }
            if (this instanceof h) {
                return "TimerAfterReloadSuccess";
            }
            throw new NoWhenBranchMatchedException();
        }

        public final long b() {
            if (this instanceof f) {
                return ((f) this).d();
            }
            return 0L;
        }

        private d() {
        }
    }

    public /* synthetic */ AbstractC3157k3(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.ironsource.InterfaceC3178l7
    public String a() {
        if (this instanceof a) {
            return ((a) this).e().a();
        }
        if (this instanceof c) {
            return ((c) this).f().a();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final long b() {
        if (this instanceof a) {
            return 0L;
        }
        if (this instanceof c) {
            return ((c) this).f().b();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final long c() {
        if (this instanceof a) {
            return 0L;
        }
        if (this instanceof c) {
            return ((c) this).g();
        }
        throw new NoWhenBranchMatchedException();
    }

    private AbstractC3157k3() {
    }
}
