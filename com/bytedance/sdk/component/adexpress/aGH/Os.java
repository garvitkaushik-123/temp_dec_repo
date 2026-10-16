package com.bytedance.sdk.component.adexpress.aGH;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* loaded from: classes3.dex */
public class Os {
    public static Drawable eli(Context context, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar) {
        if (context == null || kbVar == null) {
            return null;
        }
        return eli(context, (int) kb.eli(context, kbVar.dV()), kbVar.aqO(), kbVar.KM());
    }

    public static Drawable eli(Context context, int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (context != null) {
            gradientDrawable.setStroke(i, i2);
        }
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }
}
