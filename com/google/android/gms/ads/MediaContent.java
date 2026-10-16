package com.google.android.gms.ads;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.ads.zzbhj;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public interface MediaContent {
    float getAspectRatio();

    float getCurrentTime();

    float getDuration();

    Drawable getMainImage();

    VideoController getVideoController();

    boolean hasVideoContent();

    void setMainImage(Drawable drawable);

    zzbhj zza();

    boolean zzb();
}
