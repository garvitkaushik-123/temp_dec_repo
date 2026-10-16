package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.Nearby;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
abstract class zzbu extends BaseImplementation.ApiMethodImpl {
    private final ListenerHolder zza;

    public zzbu(GoogleApiClient googleApiClient) {
        super(Nearby.MESSAGES_API, googleApiClient);
        this.zza = googleApiClient.registerListener(this);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((zzbu) obj);
    }

    final ListenerHolder zza() {
        return this.zza;
    }
}
