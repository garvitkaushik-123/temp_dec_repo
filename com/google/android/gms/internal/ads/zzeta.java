package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeta implements zzeub {
    private final String zza;
    private final int zzb;

    public zzeta(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        ((zzcva) obj).zzb.putString("request_id", this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        bundle.putString("request_id", this.zza);
        if (this.zzb == 2) {
            bundle.putInt("sod", 1);
        }
    }
}
