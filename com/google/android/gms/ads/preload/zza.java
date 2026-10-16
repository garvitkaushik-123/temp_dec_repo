package com.google.android.gms.ads.preload;

import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzcg;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzea;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
final class zza extends zzcg {
    final /* synthetic */ PreloadCallbackV2 zza;

    zza(zzb zzbVar, PreloadCallbackV2 preloadCallbackV2) {
        this.zza = preloadCallbackV2;
        Objects.requireNonNull(zzbVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final void zze(String str, zze zzeVar) {
        this.zza.onAdFailedToPreload(str, zzeVar.zzb());
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final void zzf(String str, zzea zzeaVar) {
        this.zza.onAdPreloaded(str, ResponseInfo.zza(zzeaVar));
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final void zzg(String str) {
        this.zza.onAdsExhausted(str);
    }
}
