package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdzx implements zzgdj {
    final /* synthetic */ zzbvq zza;
    final /* synthetic */ zzbvi zzb;

    zzdzx(zzeab zzeabVar, zzbvq zzbvqVar, zzbvi zzbviVar) {
        this.zza = zzbvqVar;
        this.zzb = zzbviVar;
        Objects.requireNonNull(zzeabVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        try {
            this.zzb.zze(com.google.android.gms.ads.internal.util.zzbb.zzb(th));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Service can't call client", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle;
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
        try {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcq)).booleanValue()) {
                this.zzb.zzf(parcelFileDescriptor);
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcr)).booleanValue() && (bundle = this.zza.zzm) != null) {
                bundle.putLong(zzdrr.BINDER_CALL_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
            }
            this.zzb.zzg(parcelFileDescriptor, this.zza);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Service can't call client", e);
        }
    }
}
