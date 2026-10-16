package com.fyber.inneractive.sdk.web;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public class m extends WebView {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1808a;
    public boolean b;
    public l c;
    public y0 d;
    public final com.fyber.inneractive.sdk.util.e1 e;
    public int f;
    public int g;

    public m() {
        super(IAConfigManager.O.v.a());
        this.f1808a = false;
        this.e = new com.fyber.inneractive.sdk.util.e1();
    }

    public final void a(String str) {
        IAlog.a("injecting JS: %s", str);
        if (str != null) {
            try {
                loadUrl("javascript:".concat(str));
            } catch (Throwable th) {
                IAlog.a("Failed to inject JS", th, new Object[0]);
            }
        }
    }

    public final void b() {
        IAlog.e("updateVisibility called - is = %s hwf = %s atw = %swinToken - %s app token - %s", Boolean.valueOf(isShown()), Boolean.valueOf(hasWindowFocus()), Boolean.valueOf(this.f1808a), getWindowToken(), getApplicationWindowToken());
        if (getWindowToken() != getApplicationWindowToken()) {
            a(getWindowVisibility() != 8 && isShown() && this.f1808a);
            return;
        }
        boolean z = isShown() && this.f1808a;
        if (IAConfigManager.O.u.b.a(false, "ignore_w_f")) {
            r2 = z;
        } else if (!z || !hasWindowFocus()) {
            r2 = false;
        }
        a(r2);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            super.destroy();
        } catch (Throwable unused) {
        }
        this.c = null;
    }

    public int getHeightDp() {
        return this.g;
    }

    public boolean getIsVisible() {
        return this.b;
    }

    public com.fyber.inneractive.sdk.util.e1 getLastClickedLocation() {
        return this.e;
    }

    public int getWidthDp() {
        return this.f;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1808a) {
            return;
        }
        this.f1808a = true;
        l lVar = this.c;
        if (lVar != null) {
            lVar.b();
        }
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = false;
        if (this.f1808a) {
            this.f1808a = false;
            l lVar = this.c;
            if (lVar != null) {
                lVar.c();
            }
            a();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        a();
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1 && motionEvent.getEventTime() - motionEvent.getDownTime() >= ViewConfiguration.getLongPressTimeout()) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, x, y, 0));
            dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, x, y, 0));
        }
        y0 y0Var = this.d;
        if (y0Var != null) {
            y0Var.onTouch(this, motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            com.fyber.inneractive.sdk.util.e1 e1Var = this.e;
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            e1Var.f1756a = x2;
            e1Var.b = y2;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        a();
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        IAlog.e("onWindowFocusChanged with: %s", Boolean.valueOf(z));
        a();
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8) {
            a(false);
        } else {
            a();
        }
    }

    public void setHeightDp(int i) {
        this.g = i;
    }

    public void setListener(l lVar) {
        this.c = lVar;
    }

    public void setTapListener(x0 x0Var) {
        this.d = new y0(x0Var, IAConfigManager.O.v.a());
    }

    public void setWidthDp(int i) {
        this.f = i;
    }

    public final void a(boolean z) {
        if (z) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                Rect rect = new Rect();
                viewGroup.getHitRect(rect);
                if (!getLocalVisibleRect(rect) && getWindowToken() == getApplicationWindowToken()) {
                    IAlog.e("updateVisibility - Cannot find local visible rect. Scrolled out?", new Object[0]);
                    z = false;
                }
            } else {
                IAlog.e("updateVisibility - No parent available", new Object[0]);
            }
        }
        if (this.b != z) {
            this.b = z;
            l lVar = this.c;
            if (lVar != null) {
                lVar.a(z);
            }
        }
    }

    public final void a() {
        if (IAConfigManager.O.u.b.a(false, "update_v_mth")) {
            com.fyber.inneractive.sdk.util.r.b.post(new k(this));
        } else {
            b();
        }
    }
}
