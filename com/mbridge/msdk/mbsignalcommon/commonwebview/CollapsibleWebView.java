package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class CollapsibleWebView extends CommonWebView {
    private CopyOnWriteArrayList<CommonWebView.h> v;
    private CopyOnWriteArrayList<CommonWebView.h> w;
    private CopyOnWriteArrayList<e> x;
    private String y;
    private String z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CollapsibleWebView.this.hideToolBarButton("doCollapse");
            CollapsibleWebView.this.showToolBarButton("doSpand");
            CollapsibleWebView.this.d();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CollapsibleWebView.this.hideToolBarButton("doSpand");
            CollapsibleWebView.this.showToolBarButton("doCollapse");
            CollapsibleWebView.this.e();
        }
    }

    class c implements CommonWebView.i {
        c() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.i
        public void a(String str) {
            CollapsibleWebView collapsibleWebView = CollapsibleWebView.this;
            collapsibleWebView.b(collapsibleWebView.j, str);
        }
    }

    class d extends WebViewClient {

        /* renamed from: a, reason: collision with root package name */
        Boolean f4539a = Boolean.FALSE;
        String b = "";

        d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (this.f4539a.booleanValue()) {
                return;
            }
            CollapsibleWebView.this.a((View) webView, str);
            this.f4539a = Boolean.FALSE;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.b = str;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "error");
            hashMap.put("url", str2);
            hashMap.put("description", str);
            if (!this.f4539a.booleanValue() && this.b.equals(str2)) {
                this.f4539a = Boolean.TRUE;
                CollapsibleWebView.this.b(webView, hashMap);
            }
            CollapsibleWebView.this.a(webView, hashMap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "ssl");
            hashMap.put("url", sslError.getUrl());
            hashMap.put("description", "ssl error");
            if (!this.f4539a.booleanValue() && this.b.equals(sslError.getUrl() + "")) {
                this.f4539a = Boolean.TRUE;
                CollapsibleWebView.this.b(webView, hashMap);
            }
            CollapsibleWebView.this.a(webView, hashMap);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            p0.b("CollapsibleWebView", "WebView called onRenderProcessGone");
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "http");
            String str = webResourceRequest.getUrl() + "";
            hashMap.put("url", str);
            hashMap.put("statusCode", webResourceResponse.getStatusCode() + "");
            hashMap.put("description", "http error");
            if (!this.f4539a.booleanValue() && (this.b.equals(str) || TextUtils.isEmpty(this.b))) {
                this.f4539a = Boolean.TRUE;
                CollapsibleWebView.this.b(webView, hashMap);
            }
            CollapsibleWebView.this.a(webView, hashMap);
        }
    }

    public interface e {
        void a(View view, String str);

        void a(View view, Map<String, String> map);

        void b(View view, String str);

        void b(View view, Map<String, String> map);
    }

    public CollapsibleWebView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Iterator<CommonWebView.h> it = this.v.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Iterator<CommonWebView.h> it = this.w.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    private ToolBar.b getCollapseButton() {
        return new ToolBar.b("doCollapse").a(false).a("mbridge_arrow_down_white_blackbg").a(new a());
    }

    private ToolBar.b getExpandButton() {
        return new ToolBar.b("doSpand").a("mbridge_arrow_up_black").a(new b());
    }

    public String getCollapseIconName() {
        return this.y;
    }

    public String getExpandIconName() {
        return this.z;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView
    public void init() {
        super.init();
        this.v = new CopyOnWriteArrayList<>();
        this.w = new CopyOnWriteArrayList<>();
        this.x = new CopyOnWriteArrayList<>();
        this.y = "mbridge_arrow_down_white_blackbg";
        this.z = "mbridge_arrow_up_white";
        useDeeplink();
        initWebViewListener();
        useProgressBar();
        ArrayList<ToolBar.b> arrayList = new ArrayList<>();
        arrayList.add(getCollapseButton());
        arrayList.add(getExpandButton());
        useDefaultToolBar();
        useCustomizedToolBar(arrayList, true);
    }

    public void initWebViewListener() {
        setPageLoadTimtoutListener(new c());
        setPageLoadTimtout(CommonWebView.DEFAULT_JUMP_TIMEOUT);
        addWebViewClient(new d());
    }

    public void setCollapseIconName(String str) {
        this.y = str;
    }

    public void setCollapseListener(CommonWebView.h hVar) {
        this.v.add(hVar);
    }

    public void setCustomizedToolBarMarginWidthPixel(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        this.c.setLayoutParams(layoutParams);
    }

    public void setExpandIconName(String str) {
        this.z = str;
    }

    public void setExpandListener(CommonWebView.h hVar) {
        this.w.add(hVar);
    }

    public void setPageLoadListener(e eVar) {
        this.x.add(eVar);
    }

    public CollapsibleWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CollapsibleWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, String str) {
        Iterator<e> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().a(view, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, Map<String, String> map) {
        Iterator<e> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().b(view, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, Map<String, String> map) {
        Iterator<e> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().a(view, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, String str) {
        Iterator<e> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().b(view, str);
        }
    }
}
