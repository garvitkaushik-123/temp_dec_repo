package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.foundation.webview.ProgressBar;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class CommonWebView extends LinearLayout {
    public static int DEFAULT_JUMP_TIMEOUT = 10000;

    /* renamed from: a, reason: collision with root package name */
    private int f4540a;
    private int b;
    protected ToolBar c;
    protected ToolBar d;
    protected ProgressBar e;
    private RelativeLayout f;
    private View.OnClickListener g;
    private com.mbridge.msdk.mbsignalcommon.commonwebview.b h;
    private com.mbridge.msdk.mbsignalcommon.commonwebview.a i;
    protected BaseWebView j;
    private View.OnClickListener k;
    private View.OnClickListener l;
    private View.OnClickListener m;
    private View.OnClickListener n;
    private Handler o;
    private int p;
    private WebViewClient q;
    private String r;
    private i s;
    private boolean t;
    private final Runnable u;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p0.b("CommonWebView", "webview js!！超时上限：" + CommonWebView.this.p + "ms");
            if (CommonWebView.this.s != null) {
                CommonWebView.this.t = false;
                CommonWebView.this.s.a(CommonWebView.this.r);
            }
        }
    }

    class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            p0.c("CommonWebView", "newProgress! 开始! = " + str);
            CommonWebView.this.e.setVisible(true);
            CommonWebView.this.e.setProgressState(5);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (webView != null) {
                try {
                    ViewGroup viewGroup = (ViewGroup) webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(webView);
                    }
                    if (webView instanceof WindVaneWebView) {
                        ((WindVaneWebView) webView).release();
                    } else {
                        webView.destroy();
                    }
                } catch (Throwable th) {
                    p0.b("CommonWebView", th.getMessage());
                }
            }
            return true;
        }
    }

    class c extends WebChromeClient {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CommonWebView.this.e.setVisible(false);
            }
        }

        c() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            p0.c("CommonWebView", "newProgress! = " + i);
            if (i == 100) {
                CommonWebView.this.e.setProgressState(7);
                new Handler().postDelayed(new a(), 200L);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseWebView baseWebView = CommonWebView.this.j;
            if (baseWebView != null) {
                baseWebView.stopLoading();
                String str = (String) view.getTag();
                if (TextUtils.equals(str, ToolBar.BACKWARD)) {
                    CommonWebView.this.d.getItem(ToolBar.FORWARD).setEnabled(true);
                    if (CommonWebView.this.j.canGoBack()) {
                        CommonWebView.this.j.goBack();
                    }
                    CommonWebView.this.d.getItem(ToolBar.BACKWARD).setEnabled(CommonWebView.this.j.canGoBack());
                    if (CommonWebView.this.k != null) {
                        CommonWebView.this.k.onClick(view);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(str, ToolBar.FORWARD)) {
                    CommonWebView.this.d.getItem(ToolBar.BACKWARD).setEnabled(true);
                    if (CommonWebView.this.j.canGoForward()) {
                        CommonWebView.this.j.goForward();
                    }
                    CommonWebView.this.d.getItem(ToolBar.FORWARD).setEnabled(CommonWebView.this.j.canGoForward());
                    if (CommonWebView.this.l != null) {
                        CommonWebView.this.l.onClick(view);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(str, ToolBar.REFRESH)) {
                    CommonWebView.this.d.getItem(ToolBar.BACKWARD).setEnabled(CommonWebView.this.j.canGoBack());
                    CommonWebView.this.d.getItem(ToolBar.FORWARD).setEnabled(CommonWebView.this.j.canGoForward());
                    CommonWebView.this.j.reload();
                    if (CommonWebView.this.m != null) {
                        CommonWebView.this.m.onClick(view);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(str, ToolBar.EXITS)) {
                    if (CommonWebView.this.g != null) {
                        CommonWebView.this.g.onClick(view);
                    }
                } else if (TextUtils.equals(str, ToolBar.OPEN_BY_BROWSER)) {
                    if (CommonWebView.this.n != null) {
                        CommonWebView.this.n.onClick(view);
                    }
                    com.mbridge.msdk.click.c.c(CommonWebView.this.getContext(), CommonWebView.this.j.getUrl());
                }
            }
        }
    }

    class e extends WebViewClient {
        e() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            CommonWebView.this.d.getItem(ToolBar.BACKWARD).setEnabled(true);
            CommonWebView.this.d.getItem(ToolBar.FORWARD).setEnabled(false);
            return false;
        }
    }

    class f extends WebViewClient {
        f() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (t0.a.b(str)) {
                t0.a.a(CommonWebView.this.getContext(), str, null);
            }
            return CommonWebView.this.a(webView, str);
        }
    }

    class g extends WebViewClient {
        g() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            CommonWebView.this.t = false;
            CommonWebView.this.a();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            CommonWebView.this.r = str;
            if (CommonWebView.this.t) {
                return;
            }
            CommonWebView.this.t = true;
            CommonWebView.this.c();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            CommonWebView.this.t = false;
            CommonWebView.this.a();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            CommonWebView.this.r = str;
            if (CommonWebView.this.t) {
                CommonWebView.this.a();
            }
            CommonWebView.this.t = true;
            CommonWebView.this.c();
            return false;
        }
    }

    public interface h {
        void a();
    }

    public interface i {
        void a(String str);
    }

    public CommonWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.u = new a();
        init();
    }

    public void addWebChromeClient(WebChromeClient webChromeClient) {
        this.i.a(webChromeClient);
    }

    public void addWebViewClient(WebViewClient webViewClient) {
        this.h.a(webViewClient);
    }

    public View findToolBarButton(String str) {
        ToolBar toolBar;
        ToolBar toolBar2 = this.c;
        View item = toolBar2 != null ? toolBar2.getItem(str) : null;
        return (item != null || (toolBar = this.d) == null) ? item : toolBar.getItem(str);
    }

    public String getUrl() {
        BaseWebView baseWebView = this.j;
        return baseWebView == null ? "" : baseWebView.getUrl();
    }

    public WebView getWebView() {
        return this.j;
    }

    public void hideCustomizedToolBar() {
        ToolBar toolBar = this.c;
        if (toolBar != null) {
            toolBar.setVisibility(8);
        }
    }

    public void hideDefaultToolBar() {
        ToolBar toolBar = this.d;
        if (toolBar != null) {
            toolBar.setVisibility(8);
        }
    }

    public void hideToolBarButton(String str) {
        View findToolBarButton = findToolBarButton(str);
        if (findToolBarButton != null) {
            findToolBarButton.setVisibility(8);
        }
    }

    public void hideToolBarTitle() {
        this.c.hideTitle();
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        this.f = new RelativeLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        addView(this.f, layoutParams);
        this.f4540a = u0.a(getContext(), 40.0f);
        this.b = u0.a(getContext(), 40.0f);
        this.h = new com.mbridge.msdk.mbsignalcommon.commonwebview.b();
        this.i = new com.mbridge.msdk.mbsignalcommon.commonwebview.a();
        initWebview();
    }

    public void initWebview() {
        try {
            if (this.j == null) {
                this.j = new BaseWebView(getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(10);
            this.j.setLayoutParams(layoutParams);
            BaseWebView baseWebView = this.j;
            com.mbridge.msdk.mbsignalcommon.base.b bVar = baseWebView.mWebViewClient;
            baseWebView.setWebViewClient(this.h);
            this.j.setWebChromeClient(this.i);
            addWebViewClient(bVar);
        } catch (Throwable th) {
            p0.b("CommonWebView", "webview is error", th);
        }
        this.f.addView(this.j);
    }

    public void loadUrl(String str) {
        this.j.loadUrl(str);
        if (this.q != null) {
            c();
        }
    }

    public void onBackwardClicked(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void onForwardClicked(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void onOpenByBrowserClicked(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }

    public void onRefreshClicked(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void removeWebChromeClient(WebChromeClient webChromeClient) {
        this.i.b(webChromeClient);
    }

    public void removeWebViewClient(WebViewClient webViewClient) {
        this.h.b(webViewClient);
    }

    public void setCustomizedToolBarFloating() {
        ((ViewGroup) this.c.getParent()).removeView(this.c);
        this.f.addView(this.c);
    }

    public void setCustomizedToolBarUnfloating() {
        ((ViewGroup) this.c.getParent()).removeView(this.c);
        addView(this.c, 0);
    }

    public void setExitsClickListener(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    public void setPageLoadTimtout(int i2) {
        this.p = i2;
        if (this.o == null) {
            this.o = new Handler(Looper.getMainLooper());
        }
        if (this.q == null) {
            g gVar = new g();
            this.q = gVar;
            addWebViewClient(gVar);
        }
    }

    public void setPageLoadTimtoutListener(i iVar) {
        this.s = iVar;
    }

    public void setToolBarTitle(String str, int i2) {
        this.c.setTitle(str, i2);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        addWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        addWebViewClient(webViewClient);
    }

    public void showCustomizedToolBar() {
        ToolBar toolBar = this.c;
        if (toolBar != null) {
            toolBar.setVisibility(0);
        }
    }

    public void showDefaultToolBar() {
        ToolBar toolBar = this.d;
        if (toolBar != null) {
            toolBar.setVisibility(0);
        }
    }

    public void showToolBarButton(String str) {
        View findToolBarButton = findToolBarButton(str);
        if (findToolBarButton != null) {
            findToolBarButton.setVisibility(0);
        }
    }

    public void showToolBarTitle() {
        this.c.showTitle();
    }

    public void useCustomizedToolBar(ArrayList<ToolBar.b> arrayList, boolean z) {
        a(arrayList, z);
    }

    public void useDeeplink() {
        addWebViewClient(new f());
    }

    public void useDefaultToolBar() {
        b();
    }

    public void useProgressBar() {
        ProgressBar progressBar = new ProgressBar(getContext());
        this.e = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        addWebViewClient(new b());
        addWebChromeClient(new c());
        addView(this.e);
        this.e.initResource(true);
    }

    private void b() {
        if (this.d != null) {
            return;
        }
        this.d = new ToolBar(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.b);
        layoutParams.bottomMargin = 0;
        this.d.setLayoutParams(layoutParams);
        this.d.setBackgroundColor(-1);
        this.d.setOnItemClickListener(new d());
        addWebViewClient(new e());
        addView(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.o.postDelayed(this.u, this.p);
    }

    public void setToolBarTitle(String str) {
        this.c.setTitle(str);
    }

    public void useCustomizedToolBar(ArrayList<ToolBar.b> arrayList) {
        a(arrayList, false);
    }

    private void a(ArrayList<ToolBar.b> arrayList, boolean z) {
        if (this.c != null) {
            return;
        }
        ToolBar.a aVar = new ToolBar.a();
        aVar.a(40);
        aVar.b(80);
        ToolBar toolBar = new ToolBar(getContext(), aVar, arrayList);
        this.c = toolBar;
        toolBar.setBackgroundColor(Color.argb(153, 255, 255, 255));
        if (z) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f4540a);
            layoutParams.addRule(10);
            this.c.setLayoutParams(layoutParams);
            this.f.addView(this.c);
            return;
        }
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f4540a));
        addView(this.c, 0);
    }

    public CommonWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = new a();
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            if (!parse.getScheme().equals("http") && !parse.getScheme().equals("https")) {
                if (parse.getScheme().equals("intent")) {
                    Intent parseUri = Intent.parseUri(str, 1);
                    try {
                        String str2 = parseUri.getPackage();
                        if (!TextUtils.isEmpty(str2) && getContext().getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            parseUri.setComponent(null);
                            parseUri.setSelector(null);
                            parseUri.setFlags(268435456);
                            getContext().startActivity(parseUri);
                            return true;
                        }
                    } catch (Throwable th) {
                        p0.b("CommonWebView", th.getMessage());
                    }
                    try {
                        String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            Uri parse2 = Uri.parse(str);
                            if (!parse2.getScheme().equals("http") && !parse2.getScheme().equals("https")) {
                                str = stringExtra;
                            }
                            webView.loadUrl(stringExtra);
                            return false;
                        }
                    } catch (Throwable th2) {
                        p0.b("CommonWebView", th2.getMessage());
                    }
                }
                if (com.mbridge.msdk.click.c.d(getContext(), str)) {
                    p0.b("CommonWebView", "openDeepLink");
                    return true;
                }
                if (!TextUtils.isEmpty(str)) {
                    return !(str.startsWith("http") || str.startsWith("https"));
                }
            }
            return false;
        } catch (Throwable th3) {
            p0.b("CommonWebView", th3.getMessage());
            return false;
        }
    }

    public CommonWebView(Context context) {
        super(context);
        this.u = new a();
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.o.removeCallbacks(this.u);
    }
}
