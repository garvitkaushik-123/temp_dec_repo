package com.bytedance.adsdk.ugeno.eli;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* loaded from: classes3.dex */
public class wC implements kb {
    private float DbA;
    private float MGA;
    private float Os;
    private float aGH;
    private View eli;
    private float ui;

    public wC(View view) {
        this.eli = view;
    }

    public void eli(float f) {
        View view = this.eli;
        if (view == null) {
            return;
        }
        this.DbA = f;
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(f);
        }
    }

    public float eli() {
        return this.DbA;
    }

    public void DbA(float f) {
        View view = this.eli;
        if (view == null) {
            return;
        }
        this.Os = f;
        view.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.eli.kb
    public float getRipple() {
        return this.Os;
    }

    public void Os(float f) {
        View view = this.eli;
        if (view == null) {
            return;
        }
        this.aGH = f;
        view.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.eli.kb
    public float getShine() {
        return this.aGH;
    }

    public void aGH(float f) {
        this.ui = f;
        this.eli.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.eli.kb
    public float getStretch() {
        return this.ui;
    }

    public void ui(float f) {
        this.MGA = f;
        this.eli.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.eli.kb
    public float getRubIn() {
        return this.MGA;
    }

    public void eli(int i) {
        View view = this.eli;
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background.mutate()).setColor(i);
        }
    }
}
