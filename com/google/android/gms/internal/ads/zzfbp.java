package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfbp implements OnAdMetadataChangedListener {
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzdq zza;
    final /* synthetic */ zzfbr zzb;

    zzfbp(zzfbr zzfbrVar, com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        this.zza = zzdqVar;
        Objects.requireNonNull(zzfbrVar);
        this.zzb = zzfbrVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        zzdon zzdonVar;
        zzdonVar = this.zzb.zzi;
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
