package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzagg extends zzagf {
    private final zzen zzb;
    private final zzen zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzagg(zzafb zzafbVar) {
        super(zzafbVar);
        this.zzb = new zzen(zzfv.zza);
        this.zzc = new zzen(4);
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    protected final boolean zza(zzen zzenVar) throws zzage {
        int zzm = zzenVar.zzm();
        int i = zzm >> 4;
        int i2 = zzm & 15;
        if (i2 == 7) {
            this.zzg = i;
            return i != 5;
        }
        throw new zzage("Video format not supported: " + i2);
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    protected final boolean zzb(zzen zzenVar, long j) throws zzaz {
        int i;
        int zzm = zzenVar.zzm();
        long zzh = zzenVar.zzh();
        if (zzm == 0) {
            if (!this.zze) {
                zzen zzenVar2 = new zzen(new byte[zzenVar.zza()]);
                zzenVar.zzH(zzenVar2.zzN(), 0, zzenVar.zza());
                zzacz zza = zzacz.zza(zzenVar2);
                this.zzd = zza.zzb;
                zzx zzxVar = new zzx();
                zzxVar.zzG("video/x-flv");
                zzxVar.zzah("video/avc");
                zzxVar.zzE(zza.zzl);
                zzxVar.zzam(zza.zzc);
                zzxVar.zzQ(zza.zzd);
                zzxVar.zzad(zza.zzk);
                zzxVar.zzT(zza.zza);
                this.zza.zzm(zzxVar.zzan());
                this.zze = true;
                return false;
            }
        } else if (zzm == 1 && this.zze) {
            int i2 = this.zzg == 1 ? 1 : 0;
            if (this.zzf) {
                i = i2;
            } else if (i2 != 0) {
                i = 1;
            }
            zzen zzenVar3 = this.zzc;
            byte[] zzN = zzenVar3.zzN();
            zzN[0] = 0;
            zzN[1] = 0;
            zzN[2] = 0;
            int i3 = 4 - this.zzd;
            int i4 = 0;
            while (zzenVar.zza() > 0) {
                zzenVar.zzH(zzenVar3.zzN(), i3, this.zzd);
                zzenVar3.zzL(0);
                zzen zzenVar4 = this.zzb;
                int zzp = zzenVar3.zzp();
                zzenVar4.zzL(0);
                zzafb zzafbVar = this.zza;
                zzafbVar.zzr(zzenVar4, 4);
                zzafbVar.zzr(zzenVar, zzp);
                i4 = i4 + 4 + zzp;
            }
            this.zza.zzt(j + (zzh * 1000), i, i4, 0, null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
