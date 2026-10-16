package com.google.android.gms.internal.ads;

import io.bidmachine.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaoe implements zzadf {
    private final zzeu zza;
    private final zzen zzb = new zzen();
    private final int zzc;

    public zzaoe(int i, zzeu zzeuVar, int i2) {
        this.zzc = i;
        this.zza = zzeuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final zzade zza(zzadw zzadwVar, long j) throws IOException {
        int zza;
        int zza2;
        long zzf = zzadwVar.zzf();
        int min = (int) Math.min(112800L, zzadwVar.zzd() - zzf);
        zzen zzenVar = this.zzb;
        zzenVar.zzI(min);
        zzadwVar.zzh(zzenVar.zzN(), 0, min);
        int zzd = zzenVar.zzd();
        long j2 = -1;
        long j3 = -9223372036854775807L;
        long j4 = -1;
        while (zzenVar.zza() >= 188 && (zza2 = (zza = zzaop.zza(zzenVar.zzN(), zzenVar.zzc(), zzd)) + 188) <= zzd) {
            long zzb = zzaop.zzb(zzenVar, zza, this.zzc);
            if (zzb != -9223372036854775807L) {
                long zzb2 = this.zza.zzb(zzb);
                if (zzb2 > j) {
                    return j3 == -9223372036854775807L ? zzade.zzd(zzb2, zzf) : zzade.zze(zzf + j4);
                }
                j4 = zza;
                if (SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US + zzb2 > j) {
                    return zzade.zze(zzf + j4);
                }
                j3 = zzb2;
            }
            zzenVar.zzL(zza2);
            j2 = zza2;
        }
        return j3 != -9223372036854775807L ? zzade.zzf(j3, zzf + j2) : zzade.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzb() {
        byte[] bArr = zzex.zzb;
        int length = bArr.length;
        this.zzb.zzJ(bArr, 0);
    }
}
