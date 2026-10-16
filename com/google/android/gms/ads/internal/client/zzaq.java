package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzbup;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
final class zzaq extends zzba {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbpq zzc;
    final /* synthetic */ zzaz zzd;

    zzaq(zzaz zzazVar, Context context, String str, zzbpq zzbpqVar) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbpqVar;
        Objects.requireNonNull(zzazVar);
        this.zzd = zzazVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    protected final /* bridge */ /* synthetic */ Object zza() {
        zzaz.zzv(this.zza, "native_ad");
        return new zzfk();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzb(zzcr zzcrVar) throws RemoteException {
        return zzcrVar.zzb(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzi zziVar;
        zzbup zzbupVar;
        Context context = this.zza;
        zzbde.zza(context);
        if (!((Boolean) zzbd.zzc().zzb(zzbde.zzle)).booleanValue()) {
            zzaz zzazVar = this.zzd;
            Context context2 = this.zza;
            String str = this.zzb;
            zzbpq zzbpqVar = this.zzc;
            zziVar = zzazVar.zzb;
            return zziVar.zza(context2, str, zzbpqVar);
        }
        try {
            IBinder zze = ((zzbu) com.google.android.gms.ads.internal.util.client.zzs.zzb(context, "com.google.android.gms.ads.ChimeraAdLoaderBuilderCreatorImpl", new com.google.android.gms.ads.internal.util.client.zzq() { // from class: com.google.android.gms.ads.internal.client.zzap
                @Override // com.google.android.gms.ads.internal.util.client.zzq
                public final Object zza(Object obj) {
                    IBinder iBinder = (IBinder) obj;
                    if (iBinder == null) {
                        return null;
                    }
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
                    return queryLocalInterface instanceof zzbu ? (zzbu) queryLocalInterface : new zzbu(iBinder);
                }
            })).zze(ObjectWrapper.wrap(context), this.zzb, this.zzc, ModuleDescriptor.MODULE_VERSION);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return queryLocalInterface instanceof zzbt ? (zzbt) queryLocalInterface : new zzbr(zze);
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException e) {
            zzaz zzazVar2 = this.zzd;
            zzazVar2.zzg = zzbun.zza(this.zza);
            zzbupVar = zzazVar2.zzg;
            zzbupVar.zzh(e, "ClientApiBroker.createAdLoaderBuilder");
            return null;
        }
    }
}
