package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.media3.common.C;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.6x, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class ViewOnClickListenerC07906x extends PZ implements View.OnClickListener, View.OnTouchListener {
    public static int A09;
    public static int A0A;
    public static int A0B;
    public static int A0C;
    public static int A0D;
    public static byte[] A0E;
    public static String[] A0F = {"KCgVVt0Ap7UjFwdZVPwtujaSBd4wOGh", "pwlBzpehZvT0dx09nfsqJf3x9Ohs0th5", "vfZ4vr2K2y2ARDvqPAWs6IAB7KSzcYkK", "bFCbuQIkoS9nYpv83ewRiG67IWanvmGf", "GLbAB0S4L", "VAKU94yPMVJGstkAs9GlkzAfXtUrDcQU", "ELeO8zIeBErz", "BBoYkiBeDILGrcaYIrD29JxsdoJmJVn4"};
    public int A00;
    public int A01;
    public VI A02;
    public boolean A03;
    public final int A04;
    public final Handler A05;
    public final InputMethodManager A06;
    public final Runnable A07;
    public final String A08;

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A0F[6].length() != 12) {
                throw new RuntimeException();
            }
            A0F[6] = "rGUQ6sPwqM0P";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 26);
            i4++;
        }
    }

    public static void A09() {
        A0E = new byte[]{94, 81, 84, 94, 86, 98, 78, 82, 72, 79, 94, 88, 36, 40, 42, 105, 33, 38, 36, 34, 37, 40, 40, 44, 105, 38, 35, 52, 105, 37, 38, 41, 41, 34, 53, 105, 36, 43, 46, 36, 44, 34, 35, 118, 122, 120, 59, 115, 116, 118, 112, 119, 122, 122, 126, 59, 116, 113, 102, 59, 124, 123, 97, 112, 103, 102, 97, 124, 97, 124, 116, 121, 59, 118, 121, 124, 118, 126, 112, 113, 2, Ascii.SO, Ascii.FF, 79, 7, 0, 2, 4, 3, Ascii.SO, Ascii.SO, 10, 79, 0, 5, Ascii.DC2, 79, Ascii.SI, 0, Ascii.NAK, 8, Ascii.ETB, 4, 79, 0, 5, 62, 2, Ascii.CR, 8, 2, 10, 53, 50, 44, 41, 40, 3, 49, 57, 40, 52, 51, 56, Ascii.RS, Ascii.CAN, Ascii.SO, Ascii.EM, 52, 9, Ascii.RS, Ascii.CR, Ascii.CR, Ascii.SO, Ascii.EM, Ascii.SO, Ascii.SI, 52, 8, 7, 2, 8, 0, 52, 2, 10, 9, 52, 8, 7, 2, 8, 0, Ascii.CAN, 81, 87, 65, 86, 123, 70, 81, 66, 66, 65, 86, 65, SignedBytes.MAX_POWER_OF_TWO, 123, 71, 72, 77, 71, 79, 123, 77, 69, 70, 123, 80, 93, 84, 77, 74, 67};
    }

    static {
        A09();
        A0B = 450;
        A09 = 500;
        A0A = 50;
        A0D = 450;
        A0C = 150;
    }

    public ViewOnClickListenerC07906x(C1291Re c1291Re, C1929gi c1929gi, VA va, InterfaceC1470Yh interfaceC1470Yh, String str, int i) {
        super(c1291Re, c1929gi, va, interfaceC1470Yh, false);
        this.A00 = 0;
        this.A01 = 0;
        this.A03 = false;
        this.A07 = new RunnableC1473Yk(this);
        this.A08 = str;
        this.A05 = new Handler(Looper.getMainLooper());
        this.A06 = (InputMethodManager) c1929gi.getSystemService(A05(112, 12, 70));
        this.A04 = i;
    }

    public static /* synthetic */ int A02(ViewOnClickListenerC07906x viewOnClickListenerC07906x) {
        int i = viewOnClickListenerC07906x.A00;
        viewOnClickListenerC07906x.A00 = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06() {
        YB.A0N(this, C.ENCODING_PCM_32BIT_BIG_ENDIAN);
    }

    private void A07() {
        if (this.A08 == null) {
            return;
        }
        if (AdPlacementType.BANNER.name().equals(this.A08)) {
            super.A08.A0E(A05(12, 31, 93), null);
            return;
        }
        if (AdPlacementType.NATIVE.name().equals(this.A08)) {
            super.A08.A0E(A05(80, 32, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), null);
        } else if (AdPlacementType.INTERSTITIAL.name().equals(this.A08)) {
            super.A08.A0E(A05(43, 37, 15), null);
        } else {
            if (!AdPlacementType.REWARDED_VIDEO.name().equals(this.A08)) {
                return;
            }
            super.A08.A0E(EnumC1822ez.A04.A03(), null);
        }
    }

    private void A08() {
        YB.A0N(this, 0);
    }

    public static /* synthetic */ boolean A0B(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.PZ
    public final InterfaceC1567aq A0F() {
        return new C1242Pd(this);
    }

    @Override // com.instagram.common.viewpoint.core.PZ
    public final void A0G() {
        YB.A0N(this, C.ENCODING_PCM_32BIT_BIG_ENDIAN);
        setPadding(getResources().getConfiguration().orientation);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{A0A, A0A, A0A, A0A, 0.0f, 0.0f, 0.0f, 0.0f});
        gradientDrawable.setColor(-1);
        super.A07.setBackground(gradientDrawable);
        super.A07.setOnTouchListener(new View.OnTouchListener() { // from class: com.facebook.ads.redexgen.X.Yj
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ViewOnClickListenerC07906x.A0B(view, motionEvent);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        addView(super.A07, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, super.A07.getId());
        layoutParams2.addRule(12);
        this.A0E.setBackgroundColor(-1);
        addView(this.A0E, layoutParams2);
        this.A0E.setOnTouchListener(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (PZ.A0I * XX.A02));
        layoutParams3.addRule(3, super.A07.getId());
        this.A0C.setProgress(0);
        addView(this.A0C, layoutParams3);
        A06();
        this.A0B.A45(this, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.instagram.common.viewpoint.core.PZ
    public final void A0H() {
        A08();
        super.A08.A05().overridePendingTransition(0, 0);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, Resources.getSystem().getDisplayMetrics().heightPixels);
        translateAnimation.setDuration(A09);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new AnimationAnimationListenerC1475Ym(this));
        startAnimation(translateAnimation);
    }

    @Override // com.instagram.common.viewpoint.core.PZ
    public final void A0I(String str) {
        if (this.A04 > 0 && !this.A03) {
            this.A03 = true;
            this.A05.removeCallbacksAndMessages(null);
            Map<String, String> A05 = new C1586b9().A03(null).A02(null).A05();
            A05.put(A05(0, 12, 39), str);
            if (this.A02 != null) {
                this.A02.A04(VH.A0J, A05);
            }
            A07();
            this.A0A.ABM(super.A04, A05);
            if (C1379Up.A2U(this.A09)) {
                HashMap hashMap = new HashMap();
                hashMap.put(AbstractC2133kH.A04, Boolean.TRUE.toString());
                hashMap.put(AbstractC2133kH.A05, Boolean.TRUE.toString());
                hashMap.put(AbstractC2133kH.A06, Boolean.TRUE.toString());
                this.A0A.ABn(super.A04, hashMap);
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.PZ, com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void AAu(Intent intent, Bundle bundle, C1291Re c1291Re) {
        super.AAu(intent, bundle, c1291Re);
        this.A02 = new VI(super.A04, this.A0A);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        A08();
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, Resources.getSystem().getDisplayMetrics().heightPixels, 0.0f);
        translateAnimation.setDuration(A0B);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new AnimationAnimationListenerC1474Yl(this));
        startAnimation(translateAnimation);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (WU.A02(this)) {
            return;
        }
        try {
            A0H();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setPadding(configuration.orientation);
    }

    @Override // com.instagram.common.viewpoint.core.PZ, com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void onDestroy() {
        super.onDestroy();
        this.A05.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (this.A06 == null) {
                    return false;
                }
                InputMethodManager inputMethodManager = this.A06;
                if (A0F[1].charAt(4) != 'z') {
                    throw new RuntimeException();
                }
                A0F[6] = "wSSlTu5XSXtb";
                if (!inputMethodManager.isAcceptingText()) {
                    return false;
                }
                A0I(A05(154, 30, 62));
                return false;
            case 1:
                this.A01++;
                if (this.A01 < 5) {
                    return false;
                }
                A0I(A05(Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 30, 113));
                return false;
            default:
                return false;
        }
    }

    private void setPadding(int i) {
        if (i == 2) {
            setPadding(0, A0C, 0, 0);
        } else {
            setPadding(0, A0D, 0, 0);
        }
    }
}
