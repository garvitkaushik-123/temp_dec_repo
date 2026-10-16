package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaek {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final int zzk;
    public final float zzl;
    public final int zzm;
    public final String zzn;
    public final zzfs zzo;

    private zzaek(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f, int i13, String str, zzfs zzfsVar) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = i7;
        this.zzg = i8;
        this.zzh = i9;
        this.zzi = i10;
        this.zzj = i11;
        this.zzk = i12;
        this.zzl = f;
        this.zzm = i13;
        this.zzn = str;
        this.zzo = zzfsVar;
    }

    public static zzaek zza(zzen zzenVar) throws zzaz {
        return zzc(zzenVar, false, null);
    }

    public static zzaek zzb(zzen zzenVar, zzfs zzfsVar) throws zzaz {
        return zzc(zzenVar, true, zzfsVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0297  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static zzaek zzc(zzen zzenVar, boolean z, zzfs zzfsVar) throws zzaz {
        boolean z2;
        boolean z3;
        int i;
        int i2;
        zzfo zzfoVar;
        int i3;
        int max;
        int i4;
        int max2;
        int i5;
        int i6;
        int i7;
        int i8 = 4;
        boolean z4 = true;
        if (z) {
            try {
                zzenVar.zzM(4);
            } catch (ArrayIndexOutOfBoundsException e) {
                e = e;
                z3 = true;
                throw zzaz.zza("Error parsing".concat(z3 != z ? "HEVC config" : "L-HEVC config"), e);
            }
        } else {
            try {
                zzenVar.zzM(21);
            } catch (ArrayIndexOutOfBoundsException e2) {
                e = e2;
                z2 = z4;
                z3 = z2;
                throw zzaz.zza("Error parsing".concat(z3 != z ? "HEVC config" : "L-HEVC config"), e);
            }
        }
        int zzm = zzenVar.zzm() & 3;
        int zzm2 = zzenVar.zzm();
        int zzc = zzenVar.zzc();
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < zzm2; i11++) {
            zzenVar.zzM(1);
            int zzq = zzenVar.zzq();
            for (int i12 = 0; i12 < zzq; i12++) {
                int zzq2 = zzenVar.zzq();
                i10 += zzq2 + 4;
                zzenVar.zzM(zzq2);
            }
        }
        zzenVar.zzL(zzc);
        byte[] bArr = new byte[i10];
        zzfs zzfsVar2 = zzfsVar;
        int i13 = 0;
        float f = 1.0f;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        int i18 = -1;
        int i19 = -1;
        int i20 = -1;
        int i21 = -1;
        int i22 = -1;
        int i23 = -1;
        int i24 = -1;
        int i25 = -1;
        String str = null;
        int i26 = 0;
        while (i26 < zzm2) {
            int zzm3 = zzenVar.zzm() & 63;
            int zzq3 = zzenVar.zzq();
            z2 = z4;
            int i27 = i9;
            zzfs zzfsVar3 = zzfsVar2;
            while (i27 < zzq3) {
                try {
                    int zzq4 = zzenVar.zzq();
                    int i28 = i27;
                    System.arraycopy(zzfv.zza, i9, bArr, i13, i8);
                    int i29 = i13 + 4;
                    System.arraycopy(zzenVar.zzN(), zzenVar.zzc(), bArr, i29, zzq4);
                    int i30 = 32;
                    if (zzm3 != 32) {
                        i30 = zzm3;
                    } else if (i28 == 0) {
                        zzfsVar3 = zzfv.zze(bArr, i29, i29 + zzq4);
                        i2 = i29;
                        i = zzm;
                        i6 = 0;
                        i5 = 0;
                        i13 = i2 + zzq4;
                        zzenVar.zzM(zzq4);
                        i27 = i6 + 1;
                        i9 = i5;
                        zzm = i;
                        i8 = 4;
                    }
                    i = zzm;
                    if (i30 != 33) {
                        i2 = i29;
                        int i31 = 8;
                        if (i30 == 39 && i28 == 0) {
                            int i32 = i13 + 6;
                            int i33 = (i2 + zzq4) - 1;
                            while (true) {
                                byte b = bArr[i33];
                                if (b == 0) {
                                    if (i33 <= i32) {
                                        break;
                                    }
                                    i33--;
                                } else if (b != 0 && i33 > i32) {
                                    zzfw zzfwVar = new zzfw(bArr, i32, i33 + 1);
                                    while (true) {
                                        if (!zzfwVar.zzg(16)) {
                                            break;
                                        }
                                        int i34 = i31;
                                        int zza = zzfwVar.zza(i34);
                                        int i35 = 0;
                                        while (zza == 255) {
                                            i35 += 255;
                                            zza = zzfwVar.zza(i34);
                                        }
                                        int i36 = i35 + zza;
                                        int zza2 = zzfwVar.zza(i34);
                                        int i37 = 0;
                                        while (zza2 == 255) {
                                            i37 += 255;
                                            zza2 = zzfwVar.zza(8);
                                        }
                                        i31 = 8;
                                        int i38 = i37 + zza2;
                                        if (i38 == 0 || !zzfwVar.zzg(i38)) {
                                            break;
                                        }
                                        if (i36 == 176) {
                                            int zzc2 = zzfwVar.zzc();
                                            boolean zzh = zzfwVar.zzh();
                                            int zzc3 = zzh ? zzfwVar.zzc() : 0;
                                            int zzc4 = zzfwVar.zzc();
                                            int i39 = -1;
                                            int i40 = -1;
                                            int i41 = -1;
                                            int i42 = -1;
                                            int i43 = -1;
                                            int i44 = -1;
                                            int i45 = 0;
                                            while (i45 <= zzc4) {
                                                i39 = zzfwVar.zzc();
                                                i40 = zzfwVar.zzc();
                                                boolean z5 = zzh;
                                                int zza3 = zzfwVar.zza(6);
                                                if (zza3 != 63) {
                                                    if (zza3 == 0) {
                                                        i3 = zza3;
                                                        max = Math.max(0, zzc2 - 30);
                                                    } else {
                                                        i3 = zza3;
                                                        max = Math.max(0, (i3 + zzc2) - 31);
                                                    }
                                                    i42 = zzfwVar.zza(max);
                                                    if (z5) {
                                                        int zza4 = zzfwVar.zza(6);
                                                        if (zza4 != 63) {
                                                            if (zza4 == 0) {
                                                                i4 = zza4;
                                                                max2 = Math.max(0, zzc3 - 30);
                                                            } else {
                                                                i4 = zza4;
                                                                max2 = Math.max(0, (i4 + zzc3) - 31);
                                                            }
                                                            i44 = zzfwVar.zza(max2);
                                                            i43 = i4;
                                                        }
                                                    }
                                                    if (zzfwVar.zzh()) {
                                                        zzfwVar.zzf(10);
                                                    }
                                                    i45++;
                                                    zzh = z5;
                                                    i41 = i3;
                                                }
                                            }
                                            zzfoVar = new zzfo(zzc2, zzc3, zzc4 + 1, i39, i40, i41, i42, i43, i44);
                                        } else {
                                            zzfwVar.zzf(i38 * 8);
                                        }
                                    }
                                }
                            }
                            zzfoVar = null;
                            if (zzfoVar != null && zzfsVar3 != null) {
                                i5 = 0;
                                if (zzfoVar.zza == ((zzfi) zzfsVar3.zza.get(0)).zzb) {
                                    i6 = i28;
                                    i24 = 4;
                                    i13 = i2 + zzq4;
                                    zzenVar.zzM(zzq4);
                                    i27 = i6 + 1;
                                    i9 = i5;
                                    zzm = i;
                                    i8 = 4;
                                } else {
                                    i24 = 5;
                                }
                            }
                        }
                        i5 = 0;
                    } else if (i28 == 0) {
                        zzfp zzd = zzfv.zzd(bArr, i29, i29 + zzq4, zzfsVar3);
                        int i46 = zzd.zza + 1;
                        int i47 = zzd.zze;
                        int i48 = zzd.zzf;
                        int i49 = zzd.zzg;
                        i2 = i29;
                        int i50 = zzd.zzh;
                        int i51 = zzd.zzc + 8;
                        int i52 = zzd.zzd + 8;
                        int i53 = zzd.zzk;
                        int i54 = zzd.zzl;
                        int i55 = zzd.zzm;
                        float f2 = zzd.zzi;
                        int i56 = zzd.zzj;
                        zzfk zzfkVar = zzd.zzb;
                        if (zzfkVar != null) {
                            i7 = i56;
                            str = zzdk.zzd(zzfkVar.zza, zzfkVar.zzb, zzfkVar.zzc, zzfkVar.zzd, zzfkVar.zze, zzfkVar.zzf);
                        } else {
                            i7 = i56;
                        }
                        i23 = i55;
                        f = f2;
                        i25 = i7;
                        i6 = i28;
                        i20 = i52;
                        i21 = i53;
                        i22 = i54;
                        i17 = i49;
                        i18 = i50;
                        i19 = i51;
                        i5 = 0;
                        i15 = i47;
                        i16 = i48;
                        i14 = i46;
                        i13 = i2 + zzq4;
                        zzenVar.zzM(zzq4);
                        i27 = i6 + 1;
                        i9 = i5;
                        zzm = i;
                        i8 = 4;
                    } else {
                        i2 = i29;
                        i5 = 0;
                    }
                    i6 = i28;
                    i13 = i2 + zzq4;
                    zzenVar.zzM(zzq4);
                    i27 = i6 + 1;
                    i9 = i5;
                    zzm = i;
                    i8 = 4;
                } catch (ArrayIndexOutOfBoundsException e3) {
                    e = e3;
                    z3 = z2;
                    throw zzaz.zza("Error parsing".concat(z3 != z ? "HEVC config" : "L-HEVC config"), e);
                }
            }
            i26++;
            zzfsVar2 = zzfsVar3;
            z4 = z2;
            zzm = zzm;
            i8 = 4;
        }
        z2 = z4;
        return new zzaek(i10 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), zzm + 1, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, f, i25, str, zzfsVar2);
    }
}
