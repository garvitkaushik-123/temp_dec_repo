package com.bytedance.sdk.openadsdk.api.factory;

import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.bytedance.sdk.openadsdk.common.MGA;

/* loaded from: classes3.dex */
public interface IADLoader<R extends PAGRequest, L extends MGA> {
    void loadAd(String str, R r, L l);
}
