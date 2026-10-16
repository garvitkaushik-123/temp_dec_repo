package io.bidmachine.nativead;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import io.bidmachine.ImageData;
import io.bidmachine.LabelData;
import io.bidmachine.PrivacySheetData;
import io.bidmachine.nativead.view.NativeAdOverlayContainer;
import io.bidmachine.nativead.view.NativeMediaView;
import java.util.Set;

/* loaded from: classes6.dex */
public class NativeNetworkAdapter implements NativeData {
    private LabelData adLabelData;
    private String callToAction;
    private String clickUrl;
    private String description;
    private boolean hasVideo;
    private ImageData iconImageData;
    private ImageData mainImageData;
    private PrivacySheetData privacySheetData;
    private String title;
    private String videoAdm;
    private String videoUrl;
    private float rating = -1.0f;
    private boolean isNetworkControlLoadingAssets = true;

    public ViewGroup configureContainer(Context context) {
        return null;
    }

    public View createCustomMediaView(Context context) {
        return null;
    }

    public void destroy() {
    }

    public void registerNative(ViewGroup container, ImageView iconView, NativeMediaView nativeMediaView, Set<View> clickableViews) {
    }

    public void unregisterNative() {
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public String getTitle() {
        return this.title;
    }

    public NativeNetworkAdapter setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public String getDescription() {
        return this.description;
    }

    public NativeNetworkAdapter setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public String getCallToAction() {
        return this.callToAction;
    }

    public NativeNetworkAdapter setCallToAction(String callToAction) {
        this.callToAction = callToAction;
        return this;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public float getRating() {
        return this.rating;
    }

    public NativeNetworkAdapter setRating(float rating) {
        this.rating = rating;
        return this;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public ImageData getIcon() {
        return this.iconImageData;
    }

    public NativeNetworkAdapter setIcon(ImageData iconImageData) {
        this.iconImageData = iconImageData;
        return this;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public ImageData getMainImage() {
        return this.mainImageData;
    }

    public NativeNetworkAdapter setMainImage(ImageData mainImageData) {
        this.mainImageData = mainImageData;
        return this;
    }

    @Override // io.bidmachine.nativead.NativeData
    public String getClickUrl() {
        return this.clickUrl;
    }

    public NativeNetworkAdapter setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
        return this;
    }

    @Override // io.bidmachine.nativead.NativeData
    public String getVideoUrl() {
        return this.videoUrl;
    }

    public NativeNetworkAdapter setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    @Override // io.bidmachine.nativead.NativeData
    public String getVideoAdm() {
        return this.videoAdm;
    }

    public NativeNetworkAdapter setVideoAdm(String videoAdm) {
        this.videoAdm = videoAdm;
        return this;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public boolean hasVideo() {
        return this.hasVideo;
    }

    public NativeNetworkAdapter setHasVideo(boolean hasVideo) {
        this.hasVideo = hasVideo;
        return this;
    }

    public boolean isNetworkControlLoadingAssets() {
        return this.isNetworkControlLoadingAssets;
    }

    public NativeNetworkAdapter setNetworkControlLoadingAssets(boolean networkControlLoadingAssets) {
        this.isNetworkControlLoadingAssets = networkControlLoadingAssets;
        return this;
    }

    @Override // io.bidmachine.nativead.NativeData
    public LabelData getAdLabelData() {
        return this.adLabelData;
    }

    public NativeNetworkAdapter setAdLabelData(LabelData adLabelData) {
        this.adLabelData = adLabelData;
        return this;
    }

    @Override // io.bidmachine.nativead.NativeData
    public PrivacySheetData getPrivacySheetData() {
        return this.privacySheetData;
    }

    public NativeNetworkAdapter setPrivacySheetData(PrivacySheetData privacySheetData) {
        this.privacySheetData = privacySheetData;
        return this;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(getTitle()) || TextUtils.isEmpty(getDescription()) || TextUtils.isEmpty(getCallToAction())) ? false : true;
    }

    public View createProviderView(Context context) {
        if (this.adLabelData == null && this.privacySheetData == null) {
            return null;
        }
        NativeAdOverlayContainer nativeAdOverlayContainer = new NativeAdOverlayContainer(context);
        nativeAdOverlayContainer.bindNativeData(this);
        nativeAdOverlayContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return nativeAdOverlayContainer;
    }
}
