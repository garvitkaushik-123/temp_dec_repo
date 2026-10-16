package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzbup;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
final class zzau extends zzba {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzaz zzb;

    zzau(zzaz zzazVar, Context context) {
        this.zza = context;
        Objects.requireNonNull(zzazVar);
        this.zzb = zzazVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    protected final /* bridge */ /* synthetic */ Object zza() {
        zzaz.zzv(this.zza, "mobile_ads_settings");
        return new zzfo();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzb(zzcr zzcrVar) throws RemoteException {
        return zzcrVar.zzh(ObjectWrapper.wrap(this.zza), ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzfg zzfgVar;
        zzbup zzbupVar;
        Context context = this.zza;
        zzbde.zza(context);
        if (!((Boolean) zzbd.zzc().zzb(zzbde.zzle)).booleanValue()) {
            zzaz zzazVar = this.zzb;
            Context context2 = this.zza;
            zzfgVar = zzazVar.zzc;
            return zzfgVar.zza(context2);
        }
        try {
            IBinder zze = ((zzdc) com.google.android.gms.ads.internal.util.client.zzs.zzb(context, "com.google.android.gms.ads.ChimeraMobileAdsSettingManagerCreatorImpl", new com.google.android.gms.ads.internal.util.client.zzq() { // from class: com.google.android.gms.ads.internal.client.zzat
                @Override // com.google.android.gms.ads.internal.util.client.zzq
                public final Object zza(Object obj) {
                    IBinder iBinder = (IBinder) obj;
                    if (iBinder == null) {
                        return null;
                    }
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
                    return queryLocalInterface instanceof zzdc ? (zzdc) queryLocalInterface : new zzdc(iBinder);
                }
            })).zze(ObjectWrapper.wrap(context), ModuleDescriptor.MODULE_VERSION);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            return queryLocalInterface instanceof zzdb ? (zzdb) queryLocalInterface : new zzcz(zze);
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException e) {
            zzaz zzazVar2 = this.zzb;
            zzazVar2.zzg = zzbun.zza(this.zza);
            zzbupVar = zzazVar2.zzg;
            zzbupVar.zzh(e, "ClientApiBroker.getMobileAdsSettingsManager");
            return null;
        }
    }
}
