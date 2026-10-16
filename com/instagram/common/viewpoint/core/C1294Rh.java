package com.instagram.common.viewpoint.core;

import android.content.Context;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.api.AudienceNetworkAdsApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoader;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;

/* renamed from: com.facebook.ads.redexgen.X.Rh, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1294Rh implements AudienceNetworkAdsApi {
    @Override // com.facebook.ads.internal.api.AudienceNetworkAdsApi
    public final int getAdFormatForPlacement(String str) {
        WU.A02(this);
        return 0;
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkAdsApi
    public final void initialize(Context context, MultithreadedBundleWrapper initSettings, AudienceNetworkAds.InitListener initListener) {
        if (WU.A02(this)) {
            return;
        }
        if (initListener == null) {
            try {
                initListener = new C1293Rg(this);
            } catch (Throwable th) {
                WU.A00(th, this);
                return;
            }
        }
        DynamicLoaderFactory.makeLoader(context).getInitApi().initialize(context, initSettings, initListener, 1);
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkAdsApi
    public final boolean isInitialized() {
        if (WU.A02(this)) {
            return false;
        }
        try {
            DynamicLoader dynamicLoader = DynamicLoaderFactory.getDynamicLoader();
            if (dynamicLoader == null) {
                return false;
            }
            return dynamicLoader.getInitApi().isInitialized();
        } catch (Throwable th) {
            WU.A00(th, this);
            return false;
        }
    }

    @Override // com.facebook.ads.internal.api.AudienceNetworkAdsApi
    public final void onContentProviderCreated(Context context) {
        if (WU.A02(this)) {
            return;
        }
        try {
            DynamicLoaderFactory.makeLoader(context).getInitApi().onContentProviderCreated(context);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
