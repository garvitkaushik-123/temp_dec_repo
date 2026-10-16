package com.ironsource.mediationsdk.adunit.adapter.listener;

import java.util.Map;

/* loaded from: classes6.dex */
public interface NetworkInitializationListener {
    void onInitFailed(int i, String str);

    default void onInitFailed(int i, String str, Map<String, Object> map) {
        onInitFailed(i, str);
    }

    void onInitSuccess();

    default void onInitSuccess(Map<String, Object> map) {
        onInitSuccess();
    }
}
