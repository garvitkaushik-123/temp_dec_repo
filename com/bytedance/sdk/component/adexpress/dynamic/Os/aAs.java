package com.bytedance.sdk.component.adexpress.dynamic.Os;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class aAs {
    public static kb eli(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.aAs aas, com.bytedance.sdk.component.adexpress.DbA.NU nu) {
        String FS;
        String Vy;
        if (context == null || uiVar == null || kbVar == null) {
            return null;
        }
        FS = kbVar.FS();
        Vy = nu.Vy();
        FS.hashCode();
        switch (FS) {
            case "0":
                return new ui(context, uiVar, kbVar);
            case "1":
                return new Os(context, uiVar, kbVar);
            case "2":
                return new DbA(context, uiVar, kbVar);
            case "5":
                if (kbVar.Za() == 1) {
                    return new dV(context, uiVar, kbVar, kbVar.BH());
                }
                return new aqO(context, uiVar, kbVar);
            case "6":
            case "11":
                return new nn(context, uiVar, kbVar);
            case "7":
            case "14":
                return new nlS(context, uiVar, kbVar);
            case "8":
                return new NU(context, uiVar, kbVar);
            case "9":
            case "16":
                return new Dfc(context, uiVar, kbVar, FS, aas.eli(), aas.DbA(), aas.aGH(), aas.kb());
            case "10":
                return new aGH(context, uiVar, kbVar);
            case "12":
                return new aqO(context, uiVar, kbVar);
            case "13":
                return new dV(context, uiVar, kbVar);
            case "17":
            case "18":
                return new QX(context, uiVar, kbVar, FS, aas);
            case "20":
                if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                    return new du(context, uiVar, kbVar, Vy + "static/lotties/glass-swipe/glass-swipe.json", "20");
                }
                return new du(context, uiVar, kbVar, TextUtils.isEmpty(Vy) ? null : Vy + "brush_mask.json", "20");
            case "22":
                if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                    return new du(context, uiVar, kbVar, Vy + "static/lotties/202327swiper-up-star/index.json", "22");
                }
                return new nGm(context, uiVar, kbVar);
            case "23":
                if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                    return new du(context, uiVar, kbVar, Vy + "static/lotties/202327swiper-up-star/click.json", "23");
                }
                return null;
            case "24":
                if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                    return new eli(context, uiVar, kbVar);
                }
                return new du(context, uiVar, kbVar, TextUtils.isEmpty(Vy) ? null : Vy + "swiper_up_star.json", "24");
            case "25":
                if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                    return new du(context, uiVar, kbVar, Vy + "static/lotties/gesture-slide.json", "25");
                }
                return null;
            case "29":
                return new MGA(context, uiVar, kbVar, aas.eli(), aas.DbA(), aas.aGH(), aas.kb());
            default:
                return null;
        }
    }
}
