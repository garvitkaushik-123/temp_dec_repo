package com.instagram.common.viewpoint.core;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.cJ, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1658cJ {
    public static byte[] A0N;
    public static String[] A0O = {"pFRbUbIPvfwTsTWtR68DyqtfsQzo0Y9e", "Jmt0yS7cxIqywVTLVazlNOZqViG4fijG", "7JVXgwFSulrh0z9RNSntkrow2", "W96LwBzZpPkBapcy7gGTKWs8B4GUDBcq", "br88nFbBZbLJ3vTh4p9wwCNTIA57FmIY", "mzQptMR0Z3d1fPQPbwNf4EthVYWzR3DW", "IPE7BiI9pZn923UUuncSvZhUL3wMHGrT", "br6hrssh6VRKiVV1vNUkmhf3WWjX02F0"};
    public C1534aJ A08;
    public C1534aJ A09;
    public ViewOnClickListenerC1127Kr A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0E;
    public final int A0F;
    public final AbstractC2094jd A0G;
    public final NN A0H;
    public final NY A0I;
    public final C1190Nd A0J;
    public final C1929gi A0K;
    public final VI A0L;
    public final InterfaceC1470Yh A0M;
    public int A03 = 16;
    public int A02 = 12;
    public int A01 = 10;
    public int A04 = 20;
    public int A05 = 40;
    public int A06 = 52;
    public int A00 = 10;
    public int A07 = 8;
    public boolean A0D = true;

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0N, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = copyOfRange[i4] ^ i3;
            if (A0O[2].length() != 25) {
                throw new RuntimeException();
            }
            String[] strArr = A0O;
            strArr[3] = "XwNXbwlUcFi7qEktIehGuIyqazGrk614";
            strArr[1] = "hx9Csixc74t4pIrSAOrr1o5nquGlqFF4";
            copyOfRange[i4] = (byte) (i5 ^ 30);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0N = new byte[]{109, 118, 126, 126, 126, 126, 126, 126, 126, 4, 97, 97, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, 37, 41, 43, 104, 32, 39, 37, 35, 36, 41, 41, 45, 104, 39, 34, 53, 104, 47, 40, 50, 35, 52, 53, 50, 47, 50, 47, 39, 42, 104, 32, 47, 40, 47, 53, 46, Ascii.EM, 39, 37, 50, 47, 48, 47, 50, 63, 42, 50, 48, 41};
    }

    static {
        A04();
    }

    public C1658cJ(C1929gi c1929gi, AbstractC2094jd abstractC2094jd, VI vi, Handler handler, InterfaceC1470Yh interfaceC1470Yh) {
        this.A0K = c1929gi;
        this.A0M = interfaceC1470Yh;
        this.A0I = abstractC2094jd.A29().A0I();
        this.A0J = abstractC2094jd.A29().A0K();
        this.A0H = abstractC2094jd.A28();
        this.A0E = abstractC2094jd.A2T();
        this.A0C = abstractC2094jd.A2P();
        this.A0F = AbstractC1792eU.A00(c1929gi.getResources().getDisplayMetrics());
        this.A0L = vi;
        this.A0G = abstractC2094jd;
        A03();
    }

    private ImageView A00(final ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr) {
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(YN.A01(YM.OTHER_SKIP), this.A04, this.A04, true);
        ImageView imageView = new ImageView(this.A0K);
        imageView.setImageBitmap(scaledBitmap);
        imageView.setColorFilter(-1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(A02(0, 9, 80)));
        imageView.setBackground(gradientDrawable);
        imageView.setPadding(this.A01, this.A01, this.A01, this.A01);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.cG
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1658cJ.A0B(ViewOnClickListenerC1127Kr.this, view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388661);
        layoutParams.setMargins(0, 0, 0, 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setVisibility(0);
        return imageView;
    }

    private TextView A01() {
        if (TextUtils.isEmpty(this.A0G.A29().A0I().A08())) {
            return null;
        }
        TextView textView = new TextView(this.A0K);
        textView.setText(this.A0G.A29().A0I().A08());
        textView.setTextColor(-1);
        textView.setTextSize(13.0f);
        textView.setGravity(17);
        return textView;
    }

    private void A03() {
        this.A03 *= this.A0F;
        this.A02 *= this.A0F;
        this.A01 *= this.A0F;
        this.A04 *= this.A0F;
        this.A05 *= this.A0F;
        this.A06 *= this.A0F;
        this.A00 *= this.A0F;
        this.A07 *= this.A0F;
    }

    private void A05(FrameLayout frameLayout) {
        View view = new View(this.A0K);
        view.setBackgroundColor(Color.parseColor(A02(9, 9, 57)));
        view.setAlpha(0.8f);
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    private void A06(FrameLayout frameLayout) {
        FrameLayout frameLayout2 = new FrameLayout(this.A0K);
        this.A08 = AbstractC1539aO.A01(this.A0K, false, this.A0G, this.A0L, this.A0M, EnumC1537aM.A02, AbstractC1536aL.A00(this.A0G));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388693);
        layoutParams.setMargins(0, 0, this.A04, this.A03);
        frameLayout2.addView(this.A08, layoutParams);
        frameLayout.addView(frameLayout2);
    }

    private void A07(FrameLayout frameLayout) {
        FrameLayout frameLayout2 = new FrameLayout(this.A0K);
        this.A09 = AbstractC1539aO.A01(this.A0K, false, this.A0G, this.A0L, this.A0M, EnumC1537aM.A02, EnumC1540aP.A04);
        YB.A0K(this.A09);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388691);
        layoutParams.setMargins(this.A04, 0, 0, this.A03);
        frameLayout2.addView(this.A09, layoutParams);
        frameLayout.addView(frameLayout2);
    }

    private void A08(FrameLayout frameLayout) {
        FrameLayout frameLayout2 = new FrameLayout(this.A0K);
        C1538aN A02 = AbstractC1539aO.A02(this.A0K, EnumC1537aM.A02, this.A0G);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388691);
        layoutParams.setMargins(this.A04, 0, 0, this.A03);
        frameLayout2.addView(A02, layoutParams);
        frameLayout.addView(frameLayout2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00bf, code lost:
    
        if (r9 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00c5, code lost:
    
        if (r2 <= 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c7, code lost:
    
        r10 = null;
        r9 = r13.A0C;
        r8 = com.instagram.common.viewpoint.core.C1658cJ.A0O;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00dc, code lost:
    
        if (r8[0].charAt(31) == r8[6].charAt(31)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00de, code lost:
    
        r8 = com.instagram.common.viewpoint.core.C1658cJ.A0O;
        r8[3] = "NBSSb5i8vB7h2DITQFZ0JVIGTEGpjtjm";
        r8[1] = "r6oo3XDBH3cPwN6mP2aoTtDXeEGymFZK";
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ea, code lost:
    
        if (r9 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ec, code lost:
    
        if (r15 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ee, code lost:
    
        r10 = A00(r15);
        r7.addView(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00f5, code lost:
    
        com.instagram.common.viewpoint.core.AbstractC1792eU.A01(r13.A0K, r6, r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x011c, code lost:
    
        r8 = com.instagram.common.viewpoint.core.C1658cJ.A0O;
        r8[0] = "LTYB5M4Mhdd1oprOtejFkg7YcKqdK9Vm";
        r8[6] = "s8tsGyr3r09N1mPmkZSZvoZyMzIeZ0vJ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0128, code lost:
    
        if (r9 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00fa, code lost:
    
        r7.addView(r6, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ff, code lost:
    
        if (r13.A0D != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0101, code lost:
    
        r2 = com.instagram.common.viewpoint.core.C1658cJ.A0O;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0114, code lost:
    
        if (r2[4].charAt(0) == r2[7].charAt(0)) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x011b, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x013a, code lost:
    
        r2 = com.instagram.common.viewpoint.core.C1658cJ.A0O;
        r2[3] = "Yzc02jbTluogikiQi2Wv962AcLGu9uF1";
        r2[1] = "JahYjLhPUhQBnUZY2LL7YeIOJlGmyCNi";
        r6.setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0149, code lost:
    
        r14.addView(r7, new android.widget.FrameLayout.LayoutParams(-1, -2, 48));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0153, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0137, code lost:
    
        if (r9 != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A09(FrameLayout frameLayout, ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr) {
        FrameLayout frameLayout2 = new FrameLayout(this.A0K);
        frameLayout2.setPadding(0, this.A06, this.A02, this.A02);
        if (this.A0E) {
            frameLayout2.setOnClickListener(new ViewOnClickListenerC1657cI(this, viewOnClickListenerC1127Kr));
        }
        Bitmap bitmap = YN.A01(YM.NAV_CROSS);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, this.A04, this.A04, true);
        ImageView dubiousSkip = new ImageView(this.A0K);
        YB.A0G(1002, dubiousSkip);
        dubiousSkip.setImageBitmap(createScaledBitmap);
        dubiousSkip.setColorFilter(-1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(A02(0, 9, 80)));
        dubiousSkip.setBackground(gradientDrawable);
        dubiousSkip.setPadding(this.A01, this.A01, this.A01, this.A01);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388661);
        layoutParams.setMargins(0, 0, 0, 0);
        dubiousSkip.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.cF
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1658cJ.this.A0G(view);
            }
        });
        long A00 = this.A0J.A00();
        if (this.A0B) {
            C1190Nd c1190Nd = this.A0J;
            if (A0O[2].length() != 25) {
                throw new RuntimeException();
            }
            A0O[2] = "EDg5a4vgNKTBN5Vd4K7j2JAWQ";
            A00 = c1190Nd.A01();
        }
        boolean z = this.A0D;
        if (A0O[2].length() != 25) {
            String[] strArr = A0O;
            strArr[3] = "lPr3oecF17Vr0ETjxWpa6eT7xUG7TKGz";
            strArr[1] = "pN0Dd6Okr1h1scp4h6gPnTJrQwG996nC";
        } else {
            String[] strArr2 = A0O;
            strArr2[3] = "tzOwMkw7uDsuhpEAhy55DDXkTNG5R2eG";
            strArr2[1] = "LVlHDeBQ28ZWrMMDEXcUdCCcU9GvuA6m";
        }
    }

    private void A0A(ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewOnClickListenerC1127Kr.setPadding(this.A04, this.A03, this.A04, this.A03);
        viewOnClickListenerC1127Kr.setTextSize(14.0f);
        viewOnClickListenerC1127Kr.A0D();
        viewOnClickListenerC1127Kr.setIncludeFontPadding(true);
        viewOnClickListenerC1127Kr.setLayoutParams(layoutParams);
        viewOnClickListenerC1127Kr.setTextColor(-16777216);
        YB.A0V(viewOnClickListenerC1127Kr, YB.A06(-1, this.A00));
        viewOnClickListenerC1127Kr.setId(View.generateViewId());
        if (viewOnClickListenerC1127Kr.getParent() != null) {
            ((ViewGroup) viewOnClickListenerC1127Kr.getParent()).removeView(viewOnClickListenerC1127Kr);
        }
    }

    public static /* synthetic */ void A0B(ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr, View view) {
        viewOnClickListenerC1127Kr.A0E(A02(63, 4, 71));
        viewOnClickListenerC1127Kr.setVisibility(4);
    }

    public final View A0C(ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr) {
        if (viewOnClickListenerC1127Kr != null) {
            viewOnClickListenerC1127Kr.setV2Design(true);
        }
        return A0D(viewOnClickListenerC1127Kr, null);
    }

    public final View A0D(ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr, ImageView imageView) {
        this.A0A = viewOnClickListenerC1127Kr;
        this.A0B = imageView != null;
        FrameLayout frameLayout = new FrameLayout(this.A0K);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        C1629bq c1629bq = new C1629bq(this.A0K, this.A0H.A01(), true, false, false);
        c1629bq.A04(this.A0I.A0G(), this.A0I.A0E().toLowerCase(Locale.getDefault()), null, false, false);
        c1629bq.setAlignment(17);
        c1629bq.setTitleTextSize(28);
        c1629bq.setDescriptionTextSize(13);
        c1629bq.A02();
        c1629bq.setPadding(this.A05, 0, this.A05, 0);
        LinearLayout linearLayout = new LinearLayout(this.A0K);
        linearLayout.setClickable(true);
        if (C1379Up.A1D(this.A0K)) {
            linearLayout.setOnClickListener(new ViewOnClickListenerC1656cH(this, viewOnClickListenerC1127Kr));
        }
        linearLayout.setPadding(0, -this.A04, 0, 0);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        if (imageView != null) {
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            linearLayout.addView(imageView);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, this.A03, 0, this.A07);
        linearLayout.addView(c1629bq, layoutParams);
        TextView A01 = A01();
        if (A01 != null) {
            new LinearLayout.LayoutParams(-2, -2).setMargins(0, this.A07, 0, this.A03);
            linearLayout.addView(A01);
        }
        if (viewOnClickListenerC1127Kr != null) {
            A0A(viewOnClickListenerC1127Kr);
            linearLayout.addView(viewOnClickListenerC1127Kr, layoutParams);
            if (TextUtils.isEmpty(viewOnClickListenerC1127Kr.getText())) {
                YB.A0H(viewOnClickListenerC1127Kr);
            }
        }
        linearLayout.setAlpha(1.0f);
        A05(frameLayout);
        frameLayout.addView(linearLayout);
        A09(frameLayout, viewOnClickListenerC1127Kr);
        if (this.A0G.A2M()) {
            A06(frameLayout);
        }
        AbstractC2094jd abstractC2094jd = this.A0G;
        String[] strArr = A0O;
        if (strArr[0].charAt(31) == strArr[6].charAt(31)) {
            throw new RuntimeException();
        }
        A0O[2] = "4iwGVt394BTmmSYCgqRVgc6es";
        if (abstractC2094jd.A2W()) {
            A08(frameLayout);
        } else if (this.A0G.A2V()) {
            A07(frameLayout);
        }
        return frameLayout;
    }

    public final ViewOnClickListenerC1127Kr A0E() {
        return this.A0A;
    }

    public final void A0F() {
        if (this.A08 != null) {
            this.A08.A0O();
        }
        C1534aJ c1534aJ = this.A09;
        String[] strArr = A0O;
        if (strArr[4].charAt(0) != strArr[7].charAt(0)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0O;
        strArr2[3] = "2Z0HXqlllvltE4fpmlk2k5YgzqGJ81zY";
        strArr2[1] = "EMsyCAj6WMyQurvXYMEHBK7qX1GDVftC";
        if (c1534aJ != null) {
            this.A09.A0O();
        }
    }

    public final /* synthetic */ void A0G(View view) {
        this.A0K.A0F().AB0();
        this.A0M.A4j(A02(18, 45, 88));
    }

    public final void A0H(boolean z) {
        if (!z && this.A08 != null) {
            this.A08.A0P();
        }
        if (this.A09 != null) {
            this.A09.A0P();
        }
    }

    public final void A0I(boolean z) {
        this.A0D = z;
    }
}
