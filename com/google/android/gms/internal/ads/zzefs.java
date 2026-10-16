package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzefs implements zzeds {
    private final Context zza;
    private final zzdgf zzb;

    public zzefs(Context context, zzdgf zzdgfVar) {
        this.zza = context;
        this.zzb = zzdgfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd, zzehf {
        zzefm zzefmVar = new zzefm(zzfcaVar, (zzbrp) zzedpVar.zzb, AdFormat.INTERSTITIAL);
        zzdfc zzd = this.zzb.zzd(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdff(zzefmVar, null));
        zzefmVar.zzc(zzd.zzc());
        ((zzefd) zzedpVar.zzc).zzc(zzd.zzj());
        return zzd.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        try {
            zzbrp zzbrpVar = (zzbrp) zzedpVar.zzb;
            zzbrpVar.zzq(zzfcaVar.zzZ);
            zzbrpVar.zzl(zzfcaVar.zzU, zzfcaVar.zzv.toString(), zzfcnVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzefq(this, zzedpVar, null), (zzbpw) zzedpVar.zzc);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading a interstitial RTB ad", e);
            throw new zzfdd(e);
        }
    }
}
