package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class Dfc extends MGA {
    com.bytedance.sdk.component.adexpress.dynamic.aGH.wC DbA;
    String eli;

    public Dfc(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar, String str) {
        super(context, dynamicRootView, wCVar);
        this.eli = str;
        this.DbA = wCVar;
        com.bytedance.sdk.component.adexpress.MGA.aAs lottieView = getLottieView();
        if (lottieView != null) {
            addView(lottieView, getWidgetLayoutParams());
        }
    }

    private com.bytedance.sdk.component.adexpress.MGA.aAs getLottieView() {
        String str;
        if (this.NU == null || this.NU.aAs() == null || this.du == null || TextUtils.isEmpty(this.eli)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui = this.NU.aAs().ui();
        if (ui == null) {
            str = "";
        } else {
            str = ui.Mc();
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.eli + "static/lotties/" + str + ".json";
        com.bytedance.sdk.component.adexpress.MGA.aAs aas = new com.bytedance.sdk.component.adexpress.MGA.aAs(this.du);
        aas.setImageLottieTosPath(str2);
        aas.wC();
        return aas;
    }
}
