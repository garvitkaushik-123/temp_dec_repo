package com.inmobi.media;

import android.os.SystemClock;
import com.adjust.sdk.Constants;
import com.inmobi.commons.core.configs.TelemetryConfig;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public final class J6 {
    public static void a(final F6 funnelState, R6 r6, Integer num, Function2 function2) {
        Intrinsics.checkNotNullParameter(funnelState, "funnelState");
        if (r6 == null || funnelState.c <= r6.f) {
            return;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("plType", r6.f2415a.c);
        linkedHashMap.put("impressionId", r6.f2415a.b);
        linkedHashMap.put("plId", Long.valueOf(r6.f2415a.f2426a));
        linkedHashMap.put("adType", r6.f2415a.d);
        linkedHashMap.put("markupType", r6.f2415a.e);
        linkedHashMap.put("creativeType", r6.f2415a.f);
        linkedHashMap.put("metadataBlob", r6.f2415a.g);
        linkedHashMap.put("isRewarded", Boolean.valueOf(r6.f2415a.h));
        String str = r6.g;
        if (str == null) {
            str = r6.f2415a.i;
        }
        linkedHashMap.put("trigger", str);
        linkedHashMap.put("urlType", r6.b);
        if (num != null) {
            linkedHashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, num);
        }
        long j = r6.d;
        if (j != 0) {
            ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
            linkedHashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        }
        r6.f = funnelState.c;
        ((ScheduledThreadPoolExecutor) AbstractC2970z4.b.getValue()).submit(new Runnable() { // from class: com.inmobi.media.J6$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                J6.a(linkedHashMap, funnelState);
            }
        });
        if (r6.c > ((TelemetryConfig.LandingPageConfig) r6.e.getValue()).getMaxFunnelsToTrackPerAd() || function2 == null) {
            return;
        }
        String str2 = funnelState.b;
        String str3 = r6.g;
        if (str3 == null) {
            str3 = r6.f2415a.i;
        }
        function2.invoke(str2, MapsKt.mapOf(TuplesKt.to("$OPENMODE", str3), TuplesKt.to("$URLTYPE", r6.b)));
    }

    public static String a(String str) {
        return (str == null || str.length() == 0 || !StringsKt.contains$default((CharSequence) str, (CharSequence) "://", false, 2, (Object) null)) ? "invalid" : StringsKt.startsWith(str, "inmobideeplink://", true) ? "inmobideeplink" : StringsKt.startsWith(str, "inmobinativebrowser://", true) ? "inmobinativebrowser" : StringsKt.startsWith(str, "https://", true) ? "https" : StringsKt.startsWith(str, "http://", true) ? "http" : StringsKt.startsWith(str, "market://", true) ? "market" : Constants.DEEPLINK;
    }

    public static /* synthetic */ void a(F6 f6, R6 r6, Integer num, int i) {
        if ((i & 4) != 0) {
            num = null;
        }
        a(f6, r6, num, (Function2) null);
    }

    public static final void a(Map keyValueMap, F6 funnelState) {
        Intrinsics.checkNotNullParameter(keyValueMap, "$keyValueMap");
        Intrinsics.checkNotNullParameter(funnelState, "$funnelState");
        keyValueMap.put("networkType", L3.q());
        String str = funnelState.f2282a;
        Pd pd = Pd.f2401a;
        Pd.b(str, keyValueMap, Td.f2443a);
    }
}
