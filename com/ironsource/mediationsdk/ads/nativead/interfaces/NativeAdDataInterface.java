package com.ironsource.mediationsdk.ads.nativead.interfaces;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* loaded from: classes6.dex */
public interface NativeAdDataInterface {

    public static class Image {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable f3497a;
        private final Uri b;

        public Image(Drawable drawable, Uri uri) {
            this.f3497a = drawable;
            this.b = uri;
        }

        public final Drawable getDrawable() {
            return this.f3497a;
        }

        public final Uri getUri() {
            return this.b;
        }
    }

    String getAdvertiser();

    String getBody();

    String getCallToAction();

    Image getIcon();

    String getTitle();
}
