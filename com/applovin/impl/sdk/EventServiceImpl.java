package com.applovin.impl.sdk;

import android.content.Intent;
import android.text.TextUtils;
import com.applovin.impl.b6;
import com.applovin.impl.g5;
import com.applovin.impl.h1;
import com.applovin.impl.k7;
import com.applovin.impl.p6;
import com.applovin.impl.r1;
import com.applovin.impl.s4;
import com.applovin.impl.sdk.network.d;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.v4;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class EventServiceImpl implements AppLovinEventService {
    public static final List<String> ALLOW_PRE_INIT_EVENT_TYPES = Arrays.asList("landing", C3040d4.h.e0, "resumed", "cf_start", "tos_ok", "gdpr_ok");

    /* renamed from: a, reason: collision with root package name */
    private final k f665a;
    private final AtomicBoolean b = new AtomicBoolean();

    public EventServiceImpl(k kVar) {
        this.f665a = kVar;
    }

    private void a(final String str, final Map map) {
        final boolean contains = ALLOW_PRE_INIT_EVENT_TYPES.contains(str);
        this.f665a.r0().a((g5) new p6(this.f665a, contains, "submitTrackEventPostback", new Runnable() { // from class: com.applovin.impl.sdk.EventServiceImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                EventServiceImpl.this.a(str, map, contains);
            }
        }), b6.b.OTHER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, Map map, Map map2) {
        Map map3 = CollectionUtils.map("AppLovin-Event", str);
        map3.put("AppLovin-SDK-Name", "AppLovin-MAX");
        d.b d = com.applovin.impl.sdk.network.d.b().d(b()).a(a()).a(map3).c(a(str, map, map2)).a(((Boolean) this.f665a.a(v4.a5)).booleanValue()).a(s4.a.a(((Integer) this.f665a.a(v4.l5)).intValue())).d(false);
        if (this.f665a.t0().c()) {
            d.b(CollectionUtils.map("axon_test_code", "1"));
        }
        this.f665a.f0().e(d.a());
    }

    private void c(final String str, final Map map, final Map map2) {
        if (map.containsKey(FirebaseAnalytics.Param.ITEMS)) {
            Object obj = map.get(FirebaseAnalytics.Param.ITEMS);
            if (!(obj instanceof List)) {
                a("Invalid 'items' value: expected a list.");
                return;
            }
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof Map)) {
                    a("Invalid element in 'items': expected a map.");
                    return;
                }
            }
        }
        this.f665a.r0().a((g5) new p6(this.f665a, false, "track_event:" + str, new Runnable() { // from class: com.applovin.impl.sdk.EventServiceImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                EventServiceImpl.this.b(str, map, map2);
            }
        }), b6.b.OTHER);
    }

    private String d() {
        return ((String) this.f665a.a(v4.s0)) + "4.0/pix";
    }

    public void maybeTrackAppOpenEvent() {
        if (this.b.compareAndSet(false, true)) {
            this.f665a.G().trackEvent("landing");
        }
    }

    public String toString() {
        return "EventService{}";
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackCheckout(String str, Map<String, String> map) {
        Map<String, ?> map2 = CollectionUtils.map(map);
        map2.put("transaction_id", str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, map2);
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    public void trackEventSynchronously(String str) {
        this.f665a.O();
        if (o.a()) {
            this.f665a.O().a("AppLovinEventService", "Tracking event: \"" + str + "\" synchronously");
        }
        r1 r1Var = new r1(str, new HashMap());
        boolean contains = this.f665a.c(v4.z0).contains(r1Var.c());
        Map a2 = a(r1Var, true, contains);
        HashMap hashMap = new HashMap(r1Var.d());
        if (((Boolean) this.f665a.a(v4.t5)).booleanValue() || ((Boolean) this.f665a.a(v4.o5)).booleanValue()) {
            hashMap.putAll(a2);
            a2 = null;
        }
        this.f665a.f0().e(com.applovin.impl.sdk.network.d.b().d(d()).a(c()).b(a2).c(hashMap).a(a(r1Var, contains)).c(((Boolean) this.f665a.a(v4.D5)).booleanValue()).a(((Boolean) this.f665a.a(v4.a5)).booleanValue()).a());
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackInAppPurchase(Intent intent, Map<String, String> map) {
        Map<String, ?> map2 = CollectionUtils.map(map);
        try {
            map2.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra("INAPP_PURCHASE_DATA"));
            map2.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        } catch (Throwable th) {
            o.c("AppLovinEventService", "Unable to track in app purchase - invalid purchase intent", th);
            this.f665a.E().a("AppLovinEventService", "trackIAP", th);
        }
        trackEvent("iap", map2);
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackEvent(String str, Map<String, ?> map) {
        trackEvent(str, map, new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, Map map, boolean z) {
        r1 r1Var = new r1(str, map);
        boolean contains = this.f665a.c(v4.z0).contains(r1Var.c());
        Map a2 = a(r1Var, false, contains);
        HashMap hashMap = new HashMap(r1Var.d());
        if (((Boolean) this.f665a.a(v4.t5)).booleanValue() || ((Boolean) this.f665a.a(v4.o5)).booleanValue()) {
            hashMap.putAll(a2);
            a2 = null;
        }
        this.f665a.f0().e(com.applovin.impl.sdk.network.d.b().d(d()).a(c()).a(a(r1Var, contains)).b(a2).c(hashMap).c(((Boolean) this.f665a.a(v4.D5)).booleanValue()).a(((Boolean) this.f665a.a(v4.a5)).booleanValue()).d(z).a(s4.a.a(((Integer) this.f665a.a(v4.k5)).intValue())).a());
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackEvent(String str, Map<String, ?> map, Map<String, Object> map2) {
        if (TextUtils.isEmpty(str)) {
            a("Unable to track empty event");
        } else if (this.f665a.c(v4.A0).contains(str)) {
            c(str, map, map2);
        } else {
            a(str, map);
        }
    }

    private String b() {
        return ((String) this.f665a.a(v4.u0)) + "v1/app";
    }

    private String c() {
        return ((String) this.f665a.a(v4.t0)) + "4.0/pix";
    }

    private void a(String str) {
        o.h("AppLovinEventService", str);
        if (k7.c(this.f665a)) {
            throw new IllegalArgumentException(str);
        }
    }

    private Map a(r1 r1Var, boolean z, boolean z2) {
        Map a2 = this.f665a.B().a((Map) null, z, false);
        a2.put("event_id", r1Var.b());
        a2.put("ts", Long.toString(r1Var.a()));
        if (z2) {
            a2.put("event", r1Var.c());
        } else {
            a2.put("event", "postinstall");
            a2.put("sub_event", r1Var.c());
        }
        return k7.a(a2);
    }

    private Map a(r1 r1Var, boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("AppLovin-Event", r1Var.c());
            return hashMap;
        }
        hashMap.put("AppLovin-Event", "postinstall");
        hashMap.put("AppLovin-Sub-Event", r1Var.c());
        return hashMap;
    }

    private Map a(String str, Map map, Map map2) {
        HashMap hashMap = new HashMap();
        r1 r1Var = new r1(str, map);
        hashMap.put("id", r1Var.b());
        hashMap.put("name", r1Var.c());
        hashMap.put("data", r1Var.d());
        hashMap.put("timestamp", h1.a(r1Var.a()));
        Map E = this.f665a.B().E();
        hashMap.put("app_info", E);
        hashMap.put("device_info", this.f665a.B().o());
        CollectionUtils.putObjectToStringIfValid("dedupe_id", map2.get("dedupe_id"), hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("connectEventKey", this.f665a.r());
        CollectionUtils.putStringIfValid("eventId", this.f665a.F(), hashMap2);
        hashMap2.put("version", AppLovinSdk.VERSION);
        hashMap2.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f665a.j0());
        hashMap2.put(N6.H, this.f665a.B().y());
        if (((Boolean) this.f665a.a(v4.G3)).booleanValue()) {
            CollectionUtils.putStringIfValid("art", this.f665a.s(), hashMap2);
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put("firstVisitTs", E.get("ia_v2"));
        hashMap3.put("lastVisitTs", E.get("last_launch_ms"));
        hashMap3.put("visitCount", E.get("app_launch_count"));
        hashMap3.put("currentVisitStartTs", E.get("alts_ms"));
        hashMap2.put("visitInfo", hashMap3);
        hashMap.put("axon", hashMap2);
        return hashMap;
    }

    private String a() {
        return ((String) this.f665a.a(v4.v0)) + "v1/app";
    }
}
