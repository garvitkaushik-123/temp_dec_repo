package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeex implements zzeds {
    private final Context zza;
    private final zzcpx zzb;
    private View zzc;
    private zzbpz zzd;

    public zzeex(Context context, zzcpx zzcpxVar) {
        this.zza = context;
        this.zzb = zzcpxVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzeds
    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, final zzfca zzfcaVar, final zzedp zzedpVar) throws zzfdd, zzehf {
        final View view;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzij)).booleanValue() && zzfcaVar.zzag) {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzfdd(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                }
                if (zzf) {
                    try {
                        view = (View) zzgdn.zzn(zzgdn.zzh(null), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeeu
                            @Override // com.google.android.gms.internal.ads.zzgcu
                            public final ListenableFuture zza(Object obj) {
                                ListenableFuture zzh;
                                zzh = zzgdn.zzh(zzcqm.zza(zzeex.this.zza, view, zzfcaVar));
                                return zzh;
                            }
                        }, zzcaf.zzf).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzfdd(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzfdd(e2);
            }
        } else {
            view = this.zzc;
        }
        zzcot zza = this.zzb.zza(new zzcrq(zzfcnVar, zzfcaVar, zzedpVar.zza), new zzcoz(view, null, new zzcqy() { // from class: com.google.android.gms.internal.ads.zzeet
            @Override // com.google.android.gms.internal.ads.zzcqy
            public final com.google.android.gms.ads.internal.client.zzed zza() {
                try {
                    return ((zzbrp) zzedp.this.zzb).zze();
                } catch (RemoteException e3) {
                    throw new zzfdd(e3);
                }
            }
        }, (zzfcb) zzfcaVar.zzu.get(0)));
        zza.zzh().zza(view);
        ((zzefd) zzedpVar.zzc).zzc(zza.zzj());
        return zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeds
    public final void zzb(zzfcn zzfcnVar, zzfca zzfcaVar, zzedp zzedpVar) throws zzfdd {
        try {
            zzbrp zzbrpVar = (zzbrp) zzedpVar.zzb;
            zzbrpVar.zzq(zzfcaVar.zzZ);
            zzeew zzeewVar = null;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzij)).booleanValue() && zzfcaVar.zzag) {
                String str = zzfcaVar.zzU;
                String jSONObject = zzfcaVar.zzv.toString();
                zzfcw zzfcwVar = zzfcnVar.zza.zza;
                zzbrpVar.zzk(str, jSONObject, zzfcwVar.zzd, ObjectWrapper.wrap(this.zza), new zzeev(this, zzedpVar, zzeewVar), (zzbpw) zzedpVar.zzc, zzfcwVar.zze);
                return;
            }
            String str2 = zzfcaVar.zzU;
            String jSONObject2 = zzfcaVar.zzv.toString();
            zzfcw zzfcwVar2 = zzfcnVar.zza.zza;
            zzbrpVar.zzj(str2, jSONObject2, zzfcwVar2.zzd, ObjectWrapper.wrap(this.zza), new zzeev(this, zzedpVar, zzeewVar), (zzbpw) zzedpVar.zzc, zzfcwVar2.zze);
        } catch (RemoteException e) {
            throw new zzfdd(e);
        }
    }
}
