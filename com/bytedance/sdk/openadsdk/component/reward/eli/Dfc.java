package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;

/* loaded from: classes3.dex */
public class Dfc {
    private final ev DbA;
    private com.bytedance.sdk.openadsdk.core.widget.kb MGA;
    private final Context Os;
    private final int aGH;
    com.bytedance.sdk.openadsdk.core.widget.wC eli;
    private AnimatorSet kb;
    private final eli ui;

    public Dfc(eli eliVar) {
        this.Os = eliVar.FS;
        this.DbA = eliVar.DbA;
        this.aGH = eliVar.QI;
        this.ui = eliVar;
    }

    public void eli() {
        try {
            if (KM.Os(this.DbA)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.widget.kb kbVar = new com.bytedance.sdk.openadsdk.core.widget.kb(this.Os);
            this.MGA = kbVar;
            this.eli = kbVar.getLoadingProgressBar();
            com.bytedance.sdk.openadsdk.core.ui.wC downloadButton = this.MGA.getDownloadButton();
            if (downloadButton != null) {
                downloadButton.setOnClickListener(this.ui.KM.ui());
            }
            this.MGA.eli(this.DbA, this.aGH);
        } catch (Throwable unused) {
        }
    }

    public void DbA() {
        ValueAnimator ofInt = ValueAnimator.ofInt(1, 80);
        ofInt.setDuration(2000L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.Dfc.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (Dfc.this.eli != null) {
                    Dfc.this.eli.setProgress(intValue);
                }
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(81, 99);
        ofInt2.setDuration(3000L);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.Dfc.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (Dfc.this.eli != null) {
                    Dfc.this.eli.setProgress(intValue);
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.kb = animatorSet;
        animatorSet.play(ofInt).before(ofInt2);
        this.kb.start();
    }

    public void Os() {
        AnimatorSet animatorSet = this.kb;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public View aGH() {
        return this.MGA;
    }
}
