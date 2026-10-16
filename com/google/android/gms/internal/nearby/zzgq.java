package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzgq extends zzgp {
    final /* synthetic */ zzli zza;
    final /* synthetic */ Payload zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgq(zzgu zzguVar, zzli zzliVar, Payload payload) {
        super(null);
        this.zza = zzliVar;
        this.zzb = payload;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((PayloadCallback) obj).onPayloadReceived(this.zza.zzb(), this.zzb);
    }
}
