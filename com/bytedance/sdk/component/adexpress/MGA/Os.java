package com.bytedance.sdk.component.adexpress.MGA;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.KM;

/* loaded from: classes3.dex */
public class Os extends FrameLayout {
    private ImageView DbA;
    private AnimatorSet MGA;
    private ImageView Os;
    private TextView aGH;
    private Context eli;
    private dV ui;

    public Os(Context context) {
        super(context);
        this.MGA = new AnimatorSet();
        this.eli = context;
        ui();
        MGA();
    }

    private void ui() {
        FrameLayout frameLayout = new FrameLayout(this.eli);
        this.ui = new dV(this.eli);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 95.0f), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.ui, layoutParams);
        this.DbA = new ImageView(this.eli);
        int eli = KM.eli(this.eli, 60.0f);
        this.DbA.setImageDrawable(com.bytedance.sdk.component.adexpress.aGH.wC.eli(1, null, null, new int[]{eli, eli}, Integer.valueOf(KM.eli(this.eli, 1.0f)), Integer.valueOf(Color.parseColor("#80FFFFFF"))));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 75.0f), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.DbA, layoutParams2);
        this.Os = new ImageView(this.eli);
        int eli2 = KM.eli(this.eli, 50.0f);
        this.Os.setImageDrawable(com.bytedance.sdk.component.adexpress.aGH.wC.eli(1, Integer.valueOf(Color.parseColor("#80FFFFFF")), null, new int[]{eli2, eli2}, null, null));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 63.0f), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.Os, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.eli);
        this.aGH = textView;
        textView.setTextColor(-1);
        this.aGH.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.aGH, layoutParams4);
    }

    private void MGA() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Os, "scaleX", 1.0f, 0.9f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.Os, "scaleY", 1.0f, 0.9f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.MGA.setDuration(800L);
        this.MGA.playTogether(ofFloat, ofFloat2);
    }

    public void setGuideText(String str) {
        this.aGH.setText(str);
    }

    public void eli() {
        this.MGA.start();
    }

    public void DbA() {
        this.MGA.cancel();
    }

    public void Os() {
        this.ui.eli();
    }

    public void aGH() {
        this.ui.DbA();
        this.ui.Os();
    }
}
