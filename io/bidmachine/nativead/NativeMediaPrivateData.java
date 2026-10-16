package io.bidmachine.nativead;

import android.graphics.Bitmap;
import android.net.Uri;
import io.bidmachine.iab.vast.VastRequest;

/* loaded from: classes6.dex */
public interface NativeMediaPrivateData extends NativeMediaPublicData {
    VastRequest getVastRequest();

    void setIconBitmap(Bitmap bitmap);

    void setIconUri(Uri uri);

    void setImageBitmap(Bitmap bitmap);

    void setImageUri(Uri uri);

    void setVastRequest(VastRequest vastModel);

    void setVideoUri(Uri uri);
}
