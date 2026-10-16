package io.bidmachine;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* loaded from: classes7.dex */
public interface ImageData {
    Drawable getImage();

    Uri getLocalUri();

    String getRemoteUrl();
}
