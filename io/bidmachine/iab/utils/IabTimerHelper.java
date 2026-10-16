package io.bidmachine.iab.utils;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes7.dex */
public class IabTimerHelper {

    /* renamed from: a, reason: collision with root package name */
    private final View f6853a;
    private final TimerHelperCallback b;
    private boolean c = false;
    private float d = 0.0f;
    private long e = 0;
    private long f = 0;
    private final ViewTreeObserver.OnGlobalLayoutListener g;
    private final Runnable h;

    public interface TimerHelperCallback {
        void onTimerFinish();

        void onTimerTick(float percent, long currentTimeMs, long totalTimeMs);
    }

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IabTimerHelper.this.a();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long j = IabTimerHelper.this.f;
            if (IabTimerHelper.this.f6853a.isShown()) {
                j = Math.min(IabTimerHelper.this.e, j + 16);
                IabTimerHelper.this.a(j);
                IabTimerHelper.this.b.onTimerTick((IabTimerHelper.this.f * 100.0f) / IabTimerHelper.this.e, IabTimerHelper.this.f, IabTimerHelper.this.e);
            }
            if (j >= IabTimerHelper.this.e) {
                IabTimerHelper.this.b.onTimerFinish();
            } else {
                IabTimerHelper.this.f6853a.postDelayed(this, 16L);
            }
        }
    }

    public IabTimerHelper(View view, TimerHelperCallback callback) {
        a aVar = new a();
        this.g = aVar;
        this.h = new b();
        this.f6853a = view;
        this.b = callback;
        view.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
        a();
    }

    public void detach() {
        stop();
        this.f6853a.getViewTreeObserver().removeGlobalOnLayoutListener(this.g);
    }

    public boolean isTicking() {
        long j = this.e;
        return j != 0 && this.f < j;
    }

    public void setTime(float timeSec) {
        if (this.d == timeSec) {
            return;
        }
        this.d = timeSec;
        this.e = (long) (timeSec * 1000.0f);
        start();
    }

    public void start() {
        if (!this.f6853a.isShown() || this.e == 0) {
            return;
        }
        this.f6853a.postDelayed(this.h, 16L);
    }

    public void stop() {
        this.f6853a.removeCallbacks(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long currentTimeMs) {
        this.f = currentTimeMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        boolean isShown = this.f6853a.isShown();
        if (this.c == isShown) {
            return;
        }
        this.c = isShown;
        if (!isShown) {
            stop();
        } else if (isTicking()) {
            start();
        }
    }
}
