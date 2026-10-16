package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzys extends zzyp {
    private final boolean zze;
    private final zzyi zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final boolean zzs;
    private final boolean zzt;
    private final int zzu;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
    
        if (r1 >= 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0055, code lost:
    
        if (r1 >= 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
    
        if (r1 >= 0.0f) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006a, code lost:
    
        if (r12 >= 0) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0106 A[EDGE_INSN: B:134:0x0106->B:71:0x0106 BREAK  A[LOOP:1: B:63:0x00e7->B:132:0x0103], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzys(int i, zzbm zzbmVar, int i2, zzyi zzyiVar, int i3, String str, int i4, boolean z) {
        super(i, zzbmVar, i2);
        boolean z2;
        boolean z3;
        int i5;
        int i6;
        int i7;
        int i8;
        zzz zzzVar;
        String str2;
        int i9;
        char c;
        boolean z4;
        zzz zzzVar2;
        int i10;
        int i11;
        int i12;
        this.zzf = zzyiVar;
        int i13 = 1;
        int i14 = true != zzyiVar.zzI ? 16 : 24;
        boolean z5 = zzyiVar.zzH;
        if (z && (((i10 = (zzzVar2 = this.zzd).zzv) == -1 || i10 <= zzyiVar.zza) && ((i11 = zzzVar2.zzw) == -1 || i11 <= zzyiVar.zzb))) {
            float f = zzzVar2.zzz;
            if ((f == -1.0f || f <= zzyiVar.zzc) && ((i12 = zzzVar2.zzj) == -1 || i12 <= zzyiVar.zzd)) {
                z2 = true;
                this.zze = z2;
                if (z) {
                    zzz zzzVar3 = this.zzd;
                    int i15 = zzzVar3.zzv;
                    if (i15 != -1) {
                        int i16 = zzyiVar.zze;
                    }
                    int i17 = zzzVar3.zzw;
                    if (i17 != -1) {
                        int i18 = zzyiVar.zzf;
                    }
                    float f2 = zzzVar3.zzz;
                    if (f2 != -1.0f) {
                        int i19 = zzyiVar.zzg;
                    }
                    int i20 = zzzVar3.zzj;
                    if (i20 != -1) {
                        int i21 = zzyiVar.zzh;
                    }
                    z3 = true;
                    this.zzg = z3;
                    this.zzh = zzmb.zza(i3, false);
                    zzz zzzVar4 = this.zzd;
                    float f3 = zzzVar4.zzz;
                    this.zzi = f3 == -1.0f && f3 >= 10.0f;
                    this.zzj = zzzVar4.zzj;
                    this.zzk = zzzVar4.zza();
                    i5 = 0;
                    while (true) {
                        i6 = Integer.MAX_VALUE;
                        if (i5 >= zzyiVar.zzn.size()) {
                            i7 = 0;
                            i5 = Integer.MAX_VALUE;
                            break;
                        } else {
                            i7 = zzyu.zzc(this.zzd, (String) zzyiVar.zzn.get(i5), false);
                            if (i7 > 0) {
                                break;
                            } else {
                                i5++;
                            }
                        }
                    }
                    this.zzm = i5;
                    this.zzn = i7;
                    int i22 = this.zzd.zzf;
                    int i23 = zzyiVar.zzo;
                    this.zzo = zzyu.zzb(i22, 0);
                    int i24 = this.zzd.zzf;
                    this.zzp = (i24 == 0 && (i24 & 1) == 0) ? false : true;
                    this.zzq = zzyu.zzc(this.zzd, str, zzyu.zzh(str) == null);
                    i8 = 0;
                    while (true) {
                        if (i8 < zzyiVar.zzm.size()) {
                            String str3 = this.zzd.zzo;
                            if (str3 != null && str3.equals(zzyiVar.zzm.get(i8))) {
                                i6 = i8;
                                break;
                            }
                            i8++;
                        } else {
                            break;
                        }
                    }
                    this.zzl = i6;
                    this.zzs = (i3 & 384) == 128;
                    this.zzt = (i3 & 64) == 64;
                    zzzVar = this.zzd;
                    str2 = zzzVar.zzo;
                    if (str2 != null) {
                        i9 = 4;
                        switch (str2.hashCode()) {
                            case -1851077871:
                                if (str2.equals("video/dolby-vision")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1662735862:
                                if (str2.equals("video/av01")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1662541442:
                                if (str2.equals("video/hevc")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1331836730:
                                if (str2.equals("video/avc")) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1599127257:
                                if (str2.equals("video/x-vnd.on2.vp9")) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        if (c == 0) {
                            i9 = 5;
                        } else if (c != 1) {
                            if (c == 2) {
                                i9 = 3;
                            } else if (c == 3) {
                                i9 = 2;
                            } else if (c == 4) {
                                i9 = 1;
                            }
                        }
                        this.zzu = i9;
                        if ((zzzVar.zzf & 16384) == 0) {
                            zzyi zzyiVar2 = this.zzf;
                            if (zzmb.zza(i3, zzyiVar2.zzR) && ((z4 = this.zze) || zzyiVar2.zzG)) {
                                if (zzmb.zza(i3, false) && this.zzg && z4 && zzzVar.zzj != -1) {
                                    boolean z6 = zzyiVar2.zzC;
                                    boolean z7 = zzyiVar2.zzB;
                                    if ((i14 & i3) != 0) {
                                        i13 = 2;
                                    }
                                }
                                this.zzr = i13;
                            }
                        }
                        i13 = 0;
                        this.zzr = i13;
                    }
                    i9 = 0;
                    this.zzu = i9;
                    if ((zzzVar.zzf & 16384) == 0) {
                    }
                    i13 = 0;
                    this.zzr = i13;
                }
                z3 = false;
                this.zzg = z3;
                this.zzh = zzmb.zza(i3, false);
                zzz zzzVar42 = this.zzd;
                float f32 = zzzVar42.zzz;
                this.zzi = f32 == -1.0f && f32 >= 10.0f;
                this.zzj = zzzVar42.zzj;
                this.zzk = zzzVar42.zza();
                i5 = 0;
                while (true) {
                    i6 = Integer.MAX_VALUE;
                    if (i5 >= zzyiVar.zzn.size()) {
                    }
                    i5++;
                }
                this.zzm = i5;
                this.zzn = i7;
                int i222 = this.zzd.zzf;
                int i232 = zzyiVar.zzo;
                this.zzo = zzyu.zzb(i222, 0);
                int i242 = this.zzd.zzf;
                this.zzp = (i242 == 0 && (i242 & 1) == 0) ? false : true;
                this.zzq = zzyu.zzc(this.zzd, str, zzyu.zzh(str) == null);
                i8 = 0;
                while (true) {
                    if (i8 < zzyiVar.zzm.size()) {
                    }
                    i8++;
                }
                this.zzl = i6;
                this.zzs = (i3 & 384) == 128;
                this.zzt = (i3 & 64) == 64;
                zzzVar = this.zzd;
                str2 = zzzVar.zzo;
                if (str2 != null) {
                }
                i9 = 0;
                this.zzu = i9;
                if ((zzzVar.zzf & 16384) == 0) {
                }
                i13 = 0;
                this.zzr = i13;
            }
        }
        z2 = false;
        this.zze = z2;
        if (z) {
        }
        z3 = false;
        this.zzg = z3;
        this.zzh = zzmb.zza(i3, false);
        zzz zzzVar422 = this.zzd;
        float f322 = zzzVar422.zzz;
        this.zzi = f322 == -1.0f && f322 >= 10.0f;
        this.zzj = zzzVar422.zzj;
        this.zzk = zzzVar422.zza();
        i5 = 0;
        while (true) {
            i6 = Integer.MAX_VALUE;
            if (i5 >= zzyiVar.zzn.size()) {
            }
            i5++;
        }
        this.zzm = i5;
        this.zzn = i7;
        int i2222 = this.zzd.zzf;
        int i2322 = zzyiVar.zzo;
        this.zzo = zzyu.zzb(i2222, 0);
        int i2422 = this.zzd.zzf;
        this.zzp = (i2422 == 0 && (i2422 & 1) == 0) ? false : true;
        this.zzq = zzyu.zzc(this.zzd, str, zzyu.zzh(str) == null);
        i8 = 0;
        while (true) {
            if (i8 < zzyiVar.zzm.size()) {
            }
            i8++;
        }
        this.zzl = i6;
        this.zzs = (i3 & 384) == 128;
        this.zzt = (i3 & 64) == 64;
        zzzVar = this.zzd;
        str2 = zzzVar.zzo;
        if (str2 != null) {
        }
        i9 = 0;
        this.zzu = i9;
        if ((zzzVar.zzf & 16384) == 0) {
        }
        i13 = 0;
        this.zzr = i13;
    }

    public static /* synthetic */ int zza(zzys zzysVar, zzys zzysVar2) {
        zzgab zzgabVar;
        zzgab zza;
        if (zzysVar.zze && zzysVar.zzh) {
            zza = zzyu.zzc;
        } else {
            zzgabVar = zzyu.zzc;
            zza = zzgabVar.zza();
        }
        zzfyf zzj = zzfyf.zzj();
        boolean z = zzysVar.zzf.zzB;
        return zzj.zzc(Integer.valueOf(zzysVar.zzk), Integer.valueOf(zzysVar2.zzk), zza).zzc(Integer.valueOf(zzysVar.zzj), Integer.valueOf(zzysVar2.zzj), zza).zza();
    }

    public static /* synthetic */ int zzd(zzys zzysVar, zzys zzysVar2) {
        zzfyf zzc = zzfyf.zzj().zzd(zzysVar.zzh, zzysVar2.zzh).zzc(Integer.valueOf(zzysVar.zzm), Integer.valueOf(zzysVar2.zzm), zzgab.zzc().zza()).zzb(zzysVar.zzn, zzysVar2.zzn).zzb(zzysVar.zzo, zzysVar2.zzo).zzd(zzysVar.zzp, zzysVar2.zzp).zzb(zzysVar.zzq, zzysVar2.zzq).zzd(zzysVar.zzi, zzysVar2.zzi).zzd(zzysVar.zze, zzysVar2.zze).zzd(zzysVar.zzg, zzysVar2.zzg).zzc(Integer.valueOf(zzysVar.zzl), Integer.valueOf(zzysVar2.zzl), zzgab.zzc().zza());
        boolean z = zzysVar.zzs;
        zzfyf zzd = zzc.zzd(z, zzysVar2.zzs);
        boolean z2 = zzysVar.zzt;
        zzfyf zzd2 = zzd.zzd(z2, zzysVar2.zzt);
        if (z && z2) {
            zzd2 = zzd2.zzb(zzysVar.zzu, zzysVar2.zzu);
        }
        return zzd2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zzb() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final /* bridge */ /* synthetic */ boolean zzc(zzyp zzypVar) {
        zzys zzysVar = (zzys) zzypVar;
        if (!Objects.equals(this.zzd.zzo, zzysVar.zzd.zzo)) {
            return false;
        }
        boolean z = this.zzf.zzJ;
        return this.zzs == zzysVar.zzs && this.zzt == zzysVar.zzt;
    }
}
