package com.mbridge.msdk.advanced.view;

import android.content.Context;
import android.content.IntentFilter;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.mbridge.msdk.advanced.common.NetWorkStateReceiver;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;

/* loaded from: classes6.dex */
public class MBNativeAdvancedWebview extends WindVaneWebView {
    private static final String t = "MBNativeAdvancedWebview";
    private AdSession r;
    private NetWorkStateReceiver s;

    public MBNativeAdvancedWebview(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    public void finishAdSession() {
        try {
            AdSession adSession = this.r;
            if (adSession != null) {
                adSession.finish();
                this.r = null;
                p0.a("OMSDK", "finish adSession");
            }
        } catch (Exception e) {
            p0.a("OMSDK", e.getMessage());
        }
    }

    public AdSession getAdSession() {
        return this.r;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerNetWorkReceiver();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unregisterNetWorkReceiver();
    }

    public void registerNetWorkReceiver() {
        try {
            if (this.s == null) {
                this.s = new NetWorkStateReceiver(this);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            getContext().registerReceiver(this.s, intentFilter);
        } catch (Throwable th) {
            p0.a(t, th.getMessage());
        }
    }

    public void setAdSession(AdSession adSession) {
        this.r = adSession;
    }

    public void unregisterNetWorkReceiver() {
        try {
            NetWorkStateReceiver netWorkStateReceiver = this.s;
            if (netWorkStateReceiver != null) {
                netWorkStateReceiver.a();
                getContext().unregisterReceiver(this.s);
            }
        } catch (Throwable th) {
            p0.a(t, th.getMessage());
        }
    }
}
