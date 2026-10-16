package io.bidmachine.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import io.bidmachine.analytics.internal.InterfaceC3583x;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutKt;

/* renamed from: io.bidmachine.analytics.internal.o, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3575o {
    public static final i l = new i(null);
    private static final Lazy m = LazyKt.lazy(d.f6737a);
    private static final Lazy n = LazyKt.lazy(e.f6738a);
    private static final Lazy o = LazyKt.lazy(f.f6739a);
    private static final Lazy p = LazyKt.lazy(b.f6735a);
    private static final Lazy q = LazyKt.lazy(h.f6741a);
    private static final Lazy r = LazyKt.lazy(c.f6736a);
    private static final Lazy s = LazyKt.lazy(g.f6740a);
    private static final Lazy t = LazyKt.lazy(a.f6734a);

    /* renamed from: a, reason: collision with root package name */
    private final Context f6733a;
    private volatile C3576p b;
    private volatile boolean c;
    private volatile boolean d;
    private final Lazy e = LazyKt.lazy(C0597o.f6747a);
    private final Lazy f = LazyKt.lazy(new l());
    private final Lazy g = LazyKt.lazy(new m());
    private final Lazy h = LazyKt.lazy(new n());
    private final Lazy i = LazyKt.lazy(new p());
    private final Lazy j = LazyKt.lazy(new j());
    private final ServiceConnection k = new q();

    /* renamed from: io.bidmachine.analytics.internal.o$a */
    static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6734a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("cGxheUJpbGxpbmdMaWJyYXJ5VmVyc2lvbg==");
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$b */
    static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f6735a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("VkVSU0lPTl9OQU1F");
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$c */
    static final class c extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f6736a = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("Y29tLmFuZHJvaWQudmVuZGluZy5iaWxsaW5nLkluQXBwQmlsbGluZ1NlcnZpY2UuQklORA==");
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$d */
    static final class d extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final d f6737a = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("Y29tLmFuZHJvaWQuYmlsbGluZ2NsaWVudC5CdWlsZENvbmZpZw==");
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$e */
    static final class e extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final e f6738a = new e();

        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("Y29tLmFuZHJvaWQuYmlsbGluZ2NsaWVudC5rdHguQnVpbGRDb25maWc=");
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$f */
    static final class f extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final f f6739a = new f();

        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("Y29tLmdvb2dsZS5hbmRyb2lkLnBsYXkuYmlsbGluZ2NsaWVudC52ZXJzaW9u");
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$g */
    static final class g extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final g f6740a = new g();

        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("Y29tLmFuZHJvaWQudmVuZGluZw==");
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$h */
    static final class h extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final h f6741a = new h();

        h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return s0.a("Y29tLmFuZHJvaWQudmVuZGluZy5CSUxMSU5H");
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$i */
    public static final class i {
        public /* synthetic */ i(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return (String) C3575o.t.getValue();
        }

        public final String b() {
            return (String) C3575o.p.getValue();
        }

        public final String c() {
            return (String) C3575o.r.getValue();
        }

        public final String d() {
            return (String) C3575o.m.getValue();
        }

        public final String e() {
            return (String) C3575o.n.getValue();
        }

        public final String f() {
            return (String) C3575o.o.getValue();
        }

        public final String g() {
            return (String) C3575o.s.getValue();
        }

        public final String h() {
            return (String) C3575o.q.getValue();
        }

        private i() {
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$j */
    static final class j extends Lambda implements Function0 {
        j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t0 invoke() {
            Object m10241constructorimpl;
            t0 a2;
            C3575o c3575o = C3575o.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                String p = c3575o.p();
                if (p == null || (a2 = t0.d.a(p)) == null) {
                    String n = c3575o.n();
                    a2 = n != null ? t0.d.a(n) : null;
                }
                m10241constructorimpl = Result.m10241constructorimpl(a2);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
            return (t0) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$k */
    static final class k extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        int f6743a;

        k(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return C3575o.this.new k(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6743a;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            while (C3575o.this.b == null) {
                this.f6743a = 1;
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            C3576p c3576p = C3575o.this.b;
            if (c3576p != null) {
                return c3576p.s();
            }
            return null;
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$l */
    static final class l extends Lambda implements Function0 {
        l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return C3575o.this.a(C3575o.l.d());
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$m */
    static final class m extends Lambda implements Function0 {
        m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return C3575o.this.a(C3575o.l.e());
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$n */
    static final class n extends Lambda implements Function0 {
        n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return C3575o.this.m();
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$o, reason: collision with other inner class name */
    static final class C0597o extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final C0597o f6747a = new C0597o();

        C0597o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Random invoke() {
            return RandomKt.Random(System.nanoTime());
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$p */
    static final class p extends Lambda implements Function0 {
        p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            String o = C3575o.this.o();
            if (o != null) {
                return o;
            }
            String n = C3575o.this.n();
            return n == null ? C3575o.this.p() : n;
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.o$q */
    public static final class q implements ServiceConnection {
        q() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C3576p c3576p;
            t0 l = C3575o.this.l();
            if (l == null) {
                throw new IllegalArgumentException("Version not found in connected callback");
            }
            C3575o c3575o = C3575o.this;
            String r = c3575o.r();
            if (r != null) {
                C3575o c3575o2 = C3575o.this;
                c3576p = new C3576p(new InterfaceC3583x.a(iBinder, InterfaceC3583x.a.d.a(l), null, 4, null), c3575o2.f6733a.getPackageName(), l, r, c3575o2.q().nextLong());
            } else {
                c3576p = null;
            }
            c3575o.b = c3576p;
            C3575o c3575o3 = C3575o.this;
            c3575o3.c = c3575o3.b != null;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C3575o.this.c = false;
            C3575o.this.b = null;
        }
    }

    public C3575o(Context context) {
        this.f6733a = context;
    }

    private final Intent k() {
        i iVar = l;
        Intent intent = new Intent(iVar.c());
        intent.setPackage(iVar.g());
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Bundle bundle = this.f6733a.getPackageManager().getApplicationInfo(this.f6733a.getPackageName(), 128).metaData;
            m10241constructorimpl = Result.m10241constructorimpl(bundle != null ? bundle.getString(l.f()) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        return (String) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n() {
        return (String) this.f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String o() {
        return (String) this.g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p() {
        return (String) this.h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Random q() {
        return (Random) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String r() {
        return (String) this.i.getValue();
    }

    private final ComponentName s() {
        ServiceInfo serviceInfo;
        List<ResolveInfo> queryIntentServices = this.f6733a.getPackageManager().queryIntentServices(k(), 0);
        if (!queryIntentServices.isEmpty() && (serviceInfo = queryIntentServices.get(0).serviceInfo) != null) {
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (Intrinsics.areEqual(l.g(), str) && str2 != null) {
                return new ComponentName(str, str2);
            }
        }
        return null;
    }

    public final void i() {
        ComponentName s2 = s();
        if (s2 == null) {
            throw new IllegalArgumentException("Component name not found");
        }
        String r2 = r();
        if (r2 == null) {
            throw new IllegalArgumentException("Library version not found");
        }
        Context context = this.f6733a;
        Intent k2 = k();
        k2.setComponent(s2);
        k2.putExtra(l.a(), r2);
        if (!context.bindService(k2, this.k, 1)) {
            throw new IllegalStateException("Can't connect");
        }
        this.d = true;
    }

    public final void j() {
        if (this.d) {
            this.f6733a.unbindService(this.k);
        }
        this.d = false;
    }

    public final t0 l() {
        return (t0) this.j.getValue();
    }

    public final boolean t() {
        return this.f6733a.getPackageManager().checkPermission(l.h(), this.f6733a.getPackageName()) == 0;
    }

    public final boolean u() {
        return s() != null;
    }

    public final Object a(long j2, Continuation continuation) {
        return TimeoutKt.withTimeoutOrNull(j2, new k(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(String str) {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Object obj = Class.forName(str).getField(l.b()).get(null);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            m10241constructorimpl = Result.m10241constructorimpl((String) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        return (String) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
    }
}
