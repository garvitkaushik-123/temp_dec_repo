package com.instagram.common.viewpoint.core;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.Arrays;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.67, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AnonymousClass67 extends AbstractC1090Jg implements XQ {
    public static byte[] A0L;
    public static String[] A0M = {"XgHadHW09EVAxZ9Csjyh8Iwd", "cGY", "0gnHO0byxZtUV0t5q6", "nitlVKI6s75UlUdu4qHy2TBluRJ6Vnqb", "dqu", "CAnKNEP5j3LNWAO1IgUwk41cBq", "Gj8h5dX0pUMTu0Q6FRM85YsFx7LjGw4a", "ydUjPQqek3X4wwrCfoz9Rz5n"};
    public static final int A0N;
    public static final int A0O;
    public static final int A0P;
    public RelativeLayout A00;
    public ZI A01;

    @Nullable
    public InterfaceC1691cq A02;
    public C1005Fy A03;
    public C1770e8 A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public final Paint A08;
    public final Path A09;
    public final RectF A0A;
    public final C1929gi A0B;
    public final XS A0C;
    public final InterfaceC1470Yh A0D;
    public final C1646c7 A0E;
    public final EA A0F;
    public final E4 A0G;
    public final E2 A0H;
    public final E0 A0I;
    public final AbstractC0947Dr A0J;
    public final String A0K;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0L, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A0M;
            if (strArr[0].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[1] = "5LW";
            strArr2[4] = "hlZ";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 11);
            i4++;
        }
    }

    public static void A03() {
        A0L = new byte[]{68, 70, 85, 72, 82, 84, 66, 75, 120, 68, 70, 85, 67};
    }

    public abstract void A1X(C1929gi c1929gi);

    static {
        A03();
        A0O = (int) (XX.A02 * 1.0f);
        A0P = (int) (XX.A02 * 4.0f);
        A0N = (int) (XX.A02 * 6.0f);
    }

    public AnonymousClass67(C1646c7 c1646c7, boolean z, String str, C1005Fy c1005Fy) {
        super(c1646c7, z);
        this.A09 = new Path();
        this.A0A = new RectF();
        this.A0J = new AbstractC0947Dr() { // from class: com.facebook.ads.redexgen.X.6C
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.UN
            /* renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C0948Ds c0948Ds) {
                C1005Fy c1005Fy2;
                c1005Fy2 = AnonymousClass67.this.A03;
                c1005Fy2.A0P().setVolume(AnonymousClass67.this.getVideoView().getVolume());
            }
        };
        this.A0F = new EA() { // from class: com.facebook.ads.redexgen.X.6B
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.UN
            /* renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C4K c4k) {
                C1005Fy c1005Fy2;
                c1005Fy2 = AnonymousClass67.this.A03;
                c1005Fy2.A0N().AGM(((Integer) AnonymousClass67.this.getTag(-1593835536)).intValue());
            }
        };
        this.A0H = new E2() { // from class: com.facebook.ads.redexgen.X.6A
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.UN
            /* renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(E3 e3) {
                C1005Fy c1005Fy2;
                c1005Fy2 = AnonymousClass67.this.A03;
                c1005Fy2.A0O().AGY(AnonymousClass67.this);
            }
        };
        this.A0G = new E4() { // from class: com.facebook.ads.redexgen.X.69
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.UN
            /* renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C4B c4b) {
                C1005Fy c1005Fy2;
                c1005Fy2 = AnonymousClass67.this.A03;
                c1005Fy2.A0O().AGW(AnonymousClass67.this);
            }
        };
        this.A0I = new E0() { // from class: com.facebook.ads.redexgen.X.68
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.instagram.common.viewpoint.core.UN
            /* renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(E1 e1) {
                AnonymousClass67.this.A07 = true;
                AnonymousClass67.this.A02();
            }
        };
        this.A0D = c1646c7.A0C();
        this.A0E = c1646c7;
        this.A03 = c1005Fy;
        this.A0K = str;
        this.A0B = c1646c7.A06();
        this.A0C = XS.A00(c1646c7.A06(), c1646c7.A05(), this);
        setGravity(17);
        setPadding(A0O, 0, A0O, A0O);
        YB.A0N(this, 0);
        setUpView(this.A0B);
        this.A08 = new Paint();
        this.A08.setColor(-16777216);
        this.A08.setStyle(Paint.Style.FILL);
        this.A08.setAlpha(16);
        this.A08.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        if (this.A02 == null) {
            return;
        }
        if ((A1V() && this.A07) || (!A1V() && this.A06)) {
            this.A02.ACz();
        }
    }

    private void A04(View view) {
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        YB.A0K(view);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1642c3
    public boolean A0A() {
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1642c3
    public final void A1C() {
        super.A1C();
        this.A0C.A03();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1642c3
    public final boolean A1O() {
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1090Jg
    public final void A1R() {
        if (A1V()) {
            this.A04.A01();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1090Jg
    public final void A1S() {
        if (A1V()) {
            A1T();
            C1770e8 c1770e8 = this.A04;
            EnumC1816et enumC1816et = EnumC1816et.A02;
            if (A0M[2].length() == 4) {
                throw new RuntimeException();
            }
            A0M[2] = "GrzUS";
            c1770e8.A05(enumC1816et);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1090Jg
    public final void A1T() {
        float volume = this.A03.A0P().getVolume();
        if (A1V()) {
            float newVolume = this.A04.getVolume();
            if (volume != newVolume) {
                C1770e8 c1770e8 = this.A04;
                if (A0M[5].length() == 9) {
                    throw new RuntimeException();
                }
                String[] strArr = A0M;
                strArr[1] = "cdp";
                strArr[4] = "iOc";
                c1770e8.setVolume(volume);
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1090Jg
    public final boolean A1U() {
        if (A1V()) {
            boolean A06 = this.A04.A06();
            if (A0M[2].length() == 4) {
                throw new RuntimeException();
            }
            A0M[2] = "SbvNib3Q04NWLkmSI4CaBbpy";
            if (A06) {
                return true;
            }
        }
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1090Jg
    public final boolean A1V() {
        return this.A05;
    }

    public final /* synthetic */ void A1W(View view) {
        getCtaButton().A0E(A01(0, 13, 44));
    }

    public final void A1Y(Map<String, String> extraParams) {
        this.A04.A02();
        if (A1V()) {
            this.A04.A04(getAdEventManager(), this.A0K, extraParams);
        }
    }

    public final RelativeLayout getMediaContainer() {
        return this.A00;
    }

    public final C1770e8 getVideoView() {
        return this.A04;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        this.A09.reset();
        this.A0A.set(0.0f, 0.0f, getWidth(), getHeight());
        this.A09.addRoundRect(this.A0A, A0N, A0N, Path.Direction.CW);
        canvas.drawPath(this.A09, this.A08);
        this.A0A.set(A0O, 0.0f, getWidth() - A0O, getHeight() - A0O);
        this.A09.addRoundRect(this.A0A, A0P, A0P, Path.Direction.CW);
        canvas.clipPath(this.A09);
        super.onDraw(canvas);
    }

    public void setAdTitleAndDescription(String str, String str2) {
        getTitleDescContainer().A04(str, str2, null, true, false);
    }

    public void setCTAInfo(C1189Nc c1189Nc, Map<String, String> extraData) {
        getCtaButton().setCta(c1189Nc, this.A0K, extraData);
    }

    public void setImageUrl(String str) {
        this.A01.setVisibility(0);
        this.A04.setVisibility(8);
        new LM(this.A01, this.A0B).A04().A06(new C1089Jf(this)).A07(str);
    }

    public void setIsVideo(boolean z) {
        this.A05 = z;
    }

    public void setOnAssetsLoadedListener(InterfaceC1691cq interfaceC1691cq) {
        this.A02 = interfaceC1691cq;
    }

    public void setUpImageView(C1929gi c1929gi) {
        this.A01 = new ZI(c1929gi);
        if (C1379Up.A1J(c1929gi)) {
            AbstractC1589bC.A00(this.A01, C1379Up.A1K(c1929gi), new ViewOnClickListenerC1697cw(this));
        }
        A04(this.A01);
    }

    public void setUpMediaContainer(C1929gi c1929gi) {
        this.A00 = new RelativeLayout(c1929gi);
        A04(this.A00);
        XR A02 = this.A0C.A02(this.A0E.A05());
        this.A0E.A06().A0H().A00(A02.A01);
        getCtaButton().setCreativeAsCtaLoggingHelper(this.A0C);
        if (this.A0E.A05().A1e() && C1379Up.A2w(this.A0B)) {
            this.A00.setOnClickListener(new ViewOnClickListenerC1696cv(this));
        } else {
            if (!A02.A00) {
                return;
            }
            this.A00.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.cu
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnonymousClass67.this.A1W(view);
                }
            });
        }
    }

    public void setUpVideoView(C1929gi c1929gi) {
        this.A04 = new C1770e8(c1929gi, new VI(this.A0K, getAdEventManager()));
        if (C1379Up.A1L(c1929gi)) {
            AbstractC1589bC.A00(this.A04, C1379Up.A1M(c1929gi), new ViewOnClickListenerC1698cx(this));
        }
        A04(this.A04);
    }

    private void setUpView(C1929gi c1929gi) {
        setUpImageView(c1929gi);
        setUpVideoView(c1929gi);
        setUpMediaContainer(c1929gi);
        this.A00.addView(this.A01);
        this.A00.addView(this.A04);
        A1X(c1929gi);
    }

    public void setVideoPlaceholderUrl(String str) {
        this.A04.setPlaceholderUrl(str);
    }

    public void setVideoUrl(String str) {
        this.A01.setVisibility(8);
        this.A04.setVisibility(0);
        this.A04.setVideoURI(str);
        this.A04.A03(this.A0J);
        this.A04.A03(this.A0F);
        this.A04.A03(this.A0H);
        this.A04.A03(this.A0G);
        this.A04.A03(this.A0I);
    }
}
