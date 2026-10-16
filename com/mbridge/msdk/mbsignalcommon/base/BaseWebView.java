package com.mbridge.msdk.mbsignalcommon.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.foundation.tools.p0;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class BaseWebView extends WebView {

    /* renamed from: a, reason: collision with root package name */
    protected Context f4531a;
    private View.OnTouchListener b;
    private View.OnTouchListener c;
    public long lastTouchTime;
    public b mWebViewClient;

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                BaseWebView.this.lastTouchTime = System.currentTimeMillis();
            }
            if (BaseWebView.this.b != null) {
                return BaseWebView.this.b.onTouch(view, motionEvent);
            }
            return false;
        }
    }

    public BaseWebView(Context context) {
        super(context);
        this.lastTouchTime = 0L;
        this.c = new a();
        this.f4531a = context;
        a();
    }

    @Override // android.webkit.WebView
    public void reload() {
        super.reload();
    }

    public void setFilter(com.mbridge.msdk.mbsignalcommon.base.a aVar) {
        b bVar = this.mWebViewClient;
        if (bVar == null || !(bVar instanceof b)) {
            return;
        }
        bVar.a(aVar);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.b = onTouchListener;
    }

    public void setTransparent() {
        setLayerType(1, null);
        setBackgroundColor(0);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof b) {
            this.mWebViewClient = (b) webViewClient;
        }
    }

    protected void a() {
        if (this.mWebViewClient == null) {
            b bVar = new b();
            this.mWebViewClient = bVar;
            setWebViewClient(bVar);
        }
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        try {
            settings.setSafeBrowsingEnabled(false);
        } catch (Throwable th) {
            p0.b("BaseWebView", th.getMessage());
        }
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        try {
            settings.setMixedContentMode(0);
        } catch (Exception e) {
            p0.b("BaseWebView", e.getMessage());
        }
        settings.setDatabaseEnabled(true);
        String path = this.f4531a.getDir("database", 0).getPath();
        settings.setDatabasePath(path);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
        try {
            Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(settings, Boolean.FALSE);
        } catch (Exception e2) {
            p0.b("BaseWebView", e2.getMessage());
        }
        super.setOnTouchListener(this.c);
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lastTouchTime = 0L;
        this.c = new a();
        this.f4531a = context;
        a();
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastTouchTime = 0L;
        this.c = new a();
        this.f4531a = context;
        a();
    }
}
