package com.applovin.impl;

import android.webkit.WebView;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;

/* loaded from: classes2.dex */
public class d4 extends c4 {
    public d4(com.applovin.impl.sdk.ad.a aVar) {
        super(aVar);
    }

    @Override // com.applovin.impl.c4
    protected AdSessionContext a(WebView webView) {
        try {
            return this.f420a.getOpenMeasurementVerificationScriptResources().size() > 0 ? AdSessionContext.createNativeAdSessionContext(this.b.e0().b(), this.b.e0().a(), this.f420a.getOpenMeasurementVerificationScriptResources(), this.f420a.getOpenMeasurementContentUrl(), this.f420a.getOpenMeasurementCustomReferenceData()) : AdSessionContext.createHtmlAdSessionContext(this.b.e0().b(), webView, this.f420a.getOpenMeasurementContentUrl(), this.f420a.getOpenMeasurementCustomReferenceData());
        } catch (Throwable th) {
            if (!com.applovin.impl.sdk.o.a()) {
                return null;
            }
            this.c.a(this.d, "Failed to create ad session context", th);
            return null;
        }
    }

    @Override // com.applovin.impl.c4
    protected AdSessionConfiguration a() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.LOADED, Owner.NATIVE, Owner.NONE, false);
        } catch (Throwable th) {
            if (!com.applovin.impl.sdk.o.a()) {
                return null;
            }
            this.c.a(this.d, "Failed to create ad session configuration", th);
            return null;
        }
    }
}
