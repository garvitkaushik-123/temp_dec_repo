package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.b6;
import com.applovin.impl.b8;
import com.applovin.impl.c2;
import com.applovin.impl.c6;
import com.applovin.impl.g5;
import com.applovin.impl.h7;
import com.applovin.impl.k;
import com.applovin.impl.k7;
import com.applovin.impl.l2;
import com.applovin.impl.o0;
import com.applovin.impl.q2;
import com.applovin.impl.r0;
import com.applovin.impl.s1;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.a;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.d;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.u;
import com.applovin.impl.v1;
import com.applovin.impl.v4;
import com.applovin.impl.w5;
import com.applovin.impl.x4;
import com.applovin.impl.y5;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinBidTokenCollectionListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class AppLovinAdServiceImpl implements AppLovinAdService, a.InterfaceC0101a {

    /* renamed from: a, reason: collision with root package name */
    private final k f653a;
    private final o b;
    private final Map c;
    private final Object d = new Object();
    private final Map e = Collections.synchronizedMap(new HashMap());
    private final AtomicReference f = new AtomicReference();

    class a implements ArrayService.DirectDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v1 f654a;
        final /* synthetic */ com.applovin.impl.sdk.ad.b b;
        final /* synthetic */ Uri c;
        final /* synthetic */ Context d;

        a(v1 v1Var, com.applovin.impl.sdk.ad.b bVar, Uri uri, Context context) {
            this.f654a = v1Var;
            this.b = bVar;
            this.c = uri;
            this.d = context;
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onEvent(String str, Bundle bundle) {
            if (ArrayService.DIRECT_DOWNLOAD_EVENT_APP_DETAILS_SHOWN.equals(str)) {
                AppLovinAdServiceImpl.this.f653a.n0().pauseForClick();
            } else if (ArrayService.DIRECT_DOWNLOAD_EVENT_APP_DETAILS_DISMISSED.equals(str)) {
                AppLovinAdServiceImpl.this.f653a.n0().resumeForClick();
            }
            if (this.f654a != null) {
                this.f654a.e(AppLovinAdServiceImpl.this.f653a.p().getJavaScript(str, bundle));
            }
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onFailure() {
            o unused = AppLovinAdServiceImpl.this.b;
            if (o.a()) {
                AppLovinAdServiceImpl.this.b.a("AppLovinAdService", "Could not execute Direct Install/Direct Download - falling back to normal click logic");
            }
            AppLovinAdServiceImpl.this.a(this.b, this.c, this.d);
        }
    }

    class b implements ArrayService.DirectDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.adview.a f655a;
        final /* synthetic */ com.applovin.impl.sdk.ad.b b;
        final /* synthetic */ AppLovinAdView c;
        final /* synthetic */ Uri d;

        b(com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, Uri uri) {
            this.f655a = aVar;
            this.b = bVar;
            this.c = appLovinAdView;
            this.d = uri;
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onEvent(String str, Bundle bundle) {
            com.applovin.impl.adview.b f;
            if (ArrayService.DIRECT_DOWNLOAD_EVENT_APP_DETAILS_SHOWN.equals(str)) {
                AppLovinAdServiceImpl.this.f653a.n0().pauseForClick();
                com.applovin.impl.adview.a aVar = this.f655a;
                if (aVar != null) {
                    aVar.w();
                    q2.c(this.f655a.e(), this.b, this.c);
                }
            } else if (ArrayService.DIRECT_DOWNLOAD_EVENT_APP_DETAILS_DISMISSED.equals(str) && this.f655a != null) {
                AppLovinAdServiceImpl.this.f653a.n0().resumeForClick();
                q2.a(this.f655a.e(), this.b, this.c);
            }
            com.applovin.impl.adview.a aVar2 = this.f655a;
            if (aVar2 == null || (f = aVar2.f()) == null) {
                return;
            }
            f.a(AppLovinAdServiceImpl.this.f653a.p().getJavaScript(str, bundle));
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onFailure() {
            o unused = AppLovinAdServiceImpl.this.b;
            if (o.a()) {
                AppLovinAdServiceImpl.this.b.a("AppLovinAdService", "Could not execute Direct Install/Direct Download - falling back to normal click logic");
            }
            AppLovinAdServiceImpl.this.a(this.b, this.c, this.f655a, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class c implements l2 {

        /* renamed from: a, reason: collision with root package name */
        private final d f656a;

        /* synthetic */ c(AppLovinAdServiceImpl appLovinAdServiceImpl, d dVar, a aVar) {
            this(dVar);
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            if (!(appLovinAd instanceof com.applovin.impl.sdk.ad.c)) {
                AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
                AppLovinAdServiceImpl.this.f653a.i().a(appLovinAdImpl);
                if (appLovinAdImpl.canExpire()) {
                    AppLovinAdServiceImpl.this.f653a.f().a(appLovinAdImpl, AppLovinAdServiceImpl.this);
                }
                appLovinAd = new com.applovin.impl.sdk.ad.c(appLovinAdImpl.getAdZone(), AppLovinAdServiceImpl.this.f653a);
            }
            Collection emptySet = Collections.emptySet();
            synchronized (this.f656a.f657a) {
                if (!this.f656a.c) {
                    emptySet = new HashSet(this.f656a.d);
                    this.f656a.d.clear();
                }
                d dVar = this.f656a;
                dVar.b = false;
                dVar.c = false;
            }
            Iterator it = emptySet.iterator();
            while (it.hasNext()) {
                AppLovinAdServiceImpl.this.a(appLovinAd, (AppLovinAdLoadListener) it.next());
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i) {
            failedToReceiveAdV2(new AppLovinError(i, ""));
        }

        @Override // com.applovin.impl.l2
        public void failedToReceiveAdV2(AppLovinError appLovinError) {
            Collection emptySet = Collections.emptySet();
            synchronized (this.f656a.f657a) {
                if (!this.f656a.c) {
                    emptySet = new HashSet(this.f656a.d);
                    this.f656a.d.clear();
                }
                d dVar = this.f656a;
                dVar.b = false;
                dVar.c = false;
            }
            Iterator it = emptySet.iterator();
            while (it.hasNext()) {
                AppLovinAdServiceImpl.this.b(appLovinError, (AppLovinAdLoadListener) it.next());
            }
        }

        private c(d dVar) {
            this.f656a = dVar;
        }
    }

    AppLovinAdServiceImpl(k kVar) {
        this.f653a = kVar;
        this.b = kVar.O();
        HashMap hashMap = new HashMap(6);
        this.c = hashMap;
        a aVar = null;
        hashMap.put(u.c(), new d(aVar));
        hashMap.put(u.k(), new d(aVar));
        hashMap.put(u.j(), new d(aVar));
        hashMap.put(u.m(), new d(aVar));
        hashMap.put(u.b(), new d(aVar));
        hashMap.put(u.h(), new d(aVar));
    }

    private void c(AppLovinError appLovinError, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (appLovinAdLoadListener instanceof l2) {
            ((l2) appLovinAdLoadListener).failedToReceiveAdV2(appLovinError);
        } else {
            appLovinAdLoadListener.failedToReceiveAd(appLovinError.getCode());
        }
    }

    public void addCustomQueryParams(Map<String, String> map) {
        this.e.putAll(map);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void collectBidToken(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        if (o.a()) {
            this.b.a("AppLovinAdService", "collectBidToken(listener=" + appLovinBidTokenCollectionListener + ")");
        }
        this.f653a.B().a(appLovinBidTokenCollectionListener);
    }

    public AppLovinAd dequeueAd(u uVar) {
        AppLovinAdImpl a2 = this.f653a.i().a(uVar);
        if (o.a()) {
            this.b.a("AppLovinAdService", "Dequeued ad: " + a2 + " for zone: " + uVar + "...");
        }
        return a2;
    }

    public JSONObject getAndResetCustomPostBody() {
        return (JSONObject) this.f.getAndSet(null);
    }

    public Map<String, String> getAndResetCustomQueryParams() {
        Map<String, String> map;
        synchronized (this.e) {
            map = CollectionUtils.map(this.e);
            this.e.clear();
        }
        return map;
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public String getBidToken() {
        if (o.a()) {
            this.b.a("AppLovinAdService", "getBidToken()");
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String G = this.f653a.B().G();
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        if (StringUtils.isValidString(G) && o.a()) {
            this.b.a("AppLovinAdService", "Successfully retrieved bid token");
        }
        return G;
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        a(u.a(appLovinAdSize, AppLovinAdType.REGULAR), appLovinAdLoadListener);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAdForAdToken(String str, final AppLovinAdLoadListener appLovinAdLoadListener) {
        String trim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(trim)) {
            o.h("AppLovinAdService", "Empty ad token");
            c(new AppLovinError(-8, "Empty ad token"), appLovinAdLoadListener);
            return;
        }
        com.applovin.impl.k kVar = new com.applovin.impl.k(trim, this.f653a);
        if (kVar.c() == k.a.REGULAR) {
            if (o.a()) {
                this.b.a("AppLovinAdService", "Loading next ad for token: " + kVar);
            }
            a(new y5(kVar, appLovinAdLoadListener, this.f653a));
            return;
        }
        if (kVar.c() != k.a.AD_RESPONSE_JSON) {
            AppLovinError appLovinError = new AppLovinError(-8, "Invalid token type");
            o.h("AppLovinAdService", "Invalid token type");
            c(appLovinError, appLovinAdLoadListener);
            return;
        }
        final JSONObject a2 = kVar.a();
        if (a2 == null) {
            String str2 = "Unable to retrieve ad response JSON from token: " + kVar.b();
            AppLovinError appLovinError2 = new AppLovinError(-8, str2);
            o.h("AppLovinAdService", str2);
            c(appLovinError2, appLovinAdLoadListener);
            return;
        }
        r0.c(a2, this.f653a);
        r0.b(a2, this.f653a);
        r0.a(a2, this.f653a);
        this.f653a.m().a();
        if (JsonUtils.getJSONArray(a2, com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, new JSONArray()).length() <= 0) {
            if (o.a()) {
                this.b.b("AppLovinAdService", "No ad returned from the server for token: " + kVar);
            }
            c(AppLovinError.NO_FILL, appLovinAdLoadListener);
            return;
        }
        if (o.a()) {
            this.b.a("AppLovinAdService", "Rendering ad for token: " + kVar);
        }
        final u a3 = k7.a(a2, this.f653a);
        MaxAdFormat d2 = a3.d();
        if (((Boolean) this.f653a.a(v4.W0)).booleanValue() && d2 != null && d2.isFullscreenAd()) {
            this.f653a.h().a(a3, new d.a() { // from class: com.applovin.impl.sdk.AppLovinAdServiceImpl$$ExternalSyntheticLambda1
                @Override // com.applovin.impl.sdk.d.a
                public final void a(com.applovin.impl.sdk.ad.b bVar) {
                    AppLovinAdServiceImpl.this.a(appLovinAdLoadListener, a2, a3, bVar);
                }
            });
        } else {
            a(new c6(a2, a3, appLovinAdLoadListener, this.f653a));
        }
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAdForZoneId(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No zone id specified");
        }
        if (o.a()) {
            this.b.a("AppLovinAdService", "Loading next ad of zone {" + str + "}");
        }
        a(u.a(str), appLovinAdLoadListener);
    }

    public void loadNextIncentivizedAd(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (o.a()) {
            this.b.a("AppLovinAdService", "Loading next incentivized ad of zone {" + str + "}");
        }
        a(u.b(str), appLovinAdLoadListener);
    }

    public void maybeFireAppKilledWhilePlayingAdPostback() {
        Long l;
        if (((Boolean) this.f653a.a(v4.v2)).booleanValue() && (l = (Long) this.f653a.b(x4.M)) != null && System.currentTimeMillis() - l.longValue() <= ((Long) this.f653a.a(v4.z2)).longValue()) {
            if (((Boolean) this.f653a.a(v4.y2)).booleanValue() || b()) {
                a();
            }
        }
    }

    public void maybeSubmitPersistentPostbacks(List<com.applovin.impl.e> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.applovin.impl.e> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    @Override // com.applovin.impl.sdk.a.InterfaceC0101a
    public void onAdExpired(s1 s1Var) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) s1Var;
        u adZone = appLovinAdImpl.getAdZone();
        if (o.a()) {
            this.b.k("AppLovinAdService", "Ad expired for zone: " + adZone);
        }
        this.f653a.i().b(appLovinAdImpl);
        if (this.f653a.H0() || !((Boolean) this.f653a.a(v4.c1)).booleanValue()) {
            return;
        }
        d a2 = a(adZone);
        synchronized (a2.f657a) {
            if (!a2.b) {
                this.f653a.O();
                if (o.a()) {
                    this.f653a.O().a("AppLovinAdService", "Reloading ad after expiration for zone {" + adZone + "}...");
                }
                a2.b = true;
                a2.c = true;
                a(adZone, new c(this, a2, null));
            } else if (o.a()) {
                this.b.a("AppLovinAdService", "Cancelled expired ad reload. Already waiting on an ad load...");
            }
        }
    }

    public void setCustomPostBody(JSONObject jSONObject) {
        this.f.set(jSONObject);
    }

    public String toString() {
        return "AppLovinAdService{adLoadStates=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public void trackAndLaunchClick(com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Uri uri, MotionEvent motionEvent, Bundle bundle) {
        if (bVar == null) {
            if (o.a()) {
                this.b.b("AppLovinAdService", "Unable to track ad view click. No ad specified");
                return;
            }
            return;
        }
        if (bundle == null || !Boolean.parseBoolean(bundle.getString("skip_click_tracking"))) {
            if (o.a()) {
                this.b.a("AppLovinAdService", "Tracking click on an ad...");
            }
            boolean z = bundle != null && Boolean.parseBoolean(bundle.getString("install_click"));
            maybeSubmitPersistentPostbacks(bVar.a(motionEvent, z));
            if (this.f653a.h0() != null) {
                this.f653a.h0().b(bVar.d(motionEvent, false, z), motionEvent);
            }
        } else if (o.a()) {
            this.b.a("AppLovinAdService", "Skipping tracking for click on an ad...");
        }
        if (appLovinAdView == null || uri == null) {
            if (o.a()) {
                this.b.b("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
            }
        } else if (bVar.isDirectDownloadEnabled()) {
            this.f653a.p().startDirectInstallOrDownloadProcess(bVar, bundle, new b(aVar, bVar, appLovinAdView, uri));
        } else {
            a(bVar, appLovinAdView, aVar, uri);
        }
    }

    public void trackAndLaunchVideoClick(com.applovin.impl.sdk.ad.b bVar, Uri uri, MotionEvent motionEvent, Bundle bundle, v1 v1Var, Context context) {
        if (bVar == null) {
            if (o.a()) {
                this.b.b("AppLovinAdService", "Unable to track video click. No ad specified");
                return;
            }
            return;
        }
        if (bundle == null || !Boolean.parseBoolean(bundle.getString("skip_click_tracking"))) {
            if (o.a()) {
                this.b.a("AppLovinAdService", "Tracking VIDEO click on an ad...");
            }
            boolean z = bundle != null && Boolean.parseBoolean(bundle.getString("install_click"));
            maybeSubmitPersistentPostbacks(bVar.b(motionEvent, z));
            if (this.f653a.h0() != null) {
                this.f653a.h0().b(bVar.d(motionEvent, true, z), motionEvent);
            }
        } else if (o.a()) {
            this.b.a("AppLovinAdService", "Skipping tracking for VIDEO click on an ad...");
        }
        if (bVar.isDirectDownloadEnabled()) {
            this.f653a.p().startDirectInstallOrDownloadProcess(bVar, bundle, new a(v1Var, bVar, uri, context));
        } else {
            a(bVar, uri, context);
        }
    }

    public void trackCustomTabsNavigationAborted(com.applovin.impl.sdk.ad.b bVar) {
        if (o.a()) {
            this.b.a("AppLovinAdService", "Tracking Custom Tabs navigation aborted on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.w());
    }

    public void trackCustomTabsNavigationFailed(com.applovin.impl.sdk.ad.b bVar) {
        if (o.a()) {
            this.b.a("AppLovinAdService", "Tracking Custom Tabs navigation failed on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.x());
    }

    public void trackCustomTabsNavigationFinished(com.applovin.impl.sdk.ad.b bVar) {
        if (o.a()) {
            this.b.a("AppLovinAdService", "Tracking Custom Tabs navigation finished on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.y());
    }

    public void trackCustomTabsNavigationStarted(com.applovin.impl.sdk.ad.b bVar) {
        if (o.a()) {
            this.b.a("AppLovinAdService", "Tracking Custom Tabs navigation started on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.z());
    }

    public void trackCustomTabsTabHidden(com.applovin.impl.sdk.ad.b bVar) {
        if (o.a()) {
            this.b.a("AppLovinAdService", "Tracking Custom Tabs tab hidden on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.B());
    }

    public void trackCustomTabsTabShown(com.applovin.impl.sdk.ad.b bVar) {
        if (o.a()) {
            this.b.a("AppLovinAdService", "Tracking Custom Tabs tab shown on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.C());
    }

    public void trackFullScreenAdClosed(com.applovin.impl.sdk.ad.b bVar, long j, List<Long> list, long j2, boolean z, int i) {
        if (bVar == null) {
            if (o.a()) {
                this.b.b("AppLovinAdService", "Unable to track ad closed. No ad specified.");
                return;
            }
            return;
        }
        if (o.a()) {
            this.b.a("AppLovinAdService", "Tracking ad closed...");
        }
        List<com.applovin.impl.e> e = bVar.e();
        if (e == null || e.isEmpty()) {
            if (o.a()) {
                this.b.k("AppLovinAdService", "Unable to track ad closed for AD #" + bVar.getAdIdNumber() + ". Missing ad close tracking URL." + bVar.getAdIdNumber());
                return;
            }
            return;
        }
        for (com.applovin.impl.e eVar : e) {
            String a2 = a(eVar.c(), j, j2, list, bVar.F(), z, i);
            String a3 = a(eVar.a(), j, j2, list, bVar.F(), z, i);
            if (StringUtils.isValidString(a2)) {
                a(new com.applovin.impl.e(a2, a3));
            } else if (o.a()) {
                this.b.b("AppLovinAdService", "Failed to parse url: " + eVar.c());
            }
        }
    }

    public void trackImpression(com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null) {
            if (o.a()) {
                this.b.b("AppLovinAdService", "Unable to track impression click. No ad specified");
            }
        } else {
            if (o.a()) {
                this.b.a("AppLovinAdService", "Tracking impression on ad...");
            }
            maybeSubmitPersistentPostbacks(bVar.K());
            if (this.f653a.h0() != null) {
                this.f653a.h0().b(bVar.getPrivacySandboxImpressionAttributionUrls());
            }
        }
    }

    public void trackVideoEnd(com.applovin.impl.sdk.ad.b bVar, long j, int i, boolean z) {
        if (bVar == null) {
            if (o.a()) {
                this.b.b("AppLovinAdService", "Unable to track video end. No ad specified");
                return;
            }
            return;
        }
        if (o.a()) {
            this.b.a("AppLovinAdService", "Tracking video end on ad...");
        }
        List<com.applovin.impl.e> q0 = bVar.q0();
        if (q0 == null || q0.isEmpty()) {
            if (o.a()) {
                this.b.k("AppLovinAdService", "Unable to submit persistent postback for AD #" + bVar.getAdIdNumber() + ". Missing video end tracking URL.");
                return;
            }
            return;
        }
        String l = Long.toString(System.currentTimeMillis());
        for (com.applovin.impl.e eVar : q0) {
            if (StringUtils.isValidString(eVar.c())) {
                String a2 = a(eVar.c(), j, i, l, z);
                String a3 = a(eVar.a(), j, i, l, z);
                if (a2 != null) {
                    a(new com.applovin.impl.e(a2, a3));
                } else if (o.a()) {
                    this.b.b("AppLovinAdService", "Failed to parse url: " + eVar.c());
                }
            } else if (o.a()) {
                this.b.k("AppLovinAdService", "Requested a postback dispatch for an empty video end URL; nothing to do...");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final AppLovinError appLovinError, final AppLovinAdLoadListener appLovinAdLoadListener) {
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.AppLovinAdServiceImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AppLovinAdServiceImpl.this.a(appLovinError, appLovinAdLoadListener);
            }
        });
    }

    public void loadNextAd(String str, AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (o.a()) {
            this.b.a("AppLovinAdService", "Loading next ad of zone {" + str + "} with size " + appLovinAdSize);
        }
        a(u.a(appLovinAdSize, AppLovinAdType.REGULAR, str), appLovinAdLoadListener);
    }

    private Uri b(Uri uri, String str) {
        try {
            return Uri.parse(uri.getQueryParameter(str));
        } catch (Throwable th) {
            this.f653a.O();
            if (o.a()) {
                this.f653a.O().k("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
            }
            this.f653a.E().a("AppLovinAdService", "buildDeepLinkPlusUrl", th);
            return null;
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        final Object f657a;
        boolean b;
        boolean c;
        final Collection d;

        private d() {
            this.f657a = new Object();
            this.d = new HashSet();
        }

        public String toString() {
            return "AdLoadState{, isWaitingForAd=" + this.b + ", isReloadingExpiredAd=" + this.c + ", pendingAdListeners=" + this.d + AbstractJsonLexerKt.END_OBJ;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final AppLovinAdLoadListener appLovinAdLoadListener, JSONObject jSONObject, u uVar, final com.applovin.impl.sdk.ad.b bVar) {
        if (bVar != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.AppLovinAdServiceImpl$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    AppLovinAdLoadListener.this.adReceived(bVar);
                }
            });
        } else {
            a(new c6(jSONObject, uVar, appLovinAdLoadListener, this.f653a));
        }
    }

    private boolean b() {
        if (!o0.b()) {
            return true;
        }
        Context o = k.o();
        ApplicationExitInfo applicationExitInfo = ((ActivityManager) o.getSystemService("activity")).getHistoricalProcessExitReasons(o.getPackageName(), 0, 1).get(0);
        return applicationExitInfo.getReason() == 10 || applicationExitInfo.getReason() == 11;
    }

    private void a(u uVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (uVar == null) {
            throw new IllegalArgumentException("No zone specified");
        }
        if (appLovinAdLoadListener != null) {
            this.f653a.O();
            if (o.a()) {
                this.f653a.O().a("AppLovinAdService", "Loading next ad of zone {" + uVar + "}...");
            }
            d a2 = a(uVar);
            synchronized (a2.f657a) {
                a2.d.add(appLovinAdLoadListener);
                if (!a2.b) {
                    a2.b = true;
                    a(uVar, new c(this, a2, null));
                } else if (o.a()) {
                    this.b.a("AppLovinAdService", "Already waiting on an ad load...");
                }
            }
            return;
        }
        throw new IllegalArgumentException("No callback specified");
    }

    private void a(g5 g5Var) {
        if (!this.f653a.C0()) {
            o.j("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        this.f653a.c();
        this.f653a.r0().a(g5Var, b6.b.CORE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final AppLovinAd appLovinAd, final AppLovinAdLoadListener appLovinAdLoadListener) {
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.AppLovinAdServiceImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AppLovinAdServiceImpl.this.a(appLovinAdLoadListener, appLovinAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinAdLoadListener appLovinAdLoadListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdLoadListener.adReceived(appLovinAd);
        } catch (Throwable th) {
            o.c("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
            this.f653a.E().a("AppLovinAdService", "notifyAdLoadedCallback", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinError appLovinError, AppLovinAdLoadListener appLovinAdLoadListener) {
        try {
            c(appLovinError, appLovinAdLoadListener);
        } catch (Throwable th) {
            o.c("AppLovinAdService", "Unable to notify listener about ad load failure", th);
            this.f653a.E().a("AppLovinAdService", "notifyAdLoadFailedCallback".concat(appLovinAdLoadListener instanceof l2 ? "V2" : ""), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.sdk.ad.b bVar, Uri uri, Context context) {
        if (h7.b(uri)) {
            a(uri, bVar, null, null, context, this.f653a);
        } else {
            h7.b(uri, bVar, context, this.f653a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Uri uri) {
        Context context;
        if (((Boolean) this.f653a.a(v4.x)).booleanValue()) {
            context = b8.b(appLovinAdView, this.f653a);
            if (context == null) {
                context = appLovinAdView.getContext();
            }
        } else {
            context = appLovinAdView.getContext();
        }
        Context context2 = context;
        if (h7.b(uri)) {
            a(uri, bVar, appLovinAdView, aVar, context2, this.f653a);
        } else {
            a(uri, bVar, appLovinAdView, aVar, context2);
        }
    }

    private String a(String str, long j, int i, String str2, boolean z) {
        try {
            if (!StringUtils.isValidString(str)) {
                return null;
            }
            if (i < 0 || i > 100) {
                i = 0;
            }
            return Uri.parse(str).buildUpon().appendQueryParameter("et_s", Long.toString(j)).appendQueryParameter("pv", Integer.toString(i)).appendQueryParameter("vid_ts", str2).appendQueryParameter("uvs", Boolean.toString(z)).build().toString();
        } catch (Throwable th) {
            if (o.a()) {
                this.b.a("AppLovinAdService", "Unknown error parsing the video end url: " + str, th);
            }
            this.f653a.E().a("AppLovinAdService", "buildVideoEndUrl", th);
            return null;
        }
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Context context) {
        if (h7.b(uri, bVar, context, this.f653a)) {
            q2.b(aVar.e(), bVar, appLovinAdView);
        }
        aVar.w();
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Context context, k kVar) {
        if (uri != null && StringUtils.isValidString(uri.getQuery())) {
            Uri b2 = b(uri, "primaryUrl");
            List a2 = a(uri, "primaryTrackingUrl");
            Uri b3 = b(uri, "fallbackUrl");
            List a3 = a(uri, "fallbackTrackingUrl");
            if (b2 == null && b3 == null) {
                kVar.O();
                if (o.a()) {
                    kVar.O().b("AppLovinAdService", "Failed to parse both primary and backup URLs for Deep Link+ command");
                    return;
                }
                return;
            }
            if (!a(b2, "primary", a2, bVar, appLovinAdView, aVar, context, kVar)) {
                a(b3, "backup", a3, bVar, appLovinAdView, aVar, context, kVar);
            }
            if (aVar != null) {
                aVar.w();
                return;
            }
            return;
        }
        kVar.O();
        if (o.a()) {
            kVar.O().b("AppLovinAdService", "Failed to execute Deep Link+ command - no query parameters found");
        }
    }

    private boolean a(Uri uri, String str, List list, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Context context, k kVar) {
        kVar.O();
        if (o.a()) {
            kVar.O().a("AppLovinAdService", "Opening " + str + " URL: " + uri);
        }
        boolean b2 = h7.b(uri, bVar, context, kVar);
        if (b2) {
            kVar.O();
            if (o.a()) {
                kVar.O().a("AppLovinAdService", "URL opened successfully, dispatching tracking URLs: " + list);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                kVar.g0().dispatchPostbackAsync(((Uri) it.next()).toString(), null);
            }
            if (aVar != null) {
                q2.b(aVar.e(), bVar, appLovinAdView);
                return b2;
            }
        } else {
            kVar.O();
            if (o.a()) {
                kVar.O().b("AppLovinAdService", "URL failed to open");
            }
        }
        return b2;
    }

    private List a(Uri uri, String str) {
        List<String> queryParameters = uri.getQueryParameters(str);
        ArrayList arrayList = new ArrayList(queryParameters.size());
        Iterator<String> it = queryParameters.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(Uri.parse(it.next()));
            } catch (Throwable th) {
                this.f653a.O();
                if (o.a()) {
                    this.f653a.O().k("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
                }
                this.f653a.E().a("AppLovinAdService", "buildDeepLinkPlusUrlList", th);
            }
        }
        return arrayList;
    }

    private String a(String str, long j, long j2, List list, String str2, boolean z, int i) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("et_ms", Long.toString(j)).appendQueryParameter("vs_ms", Long.toString(j2));
        if (list != null && list.size() > 0) {
            appendQueryParameter.appendQueryParameter("ec_ms", list.toString());
        }
        if (StringUtils.isValidString(str2)) {
            appendQueryParameter.appendQueryParameter("ds", str2);
        }
        if (i != i.h) {
            appendQueryParameter.appendQueryParameter("musw_ch", Boolean.toString(z));
            appendQueryParameter.appendQueryParameter("musw_st", Boolean.toString(i.a(i)));
        }
        return appendQueryParameter.build().toString();
    }

    private void a() {
        Map<String, String> tryToStringMap;
        if (o.a()) {
            this.b.a("AppLovinAdService", "Tracking app killed during ad from previous run.");
        }
        String str = (String) this.f653a.b(x4.P);
        if (TextUtils.isEmpty(str)) {
            if (o.a()) {
                this.b.a("AppLovinAdService", "Couldn't get last ad data. Tracking event with empty data.");
            }
            tryToStringMap = null;
        } else {
            tryToStringMap = JsonUtils.tryToStringMap(JsonUtils.jsonObjectFromJsonString(str, new JSONObject()));
        }
        this.f653a.E().d(c2.t0, tryToStringMap);
        String str2 = (String) this.f653a.b(x4.O);
        if (str2 != null) {
            JSONObject jsonObjectFromJsonString = JsonUtils.jsonObjectFromJsonString(str2, null);
            String string = JsonUtils.getString(jsonObjectFromJsonString, "app_killed_postback_url", null);
            String string2 = JsonUtils.getString(jsonObjectFromJsonString, "app_killed_postback_backup_url", null);
            Long l = (Long) this.f653a.b(x4.N);
            if (l != null) {
                string = StringUtils.appendQueryParameter(string, "imp_duration_ms", String.valueOf(l));
                string2 = StringUtils.appendQueryParameter(string2, "imp_duration_ms", String.valueOf(l));
            }
            a(new com.applovin.impl.e(string, string2));
            return;
        }
        if (o.a()) {
            this.b.k("AppLovinAdService", "Unable to track app killed during ad from previous run. Missing app killed tracking URLs.");
        }
    }

    private void a(com.applovin.impl.e eVar) {
        if (StringUtils.isValidString(eVar.c())) {
            this.f653a.f0().e(com.applovin.impl.sdk.network.d.b().d(eVar.c()).a(StringUtils.isValidString(eVar.a()) ? eVar.a() : null).a(eVar.b()).a(false).b(eVar.d()).a());
        } else if (o.a()) {
            this.b.k("AppLovinAdService", "Requested a postback dispatch for a null URL; nothing to do...");
        }
    }

    private void a(final u uVar, final c cVar) {
        AppLovinAdImpl e = this.f653a.i().e(uVar);
        if (e != null && !e.isExpired()) {
            if (o.a()) {
                this.b.a("AppLovinAdService", "Using pre-loaded ad: " + e + " for " + uVar);
            }
            cVar.adReceived(e);
            return;
        }
        MaxAdFormat d2 = uVar.d();
        if (((Boolean) this.f653a.a(v4.W0)).booleanValue() && d2 != null && d2.isFullscreenAd()) {
            this.f653a.h().a(uVar, new d.a() { // from class: com.applovin.impl.sdk.AppLovinAdServiceImpl$$ExternalSyntheticLambda5
                @Override // com.applovin.impl.sdk.d.a
                public final void a(com.applovin.impl.sdk.ad.b bVar) {
                    AppLovinAdServiceImpl.this.a(cVar, uVar, bVar);
                }
            });
        } else {
            a(new w5(uVar, cVar, this.f653a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final c cVar, u uVar, final com.applovin.impl.sdk.ad.b bVar) {
        if (bVar != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.AppLovinAdServiceImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    AppLovinAdServiceImpl.c.this.adReceived(bVar);
                }
            });
        } else {
            a(new w5(uVar, cVar, this.f653a));
        }
    }

    private d a(u uVar) {
        d dVar;
        synchronized (this.d) {
            dVar = (d) this.c.get(uVar);
            if (dVar == null) {
                dVar = new d(null);
                this.c.put(uVar, dVar);
            }
        }
        return dVar;
    }
}
