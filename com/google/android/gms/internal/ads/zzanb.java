package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzanb implements zzamz {
    private static final double[] zza = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String zzb;
    private zzafb zzc;
    private final zzaor zzd;
    private final String zze;
    private final zzen zzf;
    private final zzanr zzg;
    private final boolean[] zzh = new boolean[4];
    private final zzana zzi = new zzana(128);
    private long zzj;
    private boolean zzk;
    private boolean zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private boolean zzq;
    private boolean zzr;

    zzanb(zzaor zzaorVar, String str) {
        zzen zzenVar;
        this.zzd = zzaorVar;
        this.zze = str;
        if (zzaorVar != null) {
            this.zzg = new zzanr(178, 128);
            zzenVar = new zzen();
        } else {
            zzenVar = null;
            this.zzg = null;
        }
        this.zzf = zzenVar;
        this.zzn = -9223372036854775807L;
        this.zzp = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ce  */
    @Override // com.google.android.gms.internal.ads.zzamz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(zzen zzenVar) {
        int i;
        zzanr zzanrVar;
        int i2;
        long j;
        long j2;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        long j3;
        byte b;
        int i7;
        zzdd.zzb(this.zzc);
        int zzc = zzenVar.zzc();
        int zzd = zzenVar.zzd();
        byte[] zzN = zzenVar.zzN();
        this.zzj += zzenVar.zza();
        this.zzc.zzr(zzenVar, zzenVar.zza());
        while (true) {
            int zza2 = zzfv.zza(zzN, zzc, zzd, this.zzh);
            if (zza2 == zzd) {
                break;
            }
            int i8 = zza2 + 3;
            int i9 = zzenVar.zzN()[i8] & 255;
            int i10 = zza2 - zzc;
            if (!this.zzl) {
                if (i10 > 0) {
                    this.zzi.zza(zzN, zzc, zza2);
                }
                int i11 = i10 < 0 ? -i10 : 0;
                zzana zzanaVar = this.zzi;
                if (zzanaVar.zzc(i9, i11)) {
                    String str = this.zzb;
                    str.getClass();
                    String str2 = this.zze;
                    byte[] copyOf = Arrays.copyOf(zzanaVar.zzc, zzanaVar.zza);
                    int i12 = copyOf[4] & 255;
                    byte b2 = copyOf[5];
                    i = zzd;
                    int i13 = copyOf[6] & 255;
                    int i14 = (i12 << 4) | ((b2 & 255) >> 4);
                    int i15 = (copyOf[7] & 240) >> 4;
                    int i16 = ((b2 & Ascii.SI) << 8) | i13;
                    if (i15 == 2) {
                        i4 = i16 * 4;
                        i5 = i14 * 3;
                    } else if (i15 == 3) {
                        i4 = i16 * 16;
                        i5 = i14 * 9;
                    } else if (i15 != 4) {
                        f = 1.0f;
                        zzx zzxVar = new zzx();
                        zzxVar.zzS(str);
                        zzxVar.zzG(str2);
                        zzxVar.zzah("video/mpeg2");
                        zzxVar.zzam(i14);
                        zzxVar.zzQ(i16);
                        zzxVar.zzad(f);
                        zzxVar.zzT(Collections.singletonList(copyOf));
                        zzz zzan = zzxVar.zzan();
                        i6 = (copyOf[7] & Ascii.SI) - 1;
                        j3 = 0;
                        if (i6 >= 0 && i6 < 8) {
                            double d = zza[i6];
                            b = copyOf[zzanaVar.zzb + 9];
                            i7 = (b & 96) >> 5;
                            if (i7 != (b & Ascii.US)) {
                                d *= (i7 + 1.0d) / (r11 + 1);
                            }
                            j3 = (long) (1000000.0d / d);
                        }
                        Pair create = Pair.create(zzan, Long.valueOf(j3));
                        this.zzc.zzm((zzz) create.first);
                        this.zzm = ((Long) create.second).longValue();
                        this.zzl = true;
                        zzanrVar = this.zzg;
                        if (zzanrVar != null) {
                            if (i10 > 0) {
                                zzanrVar.zza(zzN, zzc, zza2);
                                i3 = 0;
                            } else {
                                i3 = -i10;
                            }
                            if (zzanrVar.zzd(i3)) {
                                int zzc2 = zzfv.zzc(zzanrVar.zza, zzanrVar.zzb);
                                zzen zzenVar2 = this.zzf;
                                String str3 = zzex.zza;
                                zzenVar2.zzJ(zzanrVar.zza, zzc2);
                                this.zzd.zzb(this.zzp, zzenVar2);
                            }
                            if (i9 == 178) {
                                if (zzenVar.zzN()[zza2 + 2] == 1) {
                                    zzanrVar.zzc(178);
                                }
                                i9 = 178;
                            }
                        }
                        if (i9 != 0 || i9 == 179) {
                            i2 = i - zza2;
                            if (this.zzr || !this.zzl) {
                                j = -9223372036854775807L;
                            } else {
                                j = -9223372036854775807L;
                                long j4 = this.zzp;
                                if (j4 != -9223372036854775807L) {
                                    j = -9223372036854775807L;
                                    this.zzc.zzt(j4, this.zzq ? 1 : 0, ((int) (this.zzj - this.zzo)) - i2, i2, null);
                                }
                            }
                            if (this.zzk || this.zzr) {
                                this.zzo = this.zzj - i2;
                                j2 = this.zzn;
                                if (j2 == j) {
                                    long j5 = this.zzp;
                                    j2 = j5 != j ? j5 + this.zzm : j;
                                }
                                this.zzp = j2;
                                z = false;
                                this.zzq = false;
                                this.zzn = j;
                                z2 = true;
                                this.zzk = true;
                            } else {
                                z2 = true;
                                z = false;
                            }
                            this.zzr = i9 == 0 ? z2 : z;
                        } else if (i9 == 184) {
                            this.zzq = true;
                        }
                        zzc = i8;
                        zzd = i;
                    } else {
                        i4 = i16 * Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
                        i5 = i14 * 100;
                    }
                    f = i4 / i5;
                    zzx zzxVar2 = new zzx();
                    zzxVar2.zzS(str);
                    zzxVar2.zzG(str2);
                    zzxVar2.zzah("video/mpeg2");
                    zzxVar2.zzam(i14);
                    zzxVar2.zzQ(i16);
                    zzxVar2.zzad(f);
                    zzxVar2.zzT(Collections.singletonList(copyOf));
                    zzz zzan2 = zzxVar2.zzan();
                    i6 = (copyOf[7] & Ascii.SI) - 1;
                    j3 = 0;
                    if (i6 >= 0) {
                        double d2 = zza[i6];
                        b = copyOf[zzanaVar.zzb + 9];
                        i7 = (b & 96) >> 5;
                        if (i7 != (b & Ascii.US)) {
                        }
                        j3 = (long) (1000000.0d / d2);
                    }
                    Pair create2 = Pair.create(zzan2, Long.valueOf(j3));
                    this.zzc.zzm((zzz) create2.first);
                    this.zzm = ((Long) create2.second).longValue();
                    this.zzl = true;
                    zzanrVar = this.zzg;
                    if (zzanrVar != null) {
                    }
                    if (i9 != 0) {
                    }
                    i2 = i - zza2;
                    if (this.zzr) {
                    }
                    j = -9223372036854775807L;
                    if (this.zzk) {
                    }
                    this.zzo = this.zzj - i2;
                    j2 = this.zzn;
                    if (j2 == j) {
                    }
                    this.zzp = j2;
                    z = false;
                    this.zzq = false;
                    this.zzn = j;
                    z2 = true;
                    this.zzk = true;
                    this.zzr = i9 == 0 ? z2 : z;
                    zzc = i8;
                    zzd = i;
                }
            }
            i = zzd;
            zzanrVar = this.zzg;
            if (zzanrVar != null) {
            }
            if (i9 != 0) {
            }
            i2 = i - zza2;
            if (this.zzr) {
            }
            j = -9223372036854775807L;
            if (this.zzk) {
            }
            this.zzo = this.zzj - i2;
            j2 = this.zzn;
            if (j2 == j) {
            }
            this.zzp = j2;
            z = false;
            this.zzq = false;
            this.zzn = j;
            z2 = true;
            this.zzk = true;
            this.zzr = i9 == 0 ? z2 : z;
            zzc = i8;
            zzd = i;
        }
        if (!this.zzl) {
            this.zzi.zza(zzN, zzc, zzd);
        }
        zzanr zzanrVar2 = this.zzg;
        if (zzanrVar2 != null) {
            zzanrVar2.zza(zzN, zzc, zzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        this.zzb = zzaonVar.zzb();
        this.zzc = zzadyVar.zzw(zzaonVar.zza(), 2);
        zzaor zzaorVar = this.zzd;
        if (zzaorVar != null) {
            zzaorVar.zzc(zzadyVar, zzaonVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
        zzdd.zzb(this.zzc);
        if (z) {
            boolean z2 = this.zzq;
            long j = this.zzj - this.zzo;
            this.zzc.zzt(this.zzp, z2 ? 1 : 0, (int) j, 0, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        this.zzn = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        zzfv.zzi(this.zzh);
        this.zzi.zzb();
        zzanr zzanrVar = this.zzg;
        if (zzanrVar != null) {
            zzanrVar.zzb();
        }
        this.zzj = 0L;
        this.zzk = false;
        this.zzn = -9223372036854775807L;
        this.zzp = -9223372036854775807L;
    }
}
