package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.protocol.AdErrorType;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import org.json.JSONException;

/* renamed from: com.facebook.ads.redexgen.X.Sl, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1323Sl implements InterfaceC1881fw {
    public static byte[] A03;
    public static String[] A04 = {"vUQacvUb1jgaOB1nXCILUaEr4ItZ5QEs", "N", "ozPzI", "iemFS7qx3ItQSdDQeBrvuJ9y9CMkfIqY", "EwROMxnfRd6F7268i4EpvPtVg3hQf", "a", "qVu8", "3RxrE6NsEsLt8TXu"};
    public final /* synthetic */ long A00;
    public final /* synthetic */ WA A01;
    public final /* synthetic */ WD A02;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 120);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{85, 81, 3, 85, 87, 7, 80, 3, 60, 111, 51, 63, 51, 63, 107, 60, 44, 53, 41, 40, 35, Ascii.RS, 5, 3, Ascii.SYN, Ascii.DC2, Ascii.SI, 9, 8, 92, 70, 78, 120, 111, 107, 120, 111, Base64.padSymbol, 120, 111, 111, 114, 111, Base64.padSymbol, 114, 126, 126, 104, 111, 111, 120, 121, 124, 74, 93, 89, 74, 93, Ascii.SI, 93, 74, 95, 67, 70, 74, 75, Ascii.SI, 92, 90, 76, 76, 74, 92, 92, 73, 90, 67, 67, 86, 63, 62, 19, 63, Base64.padSymbol, 32, 60, 53, 36, 53, Ascii.DLE, 17, 58, Ascii.CR, Ascii.CR, Ascii.DLE, Ascii.CR};
    }

    static {
        A01();
    }

    public C1323Sl(WD wd, WA wa, long j) {
        this.A02 = wd;
        this.A01 = wa;
        this.A00 = j;
    }

    private final void A02(C1893g8 c1893g8) {
        C1929gi c1929gi;
        long j;
        C1929gi c1929gi2;
        long j2;
        WE we;
        C1929gi c1929gi3;
        C1929gi c1929gi4;
        long j3;
        W9.A06(this.A01);
        try {
            InterfaceC1879fu response = c1893g8.A00();
            if (response != null) {
                String A73 = response.A73();
                we = this.A02.A06;
                c1929gi3 = this.A02.A05;
                WG serverResponse = we.A07(c1929gi3, A73, this.A00);
                if (serverResponse.A01() == WF.A03) {
                    R4 r4 = (R4) serverResponse;
                    String A042 = r4.A04();
                    AdErrorType adErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(r4.A03(), AdErrorType.ERROR_MESSAGE);
                    if (A042 != null) {
                        A73 = A042;
                    }
                    c1929gi4 = this.A02.A05;
                    InterfaceC1155Lt A0F = c1929gi4.A0F();
                    j3 = this.A02.A01;
                    A0F.A3W(Y1.A01(j3), adErrorTypeFromCode.getErrorCode(), A73, adErrorTypeFromCode.isPublicError());
                    this.A02.A0E(C1401Vm.A01(adErrorTypeFromCode, A73));
                    return;
                }
            }
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String message = c1893g8.getMessage();
            c1929gi2 = this.A02.A05;
            InterfaceC1155Lt A0F2 = c1929gi2.A0F();
            j2 = this.A02.A01;
            long A01 = Y1.A01(j2);
            int errorCode = adErrorType.getErrorCode();
            boolean isPublicError = adErrorType.isPublicError();
            if (A04[2].length() == 29) {
                throw new RuntimeException();
            }
            A04[4] = "NZ18w";
            A0F2.A3W(A01, errorCode, message, isPublicError);
            this.A02.A0E(C1401Vm.A01(adErrorType, message));
        } catch (JSONException e) {
            AdErrorType adErrorType2 = AdErrorType.NETWORK_ERROR;
            String errorMessage = c1893g8.getMessage();
            c1929gi = this.A02.A05;
            InterfaceC1155Lt A0F3 = c1929gi.A0F();
            j = this.A02.A01;
            A0F3.A3W(Y1.A01(j), adErrorType2.getErrorCode(), A00(16, 15, 30) + e.getMessage(), adErrorType2.isPublicError());
            this.A02.A0E(C1401Vm.A01(adErrorType2, errorMessage));
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1881fw
    public final void ADR(InterfaceC1879fu interfaceC1879fu) {
        C1929gi c1929gi;
        C1929gi c1929gi2;
        AbstractC1412Vy.A05(A00(79, 10, 40), A00(52, 27, 87), A00(8, 8, 114));
        if (interfaceC1879fu != null) {
            String A73 = interfaceC1879fu.A73();
            c1929gi = this.A02.A05;
            int A02 = C1379Up.A02(c1929gi);
            String[] strArr = A04;
            String str = strArr[5];
            String response = strArr[1];
            if (str.length() != response.length()) {
                throw new RuntimeException();
            }
            A04[2] = "kblvpkFa8oUK1ItVGqcsW93nH";
            if (A02 > 0) {
                c1929gi2 = this.A02.A05;
                C1425Wl.A00(c1929gi2).A0C(A73);
            }
            W9.A06(this.A01);
            this.A02.A0O(A73, this.A00, this.A01);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1881fw
    public final void ADq(Exception exc) {
        C1929gi c1929gi;
        long j;
        AbstractC1412Vy.A05(A00(89, 7, 7), A00(31, 21, 101), A00(0, 8, 30));
        if (C1893g8.class.equals(exc.getClass())) {
            A02((C1893g8) exc);
            return;
        }
        AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
        String errorMessage = exc.getMessage();
        c1929gi = this.A02.A05;
        InterfaceC1155Lt A0F = c1929gi.A0F();
        j = this.A02.A01;
        A0F.A3W(Y1.A01(j), adErrorType.getErrorCode(), errorMessage, adErrorType.isPublicError());
        this.A02.A0E(C1401Vm.A01(adErrorType, errorMessage));
    }
}
