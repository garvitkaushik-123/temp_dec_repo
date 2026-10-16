package com.mbridge.msdk.foundation.tools;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ViewUtil.java */
/* loaded from: classes6.dex */
public class e1 {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f4361a = new AtomicInteger(1);

    public static void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static void a(Window window) {
        if (window != null) {
            try {
                int i = Build.VERSION.SDK_INT;
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (i >= 30) {
                    attributes.layoutInDisplayCutoutMode = 3;
                } else {
                    attributes.layoutInDisplayCutoutMode = 1;
                }
                window.setAttributes(attributes);
            } catch (Throwable th) {
                p0.b("ViewUtil", th.getMessage());
            }
        }
    }
}
