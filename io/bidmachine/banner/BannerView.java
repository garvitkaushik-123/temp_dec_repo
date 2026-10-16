package io.bidmachine.banner;

import android.content.Context;
import android.util.AttributeSet;
import io.bidmachine.AdView;
import io.bidmachine.ViewAdObject;
import io.bidmachine.unified.UnifiedBannerAd;
import io.bidmachine.unified.UnifiedBannerAdRequestParams;

/* loaded from: classes7.dex */
public class BannerView extends AdView<BannerView, BannerAd, BannerRequest, ViewAdObject<BannerRequest, UnifiedBannerAd, UnifiedBannerAdRequestParams>, BannerListener> {
    public BannerView(Context context) {
        super(context);
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BannerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.AdView
    public BannerAd createAd(Context context) {
        return new BannerAd(context);
    }
}
