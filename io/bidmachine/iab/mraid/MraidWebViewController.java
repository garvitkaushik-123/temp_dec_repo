package io.bidmachine.iab.mraid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ironsource.sdk.controller.f;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.bridge.JsBridgeHandler;
import io.bidmachine.iab.mraid.MraidWebView;
import io.bidmachine.iab.utils.Logger;
import io.bidmachine.iab.utils.Utils;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes7.dex */
public class MraidWebViewController {
    public static final String TAG = "MraidWebViewController";

    /* renamed from: a, reason: collision with root package name */
    private final Callback f6829a;
    final MraidWebView b;
    private boolean c;
    private boolean d;
    private boolean e;
    private MraidOrientationProperties f;

    public interface Callback {
        void onCalendarEvent(String eventJson);

        void onClose();

        void onError(IabError iabError);

        void onExpand(String url);

        void onLoaded();

        void onOpen(String url);

        void onOpenPrivacySheet(String json);

        void onOrientation(MraidOrientationProperties orientationProperties);

        void onPageFinished(String url);

        void onPlayVideo(String url);

        void onResize(MraidResizeProperties resizeProperties);

        void onStorePicture(String url);

        void onUseCustomClose(boolean use);

        void onViewableChanged(boolean viewable);
    }

    class a implements MraidWebView.MraidWebViewListener {
        a() {
        }

        @Override // io.bidmachine.iab.mraid.MraidWebView.MraidWebViewListener
        public void onViewableChanged(boolean viewable) {
            if (MraidWebViewController.this.c) {
                MraidWebViewController.this.applyViewable(viewable);
            }
            MraidWebViewController.this.f6829a.onViewableChanged(viewable);
        }
    }

    private class b extends WebViewClient {
        private b() {
        }

        private void a(String url, String message, int errorCode) {
            MraidLog.d(MraidWebViewController.TAG, "onError: %s / %s / %d", url, message, Integer.valueOf(errorCode));
            if (message == null || !message.contains("ERR_INTERNET_DISCONNECTED")) {
                return;
            }
            MraidWebViewController.this.e = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            MraidLog.d(MraidWebViewController.TAG, "onPageFinished", new Object[0]);
            if (MraidWebViewController.this.c) {
                return;
            }
            MraidWebViewController.this.c = true;
            MraidWebViewController.this.f6829a.onPageFinished(url);
            MraidWebViewController.this.getWebView().onPageFinished();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            MraidLog.d(MraidWebViewController.TAG, "onPageStarted", new Object[0]);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Uri url = request.getUrl();
            a(url != null ? url.toString() : null, error.getDescription().toString(), error.getErrorCode());
            super.onReceivedError(view, request, error);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
            MraidLog.d(MraidWebViewController.TAG, "onRenderProcessGone", new Object[0]);
            MraidWebViewController.this.destroy();
            MraidWebViewController.this.f6829a.onError(IabError.internal("WebViewClient - onRenderProcessGone"));
            return true;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView view, final WebResourceRequest request) {
            return a(request.getUrl()) ? a() : super.shouldInterceptRequest(view, request);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith(MraidUtils.COMMAND_URL_PREFIX)) {
                MraidWebViewController.this.a(url);
                return true;
            }
            if (JsBridgeHandler.isHandled(url)) {
                JsBridgeHandler.handleJsCommand(MraidWebViewController.this.b, url);
                return true;
            }
            MraidWebViewController.this.c(url);
            return true;
        }

        /* synthetic */ b(MraidWebViewController mraidWebViewController, a aVar) {
            this();
        }

        boolean a(final String url) {
            return a(Uri.parse(url.toLowerCase(Locale.US)));
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView view, final String url) {
            if (a(url)) {
                return a();
            }
            return super.shouldInterceptRequest(view, url);
        }

        boolean a(final Uri uri) {
            return "mraid.js".equals(uri.getLastPathSegment());
        }

        private WebResourceResponse a() {
            String b = MraidUtils.b();
            Charset charset = StandardCharsets.UTF_8;
            return new WebResourceResponse("text/javascript", charset.name(), new ByteArrayInputStream(b.getBytes(charset)));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            a(failingUrl, description, errorCode);
            super.onReceivedError(view, errorCode, description, failingUrl);
        }
    }

    public MraidWebViewController(Context context, Callback callback) {
        this.f6829a = callback;
        MraidWebView mraidWebView = new MraidWebView(context);
        this.b = mraidWebView;
        mraidWebView.setWebViewClient(new b(this, null));
        mraidWebView.setListener(new a());
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String url) {
        if (!this.b.wasClicked()) {
            MraidLog.d(TAG, "Can't open url because webView wasn't clicked", new Object[0]);
        } else {
            this.f6829a.onOpen(url);
            this.b.resetClicked();
        }
    }

    public void applyClick(int x, int y) {
        b(String.format("(function click(x, y) {var ev = new MouseEvent('click', {    'view': window,    'bubbles': true,    'cancelable': true,    'screenX': x,    'screenY': y});var el = document.elementFromPoint(x, y);if (el !== null) {      el.dispatchEvent(ev); }})(%s, %s)", Integer.valueOf(x), Integer.valueOf(y)));
    }

    public void applyLogLevel(Logger.LogLevel level) {
        if (level == Logger.LogLevel.debug) {
            b("mraid.logLevel = mraid.LogLevelEnum.DEBUG;");
            return;
        }
        if (level == Logger.LogLevel.info) {
            b("mraid.logLevel = mraid.LogLevelEnum.INFO;");
            return;
        }
        if (level == Logger.LogLevel.warning) {
            b("mraid.logLevel = mraid.LogLevelEnum.WARNING;");
        } else if (level == Logger.LogLevel.error) {
            b("mraid.logLevel = mraid.LogLevelEnum.ERROR;");
        } else if (level == Logger.LogLevel.none) {
            b("mraid.logLevel = mraid.LogLevelEnum.NONE;");
        }
    }

    public void applyPlacement(MraidPlacementType placement) {
        b("mraid.setPlacementType('" + placement.b() + "');");
    }

    public void applyScreenMetrics(MraidScreenMetrics screenMetrics) {
        Rect e = screenMetrics.e();
        Rect d = screenMetrics.d();
        b("mraid.setScreenSize(" + e.width() + "," + e.height() + ");mraid.setMaxSize(" + d.width() + "," + d.height() + ");mraid.setCurrentPosition(" + Utils.stringifyRect(screenMetrics.a()) + ");mraid.setDefaultPosition(" + Utils.stringifyRect(screenMetrics.c()) + ");mraid.fireSizeChangeEvent(" + Utils.stringifySize(screenMetrics.a()) + ");");
    }

    public void applyState(MraidViewState state) {
        b("mraid.fireStateChangeEvent('" + state.toJsString() + "');");
    }

    public void applySupportedServices(MraidNativeFeatureManager nativeFeatureManager) {
        b("mraid.setSupports(mraid.SUPPORTED_FEATURES.CALENDAR, " + nativeFeatureManager.isCalendarFeatureAvailable() + ");mraid.setSupports(mraid.SUPPORTED_FEATURES.INLINEVIDEO, " + nativeFeatureManager.isInlineVideoFeatureAvailable() + ");mraid.setSupports(mraid.SUPPORTED_FEATURES.SMS, " + nativeFeatureManager.isSmsFeatureAvailable() + ");mraid.setSupports(mraid.SUPPORTED_FEATURES.STOREPICTURE, " + nativeFeatureManager.isStorePictureFeatureAvailable() + ");mraid.setSupports(mraid.SUPPORTED_FEATURES.TEL, " + nativeFeatureManager.isTelFeatureAvailable() + ");");
    }

    public void applyViewable(boolean viewable) {
        b("mraid.fireViewableChangeEvent(" + viewable + ");");
    }

    public void destroy() {
        MraidWebView webView = getWebView();
        Utils.removeFromParent(webView);
        webView.destroy();
    }

    public MraidOrientationProperties getLastOrientationProperties() {
        return this.f;
    }

    public MraidWebView getWebView() {
        return this.b;
    }

    public boolean isReceivedJsError() {
        return this.e;
    }

    public boolean isUseCustomClose() {
        return this.d;
    }

    public boolean isViewable() {
        return this.b.isViewable();
    }

    public void load(String url) {
        this.c = false;
        getWebView().loadUrl(url);
    }

    public void notifyReady() {
        b("mraid.fireReadyEvent();");
    }

    public void reset() {
        getWebView().reset();
    }

    public void load(String baseUrl, String data, String mimeType, String encoding) {
        this.c = false;
        getWebView().loadDataWithBaseURL(baseUrl, data, mimeType, encoding, null);
    }

    private void a() {
        b("mraid.nativeCallComplete();");
    }

    void b(String js) {
        this.b.injectJs(js);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String commandUrl) {
        Map<String, String> parseCommandUrl;
        MraidLog.d(TAG, "handleJsCommand - %s", commandUrl);
        try {
            parseCommandUrl = MraidUtils.parseCommandUrl(commandUrl);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (parseCommandUrl == null) {
            return;
        }
        String str = parseCommandUrl.get(f.b.g);
        if (str == null) {
            MraidLog.w(TAG, "handleJsCommand not found", new Object[0]);
        } else {
            a(str, parseCommandUrl);
            a();
        }
    }

    private void a(String command, Map<String, String> params) {
        command.hashCode();
        command.hashCode();
        switch (command) {
            case "playVideo":
                this.f6829a.onPlayVideo(params.get("url"));
                break;
            case "openPrivacySheet":
                String str = params.get("data");
                if (TextUtils.isEmpty(str)) {
                    MraidLog.e(TAG, "data is null or empty", new Object[0]);
                    break;
                } else {
                    try {
                        this.f6829a.onOpenPrivacySheet(new String(Base64.decode(str, 2)));
                        break;
                    } catch (Throwable unused) {
                        MraidLog.e(TAG, "data must be base64 encoded json", new Object[0]);
                        return;
                    }
                }
            case "expand":
                MraidLog.d(TAG, "mraid.expand is not supported", new Object[0]);
                break;
            case "loaded":
                this.f6829a.onLoaded();
                break;
            case "noFill":
                this.f6829a.onError(IabError.noFIll("Fired noFill event from mraid.js"));
                break;
            case "resize":
                MraidLog.d(TAG, "mraid.resize is not supported", new Object[0]);
                break;
            case "createCalendarEvent":
                this.f6829a.onCalendarEvent(params.get("eventJSON"));
                break;
            case "open":
                String str2 = params.get("url");
                if (TextUtils.isEmpty(str2)) {
                    MraidLog.e(TAG, "url is null or empty", new Object[0]);
                    break;
                } else {
                    c(str2);
                    break;
                }
            case "close":
                this.f6829a.onClose();
                break;
            case "setOrientationProperties":
                MraidOrientationProperties mraidOrientationProperties = new MraidOrientationProperties(Boolean.parseBoolean(params.get("allowOrientationChange")), MraidOrientationProperties.forceOrientationFromString(params.get("forceOrientation")));
                this.f = mraidOrientationProperties;
                this.f6829a.onOrientation(mraidOrientationProperties);
                break;
            case "storePicture":
                this.f6829a.onStorePicture(params.get("url"));
                break;
            case "useCustomClose":
                boolean parseBoolean = Boolean.parseBoolean(params.get("useCustomClose"));
                if (this.d != parseBoolean) {
                    this.d = parseBoolean;
                    this.f6829a.onUseCustomClose(parseBoolean);
                    break;
                }
                break;
        }
    }
}
