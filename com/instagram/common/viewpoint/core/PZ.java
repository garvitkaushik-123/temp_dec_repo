package com.instagram.common.viewpoint.core;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public class PZ extends RelativeLayout implements InterfaceC1471Yi {
    public static byte[] A0G;
    public static final String A0H;
    public static final int A0I;
    public long A00;
    public long A01;
    public String A02;
    public boolean A03;
    public String A04;
    public boolean A05;
    public final InterfaceC1297Rk A06;
    public final LinearLayout A07;
    public final C1291Re A08;
    public final C1929gi A09;
    public final VA A0A;
    public final InterfaceC1470Yh A0B;
    public final C1558ah A0C;
    public final InterfaceC1567aq A0D;
    public final M3 A0E;
    public final InterfaceC1572av A0F;

    public static String A0D(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0G, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 44);
        }
        return new String(copyOfRange);
    }

    public static void A0E() {
        A0G = new byte[]{90, 112, 112, 125, 112, Ascii.DC4, 63, Base64.padSymbol, 112, 19, 63, 62, 36, 53, 62, 36, 112, Ascii.FS, 63, 49, 52, 53, 52, 112, 4, 57, Base64.padSymbol, 53, 106, 112, 48, Ascii.SUB, Ascii.SUB, Ascii.ETB, Ascii.SUB, 118, 85, 91, 94, Ascii.SUB, 124, 83, 84, 83, 73, 82, Ascii.SUB, 110, 83, 87, 95, 0, Ascii.SUB, 95, 117, 117, 120, 117, Ascii.EM, 58, 52, 49, 117, 6, 33, 52, 39, 33, 117, 1, 60, 56, 48, 111, 117, 117, 95, 95, 82, 95, 45, Ascii.SUB, Ascii.FF, Ascii.SI, Ascii.DLE, 17, Ascii.FF, Ascii.SUB, 95, 58, 17, Ascii.ESC, 95, 43, Ascii.SYN, Ascii.DC2, Ascii.SUB, 69, 95, 109, 71, 71, 74, 71, 52, 4, Ascii.NAK, 8, Ascii.VT, Ascii.VT, 71, 53, 2, 6, 3, Ascii.RS, 71, 51, Ascii.SO, 10, 2, 93, 71, 87, 125, 125, 112, 125, Ascii.SO, 56, 46, 46, 52, 50, 51, 125, Ascii.ESC, 52, 51, 52, 46, 53, 125, 9, 52, 48, 56, 103, 125, 42, Ascii.SUB, 48, 48, Base64.padSymbol, 48, 88, 113, 126, 116, 124, 117, 98, 48, 68, 121, 125, 117, 42, 48, 97, 81, 76, 84, 80, 70, 81, 3, 80, 70, 80, 80, 74, 76, 77, 3, 71, 66, 87, 66, 3, 79, 76, 68, 68, 70, 71, 3, 99, 3, 126, 125, 112, 106, 107, 37, 125, 115, 126, 113, 116, 67, 83, 78, 86, 82, 68, 83, 116, 115, 109, 85, 90, 95, 83, 88, 66, 98, 89, 93, 83, 88, 37, 44, 35, 41, 33, 40, 63, Ascii.EM, 36, 32, 40};
    }

    static {
        A0E();
        A0H = PZ.class.getSimpleName();
        A0I = XV.A0A;
    }

    public PZ(C1291Re c1291Re, C1929gi c1929gi, VA va, InterfaceC1470Yh interfaceC1470Yh, boolean z) {
        super(c1929gi);
        M3 m3;
        this.A06 = new C1241Pc(this);
        this.A05 = true;
        this.A01 = -1L;
        this.A03 = true;
        this.A08 = c1291Re;
        this.A0A = va;
        this.A0B = interfaceC1470Yh;
        this.A09 = c1929gi;
        if (c1929gi.A0E() == null) {
            c1929gi.A0F().A9v();
        }
        this.A0D = A0F();
        if (AbstractC1380Uq.A02(c1929gi) || c1929gi.A0E() == null) {
            m3 = new M3(c1929gi, this.A0D);
        } else {
            m3 = new M3(c1929gi, c1929gi.A0E(), this.A0D);
        }
        this.A0E = m3;
        this.A0F = A0C(z);
        this.A07 = (LinearLayout) this.A0F;
        this.A07.setId(View.generateViewId());
        this.A0F.setListener(new C1240Pb(this));
        this.A0E.setBrowserNavigationListener(this.A0F.getBrowserNavigationListener());
        this.A0C = new C1558ah(c1929gi, null, R.attr.progressBarStyleHorizontal);
        A0G();
        c1291Re.A0A(this.A06);
    }

    private InterfaceC1572av A0C(boolean z) {
        if (z) {
            return new M8(this.A09, this.A0E, false);
        }
        return new M6(this.A09, this.A0E);
    }

    public InterfaceC1567aq A0F() {
        return new C1239Pa(this);
    }

    public void A0G() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        this.A07.setPadding(XV.A0b, XV.A0b, XV.A0b, XV.A0b);
        this.A0B.A45(this.A07, layoutParams);
        RelativeLayout.LayoutParams webViewParams = new RelativeLayout.LayoutParams(-1, -2);
        webViewParams.addRule(3, this.A07.getId());
        webViewParams.addRule(12);
        this.A0B.A45(this.A0E, webViewParams);
        RelativeLayout.LayoutParams webViewParams2 = new RelativeLayout.LayoutParams(-1, A0I);
        webViewParams2.addRule(3, this.A07.getId());
        this.A0C.setProgress(0);
        this.A0B.A45(this.A0C, webViewParams2);
    }

    public void A0H() {
        this.A08.finish(1);
    }

    public void A0I(String str) {
    }

    public void AAu(Intent intent, Bundle bundle, C1291Re c1291Re) {
        if (this.A01 < 0) {
            this.A01 = System.currentTimeMillis();
        }
        String A0D = A0D(231, 11, 97);
        String A0D2 = A0D(Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 11, 26);
        String url = A0D(210, 10, 13);
        if (bundle == null) {
            this.A02 = intent.getStringExtra(url);
            this.A04 = intent.getStringExtra(A0D2);
            this.A00 = intent.getLongExtra(A0D, -1L);
        } else {
            this.A02 = bundle.getString(url);
            this.A04 = bundle.getString(A0D2);
            this.A00 = bundle.getLong(A0D, -1L);
        }
        String A0D3 = this.A02 != null ? this.A02 : A0D(199, 11, 51);
        this.A0F.setUrl(A0D3);
        this.A0E.loadUrl(A0D3);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void AFA(boolean z) {
        this.A0E.onPause();
        if (this.A03) {
            this.A03 = false;
            C1561ak A07 = new C1560aj(this.A0E.getFirstUrl()).A01(this.A00).A03(this.A01).A04(this.A0E.getResponseEndMs()).A00(this.A0E.getDomContentLoadedMs()).A05(this.A0E.getScrollReadyMs()).A02(this.A0E.getLoadFinishMs()).A06(System.currentTimeMillis()).A07();
            this.A0A.AB5(this.A04, A07.A02());
            if (BuildConfigApi.isDebug()) {
                String str = A0D(169, 30, 15) + System.currentTimeMillis() + A0D(149, 20, 60) + A07.A01 + A0D(53, 22, Sdk.SDKError.Reason.TPAT_ERROR_VALUE) + A07.A03 + A0D(75, 24, 83) + A07.A04 + A0D(0, 30, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE) + A07.A00 + A0D(99, 24, 75) + A07.A05 + A0D(30, 23, 22) + A07.A02 + A0D(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, 26, 113) + A07.A06;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void AFi(boolean z) {
        this.A0E.onResume();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void AIv(Bundle bundle) {
        bundle.putString(A0D(210, 10, 13), this.A02);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public String getCurrentClientToken() {
        return this.A04;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    public void onDestroy() {
        this.A08.A0B(this.A06);
        AbstractC1581b4.A03(this.A0E);
        this.A0E.destroy();
    }

    public void setListener(InterfaceC1470Yh interfaceC1470Yh) {
    }
}
