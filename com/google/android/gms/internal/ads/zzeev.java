package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzeev extends zzbrc {
    final /* synthetic */ zzeex zza;
    private final zzedp zzb;

    /* synthetic */ zzeev(zzeex zzeexVar, zzedp zzedpVar, zzeew zzeewVar) {
        Objects.requireNonNull(zzeexVar);
        this.zza = zzeexVar;
        this.zzb = zzedpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final void zze(String str) throws RemoteException {
        ((zzefd) this.zzb.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzefd) this.zzb.zzc).zzh(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zza.zzc = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzefd) this.zzb.zzc).zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final void zzh(zzbpz zzbpzVar) throws RemoteException {
        this.zza.zzd = zzbpzVar;
        ((zzefd) this.zzb.zzc).zzo();
    }
}
