package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class NP implements InterfaceC1778eG {
    public static byte[] A01;
    public static String[] A02 = {"BHXiYjXxfgjD7yDB", "kPfw5HKETqo8dV", "SlBKzsC69frNfTspgJs5v90302jxH173", "0t7u2eeKUCj5gcxeWZIOCTpidMAeGJtt", "hTXrvsDVbOi3Q9xrUBZOJj7T", "iLbLRTjnBQIJ87KFXaIFUijyWt7EPIGc", "0utayShxEdwMeaV3UZeoWviAuyaBWRmj", "gyVOCm6F1v6TZALkbG"};
    public final /* synthetic */ NO A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 58);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.EM, Ascii.ETB, 9, Ascii.SYN, 7, Ascii.DLE, Ascii.CR, 7, Ascii.SI};
    }

    static {
        A01();
    }

    public NP(NO no) {
        this.A00 = no;
    }

    public /* synthetic */ NP(NO no, OV ov) {
        this(no);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1778eG
    public final void ADX() {
        this.A00.A0W(true, A00(0, 9, 106));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1778eG
    public final void AEA() {
        boolean z;
        AbstractC2094jd abstractC2094jd;
        InterfaceC1470Yh interfaceC1470Yh;
        ZU zu;
        VA va;
        AbstractC2094jd abstractC2094jd2;
        C1780eI c1780eI;
        C1780eI c1780eI2;
        C1929gi c1929gi;
        ZU zu2;
        AbstractC2094jd abstractC2094jd3;
        AbstractC2094jd abstractC2094jd4;
        C1929gi c1929gi2;
        AbstractC2094jd abstractC2094jd5;
        AbstractC2094jd abstractC2094jd6;
        C1929gi c1929gi3;
        C1201No c1201No;
        C1929gi c1929gi4;
        C1929gi c1929gi5;
        z = this.A00.A0f;
        if (!z) {
            abstractC2094jd = this.A00.A0O;
            if (!TextUtils.isEmpty(abstractC2094jd.A2E())) {
                va = this.A00.A0S;
                abstractC2094jd2 = this.A00.A0O;
                String A2E = abstractC2094jd2.A2E();
                C1586b9 c1586b9 = new C1586b9();
                c1780eI = this.A00.A0B;
                C1586b9 A03 = c1586b9.A03(c1780eI.getViewabilityChecker());
                c1780eI2 = this.A00.A0B;
                va.ABJ(A2E, A03.A02(c1780eI2.getTouchDataRecorder()).A05());
                c1929gi = this.A00.A0R;
                C1425Wl A00 = C1425Wl.A00(c1929gi);
                zu2 = this.A00.A0X;
                String A8l = zu2.A8l();
                abstractC2094jd3 = this.A00.A0O;
                A00.A0E(A8l, abstractC2094jd3.A2E());
                abstractC2094jd4 = this.A00.A0O;
                C1193Ng A2A = abstractC2094jd4.A2A();
                c1929gi2 = this.A00.A0R;
                C1193Ng.A07(A2A, c1929gi2);
                abstractC2094jd5 = this.A00.A0O;
                String A0y = abstractC2094jd5.A0y();
                abstractC2094jd6 = this.A00.A0O;
                AbstractC1213Oa.A02(A0y, AbstractC1449Xm.A00(abstractC2094jd6.A10()));
                c1929gi3 = this.A00.A0R;
                c1929gi3.A0F().A3L();
                c1201No = this.A00.A0P;
                if (c1201No.A0c()) {
                    c1929gi4 = this.A00.A0R;
                    c1929gi4.A0F().AES();
                }
            }
            NO no = this.A00;
            String[] strArr = A02;
            if (strArr[5].charAt(12) == strArr[2].charAt(12)) {
                throw new RuntimeException();
            }
            A02[4] = "GzK3XL6hk7idJD";
            interfaceC1470Yh = no.A0W;
            zu = this.A00.A0X;
            interfaceC1470Yh.A4j(zu.A8G());
            return;
        }
        c1929gi5 = this.A00.A0R;
        c1929gi5.A0F().AET();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1778eG
    public final void AEh() {
        InterfaceC1470Yh interfaceC1470Yh;
        ZU zu;
        interfaceC1470Yh = this.A00.A0W;
        zu = this.A00.A0X;
        interfaceC1470Yh.A4j(zu.A81());
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1778eG
    public final void AFQ() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1778eG
    public final void AGg() {
        InterfaceC1470Yh interfaceC1470Yh;
        interfaceC1470Yh = this.A00.A0W;
        interfaceC1470Yh.ADJ(15);
    }
}
