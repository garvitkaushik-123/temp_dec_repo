package io.bidmachine.iab.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* loaded from: classes7.dex */
public abstract class IabElementWrapper<T extends View> {

    /* renamed from: a, reason: collision with root package name */
    private final View.OnClickListener f6850a;
    protected T b;
    protected IabElementStyle c;
    private boolean d = false;
    private final Runnable e = new a();
    private final Animator.AnimatorListener f = new b();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IabElementWrapper.this.d = false;
            IabElementWrapper iabElementWrapper = IabElementWrapper.this;
            T t = iabElementWrapper.b;
            if (t == null || iabElementWrapper.c == null) {
                return;
            }
            t.animate().alpha(0.0f).setDuration(400L).setListener(IabElementWrapper.this.f).withLayer();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            super.onAnimationCancel(animation);
            animation.removeAllListeners();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            T t = IabElementWrapper.this.b;
            if (t != null) {
                t.setClickable(t.getAlpha() != 0.0f);
            }
        }
    }

    public IabElementWrapper(View.OnClickListener onClickListener) {
        this.f6850a = onClickListener;
    }

    protected void a(Context context, T view, IabElementStyle elementStyle) {
    }

    public void attach(Context context, ViewGroup viewGroup, IabElementStyle iabElementStyle) {
        RelativeLayout.LayoutParams layoutParams;
        IabElementStyle iabElementStyle2;
        IabElementStyle copyWith = c(context, iabElementStyle).copyWith(iabElementStyle);
        if (!copyWith.isVisible().booleanValue()) {
            detach();
            return;
        }
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a(context, copyWith));
            copyWith.applyAlignment(layoutParams2);
            layoutParams = layoutParams2;
        } else {
            if (!(viewGroup instanceof RelativeLayout)) {
                throw new IllegalArgumentException("Parent should be instance of FrameLayout or RelativeLayout");
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a(context, copyWith));
            copyWith.applyRelativeAlignment(layoutParams3);
            layoutParams = layoutParams3;
        }
        copyWith.applyMargin(context, layoutParams);
        T t = this.b;
        if (t == null || (iabElementStyle2 = this.c) == null || a((IabElementWrapper<T>) t, iabElementStyle2, copyWith)) {
            Utils.removeFromParent(this.b);
            T b2 = b(context, copyWith);
            this.b = b2;
            viewGroup.addView(b2, layoutParams);
        } else {
            this.b.setLayoutParams(layoutParams);
            this.b.setVisibility(0);
        }
        this.b.setAlpha(copyWith.getOpacity().floatValue());
        copyWith.applyPadding(context, this.b);
        this.b.setOnClickListener(this.f6850a);
        this.c = copyWith;
        a((IabElementWrapper<T>) this.b, copyWith);
        a(context, (Context) this.b, copyWith);
    }

    abstract T b(Context context, IabElementStyle elementStyle);

    public void bringToFront() {
        T t = this.b;
        if (t != null) {
            t.bringToFront();
        }
    }

    protected abstract IabElementStyle c(Context context, IabElementStyle targetStyle);

    public void cancelHide() {
        this.d = false;
        T t = this.b;
        if (t == null || this.c == null) {
            return;
        }
        t.animate().cancel();
        this.b.removeCallbacks(this.e);
        this.b.setClickable(true);
        this.b.setAlpha(this.c.getOpacity().floatValue());
    }

    public void detach() {
        if (this.b != null) {
            cancelHide();
            Utils.removeFromParent(this.b);
            this.b = null;
            this.c = null;
        }
    }

    public T getCachedView() {
        return this.b;
    }

    public void invalidate() {
        T t;
        if (!isAttached() || (t = this.b) == null || this.c == null) {
            return;
        }
        a(t.getContext(), (Context) this.b, this.c);
    }

    public boolean isAttached() {
        return this.b != null;
    }

    public void setVisibility(int visibility) {
        T t = this.b;
        if (t != null) {
            t.setVisibility(visibility);
        }
    }

    public void toggleHide() {
        IabElementStyle iabElementStyle;
        Float hideAfter;
        if (this.d || this.b == null || (iabElementStyle = this.c) == null || (hideAfter = iabElementStyle.getHideAfter()) == null || hideAfter.floatValue() == 0.0f) {
            return;
        }
        this.d = true;
        this.b.postDelayed(this.e, (long) (hideAfter.floatValue() * 1000.0f));
    }

    public void toggleShow() {
        if (this.b == null || this.c == null) {
            return;
        }
        cancelHide();
        toggleHide();
    }

    protected ViewGroup.MarginLayoutParams a(Context context, IabElementStyle elementStyle) {
        return new ViewGroup.MarginLayoutParams(elementStyle.getWidth(context).intValue(), elementStyle.getHeight(context).intValue());
    }

    protected void a(T view, IabElementStyle elementStyle) {
        if (view instanceof IabElement) {
            ((IabElement) view).setStyle(elementStyle);
        }
    }

    protected boolean a(T view, IabElementStyle newElementStyle, IabElementStyle previousElementStyle) {
        return !TextUtils.equals(newElementStyle.getStyle(), previousElementStyle.getStyle());
    }
}
