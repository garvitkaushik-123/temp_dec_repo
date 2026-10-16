package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaga implements zzadv {
    private final byte[] zza;
    private final zzen zzb;
    private final zzaeb zzc;
    private zzady zzd;
    private zzafb zze;
    private int zzf;
    private zzav zzg;
    private zzaeg zzh;
    private int zzi;
    private int zzj;
    private zzafz zzk;
    private int zzl;
    private long zzm;

    public zzaga() {
        throw null;
    }

    public zzaga(int i) {
        this.zza = new byte[42];
        this.zzb = new zzen(new byte[32768], 0);
        this.zzc = new zzaeb();
        this.zzf = 0;
    }

    private final long zza(zzen zzenVar, boolean z) {
        boolean z2;
        this.zzh.getClass();
        int zzc = zzenVar.zzc();
        while (zzc <= zzenVar.zzd() - 16) {
            zzenVar.zzL(zzc);
            zzaeg zzaegVar = this.zzh;
            int i = this.zzj;
            zzaeb zzaebVar = this.zzc;
            if (zzaec.zzc(zzenVar, zzaegVar, i, zzaebVar)) {
                zzenVar.zzL(zzc);
                return zzaebVar.zza;
            }
            zzc++;
        }
        if (!z) {
            zzenVar.zzL(zzc);
            return -1L;
        }
        while (zzc <= zzenVar.zzd() - this.zzi) {
            zzenVar.zzL(zzc);
            try {
                z2 = zzaec.zzc(zzenVar, this.zzh, this.zzj, this.zzc);
            } catch (IndexOutOfBoundsException unused) {
                z2 = false;
            }
            if (zzenVar.zzc() <= zzenVar.zzd() && z2) {
                zzenVar.zzL(zzc);
                return this.zzc.zza;
            }
            zzc++;
        }
        zzenVar.zzL(zzenVar.zzd());
        return -1L;
    }

    private final void zzg() {
        long j = this.zzm * 1000000;
        zzaeg zzaegVar = this.zzh;
        String str = zzex.zza;
        this.zze.zzt(j / zzaegVar.zze, 1, this.zzl, 0, null);
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
        this.zzd = zzadyVar;
        this.zze = zzadyVar.zzw(0, 1);
        zzadyVar.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws IOException {
        zzaed.zza(zzadwVar, false);
        zzen zzenVar = new zzen(4);
        ((zzadl) zzadwVar).zzm(zzenVar.zzN(), 0, 4, false);
        return zzenVar.zzu() == 1716281667;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        if (j == 0) {
            this.zzf = 0;
        } else {
            zzafz zzafzVar = this.zzk;
            if (zzafzVar != null) {
                zzafzVar.zzd(j2);
            }
        }
        this.zzm = j2 != 0 ? -1L : 0L;
        this.zzl = 0;
        this.zzb.zzI(0);
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        boolean zzp;
        zzaeu zzaetVar;
        boolean z;
        int i = this.zzf;
        if (i == 0) {
            zzadwVar.zzj();
            long zze = zzadwVar.zze();
            zzav zza = zzaed.zza(zzadwVar, true);
            zzadwVar.zzk((int) (zzadwVar.zze() - zze));
            this.zzg = zza;
            this.zzf = 1;
            return 0;
        }
        if (i == 1) {
            zzadwVar.zzh(this.zza, 0, 42);
            zzadwVar.zzj();
            this.zzf = 2;
            return 0;
        }
        if (i == 2) {
            zzen zzenVar = new zzen(4);
            zzadwVar.zzi(zzenVar.zzN(), 0, 4);
            if (zzenVar.zzu() != 1716281667) {
                throw zzaz.zza("Failed to read FLAC stream marker.", null);
            }
            this.zzf = 3;
            return 0;
        }
        if (i == 3) {
            zzaeg zzaegVar = this.zzh;
            do {
                zzadwVar.zzj();
                zzem zzemVar = new zzem(new byte[4], 4);
                zzadwVar.zzh(zzemVar.zza, 0, 4);
                zzp = zzemVar.zzp();
                int zzd = zzemVar.zzd(7);
                int zzd2 = zzemVar.zzd(24) + 4;
                if (zzd == 0) {
                    byte[] bArr = new byte[38];
                    zzadwVar.zzi(bArr, 0, 38);
                    zzaegVar = new zzaeg(bArr, 4);
                } else {
                    if (zzaegVar == null) {
                        throw new IllegalArgumentException();
                    }
                    if (zzd == 3) {
                        zzen zzenVar2 = new zzen(zzd2);
                        zzadwVar.zzi(zzenVar2.zzN(), 0, zzd2);
                        zzaegVar = zzaegVar.zzf(zzaed.zzb(zzenVar2));
                    } else if (zzd == 4) {
                        zzen zzenVar3 = new zzen(zzd2);
                        zzadwVar.zzi(zzenVar3.zzN(), 0, zzd2);
                        zzenVar3.zzM(4);
                        zzaegVar = zzaegVar.zzg(Arrays.asList(zzafh.zzc(zzenVar3, false, false).zza));
                    } else if (zzd == 6) {
                        zzen zzenVar4 = new zzen(zzd2);
                        zzadwVar.zzi(zzenVar4.zzN(), 0, zzd2);
                        zzenVar4.zzM(4);
                        zzaegVar = zzaegVar.zze(zzfyq.zzo(zzagt.zzb(zzenVar4)));
                    } else {
                        zzadwVar.zzk(zzd2);
                    }
                }
                String str = zzex.zza;
                this.zzh = zzaegVar;
            } while (!zzp);
            zzaegVar.getClass();
            this.zzi = Math.max(zzaegVar.zzc, 6);
            zzz zzc = this.zzh.zzc(this.zza, this.zzg);
            zzafb zzafbVar = this.zze;
            zzx zzb = zzc.zzb();
            zzb.zzG("audio/flac");
            zzafbVar.zzm(zzb.zzan());
            this.zze.zzl(this.zzh.zza());
            this.zzf = 4;
            return 0;
        }
        if (i == 4) {
            zzadwVar.zzj();
            zzen zzenVar5 = new zzen(2);
            zzadwVar.zzh(zzenVar5.zzN(), 0, 2);
            int zzq = zzenVar5.zzq();
            if ((zzq >> 2) != 16382) {
                zzadwVar.zzj();
                throw zzaz.zza("First frame does not start with sync code.", null);
            }
            zzadwVar.zzj();
            this.zzj = zzq;
            zzady zzadyVar = this.zzd;
            String str2 = zzex.zza;
            long zzf = zzadwVar.zzf();
            long zzd3 = zzadwVar.zzd();
            zzaeg zzaegVar2 = this.zzh;
            zzaegVar2.getClass();
            zzaef zzaefVar = zzaegVar2.zzk;
            if (zzaefVar != null && zzaefVar.zza.length > 0) {
                zzaetVar = new zzaee(zzaegVar2, zzf);
            } else if (zzd3 == -1 || zzaegVar2.zzj <= 0) {
                zzaetVar = new zzaet(zzaegVar2.zza(), 0L);
            } else {
                zzafz zzafzVar = new zzafz(zzaegVar2, this.zzj, zzf, zzd3);
                this.zzk = zzafzVar;
                zzaetVar = zzafzVar.zzb();
            }
            zzadyVar.zzP(zzaetVar);
            this.zzf = 5;
            return 0;
        }
        this.zze.getClass();
        zzaeg zzaegVar3 = this.zzh;
        zzaegVar3.getClass();
        zzafz zzafzVar2 = this.zzk;
        if (zzafzVar2 != null && zzafzVar2.zze()) {
            return zzafzVar2.zza(zzadwVar, zzaerVar);
        }
        if (this.zzm == -1) {
            this.zzm = zzaec.zzb(zzadwVar, zzaegVar3);
            return 0;
        }
        zzen zzenVar6 = this.zzb;
        int zzd4 = zzenVar6.zzd();
        if (zzd4 < 32768) {
            int zza2 = zzadwVar.zza(zzenVar6.zzN(), zzd4, 32768 - zzd4);
            z = zza2 == -1;
            if (!z) {
                zzenVar6.zzK(zzd4 + zza2);
            } else if (zzenVar6.zza() == 0) {
                zzg();
                return -1;
            }
        } else {
            z = false;
        }
        int zzc2 = zzenVar6.zzc();
        int i2 = this.zzl;
        int i3 = this.zzi;
        if (i2 < i3) {
            zzenVar6.zzM(Math.min(i3 - i2, zzenVar6.zza()));
        }
        long zza3 = zza(zzenVar6, z);
        int zzc3 = zzenVar6.zzc() - zzc2;
        zzenVar6.zzL(zzc2);
        this.zze.zzr(zzenVar6, zzc3);
        this.zzl += zzc3;
        if (zza3 != -1) {
            zzg();
            this.zzl = 0;
            this.zzm = zza3;
        }
        int length = zzenVar6.zzN().length - zzenVar6.zzd();
        if (zzenVar6.zza() >= 16 || length >= 16) {
            return 0;
        }
        int zza4 = zzenVar6.zza();
        System.arraycopy(zzenVar6.zzN(), zzenVar6.zzc(), zzenVar6.zzN(), 0, zza4);
        zzenVar6.zzL(0);
        zzenVar6.zzK(zza4);
        return 0;
    }
}
