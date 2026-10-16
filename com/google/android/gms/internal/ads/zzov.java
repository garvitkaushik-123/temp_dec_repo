package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzov {
    final /* synthetic */ zzow zza;
    private final String zzb;
    private int zzc;
    private long zzd;
    private zzvh zze;
    private boolean zzf;
    private boolean zzg;

    public zzov(zzow zzowVar, String str, int i, zzvh zzvhVar) {
        Objects.requireNonNull(zzowVar);
        this.zza = zzowVar;
        this.zzb = str;
        this.zzc = i;
        this.zzd = zzvhVar == null ? -1L : zzvhVar.zzd;
        if (zzvhVar == null || !zzvhVar.zzb()) {
            return;
        }
        this.zze = zzvhVar;
    }

    public final void zzg(int i, zzvh zzvhVar) {
        long zzl;
        if (this.zzd == -1 && i == this.zzc && zzvhVar != null) {
            zzow zzowVar = this.zza;
            long j = zzvhVar.zzd;
            zzl = zzowVar.zzl();
            if (j >= zzl) {
                this.zzd = j;
            }
        }
    }

    public final boolean zzj(int i, zzvh zzvhVar) {
        if (zzvhVar == null) {
            return i == this.zzc;
        }
        zzvh zzvhVar2 = this.zze;
        return zzvhVar2 == null ? !zzvhVar.zzb() && zzvhVar.zzd == this.zzd : zzvhVar.zzd == zzvhVar2.zzd && zzvhVar.zzb == zzvhVar2.zzb && zzvhVar.zzc == zzvhVar2.zzc;
    }

    public final boolean zzk(zzmp zzmpVar) {
        zzvh zzvhVar = zzmpVar.zzd;
        if (zzvhVar == null) {
            return this.zzc != zzmpVar.zzc;
        }
        long j = this.zzd;
        if (j == -1) {
            return false;
        }
        long j2 = zzvhVar.zzd;
        if (j2 > j) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        zzbl zzblVar = zzmpVar.zzb;
        int zza = zzblVar.zza(zzvhVar.zza);
        int zza2 = zzblVar.zza(this.zze.zza);
        zzvh zzvhVar2 = this.zze;
        if (j2 < zzvhVar2.zzd || zza < zza2) {
            return false;
        }
        if (zza > zza2) {
            return true;
        }
        if (!zzvhVar.zzb()) {
            int i = zzvhVar.zze;
            return i == -1 || i > zzvhVar2.zzb;
        }
        int i2 = zzvhVar.zzb;
        int i3 = zzvhVar.zzc;
        int i4 = zzvhVar2.zzb;
        if (i2 <= i4) {
            return i2 == i4 && i3 > zzvhVar2.zzc;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r0 < r9.zzc()) goto L15;
     */
    /* JADX WARN: Incorrect condition in loop: B:19:0x002a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzl(zzbl zzblVar, zzbl zzblVar2) {
        zzbk zzbkVar;
        zzbk zzbkVar2;
        zzbk zzbkVar3;
        zzbj zzbjVar;
        int i = this.zzc;
        if (i < zzblVar.zzc()) {
            zzow zzowVar = this.zza;
            zzbkVar = zzowVar.zzc;
            zzblVar.zze(i, zzbkVar, 0L);
            zzbkVar2 = zzowVar.zzc;
            for (int i2 = zzbkVar2.zzn; i2 <= zzbkVar3.zzo; i2++) {
                int zza = zzblVar2.zza(zzblVar.zzf(i2));
                if (zza != -1) {
                    zzbjVar = zzowVar.zzd;
                    i = zzblVar2.zzd(zza, zzbjVar, false).zzc;
                    break;
                }
            }
            i = -1;
        }
        this.zzc = i;
        if (i == -1) {
            return false;
        }
        zzvh zzvhVar = this.zze;
        return zzvhVar == null || zzblVar2.zza(zzvhVar.zza) != -1;
    }
}
