package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdListener;
import com.facebook.ads.AdView;

/* loaded from: assets/audience_network/classes2.dex */
public final class VO implements AdView.AdViewLoadConfigBuilder, AdView.AdViewLoadConfig {
    public String A00;
    public final C1290Rd A01;

    public VO(C1290Rd c1290Rd) {
        this.A01 = c1290Rd;
    }

    public final String A00() {
        return this.A00;
    }

    @Override // com.facebook.ads.AdView.AdViewLoadConfigBuilder, com.facebook.ads.Ad.LoadConfigBuilder
    public final AdView.AdViewLoadConfig build() {
        return this;
    }

    @Override // com.facebook.ads.AdView.AdViewLoadConfigBuilder
    public final AdView.AdViewLoadConfigBuilder withAdListener(AdListener adListener) {
        this.A01.A0C(adListener);
        return this;
    }

    @Override // com.facebook.ads.AdView.AdViewLoadConfigBuilder, com.facebook.ads.Ad.LoadConfigBuilder
    public final AdView.AdViewLoadConfigBuilder withBid(String str) {
        this.A00 = str;
        return this;
    }
}
