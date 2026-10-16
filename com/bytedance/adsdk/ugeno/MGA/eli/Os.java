package com.bytedance.adsdk.ugeno.MGA.eli;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* loaded from: classes3.dex */
public class Os extends eli {
    public Os(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.MGA.eli.eli
    public Drawable DbA(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }
}
