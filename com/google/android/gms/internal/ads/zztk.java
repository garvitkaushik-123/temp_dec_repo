package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.os.Build;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zztk {
    private static Boolean zza;

    public static int zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (Build.VERSION.SDK_INT < 29) {
            return 0;
        }
        Boolean bool = zza;
        if (bool == null || !bool.booleanValue()) {
            return zztj.zza(videoCapabilities, i, i2, d);
        }
        return 0;
    }
}
