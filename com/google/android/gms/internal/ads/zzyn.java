package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzyn extends zzyp implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;

    public zzyn(int i, zzbm zzbmVar, int i2, zzyi zzyiVar, int i3, String str, String str2) {
        super(i, zzbmVar, i2);
        int i4;
        int i5;
        int i6 = 0;
        this.zzf = zzmb.zza(i3, false);
        int i7 = this.zzd.zze;
        int i8 = zzyiVar.zzy;
        this.zzg = 1 == (i7 & 1);
        this.zzh = (i7 & 2) != 0;
        zzfyq zzo = str2 != null ? zzfyq.zzo(str2) : zzyiVar.zzv.isEmpty() ? zzfyq.zzo("") : zzyiVar.zzv;
        int i9 = 0;
        while (true) {
            if (i9 >= zzo.size()) {
                i9 = Integer.MAX_VALUE;
                i4 = 0;
                break;
            }
            zzz zzzVar = this.zzd;
            String str3 = (String) zzo.get(i9);
            boolean z = zzyiVar.zzz;
            i4 = zzyu.zzc(zzzVar, str3, false);
            if (i4 > 0) {
                break;
            } else {
                i9++;
            }
        }
        this.zzi = i9;
        this.zzj = i4;
        if (str2 != null) {
            i5 = 1088;
        } else {
            int i10 = zzyiVar.zzw;
            i5 = 0;
        }
        int zzb = zzyu.zzb(this.zzd.zzf, i5);
        this.zzk = zzb;
        this.zzm = (1088 & this.zzd.zzf) != 0;
        int zzc = zzyu.zzc(this.zzd, str, zzyu.zzh(str) == null);
        this.zzl = zzc;
        boolean z2 = i4 > 0 || (zzyiVar.zzv.isEmpty() && zzb > 0) || this.zzg || (this.zzh && zzc > 0);
        if (zzmb.zza(i3, zzyiVar.zzR) && z2) {
            i6 = 1;
        }
        this.zze = i6;
    }

    @Override // java.lang.Comparable
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzyn zzynVar) {
        zzfyf zzc = zzfyf.zzj().zzd(this.zzf, zzynVar.zzf).zzc(Integer.valueOf(this.zzi), Integer.valueOf(zzynVar.zzi), zzgab.zzc().zza());
        int i = this.zzj;
        zzfyf zzb = zzc.zzb(i, zzynVar.zzj);
        int i2 = this.zzk;
        zzfyf zzb2 = zzb.zzb(i2, zzynVar.zzk).zzd(this.zzg, zzynVar.zzg).zzc(Boolean.valueOf(this.zzh), Boolean.valueOf(zzynVar.zzh), i == 0 ? zzgab.zzc() : zzgab.zzc().zza()).zzb(this.zzl, zzynVar.zzl);
        if (i2 == 0) {
            zzb2 = zzb2.zze(this.zzm, zzynVar.zzm);
        }
        return zzb2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final /* bridge */ /* synthetic */ boolean zzc(zzyp zzypVar) {
        return false;
    }
}
