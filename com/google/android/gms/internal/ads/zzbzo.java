package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbzo extends com.google.android.gms.ads.internal.util.zzb {
    final /* synthetic */ zzbzs zza;

    zzbzo(zzbzs zzbzsVar) {
        Objects.requireNonNull(zzbzsVar);
        this.zza = zzbzsVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        Context context;
        VersionInfoParcel versionInfoParcel;
        Object obj;
        zzbdj zzbdjVar;
        zzbzs zzbzsVar = this.zza;
        context = zzbzsVar.zze;
        versionInfoParcel = zzbzsVar.zzf;
        zzbdh zzbdhVar = new zzbdh(context, versionInfoParcel.afmaVersion);
        obj = zzbzsVar.zza;
        synchronized (obj) {
            try {
                com.google.android.gms.ads.internal.zzv.zze();
                zzbdjVar = zzbzsVar.zzh;
                zzbdk.zza(zzbdjVar, zzbdhVar);
            } catch (IllegalArgumentException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Cannot config CSI reporter.", e);
            }
        }
    }
}
