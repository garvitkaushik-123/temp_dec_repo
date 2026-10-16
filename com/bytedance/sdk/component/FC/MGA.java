package com.bytedance.sdk.component.FC;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.bytedance.sdk.component.FC.eli;
import com.bytedance.sdk.component.utils.Vy;
import com.ironsource.C3040d4;
import com.vungle.ads.internal.model.AdPayload;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA extends FrameLayout {
    private static Os SSo;
    private boolean CMM;
    private AtomicBoolean Cp;
    public int DbA;
    private View Dfc;
    private float FC;
    private long FS;
    private DbA GB;
    private float KM;
    private JSONObject MGA;
    private boolean NU;
    public int Os;
    private com.bytedance.sdk.component.FC.aGH QX;
    private float Ue;
    private long Uv;
    private int VM;
    private boolean Vy;
    private boolean Xb;
    private long aAs;
    private com.bytedance.sdk.component.FC.DbA.eli aGH;
    private eli.InterfaceC0132eli aqO;
    private boolean bf;
    private AtomicBoolean cyF;
    private com.bytedance.sdk.component.FC.eli dV;
    private aGH dZ;
    private long du;
    private AtomicBoolean eU;
    public int eli;
    private boolean ev;
    private WebViewClient gG;
    private boolean kb;
    private List<String> nGm;
    private long nlS;
    private volatile WebView nn;
    private Context nro;
    private Vy oWW;
    private AttributeSet qj;
    private String ui;
    private float ujq;
    private float wC;

    public interface DbA {
    }

    public interface Os {
        WebView createWebView(Context context, AttributeSet attributeSet, int i);
    }

    public interface aGH {
    }

    private static void Os(Context context) {
    }

    private static Context eli(Context context) {
        return context;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
    }

    public com.bytedance.sdk.component.FC.DbA.eli getMaterialMeta() {
        return this.aGH;
    }

    public boolean l_() {
        return this.Xb;
    }

    public void setLpPreRender(boolean z) {
        this.Xb = z;
    }

    public boolean DbA() {
        return this.bf;
    }

    public void setPreStart(boolean z) {
        this.bf = z;
    }

    public boolean Os() {
        return this.CMM;
    }

    public void setPreFinish(boolean z) {
        this.CMM = z;
    }

    public boolean aGH() {
        return this.ev;
    }

    public void setPreProgressHundred(boolean z) {
        this.ev = z;
    }

    public void setPreError(boolean z) {
        this.Vy = z;
    }

    public void setMaterialMeta(com.bytedance.sdk.component.FC.DbA.eli eliVar) {
        this.aGH = eliVar;
    }

    @Override // android.view.View
    public String getTag() {
        return this.ui;
    }

    public void setTag(String str) {
        this.ui = str;
        com.bytedance.sdk.component.FC.eli eliVar = this.dV;
        if (eliVar != null) {
            eliVar.eli(str);
        }
        com.bytedance.sdk.component.FC.aGH agh = this.QX;
        if (agh != null) {
            agh.eli(str);
        }
    }

    public void setLandingPage(boolean z) {
        this.kb = z;
    }

    public void setTouchStateListener(aGH agh) {
        this.dZ = agh;
    }

    public MGA(Context context) {
        this(eli(context), false);
    }

    public MGA(Context context, boolean z) {
        super(eli(context));
        this.wC = 0.0f;
        this.FC = 0.0f;
        this.aAs = 0L;
        this.du = 0L;
        this.nlS = 0L;
        this.NU = false;
        this.ujq = 20.0f;
        this.KM = 50.0f;
        this.Cp = new AtomicBoolean();
        this.cyF = new AtomicBoolean();
        this.eU = new AtomicBoolean();
        this.nro = context;
        if (z) {
            return;
        }
        try {
            this.nn = eli((AttributeSet) null, 0);
            MGA();
        } catch (Throwable unused) {
        }
        DbA(eli(context));
    }

    public void eli(boolean z, int i, int i2, List<Integer> list, int i3, List<String> list2) {
        if (z && this.nn != null && (this.nn instanceof ui)) {
            this.dV = new com.bytedance.sdk.component.FC.eli(this.nro, i, i2, list, i3);
            this.nGm = list2;
            if (!TextUtils.isEmpty(this.ui)) {
                this.dV.eli(this.ui);
            }
            ((ui) this.nn).setTouchListenerProxy(this.dV);
            this.aqO = this.dV.eli();
        }
    }

    public void eli(int i, long j) {
        if (this.nn == null || !(this.nn instanceof ui)) {
            return;
        }
        this.QX = new com.bytedance.sdk.component.FC.aGH(this.nro, this.dV, i, j, this);
        if (!TextUtils.isEmpty(this.ui)) {
            this.QX.eli(this.ui);
        }
        ((ui) this.nn).setTouchListenerProxy(this.QX);
    }

    public void eli(boolean z, View view) {
        if (z) {
            this.Dfc = view;
            view.setVisibility(8);
            View view2 = this.Dfc;
            if (view2 == null || view2.getParent() != null) {
                return;
            }
            addView(this.Dfc, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public View getArbitrageLoadingView() {
        return this.Dfc;
    }

    public void ui() {
        try {
            this.nn = eli(this.qj, 0);
            MGA();
            DbA(eli(this.nro));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void setWebViewProvider(Os os) {
        SSo = os;
    }

    private WebView eli(AttributeSet attributeSet, int i) {
        Os os = SSo;
        if (os != null) {
            return os.createWebView(getContext(), attributeSet, i);
        }
        if (attributeSet == null) {
            return new WebView(eli(this.nro));
        }
        return new WebView(eli(this.nro), attributeSet);
    }

    public void setRecycler(boolean z) {
        if (this.nn == null || !(this.nn instanceof ui)) {
            return;
        }
        ((ui) this.nn).setRecycler(z);
    }

    public void MGA() {
        if (this.nn != null) {
            removeAllViews();
            setBackground(null);
            try {
                this.nn.setId(520093704);
            } catch (Throwable unused) {
            }
            addView(this.nn, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void DbA(Context context) {
        Os(context);
        Xb();
        QX();
    }

    public void setNetworkAvailable(boolean z) {
        try {
            this.nn.setNetworkAvailable(z);
        } catch (Throwable unused) {
        }
    }

    public void eli(String str, Map<String, String> map) {
        try {
            setJavaScriptEnabled(str);
            this.nn.loadUrl(str, map);
        } catch (Throwable unused) {
        }
    }

    public void a_(String str) {
        try {
            setJavaScriptEnabled(str);
            this.nn.loadUrl(str);
        } catch (Throwable unused) {
        }
    }

    public void eli(String str, String str2, String str3, String str4, String str5) {
        try {
            setJavaScriptEnabled(str);
            this.nn.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } catch (Throwable unused) {
        }
    }

    public void kb() {
        try {
            this.nn.stopLoading();
        } catch (Throwable unused) {
        }
    }

    public void wC() {
        try {
            this.nn.reload();
        } catch (Throwable unused) {
        }
    }

    public boolean FC() {
        if (this.nn == null) {
            return false;
        }
        try {
            return this.nn.canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void aAs() {
        try {
            this.nn.goBack();
        } catch (Throwable unused) {
        }
    }

    public boolean du() {
        if (this.nn == null) {
            return false;
        }
        try {
            return this.nn.canGoForward();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void nlS() {
        try {
            this.nn.goForward();
        } catch (Throwable unused) {
        }
    }

    public void NU() {
        if (this.nn != null) {
            this.nn.onResume();
        }
    }

    public String getUrl() {
        if (this.nn == null) {
            return null;
        }
        try {
            return this.nn.getUrl();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getOriginalUrl() {
        String url;
        if (this.nn == null) {
            return null;
        }
        try {
            String originalUrl = this.nn.getOriginalUrl();
            if (originalUrl != null && originalUrl.startsWith("data:text/html") && (url = this.nn.getUrl()) != null) {
                if (url.startsWith(AdPayload.FILE_SCHEME)) {
                    return url;
                }
            }
            return originalUrl;
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getProgress() {
        if (this.nn == null) {
            return 0;
        }
        try {
            return this.nn.getProgress();
        } catch (Throwable unused) {
            return 100;
        }
    }

    public int getContentHeight() {
        if (this.nn == null) {
            return 0;
        }
        try {
            return this.nn.getContentHeight();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public void eli(boolean z) {
        try {
            this.nn.clearCache(z);
        } catch (Throwable unused) {
        }
    }

    public void nn() {
        try {
            this.nn.clearHistory();
        } catch (Throwable unused) {
        }
    }

    public static void setDataDirectorySuffix(String str) {
        WebView.setDataDirectorySuffix(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setWebViewClient(WebViewClient webViewClient) {
        try {
            if (webViewClient instanceof aGH) {
                setTouchStateListener((aGH) webViewClient);
            } else {
                setTouchStateListener(null);
            }
            if (webViewClient == 0) {
                webViewClient = new eli();
            }
            this.gG = webViewClient;
            this.nn.setWebViewClient(new kb(this.aqO, webViewClient, this.nGm));
        } catch (Throwable unused) {
        }
    }

    public WebViewClient getWebViewClient() {
        return this.gG;
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        try {
            this.nn.setDownloadListener(downloadListener);
        } catch (Throwable unused) {
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        try {
            this.nn.setWebChromeClient(webChromeClient);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        try {
            this.nn.setBackgroundColor(i);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.nn == null) {
            return;
        }
        try {
            this.nn.computeScroll();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent eli2;
        try {
            eli(motionEvent);
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.NU && (eli2 = eli(this)) != null) {
                eli2.requestDisallowInterceptTouchEvent(true);
            }
            return onInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public void setIsPreventTouchEvent(boolean z) {
        this.NU = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ViewParent eli(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (DbA(view2) || Os(view2)) ? parent : eli(view2);
    }

    private static boolean DbA(View view) {
        try {
            Class<?> loadClass = view.getClass().getClassLoader().loadClass("android.support.v4.view.ViewPager");
            if (loadClass != null) {
                if (loadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> loadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (loadClass2 != null) {
                return loadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable unused2) {
            return false;
        }
    }

    private static boolean Os(View view) {
        try {
            Class<?> loadClass = view.getClass().getClassLoader().loadClass("android.support.v4.view.ScrollingView");
            if (loadClass != null) {
                if (loadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> loadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (loadClass2 != null) {
                return loadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable unused2) {
            return false;
        }
    }

    @Override // android.view.View
    public void setLayerType(int i, Paint paint) {
        try {
            this.nn.setLayerType(i, paint);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        try {
            this.nn.setOverScrollMode(i);
            super.setOverScrollMode(i);
        } catch (Throwable unused) {
        }
    }

    private void QX() {
        if (this.nn == null) {
            return;
        }
        try {
            this.nn.removeJavascriptInterface("searchBoxJavaBridge_");
            this.nn.removeJavascriptInterface("accessibility");
            this.nn.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    public void eli(Object obj, String str) {
        try {
            this.nn.addJavascriptInterface(obj, str);
        } catch (Throwable unused) {
        }
    }

    public void setJavaScriptEnabled(boolean z) {
        try {
            this.nn.getSettings().setJavaScriptEnabled(z);
        } catch (Throwable unused) {
        }
    }

    public void setDisplayZoomControls(boolean z) {
        try {
            this.nn.getSettings().setDisplayZoomControls(z);
        } catch (Throwable unused) {
        }
    }

    public void setCacheMode(int i) {
        try {
            this.nn.getSettings().setCacheMode(i);
        } catch (Throwable unused) {
        }
    }

    private void Xb() {
        try {
            WebSettings settings = this.nn.getSettings();
            if (settings != null) {
                settings.setSavePassword(false);
            }
        } catch (Throwable unused) {
        }
    }

    private void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (!TextUtils.isEmpty(str) && (settings = this.nn.getSettings()) != null) {
                if (Uri.parse(str).getScheme().equalsIgnoreCase(C3040d4.h.b)) {
                    settings.setJavaScriptEnabled(false);
                } else {
                    settings.setJavaScriptEnabled(true);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void Dfc() {
        if (this.nn == null) {
            return;
        }
        try {
            this.nn.onPause();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public String getUserAgentString() {
        if (this.nn == null) {
            return "";
        }
        try {
            return this.nn.getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public WebView getWebView() {
        return this.nn;
    }

    public void aqO() {
        if (this.nn == null) {
            return;
        }
        try {
            this.nn.destroy();
        } catch (Throwable unused) {
        }
    }

    public void b_(String str) {
        try {
            this.nn.removeJavascriptInterface(str);
        } catch (Throwable unused) {
        }
    }

    public void setSupportZoom(boolean z) {
        try {
            this.nn.getSettings().setSupportZoom(z);
        } catch (Throwable unused) {
        }
    }

    public void setUseWideViewPort(boolean z) {
        try {
            this.nn.getSettings().setUseWideViewPort(z);
        } catch (Throwable unused) {
        }
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        try {
            this.nn.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
        } catch (Throwable unused) {
        }
    }

    public void setDomStorageEnabled(boolean z) {
        try {
            this.nn.getSettings().setDomStorageEnabled(z);
        } catch (Throwable unused) {
        }
    }

    public void setBuiltInZoomControls(boolean z) {
        try {
            this.nn.getSettings().setBuiltInZoomControls(z);
        } catch (Throwable unused) {
        }
    }

    public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        try {
            this.nn.getSettings().setLayoutAlgorithm(layoutAlgorithm);
        } catch (Throwable unused) {
        }
    }

    public void setLoadWithOverviewMode(boolean z) {
        try {
            this.nn.getSettings().setLoadWithOverviewMode(z);
        } catch (Throwable unused) {
        }
    }

    public void setUserAgentString(String str) {
        try {
            this.nn.getSettings().setUserAgentString(str);
        } catch (Throwable unused) {
        }
    }

    public void setDefaultTextEncodingName(String str) {
        try {
            this.nn.getSettings().setDefaultTextEncodingName(str);
        } catch (Throwable unused) {
        }
    }

    public void setDefaultFontSize(int i) {
        try {
            this.nn.getSettings().setDefaultFontSize(i);
        } catch (Throwable unused) {
        }
    }

    public void setMixedContentMode(int i) {
        try {
            this.nn.getSettings().setMixedContentMode(i);
        } catch (Throwable unused) {
        }
    }

    public void setDatabaseEnabled(boolean z) {
        try {
            this.nn.getSettings().setDatabaseEnabled(z);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        try {
            super.setVisibility(i);
            this.nn.setVisibility(i);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        try {
            super.setAlpha(f);
            this.nn.setAlpha(f);
        } catch (Throwable unused) {
        }
    }

    public void setAllowFileAccess(boolean z) {
        try {
            this.nn.getSettings().setAllowFileAccess(z);
        } catch (Throwable unused) {
        }
    }

    public void dV() {
        try {
            this.nn.clearView();
        } catch (Throwable unused) {
        }
    }

    public void nGm() {
        try {
            this.nn.pauseTimers();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        try {
            this.nn.removeAllViews();
        } catch (Throwable unused) {
        }
    }

    private void bf() {
        if (this.oWW == null) {
            this.eU.set(false);
            this.oWW = new Vy(getContext());
        }
        new Object() { // from class: com.bytedance.sdk.component.FC.MGA.1
        };
        this.eU.set(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Cp.set(true);
        if (!this.cyF.get() || this.eU.get()) {
            return;
        }
        bf();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Cp.set(false);
    }

    public long getLandingPageClickBegin() {
        return this.Uv;
    }

    public void setLandingPageClickBegin(long j) {
        this.Uv = j;
    }

    public long getLandingPageClickEnd() {
        return this.FS;
    }

    public void setLandingPageClickEnd(long j) {
        this.FS = j;
    }

    private void eli(MotionEvent motionEvent) {
        if (!this.kb || this.aGH == null) {
            return;
        }
        if ((this.ui == null && this.MGA == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.wC = motionEvent.getRawX();
                this.FC = motionEvent.getRawY();
                this.aAs = System.currentTimeMillis();
                this.MGA = new JSONObject();
                if (this.nn != null) {
                    this.Uv = this.aAs;
                    return;
                }
                return;
            }
            if (action == 1 || action == 3) {
                this.MGA.put("start_x", String.valueOf(this.wC));
                this.MGA.put("start_y", String.valueOf(this.FC));
                this.MGA.put("offset_x", String.valueOf(motionEvent.getRawX() - this.wC));
                this.MGA.put("offset_y", String.valueOf(motionEvent.getRawY() - this.FC));
                this.MGA.put("url", String.valueOf(getUrl()));
                this.MGA.put("tag", "");
                this.du = System.currentTimeMillis();
                if (this.nn != null) {
                    this.FS = this.du;
                }
                this.MGA.put("down_time", this.aAs);
                this.MGA.put("up_time", this.du);
                if (com.bytedance.sdk.component.FC.eli.eli.eli().DbA() != null) {
                    long j = this.nlS;
                    long j2 = this.aAs;
                    if (j != j2) {
                        this.nlS = j2;
                        com.bytedance.sdk.component.FC.eli.eli.eli().DbA().eli(this.aGH, this.ui, "in_web_click", this.MGA, this.du - this.aAs);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setShakeValue(float f) {
        this.ujq = f;
    }

    public void setDeepShakeValue(float f) {
        this.Ue = f;
    }

    public void setWriggleValue(float f) {
        this.KM = f;
    }

    public void setCalculationMethod(int i) {
        this.VM = i;
    }

    public void setOnShakeListener(DbA dbA) {
        this.GB = dbA;
    }

    public static class eli extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(final WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (webView == null) {
                return true;
            }
            webView.post(new Runnable() { // from class: com.bytedance.sdk.component.FC.MGA.eli.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ViewGroup viewGroup = (ViewGroup) webView.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(webView);
                        }
                        webView.destroy();
                    } catch (Exception unused) {
                    }
                }
            });
            return true;
        }
    }
}
