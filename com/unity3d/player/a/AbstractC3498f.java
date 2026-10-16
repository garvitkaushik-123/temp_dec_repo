package com.unity3d.player.a;

import android.app.Activity;
import android.app.Dialog;
import android.window.OnBackInvokedDispatcher;

/* renamed from: com.unity3d.player.a.f, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC3498f {
    public static OnBackInvokedDispatcher a(Object obj) {
        if (obj instanceof Activity) {
            return ((Activity) obj).getOnBackInvokedDispatcher();
        }
        if (obj instanceof Dialog) {
            return ((Dialog) obj).getOnBackInvokedDispatcher();
        }
        throw new IllegalArgumentException("Unsupported context type when getting '" + obj.getClass().getName() + "' OnBackInvokedDispatcher");
    }

    public static void a(OnBackInvokedDispatcher onBackInvokedDispatcher, int i, C3497e c3497e) {
        onBackInvokedDispatcher.registerOnBackInvokedCallback(i, c3497e);
    }

    public static void a(OnBackInvokedDispatcher onBackInvokedDispatcher, C3497e c3497e) {
        onBackInvokedDispatcher.unregisterOnBackInvokedCallback(c3497e);
    }
}
