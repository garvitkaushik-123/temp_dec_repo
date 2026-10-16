package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.ip, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2053ip implements NJ {
    public static byte[] A02;
    public static String[] A03 = {"prnrxiqBIRUWmtrywfPqKqEQqhVy", "ZIMYOFT0ZsWMsvQaDuWdcBD1JUfFlpFK", "eDL3S9t0lib8FebdadRdAEhF6DEMjh5k", "bs6kAZMpX5XJVmB6S4pTEB090dM9ax0i", "QHqe8jS5x4PwEQqsnwl", "gxNXj6OyEOj3k7PGi9sSLvTTkEfltc4s", "tcOGThQLxe2W2uuyyUr03jLhoPapxorM", "Kh0wErWL647o91YILjhTKlO7bRERsR4e"};
    public final /* synthetic */ C07937a A00;
    public final /* synthetic */ Runnable A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 23);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        if (A03[4].length() == 18) {
            throw new RuntimeException();
        }
        A03[7] = "PFnJtf9LUj4qa4JPPUOTumvSeGZYJypM";
        A02 = new byte[]{Ascii.SO, Ascii.FF, 8, 89, Ascii.SI, Ascii.SI, Ascii.SO, Ascii.SO, 118, 65, 83, 69, 86, SignedBytes.MAX_POWER_OF_TWO, 65, SignedBytes.MAX_POWER_OF_TWO, 4, 114, 77, SignedBytes.MAX_POWER_OF_TWO, 65, 75, 4, 77, 73, 84, 86, 65, 87, 87, 77, 75, 74, 4, 66, 77, 86, 65, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 65, 125, 74, 88, 78, 93, 75, 74, 75, 121, 70, 75, 74, SignedBytes.MAX_POWER_OF_TWO, 110, 75, 99, SignedBytes.MAX_POWER_OF_TWO, 72, 72, 70, 65, 72, 102, 66, 95, 93, 74, 92, 92, 70, SignedBytes.MAX_POWER_OF_TWO, 65};
    }

    static {
        A01();
    }

    public C2053ip(C07937a c07937a, Runnable runnable) {
        this.A00 = c07937a;
        this.A01 = runnable;
    }

    @Override // com.instagram.common.viewpoint.core.NJ
    public final void AFj(AbstractC2098jh abstractC2098jh) {
        this.A00.A07.A06();
    }

    @Override // com.instagram.common.viewpoint.core.NJ
    public final void AFk(AbstractC2098jh abstractC2098jh) {
        this.A00.A07.A07();
    }

    @Override // com.instagram.common.viewpoint.core.NJ
    public final void AFl(AbstractC2098jh abstractC2098jh) {
        this.A00.A07.A0C();
    }

    @Override // com.instagram.common.viewpoint.core.NJ
    public final void AFm(AbstractC2098jh abstractC2098jh) {
        this.A00.A0H().removeCallbacks(this.A01);
        this.A00.A01 = abstractC2098jh;
        this.A00.A0L();
        if (this.A00.A07 != null) {
            this.A00.A07.A0F(abstractC2098jh);
        }
    }

    @Override // com.instagram.common.viewpoint.core.NJ
    public final void AFn(AbstractC2098jh abstractC2098jh) {
        AbstractC1412Vy.A05(A00(39, 34, 56), A00(8, 31, 51), A00(0, 8, 47));
        this.A00.A07.A0D();
        this.A00.A0O();
    }

    @Override // com.instagram.common.viewpoint.core.NJ
    public final void AFo(AbstractC2098jh abstractC2098jh) {
        this.A00.A07.A08();
    }

    @Override // com.instagram.common.viewpoint.core.NJ
    public final void AFp(AbstractC2098jh abstractC2098jh, AdError adError) {
        this.A00.A0H().removeCallbacks(this.A01);
        this.A00.A0B.A0F().A5g(adError.getErrorCode(), adError.getErrorMessage());
        if (AdError.AD_PRESENTATION_ERROR.equals(adError) && C1379Up.A1y(this.A00.A0B)) {
            this.A00.A07.A0G(C1401Vm.A00(AdErrorType.AD_PRESENTATION_ERROR));
        } else if (AdError.NO_FILL.equals(adError)) {
            this.A00.A07.A0G(C1401Vm.A00(AdErrorType.NO_FILL));
        } else {
            this.A00.A07.A0G(C1401Vm.A00(AdErrorType.INTERNAL_ERROR));
        }
        this.A00.A0Q(abstractC2098jh);
        if (A03[7].charAt(7) != 'L') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[1] = "5mDNAkmPsKXxtvZqFgypt4QK4uBiUiuf";
        strArr[2] = "5tmiAUheAxojxdkmR27o6gIBrLCMojmA";
    }

    @Override // com.instagram.common.viewpoint.core.NJ
    public final void onRewardedVideoActivityDestroyed() {
        this.A00.A07.A09();
    }

    @Override // com.instagram.common.viewpoint.core.NJ
    public final void onRewardedVideoClosed() {
        this.A00.A07.A0A();
    }
}
