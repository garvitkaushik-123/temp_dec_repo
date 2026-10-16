package com.ironsource;

import android.os.Handler;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.testSuite.TestSuiteActivity;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.ironsource.gf, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3102gf {

    /* renamed from: a, reason: collision with root package name */
    private final c f3323a;
    private final d b;
    private final b c;

    /* renamed from: com.ironsource.gf$b */
    public interface b {
        void a(double d);

        void a(C3203mf c3203mf, String str, int i, int i2);

        void d();
    }

    /* renamed from: com.ironsource.gf$c */
    public interface c {
        void b();

        void b(C3203mf c3203mf);

        boolean e();
    }

    /* renamed from: com.ironsource.gf$d */
    public interface d {
        void a(C3203mf c3203mf);

        boolean a();

        void c();
    }

    public /* synthetic */ C3102gf(c cVar, d dVar, b bVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, dVar, bVar);
    }

    public final b a() {
        return this.c;
    }

    public final c b() {
        return this.f3323a;
    }

    public final d c() {
        return this.b;
    }

    private C3102gf(c cVar, d dVar, b bVar) {
        this.f3323a = cVar;
        this.b = dVar;
        this.c = bVar;
    }

    /* renamed from: com.ironsource.gf$a */
    public static final class a {

        /* renamed from: com.ironsource.gf$a$a, reason: collision with other inner class name */
        static final class C0287a extends Lambda implements Function0<C3254pf> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ TestSuiteActivity f3324a;
            final /* synthetic */ Handler b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0287a(TestSuiteActivity testSuiteActivity, Handler handler) {
                super(0);
                this.f3324a = testSuiteActivity;
                this.b = handler;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C3254pf invoke() {
                return new C3254pf(this.f3324a, this.b);
            }
        }

        /* renamed from: com.ironsource.gf$a$b */
        static final class b extends Lambda implements Function0<C3372wf> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ TestSuiteActivity f3325a;
            final /* synthetic */ Handler b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(TestSuiteActivity testSuiteActivity, Handler handler) {
                super(0);
                this.f3325a = testSuiteActivity;
                this.b = handler;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C3372wf invoke() {
                return new C3372wf(this.f3325a, this.b);
            }
        }

        private static final C3372wf b(Lazy<C3372wf> lazy) {
            return lazy.getValue();
        }

        public final C3102gf a(List<? extends IronSource.AD_UNIT> maduEnabledAdUnits, TestSuiteActivity activity, Handler handler) {
            Intrinsics.checkNotNullParameter(maduEnabledAdUnits, "maduEnabledAdUnits");
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Lazy lazy = LazyKt.lazy(new C0287a(activity, handler));
            Lazy lazy2 = LazyKt.lazy(new b(activity, handler));
            return new C3102gf(maduEnabledAdUnits.contains(IronSource.AD_UNIT.INTERSTITIAL) ? a(lazy) : b(lazy2), maduEnabledAdUnits.contains(IronSource.AD_UNIT.REWARDED_VIDEO) ? a(lazy) : b(lazy2), maduEnabledAdUnits.contains(IronSource.AD_UNIT.BANNER) ? a(lazy) : b(lazy2), null);
        }

        private static final C3254pf a(Lazy<C3254pf> lazy) {
            return lazy.getValue();
        }
    }
}
