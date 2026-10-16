package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzblb;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzblk;
import com.google.android.gms.internal.ads.zzblo;
import com.google.android.gms.internal.ads.zzbpq;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
final class zzak extends zzba {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbpq zzb;
    final /* synthetic */ OnH5AdsEventListener zzc;

    zzak(zzaz zzazVar, Context context, zzbpq zzbpqVar, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = context;
        this.zzb = zzbpqVar;
        this.zzc = onH5AdsEventListener;
        Objects.requireNonNull(zzazVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    protected final /* synthetic */ Object zza() {
        return new zzblo();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzb(zzcr zzcrVar) throws RemoteException {
        return zzcrVar.zzl(ObjectWrapper.wrap(this.zza), this.zzb, ModuleDescriptor.MODULE_VERSION, new zzblb(this.zzc));
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        Context context = this.zza;
        try {
            return ((zzblk) com.google.android.gms.ads.internal.util.client.zzs.zzb(context, "com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl", new com.google.android.gms.ads.internal.util.client.zzq() { // from class: com.google.android.gms.ads.internal.client.zzaj
                @Override // com.google.android.gms.ads.internal.util.client.zzq
                public final Object zza(Object obj) {
                    return zzblj.zzb((IBinder) obj);
                }
            })).zze(ObjectWrapper.wrap(context), this.zzb, ModuleDescriptor.MODULE_VERSION, new zzblb(this.zzc));
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException unused) {
            return null;
        }
    }
}
