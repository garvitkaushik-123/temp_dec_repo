package io.bidmachine.iab.mraid;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: classes7.dex */
public class WebViewGestureDetector extends GestureDetector {

    /* renamed from: a, reason: collision with root package name */
    private final a f6837a;

    static class a extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        private boolean f6838a = false;

        a() {
        }

        boolean a() {
            return this.f6838a;
        }

        void b() {
            this.f6838a = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e) {
            this.f6838a = true;
            return super.onSingleTapUp(e);
        }
    }

    public WebViewGestureDetector(Context context) {
        this(context, new a());
    }

    public boolean isClicked() {
        return this.f6837a.a();
    }

    public void resetClick() {
        this.f6837a.b();
    }

    private WebViewGestureDetector(Context context, a listener) {
        super(context, listener);
        this.f6837a = listener;
        setIsLongpressEnabled(false);
    }
}
