package com.google.android.gms.internal.ads;

import io.bidmachine.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzanu implements zzadf {
    private final zzeu zza;
    private final zzen zzb = new zzen();

    /* synthetic */ zzanu(zzeu zzeuVar, zzanv zzanvVar) {
        this.zza = zzeuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final zzade zza(zzadw zzadwVar, long j) throws IOException {
        int zzh;
        long zzf = zzadwVar.zzf();
        int min = (int) Math.min(20000L, zzadwVar.zzd() - zzf);
        zzen zzenVar = this.zzb;
        zzenVar.zzI(min);
        zzadwVar.zzh(zzenVar.zzN(), 0, min);
        int i = -1;
        int i2 = -1;
        long j2 = -9223372036854775807L;
        while (zzenVar.zza() >= 4) {
            if (zzanw.zzh(zzenVar.zzN(), zzenVar.zzc()) != 442) {
                zzenVar.zzM(1);
            } else {
                zzenVar.zzM(4);
                long zzc = zzanx.zzc(zzenVar);
                if (zzc != -9223372036854775807L) {
                    long zzb = this.zza.zzb(zzc);
                    if (zzb > j) {
                        return j2 == -9223372036854775807L ? zzade.zzd(zzb, zzf) : zzade.zze(zzf + i2);
                    }
                    if (SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US + zzb > j) {
                        return zzade.zze(zzf + zzenVar.zzc());
                    }
                    i2 = zzenVar.zzc();
                    j2 = zzb;
                }
                int zzd = zzenVar.zzd();
                if (zzenVar.zza() >= 10) {
                    zzenVar.zzM(9);
                    int zzm = zzenVar.zzm() & 7;
                    if (zzenVar.zza() >= zzm) {
                        zzenVar.zzM(zzm);
                        if (zzenVar.zza() >= 4) {
                            if (zzanw.zzh(zzenVar.zzN(), zzenVar.zzc()) == 443) {
                                zzenVar.zzM(4);
                                int zzq = zzenVar.zzq();
                                if (zzenVar.zza() < zzq) {
                                    zzenVar.zzL(zzd);
                                } else {
                                    zzenVar.zzM(zzq);
                                }
                            }
                            while (true) {
                                if (zzenVar.zza() < 4 || (zzh = zzanw.zzh(zzenVar.zzN(), zzenVar.zzc())) == 442 || zzh == 441 || (zzh >>> 8) != 1) {
                                    break;
                                }
                                zzenVar.zzM(4);
                                if (zzenVar.zza() < 2) {
                                    zzenVar.zzL(zzd);
                                    break;
                                }
                                zzenVar.zzL(Math.min(zzenVar.zzd(), zzenVar.zzc() + zzenVar.zzq()));
                            }
                        } else {
                            zzenVar.zzL(zzd);
                        }
                    } else {
                        zzenVar.zzL(zzd);
                    }
                } else {
                    zzenVar.zzL(zzd);
                }
                i = zzenVar.zzc();
            }
        }
        return j2 != -9223372036854775807L ? zzade.zzf(j2, zzf + i) : zzade.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzb() {
        byte[] bArr = zzex.zzb;
        int length = bArr.length;
        this.zzb.zzJ(bArr, 0);
    }
}
