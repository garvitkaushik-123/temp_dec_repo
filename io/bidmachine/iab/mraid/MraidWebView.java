package io.bidmachine.iab.mraid;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ironsource.C3040d4;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.v;
import io.bidmachine.iab.utils.VisibilityTracker;

/* loaded from: classes7.dex */
public class MraidWebView extends WebView {
    private static final b g = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final WebViewGestureDetector f6827a;
    private final VisibilityTracker b;
    private MraidWebViewListener c;
    private boolean d;
    private boolean e;
    private boolean f;

    public interface MraidWebViewListener {
        void onViewableChanged(boolean viewable);
    }

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            MraidWebView.this.f6827a.onTouchEvent(event);
            int action = event.getAction();
            if ((action != 0 && action != 1) || v.hasFocus()) {
                return false;
            }
            v.requestFocus();
            return false;
        }
    }

    private static final class b extends WebChromeClient {
        private b() {
        }

        private boolean a(JsResult result) {
            result.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage cm) {
            if (cm == null || cm.message() == null) {
                return false;
            }
            if (MraidLog.canSendDLog() && !cm.message().contains("Uncaught ReferenceError")) {
                MraidLog.d("JS console", String.format("%s%s:%d", cm.message(), cm.sourceId() == null ? "" : " at " + cm.sourceId(), Integer.valueOf(cm.lineNumber())), new Object[0]);
            }
            if (!MraidLog.canSendELog() || !cm.message().contains("AppodealAlert")) {
                return true;
            }
            MraidLog.e("Appodeal", cm.message().replace("AppodealAlert:", ""), new Object[0]);
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            MraidLog.d("JS alert", message, new Object[0]);
            return a(result);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            MraidLog.d("JS confirm", message, new Object[0]);
            return a(result);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            MraidLog.d("JS prompt", message, new Object[0]);
            return a(result);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public MraidWebView(Context context) {
        super(context);
        this.d = false;
        this.e = false;
        this.f = false;
        setScrollContainer(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setScrollBarStyle(33554432);
        setFocusableInTouchMode(false);
        this.f6827a = new WebViewGestureDetector(context);
        setOnTouchListener(new a());
        setWebChromeClient(g);
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        setBackgroundColor(0);
        this.b = new VisibilityTracker(context, this, new VisibilityTracker.Callback() { // from class: io.bidmachine.iab.mraid.MraidWebView$$ExternalSyntheticLambda0
            @Override // io.bidmachine.iab.utils.VisibilityTracker.Callback
            public final void onVisibilityChanged(boolean z) {
                MraidWebView.this.a(z);
            }
        });
    }

    private void b() {
        MraidLog.d(v.h, C3040d4.h.u0, new Object[0]);
        try {
            onResume();
        } catch (Throwable th) {
            MraidLog.e(v.h, th);
        }
        this.e = false;
        c();
    }

    private void c() {
        boolean z = !this.e && this.b.isVisible();
        if (z != this.d) {
            this.d = z;
            MraidWebViewListener mraidWebViewListener = this.c;
            if (mraidWebViewListener != null) {
                mraidWebViewListener.onViewableChanged(z);
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.f = true;
        try {
            reset();
            removeAllViews();
            this.b.release();
            super.destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void injectJs(String js) {
        if (isDestroyed()) {
            MraidLog.d(v.h, "can't evaluating js: WebView is destroyed", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(js)) {
            MraidLog.d(v.h, "can't evaluating js: js is empty", new Object[0]);
            return;
        }
        try {
            MraidLog.d(v.h, "evaluating js: %s", js);
            evaluateJavascript(js, new ValueCallback() { // from class: io.bidmachine.iab.mraid.MraidWebView$$ExternalSyntheticLambda1
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    MraidWebView.a((String) obj);
                }
            });
        } catch (Throwable th) {
            MraidLog.e(v.h, th.getMessage(), new Object[0]);
            MraidLog.d(v.h, "loading url: %s", js);
            loadUrl("javascript:" + js);
        }
    }

    public boolean isDestroyed() {
        return this.f;
    }

    public boolean isViewable() {
        return this.d;
    }

    public void onPageFinished() {
        this.b.start();
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == 0) {
            b();
        } else {
            a();
        }
    }

    @Override // android.view.View
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return false;
    }

    public void reset() {
        stopLoading();
        loadUrl("");
        a();
    }

    public void resetClicked() {
        this.f6827a.resetClick();
    }

    public void setListener(MraidWebViewListener listener) {
        this.c = listener;
    }

    public boolean wasClicked() {
        return this.f6827a.isClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z) {
        c();
    }

    private void a() {
        MraidLog.d(v.h, C3040d4.h.t0, new Object[0]);
        try {
            onPause();
        } catch (Throwable th) {
            MraidLog.e(v.h, th);
        }
        this.e = true;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str) {
        MraidLog.d(v.h, "evaluate js complete: %s", str);
    }
}
