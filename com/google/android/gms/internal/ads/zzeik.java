package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeik implements zzeds {
    private final Context zza;
    private final Executor zzb;
    private final zzdos zzc;

    public zzeik(Context context, Executor executor, zzdos zzdosVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdosVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zze(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) {
        try {
            ((zzfdu) zzedpVar.zzb).zzk(zzfcnVar.zza.zza.zzd, zzfcaVar.zzv.toString());
        } catch (Exception e) {
            String str = zzedpVar.zza;
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Fail to load ad from adapter ".concat(String.valueOf(str)), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd, zzehf {
        zzdoo zzd = this.zzc.zzd(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdop(new zzeii(this, zzedpVar, zzfcaVar)));
        zzd.zzd().zzo(new zzcmg((zzfdu) zzedpVar.zzb), this.zzb);
        zzcxf zze = zzd.zze();
        zzcvw zzb = zzd.zzb();
        ((zzefe) zzedpVar.zzc).zzc(new zzeij(this, zzd.zza(), zzb, zze, zzd.zzg()));
        return zzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        zzfdu zzfduVar = (zzfdu) zzedpVar.zzb;
        if (zzfduVar.zzC()) {
            zze(zzfcnVar, zzfcaVar, zzedpVar);
            return;
        }
        zzeih zzeihVar = new zzeih(this, zzfcnVar, zzfcaVar, zzedpVar);
        zzcxi zzcxiVar = zzedpVar.zzc;
        ((zzefe) zzcxiVar).zzd(zzeihVar);
        Context context = this.zza;
        zzfcw zzfcwVar = zzfcnVar.zza.zza;
        String jSONObject = zzfcaVar.zzv.toString();
        zzfduVar.zzh(context, zzfcwVar.zzd, null, (zzbwn) zzcxiVar, jSONObject);
    }
}
