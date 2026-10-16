package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.OutOfContextTestingActivity;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdwf extends com.google.android.gms.ads.internal.client.zzdv {
    final Map zza = new HashMap();
    private final Context zzb;
    private final WeakReference zzc;
    private final zzdvt zzd;
    private final zzgdy zze;
    private zzdvi zzf;

    zzdwf(Context context, WeakReference weakReference, zzdvt zzdvtVar, zzdwh zzdwhVar, zzgdy zzgdyVar) {
        this.zzb = context;
        this.zzc = weakReference;
        this.zzd = zzdvtVar;
        this.zze = zzgdyVar;
    }

    private final Context zzj() {
        Context context = (Context) this.zzc.get();
        return context == null ? this.zzb : context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzk(Object obj) {
        ResponseInfo responseInfo;
        com.google.android.gms.ads.internal.client.zzea zzc;
        if (obj instanceof LoadAdError) {
            responseInfo = ((LoadAdError) obj).getResponseInfo();
        } else if (obj instanceof AppOpenAd) {
            responseInfo = ((AppOpenAd) obj).getResponseInfo();
        } else if (obj instanceof InterstitialAd) {
            responseInfo = ((InterstitialAd) obj).getResponseInfo();
        } else if (obj instanceof RewardedAd) {
            responseInfo = ((RewardedAd) obj).getResponseInfo();
        } else if (obj instanceof RewardedInterstitialAd) {
            responseInfo = ((RewardedInterstitialAd) obj).getResponseInfo();
        } else if (obj instanceof AdView) {
            responseInfo = ((AdView) obj).getResponseInfo();
        } else {
            if (!(obj instanceof NativeAd)) {
                return "";
            }
            responseInfo = ((NativeAd) obj).getResponseInfo();
        }
        if (responseInfo == null || (zzc = responseInfo.zzc()) == null) {
            return "";
        }
        try {
            return zzc.zzh();
        } catch (RemoteException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzl(String str) {
        try {
            zzgdn.zzr(this.zzf.zzb(str), new zzdwd(this), this.zze);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "OutOfContextTester.setAdAsOutOfContext");
            this.zzd.zzk();
        }
    }

    private final synchronized void zzm(String str) {
        try {
            zzgdn.zzr(this.zzf.zzb(str), new zzdwe(this), this.zze);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "OutOfContextTester.setAdAsShown");
            this.zzd.zzk();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdw
    public final void zze(String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        ViewGroup viewGroup = (ViewGroup) ObjectWrapper.unwrap(iObjectWrapper2);
        if (context == null || viewGroup == null) {
            return;
        }
        Map map = this.zza;
        Object obj = map.get(str);
        if (obj != null) {
            map.remove(str);
        }
        if (obj instanceof AdView) {
            zzdwh.zza(context, viewGroup, (AdView) obj);
        } else if (obj instanceof NativeAd) {
            zzdwh.zzb(context, viewGroup, (NativeAd) obj);
        }
    }

    public final void zzf(zzdvi zzdviVar) {
        this.zzf = zzdviVar;
    }

    protected final synchronized void zzg(String str, Object obj) {
        this.zza.put(str, obj);
        zzl(zzk(obj));
    }

    public final synchronized void zzh(zzdwg zzdwgVar) {
        char c;
        String zzf = zzdwgVar.zzf();
        switch (zzf.hashCode()) {
            case -1999289321:
                if (zzf.equals("NATIVE")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1372958932:
                if (zzf.equals("INTERSTITIAL")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -428325382:
                if (zzf.equals("APP_OPEN_AD")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 543046670:
                if (zzf.equals("REWARDED")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1854800829:
                if (zzf.equals("REWARDED_INTERSTITIAL")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1951953708:
                if (zzf.equals("BANNER")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            String zze = zzdwgVar.zze();
            AppOpenAd.load(zzj(), zze, zzdwgVar.zza(), new zzdvx(this, zze));
            return;
        }
        if (c == 1) {
            String zze2 = zzdwgVar.zze();
            zzbcv zzbcvVar = zzbde.zzjP;
            BaseAdView adManagerAdView = (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue() && zzdwgVar.zzn()) ? new AdManagerAdView(zzj()) : new AdView(zzj());
            adManagerAdView.setAdSize(zzdwgVar.zzb());
            adManagerAdView.setAdUnitId(zze2);
            adManagerAdView.setAdListener(new zzdvy(this, zze2, adManagerAdView));
            VideoOptions zzc = zzdwgVar.zzc();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue() && zzdwgVar.zzn() && zzc != null) {
                ((AdManagerAdView) adManagerAdView).setVideoOptions(zzc);
            }
            adManagerAdView.loadAd(zzdwgVar.zza());
            return;
        }
        if (c == 2) {
            String zze3 = zzdwgVar.zze();
            InterstitialAd.load(zzj(), zze3, zzdwgVar.zza(), new zzdvz(this, zze3));
            return;
        }
        if (c != 3) {
            if (c == 4) {
                String zze4 = zzdwgVar.zze();
                RewardedAd.load(zzj(), zze4, zzdwgVar.zza(), new zzdwa(this, zze4));
                return;
            } else {
                if (c != 5) {
                    return;
                }
                String zze5 = zzdwgVar.zze();
                RewardedInterstitialAd.load(zzj(), zze5, zzdwgVar.zza(), new zzdwb(this, zze5));
                return;
            }
        }
        final String zze6 = zzdwgVar.zze();
        AdLoader.Builder builder = new AdLoader.Builder(zzj(), zze6);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: com.google.android.gms.internal.ads.zzdvw
            @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
            public final void onNativeAdLoaded(NativeAd nativeAd) {
                zzdwf.this.zzg(zze6, nativeAd);
            }
        });
        builder.withAdListener(new zzdwc(this));
        NativeAdOptions zzd = zzdwgVar.zzd();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjP)).booleanValue() && zzd != null) {
            builder.withNativeAdOptions(zzd);
        }
        builder.build().loadAd(zzdwgVar.zza());
    }

    public final synchronized void zzi(String str) {
        Map map;
        Object obj;
        Activity zzg = this.zzd.zzg();
        if (zzg != null && (obj = (map = this.zza).get(str)) != null) {
            zzbcv zzbcvVar = zzbde.zzjO;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue() || (obj instanceof AppOpenAd) || (obj instanceof InterstitialAd) || (obj instanceof RewardedAd) || (obj instanceof RewardedInterstitialAd)) {
                map.remove(str);
            }
            zzm(zzk(obj));
            if (obj instanceof AppOpenAd) {
                ((AppOpenAd) obj).show(zzg);
                return;
            }
            if (obj instanceof InterstitialAd) {
                ((InterstitialAd) obj).show(zzg);
                return;
            }
            if (obj instanceof RewardedAd) {
                ((RewardedAd) obj).show(zzg, new OnUserEarnedRewardListener() { // from class: com.google.android.gms.internal.ads.zzdvu
                    @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
                    public final void onUserEarnedReward(RewardItem rewardItem) {
                    }
                });
                return;
            }
            if (obj instanceof RewardedInterstitialAd) {
                ((RewardedInterstitialAd) obj).show(zzg, new OnUserEarnedRewardListener() { // from class: com.google.android.gms.internal.ads.zzdvv
                    @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
                    public final void onUserEarnedReward(RewardItem rewardItem) {
                    }
                });
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue() && ((obj instanceof AdView) || (obj instanceof NativeAd))) {
                Intent intent = new Intent();
                Context zzj = zzj();
                intent.setClassName(zzj, OutOfContextTestingActivity.CLASS_NAME);
                intent.putExtra("adUnit", str);
                com.google.android.gms.ads.internal.zzv.zzr();
                com.google.android.gms.ads.internal.util.zzs.zzU(zzj, intent);
            }
        }
    }
}
