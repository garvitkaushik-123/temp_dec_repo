package com.applovin.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.applovin.impl.adview.AppLovinWebViewBase;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class j0 extends AppLovinWebViewBase {
    private static Boolean b;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference f488a;

    public j0(Context context) {
        super(context);
        this.f488a = new AtomicReference();
        if (b == null) {
            try {
                WebView.class.getDeclaredMethod("onTouchEvent", MotionEvent.class);
                b = Boolean.TRUE;
            } catch (NoSuchMethodException unused) {
                com.applovin.impl.sdk.o.h("AppLovinSdk", "WebView.onTouchEvent() not implemented");
                b = Boolean.FALSE;
            }
        }
    }

    public boolean a() {
        return this.f488a.get() != null;
    }

    public MotionEvent getAndClearLastClickEvent() {
        return (MotionEvent) this.f488a.getAndSet(null);
    }

    public MotionEvent getLastClickEvent() {
        return (MotionEvent) this.f488a.get();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f488a.set(MotionEvent.obtain(motionEvent));
        if (b.booleanValue()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
