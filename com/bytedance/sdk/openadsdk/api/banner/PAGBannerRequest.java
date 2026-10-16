package com.bytedance.sdk.openadsdk.api.banner;

import com.bytedance.sdk.openadsdk.api.PAGRequest;

/* loaded from: classes3.dex */
public class PAGBannerRequest extends PAGRequest {
    private PAGBannerSize eli;

    public PAGBannerRequest(PAGBannerSize pAGBannerSize) {
        this.eli = pAGBannerSize;
    }

    public PAGBannerSize getAdSize() {
        return this.eli;
    }

    public void setAdSize(PAGBannerSize pAGBannerSize) {
        this.eli = pAGBannerSize;
    }
}
