package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.4.0 */
/* loaded from: classes5.dex */
final class zzdz extends zzeu {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ zzff zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzdz(zzff zzffVar, Runnable runnable) {
        super(zzffVar, true);
        this.zza = runnable;
        this.zzb = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeu
    final void zza() throws RemoteException {
        zzcv zzcvVar;
        zzcvVar = this.zzb.zzj;
        ((zzcv) Preconditions.checkNotNull(zzcvVar)).retrieveAndUploadBatches(new zzdy(this, this.zza));
    }
}
