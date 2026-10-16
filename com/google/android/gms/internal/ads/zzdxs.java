package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdxs implements zzgdj {
    final /* synthetic */ zzdxt zza;

    zzdxs(zzdxt zzdxtVar) {
        Objects.requireNonNull(zzdxtVar);
        this.zza = zzdxtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        Pattern pattern;
        zzeaw zzeawVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgv)).booleanValue()) {
            pattern = zzdxt.zza;
            Matcher matcher = pattern.matcher(th.getMessage());
            if (matcher.matches()) {
                String group = matcher.group(1);
                zzeawVar = this.zza.zzf;
                zzeawVar.zzi(Integer.parseInt(group));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzeaw zzeawVar;
        zzeaw zzeawVar2;
        zzfcn zzfcnVar = (zzfcn) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgv)).booleanValue()) {
            zzdxt zzdxtVar = this.zza;
            zzeawVar = zzdxtVar.zzf;
            zzfcd zzfcdVar = zzfcnVar.zzb.zzb;
            zzeawVar.zzi(zzfcdVar.zzf);
            zzeawVar2 = zzdxtVar.zzf;
            zzeawVar2.zzj(zzfcdVar.zzg);
        }
    }
}
