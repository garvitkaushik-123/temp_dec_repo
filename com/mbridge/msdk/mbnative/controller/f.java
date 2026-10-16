package com.mbridge.msdk.mbnative.controller;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;

/* compiled from: Views.java */
/* loaded from: classes6.dex */
public class f {
    public static View a(Context context, View view) {
        View a2 = a(context);
        return a2 != null ? a2 : a(view);
    }

    private static View a(Context context) {
        if (context != null && (context instanceof Activity)) {
            return ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
        }
        return null;
    }

    private static View a(View view) {
        if (view == null) {
            return null;
        }
        try {
            ViewCompat.isAttachedToWindow(view);
        } catch (Throwable unused) {
        }
        try {
            View rootView = view.getRootView();
            if (rootView == null) {
                return null;
            }
            View findViewById = rootView.findViewById(R.id.content);
            return findViewById != null ? findViewById : rootView;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
