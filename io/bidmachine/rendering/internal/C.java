package io.bidmachine.rendering.internal;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import io.bidmachine.iab.utils.VisibilityTracker;
import io.bidmachine.rendering.internal.B;
import io.bidmachine.rendering.model.VisibilityParams;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.util.ViewUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes8.dex */
public class C implements B {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<View> f6942a;
    private final VisibilityParams b;
    private final B.a c;
    private final Runnable d;
    private final ViewTreeObserver.OnPreDrawListener e;
    private final Object f = new Object();
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean(false);

    private class b implements n {
        private b() {
        }

        @Override // io.bidmachine.util.SafeRunnable
        public void onRun() {
            if (C.this.c()) {
                return;
            }
            C.this.d();
        }

        @Override // io.bidmachine.rendering.internal.n, io.bidmachine.util.SafeRunnable
        public void onThrows(Throwable throwable) {
            super.onThrows(throwable);
            C.this.d();
        }
    }

    private class c implements ViewTreeObserver.OnPreDrawListener {
        private c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            C.this.h();
            return true;
        }
    }

    public C(View view, VisibilityParams visibilityParams, B.a callback) {
        this.f6942a = new WeakReference<>(view);
        this.b = visibilityParams;
        this.c = callback;
        this.d = new b();
        this.e = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.h.set(false);
        h();
    }

    private void f() {
        if (this.i.compareAndSet(false, true)) {
            this.c.a();
        }
    }

    private void g() {
        if (this.i.compareAndSet(true, false)) {
            this.c.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.h.compareAndSet(false, true)) {
            UiUtils.cancelOnUiThread(this.d);
            UiUtils.onUiThread(this.d, 100L);
        }
    }

    public View e() {
        return this.f6942a.get();
    }

    @Override // io.bidmachine.rendering.internal.B
    public void start() {
        synchronized (this.f) {
            if (this.g.compareAndSet(false, true)) {
                View e = e();
                if (e == null) {
                    stop();
                    return;
                }
                o.b(VisibilityTracker.TAG, "Start tracking - %s", e);
                ViewTreeObserver viewTreeObserver = e.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnPreDrawListener(this.e);
                }
            }
        }
    }

    @Override // io.bidmachine.rendering.internal.B
    public void stop() {
        synchronized (this.f) {
            this.g.set(false);
            View e = e();
            if (e != null) {
                o.b(VisibilityTracker.TAG, "Stop tracking - %s", e);
                ViewTreeObserver viewTreeObserver = e.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.e);
                }
            }
            UiUtils.cancelOnUiThread(this.d);
            this.h.set(false);
            this.i.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        View e = e();
        if (e == null) {
            stop();
            return true;
        }
        if (a(e, this.b.getVisibilityPercent(), this.b.getIsIgnoreWindowFocus(), this.b.getIsIgnoreOverlap())) {
            f();
            return false;
        }
        g();
        return false;
    }

    @Override // io.bidmachine.rendering.internal.B
    public void a() {
        stop();
        this.f6942a.clear();
    }

    @Override // io.bidmachine.rendering.internal.B
    public boolean b() {
        return this.i.get();
    }

    private boolean a(View view, float visibilityPercent, boolean ignoreWindowFocus, boolean ignoreOverlap) {
        try {
        } catch (Exception e) {
            o.b(e);
        }
        if (!view.isShown()) {
            o.b(VisibilityTracker.TAG, "Show wasn't tracked: view visibility verification failed - %s", view);
            return false;
        }
        if (UiUtils.isViewTransparent(view)) {
            o.b(VisibilityTracker.TAG, "Show wasn't tracked: view transparent verification failed - %s", view);
            return false;
        }
        if (!ignoreWindowFocus && !view.hasWindowFocus()) {
            o.b(VisibilityTracker.TAG, "Show wasn't tracked: window focus verification failed - %s", view);
            return false;
        }
        float width = view.getWidth() * view.getHeight();
        if (width == 0.0f) {
            o.b(VisibilityTracker.TAG, "Show wasn't tracked: view size verification failed - %s", view);
            return false;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            o.b(VisibilityTracker.TAG, "Show wasn't tracked: global visibility verification failed - %s", view);
            return false;
        }
        float width2 = (rect.width() * rect.height()) / width;
        if (width2 < visibilityPercent) {
            o.b(VisibilityTracker.TAG, "Show wasn't tracked: ad view not completely visible (%s / %s) - %s", Float.valueOf(width2), Float.valueOf(visibilityPercent), view);
            return false;
        }
        View a2 = a(view);
        if (a2 == null) {
            o.b(VisibilityTracker.TAG, "Show wasn't tracked: content or root layout not found - %s", view);
            return false;
        }
        Rect rect2 = new Rect();
        a2.getGlobalVisibleRect(rect2);
        if (!Rect.intersects(rect, rect2)) {
            o.b(VisibilityTracker.TAG, "Show wasn't tracked: ad view is out of current window - %s", view);
            return false;
        }
        if (!ignoreOverlap) {
            ViewGroup viewGroup = (ViewGroup) view.getRootView();
            View view2 = view;
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            int i = 0;
            while (viewGroup2 != null) {
                for (int indexOfChild = viewGroup2.indexOfChild(view2) + 1; indexOfChild < viewGroup2.getChildCount(); indexOfChild++) {
                    View childAt = viewGroup2.getChildAt(indexOfChild);
                    if (ViewUtils.isViewVisible(childAt)) {
                        Rect locationInWindow = UiUtils.getLocationInWindow(childAt);
                        if (Rect.intersects(rect, locationInWindow)) {
                            float notOverlappedAreaPercent = UiUtils.getNotOverlappedAreaPercent(rect, locationInWindow);
                            if (notOverlappedAreaPercent < visibilityPercent) {
                                o.b(VisibilityTracker.TAG, "Show wasn't tracked: ad view is covered by another view (visible percent - %s / %s, ad view - %s, overlapping view - %s)", Float.valueOf(notOverlappedAreaPercent), Float.valueOf(visibilityPercent), view2, childAt);
                                return false;
                            }
                            i++;
                            if (i >= 3) {
                                o.b(VisibilityTracker.TAG, "Show wasn't tracked: ad view is covered by too many views (overlapping views count - %s, ad view - %s)", Integer.valueOf(i), view2);
                                return false;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (viewGroup2 != viewGroup) {
                    view2 = viewGroup2;
                    viewGroup2 = (ViewGroup) viewGroup2.getParent();
                } else {
                    viewGroup2 = null;
                }
            }
        }
        return true;
    }

    private View a(View view) {
        View view2 = null;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            view2 = (View) parent;
            if (view2.getId() == 16908290) {
                return view2;
            }
        }
        return view2;
    }
}
