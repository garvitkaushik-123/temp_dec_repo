package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeaj {
    private final zzbvk zza;

    zzeaj(zzbvk zzbvkVar) {
        this.zza = zzbvkVar;
    }

    public final void zza() {
        ListenableFuture zza = this.zza.zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzia)).booleanValue()) {
            zzcai.zzb(zza, "persistFlags");
        } else {
            zzcai.zza(zza, "persistFlags");
        }
    }
}
