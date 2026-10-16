package com.instagram.common.viewpoint.core;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.It, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1077It extends AbstractC1575ay {
    public static byte[] A01;
    public static String[] A02 = {"Hi1Kp4OvuN0Mi1seIlZSQ9fXUMjjvE9p", "a9aQz404TSolCr57kPPHO7UwC5OuSOzH", "iZ3", "0R4wIBceXoURlcuySRfEAV2VVdZMdToQ", "Pns5aPZ6VZAIHBBYLIEekDbTjPHG0hEC", "QEtpGmawVai8H8emaUXHDe6205ss7rIx", "CSF", "KC7cPyOdjWwnXiGHMOi8VSLb8GeuOYES"};
    public final /* synthetic */ C1713dC A00;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 28);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-44, -23, -34, -47, -35, -39, -45, -49, -29, -44, -37, -49, -36, -47, -23, -43, -30, -49, -45, -33, -34, -28, -43, -34, -28, -49, -40, -43, -39, -41, -40, -28, -53, -32, -43, -56, -44, -48, -54, -58, -38, -53, -46, -58, -45, -56, -32, -52, -39, -58, -54, -42, -43, -37, -52, -43, -37, -58, -34, -48, -53, -37, -49};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int dynamicWebViewWidth = getDynamicWebViewWidth();
        int dynamicWebViewHeight = getDynamicWebViewHeight();
        if (dynamicWebViewWidth <= 0 || dynamicWebViewHeight <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        float f = dynamicWebViewWidth / dynamicWebViewHeight;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z = mode != 1073741824;
        boolean z2 = mode2 != 1073741824;
        int i3 = getResources().getDisplayMetrics().widthPixels;
        int i4 = getResources().getDisplayMetrics().heightPixels;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            i4 = Integer.MAX_VALUE;
            i3 = viewGroup.getWidth() != 0 ? viewGroup.getWidth() : Integer.MAX_VALUE;
            if (viewGroup.getHeight() != 0) {
                i4 = viewGroup.getHeight();
            }
        }
        int A00 = A00(dynamicWebViewWidth, i3, i);
        int A002 = A00(dynamicWebViewHeight, i4, i2);
        if ((z2 || z) && Math.abs((A00 / A002) - f) > 1.0E-7d) {
            boolean z3 = false;
            if (z2) {
                A002 = (int) (A00 / f);
                z3 = true;
            }
            if (!z3 && z) {
                float f2 = A002 * f;
                if (A02[4].charAt(14) == 'W') {
                    throw new RuntimeException();
                }
                A02[4] = "z0LYwU9eQuMrdS04YY6f4w1GT5TpPfvp";
                A00 = (int) f2;
            }
        }
        setMeasuredDimension(A00, A002);
    }

    static {
        A02();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1077It(C1713dC c1713dC, C1929gi c1929gi) {
        super(c1929gi);
        this.A00 = c1713dC;
        getSettings().setAllowFileAccess(true);
        setBackgroundColor(0);
    }

    private int A00(int i, int i2, int i3) {
        int specMode = View.MeasureSpec.getMode(i3);
        int result = View.MeasureSpec.getSize(i3);
        switch (specMode) {
            case Integer.MIN_VALUE:
                int min = Math.min(i, result);
                String[] strArr = A02;
                String str = strArr[0];
                String str2 = strArr[7];
                int specMode2 = str.charAt(6);
                if (specMode2 != str2.charAt(6)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[6] = "m6i";
                strArr2[2] = "Lyc";
                return Math.min(min, i2);
            case 0:
                return Math.min(i, i2);
            case 1073741824:
                return result;
            default:
                return i;
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1575ay
    public final WebChromeClient A0G() {
        return new C1708d7(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1575ay
    public final WebViewClient A0H() {
        return new C1709d8(this.A00);
    }

    private int getDynamicWebViewHeight() {
        AbstractC2094jd abstractC2094jd;
        abstractC2094jd = this.A00.A09;
        return abstractC2094jd.A1H().optInt(A01(0, 32, 84));
    }

    private int getDynamicWebViewWidth() {
        AbstractC2094jd abstractC2094jd;
        abstractC2094jd = this.A00.A09;
        return abstractC2094jd.A1H().optInt(A01(32, 31, 75));
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        InterfaceC1702d1 interfaceC1702d1;
        InterfaceC1702d1 interfaceC1702d12;
        interfaceC1702d1 = this.A00.A02;
        if (interfaceC1702d1 != null) {
            interfaceC1702d12 = this.A00.A02;
            interfaceC1702d12.AGC(this, motionEvent);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (A02[1].charAt(18) != 'P') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[0] = "8G0frzOI4hnuLOXw8ofdNPqhqb4ZK9tq";
        strArr[7] = "WF4GKlO7gB8U235davoNaDl6h9NjfHA4";
        return onTouchEvent;
    }
}
