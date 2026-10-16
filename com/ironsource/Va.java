package com.ironsource;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;

/* loaded from: classes6.dex */
public interface Va extends NativeAdDataInterface {

    public static final class a extends NativeAdDataInterface.Image {
        public a(Drawable drawable, Uri uri) {
            super(drawable, uri);
        }
    }
}
