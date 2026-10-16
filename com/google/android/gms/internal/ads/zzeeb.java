package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeeb implements zzeds {
    private final Context zza;
    private final zzcog zzb;
    private final Executor zzc;

    zzeeb(Context context, zzcog zzcogVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcogVar;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd, zzehf {
        zzcod zza = this.zzb.zza(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdff(new zzeea(this, zzedpVar, zzfcaVar), null), new zzcoe(zzfcaVar.zzaa));
        zza.zzd().zzo(new zzcmg((zzfdu) zzedpVar.zzb), this.zzc);
        ((zzefd) zzedpVar.zzc).zzc(zza.zzk());
        return zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        zzfdu zzfduVar = (zzfdu) zzedpVar.zzb;
        zzfcw zzfcwVar = zzfcnVar.zza.zza;
        String jSONObject = zzfcaVar.zzv.toString();
        zzfduVar.zzl(this.zza, zzfcwVar.zzd, jSONObject, (zzbpw) zzedpVar.zzc);
    }
}
