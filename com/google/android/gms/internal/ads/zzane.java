package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzane implements zzamz {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzaor zzb;
    private zzand zzg;
    private long zzh;
    private String zzi;
    private zzafb zzj;
    private boolean zzk;
    private final boolean[] zzd = new boolean[4];
    private final zzanc zze = new zzanc(128);
    private long zzl = -9223372036854775807L;
    private final zzanr zzf = new zzanr(178, 128);
    private final zzen zzc = new zzen();

    zzane(zzaor zzaorVar, String str) {
        this.zzb = zzaorVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01cf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0197  */
    @Override // com.google.android.gms.internal.ads.zzamz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(zzen zzenVar) {
        int i;
        zzanr zzanrVar;
        int i2;
        int i3;
        zzdd.zzb(this.zzg);
        zzdd.zzb(this.zzj);
        int zzc = zzenVar.zzc();
        int zzd = zzenVar.zzd();
        byte[] zzN = zzenVar.zzN();
        this.zzh += zzenVar.zza();
        this.zzj.zzr(zzenVar, zzenVar.zza());
        while (true) {
            int zza2 = zzfv.zza(zzN, zzc, zzd, this.zzd);
            if (zza2 == zzd) {
                break;
            }
            int i4 = zza2 + 3;
            int i5 = zzenVar.zzN()[i4] & 255;
            int i6 = zza2 - zzc;
            if (!this.zzk) {
                if (i6 > 0) {
                    this.zze.zza(zzN, zzc, zza2);
                }
                int i7 = i6 < 0 ? -i6 : 0;
                zzanc zzancVar = this.zze;
                if (zzancVar.zzc(i5, i7)) {
                    zzafb zzafbVar = this.zzj;
                    int i8 = zzancVar.zzb;
                    String str = this.zzi;
                    str.getClass();
                    byte[] copyOf = Arrays.copyOf(zzancVar.zzc, zzancVar.zza);
                    zzem zzemVar = new zzem(copyOf, copyOf.length);
                    zzemVar.zzo(i8);
                    zzemVar.zzo(4);
                    zzemVar.zzm();
                    zzemVar.zzn(8);
                    if (zzemVar.zzp()) {
                        zzemVar.zzn(4);
                        zzemVar.zzn(3);
                    }
                    int zzd2 = zzemVar.zzd(4);
                    float f = 1.0f;
                    i = zzd;
                    if (zzd2 == 15) {
                        int zzd3 = zzemVar.zzd(8);
                        int zzd4 = zzemVar.zzd(8);
                        if (zzd4 == 0) {
                            zzea.zzf("H263Reader", "Invalid aspect ratio");
                        } else {
                            f = zzd3 / zzd4;
                        }
                    } else if (zzd2 < 7) {
                        f = zza[zzd2];
                    } else {
                        zzea.zzf("H263Reader", "Invalid aspect ratio");
                    }
                    float f2 = f;
                    if (zzemVar.zzp()) {
                        zzemVar.zzn(2);
                        zzemVar.zzn(1);
                        if (zzemVar.zzp()) {
                            zzemVar.zzn(15);
                            zzemVar.zzm();
                            zzemVar.zzn(15);
                            zzemVar.zzm();
                            zzemVar.zzn(15);
                            zzemVar.zzm();
                            zzemVar.zzn(3);
                            zzemVar.zzn(11);
                            zzemVar.zzm();
                            zzemVar.zzn(15);
                            zzemVar.zzm();
                            i3 = 2;
                            if (zzemVar.zzd(i3) != 0) {
                                zzea.zzf("H263Reader", "Unhandled video object layer shape");
                            }
                            zzemVar.zzm();
                            int zzd5 = zzemVar.zzd(16);
                            zzemVar.zzm();
                            if (zzemVar.zzp()) {
                                if (zzd5 == 0) {
                                    zzea.zzf("H263Reader", "Invalid vop_increment_time_resolution");
                                } else {
                                    int i9 = zzd5 - 1;
                                    int i10 = 0;
                                    while (i9 > 0) {
                                        i9 >>= 1;
                                        i10++;
                                    }
                                    zzemVar.zzn(i10);
                                }
                            }
                            zzemVar.zzm();
                            int zzd6 = zzemVar.zzd(13);
                            zzemVar.zzm();
                            int zzd7 = zzemVar.zzd(13);
                            zzemVar.zzm();
                            zzemVar.zzm();
                            zzx zzxVar = new zzx();
                            zzxVar.zzS(str);
                            zzxVar.zzG("video/mp2t");
                            zzxVar.zzah("video/mp4v-es");
                            zzxVar.zzam(zzd6);
                            zzxVar.zzQ(zzd7);
                            zzxVar.zzad(f2);
                            zzxVar.zzT(Collections.singletonList(copyOf));
                            zzafbVar.zzm(zzxVar.zzan());
                            this.zzk = true;
                            this.zzg.zza(zzN, zzc, zza2);
                            zzanrVar = this.zzf;
                            if (i6 > 0) {
                                zzanrVar.zza(zzN, zzc, zza2);
                                i2 = 0;
                            } else {
                                i2 = -i6;
                            }
                            if (zzanrVar.zzd(i2)) {
                                int zzc2 = zzfv.zzc(zzanrVar.zza, zzanrVar.zzb);
                                zzen zzenVar2 = this.zzc;
                                String str2 = zzex.zza;
                                zzenVar2.zzJ(zzanrVar.zza, zzc2);
                                this.zzb.zzb(this.zzl, zzenVar2);
                            }
                            if (i5 == 178) {
                                if (zzenVar.zzN()[zza2 + 2] == 1) {
                                    zzanrVar.zzc(178);
                                }
                                i5 = 178;
                            }
                            int i11 = i - zza2;
                            this.zzg.zzb(this.zzh - i11, i11, this.zzk);
                            this.zzg.zzc(i5, this.zzl);
                            zzc = i4;
                            zzd = i;
                        }
                    }
                    i3 = 2;
                    if (zzemVar.zzd(i3) != 0) {
                    }
                    zzemVar.zzm();
                    int zzd52 = zzemVar.zzd(16);
                    zzemVar.zzm();
                    if (zzemVar.zzp()) {
                    }
                    zzemVar.zzm();
                    int zzd62 = zzemVar.zzd(13);
                    zzemVar.zzm();
                    int zzd72 = zzemVar.zzd(13);
                    zzemVar.zzm();
                    zzemVar.zzm();
                    zzx zzxVar2 = new zzx();
                    zzxVar2.zzS(str);
                    zzxVar2.zzG("video/mp2t");
                    zzxVar2.zzah("video/mp4v-es");
                    zzxVar2.zzam(zzd62);
                    zzxVar2.zzQ(zzd72);
                    zzxVar2.zzad(f2);
                    zzxVar2.zzT(Collections.singletonList(copyOf));
                    zzafbVar.zzm(zzxVar2.zzan());
                    this.zzk = true;
                    this.zzg.zza(zzN, zzc, zza2);
                    zzanrVar = this.zzf;
                    if (i6 > 0) {
                    }
                    if (zzanrVar.zzd(i2)) {
                    }
                    if (i5 == 178) {
                    }
                    int i112 = i - zza2;
                    this.zzg.zzb(this.zzh - i112, i112, this.zzk);
                    this.zzg.zzc(i5, this.zzl);
                    zzc = i4;
                    zzd = i;
                }
            }
            i = zzd;
            this.zzg.zza(zzN, zzc, zza2);
            zzanrVar = this.zzf;
            if (i6 > 0) {
            }
            if (zzanrVar.zzd(i2)) {
            }
            if (i5 == 178) {
            }
            int i1122 = i - zza2;
            this.zzg.zzb(this.zzh - i1122, i1122, this.zzk);
            this.zzg.zzc(i5, this.zzl);
            zzc = i4;
            zzd = i;
        }
        if (!this.zzk) {
            this.zze.zza(zzN, zzc, zzd);
        }
        this.zzg.zza(zzN, zzc, zzd);
        this.zzf.zza(zzN, zzc, zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        this.zzi = zzaonVar.zzb();
        this.zzj = zzadyVar.zzw(zzaonVar.zza(), 2);
        this.zzg = new zzand(this.zzj);
        this.zzb.zzc(zzadyVar, zzaonVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
        zzdd.zzb(this.zzg);
        if (z) {
            this.zzg.zzb(this.zzh, 0, this.zzk);
            this.zzg.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        this.zzl = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        zzfv.zzi(this.zzd);
        this.zze.zzb();
        zzand zzandVar = this.zzg;
        if (zzandVar != null) {
            zzandVar.zzd();
        }
        this.zzf.zzb();
        this.zzh = 0L;
        this.zzl = -9223372036854775807L;
    }
}
