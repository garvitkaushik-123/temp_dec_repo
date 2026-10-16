package com.bytedance.sdk.openadsdk.core.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class MGA extends FrameLayout {
    private int DbA;
    private boolean MGA;
    private Drawable Os;
    private Drawable aGH;
    private int eli;
    private ValueAnimator kb;
    private Drawable ui;
    private boolean wC;

    public void setProgress(int i) {
        this.DbA = i;
        Drawable drawable = this.Os;
        if (drawable != null) {
            drawable.setLevel((int) ((i * 10000.0f) / this.eli));
        }
    }

    public void setMax(int i) {
        this.eli = i;
    }

    public void setProgressDrawable(Drawable drawable) {
        this.aGH = drawable;
        setBackground(drawable);
        Drawable drawable2 = this.aGH;
        if (drawable2 instanceof LayerDrawable) {
            int numberOfLayers = ((LayerDrawable) drawable2).getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                Drawable drawable3 = ((LayerDrawable) this.aGH).getDrawable(i);
                if ((drawable3 instanceof ScaleDrawable) || (drawable3 instanceof ClipDrawable)) {
                    this.Os = drawable3;
                }
            }
        }
        Drawable drawable4 = this.aGH;
        if (drawable4 instanceof RotateDrawable) {
            this.Os = drawable4;
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        this.ui = drawable;
        setProgressDrawable(drawable);
        if (this.MGA && this.kb == null) {
            eli();
        }
    }

    public MGA(Context context) {
        super(context);
        this.eli = 100;
    }

    public MGA(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eli = 100;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(FC.eli(this, layoutParams));
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.MGA = true;
        if (this.ui != null) {
            eli();
        }
    }

    private void eli() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 10000);
        this.kb = ofInt;
        ofInt.setDuration(2000L);
        this.kb.setRepeatCount(-1);
        this.kb.setInterpolator(new LinearInterpolator());
        this.kb.setRepeatMode(1);
        this.kb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.ui.MGA.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MGA.this.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.kb.start();
        setMax(10000);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.MGA = false;
        ValueAnimator valueAnimator = this.kb;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.kb.removeAllUpdateListeners();
            this.kb = null;
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            if (this.wC) {
                this.wC = false;
                ValueAnimator valueAnimator = this.kb;
                if (valueAnimator != null) {
                    valueAnimator.resume();
                    return;
                } else {
                    eli();
                    return;
                }
            }
            return;
        }
        if (this.kb == null || this.wC) {
            return;
        }
        this.wC = true;
        this.kb.pause();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
