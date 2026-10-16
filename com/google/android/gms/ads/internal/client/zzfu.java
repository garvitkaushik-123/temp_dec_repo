package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzfu extends zzds {
    private final OnPaidEventListener zza;

    public zzfu(OnPaidEventListener onPaidEventListener) {
        this.zza = onPaidEventListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdt
    public final void zze(zzt zztVar) {
        OnPaidEventListener onPaidEventListener = this.zza;
        if (onPaidEventListener != null) {
            onPaidEventListener.onPaidEvent(AdValue.zza(zztVar.zzb, zztVar.zzc, zztVar.zzd));
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdt
    public final boolean zzf() {
        return this.zza == null;
    }
}
