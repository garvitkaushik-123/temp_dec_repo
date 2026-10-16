package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Surface;
import com.unity3d.services.core.di.ServiceProvider;
import io.bidmachine.media3.exoplayer.audio.SilenceSkippingAudioProcessor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzabs {
    private final zzabr zza;
    private final zzabw zzb;
    private boolean zzc;
    private long zzf;
    private boolean zzi;
    private boolean zzl;
    private boolean zzm;
    private int zzd = 0;
    private long zze = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private float zzj = 1.0f;
    private zzdj zzk = zzdj.zza;

    public zzabs(Context context, zzabr zzabrVar, long j) {
        this.zza = zzabrVar;
        this.zzb = new zzabw(context);
    }

    private final void zzo(int i) {
        this.zzd = Math.min(this.zzd, i);
    }

    public final int zza(long j, long j2, long j3, long j4, boolean z, boolean z2, zzabq zzabqVar) throws zzin {
        long j5;
        boolean z3;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        zzabq.zzg(zzabqVar);
        if (this.zzc && this.zze == -9223372036854775807L) {
            this.zze = j2;
        }
        if (this.zzg != j) {
            this.zzb.zzd(j);
            this.zzg = j;
        }
        long j13 = (long) ((j - j2) / this.zzj);
        if (this.zzc) {
            j13 -= zzex.zzs(this.zzk.zzb()) - j3;
        }
        zzabqVar.zza = j13;
        if (z && !z2) {
            return 3;
        }
        if (!this.zzl) {
            this.zzm = true;
            zzabr zzabrVar = this.zza;
            j11 = zzabqVar.zza;
            if (zzabrVar.zzbc(j11, j2, j3, z2, true)) {
                return 4;
            }
            if (this.zzc) {
                j12 = zzabqVar.zza;
                if (j12 < 30000) {
                    return 3;
                }
            }
            return 5;
        }
        j5 = zzabqVar.zza;
        if (this.zzh == -9223372036854775807L || this.zzi) {
            int i = this.zzd;
            if (i == 0) {
                z3 = false;
                if (this.zzc) {
                    return 0;
                }
            } else {
                if (i == 1) {
                    return 0;
                }
                if (i == 2) {
                    z3 = false;
                    if (j2 >= j4) {
                        return 0;
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    z3 = false;
                    long zzs = zzex.zzs(this.zzk.zzb()) - this.zzf;
                    if (this.zzc) {
                        long j14 = this.zze;
                        if (j14 != -9223372036854775807L && j14 != j2 && j5 < -30000 && zzs > SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) {
                            return 0;
                        }
                    }
                }
            }
        } else {
            z3 = false;
        }
        if (!this.zzc || j2 == this.zze) {
            return 5;
        }
        long zzc = this.zzk.zzc();
        zzabw zzabwVar = this.zzb;
        j6 = zzabqVar.zza;
        zzabqVar.zzb = zzabwVar.zza((j6 * 1000) + zzc);
        j7 = zzabqVar.zzb;
        zzabqVar.zza = (j7 - zzc) / 1000;
        boolean z4 = (this.zzh == -9223372036854775807L || this.zzi) ? z3 : true;
        zzabr zzabrVar2 = this.zza;
        j8 = zzabqVar.zza;
        if (zzabrVar2.zzbc(j8, j2, j3, z2, z4)) {
            return 4;
        }
        j9 = zzabqVar.zza;
        if (j9 < -30000 && !z2) {
            return z4 ? 3 : 2;
        }
        j10 = zzabqVar.zza;
        return j10 > ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT ? 5 : 1;
    }

    public final void zzb() {
        if (this.zzd == 0) {
            this.zzd = 1;
        }
    }

    public final void zzc(boolean z) {
        this.zzi = z;
        this.zzh = -9223372036854775807L;
    }

    public final void zzd() {
        this.zzc = true;
        this.zzf = zzex.zzs(this.zzk.zzb());
        this.zzb.zzg();
    }

    public final void zze() {
        this.zzc = false;
        this.zzh = -9223372036854775807L;
        this.zzb.zzh();
    }

    public final void zzf(int i) {
        if (i == 0) {
            this.zzd = 1;
        } else if (i != 1) {
            zzo(2);
        } else {
            this.zzd = 0;
        }
    }

    public final void zzg() {
        this.zzb.zzf();
        this.zzg = -9223372036854775807L;
        this.zze = -9223372036854775807L;
        zzo(1);
        this.zzh = -9223372036854775807L;
    }

    public final void zzh(int i) {
        this.zzb.zzj(i);
    }

    public final void zzi(zzdj zzdjVar) {
        this.zzk = zzdjVar;
    }

    public final void zzj(float f) {
        this.zzb.zzc(f);
    }

    public final void zzk(Surface surface) {
        this.zzl = surface != null;
        this.zzm = false;
        this.zzb.zzi(surface);
        zzo(1);
    }

    public final void zzl(float f) {
        zzdd.zzd(f > 0.0f);
        if (f == this.zzj) {
            return;
        }
        this.zzj = f;
        this.zzb.zze(f);
    }

    public final boolean zzm(boolean z) {
        if (z && (this.zzd == 3 || (!this.zzl && this.zzm))) {
            this.zzh = -9223372036854775807L;
            return true;
        }
        if (this.zzh == -9223372036854775807L) {
            return false;
        }
        if (this.zzk.zzb() < this.zzh) {
            return true;
        }
        this.zzh = -9223372036854775807L;
        return false;
    }

    public final boolean zzn() {
        int i = this.zzd;
        this.zzd = 3;
        this.zzf = zzex.zzs(this.zzk.zzb());
        return i != 3;
    }
}
