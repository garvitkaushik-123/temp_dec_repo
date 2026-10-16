package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class G5 implements C0 {
    public final Map<String, Object> a(C3070f0 adProperties) {
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        String ad_unit = adProperties.a().toString();
        Intrinsics.checkNotNullExpressionValue(ad_unit, "adProperties.adFormat.toString()");
        hashMap.put(Ma.f, ad_unit);
        hashMap.put("adf", Integer.valueOf(C3051df.b(adProperties.a())));
        String uuid = adProperties.b().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "adProperties.adId.toString()");
        hashMap.put(Ma.i, uuid);
        hashMap.put("mediationAdUnitId", adProperties.c());
        hashMap.put("isMultipleAdUnits", 1);
        return hashMap;
    }
}
