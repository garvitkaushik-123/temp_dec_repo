package com.inmobi.media;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.kb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2733kb {
    public static final void a(AbstractC2717jb telemetryType) {
        Intrinsics.checkNotNullParameter(telemetryType, "telemetryType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (telemetryType instanceof C2651fb) {
            linkedHashMap.put("trigger", ((C2651fb) telemetryType).f2571a);
            Pd pd = Pd.f2401a;
            Pd.b("BillingClientConnectionError", linkedHashMap, Td.f2443a);
            return;
        }
        if (telemetryType instanceof C2668gb) {
            linkedHashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Short.valueOf(((C2668gb) telemetryType).f2581a));
            Pd pd2 = Pd.f2401a;
            Pd.b("IAPFetchFailed", linkedHashMap, Td.f2443a);
        } else {
            if (!(telemetryType instanceof C2701ib)) {
                if (telemetryType instanceof C2684hb) {
                    Pd pd3 = Pd.f2401a;
                    Pd.b("IAPFetchSuccess", linkedHashMap, Td.f2443a);
                    return;
                }
                return;
            }
            String str = ((C2701ib) telemetryType).f2600a;
            if (str != null) {
                linkedHashMap.put("trigger", str);
            }
            Pd pd4 = Pd.f2401a;
            Pd.b("BillingClientNotCompatible", linkedHashMap, Td.f2443a);
        }
    }
}
