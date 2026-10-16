package com.bytedance.adsdk.ugeno.MGA.DbA;

import android.view.View;
import com.bytedance.adsdk.ugeno.wC.Os;

/* loaded from: classes3.dex */
public class DbA implements Os.ui {
    @Override // com.bytedance.adsdk.ugeno.wC.Os.ui
    public void eli(View view, float f) {
        int width = view.getWidth();
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                view.setTranslationX((-width) * f);
            } else {
                view.setTranslationX(width);
                view.setTranslationX((-width) * f);
            }
            view.setAlpha(Math.max(0.0f, 1.0f - Math.abs(f)));
            return;
        }
        view.setAlpha(0.0f);
    }
}
