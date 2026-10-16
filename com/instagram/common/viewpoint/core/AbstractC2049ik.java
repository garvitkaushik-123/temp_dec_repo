package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.ik, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2049ik implements OW {
    public static byte[] A06;
    public final OE A00;
    public final OL A01;
    public final C1929gi A02;
    public final Handler A03;
    public final String A04;
    public final OQ A05;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 70);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{-104, -85, -92, -102, -94, -101, -75, -101, -82, -86, -88, -105, -87, -75, -95, -101, -81, -25, -20, -14, -3, -29, -16, -16, -19, -16, -3, -31, -19, -30, -29, -3, -23, -29, -9, -6, -5, -7, 6, -24, -21, 6, -16, -21, 6, -14, -20, 0, Ascii.NAK, Ascii.SYN, Ascii.DC4, 33, 7, Ascii.DC4, Ascii.DC4, 17, Ascii.DC4, 33, Ascii.SI, 7, Ascii.NAK, Ascii.NAK, 3, 9, 7, 33, Ascii.CR, 7, Ascii.ESC};
    }

    public abstract void A08();

    public abstract void A09();

    public abstract void A0D(boolean z);

    public AbstractC2049ik(C1929gi c1929gi, String str, OR or) {
        this.A02 = c1929gi;
        this.A04 = str;
        DynamicLoaderFactory.makeLoader(this.A02).getInitApi().onAdLoadInvoked(this.A02);
        this.A00 = new C2052io(c1929gi, this);
        this.A01 = new OL(c1929gi, this);
        this.A03 = new Handler(Looper.getMainLooper());
        this.A05 = or.A5S(this.A00, this, this.A01);
    }

    public final OE A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A04;
    }

    public final void A05() {
        if (this.A01.A01) {
            this.A02.A0F().AI0();
            A06();
        } else {
            this.A02.A0F().AHs();
            this.A01.A02 = true;
            this.A01.A0E(AbstractC1382Us.A02.get());
        }
    }

    public final void A06() {
        this.A02.A0F().AI6();
        if (!this.A01.A0F(this.A05.A8P(), this.A05.A5R(this.A04))) {
            A09();
            this.A02.A0F().AHy();
        }
    }

    public final void A07() {
        if (!C1379Up.A0u(this.A02)) {
            return;
        }
        Y4.A00(new C2050il(this));
    }

    public final void A0A(int i) {
        this.A01.A0D(this.A02, i);
    }

    public final void A0B(int i, AdErrorType adErrorType, String str) {
        Bundle bundle = new Bundle();
        String A01 = A01(48, 21, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE);
        if (str != null) {
            bundle.putString(A01, str);
        } else {
            bundle.putString(A01, adErrorType.getDefaultErrorMessage());
        }
        bundle.putInt(A01(17, 18, 88), adErrorType.getErrorCode());
        AEs(i, this.A04, bundle);
    }

    public final void A0C(Message message) {
        this.A05.A9j(message);
    }

    @Override // com.instagram.common.viewpoint.core.OW
    public final void AEs(int i, String str, Bundle bundle) {
        Message obtain = Message.obtain((Handler) null, i);
        obtain.getData().putString(A01(35, 13, 97), str);
        if (bundle != null) {
            obtain.getData().putBundle(A01(0, 17, 16), bundle);
        }
        Runnable callbackApiRunnable = new C2051im(this, obtain);
        this.A03.post(callbackApiRunnable);
    }
}
