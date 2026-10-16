package com.bytedance.sdk.openadsdk.api;

import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;

/* loaded from: classes3.dex */
public interface PAGLoadCallback<Ad> {
    void onAdLoaded(Ad ad);

    void onError(PAGErrorModel pAGErrorModel);
}
