package com.instagram.common.viewpoint.core;

import android.content.Context;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.RewardedInterstitialAd;
import com.facebook.ads.internal.api.RewardedInterstitialAdApi;
import com.facebook.ads.internal.context.Repairable;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public final class SD implements RewardedInterstitialAdApi, Repairable {
    public static byte[] A01;
    public final SH A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 66);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{80, 80, 1, 84, 82, 91, 91, 2, 54, 52, 97, 96, 100, 96, 55, 96, 108, 106, 59, 56, 60, 105, 56, 63, Ascii.SO, 93, 93, Ascii.FF, 10, 88, 8, Ascii.VT, SignedBytes.MAX_POWER_OF_TWO, 119, 101, 115, 96, 118, 119, 118, 50, 123, 124, 102, 119, 96, 97, 102, 123, 102, 123, 115, 126, 50, 115, 118, 50, 118, 119, 97, 102, 96, 125, 107, 119, 118, Ascii.RS, 41, 59, 45, 62, 40, 41, 40, 108, 37, 34, 56, 41, 62, 63, 56, 37, 56, 37, 45, 32, 108, 45, 40, 108, 32, 35, 45, 40, 108, 62, 41, Base64.padSymbol, 57, 41, 63, 56, 41, 40, 122, 77, 95, 73, 90, 76, 77, 76, 8, 65, 70, 92, 77, 90, 91, 92, 65, 92, 65, 73, 68, 8, 73, 76, 8, 91, SignedBytes.MAX_POWER_OF_TWO, 71, 95, 8, 75, 73, 68, 68, 77, 76, 126, Byte.MAX_VALUE, 105, 110, 104, 117, 99, Ascii.US, Ascii.FS, Ascii.DC2, Ascii.ETB, 50, Ascii.ETB, 41, 50, 53, 45};
    }

    public SD(Context context, String str, RewardedInterstitialAd rewardedInterstitialAd) {
        this.A00 = new SH(context, str, rewardedInterstitialAd);
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi, com.facebook.ads.FullScreenAd
    public final RewardedInterstitialAd.RewardedInterstitialAdLoadConfigBuilder buildLoadAdConfig() {
        return new SF(this.A00.buildLoadAdConfig());
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi, com.facebook.ads.FullScreenAd
    public final RewardedInterstitialAd.RewardedInterstitialAdShowConfigBuilder buildShowAdConfig() {
        return new SG(this.A00.buildShowAdConfig());
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi, com.facebook.ads.Ad
    public final void destroy() {
        AbstractC1412Vy.A05(A00(ModuleDescriptor.MODULE_VERSION, 7, 88), A00(32, 34, 80), A00(24, 8, Sdk.SDKError.Reason.TPAT_ERROR_VALUE));
        this.A00.A04();
    }

    public final void finalize() {
        this.A00.finalize();
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi, com.facebook.ads.Ad
    public final String getPlacementId() {
        return this.A00.getPlacementId();
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi
    public final int getVideoDuration() {
        return this.A00.getVideoDuration();
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        return this.A00.isAdInvalidated();
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi
    public final boolean isAdLoaded() {
        return this.A00.isAdLoaded();
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi, com.facebook.ads.Ad
    public final void loadAd() {
        AbstractC1412Vy.A05(A00(148, 6, 49), A00(66, 39, 14), A00(16, 8, 27));
        this.A00.A07(null, AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED_INTERSTITIAL, true);
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi
    public final void loadAd(RewardedInterstitialAd.RewardedInterstitialLoadAdConfig rewardedInterstitialLoadAdConfig) {
        ((SF) rewardedInterstitialLoadAdConfig).A00();
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th) {
        this.A00.repair(th);
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi, com.facebook.ads.Ad
    @Deprecated
    public final void setExtraHints(ExtraHints extraHints) {
        this.A00.setExtraHints(extraHints);
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi, com.facebook.ads.FullScreenAd
    public final boolean show() {
        AbstractC1412Vy.A05(A00(154, 4, 24), A00(105, 36, 106), A00(0, 8, 33));
        return this.A00.A08(new SJ().withAppOrientation(-1).build());
    }

    @Override // com.facebook.ads.internal.api.RewardedInterstitialAdApi
    public final boolean show(RewardedInterstitialAd.RewardedInterstitialShowAdConfig rewardedInterstitialShowAdConfig) {
        AbstractC1412Vy.A05(A00(154, 4, 24), A00(105, 36, 106), A00(8, 8, 64));
        return this.A00.A08(((SG) rewardedInterstitialShowAdConfig).A00());
    }
}
