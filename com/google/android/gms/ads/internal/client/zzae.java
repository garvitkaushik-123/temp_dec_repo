package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbun;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
final class zzae extends zzba {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbpq zzb;

    zzae(zzaz zzazVar, Context context, zzbpq zzbpqVar) {
        this.zza = context;
        this.zzb = zzbpqVar;
        Objects.requireNonNull(zzazVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    protected final /* bridge */ /* synthetic */ Object zza() {
        zzaz.zzv(this.zza, "out_of_context_tester");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzb(zzcr zzcrVar) throws RemoteException {
        Context context = this.zza;
        IObjectWrapper wrap = ObjectWrapper.wrap(context);
        zzbde.zza(context);
        if (((Boolean) zzbd.zzc().zzb(zzbde.zzjO)).booleanValue()) {
            return zzcrVar.zzi(wrap, this.zzb, ModuleDescriptor.MODULE_VERSION);
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        Context context = this.zza;
        IObjectWrapper wrap = ObjectWrapper.wrap(context);
        zzbde.zza(context);
        if (((Boolean) zzbd.zzc().zzb(zzbde.zzjO)).booleanValue()) {
            try {
                return ((zzdx) com.google.android.gms.ads.internal.util.client.zzs.zzb(context, "com.google.android.gms.ads.DynamiteOutOfContextTesterCreatorImpl", new com.google.android.gms.ads.internal.util.client.zzq() { // from class: com.google.android.gms.ads.internal.client.zzad
                    @Override // com.google.android.gms.ads.internal.util.client.zzq
                    public final Object zza(Object obj) {
                        IBinder iBinder = (IBinder) obj;
                        if (iBinder == null) {
                            return null;
                        }
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTesterCreator");
                        return queryLocalInterface instanceof zzdx ? (zzdx) queryLocalInterface : new zzdx(iBinder);
                    }
                })).zze(wrap, this.zzb, ModuleDescriptor.MODULE_VERSION);
            } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException e) {
                zzbun.zza(this.zza).zzh(e, "ClientApiBroker.getOutOfContextTester");
            }
        }
        return null;
    }
}
