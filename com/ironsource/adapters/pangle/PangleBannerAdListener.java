package com.ironsource.adapters.pangle;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.ironsource.C3355vf;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PangleBannerAdListener.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ironsource/adapters/pangle/PangleBannerAdListener;", "Lcom/bytedance/sdk/openadsdk/api/banner/PAGBannerAdLoadListener;", "Lcom/bytedance/sdk/openadsdk/api/banner/PAGBannerAdInteractionListener;", "mListener", "Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;", "mAdapter", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/adapters/pangle/PangleAdapter;", "mSlotId", "", "mLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "(Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;Ljava/lang/ref/WeakReference;Ljava/lang/String;Landroid/widget/FrameLayout$LayoutParams;)V", C3355vf.f, "", "onAdDismissed", C3355vf.j, "bannerAd", "Lcom/bytedance/sdk/openadsdk/api/banner/PAGBannerAd;", "onAdShowed", "onError", "code", "", PglCryptUtils.KEY_MESSAGE, "pangleadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PangleBannerAdListener implements PAGBannerAdLoadListener, PAGBannerAdInteractionListener {
    private final WeakReference<PangleAdapter> mAdapter;
    private final FrameLayout.LayoutParams mLayoutParams;
    private final BannerSmashListener mListener;
    private final String mSlotId;

    public PangleBannerAdListener(BannerSmashListener bannerSmashListener, WeakReference<PangleAdapter> weakReference, String mSlotId, FrameLayout.LayoutParams mLayoutParams) {
        Intrinsics.checkNotNullParameter(mSlotId, "mSlotId");
        Intrinsics.checkNotNullParameter(mLayoutParams, "mLayoutParams");
        this.mListener = bannerSmashListener;
        this.mAdapter = weakReference;
        this.mSlotId = mSlotId;
        this.mLayoutParams = mLayoutParams;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    public void onAdLoaded(PAGBannerAd bannerAd) {
        PangleAdapter pangleAdapter;
        Intrinsics.checkNotNullParameter(bannerAd, "bannerAd");
        IronLog.ADAPTER_CALLBACK.verbose("slotId = " + this.mSlotId);
        WeakReference<PangleAdapter> weakReference = this.mAdapter;
        if (weakReference != null && (pangleAdapter = weakReference.get()) != null) {
            pangleAdapter.setBannerAd$pangleadapter_release(this.mSlotId, bannerAd);
        }
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdLoaded(bannerAd.getBannerView(), this.mLayoutParams);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.MGA
    public void onError(int code, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        IronLog.ADAPTER_CALLBACK.verbose("slotId = " + this.mSlotId + ", error code = " + code + ", message = " + message);
        if (code == 20001) {
            code = 606;
        }
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdLoadFailed(new IronSourceError(code, message));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdShowed() {
        IronLog.ADAPTER_CALLBACK.verbose("slotId = " + this.mSlotId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdShown();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose("slotId = " + this.mSlotId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdDismissed() {
        IronLog.ADAPTER_CALLBACK.verbose("slotId = " + this.mSlotId);
    }
}
