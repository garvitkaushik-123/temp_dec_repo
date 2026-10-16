package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.text.TextUtils;
import io.bidmachine.media3.common.MimeTypes;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzye extends zzyp implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzyi zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;
    private final boolean zzw;

    /* JADX WARN: Removed duplicated region for block: B:100:0x00aa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f6 A[LOOP:1: B:28:0x00f3->B:30:0x00f6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0139 A[EDGE_INSN: B:80:0x0139->B:48:0x0139 BREAK  A[LOOP:3: B:40:0x011a->B:78:0x0136], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0113 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzye(int i, zzbm zzbmVar, int i2, zzyi zzyiVar, int i3, boolean z, zzfvq zzfvqVar, int i4) {
        super(i, zzbmVar, i2);
        int i5;
        int i6;
        char c;
        boolean z2;
        int i7;
        String[] split;
        int i8;
        int i9;
        int i10;
        int i11;
        zzyi zzyiVar2;
        boolean z3;
        this.zzh = zzyiVar;
        int i12 = 1;
        int i13 = true != zzyiVar.zzP ? 16 : 24;
        boolean z4 = zzyiVar.zzL;
        this.zzg = zzyu.zzh(this.zzd.zzd);
        this.zzi = zzmb.zza(i3, false);
        int i14 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i14 >= zzyiVar.zzp.size()) {
                i6 = 0;
                i14 = Integer.MAX_VALUE;
                break;
            } else {
                i6 = zzyu.zzc(this.zzd, (String) zzyiVar.zzp.get(i14), false);
                if (i6 > 0) {
                    break;
                } else {
                    i14++;
                }
            }
        }
        this.zzk = i14;
        this.zzj = i6;
        int i15 = this.zzd.zzf;
        int i16 = zzyiVar.zzq;
        this.zzl = zzyu.zzb(i15, 0);
        zzz zzzVar = this.zzd;
        int i17 = zzzVar.zzf;
        this.zzm = i17 == 0 || (i17 & 1) != 0;
        this.zzp = 1 == (zzzVar.zze & 1);
        String str = zzzVar.zzo;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode == -2123537834) {
                if (str.equals("audio/eac3-joc")) {
                    c = 0;
                    if (c != 0) {
                    }
                }
                c = 65535;
                if (c != 0) {
                }
            } else if (hashCode != 187078297) {
                if (hashCode == 1504698186 && str.equals(MimeTypes.AUDIO_IAMF)) {
                    c = 2;
                    z2 = (c != 0 || c == 1 || c == 2) ? true : z2;
                }
                c = 65535;
                if (c != 0) {
                }
            } else {
                if (str.equals("audio/ac4")) {
                    c = 1;
                    if (c != 0) {
                    }
                }
                c = 65535;
                if (c != 0) {
                }
            }
            this.zzw = z2;
            this.zzq = zzzVar.zzG;
            this.zzr = zzzVar.zzH;
            this.zzs = zzzVar.zzj;
            int i18 = zzzVar.zzj;
            this.zzf = (i18 != -1 || i18 <= zzyiVar.zzs) && ((i7 = zzzVar.zzG) == -1 || i7 <= zzyiVar.zzr) && zzfvqVar.zza(zzzVar);
            String str2 = zzex.zza;
            split = Resources.getSystem().getConfiguration().getLocales().toLanguageTags().split(",", -1);
            for (i8 = 0; i8 < split.length; i8++) {
                split[i8] = zzex.zzE(split[i8]);
            }
            i9 = 0;
            while (true) {
                if (i9 < split.length) {
                    i10 = 0;
                    i9 = Integer.MAX_VALUE;
                    break;
                } else {
                    i10 = zzyu.zzc(this.zzd, split[i9], false);
                    if (i10 > 0) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            this.zzn = i9;
            this.zzo = i10;
            i11 = 0;
            while (true) {
                if (i11 >= zzyiVar.zzt.size()) {
                    break;
                }
                String str3 = this.zzd.zzo;
                if (str3 != null && str3.equals(zzyiVar.zzt.get(i11))) {
                    i5 = i11;
                    break;
                }
                i11++;
            }
            this.zzt = i5;
            this.zzu = (i3 & 384) != 128;
            this.zzv = (i3 & 64) != 64;
            zzyiVar2 = this.zzh;
            if (zzmb.zza(i3, zzyiVar2.zzR) && ((z3 = this.zzf) || zzyiVar2.zzK)) {
                int i19 = zzyiVar2.zzu.zzb;
                if (zzmb.zza(i3, false) && z3 && this.zzd.zzj != -1) {
                    boolean z5 = zzyiVar2.zzC;
                    boolean z6 = zzyiVar2.zzB;
                    if ((!zzyiVar2.zzT || !z) && (i13 & i3) != 0) {
                        i12 = 2;
                    }
                }
            } else {
                i12 = 0;
            }
            this.zze = i12;
        }
        z2 = false;
        this.zzw = z2;
        this.zzq = zzzVar.zzG;
        this.zzr = zzzVar.zzH;
        this.zzs = zzzVar.zzj;
        int i182 = zzzVar.zzj;
        this.zzf = (i182 != -1 || i182 <= zzyiVar.zzs) && ((i7 = zzzVar.zzG) == -1 || i7 <= zzyiVar.zzr) && zzfvqVar.zza(zzzVar);
        String str22 = zzex.zza;
        split = Resources.getSystem().getConfiguration().getLocales().toLanguageTags().split(",", -1);
        while (i8 < split.length) {
        }
        i9 = 0;
        while (true) {
            if (i9 < split.length) {
            }
            i9++;
        }
        this.zzn = i9;
        this.zzo = i10;
        i11 = 0;
        while (true) {
            if (i11 >= zzyiVar.zzt.size()) {
            }
            i11++;
        }
        this.zzt = i5;
        this.zzu = (i3 & 384) != 128;
        this.zzv = (i3 & 64) != 64;
        zzyiVar2 = this.zzh;
        if (zzmb.zza(i3, zzyiVar2.zzR)) {
            int i192 = zzyiVar2.zzu.zzb;
            if (zzmb.zza(i3, false)) {
                boolean z52 = zzyiVar2.zzC;
                boolean z62 = zzyiVar2.zzB;
                if (!zzyiVar2.zzT) {
                }
                i12 = 2;
            }
            this.zze = i12;
        }
        i12 = 0;
        this.zze = i12;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final /* bridge */ /* synthetic */ boolean zzc(zzyp zzypVar) {
        String str;
        zzyi zzyiVar = this.zzh;
        zzye zzyeVar = (zzye) zzypVar;
        boolean z = zzyiVar.zzN;
        zzz zzzVar = this.zzd;
        int i = zzzVar.zzG;
        if (i == -1) {
            return false;
        }
        zzz zzzVar2 = zzyeVar.zzd;
        if (i != zzzVar2.zzG || (str = zzzVar.zzo) == null || !TextUtils.equals(str, zzzVar2.zzo)) {
            return false;
        }
        boolean z2 = zzyiVar.zzM;
        int i2 = zzzVar.zzH;
        if (i2 == -1 || i2 != zzzVar2.zzH) {
            return false;
        }
        boolean z3 = zzyiVar.zzO;
        return this.zzu == zzyeVar.zzu && this.zzv == zzyeVar.zzv;
    }

    @Override // java.lang.Comparable
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzye zzyeVar) {
        zzgab zzgabVar;
        zzgab zza;
        boolean z = this.zzf;
        if (z && this.zzi) {
            zza = zzyu.zzc;
        } else {
            zzgabVar = zzyu.zzc;
            zza = zzgabVar.zza();
        }
        zzfyf zzc = zzfyf.zzj().zzd(this.zzi, zzyeVar.zzi).zzc(Integer.valueOf(this.zzk), Integer.valueOf(zzyeVar.zzk), zzgab.zzc().zza()).zzb(this.zzj, zzyeVar.zzj).zzb(this.zzl, zzyeVar.zzl).zzd(this.zzp, zzyeVar.zzp).zzd(this.zzm, zzyeVar.zzm).zzc(Integer.valueOf(this.zzn), Integer.valueOf(zzyeVar.zzn), zzgab.zzc().zza()).zzb(this.zzo, zzyeVar.zzo).zzd(z, zzyeVar.zzf).zzc(Integer.valueOf(this.zzt), Integer.valueOf(zzyeVar.zzt), zzgab.zzc().zza());
        boolean z2 = this.zzh.zzB;
        zzfyf zzc2 = zzc.zzd(this.zzu, zzyeVar.zzu).zzd(this.zzv, zzyeVar.zzv).zzd(this.zzw, zzyeVar.zzw).zzc(Integer.valueOf(this.zzq), Integer.valueOf(zzyeVar.zzq), zza).zzc(Integer.valueOf(this.zzr), Integer.valueOf(zzyeVar.zzr), zza);
        if (Objects.equals(this.zzg, zzyeVar.zzg)) {
            zzc2 = zzc2.zzc(Integer.valueOf(this.zzs), Integer.valueOf(zzyeVar.zzs), zza);
        }
        return zzc2.zza();
    }
}
