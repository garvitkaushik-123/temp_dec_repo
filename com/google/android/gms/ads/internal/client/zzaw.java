package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbgs;
import com.google.android.gms.internal.ads.zzbgv;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbil;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzbup;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
final class zzaw extends zzba {
    final /* synthetic */ FrameLayout zza;
    final /* synthetic */ FrameLayout zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ zzaz zzd;

    zzaw(zzaz zzazVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zza = frameLayout;
        this.zzb = frameLayout2;
        this.zzc = context;
        Objects.requireNonNull(zzazVar);
        this.zzd = zzazVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    protected final /* bridge */ /* synthetic */ Object zza() {
        zzaz.zzv(this.zzc, "native_ad_view_delegate");
        return new zzfp();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzb(zzcr zzcrVar) throws RemoteException {
        return zzcrVar.zzj(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb));
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbup zzbupVar;
        zzbil zzbilVar;
        Context context = this.zzc;
        zzbde.zza(context);
        if (!((Boolean) zzbd.zzc().zzb(zzbde.zzle)).booleanValue()) {
            zzaz zzazVar = this.zzd;
            Context context2 = this.zzc;
            FrameLayout frameLayout = this.zza;
            FrameLayout frameLayout2 = this.zzb;
            zzbilVar = zzazVar.zzd;
            return zzbilVar.zza(context2, frameLayout, frameLayout2);
        }
        try {
            return zzbgs.zzdC(((zzbgw) com.google.android.gms.ads.internal.util.client.zzs.zzb(context, "com.google.android.gms.ads.ChimeraNativeAdViewDelegateCreatorImpl", new com.google.android.gms.ads.internal.util.client.zzq() { // from class: com.google.android.gms.ads.internal.client.zzav
                @Override // com.google.android.gms.ads.internal.util.client.zzq
                public final Object zza(Object obj) {
                    return zzbgv.zzb((IBinder) obj);
                }
            })).zze(ObjectWrapper.wrap(context), ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb), ModuleDescriptor.MODULE_VERSION));
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException e) {
            zzaz zzazVar2 = this.zzd;
            zzazVar2.zzg = zzbun.zza(this.zzc);
            zzbupVar = zzazVar2.zzg;
            zzbupVar.zzh(e, "ClientApiBroker.createNativeAdViewDelegate");
            return null;
        }
    }
}
