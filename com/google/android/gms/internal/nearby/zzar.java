package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzar extends zzdx {
    final /* synthetic */ TaskCompletionSource zza;

    zzar(zzax zzaxVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzdy
    public final void zzb(Status status, List list) {
        TaskUtil.trySetResultOrApiException(status, list, this.zza);
    }
}
