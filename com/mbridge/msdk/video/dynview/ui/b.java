package com.mbridge.msdk.video.dynview.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.foundation.tools.u0;
import java.util.List;
import java.util.Map;

/* compiled from: MBridgeUIAnim.java */
/* loaded from: classes6.dex */
public class b {

    /* compiled from: MBridgeUIAnim.java */
    class a implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5057a;

        a(View view) {
            this.f5057a = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            View view = this.f5057a;
            if (view == null || !(view instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) view).removeAllViews();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.f5057a;
            if (view == null || !(view instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) view).removeAllViews();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: MBridgeUIAnim.java */
    /* renamed from: com.mbridge.msdk.video.dynview.ui.b$b, reason: collision with other inner class name */
    class C0410b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f5058a;

        C0410b(List list) {
            this.f5058a = list;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            List list = this.f5058a;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (View view : this.f5058a) {
                if (view != null) {
                    view.setPadding(0, 0, 0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    view.requestLayout();
                }
            }
        }
    }

    /* compiled from: MBridgeUIAnim.java */
    class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5059a;

        c(View view) {
            this.f5059a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view = this.f5059a;
            if (view != null) {
                view.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.f5059a.requestLayout();
            }
        }
    }

    /* compiled from: MBridgeUIAnim.java */
    class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5060a;

        d(View view) {
            this.f5060a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view = this.f5060a;
            if (view != null) {
                view.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.f5060a.requestLayout();
                if (this.f5060a.getVisibility() != 0) {
                    this.f5060a.setVisibility(0);
                }
            }
        }
    }

    /* compiled from: MBridgeUIAnim.java */
    class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5061a;

        e(View view) {
            this.f5061a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup.LayoutParams layoutParams = this.f5061a.getLayoutParams();
            layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.f5061a.setLayoutParams(layoutParams);
        }
    }

    /* compiled from: MBridgeUIAnim.java */
    class f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5062a;

        f(View view) {
            this.f5062a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f5062a.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f5062a.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public void a(Map<String, Bitmap> map, com.mbridge.msdk.video.dynview.c cVar, View view) {
        if (view != null) {
            com.mbridge.msdk.video.dynview.util.draw.a.a().a(map, cVar, view);
        }
    }

    public ObjectAnimator b(View view) {
        ObjectAnimator a2 = a(view, 1.0f, 1.0f, 5.0f, 2000L);
        a2.setRepeatCount(-1);
        return a2;
    }

    public ObjectAnimator c(View view) {
        ObjectAnimator a2 = a(view, 1.0f, 1.0f, 2000L);
        a2.setRepeatCount(-1);
        return a2;
    }

    public ObjectAnimator a(View view) {
        ObjectAnimator a2 = a(view, 2.0f, 1000L);
        a2.setRepeatCount(-1);
        return a2;
    }

    public void b(View view, long j) {
        if (view != null) {
            view.setAlpha(1.0f);
            view.animate().alpha(0.0f).setDuration(j).setListener(new a(view));
        }
    }

    public void c(View view, long j) {
        if (view == null) {
            return;
        }
        a(view, 0, u0.g(view.getContext().getApplicationContext()), j);
    }

    public void a(View view, long j) {
        if (view != null) {
            view.setVisibility(0);
            view.setAlpha(0.0f);
            view.animate().alpha(1.0f).setDuration(j);
        }
    }

    private PropertyValuesHolder b(Property property, float f2) {
        float f3 = f2 - 0.2f;
        float f4 = f2 + 0.3f;
        return PropertyValuesHolder.ofKeyframe(property, Keyframe.ofFloat(0.0f, f2), Keyframe.ofFloat(0.1f, f2 - 0.4f), Keyframe.ofFloat(0.2f, f3), Keyframe.ofFloat(0.3f, f4), Keyframe.ofFloat(0.4f, f3), Keyframe.ofFloat(0.5f, f4), Keyframe.ofFloat(0.6f, f2 - 0.1f), Keyframe.ofFloat(0.7f, f4), Keyframe.ofFloat(0.8f, f2), Keyframe.ofFloat(0.9f, 0.1f + f2), Keyframe.ofFloat(1.0f, f2));
    }

    private PropertyValuesHolder c(Property property, float f2) {
        float f3 = (-2.0f) * f2;
        float f4 = f2 * 2.0f;
        return PropertyValuesHolder.ofKeyframe(property, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.1f, f3), Keyframe.ofFloat(0.2f, f3), Keyframe.ofFloat(0.3f, f4), Keyframe.ofFloat(0.4f, f3), Keyframe.ofFloat(0.5f, f4), Keyframe.ofFloat(0.6f, f3), Keyframe.ofFloat(0.7f, f4), Keyframe.ofFloat(0.8f, f3), Keyframe.ofFloat(0.9f, f4), Keyframe.ofFloat(1.0f, 0.0f));
    }

    public void a(List<View> list, int i, int i2, long j) {
        ValueAnimator duration = ValueAnimator.ofInt(i, i2).setDuration(j);
        duration.addUpdateListener(new C0410b(list));
        duration.start();
    }

    public void a(View view, int i, int i2, int i3, int i4, long j) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.addUpdateListener(new c(view));
        ValueAnimator ofInt2 = ValueAnimator.ofInt(i3, i4);
        ofInt2.addUpdateListener(new d(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofInt, ofInt2);
        animatorSet.setDuration(j);
        animatorSet.start();
    }

    private ObjectAnimator a(View view, float f2, float f3, float f4, long j) {
        return ObjectAnimator.ofPropertyValuesHolder(view, b(View.SCALE_X, f2), b(View.SCALE_Y, f3), c(View.ROTATION_X, f4)).setDuration(j);
    }

    private void a(View view, int i, int i2, long j) {
        ValueAnimator ofInt;
        ValueAnimator ofFloat;
        if (view.getLayoutParams().width == 0) {
            ofInt = ValueAnimator.ofInt(i, i2);
        } else {
            ofInt = ValueAnimator.ofInt(i2, i);
        }
        ofInt.setDuration(j);
        ofInt.addUpdateListener(new e(view));
        if (view.getLayoutParams().width == 0) {
            ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        } else {
            ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        }
        ofFloat.setDuration(j);
        ofFloat.addUpdateListener(new f(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofInt, ofFloat);
        animatorSet.start();
    }

    private ObjectAnimator a(View view, float f2, float f3, long j) {
        return ObjectAnimator.ofPropertyValuesHolder(view, a(View.SCALE_X, f2), a(View.SCALE_Y, f3)).setDuration(j);
    }

    public ObjectAnimator a(View view, float f2, long j) {
        return ObjectAnimator.ofPropertyValuesHolder(view, c(View.ROTATION, f2)).setDuration(j);
    }

    private PropertyValuesHolder a(Property property, float f2) {
        float f3 = f2 - 0.4f;
        return PropertyValuesHolder.ofKeyframe(property, Keyframe.ofFloat(0.0f, f2), Keyframe.ofFloat(0.1f, f3), Keyframe.ofFloat(0.2f, f3), Keyframe.ofFloat(0.3f, f2), Keyframe.ofFloat(0.4f, f2), Keyframe.ofFloat(0.5f, f2), Keyframe.ofFloat(0.6f, f2), Keyframe.ofFloat(0.7f, f2), Keyframe.ofFloat(0.8f, f2), Keyframe.ofFloat(0.9f, f2), Keyframe.ofFloat(1.0f, f2));
    }
}
