package com.bytedance.sdk.component.adexpress.dynamic.animation.eli;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class aAs extends aGH {
    private float MGA;
    private eli aGH;
    private float ui;

    public aAs(View view, com.bytedance.sdk.component.adexpress.dynamic.aGH.eli eliVar) {
        super(view, eliVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.eli.aGH
    List<ObjectAnimator> eli() {
        int i;
        String str;
        if ((this.Os instanceof ImageView) && (this.Os.getParent() instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui)) {
            this.Os = (View) this.Os.getParent();
        }
        this.Os.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.Os, "alpha", 0.0f, 1.0f).setDuration((int) (this.DbA.aAs() * 1000.0d));
        this.aGH = new eli(this.Os);
        final int i2 = this.Os.getLayoutParams().height;
        this.ui = i2;
        this.MGA = this.Os.getLayoutParams().width;
        if ("left".equals(this.DbA.eli()) || "right".equals(this.DbA.eli())) {
            i = (int) this.MGA;
            str = "width";
        } else {
            str = "height";
            i = i2;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.aGH, str, 0, i).setDuration((int) (this.DbA.aAs() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(eli(duration));
        arrayList.add(eli(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.eli.aAs.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                aAs.this.aGH.eli(i2);
            }
        });
        return arrayList;
    }

    private class eli {
        private View DbA;

        public eli(View view) {
            this.DbA = view;
        }

        public void eli(int i) {
            if ("top".equals(aAs.this.DbA.eli())) {
                if (aAs.this.Os instanceof ViewGroup) {
                    for (int i2 = 0; i2 < ((ViewGroup) aAs.this.Os).getChildCount(); i2++) {
                        ((ViewGroup) aAs.this.Os).getChildAt(i2).setTranslationY(i - aAs.this.ui);
                    }
                }
                aAs.this.Os.setTranslationY(aAs.this.ui - i);
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.DbA.getLayoutParams();
            layoutParams.height = i;
            this.DbA.setLayoutParams(layoutParams);
            this.DbA.requestLayout();
        }
    }
}
