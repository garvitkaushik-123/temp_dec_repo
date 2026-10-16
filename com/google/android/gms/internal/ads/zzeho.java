package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeho implements zzeds {
    private final Context zza;
    private final Executor zzb;
    private final zzdos zzc;

    public zzeho(Context context, Executor executor, zzdos zzdosVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdosVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd, zzehf {
        zzdoo zzd = this.zzc.zzd(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdop(new zzehn(this, zzedpVar, zzfcaVar)));
        zzd.zzd().zzo(new zzcmg((zzfdu) zzedpVar.zzb), this.zzb);
        ((zzefd) zzedpVar.zzc).zzc(zzd.zzn());
        return zzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        try {
            zzfcw zzfcwVar = zzfcnVar.zza.zza;
            if (zzfcwVar.zzo.zza == 3) {
                ((zzfdu) zzedpVar.zzb).zzr(this.zza, zzfcwVar.zzd, zzfcaVar.zzv.toString(), (zzbpw) zzedpVar.zzc);
            } else {
                ((zzfdu) zzedpVar.zzb).zzq(this.zza, zzfcwVar.zzd, zzfcaVar.zzv.toString(), (zzbpw) zzedpVar.zzc);
            }
        } catch (Exception e) {
            String str = zzedpVar.zza;
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Fail to load ad from adapter ".concat(String.valueOf(str)), e);
        }
    }
}
