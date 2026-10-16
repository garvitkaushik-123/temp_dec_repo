package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.nearby.exposurenotification.PackageConfiguration;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzan extends zzdt {
    final /* synthetic */ TaskCompletionSource zza;

    zzan(zzax zzaxVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zzb(Status status, PackageConfiguration packageConfiguration) {
        TaskUtil.trySetResultOrApiException(status, packageConfiguration, this.zza);
    }
}
