package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.preload.PreloadCallback;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
final class zzet extends zzcd {
    final /* synthetic */ PreloadCallback zza;

    zzet(zzey zzeyVar, PreloadCallback preloadCallback) {
        this.zza = preloadCallback;
        Objects.requireNonNull(zzeyVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final void zze(zzfv zzfvVar) {
        PreloadConfiguration zzh = com.google.android.gms.ads.internal.util.client.zzf.zzh(zzfvVar);
        if (zzh != null) {
            this.zza.onAdsAvailable(zzh);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final void zzf(zzfv zzfvVar) {
        PreloadConfiguration zzh = com.google.android.gms.ads.internal.util.client.zzf.zzh(zzfvVar);
        if (zzh != null) {
            this.zza.onAdsExhausted(zzh);
        }
    }
}
