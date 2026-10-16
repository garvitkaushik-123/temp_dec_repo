package com.inmobi.media;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.iab.omid.library.inmobi.Omid;
import com.iab.omid.library.inmobi.adsession.AdSessionContext;
import com.iab.omid.library.inmobi.adsession.ImpressionType;
import com.iab.omid.library.inmobi.adsession.VerificationScriptResource;
import com.inmobi.adquality.models.AdQualityControl;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.WatermarkData;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.TelemetryConfig;
import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$ABConfig;
import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$AdABConfig;
import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$AdNonABConfig;
import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$AdPreloadConfig;
import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$MediationConfig;
import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$NonABConfig;
import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$PreloadConfig;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import io.bidmachine.rendering.model.EventTaskParams;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class S0 extends AbstractC2669gc implements InterfaceC2573b2, InterfaceC2636ee, Te, InterfaceC2553a0 {
    public static final /* synthetic */ int M = 0;
    public boolean A;
    public String B;
    public final A C;
    public N D;
    public C2663g6 E;
    public C2957y7 F;
    public final Handler G;
    public final LinkedHashMap H;
    public final U0 I;
    public WatermarkData J;
    public final Lazy K;
    public final K0 L;

    /* renamed from: a, reason: collision with root package name */
    public byte f2420a;
    public AdConfig b;
    public WeakReference c;
    public C2784ne d;
    public B0 e;
    public WeakReference f;
    public ArrayList g;
    public T7 h;
    public HashMap i;
    public InterfaceC2971z5 j;
    public byte k;
    public Handler l;
    public boolean m;
    public GestureDetectorOnGestureListenerC2634ec n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public C2598ca s;
    public Z t;
    public C2947y0 u;
    public C2671ge v;
    public int w;
    public int x;
    public long y;
    public TreeSet z;

    public S0(Context context, Z adPlacement, F0 f0) {
        Boolean o;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
        this.g = new ArrayList();
        this.y = -1L;
        this.z = new TreeSet();
        this.C = A.f2225a;
        this.G = new Handler(Looper.getMainLooper());
        this.H = new LinkedHashMap();
        this.I = new U0(this);
        this.K = LazyKt.lazy(new R0(this));
        this.L = new K0(this);
        Intrinsics.checkNotNullExpressionValue("S0", "TAG");
        toString();
        this.c = new WeakReference(context);
        this.t = adPlacement;
        WeakReference weakReference = new WeakReference(f0);
        this.f = weakReference;
        String q = q();
        C2947y0 c2947y0 = this.u;
        this.D = new N(weakReference, q, (c2947y0 == null || (o = c2947y0.o()) == null) ? false : o.booleanValue());
        n0();
    }

    public static /* synthetic */ void R() {
    }

    public static /* synthetic */ void U() {
    }

    public static final tf c(S0 s0) {
        return (tf) s0.K.getValue();
    }

    public static final /* synthetic */ String e() {
        return "S0";
    }

    public final int A() {
        return this.x;
    }

    public long A0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "timeSincePodShow ", this));
        }
        if (this.A) {
            return System.currentTimeMillis() - this.y;
        }
        return -1L;
    }

    public final TreeSet<Integer> B() {
        return this.z;
    }

    public final Ue B0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "trySetTheLocalVideoDescriptor ", this));
        }
        C2672h m = m();
        if (m == null) {
            throw new IllegalStateException("No ad");
        }
        if (!(m instanceof W8)) {
            return null;
        }
        W8 w8 = (W8) m;
        C2705j b = Nc.a().b(w8.f2470a);
        if (b == null || !b.a()) {
            throw new IllegalStateException("Asset not available in cache");
        }
        String str = b.c;
        String str2 = w8.b;
        String str3 = w8.c;
        ArrayList arrayList = w8.d;
        ArrayList arrayList2 = w8.e;
        AdConfig adConfig = this.b;
        Intrinsics.checkNotNull(adConfig);
        return new Ue(str, str2, str3, arrayList, arrayList2, adConfig.getVastVideo());
    }

    public final long C() {
        return this.y;
    }

    public final void C0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).b("S0", "ad unloaded");
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z52).d("S0", "AdUnit " + this + " state - UNLOADED");
        }
        d((byte) 8);
    }

    public final Handler D() {
        return this.l;
    }

    public final String E() {
        String u;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "markupType getter ", this));
        }
        C2672h m = m();
        return (m == null || (u = m.u()) == null) ? "unknown" : u;
    }

    public Integer F() {
        return null;
    }

    public final T7 G() {
        return this.h;
    }

    public final C2598ca H() {
        return this.s;
    }

    public final Z I() {
        return this.t;
    }

    public abstract byte J();

    public String K() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "getPodAdContext ", this));
        }
        if (this.A) {
            return this.B;
        }
        return null;
    }

    public final String L() {
        return d(0);
    }

    public final Map<String, String> M() {
        return this.t.f();
    }

    public JSONArray N() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "getRenderableAdIndexes ", this));
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.z.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Intrinsics.checkNotNull(num);
            jSONArray.put(num.intValue());
        }
        return jSONArray;
    }

    public long O() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "getShowTimeStamp ", this));
        }
        if (this.A) {
            return this.y;
        }
        return -1L;
    }

    public final Unit P() {
        F0 r = r();
        long currentTimeMillis = System.currentTimeMillis();
        if (a(r, currentTimeMillis)) {
            return Unit.INSTANCE;
        }
        this.r = true;
        if (this.s == null) {
            this.s = new C2598ca(this);
        }
        A a2 = this.C;
        int hashCode = hashCode();
        H4 h4 = new H4(this, currentTimeMillis, this.j);
        a2.getClass();
        A.a(hashCode, h4);
        return Unit.INSTANCE;
    }

    public final byte Q() {
        return this.f2420a;
    }

    public final String S() {
        LinkedList<C2672h> f;
        C2672h c2672h;
        String w;
        C2947y0 c2947y0 = this.u;
        return (c2947y0 == null || (f = c2947y0.f()) == null || (c2672h = (C2672h) CollectionsKt.firstOrNull((List) f)) == null || (w = c2672h.w()) == null) ? "" : w;
    }

    public final byte T() {
        return this.k;
    }

    public final void V() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "handleInterActive ", this));
        }
        A a2 = this.C;
        int hashCode = hashCode();
        J0 j0 = new J0(this);
        a2.getClass();
        A.a(hashCode, j0);
    }

    public final boolean W() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "hasAdExpired ", this));
        }
        C2672h m = m();
        if (m == null) {
            return false;
        }
        AdConfig adConfig = this.b;
        Intrinsics.checkNotNull(adConfig);
        return m.a(adConfig.getCacheConfig(q()).getTimeToLive());
    }

    public final boolean X() {
        AdConfig.RenderingConfig rendering;
        AdConfig adConfig = this.b;
        return adConfig != null && (rendering = adConfig.getRendering()) != null && rendering.getEnablePubMuteControl() && Uc.o();
    }

    public final boolean Y() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).c("S0", "isBlockingStateForLoadWithResponse getter " + this + " state=" + ((int) this.f2420a));
        }
        if (!G4.f2291a.a()) {
            g();
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.GDPR_COMPLIANCE_ENFORCED), true, (short) 2141);
            return true;
        }
        if (f0()) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).b("S0", H6.a("S0", "TAG", "Some of the dependency libraries for ").append(q()).append(" not found").toString());
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES), true, (short) 2007);
            return true;
        }
        byte b = this.f2420a;
        if (b == 1) {
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z53).b("S0", "load with reasponse called while loading");
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOAD_WITH_RESPONSE_CALLED_WHILE_LOADING), false, (short) 2001);
            return true;
        }
        if (b != 7) {
            return false;
        }
        InterfaceC2971z5 interfaceC2971z54 = this.j;
        if (interfaceC2971z54 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z54).b("S0", "ad active before load");
        }
        b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE), false, (short) 2003);
        return true;
    }

    public final boolean Z() {
        return this.o;
    }

    public abstract /* synthetic */ void a(int i, GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec);

    @Override // com.inmobi.media.AbstractC2669gc
    public void a(GestureDetectorOnGestureListenerC2634ec renderView, boolean z) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).c("S0", "onRenderProcessGone didCrash=" + z + " state=" + ((int) this.f2420a));
        }
        byte b = this.f2420a;
        if (b == 0) {
            short s = z ? (short) 2214 : (short) 2213;
            m0();
            renderView.a(z, s);
            return;
        }
        if (b == 1) {
            short s2 = z ? (short) 2216 : (short) 2215;
            m0();
            b(s2);
            F0 r = r();
            if (r != null) {
                r.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                return;
            }
            return;
        }
        if (b == 3) {
            renderView.a(z, z ? (short) 2226 : (short) 2225);
            return;
        }
        if (b == 2) {
            m0();
            b(z ? (short) 2218 : (short) 2217);
            F0 r2 = r();
            if (r2 != null) {
                r2.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                return;
            }
            return;
        }
        if (b == 4 || b == 6 || b == 7 || b != 8) {
            return;
        }
        renderView.a(z, z ? (short) 2240 : (short) 2241);
    }

    public final boolean a0() {
        return this.m;
    }

    public abstract /* synthetic */ void b();

    public final boolean b0() {
        return this.A;
    }

    public void c0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "load  ", this));
        }
        U0 u0 = this.I;
        u0.getClass();
        u0.c = SystemClock.elapsedRealtime();
        a(new L0(this), new M0(this));
    }

    public final void d(byte b) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).d("S0", H6.a("S0", "TAG", "from ").append((int) this.f2420a).append(" to ").append((int) b).append(' ').append(this).toString());
        }
        this.f2420a = b;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0110 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d0() throws IllegalStateException {
        List<String> c;
        LinkedList<C2672h> f;
        C2672h c2672h;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "loadAd_ ", this));
        }
        C2672h m = m();
        if (m == null || W()) {
            m = null;
        }
        if (m == null) {
            throw new IllegalStateException("Unable to get topAd");
        }
        String u = m.u();
        int hashCode = u.hashCode();
        if (hashCode == -1084172778) {
            if (u.equals("inmobiJson")) {
                InterfaceC2971z5 interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                    ((A5) interfaceC2971z52).a("S0", H6.a("S0", "TAG", "Loading ad with impressionId : ").append(m.s()).toString());
                }
                C2947y0 c2947y0 = this.u;
                if (c2947y0 != null) {
                    AdConfig adConfig = this.b;
                    Intrinsics.checkNotNull(adConfig);
                    c2947y0.a(adConfig, this, this.j);
                }
                c = m.c(C2672h.WIN_BEACON);
                if (this.A) {
                }
                if (c == null) {
                }
            }
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                ((A5) interfaceC2971z53).b("S0", H6.a("S0", "TAG", "Can not handle fallback for").append(m.u()).toString());
            }
            throw new IllegalStateException("Can not handle fallback for markup type: " + m.u());
        }
        if (hashCode != 3213227) {
            c = m.c(C2672h.WIN_BEACON);
            if (this.A) {
                C2947y0 c2947y02 = this.u;
                Intrinsics.checkNotNull(c2947y02);
                int size = c2947y02.f().size();
                for (int i = 1; i < size; i++) {
                    C2947y0 c2947y03 = this.u;
                    List<String> c2 = (c2947y03 == null || (f = c2947y03.f()) == null || (c2672h = f.get(i)) == null) ? null : c2672h.c(C2672h.WIN_BEACON);
                    if (c2 != null && (c instanceof LinkedList)) {
                        ((LinkedList) c).addAll(c2);
                    }
                }
            }
            if (c == null) {
                return;
            }
            Iterator<String> it = c.iterator();
            while (it.hasNext()) {
                C2933x2.f2748a.a(it.next(), true, this.j);
            }
            return;
        }
        c = m.c(C2672h.WIN_BEACON);
        if (this.A) {
        }
        if (c == null) {
        }
    }

    public final void e0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "makeUnitActive ", this));
        }
        this.o = false;
    }

    public final void f(int i) {
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "initializeHtmlAdContainer ", this));
        }
        Context t = t();
        if (t == null) {
            return;
        }
        try {
            if (this.g.get(i) == null || ((gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) this.g.get(i)) != null && gestureDetectorOnGestureListenerC2634ec.J.get())) {
                C2672h b = b(i);
                GestureDetectorOnGestureListenerC2634ec a2 = ((tf) this.K.getValue()).a(new Cc("adUnit-" + i, EventTaskParams.STATE_GROUP_DEFAULT), t, (short) 0, a(i));
                this.g.set(i, a2);
                AdConfig adConfig = this.b;
                Intrinsics.checkNotNull(adConfig);
                a2.a(this, adConfig);
                InterfaceC2971z5 interfaceC2971z52 = a2.i;
                if (interfaceC2971z52 != null) {
                    String str = GestureDetectorOnGestureListenerC2634ec.a1;
                    ((A5) interfaceC2971z52).c(str, Ob.a(a2, str, "TAG", "initContextualData "));
                }
                a2.T0 = new C2625e3(b, a2.T);
            }
        } catch (Exception e) {
            a((GestureDetectorOnGestureListenerC2634ec) this.g.get(this.w), (short) 2136);
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z53).a("S0", "Exception while initializing WebView", e);
            }
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    public boolean f0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "missingPrerequisitesForAd ", this));
        }
        try {
            Reflection.getOrCreateKotlinClass(RecyclerView.class).getSimpleName();
            Reflection.getOrCreateKotlinClass(CustomTabsClient.class).getSimpleName();
            return false;
        } catch (NoClassDefFoundError unused) {
            return true;
        }
    }

    public final void g(F0 f0) {
        Boolean o;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "adUnitEventListener setter ", this));
        }
        WeakReference weakReference = new WeakReference(f0);
        this.f = weakReference;
        String q = q();
        C2947y0 c2947y0 = this.u;
        N n = new N(weakReference, q, (c2947y0 == null || (o = c2947y0.o()) == null) ? false : o.booleanValue());
        this.D = n;
        InterfaceC2971z5 logger = this.j;
        if (logger != null) {
            Intrinsics.checkNotNullParameter(logger, "logger");
            n.f = logger;
        }
    }

    public void g0() {
        U0 u0 = this.I;
        u0.getClass();
        u0.h = SystemClock.elapsedRealtime();
    }

    public final void h(int i) {
        this.w = i;
    }

    public final T h0() {
        String jSONArray;
        Integer num;
        Integer num2;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "prepareAdRequest ", this));
        }
        Context t = t();
        X9 x9 = null;
        Z9 z9 = t != null ? new Z9(t, this.j) : null;
        AdConfig adConfig = this.b;
        String url = adConfig != null ? adConfig.getUrl() : null;
        AdConfig adConfig2 = this.b;
        Intrinsics.checkNotNull(adConfig2);
        C2897ue c2897ue = new C2897ue(adConfig2.getIncludeIds());
        ArrayList a2 = Nc.a().a();
        if (a2.isEmpty()) {
            jSONArray = null;
        } else {
            JSONArray jSONArray2 = new JSONArray();
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray2.put(URLEncoder.encode(((C2705j) it.next()).b, "UTF-8"));
                } catch (UnsupportedEncodingException unused) {
                }
            }
            jSONArray = jSONArray2.toString();
        }
        Z z = this.t;
        if (z9 != null) {
            if (z9.d) {
                x9 = new X9(MapsKt.hashMapOf(TuplesKt.to("n-h-id", z9.c)));
            } else {
                InterfaceC2971z5 interfaceC2971z52 = z9.b;
                if (interfaceC2971z52 != null) {
                    ((A5) interfaceC2971z52).a("NovatiqDataHandler", "Novatiq disabled. skip");
                }
                x9 = new X9(MapsKt.emptyMap());
            }
        }
        X9 x92 = x9;
        InterfaceC2971z5 interfaceC2971z53 = this.j;
        AdConfig adConfig3 = this.b;
        T t2 = new T(url, c2897ue, jSONArray, z, x92, interfaceC2971z53, adConfig3 != null ? adConfig3.getApplyGzipReq() : false);
        t2.C = this.t.i();
        t2.B = q();
        Intrinsics.checkNotNullParameter("unifiedSdkJson", "<set-?>");
        t2.A = "unifiedSdkJson";
        t2.D = o();
        C2957y7 c2957y7 = this.F;
        int i = 15000;
        t2.p = (c2957y7 == null || (num2 = c2957y7.d) == null) ? 15000 : num2.intValue();
        C2957y7 c2957y72 = this.F;
        if (c2957y72 != null && (num = c2957y72.d) != null) {
            i = num.intValue();
        }
        t2.q = i;
        t2.o = X();
        return t2;
    }

    public final void i(int i) {
        this.x = i;
    }

    public C2784ne i0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "provideTimeoutConfigurations ", this));
        }
        C2784ne c2784ne = this.d;
        Intrinsics.checkNotNull(c2784ne);
        return c2784ne;
    }

    public final AdConfig j() {
        return this.b;
    }

    public abstract void j0();

    public final InterfaceC2930x k() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "adMarkupContainer getter ", this));
        }
        byte b = this.f2420a;
        String E = E();
        int hashCode = E.hashCode();
        if (hashCode == -1084172778) {
            if (!E.equals("inmobiJson") || b == 0 || 1 == b || 3 == b || 2 == b) {
                return null;
            }
            return this.h;
        }
        if (hashCode == 3213227) {
            if (!E.equals(AnalyticsConstants.CREATIVE_TYPE_HTML) || b == 0 || 1 == b || 3 == b || 8 == b) {
                return null;
            }
            return w();
        }
        if (hashCode != 1236050372 || !E.equals("htmlUrl") || b == 0 || 1 == b || 3 == b || 8 == b) {
            return null;
        }
        return w();
    }

    public void k0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "resetContainersForNextAd ", this));
        }
        T7 t7 = this.h;
        if (t7 != null) {
            t7.b();
        }
        this.h = null;
        int size = this.g.size();
        int i = this.x;
        if (size <= i || this.g.get(i) == null) {
            return;
        }
        a(this.x, false);
    }

    public final AdMetaInfo l() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "adMetaInfo getter ", this));
        }
        C2672h m = m();
        if (m != null) {
            return m.d();
        }
        return null;
    }

    public final S6 l0() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z;
        String t;
        Boolean o;
        long l = this.t.l();
        C2672h u = u();
        if (u == null || (str = u.s()) == null) {
            str = "";
        }
        String valueOf = String.valueOf(this.t.m());
        String q = q();
        String E = E();
        C2672h u2 = u();
        if (u2 == null || (str2 = u2.p()) == null) {
            str2 = "";
        }
        C2672h u3 = u();
        if (u3 == null || (str3 = u3.w()) == null) {
            str3 = "";
        }
        C2947y0 c2947y0 = this.u;
        boolean booleanValue = (c2947y0 == null || (o = c2947y0.o()) == null) ? false : o.booleanValue();
        C2672h u4 = u();
        if (u4 == null || (t = u4.t()) == null) {
            boolean z2 = booleanValue;
            str4 = "";
            str5 = str2;
            str6 = str3;
            z = z2;
        } else {
            str5 = str2;
            str6 = str3;
            z = booleanValue;
            str4 = t;
        }
        return new S6(l, str, valueOf, q, E, str5, str6, z, str4);
    }

    public final C2672h m() {
        return b(0);
    }

    public final void m0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).d("S0", "AdUnit " + this + " state - FAILED");
        }
        d((byte) 3);
        b((byte) 1);
    }

    public final String n() {
        C2947y0 c2947y0 = this.u;
        if (c2947y0 != null) {
            return c2947y0.c();
        }
        return null;
    }

    public final void n0() {
        Intrinsics.checkNotNullExpressionValue("S0", "TAG");
        toString();
        String b = Uc.b();
        LinkedHashMap linkedHashMap = O2.f2380a;
        Config a2 = M2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, b, null);
        this.b = a2 instanceof AdConfig ? (AdConfig) a2 : null;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "timeOutConfiguration getter ", this));
        }
        AdConfig adConfig = this.b;
        Intrinsics.checkNotNull(adConfig);
        this.d = adConfig.getTimeouts();
        d((byte) 0);
        this.e = new B0(this, this, this.t);
        this.i = new HashMap();
        this.k = (byte) -1;
        this.l = new Handler(Looper.getMainLooper());
        this.m = false;
        this.v = new C2671ge(this);
    }

    public HashMap o() {
        return new HashMap();
    }

    public final boolean o0() {
        Unit unit;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "shouldBlockLoadAd ", this));
        }
        C2672h m = m();
        if (m != null && 4 == this.f2420a && !W()) {
            F0 r = r();
            if (r != null) {
                InterfaceC2971z5 interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                    Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                    ((A5) interfaceC2971z52).a("S0", "ad is ready - load success");
                }
                f(r);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b((short) 2188);
            }
            return true;
        }
        if (m == null) {
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE), true, (short) 2131);
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z53).b("S0", "ad no longer available");
            }
            return true;
        }
        if (2 != this.f2420a) {
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE), true, (short) 2132);
            InterfaceC2971z5 interfaceC2971z54 = this.j;
            if (interfaceC2971z54 != null) {
                ((A5) interfaceC2971z54).b("S0", H6.a("S0", "TAG", "ad no longer available. state - ").append((int) this.f2420a).toString());
            }
            return true;
        }
        if (!W()) {
            return false;
        }
        b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE), true, (short) 2133);
        InterfaceC2971z5 interfaceC2971z55 = this.j;
        if (interfaceC2971z55 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z55).b("S0", "ad is expired");
        }
        return true;
    }

    public final B0 p() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "adStore getter ", this));
        }
        if (this.e == null) {
            this.e = new B0(this, this, this.t);
        }
        B0 b0 = this.e;
        Intrinsics.checkNotNull(b0);
        return b0;
    }

    public final boolean p0() {
        AdConfig adConfig;
        return Intrinsics.areEqual(this.t.m(), "AB") && (adConfig = this.b) != null && adConfig.getSkipNetCheckHB();
    }

    public abstract String q();

    public void q0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "signalAvailabilityChange ", this));
        }
    }

    public final F0 r() {
        InterfaceC2971z5 interfaceC2971z5;
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).c("S0", D0.a("S0", "TAG", "adUnitEventListener getter ", this));
        }
        F0 f0 = (F0) this.f.get();
        if (f0 == null && (interfaceC2971z5 = this.j) != null) {
            ((A5) interfaceC2971z5).b("InMobi", "Listener was garbage collected. Unable to give callback");
        }
        return f0;
    }

    public void r0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "signalSuccess ", this));
        }
    }

    public final U0 s() {
        return this.I;
    }

    public final void s0() {
        LinkedList<C2672h> f;
        C2672h c2672h;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "startLoadingHTMLAd ", this));
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = null;
        try {
            f(this.w);
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                StringBuilder sb = new StringBuilder("Loading ad with impressionId : ");
                C2947y0 c2947y0 = this.u;
                ((A5) interfaceC2971z52).a("S0", sb.append((c2947y0 == null || (f = c2947y0.f()) == null || (c2672h = f.get(this.w)) == null) ? null : c2672h.s()).toString());
            }
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = (GestureDetectorOnGestureListenerC2634ec) this.g.get(this.w);
            String E = E();
            if (Intrinsics.areEqual(E, AnalyticsConstants.CREATIVE_TYPE_HTML)) {
                InterfaceC2971z5 interfaceC2971z53 = this.j;
                if (interfaceC2971z53 != null) {
                    Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                    ((A5) interfaceC2971z53).a("S0", "loading into weview for " + E());
                }
                if (gestureDetectorOnGestureListenerC2634ec2 != null) {
                    gestureDetectorOnGestureListenerC2634ec2.d(d(this.w));
                }
            } else if (Intrinsics.areEqual(E, "htmlUrl")) {
                InterfaceC2971z5 interfaceC2971z54 = this.j;
                if (interfaceC2971z54 != null) {
                    Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                    ((A5) interfaceC2971z54).a("S0", "loading into weview for " + E());
                }
                if (gestureDetectorOnGestureListenerC2634ec2 != null) {
                    gestureDetectorOnGestureListenerC2634ec2.e(d(this.w));
                }
            }
            a(true, gestureDetectorOnGestureListenerC2634ec2);
            if (gestureDetectorOnGestureListenerC2634ec2 == null || !Intrinsics.areEqual(E(), "htmlUrl")) {
                return;
            }
            k(gestureDetectorOnGestureListenerC2634ec2);
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z55 = this.j;
            if (interfaceC2971z55 != null) {
                ((A5) interfaceC2971z55).a("S0", rf.a(e, H6.a("S0", "TAG", "Loading ad markup into container encountered an unexpected error: ")));
            }
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            int i = this.w;
            if (i >= 0 && i < this.g.size()) {
                gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) this.g.get(this.w);
            }
            a(gestureDetectorOnGestureListenerC2634ec, (short) 2135);
        }
    }

    public final Context t() {
        WeakReference weakReference = this.c;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    public final void t0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "submitAdLoadCalled ", this));
        }
        HashMap hashMap = new HashMap();
        c(hashMap);
        c("AdLoadCalled", hashMap);
    }

    public final C2672h u() {
        return this.A ? b(this.w) : m();
    }

    public final void u0() {
        Boolean o;
        String p;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", H6.a("S0", "TAG", "submitAdLoadSuccessfulEvent ADunit markuptype : ").append(E()).append(' ').append(this).toString());
        }
        HashMap hashMap = new HashMap();
        long j = this.I.c;
        ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
        hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        hashMap.put("markupType", E());
        C2672h u = u();
        if (u != null && (p = u.p()) != null) {
            hashMap.put("creativeType", "\"" + p + '\"');
        }
        C2663g6 c2663g6 = this.E;
        if (c2663g6 != null) {
            hashMap.put("retryCount", Integer.valueOf(c2663g6.b));
        }
        C2947y0 c2947y0 = this.u;
        if (c2947y0 != null && (o = c2947y0.o()) != null) {
            hashMap.put("isRewarded", o);
        }
        if (S().length() > 0) {
            hashMap.put("metadataBlob", S());
        }
        c(hashMap);
        c("AdLoadSuccessful", hashMap);
    }

    public final A v() {
        return this.C;
    }

    public final void v0() {
        String p;
        Boolean o;
        HashMap hashMap = new HashMap();
        c(hashMap);
        hashMap.put("markupType", E());
        long j = this.I.h;
        ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
        hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        hashMap.put("metadataBlob", S());
        C2663g6 c2663g6 = this.E;
        if (c2663g6 != null) {
            hashMap.put("retryCount", Integer.valueOf(c2663g6.b));
        }
        C2947y0 c2947y0 = this.u;
        if (c2947y0 != null && (o = c2947y0.o()) != null) {
            hashMap.put("isRewarded", o);
        }
        C2672h u = u();
        if (u != null && (p = u.p()) != null) {
            hashMap.put("creativeType", "\"" + p + '\"');
        }
        c("ParseSuccess", hashMap);
    }

    public GestureDetectorOnGestureListenerC2634ec w() {
        if (this.g.size() <= 0 || this.x >= this.g.size()) {
            return null;
        }
        return (GestureDetectorOnGestureListenerC2634ec) this.g.get(this.x);
    }

    public final void w0() {
        Boolean o;
        String p;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "submitAdShowCalled ", this));
        }
        U0 u0 = this.I;
        u0.getClass();
        u0.e = SystemClock.elapsedRealtime();
        HashMap hashMap = new HashMap();
        hashMap.put("markupType", E());
        long j = this.I.i;
        ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
        hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        C2672h b = this.A ? b(this.x) : m();
        if (b != null && (p = b.p()) != null) {
            hashMap.put("creativeType", "\"" + p + '\"');
        }
        C2947y0 c2947y0 = this.u;
        if (c2947y0 != null && (o = c2947y0.o()) != null) {
            hashMap.put("isRewarded", o);
        }
        if (S().length() > 0) {
            hashMap.put("metadataBlob", S());
        }
        c(hashMap);
        c("AdShowCalled", hashMap);
    }

    public final GestureDetectorOnGestureListenerC2634ec x() {
        return this.n;
    }

    public final void x0() {
        Boolean o;
        String p;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "submitAdShowSuccess ", this));
        }
        HashMap hashMap = new HashMap();
        long j = this.I.e;
        ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
        hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        hashMap.put("markupType", E());
        C2672h b = this.A ? b(this.x) : m();
        if (b != null && (p = b.p()) != null) {
            hashMap.put("creativeType", "\"" + p + '\"');
        }
        C2947y0 c2947y0 = this.u;
        if (c2947y0 != null && (o = c2947y0.o()) != null) {
            hashMap.put("isRewarded", o);
        }
        if (S().length() > 0) {
            hashMap.put("metadataBlob", S());
        }
        c(hashMap);
        c("AdShowSuccessful", hashMap);
    }

    public final C2947y0 y() {
        return this.u;
    }

    public final void y0() {
        HashMap hashMap = new HashMap();
        c(hashMap);
        c("AdGetSignalsCalled", hashMap);
    }

    public final int z() {
        return this.w;
    }

    public final void z0() {
        Boolean o;
        String p;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", H6.a("S0", "TAG", "submitRenderSuccessEvent ADunit markuptype : ").append(E()).append(' ').append(this).toString());
        }
        HashMap hashMap = new HashMap();
        long j = this.I.g;
        ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
        hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        hashMap.put("markupType", E());
        C2672h b = this.A ? b(this.x) : m();
        if (b != null && (p = b.p()) != null) {
            hashMap.put("creativeType", "\"" + p + '\"');
        }
        C2663g6 c2663g6 = this.E;
        if (c2663g6 != null) {
            hashMap.put("retryCount", Integer.valueOf(c2663g6.b));
        }
        hashMap.put("plType", Byte.valueOf(J()));
        C2947y0 c2947y0 = this.u;
        if (c2947y0 != null && (o = c2947y0.o()) != null) {
            hashMap.put("isRewarded", o);
        }
        if (S().length() > 0) {
            hashMap.put("metadataBlob", S());
        }
        c(hashMap);
        c((Map) hashMap);
        c("RenderSuccess", hashMap);
    }

    public final void e(C2947y0 c2947y0) {
        this.u = c2947y0;
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void h(final GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "onRenderViewSignaledAdReady ", this));
        }
        if (this.o || t() == null) {
            b((short) 2186);
            return;
        }
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.inmobi.media.S0$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    S0.c(S0.this, renderView);
                }
            });
        } else {
            b((short) 2187);
        }
    }

    public final void i() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "fireAdServedBeacon ", this));
        }
        InterfaceC2930x k = k();
        if (k == null) {
            return;
        }
        k.a((byte) 2, null);
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void j(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        byte b = this.f2420a;
        if (b == 2) {
            C0();
            b((byte) 1);
            F0 r = r();
            InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
            if (r != null) {
                r.a(this, inMobiAdRequestStatus);
            } else {
                InterfaceC2971z5 interfaceC2971z5 = this.j;
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).a();
                }
            }
            b((short) 2238);
            renderView.b();
            return;
        }
        if (b == 4) {
            n(renderView);
            renderView.b();
            b((byte) 4);
        } else {
            if (b == 6 || b == 7) {
                o(renderView);
                return;
            }
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).b("S0", H6.a("S0", "TAG", "onUnloadCalled - invalid state - ").append((int) this.f2420a).toString());
            }
        }
    }

    public void m(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", H6.a("S0", "TAG", "Render view signaled ad ready, for index ").append(this.g.indexOf(gestureDetectorOnGestureListenerC2634ec)).append(' ').append(this).toString());
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z52).a("S0", "==== CHECKPOINT REACHED - LOAD SUCCESS ====");
        }
        InterfaceC2971z5 interfaceC2971z53 = this.j;
        if (interfaceC2971z53 != null) {
            ((A5) interfaceC2971z53).b();
        }
    }

    public void n(GestureDetectorOnGestureListenerC2634ec renderView) {
        int l;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).c("S0", "onAdUnloadedAfterLoadSuccess");
        }
        if (!this.A || (l = l(renderView)) <= this.x) {
            C0();
        } else {
            this.z.remove(Integer.valueOf(l));
        }
    }

    public void o(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).c("S0", "onAdUnloadedAfterShowSuccess");
        }
        renderView.i();
        b((byte) 4);
    }

    public final void b(boolean z) {
        this.m = z;
    }

    public final void c(boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "setIsAssetReady ", this));
        }
        this.p = z;
    }

    public final Set e(int i) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "getViewabilityTrackers ", this));
        }
        HashMap hashMap = this.i;
        if (hashMap != null) {
            return (Set) hashMap.get(Integer.valueOf(i));
        }
        return null;
    }

    public final boolean b(C2672h c2672h) {
        C2834r0 q;
        AdConfig.RenderingConfig rendering;
        AdConfig adConfig = this.b;
        boolean z = false;
        boolean enableImmersive = (adConfig == null || (rendering = adConfig.getRendering()) == null) ? false : rendering.getEnableImmersive();
        boolean z2 = U3.i;
        boolean a2 = (c2672h == null || (q = c2672h.q()) == null) ? false : q.a(false);
        if (enableImmersive && z2 && a2) {
            z = true;
        }
        if (!z) {
            b(enableImmersive, z2, a2);
        }
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).a("S0", "Immersive support - config, device, adResponse - (" + enableImmersive + ' ' + z2 + ' ' + a2 + ')');
        }
        return z;
    }

    public final void b(boolean z, boolean z2, boolean z3) {
        Pair<String, Short> a2 = a(z, z2, z3);
        String component1 = a2.component1();
        short shortValue = a2.component2().shortValue();
        HashMap hashMap = new HashMap();
        hashMap.put("reason", component1);
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Short.valueOf(shortValue));
        c("ImmersiveNotSupported", hashMap);
    }

    public final C2672h b(int i) {
        Iterable emptyList;
        LinkedList<C2672h> f;
        LinkedList<C2672h> f2;
        Intrinsics.checkNotNullExpressionValue("S0", "TAG");
        toString();
        C2947y0 c2947y0 = this.u;
        if (c2947y0 == null || (f2 = c2947y0.f()) == null || (emptyList = CollectionsKt.getIndices(f2)) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        if (CollectionsKt.contains(emptyList, Integer.valueOf(i))) {
            C2947y0 c2947y02 = this.u;
            if (c2947y02 == null || (f = c2947y02.f()) == null) {
                return null;
            }
            return f.get(i);
        }
        C2947y0 c2947y03 = this.u;
        if (c2947y03 != null) {
            return c2947y03.p();
        }
        return null;
    }

    public final int b(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "parseViewabilityResponseValue ", this));
        }
        if (StringsKt.startsWith$default(str, "track_", false, 2, (Object) null)) {
            str = str.substring(6);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static final void a(Context context, S0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C2796oa c2796oa = AbstractC2780na.f2651a;
        AdConfig adConfig = this$0.b;
        c2796oa.getClass();
        try {
            if (!Omid.isActive()) {
                Omid.activate(context);
            } else {
                c2796oa.a(adConfig);
            }
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    public final void a(AdConfig adConfig) {
        this.b = adConfig;
    }

    public final void a(Handler handler) {
        this.l = handler;
    }

    public final void a(C2598ca c2598ca) {
        this.s = c2598ca;
    }

    public final void a(long j) {
        this.y = j;
    }

    public final void a(TreeSet<Integer> treeSet) {
        Intrinsics.checkNotNullParameter(treeSet, "<set-?>");
        this.z = treeSet;
    }

    public final void a(Context context, Z adPlacement, F0 f0) {
        String placementType;
        String adTypes;
        TimeoutConfigurations$AdNonABConfig banner;
        C2957y7 c2957y7;
        TimeoutConfigurations$AdPreloadConfig banner2;
        TimeoutConfigurations$AdABConfig banner3;
        InterfaceC2971z5 interfaceC2971z5;
        InterfaceC2971z5 interfaceC2971z52;
        InterfaceC2971z5 interfaceC2971z53;
        Boolean o;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
        Intrinsics.checkNotNullExpressionValue("S0", "TAG");
        toString();
        a(context);
        WeakReference weakReference = new WeakReference(f0);
        this.f = weakReference;
        String q = q();
        C2947y0 c2947y0 = this.u;
        this.D = new N(weakReference, q, (c2947y0 == null || (o = c2947y0.o()) == null) ? false : o.booleanValue());
        this.t = adPlacement;
        InterfaceC2971z5 interfaceC2971z54 = this.j;
        if (interfaceC2971z54 != null) {
            ((A5) interfaceC2971z54).a("S0", D0.a("S0", "TAG", "initTelemetry ", this));
        }
        this.H.put("AdImpressionSuccessful", this.I);
        InterfaceC2971z5 interfaceC2971z55 = this.j;
        if (interfaceC2971z55 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z55).c("S0", "initInternetAvailabilityAdRetry");
        }
        if (this.b == null && (interfaceC2971z53 = this.j) != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z53).c("S0", "adConfig is null");
            Unit unit = Unit.INSTANCE;
        }
        if (this.t.m() == null && (interfaceC2971z52 = this.j) != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z52).c("S0", "placement.placementType is null");
            Unit unit2 = Unit.INSTANCE;
        }
        if (this.t.b() == null && (interfaceC2971z5 = this.j) != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).c("S0", "placement.adType is null");
            Unit unit3 = Unit.INSTANCE;
        }
        AdConfig adConfig = this.b;
        if (adConfig != null && (placementType = this.t.m()) != null && (adTypes = this.t.b()) != null) {
            TimeoutConfigurations$MediationConfig mediationConfig = adConfig.getTimeouts().X();
            String d = Vc.d();
            Intrinsics.checkNotNullParameter(mediationConfig, "mediationConfig");
            Intrinsics.checkNotNullParameter(placementType, "placementType");
            Intrinsics.checkNotNullParameter(adTypes, "adTypes");
            if (placementType.equals("AB")) {
                TimeoutConfigurations$ABConfig ab = mediationConfig.getAb();
                int hashCode = adTypes.hashCode();
                if (hashCode == -1396342996) {
                    if (adTypes.equals("banner")) {
                        banner3 = ab.getBanner();
                        c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner3.getLoadRetryInterval()), AbstractC2938x7.a(d, banner3.getMaxLoadRetries()), AbstractC2938x7.a(d, banner3.getLoadTimeout()), (Integer) null, 24);
                    }
                    banner3 = ab.getBanner();
                    c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner3.getLoadRetryInterval()), AbstractC2938x7.a(d, banner3.getMaxLoadRetries()), AbstractC2938x7.a(d, banner3.getLoadTimeout()), (Integer) null, 24);
                } else if (hashCode == -1052618729) {
                    if (adTypes.equals("native")) {
                        banner3 = ab.getNative();
                        c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner3.getLoadRetryInterval()), AbstractC2938x7.a(d, banner3.getMaxLoadRetries()), AbstractC2938x7.a(d, banner3.getLoadTimeout()), (Integer) null, 24);
                    }
                    banner3 = ab.getBanner();
                    c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner3.getLoadRetryInterval()), AbstractC2938x7.a(d, banner3.getMaxLoadRetries()), AbstractC2938x7.a(d, banner3.getLoadTimeout()), (Integer) null, 24);
                } else if (hashCode == 104431) {
                    if (adTypes.equals("int")) {
                        banner3 = ab.getInt();
                        c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner3.getLoadRetryInterval()), AbstractC2938x7.a(d, banner3.getMaxLoadRetries()), AbstractC2938x7.a(d, banner3.getLoadTimeout()), (Integer) null, 24);
                    }
                    banner3 = ab.getBanner();
                    c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner3.getLoadRetryInterval()), AbstractC2938x7.a(d, banner3.getMaxLoadRetries()), AbstractC2938x7.a(d, banner3.getLoadTimeout()), (Integer) null, 24);
                } else {
                    if (hashCode == 93166550 && adTypes.equals("audio")) {
                        banner3 = ab.getAudio();
                        c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner3.getLoadRetryInterval()), AbstractC2938x7.a(d, banner3.getMaxLoadRetries()), AbstractC2938x7.a(d, banner3.getLoadTimeout()), (Integer) null, 24);
                    }
                    banner3 = ab.getBanner();
                    c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner3.getLoadRetryInterval()), AbstractC2938x7.a(d, banner3.getMaxLoadRetries()), AbstractC2938x7.a(d, banner3.getLoadTimeout()), (Integer) null, 24);
                }
            } else if (placementType.equals("Preload")) {
                TimeoutConfigurations$PreloadConfig preload = mediationConfig.getPreload();
                int hashCode2 = adTypes.hashCode();
                if (hashCode2 == -1396342996) {
                    if (adTypes.equals("banner")) {
                        banner2 = preload.getBanner();
                        c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner2.getLoadRetryInterval()), AbstractC2938x7.a(d, banner2.getMaxLoadRetries()), AbstractC2938x7.a(d, banner2.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner2.getMuttTimeout())), Integer.valueOf(AbstractC2938x7.a(d, banner2.getPreloadTimeout())));
                    }
                    banner2 = preload.getBanner();
                    c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner2.getLoadRetryInterval()), AbstractC2938x7.a(d, banner2.getMaxLoadRetries()), AbstractC2938x7.a(d, banner2.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner2.getMuttTimeout())), Integer.valueOf(AbstractC2938x7.a(d, banner2.getPreloadTimeout())));
                } else if (hashCode2 == -1052618729) {
                    if (adTypes.equals("native")) {
                        banner2 = preload.getNative();
                        c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner2.getLoadRetryInterval()), AbstractC2938x7.a(d, banner2.getMaxLoadRetries()), AbstractC2938x7.a(d, banner2.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner2.getMuttTimeout())), Integer.valueOf(AbstractC2938x7.a(d, banner2.getPreloadTimeout())));
                    }
                    banner2 = preload.getBanner();
                    c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner2.getLoadRetryInterval()), AbstractC2938x7.a(d, banner2.getMaxLoadRetries()), AbstractC2938x7.a(d, banner2.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner2.getMuttTimeout())), Integer.valueOf(AbstractC2938x7.a(d, banner2.getPreloadTimeout())));
                } else if (hashCode2 == 104431) {
                    if (adTypes.equals("int")) {
                        banner2 = preload.getInt();
                        c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner2.getLoadRetryInterval()), AbstractC2938x7.a(d, banner2.getMaxLoadRetries()), AbstractC2938x7.a(d, banner2.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner2.getMuttTimeout())), Integer.valueOf(AbstractC2938x7.a(d, banner2.getPreloadTimeout())));
                    }
                    banner2 = preload.getBanner();
                    c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner2.getLoadRetryInterval()), AbstractC2938x7.a(d, banner2.getMaxLoadRetries()), AbstractC2938x7.a(d, banner2.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner2.getMuttTimeout())), Integer.valueOf(AbstractC2938x7.a(d, banner2.getPreloadTimeout())));
                } else {
                    if (hashCode2 == 93166550 && adTypes.equals("audio")) {
                        banner2 = preload.getAudio();
                        c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner2.getLoadRetryInterval()), AbstractC2938x7.a(d, banner2.getMaxLoadRetries()), AbstractC2938x7.a(d, banner2.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner2.getMuttTimeout())), Integer.valueOf(AbstractC2938x7.a(d, banner2.getPreloadTimeout())));
                    }
                    banner2 = preload.getBanner();
                    c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner2.getLoadRetryInterval()), AbstractC2938x7.a(d, banner2.getMaxLoadRetries()), AbstractC2938x7.a(d, banner2.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner2.getMuttTimeout())), Integer.valueOf(AbstractC2938x7.a(d, banner2.getPreloadTimeout())));
                }
            } else {
                TimeoutConfigurations$NonABConfig nonAb = mediationConfig.getNonAb();
                int hashCode3 = adTypes.hashCode();
                if (hashCode3 == -1396342996) {
                    if (adTypes.equals("banner")) {
                        banner = nonAb.getBanner();
                        c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner.getLoadRetryInterval()), AbstractC2938x7.a(d, banner.getMaxLoadRetries()), AbstractC2938x7.a(d, banner.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner.getMuttTimeout())), 16);
                    }
                    banner = nonAb.getBanner();
                    c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner.getLoadRetryInterval()), AbstractC2938x7.a(d, banner.getMaxLoadRetries()), AbstractC2938x7.a(d, banner.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner.getMuttTimeout())), 16);
                } else if (hashCode3 == -1052618729) {
                    if (adTypes.equals("native")) {
                        banner = nonAb.getNative();
                        c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner.getLoadRetryInterval()), AbstractC2938x7.a(d, banner.getMaxLoadRetries()), AbstractC2938x7.a(d, banner.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner.getMuttTimeout())), 16);
                    }
                    banner = nonAb.getBanner();
                    c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner.getLoadRetryInterval()), AbstractC2938x7.a(d, banner.getMaxLoadRetries()), AbstractC2938x7.a(d, banner.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner.getMuttTimeout())), 16);
                } else if (hashCode3 == 104431) {
                    if (adTypes.equals("int")) {
                        banner = nonAb.getInt();
                        c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner.getLoadRetryInterval()), AbstractC2938x7.a(d, banner.getMaxLoadRetries()), AbstractC2938x7.a(d, banner.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner.getMuttTimeout())), 16);
                    }
                    banner = nonAb.getBanner();
                    c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner.getLoadRetryInterval()), AbstractC2938x7.a(d, banner.getMaxLoadRetries()), AbstractC2938x7.a(d, banner.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner.getMuttTimeout())), 16);
                } else {
                    if (hashCode3 == 93166550 && adTypes.equals("audio")) {
                        banner = nonAb.getAudio();
                        c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner.getLoadRetryInterval()), AbstractC2938x7.a(d, banner.getMaxLoadRetries()), AbstractC2938x7.a(d, banner.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner.getMuttTimeout())), 16);
                    }
                    banner = nonAb.getBanner();
                    c2957y7 = new C2957y7(AbstractC2938x7.a(d, banner.getLoadRetryInterval()), AbstractC2938x7.a(d, banner.getMaxLoadRetries()), AbstractC2938x7.a(d, banner.getLoadTimeout()), Integer.valueOf(AbstractC2938x7.a(d, banner.getMuttTimeout())), 16);
                }
            }
            this.E = new C2663g6(c2957y7);
            this.F = c2957y7;
        }
        V3 v3 = U3.f2447a;
        if (context != null && U3.h == null) {
            U3.h = Float.valueOf(new TextView(context).getTextSize());
            Intrinsics.checkNotNullExpressionValue("U3", "TAG");
        } else {
            Intrinsics.checkNotNullExpressionValue("U3", "TAG");
        }
        n0();
    }

    public final String d(int i) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "getPubContent ", this));
        }
        if (i > 0 && !this.A) {
            return "";
        }
        C2672h b = b(i);
        if (b != null) {
            return b.x();
        }
        return null;
    }

    public void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "setContext ", this));
        }
        this.c = new WeakReference(context);
    }

    public final void e(F0 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "onFetchSuccess ", this));
        }
        v0();
        AdMetaInfo l = l();
        if (l == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z52).b("S0", "ad meta info null. fail");
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2106);
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = this.j;
        if (interfaceC2971z53 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z53).a("S0", "callback - onAdFetchSuccess");
        }
        listener.b(l);
    }

    public final boolean c(int i) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).c("S0", "getAllowAutoRedirectionForIndex " + this + " index - " + i);
        }
        C2672h b = b(i);
        return b != null && b.i();
    }

    public final void c(C2947y0 adSet) {
        Intrinsics.checkNotNullParameter(adSet, "adSet");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "onAdFetchSuccessful ", this));
        }
        if (this.f2420a == 1) {
            this.u = adSet;
        }
        if (!this.o && t() != null) {
            a(adSet);
            return;
        }
        b((short) 2185);
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z52).b("S0", "adUnit is destroyed");
        }
    }

    public void g() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "clear ", this));
        }
        if (this.o) {
            return;
        }
        this.o = true;
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).a("S0", D0.a("S0", "TAG", "clearAdPods ", this));
        }
        if (this.A) {
            h();
            this.g.clear();
            this.w = 0;
            this.x = 0;
            this.z.clear();
        }
        C2663g6 c2663g6 = this.E;
        if (c2663g6 != null) {
            c2663g6.b = 0;
        }
        HashMap hashMap = this.i;
        if (hashMap != null) {
            hashMap.clear();
        }
        k0();
        d((byte) 0);
        InterfaceC2971z5 interfaceC2971z53 = this.j;
        if (interfaceC2971z53 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z53).d("S0", "AdUnit " + this + " state - CREATED");
        }
        A a2 = this.C;
        int hashCode = hashCode();
        a2.getClass();
        SparseArray sparseArray = A.b;
        sparseArray.remove(hashCode);
        Intrinsics.checkNotNullExpressionValue(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "TAG");
        sparseArray.size();
        this.q = false;
        this.n = null;
        this.m = false;
        this.p = false;
        this.r = false;
        this.u = null;
        this.A = false;
    }

    public final void k(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        List<String> c;
        int indexOf = this.g.indexOf(gestureDetectorOnGestureListenerC2634ec);
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).a("S0", "fireLoadAdTokenUrlSuccessful : " + indexOf + ' ' + this);
        }
        C2672h b = b(indexOf);
        if (b == null || (c = b.c(C2672h.LOAD_AD_TOKEN_URL)) == null) {
            return;
        }
        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            C2933x2.f2748a.a(it.next(), true, this.j);
        }
    }

    public final void a(InterfaceC2971z5 logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.j = logger;
        B0 p = p();
        p.getClass();
        Intrinsics.checkNotNullParameter(logger, "logger");
        p.f = logger;
        N n = this.D;
        n.getClass();
        Intrinsics.checkNotNullParameter(logger, "logger");
        n.f = logger;
    }

    public final void d(F0 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "onAdDisplayed ", this));
        }
        AdMetaInfo l = l();
        if (l == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z52).b("S0", "callback onAdDisplayed failed. ad meta info is null");
            }
            a(listener, (short) 85);
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = this.j;
        if (interfaceC2971z53 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z53).a("S0", "callback - onAdDisplayed");
        }
        listener.a(l);
    }

    public int l(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "getCurrentRenderingPodAdIndex ", this));
        }
        if (!this.A) {
            return -1;
        }
        int indexOf = this.g.indexOf(renderView);
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).c("S0", X8.a("S0", "TAG", "getCurrentRenderingPodAdIndex ", indexOf));
        }
        return indexOf;
    }

    public final Q a(int i) {
        String str;
        String str2;
        Boolean o;
        String o2;
        String p;
        String w;
        C2672h b = b(i);
        if (b == null || (str = b.u()) == null) {
            str = AnalyticsConstants.CREATIVE_TYPE_HTML;
        }
        String str3 = str;
        String a2 = (Intrinsics.areEqual(this.t.b(), "banner") || Intrinsics.areEqual(this.t.b(), "audio")) ? this.t.a() : null;
        String b2 = this.t.b();
        boolean b3 = b(b);
        long l = this.t.l();
        boolean c = c(i);
        String e = this.t.e();
        String p2 = b != null ? b.p() : null;
        AdMetaInfo l2 = l();
        String creativeID = l2 != null ? l2.getCreativeID() : null;
        boolean p3 = this.t.p();
        String str4 = creativeID;
        LinkedHashMap linkedHashMap = this.H;
        WatermarkData watermarkData = this.J;
        AdQualityControl e2 = b != null ? b.e() : null;
        byte J = J();
        HashMap hashMap = this.i;
        Set set = hashMap != null ? (Set) hashMap.get(Integer.valueOf(i)) : null;
        C2672h b4 = b(i);
        String s = b4 != null ? b4.s() : null;
        if (b == null || (str2 = b.t()) == null) {
            str2 = "DEFAULT";
        }
        LinkedHashMap linkedHashMap2 = O2.f2380a;
        Set set2 = set;
        String str5 = s;
        C2766mc c2766mc = new C2766mc(((TelemetryConfig) AbstractC2808p5.a("telemetry", "null cannot be cast to non-null type com.inmobi.commons.core.configs.TelemetryConfig", null)).getMaxTemplateEvents());
        Z z = this.t;
        String E = E();
        String str6 = (b == null || (w = b.w()) == null) ? "" : w;
        C2663g6 c2663g6 = this.E;
        boolean z2 = false;
        int i2 = c2663g6 != null ? c2663g6.b : 0;
        C2672h u = u();
        String str7 = (u == null || (p = u.p()) == null) ? "" : p;
        C2672h u2 = u();
        String str8 = (u2 == null || (o2 = u2.o()) == null) ? "" : o2;
        C2947y0 c2947y0 = this.u;
        if (c2947y0 != null && (o = c2947y0.o()) != null) {
            z2 = o.booleanValue();
        }
        return new Q(b2, b3, l, c, str4, p2, str3, a2, this, e, linkedHashMap, Boolean.valueOf(p3), watermarkData, e2, J, set2, str5, str2, new C2685hc(z, E, str6, i2, str7, str8, z2, i, this.I.j, c2766mc, EventTaskParams.STATE_GROUP_DEFAULT), this.j, 2228224);
    }

    public final Pair<String, Short> a(boolean z, boolean z2, boolean z3) {
        Short sh;
        StringBuilder sb = new StringBuilder("Immersive not supported on");
        BitSet bitSet = new BitSet(3);
        ArrayList arrayList = new ArrayList();
        if (!z) {
            arrayList.add(" config");
            bitSet.set(0);
        }
        if (!z2) {
            arrayList.add(" device");
            bitSet.set(1);
        }
        if (!z3) {
            arrayList.add(" ad");
            bitSet.set(2);
        }
        sb.append(CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null));
        Intrinsics.checkNotNullParameter(bitSet, "bitSet");
        if (bitSet.get(0) && bitSet.get(1) && bitSet.get(2)) {
            sh = (short) 2202;
        } else if (bitSet.get(0) && bitSet.get(1)) {
            sh = (short) 2200;
        } else if (bitSet.get(0) && bitSet.get(2)) {
            sh = (short) 2199;
        } else if (bitSet.get(1) && bitSet.get(2)) {
            sh = (short) 2201;
        } else if (bitSet.get(0)) {
            sh = (short) 2196;
        } else if (bitSet.get(1)) {
            sh = (short) 2197;
        } else {
            sh = bitSet.get(2) ? (short) 2198 : null;
        }
        short shortValue = sh != null ? sh.shortValue() : (short) -1;
        if (shortValue == -1) {
            return new Pair<>("Invalid Reason", (short) -1);
        }
        return new Pair<>(sb.toString(), Short.valueOf(shortValue));
    }

    public final void b(InMobiAdRequestStatus requestStatus, boolean z, short s) {
        Intrinsics.checkNotNullParameter(requestStatus, "requestStatus");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).b("S0", "handleAdLoadFailure " + this + " errorCode - " + ((int) s));
        }
        if (this.f2420a == 1 && z) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).b("S0", X8.a("S0", "TAG", "load failed - ", s));
            }
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z53).d("S0", "AdUnit " + this + " state - FAILED");
            }
            d((byte) 3);
            b((byte) 1);
        }
        F0 r = r();
        if (r != null) {
            r.a(this, requestStatus);
        } else {
            InterfaceC2971z5 interfaceC2971z54 = this.j;
            if (interfaceC2971z54 != null) {
                ((A5) interfaceC2971z54).a();
            }
        }
        if (s != 0) {
            b(s);
        }
    }

    public static final void e(S0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (6 == this$0.f2420a) {
            this$0.a(true, (short) 2158);
        }
    }

    public final boolean e(byte b) {
        int Y;
        Integer num;
        long j;
        Integer num2;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "startTimer ", this));
        }
        if (b == 0) {
            C2957y7 c2957y7 = this.F;
            if (c2957y7 != null && (num2 = c2957y7.d) != null) {
                Y = num2.intValue();
                j = Y;
            }
            j = 15000;
        } else if (b == 1) {
            C2957y7 c2957y72 = this.F;
            if (c2957y72 != null) {
                Y = c2957y72.c;
                j = Y;
            }
            j = 15000;
        } else {
            if (b == 2) {
                C2957y7 c2957y73 = this.F;
                if (c2957y73 != null && (num = c2957y73.e) != null) {
                    Y = num.intValue();
                }
                j = 15000;
            } else if (b == 4) {
                C2784ne c2784ne = this.d;
                Intrinsics.checkNotNull(c2784ne);
                Y = c2784ne.Y();
            } else {
                InterfaceC2971z5 interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                    Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                    ((A5) interfaceC2971z52).b("S0", "Invalid value for timeOutScenario passed!. Please pass a valid value");
                }
                return false;
            }
            j = Y;
        }
        C2671ge c2671ge = this.v;
        if (c2671ge != null) {
            Intrinsics.checkNotNullExpressionValue("ge", "TAG");
            if (c2671ge.b.containsKey(Byte.valueOf(b))) {
                Intrinsics.checkNotNullExpressionValue("ge", "TAG");
                Timer timer = (Timer) c2671ge.b.get(Byte.valueOf(b));
                if (timer != null) {
                    timer.cancel();
                    c2671ge.b.remove(Byte.valueOf(b));
                }
            }
            try {
                Timer timer2 = new Timer("ge");
                c2671ge.b.put(Byte.valueOf(b), timer2);
                timer2.schedule(new C2654fe(c2671ge, b), j);
                return true;
            } catch (InternalError e) {
                Intrinsics.checkNotNullExpressionValue("ge", "TAG");
                e.toString();
            } catch (OutOfMemoryError unused) {
                Intrinsics.checkNotNullExpressionValue("ge", "TAG");
                AbstractC2680h7.a((byte) 1, "ge", "Could not execute timer due to OutOfMemory.");
                c2671ge.f2582a.c(b);
            }
        }
        return false;
    }

    public final void a(F0 listener, short s) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "onAdShowFailed ", this));
        }
        c(s);
        listener.d();
    }

    public final void d(C2947y0 adSet) {
        Intrinsics.checkNotNullParameter(adSet, "adSet");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "onAuctionNotClosed ", this));
        }
        if (this.o || t() == null) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).c("S0", D0.a("S0", "TAG", "handleAuctionNotClosed ", this));
        }
        if (this.f2420a == 1) {
            this.u = adSet;
            this.A = adSet != null ? adSet.n() : false;
            F0 r = r();
            if (r != null) {
                r.a(this.t, adSet);
            }
        }
    }

    public void c(String monetizationContext) {
        Intrinsics.checkNotNullParameter(monetizationContext, "monetizationContext");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "setMonetizationContext ", this));
        }
        this.t.b(monetizationContext);
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void i(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", H6.a("S0", "TAG", "RenderView visible, for index ").append(this.g.indexOf(renderView)).append(' ').append(this).toString());
        }
    }

    public final void h() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "destroyAllContainer ", this));
        }
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            a(this, i, false, 2, null);
        }
    }

    public final void f(F0 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "onLoadSuccess ", this));
        }
        AdMetaInfo l = l();
        if (l == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z52).b("S0", "load success - ad unit null");
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2107);
            return;
        }
        b((byte) 1);
        InterfaceC2971z5 interfaceC2971z53 = this.j;
        if (interfaceC2971z53 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z53).a("S0", "callback - onAdLoadSucceeded");
        }
        listener.c(l);
    }

    public final void b(C2947y0 adSet) {
        Intrinsics.checkNotNullParameter(adSet, "adSet");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "loadResponse ", this));
        }
        c(adSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:141:0x024a, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x024f, code lost:
    
        if (r9.has("tracking") != true) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x025b, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual("web", r9.getString("tracking")) == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x025d, code lost:
    
        r28.k = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x031f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(C2672h ad, int i, boolean z) {
        Object obj;
        String str;
        Object obj2;
        Object obj3;
        String str2;
        InterfaceC2971z5 interfaceC2971z5;
        boolean z2;
        InterfaceC2971z5 interfaceC2971z52;
        InterfaceC2971z5 interfaceC2971z53;
        JSONObject c;
        AdConfig.ViewabilityConfig viewability;
        AdConfig.OmidConfig omidConfig;
        HashMap hashMap;
        Intrinsics.checkNotNullParameter(ad, "ad");
        InterfaceC2971z5 interfaceC2971z54 = this.j;
        if (interfaceC2971z54 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            obj = "reason";
            str = "event";
            ((A5) interfaceC2971z54).c("S0", "didParseAdResponseAndExtractData " + this + " - index - " + i);
        } else {
            obj = "reason";
            str = "event";
        }
        boolean z3 = false;
        try {
            c = ad.c();
        } catch (IllegalArgumentException e) {
            e = e;
            obj2 = IronSourceConstants.EVENTS_ERROR_CODE;
        } catch (JSONException e2) {
            e = e2;
            obj2 = IronSourceConstants.EVENTS_ERROR_CODE;
        }
        if (Intrinsics.areEqual("unknown", ad.u())) {
            InterfaceC2971z5 interfaceC2971z55 = this.j;
            if (interfaceC2971z55 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z55).b("S0", "unknown markup type. fail");
            }
            if (z) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(IronSourceConstants.EVENTS_ERROR_CODE, (short) 2163);
                b((Map<String, Object>) hashMap2);
            }
            return false;
        }
        String x = ad.x();
        try {
            try {
            } catch (IllegalArgumentException e3) {
                e = e3;
            }
        } catch (JSONException e4) {
            e = e4;
        }
        if (x.length() > 0) {
            try {
                long j = this.I.f;
                ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
                ad.f(StringsKt.replace$default(x, "@__imm_aft@", String.valueOf(SystemClock.elapsedRealtime() - j), false, 4, (Object) null));
                InterfaceC2971z5 interfaceC2971z56 = this.j;
                if (interfaceC2971z56 != null) {
                    try {
                        Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                        ((A5) interfaceC2971z56).a("S0", "parsing of pub content success");
                    } catch (IllegalArgumentException e5) {
                        e = e5;
                        obj2 = IronSourceConstants.EVENTS_ERROR_CODE;
                        interfaceC2971z53 = this.j;
                        if (interfaceC2971z53 != null) {
                        }
                        S5 s5 = S5.f2425a;
                        C2640f2 c2640f2 = new C2640f2(e);
                        Intrinsics.checkNotNullParameter(c2640f2, str);
                        S5.d.a(c2640f2);
                        if (z) {
                        }
                        z2 = z3;
                        interfaceC2971z52 = this.j;
                        if (interfaceC2971z52 != null) {
                        }
                        return z2;
                    } catch (JSONException e6) {
                        e = e6;
                        obj3 = obj;
                        str2 = str;
                        obj2 = IronSourceConstants.EVENTS_ERROR_CODE;
                        interfaceC2971z5 = this.j;
                        if (interfaceC2971z5 != null) {
                        }
                        S5 s52 = S5.f2425a;
                        C2640f2 c2640f22 = new C2640f2(e);
                        Intrinsics.checkNotNullParameter(c2640f22, str2);
                        S5.d.a(c2640f22);
                        if (z) {
                        }
                        z2 = z3;
                        interfaceC2971z52 = this.j;
                        if (interfaceC2971z52 != null) {
                        }
                        return z2;
                    }
                }
                final Context d = Uc.d();
                HashMap hashMap3 = this.i;
                Intrinsics.checkNotNull(hashMap3);
                if (hashMap3.get(Integer.valueOf(i)) == null) {
                    Integer valueOf = Integer.valueOf(i);
                    HashMap hashMap4 = this.i;
                    Intrinsics.checkNotNull(hashMap4);
                    hashMap4.put(valueOf, new HashSet());
                }
                HashMap hashMap5 = this.i;
                Intrinsics.checkNotNull(hashMap5);
                Set set = (Set) hashMap5.get(Integer.valueOf(i));
                if (set != null && set.isEmpty()) {
                    InterfaceC2971z5 interfaceC2971z57 = this.j;
                    if (interfaceC2971z57 != null) {
                        Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                        ((A5) interfaceC2971z57).c("S0", "empty trackers");
                    }
                    AdConfig adConfig = this.b;
                    Boolean valueOf2 = (adConfig == null || (viewability = adConfig.getViewability()) == null || (omidConfig = viewability.getOmidConfig()) == null) ? null : Boolean.valueOf(omidConfig.isOmidEnabled());
                    InterfaceC2971z5 interfaceC2971z58 = this.j;
                    if (interfaceC2971z58 != null) {
                        Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                        ((A5) interfaceC2971z58).c("S0", "OMID enable - " + valueOf2);
                    }
                    if (Intrinsics.areEqual(valueOf2, Boolean.TRUE) && c != null && c.has("metaInfo")) {
                        InterfaceC2971z5 interfaceC2971z59 = this.j;
                        if (interfaceC2971z59 != null) {
                            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                            ((A5) interfaceC2971z59).c("S0", "checking meta info");
                        }
                        JSONObject jSONObject = c.getJSONObject("metaInfo");
                        if (jSONObject.has("omsdkInfo")) {
                            InterfaceC2971z5 interfaceC2971z510 = this.j;
                            if (interfaceC2971z510 != null) {
                                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                                ((A5) interfaceC2971z510).c("S0", "checking OMSDK meta info");
                            }
                            JSONObject jSONObject2 = jSONObject.getJSONObject("omsdkInfo");
                            if (jSONObject2.has("omidEnabled") && jSONObject2.getBoolean("omidEnabled")) {
                                String string = jSONObject.has("creativeType") ? jSONObject.getString("creativeType") : "unknown";
                                Handler handler = this.l;
                                if (handler != null) {
                                    handler.post(new Runnable() { // from class: com.inmobi.media.S0$$ExternalSyntheticLambda7
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            S0.a(d, this);
                                        }
                                    });
                                }
                                C2833qe c2833qe = new C2833qe((byte) 3);
                                boolean optBoolean = jSONObject2.optBoolean("isolateVerificationScripts");
                                String optString = jSONObject2.optString("customReferenceData");
                                JSONObject optJSONObject = jSONObject2.optJSONObject("macros");
                                byte optInt = (byte) jSONObject2.optInt("impressionType");
                                Intrinsics.checkNotNull(string);
                                Intrinsics.checkNotNull(optString);
                                c2833qe.b = H0.a(string, optString, optBoolean, optJSONObject, optInt);
                                InterfaceC2971z5 interfaceC2971z511 = this.j;
                                if (interfaceC2971z511 != null) {
                                    Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                                    ((A5) interfaceC2971z511).c("S0", "Read out OMID params: " + c2833qe.b);
                                }
                                set.add(c2833qe);
                            }
                        }
                    }
                    if (c != null && c.has("viewability")) {
                        InterfaceC2971z5 interfaceC2971z512 = this.j;
                        if (interfaceC2971z512 != null) {
                            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                            ((A5) interfaceC2971z512).c("S0", "checking viewability info");
                        }
                        JSONArray jSONArray = c.getJSONArray("viewability");
                        Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
                        HashMap a2 = a(jSONArray);
                        if (a2 != null && !a2.isEmpty()) {
                            InterfaceC2971z5 interfaceC2971z513 = this.j;
                            if (interfaceC2971z513 != null) {
                                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                                ((A5) interfaceC2971z513).c("S0", "checking for inmobi trackers");
                            }
                            C2833qe c2833qe2 = new C2833qe((byte) 2);
                            c2833qe2.b = a2;
                            set.add(c2833qe2);
                        }
                    }
                }
                boolean z4 = true;
                z2 = z4;
            } catch (IllegalArgumentException e7) {
                e = e7;
                obj2 = IronSourceConstants.EVENTS_ERROR_CODE;
                z3 = false;
                interfaceC2971z53 = this.j;
                if (interfaceC2971z53 != null) {
                }
                S5 s53 = S5.f2425a;
                C2640f2 c2640f23 = new C2640f2(e);
                Intrinsics.checkNotNullParameter(c2640f23, str);
                S5.d.a(c2640f23);
                if (z) {
                }
                z2 = z3;
                interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                }
                return z2;
            } catch (JSONException e8) {
                e = e8;
                obj3 = obj;
                str2 = str;
                obj2 = IronSourceConstants.EVENTS_ERROR_CODE;
                z3 = false;
                interfaceC2971z5 = this.j;
                if (interfaceC2971z5 != null) {
                }
                S5 s522 = S5.f2425a;
                C2640f2 c2640f222 = new C2640f2(e);
                Intrinsics.checkNotNullParameter(c2640f222, str2);
                S5.d.a(c2640f222);
                if (z) {
                }
                z2 = z3;
                interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                }
                return z2;
            }
            interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z52).a("S0", "Parsing result - " + z2);
            }
            return z2;
        }
        try {
            InterfaceC2971z5 interfaceC2971z514 = this.j;
            if (interfaceC2971z514 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z514).a("S0", "empty punContent - fail");
            }
            if (!z) {
                return false;
            }
            try {
                hashMap = new HashMap();
                obj2 = IronSourceConstants.EVENTS_ERROR_CODE;
            } catch (JSONException e9) {
                e = e9;
                obj2 = IronSourceConstants.EVENTS_ERROR_CODE;
            }
            try {
                hashMap.put(obj2, (short) 2162);
                b((Map<String, Object>) hashMap);
                return false;
            } catch (IllegalArgumentException e10) {
                e = e10;
                z3 = false;
                interfaceC2971z53 = this.j;
                if (interfaceC2971z53 != null) {
                    Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                    ((A5) interfaceC2971z53).a("S0", "Invalid Base64 encoding in received ad.", e);
                }
                S5 s532 = S5.f2425a;
                C2640f2 c2640f232 = new C2640f2(e);
                Intrinsics.checkNotNullParameter(c2640f232, str);
                S5.d.a(c2640f232);
                if (z) {
                    HashMap hashMap6 = new HashMap();
                    hashMap6.put(obj2, (short) 2121);
                    String message = e.getMessage();
                    if (message != null) {
                        hashMap6.put(obj, message);
                    }
                    b((Map<String, Object>) hashMap6);
                }
                z2 = z3;
                interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                }
                return z2;
            } catch (JSONException e11) {
                e = e11;
                obj3 = obj;
                str2 = str;
                z3 = false;
                interfaceC2971z5 = this.j;
                if (interfaceC2971z5 != null) {
                }
                S5 s5222 = S5.f2425a;
                C2640f2 c2640f2222 = new C2640f2(e);
                Intrinsics.checkNotNullParameter(c2640f2222, str2);
                S5.d.a(c2640f2222);
                if (z) {
                }
                z2 = z3;
                interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                }
                return z2;
            }
        } catch (JSONException e12) {
            e = e12;
            obj2 = IronSourceConstants.EVENTS_ERROR_CODE;
            z3 = false;
            obj3 = obj;
            str2 = str;
            interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z5).a("S0", "Exception while parsing received ad.", e);
            }
            S5 s52222 = S5.f2425a;
            C2640f2 c2640f22222 = new C2640f2(e);
            Intrinsics.checkNotNullParameter(c2640f22222, str2);
            S5.d.a(c2640f22222);
            if (z) {
                HashMap hashMap7 = new HashMap();
                hashMap7.put(obj2, (short) 2120);
                String message2 = e.getMessage();
                if (message2 != null) {
                    hashMap7.put(obj3, message2);
                }
                b((Map<String, Object>) hashMap7);
            }
            z2 = z3;
            interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
            }
            return z2;
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void g(final GestureDetectorOnGestureListenerC2634ec renderView) {
        Handler handler;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "onRenderViewSignaledAdFailed ", this));
        }
        if (this.o || t() == null || (handler = this.l) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.inmobi.media.S0$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                S0.b(S0.this, renderView);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(S0 s0) {
        int i;
        String str;
        InterfaceC2971z5 interfaceC2971z5;
        InterfaceC2971z5 interfaceC2971z52 = s0.j;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).a("S0", D0.a("S0", "TAG", "startAdFetchWorker ", s0));
        }
        U0 u0 = s0.I;
        u0.getClass();
        u0.d = SystemClock.elapsedRealtime();
        InterfaceC2971z5 interfaceC2971z53 = s0.j;
        if (interfaceC2971z53 != null) {
            ((A5) interfaceC2971z53).a("S0", D0.a("S0", "TAG", "doAdLoadWork ", s0));
        }
        try {
            s0.d((byte) 1);
            InterfaceC2971z5 interfaceC2971z54 = s0.j;
            if (interfaceC2971z54 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z54).d("S0", "AdUnit " + s0 + " state - LOADING");
            }
            InterfaceC2971z5 interfaceC2971z55 = s0.j;
            if (interfaceC2971z55 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z55).c("S0", "printPublisherTestId " + s0);
            }
            C2881te.f2715a.d();
            i = 0;
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z56 = s0.j;
            if (interfaceC2971z56 != null) {
                ((A5) interfaceC2971z56).b("S0", rf.a(e, H6.a("S0", "TAG", "Load failed with unexpected error: ")));
            }
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            s0.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2000);
        }
        if (s0.e((byte) 0)) {
            A a2 = s0.C;
            int hashCode = s0.hashCode();
            L l = new L(s0, s0.j);
            a2.getClass();
            A.a(hashCode, l);
            if (i != -2) {
                str = "Loading an ad resulted in an unexpected error";
            } else if (i == -1) {
                str = "Ad request skipped as monetization is disabled";
            } else if (i == 0) {
                str = "Fresh ad requested";
            } else if (i == 1) {
                str = "Returning pre-cached ad";
            } else if (i != 2) {
                str = "Unknown return value (" + i + ") from #doAdLoadWork()";
            } else {
                str = "Already Loading";
            }
            interfaceC2971z5 = s0.j;
            if (interfaceC2971z5 == null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z5).c("S0", str);
                return;
            }
            return;
        }
        i = -2;
        if (i != -2) {
        }
        interfaceC2971z5 = s0.j;
        if (interfaceC2971z5 == null) {
        }
    }

    public void d(String podAdContext) {
        Intrinsics.checkNotNullParameter(podAdContext, "podAdContext");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "setPodAdContext ", this));
        }
        if (this.A) {
            this.B = podAdContext;
        }
    }

    public final HashMap a(JSONArray jSONArray) {
        JSONObject jSONObject;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "parseInMobiViewabilityParams ", this));
        }
        try {
            int length = jSONArray.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    jSONObject = null;
                    break;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.has("inmobi")) {
                    jSONObject = jSONObject2.getJSONObject("inmobi");
                    break;
                }
                i++;
            }
            if (jSONObject != null) {
                HashMap hashMap = new HashMap();
                String optString = jSONObject.optString("time");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                int b = b(optString);
                if (b != -1) {
                    hashMap.put("time", Integer.valueOf(b));
                }
                String optString2 = jSONObject.optString(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
                Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
                int b2 = b(optString2);
                if (b2 != -1) {
                    hashMap.put(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, Integer.valueOf(b2));
                }
                String optString3 = jSONObject.optString("pixel");
                Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
                int b3 = b(optString3);
                if (b3 != -1) {
                    hashMap.put("pixel", Integer.valueOf(b3));
                }
                int optInt = jSONObject.optInt("type");
                if (optInt != -1) {
                    hashMap.put("type", Integer.valueOf(optInt));
                    if (optInt == 2) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("frame");
                        if (optJSONArray != null && optJSONArray.length() == 4) {
                            JSONArray optJSONArray2 = jSONObject.optJSONArray("frame");
                            Intrinsics.checkNotNullExpressionValue(optJSONArray2, "optJSONArray(...)");
                            hashMap.put("frame", optJSONArray2);
                            return hashMap;
                        }
                        hashMap.put("frame", new JSONArray("[0,0,0,0]"));
                    }
                }
                return hashMap;
            }
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).b("S0", E0.a(e, H6.a("S0", "TAG", "Exception while parsing MoatParams from response : ")));
            }
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        }
        return null;
    }

    public void a(Z placement, boolean z, short s) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "onAssetAvailabilityChanged ", this));
        }
        if (this.o || t() == null) {
            return;
        }
        if (s != 0) {
            b(s);
        }
        a(placement, z);
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void f(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", H6.a("S0", "TAG", "RenderView completed loading ad content, for index ").append(this.g.indexOf(renderView)).append(' ').append(this).toString());
        }
    }

    public final short c(F0 adUnitEventListener) {
        HashMap a2;
        short s;
        T7 t7;
        Intrinsics.checkNotNullParameter(adUnitEventListener, "adUnitEventListener");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "loadMarkupInContainerNative ", this));
        }
        WeakReference weakReference = new WeakReference(adUnitEventListener);
        try {
            byte J = J();
            JSONObject jSONObject = new JSONObject(L());
            AdConfig adConfig = this.b;
            Intrinsics.checkNotNull(adConfig);
            C2947y0 c2947y0 = this.u;
            if (c2947y0 == null) {
                a2 = null;
            } else {
                boolean z = T9.f2439a;
                a2 = T9.a(c2947y0.h());
            }
            C2811p8 dataModel = new C2811p8(J, jSONObject, adConfig, a2, B0(), this.j);
            C2672h m = m();
            if (!dataModel.f() || t() == null || m == null) {
                return (short) 20;
            }
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z52).a("S0", "creating native ad container");
            }
            Context context = t();
            Intrinsics.checkNotNull(context);
            byte J2 = J();
            String adImpressionId = m.s();
            Set e = e(0);
            AdConfig adConfig2 = this.b;
            Intrinsics.checkNotNull(adConfig2);
            long l = this.t.l();
            boolean c = c(0);
            String creativeId = m.o();
            C2625e3 c2625e3 = new C2625e3(m, this.t.l());
            S6 l0 = l0();
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(dataModel, "dataModel");
            Intrinsics.checkNotNullParameter(adImpressionId, "adImpressionId");
            Intrinsics.checkNotNullParameter(adConfig2, "adConfig");
            Intrinsics.checkNotNullParameter(creativeId, "creativeId");
            if (dataModel.c().contains("VIDEO")) {
                s = 0;
                t7 = new C2562a9(context, J2, dataModel, adImpressionId, e, adConfig2, l, c, creativeId, c2625e3, l0, interfaceC2971z53);
            } else {
                s = 0;
                t7 = new T7(context, J2, dataModel, adImpressionId, e, adConfig2, l, c, creativeId, c2625e3, l0, interfaceC2971z53);
            }
            t7.w = new P0(this, weakReference);
            this.h = t7;
            t7.R = this.H;
            return s;
        } catch (IllegalStateException e2) {
            InterfaceC2971z5 interfaceC2971z54 = this.j;
            if (interfaceC2971z54 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z54).a("S0", "Error while setting video descriptor", e2);
            }
            return (short) 83;
        } catch (JSONException e3) {
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e3);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
            return (short) 13;
        } catch (Exception e4) {
            InterfaceC2971z5 interfaceC2971z55 = this.j;
            if (interfaceC2971z55 != null) {
                ((A5) interfaceC2971z55).b("S0", rf.a(e4, H6.a("S0", "TAG", "Encountered unexpected error in loading ad markup into container: ")));
            }
            S5 s52 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e4, "event"));
            return (short) 88;
        }
    }

    public void a(int i, GestureDetectorOnGestureListenerC2634ec renderView, Context context) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).c("S0", "Show pod ad with index : " + i + " from creative: " + this.g.indexOf(renderView) + ' ' + this);
        }
        if (i >= 0) {
            this.x = i;
        } else {
            this.x++;
        }
    }

    @Override // com.inmobi.media.InterfaceC2553a0
    public void a(GestureDetectorOnGestureListenerC2634ec renderView, Context context) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "closeCurrentPodAd ", this));
        }
    }

    public void b(F0 f0) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "handleAdScreenDisplayed ", this));
        }
    }

    public void a(Z placement, boolean z) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "handleAssetAvailabilityChanged ", this));
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z52).a("S0", "Asset availability changed (" + z + ") for placement ID (" + placement + ')');
        }
    }

    public final void g(int i) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "resetCurrentRenderingIndex ", this));
        }
        this.x = i;
    }

    public final void d(boolean z) {
        this.A = z;
    }

    public void a(C2947y0 adSet) {
        LinkedList<C2672h> f;
        LinkedList<C2672h> f2;
        Intrinsics.checkNotNullParameter(adSet, "adSet");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "handleAdFetchSuccessful ", this));
        }
        if (this.f2420a == 1) {
            this.u = adSet;
            int i = 0;
            this.A = adSet != null ? adSet.n() : false;
            C2947y0 c2947y0 = this.u;
            if (c2947y0 != null && (f2 = c2947y0.f()) != null) {
                i = f2.size();
            }
            this.g = new ArrayList(i);
            C2947y0 c2947y02 = this.u;
            if (c2947y02 != null && (f = c2947y02.f()) != null) {
                for (C2672h c2672h : f) {
                    this.g.add(null);
                }
            }
            C2672h p = adSet.p();
            if (p == null) {
                InterfaceC2971z5 interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                    Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                    ((A5) interfaceC2971z52).b("S0", "top ad is null. failed.");
                }
                b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2119);
                return;
            }
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z53).a("S0", "starting executor. parsing ad response");
            }
            A a2 = this.C;
            int hashCode = hashCode();
            C2893ua c2893ua = new C2893ua(this, p, adSet, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), this.j);
            a2.getClass();
            A.a(hashCode, c2893ua);
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = this.j;
        if (interfaceC2971z54 != null) {
            ((A5) interfaceC2971z54).b("S0", H6.a("S0", "TAG", "incorrect state - ").append((int) this.f2420a).toString());
        }
        b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2118);
    }

    public final void f() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "checkInteractiveAndSignal ", this));
        }
        if (this.m && this.p && this.q) {
            r0();
        }
    }

    public static final void b(S0 this$0, GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(renderView, "$renderView");
        this$0.a(renderView, (short) 2137);
    }

    public void b(final GestureDetectorOnGestureListenerC2634ec renderView, final short s) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "onRenderViewError ", this));
        }
        if (this.o || t() == null) {
            return;
        }
        try {
            Handler handler = this.l;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.inmobi.media.S0$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        S0.a(S0.this, renderView, s);
                    }
                });
            }
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).b("S0", rf.a(e, H6.a("S0", "TAG", "Loading ad markup into container encountered an unexpected error: ")));
            }
        }
    }

    @Override // com.inmobi.media.InterfaceC2553a0
    public boolean a(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 == null) {
            return false;
        }
        ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "hasNextAdInAdPod ", this));
        return false;
    }

    public static final void c(S0 this$0, GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(renderView, "$renderView");
        this$0.m(renderView);
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void c() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "onAdScreenDisplayFailed ", this));
        }
        if (this.o || t() == null) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z52).b("S0", "Ad failed to display");
        }
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.inmobi.media.S0$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    S0.e(S0.this);
                }
            });
        }
    }

    public final void c(HashMap hashMap) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "constructTelemetryPayload ", this));
        }
        hashMap.put("adType", q());
        hashMap.put("networkType", L3.q());
        hashMap.put("plId", Long.valueOf(this.t.l()));
        String m = this.t.m();
        if (m != null) {
            hashMap.put("plType", m);
        }
    }

    public final void c(short s) {
        C2672h m;
        Boolean o;
        String p;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "submitAdShowFailed ", this));
        }
        HashMap hashMap = new HashMap();
        long j = this.I.e;
        ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
        hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Short.valueOf(s));
        hashMap.put("markupType", E());
        if (this.A) {
            m = b(this.x);
        } else {
            m = m();
        }
        if (m != null && (p = m.p()) != null) {
            hashMap.put("creativeType", "\"" + p + '\"');
        }
        C2947y0 c2947y0 = this.u;
        if (c2947y0 != null && (o = c2947y0.o()) != null) {
            hashMap.put("isRewarded", o);
        }
        if (S().length() > 0) {
            hashMap.put("metadataBlob", S());
        }
        c(hashMap);
        c((Map) hashMap);
        c("AdShowFailed", hashMap);
    }

    public void a(boolean z, InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "onDidParseAfterFetch ", this));
        }
        if (z) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z52).a("S0", "Ad fetch successful");
            }
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z53).d("S0", "AdUnit " + this + " state - AVAILABLE");
            }
            d((byte) 2);
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = this.j;
        if (interfaceC2971z54 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z54).b("S0", "onComplete parse success");
        }
        b(status, true, (short) 0);
    }

    @Override // com.inmobi.media.InterfaceC2636ee
    public void a(byte b) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "onTimeOut ", this));
        }
        if (b == 0) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).a("S0", H6.a("S0", "TAG", "AdRequestTimeOut by timer, Adstate=").append((int) this.f2420a).toString());
            }
            if (this.f2420a != 3) {
                a(this.t, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_TIMED_OUT), (short) 2109);
                return;
            }
            return;
        }
        if (b != 2 && b != 1) {
            if (b == 4) {
                InterfaceC2971z5 interfaceC2971z53 = this.j;
                if (interfaceC2971z53 != null) {
                    Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                    ((A5) interfaceC2971z53).a("S0", "Show RequestTimeOut by show timer");
                }
                F0 r = r();
                if (r != null) {
                    r.g();
                    return;
                }
                return;
            }
            if (b == 3) {
                InterfaceC2971z5 interfaceC2971z54 = this.j;
                if (interfaceC2971z54 != null) {
                    Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                    ((A5) interfaceC2971z54).a("S0", "Bitmap TimeOut not handled here");
                    return;
                }
                return;
            }
            InterfaceC2971z5 interfaceC2971z55 = this.j;
            if (interfaceC2971z55 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z55).a("S0", "Unknown TimeOut ignored");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z56 = this.j;
        if (interfaceC2971z56 != null) {
            ((A5) interfaceC2971z56).a("S0", H6.a("S0", "TAG", "Internal LoadTimeOut by timer, Adstate=").append((int) this.f2420a).toString());
        }
        if (this.f2420a != 3) {
            this.G.removeCallbacksAndMessages(null);
            InterfaceC2971z5 interfaceC2971z57 = this.j;
            if (interfaceC2971z57 != null) {
                ((A5) interfaceC2971z57).a("S0", H6.a("S0", "TAG", "adUnitEventListener=").append(r()).append(", Adstate=").append((int) this.f2420a).toString());
            }
            byte b2 = this.f2420a;
            if (2 == b2) {
                m0();
                boolean z = T9.f2439a;
                b(T9.a(false) == null ? (short) 2139 : (short) 2203);
                F0 r2 = r();
                if (r2 != null) {
                    r2.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                    return;
                }
                return;
            }
            if (1 == b2) {
                m0();
                b((short) 2138);
                F0 r3 = r();
                if (r3 != null) {
                    r3.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_TIMED_OUT));
                }
            }
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void b(HashMap<Object, Object> rewards) {
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "onAdRewardActionCompleted ", this));
        }
        if (this.o || t() == null) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z52).a("S0", "Ad reward action completed. Params:" + rewards);
        }
        F0 r = r();
        if (r != null) {
            r.b(rewards);
        }
    }

    public final void a(Z placement, InMobiAdRequestStatus requestStatus, short s) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(requestStatus, "requestStatus");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "onAdFetchFailed ", this));
        }
        if (!this.o && t() != null && this.f2420a != 3) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).c("S0", D0.a("S0", "TAG", "handleMarkupFetchFailure ", this));
            }
            try {
                if (Intrinsics.areEqual(this.t, placement) && this.f2420a == 1) {
                    InterfaceC2971z5 interfaceC2971z53 = this.j;
                    if (interfaceC2971z53 != null) {
                        Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                        ((A5) interfaceC2971z53).b("S0", "Failed to fetch ad for placement id: " + placement + ", reason - " + requestStatus.getMessage());
                    }
                    String str = "MarkupFetch failed reason is: " + requestStatus.getMessage();
                    InterfaceC2971z5 interfaceC2971z54 = this.j;
                    if (interfaceC2971z54 != null) {
                        Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                        ((A5) interfaceC2971z54).b("S0", str);
                    }
                    InterfaceC2971z5 interfaceC2971z55 = this.j;
                    if (interfaceC2971z55 != null) {
                        Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                        ((A5) interfaceC2971z55).d("S0", "AdUnit " + this + " state - FAILED");
                    }
                    d((byte) 3);
                    b((byte) 1);
                    if (s != 0) {
                        a(s);
                    }
                    F0 r = r();
                    if (r != null) {
                        r.a(requestStatus);
                        return;
                    }
                    InterfaceC2971z5 interfaceC2971z56 = this.j;
                    if (interfaceC2971z56 != null) {
                        ((A5) interfaceC2971z56).a();
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception e) {
                InterfaceC2971z5 interfaceC2971z57 = this.j;
                if (interfaceC2971z57 != null) {
                    Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                    ((A5) interfaceC2971z57).a("S0", "onAdFetchFailed with error: ", e);
                }
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e, "event"));
                return;
            }
        }
        InterfaceC2971z5 interfaceC2971z58 = this.j;
        if (interfaceC2971z58 != null) {
            ((A5) interfaceC2971z58).b("S0", H6.a("S0", "TAG", "callback ignored - isDestroyed - ").append(this.o).append(" context - ").append(t()).append(" state- ").append((int) this.f2420a).toString());
        }
    }

    public final void c(Map map) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "updateIdsInTelemetryPayload ", this));
        }
        C2672h m = m();
        if (m != null) {
            map.put("creativeId", "\"" + m.o() + '\"');
            map.put("impressionId", "\"" + m.s() + '\"');
        }
    }

    public final void b(short s) {
        long j;
        long elapsedRealtime;
        Boolean o;
        String p;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "submitAdLoadFailedEvent ", this));
        }
        HashMap hashMap = new HashMap();
        if (s == 2138 || s == 2109) {
            j = this.I.d;
            ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
            elapsedRealtime = SystemClock.elapsedRealtime();
        } else if (s == 2139) {
            j = this.I.g;
            ScheduledExecutorService scheduledExecutorService2 = Ie.f2319a;
            elapsedRealtime = SystemClock.elapsedRealtime();
        } else {
            j = this.I.c;
            ScheduledExecutorService scheduledExecutorService3 = Ie.f2319a;
            elapsedRealtime = SystemClock.elapsedRealtime();
        }
        hashMap.put("latency", Long.valueOf(elapsedRealtime - j));
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Short.valueOf(s));
        hashMap.put("markupType", E());
        C2672h u = u();
        if (u != null && (p = u.p()) != null) {
            hashMap.put("creativeType", "\"" + p + '\"');
        }
        C2663g6 c2663g6 = this.E;
        if (c2663g6 != null) {
            hashMap.put("retryCount", Integer.valueOf(c2663g6.b));
        }
        C2947y0 c2947y0 = this.u;
        if (c2947y0 != null && (o = c2947y0.o()) != null) {
            hashMap.put("isRewarded", o);
        }
        if (S().length() > 0) {
            hashMap.put("metadataBlob", S());
        }
        c(hashMap);
        c((Map) hashMap);
        c("AdLoadFailed", hashMap);
    }

    public final void a(boolean z, short s) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).b("S0", "handleAdShowFailure " + this + " errorCode - " + ((int) s));
        }
        if (z) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z52).d("S0", "AdUnit " + this + " state - FAILED");
            }
            d((byte) 3);
            b((byte) 4);
        }
        F0 r = r();
        if (r != null) {
            r.d();
        }
        if (s != 0) {
            c(s);
        }
    }

    public final void a(InMobiAdRequestStatus requestStatus, boolean z, short s) {
        Intrinsics.checkNotNullParameter(requestStatus, "requestStatus");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).b("S0", "handleAdFetchFailure " + this + " errorCode - " + ((int) s));
        }
        if (this.f2420a == 3 && z) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z52).d("S0", "AdUnit " + this + " state - FAILED");
            }
            d((byte) 3);
            b((byte) 1);
        }
        F0 r = r();
        if (r != null) {
            r.a(this, requestStatus);
        }
        if (s != 0) {
            a(s);
        }
    }

    public final void a(Map<String, String> map) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).c("S0", "setPublisherSuppliedExtras " + this + " - " + map);
        }
        this.t.a(map);
    }

    public final void a(final JSONObject responseJson) {
        Intrinsics.checkNotNullParameter(responseJson, "responseJson");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "onAuctionClosed ", this));
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.S0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                S0.a(S0.this, responseJson);
            }
        });
    }

    public final void c(String eventType, Map<String, Object> kv) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(kv, "kv");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "submitTelemetryEvent ", this));
        }
        Pd pd = Pd.f2401a;
        Pd.b(eventType, kv, Td.f2443a);
    }

    public final void b(Map<String, Object> payload) {
        Boolean o;
        String p;
        Intrinsics.checkNotNullParameter(payload, "payload");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "submitServerError ", this));
        }
        if (this.e == null) {
            return;
        }
        if (payload.get("reason") == null) {
            payload.put("reason", "");
        }
        C2672h u = u();
        if (u != null && (p = u.p()) != null) {
            payload.put("creativeType", "\"" + p + '\"');
        }
        C2663g6 c2663g6 = this.E;
        if (c2663g6 != null) {
            payload.put("retryCount", Integer.valueOf(c2663g6.b));
        }
        C2947y0 c2947y0 = this.u;
        if (c2947y0 != null && (o = c2947y0.o()) != null) {
            payload.put("isRewarded", o);
        }
        c(payload);
        B0 b0 = this.e;
        Intrinsics.checkNotNull(b0);
        b0.a(payload);
    }

    public static final void a(S0 this$0, JSONObject responseJson) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(responseJson, "$responseJson");
        A a2 = this$0.C;
        int hashCode = this$0.hashCode();
        C2948y1 c2948y1 = new C2948y1(this$0, responseJson, this$0.j);
        a2.getClass();
        A.a(hashCode, c2948y1);
    }

    public final void a(final Function0 onSuccess, final Function1 onMaxRetryReached) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onMaxRetryReached, "onMaxRetryReached");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        Object obj = null;
        if (interfaceC2971z5 != null) {
            StringBuilder a2 = H6.a("S0", "TAG", "loadWithRetry ");
            C2663g6 c2663g6 = this.E;
            ((A5) interfaceC2971z5).c("S0", a2.append(c2663g6 != null ? Integer.valueOf(c2663g6.b) : null).toString());
        }
        C2663g6 c2663g62 = this.E;
        if (c2663g62 != null) {
            boolean z = T9.f2439a;
            EnumC2790o4 a3 = T9.a(false);
            if (a3 == null) {
                obj = C2877ta.f2712a;
            } else {
                int i = c2663g62.b + 1;
                c2663g62.b = i;
                if (i >= c2663g62.f2578a.b) {
                    obj = new C2777n7(a3);
                } else {
                    obj = C2926wb.f2743a;
                }
            }
        }
        if (obj instanceof C2777n7) {
            onMaxRetryReached.invoke(((C2777n7) obj).f2649a);
            return;
        }
        if (obj instanceof C2877ta) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z52).c("S0", "load with retry success");
            }
            onSuccess.invoke();
            return;
        }
        if (!(obj instanceof C2926wb)) {
            if (obj == null) {
                InterfaceC2971z5 interfaceC2971z53 = this.j;
                if (interfaceC2971z53 != null) {
                    Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                    ((A5) interfaceC2971z53).c("S0", "shouldProceedToLoad result null. starting as if we have internet.");
                }
                onSuccess.invoke();
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = this.j;
        if (interfaceC2971z54 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z54).c("S0", "load failed, retrying");
        }
        this.G.postDelayed(new Runnable() { // from class: com.inmobi.media.S0$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                S0.a(S0.this, onSuccess, onMaxRetryReached);
            }
        }, this.F != null ? r7.f2762a : 1000L);
    }

    public static final void a(S0 this$0, Function0 onSuccess, Function1 onMaxRetryReached) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onSuccess, "$onSuccess");
        Intrinsics.checkNotNullParameter(onMaxRetryReached, "$onMaxRetryReached");
        InterfaceC2971z5 interfaceC2971z5 = this$0.j;
        if (interfaceC2971z5 != null) {
            StringBuilder a2 = H6.a("S0", "TAG", "Loading from retry Handler ");
            C2663g6 c2663g6 = this$0.E;
            ((A5) interfaceC2971z5).c("S0", a2.append(c2663g6 != null ? Integer.valueOf(c2663g6.b) : null).toString());
        }
        this$0.a(onSuccess, onMaxRetryReached);
    }

    public void c(byte b) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).b("S0", D0.a("S0", "TAG", "onOOM ", this));
        }
        if (b == 0) {
            a(this.t, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY), (short) 2110);
            return;
        }
        if (b == 2 || b == 1) {
            byte b2 = this.f2420a;
            if (b2 == 0 || 1 == b2 || 2 == b2) {
                InterfaceC2971z5 interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                    Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                    ((A5) interfaceC2971z52).a("S0", "onOOM INTERNAL_LOAD_TIME_OUT or PRE_LOAD_TIME_OUT");
                }
                this.G.removeCallbacksAndMessages(null);
                m0();
                b((short) 2112);
                F0 r = r();
                if (r != null) {
                    r.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY));
                    return;
                }
                return;
            }
            return;
        }
        if (b == 4) {
            F0 r2 = r();
            if (r2 != null) {
                r2.g();
                return;
            }
            return;
        }
        if (b == 3) {
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                ((A5) interfaceC2971z53).a("S0", X8.a("S0", "TAG", "OOM Timeout scenario ignored for : ", b));
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = this.j;
        if (interfaceC2971z54 != null) {
            ((A5) interfaceC2971z54).a("S0", X8.a("S0", "TAG", "OOM Timeout scenario ignored for : ", b));
        }
    }

    public final void b(long j) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "submitAdGetSignalsSucceeded ", this));
        }
        this.r = false;
        HashMap hashMap = new HashMap();
        hashMap.put("adType", q());
        hashMap.put("latency", Long.valueOf(System.currentTimeMillis() - j));
        hashMap.put("networkType", L3.q());
        c("AdGetSignalsSucceeded", hashMap);
    }

    public void a(byte[] bArr) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "load response ", this));
        }
        U0 u0 = this.I;
        u0.getClass();
        u0.c = SystemClock.elapsedRealtime();
        U0 u02 = this.I;
        u02.getClass();
        u02.h = SystemClock.elapsedRealtime();
        if (Y()) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z52).a("S0", "isBlockingStateForLoadWithResponse - blocking");
                return;
            }
            return;
        }
        if (bArr != null && bArr.length != 0) {
            if (this.s == null) {
                this.s = new C2598ca(this);
            }
            O0 o0 = new O0(this, bArr);
            if (p0()) {
                InterfaceC2971z5 interfaceC2971z53 = this.j;
                if (interfaceC2971z53 != null) {
                    Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                    ((A5) interfaceC2971z53).a("S0", "skipping internet check on load(byte[])");
                }
                o0.invoke();
                return;
            }
            InterfaceC2971z5 interfaceC2971z54 = this.j;
            if (interfaceC2971z54 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z54).a("S0", "starting load with retry");
            }
            a(o0, new N0(this));
            return;
        }
        b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INVALID_RESPONSE_IN_LOAD), true, (short) 2143);
        InterfaceC2971z5 interfaceC2971z55 = this.j;
        if (interfaceC2971z55 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z55).a("S0", "null response. failing");
        }
    }

    public final void a(InMobiAdRequestStatus requestStatus, short s) {
        Intrinsics.checkNotNullParameter(requestStatus, "requestStatus");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).b("S0", "loadResponseFailed " + this + " errorCode - " + ((int) s));
        }
        b(requestStatus, true, s);
    }

    public final boolean a(F0 f0, long j) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "isBlockingStateForGetSignals ", this));
        }
        if (this.r) {
            AbstractC2680h7.a((byte) 2, "InMobi", "getSignals() call is already in progress. Please wait for its execution to get complete");
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z52).b("S0", "getSignals() call is already in progress. Please wait for its execution to get complete");
            }
            return true;
        }
        if (!f0()) {
            return false;
        }
        if (f0 != null) {
            f0.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES));
        }
        a(2007, j);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005f, code lost:
    
        if (r6.equals("ServerNoFill") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x008a, code lost:
    
        r0 = r5.E;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008c, code lost:
    
        if (r0 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008e, code lost:
    
        r7.put("retryCount", java.lang.Integer.valueOf(r0.b));
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
    
        if (r6.equals("AdLoadFailed") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
    
        if (r6.equals("AdLoadSuccessful") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
    
        if (r6.equals("ServerError") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007f, code lost:
    
        if (r6.equals("ServerFill") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        if (r6.equals("RenderSuccess") != false) goto L32;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String eventType, Map<String, Object> kv) {
        C2672h u;
        String p;
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(kv, "kv");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).c("S0", "onTelemetryEvent " + this + " adState=" + ((int) this.f2420a));
        }
        byte b = this.f2420a;
        if (b == 3 || b == 8) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).c("S0", I6.a("S0", "TAG", "addRetryCountToTelemetryEvent event - ", eventType));
        }
        switch (eventType.hashCode()) {
            case -1959333523:
                break;
            case 167123846:
                break;
            case 885222501:
                break;
            case 925075267:
                break;
            case 1881615718:
                break;
            case 1925668903:
                break;
        }
        if ((Intrinsics.areEqual(eventType, "ServerFill") ? true : Intrinsics.areEqual(eventType, "ServerError")) && (u = u()) != null && (p = u.p()) != null) {
            kv.put("creativeType", p);
        }
        c(eventType, kv);
    }

    public final void b(byte b) {
        C2671ge c2671ge;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "cancelTimer ", this));
        }
        if (b == 1 && (c2671ge = this.v) != null) {
            Intrinsics.checkNotNullExpressionValue("ge", "TAG");
            Timer timer = (Timer) c2671ge.b.get((byte) 2);
            if (timer != null) {
                timer.cancel();
                c2671ge.b.remove((byte) 2);
            }
        }
        C2671ge c2671ge2 = this.v;
        if (c2671ge2 != null) {
            Intrinsics.checkNotNullExpressionValue("ge", "TAG");
            Timer timer2 = (Timer) c2671ge2.b.get(Byte.valueOf(b));
            if (timer2 != null) {
                timer2.cancel();
                c2671ge2.b.remove(Byte.valueOf(b));
            }
        }
    }

    public final void a(WeakReference<F0> listenerWeakReference, short s, InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(listenerWeakReference, "listenerWeakReference");
        Intrinsics.checkNotNullParameter(status, "status");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "onLoadAdMarkupFailed ", this));
        }
        d((byte) 3);
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z52).d("S0", "AdUnit " + this + " state - FAILED");
        }
        b((byte) 1);
        if (this.o) {
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z53).b("S0", "AdUnit destroyed while onLoadAdMarkupFailed");
                return;
            }
            return;
        }
        F0 f0 = listenerWeakReference.get();
        if (f0 != null) {
            if (Intrinsics.areEqual("int", q())) {
                a(f0, s);
                return;
            } else {
                b(s);
                f0.a(this, status);
                return;
            }
        }
        InterfaceC2971z5 interfaceC2971z54 = this.j;
        if (interfaceC2971z54 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z54).b("S0", "Listener was garbage collected.Unable to give callback");
        }
    }

    public void a(F0 f0) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "handleAdScreenDismissed ", this));
        }
    }

    public final void a(WatermarkData watermarkData) {
        Intrinsics.checkNotNullParameter(watermarkData, "watermarkData");
        this.J = watermarkData;
        GestureDetectorOnGestureListenerC2634ec w = w();
        if (w != null) {
            w.setWatermark(watermarkData);
        }
    }

    public static /* synthetic */ void a(S0 s0, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: destroyContainer");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        s0.a(i, z);
    }

    public final void a(int i, boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).a("S0", "Destroying container for index " + i + ' ' + this);
        }
        ArrayList list = this.g;
        Intrinsics.checkNotNullParameter(list, "list");
        if (i < 0 || i >= list.size()) {
            return;
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) this.g.get(i);
        if (gestureDetectorOnGestureListenerC2634ec != null) {
            gestureDetectorOnGestureListenerC2634ec.E0.set(z);
            gestureDetectorOnGestureListenerC2634ec.stopLoading();
            gestureDetectorOnGestureListenerC2634ec.b();
        }
        this.g.set(i, null);
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void a(GestureDetectorOnGestureListenerC2634ec renderView, String trackerName, Map<String, String> macros) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullParameter(trackerName, "trackerName");
        Intrinsics.checkNotNullParameter(macros, "macros");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).a("S0", "fireLandingPageTracker " + trackerName + ' ' + this);
        }
        C2672h b = b(this.g.indexOf(renderView));
        if (b != null) {
            List<String> c = b.c(trackerName);
            if (c == null) {
                return;
            }
            for (String str : c) {
                String str2 = str;
                for (Map.Entry<String, String> entry : macros.entrySet()) {
                    str2 = StringsKt.replace$default(str2, entry.getKey(), entry.getValue(), false, 4, (Object) null);
                }
                C2933x2.f2748a.a(str2, true, this.j);
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z52).a("S0", "fireLandingPageTracker failed");
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void a(String log) {
        Intrinsics.checkNotNullParameter(log, "log");
        F0 r = r();
        if (r != null) {
            r.a(log);
        }
    }

    public final void a(GestureDetectorOnGestureListenerC2634ec renderView, int i) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        this.g.add(i, renderView);
        this.z.add(Integer.valueOf(i));
    }

    public final void b(int i, boolean z) {
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "fireAdPodShowResult ", this));
        }
        ArrayList list = this.g;
        Intrinsics.checkNotNullParameter(list, "list");
        if (i < 0 || i >= list.size() || (gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) this.g.get(i)) == null) {
            return;
        }
        gestureDetectorOnGestureListenerC2634ec.b(z);
    }

    public void a(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec, short s) {
        List<String> c;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).b("S0", H6.a("S0", "TAG", "Render view signaled ad failed, for index ").append(this.g.indexOf(gestureDetectorOnGestureListenerC2634ec)).append(' ').append(this).toString());
        }
        if (gestureDetectorOnGestureListenerC2634ec == null || !Intrinsics.areEqual(gestureDetectorOnGestureListenerC2634ec.getMarkupType(), "htmlUrl")) {
            return;
        }
        int indexOf = this.g.indexOf(gestureDetectorOnGestureListenerC2634ec);
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z52).b("S0", "fireLoadAdTokenUrlFailed : " + indexOf + ' ' + this);
        }
        C2672h b = b(indexOf);
        if (b == null || (c = b.c(C2672h.LOAD_AD_TOKEN_URL_FAILURE)) == null) {
            return;
        }
        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            C2933x2.f2748a.a(it.next(), true, this.j);
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void b(GestureDetectorOnGestureListenerC2634ec renderView) {
        List<String> c;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "fireClickTracker ", this));
        }
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        C2672h b = b(this.g.indexOf(renderView));
        if (((b != null ? b.p() : null) != null && Intrinsics.areEqual(b.p(), "video")) || b == null || (c = b.c("click")) == null) {
            return;
        }
        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            C2933x2.f2748a.a(it.next(), true, this.j);
        }
    }

    public static final void a(S0 this$0, GestureDetectorOnGestureListenerC2634ec renderView, short s) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(renderView, "$renderView");
        this$0.a(renderView, s);
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void a(HashMap<Object, Object> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "onAdInteraction ", this));
        }
        if (this.o || t() == null) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z52).a("S0", "Ad interaction. Params: " + params);
        }
        F0 r = r();
        if (r != null) {
            r.a(params);
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void c(GestureDetectorOnGestureListenerC2634ec renderView) {
        List<String> c;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "fireImpressionTracker ", this));
        }
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        C2672h b = b(this.g.indexOf(renderView));
        if (((b != null ? b.p() : null) != null && Intrinsics.areEqual(b.p(), "video")) || b == null || (c = b.c("impression")) == null) {
            return;
        }
        for (String str : c) {
            Yd telemetryOnAdImpression = renderView.getTelemetryOnAdImpression();
            telemetryOnAdImpression.getClass();
            Intrinsics.checkNotNullParameter("adResponseTracker", "<set-?>");
            telemetryOnAdImpression.e = "adResponseTracker";
            C2933x2.f2748a.b(str, true, (Z1) new M(this.D, telemetryOnAdImpression), this.j);
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void a(final Yd telemetryOnAdImpression) {
        Intrinsics.checkNotNullParameter(telemetryOnAdImpression, "telemetryOnAdImpression");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "onImpressionFiredFromTemplate ", this));
        }
        telemetryOnAdImpression.getClass();
        Intrinsics.checkNotNullParameter("imraid_impressionFired", "<set-?>");
        telemetryOnAdImpression.e = "imraid_impressionFired";
        if (!this.o && t() != null) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z52).a("S0", "onImpressionFiredFromTemplate");
            }
            Handler handler = this.l;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.inmobi.media.S0$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        S0.a(S0.this, telemetryOnAdImpression);
                    }
                });
                return;
            }
            return;
        }
        telemetryOnAdImpression.b();
    }

    public static final void a(S0 this$0, Yd telemetryOnAdImpression) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(telemetryOnAdImpression, "$telemetryOnAdImpression");
        this$0.D.a(telemetryOnAdImpression);
    }

    @Override // com.inmobi.media.AbstractC2669gc, com.inmobi.media.Fe
    public void a() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "onUserLeaveApplication ", this));
        }
        if (this.o || t() == null) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z52).a("S0", "User left application");
        }
        F0 r = r();
        if (r != null) {
            r.h();
        }
    }

    public final void a(short s) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "submitAdLoadDroppedAtSDK ", this));
        }
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Short.valueOf(s));
        c(hashMap);
        c("AdLoadDroppedAtSDK", hashMap);
    }

    public final void a(int i, long j) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "submitAdGetSignalsFailed ", this));
        }
        this.r = false;
        HashMap hashMap = new HashMap();
        hashMap.put("adType", q());
        hashMap.put("latency", Long.valueOf(System.currentTimeMillis() - j));
        hashMap.put("networkType", L3.q());
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        c("AdGetSignalsFailed", hashMap);
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void a(String eventType, Map<String, Object> kv) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(kv, "kv");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "onRenderViewRequestedAction ", this));
        }
        c(eventType, kv);
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x03b1, code lost:
    
        if (r6 == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x022e, code lost:
    
        if (r6 == null) goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C2672h ad) {
        String str;
        boolean z;
        HashMap a2;
        C2613d8 c2613d8;
        String str2;
        VerificationScriptResource createVerificationScriptResourceWithoutParameters;
        Object obj;
        HashMap a3;
        String str3;
        VerificationScriptResource createVerificationScriptResourceWithoutParameters2;
        AdConfig.ViewabilityConfig viewability;
        Intrinsics.checkNotNullParameter(ad, "ad");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "initOmidForAd ", this));
        }
        Context t = t();
        AdConfig adConfig = this.b;
        AdConfig.OmidConfig omidConfig = (adConfig == null || (viewability = adConfig.getViewability()) == null) ? null : viewability.getOmidConfig();
        if (omidConfig == null || omidConfig.isOmidEnabled()) {
            AbstractC2780na.f2651a.getClass();
            if (Omid.isActive()) {
                boolean z2 = ad instanceof W8;
                Set e = e(0);
                if (e != null) {
                    Iterator it = e.iterator();
                    while (it.hasNext()) {
                        C2833qe c2833qe = (C2833qe) it.next();
                        if (3 == c2833qe.f2687a) {
                            String str4 = "macros";
                            Context context = t;
                            boolean z3 = z2;
                            String str5 = "OMID_VIEWABILITY";
                            Iterator it2 = it;
                            if ("video" == c2833qe.b.get("creativeType") && z3) {
                                W8 w8 = (W8) ad;
                                InterfaceC2971z5 interfaceC2971z52 = this.j;
                                if (interfaceC2971z52 != null) {
                                    obj = "omidAdSession";
                                    ((A5) interfaceC2971z52).b("S0", D0.a("S0", "TAG", "initOmidForNativeVideoAd ", this));
                                } else {
                                    obj = "omidAdSession";
                                }
                                try {
                                    InterfaceC2971z5 interfaceC2971z53 = this.j;
                                    if (interfaceC2971z53 != null) {
                                        Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                                        ((A5) interfaceC2971z53).a("S0", "Processing OMID meta data to bootstrap impression tracking for this ad response");
                                    }
                                    String str6 = w8.f2470a;
                                    String str7 = w8.b;
                                    String str8 = w8.c;
                                    ArrayList arrayList = w8.d;
                                    ArrayList arrayList2 = w8.e;
                                    AdConfig adConfig2 = this.b;
                                    Intrinsics.checkNotNull(adConfig2);
                                    Ue ue = new Ue(str6, str7, str8, arrayList, arrayList2, adConfig2.getVastVideo());
                                    byte J = J();
                                    String L = L();
                                    Intrinsics.checkNotNull(L);
                                    JSONObject pubContent = new JSONObject(L);
                                    AdConfig adConfig3 = this.b;
                                    Intrinsics.checkNotNull(adConfig3);
                                    C2947y0 c2947y0 = this.u;
                                    if (c2947y0 == null) {
                                        a3 = null;
                                    } else {
                                        boolean z4 = T9.f2439a;
                                        a3 = T9.a(c2947y0.h());
                                    }
                                    InterfaceC2971z5 interfaceC2971z54 = this.j;
                                    Intrinsics.checkNotNullParameter(pubContent, "pubContent");
                                    Intrinsics.checkNotNullParameter(adConfig3, "adConfig");
                                    C2811p8 c2811p8 = new C2811p8(J, pubContent, null, false, adConfig3, a3, ue, interfaceC2971z54);
                                    Object obj2 = c2811p8.n("VIDEO").get(0);
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeVideoAsset");
                                    C2597c9 c2597c9 = (C2597c9) obj2;
                                    if (context != null) {
                                        ArrayList verificationScriptResources = new ArrayList();
                                        Iterator it3 = c2597c9.s.iterator();
                                        while (it3.hasNext()) {
                                            U8 u8 = (U8) it3.next();
                                            Iterator it4 = it3;
                                            if (Intrinsics.areEqual(str5, u8.b) && (u8 instanceof C2683ha)) {
                                                Map map = (Map) c2833qe.a(str4, Map.class);
                                                String str9 = str4;
                                                String a4 = G0.a(((C2683ha) u8).g, map);
                                                String str10 = str5;
                                                String str11 = ((C2683ha) u8).h;
                                                String a5 = G0.a(u8.d, map);
                                                if (B2.a(a4) && B2.a(str11)) {
                                                    createVerificationScriptResourceWithoutParameters2 = VerificationScriptResource.createVerificationScriptResourceWithParameters(str11, new URL(a5), a4);
                                                    Intrinsics.checkNotNull(createVerificationScriptResourceWithoutParameters2);
                                                } else {
                                                    createVerificationScriptResourceWithoutParameters2 = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(new URL(a5));
                                                    Intrinsics.checkNotNull(createVerificationScriptResourceWithoutParameters2);
                                                }
                                                verificationScriptResources.add(createVerificationScriptResourceWithoutParameters2);
                                                it3 = it4;
                                                str4 = str9;
                                                str5 = str10;
                                            } else {
                                                it3 = it4;
                                            }
                                        }
                                        if (verificationScriptResources.size() != 0) {
                                            C2613d8 a6 = a(c2811p8);
                                            if (a6 != null) {
                                                c2833qe.b.put("videoSkippable", Boolean.TRUE);
                                                c2833qe.b.put("videoSkipOffset", Integer.valueOf(a6.n));
                                            } else {
                                                c2833qe.b.put("videoSkippable", Boolean.FALSE);
                                                c2833qe.b.put("videoSkipOffset", 0);
                                            }
                                            HashMap hashMap = c2833qe.b;
                                            Object obj3 = c2597c9.t.get("shouldAutoPlay");
                                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Any");
                                            hashMap.put("videoAutoPlay", obj3);
                                            HashMap hashMap2 = c2833qe.b;
                                            String e2 = this.t.e();
                                            String str12 = (String) c2833qe.b.get("creativeType");
                                            Intrinsics.checkNotNullParameter(verificationScriptResources, "verificationScriptResources");
                                            C2796oa c2796oa = AbstractC2780na.f2651a;
                                            c2796oa.getClass();
                                            Intrinsics.checkNotNullParameter(verificationScriptResources, "verificationScriptResources");
                                            Context d = Uc.d();
                                            if (d != null) {
                                                str3 = new Sa(d, "omid_js_store").a("omid_js_string");
                                                if (str3 == null) {
                                                    str3 = null;
                                                }
                                            }
                                            str3 = ";(function(omidGlobal) {\n  var n;function aa(a){var b=0;return function(){return b<a.length?{done:!1,value:a[b++]}:{done:!0}}}function p(a){var b='undefined'!=typeof Symbol&&Symbol.iterator&&a[Symbol.iterator];if(b)return b.call(a);if('number'==typeof a.length)return{next:aa(a)};throw Error(String(a)+' is not an iterable or ArrayLike');}function q(a){if(!(a instanceof Array)){a=p(a);for(var b,c=[];!(b=a.next()).done;)c.push(b.value);a=c}return a}\nvar ca='function'==typeof Object.create?Object.create:function(a){function b(){}b.prototype=a;return new b},t='function'==typeof Object.defineProperties?Object.defineProperty:function(a,b,c){if(a==Array.prototype||a==Object.prototype)return a;a[b]=c.value;return a};\nfunction da(a){a=['object'==typeof globalThis&&globalThis,a,'object'==typeof window&&window,'object'==typeof self&&self,'object'==typeof global&&global];for(var b=0;b<a.length;++b){var c=a[b];if(c&&c.Math==Math)return c}throw Error('Cannot find global object');}var ea=da(this);function u(a,b){if(b)a:{var c=ea;a=a.split('.');for(var d=0;d<a.length-1;d++){var e=a[d];if(!(e in c))break a;c=c[e]}a=a[a.length-1];d=c[a];b=b(d);b!=d&&null!=b&&t(c,a,{configurable:!0,writable:!0,value:b})}}var fa;\nif('function'==typeof Object.setPrototypeOf)fa=Object.setPrototypeOf;else{var ha;a:{var ia={a:!0},ja={};try{ja.__proto__=ia;ha=ja.a;break a}catch(a){}ha=!1}fa=ha?function(a,b){a.__proto__=b;if(a.__proto__!==b)throw new TypeError(a+' is not extensible');return a}:null}var ka=fa;\nfunction v(a,b){a.prototype=ca(b.prototype);a.prototype.constructor=a;if(ka)ka(a,b);else for(var c in b)if('prototype'!=c)if(Object.defineProperties){var d=Object.getOwnPropertyDescriptor(b,c);d&&Object.defineProperty(a,c,d)}else a[c]=b[c];a.La=b.prototype}function w(){for(var a=Number(this),b=[],c=a;c<arguments.length;c++)b[c-a]=arguments[c];return b}function x(a,b){return Object.prototype.hasOwnProperty.call(a,b)}\nvar la='function'==typeof Object.assign?Object.assign:function(a,b){for(var c=1;c<arguments.length;c++){var d=arguments[c];if(d)for(var e in d)x(d,e)&&(a[e]=d[e])}return a};u('Object.assign',function(a){return a||la});\nu('Symbol',function(a){function b(f){if(this instanceof b)throw new TypeError('Symbol is not a constructor');return new c(d+(f||'')+'_'+e++,f)}function c(f,h){this.g=f;t(this,'description',{configurable:!0,writable:!0,value:h})}if(a)return a;c.prototype.toString=function(){return this.g};var d='jscomp_symbol_'+(1E9*Math.random()>>>0)+'_',e=0;return b});\nu('Symbol.iterator',function(a){if(a)return a;a=Symbol('Symbol.iterator');for(var b='Array Int8Array Uint8Array Uint8ClampedArray Int16Array Uint16Array Int32Array Uint32Array Float32Array Float64Array'.split(' '),c=0;c<b.length;c++){var d=ea[b[c]];'function'===typeof d&&'function'!=typeof d.prototype[a]&&t(d.prototype,a,{configurable:!0,writable:!0,value:function(){return ma(aa(this))}})}return a});function ma(a){a={next:a};a[Symbol.iterator]=function(){return this};return a}\nu('WeakMap',function(a){function b(g){this.g=(k+=Math.random()+1).toString();if(g){g=p(g);for(var l;!(l=g.next()).done;)l=l.value,this.set(l[0],l[1])}}function c(){}function d(g){var l=typeof g;return'object'===l&&null!==g||'function'===l}function e(g){if(!x(g,h)){var l=new c;t(g,h,{value:l})}}function f(g){var l=Object[g];l&&(Object[g]=function(m){if(m instanceof c)return m;Object.isExtensible(m)&&e(m);return l(m)})}if(function(){if(!a||!Object.seal)return!1;try{var g=Object.seal({}),l=Object.seal({}),\nm=new a([[g,2],[l,3]]);if(2!=m.get(g)||3!=m.get(l))return!1;m.delete(g);m.set(l,4);return!m.has(g)&&4==m.get(l)}catch(r){return!1}}())return a;var h='$jscomp_hidden_'+Math.random();f('freeze');f('preventExtensions');f('seal');var k=0;b.prototype.set=function(g,l){if(!d(g))throw Error('Invalid WeakMap key');e(g);if(!x(g,h))throw Error('WeakMap key fail: '+g);g[h][this.g]=l;return this};b.prototype.get=function(g){return d(g)&&x(g,h)?g[h][this.g]:void 0};b.prototype.has=function(g){return d(g)&&x(g,\nh)&&x(g[h],this.g)};b.prototype.delete=function(g){return d(g)&&x(g,h)&&x(g[h],this.g)?delete g[h][this.g]:!1};return b});\nu('Map',function(a){function b(){var k={};return k.H=k.next=k.head=k}function c(k,g){var l=k.g;return ma(function(){if(l){for(;l.head!=k.g;)l=l.H;for(;l.next!=l.head;)return l=l.next,{done:!1,value:g(l)};l=null}return{done:!0,value:void 0}})}function d(k,g){var l=g&&typeof g;'object'==l||'function'==l?f.has(g)?l=f.get(g):(l=''+ ++h,f.set(g,l)):l='p_'+g;var m=k.h[l];if(m&&x(k.h,l))for(k=0;k<m.length;k++){var r=m[k];if(g!==g&&r.key!==r.key||g===r.key)return{id:l,list:m,index:k,B:r}}return{id:l,list:m,\nindex:-1,B:void 0}}function e(k){this.h={};this.g=b();this.size=0;if(k){k=p(k);for(var g;!(g=k.next()).done;)g=g.value,this.set(g[0],g[1])}}if(function(){if(!a||'function'!=typeof a||!a.prototype.entries||'function'!=typeof Object.seal)return!1;try{var k=Object.seal({x:4}),g=new a(p([[k,'s']]));if('s'!=g.get(k)||1!=g.size||g.get({x:4})||g.set({x:4},'t')!=g||2!=g.size)return!1;var l=g.entries(),m=l.next();if(m.done||m.value[0]!=k||'s'!=m.value[1])return!1;m=l.next();return m.done||4!=m.value[0].x||\n't'!=m.value[1]||!l.next().done?!1:!0}catch(r){return!1}}())return a;var f=new WeakMap;e.prototype.set=function(k,g){k=0===k?0:k;var l=d(this,k);l.list||(l.list=this.h[l.id]=[]);l.B?l.B.value=g:(l.B={next:this.g,H:this.g.H,head:this.g,key:k,value:g},l.list.push(l.B),this.g.H.next=l.B,this.g.H=l.B,this.size++);return this};e.prototype.delete=function(k){k=d(this,k);return k.B&&k.list?(k.list.splice(k.index,1),k.list.length||delete this.h[k.id],k.B.H.next=k.B.next,k.B.next.H=k.B.H,k.B.head=null,this.size--,\n!0):!1};e.prototype.clear=function(){this.h={};this.g=this.g.H=b();this.size=0};e.prototype.has=function(k){return!!d(this,k).B};e.prototype.get=function(k){return(k=d(this,k).B)&&k.value};e.prototype.entries=function(){return c(this,function(k){return[k.key,k.value]})};e.prototype.keys=function(){return c(this,function(k){return k.key})};e.prototype.values=function(){return c(this,function(k){return k.value})};e.prototype.forEach=function(k,g){for(var l=this.entries(),m;!(m=l.next()).done;)m=m.value,\nk.call(g,m[1],m[0],this)};e.prototype[Symbol.iterator]=e.prototype.entries;var h=0;return e});u('Object.values',function(a){return a?a:function(b){var c=[],d;for(d in b)x(b,d)&&c.push(b[d]);return c}});function na(a,b){a instanceof String&&(a+='');var c=0,d=!1,e={next:function(){if(!d&&c<a.length){var f=c++;return{value:b(f,a[f]),done:!1}}d=!0;return{done:!0,value:void 0}}};e[Symbol.iterator]=function(){return e};return e}u('Array.prototype.keys',function(a){return a?a:function(){return na(this,function(b){return b})}});\nu('Set',function(a){function b(c){this.g=new Map;if(c){c=p(c);for(var d;!(d=c.next()).done;)this.add(d.value)}this.size=this.g.size}if(function(){if(!a||'function'!=typeof a||!a.prototype.entries||'function'!=typeof Object.seal)return!1;try{var c=Object.seal({x:4}),d=new a(p([c]));if(!d.has(c)||1!=d.size||d.add(c)!=d||1!=d.size||d.add({x:4})!=d||2!=d.size)return!1;var e=d.entries(),f=e.next();if(f.done||f.value[0]!=c||f.value[1]!=c)return!1;f=e.next();return f.done||f.value[0]==c||4!=f.value[0].x||\nf.value[1]!=f.value[0]?!1:e.next().done}catch(h){return!1}}())return a;b.prototype.add=function(c){c=0===c?0:c;this.g.set(c,c);this.size=this.g.size;return this};b.prototype.delete=function(c){c=this.g.delete(c);this.size=this.g.size;return c};b.prototype.clear=function(){this.g.clear();this.size=0};b.prototype.has=function(c){return this.g.has(c)};b.prototype.entries=function(){return this.g.entries()};b.prototype.values=function(){return this.g.values()};b.prototype.keys=b.prototype.values;b.prototype[Symbol.iterator]=\nb.prototype.values;b.prototype.forEach=function(c,d){var e=this;this.g.forEach(function(f){return c.call(d,f,f,e)})};return b});u('Object.is',function(a){return a?a:function(b,c){return b===c?0!==b||1/b===1/c:b!==b&&c!==c}});u('Array.prototype.includes',function(a){return a?a:function(b,c){var d=this;d instanceof String&&(d=String(d));var e=d.length;c=c||0;for(0>c&&(c=Math.max(c+e,0));c<e;c++){var f=d[c];if(f===b||Object.is(f,b))return!0}return!1}});\nu('String.prototype.includes',function(a){return a?a:function(b,c){if(null==this)throw new TypeError(\"The 'this' value for String.prototype.includes must not be null or undefined\");if(b instanceof RegExp)throw new TypeError('First argument to String.prototype.includes must not be a regular expression');return-1!==this.indexOf(b,c||0)}});u('Object.entries',function(a){return a?a:function(b){var c=[],d;for(d in b)x(b,d)&&c.push([d,b[d]]);return c}});\nu('Array.prototype.values',function(a){return a?a:function(){return na(this,function(b,c){return c})}});\nvar y={xa:'loaded',Fa:'start',ra:'firstQuartile',Aa:'midpoint',Ga:'thirdQuartile',pa:'complete',Ba:'pause',Da:'resume',oa:'bufferStart',na:'bufferFinish',Ea:'skipped',Ja:'volumeChange',Ca:'playerStateChange',ka:'adUserInteraction'},oa={ua:'generic',Ia:'video',za:'media'},pa={ca:'native',va:'html',V:'javascript'},qa={ca:'native',V:'javascript',NONE:'none'},ra={ta:'full',qa:'domain',wa:'limited'},sa={ma:'backgrounded',sa:'foregrounded'},ta={ya:'locked',Ha:'unlocked'},ua={la:'app',Ka:'web'};function z(a,b){this.x=null!=a.x?a.x:a.left;this.y=null!=a.y?a.y:a.top;this.width=a.width;this.height=a.height;this.endX=this.x+this.width;this.endY=this.y+this.height;this.adSessionId=a.adSessionId||void 0;this.isFriendlyObstructionFor=a.isFriendlyObstructionFor||[];this.h=a.friendlyObstructionClass||void 0;this.i=a.friendlyObstructionPurpose||void 0;this.j=a.friendlyObstructionReason||void 0;this.clipsToBounds=void 0!==a.clipsToBounds?!0===a.clipsToBounds:!0;this.m=void 0!==a.hasWindowFocus?!0===\na.hasWindowFocus:!0;this.notVisibleReason=a.notVisibleReason||void 0;this.noOutputDevice=a.noOutputDevice||void 0;this.isPipActive='true'===a.isPipActive||!0===a.isPipActive||!1;this.childViews=a.childViews||[];this.isCreative=a.isCreative||!1;this.g=b}function va(a){var b={};return b.width=a.width,b.height=a.height,b}function A(a){var b={};return Object.assign({},va(a),(b.x=a.x,b.y=a.y,b))}function C(a){var b=A(a),c={};return Object.assign({},b,(c.endX=a.endX,c.endY=a.endY,c))}\nfunction wa(a,b,c){a.x+=b;a.y+=c;a.endX+=b;a.endY+=c}z.prototype.N=function(a){if(null==a)return!1;a=A(a);var b=a.y,c=a.width,d=a.height;return this.x===a.x&&this.y===b&&this.width===c&&this.height===d};function xa(a){return a.width*a.height}function D(a){return 0===a.width||0===a.height};function ya(a,b){a=A(a);for(var c=[],d=[],e=0;e<b.length;e++){var f=A(b[e]);f=za(a,f);E(c,f.x);E(c,f.endX);E(d,f.y);E(d,f.endY)}c=c.sort(function(h,k){return h-k});d=d.sort(function(h,k){return h-k});return{ia:c,ja:d}}function za(a,b){return{x:Math.max(a.x,b.x),y:Math.max(a.y,b.y),endX:Math.min(a.x+a.width,b.x+b.width),endY:Math.min(a.y+a.height,b.y+b.height)}}function E(a,b){-1===a.indexOf(b)&&a.push(b)};function H(){this.h=this.g=this.D=this.u=this.m=this.s=void 0;this.A=0;this.l=[];this.v=[];this.C=0;this.o=[];this.j=[];this.i=[]}H.prototype.N=function(a){return null==a?!1:JSON.stringify(Aa(this))===JSON.stringify(Aa(a))};\nfunction Aa(a){var b=[],c=[],d={viewport:a.s,adView:{percentageInView:a.A,pixelsInView:a.C,reasons:a.i},declaredFriendlyObstructions:a.l.length};if(void 0!==a.g){d.adView.geometry=A(a.g);d.adView.geometry.pixels=xa(a.g);d.adView.onScreenGeometry=A(a.h);d.adView.onScreenGeometry.pixels=Ba(a);for(var e=0;e<a.j.length;e++)b.push(A(a.j[e]));for(e=0;e<a.v.length;e++){var f=a.v[e],h=f,k={};h.h&&(k.obstructionClass=h.h);h.i&&(k.obstructionPurpose=h.i);h.j&&(k.obstructionReason=h.j);f=za(a.g,f);c.push(Object.assign({},\n{x:f.x,y:f.y,width:f.endX-f.x,height:f.endY-f.y},k))}d.adView.onScreenGeometry.obstructions=b;d.adView.onScreenGeometry.friendlyObstructions=c;void 0!==a.u&&void 0!==a.D&&(d.adView.containerGeometry=A(a.u),d.adView.onScreenContainerGeometry=A(a.D),d.adView.measuringElement=!0)}return d}function Ca(a,b){b=va(b);a.s={};a.s.width=b.width;a.s.height=b.height;a.m={};a.m.x=0;a.m.y=0;a.m.width=b.width;a.m.height=b.height;a.m.endX=b.width;a.m.endY=b.height}\nfunction Da(){return{x:0,y:0,endX:0,endY:0,width:0,height:0}}function Ea(a,b){var c={};c.x=Math.max(a.x,b.x);c.y=Math.max(a.y,b.y);c.endX=Math.min(a.endX,b.endX);c.endY=Math.min(a.endY,b.endY);c.width=Math.max(0,c.endX-c.x);c.height=Math.max(0,c.endY-c.y);return c}function Fa(a,b){return.01<b.width-a.width||.01<b.height-a.height}function Ga(a){if(-1!==a.i.indexOf('backgrounded'))a.A=0,a.C=0;else{var b=xa(a.g);if(0!==b){var c=Ba(a);a.A=Math.round(c/b*100);a.C=c}}}\nfunction Ha(a,b){if(D(b)||!a.h)b=!1;else{var c=C(a.h),d=c.y,e=c.endX;a=c.endY;var f=b.endX;c=c.x;(f=f<c||.01>Math.abs(f-c))||(f=b.x,f=f>e||.01>Math.abs(f-e));(e=f)||(e=b.endY,e=e<d||.01>Math.abs(e-d));(d=e)||(b=b.y,d=b>a||.01>Math.abs(b-a));b=!d}return b}function I(a,b){for(var c=!1,d=0;d<a.i.length;d++)a.i[d]===b&&(c=!0);c||a.i.push(b)}\nfunction Ba(a){var b=Math,c=b.max,d=xa(a.h),e=a.j,f=0;if(0<e.length){var h=ya(a.h,e);a=h.ia;h=h.ja;for(var k=0;k<a.length-1;k++)for(var g=(a[k]+(a[k]+1))/2,l=a[k+1]-a[k],m=0;m<h.length-1;m++){for(var r=(h[m]+(h[m]+1))/2,F=h[m+1]-h[m],ba=!1,R=0;R<e.length;R++){var G=A(e[R]);if(G.x<g&&G.x+G.width>g&&G.y<r&&G.y+G.height>r){ba=!0;break}}ba&&(f+=Math.round(l)*Math.round(F))}}return c.call(b,0,d-f)};function Ia(){};function Ja(){}\nfunction Ka(a,b,c,d,e,f){var h=new H;b=new z(b,!1);Ca(h,b);La(a,b,h,d);if(!e)return h.i=['unmeasurable'],h.s=void 0,h.A=0,h.j=[],h.g&&(a=h.g,c={},a=new z((c.x=0,c.y=0,c.width=a.width,c.height=a.height,c),a.g),h.g=a),h.h=Da(),h;'locked'===f&&I(h,'deviceLocked');if(b.noOutputDevice)I(h,'backgrounded'),I(h,'noOutputDevice');else if('backgrounded'===c)I(h,'backgrounded');else if(void 0!==h.g){for(a=0;a<h.l.length;a++)Ha(h,h.l[a])&&h.v.push(h.l[a]);for(a=0;a<h.o.length;a++){if(c=Ha(h,h.o[a])){a:{c=h.o[a];\nfor(d=0;d<h.j.length;d++)if(h.j[d].N(c)){c=!0;break a}c=!1}c=!c}c&&(I(h,'obstructed'),h.j.push(h.o[a]))}Ga(h)}else I(h,'notFound');return h}\nfunction La(a,b,c,d){var e=b.isCreative?!0:b.adSessionId===d;if(e){c.g=b;var f=C(c.g);a=Ea(c.m,f);var h=c.g;'notAttached'===h.notVisibleReason||'noWindowFocus'===h.notVisibleReason||'noAdView'===h.notVisibleReason?(I(c,'notFound'),c.h=new z(Da(),!1)):(h=c.g,'viewInvisible'===h.notVisibleReason||'viewGone'===h.notVisibleReason||'viewNotVisible'===h.notVisibleReason||'viewAlphaZero'===h.notVisibleReason||'viewHidden'===h.notVisibleReason||void 0!==c.g.notVisibleReason||D(c.g)?(I(c,'hidden'),c.h=new z(Da(),\n!1)):(c.g.isPipActive&&I(c,'pictureInPicture'),c.g.m||(I(c,'backgrounded'),I(c,'noWindowFocus')),Fa(a,f)&&I(c,'clipped'),c.h=new z(a,!1)))}else if(f=!0,b.g&&(f=-1!==b.isFriendlyObstructionFor.indexOf(d)?!1:!1===b.clipsToBounds),f){h=b.childViews;for(var k=0;k<h.length;k++)f=void 0!==c.g,La(a,new z(h[k],f),c,d)}e||void 0===c.g||(b.g?-1!==b.isFriendlyObstructionFor.indexOf(d)?c.l.push(b):c.o.push(b):(e=C(b),d=C(c.h),A(c.h),!D(c.h)&&b.clipsToBounds&&(b=Ea(d,e),Fa(b,d)&&(I(c,'clipped'),c.h=new z(b,!1)))))}\n;function Ma(){this.h=new Map;this.g=null}function Na(){Oa||(Oa=new Ma);return Oa}var Oa=null;function Pa(a,b){this.y=this.x=0;this.width=a;this.height=b};function Qa(){this.adSessionId=null;this.m={apiVersion:'1.0',accessMode:'limited',environment:'app',omidJsInfo:{omidImplementer:'omsdk',serviceVersion:'1.5.5-iab77'}};this.C=null;this.A='foregrounded';this.M='unlocked';this.u=this.o='none';this.s=this.j=this.i=this.l=this.h=this.g=this.J=this.D=null;this.I=!0;this.v=new Map}\nfunction Ra(a,b){void 0!==b.contentUrl&&(a.C=b.contentUrl,b.contentUrl=void 0);var c=a.m||{};b.omidJsInfo=Object.assign({},c.omidJsInfo||{},b.omidJsInfo||{});b=Object.assign({},c,b);a.I||(null!=a.j?(b.videoElement=a.j,b.accessMode='full'):null!=a.i&&(b.slotElement=a.i,b.accessMode='full'));a.m=b};var J=function(){if('undefined'!==typeof omidGlobal&&omidGlobal)return omidGlobal;if('undefined'!==typeof global&&global)return global;if('undefined'!==typeof window&&window)return window;if('undefined'!==typeof globalThis&&globalThis)return globalThis;var a=Function('return this')();if(a)return a;throw Error('Could not determine global object context.');}();function Sa(a,b){this.g=a;this.h=b}ea.Object.defineProperties(Sa.prototype,{event:{configurable:!0,enumerable:!0,get:function(){return this.g}},origin:{configurable:!0,enumerable:!0,get:function(){return this.h}}});function K(){var a=w.apply(0,arguments);Ta(function(){throw new (Function.prototype.bind.apply(Error,[null,'Could not complete the test successfully - '].concat(q(a))));},function(){return console.error.apply(console,q(a))})}function Ua(){var a=w.apply(0,arguments);Ta(function(){},function(){return console.error.apply(console,q(a))})}function Ta(a,b){'undefined'!==typeof jasmine&&jasmine?a():'undefined'!==typeof console&&console&&console.error&&b()};function Va(a){this.g=a;this.m=[];this.i=[];this.j=[];this.l=[];this.o={}}function Wa(a,b){if(void 0!==a.g&&a.g.adSessionId&&!1!==Xa(a,b)){var c=b.event;a.j.filter(function(d){return d.type===c.type}).forEach(function(d){a.h(d.G,c)})}}function Ya(a,b){a.m.push(b);Wa(a,b)}function Za(a,b,c){void 0!==a.g&&a.g.adSessionId&&a.m.filter(function(d){return d.event.type===b&&Xa(a,d)}).map(function(d){return d.event}).forEach(function(d){a.h(c.G,d)})}\nfunction Xa(a,b){var c=b.event.type,d=-1!==Object.values(y).indexOf(c)&&'volumeChange'!==c;return'impression'===c||'loaded'===c&&a.g.h?b.origin===a.g.u:d?b.origin===a.g.o:!0}function $a(a,b,c){Object.keys(y).forEach(function(d){d=y[d];var e={type:d,R:c,G:b};a.j.push(e);Za(a,d,e)})}function ab(a,b,c,d){var e={U:c,R:d,G:b};a.l.push(e);a.i.forEach(function(f){var h=bb(f);'sessionStart'===f.event.type&&cb(a,h,e);a.h(e.G,h)})}\nfunction db(a,b,c){var d=L(a,'sessionError','native',{errorType:b,message:c});a.i.push(d);a.l.forEach(function(e){a.h(e.G,d.event)})}function eb(a,b){a.o=Object.assign(a.o,b);b=a.g.m;if(void 0!==b){b=Object.assign({},fb(gb(a,hb(a,{context:b}),!0)),{supportsLoadedEvent:!!a.g.h||'video'==a.g.g});Object.assign(b,{pageUrl:null,contentUrl:a.g.C});var c=L(a,'sessionStart','native',b);a.i.push(c);a.l.forEach(function(d){var e=bb(c);cb(a,e,d);a.h(d.G,e)},a);ib(a)}}\nfunction cb(a,b,c){c.U&&(b.data.verificationParameters=a.o[c.U]);c.R&&(c=a.g.v.get(c.R))&&(b.data.verificationParameters=c.verificationParameters,b.data.context.accessMode=c.accessMode,'full'===c.accessMode&&(a.g.j&&(b.data.context.videoElement=a.g.j),a.g.i&&(b.data.context.slotElement=a.g.i)))}function jb(a){var b=L(a,'sessionFinish','native');a.i.push(b);a.l.forEach(function(c){a.h(c.G,b.event)})}Va.prototype.h=function(a){var b=w.apply(1,arguments);try{a.apply(null,q(b))}catch(c){Ua(c)}};\nfunction kb(a,b){var c=(c=a.g.K)?Aa(c):null;c=gb(a,hb(a,c));Ya(a,L(a,'impression',b,c))}function lb(a,b,c){if(a.g.h||'display'!=a.g.g)b=L(a,'loaded',b,gb(a,hb(a,void 0===c?null:c))),Ya(a,b)}\nfunction mb(a,b,c,d){'start'!==b&&'volumeChange'!==b||null!=(d&&d.deviceVolume)||(d.deviceVolume=a.g.D);if(d&&('start'===b||'volumeChange'===b)){var e=d.videoPlayerVolume,f=d.mediaPlayerVolume;null!=e?(Object.assign(d,{mediaPlayerVolume:e}),a.g.J=e):null!=f&&(Object.assign(d,{videoPlayerVolume:f}),a.g.J=f)}Ya(a,L(a,b,c,d))}\nfunction ib(a){var b=a.m.filter(function(f){return Object.values(y).includes(f.event.type)&&'video'==a.g.g&&f.origin===a.g.o||'loaded'==f.event.type&&'display'==a.g.g&&f.origin===a.g.u?!0:!1}).map(function(f){return f.event}),c=a.g.adSessionId||'',d={};b=p(b);for(var e=b.next();!e.done;d={F:d.F},e=b.next()){d.F=e.value;d.F.adSessionId||(d.F.adSessionId=c);if('loaded'==d.F.type){if(!a.g.h&&'display'==a.g.g)continue;d.F.data=gb(a,hb(a,d.F.data))}a.j.filter(function(f){return function(h){return h.type===\nf.F.type}}(d)).forEach(function(f){return function(h){return h.G(f.F)}}(d))}}function nb(a,b,c){a:{c=new Set(c);a=p(a.m.concat(a.i));for(var d=a.next();!d.done;d=a.next())if(d=d.value,c.has(d.event.type)&&d.origin!=b){b=!0;break a}b=!1}return b?(K('Event owner cannot be registered after its events have already been published.'),!1):!0}function ob(a,b){nb(a,b,Object.values(y))&&pb(a,b)&&(a.g.o=b)}function qb(a,b){nb(a,b,['impression'])&&rb(a,b)&&(a.g.u=b)}\nfunction rb(a,b){var c=a.g.u;return'none'!=c&&c!=b?(K('Impression event is owned by '+(a.g.u+', not ')+(b+'.')),!1):!0}function pb(a,b){var c=a.g.o;return'none'!=c&&c!=b?(K('Media events are owned by '+(a.g.o+', not '+b+'.')),!1):!0}function gb(a,b,c){c=void 0===c?!1:c;b=Object.assign({},b);a.g.g&&Object.assign(b,{mediaType:a.g.g});a.g.h&&(c||'definedByJavaScript'!==a.g.h)&&Object.assign(b,{creativeType:a.g.h});return b}function fb(a){var b=Na().g;return b?Object.assign({},a,{lastActivity:b}):a}\nfunction hb(a,b){return a.g.l?Object.assign({},b,{impressionType:a.g.l}):b}function L(a,b,c,d){return new Sa({adSessionId:a.g.adSessionId||'',timestamp:(new Date).getTime(),type:b,data:d},c)}function bb(a){a=a.event;var b=a.data?Object.assign({},a.data):void 0;'sessionStart'===a.type&&(b.context=Object.assign({},b.context));return{adSessionId:a.adSessionId,timestamp:a.timestamp,type:a.type,data:b}};function sb(a,b,c){this.h=a;this.i=b;this.g=c}\nfunction M(a,b,c){'container'===b&&void 0!==a.g.L&&void 0!==a.g&&null!=a.g.adSessionId&&(a.g.O=Ka(a.i,a.g.L,a.g.A,a.g.adSessionId,!0,a.g.M));b=a.g;var d=b.O,e=b.P;if(d)if(e){b=new H;var f=d.s,h=d.g,k=d.h,g=e.g,l=e.h;f&&h&&k&&g&&l&&(Ca(b,f),b.u=new z(h,!1),b.D=new z(k,!1),b.o=Object.assign([],d.o),b.j=Object.assign([],d.j),b.l=Object.assign([],d.l),b.v=Object.assign([],d.v),b.i=Object.assign([],e.i,d.i),d=b.u.x,e=b.u.y,g=new z(g,!1),l=new z(l,!1),wa(g,d,e),wa(l,d,e),b.g=g,b.h=Ea(l,k),Ga(b))}else b=\nd;else b=null;k=a.g.K;if(b&&!b.N(k)||c)k=Aa(b),c&&(k.adView.reasons=k.adView.reasons||[c]),c=a.h,'audio'!=c.g.h&&Ya(c,L(c,'geometryChange','native',k)),a.g.K=b};function tb(){var a;this.g=a=void 0===a?omidGlobal:a}tb.prototype.setInterval=function(a,b){return ub(this,'setInterval')(a,b)};tb.prototype.clearInterval=function(a){ub(this,'clearInterval')(a)};function vb(a,b){ub(a,'clearTimeout')(b)}function ub(a,b){return a.g&&a.g[b]?a.g[b]:wb(a,b)}\nfunction xb(a,b,c,d){if(a.g.document&&a.g.document.body){var e=a.g.document.createElement('img');e.width=1;e.height=1;e.style.display='none';e.src=b;c&&e.addEventListener('load',function(){return c()});d&&e.addEventListener('error',function(){return d()});a.g.document.body.appendChild(e)}else wb(a,'sendUrl')(b,c,d)}function wb(a,b){if(a.g&&a.g.omidNative&&a.g.omidNative[b])return a.g.omidNative[b].bind(a.g.omidNative);throw Error('Native interface method \"'+b+'\" not found.');};function N(a){return'object'===typeof a}function O(a){return'number'===typeof a&&!isNaN(a)&&0<=a}function P(a){return'string'===typeof a}function Q(a,b){return P(a)&&-1!==Object.values(b).indexOf(a)}function yb(a){return!(!a||!a.tagName||'iframe'!==a.tagName.toLowerCase())};function S(a,b,c,d,e){this.j=a;this.ba=b;this.L=c;this.i=d;this.P=e;this.h=null;this.g=this.m=this.D=void 0;this.O=!0;this.J=void 0;zb(this)}\nfunction zb(a){if(!a.h){var b;a:{if((b=a.j.document)&&b.getElementsByClassName&&(b=b.getElementsByClassName('omid-element'))){if(1==b.length){b=b[0];break a}1<b.length&&a.O&&(db(a.L,'generic',\"More than one element with 'omid-element' class name.\"),a.O=!1)}b=null}if(b&&b.tagName&&'video'===b.tagName.toLowerCase())a.i.j=b;else if(b&&b.tagName)a.i.i=b;else return;Ab(a)}}function Ab(a){a.i.j?(a.h=a.i.j,a.o()):a.i.i&&(a.h=a.i.i,yb(a.h)?a.i.s&&a.o():a.o())}\nfunction Bb(a){a.g&&(yb(a.h)?a.i.s&&(a.K(),Cb(a)):(a.K(),Cb(a)))}S.prototype.A=function(){this.J&&(this.j.document.removeEventListener('visibilitychange',this.J),this.J=void 0)};S.prototype.o=function(){};function Cb(a){a.D&&(a.i.P=a.D,M(a.ba,'creative'))}function Db(a){if(a.g&&a.i.s){var b=new z(a.i.s,!1);wa(b,a.g.x,a.g.y);b.clipsToBounds=!0;return b}};function T(a,b,c,d,e,f){S.call(this,a,c,d,e,f);this.s=b;this.l=void 0}v(T,S);T.prototype.A=function(){void 0!==this.l&&(this.P.clearInterval(this.l),this.l=void 0);S.prototype.A.call(this)};T.prototype.o=function(){var a=this;S.prototype.o.call(this);null==this.h?this.l=void 0:void 0===this.l&&(this.l=this.P.setInterval(function(){return Eb(a)},200),Eb(this))};\nT.prototype.K=function(){if(this.m){var a=Db(this);if(a){this.g.isCreative=!1;a.isCreative=!0;for(var b=!1,c=0;c<this.g.childViews.length;c++)if(this.g.childViews[c].isCreative){this.g.childViews[c]=a;b=!0;break}b||this.g.childViews.push(a)}else this.g.isCreative=!0;this.D=Ka(this.s,this.m,this.i.A,this.i.adSessionId,this.I())}};T.prototype.I=function(){return!0};\nfunction Eb(a){if(void 0!==a.l){b:{try{var b=a.j.top;var c=0<=b.innerHeight&&0<=b.innerWidth;break b}catch(d){}c=!1}c?(c=a.j.top,c=new z(new Pa(c.innerWidth,c.innerHeight),!1)):c=new z(new Pa(0,0),!1);b=a.h.getBoundingClientRect();if(null==b.x||isNaN(b.x))b.x=b.left;if(null==b.y||isNaN(b.y))b.y=b.top;b=new z(b,!1);c.N(a.m)&&b.N(a.g)||(a.g=b,a.g.clipsToBounds=!0,a.m=c,a.m.childViews.push(a.g),Bb(a))}};function U(a,b,c,d,e,f){S.call(this,a,c,d,e,f);this.v=this.s=this.u=this.l=void 0;this.M=!1;this.C=void 0}v(U,S);U.prototype.A=function(){this.l&&this.l.disconnect();Fb(this);S.prototype.A.call(this)};U.prototype.o=function(){S.prototype.o.call(this);if(this.h&&(this.l||(this.l=Gb(this)),Hb(this),Ib(this.h)&&Jb(this),'backgrounded'===this.i.A)){var a=Kb(new Pa(0,0));this.C=this.g=this.m=a;Bb(this)}};\nU.prototype.K=function(){if(this.g&&this.C){var a=Db(this);if(a){var b=a;var c=this.C;var d=Math.max(a.x,c.x);var e=Math.max(a.y,c.y),f=Math.min(a.endX,c.endX);a=Math.min(a.endY,c.endY);f<=d||a<=e?d=null:(c={},d=new z((c.x=d,c.y=e,c.width=Math.abs(f-d),c.height=Math.abs(a-e),c),!1));d||(d=new z({x:0,y:0,width:0,height:0},!1))}else b=this.g,d=this.C;e=new H;this.m&&Ca(e,this.m);e.g=b;e.h=d;Ga(e);this.M?D(e.g)?I(e,'hidden'):100===e.A||I(e,'clipped'):I(e,'viewport');this.D=e}};U.prototype.I=function(){return!0};\nfunction Fb(a){a.u&&(a.u.disconnect(),a.u=void 0);a.s&&(a.s.disconnect(),a.s=void 0);a.v&&((0,a.j.removeEventListener)('resize',a.v),a.v=void 0)}function Hb(a){a.l&&a.h&&(a.l.unobserve(a.h),a.l.observe(a.h))}function Ib(a){a=a.getBoundingClientRect();return 0==a.width||0==a.height}\nfunction Gb(a){return new a.j.IntersectionObserver(function(b){try{if(b.length){for(var c,d=b[0],e=1;e<b.length;e++)b[e].time>d.time&&(d=b[e]);c=d;a.m=Kb(c.rootBounds);a.g=Kb(c.boundingClientRect);a.C=Kb(c.intersectionRect);a.M=!!c.isIntersecting;Bb(a)}}catch(f){a.A(),db(a.L,'generic','Problem handling IntersectionObserver callback: '+f.message)}},{root:null,rootMargin:'0px',threshold:[0,.1,.2,.3,.4,.5,.6,.7,.8,.9,1]})}\nfunction Jb(a){a.j.ResizeObserver?a.u||(a.u=Lb(a,function(){return Mb(a)}),a.u.observe(a.h)):(a.v||(a.v=function(){return Mb(a)},(0,a.j.addEventListener)('resize',a.v)),a.s||(a.s=new MutationObserver(function(){return Mb(a)}),a.s.observe(a.h,{childList:!1,attributes:!0,subtree:!1})))}function Mb(a){a.h&&!Ib(a.h)&&(Hb(a),Fb(a))}function Lb(a,b){return new a.j.ResizeObserver(b)}function Kb(a){if(a&&null!==a.x&&null!==a.y&&null!==a.width&&null!==a.height)return new z(a,!1)};function Nb(a){if('object'===typeof a&&'object'===typeof a.webOSSystem)return a.webOSSystem}function Ob(a){if('object'===typeof a&&'object'===typeof a.tizen)return a.tizen}function Pb(a){return'object'===typeof Ob(a)};function Qb(a,b){this.h=a;this.g=b};function Sb(){return'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g,function(a){var b=16*Math.random()|0;return'y'===a?(b&3|8).toString(16):b.toString(16)})};function Tb(a,b){var c=void 0===c?J:c;this.j=a;this.g=c;this.i=b;this.h=[]}\nfunction Ub(a){if(!a.g||!a.g.document)throw Error('OMID Service Script is not running within a window.');var b=a.h;a.h=[];b.forEach(function(c){try{var d=a.i.I?'limited':'full',e=Q(c.accessMode,ra)?c.accessMode:null;var f=e?'full'==e&&'limited'==d?d:'domain'==e?'limited':e:d;c.accessMode=f;a:{var h=c.resourceUrl,k=a.g.location.origin;try{var g=new URL(h,k);break a}catch(F){}try{g=new URL(h);break a}catch(F){}g=null}if(d=g){var l=Sb();Vb(a,l,d,f);var m=c.vendorKey,r=c.verificationParameters;m=void 0===\nm?'':m;r=void 0===r?'':r;m&&'string'===typeof m&&''!==m&&r&&'string'===typeof r&&''!==r&&(a.j.o[m]=r);a.i.v.set(l,c)}}catch(F){Ua('OMID verification script '+c.resourceUrl+' failed to load: '+F)}})}\nfunction Vb(a,b,c,d){var e=a.g.document,f=e.createElement('iframe');f.id='omid-verification-script-frame-'+b;f.style.display='none';if('full'==d){var h=function(){var k=f.contentWindow;k.omidVerificationProperties={serviceWindow:a.g,injectionSource:'app',injectionId:b};k=k.document;var g=k.createElement('script');g.src=c.href;k.head.appendChild(g);f.removeEventListener('load',h)};f.addEventListener('load',h)}else'limited'==d&&(f.srcdoc=\"<html><head>\\n<script type=\\\"text/javascript\\\">window['omidVerificationProperties'] = {\\n'serviceWindow': window.parent,\\n'injectionSource': 'app',\\n'injectionId': '\"+\n(b+'\\',\\n};\\x3c/script>\\n<script type=\"text/javascript\" src=\"')+c.href+'\">\\x3c/script>\\n</head><body></body></html>',f.sandbox='allow-scripts');e.body.appendChild(f);Na().h.set(b,f)};function Wb(a,b,c,d,e,f){var h=this;this.g=a;this.h=b;this.j=c;this.i=d;this.l=e;this.s=f;this.m=!1;Xb(this,function(k){if('sessionStart'===k.type){h.m=!0;try{Ub(h.l)}catch(g){K(g.message)}}'sessionFinish'===k.type&&(h.m=!1)})}function Xb(a,b,c,d){ab(a.h,b,c,d)}n=Wb.prototype;n.setSlotElement=function(a){a&&a.tagName?(this.g.i=a,this.i&&Ab(this.i)):K('setSlotElement called with a non-HTMLElement.  It will be ignored.')};n.setElementBounds=function(a){this.g.s=a;this.i&&Ab(this.i);this.i&&Bb(this.i)};\nn.error=function(a,b){db(this.h,a,b)};n.injectVerificationScriptResources=function(a){var b=this.l;b.h.push.apply(b.h,q(a));if(this.m)try{Ub(this.l)}catch(c){K(c.message)}};n.setCreativeType=function(a,b){b=void 0===b?null:b;if(!this.g.g||this.g.h)this.g.h=a,'video'==a||'audio'==a?this.g.g='video':'htmlDisplay'==a||'nativeDisplay'==a?this.g.g='display':'definedByJavaScript'==a&&b&&(this.g.g='none'==b?'display':'video')};n.setImpressionType=function(a){if(!this.g.g||this.g.h)this.g.l=a};\nn.setClientInfo=function(a,b,c){var d=this.g.m||{};d.omidJsInfo=Object.assign({},d.omidJsInfo,{sessionClientVersion:a,partnerName:b,partnerVersion:c});this.g.m=d;return this.g.m.omidJsInfo.serviceVersion};function Yb(a,b){if(!b)return a.g;for(var c=p(a.h.values()),d=c.next();!d.done;d=c.next())if(d=d.value,d.g.v.has(b))return d;return a.g}function V(a,b){return null==b?a.g:a.h.get(b)||a.g}function Zb(a){var b=new Qa,c=new Va(b),d=new Ia,e=new Ja,f=new sb(c,e,b);a=a.i;var h=omidGlobal;d=h?h.IntersectionObserver&&(h.MutationObserver||h.ResizeObserver)?new U(h,d,f,c,b,a):new T(h,e,f,c,b,a):null;return new Wb(b,c,f,d,new Tb(c,b),new Qb(c,b))};function $b(a){return a&&N(a)?Object.entries(a).reduce(function(b,c){var d=p(c);c=d.next().value;d=d.next().value;return b&&P(c)&&null!=d&&N(d)&&P(d.resourceUrl)},!0):!1};function W(a,b,c,d){this.h=a;this.method=b;this.version=c;this.g=d}function ac(a){return!!a&&void 0!==a.omid_message_guid&&void 0!==a.omid_message_method&&void 0!==a.omid_message_version&&'string'===typeof a.omid_message_guid&&'string'===typeof a.omid_message_method&&'string'===typeof a.omid_message_version&&(void 0===a.omid_message_args||void 0!==a.omid_message_args)}function bc(a){return new W(a.omid_message_guid,a.omid_message_method,a.omid_message_version,a.omid_message_args)}\nfunction cc(a){var b={};b=(b.omid_message_guid=a.h,b.omid_message_method=a.method,b.omid_message_version=a.version,b);void 0!==a.g&&(b.omid_message_args=a.g);return b};function dc(a){this.i=a};function X(a){this.i=a;this.handleExportedMessage=X.prototype.j.bind(this)}v(X,dc);X.prototype.h=function(a,b){b=void 0===b?this.i:b;if(!b)throw Error('Message destination must be defined at construction time or when sending the message.');b.handleExportedMessage(cc(a),this)};X.prototype.j=function(a,b){ac(a)&&this.g&&this.g(bc(a),b)};function ec(a){return fc(a,'SessionService.')}function fc(a,b){return(a=a.match(new RegExp('^'+b+'(.*)')))&&a[1]};function gc(a,b){this.i=b=void 0===b?J:b;var c=this;a.addEventListener('message',function(d){if('object'===typeof d.data){var e=d.data;ac(e)&&d.source&&c.g&&c.g(bc(e),d.source)}})}v(gc,dc);gc.prototype.h=function(a,b){b=void 0===b?this.i:b;if(!b)throw Error('Message destination must be defined at construction time or when sending the message.');b.postMessage(cc(a),'*')};function hc(a,b){b=void 0===b?{}:b;var c=J.webkit?J.webkit.messageHandlers.omidJsSessionService:J.omidJsSessionService;if(!c)return!1;c.postMessage(JSON.stringify({method:a,data:b}));return!0};function ic(){this.g=jc}n=ic.prototype;n.registerSessionObserver=function(a,b){Xb(V(this.g,a),b)};n.setSlotElement=function(a,b){V(this.g,a).setSlotElement(b)};n.setElementBounds=function(a,b){V(this.g,a).setElementBounds(b)};\nfunction kc(a,b,c,d,e){e=void 0===e?null:e;a=V(a.g,b);var f=a.g.m;f.sessionOwner||(f.sessionOwner=d?'native':'javascript');d?(b=b||Sb(),a.g.adSessionId=b,c.canMeasureVisibility=a.i.I(),Ra(a.g,c),eb(a.h,e),a.i&&zb(a.i)):b?(Ra(a.g,c),hc('startSession',{adSessionId:b})||K('On App, the native-layer JS Session Service must be initialized before starting an ad session using the JS API.')):K('Session client must be updated to start an App session from JS.')}\nfunction lc(a,b,c){c?(b=V(a.g,b),a=a.g,a.g=Zb(a),jb(b.h),b.i.A(),b.o&&(b.o.stop(),b.o=null)):b?hc('finishSession',{adSessionId:b})||K('On App, the native-layer JS Session Service must be initialized before finishing an ad session using the JS API.'):K('Session client must be updated to finish an App session from JS.')}n.error=function(a,b,c){V(this.g,a).error(b,c)};\nfunction Y(a,b,c,d){a=V(a.g,b);'impression'==c?rb(a.h,'javascript')&&(kb(a.h,'javascript'),a.i&&zb(a.i)):('loaded'==c?(d=void 0===d?null:d,pb(a.h,'javascript')&&lb(a.h,'javascript',d)):pb(a.h,'javascript')&&mb(a.h,c,'javascript',d),['loaded','start'].includes(c)&&a.i&&zb(a.i))}n.injectVerificationScriptResources=function(a,b){V(this.g,a).injectVerificationScriptResources(b)};n.setCreativeType=function(a,b,c){c=void 0===c?null:c;V(this.g,a).setCreativeType(b,c)};\nn.setImpressionType=function(a,b){V(this.g,a).setImpressionType(b)};n.setClientInfo=function(a,b,c,d){var e=this.g;if(null==a)a=e.g;else{var f=[].concat(q(e.h.values())).includes(e.g)?Zb(e):e.g;e.h.set(a,f);a=f}return a.setClientInfo(b,c,d)};function mc(a){a=a.split('-')[0].split('.');for(var b=['1','0','3'],c=0;3>c;c++){var d=parseInt(a[c],10),e=parseInt(b[c],10);if(d>e)break;else if(d<e)return!1}return!0};function nc(a,b){return/\\d+\\.\\d+\\.\\d+(-.*)?/.test(a)&&mc(a)?b:JSON.stringify(b)}function oc(a,b){return/\\d+\\.\\d+\\.\\d+(-.*)?/.test(a)&&mc(a)?b?b:[]:b&&'string'===typeof b?JSON.parse(b):[]};function pc(){var a=qc;var b=void 0===b?omidGlobal:b;this.g=a;this.h=b;this.j=new X;this.h.omid=this.h.omid||{};this.h.omid.v1_SessionServiceCommunication=this.j;this.i=b&&b.addEventListener&&b.postMessage?new gc(b):null;this.j.g=this.m.bind(this);this.i&&(this.i.g=this.l.bind(this))}pc.prototype.m=function(a,b){null!=ec(a.method)&&rc(this,a,b,this.j)};pc.prototype.l=function(a,b){null!=ec(a.method)&&rc(this,a,b,this.i)};\nfunction rc(a,b,c,d){function e(){var g=new W(f,'response',k,nc(k,w.apply(0,arguments)));d.h(g,c)}var f=b.h,h=b.method,k=b.version;b=oc(k,b.g);try{sc(a,h,e,b)}catch(g){d.h(new W(f,'error',k,'\\n        name: '+g.name+'\\n        message: '+g.message+'\\n        filename: '+g.filename+'\\n        lineNumber: '+g.lineNumber+'\\n        columnNumber: '+g.columnNumber+'\\n        stack: '+g.stack+'\\n        toString(): '+g.toString()),c)}}\nfunction sc(a,b,c,d){if(null!=ec(b))switch(ec(b)){case 'registerAdEvents':c=p(d).next().value;qb(V(a.g.g,c).h,'javascript');break;case 'registerMediaEvents':c=p(d).next().value;ob(V(a.g.g,c).h,'javascript');break;case 'registerSessionObserver':var e=p(d).next().value;a.g.registerSessionObserver(e,c);break;case 'setSlotElement':e=p(d);c=e.next().value;e=e.next().value;a.g.setSlotElement(e,c);break;case 'setVideoElement':e=p(d);c=e.next().value;e=e.next().value;a=V(a.g.g,e);c&&c.tagName&&'video'===\nc.tagName.toLowerCase()?(a.g.j=c,a.i&&Ab(a.i)):K('setVideoElement called with a non-HTMLVideoElement. It will be ignored.');break;case 'setElementBounds':e=p(d);c=e.next().value;e=e.next().value;a.g.setElementBounds(e,c);break;case 'startSession':c=p(d);d=c.next().value;c=c.next().value;b=a.h;if(null!=d&&N(d)){var f=d.customReferenceData,h=d.underEvaluation,k=d.universalAdId;P(f)||(f=void 0);'boolean'===typeof h||(h=!1);d={customReferenceData:f,underEvaluation:h};P(k)&&(d.universalAdId=k);if('object'===\ntypeof Nb(b)){var g=Nb(b),l;'object'===typeof g&&(l=g.identifier);d.app={appId:l&&'string'===typeof l?l:void 0};b:if(g=Nb(b),'object'===typeof g){try{e=JSON.parse(g.deviceInfo)}catch(F){e=void 0;break b}e={deviceType:e.modelName||'Unknown',osVersion:e.platformVersion||'Unknown',os:'webOS'}}else e=void 0;d.deviceInfo=e;d.deviceCategory='ctv'}else if(Pb(b)){b:{if(Pb(b)){try{var m=Ob(b).application.getCurrentApplication().appInfo.id}catch(F){e=void 0;break b}if('string'===typeof m){e=m;break b}}e=void 0}d.app=\n{appId:e};if(Pb(b)){e=Ob(b).systeminfo;if('object'===typeof e&&'function'===typeof e.getCapability){g=e.getCapability('http://tizen.org/system/model_name');var r=e.getCapability('http://tizen.org/feature/platform.version')}e={deviceType:g||'Unknown',osVersion:r||'Unknown',os:'tizen'}}else e=void 0;d.deviceInfo=e;Pb(b)&&'object'===typeof Ob(b).tvinputdevice&&(d.deviceCategory='ctv')}}else d=null;if(null==d)break;kc(a.g,c,d,!1);break;case 'finishSession':c=p(d).next().value;lc(a.g,c,!1);break;case 'impressionOccurred':c=\np(d).next().value;Y(a.g,c,'impression');break;case 'loaded':e=p(d);c=e.next().value;e=e.next().value;c?(g={skippable:c.isSkippable,autoPlay:c.isAutoPlay,position:c.position},c.isSkippable&&(g.skipOffset=c.skipOffset),Y(a.g,e,'loaded',g)):Y(a.g,e,'loaded');break;case 'start':g=p(d);c=g.next().value;e=g.next().value;g=g.next().value;Y(a.g,g,'start',{duration:c,mediaPlayerVolume:e});break;case 'firstQuartile':c=p(d).next().value;Y(a.g,c,'firstQuartile');break;case 'midpoint':c=p(d).next().value;Y(a.g,\nc,'midpoint');break;case 'thirdQuartile':c=p(d).next().value;Y(a.g,c,'thirdQuartile');break;case 'complete':c=p(d).next().value;Y(a.g,c,'complete');break;case 'pause':c=p(d).next().value;Y(a.g,c,'pause');break;case 'resume':c=p(d).next().value;Y(a.g,c,'resume');break;case 'bufferStart':c=p(d).next().value;Y(a.g,c,'bufferStart');break;case 'bufferFinish':c=p(d).next().value;Y(a.g,c,'bufferFinish');break;case 'skipped':c=p(d).next().value;Y(a.g,c,'skipped');break;case 'volumeChange':e=p(d);c=e.next().value;\ne=e.next().value;Y(a.g,e,'volumeChange',{mediaPlayerVolume:c});break;case 'playerStateChange':e=p(d);c=e.next().value;e=e.next().value;Y(a.g,e,'playerStateChange',{state:c});break;case 'adUserInteraction':e=p(d);c=e.next().value;e=e.next().value;Y(a.g,e,'adUserInteraction',{interactionType:c});break;case 'setClientInfo':l=p(d);e=l.next().value;g=l.next().value;r=l.next().value;l=l.next().value;a=a.g.setClientInfo(l,e,g,r);c(a);break;case 'injectVerificationScriptResources':e=p(d);c=e.next().value;\ne=e.next().value;a.g.injectVerificationScriptResources(e,c);break;case 'setCreativeType':e=p(d);c=e.next().value;e=e.next().value;a.g.setCreativeType(e,c);break;case 'setImpressionType':e=p(d);c=e.next().value;e=e.next().value;a.g.setImpressionType(e,c);break;case 'setContentUrl':e=p(d);c=e.next().value;e=e.next().value;V(a.g.g,e).g.C=c;break;case 'sessionError':g=p(d),c=g.next().value,e=g.next().value,g=g.next().value,a.g.error(g,c,e)}};function Z(){this.g=qc}n=Z.prototype;\nn.da=function(a,b){if(!(!(a&&N(a)&&Q(a.impressionOwner,qa))||'videoEventsOwner'in a&&null!=a.videoEventsOwner&&!Q(a.videoEventsOwner,qa)||'mediaEventsOwner'in a&&null!=a.mediaEventsOwner&&!Q(a.mediaEventsOwner,qa))){b=V(this.g.g,b);if(a.creativeType&&a.impressionType){var c=a.mediaEventsOwner;null==b.g.h&&b.setCreativeType(a.creativeType,c);null==b.g.l&&(b.g.l=a.impressionType);ob(b.h,c)}else c=a.videoEventsOwner,b.g.g=null==c||'none'===c?'display':'video',b.g.h=null,b.g.l=null,ob(b.h,c);qb(b.h,a.impressionOwner);\na&&null!=a.isolateVerificationScripts&&'boolean'===typeof a.isolateVerificationScripts&&(b.g.I=a.isolateVerificationScripts)}};\nn.aa=function(a,b,c,d){b&&'string'===typeof b.adSessionType&&(b.adSessionType=b.adSessionType.toLowerCase());var e;if(N(b)){if(e=Q(b.environment,ua)&&Q(b.adSessionType,pa))e=b.omidNativeInfo,e=N(e)?P(e.partnerName)&&P(e.partnerVersion):!1;e&&(e=b.app,e=N(e)?P(e.libraryVersion)&&P(e.appId):!1)}else e=!1;if(e){if($b(d)){e=p(Object.values(d));for(var f=e.next();!f.done;f=e.next())f.value.accessMode='limited';V(this.g.g,a).g.v=new Map(Object.entries(d))}kc(this.g,a,b,!0,c)}else K('Native ad session context invalid; session not started.')};\nn.W=function(a){lc(this.g,a,!0)};n.$=function(a,b){N(a)&&O(a.x)&&O(a.y)&&O(a.width)&&O(a.height)&&(b=V(this.g.g,b),b.g.L=a,M(b.j,'container'))};n.ha=function(a,b){Q(a,sa)&&(b=V(this.g.g,b),b.g.A=a,'backgrounded'===a?M(b.j,'container','backgrounded'):M(b.j,'container'))};n.Y=function(a,b){Q(a,ta)&&(b=V(this.g.g,b),b.g.M=a,'locked'===a?M(b.j,'container','deviceLocked'):M(b.j,'container'))};n.ea=function(a){'impression'===a&&this.T()};n.T=function(a){a=V(this.g.g,a);rb(a.h,'native')&&kb(a.h,'native')};\nn.X=function(a,b){this.S('loaded',void 0===a?null:a,b)};n.error=function(a,b,c){Q(a,oa)&&this.g.error(c,a,b)};n.fa=function(a,b,c){this.S(a,b,c)};n.S=function(a,b,c){Q(a,y)&&(void 0===b||N(b))&&(c=V(this.g.g,c),pb(c.h,'native')&&('loaded'==a?lb(c.h,'native',b):mb(c.h,a,'native',b)))};n.Z=function(a,b){b=V(this.g.g,b);'none'===b.h.g.o||'number'!==typeof a||isNaN(a)||(b.g.D=a,a=b.s,b=a.g.J,null!=b&&mb(a.h,'volumeChange','native',{mediaPlayerVolume:b,deviceVolume:a.g.D}))};\nn.ga=function(a){if(a&&N(a)&&O(a.timestamp)){var b=Na(),c=(b.g||{}).timestamp;if(!c||c<a.timestamp)b.g=a}};Z.prototype.startSession=Z.prototype.aa;Z.prototype.error=Z.prototype.error;Z.prototype.finishSession=Z.prototype.W;Z.prototype.publishAdEvent=Z.prototype.ea;Z.prototype.publishImpressionEvent=Z.prototype.T;Z.prototype.publishVideoEvent=Z.prototype.fa;Z.prototype.publishMediaEvent=Z.prototype.S;Z.prototype.publishLoadedEvent=Z.prototype.X;Z.prototype.setNativeViewHierarchy=Z.prototype.$;\nZ.prototype.setState=Z.prototype.ha;Z.prototype.setDeviceLockState=Z.prototype.Y;Z.prototype.setDeviceVolume=Z.prototype.Z;Z.prototype.init=Z.prototype.da;Z.prototype.setLastActivity=Z.prototype.ga;function tc(){var a=jc,b=uc,c=this;var d=void 0===d?J:d;this.j=a;this.g=b;this.l={};this.m={};this.i=new X;d.omid=d.omid||{};d.omid.v1_VerificationServiceCommunication=this.i;this.h=null;d&&d.addEventListener&&d.postMessage&&(this.h=new gc(d));this.i.g=function(e,f){vc(c,e,f,c.i)};this.h&&(this.h.g=function(e,f){c.h&&vc(c,e,f,c.h)})}function wc(a,b,c,d){a=Yb(a.j,d).h;'media'===b||'video'===b?$a(a,c,d):(c={type:b,R:d,G:c},a.j.push(c),Za(a,b,c))}function xc(a,b,c,d){a=Yb(a.j,d);Xb(a,b,c,d)}\nfunction yc(a,b,c,d){xb(a.g,b,c,d)}tc.prototype.setInterval=function(a,b){return this.g.setInterval(a,b)};tc.prototype.clearInterval=function(a){this.g.clearInterval(a)};function zc(a,b,c,d){wb(a.g,'downloadJavaScriptResource')(b,c,d)}\nfunction vc(a,b,c,d){function e(){var B=new W(f,'response',k,nc(k,w.apply(0,arguments)));d.h(B,c)}var f=b.h,h=b.method,k=b.version;b=oc(k,b.g);if(null!=fc(h,'VerificationService.')){h=fc(h,'VerificationService.');try{switch(h){case 'addEventListener':var g=p(b),l=g.next().value,m=g.next().value||Ac(c);wc(a,l,e,m);break;case 'addSessionListener':var r=p(b),F=r.next().value,ba=r.next().value||Ac(c);xc(a,e,F,ba);break;case 'sendUrl':var R=p(b).next().value;yc(a,R,function(){return e(!0)},function(){return e(!1)});\nbreak;case 'setTimeout':var G=p(b),Ec=G.next().value,Fc=G.next().value;a.l[Ec]=ub(a.g,'setTimeout')(e,Fc);break;case 'clearTimeout':var Gc=p(b).next().value;vb(a.g,a.l[Gc]);break;case 'setInterval':var Rb=p(b),Hc=Rb.next().value,Ic=Rb.next().value;a.m[Hc]=a.setInterval(e,Ic);break;case 'clearInterval':var Jc=p(b).next().value;a.clearInterval(a.m[Jc]);break;case 'injectJavaScriptResource':var Kc=p(b).next().value;zc(a,Kc,function(B){return e(!0,B)},function(){return e(!1)});break;case 'getVersion':e('1.5.5-iab77')}}catch(B){d.h(new W(f,\n'error',k,'\\n              name: '+B.name+'\\n              message: '+B.message+'\\n              filename: '+B.filename+'\\n              lineNumber: '+B.lineNumber+'\\n              columnNumber: '+B.columnNumber+'\\n              stack: '+B.stack+'\\n              toString(): '+B.toString()+'\\n          '),c)}}}\nfunction Ac(a){for(var b=Na().h,c=p(b.keys()),d=c.next();!d.done;d=c.next()){d=d.value;var e=b.get(d);if(e){if(e.contentWindow===a)return d;try{if(e.contentWindow.Object.prototype.isPrototypeOf(a))return d}catch(f){}}}};function Bc(a){var b={};return(b.app='omid_v1_present_app',b.web='omid_v1_present_web',b)[a]}function Cc(a,b){a.document.write('<iframe style=\"display:none\" id=\"'+(b+'\" name=\"'+b+'\" sandbox></iframe>'))}function Dc(a,b){var c=a.document.createElement('iframe');c.id=b;c.name=b;c.style.display='none';c.sandbox='';a.document.body.appendChild(c)}\nfunction Lc(a,b){var c=new MutationObserver(function(d){d.forEach(function(e){'BODY'===e.addedNodes[0].nodeName&&(e=Bc(b),Dc(a,'omid_v1_present'),Dc(a,e),c.disconnect())})});c.observe(a.document.documentElement,{childList:!0})};var uc=new tb,jc=new function(){this.i=uc;this.h=new Map;this.g=Zb(this)},qc=new ic;new tc;J.omidBridge=new Z;new pc;(function(a,b){a.frames&&a.document&&!['omid_v1_present','omid_v1_present_web','omid_v1_present_app'].some(function(c){return!!a.frames[c]})&&(null==a.document.body&&'MutationObserver'in a?Lc(a,b):(b=Bc(b),a.document.body?(Dc(a,'omid_v1_present'),Dc(a,b)):(Cc(a,'omid_v1_present'),Cc(a,b))))})(J,'app');\n}).call(this, this);";
                                            AdSessionContext createNativeAdSessionContext = AdSessionContext.createNativeAdSessionContext(c2796oa.b, str3, verificationScriptResources, e2, str12);
                                            Intrinsics.checkNotNullExpressionValue(createNativeAdSessionContext, "createNativeAdSessionContext(...)");
                                            hashMap2.put(obj, new C2667ga("native_video_ad", ImpressionType.VIEWABLE, createNativeAdSessionContext, false));
                                            c2833qe.b.put("deferred", Boolean.TRUE);
                                            InterfaceC2971z5 interfaceC2971z55 = this.j;
                                            if (interfaceC2971z55 != null) {
                                                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                                                ((A5) interfaceC2971z55).a("S0", "OMID video ad session created and JavaScript resources injected");
                                            }
                                        }
                                    }
                                } catch (Exception e3) {
                                    InterfaceC2971z5 interfaceC2971z56 = this.j;
                                    if (interfaceC2971z56 != null) {
                                        ((A5) interfaceC2971z56).b("S0", rf.a(e3, H6.a("S0", "TAG", "Setting up impression tracking for OMID Native Video encountered an unexpected error: ")));
                                    }
                                    S5 s5 = S5.f2425a;
                                    S5.d.a(AbstractC2920w5.a(e3, "event"));
                                }
                            } else {
                                String str13 = "macros";
                                Object obj4 = "OMID_VIEWABILITY";
                                InterfaceC2971z5 interfaceC2971z57 = this.j;
                                if (interfaceC2971z57 != null) {
                                    str = "event";
                                    ((A5) interfaceC2971z57).c("S0", D0.a("S0", "TAG", "initOmidForNativeDisplayAd ", this));
                                } else {
                                    str = "event";
                                }
                                try {
                                    byte J2 = J();
                                    String L2 = L();
                                    Intrinsics.checkNotNull(L2);
                                    JSONObject pubContent2 = new JSONObject(L2);
                                    AdConfig adConfig4 = this.b;
                                    Intrinsics.checkNotNull(adConfig4);
                                    C2947y0 c2947y02 = this.u;
                                    if (c2947y02 == null) {
                                        a2 = null;
                                    } else {
                                        boolean z5 = T9.f2439a;
                                        a2 = T9.a(c2947y02.h());
                                    }
                                    InterfaceC2971z5 interfaceC2971z58 = this.j;
                                    Intrinsics.checkNotNullParameter(pubContent2, "pubContent");
                                    Intrinsics.checkNotNullParameter(adConfig4, "adConfig");
                                    try {
                                        c2613d8 = (C2613d8) new C2811p8(J2, pubContent2, null, false, adConfig4, a2, null, interfaceC2971z58).n("CONTAINER").get(0);
                                    } catch (Exception e4) {
                                        e = e4;
                                        z = false;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    z = false;
                                }
                                if (context != null) {
                                    ArrayList verificationScriptResources2 = new ArrayList();
                                    Iterator it5 = c2613d8.s.iterator();
                                    while (it5.hasNext()) {
                                        U8 u82 = (U8) it5.next();
                                        Object obj5 = obj4;
                                        if (Intrinsics.areEqual(obj5, u82.b) && (u82 instanceof C2683ha)) {
                                            Iterator it6 = it5;
                                            String str14 = str13;
                                            Map map2 = (Map) c2833qe.a(str14, Map.class);
                                            str13 = str14;
                                            String a7 = G0.a(((C2683ha) u82).g, map2);
                                            obj4 = obj5;
                                            String str15 = ((C2683ha) u82).h;
                                            String a8 = G0.a(u82.d, map2);
                                            if (B2.a(a7) && B2.a(str15)) {
                                                createVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithParameters(str15, new URL(a8), a7);
                                                Intrinsics.checkNotNull(createVerificationScriptResourceWithoutParameters);
                                            } else {
                                                createVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(new URL(a8));
                                                Intrinsics.checkNotNull(createVerificationScriptResourceWithoutParameters);
                                            }
                                            verificationScriptResources2.add(createVerificationScriptResourceWithoutParameters);
                                            it5 = it6;
                                        } else {
                                            obj4 = obj5;
                                        }
                                    }
                                    if (verificationScriptResources2.size() != 0) {
                                        HashMap hashMap3 = c2833qe.b;
                                        String e6 = this.t.e();
                                        String str16 = (String) c2833qe.b.get("creativeType");
                                        Intrinsics.checkNotNullParameter(verificationScriptResources2, "verificationScriptResources");
                                        C2796oa c2796oa2 = AbstractC2780na.f2651a;
                                        c2796oa2.getClass();
                                        Intrinsics.checkNotNullParameter(verificationScriptResources2, "verificationScriptResources");
                                        Context d2 = Uc.d();
                                        if (d2 != null) {
                                            str2 = new Sa(d2, "omid_js_store").a("omid_js_string");
                                            if (str2 == null) {
                                                str2 = null;
                                            }
                                        }
                                        str2 = ";(function(omidGlobal) {\n  var n;function aa(a){var b=0;return function(){return b<a.length?{done:!1,value:a[b++]}:{done:!0}}}function p(a){var b='undefined'!=typeof Symbol&&Symbol.iterator&&a[Symbol.iterator];if(b)return b.call(a);if('number'==typeof a.length)return{next:aa(a)};throw Error(String(a)+' is not an iterable or ArrayLike');}function q(a){if(!(a instanceof Array)){a=p(a);for(var b,c=[];!(b=a.next()).done;)c.push(b.value);a=c}return a}\nvar ca='function'==typeof Object.create?Object.create:function(a){function b(){}b.prototype=a;return new b},t='function'==typeof Object.defineProperties?Object.defineProperty:function(a,b,c){if(a==Array.prototype||a==Object.prototype)return a;a[b]=c.value;return a};\nfunction da(a){a=['object'==typeof globalThis&&globalThis,a,'object'==typeof window&&window,'object'==typeof self&&self,'object'==typeof global&&global];for(var b=0;b<a.length;++b){var c=a[b];if(c&&c.Math==Math)return c}throw Error('Cannot find global object');}var ea=da(this);function u(a,b){if(b)a:{var c=ea;a=a.split('.');for(var d=0;d<a.length-1;d++){var e=a[d];if(!(e in c))break a;c=c[e]}a=a[a.length-1];d=c[a];b=b(d);b!=d&&null!=b&&t(c,a,{configurable:!0,writable:!0,value:b})}}var fa;\nif('function'==typeof Object.setPrototypeOf)fa=Object.setPrototypeOf;else{var ha;a:{var ia={a:!0},ja={};try{ja.__proto__=ia;ha=ja.a;break a}catch(a){}ha=!1}fa=ha?function(a,b){a.__proto__=b;if(a.__proto__!==b)throw new TypeError(a+' is not extensible');return a}:null}var ka=fa;\nfunction v(a,b){a.prototype=ca(b.prototype);a.prototype.constructor=a;if(ka)ka(a,b);else for(var c in b)if('prototype'!=c)if(Object.defineProperties){var d=Object.getOwnPropertyDescriptor(b,c);d&&Object.defineProperty(a,c,d)}else a[c]=b[c];a.La=b.prototype}function w(){for(var a=Number(this),b=[],c=a;c<arguments.length;c++)b[c-a]=arguments[c];return b}function x(a,b){return Object.prototype.hasOwnProperty.call(a,b)}\nvar la='function'==typeof Object.assign?Object.assign:function(a,b){for(var c=1;c<arguments.length;c++){var d=arguments[c];if(d)for(var e in d)x(d,e)&&(a[e]=d[e])}return a};u('Object.assign',function(a){return a||la});\nu('Symbol',function(a){function b(f){if(this instanceof b)throw new TypeError('Symbol is not a constructor');return new c(d+(f||'')+'_'+e++,f)}function c(f,h){this.g=f;t(this,'description',{configurable:!0,writable:!0,value:h})}if(a)return a;c.prototype.toString=function(){return this.g};var d='jscomp_symbol_'+(1E9*Math.random()>>>0)+'_',e=0;return b});\nu('Symbol.iterator',function(a){if(a)return a;a=Symbol('Symbol.iterator');for(var b='Array Int8Array Uint8Array Uint8ClampedArray Int16Array Uint16Array Int32Array Uint32Array Float32Array Float64Array'.split(' '),c=0;c<b.length;c++){var d=ea[b[c]];'function'===typeof d&&'function'!=typeof d.prototype[a]&&t(d.prototype,a,{configurable:!0,writable:!0,value:function(){return ma(aa(this))}})}return a});function ma(a){a={next:a};a[Symbol.iterator]=function(){return this};return a}\nu('WeakMap',function(a){function b(g){this.g=(k+=Math.random()+1).toString();if(g){g=p(g);for(var l;!(l=g.next()).done;)l=l.value,this.set(l[0],l[1])}}function c(){}function d(g){var l=typeof g;return'object'===l&&null!==g||'function'===l}function e(g){if(!x(g,h)){var l=new c;t(g,h,{value:l})}}function f(g){var l=Object[g];l&&(Object[g]=function(m){if(m instanceof c)return m;Object.isExtensible(m)&&e(m);return l(m)})}if(function(){if(!a||!Object.seal)return!1;try{var g=Object.seal({}),l=Object.seal({}),\nm=new a([[g,2],[l,3]]);if(2!=m.get(g)||3!=m.get(l))return!1;m.delete(g);m.set(l,4);return!m.has(g)&&4==m.get(l)}catch(r){return!1}}())return a;var h='$jscomp_hidden_'+Math.random();f('freeze');f('preventExtensions');f('seal');var k=0;b.prototype.set=function(g,l){if(!d(g))throw Error('Invalid WeakMap key');e(g);if(!x(g,h))throw Error('WeakMap key fail: '+g);g[h][this.g]=l;return this};b.prototype.get=function(g){return d(g)&&x(g,h)?g[h][this.g]:void 0};b.prototype.has=function(g){return d(g)&&x(g,\nh)&&x(g[h],this.g)};b.prototype.delete=function(g){return d(g)&&x(g,h)&&x(g[h],this.g)?delete g[h][this.g]:!1};return b});\nu('Map',function(a){function b(){var k={};return k.H=k.next=k.head=k}function c(k,g){var l=k.g;return ma(function(){if(l){for(;l.head!=k.g;)l=l.H;for(;l.next!=l.head;)return l=l.next,{done:!1,value:g(l)};l=null}return{done:!0,value:void 0}})}function d(k,g){var l=g&&typeof g;'object'==l||'function'==l?f.has(g)?l=f.get(g):(l=''+ ++h,f.set(g,l)):l='p_'+g;var m=k.h[l];if(m&&x(k.h,l))for(k=0;k<m.length;k++){var r=m[k];if(g!==g&&r.key!==r.key||g===r.key)return{id:l,list:m,index:k,B:r}}return{id:l,list:m,\nindex:-1,B:void 0}}function e(k){this.h={};this.g=b();this.size=0;if(k){k=p(k);for(var g;!(g=k.next()).done;)g=g.value,this.set(g[0],g[1])}}if(function(){if(!a||'function'!=typeof a||!a.prototype.entries||'function'!=typeof Object.seal)return!1;try{var k=Object.seal({x:4}),g=new a(p([[k,'s']]));if('s'!=g.get(k)||1!=g.size||g.get({x:4})||g.set({x:4},'t')!=g||2!=g.size)return!1;var l=g.entries(),m=l.next();if(m.done||m.value[0]!=k||'s'!=m.value[1])return!1;m=l.next();return m.done||4!=m.value[0].x||\n't'!=m.value[1]||!l.next().done?!1:!0}catch(r){return!1}}())return a;var f=new WeakMap;e.prototype.set=function(k,g){k=0===k?0:k;var l=d(this,k);l.list||(l.list=this.h[l.id]=[]);l.B?l.B.value=g:(l.B={next:this.g,H:this.g.H,head:this.g,key:k,value:g},l.list.push(l.B),this.g.H.next=l.B,this.g.H=l.B,this.size++);return this};e.prototype.delete=function(k){k=d(this,k);return k.B&&k.list?(k.list.splice(k.index,1),k.list.length||delete this.h[k.id],k.B.H.next=k.B.next,k.B.next.H=k.B.H,k.B.head=null,this.size--,\n!0):!1};e.prototype.clear=function(){this.h={};this.g=this.g.H=b();this.size=0};e.prototype.has=function(k){return!!d(this,k).B};e.prototype.get=function(k){return(k=d(this,k).B)&&k.value};e.prototype.entries=function(){return c(this,function(k){return[k.key,k.value]})};e.prototype.keys=function(){return c(this,function(k){return k.key})};e.prototype.values=function(){return c(this,function(k){return k.value})};e.prototype.forEach=function(k,g){for(var l=this.entries(),m;!(m=l.next()).done;)m=m.value,\nk.call(g,m[1],m[0],this)};e.prototype[Symbol.iterator]=e.prototype.entries;var h=0;return e});u('Object.values',function(a){return a?a:function(b){var c=[],d;for(d in b)x(b,d)&&c.push(b[d]);return c}});function na(a,b){a instanceof String&&(a+='');var c=0,d=!1,e={next:function(){if(!d&&c<a.length){var f=c++;return{value:b(f,a[f]),done:!1}}d=!0;return{done:!0,value:void 0}}};e[Symbol.iterator]=function(){return e};return e}u('Array.prototype.keys',function(a){return a?a:function(){return na(this,function(b){return b})}});\nu('Set',function(a){function b(c){this.g=new Map;if(c){c=p(c);for(var d;!(d=c.next()).done;)this.add(d.value)}this.size=this.g.size}if(function(){if(!a||'function'!=typeof a||!a.prototype.entries||'function'!=typeof Object.seal)return!1;try{var c=Object.seal({x:4}),d=new a(p([c]));if(!d.has(c)||1!=d.size||d.add(c)!=d||1!=d.size||d.add({x:4})!=d||2!=d.size)return!1;var e=d.entries(),f=e.next();if(f.done||f.value[0]!=c||f.value[1]!=c)return!1;f=e.next();return f.done||f.value[0]==c||4!=f.value[0].x||\nf.value[1]!=f.value[0]?!1:e.next().done}catch(h){return!1}}())return a;b.prototype.add=function(c){c=0===c?0:c;this.g.set(c,c);this.size=this.g.size;return this};b.prototype.delete=function(c){c=this.g.delete(c);this.size=this.g.size;return c};b.prototype.clear=function(){this.g.clear();this.size=0};b.prototype.has=function(c){return this.g.has(c)};b.prototype.entries=function(){return this.g.entries()};b.prototype.values=function(){return this.g.values()};b.prototype.keys=b.prototype.values;b.prototype[Symbol.iterator]=\nb.prototype.values;b.prototype.forEach=function(c,d){var e=this;this.g.forEach(function(f){return c.call(d,f,f,e)})};return b});u('Object.is',function(a){return a?a:function(b,c){return b===c?0!==b||1/b===1/c:b!==b&&c!==c}});u('Array.prototype.includes',function(a){return a?a:function(b,c){var d=this;d instanceof String&&(d=String(d));var e=d.length;c=c||0;for(0>c&&(c=Math.max(c+e,0));c<e;c++){var f=d[c];if(f===b||Object.is(f,b))return!0}return!1}});\nu('String.prototype.includes',function(a){return a?a:function(b,c){if(null==this)throw new TypeError(\"The 'this' value for String.prototype.includes must not be null or undefined\");if(b instanceof RegExp)throw new TypeError('First argument to String.prototype.includes must not be a regular expression');return-1!==this.indexOf(b,c||0)}});u('Object.entries',function(a){return a?a:function(b){var c=[],d;for(d in b)x(b,d)&&c.push([d,b[d]]);return c}});\nu('Array.prototype.values',function(a){return a?a:function(){return na(this,function(b,c){return c})}});\nvar y={xa:'loaded',Fa:'start',ra:'firstQuartile',Aa:'midpoint',Ga:'thirdQuartile',pa:'complete',Ba:'pause',Da:'resume',oa:'bufferStart',na:'bufferFinish',Ea:'skipped',Ja:'volumeChange',Ca:'playerStateChange',ka:'adUserInteraction'},oa={ua:'generic',Ia:'video',za:'media'},pa={ca:'native',va:'html',V:'javascript'},qa={ca:'native',V:'javascript',NONE:'none'},ra={ta:'full',qa:'domain',wa:'limited'},sa={ma:'backgrounded',sa:'foregrounded'},ta={ya:'locked',Ha:'unlocked'},ua={la:'app',Ka:'web'};function z(a,b){this.x=null!=a.x?a.x:a.left;this.y=null!=a.y?a.y:a.top;this.width=a.width;this.height=a.height;this.endX=this.x+this.width;this.endY=this.y+this.height;this.adSessionId=a.adSessionId||void 0;this.isFriendlyObstructionFor=a.isFriendlyObstructionFor||[];this.h=a.friendlyObstructionClass||void 0;this.i=a.friendlyObstructionPurpose||void 0;this.j=a.friendlyObstructionReason||void 0;this.clipsToBounds=void 0!==a.clipsToBounds?!0===a.clipsToBounds:!0;this.m=void 0!==a.hasWindowFocus?!0===\na.hasWindowFocus:!0;this.notVisibleReason=a.notVisibleReason||void 0;this.noOutputDevice=a.noOutputDevice||void 0;this.isPipActive='true'===a.isPipActive||!0===a.isPipActive||!1;this.childViews=a.childViews||[];this.isCreative=a.isCreative||!1;this.g=b}function va(a){var b={};return b.width=a.width,b.height=a.height,b}function A(a){var b={};return Object.assign({},va(a),(b.x=a.x,b.y=a.y,b))}function C(a){var b=A(a),c={};return Object.assign({},b,(c.endX=a.endX,c.endY=a.endY,c))}\nfunction wa(a,b,c){a.x+=b;a.y+=c;a.endX+=b;a.endY+=c}z.prototype.N=function(a){if(null==a)return!1;a=A(a);var b=a.y,c=a.width,d=a.height;return this.x===a.x&&this.y===b&&this.width===c&&this.height===d};function xa(a){return a.width*a.height}function D(a){return 0===a.width||0===a.height};function ya(a,b){a=A(a);for(var c=[],d=[],e=0;e<b.length;e++){var f=A(b[e]);f=za(a,f);E(c,f.x);E(c,f.endX);E(d,f.y);E(d,f.endY)}c=c.sort(function(h,k){return h-k});d=d.sort(function(h,k){return h-k});return{ia:c,ja:d}}function za(a,b){return{x:Math.max(a.x,b.x),y:Math.max(a.y,b.y),endX:Math.min(a.x+a.width,b.x+b.width),endY:Math.min(a.y+a.height,b.y+b.height)}}function E(a,b){-1===a.indexOf(b)&&a.push(b)};function H(){this.h=this.g=this.D=this.u=this.m=this.s=void 0;this.A=0;this.l=[];this.v=[];this.C=0;this.o=[];this.j=[];this.i=[]}H.prototype.N=function(a){return null==a?!1:JSON.stringify(Aa(this))===JSON.stringify(Aa(a))};\nfunction Aa(a){var b=[],c=[],d={viewport:a.s,adView:{percentageInView:a.A,pixelsInView:a.C,reasons:a.i},declaredFriendlyObstructions:a.l.length};if(void 0!==a.g){d.adView.geometry=A(a.g);d.adView.geometry.pixels=xa(a.g);d.adView.onScreenGeometry=A(a.h);d.adView.onScreenGeometry.pixels=Ba(a);for(var e=0;e<a.j.length;e++)b.push(A(a.j[e]));for(e=0;e<a.v.length;e++){var f=a.v[e],h=f,k={};h.h&&(k.obstructionClass=h.h);h.i&&(k.obstructionPurpose=h.i);h.j&&(k.obstructionReason=h.j);f=za(a.g,f);c.push(Object.assign({},\n{x:f.x,y:f.y,width:f.endX-f.x,height:f.endY-f.y},k))}d.adView.onScreenGeometry.obstructions=b;d.adView.onScreenGeometry.friendlyObstructions=c;void 0!==a.u&&void 0!==a.D&&(d.adView.containerGeometry=A(a.u),d.adView.onScreenContainerGeometry=A(a.D),d.adView.measuringElement=!0)}return d}function Ca(a,b){b=va(b);a.s={};a.s.width=b.width;a.s.height=b.height;a.m={};a.m.x=0;a.m.y=0;a.m.width=b.width;a.m.height=b.height;a.m.endX=b.width;a.m.endY=b.height}\nfunction Da(){return{x:0,y:0,endX:0,endY:0,width:0,height:0}}function Ea(a,b){var c={};c.x=Math.max(a.x,b.x);c.y=Math.max(a.y,b.y);c.endX=Math.min(a.endX,b.endX);c.endY=Math.min(a.endY,b.endY);c.width=Math.max(0,c.endX-c.x);c.height=Math.max(0,c.endY-c.y);return c}function Fa(a,b){return.01<b.width-a.width||.01<b.height-a.height}function Ga(a){if(-1!==a.i.indexOf('backgrounded'))a.A=0,a.C=0;else{var b=xa(a.g);if(0!==b){var c=Ba(a);a.A=Math.round(c/b*100);a.C=c}}}\nfunction Ha(a,b){if(D(b)||!a.h)b=!1;else{var c=C(a.h),d=c.y,e=c.endX;a=c.endY;var f=b.endX;c=c.x;(f=f<c||.01>Math.abs(f-c))||(f=b.x,f=f>e||.01>Math.abs(f-e));(e=f)||(e=b.endY,e=e<d||.01>Math.abs(e-d));(d=e)||(b=b.y,d=b>a||.01>Math.abs(b-a));b=!d}return b}function I(a,b){for(var c=!1,d=0;d<a.i.length;d++)a.i[d]===b&&(c=!0);c||a.i.push(b)}\nfunction Ba(a){var b=Math,c=b.max,d=xa(a.h),e=a.j,f=0;if(0<e.length){var h=ya(a.h,e);a=h.ia;h=h.ja;for(var k=0;k<a.length-1;k++)for(var g=(a[k]+(a[k]+1))/2,l=a[k+1]-a[k],m=0;m<h.length-1;m++){for(var r=(h[m]+(h[m]+1))/2,F=h[m+1]-h[m],ba=!1,R=0;R<e.length;R++){var G=A(e[R]);if(G.x<g&&G.x+G.width>g&&G.y<r&&G.y+G.height>r){ba=!0;break}}ba&&(f+=Math.round(l)*Math.round(F))}}return c.call(b,0,d-f)};function Ia(){};function Ja(){}\nfunction Ka(a,b,c,d,e,f){var h=new H;b=new z(b,!1);Ca(h,b);La(a,b,h,d);if(!e)return h.i=['unmeasurable'],h.s=void 0,h.A=0,h.j=[],h.g&&(a=h.g,c={},a=new z((c.x=0,c.y=0,c.width=a.width,c.height=a.height,c),a.g),h.g=a),h.h=Da(),h;'locked'===f&&I(h,'deviceLocked');if(b.noOutputDevice)I(h,'backgrounded'),I(h,'noOutputDevice');else if('backgrounded'===c)I(h,'backgrounded');else if(void 0!==h.g){for(a=0;a<h.l.length;a++)Ha(h,h.l[a])&&h.v.push(h.l[a]);for(a=0;a<h.o.length;a++){if(c=Ha(h,h.o[a])){a:{c=h.o[a];\nfor(d=0;d<h.j.length;d++)if(h.j[d].N(c)){c=!0;break a}c=!1}c=!c}c&&(I(h,'obstructed'),h.j.push(h.o[a]))}Ga(h)}else I(h,'notFound');return h}\nfunction La(a,b,c,d){var e=b.isCreative?!0:b.adSessionId===d;if(e){c.g=b;var f=C(c.g);a=Ea(c.m,f);var h=c.g;'notAttached'===h.notVisibleReason||'noWindowFocus'===h.notVisibleReason||'noAdView'===h.notVisibleReason?(I(c,'notFound'),c.h=new z(Da(),!1)):(h=c.g,'viewInvisible'===h.notVisibleReason||'viewGone'===h.notVisibleReason||'viewNotVisible'===h.notVisibleReason||'viewAlphaZero'===h.notVisibleReason||'viewHidden'===h.notVisibleReason||void 0!==c.g.notVisibleReason||D(c.g)?(I(c,'hidden'),c.h=new z(Da(),\n!1)):(c.g.isPipActive&&I(c,'pictureInPicture'),c.g.m||(I(c,'backgrounded'),I(c,'noWindowFocus')),Fa(a,f)&&I(c,'clipped'),c.h=new z(a,!1)))}else if(f=!0,b.g&&(f=-1!==b.isFriendlyObstructionFor.indexOf(d)?!1:!1===b.clipsToBounds),f){h=b.childViews;for(var k=0;k<h.length;k++)f=void 0!==c.g,La(a,new z(h[k],f),c,d)}e||void 0===c.g||(b.g?-1!==b.isFriendlyObstructionFor.indexOf(d)?c.l.push(b):c.o.push(b):(e=C(b),d=C(c.h),A(c.h),!D(c.h)&&b.clipsToBounds&&(b=Ea(d,e),Fa(b,d)&&(I(c,'clipped'),c.h=new z(b,!1)))))}\n;function Ma(){this.h=new Map;this.g=null}function Na(){Oa||(Oa=new Ma);return Oa}var Oa=null;function Pa(a,b){this.y=this.x=0;this.width=a;this.height=b};function Qa(){this.adSessionId=null;this.m={apiVersion:'1.0',accessMode:'limited',environment:'app',omidJsInfo:{omidImplementer:'omsdk',serviceVersion:'1.5.5-iab77'}};this.C=null;this.A='foregrounded';this.M='unlocked';this.u=this.o='none';this.s=this.j=this.i=this.l=this.h=this.g=this.J=this.D=null;this.I=!0;this.v=new Map}\nfunction Ra(a,b){void 0!==b.contentUrl&&(a.C=b.contentUrl,b.contentUrl=void 0);var c=a.m||{};b.omidJsInfo=Object.assign({},c.omidJsInfo||{},b.omidJsInfo||{});b=Object.assign({},c,b);a.I||(null!=a.j?(b.videoElement=a.j,b.accessMode='full'):null!=a.i&&(b.slotElement=a.i,b.accessMode='full'));a.m=b};var J=function(){if('undefined'!==typeof omidGlobal&&omidGlobal)return omidGlobal;if('undefined'!==typeof global&&global)return global;if('undefined'!==typeof window&&window)return window;if('undefined'!==typeof globalThis&&globalThis)return globalThis;var a=Function('return this')();if(a)return a;throw Error('Could not determine global object context.');}();function Sa(a,b){this.g=a;this.h=b}ea.Object.defineProperties(Sa.prototype,{event:{configurable:!0,enumerable:!0,get:function(){return this.g}},origin:{configurable:!0,enumerable:!0,get:function(){return this.h}}});function K(){var a=w.apply(0,arguments);Ta(function(){throw new (Function.prototype.bind.apply(Error,[null,'Could not complete the test successfully - '].concat(q(a))));},function(){return console.error.apply(console,q(a))})}function Ua(){var a=w.apply(0,arguments);Ta(function(){},function(){return console.error.apply(console,q(a))})}function Ta(a,b){'undefined'!==typeof jasmine&&jasmine?a():'undefined'!==typeof console&&console&&console.error&&b()};function Va(a){this.g=a;this.m=[];this.i=[];this.j=[];this.l=[];this.o={}}function Wa(a,b){if(void 0!==a.g&&a.g.adSessionId&&!1!==Xa(a,b)){var c=b.event;a.j.filter(function(d){return d.type===c.type}).forEach(function(d){a.h(d.G,c)})}}function Ya(a,b){a.m.push(b);Wa(a,b)}function Za(a,b,c){void 0!==a.g&&a.g.adSessionId&&a.m.filter(function(d){return d.event.type===b&&Xa(a,d)}).map(function(d){return d.event}).forEach(function(d){a.h(c.G,d)})}\nfunction Xa(a,b){var c=b.event.type,d=-1!==Object.values(y).indexOf(c)&&'volumeChange'!==c;return'impression'===c||'loaded'===c&&a.g.h?b.origin===a.g.u:d?b.origin===a.g.o:!0}function $a(a,b,c){Object.keys(y).forEach(function(d){d=y[d];var e={type:d,R:c,G:b};a.j.push(e);Za(a,d,e)})}function ab(a,b,c,d){var e={U:c,R:d,G:b};a.l.push(e);a.i.forEach(function(f){var h=bb(f);'sessionStart'===f.event.type&&cb(a,h,e);a.h(e.G,h)})}\nfunction db(a,b,c){var d=L(a,'sessionError','native',{errorType:b,message:c});a.i.push(d);a.l.forEach(function(e){a.h(e.G,d.event)})}function eb(a,b){a.o=Object.assign(a.o,b);b=a.g.m;if(void 0!==b){b=Object.assign({},fb(gb(a,hb(a,{context:b}),!0)),{supportsLoadedEvent:!!a.g.h||'video'==a.g.g});Object.assign(b,{pageUrl:null,contentUrl:a.g.C});var c=L(a,'sessionStart','native',b);a.i.push(c);a.l.forEach(function(d){var e=bb(c);cb(a,e,d);a.h(d.G,e)},a);ib(a)}}\nfunction cb(a,b,c){c.U&&(b.data.verificationParameters=a.o[c.U]);c.R&&(c=a.g.v.get(c.R))&&(b.data.verificationParameters=c.verificationParameters,b.data.context.accessMode=c.accessMode,'full'===c.accessMode&&(a.g.j&&(b.data.context.videoElement=a.g.j),a.g.i&&(b.data.context.slotElement=a.g.i)))}function jb(a){var b=L(a,'sessionFinish','native');a.i.push(b);a.l.forEach(function(c){a.h(c.G,b.event)})}Va.prototype.h=function(a){var b=w.apply(1,arguments);try{a.apply(null,q(b))}catch(c){Ua(c)}};\nfunction kb(a,b){var c=(c=a.g.K)?Aa(c):null;c=gb(a,hb(a,c));Ya(a,L(a,'impression',b,c))}function lb(a,b,c){if(a.g.h||'display'!=a.g.g)b=L(a,'loaded',b,gb(a,hb(a,void 0===c?null:c))),Ya(a,b)}\nfunction mb(a,b,c,d){'start'!==b&&'volumeChange'!==b||null!=(d&&d.deviceVolume)||(d.deviceVolume=a.g.D);if(d&&('start'===b||'volumeChange'===b)){var e=d.videoPlayerVolume,f=d.mediaPlayerVolume;null!=e?(Object.assign(d,{mediaPlayerVolume:e}),a.g.J=e):null!=f&&(Object.assign(d,{videoPlayerVolume:f}),a.g.J=f)}Ya(a,L(a,b,c,d))}\nfunction ib(a){var b=a.m.filter(function(f){return Object.values(y).includes(f.event.type)&&'video'==a.g.g&&f.origin===a.g.o||'loaded'==f.event.type&&'display'==a.g.g&&f.origin===a.g.u?!0:!1}).map(function(f){return f.event}),c=a.g.adSessionId||'',d={};b=p(b);for(var e=b.next();!e.done;d={F:d.F},e=b.next()){d.F=e.value;d.F.adSessionId||(d.F.adSessionId=c);if('loaded'==d.F.type){if(!a.g.h&&'display'==a.g.g)continue;d.F.data=gb(a,hb(a,d.F.data))}a.j.filter(function(f){return function(h){return h.type===\nf.F.type}}(d)).forEach(function(f){return function(h){return h.G(f.F)}}(d))}}function nb(a,b,c){a:{c=new Set(c);a=p(a.m.concat(a.i));for(var d=a.next();!d.done;d=a.next())if(d=d.value,c.has(d.event.type)&&d.origin!=b){b=!0;break a}b=!1}return b?(K('Event owner cannot be registered after its events have already been published.'),!1):!0}function ob(a,b){nb(a,b,Object.values(y))&&pb(a,b)&&(a.g.o=b)}function qb(a,b){nb(a,b,['impression'])&&rb(a,b)&&(a.g.u=b)}\nfunction rb(a,b){var c=a.g.u;return'none'!=c&&c!=b?(K('Impression event is owned by '+(a.g.u+', not ')+(b+'.')),!1):!0}function pb(a,b){var c=a.g.o;return'none'!=c&&c!=b?(K('Media events are owned by '+(a.g.o+', not '+b+'.')),!1):!0}function gb(a,b,c){c=void 0===c?!1:c;b=Object.assign({},b);a.g.g&&Object.assign(b,{mediaType:a.g.g});a.g.h&&(c||'definedByJavaScript'!==a.g.h)&&Object.assign(b,{creativeType:a.g.h});return b}function fb(a){var b=Na().g;return b?Object.assign({},a,{lastActivity:b}):a}\nfunction hb(a,b){return a.g.l?Object.assign({},b,{impressionType:a.g.l}):b}function L(a,b,c,d){return new Sa({adSessionId:a.g.adSessionId||'',timestamp:(new Date).getTime(),type:b,data:d},c)}function bb(a){a=a.event;var b=a.data?Object.assign({},a.data):void 0;'sessionStart'===a.type&&(b.context=Object.assign({},b.context));return{adSessionId:a.adSessionId,timestamp:a.timestamp,type:a.type,data:b}};function sb(a,b,c){this.h=a;this.i=b;this.g=c}\nfunction M(a,b,c){'container'===b&&void 0!==a.g.L&&void 0!==a.g&&null!=a.g.adSessionId&&(a.g.O=Ka(a.i,a.g.L,a.g.A,a.g.adSessionId,!0,a.g.M));b=a.g;var d=b.O,e=b.P;if(d)if(e){b=new H;var f=d.s,h=d.g,k=d.h,g=e.g,l=e.h;f&&h&&k&&g&&l&&(Ca(b,f),b.u=new z(h,!1),b.D=new z(k,!1),b.o=Object.assign([],d.o),b.j=Object.assign([],d.j),b.l=Object.assign([],d.l),b.v=Object.assign([],d.v),b.i=Object.assign([],e.i,d.i),d=b.u.x,e=b.u.y,g=new z(g,!1),l=new z(l,!1),wa(g,d,e),wa(l,d,e),b.g=g,b.h=Ea(l,k),Ga(b))}else b=\nd;else b=null;k=a.g.K;if(b&&!b.N(k)||c)k=Aa(b),c&&(k.adView.reasons=k.adView.reasons||[c]),c=a.h,'audio'!=c.g.h&&Ya(c,L(c,'geometryChange','native',k)),a.g.K=b};function tb(){var a;this.g=a=void 0===a?omidGlobal:a}tb.prototype.setInterval=function(a,b){return ub(this,'setInterval')(a,b)};tb.prototype.clearInterval=function(a){ub(this,'clearInterval')(a)};function vb(a,b){ub(a,'clearTimeout')(b)}function ub(a,b){return a.g&&a.g[b]?a.g[b]:wb(a,b)}\nfunction xb(a,b,c,d){if(a.g.document&&a.g.document.body){var e=a.g.document.createElement('img');e.width=1;e.height=1;e.style.display='none';e.src=b;c&&e.addEventListener('load',function(){return c()});d&&e.addEventListener('error',function(){return d()});a.g.document.body.appendChild(e)}else wb(a,'sendUrl')(b,c,d)}function wb(a,b){if(a.g&&a.g.omidNative&&a.g.omidNative[b])return a.g.omidNative[b].bind(a.g.omidNative);throw Error('Native interface method \"'+b+'\" not found.');};function N(a){return'object'===typeof a}function O(a){return'number'===typeof a&&!isNaN(a)&&0<=a}function P(a){return'string'===typeof a}function Q(a,b){return P(a)&&-1!==Object.values(b).indexOf(a)}function yb(a){return!(!a||!a.tagName||'iframe'!==a.tagName.toLowerCase())};function S(a,b,c,d,e){this.j=a;this.ba=b;this.L=c;this.i=d;this.P=e;this.h=null;this.g=this.m=this.D=void 0;this.O=!0;this.J=void 0;zb(this)}\nfunction zb(a){if(!a.h){var b;a:{if((b=a.j.document)&&b.getElementsByClassName&&(b=b.getElementsByClassName('omid-element'))){if(1==b.length){b=b[0];break a}1<b.length&&a.O&&(db(a.L,'generic',\"More than one element with 'omid-element' class name.\"),a.O=!1)}b=null}if(b&&b.tagName&&'video'===b.tagName.toLowerCase())a.i.j=b;else if(b&&b.tagName)a.i.i=b;else return;Ab(a)}}function Ab(a){a.i.j?(a.h=a.i.j,a.o()):a.i.i&&(a.h=a.i.i,yb(a.h)?a.i.s&&a.o():a.o())}\nfunction Bb(a){a.g&&(yb(a.h)?a.i.s&&(a.K(),Cb(a)):(a.K(),Cb(a)))}S.prototype.A=function(){this.J&&(this.j.document.removeEventListener('visibilitychange',this.J),this.J=void 0)};S.prototype.o=function(){};function Cb(a){a.D&&(a.i.P=a.D,M(a.ba,'creative'))}function Db(a){if(a.g&&a.i.s){var b=new z(a.i.s,!1);wa(b,a.g.x,a.g.y);b.clipsToBounds=!0;return b}};function T(a,b,c,d,e,f){S.call(this,a,c,d,e,f);this.s=b;this.l=void 0}v(T,S);T.prototype.A=function(){void 0!==this.l&&(this.P.clearInterval(this.l),this.l=void 0);S.prototype.A.call(this)};T.prototype.o=function(){var a=this;S.prototype.o.call(this);null==this.h?this.l=void 0:void 0===this.l&&(this.l=this.P.setInterval(function(){return Eb(a)},200),Eb(this))};\nT.prototype.K=function(){if(this.m){var a=Db(this);if(a){this.g.isCreative=!1;a.isCreative=!0;for(var b=!1,c=0;c<this.g.childViews.length;c++)if(this.g.childViews[c].isCreative){this.g.childViews[c]=a;b=!0;break}b||this.g.childViews.push(a)}else this.g.isCreative=!0;this.D=Ka(this.s,this.m,this.i.A,this.i.adSessionId,this.I())}};T.prototype.I=function(){return!0};\nfunction Eb(a){if(void 0!==a.l){b:{try{var b=a.j.top;var c=0<=b.innerHeight&&0<=b.innerWidth;break b}catch(d){}c=!1}c?(c=a.j.top,c=new z(new Pa(c.innerWidth,c.innerHeight),!1)):c=new z(new Pa(0,0),!1);b=a.h.getBoundingClientRect();if(null==b.x||isNaN(b.x))b.x=b.left;if(null==b.y||isNaN(b.y))b.y=b.top;b=new z(b,!1);c.N(a.m)&&b.N(a.g)||(a.g=b,a.g.clipsToBounds=!0,a.m=c,a.m.childViews.push(a.g),Bb(a))}};function U(a,b,c,d,e,f){S.call(this,a,c,d,e,f);this.v=this.s=this.u=this.l=void 0;this.M=!1;this.C=void 0}v(U,S);U.prototype.A=function(){this.l&&this.l.disconnect();Fb(this);S.prototype.A.call(this)};U.prototype.o=function(){S.prototype.o.call(this);if(this.h&&(this.l||(this.l=Gb(this)),Hb(this),Ib(this.h)&&Jb(this),'backgrounded'===this.i.A)){var a=Kb(new Pa(0,0));this.C=this.g=this.m=a;Bb(this)}};\nU.prototype.K=function(){if(this.g&&this.C){var a=Db(this);if(a){var b=a;var c=this.C;var d=Math.max(a.x,c.x);var e=Math.max(a.y,c.y),f=Math.min(a.endX,c.endX);a=Math.min(a.endY,c.endY);f<=d||a<=e?d=null:(c={},d=new z((c.x=d,c.y=e,c.width=Math.abs(f-d),c.height=Math.abs(a-e),c),!1));d||(d=new z({x:0,y:0,width:0,height:0},!1))}else b=this.g,d=this.C;e=new H;this.m&&Ca(e,this.m);e.g=b;e.h=d;Ga(e);this.M?D(e.g)?I(e,'hidden'):100===e.A||I(e,'clipped'):I(e,'viewport');this.D=e}};U.prototype.I=function(){return!0};\nfunction Fb(a){a.u&&(a.u.disconnect(),a.u=void 0);a.s&&(a.s.disconnect(),a.s=void 0);a.v&&((0,a.j.removeEventListener)('resize',a.v),a.v=void 0)}function Hb(a){a.l&&a.h&&(a.l.unobserve(a.h),a.l.observe(a.h))}function Ib(a){a=a.getBoundingClientRect();return 0==a.width||0==a.height}\nfunction Gb(a){return new a.j.IntersectionObserver(function(b){try{if(b.length){for(var c,d=b[0],e=1;e<b.length;e++)b[e].time>d.time&&(d=b[e]);c=d;a.m=Kb(c.rootBounds);a.g=Kb(c.boundingClientRect);a.C=Kb(c.intersectionRect);a.M=!!c.isIntersecting;Bb(a)}}catch(f){a.A(),db(a.L,'generic','Problem handling IntersectionObserver callback: '+f.message)}},{root:null,rootMargin:'0px',threshold:[0,.1,.2,.3,.4,.5,.6,.7,.8,.9,1]})}\nfunction Jb(a){a.j.ResizeObserver?a.u||(a.u=Lb(a,function(){return Mb(a)}),a.u.observe(a.h)):(a.v||(a.v=function(){return Mb(a)},(0,a.j.addEventListener)('resize',a.v)),a.s||(a.s=new MutationObserver(function(){return Mb(a)}),a.s.observe(a.h,{childList:!1,attributes:!0,subtree:!1})))}function Mb(a){a.h&&!Ib(a.h)&&(Hb(a),Fb(a))}function Lb(a,b){return new a.j.ResizeObserver(b)}function Kb(a){if(a&&null!==a.x&&null!==a.y&&null!==a.width&&null!==a.height)return new z(a,!1)};function Nb(a){if('object'===typeof a&&'object'===typeof a.webOSSystem)return a.webOSSystem}function Ob(a){if('object'===typeof a&&'object'===typeof a.tizen)return a.tizen}function Pb(a){return'object'===typeof Ob(a)};function Qb(a,b){this.h=a;this.g=b};function Sb(){return'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g,function(a){var b=16*Math.random()|0;return'y'===a?(b&3|8).toString(16):b.toString(16)})};function Tb(a,b){var c=void 0===c?J:c;this.j=a;this.g=c;this.i=b;this.h=[]}\nfunction Ub(a){if(!a.g||!a.g.document)throw Error('OMID Service Script is not running within a window.');var b=a.h;a.h=[];b.forEach(function(c){try{var d=a.i.I?'limited':'full',e=Q(c.accessMode,ra)?c.accessMode:null;var f=e?'full'==e&&'limited'==d?d:'domain'==e?'limited':e:d;c.accessMode=f;a:{var h=c.resourceUrl,k=a.g.location.origin;try{var g=new URL(h,k);break a}catch(F){}try{g=new URL(h);break a}catch(F){}g=null}if(d=g){var l=Sb();Vb(a,l,d,f);var m=c.vendorKey,r=c.verificationParameters;m=void 0===\nm?'':m;r=void 0===r?'':r;m&&'string'===typeof m&&''!==m&&r&&'string'===typeof r&&''!==r&&(a.j.o[m]=r);a.i.v.set(l,c)}}catch(F){Ua('OMID verification script '+c.resourceUrl+' failed to load: '+F)}})}\nfunction Vb(a,b,c,d){var e=a.g.document,f=e.createElement('iframe');f.id='omid-verification-script-frame-'+b;f.style.display='none';if('full'==d){var h=function(){var k=f.contentWindow;k.omidVerificationProperties={serviceWindow:a.g,injectionSource:'app',injectionId:b};k=k.document;var g=k.createElement('script');g.src=c.href;k.head.appendChild(g);f.removeEventListener('load',h)};f.addEventListener('load',h)}else'limited'==d&&(f.srcdoc=\"<html><head>\\n<script type=\\\"text/javascript\\\">window['omidVerificationProperties'] = {\\n'serviceWindow': window.parent,\\n'injectionSource': 'app',\\n'injectionId': '\"+\n(b+'\\',\\n};\\x3c/script>\\n<script type=\"text/javascript\" src=\"')+c.href+'\">\\x3c/script>\\n</head><body></body></html>',f.sandbox='allow-scripts');e.body.appendChild(f);Na().h.set(b,f)};function Wb(a,b,c,d,e,f){var h=this;this.g=a;this.h=b;this.j=c;this.i=d;this.l=e;this.s=f;this.m=!1;Xb(this,function(k){if('sessionStart'===k.type){h.m=!0;try{Ub(h.l)}catch(g){K(g.message)}}'sessionFinish'===k.type&&(h.m=!1)})}function Xb(a,b,c,d){ab(a.h,b,c,d)}n=Wb.prototype;n.setSlotElement=function(a){a&&a.tagName?(this.g.i=a,this.i&&Ab(this.i)):K('setSlotElement called with a non-HTMLElement.  It will be ignored.')};n.setElementBounds=function(a){this.g.s=a;this.i&&Ab(this.i);this.i&&Bb(this.i)};\nn.error=function(a,b){db(this.h,a,b)};n.injectVerificationScriptResources=function(a){var b=this.l;b.h.push.apply(b.h,q(a));if(this.m)try{Ub(this.l)}catch(c){K(c.message)}};n.setCreativeType=function(a,b){b=void 0===b?null:b;if(!this.g.g||this.g.h)this.g.h=a,'video'==a||'audio'==a?this.g.g='video':'htmlDisplay'==a||'nativeDisplay'==a?this.g.g='display':'definedByJavaScript'==a&&b&&(this.g.g='none'==b?'display':'video')};n.setImpressionType=function(a){if(!this.g.g||this.g.h)this.g.l=a};\nn.setClientInfo=function(a,b,c){var d=this.g.m||{};d.omidJsInfo=Object.assign({},d.omidJsInfo,{sessionClientVersion:a,partnerName:b,partnerVersion:c});this.g.m=d;return this.g.m.omidJsInfo.serviceVersion};function Yb(a,b){if(!b)return a.g;for(var c=p(a.h.values()),d=c.next();!d.done;d=c.next())if(d=d.value,d.g.v.has(b))return d;return a.g}function V(a,b){return null==b?a.g:a.h.get(b)||a.g}function Zb(a){var b=new Qa,c=new Va(b),d=new Ia,e=new Ja,f=new sb(c,e,b);a=a.i;var h=omidGlobal;d=h?h.IntersectionObserver&&(h.MutationObserver||h.ResizeObserver)?new U(h,d,f,c,b,a):new T(h,e,f,c,b,a):null;return new Wb(b,c,f,d,new Tb(c,b),new Qb(c,b))};function $b(a){return a&&N(a)?Object.entries(a).reduce(function(b,c){var d=p(c);c=d.next().value;d=d.next().value;return b&&P(c)&&null!=d&&N(d)&&P(d.resourceUrl)},!0):!1};function W(a,b,c,d){this.h=a;this.method=b;this.version=c;this.g=d}function ac(a){return!!a&&void 0!==a.omid_message_guid&&void 0!==a.omid_message_method&&void 0!==a.omid_message_version&&'string'===typeof a.omid_message_guid&&'string'===typeof a.omid_message_method&&'string'===typeof a.omid_message_version&&(void 0===a.omid_message_args||void 0!==a.omid_message_args)}function bc(a){return new W(a.omid_message_guid,a.omid_message_method,a.omid_message_version,a.omid_message_args)}\nfunction cc(a){var b={};b=(b.omid_message_guid=a.h,b.omid_message_method=a.method,b.omid_message_version=a.version,b);void 0!==a.g&&(b.omid_message_args=a.g);return b};function dc(a){this.i=a};function X(a){this.i=a;this.handleExportedMessage=X.prototype.j.bind(this)}v(X,dc);X.prototype.h=function(a,b){b=void 0===b?this.i:b;if(!b)throw Error('Message destination must be defined at construction time or when sending the message.');b.handleExportedMessage(cc(a),this)};X.prototype.j=function(a,b){ac(a)&&this.g&&this.g(bc(a),b)};function ec(a){return fc(a,'SessionService.')}function fc(a,b){return(a=a.match(new RegExp('^'+b+'(.*)')))&&a[1]};function gc(a,b){this.i=b=void 0===b?J:b;var c=this;a.addEventListener('message',function(d){if('object'===typeof d.data){var e=d.data;ac(e)&&d.source&&c.g&&c.g(bc(e),d.source)}})}v(gc,dc);gc.prototype.h=function(a,b){b=void 0===b?this.i:b;if(!b)throw Error('Message destination must be defined at construction time or when sending the message.');b.postMessage(cc(a),'*')};function hc(a,b){b=void 0===b?{}:b;var c=J.webkit?J.webkit.messageHandlers.omidJsSessionService:J.omidJsSessionService;if(!c)return!1;c.postMessage(JSON.stringify({method:a,data:b}));return!0};function ic(){this.g=jc}n=ic.prototype;n.registerSessionObserver=function(a,b){Xb(V(this.g,a),b)};n.setSlotElement=function(a,b){V(this.g,a).setSlotElement(b)};n.setElementBounds=function(a,b){V(this.g,a).setElementBounds(b)};\nfunction kc(a,b,c,d,e){e=void 0===e?null:e;a=V(a.g,b);var f=a.g.m;f.sessionOwner||(f.sessionOwner=d?'native':'javascript');d?(b=b||Sb(),a.g.adSessionId=b,c.canMeasureVisibility=a.i.I(),Ra(a.g,c),eb(a.h,e),a.i&&zb(a.i)):b?(Ra(a.g,c),hc('startSession',{adSessionId:b})||K('On App, the native-layer JS Session Service must be initialized before starting an ad session using the JS API.')):K('Session client must be updated to start an App session from JS.')}\nfunction lc(a,b,c){c?(b=V(a.g,b),a=a.g,a.g=Zb(a),jb(b.h),b.i.A(),b.o&&(b.o.stop(),b.o=null)):b?hc('finishSession',{adSessionId:b})||K('On App, the native-layer JS Session Service must be initialized before finishing an ad session using the JS API.'):K('Session client must be updated to finish an App session from JS.')}n.error=function(a,b,c){V(this.g,a).error(b,c)};\nfunction Y(a,b,c,d){a=V(a.g,b);'impression'==c?rb(a.h,'javascript')&&(kb(a.h,'javascript'),a.i&&zb(a.i)):('loaded'==c?(d=void 0===d?null:d,pb(a.h,'javascript')&&lb(a.h,'javascript',d)):pb(a.h,'javascript')&&mb(a.h,c,'javascript',d),['loaded','start'].includes(c)&&a.i&&zb(a.i))}n.injectVerificationScriptResources=function(a,b){V(this.g,a).injectVerificationScriptResources(b)};n.setCreativeType=function(a,b,c){c=void 0===c?null:c;V(this.g,a).setCreativeType(b,c)};\nn.setImpressionType=function(a,b){V(this.g,a).setImpressionType(b)};n.setClientInfo=function(a,b,c,d){var e=this.g;if(null==a)a=e.g;else{var f=[].concat(q(e.h.values())).includes(e.g)?Zb(e):e.g;e.h.set(a,f);a=f}return a.setClientInfo(b,c,d)};function mc(a){a=a.split('-')[0].split('.');for(var b=['1','0','3'],c=0;3>c;c++){var d=parseInt(a[c],10),e=parseInt(b[c],10);if(d>e)break;else if(d<e)return!1}return!0};function nc(a,b){return/\\d+\\.\\d+\\.\\d+(-.*)?/.test(a)&&mc(a)?b:JSON.stringify(b)}function oc(a,b){return/\\d+\\.\\d+\\.\\d+(-.*)?/.test(a)&&mc(a)?b?b:[]:b&&'string'===typeof b?JSON.parse(b):[]};function pc(){var a=qc;var b=void 0===b?omidGlobal:b;this.g=a;this.h=b;this.j=new X;this.h.omid=this.h.omid||{};this.h.omid.v1_SessionServiceCommunication=this.j;this.i=b&&b.addEventListener&&b.postMessage?new gc(b):null;this.j.g=this.m.bind(this);this.i&&(this.i.g=this.l.bind(this))}pc.prototype.m=function(a,b){null!=ec(a.method)&&rc(this,a,b,this.j)};pc.prototype.l=function(a,b){null!=ec(a.method)&&rc(this,a,b,this.i)};\nfunction rc(a,b,c,d){function e(){var g=new W(f,'response',k,nc(k,w.apply(0,arguments)));d.h(g,c)}var f=b.h,h=b.method,k=b.version;b=oc(k,b.g);try{sc(a,h,e,b)}catch(g){d.h(new W(f,'error',k,'\\n        name: '+g.name+'\\n        message: '+g.message+'\\n        filename: '+g.filename+'\\n        lineNumber: '+g.lineNumber+'\\n        columnNumber: '+g.columnNumber+'\\n        stack: '+g.stack+'\\n        toString(): '+g.toString()),c)}}\nfunction sc(a,b,c,d){if(null!=ec(b))switch(ec(b)){case 'registerAdEvents':c=p(d).next().value;qb(V(a.g.g,c).h,'javascript');break;case 'registerMediaEvents':c=p(d).next().value;ob(V(a.g.g,c).h,'javascript');break;case 'registerSessionObserver':var e=p(d).next().value;a.g.registerSessionObserver(e,c);break;case 'setSlotElement':e=p(d);c=e.next().value;e=e.next().value;a.g.setSlotElement(e,c);break;case 'setVideoElement':e=p(d);c=e.next().value;e=e.next().value;a=V(a.g.g,e);c&&c.tagName&&'video'===\nc.tagName.toLowerCase()?(a.g.j=c,a.i&&Ab(a.i)):K('setVideoElement called with a non-HTMLVideoElement. It will be ignored.');break;case 'setElementBounds':e=p(d);c=e.next().value;e=e.next().value;a.g.setElementBounds(e,c);break;case 'startSession':c=p(d);d=c.next().value;c=c.next().value;b=a.h;if(null!=d&&N(d)){var f=d.customReferenceData,h=d.underEvaluation,k=d.universalAdId;P(f)||(f=void 0);'boolean'===typeof h||(h=!1);d={customReferenceData:f,underEvaluation:h};P(k)&&(d.universalAdId=k);if('object'===\ntypeof Nb(b)){var g=Nb(b),l;'object'===typeof g&&(l=g.identifier);d.app={appId:l&&'string'===typeof l?l:void 0};b:if(g=Nb(b),'object'===typeof g){try{e=JSON.parse(g.deviceInfo)}catch(F){e=void 0;break b}e={deviceType:e.modelName||'Unknown',osVersion:e.platformVersion||'Unknown',os:'webOS'}}else e=void 0;d.deviceInfo=e;d.deviceCategory='ctv'}else if(Pb(b)){b:{if(Pb(b)){try{var m=Ob(b).application.getCurrentApplication().appInfo.id}catch(F){e=void 0;break b}if('string'===typeof m){e=m;break b}}e=void 0}d.app=\n{appId:e};if(Pb(b)){e=Ob(b).systeminfo;if('object'===typeof e&&'function'===typeof e.getCapability){g=e.getCapability('http://tizen.org/system/model_name');var r=e.getCapability('http://tizen.org/feature/platform.version')}e={deviceType:g||'Unknown',osVersion:r||'Unknown',os:'tizen'}}else e=void 0;d.deviceInfo=e;Pb(b)&&'object'===typeof Ob(b).tvinputdevice&&(d.deviceCategory='ctv')}}else d=null;if(null==d)break;kc(a.g,c,d,!1);break;case 'finishSession':c=p(d).next().value;lc(a.g,c,!1);break;case 'impressionOccurred':c=\np(d).next().value;Y(a.g,c,'impression');break;case 'loaded':e=p(d);c=e.next().value;e=e.next().value;c?(g={skippable:c.isSkippable,autoPlay:c.isAutoPlay,position:c.position},c.isSkippable&&(g.skipOffset=c.skipOffset),Y(a.g,e,'loaded',g)):Y(a.g,e,'loaded');break;case 'start':g=p(d);c=g.next().value;e=g.next().value;g=g.next().value;Y(a.g,g,'start',{duration:c,mediaPlayerVolume:e});break;case 'firstQuartile':c=p(d).next().value;Y(a.g,c,'firstQuartile');break;case 'midpoint':c=p(d).next().value;Y(a.g,\nc,'midpoint');break;case 'thirdQuartile':c=p(d).next().value;Y(a.g,c,'thirdQuartile');break;case 'complete':c=p(d).next().value;Y(a.g,c,'complete');break;case 'pause':c=p(d).next().value;Y(a.g,c,'pause');break;case 'resume':c=p(d).next().value;Y(a.g,c,'resume');break;case 'bufferStart':c=p(d).next().value;Y(a.g,c,'bufferStart');break;case 'bufferFinish':c=p(d).next().value;Y(a.g,c,'bufferFinish');break;case 'skipped':c=p(d).next().value;Y(a.g,c,'skipped');break;case 'volumeChange':e=p(d);c=e.next().value;\ne=e.next().value;Y(a.g,e,'volumeChange',{mediaPlayerVolume:c});break;case 'playerStateChange':e=p(d);c=e.next().value;e=e.next().value;Y(a.g,e,'playerStateChange',{state:c});break;case 'adUserInteraction':e=p(d);c=e.next().value;e=e.next().value;Y(a.g,e,'adUserInteraction',{interactionType:c});break;case 'setClientInfo':l=p(d);e=l.next().value;g=l.next().value;r=l.next().value;l=l.next().value;a=a.g.setClientInfo(l,e,g,r);c(a);break;case 'injectVerificationScriptResources':e=p(d);c=e.next().value;\ne=e.next().value;a.g.injectVerificationScriptResources(e,c);break;case 'setCreativeType':e=p(d);c=e.next().value;e=e.next().value;a.g.setCreativeType(e,c);break;case 'setImpressionType':e=p(d);c=e.next().value;e=e.next().value;a.g.setImpressionType(e,c);break;case 'setContentUrl':e=p(d);c=e.next().value;e=e.next().value;V(a.g.g,e).g.C=c;break;case 'sessionError':g=p(d),c=g.next().value,e=g.next().value,g=g.next().value,a.g.error(g,c,e)}};function Z(){this.g=qc}n=Z.prototype;\nn.da=function(a,b){if(!(!(a&&N(a)&&Q(a.impressionOwner,qa))||'videoEventsOwner'in a&&null!=a.videoEventsOwner&&!Q(a.videoEventsOwner,qa)||'mediaEventsOwner'in a&&null!=a.mediaEventsOwner&&!Q(a.mediaEventsOwner,qa))){b=V(this.g.g,b);if(a.creativeType&&a.impressionType){var c=a.mediaEventsOwner;null==b.g.h&&b.setCreativeType(a.creativeType,c);null==b.g.l&&(b.g.l=a.impressionType);ob(b.h,c)}else c=a.videoEventsOwner,b.g.g=null==c||'none'===c?'display':'video',b.g.h=null,b.g.l=null,ob(b.h,c);qb(b.h,a.impressionOwner);\na&&null!=a.isolateVerificationScripts&&'boolean'===typeof a.isolateVerificationScripts&&(b.g.I=a.isolateVerificationScripts)}};\nn.aa=function(a,b,c,d){b&&'string'===typeof b.adSessionType&&(b.adSessionType=b.adSessionType.toLowerCase());var e;if(N(b)){if(e=Q(b.environment,ua)&&Q(b.adSessionType,pa))e=b.omidNativeInfo,e=N(e)?P(e.partnerName)&&P(e.partnerVersion):!1;e&&(e=b.app,e=N(e)?P(e.libraryVersion)&&P(e.appId):!1)}else e=!1;if(e){if($b(d)){e=p(Object.values(d));for(var f=e.next();!f.done;f=e.next())f.value.accessMode='limited';V(this.g.g,a).g.v=new Map(Object.entries(d))}kc(this.g,a,b,!0,c)}else K('Native ad session context invalid; session not started.')};\nn.W=function(a){lc(this.g,a,!0)};n.$=function(a,b){N(a)&&O(a.x)&&O(a.y)&&O(a.width)&&O(a.height)&&(b=V(this.g.g,b),b.g.L=a,M(b.j,'container'))};n.ha=function(a,b){Q(a,sa)&&(b=V(this.g.g,b),b.g.A=a,'backgrounded'===a?M(b.j,'container','backgrounded'):M(b.j,'container'))};n.Y=function(a,b){Q(a,ta)&&(b=V(this.g.g,b),b.g.M=a,'locked'===a?M(b.j,'container','deviceLocked'):M(b.j,'container'))};n.ea=function(a){'impression'===a&&this.T()};n.T=function(a){a=V(this.g.g,a);rb(a.h,'native')&&kb(a.h,'native')};\nn.X=function(a,b){this.S('loaded',void 0===a?null:a,b)};n.error=function(a,b,c){Q(a,oa)&&this.g.error(c,a,b)};n.fa=function(a,b,c){this.S(a,b,c)};n.S=function(a,b,c){Q(a,y)&&(void 0===b||N(b))&&(c=V(this.g.g,c),pb(c.h,'native')&&('loaded'==a?lb(c.h,'native',b):mb(c.h,a,'native',b)))};n.Z=function(a,b){b=V(this.g.g,b);'none'===b.h.g.o||'number'!==typeof a||isNaN(a)||(b.g.D=a,a=b.s,b=a.g.J,null!=b&&mb(a.h,'volumeChange','native',{mediaPlayerVolume:b,deviceVolume:a.g.D}))};\nn.ga=function(a){if(a&&N(a)&&O(a.timestamp)){var b=Na(),c=(b.g||{}).timestamp;if(!c||c<a.timestamp)b.g=a}};Z.prototype.startSession=Z.prototype.aa;Z.prototype.error=Z.prototype.error;Z.prototype.finishSession=Z.prototype.W;Z.prototype.publishAdEvent=Z.prototype.ea;Z.prototype.publishImpressionEvent=Z.prototype.T;Z.prototype.publishVideoEvent=Z.prototype.fa;Z.prototype.publishMediaEvent=Z.prototype.S;Z.prototype.publishLoadedEvent=Z.prototype.X;Z.prototype.setNativeViewHierarchy=Z.prototype.$;\nZ.prototype.setState=Z.prototype.ha;Z.prototype.setDeviceLockState=Z.prototype.Y;Z.prototype.setDeviceVolume=Z.prototype.Z;Z.prototype.init=Z.prototype.da;Z.prototype.setLastActivity=Z.prototype.ga;function tc(){var a=jc,b=uc,c=this;var d=void 0===d?J:d;this.j=a;this.g=b;this.l={};this.m={};this.i=new X;d.omid=d.omid||{};d.omid.v1_VerificationServiceCommunication=this.i;this.h=null;d&&d.addEventListener&&d.postMessage&&(this.h=new gc(d));this.i.g=function(e,f){vc(c,e,f,c.i)};this.h&&(this.h.g=function(e,f){c.h&&vc(c,e,f,c.h)})}function wc(a,b,c,d){a=Yb(a.j,d).h;'media'===b||'video'===b?$a(a,c,d):(c={type:b,R:d,G:c},a.j.push(c),Za(a,b,c))}function xc(a,b,c,d){a=Yb(a.j,d);Xb(a,b,c,d)}\nfunction yc(a,b,c,d){xb(a.g,b,c,d)}tc.prototype.setInterval=function(a,b){return this.g.setInterval(a,b)};tc.prototype.clearInterval=function(a){this.g.clearInterval(a)};function zc(a,b,c,d){wb(a.g,'downloadJavaScriptResource')(b,c,d)}\nfunction vc(a,b,c,d){function e(){var B=new W(f,'response',k,nc(k,w.apply(0,arguments)));d.h(B,c)}var f=b.h,h=b.method,k=b.version;b=oc(k,b.g);if(null!=fc(h,'VerificationService.')){h=fc(h,'VerificationService.');try{switch(h){case 'addEventListener':var g=p(b),l=g.next().value,m=g.next().value||Ac(c);wc(a,l,e,m);break;case 'addSessionListener':var r=p(b),F=r.next().value,ba=r.next().value||Ac(c);xc(a,e,F,ba);break;case 'sendUrl':var R=p(b).next().value;yc(a,R,function(){return e(!0)},function(){return e(!1)});\nbreak;case 'setTimeout':var G=p(b),Ec=G.next().value,Fc=G.next().value;a.l[Ec]=ub(a.g,'setTimeout')(e,Fc);break;case 'clearTimeout':var Gc=p(b).next().value;vb(a.g,a.l[Gc]);break;case 'setInterval':var Rb=p(b),Hc=Rb.next().value,Ic=Rb.next().value;a.m[Hc]=a.setInterval(e,Ic);break;case 'clearInterval':var Jc=p(b).next().value;a.clearInterval(a.m[Jc]);break;case 'injectJavaScriptResource':var Kc=p(b).next().value;zc(a,Kc,function(B){return e(!0,B)},function(){return e(!1)});break;case 'getVersion':e('1.5.5-iab77')}}catch(B){d.h(new W(f,\n'error',k,'\\n              name: '+B.name+'\\n              message: '+B.message+'\\n              filename: '+B.filename+'\\n              lineNumber: '+B.lineNumber+'\\n              columnNumber: '+B.columnNumber+'\\n              stack: '+B.stack+'\\n              toString(): '+B.toString()+'\\n          '),c)}}}\nfunction Ac(a){for(var b=Na().h,c=p(b.keys()),d=c.next();!d.done;d=c.next()){d=d.value;var e=b.get(d);if(e){if(e.contentWindow===a)return d;try{if(e.contentWindow.Object.prototype.isPrototypeOf(a))return d}catch(f){}}}};function Bc(a){var b={};return(b.app='omid_v1_present_app',b.web='omid_v1_present_web',b)[a]}function Cc(a,b){a.document.write('<iframe style=\"display:none\" id=\"'+(b+'\" name=\"'+b+'\" sandbox></iframe>'))}function Dc(a,b){var c=a.document.createElement('iframe');c.id=b;c.name=b;c.style.display='none';c.sandbox='';a.document.body.appendChild(c)}\nfunction Lc(a,b){var c=new MutationObserver(function(d){d.forEach(function(e){'BODY'===e.addedNodes[0].nodeName&&(e=Bc(b),Dc(a,'omid_v1_present'),Dc(a,e),c.disconnect())})});c.observe(a.document.documentElement,{childList:!0})};var uc=new tb,jc=new function(){this.i=uc;this.h=new Map;this.g=Zb(this)},qc=new ic;new tc;J.omidBridge=new Z;new pc;(function(a,b){a.frames&&a.document&&!['omid_v1_present','omid_v1_present_web','omid_v1_present_app'].some(function(c){return!!a.frames[c]})&&(null==a.document.body&&'MutationObserver'in a?Lc(a,b):(b=Bc(b),a.document.body?(Dc(a,'omid_v1_present'),Dc(a,b)):(Cc(a,'omid_v1_present'),Cc(a,b))))})(J,'app');\n}).call(this, this);";
                                        AdSessionContext createNativeAdSessionContext2 = AdSessionContext.createNativeAdSessionContext(c2796oa2.b, str2, verificationScriptResources2, e6, str16);
                                        Intrinsics.checkNotNullExpressionValue(createNativeAdSessionContext2, "createNativeAdSessionContext(...)");
                                        z = false;
                                        try {
                                            hashMap3.put("omidAdSession", new C2667ga("native_display_ad", ImpressionType.VIEWABLE, createNativeAdSessionContext2, false));
                                            c2833qe.b.put("deferred", Boolean.TRUE);
                                            InterfaceC2971z5 interfaceC2971z59 = this.j;
                                            if (interfaceC2971z59 != null) {
                                                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                                                ((A5) interfaceC2971z59).a("S0", "OMID video ad session created and JavaScript resources injected");
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            InterfaceC2971z5 interfaceC2971z510 = this.j;
                                            if (interfaceC2971z510 != null) {
                                                ((A5) interfaceC2971z510).b("S0", rf.a(e, H6.a("S0", "TAG", "Setting up impression tracking for OMID Native Display encountered an unexpected error: ")));
                                            }
                                            S5 s52 = S5.f2425a;
                                            S5.d.a(AbstractC2920w5.a(e, str));
                                            t = context;
                                            z2 = z3;
                                            it = it2;
                                        }
                                        t = context;
                                        z2 = z3;
                                        it = it2;
                                    }
                                }
                            }
                            t = context;
                            z2 = z3;
                            it = it2;
                        }
                    }
                }
            }
        }
    }

    public final C2613d8 a(C2811p8 c2811p8) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "isSkippableVideo ", this));
        }
        Iterator it = c2811p8.c().iterator();
        while (it.hasNext()) {
            C2613d8 c2613d8 = (C2613d8) c2811p8.n((String) it.next()).get(0);
            if (2 == c2613d8.k) {
                return c2613d8;
            }
        }
        return null;
    }

    public final void a(boolean z, GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        Set<C2833qe> e;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2;
        C2667ga c2667ga;
        AdConfig.ViewabilityConfig viewability;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("S0", D0.a("S0", "TAG", "omidSessionForHtmlMarkup ", this));
        }
        AdConfig adConfig = this.b;
        AdConfig.OmidConfig omidConfig = (adConfig == null || (viewability = adConfig.getViewability()) == null) ? null : viewability.getOmidConfig();
        if (omidConfig == null || omidConfig.isOmidEnabled()) {
            AbstractC2780na.f2651a.getClass();
            if (Omid.isActive() && (e = e(this.g.indexOf(gestureDetectorOnGestureListenerC2634ec))) != null) {
                for (C2833qe c2833qe : e) {
                    if (3 == c2833qe.f2687a) {
                        try {
                            String str = (String) c2833qe.a("creativeType", String.class);
                            String str2 = (String) c2833qe.a("customReferenceData", String.class);
                            Boolean bool = (Boolean) c2833qe.a("isolateVerificationScripts", Boolean.class);
                            Byte b = (Byte) c2833qe.a("impressionType", Byte.class);
                            if (str == null || bool == null || b == null) {
                                gestureDetectorOnGestureListenerC2634ec2 = gestureDetectorOnGestureListenerC2634ec;
                                c2667ga = null;
                            } else {
                                boolean booleanValue = bool.booleanValue();
                                String e2 = this.t.e();
                                byte byteValue = b.byteValue();
                                gestureDetectorOnGestureListenerC2634ec2 = gestureDetectorOnGestureListenerC2634ec;
                                try {
                                    c2667ga = AbstractC2716ja.a(str, gestureDetectorOnGestureListenerC2634ec2, booleanValue, e2, byteValue, str2);
                                } catch (Exception e3) {
                                    e = e3;
                                    Exception exc = e;
                                    InterfaceC2971z5 interfaceC2971z52 = this.j;
                                    if (interfaceC2971z52 != null) {
                                        ((A5) interfaceC2971z52).b("S0", rf.a(exc, H6.a("S0", "TAG", "Setting up impression tracking for IAB encountered an unexpected error: ")));
                                    }
                                    S5 s5 = S5.f2425a;
                                    S5.d.a(AbstractC2920w5.a(exc, "event"));
                                    gestureDetectorOnGestureListenerC2634ec = gestureDetectorOnGestureListenerC2634ec2;
                                }
                            }
                            if (c2667ga != null) {
                                c2833qe.b.put("omidAdSession", c2667ga);
                                c2833qe.b.put("deferred", Boolean.valueOf(z));
                                InterfaceC2971z5 interfaceC2971z53 = this.j;
                                if (interfaceC2971z53 != null) {
                                    Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                                    ((A5) interfaceC2971z53).a("S0", "OMID ad session created and WebView container registered with OMID");
                                }
                            } else {
                                InterfaceC2971z5 interfaceC2971z54 = this.j;
                                if (interfaceC2971z54 != null) {
                                    Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                                    ((A5) interfaceC2971z54).a("S0", "Ignoring IAB meta data for this ad markup");
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            gestureDetectorOnGestureListenerC2634ec2 = gestureDetectorOnGestureListenerC2634ec;
                        }
                        gestureDetectorOnGestureListenerC2634ec = gestureDetectorOnGestureListenerC2634ec2;
                    }
                }
            }
        }
    }

    public static final void a(S0 s0, C2672h c2672h, String str) {
        InterfaceC2971z5 interfaceC2971z5 = s0.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "updateAdForBlob ", s0));
        }
        c2672h.e(str);
        InterfaceC2971z5 interfaceC2971z52 = s0.j;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).c("S0", D0.a("S0", "TAG", "updateAd ", s0));
        }
        C2947y0 c2947y0 = s0.u;
        if (c2947y0 != null) {
            c2947y0.a(c2672h);
        }
    }

    public void a(String blob, String str) {
        Intrinsics.checkNotNullParameter(blob, "blob");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "saveBlob ", this));
        }
        A a2 = this.C;
        int hashCode = hashCode();
        Q0 q0 = new Q0(this, str, blob);
        a2.getClass();
        A.a(hashCode, q0);
    }

    public void a(String jsCallbackNamespace, String callback, InterfaceC2590c2 receiver, String str) {
        Intrinsics.checkNotNullParameter(jsCallbackNamespace, "jsCallbackNamespace");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "getBlob ", this));
        }
        A a2 = this.C;
        int hashCode = hashCode();
        I0 i0 = new I0(this, str, receiver, jsCallbackNamespace, callback);
        a2.getClass();
        A.a(hashCode, i0);
    }

    @Override // com.inmobi.media.Te
    public void a(C2672h primaryAd, boolean z, short s) {
        C2947y0 c2947y0;
        Intrinsics.checkNotNullParameter(primaryAd, "ad");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("S0", D0.a("S0", "TAG", "onVastProcessCompleted ", this));
        }
        C2672h m = m();
        if (m == null || W()) {
            m = null;
        }
        if (m == null) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).c("S0", H6.a("S0", "TAG", "Vast processing completed for ad with impressionId : ").append(m.s()).toString());
        }
        String u = m.u();
        int hashCode = u.hashCode();
        if (hashCode != -1084172778) {
            if (hashCode != 3213227) {
                if (hashCode == 1236050372 && u.equals("htmlUrl")) {
                    return;
                }
            } else if (u.equals(AnalyticsConstants.CREATIVE_TYPE_HTML)) {
                return;
            }
        } else if (u.equals("inmobiJson")) {
            if (this.f2420a == 2 && (c2947y0 = this.u) != null) {
                c2947y0.a(primaryAd);
                B0 p = p();
                String clientReqId = c2947y0.k();
                p.getClass();
                Intrinsics.checkNotNullParameter(primaryAd, "primaryAd");
                Intrinsics.checkNotNullParameter(clientReqId, "clientReqId");
                Set<C2942xb> y = primaryAd.y();
                if (y.isEmpty()) {
                    p.f2239a.a(p.c, true, (short) 0);
                    return;
                }
                String uuid = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
                C2721k c2721k = new C2721k(uuid, y, p.g, null, 16);
                String f = primaryAd.f();
                if (f != null) {
                    C2868t1 c2868t1 = C2868t1.f2707a;
                    C2868t1.a(c2721k, f);
                    return;
                }
                return;
            }
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("S0", "TAG");
                ((A5) interfaceC2971z53).b("S0", "Found inconsistent state after vast processing");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = this.j;
        if (interfaceC2971z54 != null) {
            ((A5) interfaceC2971z54).b("S0", H6.a("S0", "TAG", "Can not handle fallback for").append(m.u()).toString());
        }
        throw new IllegalStateException("Can not handle fallback for markup type: " + m.u());
    }
}
