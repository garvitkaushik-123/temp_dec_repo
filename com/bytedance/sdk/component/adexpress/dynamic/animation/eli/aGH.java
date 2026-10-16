package com.bytedance.sdk.component.adexpress.dynamic.animation.eli;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class aGH implements Cp {
    com.bytedance.sdk.component.adexpress.dynamic.aGH.eli DbA;
    public View Os;
    private Set<ScheduledFuture<?>> aGH = new HashSet();
    public List<ObjectAnimator> eli = eli();

    abstract List<ObjectAnimator> eli();

    public aGH(View view, com.bytedance.sdk.component.adexpress.dynamic.aGH.eli eliVar) {
        this.Os = view;
        this.DbA = eliVar;
    }

    public void Os() {
        List<ObjectAnimator> list = this.eli;
        if (list == null) {
            return;
        }
        for (final ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.DbA.dV() > 0.0d) {
                objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.eli.aGH.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        objectAnimator.pause();
                        eli eliVar = aGH.this.new eli(objectAnimator);
                        ScheduledFuture<?> eli2 = com.bytedance.sdk.component.adexpress.aGH.aGH.eli(eliVar, (long) (aGH.this.DbA.dV() * 1000.0d), TimeUnit.MILLISECONDS);
                        eliVar.eli(eli2);
                        aGH.this.aGH.add(eli2);
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cp
    public void DbA() {
        List<ObjectAnimator> list = this.eli;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        Iterator<ScheduledFuture<?>> it = this.aGH.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    ObjectAnimator eli(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.DbA.nn() * 1000.0d));
        if (this.DbA.Dfc() > 0) {
            objectAnimator.setRepeatCount(this.DbA.Dfc() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!Constants.NORMAL.equals(this.DbA.aqO())) {
            if ("alternate".equals(this.DbA.aqO()) || "alternate-reverse".equals(this.DbA.aqO())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.DbA.NU())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.DbA.aqO())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.DbA.aqO())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.eli.aGH.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    aGH.this.Os.setVisibility(0);
                    if (aGH.this.Os.getParent() instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA) {
                        ((View) aGH.this.Os.getParent()).setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }

    public class eli implements Runnable {
        ScheduledFuture<?> DbA;
        ObjectAnimator eli;

        eli(ObjectAnimator objectAnimator) {
            this.eli = objectAnimator;
        }

        public void eli(ScheduledFuture<?> scheduledFuture) {
            this.DbA = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os() != null) {
                com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os().Os().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.eli.aGH.eli.1
                    @Override // java.lang.Runnable
                    public void run() {
                        eli.this.eli.resume();
                    }
                });
                if (this.DbA != null) {
                    aGH.this.aGH.remove(this.DbA);
                }
            }
        }
    }
}
