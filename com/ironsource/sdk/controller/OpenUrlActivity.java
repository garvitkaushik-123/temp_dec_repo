package com.ironsource.sdk.controller;

import android.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.ironsource.C3040d4;
import com.ironsource.C3260q4;
import com.ironsource.C3270qe;
import com.ironsource.F9;
import com.ironsource.InterfaceC3103h;
import com.ironsource.Q3;
import com.ironsource.Qf;
import com.ironsource.R9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;

/* loaded from: classes6.dex */
public class OpenUrlActivity extends Activity {
    private static final String j = "OpenUrlActivity";
    private static final int k = SDKUtils.generateViewId();
    private static final int l = SDKUtils.generateViewId();
    private v b;
    private ProgressBar c;
    boolean d;
    private RelativeLayout e;
    private String f;

    /* renamed from: a, reason: collision with root package name */
    private WebView f3704a = null;
    private final Handler g = new Handler(Looper.getMainLooper());
    private boolean h = false;
    private final Runnable i = new b();

    class a implements View.OnSystemUiVisibilityChangeListener {
        a() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            if ((i & 4098) == 0) {
                OpenUrlActivity openUrlActivity = OpenUrlActivity.this;
                openUrlActivity.g.removeCallbacks(openUrlActivity.i);
                OpenUrlActivity openUrlActivity2 = OpenUrlActivity.this;
                openUrlActivity2.g.postDelayed(openUrlActivity2.i, 500L);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OpenUrlActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(OpenUrlActivity.this.h));
        }
    }

    private class c extends WebViewClient {
        private c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            OpenUrlActivity.this.c.setVisibility(4);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            OpenUrlActivity.this.c.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            v vVar;
            super.onReceivedError(webView, i, str, str2);
            try {
                Q3 featureFlagCatchUrlError = FeaturesManager.getInstance().getFeatureFlagCatchUrlError();
                if (featureFlagCatchUrlError.b()) {
                    if (featureFlagCatchUrlError.e() && (vVar = OpenUrlActivity.this.b) != null) {
                        vVar.d(str, str2);
                    }
                    if (featureFlagCatchUrlError.d()) {
                        OpenUrlActivity.this.finish();
                    }
                }
            } catch (Throwable th) {
                C3260q4.d().a(th);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Logger.e(OpenUrlActivity.j, "Chromium process crashed - detail.didCrash():" + renderProcessGoneDetail.didCrash());
            OpenUrlActivity.this.finish();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!new C3270qe(str, R9.e().d(), FeaturesManager.getInstance().getFeatureFlagClickCheck().b()).a()) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            try {
                Qf.a(OpenUrlActivity.this, str);
                OpenUrlActivity.this.b.y();
            } catch (Exception e) {
                C3260q4.d().a(e);
                StringBuilder sb = new StringBuilder();
                if (e instanceof ActivityNotFoundException) {
                    sb.append(C3040d4.c.x);
                } else {
                    sb.append(C3040d4.c.y);
                }
                v vVar = OpenUrlActivity.this.b;
                if (vVar != null) {
                    vVar.d(sb.toString(), str);
                }
            }
            OpenUrlActivity.this.finish();
            return true;
        }
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        static final String f3708a = "is_store";
        static final String b = "external_url";
        static final String c = "secondary_web_view";
        static final String d = "immersive";
        static final String e = "no activity to handle url";
        static final String f = "activity failed to open with unspecified reason";

        private d() {
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC3103h f3709a;
        private int b;
        private String c;
        private boolean d = false;
        private boolean e = false;
        private boolean f = false;

        public e(InterfaceC3103h interfaceC3103h) {
            this.f3709a = interfaceC3103h;
        }

        e a(int i) {
            this.b = i;
            return this;
        }

        public e b(boolean z) {
            this.d = z;
            return this;
        }

        public e c(boolean z) {
            this.e = z;
            return this;
        }

        public e a(String str) {
            this.c = str;
            return this;
        }

        e a(boolean z) {
            this.f = z;
            return this;
        }

        public Intent a(Context context) {
            Intent a2 = this.f3709a.a(context);
            a2.putExtra("external_url", this.c);
            a2.putExtra("secondary_web_view", this.d);
            a2.putExtra("is_store", this.e);
            a2.putExtra(C3040d4.h.v, this.f);
            if (!(context instanceof Activity)) {
                a2.setFlags(this.b);
            }
            return a2;
        }
    }

    private void a() {
        if (this.c == null) {
            ProgressBar progressBar = new ProgressBar(new ContextThemeWrapper(this, R.style.Theme.Holo.Light.Dialog));
            this.c = progressBar;
            progressBar.setId(l);
        }
        if (findViewById(l) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.c.setLayoutParams(layoutParams);
            this.c.setVisibility(4);
            this.e.addView(this.c);
        }
    }

    private void b() {
        if (this.f3704a == null) {
            WebView webView = new WebView(getApplicationContext());
            this.f3704a = webView;
            webView.setId(k);
            this.f3704a.getSettings().setJavaScriptEnabled(true);
            this.f3704a.setWebViewClient(new c());
            loadUrl(this.f);
        }
        if (findViewById(k) == null) {
            this.e.addView(this.f3704a, new RelativeLayout.LayoutParams(-1, -1));
        }
        a();
        v vVar = this.b;
        if (vVar != null) {
            vVar.a(true, C3040d4.h.Y);
        }
    }

    private void c() {
        WebView webView = this.f3704a;
        if (webView != null) {
            webView.destroy();
        }
    }

    private void d() {
        getWindow().addFlags(16);
    }

    private void e() {
        requestWindowFeature(1);
    }

    private void f() {
        getWindow().setFlags(1024, 1024);
    }

    private void g() {
        ViewGroup viewGroup;
        v vVar = this.b;
        if (vVar != null) {
            vVar.a(false, C3040d4.h.Y);
            if (this.e == null || (viewGroup = (ViewGroup) this.f3704a.getParent()) == null) {
                return;
            }
            if (viewGroup.findViewById(k) != null) {
                viewGroup.removeView(this.f3704a);
            }
            if (viewGroup.findViewById(l) != null) {
                viewGroup.removeView(this.c);
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        v vVar;
        if (this.d && (vVar = this.b) != null) {
            vVar.c(C3040d4.h.j);
        }
        super.finish();
    }

    public void loadUrl(String str) {
        this.f3704a.stopLoading();
        this.f3704a.clearHistory();
        try {
            this.f3704a.loadUrl(str);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            Logger.e(j, "OpenUrlActivity:: loadUrl: " + th.toString());
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f3704a.canGoBack()) {
            this.f3704a.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.i(j, "onCreate()");
        try {
            this.b = (v) F9.b((Context) this).a().k();
            e();
            f();
            Bundle extras = getIntent().getExtras();
            this.f = extras.getString("external_url");
            this.d = extras.getBoolean("secondary_web_view");
            boolean booleanExtra = getIntent().getBooleanExtra(C3040d4.h.v, false);
            this.h = booleanExtra;
            if (booleanExtra) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new a());
                runOnUiThread(this.i);
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.e = relativeLayout;
            setContentView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        c();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.h && (i == 25 || i == 24)) {
            this.g.postDelayed(this.i, 500L);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        g();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.h && z) {
            runOnUiThread(this.i);
        }
    }
}
