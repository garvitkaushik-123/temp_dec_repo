package com.applovin.impl.mediation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.a5;
import com.applovin.impl.b5;
import com.applovin.impl.b6;
import com.applovin.impl.c2;
import com.applovin.impl.e2;
import com.applovin.impl.e3;
import com.applovin.impl.g5;
import com.applovin.impl.g6;
import com.applovin.impl.h3;
import com.applovin.impl.i;
import com.applovin.impl.k7;
import com.applovin.impl.l6;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.o3;
import com.applovin.impl.p3;
import com.applovin.impl.q2;
import com.applovin.impl.q3;
import com.applovin.impl.q4;
import com.applovin.impl.r6;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.g;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t3;
import com.applovin.impl.v2;
import com.applovin.impl.v4;
import com.applovin.impl.x2;
import com.applovin.impl.x4;
import com.applovin.impl.z2;
import com.applovin.impl.z4;
import com.applovin.impl.z5;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MediationServiceImpl implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a, reason: collision with root package name */
    private final k f560a;
    private final o b;
    private final z4 c;
    private final AtomicReference d = new AtomicReference();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f561a;

        static {
            int[] iArr = new int[MaxAdapter.InitializationStatus.values().length];
            f561a = iArr;
            try {
                iArr[MaxAdapter.InitializationStatus.DOES_NOT_APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f561a[MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f561a[MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f561a[MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f561a[MaxAdapter.InitializationStatus.NOT_INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f561a[MaxAdapter.InitializationStatus.INITIALIZING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class b implements MaxAdListener, MaxRewardedAdListener, MaxAdViewAdListener, MaxAdRevenueListener, a.InterfaceC0097a {

        /* renamed from: a, reason: collision with root package name */
        private final v2 f562a;
        private a.InterfaceC0097a b;

        public b(v2 v2Var, a.InterfaceC0097a interfaceC0097a) {
            this.f562a = v2Var;
            this.b = interfaceC0097a;
        }

        public void a(a.InterfaceC0097a interfaceC0097a) {
            this.b = interfaceC0097a;
        }

        public void b(MaxAd maxAd, Bundle bundle) {
            this.f562a.a(bundle);
            q2.b(this.b, maxAd);
        }

        public void c(MaxAd maxAd, Bundle bundle) {
            this.f562a.a(bundle);
            o unused = MediationServiceImpl.this.b;
            if (o.a()) {
                MediationServiceImpl.this.b.a("MediationService", "Scheduling impression for ad via callback...");
            }
            MediationServiceImpl.this.processCallbackAdImpressionPostback(this.f562a, this.b);
            if (!((Boolean) MediationServiceImpl.this.f560a.a(o3.m8)).booleanValue() || this.f562a.u().compareAndSet(false, true)) {
                MediationServiceImpl.this.f560a.l().a(this.f562a, g.c.SHOW);
                MediationServiceImpl.this.f560a.u().b(this.f562a, "DID_DISPLAY");
                MediationServiceImpl.this.f560a.p().maybeSendAdEvent(this.f562a, "DID_DISPLAY");
                if (maxAd.getFormat().isFullscreenAd()) {
                    MediationServiceImpl.this.f560a.I().a(this.f562a);
                }
                q2.c(this.b, maxAd);
            }
        }

        public void d(MaxAd maxAd, Bundle bundle) {
            this.f562a.a(bundle);
            q2.d(this.b, maxAd);
        }

        public void e(final MaxAd maxAd, Bundle bundle) {
            this.f562a.a(bundle);
            MediationServiceImpl.this.f560a.l().a(this.f562a, g.c.HIDE);
            MediationServiceImpl.this.a(this.f562a);
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MediationServiceImpl.b.this.a(maxAd);
                }
            }, maxAd instanceof z2 ? ((z2) maxAd).f0() : 0L);
        }

        public void f(MaxAd maxAd, Bundle bundle) {
            this.f562a.a(bundle);
            this.f562a.Y();
            MediationServiceImpl.this.f560a.l().a(this.f562a, g.c.LOAD);
            MediationServiceImpl.this.b(this.f562a);
            q2.f(this.b, maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            a(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdCollapsed(MaxAd maxAd) {
            b(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            a(maxAd, maxError, (Bundle) null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            c(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdExpanded(MaxAd maxAd) {
            d(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            e(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            this.f562a.Y();
            MediationServiceImpl.this.b(this.f562a, maxError, this.b);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            f(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            a(maxAd, maxReward, (Bundle) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd) {
            if (maxAd.getFormat().isFullscreenAd()) {
                MediationServiceImpl.this.f560a.I().b(maxAd);
            }
            q2.e(this.b, maxAd);
        }

        public void a(MaxAd maxAd, Bundle bundle) {
            this.f562a.a(bundle);
            MediationServiceImpl.this.f560a.l().a(this.f562a, g.c.CLICK);
            MediationServiceImpl.this.a(this.f562a, this.b);
            q2.a((MaxAdListener) this.b, maxAd);
        }

        public void a(MaxAd maxAd, MaxError maxError, Bundle bundle) {
            this.f562a.a(bundle);
            MediationServiceImpl.this.a(this.f562a, maxError, this.b);
            if (maxAd.getFormat() == MaxAdFormat.REWARDED && (maxAd instanceof z2)) {
                ((z2) maxAd).d0();
            }
        }

        public void a(MaxAd maxAd, MaxReward maxReward, Bundle bundle) {
            this.f562a.a(bundle);
            q2.a(this.b, maxAd, maxReward);
            MediationServiceImpl.this.f560a.r0().a((g5) new l6((z2) maxAd, MediationServiceImpl.this.f560a), b6.b.OTHER);
        }
    }

    public MediationServiceImpl(k kVar) {
        this.f560a = kVar;
        this.b = kVar.O();
        this.c = new z4(kVar);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
    }

    public void collectSignal(final b5 b5Var, Context context, final a5.a aVar) {
        if (b5Var == null) {
            throw new IllegalArgumentException("No spec specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        x2 u = b5Var.u();
        final String b2 = u.b();
        final MaxAdFormat a2 = u.a();
        a5 b3 = this.c.b(b5Var, b2, a2);
        if (b3 != null) {
            aVar.a(a5.a(b3));
            return;
        }
        final h a3 = this.f560a.T().a(b5Var, b5Var.A());
        if (a3 == null) {
            aVar.a(a5.a(b5Var, new MaxErrorImpl("Could not load adapter")));
            return;
        }
        final q4 q4Var = new q4("SignalCollection:" + b5Var.c());
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        Executor executor = q4.i;
        q4Var.a(executor, new q4.b() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda1
            @Override // com.applovin.impl.q4.b
            public final void a(boolean z, Object obj, Object obj2) {
                MediationServiceImpl.this.a(elapsedRealtime, a3, b2, b5Var, a2, aVar, z, (String) obj, (MaxError) obj2);
            }
        });
        g6.a(b5Var.m(), q4Var, new MaxErrorImpl(MaxAdapterError.ERROR_CODE_SIGNAL_COLLECTION_TIMEOUT, "The adapter (" + b5Var.c() + ") timed out collecting signal"), "MediationService", this.f560a);
        final Activity v0 = context instanceof Activity ? (Activity) context : this.f560a.v0();
        final MaxAdapterParametersImpl a4 = MaxAdapterParametersImpl.a(b5Var, b2, a2);
        if (b5Var.w()) {
            q4 a5 = this.f560a.S().a(b5Var, v0);
            a5.a(executor, new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    MediationServiceImpl.this.a(q4Var, a3, a4, b5Var, v0);
                }
            });
            a5.a(executor, new q4.a() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda3
                @Override // com.applovin.impl.q4.a
                public final void a(Object obj) {
                    MediationServiceImpl.this.a(a3, q4Var, (String) obj);
                }
            });
            return;
        }
        if (b5Var.x()) {
            q4 a6 = this.f560a.S().a(b5Var, v0);
            if (a6.d() && !b5Var.z()) {
                if (o.a()) {
                    this.b.b("MediationService", "Skip collecting signal for failed-initialized adapter: " + a3.g());
                }
                q4Var.a(new MaxErrorImpl("Could not initialize adapter: " + ((String) a6.a())));
                return;
            }
        }
        if (o.a()) {
            this.b.a("MediationService", "Collecting signal for adapter: " + a3.g());
        }
        a3.a(a4, b5Var, v0, q4Var);
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd instanceof v2) {
            if (o.a()) {
                this.b.d("MediationService", "Destroying " + maxAd);
            }
            v2 v2Var = (v2) maxAd;
            h A = v2Var.A();
            if (A != null) {
                A.a();
                v2Var.t();
            }
            this.f560a.j().c(v2Var.P());
            this.f560a.l().a(v2Var, g.c.DESTROY);
        }
    }

    public JSONObject getAndResetCustomPostBodyData() {
        return (JSONObject) this.d.getAndSet(null);
    }

    public void loadAd(String str, String str2, MaxAdFormat maxAdFormat, i iVar, Map<String, Object> map, Map<String, Object> map2, Context context, a.InterfaceC0097a interfaceC0097a) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No Ad Unit ID specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (interfaceC0097a == null) {
            throw new IllegalArgumentException("No listener specified");
        }
        if (TextUtils.isEmpty(this.f560a.V())) {
            o.h("AppLovinSdk", "Mediation provider is null. Please set the mediation provider in the AppLovinSdkInitializationConfiguration.Builder when initializing the AppLovinSDK.");
        }
        if (!this.f560a.C0()) {
            o.j("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        List<String> adUnitIds = this.f560a.K() != null ? this.f560a.K().getAdUnitIds() : null;
        boolean startsWith = str.startsWith("test_mode");
        if (adUnitIds != null && adUnitIds.size() > 0 && !adUnitIds.contains(str) && !startsWith) {
            if (k7.c(this.f560a)) {
                String str3 = "Ad Unit ID " + str + " has not been initialized. When you use selective init, any ad units that you do not explicitly specify are excluded from serving ads for the current session. For more information visit our docs: https://developers.applovin.com/en/max/android/overview/advanced-settings#selective-init";
                if (((Boolean) this.f560a.a(v4.p6)).booleanValue()) {
                    throw new RuntimeException(str3);
                }
                if (o.a()) {
                    this.b.b("MediationService", str3);
                }
            }
            this.f560a.E().a(c2.E0, "uninitialized_ad_unit_id", CollectionUtils.hashMap("ad_unit_id", str), "uninitialized_ad_unit_id" + str);
        }
        this.f560a.c();
        if (str.length() != 16 && !startsWith && !this.f560a.j0().startsWith("05TMD")) {
            o.h("MediationService", "Ad unit ID provided for " + maxAdFormat.getLabel() + " is invalid (" + str + "). Expected length: 16 characters.\n\nStack trace:\n" + Log.getStackTraceString(new Throwable()));
        }
        if (this.f560a.a(maxAdFormat)) {
            o.h("MediationService", "Ad load failed due to disabled ad format " + maxAdFormat.getLabel());
            q2.a(interfaceC0097a, str, new MaxErrorImpl(-1, "Disabled ad format " + maxAdFormat.getLabel()));
            return;
        }
        this.f560a.W0();
        q2.a((MaxAdRequestListener) interfaceC0097a, str, true);
        if (this.f560a.R() != null) {
            this.f560a.R().a(str, str2, maxAdFormat, iVar, map, map2, context, interfaceC0097a);
        } else {
            this.f560a.Q().a(str, str2, maxAdFormat, iVar, map, map2, context, interfaceC0097a);
        }
    }

    public void loadThirdPartyMediatedAd(final String str, final v2 v2Var, final Activity activity, final a.InterfaceC0097a interfaceC0097a) {
        q4 q4Var;
        if (v2Var == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        if (o.a()) {
            this.b.a("MediationService", "Loading " + v2Var + "...");
        }
        this.f560a.P().a(c2.W, v2Var);
        this.f560a.l().a(v2Var, g.c.LOADING);
        this.f560a.u().b(v2Var, "WILL_LOAD");
        this.f560a.p().maybeSendAdEvent(v2Var, "WILL_LOAD");
        final h a2 = this.f560a.T().a(v2Var);
        if (a2 == null) {
            String str2 = "Failed to load " + v2Var + ": adapter not loaded";
            o.h("MediationService", str2);
            b(v2Var, new MaxErrorImpl(-5001, str2), interfaceC0097a);
            return;
        }
        final MaxAdapterParametersImpl a3 = MaxAdapterParametersImpl.a(v2Var);
        if (v2Var.W()) {
            q4Var = this.f560a.S().a(v2Var, activity);
        } else {
            if (v2Var.X()) {
                this.f560a.S().a(v2Var, activity);
            }
            q4Var = null;
        }
        final v2 a4 = v2Var.a(a2);
        a2.a(str, a4);
        a4.Z();
        if (q4Var == null) {
            a2.a(str, a3, a4, activity, new b(a4, interfaceC0097a));
            return;
        }
        Executor executor = q4.i;
        q4Var.a(executor, new q4.a() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda4
            @Override // com.applovin.impl.q4.a
            public final void a(Object obj) {
                MediationServiceImpl.this.a(v2Var, interfaceC0097a, (String) obj);
            }
        });
        q4Var.a(executor, new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                MediationServiceImpl.this.a(a2, str, a3, a4, activity, interfaceC0097a);
            }
        });
    }

    public void maybeFireAppKilledWhilePlayingMediatedAdPostback() {
        String str = (String) this.f560a.b(x4.Q);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jsonObjectFromJsonString = JsonUtils.jsonObjectFromJsonString(str, new JSONObject());
        if (a(JsonUtils.getLong(jsonObjectFromJsonString, "timestamp_ms", 0L))) {
            Long l = (Long) this.f560a.b(x4.R);
            String l2 = l != null ? l.toString() : "";
            JSONObject jSONObject = JsonUtils.getJSONObject(jsonObjectFromJsonString, "ad_info");
            Map tryToStringMap = jSONObject != null ? JsonUtils.tryToStringMap(jSONObject) : new HashMap(1);
            CollectionUtils.putStringIfValid("duration_ms", l2, tryToStringMap);
            this.f560a.E().d(c2.u0, tryToStringMap);
            List list = JsonUtils.getList(jsonObjectFromJsonString, "app_killed_urls", Collections.emptyList());
            if (CollectionUtils.isEmpty(list)) {
                if (o.a()) {
                    this.b.k("MediationService", "Unable to track app killed during mediated ad from previous run. Missing app killed tracking URLs.");
                }
            } else {
                JSONObject jSONObject2 = JsonUtils.getJSONObject(jsonObjectFromJsonString, "user_info");
                Map<String, String> tryToStringMap2 = jSONObject2 != null ? JsonUtils.tryToStringMap(jSONObject2) : t3.c(this.f560a);
                tryToStringMap2.put("{IMP_DURATION_MS}", l2);
                a("mappk", list, tryToStringMap2, null, null, null, true);
            }
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map<String, Object> map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction())) {
            Object a2 = this.f560a.I().a();
            if (a2 instanceof v2) {
                a((MaxError) MaxAdapterError.WEBVIEW_ERROR, (v2) a2, true);
            }
        }
    }

    public void processAdDisplayErrorPostbackForUserError(MaxError maxError, v2 v2Var) {
        a(maxError, v2Var, false);
    }

    public void processAdapterInitializationPostback(h3 h3Var, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("{INIT_STATUS}", String.valueOf(initializationStatus.getCode()));
        hashMap.put("{INIT_TIME_MS}", String.valueOf(j));
        a("minit", hashMap, new MaxErrorImpl(str), h3Var);
        Map a2 = e2.a(h3Var);
        CollectionUtils.putStringIfValid("adapter_init_status", String.valueOf(initializationStatus.getCode()), a2);
        CollectionUtils.putStringIfValid("error_message", str, a2);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(j), a2);
        switch (a.f561a[initializationStatus.ordinal()]) {
            case 1:
            case 2:
            case 3:
                this.f560a.P().d(c2.P, a2);
                break;
            case 4:
                this.f560a.P().d(c2.Q, a2);
                break;
            case 5:
            case 6:
                this.f560a.O();
                if (o.a()) {
                    this.f560a.O().k("MediationService", "Adapter init postback called while the adapter is not fully initialized.");
                }
                this.f560a.E().a(c2.d, "adapterNotInitializedForPostback", a2);
                break;
        }
    }

    public void processCallbackAdImpressionPostback(v2 v2Var, a.InterfaceC0097a interfaceC0097a) {
        if (v2Var.N().endsWith("cimp")) {
            this.f560a.u().b(v2Var);
            q2.a((MaxAdRevenueListener) interfaceC0097a, (MaxAd) v2Var);
        }
        HashMap hashMap = new HashMap(2);
        if (v2Var instanceof z2) {
            hashMap.put("{PREVIOUS_FAILED_NETWORK_NAME}", StringUtils.emptyIfNull(((z2) v2Var).o0()));
        }
        String emptyIfNull = StringUtils.emptyIfNull(this.f560a.x0().e());
        if (!((Boolean) this.f560a.a(v4.E3)).booleanValue()) {
            emptyIfNull = "";
        }
        hashMap.put("{CUID}", emptyIfNull);
        a("mcimp", hashMap, v2Var);
        this.f560a.P().a(c2.b0, v2Var);
    }

    public void processRawAdImpression(v2 v2Var, a.InterfaceC0097a interfaceC0097a) {
        this.f560a.u().b(v2Var, "WILL_DISPLAY");
        this.f560a.p().maybeSendAdEvent(v2Var, "WILL_DISPLAY");
        if (v2Var.N().endsWith("mimp")) {
            this.f560a.u().b(v2Var);
            q2.a((MaxAdRevenueListener) interfaceC0097a, (MaxAd) v2Var);
        }
        if (((Boolean) this.f560a.a(v4.C4)).booleanValue()) {
            this.f560a.Y().a(p3.g, q3.a(v2Var), Long.valueOf(System.currentTimeMillis() - this.f560a.L()));
        }
        HashMap hashMap = new HashMap(3);
        if (v2Var instanceof z2) {
            z2 z2Var = (z2) v2Var;
            hashMap.put("{TIME_TO_SHOW_MS}", String.valueOf(z2Var.j0()));
            hashMap.put("{PREVIOUS_FAILED_NETWORK_NAME}", StringUtils.emptyIfNull(z2Var.o0()));
        }
        String emptyIfNull = StringUtils.emptyIfNull(this.f560a.x0().e());
        if (!((Boolean) this.f560a.a(v4.E3)).booleanValue()) {
            emptyIfNull = "";
        }
        hashMap.put("{CUID}", emptyIfNull);
        a("mimp", hashMap, v2Var);
        this.f560a.P().a(c2.a0, v2Var);
    }

    public void processViewabilityAdImpressionPostback(e3 e3Var, long j, a.InterfaceC0097a interfaceC0097a) {
        if (e3Var.N().endsWith("vimp")) {
            this.f560a.u().b(e3Var);
            q2.a((MaxAdRevenueListener) interfaceC0097a, (MaxAd) e3Var);
        }
        HashMap hashMap = new HashMap(3);
        hashMap.put("{VIEWABILITY_FLAGS}", String.valueOf(j));
        hashMap.put("{USED_VIEWABILITY_TIMER}", String.valueOf(e3Var.k0()));
        String emptyIfNull = StringUtils.emptyIfNull(this.f560a.x0().e());
        if (!((Boolean) this.f560a.a(v4.E3)).booleanValue()) {
            emptyIfNull = "";
        }
        hashMap.put("{CUID}", emptyIfNull);
        a("mvimp", hashMap, e3Var);
        this.f560a.P().a(c2.c0, e3Var);
    }

    public void processWaterfallInfoPostback(MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl, MaxError maxError, long j, long j2) {
        x2 requestParameters = maxAdWaterfallInfoImpl.getRequestParameters();
        String b2 = requestParameters.b();
        MaxAdFormat a2 = requestParameters.a();
        HashMap hashMap = new HashMap();
        CollectionUtils.putStringIfValid(FirebaseAnalytics.Param.AD_FORMAT, a2.getLabel(), hashMap);
        CollectionUtils.putStringIfValid("ad_unit_id", b2, hashMap);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(j2), hashMap);
        CollectionUtils.putStringIfValid("ad_event_id", maxAdWaterfallInfoImpl.getEventId(), hashMap);
        if (maxError != null) {
            hashMap.putAll(e2.a(maxError));
        }
        this.f560a.P().d(c2.Z, hashMap);
        if (CollectionUtils.isEmpty(maxAdWaterfallInfoImpl.getPostbackUrls())) {
            return;
        }
        HashMap hashMap2 = new HashMap(8);
        CollectionUtils.putStringIfValid("mcode", maxAdWaterfallInfoImpl.getMCode(), hashMap2);
        CollectionUtils.putStringIfValid("ad_unit_id", b2, hashMap2);
        CollectionUtils.putStringIfValid(FirebaseAnalytics.Param.AD_FORMAT, a2.getLabel(), hashMap2);
        CollectionUtils.putStringIfValid("name", maxAdWaterfallInfoImpl.getName(), hashMap2);
        CollectionUtils.putLongIfValid("request_latency_ms", Long.valueOf(j2), hashMap2);
        CollectionUtils.putLongIfValid("request_start_timestamp_ms", Long.valueOf(j), hashMap2);
        CollectionUtils.putLongIfValid("wf_latency_ms", Long.valueOf(maxAdWaterfallInfoImpl.getLatencyMillis()), hashMap2);
        hashMap2.put("arn_info", requestParameters.f().e());
        List<MaxNetworkResponseInfo> networkResponses = maxAdWaterfallInfoImpl.getNetworkResponses();
        ArrayList arrayList = new ArrayList(networkResponses.size());
        for (MaxNetworkResponseInfo maxNetworkResponseInfo : networkResponses) {
            MaxMediatedNetworkInfo mediatedNetwork = maxNetworkResponseInfo.getMediatedNetwork();
            HashMap hashMap3 = new HashMap(5);
            CollectionUtils.putStringIfValid("bcode", ((MaxNetworkResponseInfoImpl) maxNetworkResponseInfo).getBCode(), hashMap3);
            hashMap3.put("name", mediatedNetwork.getName());
            CollectionUtils.putLongIfValid("latency_ms", Long.valueOf(maxNetworkResponseInfo.getLatencyMillis()), hashMap3);
            hashMap3.put("load_state", Integer.valueOf(maxNetworkResponseInfo.getAdLoadState().ordinal()));
            MaxErrorImpl maxErrorImpl = (MaxErrorImpl) maxNetworkResponseInfo.getError();
            if (maxErrorImpl != null) {
                HashMap hashMap4 = new HashMap(4);
                hashMap4.put(AndroidBridgeConstants.ERROR_CODE, Integer.valueOf(maxErrorImpl.getCode()));
                hashMap4.put("error_message", maxErrorImpl.getMessage());
                hashMap4.put("third_party_sdk_error_code", Integer.valueOf(maxErrorImpl.getMediatedNetworkErrorCode()));
                hashMap4.put("third_party_sdk_error_message", maxErrorImpl.getMediatedNetworkErrorMessage());
                hashMap3.put("error_info", hashMap4);
            }
            arrayList.add(hashMap3);
        }
        hashMap2.put("ads_info", arrayList);
        a("mwf_info", maxAdWaterfallInfoImpl.getPostbackUrls(), Collections.EMPTY_MAP, hashMap2, null, null, false);
    }

    public void setCustomPostBodyData(JSONObject jSONObject) {
        this.d.set(jSONObject);
    }

    public void showFullscreenAd(final z2 z2Var, final Activity activity, final a.InterfaceC0097a interfaceC0097a) {
        if (z2Var == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (activity == null && MaxAdFormat.APP_OPEN != z2Var.getFormat()) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.f560a.I().a(true);
        final h b2 = b(z2Var);
        long l0 = z2Var.l0();
        if (o.a()) {
            this.b.d("MediationService", "Showing ad " + z2Var.getAdUnitId() + " with delay of " + l0 + "ms...");
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MediationServiceImpl.this.a(z2Var, b2, activity, interfaceC0097a);
            }
        }, l0);
    }

    private h b(z2 z2Var) {
        h A = z2Var.A();
        if (A != null) {
            return A;
        }
        this.f560a.I().a(false);
        if (o.a()) {
            this.b.k("MediationService", "Failed to show " + z2Var + ": adapter not found");
        }
        o.h("MediationService", "There may be an integration problem with the adapter for Ad Unit ID '" + z2Var.getAdUnitId() + "'. Please check if you have a supported version of that SDK integrated into your project.");
        throw new IllegalStateException("Could not find adapter for provided ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(z2 z2Var, h hVar, Activity activity, a.InterfaceC0097a interfaceC0097a) {
        a(z2Var);
        hVar.b(z2Var, activity);
        a(z2Var, interfaceC0097a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(z2 z2Var, h hVar, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, a.InterfaceC0097a interfaceC0097a) {
        a(z2Var);
        hVar.a(z2Var, viewGroup, lifecycle, activity);
        a(z2Var, interfaceC0097a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(v2 v2Var, MaxError maxError, MaxAdListener maxAdListener) {
        a(maxError, v2Var);
        destroyAd(v2Var);
        q2.a(maxAdListener, v2Var.getAdUnitId(), maxError);
    }

    public void showFullscreenAd(final z2 z2Var, final ViewGroup viewGroup, final Lifecycle lifecycle, final Activity activity, final a.InterfaceC0097a interfaceC0097a) {
        if (z2Var == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (activity != null) {
            this.f560a.I().a(true);
            final h b2 = b(z2Var);
            long l0 = z2Var.l0();
            if (o.a()) {
                this.b.d("MediationService", "Showing ad " + z2Var.getAdUnitId() + " with delay of " + l0 + "ms...");
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    MediationServiceImpl.this.a(z2Var, b2, viewGroup, lifecycle, activity, interfaceC0097a);
                }
            }, l0);
            return;
        }
        throw new IllegalArgumentException("No activity specified");
    }

    private void a(z2 z2Var) {
        if (z2Var.getFormat() == MaxAdFormat.REWARDED) {
            this.f560a.r0().a((g5) new r6(z2Var, this.f560a), b6.b.OTHER);
        }
    }

    private void a(z2 z2Var, a.InterfaceC0097a interfaceC0097a) {
        this.f560a.I().a(false);
        a(z2Var, (MaxAdListener) interfaceC0097a);
        if (o.a()) {
            this.b.a("MediationService", "Scheduling impression for ad manually...");
        }
        processRawAdImpression(z2Var, interfaceC0097a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(v2 v2Var) {
        this.f560a.u().b(v2Var, "DID_LOAD");
        this.f560a.p().maybeSendAdEvent(v2Var, "DID_LOAD");
        if (v2Var.N().endsWith("load")) {
            this.f560a.u().b(v2Var);
        }
        HashMap hashMap = new HashMap(3);
        long G = v2Var.G();
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(G));
        if (v2Var.getFormat().isFullscreenAd()) {
            n.a b2 = this.f560a.I().b(v2Var.getAdUnitId());
            hashMap.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(b2.a()));
            hashMap.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(b2.b()));
        }
        a("load", hashMap, v2Var);
        Map a2 = e2.a(v2Var);
        a2.put("duration_ms", String.valueOf(G));
        this.f560a.P().d(c2.X, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(v2 v2Var, a.InterfaceC0097a interfaceC0097a, String str) {
        String str2 = "Failed to load " + v2Var + ": adapter init failed with error: " + str;
        if (o.a()) {
            this.b.k("MediationService", str2);
        }
        b(v2Var, new MaxErrorImpl(MaxAdapterError.NOT_INITIALIZED.getErrorCode(), "Adapter initialization failed"), interfaceC0097a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, String str, MaxAdapterParametersImpl maxAdapterParametersImpl, v2 v2Var, Activity activity, a.InterfaceC0097a interfaceC0097a) {
        hVar.a(str, maxAdapterParametersImpl, v2Var, activity, new b(v2Var, interfaceC0097a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j, h hVar, String str, b5 b5Var, MaxAdFormat maxAdFormat, a5.a aVar, boolean z, String str2, MaxError maxError) {
        a5 a2;
        String str3;
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (z) {
            if (o.a()) {
                str3 = str2;
                this.b.a("MediationService", "Signal collection successful from: " + hVar.g() + " for Ad Unit ID: " + str + " with signal: \"" + str3 + "\"");
            } else {
                str3 = str2;
            }
            a2 = a5.a(b5Var, hVar, str3, j, elapsedRealtime);
            this.c.a(a2, b5Var, str, maxAdFormat);
            HashMap hashMap = new HashMap();
            CollectionUtils.putStringIfValid("network_name", b5Var.c(), hashMap);
            CollectionUtils.putStringIfValid("adapter_class", b5Var.b(), hashMap);
            CollectionUtils.putStringIfValid("adapter_version", hVar.b(), hashMap);
            CollectionUtils.putStringIfValid("duration_ms", String.valueOf(elapsedRealtime), hashMap);
            CollectionUtils.putStringIfValid(FirebaseAnalytics.Param.AD_FORMAT, String.valueOf(maxAdFormat.getLabel()), hashMap);
            CollectionUtils.putStringIfValid("ad_unit_id", str, hashMap);
            this.f560a.P().d(c2.R, hashMap);
        } else {
            if (o.a()) {
                this.b.b("MediationService", "Signal collection failed from: " + hVar.g() + " for Ad Unit ID: " + str + " with error message: \"" + maxError.getMessage() + "\"");
            }
            a2 = a5.a(b5Var, hVar, maxError, j, elapsedRealtime);
            a(a2, b5Var, hVar);
        }
        aVar.a(a2);
        hVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(q4 q4Var, h hVar, MaxAdapterParametersImpl maxAdapterParametersImpl, b5 b5Var, Activity activity) {
        if (q4Var.c()) {
            return;
        }
        if (o.a()) {
            this.b.a("MediationService", "Collecting signal for now-initialized adapter: " + hVar.g());
        }
        hVar.a(maxAdapterParametersImpl, b5Var, activity, q4Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, q4 q4Var, String str) {
        if (o.a()) {
            this.b.b("MediationService", "Skip collecting signal for failed-initialized adapter: " + hVar.g());
        }
        q4Var.a(new MaxErrorImpl(MaxAdapterError.ERROR_CODE_NOT_INITIALIZED, "Could not initialize adapter: " + str));
    }

    private void a(final z2 z2Var, final MaxAdListener maxAdListener) {
        final Long l = (Long) this.f560a.a(o3.L7);
        if (l.longValue() <= 0) {
            return;
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                MediationServiceImpl.this.a(z2Var, l, maxAdListener);
            }
        }, l.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(z2 z2Var, Long l, MaxAdListener maxAdListener) {
        if (z2Var.u().get()) {
            return;
        }
        String str = "Ad (" + z2Var.k() + ") has not been displayed after " + l + "ms. Failing ad display...";
        o.h("MediationService", str);
        a(z2Var, new MaxErrorImpl(-1, str), maxAdListener);
        this.f560a.I().b(z2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v2 v2Var, MaxError maxError, MaxAdListener maxAdListener) {
        this.f560a.l().a(v2Var, g.c.SHOW_ERROR);
        this.f560a.u().b(v2Var, "DID_FAIL_DISPLAY");
        this.f560a.p().maybeSendAdEvent(v2Var, "DID_FAIL_DISPLAY");
        a(maxError, v2Var, true);
        if (v2Var.u().compareAndSet(false, true)) {
            q2.a(maxAdListener, v2Var, maxError);
        }
    }

    private void a(MaxError maxError, v2 v2Var) {
        HashMap hashMap = new HashMap(3);
        long G = v2Var.G();
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(G));
        if (v2Var.getFormat().isFullscreenAd()) {
            n.a b2 = this.f560a.I().b(v2Var.getAdUnitId());
            hashMap.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(b2.a()));
            hashMap.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(b2.b()));
        }
        a("mlerr", hashMap, maxError, v2Var);
        Map a2 = e2.a(v2Var);
        a2.putAll(e2.a(maxError));
        a2.put("duration_ms", String.valueOf(G));
        this.f560a.P().d(c2.Y, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v2 v2Var) {
        this.f560a.u().b(v2Var, "DID_HIDE");
        this.f560a.p().maybeSendAdEvent(v2Var, "DID_HIDE");
        HashMap hashMap = new HashMap(1);
        String emptyIfNull = StringUtils.emptyIfNull(this.f560a.x0().e());
        if (!((Boolean) this.f560a.a(v4.E3)).booleanValue()) {
            emptyIfNull = "";
        }
        hashMap.put("{CUID}", emptyIfNull);
        a("mclose", hashMap, v2Var);
        this.f560a.P().a(c2.e0, v2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v2 v2Var, a.InterfaceC0097a interfaceC0097a) {
        this.f560a.u().b(v2Var, "DID_CLICKED");
        this.f560a.u().b(v2Var, "DID_CLICK");
        this.f560a.p().maybeSendAdEvent(v2Var, "DID_CLICK");
        if (v2Var.N().endsWith("click")) {
            this.f560a.u().b(v2Var);
            q2.a((MaxAdRevenueListener) interfaceC0097a, (MaxAd) v2Var);
        }
        HashMap hashMap = new HashMap(1);
        String emptyIfNull = StringUtils.emptyIfNull(this.f560a.x0().e());
        if (!((Boolean) this.f560a.a(v4.E3)).booleanValue()) {
            emptyIfNull = "";
        }
        hashMap.put("{CUID}", emptyIfNull);
        a("mclick", hashMap, v2Var);
    }

    private void a(MaxError maxError, v2 v2Var, boolean z) {
        HashMap hashMap = new HashMap(1);
        if (v2Var instanceof z2) {
            hashMap.put("{PREVIOUS_FAILED_NETWORK_NAME}", StringUtils.emptyIfNull(((z2) v2Var).o0()));
        }
        a("mierr", hashMap, maxError, v2Var, z);
        if (!z || v2Var == null) {
            return;
        }
        this.f560a.P().a(c2.d0, v2Var, maxError);
    }

    private void a(a5 a5Var, b5 b5Var, h hVar) {
        long b2 = a5Var.b();
        HashMap hashMap = new HashMap(3);
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(b2));
        CollectionUtils.putStringIfValid("{ADAPTER_VERSION}", hVar.b(), hashMap);
        CollectionUtils.putStringIfValid("{SDK_VERSION}", hVar.i(), hashMap);
        a("serr", hashMap, a5Var.c(), b5Var);
        Map a2 = e2.a(a5Var.c());
        CollectionUtils.putStringIfValid("network_name", b5Var.c(), a2);
        CollectionUtils.putStringIfValid("adapter_class", b5Var.b(), a2);
        CollectionUtils.putStringIfValid("adapter_version", hVar.b(), a2);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(b2), a2);
        this.f560a.P().d(c2.S, a2);
    }

    private void a(String str, Map map, h3 h3Var) {
        a(str, map, (MaxError) null, h3Var);
    }

    private void a(String str, Map map, MaxError maxError, h3 h3Var) {
        a(str, map, maxError, h3Var, true);
    }

    private void a(String str, Map map, MaxError maxError, h3 h3Var, boolean z) {
        String str2;
        Map map2 = CollectionUtils.map(map);
        String str3 = "";
        map2.put("{PLACEMENT}", z ? StringUtils.emptyIfNull(h3Var.getPlacement()) : "");
        if (!z) {
            str2 = "";
        } else {
            str2 = StringUtils.emptyIfNull(h3Var.e());
        }
        map2.put("{CUSTOM_DATA}", str2);
        if (h3Var instanceof v2) {
            v2 v2Var = (v2) h3Var;
            if (z) {
                str3 = StringUtils.emptyIfNull(v2Var.getCreativeId());
            }
            map2.put("{CREATIVE_ID}", str3);
        }
        a(str, null, map2, null, maxError, h3Var, z);
    }

    private void a(String str, List list, Map map, Map map2, MaxError maxError, h3 h3Var, boolean z) {
        this.f560a.r0().a((g5) new z5(str, list, map, map2, maxError, h3Var, this.f560a, z), b6.b.OTHER);
    }

    private boolean a(long j) {
        return System.currentTimeMillis() - j <= ((Long) this.f560a.a(v4.C2)).longValue();
    }
}
