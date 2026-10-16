package com.bytedance.sdk.component.adexpress.dynamic.animation.eli;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ui extends aGH {
    public ui(View view, com.bytedance.sdk.component.adexpress.dynamic.aGH.eli eliVar) {
        super(view, eliVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.eli.aGH
    List<ObjectAnimator> eli() {
        char c;
        ArrayList arrayList = new ArrayList();
        String bf = this.DbA.bf();
        switch (bf.hashCode()) {
            case 3029889:
                if (bf.equals("both")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3387192:
                if (bf.equals("none")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 483313230:
                if (bf.equals("forwards")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1356771568:
                if (bf.equals("backwards")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            eli(arrayList);
            return arrayList;
        }
        if (c == 1) {
            aGH(arrayList);
            return arrayList;
        }
        if (c == 2) {
            DbA(arrayList);
            return arrayList;
        }
        Os(arrayList);
        return arrayList;
    }

    private void eli(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.Os, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.DbA.Xb())).setDuration(((int) (this.DbA.aAs() * 1000.0d)) / 2);
        duration.setInterpolator(new LinearInterpolator());
        duration.setRepeatMode(2);
        this.DbA.MGA(this.DbA.Dfc() * 2);
        list.add(eli(duration));
    }

    private void DbA(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.Os, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.DbA.Xb())).setDuration((int) (this.DbA.aAs() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.eli.ui.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ui.this.Os.setTranslationY(0.0f);
            }
        });
        list.add(eli(duration));
    }

    private void Os(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.Os, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.DbA.Xb())).setDuration((int) (this.DbA.aAs() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.eli.ui.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ui.this.Os.setTranslationY(0.0f);
            }
        });
        list.add(eli(duration));
    }

    private void aGH(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.Os, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.DbA.Xb())).setDuration((int) (this.DbA.aAs() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        list.add(eli(duration));
    }
}
