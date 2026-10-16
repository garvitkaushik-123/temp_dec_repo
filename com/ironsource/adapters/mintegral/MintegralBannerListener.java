package com.ironsource.adapters.mintegral;

import android.widget.FrameLayout;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.out.BannerAdWithCodeListener;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.MBridgeIds;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MintegralBannerListener.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u0011\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0016\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ironsource/adapters/mintegral/MintegralBannerListener;", "Lcom/mbridge/msdk/out/BannerAdWithCodeListener;", "placementId", "", "smashListener", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;", "adapterListener", "Lcom/ironsource/adapters/mintegral/MintegralAdapter;", "(Ljava/lang/String;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "closeFullScreen", "", "bridgeIds", "Lcom/mbridge/msdk/out/MBridgeIds;", "onClick", "onCloseBanner", "onLeaveApp", "onLoadFailedWithCode", IronSourceConstants.EVENTS_ERROR_CODE, "", "errorMsg", "onLoadSuccessed", "onLogImpression", "showFullScreen", "mintegraladapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MintegralBannerListener extends BannerAdWithCodeListener {
    private final WeakReference<MintegralAdapter> adapterListener;
    private final String placementId;
    private final WeakReference<BannerSmashListener> smashListener;

    public MintegralBannerListener(String placementId, WeakReference<BannerSmashListener> smashListener, WeakReference<MintegralAdapter> adapterListener) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        Intrinsics.checkNotNullParameter(smashListener, "smashListener");
        Intrinsics.checkNotNullParameter(adapterListener, "adapterListener");
        this.placementId = placementId;
        this.smashListener = smashListener;
        this.adapterListener = adapterListener;
    }

    @Override // com.mbridge.msdk.out.BannerAdWithCodeListener
    public void onLoadFailedWithCode(MBridgeIds bridgeIds, int errorCode, String errorMsg) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId + "  errorCode=" + errorCode + " errorMsg=" + errorMsg);
        BannerSmashListener bannerSmashListener = this.smashListener.get();
        if (bannerSmashListener != null) {
            if (errorCode == 708) {
                errorCode = 606;
            }
            bannerSmashListener.onBannerAdLoadFailed(new IronSourceError(errorCode, errorMsg));
        }
    }

    @Override // com.mbridge.msdk.out.BannerAdListener
    public void onLoadSuccessed(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
        MintegralAdapter mintegralAdapter = this.adapterListener.get();
        MBBannerView bannerView = mintegralAdapter != null ? mintegralAdapter.getBannerView(this.placementId) : null;
        MintegralAdapter mintegralAdapter2 = this.adapterListener.get();
        FrameLayout.LayoutParams bannerLayoutParams = mintegralAdapter2 != null ? mintegralAdapter2.getBannerLayoutParams(this.placementId) : null;
        BannerSmashListener bannerSmashListener = this.smashListener.get();
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdLoaded(bannerView, bannerLayoutParams);
        }
    }

    @Override // com.mbridge.msdk.out.BannerAdListener
    public void onLogImpression(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
        BannerSmashListener bannerSmashListener = this.smashListener.get();
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdShown();
        }
    }

    @Override // com.mbridge.msdk.out.BannerAdListener
    public void onClick(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
        BannerSmashListener bannerSmashListener = this.smashListener.get();
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdClicked();
        }
    }

    @Override // com.mbridge.msdk.out.BannerAdListener
    public void onLeaveApp(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
        BannerSmashListener bannerSmashListener = this.smashListener.get();
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdLeftApplication();
        }
    }

    @Override // com.mbridge.msdk.out.BannerAdListener
    public void showFullScreen(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
        BannerSmashListener bannerSmashListener = this.smashListener.get();
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdScreenPresented();
        }
    }

    @Override // com.mbridge.msdk.out.BannerAdListener
    public void closeFullScreen(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
        BannerSmashListener bannerSmashListener = this.smashListener.get();
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdScreenDismissed();
        }
    }

    @Override // com.mbridge.msdk.out.BannerAdListener
    public void onCloseBanner(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
    }
}
