package com.bytedance.sdk.openadsdk.api.bidding;

import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;

/* loaded from: classes3.dex */
public class PAGBiddingRequest {
    private PAGBannerSize eli = null;
    private String DbA = null;
    private String Os = null;

    public void setBannerSize(PAGBannerSize pAGBannerSize) {
        this.eli = pAGBannerSize;
    }

    public PAGBannerSize getBannerSize() {
        return this.eli;
    }

    public void setSlotId(String str) {
        this.DbA = str;
    }

    public String getSlotId() {
        return this.DbA;
    }

    public String getAdxId() {
        return this.Os;
    }

    public void setAdxId(String str) {
        this.Os = str;
    }
}
