package io.bidmachine.iab.mraid;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.IabSettings;
import io.bidmachine.iab.bridge.JsBridgeHandler;
import io.bidmachine.iab.mraid.MraidAdView;
import io.bidmachine.iab.mraid.MraidWebViewController;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.utils.PrivacySheetParamsParser;
import io.bidmachine.util.Executable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public class MraidAdView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final MraidPlacementType f6800a;
    private final String b;
    private final String c;
    private final String d;
    private final AtomicBoolean e;
    private final AtomicBoolean f;
    private final AtomicBoolean g;
    private final AtomicBoolean h;
    private final AtomicBoolean i;
    private final AtomicBoolean j;
    private final AtomicBoolean k;
    private final GestureDetector l;
    private final MraidScreenMetrics m;
    private final ViewOnScreenObserver n;
    private final MraidNativeFeatureManager o;
    private final MraidNativeFeatureSchemeValidator p;
    private final b q;
    private final MraidWebViewController r;
    private final Listener s;
    private MraidWebViewController t;
    private MraidViewState u;
    private Runnable v;

    /* renamed from: io.bidmachine.iab.mraid.MraidAdView$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6801a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ MraidWebViewController e;

        AnonymousClass1(final int val$width, final int val$height, final int val$horizontalGravity, final int val$verticalGravity, final MraidWebViewController val$currentController) {
            this.f6801a = val$width;
            this.b = val$height;
            this.c = val$horizontalGravity;
            this.d = val$verticalGravity;
            this.e = val$currentController;
        }

        @Override // java.lang.Runnable
        public void run() {
            final Point clickPoint = Utils.getClickPoint(this.f6801a, this.b, this.c, this.d);
            MraidAdView.this.a(clickPoint.x, clickPoint.y, this.e, new Runnable() { // from class: io.bidmachine.iab.mraid.MraidAdView.1.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable = new Runnable() { // from class: io.bidmachine.iab.mraid.MraidAdView.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MraidAdView.this.c();
                        }
                    };
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    MraidAdView mraidAdView = MraidAdView.this;
                    Point point = clickPoint;
                    mraidAdView.b(point.x, point.y, anonymousClass1.e, runnable);
                }
            });
        }
    }

    private static class GestureDetectorListener extends GestureDetector.SimpleOnGestureListener {
        private GestureDetectorListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float dx, float dy) {
            return true;
        }

        /* synthetic */ GestureDetectorListener(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public interface Listener {
        void onCalendarEventIntention(MraidAdView mraidAdView, String url);

        void onChangeOrientationIntention(MraidAdView mraidAdView, MraidOrientationProperties mraidOrientationProperties);

        void onCloseIntention(MraidAdView mraidAdView);

        boolean onExpandIntention(MraidAdView mraidAdView, WebView webView, MraidOrientationProperties mraidOrientationProperties, boolean isUseCustomClose);

        void onExpanded(MraidAdView mraidAdView);

        void onMraidAdViewExpired(MraidAdView mraidAdView, IabError iabError);

        void onMraidAdViewLoadFailed(MraidAdView mraidAdView, IabError iabError);

        void onMraidAdViewPageLoaded(MraidAdView mraidAdView, String url, WebView webView, boolean isUseCustomClose);

        void onMraidAdViewShowFailed(MraidAdView mraidAdView, IabError iabError);

        void onMraidAdViewShown(MraidAdView mraidAdView);

        void onMraidLoadedIntention(MraidAdView mraidAdView);

        void onOpenPrivacySheet(MraidAdView mraidAdView, PrivacySheetParams privacySheetParams);

        void onOpenUrlIntention(MraidAdView mraidAdView, String url);

        void onPlayVideoIntention(MraidAdView mraidAdView, String url);

        boolean onResizeIntention(MraidAdView mraidAdView, WebView webView, MraidResizeProperties mraidResizeProperties, MraidScreenMetrics mraidScreenMetrics);

        void onStorePictureIntention(MraidAdView mraidAdView, String url);

        void onSyncCustomCloseIntention(MraidAdView mraidAdView, boolean isUseCustomClose);
    }

    /* JADX INFO: Access modifiers changed from: private */
    abstract class MraidWebViewControllerCallback implements MraidWebViewController.Callback {
        private MraidWebViewControllerCallback() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str) {
            MraidAdView.this.s.onCalendarEventIntention(MraidAdView.this, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            MraidAdView.this.s.onStorePictureIntention(MraidAdView.this, str);
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onCalendarEvent(String eventJson) {
            MraidLog.d("MraidAdView", "Callback - onCalendarEvent: %s", eventJson);
            String a2 = MraidAdView.this.q.a(eventJson);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            MraidAdView.this.a(a2, (Executable<String>) new Executable() { // from class: io.bidmachine.iab.mraid.MraidAdView$MraidWebViewControllerCallback$$ExternalSyntheticLambda1
                @Override // io.bidmachine.util.Executable
                public final void execute(Object obj) {
                    MraidAdView.MraidWebViewControllerCallback.this.a((String) obj);
                }
            });
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onClose() {
            MraidLog.d("MraidAdView", "Callback - onClose", new Object[0]);
            MraidAdView.this.a();
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onError(IabError iabError) {
            MraidLog.d("MraidAdView", "Callback - onError: %s", iabError);
            MraidAdView.this.a(iabError);
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onExpand(String url) {
            MraidLog.d("MraidAdView", "Callback - onExpand: %s", url);
            if (MraidAdView.this.isInterstitial()) {
                return;
            }
            MraidAdView.this.a(url);
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onLoaded() {
            MraidLog.d("MraidAdView", "Callback - onLoaded", new Object[0]);
            MraidAdView.this.b();
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onOpen(String url) {
            MraidLog.d("MraidAdView", "Callback - onOpen: %s", url);
            MraidAdView.this.c(url);
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onOpenPrivacySheet(String json) {
            MraidLog.d("MraidAdView", "Callback - onOpenPrivacySheet: %s", json);
            MraidAdView.this.b(json);
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onOrientation(MraidOrientationProperties mraidOrientationProperties) {
            MraidLog.d("MraidAdView", "Callback - onOrientation: %s", mraidOrientationProperties);
            if (MraidAdView.this.isInterstitial() || MraidAdView.this.u == MraidViewState.EXPANDED) {
                MraidAdView.this.s.onChangeOrientationIntention(MraidAdView.this, mraidOrientationProperties);
            }
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onPlayVideo(String url) {
            MraidLog.d("MraidAdView", "Callback - onPlayVideo: %s", url);
            if (TextUtils.isEmpty(url)) {
                return;
            }
            try {
                MraidAdView.this.s.onPlayVideoIntention(MraidAdView.this, URLDecoder.decode(url, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                MraidLog.e("MraidAdView", e);
            }
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onResize(MraidResizeProperties resizeProperties) {
            MraidLog.d("MraidAdView", "Callback - onResize: %s", resizeProperties);
            MraidAdView.this.a(resizeProperties);
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onStorePicture(String url) {
            MraidLog.d("MraidAdView", "Callback - onStorePicture: %s", url);
            String b = MraidAdView.this.q.b(url);
            if (TextUtils.isEmpty(b)) {
                return;
            }
            MraidAdView.this.a(b, (Executable<String>) new Executable() { // from class: io.bidmachine.iab.mraid.MraidAdView$MraidWebViewControllerCallback$$ExternalSyntheticLambda0
                @Override // io.bidmachine.util.Executable
                public final void execute(Object obj) {
                    MraidAdView.MraidWebViewControllerCallback.this.b((String) obj);
                }
            });
        }

        /* synthetic */ MraidWebViewControllerCallback(MraidAdView mraidAdView, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private class PrimaryControllerCallback extends MraidWebViewControllerCallback {
        private PrimaryControllerCallback() {
            super(MraidAdView.this, null);
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onPageFinished(String url) {
            MraidAdView.this.d(url);
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onUseCustomClose(boolean use) {
            Listener listener = MraidAdView.this.s;
            MraidAdView mraidAdView = MraidAdView.this;
            listener.onSyncCustomCloseIntention(mraidAdView, mraidAdView.r.isUseCustomClose());
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onViewableChanged(boolean viewable) {
            if (viewable) {
                MraidAdView.this.f();
                MraidAdView.this.g();
            }
        }

        /* synthetic */ PrimaryControllerCallback(MraidAdView mraidAdView, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private class SecondaryControllerCallback extends MraidWebViewControllerCallback {
        private SecondaryControllerCallback() {
            super(MraidAdView.this, null);
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onPageFinished(String url) {
            MraidAdView.this.d();
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onUseCustomClose(boolean use) {
            if (MraidAdView.this.t != null) {
                Listener listener = MraidAdView.this.s;
                MraidAdView mraidAdView = MraidAdView.this;
                listener.onSyncCustomCloseIntention(mraidAdView, mraidAdView.t.isUseCustomClose());
            }
        }

        @Override // io.bidmachine.iab.mraid.MraidWebViewController.Callback
        public void onViewableChanged(boolean viewable) {
        }

        /* synthetic */ SecondaryControllerCallback(MraidAdView mraidAdView, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public MraidAdView(Context context, MraidPlacementType mraidPlacementType, String baseUrl, String productLink, List<String> nativeFeatures, String pageFinishedScript, Listener listener) {
        super(context);
        this.q = new b();
        this.f6800a = mraidPlacementType;
        this.b = baseUrl;
        this.d = productLink;
        this.c = pageFinishedScript;
        this.s = listener;
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.i = new AtomicBoolean(false);
        this.j = new AtomicBoolean(false);
        this.k = new AtomicBoolean(false);
        AnonymousClass1 anonymousClass1 = null;
        this.l = new GestureDetector(context, new GestureDetectorListener(anonymousClass1));
        this.m = new MraidScreenMetrics(context);
        this.n = new ViewOnScreenObserver();
        MraidNativeFeatureManager mraidNativeFeatureManager = new MraidNativeFeatureManager(context, nativeFeatures);
        this.o = mraidNativeFeatureManager;
        this.p = new MraidNativeFeatureSchemeValidator(mraidNativeFeatureManager);
        MraidWebViewController mraidWebViewController = new MraidWebViewController(context, new PrimaryControllerCallback(this, anonymousClass1));
        this.r = mraidWebViewController;
        addView(mraidWebViewController.getWebView(), new FrameLayout.LayoutParams(-1, -1, 17));
        this.u = MraidViewState.LOADING;
    }

    private MraidWebViewController getCurrentMraidWebViewController() {
        MraidWebViewController mraidWebViewController = this.t;
        return mraidWebViewController != null ? mraidWebViewController : this.r;
    }

    public void close() {
        setViewState(MraidViewState.HIDDEN);
    }

    public void closeExpanded() {
        MraidWebViewController mraidWebViewController = this.t;
        if (mraidWebViewController != null) {
            mraidWebViewController.destroy();
            this.t = null;
        } else {
            addView(this.r.getWebView());
        }
        setViewState(MraidViewState.DEFAULT);
    }

    public void closeResized() {
        addView(this.r.getWebView());
        setViewState(MraidViewState.DEFAULT);
    }

    public void destroy() {
        this.n.cancelLastRequest();
        this.r.destroy();
        MraidWebViewController mraidWebViewController = this.t;
        if (mraidWebViewController != null) {
            mraidWebViewController.destroy();
        }
    }

    public String getBaseUrl() {
        return this.b;
    }

    public MraidOrientationProperties getLastOrientationProperties() {
        return this.r.getLastOrientationProperties();
    }

    public MraidViewState getMraidViewState() {
        return this.u;
    }

    public WebView getWebView() {
        return this.r.getWebView();
    }

    public void handleRedirect(int width, int height, int horizontalGravity, int verticalGravity) {
        a(getCurrentMraidWebViewController(), width, height, horizontalGravity, verticalGravity);
    }

    public void handleRedirectScreen(int horizontalGravity, int verticalGravity) {
        Rect e = this.m.e();
        handleRedirect(e.width(), e.height(), horizontalGravity, verticalGravity);
    }

    public void handleRedirectView() {
        MraidWebView webView = getCurrentMraidWebViewController().getWebView();
        handleRedirect(webView.getMeasuredWidth(), webView.getMeasuredHeight(), 17, 17);
    }

    public boolean isInterstitial() {
        return this.f6800a == MraidPlacementType.INTERSTITIAL;
    }

    public boolean isLoaded() {
        return this.e.get();
    }

    public boolean isOpenNotified() {
        return this.i.get();
    }

    public boolean isReceivedJsError() {
        return this.r.isReceivedJsError();
    }

    public boolean isRedirectProcessed() {
        return this.k.get();
    }

    public boolean isUseCustomClose() {
        return this.r.isUseCustomClose();
    }

    public void load(String htmlData) {
        if (htmlData == null) {
            a(IabError.noRequiredArguments("Html data are null"));
        } else {
            this.r.load(this.b, String.format("<script type='application/javascript'>%s</script>%s%s", MraidUtils.b(), JsBridgeHandler.obtainJs(), MraidUtils.processRawHtml(htmlData)), "text/html", "UTF-8");
            this.r.applyLogLevel(MraidLog.getLoggingLevel());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.l.onTouchEvent(event)) {
            event.setAction(3);
        }
        return super.onTouchEvent(event);
    }

    void setViewState(MraidViewState state) {
        this.u = state;
        this.r.applyState(state);
        MraidWebViewController mraidWebViewController = this.t;
        if (mraidWebViewController != null) {
            mraidWebViewController.applyState(state);
        }
        if (state != MraidViewState.HIDDEN) {
            updateMetrics(null);
        }
    }

    public void show() {
        if (this.g.compareAndSet(false, true) && isLoaded()) {
            f();
        }
    }

    public void updateMetrics(final Runnable successRunnable) {
        MraidWebViewController mraidWebViewController = this.t;
        final MraidWebView webView = mraidWebViewController != null ? mraidWebViewController.getWebView() : this.r.getWebView();
        this.n.wait(this, webView).start(new Runnable() { // from class: io.bidmachine.iab.mraid.MraidAdView.2
            @Override // java.lang.Runnable
            public void run() {
                MraidAdView.this.a(webView);
                Runnable runnable = successRunnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final Context f6806a;
        private final MraidPlacementType b;
        private final Listener c;
        private String d = IabSettings.DEF_BASE_URL;
        private List<String> e;
        private String f;
        private String g;

        public Builder(Context context, MraidPlacementType mraidPlacementType, Listener listener) {
            this.f6806a = context;
            this.b = mraidPlacementType;
            this.c = listener;
        }

        public MraidAdView build() {
            return new MraidAdView(this.f6806a, this.b, this.d, this.g, this.e, this.f, this.c);
        }

        public Builder setAllowedNativeFeatures(String[] allowedNativeFeatures) {
            this.e = allowedNativeFeatures != null ? Arrays.asList(allowedNativeFeatures) : null;
            return this;
        }

        public Builder setBaseUrl(String baseUrl) {
            this.d = baseUrl;
            return this;
        }

        public Builder setPageFinishedScript(String pageFinishedScript) {
            this.f = pageFinishedScript;
            return this;
        }

        public Builder setProductLink(String productLink) {
            this.g = productLink;
            return this;
        }

        public Builder setAllowedNativeFeatures(List<String> allowedNativeFeatures) {
            this.e = allowedNativeFeatures;
            return this;
        }
    }

    private boolean e() {
        return this.g.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f.compareAndSet(false, true)) {
            this.r.notifyReady();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.h.compareAndSet(false, true)) {
            this.s.onMraidAdViewShown(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String url) {
        a(url, new Executable() { // from class: io.bidmachine.iab.mraid.MraidAdView$$ExternalSyntheticLambda0
            @Override // io.bidmachine.util.Executable
            public final void execute(Object obj) {
                MraidAdView.this.e((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String url) {
        if (this.u == MraidViewState.LOADING && this.e.compareAndSet(false, true)) {
            this.r.applySupportedServices(this.o);
            MraidPlacementType mraidPlacementType = this.f6800a;
            if (mraidPlacementType != null) {
                this.r.applyPlacement(mraidPlacementType);
            }
            MraidWebViewController mraidWebViewController = this.r;
            mraidWebViewController.applyViewable(mraidWebViewController.isViewable());
            this.r.b(this.c);
            a(this.r.getWebView());
            setViewState(MraidViewState.DEFAULT);
            f();
            this.s.onMraidAdViewPageLoaded(this, url, this.r.getWebView(), this.r.isUseCustomClose());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String str) {
        this.s.onOpenUrlIntention(this, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.s.onMraidLoadedIntention(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (isRedirectProcessed() || TextUtils.isEmpty(this.d)) {
            return;
        }
        c(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String json) {
        PrivacySheetParams parseJson = PrivacySheetParamsParser.parseJson(json);
        if (parseJson == null) {
            MraidLog.e("MraidAdView", "Callback - can't parse privacy sheet", new Object[0]);
        } else {
            this.s.onOpenPrivacySheet(this, parseJson);
        }
    }

    private void a(MraidWebViewController currentController, int width, int height, int horizontalGravity, int verticalGravity) {
        if (this.j.compareAndSet(false, true)) {
            this.k.set(false);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(width, height, horizontalGravity, verticalGravity, currentController);
            Point defaultClickPoint = Utils.getDefaultClickPoint(width, height);
            a(defaultClickPoint.x, defaultClickPoint.y, currentController, anonymousClass1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int x, int y, MraidWebViewController controller, Runnable postMethod) {
        if (isRedirectProcessed()) {
            return;
        }
        controller.applyClick(x, y);
        this.v = postMethod;
        postDelayed(postMethod, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.t == null) {
            return;
        }
        updateMetrics(new Runnable() { // from class: io.bidmachine.iab.mraid.MraidAdView.3
            @Override // java.lang.Runnable
            public void run() {
                MraidAdView.this.t.applySupportedServices(MraidAdView.this.o);
                if (MraidAdView.this.f6800a != null) {
                    MraidAdView.this.t.applyPlacement(MraidAdView.this.f6800a);
                }
                MraidAdView.this.t.applyViewable(MraidAdView.this.t.isViewable());
                MraidAdView.this.t.applyState(MraidAdView.this.u);
                MraidAdView.this.t.b(MraidAdView.this.c);
                MraidAdView.this.t.notifyReady();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IabError iabError) {
        if (isLoaded()) {
            if (e()) {
                this.s.onMraidAdViewShowFailed(this, iabError);
                return;
            } else {
                this.s.onMraidAdViewExpired(this, iabError);
                return;
            }
        }
        this.s.onMraidAdViewLoadFailed(this, iabError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String url, Executable<String> action) {
        this.i.set(true);
        this.j.set(false);
        this.k.set(true);
        removeCallbacks(this.v);
        if (this.p.a(url)) {
            action.execute(url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MraidResizeProperties mraidResizeProperties) {
        MraidViewState mraidViewState = this.u;
        if (mraidViewState != MraidViewState.LOADING && mraidViewState != MraidViewState.HIDDEN && mraidViewState != MraidViewState.EXPANDED && !isInterstitial()) {
            if (this.s.onResizeIntention(this, this.r.getWebView(), mraidResizeProperties, this.m)) {
                setViewState(MraidViewState.RESIZED);
                return;
            }
            return;
        }
        MraidLog.d("MraidAdView", "Callback: onResize (invalidate state: %s)", this.u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String url) {
        MraidWebViewController mraidWebViewController;
        if (isInterstitial()) {
            return;
        }
        MraidViewState mraidViewState = this.u;
        if (mraidViewState == MraidViewState.DEFAULT || mraidViewState == MraidViewState.RESIZED) {
            if (url == null) {
                mraidWebViewController = this.r;
            } else {
                try {
                    String decode = URLDecoder.decode(url, "UTF-8");
                    if (!io.bidmachine.util.Utils.isHttpUrl(decode)) {
                        decode = this.b + decode;
                    }
                    MraidWebViewController mraidWebViewController2 = new MraidWebViewController(getContext(), new SecondaryControllerCallback(this, null));
                    this.t = mraidWebViewController2;
                    mraidWebViewController2.load(decode);
                    mraidWebViewController = mraidWebViewController2;
                } catch (UnsupportedEncodingException unused) {
                    return;
                }
            }
            if (this.s.onExpandIntention(this, mraidWebViewController.getWebView(), mraidWebViewController.getLastOrientationProperties(), mraidWebViewController.isUseCustomClose())) {
                setViewState(MraidViewState.EXPANDED);
                this.s.onExpanded(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.s.onCloseIntention(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View currentWebView) {
        Context context = getContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.m.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        int[] iArr = new int[2];
        View obtainRootView = MraidUtils.obtainRootView(context, this);
        obtainRootView.getLocationOnScreen(iArr);
        this.m.c(iArr[0], iArr[1], obtainRootView.getWidth(), obtainRootView.getHeight());
        getLocationOnScreen(iArr);
        this.m.b(iArr[0], iArr[1], getWidth(), getHeight());
        currentWebView.getLocationOnScreen(iArr);
        this.m.a(iArr[0], iArr[1], currentWebView.getWidth(), currentWebView.getHeight());
        this.r.applyScreenMetrics(this.m);
        MraidWebViewController mraidWebViewController = this.t;
        if (mraidWebViewController != null) {
            mraidWebViewController.applyScreenMetrics(this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int x, int y, MraidWebViewController controller, Runnable postMethod) {
        if (isRedirectProcessed()) {
            return;
        }
        a(controller.getWebView(), x, y);
        this.v = postMethod;
        postDelayed(postMethod, 150L);
    }

    private void a(MraidWebView webView, int x, int y) {
        webView.dispatchTouchEvent(Utils.obtainMotionEvent(0, x, y));
        webView.dispatchTouchEvent(Utils.obtainMotionEvent(1, x, y));
    }
}
