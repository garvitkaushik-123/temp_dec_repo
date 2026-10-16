package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzams implements zzadv {
    private final zzamt zza = new zzamt(null, 0, "audio/ac4");
    private final zzen zzb = new zzen(16384);
    private boolean zzc;

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        zzen zzenVar = this.zzb;
        int zza = zzadwVar.zza(zzenVar.zzN(), 0, 16384);
        if (zza == -1) {
            return -1;
        }
        zzenVar.zzL(0);
        zzenVar.zzK(zza);
        if (!this.zzc) {
            this.zza.zzd(0L, 4);
            this.zzc = true;
        }
        this.zza.zza(zzenVar);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ zzadv zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ List zzd() {
        return zzfyq.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zze(zzady zzadyVar) {
        this.zza.zzb(zzadyVar, new zzaon(Integer.MIN_VALUE, 0, 1));
        zzadyVar.zzG();
        zzadyVar.zzP(new zzaet(-9223372036854775807L, 0L));
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzc = false;
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws IOException {
        zzadl zzadlVar;
        int i;
        zzen zzenVar = new zzen(10);
        int i2 = 0;
        while (true) {
            zzadlVar = (zzadl) zzadwVar;
            zzadlVar.zzm(zzenVar.zzN(), 0, 10, false);
            zzenVar.zzL(0);
            if (zzenVar.zzo() != 4801587) {
                break;
            }
            zzenVar.zzM(3);
            int zzl = zzenVar.zzl();
            i2 += zzl + 10;
            zzadlVar.zzl(zzl, false);
        }
        zzadwVar.zzj();
        zzadlVar.zzl(i2, false);
        int i3 = 0;
        int i4 = i2;
        while (true) {
            int i5 = 7;
            zzadlVar.zzm(zzenVar.zzN(), 0, 7, false);
            zzenVar.zzL(0);
            int zzq = zzenVar.zzq();
            if (zzq == 44096 || zzq == 44097) {
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] zzN = zzenVar.zzN();
                int i6 = zzacy.zza;
                if (zzN.length < 7) {
                    i = -1;
                } else {
                    int i7 = ((zzN[2] & 255) << 8) | (zzN[3] & 255);
                    if (i7 == 65535) {
                        i7 = ((zzN[4] & 255) << 16) | ((zzN[5] & 255) << 8) | (zzN[6] & 255);
                    } else {
                        i5 = 4;
                    }
                    if (zzq == 44097) {
                        i5 += 2;
                    }
                    i = i7 + i5;
                }
                if (i == -1) {
                    return false;
                }
                zzadlVar.zzl(i - 7, false);
            } else {
                zzadwVar.zzj();
                i4++;
                if (i4 - i2 >= 8192) {
                    return false;
                }
                zzadlVar.zzl(i4, false);
                i3 = 0;
            }
        }
    }
}
