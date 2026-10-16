package io.bidmachine.nativead.view;

import android.view.ViewGroup;

/* loaded from: classes6.dex */
public class NativeAdContainerBridge {
    public static void configureContainer(NativeAdContainer nativeAdContainer, ViewGroup adContainer) {
        nativeAdContainer.configureContainer(adContainer);
    }

    public static void deConfigureContainer(NativeAdContainer nativeAdContainer) {
        nativeAdContainer.deConfigureContainer();
    }
}
