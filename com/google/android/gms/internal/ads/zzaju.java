package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaju implements zzaeu {
    final /* synthetic */ zzajw zza;

    /* synthetic */ zzaju(zzajw zzajwVar, zzajv zzajvVar) {
        Objects.requireNonNull(zzajwVar);
        this.zza = zzajwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        zzakh zzakhVar;
        long j;
        zzajw zzajwVar = this.zza;
        zzakhVar = zzajwVar.zzd;
        j = zzajwVar.zzf;
        return zzakhVar.zzf(j);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        zzakh zzakhVar;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        zzajw zzajwVar = this.zza;
        zzakhVar = zzajwVar.zzd;
        long zzg = zzakhVar.zzg(j);
        j2 = zzajwVar.zzb;
        BigInteger valueOf = BigInteger.valueOf(zzg);
        j3 = zzajwVar.zzc;
        j4 = zzajwVar.zzb;
        BigInteger multiply = valueOf.multiply(BigInteger.valueOf(j3 - j4));
        j5 = zzajwVar.zzf;
        long longValue = j2 + multiply.divide(BigInteger.valueOf(j5)).longValue();
        j6 = zzajwVar.zzb;
        j7 = zzajwVar.zzc;
        String str = zzex.zza;
        zzaev zzaevVar = new zzaev(j, Math.max(j6, Math.min(longValue - 30000, j7 - 1)));
        return new zzaes(zzaevVar, zzaevVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return true;
    }
}
