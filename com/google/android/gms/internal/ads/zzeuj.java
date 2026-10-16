package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeuj implements zzeub {
    private final int zza;
    private final int zzb;

    zzeuj(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        int i;
        Bundle bundle = ((zzcva) obj).zza;
        int i2 = this.zza;
        if (i2 == -1 || (i = this.zzb) == -1) {
            return;
        }
        bundle.putInt("sessions_without_flags", i2);
        bundle.putInt("crashes_without_flags", i);
        int i3 = com.google.android.gms.ads.internal.client.zzbb.zza;
        if (com.google.android.gms.ads.internal.client.zzbd.zzc().zze()) {
            bundle.putBoolean("did_reset", true);
        }
    }
}
