package com.vungle.ads.internal.ui.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.platform.WebViewUtil;
import com.vungle.ads.internal.util.HandlerScheduler;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.ViewUtility;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MRAIDAdWidget.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 :2\u00020\u0001:\u0007789:;<=B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0003J\u0006\u0010#\u001a\u00020\"J\u000e\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&J\u0018\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+J\b\u0010,\u001a\u00020\"H\u0014J\u0006\u0010-\u001a\u00020\"J\b\u0010.\u001a\u00020\"H\u0002J\u0006\u0010/\u001a\u00020\"J\u000e\u00100\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u00101\u001a\u00020\"2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u00102\u001a\u00020\"2\u0006\u00103\u001a\u000204J\u0010\u00105\u001a\u00020\"2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u00106\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001cR&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "closeDelegate", "Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$CloseDelegate;", "getCloseDelegate$vungle_ads_release$annotations", "()V", "getCloseDelegate$vungle_ads_release", "()Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$CloseDelegate;", "setCloseDelegate$vungle_ads_release", "(Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$CloseDelegate;)V", "onViewTouchListener", "Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OnViewTouchListener;", "getOnViewTouchListener$vungle_ads_release$annotations", "getOnViewTouchListener$vungle_ads_release", "()Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OnViewTouchListener;", "setOnViewTouchListener$vungle_ads_release", "(Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OnViewTouchListener;)V", "orientationDelegate", "Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OrientationDelegate;", "getOrientationDelegate$vungle_ads_release$annotations", "getOrientationDelegate$vungle_ads_release", "()Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OrientationDelegate;", "setOrientationDelegate$vungle_ads_release", "(Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OrientationDelegate;)V", "url", "", "getUrl", "()Ljava/lang/String;", "webView", "Landroid/webkit/WebView;", "bindListeners", "", "close", "destroyWebView", "webViewDestroyDelay", "", "linkWebView", "vngWebViewClient", "Landroid/webkit/WebViewClient;", "webViewSettings", "Lcom/vungle/ads/internal/model/AdPayload$WebViewSettings;", "onAttachedToWindow", "pauseWeb", "prepare", "resumeWeb", "setCloseDelegate", "setOnViewTouchListener", "setOrientation", "requestedOrientation", "", "setOrientationDelegate", "showWebsite", "AdStopReason", "AudioContextWrapper", "CloseDelegate", "Companion", "DestroyRunnable", "OnViewTouchListener", "OrientationDelegate", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class MRAIDAdWidget extends RelativeLayout {
    private static final String TAG = "MRAIDAdWidget";
    private CloseDelegate closeDelegate;
    private OnViewTouchListener onViewTouchListener;
    private OrientationDelegate orientationDelegate;
    private WebView webView;

    /* compiled from: MRAIDAdWidget.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$CloseDelegate;", "", "close", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface CloseDelegate {
        void close();
    }

    /* compiled from: MRAIDAdWidget.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OnViewTouchListener;", "", "onTouch", "", "event", "Landroid/view/MotionEvent;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnViewTouchListener {
        boolean onTouch(MotionEvent event);
    }

    /* compiled from: MRAIDAdWidget.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OrientationDelegate;", "", "setOrientation", "", "orientation", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OrientationDelegate {
        void setOrientation(int orientation);
    }

    public static /* synthetic */ void getCloseDelegate$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getOnViewTouchListener$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getOrientationDelegate$vungle_ads_release$annotations() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MRAIDAdWidget(Context context) throws InstantiationException {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(layoutParams);
        WebView webView = ViewUtility.INSTANCE.getWebView(context);
        this.webView = webView;
        if (webView != null) {
            webView.setLayoutParams(layoutParams);
        }
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setTag("VungleWebView");
        }
        addView(this.webView, layoutParams);
        bindListeners();
        prepare();
    }

    /* renamed from: getOnViewTouchListener$vungle_ads_release, reason: from getter */
    public final OnViewTouchListener getOnViewTouchListener() {
        return this.onViewTouchListener;
    }

    public final void setOnViewTouchListener$vungle_ads_release(OnViewTouchListener onViewTouchListener) {
        this.onViewTouchListener = onViewTouchListener;
    }

    /* renamed from: getCloseDelegate$vungle_ads_release, reason: from getter */
    public final CloseDelegate getCloseDelegate() {
        return this.closeDelegate;
    }

    public final void setCloseDelegate$vungle_ads_release(CloseDelegate closeDelegate) {
        this.closeDelegate = closeDelegate;
    }

    /* renamed from: getOrientationDelegate$vungle_ads_release, reason: from getter */
    public final OrientationDelegate getOrientationDelegate() {
        return this.orientationDelegate;
    }

    public final void setOrientationDelegate$vungle_ads_release(OrientationDelegate orientationDelegate) {
        this.orientationDelegate = orientationDelegate;
    }

    private final void bindListeners() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.vungle.ads.internal.ui.view.MRAIDAdWidget$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean m9403bindListeners$lambda0;
                    m9403bindListeners$lambda0 = MRAIDAdWidget.m9403bindListeners$lambda0(MRAIDAdWidget.this, view, motionEvent);
                    return m9403bindListeners$lambda0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindListeners$lambda-0, reason: not valid java name */
    public static final boolean m9403bindListeners$lambda0(MRAIDAdWidget this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnViewTouchListener onViewTouchListener = this$0.onViewTouchListener;
        if (onViewTouchListener != null) {
            return onViewTouchListener.onTouch(motionEvent);
        }
        return false;
    }

    private final void prepare() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.setLayerType(2, null);
            webView.setBackgroundColor(0);
            webView.setVisibility(8);
        }
    }

    public final void setCloseDelegate(CloseDelegate closeDelegate) {
        Intrinsics.checkNotNullParameter(closeDelegate, "closeDelegate");
        this.closeDelegate = closeDelegate;
    }

    public final void setOnViewTouchListener(OnViewTouchListener onViewTouchListener) {
        this.onViewTouchListener = onViewTouchListener;
    }

    public final void setOrientationDelegate(OrientationDelegate orientationDelegate) {
        this.orientationDelegate = orientationDelegate;
    }

    public final void close() {
        CloseDelegate closeDelegate = this.closeDelegate;
        if (closeDelegate != null) {
            closeDelegate.close();
        }
    }

    public final void setOrientation(int requestedOrientation) {
        OrientationDelegate orientationDelegate = this.orientationDelegate;
        if (orientationDelegate != null) {
            orientationDelegate.setOrientation(requestedOrientation);
        }
    }

    public final void linkWebView(WebViewClient vngWebViewClient, AdPayload.WebViewSettings webViewSettings) {
        Intrinsics.checkNotNullParameter(vngWebViewClient, "vngWebViewClient");
        WebView webView = this.webView;
        if (webView != null) {
            WebViewUtil.INSTANCE.applyWebSettings(webView, webViewSettings);
            webView.setWebViewClient(vngWebViewClient);
        }
    }

    public final void showWebsite(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Logger.INSTANCE.d(TAG, "loadUrl: " + url);
        WebView webView = this.webView;
        if (webView != null) {
            webView.setVisibility(0);
            webView.loadUrl(url);
        }
    }

    public final void pauseWeb() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.onPause();
        }
    }

    public final void resumeWeb() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.onResume();
        }
    }

    public final String getUrl() {
        WebView webView = this.webView;
        if (webView != null) {
            return webView.getUrl();
        }
        return null;
    }

    public final void destroyWebView(long webViewDestroyDelay) {
        if (webViewDestroyDelay <= 0) {
            new DestroyRunnable(this).run();
        } else {
            new HandlerScheduler().schedule(new DestroyRunnable(this), webViewDestroyDelay);
        }
    }

    /* compiled from: MRAIDAdWidget.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$DestroyRunnable;", "Ljava/lang/Runnable;", "widget", "Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget;", "(Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget;)V", "run", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class DestroyRunnable implements Runnable {
        private final MRAIDAdWidget widget;

        public DestroyRunnable(MRAIDAdWidget widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            this.widget = widget;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.widget.removeAllViews();
                WebView webView = this.widget.webView;
                if (webView != null) {
                    webView.setWebChromeClient(null);
                    webView.stopLoading();
                    webView.clearHistory();
                    if (Build.VERSION.SDK_INT >= 29) {
                        webView.setWebViewRenderProcessClient(null);
                    }
                    webView.loadUrl(AndroidWebViewClient.BLANK_PAGE);
                    webView.removeAllViews();
                    ViewParent parent = webView.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        viewGroup.removeView(webView);
                    }
                    webView.destroy();
                }
                this.widget.webView = null;
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ViewGroup.LayoutParams layoutParams;
        super.onAttachedToWindow();
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = -1;
            layoutParams2.width = -1;
        }
        WebView webView = this.webView;
        if (webView == null || (layoutParams = webView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = -1;
        layoutParams.width = -1;
    }

    /* compiled from: MRAIDAdWidget.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$AudioContextWrapper;", "Landroid/content/ContextWrapper;", "base", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getSystemService", "", "name", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AudioContextWrapper extends ContextWrapper {
        public AudioContextWrapper(Context context) {
            super(context);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String name) {
            Object systemService;
            Intrinsics.checkNotNullParameter(name, "name");
            if (Intrinsics.areEqual("audio", name)) {
                systemService = getApplicationContext().getSystemService(name);
            } else {
                systemService = super.getSystemService(name);
            }
            Intrinsics.checkNotNullExpressionValue(systemService, "if (AUDIO_SERVICE == nam…rvice(name)\n            }");
            return systemService;
        }
    }

    /* compiled from: MRAIDAdWidget.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$AdStopReason;", "", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AdStopReason {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int IS_AD_FINISHED_BY_API = 4;
        public static final int IS_AD_FINISHING = 2;
        public static final int IS_CHANGING_CONFIGURATION = 1;

        /* compiled from: MRAIDAdWidget.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$AdStopReason$Companion;", "", "()V", "IS_AD_FINISHED_BY_API", "", "IS_AD_FINISHING", "IS_CHANGING_CONFIGURATION", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int IS_AD_FINISHED_BY_API = 4;
            public static final int IS_AD_FINISHING = 2;
            public static final int IS_CHANGING_CONFIGURATION = 1;

            private Companion() {
            }
        }
    }
}
