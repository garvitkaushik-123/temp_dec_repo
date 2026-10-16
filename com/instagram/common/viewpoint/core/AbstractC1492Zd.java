package com.instagram.common.viewpoint.core;

import android.widget.FrameLayout;
import com.facebook.ads.AdClosedListener;

/* renamed from: com.facebook.ads.redexgen.X.Zd, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1492Zd extends FrameLayout {
    public static String[] A0E = {"5RNIIKEidNz4CxH4JgV5654XoKm2WCRJ", "1p9zA", "TyFhTVOKfwCiarLUW0", "qGg1KSsP6zNQFhXHIMmjZGXDOHal5qmq", "ysvkaelauuCqE6L7ICudiIGq1Ejo0wOd", "BlsqFJOSCgQfST", "dpiEaUs9Aor9er1WGZ", "tfv9H94"};
    public int A00;
    public AdClosedListener A01;
    public EnumC1221Oi A02;
    public C1222Oj A03;
    public C1223Ok A04;
    public InterfaceC1491Zc A05;
    public final C1219Og A06;
    public final C1929gi A07;
    public final VA A08;
    public final InterfaceC1470Yh A09;
    public final InterfaceC1471Yi A0A;
    public final String A0B;
    public final C1199Nm A0C;
    public final InterfaceC1494Zf A0D;

    public abstract void A0O();

    public abstract void A0P();

    public abstract void A0R(C1223Ok c1223Ok, EnumC1221Oi enumC1221Oi);

    public abstract boolean A0S();

    public AbstractC1492Zd(C1929gi c1929gi, VA va, String str) {
        this(c1929gi, va, str, null, null, null);
    }

    public AbstractC1492Zd(C1929gi c1929gi, VA va, String str, C1199Nm c1199Nm, InterfaceC1471Yi interfaceC1471Yi, InterfaceC1470Yh interfaceC1470Yh) {
        super(c1929gi);
        this.A00 = 0;
        this.A02 = EnumC1221Oi.A05;
        this.A04 = null;
        this.A0D = new MF(this);
        this.A07 = c1929gi;
        this.A08 = va;
        this.A0A = interfaceC1471Yi;
        this.A09 = interfaceC1470Yh;
        this.A0B = str;
        this.A0C = c1199Nm;
        this.A06 = AbstractC1220Oh.A00(this.A07.A02());
    }

    public static /* synthetic */ int A02(AbstractC1492Zd abstractC1492Zd) {
        int i = abstractC1492Zd.A00;
        abstractC1492Zd.A00 = i + 1;
        return i;
    }

    public static /* synthetic */ int A03(AbstractC1492Zd abstractC1492Zd) {
        int i = abstractC1492Zd.A00;
        abstractC1492Zd.A00 = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0E() {
        if (this.A03.A0A()) {
            this.A08.AB3(this.A0B, this.A03.A02());
            this.A03.A03();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0F() {
        this.A04 = null;
        this.A03.A05();
        A0O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G(C1223Ok c1223Ok) {
        this.A03.A08(this.A02);
        A0Q(c1223Ok, this.A02);
        N8.A01(this.A07).A0L();
        if (A0S()) {
            A0E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H(C1223Ok c1223Ok) {
        this.A04 = c1223Ok;
        this.A03.A09(this.A02, this.A00);
        A0R(c1223Ok, this.A02);
    }

    public final void A0M() {
        A0E();
    }

    public final void A0N() {
        this.A03 = new C1222Oj(new VI(this.A0B, this.A08));
        if (this.A0A != null) {
            InterfaceC1471Yi interfaceC1471Yi = this.A0A;
            if (A0E[0].charAt(22) == 'O') {
                throw new RuntimeException();
            }
            A0E[7] = "FLAi4P2";
            interfaceC1471Yi.AFA(true);
        }
        if (this.A05 != null) {
            this.A05.ACs();
        }
        A0F();
    }

    public void A0Q(C1223Ok c1223Ok, EnumC1221Oi enumC1221Oi) {
        if (this.A01 != null) {
            this.A07.A0F().ABV();
            this.A01.onAdClosed();
        }
    }

    public void setAdReportingCallbackListener(InterfaceC1491Zc interfaceC1491Zc) {
        this.A05 = interfaceC1491Zc;
    }

    public void setOnAdClosedListener(AdClosedListener adClosedListener) {
        this.A01 = adClosedListener;
    }
}
