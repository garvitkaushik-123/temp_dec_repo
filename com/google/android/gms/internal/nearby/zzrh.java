package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.RangingCapabilities;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzrh extends zzou {
    final /* synthetic */ TaskCompletionSource zza;

    zzrh(zzrs zzrsVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzov
    public final void zzd(zzps zzpsVar) {
        this.zza.setResult(new RangingCapabilities(zzpsVar.zzd(), zzpsVar.zzc(), zzpsVar.zze(), zzpsVar.zzb(), zztm.zzb(zzpsVar.zzf()), zzsq.zzo(1, 2, 3), zzpsVar.zza()));
    }
}
