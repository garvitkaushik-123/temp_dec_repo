package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.ironsource.Ac;
import com.ironsource.C3040d4;
import com.ironsource.C3153k;
import com.ironsource.C3170l;
import com.ironsource.C3179l8;
import com.ironsource.C3260q4;
import com.ironsource.C3264q8;
import com.ironsource.C3334ub;
import com.ironsource.C3342v2;
import com.ironsource.C3348v8;
import com.ironsource.D5;
import com.ironsource.F9;
import com.ironsource.InterfaceC3381x7;
import com.ironsource.Md;
import com.ironsource.Xf;
import com.ironsource.Z0;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.controller.v;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.vg;

/* loaded from: classes6.dex */
public class ControllerActivity extends Activity implements Ac, Xf {
    private static final String n = "ControllerActivity";
    private static final int o = 1;
    private static String p = "removeWebViewContainerView | mContainer is null";
    private static String q = "removeWebViewContainerView | view is null";

    /* renamed from: a, reason: collision with root package name */
    private String f3697a;
    private v b;
    private RelativeLayout c;
    private FrameLayout d;
    private InterfaceC3381x7 e;
    private String g;
    private Z0 k;
    private boolean l;
    private boolean m;
    public int currentRequestedRotation = -1;
    private boolean f = false;
    private Handler h = new Handler();
    private final Runnable i = new a();
    final RelativeLayout.LayoutParams j = new RelativeLayout.LayoutParams(-1, -1);

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControllerActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(ControllerActivity.this.f));
        }
    }

    class b implements View.OnSystemUiVisibilityChangeListener {
        b() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            if ((i & 4098) == 0) {
                ControllerActivity controllerActivity = ControllerActivity.this;
                controllerActivity.h.removeCallbacks(controllerActivity.i);
                ControllerActivity controllerActivity2 = ControllerActivity.this;
                controllerActivity2.h.postDelayed(controllerActivity2.i, 500L);
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControllerActivity.this.getWindow().addFlags(128);
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControllerActivity.this.getWindow().clearFlags(128);
        }
    }

    private FrameLayout a(String str) {
        return !b(str) ? this.b.r() : vg.a(getApplicationContext(), C3179l8.a().a(str).getPresentingView());
    }

    private boolean b(String str) {
        return (TextUtils.isEmpty(str) || str.equals(Integer.toString(1))) ? false : true;
    }

    private void c() {
        Intent intent = getIntent();
        a(intent.getStringExtra(C3040d4.h.A), intent.getIntExtra(C3040d4.h.B, 0));
    }

    private boolean d() {
        return this.f3697a == null;
    }

    private void e() {
        runOnUiThread(new c());
    }

    private void f() {
        ViewGroup viewGroup;
        try {
            if (this.c == null) {
                throw new Exception(p);
            }
            ViewGroup viewGroup2 = (ViewGroup) this.d.getParent();
            View a2 = a(viewGroup2);
            if (a2 == null) {
                throw new Exception(q);
            }
            if (isFinishing() && (viewGroup = (ViewGroup) a2.getParent()) != null) {
                viewGroup.removeView(a2);
            }
            viewGroup2.removeView(this.d);
        } catch (Exception e) {
            C3260q4.d().a(e);
            C3348v8.a(Md.s, new C3264q8().a(D5.A, e.getMessage()).a());
            Logger.i(n, "removeWebViewContainerView fail " + e.getMessage());
        }
    }

    private void g() {
        int K = this.e.K(this);
        String str = n;
        Logger.i(str, "setInitiateLandscapeOrientation");
        if (K == 0) {
            Logger.i(str, "ROTATION_0");
            setRequestedOrientation(0);
            return;
        }
        if (K == 2) {
            Logger.i(str, "ROTATION_180");
            setRequestedOrientation(8);
        } else if (K == 3) {
            Logger.i(str, "ROTATION_270 Right Landscape");
            setRequestedOrientation(8);
        } else if (K != 1) {
            Logger.i(str, "No Rotation");
        } else {
            Logger.i(str, "ROTATION_90 Left Landscape");
            setRequestedOrientation(0);
        }
    }

    private void h() {
        int K = this.e.K(this);
        String str = n;
        Logger.i(str, "setInitiatePortraitOrientation");
        if (K == 0) {
            Logger.i(str, "ROTATION_0");
            setRequestedOrientation(1);
            return;
        }
        if (K == 2) {
            Logger.i(str, "ROTATION_180");
            setRequestedOrientation(9);
        } else if (K == 1) {
            Logger.i(str, "ROTATION_270 Right Landscape");
            setRequestedOrientation(1);
        } else if (K != 3) {
            Logger.i(str, "No Rotation");
        } else {
            Logger.i(str, "ROTATION_90 Left Landscape");
            setRequestedOrientation(1);
        }
    }

    @Override // com.ironsource.Ac
    public boolean onBackButtonPressed() {
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Logger.i(n, "onBackPressed");
        if (C3342v2.a().a(this)) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.ironsource.Ac
    public void onCloseRequested() {
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = C3334ub.U().i();
        try {
            new C3170l(this).a();
            new C3153k(this).a();
            v vVar = (v) F9.b((Context) this).a().k();
            this.b = vVar;
            vVar.r().setId(1);
            this.b.a((Ac) this);
            this.b.a((Xf) this);
            Intent intent = getIntent();
            this.g = intent.getStringExtra(C3040d4.h.m);
            this.f = intent.getBooleanExtra(C3040d4.h.v, false);
            this.f3697a = intent.getStringExtra("adViewId");
            this.l = false;
            this.m = intent.getBooleanExtra(C3040d4.h.z0, false);
            if (this.f) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new b());
                runOnUiThread(this.i);
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.c = relativeLayout;
            setContentView(relativeLayout, this.j);
            this.d = a(this.f3697a);
            if (this.c.findViewById(1) == null && this.d.getParent() != null) {
                finish();
            }
            c();
            this.c.addView(this.d, this.j);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        String str = n;
        Logger.i(str, "onDestroy");
        f();
        if (this.l) {
            return;
        }
        Logger.i(str, "onDestroy | destroyedFromBackground");
        b();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.b.x()) {
            this.b.w();
            return true;
        }
        if (this.f && (i == 25 || i == 24)) {
            this.h.removeCallbacks(this.i);
            this.h.postDelayed(this.i, 500L);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.ironsource.Ac
    public void onOrientationChanged(String str, int i) {
        a(str, i);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        Logger.i(n, "onPause, isFinishing=" + isFinishing());
        t.a(this);
        v vVar = this.b;
        if (vVar != null) {
            vVar.a((Context) this);
            if (!this.m) {
                this.b.A();
            }
            this.b.a(false, C3040d4.h.Z);
            this.b.g(this.g, C3040d4.h.t0);
        }
        if (isFinishing()) {
            this.l = true;
            b();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Logger.i(n, C3040d4.h.u0);
        v vVar = this.b;
        if (vVar != null) {
            vVar.b(this);
            if (!this.m) {
                this.b.E();
            }
            this.b.a(true, C3040d4.h.Z);
            this.b.g(this.g, C3040d4.h.u0);
        }
        t.b(this);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Logger.i(n, "onStart");
        v vVar = this.b;
        if (vVar != null) {
            vVar.g(this.g, "onStart");
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Logger.i(n, "onStop");
        v vVar = this.b;
        if (vVar != null) {
            vVar.g(this.g, "onStop");
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Logger.i(n, "onUserLeaveHint");
        v vVar = this.b;
        if (vVar != null) {
            vVar.g(this.g, "onUserLeaveHint");
        }
    }

    @Override // com.ironsource.Xf
    public void onVideoEnded() {
        toggleKeepScreen(false);
    }

    @Override // com.ironsource.Xf
    public void onVideoPaused() {
        toggleKeepScreen(false);
    }

    @Override // com.ironsource.Xf
    public void onVideoResumed() {
        toggleKeepScreen(true);
    }

    @Override // com.ironsource.Xf
    public void onVideoStarted() {
        toggleKeepScreen(true);
    }

    @Override // com.ironsource.Xf
    public void onVideoStopped() {
        toggleKeepScreen(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f && z) {
            runOnUiThread(this.i);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (this.currentRequestedRotation != i) {
            Logger.i(n, "Rotation: Req = " + i + " Curr = " + this.currentRequestedRotation);
            this.currentRequestedRotation = i;
            super.setRequestedOrientation(i);
        }
    }

    public void toggleKeepScreen(boolean z) {
        if (z) {
            e();
        } else {
            a();
        }
    }

    private void b() {
        String str = n;
        Logger.i(str, "clearWebviewController");
        v vVar = this.b;
        if (vVar == null) {
            Logger.i(str, "clearWebviewController, null");
            return;
        }
        vVar.a(v.u.Gone);
        this.b.B();
        this.b.C();
        this.b.g(this.g, "onDestroy");
    }

    private void a(String str, int i) {
        if (str != null) {
            if (C3040d4.h.C.equalsIgnoreCase(str)) {
                g();
                return;
            }
            if (C3040d4.h.D.equalsIgnoreCase(str)) {
                h();
                return;
            }
            if (C3040d4.h.G.equalsIgnoreCase(str)) {
                if (this.e.w(this)) {
                    setRequestedOrientation(1);
                }
            } else if (getRequestedOrientation() == -1) {
                setRequestedOrientation(4);
            }
        }
    }

    private View a(ViewGroup viewGroup) {
        if (d()) {
            return viewGroup.findViewById(1);
        }
        return C3179l8.a().a(this.f3697a).getPresentingView();
    }

    private void a() {
        runOnUiThread(new d());
    }
}
