package com.instagram.common.viewpoint.core;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import io.bidmachine.media3.common.PlaybackException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.bT, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1606bT extends RelativeLayout {
    public static byte[] A0E;
    public static String[] A0F = {"ZXfERob4xoBH3IcU8XCjlL1hD69lrIyA", "mQeX6yhTUvQ4pK8ACBM6nUVZWHaQDR", "t18Mgh0fo46erZhvjKlVSbwf5heaPhmM", "S6rERx5ctFRQ2KVL", "3Fwf", "FlQfbFZAJ1ylax3KsERNgz88EmHf", "VMbmryNa1vDSool6GPHICtScLmJABdX", "KdX0dASRYEcEQR8bSkkNlsR1046Pig"};
    public static final int A0G;
    public AnimatorSet A00;
    public AnimatorSet A01;
    public AnimatorSet A02;
    public LinearLayout A03;
    public C1563am A04;
    public M3 A05;
    public final int A06;
    public final int A07;
    public final View A08;
    public final AbstractC1181Mt A09;
    public final C1231Os A0A;
    public final C1929gi A0B;
    public final InterfaceC1470Yh A0C;
    public final ViewOnClickListenerC1127Kr A0D;

    public static String A06(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) + PlaybackException.ERROR_CODE_SKIP_LIMIT_REACHED);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A0E = new byte[]{77};
    }

    static {
        A08();
        A0G = XV.A02;
    }

    public C1606bT(C1929gi c1929gi, InterfaceC1470Yh interfaceC1470Yh, int i, AbstractC1181Mt abstractC1181Mt, ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr, View view) {
        super(c1929gi);
        this.A0B = c1929gi;
        this.A0C = interfaceC1470Yh;
        this.A09 = abstractC1181Mt;
        this.A0D = viewOnClickListenerC1127Kr;
        this.A08 = view;
        if (getResources().getConfiguration().orientation == 1) {
            this.A02 = new AnimatorSet();
            this.A01 = new AnimatorSet();
            this.A00 = new AnimatorSet();
        }
        int i2 = (int) (i * XX.A02);
        this.A07 = i2;
        this.A06 = i2 - A0G;
        this.A0A = A02();
    }

    private LinearLayout A00() {
        M3 m3;
        this.A03 = new LinearLayout(this.A0B);
        this.A03.setOrientation(1);
        this.A03.addView(A01());
        C1129Kt c1129Kt = new C1129Kt(this);
        if (AbstractC1380Uq.A02(this.A0B) || this.A0B.A0E() == null) {
            m3 = new M3(this.A0B, c1129Kt);
        } else {
            m3 = new M3(this.A0B, this.A0B.A0E(), c1129Kt);
        }
        this.A05 = m3;
        this.A03.addView(this.A05, new LinearLayout.LayoutParams(-1, -1));
        this.A05.loadUrl(((AnonymousClass85) this.A09).A0M().toString());
        return this.A03;
    }

    private LinearLayout A01() {
        this.A04 = new C1563am(this.A0B);
        this.A04.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(XV.A0G, 0, XV.A0G, 0);
        this.A04.setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(this.A0B);
        linearLayout.addView(this.A04);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(XV.A0U, XV.A0U, XV.A0U, XV.A0U);
        linearLayout.setLayoutParams(layoutParams2);
        return linearLayout;
    }

    private C1231Os A02() {
        C1231Os c1231Os = new C1231Os(this.A0B);
        c1231Os.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        c1231Os.setRadius(40.0f);
        c1231Os.addView(A00());
        c1231Os.setTranslationY(getResources().getDisplayMetrics().heightPixels);
        View view = new View(this.A0B);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        view.setBackgroundColor(0);
        view.setOnClickListener(new ViewOnClickListenerC1605bS(this));
        c1231Os.addView(view);
        return c1231Os;
    }

    private void A07() {
        if (this.A02 != null) {
            this.A02.cancel();
            this.A02 = null;
        }
        if (this.A01 != null) {
            this.A01.cancel();
            this.A01 = null;
        }
        if (this.A00 != null) {
            this.A00.cancel();
            this.A00 = null;
        }
    }

    private final void A09() {
        this.A08.setTranslationY(0.0f);
    }

    public final void A0A() {
        int i = getResources().getDisplayMetrics().heightPixels;
        C1231Os c1231Os = this.A0A;
        int screenHeight = this.A07;
        String A06 = A06(0, 1, 105);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c1231Os, A06, i - screenHeight);
        ofFloat.setDuration(300L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.A08, A06, -this.A07);
        ofFloat2.setDuration(300L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.A0A, A06, i - this.A06);
        ofFloat3.setDuration(300L);
        ObjectAnimator adDetailsViewDown = ObjectAnimator.ofFloat(this.A08, A06, -this.A06);
        adDetailsViewDown.setDuration(300L);
        if (this.A02 != null && this.A01 != null && this.A00 != null) {
            this.A02.setInterpolator(new AccelerateDecelerateInterpolator());
            this.A02.playTogether(ofFloat, ofFloat2);
            this.A01.playTogether(ofFloat3, adDetailsViewDown);
            this.A00.playSequentially(this.A02, this.A01);
            this.A00.start();
        }
    }

    public final void A0B() {
        A07();
        this.A05.destroy();
        this.A0A.setVisibility(8);
        A09();
    }

    public final void A0C() {
        if (this.A02 != null) {
            this.A02.pause();
        }
        if (this.A01 != null) {
            this.A01.pause();
        }
        if (this.A00 != null) {
            this.A00.pause();
        }
    }

    public final void A0D(int i) {
        if (i == 2) {
            this.A0A.setVisibility(8);
            this.A08.setTranslationY(0.0f);
            if (A0F[2].charAt(16) != 'j') {
                throw new RuntimeException();
            }
            A0F[3] = "0Dd01EimJB8SQQk0dQvdznLslJ";
            A07();
            A09();
            return;
        }
        if (i == 1) {
            int i2 = getResources().getDisplayMetrics().heightPixels;
            this.A0A.setVisibility(0);
            C1231Os c1231Os = this.A0A;
            int screenHeight = this.A06;
            c1231Os.setTranslationY(i2 - screenHeight);
            View view = this.A08;
            int screenHeight2 = this.A06;
            view.setTranslationY(-screenHeight2);
        }
    }

    public C1231Os getBrowserPeekView() {
        return this.A0A;
    }
}
