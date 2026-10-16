package com.inmobi.media;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class L7 extends Z1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T7 f2351a;

    public L7(T7 t7) {
        this.f2351a = t7;
    }

    @Override // com.inmobi.media.Z1
    public final void a(C2740l2 click) {
        Intrinsics.checkNotNullParameter(click, "click");
        T7 t7 = this.f2351a;
        LinkedHashMap linkedHashMap = t7.R;
        Yd telemetryOnAdImpression = new Yd(linkedHashMap != null ? (U0) linkedHashMap.get("AdImpressionSuccessful") : null, t7.i.f, t7.getCreativeId(), "inmobiJson");
        Intrinsics.checkNotNullParameter("nativeBeacon", "<set-?>");
        telemetryOnAdImpression.e = "nativeBeacon";
        P0 p0 = this.f2351a.w;
        if (p0 != null) {
            Intrinsics.checkNotNullParameter(telemetryOnAdImpression, "telemetryOnAdImpression");
            Intrinsics.checkNotNullParameter("nativeBeacon", "<set-?>");
            telemetryOnAdImpression.e = "nativeBeacon";
            if (p0.f2390a.Z()) {
                telemetryOnAdImpression.b();
            } else {
                p0.f2390a.D.a(telemetryOnAdImpression);
            }
        }
    }

    @Override // com.inmobi.media.Z1
    public final void a(C2740l2 click, String reason) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(reason, "error");
        T7 t7 = this.f2351a;
        LinkedHashMap linkedHashMap = t7.R;
        Yd yd = new Yd(linkedHashMap != null ? (U0) linkedHashMap.get("AdImpressionSuccessful") : null, t7.i.f, t7.getCreativeId(), "inmobiJson");
        Intrinsics.checkNotNullParameter("nativeBeacon", "<set-?>");
        yd.e = "nativeBeacon";
        Intrinsics.checkNotNullParameter(reason, "reason");
        LinkedHashMap a2 = yd.a();
        a2.put("networkType", L3.q());
        a2.put(IronSourceConstants.EVENTS_ERROR_CODE, (short) 2178);
        a2.put("reason", reason);
        Pd pd = Pd.f2401a;
        Pd.b("AdImpressionSuccessful", a2, Td.f2443a);
    }
}
