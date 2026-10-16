package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import com.ironsource.A4;
import com.ironsource.C3040d4;
import com.ironsource.C3091g4;
import com.ironsource.C3092g5;
import com.ironsource.C3230o8;
import com.ironsource.C3247p8;
import com.ironsource.C3260q4;
import com.ironsource.C3264q8;
import com.ironsource.C3273r1;
import com.ironsource.C3334ub;
import com.ironsource.C3348v8;
import com.ironsource.C3365w8;
import com.ironsource.C3368wb;
import com.ironsource.C3385xb;
import com.ironsource.C3412z4;
import com.ironsource.D5;
import com.ironsource.EnumC2989a7;
import com.ironsource.InterfaceC3344v4;
import com.ironsource.InterfaceC3361w4;
import com.ironsource.InterfaceC3378x4;
import com.ironsource.L;
import com.ironsource.Md;
import com.ironsource.R7;
import com.ironsource.S3;
import com.ironsource.V4;
import com.ironsource.W4;
import com.ironsource.W5;
import com.ironsource.X5;
import com.ironsource.Xb;
import com.ironsource.Y6;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.l;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.tg;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class e implements com.ironsource.sdk.controller.c, com.ironsource.sdk.controller.l {
    private com.ironsource.sdk.controller.l b;
    private CountDownTimer d;
    private final R7 g;
    private final tg h;
    private final Xb k;

    /* renamed from: a, reason: collision with root package name */
    private final String f3718a = "e";
    private C3230o8.b c = C3230o8.b.None;
    private final S3 e = new S3("NativeCommandExecutor");
    private final S3 f = new S3("ControllerCommandsExecutor");
    private final Map<String, l.a> i = new HashMap();
    private final Map<String, l.b> j = new HashMap();

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f3719a;
        final /* synthetic */ InterfaceC3361w4 b;

        a(JSONObject jSONObject, InterfaceC3361w4 interfaceC3361w4) {
            this.f3719a = jSONObject;
            this.b = interfaceC3361w4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.b;
            if (lVar != null) {
                lVar.a(this.f3719a, this.b);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ V4 f3720a;
        final /* synthetic */ Map b;
        final /* synthetic */ InterfaceC3361w4 c;

        b(V4 v4, Map map, InterfaceC3361w4 interfaceC3361w4) {
            this.f3720a = v4;
            this.b = map;
            this.c = interfaceC3361w4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.b;
            if (lVar != null) {
                lVar.a(this.f3720a, this.b, this.c);
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3721a;
        final /* synthetic */ String b;
        final /* synthetic */ V4 c;
        final /* synthetic */ InterfaceC3344v4 d;

        c(String str, String str2, V4 v4, InterfaceC3344v4 interfaceC3344v4) {
            this.f3721a = str;
            this.b = str2;
            this.c = v4;
            this.d = interfaceC3344v4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.b;
            if (lVar != null) {
                lVar.a(this.f3721a, this.b, this.c, this.d);
            }
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f3722a;
        final /* synthetic */ InterfaceC3344v4 b;

        d(JSONObject jSONObject, InterfaceC3344v4 interfaceC3344v4) {
            this.f3722a = jSONObject;
            this.b = interfaceC3344v4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.b;
            if (lVar != null) {
                lVar.a(this.f3722a, this.b);
            }
        }
    }

    /* renamed from: com.ironsource.sdk.controller.e$e, reason: collision with other inner class name */
    class RunnableC0300e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ V4 f3723a;

        RunnableC0300e(V4 v4) {
            this.f3723a = v4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.b;
            if (lVar != null) {
                lVar.a(this.f3723a);
            }
        }
    }

    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ V4 f3724a;

        f(V4 v4) {
            this.f3724a = v4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.b;
            if (lVar != null) {
                lVar.b(this.f3724a);
            }
        }
    }

    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ V4 f3725a;
        final /* synthetic */ Map b;
        final /* synthetic */ InterfaceC3344v4 c;

        g(V4 v4, Map map, InterfaceC3344v4 interfaceC3344v4) {
            this.f3725a = v4;
            this.b = map;
            this.c = interfaceC3344v4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.b;
            if (lVar != null) {
                lVar.a(this.f3725a, this.b, this.c);
            }
        }
    }

    class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l.a f3726a;
        final /* synthetic */ f.c b;

        h(l.a aVar, f.c cVar) {
            this.f3726a = aVar;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            if (eVar.b != null) {
                if (this.f3726a != null) {
                    eVar.i.put(this.b.f(), this.f3726a);
                }
                e.this.b.a(this.b, this.f3726a);
            }
        }
    }

    class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f3727a;

        i(JSONObject jSONObject) {
            this.f3727a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.b;
            if (lVar != null) {
                lVar.b(this.f3727a);
            }
        }
    }

    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.b;
            if (lVar != null) {
                lVar.a();
                e.this.b = null;
            }
        }
    }

    class k extends CountDownTimer {
        k(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Logger.i(e.this.f3718a, "Global Controller Timer Finish");
            e.this.d(C3040d4.c.k);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Logger.i(e.this.f3718a, "Global Controller Timer Tick " + j);
        }
    }

    class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.d();
        }
    }

    class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3731a;
        final /* synthetic */ String b;

        m(String str, String str2) {
            this.f3731a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e eVar = e.this;
                eVar.b = eVar.b(eVar.h.b(), e.this.h.d(), e.this.h.f(), e.this.h.e(), e.this.h.g(), e.this.h.c(), this.f3731a, this.b);
                e.this.b.b();
            } catch (Throwable th) {
                C3260q4.d().a(th);
                e.this.d(Log.getStackTraceString(th));
            }
        }
    }

    class n extends CountDownTimer {
        n(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Logger.i(e.this.f3718a, "Recovered Controller | Global Controller Timer Finish");
            e.this.d(C3040d4.c.k);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Logger.i(e.this.f3718a, "Recovered Controller | Global Controller Timer Tick " + j);
        }
    }

    class o implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3733a;
        final /* synthetic */ String b;
        final /* synthetic */ V4 c;
        final /* synthetic */ InterfaceC3378x4 d;

        o(String str, String str2, V4 v4, InterfaceC3378x4 interfaceC3378x4) {
            this.f3733a = str;
            this.b = str2;
            this.c = v4;
            this.d = interfaceC3378x4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.b;
            if (lVar != null) {
                lVar.a(this.f3733a, this.b, this.c, this.d);
            }
        }
    }

    class p implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f3734a;
        final /* synthetic */ InterfaceC3378x4 b;

        p(JSONObject jSONObject, InterfaceC3378x4 interfaceC3378x4) {
            this.f3734a = jSONObject;
            this.b = interfaceC3378x4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.b;
            if (lVar != null) {
                lVar.a(this.f3734a, this.b);
            }
        }
    }

    class q implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3735a;
        final /* synthetic */ String b;
        final /* synthetic */ V4 c;
        final /* synthetic */ InterfaceC3361w4 d;

        q(String str, String str2, V4 v4, InterfaceC3361w4 interfaceC3361w4) {
            this.f3735a = str;
            this.b = str2;
            this.c = v4;
            this.d = interfaceC3361w4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.b;
            if (lVar != null) {
                lVar.a(this.f3735a, this.b, this.c, this.d);
            }
        }
    }

    class r implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3736a;
        final /* synthetic */ InterfaceC3361w4 b;

        r(String str, InterfaceC3361w4 interfaceC3361w4) {
            this.f3736a = str;
            this.b = interfaceC3361w4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.l lVar = e.this.b;
            if (lVar != null) {
                lVar.a(this.f3736a, this.b);
            }
        }
    }

    class s implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ V4 f3737a;
        final /* synthetic */ Map b;
        final /* synthetic */ InterfaceC3361w4 c;

        s(V4 v4, Map map, InterfaceC3361w4 interfaceC3361w4) {
            this.f3737a = v4;
            this.b = map;
            this.c = interfaceC3361w4;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3348v8.a(Md.j, new C3264q8().a(D5.v, this.f3737a.f()).a(D5.w, C3365w8.a(this.f3737a, C3230o8.e.Interstitial)).a(D5.x, Boolean.valueOf(C3365w8.a(this.f3737a))).a(D5.I, Long.valueOf(L.f2933a.b(this.f3737a.h()))).a());
            com.ironsource.sdk.controller.l lVar = e.this.b;
            if (lVar != null) {
                lVar.b(this.f3737a, this.b, this.c);
            }
        }
    }

    public e(Context context, C3091g4 c3091g4, W4 w4, R7 r7, int i2, JSONObject jSONObject, String str, String str2, Xb xb) {
        this.k = xb;
        this.g = r7;
        String networkStorageDir = IronSourceStorageUtils.getNetworkStorageDir(context);
        C3092g5 a2 = C3092g5.a(networkStorageDir, r7, jSONObject);
        this.h = new tg(context, c3091g4, w4, i2, a2, networkStorageDir);
        a(context, c3091g4, w4, i2, a2, networkStorageDir, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Context context, C3091g4 c3091g4, W4 w4, int i2, C3092g5 c3092g5, String str, String str2, String str3) {
        try {
            v b2 = b(context, c3091g4, w4, i2, c3092g5, str, str2, str3);
            try {
                this.b = b2;
                b2.b();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                C3260q4.d().a(th2);
                d(Log.getStackTraceString(th2));
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        C3348v8.a(Md.d, new C3264q8().a(D5.A, str).a());
        this.c = C3230o8.b.Loading;
        this.b = new com.ironsource.sdk.controller.n(str, this.g);
        this.e.c();
        this.e.a();
        R7 r7 = this.g;
        if (r7 != null) {
            r7.c(new l());
        }
    }

    private void e(String str) {
        IronSourceNetwork.updateInitFailed(new C3247p8(1001, str));
    }

    private l.a i() {
        return new l.a() { // from class: com.ironsource.sdk.controller.e$$ExternalSyntheticLambda0
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                e.this.a(aVar);
            }
        };
    }

    private l.b j() {
        return new l.b() { // from class: com.ironsource.sdk.controller.e$$ExternalSyntheticLambda2
            @Override // com.ironsource.sdk.controller.l.b
            public final void a(C3368wb c3368wb) {
                e.this.a(c3368wb);
            }
        };
    }

    private void l() {
        Logger.i(this.f3718a, "handleReadyState");
        this.c = C3230o8.b.Ready;
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        n();
        this.f.c();
        this.f.a();
        com.ironsource.sdk.controller.l lVar = this.b;
        if (lVar != null) {
            lVar.f();
        }
    }

    private boolean m() {
        return C3230o8.b.Ready.equals(this.c);
    }

    private void n() {
        this.h.a(true);
        com.ironsource.sdk.controller.l lVar = this.b;
        if (lVar != null) {
            lVar.a(this.h.i());
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void b() {
    }

    @Override // com.ironsource.sdk.controller.l
    @Deprecated
    public void f() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void g() {
        com.ironsource.sdk.controller.l lVar;
        if (!m() || (lVar = this.b) == null) {
            return;
        }
        lVar.g();
    }

    @Override // com.ironsource.sdk.controller.l
    public C3230o8.c h() {
        com.ironsource.sdk.controller.l lVar = this.b;
        return lVar != null ? lVar.h() : C3230o8.c.None;
    }

    public com.ironsource.sdk.controller.l k() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(f.a aVar) {
        l.a remove = this.i.remove(aVar.c());
        if (remove != null) {
            remove.a(aVar);
        }
    }

    private void b(Runnable runnable) {
        a(runnable, 0L);
    }

    @Override // com.ironsource.sdk.controller.l
    public void e() {
        com.ironsource.sdk.controller.l lVar;
        if (!m() || (lVar = this.b) == null) {
            return;
        }
        lVar.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public v b(Context context, C3091g4 c3091g4, W4 w4, int i2, C3092g5 c3092g5, String str, String str2, String str3) throws Throwable {
        C3348v8.a(Md.c);
        v vVar = new v(context, w4, c3091g4, this, this.g, i2, c3092g5, str, i(), j(), str2, str3);
        X5 x5 = new X5(context, c3092g5, new W5(this.g.a()), new C3385xb(c3092g5.a()));
        vVar.a(new u(context));
        vVar.a(new com.ironsource.sdk.controller.o(context));
        vVar.a(new com.ironsource.sdk.controller.q(context));
        vVar.a(new com.ironsource.sdk.controller.i(context));
        vVar.a(new com.ironsource.sdk.controller.a(context));
        vVar.a(new com.ironsource.sdk.controller.j(c3092g5.a(), x5));
        vVar.a(new C3273r1());
        vVar.a(new A4(context, new C3412z4()));
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(C3368wb c3368wb) {
        l.b bVar = this.j.get(c3368wb.d());
        if (bVar != null) {
            bVar.a(c3368wb);
        }
    }

    private void a(Runnable runnable, long j2) {
        R7 r7 = this.g;
        if (r7 != null) {
            r7.d(runnable, j2);
        } else {
            Logger.e(this.f3718a, "mThreadManager = null");
        }
    }

    private void a(final Context context, final C3091g4 c3091g4, final W4 w4, final int i2, final C3092g5 c3092g5, final String str, final String str2, final String str3) {
        int h2 = C3334ub.U().g().h();
        if (h2 > 0) {
            C3348v8.a(Md.B, new C3264q8().a(D5.y, String.valueOf(h2)).a());
        }
        a(new Runnable() { // from class: com.ironsource.sdk.controller.e$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                e.this.c(context, c3091g4, w4, i2, c3092g5, str, str2, str3);
            }
        }, h2);
        this.d = new k(200000L, 1000L).start();
    }

    @Override // com.ironsource.sdk.controller.c
    public void c() {
        Logger.i(this.f3718a, "handleControllerLoaded");
        this.c = C3230o8.b.Loaded;
        this.e.c();
        this.e.a();
    }

    @Override // com.ironsource.sdk.controller.c
    public void d() {
        Logger.i(this.f3718a, "handleControllerReady ");
        this.k.a(h());
        if (C3230o8.c.Web.equals(h())) {
            C3348v8.a(Md.e, new C3264q8().a(D5.y, String.valueOf(this.h.l())).a());
            IronSourceNetwork.updateInitSucceeded();
        }
        l();
    }

    @Override // com.ironsource.sdk.controller.c
    public void c(String str) {
        Logger.i(this.f3718a, "handleControllerFailed ");
        C3264q8 c3264q8 = new C3264q8();
        c3264q8.a(D5.A, str);
        c3264q8.a(D5.y, String.valueOf(this.h.l()));
        C3348v8.a(Md.o, c3264q8.a());
        this.h.a(false);
        e(str);
        if (this.d != null) {
            Logger.i(this.f3718a, "cancel timer mControllerReadyTimer");
            this.d.cancel();
        }
        d(str);
    }

    @Override // com.ironsource.sdk.controller.c
    public void b(String str) {
        C3348v8.a(Md.y, new C3264q8().a(D5.y, str).a());
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        d(str);
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(V4 v4, Map<String, String> map, InterfaceC3361w4 interfaceC3361w4) {
        this.f.a(new s(v4, map, interfaceC3361w4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(V4 v4) {
        this.f.a(new f(v4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(JSONObject jSONObject) {
        this.f.a(new i(jSONObject));
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(Context context) {
        com.ironsource.sdk.controller.l lVar;
        if (!m() || (lVar = this.b) == null) {
            return;
        }
        lVar.b(context);
    }

    public void a(Runnable runnable) {
        this.e.a(runnable);
    }

    @Override // com.ironsource.InterfaceC3023c7
    public void a(Y6 y6) {
        EnumC2989a7 b2 = y6.b();
        if (b2 == EnumC2989a7.SendEvent) {
            C3348v8.a(Md.A, new C3264q8().a(D5.y, y6.a() + " : strategy: " + b2).a());
            return;
        }
        if (b2 == EnumC2989a7.NativeController) {
            com.ironsource.sdk.controller.n nVar = new com.ironsource.sdk.controller.n(y6.a(), this.g);
            this.b = nVar;
            this.k.a(nVar.h());
            C3348v8.a(Md.d, new C3264q8().a(D5.A, y6.a() + " : strategy: " + b2).a());
            C3348v8.a(Md.A, new C3264q8().a(D5.y, y6.a() + " : strategy: " + b2).a());
        }
    }

    private void a(C3230o8.e eVar, V4 v4, String str, String str2) {
        Logger.i(this.f3718a, "recoverWebController for product: " + eVar.toString());
        C3264q8 c3264q8 = new C3264q8();
        c3264q8.a(D5.w, eVar.toString());
        c3264q8.a(D5.v, v4.f());
        C3348v8.a(Md.b, c3264q8.a());
        this.h.n();
        a();
        b(new m(str, str2));
        this.d = new n(200000L, 1000L).start();
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, V4 v4, InterfaceC3378x4 interfaceC3378x4) {
        if (this.h.a(h(), this.c)) {
            a(C3230o8.e.RewardedVideo, v4, str, str2);
        }
        this.f.a(new o(str, str2, v4, interfaceC3378x4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC3378x4 interfaceC3378x4) {
        this.f.a(new p(jSONObject, interfaceC3378x4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, V4 v4, InterfaceC3361w4 interfaceC3361w4) {
        if (this.h.a(h(), this.c)) {
            a(C3230o8.e.Interstitial, v4, str, str2);
        }
        this.f.a(new q(str, str2, v4, interfaceC3361w4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, InterfaceC3361w4 interfaceC3361w4) {
        Logger.i(this.f3718a, "load interstitial");
        this.f.a(new r(str, interfaceC3361w4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC3361w4 interfaceC3361w4) {
        this.f.a(new a(jSONObject, interfaceC3361w4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(V4 v4, Map<String, String> map, InterfaceC3361w4 interfaceC3361w4) {
        this.f.a(new b(v4, map, interfaceC3361w4));
    }

    @Override // com.ironsource.sdk.controller.l
    public boolean a(String str) {
        if (this.b == null || !m()) {
            return false;
        }
        return this.b.a(str);
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, V4 v4, InterfaceC3344v4 interfaceC3344v4) {
        if (this.h.a(h(), this.c)) {
            a(C3230o8.e.Banner, v4, str, str2);
        }
        this.f.a(new c(str, str2, v4, interfaceC3344v4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC3344v4 interfaceC3344v4) {
        this.f.a(new d(jSONObject, interfaceC3344v4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(V4 v4) {
        this.f.a(new RunnableC0300e(v4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(V4 v4, Map<String, String> map, InterfaceC3344v4 interfaceC3344v4) {
        this.f.a(new g(v4, map, interfaceC3344v4));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(f.c cVar, l.a aVar) {
        this.f.a(new h(aVar, cVar));
    }

    public void a(String str, l.b bVar) {
        this.j.put(str, bVar);
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Context context) {
        com.ironsource.sdk.controller.l lVar;
        if (!m() || (lVar = this.b) == null) {
            return;
        }
        lVar.a(context);
    }

    @Override // com.ironsource.sdk.controller.l
    public void a() {
        Logger.i(this.f3718a, "destroy controller");
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        S3 s3 = this.f;
        if (s3 != null) {
            s3.b();
        }
        this.d = null;
        b(new j());
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Activity activity) {
        this.b.a(activity);
    }
}
