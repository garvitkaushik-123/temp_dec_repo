package io.bidmachine.nativead;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import io.bidmachine.nativead.view.NativeMediaView;
import java.util.Set;

/* loaded from: classes6.dex */
public interface NativeContainer {
    View getProviderView(Context context);

    boolean isViewRegistered();

    void registerView(ViewGroup nativeAdView, View iconView, NativeMediaView nativeMediaView, Set<View> clickableViews);

    void unregisterView();
}
