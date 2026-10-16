package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.4.0 */
/* loaded from: classes5.dex */
final class zzdm extends zzeu {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzff zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzdm(zzff zzffVar, Bundle bundle) {
        super(zzffVar, true);
        this.zza = bundle;
        this.zzb = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeu
    final void zza() throws RemoteException {
        zzcv zzcvVar;
        zzcvVar = this.zzb.zzj;
        ((zzcv) Preconditions.checkNotNull(zzcvVar)).setConditionalUserProperty(this.zza, this.zzh);
    }
}
