package io.bidmachine.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import io.bidmachine.core.Logger;

/* loaded from: classes8.dex */
public class ViewHelper {
    public static boolean belongTo(ViewGroup parent, View child) {
        ViewParent parent2 = child.getParent();
        if (!(parent2 instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) parent2;
        return viewGroup.equals(parent) || belongTo(parent, viewGroup);
    }

    public static void removeViewFromParent(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public static <T extends View> T findViewByClassName(ViewGroup viewGroup, Class<T> cls) {
        T t;
        try {
            if (viewGroup.getClass() == cls) {
                return viewGroup;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof ViewGroup) && (t = (T) findViewByClassName((ViewGroup) childAt, cls)) != null) {
                    return t;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void safeAddSingleView(ViewGroup container, View view) {
        safeAddSingleView(container, view, null);
    }

    public static void safeAddSingleView(ViewGroup container, View view, ViewGroup.LayoutParams layoutParams) {
        try {
            container.removeAllViews();
        } catch (Exception e) {
            Logger.w(e);
        }
        safeAddView(container, view, layoutParams);
    }

    public static void safeAddView(ViewGroup container, View view) {
        safeAddView(container, view, null);
    }

    public static void safeAddView(ViewGroup container, View view, ViewGroup.LayoutParams layoutParams) {
        try {
            removeViewFromParent(view);
            if (layoutParams != null) {
                container.addView(view, layoutParams);
            } else {
                container.addView(view);
            }
        } catch (Exception e) {
            Logger.w(e);
        }
    }
}
