package com.google.android.gms.ads.admanager;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzbx;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfc;
import com.google.android.gms.internal.ads.zzbun;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class AdManagerAdView extends BaseAdView {
    public AdManagerAdView(Context context) {
        super(context, 0);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public static /* synthetic */ void zza(AdManagerAdView adManagerAdView, AdManagerAdRequest adManagerAdRequest) {
        try {
            adManagerAdView.zza.zzn(adManagerAdRequest.zza());
        } catch (IllegalStateException e) {
            zzbun.zza(adManagerAdView.getContext()).zzh(e, "AdManagerAdView.loadAd");
        }
    }

    public AdSize[] getAdSizes() {
        return this.zza.zzE();
    }

    public AppEventListener getAppEventListener() {
        return this.zza.zzi();
    }

    public VideoController getVideoController() {
        return this.zza.zzg();
    }

    public VideoOptions getVideoOptions() {
        return this.zza.zzh();
    }

    public void loadAd(final AdManagerAdRequest adManagerAdRequest) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbde.zza(getContext());
        if (((Boolean) zzbfc.zzf.zze()).booleanValue()) {
            if (((Boolean) zzbd.zzc().zzb(zzbde.zzlE)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.admanager.zzb
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdManagerAdView.zza(AdManagerAdView.this, adManagerAdRequest);
                    }
                });
                return;
            }
        }
        this.zza.zzn(adManagerAdRequest.zza());
    }

    public void recordManualImpression() {
        this.zza.zzp();
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zza.zzu(adSizeArr);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.zza.zzw(appEventListener);
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.zza.zzx(z);
    }

    public void setVideoOptions(VideoOptions videoOptions) {
        this.zza.zzA(videoOptions);
    }

    public final boolean zzb(zzbx zzbxVar) {
        return this.zza.zzB(zzbxVar);
    }

    public AdManagerAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, true);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public AdManagerAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0, true);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }
}
