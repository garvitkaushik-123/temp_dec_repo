package com.google.android.gms.internal.ads;

import io.bidmachine.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzajw implements zzakc {
    private final zzakb zza;
    private final long zzb;
    private final long zzc;
    private final zzakh zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzajw(zzakh zzakhVar, long j, long j2, long j3, long j4, boolean z) {
        zzdd.zzd(j >= 0 && j2 > j);
        this.zzd = zzakhVar;
        this.zzb = j;
        this.zzc = j2;
        if (j3 == j2 - j || z) {
            this.zzf = j4;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzakb();
    }

    @Override // com.google.android.gms.internal.ads.zzakc
    public final /* bridge */ /* synthetic */ zzaeu zze() {
        zzajv zzajvVar = null;
        if (this.zzf != 0) {
            return new zzaju(this, zzajvVar);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzakc
    public final void zzg(long j) {
        long j2 = this.zzf - 1;
        String str = zzex.zza;
        this.zzh = Math.max(0L, Math.min(j, j2));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0L;
        this.zzl = this.zzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bc  */
    @Override // com.google.android.gms.internal.ads.zzakc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long zzd(zzadw zzadwVar) throws IOException {
        long j;
        long j2;
        long max;
        int i = this.zze;
        if (i == 0) {
            long zzf = zzadwVar.zzf();
            this.zzg = zzf;
            this.zze = 1;
            long j3 = this.zzc - 65307;
            if (j3 > zzf) {
                return j3;
            }
        } else if (i != 1) {
            if (i == 2) {
                long j4 = this.zzi;
                long j5 = this.zzj;
                if (j4 == j5) {
                    max = -1;
                    j2 = -1;
                } else {
                    long zzf2 = zzadwVar.zzf();
                    zzakb zzakbVar = this.zza;
                    if (zzakbVar.zzc(zzadwVar, j5)) {
                        zzakbVar.zzb(zzadwVar, false);
                        zzadwVar.zzj();
                        long j6 = this.zzh;
                        j = 2;
                        long j7 = zzakbVar.zzb;
                        long j8 = j6 - j7;
                        int i2 = zzakbVar.zzd + zzakbVar.zze;
                        if (j8 < 0 || j8 >= 72000) {
                            if (j8 < 0) {
                                this.zzj = zzf2;
                                this.zzl = j7;
                            } else {
                                this.zzi = zzadwVar.zzf() + i2;
                                this.zzk = j7;
                            }
                            long j9 = this.zzj;
                            long j10 = this.zzi;
                            long j11 = j9 - j10;
                            if (j11 < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) {
                                this.zzj = j10;
                                j2 = -1;
                                max = j10;
                            } else {
                                long zzf3 = zzadwVar.zzf() - (i2 * (j8 <= 0 ? 2L : 1L));
                                j2 = -1;
                                String str = zzex.zza;
                                max = Math.max(j10, Math.min(zzf3 + ((j8 * j11) / (this.zzl - this.zzk)), j9 - 1));
                            }
                        } else {
                            max = -1;
                            j2 = -1;
                        }
                        if (max == j2) {
                            return max;
                        }
                        this.zze = 3;
                    } else {
                        max = this.zzi;
                        if (max == zzf2) {
                            throw new IOException("No ogg page can be found.");
                        }
                        j2 = -1;
                    }
                }
                j = 2;
                if (max == j2) {
                }
            } else {
                if (i != 3) {
                    return -1L;
                }
                j2 = -1;
                j = 2;
            }
            while (true) {
                zzakb zzakbVar2 = this.zza;
                zzakbVar2.zzc(zzadwVar, j2);
                zzakbVar2.zzb(zzadwVar, false);
                if (zzakbVar2.zzb > this.zzh) {
                    zzadwVar.zzj();
                    this.zze = 4;
                    return -(this.zzk + j);
                }
                zzadwVar.zzk(zzakbVar2.zzd + zzakbVar2.zze);
                this.zzi = zzadwVar.zzf();
                this.zzk = zzakbVar2.zzb;
                j2 = -1;
            }
        }
        zzakb zzakbVar3 = this.zza;
        zzakbVar3.zza();
        if (!zzakbVar3.zzc(zzadwVar, -1L)) {
            throw new EOFException();
        }
        zzakbVar3.zzb(zzadwVar, false);
        zzadwVar.zzk(zzakbVar3.zzd + zzakbVar3.zze);
        long j12 = zzakbVar3.zzb;
        while ((zzakbVar3.zza & 4) != 4 && zzakbVar3.zzc(zzadwVar, -1L) && zzadwVar.zzf() < this.zzc && zzakbVar3.zzb(zzadwVar, true) && zzadz.zzf(zzadwVar, zzakbVar3.zzd + zzakbVar3.zze)) {
            j12 = zzakbVar3.zzb;
        }
        this.zzf = j12;
        this.zze = 4;
        return this.zzg;
    }
}
