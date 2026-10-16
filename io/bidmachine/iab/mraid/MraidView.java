package io.bidmachine.iab.mraid;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import io.bidmachine.iab.CacheControl;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.IabSettings;
import io.bidmachine.iab.measurer.MraidAdMeasurer;
import io.bidmachine.iab.mraid.MraidAdView;
import io.bidmachine.iab.utils.Assets;
import io.bidmachine.iab.utils.IabClickCallback;
import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.iab.utils.IabLoadingWrapper;
import io.bidmachine.iab.utils.IabProgressWrapper;
import io.bidmachine.iab.utils.IabTimerHelper;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.iab.view.CloseableLayout;
import io.bidmachine.rendering.model.PrivacySheetParams;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public class MraidView extends CloseableLayout implements CloseableLayout.OnCloseClickListener, IabClickCallback {
    private final IabElementStyle A;
    private final IabElementStyle B;
    private final IabElementStyle C;
    private final IabElementStyle D;
    private boolean E;
    private IabTimerHelper F;
    private IabProgressWrapper G;
    private Integer H;
    private final MutableContextWrapper h;
    private final MraidAdView i;
    private CloseableLayout j;
    private CloseableLayout k;
    private IabLoadingWrapper l;
    private WeakReference<Activity> m;
    private String n;
    private MraidViewListener o;
    private final MraidAdMeasurer p;
    private final CacheControl q;
    private final float r;
    private final float s;
    private final float t;
    private final boolean u;
    private final boolean v;
    private final boolean w;
    private final boolean x;
    private final AtomicBoolean y;
    private final CloseableLayout.OnCloseClickListener z;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final MraidPlacementType f6819a;
        private CacheControl b;
        private String c;
        private String d;
        private String e;
        private String[] f;
        private IabElementStyle g;
        private IabElementStyle h;
        private IabElementStyle i;
        private IabElementStyle j;
        private float k;
        private float l;
        public MraidViewListener listener;
        private float m;
        public MraidAdMeasurer mraidAdMeasurer;
        private boolean n;
        private boolean o;
        private boolean p;
        private boolean q;

        public Builder() {
            this(MraidPlacementType.INLINE);
        }

        public MraidView build(Context context) {
            return new MraidView(context, this, null);
        }

        public Builder forceUseNativeCloseButton(boolean forceUseNativeCloseButton) {
            this.o = forceUseNativeCloseButton;
            return this;
        }

        public Builder setAdMeasurer(MraidAdMeasurer mraidAdMeasurer) {
            this.mraidAdMeasurer = mraidAdMeasurer;
            return this;
        }

        public Builder setAllowedNativeFeatures(String[] allowedNativeFeatures) {
            this.f = allowedNativeFeatures;
            return this;
        }

        public Builder setBaseUrl(String baseUrl) {
            this.c = baseUrl;
            return this;
        }

        public Builder setCacheControl(CacheControl cacheControl) {
            this.b = cacheControl;
            return this;
        }

        public Builder setCloseStyle(IabElementStyle closeStyle) {
            this.g = closeStyle;
            return this;
        }

        public Builder setCloseTimeSec(float closeTimeSec) {
            this.l = closeTimeSec;
            return this;
        }

        public Builder setCountDownStyle(IabElementStyle countDownStyle) {
            this.h = countDownStyle;
            return this;
        }

        public Builder setDurationSec(float durationSec) {
            this.m = durationSec;
            return this;
        }

        public Builder setIsTag(boolean isTag) {
            this.n = isTag;
            return this;
        }

        public Builder setListener(MraidViewListener listener) {
            this.listener = listener;
            return this;
        }

        public Builder setLoadingStyle(IabElementStyle loadingStyle) {
            this.i = loadingStyle;
            return this;
        }

        public Builder setPageFinishedScript(String pageFinishedScript) {
            this.e = pageFinishedScript;
            return this;
        }

        public Builder setPlaceholderTimeoutSec(float placeholderTimeoutSec) {
            this.k = placeholderTimeoutSec;
            return this;
        }

        public Builder setProductLink(String productLink) {
            this.d = productLink;
            return this;
        }

        public Builder setProgressStyle(IabElementStyle progressStyle) {
            this.j = progressStyle;
            return this;
        }

        public Builder setR1(boolean r1) {
            this.p = r1;
            return this;
        }

        public Builder setR2(boolean r2) {
            this.q = r2;
            return this;
        }

        Builder(MraidPlacementType placementType) {
            this.f = null;
            this.k = 3.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.f6819a = placementType;
            this.b = CacheControl.FullLoad;
            this.c = IabSettings.DEF_BASE_URL;
        }
    }

    class a implements IabTimerHelper.TimerHelperCallback {
        a() {
        }

        @Override // io.bidmachine.iab.utils.IabTimerHelper.TimerHelperCallback
        public void onTimerFinish() {
            if (MraidView.this.G != null) {
                MraidView.this.G.detach();
            }
            if (MraidView.this.i.isOpenNotified() || !MraidView.this.x || MraidView.this.t <= 0.0f) {
                return;
            }
            MraidView.this.g();
        }

        @Override // io.bidmachine.iab.utils.IabTimerHelper.TimerHelperCallback
        public void onTimerTick(float percent, long currentTimeMs, long totalTimeMs) {
            int i = (int) (totalTimeMs / 1000);
            int i2 = (int) (currentTimeMs / 1000);
            if (MraidView.this.G != null) {
                MraidView.this.G.changePercentage(percent, i2, i);
            }
        }
    }

    class b implements CloseableLayout.OnCloseClickListener {
        b() {
        }

        @Override // io.bidmachine.iab.view.CloseableLayout.OnCloseClickListener
        public void onCloseClick() {
            MraidView.this.c(IabError.placeholder("Close button clicked"));
            MraidView.this.j();
        }

        @Override // io.bidmachine.iab.view.CloseableLayout.OnCloseClickListener
        public void onCountDownFinish() {
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MraidViewState mraidViewState = MraidView.this.i.getMraidViewState();
            if (mraidViewState == MraidViewState.RESIZED) {
                MraidView.this.e();
                return;
            }
            if (mraidViewState == MraidViewState.EXPANDED) {
                MraidView.this.d();
            } else if (MraidView.this.h()) {
                MraidView.this.i.close();
                MraidView.this.j();
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MraidView.this.i.updateMetrics(null);
        }
    }

    static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6824a;

        static {
            int[] iArr = new int[CacheControl.values().length];
            f6824a = iArr;
            try {
                iArr[CacheControl.FullLoad.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6824a[CacheControl.Stream.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6824a[CacheControl.PartialLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private class f implements MraidAdView.Listener {
        private f() {
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public void onCalendarEventIntention(MraidAdView mraidAdView, String url) {
            MraidView.this.b(url);
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public void onChangeOrientationIntention(MraidAdView mraidAdView, MraidOrientationProperties mraidOrientationProperties) {
            MraidView.this.a(mraidOrientationProperties);
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public void onCloseIntention(MraidAdView mraidAdView) {
            MraidView.this.f();
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public boolean onExpandIntention(MraidAdView mraidAdView, WebView webView, MraidOrientationProperties mraidOrientationProperties, boolean isUseCustomClose) {
            return MraidView.this.a(webView, mraidOrientationProperties, isUseCustomClose);
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public void onExpanded(MraidAdView mraidAdView) {
            MraidView.this.k();
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public void onMraidAdViewExpired(MraidAdView mraidAdView, IabError iabError) {
            MraidView.this.a(iabError);
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public void onMraidAdViewLoadFailed(MraidAdView mraidAdView, IabError iabError) {
            MraidView.this.b(iabError);
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public void onMraidAdViewPageLoaded(MraidAdView mraidAdView, String url, WebView webView, boolean isUseCustomClose) {
            MraidView.this.a(url, webView, isUseCustomClose);
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public void onMraidAdViewShowFailed(MraidAdView mraidAdView, IabError iabError) {
            MraidView.this.c(iabError);
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public void onMraidAdViewShown(MraidAdView mraidAdView) {
            MraidView.this.m();
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public void onMraidLoadedIntention(MraidAdView mraidAdView) {
            MraidView.this.l();
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public void onOpenPrivacySheet(MraidAdView mraidAdView, PrivacySheetParams privacySheetParams) {
            MraidView.this.a(privacySheetParams);
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public void onOpenUrlIntention(MraidAdView mraidAdView, String url) {
            MraidView.this.c(url);
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public void onPlayVideoIntention(MraidAdView mraidAdView, String url) {
            MraidView.this.a(url);
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public boolean onResizeIntention(MraidAdView mraidAdView, WebView webView, MraidResizeProperties mraidResizeProperties, MraidScreenMetrics mraidScreenMetrics) {
            return MraidView.this.a(webView, mraidResizeProperties, mraidScreenMetrics);
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public void onStorePictureIntention(MraidAdView mraidAdView, String url) {
            MraidView.this.d(url);
        }

        @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
        public void onSyncCustomCloseIntention(MraidAdView mraidAdView, boolean isUseCustomClose) {
            if (MraidView.this.v) {
                return;
            }
            if (isUseCustomClose && !MraidView.this.E) {
                MraidView.this.E = true;
            }
            MraidView.this.a(isUseCustomClose);
        }

        /* synthetic */ f(MraidView mraidView, a aVar) {
            this();
        }
    }

    /* synthetic */ MraidView(Context context, Builder builder, a aVar) {
        this(context, builder);
    }

    private void n() {
        setCloseClickListener(this.z);
        setCloseVisibility(true, this.r);
    }

    @Override // io.bidmachine.iab.view.CloseableLayout
    public boolean canBeClosed() {
        if (getOnScreenTimeMs() > MraidUtils.MAX_ON_SCREEN_TIME_MS || this.i.isReceivedJsError()) {
            return true;
        }
        if (this.v || !this.i.isUseCustomClose()) {
            return super.canBeClosed();
        }
        return false;
    }

    @Override // io.bidmachine.iab.utils.IabClickCallback
    public void clickHandleCanceled() {
        setLoadingVisible(false);
    }

    @Override // io.bidmachine.iab.utils.IabClickCallback
    public void clickHandleError() {
        setLoadingVisible(false);
    }

    @Override // io.bidmachine.iab.utils.IabClickCallback
    public void clickHandled() {
        setLoadingVisible(false);
    }

    public void destroy() {
        this.o = null;
        this.m = null;
        Activity peekActivity = peekActivity();
        if (peekActivity != null) {
            a(peekActivity);
        }
        a((View) this.j);
        a((View) this.k);
        this.i.destroy();
        IabTimerHelper iabTimerHelper = this.F;
        if (iabTimerHelper != null) {
            iabTimerHelper.detach();
        }
    }

    public void load(final String htmlData) {
        MraidAdMeasurer mraidAdMeasurer = this.p;
        if (mraidAdMeasurer != null && htmlData != null) {
            htmlData = mraidAdMeasurer.prepareCreativeForMeasure(htmlData);
        }
        int i = e.f6824a[this.q.ordinal()];
        if (i == 1) {
            e(htmlData);
            return;
        }
        if (i == 2) {
            this.n = htmlData;
            l();
        } else {
            if (i != 3) {
                return;
            }
            l();
            e(htmlData);
        }
    }

    @Override // io.bidmachine.iab.view.CloseableLayout.OnCloseClickListener
    public void onCloseClick() {
        f();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        MraidLog.d("MraidView", "onConfigurationChanged: %s", Utils.orientationToString(newConfig.orientation));
        Utils.onUiThread(new d());
    }

    @Override // io.bidmachine.iab.view.CloseableLayout.OnCloseClickListener
    public void onCountDownFinish() {
        if (!this.i.isOpenNotified() && this.x && this.t == 0.0f) {
            g();
        }
    }

    public Activity peekActivity() {
        WeakReference<Activity> weakReference = this.m;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Context peekContext() {
        Activity peekActivity = peekActivity();
        return peekActivity == null ? getContext() : peekActivity;
    }

    public void setLastInteractedActivity(Activity activity) {
        if (activity != null) {
            this.m = new WeakReference<>(activity);
            this.h.setBaseContext(activity);
        }
    }

    public void setLoadingVisible(boolean visible) {
        if (!visible) {
            IabLoadingWrapper iabLoadingWrapper = this.l;
            if (iabLoadingWrapper != null) {
                iabLoadingWrapper.setVisibility(8);
                return;
            }
            return;
        }
        if (this.l == null) {
            IabLoadingWrapper iabLoadingWrapper2 = new IabLoadingWrapper(null);
            this.l = iabLoadingWrapper2;
            iabLoadingWrapper2.attach(getContext(), this, this.C);
        }
        this.l.setVisibility(0);
        this.l.bringToFront();
    }

    public void show(Activity activity) {
        int i = e.f6824a[this.q.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (h()) {
                    n();
                }
                e(this.n);
                this.n = null;
            } else if (i == 3) {
                if (i()) {
                    if (h()) {
                        a((CloseableLayout) this, this.i.isUseCustomClose());
                    }
                } else if (h()) {
                    n();
                }
            }
        } else if (h()) {
            a((CloseableLayout) this, this.i.isUseCustomClose());
        }
        this.i.show();
        setLastInteractedActivity(activity);
        a(this.i.getLastOrientationProperties());
    }

    private MraidView(Context context, Builder builder) {
        super(context);
        this.y = new AtomicBoolean(false);
        this.E = false;
        this.h = new MutableContextWrapper(context);
        this.o = builder.listener;
        this.q = builder.b;
        this.r = builder.k;
        this.s = builder.l;
        float f2 = builder.m;
        this.t = f2;
        this.u = builder.n;
        this.v = builder.o;
        this.w = builder.p;
        this.x = builder.q;
        MraidAdMeasurer mraidAdMeasurer = builder.mraidAdMeasurer;
        this.p = mraidAdMeasurer;
        this.A = builder.g;
        this.B = builder.h;
        this.C = builder.i;
        IabElementStyle iabElementStyle = builder.j;
        this.D = iabElementStyle;
        MraidAdView build = new MraidAdView.Builder(context.getApplicationContext(), builder.f6819a, new f(this, null)).setBaseUrl(builder.c).setProductLink(builder.d).setAllowedNativeFeatures(builder.f).setPageFinishedScript(builder.e).build();
        this.i = build;
        addView(build, new FrameLayout.LayoutParams(-1, -1, 17));
        if (f2 > 0.0f) {
            IabProgressWrapper iabProgressWrapper = new IabProgressWrapper(null);
            this.G = iabProgressWrapper;
            iabProgressWrapper.attach(context, this, iabElementStyle);
            IabTimerHelper iabTimerHelper = new IabTimerHelper(this, new a());
            this.F = iabTimerHelper;
            iabTimerHelper.setTime(f2);
        }
        this.z = new b();
        setCloseClickListener(this);
        if (mraidAdMeasurer != null) {
            mraidAdMeasurer.registerAdContainer(this);
            mraidAdMeasurer.registerAdView(build.getWebView());
        }
    }

    private void e(String htmlData) {
        this.i.load(htmlData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        IabElementStyle resolveDefCloseStyle = Assets.resolveDefCloseStyle(getContext(), this.A);
        this.i.handleRedirectScreen(resolveDefCloseStyle.getHorizontalPosition().intValue(), resolveDefCloseStyle.getVerticalPosition().intValue());
    }

    private boolean i() {
        return this.i.isLoaded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        MraidViewListener mraidViewListener = this.o;
        if (mraidViewListener != null) {
            mraidViewListener.onClose(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        MraidViewListener mraidViewListener = this.o;
        if (mraidViewListener != null) {
            mraidViewListener.onExpand(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        MraidViewListener mraidViewListener;
        if (this.y.getAndSet(true) || (mraidViewListener = this.o) == null) {
            return;
        }
        mraidViewListener.onLoaded(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        MraidAdMeasurer mraidAdMeasurer = this.p;
        if (mraidAdMeasurer != null) {
            mraidAdMeasurer.onAdShown();
        }
        MraidViewListener mraidViewListener = this.o;
        if (mraidViewListener != null) {
            mraidViewListener.onShown(this);
        }
    }

    void f() {
        if (this.i.isOpenNotified() || !this.w) {
            Utils.onUiThread(new c());
        } else {
            g();
        }
    }

    boolean h() {
        return this.i.isInterstitial();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        a((View) this.k);
        this.k = null;
        Activity peekActivity = peekActivity();
        if (peekActivity != null) {
            a(peekActivity);
        }
        this.i.closeExpanded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a((View) this.j);
        this.j = null;
        this.i.closeResized();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(IabError iabError) {
        MraidAdMeasurer mraidAdMeasurer = this.p;
        if (mraidAdMeasurer != null) {
            mraidAdMeasurer.onError(iabError);
        }
        MraidViewListener mraidViewListener = this.o;
        if (mraidViewListener != null) {
            mraidViewListener.onShowFailed(this, iabError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(IabError iabError) {
        MraidAdMeasurer mraidAdMeasurer = this.p;
        if (mraidAdMeasurer != null) {
            mraidAdMeasurer.onError(iabError);
        }
        MraidViewListener mraidViewListener = this.o;
        if (mraidViewListener != null) {
            mraidViewListener.onLoadFailed(this, iabError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String url) {
        if (this.o == null) {
            return;
        }
        setLoadingVisible(true);
        MraidAdMeasurer mraidAdMeasurer = this.p;
        if (mraidAdMeasurer != null) {
            mraidAdMeasurer.onAdClicked();
        }
        this.o.onOpenUrl(this, url, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IabError iabError) {
        MraidAdMeasurer mraidAdMeasurer = this.p;
        if (mraidAdMeasurer != null) {
            mraidAdMeasurer.onError(iabError);
        }
        MraidViewListener mraidViewListener = this.o;
        if (mraidViewListener != null) {
            mraidViewListener.onExpired(this, iabError);
        }
    }

    private void b(Activity activity) {
        this.H = Integer.valueOf(activity.getRequestedOrientation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String url) {
        if (this.o == null) {
            return;
        }
        setLoadingVisible(true);
        MraidAdMeasurer mraidAdMeasurer = this.p;
        if (mraidAdMeasurer != null) {
            mraidAdMeasurer.onAdClicked();
        }
        this.o.onCalendarEvent(this, url, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String url) {
        if (this.o == null) {
            return;
        }
        setLoadingVisible(true);
        MraidAdMeasurer mraidAdMeasurer = this.p;
        if (mraidAdMeasurer != null) {
            mraidAdMeasurer.onAdClicked();
        }
        this.o.onStorePicture(this, url, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String url) {
        MraidViewListener mraidViewListener = this.o;
        if (mraidViewListener != null) {
            mraidViewListener.onPlayVideo(this, url);
        }
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).removeAllViews();
        }
        Utils.removeFromParent(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String url, WebView webView, boolean isUseCustomClose) {
        setLoadingVisible(false);
        if (h()) {
            a((CloseableLayout) this, isUseCustomClose);
        }
        MraidAdMeasurer mraidAdMeasurer = this.p;
        if (mraidAdMeasurer != null) {
            mraidAdMeasurer.onAdViewReady(webView);
        }
        if (this.q != CacheControl.FullLoad || this.u || url.equals("data:text/html,<html></html>")) {
            return;
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PrivacySheetParams privacySheetParams) {
        MraidViewListener mraidViewListener = this.o;
        if (mraidViewListener == null) {
            return;
        }
        mraidViewListener.onOpenPrivacySheet(this, privacySheetParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(WebView webView, MraidResizeProperties mraidResizeProperties, MraidScreenMetrics mraidScreenMetrics) {
        CloseableLayout closeableLayout = this.j;
        if (closeableLayout == null || closeableLayout.getParent() == null) {
            View topmostView = MraidUtils.getTopmostView(peekContext(), this);
            if (!(topmostView instanceof ViewGroup)) {
                MraidLog.e("MraidView", "Can't add resized view because can't find required parent", new Object[0]);
                return false;
            }
            CloseableLayout closeableLayout2 = new CloseableLayout(getContext());
            this.j = closeableLayout2;
            closeableLayout2.setCloseClickListener(this);
            ((ViewGroup) topmostView).addView(this.j);
        }
        Utils.removeFromParent(webView);
        this.j.addView(webView);
        IabElementStyle resolveDefCloseStyle = Assets.resolveDefCloseStyle(getContext(), this.A);
        resolveDefCloseStyle.setHorizontalPosition(Integer.valueOf(mraidResizeProperties.customClosePosition.getGravity() & 7));
        resolveDefCloseStyle.setVerticalPosition(Integer.valueOf(mraidResizeProperties.customClosePosition.getGravity() & 112));
        this.j.setCloseStyle(resolveDefCloseStyle);
        this.j.setCloseVisibility(false, this.s);
        a(mraidResizeProperties, mraidScreenMetrics);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(WebView webView, MraidOrientationProperties mraidOrientationProperties, boolean isUseCustomClose) {
        CloseableLayout closeableLayout = this.k;
        if (closeableLayout == null || closeableLayout.getParent() == null) {
            View topmostView = MraidUtils.getTopmostView(peekContext(), this);
            if (!(topmostView instanceof ViewGroup)) {
                MraidLog.e("MraidView", "Can't add resized view because can't find required parent", new Object[0]);
                return false;
            }
            CloseableLayout closeableLayout2 = new CloseableLayout(getContext());
            this.k = closeableLayout2;
            closeableLayout2.setCloseClickListener(this);
            ((ViewGroup) topmostView).addView(this.k);
        }
        Utils.removeFromParent(webView);
        this.k.addView(webView);
        a(this.k, isUseCustomClose);
        a(mraidOrientationProperties);
        return true;
    }

    private void a(CloseableLayout layout, boolean isUseCustomClose) {
        setCloseClickListener(this);
        layout.setCloseStyle(this.A);
        layout.setCountDownStyle(this.B);
        a(isUseCustomClose);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean isUseCustomClose) {
        boolean z = !isUseCustomClose || this.v;
        CloseableLayout closeableLayout = this.j;
        if (closeableLayout != null) {
            closeableLayout.setCloseVisibility(z, this.s);
            return;
        }
        CloseableLayout closeableLayout2 = this.k;
        if (closeableLayout2 != null) {
            closeableLayout2.setCloseVisibility(z, this.s);
        } else if (h()) {
            setCloseVisibility(z, this.E ? 0.0f : this.s);
        }
    }

    private void a(MraidResizeProperties mraidResizeProperties, MraidScreenMetrics mraidScreenMetrics) {
        MraidLog.d("MraidView", "setResizedViewSizeAndPosition: %s", mraidResizeProperties);
        if (this.j == null) {
            return;
        }
        int dpToPx = Utils.dpToPx(getContext(), mraidResizeProperties.width);
        int dpToPx2 = Utils.dpToPx(getContext(), mraidResizeProperties.height);
        int dpToPx3 = Utils.dpToPx(getContext(), mraidResizeProperties.offsetX);
        int dpToPx4 = Utils.dpToPx(getContext(), mraidResizeProperties.offsetY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, dpToPx2);
        Rect b2 = mraidScreenMetrics.b();
        int i = b2.left + dpToPx3;
        int i2 = b2.top + dpToPx4;
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        this.j.setLayoutParams(layoutParams);
    }

    private void a(Activity activity) {
        Integer num = this.H;
        if (num != null) {
            activity.setRequestedOrientation(num.intValue());
            this.H = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MraidOrientationProperties mraidOrientationProperties) {
        if (mraidOrientationProperties == null) {
            return;
        }
        Activity peekActivity = peekActivity();
        MraidLog.d("MraidView", "applyOrientation: %s", mraidOrientationProperties);
        if (peekActivity == null) {
            MraidLog.d("MraidView", "no any interacted activities", new Object[0]);
        } else {
            b(peekActivity);
            peekActivity.setRequestedOrientation(mraidOrientationProperties.obtainTargetActivityOrientation(peekActivity));
        }
    }
}
