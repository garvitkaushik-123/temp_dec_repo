package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzz {
    public static final /* synthetic */ int zzO = 0;
    public final int zzA;
    public final float zzB;
    public final byte[] zzC;
    public final int zzD;
    public final zzk zzE;
    public final int zzF;
    public final int zzG;
    public final int zzH;
    public final int zzI;
    public final int zzJ;
    public final int zzK;
    public final int zzL;
    public final int zzM;
    public final int zzN;
    private int zzP;
    public final String zza;
    public final String zzb;
    public final List zzc;
    public final String zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final String zzk;
    public final zzav zzl;
    public final Object zzm;
    public final String zzn;
    public final String zzo;
    public final int zzp;
    public final int zzq;
    public final List zzr;
    public final zzs zzs;
    public final long zzt;
    public final boolean zzu;
    public final int zzv;
    public final int zzw;
    public final int zzx;
    public final int zzy;
    public final float zzz;

    static {
        new zzz(new zzx());
        String str = zzex.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
        Integer.toString(14, 36);
        Integer.toString(15, 36);
        Integer.toString(16, 36);
        Integer.toString(17, 36);
        Integer.toString(18, 36);
        Integer.toString(19, 36);
        Integer.toString(20, 36);
        Integer.toString(21, 36);
        Integer.toString(22, 36);
        Integer.toString(23, 36);
        Integer.toString(24, 36);
        Integer.toString(25, 36);
        Integer.toString(26, 36);
        Integer.toString(27, 36);
        Integer.toString(28, 36);
        Integer.toString(29, 36);
        Integer.toString(30, 36);
        Integer.toString(31, 36);
        Integer.toString(32, 36);
        Integer.toString(33, 36);
        Integer.toString(34, 36);
        Integer.toString(35, 36);
        Integer.toString(36, 36);
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x008a, code lost:
    
        if (r0 == null) goto L23;
     */
    /* JADX WARN: Incorrect condition in loop: B:65:0x0097 */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01e0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private zzz(zzx zzxVar) {
        String str;
        String str2;
        List list;
        List list2;
        List list3;
        List list4;
        boolean z;
        List list5;
        String str3;
        List list6;
        String str4;
        String str5;
        String str6;
        List list7;
        List list8;
        String str7;
        int i;
        int i2;
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str8;
        zzav zzavVar;
        String str9;
        String str10;
        int i7;
        int i8;
        List list9;
        zzs zzsVar;
        long j;
        boolean z3;
        int i9;
        int i10;
        int i11;
        int i12;
        float f;
        int i13;
        float f2;
        byte[] bArr;
        int i14;
        zzk zzkVar;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        String str11;
        String str12;
        String str13;
        str = zzxVar.zza;
        this.zza = str;
        str2 = zzxVar.zzd;
        String zzE = zzex.zzE(str2);
        this.zzd = zzE;
        list = zzxVar.zzc;
        if (list.isEmpty()) {
            str11 = zzxVar.zzb;
            if (str11 != null) {
                str12 = zzxVar.zzb;
                this.zzc = zzfyq.zzo(new zzab(zzE, str12));
                str13 = zzxVar.zzb;
                this.zzb = str13;
                i = zzxVar.zze;
                this.zze = i;
                i2 = zzxVar.zzg;
                if (i2 != 0) {
                    i25 = zzxVar.zzf;
                    if ((i25 & 32768) == 0) {
                        z2 = false;
                        zzdd.zzg(z2, "Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set");
                        i3 = zzxVar.zzf;
                        this.zzf = i3;
                        i4 = zzxVar.zzg;
                        this.zzg = i4;
                        i5 = zzxVar.zzh;
                        this.zzh = i5;
                        i6 = zzxVar.zzi;
                        this.zzi = i6;
                        this.zzj = i6 != -1 ? i6 : i5;
                        str8 = zzxVar.zzj;
                        this.zzk = str8;
                        zzavVar = zzxVar.zzk;
                        this.zzl = zzavVar;
                        this.zzm = null;
                        str9 = zzxVar.zzl;
                        this.zzn = str9;
                        str10 = zzxVar.zzm;
                        this.zzo = str10;
                        i7 = zzxVar.zzn;
                        this.zzp = i7;
                        i8 = zzxVar.zzo;
                        this.zzq = i8;
                        list9 = zzxVar.zzp;
                        this.zzr = list9 != null ? Collections.emptyList() : zzxVar.zzp;
                        zzsVar = zzxVar.zzq;
                        this.zzs = zzsVar;
                        j = zzxVar.zzr;
                        this.zzt = j;
                        z3 = zzxVar.zzs;
                        this.zzu = z3;
                        i9 = zzxVar.zzt;
                        this.zzv = i9;
                        i10 = zzxVar.zzu;
                        this.zzw = i10;
                        i11 = zzxVar.zzv;
                        this.zzx = i11;
                        i12 = zzxVar.zzw;
                        this.zzy = i12;
                        f = zzxVar.zzx;
                        this.zzz = f;
                        i13 = zzxVar.zzy;
                        this.zzA = i13 != -1 ? 0 : zzxVar.zzy;
                        f2 = zzxVar.zzz;
                        this.zzB = f2 != -1.0f ? 1.0f : zzxVar.zzz;
                        bArr = zzxVar.zzA;
                        this.zzC = bArr;
                        i14 = zzxVar.zzB;
                        this.zzD = i14;
                        zzkVar = zzxVar.zzC;
                        this.zzE = zzkVar;
                        i15 = zzxVar.zzD;
                        this.zzF = i15;
                        i16 = zzxVar.zzE;
                        this.zzG = i16;
                        i17 = zzxVar.zzF;
                        this.zzH = i17;
                        i18 = zzxVar.zzG;
                        this.zzI = i18;
                        i19 = zzxVar.zzH;
                        this.zzJ = i19 != -1 ? 0 : zzxVar.zzH;
                        i20 = zzxVar.zzI;
                        this.zzK = i20 != -1 ? zzxVar.zzI : 0;
                        i21 = zzxVar.zzJ;
                        this.zzL = i21;
                        i22 = zzxVar.zzK;
                        this.zzM = i22;
                        i23 = zzxVar.zzL;
                        if (i23 != 0 && zzsVar != null) {
                            this.zzN = 1;
                            return;
                        } else {
                            i24 = zzxVar.zzL;
                            this.zzN = i24;
                        }
                    }
                }
                z2 = true;
                zzdd.zzg(z2, "Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set");
                i3 = zzxVar.zzf;
                this.zzf = i3;
                i4 = zzxVar.zzg;
                this.zzg = i4;
                i5 = zzxVar.zzh;
                this.zzh = i5;
                i6 = zzxVar.zzi;
                this.zzi = i6;
                this.zzj = i6 != -1 ? i6 : i5;
                str8 = zzxVar.zzj;
                this.zzk = str8;
                zzavVar = zzxVar.zzk;
                this.zzl = zzavVar;
                this.zzm = null;
                str9 = zzxVar.zzl;
                this.zzn = str9;
                str10 = zzxVar.zzm;
                this.zzo = str10;
                i7 = zzxVar.zzn;
                this.zzp = i7;
                i8 = zzxVar.zzo;
                this.zzq = i8;
                list9 = zzxVar.zzp;
                this.zzr = list9 != null ? Collections.emptyList() : zzxVar.zzp;
                zzsVar = zzxVar.zzq;
                this.zzs = zzsVar;
                j = zzxVar.zzr;
                this.zzt = j;
                z3 = zzxVar.zzs;
                this.zzu = z3;
                i9 = zzxVar.zzt;
                this.zzv = i9;
                i10 = zzxVar.zzu;
                this.zzw = i10;
                i11 = zzxVar.zzv;
                this.zzx = i11;
                i12 = zzxVar.zzw;
                this.zzy = i12;
                f = zzxVar.zzx;
                this.zzz = f;
                i13 = zzxVar.zzy;
                this.zzA = i13 != -1 ? 0 : zzxVar.zzy;
                f2 = zzxVar.zzz;
                this.zzB = f2 != -1.0f ? 1.0f : zzxVar.zzz;
                bArr = zzxVar.zzA;
                this.zzC = bArr;
                i14 = zzxVar.zzB;
                this.zzD = i14;
                zzkVar = zzxVar.zzC;
                this.zzE = zzkVar;
                i15 = zzxVar.zzD;
                this.zzF = i15;
                i16 = zzxVar.zzE;
                this.zzG = i16;
                i17 = zzxVar.zzF;
                this.zzH = i17;
                i18 = zzxVar.zzG;
                this.zzI = i18;
                i19 = zzxVar.zzH;
                this.zzJ = i19 != -1 ? 0 : zzxVar.zzH;
                i20 = zzxVar.zzI;
                this.zzK = i20 != -1 ? zzxVar.zzI : 0;
                i21 = zzxVar.zzJ;
                this.zzL = i21;
                i22 = zzxVar.zzK;
                this.zzM = i22;
                i23 = zzxVar.zzL;
                if (i23 != 0) {
                }
                i24 = zzxVar.zzL;
                this.zzN = i24;
            }
        }
        list2 = zzxVar.zzc;
        if (!list2.isEmpty()) {
            str6 = zzxVar.zzb;
            if (str6 == null) {
                list7 = zzxVar.zzc;
                this.zzc = list7;
                list8 = zzxVar.zzc;
                Iterator it = list8.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str7 = ((zzab) list8.get(0)).zzb;
                        break;
                    }
                    zzab zzabVar = (zzab) it.next();
                    if (TextUtils.equals(zzabVar.zza, zzE)) {
                        str7 = zzabVar.zzb;
                        break;
                    }
                }
                this.zzb = str7;
                i = zzxVar.zze;
                this.zze = i;
                i2 = zzxVar.zzg;
                if (i2 != 0) {
                }
                z2 = true;
                zzdd.zzg(z2, "Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set");
                i3 = zzxVar.zzf;
                this.zzf = i3;
                i4 = zzxVar.zzg;
                this.zzg = i4;
                i5 = zzxVar.zzh;
                this.zzh = i5;
                i6 = zzxVar.zzi;
                this.zzi = i6;
                this.zzj = i6 != -1 ? i6 : i5;
                str8 = zzxVar.zzj;
                this.zzk = str8;
                zzavVar = zzxVar.zzk;
                this.zzl = zzavVar;
                this.zzm = null;
                str9 = zzxVar.zzl;
                this.zzn = str9;
                str10 = zzxVar.zzm;
                this.zzo = str10;
                i7 = zzxVar.zzn;
                this.zzp = i7;
                i8 = zzxVar.zzo;
                this.zzq = i8;
                list9 = zzxVar.zzp;
                this.zzr = list9 != null ? Collections.emptyList() : zzxVar.zzp;
                zzsVar = zzxVar.zzq;
                this.zzs = zzsVar;
                j = zzxVar.zzr;
                this.zzt = j;
                z3 = zzxVar.zzs;
                this.zzu = z3;
                i9 = zzxVar.zzt;
                this.zzv = i9;
                i10 = zzxVar.zzu;
                this.zzw = i10;
                i11 = zzxVar.zzv;
                this.zzx = i11;
                i12 = zzxVar.zzw;
                this.zzy = i12;
                f = zzxVar.zzx;
                this.zzz = f;
                i13 = zzxVar.zzy;
                this.zzA = i13 != -1 ? 0 : zzxVar.zzy;
                f2 = zzxVar.zzz;
                this.zzB = f2 != -1.0f ? 1.0f : zzxVar.zzz;
                bArr = zzxVar.zzA;
                this.zzC = bArr;
                i14 = zzxVar.zzB;
                this.zzD = i14;
                zzkVar = zzxVar.zzC;
                this.zzE = zzkVar;
                i15 = zzxVar.zzD;
                this.zzF = i15;
                i16 = zzxVar.zzE;
                this.zzG = i16;
                i17 = zzxVar.zzF;
                this.zzH = i17;
                i18 = zzxVar.zzG;
                this.zzI = i18;
                i19 = zzxVar.zzH;
                this.zzJ = i19 != -1 ? 0 : zzxVar.zzH;
                i20 = zzxVar.zzI;
                this.zzK = i20 != -1 ? zzxVar.zzI : 0;
                i21 = zzxVar.zzJ;
                this.zzL = i21;
                i22 = zzxVar.zzK;
                this.zzM = i22;
                i23 = zzxVar.zzL;
                if (i23 != 0) {
                }
                i24 = zzxVar.zzL;
                this.zzN = i24;
            }
        }
        list3 = zzxVar.zzc;
        if (list3.isEmpty()) {
            str5 = zzxVar.zzb;
        }
        for (int i26 = 0; i26 < list4.size(); i26++) {
            list5 = zzxVar.zzc;
            String str14 = ((zzab) list5.get(i26)).zzb;
            str3 = zzxVar.zzb;
            if (str14.equals(str3)) {
                z = true;
                break;
            }
        }
        z = false;
        zzdd.zzf(z);
        list6 = zzxVar.zzc;
        this.zzc = list6;
        str4 = zzxVar.zzb;
        this.zzb = str4;
        i = zzxVar.zze;
        this.zze = i;
        i2 = zzxVar.zzg;
        if (i2 != 0) {
        }
        z2 = true;
        zzdd.zzg(z2, "Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set");
        i3 = zzxVar.zzf;
        this.zzf = i3;
        i4 = zzxVar.zzg;
        this.zzg = i4;
        i5 = zzxVar.zzh;
        this.zzh = i5;
        i6 = zzxVar.zzi;
        this.zzi = i6;
        this.zzj = i6 != -1 ? i6 : i5;
        str8 = zzxVar.zzj;
        this.zzk = str8;
        zzavVar = zzxVar.zzk;
        this.zzl = zzavVar;
        this.zzm = null;
        str9 = zzxVar.zzl;
        this.zzn = str9;
        str10 = zzxVar.zzm;
        this.zzo = str10;
        i7 = zzxVar.zzn;
        this.zzp = i7;
        i8 = zzxVar.zzo;
        this.zzq = i8;
        list9 = zzxVar.zzp;
        this.zzr = list9 != null ? Collections.emptyList() : zzxVar.zzp;
        zzsVar = zzxVar.zzq;
        this.zzs = zzsVar;
        j = zzxVar.zzr;
        this.zzt = j;
        z3 = zzxVar.zzs;
        this.zzu = z3;
        i9 = zzxVar.zzt;
        this.zzv = i9;
        i10 = zzxVar.zzu;
        this.zzw = i10;
        i11 = zzxVar.zzv;
        this.zzx = i11;
        i12 = zzxVar.zzw;
        this.zzy = i12;
        f = zzxVar.zzx;
        this.zzz = f;
        i13 = zzxVar.zzy;
        this.zzA = i13 != -1 ? 0 : zzxVar.zzy;
        f2 = zzxVar.zzz;
        this.zzB = f2 != -1.0f ? 1.0f : zzxVar.zzz;
        bArr = zzxVar.zzA;
        this.zzC = bArr;
        i14 = zzxVar.zzB;
        this.zzD = i14;
        zzkVar = zzxVar.zzC;
        this.zzE = zzkVar;
        i15 = zzxVar.zzD;
        this.zzF = i15;
        i16 = zzxVar.zzE;
        this.zzG = i16;
        i17 = zzxVar.zzF;
        this.zzH = i17;
        i18 = zzxVar.zzG;
        this.zzI = i18;
        i19 = zzxVar.zzH;
        this.zzJ = i19 != -1 ? 0 : zzxVar.zzH;
        i20 = zzxVar.zzI;
        this.zzK = i20 != -1 ? zzxVar.zzI : 0;
        i21 = zzxVar.zzJ;
        this.zzL = i21;
        i22 = zzxVar.zzK;
        this.zzM = i22;
        i23 = zzxVar.zzL;
        if (i23 != 0) {
        }
        i24 = zzxVar.zzL;
        this.zzN = i24;
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzz zzzVar = (zzz) obj;
            int i2 = this.zzP;
            if ((i2 == 0 || (i = zzzVar.zzP) == 0 || i2 == i) && this.zze == zzzVar.zze && this.zzf == zzzVar.zzf && this.zzg == zzzVar.zzg && this.zzh == zzzVar.zzh && this.zzi == zzzVar.zzi && this.zzp == zzzVar.zzp && this.zzt == zzzVar.zzt && this.zzv == zzzVar.zzv && this.zzw == zzzVar.zzw && this.zzx == zzzVar.zzx && this.zzy == zzzVar.zzy && this.zzA == zzzVar.zzA && this.zzD == zzzVar.zzD && this.zzF == zzzVar.zzF && this.zzG == zzzVar.zzG && this.zzH == zzzVar.zzH && this.zzI == zzzVar.zzI && this.zzJ == zzzVar.zzJ && this.zzK == zzzVar.zzK && this.zzL == zzzVar.zzL && this.zzN == zzzVar.zzN && Float.compare(this.zzz, zzzVar.zzz) == 0 && Float.compare(this.zzB, zzzVar.zzB) == 0 && Objects.equals(this.zza, zzzVar.zza) && Objects.equals(this.zzb, zzzVar.zzb) && this.zzc.equals(zzzVar.zzc) && Objects.equals(this.zzk, zzzVar.zzk) && Objects.equals(this.zzn, zzzVar.zzn) && Objects.equals(this.zzo, zzzVar.zzo) && Objects.equals(this.zzd, zzzVar.zzd) && Arrays.equals(this.zzC, zzzVar.zzC) && Objects.equals(this.zzl, zzzVar.zzl) && Objects.equals(this.zzE, zzzVar.zzE) && Objects.equals(this.zzs, zzzVar.zzs) && zzd(zzzVar) && Objects.equals(null, null)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return "Format(" + this.zza + ", " + this.zzb + ", " + this.zzn + ", " + this.zzo + ", " + this.zzk + ", " + this.zzj + ", " + this.zzd + ", [" + this.zzv + ", " + this.zzw + ", " + this.zzz + ", " + String.valueOf(this.zzE) + "], [" + this.zzG + ", " + this.zzH + "])";
    }

    public final int zza() {
        int i;
        int i2 = this.zzv;
        if (i2 == -1 || (i = this.zzw) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final zzx zzb() {
        return new zzx(this, null);
    }

    public final zzz zzc(int i) {
        zzx zzxVar = new zzx(this, null);
        zzxVar.zzH(i);
        return new zzz(zzxVar);
    }

    public final boolean zzd(zzz zzzVar) {
        List list = this.zzr;
        int size = list.size();
        List list2 = zzzVar.zzr;
        if (size != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = this.zzP;
        if (i != 0) {
            return i;
        }
        String str = this.zza;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.zzb;
        int hashCode2 = ((((hashCode + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + (str2 == null ? 0 : str2.hashCode())) * 31) + this.zzc.hashCode();
        String str3 = this.zzd;
        int hashCode3 = ((((((((((((hashCode2 * 31) + (str3 == null ? 0 : str3.hashCode())) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + this.zzh) * 31) + this.zzi) * 31;
        String str4 = this.zzk;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        zzav zzavVar = this.zzl;
        int hashCode5 = hashCode4 + (zzavVar == null ? 0 : zzavVar.hashCode());
        String str5 = this.zzn;
        int hashCode6 = ((hashCode5 * 961) + (str5 == null ? 0 : str5.hashCode())) * 31;
        int hashCode7 = ((((((((((((((((((((((((((((((((((((((((hashCode6 + (this.zzo != null ? r2.hashCode() : 0)) * 31) + this.zzp) * 31) + ((int) this.zzt)) * 31) + this.zzv) * 31) + this.zzw) * 31) + this.zzx) * 31) + this.zzy) * 31) + Float.floatToIntBits(this.zzz)) * 31) + this.zzA) * 31) + Float.floatToIntBits(this.zzB)) * 31) + this.zzD) * 31) + this.zzF) * 31) + this.zzG) * 31) + this.zzH) * 31) + this.zzI) * 31) + this.zzJ) * 31) + this.zzK) * 31) + this.zzL) * 31) - 1) * 31) - 1) * 31) + this.zzN;
        this.zzP = hashCode7;
        return hashCode7;
    }
}
