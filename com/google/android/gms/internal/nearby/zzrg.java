package com.google.android.gms.internal.nearby;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzrg extends zzoq {
    final /* synthetic */ TaskCompletionSource zza;

    zzrg(zzrs zzrsVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzor
    public final void zzd(boolean z) {
        this.zza.setResult(Boolean.valueOf(z));
    }
}
