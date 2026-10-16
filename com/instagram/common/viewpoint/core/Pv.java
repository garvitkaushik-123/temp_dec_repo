package com.instagram.common.viewpoint.core;

import adn.analytics.Analytics;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager$DecorView;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager$SavedState;
import com.facebook.ads.internal.util.parcelable.WrappedParcelable;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public class Pv extends ViewGroup {
    public static byte[] A0s;
    public static String[] A0t = {"e0WzfCgg5XcVfGi", "ISw7K0NC0JjGKw3aqLZnEeCyQmnJarTP", "Hy7VicQaJFFlWaz3OdTjA4ZWS7Vff8v7", "WcFZxi67WO2ZtzqmgJX02c4dryVYoE5T", "rF0iooiSTOADQgiXw4j324HAbDkNAAle", "vgT88YiEWUZNicvmty9GpsXkAZSLF8rx", "LdGmA2eGd1B3SK0OmViQAh3pNWcZcixS", "9ZqOeGgvX4TfhHbWbTIbZxI4Pt81j06N"};
    public static final int[] A0u;
    public static final Interpolator A0v;
    public static final C1257Pu A0w;
    public static final Comparator<C1250Pn> A0x;
    public int A00;
    public PS A01;
    public float A02;
    public float A03;
    public float A04;
    public float A05;
    public float A06;
    public float A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public int A0G;
    public int A0H;
    public int A0I;
    public int A0J;
    public int A0K;
    public int A0L;
    public int A0M;
    public int A0N;
    public int A0O;
    public int A0P;
    public int A0Q;
    public int A0R;
    public Drawable A0S;
    public Parcelable A0T;
    public VelocityTracker A0U;
    public EdgeEffect A0V;
    public EdgeEffect A0W;
    public Scroller A0X;
    public InterfaceC1253Pq A0Y;
    public C1255Ps A0Z;
    public ClassLoader A0a;
    public ArrayList<View> A0b;
    public List<ViewPager.OnAdapterChangeListener> A0c;
    public List<InterfaceC1253Pq> A0d;
    public boolean A0e;
    public boolean A0f;
    public boolean A0g;
    public boolean A0h;
    public boolean A0i;
    public boolean A0j;
    public boolean A0k;
    public boolean A0l;
    public boolean A0m;
    public boolean A0n;
    public final Rect A0o;
    public final C1250Pn A0p;
    public final Runnable A0q;
    public final ArrayList<C1250Pn> A0r;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 12 out of bounds for length 12
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private C1250Pn A03() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f = clientWidth > 0 ? this.A0M / clientWidth : 0.0f;
        int i = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        boolean z = true;
        C1250Pn c1250Pn = null;
        int i2 = 0;
        while (i2 < this.A0r.size()) {
            C1250Pn c1250Pn2 = this.A0r.get(i2);
            if (!z && c1250Pn2.A02 != i + 1) {
                c1250Pn2 = this.A0p;
                c1250Pn2.A00 = f2 + f3 + f;
                c1250Pn2.A02 = i + 1;
                c1250Pn2.A01 = this.A01.A00(c1250Pn2.A02);
                i2--;
            }
            f2 = c1250Pn2.A00;
            float f4 = c1250Pn2.A01 + f2;
            String[] strArr = A0t;
            if (strArr[4].charAt(21) != strArr[2].charAt(21)) {
                throw new RuntimeException();
            }
            A0t[0] = "anv8UthCgv3bxkb";
            float f5 = f4 + f;
            if (!z && scrollX < f2) {
                return c1250Pn;
            }
            if (scrollX < f5 || i2 == this.A0r.size() - 1) {
                return c1250Pn2;
            }
            z = false;
            i = c1250Pn2.A02;
            f3 = c1250Pn2.A01;
            c1250Pn = c1250Pn2;
            i2++;
        }
        return c1250Pn;
    }

    public static String A08(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0s, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 113);
        }
        return new String(copyOfRange);
    }

    public static void A0C() {
        A0s = new byte[]{-32, -3, -2, -32, -6, 42, 59, 65, 63, 76, -6, Base64.padSymbol, 70, 59, 77, 77, Ascii.DC4, -6, -88, -40, -23, -17, -19, -6, -88, -15, -20, -62, -88, Ascii.VT, 59, 93, 90, 77, 87, 80, 88, 76, 95, 84, 78, Ascii.VT, 76, 79, 76, 91, 95, 80, 93, 37, Ascii.VT, -66, Ascii.DC2, Ascii.CR, Ascii.CR, -66, 17, Ascii.VT, -1, 10, 10, -39, -66, 2, 3, 4, -1, 19, 10, Ascii.DC2, 7, Ascii.FF, 5, -66, Ascii.DC2, Ascii.CR, -66, Ascii.DLE, 4, 74, 83, 89, 82, 72, Ascii.RS, 4, -49, -19, -6, -6, -5, 0, -84, -19, -16, -16, -84, -4, -19, -13, -15, -2, -84, -16, -15, -17, -5, -2, -84, 2, -11, -15, 3, -84, -16, 1, -2, -11, -6, -13, -84, -8, -19, 5, -5, 1, 0, Base64.padSymbol, 80, 92, 96, 80, 94, 95, 80, 79, Ascii.VT, 90, 81, 81, 94, 78, 93, 80, 80, 89, Ascii.VT, 91, 76, 82, 80, Ascii.VT, 87, 84, 88, 84, 95, Ascii.VT, -57, -37, -40, -109, -44, -29, -29, -33, -36, -42, -44, -25, -36, -30, -31, -102, -26, -109, -61, -44, -38, -40, -27, -76, -41, -44, -29, -25, -40, -27, -109, -42, -37, -44, -31, -38, -40, -41, -109, -25, -37, -40, -109, -44, -41, -44, -29, -25, -40, -27, -102, -26, -109, -42, -30, -31, -25, -40, -31, -25, -26, -109, -22, -36, -25, -37, -30, -24, -25, -109, -42, -44, -33, -33, -36, -31, -38, -109, -61, -44, -38, -40, -27, -76, -41, -44, -29, -25, -40, -27, -106, -31, -30, -25, -36, -39, -20, -73, -44, -25, -44, -58, -40, -25, -74, -37, -44, -31, -38, -40, -41, -108, -109, -72, -21, -29, -40, -42, -25, -40, -41, -109, -44, -41, -44, -29, -25, -40, -27, -109, -36, -25, -40, -32, -109, -42, -30, -24, -31, -25, -83, -109, Ascii.DLE, 35, Ascii.US, 49, 10, Ascii.ESC, 33, Ascii.US, 44, -3, Ascii.SO, Ascii.SO, Ascii.VT, 19, -17, -1, Ascii.SO, Ascii.VT, 8, 8, -68, Ascii.DLE, Ascii.SO, 5, 1, 0, -68, Ascii.DLE, Ascii.VT, -68, 2, 5, 10, 0, -68, 2, Ascii.VT, -1, 17, Ascii.SI, -68, -2, -3, Ascii.SI, 1, 0, -68, Ascii.VT, 10, -68, 10, Ascii.VT, 10, -55, -1, 4, 5, 8, 0, -68, -1, 17, Ascii.SO, Ascii.SO, 1, 10, Ascii.DLE, -68, 2, Ascii.VT, -1, 17, Ascii.SI, 1, 0, -68, Ascii.DC2, 5, 1, 19, -68, 67, 66, Ascii.NAK, 56, 53, 68, 72, 57, 70, Ascii.ETB, 60, 53, 66, 59, 57, 56, 1, 0, -30, -13, -7, -9, -27, -11, 4, 1, -2, -2, -9, -10, -78, -10, -5, -10, -78, 0, 1, 6, -78, -11, -13, -2, -2, -78, 5, 7, 2, -9, 4, -11, -2, -13, 5, 5, -78, -5, -1, 2, -2, -9, -1, -9, 0, 6, -13, 6, -5, 1, 0, 96, 94, 77, 90, 95, 82, 91, 94, 89, 60, 77, 83, 81};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 21 out of bounds for length 17
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:147)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private final void A0J(int i, int i2, int i3) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if ((this.A0X == null || this.A0X.isFinished()) ? false : true) {
            scrollX = this.A0j ? this.A0X.getCurrX() : this.A0X.getStartX();
            this.A0X.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        if (A0t[6].charAt(18) == '5') {
            throw new RuntimeException();
        }
        String[] strArr = A0t;
        strArr[4] = "Z0LZClJ0au8nSBm1r5wZo4UlFxtb531d";
        strArr[2] = "ZltNMTIOlLDzNXpQzZy3241df7YiJdYF";
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            A0R(false);
            A0f();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float A00 = i6 + (i6 * A00(Math.min(1.0f, (Math.abs(i4) * 1.0f) / clientWidth)));
        int abs = Math.abs(i3);
        int min = Math.min(abs > 0 ? Math.round(Math.abs(A00 / abs) * 1000.0f) * 4 : (int) ((1.0f + (Math.abs(i4) / (this.A0M + (clientWidth * this.A01.A00(this.A00))))) * 100.0f), 600);
        this.A0j = false;
        this.A0X.startScroll(scrollX, scrollY, i4, i5, min);
        Ph.A07(this);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 6
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList<View> arrayList) {
        C1250Pn A07;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (A07 = A07(childAt)) != null && A07.A02 == this.A00) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 18
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ef  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        C1251Po c1251Po;
        C1251Po c1251Po2;
        boolean z;
        int i3;
        int i4;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.A0I = Math.min(measuredWidth / 10, this.A0E);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8 && (c1251Po2 = (C1251Po) childAt.getLayoutParams()) != null && c1251Po2.A05) {
                int i6 = c1251Po2.A04 & 7;
                int i7 = c1251Po2.A04 & 112;
                int i8 = Integer.MIN_VALUE;
                int i9 = Integer.MIN_VALUE;
                boolean z2 = i7 == 48 || i7 == 80;
                if (i6 != 3) {
                    if (A0t[0].length() != 15) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0t;
                    strArr[1] = "9a0FyoC52B3yBXBi2GxtutV5LsdNQe1M";
                    strArr[7] = "xl5cJkQWQfSP6Zwlt45arSi0METJpEUG";
                    if (i6 != 5) {
                        z = false;
                        if (!z2) {
                            i8 = 1073741824;
                        } else if (z) {
                            i9 = 1073741824;
                        }
                        if (c1251Po2.width == -2) {
                            i8 = 1073741824;
                            i3 = c1251Po2.width != -1 ? c1251Po2.width : paddingLeft;
                        } else {
                            i3 = paddingLeft;
                        }
                        if (c1251Po2.height == -2) {
                            i9 = 1073741824;
                            i4 = c1251Po2.height != -1 ? c1251Po2.height : measuredHeight;
                        } else {
                            i4 = measuredHeight;
                        }
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, i8), View.MeasureSpec.makeMeasureSpec(i4, i9));
                        if (!z2) {
                            int measuredHeight2 = childAt.getMeasuredHeight();
                            if (A0t[0].length() != 15) {
                                measuredHeight -= measuredHeight2;
                            } else {
                                A0t[6] = "EqasZ8zwVhCwMRvet1jUrx6TZdyGyQkK";
                                measuredHeight -= measuredHeight2;
                            }
                        } else if (z) {
                            paddingLeft -= childAt.getMeasuredWidth();
                        }
                    }
                }
                z = true;
                if (!z2) {
                }
                if (c1251Po2.width == -2) {
                }
                if (c1251Po2.height == -2) {
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, i8), View.MeasureSpec.makeMeasureSpec(i4, i9));
                if (!z2) {
                }
            }
        }
        this.A0B = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.A0A = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.A0h = true;
        A0f();
        this.A0h = false;
        int childCount2 = getChildCount();
        for (int i10 = 0; i10 < childCount2; i10++) {
            View childAt2 = getChildAt(i10);
            if (childAt2.getVisibility() != 8 && ((c1251Po = (C1251Po) childAt2.getLayoutParams()) == null || !c1251Po.A05)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * c1251Po.A00), 1073741824), this.A0A);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0162, code lost:
    
        if (r5 > r9.A0R) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0166, code lost:
    
        if (r5 <= r1) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0168, code lost:
    
        r9.A0i = true;
        A0T(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0173, code lost:
    
        if ((r7 - r9.A03) <= 0.0f) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0175, code lost:
    
        r1 = r9.A03 + r9.A0R;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x017b, code lost:
    
        r9.A05 = r1;
        r9.A06 = r2;
        r2 = com.instagram.common.viewpoint.core.Pv.A0t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0191, code lost:
    
        if (r2[4].charAt(21) == r2[2].charAt(21)) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01c6, code lost:
    
        r2 = com.instagram.common.viewpoint.core.Pv.A0t;
        r2[5] = "e7fI1kGLNvpqtNm7aDmxtkJeXMvTP5FY";
        r2[3] = "XvYFrHQXjTrYZxGmpAYONm66bvHDiRqC";
        setScrollState(1);
        setScrollingCacheEnabled(true);
        r0 = getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01dc, code lost:
    
        if (r0 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01de, code lost:
    
        r0.requestDisallowInterceptTouchEvent(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0199, code lost:
    
        r1 = r9.A03 - r9.A0R;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01c3, code lost:
    
        if (r5 > r9.A0R) goto L45;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 16 out of bounds for length 11
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:147)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01f6  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        float abs;
        float y;
        float abs2;
        if (this.A0f) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        PS ps = this.A01;
        String[] strArr = A0t;
        if (strArr[1].charAt(20) != strArr[7].charAt(20)) {
            A0t[0] = "LvXhlgkzmvNssd6";
            if (ps == null || this.A01.A01() == 0) {
                return false;
            }
            if (this.A0U == null) {
                this.A0U = VelocityTracker.obtain();
            }
            this.A0U.addMovement(motionEvent);
            boolean z = false;
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.A0X.abortAnimation();
                    this.A0m = false;
                    A0f();
                    float x = motionEvent.getX();
                    this.A03 = x;
                    this.A05 = x;
                    float y2 = motionEvent.getY();
                    this.A04 = y2;
                    this.A06 = y2;
                    this.A08 = motionEvent.getPointerId(0);
                    if (z) {
                        Ph.A07(this);
                    }
                    return true;
                case 1:
                    if (this.A0i) {
                        VelocityTracker velocityTracker = this.A0U;
                        velocityTracker.computeCurrentVelocity(1000, this.A0J);
                        int xVelocity = (int) velocityTracker.getXVelocity(this.A08);
                        this.A0m = true;
                        int clientWidth = getClientWidth();
                        int scrollX = getScrollX();
                        C1250Pn A03 = A03();
                        A0O(A01(A03.A02, ((scrollX / clientWidth) - A03.A00) / (A03.A01 + (this.A0M / clientWidth)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.A08)) - this.A03)), true, true, xVelocity);
                        z = A0U();
                    }
                    if (z) {
                    }
                    return true;
                case 2:
                    if (!this.A0i) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.A08);
                        if (findPointerIndex != -1) {
                            float x2 = motionEvent.getX(findPointerIndex);
                            float f = this.A05;
                            if (A0t[6].charAt(18) == '5') {
                                String[] strArr2 = A0t;
                                strArr2[4] = "ontN6EF9kNoPk4JOa0rpD46Vxb17myeK";
                                strArr2[2] = "q3u6R9yrNwStVG1gWFMVX4nkPMMF7Bi5";
                                abs = Math.abs(x2 - f);
                                y = motionEvent.getY(findPointerIndex);
                                abs2 = Math.abs(y - this.A06);
                                break;
                            } else {
                                A0t[6] = "4VLsr63NxXDsBxSO9qPsxtMfhqSOrFpj";
                                abs = Math.abs(x2 - f);
                                y = motionEvent.getY(findPointerIndex);
                                abs2 = Math.abs(y - this.A06);
                                break;
                            }
                        } else {
                            z = A0U();
                            if (z) {
                            }
                            return true;
                        }
                    }
                    if (this.A0i) {
                        z = false | A0X(motionEvent.getX(motionEvent.findPointerIndex(this.A08)));
                    }
                    if (z) {
                    }
                    return true;
                case 3:
                    if (this.A0i) {
                        A0M(this.A00, true, 0, false);
                        String[] strArr3 = A0t;
                        if (strArr3[1].charAt(20) == strArr3[7].charAt(20)) {
                            throw new RuntimeException();
                        }
                        A0t[0] = "8Tm9By8OJxOMqui";
                        z = A0U();
                    }
                    if (z) {
                    }
                    return true;
                case 4:
                default:
                    if (z) {
                    }
                    return true;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    this.A05 = motionEvent.getX(actionIndex);
                    this.A08 = motionEvent.getPointerId(actionIndex);
                    if (z) {
                    }
                    return true;
                case 6:
                    A0P(motionEvent);
                    this.A05 = motionEvent.getX(motionEvent.findPointerIndex(this.A08));
                    if (z) {
                    }
                    return true;
            }
        }
        throw new RuntimeException();
    }

    static {
        A0C();
        A0u = new int[]{R.attr.layout_gravity};
        A0x = new C1247Pj();
        A0v = new InterpolatorC1248Pk();
        A0w = new C1257Pu();
    }

    public Pv(Context context) {
        super(context);
        this.A0r = new ArrayList<>();
        this.A0p = new C1250Pn();
        this.A0o = new Rect();
        this.A0O = -1;
        this.A0T = null;
        this.A0a = null;
        this.A02 = -3.4028235E38f;
        this.A07 = Float.MAX_VALUE;
        this.A0L = 1;
        this.A08 = -1;
        this.A0g = true;
        this.A0l = false;
        this.A0q = new RunnableC1249Pl(this);
        this.A0P = 0;
        A0D();
    }

    private final float A00(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    private int A01(int i, float f, int i2, int i3) {
        if (Math.abs(i3) > this.A0H && Math.abs(i2) > this.A0K) {
            if (i2 <= 0) {
                i++;
            }
        } else {
            int targetPage = this.A00;
            float truncator = i >= targetPage ? 0.4f : 0.6f;
            i = ((int) (f + truncator)) + i;
        }
        int targetPage2 = this.A0r.size();
        if (targetPage2 > 0) {
            C1250Pn lastItem = this.A0r.get(0);
            ArrayList<C1250Pn> arrayList = this.A0r;
            int targetPage3 = this.A0r.size();
            C1250Pn c1250Pn = arrayList.get(targetPage3 - 1);
            int i4 = lastItem.A02;
            int targetPage4 = c1250Pn.A02;
            return Math.max(i4, Math.min(i, targetPage4));
        }
        return i;
    }

    private Rect A02(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            int i = rect.bottom;
            String[] strArr = A0t;
            if (strArr[5].charAt(3) == strArr[3].charAt(3)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0t;
            strArr2[5] = "TxsWzRbkVVm53KJb0hYxYLTaFP4RvuCR";
            strArr2[3] = "7IWTmTKlEE0GT3GusYYvAPWFxogbhPhf";
            rect.bottom = i + viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final C1250Pn A04(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            C1250Pn c1250Pn = this.A0r.get(i2);
            int i3 = c1250Pn.A02;
            if (A0t[6].charAt(18) == '5') {
                throw new RuntimeException();
            }
            String[] strArr = A0t;
            strArr[5] = "FTW8lMLV1WF1uT7A98mx1WW44JTpX4mD";
            strArr[3] = "8smTuGxWqqiqky02WbAruJcj0nAU8eAT";
            if (i3 == i) {
                return c1250Pn;
            }
        }
        return null;
    }

    private final C1250Pn A05(int i, int i2) {
        C1250Pn c1250Pn = new C1250Pn();
        c1250Pn.A02 = i;
        c1250Pn.A03 = this.A01.A04(this, i);
        c1250Pn.A01 = this.A01.A00(i);
        if (i2 < 0 || i2 >= this.A0r.size()) {
            this.A0r.add(c1250Pn);
        } else {
            this.A0r.add(i2, c1250Pn);
        }
        return c1250Pn;
    }

    private final C1250Pn A06(View view) {
        while (true) {
            Object parent = view.getParent();
            if (A0t[0].length() != 15) {
                throw new RuntimeException();
            }
            String[] strArr = A0t;
            strArr[4] = "Cp8HLsoEDfOeEYMqWHrr049HoHROoinV";
            strArr[2] = "T0VfZL8wtEwZV1iGxV5Hd4QPubsH4Hu8";
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return A07(view);
            }
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final C1250Pn A07(View view) {
        for (int i = 0; i < i; i++) {
            C1250Pn c1250Pn = this.A0r.get(i);
            if (this.A01.A08(view, c1250Pn.A03)) {
                return c1250Pn;
            }
        }
        return null;
    }

    private void A09() {
        this.A0i = false;
        this.A0k = false;
        if (this.A0U != null) {
            this.A0U.recycle();
            this.A0U = null;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0A() {
        int i = 0;
        while (i < i) {
            if (!((C1251Po) getChildAt(i).getLayoutParams()).A05) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private void A0B() {
        if (this.A0F != 0) {
            if (this.A0b == null) {
                this.A0b = new ArrayList<>();
            } else {
                this.A0b.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.A0b.add(getChildAt(i));
            }
            Collections.sort(this.A0b, A0w);
        }
    }

    private final void A0D() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.A0X = new Scroller(context, A0v);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.A0R = viewConfiguration.getScaledPagingTouchSlop();
        this.A0K = (int) (400.0f * f);
        this.A0J = viewConfiguration.getScaledMaximumFlingVelocity();
        this.A0V = new EdgeEffect(context);
        this.A0W = new EdgeEffect(context);
        this.A0H = (int) (25.0f * f);
        this.A0C = (int) (2.0f * f);
        this.A0E = (int) (16.0f * f);
        Ph.A0B(this, new C2008i1(this));
        if (Ph.A00(this) == 0) {
            Ph.A09(this, 1);
        }
        Ph.A0C(this, new C2009i2(this));
    }

    private void A0E(int i) {
        List<InterfaceC1253Pq> list = this.A0d;
        String[] strArr = A0t;
        if (strArr[5].charAt(3) == strArr[3].charAt(3)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0t;
        strArr2[1] = "BVTy00cMA02UZPGNllJjIH3AYkDj1BkJ";
        strArr2[7] = "OotLKoFjxgYdGdzuGdwdV1ikaCSVhdo5";
        if (list != null) {
            int z = this.A0d.size();
            for (int i2 = 0; i2 < z; i2++) {
                this.A0d.get(i2);
            }
        }
    }

    private void A0F(int i) {
        if (this.A0d != null) {
            int z = this.A0d.size();
            for (int i2 = 0; i2 < z; i2++) {
                this.A0d.get(i2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01a4, code lost:
    
        if (r10 < r12) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01a6, code lost:
    
        r12 = r16.A0r.get(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01b9, code lost:
    
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01b6, code lost:
    
        if (r10 < r12) goto L92;
     */
    /* JADX WARN: Incorrect condition in loop: B:167:0x0294 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void A0G(int i) {
        String hexString;
        C1250Pn c1250Pn;
        C1250Pn A07;
        C1250Pn c1250Pn2;
        float f;
        C1250Pn ii;
        float leftWidthNeeded;
        C1250Pn c1250Pn3 = null;
        if (this.A00 != i) {
            c1250Pn3 = A04(this.A00);
            this.A00 = i;
        }
        if (this.A01 == null) {
            A0B();
            return;
        }
        if (this.A0m) {
            A0B();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        int i2 = this.A0L;
        int pos = Math.max(0, this.A00 - i2);
        int N = this.A01.A01();
        int startPos = Math.min(N - 1, this.A00 + i2);
        if (N == this.A0G) {
            C1250Pn ii2 = null;
            int i3 = 0;
            while (true) {
                int curIndex = this.A0r.size();
                if (i3 >= curIndex) {
                    break;
                }
                C1250Pn c1250Pn4 = this.A0r.get(i3);
                int i4 = c1250Pn4.A02;
                int curIndex2 = this.A00;
                if (i4 >= curIndex2) {
                    int i5 = c1250Pn4.A02;
                    int curIndex3 = this.A00;
                    if (i5 == curIndex3) {
                        ii2 = c1250Pn4;
                    }
                } else {
                    i3++;
                }
            }
            if (ii2 == null && N > 0) {
                int curIndex4 = this.A00;
                ii2 = A05(curIndex4, i3);
            }
            if (ii2 != null) {
                float f2 = 0.0f;
                int i6 = i3 - 1;
                if (i6 >= 0) {
                    c1250Pn2 = this.A0r.get(i6);
                } else {
                    c1250Pn2 = null;
                }
                int clientWidth = getClientWidth();
                if (clientWidth <= 0) {
                    f = 0.0f;
                } else {
                    float f3 = 2.0f - ii2.A01;
                    int curIndex5 = getPaddingLeft();
                    f = f3 + (curIndex5 / clientWidth);
                }
                int curIndex6 = this.A00;
                for (int i7 = curIndex6 - 1; i7 >= 0; i7--) {
                    if (f2 >= f && i7 < pos) {
                        if (c1250Pn2 == null) {
                            break;
                        }
                        int curIndex7 = c1250Pn2.A02;
                        if (i7 == curIndex7 && !c1250Pn2.A04) {
                            this.A0r.remove(i6);
                            this.A01.A07(this, i7, c1250Pn2.A03);
                            i6--;
                            i3--;
                            c1250Pn2 = i6 >= 0 ? this.A0r.get(i6) : null;
                        }
                    } else {
                        if (c1250Pn2 != null) {
                            int curIndex8 = c1250Pn2.A02;
                            if (i7 == curIndex8) {
                                f2 += c1250Pn2.A01;
                                i6--;
                                c1250Pn2 = i6 >= 0 ? this.A0r.get(i6) : null;
                            }
                        }
                        int curIndex9 = i6 + 1;
                        float f4 = A05(i7, curIndex9).A01;
                        String[] strArr = A0t;
                        String str = strArr[5];
                        String str2 = strArr[3];
                        int charAt = str.charAt(3);
                        int curIndex10 = str2.charAt(3);
                        if (charAt == curIndex10) {
                            break;
                        }
                        String[] strArr2 = A0t;
                        strArr2[4] = "dloXpWDXOKz7FwqtlWspO43tyknOTTlF";
                        strArr2[2] = "sCPq7B1Nle5jSSIhAv3Hb4nKNO5mS7KT";
                        f2 += f4;
                        i3++;
                        c1250Pn2 = i6 >= 0 ? this.A0r.get(i6) : null;
                    }
                }
                float extraWidthLeft = ii2.A01;
                int itemIndex = i3 + 1;
                if (extraWidthLeft < 2.0f) {
                    int curIndex11 = this.A0r.size();
                    if (itemIndex < curIndex11) {
                        ii = this.A0r.get(itemIndex);
                    } else {
                        ii = null;
                    }
                    if (clientWidth <= 0) {
                        leftWidthNeeded = 0.0f;
                    } else {
                        int curIndex12 = getPaddingRight();
                        float f5 = curIndex12;
                        float rightWidthNeeded = clientWidth;
                        if (A0t[0].length() != 15) {
                            throw new RuntimeException();
                        }
                        String[] strArr3 = A0t;
                        strArr3[5] = "yjiSNpko5C4HRuH1DqNZIljIP1AyIB8Y";
                        strArr3[3] = "4BabcLoEiYQllUHdwQ0JBCE7juXq8SlJ";
                        leftWidthNeeded = (f5 / rightWidthNeeded) + 2.0f;
                    }
                    int curIndex13 = this.A00;
                    for (int i8 = curIndex13 + 1; i8 < N; i8++) {
                        if (extraWidthLeft >= leftWidthNeeded && i8 > startPos) {
                            if (ii == null) {
                                break;
                            }
                            int curIndex14 = ii.A02;
                            if (i8 == curIndex14 && !ii.A04) {
                                this.A0r.remove(itemIndex);
                                this.A01.A07(this, i8, ii.A03);
                                int curIndex15 = this.A0r.size();
                                ii = itemIndex < curIndex15 ? this.A0r.get(itemIndex) : null;
                            }
                        } else {
                            if (ii != null) {
                                int curIndex16 = ii.A02;
                                if (i8 == curIndex16) {
                                    extraWidthLeft += ii.A01;
                                    itemIndex++;
                                    int curIndex17 = this.A0r.size();
                                    if (itemIndex < curIndex17) {
                                        C1250Pn ii3 = this.A0r.get(itemIndex);
                                        String[] strArr4 = A0t;
                                        String str3 = strArr4[5];
                                        String str4 = strArr4[3];
                                        int charAt2 = str3.charAt(3);
                                        int curIndex18 = str4.charAt(3);
                                        if (charAt2 != curIndex18) {
                                            String[] strArr5 = A0t;
                                            strArr5[4] = "IsA4bkdSyqEuCzjIc9UrR46Q3omYxVKd";
                                            strArr5[2] = "uQMdRRPHCTPdIeSYH7tJM435sOxxqF9X";
                                            ii = ii3;
                                        } else {
                                            A0t[0] = "Vvaq8MYPG9MCZuQ";
                                            ii = ii3;
                                        }
                                    } else {
                                        ii = null;
                                    }
                                }
                            }
                            C1250Pn A05 = A05(i8, itemIndex);
                            itemIndex++;
                            extraWidthLeft += A05.A01;
                            int size = this.A0r.size();
                            if (A0t[0].length() == 15) {
                                A0t[0] = "BbpcE6tkf1K6OjJ";
                            }
                        }
                    }
                }
                A0Q(ii2, i3, c1250Pn3);
            }
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                C1251Po c1251Po = (C1251Po) childAt.getLayoutParams();
                c1251Po.A01 = i9;
                if (!c1251Po.A05 && c1251Po.A00 == 0.0f && (A07 = A07(childAt)) != null) {
                    c1251Po.A00 = A07.A01;
                    String[] strArr6 = A0t;
                    String str5 = strArr6[4];
                    String str6 = strArr6[2];
                    int charAt3 = str5.charAt(21);
                    int curIndex19 = str6.charAt(21);
                    if (charAt3 != curIndex19) {
                        throw new RuntimeException();
                    }
                    String[] strArr7 = A0t;
                    strArr7[5] = "EyT6xwfDNG2S3e9LtZYytN0s3Xm8cKUy";
                    strArr7[3] = "L43v13w7qHrePnOf1vJtqhkFr9Wez5bL";
                    int curIndex20 = A07.A02;
                    c1251Po.A02 = curIndex20;
                }
            }
            A0B();
            if (hasFocus()) {
                View findFocus = findFocus();
                if (findFocus != null) {
                    c1250Pn = A06(findFocus);
                } else {
                    c1250Pn = null;
                }
                if (c1250Pn != null) {
                    int i10 = c1250Pn.A02;
                    int curIndex21 = this.A00;
                    if (i10 == curIndex21) {
                        return;
                    }
                }
                for (int i11 = 0; i11 < curIndex; i11++) {
                    View childAt2 = getChildAt(i11);
                    C1250Pn A072 = A07(childAt2);
                    if (A072 != null) {
                        int i12 = A072.A02;
                        int curIndex22 = this.A00;
                        if (i12 == curIndex22 && childAt2.requestFocus(2)) {
                            return;
                        }
                    }
                }
                return;
            }
            return;
        }
        try {
            Resources resources = getResources();
            int curIndex23 = getId();
            hexString = resources.getResourceName(curIndex23);
        } catch (Resources.NotFoundException unused) {
            int curIndex24 = getId();
            hexString = Integer.toHexString(curIndex24);
        }
        StringBuilder sb = new StringBuilder();
        String resName = A08(158, 142, 2);
        StringBuilder append = sb.append(resName).append(this.A0G);
        String resName2 = A08(77, 9, 115);
        StringBuilder append2 = append.append(resName2).append(N);
        String resName3 = A08(18, 11, 23);
        StringBuilder append3 = append2.append(resName3).append(hexString);
        String resName4 = A08(4, 14, 105);
        StringBuilder append4 = append3.append(resName4).append(getClass());
        String resName5 = A08(29, 22, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
        throw new IllegalStateException(append4.append(resName5).append(this.A01.getClass()).toString());
    }

    private void A0H(int i, float f, int i2) {
        if (this.A0d != null) {
            int z = this.A0d.size();
            for (int i3 = 0; i3 < z; i3++) {
                this.A0d.get(i3);
            }
        }
    }

    private final void A0I(int i, float f, int i2) {
        int max;
        if (this.A0D > 0) {
            int childLeft = getScrollX();
            int paddingLeft = getPaddingLeft();
            int childLeft2 = getPaddingRight();
            int hgrav = getWidth();
            int i3 = getChildCount();
            for (int childCount = 0; childCount < i3; childCount++) {
                View childAt = getChildAt(childCount);
                C1251Po lp = (C1251Po) childAt.getLayoutParams();
                int paddingLeft2 = A0t[6].charAt(18);
                if (paddingLeft2 != 53) {
                    A0t[0] = "eLb4kWjiyFzQgYZ";
                    if (lp.A05) {
                        int scrollX = lp.A04;
                        switch (scrollX & 7) {
                            case 1:
                                int scrollX2 = childAt.getMeasuredWidth();
                                max = Math.max((hgrav - scrollX2) / 2, paddingLeft);
                                break;
                            case 2:
                            case 4:
                            default:
                                max = paddingLeft;
                                break;
                            case 3:
                                max = paddingLeft;
                                int scrollX3 = childAt.getWidth();
                                paddingLeft += scrollX3;
                                break;
                            case 5:
                                int scrollX4 = childAt.getMeasuredWidth();
                                max = (hgrav - childLeft2) - scrollX4;
                                int scrollX5 = childAt.getMeasuredWidth();
                                childLeft2 += scrollX5;
                                break;
                        }
                        int scrollX6 = childAt.getLeft();
                        int i4 = (max + childLeft) - scrollX6;
                        String[] strArr = A0t;
                        String str = strArr[4];
                        String str2 = strArr[2];
                        int paddingLeft3 = str.charAt(21);
                        int scrollX7 = str2.charAt(21);
                        if (paddingLeft3 == scrollX7) {
                            String[] strArr2 = A0t;
                            strArr2[5] = "8dfGriTrd9bOdESwE5mGPvbaI7ots8HA";
                            strArr2[3] = "OX1hZuxAiPsPngs8SIDO4tRfQKy4SqJm";
                            if (i4 != 0) {
                                childAt.offsetLeftAndRight(i4);
                            }
                        }
                    }
                }
                throw new RuntimeException();
            }
        }
        A0H(i, f, i2);
        if (0 != 0) {
            getScrollX();
            int childCount2 = getChildCount();
            for (int i5 = 0; i5 < childCount2; i5++) {
                View childAt2 = getChildAt(i5);
                String[] strArr3 = A0t;
                String str3 = strArr3[5];
                String str4 = strArr3[3];
                int childCount3 = str3.charAt(3);
                int scrollX8 = str4.charAt(3);
                if (childCount3 == scrollX8) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A0t;
                strArr4[4] = "xqiTxeHFqkAvCvaAoyIYw4ze8LixE8Bg";
                strArr4[2] = "dxU2iatDRuS97WdbX1MSD4wOgw4tArLe";
                if (!((C1251Po) childAt2.getLayoutParams()).A05) {
                    childAt2.getLeft();
                    getClientWidth();
                    throw new NullPointerException(A08(450, 13, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE));
                }
            }
        }
        this.A0e = true;
    }

    private void A0K(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.A0r.isEmpty()) {
            if (!this.A0X.isFinished()) {
                this.A0X.setFinalX(getCurrentItem() * getClientWidth());
                return;
            }
            int paddingLeft = ((i - getPaddingLeft()) - getPaddingRight()) + i3;
            int widthWithMargin = getPaddingLeft();
            int i5 = i2 - widthWithMargin;
            int widthWithMargin2 = getPaddingRight();
            int i6 = (i5 - widthWithMargin2) + i4;
            int widthWithMargin3 = getScrollX();
            int oldWidthWithMargin = (int) (paddingLeft * (widthWithMargin3 / i6));
            int widthWithMargin4 = getScrollY();
            scrollTo(oldWidthWithMargin, widthWithMargin4);
            return;
        }
        int i7 = this.A00;
        String[] strArr = A0t;
        if (strArr[4].charAt(21) != strArr[2].charAt(21)) {
            throw new RuntimeException();
        }
        A0t[6] = "zbIyuU4nFdtSfTRFogYOf2jKfKMbfeaA";
        C1250Pn ii = A04(i7);
        float scrollOffset = ii != null ? Math.min(ii.A00, this.A07) : 0.0f;
        int paddingLeft2 = (int) (((i - getPaddingLeft()) - getPaddingRight()) * scrollOffset);
        if (paddingLeft2 == getScrollX()) {
            return;
        }
        A0R(false);
        scrollTo(paddingLeft2, getScrollY());
    }

    private final void A0L(int i, boolean z) {
        this.A0m = false;
        A0N(i, z, false);
    }

    private void A0M(int i, boolean z, int i2, boolean z2) {
        C1250Pn A04 = A04(i);
        int destX = 0;
        if (A04 != null) {
            destX = (int) (getClientWidth() * Math.max(this.A02, Math.min(A04.A00, this.A07)));
        }
        if (z) {
            A0J(destX, 0, i2);
            if (z2) {
                A0E(i);
                return;
            }
            return;
        }
        if (z2) {
            A0E(i);
        }
        A0R(false);
        scrollTo(destX, 0);
        A0Z(destX);
    }

    private final void A0N(int i, boolean z, boolean z2) {
        A0O(i, z, z2, 0);
    }

    private final void A0O(int i, boolean z, boolean z2, int i2) {
        if (this.A01 == null || this.A01.A01() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.A00 == i) {
            int size = this.A0r.size();
            String[] strArr = A0t;
            if (strArr[5].charAt(3) == strArr[3].charAt(3)) {
                throw new RuntimeException();
            }
            A0t[0] = "caHeuZPLB8pjODm";
            if (size != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.A01.A01()) {
            i = this.A01.A01() - 1;
        }
        int i3 = this.A0L;
        if (i > this.A00 + i3 || i < this.A00 - i3) {
            for (int i4 = 0; i4 < this.A0r.size(); i4++) {
                this.A0r.get(i4).A04 = true;
            }
        }
        boolean z3 = this.A00 != i;
        boolean dispatchSelected = this.A0g;
        if (dispatchSelected) {
            this.A00 = i;
            if (z3) {
                A0E(i);
            }
            requestLayout();
            return;
        }
        A0G(i);
        A0M(i, z, i2, z3);
    }

    private void A0P(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        int pointerIndex = this.A08;
        if (pointerId != pointerIndex) {
            return;
        }
        int pointerId2 = actionIndex == 0 ? 1 : 0;
        this.A05 = motionEvent.getX(pointerId2);
        int pointerIndex2 = motionEvent.getPointerId(pointerId2);
        this.A08 = pointerIndex2;
        if (this.A0U != null) {
            VelocityTracker velocityTracker = this.A0U;
            int pointerId3 = A0t[6].charAt(18);
            if (pointerId3 == 53) {
                throw new RuntimeException();
            }
            String[] strArr = A0t;
            strArr[4] = "bDxXC3oviTuOT7HziZkEX4OVFsay8yQk";
            strArr[2] = "Td40sAmtginQL7DIEYzsL4IjnbfuGR0u";
            velocityTracker.clear();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
    
        r0 = r7.A02;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0092, code lost:
    
        if (r6 >= r0) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0094, code lost:
    
        r3 = r3 + (r12.A01.A00(r6) + r5);
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009f, code lost:
    
        r7.A00 = r3;
        r3 = r3 + (r7.A01 + r5);
        r6 = r6 + 1;
     */
    /* JADX WARN: Incorrect condition in loop: B:43:0x00c4 */
    /* JADX WARN: Incorrect condition in loop: B:56:0x0103 */
    /* JADX WARN: Incorrect condition in loop: B:78:0x0188 */
    /* JADX WARN: Incorrect condition in loop: B:97:0x01ff */
    /* JADX WARN: Incorrect condition in loop: B:9:0x0024 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0Q(C1250Pn c1250Pn, int i, C1250Pn c1250Pn2) {
        float f;
        float f2;
        int pos;
        C1250Pn c1250Pn3;
        int A01 = this.A01.A01();
        int width = getClientWidth();
        if (width > 0) {
            int N = this.A0M;
            f = N / width;
        } else {
            f = 0.0f;
        }
        if (c1250Pn2 != null) {
            int width2 = c1250Pn2.A02;
            int N2 = c1250Pn.A02;
            if (width2 < N2) {
                int itemIndex = 0;
                float f3 = c1250Pn2.A00 + c1250Pn2.A01 + f;
                int i2 = width2 + 1;
                while (i2 <= N) {
                    int N3 = this.A0r.size();
                    if (itemIndex >= N3) {
                        break;
                    }
                    C1250Pn c1250Pn4 = this.A0r.get(itemIndex);
                    while (true) {
                        C1250Pn c1250Pn5 = c1250Pn4;
                        int i3 = c1250Pn5.A02;
                        String[] strArr = A0t;
                        String str = strArr[4];
                        String str2 = strArr[2];
                        int width3 = str.charAt(21);
                        int N4 = str2.charAt(21);
                        if (width3 == N4) {
                            A0t[0] = "mMCGHDWlxFgMsjt";
                            if (i2 <= i3) {
                                break;
                            }
                            int N5 = this.A0r.size();
                            if (itemIndex >= N5 - 1) {
                                break;
                            }
                            itemIndex++;
                            c1250Pn4 = this.A0r.get(itemIndex);
                            String[] strArr2 = A0t;
                            String str3 = strArr2[1];
                            String str4 = strArr2[7];
                            int width4 = str3.charAt(20);
                            int N6 = str4.charAt(20);
                            if (width4 == N6) {
                                throw new RuntimeException();
                            }
                            String[] strArr3 = A0t;
                            strArr3[4] = "0GRoiU6ng6hdQPVw3EwHp4l2hIIYcNtn";
                            strArr3[2] = "8Y3rzgV9nzp3iIaIDQEcr4upuD8fyeiC";
                        } else {
                            throw new RuntimeException();
                        }
                    }
                }
            } else {
                int N7 = c1250Pn.A02;
                if (width2 > N7) {
                    int N8 = this.A0r.size();
                    int i4 = N8 - 1;
                    float f4 = c1250Pn2.A00;
                    int itemIndex2 = width2 - 1;
                    while (itemIndex2 >= N && i4 >= 0) {
                        C1250Pn c1250Pn6 = this.A0r.get(i4);
                        String[] strArr4 = A0t;
                        String str5 = strArr4[1];
                        String str6 = strArr4[7];
                        int width5 = str5.charAt(20);
                        int N9 = str6.charAt(20);
                        if (width5 != N9) {
                            String[] strArr5 = A0t;
                            strArr5[4] = "sG2D1AU9vQNSSAZRjoe3z4C00Dqdfrqj";
                            strArr5[2] = "Rdd7cBladgYGVcjrx8uRB4qQBDUzOR2E";
                        }
                        while (true) {
                            c1250Pn3 = c1250Pn6;
                            int N10 = c1250Pn3.A02;
                            if (itemIndex2 >= N10 || i4 <= 0) {
                                break;
                            }
                            i4--;
                            c1250Pn6 = this.A0r.get(i4);
                        }
                        while (itemIndex2 > N) {
                            f4 -= this.A01.A00(itemIndex2) + f;
                            itemIndex2--;
                        }
                        f4 -= c1250Pn3.A01 + f;
                        c1250Pn3.A00 = f4;
                        itemIndex2--;
                    }
                }
            }
        }
        int size = this.A0r.size();
        float offset = c1250Pn.A00;
        int N11 = c1250Pn.A02;
        int itemCount = N11 - 1;
        int N12 = c1250Pn.A02;
        this.A02 = N12 == 0 ? c1250Pn.A00 : -3.4028235E38f;
        int N13 = A01 - 1;
        if (c1250Pn.A02 == N13) {
            float f5 = c1250Pn.A00;
            if (A0t[6].charAt(18) != 53) {
                String[] strArr6 = A0t;
                strArr6[5] = "UG1gT2jUNjrId2t7MfTS74a15LtMOaPg";
                strArr6[3] = "2ozfqeZF2OaiC2JUfBmasK4DPIGaXMZO";
                f2 = (f5 + c1250Pn.A01) - 1.0f;
            } else {
                f2 = (f5 + c1250Pn.A01) - 1.0f;
            }
        } else {
            f2 = Float.MAX_VALUE;
        }
        this.A07 = f2;
        String[] strArr7 = A0t;
        String str7 = strArr7[5];
        String str8 = strArr7[3];
        int width6 = str7.charAt(3);
        int N14 = str8.charAt(3);
        if (width6 != N14) {
            String[] strArr8 = A0t;
            strArr8[5] = "icTatsUiht4AjRSLPfh6XPjJPbhUZ0sF";
            strArr8[3] = "b2D116l90T5me9fMxsyBUu50CZtZWawR";
            pos = i - 1;
        } else {
            A0t[0] = "QtgdpK39IRmx84t";
            pos = i - 1;
        }
        while (pos >= 0) {
            C1250Pn c1250Pn7 = this.A0r.get(pos);
            while (itemCount > N) {
                offset -= this.A01.A00(itemCount) + f;
                itemCount--;
            }
            float f6 = c1250Pn7.A01 + f;
            String[] strArr9 = A0t;
            String str9 = strArr9[4];
            String str10 = strArr9[2];
            int width7 = str9.charAt(21);
            int N15 = str10.charAt(21);
            if (width7 != N15) {
                throw new RuntimeException();
            }
            String[] strArr10 = A0t;
            strArr10[5] = "SgZGqUZOfUbRscKwt61ZJH2C2qxkKaaL";
            strArr10[3] = "iEhLnshzYOduKlFOAhFClgc41xkECprr";
            offset -= f6;
            c1250Pn7.A00 = offset;
            int N16 = c1250Pn7.A02;
            if (N16 == 0) {
                this.A02 = offset;
            }
            pos--;
            itemCount--;
        }
        float f7 = c1250Pn.A00 + c1250Pn.A01 + f;
        int N17 = c1250Pn.A02;
        int i5 = N17 + 1;
        int pos2 = i + 1;
        while (pos2 < size) {
            C1250Pn c1250Pn8 = this.A0r.get(pos2);
            while (i5 < N) {
                f7 += this.A01.A00(i5) + f;
                i5++;
            }
            int N18 = A01 - 1;
            if (c1250Pn8.A02 == N18) {
                this.A07 = (c1250Pn8.A01 + f7) - 1.0f;
            }
            c1250Pn8.A00 = f7;
            f7 += c1250Pn8.A01 + f;
            pos2++;
            i5++;
        }
        this.A0l = false;
    }

    private void A0R(boolean z) {
        boolean z2 = this.A0P == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            boolean needPopulate = this.A0X.isFinished();
            if (!needPopulate) {
                this.A0X.abortAnimation();
                int scrollX = getScrollX();
                int oldX = getScrollY();
                int currX = this.A0X.getCurrX();
                int currY = this.A0X.getCurrY();
                if (scrollX != currX || oldX != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        A0Z(currX);
                    }
                }
            }
        }
        this.A0m = false;
        for (int i = 0; i < this.A0r.size(); i++) {
            C1250Pn c1250Pn = this.A0r.get(i);
            boolean needPopulate2 = c1250Pn.A04;
            if (needPopulate2) {
                z2 = true;
                c1250Pn.A04 = false;
            }
        }
        if (z2) {
            if (z) {
                Ph.A0D(this, this.A0q);
            } else {
                this.A0q.run();
            }
        }
    }

    private void A0S(boolean z) {
        int layerType;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (z) {
                layerType = this.A0N;
            } else {
                layerType = 0;
            }
            getChildAt(i).setLayerType(layerType, null);
        }
    }

    private void A0T(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean A0U() {
        this.A08 = -1;
        A09();
        this.A0V.onRelease();
        this.A0W.onRelease();
        return this.A0V.isFinished() || this.A0W.isFinished();
    }

    private final boolean A0V() {
        if (this.A00 > 0) {
            A0L(this.A00 - 1, true);
            return true;
        }
        return false;
    }

    private final boolean A0W() {
        if (this.A01 != null && this.A00 < this.A01.A01() - 1) {
            A0L(this.A00 + 1, true);
            return true;
        }
        return false;
    }

    private boolean A0X(float f) {
        boolean z = false;
        float f2 = this.A05 - f;
        this.A05 = f;
        float scrollX = getScrollX() + f2;
        int clientWidth = getClientWidth();
        float f3 = clientWidth * this.A02;
        float leftBound = clientWidth;
        float leftBound2 = leftBound * this.A07;
        boolean rightAbsolute = true;
        boolean leftAbsolute = true;
        C1250Pn c1250Pn = this.A0r.get(0);
        C1250Pn c1250Pn2 = this.A0r.get(this.A0r.size() - 1);
        if (c1250Pn.A02 != 0) {
            rightAbsolute = false;
            f3 = c1250Pn.A00 * clientWidth;
        }
        if (c1250Pn2.A02 != this.A01.A01() - 1) {
            leftAbsolute = false;
            float leftBound3 = c1250Pn2.A00;
            leftBound2 = leftBound3 * clientWidth;
        }
        if (scrollX < f3) {
            if (rightAbsolute) {
                float scrollX2 = f3 - scrollX;
                if (A0t[6].charAt(18) == '5') {
                    throw new RuntimeException();
                }
                A0t[6] = "BqGUV6FWN85Kb3W2SyX26JGUB7qlw7kS";
                this.A0V.onPull(Math.abs(scrollX2) / clientWidth);
                z = true;
            }
            scrollX = f3;
        } else if (scrollX > leftBound2) {
            if (leftAbsolute) {
                EdgeEffect edgeEffect = this.A0W;
                float over = Math.abs(scrollX - leftBound2);
                edgeEffect.onPull(over / clientWidth);
                z = true;
            }
            scrollX = leftBound2;
        }
        this.A05 += scrollX - ((int) scrollX);
        scrollTo((int) scrollX, getScrollY());
        A0Z((int) scrollX);
        return z;
    }

    private final boolean A0Y(float f, float f2) {
        return (f < ((float) this.A0I) && f2 > 0.0f) || (f > ((float) (getWidth() - this.A0I)) && f2 < 0.0f);
    }

    private boolean A0Z(int i) {
        int size = this.A0r.size();
        String A08 = A08(397, 53, 33);
        if (size == 0) {
            if (this.A0g) {
                return false;
            }
            this.A0e = false;
            A0I(0, 0.0f, 0);
            if (this.A0e) {
                return false;
            }
            throw new IllegalStateException(A08);
        }
        C1250Pn A03 = A03();
        int currentPage = getClientWidth();
        int widthWithMargin = this.A0M + currentPage;
        int i2 = A03.A02;
        float f = ((i / currentPage) - A03.A00) / (A03.A01 + (this.A0M / currentPage));
        this.A0e = false;
        A0I(i2, f, (int) (widthWithMargin * f));
        if (this.A0e) {
            return true;
        }
        throw new IllegalStateException(A08);
    }

    private final boolean A0a(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        } else if (findFocus != null) {
            boolean z = false;
            ViewParent parent = findFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    break;
                }
                if (parent == this) {
                    z = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append(findFocus.getClass().getSimpleName());
                for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(A08(0, 4, 79)).append(parent2.getClass().getSimpleName());
                }
                Log.e(A08(300, 9, 73), A08(Sdk.SDKError.Reason.ASSET_FAILED_TO_DELETE_VALUE, 72, 43) + sb.toString());
                findFocus = null;
            }
        }
        boolean z2 = false;
        View nextFocused = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (nextFocused != null && nextFocused != findFocus) {
            if (i == 17) {
                z2 = (findFocus == null || A02(this.A0o, nextFocused).left < A02(this.A0o, findFocus).left) ? nextFocused.requestFocus() : A0V();
            } else if (i == 66) {
                z2 = (findFocus == null || A02(this.A0o, nextFocused).left > A02(this.A0o, findFocus).left) ? nextFocused.requestFocus() : A0W();
            }
        } else if (i == 17 || i == 1) {
            z2 = A0V();
        } else if (i == 66 || i == 2) {
            z2 = A0W();
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z2;
    }

    private final boolean A0b(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                boolean handled = keyEvent.hasModifiers(2);
                if (!handled) {
                    break;
                } else {
                    break;
                }
            case 22:
                boolean handled2 = keyEvent.hasModifiers(2);
                if (!handled2) {
                    break;
                } else {
                    break;
                }
            case 61:
                boolean handled3 = keyEvent.hasNoModifiers();
                if (!handled3) {
                    boolean handled4 = keyEvent.hasModifiers(1);
                    if (handled4) {
                        break;
                    }
                } else {
                    break;
                }
                break;
        }
        return false;
    }

    public static boolean A0c(View view) {
        return view.getClass().getAnnotation(ViewPager$DecorView.class) != null;
    }

    private final boolean A0d(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int count = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + count >= childAt.getLeft() && i2 + count < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom() && A0d(childAt, true, i, (i2 + count) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    /* JADX WARN: Incorrect condition in loop: B:13:0x004b */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A0e() {
        boolean z;
        int i;
        int adapterCount;
        int A01 = this.A01.A01();
        this.A0G = A01;
        int size = this.A0r.size();
        int adapterCount2 = this.A0L;
        if (size < (adapterCount2 * 2) + 1) {
            int size2 = this.A0r.size();
            if (A0t[0].length() == 15) {
                String[] strArr = A0t;
                strArr[1] = "NUxzbYKB38C8830aSHSoc7rOuvQ6KKjw";
                strArr[7] = "E23nb8MxwjqpvKiqrD17l4bR7FdWFUoL";
                if (size2 < A01) {
                    z = true;
                    int i2 = this.A00;
                    boolean z2 = false;
                    i = 0;
                    while (i < adapterCount) {
                        C1250Pn c1250Pn = this.A0r.get(i);
                        int newPos = this.A01.A02(c1250Pn.A03);
                        if (newPos != -1) {
                            if (newPos == -2) {
                                this.A0r.remove(i);
                                i--;
                                if (!z2) {
                                    z2 = true;
                                }
                                this.A01.A07(this, c1250Pn.A02, c1250Pn.A03);
                                z = true;
                                int i3 = this.A00;
                                int adapterCount3 = c1250Pn.A02;
                                if (i3 == adapterCount3) {
                                    int adapterCount4 = A01 - 1;
                                    i2 = Math.max(0, Math.min(this.A00, adapterCount4));
                                    z = true;
                                }
                            } else {
                                int i4 = c1250Pn.A02;
                                String[] strArr2 = A0t;
                                String str = strArr2[1];
                                String str2 = strArr2[7];
                                int charAt = str.charAt(20);
                                int adapterCount5 = str2.charAt(20);
                                if (charAt != adapterCount5) {
                                    A0t[6] = "CXZhbfMOsfHqdudS8oUHBRPLwe0MhJzA";
                                    if (i4 != newPos) {
                                        int i5 = c1250Pn.A02;
                                        int adapterCount6 = this.A00;
                                        if (i5 == adapterCount6) {
                                            i2 = newPos;
                                        }
                                        c1250Pn.A02 = newPos;
                                        String[] strArr3 = A0t;
                                        String str3 = strArr3[5];
                                        String str4 = strArr3[3];
                                        int charAt2 = str3.charAt(3);
                                        int adapterCount7 = str4.charAt(3);
                                        if (charAt2 == adapterCount7) {
                                            throw new RuntimeException();
                                        }
                                        String[] strArr4 = A0t;
                                        strArr4[5] = "nuby1bZs8jKJK7rkqs9ajCRBcIxNm0YN";
                                        strArr4[3] = "0Rmx2JLm7aBulgdoCmfHMSHVIg2nPwRL";
                                        z = true;
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        }
                        i++;
                    }
                    Collections.sort(this.A0r, A0x);
                    if (!z) {
                        int childCount = getChildCount();
                        for (int newCurrItem = 0; newCurrItem < childCount; newCurrItem++) {
                            C1251Po c1251Po = (C1251Po) getChildAt(newCurrItem).getLayoutParams();
                            if (!c1251Po.A05) {
                                c1251Po.A00 = 0.0f;
                            }
                        }
                        A0N(i2, false, true);
                        requestLayout();
                        return;
                    }
                    return;
                }
            }
            throw new RuntimeException();
        }
        z = false;
        int i22 = this.A00;
        boolean z22 = false;
        i = 0;
        while (i < adapterCount) {
        }
        Collections.sort(this.A0r, A0x);
        if (!z) {
        }
    }

    public final void A0f() {
        A0G(this.A00);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> views, int i, int i2) {
        C1250Pn A07;
        int size = views.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            int i3 = 0;
            while (true) {
                int childCount = getChildCount();
                int descendantFocusability2 = A0t[6].charAt(18);
                if (descendantFocusability2 == 53) {
                    throw new RuntimeException();
                }
                A0t[0] = "IpvXuWuZmfdtaN6";
                if (i3 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i3);
                int focusableCount = childAt.getVisibility();
                if (focusableCount == 0 && (A07 = A07(childAt)) != null) {
                    int descendantFocusability3 = A07.A02;
                    int focusableCount2 = this.A00;
                    if (descendantFocusability3 == focusableCount2) {
                        childAt.addFocusables(views, i, i2);
                    }
                }
                i3++;
            }
        }
        if (descendantFocusability == 262144) {
            int focusableCount3 = views.size();
            if (size != focusableCount3) {
                return;
            }
        }
        if (!isFocusable()) {
            return;
        }
        int descendantFocusability4 = i2 & 1;
        if ((descendantFocusability4 != 1 || !isInTouchMode() || isFocusableInTouchMode()) && views != null) {
            views.add(this);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C1251Po c1251Po = (C1251Po) layoutParams;
        boolean z = c1251Po.A05;
        String[] strArr = A0t;
        if (strArr[4].charAt(21) != strArr[2].charAt(21)) {
            throw new RuntimeException();
        }
        A0t[6] = "0hKurRTmjdCHvNVYXWivI507L49T3Iz9";
        c1251Po.A05 = z | A0c(view);
        if (this.A0h) {
            if (c1251Po == null || !c1251Po.A05) {
                c1251Po.A03 = true;
                addViewInLayout(view, i, layoutParams);
                return;
            }
            throw new IllegalStateException(A08(86, 41, 27));
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        if (this.A01 == null) {
            return false;
        }
        int width = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) width) * this.A02)) : i > 0 && scrollX < ((int) (((float) width) * this.A07));
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C1251Po) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.A0j = true;
        if (!this.A0X.isFinished() && this.A0X.computeScrollOffset()) {
            int scrollX = getScrollX();
            int y = getScrollY();
            int x = this.A0X.getCurrX();
            int oldY = this.A0X.getCurrY();
            if (scrollX != x || y != oldY) {
                scrollTo(x, oldY);
                if (!A0Z(x)) {
                    this.A0X.abortAnimation();
                    scrollTo(0, oldY);
                }
            }
            Ph.A07(this);
            return;
        }
        A0R(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || A0b(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            boolean dispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
            String[] strArr = A0t;
            if (strArr[1].charAt(20) != strArr[7].charAt(20)) {
                String[] strArr2 = A0t;
                strArr2[5] = "SnNuJhKin8DS21TzQefDZ7b1qeceX1Jv";
                strArr2[3] = "R0wvzxNXSAt5doStTJlFm1lxESFLXhHC";
                return dispatchPopulateAccessibilityEvent;
            }
        } else {
            int childCount = getChildCount();
            if (A0t[0].length() == 15) {
                A0t[6] = "LA2rc0K0poOotSQUO6QKpLGNHvEBCZdG";
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    int childCount2 = childAt.getVisibility();
                    if (childCount2 == 0) {
                        C1250Pn A07 = A07(childAt);
                        String[] strArr3 = A0t;
                        String str = strArr3[1];
                        String str2 = strArr3[7];
                        int i2 = str.charAt(20);
                        int childCount3 = str2.charAt(20);
                        if (i2 == childCount3) {
                            throw new RuntimeException();
                        }
                        String[] strArr4 = A0t;
                        strArr4[1] = "08daBwAiC3e1eMunN04MWwSicEkZtb5w";
                        strArr4[7] = "VX7AcKsgdRXMMXDzaUN7bbmrPcZJNGdB";
                        if (A07 != null) {
                            int i3 = A07.A02;
                            int childCount4 = this.A00;
                            if (i3 == childCount4 && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                                return true;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return false;
            }
        }
        throw new RuntimeException();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        boolean z = false;
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && this.A01 != null && this.A01.A01() > 1)) {
            EdgeEffect edgeEffect = this.A0V;
            int overScrollMode2 = A0t[0].length();
            if (overScrollMode2 != 15) {
                throw new RuntimeException();
            }
            String[] strArr = A0t;
            strArr[4] = "05N514BeFeDJgHlm81yP34LPQc7rkHPA";
            strArr[2] = "pzL9ltF7r1sXjfs3WepY84pTO2WENAbf";
            boolean needsInvalidate = edgeEffect.isFinished();
            if (!needsInvalidate) {
                int save = canvas.save();
                int width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int height = getWidth();
                canvas.rotate(270.0f);
                int overScrollMode3 = -width;
                canvas.translate(overScrollMode3 + getPaddingTop(), this.A02 * height);
                this.A0V.setSize(width, height);
                boolean needsInvalidate2 = this.A0V.draw(canvas);
                z = false | needsInvalidate2;
                canvas.restoreToCount(save);
            }
            boolean needsInvalidate3 = this.A0W.isFinished();
            if (!needsInvalidate3) {
                int width2 = canvas.save();
                int width3 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.A07 + 1.0f)) * width3);
                this.A0W.setSize(height2, width3);
                boolean needsInvalidate4 = this.A0W.draw(canvas);
                z |= needsInvalidate4;
                canvas.restoreToCount(width2);
            }
        } else {
            this.A0V.finish();
            this.A0W.finish();
        }
        if (z) {
            Ph.A07(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.A0S;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C1251Po();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C1251Po(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PS getAdapter() {
        return this.A01;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        int result = this.A0F == 2 ? (i - 1) - i2 : i2;
        int index = ((C1251Po) this.A0b.get(result).getLayoutParams()).A01;
        return index;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public int getCurrentItem() {
        return this.A00;
    }

    public int getOffscreenPageLimit() {
        return this.A0L;
    }

    public int getPageMargin() {
        return this.A0M;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A0g = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.A0q);
        if (this.A0X != null && !this.A0X.isFinished()) {
            this.A0X.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.A0M > 0 && this.A0S != null && this.A0r.size() > 0 && this.A01 != null) {
            int scrollX = getScrollX();
            int pos = getWidth();
            float f2 = this.A0M / pos;
            int firstPos = 0;
            C1250Pn c1250Pn = this.A0r.get(0);
            float marginOffset = c1250Pn.A00;
            int itemCount = this.A0r.size();
            int i = this.A0r.get(itemCount - 1).A02;
            for (int i2 = c1250Pn.A02; i2 < i; i2++) {
                while (i2 > c1250Pn.A02 && firstPos < itemCount) {
                    firstPos++;
                    c1250Pn = this.A0r.get(firstPos);
                }
                if (i2 == c1250Pn.A02) {
                    f = (c1250Pn.A00 + c1250Pn.A01) * pos;
                    float marginOffset2 = c1250Pn.A00;
                    marginOffset = marginOffset2 + c1250Pn.A01 + f2;
                } else {
                    float A00 = this.A01.A00(i2);
                    f = (marginOffset + A00) * pos;
                    marginOffset += A00 + f2;
                }
                if (this.A0M + f > scrollX) {
                    Drawable drawable = this.A0S;
                    int round = Math.round(f);
                    int i3 = this.A0Q;
                    int width = Math.round(this.A0M + f);
                    drawable.setBounds(round, i3, width, this.A09);
                    this.A0S.draw(canvas);
                }
                if (f > scrollX + pos) {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
    
        if (r3 != 0.0f) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0079, code lost:
    
        if (A0Y(r17.A05, r3) != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0087, code lost:
    
        if (A0d(r17, false, (int) r3, (int) r4, (int) r2) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
    
        r17.A05 = r4;
        r17.A06 = r2;
        r17.A0k = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0090, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a8, code lost:
    
        if (r10 <= r17.A0R) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00af, code lost:
    
        if ((0.5f * r10) <= r9) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b1, code lost:
    
        r17.A0i = true;
        A0T(true);
        setScrollState(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bb, code lost:
    
        if (r3 <= r1) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bd, code lost:
    
        r1 = r17.A03 + r17.A0R;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c3, code lost:
    
        r17.A05 = r1;
        r17.A06 = r2;
        setScrollingCacheEnabled(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00cc, code lost:
    
        if (r17.A0i == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d2, code lost:
    
        if (A0X(r4) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d4, code lost:
    
        com.instagram.common.viewpoint.core.Ph.A07(r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d9, code lost:
    
        r1 = r17.A03 - r17.A0R;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e5, code lost:
    
        if (r9 <= r17.A0R) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e7, code lost:
    
        r17.A0k = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a0, code lost:
    
        if (r3 != 0.0f) goto L28;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            A0U();
            return false;
        }
        if (action != 0) {
            if (this.A0i) {
                return true;
            }
            if (this.A0k) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.A03 = x;
                this.A05 = x;
                float y = motionEvent.getY();
                this.A04 = y;
                this.A06 = y;
                this.A08 = motionEvent.getPointerId(0);
                this.A0k = false;
                this.A0j = true;
                this.A0X.computeScrollOffset();
                if (this.A0P != 2 || Math.abs(this.A0X.getFinalX() - this.A0X.getCurrX()) <= this.A0C) {
                    A0R(false);
                    this.A0i = false;
                    break;
                } else {
                    this.A0X.abortAnimation();
                    this.A0m = false;
                    A0f();
                    this.A0i = true;
                    A0T(true);
                    setScrollState(1);
                    break;
                }
            case 2:
                int i = this.A08;
                if (i != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float f2 = x2 - this.A05;
                    float abs = Math.abs(f2);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float y3 = Math.abs(y2 - this.A04);
                    if (A0t[0].length() != 15) {
                        f = 0.0f;
                        break;
                    } else {
                        String[] strArr = A0t;
                        strArr[1] = "2mSFRFxNhkhE5V58FIjiOaI1HMcnWaQH";
                        strArr[7] = "DD1Vl4odvM0LFeMw4Y0kpPn9PiY9Pgji";
                        f = 0.0f;
                        break;
                    }
                }
                break;
            case 6:
                A0P(motionEvent);
                break;
        }
        VelocityTracker velocityTracker = this.A0U;
        if (A0t[0].length() != 15) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0t;
        strArr2[5] = "Ahq8EZKp9TCcvWp5KGK4NZLMSiBqs7aW";
        strArr2[3] = "zhUlAvocS2Bx9TU9L2ybIINdNSgG3BiY";
        if (velocityTracker == null) {
            this.A0U = VelocityTracker.obtain();
        }
        this.A0U.addMovement(motionEvent);
        return this.A0i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        C1250Pn A07;
        int paddingRight;
        int count;
        int scrollX = getChildCount();
        int childTop = i3 - i;
        int childWidth = i4 - i2;
        int vgrav = getPaddingLeft();
        int width = getPaddingTop();
        int childLeft = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int hgrav = getScrollX();
        int i5 = 0;
        int paddingTop = 0;
        while (true) {
            int count2 = 8;
            if (paddingTop < scrollX) {
                View childAt = getChildAt(paddingTop);
                if (childAt.getVisibility() != 8) {
                    C1251Po c1251Po = (C1251Po) childAt.getLayoutParams();
                    if (c1251Po.A05) {
                        int count3 = c1251Po.A04 & 7;
                        int childTop2 = c1251Po.A04 & 112;
                        switch (count3) {
                            case 1:
                                paddingRight = Math.max((childTop - childAt.getMeasuredWidth()) / 2, vgrav);
                                break;
                            case 2:
                            case 4:
                            default:
                                paddingRight = vgrav;
                                break;
                            case 3:
                                paddingRight = vgrav;
                                int paddingBottom2 = childAt.getMeasuredWidth();
                                String[] strArr = A0t;
                                String str = strArr[1];
                                String str2 = strArr[7];
                                int count4 = str.charAt(20);
                                if (count4 == str2.charAt(20)) {
                                    throw new RuntimeException();
                                }
                                A0t[0] = "4DhY9NaEfbkSZ9C";
                                vgrav += paddingBottom2;
                                break;
                            case 5:
                                int paddingRight2 = childTop - childLeft;
                                paddingRight = paddingRight2 - childAt.getMeasuredWidth();
                                childLeft += childAt.getMeasuredWidth();
                                break;
                        }
                        switch (childTop2) {
                            case 16:
                                count = Math.max((childWidth - childAt.getMeasuredHeight()) / 2, width);
                                break;
                            case 48:
                                count = width;
                                width += childAt.getMeasuredHeight();
                                break;
                            case Analytics.AnalyticsData.BOOT_TIME_FIELD_NUMBER /* 80 */:
                                int count5 = childWidth - paddingBottom;
                                count = count5 - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                                break;
                            default:
                                count = width;
                                break;
                        }
                        int paddingRight3 = paddingRight + hgrav;
                        childAt.layout(paddingRight3, count, paddingRight3 + childAt.getMeasuredWidth(), childAt.getMeasuredHeight() + count);
                        i5++;
                    } else {
                        continue;
                    }
                }
                paddingTop++;
            } else {
                int childLeft2 = (childTop - vgrav) - childLeft;
                int paddingBottom3 = 0;
                while (paddingBottom3 < scrollX) {
                    View childAt2 = getChildAt(paddingBottom3);
                    if (childAt2.getVisibility() != count2) {
                        C1251Po c1251Po2 = (C1251Po) childAt2.getLayoutParams();
                        if (!c1251Po2.A05 && (A07 = A07(childAt2)) != null) {
                            int i6 = vgrav + ((int) (childLeft2 * A07.A00));
                            if (c1251Po2.A03) {
                                c1251Po2.A03 = false;
                                int widthSpec = View.MeasureSpec.makeMeasureSpec((int) (childLeft2 * c1251Po2.A00), 1073741824);
                                childAt2.measure(widthSpec, View.MeasureSpec.makeMeasureSpec((childWidth - width) - paddingBottom, 1073741824));
                            }
                            int childTop3 = childAt2.getMeasuredWidth() + i6;
                            width = width;
                            int height = childAt2.getMeasuredHeight() + width;
                            String[] strArr2 = A0t;
                            String str3 = strArr2[1];
                            String str4 = strArr2[7];
                            int widthSpec2 = str3.charAt(20);
                            if (widthSpec2 != str4.charAt(20)) {
                                String[] strArr3 = A0t;
                                strArr3[1] = "z1EGVKAINgCK1pWg9AJjq4tA4jzMvRMS";
                                strArr3[7] = "NHHZP3L5Wb2TlMM1gmFw9TkZDHFcmZzw";
                                childAt2.layout(i6, width, childTop3, height);
                            } else {
                                childAt2.layout(i6, width, childTop3, height);
                            }
                        }
                    }
                    paddingBottom3++;
                    count2 = 8;
                }
                this.A0Q = width;
                this.A09 = childWidth - paddingBottom;
                this.A0D = i5;
                if (this.A0g) {
                    z2 = false;
                    A0M(this.A00, false, 0, false);
                } else {
                    z2 = false;
                }
                this.A0g = z2;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int end;
        C1250Pn A07;
        int childCount = getChildCount();
        int count = i & 2;
        if (count != 0) {
            i2 = 0;
            end = 1;
        } else {
            i2 = childCount - 1;
            end = -1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            int count2 = childAt.getVisibility();
            if (count2 == 0 && (A07 = A07(childAt)) != null) {
                int index = A07.A02;
                int count3 = this.A00;
                if (index == count3 && childAt.requestFocus(i, rect)) {
                    int index2 = A0t[6].charAt(18);
                    if (index2 == 53) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0t;
                    strArr[4] = "Znu0WDOQkx79zIIXKJQFb47iIrfdw3ED";
                    strArr[2] = "SboSqac50StP5vJHTPKGX42Xta1ZIbyJ";
                    return true;
                }
            }
            i2 += end;
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof WrappedParcelable)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            classLoader = getContext().getClassLoader();
        }
        Parcelable state = ((WrappedParcelable) parcelable).unwrap(classLoader);
        if (!(state instanceof ViewPager$SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        ViewPager$SavedState viewPager$SavedState = (ViewPager$SavedState) state;
        super.onRestoreInstanceState(viewPager$SavedState.A02());
        if (this.A01 != null) {
            A0N(viewPager$SavedState.A00, false, true);
            return;
        }
        this.A0O = viewPager$SavedState.A00;
        this.A0T = viewPager$SavedState.A01;
        this.A0a = viewPager$SavedState.A02;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        ViewPager$SavedState ss = new ViewPager$SavedState(superState);
        ss.A00 = this.A00;
        if (this.A01 != null) {
            Parcelable superState2 = this.A01.A03();
            ss.A01 = superState2;
        }
        Parcelable superState3 = new WrappedParcelable(ss);
        return superState3;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            A0K(i, i3, this.A0M, this.A0M);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.A0h) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:5:0x0012 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setAdapter(PS ps) {
        if (this.A01 != null) {
            this.A01.A06(null);
            for (int i = 0; i < i; i++) {
                C1250Pn c1250Pn = this.A0r.get(i);
                this.A01.A07(this, c1250Pn.A02, c1250Pn.A03);
            }
            ArrayList<C1250Pn> arrayList = this.A0r;
            String[] strArr = A0t;
            if (strArr[5].charAt(3) == strArr[3].charAt(3)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0t;
            strArr2[5] = "5tjoWE4Q5tO0E95pkDqQ6gCRa23v2VF9";
            strArr2[3] = "zPJLPuVWeZXbdPcD4tg2pz6GDm3T23cV";
            arrayList.clear();
            A0A();
            this.A00 = 0;
            scrollTo(0, 0);
        }
        this.A01 = ps;
        this.A0G = 0;
        PS oldAdapter = this.A01;
        if (oldAdapter != null) {
            if (this.A0Z == null) {
                this.A0Z = new C1255Ps(this);
            }
            this.A01.A06(this.A0Z);
            this.A0m = false;
            boolean z = this.A0g;
            this.A0g = true;
            PS oldAdapter2 = this.A01;
            this.A0G = oldAdapter2.A01();
            if (this.A0O >= 0) {
                A0N(this.A0O, false, true);
                this.A0O = -1;
                this.A0T = null;
                this.A0a = null;
            } else if (!z) {
                A0f();
            } else {
                requestLayout();
            }
        }
        if (this.A0c != null && !this.A0c.isEmpty() && 0 < this.A0c.size()) {
            this.A0c.get(0);
            throw new NullPointerException(A08(381, 16, 99));
        }
    }

    public void setCurrentItem(int i) {
        this.A0m = false;
        A0N(i, !this.A0g, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w(A08(300, 9, 73), A08(127, 31, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE) + i + A08(51, 26, 45) + 1);
            i = 1;
        }
        if (i != this.A0L) {
            this.A0L = i;
            A0f();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(InterfaceC1253Pq interfaceC1253Pq) {
        this.A0Y = interfaceC1253Pq;
    }

    public void setPageMargin(int i) {
        int width = this.A0M;
        this.A0M = i;
        int oldMargin = getWidth();
        A0K(oldMargin, oldMargin, i, width);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(AbstractC1237Oy.A00(getContext(), i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.A0S = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i) {
        if (this.A0P == i) {
            return;
        }
        this.A0P = i;
        if (0 != 0) {
            A0S(i != 0);
        }
        A0F(i);
        if (A0t[6].charAt(18) == '5') {
            throw new RuntimeException();
        }
        A0t[0] = "blMFZWDPlO2VlWf";
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.A0n != z) {
            this.A0n = z;
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.A0S;
    }
}
