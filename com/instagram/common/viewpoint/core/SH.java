package com.instagram.common.viewpoint.core;

import android.content.Context;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: assets/audience_network/classes2.dex */
public final class SH implements RewardedVideoAdApi, Repairable {
    public static byte[] A04;
    public static String[] A05 = {"k8yEFjaDDmJNEMKVrce3vEWkKDhb9GrD", "5HJZEEaowyWiZ6x5JcW91LnqKILZK9iv", "JCdbC5zohUOjfclxz", "cbOkRGwJ0he66t85Zev39Ck1DLyP", "QnWh1EoQaEskbAIVlUx7Y0ywxM6b", "GMmjAnpO", "8CCIVLGxcMAoQXrfALv1hDyohO9DfryR", "UYxyoZ6BjjTfNK3ar4eEie7WMpDsFwCV"};
    public final Ad A00;
    public final C2024iI A01;
    public final C7X A02;
    public final C1929gi A03;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 9);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{120, 124, 121, 121, 44, 40, 113, 45, Ascii.ESC, 74, Ascii.SUB, Ascii.SYN, 74, 76, Ascii.GS, 75, 102, 48, 50, 97, 53, 97, 48, 55, 32, 117, 34, 113, 37, 46, 46, 34, 52, 19, 9, Ascii.CAN, Ascii.SI, 19, Ascii.FS, 17, 93, Ascii.CAN, Ascii.SI, Ascii.SI, Ascii.DC2, Ascii.SI, 83, 119, 105, 94, 76, 90, 73, 95, 94, 95, Ascii.ESC, 77, 82, 95, 94, 84, Ascii.ESC, 90, 95, Ascii.ESC, 95, 94, 72, 79, 73, 84, 66, 94, 95, 59, Ascii.FF, Ascii.RS, 8, Ascii.ESC, Ascii.CR, Ascii.FF, Ascii.CR, 73, Ascii.US, 0, Ascii.CR, Ascii.FF, 6, 73, 8, Ascii.CR, 73, 5, 6, 8, Ascii.CR, 73, Ascii.ESC, Ascii.FF, Ascii.CAN, Ascii.FS, Ascii.FF, Ascii.SUB, Ascii.GS, Ascii.FF, Ascii.CR, 33, Ascii.SYN, 4, Ascii.DC2, 1, Ascii.ETB, Ascii.SYN, Ascii.ETB, 83, 5, Ascii.SUB, Ascii.ETB, Ascii.SYN, Ascii.FS, 83, Ascii.DC2, Ascii.ETB, 83, 0, Ascii.ESC, Ascii.FS, 4, 83, Ascii.DLE, Ascii.DC2, Ascii.US, Ascii.US, Ascii.SYN, Ascii.ETB, 66, 67, 85, 82, 84, 73, 95, 73, 74, 68, 65, 100, 65, Ascii.SYN, Ascii.CR, 10, Ascii.DC2};
    }

    static {
        A01();
    }

    public SH(Context context, String str, Ad ad) {
        String uuid;
        this.A00 = ad;
        if (context instanceof C1929gi) {
            this.A03 = (C1929gi) context;
            uuid = this.A03.A0F().getId();
        } else {
            uuid = UUID.randomUUID().toString();
            this.A03 = C1302Rp.A07(context, uuid);
        }
        InterfaceC1155Lt A0F = this.A03.A0F();
        String adId = AdPlacementType.REWARDED_VIDEO.toString();
        A0F.A3T(adId, str);
        this.A01 = new C2024iI(this.A03, str, this.A00, new C2048ij());
        this.A03.A0O(this);
        this.A02 = new C7X(this.A01, uuid);
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.FullScreenAd
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final SI buildLoadAdConfig() {
        return new SI(this);
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.FullScreenAd
    /* renamed from: A03, reason: merged with bridge method [inline-methods] */
    public final SJ buildShowAdConfig() {
        return new SJ();
    }

    public final void A04() {
        if (C1379Up.A2M(this.A03)) {
            return;
        }
        this.A02.A08();
        this.A03.A0F().A3U();
    }

    public final void A05(RewardData rewardData) {
        this.A02.A0G(rewardData);
    }

    public final void A06(RewardedVideoAdListener rewardedVideoAdListener) {
        this.A01.A04 = rewardedVideoAdListener;
        this.A03.A0F().A3M(rewardedVideoAdListener != null);
        String[] strArr = A05;
        if (strArr[1].charAt(24) != strArr[0].charAt(24)) {
            throw new RuntimeException();
        }
        A05[6] = "1SRpemADNZd8xb9i9fuLSYNF0AwY2Tu2";
    }

    public final void A07(String str, AdExperienceType adExperienceType, boolean z) {
        if (str == null) {
            this.A03.A0F().A3Q();
        } else {
            C1929gi c1929gi = this.A03;
            if (A05[6].charAt(25) == 'H') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[3] = "67CWYk6q7caxeYWX3cgidRuGJDEH";
            strArr[4] = "JzT9b8y5FiDfchRrDecE58hhFV9F";
            c1929gi.A0F().A3P();
        }
        this.A02.A0F(this.A00, str, adExperienceType, z);
        this.A03.A0F().A3O();
    }

    public final boolean A08(RewardedVideoAd.RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        this.A03.A0F().A3Z();
        boolean A0J = this.A02.A0J(this.A00, rewardedVideoShowAdConfig);
        this.A03.A0F().A3Y(A0J);
        return A0J;
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.Ad
    public final void destroy() {
        AbstractC1412Vy.A05(A00(136, 7, 47), A00(48, 27, 50), A00(0, 8, 64));
        A04();
    }

    public final void finalize() {
        this.A02.A07();
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.Ad
    public final String getPlacementId() {
        return this.A01.A0D;
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final int getVideoDuration() {
        return this.A01.A00;
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        boolean A0H = this.A02.A0H();
        this.A03.A0F().A5f(A0H);
        return A0H;
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final boolean isAdLoaded() {
        return this.A02.A0I();
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.Ad
    public final void loadAd() {
        AbstractC1412Vy.A05(A00(143, 6, 44), A00(75, 32, 96), A00(24, 8, 30));
        A07(null, null, true);
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final void loadAd(RewardedVideoAd.RewardedVideoLoadAdConfig rewardedVideoLoadAdConfig) {
        ((SI) rewardedVideoLoadAdConfig).A00();
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th) {
        if (this.A01.A04 != null) {
            this.A01.A04.onError(this.A00, new AdError(2001, A00(32, 16, 116) + AbstractC1456Xt.A03(this.A01.A0B, th)));
        }
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.Ad
    @Deprecated
    public final void setExtraHints(ExtraHints extraHints) {
        this.A01.A06 = extraHints.getHints();
        this.A01.A07 = extraHints.getMediationData();
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.FullScreenAd
    public final boolean show() {
        AbstractC1412Vy.A05(A00(149, 4, 108), A00(107, 29, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE), A00(8, 8, 38));
        return A08(new SJ().withAppOrientation(-1).build());
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final boolean show(RewardedVideoAd.RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        AbstractC1412Vy.A05(A00(149, 4, 108), A00(107, 29, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE), A00(16, 8, 88));
        return A08(rewardedVideoShowAdConfig);
    }
}
