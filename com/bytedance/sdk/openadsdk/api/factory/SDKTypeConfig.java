package com.bytedance.sdk.openadsdk.api.factory;

import android.util.Log;

/* loaded from: classes3.dex */
public class SDKTypeConfig {
    private static ISDKTypeFactory eli;

    public static ISDKTypeFactory getSdkTypeFactory() {
        Log.i("SDKTypeConfig", "getSdkTypeFactory: ");
        return eli;
    }

    public static void setSdkTypeFactory(ISDKTypeFactory iSDKTypeFactory) {
        Log.i("SDKTypeConfig", "setSdkTypeFactory: ");
        eli = iSDKTypeFactory;
    }
}
