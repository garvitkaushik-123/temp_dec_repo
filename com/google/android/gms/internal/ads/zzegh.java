package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzegh implements zzeds {
    private final Context zza;
    private final zzdhb zzb;
    private zzbqf zzc;
    private final VersionInfoParcel zzd;

    public zzegh(Context context, zzdhb zzdhbVar, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzdhbVar;
        this.zzd = versionInfoParcel;
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd, zzehf {
        ArrayList arrayList = zzfcnVar.zza.zza.zzg;
        if (!arrayList.contains(Integer.toString(6))) {
            throw new zzehf(2, "Unified must be used for RTB.");
        }
        zzdit zzt = zzdit.zzt(this.zzc);
        if (!arrayList.contains(Integer.toString(zzt.zzc()))) {
            throw new zzehf(1, "No corresponding native ad listener");
        }
        zzdiv zze = this.zzb.zze(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzdjf(zzt), new zzdky(null, null, this.zzc));
        ((zzefd) zzedpVar.zzc).zzc(zze.zzj());
        return zze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        try {
            zzbrp zzbrpVar = (zzbrp) zzedpVar.zzb;
            zzbrpVar.zzq(zzfcaVar.zzZ);
            zzegg zzeggVar = null;
            if (this.zzd.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbT)).intValue()) {
                zzbrpVar.zzm(zzfcaVar.zzU, zzfcaVar.zzv.toString(), zzfcnVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzegf(this, zzedpVar, zzeggVar), (zzbpw) zzedpVar.zzc);
                return;
            }
            String str = zzfcaVar.zzU;
            String jSONObject = zzfcaVar.zzv.toString();
            zzfcw zzfcwVar = zzfcnVar.zza.zza;
            zzbrpVar.zzn(str, jSONObject, zzfcwVar.zzd, ObjectWrapper.wrap(this.zza), new zzegf(this, zzedpVar, zzeggVar), (zzbpw) zzedpVar.zzc, zzfcwVar.zzi);
        } catch (RemoteException e) {
            throw new zzfdd(e);
        }
    }
}
