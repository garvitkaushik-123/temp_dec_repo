package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzang implements zzamz {
    private final zzaod zza;
    private long zzf;
    private String zzh;
    private zzafb zzi;
    private zzanf zzj;
    private boolean zzk;
    private boolean zzm;
    private final String zzb = "video/mp2t";
    private final boolean[] zzg = new boolean[3];
    private final zzanr zzc = new zzanr(7, 128);
    private final zzanr zzd = new zzanr(8, 128);
    private final zzanr zze = new zzanr(6, 128);
    private long zzl = -9223372036854775807L;
    private final zzen zzn = new zzen();

    public zzang(zzaod zzaodVar, boolean z, boolean z2, String str) {
        this.zza = zzaodVar;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzg(byte[] bArr, int i, int i2) {
        if (!this.zzk) {
            this.zzc.zza(bArr, i, i2);
            this.zzd.zza(bArr, i, i2);
        }
        this.zze.zza(bArr, i, i2);
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzh(long j, int i, long j2) {
        if (!this.zzk) {
            this.zzc.zzc(i);
            this.zzd.zzc(i);
        }
        this.zze.zzc(i);
        this.zzj.zzd(j, i, j2, this.zzm);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    @Override // com.google.android.gms.internal.ads.zzamz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(zzen zzenVar) {
        int i;
        int i2;
        int i3;
        zzdd.zzb(this.zzi);
        String str = zzex.zza;
        int zzc = zzenVar.zzc();
        int zzd = zzenVar.zzd();
        byte[] zzN = zzenVar.zzN();
        this.zzf += zzenVar.zza();
        this.zzi.zzr(zzenVar, zzenVar.zza());
        while (true) {
            int zza = zzfv.zza(zzN, zzc, zzd, this.zzg);
            if (zza == zzd) {
                zzg(zzN, zzc, zzd);
                return;
            }
            int i4 = zzN[zza + 3] & Ascii.US;
            if (zza > 0) {
                int i5 = zza - 1;
                if (zzN[i5] == 0) {
                    i2 = 4;
                    i = i5;
                    i3 = i - zzc;
                    if (i3 > 0) {
                        zzg(zzN, zzc, i);
                    }
                    int i6 = zzd - i;
                    long j = this.zzf - i6;
                    zzf(j, i6, i3 >= 0 ? -i3 : 0, this.zzl);
                    zzh(j, i4, this.zzl);
                    zzc = i + i2;
                }
            }
            i = zza;
            i2 = 3;
            i3 = i - zzc;
            if (i3 > 0) {
            }
            int i62 = zzd - i;
            long j2 = this.zzf - i62;
            zzf(j2, i62, i3 >= 0 ? -i3 : 0, this.zzl);
            zzh(j2, i4, this.zzl);
            zzc = i + i2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        this.zzh = zzaonVar.zzb();
        this.zzi = zzadyVar.zzw(zzaonVar.zza(), 2);
        this.zzj = new zzanf(this.zzi, false, false);
        this.zza.zzd(zzadyVar, zzaonVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
        zzdd.zzb(this.zzi);
        String str = zzex.zza;
        if (z) {
            this.zza.zze();
            zzf(this.zzf, 0, 0, this.zzl);
            zzh(this.zzf, 9, this.zzl);
            zzf(this.zzf, 0, 0, this.zzl);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        this.zzl = j;
        int i2 = i & 2;
        this.zzm = (i2 != 0) | this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        this.zzf = 0L;
        this.zzm = false;
        this.zzl = -9223372036854775807L;
        zzfv.zzi(this.zzg);
        this.zzc.zzb();
        this.zzd.zzb();
        this.zze.zzb();
        this.zza.zzb();
        zzanf zzanfVar = this.zzj;
        if (zzanfVar != null) {
            zzanfVar.zzc();
        }
    }

    @RequiresNonNull({"output", "sampleReader"})
    private final void zzf(long j, int i, int i2, long j2) {
        if (!this.zzk) {
            zzanr zzanrVar = this.zzc;
            zzanrVar.zzd(i2);
            zzanr zzanrVar2 = this.zzd;
            zzanrVar2.zzd(i2);
            if (this.zzk) {
                if (zzanrVar.zze()) {
                    zzfu zzg = zzfv.zzg(zzanrVar.zza, 4, zzanrVar.zzb);
                    this.zza.zzf(zzg.zzm);
                    this.zzj.zzb(zzg);
                    zzanrVar.zzb();
                } else if (zzanrVar2.zze()) {
                    this.zzj.zza(zzfv.zzf(zzanrVar2.zza, 4, zzanrVar2.zzb));
                    zzanrVar2.zzb();
                }
            } else if (zzanrVar.zze() && zzanrVar2.zze()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Arrays.copyOf(zzanrVar.zza, zzanrVar.zzb));
                arrayList.add(Arrays.copyOf(zzanrVar2.zza, zzanrVar2.zzb));
                zzfu zzg2 = zzfv.zzg(zzanrVar.zza, 4, zzanrVar.zzb);
                zzft zzf = zzfv.zzf(zzanrVar2.zza, 4, zzanrVar2.zzb);
                String zzc = zzdk.zzc(zzg2.zza, zzg2.zzb, zzg2.zzc);
                zzafb zzafbVar = this.zzi;
                zzx zzxVar = new zzx();
                zzxVar.zzS(this.zzh);
                zzxVar.zzG(this.zzb);
                zzxVar.zzah("video/avc");
                zzxVar.zzE(zzc);
                zzxVar.zzam(zzg2.zze);
                zzxVar.zzQ(zzg2.zzf);
                zzi zziVar = new zzi();
                zziVar.zzc(zzg2.zzj);
                zziVar.zzb(zzg2.zzk);
                zziVar.zzd(zzg2.zzl);
                zziVar.zzf(zzg2.zzh + 8);
                zziVar.zza(zzg2.zzi + 8);
                zzxVar.zzF(zziVar.zzg());
                zzxVar.zzad(zzg2.zzg);
                zzxVar.zzT(arrayList);
                int i3 = zzg2.zzm;
                zzxVar.zzY(i3);
                zzafbVar.zzm(zzxVar.zzan());
                this.zzk = true;
                this.zza.zzf(i3);
                this.zzj.zzb(zzg2);
                this.zzj.zza(zzf);
                zzanrVar.zzb();
                zzanrVar2.zzb();
            }
        }
        zzanr zzanrVar3 = this.zze;
        if (zzanrVar3.zzd(i2)) {
            int zzc2 = zzfv.zzc(zzanrVar3.zza, zzanrVar3.zzb);
            zzen zzenVar = this.zzn;
            zzenVar.zzJ(zzanrVar3.zza, zzc2);
            zzenVar.zzL(4);
            this.zza.zzc(j2, zzenVar);
        }
        if (this.zzj.zze(j, i, this.zzk)) {
            this.zzm = false;
        }
    }
}
