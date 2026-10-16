package com.ironsource;

import com.ironsource.InterfaceC3246p7;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Ue implements InterfaceC3246p7, InterfaceC3246p7.a {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3293s4 f3081a;
    private final O8 b;
    private final Map<String, Re> c;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private int f3082a;
        private long b;
        private Long c;

        public a(int i, long j, Long l) {
            this.f3082a = i;
            this.b = j;
            this.c = l;
        }

        public final int a() {
            return this.f3082a;
        }

        public final long b() {
            return this.b;
        }

        public final Long c() {
            return this.c;
        }

        public final int d() {
            return this.f3082a;
        }

        public final long e() {
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
            return this.f3082a == aVar.f3082a && this.b == aVar.b && Intrinsics.areEqual(this.c, aVar.c);
        }

        public final Long f() {
            return this.c;
        }

        public int hashCode() {
            int hashCode = ((Integer.hashCode(this.f3082a) * 31) + Long.hashCode(this.b)) * 31;
            Long l = this.c;
            return hashCode + (l == null ? 0 : l.hashCode());
        }

        public String toString() {
            return "ShowCountCappingInfo(currentNumberOfShows=" + this.f3082a + ", currentTime=" + this.b + ", currentTimeThreshold=" + this.c + ")";
        }

        public final a a(int i, long j, Long l) {
            return new a(i, j, l);
        }

        public static /* synthetic */ a a(a aVar, int i, long j, Long l, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = aVar.f3082a;
            }
            if ((i2 & 2) != 0) {
                j = aVar.b;
            }
            if ((i2 & 4) != 0) {
                l = aVar.c;
            }
            return aVar.a(i, j, l);
        }

        public final void a(int i) {
            this.f3082a = i;
        }

        public final void a(long j) {
            this.b = j;
        }

        public final void a(Long l) {
            this.c = l;
        }
    }

    public Ue(InterfaceC3293s4 currentTimeProvider, O8 serviceDataRepository) {
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        Intrinsics.checkNotNullParameter(serviceDataRepository, "serviceDataRepository");
        this.f3081a = currentTimeProvider;
        this.b = serviceDataRepository;
        this.c = new LinkedHashMap();
    }

    private final a c(String str) {
        return new a(this.b.a(str), this.f3081a.a(), this.b.b(str));
    }

    public final Map<String, Re> a() {
        return this.c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
    
        if (r4 >= (r2 != null ? r2.longValue() : 0)) goto L13;
     */
    @Override // com.ironsource.InterfaceC3246p7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Re re = this.c.get(identifier);
        if (re == null) {
            return;
        }
        a c = c(identifier);
        if (c.d() != 0) {
            long e = c.e();
            Long f = c.f();
        }
        this.b.a(c.e() + O3.a(re.b(), null, 1, null), identifier);
        c.a(0);
        c.a(c.d() + 1);
        this.b.a(c.d(), identifier);
    }

    @Override // com.ironsource.InterfaceC3246p7
    public N3 a(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Re re = this.c.get(identifier);
        return re == null ? new N3(false, null, 2, null) : a(re, identifier) ? new N3(true, P3.ShowCount) : new N3(false, null, 2, null);
    }

    private final boolean a(Re re, String str) {
        a c = c(str);
        Long f = c.f();
        if (f != null) {
            long longValue = f.longValue();
            if (c.d() >= re.a() && this.f3081a.a() < longValue) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ironsource.InterfaceC3246p7.a
    public Object a(String identifier, P3 cappingType, InterfaceC3212n7 cappingConfig) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(cappingType, "cappingType");
        Intrinsics.checkNotNullParameter(cappingConfig, "cappingConfig");
        Object c = cappingConfig.c();
        if (Result.m10248isSuccessimpl(c)) {
            Re re = (Re) c;
            if (re != null) {
                this.c.put(identifier, re);
            }
            Result.Companion companion = Result.INSTANCE;
            return Result.m10241constructorimpl(Unit.INSTANCE);
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(c);
        if (m10244exceptionOrNullimpl != null) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl));
        }
        Result.Companion companion3 = Result.INSTANCE;
        return Result.m10241constructorimpl(Unit.INSTANCE);
    }
}
