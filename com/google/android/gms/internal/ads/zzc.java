package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.os.Build;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzc {
    public final AudioAttributes zza;

    /* synthetic */ zzc(zze zzeVar, zzd zzdVar) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
        if (Build.VERSION.SDK_INT >= 29) {
            usage.setAllowedCapturePolicy(1);
        }
        if (Build.VERSION.SDK_INT >= 32) {
            usage.setSpatializationBehavior(0);
        }
        this.zza = usage.build();
    }
}
