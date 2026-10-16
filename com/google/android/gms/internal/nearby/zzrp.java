package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.RangingSessionCallback;
import com.google.android.gms.nearby.uwb.UwbDevice;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzrp extends zznp {
    final /* synthetic */ zzpo zza;
    final /* synthetic */ zzrr zzb;

    zzrp(zzrr zzrrVar, zzpo zzpoVar) {
        this.zzb = zzrrVar;
        this.zza = zzpoVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        UwbDevice createForAddress;
        zzrr zzrrVar = this.zzb;
        createForAddress = UwbDevice.createForAddress(this.zza.zzb().zza().zzb());
        ((RangingSessionCallback) obj).onRangingResult(createForAddress, zzrr.zzb(this.zzb, this.zza.zza()));
    }
}
