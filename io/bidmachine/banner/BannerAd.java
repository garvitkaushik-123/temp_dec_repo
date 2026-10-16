package io.bidmachine.banner;

import android.content.Context;
import io.bidmachine.AdListener;
import io.bidmachine.AdProcessCallback;
import io.bidmachine.AdsType;
import io.bidmachine.ContextProvider;
import io.bidmachine.NetworkAdapter;
import io.bidmachine.ViewAd;
import io.bidmachine.ViewAdObject;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.unified.UnifiedBannerAd;
import io.bidmachine.unified.UnifiedBannerAdRequestParams;

/* loaded from: classes7.dex */
final class BannerAd extends ViewAd<BannerAd, BannerRequest, ViewAdObject<BannerRequest, UnifiedBannerAd, UnifiedBannerAdRequestParams>, UnifiedBannerAdRequestParams, AdListener<BannerAd>> {
    BannerAd(Context context) {
        super(context, AdsType.Banner);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.BidMachineAd
    public ViewAdObject<BannerRequest, UnifiedBannerAd, UnifiedBannerAdRequestParams> createAdObject(ContextProvider contextProvider, BannerRequest adRequest, NetworkAdapter adapter, AdObjectParams adObjectParams, AdProcessCallback processCallback) {
        UnifiedBannerAd createBanner = adapter.createBanner();
        if (createBanner == null) {
            return null;
        }
        ViewAdObject<BannerRequest, UnifiedBannerAd, UnifiedBannerAdRequestParams> viewAdObject = new ViewAdObject<>(contextProvider, processCallback, adRequest, adObjectParams, createBanner);
        BannerSize size = adRequest.getSize();
        viewAdObject.setWidth(size.width);
        viewAdObject.setHeight(size.height);
        return viewAdObject;
    }
}
