package com.bytedance.sdk.openadsdk.core.model;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.aGH.Os;
import com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity;
import com.bytedance.sdk.openadsdk.core.cyF;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class Xb implements Handler.Callback {
    private com.bytedance.sdk.openadsdk.core.widget.dV BDs;
    private AtomicBoolean BH;
    private com.bytedance.sdk.openadsdk.core.qj CMM;
    private final View Cp;
    FrameLayout DbA;
    private Handler Dfc;
    ObjectAnimator FC;
    private boolean FS;
    private DbA GMY;
    private View KM;
    RelativeLayout MGA;
    com.bytedance.sdk.openadsdk.core.DbA.eli NU;
    TextView Os;
    private int QI;
    private TextView QX;
    private boolean SSo;
    private int TfR;
    private ImageView Ue;
    private long VM;
    private FrameLayout Vy;
    private com.bytedance.sdk.openadsdk.core.widget.dV Xb;
    private FrameLayout Yw;
    private String Za;
    ValueAnimator aAs;
    FrameLayout aGH;
    private View aqO;
    private TextView bf;
    private int cyF;
    private View dV;
    private com.bytedance.sdk.openadsdk.aGH.nlS dZ;
    ObjectAnimator du;
    private com.bytedance.sdk.openadsdk.QX.eli.eli.MGA eU;
    ImageView eli;
    private com.bytedance.sdk.component.FC.MGA ev;
    private com.bytedance.sdk.openadsdk.common.nlS gG;
    private LinearLayout.LayoutParams gHb;
    private ILoader ikX;
    private com.bytedance.sdk.openadsdk.core.widget.eli.ui jh;
    final ev kb;
    private com.bytedance.sdk.openadsdk.common.aGH mm;
    private TextView nGm;
    Os.eli nlS;
    com.bytedance.sdk.openadsdk.core.DbA.DbA nn;
    private final com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA nro;
    private final Activity oWW;
    private com.bytedance.sdk.openadsdk.core.ui.aGH oc;
    private String qj;
    private ValueAnimator rH;
    private com.bytedance.sdk.openadsdk.core.wC.Xb rQ;
    private com.bytedance.sdk.openadsdk.core.ui.wC tLO;
    View ui;
    private View ujq;
    FrameLayout wC;
    private final AtomicBoolean GB = new AtomicBoolean(false);
    private final AtomicBoolean Uv = new AtomicBoolean(false);
    private volatile int tGZ = 0;
    private volatile int WfR = 0;
    private volatile int ow = 0;
    private float qyC = -1.0f;
    private final AtomicBoolean Mc = new AtomicBoolean(false);
    private long DE = -1;
    private final AtomicBoolean eEH = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public boolean DbA(int i) {
        return i == 1 || i == 2 || i == 4 || i == 5;
    }

    static /* synthetic */ int Dfc(Xb xb) {
        int i = xb.ow;
        xb.ow = i + 1;
        return i;
    }

    static /* synthetic */ int nlS(Xb xb) {
        int i = xb.tGZ;
        xb.tGZ = i + 1;
        return i;
    }

    static /* synthetic */ int nn(Xb xb) {
        int i = xb.WfR;
        xb.WfR = i + 1;
        return i;
    }

    public Xb(Activity activity, final ev evVar, String str, FrameLayout frameLayout, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA, View view) {
        this.oWW = activity;
        this.kb = evVar;
        this.qj = str;
        this.nro = dbA;
        this.Cp = view;
        this.cyF = dZ.eli(str);
        if (evVar != null) {
            this.Za = evVar.QxD();
        }
        if (!TextUtils.isEmpty(this.Za)) {
            this.ikX = com.bytedance.sdk.openadsdk.kb.DbA.eli().DbA();
            int eli2 = com.bytedance.sdk.openadsdk.kb.DbA.eli().eli(this.ikX, this.Za);
            this.TfR = eli2;
            this.QI = eli2 > 0 ? 2 : 0;
        }
        boolean aGH = aGH(evVar);
        boolean ui = ui(evVar);
        boolean DbA2 = DbA(evVar);
        if (DbA2) {
            this.qj = "landingpage_split_screen";
        } else if (aGH) {
            this.qj = "landingpage_direct";
        } else if (ui) {
            this.qj = "aggregate_page";
        } else if (Os(evVar)) {
            this.qj = "landingpage_split_ceiling";
        }
        this.NU = new com.bytedance.sdk.openadsdk.core.DbA.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), evVar, this.qj, dZ.eli(str));
        HashMap hashMap = new HashMap();
        hashMap.put("click_scence", 1);
        this.NU.eli(hashMap);
        View findViewById = activity.findViewById(R.id.content);
        this.NU.eli(findViewById);
        com.bytedance.sdk.openadsdk.core.DbA.DbA dbA2 = new com.bytedance.sdk.openadsdk.core.DbA.DbA(activity, evVar, this.qj, dZ.eli(str), true) { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.1
            @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA
            public boolean eli(nlS nls, Map<String, Object> map) {
                if (Xb.wC(evVar) && Xb.this.jh != null) {
                    Xb.this.jh.eli(nls);
                    Xb.this.jh.eli(map);
                    if (Xb.kb(Xb.this.kb) || Xb.this.FS) {
                        return true;
                    }
                }
                return super.eli(nls, map);
            }
        };
        this.nn = dbA2;
        dbA2.eli(hashMap);
        this.nn.eli(findViewById);
        this.wC = frameLayout;
        if (DbA2 || aGH || ui) {
            try {
                this.Dfc = new Handler(Looper.getMainLooper(), this);
            } catch (Exception e) {
                Log.e("LandingPageModel", "LandingPageModel: ", e);
                return;
            }
        }
        if (!aGH && !ui) {
            return;
        }
        Handler handler = this.Dfc;
        handler.sendMessage(handler.obtainMessage(100, 0, 0));
    }

    public void eli(Os.eli eliVar) {
        this.nlS = eliVar;
    }

    public void eli() {
        long eli2;
        View view;
        Long valueOf = Long.valueOf(SystemClock.elapsedRealtime());
        com.bytedance.sdk.component.FC.MGA mga = (com.bytedance.sdk.component.FC.MGA) this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.bf);
        this.ev = mga;
        if (mga != null && !ev.eli(this.kb)) {
            if (!this.ev.l_()) {
                this.ev.ui();
            }
        } else {
            SSo.eli((View) this.ev, 8);
        }
        this.Vy = (FrameLayout) this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.Xb);
        this.gG = (com.bytedance.sdk.openadsdk.common.nlS) this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.gG);
        this.ujq = this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.CMM);
        this.Ue = (ImageView) this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.ev);
        this.KM = this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.nro);
        this.DbA = (FrameLayout) this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.nGm);
        this.eli = (ImageView) this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.QX);
        this.MGA = (RelativeLayout) this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.Vy);
        this.Os = (TextView) this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.fnE);
        this.aGH = (FrameLayout) this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.aAs);
        View findViewById = this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.ujq);
        this.aqO = findViewById;
        if (findViewById == null) {
            this.aqO = this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.cyF);
        }
        this.dV = this.oWW.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.Ue);
        this.nGm = (TextView) this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.VM);
        this.QX = (TextView) this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.GB);
        this.Xb = (com.bytedance.sdk.openadsdk.core.widget.dV) this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.KM);
        this.bf = (TextView) this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.oWW);
        if (this.Os != null && this.kb.QX() != null) {
            this.Os.setText(this.kb.QX().ui());
        }
        this.ui = this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.qj);
        this.oc = (com.bytedance.sdk.openadsdk.core.ui.aGH) this.Cp.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.ikx);
        if ((aGH(this.kb) || DbA(this.kb) || ui(this.kb) || Os(this.kb)) && this.kb.QX() != null) {
            View view2 = this.ui;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (ui(this.kb)) {
                eli2 = this.kb.QX().Os();
            } else {
                eli2 = this.kb.QX().eli();
            }
            com.bytedance.sdk.openadsdk.core.nn.Os().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.11
                @Override // java.lang.Runnable
                public void run() {
                    if (Xb.this.GB.get()) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(Xb.this.kb, Xb.this.qj, System.currentTimeMillis() - Xb.this.VM, false);
                    Xb.this.Dfc();
                }
            }, eli2 * 1000);
        }
        du();
        if (DbA(this.kb)) {
            nGm();
            if (!aGH()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Vy.getLayoutParams();
                layoutParams.weight = 2.33f;
                this.Vy.setLayoutParams(layoutParams);
            }
        }
        if ((aGH(this.kb) || ui(this.kb)) && (view = this.KM) != null) {
            view.setVisibility(8);
        }
        com.bytedance.sdk.openadsdk.common.nlS nls = this.gG;
        if (nls != null) {
            nls.eli(this.kb);
        }
        if (Os(this.kb)) {
            dV();
        }
        Os.eli.eli(SystemClock.elapsedRealtime() - valueOf.longValue(), this.kb, this.qj, this.ikX, this.Za);
    }

    private void du() {
        Xb xb;
        com.bytedance.sdk.component.FC.MGA mga = this.ev;
        if (mga == null || mga.getWebView() == null) {
            xb = this;
        } else {
            com.bytedance.sdk.openadsdk.core.widget.eli.Os.eli(com.bytedance.sdk.openadsdk.core.dV.eli()).eli(false).DbA(false).eli(this.ev.getWebView());
            com.bytedance.sdk.component.FC.MGA mga2 = this.ev;
            if (mga2 != null && mga2.getWebView() != null) {
                this.GMY = new DbA(this.TfR, this.kb, this.qj, this);
                if (this.ev.l_() && (this.ev.getWebViewClient() instanceof com.bytedance.sdk.openadsdk.core.widget.eli.ui)) {
                    com.bytedance.sdk.openadsdk.aGH.nlS DbA2 = ((com.bytedance.sdk.openadsdk.core.widget.eli.ui) this.ev.getWebViewClient()).DbA();
                    this.dZ = DbA2;
                    if (DbA2 != null) {
                        DbA2.eli(this.GMY);
                        this.dZ.DbA(true);
                    }
                } else {
                    this.dZ = new com.bytedance.sdk.openadsdk.aGH.nlS(this.kb, this.ev.getWebView(), this.GMY, this.QI).DbA(true);
                }
                this.dZ.eli(this.qj);
                com.bytedance.sdk.openadsdk.common.aGH eli2 = dZ.eli(this.kb, this.ev, this.oWW, this.qj);
                this.mm = eli2;
                if (eli2 != null) {
                    eli2.eli(this.qj);
                }
                dZ.eli(this.kb, this.ev);
            }
            nlS();
            if (this.ev.l_()) {
                Xb();
            }
            this.ev.setLandingPage(true);
            this.ev.setTag(this.qj);
            this.ev.setMaterialMeta(this.kb.sO());
            xb = this;
            com.bytedance.sdk.openadsdk.core.widget.eli.ui uiVar = new com.bytedance.sdk.openadsdk.core.widget.eli.ui(com.bytedance.sdk.openadsdk.core.dV.eli(), this.CMM, this.kb.umh(), this.mm, this.dZ, true) { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.12
                @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    if (Xb.Os(Xb.this.kb) && dZ.eli(webView) == 1) {
                        Intent intent = new Intent(Xb.this.oWW, (Class<?>) TTCeilingLandingPageActivity.class);
                        Xb.this.kb.ui(str);
                        intent.putExtra("meta_index", com.bytedance.sdk.openadsdk.core.Ue.eli().eli(Xb.this.kb));
                        com.bytedance.sdk.component.utils.DbA.eli(this.ui, intent, null);
                        return true;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    Xb.this.NU();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    super.onPageStarted(webView, str, bitmap);
                    Xb.this.nro.aqO();
                    Xb.this.VM = System.currentTimeMillis();
                    if (!Xb.DbA(Xb.this.kb) || Xb.this.Dfc == null || ev.ui(Xb.this.kb)) {
                        return;
                    }
                    Xb.this.Dfc.sendEmptyMessageDelayed(101, 2000L);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    super.onReceivedError(webView, i, str, str2);
                    String aGH = aGH(str2);
                    if (this.kb != null) {
                        this.kb.eli(webView, i, str, str2, aGH(str2), (webView == null || str2 == null || !str2.equals(webView.getUrl())) ? false : true);
                    }
                    boolean z = aGH != null && aGH.startsWith("image");
                    boolean z2 = aGH != null && aGH.startsWith("mp4");
                    if (z || z2 || Xb.this.GB.get()) {
                        return;
                    }
                    Xb.this.Dfc();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    if (sslErrorHandler != null) {
                        Xb.this.Dfc();
                    }
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    try {
                        if (TextUtils.isEmpty(Xb.this.Za)) {
                            return super.shouldInterceptRequest(webView, str);
                        }
                        Xb.nlS(Xb.this);
                        WebResourceResponseModel eli3 = com.bytedance.sdk.openadsdk.kb.DbA.eli().eli(Xb.this.ikX, Xb.this.Za, str);
                        if (eli3 != null && eli3.getWebResourceResponse() != null) {
                            Xb.nn(Xb.this);
                            return eli3.getWebResourceResponse();
                        }
                        if (eli3 != null && eli3.getMsg() == 2) {
                            Xb.Dfc(Xb.this);
                        }
                        return super.shouldInterceptRequest(webView, str);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.Xb.eli("LandingPageModel", "shouldInterceptRequest url error", th);
                        return super.shouldInterceptRequest(webView, str);
                    }
                }
            };
            xb.jh = uiVar;
            xb.ev.setWebViewClient(uiVar);
            xb.jh.eli(xb.kb);
            xb.jh.eli(xb.qj);
            xb.jh.eli(xb.nro);
            xb.ev.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.eli.aGH(xb.CMM, xb.dZ, xb.mm) { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.13
                @Override // com.bytedance.sdk.openadsdk.core.widget.eli.aGH, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    if (Xb.this.oWW != null && !Xb.this.oWW.isFinishing() && i == 100) {
                        Xb.this.NU();
                    }
                    if (Xb.this.gG != null) {
                        Xb.this.gG.eli(i);
                    }
                }
            });
            if (xb.eU == null) {
                xb.eU = com.bytedance.sdk.openadsdk.QX.eli.eli.kb.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), xb.qj);
            }
            xb.ev.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.14
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (Xb.this.eU != null) {
                        Xb.this.eU.Os(Xb.this.kb);
                    }
                }
            });
            com.bytedance.sdk.component.FC.MGA mga3 = xb.ev;
            mga3.setUserAgentString(com.bytedance.sdk.openadsdk.utils.QX.eli(mga3.getWebView(), BuildConfig.VERSION_CODE));
            xb.ev.setMixedContentMode(0);
            xb.ev.getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.15
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    if (Xb.this.dZ != null) {
                        Xb.this.dZ.DbA(i2);
                    }
                }
            });
            xb.ev.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.16
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (Xb.this.FC()) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            Xb.this.qyC = motionEvent.getY();
                        } else if (action == 1) {
                            if (SSo.eli(Xb.this.qyC, motionEvent.getY(), Xb.this.oWW)) {
                                Xb.this.eli(5);
                            }
                        } else if (action == 2) {
                            motionEvent.setAction(3);
                        }
                    }
                    if ((!Xb.this.FS || Xb.wC(Xb.this.kb)) && !Xb.ui(Xb.this.kb)) {
                        Xb.this.nn.onTouch(view, motionEvent);
                    }
                    if ((!Xb.this.FS || Xb.wC(Xb.this.kb)) && !Xb.ui(Xb.this.kb) && motionEvent.getAction() == 1 && Xb.this.nn.kb()) {
                        Xb.this.ev.getWebView().performClick();
                        Xb.this.FS = true;
                    }
                    if (Xb.this.dZ != null) {
                        Xb.this.dZ.eli(motionEvent);
                    }
                    if (Xb.this.mm == null) {
                        return false;
                    }
                    Xb.this.mm.eli(motionEvent);
                    return false;
                }
            });
            xb.ev.getWebView().setOnClickListener(xb.nn);
            com.bytedance.sdk.openadsdk.aGH.Os.eli(xb.kb, xb.qj, xb.QI);
            if (!xb.ev.l_()) {
                com.bytedance.sdk.openadsdk.utils.bf.eli(xb.ev, xb.kb.dM());
            }
            xb.SSo = true;
        }
        com.bytedance.sdk.component.FC.MGA mga4 = xb.ev;
        if (mga4 == null || xb.gG == null || mga4.Os()) {
            return;
        }
        xb.gG.eli();
    }

    public static class DbA implements com.bytedance.sdk.openadsdk.aGH.du {
        private final ev DbA;
        private final String Os;
        private final WeakReference<Xb> aGH;
        private final int eli;

        public DbA(int i, ev evVar, String str, Xb xb) {
            this.eli = i;
            this.DbA = evVar;
            this.Os = str;
            this.aGH = new WeakReference<>(xb);
        }

        @Override // com.bytedance.sdk.openadsdk.aGH.du
        public void eli(int i) {
            Xb xb = this.aGH.get();
            if (xb != null) {
                Os.eli.eli(this.eli, xb.ow, xb.WfR, xb.tGZ - xb.WfR, this.DbA, this.Os, i);
            }
        }
    }

    private void nlS() {
        com.bytedance.sdk.openadsdk.core.qj qjVar = new com.bytedance.sdk.openadsdk.core.qj(this.oWW);
        this.CMM = qjVar;
        qjVar.eli(this.nro);
        this.CMM.DbA(this.ev).eli(com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli(this.kb)).Os(this.kb.umh()).aGH(this.kb.eu()).eli(this.kb).DbA(ui(this.kb) ? this.cyF : -1).eli(this.kb.ND()).DbA(this.qj).ui(this.kb.WA()).eli(this.ev).eli(new com.bytedance.sdk.openadsdk.core.widget.ui() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.17
            @Override // com.bytedance.sdk.openadsdk.core.widget.ui
            public void eli() {
                if (!Xb.ui(Xb.this.kb) || !(Xb.this.oWW instanceof com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA)) {
                    if (Xb.this.jh != null) {
                        Xb.this.jh.Os();
                        return;
                    }
                    return;
                }
                ((com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA) Xb.this.oWW).e_();
            }
        });
    }

    public static boolean eli(ev evVar) {
        if (evVar == null || FC(evVar)) {
            return false;
        }
        return aGH(evVar) || DbA(evVar) || ui(evVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NU() {
        if (this.GB.get() || this.Uv.get()) {
            return;
        }
        this.GB.set(true);
        long elapsedRealtime = this.DE == -1 ? 0L : SystemClock.elapsedRealtime() - this.DE;
        if (Os(this.kb)) {
            com.bytedance.sdk.openadsdk.aGH.Os.Os(this.kb, this.qj, elapsedRealtime);
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(this.kb, this.qj, System.currentTimeMillis() - this.VM, true);
        nn();
    }

    private void nn() {
        this.MGA.setVisibility(8);
        if (aGH(this.kb) || ui(this.kb) || !aGH() || Os(this.kb)) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "timeVisible", 0.0f, 1.0f);
        this.du = ofFloat;
        ofFloat.setDuration(100L);
        this.du.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.18
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) Xb.this.Vy.getLayoutParams();
                layoutParams.weight = (float) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 0.25d);
                Xb.this.eli((float) (1.0d - (((Float) valueAnimator.getAnimatedValue()).floatValue() * 0.2d)));
                Xb.this.Vy.setLayoutParams(layoutParams);
            }
        });
        this.du.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dfc() {
        LinearLayout.LayoutParams layoutParams;
        if (this.GB.get()) {
            return;
        }
        aqO();
        this.Uv.set(true);
        this.nro.du();
        com.bytedance.sdk.openadsdk.common.nlS nls = this.gG;
        if (nls != null) {
            nls.DbA();
        }
        if (ui(this.kb)) {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), this.kb, this.qj, "show_agg_backup");
            View view = this.dV;
            if (view != null) {
                view.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dV.getLayoutParams();
                layoutParams2.addRule(13);
                layoutParams2.addRule(10, 0);
                this.dV.setLayoutParams(layoutParams2);
                RelativeLayout relativeLayout = this.MGA;
                if (relativeLayout != null) {
                    relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        this.aqO.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.aqO.getLayoutParams();
        layoutParams3.addRule(13);
        layoutParams3.addRule(10, 0);
        this.aqO.setLayoutParams(layoutParams3);
        if (this.kb.SjY() != null && !TextUtils.isEmpty(this.kb.SjY().eli())) {
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.kb.SjY().eli(), this.kb.SjY().DbA(), this.kb.SjY().Os(), this.Xb, this.kb);
        }
        this.nGm.setText(this.kb.kEI());
        this.QX.setText(this.kb.bU());
        if (this.bf != null) {
            DbA();
            this.bf.setClickable(true);
            this.bf.setOnClickListener(this.NU);
            this.bf.setOnTouchListener(this.NU);
        }
        if (!Os(this.kb) || (layoutParams = this.gHb) == null) {
            return;
        }
        if (layoutParams.weight < 30.0f) {
            Os(8);
        } else {
            Os(0);
        }
    }

    private void aqO() {
        if ((aGH(this.kb) || ui(this.kb)) && (this.oWW instanceof com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA)) {
            this.nro.aqO();
            this.nro.dV();
        }
    }

    protected void DbA() {
        ev evVar = this.kb;
        if (evVar == null || TextUtils.isEmpty(evVar.GMu())) {
            return;
        }
        this.bf.setText(this.kb.GMu());
    }

    private void dV() {
        com.bytedance.sdk.openadsdk.common.du loadingStyle;
        com.bytedance.sdk.openadsdk.common.nlS nls = this.gG;
        if (nls != null && (loadingStyle = nls.getLoadingStyle()) != null) {
            this.BDs = loadingStyle.DbA();
            this.tLO = loadingStyle.Os();
        }
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = this.oc;
        if (agh != null) {
            agh.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (Xb.this.oc.getTag() != null) {
                        if (!Xb.this.oc.getTag().equals(1)) {
                            if (Xb.this.oc.getTag().equals(2)) {
                                Xb.this.eli(4);
                                return;
                            }
                            return;
                        }
                        Xb.this.eli(3);
                    }
                }
            });
        }
    }

    public void Os() {
        if (QX()) {
            try {
                String aAs = this.kb.nY().aAs();
                com.bytedance.sdk.openadsdk.FC.aGH.eli().eli(aAs).eli(this.kb.nY().Os()).DbA(this.kb.nY().DbA()).ui(SSo.ui(com.bytedance.sdk.openadsdk.core.dV.eli())).aGH(SSo.Os(com.bytedance.sdk.openadsdk.core.dV.eli())).Os(2).eli(new eli()).eli(new com.bytedance.sdk.openadsdk.FC.DbA(this.kb, aAs, new com.bytedance.sdk.component.ui.aqO() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.4
                    @Override // com.bytedance.sdk.component.ui.aqO
                    public void eli(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.ui.aqO
                    public void eli(com.bytedance.sdk.component.ui.du duVar) {
                        try {
                            Object DbA2 = duVar.DbA();
                            if (DbA2 != null && duVar.Os() != null) {
                                BitmapDrawable bitmapDrawable = DbA2 instanceof Bitmap ? new BitmapDrawable(com.bytedance.sdk.openadsdk.core.dV.eli().getResources(), (Bitmap) DbA2) : null;
                                View Dfc = Xb.this.nro.Dfc();
                                if (bitmapDrawable == null || Dfc == null || !(Dfc.getParent() instanceof View)) {
                                    return;
                                }
                                View view = (View) Dfc.getParent();
                                View view2 = view;
                                view.setBackground(bitmapDrawable);
                            }
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.Xb.Os("LandingPageModel", th.getMessage());
                        }
                    }
                }));
            } catch (Exception unused) {
            }
        }
    }

    private void nGm() {
        if (aGH()) {
            this.ujq.setVisibility(0);
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.Ue, "translationY", 16.0f, 0.0f).setDuration(500L);
            this.FC = duration;
            duration.setRepeatMode(2);
            this.FC.setRepeatCount(-1);
            this.FC.start();
            this.ujq.setClickable(true);
            this.ujq.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!Xb.this.FS) {
                        Xb.this.nn.onTouch(view, motionEvent);
                    }
                    if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
                        return false;
                    }
                    Xb.this.aAs = ObjectAnimator.ofFloat(this, "timeSlide", 0.0f, 1.0f);
                    Xb.this.aAs.setDuration(200L);
                    Xb.this.aAs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.5.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) Xb.this.Vy.getLayoutParams();
                            layoutParams.weight = (float) ((((Float) valueAnimator.getAnimatedValue()).floatValue() * 2.07f) + 0.25d);
                            Xb.this.eli((float) (0.800000011920929d - (((Float) valueAnimator.getAnimatedValue()).floatValue() * 0.5d)));
                            Xb.this.Vy.setLayoutParams(layoutParams);
                        }
                    });
                    if (Xb.this.nn.kb()) {
                        Xb.this.ujq.performClick();
                        Xb.this.FS = true;
                    }
                    Xb.this.aAs.start();
                    Xb.this.ujq.setVisibility(8);
                    return true;
                }
            });
            this.ujq.setOnClickListener(this.nn);
        }
        if (!QX()) {
            this.wC.setVisibility(8);
            this.DbA.setVisibility(0);
            this.eli.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.eli.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.bytedance.sdk.openadsdk.aGH.Os.DbA(Xb.this.kb, Xb.this.qj);
                }
            });
            ev evVar = this.kb;
            if (evVar != null && evVar.an() != null && this.kb.an().size() > 0 && this.kb.an().get(0) != null && !TextUtils.isEmpty(this.kb.an().get(0).eli())) {
                com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.kb.an().get(0), this.eli, this.kb, new com.bytedance.sdk.component.ui.aqO() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.7
                    @Override // com.bytedance.sdk.component.ui.aqO
                    public void eli(com.bytedance.sdk.component.ui.du duVar) {
                        if (Xb.this.Dfc != null) {
                            Xb.this.Dfc.removeMessages(101);
                        }
                    }

                    @Override // com.bytedance.sdk.component.ui.aqO
                    public void eli(int i, String str, Throwable th) {
                        if (Xb.this.Dfc != null) {
                            Xb.this.Dfc.removeMessages(101);
                        }
                        Xb.this.aAs();
                    }
                });
            }
        }
        try {
            String eli2 = this.kb.an().get(0).eli();
            com.bytedance.sdk.openadsdk.FC.aGH.eli().eli(eli2).eli(this.kb.an().get(0).DbA()).DbA(this.kb.an().get(0).Os()).ui(SSo.ui(com.bytedance.sdk.openadsdk.core.dV.eli())).aGH(SSo.Os(com.bytedance.sdk.openadsdk.core.dV.eli())).Os(1).eli(new eli()).eli(new com.bytedance.sdk.openadsdk.FC.DbA(this.kb, eli2, new com.bytedance.sdk.component.ui.aqO() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.8
                @Override // com.bytedance.sdk.component.ui.aqO
                public void eli(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.ui.aqO
                public void eli(com.bytedance.sdk.component.ui.du duVar) {
                    Drawable drawable;
                    try {
                        Object DbA2 = duVar.DbA();
                        if (DbA2 != null && duVar.Os() != null) {
                            if (DbA2 instanceof Bitmap) {
                                drawable = new BitmapDrawable(com.bytedance.sdk.openadsdk.core.dV.eli().getResources(), (Bitmap) DbA2);
                            } else if (DbA2 instanceof Drawable) {
                                if (DbA2 instanceof AnimatedImageDrawable) {
                                    ((AnimatedImageDrawable) DbA2).start();
                                }
                                drawable = (Drawable) DbA2;
                            } else {
                                drawable = null;
                            }
                            if (!Xb.this.QX()) {
                                Xb.this.DbA.setBackground(drawable);
                                return;
                            }
                            Xb.this.aGH.setBackground(drawable);
                            View Dfc = Xb.this.nro.Dfc();
                            if (Dfc == null || !(Dfc.getParent() instanceof View)) {
                                return;
                            }
                            View view = (View) Dfc.getParent();
                            View view2 = view;
                            view.setBackground(drawable);
                        }
                    } catch (Exception unused) {
                    }
                }
            }));
        } catch (Exception unused) {
        }
    }

    private static class eli implements com.bytedance.sdk.component.ui.wC {
        @Override // com.bytedance.sdk.component.ui.wC
        public Bitmap eli(Bitmap bitmap) {
            return com.bytedance.sdk.component.adexpress.aGH.eli.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), bitmap, 25);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean QX() {
        return ev.ui(this.kb);
    }

    public boolean aGH() {
        return this.kb.GR() == 15 || this.kb.GR() == 16;
    }

    public void eli(float f) {
        try {
            this.nro.nn();
        } catch (Throwable unused) {
        }
    }

    public static boolean DbA(ev evVar) {
        return evVar != null && evVar.yw() == 3 && evVar.mm() == 6 && !KM.DbA(evVar) && evVar.WO() == 1 && (evVar.Nvn() == 0.0f || evVar.Nvn() == 100.0f);
    }

    public static boolean Os(ev evVar) {
        return evVar != null && evVar.yw() == 3 && evVar.oc() == 38 && evVar.WO() == 1;
    }

    public static boolean aGH(ev evVar) {
        if (evVar == null) {
            return false;
        }
        if (FC(evVar)) {
            return true;
        }
        return evVar.yw() == 3 && evVar.mm() == 5 && !KM.DbA(evVar) && (evVar.Nvn() == 0.0f || evVar.Nvn() == 100.0f);
    }

    public static boolean ui(ev evVar) {
        return evVar != null && evVar.mm() == 33;
    }

    public static boolean MGA(ev evVar) {
        return aGH(evVar) && !FC(evVar);
    }

    public static boolean kb(ev evVar) {
        return (evVar == null || evVar.tl() == 1 || !wC(evVar)) ? false : true;
    }

    public static boolean wC(ev evVar) {
        if (evVar != null) {
            return evVar.mm() == 19 || evVar.mm() == 20;
        }
        return false;
    }

    public static boolean FC(ev evVar) {
        return evVar != null && evVar.mm() == 19;
    }

    public static boolean aAs(ev evVar) {
        return (evVar == null || !com.bytedance.sdk.openadsdk.core.dV.aGH().QX() || !evVar.XxP() || DbA(evVar) || aGH(evVar) || ui(evVar)) ? false : true;
    }

    public void ui() {
        FrameLayout frameLayout = this.Vy;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            View view = this.KM;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public void MGA() {
        com.bytedance.sdk.component.FC.MGA mga;
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.dZ;
        if (nls != null && (mga = this.ev) != null) {
            nls.eli(mga);
        }
        Handler handler = this.Dfc;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ValueAnimator valueAnimator = this.rH;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.rH.cancel();
        }
        ValueAnimator valueAnimator2 = this.aAs;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.aAs.cancel();
        }
        ObjectAnimator objectAnimator = this.du;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.du.cancel();
        }
        com.bytedance.sdk.openadsdk.common.nlS nls2 = this.gG;
        if (nls2 != null) {
            nls2.DbA();
        }
        ObjectAnimator objectAnimator2 = this.FC;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        com.bytedance.sdk.component.FC.MGA mga2 = this.ev;
        if (mga2 != null) {
            cyF.eli(mga2.getWebView());
        }
        this.ev = null;
        com.bytedance.sdk.openadsdk.core.qj qjVar = this.CMM;
        if (qjVar != null) {
            qjVar.nlS();
        }
        com.bytedance.sdk.openadsdk.aGH.nlS nls3 = this.dZ;
        if (nls3 != null) {
            nls3.aGH(true);
        }
        if (!TextUtils.isEmpty(this.Za) && this.SSo) {
            Os.eli.eli(this.WfR, this.tGZ, this.kb);
        }
        com.bytedance.sdk.openadsdk.kb.DbA.eli().eli(this.ikX);
    }

    public void kb() {
        com.bytedance.sdk.openadsdk.core.qj qjVar = this.CMM;
        if (qjVar != null) {
            qjVar.du();
        }
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.dZ;
        if (nls != null) {
            nls.kb();
        }
    }

    public void wC() {
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.dZ;
        if (nls != null) {
            nls.wC();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        long aGH;
        ev evVar;
        ev evVar2;
        if (message.what == 100) {
            int i = message.arg1;
            if (aGH(this.kb) && (evVar2 = this.kb) != null && evVar2.QX() != null) {
                aGH = this.kb.QX().DbA();
            } else {
                aGH = (!ui(this.kb) || (evVar = this.kb) == null || evVar.QX() == null) ? 20L : this.kb.QX().aGH();
            }
            Os.eli eliVar = this.nlS;
            if (eliVar != null) {
                eliVar.eli(i * 1000, aGH * 1000);
            }
            long j = i;
            if (j >= aGH) {
                Os.eli eliVar2 = this.nlS;
                if (eliVar2 != null) {
                    eliVar2.eli(aGH * 1000, 100);
                }
            } else if (j < aGH && this.Dfc != null) {
                Message obtain = Message.obtain();
                obtain.what = 100;
                obtain.arg1 = i + 1;
                this.Dfc.sendMessageDelayed(obtain, 1000L);
            }
        } else if (message.what == 101) {
            aAs();
        }
        return true;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.wC.Xb xb, FrameLayout frameLayout) {
        this.rQ = xb;
        this.Yw = frameLayout;
    }

    public boolean FC() {
        AtomicBoolean atomicBoolean;
        return (!Os(this.kb) || (atomicBoolean = this.BH) == null || atomicBoolean.get()) ? false : true;
    }

    public void eli(int i) {
        com.bytedance.sdk.openadsdk.core.wC.Xb xb = this.rQ;
        if (xb != null) {
            xb.ui(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eli(final int i, com.bytedance.sdk.component.adexpress.DbA.nn nnVar) {
        float f;
        int MGA;
        FrameLayout.LayoutParams layoutParams;
        com.bytedance.sdk.openadsdk.aGH.nlS nls;
        if ((i != 3 && !DbA(i)) || this.Yw == null || nnVar == null) {
            return;
        }
        AtomicBoolean atomicBoolean = this.BH;
        if (atomicBoolean != null) {
            if (i == 1) {
                return;
            }
            if (i == 5 && atomicBoolean.get()) {
                return;
            }
        }
        final LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.KM.getLayoutParams();
        this.gHb = (LinearLayout.LayoutParams) this.Vy.getLayoutParams();
        final float f2 = layoutParams2.weight;
        QX bf = this.kb.bf();
        if (!DbA(i)) {
            if (bf != null) {
                MGA = bf.MGA();
                f = MGA;
                final float f3 = f;
                new Object[]{"expressStartWeight is :", Float.valueOf(f2), "expressEndWeight is:", Float.valueOf(f3)};
                layoutParams = (FrameLayout.LayoutParams) this.Yw.getLayoutParams();
                if (layoutParams == null) {
                }
                final FrameLayout.LayoutParams layoutParams3 = layoutParams;
                final int i2 = layoutParams3.height;
                final int i3 = layoutParams3.width;
                final int i4 = layoutParams3.leftMargin;
                final int i5 = layoutParams3.topMargin;
                final int DbA2 = SSo.DbA(this.oWW, (float) nnVar.kb());
                final int DbA3 = SSo.DbA(this.oWW, (float) nnVar.wC());
                final int DbA4 = SSo.DbA(this.oWW, (float) nnVar.ui());
                final int DbA5 = SSo.DbA(this.oWW, (float) nnVar.MGA());
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.aAs = ofFloat;
                ofFloat.setDuration(500L);
                this.aAs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.9
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        LinearLayout.LayoutParams layoutParams4 = layoutParams2;
                        float f4 = f2;
                        layoutParams4.weight = f4 + ((f3 - f4) * floatValue);
                        Xb.this.gHb.weight = 100.0f - layoutParams2.weight;
                        if (Xb.this.KM != null) {
                            Xb.this.KM.setLayoutParams(layoutParams2);
                        }
                        if (Xb.this.Vy != null) {
                            Xb.this.Vy.setLayoutParams(Xb.this.gHb);
                        }
                        if (Xb.this.gHb.weight < 30.0f) {
                            Xb.this.Os(8);
                        } else {
                            Xb.this.Os(0);
                        }
                        layoutParams3.width = i3 + ((int) ((DbA2 - r2) * floatValue));
                        layoutParams3.height = i2 + ((int) ((DbA3 - r2) * floatValue));
                        layoutParams3.leftMargin = i4 + ((int) ((DbA4 - r2) * floatValue));
                        layoutParams3.topMargin = i5 + ((int) ((DbA5 - r2) * floatValue));
                        if (Xb.this.Yw != null) {
                            Xb.this.Yw.setLayoutParams(layoutParams3);
                        }
                        Xb.this.eli(0.0f);
                        if (floatValue == 1.0f) {
                            if (Xb.this.oc != null) {
                                SSo.eli((View) Xb.this.oc, 0);
                                if (Xb.this.DbA(i)) {
                                    Xb.this.oc.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(Xb.this.oWW, "tt_ad_zoom_down"));
                                    Xb.this.oc.setTag(1);
                                } else {
                                    Xb.this.oc.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(Xb.this.oWW, "tt_ad_zoom_up"));
                                    Xb.this.oc.setTag(2);
                                }
                            }
                            if (Xb.this.BH == null) {
                                Xb.this.BH = new AtomicBoolean();
                            }
                            Xb.this.BH.set(Xb.this.DbA(i));
                        }
                    }
                });
                com.bytedance.sdk.openadsdk.aGH.Os.aGH(this.kb, this.qj, i);
                this.aAs.start();
                if (this.Mc.compareAndSet(false, true)) {
                }
                nls = this.dZ;
                if (nls != null) {
                }
                SSo.eli((View) this.oc, 8);
            }
            f = 70.0f;
            final float f32 = f;
            new Object[]{"expressStartWeight is :", Float.valueOf(f2), "expressEndWeight is:", Float.valueOf(f32)};
            layoutParams = (FrameLayout.LayoutParams) this.Yw.getLayoutParams();
            if (layoutParams == null) {
            }
            final FrameLayout.LayoutParams layoutParams32 = layoutParams;
            final int i22 = layoutParams32.height;
            final int i32 = layoutParams32.width;
            final int i42 = layoutParams32.leftMargin;
            final int i52 = layoutParams32.topMargin;
            final int DbA22 = SSo.DbA(this.oWW, (float) nnVar.kb());
            final int DbA32 = SSo.DbA(this.oWW, (float) nnVar.wC());
            final int DbA42 = SSo.DbA(this.oWW, (float) nnVar.ui());
            final int DbA52 = SSo.DbA(this.oWW, (float) nnVar.MGA());
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.aAs = ofFloat2;
            ofFloat2.setDuration(500L);
            this.aAs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.9
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LinearLayout.LayoutParams layoutParams4 = layoutParams2;
                    float f4 = f2;
                    layoutParams4.weight = f4 + ((f32 - f4) * floatValue);
                    Xb.this.gHb.weight = 100.0f - layoutParams2.weight;
                    if (Xb.this.KM != null) {
                        Xb.this.KM.setLayoutParams(layoutParams2);
                    }
                    if (Xb.this.Vy != null) {
                        Xb.this.Vy.setLayoutParams(Xb.this.gHb);
                    }
                    if (Xb.this.gHb.weight < 30.0f) {
                        Xb.this.Os(8);
                    } else {
                        Xb.this.Os(0);
                    }
                    layoutParams32.width = i32 + ((int) ((DbA22 - r2) * floatValue));
                    layoutParams32.height = i22 + ((int) ((DbA32 - r2) * floatValue));
                    layoutParams32.leftMargin = i42 + ((int) ((DbA42 - r2) * floatValue));
                    layoutParams32.topMargin = i52 + ((int) ((DbA52 - r2) * floatValue));
                    if (Xb.this.Yw != null) {
                        Xb.this.Yw.setLayoutParams(layoutParams32);
                    }
                    Xb.this.eli(0.0f);
                    if (floatValue == 1.0f) {
                        if (Xb.this.oc != null) {
                            SSo.eli((View) Xb.this.oc, 0);
                            if (Xb.this.DbA(i)) {
                                Xb.this.oc.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(Xb.this.oWW, "tt_ad_zoom_down"));
                                Xb.this.oc.setTag(1);
                            } else {
                                Xb.this.oc.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(Xb.this.oWW, "tt_ad_zoom_up"));
                                Xb.this.oc.setTag(2);
                            }
                        }
                        if (Xb.this.BH == null) {
                            Xb.this.BH = new AtomicBoolean();
                        }
                        Xb.this.BH.set(Xb.this.DbA(i));
                    }
                }
            });
            com.bytedance.sdk.openadsdk.aGH.Os.aGH(this.kb, this.qj, i);
            this.aAs.start();
            if (this.Mc.compareAndSet(false, true)) {
            }
            nls = this.dZ;
            if (nls != null) {
            }
            SSo.eli((View) this.oc, 8);
        }
        if (bf != null) {
            MGA = bf.ui();
            f = MGA;
            final float f322 = f;
            new Object[]{"expressStartWeight is :", Float.valueOf(f2), "expressEndWeight is:", Float.valueOf(f322)};
            layoutParams = (FrameLayout.LayoutParams) this.Yw.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            final FrameLayout.LayoutParams layoutParams322 = layoutParams;
            final int i222 = layoutParams322.height;
            final int i322 = layoutParams322.width;
            final int i422 = layoutParams322.leftMargin;
            final int i522 = layoutParams322.topMargin;
            final int DbA222 = SSo.DbA(this.oWW, (float) nnVar.kb());
            final int DbA322 = SSo.DbA(this.oWW, (float) nnVar.wC());
            final int DbA422 = SSo.DbA(this.oWW, (float) nnVar.ui());
            final int DbA522 = SSo.DbA(this.oWW, (float) nnVar.MGA());
            ValueAnimator ofFloat22 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.aAs = ofFloat22;
            ofFloat22.setDuration(500L);
            this.aAs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.9
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LinearLayout.LayoutParams layoutParams4 = layoutParams2;
                    float f4 = f2;
                    layoutParams4.weight = f4 + ((f322 - f4) * floatValue);
                    Xb.this.gHb.weight = 100.0f - layoutParams2.weight;
                    if (Xb.this.KM != null) {
                        Xb.this.KM.setLayoutParams(layoutParams2);
                    }
                    if (Xb.this.Vy != null) {
                        Xb.this.Vy.setLayoutParams(Xb.this.gHb);
                    }
                    if (Xb.this.gHb.weight < 30.0f) {
                        Xb.this.Os(8);
                    } else {
                        Xb.this.Os(0);
                    }
                    layoutParams322.width = i322 + ((int) ((DbA222 - r2) * floatValue));
                    layoutParams322.height = i222 + ((int) ((DbA322 - r2) * floatValue));
                    layoutParams322.leftMargin = i422 + ((int) ((DbA422 - r2) * floatValue));
                    layoutParams322.topMargin = i522 + ((int) ((DbA522 - r2) * floatValue));
                    if (Xb.this.Yw != null) {
                        Xb.this.Yw.setLayoutParams(layoutParams322);
                    }
                    Xb.this.eli(0.0f);
                    if (floatValue == 1.0f) {
                        if (Xb.this.oc != null) {
                            SSo.eli((View) Xb.this.oc, 0);
                            if (Xb.this.DbA(i)) {
                                Xb.this.oc.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(Xb.this.oWW, "tt_ad_zoom_down"));
                                Xb.this.oc.setTag(1);
                            } else {
                                Xb.this.oc.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(Xb.this.oWW, "tt_ad_zoom_up"));
                                Xb.this.oc.setTag(2);
                            }
                        }
                        if (Xb.this.BH == null) {
                            Xb.this.BH = new AtomicBoolean();
                        }
                        Xb.this.BH.set(Xb.this.DbA(i));
                    }
                }
            });
            com.bytedance.sdk.openadsdk.aGH.Os.aGH(this.kb, this.qj, i);
            this.aAs.start();
            if (this.Mc.compareAndSet(false, true)) {
                this.DE = SystemClock.elapsedRealtime();
            }
            nls = this.dZ;
            if (nls != null) {
                nls.eli(true, SystemClock.elapsedRealtime());
            }
            SSo.eli((View) this.oc, 8);
        }
        f = 30.0f;
        final float f3222 = f;
        new Object[]{"expressStartWeight is :", Float.valueOf(f2), "expressEndWeight is:", Float.valueOf(f3222)};
        layoutParams = (FrameLayout.LayoutParams) this.Yw.getLayoutParams();
        if (layoutParams == null) {
        }
        final FrameLayout.LayoutParams layoutParams3222 = layoutParams;
        final int i2222 = layoutParams3222.height;
        final int i3222 = layoutParams3222.width;
        final int i4222 = layoutParams3222.leftMargin;
        final int i5222 = layoutParams3222.topMargin;
        final int DbA2222 = SSo.DbA(this.oWW, (float) nnVar.kb());
        final int DbA3222 = SSo.DbA(this.oWW, (float) nnVar.wC());
        final int DbA4222 = SSo.DbA(this.oWW, (float) nnVar.ui());
        final int DbA5222 = SSo.DbA(this.oWW, (float) nnVar.MGA());
        ValueAnimator ofFloat222 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aAs = ofFloat222;
        ofFloat222.setDuration(500L);
        this.aAs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LinearLayout.LayoutParams layoutParams4 = layoutParams2;
                float f4 = f2;
                layoutParams4.weight = f4 + ((f3222 - f4) * floatValue);
                Xb.this.gHb.weight = 100.0f - layoutParams2.weight;
                if (Xb.this.KM != null) {
                    Xb.this.KM.setLayoutParams(layoutParams2);
                }
                if (Xb.this.Vy != null) {
                    Xb.this.Vy.setLayoutParams(Xb.this.gHb);
                }
                if (Xb.this.gHb.weight < 30.0f) {
                    Xb.this.Os(8);
                } else {
                    Xb.this.Os(0);
                }
                layoutParams3222.width = i3222 + ((int) ((DbA2222 - r2) * floatValue));
                layoutParams3222.height = i2222 + ((int) ((DbA3222 - r2) * floatValue));
                layoutParams3222.leftMargin = i4222 + ((int) ((DbA4222 - r2) * floatValue));
                layoutParams3222.topMargin = i5222 + ((int) ((DbA5222 - r2) * floatValue));
                if (Xb.this.Yw != null) {
                    Xb.this.Yw.setLayoutParams(layoutParams3222);
                }
                Xb.this.eli(0.0f);
                if (floatValue == 1.0f) {
                    if (Xb.this.oc != null) {
                        SSo.eli((View) Xb.this.oc, 0);
                        if (Xb.this.DbA(i)) {
                            Xb.this.oc.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(Xb.this.oWW, "tt_ad_zoom_down"));
                            Xb.this.oc.setTag(1);
                        } else {
                            Xb.this.oc.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(Xb.this.oWW, "tt_ad_zoom_up"));
                            Xb.this.oc.setTag(2);
                        }
                    }
                    if (Xb.this.BH == null) {
                        Xb.this.BH = new AtomicBoolean();
                    }
                    Xb.this.BH.set(Xb.this.DbA(i));
                }
            }
        });
        com.bytedance.sdk.openadsdk.aGH.Os.aGH(this.kb, this.qj, i);
        this.aAs.start();
        if (this.Mc.compareAndSet(false, true)) {
        }
        nls = this.dZ;
        if (nls != null) {
        }
        SSo.eli((View) this.oc, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os(int i) {
        SSo.eli((View) this.BDs, i);
        SSo.eli((View) this.tLO, i);
        if (this.Uv.get()) {
            SSo.eli((View) this.nGm, i);
            SSo.eli((View) this.QX, i);
            SSo.eli((View) this.Xb, i);
            SSo.eli((View) this.bf, 0);
        }
    }

    private void Xb() {
        com.bytedance.sdk.component.FC.MGA mga = this.ev;
        if (mga == null || mga.getWebView() == null) {
            return;
        }
        this.tGZ = this.ev.eli;
        this.WfR = this.ev.DbA;
        this.ow = this.ev.Os;
        if (this.ev.DbA()) {
            this.nro.aqO();
            this.VM = System.currentTimeMillis();
        }
        if (this.ev.aGH()) {
            NU();
        }
        if (this.ev.Os()) {
            NU();
            int eli2 = dZ.eli(this.ev.getWebView());
            DbA dbA = this.GMY;
            if (dbA != null) {
                dbA.eli(eli2 != 1 ? 0 : 1);
            }
        }
    }

    public void aAs() {
        if ("landingpage_split_screen".equals(this.qj) && com.bytedance.sdk.openadsdk.bf.eli.eli("default_split_style", false) && this.eEH.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.utils.cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.10
                @Override // java.lang.Runnable
                public void run() {
                    Xb.this.rH = ValueAnimator.ofFloat(1.0f, 0.0f);
                    Xb.this.rH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xb.10.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (Xb.this.KM != null) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) Xb.this.KM.getLayoutParams();
                                layoutParams.weight = floatValue;
                                Xb.this.KM.setLayoutParams(layoutParams);
                            }
                        }
                    });
                    Xb.this.rH.setDuration(500L);
                    Xb.this.rH.start();
                    if (Xb.this.ujq != null) {
                        Xb.this.ujq.setVisibility(8);
                    }
                }
            });
        }
    }
}
