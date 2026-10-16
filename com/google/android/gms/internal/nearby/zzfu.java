package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzfu extends zzgp {
    final /* synthetic */ zzkq zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfu(zzfx zzfxVar, zzkq zzkqVar) {
        super(null);
        this.zza = zzkqVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        String zzc = this.zza.zzc();
        com.google.android.gms.nearby.connection.zze zzeVar = new com.google.android.gms.nearby.connection.zze();
        zzeVar.zzb(this.zza.zzb());
        zzeVar.zza(this.zza.zza());
        ((ConnectionLifecycleCallback) obj).onBandwidthChanged(zzc, zzeVar.zzc());
    }
}
