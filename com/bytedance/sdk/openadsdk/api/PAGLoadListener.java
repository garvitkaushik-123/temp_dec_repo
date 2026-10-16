package com.bytedance.sdk.openadsdk.api;

import com.bytedance.sdk.openadsdk.common.MGA;

/* loaded from: classes3.dex */
public interface PAGLoadListener<Ad> extends MGA {
    void onAdLoaded(Ad ad);

    @Override // com.bytedance.sdk.openadsdk.common.MGA
    void onError(int i, String str);
}
