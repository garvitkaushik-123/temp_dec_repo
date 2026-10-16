package com.mbridge.msdk.splash.view;

import android.content.Context;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;

/* loaded from: classes6.dex */
public class MBSplashWebview extends WindVaneWebView {
    private String r;
    private AdSession s;

    public MBSplashWebview(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    public void finishAdSession() {
        try {
            AdSession adSession = this.s;
            if (adSession != null) {
                adSession.finish();
                this.s = null;
                p0.a("OMSDK", "finish adSession");
            }
        } catch (Exception e) {
            p0.a("OMSDK", e.getMessage());
        }
    }

    public AdSession getAdSession() {
        return this.s;
    }

    public String getRequestId() {
        return this.r;
    }

    public void setAdSession(AdSession adSession) {
        this.s = adSession;
    }

    public void setRequestId(String str) {
        this.r = str;
    }
}
