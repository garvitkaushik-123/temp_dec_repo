package com.mbridge.msdk.dycreator.baseview.cusview;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: classes6.dex */
public class MBridgeFramLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private AnimatorSet f4106a;

    public MBridgeFramLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AnimatorSet animatorSet = this.f4106a;
        if (animatorSet != null) {
            try {
                animatorSet.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet animatorSet = this.f4106a;
        if (animatorSet != null) {
            try {
                animatorSet.cancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setAnimatorSet(AnimatorSet animatorSet) {
        this.f4106a = animatorSet;
    }

    public MBridgeFramLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeFramLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
