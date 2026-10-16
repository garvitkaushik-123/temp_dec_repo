package com.bytedance.sdk.component.FC;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.FC.MGA;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class ui extends WebView {
    private final HashSet<String> DbA;
    private Os MGA;
    private boolean Os;
    private boolean aGH;
    public long eli;
    private boolean ui;

    public ui(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DbA = new HashSet<>();
        this.eli = System.currentTimeMillis();
        eli();
    }

    public ui(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DbA = new HashSet<>();
        this.eli = System.currentTimeMillis();
        eli();
    }

    public void setTouchListenerProxy(Os os) {
        this.MGA = os;
    }

    private void eli() {
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        settings.setBuiltInZoomControls(false);
        settings.setSupportMultipleWindows(false);
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        setWebViewClient(new MGA.eli());
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        new StringBuilder("addJavascriptInterface: ").append(str).append(", ").append(this);
        if (this.Os || this.ui) {
            return;
        }
        super.addJavascriptInterface(obj, str);
        this.DbA.add(str);
    }

    @Override // android.webkit.WebView
    public void removeJavascriptInterface(String str) {
        if (this.Os || this.ui) {
            return;
        }
        super.removeJavascriptInterface(str);
        this.DbA.remove(str);
    }

    @Override // android.webkit.WebView
    public void onPause() {
        if (this.Os || this.ui) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void onResume() {
        if (this.Os || this.ui) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        if (this.Os || this.ui) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void reload() {
        if (this.Os || this.ui) {
            return;
        }
        super.reload();
    }

    @Override // android.webkit.WebView
    public void goBack() {
        if (this.Os || this.ui) {
            return;
        }
        super.goBack();
    }

    @Override // android.webkit.WebView
    public void goForward() {
        if (this.Os || this.ui) {
            return;
        }
        super.goForward();
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(int i) {
        if (this.Os || this.ui) {
            return;
        }
        super.goBackOrForward(i);
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z) {
        if (this.Os || this.ui) {
            return;
        }
        super.clearCache(z);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (this.Os || this.ui) {
            return;
        }
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError unused) {
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        if (this.Os || this.ui) {
            return;
        }
        try {
            super.loadUrl(str, map);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError unused) {
        }
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.Os || this.ui) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.Os || this.ui) {
            return;
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.Os && !this.ui) {
            super.evaluateJavascript(str, valueCallback);
        } else if (valueCallback != null) {
            valueCallback.onReceiveValue("");
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        new StringBuilder("onAttachedToWindow: ").append(this);
    }

    public void setDestroyOnDetached(boolean z) {
        this.aGH = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        new StringBuilder("onDetachedFromWindow: ").append(this);
        if (this.aGH) {
            destroy();
        }
    }

    @Override // android.webkit.WebView
    public void resumeTimers() {
        if (this.Os || this.ui) {
            return;
        }
        super.resumeTimers();
    }

    @Override // android.webkit.WebView
    public void pauseTimers() {
        if (this.Os || this.ui) {
            return;
        }
        super.pauseTimers();
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.Os || this.ui) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        new StringBuilder("destroy() called, ").append(this);
        if (this.Os) {
            return;
        }
        this.Os = true;
        DbA();
        super.destroy();
    }

    private void DbA() {
        if (this.Os) {
            return;
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
        setOnClickListener(null);
        setOnTouchListener(null);
        Iterator<String> it = this.DbA.iterator();
        while (it.hasNext()) {
            super.removeJavascriptInterface(it.next());
        }
    }

    public void setRecycler(boolean z) {
        this.ui = z;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        Os os = this.MGA;
        if (os == null) {
            super.setOnTouchListener(onTouchListener);
        } else {
            os.eli(onTouchListener);
            super.setOnTouchListener(this.MGA);
        }
    }
}
