package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzafx implements zzadf {
    private final zzaeg zza;
    private final int zzb;
    private final zzaeb zzc = new zzaeb();

    /* synthetic */ zzafx(zzaeg zzaegVar, int i, zzafy zzafyVar) {
        this.zza = zzaegVar;
        this.zzb = i;
    }

    private final long zzc(zzadw zzadwVar) throws IOException {
        while (zzadwVar.zze() < zzadwVar.zzd() - 6) {
            zzaeg zzaegVar = this.zza;
            int i = this.zzb;
            zzaeb zzaebVar = this.zzc;
            long zze = zzadwVar.zze();
            byte[] bArr = new byte[2];
            zzadwVar.zzh(bArr, 0, 2);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
                zzadwVar.zzj();
                zzadwVar.zzg((int) (zze - zzadwVar.zzf()));
            } else {
                zzen zzenVar = new zzen(16);
                System.arraycopy(bArr, 0, zzenVar.zzN(), 0, 2);
                zzenVar.zzK(zzadz.zzb(zzadwVar, zzenVar.zzN(), 2, 14));
                zzadwVar.zzj();
                zzadwVar.zzg((int) (zze - zzadwVar.zzf()));
                if (zzaec.zzc(zzenVar, zzaegVar, i, zzaebVar)) {
                    break;
                }
            }
            zzadwVar.zzg(1);
        }
        if (zzadwVar.zze() < zzadwVar.zzd() - 6) {
            return this.zzc.zza;
        }
        zzadwVar.zzg((int) (zzadwVar.zzd() - zzadwVar.zze()));
        return this.zza.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final zzade zza(zzadw zzadwVar, long j) throws IOException {
        long zzf = zzadwVar.zzf();
        long zzc = zzc(zzadwVar);
        long zze = zzadwVar.zze();
        zzadwVar.zzg(Math.max(6, this.zza.zzc));
        long zzc2 = zzc(zzadwVar);
        return (zzc > j || zzc2 <= j) ? zzc2 <= j ? zzade.zzf(zzc2, zzadwVar.zze()) : zzade.zzd(zzc, zzf) : zzade.zze(zze);
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final /* synthetic */ void zzb() {
    }
}
