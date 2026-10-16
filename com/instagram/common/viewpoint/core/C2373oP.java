package com.instagram.common.viewpoint.core;

import android.os.SystemClock;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.oP, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2373oP implements AnonymousClass93 {
    public static byte[] A01;
    public static String[] A02 = {"JE7C4PJjP7BCbZqkJpMMyURXZ5h", "iMYF6XNZz1LBnq9Lsd18aPb3vu2", "XxqNLC6c7RSVqgSJXO5oI", "nEpRStmmyFjBR5hyZRShRQxXaXf0Mj7x", "WMevU6o4a2paeBy7iKLxLT9X", "1yBfwy19", "IbfL1f4elDnhfhlOaFmHA7", "3K7V2NpliX3hv5M7KS"};
    public final /* synthetic */ C2370oM A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {SignedBytes.MAX_POWER_OF_TWO, 76, 70, 103, 100, 99, 119, 110, 118, 67, 119, 102, 107, 109, 81, 107, 108, 105, Ascii.CAN, 54, 63, 62, 35, 56, 63, 54, 113, 56, 60, 33, 62, 34, 34, 56, 51, Base64.padSymbol, 40, 113, Base64.padSymbol, 48, 35, 54, 52, 113, 48, 36, 53, 56, 62, 113, Base64.padSymbol, 48, 37, 52, 63, 50, 40, 107, 113, 98, 65, 68, 67, 88, 94, 68, 66, 17, 80, 68, 85, 88, 94, 17, 69, 88, 92, 84, 66, 69, 80, 92, 65, 17, Ascii.EM, 87, 67, 80, 92, 84, 17, 65, 94, 66, 88, 69, 88, 94, 95, 17, 92, 88, 66, 92, 80, 69, 82, 89, Ascii.CAN, Ascii.VT, 17, 102, 69, SignedBytes.MAX_POWER_OF_TWO, 71, 92, 90, SignedBytes.MAX_POWER_OF_TWO, 70, Ascii.NAK, 84, SignedBytes.MAX_POWER_OF_TWO, 81, 92, 90, Ascii.NAK, 65, 92, 88, 80, 70, 65, 84, 88, 69, Ascii.NAK, Ascii.GS, 70, 76, 70, 65, 80, 88, Ascii.NAK, 86, 89, 90, 86, 94, Ascii.NAK, 88, 92, 70, 88, 84, 65, 86, 93, Ascii.FS, Ascii.SI, Ascii.NAK};
        if (A02[4].length() != 24) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[2] = "crOuuTwIIsvqp0CyO4zKH";
        strArr[6] = "QvBSziwTMADuiMqU3qgYIx";
        A01 = bArr;
    }

    static {
        A01();
    }

    public C2373oP(C2370oM c2370oM) {
        this.A00 = c2370oM;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass93
    public final void AEM(long j) {
        AbstractC07214g.A07(A00(2, 16, 116), A00(18, 41, 39) + j);
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass93
    public final void AFN(long j) {
        InterfaceC08378v interfaceC08378v;
        InterfaceC08378v interfaceC08378v2;
        interfaceC08378v = this.A00.A0I;
        if (interfaceC08378v != null) {
            C2370oM c2370oM = this.A00;
            String[] strArr = A02;
            if (strArr[1].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[2] = "XUD65QsQyQCwJDnhFrO8y";
            strArr2[6] = "L1DcP3KlVDNfGhVI0cZDzs";
            interfaceC08378v2 = c2370oM.A0I;
            interfaceC08378v2.AFN(j);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass93
    public final void AFP(long j, long j2, long j3, long j4) {
        long A06;
        long A07;
        StringBuilder append = new StringBuilder().append(A00(59, 52, 71)).append(j);
        String A00 = A00(0, 2, 26);
        StringBuilder append2 = append.append(A00).append(j2).append(A00).append(j3).append(A00).append(j4).append(A00);
        A06 = this.A00.A06();
        StringBuilder append3 = append2.append(A06).append(A00);
        A07 = this.A00.A07();
        String sb = append3.append(A07).toString();
        if (!C2370oM.A0v) {
            String message = A00(2, 16, 116);
            AbstractC07214g.A07(message, sb);
            return;
        }
        throw new C9I(sb);
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass93
    public final void AG9(long j, long j2, long j3, long j4) {
        long A06;
        long A07;
        StringBuilder append = new StringBuilder().append(A00(111, 50, 67)).append(j);
        String A00 = A00(0, 2, 26);
        StringBuilder append2 = append.append(A00).append(j2).append(A00).append(j3).append(A00).append(j4).append(A00);
        A06 = this.A00.A06();
        StringBuilder append3 = append2.append(A06).append(A00);
        A07 = this.A00.A07();
        String sb = append3.append(A07).toString();
        if (!C2370oM.A0v) {
            String message = A00(2, 16, 116);
            AbstractC07214g.A07(message, sb);
            return;
        }
        throw new C9I(sb);
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass93
    public final void AGI(int i, long j) {
        InterfaceC08378v interfaceC08378v;
        long j2;
        InterfaceC08378v interfaceC08378v2;
        interfaceC08378v = this.A00.A0I;
        if (interfaceC08378v != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            j2 = this.A00.A07;
            long j3 = elapsedRealtime - j2;
            interfaceC08378v2 = this.A00.A0I;
            interfaceC08378v2.AGJ(i, j, j3);
        }
    }
}
