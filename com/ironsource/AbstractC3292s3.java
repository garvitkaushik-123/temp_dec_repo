package com.ironsource;

import android.text.TextUtils;
import com.ironsource.D0;
import com.ironsource.J8;
import com.ironsource.Q0;
import com.ironsource.Ye;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.ironsource.s3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC3292s3<Listener extends Q0> implements NetworkInitializationListener, Ye.a, C0, AdapterAdListener, J8.b {

    /* renamed from: a, reason: collision with root package name */
    protected C3171l0 f3690a;
    protected Listener b;
    protected BaseAdAdapter<?, AdapterAdListener> c;
    protected D0 d;
    protected h e;
    protected Placement g;
    protected C3000b1 h;
    protected JSONObject i;
    protected String j;
    protected AdData k;
    protected Long l;
    protected C3126i5 m;
    private final C3207n2 o;
    private final InterfaceC3012bd p;
    private AtomicBoolean f = new AtomicBoolean(false);
    private Ye n = new Ye(TimeUnit.SECONDS.toMillis(s()));
    protected final Object q = new Object();

    /* renamed from: com.ironsource.s3$a */
    class a extends Pd {
        a() {
        }

        @Override // com.ironsource.Pd
        public void a() {
            AbstractC3292s3.this.L();
        }
    }

    /* renamed from: com.ironsource.s3$b */
    class b extends Pd {
        b() {
        }

        @Override // com.ironsource.Pd
        public void a() {
            AbstractC3292s3.this.K();
        }
    }

    /* renamed from: com.ironsource.s3$c */
    class c extends Pd {
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        c(int i, String str) {
            this.b = i;
            this.c = str;
        }

        @Override // com.ironsource.Pd
        public void a() {
            AbstractC3292s3.this.a(this.b, this.c);
        }
    }

    /* renamed from: com.ironsource.s3$d */
    class d extends Pd {
        d() {
        }

        @Override // com.ironsource.Pd
        public void a() {
            AbstractC3292s3.this.I();
        }
    }

    /* renamed from: com.ironsource.s3$e */
    class e extends Pd {
        final /* synthetic */ AdapterErrorType b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;

        e(AdapterErrorType adapterErrorType, int i, String str) {
            this.b = adapterErrorType;
            this.c = i;
            this.d = str;
        }

        @Override // com.ironsource.Pd
        public void a() {
            AbstractC3292s3.this.a(this.b, this.c, this.d);
        }
    }

    /* renamed from: com.ironsource.s3$f */
    class f extends Pd {
        f() {
        }

        @Override // com.ironsource.Pd
        public void a() {
            AbstractC3292s3.this.J();
        }
    }

    /* renamed from: com.ironsource.s3$g */
    class g extends Pd {
        g() {
        }

        @Override // com.ironsource.Pd
        public void a() {
            AbstractC3292s3.this.H();
        }
    }

    /* renamed from: com.ironsource.s3$h */
    protected enum h {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        SHOWING,
        FAILED
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC3292s3(InterfaceC3012bd interfaceC3012bd, C3171l0 c3171l0, BaseAdAdapter<?, ?> baseAdAdapter, C3000b1 c3000b1, C3207n2 c3207n2, Listener listener) {
        this.f3690a = c3171l0;
        this.b = listener;
        this.d = new D0(c3171l0.a(), D0.b.PROVIDER, this);
        this.h = c3000b1;
        this.i = c3000b1.c();
        this.c = baseAdAdapter;
        this.o = c3207n2;
        this.p = interfaceC3012bd;
        a(h.NONE);
    }

    private boolean D() {
        return this.e == h.INIT_IN_PROGRESS;
    }

    private void F() {
        IronLog.INTERNAL.verbose(d());
        a(h.LOADING);
        a(false);
        try {
            this.n.a((Ye.a) this);
            G();
        } catch (Throwable th) {
            C3260q4.d().a(th);
            String str = "unexpected error while calling adapter.loadAd() - " + th.getMessage() + " - state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            D0 d0 = this.d;
            if (d0 != null) {
                d0.j.g(str);
            }
            onAdLoadFailed(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, 510, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        IronLog.INTERNAL.verbose(d());
        D0 d0 = this.d;
        if (d0 != null) {
            d0.i.a(j());
        }
        this.b.e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        boolean z;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        Ye ye = this.n;
        if (ye != null) {
            ye.e();
        }
        synchronized (this.q) {
            h hVar = this.e;
            z = false;
            if (hVar == h.LOADING) {
                long a2 = C3126i5.a(this.m);
                ironLog.verbose(a("Load duration = " + a2));
                if (this.d != null) {
                    if (v()) {
                        this.d.f.a(a2);
                    } else {
                        this.d.f.a(a2, false);
                    }
                }
                a(h.LOADED);
                z = O();
            } else if (hVar != h.FAILED) {
                ironLog.error(a(String.format("unexpected load success for %s, state - %s", k(), this.e)));
                String format = String.format("unexpected load success, state - %s", this.e);
                if (this.d != null) {
                    if (v()) {
                        this.d.j.s(format);
                    } else {
                        this.d.j.p(format);
                    }
                }
            }
        }
        if (z) {
            this.b.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        IronLog.INTERNAL.verbose(d());
        a(h.SHOWING);
        D0 d0 = this.d;
        if (d0 != null) {
            d0.i.g(j());
        }
        this.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        if (D()) {
            Ye ye = this.n;
            if (ye != null) {
                ye.e();
            }
            a(h.READY_TO_LOAD);
            F();
            return;
        }
        if (this.e == h.FAILED) {
            return;
        }
        ironLog.error(a(String.format("unexpected init success for %s, state - %s", k(), this.e)));
        if (this.d != null) {
            this.d.j.n(String.format("unexpected init success, state - %s", this.e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        long a2 = C3126i5.a(this.m);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("Load duration = " + a2 + ", state = " + this.e + ", isBidder = " + w()));
        synchronized (this.q) {
            if (!z()) {
                ironLog.error(a(String.format("unexpected timeout for %s, state - %s, error - %s", k(), this.e, 1025)));
                if (this.d != null) {
                    this.d.j.u(String.format("unexpected timeout, state - %s, error - %s", this.e, 1025));
                }
                return;
            }
            a(h.FAILED);
            D0 d0 = this.d;
            if (d0 != null) {
                d0.f.a(a2, 1025, false);
                this.d.f.a(a2, 1025, "time out", false);
            }
            this.b.a(ErrorBuilder.buildLoadFailedError("time out"), this);
        }
    }

    private int o() {
        return 1;
    }

    private int s() {
        C3207n2 c3207n2 = this.o;
        if (c3207n2 == null) {
            return this.f3690a.f();
        }
        Integer f2 = c3207n2.f();
        int f3 = (f2 == null || f2.intValue() <= 0) ? this.f3690a.f() : f2.intValue();
        IronLog.INTERNAL.verbose(a("Load timeout for " + this.o.c() + " - " + f3 + " seconds"));
        return f3;
    }

    public AtomicBoolean A() {
        return this.f;
    }

    public boolean B() {
        return y();
    }

    public boolean C() {
        return this.e == h.SHOWING;
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface] */
    public void E() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        C3207n2 i = i();
        String k = i.k();
        Map<String, Object> a2 = V9.a(i.a());
        a2.put("adUnit", this.f3690a.a());
        b(k);
        try {
            boolean z = false;
            if (v()) {
                this.d.f.a();
            } else {
                this.d.f.a(false);
            }
            this.l = null;
            this.m = new C3126i5();
            this.k = a(k, a2);
            synchronized (this.q) {
                if (this.e != h.NONE) {
                    z = true;
                } else {
                    a(h.INIT_IN_PROGRESS);
                }
            }
            if (z) {
                String str = "loadAd - incorrect state while loading, state = " + this.e;
                ironLog.error(a(str));
                this.d.j.g(str);
                onInitFailed(C3408z0.c(this.f3690a.a()), str);
                return;
            }
            this.n.a((Ye.a) this);
            ?? networkAdapter = this.c.getNetworkAdapter();
            if (networkAdapter != 0) {
                networkAdapter.init(this.k, ContextProvider.getInstance().getApplicationContext(), this);
                return;
            }
            String str2 = "loadAd - network adapter not available " + k();
            ironLog.error(a(str2));
            onInitFailed(C3408z0.c(this.f3690a.a()), str2);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            String str3 = "loadAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str3));
            D0 d0 = this.d;
            if (d0 != null) {
                d0.j.g(str3);
            }
            onInitFailed(C3408z0.c(this.f3690a.a()), str3);
        }
    }

    protected void G() {
        Object obj = this.c;
        if (obj instanceof AdapterAdFullScreenInterface) {
            ((AdapterAdFullScreenInterface) obj).loadAd(this.k, ContextProvider.getInstance().getCurrentActiveActivity(), this);
        } else {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterAdFullScreenInterface"));
        }
    }

    public void M() {
        synchronized (this) {
            BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.c;
            if (baseAdAdapter != null) {
                try {
                    baseAdAdapter.releaseMemory();
                    this.c = null;
                } catch (Exception e2) {
                    C3260q4.d().a(e2);
                    String str = "Exception while calling adapter.releaseMemory() from " + this.h.f() + " - " + e2.getMessage() + " - state = " + this.e;
                    IronLog.INTERNAL.error(a(str));
                    D0 d0 = this.d;
                    if (d0 != null) {
                        d0.j.g(str);
                    }
                }
            }
            D0 d02 = this.d;
            if (d02 != null) {
                d02.f();
                this.d = null;
            }
            Ye ye = this.n;
            if (ye != null) {
                ye.d();
                this.n = null;
            }
        }
    }

    public void N() {
        IronLog.INTERNAL.verbose(d());
        D0 d0 = this.d;
        if (d0 != null) {
            d0.i.a();
        }
    }

    protected boolean O() {
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v16, types: [com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface] */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface] */
    public Map<String, Object> a(A0 a0) {
        HashMap hashMap = new HashMap();
        try {
            BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.c;
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, baseAdAdapter != null ? baseAdAdapter.getNetworkAdapter().getAdapterVersion() : "");
            BaseAdAdapter<?, AdapterAdListener> baseAdAdapter2 = this.c;
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, baseAdAdapter2 != null ? baseAdAdapter2.getNetworkAdapter().getNetworkSDKVersion() : "");
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(a("could not get adapter version for event data" + k()));
        }
        hashMap.put("spId", this.h.i());
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, this.h.a());
        hashMap.put("instanceType", Integer.valueOf(l()));
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(o()));
        if (!TextUtils.isEmpty(this.j)) {
            hashMap.put("dynamicDemandSource", this.j);
        }
        hashMap.put("sessionDepth", r());
        if (this.f3690a.e() != null && this.f3690a.e().length() > 0) {
            hashMap.put("genericParams", this.f3690a.e());
        }
        if (!TextUtils.isEmpty(this.f3690a.c())) {
            hashMap.put("auctionId", this.f3690a.c());
        }
        if (b(a0)) {
            hashMap.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(this.f3690a.d()));
            if (!TextUtils.isEmpty(this.f3690a.b())) {
                hashMap.put(IronSourceConstants.AUCTION_FALLBACK, this.f3690a.b());
            }
        }
        if (!TextUtils.isEmpty(this.f3690a.g().getCustomNetwork())) {
            hashMap.put(IronSourceConstants.EVENTS_CUSTOM_NETWORK_FIELD, this.f3690a.g().getCustomNetwork());
        }
        return hashMap;
    }

    public void b(String str) {
        this.j = com.ironsource.mediationsdk.d.b().c(str);
    }

    @Override // com.ironsource.J8.b
    public String c() {
        return this.h.f();
    }

    protected String d() {
        return a((String) null);
    }

    public Long e() {
        return this.l;
    }

    public AdInfo f() {
        return new AdInfo(this.o.a(j()), this.o.d());
    }

    public IronSource.AD_UNIT g() {
        return this.f3690a.a();
    }

    public String h() {
        return this.f3690a.c();
    }

    public C3207n2 i() {
        return this.o;
    }

    protected String j() {
        Placement placement = this.g;
        return placement == null ? "" : placement.getPlacementName();
    }

    public String k() {
        return String.format("%s %s", c(), Integer.valueOf(hashCode()));
    }

    public int l() {
        return this.h.d();
    }

    public String m() {
        return this.h.h().isMultipleInstances() ? this.h.h().getProviderTypeForReflection() : this.h.f();
    }

    public String n() {
        return this.h.g();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdClicked() {
        if (this.p.e()) {
            this.p.a(new g());
        } else {
            H();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdLoadFailed(AdapterErrorType adapterErrorType, int i, String str) {
        if (this.p.e()) {
            this.p.a(new e(adapterErrorType, i, str));
        } else {
            a(adapterErrorType, i, str);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdLoadSuccess() {
        if (this.p.e()) {
            this.p.a(new d());
        } else {
            I();
        }
    }

    public void onAdOpened() {
        if (this.p.e()) {
            this.p.a(new f());
        } else {
            J();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
    public void onInitFailed(int i, String str) {
        if (this.p.e()) {
            this.p.a(new c(i, str));
        } else {
            a(i, str);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
    public void onInitSuccess() {
        if (this.p.e()) {
            this.p.a(new b());
        } else {
            K();
        }
    }

    public NetworkSettings p() {
        return this.f3690a.g();
    }

    protected Map<String, Object> q() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(V9.a(this.i));
        return hashMap;
    }

    public Integer r() {
        C3171l0 c3171l0 = this.f3690a;
        if (c3171l0 != null) {
            return Integer.valueOf(c3171l0.h());
        }
        return null;
    }

    public h t() {
        return this.e;
    }

    protected InterfaceC3012bd u() {
        return this.p;
    }

    protected boolean v() {
        return false;
    }

    public boolean w() {
        return this.h.j();
    }

    public boolean x() {
        return this.e == h.FAILED;
    }

    public boolean y() {
        return this.e == h.LOADED;
    }

    public boolean z() {
        h hVar = this.e;
        return hVar == h.INIT_IN_PROGRESS || hVar == h.LOADING;
    }

    @Override // com.ironsource.J8.b
    public int b() {
        return this.h.e();
    }

    private boolean b(A0 a0) {
        return new ArrayList(Arrays.asList(A0.LOAD_AD, A0.LOAD_AD_SUCCESS, A0.LOAD_AD_FAILED, A0.LOAD_AD_FAILED_WITH_REASON, A0.LOAD_AD_NO_FILL, A0.RELOAD_AD, A0.RELOAD_AD_SUCCESS, A0.RELOAD_AD_FAILED_WITH_REASON, A0.RELOAD_AD_NO_FILL, A0.DESTROY_AD, A0.AD_PRESENT_SCREEN, A0.AD_DISMISS_SCREEN, A0.AD_LEFT_APPLICATION, A0.AD_OPENED, A0.AD_CLOSED, A0.SHOW_AD, A0.SHOW_AD_FAILED, A0.AD_CLICKED, A0.AD_REWARDED)).contains(a0);
    }

    protected void a(h hVar) {
        IronLog.INTERNAL.verbose(d());
        this.e = hVar;
    }

    public void a(boolean z) {
        this.f.set(z);
    }

    protected Map<String, Object> a(Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("userId", this.f3690a.i());
        return map;
    }

    protected AdData a(String str, Map<String, Object> map) {
        return new AdData(str, q(), a(map));
    }

    protected String a(String str) {
        String str2 = this.f3690a.a().name() + " - " + k() + " - state = " + this.e;
        return TextUtils.isEmpty(str) ? str2 : str2 + " - " + str;
    }

    @Override // com.ironsource.Ye.a
    public void a() {
        if (!this.p.e()) {
            L();
        } else {
            this.p.a(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("error = " + i + ", " + str));
        if (D()) {
            Ye ye = this.n;
            if (ye != null) {
                ye.e();
            }
            a(h.FAILED);
            a(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, i, str, C3126i5.a(this.m));
            this.b.a(new IronSourceError(i, str), this);
            return;
        }
        if (this.e == h.FAILED) {
            return;
        }
        ironLog.error(a(String.format("unexpected init failed for %s, state - %s, error - %s, %s", k(), this.e, Integer.valueOf(i), str)));
        if (this.d != null) {
            this.d.j.m(String.format("unexpected init failed, state - %s, error - %s, %s", this.e, Integer.valueOf(i), str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdapterErrorType adapterErrorType, int i, String str) {
        long a2 = C3126i5.a(this.m);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("Load duration = " + a2 + ", error = " + i + ", " + str));
        Ye ye = this.n;
        if (ye != null) {
            ye.e();
        }
        synchronized (this.q) {
            try {
                try {
                    h hVar = this.e;
                    if (hVar == h.LOADING) {
                        a(adapterErrorType, i, str, a2);
                        a(h.FAILED);
                        this.b.a(new IronSourceError(i, str), this);
                        return;
                    }
                    if (hVar == h.FAILED) {
                        a(adapterErrorType, i, str, a2);
                        return;
                    }
                    if (hVar == h.LOADED && adapterErrorType == AdapterErrorType.ADAPTER_ERROR_TYPE_AD_EXPIRED) {
                        this.l = Long.valueOf(System.currentTimeMillis());
                        ironLog.error(a(String.format("ad expired for %s, state = %s", this.h.f(), this.e)));
                        D0 d0 = this.d;
                        if (d0 != null) {
                            d0.j.a(String.format("ad expired, state = %s", this.e));
                        }
                        return;
                    }
                    ironLog.error(a(String.format("unexpected load failed for %s, state - %s, error - %s, %s", k(), this.e, Integer.valueOf(i), str)));
                    String format = String.format("unexpected load failed, state - %s, error - %s, %s", this.e, Integer.valueOf(i), str);
                    if (this.d != null) {
                        if (v()) {
                            this.d.j.r(format);
                        } else if (this.f3690a.a() != IronSource.AD_UNIT.REWARDED_VIDEO || this.e != h.SHOWING) {
                            this.d.j.o(format);
                        }
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
    }

    private void a(AdapterErrorType adapterErrorType, int i, String str, long j) {
        if (this.d != null) {
            if (adapterErrorType == AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL) {
                if (v()) {
                    this.d.f.b(j, i);
                    return;
                } else {
                    this.d.f.a(j, i);
                    return;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                if (v()) {
                    this.d.f.a(j, i, str);
                    return;
                } else {
                    this.d.f.a(j, i, str, false);
                    return;
                }
            }
            this.d.f.a(j, i, false);
        }
    }
}
