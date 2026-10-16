package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.InterstitialAdListener;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.iU, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2035iU implements OQ {
    public static byte[] A05;
    public static String[] A06 = {"41kFMkgYcMqjBdEAHWyZzQ9Q1YQDMkZo", "a1qrqbdzoLKte5dp2TdqsHV2Btmo8HIO", "VlRnhGghZyM7Xz", "WVmrs7jRPAo6ieNv", "abQhu9SgesOIRxLkCU6L7yAdrfeNFYXV", "iVqBhi5IkesALAcr", "e6wMTa30i0R6i9", "GTVyj1NjpD4uWxM1mBTnBnh1LH0X6W6g"};
    public boolean A00;
    public final OE A01;
    public final C2039iY A02;
    public final OL A03;
    public final C1929gi A04;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 112);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{110, 75, Ascii.SI, SignedBytes.MAX_POWER_OF_TWO, 77, 69, 74, 76, 91, Ascii.SI, 70, 92, Ascii.SI, 65, 90, 67, 67, 9, Ascii.RS, 5, Ascii.SI, 7, Ascii.SO, Ascii.DC4, Ascii.SO, 19, Ascii.US, Ascii.EM, 10, Ascii.CAN, Ascii.DC4, 0, Ascii.SO, Ascii.DC2, 47, 43, 40, Ascii.FS, Ascii.CR, 0, Ascii.FF, 7, 10, Ascii.FF, 39, Ascii.FF, Ascii.GS, Ascii.RS, 6, Ascii.ESC, 2, 87, 80, 74, 65, 91, 76, 76, 81, 76, 65, 93, 81, 90, 91, 65, 85, 91, 71, Ascii.SO, Ascii.CR, Ascii.FF, 5, Ascii.GS, Ascii.VT, Ascii.FF, Ascii.DC4, 3, Ascii.SO, Ascii.VT, 6, 3, Ascii.SYN, Ascii.VT, Ascii.CR, Ascii.FF, Ascii.GS, Ascii.SYN, Ascii.VT, Ascii.SI, 7, Ascii.GS, 9, 7, Ascii.ESC, 39, Ascii.SI, Ascii.EM, Ascii.EM, Ascii.VT, Ascii.CR, Ascii.SI, 80, 74, 118, 82, 72, 72, 82, 85, 92, Ascii.ESC, 89, 78, 85, 95, 87, 94, Ascii.ESC, 93, 84, 73, Ascii.ESC, 86, 94, 72, 72, 90, 92, 94, Ascii.NAK, 35, 36, 34, 47, 53, 34, 34, 63, 34, 47, Base64.padSymbol, 53, 35, 35, 49, 55, 53, 47, 59, 53, 41, 72, 89, SignedBytes.MAX_POWER_OF_TWO};
    }

    static {
        A01();
    }

    public C2035iU(C1929gi c1929gi, C2039iY c2039iY, OE oe, OL ol) {
        this.A04 = c1929gi;
        this.A02 = c2039iY;
        this.A01 = oe;
        this.A03 = ol;
    }

    @Override // com.instagram.common.viewpoint.core.OQ
    public final Bundle A5R(String str) {
        return OX.A02(str, this.A02);
    }

    @Override // com.instagram.common.viewpoint.core.OQ
    public final void A5v() {
        this.A03.A0F(1012, null);
        this.A03.A0C();
        this.A02.A0D(null);
    }

    @Override // com.instagram.common.viewpoint.core.OQ
    public final int A8P() {
        return 1010;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x014d  */
    @Override // com.instagram.common.viewpoint.core.OQ
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A9j(Message message) {
        InterstitialAd A6k = this.A02.A6k();
        String A00 = A00(152, 3, 89);
        if (A6k == null) {
            this.A04.A08().ABC(A00, AbstractC1341Td.A0K, new C1342Te(A00(0, 17, 95)));
            return;
        }
        int i = message.what;
        String A002 = A00(95, 9, 26);
        String A003 = A00(104, 27, 75);
        String A004 = A00(17, 17, 59);
        switch (i) {
            case 10:
            case 1023:
                Bundle bundle = message.getData().getBundle(A004);
                if (bundle != null) {
                    int i2 = bundle.getInt(A00(51, 18, 110));
                    String string = bundle.getString(A00(Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, 21, 0));
                    AdError adError = new AdError(i2, string);
                    this.A01.AJR(adError);
                    if (this.A02.A6o() != null) {
                        InterstitialAdListener A6o = this.A02.A6o();
                        String[] strArr = A06;
                        String str = strArr[1];
                        String str2 = strArr[0];
                        int errorCode = str.charAt(1);
                        if (errorCode != str2.charAt(1)) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A06;
                        strArr2[2] = "mejJWXlfs8BbYc";
                        strArr2[6] = "mZxW76dM1wQ3lj";
                        A6o.onError(A6k, adError);
                    } else {
                        Log.e(A00(34, 17, 25), string);
                    }
                } else {
                    this.A01.AJM(OD.A04);
                    this.A04.A08().ABC(A00, AbstractC1341Td.A0V, new C1342Te(A003, A002 + message));
                }
                this.A02.A0D(null);
                return;
            case 1020:
                this.A01.AJW();
                Bundle bundle2 = message.getData().getBundle(A004);
                if (bundle2 != null) {
                    this.A02.A0C(bundle2.getLong(A00(69, 26, 50)));
                } else {
                    this.A04.A08().ABC(A00, AbstractC1341Td.A0V, new C1342Te(A003, A002 + message));
                }
                this.A02.A0D(null);
                break;
            case 1022:
                this.A01.AJm();
                break;
        }
        if (this.A02.A6o() == null) {
            return;
        }
        int i3 = message.what;
        String[] strArr3 = A06;
        if (strArr3[4].charAt(13) == strArr3[7].charAt(13)) {
            String[] strArr4 = A06;
            strArr4[1] = "311XYum1gU07qORRQ11S6l3eVKorNtDz";
            strArr4[0] = "91xN7y0ETPjwD6LsGrgnzhnoOTtOTKl3";
            switch (i3) {
                case 1020:
                    if (!this.A00) {
                        this.A02.A6o().onAdLoaded(A6k);
                        return;
                    } else {
                        this.A00 = false;
                        return;
                    }
                case 1021:
                    this.A02.A6o().onInterstitialDisplayed(A6k);
                    return;
                case 1022:
                    this.A02.A6o().onInterstitialDismissed(A6k);
                    return;
                case 1023:
                default:
                    if (this.A02.A04() != null) {
                        return;
                    }
                    int i4 = message.what;
                    String[] strArr5 = A06;
                    if (strArr5[5].length() == strArr5[3].length()) {
                        String[] strArr6 = A06;
                        strArr6[4] = "s5jamizIFVbotxZqKkKlcngcWbLxgQvF";
                        strArr6[7] = "aiBjTIjz8RGRWx4VpHoYFj9LDTOMQV9R";
                        switch (i4) {
                            case 3000:
                                break;
                            case 3001:
                                break;
                            case 3002:
                                break;
                            default:
                                return;
                        }
                    } else {
                        switch (i4) {
                            case 3000:
                                this.A02.A04().onRewardedAdCompleted();
                                return;
                            case 3001:
                                this.A02.A04().onRewardedAdServerSucceeded();
                                return;
                            case 3002:
                                this.A02.A04().onRewardedAdServerFailed();
                                return;
                            default:
                                return;
                        }
                    }
                case 1024:
                    this.A02.A6o().onAdClicked(A6k);
                    return;
                case 1025:
                    this.A02.A6o().onLoggingImpression(A6k);
                    return;
                case 1026:
                    boolean z = this.A02.A6o() instanceof InterstitialAdExtendedListener;
                    String[] strArr7 = A06;
                    if (strArr7[2].length() == strArr7[6].length()) {
                        String[] strArr8 = A06;
                        strArr8[2] = "qw7ApZ7ipfHbwj";
                        strArr8[6] = "LJsV5SavG50yIX";
                        if (z) {
                            ((InterstitialAdExtendedListener) this.A02.A6o()).onInterstitialActivityDestroyed();
                        }
                        if (this.A02.A04() != null) {
                        }
                    }
                    break;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.instagram.common.viewpoint.core.OQ
    public final void AJn(boolean z) {
        this.A00 = z;
    }
}
