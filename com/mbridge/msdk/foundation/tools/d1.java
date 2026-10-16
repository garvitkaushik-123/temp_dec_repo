package com.mbridge.msdk.foundation.tools;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/* compiled from: ViewCoveredUtils.java */
/* loaded from: classes6.dex */
public class d1 {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f4360a = false;

    private static int a(View view, ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) == view) {
                return i;
            }
        }
        return -1;
    }

    private static boolean a(View view, View view2, float f) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view2.getGlobalVisibleRect(rect2);
        Rect rect3 = new Rect();
        if (rect3.setIntersect(rect, rect2)) {
            int width = rect3.width() * rect3.height();
            int width2 = rect.width() * rect.height();
            int measuredWidth = view.getMeasuredWidth() * view.getMeasuredHeight();
            if (f == 0.0f) {
                return width2 < measuredWidth || width >= measuredWidth;
            }
            float f2 = measuredWidth * f;
            float f3 = width;
            if (f3 >= f2) {
                return true;
            }
            int i = width2 - width;
            if (width + i >= measuredWidth) {
                return f3 > f2;
            }
            if (i <= f2) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(View view, ViewGroup viewGroup, float f) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            p0.b("ViewUtils", "View Judge : Start Loop");
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0 && a(view, childAt, f)) {
                if ((childAt instanceof WebView) && childAt.getVisibility() == 0) {
                    p0.b("ViewUtils", "View Judge : View Covered by WebView.");
                    f4360a = true;
                }
                if (a(childAt)) {
                    p0.b("ViewUtils", "View Judge : View Covered and Cover ViewGroup is not transparent.");
                    f4360a = true;
                }
                if (f4360a) {
                    break;
                }
                if (childAt instanceof ViewGroup) {
                    a(view, (ViewGroup) childAt, f);
                }
            }
        }
        return f4360a;
    }

    public static boolean a(View view, int i) {
        if (view == null) {
            return true;
        }
        if (view.getVisibility() != 0) {
            p0.b("ViewUtils", "View Judge : View's not visible.");
            return true;
        }
        if (view.getAlpha() < 0.5f) {
            p0.b("ViewUtils", "View Judge : View's alpha must set up 50%.");
            return true;
        }
        if (view.getParent() == null) {
            p0.b("ViewUtils", "View Judge : view has no parent");
            return true;
        }
        if (view.getParent() != null && (view.getParent() instanceof ViewGroup) && ((ViewGroup) view.getParent()).getVisibility() != 0) {
            p0.b("ViewUtils", "View Judge : View's container is not visible.");
            return true;
        }
        Rect rect = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
        float f = i == 1 ? 0.0f : 0.5f;
        boolean z = ((float) ((rect.bottom - rect.top) * (rect.right - rect.left))) > ((float) (view.getMeasuredHeight() * view.getMeasuredWidth())) * f;
        boolean z2 = globalVisibleRect && z;
        p0.b("ViewUtils", "View Judge : partVisible is " + globalVisibleRect + " halfPercentVisible is " + z);
        p0.b("ViewUtils", "View Judge : totalViewVisible is " + z2);
        if (!z2) {
            return true;
        }
        View view2 = view;
        while (view2.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int a2 = a(view2, viewGroup);
            for (int i2 = a2 + 1; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    boolean a3 = a(view, childAt, f);
                    p0.b("ViewUtils", "View Judge : " + a2 + "  intersects " + a3 + " currentParent " + viewGroup + "currentView " + childAt);
                    if (a3) {
                        if (childAt instanceof ViewGroup) {
                            ViewGroup viewGroup2 = (ViewGroup) childAt;
                            if (viewGroup2.getChildCount() > 0) {
                                p0.b("ViewUtils", "View Judge : Covered by ViewGroup.");
                                boolean a4 = a(view, viewGroup2, f);
                                f4360a = false;
                                if (a4) {
                                    return true;
                                }
                            }
                        }
                        if (a(childAt)) {
                            p0.b("ViewUtils", "View Judge : View Covered and Cover View is not transparent.");
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
            view2 = viewGroup;
        }
        p0.b("ViewUtils", "View Judge : Well done, View is not covered.");
        return false;
    }

    public static boolean a(View view) {
        if (view == null) {
            return true;
        }
        if (!((view.getTag() instanceof String) && "mb_wm".equals(view.getTag())) && view.getAlpha() > 0.5f) {
            return view.getBackground() == null || view.getBackground().getAlpha() > 127;
        }
        return false;
    }
}
