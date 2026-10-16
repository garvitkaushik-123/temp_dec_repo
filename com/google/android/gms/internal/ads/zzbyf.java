package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbyf {
    private final Clock zza;
    private final zzbyd zzb;

    zzbyf(Clock clock, zzbyd zzbydVar) {
        this.zza = clock;
        this.zzb = zzbydVar;
    }

    public static zzbyf zza(Context context) {
        return zzbyp.zzb(context).zza();
    }

    public final void zzb(int i, long j) {
        this.zzb.zza(i, j);
    }

    public final void zzc(com.google.android.gms.ads.internal.client.zzfx zzfxVar) {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzd() {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }
}
