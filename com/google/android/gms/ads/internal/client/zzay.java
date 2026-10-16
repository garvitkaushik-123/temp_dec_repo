package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbgy;
import com.google.android.gms.internal.ads.zzbhb;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbim;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzbup;
import java.util.HashMap;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
final class zzay extends zzba {
    final /* synthetic */ View zza;
    final /* synthetic */ HashMap zzb;
    final /* synthetic */ HashMap zzc;
    final /* synthetic */ zzaz zzd;

    zzay(zzaz zzazVar, View view, HashMap hashMap, HashMap hashMap2) {
        this.zza = view;
        this.zzb = hashMap;
        this.zzc = hashMap2;
        Objects.requireNonNull(zzazVar);
        this.zzd = zzazVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    protected final /* bridge */ /* synthetic */ Object zza() {
        zzaz.zzv(this.zza.getContext(), "native_ad_view_holder_delegate");
        return new zzfq();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzb(zzcr zzcrVar) throws RemoteException {
        HashMap hashMap = this.zzc;
        return zzcrVar.zzk(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb), ObjectWrapper.wrap(hashMap));
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbup zzbupVar;
        zzbim zzbimVar;
        View view = this.zza;
        zzbde.zza(view.getContext());
        if (!((Boolean) zzbd.zzc().zzb(zzbde.zzle)).booleanValue()) {
            zzaz zzazVar = this.zzd;
            View view2 = this.zza;
            HashMap hashMap = this.zzb;
            HashMap hashMap2 = this.zzc;
            zzbimVar = zzazVar.zzf;
            return zzbimVar.zza(view2, hashMap, hashMap2);
        }
        try {
            return zzbgy.zze(((zzbhc) com.google.android.gms.ads.internal.util.client.zzs.zzb(view.getContext(), "com.google.android.gms.ads.ChimeraNativeAdViewHolderDelegateCreatorImpl", new com.google.android.gms.ads.internal.util.client.zzq() { // from class: com.google.android.gms.ads.internal.client.zzax
                @Override // com.google.android.gms.ads.internal.util.client.zzq
                public final Object zza(Object obj) {
                    return zzbhb.zzb((IBinder) obj);
                }
            })).zze(ObjectWrapper.wrap(view), ObjectWrapper.wrap(this.zzb), ObjectWrapper.wrap(this.zzc)));
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException e) {
            zzaz zzazVar2 = this.zzd;
            zzazVar2.zzg = zzbun.zza(this.zza.getContext());
            zzbupVar = zzazVar2.zzg;
            zzbupVar.zzh(e, "ClientApiBroker.createNativeAdViewHolderDelegate");
            return null;
        }
    }
}
