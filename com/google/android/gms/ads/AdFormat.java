package com.google.android.gms.ads;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public enum AdFormat {
    BANNER(0),
    INTERSTITIAL(1),
    REWARDED(2),
    REWARDED_INTERSTITIAL(3),
    NATIVE(4),
    APP_OPEN_AD(6);

    private final int zzb;

    AdFormat(int i) {
        this.zzb = i;
    }

    public static AdFormat getAdFormat(int i) {
        for (AdFormat adFormat : values()) {
            if (adFormat.getValue() == i) {
                return adFormat;
            }
        }
        return null;
    }

    public int getValue() {
        return this.zzb;
    }
}
