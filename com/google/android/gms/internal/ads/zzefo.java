package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzefo implements zzeds {
    private final Context zza;
    private final zzdgf zzb;
    private final VersionInfoParcel zzc;
    private final Executor zzd;

    public zzefo(Context context, VersionInfoParcel versionInfoParcel, zzdgf zzdgfVar, Executor executor) {
        this.zza = context;
        this.zzc = versionInfoParcel;
        this.zzb = zzdgfVar;
        this.zzd = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd, zzehf {
        zzdfc zzd = this.zzb.zzd(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdff(new zzefn(this, zzedpVar, zzfcaVar), null));
        zzd.zzd().zzo(new zzcmg((zzfdu) zzedpVar.zzb), this.zzd);
        ((zzefd) zzedpVar.zzc).zzc(zzd.zzk());
        return zzd.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        zzfdu zzfduVar = (zzfdu) zzedpVar.zzb;
        zzfcw zzfcwVar = zzfcnVar.zza.zza;
        String jSONObject = zzfcaVar.zzv.toString();
        String zzm = com.google.android.gms.ads.internal.util.zzbs.zzm(zzfcaVar.zzs);
        zzfduVar.zzo(this.zza, zzfcwVar.zzd, jSONObject, zzm, (zzbpw) zzedpVar.zzc);
    }
}
