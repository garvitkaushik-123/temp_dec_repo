package com.moloco.sdk.publisher;

import android.net.Uri;
import android.view.View;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0010\u0011J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/moloco/sdk/publisher/NativeAd;", "Lcom/moloco/sdk/publisher/AdLoad;", "Lcom/moloco/sdk/publisher/Destroyable;", "assets", "Lcom/moloco/sdk/publisher/NativeAd$Assets;", "getAssets", "()Lcom/moloco/sdk/publisher/NativeAd$Assets;", "handleImpression", "", "handleGeneralAdClick", "interactionListener", "Lcom/moloco/sdk/publisher/NativeAd$InteractionListener;", "getInteractionListener", "()Lcom/moloco/sdk/publisher/NativeAd$InteractionListener;", "setInteractionListener", "(Lcom/moloco/sdk/publisher/NativeAd$InteractionListener;)V", "InteractionListener", "Assets", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface NativeAd extends AdLoad, Destroyable {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/moloco/sdk/publisher/NativeAd$Assets;", "", "title", "", "getTitle", "()Ljava/lang/String;", "description", "getDescription", "sponsorText", "getSponsorText", "callToActionText", "getCallToActionText", "rating", "", "getRating", "()Ljava/lang/Float;", "iconUri", "Landroid/net/Uri;", "getIconUri", "()Landroid/net/Uri;", "mediaView", "Landroid/view/View;", "getMediaView", "()Landroid/view/View;", "mainImageUri", "getMainImageUri", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Assets {
        String getCallToActionText();

        String getDescription();

        Uri getIconUri();

        Uri getMainImageUri();

        View getMediaView();

        Float getRating();

        String getSponsorText();

        String getTitle();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/moloco/sdk/publisher/NativeAd$InteractionListener;", "", "onImpressionHandled", "", "onGeneralClickHandled", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface InteractionListener {
        void onGeneralClickHandled();

        void onImpressionHandled();
    }

    Assets getAssets();

    InteractionListener getInteractionListener();

    void handleGeneralAdClick();

    void handleImpression();

    void setInteractionListener(InteractionListener interactionListener);
}
