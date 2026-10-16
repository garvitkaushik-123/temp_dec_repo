package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Connections;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzgw implements Connections.StartAdvertisingResult {
    private final Status zza;
    private final String zzb;

    zzgw(Status status, String str) {
        this.zza = status;
        this.zzb = str;
    }

    @Override // com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult
    public final String getLocalEndpointName() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}
