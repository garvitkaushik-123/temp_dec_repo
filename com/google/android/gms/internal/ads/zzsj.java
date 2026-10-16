package com.google.android.gms.internal.ads;

import android.os.Build;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzsj {
    public static final boolean zza;

    static {
        boolean z = false;
        if ("Amazon".equals(Build.MANUFACTURER) && ("AFTM".equals(Build.MODEL) || "AFTB".equals(Build.MODEL))) {
            z = true;
        }
        zza = z;
    }
}
