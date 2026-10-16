package com.bytedance.adsdk.ugeno.MGA.DbA;

import android.view.View;
import com.bytedance.adsdk.ugeno.wC.Os;

/* loaded from: classes3.dex */
public class Os implements Os.ui {
    final float eli = 0.8f;
    final float DbA = 0.5f;

    @Override // com.bytedance.adsdk.ugeno.wC.Os.ui
    public void eli(View view, float f) {
        float f2 = ((f < 0.0f ? 0.19999999f : -0.19999999f) * f) + 1.0f;
        float f3 = (f * (f < 0.0f ? 0.5f : -0.5f)) + 1.0f;
        if (f < 0.0f) {
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight() / 2);
        } else {
            view.setPivotX(0.0f);
            view.setPivotY(view.getHeight() / 2);
        }
        view.setScaleX(f2);
        view.setScaleY(f2);
        view.setAlpha(Math.abs(f3));
    }
}
