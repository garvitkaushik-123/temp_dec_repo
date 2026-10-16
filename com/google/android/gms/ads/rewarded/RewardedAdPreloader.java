package com.google.android.gms.ads.rewarded;

import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzey;
import com.google.android.gms.ads.internal.client.zzfc;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.preload.PreloadCallbackV2;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class RewardedAdPreloader {
    private RewardedAdPreloader() {
    }

    public static boolean destroy(String str) {
        zzfc zza = zza();
        if (zza == null) {
            return false;
        }
        return zza.zzg(str);
    }

    public static void destroyAll() {
        zzfc zza = zza();
        if (zza != null) {
            zza.zzf();
        }
    }

    public static PreloadConfiguration getConfiguration(String str) {
        zzfc zza = zza();
        if (zza == null) {
            return null;
        }
        return zza.zzd(str);
    }

    public static Map<String, PreloadConfiguration> getConfigurations() {
        zzfc zza = zza();
        return zza == null ? new HashMap() : zza.zze();
    }

    public static int getNumAdsAvailable(String str) {
        zzfc zza = zza();
        if (zza == null) {
            return 0;
        }
        return zza.zzb(str);
    }

    public static boolean isAdAvailable(String str) {
        zzfc zza = zza();
        if (zza == null) {
            return false;
        }
        return zza.zzh(str);
    }

    public static RewardedAd pollAd(String str) {
        zzfc zza = zza();
        if (zza == null) {
            return null;
        }
        return zza.zza(str);
    }

    public static boolean start(String str, PreloadConfiguration preloadConfiguration) {
        zzfc zza = zza();
        if (zza == null) {
            return false;
        }
        return zza.zzi(str, preloadConfiguration);
    }

    private static zzfc zza() {
        zzfc zzfcVar = (zzfc) zzey.zzf().zzg(AdFormat.REWARDED);
        if (zzfcVar == null) {
            zzo.zzl("Failed to get a preloader. Call MobileAds.initialize() prior to calling preload APIs.", null);
        }
        return zzfcVar;
    }

    public static boolean start(String str, PreloadConfiguration preloadConfiguration, PreloadCallbackV2 preloadCallbackV2) {
        zzfc zza = zza();
        if (zza == null) {
            return false;
        }
        return zza.zzj(str, preloadConfiguration, preloadCallbackV2);
    }
}
