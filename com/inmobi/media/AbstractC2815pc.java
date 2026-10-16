package com.inmobi.media;

import android.graphics.Insets;
import android.view.DisplayCutout;
import android.view.RoundedCorner;
import android.view.WindowInsets;
import androidx.core.view.WindowInsetsCompat;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.pc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2815pc {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f2672a = LazyKt.lazy(C2798oc.f2663a);

    public static final JSONObject a(String str, int i) {
        JSONObject a2 = AbstractC2567ad.a(str, "targetViewId", "id", str);
        a2.put(IronSourceConstants.EVENTS_ERROR_CODE, i);
        return a2;
    }

    public static final Bf b(WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(windowInsets, "<this>");
        Bf e = e(windowInsets);
        Bf c = c(windowInsets);
        Bf d = d(windowInsets);
        Intrinsics.checkNotNullParameter(windowInsets, "<this>");
        Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.navigationBars());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        return a(e, c, d, new Bf(insets.left, insets.top, insets.right, insets.bottom));
    }

    public static final Bf c(WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(windowInsets, "<this>");
        L3 l3 = L3.f2348a;
        if (l3.z()) {
            Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.displayCutout());
            Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
            return new Bf(insets.left, insets.top, insets.right, insets.bottom);
        }
        if (!l3.x()) {
            return (Bf) f2672a.getValue();
        }
        DisplayCutout displayCutout = windowInsets.getDisplayCutout();
        int safeInsetLeft = displayCutout != null ? displayCutout.getSafeInsetLeft() : 0;
        DisplayCutout displayCutout2 = windowInsets.getDisplayCutout();
        int safeInsetTop = displayCutout2 != null ? displayCutout2.getSafeInsetTop() : 0;
        DisplayCutout displayCutout3 = windowInsets.getDisplayCutout();
        int safeInsetRight = displayCutout3 != null ? displayCutout3.getSafeInsetRight() : 0;
        DisplayCutout displayCutout4 = windowInsets.getDisplayCutout();
        return new Bf(safeInsetLeft, safeInsetTop, safeInsetRight, displayCutout4 != null ? displayCutout4.getSafeInsetBottom() : 0);
    }

    public static final Bf d(WindowInsets windowInsets) {
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(windowInsets, "<this>");
        if (!L3.f2348a.A()) {
            return (Bf) f2672a.getValue();
        }
        RoundedCorner roundedCorner = windowInsets.getRoundedCorner(3);
        int i4 = 0;
        RoundedCorner roundedCorner2 = windowInsets.getRoundedCorner(0);
        RoundedCorner roundedCorner3 = windowInsets.getRoundedCorner(1);
        RoundedCorner roundedCorner4 = windowInsets.getRoundedCorner(2);
        if (roundedCorner != null) {
            i = (int) (Math.sin(Math.toRadians(45.0d)) * roundedCorner.getRadius());
        } else {
            i = 0;
        }
        if (roundedCorner2 != null) {
            i2 = (int) (Math.sin(Math.toRadians(45.0d)) * roundedCorner2.getRadius());
        } else {
            i2 = 0;
        }
        if (roundedCorner3 != null) {
            i3 = (int) (Math.sin(Math.toRadians(45.0d)) * roundedCorner3.getRadius());
        } else {
            i3 = 0;
        }
        if (roundedCorner4 != null) {
            i4 = (int) (Math.sin(Math.toRadians(45.0d)) * roundedCorner4.getRadius());
        }
        return new Bf(Math.max(i, i2), Math.max(i2, i3), Math.max(i4, i3), Math.max(i, i4));
    }

    public static final Bf e(WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(windowInsets, "<this>");
        L3 l3 = L3.f2348a;
        if (!l3.z()) {
            return l3.y() ? new Bf(windowInsets.getSystemGestureInsets().left, windowInsets.getSystemGestureInsets().top, windowInsets.getSystemGestureInsets().right, windowInsets.getSystemGestureInsets().bottom) : (Bf) f2672a.getValue();
        }
        Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemGestures());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        return new Bf(insets.left, insets.top, insets.right, insets.bottom);
    }

    public static final Bf a(WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(windowInsets, "<this>");
        return a(e(windowInsets), c(windowInsets), d(windowInsets), (Bf) f2672a.getValue());
    }

    public static final Bf a(Bf area, Bf display, Bf roundedCorner, Bf navigationBar) {
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(roundedCorner, "roundedCorner");
        Intrinsics.checkNotNullParameter(navigationBar, "navigationBar");
        return new Bf(ComparisonsKt.maxOf(area.f2247a, display.f2247a, roundedCorner.f2247a, navigationBar.f2247a), ComparisonsKt.maxOf(area.b, display.b, roundedCorner.b, navigationBar.b), ComparisonsKt.maxOf(area.c, display.c, roundedCorner.c, navigationBar.c), ComparisonsKt.maxOf(area.d, display.d, roundedCorner.d, navigationBar.d));
    }
}
