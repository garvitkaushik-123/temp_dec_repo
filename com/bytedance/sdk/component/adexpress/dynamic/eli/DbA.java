package com.bytedance.sdk.component.adexpress.dynamic.eli;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.DbA.NU;
import com.bytedance.sdk.component.adexpress.aGH;
import com.bytedance.sdk.component.adexpress.dynamic.aGH.wC;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.CMM;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Dfc;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.FC;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.GB;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.KM;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Os;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Ue;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.VM;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Vy;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Xb;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.aAs;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.aqO;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.bf;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.dV;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.du;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ev;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gG;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.kb;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nGm;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nlS;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nn;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.oWW;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qj;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ujq;

/* loaded from: classes3.dex */
public class DbA {
    public static ui eli(Context context, DynamicRootView dynamicRootView, wC wCVar) {
        NU renderRequest;
        if (context == null || dynamicRootView == null || wCVar == null || wCVar.aAs() == null) {
            return null;
        }
        switch (wCVar.aAs().eli()) {
            case -1:
                return new GB(context, dynamicRootView, wCVar);
            case 0:
                return new gG(context, dynamicRootView, wCVar);
            case 1:
                return new du(context, dynamicRootView, wCVar);
            case 2:
                return new kb(context, dynamicRootView, wCVar);
            case 3:
                return new FC(context, dynamicRootView, wCVar);
            case 4:
                return new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.NU(context, dynamicRootView, wCVar);
            case 5:
                return new nn(context, dynamicRootView, wCVar);
            case 6:
            case 9:
            case 17:
                return new MGA(context, dynamicRootView, wCVar);
            case 7:
                return new qj(context, dynamicRootView, wCVar);
            case 8:
                return new nGm(context, dynamicRootView, wCVar);
            case 10:
                return new aqO(context, dynamicRootView, wCVar);
            case 11:
                return new Vy(context, dynamicRootView, wCVar);
            case 12:
                return new aAs(context, dynamicRootView, wCVar);
            case 13:
                return new ujq(context, dynamicRootView, wCVar);
            case 14:
                return new Ue(context, dynamicRootView, wCVar);
            case 15:
                if (aGH.DbA()) {
                    return new KM(context, dynamicRootView, wCVar);
                }
                return new VM(context, dynamicRootView, wCVar);
            case 16:
                return new du(context, dynamicRootView, wCVar);
            case 18:
                return new ev(context, dynamicRootView, wCVar);
            case 19:
                return new CMM(context, dynamicRootView, wCVar);
            case 20:
                return new Xb(context, dynamicRootView, wCVar);
            case 21:
                return new bf(context, dynamicRootView, wCVar);
            case 22:
                return new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.wC(context, dynamicRootView, wCVar);
            case 23:
                return new dV(context, dynamicRootView, wCVar);
            case 24:
                return new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.aGH(context, dynamicRootView, wCVar);
            case 25:
                return new nlS(context, dynamicRootView, wCVar);
            case 26:
                if ("vertical".equals(wCVar.aAs().ui().Kp())) {
                    return new oWW(context, dynamicRootView, wCVar);
                }
                return new Os(context, dynamicRootView, wCVar);
            case 27:
                return new VM(context, dynamicRootView, wCVar);
            case 28:
                if (!aGH.DbA() || (renderRequest = dynamicRootView.getRenderRequest()) == null) {
                    return null;
                }
                return new Dfc(context, dynamicRootView, wCVar, renderRequest.Vy());
            default:
                return null;
        }
    }
}
