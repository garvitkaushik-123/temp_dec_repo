package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbca {
    private final InputStream zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private final boolean zze;

    private zzbca(InputStream inputStream, boolean z, boolean z2, long j, boolean z3) {
        this.zza = inputStream;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = j;
        this.zze = z3;
    }

    public static zzbca zzb(InputStream inputStream, boolean z, boolean z2, long j, boolean z3) {
        return new zzbca(inputStream, z, z2, j, z3);
    }

    public final long zza() {
        return this.zzd;
    }

    public final InputStream zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzb;
    }

    public final boolean zze() {
        return this.zze;
    }

    public final boolean zzf() {
        return this.zzc;
    }
}
