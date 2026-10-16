package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaen {
    public int zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;

    public zzaen() {
    }

    public zzaen(zzaen zzaenVar) {
        this.zza = zzaenVar.zza;
        this.zzb = zzaenVar.zzb;
        this.zzc = zzaenVar.zzc;
        this.zzd = zzaenVar.zzd;
        this.zze = zzaenVar.zze;
        this.zzf = zzaenVar.zzf;
        this.zzg = zzaenVar.zzg;
    }

    public final boolean zza(int i) {
        boolean zzm;
        int i2;
        int i3;
        int i4;
        int i5;
        String[] strArr;
        int[] iArr;
        int zzl;
        int[] iArr2;
        int[] iArr3;
        int i6;
        int[] iArr4;
        int[] iArr5;
        int i7;
        int[] iArr6;
        zzm = zzaeo.zzm(i);
        if (!zzm || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return false;
        }
        int i8 = i4 - 1;
        this.zza = i2;
        strArr = zzaeo.zza;
        this.zzb = strArr[3 - i3];
        iArr = zzaeo.zzb;
        int i9 = iArr[i5];
        this.zzd = i9;
        if (i2 == 2) {
            i9 /= 2;
            this.zzd = i9;
        } else if (i2 == 0) {
            i9 /= 4;
            this.zzd = i9;
        }
        int i10 = (i >>> 9) & 1;
        zzl = zzaeo.zzl(i2, i3);
        this.zzg = zzl;
        if (i3 == 3) {
            if (i2 == 3) {
                iArr6 = zzaeo.zzc;
                i7 = iArr6[i8];
            } else {
                iArr5 = zzaeo.zzd;
                i7 = iArr5[i8];
            }
            this.zzf = i7;
            this.zzc = (((i7 * 12) / i9) + i10) * 4;
        } else {
            if (i2 == 3) {
                if (i3 == 2) {
                    iArr4 = zzaeo.zze;
                    i6 = iArr4[i8];
                } else {
                    iArr3 = zzaeo.zzf;
                    i6 = iArr3[i8];
                }
                this.zzf = i6;
                this.zzc = ((i6 * 144) / i9) + i10;
            } else {
                iArr2 = zzaeo.zzg;
                int i11 = iArr2[i8];
                this.zzf = i11;
                this.zzc = (((i3 == 1 ? 72 : 144) * i11) / i9) + i10;
            }
        }
        this.zze = ((i >> 6) & 3) == 3 ? 1 : 2;
        return true;
    }
}
