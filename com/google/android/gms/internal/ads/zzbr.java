package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzbr {
    public final boolean zzA;
    public final boolean zzB;
    public final boolean zzC;
    public final zzfyt zzD;
    public final zzfyv zzE;
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final boolean zzk;
    public final boolean zzl;
    public final zzfyq zzm;
    public final zzfyq zzn;
    public final int zzo;
    public final zzfyq zzp;
    public final int zzq;
    public final int zzr;
    public final int zzs;
    public final zzfyq zzt;
    public final zzbp zzu;
    public final zzfyq zzv;
    public final int zzw;
    public final boolean zzx;
    public final int zzy;
    public final boolean zzz;

    static {
        new zzbr(new zzbq());
        String str = zzex.zza;
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
    }

    protected zzbr(zzbq zzbqVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        boolean z2;
        zzfyq zzfyqVar;
        zzfyq zzfyqVar2;
        zzfyq zzfyqVar3;
        int i7;
        int i8;
        zzfyq zzfyqVar4;
        zzbp zzbpVar;
        zzfyq zzfyqVar5;
        boolean z3;
        HashMap hashMap;
        HashSet hashSet;
        i = zzbqVar.zza;
        this.zza = i;
        i2 = zzbqVar.zzb;
        this.zzb = i2;
        i3 = zzbqVar.zzc;
        this.zzc = i3;
        i4 = zzbqVar.zzd;
        this.zzd = i4;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        i5 = zzbqVar.zze;
        this.zzi = i5;
        i6 = zzbqVar.zzf;
        this.zzj = i6;
        z = zzbqVar.zzg;
        this.zzk = z;
        z2 = zzbqVar.zzh;
        this.zzl = z2;
        zzfyqVar = zzbqVar.zzi;
        this.zzm = zzfyqVar;
        zzfyqVar2 = zzbqVar.zzj;
        this.zzn = zzfyqVar2;
        this.zzo = 0;
        zzfyqVar3 = zzbqVar.zzk;
        this.zzp = zzfyqVar3;
        this.zzq = 0;
        i7 = zzbqVar.zzl;
        this.zzr = i7;
        i8 = zzbqVar.zzm;
        this.zzs = i8;
        zzfyqVar4 = zzbqVar.zzn;
        this.zzt = zzfyqVar4;
        zzbpVar = zzbqVar.zzo;
        this.zzu = zzbpVar;
        zzfyqVar5 = zzbqVar.zzp;
        this.zzv = zzfyqVar5;
        this.zzw = 0;
        z3 = zzbqVar.zzq;
        this.zzx = z3;
        this.zzy = 0;
        this.zzz = false;
        this.zzA = false;
        this.zzB = false;
        this.zzC = false;
        hashMap = zzbqVar.zzr;
        this.zzD = zzfyt.zzc(hashMap);
        hashSet = zzbqVar.zzs;
        this.zzE = zzfyv.zzl(hashSet);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbr zzbrVar = (zzbr) obj;
            if (this.zza == zzbrVar.zza && this.zzb == zzbrVar.zzb && this.zzc == zzbrVar.zzc && this.zzd == zzbrVar.zzd && this.zzl == zzbrVar.zzl && this.zzi == zzbrVar.zzi && this.zzj == zzbrVar.zzj && this.zzk == zzbrVar.zzk && this.zzm.equals(zzbrVar.zzm) && this.zzn.equals(zzbrVar.zzn) && this.zzp.equals(zzbrVar.zzp) && this.zzr == zzbrVar.zzr && this.zzs == zzbrVar.zzs && this.zzt.equals(zzbrVar.zzt) && this.zzu.equals(zzbrVar.zzu) && this.zzv.equals(zzbrVar.zzv) && this.zzx == zzbrVar.zzx && this.zzD.equals(zzbrVar.zzD) && this.zzE.equals(zzbrVar.zzE)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((this.zza + 31) * 31) + this.zzb) * 31) + this.zzc) * 31) + this.zzd) * 28629151) + (this.zzl ? 1 : 0)) * 31) + this.zzi) * 31) + this.zzj) * 31) + (this.zzk ? 1 : 0)) * 31) + this.zzm.hashCode()) * 31) + this.zzn.hashCode()) * 961) + this.zzp.hashCode()) * 961) + this.zzr) * 31) + this.zzs) * 31) + this.zzt.hashCode()) * 31) + 29791) * 31) + this.zzv.hashCode()) * 961) + (this.zzx ? 1 : 0)) * 887503681) + this.zzD.hashCode()) * 31) + this.zzE.hashCode();
    }
}
