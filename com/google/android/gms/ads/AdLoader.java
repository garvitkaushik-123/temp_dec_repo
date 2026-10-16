package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzbq;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzek;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.internal.client.zzgc;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfc;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzbit;
import com.google.android.gms.internal.ads.zzbpm;
import com.google.android.gms.internal.ads.zzbtd;
import com.google.android.gms.internal.ads.zzbtf;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public class AdLoader {
    private final zzq zza;
    private final Context zzb;
    private final zzbq zzc;

    /* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
    public static class Builder {
        private final Context zza;
        private final zzbt zzb;

        public Builder(Context context, String str) {
            Context context2 = (Context) Preconditions.checkNotNull(context, "context cannot be null");
            zzbt zzd = zzbb.zza().zzd(context, str, new zzbpm());
            this.zza = context2;
            this.zzb = zzd;
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.zza, this.zzb.zze(), zzq.zza);
            } catch (RemoteException e) {
                zzo.zzh("Failed to build AdLoader.", e);
                return new AdLoader(this.zza, new zzfk().zzc(), zzq.zza);
            }
        }

        public Builder forCustomFormatAd(String str, NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
            zzbtd zzbtdVar = new zzbtd(onCustomFormatAdLoadedListener, onCustomClickListener);
            try {
                this.zzb.zzh(str, zzbtdVar.zzb(), zzbtdVar.zza());
                return this;
            } catch (RemoteException e) {
                zzo.zzk("Failed to add custom format ad listener", e);
                return this;
            }
        }

        public Builder forNativeAd(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
            try {
                this.zzb.zzk(new zzbtf(onNativeAdLoadedListener));
                return this;
            } catch (RemoteException e) {
                zzo.zzk("Failed to add google native ad listener", e);
                return this;
            }
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzb.zzl(new com.google.android.gms.ads.internal.client.zzg(adListener));
                return this;
            } catch (RemoteException e) {
                zzo.zzk("Failed to set AdListener.", e);
                return this;
            }
        }

        public Builder withAdManagerAdViewOptions(AdManagerAdViewOptions adManagerAdViewOptions) {
            try {
                this.zzb.zzm(adManagerAdViewOptions);
                return this;
            } catch (RemoteException e) {
                zzo.zzk("Failed to specify Ad Manager banner ad options", e);
                return this;
            }
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzb.zzo(new zzbge(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), -1, nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzgc(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzc(), nativeAdOptions.getMediaAspectRatio(), nativeAdOptions.zza(), nativeAdOptions.zzb(), nativeAdOptions.zzd() - 1));
                return this;
            } catch (RemoteException e) {
                zzo.zzk("Failed to specify native ad options", e);
                return this;
            }
        }

        @Deprecated
        public final Builder zza(String str, com.google.android.gms.ads.formats.zzg zzgVar, com.google.android.gms.ads.formats.zzf zzfVar) {
            zzbiq zzbiqVar = new zzbiq(zzgVar, zzfVar);
            try {
                this.zzb.zzh(str, zzbiqVar.zzd(), zzbiqVar.zzc());
                return this;
            } catch (RemoteException e) {
                zzo.zzk("Failed to add custom template ad listener", e);
                return this;
            }
        }

        @Deprecated
        public final Builder zzb(com.google.android.gms.ads.formats.zzi zziVar) {
            try {
                this.zzb.zzk(new zzbit(zziVar));
                return this;
            } catch (RemoteException e) {
                zzo.zzk("Failed to add google native ad listener", e);
                return this;
            }
        }

        @Deprecated
        public final Builder zzc(com.google.android.gms.ads.formats.NativeAdOptions nativeAdOptions) {
            try {
                this.zzb.zzo(new zzbge(nativeAdOptions));
                return this;
            } catch (RemoteException e) {
                zzo.zzk("Failed to specify native ad options", e);
                return this;
            }
        }

        public Builder forAdManagerAdView(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzb.zzj(new zzbis(onAdManagerAdViewLoadedListener), new zzr(this.zza, adSizeArr));
                return this;
            } catch (RemoteException e) {
                zzo.zzk("Failed to add Google Ad Manager banner ad listener", e);
                return this;
            }
        }
    }

    AdLoader(Context context, zzbq zzbqVar, zzq zzqVar) {
        this.zzb = context;
        this.zzc = zzbqVar;
        this.zza = zzqVar;
    }

    public static /* synthetic */ void zza(AdLoader adLoader, zzek zzekVar) {
        try {
            adLoader.zzc.zzg(adLoader.zza.zza(adLoader.zzb, zzekVar));
        } catch (RemoteException e) {
            zzo.zzh("Failed to load ad.", e);
        }
    }

    private final void zzb(final zzek zzekVar) {
        Context context = this.zzb;
        zzbde.zza(context);
        if (((Boolean) zzbfc.zzc.zze()).booleanValue()) {
            if (((Boolean) zzbd.zzc().zzb(zzbde.zzlE)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zza
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdLoader.zza(AdLoader.this, zzekVar);
                    }
                });
                return;
            }
        }
        try {
            this.zzc.zzg(this.zza.zza(context, zzekVar));
        } catch (RemoteException e) {
            zzo.zzh("Failed to load ad.", e);
        }
    }

    public boolean isLoading() {
        try {
            return this.zzc.zzi();
        } catch (RemoteException e) {
            zzo.zzk("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public void loadAd(AdRequest adRequest) {
        zzb(adRequest.zza);
    }

    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzc.zzh(this.zza.zza(this.zzb, adRequest.zza), i);
        } catch (RemoteException e) {
            zzo.zzh("Failed to load ads.", e);
        }
    }

    public void loadAd(AdManagerAdRequest adManagerAdRequest) {
        zzb(adManagerAdRequest.zza);
    }
}
