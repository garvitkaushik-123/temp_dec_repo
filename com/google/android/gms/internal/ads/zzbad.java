package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes5.dex */
public final class zzbad {
    private final float zza;
    private final float zzb;
    private final float zzc;
    private final float zzd;
    private final int zze;

    public zzbad(float f, float f2, float f3, float f4, int i) {
        this.zza = f;
        this.zzb = f2;
        this.zzc = f + f3;
        this.zzd = f2 + f4;
        this.zze = i;
    }

    final float zza() {
        return this.zzd;
    }

    final float zzb() {
        return this.zza;
    }

    final float zzc() {
        return this.zzc;
    }

    final float zzd() {
        return this.zzb;
    }

    final int zze() {
        return this.zze;
    }
}
