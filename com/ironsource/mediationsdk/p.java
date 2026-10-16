package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.A5;
import com.ironsource.AbstractC3326u3;
import com.ironsource.C2991a9;
import com.ironsource.C2997af;
import com.ironsource.C3003b4;
import com.ironsource.C3024c8;
import com.ironsource.C3025c9;
import com.ironsource.C3098gb;
import com.ironsource.C3104h0;
import com.ironsource.C3119hf;
import com.ironsource.C3124i3;
import com.ironsource.C3137j0;
import com.ironsource.C3151je;
import com.ironsource.C3176l5;
import com.ironsource.C3184ld;
import com.ironsource.C3193m5;
import com.ironsource.C3203mf;
import com.ironsource.C3260q4;
import com.ironsource.C3281r9;
import com.ironsource.C3334ub;
import com.ironsource.C3337ue;
import com.ironsource.C3351vb;
import com.ironsource.C3366w9;
import com.ironsource.C3400y9;
import com.ironsource.C3413z5;
import com.ironsource.C3419zb;
import com.ironsource.Cif;
import com.ironsource.Dd;
import com.ironsource.EnumC3135ie;
import com.ironsource.F3;
import com.ironsource.Gd;
import com.ironsource.H1;
import com.ironsource.H2;
import com.ironsource.H8;
import com.ironsource.Ib;
import com.ironsource.Id;
import com.ironsource.InterfaceC3144j7;
import com.ironsource.InterfaceC3200mc;
import com.ironsource.InterfaceC3335uc;
import com.ironsource.InterfaceC3381x7;
import com.ironsource.J9;
import com.ironsource.Jf;
import com.ironsource.K1;
import com.ironsource.Kb;
import com.ironsource.Kf;
import com.ironsource.L6;
import com.ironsource.L7;
import com.ironsource.N7;
import com.ironsource.O9;
import com.ironsource.P5;
import com.ironsource.P7;
import com.ironsource.Qc;
import com.ironsource.Rc;
import com.ironsource.S4;
import com.ironsource.S6;
import com.ironsource.T3;
import com.ironsource.T4;
import com.ironsource.U3;
import com.ironsource.V2;
import com.ironsource.W7;
import com.ironsource.Wc;
import com.ironsource.X4;
import com.ironsource.Z9;
import com.ironsource.Zd;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adquality.AdQualityBridge;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.demandOnly.h;
import com.ironsource.mediationsdk.events.ISErrorListener;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.s;
import com.ironsource.mediationsdk.sdk.InitializationListener;
import com.ironsource.mediationsdk.sdk.IronSourceInterface;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.server.ServerURL;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.sdk.controller.FeaturesManager;
import com.unity3d.mediation.LevelPlay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class p implements IronSourceInterface, InterfaceC3335uc, S4, S4.b, S4.c, S4.a {
    private static boolean r0 = false;
    private Set<IronSource.AD_UNIT> A;
    private boolean B;
    private IronSourceSegment C;
    private final String D;
    private int E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private Boolean L;
    private IronSourceBannerLayout M;
    private String N;
    private Boolean O;
    private N7 P;
    private w Q;
    private C3281r9 R;
    private Dd S;
    private H2 T;
    private InitializationListener U;
    private InterfaceC3200mc V;
    private AtomicBoolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a, reason: collision with root package name */
    private final String f3556a;
    private boolean a0;
    private final String b;
    private boolean b0;
    private final InterfaceC3381x7 c;
    private int c0;
    private final InterfaceC3381x7.a d;
    private final ConcurrentHashMap<String, h.d> d0;
    private final L7 e;
    private final ConcurrentHashMap<String, h.b> e0;
    private final InterfaceC3144j7 f;
    private final ConcurrentHashMap<String, h.d> f0;
    private final H8.a g;
    private com.ironsource.mediationsdk.demandOnly.f g0;
    private IronSourceLoggerManager h;
    private com.ironsource.mediationsdk.demandOnly.k h0;
    private C3098gb i;
    private com.ironsource.mediationsdk.demandOnly.c i0;
    private com.ironsource.mediationsdk.logger.b j;
    private P5 j0;
    private AtomicBoolean k;
    private J9 k0;
    private final Object l;
    private S6 l0;
    private C3337ue m;
    private boolean m0;
    private String n;
    private AdQualityBridge n0;
    private String o;
    ISErrorListener o0;
    private String p;
    W7<ISDemandOnlyInterstitialListener> p0;
    private String q;
    W7<ISDemandOnlyRewardedVideoListener> q0;
    private Map<String, String> r;
    private String s;
    private AtomicBoolean t;
    private boolean u;
    private List<IronSource.AD_UNIT> v;
    private String w;
    private Context x;
    private Boolean y;
    private Set<IronSource.AD_UNIT> z;

    class a implements ISErrorListener {
        a() {
        }

        @Override // com.ironsource.mediationsdk.events.ISErrorListener
        public void onError(Throwable th) {
            IronLog.INTERNAL.error(th.getMessage());
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3558a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[Wc.b.values().length];
            c = iArr;
            try {
                iArr[Wc.b.CAPPED_PER_DELIVERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[Wc.b.CAPPED_PER_COUNT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[Wc.b.CAPPED_PER_PACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[Wc.b.NOT_CAPPED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[s.d.values().length];
            b = iArr2;
            try {
                iArr2[s.d.NOT_INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[s.d.INIT_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[s.d.INIT_IN_PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[s.d.INITIATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[IronSource.AD_UNIT.values().length];
            f3558a = iArr3;
            try {
                iArr3[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3558a[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3558a[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3558a[IronSource.AD_UNIT.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public interface c {
        void a(String str);
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        static volatile p f3559a = new p();

        private d() {
        }
    }

    private p() {
        this(C3334ub.U().i(), C3334ub.O().b(), C3334ub.U().w(), C3334ub.U().k(), C3334ub.O().C());
    }

    private synchronized boolean A() {
        return this.u;
    }

    private boolean B() {
        C3337ue c3337ue = this.m;
        return (c3337ue == null || c3337ue.c() == null || this.m.c().d() == null) ? false : true;
    }

    private boolean C() {
        return B() && E();
    }

    private boolean E() {
        C3337ue c3337ue = this.m;
        return (c3337ue == null || c3337ue.j() == null || this.m.j().b() == null || this.m.j().b().size() <= 0) ? false : true;
    }

    private boolean F() {
        C3337ue c3337ue = this.m;
        return (c3337ue == null || c3337ue.c() == null || this.m.c().e() == null) ? false : true;
    }

    private boolean G() {
        return F() && H();
    }

    private boolean H() {
        C3337ue c3337ue = this.m;
        return (c3337ue == null || c3337ue.j() == null || this.m.j().c() == null || this.m.j().c().isEmpty()) ? false : true;
    }

    private boolean J() {
        C3337ue c3337ue = this.m;
        return (c3337ue == null || c3337ue.c() == null || this.m.c().f() == null) ? false : true;
    }

    private boolean K() {
        return J() && L();
    }

    private boolean L() {
        C3337ue c3337ue = this.m;
        return (c3337ue == null || c3337ue.j() == null || this.m.j().d() == null || this.m.j().d().size() <= 0) ? false : true;
    }

    private void R() {
        if (this.U == null || !this.W.compareAndSet(false, true)) {
            return;
        }
        IronLog.CALLBACK.verbose("onInitializationCompleted()");
        C3334ub.U().q().a(new C3413z5(A5.TROUBLESHOOTING_INIT_COMPLETED, IronSourceUtils.getMediationAdditionalData(false)));
        this.U.onInitializationComplete();
    }

    private void T() {
        ConcurrentHashMap<String, List<String>> c2 = Z9.b().c();
        if (c2.containsKey(com.ironsource.mediationsdk.metadata.a.c)) {
            if (TextUtils.isEmpty(c2.get(com.ironsource.mediationsdk.metadata.a.c).get(0))) {
                return;
            }
            X4.f3123a.b(!MetaDataUtils.getMetaDataBooleanValue(r0));
        }
    }

    private void U() {
        if (this.H) {
            W();
            return;
        }
        boolean h = this.m.c().c().d().h();
        this.b0 = h;
        if (h) {
            V();
        } else {
            c0();
        }
    }

    private void V() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> a2 = a(this.m.j().a());
        if (a2.size() > 0) {
            this.T = new H2(a2, this.m.c().c(), IronSourceUtils.getUserIdForNetworks(), Z9.b(), this.C);
            s();
        } else {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
            a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            a(A5.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.BANNER, false);
        }
    }

    private void W() {
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.m.j().a().size(); i++) {
            String str = this.m.j().a().get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.m.k().b(str));
            }
        }
        if (arrayList.isEmpty()) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, 1);
            a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            a(A5.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.BANNER, false);
            return;
        }
        synchronized (this.e0) {
            V2 c2 = this.m.c().c();
            T4.a aVar = new T4.a("Mediation");
            if (c2.k()) {
                aVar.a("isOneFlow", 1);
            }
            this.i0 = new com.ironsource.mediationsdk.demandOnly.c(arrayList, c2, k(), l(), new T4.b(C3400y9.i(), aVar));
        }
        for (h.b bVar : this.e0.values()) {
            this.i0.a(bVar.g(), bVar.e());
        }
        this.e0.clear();
    }

    private void X() {
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Interstitial started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.m.j().b().size(); i++) {
            String str = this.m.j().b().get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.m.k().b(str));
            }
        }
        if (arrayList.isEmpty()) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, 1);
            a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            a(A5.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.INTERSTITIAL, false);
            return;
        }
        synchronized (this.d0) {
            this.g0 = a((List<NetworkSettings>) arrayList);
        }
        Iterator<h.d> it = this.d0.values().iterator();
        while (it.hasNext()) {
            this.g0.a(it.next());
        }
        this.d0.clear();
    }

    private void Y() {
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.m.j().d().size(); i++) {
            String str = this.m.j().d().get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.m.k().b(str));
            }
        }
        if (arrayList.isEmpty()) {
            a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
            return;
        }
        synchronized (this.f0) {
            this.h0 = b(arrayList);
        }
        if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
            a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
            return;
        }
        Iterator<h.d> it = this.f0.values().iterator();
        while (it.hasNext()) {
            this.h0.a(it.next());
        }
        this.f0.clear();
    }

    private void Z() {
        if (this.G) {
            X();
        } else {
            a0();
        }
    }

    private void a0() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> a2 = a(this.m.j().b());
        if (a2.size() <= 0) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
            a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            a(A5.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.INTERSTITIAL, false);
            return;
        }
        C3281r9 c3281r9 = new C3281r9(a2, this.m.c().d(), IronSourceUtils.getUserIdForNetworks(), Z9.b(), this.C);
        this.R = c3281r9;
        Boolean bool = this.y;
        if (bool != null) {
            c3281r9.a(this.x, bool.booleanValue());
        }
        if (this.a0) {
            this.a0 = false;
            this.R.A();
        }
    }

    private synchronized void b(boolean z) {
        this.u = z;
    }

    private void b0() {
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in programmatic mode", 0);
        List<NetworkSettings> a2 = a(this.m.j().d());
        if (a2.size() <= 0) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, this.c0);
            a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            b(A5.TROUBLESHOOTING_RV_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
            return;
        }
        q qVar = new q(a2, this.m.c().f(), k(), IronSourceUtils.getUserIdForNetworks(), Z9.b().a(), this.C);
        this.P = qVar;
        Boolean bool = this.y;
        if (bool != null) {
            qVar.shouldTrackNetworkState(this.x, bool.booleanValue());
        }
    }

    private void c(boolean z) {
        if (z) {
            this.k0.a(Zd.EXTERNAL_MEDIATION_INIT);
        } else {
            this.k0.a(Zd.LEVEL_PLAY_INIT);
        }
    }

    private void c0() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> a2 = a(this.m.j().a());
        if (a2.size() > 0) {
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in programmatic mode", 0);
            this.Q = new w(a2, new k(k(), IronSourceUtils.getUserIdForNetworks(), this.m.c().c()), Z9.b().a(), this.C);
            s();
        } else {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
            a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            a(A5.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.BANNER, false);
        }
    }

    private void d0() {
        if (this.F) {
            Y();
            return;
        }
        Gd f = this.m.c().f();
        this.Z = f.k().h();
        this.c0 = a(f);
        if (this.X || this.Z) {
            e0();
        } else {
            b0();
        }
    }

    private void e0() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> a2 = a(this.m.j().d());
        if (a2.size() <= 0) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, this.c0);
            a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            b(A5.TROUBLESHOOTING_RV_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
            return;
        }
        Dd dd = new Dd(a2, this.m.c().f(), IronSourceUtils.getUserIdForNetworks(), this.X, Z9.b(), this.C);
        this.S = dd;
        Boolean bool = this.y;
        if (bool != null) {
            dd.a(this.x, bool.booleanValue());
        }
        if (this.Y && this.X) {
            this.Y = false;
            this.S.A();
        }
    }

    private Placement g() {
        Gd f = this.m.c().f();
        if (f != null) {
            return f.a();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Wc.b h(String str) {
        InterstitialPlacement interstitialPlacement;
        C3337ue c3337ue = this.m;
        if (c3337ue == null || c3337ue.c() == null || this.m.c().d() == null) {
            return Wc.b.NOT_CAPPED;
        }
        try {
            interstitialPlacement = i(str);
            if (interstitialPlacement == null) {
                try {
                    interstitialPlacement = f();
                    if (interstitialPlacement == null) {
                        this.h.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found", 3);
                    }
                } catch (Exception e) {
                    e = e;
                    C3260q4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                    if (interstitialPlacement != null) {
                    }
                }
            }
        } catch (Exception e2) {
            e = e2;
            interstitialPlacement = null;
        }
        return interstitialPlacement != null ? Wc.b.NOT_CAPPED : a(interstitialPlacement);
    }

    public static p j() {
        return d.f3559a;
    }

    private Placement l(String str) {
        Gd f = this.m.c().f();
        if (f != null) {
            return f.a(str);
        }
        return null;
    }

    private synchronized InterfaceC3200mc o() {
        return this.V;
    }

    private boolean q(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]*$");
    }

    private T3 r(String str) {
        T3 t3 = new T3();
        if (str == null) {
            t3.a(new IronSourceError(506, "Init Fail - appKey is missing"));
            return t3;
        }
        if (!a(str, 5, 10)) {
            t3.a(ErrorBuilder.buildInvalidCredentialsError("appKey", str, "length should be between 5-10 characters"));
            return t3;
        }
        if (!q(str)) {
            t3.a(ErrorBuilder.buildInvalidCredentialsError("appKey", str, "should contain only english characters and numbers"));
        }
        return t3;
    }

    private void s() {
        if (this.L.booleanValue()) {
            IronLog.INTERNAL.verbose("load banner after init");
            this.L = Boolean.FALSE;
            a(this.M, this.N);
            this.M = null;
            this.N = null;
        }
    }

    private void t() {
        this.h = IronSourceLoggerManager.getLogger(0);
        com.ironsource.mediationsdk.logger.b bVar = new com.ironsource.mediationsdk.logger.b(null, 1);
        this.j = bVar;
        this.h.addLogger(bVar);
        this.i = new C3098gb();
    }

    private boolean u() {
        try {
            IronLog.INTERNAL.verbose("AdQuality SDK exist: " + Class.forName("com.ironsource.adqualitysdk.sdk.IronSourceAdQuality").getName());
            return true;
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.INTERNAL.verbose("No AdQuality SDK found");
            return false;
        }
    }

    private boolean v() {
        C3337ue c3337ue = this.m;
        return (c3337ue == null || c3337ue.c() == null || this.m.c().b() == null || this.m.c().b().b() == null) ? false : true;
    }

    private boolean w() {
        C3337ue c3337ue = this.m;
        return (c3337ue == null || c3337ue.c() == null || this.m.c().c() == null) ? false : true;
    }

    private boolean x() {
        return w() && y();
    }

    private boolean y() {
        C3337ue c3337ue = this.m;
        return (c3337ue == null || c3337ue.j() == null || this.m.j().a() == null || this.m.j().a().size() <= 0) ? false : true;
    }

    public boolean D() {
        boolean z;
        try {
            if (this.G) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use isISDemandOnlyInterstitialReady instead", 3);
                return false;
            }
            C3281r9 c3281r9 = this.R;
            boolean z2 = c3281r9 != null && c3281r9.u();
            try {
                C3400y9.i().a(new C3413z5(z2 ? A5.IS_CHECK_READY_TRUE : A5.IS_CHECK_READY_FALSE, IronSourceUtils.getMediationAdditionalData(false, true, 1)));
                this.h.log(IronSourceLogger.IronSourceTag.API, "isInterstitialReady():" + z2, 1);
                return z2;
            } catch (Throwable th) {
                z = z2;
                th = th;
                C3260q4.d().a(th);
                IronSourceLoggerManager ironSourceLoggerManager = this.h;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                ironSourceLoggerManager.log(ironSourceTag, "isInterstitialReady():" + z, 1);
                this.h.logException(ironSourceTag, "isInterstitialReady()", th);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x002f, code lost:
    
        if (r3.u() != false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:20:0x0034, B:22:0x004f, B:23:0x0054, B:26:0x0052), top: B:19:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:20:0x0034, B:22:0x004f, B:23:0x0054, B:26:0x0052), top: B:19:0x0034 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean I() {
        boolean z;
        boolean z2;
        try {
            if (this.F) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in demand only mode. Use isISDemandOnlyRewardedVideoAvailable instead", 3);
                return false;
            }
            try {
                if (!this.X && !this.Z) {
                    N7 n7 = this.P;
                    if (n7 != null && n7.d()) {
                        z2 = true;
                        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
                        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(this.c0)}});
                        Id.i().a(new C3413z5(z2 ? A5.RV_API_HAS_AVAILABILITY_TRUE : A5.RV_API_HAS_AVAILABILITY_FALSE, mediationAdditionalData));
                        this.h.log(IronSourceLogger.IronSourceTag.API, "isRewardedVideoAvailable():" + z2, 1);
                        return z2;
                    }
                    z2 = false;
                    JSONObject mediationAdditionalData2 = IronSourceUtils.getMediationAdditionalData(false);
                    a(mediationAdditionalData2, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(this.c0)}});
                    Id.i().a(new C3413z5(z2 ? A5.RV_API_HAS_AVAILABILITY_TRUE : A5.RV_API_HAS_AVAILABILITY_FALSE, mediationAdditionalData2));
                    this.h.log(IronSourceLogger.IronSourceTag.API, "isRewardedVideoAvailable():" + z2, 1);
                    return z2;
                }
                JSONObject mediationAdditionalData22 = IronSourceUtils.getMediationAdditionalData(false);
                a(mediationAdditionalData22, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(this.c0)}});
                Id.i().a(new C3413z5(z2 ? A5.RV_API_HAS_AVAILABILITY_TRUE : A5.RV_API_HAS_AVAILABILITY_FALSE, mediationAdditionalData22));
                this.h.log(IronSourceLogger.IronSourceTag.API, "isRewardedVideoAvailable():" + z2, 1);
                return z2;
            } catch (Throwable th) {
                z = z2;
                th = th;
                C3260q4.d().a(th);
                IronSourceLoggerManager ironSourceLoggerManager = this.h;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                ironSourceLoggerManager.log(ironSourceTag, "isRewardedVideoAvailable():" + z, 1);
                this.h.logException(ironSourceTag, "isRewardedVideoAvailable()", th);
                return false;
            }
            Dd dd = this.S;
            if (dd != null) {
            }
            z2 = false;
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    public boolean M() {
        return A();
    }

    public void P() {
        C3281r9 c3281r9 = this.R;
        if (c3281r9 != null) {
            c3281r9.a((C3203mf) null);
        }
        Dd dd = this.S;
        if (dd != null) {
            dd.a((C3203mf) null);
        }
        H2 h2 = this.T;
        if (h2 != null) {
            h2.a((C3203mf) null);
        }
        this.m0 = false;
    }

    public void Q() {
        IronLog.API.info("removing all impression data listeners");
        Z9.b().d();
        N7 n7 = this.P;
        if (n7 != null) {
            n7.c();
        }
        w wVar = this.Q;
        if (wVar != null) {
            wVar.c();
        }
    }

    public void S() {
        if (r0) {
            return;
        }
        r0 = true;
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            mediationAdditionalData.put("status", "false");
            mediationAdditionalData.put(IronSourceConstants.EVENTS_ERROR_CODE, 1);
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        C3334ub.U().q().a(new C3413z5(A5.FIRST_INSTANCE_RESULT, mediationAdditionalData));
    }

    public void a(long j, C3337ue.a aVar) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(z());
        try {
            mediationAdditionalData.put("duration", j);
            mediationAdditionalData.put("sessionDepth", this.E);
            mediationAdditionalData.put(IronSourceConstants.EVENTS_EXT1, aVar.b());
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        C3334ub.U().q().a(new C3413z5(A5.INIT_COMPLETE, mediationAdditionalData));
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public void clearRewardedVideoServerParameters() {
        this.r = null;
    }

    public void d(Activity activity) {
        if (!J()) {
            C3184ld.a().a(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", 3);
            return;
        }
        Placement g = g();
        if (g != null) {
            f(activity, g.getPlacementName());
            return;
        }
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo error: empty default placement in response", 3);
        C3184ld.a().a(new IronSourceError(1021, "showRewardedVideo error: empty default placement in response"), (AdInfo) null);
    }

    @Override // com.ironsource.InterfaceC3335uc
    public void e(String str) {
        try {
            this.h.log(IronSourceLogger.IronSourceTag.API, "onInitFailed(reason:" + str + ")", 1);
            IronSourceUtils.sendAutomationLog("Mediation init failed");
            if (this.i != null) {
                Iterator<IronSource.AD_UNIT> it = this.z.iterator();
                while (it.hasNext()) {
                    a(it.next(), true);
                }
            }
            InterfaceC3200mc o = o();
            if (o != null) {
                o.onInitFailed(new IronSourceError(IronSourceError.ERROR_LEGACY_INIT_FAILED, "Legacy init failed"));
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public void f(Activity activity, String str) {
        String str2 = "showRewardedVideo(" + str + ")";
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, str2, 1);
        try {
            if (this.F) {
                this.h.log(ironSourceTag, "Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", 3);
                C3184ld.a().a(ErrorBuilder.buildInitFailedError("Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            } else if (J()) {
                e(activity, str);
            } else {
                C3184ld.a().a(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, str2, e);
            C3184ld.a().a(new IronSourceError(510, e.getMessage()), (AdInfo) null);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public String getAdvertiserId(Context context) {
        String I = this.c.I(context);
        C3334ub.U().q().a(new C3413z5(A5.GET_ADVERTISING_ID, IronSourceUtils.getMediationAdditionalData(false)));
        return !TextUtils.isEmpty(I) ? I : "";
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public InterstitialPlacement getInterstitialPlacementInfo(String str) {
        InterstitialPlacement interstitialPlacement;
        try {
            interstitialPlacement = i(str);
            if (interstitialPlacement == null) {
                try {
                    this.h.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    interstitialPlacement = f();
                } catch (Exception e) {
                    e = e;
                    C3260q4.d().a(e);
                    return interstitialPlacement;
                }
            }
            this.h.log(IronSourceLogger.IronSourceTag.API, "getPlacementInfo(placement: " + str + "):" + interstitialPlacement, 1);
            return interstitialPlacement;
        } catch (Exception e2) {
            e = e2;
            interstitialPlacement = null;
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public Placement getRewardedVideoPlacementInfo(String str) {
        Placement placement;
        try {
            placement = l(str);
            if (placement == null) {
                try {
                    this.h.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    placement = g();
                } catch (Exception e) {
                    e = e;
                    C3260q4.d().a(e);
                    return placement;
                }
            }
            this.h.log(IronSourceLogger.IronSourceTag.API, "getPlacementInfo(placement: " + str + "):" + placement, 1);
            return placement;
        } catch (Exception e2) {
            e = e2;
            placement = null;
        }
    }

    public String i() {
        return this.q;
    }

    public String k() {
        return this.n;
    }

    boolean m(String str) {
        if (!w()) {
            return false;
        }
        C3124i3 c3124i3 = null;
        try {
            c3124i3 = this.m.c().c().a(str);
            if (c3124i3 == null && (c3124i3 = this.m.c().c().i()) == null) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "Banner default placement was not found", 3);
                return false;
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        if (c3124i3 == null) {
            return false;
        }
        return a(c3124i3);
    }

    public String n() {
        return this.s;
    }

    public Map<String, String> p() {
        return this.r;
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public void removeInterstitialListener() {
        this.h.log(IronSourceLogger.IronSourceTag.API, "removeInterstitialListener()", 1);
        C3024c8.a().a((LevelPlayInterstitialListener) null);
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public void removeRewardedVideoListener() {
        this.h.log(IronSourceLogger.IronSourceTag.API, "removeRewardedVideoListener()", 1);
        C3184ld.a().a((LevelPlayRewardedVideoBaseListener) null);
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public void setAdaptersDebug(boolean z) {
        com.ironsource.mediationsdk.c.b().a(z);
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public boolean setDynamicUserId(String str) {
        try {
            T3 t3 = new T3();
            a(str, t3);
            if (!t3.b()) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, t3.a().toString(), 2);
                return false;
            }
            this.q = str;
            C3334ub.U().q().a(new C3413z5(A5.SET_USER_ID, IronSourceUtils.getJsonForUserId(true)));
            return true;
        } catch (Exception e) {
            C3260q4.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, this.f3556a + ":setDynamicUserId(dynamicUserId:" + str + ")", e);
            return false;
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public void setMediationType(String str) {
        try {
            String str2 = this.f3556a + ":setMediationType(mediationType:" + str + ")";
            IronSourceLoggerManager ironSourceLoggerManager = this.h;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, str2, 1);
            if (!a(str, 1, 64) || !q(str)) {
                this.h.log(ironSourceTag, " mediationType value is invalid - should be alphanumeric and 1-64 chars in length", 1);
            } else {
                this.s = str;
                this.k0.f(str);
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, this.f3556a + ":setMediationType(mediationType:" + str + ")", e);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public void setRewardedVideoServerParameters(Map<String, String> map) {
        if (map != null) {
            try {
                if (map.size() == 0) {
                    return;
                }
                this.h.log(IronSourceLogger.IronSourceTag.API, this.f3556a + ":setRewardedVideoServerParameters(params:" + map.toString() + ")", 1);
                this.r = new HashMap(map);
                C3413z5 c3413z5 = new C3413z5(A5.SET_RV_SERVER_PARAMS, IronSourceUtils.getMediationAdditionalData(false));
                c3413z5.a(IronSourceConstants.EVENTS_EXT1, map.toString());
                Id.i().a(c3413z5);
            } catch (Exception e) {
                C3260q4.d().a(e);
                this.h.logException(IronSourceLogger.IronSourceTag.API, this.f3556a + ":setRewardedVideoServerParameters(params:" + map.toString() + ")", e);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public void shouldTrackNetworkState(Context context, boolean z) {
        this.x = context;
        this.y = Boolean.valueOf(z);
        C3281r9 c3281r9 = this.R;
        if (c3281r9 != null) {
            c3281r9.a(context, z);
        }
        if (this.Z) {
            Dd dd = this.S;
            if (dd != null) {
                dd.a(context, z);
            }
        } else {
            N7 n7 = this.P;
            if (n7 != null) {
                n7.shouldTrackNetworkState(context, z);
            }
        }
        C3334ub.U().q().a(new C3413z5(A5.SHOULD_TRACK_NETWORK_STATE, IronSourceUtils.getMediationAdditionalData(false)));
    }

    boolean z() {
        return this.F || this.G || this.H;
    }

    private boolean b(List<IronSource.AD_UNIT> list, boolean z, U3 u3) {
        IronLog.INTERNAL.verbose();
        try {
            this.j.a(u3.b().h().d());
            this.v = list;
            b(true);
            this.h.log(IronSourceLogger.IronSourceTag.API, "onInitSuccess()", 1);
            IronSourceUtils.sendAutomationLog("init success");
            if (z) {
                JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
                try {
                    mediationAdditionalData.put("revived", true);
                } catch (JSONException e) {
                    C3260q4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
                C3334ub.U().q().a(new C3413z5(A5.FIRST_INSTANCE_RESULT, mediationAdditionalData));
            }
            int b2 = u3.b().f().b();
            if (b2 >= 0) {
                C3003b4 c3003b4 = new C3003b4();
                c3003b4.a(b2);
                c3003b4.a(b2, this.m.k().d());
            }
            C3400y9.i().h();
            Id.i().h();
            C3334ub.U().q().h();
            com.ironsource.mediationsdk.c.b().b(k(), l());
            for (IronSource.AD_UNIT ad_unit : IronSource.AD_UNIT.values()) {
                if (this.z.contains(ad_unit)) {
                    if (list.contains(ad_unit)) {
                        b(ad_unit);
                    } else {
                        a(ad_unit, false);
                    }
                }
            }
            R();
            InterfaceC3200mc o = o();
            if (o != null) {
                o.a(this.m);
            }
            return true;
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            InterfaceC3200mc o2 = o();
            if (o2 != null) {
                o2.onInitFailed(new IronSourceError(IronSourceError.ERROR_LEGACY_INIT_POST_FAILED, "onInitSuccess() had failed"));
            }
            return false;
        }
    }

    private InterstitialPlacement i(String str) {
        C3366w9 d2 = this.m.c().d();
        if (d2 != null) {
            return d2.a(str);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Wc.b k(String str) {
        Placement placement;
        C3337ue c3337ue = this.m;
        if (c3337ue == null || c3337ue.c() == null || this.m.c().f() == null) {
            return Wc.b.NOT_CAPPED;
        }
        try {
            placement = l(str);
            if (placement == null) {
                try {
                    placement = g();
                    if (placement == null) {
                        this.h.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found", 3);
                    }
                } catch (Exception e) {
                    e = e;
                    C3260q4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                    if (placement != null) {
                    }
                }
            }
        } catch (Exception e2) {
            e = e2;
            placement = null;
        }
        return placement != null ? Wc.b.NOT_CAPPED : a(placement);
    }

    public void N() {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "loadInterstitial()", 1);
        try {
            if (this.G) {
                this.h.log(ironSourceTag, "Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", 3);
                n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", "Interstitial"));
                return;
            }
            if (!this.J) {
                this.h.log(ironSourceTag, "init() must be called before loadInterstitial()", 3);
                n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() must be called before loadInterstitial()", "Interstitial"));
                return;
            }
            s.d a2 = s.c().a();
            if (a2 == s.d.INIT_FAILED) {
                this.h.log(ironSourceTag, "init() had failed", 3);
                n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                return;
            }
            if (a2 == s.d.INIT_IN_PROGRESS) {
                if (!s.c().d()) {
                    this.a0 = true;
                    return;
                } else {
                    this.h.log(ironSourceTag, "init() had failed", 3);
                    n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                    return;
                }
            }
            if (!C()) {
                this.h.log(ironSourceTag, "No interstitial configurations found", 3);
                n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("the server response does not contain interstitial data", "Interstitial"));
                return;
            }
            C3281r9 c3281r9 = this.R;
            if (c3281r9 == null) {
                this.a0 = true;
            } else {
                c3281r9.A();
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "loadInterstitial()", th);
            n.a().b(IronSource.AD_UNIT.INTERSTITIAL, new IronSourceError(510, th.getMessage()));
        }
    }

    public void O() {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "loadRewardedVideo()", 1);
        try {
            if (this.F) {
                this.h.log(ironSourceTag, "Rewarded Video was initialized in demand only mode. Use loadISDemandOnlyRewardedVideo instead", 3);
                n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("Rewarded Video was initialized in demand only mode. Use loadISDemandOnlyRewardedVideo instead", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            if (!this.X && !this.m0) {
                this.h.log(ironSourceTag, "Rewarded Video is not initiated with manual load", 3);
                return;
            }
            if (!this.I) {
                this.h.log(ironSourceTag, "init() must be called before loadRewardedVideo()", 3);
                n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() must be called before loadRewardedVideo()", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            s.d a2 = s.c().a();
            if (a2 == s.d.INIT_FAILED) {
                this.h.log(ironSourceTag, "init() had failed", 3);
                n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            if (a2 == s.d.INIT_IN_PROGRESS) {
                if (!s.c().d()) {
                    this.Y = true;
                    return;
                } else {
                    this.h.log(ironSourceTag, "init() had failed", 3);
                    n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                    return;
                }
            }
            if (!K()) {
                this.h.log(ironSourceTag, "No rewarded video configurations found", 3);
                n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("the server response does not contain rewarded video data", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            Dd dd = this.S;
            if (dd == null) {
                this.Y = true;
            } else {
                dd.A();
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "loadRewardedVideo()", th);
            n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, new IronSourceError(510, th.getMessage()));
        }
    }

    public Kb j(String str) {
        C3419zb e = this.m.c().e();
        if (e == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return e.e();
        }
        Kb a2 = e.a(str);
        return a2 != null ? a2 : e.e();
    }

    boolean n(String str) {
        if (this.G) {
            return false;
        }
        boolean z = h(str) != Wc.b.NOT_CAPPED;
        if (z) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(this.G, true, 1);
            try {
                mediationAdditionalData.put("placement", str);
                mediationAdditionalData.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
            } catch (Exception e) {
                C3260q4.d().a(e);
            }
            C3400y9.i().a(new C3413z5(A5.IS_CHECK_CAPPED_TRUE, mediationAdditionalData));
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r0 != 3) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean o(String str) {
        boolean z;
        Wc.b k = k(str);
        if (k != null) {
            int i = b.c[k.ordinal()];
            z = true;
            if (i != 1) {
                if (i != 2) {
                }
            }
            a(z, str);
            return z;
        }
        z = false;
        a(z, str);
        return z;
    }

    public void p(String str) {
        IronLog.API.verbose("userId = " + str);
        this.o = str;
        C3334ub.U().q().a(new C3413z5(A5.SET_USER_ID, IronSourceUtils.getJsonForUserId(false)));
        AdQualityBridge adQualityBridge = this.n0;
        if (adQualityBridge != null) {
            adQualityBridge.changeUserId(str);
        }
    }

    public IronSourceSegment q() {
        return this.C;
    }

    public Ib c() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> a2 = a(this.m.j().c());
        if (a2.size() > 0) {
            return new Ib(a2, this.m.c().e(), IronSourceUtils.getUserIdForNetworks(), Z9.b(), this.C);
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        a(A5.TROUBLESHOOTING_NT_INIT_FAILED, mediationAdditionalData);
        return null;
    }

    p(InterfaceC3381x7 interfaceC3381x7, InterfaceC3381x7.a aVar, L7 l7, InterfaceC3144j7 interfaceC3144j7, H8.a aVar2) {
        this.f3556a = getClass().getName();
        this.b = "!SDK-VERSION-STRING!:com.ironsource:mediationsdk:\u200b8.11.1";
        this.l = new Object();
        this.m = null;
        this.n = null;
        this.o = "";
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.u = false;
        this.y = null;
        this.B = true;
        this.D = "sessionDepth";
        this.O = null;
        this.m0 = false;
        this.c = interfaceC3381x7;
        this.d = aVar;
        this.e = l7;
        this.f = interfaceC3144j7;
        this.g = aVar2;
        t();
        this.k = new AtomicBoolean();
        this.z = new HashSet();
        this.A = new HashSet();
        this.G = false;
        this.F = false;
        this.H = false;
        this.t = new AtomicBoolean(true);
        this.W = new AtomicBoolean(false);
        this.E = 0;
        this.I = false;
        this.J = false;
        this.K = false;
        this.w = IronSourceUtils.getSessionId();
        this.L = Boolean.FALSE;
        this.a0 = false;
        this.N = null;
        this.P = null;
        this.U = null;
        this.V = null;
        this.Q = null;
        this.X = false;
        this.d0 = new ConcurrentHashMap<>();
        this.f0 = new ConcurrentHashMap<>();
        this.e0 = new ConcurrentHashMap<>();
        this.g0 = null;
        this.h0 = null;
        this.i0 = null;
        this.c0 = 1;
        this.j0 = new P5();
        J9 j9 = new J9();
        this.k0 = j9;
        this.l0 = new S6(j9);
        this.o0 = new a();
        this.n0 = null;
        this.p0 = new W7.a();
        this.q0 = new W7.b();
    }

    private C3124i3 g(String str) {
        V2 c2 = this.m.c().c();
        if (c2 == null) {
            return new C3176l5();
        }
        if (TextUtils.isEmpty(str)) {
            return c2.i();
        }
        C3124i3 a2 = c2.a(str);
        return a2 != null ? a2 : c2.i();
    }

    public String l() {
        return this.o;
    }

    public synchronized void a(Context context, String str, boolean z, InitializationListener initializationListener, IronSource.AD_UNIT... ad_unitArr) {
        try {
            try {
                c(z);
                if (a(context, str, z, initializationListener, null, ad_unitArr) == null) {
                    s.c().a(this);
                    s.c().a(this.j0);
                    s.c().a(context, str, this.o, ad_unitArr);
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e(Activity activity, String str) {
        Placement placement;
        Dd dd;
        N7 n7;
        try {
            placement = l(str);
            if (placement == null) {
                try {
                    placement = g();
                } catch (Exception e) {
                    e = e;
                    C3260q4.d().a(e);
                    this.h.logException(IronSourceLogger.IronSourceTag.API, "showProgrammaticRewardedVideo()", e);
                    if (activity == null) {
                    }
                    dd = this.S;
                    if (dd == null) {
                    }
                    n7 = this.P;
                    if (n7 == null) {
                    }
                }
            }
            if (placement == null) {
                this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showProgrammaticRewardedVideo error: empty default placement in response", 3);
                C3184ld.a().a(new IronSourceError(1021, "showProgrammaticRewardedVideo error: empty default placement in response"), (AdInfo) null);
                return;
            }
        } catch (Exception e2) {
            e = e2;
            placement = null;
        }
        if (activity == null) {
            e(activity);
        } else if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "Activity must be provided in showRewardedVideo when initializing SDK with context", 3);
            C3184ld.a().a(ErrorBuilder.buildInitFailedError("Activity must be provided in showRewardedVideo when initializing SDK with context", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            return;
        }
        dd = this.S;
        if (dd == null && (this.X || this.Z)) {
            dd.a(activity, placement);
            return;
        }
        n7 = this.P;
        if (n7 == null) {
            n7.a(activity, placement);
            return;
        }
        this.h.log(IronSourceLogger.IronSourceTag.API, "showProgrammaticRewardedVideo - show called before init completed, managers not initiated yet", 3);
        C3184ld.a().a(new IronSourceError(1023, "showProgrammaticRewardedVideo - show called before init completed, managers not initiated yet"), (AdInfo) null);
    }

    public synchronized IronSourceError a(Context context, String str, boolean z, InitializationListener initializationListener, InterfaceC3200mc interfaceC3200mc, IronSource.AD_UNIT... ad_unitArr) {
        Throwable th;
        try {
            try {
                IronLog.INTERNAL.verbose("GitHash: aee9a3f");
                try {
                    if (!O9.a((Object) context, "Init Failed - provided context is null")) {
                        e("Provided context is null");
                        return new IronSourceError(2000, "Provided context is null");
                    }
                    this.g.a(context);
                    boolean z2 = context instanceof Activity;
                    if (z2) {
                        e((Activity) context);
                    }
                    if (initializationListener != null) {
                        this.U = initializationListener;
                    }
                    AtomicBoolean atomicBoolean = this.t;
                    if (atomicBoolean != null && atomicBoolean.compareAndSet(true, false)) {
                        C3151je.f3381a.a(interfaceC3200mc == null);
                        if ((ad_unitArr == null || ad_unitArr.length == 0) && interfaceC3200mc == null) {
                            for (IronSource.AD_UNIT ad_unit : IronSource.AD_UNIT.values()) {
                                this.z.add(ad_unit);
                            }
                            this.I = true;
                            this.J = true;
                            this.K = true;
                        } else {
                            for (IronSource.AD_UNIT ad_unit2 : ad_unitArr) {
                                this.z.add(ad_unit2);
                                this.A.add(ad_unit2);
                                if (ad_unit2.equals(IronSource.AD_UNIT.INTERSTITIAL)) {
                                    this.J = true;
                                }
                                if (ad_unit2.equals(IronSource.AD_UNIT.BANNER)) {
                                    this.K = true;
                                }
                                if (ad_unit2.equals(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                                    this.I = true;
                                }
                            }
                        }
                        IronLog.API.info("init(appKey:" + str + ")");
                        T3 r = r(str);
                        if (r.b()) {
                            this.n = str;
                        }
                        C3337ue a2 = a(context, this.n);
                        if (a2 != null) {
                            IronLog.INTERNAL.verbose("init cache exists");
                            a(a2.c().b().f());
                        } else {
                            IronLog.INTERNAL.verbose("init cache does not exist");
                        }
                        ContextProvider.getInstance().updateAppContext(context.getApplicationContext());
                        this.d.a(context.getApplicationContext(), TimeUnit.HOURS.toMillis(X4.f3123a.d()));
                        this.k0.g(LevelPlay.getSdkVersion());
                        this.k0.a(P7.a());
                        this.k0.b(IronSourceUtils.isGooglePlayInstalled(context));
                        this.k0.a(C3137j0.a());
                        T();
                        c(context);
                        if (this.n == null) {
                            s.c().f();
                            if (this.z.contains(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                                C3184ld.a().a(false, (AdInfo) null);
                            }
                            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, r.a().toString(), 1);
                            return new IronSourceError(2010, "App key is null");
                        }
                        this.k0.a(context);
                        this.k0.c(this.n);
                        this.k0.h(this.w);
                        if (this.B) {
                            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(z);
                            if (ad_unitArr != null) {
                                for (IronSource.AD_UNIT ad_unit3 : ad_unitArr) {
                                    try {
                                        mediationAdditionalData.put(ad_unit3.toString(), true);
                                    } catch (Exception e) {
                                        C3260q4.d().a(e);
                                    }
                                }
                            }
                            int i = this.E + 1;
                            this.E = i;
                            try {
                                a(z2, z, i, mediationAdditionalData, interfaceC3200mc != null);
                                this.B = false;
                            } catch (Throwable th2) {
                                th = th2;
                                th = th;
                                throw th;
                            }
                        }
                        return null;
                    }
                    if (ad_unitArr != null) {
                        a(z2, z, interfaceC3200mc != null, ad_unitArr);
                        if (A() && !z) {
                            R();
                        }
                    } else {
                        this.h.log(IronSourceLogger.IronSourceTag.API, "Multiple calls to init without ad units are not allowed", 3);
                    }
                    EnumC3135ie b2 = C3151je.f3381a.b();
                    if (A()) {
                        a(this.m);
                        return new IronSourceError(IronSourceError.ERROR_INIT_ALREADY_FINISHED, "Already finished init");
                    }
                    if (b2 == EnumC3135ie.INIT_FAILED) {
                        return new IronSourceError(IronSourceError.ERROR_LEGACY_INIT_FAILED, "Legacy init failed");
                    }
                    if (b2 != EnumC3135ie.NOT_INIT) {
                        if (interfaceC3200mc != null) {
                            a(interfaceC3200mc);
                        }
                        return new IronSourceError(IronSourceError.ERROR_OLD_API_INIT_IN_PROGRESS, "Old Api init in progress");
                    }
                    return new IronSourceError(IronSourceError.ERROR_NEW_INIT_API_ALREADY_CALLED, "Already called new init");
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private void c(Context context) {
        AtomicBoolean atomicBoolean = this.k;
        if (atomicBoolean == null || !atomicBoolean.compareAndSet(false, true)) {
            return;
        }
        C2997af.a().a(new L6(context));
        C3334ub.U().q().a(context, this.C);
        C3400y9.i().a(context, this.C);
        Id.i().a(context, this.C);
        Qc.P.a(context, this.C);
    }

    private void d(Activity activity, String str) {
        try {
            InterstitialPlacement i = i(str);
            if (i == null) {
                i = f();
            }
            if (i == null) {
                this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showProgrammaticInterstitial error: empty default placement in response", 3);
                C3024c8.a().a(new IronSourceError(1020, "showProgrammaticInterstitial error: empty default placement in response"), (AdInfo) null);
                return;
            }
            if (activity != null) {
                e(activity);
            } else if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "Activity must be provided in showInterstitial when initializing SDK with context", 3);
                C3024c8.a().a(new IronSourceError(510, "Activity must be provided in showInterstitial when initializing SDK with context"), (AdInfo) null);
                return;
            }
            this.R.a(activity, new Placement(i));
        } catch (Exception e) {
            C3260q4.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "showProgrammaticInterstitial()", e);
        }
    }

    public String r() {
        return this.w;
    }

    private T4 h() {
        return new T4.b(C3334ub.U().q(), new T4.a("IronSource"));
    }

    public void c(Activity activity) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "showInterstitial()", 1);
        try {
            if (this.G) {
                this.h.log(ironSourceTag, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                C3024c8.a().a(new IronSourceError(510, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"), (AdInfo) null);
            } else {
                if (!B()) {
                    C3024c8.a().a(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"), (AdInfo) null);
                    return;
                }
                InterstitialPlacement f = f();
                if (f != null) {
                    c(activity, f.getPlacementName());
                } else {
                    C3024c8.a().a(new IronSourceError(1020, "showInterstitial error: empty default placement in response"), (AdInfo) null);
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "showInterstitial()", e);
            C3024c8.a().a(new IronSourceError(510, e.getMessage()), (AdInfo) null);
        }
    }

    @Override // com.ironsource.S4.c
    public synchronized boolean f(String str) {
        boolean z;
        com.ironsource.mediationsdk.demandOnly.k kVar = this.h0;
        if (kVar != null) {
            z = kVar.a(str);
        }
        return z;
    }

    private InterstitialPlacement f() {
        C3366w9 d2 = this.m.c().d();
        if (d2 != null) {
            return d2.a();
        }
        return null;
    }

    public List<IronSource.AD_UNIT> m() {
        ArrayList arrayList = new ArrayList();
        Set<IronSource.AD_UNIT> set = this.z;
        if (set != null) {
            arrayList.addAll(set);
        }
        return arrayList;
    }

    @Override // com.ironsource.S4.a
    public void d(String str) {
        this.h.log(IronSourceLogger.IronSourceTag.API, "destroyBanner()", 1);
        try {
            com.ironsource.mediationsdk.demandOnly.c cVar = this.i0;
            if (cVar != null) {
                cVar.a(str);
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "destroyISDemandOnlyBanner()", th);
        }
    }

    Boolean d() {
        return this.O;
    }

    private boolean d(C3337ue c3337ue) {
        com.ironsource.mediationsdk.adquality.a a2 = c3337ue.c().a();
        return this.n0 == null && a2 != null && a2.b() && AdQualityBridge.adQualityAvailable();
    }

    public C3337ue e() {
        return this.m;
    }

    private void e(Activity activity) {
        ContextProvider.getInstance().updateActivity(activity);
        IronLog.INTERNAL.verbose("activity is updated to: " + activity.hashCode());
    }

    public void c(Activity activity, String str) {
        String str2 = "showInterstitial(" + str + ")";
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, str2, 1);
        try {
            if (this.G) {
                this.h.log(ironSourceTag, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                C3024c8.a().a(new IronSourceError(510, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"), (AdInfo) null);
            } else if (!B()) {
                C3024c8.a().a(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"), (AdInfo) null);
            } else {
                d(activity, str);
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, str2, e);
            C3024c8.a().a(new IronSourceError(510, e.getMessage()), (AdInfo) null);
        }
    }

    private void b(IronSource.AD_UNIT ad_unit) {
        int i = b.f3558a[ad_unit.ordinal()];
        if (i == 1) {
            d0();
        } else if (i == 2) {
            Z();
        } else {
            if (i != 3) {
                return;
            }
            U();
        }
    }

    private com.ironsource.mediationsdk.demandOnly.k b(List<NetworkSettings> list) {
        Gd f = this.m.c().f();
        T4.a aVar = new T4.a("Mediation");
        if (f.d()) {
            aVar.a("isOneFlow", 1);
        }
        return new com.ironsource.mediationsdk.demandOnly.k(list, f, com.ironsource.mediationsdk.c.b(), this.q0, k(), l(), new T4.b(Id.i(), aVar));
    }

    @Override // com.ironsource.S4.b
    public synchronized boolean c(String str) {
        boolean z;
        com.ironsource.mediationsdk.demandOnly.f fVar = this.g0;
        if (fVar != null) {
            z = fVar.b(str);
        }
        return z;
    }

    private boolean c(C3337ue c3337ue) {
        return c3337ue != null && c3337ue.o();
    }

    public void b(Activity activity) {
        IronLog ironLog = IronLog.API;
        ironLog.info("onResume()");
        try {
            if (FeaturesManager.getInstance().getStopUseOnResumeAndPause()) {
                ironLog.info("onResume() is disabled");
            } else {
                ContextProvider.getInstance().onResume(activity);
            }
        } catch (Throwable th) {
            this.h.logException(IronSourceLogger.IronSourceTag.API, "onResume()", th);
            C3260q4.d().a(th);
        }
    }

    @Override // com.ironsource.S4.c
    public synchronized void b(Activity activity, String str) {
        a(new h.c().b(str).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(IronSource.AD_UNIT.REWARDED_VIDEO).b(), this.q0.a(str));
    }

    @Override // com.ironsource.S4.b
    public synchronized void b(Activity activity, String str, String str2) {
        a(new h.c().b(str).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(IronSource.AD_UNIT.INTERSTITIAL).a(true).a(str2).b(), this.p0.a(str));
    }

    @Override // com.ironsource.S4.b
    public void b(String str) {
        this.h.log(IronSourceLogger.IronSourceTag.API, "showDemandOnlyInterstitial() instanceId=" + str, 1);
        ISDemandOnlyInterstitialListener a2 = this.p0.a(str);
        try {
            if (!this.G) {
                IronLog.API.error("Interstitial was initialized in mediation mode. Use showInterstitial instead");
                a2.onInterstitialAdShowFailed(str, new IronSourceError(508, "Interstitial was initialized in mediation mode. Use showInterstitial instead"));
                return;
            }
            com.ironsource.mediationsdk.demandOnly.f fVar = this.g0;
            if (fVar == null) {
                IronLog.API.error("Interstitial was not initiated");
                a2.onInterstitialAdShowFailed(str, new IronSourceError(508, "Interstitial was not initiated"));
            } else {
                fVar.a(str);
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.API.error(e.getMessage());
            if (a2 != null) {
                a2.onInterstitialAdShowFailed(str, ErrorBuilder.buildInitFailedError("showISDemandOnlyInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
            }
        }
    }

    public IronSourceBannerLayout b(Activity activity, ISBannerSize iSBannerSize) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "createBanner()", 1);
        if (activity == null) {
            this.h.log(ironSourceTag, "createBanner() : Activity cannot be null", 3);
            return null;
        }
        ContextProvider.getInstance().updateActivity(activity);
        return new IronSourceBannerLayout(activity, iSBannerSize);
    }

    private void a(K1 k1) {
        X4 x4 = X4.f3123a;
        x4.c(k1.g());
        x4.a(k1.f());
        x4.a(k1.j());
        this.f.a(k1);
    }

    public void b(IronSourceBannerLayout ironSourceBannerLayout) {
        a(ironSourceBannerLayout, "");
    }

    private boolean b(h.b bVar) {
        synchronized (this.e0) {
            if (this.i0 != null) {
                return false;
            }
            this.e0.put(bVar.e(), bVar);
            return true;
        }
    }

    @Override // com.ironsource.S4
    public synchronized void a(Context context, String str, IronSource.AD_UNIT... ad_unitArr) {
        try {
            try {
                List<IronSource.AD_UNIT> a2 = a(context, str, true, ad_unitArr);
                if (!a2.isEmpty()) {
                    a(context, str, true, (InitializationListener) null, (IronSource.AD_UNIT[]) a2.toArray(new IronSource.AD_UNIT[a2.size()]));
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public synchronized List<IronSource.AD_UNIT> a(Context context, String str, boolean z, IronSource.AD_UNIT... ad_unitArr) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if ((ad_unitArr == null || ad_unitArr.length == 0) && z) {
            if (this.I) {
                a(IronSource.AD_UNIT.REWARDED_VIDEO);
            } else {
                this.F = true;
                arrayList.add(IronSource.AD_UNIT.REWARDED_VIDEO);
            }
            if (this.J) {
                a(IronSource.AD_UNIT.INTERSTITIAL);
            } else {
                this.G = true;
                arrayList.add(IronSource.AD_UNIT.INTERSTITIAL);
            }
            if (this.K) {
                a(IronSource.AD_UNIT.BANNER);
            } else {
                this.H = true;
                arrayList.add(IronSource.AD_UNIT.BANNER);
            }
        } else {
            for (IronSource.AD_UNIT ad_unit : ad_unitArr) {
                if (ad_unit.equals(IronSource.AD_UNIT.INTERSTITIAL)) {
                    if (this.J) {
                        a(ad_unit);
                    } else {
                        this.G = true;
                        if (!arrayList.contains(ad_unit)) {
                            arrayList.add(ad_unit);
                        }
                    }
                }
                if (ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                    if (this.I) {
                        a(ad_unit);
                    } else {
                        this.F = true;
                        if (!arrayList.contains(ad_unit)) {
                            arrayList.add(ad_unit);
                        }
                    }
                }
                if (ad_unit.equals(IronSource.AD_UNIT.BANNER)) {
                    if (this.K) {
                        a(ad_unit);
                    } else {
                        this.H = true;
                        if (!arrayList.contains(ad_unit)) {
                            arrayList.add(ad_unit);
                        }
                    }
                }
            }
        }
        if (context != null) {
            if (context instanceof Activity) {
                e((Activity) context);
            }
            ContextProvider.getInstance().updateAppContext(context.getApplicationContext());
        }
        return arrayList;
    }

    public String b() {
        s c2 = s.c();
        int i = b.b[c2.a().ordinal()];
        if (i != 1) {
            return i != 2 ? i != 3 ? (i == 4 && !G()) ? "No Native Ad configurations found" : "" : c2.d() ? "init() had failed" : "init() not finished yet" : "init() had failed";
        }
        return "init() must be called first";
    }

    C3337ue b(Context context, String str, c cVar) {
        synchronized (this.l) {
            C3337ue c3337ue = this.m;
            if (c3337ue != null) {
                return new C3337ue(c3337ue);
            }
            C3337ue a2 = a(context, str, cVar);
            if (a2 == null || !a2.p()) {
                IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                logger.log(ironSourceTag, "Null or invalid response. Trying to get cached response", 0);
                a2 = a(context, k());
                if (a2 != null) {
                    this.h.log(ironSourceTag, ErrorBuilder.buildUsingCachedConfigurationError(k(), str).toString() + ": " + a2.toString(), 1);
                    C3334ub.U().q().a(new C3413z5(A5.USING_CACHE_FOR_INIT_EVENT, IronSourceUtils.getMediationAdditionalData(false)));
                }
            }
            if (a2 != null) {
                this.m = a2;
                IronSourceUtils.saveLastResponse(context, a2.toString());
                b(this.m, context);
                C3400y9.i().c(true);
                Id.i().c(true);
                Qc.P.c(true);
                C3334ub.U().q().c(true);
            }
            return a2;
        }
    }

    private void a(IronSource.AD_UNIT ad_unit) {
        String str = ad_unit + " ad unit has already been initialized";
        this.h.log(IronSourceLogger.IronSourceTag.API, str, 3);
        IronSourceUtils.sendAutomationLog(str);
    }

    private synchronized void a(boolean z, boolean z2, boolean z3, IronSource.AD_UNIT... ad_unitArr) {
        Throwable th;
        try {
            try {
                int i = 0;
                for (IronSource.AD_UNIT ad_unit : ad_unitArr) {
                    try {
                        if (ad_unit.equals(IronSource.AD_UNIT.INTERSTITIAL)) {
                            this.J = true;
                        } else if (ad_unit.equals(IronSource.AD_UNIT.BANNER)) {
                            this.K = true;
                        } else if (ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                            this.I = true;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                if (s.c().a() == s.d.INIT_FAILED) {
                    try {
                        if (this.i != null) {
                            int length = ad_unitArr.length;
                            while (i < length) {
                                IronSource.AD_UNIT ad_unit2 = ad_unitArr[i];
                                if (!this.z.contains(ad_unit2)) {
                                    a(ad_unit2, true);
                                }
                                i++;
                            }
                        }
                    } catch (Exception e) {
                        C3260q4.d().a(e);
                        IronLog.INTERNAL.error(e.toString());
                    }
                }
                if (!A()) {
                    JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(z2);
                    int length2 = ad_unitArr.length;
                    while (i < length2) {
                        IronSource.AD_UNIT ad_unit3 = ad_unitArr[i];
                        if (!this.z.contains(ad_unit3)) {
                            this.z.add(ad_unit3);
                            this.A.add(ad_unit3);
                            try {
                                mediationAdditionalData.put(ad_unit3.toString(), true);
                            } catch (Exception e2) {
                                C3260q4.d().a(e2);
                                IronLog.INTERNAL.error(e2.toString());
                            }
                        } else {
                            this.h.log(IronSourceLogger.IronSourceTag.API, ad_unit3 + " ad unit has started initializing.", 3);
                        }
                        i++;
                    }
                    int i2 = this.E + 1;
                    this.E = i2;
                    a(z, z2, i2, mediationAdditionalData, z3);
                } else {
                    if (this.v == null) {
                        return;
                    }
                    try {
                        new C3351vb().a(this.m.c().b().e().b(), z());
                    } catch (Exception e3) {
                        C3260q4.d().a(e3);
                        IronLog.INTERNAL.error(e3.toString());
                    }
                    JSONObject mediationAdditionalData2 = IronSourceUtils.getMediationAdditionalData(z2);
                    for (IronSource.AD_UNIT ad_unit4 : ad_unitArr) {
                        if (!this.z.contains(ad_unit4)) {
                            this.z.add(ad_unit4);
                            this.A.add(ad_unit4);
                            try {
                                mediationAdditionalData2.put(ad_unit4.toString(), true);
                            } catch (Exception e4) {
                                C3260q4.d().a(e4);
                                IronLog.INTERNAL.error(e4.toString());
                            }
                            List<IronSource.AD_UNIT> list = this.v;
                            if (list != null && list.contains(ad_unit4)) {
                                b(ad_unit4);
                            } else {
                                a(ad_unit4, false);
                            }
                        } else {
                            a(ad_unit4);
                        }
                    }
                    int i3 = this.E + 1;
                    this.E = i3;
                    try {
                        a(z, z2, i3, mediationAdditionalData2, z3);
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public void b(C3337ue c3337ue, Context context) {
        b(c3337ue);
        a(c3337ue, context);
    }

    private void b(C3337ue c3337ue) {
        this.j.setDebugLevel(c3337ue.c().b().h().b());
        this.h.setLoggerDebugLevel("console", c3337ue.c().b().h().a());
    }

    private void b(A5 a5, JSONObject jSONObject) {
        Id.i().a(new C3413z5(a5, jSONObject));
    }

    public void b(String str, JSONObject jSONObject) {
        com.ironsource.mediationsdk.c.b().b(new v(str, jSONObject));
    }

    @Override // com.ironsource.T8
    public void b(ImpressionDataListener impressionDataListener) {
        if (O9.a((Object) impressionDataListener, "addImpressionDataListener - listener is null")) {
            Z9.b().a(impressionDataListener);
            N7 n7 = this.P;
            if (n7 != null) {
                n7.b(impressionDataListener);
            }
            w wVar = this.Q;
            if (wVar != null) {
                wVar.b(impressionDataListener);
            }
            IronLog.API.info("add impression data listener to " + impressionDataListener.getClass().getSimpleName());
        }
    }

    public void b(Context context) {
        C3119hf c3119hf = C3119hf.f3344a;
        c3119hf.b();
        if (!A()) {
            c3119hf.a(IronSourceConstants.errorCode_TEST_SUITE_SDK_NOT_INITIALIZED);
            IronLog.API.error("TestSuite cannot be launched, SDK not initialized");
            return;
        }
        if (!c(this.m)) {
            c3119hf.a(IronSourceConstants.errorCode_TEST_SUITE_DISABLED);
            IronLog.API.error("TestSuite cannot be launched, Please contact your account manager to enable it");
            return;
        }
        if (!IronSourceUtils.isNetworkConnected(context)) {
            c3119hf.a(IronSourceConstants.errorCode_TEST_SUITE_NO_NETWORK_CONNECTIVITY);
            IronLog.API.error("TestSuite cannot be launched, No network connectivity");
            return;
        }
        C3281r9 c3281r9 = this.R;
        if (c3281r9 != null) {
            c3281r9.J();
        }
        Dd dd = this.S;
        if (dd != null) {
            dd.J();
        }
        H2 h2 = this.T;
        if (h2 != null) {
            h2.J();
            this.T.T();
        }
        new Cif().a(context, k(), this.m.i(), LevelPlay.getSdkVersion(), this.m.c().g().b(), d(), this.X);
        this.m0 = true;
        c3119hf.c();
    }

    private void a(boolean z, boolean z2, int i, JSONObject jSONObject, boolean z3) {
        try {
            StringBuilder sb = new StringBuilder();
            if (z2) {
                sb.append(String.format(",Activity=%s", Boolean.valueOf(ContextProvider.getInstance().getCurrentActiveActivity() != null)));
            } else if (!z) {
                sb.append(",init_context_flow");
            }
            sb.append(String.format(",cachedUserAgent=%s", Boolean.valueOf(this.c.n())));
            jSONObject.put(IronSourceConstants.EVENTS_EXT1, sb.toString());
            jSONObject.put("sessionDepth", i);
            if (z3) {
                if (z2) {
                    jSONObject.put("isMultipleAdObjects", 1);
                } else {
                    jSONObject.put("isMultipleAdUnits", 1);
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        C3334ub.U().q().a(new C3413z5(A5.FIRST_INSTANCE, jSONObject));
    }

    private synchronized void a(InterfaceC3200mc interfaceC3200mc) {
        this.V = interfaceC3200mc;
    }

    public boolean a(boolean z, C3337ue c3337ue) {
        a(c3337ue);
        if (A()) {
            return true;
        }
        synchronized (this.l) {
            this.m = c3337ue;
        }
        return b(c3337ue.g(), z, c3337ue.c());
    }

    @Override // com.ironsource.InterfaceC3335uc
    public void a(List<IronSource.AD_UNIT> list, boolean z, U3 u3) {
        a(this.m);
        b(list, z, u3);
    }

    private void a(C3337ue c3337ue) {
        if (u() && d(c3337ue)) {
            AdQualityBridge adQualityBridge = new AdQualityBridge(ContextProvider.getInstance().getApplicationContext(), k(), l(), new C3104h0(), c3337ue.c().b().h().a());
            this.n0 = adQualityBridge;
            IronSourceSegment ironSourceSegment = this.C;
            if (ironSourceSegment != null) {
                adQualityBridge.setSegment(ironSourceSegment);
            }
        }
    }

    private com.ironsource.mediationsdk.demandOnly.f a(List<NetworkSettings> list) {
        C3366w9 d2 = this.m.c().d();
        T4.a aVar = new T4.a("Mediation");
        if (d2.j()) {
            aVar.a("isOneFlow", 1);
        }
        return new com.ironsource.mediationsdk.demandOnly.f(list, d2, com.ironsource.mediationsdk.c.b(), this.p0, k(), l(), new T4.b(C3400y9.i(), aVar));
    }

    private int a(Gd gd) {
        return (this.Z || this.X || !gd.k().e()) ? 1 : 2;
    }

    private List<NetworkSettings> a(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            String str = arrayList.get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList2.add(this.m.k().b(str));
            }
        }
        return arrayList2;
    }

    @Override // com.ironsource.InterfaceC3335uc
    public void a() {
        if (this.L.booleanValue()) {
            this.L = Boolean.FALSE;
            n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(603, "init() had failed"));
            this.M = null;
            this.N = null;
        }
        if (this.a0) {
            this.a0 = false;
            n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
        }
        if (this.Y) {
            this.Y = false;
            n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
        synchronized (this.d0) {
            Iterator<h.d> it = this.d0.values().iterator();
            while (it.hasNext()) {
                String e = it.next().e();
                this.p0.a(e).onInterstitialAdLoadFailed(e, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
            }
            this.d0.clear();
        }
        synchronized (this.f0) {
            Iterator<h.d> it2 = this.f0.values().iterator();
            while (it2.hasNext()) {
                String e2 = it2.next().e();
                this.q0.a(e2).onRewardedVideoAdLoadFailed(e2, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
            this.f0.clear();
        }
        synchronized (this.e0) {
            for (h.b bVar : this.e0.values()) {
                ISDemandOnlyBannerLayout g = bVar.g();
                if (g != null) {
                    g.getListener().a(bVar.e(), ErrorBuilder.buildInitFailedError("init() had failed", "Banner"));
                }
            }
            this.e0.clear();
        }
    }

    private void a(IronSource.AD_UNIT ad_unit, boolean z) {
        int i = b.f3558a[ad_unit.ordinal()];
        if (i == 1) {
            if (this.F) {
                Iterator<h.d> it = this.f0.values().iterator();
                while (it.hasNext()) {
                    String e = it.next().e();
                    this.q0.a(e).onRewardedVideoAdLoadFailed(e, ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                }
                this.f0.clear();
                return;
            }
            if (this.X) {
                if (this.Y) {
                    this.Y = false;
                    n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                    return;
                }
                return;
            }
            if (z || J() || this.A.contains(ad_unit)) {
                C3184ld.a().a(false, (AdInfo) null);
                return;
            }
            return;
        }
        if (i == 2) {
            if (this.G) {
                Iterator<h.d> it2 = this.d0.values().iterator();
                while (it2.hasNext()) {
                    String e2 = it2.next().e();
                    this.p0.a(e2).onInterstitialAdLoadFailed(e2, ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", "Interstitial"));
                }
                this.d0.clear();
                return;
            }
            if (this.a0) {
                this.a0 = false;
                n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                return;
            }
            return;
        }
        if (i != 3) {
            return;
        }
        if (this.H) {
            for (h.b bVar : this.e0.values()) {
                ISDemandOnlyBannerLayout g = bVar.g();
                if (g != null) {
                    g.getListener().a(bVar.e(), ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", "Banner"));
                }
            }
            this.e0.clear();
            return;
        }
        if (this.L.booleanValue()) {
            this.L = Boolean.FALSE;
            n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(602, "init() had failed"));
            this.M = null;
            this.N = null;
        }
    }

    public void a(Activity activity) {
        try {
            if (FeaturesManager.getInstance().getStopUseOnResumeAndPause()) {
                return;
            }
            this.h.log(IronSourceLogger.IronSourceTag.API, "onPause()", 1);
            ContextProvider.getInstance().onPause(activity);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "onPause()", th);
        }
    }

    public void a(IronSourceSegment ironSourceSegment) {
        this.C = ironSourceSegment;
        Dd dd = this.S;
        if (dd != null) {
            dd.a(ironSourceSegment);
        }
        N7 n7 = this.P;
        if (n7 != null) {
            n7.a(ironSourceSegment);
        }
        C3281r9 c3281r9 = this.R;
        if (c3281r9 != null) {
            c3281r9.a(ironSourceSegment);
        }
        w wVar = this.Q;
        if (wVar != null) {
            wVar.a(ironSourceSegment);
        }
        H2 h2 = this.T;
        if (h2 != null) {
            h2.a(ironSourceSegment);
        }
        AdQualityBridge adQualityBridge = this.n0;
        if (adQualityBridge != null) {
            adQualityBridge.setSegment(ironSourceSegment);
        }
        C3400y9.i().a(this.C);
        Id.i().a(this.C);
        Qc.P.a(this.C);
        C3334ub.U().q().a(this.C);
    }

    public synchronized void a(LevelPlayRewardedVideoManualListener levelPlayRewardedVideoManualListener) {
        IronLog ironLog = IronLog.API;
        ironLog.info();
        if (!this.I) {
            if (levelPlayRewardedVideoManualListener == null) {
                this.X = false;
                ironLog.info("Disabling rewarded video manual mode");
            } else {
                this.X = true;
                ironLog.info("Enabling rewarded video manual mode");
            }
        }
        C3184ld.a().a(levelPlayRewardedVideoManualListener);
    }

    public void a(LevelPlayRewardedVideoListener levelPlayRewardedVideoListener) {
        IronLog.API.info();
        C3184ld.a().a(levelPlayRewardedVideoListener);
    }

    @Override // com.ironsource.S4.c
    public synchronized void a(Activity activity, String str, String str2) {
        a(new h.c().b(str).a(str2).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(true).a(IronSource.AD_UNIT.REWARDED_VIDEO).b(), this.q0.a(str));
    }

    void a(h.d dVar, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        String e = dVar.e();
        IronLog ironLog = IronLog.API;
        ironLog.info("instanceId=" + e);
        try {
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.API.error(th.getMessage());
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(e, new IronSourceError(510, th.getMessage()));
        }
        if (!this.I) {
            ironLog.error("initISDemandOnly() must be called before loadDemandOnlyRewardedVideo()");
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(e, new IronSourceError(510, "initISDemandOnly() must be called before loadDemandOnlyRewardedVideo()"));
            return;
        }
        if (!this.F) {
            ironLog.error("Rewarded video was initialized in mediation mode");
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(e, new IronSourceError(510, "Rewarded video was initialized in mediation mode"));
            return;
        }
        s.d a2 = s.c().a();
        if (a2 == s.d.INIT_FAILED) {
            ironLog.error("init() had failed");
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(e, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        IronSourceError a3 = dVar.a();
        if (a3 != null) {
            if (a3.getErrorCode() == 1060) {
                b(A5.TROUBLESHOOTING_DO_CALLED_RV_LOAD_WITH_NO_ACTIVITY, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.b()), 1));
            }
            ironLog.error(a3.toString());
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(e, a3);
            return;
        }
        e(dVar.d());
        if (a2 == s.d.INIT_IN_PROGRESS) {
            if (s.c().d()) {
                ironLog.error("init() had failed");
                iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(e, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            synchronized (this.f0) {
                this.f0.put(e, dVar);
            }
            if (TextUtils.isEmpty(dVar.b())) {
                return;
            }
            b(A5.TROUBLESHOOTING_DO_IAB_RV_LOAD_FAILED_INIT_IN_PROGRESS, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.b()), 1));
            return;
        }
        if (!K()) {
            ironLog.error("No rewarded video configurations found");
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(e, ErrorBuilder.buildInitFailedError("the server response does not contain rewarded video data", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        synchronized (this.f0) {
            com.ironsource.mediationsdk.demandOnly.k kVar = this.h0;
            if (kVar == null) {
                this.f0.put(e, dVar);
                if (!TextUtils.isEmpty(dVar.b())) {
                    b(A5.TROUBLESHOOTING_DO_IAB_RV_LOAD_FAILED_INIT_IN_PROGRESS, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.b()), 1));
                }
                return;
            }
            kVar.a(dVar);
            return;
        }
        C3260q4.d().a(th);
        IronLog.API.error(th.getMessage());
        iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(e, new IronSourceError(510, th.getMessage()));
    }

    @Override // com.ironsource.S4.c
    public synchronized void a(String str) {
        IronLog ironLog = IronLog.API;
        ironLog.info("instanceId=" + str);
        ISDemandOnlyRewardedVideoListener a2 = this.q0.a(str);
        try {
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.API.error(e.getMessage());
            if (a2 != null) {
                a2.onRewardedVideoAdShowFailed(str, new IronSourceError(510, e.getMessage()));
            }
        }
        if (!this.F) {
            ironLog.error("Rewarded video was initialized in mediation mode. Use showRewardedVideo instead");
            a2.onRewardedVideoAdShowFailed(str, new IronSourceError(508, "Rewarded video was initialized in mediation mode. Use showRewardedVideo instead"));
            return;
        }
        com.ironsource.mediationsdk.demandOnly.k kVar = this.h0;
        if (kVar == null) {
            ironLog.error("Rewarded video was not initiated");
            a2.onRewardedVideoAdShowFailed(str, new IronSourceError(508, "Rewarded video was not initiated"));
        } else {
            kVar.b(str);
        }
    }

    @Override // com.ironsource.S4.c
    public void a(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        this.q0.a((W7<ISDemandOnlyRewardedVideoListener>) iSDemandOnlyRewardedVideoListener);
    }

    public void a(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        IronLog.API.info();
        C3024c8.a().a(levelPlayInterstitialListener);
    }

    @Override // com.ironsource.S4.b
    public synchronized void a(Activity activity, String str) {
        a(new h.c().b(str).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(IronSource.AD_UNIT.INTERSTITIAL).b(), this.p0.a(str));
    }

    private synchronized void a(h.d dVar, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        String e = dVar.e();
        IronLog ironLog = IronLog.API;
        ironLog.info("instanceId=" + e);
        try {
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.API.error(th.getMessage());
            iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(e, new IronSourceError(510, th.getMessage()));
        }
        if (!this.J) {
            ironLog.error("initISDemandOnly() must be called before loadISDemandOnlyInterstitial()");
            iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(e, new IronSourceError(510, "initISDemandOnly() must be called before loadISDemandOnlyInterstitial()"));
            return;
        }
        if (!this.G) {
            ironLog.error("Interstitial was initialized in mediation mode. Use loadInterstitial instead");
            iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(e, new IronSourceError(510, "Interstitial was initialized in mediation mode. Use loadInterstitial instead"));
            return;
        }
        s.d a2 = s.c().a();
        if (a2 == s.d.INIT_FAILED) {
            ironLog.error("init() had failed");
            iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(e, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
            return;
        }
        IronSourceError a3 = dVar.a();
        if (a3 != null) {
            if (a3.getErrorCode() == 1060) {
                b(A5.TROUBLESHOOTING_DO_CALLED_IS_LOAD_WITH_NO_ACTIVITY, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.b()), 1));
            }
            ironLog.error(a3.toString());
            iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(e, a3);
            return;
        }
        e(dVar.d());
        if (a2 == s.d.INIT_IN_PROGRESS) {
            if (s.c().d()) {
                ironLog.error("init() had failed");
                iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(e, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
            } else {
                synchronized (this.d0) {
                    this.d0.put(dVar.e(), dVar);
                }
                if (!TextUtils.isEmpty(dVar.e())) {
                    a(A5.TROUBLESHOOTING_DO_IAB_IS_LOAD_FAILED_INIT_IN_PROGRESS, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.b()), 1));
                }
            }
            return;
        }
        if (!C()) {
            ironLog.error("No interstitial configurations found");
            iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(e, ErrorBuilder.buildInitFailedError("the server response does not contain interstitial data", "Interstitial"));
            return;
        }
        synchronized (this.d0) {
            com.ironsource.mediationsdk.demandOnly.f fVar = this.g0;
            if (fVar == null) {
                this.d0.put(dVar.e(), dVar);
                if (!TextUtils.isEmpty(dVar.b())) {
                    a(A5.TROUBLESHOOTING_DO_IAB_IS_LOAD_FAILED_INIT_IN_PROGRESS, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.b()), 1));
                }
                return;
            }
            fVar.a(dVar);
        }
    }

    @Override // com.ironsource.S4.b
    public void a(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        this.p0.a((W7<ISDemandOnlyInterstitialListener>) iSDemandOnlyInterstitialListener);
    }

    @Override // com.ironsource.InterfaceC3267qb
    public void a(LogListener logListener) {
        if (logListener == null) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "setLogListener(LogListener:null)", 1);
            return;
        }
        this.j.a(logListener);
        this.h.log(IronSourceLogger.IronSourceTag.API, "setLogListener(LogListener:" + logListener.getClass().getSimpleName() + ")", 1);
        C3334ub.U().q().a(new C3413z5(A5.SET_LOG_LISTENER, IronSourceUtils.getMediationAdditionalData(false)));
    }

    @Override // com.ironsource.S4.a
    public ISDemandOnlyBannerLayout a(Activity activity, ISBannerSize iSBannerSize) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "createBannerForDemandOnly()", 1);
        if (activity == null) {
            this.h.log(ironSourceTag, "createBannerForDemandOnly() : Activity cannot be null", 3);
            return null;
        }
        ContextProvider.getInstance().updateActivity(activity);
        return new ISDemandOnlyBannerLayout(activity, iSBannerSize);
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, String str) {
        IronLog.INTERNAL.verbose("placementName = " + str);
        if (this.H) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "Banner was initialized in demand only mode. Use loadISDemandOnlyBanner instead", 3);
            n.a().b(IronSource.AD_UNIT.BANNER, ErrorBuilder.buildInitFailedError("Banner was initialized in demand only mode. Use loadISDemandOnlyBanner instead", "Banner"));
            return;
        }
        if (ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed()) {
            if (!this.K) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "init() must be called before loadBanner()", 3);
                n.a().b(IronSource.AD_UNIT.BANNER, ErrorBuilder.buildLoadFailedError("init() must be called before loadBanner()"));
                return;
            }
            if (ironSourceBannerLayout.getSize().getDescription().equals("CUSTOM") && (ironSourceBannerLayout.getSize().getWidth() <= 0 || ironSourceBannerLayout.getSize().getHeight() <= 0)) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "loadBanner: Unsupported banner size. Height and width must be bigger than 0", 3);
                n.a().b(IronSource.AD_UNIT.BANNER, ErrorBuilder.unsupportedBannerSize(""));
                return;
            }
            s.d a2 = s.c().a();
            if (a2 == s.d.INIT_FAILED) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(600, "Init() had failed"));
                return;
            }
            if (a2 == s.d.INIT_IN_PROGRESS) {
                if (s.c().d()) {
                    this.h.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                    n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(601, "Init() had failed"));
                    return;
                } else {
                    this.M = ironSourceBannerLayout;
                    this.L = Boolean.TRUE;
                    this.N = str;
                    return;
                }
            }
            if (!x()) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
                n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(615, "the server response does not contain banner data"));
                return;
            }
            w wVar = this.Q;
            if (wVar == null && this.T == null) {
                this.M = ironSourceBannerLayout;
                this.L = Boolean.TRUE;
                this.N = str;
                return;
            } else if (this.b0) {
                this.T.a(ironSourceBannerLayout, new Placement(g(str)));
                return;
            } else {
                wVar.a(ironSourceBannerLayout, g(str));
                return;
            }
        }
        String concat = "loadBanner can't be called - ".concat(ironSourceBannerLayout == null ? "banner layout is null " : "banner layout is destroyed");
        this.h.log(IronSourceLogger.IronSourceTag.API, concat, 3);
        n.a().b(IronSource.AD_UNIT.BANNER, ErrorBuilder.buildLoadFailedError(concat));
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout) {
        H2 h2;
        this.h.log(IronSourceLogger.IronSourceTag.API, "destroyBanner()", 1);
        try {
            if (this.b0 && (h2 = this.T) != null) {
                h2.a(ironSourceBannerLayout);
                return;
            }
            w wVar = this.Q;
            if (wVar != null) {
                wVar.a(ironSourceBannerLayout);
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "destroyBanner()", th);
        }
    }

    @Override // com.ironsource.S4.a
    public synchronized void a(Activity activity, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str, String str2) {
        h.b a2 = new h.c().b(str).a(activity).a(true).a(str2).a(iSDemandOnlyBannerLayout).a(IronSource.AD_UNIT.BANNER).a();
        IronSourceError a3 = a2.a();
        if (a3 != null) {
            this.h.log(IronSourceLogger.IronSourceTag.API, a3.getErrorMessage(), 3);
            if (iSDemandOnlyBannerLayout != null) {
                iSDemandOnlyBannerLayout.getListener().a(str, a3);
            }
            return;
        }
        IronSourceError a4 = a(s.c().a());
        if (a4 != null) {
            this.h.log(IronSourceLogger.IronSourceTag.API, a4.getErrorMessage(), 3);
            iSDemandOnlyBannerLayout.getListener().a(str, a4);
            return;
        }
        ContextProvider.getInstance().updateActivity(activity);
        if (a(a2)) {
            return;
        }
        if (!x()) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
            iSDemandOnlyBannerLayout.getListener().a(str, ErrorBuilder.buildInitFailedError("the server response does not contain banner data", "Banner"));
        } else {
            if (b(a2)) {
                return;
            }
            this.i0.a(iSDemandOnlyBannerLayout, str, str2);
        }
    }

    @Override // com.ironsource.S4.a
    public synchronized void a(Activity activity, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str) {
        h.b a2 = new h.c().b(str).a(activity).a(iSDemandOnlyBannerLayout).a(IronSource.AD_UNIT.BANNER).a();
        IronSourceError a3 = a2.a();
        if (a3 != null) {
            this.h.log(IronSourceLogger.IronSourceTag.API, a3.getErrorMessage(), 3);
            if (iSDemandOnlyBannerLayout != null) {
                iSDemandOnlyBannerLayout.getListener().a(str, a3);
            }
            return;
        }
        IronSourceError a4 = a(s.c().a());
        if (a4 != null) {
            this.h.log(IronSourceLogger.IronSourceTag.API, a4.getErrorMessage(), 3);
            iSDemandOnlyBannerLayout.getListener().a(str, a4);
            return;
        }
        ContextProvider.getInstance().updateActivity(activity);
        if (a(a2)) {
            return;
        }
        if (!x()) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
            iSDemandOnlyBannerLayout.getListener().a(str, ErrorBuilder.buildInitFailedError("the server response does not contain banner data", "Banner"));
        } else {
            if (b(a2)) {
                return;
            }
            this.i0.a(iSDemandOnlyBannerLayout, str);
        }
    }

    private boolean a(h.b bVar) {
        if (s.c().a() != s.d.INIT_IN_PROGRESS) {
            return false;
        }
        synchronized (this.e0) {
            this.e0.put(bVar.e(), bVar);
        }
        return true;
    }

    private IronSourceError a(s.d dVar) {
        if (!this.K) {
            return new IronSourceError(510, "ironSource SDK was not initialized");
        }
        if (!this.H) {
            return new IronSourceError(510, "ironSource SDK was not initialized using Demand Only mode");
        }
        if (dVar == s.d.INIT_FAILED) {
            return new IronSourceError(510, "ironSource initialization failed");
        }
        if (dVar == s.d.INIT_IN_PROGRESS && s.c().d()) {
            return new IronSourceError(510, "ironSource initialization in progress");
        }
        return null;
    }

    public C3337ue a(Context context, String str) {
        if (!C3025c9.a(context)) {
            return null;
        }
        F3 c2 = C3025c9.c(context);
        String d2 = c2.d();
        String f = c2.f();
        String e = c2.e();
        if (!d2.equals(str)) {
            return null;
        }
        C3337ue c3337ue = new C3337ue(context, d2, f, e);
        c3337ue.a(C3337ue.a.CACHE);
        return c3337ue;
    }

    private C3337ue a(Context context, String str, c cVar) {
        Exception exc;
        C3337ue c3337ue = null;
        if (!IronSourceUtils.isNetworkConnected(context)) {
            return null;
        }
        try {
            String advertiserId = getAdvertiserId(context);
            if (TextUtils.isEmpty(advertiserId)) {
                advertiserId = this.c.M(context);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 1);
            }
            String str2 = advertiserId;
            IronSourceSegment ironSourceSegment = this.C;
            String sendPostRequest = HttpFunctions.sendPostRequest(ServerURL.buildInitURL(context, k(), str, str2, n(), this.X, ironSourceSegment != null ? ironSourceSegment.getSegmentData() : null, z()), C2991a9.a().toString(), cVar);
            if (sendPostRequest == null) {
                IronLog.INTERNAL.warning("serverResponseString is null");
                return null;
            }
            if (IronSourceUtils.isEncryptedResponse()) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("encrypt");
                JSONObject jSONObject = new JSONObject(sendPostRequest);
                String optString = jSONObject.optString(C3337ue.n, null);
                if (TextUtils.isEmpty(optString)) {
                    ironLog.warning("encryptedResponse is empty - return null");
                    return null;
                }
                sendPostRequest = a(optString, Boolean.valueOf(jSONObject.optBoolean("compression", false)));
                if (TextUtils.isEmpty(sendPostRequest)) {
                    ironLog.warning("encoded response invalid - return null");
                    S();
                    return null;
                }
            }
            C3337ue c3337ue2 = new C3337ue(context, k(), str, sendPostRequest);
            try {
                c3337ue2.a(C3337ue.a.SERVER);
                if (c3337ue2.p()) {
                    return c3337ue2;
                }
                IronLog.INTERNAL.warning("response invalid - return null");
                return null;
            } catch (Exception e) {
                exc = e;
                c3337ue = c3337ue2;
                C3260q4.d().a(exc);
                IronLog.INTERNAL.warning("exception = " + exc);
                return c3337ue;
            }
        } catch (Exception e2) {
            exc = e2;
        }
    }

    private String a(String str, Boolean bool) {
        if (bool.booleanValue()) {
            return IronSourceAES.decryptAndDecompress(C3193m5.b().c(), str);
        }
        return IronSourceAES.decode(C3193m5.b().c(), str);
    }

    private void a(C3337ue c3337ue, Context context) {
        boolean l = v() ? c3337ue.c().b().b().l() : false;
        boolean l2 = J() ? c3337ue.c().f().m().l() : false;
        boolean l3 = B() ? c3337ue.c().d().i().l() : false;
        boolean l4 = w() ? c3337ue.c().c().g().l() : false;
        boolean l5 = F() ? c3337ue.c().e().g().l() : false;
        Rc i = c3337ue.c().b().i();
        boolean i2 = i.i();
        if (l) {
            a((AbstractC3326u3) C3334ub.U().q(), c3337ue.c().b().b(), context, c3337ue, true);
        }
        if (l2) {
            a((AbstractC3326u3) Id.i(), c3337ue.c().f().m(), context, c3337ue, true);
        } else {
            Id.i().a(false);
        }
        if (l3) {
            a((AbstractC3326u3) C3400y9.i(), c3337ue.c().d().i(), context, c3337ue, true);
        } else if (l4) {
            a((AbstractC3326u3) C3400y9.i(), c3337ue.c().c().g(), context, c3337ue, true);
        } else if (l5) {
            a((AbstractC3326u3) C3400y9.i(), c3337ue.c().e().g(), context, c3337ue, true);
        } else {
            C3400y9.i().a(false);
        }
        Qc qc = Qc.P;
        qc.a(i2);
        if (i2) {
            qc.b(i.j(), context);
            qc.b(i.l(), context);
            qc.c(i.k(), context);
            qc.b(i.g());
            qc.c(i.h());
        }
    }

    private void a(AbstractC3326u3 abstractC3326u3, H1 h1, Context context, C3337ue c3337ue, boolean z) {
        abstractC3326u3.a(z);
        abstractC3326u3.a(h1.c(), context);
        abstractC3326u3.b(h1.d(), context);
        abstractC3326u3.a(h1.f());
        abstractC3326u3.d(h1.e());
        abstractC3326u3.b(h1.a());
        abstractC3326u3.b(h1.i(), context);
        abstractC3326u3.c(h1.h(), context);
        abstractC3326u3.a(h1.j(), context);
        abstractC3326u3.d(h1.g(), context);
        abstractC3326u3.a(c3337ue.c().b().j());
        abstractC3326u3.b(h1.k());
        abstractC3326u3.c(h1.b());
    }

    private void a(String str, T3 t3) {
        if (a(str, 1, 128)) {
            return;
        }
        t3.a(ErrorBuilder.buildInvalidKeyValueError(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, "dynamicUserId is invalid, should be between 1-128 chars in length."));
    }

    private boolean a(String str, int i, int i2) {
        return str != null && str.length() >= i && str.length() <= i2;
    }

    boolean a(C3124i3 c3124i3) {
        return this.e.c(ContextProvider.getInstance().getApplicationContext(), c3124i3, IronSource.AD_UNIT.BANNER);
    }

    Wc.b a(InterstitialPlacement interstitialPlacement) {
        return this.e.a(ContextProvider.getInstance().getApplicationContext(), interstitialPlacement, IronSource.AD_UNIT.INTERSTITIAL);
    }

    Wc.b a(Placement placement) {
        return this.e.a(ContextProvider.getInstance().getApplicationContext(), placement, IronSource.AD_UNIT.REWARDED_VIDEO);
    }

    private void a(A5 a5, JSONObject jSONObject) {
        C3400y9.i().a(new C3413z5(a5, jSONObject));
    }

    private void a(boolean z, String str) {
        if (z) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(this.F, true, this.c0);
            if (str != null) {
                a(mediationAdditionalData, new Object[][]{new Object[]{"placement", str}});
            }
            b(A5.RV_API_IS_CAPPED_TRUE, mediationAdditionalData);
        }
    }

    String a(String str, Wc.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = b.c[bVar.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return "placement " + str + " is capped";
        }
        return null;
    }

    void a(SegmentListener segmentListener) {
        C3098gb c3098gb = this.i;
        if (c3098gb != null) {
            c3098gb.a(segmentListener);
            s.c().a(this.i);
        }
    }

    HashSet<String> a(String str, String str2) {
        C3337ue c3337ue = this.m;
        return c3337ue == null ? new HashSet<>() : c3337ue.k().a(str, str2);
    }

    public void a(boolean z) {
        this.O = Boolean.valueOf(z);
        com.ironsource.mediationsdk.c.b().b(z);
        this.k0.a(z);
        C3334ub.U().q().a(new C3413z5(z ? A5.CONSENT_TRUE_CODE : A5.CONSENT_FALSE_CODE, IronSourceUtils.getMediationAdditionalData(false)));
    }

    private void a(JSONObject jSONObject, Object[][] objArr) {
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    jSONObject.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "IronSourceObject addToDictionary: " + Log.getStackTraceString(e), 3);
            }
        }
    }

    public void a(String str, List<String> list) {
        String checkMetaDataKeyValidity = MetaDataUtils.checkMetaDataKeyValidity(str);
        String checkMetaDataValueValidity = MetaDataUtils.checkMetaDataValueValidity(list);
        if (checkMetaDataKeyValidity.length() > 0) {
            IronLog.API.verbose(checkMetaDataKeyValidity);
            return;
        }
        if (checkMetaDataValueValidity.length() > 0) {
            IronLog.API.verbose(checkMetaDataValueValidity);
            return;
        }
        MetaData formatMetaData = MetaDataUtils.formatMetaData(str, list);
        String metaDataKey = formatMetaData.getMetaDataKey();
        List<String> metaDataValue = formatMetaData.getMetaDataValue();
        if (MetaDataUtils.isMediationOnlyKey(metaDataKey)) {
            if (A() && MetaDataUtils.isMediationKeysBeforeInit(metaDataKey)) {
                IronLog.API.error("setMetaData with key = " + metaDataKey + " must to be called before init");
            } else {
                Z9.b().a(metaDataKey, metaDataValue);
            }
        } else {
            com.ironsource.mediationsdk.c.b().c(metaDataKey, metaDataValue);
        }
        try {
            ConcurrentHashMap<String, List<String>> d2 = com.ironsource.mediationsdk.c.b().d();
            d2.putAll(Z9.b().c());
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, List<String>> entry : d2.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            this.l0.a(jSONObject);
            this.k0.a(jSONObject);
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error("got the following error " + e.getMessage());
        }
        C3334ub.U().q().a(new C3413z5(A() ? A5.SET_META_DATA_AFTER_INIT : A5.SET_META_DATA, IronSourceUtils.getJsonForMetaData(str, list, metaDataValue)));
    }

    @Override // com.ironsource.S4
    public String a(Context context) {
        String str;
        EnumC3135ie enumC3135ie;
        String str2;
        String encrypt;
        Kf k;
        T4 h = h();
        EnumC3135ie enumC3135ie2 = null;
        try {
            enumC3135ie = C3151je.f3381a.a();
        } catch (Exception unused) {
            str = null;
        }
        try {
            h.a(A5.TROUBLESHOOTING_DO_GET_BIDDING_DATA_CALLED_IN_INIT_STATUS, enumC3135ie);
        } catch (Exception unused2) {
            str = null;
            enumC3135ie2 = enumC3135ie;
            h.a(A5.TROUBLESHOOTING_DO_GET_BIDDING_DATA_ENRICH_TOKEN_ERROR, enumC3135ie2);
            enumC3135ie = enumC3135ie2;
            str2 = str;
            h.a(A5.TROUBLESHOOTING_DO_GET_BIDDING_DATA_CALLED_TOKEN_RETURNED, enumC3135ie);
            return str2;
        }
        if (context == null) {
            IronLog.API.error("bidding data cannot be retrieved, context required");
            h.a(A5.TROUBLESHOOTING_DO_GET_BIDDING_DATA_CALLED_WITHOUT_CONTEXT, (EnumC3135ie) null);
            return null;
        }
        if (enumC3135ie == EnumC3135ie.NOT_INIT) {
            IronLog.API.error("bidding data cannot be retrieved, SDK not initialized");
            h.a(A5.TROUBLESHOOTING_DO_GET_BIDDING_DATA_NO_INIT_RETURNED_NULL, (EnumC3135ie) null);
            return null;
        }
        s.c().g();
        C3337ue c3337ue = this.m;
        boolean e = (c3337ue == null || (k = c3337ue.c().b().k()) == null) ? true : k.e();
        this.k0.b(context);
        JSONObject a2 = new Jf().a(context);
        com.ironsource.mediationsdk.d.b().a(a2, true);
        if (e) {
            encrypt = IronSourceAES.compressAndEncrypt(a2.toString());
        } else {
            encrypt = IronSourceAES.encrypt(a2.toString());
        }
        str2 = encrypt;
        if (TextUtils.isEmpty(str2)) {
            h.a(A5.TROUBLESHOOTING_DO_GET_BIDDING_DATA_RETURNED_NULL, enumC3135ie);
        }
        h.a(A5.TROUBLESHOOTING_DO_GET_BIDDING_DATA_CALLED_TOKEN_RETURNED, enumC3135ie);
        return str2;
    }

    @Override // com.ironsource.T8
    public void a(ImpressionDataListener impressionDataListener) {
        if (O9.a((Object) impressionDataListener, "removeImpressionDataListener - listener is null")) {
            Z9.b().b(impressionDataListener);
            N7 n7 = this.P;
            if (n7 != null) {
                n7.a(impressionDataListener);
            }
            w wVar = this.Q;
            if (wVar != null) {
                wVar.a(impressionDataListener);
            }
        }
    }

    public void a(String str, JSONObject jSONObject) {
        if (O9.a((Object) jSONObject, "setAdRevenueData - impressionData is null") && O9.a((Object) str, "setAdRevenueData - dataSource is null")) {
            this.j0.a(str, jSONObject);
        }
    }

    public void a(IronSource.AD_UNIT ad_unit, C3203mf c3203mf) {
        H2 h2;
        Dd dd;
        C3281r9 c3281r9;
        if (this.m0) {
            if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL && (c3281r9 = this.R) != null) {
                c3281r9.a(c3203mf);
            }
            if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO && (dd = this.S) != null) {
                dd.a(c3203mf);
            }
            if (ad_unit != IronSource.AD_UNIT.BANNER || (h2 = this.T) == null) {
                return;
            }
            h2.a(c3203mf);
        }
    }

    public void a(IronSource.AD_UNIT ad_unit, WaterfallConfiguration waterfallConfiguration) {
        if (ad_unit == null) {
            IronLog.API.error("AdUnit should not be null.");
            return;
        }
        IronLog.API.info(String.format("(%s, %s)", ad_unit.name(), waterfallConfiguration == null ? "NULL" : waterfallConfiguration.toString()));
        C3413z5 c3413z5 = new C3413z5(A5.SET_WATERFALL_CONFIGURATION, IronSourceUtils.getMediationAdditionalData(false));
        c3413z5.a(IronSourceConstants.EVENTS_EXT1, waterfallConfiguration == null ? "" : waterfallConfiguration.toJsonString());
        C3334ub.U().q().a(c3413z5, ad_unit);
        this.k0.a(ad_unit, waterfallConfiguration);
    }
}
