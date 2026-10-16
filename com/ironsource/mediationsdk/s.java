package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import com.ironsource.A1;
import com.ironsource.A5;
import com.ironsource.C3151je;
import com.ironsource.C3167kd;
import com.ironsource.C3201md;
import com.ironsource.C3260q4;
import com.ironsource.C3334ub;
import com.ironsource.C3337ue;
import com.ironsource.C3351vb;
import com.ironsource.C3354ve;
import com.ironsource.C3388xe;
import com.ironsource.C3413z5;
import com.ironsource.E1;
import com.ironsource.EnumC3135ie;
import com.ironsource.InterfaceC3144j7;
import com.ironsource.InterfaceC3183lc;
import com.ironsource.InterfaceC3335uc;
import com.ironsource.J9;
import com.ironsource.K1;
import com.ironsource.K6;
import com.ironsource.Qc;
import com.ironsource.X4;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* loaded from: classes6.dex */
class s implements InterfaceC3183lc {
    private static s A;

    /* renamed from: a, reason: collision with root package name */
    private C3388xe f3567a;
    private NetworkStateReceiver p;
    private CountDownTimer q;
    private String t;
    private C3337ue u;
    private SegmentListener v;
    private long x;
    private int b = e.f;
    private InterfaceC3144j7 c = C3334ub.U().k();
    private final String d = "appKey";
    private final String e = getClass().getSimpleName();
    private boolean l = false;
    private boolean n = false;
    private List<InterfaceC3335uc> r = new ArrayList();
    private String s = "";
    private f z = new a();
    private Handler m = IronSourceThreadManager.INSTANCE.getInitHandler();
    private int f = 1;
    private int g = 0;
    private int h = 62;
    private int i = 12;
    private int j = 5;
    private AtomicBoolean o = new AtomicBoolean(true);
    private boolean k = false;
    private boolean w = false;
    private J9 y = new J9();

    class a extends f {
        a() {
            super();
        }

        /* JADX WARN: Code restructure failed: missing block: B:68:0x02d0, code lost:
        
            if (r0.g == r0.j) goto L62;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            C3354ve j;
            try {
                p j2 = p.j();
                if (!TextUtils.isEmpty(s.this.s)) {
                    K6.a().a("userId", s.this.s);
                }
                if (!TextUtils.isEmpty(s.this.t)) {
                    K6.a().a("appKey", s.this.t);
                }
                s sVar = s.this;
                sVar.y.i(sVar.s);
                s.this.x = new Date().getTime();
                C3167kd.c().a();
                s.this.u = j2.b(ContextProvider.getInstance().getApplicationContext(), s.this.s, this.c);
                s sVar2 = s.this;
                if (sVar2.u != null) {
                    sVar2.m.removeCallbacks(this);
                    if (s.this.u.p()) {
                        s.this.b(d.INITIATED);
                        new C3351vb().a(s.this.u.c().b().e().b(), j2.z());
                        K1 f = s.this.u.c().b().f();
                        if (f != null) {
                            X4 x4 = X4.f3123a;
                            x4.c(f.g());
                            x4.a(f.f());
                            x4.a(f.j());
                            IronSourceThreadManager.INSTANCE.setUseSharedExecutorService(f.h());
                            s.this.c.a(f);
                        }
                        s.this.a(ContextProvider.getInstance().getApplicationContext(), s.this.u);
                        long time = new Date().getTime();
                        s sVar3 = s.this;
                        j2.a(time - sVar3.x, sVar3.u.h());
                        if (f != null && f.e()) {
                            new C3201md(C3334ub.U().q(), new Function0() { // from class: com.ironsource.mediationsdk.s$a$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    long currentTimeMillis;
                                    currentTimeMillis = System.currentTimeMillis();
                                    return Long.valueOf(currentTimeMillis);
                                }
                            }, C3334ub.U(), IronSourceThreadManager.INSTANCE.getThreadPoolExecutor()).c(ContextProvider.getInstance().getApplicationContext());
                        }
                        s.this.f3567a = new C3388xe();
                        s sVar4 = s.this;
                        sVar4.f3567a.a(sVar4.c);
                        if (s.this.u.c().b().g() && ContextProvider.getInstance().getApplicationContext() != null) {
                            IntegrationHelper.validateIntegration(ContextProvider.getInstance().getApplicationContext());
                        }
                        List<IronSource.AD_UNIT> g = s.this.u.g();
                        Iterator it = s.this.r.iterator();
                        while (it.hasNext()) {
                            ((InterfaceC3335uc) it.next()).a(g, s.this.h(), s.this.u.c());
                        }
                        new Qc.a().a();
                        s sVar5 = s.this;
                        if (sVar5.v != null && (j = sVar5.u.c().b().j()) != null && !TextUtils.isEmpty(j.c())) {
                            s.this.v.onSegmentReceived(j.c());
                        }
                        E1 d = s.this.u.c().b().d();
                        if (d.f()) {
                            C3260q4.d().a(d.b(), d.d(), d.c(), d.e(), IronSourceUtils.getSessionId(), d.a(), d.g());
                        }
                    } else {
                        s sVar6 = s.this;
                        if (!sVar6.l) {
                            sVar6.b(d.INIT_FAILED);
                            s sVar7 = s.this;
                            sVar7.l = true;
                            Iterator it2 = sVar7.r.iterator();
                            while (it2.hasNext()) {
                                ((InterfaceC3335uc) it2.next()).e("serverResponseIsNotValid");
                            }
                        }
                    }
                } else {
                    if (sVar2.g == 3) {
                        sVar2.w = true;
                        Iterator it3 = sVar2.r.iterator();
                        while (it3.hasNext()) {
                            ((InterfaceC3335uc) it3.next()).a();
                        }
                    }
                    if (this.f3573a) {
                        s sVar8 = s.this;
                        if (sVar8.g < sVar8.h) {
                            sVar8.k = true;
                            sVar8.m.postDelayed(this, sVar8.f * 1000);
                            s sVar9 = s.this;
                            if (sVar9.g < sVar9.i) {
                                sVar9.f *= 2;
                            }
                        }
                    }
                    if (this.f3573a) {
                        s sVar10 = s.this;
                    }
                    s sVar11 = s.this;
                    if (!sVar11.l) {
                        sVar11.l = true;
                        if (TextUtils.isEmpty(this.b)) {
                            this.b = "noServerResponse";
                        }
                        Iterator it4 = s.this.r.iterator();
                        while (it4.hasNext()) {
                            ((InterfaceC3335uc) it4.next()).e(this.b);
                        }
                        s.this.b(d.INIT_FAILED);
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No server response", 1);
                    }
                    s.this.g++;
                }
                s.this.e();
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }
    }

    class b implements Runnable {

        class a extends CountDownTimer {
            a(long j, long j2) {
                super(j, j2);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                s sVar = s.this;
                if (sVar.l) {
                    return;
                }
                sVar.l = true;
                Iterator it = sVar.r.iterator();
                while (it.hasNext()) {
                    ((InterfaceC3335uc) it.next()).e("noInternetConnection");
                }
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No internet connection", 1);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (j <= 45000) {
                    s sVar = s.this;
                    sVar.w = true;
                    Iterator it = sVar.r.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC3335uc) it.next()).a();
                    }
                }
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.this.q = new a(60000L, 15000L).start();
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3570a;

        static {
            int[] iArr = new int[d.values().length];
            f3570a = iArr;
            try {
                iArr[d.INIT_IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3570a[d.INIT_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3570a[d.INITIATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    enum d {
        NOT_INIT,
        INIT_IN_PROGRESS,
        INIT_FAILED,
        INITIATED
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public static int f3572a = 0;
        public static int b = 1;
        public static int c = 2;
        public static int d = 3;
        public static int e = 4;
        public static int f = 5;
    }

    abstract class f implements Runnable {
        String b;

        /* renamed from: a, reason: collision with root package name */
        boolean f3573a = true;
        protected p.c c = new a();

        class a implements p.c {
            a() {
            }

            @Override // com.ironsource.mediationsdk.p.c
            public void a(String str) {
                f fVar = f.this;
                fVar.f3573a = false;
                fVar.b = str;
            }
        }

        f() {
        }
    }

    private s() {
    }

    public static synchronized s c() {
        s sVar;
        synchronized (s.class) {
            if (A == null) {
                A = new s();
            }
            sVar = A;
        }
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (C3334ub.U().g().g()) {
            C3334ub.U().q().a(new C3413z5(A5.EP_CONFIG_RECEIVED, (JSONObject) null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        return this.k;
    }

    public void a(Context context, C3337ue c3337ue) {
        this.y.i(c3337ue.f().h());
        this.y.c(c3337ue.f().d());
        A1 b2 = c3337ue.c().b();
        this.y.a(b2.a());
        this.y.d(b2.c().b());
        this.y.b(b2.k().b());
        this.y.a(Boolean.valueOf(IronSourceUtils.getFirstSession(context)));
        K1 f2 = c3337ue.c().b().f();
        this.y.b(f2.b());
        C3334ub.O().o().a(f2.c());
    }

    public int b() {
        return this.b;
    }

    public synchronized boolean d() {
        return this.w;
    }

    void f() {
        b(d.INIT_FAILED);
    }

    public synchronized void g() {
        int a2 = a(a());
        this.b = a2;
        this.y.c(a2);
    }

    public synchronized void b(d dVar) {
        IronLog.INTERNAL.verbose("old status: " + a() + ", new status: " + dVar + ")");
        C3151je.f3381a.a(EnumC3135ie.values()[dVar.ordinal()]);
    }

    public void b(InterfaceC3335uc interfaceC3335uc) {
        if (interfaceC3335uc == null || this.r.size() == 0) {
            return;
        }
        this.r.remove(interfaceC3335uc);
    }

    private static int a(d dVar) {
        int i = c.f3570a[dVar.ordinal()];
        if (i == 1) {
            return e.d;
        }
        if (i == 2) {
            return e.e;
        }
        if (i != 3) {
            return e.f3572a;
        }
        return e.b;
    }

    public synchronized void a(Context context, String str, String str2, IronSource.AD_UNIT... ad_unitArr) {
        try {
            AtomicBoolean atomicBoolean = this.o;
            if (atomicBoolean != null && atomicBoolean.compareAndSet(true, false)) {
                b(d.INIT_IN_PROGRESS);
                this.s = str2;
                this.t = str;
                if (IronSourceUtils.isNetworkConnected(context)) {
                    this.m.post(this.z);
                } else {
                    this.n = true;
                    if (this.p == null) {
                        this.p = new NetworkStateReceiver(context, this);
                    }
                    context.registerReceiver(this.p, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new b());
                }
            } else {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, this.e + ": Multiple calls to init are not allowed", 2);
            }
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
    }

    @Override // com.ironsource.InterfaceC3183lc
    public void a(boolean z) {
        if (this.n && z) {
            CountDownTimer countDownTimer = this.q;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.n = false;
            this.k = true;
            C3334ub.U().q().a(new C3413z5(A5.INIT_AFTER_REACHABILITY_CHANGE, IronSourceUtils.getMediationAdditionalData(false)));
            this.m.post(this.z);
        }
    }

    public synchronized d a() {
        return d.values()[C3151je.f3381a.a().ordinal()];
    }

    public void a(InterfaceC3335uc interfaceC3335uc) {
        if (interfaceC3335uc == null) {
            return;
        }
        this.r.add(interfaceC3335uc);
    }

    public void a(SegmentListener segmentListener) {
        this.v = segmentListener;
    }
}
