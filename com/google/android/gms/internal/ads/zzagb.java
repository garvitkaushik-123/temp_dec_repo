package com.google.android.gms.internal.ads;

import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzagb extends zzagf {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzagb(zzafb zzafbVar) {
        super(zzafbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    protected final boolean zza(zzen zzenVar) throws zzage {
        if (this.zzc) {
            zzenVar.zzM(1);
        } else {
            int zzm = zzenVar.zzm();
            int i = zzm >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(zzm >> 2) & 3];
                zzx zzxVar = new zzx();
                zzxVar.zzG("video/x-flv");
                zzxVar.zzah("audio/mpeg");
                zzxVar.zzD(1);
                zzxVar.zzai(i2);
                this.zza.zzm(zzxVar.zzan());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                zzx zzxVar2 = new zzx();
                zzxVar2.zzG("video/x-flv");
                zzxVar2.zzah(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw");
                zzxVar2.zzD(1);
                zzxVar2.zzai(8000);
                this.zza.zzm(zzxVar2.zzan());
                this.zzd = true;
            } else if (i != 10) {
                throw new zzage("Audio format not supported: " + i);
            }
            this.zzc = true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    protected final boolean zzb(zzen zzenVar, long j) throws zzaz {
        if (this.zze == 2) {
            int zza = zzenVar.zza();
            zzafb zzafbVar = this.zza;
            zzafbVar.zzr(zzenVar, zza);
            zzafbVar.zzt(j, 1, zza, 0, null);
            return true;
        }
        int zzm = zzenVar.zzm();
        if (zzm != 0 || this.zzd) {
            if (this.zze == 10 && zzm != 1) {
                return false;
            }
            int zza2 = zzenVar.zza();
            zzafb zzafbVar2 = this.zza;
            zzafbVar2.zzr(zzenVar, zza2);
            zzafbVar2.zzt(j, 1, zza2, 0, null);
            return true;
        }
        int zza3 = zzenVar.zza();
        byte[] bArr = new byte[zza3];
        zzenVar.zzH(bArr, 0, zza3);
        zzacp zza4 = zzacr.zza(bArr);
        zzx zzxVar = new zzx();
        zzxVar.zzG("video/x-flv");
        zzxVar.zzah("audio/mp4a-latm");
        zzxVar.zzE(zza4.zzc);
        zzxVar.zzD(zza4.zzb);
        zzxVar.zzai(zza4.zza);
        zzxVar.zzT(Collections.singletonList(bArr));
        this.zza.zzm(zzxVar.zzan());
        this.zzd = true;
        return false;
    }
}
