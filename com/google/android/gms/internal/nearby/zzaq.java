package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzaq extends zzcn {
    final /* synthetic */ TaskCompletionSource zza;

    zzaq(zzax zzaxVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzco
    public final void zzb(Status status, boolean z) {
        TaskUtil.trySetResultOrApiException(status, Boolean.valueOf(z), this.zza);
    }
}
