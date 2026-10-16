package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbsg implements com.google.android.gms.ads.internal.overlay.zzr {
    final /* synthetic */ zzbsi zza;

    zzbsg(zzbsi zzbsiVar) {
        Objects.requireNonNull(zzbsiVar);
        this.zza = zzbsiVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzd() {
        com.google.android.gms.ads.internal.util.client.zzo.zze("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdk() {
        com.google.android.gms.ads.internal.util.client.zzo.zze("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzds() {
        com.google.android.gms.ads.internal.util.client.zzo.zze("Delay close AdMobCustomTabsAdapter overlay.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdt() {
        MediationInterstitialListener mediationInterstitialListener;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Opening AdMobCustomTabsAdapter overlay.");
        zzbsi zzbsiVar = this.zza;
        mediationInterstitialListener = zzbsiVar.zzb;
        mediationInterstitialListener.onAdOpened(zzbsiVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdw(int i) {
        MediationInterstitialListener mediationInterstitialListener;
        com.google.android.gms.ads.internal.util.client.zzo.zze("AdMobCustomTabsAdapter overlay is closed.");
        zzbsi zzbsiVar = this.zza;
        mediationInterstitialListener = zzbsiVar.zzb;
        mediationInterstitialListener.onAdClosed(zzbsiVar);
    }
}
