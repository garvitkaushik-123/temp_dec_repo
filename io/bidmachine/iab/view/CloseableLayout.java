package io.bidmachine.iab.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.bidmachine.iab.utils.IabCloseWrapper;
import io.bidmachine.iab.utils.IabCountDownWrapper;
import io.bidmachine.iab.utils.IabElementStyle;

/* loaded from: classes7.dex */
public class CloseableLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final c f6930a;
    private IabCloseWrapper b;
    private IabCountDownWrapper c;
    private b d;
    private OnCloseClickListener e;
    private IabElementStyle f;
    private IabElementStyle g;

    public interface OnCloseClickListener {
        void onCloseClick();

        void onCountDownFinish();
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (CloseableLayout.this.e != null) {
                CloseableLayout.this.e.onCloseClick();
            }
        }
    }

    private class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CloseableLayout.this.c == null) {
                return;
            }
            long j = CloseableLayout.this.f6930a.d;
            if (CloseableLayout.this.isShown()) {
                j += 50;
                CloseableLayout.this.f6930a.a(j);
                CloseableLayout.this.c.changePercentage((int) ((100 * j) / CloseableLayout.this.f6930a.c), (int) Math.ceil((CloseableLayout.this.f6930a.c - j) / 1000.0d));
            }
            if (j < CloseableLayout.this.f6930a.c) {
                CloseableLayout.this.postDelayed(this, 50L);
                return;
            }
            CloseableLayout.this.c();
            if (CloseableLayout.this.f6930a.b <= 0.0f || CloseableLayout.this.e == null) {
                return;
            }
            CloseableLayout.this.e.onCountDownFinish();
        }

        /* synthetic */ b(CloseableLayout closeableLayout, a aVar) {
            this();
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private boolean f6933a;
        private float b;
        private long c;
        private long d;
        private long e;
        private long f;

        private c() {
            this.f6933a = false;
            this.b = 0.0f;
            this.c = 0L;
            this.d = 0L;
            this.e = 0L;
            this.f = 0L;
        }

        public long b() {
            return this.e > 0 ? System.currentTimeMillis() - this.e : this.f;
        }

        public boolean c() {
            long j = this.c;
            return j != 0 && this.d < j;
        }

        public boolean d() {
            return this.f6933a;
        }

        public void a(boolean visible, float closeTimeSec) {
            this.f6933a = visible;
            this.b = closeTimeSec;
            this.c = (long) (closeTimeSec * 1000.0f);
            this.d = 0L;
        }

        public void a(long currentOffset) {
            this.d = currentOffset;
        }

        public boolean a() {
            long j = this.c;
            return j == 0 || this.d >= j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean currentlyVisible) {
            if (this.e > 0) {
                this.f += System.currentTimeMillis() - this.e;
            }
            if (currentlyVisible) {
                this.e = System.currentTimeMillis();
            } else {
                this.e = 0L;
            }
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    public CloseableLayout(Context context) {
        super(context);
        this.f6930a = new c(null);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        IabCloseWrapper iabCloseWrapper = this.b;
        if (iabCloseWrapper != null) {
            iabCloseWrapper.bringToFront();
        }
        IabCountDownWrapper iabCountDownWrapper = this.c;
        if (iabCountDownWrapper != null) {
            iabCountDownWrapper.bringToFront();
        }
    }

    public boolean canBeClosed() {
        return this.f6930a.a();
    }

    public long getOnScreenTimeMs() {
        return this.f6930a.b();
    }

    public boolean isVisible() {
        return this.f6930a.d();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility != 0) {
            b();
        } else if (this.f6930a.c() && this.f6930a.d()) {
            a();
        }
        this.f6930a.a(visibility == 0);
    }

    public void setCloseClickListener(OnCloseClickListener closeClickListener) {
        this.e = closeClickListener;
    }

    public void setCloseStyle(IabElementStyle style) {
        this.f = style;
        IabCloseWrapper iabCloseWrapper = this.b;
        if (iabCloseWrapper == null || !iabCloseWrapper.isAttached()) {
            return;
        }
        this.b.attach(getContext(), this, style);
    }

    public void setCloseVisibility(boolean visible, float closeTimeSec) {
        if (this.f6930a.f6933a == visible && this.f6930a.b == closeTimeSec) {
            return;
        }
        this.f6930a.a(visible, closeTimeSec);
        if (visible) {
            c();
            return;
        }
        IabCloseWrapper iabCloseWrapper = this.b;
        if (iabCloseWrapper != null) {
            iabCloseWrapper.detach();
        }
        IabCountDownWrapper iabCountDownWrapper = this.c;
        if (iabCountDownWrapper != null) {
            iabCountDownWrapper.detach();
        }
        b();
    }

    public void setCountDownStyle(IabElementStyle style) {
        this.g = style;
        IabCountDownWrapper iabCountDownWrapper = this.c;
        if (iabCountDownWrapper == null || !iabCountDownWrapper.isAttached()) {
            return;
        }
        this.c.attach(getContext(), this, style);
    }

    private void a() {
        if (isShown()) {
            b();
            b bVar = new b(this, null);
            this.d = bVar;
            postDelayed(bVar, 50L);
        }
    }

    private void b() {
        b bVar = this.d;
        if (bVar != null) {
            removeCallbacks(bVar);
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f6930a.c()) {
            IabCloseWrapper iabCloseWrapper = this.b;
            if (iabCloseWrapper != null) {
                iabCloseWrapper.detach();
            }
            if (this.c == null) {
                this.c = new IabCountDownWrapper(null);
            }
            this.c.attach(getContext(), this, this.g);
            a();
            return;
        }
        b();
        if (this.b == null) {
            this.b = new IabCloseWrapper(new a());
        }
        this.b.attach(getContext(), this, this.f);
        IabCountDownWrapper iabCountDownWrapper = this.c;
        if (iabCountDownWrapper != null) {
            iabCountDownWrapper.detach();
        }
    }
}
