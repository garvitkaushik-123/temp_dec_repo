package com.instagram.common.viewpoint.core;

import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.S2SRewardedVideoAdExtendedListener;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.ib, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2042ib extends N2 {
    public static byte[] A01;
    public final /* synthetic */ C2040iZ A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 43);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{9, Ascii.CAN, 1, 36, 40, 41, 51, 53, 40, 43, 43, 34, 53, 103, 46, 52, 103, 41, 50, 43, 43};
    }

    public C2042ib(C2040iZ c2040iZ) {
        this.A00 = c2040iZ;
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A06() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        s2SRewardedVideoAdExtendedListener = this.A00.A07;
        s2SRewardedVideoAdExtendedListener.onRewardServerFailed();
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A07() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        s2SRewardedVideoAdExtendedListener = this.A00.A07;
        s2SRewardedVideoAdExtendedListener.onRewardServerSuccess();
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A08() {
        RewardedVideoAd rewardedVideoAd;
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        rewardedVideoAd = this.A00.A02;
        if (rewardedVideoAd == null) {
            s2SRewardedVideoAdExtendedListener = this.A00.A07;
            s2SRewardedVideoAdExtendedListener.onRewardedVideoCompleted();
        }
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A09() {
        RewardedVideoAd rewardedVideoAd;
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        rewardedVideoAd = this.A00.A02;
        if (rewardedVideoAd == null) {
            s2SRewardedVideoAdExtendedListener = this.A00.A07;
            s2SRewardedVideoAdExtendedListener.onRewardedVideoActivityDestroyed();
        }
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A0A() {
        RewardedVideoAd rewardedVideoAd;
        RewardedVideoAd rewardedVideoAd2;
        long j;
        RewardedVideoAd rewardedVideoAd3;
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        rewardedVideoAd = this.A00.A02;
        if (rewardedVideoAd != null) {
            rewardedVideoAd2 = this.A00.A02;
            SJ sj = (SJ) rewardedVideoAd2.buildShowAdConfig();
            long currentTimeMillis = System.currentTimeMillis();
            j = this.A00.A01;
            sj.A02(currentTimeMillis - j);
            rewardedVideoAd3 = this.A00.A02;
            rewardedVideoAd3.show(sj.build());
            return;
        }
        s2SRewardedVideoAdExtendedListener = this.A00.A07;
        s2SRewardedVideoAdExtendedListener.onRewardedVideoClosed();
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A0C() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        C2024iI c2024iI;
        this.A00.A06.A0F().A3K();
        s2SRewardedVideoAdExtendedListener = this.A00.A07;
        c2024iI = this.A00.A08;
        s2SRewardedVideoAdExtendedListener.onAdClicked(c2024iI.A6k());
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A0D() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        C2024iI c2024iI;
        s2SRewardedVideoAdExtendedListener = this.A00.A07;
        c2024iI = this.A00.A08;
        s2SRewardedVideoAdExtendedListener.onLoggingImpression(c2024iI.A6k());
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A0F(N1 n1) {
        C07937a c07937a;
        C2024iI c2024iI;
        C2024iI c2024iI2;
        C07937a c07937a2;
        NQ nq;
        RewardedVideoAd rewardedVideoAd;
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        C2024iI c2024iI3;
        NQ nq2;
        RewardedVideoAd rewardedVideoAd2;
        NQ nq3;
        C2024iI c2024iI4;
        RewardedVideoAd rewardedVideoAd3;
        NQ nq4;
        C2024iI c2024iI5;
        C2024iI c2024iI6;
        C2024iI c2024iI7;
        NQ nq5;
        C2024iI c2024iI8;
        c07937a = this.A00.A04;
        if (c07937a == null) {
            this.A00.A06.A08().ABC(A00(0, 3, 67), AbstractC1341Td.A0N, new C1342Te(A00(3, 18, 108)));
            return;
        }
        AbstractC2098jh abstractC2098jh = (AbstractC2098jh) n1;
        c2024iI = this.A00.A08;
        if (c2024iI.A03 != null) {
            c2024iI8 = this.A00.A08;
            abstractC2098jh.A02(c2024iI8.A03);
        }
        c2024iI2 = this.A00.A08;
        c2024iI2.A00 = abstractC2098jh.A0H();
        this.A00.A05 = true;
        C2040iZ c2040iZ = this.A00;
        c07937a2 = this.A00.A04;
        c2040iZ.A03 = c07937a2.A0I();
        nq = this.A00.A03;
        if (nq != null) {
            int i = 0;
            nq4 = this.A00.A03;
            if (!nq4.A1b()) {
                nq5 = this.A00.A03;
                i = ((AbstractC2094jd) nq5).A26();
            }
            if (i > 0) {
                XC xc = new XC();
                C1929gi c1929gi = this.A00.A06;
                c2024iI5 = this.A00.A08;
                if (xc.A09(c1929gi, c2024iI5.A06, i)) {
                    xc.A08(this.A00.A06, true);
                    C2040iZ c2040iZ2 = this.A00;
                    C1929gi c1929gi2 = this.A00.A06;
                    c2024iI6 = this.A00.A08;
                    String str = c2024iI6.A0D;
                    c2024iI7 = this.A00.A08;
                    c2040iZ2.A02 = xc.A07(c1929gi2, str, c2024iI7.A06);
                } else {
                    xc.A08(this.A00.A06, false);
                }
            }
        }
        rewardedVideoAd = this.A00.A02;
        if (rewardedVideoAd == null) {
            s2SRewardedVideoAdExtendedListener = this.A00.A07;
            c2024iI3 = this.A00.A08;
            s2SRewardedVideoAdExtendedListener.onAdLoaded(c2024iI3.A6k());
            return;
        }
        nq2 = this.A00.A03;
        ((AbstractC2094jd) nq2).A2J(true);
        rewardedVideoAd2 = this.A00.A02;
        RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withFailOnCacheFailureEnabled = rewardedVideoAd2.buildLoadAdConfig().withFailOnCacheFailureEnabled(true);
        nq3 = this.A00.A03;
        RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withRewardData = withFailOnCacheFailureEnabled.withRewardData(nq3.A0s());
        c2024iI4 = this.A00.A08;
        RewardedVideoAd.RewardedVideoLoadAdConfig loadAdConfig = withRewardData.withAdExperience(c2024iI4.A02).withAdListener(new OI(this)).build();
        rewardedVideoAd3 = this.A00.A02;
        rewardedVideoAd3.loadAd(loadAdConfig);
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A0G(C1401Vm c1401Vm) {
        C2024iI c2024iI;
        long j;
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        C2024iI c2024iI2;
        this.A00.A0D(true);
        c2024iI = this.A00.A08;
        InterfaceC1155Lt A0F = c2024iI.A0B.A0F();
        j = this.A00.A00;
        A0F.A3N(Y1.A01(j), c1401Vm.A03().getErrorCode(), c1401Vm.A04());
        s2SRewardedVideoAdExtendedListener = this.A00.A07;
        c2024iI2 = this.A00.A08;
        s2SRewardedVideoAdExtendedListener.onError(c2024iI2.A6k(), XE.A00(c1401Vm));
    }
}
