package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.webkit.WebView;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.video.bt.component.d;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MBridgeBTLayout extends BTBaseView {
    private WebView p;

    public MBridgeBTLayout(Context context) {
        super(context);
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.p != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", BTBaseView.n);
                jSONObject2.put("id", getInstanceId());
                jSONObject2.put(C3040d4.h.j0, str);
                jSONObject2.put("data", jSONObject);
                f.a().a(this.p, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                d.c().a(this.p, "broadcast", getInstanceId());
            }
        }
    }

    public WebView getBtWebView() {
        return this.p;
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void init(Context context) {
    }

    public void notifyEvent(String str) {
        WebView webView = this.p;
        if (webView != null) {
            BTBaseView.a(webView, str, this.d);
        }
    }

    public void onBackPressed() {
        if (this.p != null) {
            d.c().a(this.p, "onSystemBackPressed", this.d);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (this.p != null) {
            try {
                CampaignEx campaignEx = this.b;
                if (campaignEx == null || !campaignEx.isDynamicView()) {
                    JSONObject jSONObject = new JSONObject();
                    if (configuration.orientation == 2) {
                        jSONObject.put("orientation", C3040d4.h.C);
                    } else {
                        jSONObject.put("orientation", C3040d4.h.D);
                    }
                    jSONObject.put("instanceId", this.d);
                    f.a().a(this.p, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void onDestory() {
    }

    public void setWebView(WebView webView) {
        this.p = webView;
    }

    public MBridgeBTLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
