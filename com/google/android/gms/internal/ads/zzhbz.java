package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzhbz extends zzhbx {
    zzhbz() {
    }

    @Override // com.google.android.gms.internal.ads.zzhbx
    final /* bridge */ /* synthetic */ Object zza(Object obj) {
        zzgzh zzgzhVar = (zzgzh) obj;
        zzhby zzhbyVar = zzgzhVar.zzt;
        if (zzhbyVar != zzhby.zzc()) {
            return zzhbyVar;
        }
        zzhby zzf = zzhby.zzf();
        zzgzhVar.zzt = zzf;
        return zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzhbx
    final /* synthetic */ Object zzb() {
        return zzhby.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzhbx
    final /* synthetic */ Object zzc(Object obj) {
        zzhby zzhbyVar = (zzhby) obj;
        zzhbyVar.zzh();
        return zzhbyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbx
    final /* bridge */ /* synthetic */ void zzd(Object obj, int i, int i2) {
        ((zzhby) obj).zzj((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzhbx
    final /* bridge */ /* synthetic */ void zze(Object obj, int i, long j) {
        ((zzhby) obj).zzj((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzhbx
    final /* bridge */ /* synthetic */ void zzf(Object obj, int i, Object obj2) {
        ((zzhby) obj).zzj((i << 3) | 3, (zzhby) obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzhbx
    final /* bridge */ /* synthetic */ void zzg(Object obj, int i, zzgxz zzgxzVar) {
        ((zzhby) obj).zzj((i << 3) | 2, zzgxzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbx
    final /* bridge */ /* synthetic */ void zzh(Object obj, int i, long j) {
        ((zzhby) obj).zzj(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzhbx
    final void zzi(Object obj) {
        ((zzgzh) obj).zzt.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzhbx
    final /* synthetic */ void zzj(Object obj, Object obj2) {
        ((zzgzh) obj).zzt = (zzhby) obj2;
    }
}
