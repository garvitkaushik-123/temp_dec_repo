package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.4.0 */
/* loaded from: classes5.dex */
final class zzek extends zzeu {
    final /* synthetic */ zzcs zza;
    final /* synthetic */ zzff zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzek(zzff zzffVar, zzcs zzcsVar) {
        super(zzffVar, true);
        this.zza = zzcsVar;
        this.zzb = zzffVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeu
    final void zza() throws RemoteException {
        zzcv zzcvVar;
        zzcvVar = this.zzb.zzj;
        ((zzcv) Preconditions.checkNotNull(zzcvVar)).getAppInstanceId(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzeu
    protected final void zzb() {
        this.zza.zze(null);
    }
}
