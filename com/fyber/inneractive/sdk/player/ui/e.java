package com.fyber.inneractive.sdk.player.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.e1;
import com.fyber.inneractive.sdk.util.f1;

/* loaded from: classes4.dex */
public abstract class e extends RelativeLayout implements m {

    /* renamed from: a, reason: collision with root package name */
    public final e1 f1642a;
    public final int b;
    public s0 c;
    public UnitDisplayType d;
    public boolean e;
    public boolean f;
    public n g;
    public boolean h;

    public e(Context context) {
        super(context, null, 0);
        this.f1642a = new e1();
        this.b = 0;
        this.e = false;
        this.f = false;
        this.h = false;
        this.b = Math.min(com.fyber.inneractive.sdk.util.o.e(), com.fyber.inneractive.sdk.util.o.d());
    }

    public abstract void a(f1 f1Var, int i, int i2);

    @Override // com.fyber.inneractive.sdk.player.ui.m
    public boolean a() {
        return false;
    }

    public void b() {
        this.h = true;
    }

    public void c() {
        this.h = false;
    }

    public final void d() {
        boolean z = isShown() && hasWindowFocus() && this.f && !this.h;
        if (z) {
            z = getGlobalVisibleRect(new Rect());
        }
        if (z == this.e || this.g == null) {
            return;
        }
        IAlog.a("%supdateVisibility changing to %s", IAlog.a(this), Boolean.valueOf(z));
        this.e = z;
        this.g.a(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        IAlog.a("%sGot onAttachedToWindow: mIsAttached = %s", IAlog.a(this), Boolean.valueOf(this.f));
        this.f = true;
        n nVar = this.g;
        if (nVar != null) {
            nVar.a();
        }
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IAlog.a("%sGot onDetachedFromWindow: mIsAttached = %s", IAlog.a(this), Boolean.valueOf(this.f));
        this.f = false;
        n nVar = this.g;
        if (nVar != null) {
            nVar.c();
        }
        d();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (equals(view)) {
            IAlog.a("%sgot onVisibilityChanged with %d", IAlog.a(this), Integer.valueOf(i));
            d();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        IAlog.a("%sgot onWindowFocusChanged with: %s", IAlog.a(this), Boolean.valueOf(z));
        com.fyber.inneractive.sdk.util.r.b.postDelayed(new d(this, z), 500L);
    }

    public void setListener(n nVar) {
        this.g = nVar;
    }

    public void setUnitConfig(s0 s0Var) {
        this.c = s0Var;
        r0 r0Var = (r0) s0Var;
        this.d = r0Var.e == null ? r0Var.f.j : UnitDisplayType.DEFAULT;
    }
}
