package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeef implements zzeds {
    private final Context zza;
    private final zzcog zzb;

    zzeef(Context context, zzcog zzcogVar) {
        this.zza = context;
        this.zzb = zzcogVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd, zzehf {
        zzefm zzefmVar = new zzefm(zzfcaVar, (zzbrp) zzedpVar.zzb, AdFormat.APP_OPEN_AD);
        zzcod zza = this.zzb.zza(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdff(zzefmVar, null), new zzcoe(zzfcaVar.zzaa));
        zzefmVar.zzc(zza.zzc());
        ((zzefd) zzedpVar.zzc).zzc(zza.zzj());
        return zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        try {
            zzbrp zzbrpVar = (zzbrp) zzedpVar.zzb;
            zzbrpVar.zzq(zzfcaVar.zzZ);
            zzbrpVar.zzi(zzfcaVar.zzU, zzfcaVar.zzv.toString(), zzfcnVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeed(zzedpVar, null), (zzbpw) zzedpVar.zzc);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading an app open RTB ad", e);
            throw new zzfdd(e);
        }
    }
}
