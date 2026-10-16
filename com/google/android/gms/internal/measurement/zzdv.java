package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.4.0 */
/* loaded from: classes5.dex */
final class zzdv extends zzeu {
    final /* synthetic */ long zza;
    final /* synthetic */ zzff zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzdv(zzff zzffVar, long j) {
        super(zzffVar, true);
        this.zza = j;
        this.zzb = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeu
    final void zza() throws RemoteException {
        zzcv zzcvVar;
        zzcvVar = this.zzb.zzj;
        ((zzcv) Preconditions.checkNotNull(zzcvVar)).setSessionTimeoutDuration(this.zza);
    }
}
