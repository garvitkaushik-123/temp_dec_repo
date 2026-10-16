package com.instagram.common.viewpoint.core;

import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.media3.extractor.ts.TsExtractor;
import java.util.Arrays;
import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.io, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2052io implements OE {
    public static byte[] A05;
    public static String[] A06 = {"LqS4Vpkhy9E", "ge1EwIuJY0TovlYE8lSK4ibgoBpAWn9a", "g9aMV", "tM0yo6k6wg7fwB8A5Xyw1gAw", "QSFbFVun0ml7C8TY77Vqi1TYUccnWCEL", "t0vPMbYvCUeZJjWwsMbVoEbKc6G6LcPD", "iAyfyMUWIOpY9gjOpihEXzDIF", "NOfvqhzewpei8jQqPEPmMqHVwiKNDwof"};
    public AdError A00;
    public OD A01 = OD.A02;
    public OD A02 = OD.A02;
    public final AbstractC2049ik A03;
    public final C1929gi A04;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 33);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {125, 41, 50, 125, Ascii.FF, 2, 123, 77, 87, 2, 65, 67, 76, 2, 65, 74, 67, 76, 69, 71, 2, 107, 76, 86, 71, 69, 80, 67, 86, 75, 77, 76, 2, 103, 80, 80, 77, 80, 2, 79, 77, 70, 71, 2, SignedBytes.MAX_POWER_OF_TWO, 91, 2, 81, 71, 86, 86, 75, 76, 69, 2, 99, 70, 113, 71, 86, 86, 75, 76, 69, 81, Ascii.FF, 81, 71, 86, 107, 76, 86, 71, 69, 80, 67, 86, 75, 77, 76, 103, 80, 80, 77, 80, 111, 77, 70, 71, 10, Ascii.VT, 37, 33, 34, Ascii.SYN, 7, 10, 6, Ascii.CR, 0, 6, 45, 6, Ascii.ETB, Ascii.DC4, Ascii.FF, 17, 8, 65, 117, 104, 106, 39, 90, Byte.MAX_VALUE, 98, 99, 106, 45, 100, 99, 121, 104, Byte.MAX_VALUE, 99, 108, 97, 45, 121, Byte.MAX_VALUE, 108, 99, 126, 100, 121, 100, 98, 99, 35, 125, 108, 117, 106, 105, 103, 98, 46, 47, 121, 98, 101, 125, 34, 35, 120, 100, 109, 120, 44, 101, Byte.MAX_VALUE, 44, 109, 96, 126, 105, 109, 104, 117, 44, SignedBytes.MAX_POWER_OF_TWO, 67, 77, 72, 69, 66, 75, 32, 44, SignedBytes.MAX_POWER_OF_TWO, 67, 77, 72, 73, 72, 44, 99, 126, 44, 95, 68, 67, 91, 69, 66, 75, 123, 103, 110, 123, 47, 102, 124, 47, 110, 99, 125, 106, 110, 107, 118, 47, 92, 71, SignedBytes.MAX_POWER_OF_TWO, 88, 70, 65, 72, 121, 101, 108, 121, 45, 100, 126, 45, 99, 98, 121, 45, 65, 66, 76, 73, 72, 73};
        String[] strArr = A06;
        if (strArr[1].charAt(28) == strArr[5].charAt(28)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[1] = "uHXyGv91YS5AZybwuzmh7pK9ZkTxCxly";
        strArr2[5] = "aSclBZwoH94XlBt4xX3FAXD0bzJVnGEs";
        A05 = bArr;
    }

    static {
        A01();
    }

    public C2052io(C1929gi c1929gi, AbstractC2049ik abstractC2049ik) {
        this.A04 = c1929gi;
        this.A03 = abstractC2049ik;
    }

    private void A02(OD od, OD od2) {
        String A00 = A00(113, 26, 44);
        StringBuilder sb = new StringBuilder();
        String errorTitle = A00(108, 5, 38);
        StringBuilder append = sb.append(errorTitle).append(od);
        String errorTitle2 = A00(0, 4, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE);
        String sb2 = append.append(errorTitle2).append(od2).toString();
        InterfaceC1340Tc A08 = this.A04.A08();
        int i = AbstractC1341Td.A0e;
        C1342Te c1342Te = new C1342Te(A00, sb2);
        String errorTitle3 = A00(TsExtractor.TS_STREAM_TYPE_DTS_UHD, 3, 61);
        A08.ABC(errorTitle3, i, c1342Te);
        String errorTitle4 = A00 + ' ' + sb2;
        this.A04.A0F().ALA(errorTitle4);
    }

    private void A03(String str, String str2, boolean z) {
        AdSettings.IntegrationErrorMode A00 = OA.A00(this.A04);
        String format = String.format(Locale.US, AdErrorType.INCORRECT_API_CALL_ERROR.getDefaultErrorMessage(), str, str2);
        String A002 = A00(TsExtractor.TS_STREAM_TYPE_DTS_UHD, 3, 61);
        String A003 = A00(91, 17, 66);
        if (!z) {
            Log.e(A003, format);
            this.A04.A08().ABC(A002, AbstractC1341Td.A0c, new C1342Te(format));
            this.A04.A0F().AL9(format);
            return;
        }
        switch (OC.A00[A00.ordinal()]) {
            case 1:
                String errorMessage = format + A00(4, 87, 3);
                throw new OF(errorMessage);
            case 2:
                this.A03.A08();
                this.A03.A0B(10, AdErrorType.INCORRECT_STATE_ERROR, format);
                this.A04.A0F().AL9(format);
                Log.e(A003, format);
                this.A04.A08().ABC(A002, AbstractC1341Td.A0c, new C1342Te(format));
                break;
        }
        Log.e(A003, format);
    }

    @Override // com.instagram.common.viewpoint.core.OE
    public final boolean A6U() {
        boolean z = (this.A01 == OD.A02 || this.A01 == OD.A04) && this.A02 != OD.A07;
        if (z) {
            this.A01 = OD.A06;
        } else {
            A03(A00(142, 6, 39), A00(154, 42, 45), false);
        }
        return !z;
    }

    @Override // com.instagram.common.viewpoint.core.OE
    public final boolean A6V() {
        if (this.A01 == OD.A04 && this.A00 != null && this.A00.getErrorCode() == 2008) {
            this.A04.A0F().AI5();
            this.A03.A0B(10, AdErrorType.AD_PRESENTATION_ERROR, null);
            return true;
        }
        OD od = this.A01;
        OD od2 = OD.A05;
        String[] strArr = A06;
        if (strArr[6].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[4] = "mF60z106z8KVykzxhCmjg96dV72kpnud";
        strArr2[7] = "JHGcNRxcSq72OhujKZnAiyvPQwA3qgql";
        boolean z = od == od2 && (this.A02 != OD.A07 || C1379Up.A0i(this.A04));
        if (z) {
            this.A01 = OD.A02;
            this.A02 = OD.A07;
        } else {
            OD od3 = this.A01;
            OD od4 = OD.A05;
            String A00 = A00(148, 6, 43);
            if (od3 != od4) {
                A03(A00, A00(Sdk.SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, 18, 44), true);
            } else {
                A03(A00, A00(196, 23, 46), false);
            }
        }
        return !z;
    }

    @Override // com.instagram.common.viewpoint.core.OE
    public final OD A6p() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.OE
    public final OD A6q() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.OE
    public final void AAw() {
        this.A01 = OD.A06;
    }

    @Override // com.instagram.common.viewpoint.core.OE
    public final void AJM(OD od) {
        this.A01 = od;
        this.A02 = od;
    }

    @Override // com.instagram.common.viewpoint.core.OE
    public final void AJR(AdError adError) {
        this.A01 = OD.A04;
        this.A02 = OD.A04;
        this.A00 = adError;
    }

    @Override // com.instagram.common.viewpoint.core.OE
    public final void AJW() {
        if (this.A01 != OD.A06) {
            A02(this.A01, OD.A05);
        }
        OD od = OD.A05;
        String[] strArr = A06;
        if (strArr[4].charAt(13) == strArr[7].charAt(13)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[6] = "0CQ8O9HdNp0eBnIGd0pIqA2Cb";
        strArr2[2] = "A9QPt";
        this.A01 = od;
    }

    @Override // com.instagram.common.viewpoint.core.OE
    public final void AJm() {
        if (this.A02 != OD.A07) {
            A02(this.A01, OD.A08);
        }
        this.A02 = OD.A08;
    }
}
