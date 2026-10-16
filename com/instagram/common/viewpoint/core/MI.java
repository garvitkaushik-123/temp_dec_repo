package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public final class MI implements InterfaceC1471Yi {
    public static byte[] A0D;
    public int A00;
    public C0976Eu A01;
    public C4L A02;
    public String A03;
    public final C1929gi A04;
    public final VA A05;
    public final InterfaceC1470Yh A06;
    public final ZP A07;
    public final C0966Ek A08;
    public final E2 A0C = new E2() { // from class: com.facebook.ads.redexgen.X.6d
        public static byte[] A01;

        static {
            A01();
        }

        public static String A00(int i, int i2, int i3) {
            byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
            for (int i4 = 0; i4 < copyOfRange.length; i4++) {
                copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 58);
            }
            return new String(copyOfRange);
        }

        public static void A01() {
            A01 = new byte[]{115, 108, 97, 96, 106, 76, 107, 113, 96, 119, 118, 113, 108, 113, 100, 105, SignedBytes.MAX_POWER_OF_TWO, 115, 96, 107, 113};
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.instagram.common.viewpoint.core.UN
        /* renamed from: A02, reason: merged with bridge method [inline-methods] */
        public final void A03(E3 e3) {
            InterfaceC1470Yh interfaceC1470Yh;
            interfaceC1470Yh = MI.this.A06;
            interfaceC1470Yh.A4k(A00(0, 21, 63), e3);
        }
    };
    public final E4 A0B = new E4() { // from class: com.facebook.ads.redexgen.X.6a
        public static byte[] A01;

        static {
            A01();
        }

        public static String A00(int i, int i2, int i3) {
            byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
            for (int i4 = 0; i4 < copyOfRange.length; i4++) {
                copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 120);
            }
            return new String(copyOfRange);
        }

        public static void A01() {
            A01 = new byte[]{38, 57, 52, 53, 63, Ascii.EM, 62, 36, 53, 34, 35, 36, 57, 36, 49, 60, Ascii.NAK, 38, 53, 62, 36};
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.instagram.common.viewpoint.core.UN
        /* renamed from: A02, reason: merged with bridge method [inline-methods] */
        public final void A03(C4B c4b) {
            InterfaceC1470Yh interfaceC1470Yh;
            interfaceC1470Yh = MI.this.A06;
            interfaceC1470Yh.A4k(A00(0, 21, 40), c4b);
        }
    };
    public final EA A09 = new EA() { // from class: com.facebook.ads.redexgen.X.6Z
        public static byte[] A01;
        public static String[] A02 = {"cVYzzU3WDwilAiB6lBwH", "ltb11yKnDLf", "qD1l7ddw57WScFbFlpW6gLQQ4LJZYMm4", "7tmDLtuP1dSUokfmYRKMMhnjp75BOUEQ", "O1T", "OUAaXGhWo5xW6BfvCbr", "NPW6PnCzVK8iTd9b27h5", "ykk8Miz3Z2gvnB5Rb4Sxgn912BIo"};

        public static String A00(int i, int i2, int i3) {
            byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
            for (int i4 = 0; i4 < copyOfRange.length; i4++) {
                int i5 = copyOfRange[i4] ^ i3;
                if (A02[2].charAt(8) != '5') {
                    throw new RuntimeException();
                }
                A02[5] = "7KI0j9KfVtSFY3dF";
                copyOfRange[i4] = (byte) (i5 ^ 70);
            }
            return new String(copyOfRange);
        }

        public static void A01() {
            A01 = new byte[]{3, Ascii.FS, 17, Ascii.DLE, Ascii.SUB, 60, Ascii.ESC, 1, Ascii.DLE, 7, 6, 1, Ascii.FS, 1, Ascii.DC4, Ascii.EM, 48, 3, Ascii.DLE, Ascii.ESC, 1};
        }

        static {
            A01();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.instagram.common.viewpoint.core.UN
        /* renamed from: A02, reason: merged with bridge method [inline-methods] */
        public final void A03(C4K c4k) {
            InterfaceC1470Yh interfaceC1470Yh;
            interfaceC1470Yh = MI.this.A06;
            interfaceC1470Yh.A4k(A00(0, 21, 51), c4k);
        }
    };
    public final E8 A0A = new E8() { // from class: com.facebook.ads.redexgen.X.6Y
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.instagram.common.viewpoint.core.UN
        /* renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(E9 e9) {
            ZP zp;
            zp = MI.this.A07;
            zp.ADv();
        }
    };

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 102);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A0D = new byte[]{44, 56, 57, 34, Base64.padSymbol, 33, 44, 52, 122, 117, 112, 124, 119, 109, 77, 118, 114, 124, 119, Ascii.DC4, Ascii.DC2, 4, 47, 0, Ascii.NAK, 8, Ascii.ETB, 4, 34, Ascii.NAK, 0, 35, Ascii.DC4, Ascii.NAK, Ascii.NAK, Ascii.SO, Ascii.SI, 55, 40, 37, 36, 46, 8, 47, 53, 36, 51, 50, 53, 40, 53, 32, 45, 4, 55, 36, 47, 53, 81, 78, 67, 66, 72, 107, 72, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 66, 85, 116, 107, 102, 103, 109, 79, 82, 70, 103, 120, 117, 116, 126, 66, 116, 116, 122, 69, 120, 124, 116, 63, 32, 45, 44, 38, Ascii.FS, Ascii.ESC, 5};
    }

    public MI(C1929gi c1929gi, ZP zp, VA va, InterfaceC1470Yh interfaceC1470Yh) {
        this.A04 = c1929gi;
        this.A05 = va;
        this.A07 = zp;
        this.A08 = new C0966Ek(c1929gi);
        this.A08.A0f(new C07053q(c1929gi));
        this.A08.getEventBus().A03(this.A0C, this.A0B, this.A09, this.A0A);
        this.A06 = interfaceC1470Yh;
        this.A08.setIsFullScreen(true);
        this.A08.setVolume(1.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        interfaceC1470Yh.A45(this.A08, layoutParams);
        C1478Yp closeButton = new C1478Yp(c1929gi);
        closeButton.setOnClickListener(new ZN(this));
        RelativeLayout.LayoutParams params = closeButton.getDefaultLayoutParams();
        interfaceC1470Yh.A45(closeButton, params);
    }

    public final void A04(int i) {
        this.A08.setVideoProgressReportIntervalMs(i);
    }

    public final void A05(View view) {
        this.A08.setControlsAnchorView(view);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void AAu(Intent intent, Bundle bundle, C1291Re c1291Re) {
        String ctaText = A02(8, 11, 127);
        if (bundle == null) {
            this.A03 = intent.getStringExtra(ctaText);
        } else {
            this.A03 = bundle.getString(ctaText);
        }
        String stringExtra = intent.getStringExtra(A02(19, 18, 7));
        if (stringExtra != null && !stringExtra.isEmpty()) {
            C1765e3 c1765e3 = new C1765e3(this.A04, stringExtra);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int i = (int) (16.0f * XX.A02);
            layoutParams.setMargins(i, i, i, i);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            c1765e3.setOnClickListener(new ZO(this));
            this.A06.A45(c1765e3, layoutParams);
        }
        this.A00 = intent.getIntExtra(A02(77, 13, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), 0);
        this.A02 = new C4L(this.A04, this.A05, this.A08, this.A03, intent.getBundleExtra(A02(58, 11, 65)), null);
        if (C1379Up.A20(this.A04)) {
            this.A01 = new C0976Eu(this.A04, this.A05, this.A08, this.A03, false, this.A02, null);
        } else {
            this.A01 = null;
        }
        this.A08.setVideoMPD(intent.getStringExtra(A02(69, 8, 100)));
        this.A08.setVideoURI(intent.getStringExtra(A02(90, 8, 47)));
        if (this.A00 > 0) {
            this.A08.A0a(this.A00);
        }
        if (intent.getBooleanExtra(A02(0, 8, 43), false)) {
            this.A08.A0e(EnumC1816et.A04, 17);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void AFA(boolean z) {
        this.A06.A4k(A02(37, 21, 39), new E6());
        this.A08.A0X();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void AFi(boolean z) {
        this.A06.A4k(A02(37, 21, 39), new E5());
        if (!this.A08.A0o()) {
            this.A08.A0e(EnumC1816et.A04, 18);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void AIv(Bundle bundle) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final String getCurrentClientToken() {
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void onDestroy() {
        this.A06.A4k(A02(37, 21, 39), new C0954Dy(this.A00, this.A08.getCurrentPositionInMillis()));
        this.A02.A0j(this.A08.getCurrentPositionInMillis());
        if (this.A01 != null) {
            this.A01.A08();
        }
        this.A08.A0b(1);
        this.A08.A0W();
    }
}
