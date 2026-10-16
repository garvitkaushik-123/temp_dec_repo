package com.ironsource.mediationsdk.adunit.adapter.internal.listener;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import java.util.Map;

/* loaded from: classes6.dex */
public interface AdapterAdListener {
    void onAdClicked();

    default void onAdClicked(Map<String, Object> map) {
        onAdClicked();
    }

    void onAdLoadFailed(AdapterErrorType adapterErrorType, int i, String str);

    default void onAdLoadFailed(AdapterErrorType adapterErrorType, int i, String str, Map<String, Object> map) {
        onAdLoadFailed(adapterErrorType, i, str);
    }

    void onAdLoadSuccess();

    default void onAdLoadSuccess(Map<String, Object> map) {
        onAdLoadSuccess();
    }

    void onAdOpened();

    default void onAdOpened(Map<String, Object> map) {
        onAdOpened();
    }
}
