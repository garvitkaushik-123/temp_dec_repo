package com.bytedance.sdk.openadsdk.common;

import com.bytedance.sdk.openadsdk.api.PAGErrorCode;
import com.bytedance.sdk.openadsdk.api.PAGLoadListener;
import com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory;
import com.bytedance.sdk.openadsdk.api.factory.SDKTypeConfig;

/* loaded from: classes3.dex */
public class ui {
    private static boolean eli = false;

    public static void eli(boolean z) {
        eli = z;
    }

    public static ISDKTypeFactory eli(PAGLoadListener pAGLoadListener) {
        if (eli) {
            if (pAGLoadListener != null) {
                pAGLoadListener.onError(-1, PAGErrorCode.LOAD_SDK_DISABLE_MSG);
            }
            return null;
        }
        ISDKTypeFactory sdkTypeFactory = SDKTypeConfig.getSdkTypeFactory();
        if (sdkTypeFactory != null) {
            return sdkTypeFactory;
        }
        if (pAGLoadListener != null) {
            pAGLoadListener.onError(5000, PAGErrorCode.LOAD_FACTORY_NULL_MSG);
        }
        return null;
    }

    public static boolean eli() {
        return eli;
    }
}
