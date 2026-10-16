package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgyn implements zzhcm {
    private final zzgym zza;

    private zzgyn(zzgym zzgymVar) {
        zzgzu.zzc(zzgymVar, "output");
        this.zza = zzgymVar;
        zzgymVar.zze = this;
    }

    public static zzgyn zza(zzgym zzgymVar) {
        zzgyn zzgynVar = zzgymVar.zze;
        return zzgynVar != null ? zzgynVar : new zzgyn(zzgymVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzB(int i, int i2) throws IOException {
        this.zza.zzt(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzD(int i, long j) throws IOException {
        this.zza.zzv(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    @Deprecated
    public final void zzF(int i) throws IOException {
        this.zza.zzs(i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzG(int i, String str) throws IOException {
        this.zza.zzq(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzI(int i, int i2) throws IOException {
        this.zza.zzt(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzK(int i, long j) throws IOException {
        this.zza.zzv(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzM(i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzd(int i, zzgxz zzgxzVar) throws IOException {
        this.zza.zzN(i, zzgxzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzN(i, (zzgxz) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzf(int i, double d) throws IOException {
        this.zza.zzj(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzs(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzm(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzo(int i, float f) throws IOException {
        this.zza.zzh(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzq(int i, Object obj, zzhbl zzhblVar) throws IOException {
        zzgym zzgymVar = this.zza;
        zzgymVar.zzs(i, 3);
        zzhblVar.zzj((zzhas) obj, zzgymVar.zze);
        zzgymVar.zzs(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzt(int i, long j) throws IOException {
        this.zza.zzv(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzv(int i, Object obj, zzhbl zzhblVar) throws IOException {
        this.zza.zzn(i, (zzhas) obj, zzhblVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzw(int i, Object obj) throws IOException {
        if (obj instanceof zzgxz) {
            this.zza.zzp(i, (zzgxz) obj);
        } else {
            this.zza.zzo(i, (zzhas) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzx(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzz(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzH(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhae)) {
            while (i2 < list.size()) {
                this.zza.zzq(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzhae zzhaeVar = (zzhae) list;
        while (i2 < list.size()) {
            Object zzc = zzhaeVar.zzc();
            if (zzc instanceof String) {
                this.zza.zzq(i, (String) zzc);
            } else {
                this.zza.zzN(i, (zzgxz) zzc);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgzi)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzt(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgym.zzD(((Integer) list.get(i4)).intValue());
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgzi zzgziVar = (zzgzi) list;
        if (!z) {
            while (i2 < zzgziVar.size()) {
                this.zza.zzt(i, zzgziVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgziVar.size(); i6++) {
            i5 += zzgym.zzD(zzgziVar.zzd(i6));
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzgziVar.size()) {
            zzgymVar2.zzu(zzgziVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhah)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgym.zzE(((Long) list.get(i4)).longValue());
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhah zzhahVar = (zzhah) list;
        if (!z) {
            while (i2 < zzhahVar.size()) {
                this.zza.zzv(i, zzhahVar.zza(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzhahVar.size(); i6++) {
            i5 += zzgym.zzE(zzhahVar.zza(i6));
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzhahVar.size()) {
            zzgymVar2.zzw(zzhahVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgzi)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgzi zzgziVar = (zzgzi) list;
        if (!z) {
            while (i2 < zzgziVar.size()) {
                this.zza.zzh(i, zzgziVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgziVar.size(); i6++) {
            zzgziVar.zzd(i6);
            i5 += 4;
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzgziVar.size()) {
            zzgymVar2.zzi(zzgziVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhah)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhah zzhahVar = (zzhah) list;
        if (!z) {
            while (i2 < zzhahVar.size()) {
                this.zza.zzj(i, zzhahVar.zza(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzhahVar.size(); i6++) {
            zzhahVar.zza(i6);
            i5 += 8;
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzhahVar.size()) {
            zzgymVar2.zzk(zzhahVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgxp)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzM(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzL(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzgxp zzgxpVar = (zzgxp) list;
        if (!z) {
            while (i2 < zzgxpVar.size()) {
                this.zza.zzM(i, zzgxpVar.zzh(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgxpVar.size(); i6++) {
            zzgxpVar.zzh(i6);
            i5++;
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzgxpVar.size()) {
            zzgymVar2.zzL(zzgxpVar.zzh(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgzi)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgym.zzE(((Integer) list.get(i4)).intValue());
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgzi zzgziVar = (zzgzi) list;
        if (!z) {
            while (i2 < zzgziVar.size()) {
                this.zza.zzl(i, zzgziVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgziVar.size(); i6++) {
            i5 += zzgym.zzE(zzgziVar.zzd(i6));
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzgziVar.size()) {
            zzgymVar2.zzm(zzgziVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhah)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhah zzhahVar = (zzhah) list;
        if (!z) {
            while (i2 < zzhahVar.size()) {
                this.zza.zzj(i, zzhahVar.zza(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzhahVar.size(); i6++) {
            zzhahVar.zza(i6);
            i5 += 8;
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzhahVar.size()) {
            zzgymVar2.zzk(zzhahVar.zza(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgyo)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzk(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzgyo zzgyoVar = (zzgyo) list;
        if (!z) {
            while (i2 < zzgyoVar.size()) {
                this.zza.zzj(i, Double.doubleToRawLongBits(zzgyoVar.zzd(i2)));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgyoVar.size(); i6++) {
            zzgyoVar.zzd(i6);
            i5 += 8;
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzgyoVar.size()) {
            zzgymVar2.zzk(Double.doubleToRawLongBits(zzgyoVar.zzd(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgyy)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzi(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzgyy zzgyyVar = (zzgyy) list;
        if (!z) {
            while (i2 < zzgyyVar.size()) {
                this.zza.zzh(i, Float.floatToRawIntBits(zzgyyVar.zzd(i2)));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgyyVar.size(); i6++) {
            zzgyyVar.zzd(i6);
            i5 += 4;
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzgyyVar.size()) {
            zzgymVar2.zzi(Float.floatToRawIntBits(zzgyyVar.zzd(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgzi)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgzi zzgziVar = (zzgzi) list;
        if (!z) {
            while (i2 < zzgziVar.size()) {
                this.zza.zzh(i, zzgziVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgziVar.size(); i6++) {
            zzgziVar.zzd(i6);
            i5 += 4;
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzgziVar.size()) {
            zzgymVar2.zzi(zzgziVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgzi)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzgym zzgymVar = this.zza;
                    int intValue = ((Integer) list.get(i2)).intValue();
                    zzgymVar.zzt(i, (intValue >> 31) ^ (intValue + intValue));
                    i2++;
                }
                return;
            }
            zzgym zzgymVar2 = this.zza;
            zzgymVar2.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                int intValue2 = ((Integer) list.get(i4)).intValue();
                i3 += zzgym.zzD((intValue2 >> 31) ^ (intValue2 + intValue2));
            }
            zzgymVar2.zzu(i3);
            while (i2 < list.size()) {
                int intValue3 = ((Integer) list.get(i2)).intValue();
                zzgymVar2.zzu((intValue3 >> 31) ^ (intValue3 + intValue3));
                i2++;
            }
            return;
        }
        zzgzi zzgziVar = (zzgzi) list;
        if (!z) {
            while (i2 < zzgziVar.size()) {
                zzgym zzgymVar3 = this.zza;
                int zzd = zzgziVar.zzd(i2);
                zzgymVar3.zzt(i, (zzd >> 31) ^ (zzd + zzd));
                i2++;
            }
            return;
        }
        zzgym zzgymVar4 = this.zza;
        zzgymVar4.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgziVar.size(); i6++) {
            int zzd2 = zzgziVar.zzd(i6);
            i5 += zzgym.zzD((zzd2 >> 31) ^ (zzd2 + zzd2));
        }
        zzgymVar4.zzu(i5);
        while (i2 < zzgziVar.size()) {
            int zzd3 = zzgziVar.zzd(i2);
            zzgymVar4.zzu((zzd3 >> 31) ^ (zzd3 + zzd3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhah)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzgym zzgymVar = this.zza;
                    long longValue = ((Long) list.get(i2)).longValue();
                    zzgymVar.zzv(i, (longValue >> 63) ^ (longValue + longValue));
                    i2++;
                }
                return;
            }
            zzgym zzgymVar2 = this.zza;
            zzgymVar2.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                long longValue2 = ((Long) list.get(i4)).longValue();
                i3 += zzgym.zzE((longValue2 >> 63) ^ (longValue2 + longValue2));
            }
            zzgymVar2.zzu(i3);
            while (i2 < list.size()) {
                long longValue3 = ((Long) list.get(i2)).longValue();
                zzgymVar2.zzw((longValue3 >> 63) ^ (longValue3 + longValue3));
                i2++;
            }
            return;
        }
        zzhah zzhahVar = (zzhah) list;
        if (!z) {
            while (i2 < zzhahVar.size()) {
                zzgym zzgymVar3 = this.zza;
                long zza = zzhahVar.zza(i2);
                zzgymVar3.zzv(i, (zza >> 63) ^ (zza + zza));
                i2++;
            }
            return;
        }
        zzgym zzgymVar4 = this.zza;
        zzgymVar4.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzhahVar.size(); i6++) {
            long zza2 = zzhahVar.zza(i6);
            i5 += zzgym.zzE((zza2 >> 63) ^ (zza2 + zza2));
        }
        zzgymVar4.zzu(i5);
        while (i2 < zzhahVar.size()) {
            long zza3 = zzhahVar.zza(i2);
            zzgymVar4.zzw((zza3 >> 63) ^ (zza3 + zza3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgzi)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgym.zzE(((Integer) list.get(i4)).intValue());
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgzi zzgziVar = (zzgzi) list;
        if (!z) {
            while (i2 < zzgziVar.size()) {
                this.zza.zzl(i, zzgziVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgziVar.size(); i6++) {
            i5 += zzgym.zzE(zzgziVar.zzd(i6));
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzgziVar.size()) {
            zzgymVar2.zzm(zzgziVar.zzd(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcm
    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhah)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzgym zzgymVar = this.zza;
            zzgymVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgym.zzE(((Long) list.get(i4)).longValue());
            }
            zzgymVar.zzu(i3);
            while (i2 < list.size()) {
                zzgymVar.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhah zzhahVar = (zzhah) list;
        if (!z) {
            while (i2 < zzhahVar.size()) {
                this.zza.zzv(i, zzhahVar.zza(i2));
                i2++;
            }
            return;
        }
        zzgym zzgymVar2 = this.zza;
        zzgymVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzhahVar.size(); i6++) {
            i5 += zzgym.zzE(zzhahVar.zza(i6));
        }
        zzgymVar2.zzu(i5);
        while (i2 < zzhahVar.size()) {
            zzgymVar2.zzw(zzhahVar.zza(i2));
            i2++;
        }
    }
}
