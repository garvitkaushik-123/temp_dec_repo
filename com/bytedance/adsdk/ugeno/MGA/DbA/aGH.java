package com.bytedance.adsdk.ugeno.MGA.DbA;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.wC.Os;

/* loaded from: classes3.dex */
public class aGH implements Os.ui {
    private String eli;

    public void eli(String str) {
        this.eli = str;
    }

    @Override // com.bytedance.adsdk.ugeno.wC.Os.ui
    public void eli(View view, float f) {
        if (f >= -1.0f && f <= 1.0f) {
            view.setAlpha(1.0f);
            view.setTranslationX(view.getWidth() * (-f));
            view.setTranslationY(view.getHeight() * f);
        } else {
            view.setAlpha(0.0f);
        }
        if (TextUtils.equals(this.eli, "cube")) {
            float height = f < 0.0f ? view.getHeight() : 0.0f;
            view.setPivotX(view.getWidth() * 0.5f);
            view.setPivotY(height);
            view.setRotationX(f * (-90.0f));
        }
    }
}
