package com.ironsource;

import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class eg {
    public static final boolean a(View view, Rect rect) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(rect, "rect");
        return view.isShown() && view.hasWindowFocus() && view.getGlobalVisibleRect(rect);
    }
}
