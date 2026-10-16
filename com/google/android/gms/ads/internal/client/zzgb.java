package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.VideoController;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzgb extends zzef {
    private final VideoController.VideoLifecycleCallbacks zza;

    public zzgb(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zza = videoLifecycleCallbacks;
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zze() {
        this.zza.onVideoEnd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzf(boolean z) {
        this.zza.onVideoMute(z);
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzg() {
        this.zza.onVideoPause();
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzh() {
        this.zza.onVideoPlay();
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzi() {
        this.zza.onVideoStart();
    }
}
