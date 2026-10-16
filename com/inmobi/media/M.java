package com.inmobi.media;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class M extends Z1 {

    /* renamed from: a, reason: collision with root package name */
    public final N f2357a;
    public final Yd b;

    public M(N adImpressionCallbackHandler, Yd yd) {
        Intrinsics.checkNotNullParameter(adImpressionCallbackHandler, "adImpressionCallbackHandler");
        this.f2357a = adImpressionCallbackHandler;
        this.b = yd;
    }

    @Override // com.inmobi.media.Z1
    public final void a(C2740l2 click) {
        Intrinsics.checkNotNullParameter(click, "click");
        this.f2357a.a(this.b);
    }

    @Override // com.inmobi.media.Z1
    public final void a(C2740l2 click, String reason) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(reason, "error");
        Yd yd = this.b;
        Intrinsics.checkNotNullParameter(reason, "reason");
        LinkedHashMap a2 = yd.a();
        a2.put("networkType", L3.q());
        a2.put(IronSourceConstants.EVENTS_ERROR_CODE, (short) 2178);
        a2.put("reason", reason);
        Pd pd = Pd.f2401a;
        Pd.b("AdImpressionSuccessful", a2, Td.f2443a);
    }
}
