package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaov implements zzadv {
    private zzady zza;
    private zzafb zzb;
    private zzaot zze;
    private int zzc = 0;
    private long zzd = -1;
    private int zzf = -1;
    private long zzg = -1;

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ea, code lost:
    
        if (r1 != 65534) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f1, code lost:
    
        if (r2 == 32) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010e  */
    @Override // com.google.android.gms.internal.ads.zzadv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        int i;
        zzdd.zzb(this.zzb);
        String str = zzex.zza;
        int i2 = this.zzc;
        int i3 = 4;
        if (i2 == 0) {
            zzdd.zzf(zzadwVar.zzf() == 0);
            int i4 = this.zzf;
            if (i4 != -1) {
                zzadwVar.zzk(i4);
                this.zzc = 4;
            } else {
                if (!zzaoy.zzc(zzadwVar)) {
                    throw zzaz.zza("Unsupported or unrecognized wav file type.", null);
                }
                zzadwVar.zzk((int) (zzadwVar.zze() - zzadwVar.zzf()));
                this.zzc = 1;
            }
            return 0;
        }
        long j = -1;
        if (i2 == 1) {
            int i5 = zzaoy.zza;
            zzen zzenVar = new zzen(8);
            zzaox zza = zzaox.zza(zzadwVar, zzenVar);
            if (zza.zza != 1685272116) {
                zzadwVar.zzj();
            } else {
                zzadwVar.zzg(8);
                zzenVar.zzL(0);
                zzadwVar.zzh(zzenVar.zzN(), 0, 8);
                j = zzenVar.zzr();
                zzadwVar.zzk(((int) zza.zzb) + 8);
            }
            this.zzd = j;
            this.zzc = 2;
            return 0;
        }
        if (i2 == 2) {
            zzaow zzb = zzaoy.zzb(zzadwVar);
            int i6 = zzb.zza;
            if (i6 == 17) {
                this.zze = new zzaos(this.zza, this.zzb, zzb);
            } else if (i6 == 6) {
                this.zze = new zzaou(this.zza, this.zzb, zzb, "audio/g711-alaw", -1);
            } else if (i6 == 7) {
                this.zze = new zzaou(this.zza, this.zzb, zzb, "audio/g711-mlaw", -1);
            } else {
                int i7 = zzb.zze;
                if (i6 != 1) {
                    if (i6 != 3) {
                    }
                    i = 0;
                    if (i != 0) {
                        throw zzaz.zzc("Unsupported WAV format type: " + i6);
                    }
                    this.zze = new zzaou(this.zza, this.zzb, zzb, "audio/raw", i);
                }
                i3 = zzex.zzn(i7, ByteOrder.LITTLE_ENDIAN);
                i = i3;
                if (i != 0) {
                }
            }
            this.zzc = 3;
            return 0;
        }
        if (i2 != 3) {
            zzdd.zzf(this.zzg != -1);
            long zzf = this.zzg - zzadwVar.zzf();
            zzaot zzaotVar = this.zze;
            zzaotVar.getClass();
            return zzaotVar.zzc(zzadwVar, zzf) ? -1 : 0;
        }
        Pair zza2 = zzaoy.zza(zzadwVar);
        this.zzf = ((Long) zza2.first).intValue();
        long longValue = ((Long) zza2.second).longValue();
        long j2 = this.zzd;
        if (j2 != -1 && longValue == 4294967295L) {
            longValue = j2;
        }
        long j3 = this.zzf + longValue;
        this.zzg = j3;
        long zzd = zzadwVar.zzd();
        if (zzd != -1 && j3 > zzd) {
            zzea.zzf("WavExtractor", "Data exceeds input length: " + j3 + ", " + zzd);
            this.zzg = zzd;
            j3 = zzd;
        }
        zzaot zzaotVar2 = this.zze;
        zzaotVar2.getClass();
        zzaotVar2.zza(this.zzf, j3);
        this.zzc = 4;
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
        this.zza = zzadyVar;
        this.zzb = zzadyVar.zzw(0, 1);
        zzadyVar.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzc = j == 0 ? 0 : 4;
        zzaot zzaotVar = this.zze;
        if (zzaotVar != null) {
            zzaotVar.zzb(j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws IOException {
        return zzaoy.zzc(zzadwVar);
    }
}
