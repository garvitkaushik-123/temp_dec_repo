package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfbw implements OnAdMetadataChangedListener {
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzcb zza;
    final /* synthetic */ zzfbx zzb;

    zzfbw(zzfbx zzfbxVar, com.google.android.gms.ads.internal.client.zzcb zzcbVar) {
        this.zza = zzcbVar;
        Objects.requireNonNull(zzfbxVar);
        this.zzb = zzfbxVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        zzdon zzdonVar;
        zzdonVar = this.zzb.zzd;
        if (zzdonVar != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
