package com.instagram.common.viewpoint.core;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.common.base.Ascii;
import io.bidmachine.media3.common.PlaybackException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.1F, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class C1F extends C7M implements View.OnTouchListener {
    public static byte[] A07;
    public static String[] A08 = {"ySOBxSJ7y2GELC2cR9WRTK6hAhZYocJS", "8dRmuXbfMCidMDGiSpjEcbCkPgx3mm8G", "li61zS9WhZTBvI47lvKtLPcqAcNkij1S", "lH5BfkXLxOyhi", "q0Ccq4Fbg7VKO8sxkIKNcZgKtjQ1fZ14", "ep7ggC7RKpg7Ol5cXUmXF8JhcfOkgUip", "fpgtpMAGWAVh3a0xLZP1kWTjCGk3An57", "s5"};
    public int A00;

    @Nullable
    public C1999hr A01;
    public InterfaceC1764e2 A02;
    public boolean A03;
    public boolean A04;
    public int A05;
    public final int A06;

    public static String A09(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) + PlaybackException.ERROR_CODE_CONTENT_ALREADY_PLAYING);
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{-4, Ascii.ETB, 10, Ascii.EM, -5, Ascii.SO, Ascii.FF, 34, Ascii.FF, Ascii.NAK, Ascii.SO, Ascii.ESC, -1, Ascii.DC2, Ascii.SO, 32, -55, Ascii.CAN, Ascii.ETB, Ascii.NAK, 34, -55, Ascii.FS, Ascii.RS, Ascii.EM, Ascii.EM, Ascii.CAN, Ascii.ESC, Ascii.GS, Ascii.FS, -55, -11, Ascii.DC2, Ascii.ETB, Ascii.SO, 10, Ascii.ESC, -11, 10, 34, Ascii.CAN, Ascii.RS, Ascii.GS, -10, 10, Ascii.ETB, 10, Ascii.DLE, Ascii.SO, Ascii.ESC};
    }

    static {
        A0A();
    }

    public C1F(C1929gi c1929gi) {
        super(c1929gi);
        this.A05 = 0;
        this.A00 = 0;
        this.A03 = true;
        this.A04 = false;
        this.A06 = A05();
        setOnTouchListener(this);
    }

    public C1F(C1929gi c1929gi, AttributeSet attributeSet) {
        super(c1929gi, attributeSet);
        this.A05 = 0;
        this.A00 = 0;
        this.A03 = true;
        this.A04 = false;
        this.A06 = A05();
        setOnTouchListener(this);
    }

    public C1F(C1929gi c1929gi, AttributeSet attributeSet, int i) {
        super(c1929gi, attributeSet, i);
        this.A05 = 0;
        this.A00 = 0;
        this.A03 = true;
        this.A04 = false;
        this.A06 = A05();
        setOnTouchListener(this);
    }

    private int A05() {
        return ((int) getContext().getResources().getDisplayMetrics().density) * 10;
    }

    private int A06(int i) {
        int delta = this.A00 - i;
        int A8o = this.A02.A8o(delta);
        int scrollX = this.A06;
        if (delta > scrollX) {
            int scrollX2 = this.A05;
            return A08(scrollX2, A8o);
        }
        int scrollX3 = this.A06;
        if (delta < (-scrollX3)) {
            int i2 = this.A05;
            if (A08[6].charAt(24) != 67) {
                throw new RuntimeException();
            }
            A08[7] = "Vh4";
            int scrollX4 = A07(i2, A8o);
            return scrollX4;
        }
        int scrollX5 = this.A05;
        return scrollX5;
    }

    private int A07(int i, int i2) {
        return Math.max(i - i2, 0);
    }

    private int A08(int i, int i2) {
        return Math.min(i + i2, getItemCount() - 1);
    }

    public void A20(int i, boolean z) {
        if (getAdapter() == null) {
            return;
        }
        this.A05 = i;
        if (z) {
            A1Y(i);
        } else {
            A1X(i);
        }
    }

    public int getCurrentPosition() {
        return this.A05;
    }

    private int getItemCount() {
        if (getAdapter() == null) {
            return 0;
        }
        return getAdapter().A0B();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1 && actionMasked != 6 && actionMasked != 3) {
            int action = A08[7].length();
            if (action == 18) {
                throw new RuntimeException();
            }
            A08[4] = "tIjSEqZVzrzr7cEE0p57iZetopRejSVd";
            if (actionMasked != 4) {
                if (actionMasked == 0 || actionMasked == 5 || (this.A03 && actionMasked == 2)) {
                    this.A00 = rawX;
                    if (this.A03) {
                        this.A03 = false;
                    }
                    this.A04 = true;
                }
                return false;
            }
        }
        if (this.A04) {
            int rawX2 = A06(rawX);
            A20(rawX2, true);
        }
        this.A03 = true;
        this.A04 = false;
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.C7M
    public void setLayoutManager(R2 r2) {
        if (r2 instanceof C1999hr) {
            super.setLayoutManager(r2);
            this.A01 = (C1999hr) r2;
            return;
        }
        throw new IllegalArgumentException(A09(0, 50, 59));
    }

    public void setSnapDelegate(InterfaceC1764e2 interfaceC1764e2) {
        this.A02 = interfaceC1764e2;
    }
}
