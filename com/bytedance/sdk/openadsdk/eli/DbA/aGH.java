package com.bytedance.sdk.openadsdk.eli.DbA;

import android.view.View;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.core.model.ev;

/* loaded from: classes3.dex */
public class aGH implements PAGNativeAdData {
    private final eli eli;

    public aGH(eli eliVar) {
        this.eli = eliVar;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public PAGImageItem getIcon() {
        eli eliVar = this.eli;
        if (eliVar != null) {
            return eliVar.Os();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public String getTitle() {
        eli eliVar = this.eli;
        if (eliVar != null) {
            return eliVar.aGH();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public String getDescription() {
        eli eliVar = this.eli;
        if (eliVar != null) {
            return eliVar.ui();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public String getButtonText() {
        eli eliVar = this.eli;
        if (eliVar != null) {
            return eliVar.MGA();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public PAGMediaView getMediaView() {
        eli eliVar = this.eli;
        if (eliVar != null) {
            return eliVar.kb();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public View getAdLogoView() {
        eli eliVar = this.eli;
        if (eliVar != null) {
            return eliVar.aAs();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public PAGNativeAdData.PAGNativeMediaType getMediaType() {
        if (ev.ui(this.eli.eli)) {
            return PAGNativeAdData.PAGNativeMediaType.PAGNativeMediaTypeVideo;
        }
        return PAGNativeAdData.PAGNativeMediaType.PAGNativeMediaTypeImage;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public View getAdChoicesView() {
        eli eliVar = this.eli;
        if (eliVar != null) {
            return eliVar.du();
        }
        return null;
    }
}
