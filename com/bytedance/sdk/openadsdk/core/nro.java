package com.bytedance.sdk.openadsdk.core;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class nro {
    private static boolean eli(View view, int i) {
        float eli = eli(view);
        return eli > 0.0f && eli >= ((float) i) / 100.0f;
    }

    public static float eli(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null) {
                    if (!view.getGlobalVisibleRect(new Rect())) {
                        return -1.0f;
                    }
                    long height = r1.height() * r1.width();
                    long height2 = view.getHeight() * view.getWidth();
                    if (height2 <= 0) {
                        return -1.0f;
                    }
                    return height / height2;
                }
            } catch (Throwable unused) {
            }
        }
        return -1.0f;
    }

    private static boolean DbA(View view) {
        return view != null && view.isShown();
    }

    private static boolean eli(View view, int i, boolean z) {
        return (i == 1 && z) ? view.getWidth() > 0 && view.getHeight() > 0 : view.getWidth() >= DbA(view, i) && view.getHeight() >= Os(view, i);
    }

    private static int DbA(View view, int i) {
        if (i == 3) {
            return (int) (SSo.Os(view.getContext().getApplicationContext()) * 0.7d);
        }
        return 20;
    }

    private static int Os(View view, int i) {
        if (i == 3) {
            return SSo.ui(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    private static int DbA(View view, int i, int i2, boolean z) throws Throwable {
        if (view.getWindowVisibility() != 0) {
            return 4;
        }
        if (!DbA(view)) {
            return 1;
        }
        if (eli(view, i2, z)) {
            return !eli(view, i) ? 3 : 0;
        }
        return 6;
    }

    public static boolean eli(View view, int i, int i2, boolean z) {
        if (i2 == 1) {
            while (view != null) {
                try {
                    if (view.getVisibility() == 0) {
                        if ((view instanceof com.bytedance.sdk.openadsdk.core.wC.Xb) || (view instanceof com.bytedance.sdk.openadsdk.core.Os.aGH)) {
                            break;
                        }
                        view = (View) view.getParent();
                    } else {
                        return false;
                    }
                } catch (Throwable unused) {
                }
            }
            if (z) {
                i = 0;
            }
        }
        return DbA(view, i, i2, z) == 0;
    }
}
