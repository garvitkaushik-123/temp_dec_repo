package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzezu implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzezu(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
    }

    public static zzezu zzc(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        return new zzezu(zzhhaVar, zzhhaVar2, zzhhaVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzezr zzb() {
        zzezr zzezgVar;
        Context context = (Context) this.zza.zzb();
        zzfef zzfefVar = (zzfef) this.zzb.zzb();
        zzfex zzfexVar = (zzfex) this.zzc.zzb();
        zzbzm zzg = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgA)).booleanValue() ? com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg() : com.google.android.gms.ads.internal.zzv.zzp().zzi().zzh();
        boolean z = false;
        if (zzg != null && zzg.zzh()) {
            z = true;
        }
        if (((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgC)).intValue() > 0) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgz)).booleanValue() || z) {
                zzfew zza = zzfexVar.zza(zzfen.Rewarded, context, zzfefVar, new zzeyv(new zzeys()));
                zzezh zzezhVar = new zzezh(new zzezg());
                zzfej zzfejVar = zza.zza;
                zzgdy zzgdyVar = zzcaf.zza;
                zzezgVar = new zzeyx(zzezhVar, new zzezd(zzfejVar, zzgdyVar), zza.zzb, zzfejVar.zza().zzf, zzgdyVar);
                return zzezgVar;
            }
        }
        zzezgVar = new zzezg();
        return zzezgVar;
    }
}
