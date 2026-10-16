package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.api.BuildConfigApi;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.gw, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1943gw {
    public static byte[] A02;
    public static String[] A03 = {"lJVeP2IR7ua2", "jEDUnDrnc1QBGJRRXgI1zLNGeQAVlRB5", "4J1evWwVBwsv6j2jE3cxdE8l4EvJqUWx", "hbOpPbm2Lvz8WBi4M4lcAmyYP20RrxkZ", "42MJRsHMkke9vUn", "N1ePHibZvm11p1YoQp9n3cvTSohhnC86", "pzMHmXStxFGPpObuVYX1kVlrzXN", "JuJmyZjKd3poC4Sz8wRazc2gW2"};
    public static final String A04;
    public final SR A00;
    public final C1335Sx A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 45);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{81, 115, 100, 109, 110, 96, 101, 104, 111, 102, 33, 36, 101, 33, 96, 114, 114, 100, 117, 114, 60, Ascii.RS, 9, 0, 3, Ascii.CR, 8, 5, 2, Ascii.VT, 76, 5, 1, Ascii.CR, Ascii.VT, 9, 86, 76, 73, Ascii.US, 118, 84, 67, 74, 73, 71, 66, 79, 72, 65, 6, 75, 71, 84, 77, 83, 86, Ascii.FS, 6, 3, 85, 86, 116, 99, 106, 105, 103, 98, 111, 104, 97, 38, 112, 111, 98, 99, 105, 60, 38, 35, 117, 50, 101, 48, 48, 96, 97, 98, 98, 123, 52, 110, 101, 100, 123, 103, 103, 51, 111, 123, 55, 100, 55, 101, 123, 100, 55, 100, 55, 51, 100, 50, 52, 53, 53, 51, 98, 55, 53, 34, 33, 34, 51, 36, 47, 106, 113, 116, 113, 112, 104, 113};
    }

    static {
        A02();
        A04 = C1943gw.class.getSimpleName();
    }

    public C1943gw(SR sr, C1925ge c1925ge) {
        this.A00 = sr;
        this.A00.A40(new C1945gy(this));
        this.A01 = new C1335Sx(c1925ge);
        A01();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01() {
        if (BuildConfigApi.isDebug()) {
            Locale locale = Locale.US;
            SR sr = this.A00;
            if (A03[2].charAt(7) != 'V') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[7] = "B9WAOcp3zNbG4sQr12bKZPkRro";
            strArr[6] = "6ENVq9NVFWRAnG6rhAVuoXedHs5";
            String.format(locale, A00(0, 20, 44), Integer.valueOf(sr.A6x().size()));
        }
        for (SU su : this.A00.A6x()) {
            switch (SQ.A00[su.A9O().ordinal()]) {
                case 1:
                    A04(su.getUrl());
                    break;
                case 2:
                    A06(su.getUrl());
                    break;
                case 3:
                    A05(su.getUrl());
                    break;
            }
        }
        this.A01.A0X(new C1944gx(this), new C1328Sq(A00(81, 36, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), A00(Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 7, 50)));
    }

    private void A04(String str) {
        if (BuildConfigApi.isDebug()) {
            String.format(Locale.US, A00(20, 20, 65), str);
        }
        C1333Sv c1333Sv = new C1333Sv(str, -1, -1, A00(81, 36, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), A00(Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 7, 50));
        c1333Sv.A02 = A00(Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, 8, 106);
        this.A01.A0c(c1333Sv);
    }

    private void A05(String str) {
        if (BuildConfigApi.isDebug()) {
            String.format(Locale.US, A00(40, 21, 11), str);
        }
        C1331St c1331St = new C1331St(str, A00(81, 36, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), A00(Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 7, 50));
        c1331St.A04 = true;
        c1331St.A02 = A00(Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, 8, 106);
        this.A01.A0Y(c1331St);
    }

    private void A06(String str) {
        if (BuildConfigApi.isDebug()) {
            String.format(Locale.US, A00(61, 20, 43), str);
        }
        C1331St c1331St = new C1331St(str, A00(81, 36, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), A00(Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 7, 50));
        c1331St.A04 = false;
        c1331St.A02 = A00(Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, 8, 106);
        this.A01.A0b(c1331St);
    }
}
