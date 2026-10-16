package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzehs implements zzeds {
    private final Context zza;
    private final zzdos zzb;

    public zzehs(Context context, zzdos zzdosVar) {
        this.zza = context;
        this.zzb = zzdosVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd, zzehf {
        zzefm zzefmVar = new zzefm(zzfcaVar, (zzbrp) zzedpVar.zzb, AdFormat.REWARDED);
        zzdoo zzd = this.zzb.zzd(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdop(zzefmVar));
        zzefmVar.zzc(zzd.zzc());
        ((zzefd) zzedpVar.zzc).zzc(zzd.zzo());
        return zzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        try {
            zzbrp zzbrpVar = (zzbrp) zzedpVar.zzb;
            zzbrpVar.zzq(zzfcaVar.zzZ);
            zzfcw zzfcwVar = zzfcnVar.zza.zza;
            if (zzfcwVar.zzo.zza == 3) {
                zzbrpVar.zzo(zzfcaVar.zzU, zzfcaVar.zzv.toString(), zzfcwVar.zzd, ObjectWrapper.wrap(this.zza), new zzehq(this, zzedpVar, null), (zzbpw) zzedpVar.zzc);
            } else {
                zzbrpVar.zzp(zzfcaVar.zzU, zzfcaVar.zzv.toString(), zzfcwVar.zzd, ObjectWrapper.wrap(this.zza), new zzehq(this, zzedpVar, null), (zzbpw) zzedpVar.zzc);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading a rewarded RTB ad", e);
        }
    }
}
