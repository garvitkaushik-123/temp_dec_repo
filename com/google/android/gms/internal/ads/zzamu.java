package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzamu implements zzadv {
    private final zzamv zza;
    private final zzen zzb;
    private final zzen zzc;
    private final zzem zzd;
    private zzady zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private boolean zzi;

    public zzamu() {
        throw null;
    }

    public zzamu(int i) {
        this.zza = new zzamv(true, null, 0, "audio/mp4a-latm");
        this.zzb = new zzen(2048);
        this.zzg = -1L;
        zzen zzenVar = new zzen(10);
        this.zzc = zzenVar;
        byte[] zzN = zzenVar.zzN();
        this.zzd = new zzem(zzN, zzN.length);
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        zzdd.zzb(this.zze);
        zzen zzenVar = this.zzb;
        int zza = zzadwVar.zza(zzenVar.zzN(), 0, 2048);
        if (!this.zzi) {
            this.zze.zzP(new zzaet(-9223372036854775807L, 0L));
            this.zzi = true;
        }
        if (zza == -1) {
            return -1;
        }
        zzenVar.zzL(0);
        zzenVar.zzK(zza);
        if (!this.zzh) {
            this.zza.zzd(this.zzf, 4);
            this.zzh = true;
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
        this.zze = zzadyVar;
        this.zza.zzb(zzadyVar, new zzaon(Integer.MIN_VALUE, 0, 1));
        zzadyVar.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzh = false;
        this.zza.zze();
        this.zzf = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws IOException {
        zzen zzenVar;
        zzadl zzadlVar;
        int i = 0;
        while (true) {
            zzenVar = this.zzc;
            zzadlVar = (zzadl) zzadwVar;
            zzadlVar.zzm(zzenVar.zzN(), 0, 10, false);
            zzenVar.zzL(0);
            if (zzenVar.zzo() != 4801587) {
                break;
            }
            zzenVar.zzM(3);
            int zzl = zzenVar.zzl();
            i += zzl + 10;
            zzadlVar.zzl(zzl, false);
        }
        zzadwVar.zzj();
        zzadlVar.zzl(i, false);
        if (this.zzg == -1) {
            this.zzg = i;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        do {
            zzadlVar.zzm(zzenVar.zzN(), 0, 2, false);
            zzenVar.zzL(0);
            if (zzamv.zzf(zzenVar.zzq())) {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                zzadlVar.zzm(zzenVar.zzN(), 0, 4, false);
                zzem zzemVar = this.zzd;
                zzemVar.zzl(14);
                int zzd = zzemVar.zzd(13);
                if (zzd <= 6) {
                    i4++;
                    zzadwVar.zzj();
                    zzadlVar.zzl(i4, false);
                } else {
                    zzadlVar.zzl(zzd - 6, false);
                    i3 += zzd;
                }
            } else {
                i4++;
                zzadwVar.zzj();
                zzadlVar.zzl(i4, false);
            }
            i2 = 0;
            i3 = 0;
        } while (i4 - i < 8192);
        return false;
    }
}
