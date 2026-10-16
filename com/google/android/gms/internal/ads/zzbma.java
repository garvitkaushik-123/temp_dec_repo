package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbma implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzcak zza;
    final /* synthetic */ zzbmc zzb;

    zzbma(zzbmc zzbmcVar, zzcak zzcakVar) {
        this.zza = zzcakVar;
        Objects.requireNonNull(zzbmcVar);
        this.zzb = zzbmcVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzblp zzblpVar;
        try {
            zzcak zzcakVar = this.zza;
            zzblpVar = this.zzb.zza;
            zzcakVar.zzc(zzblpVar.zzp());
        } catch (DeadObjectException e) {
            this.zza.zzd(e);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.zza.zzd(new RuntimeException("onConnectionSuspended: " + i));
    }
}
