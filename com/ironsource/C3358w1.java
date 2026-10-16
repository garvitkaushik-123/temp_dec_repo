package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.w1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3358w1 extends Oc {
    public static final a f = new a(null);
    private static final String g = "AppLifecycleTrigger";
    private final com.ironsource.lifecycle.b d;
    private final W9 e;

    /* renamed from: com.ironsource.w1$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: com.ironsource.w1$b */
    public static final class b implements W9 {
        b() {
        }

        @Override // com.ironsource.W9
        public void a() {
        }

        @Override // com.ironsource.W9
        public void b() {
        }

        @Override // com.ironsource.W9
        public void c() {
            C3358w1.this.a(false);
        }

        @Override // com.ironsource.W9
        public void d() {
            C3358w1.this.a(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3358w1(com.ironsource.lifecycle.b lifeCycleObserver) {
        super(false, 1, null);
        Intrinsics.checkNotNullParameter(lifeCycleObserver, "lifeCycleObserver");
        this.d = lifeCycleObserver;
        b bVar = new b();
        this.e = bVar;
        lifeCycleObserver.a(bVar);
        a(lifeCycleObserver.e());
    }

    @Override // com.ironsource.Oc
    public String b() {
        return g;
    }

    public final void e() {
        this.d.b(this.e);
    }
}
