package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbbj implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbbk zza;

    zzbbj(zzbbk zzbbkVar) {
        Objects.requireNonNull(zzbbkVar);
        this.zza = zzbbkVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Object obj;
        zzbbn zzbbnVar;
        Object obj2;
        zzbbk zzbbkVar = this.zza;
        obj = zzbbkVar.zzc;
        synchronized (obj) {
            zzbbkVar.zzf = null;
            zzbbnVar = zzbbkVar.zzd;
            if (zzbbnVar != null) {
                zzbbkVar.zzd = null;
            }
            obj2 = zzbbkVar.zzc;
            obj2.notifyAll();
        }
    }
}
