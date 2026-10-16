package io.bidmachine;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* loaded from: classes7.dex */
public class ImageDataImpl implements ImageData {
    private Drawable image;
    private Uri localUri;
    private String remoteUrl;

    public ImageDataImpl() {
    }

    public ImageDataImpl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public ImageDataImpl(Drawable image) {
        this.image = image;
    }

    public ImageDataImpl(ImageData imageData) {
        if (imageData != null) {
            this.remoteUrl = imageData.getRemoteUrl();
            this.image = imageData.getImage();
            this.localUri = imageData.getLocalUri();
        }
    }

    @Override // io.bidmachine.ImageData
    public String getRemoteUrl() {
        return this.remoteUrl;
    }

    public ImageDataImpl setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
        return this;
    }

    @Override // io.bidmachine.ImageData
    public Drawable getImage() {
        return this.image;
    }

    public ImageDataImpl setImage(Drawable image) {
        this.image = image;
        return this;
    }

    @Override // io.bidmachine.ImageData
    public Uri getLocalUri() {
        return this.localUri;
    }

    public ImageDataImpl setLocalUri(Uri localUri) {
        this.localUri = localUri;
        return this;
    }

    public void destroy() {
        this.remoteUrl = null;
        this.image = null;
        this.localUri = null;
    }
}
