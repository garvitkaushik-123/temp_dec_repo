package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.a6;
import com.applovin.impl.b6;
import com.applovin.impl.c2;
import com.applovin.impl.c7;
import com.applovin.impl.d1;
import com.applovin.impl.e1;
import com.applovin.impl.e8;
import com.applovin.impl.g4;
import com.applovin.impl.g5;
import com.applovin.impl.h3;
import com.applovin.impl.i1;
import com.applovin.impl.i3;
import com.applovin.impl.i7;
import com.applovin.impl.i8;
import com.applovin.impl.j2;
import com.applovin.impl.j7;
import com.applovin.impl.k7;
import com.applovin.impl.m3;
import com.applovin.impl.mediation.MaxSegmentCollectionImpl;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.o3;
import com.applovin.impl.o4;
import com.applovin.impl.p6;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.q0;
import com.applovin.impl.q1;
import com.applovin.impl.q2;
import com.applovin.impl.r0;
import com.applovin.impl.r3;
import com.applovin.impl.r5;
import com.applovin.impl.s3;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdService;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t0;
import com.applovin.impl.t3;
import com.applovin.impl.u4;
import com.applovin.impl.v3;
import com.applovin.impl.v4;
import com.applovin.impl.w2;
import com.applovin.impl.w4;
import com.applovin.impl.w6;
import com.applovin.impl.x4;
import com.applovin.impl.y4;
import com.applovin.impl.z3;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxSegmentCollection;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkInitializationConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class k {
    public static k D0;
    protected static Context E0;
    private static boolean F0;
    private static final boolean H0;
    private static volatile com.applovin.impl.c I0;
    private AppLovinSdk.SdkInitializationListener A0;

    /* renamed from: a, reason: collision with root package name */
    private String f695a;
    private String b;
    private WeakReference c;
    private final long d;
    private long e;
    private long f;
    private Long g;
    private long h;
    private final AppLovinSdkSettings j;
    private com.applovin.impl.mediation.e j0;
    private MaxSegmentCollection k;
    private String l;
    private List l0;
    private volatile AppLovinSdk q;
    private boolean q0;
    private String v0;
    private AppLovinSdkInitializationConfiguration w0;
    private AppLovinSdk.SdkInitializationListener z0;
    private static final Object J0 = new Object();
    private static final long G0 = System.currentTimeMillis();
    private final AtomicBoolean i = new AtomicBoolean();
    private final AtomicReference m = new AtomicReference();
    private final AtomicReference n = new AtomicReference();
    private final AtomicReference o = new AtomicReference();
    private final AtomicReference p = new AtomicReference();
    private final o r = new o(this);
    private final com.applovin.impl.f s = new com.applovin.impl.f(this);
    private final w2 t = new w2(this);
    private final q1 u = new q1(this);
    private final i7 v = new i7(this);
    private final AtomicReference w = new AtomicReference();
    private final AtomicReference x = new AtomicReference();
    private final AtomicReference y = new AtomicReference();
    private final AtomicReference z = new AtomicReference();
    private final AtomicReference A = new AtomicReference();
    private final AtomicReference B = new AtomicReference();
    private final AtomicReference C = new AtomicReference();
    private final AtomicReference D = new AtomicReference();
    private final AtomicReference E = new AtomicReference();
    private final AtomicReference F = new AtomicReference();
    private final AtomicReference G = new AtomicReference();
    private final AtomicReference H = new AtomicReference();
    private final AtomicReference I = new AtomicReference();
    private final AtomicReference J = new AtomicReference();
    private final AtomicReference K = new AtomicReference();
    private final AtomicReference L = new AtomicReference();
    private final AtomicReference M = new AtomicReference();
    private final AtomicReference N = new AtomicReference();
    private final AtomicReference O = new AtomicReference();
    private final AtomicReference P = new AtomicReference();
    private final AtomicReference Q = new AtomicReference();
    private final AtomicReference R = new AtomicReference();
    private final AtomicReference S = new AtomicReference();
    private final AtomicReference T = new AtomicReference();
    private final AtomicReference U = new AtomicReference();
    private final AtomicReference V = new AtomicReference();
    private final AtomicReference W = new AtomicReference();
    private final AtomicReference X = new AtomicReference();
    private final AtomicReference Y = new AtomicReference();
    private final AtomicReference Z = new AtomicReference();
    private final AtomicReference a0 = new AtomicReference();
    private final AtomicReference b0 = new AtomicReference();
    private final AtomicReference c0 = new AtomicReference();
    private final AtomicReference d0 = new AtomicReference();
    private final AtomicReference e0 = new AtomicReference();
    private final AtomicReference f0 = new AtomicReference();
    private final AtomicReference g0 = new AtomicReference();
    private final AtomicReference h0 = new AtomicReference();
    private final AtomicReference i0 = new AtomicReference();
    private final AtomicReference k0 = new AtomicReference();
    private final Object m0 = new Object();
    private final AtomicBoolean n0 = new AtomicBoolean(true);
    private final AtomicBoolean o0 = new AtomicBoolean();
    private final AtomicBoolean p0 = new AtomicBoolean();
    private boolean r0 = false;
    private boolean s0 = false;
    private boolean t0 = false;
    private int u0 = 0;
    private final Object x0 = new Object();
    private SdkConfigurationImpl y0 = new SdkConfigurationImpl(this);
    private final g5 B0 = new p6(this, true, "scheduleAdLoadIntegrationError", new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda6
        @Override // java.lang.Runnable
        public final void run() {
            k.this.L0();
        }
    });
    private final g5 C0 = new p6(this, true, "sdkInit", new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda7
        @Override // java.lang.Runnable
        public final void run() {
            k.this.M0();
        }
    });

    class a implements r5.b {
        a() {
        }

        @Override // com.applovin.impl.r5.b
        public void a(JSONObject jSONObject) {
            boolean isValid = JsonUtils.isValid(jSONObject);
            k.this.c(jSONObject);
            if (((Boolean) k.this.a(o3.V7)).booleanValue()) {
                k kVar = k.this;
                kVar.j0 = new com.applovin.impl.mediation.e(kVar);
            }
            k.this.m().a();
            r0.a(jSONObject, isValid, k.this);
            Boolean bool = JsonUtils.getBoolean(jSONObject, "smd", Boolean.FALSE);
            k.this.U().a(bool.booleanValue(), JsonUtils.getInt(jSONObject, "smd_delay_sec", 2));
            k.this.E().b();
            k kVar2 = k.this;
            kVar2.l0 = kVar2.a(jSONObject);
            if (isValid) {
                k.this.y0.setEnabledAmazonAdUnitIds(CollectionUtils.explode(JsonUtils.getString(jSONObject, "eaaui", "")));
            }
            k.this.t0().a(jSONObject);
            k.this.b(jSONObject);
            q2.b(((Boolean) k.this.a(v4.k6)).booleanValue());
            q2.a(((Boolean) k.this.a(v4.l6)).booleanValue());
            k.this.R0();
            if (!((Boolean) k.this.a(v4.b3)).booleanValue() || isValid || !r0.a(k.o())) {
                k.this.P0();
                return;
            }
            k.this.O();
            if (o.a()) {
                k.this.O().d("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
            }
            k.this.U0();
        }
    }

    class b implements t0.c {
        b() {
        }

        @Override // com.applovin.impl.t0.c
        public void a(t0.b bVar) {
            k.this.O();
            if (o.a()) {
                k.this.O().a("AppLovinSdk", "Terms and Privacy Policy flow completed with status: " + bVar);
            }
            k.this.p0.set(bVar.b());
            if (!bVar.a()) {
                k.this.c("Initializing SDK in MAX environment...");
                return;
            }
            k.this.O();
            if (o.a()) {
                k.this.O().a("AppLovinSdk", "Re-initializing SDK with the updated privacy settings...");
            }
            k.this.T0();
            k.this.S0();
        }
    }

    class c implements r5.b {
        c() {
        }

        @Override // com.applovin.impl.r5.b
        public void a(JSONObject jSONObject) {
            k.this.c(jSONObject);
            k.this.i.set(false);
            k.this.P0();
        }
    }

    class d implements v3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v3 f699a;

        d(v3 v3Var) {
            this.f699a = v3Var;
        }

        @Override // com.applovin.impl.v3.a
        public void a() {
            k.this.O();
            if (o.a()) {
                k.this.O().d("AppLovinSdk", "Connected to internet - re-initializing SDK");
            }
            synchronized (k.this.m0) {
                if (!k.this.q0) {
                    k.this.T0();
                }
            }
            this.f699a.b(this);
        }

        @Override // com.applovin.impl.v3.a
        public void b() {
        }
    }

    static {
        try {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    k7.c();
                }
            });
            H0 = true;
        } catch (Throwable unused) {
            H0 = false;
        }
    }

    public k(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        this.q0 = false;
        D0 = this;
        this.j = appLovinSdkSettings;
        this.d = System.currentTimeMillis();
        this.q0 = true;
        if (!G0()) {
            throw new RuntimeException("As of version 12.0.0, the AppLovin MAX SDK requires Java 8. For more information visit our docs: https://developers.applovin.com/en/android/overview/integration");
        }
        E0 = context.getApplicationContext();
        if (context instanceof Activity) {
            this.c = new WeakReference((Activity) context);
        }
    }

    private void B0() {
        Context context = E0;
        o O = O();
        y4 q0 = q0();
        t0 y = y();
        a(context);
        n0();
        j();
        p();
        c0();
        S().a(MaxAdapter.InitializationStatus.INITIALIZING);
        NativeCrashReporter.a(this);
        String str = this.f695a;
        if (str == null || str.length() != 86) {
            o.h("AppLovinSdk", "SDK key provided is invalid (" + this.f695a + "). Expected length: 86 characters.\n\nStack trace:\n" + Log.getStackTraceString(new Throwable()));
        }
        if (StringUtils.isValidString(this.b) && this.b.length() != 36) {
            String str2 = "Axon event key length " + this.b + " is invalid - expected 36";
            if (k7.c(this)) {
                throw new IllegalArgumentException(str2);
            }
            o.h("AppLovinSdk", str2);
        }
        if (y.l()) {
            String str3 = "Terms Flow has been replaced. " + y.g();
            if (k7.c(this)) {
                throw new IllegalStateException(str3);
            }
            o.h("AppLovinSdk", str3);
        }
        if (k7.i()) {
            o.h("AppLovinSdk", "Failed to find class for name: com.applovin.sdk.AppLovinSdk. Please ensure proguard rules have not been omitted from the build.");
        }
        if (!k7.b(this)) {
            o.h("AppLovinSdk", "Detected non-Android core JSON library. Please double-check that none of your third party libraries include custom implementation of org.json.JSONObject.");
        }
        if (k7.m(context)) {
            this.j.setVerboseLogging(true);
        }
        p0().a(v4.k, Boolean.valueOf(this.j.isVerboseLoggingEnabled()));
        t3.e(this);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        x4 x4Var = x4.c;
        if (TextUtils.isEmpty((String) q0.a(x4Var, (Object) null, defaultSharedPreferences))) {
            this.s0 = true;
            q0.b(x4Var, Boolean.toString(true), defaultSharedPreferences);
        } else {
            q0.b(x4Var, Boolean.toString(false), defaultSharedPreferences);
        }
        x4 x4Var2 = x4.d;
        if (((Boolean) q0.a(x4Var2, Boolean.FALSE)).booleanValue()) {
            if (o.a()) {
                O.a("AppLovinSdk", "Initializing SDK for non-maiden launch");
            }
            this.t0 = true;
        } else {
            if (o.a()) {
                O.a("AppLovinSdk", "Initializing SDK for maiden launch");
            }
            q0.b(x4Var2, Boolean.TRUE);
            q0.b(x4.s, Boolean.valueOf(y.j()));
        }
        x4 x4Var3 = x4.e;
        this.f = ((Long) q0.a(x4Var3, 0L)).longValue() + 1;
        q0().b(x4Var3, Long.valueOf(this.f));
        x4 x4Var4 = x4.f;
        this.g = (Long) q0.a(x4Var4, null);
        q0().b(x4Var4, Long.valueOf(G0));
        x4 x4Var5 = x4.g;
        String str4 = (String) q0.a(x4Var5, null);
        if (StringUtils.isValidString(str4)) {
            if (AppLovinSdk.VERSION_CODE > k7.g(str4)) {
                q0.b(x4Var5, AppLovinSdk.VERSION);
            }
        } else {
            q0.b(x4Var5, AppLovinSdk.VERSION);
        }
        w0().d(c2.e, CollectionUtils.map("details", "isInitProviderContextSet=" + F0));
    }

    public static boolean G0() {
        return H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0() {
        if (r0().g()) {
            return;
        }
        O();
        if (o.a()) {
            O().a("AppLovinSdk", "Timing out adapters init...");
        }
        r0().h();
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0() {
        b6 r0 = r0();
        int i = this.u0 + 1;
        this.u0 = i;
        r0.a((g5) new r5(i, this, new c()), b6.b.CORE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0() {
        if (H0()) {
            j2.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0() {
        synchronized (this.m0) {
            boolean a2 = r0.a(o());
            if (!H0()) {
                O();
                if (o.a()) {
                    O().a("AppLovinSdk", "non-MAX mediation detected, mediation provider is: " + V());
                }
            }
            if (!((Boolean) a(v4.c3)).booleanValue() || a2) {
                T0();
            }
            if (((Boolean) a(v4.b3)).booleanValue() && !a2) {
                O();
                if (o.a()) {
                    O().d("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
                }
                U0();
            }
        }
    }

    private r O0() {
        if (!o4.f(E0)) {
            return null;
        }
        try {
            return new r(this);
        } catch (Throwable th) {
            o.b("AppLovinSdk", "Failed to initialize Privacy Sandbox Service", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        Long l = (Long) a(v4.k3);
        if (l.longValue() >= 0 && this.i.compareAndSet(false, true)) {
            e8.a(l.longValue(), false, this, new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.K0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        if (!H0()) {
            c("Initializing SDK in non-MAX environment...");
            return;
        }
        if (!this.o0.compareAndSet(false, true)) {
            c("Consent flow is already shown. Initializing SDK in MAX environment...");
        } else if (!y().j()) {
            c("Consent flow is not enabled. Initializing SDK in MAX environment...");
        } else {
            y().a(v0(), new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        v3 c0 = c0();
        c0.a(new d(c0));
    }

    private Map W() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) a(v4.f4)));
        } catch (JSONException unused) {
            return Collections.emptyMap();
        }
    }

    public static long n() {
        return G0;
    }

    public static Context o() {
        return E0;
    }

    public e1 A() {
        Object obj = this.V.get();
        if (obj == null) {
            synchronized (this.V) {
                obj = this.V.get();
                if (obj == null) {
                    obj = new e1(this);
                    this.V.set(obj);
                }
            }
        }
        if (obj == this.V) {
            obj = null;
        }
        return (e1) obj;
    }

    public boolean A0() {
        return this.t0;
    }

    public l B() {
        Object obj = this.A.get();
        if (obj == null) {
            synchronized (this.A) {
                obj = this.A.get();
                if (obj == null) {
                    obj = new l(this);
                    this.A.set(obj);
                }
            }
        }
        if (obj == this.A) {
            obj = null;
        }
        return (l) obj;
    }

    public i1 C() {
        Object obj = this.E.get();
        if (obj == null) {
            synchronized (this.E) {
                obj = this.E.get();
                if (obj == null) {
                    obj = new i1(this);
                    this.E.set(obj);
                }
            }
        }
        if (obj == this.E) {
            obj = null;
        }
        return (i1) obj;
    }

    public boolean C0() {
        boolean z;
        synchronized (this.m0) {
            z = this.r0;
        }
        return z;
    }

    public String D() {
        return this.v0;
    }

    public boolean D0() {
        return this.s0;
    }

    public q1 E() {
        return this.u;
    }

    public boolean E0() {
        boolean z;
        synchronized (this.x0) {
            z = this.w0 != null;
        }
        return z;
    }

    public String F() {
        return x0().d();
    }

    public boolean F0() {
        boolean z;
        synchronized (this.m0) {
            z = this.q0;
        }
        return z;
    }

    public EventServiceImpl G() {
        Object obj = this.o.get();
        if (obj == null) {
            synchronized (this.o) {
                obj = this.o.get();
                if (obj == null) {
                    obj = new EventServiceImpl(this);
                    this.o.set(obj);
                }
            }
        }
        if (obj == this.o) {
            obj = null;
        }
        return (EventServiceImpl) obj;
    }

    public m H() {
        Object obj = this.H.get();
        if (obj == null) {
            synchronized (this.H) {
                obj = this.H.get();
                if (obj == null) {
                    obj = new m(this);
                    this.H.set(obj);
                }
            }
        }
        if (obj == this.H) {
            obj = null;
        }
        return (m) obj;
    }

    public boolean H0() {
        return StringUtils.containsIgnoreCase(V(), "max");
    }

    public n I() {
        Object obj = this.J.get();
        if (obj == null) {
            synchronized (this.J) {
                obj = this.J.get();
                if (obj == null) {
                    obj = new n(this);
                    this.J.set(obj);
                }
            }
        }
        if (obj == this.J) {
            obj = null;
        }
        return (n) obj;
    }

    public boolean I0() {
        return k7.a("com.unity3d.player.UnityPlayerActivity");
    }

    public Activity J() {
        WeakReference weakReference;
        if (!((Boolean) a(v4.v4)).booleanValue() || (weakReference = this.c) == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public AppLovinSdkInitializationConfiguration K() {
        return this.w0;
    }

    public long L() {
        return this.d;
    }

    public Long M() {
        return this.g;
    }

    public long N() {
        return this.f;
    }

    protected void N0() {
        b(false);
    }

    public o O() {
        return this.r;
    }

    public w2 P() {
        return this.t;
    }

    public com.applovin.impl.mediation.d Q() {
        Object obj = this.i0.get();
        if (obj == null) {
            synchronized (this.i0) {
                obj = this.i0.get();
                if (obj == null) {
                    obj = new com.applovin.impl.mediation.d(this);
                    this.i0.set(obj);
                }
            }
        }
        if (obj == this.i0) {
            obj = null;
        }
        return (com.applovin.impl.mediation.d) obj;
    }

    public void Q0() {
        if (StringUtils.isValidString(this.l)) {
            return;
        }
        this.l = "max";
    }

    public com.applovin.impl.mediation.e R() {
        return this.j0;
    }

    public com.applovin.impl.mediation.f S() {
        Object obj = this.d0.get();
        if (obj == null) {
            synchronized (this.d0) {
                obj = this.d0.get();
                if (obj == null) {
                    obj = new com.applovin.impl.mediation.f(this);
                    this.d0.set(obj);
                }
            }
        }
        if (obj == this.d0) {
            obj = null;
        }
        return (com.applovin.impl.mediation.f) obj;
    }

    public void S0() {
        u().a();
    }

    public com.applovin.impl.mediation.g T() {
        Object obj = this.c0.get();
        if (obj == null) {
            synchronized (this.c0) {
                obj = this.c0.get();
                if (obj == null) {
                    obj = new com.applovin.impl.mediation.g(this);
                    this.c0.set(obj);
                }
            }
        }
        if (obj == this.c0) {
            obj = null;
        }
        return (com.applovin.impl.mediation.g) obj;
    }

    public void T0() {
        synchronized (this.m0) {
            this.q0 = true;
            r0().i();
            d();
        }
    }

    public m3 U() {
        Object obj = this.g0.get();
        if (obj == null) {
            synchronized (this.g0) {
                obj = this.g0.get();
                if (obj == null) {
                    obj = new m3(this);
                    this.g0.set(obj);
                }
            }
        }
        if (obj == this.g0) {
            obj = null;
        }
        return (m3) obj;
    }

    public String V() {
        return this.l;
    }

    public void V0() {
        o.h("AppLovinSdk", "Resetting SDK state...");
        p0().a();
        p0().e();
        if (this.n0.compareAndSet(true, false)) {
            T0();
        } else {
            this.n0.set(true);
        }
    }

    public void W0() {
        if (StringUtils.isValidString(this.v0)) {
            return;
        }
        this.v0 = "max";
        O();
        if (o.a()) {
            O().a("AppLovinSdk", "Detected mediation provider: MAX");
        }
    }

    public MediationServiceImpl X() {
        Object obj = this.e0.get();
        if (obj == null) {
            synchronized (this.e0) {
                obj = this.e0.get();
                if (obj == null) {
                    obj = new MediationServiceImpl(this);
                    this.e0.set(obj);
                }
            }
        }
        if (obj == this.e0) {
            obj = null;
        }
        return (MediationServiceImpl) obj;
    }

    public void X0() {
        z().n();
    }

    public r3 Y() {
        Object obj = this.z.get();
        if (obj == null) {
            synchronized (this.z) {
                obj = this.z.get();
                if (obj == null) {
                    obj = new r3(this);
                    this.z.set(obj);
                }
            }
        }
        if (obj == this.z) {
            obj = null;
        }
        return (r3) obj;
    }

    public void Y0() {
        a((Map) null);
    }

    public s3 Z() {
        Object obj = this.f0.get();
        if (obj == null) {
            synchronized (this.f0) {
                obj = this.f0.get();
                if (obj == null) {
                    obj = new s3();
                    this.f0.set(obj);
                }
            }
        }
        if (obj == this.f0) {
            obj = null;
        }
        return (s3) obj;
    }

    public void Z0() {
        if ("admob".equalsIgnoreCase(this.l) && ((Boolean) a(v4.J3)).booleanValue()) {
            String str = (String) a(v4.I3);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            String str2 = AppLovinSdk.VERSION;
            if (str.startsWith(sb.append(str2).append(".").toString())) {
                return;
            }
            final String str3 = "Mismatched AdMob adapter (" + str + ") and AppLovin SDK (" + str2 + ") versions detected, which may cause compatibility issues.";
            o.h("AppLovinSdk", str3);
            AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.b(str3);
                }
            });
        }
    }

    public p a0() {
        Object obj = this.h0.get();
        if (obj == null) {
            synchronized (this.h0) {
                obj = this.h0.get();
                if (obj == null) {
                    obj = new p(this);
                    this.h0.set(obj);
                }
            }
        }
        if (obj == this.h0) {
            obj = null;
        }
        return (p) obj;
    }

    public AppLovinNativeAdService b0() {
        Object obj = this.n.get();
        if (obj == null) {
            synchronized (this.n) {
                obj = this.n.get();
                if (obj == null) {
                    obj = new AppLovinNativeAdService(this);
                    this.n.set(obj);
                }
            }
        }
        if (obj == this.n) {
            obj = null;
        }
        return (AppLovinNativeAdService) obj;
    }

    public v3 c0() {
        Object obj = this.M.get();
        if (obj == null) {
            synchronized (this.M) {
                obj = this.M.get();
                if (obj == null) {
                    obj = new v3(o());
                    this.M.set(obj);
                }
            }
        }
        if (obj == this.M) {
            obj = null;
        }
        return (v3) obj;
    }

    public z3 d0() {
        Object obj = this.Y.get();
        if (obj == null) {
            synchronized (this.Y) {
                obj = this.Y.get();
                if (obj == null) {
                    obj = new z3(this);
                    this.Y.set(obj);
                }
            }
        }
        if (obj == this.Y) {
            obj = null;
        }
        return (z3) obj;
    }

    public g4 e0() {
        Object obj = this.T.get();
        if (obj == null) {
            synchronized (this.T) {
                obj = this.T.get();
                if (obj == null) {
                    obj = new g4(this);
                    this.T.set(obj);
                }
            }
        }
        if (obj == this.T) {
            obj = null;
        }
        return (g4) obj;
    }

    public com.applovin.impl.sdk.network.b f0() {
        Object obj = this.a0.get();
        if (obj == null) {
            synchronized (this.a0) {
                obj = this.a0.get();
                if (obj == null) {
                    obj = new com.applovin.impl.sdk.network.b(this);
                    this.a0.set(obj);
                }
            }
        }
        if (obj == this.a0) {
            obj = null;
        }
        return (com.applovin.impl.sdk.network.b) obj;
    }

    public PostbackServiceImpl g0() {
        Object obj = this.Z.get();
        if (obj == null) {
            synchronized (this.Z) {
                obj = this.Z.get();
                if (obj == null) {
                    obj = new PostbackServiceImpl(this);
                    this.Z.set(obj);
                }
            }
        }
        if (obj == this.Z) {
            obj = null;
        }
        return (PostbackServiceImpl) obj;
    }

    public r h0() {
        Object obj = this.B.get();
        if (obj == null) {
            synchronized (this.B) {
                obj = this.B.get();
                if (obj == null) {
                    obj = O0();
                    if (obj == null) {
                        obj = this.B;
                    }
                    this.B.set(obj);
                }
            }
        }
        if (obj == this.B) {
            obj = null;
        }
        return (r) obj;
    }

    public e i() {
        Object obj = this.F.get();
        if (obj == null) {
            synchronized (this.F) {
                obj = this.F.get();
                if (obj == null) {
                    obj = new e(this);
                    this.F.set(obj);
                }
            }
        }
        if (obj == this.F) {
            obj = null;
        }
        return (e) obj;
    }

    public String i0() {
        return x0().a();
    }

    public com.applovin.impl.j j() {
        Object obj = this.b0.get();
        if (obj == null) {
            synchronized (this.b0) {
                obj = this.b0.get();
                if (obj == null) {
                    obj = new com.applovin.impl.j(this);
                    this.b0.set(obj);
                }
            }
        }
        if (obj == this.b0) {
            obj = null;
        }
        return (com.applovin.impl.j) obj;
    }

    public String j0() {
        return this.f695a;
    }

    public AppLovinAdServiceImpl k() {
        Object obj = this.m.get();
        if (obj == null) {
            synchronized (this.m) {
                obj = this.m.get();
                if (obj == null) {
                    obj = new AppLovinAdServiceImpl(this);
                    this.m.set(obj);
                }
            }
        }
        if (obj == this.m) {
            obj = null;
        }
        return (AppLovinAdServiceImpl) obj;
    }

    public MaxSegmentCollectionImpl k0() {
        return (MaxSegmentCollectionImpl) this.k;
    }

    public g l() {
        Object obj = this.K.get();
        if (obj == null) {
            synchronized (this.K) {
                obj = this.K.get();
                if (obj == null) {
                    obj = new g(this);
                    this.K.set(obj);
                }
            }
        }
        if (obj == this.K) {
            obj = null;
        }
        return (g) obj;
    }

    public Map l0() {
        MaxSegmentCollectionImpl k0 = k0();
        if (k0 == null) {
            return null;
        }
        return k0.getJsonData();
    }

    public h m() {
        Object obj = this.X.get();
        if (obj == null) {
            synchronized (this.X) {
                obj = this.X.get();
                if (obj == null) {
                    obj = new h(this);
                    this.X.set(obj);
                }
            }
        }
        if (obj == this.X) {
            obj = null;
        }
        return (h) obj;
    }

    public u4 m0() {
        Object obj = this.O.get();
        if (obj == null) {
            synchronized (this.O) {
                obj = this.O.get();
                if (obj == null) {
                    obj = new u4(this);
                    this.O.set(obj);
                }
            }
        }
        if (obj == this.O) {
            obj = null;
        }
        return (u4) obj;
    }

    public SessionTracker n0() {
        Object obj = this.I.get();
        if (obj == null) {
            synchronized (this.I) {
                obj = this.I.get();
                if (obj == null) {
                    obj = new SessionTracker(this);
                    this.I.set(obj);
                }
            }
        }
        if (obj == this.I) {
            obj = null;
        }
        return (SessionTracker) obj;
    }

    public AppLovinSdkSettings o0() {
        return this.j;
    }

    public ArrayService p() {
        Object obj = this.U.get();
        if (obj == null) {
            synchronized (this.U) {
                obj = this.U.get();
                if (obj == null) {
                    obj = new ArrayService(this);
                    this.U.set(obj);
                }
            }
        }
        if (obj == this.U) {
            obj = null;
        }
        return (ArrayService) obj;
    }

    public w4 p0() {
        Object obj = this.x.get();
        if (obj == null) {
            synchronized (this.x) {
                obj = this.x.get();
                if (obj == null) {
                    obj = new w4(this);
                    this.x.set(obj);
                }
            }
        }
        if (obj == this.x) {
            obj = null;
        }
        return (w4) obj;
    }

    public i q() {
        Object obj = this.P.get();
        if (obj == null) {
            synchronized (this.P) {
                obj = this.P.get();
                if (obj == null) {
                    obj = new i(this);
                    this.P.set(obj);
                }
            }
        }
        if (obj == this.P) {
            obj = null;
        }
        return (i) obj;
    }

    public y4 q0() {
        Object obj = this.C.get();
        if (obj == null) {
            synchronized (this.C) {
                obj = this.C.get();
                if (obj == null) {
                    obj = new y4(this);
                    this.C.set(obj);
                }
            }
        }
        if (obj == this.C) {
            obj = null;
        }
        return (y4) obj;
    }

    public String r() {
        return this.b;
    }

    public b6 r0() {
        Object obj = this.w.get();
        if (obj == null) {
            synchronized (this.w) {
                obj = this.w.get();
                if (obj == null) {
                    obj = new b6(this);
                    this.w.set(obj);
                }
            }
        }
        if (obj == this.w) {
            obj = null;
        }
        return (b6) obj;
    }

    public String s() {
        return x0().b();
    }

    public w6 s0() {
        Object obj = this.R.get();
        if (obj == null) {
            synchronized (this.R) {
                obj = this.R.get();
                if (obj == null) {
                    obj = new w6(this);
                    this.R.set(obj);
                }
            }
        }
        if (obj == this.R) {
            obj = null;
        }
        return (w6) obj;
    }

    public CmpServiceImpl t() {
        Object obj = this.p.get();
        if (obj == null) {
            synchronized (this.p) {
                obj = this.p.get();
                if (obj == null) {
                    obj = new CmpServiceImpl(this);
                    this.p.set(obj);
                }
            }
        }
        if (obj == this.p) {
            obj = null;
        }
        return (CmpServiceImpl) obj;
    }

    public c7 t0() {
        Object obj = this.k0.get();
        if (obj == null) {
            synchronized (this.k0) {
                obj = this.k0.get();
                if (obj == null) {
                    obj = new c7(this);
                    this.k0.set(obj);
                }
            }
        }
        if (obj == this.k0) {
            obj = null;
        }
        return (c7) obj;
    }

    public String toString() {
        return "CoreSdk{sdkKey='" + this.f695a + "', enabled=" + this.r0 + ", isFirstSession=" + this.s0 + AbstractJsonLexerKt.END_OBJ;
    }

    public j u() {
        Object obj = this.N.get();
        if (obj == null) {
            synchronized (this.N) {
                obj = this.N.get();
                if (obj == null) {
                    obj = new j(this);
                    this.N.set(obj);
                }
            }
        }
        if (obj == this.N) {
            obj = null;
        }
        return (j) obj;
    }

    public long u0() {
        if (this.h == 0) {
            return -1L;
        }
        return System.currentTimeMillis() - this.h;
    }

    public String v() {
        return x0().c();
    }

    public Activity v0() {
        Activity b2 = a(o()).b();
        return b2 != null ? b2 : J();
    }

    public SdkConfigurationImpl w() {
        return this.y0;
    }

    public i7 w0() {
        return this.v;
    }

    public q0 x() {
        Object obj = this.y.get();
        if (obj == null) {
            synchronized (this.y) {
                obj = this.y.get();
                if (obj == null) {
                    obj = new q0(this);
                    this.y.set(obj);
                }
            }
        }
        if (obj == this.y) {
            obj = null;
        }
        return (q0) obj;
    }

    public j7 x0() {
        Object obj = this.D.get();
        if (obj == null) {
            synchronized (this.D) {
                obj = this.D.get();
                if (obj == null) {
                    obj = new j7(this);
                    this.D.set(obj);
                }
            }
        }
        if (obj == this.D) {
            obj = null;
        }
        return (j7) obj;
    }

    public t0 y() {
        Object obj = this.Q.get();
        if (obj == null) {
            synchronized (this.Q) {
                obj = this.Q.get();
                if (obj == null) {
                    obj = new t0(this);
                    this.Q.set(obj);
                }
            }
        }
        if (obj == this.Q) {
            obj = null;
        }
        return (t0) obj;
    }

    public i8 y0() {
        Object obj = this.L.get();
        if (obj == null) {
            synchronized (this.L) {
                obj = this.L.get();
                if (obj == null) {
                    obj = new i8(this);
                    this.L.set(obj);
                }
            }
        }
        if (obj == this.L) {
            obj = null;
        }
        return (i8) obj;
    }

    public d1 z() {
        Object obj = this.S.get();
        if (obj == null) {
            synchronized (this.S) {
                obj = this.S.get();
                if (obj == null) {
                    obj = new d1(this);
                    this.S.set(obj);
                }
            }
        }
        if (obj == this.S) {
            obj = null;
        }
        return (d1) obj;
    }

    public AppLovinSdk z0() {
        return this.q;
    }

    private void d() {
        b6 r0 = r0();
        int i = this.u0 + 1;
        this.u0 = i;
        r0.a((g5) new r5(i, this, new a()), b6.b.CORE);
    }

    public com.applovin.impl.c e() {
        return a(E0);
    }

    public com.applovin.impl.sdk.a f() {
        Object obj = this.G.get();
        if (obj == null) {
            synchronized (this.G) {
                obj = this.G.get();
                if (obj == null) {
                    obj = new com.applovin.impl.sdk.a(this);
                    this.G.set(obj);
                }
            }
        }
        if (obj == this.G) {
            obj = null;
        }
        return (com.applovin.impl.sdk.a) obj;
    }

    public com.applovin.impl.f g() {
        return this.s;
    }

    public com.applovin.impl.sdk.d h() {
        Object obj = this.W.get();
        if (obj == null) {
            synchronized (this.W) {
                obj = this.W.get();
                if (obj == null) {
                    obj = new com.applovin.impl.sdk.d(this);
                    this.W.set(obj);
                }
            }
        }
        if (obj == this.W) {
            obj = null;
        }
        return (com.applovin.impl.sdk.d) obj;
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        E0 = context.getApplicationContext();
        F0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        if (JsonUtils.isValid(jSONObject)) {
            this.h = System.currentTimeMillis();
            r0.c(jSONObject, this);
            r0.b(jSONObject, this);
            r0.a(jSONObject, this);
            i3.f(jSONObject, this);
            i3.d(jSONObject, this);
            i3.e(jSONObject, this);
            i3.g(jSONObject, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(AppLovinSdkInitializationConfiguration appLovinSdkInitializationConfiguration) {
        B0();
        this.j.attachAppLovinSdk(this);
        String pluginVersion = appLovinSdkInitializationConfiguration.getPluginVersion();
        if (pluginVersion != null) {
            o.g("AppLovinSdk", "Setting plugin version: " + pluginVersion);
            p0().a(v4.I3, pluginVersion);
        }
        if (appLovinSdkInitializationConfiguration.isExceptionHandlerEnabled() && ((Boolean) a(v4.s)).booleanValue()) {
            AppLovinExceptionHandler.shared().addSdk(this);
            AppLovinExceptionHandler.shared().enable();
        }
        b6 r0 = r0();
        g5 g5Var = this.B0;
        b6.b bVar = b6.b.CORE;
        r0.a(g5Var, bVar);
        r0().a(this.C0, bVar);
    }

    public void a(AppLovinSdk appLovinSdk) {
        this.q = appLovinSdk;
    }

    public static String a(String str) {
        return a(str, (List) null);
    }

    public static String a(int i) {
        return a(i, (List) null);
    }

    public static String a(String str, List list) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Context o = o();
        return a(o.getResources().getIdentifier(str, "string", o.getPackageName()), list);
    }

    public static String a(int i, List list) {
        String string = o().getResources().getString(i);
        return list != null ? String.format(string, list.toArray()) : string;
    }

    public static com.applovin.impl.c a(Context context) {
        if (I0 == null) {
            synchronized (J0) {
                if (I0 == null) {
                    I0 = new com.applovin.impl.c(context);
                }
            }
        }
        return I0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        O();
        if (o.a()) {
            O().a("AppLovinSdk", str);
        }
        r0().a(new a6(this));
    }

    public void c() {
        synchronized (this.m0) {
            if (!this.q0 && !this.r0) {
                T0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        Iterator it = JsonUtils.getList(jSONObject, "error_messages", Collections.emptyList()).iterator();
        while (it.hasNext()) {
            o.h("AppLovinSdk", (String) it.next());
        }
    }

    public void a(final AppLovinSdkInitializationConfiguration appLovinSdkInitializationConfiguration, final AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        synchronized (this.x0) {
            if (this.w0 != null) {
                o.h("AppLovinSdk", "AppLovin SDK already initialized with configuration: " + this.w0 + ". Ignoring the provided initialization configuration.");
                if (!C0() || sdkInitializationListener == null) {
                    return;
                }
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.this.a(sdkInitializationListener);
                    }
                });
                return;
            }
            this.e = System.currentTimeMillis();
            this.w0 = appLovinSdkInitializationConfiguration;
            this.z0 = sdkInitializationListener;
            this.f695a = appLovinSdkInitializationConfiguration.getSdkKey();
            this.b = appLovinSdkInitializationConfiguration.getAxonEventKey();
            this.l = appLovinSdkInitializationConfiguration.getMediationProvider();
            this.k = appLovinSdkInitializationConfiguration.getSegmentCollection();
            k7.a(new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.a(appLovinSdkInitializationConfiguration);
                }
            });
        }
    }

    public List c(v4 v4Var) {
        return p0().c(v4Var);
    }

    public void c(x4 x4Var) {
        q0().b(x4Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        if (!k7.c(this)) {
            HashMap hashMap = new HashMap();
            hashMap.put("details", "admob");
            hashMap.put("error_message", str);
            E().a(c2.E0, "adapterVersionMismatch", hashMap);
            return;
        }
        throw new IllegalStateException(str);
    }

    protected void b(boolean z) {
        final AppLovinSdk.SdkInitializationListener sdkInitializationListener;
        if (y().i() || (sdkInitializationListener = this.z0) == null) {
            return;
        }
        if (C0()) {
            this.z0 = null;
            this.A0 = null;
            S().a(MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS);
        } else {
            if (this.A0 == sdkInitializationListener) {
                return;
            }
            S().a(MaxAdapter.InitializationStatus.INITIALIZED_FAILURE);
            if (((Boolean) a(v4.p)).booleanValue()) {
                this.z0 = null;
            } else {
                this.A0 = sdkInitializationListener;
            }
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putBoolean(jSONObject, "enabled", C0());
        JsonUtils.putBoolean(jSONObject, "timeout", z);
        JsonUtils.putBoolean(jSONObject, "consent_flow_shown", this.p0.get());
        long currentTimeMillis = System.currentTimeMillis() - this.e;
        HashMap hashMap = new HashMap();
        hashMap.put("duration_ms", String.valueOf(currentTimeMillis));
        hashMap.put("details", jSONObject.toString());
        this.v.d(c2.i, hashMap);
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                k.this.b(sdkInitializationListener);
            }
        }, Math.max(0L, ((Long) a(v4.q)).longValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        sdkInitializationListener.onSdkInitialized(this.y0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a(JSONObject jSONObject) {
        List asList = Arrays.asList(JsonUtils.getString(jSONObject, "eaf", "").split(","));
        ArrayList arrayList = new ArrayList(asList.size());
        Iterator it = asList.iterator();
        while (it.hasNext()) {
            MaxAdFormat formatFromString = MaxAdFormat.formatFromString((String) it.next());
            if (formatFromString != null) {
                arrayList.add(formatFromString);
            }
        }
        return arrayList;
    }

    public void a(boolean z) {
        synchronized (this.m0) {
            this.q0 = false;
            this.r0 = z;
        }
        if (z) {
            List a2 = t3.a(this);
            if (a2.isEmpty()) {
                r0().h();
                N0();
                return;
            }
            Long l = (Long) a(o3.f7);
            p6 p6Var = new p6(this, true, "timeoutInitAdapters", new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.J0();
                }
            });
            O();
            if (o.a()) {
                O().a("AppLovinSdk", "Waiting for required adapters to init: " + a2 + " - timing out in " + l + "ms...");
            }
            r0().a(p6Var, b6.b.TIMEOUT, l.longValue(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        O();
        if (o.a()) {
            O().a("AppLovinSdk", "Calling back publisher's initialization completion handler...");
        }
        sdkInitializationListener.onSdkInitialized(this.y0);
    }

    public List b(v4 v4Var) {
        return p0().b(v4Var);
    }

    public void b(x4 x4Var, Object obj) {
        q0().b(x4Var, obj);
    }

    public Object b(x4 x4Var) {
        return q0().a(x4Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
    
        r12 = r4.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:
    
        if (r12.hasNext() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0079, code lost:
    
        r13 = (java.util.Map.Entry) r12.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0089, code lost:
    
        if (r11.startsWith((java.lang.String) r13.getKey()) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008b, code lost:
    
        r15.v0 = (java.lang.String) r13.getValue();
        O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009a, code lost:
    
        if (com.applovin.impl.sdk.o.a() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
    
        O().a("AppLovinSdk", "Detected mediation provider: " + r15.v0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b8, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bd, code lost:
    
        if (r6.booleanValue() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bf, code lost:
    
        r2.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c2, code lost:
    
        r8 = java.lang.Integer.valueOf(r8.intValue() - 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b() {
        if (StringUtils.isValidString(this.v0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Map W = W();
        List c2 = c(v4.h4);
        Boolean bool = (Boolean) a(v4.i4);
        if (W.isEmpty() && !bool.booleanValue()) {
            return null;
        }
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            Integer num = (Integer) a(v4.g4);
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (num.intValue() <= 0) {
                    break;
                }
                String className = stackTraceElement.getClassName();
                Iterator it = c2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (className.startsWith((String) it.next())) {
                        break;
                    }
                }
            }
        } catch (Throwable th) {
            E().a("AppLovinSdk", "detectMediationProvider", th);
        }
        this.v0 = "unknown";
        O();
        if (o.a()) {
            O().k("AppLovinSdk", "Unable to detect mediation provider");
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        String join = StringUtils.join(",", arrayList);
        if (!((Boolean) a(v4.j4)).booleanValue()) {
            return join;
        }
        E().a(c2.d, "detectMediationProvider", CollectionUtils.hashMap("details", join));
        return null;
    }

    public void a(h3 h3Var) {
        if (r0().g()) {
            return;
        }
        List a2 = t3.a(this);
        if (a2.size() <= 0 || !S().a().containsAll(a2)) {
            return;
        }
        O();
        if (o.a()) {
            O().a("AppLovinSdk", "All required adapters initialized");
        }
        r0().h();
        N0();
    }

    public boolean a(MaxAdFormat maxAdFormat) {
        List list = this.l0;
        return (list == null || list.size() <= 0 || this.l0.contains(maxAdFormat)) ? false : true;
    }

    public void a() {
        String str = (String) q0().a(x4.g, null);
        if (StringUtils.isValidString(str)) {
            if (AppLovinSdk.VERSION_CODE < k7.g(str)) {
                o.h("AppLovinSdk", "Current version (" + AppLovinSdk.VERSION + ") is older than earlier installed version (" + str + "), which may cause compatibility issues.");
            }
        }
    }

    public Object a(v4 v4Var) {
        return p0().a(v4Var);
    }

    public boolean a(v4 v4Var, MaxAdFormat maxAdFormat) {
        return b(v4Var).contains(maxAdFormat);
    }

    public void a(Map map) {
        U().a(map);
    }

    public void a(Uri uri) {
        C().a(uri);
    }

    public void a(String str, Object obj, SharedPreferences.Editor editor) {
        q0().a(str, obj, editor);
    }

    public Object a(x4 x4Var) {
        return a(x4Var, (Object) null);
    }

    public Object a(x4 x4Var, Object obj) {
        return q0().a(x4Var, obj);
    }

    public Object a(String str, Object obj, Class cls, SharedPreferences sharedPreferences) {
        return y4.a(str, obj, cls, sharedPreferences);
    }

    public void a(SharedPreferences sharedPreferences) {
        q0().a(sharedPreferences);
    }
}
