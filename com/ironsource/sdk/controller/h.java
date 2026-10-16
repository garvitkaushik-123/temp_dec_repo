package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ironsource.Ac;
import com.ironsource.C3040d4;
import com.ironsource.C3260q4;
import com.ironsource.C3334ub;
import com.ironsource.C3342v2;
import com.ironsource.InterfaceC3381x7;
import com.ironsource.sdk.controller.v;

/* loaded from: classes6.dex */
public class h extends FrameLayout implements Ac {

    /* renamed from: a, reason: collision with root package name */
    private Context f3742a;
    private v b;
    private final InterfaceC3381x7 c;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup windowDecorViewGroup = h.this.getWindowDecorViewGroup();
            if (windowDecorViewGroup != null) {
                windowDecorViewGroup.addView(h.this);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup windowDecorViewGroup = h.this.getWindowDecorViewGroup();
            if (windowDecorViewGroup != null) {
                windowDecorViewGroup.removeView(h.this);
            }
        }
    }

    public h(Context context) {
        super(context);
        this.c = C3334ub.U().i();
        this.f3742a = context;
        setClickable(true);
    }

    private void b() {
        ((Activity) this.f3742a).runOnUiThread(new b());
    }

    private int getNavigationBarPadding() {
        Activity activity = (Activity) this.f3742a;
        try {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getDrawingRect(rect);
            Rect rect2 = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (this.c.z(activity) == 1) {
                int i = rect.bottom - rect2.bottom;
                if (i > 0) {
                    return i;
                }
                return 0;
            }
            int i2 = rect.right - rect2.right;
            if (i2 > 0) {
                return i2;
            }
            return 0;
        } catch (Exception e) {
            C3260q4.d().a(e);
            return 0;
        }
    }

    private int getStatusBarHeight() {
        int identifier;
        try {
            Context context = this.f3742a;
            if (context == null || (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
                return 0;
            }
            return this.f3742a.getResources().getDimensionPixelSize(identifier);
        } catch (Exception e) {
            C3260q4.d().a(e);
            return 0;
        }
    }

    private int getStatusBarPadding() {
        int statusBarHeight;
        if ((((Activity) this.f3742a).getWindow().getAttributes().flags & 1024) == 0 && (statusBarHeight = getStatusBarHeight()) > 0) {
            return statusBarHeight;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup getWindowDecorViewGroup() {
        Activity activity = (Activity) this.f3742a;
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }

    public void a(v vVar) {
        this.b = vVar;
        vVar.a(this);
        this.b.D();
        this.f3742a = this.b.p();
        a(getStatusBarPadding(), getNavigationBarPadding());
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.E();
        this.b.a(true, C3040d4.h.Z);
    }

    @Override // com.ironsource.Ac
    public boolean onBackButtonPressed() {
        return C3342v2.a().a((Activity) this.f3742a);
    }

    @Override // com.ironsource.Ac
    public void onCloseRequested() {
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.A();
        this.b.a(false, C3040d4.h.Z);
        v vVar = this.b;
        if (vVar != null) {
            vVar.a(v.u.Gone);
            this.b.B();
            this.b.C();
        }
        removeAllViews();
    }

    @Override // com.ironsource.Ac
    public void onOrientationChanged(String str, int i) {
    }

    private void a() {
        ((Activity) this.f3742a).runOnUiThread(new a());
    }

    private void a(int i, int i2) {
        try {
            Context context = this.f3742a;
            if (context != null) {
                int z = this.c.z(context);
                if (z == 1) {
                    setPadding(0, i, 0, i2);
                } else if (z == 2) {
                    setPadding(0, i, i2, 0);
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
        }
    }
}
