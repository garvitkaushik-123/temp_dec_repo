package com.ironsource.adapters.admob.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.vungle.ads.internal.protos.Sdk;

/* loaded from: classes6.dex */
public class AdMobNativeBannerViewHandler {
    private final NativeAdView mAdView;
    private FrameLayout.LayoutParams mLayoutParams;
    private NativeTemplateType mTemplateType;

    public AdMobNativeBannerViewHandler(ISBannerSize iSBannerSize, NativeTemplateType nativeTemplateType, Context context) {
        this.mTemplateType = nativeTemplateType;
        String description = iSBannerSize.getDescription();
        description.hashCode();
        switch (description) {
            case "RECTANGLE":
                this.mLayoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, 300), AdapterUtils.dpToPixels(context, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
                break;
            case "LARGE":
                this.mLayoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(context, 90));
                break;
            case "SMART":
            case "BANNER":
                this.mLayoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(context, 50));
                break;
        }
        this.mLayoutParams.gravity = 17;
        this.mAdView = (NativeAdView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(this.mTemplateType.getLayoutId(), (ViewGroup) null);
    }

    public FrameLayout.LayoutParams getLayoutParams() {
        return this.mLayoutParams;
    }

    public NativeAdView getNativeAdView() {
        return this.mAdView;
    }
}
