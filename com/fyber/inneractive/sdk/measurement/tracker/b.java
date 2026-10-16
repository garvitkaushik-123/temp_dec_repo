package com.fyber.inneractive.sdk.measurement.tracker;

import android.webkit.WebView;
import com.fyber.inneractive.sdk.util.o0;
import com.fyber.inneractive.sdk.web.m;
import com.iab.omid.library.fyber.adsession.AdSessionConfiguration;
import com.iab.omid.library.fyber.adsession.CreativeType;
import com.iab.omid.library.fyber.adsession.ImpressionType;
import com.iab.omid.library.fyber.adsession.Owner;
import com.iab.omid.library.fyber.adsession.Partner;

/* loaded from: classes4.dex */
public final class b extends e {
    public b(Partner partner, m mVar) {
        super(partner, mVar);
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.e
    public final void a(m mVar) {
        super.a(mVar);
        StringBuilder sb = new StringBuilder("javascript:FyberMraidVideoTracker.initOmid(\"");
        sb.append(this.d.getName()).append("\",\"").append(this.d.getVersion());
        sb.append("\");");
        mVar.loadUrl(sb.toString());
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.e
    public final AdSessionConfiguration b() {
        try {
            CreativeType creativeType = CreativeType.DEFINED_BY_JAVASCRIPT;
            ImpressionType impressionType = ImpressionType.DEFINED_BY_JAVASCRIPT;
            Owner owner = Owner.JAVASCRIPT;
            return AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.e
    public final void c() {
        WebView webView;
        if (this.c || this.f1273a == null || (webView = this.e) == null) {
            return;
        }
        this.c = true;
        o0.a(webView, "FyberMraidVideoTracker.impression();");
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.e
    public final void a() {
        WebView webView = this.e;
        if (webView != null) {
            o0.a(webView, "FyberMraidVideoTracker.adUserInteraction();");
        }
    }
}
