package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.TelemetryConfig;
import com.moloco.sdk.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Pd implements InterfaceC2909va, Db, N2 {

    /* renamed from: a, reason: collision with root package name */
    public static final Pd f2401a;
    public static final String b;
    public static final List c;
    public static final AtomicBoolean d;
    public static volatile TelemetryConfig e;
    public static C2871t4 f;
    public static volatile C2585be g;
    public static final Od h;
    public static Xd i;

    static {
        Pd pd = new Pd();
        f2401a = pd;
        Intrinsics.checkNotNullExpressionValue("Pd", "getSimpleName(...)");
        b = "Pd";
        List mutableListOf = CollectionsKt.mutableListOf("AdLoadCalled", "AdLoadDroppedAtSDK", "AdLoadSuccessful", "AdLoadFailed", "ServerFill", "ServerNoFill", "ServerError", "AssetDownloaded", "AdShowCalled", "AdShowSuccessful", "AdShowFailed", "AdGetSignalsCalled", "AdGetSignalsSucceeded", "AdGetSignalsFailed", "UnifiedIdNetworkCallRequested", "UnifiedIdNetworkResponseFailure", "FetchApiInvoked", "FetchCallbackFailure", "AdImpressionSuccessful", "RenderSuccess", "ParseSuccess", "PageStarted", "WebViewLoadFinished", "FireAdReady", "WebViewLoadCalled", "FireAdFailed", "ResourceCacheMiss", "ResourceCacheHit", "ResourceDiskCacheFileMissing", "ResourceDiskCacheFileEvicted", "LowAvailableSpaceForCache", "WebViewRenderProcessGoneEvent", "clickStartCalled", "landingsStartSuccess", "landingsStartFailed", "browserOpenFailed", "landingsPageStarted", "landingsCompleteSuccess", "landingsCompleteFailed", "ImmersiveNotSupported", "AdNotReady", "IAPFetchFailed", "BillingClientConnectionError", "BillingClientNotCompatible", "PingFailed", "PingStarted", "PingSuccess", "CompanionWebViewLoadCalled", "CompanionWebViewLoadFailed", "CompanionFireAdReady", "CompanionFireAdFailed", "CompanionWebViewPageStarted", "CompanionWebViewLoadFinished");
        c = mutableListOf;
        d = new AtomicBoolean(false);
        LinkedHashMap linkedHashMap = O2.f2380a;
        Config a2 = M2.a("telemetry", Uc.b(), pd);
        Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.TelemetryConfig");
        e = (TelemetryConfig) a2;
        TelemetryConfig telemetryConfig = e;
        g = new C2585be(new Sd(telemetryConfig.getEnabled(), telemetryConfig.getAssetReporting().isImageEnabled(), telemetryConfig.getAssetReporting().isGifEnabled(), telemetryConfig.getAssetReporting().isVideoEnabled(), telemetryConfig.getDisableAllGeneralEvents(), telemetryConfig.getPriorityEventsList(), telemetryConfig.getSamplingFactor()), CollectionsKt.toList(mutableListOf));
        h = Od.f2387a;
    }

    public static final void b(final String eventType, final Map keyValueMap, final Td telemetryEventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(keyValueMap, "keyValueMap");
        Intrinsics.checkNotNullParameter(telemetryEventType, "telemetryEventType");
        Uc.a(new Runnable() { // from class: com.inmobi.media.Pd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Pd.c(eventType, keyValueMap, telemetryEventType);
            }
        });
    }

    public static final void c() {
        if (d.getAndSet(true)) {
            return;
        }
        Pd pd = f2401a;
        if (T1.a(Nc.e(), null, null, 63) > 0) {
            pd.b();
        }
        Uc.f().a(new int[]{2, 1, 150, 152, 151}, h);
        i = new Xd(e);
    }

    @Override // com.inmobi.media.N2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config instanceof TelemetryConfig) {
            TelemetryConfig telemetryConfig = (TelemetryConfig) config;
            e = telemetryConfig;
            g = new C2585be(new Sd(telemetryConfig.getEnabled(), telemetryConfig.getAssetReporting().isImageEnabled(), telemetryConfig.getAssetReporting().isGifEnabled(), telemetryConfig.getAssetReporting().isVideoEnabled(), telemetryConfig.getDisableAllGeneralEvents(), telemetryConfig.getPriorityEventsList(), telemetryConfig.getSamplingFactor()), CollectionsKt.toList(c));
            Xd xd = i;
            if (xd != null) {
                Intrinsics.checkNotNullParameter(telemetryConfig, "telemetryConfig");
                xd.f2486a = telemetryConfig;
            }
        }
    }

    public final void b() {
        if (d.get()) {
            C2823q4 eventConfig = e.getEventConfig();
            eventConfig.k = e.getTelemetryUrl();
            C2871t4 c2871t4 = f;
            if (c2871t4 == null) {
                f = new C2871t4(Nc.e(), this, eventConfig, this);
            } else {
                Intrinsics.checkNotNullParameter(eventConfig, "eventConfig");
                c2871t4.i = eventConfig;
            }
            C2871t4 c2871t42 = f;
            if (c2871t42 != null) {
                C2823q4 c2823q4 = c2871t42.i;
                if (c2871t42.f.get() || c2823q4 == null) {
                    return;
                }
                c2871t42.a(c2823q4.c, true);
            }
        }
    }

    public static final void c(String eventType, Map keyValueMap, Td telemetryEventType) {
        String str;
        Intrinsics.checkNotNullParameter(eventType, "$eventType");
        Intrinsics.checkNotNullParameter(keyValueMap, "$keyValueMap");
        Intrinsics.checkNotNullParameter(telemetryEventType, "$telemetryEventType");
        Objects.toString(keyValueMap);
        try {
            if (g == null) {
                return;
            }
            Pd pd = f2401a;
            if (a(eventType, keyValueMap, telemetryEventType)) {
                return;
            }
            C2585be c2585be = g;
            if (c2585be == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTelemetryValidator");
                c2585be = null;
            }
            int a2 = c2585be.a(telemetryEventType, eventType);
            if (a2 != 0) {
                if (a2 != 1) {
                    return;
                }
                if (keyValueMap.get("samplingRate") == null) {
                    keyValueMap.put("samplingRate", 100);
                }
            } else if (keyValueMap.get("samplingRate") == null) {
                keyValueMap.put("samplingRate", Integer.valueOf(MathKt.roundToInt((1 - e.getSamplingFactor()) * 100)));
            }
            int ordinal = telemetryEventType.ordinal();
            if (ordinal == 0) {
                str = "sdk";
            } else {
                if (ordinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "template";
            }
            Wd wd = new Wd(eventType, null, str);
            keyValueMap.put("eventType", wd.f2446a);
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            keyValueMap.put("eventId", uuid);
            keyValueMap.put("isTemplateEvent", Boolean.valueOf(telemetryEventType == Td.b));
            String payload = new JSONObject(keyValueMap).toString();
            Intrinsics.checkNotNullExpressionValue(payload, "toString(...)");
            Intrinsics.checkNotNullParameter(payload, "payload");
            wd.d = payload;
            int a3 = (T1.a(Nc.e(), null, null, 63) + 1) - e.getMaxEventsToPersist();
            if (a3 > 0) {
                Nc.e().a(a3);
                int a4 = Ud.a() + a3;
                if (a4 != -1) {
                    Ud.b = a4;
                    C6 c6 = Ud.f2454a;
                    if (c6 != null) {
                        C6.a(c6, "count", a4, false, 4, (Object) null);
                    }
                }
            }
            Nc.e().a(wd);
            pd.b();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        if (r0.f.contains(r5) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0075, code lost:
    
        if (r7.f2386a.b == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0088, code lost:
    
        if (r7.f2386a.c == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009b, code lost:
    
        if (r7.f2386a.d == false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String eventType, Map keyValueMap, Td telemetryEventType) {
        boolean z;
        C2585be c2585be = g;
        if (c2585be == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTelemetryValidator");
            c2585be = null;
        }
        c2585be.getClass();
        Intrinsics.checkNotNullParameter(telemetryEventType, "telemetryEventType");
        Intrinsics.checkNotNullParameter(keyValueMap, "keyValueMap");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        if (c2585be.f2528a.f2430a) {
            int ordinal = telemetryEventType.ordinal();
            if (ordinal == 0) {
                Oc oc = c2585be.b;
                oc.getClass();
                Intrinsics.checkNotNullParameter(keyValueMap, "keyValueMap");
                Intrinsics.checkNotNullParameter(eventType, "eventType");
                Sd sd = oc.f2386a;
                if (sd.e) {
                }
                if (!keyValueMap.isEmpty()) {
                    if (Intrinsics.areEqual(eventType, "AssetDownloaded")) {
                        if (keyValueMap.containsKey("assetType")) {
                            if (Intrinsics.areEqual("image", keyValueMap.get("assetType"))) {
                            }
                            if (Intrinsics.areEqual("gif", keyValueMap.get("assetType"))) {
                            }
                            if (Intrinsics.areEqual("video", keyValueMap.get("assetType"))) {
                            }
                        }
                    }
                }
            } else if (ordinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            z = true;
            return !z;
        }
        z = false;
        return !z;
    }

    @Override // com.inmobi.media.InterfaceC2909va
    public final C2854s4 a() {
        int a2;
        char c2;
        char c3;
        String str;
        if (L3.f2348a.p() == 1) {
            a2 = e.getWifiConfig().a();
        } else {
            a2 = e.getMobileConfig().a();
        }
        List<Wd> mutableList = CollectionsKt.toMutableList((Collection) Nc.e().b(a2));
        if (a("DatabaseMaxLimitReachedV2", MapsKt.emptyMap(), Td.f2443a) || mutableList.size() >= a2 || Ud.a() <= 0) {
            c2 = 1;
            c3 = 4;
        } else {
            int a3 = Ud.a();
            Wd wd = new Wd("DatabaseMaxLimitReachedV2", null, "sdk");
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            c2 = 1;
            c3 = 4;
            HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to("eventId", uuid), TuplesKt.to("eventType", "DatabaseMaxLimitReachedV2"), TuplesKt.to("samplingRate", 100), TuplesKt.to("isTemplateEvent", Boolean.FALSE), TuplesKt.to("eventLostCount", Integer.valueOf(a3)));
            Intrinsics.checkNotNull(hashMapOf, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            String payload = new JSONObject(hashMapOf).toString();
            Intrinsics.checkNotNullExpressionValue(payload, "toString(...)");
            Intrinsics.checkNotNullParameter(payload, "payload");
            wd.d = payload;
            Ud.c = Integer.valueOf(wd.c);
            mutableList.add(wd);
        }
        if (mutableList.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((Wd) it.next()).c));
        }
        try {
            String b2 = Uc.b();
            if (b2 == null) {
                b2 = "";
            }
            Pair pair = TuplesKt.to("im-accid", b2);
            Pair pair2 = TuplesKt.to("version", BuildConfig.SDK_VERSION_NAME);
            Pair pair3 = TuplesKt.to("mk-version", Vc.a());
            Pair pair4 = TuplesKt.to("u-appbid", C2623e1.f2554a);
            Pair pair5 = TuplesKt.to("tp", Vc.d());
            Pair[] pairArr = new Pair[5];
            pairArr[0] = pair;
            pairArr[c2] = pair2;
            pairArr[2] = pair3;
            pairArr[3] = pair4;
            pairArr[c3] = pair5;
            Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
            String f2 = Vc.f();
            if (f2 != null) {
                mutableMapOf.put("tp-v", f2);
            }
            Intrinsics.checkNotNull(mutableMapOf, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            JSONObject jSONObject = new JSONObject(mutableMapOf);
            JSONArray jSONArray = new JSONArray();
            for (Wd wd2 : mutableList) {
                if (StringsKt.trim((CharSequence) wd2.a()).toString().length() > 0) {
                    jSONArray.put(new JSONObject(wd2.a()));
                }
            }
            jSONObject.put("payload", jSONArray);
            str = jSONObject.toString();
        } catch (JSONException unused) {
            str = null;
        }
        if (str != null) {
            return new C2854s4(arrayList, str);
        }
        return null;
    }
}
