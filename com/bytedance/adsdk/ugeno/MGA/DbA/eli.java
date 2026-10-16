package com.bytedance.adsdk.ugeno.MGA.DbA;

import android.view.View;
import com.bytedance.adsdk.ugeno.wC.Os;

/* loaded from: classes3.dex */
public class eli implements Os.ui {
    @Override // com.bytedance.adsdk.ugeno.wC.Os.ui
    public void eli(View view, float f) {
        view.setPivotX(f < 0.0f ? view.getWidth() : 0.0f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setRotationY(f * 90.0f);
    }
}
