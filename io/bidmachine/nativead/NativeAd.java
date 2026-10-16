package io.bidmachine.nativead;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import io.bidmachine.AdProcessCallback;
import io.bidmachine.AdsType;
import io.bidmachine.BidMachineAd;
import io.bidmachine.ContextProvider;
import io.bidmachine.ImageData;
import io.bidmachine.NetworkAdapter;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.nativead.view.NativeMediaView;
import io.bidmachine.unified.UnifiedNativeAd;
import io.bidmachine.unified.UnifiedNativeAdRequestParams;
import java.util.Set;

/* loaded from: classes6.dex */
public final class NativeAd extends BidMachineAd<NativeAd, NativeRequest, NativeAdObject, AdObjectParams, UnifiedNativeAdRequestParams, NativeListener> implements NativePublicData, NativeContainer {
    @Override // io.bidmachine.BidMachineAd
    public boolean isDuplicateShowDisabled() {
        return false;
    }

    public NativeAd(Context context) {
        super(context, AdsType.Native);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.BidMachineAd
    public NativeAdObject createAdObject(ContextProvider contextProvider, NativeRequest adRequest, NetworkAdapter adapter, AdObjectParams adObjectParams, AdProcessCallback processCallback) {
        UnifiedNativeAd createNativeAd = adapter.createNativeAd();
        if (createNativeAd == null) {
            return null;
        }
        return new NativeAdObject(contextProvider, processCallback, adRequest, adObjectParams, createNativeAd);
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public String getTitle() {
        if (hasLoadedObject()) {
            return getLoadedAdObject().getTitle();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public String getDescription() {
        if (hasLoadedObject()) {
            return getLoadedAdObject().getDescription();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public String getCallToAction() {
        if (hasLoadedObject()) {
            return getLoadedAdObject().getCallToAction();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public float getRating() {
        if (hasLoadedObject()) {
            return getLoadedAdObject().getRating();
        }
        return -1.0f;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public ImageData getIcon() {
        if (hasLoadedObject()) {
            return getLoadedAdObject().getIcon();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public ImageData getMainImage() {
        if (hasLoadedObject()) {
            return getLoadedAdObject().getMainImage();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public boolean hasVideo() {
        return hasLoadedObject() && getLoadedAdObject().hasVideo();
    }

    @Override // io.bidmachine.nativead.NativeContainer
    public View getProviderView(Context context) {
        if (hasLoadedObject()) {
            return getLoadedAdObject().getProviderView(context);
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativeContainer
    public void registerView(ViewGroup nativeAdView, View iconView, NativeMediaView nativeMediaView, Set<View> clickableViews) {
        NativeAdObject prepareShow = prepareShow();
        if (prepareShow == null) {
            return;
        }
        prepareShow.registerView(nativeAdView, iconView, nativeMediaView, clickableViews, this.rendererConfiguration);
    }

    @Override // io.bidmachine.nativead.NativeContainer
    public void unregisterView() {
        if (hasLoadedObject()) {
            getLoadedAdObject().unregisterView();
        }
    }

    @Override // io.bidmachine.nativead.NativeContainer
    public boolean isViewRegistered() {
        return hasLoadedObject() && getLoadedAdObject().isViewRegistered();
    }

    public NativePublicData getAdData() {
        return getLoadedAdObject();
    }

    private boolean hasLoadedObject() {
        if (getLoadedAdObject() != null) {
            return true;
        }
        log("not loaded, please load ads first");
        return false;
    }
}
