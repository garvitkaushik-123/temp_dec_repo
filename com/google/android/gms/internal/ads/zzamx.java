package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzamx implements zzamz {
    private final zzen zza;
    private final String zzc;
    private final int zzd;
    private String zzf;
    private zzafb zzg;
    private int zzi;
    private int zzj;
    private long zzk;
    private zzz zzl;
    private int zzm;
    private int zzn;
    private int zzh = 0;
    private long zzq = -9223372036854775807L;
    private final AtomicInteger zzb = new AtomicInteger();
    private int zzo = -1;
    private int zzp = -1;
    private final String zze = "video/mp2t";

    public zzamx(String str, int i, int i2, String str2) {
        this.zza = new zzen(new byte[i2]);
        this.zzc = str;
        this.zzd = i;
    }

    @RequiresNonNull({"output"})
    private final void zzf(zzads zzadsVar) {
        int i;
        int i2 = zzadsVar.zzb;
        if (i2 == -2147483647 || (i = zzadsVar.zzc) == -1) {
            return;
        }
        zzz zzzVar = this.zzl;
        if (zzzVar != null && i == zzzVar.zzG && i2 == zzzVar.zzH && Objects.equals(zzadsVar.zza, zzzVar.zzo)) {
            return;
        }
        zzz zzzVar2 = this.zzl;
        zzx zzxVar = zzzVar2 == null ? new zzx() : zzzVar2.zzb();
        zzxVar.zzS(this.zzf);
        zzxVar.zzG(this.zze);
        zzxVar.zzah(zzadsVar.zza);
        zzxVar.zzD(i);
        zzxVar.zzai(i2);
        zzxVar.zzW(this.zzc);
        zzxVar.zzaf(this.zzd);
        zzz zzan = zzxVar.zzan();
        this.zzl = zzan;
        this.zzg.zzm(zzan);
    }

    private final boolean zzg(zzen zzenVar, byte[] bArr, int i) {
        int min = Math.min(zzenVar.zza(), i - this.zzi);
        zzenVar.zzH(bArr, this.zzi, min);
        int i2 = this.zzi + min;
        this.zzi = i2;
        return i2 == i;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ed  */
    @Override // com.google.android.gms.internal.ads.zzamz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(zzen zzenVar) throws zzaz {
        char c;
        char c2;
        char c3;
        int i;
        boolean z;
        int i2;
        int i3;
        byte b;
        int i4;
        byte b2;
        int i5;
        int i6;
        byte b3;
        zzdd.zzb(this.zzg);
        while (zzenVar.zza() > 0) {
            int i7 = this.zzh;
            if (i7 == 0) {
                while (true) {
                    if (zzenVar.zza() > 0) {
                        int i8 = this.zzj << 8;
                        this.zzj = i8;
                        int zzm = i8 | zzenVar.zzm();
                        this.zzj = zzm;
                        int i9 = zzadu.zza;
                        int i10 = (zzm == 2147385345 || zzm == -25230976 || zzm == 536864768 || zzm == -14745368) ? 1 : (zzm == 1683496997 || zzm == 622876772) ? 2 : (zzm == 1078008818 || zzm == -233094848) ? 3 : (zzm == 1908687592 || zzm == -398277519) ? 4 : 0;
                        this.zzn = i10;
                        if (i10 != 0) {
                            byte[] zzN = this.zza.zzN();
                            int i11 = this.zzj;
                            zzN[0] = (byte) ((i11 >> 24) & 255);
                            zzN[1] = (byte) ((i11 >> 16) & 255);
                            zzN[2] = (byte) ((i11 >> 8) & 255);
                            zzN[3] = (byte) (i11 & 255);
                            this.zzi = 4;
                            this.zzj = 0;
                            if (i10 == 3 || i10 == 4) {
                                this.zzh = 4;
                            } else if (i10 == 1) {
                                this.zzh = 1;
                            } else {
                                this.zzh = 2;
                            }
                        }
                    }
                }
            } else if (i7 == 1) {
                zzen zzenVar2 = this.zza;
                if (zzg(zzenVar, zzenVar2.zzN(), 18)) {
                    byte[] zzN2 = zzenVar2.zzN();
                    if (this.zzl == null) {
                        c2 = '\b';
                        c = 5;
                        zzz zzc = zzadu.zzc(zzN2, this.zzf, this.zzc, this.zzd, this.zze, null);
                        this.zzl = zzc;
                        this.zzg.zzm(zzc);
                    } else {
                        c = 5;
                        c2 = '\b';
                    }
                    int i12 = zzadu.zza;
                    byte b4 = zzN2[0];
                    if (b4 != -2) {
                        if (b4 == -1) {
                            c3 = 7;
                            i5 = (3 & zzN2[7]) << 12;
                            i6 = (zzN2[6] & 255) << 4;
                            b3 = zzN2[9];
                        } else if (b4 != 31) {
                            c3 = 7;
                            i = ((zzN2[c] & 3) << 12) | ((zzN2[6] & 255) << 4) | ((zzN2[7] & 240) >> 4);
                        } else {
                            c3 = 7;
                            i5 = (3 & zzN2[6]) << 12;
                            i6 = (zzN2[7] & 255) << 4;
                            b3 = zzN2[c2];
                        }
                        i2 = (i5 | i6 | ((b3 & 60) >> 2)) + 1;
                        z = true;
                        if (z) {
                            i2 = (i2 * 16) / 14;
                        }
                        this.zzm = i2;
                        if (b4 == -2) {
                            if (b4 == -1) {
                                i3 = (zzN2[4] & 7) << 4;
                                b2 = zzN2[c3];
                            } else if (b4 != 31) {
                                i3 = (zzN2[4] & 1) << 6;
                                b = zzN2[c];
                            } else {
                                i3 = (zzN2[c] & 7) << 4;
                                b2 = zzN2[6];
                            }
                            i4 = b2 & 60;
                            this.zzk = zzgbt.zzb(zzex.zzt(((i3 | (i4 >> 2)) + 1) * 32, this.zzl.zzH));
                            zzenVar2.zzL(0);
                            this.zzg.zzr(zzenVar2, 18);
                            this.zzh = 6;
                        } else {
                            i3 = (zzN2[c] & 1) << 6;
                            b = zzN2[4];
                        }
                        i4 = b & 252;
                        this.zzk = zzgbt.zzb(zzex.zzt(((i3 | (i4 >> 2)) + 1) * 32, this.zzl.zzH));
                        zzenVar2.zzL(0);
                        this.zzg.zzr(zzenVar2, 18);
                        this.zzh = 6;
                    } else {
                        c3 = 7;
                        i = ((3 & zzN2[4]) << 12) | ((zzN2[7] & 255) << 4) | ((zzN2[6] & 240) >> 4);
                    }
                    i2 = i + 1;
                    z = false;
                    if (z) {
                    }
                    this.zzm = i2;
                    if (b4 == -2) {
                    }
                    i4 = b & 252;
                    this.zzk = zzgbt.zzb(zzex.zzt(((i3 | (i4 >> 2)) + 1) * 32, this.zzl.zzH));
                    zzenVar2.zzL(0);
                    this.zzg.zzr(zzenVar2, 18);
                    this.zzh = 6;
                }
            } else if (i7 != 2) {
                if (i7 == 3) {
                    zzen zzenVar3 = this.zza;
                    if (zzg(zzenVar, zzenVar3.zzN(), this.zzo)) {
                        zzads zzd = zzadu.zzd(zzenVar3.zzN());
                        zzf(zzd);
                        this.zzm = zzd.zzd;
                        long j = zzd.zze;
                        this.zzk = j != -9223372036854775807L ? j : 0L;
                        zzenVar3.zzL(0);
                        this.zzg.zzr(zzenVar3, this.zzo);
                        this.zzh = 6;
                    }
                } else if (i7 == 4) {
                    zzen zzenVar4 = this.zza;
                    if (zzg(zzenVar, zzenVar4.zzN(), 6)) {
                        int zzb = zzadu.zzb(zzenVar4.zzN());
                        this.zzp = zzb;
                        int i13 = this.zzi;
                        if (i13 > zzb) {
                            int i14 = i13 - zzb;
                            this.zzi = i13 - i14;
                            zzenVar.zzL(zzenVar.zzc() - i14);
                        }
                        this.zzh = 5;
                    }
                } else if (i7 != 5) {
                    int min = Math.min(zzenVar.zza(), this.zzm - this.zzi);
                    this.zzg.zzr(zzenVar, min);
                    int i15 = this.zzi + min;
                    this.zzi = i15;
                    if (i15 == this.zzm) {
                        zzdd.zzf(this.zzq != -9223372036854775807L);
                        this.zzg.zzt(this.zzq, this.zzn == 4 ? 0 : 1, this.zzm, 0, null);
                        this.zzq += this.zzk;
                        this.zzh = 0;
                    }
                } else {
                    zzen zzenVar5 = this.zza;
                    if (zzg(zzenVar, zzenVar5.zzN(), this.zzp)) {
                        zzads zze = zzadu.zze(zzenVar5.zzN(), this.zzb);
                        if (this.zzn == 3) {
                            zzf(zze);
                        }
                        this.zzm = zze.zzd;
                        long j2 = zze.zze;
                        this.zzk = j2 != -9223372036854775807L ? j2 : 0L;
                        zzenVar5.zzL(0);
                        this.zzg.zzr(zzenVar5, this.zzp);
                        this.zzh = 6;
                    }
                }
            } else {
                zzen zzenVar6 = this.zza;
                if (zzg(zzenVar, zzenVar6.zzN(), 7)) {
                    this.zzo = zzadu.zza(zzenVar6.zzN());
                    this.zzh = 3;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        this.zzf = zzaonVar.zzb();
        this.zzg = zzadyVar.zzw(zzaonVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        this.zzq = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = 0;
        this.zzq = -9223372036854775807L;
        this.zzb.set(0);
    }
}
