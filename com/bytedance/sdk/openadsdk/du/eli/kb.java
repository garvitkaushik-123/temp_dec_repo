package com.bytedance.sdk.openadsdk.du.eli;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.eli.dV;
import com.bytedance.sdk.openadsdk.core.qj;
import com.ironsource.C3040d4;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class kb extends com.bytedance.sdk.component.eli.ui<JSONObject, JSONObject> {
    private final qj DbA;
    private final String eli;

    public kb(String str, qj qjVar) {
        this.DbA = qjVar;
        this.eli = str;
    }

    public static void eli(dV dVVar, qj qjVar) {
        dVVar.eli("appInfo", new kb("appInfo", qjVar));
        dVVar.eli("adInfo", new kb("adInfo", qjVar));
        dVVar.eli("sendLog", new kb("sendLog", qjVar));
        dVVar.eli("playable_style", new kb("playable_style", qjVar));
        dVVar.eli("getTemplateInfo", new kb("getTemplateInfo", qjVar));
        dVVar.eli("getTeMaiAds", new kb("getTeMaiAds", qjVar));
        dVVar.eli(C3040d4.h.o, new kb(C3040d4.h.o, qjVar));
        dVVar.eli("getScreenSize", new kb("getScreenSize", qjVar));
        dVVar.eli("getCloseButtonInfo", new kb("getCloseButtonInfo", qjVar));
        dVVar.eli("getVolume", new kb("getVolume", qjVar));
        dVVar.eli("removeLoading", new kb("removeLoading", qjVar));
        dVVar.eli("sendReward", new kb("sendReward", qjVar));
        dVVar.eli("subscribe_app_ad", new kb("subscribe_app_ad", qjVar));
        dVVar.eli("download_app_ad", new kb("download_app_ad", qjVar));
        dVVar.eli("cancel_download_app_ad", new kb("cancel_download_app_ad", qjVar));
        dVVar.eli("unsubscribe_app_ad", new kb("unsubscribe_app_ad", qjVar));
        dVVar.eli("landscape_click", new kb("landscape_click", qjVar));
        dVVar.eli("clickEvent", new kb("clickEvent", qjVar));
        dVVar.eli("renderDidFinish", new kb("renderDidFinish", qjVar));
        dVVar.eli("dynamicTrack", new kb("dynamicTrack", qjVar));
        dVVar.eli("skipVideo", new kb("skipVideo", qjVar));
        dVVar.eli("muteVideo", new kb("muteVideo", qjVar));
        dVVar.eli("changeVideoState", new kb("changeVideoState", qjVar));
        dVVar.eli("getCurrentVideoState", new kb("getCurrentVideoState", qjVar));
        dVVar.eli("send_temai_product_ids", new kb("send_temai_product_ids", qjVar));
        dVVar.eli("getMaterialMeta", new kb("getMaterialMeta", qjVar));
        dVVar.eli("endcard_load", new kb("endcard_load", qjVar));
        dVVar.eli("pauseWebView", new kb("pauseWebView", qjVar));
        dVVar.eli("pauseWebViewTimers", new kb("pauseWebViewTimers", qjVar));
        dVVar.eli("webview_time_track", new kb("webview_time_track", qjVar));
        dVVar.eli("openPrivacy", new kb("openPrivacy", qjVar));
        dVVar.eli("openAdLandPageLinks", new kb("openAdLandPageLinks", qjVar));
        dVVar.eli("getNativeSiteCustomData", new kb("getNativeSiteCustomData", qjVar));
        dVVar.eli("close", new kb("close", qjVar));
    }

    @Override // com.bytedance.sdk.component.eli.ui
    public JSONObject eli(JSONObject jSONObject, com.bytedance.sdk.component.eli.MGA mga) throws Exception {
        qj.DbA dbA = new qj.DbA();
        dbA.eli = NotificationCompat.CATEGORY_CALL;
        dbA.Os = this.eli;
        dbA.aGH = jSONObject;
        return this.DbA.eli(dbA, 3);
    }
}
