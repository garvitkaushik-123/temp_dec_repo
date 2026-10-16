package com.instagram.common.viewpoint.core;

import android.view.View;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.if, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public class Cif extends N2 {
    public static byte[] A01;
    public static String[] A02 = {"swComlxz6aoGHqKS8LOj1g5iAOstdInC", "iLoXwxITRpbgZFbT1koR1uJW4vvDXY2W", "MpkXHfR6HdYIg9t449R", "HQI6v11U6roDlbOuDHGyMjhCWVrAbgmk", "qsbQ14vrFuO8q1N0nwgFIOsRNgh3HWyt", "NXqrvE65RyYHWICx", "E9yzS8MfEszoKvwo", "osh9YHk0bwFUuMRHqHbnPk"};
    public final /* synthetic */ C2043id A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 98);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{97, 112, 105, 47, 35, 34, 56, 62, 35, 32, 32, 41, 62, 108, 37, 63, 108, 34, 57, 32, 32};
    }

    static {
        A01();
    }

    public Cif(C2043id c2043id) {
        this.A00 = c2043id;
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A02() {
        InterstitialAd interstitialAd;
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        interstitialAd = this.A00.A01;
        if (interstitialAd == null) {
            this.A00.A04 = false;
            interstitialAdExtendedListener = this.A00.A07;
            interstitialAdExtendedListener.onInterstitialActivityDestroyed();
        }
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A04() {
        InterstitialAd interstitialAd;
        InterstitialAd interstitialAd2;
        C08027j c08027j;
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        C2039iY c2039iY;
        C08027j c08027j2;
        C08027j c08027j3;
        C08027j c08027j4;
        interstitialAd = this.A00.A01;
        if (interstitialAd != null) {
            interstitialAd2 = this.A00.A01;
            interstitialAd2.show();
            return;
        }
        this.A00.A04 = false;
        c08027j = this.A00.A03;
        if (c08027j != null && C1379Up.A2D(this.A00.A06)) {
            c08027j2 = this.A00.A03;
            c08027j2.A0S(new C2045ig(this));
            c08027j3 = this.A00.A03;
            c08027j3.A0N();
            c08027j4 = this.A00.A03;
            c08027j4.A0K();
            this.A00.A03 = null;
        }
        interstitialAdExtendedListener = this.A00.A07;
        c2039iY = this.A00.A08;
        interstitialAdExtendedListener.onInterstitialDismissed(c2039iY.A6k());
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A05() {
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        C2039iY c2039iY;
        interstitialAdExtendedListener = this.A00.A07;
        c2039iY = this.A00.A08;
        interstitialAdExtendedListener.onInterstitialDisplayed(c2039iY.A6k());
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A06() {
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        interstitialAdExtendedListener = this.A00.A07;
        interstitialAdExtendedListener.onRewardedAdServerFailed();
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A07() {
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        interstitialAdExtendedListener = this.A00.A07;
        interstitialAdExtendedListener.onRewardedAdServerSucceeded();
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A08() {
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        interstitialAdExtendedListener = this.A00.A07;
        interstitialAdExtendedListener.onRewardedAdCompleted();
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A0C() {
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        C2039iY c2039iY;
        this.A00.A06.A0F().A3K();
        interstitialAdExtendedListener = this.A00.A07;
        c2039iY = this.A00.A08;
        interstitialAdExtendedListener.onAdClicked(c2039iY.A6k());
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A0D() {
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        C2039iY c2039iY;
        interstitialAdExtendedListener = this.A00.A07;
        c2039iY = this.A00.A08;
        interstitialAdExtendedListener.onLoggingImpression(c2039iY.A6k());
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A0E(View view) {
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A0F(N1 n1) {
        C08027j c08027j;
        C08027j c08027j2;
        NQ nq;
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        C2039iY c2039iY;
        NQ nq2;
        InterstitialAd interstitialAd;
        InterstitialAdExtendedListener interstitialAdExtendedListener2;
        C2039iY c2039iY2;
        InterstitialAdExtendedListener interstitialAdExtendedListener3;
        C2039iY c2039iY3;
        InterstitialAd interstitialAd2;
        C2039iY c2039iY4;
        C2039iY c2039iY5;
        InterstitialAd interstitialAd3;
        C2039iY c2039iY6;
        C2039iY c2039iY7;
        C2039iY c2039iY8;
        c08027j = this.A00.A03;
        if (c08027j != null) {
            this.A00.A05 = true;
            C2043id c2043id = this.A00;
            c08027j2 = this.A00.A03;
            c2043id.A02 = c08027j2.A0I();
            nq = this.A00.A02;
            if (!(nq instanceof AbstractC2094jd)) {
                interstitialAdExtendedListener = this.A00.A07;
                String[] strArr = A02;
                if (strArr[0].charAt(8) == strArr[3].charAt(8)) {
                    String[] strArr2 = A02;
                    strArr2[6] = "JHAXxmwzHKs3NajX";
                    strArr2[5] = "FHZeNyejFCAXh3Vz";
                    c2039iY = this.A00.A08;
                    interstitialAdExtendedListener.onAdLoaded(c2039iY.A6k());
                    return;
                }
            } else {
                nq2 = this.A00.A02;
                AbstractC2094jd abstractC2094jd = (AbstractC2094jd) nq2;
                if (abstractC2094jd.A26() > 0) {
                    XC xc = new XC();
                    C1929gi c1929gi = this.A00.A06;
                    c2039iY6 = this.A00.A08;
                    if (xc.A09(c1929gi, c2039iY6.A08(), abstractC2094jd.A26())) {
                        xc.A08(this.A00.A06, true);
                        C2043id c2043id2 = this.A00;
                        C1929gi c1929gi2 = this.A00.A06;
                        c2039iY7 = this.A00.A08;
                        String A0A = c2039iY7.A0A();
                        c2039iY8 = this.A00.A08;
                        c2043id2.A01 = xc.A06(c1929gi2, A0A, c2039iY8.A08());
                    } else {
                        C2043id c2043id3 = this.A00;
                        if (A02[1].charAt(2) != 'w') {
                            A02[7] = "alFbtn3b1";
                            xc.A08(c2043id3.A06, false);
                        } else {
                            String[] strArr3 = A02;
                            strArr3[6] = "OkLAbmcEeyte5Vfo";
                            strArr3[5] = "zgaU15rF2mVDrexS";
                            xc.A08(c2043id3.A06, false);
                        }
                    }
                }
                C2043id c2043id4 = this.A00;
                if (A02[1].charAt(2) != 'w') {
                    A02[1] = "23I4hcZMgJ395X2lYna8PMjzW0ozt3hz";
                    interstitialAd = c2043id4.A01;
                    if (interstitialAd != null) {
                        abstractC2094jd.A2J(true);
                        interstitialAd2 = this.A00.A01;
                        InterstitialAd.InterstitialAdLoadConfigBuilder withAdListener = interstitialAd2.buildLoadAdConfig().withAdListener(new OH(this, abstractC2094jd));
                        c2039iY4 = this.A00.A08;
                        InterstitialAd.InterstitialAdLoadConfigBuilder withCacheFlags = withAdListener.withCacheFlags(c2039iY4.A0B());
                        c2039iY5 = this.A00.A08;
                        InterstitialAd.InterstitialLoadAdConfig loadAdConfig = withCacheFlags.withRewardData(c2039iY5.A03()).build();
                        interstitialAd3 = this.A00.A01;
                        interstitialAd3.loadAd(loadAdConfig);
                        return;
                    }
                    C2043id c2043id5 = this.A00;
                    String[] strArr4 = A02;
                    if (strArr4[0].charAt(8) != strArr4[3].charAt(8)) {
                        interstitialAdExtendedListener3 = c2043id5.A07;
                        c2039iY3 = this.A00.A08;
                        interstitialAdExtendedListener3.onAdLoaded(c2039iY3.A6k());
                        return;
                    } else {
                        A02[2] = "joZPUUFug9Ts";
                        interstitialAdExtendedListener2 = c2043id5.A07;
                        c2039iY2 = this.A00.A08;
                        interstitialAdExtendedListener2.onAdLoaded(c2039iY2.A6k());
                        return;
                    }
                }
            }
            throw new RuntimeException();
        }
        this.A00.A06.A08().ABC(A00(0, 3, 98), AbstractC1341Td.A0N, new C1342Te(A00(3, 18, 46)));
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A0G(C1401Vm c1401Vm) {
        long j;
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        C2039iY c2039iY;
        InterfaceC1155Lt A0F = this.A00.A06.A0F();
        j = this.A00.A00;
        A0F.A3N(Y1.A01(j), c1401Vm.A03().getErrorCode(), c1401Vm.A04());
        interstitialAdExtendedListener = this.A00.A07;
        c2039iY = this.A00.A08;
        interstitialAdExtendedListener.onError(c2039iY.A6k(), XE.A00(c1401Vm));
    }
}
