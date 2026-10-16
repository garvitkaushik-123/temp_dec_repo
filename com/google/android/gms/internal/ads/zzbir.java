package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbir implements Runnable {
    final /* synthetic */ AdManagerAdView zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzbx zzb;
    final /* synthetic */ zzbis zzc;

    zzbir(zzbis zzbisVar, AdManagerAdView adManagerAdView, com.google.android.gms.ads.internal.client.zzbx zzbxVar) {
        this.zza = adManagerAdView;
        this.zzb = zzbxVar;
        Objects.requireNonNull(zzbisVar);
        this.zzc = zzbisVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener;
        AdManagerAdView adManagerAdView = this.zza;
        if (!adManagerAdView.zzb(this.zzb)) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not bind.");
        } else {
            onAdManagerAdViewLoadedListener = this.zzc.zza;
            onAdManagerAdViewLoadedListener.onAdManagerAdViewLoaded(adManagerAdView);
        }
    }
}
