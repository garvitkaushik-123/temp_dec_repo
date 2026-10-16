package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Connections;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzga extends zzgp {
    final /* synthetic */ zzkw zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzga(zzgb zzgbVar, zzkw zzkwVar) {
        super(null);
        this.zza = zzkwVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        Status zzG;
        Connections.ConnectionResponseCallback connectionResponseCallback = (Connections.ConnectionResponseCallback) obj;
        byte[] zzc = this.zza.zzc();
        if (zzc != null) {
            String zzb = this.zza.zzb();
            zzG = zzgy.zzG(this.zza.zza());
            connectionResponseCallback.onConnectionResponse(zzb, zzG, zzc);
        }
    }
}
