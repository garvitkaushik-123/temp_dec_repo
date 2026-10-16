package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.RangingSessionCallback;
import com.google.android.gms.nearby.uwb.UwbDevice;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzrq extends zznp {
    final /* synthetic */ zzpq zza;
    final /* synthetic */ zzrr zzb;

    zzrq(zzrr zzrrVar, zzpq zzpqVar) {
        this.zzb = zzrrVar;
        this.zza = zzpqVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        UwbDevice createForAddress;
        zzrr zzrrVar = this.zzb;
        createForAddress = UwbDevice.createForAddress(this.zza.zzb().zza().zzb());
        ((RangingSessionCallback) obj).onRangingSuspended(createForAddress, this.zza.zza());
    }

    @Override // com.google.android.gms.internal.nearby.zznp, com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
        RangingSessionCallback rangingSessionCallback;
        UwbDevice createForAddress;
        rangingSessionCallback = this.zzb.zzc;
        createForAddress = UwbDevice.createForAddress(this.zza.zzb().zza().zzb());
        rangingSessionCallback.onRangingSuspended(createForAddress, this.zza.zza());
    }
}
