package com.applovin.impl.adview;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.o0;
import com.unity3d.ads.adplayer.AndroidWebViewClient;

/* loaded from: classes2.dex */
public class AppLovinWebViewBase extends WebView {
    public AppLovinWebViewBase(Context context) {
        super(context);
    }

    protected void applySettings(com.applovin.impl.sdk.ad.b bVar) {
        Boolean m;
        loadUrl(AndroidWebViewClient.BLANK_PAGE);
        int w0 = bVar.w0();
        if (w0 >= 0) {
            setLayerType(w0, null);
        }
        getSettings().setMediaPlaybackRequiresUserGesture(bVar.M());
        if (bVar.P0()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        m x0 = bVar.x0();
        if (x0 != null) {
            WebSettings settings = getSettings();
            WebSettings.PluginState b = x0.b();
            if (b != null) {
                settings.setPluginState(b);
            }
            Boolean e = x0.e();
            if (e != null) {
                settings.setAllowFileAccess(e.booleanValue());
            }
            Boolean i = x0.i();
            if (i != null) {
                settings.setLoadWithOverviewMode(i.booleanValue());
            }
            Boolean q = x0.q();
            if (q != null) {
                settings.setUseWideViewPort(q.booleanValue());
            }
            Boolean d = x0.d();
            if (d != null) {
                settings.setAllowContentAccess(d.booleanValue());
            }
            Boolean p = x0.p();
            if (p != null) {
                settings.setBuiltInZoomControls(p.booleanValue());
            }
            Boolean h = x0.h();
            if (h != null) {
                settings.setDisplayZoomControls(h.booleanValue());
            }
            Boolean l = x0.l();
            if (l != null) {
                settings.setSaveFormData(l.booleanValue());
            }
            Boolean c = x0.c();
            if (c != null) {
                settings.setGeolocationEnabled(c.booleanValue());
            }
            Boolean j = x0.j();
            if (j != null) {
                settings.setNeedInitialFocus(j.booleanValue());
            }
            Boolean f = x0.f();
            if (f != null) {
                settings.setAllowFileAccessFromFileURLs(f.booleanValue());
            }
            Boolean g = x0.g();
            if (g != null) {
                settings.setAllowUniversalAccessFromFileURLs(g.booleanValue());
            }
            Boolean o = x0.o();
            if (o != null) {
                settings.setLoadsImagesAutomatically(o.booleanValue());
            }
            Boolean n = x0.n();
            if (n != null) {
                settings.setBlockNetworkImage(n.booleanValue());
            }
            if (o0.e()) {
                Integer a2 = x0.a();
                if (a2 != null) {
                    settings.setMixedContentMode(a2.intValue());
                }
                if (o0.f()) {
                    Boolean k = x0.k();
                    if (k != null) {
                        settings.setOffscreenPreRaster(k.booleanValue());
                    }
                    if (!o0.k() || (m = x0.m()) == null) {
                        return;
                    }
                    settings.setAlgorithmicDarkeningAllowed(m.booleanValue());
                }
            }
        }
    }
}
