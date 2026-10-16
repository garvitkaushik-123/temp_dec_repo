package com.bytedance.sdk.component.adexpress.MGA;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class ui extends FrameLayout {
    private AnimatorSet DbA;
    private ImageView eli;

    public ui(Context context) {
        super(context);
        Os();
        aGH();
    }

    private void Os() {
        ImageView imageView = new ImageView(getContext());
        this.eli = imageView;
        imageView.setImageResource(com.bytedance.sdk.component.utils.ev.aGH(getContext(), "tt_white_hand"));
        int eli = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(eli, eli);
        layoutParams.gravity = 17;
        addView(this.eli, layoutParams);
    }

    private void aGH() {
        this.DbA = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eli, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        ofFloat.setDuration(2000L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eli, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        ofFloat2.setDuration(2000L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.DbA.playTogether(ofFloat, ofFloat2);
    }

    public void eli() {
        AnimatorSet animatorSet = this.DbA;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void DbA() {
        AnimatorSet animatorSet = this.DbA;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
