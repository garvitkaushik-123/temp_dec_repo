package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaka {
    private final zzakb zza = new zzakb();
    private final zzen zzb = new zzen(new byte[65025], 0);
    private int zzc = -1;
    private int zzd;
    private boolean zze;

    zzaka() {
    }

    private final int zzf(int i) {
        int i2;
        int i3 = 0;
        this.zzd = 0;
        do {
            int i4 = this.zzd;
            int i5 = i + i4;
            zzakb zzakbVar = this.zza;
            if (i5 >= zzakbVar.zzc) {
                break;
            }
            this.zzd = i4 + 1;
            i2 = zzakbVar.zzf[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public final zzen zza() {
        return this.zzb;
    }

    public final zzakb zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zza();
        this.zzb.zzI(0);
        this.zzc = -1;
        this.zze = false;
    }

    public final void zzd() {
        zzen zzenVar = this.zzb;
        if (zzenVar.zzN().length == 65025) {
            return;
        }
        zzenVar.zzJ(Arrays.copyOf(zzenVar.zzN(), Math.max(65025, zzenVar.zzd())), zzenVar.zzd());
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zze(zzadw zzadwVar) throws IOException {
        if (this.zze) {
            this.zze = false;
            this.zzb.zzI(0);
        }
        while (true) {
            if (this.zze) {
                return true;
            }
            int i = this.zzc;
            if (i < 0) {
                zzakb zzakbVar = this.zza;
                if (!zzakbVar.zzc(zzadwVar, -1L) || !zzakbVar.zzb(zzadwVar, true)) {
                    break;
                }
                int i2 = zzakbVar.zzd;
                if ((zzakbVar.zza & 1) == 1 && this.zzb.zzd() == 0) {
                    i2 += zzf(0);
                    i = this.zzd;
                } else {
                    i = 0;
                }
                if (!zzadz.zzf(zzadwVar, i2)) {
                    return false;
                }
                this.zzc = i;
            }
            int zzf = zzf(i);
            int i3 = this.zzc + this.zzd;
            if (zzf > 0) {
                zzen zzenVar = this.zzb;
                zzenVar.zzF(zzenVar.zzd() + zzf);
                if (!zzadz.zze(zzadwVar, zzenVar.zzN(), zzenVar.zzd(), zzf)) {
                    return false;
                }
                zzenVar.zzK(zzenVar.zzd() + zzf);
                this.zze = this.zza.zzf[i3 + (-1)] != 255;
            }
            if (i3 == this.zza.zzc) {
                i3 = -1;
            }
            this.zzc = i3;
        }
    }
}
