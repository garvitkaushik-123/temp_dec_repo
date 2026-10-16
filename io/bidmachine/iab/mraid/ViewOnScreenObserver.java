package io.bidmachine.iab.mraid;

import android.view.View;
import android.view.ViewTreeObserver;
import io.bidmachine.iab.utils.Utils;

/* loaded from: classes7.dex */
public class ViewOnScreenObserver {

    /* renamed from: a, reason: collision with root package name */
    private ViewOnScreenObserverRequest f6832a;

    public static class ViewOnScreenObserverRequest {

        /* renamed from: a, reason: collision with root package name */
        private final View[] f6833a;
        private final Runnable b = new a();
        private Runnable c;
        private int d;

        class a implements Runnable {

            /* renamed from: io.bidmachine.iab.mraid.ViewOnScreenObserver$ViewOnScreenObserverRequest$a$a, reason: collision with other inner class name */
            class ViewTreeObserverOnPreDrawListenerC0602a implements ViewTreeObserver.OnPreDrawListener {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ View f6835a;

                ViewTreeObserverOnPreDrawListenerC0602a(final View val$view) {
                    this.f6835a = val$view;
                }

                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    this.f6835a.getViewTreeObserver().removeOnPreDrawListener(this);
                    ViewOnScreenObserverRequest.this.b();
                    return true;
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                for (View view : ViewOnScreenObserverRequest.this.f6833a) {
                    if (view.getHeight() > 0 || view.getWidth() > 0) {
                        ViewOnScreenObserverRequest.this.b();
                    } else {
                        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC0602a(view));
                    }
                }
            }
        }

        public ViewOnScreenObserverRequest(final View[] views) {
            this.f6833a = views;
        }

        void b() {
            Runnable runnable;
            int i = this.d - 1;
            this.d = i;
            if (i != 0 || (runnable = this.c) == null) {
                return;
            }
            runnable.run();
            this.c = null;
        }

        public void start(Runnable successRunnable) {
            this.c = successRunnable;
            this.d = this.f6833a.length;
            Utils.postOnUiThread(this.b);
        }

        void a() {
            Utils.cancelOnUiThread(this.b);
            this.c = null;
        }
    }

    public void cancelLastRequest() {
        ViewOnScreenObserverRequest viewOnScreenObserverRequest = this.f6832a;
        if (viewOnScreenObserverRequest != null) {
            viewOnScreenObserverRequest.a();
            this.f6832a = null;
        }
    }

    public ViewOnScreenObserverRequest wait(View... views) {
        cancelLastRequest();
        ViewOnScreenObserverRequest viewOnScreenObserverRequest = new ViewOnScreenObserverRequest(views);
        this.f6832a = viewOnScreenObserverRequest;
        return viewOnScreenObserverRequest;
    }
}
