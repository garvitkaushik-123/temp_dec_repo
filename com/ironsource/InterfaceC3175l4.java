package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.l4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC3175l4 {

    /* renamed from: com.ironsource.l4$a */
    public static final class a implements InterfaceC3175l4 {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f3442a;

        public a(boolean z) {
            this.f3442a = z;
        }

        @Override // com.ironsource.InterfaceC3175l4
        public void a() {
            C3348v8.a(Md.x, new C3264q8().a(D5.y, Boolean.valueOf(this.f3442a)).a());
        }
    }

    /* renamed from: com.ironsource.l4$b */
    public static final class b implements InterfaceC3175l4 {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f3443a;
        private final long b;
        private final InterfaceC3293s4 c;

        public b(boolean z, long j, InterfaceC3293s4 currentTimeProvider) {
            Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
            this.f3443a = z;
            this.b = j;
            this.c = currentTimeProvider;
        }

        @Override // com.ironsource.InterfaceC3175l4
        public void a() {
            C3264q8 a2 = new C3264q8().a(D5.y, Boolean.valueOf(this.f3443a));
            if (this.b > 0) {
                a2.a(D5.B, Long.valueOf(this.c.a() - this.b));
            }
            C3348v8.a(Md.w, a2.a());
        }

        public final InterfaceC3293s4 b() {
            return this.c;
        }
    }

    void a();
}
