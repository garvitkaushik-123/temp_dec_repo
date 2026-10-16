package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.iy, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2062iy implements NC {
    public static byte[] A02;
    public final /* synthetic */ C08027j A00;
    public final /* synthetic */ Runnable A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 58);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{66, 70, 66, Ascii.NAK, Ascii.NAK, 68, 19, 17, 77, 104, 109, 124, 120, 105, 126, 44, 101, Byte.MAX_VALUE, 44, 98, 121, 96, 96, 44, 99, 98, 44, 96, 99, 109, 104, 69, 98, 120, 105, 126, Byte.MAX_VALUE, 120, 101, 120, 101, 109, 96, 77, 104, 59, Ascii.FS, 6, Ascii.ETB, 0, 1, 6, Ascii.ESC, 6, Ascii.ESC, 19, Ascii.RS, 82, Ascii.ESC, Ascii.US, 2, 0, Ascii.ETB, 1, 1, Ascii.ESC, Ascii.GS, Ascii.FS, 82, Ascii.DC4, Ascii.ESC, 0, Ascii.ETB, Ascii.SYN, 63, 48, 1, 63, Base64.padSymbol, 42, 55, 40, 55, 42, 39, 101, 106, 96, 118, 107, 109, 96, 42, 109, 106, 112, 97, 106, 112, 42, 101, 103, 112, 109, 107, 106, 42, 82, 77, 65, 83, 34, 51, 42, 109, 108, 75, 108, 118, 103, 112, 113, 118, 107, 118, 107, 99, 110, 78, 109, 101, 101, 107, 108, 101, 75, 111, 114, 112, 103, 113, 113, 107, 109, 108};
    }

    public C2062iy(C08027j c08027j, Runnable runnable) {
        this.A00 = c08027j;
        this.A01 = runnable;
    }

    @Override // com.instagram.common.viewpoint.core.NC
    public final void AEC(C2116jz c2116jz, String str, boolean z) {
        this.A00.A07.A0C();
        boolean z2 = !TextUtils.isEmpty(str);
        if (z && z2) {
            try {
                Intent intent = new Intent(A00(85, 26, 62));
                intent.setData(XB.A00(str));
                C1433Wu.A0D(this.A00.A0B, intent);
            } catch (C1431Ws e) {
                Throwable cause = e.getCause();
                Throwable th = e;
                if (cause != null) {
                    th = e.getCause();
                }
                this.A00.A0B.A08().ABC(A00(74, 11, 100), AbstractC1341Td.A04, new C1342Te(th));
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.NC
    public final void AED(C2116jz c2116jz) {
        this.A00.A07.A04();
    }

    @Override // com.instagram.common.viewpoint.core.NC
    public final void AEE(C2116jz c2116jz) {
        this.A00.A07.A05();
    }

    @Override // com.instagram.common.viewpoint.core.NC
    public final void AEF(C2116jz c2116jz) {
        if (c2116jz != this.A00.A00) {
            return;
        }
        if (c2116jz == null) {
            this.A00.A0B.A08().ABC(A00(111, 3, Sdk.SDKError.Reason.TPAT_ERROR_VALUE), AbstractC1341Td.A0X, new C1342Te(A00(8, 37, 54)));
            AEG(c2116jz, AdError.internalError(2004));
            return;
        }
        this.A00.A0H().removeCallbacks(this.A01);
        this.A00.A01 = c2116jz;
        this.A00.A0L();
        this.A00.A07.A0F(c2116jz);
    }

    @Override // com.instagram.common.viewpoint.core.NC
    public final void AEG(C2116jz c2116jz, AdError adError) {
        if (c2116jz != this.A00.A00) {
            return;
        }
        this.A00.A0H().removeCallbacks(this.A01);
        this.A00.A0Q(c2116jz);
        this.A00.A0B.A0F().A5g(adError.getErrorCode(), adError.getErrorMessage());
        this.A00.A07.A0G(new C1401Vm(adError.getErrorCode(), adError.getErrorMessage()));
    }

    @Override // com.instagram.common.viewpoint.core.NC
    public final void AEH(C2116jz c2116jz) {
        AbstractC1412Vy.A05(A00(114, 31, 56), A00(45, 29, 72), A00(0, 8, 77));
        this.A00.A07.A0D();
        this.A00.A0O();
    }

    @Override // com.instagram.common.viewpoint.core.NC
    public final void AEI() {
        this.A00.A07.A08();
    }

    @Override // com.instagram.common.viewpoint.core.NC
    public final void AEJ() {
        this.A00.A07.A06();
    }

    @Override // com.instagram.common.viewpoint.core.NC
    public final void AEK() {
        this.A00.A07.A07();
    }

    @Override // com.instagram.common.viewpoint.core.NC
    public final void onInterstitialActivityDestroyed() {
        this.A00.A07.A02();
    }
}
