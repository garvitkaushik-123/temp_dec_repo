package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzuk implements zzwz {
    public final zzwz zza;
    final /* synthetic */ zzul zzb;
    private boolean zzc;

    public zzuk(zzul zzulVar, zzwz zzwzVar) {
        Objects.requireNonNull(zzulVar);
        this.zzb = zzulVar;
        this.zza = zzwzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final int zza(zzkv zzkvVar, zzhs zzhsVar, int i) {
        zzul zzulVar = this.zzb;
        if (zzulVar.zzq()) {
            return -3;
        }
        if (this.zzc) {
            zzhsVar.zzc(4);
            return -4;
        }
        long zzb = zzulVar.zzb();
        int zza = this.zza.zza(zzkvVar, zzhsVar, i);
        if (zza != -5) {
            long j = zzulVar.zzb;
            if (j == Long.MIN_VALUE || ((zza != -4 || zzhsVar.zze < j) && !(zza == -3 && zzb == Long.MIN_VALUE && !zzhsVar.zzd))) {
                return zza;
            }
            zzhsVar.zzb();
            zzhsVar.zzc(4);
            this.zzc = true;
            return -4;
        }
        zzz zzzVar = zzkvVar.zza;
        zzzVar.getClass();
        int i2 = zzzVar.zzJ;
        if (i2 == 0) {
            if (zzzVar.zzK != 0) {
                i2 = 0;
            }
            return -5;
        }
        int i3 = zzulVar.zzb == Long.MIN_VALUE ? zzzVar.zzK : 0;
        zzx zzb2 = zzzVar.zzb();
        zzb2.zzM(i2);
        zzb2.zzN(i3);
        zzkvVar.zza = zzb2.zzan();
        return -5;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final int zzb(long j) {
        if (this.zzb.zzq()) {
            return -3;
        }
        return this.zza.zzb(j);
    }

    public final void zzc() {
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final boolean zze() {
        return !this.zzb.zzq() && this.zza.zze();
    }
}
