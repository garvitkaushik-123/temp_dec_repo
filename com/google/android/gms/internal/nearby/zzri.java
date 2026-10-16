package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.UwbAddress;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzri extends zzpd {
    final /* synthetic */ TaskCompletionSource zza;

    zzri(zzrs zzrsVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzpe
    public final void zzd(zzqq zzqqVar) {
        this.zza.setResult(new UwbAddress(zzqqVar.zzb()));
    }
}
