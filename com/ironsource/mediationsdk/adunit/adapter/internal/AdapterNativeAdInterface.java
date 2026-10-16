package com.ironsource.mediationsdk.adunit.adapter.internal;

import android.app.Activity;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;

/* loaded from: classes6.dex */
public interface AdapterNativeAdInterface<Listener extends AdapterAdListener> {
    void destroyAd(AdData adData);

    void loadAd(AdData adData, Activity activity, Listener listener);
}
