package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.ironsource.kd, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3167kd {
    private static C3167kd b;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, NetworkSettings> f3409a = new ConcurrentHashMap<>();

    private C3167kd() {
    }

    public static synchronized C3167kd c() {
        C3167kd c3167kd;
        synchronized (C3167kd.class) {
            if (b == null) {
                b = new C3167kd();
            }
            c3167kd = b;
        }
        return c3167kd;
    }

    public void a(NetworkSettings networkSettings) {
        if (networkSettings == null || TextUtils.isEmpty(networkSettings.getProviderName())) {
            return;
        }
        this.f3409a.put(networkSettings.getProviderName(), networkSettings);
    }

    public NetworkSettings b(String str) {
        NetworkSettings networkSettings = this.f3409a.get(str);
        if (networkSettings != null) {
            return networkSettings;
        }
        NetworkSettings networkSettings2 = new NetworkSettings(str);
        a(networkSettings2);
        return networkSettings2;
    }

    public ConcurrentHashMap<String, NetworkSettings> d() {
        return this.f3409a;
    }

    public void a() {
        this.f3409a.clear();
    }

    public HashSet<String> a(String str, String str2) {
        HashSet<String> hashSet = new HashSet<>();
        try {
            for (NetworkSettings networkSettings : this.f3409a.values()) {
                if (networkSettings.getProviderTypeForReflection().equals(str)) {
                    if (networkSettings.getRewardedVideoSettings() != null && networkSettings.getRewardedVideoSettings().length() > 0 && !TextUtils.isEmpty(networkSettings.getRewardedVideoSettings().optString(str2))) {
                        hashSet.add(networkSettings.getRewardedVideoSettings().optString(str2));
                    }
                    if (networkSettings.getInterstitialSettings() != null && networkSettings.getInterstitialSettings().length() > 0 && !TextUtils.isEmpty(networkSettings.getInterstitialSettings().optString(str2))) {
                        hashSet.add(networkSettings.getInterstitialSettings().optString(str2));
                    }
                    if (networkSettings.getBannerSettings() != null && networkSettings.getBannerSettings().length() > 0 && !TextUtils.isEmpty(networkSettings.getBannerSettings().optString(str2))) {
                        hashSet.add(networkSettings.getBannerSettings().optString(str2));
                    }
                    if (networkSettings.getNativeAdSettings() != null && networkSettings.getNativeAdSettings().length() > 0 && !TextUtils.isEmpty(networkSettings.getNativeAdSettings().optString(str2))) {
                        hashSet.add(networkSettings.getNativeAdSettings().optString(str2));
                    }
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
        }
        return hashSet;
    }

    public NetworkSettings c(String str) {
        for (NetworkSettings networkSettings : this.f3409a.values()) {
            if ("IronSource".equals(networkSettings.getProviderTypeForReflection()) && str.equalsIgnoreCase(networkSettings.getSubProviderId())) {
                return networkSettings;
            }
        }
        return new NetworkSettings(str);
    }

    public void b() {
        for (NetworkSettings networkSettings : this.f3409a.values()) {
            if (networkSettings.isMultipleInstances() && !TextUtils.isEmpty(networkSettings.getProviderTypeForReflection())) {
                NetworkSettings b2 = b(networkSettings.getProviderDefaultInstance());
                networkSettings.setApplicationSettings(IronSourceUtils.mergeJsons(networkSettings.getApplicationSettings(), b2.getApplicationSettings()));
                networkSettings.setInterstitialSettings(IronSourceUtils.mergeJsons(networkSettings.getInterstitialSettings(), b2.getInterstitialSettings()));
                networkSettings.setRewardedVideoSettings(IronSourceUtils.mergeJsons(networkSettings.getRewardedVideoSettings(), b2.getRewardedVideoSettings()));
                networkSettings.setBannerSettings(IronSourceUtils.mergeJsons(networkSettings.getBannerSettings(), b2.getBannerSettings()));
                networkSettings.setNativeAdSettings(IronSourceUtils.mergeJsons(networkSettings.getNativeAdSettings(), b2.getNativeAdSettings()));
            }
        }
    }

    public boolean a(String str) {
        return this.f3409a.containsKey(str);
    }
}
