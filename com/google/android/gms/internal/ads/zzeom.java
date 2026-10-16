package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.ironsource.C3040d4;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeom implements zzeub {
    private final double zza;
    private final boolean zzb;

    public zzeom(double d, boolean z) {
        this.zza = d;
        this.zzb = z;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        Bundle zza = zzfdk.zza(bundle, C3040d4.h.G);
        bundle.putBundle(C3040d4.h.G, zza);
        Bundle zza2 = zzfdk.zza(zza, BidTokenRepositoryKt.BATTERY);
        zza.putBundle(BidTokenRepositoryKt.BATTERY, zza2);
        zza2.putBoolean("is_charging", this.zzb);
        zza2.putDouble("battery_level", this.zza);
    }
}
