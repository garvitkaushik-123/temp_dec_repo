package com.fyber.inneractive.sdk.util;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes4.dex */
public abstract class l1 {
    public static String a(String str) {
        com.fyber.inneractive.sdk.config.l0 l0Var;
        UnitDisplayType unitDisplayType;
        UnitDisplayType unitDisplayType2;
        IAConfigManager iAConfigManager = IAConfigManager.O;
        HashMap hashMap = iAConfigManager.f1068a;
        com.fyber.inneractive.sdk.config.q0 q0Var = (hashMap == null || !hashMap.containsKey(str)) ? null : (com.fyber.inneractive.sdk.config.q0) iAConfigManager.f1068a.get(str);
        UnitDisplayType unitDisplayType3 = UnitDisplayType.BANNER;
        if (q0Var == null) {
            return unitDisplayType3.name().toLowerCase(Locale.US);
        }
        for (int i = 0; i < q0Var.f1113a.size(); i++) {
            com.fyber.inneractive.sdk.config.r0 r0Var = (com.fyber.inneractive.sdk.config.r0) q0Var.f1113a.get(i);
            if (r0Var != null && ((l0Var = r0Var.c) != null || r0Var.f != null)) {
                if (l0Var == null || (unitDisplayType2 = l0Var.b) == null || unitDisplayType2.isDeprecated() || UnitDisplayType.DEFAULT == unitDisplayType2) {
                    com.fyber.inneractive.sdk.config.t0 t0Var = r0Var.f;
                    if (t0Var != null && (unitDisplayType = t0Var.j) != null && !unitDisplayType.isDeprecated() && UnitDisplayType.DEFAULT != unitDisplayType) {
                        unitDisplayType3 = r0Var.f.j;
                    }
                } else {
                    unitDisplayType3 = r0Var.c.b;
                }
                if (UnitDisplayType.MRECT == unitDisplayType3) {
                    unitDisplayType3 = UnitDisplayType.BANNER;
                }
                if (UnitDisplayType.REWARDED == unitDisplayType3 || UnitDisplayType.INTERSTITIAL == unitDisplayType3 || UnitDisplayType.BANNER == unitDisplayType3) {
                    return unitDisplayType3.name().toLowerCase(Locale.US);
                }
            }
        }
        return UnitDisplayType.BANNER.name().toLowerCase(Locale.US);
    }
}
