package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.webkit.CookieManager;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.webkit.Profile;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.iab.omid.library.inmobi.Omid;
import com.iab.omid.library.inmobi.adsession.AdSessionContext;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.inmobi.adquality.models.AdQualityControl;
import com.inmobi.ads.WatermarkData;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.TelemetryConfig;
import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.rendering.model.EventTaskParams;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ec, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class GestureDetectorOnGestureListenerC2634ec extends X1 implements InterfaceC2930x, InterfaceC2590c2, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, InterfaceC2860sa, InterfaceC2961yb {
    public static final Gb Y0 = new Gb();
    public static final Eb Z0 = new Eb();
    public static final String a1 = "ec";
    public static final C2932x1 b1 = new C2932x1((Object) Boolean.FALSE, (Function0) Fb.f2285a, false, true);
    public JSONObject A;
    public InterfaceC2557a4 A0;
    public boolean B;
    public String B0;
    public boolean C;
    public C2844ra C0;
    public boolean D;
    public C2786o0 D0;
    public boolean E;
    public final AtomicBoolean E0;
    public EnumC2620df F;
    public boolean F0;
    public boolean G;
    public I G0;
    public boolean H;
    public String H0;
    public String I;
    public boolean I0;
    public final AtomicBoolean J;
    public Df J0;
    public final Object K;
    public boolean K0;
    public final Object L;
    public Map L0;
    public boolean M;
    public final Jb M0;
    public final boolean N;
    public final C2617dc N0;
    public View O;
    public String O0;
    public WebChromeClient.CustomViewCallback P;
    public final Ub P0;
    public int Q;
    public final Pb Q0;
    public boolean R;
    public final Hb R0;
    public boolean S;
    public boolean S0;
    public long T;
    public C2625e3 T0;
    public String U;
    public final Vb U0;
    public final AtomicBoolean V;
    public final Xb V0;
    public C2782nc W;
    public final Wb W0;
    public Bf X0;
    public final Lazy a0;
    public final byte b;
    public Ia b0;
    public final Set c;
    public final Lazy c0;
    public String d;
    public String d0;
    public final boolean e;
    public Map e0;
    public String f;
    public InterfaceC2573b2 f0;
    public long g;
    public InterfaceC2930x g0;
    public final C2685hc h;
    public boolean h0;
    public final InterfaceC2971z5 i;
    public boolean i0;
    public final Cc j;
    public InterfaceC2553a0 j0;
    public final tf k;
    public Xe k0;
    public final Q l;
    public final boolean l0;
    public Ha m;
    public int m0;
    public byte n;
    public String n0;
    public final Bd o;
    public int[] o0;
    public final Lazy p;
    public long p0;
    public WeakReference q;
    public int q0;
    public WeakReference r;
    public final Ib r0;
    public AbstractC2669gc s;
    public final Sb s0;
    public final Zb t;
    public int t0;
    public String u;
    public int u0;
    public F7 v;
    public final C2973z7 v0;
    public AdConfig w;
    public final GestureDetector w0;
    public boolean x;
    public boolean x0;
    public boolean y;
    public boolean y0;
    public JSONObject z;
    public C2592c4 z0;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GestureDetectorOnGestureListenerC2634ec(Context context, byte b, Set set, String str, boolean z, String str2, long j, C2685hc c2685hc, InterfaceC2971z5 interfaceC2971z5, Cc route, tf webViewFactory, Q q, int i) {
        super(r12);
        Set set2 = (i & 4) != 0 ? null : set;
        String str3 = (i & 8) != 0 ? null : str;
        boolean z2 = (i & 16) != 0 ? false : z;
        String landingScheme = (i & 32) != 0 ? "DEFAULT" : str2;
        long j2 = (i & 64) != 0 ? -1L : j;
        C2685hc c2685hc2 = (i & 128) != 0 ? null : c2685hc;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(landingScheme, "landingScheme");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(webViewFactory, "webViewFactory");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.b = b;
        this.c = set2;
        this.d = str3;
        this.e = z2;
        this.f = landingScheme;
        this.g = j2;
        this.h = c2685hc2;
        this.i = interfaceC2971z5;
        this.j = route;
        this.k = webViewFactory;
        this.l = q;
        this.m = new Yb(this);
        this.o = new Bd(interfaceC2971z5);
        this.p = LazyKt.lazy(new C2583bc(this));
        this.q = new WeakReference(null);
        this.t = new Zb();
        this.u = Profile.DEFAULT_PROFILE_NAME;
        this.B = true;
        this.C = true;
        this.E = true;
        this.F = EnumC2620df.f2552a;
        this.J = new AtomicBoolean(false);
        this.K = new Object();
        this.L = new Object();
        this.N = true;
        this.Q = -1;
        this.T = Long.MIN_VALUE;
        this.V = new AtomicBoolean(false);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.a0 = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new C2566ac(this));
        this.c0 = LazyKt.lazy(lazyThreadSafetyMode, (Function0) Tb.f2441a);
        this.r0 = new Ib(this);
        this.s0 = new Sb(this);
        this.t0 = Integer.MIN_VALUE;
        this.u0 = Integer.MIN_VALUE;
        this.E0 = new AtomicBoolean(true);
        this.M0 = new Jb(this);
        this.N0 = new C2617dc(this);
        this.O0 = AnalyticsConstants.CREATIVE_TYPE_HTML;
        this.P0 = new Ub(this);
        this.Q0 = new Pb(this);
        this.R0 = new Hb(this);
        String TAG = a1;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        toString();
        Y0.getClass();
        b1.a();
        this.g0 = this;
        this.l0 = true;
        this.C0 = new C2844ra();
        this.v0 = new C2973z7(this);
        GestureDetector gestureDetector = new GestureDetector(context, this);
        gestureDetector.setOnDoubleTapListener(this);
        gestureDetector.setIsLongpressEnabled(b == 1);
        this.w0 = gestureDetector;
        if (c2685hc2 != null) {
            this.W = new C2782nc(c2685hc2);
        }
        EnumC2560a7 enumC2560a7 = Cb.f2253a;
        Cb.a(this, interfaceC2971z5);
        if (q != null) {
            setAdType(q.f2403a);
            this.S0 = q.b;
            this.T = q.c;
            this.i0 = q.d;
            setCreativeId(q.e);
            this.j0 = q.i;
            this.n0 = q.j;
            String str4 = q.g;
            if (str4 != null) {
                this.O0 = str4;
            }
            String str5 = q.h;
            if (str5 != null) {
                setAdSize(str5);
            }
            setTelemetryManagerMap(q.k);
            String str6 = q.f;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).c(TAG, "creativeType " + this + ' ' + str6);
            }
            this.B0 = str6;
        }
        this.U0 = new Vb(this);
        this.V0 = new Xb(this);
        this.W0 = new Wb(this);
        this.X0 = (this.S0 || B2.a(context)) ? new Bf(0, 44, 44, 0) : new Bf(0, 0, 0, 0);
    }

    public static final void a(GestureDetectorOnGestureListenerC2634ec renderView, byte[] overlayBytes, WatermarkData watermarkData) {
        Intrinsics.checkNotNullParameter(renderView, "this$0");
        Intrinsics.checkNotNullParameter(overlayBytes, "$overlayBytes");
        Intrinsics.checkNotNullParameter(watermarkData, "$watermarkData");
        if (renderView.V.get()) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z5 = renderView.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "adding overlay to renderview");
        }
        Context context = renderView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        FrameLayout overlayLayout = nf.a(context, overlayBytes, watermarkData.getAlpha());
        Intrinsics.checkNotNullParameter(overlayLayout, "overlayLayout");
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        if (renderView.getParent() != null) {
            ViewParent parent = renderView.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).addView(overlayLayout, 0);
        }
        renderView.getViewableAd().a(overlayLayout, FriendlyObstructionPurpose.NOT_VISIBLE);
        renderView.V.set(true);
    }

    public static /* synthetic */ void getAdType$annotations() {
    }

    public static /* synthetic */ void getCloseAssetArea$annotations() {
    }

    public static /* synthetic */ void getImpressionType$annotations() {
    }

    private final TelemetryConfig.LandingPageConfig getLandingPageConfig() {
        return (TelemetryConfig.LandingPageConfig) this.c0.getValue();
    }

    public static /* synthetic */ void getMarkupType$annotations() {
    }

    public static /* synthetic */ void getMarkupTypeAdUnit$annotations() {
    }

    private final AdConfig.MraidConfig getMraidConfig() {
        return getMAdConfig().getMraid();
    }

    public static /* synthetic */ void getPlacementType$annotations() {
    }

    private final C2619de getScrollThrottler() {
        return (C2619de) this.a0.getValue();
    }

    public static /* synthetic */ void getViewState$annotations() {
    }

    public static /* synthetic */ void getWindowInsetListener$annotations() {
    }

    private final void setAdSize(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z5).a(str2, Ob.a(this, str2, "TAG", "setAdSize "));
        }
        V3 v3 = U3.f2447a;
        this.m0 = (int) (U3.b() * Integer.parseInt(((String[]) new Regex(VastAttributes.HORIZONTAL_POSITION).split(str, 0).toArray(new String[0]))[0]));
        this.p0 = ((int) (U3.b() * Integer.parseInt(((String[]) new Regex(VastAttributes.HORIZONTAL_POSITION).split(str, 0).toArray(new String[0]))[1]))) * this.m0;
    }

    public final void A() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "updateActivitiesOrientationProperties "));
        }
        Activity activity = (Activity) this.q.get();
        if (activity == null || !(activity instanceof InMobiAdActivity)) {
            return;
        }
        C2844ra orientationProperties = this.C0;
        Intrinsics.checkNotNullParameter(orientationProperties, "orientationProperties");
        C2743l5 c2743l5 = ((InMobiAdActivity) activity).f2223a;
        if (c2743l5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
            c2743l5 = null;
        }
        c2743l5.a(orientationProperties);
    }

    public final void B() {
        int i = AbstractC2970z4.f2771a;
        ((ScheduledThreadPoolExecutor) AbstractC2970z4.b.getValue()).execute(new Runnable() { // from class: com.inmobi.media.ec$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                GestureDetectorOnGestureListenerC2634ec.c(GestureDetectorOnGestureListenerC2634ec.this);
            }
        });
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public void b() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "destroyContainer "));
        }
        h();
        this.k.b(Qb.f2409a);
        removeAllViews();
        AdConfig.OmidConfig omidConfig = getMAdConfig().getViewability().getOmidConfig();
        if (this.l0 && omidConfig.isOmidEnabled()) {
            AbstractC2780na.f2651a.getClass();
            if (Omid.isActive()) {
                new C2702ic(this, omidConfig.getWebViewRetainTime()).a();
                return;
            }
        }
        super.destroy();
    }

    public final void c(boolean z) {
        C2786o0 c2786o0;
        AdQualityControl adQualityControl;
        Activity activity;
        C2786o0 c2786o02;
        AdQualityControl adQualityControl2;
        EnumC2620df enumC2620df = z ? EnumC2620df.c : EnumC2620df.b;
        if (this.F == enumC2620df || this.M) {
            return;
        }
        this.F = enumC2620df;
        if (z) {
            getListener().i(this);
        }
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "fireViewableChange " + this + ' ' + z);
        }
        c("window.mraidview.broadcastEvent('viewableChange'," + z + ");");
        C2786o0 c2786o03 = this.D0;
        if (c2786o03 != null) {
            EnumC2620df adViewableStatus = this.F;
            Intrinsics.checkNotNullParameter(adViewableStatus, "adViewableStatus");
            c2786o03.h = adViewableStatus;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String str = a1;
            ((A5) interfaceC2971z52).a(str, H6.a(str, "TAG", "fireAQSession - ").append(getAdType()).append(" type - sdk - ").append(Build.VERSION.SDK_INT).toString());
        }
        if (!Intrinsics.areEqual(getAdType(), "int") || Build.VERSION.SDK_INT < 29 || (activity = (Activity) this.q.get()) == null) {
            C2786o0 c2786o04 = this.D0;
            if (c2786o04 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityManager");
                c2786o0 = null;
            } else {
                c2786o0 = c2786o04;
            }
            c2786o0.getClass();
            Intrinsics.checkNotNullParameter(this, "adView");
            if (!c2786o0.a()) {
                c2786o0.a("session state invalid");
                return;
            }
            c2786o0.a("session start trigger...");
            c2786o0.c.set(true);
            AdQualityControl adQualityControl3 = c2786o0.g;
            if (adQualityControl3 == null || !adQualityControl3.getTakeScreenshot() || (adQualityControl = c2786o0.g) == null) {
                return;
            }
            c2786o0.a(this, (long) (adQualityControl.getScreenshotDelayInSeconds() * 1000), false, (Jb) null);
            return;
        }
        C2786o0 c2786o05 = this.D0;
        if (c2786o05 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adQualityManager");
            c2786o02 = null;
        } else {
            c2786o02 = c2786o05;
        }
        c2786o02.getClass();
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!c2786o02.a()) {
            c2786o02.a("session state invalid");
            return;
        }
        c2786o02.a("session start trigger...");
        c2786o02.c.set(true);
        AdQualityControl adQualityControl4 = c2786o02.g;
        if (adQualityControl4 == null || !adQualityControl4.getTakeScreenshot() || (adQualityControl2 = c2786o02.g) == null) {
            return;
        }
        c2786o02.a(activity, (long) (adQualityControl2.getScreenshotDelayInSeconds() * 1000), false, (Jb) null);
    }

    public final void d(String str) {
        C2782nc c2782nc = this.W;
        if (c2782nc != null) {
            c2782nc.b();
        }
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z5).a(str2, Ob.a(this, str2, "TAG", "loadDataInWebView "));
        }
        this.M = false;
        if (this.J.get()) {
            return;
        }
        Intrinsics.checkNotNull(str);
        loadDataWithBaseURL("", str, "text/html", "UTF-8", null);
    }

    public final void e(String str) {
        C2782nc c2782nc = this.W;
        if (c2782nc != null) {
            c2782nc.b();
        }
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z5).a(str2, Ob.a(this, str2, "TAG", "loadUrlInWebView "));
        }
        this.M = false;
        if (this.J.get() || str == null) {
            return;
        }
        loadUrl(str);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v2 com.inmobi.media.M6, still in use, count: 2, list:
          (r0v2 com.inmobi.media.M6) from 0x008e: MOVE (r18v0 com.inmobi.media.M6) = (r0v2 com.inmobi.media.M6)
          (r0v2 com.inmobi.media.M6) from 0x0042: MOVE (r18v2 com.inmobi.media.M6) = (r0v2 com.inmobi.media.M6)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:447)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // com.inmobi.media.X1
    public final com.inmobi.media.M6 f() {
        /*
            r19 = this;
            r5 = r19
            com.inmobi.media.z5 r0 = r5.i
            if (r0 == 0) goto L15
            java.lang.String r1 = com.inmobi.media.GestureDetectorOnGestureListenerC2634ec.a1
            java.lang.String r2 = "TAG"
            java.lang.String r3 = "initLandingPageHandler "
            java.lang.String r2 = com.inmobi.media.Ob.a(r5, r1, r2, r3)
            com.inmobi.media.A5 r0 = (com.inmobi.media.A5) r0
            r0.a(r1, r2)
        L15:
            com.inmobi.media.N6 r2 = new com.inmobi.media.N6
            boolean r0 = r5.e
            java.lang.String r1 = r5.f
            com.inmobi.commons.core.configs.AdConfig r3 = r5.getAdConfig()
            boolean r3 = r3.getCctEnabled()
            com.inmobi.commons.core.configs.AdConfig r4 = r5.getAdConfig()
            boolean r4 = r4.getPartialTabsEnabled()
            r2.<init>(r0, r1, r3, r4)
            com.inmobi.media.M6 r0 = new com.inmobi.media.M6
            android.content.Context r1 = r5.getContext()
            java.lang.String r3 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            com.inmobi.media.Pb r3 = r5.Q0
            com.inmobi.media.Ub r4 = r5.P0
            boolean r6 = r5.e
            if (r6 == 0) goto L46
            r6 = 0
            r18 = r0
            goto Lac
        L46:
            com.inmobi.media.S6 r7 = new com.inmobi.media.S6
            com.inmobi.media.hc r6 = r5.h
            if (r6 == 0) goto L55
            com.inmobi.media.Z r6 = r6.f2589a
            if (r6 == 0) goto L55
            long r8 = r6.l()
            goto L57
        L55:
            r8 = 0
        L57:
            java.lang.String r6 = r5.getImpressionId()
            java.lang.String r10 = ""
            if (r6 != 0) goto L60
            r6 = r10
        L60:
            com.inmobi.media.hc r11 = r5.h
            if (r11 == 0) goto L6e
            com.inmobi.media.Z r11 = r11.f2589a
            if (r11 == 0) goto L6e
            java.lang.String r11 = r11.m()
            if (r11 != 0) goto L6f
        L6e:
            r11 = r10
        L6f:
            com.inmobi.media.hc r12 = r5.h
            if (r12 == 0) goto L7d
            com.inmobi.media.Z r12 = r12.f2589a
            if (r12 == 0) goto L7d
            java.lang.String r12 = r12.b()
            if (r12 != 0) goto L7e
        L7d:
            r12 = r10
        L7e:
            com.inmobi.media.hc r13 = r5.h
            if (r13 == 0) goto L86
            java.lang.String r14 = r13.b
            if (r14 != 0) goto L87
        L86:
            r14 = r10
        L87:
            if (r13 == 0) goto L8d
            java.lang.String r15 = r13.e
            if (r15 != 0) goto L8e
        L8d:
            r15 = r10
        L8e:
            r18 = r0
            if (r13 == 0) goto L98
            java.lang.String r0 = r13.c
            if (r0 != 0) goto L97
            goto L98
        L97:
            r10 = r0
        L98:
            if (r13 == 0) goto L9d
            boolean r0 = r13.g
            goto L9e
        L9d:
            r0 = 0
        L9e:
            r16 = r0
            java.lang.String r0 = r5.f
            r17 = r0
            r13 = r14
            r14 = r15
            r15 = r10
            r10 = r6
            r7.<init>(r8, r10, r11, r12, r13, r14, r15, r16, r17)
            r6 = r7
        Lac:
            com.inmobi.media.z5 r7 = r5.i
            r0 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.GestureDetectorOnGestureListenerC2634ec.f():com.inmobi.media.M6");
    }

    public final void g() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "deferredDestroy "));
        }
        super.destroy();
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public AdConfig getAdConfig() {
        return getMAdConfig();
    }

    public final Q getAdMetaData() {
        return this.l;
    }

    public final InterfaceC2553a0 getAdPodHandler() {
        return this.j0;
    }

    public final C2786o0 getAdQualityManager() {
        C2786o0 c2786o0 = this.D0;
        if (c2786o0 != null) {
            return c2786o0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adQualityManager");
        return null;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public String getAdType() {
        return this.d0;
    }

    public final boolean getAllowAutoRedirection() {
        return this.i0;
    }

    public final int getArea() {
        return getHeight() * getWidth();
    }

    public final String getBeaconUrl() {
        return this.H0;
    }

    public final Bf getCloseAssetArea() {
        return this.X0;
    }

    public final long getConfiguredArea() {
        return this.p0;
    }

    public Context getContainerContext() {
        Activity activity = (Activity) this.q.get();
        if (activity != null) {
            return activity;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return context;
    }

    public final String getContentURL() {
        return this.n0;
    }

    public final C2625e3 getContextualDataHandler() {
        return this.T0;
    }

    public final String getCreativeID() {
        String creativeId = getCreativeId();
        return creativeId == null ? "" : creativeId;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public String getCreativeId() {
        return this.U;
    }

    public final String getCurrentPosition() {
        JSONObject jSONObject = this.A;
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
        return jSONObject2 == null ? "" : jSONObject2;
    }

    public final Object getCurrentPositionMonitor() {
        return this.L;
    }

    public final int getCurrentRenderingPodAdIndex() {
        InterfaceC2553a0 interfaceC2553a0 = this.j0;
        if (interfaceC2553a0 != null) {
            return ((S0) interfaceC2553a0).l(this);
        }
        return 0;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public Object getDataModel() {
        return null;
    }

    public final String getDefaultPosition() {
        JSONObject jSONObject = this.z;
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
        return jSONObject2 == null ? "" : jSONObject2;
    }

    public final Object getDefaultPositionMonitor() {
        return this.K;
    }

    public final InterfaceC2557a4 getEmbeddedBrowserJsCallbacks() {
        return this.A0;
    }

    public final I getExposureTracker() {
        return this.G0;
    }

    public Map<View, FriendlyObstructionPurpose> getFriendlyViews() {
        return this.e0;
    }

    public final Activity getFullScreenActivity() {
        return (Activity) this.q.get();
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public InterfaceC2914w getFullScreenEventsListener() {
        return this.U0;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public String getImpressionId() {
        return this.d;
    }

    public final byte getImpressionType() {
        return this.n;
    }

    public final String getLandingScheme() {
        return this.f;
    }

    public final AbstractC2669gc getListener() {
        AbstractC2669gc abstractC2669gc = this.s;
        if (abstractC2669gc != null) {
            return abstractC2669gc;
        }
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(this, str, "TAG", "listener getter "));
        }
        Eb eb = Z0;
        this.s = eb;
        return eb;
    }

    public final AdConfig getMAdConfig() {
        AdConfig adConfig = this.w;
        if (adConfig != null) {
            return adConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAdConfig");
        return null;
    }

    public final String getMCreativeType() {
        return this.B0;
    }

    public final int getMImpressionMinPercentageViewed() {
        return this.u0;
    }

    public final int getMImpressionMinTimeViewed() {
        return this.t0;
    }

    public final Xe getMViewableAd() {
        return this.k0;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public String getMarkupType() {
        return this.O0;
    }

    public final String getMarkupTypeAdUnit() {
        return this.O0;
    }

    public final F7 getMediaProcessor() {
        return this.v;
    }

    public final int getMinimumPixelsPainted() {
        return this.q0;
    }

    public final String getMraidJsString() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(this, str, "TAG", "mraidJsString getter "));
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        String a2 = new Sa(context, "mraid_js_store").a("mraid_js_string");
        if (a2 == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.i;
            if (interfaceC2971z52 != null) {
                String TAG = a1;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z52).a(TAG, "Returning default Mraid Js string.");
            }
            return "var imIsObjValid=function(a){return\"undefined\"!=typeof a&&null!=a?!0:!1},EventListeners=function(a){this.event=a;this.count=0;var b=[];this.add=function(a){b.push(a);++this.count};this.remove=function(a){var e=!1,d=this;b=b.filter(function(b){if(b=b===a)--d.count,e=!0;return!b});return e};this.removeAll=function(){b=[];this.count=0};this.broadcast=function(a){b.forEach(function(e){try{e.apply({},a)}catch(b){}})};this.toString=function(){var c=[a,\":\"];b.forEach(function(a){c.push(\"|\",String(a),\"|\")});\nreturn c.join(\"\")}},InmobiObj=function(){this.listeners=[];this.addEventListener=function(a,b){try{if(imIsObjValid(b)&&imIsObjValid(a)){var c=this.listeners;c[a]||(c[a]=new EventListeners);c[a].add(b);\"micIntensityChange\"==a&&window.imraidview.startListeningMicIntensity();\"deviceMuted\"==a&&window.imraidview.startListeningDeviceMuteEvents();\"deviceVolumeChange\"==a&&window.imraidview.startListeningDeviceVolumeChange();\"volumeChange\"==a&&window.imraidview.startListeningVolumeChange();\"headphones\"==a&&\nwindow.imraidview.startListeningHeadphonePluggedEvents();\"backButtonPressed\"==a&&window.imraidview.startListeningForBackButtonPressedEvent();\"downloadStatusChanged\"==a&&window.imraidview.registerDownloaderCallbacks()}}catch(e){this.log(e)}};this.removeEventListener=function(a,b){if(imIsObjValid(a)){var c=this.listeners;imIsObjValid(c[a])&&(imIsObjValid(b)?c[a].remove(b):c[a].removeAll());\"micIntensityChange\"==a&&0==c[a].count&&window.imraidview.stopListeningMicIntensity();\"deviceMuted\"==a&&0==c[a].count&&\nwindow.imraidview.stopListeningDeviceMuteEvents();\"deviceVolumeChange\"==a&&0==c[a].count&&window.imraidview.stopListeningDeviceVolumeChange();\"volumeChange\"==a&&0==c[a].count&&window.imraidview.stopListeningVolumeChange();\"headphones\"==a&&0==c[a].count&&window.imraidview.stopListeningHeadphonePluggedEvents();\"backButtonPressed\"==a&&0==c[a].count&&window.imraidview.stopListeningForBackButtonPressedEvent();\"downloadStatusChanged\"==a&&0==c[a].count&&window.imraidview.unregisterDownloaderCallbacks()}};\nthis.broadcastEvent=function(a){if(imIsObjValid(a)){for(var b=Array(arguments.length),c=0;c<arguments.length;c++)b[c]=arguments[c];c=b.shift();try{this.listeners[c]&&this.listeners[c].broadcast(b)}catch(e){}}};this.sendSaveContentResult=function(a){if(imIsObjValid(a)){for(var b=Array(arguments.length),c=0;c<arguments.length;c++)if(2==c){var e=arguments[c],e=JSON.parse(e);b[c]=e}else b[c]=arguments[c];e=b[1];\"success\"!=e&&(c=b[0].substring(b[0].indexOf(\"_\")+1),imraid.saveContentIDMap[c]&&delete imraid.saveContentIDMap[c]);\nwindow.imraid.broadcastEvent(b[0],b[1],b[2])}}},__im__iosNativeMessageHandler=void 0;window.webkit&&(window.webkit.messageHandlers&&window.webkit.messageHandlers.nativeMessageHandler)&&(__im__iosNativeMessageHandler=window.webkit.messageHandlers.nativeMessageHandler);\nvar __im__iosNativeCall={nativeCallInFlight:!1,nativeCallQueue:[],executeNativeCall:function(a){this.nativeCallInFlight?this.nativeCallQueue.push(a):(this.nativeCallInFlight=!0,imIsObjValid(__im__iosNativeMessageHandler)?__im__iosNativeMessageHandler.postMessage(a):window.location=a)},nativeCallComplete:function(a){0==this.nativeCallQueue.length?this.nativeCallInFlight=!1:(a=this.nativeCallQueue.shift(),imIsObjValid(__im__iosNativeMessageHandler)?__im__iosNativeMessageHandler.postMessage(a):window.location=\na)}},IOSNativeCall=function(){this.urlScheme=\"\";this.executeNativeCall=function(a){if(imIsObjValid(__im__iosNativeMessageHandler)){e={};e.command=a;e.scheme=this.urlScheme;for(var b={},c=1;c<arguments.length;c+=2)d=arguments[c+1],null!=d&&(b[arguments[c]]=\"\"+d);e.params=b}else for(var e=this.urlScheme+\"://\"+a,d,b=!0,c=1;c<arguments.length;c+=2)d=arguments[c+1],null!=d&&(b?(e+=\"?\",b=!1):e+=\"&\",e+=arguments[c]+\"=\"+escape(d));__im__iosNativeCall.executeNativeCall(e);return\"OK\"};this.nativeCallComplete=\nfunction(a){__im__iosNativeCall.nativeCallComplete(a);return\"OK\"};this.updateKV=function(a,b){this[a]=b;var c=this.broadcastMap[a];c&&this.broadcastEvent(c,b)}};\n(function(){var a=window.mraidview={};a.orientationProperties={allowOrientationChange:!0,forceOrientation:\"none\",direction:\"right\"};var b=[],c=!1;a.detectAndBlockFraud=function(e){a.isPossibleFraud()&&a.fireRedirectFraudBeacon(e);return!1};a.popupBlocked=function(e){a.firePopupBlockedBeacon(e)};a.zeroPad=function(a){var c=\"\";10>a&&(c+=\"0\");return c+a};a.supports=function(a){console.log(\"bridge: supports (MRAID)\");if(\"string\"!=typeof a)window.mraid.broadcastEvent(\"error\",\"Supports method expects string parameter\",\n\"supports\");else return\"false\"!=sdkController.supports(\"window.mraidview\",a)};a.useCustomClose=function(a){try{sdkController.useCustomClose(\"window.mraidview\",a)}catch(c){imraidview.showAlert(\"use CustomClose: \"+c)}};a.close=function(){try{sdkController.close(\"window.mraidview\")}catch(a){imraidview.showAlert(\"close: \"+a)}};a.stackCommands=function(a,d){c?b.push(a):(eval(a),d&&(c=!0))};a.setOrientationProperties=function(e){try{e?(\"undefined\"!=typeof e.allowOrientationChange&&(a.orientationProperties.allowOrientationChange=\ne.allowOrientationChange),\"undefined\"!=typeof e.forceOrientation&&(a.orientationProperties.forceOrientation=e.forceOrientation)):e=null,sdkController.setOrientationProperties(\"window.mraidview\",a.stringify(a.orientationProperties))}catch(c){imraidview.showAlert(\"setOrientationProperties: \"+c+\", props = \"+e)}};a.getOrientationProperties=function(){return{forceOrientation:a.orientationProperties.forceOrientation,allowOrientationChange:a.orientationProperties.allowOrientationChange}};a.resizeProps=null;\na.open=function(a){\"undefined\"==typeof a&&(a=null);try{sdkController.open(\"window.mraidview\",a)}catch(c){imraidview.showAlert(\"open: \"+c)}};a.getScreenSize=function(){try{return eval(\"(\"+sdkController.getScreenSize(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getScreenSize: \"+a)}};a.getMaxSize=function(){try{return eval(\"(\"+sdkController.getMaxSize(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getMaxSize: \"+a)}};a.getCurrentPosition=function(){try{return eval(\"(\"+sdkController.getCurrentPosition(\"window.mraidview\")+\n\")\")}catch(a){imraidview.showAlert(\"getCurrentPosition: \"+a)}};a.getDefaultPosition=function(){try{return eval(\"(\"+sdkController.getDefaultPosition(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getDefaultPosition: \"+a)}};a.getState=function(){try{return String(sdkController.getState(\"window.mraidview\"))}catch(a){imraidview.showAlert(\"getState: \"+a)}};a.isViewable=function(){if(imraidview.fallbackViewabilityEnabled())return imraidview.checkFallbackViewable();try{return sdkController.isViewable(\"window.mraidview\")}catch(a){imraidview.showAlert(\"isViewable: \"+\na)}};a.getPlacementType=function(){return sdkController.getPlacementType(\"window.mraidview\")};a.close=function(){try{sdkController.close(\"window.mraidview\")}catch(a){imraidview.showAlert(\"close: \"+a)}};\"function\"!=typeof String.prototype.startsWith&&(String.prototype.startsWith=function(a){return 0==this.indexOf(a)});a.playVideo=function(a){var c=\"\";null!=a&&(c=a);try{sdkController.playVideo(\"window.mraidview\",c)}catch(b){imraidview.showAlert(\"playVideo: \"+b)}};a.stringify=function(c){if(\"undefined\"===\ntypeof JSON){var b=\"\",f;if(\"undefined\"==typeof c.length)return a.stringifyArg(c);for(f=0;f<c.length;f++)0<f&&(b+=\",\"),b+=a.stringifyArg(c[f]);return b+\"]\"}return JSON.stringify(c)};a.stringifyArg=function(a){var c,b,g;b=typeof a;c=\"\";if(\"number\"===b||\"boolean\"===b)c+=args;else if(a instanceof Array)c=c+\"[\"+a+\"]\";else if(a instanceof Object){b=!0;c+=\"{\";for(g in a)null!==a[g]&&(b||(c+=\",\"),c=c+'\"'+g+'\":',b=typeof a[g],c=\"number\"===b||\"boolean\"===b?c+a[g]:\"function\"===typeof a[g]?c+'\"\"':a[g]instanceof\nObject?c+this.stringify(args[i][g]):c+'\"'+a[g]+'\"',b=!1);c+=\"}\"}else a=a.replace(/\\\\/g,\"\\\\\\\\\"),a=a.replace(/\"/g,'\\\\\"'),c=c+'\"'+a+'\"';imraidview.showAlert(\"json:\"+c);return c};getPID=function(a){var c=\"\";null!=a&&(\"undefined\"!=typeof a.id&&null!=a.id)&&(c=a.id);return c};a.storePicture=function(c){console.log(\"bridge: storePicture\");if(\"string\"!=typeof c)window.mraid.broadcastEvent(\"error\",\"storePicture method expects url as string parameter\",\"storePicture\");else{if(a.supports(\"storePicture\"))return!window.confirm(\"Do you want to download the file?\")?\n(window.mraid.broadcastEvent(\"error\",\"Store picture on \"+c+\" was cancelled by user.\",\"storePicture\"),!1):sdkController.storePicture(\"window.mraidview\",c);window.mraid.broadcastEvent(\"error\",\"Store picture on \"+c+\" was cancelled because it is unsupported in this device/app.\",\"storePicture\")}};a.fireMediaTrackingEvent=function(a,c){};a.fireMediaErrorEvent=function(a,c){};a.fireMediaTimeUpdateEvent=function(a,c,b){};a.fireMediaCloseEvent=function(a,c,b){};a.fireMediaVolumeChangeEvent=function(a,c,b){};\na.broadcastEvent=function(){window.mraid.broadcastEvent.apply(window.mraid,arguments)};a.unload=function(){try{sdkController.unload(\"window.mraidview\")}catch(a){}};a.getCurrentAppOrientation=function(){var c;switch(a.orientation){case 0:case 180:c=\"portrait\";break;case 90:case 270:c=\"landscape\";break;default:c=\"none\"}return{orientation:c,locked:!1}};a.expand=function(a){try{\"undefined\"==typeof a&&(a=null),sdkController.expand(\"window.mraidview\",a)}catch(c){imraidview.showAlert(\"executeNativeExpand: \"+\nc+\", URL = \"+a)}};a.setExpandProperties=function(c){try{c?this.props=c:c=null;if(\"undefined\"!=typeof c.lockOrientation&&null!=c.lockOrientation&&\"undefined\"!=typeof c.orientation&&null!=c.orientation){var b={};b.allowOrientationChange=!c.lockOrientation;b.forceOrientation=c.orientation;a.setOrientationProperties(b)}sdkController.setExpandProperties(\"window.mraidview\",a.stringify(c))}catch(f){imraidview.showAlert(\"executeNativesetExpandProperties: \"+f+\", props = \"+c)}};a.getExpandProperties=function(){try{return eval(\"(\"+\nsdkController.getExpandProperties(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getExpandProperties: \"+a)}};a.resizeProps=null;a.setResizeProperties=function(c){var b,f;try{b=parseInt(c.width);f=parseInt(c.height);if(isNaN(b)||isNaN(f)||1>b||1>f)throw\"Invalid\";c.width=b;c.height=f;a.resizeProps=c;sdkController.setResizeProperties(\"window.mraidview\",a.stringify(c))}catch(g){window.mraid.broadcastEvent(\"error\",\"Invalid properties.\",\"setResizeProperties\")}};a.getResizeProperties=function(){try{return eval(\"(\"+\nsdkController.getResizeProperties(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getResizeProperties: \"+a)}};a.resize=function(){if(null==a.resizeProps)window.mraid.broadcastEvent(\"error\",\"Valid resize dimensions must be provided before calling resize\",\"resize\");else try{sdkController.resize(\"window.mraidview\")}catch(c){imraidview.showAlert(\"resize called in bridge\")}}})();\n(function(){var a=window.mraid=new InmobiObj,b=window.mraidview,c=!1;b.isAdShownToUser=!1;b.onUserInteraction=function(){imraidview.onUserInteraction();c=!0};b.isPossibleFraud=function(){return a.supports(\"redirectFraudDetection\")&&(!b.isAdShownToUser||!c)};b.fireRedirectFraudBeacon=function(a){if(\"undefined\"!=typeof inmobi&&inmobi.recordEvent){var c={};c.trigger=a;c.isAdShown=b.isAdShownToUser.toString();inmobi.recordEvent(135,c)}};b.getSdkVersionInt=function(){for(var a=imraid.getSdkVersion().split(\".\"),\nc=a.length,b=\"\",g=0;g<c;g++)b+=a[g];return parseInt(b)};b.firePopupBlockedBeacon=function(a){if(\"undefined\"!=typeof inmobi&&inmobi.recordEvent){var c={};c.trigger=a;inmobi.recordEvent(136,c)}};window.onbeforeunload=function(){b.detectAndBlockFraud(\"redirect\")};a.addEventListener(\"viewableChange\",function(a){a&&!b.isAdShownToUser&&(b.isAdShownToUser=!0)});a.useCustomClose=b.useCustomClose;a.close=b.close;a.getExpandProperties=function(){if(1083<=b.getSdkVersionInt())return window.mraid.broadcastEvent(\"error\",\n\"Method not supported\",\"getExpandProperties\"),null;window.mraid.broadcastEvent(\"error\",\"MRAID getExpandProperties is deprecated\",\"getExpandProperties\");return b.getExpandProperties()};a.setExpandProperties=function(c){1083<=b.getSdkVersionInt()?window.mraid.broadcastEvent(\"error\",\"Method not supported\",\"setExpandProperties\"):(\"undefined\"!=typeof c&&(\"useCustomClose\"in c&&\"undefined\"!=typeof a.getState()&&\"expanded\"!=a.getState())&&a.useCustomClose(c.useCustomClose),window.mraid.broadcastEvent(\"error\",\n\"MRAID setExpandProperties is deprecated\",\"setExpandProperties\"),b.setExpandProperties(c))};a.getResizeProperties=function(){if(1083<=b.getSdkVersionInt())return window.mraid.broadcastEvent(\"error\",\"Method not supported\",\"getResizeProperties\"),null;window.mraid.broadcastEvent(\"error\",\"MRAID getResizeProperties is deprecated\",\"getResizeProperties\");return b.getResizeProperties()};a.setResizeProperties=function(a){1083<=b.getSdkVersionInt()?window.mraid.broadcastEvent(\"error\",\"Method not supported\",\n\"setResizeProperties\"):(window.mraid.broadcastEvent(\"error\",\"MRAID setResizeProperties is deprecated\",\"setResizeProperties\"),b.setResizeProperties(a))};a.getOrientationProperties=b.getOrientationProperties;a.setOrientationProperties=b.setOrientationProperties;a.expand=function(a){try{1083<=b.getSdkVersionInt()?\"string\"===typeof a&&\"\"!==a.trim()?b.open(a):window.mraid.broadcastEvent(\"error\",\"Method not supported\",\"expand\"):(window.mraid.broadcastEvent(\"error\",\"MRAID expand is deprecated\",\"expand\"),\nb.expand(a))}catch(c){window.mraid.broadcastEvent(\"error\",\"error\",\"expand\")}};a.getMaxSize=b.getMaxSize;a.getState=b.getState;a.isViewable=b.isViewable;a.createCalendarEvent=function(a){window.mraid.broadcastEvent(\"error\",\"Method not supported\",\"createCalendarEvent\")};a.open=function(c){b.detectAndBlockFraud(\"mraid.open\")||(\"string\"!=typeof c?a.broadcastEvent(\"error\",\"URL is required.\",\"open\"):b.open(c))};a.resize=function(){try{1083<=b.getSdkVersionInt()?window.mraid.broadcastEvent(\"error\",\"MRAID resize not supported\",\n\"resize\"):(window.mraid.broadcastEvent(\"error\",\"MRAID resize is deprecated\",\"resize\"),b.expand())}catch(a){window.mraid.broadcastEvent(\"error\",\"error\",\"expand\")}};a.getVersion=function(){return\"3.0\"};a.getPlacementType=b.getPlacementType;a.playVideo=function(a){b.playVideo(a)};a.getScreenSize=b.getScreenSize;a.getCurrentPosition=b.getCurrentPosition;a.getDefaultPosition=b.getDefaultPosition;a.supports=function(a){return b.supports(a)};a.storePicture=function(c){\"string\"!=typeof c?a.broadcastEvent(\"error\",\n\"Request must specify a valid URL\",\"storePicture\"):b.storePicture(c)};a.unload=function(){b.unload()};a.getCurrentAppOrientation=b.getCurrentAppOrientation;a.getLocation=function(){return null};a.getAudioVolume=b.getAudioVolume})();\n(function(){var a=window.imraidview={},b=!1;a.setOrientationProperties=function(c){try{c?(\"undefined\"!=typeof c.allowOrientationChange&&(mraidview.orientationProperties.allowOrientationChange=c.allowOrientationChange),\"undefined\"!=typeof c.forceOrientation&&(mraidview.orientationProperties.forceOrientation=c.forceOrientation),\"undefined\"!=typeof c.direction&&(mraidview.orientationProperties.direction=c.direction)):c=null,sdkController.setOrientationProperties(\"window.imraidview\",mraidview.stringify(mraidview.orientationProperties))}catch(b){a.showAlert(\"setOrientationProperties: \"+\nb+\", props = \"+c)}};a.getOrientationProperties=function(){return mraidview.orientationProperties};a.firePostStatusEvent=function(a){window.imraid.broadcastEvent(\"postStatus\",a)};a.fireMediaTrackingEvent=function(a,b){var d={};d.name=a;var f=\"inmobi_media_\"+a;\"undefined\"!=typeof b&&(null!=b&&\"\"!=b)&&(f=f+\"_\"+b);window.imraid.broadcastEvent(f,d)};a.fireMediaErrorEvent=function(a,b){var d={name:\"error\"};d.code=b;var f=\"inmobi_media_\"+d.name;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(f=f+\"_\"+a);window.imraid.broadcastEvent(f,\nd)};a.fireMediaTimeUpdateEvent=function(a,b,d){var f={name:\"timeupdate\",target:{}};f.target.currentTime=b;f.target.duration=d;b=\"inmobi_media_\"+f.name;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(b=b+\"_\"+a);window.imraid.broadcastEvent(b,f)};a.saveContent=function(a,b,d){window.imraid.addEventListener(\"saveContent_\"+a,d);sdkController.saveContent(\"window.imraidview\",a,b)};a.cancelSaveContent=function(a){sdkController.cancelSaveContent(\"window.imraidview\",a)};a.disableCloseRegion=function(a){sdkController.disableCloseRegion(\"window.imraidview\",\na)};a.fireGalleryImageSelectedEvent=function(a,b,d){var f=new Image;f.src=\"data:image/jpeg;base64,\"+a;f.width=b;f.height=d;window.imraid.broadcastEvent(\"galleryImageSelected\",f)};a.fireCameraPictureCatpturedEvent=function(a,b,d){var f=new Image;f.src=\"data:image/jpeg;base64,\"+a;f.width=b;f.height=d;window.imraid.broadcastEvent(\"cameraPictureCaptured\",f)};a.fireMediaCloseEvent=function(a,b,d){var f={name:\"close\"};f.viaUserInteraction=b;f.target={};f.target.currentTime=d;b=\"inmobi_media_\"+f.name;\"undefined\"!=\ntypeof a&&(null!=a&&\"\"!=a)&&(b=b+\"_\"+a);window.imraid.broadcastEvent(b,f)};a.fireMediaVolumeChangeEvent=function(a,b,d){var f={name:\"volumechange\",target:{}};f.target.volume=b;f.target.muted=d;b=\"inmobi_media_\"+f.name;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(b=b+\"_\"+a);window.imraid.broadcastEvent(b,f)};a.fireDeviceMuteChangeEvent=function(a){window.imraid.broadcastEvent(\"deviceMuted\",a)};a.fireDeviceVolumeChangeEvent=function(a){window.imraid.broadcastEvent(\"deviceVolumeChange\",a)};a.fireHeadphonePluggedEvent=\nfunction(a){window.imraid.broadcastEvent(\"headphones\",a)};a.showAlert=function(a){sdkController.showAlert(\"window.imraidview\",a)};a.openExternal=function(c,b){try{600<=getSdkVersionInt()?sdkController.openExternal(\"window.imraidview\",c,b):sdkController.openExternal(\"window.imraidview\",c)}catch(d){a.showAlert(\"openExternal: \"+d)}};a.log=function(c){try{sdkController.log(\"window.imraidview\",c)}catch(b){a.showAlert(\"log: \"+b)}};a.getPlatform=function(){return\"android\"};a.asyncPing=function(c){try{sdkController.asyncPing(\"window.imraidview\",\nc)}catch(b){a.showAlert(\"asyncPing: \"+b)}};a.startListeningDeviceMuteEvents=function(){sdkController.registerDeviceMuteEventListener(\"window.imraidview\")};a.stopListeningDeviceMuteEvents=function(){sdkController.unregisterDeviceMuteEventListener(\"window.imraidview\")};a.startListeningDeviceVolumeChange=function(){sdkController.registerDeviceVolumeChangeEventListener(\"window.imraidview\")};a.stopListeningDeviceVolumeChange=function(){sdkController.unregisterDeviceVolumeChangeEventListener(\"window.imraidview\")};\na.startListeningHeadphonePluggedEvents=function(){sdkController.registerHeadphonePluggedEventListener(\"window.imraidview\")};a.stopListeningHeadphonePluggedEvents=function(){sdkController.unregisterHeadphonePluggedEventListener(\"window.imraidview\")};getSdkVersionInt=function(){for(var c=a.getSdkVersion().split(\".\"),b=c.length,d=\"\",f=0;f<b;f++)d+=c[f];return parseInt(d)};a.getSdkVersionInt=getSdkVersionInt;a.getSdkVersion=function(){return window._im_imaiview.getSdkVersion()};a.supports=function(a){console.log(\"bridge: supports (IMRAID)\");\nif(\"string\"!=typeof a)window.imraid.broadcastEvent(\"error\",\"Supports method expects string parameter\",\"supports\");else return\"false\"!=sdkController.supports(\"window.imraidview\",a)};a.postToSocial=function(c,b,d,f){window.imraid.broadcastEvent(\"error\",\"Method not supported\",\"postToSocial\");a.log(\"Method postToSocial not supported\")};a.incentCompleted=function(a){if(\"object\"!=typeof a||null==a)sdkController.incentCompleted(\"window.imraidview\",null);else try{sdkController.incentCompleted(\"window.imraidview\",\nJSON.stringify(a))}catch(b){sdkController.incentCompleted(\"window.imraidview\",null)}};a.getOrientation=function(){try{return String(sdkController.getOrientation(\"window.imraidview\"))}catch(c){a.showAlert(\"getOrientation: \"+c)}};a.acceptAction=function(c){try{sdkController.acceptAction(\"window.imraidview\",mraidview.stringify(c))}catch(b){a.showAlert(\"acceptAction: \"+b+\", params = \"+c)}};a.rejectAction=function(c){try{sdkController.rejectAction(\"window.imraidview\",mraidview.stringify(c))}catch(b){a.showAlert(\"rejectAction: \"+\nb+\", params = \"+c)}};a.updateToPassbook=function(c){window.imraid.broadcastEvent(\"error\",\"Method not supported\",\"updateToPassbook\");a.log(\"Method not supported\")};a.isDeviceMuted=function(){return\"false\"!=sdkController.isDeviceMuted(\"window.imraidview\")};a.getDeviceVolume=function(){return 603>=getSdkVersionInt()?-1:sdkController.getDeviceVolume(\"window.imraidview\")};a.isHeadPhonesPlugged=function(){return\"false\"!=sdkController.isHeadphonePlugged(\"window.imraidview\")};a.sendSaveContentResult=function(){window.imraid.sendSaveContentResult.apply(window.imraid,\narguments)};a.broadcastEvent=function(){window.imraid.broadcastEvent.apply(window.imraid,arguments)};a.disableBackButton=function(a){void 0==a||\"boolean\"!=typeof a?console.log(\"disableBackButton called with invalid params\"):sdkController.disableBackButton(\"window.imraidview\",a)};a.isBackButtonDisabled=function(){return sdkController.isBackButtonDisabled(\"window.imraidview\")};a.startListeningForBackButtonPressedEvent=function(){sdkController.registerBackButtonPressedEventListener(\"window.imraidview\")};\na.stopListeningForBackButtonPressedEvent=function(){sdkController.unregisterBackButtonPressedEventListener(\"window.imraidview\")};a.hideStatusBar=function(){};a.setOpaqueBackground=function(){};a.startDownloader=function(a,b,d){682<=getSdkVersionInt()&&sdkController.startDownloader(\"window.imraidview\",a,b,d)};a.registerDownloaderCallbacks=function(){682<=getSdkVersionInt()&&sdkController.registerDownloaderCallbacks(\"window.imraidview\")};a.unregisterDownloaderCallbacks=function(){682<=getSdkVersionInt()&&\nsdkController.unregisterDownloaderCallbacks(\"window.imraidview\")};a.getDownloadProgress=function(){return 682<=getSdkVersionInt()?sdkController.getDownloadProgress(\"window.imraidview\"):-1};a.getDownloadStatus=function(){return 682<=getSdkVersionInt()?sdkController.getDownloadStatus(\"window.imraidview\"):-1};a.fireEvent=function(a){700<=getSdkVersionInt()&&(\"fireSkip\"===a?sdkController.fireSkip(\"window.imraidview\"):\"fireComplete\"===a?sdkController.fireComplete(\"window.imraidview\"):\"showEndCard\"===a&&\nsdkController.showEndCard(\"window.imraidview\"))};a.saveBlob=function(a){700<=getSdkVersionInt()&&sdkController.saveBlob(\"window.imraidview\",a)};a.getBlob=function(a,b){700<=getSdkVersionInt()&&sdkController.getBlob(a,b)};a.setCloseEndCardTracker=function(a){700<=getSdkVersionInt()&&sdkController.setCloseEndCardTracker(\"window.imraidview\",a)};a.getRenderableAdIndexes=function(){try{if(917<=getSdkVersionInt())return sdkController.getRenderableAdIndexes(\"window.imraidview\")}catch(a){}return\"[]\"};a.getCurrentRenderingIndex=\nfunction(){try{if(917<=getSdkVersionInt())return sdkController.getCurrentRenderingIndex(\"window.imraidview\")}catch(a){}return-1};a.showAd=function(a){try{917<=getSdkVersionInt()&&sdkController.showAd(\"window.imraidview\",a)}catch(b){}};a.timeSinceShow=function(){try{if(917<=getSdkVersionInt())return sdkController.timeSinceShow(\"window.imraidview\")}catch(a){}return-1};a.getShowTimeStamp=function(){try{if(917<=getSdkVersionInt())return sdkController.getShowTimeStamp(\"window.imraidview\")}catch(a){}return-1};\na.closeAll=function(){try{917<=getSdkVersionInt()&&sdkController.closeAll(\"window.imraidview\")}catch(a){}};a.loadAd=function(a){try{917<=getSdkVersionInt()&&sdkController.loadAd(\"window.imraidview\",a)}catch(b){}};a.setAdContext=function(a){try{917<=getSdkVersionInt()&&sdkController.setAdContext(\"window.imraidview\",a)}catch(b){}};a.getAdContext=function(){try{if(917<=getSdkVersionInt())return sdkController.getAdContext(\"window.imraidview\")}catch(a){}return\"\"};a.openWithoutTracker=function(a){try{\"undefined\"==\ntypeof a&&(a=null),sdkController.openWithoutTracker(\"window.imraidview\",a)}catch(b){}};a.impressionRendered=function(){window.imraid.broadcastEvent(\"impressionRendered\")};a.customExpandInNative=function(a,b,d){try{void 0==a||\"string\"!=typeof a?console.log(\"url called with invalid params\"):void 0==b||\"number\"!=typeof b?console.log(\"screenPercentage called with invalid params\"):void 0==d||\"boolean\"!=typeof d?console.log(\"hideCloseButton called with invalid params\"):sdkController.customExpandInNative(\"window.imraidview\",\na,b,d)}catch(f){}};a.customExpand=function(b,e,d,f,g){try{void 0==d||\"number\"!=typeof d?console.log(\"screenPercentage called with invalid params\"):void 0==e||\"number\"!=typeof e?console.log(\"inputType called with invalid params\"):void 0==f||\"boolean\"!=typeof f?console.log(\"topNavBarVisible called with invalid params\"):void 0==g||\"boolean\"!=typeof g?console.log(\"bottomNavBarVisible called with invalid params\"):sdkController.customExpand(\"window.imraidview\",b,e,d,f,g)}catch(h){a.showAlert(\"executeNativeCustomExpand: \"+\nh+\", input = \"+b+\", inputType = \"+e+\", screenPercentage = \"+d+\", bottomNavBarVisible = \"+g+\", topNavBarVisible = \"+f)}};a.closeCustomExpand=function(){try{sdkController.closeCustomExpand(\"window.imraidview\")}catch(a){}};a.onGestureDetected=function(a,b){window.imraid.broadcastEvent(\"onGestureDetected\",a,b)};a.onUserLandingCompleted=function(){window.imraid.broadcastEvent(\"onUserLandingCompleted\")};a.onUserInteraction=function(){window.imraid.broadcastEvent(\"onUserInteraction\")};a.impressionFired=\nfunction(){try{sdkController.impressionFired(\"window.imraidview\")}catch(a){}};a.getMaxDeviceVolume=function(){try{return sdkController.getMaxDeviceVolume(\"window.imraidview\")}catch(a){return 15}};a.zoom=function(a){try{sdkController.zoom(\"window.imraidview\",a)}catch(b){}};a.onAudioStateChanged=function(a){try{sdkController.onAudioStateChanged(\"window.imraidview\",a)}catch(b){}};a.submitAdReport=function(a){try{sdkController.submitAdReport(\"window.imraidview\",void 0!=a.adQualityUrl?a.adQualityUrl:null,\nvoid 0!=a.enableUserAdReportScreenshot?a.enableUserAdReportScreenshot:null,void 0!=a.templateInfo?a.templateInfo:null)}catch(b){}};a.logTelemetryEvent=function(a){try{var b=void 0!=a.eventType?a.eventType:null,d=void 0!=a.payload?a.payload:null;a=null;null!=d&&(a=mraidview.stringify(d));sdkController.logTelemetryEvent(\"window.imraidview\",b,a)}catch(f){}};a.onUserAudioMuteInteraction=function(a){try{sdkController.onUserAudioMuteInteraction(\"window.imraidview\",a)}catch(b){}};a.enableFallbackViewabilityFunctionality=\nfunction(){b=!0;a.checkFallbackViewable()&&window.mraid.broadcastEvent(\"viewableChange\",!0);mraid.addEventListener(\"sizeChange\",function(){window.mraid.broadcastEvent(\"viewableChange\",a.checkFallbackViewable())})};a.checkFallbackViewable=function(){try{var b=mraidview.getCurrentPosition(),e=b.height;return 40<=b.width&&40<=e?!0:!1}catch(d){a.showAlert(\"checkFallbackViewable: \"+d)}};a.fallbackViewabilityEnabled=function(){return b};a.getSafeArea=function(){try{return JSON.parse(sdkController.getSafeArea(\"window.imraidview\"))}catch(a){return null}};\na.loadWebView=function(b,e){try{\"string\"!==typeof b?a.showAlert(\"loadWebView: id parameter should be a string\"):\"string\"!==typeof e?a.showAlert(\"loadWebView: html parameter should be a string\"):sdkController.loadWebView(\"window.imraidview\",b,e)}catch(d){a.showAlert(\"loadWebView: \"+d)}};a.showWebView=function(b){try{\"string\"!==typeof b?a.showAlert(\"showWebView: id parameter should be a string\"):sdkController.showWebView(\"window.imraidview\",b)}catch(e){a.showAlert(\"showWebView: \"+e)}};a.sendMessage=\nfunction(b,e){try{\"string\"!==typeof b?a.showAlert(\"sendMessage: id parameter should be a string\"):\"string\"!==typeof e?a.showAlert(\"sendMessage: message parameter should be a string\"):sdkController.sendMessage(\"window.imraidview\",b,e)}catch(d){a.showAlert(\"sendMessage: \"+d)}};a.destroyWebView=function(b){try{\"string\"!==typeof b?a.showAlert(\"destroyWebView: id parameter should be a string\"):sdkController.destroyWebView(\"window.imraidview\",b)}catch(e){a.showAlert(\"destroyWebView: \"+e)}};a.pingV2=function(b){if(\"object\"===\ntypeof b&&null!==b)try{sdkController.pingV2(\"window.imraidview\",JSON.stringify(b))}catch(e){a.showAlert(\"pingV2: \"+e)}else a.showAlert(\"pingV2: pingJson is not a valid JSON object\")}})();\n(function(){var a=window.imraid=new InmobiObj,b=window.imraidview;a.getOrientation=b.getOrientation;a.setOrientationProperties=b.setOrientationProperties;a.getOrientationProperties=b.getOrientationProperties;a.saveContentIDMap={};a.saveContent=function(c,d,f){var g=arguments.length,h,k=null;if(3>g){if(\"function\"===typeof arguments[g-1])h=arguments[g-1];else return;k={reason:1}}else a.saveContentIDMap[c]&&(h=arguments[2],k={reason:11,url:arguments[1]});\"function\"!==!h&&(k?(window.imraid.addEventListener(\"saveContent_failed_\"+\nc,h),window.imraid.sendSaveContentResult(\"saveContent_failed_\"+c,\"failed\",JSON.stringify(k))):(a.removeEventListener(\"saveContent_\"+c),a.saveContentIDMap[c]=!0,b.saveContent(c,d,f)))};a.cancelSaveContent=function(a){b.cancelSaveContent(a)};a.asyncPing=function(c){\"string\"!=typeof c?a.broadcastEvent(\"error\",\"URL is required.\",\"asyncPing\"):b.asyncPing(c)};a.disableCloseRegion=b.disableCloseRegion;a.getSdkVersion=b.getSdkVersion;a.log=function(c){\"undefined\"==typeof c?a.broadcastEvent(\"error\",\"message is required.\",\n\"log\"):\"string\"==typeof c?b.log(c):b.log(JSON.stringify(c))};a.getInMobiAIVersion=function(){return\"2.0\"};a.getVendorName=function(){return\"inmobi\"};a.openExternal=function(a,c){console.log(\"openExternal is deprecated, will be removed in future version\");mraidview.detectAndBlockFraud(\"imraid.openExternal\")||b.openExternal(a,c)};a.updateToPassbook=function(c){mraidview.detectAndBlockFraud(\"imraid.updateToPassbook\")||(\"string\"!=typeof c?a.broadcastEvent(\"error\",\"Request must specify a valid URL\",\"updateToPassbook\"):\nb.updateToPassbook(c))};a.postToSocial=function(a,c,f,g){mraidview.detectAndBlockFraud(\"imraid.postToSocial\")||b.postToSocial(a,c,f,g)};a.getPlatform=b.getPlatform;a.incentCompleted=b.incentCompleted;a.loadSKStore=b.loadSKStore;a.showSKStore=function(a){mraidview.detectAndBlockFraud(\"imraid.showSKStore\")||b.showSKStore(a)};a.pingV2=b.pingV2;a.skoverlay=b.skoverlay;a.skoverlayWithSkan=b.skoverlayWithSkan;a.zoom=b.zoom;a.dismissSKOverlay=b.dismissSKOverlay;a.supports=function(a){return b.supports(a)};\na.isDeviceMuted=function(){return!imIsObjValid(a.listeners.deviceMuted)?-1:b.isDeviceMuted()};a.isHeadPhonesPlugged=function(){return!imIsObjValid(a.listeners.headphones)?!1:b.isHeadPhonesPlugged()};a.getDeviceVolume=function(){return b.getDeviceVolume()};a.setDeviceVolume=function(a){b.setDeviceVolume(a)};a.hideStatusBar=function(){b.hideStatusBar()};a.setOpaqueBackground=function(){b.setOpaqueBackground()};a.getRenderableAdIndexes=b.getRenderableAdIndexes;a.getCurrentRenderingIndex=b.getCurrentRenderingIndex;\na.showAd=b.showAd;a.timeSinceShow=b.timeSinceShow;a.closeAll=b.closeAll;a.loadAd=b.loadAd;a.setAdContext=b.setAdContext;a.getAdContext=b.getAdContext;a.getShowTimeStamp=b.getShowTimeStamp;a.disableBackButton=b.disableBackButton;a.isBackButtonDisabled=b.isBackButtonDisabled;a.startDownloader=b.startDownloader;a.getDownloadProgress=b.getDownloadProgress;a.getDownloadStatus=b.getDownloadStatus;a.fireEvent=b.fireEvent;a.saveBlob=b.saveBlob;a.getBlob=b.getBlob;a.setCloseEndCardTracker=b.setCloseEndCardTracker;\na.openWithoutTracker=b.openWithoutTracker;a.impressionRendered=b.impressionRendered;a.onGestureDetected=b.onGestureDetected;a.onUserLandingCompleted=b.onUserLandingCompleted;a.customExpand=b.customExpand;a.closeCustomExpand=b.closeCustomExpand;a.customExpandInNative=b.customExpandInNative;a.impressionFired=b.impressionFired;a.getImraidVersion=b.getImraidVersion;a.getMaxDeviceVolume=b.getMaxDeviceVolume;a.onAudioStateChanged=b.onAudioStateChanged;a.onUserAudioMuteInteraction=b.onUserAudioMuteInteraction;\na.submitAdReport=b.submitAdReport;a.enableFallbackViewabilityFunctionality=b.enableFallbackViewabilityFunctionality;a.logTelemetryEvent=b.logTelemetryEvent;a.getSafeArea=b.getSafeArea;a.onReceviedSKANCallback=b.onReceviedSKANCallback;a.getOpenMode=b.getOpenMode;a.loadWebView=b.loadWebView;a.showWebView=b.showWebView;a.sendMessage=b.sendMessage;a.destroyWebView=b.destroyWebView;try{a.addEventListener(\"onUserLandingCompleted\",function(){1080>b.getSdkVersionInt()&&a.broadcastEvent(\"onUserLandingInitialized\")})}catch(c){}})();\n(function(){var a=window._im_imaiview={ios:{}};window.imaiview=a;a.broadcastEvent=function(){for(var a=Array(arguments.length),c=0;c<arguments.length;c++)a[c]=arguments[c];c=a.shift();try{window.mraid.broadcastEvent(c,a)}catch(e){}};a.getPlatform=function(){return\"android\"};a.getPlatformVersion=function(){return sdkController.getPlatformVersion(\"window.imaiview\")};a.log=function(a){sdkController.log(\"window.imaiview\",a)};a.openEmbedded=function(a){sdkController.openEmbedded(\"window.imaiview\",a)};\na.openExternal=function(a,c){600<=getSdkVersionInt()?sdkController.openExternal(\"window.imaiview\",a,c):sdkController.openExternal(\"window.imaiview\",a)};a.ping=function(a,c){sdkController.ping(\"window.imaiview\",a,c)};a.pingInWebView=function(a,c){sdkController.pingInWebView(\"window.imaiview\",a,c)};a.getSdkVersion=function(){try{var a=sdkController.getSdkVersion(\"window.imaiview\");if(\"string\"==typeof a&&null!=a)return a}catch(c){return\"3.7.0\"}};a.onUserInteraction=function(a){if(\"object\"!=typeof a||\nnull==a)sdkController.onUserInteraction(\"window.imaiview\",null);else try{sdkController.onUserInteraction(\"window.imaiview\",JSON.stringify(a))}catch(c){sdkController.onUserInteraction(\"window.imaiview\",null)}};a.fireAdReady=function(){sdkController.fireAdReady(\"window.imaiview\")};a.fireAdFailed=function(){sdkController.fireAdFailed(\"window.imaiview\")};a.broadcastEvent=function(){window.imai.broadcastEvent.apply(window.imai,arguments)}})();\n(function(){var a=window._im_imaiview;window._im_imai=new InmobiObj;window._im_imai.ios=new InmobiObj;var b=window._im_imai;window.imai=window._im_imai;b.matchString=function(a,b){if(\"string\"!=typeof a||null==a||null==b)return-1;var d=-1;try{d=a.indexOf(b)}catch(f){}return d};b.isHttpUrl=function(a){return\"string\"!=typeof a||null==a?!1:0==b.matchString(a,\"http://\")?!0:0==b.matchString(a,\"https://\")?!0:!1};b.appendTapParams=function(a,e,d){if(!imIsObjValid(e)||!imIsObjValid(d))return a;b.isHttpUrl(a)&&\n(a=-1==b.matchString(a,\"?\")?a+(\"?u-tap-o=\"+e+\",\"+d):a+(\"&u-tap-o=\"+e+\",\"+d));return a};b.performAdClick=function(a,e){e=e||event;if(imIsObjValid(a)){var d=a.clickConfig,f=a.landingConfig;if(!imIsObjValid(d)&&!imIsObjValid(f))b.log(\"click/landing config are invalid, Nothing to process .\"),this.broadcastEvent(\"error\",\"click/landing config are invalid, Nothing to process .\");else{var g=null,h=null,k=null,m=null,n=null,l=null,q=null,p=null;if(imIsObjValid(e))try{m=e.changedTouches[0].pageX,n=e.changedTouches[0].pageY}catch(r){n=\nm=0}imIsObjValid(f)?imIsObjValid(d)?(l=f.url,q=f.fallbackUrl,p=f.urlType,g=d.url,h=d.pingWV,k=d.fr):(l=f.url,p=f.urlType):(l=d.url,p=d.urlType);d=b.getPlatform();try{if(\"boolean\"!=typeof k&&\"number\"!=typeof k||null==k)k=!0;if(0>k||1<k)k=!0;if(\"boolean\"!=typeof h&&\"number\"!=typeof h||null==h)h=!0;if(0>h||1<h)h=!0;if(\"number\"!=typeof p||null==p)p=0;g=b.appendTapParams(g,m,n);imIsObjValid(g)?!0==h?b.pingInWebView(g,k):b.ping(g,k):b.log(\"clickurl provided is null.\");if(imIsObjValid(l))switch(imIsObjValid(g)||\n(l=b.appendTapParams(l,m,n)),p){case 1:b.openEmbedded(l);break;case 2:\"ios\"==d?b.ios.openItunesProductView(l):this.broadcastEvent(\"error\",\"Cannot process openItunesProductView for os\"+d);break;default:b.openExternal(l,q)}else b.log(\"Landing url provided is null.\")}catch(s){}}}else b.log(\" invalid config, nothing to process .\"),this.broadcastEvent(\"error\",\"invalid config, nothing to process .\")};b.performActionClick=function(a,e){e=e||event;if(imIsObjValid(a)){var d=a.clickConfig,f=a.landingConfig;\nif(!imIsObjValid(d)&&!imIsObjValid(f))b.log(\"click/landing config are invalid, Nothing to process .\"),this.broadcastEvent(\"error\",\"click/landing config are invalid, Nothing to process .\");else{var g=null,h=null,k=null,m=null,n=null;if(imIsObjValid(e))try{m=e.changedTouches[0].pageX,n=e.changedTouches[0].pageY}catch(l){n=m=0}imIsObjValid(d)&&(g=d.url,h=d.pingWV,k=d.fr);try{if(\"boolean\"!=typeof k&&\"number\"!=typeof k||null==k)k=!0;if(0>k||1<k)k=!0;if(\"boolean\"!=typeof h&&\"number\"!=typeof h||null==h)h=\n!0;if(0>h||1<h)h=!0;g=b.appendTapParams(g,m,n);imIsObjValid(g)?!0==h?b.pingInWebView(g,k):b.ping(g,k):b.log(\"clickurl provided is null.\");b.onUserInteraction(f)}catch(q){}}}else b.log(\" invalid config, nothing to process .\"),this.broadcastEvent(\"error\",\"invalid config, nothing to process .\")};b.getVersion=function(){return\"1.0\"};b.getPlatform=a.getPlatform;b.getPlatformVersion=a.getPlatformVersion;b.log=a.log;b.openEmbedded=function(b){console.log(\"openEmbedded is deprecated, will be removed in future version\");\nmraidview.detectAndBlockFraud(\"imai.openEmbedded\")||a.openEmbedded(b)};b.openExternal=function(b,e){console.log(\"openExternal is deprecated, will be removed in future version\");mraidview.detectAndBlockFraud(\"imai.openExternal\")||a.openExternal(b,e)};b.ping=a.ping;b.pingInWebView=a.pingInWebView;b.onUserInteraction=a.onUserInteraction;b.getSdkVersion=a.getSdkVersion;b.loadSKStore=a.loadSKStore;b.showSKStore=function(b){mraidview.detectAndBlockFraud(\"imai.showSKStore\")||a.showSKStore(b)};b.ios.openItunesProductView=\nfunction(b){mraidview.detectAndBlockFraud(\"imai.ios.openItunesProductView\")||a.ios.openItunesProductView(b)};b.fireAdReady=a.fireAdReady;b.fireAdFailed=a.fireAdFailed})();";
        }
        InterfaceC2971z5 interfaceC2971z53 = this.i;
        if (interfaceC2971z53 != null) {
            String TAG2 = a1;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z53).a(TAG2, "Returning fetched Mraid Js string.");
        }
        return a2;
    }

    public final C2844ra getOrientationProperties() {
        return this.C0;
    }

    public final long getPlacementId() {
        return this.T;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public byte getPlacementType() {
        return this.b;
    }

    public InterfaceC2930x getReferenceContainer() {
        return this.g0;
    }

    public final C2782nc getRenderViewTelemetry() {
        return this.W;
    }

    public final JSONArray getRenderableAdIndexes() {
        JSONArray N;
        InterfaceC2553a0 interfaceC2553a0 = this.j0;
        return (interfaceC2553a0 == null || (N = ((S0) interfaceC2553a0).N()) == null) ? new JSONArray() : N;
    }

    public final AdConfig.RenderingConfig getRenderingConfig() {
        return getMAdConfig().getRendering();
    }

    public final Cc getRoute() {
        return this.j;
    }

    public final JSONObject getSafeArea() {
        Df df = this.J0;
        if (df != null) {
            Integer f = U3.f();
            Cf cf = (f == null && (f = U3.g) == null) ? null : (Cf) df.d.get(Integer.valueOf(f.intValue()));
            if (cf != null) {
                return cf.a();
            }
        }
        return null;
    }

    public final boolean getShouldFireLandingPageBeacons() {
        return this.I0;
    }

    public final long getShowTimeStamp() {
        InterfaceC2553a0 interfaceC2553a0 = this.j0;
        if (interfaceC2553a0 != null) {
            return ((S0) interfaceC2553a0).O();
        }
        return 0L;
    }

    public final C2584bd getSiblingWebviewManager() {
        return (C2584bd) this.p.getValue();
    }

    public Map<String, U0> getTelemetryManagerMap() {
        return this.L0;
    }

    public Yd getTelemetryOnAdImpression() {
        Map<String, U0> telemetryManagerMap = getTelemetryManagerMap();
        return new Yd(telemetryManagerMap != null ? telemetryManagerMap.get("AdImpressionSuccessful") : null, this.B0, getCreativeId(), getMarkupType());
    }

    public final boolean getUnloaded() {
        return this.K0;
    }

    public final ef getVISIBILITY_CHANGE_LISTENER() {
        return this.R0;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public View getVideoContainerView() {
        return null;
    }

    public final String getViewState() {
        return this.u;
    }

    @Override // com.inmobi.media.InterfaceC2961yb
    public long getViewTouchTimestamp() {
        return this.g;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008e A[Catch: Exception -> 0x00d4, TryCatch #0 {Exception -> 0x00d4, blocks: (B:13:0x004e, B:18:0x0053, B:20:0x0060, B:21:0x0064, B:23:0x006c, B:26:0x0082, B:28:0x008e, B:31:0x0095, B:34:0x00af, B:45:0x00b3, B:37:0x00c2, B:40:0x00c6), top: B:12:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00af A[Catch: Exception -> 0x00d4, TryCatch #0 {Exception -> 0x00d4, blocks: (B:13:0x004e, B:18:0x0053, B:20:0x0060, B:21:0x0064, B:23:0x006c, B:26:0x0082, B:28:0x008e, B:31:0x0095, B:34:0x00af, B:45:0x00b3, B:37:0x00c2, B:40:0x00c6), top: B:12:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b3 A[SYNTHETIC] */
    @Override // com.inmobi.media.InterfaceC2930x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Xe getViewableAd() {
        boolean z;
        String str;
        AdSessionContext createHtmlAdSessionContext;
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z5).a(str2, Ob.a(this, str2, "TAG", "viewableAd getter "));
        }
        if (this.k0 == null) {
            this.k0 = new L5(this, new C2569af(this), new S4(this.n, this.B0, this.t0, this.u0, getVisibilityTrackingMinPercentage(), this.i), this.i);
            Set<C2833qe> set = this.c;
            if (set != null) {
                for (C2833qe c2833qe : set) {
                    try {
                        if (c2833qe.f2687a == 3) {
                            Object obj = c2833qe.b.get("omidAdSession");
                            C2667ga c2667ga = obj instanceof C2667ga ? (C2667ga) obj : null;
                            if (c2833qe.b.containsKey("deferred")) {
                                Object obj2 = c2833qe.b.get("deferred");
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                                if (((Boolean) obj2).booleanValue()) {
                                    z = true;
                                    Object obj3 = c2833qe.b.get("customReferenceData");
                                    str = obj3 instanceof String ? (String) obj3 : null;
                                    if (z && c2667ga != null) {
                                        String str3 = this.n0;
                                        C2796oa c2796oa = AbstractC2780na.f2651a;
                                        c2796oa.getClass();
                                        Intrinsics.checkNotNullParameter(this, "webView");
                                        createHtmlAdSessionContext = AdSessionContext.createHtmlAdSessionContext(c2796oa.b, this, str3, str);
                                        Intrinsics.checkNotNullExpressionValue(createHtmlAdSessionContext, "createHtmlAdSessionContext(...)");
                                        if (createHtmlAdSessionContext == null) {
                                            c2667ga.c = createHtmlAdSessionContext;
                                        }
                                    }
                                    if (c2667ga == null) {
                                        Xe xe = this.k0;
                                        Intrinsics.checkNotNull(xe);
                                        this.k0 = new C2732ka(this, xe, c2667ga, this.i);
                                    } else {
                                        InterfaceC2971z5 interfaceC2971z52 = this.i;
                                        if (interfaceC2971z52 != null) {
                                            String TAG = a1;
                                            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                                            ((A5) interfaceC2971z52).b(TAG, "Did not find a OMID ad session; the IAB decorator will not be applied.");
                                        }
                                    }
                                }
                            }
                            z = false;
                            Object obj32 = c2833qe.b.get("customReferenceData");
                            if (obj32 instanceof String) {
                            }
                            if (z) {
                                String str32 = this.n0;
                                C2796oa c2796oa2 = AbstractC2780na.f2651a;
                                c2796oa2.getClass();
                                Intrinsics.checkNotNullParameter(this, "webView");
                                createHtmlAdSessionContext = AdSessionContext.createHtmlAdSessionContext(c2796oa2.b, this, str32, str);
                                Intrinsics.checkNotNullExpressionValue(createHtmlAdSessionContext, "createHtmlAdSessionContext(...)");
                                if (createHtmlAdSessionContext == null) {
                                }
                            }
                            if (c2667ga == null) {
                            }
                        }
                    } catch (Exception e) {
                        InterfaceC2971z5 interfaceC2971z53 = this.i;
                        if (interfaceC2971z53 != null) {
                            String str4 = a1;
                            ((A5) interfaceC2971z53).b(str4, rf.a(e, H6.a(str4, "TAG", "Exception occurred while creating the HTML viewable ad : ")));
                        }
                    }
                }
            }
        }
        Xe xe2 = this.k0;
        Intrinsics.checkNotNull(xe2);
        return xe2;
    }

    public final int[] getViewableFrameArray() {
        return this.o0;
    }

    public final int getVisibilityTrackingMinPercentage() {
        return Intrinsics.areEqual("audio", getAdType()) ? getMAdConfig().getViewability().getAudioImpressionMinPercentageViewed() : getMAdConfig().getViewability().getWebImpressionMinPercentageViewed();
    }

    public final tf getWebViewFactory() {
        return this.k;
    }

    public final Af getWindowInsetListener() {
        return this.N0;
    }

    public final Bd getWvStateMachine() {
        return this.o;
    }

    public final void h() {
        if (this.J.get()) {
            return;
        }
        if (!this.E) {
            this.E = true;
            return;
        }
        this.J.set(true);
        tf tfVar = this.k;
        String id = this.j.b;
        tfVar.getClass();
        Intrinsics.checkNotNullParameter(id, "id");
        tfVar.b.remove(id);
        InterfaceC2971z5 interfaceC2971z5 = tfVar.f2716a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("SiblingWebViewManager", AbstractC2673h0.a("Unregistered bridge for WebView ID: ", id));
        }
        Df df = this.J0;
        if (df != null) {
            df.a();
        }
        C2625e3 c2625e3 = this.T0;
        if (c2625e3 != null) {
            c2625e3.b();
        }
        this.M = true;
        this.Q = -1;
        removeJavascriptInterface("sdkController");
        F7 f7 = this.v;
        if (f7 != null) {
            C2857s7 c2857s7 = f7.d;
            if (c2857s7 != null) {
                c2857s7.a();
            }
            f7.d = null;
            C2857s7 c2857s72 = f7.e;
            if (c2857s72 != null) {
                c2857s72.a();
            }
            f7.e = null;
            C2857s7 c2857s73 = f7.f;
            if (c2857s73 != null) {
                c2857s73.a();
            }
            f7.f = null;
        }
        this.q.clear();
        WeakReference weakReference = this.r;
        if (weakReference != null) {
            weakReference.clear();
        }
        Xe xe = this.k0;
        if (xe != null) {
            xe.e();
        }
        Xe xe2 = this.k0;
        if (xe2 != null) {
            xe2.a();
        }
        Ia ia = this.b0;
        if (ia != null) {
            C2576b5 c2576b5 = Aa.f2234a;
            if (c2576b5 != null) {
                String id2 = ia.c;
                Intrinsics.checkNotNullParameter(id2, "id");
                c2576b5.b.remove(id2);
                Iterator it = c2576b5.b.entrySet().iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    if (((WeakReference) ((Map.Entry) next).getValue()).get() == null) {
                        it.remove();
                    }
                }
            }
            F3 f3 = Aa.b;
            if (f3 != null) {
                String id3 = ia.c;
                Intrinsics.checkNotNullParameter(id3, "id");
                f3.b.remove(id3);
                Iterator it2 = f3.b.entrySet().iterator();
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    if (((WeakReference) ((Map.Entry) next2).getValue()).get() == null) {
                        it2.remove();
                    }
                }
            }
            ia.d.set(true);
        }
        this.b0 = null;
        x();
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String str = a1;
            ((A5) interfaceC2971z52).a(str, Ob.a(this, str, "TAG", "stopTrackingAudioVolume "));
        }
        C2849s c2849s = C2849s.f2699a;
        C2849s.c(this.i, this.r0);
        Map<View, FriendlyObstructionPurpose> friendlyViews = getFriendlyViews();
        if (friendlyViews != null) {
            friendlyViews.clear();
        }
        setFriendlyViews(null);
        this.A0 = null;
        this.s = null;
        this.g0 = null;
        this.j0 = null;
        this.x0 = false;
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public void i() {
        InterfaceC2553a0 interfaceC2553a0;
        Activity fullScreenActivity;
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "dismissCurrentViewContainer "));
        }
        F7 f7 = this.v;
        if (f7 != null) {
            C2906v7 c2906v7 = f7.c;
            if (c2906v7 != null) {
                c2906v7.b();
            }
            f7.c = null;
        }
        if (Intrinsics.areEqual(Profile.DEFAULT_PROFILE_NAME, this.u)) {
            setAndUpdateViewState("Hidden");
            ViewParent parent = getParent();
            boolean z = parent instanceof ViewGroup;
            if (z) {
                this.k.b(Rb.f2418a);
            }
            if (1 == this.b) {
                InterfaceC2971z5 interfaceC2971z52 = this.i;
                if (interfaceC2971z52 != null) {
                    String str2 = a1;
                    ((A5) interfaceC2971z52).a(str2, Ob.a(this, str2, "TAG", "finishFullScreenActivity "));
                }
                SparseArray sparseArray = InMobiAdActivity.k;
                Intrinsics.checkNotNullParameter(this, "container");
                InMobiAdActivity.k.remove(hashCode());
                if (getFullScreenActivity() != null) {
                    InterfaceC2553a0 interfaceC2553a02 = this.j0;
                    if (interfaceC2553a02 == null || !interfaceC2553a02.a(this)) {
                        Activity fullScreenActivity2 = getFullScreenActivity();
                        Intrinsics.checkNotNull(fullScreenActivity2, "null cannot be cast to non-null type com.inmobi.ads.rendering.InMobiAdActivity");
                        ((InMobiAdActivity) fullScreenActivity2).e = true;
                        Activity fullScreenActivity3 = getFullScreenActivity();
                        if (fullScreenActivity3 != null) {
                            fullScreenActivity3.finish();
                        }
                        if (this.Q != -1 && (fullScreenActivity = getFullScreenActivity()) != null) {
                            fullScreenActivity.overridePendingTransition(0, this.Q);
                        }
                    }
                } else {
                    if (Intrinsics.areEqual(Profile.DEFAULT_PROFILE_NAME, this.u)) {
                        setAndUpdateViewState("Hidden");
                    }
                    z();
                }
            } else if (z) {
                ((ViewGroup) parent).removeAllViews();
            }
        }
        if (this.F != EnumC2620df.c || (interfaceC2553a0 = this.j0) == null) {
            return;
        }
        interfaceC2553a0.a(this, getFullScreenActivity());
    }

    public final void j() {
        if (this.K0) {
            InterfaceC2971z5 interfaceC2971z5 = this.i;
            if (interfaceC2971z5 != null) {
                String TAG = a1;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).a(TAG, "fireAdFailed " + this + " - Ad is already unloaded");
                return;
            }
            return;
        }
        this.y0 = true;
        C2782nc c2782nc = this.W;
        if (c2782nc != null) {
            Map a2 = c2782nc.a();
            long j = c2782nc.c;
            ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
            a2.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
            String a3 = c2782nc.a("FireAdFailed");
            Pd pd = Pd.f2401a;
            Pd.b(a3, a2, Td.f2443a);
        }
        getListener().g(this);
    }

    public final void k() {
        if (this.J.get()) {
            InterfaceC2971z5 interfaceC2971z5 = this.i;
            if (interfaceC2971z5 != null) {
                String TAG = a1;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).b(TAG, "fireAdReady called on destroyed view");
                return;
            }
            return;
        }
        if (this.K0) {
            InterfaceC2971z5 interfaceC2971z52 = this.i;
            if (interfaceC2971z52 != null) {
                String TAG2 = a1;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).a(TAG2, "fireAdReady " + this + " - Ad is already unloaded");
                return;
            }
            return;
        }
        C2782nc c2782nc = this.W;
        if (c2782nc != null) {
            Map a2 = c2782nc.a();
            long j = c2782nc.c;
            ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
            long elapsedRealtime = SystemClock.elapsedRealtime() - j;
            a2.put("latency", Long.valueOf(elapsedRealtime));
            c2782nc.h = elapsedRealtime;
            String a3 = c2782nc.a("FireAdReady");
            Pd pd = Pd.f2401a;
            Pd.b(a3, a2, Td.f2443a);
        }
        InterfaceC2971z5 interfaceC2971z53 = this.i;
        if (interfaceC2971z53 != null) {
            String str = a1;
            ((A5) interfaceC2971z53).a(str, Ob.a(this, str, "TAG", "fireAdReady "));
        }
        this.x0 = true;
        if (this.n == 0) {
            m();
        }
        B();
        getListener().h(this);
    }

    public final void l() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "fireClickTrackers "));
        }
        C2625e3 c2625e3 = this.T0;
        if (c2625e3 != null && !c2625e3.g.get()) {
            c2625e3.d.g = 1;
            Intrinsics.checkNotNull(c2625e3.c);
        }
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z52).a(str2, Ob.a(this, str2, "TAG", "fireOnUserInteraction "));
        }
        c("window.imraidview.onUserInteraction();");
        getListener().b(this);
    }

    public void m() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "fireImpression "));
        }
        if (Intrinsics.areEqual("video", this.B0) || Intrinsics.areEqual("audio", this.B0)) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z52).a(str2, Ob.a(this, str2, "TAG", "recordContextualData "));
        }
        C2625e3 c2625e3 = this.T0;
        if (c2625e3 != null) {
            c2625e3.a();
        }
        c("window.imraidview.impressionRendered();");
        getListener().c(this);
    }

    public final boolean n() {
        if (Intrinsics.areEqual(getAdType(), "banner") && getAdConfig().getMraid3().getBannerEnabled()) {
            return true;
        }
        return Intrinsics.areEqual(getAdType(), "int") && getAdConfig().getMraid3().getInterstitialEnabled();
    }

    public void o() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "onImpressionFired "));
        }
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z52).a(str2, Ob.a(this, str2, "TAG", "recordContextualData "));
        }
        C2625e3 c2625e3 = this.T0;
        if (c2625e3 != null) {
            c2625e3.a();
        }
        getListener().a(getTelemetryOnAdImpression());
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec;
        Set<View> keySet;
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "onAttachedToWindow "));
        }
        super.onAttachedToWindow();
        F7 f7 = this.v;
        if (f7 != null) {
            C2857s7 c2857s7 = f7.d;
            if (c2857s7 != null) {
                c2857s7.b();
            }
            C2857s7 c2857s72 = f7.e;
            if (c2857s72 != null) {
                c2857s72.b();
            }
            C2857s7 c2857s73 = f7.f;
            if (c2857s73 != null) {
                c2857s73.b();
            }
        }
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z52).c(str2, Ob.a(this, str2, "TAG", "setIsViewHardwareAccelerated "));
        }
        this.x = isHardwareAccelerated();
        Set set = null;
        if (this.r == null) {
            ViewParent parent = getParent();
            this.r = new WeakReference(parent instanceof ViewGroup ? (ViewGroup) parent : null);
        }
        y();
        InterfaceC2971z5 interfaceC2971z53 = this.i;
        if (interfaceC2971z53 != null) {
            String str3 = a1;
            ((A5) interfaceC2971z53).a(str3, Ob.a(this, str3, "TAG", "startTrackingExposure "));
        }
        if (!n() || this.e) {
            gestureDetectorOnGestureListenerC2634ec = this;
            InterfaceC2971z5 interfaceC2971z54 = gestureDetectorOnGestureListenerC2634ec.i;
            if (interfaceC2971z54 != null) {
                String TAG = a1;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z54).b(TAG, "exposureTracker is already initialized");
            }
        } else {
            Map<View, FriendlyObstructionPurpose> friendlyViews = getFriendlyViews();
            if (friendlyViews != null && (keySet = friendlyViews.keySet()) != null) {
                set = CollectionsKt.toMutableSet(keySet);
            }
            gestureDetectorOnGestureListenerC2634ec = this;
            gestureDetectorOnGestureListenerC2634ec.G0 = new I(gestureDetectorOnGestureListenerC2634ec, set, getAdConfig().getMraid3().getExposureChangeInterval(), this.s0, this.i);
        }
        I i = gestureDetectorOnGestureListenerC2634ec.G0;
        if (i != null) {
            if (i.j.compareAndSet(false, true)) {
                Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(C2.a(new F(i)));
                if (m10244exceptionOrNullimpl != null) {
                    InterfaceC2971z5 interfaceC2971z55 = i.e;
                    if (interfaceC2971z55 != null) {
                        ((A5) interfaceC2971z55).b("AdExposureTracker", "Error starting exposure tracking - " + m10244exceptionOrNullimpl.getMessage());
                    }
                    i.j.set(false);
                    S5 s5 = S5.f2425a;
                    C2640f2 event = new C2640f2(m10244exceptionOrNullimpl);
                    Intrinsics.checkNotNullParameter(event, "event");
                    S5.d.a(event);
                }
            } else {
                InterfaceC2971z5 interfaceC2971z56 = i.e;
                if (interfaceC2971z56 != null) {
                    ((A5) interfaceC2971z56).c("AdExposureTracker", "Exposure tracking is already started");
                }
            }
        }
        InterfaceC2971z5 interfaceC2971z57 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z57 != null) {
            String str4 = a1;
            ((A5) interfaceC2971z57).a(str4, Ob.a(this, str4, "TAG", "startTrackingAudioVolume "));
        }
        if (n() && !gestureDetectorOnGestureListenerC2634ec.e) {
            C2849s c2849s = C2849s.f2699a;
            C2849s.a(gestureDetectorOnGestureListenerC2634ec.i, gestureDetectorOnGestureListenerC2634ec.r0);
        }
        InterfaceC2971z5 interfaceC2971z58 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z58 != null) {
            String TAG2 = a1;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z58).a(TAG2, "==== CHECKPOINT REACHED - VISIBLE ====");
        }
        InterfaceC2971z5 interfaceC2971z59 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z59 != null) {
            ((A5) interfaceC2971z59).b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "onDetachedFromWindow "));
        }
        C2592c4 c2592c4 = this.z0;
        C2786o0 c2786o0 = null;
        if (c2592c4 != null) {
            C2592c4.a(c2592c4, 8, true, null, 12);
        }
        F7 f7 = this.v;
        if (f7 != null) {
            C2857s7 c2857s7 = f7.d;
            if (c2857s7 != null) {
                c2857s7.a();
            }
            C2857s7 c2857s72 = f7.e;
            if (c2857s72 != null) {
                c2857s72.a();
            }
            C2857s7 c2857s73 = f7.f;
            if (c2857s73 != null) {
                c2857s73.a();
            }
        }
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z52).a(TAG, "Detached from window");
        }
        C2786o0 c2786o02 = this.D0;
        if (c2786o02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adQualityManager");
        } else {
            c2786o0 = c2786o02;
        }
        if (c2786o0.d.get()) {
            c2786o0.a("session end is already triggered");
        } else if (!c2786o0.f2655a.getEnabled()) {
            c2786o0.a("config kill switch - false. ad quality will skip");
        } else if (c2786o0.g == null) {
            c2786o0.a("setup not done. ignore trigger");
        } else {
            c2786o0.d.set(true);
            c2786o0.a(false);
        }
        if (this.E0.get()) {
            ((ScheduledThreadPoolExecutor) AbstractC2970z4.b.getValue()).schedule(new Runnable() { // from class: com.inmobi.media.ec$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    GestureDetectorOnGestureListenerC2634ec.a(GestureDetectorOnGestureListenerC2634ec.this);
                }
            }, 1L, TimeUnit.SECONDS);
        }
        y();
        x();
        InterfaceC2971z5 interfaceC2971z53 = this.i;
        if (interfaceC2971z53 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z53).a(str2, Ob.a(this, str2, "TAG", "stopTrackingAudioVolume "));
        }
        C2849s c2849s = C2849s.f2699a;
        C2849s.c(this.i, this.r0);
        try {
            super.onDetachedFromWindow();
        } catch (IllegalArgumentException e) {
            InterfaceC2971z5 interfaceC2971z54 = this.i;
            if (interfaceC2971z54 != null) {
                String str3 = a1;
                ((A5) interfaceC2971z54).b(str3, H6.a(str3, "TAG", "Detaching WebView from window encountered an error ( ").append(e.getMessage()).append(" )").toString());
            }
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.e || !getRenderingConfig().getSupportedGestures().contains(1)) {
            InterfaceC2971z5 interfaceC2971z5 = this.i;
            if (interfaceC2971z5 != null) {
                String TAG = a1;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).c(TAG, "Double tap gesture is disabled from config");
            }
            return false;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String TAG2 = a1;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).a(TAG2, "onDoubleTapEvent detected \n " + e);
        }
        setViewTouchTimestamp(SystemClock.elapsedRealtime());
        if (e.getAction() == 1) {
            JSONArray jSONArray = new JSONArray();
            try {
                jSONArray.put(B2.c(e.getX()));
                jSONArray.put(B2.c(e.getY()));
            } catch (JSONException e2) {
                InterfaceC2971z5 interfaceC2971z53 = this.i;
                if (interfaceC2971z53 != null) {
                    String TAG3 = a1;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    ((A5) interfaceC2971z53).a(TAG3, "Exception in onDoubleTap", e2);
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONArray);
            c("window.imraidview.onGestureDetected('1', '" + jSONArray2 + "');");
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent e2, float f, float f2) {
        Intrinsics.checkNotNullParameter(e2, "e2");
        if (this.e || !getRenderingConfig().getSupportedGestures().contains(6)) {
            InterfaceC2971z5 interfaceC2971z5 = this.i;
            if (interfaceC2971z5 != null) {
                String TAG = a1;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).c(TAG, "fling gesture is disabled from config");
            }
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(motionEvent == null ? new JSONArray() : new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(B2.c(motionEvent.getX())), Integer.valueOf(B2.c(motionEvent.getY()))})));
            jSONArray.put(new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(B2.c(e2.getX())), Integer.valueOf(B2.c(e2.getY()))})));
            jSONArray.put(new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(f), Float.valueOf(f2)})));
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z52 = this.i;
            if (interfaceC2971z52 != null) {
                String TAG2 = a1;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).a(TAG2, "Exception in onFling", e);
            }
        }
        c("window.imraidview.onGestureDetected('6', '" + jSONArray + "');");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.e || !getRenderingConfig().getSupportedGestures().contains(5)) {
            InterfaceC2971z5 interfaceC2971z5 = this.i;
            if (interfaceC2971z5 != null) {
                String TAG = a1;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).c(TAG, "LongPress gesture is disabled from config");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String TAG2 = a1;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).a(TAG2, "onLongPress detected \n " + e);
        }
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(B2.c(e.getX()));
            jSONArray.put(B2.c(e.getY()));
        } catch (JSONException e2) {
            InterfaceC2971z5 interfaceC2971z53 = this.i;
            if (interfaceC2971z53 != null) {
                String TAG3 = a1;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                ((A5) interfaceC2971z53).a(TAG3, "Exception in onLongPress", e2);
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONArray);
        c("window.imraidview.onGestureDetected('5', '" + jSONArray2 + "');");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent e2, float f, float f2) {
        Intrinsics.checkNotNullParameter(e2, "e2");
        boolean z = this.e;
        if (z && !this.S) {
            this.S = true;
            SparseArray sparseArray = InMobiAdActivity.k;
            Y0.getClass();
            JSONObject jsonObject = Gb.a("IN_CUSTOM_BROWSER", "onScroll");
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = InMobiAdActivity.l;
            if (gestureDetectorOnGestureListenerC2634ec != null) {
                gestureDetectorOnGestureListenerC2634ec.a(jsonObject);
            }
        } else if (!z) {
            C2619de scrollThrottler = getScrollThrottler();
            scrollThrottler.getClass();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - scrollThrottler.b < scrollThrottler.f2551a) {
                scrollThrottler.b = elapsedRealtime;
            } else {
                scrollThrottler.b = elapsedRealtime;
                if (getRenderingConfig().getSupportedGestures().contains(8)) {
                    JSONArray jSONArray = new JSONArray();
                    try {
                        jSONArray.put(motionEvent == null ? new JSONArray() : new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(B2.c(motionEvent.getX())), Integer.valueOf(B2.c(motionEvent.getY()))})));
                        jSONArray.put(new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(B2.c(e2.getX())), Integer.valueOf(B2.c(e2.getY()))})));
                    } catch (Exception e) {
                        InterfaceC2971z5 interfaceC2971z5 = this.i;
                        if (interfaceC2971z5 != null) {
                            String TAG = a1;
                            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                            ((A5) interfaceC2971z5).a(TAG, "Exception in onScroll", e);
                        }
                    }
                    c("window.imraidview.onGestureDetected('8', '" + jSONArray + "');");
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.e || !getRenderingConfig().getSupportedGestures().contains(0)) {
            InterfaceC2971z5 interfaceC2971z5 = this.i;
            if (interfaceC2971z5 != null) {
                String TAG = a1;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).c(TAG, "Click gesture is disabled from config");
            }
            return false;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String TAG2 = a1;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).a(TAG2, "onSingleTapConfirmed detected \n " + e);
        }
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(B2.c(e.getX()));
            jSONArray.put(B2.c(e.getY()));
        } catch (JSONException e2) {
            InterfaceC2971z5 interfaceC2971z53 = this.i;
            if (interfaceC2971z53 != null) {
                String TAG3 = a1;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                ((A5) interfaceC2971z53).a(TAG3, "Exception in onSingleTapConfirmed", e2);
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONArray);
        c("window.imraidview.onGestureDetected('0', '" + jSONArray2 + "');");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "onSingleTapUp detected \n " + e);
        }
        setViewTouchTimestamp(SystemClock.elapsedRealtime());
        return false;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(this, str, "TAG", "onSizeChanged "));
        }
        super.onSizeChanged(i, i2, i3, i4);
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z52).a(TAG, "onSizeChanged (" + i + ", " + i2 + ')');
        }
        if (i == 0 || i2 == 0) {
            return;
        }
        int b = B2.b(i / U3.b());
        int b2 = B2.b(i2 / U3.b());
        InterfaceC2971z5 interfaceC2971z53 = this.i;
        if (interfaceC2971z53 != null) {
            String TAG2 = a1;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z53).a(TAG2, "fireSizeChanged " + this + " w-" + b + " h-" + b2);
        }
        c("window.mraidview.broadcastEvent('sizeChange'," + b + AbstractJsonLexerKt.COMMA + b2 + ");");
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Float.isNaN(event.getX()) || Float.isNaN(event.getY())) {
            if (!this.F0) {
                InterfaceC2971z5 interfaceC2971z5 = this.i;
                if (interfaceC2971z5 != null) {
                    String TAG = a1;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).b(TAG, "onTouchEvent Invalid Coordinates " + event);
                }
                this.F0 = true;
            }
            return super.onTouchEvent(event);
        }
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String str = a1;
            ((A5) interfaceC2971z52).a(str, Ob.a(this, str, "TAG", "onTouchEvent "));
        }
        if (this.e && !this.R) {
            this.R = true;
            SparseArray sparseArray = InMobiAdActivity.k;
            Y0.getClass();
            JSONObject jsonObject = Gb.a("IN_CUSTOM_BROWSER", "onInteraction");
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = InMobiAdActivity.l;
            if (gestureDetectorOnGestureListenerC2634ec != null) {
                gestureDetectorOnGestureListenerC2634ec.a(jsonObject);
            }
        }
        if (this.b == 1) {
            this.v0.a(event);
        }
        this.w0.onTouchEvent(event);
        setViewTouchTimestamp(SystemClock.elapsedRealtime());
        return super.onTouchEvent(event);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "onWindowFocusChanged " + this + " - " + z);
        }
        super.onWindowFocusChanged(z);
        if (z) {
            if (isShown()) {
                P4 p4 = S4.k;
                if (p4.a(this, this, this.u0, null) && p4.a(this, this, this.u0)) {
                    z = true;
                }
            }
            z = false;
        }
        Activity fullScreenActivity = getFullScreenActivity();
        if (fullScreenActivity == null || !fullScreenActivity.isInMultiWindowMode()) {
            c(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004c, code lost:
    
        if (r2.a(r4, r4, r5) != false) goto L19;
     */
    @Override // android.webkit.WebView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onWindowVisibilityChanged(int i) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onWindowVisibilityChanged " + this + ' ' + i);
        }
        super.onWindowVisibilityChanged(i);
        boolean z = true;
        boolean z2 = i == 0;
        if (z2) {
            int visibilityTrackingMinPercentage = getVisibilityTrackingMinPercentage();
            if (isShown()) {
                P4 p4 = S4.k;
                if (p4.a(this, this, visibilityTrackingMinPercentage, null)) {
                }
            }
            z = false;
        } else {
            z = z2;
        }
        c(z);
    }

    public final void p() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "onUserLandingCompleted "));
        }
        c("window.imraid.broadcastEvent('onUserLandingCompleted');");
    }

    public final void q() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "processUnload "));
        }
        if (this.J.get()) {
            InterfaceC2971z5 interfaceC2971z52 = this.i;
            if (interfaceC2971z52 != null) {
                String TAG = a1;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z52).b(TAG, "unload called on destroyed view");
                return;
            }
            return;
        }
        if (!n()) {
            InterfaceC2971z5 interfaceC2971z53 = this.i;
            if (interfaceC2971z53 != null) {
                String TAG2 = a1;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z53).b(TAG2, "mraid 3.0 is not enabled");
                return;
            }
            return;
        }
        if (this.y0) {
            InterfaceC2971z5 interfaceC2971z54 = this.i;
            if (interfaceC2971z54 != null) {
                String TAG3 = a1;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                ((A5) interfaceC2971z54).b(TAG3, "unload called on failed view");
                return;
            }
            return;
        }
        if (this.K0) {
            return;
        }
        this.K0 = true;
        ExecutorC2793o7 executorC2793o7 = (ExecutorC2793o7) AbstractC2970z4.d.getValue();
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.ec$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                GestureDetectorOnGestureListenerC2634ec.b(GestureDetectorOnGestureListenerC2634ec.this);
            }
        };
        executorC2793o7.getClass();
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        executorC2793o7.f2659a.post(runnable);
    }

    public final void r() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(this, str, "TAG", "setCurrentPosition "));
        }
        this.A = new JSONObject();
        getLocationOnScreen(new int[2]);
        try {
            JSONObject jSONObject = this.A;
            if (jSONObject != null) {
                jSONObject.put(VastAttributes.HORIZONTAL_POSITION, B2.b(r0[0] / U3.b()));
            }
            JSONObject jSONObject2 = this.A;
            if (jSONObject2 != null) {
                jSONObject2.put(VastAttributes.VERTICAL_POSITION, B2.b(r0[1] / U3.b()));
            }
            int b = B2.b(getWidth() / U3.b());
            int b2 = B2.b(getHeight() / U3.b());
            JSONObject jSONObject3 = this.A;
            if (jSONObject3 != null) {
                jSONObject3.put("width", b);
            }
            JSONObject jSONObject4 = this.A;
            if (jSONObject4 != null) {
                jSONObject4.put("height", b2);
            }
        } catch (JSONException unused) {
        }
        synchronized (this.L) {
            this.C = false;
            this.L.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void s() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(this, str, "TAG", "setDefaultPosition "));
        }
        int[] iArr = new int[2];
        this.z = new JSONObject();
        if (this.r == null) {
            ViewParent parent = getParent();
            this.r = new WeakReference(parent instanceof ViewGroup ? (ViewGroup) parent : null);
        }
        WeakReference weakReference = this.r;
        try {
            if ((weakReference != null ? (ViewGroup) weakReference.get() : null) != null) {
                WeakReference weakReference2 = this.r;
                if (weakReference2 != null && (viewGroup3 = (ViewGroup) weakReference2.get()) != null) {
                    viewGroup3.getLocationOnScreen(iArr);
                }
                JSONObject jSONObject = this.z;
                if (jSONObject != null) {
                    jSONObject.put(VastAttributes.HORIZONTAL_POSITION, B2.b(iArr[0] / U3.b()));
                }
                JSONObject jSONObject2 = this.z;
                if (jSONObject2 != null) {
                    jSONObject2.put(VastAttributes.VERTICAL_POSITION, B2.b(iArr[1] / U3.b()));
                }
                WeakReference weakReference3 = this.r;
                int b = B2.b(((weakReference3 == null || (viewGroup2 = (ViewGroup) weakReference3.get()) == null) ? 0 : viewGroup2.getWidth()) / U3.b());
                WeakReference weakReference4 = this.r;
                int b2 = B2.b(((weakReference4 == null || (viewGroup = (ViewGroup) weakReference4.get()) == null) ? 0 : viewGroup.getHeight()) / U3.b());
                JSONObject jSONObject3 = this.z;
                if (jSONObject3 != null) {
                    jSONObject3.put("width", b);
                }
                JSONObject jSONObject4 = this.z;
                if (jSONObject4 != null) {
                    jSONObject4.put("height", b2);
                }
            } else {
                JSONObject jSONObject5 = this.z;
                if (jSONObject5 != null) {
                    jSONObject5.put(VastAttributes.HORIZONTAL_POSITION, 0);
                }
                JSONObject jSONObject6 = this.z;
                if (jSONObject6 != null) {
                    jSONObject6.put(VastAttributes.VERTICAL_POSITION, 0);
                }
                JSONObject jSONObject7 = this.z;
                if (jSONObject7 != null) {
                    jSONObject7.put("width", 0);
                }
                JSONObject jSONObject8 = this.z;
                if (jSONObject8 != null) {
                    jSONObject8.put("height", 0);
                }
            }
        } catch (JSONException unused) {
        }
        synchronized (this.K) {
            this.B = false;
            this.K.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setAdPodHandler(InterfaceC2553a0 interfaceC2553a0) {
        this.j0 = interfaceC2553a0;
    }

    public void setAdType(String str) {
        this.d0 = str;
    }

    public final void setAllowAutoRedirection(boolean z) {
        this.i0 = z;
    }

    public final void setAndUpdateViewState(String state) {
        Intrinsics.checkNotNullParameter(state, "state");
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(this, str, "TAG", "setAndUpdateViewState "));
        }
        this.u = state;
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z52).a(str2, H6.a(str2, "TAG", "set state:").append(this.u).toString());
        }
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String lowerCase = state.toLowerCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        InterfaceC2971z5 interfaceC2971z53 = this.i;
        if (interfaceC2971z53 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z53).a(TAG, "fireStateChange " + this + ' ' + lowerCase);
        }
        c("window.mraidview.broadcastEvent('stateChange','" + lowerCase + "');");
    }

    public final void setBackButtonDisabled(boolean z) {
        this.H = z;
    }

    public final void setBeaconUrl(String str) {
        this.H0 = str;
    }

    public final void setBlobProvider(InterfaceC2573b2 interfaceC2573b2) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(this, str, "TAG", "setBlobProvider "));
        }
        this.f0 = interfaceC2573b2;
    }

    public final void setCloseAssetArea(Bf value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!this.S0) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (!B2.a(context)) {
                return;
            }
        }
        this.X0 = new Bf(0, value.b, value.c, 0);
    }

    public final void setCloseEndCardTracker(String url) {
        Ve d;
        Le le;
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "setCloseEndCardTracker "));
        }
        InterfaceC2930x referenceContainer = getReferenceContainer();
        if (!(referenceContainer instanceof C2562a9) || url == null) {
            return;
        }
        C2562a9 c2562a9 = (C2562a9) referenceContainer;
        c2562a9.getClass();
        Intrinsics.checkNotNullParameter(url, "url");
        InterfaceC2971z5 interfaceC2971z52 = c2562a9.W;
        if (interfaceC2971z52 != null) {
            String str2 = c2562a9.X;
            ((A5) interfaceC2971z52).c(str2, I6.a(str2, "TAG", "Setting close end tracker with URL : ", url));
        }
        View videoContainerView = c2562a9.getVideoContainerView();
        if (videoContainerView instanceof C2763m9) {
            Object tag = ((C2763m9) videoContainerView).getVideoView().getTag();
            C2597c9 c2597c9 = tag instanceof C2597c9 ? (C2597c9) tag : null;
            if (c2597c9 == null || (d = c2597c9.d()) == null || (le = ((Ue) d).j) == null) {
                return;
            }
            U8 tracker = new U8(url, 0, "closeEndCard", null);
            Intrinsics.checkNotNullParameter(tracker, "tracker");
            le.f.add(tracker);
        }
    }

    public final void setConfiguredArea(long j) {
        this.p0 = getWidth() * getHeight();
    }

    public final void setContentURL(String str) {
        this.n0 = str;
    }

    public final void setContextualDataHandler(C2625e3 c2625e3) {
        this.T0 = c2625e3;
    }

    public void setCreativeId(String str) {
        this.U = str;
    }

    public final void setDisableBackButton(boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "setDisableBackButton "));
        }
        this.H = z;
    }

    public final void setEmbeddedBrowserJsCallbacks(InterfaceC2557a4 interfaceC2557a4) {
        this.A0 = interfaceC2557a4;
    }

    public void setExitAnimation(int i) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(this, str, "TAG", "setExitAnimation "));
        }
        this.Q = i;
    }

    public final void setExposureTracker(I i) {
        this.G0 = i;
    }

    public void setFriendlyViews(Map<View, FriendlyObstructionPurpose> map) {
        this.e0 = map;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public void setFullScreenActivityContext(Activity activity) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "setFullScreenActivityContext "));
        }
        this.q = new WeakReference(activity);
        A();
        if (this.e || activity == null) {
            return;
        }
        Df df = this.J0;
        if (df != null) {
            df.a();
        }
        this.J0 = new Df(activity, this.N0, this.i);
    }

    public final void setImmersiveMode(boolean z) {
        this.S0 = z;
    }

    public void setImpressionId(String str) {
        this.d = str;
    }

    public final void setLandingPageTelemetryControlInfoOnWebViewClient(R6 r6) {
        C2592c4 c2592c4 = this.z0;
        if (c2592c4 == null) {
            return;
        }
        c2592c4.j = r6;
        c2592c4.k = new O6(r6, c2592c4);
    }

    public final void setLandingScheme(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f = str;
    }

    public final void setMAdConfig(AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(adConfig, "<set-?>");
        this.w = adConfig;
    }

    public final void setMCreativeType(String str) {
        this.B0 = str;
    }

    public final void setMImpressionMinPercentageViewed(int i) {
        this.u0 = i;
    }

    public final void setMImpressionMinTimeViewed(int i) {
        this.t0 = i;
    }

    public final void setMViewableAd(Xe xe) {
        this.k0 = xe;
    }

    public final void setMarkupTypeAdUnit(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.O0 = str;
    }

    public final void setOrientationProperties(C2844ra c2844ra) {
        Intrinsics.checkNotNullParameter(c2844ra, "<set-?>");
        this.C0 = c2844ra;
    }

    public final void setPingAckListener(Ha pingAckListener) {
        Intrinsics.checkNotNullParameter(pingAckListener, "pingAckListener");
        this.m = pingAckListener;
    }

    public final void setPingManager(Ia pingManager) {
        Intrinsics.checkNotNullParameter(pingManager, "pingManager");
        this.b0 = pingManager;
    }

    public final void setPlacementId(long j) {
        this.T = j;
    }

    public final void setPreloadView(boolean z) {
        this.h0 = z;
    }

    public void setReferenceContainer(InterfaceC2930x interfaceC2930x) {
        this.g0 = interfaceC2930x;
    }

    public final void setRenderViewEventListener(AbstractC2669gc abstractC2669gc) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(this, str, "TAG", "setRenderViewEventListener "));
        }
        this.s = abstractC2669gc;
    }

    public final void setRenderViewTelemetry(C2782nc c2782nc) {
        this.W = c2782nc;
    }

    public final void setScrollable(boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(this, str, "TAG", "setScrollable "));
        }
        setScrollContainer(z);
        setVerticalScrollBarEnabled(z);
        setHorizontalScrollBarEnabled(z);
    }

    public final void setShouldFireLandingPageBeacons(boolean z) {
        this.I0 = z;
    }

    public void setTelemetryManagerMap(Map<String, U0> map) {
        this.L0 = map;
    }

    public final void setUnloaded(boolean z) {
        this.K0 = z;
    }

    public final void setUseCustomClose(boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "setUseCustomClose " + this + ' ' + z);
        }
        this.D = z;
    }

    public void setViewTouchTimestamp(long j) {
        this.g = j;
    }

    public final void setWatermark(final WatermarkData watermarkData) {
        Intrinsics.checkNotNullParameter(watermarkData, "watermarkData");
        if (getAdConfig().getWatermarkEnabled()) {
            final byte[] decode = Base64.decode(watermarkData.getWatermarkBase64EncodedString(), 0);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.inmobi.media.ec$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    GestureDetectorOnGestureListenerC2634ec.a(GestureDetectorOnGestureListenerC2634ec.this, decode, watermarkData);
                }
            });
        } else {
            InterfaceC2971z5 interfaceC2971z5 = this.i;
            if (interfaceC2971z5 != null) {
                String TAG = a1;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).c(TAG, "Watermark disabled from config. ignoring...");
            }
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "stopLoading "));
        }
        if (this.J.get()) {
            return;
        }
        super.stopLoading();
    }

    public final void t() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "setFallbackImpressionMinPercentageViewed "));
        }
        this.u0 = Intrinsics.areEqual("video", this.B0) ? getMAdConfig().getViewability().getVideoImpressionMinPercentageViewed() : Intrinsics.areEqual("audio", this.B0) ? Intrinsics.areEqual("audio", getAdType()) ? getMAdConfig().getViewability().getAudioImpressionMinPercentageViewed() : getMAdConfig().getViewability().getWebImpressionMinPercentageViewed() : getMAdConfig().getViewability().getWebImpressionMinPercentageViewed();
    }

    public final void u() {
        this.t0 = Intrinsics.areEqual("video", this.B0) ? getMAdConfig().getViewability().getVideoImpressionMinTimeViewed() : Intrinsics.areEqual("audio", this.B0) ? Intrinsics.areEqual("audio", getAdType()) ? getMAdConfig().getViewability().getAudioImpressionMinTimeViewed() : getMAdConfig().getViewability().getWebImpressionMinTimeViewed() : getMAdConfig().getViewability().getWebImpressionMinTimeViewed();
    }

    public final void v() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "setFallbackImpressionParams "));
        }
        u();
        t();
        w();
    }

    public final void w() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "setFallbackImpressionType "));
        }
        String adType = getAdType();
        this.n = Intrinsics.areEqual(adType, "banner") ? getMAdConfig().getViewability().getBannerImpressionType() : Intrinsics.areEqual(adType, "audio") ? getMAdConfig().getViewability().getAudioImpressionType() : getMAdConfig().getViewability().getInterstitialImpressionType();
    }

    public final void x() {
        InterfaceC2971z5 interfaceC2971z5;
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String str = a1;
            ((A5) interfaceC2971z52).a(str, Ob.a(this, str, "TAG", "stopTrackingExposure "));
        }
        I i = this.G0;
        if (i != null) {
            if (!i.j.compareAndSet(true, false)) {
                InterfaceC2971z5 interfaceC2971z53 = i.e;
                if (interfaceC2971z53 != null) {
                    ((A5) interfaceC2971z53).c("AdExposureTracker", "Exposure tracking is already stopped");
                    return;
                }
                return;
            }
            Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(C2.a(new G(i)));
            if (m10244exceptionOrNullimpl == null || (interfaceC2971z5 = i.e) == null) {
                return;
            }
            ((A5) interfaceC2971z5).b("AdExposureTracker", "Error stopping exposure tracking - " + m10244exceptionOrNullimpl.getMessage());
        }
    }

    public final void y() {
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec;
        Lazy lazy = AbstractC2815pc.f2672a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (Intrinsics.areEqual(getRoute().b, EventTaskParams.STATE_GROUP_DEFAULT)) {
            gestureDetectorOnGestureListenerC2634ec = this;
        } else {
            tf webViewFactory = getWebViewFactory();
            webViewFactory.getClass();
            Intrinsics.checkNotNullParameter(EventTaskParams.STATE_GROUP_DEFAULT, "id");
            gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) webViewFactory.b.get(EventTaskParams.STATE_GROUP_DEFAULT);
        }
        if (gestureDetectorOnGestureListenerC2634ec != null) {
            new A2(gestureDetectorOnGestureListenerC2634ec, !this.D, !this.G, this.i).a(this.X0);
        }
    }

    public final void z() {
        getListener().d(this);
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "ad dismissed");
        }
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).a();
        }
        C2786o0 c2786o0 = this.D0;
        if (c2786o0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adQualityManager");
            c2786o0 = null;
        }
        if (c2786o0.d.get()) {
            c2786o0.a("session end is already triggered");
            return;
        }
        if (!c2786o0.f2655a.getEnabled()) {
            c2786o0.a("config kill switch - false. ad quality will skip");
        } else if (c2786o0.g == null) {
            c2786o0.a("setup not done. ignore trigger");
        } else {
            c2786o0.d.set(true);
            c2786o0.a(false);
        }
    }

    public final void a(String url, String templateInfoStr, boolean z) {
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec;
        Exception exc;
        Activity activity;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(templateInfoStr, "templateInfoStr");
        try {
            JSONObject jSONObject = new JSONObject(templateInfoStr);
            InterfaceC2971z5 interfaceC2971z5 = this.i;
            if (interfaceC2971z5 != null) {
                try {
                    String TAG = a1;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).a(TAG, "report - " + getAdType() + " type - sdk - " + Build.VERSION.SDK_INT);
                } catch (Exception e) {
                    exc = e;
                    gestureDetectorOnGestureListenerC2634ec = this;
                }
            }
            if (Intrinsics.areEqual(getAdType(), "int") && Build.VERSION.SDK_INT >= 29 && (activity = (Activity) this.q.get()) != null) {
                ScheduledExecutorService scheduledExecutorService = C2638f0.f2564a;
                try {
                    C2638f0.a(activity, this, url, z, jSONObject, this.M0);
                    return;
                } catch (Exception e2) {
                    e = e2;
                    gestureDetectorOnGestureListenerC2634ec = this;
                }
            } else {
                gestureDetectorOnGestureListenerC2634ec = this;
                try {
                    ScheduledExecutorService scheduledExecutorService2 = C2638f0.f2564a;
                    C2638f0.a(gestureDetectorOnGestureListenerC2634ec, this, url, z, jSONObject, gestureDetectorOnGestureListenerC2634ec.M0);
                    return;
                } catch (Exception e3) {
                    e = e3;
                }
            }
        } catch (Exception e4) {
            e = e4;
            gestureDetectorOnGestureListenerC2634ec = this;
        }
        exc = e;
        InterfaceC2971z5 interfaceC2971z52 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z52 != null) {
            String TAG2 = a1;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).a(TAG2, "issue wile reporting ad", exc);
        }
    }

    public static final void a(GestureDetectorOnGestureListenerC2634ec this$0) {
        InterfaceC2971z5 interfaceC2971z5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAttachedToWindow() || (interfaceC2971z5 = this$0.i) == null) {
            return;
        }
        ((A5) interfaceC2971z5).a();
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0372  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(AbstractC2669gc abstractC2669gc, AdConfig adConfig) {
        int audioNetworkLoadsLimit;
        WebViewClient webViewClient;
        boolean z;
        Q q;
        Q q2;
        WatermarkData watermarkData;
        AdQualityControl adQualityControl;
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(this, str, "TAG", "initialize "));
        }
        if (Intrinsics.areEqual(this.O0, "htmlUrl")) {
            getSettings().setMixedContentMode(2);
        }
        setMAdConfig(adConfig);
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z52).a(str2, Ob.a(this, str2, "TAG", "setImpressionParams "));
        }
        if (this.c == null) {
            v();
        } else {
            try {
                v();
                for (C2833qe c2833qe : this.c) {
                    if (c2833qe.f2687a == 2) {
                        if (c2833qe.b.containsKey("type")) {
                            Object obj = c2833qe.b.get("type");
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                            this.n = (byte) ((Integer) obj).intValue();
                        } else {
                            w();
                        }
                        if (c2833qe.b.containsKey("time")) {
                            Object obj2 = c2833qe.b.get("time");
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                            this.t0 = ((Integer) obj2).intValue();
                        } else {
                            u();
                        }
                        if (c2833qe.b.containsKey(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW)) {
                            Object obj3 = c2833qe.b.get(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                            this.u0 = ((Integer) obj3).intValue();
                        } else {
                            t();
                        }
                        if (this.n == 2) {
                            if (c2833qe.b.containsKey("pixel")) {
                                Object obj4 = c2833qe.b.get("pixel");
                                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
                                this.q0 = ((Integer) obj4).intValue();
                            } else {
                                w();
                            }
                            if (c2833qe.b.containsKey("frame")) {
                                Object obj5 = c2833qe.b.get("frame");
                                JSONArray jSONArray = obj5 instanceof JSONArray ? (JSONArray) obj5 : null;
                                if (jSONArray != null) {
                                    this.o0 = new int[jSONArray.length()];
                                    int length = jSONArray.length();
                                    for (int i = 0; i < length; i++) {
                                        int[] iArr = this.o0;
                                        if (iArr != null) {
                                            Object obj6 = jSONArray.get(i);
                                            Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Int");
                                            iArr[i] = ((Integer) obj6).intValue();
                                        }
                                    }
                                }
                            } else {
                                w();
                            }
                        }
                    }
                }
            } catch (JSONException unused) {
                InterfaceC2971z5 interfaceC2971z53 = this.i;
                if (interfaceC2971z53 != null) {
                    String TAG = a1;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z53).b(TAG, "Exception in parsing the impressionType and pixel frame");
                }
                v();
            } catch (Exception unused2) {
                InterfaceC2971z5 interfaceC2971z54 = this.i;
                if (interfaceC2971z54 != null) {
                    String TAG2 = a1;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((A5) interfaceC2971z54).b(TAG2, "SDK encountered an unexpected error in parsing impression parameters");
                }
                v();
            }
        }
        this.s = abstractC2669gc;
        ViewParent parent = getParent();
        this.r = new WeakReference(parent instanceof ViewGroup ? (ViewGroup) parent : null);
        setBackgroundColor(getRenderingConfig().getWebviewBackgroundColor());
        new A7(getMraidConfig().getUrl(), getMraidConfig().getMaxRetries(), getMraidConfig().getRetryInterval(), getMraidConfig().getExpiry(), this.i).a();
        setImportantForAccessibility(2);
        setScrollable(false);
        int i2 = Build.VERSION.SDK_INT;
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(getAdConfig().getRendering().getEnableDomStorage());
        getSettings().setGeolocationEnabled(true);
        if (this.e) {
            InterfaceC2971z5 interfaceC2971z55 = this.i;
            if (interfaceC2971z55 != null) {
                String TAG3 = a1;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                ((A5) interfaceC2971z55).c(TAG3, "view is in-app browser. Using EmbeddedBrowserViewClient.");
            }
            C2592c4 c2592c4 = new C2592c4("IN_CUSTOM_BROWSER", Kb.f2342a, Lb.f2353a, Mb.f2363a, this.i);
            this.z0 = c2592c4;
            webViewClient = c2592c4;
        } else {
            InterfaceC2971z5 interfaceC2971z56 = this.i;
            if (interfaceC2971z56 != null) {
                String TAG4 = a1;
                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                ((A5) interfaceC2971z56).c(TAG4, "view is ad. Using RenderViewClient");
            }
            C2652fc c2652fc = new C2652fc(this.W, this.i, new Nb(this));
            String adType = getAdType();
            if (Intrinsics.areEqual(adType, "banner")) {
                audioNetworkLoadsLimit = getMAdConfig().getRendering().getBannerNetworkLoadsLimit();
            } else {
                audioNetworkLoadsLimit = Intrinsics.areEqual(adType, "audio") ? getMAdConfig().getRendering().getAudioNetworkLoadsLimit() : getMAdConfig().getRendering().getOtherNetworkLoadsLimit();
            }
            c2652fc.b = audioNetworkLoadsLimit;
            webViewClient = c2652fc;
        }
        setWebViewClient(webViewClient);
        if (this.e && getAdConfig().getEnableCookiesOnInAppBrowser()) {
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setAcceptThirdPartyCookies(this, true);
        }
        setWebChromeClient(this.V0);
        if (!this.e) {
            C2905v6 c2905v6 = new C2905v6(this.b, this);
            InterfaceC2971z5 logger = this.i;
            if (logger != null) {
                Intrinsics.checkNotNullParameter(logger, "logger");
                c2905v6.c = logger;
            }
            addJavascriptInterface(c2905v6, "sdkController");
        }
        this.v = new F7(this, this.i);
        this.D0 = new C2786o0(adConfig.getAdQuality(), this.i);
        if (i2 >= 29) {
            setWebViewRenderProcessClient((ScheduledThreadPoolExecutor) AbstractC2970z4.b.getValue(), new C2718jc(this.i, this.W));
        }
        Q q3 = this.l;
        if (q3 != null && (adQualityControl = q3.n) != null) {
            C2786o0 c2786o0 = this.D0;
            if (c2786o0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityManager");
                c2786o0 = null;
            }
            c2786o0.getClass();
            Intrinsics.checkNotNullParameter(adQualityControl, "adQualityControl");
            c2786o0.a("adQuality session setup");
            if (!c2786o0.f2655a.getEnabled()) {
                c2786o0.a("config kill switch - false. ad quality will skip");
            } else if (c2786o0.c.get()) {
                c2786o0.a("session already started. skip");
            } else {
                c2786o0.a("verifying control flags");
                String beacon = adQualityControl.getBeacon();
                if (beacon != null && beacon.length() == 0) {
                    c2786o0.a("no beacon received. aborting...");
                    ScheduledExecutorService scheduledExecutorService = C2638f0.f2564a;
                    if (scheduledExecutorService != null) {
                        scheduledExecutorService.shutdown();
                        try {
                            try {
                                scheduledExecutorService.shutdownNow();
                            } catch (Exception e) {
                                Intrinsics.checkNotNullParameter("AdQualityComponent", "tag");
                                Intrinsics.checkNotNullParameter("shutdown fail", PglCryptUtils.KEY_MESSAGE);
                                Log.e("AdQualityComponent", "shutdown fail", e);
                                Thread.currentThread().interrupt();
                                c2786o0.a("session end - cleanup");
                                c2786o0.g = null;
                                c2786o0.f.clear();
                                z = false;
                                c2786o0.c.set(false);
                                c2786o0.d.set(false);
                                c2786o0.a("ad quality session is already in progress. skipping...");
                                q = this.l;
                                if (q != null) {
                                }
                                q2 = this.l;
                                if (q2 == null ? Intrinsics.areEqual(q2.l, Boolean.TRUE) : z) {
                                }
                            }
                        } catch (InterruptedException unused3) {
                            scheduledExecutorService.shutdownNow();
                            Thread.currentThread().interrupt();
                            c2786o0.a("session end - cleanup");
                            c2786o0.g = null;
                            c2786o0.f.clear();
                            z = false;
                            c2786o0.c.set(false);
                            c2786o0.d.set(false);
                            c2786o0.a("ad quality session is already in progress. skipping...");
                            q = this.l;
                            if (q != null) {
                            }
                            q2 = this.l;
                            if (q2 == null ? Intrinsics.areEqual(q2.l, Boolean.TRUE) : z) {
                            }
                        }
                    }
                    c2786o0.a("session end - cleanup");
                    c2786o0.g = null;
                    c2786o0.f.clear();
                    z = false;
                    c2786o0.c.set(false);
                    c2786o0.d.set(false);
                    c2786o0.a("ad quality session is already in progress. skipping...");
                } else {
                    z = false;
                    c2786o0.g = adQualityControl;
                }
                q = this.l;
                if (q != null && (watermarkData = q.m) != null) {
                    setWatermark(watermarkData);
                }
                q2 = this.l;
                if (q2 == null ? Intrinsics.areEqual(q2.l, Boolean.TRUE) : z) {
                    return;
                }
                e();
                return;
            }
        }
        z = false;
        q = this.l;
        if (q != null) {
            setWatermark(watermarkData);
        }
        q2 = this.l;
        if (q2 == null ? Intrinsics.areEqual(q2.l, Boolean.TRUE) : z) {
        }
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public final boolean c() {
        return this.J.get();
    }

    public final void c(final String value) {
        Intrinsics.checkNotNullParameter(value, "js");
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "injectJavaScript " + this + " - " + value);
        }
        Intrinsics.checkNotNullParameter(value, "value");
        new Handler(getContainerContext().getMainLooper()).postAtFrontOfQueue(new Runnable() { // from class: com.inmobi.media.ec$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                GestureDetectorOnGestureListenerC2634ec.b(GestureDetectorOnGestureListenerC2634ec.this, value);
            }
        });
    }

    public static final void c(GestureDetectorOnGestureListenerC2634ec this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0.t) {
            if (Intrinsics.areEqual("Loading", this$0.u)) {
                InterfaceC2971z5 interfaceC2971z5 = this$0.i;
                if (interfaceC2971z5 != null) {
                    String TAG = a1;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).a(TAG, "updateWebViewLoaded " + this$0);
                }
                this$0.getListener().f(this$0);
                this$0.setAndUpdateViewState(Profile.DEFAULT_PROFILE_NAME);
                InterfaceC2971z5 interfaceC2971z52 = this$0.i;
                if (interfaceC2971z52 != null) {
                    String TAG2 = a1;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((A5) interfaceC2971z52).a(TAG2, "updateWebViewLoaded state changed to " + this$0.u);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
    
        if (r6.equals("html5video") == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00e0, code lost:
    
        if (r5.x == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00e4, code lost:
    
        if (r5.N == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00e6, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00e7, code lost:
    
        r6 = r5.i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00e9, code lost:
    
        if (r6 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00eb, code lost:
    
        r2 = com.inmobi.media.GestureDetectorOnGestureListenerC2634ec.a1;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "TAG");
        ((com.inmobi.media.A5) r6).c(r2, "HTML5 video supported:" + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0104, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00db, code lost:
    
        if (r6.equals(io.bidmachine.iab.mraid.MraidNativeFeature.FEATURE_INLINE_VIDEO) == false) goto L63;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x010e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "supports " + this + ' ' + str);
        }
        boolean z = false;
        if (str != null) {
            switch (str.hashCode()) {
                case -1886160473:
                    if (str.equals("playVideo")) {
                        return true;
                    }
                    break;
                case -1647691422:
                    break;
                case -988153970:
                    if (str.equals("pingV2")) {
                        AdConfig.PingsV2Config pingV2 = getAdConfig().getPingV2();
                        InterfaceC2971z5 interfaceC2971z52 = this.i;
                        if (interfaceC2971z52 != null) {
                            String str2 = a1;
                            ((A5) interfaceC2971z52).a(str2, H6.a(str2, "TAG", "supports(pingV2) ").append(pingV2.getEnabled()).toString());
                        }
                        return pingV2.getEnabled();
                    }
                    break;
                case -168584769:
                    if (str.equals("edge-to-edge")) {
                        if (getPlacementType() != 1) {
                            InterfaceC2971z5 interfaceC2971z53 = this.i;
                            if (interfaceC2971z53 != null) {
                                String TAG2 = a1;
                                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                                ((A5) interfaceC2971z53).b(TAG2, "EDGE_TO_EDGE is only supported for fullscreen ads. supports(edge-to-edge) = false");
                            }
                            return false;
                        }
                        if (this.S0) {
                            InterfaceC2971z5 interfaceC2971z54 = this.i;
                            if (interfaceC2971z54 != null) {
                                String TAG3 = a1;
                                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                                ((A5) interfaceC2971z54).b(TAG3, "Ad is in Immersive mode. supports(edge-to-edge) = false");
                            }
                            return false;
                        }
                        Context context = getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        return B2.a(context);
                    }
                    break;
                case 1137617595:
                    if (str.equals(C3040d4.h.v)) {
                        return this.S0;
                    }
                    break;
                case 1509574865:
                    break;
                case 1642189884:
                    if (!str.equals("saveContent")) {
                    }
                    break;
                case 1772979069:
                    str.equals("redirectFraudDetection");
                    break;
            }
        }
        return false;
    }

    public static final void b(GestureDetectorOnGestureListenerC2634ec this$0, String js) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(js, "$js");
        try {
            if (this$0.J.get()) {
                return;
            }
            String str = "javascript:try{" + js + "}catch(e){}";
            InterfaceC2971z5 interfaceC2971z5 = this$0.i;
            if (interfaceC2971z5 != null) {
                String TAG = a1;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).a(TAG, "Injecting javascript");
            }
            InterfaceC2971z5 interfaceC2971z52 = this$0.i;
            if (interfaceC2971z52 != null) {
                String TAG2 = a1;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).c(TAG2, "evaluateScript " + this$0);
            }
            this$0.evaluateJavascript(str, null);
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z53 = this$0.i;
            if (interfaceC2971z53 != null) {
                String str2 = a1;
                ((A5) interfaceC2971z53).b(str2, rf.a(e, H6.a(str2, "TAG", "SDK encountered an unexpected error injecting JavaScript in the Ad container; ")));
            }
        }
    }

    public final void d(boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "processDisableCloseRegionRequest " + this + ' ' + z);
        }
        this.G = z;
        y();
    }

    @Override // com.inmobi.media.InterfaceC2961yb
    public final boolean d() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "canRedirectExternally Called");
        }
        if (getRenderingConfig().getAutoRedirectionEnforcement()) {
            return getViewTouchTimestamp() != -1 && SystemClock.elapsedRealtime() - getViewTouchTimestamp() < getRenderingConfig().getUserTouchResetTime();
        }
        return true;
    }

    public final void e(boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "processUseCustomCloseRequest " + this + ' ' + z);
        }
        setUseCustomClose(z);
        y();
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public final void e() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(this, str, "TAG", "disableHardwareAcceleration called. "));
        }
        try {
            setLayerType(1, null);
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public final void a(byte b, Map map) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "fireEvent " + this + " 2");
        }
    }

    @Override // com.inmobi.media.InterfaceC2961yb
    public final void a(String mraidApi) {
        Intrinsics.checkNotNullParameter(mraidApi, "mraidApi");
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "sendFraudBeaconAndTelemetryEvent "));
        }
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z52).a(TAG, "fireDetectAutoRedirectFraud " + this + ' ' + mraidApi);
        }
        c("window.mraidview.fireRedirectFraudBeacon('" + mraidApi + "')");
        String adType = getAdType();
        if (adType == null) {
            adType = "banner";
        }
        InterfaceC2971z5 interfaceC2971z53 = this.i;
        if (interfaceC2971z53 != null) {
            String TAG2 = a1;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z53).c(TAG2, "sendTelemetryForAutoRedirectFraud " + this + ' ' + mraidApi + ' ' + adType);
        }
        HashMap hashMap = new HashMap();
        String creativeId = getCreativeId();
        if (creativeId != null) {
            hashMap.put("creativeId", creativeId);
        }
        hashMap.put("trigger", mraidApi);
        String impressionId = getImpressionId();
        if (impressionId != null) {
            hashMap.put("impressionId", impressionId);
        }
        hashMap.put("adType", adType);
        InterfaceC2971z5 interfaceC2971z54 = this.i;
        if (interfaceC2971z54 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z54).a(str2, Ob.a(this, str2, "TAG", "processTelemetryEvent "));
        }
        getListener().a("BlockAutoRedirection", hashMap);
    }

    public final void b(String str, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z5).a(str2, Ob.a(this, str2, "TAG", "processMediaPlaybackRequest "));
        }
        if (this.K0) {
            InterfaceC2971z5 interfaceC2971z52 = this.i;
            if (interfaceC2971z52 != null) {
                String TAG = a1;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z52).b(TAG, "Media playback is not allowed after unload! Ignoring request ...");
                return;
            }
            return;
        }
        if (1 != this.b) {
            InterfaceC2971z5 interfaceC2971z53 = this.i;
            if (interfaceC2971z53 != null) {
                String TAG2 = a1;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z53).b(TAG2, "Media playback is only supported on full screen ads! Ignoring request ...");
                return;
            }
            return;
        }
        Activity activity = (Activity) this.q.get();
        if (activity == null) {
            InterfaceC2971z5 interfaceC2971z54 = this.i;
            if (interfaceC2971z54 != null) {
                String TAG3 = a1;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                ((A5) interfaceC2971z54).b(TAG3, "Media playback is  not allowed before it is visible! Ignoring request ...");
            }
            a(str, "Media playback is  not allowed before it is visible! Ignoring request ...", "playVideo");
            return;
        }
        F7 f7 = this.v;
        if (f7 != null) {
            f7.a(url, activity);
        }
    }

    public final void a(boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "fireNextAdLoadComplete "));
        }
        String str2 = "window.imraidview.broadcastEvent('adLoadSuccess'," + z + ");";
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z52).c(TAG, str2 + " Index: " + getCurrentRenderingPodAdIndex());
        }
        c(str2);
    }

    public final void a(String str, JSONObject message) {
        short s;
        Intrinsics.checkNotNullParameter(message, "message");
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "fireError " + this + " - " + message);
        }
        c("window.imraidview.broadcastEvent('error','" + message + "', '" + str + "');");
        Object a2 = C2.a(new C2600cc(message.optString(IronSourceConstants.EVENTS_ERROR_CODE)));
        if (Result.m10248isSuccessimpl(a2)) {
            short shortValue = ((Number) a2).shortValue();
            C2782nc c2782nc = this.W;
            if (c2782nc != null) {
                Map a3 = c2782nc.a();
                switch (shortValue) {
                    case 101:
                        s = 2261;
                        break;
                    case 102:
                        s = 2262;
                        break;
                    case 103:
                        s = 2263;
                        break;
                    case 104:
                        s = 2267;
                        break;
                    case 105:
                        s = 2266;
                        break;
                    case 106:
                        s = 2265;
                        break;
                    case 107:
                        s = 2264;
                        break;
                    default:
                        switch (shortValue) {
                            case MRAID_ERROR_VALUE:
                                s = 2268;
                                break;
                            case INVALID_IFA_STATUS_VALUE:
                                s = 2269;
                                break;
                            case 303:
                                s = 2270;
                                break;
                            case AD_EXPIRED_VALUE:
                                s = 2271;
                                break;
                            case MRAID_BRIDGE_ERROR_VALUE:
                                s = 2272;
                                break;
                            case 306:
                                s = 2273;
                                break;
                            case 307:
                                s = 2274;
                                break;
                            case 308:
                                s = 2275;
                                break;
                            case ASSET_FAILED_TO_DELETE_VALUE:
                                s = 2276;
                                break;
                            case AD_HTML_FAILED_TO_LOAD_VALUE:
                                s = 2277;
                                break;
                            case MRAID_JS_CALL_EMPTY_VALUE:
                                s = 2278;
                                break;
                            case DEEPLINK_OPEN_FAILED_VALUE:
                                s = 2280;
                                break;
                            case EVALUATE_JAVASCRIPT_FAILED_VALUE:
                                s = 2281;
                                break;
                            default:
                                s = shortValue;
                                break;
                        }
                }
                a3.put(IronSourceConstants.EVENTS_ERROR_CODE, Short.valueOf(s));
                long j = c2782nc.c;
                ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
                a3.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
                Pd pd = Pd.f2401a;
                Pd.b("CompanionWebViewLoadFailed", a3, Td.f2443a);
            }
        }
    }

    public final void a(String str, String message, String str2) {
        Intrinsics.checkNotNullParameter(message, "message");
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "fireError " + this + " - " + message + " - " + str2);
        }
        if (str == null || str2 == null) {
            return;
        }
        a(str, "broadcastEvent('error',\"" + message + "\", \"" + str2 + "\")");
    }

    public final void a(String str, String callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z5).a(str2, Ob.a(this, str2, "TAG", "fireJavaScriptCallback "));
        }
        if (str == null) {
            return;
        }
        c(str + '.' + callback);
    }

    public static final void b(GestureDetectorOnGestureListenerC2634ec this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getListener().j(this$0);
    }

    public final void b(String str, String contentId, String url) {
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        Intrinsics.checkNotNullParameter(url, "url");
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z5).c(str2, Ob.a(this, str2, "TAG", "processSaveContentRequest "));
        }
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z52).a(TAG, "saveContent called: content ID: " + contentId + "; URL: " + url);
        }
        if (!f("saveContent")) {
            InterfaceC2971z5 interfaceC2971z53 = this.i;
            if (interfaceC2971z53 != null) {
                String TAG2 = a1;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z53).b(TAG2, "saveContent called despite the fact that it is not supported");
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", url);
                jSONObject.put("reason", 7);
            } catch (JSONException unused) {
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            a(str, "sendSaveContentResult(\"saveContent_" + contentId + "\", 'failed', \"" + StringsKt.replace$default(jSONObject2, "\"", "\\\"", false, 4, (Object) null) + "\");");
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(new C2942xb((byte) -1, url));
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        C2721k c2721k = new C2721k(uuid, hashSet, this.W0, contentId, 2);
        c2721k.c = str;
        C2868t1 c2868t1 = C2868t1.f2707a;
        C2868t1.a(c2721k);
    }

    public void a(C2844ra orientationProperties) {
        Intrinsics.checkNotNullParameter(orientationProperties, "orientationProperties");
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "setOrientationProperties "));
        }
        this.C0 = orientationProperties;
        A();
    }

    public final void b(boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(this, str, "TAG", "fireNextAdShowComplete "));
        }
        String str2 = "window.imraidview.broadcastEvent('adShowSuccess'," + z + ");";
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z52).a(TAG, str2 + " Index: " + getCurrentRenderingPodAdIndex());
        }
        c(str2);
    }

    @Override // com.inmobi.media.InterfaceC2860sa
    public final void a(EnumC2813pa orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "onOrientationUpdate "));
        }
    }

    public final void b(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        if (getAdConfig().getPingV2().getEnabled()) {
            InterfaceC2971z5 interfaceC2971z5 = this.i;
            if (interfaceC2971z5 != null) {
                String str = a1;
                ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "handlePing "));
            }
            if (this.b0 == null) {
                this.b0 = new Ia(this.m, this.W);
            }
            Ia ia = this.b0;
            Intrinsics.checkNotNull(ia);
            ia.b(json);
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.i;
        if (interfaceC2971z52 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z52).a(str2, Ob.a(this, str2, "TAG", "pings v2 is disabled "));
        }
        C2782nc c2782nc = this.W;
        if (c2782nc != null) {
            Intrinsics.checkNotNullParameter("unknown", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY);
            Map a2 = c2782nc.a();
            a2.put(IronSourceConstants.EVENTS_ERROR_CODE, (short) 2257);
            a2.put("trigger", "unknown");
            a2.put("retryCount", String.valueOf(0));
            Oa.a("PingFailed", a2);
        }
        Ha ha = this.m;
        EnumC2774n4[] enumC2774n4Arr = EnumC2774n4.f2646a;
        ((Yb) ha).a("", -100, "Ping V2 is disabled from SDK config", System.currentTimeMillis(), 0);
    }

    public static final boolean a(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec, JsResult jsResult) {
        InterfaceC2971z5 interfaceC2971z5 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(gestureDetectorOnGestureListenerC2634ec, str, "TAG", "shouldRenderPopup "));
        }
        if (gestureDetectorOnGestureListenerC2634ec.getRenderingConfig().getShouldRenderPopup()) {
            return true;
        }
        jsResult.cancel();
        InterfaceC2971z5 interfaceC2971z52 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z52 != null) {
            String str2 = a1;
            ((A5) interfaceC2971z52).a(str2, Ob.a(gestureDetectorOnGestureListenerC2634ec, str2, "TAG", "firePopupBlockedEvent "));
        }
        gestureDetectorOnGestureListenerC2634ec.c("window.mraidview.popupBlocked('popupBlocked')");
        return false;
    }

    @Override // com.inmobi.media.InterfaceC2961yb
    public final boolean a() {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, H6.a(str, "TAG", "hasUserInteracted ").append(getViewTouchTimestamp()).append(' ').append(getRenderingConfig().getUserTouchResetTime()).toString());
        }
        if (!getRenderingConfig().getAutoRedirectionEnforcement() || this.i0) {
            return true;
        }
        return getViewTouchTimestamp() != -1 && SystemClock.elapsedRealtime() - getViewTouchTimestamp() < getRenderingConfig().getUserTouchResetTime();
    }

    public static final void a(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec, String str, String str2, String str3) {
        InterfaceC2971z5 interfaceC2971z5 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "onUserLandingInitialized " + gestureDetectorOnGestureListenerC2634ec + " isInAppBrowser: " + gestureDetectorOnGestureListenerC2634ec.e);
        }
        gestureDetectorOnGestureListenerC2634ec.c("window.imraid.broadcastEvent('onUserLandingInitialized');");
        if (str2 == null) {
            return;
        }
        gestureDetectorOnGestureListenerC2634ec.a(str2, "broadcastEvent('" + str + "Successful','" + str3 + "');");
    }

    public final void a(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        if (getLandingPageConfig().getEnableOnLpLifeCycleEvent()) {
            InterfaceC2971z5 interfaceC2971z5 = this.i;
            if (interfaceC2971z5 != null) {
                String str = a1;
                ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "onLpLifeCycleEvent "));
            }
            c("window.imraid.broadcastEvent('onLpLifeCycleEvent', " + jsonObject + ");");
        }
    }

    public final void a(String trackerName, Map macros) {
        Intrinsics.checkNotNullParameter(trackerName, "trackerName");
        Intrinsics.checkNotNullParameter(macros, "macros");
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(this, str, "TAG", "fireLandingPageTracker "));
        }
        getListener().a(this, trackerName, macros);
    }

    public final void a(boolean z, short s) {
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String TAG = a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "fireRenderProcessGoneTelemetry");
        }
        C2782nc c2782nc = this.W;
        if (c2782nc != null) {
            String a2 = c2782nc.a("WebViewRenderProcessGoneEvent");
            String str = c2782nc.f2652a.k;
            if (str == null) {
                str = "";
            }
            Pair pair = TuplesKt.to("trigger", str);
            long j = c2782nc.c;
            ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
            Map mutableMapOf = MapsKt.mutableMapOf(pair, TuplesKt.to("latency", Long.valueOf(SystemClock.elapsedRealtime() - j)), TuplesKt.to("source", "render_view_" + c2782nc.f2652a.f2589a.b()), TuplesKt.to("isCrashed", Boolean.valueOf(z)), TuplesKt.to("creativeId", c2782nc.f2652a.f), TuplesKt.to(IronSourceConstants.EVENTS_ERROR_CODE, Short.valueOf(s)));
            Pd pd = Pd.f2401a;
            Pd.b(a2, mutableMapOf, Td.f2443a);
        }
    }

    public final void a(GestureDetectorOnGestureListenerC2634ec sourceView, String targetId) {
        Intrinsics.checkNotNullParameter(sourceView, "sourceView");
        Intrinsics.checkNotNullParameter(targetId, "targetId");
        InterfaceC2971z5 interfaceC2971z5 = this.i;
        if (interfaceC2971z5 != null) {
            String str = a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(this, str, "TAG", "fireShowWebViewSuccess "));
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", targetId);
        sourceView.c("window.imraidview.broadcastEvent('webViewShown'," + jSONObject + ");");
    }
}
