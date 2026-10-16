package com.bytedance.adsdk.DbA.MGA;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public abstract class eli extends ValueAnimator {
    private final Set<ValueAnimator.AnimatorUpdateListener> eli = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorListener> DbA = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorPauseListener> Os = new CopyOnWriteArraySet();

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.eli.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.eli.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.eli.clear();
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.DbA.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.DbA.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.DbA.clear();
    }

    void eli(boolean z) {
        Iterator<Animator.AnimatorListener> it = this.DbA.iterator();
        while (it.hasNext()) {
            it.next().onAnimationStart(this, z);
        }
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.Os.add(animatorPauseListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.Os.remove(animatorPauseListener);
    }

    void eli() {
        Iterator<Animator.AnimatorListener> it = this.DbA.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    void DbA(boolean z) {
        Iterator<Animator.AnimatorListener> it = this.DbA.iterator();
        while (it.hasNext()) {
            it.next().onAnimationEnd(this, z);
        }
    }

    void DbA() {
        Iterator<Animator.AnimatorListener> it = this.DbA.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    void Os() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.eli.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    void aGH() {
        Iterator<Animator.AnimatorPauseListener> it = this.Os.iterator();
        while (it.hasNext()) {
            it.next().onAnimationPause(this);
        }
    }

    void ui() {
        Iterator<Animator.AnimatorPauseListener> it = this.Os.iterator();
        while (it.hasNext()) {
            it.next().onAnimationResume(this);
        }
    }
}
