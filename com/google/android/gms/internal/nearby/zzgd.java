package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzgd extends zzgp {
    final /* synthetic */ zzle zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgd(zzgg zzggVar, zzle zzleVar) {
        super(null);
        this.zza = zzleVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        boolean zzg;
        EndpointDiscoveryCallback endpointDiscoveryCallback = (EndpointDiscoveryCallback) obj;
        zzg = zzgg.zzg(this.zza);
        if (zzg) {
            com.google.android.gms.nearby.connection.zzn zznVar = new com.google.android.gms.nearby.connection.zzn();
            zznVar.zzd(this.zza.zzd());
            zznVar.zza(this.zza.zza());
            endpointDiscoveryCallback.onEndpointFound("__UNRECOGNIZED_BLUETOOTH_DEVICE__", zznVar.zze());
            return;
        }
        String zzb = this.zza.zzb();
        com.google.android.gms.nearby.connection.zzn zznVar2 = new com.google.android.gms.nearby.connection.zzn();
        zznVar2.zzd(this.zza.zzd());
        zznVar2.zzc(this.zza.zzc());
        zznVar2.zzb(this.zza.zze());
        endpointDiscoveryCallback.onEndpointFound(zzb, zznVar2.zze());
    }
}
