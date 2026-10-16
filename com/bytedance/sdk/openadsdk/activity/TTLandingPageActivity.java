package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.aGH.Os;
import com.bytedance.sdk.openadsdk.aGH.du;
import com.bytedance.sdk.openadsdk.common.Dfc;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.common.aAs;
import com.bytedance.sdk.openadsdk.common.nlS;
import com.bytedance.sdk.openadsdk.common.nn;
import com.bytedance.sdk.openadsdk.core.Ue;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.core.widget.eli.MGA;
import com.bytedance.sdk.openadsdk.utils.FC;
import com.bytedance.sdk.openadsdk.utils.QX;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;
import com.bytedance.sdk.openadsdk.utils.bf;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TTLandingPageActivity extends TTBaseLandingPageActivity {
    private com.bytedance.sdk.openadsdk.common.aGH Cp;
    Dfc DbA;
    private String Dfc;
    private TextView FC;
    private nlS GB;
    private int KM;
    private com.bytedance.sdk.component.FC.MGA MGA;
    private com.bytedance.sdk.openadsdk.core.ui.MGA NU;
    TTAdDislikeToast Os;
    private ev QX;
    private int Ue;
    private ILoader Vy;
    private com.bytedance.sdk.openadsdk.QX.eli.eli.MGA Xb;
    private Context aAs;
    private qj aqO;
    private String bf;
    private com.bytedance.sdk.openadsdk.core.widget.eli.ui cyF;
    private int dV;
    private nn du;
    private boolean eU;
    com.bytedance.sdk.openadsdk.aGH.nlS eli;
    private String ev;
    private ImageView kb;
    private String nGm;
    private Button nlS;
    private String nn;
    private MGA.eli nro;
    private boolean oWW;
    private com.bytedance.sdk.openadsdk.utils.nn qj;
    private final AtomicBoolean CMM = new AtomicBoolean(true);
    private final AtomicInteger gG = new AtomicInteger(0);
    private final AtomicInteger ujq = new AtomicInteger(0);
    private final AtomicInteger VM = new AtomicInteger(0);
    final AtomicBoolean aGH = new AtomicBoolean(false);
    final AtomicBoolean ui = new AtomicBoolean(false);
    private String dZ = "ダウンロード";

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected boolean eli() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        eli(3);
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.nn.ui()) {
            finish();
            return;
        }
        try {
            dV.DbA(this);
        } catch (Throwable unused) {
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Intent intent = getIntent();
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            this.eU = intent.getBooleanExtra("only_loading", false);
        } else {
            ev eli2 = Ue.eli().eli(Ue.eli(intent));
            this.QX = eli2;
            if (eli2 != null) {
                this.eU = eli2.du();
            }
        }
        try {
            setContentView(aGH());
            this.bf = "";
            DbA(4);
            if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.QX = com.bytedance.sdk.openadsdk.core.DbA.eli(new JSONObject(stringExtra));
                    } catch (Exception e) {
                        Xb.eli("TTAD.LandingPageAct", "TTLandingPageActivity - onCreate MultiGlobalInfo : ", e);
                    }
                }
                this.bf = intent.getStringExtra("url");
                this.nGm = intent.getStringExtra("event_tag");
                this.dV = intent.getIntExtra("source", -1);
                this.nn = intent.getStringExtra("adid");
                this.Dfc = intent.getStringExtra("log_extra");
                this.ev = intent.getStringExtra("gecko_id");
            } else {
                ev evVar = this.QX;
                if (evVar != null) {
                    this.nn = evVar.umh();
                    this.Dfc = this.QX.eu();
                    this.ev = this.QX.QxD();
                    this.bf = this.QX.wC();
                    this.dV = this.QX.aAs();
                    this.nGm = this.QX.FC();
                }
            }
            if (this.QX == null) {
                finish();
                return;
            }
            kb();
            if (!TextUtils.isEmpty(this.ev)) {
                this.Vy = com.bytedance.sdk.openadsdk.kb.DbA.eli().DbA();
                int eli3 = com.bytedance.sdk.openadsdk.kb.DbA.eli().eli(this.Vy, this.ev);
                this.Ue = eli3;
                this.KM = eli3 > 0 ? 2 : 0;
            }
            this.aAs = this;
            if (this.MGA != null) {
                com.bytedance.sdk.openadsdk.core.widget.eli.Os.eli(this).eli(false).DbA(false).eli(this.MGA.getWebView());
            }
            com.bytedance.sdk.component.FC.MGA mga = this.MGA;
            if (mga != null && mga.getWebView() != null) {
                com.bytedance.sdk.openadsdk.aGH.nlS DbA2 = new com.bytedance.sdk.openadsdk.aGH.nlS(this.QX, this.MGA.getWebView(), new eli(this.Ue, this.QX, "landingpage", this), this.KM).DbA(true);
                this.eli = DbA2;
                this.nro = DbA2.eli;
                this.Cp = dZ.eli(this.QX, this.MGA, this.aAs, this.nGm);
            }
            wC();
            com.bytedance.sdk.component.FC.MGA mga2 = this.MGA;
            if (mga2 != null) {
                mga2.setLandingPage(true);
                this.MGA.setTag("landingpage");
                this.MGA.setMaterialMeta(this.QX.sO());
            }
            com.bytedance.sdk.openadsdk.core.widget.eli.ui uiVar = new com.bytedance.sdk.openadsdk.core.widget.eli.ui(this.aAs, this.aqO, this.nn, this.Cp, this.eli, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.1
                @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    try {
                        if (TTLandingPageActivity.this.NU != null && !TTLandingPageActivity.this.isFinishing()) {
                            TTLandingPageActivity.this.NU.setVisibility(8);
                        }
                    } catch (Throwable unused2) {
                    }
                    if (TTLandingPageActivity.this.GB != null) {
                        TTLandingPageActivity.this.GB.DbA();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    try {
                        if (!TextUtils.isEmpty(TTLandingPageActivity.this.ev)) {
                            TTLandingPageActivity.this.gG.incrementAndGet();
                            WebResourceResponseModel eli4 = com.bytedance.sdk.openadsdk.kb.DbA.eli().eli(TTLandingPageActivity.this.Vy, TTLandingPageActivity.this.ev, str);
                            if (eli4 != null && eli4.getWebResourceResponse() != null) {
                                TTLandingPageActivity.this.VM.incrementAndGet();
                                return eli4.getWebResourceResponse();
                            }
                            if (eli4 != null && eli4.getMsg() == 2) {
                                TTLandingPageActivity.this.ujq.incrementAndGet();
                            }
                            return super.shouldInterceptRequest(webView, str);
                        }
                        return super.shouldInterceptRequest(webView, str);
                    } catch (Throwable th) {
                        Xb.eli("TTAD.LandingPageAct", "shouldInterceptRequest url error", th);
                        return super.shouldInterceptRequest(webView, str);
                    }
                }
            };
            this.cyF = uiVar;
            uiVar.eli(this.QX);
            this.cyF.eli("landingpage");
            com.bytedance.sdk.component.FC.MGA mga3 = this.MGA;
            if (mga3 != null) {
                mga3.setWebViewClient(this.cyF);
                com.bytedance.sdk.component.FC.MGA mga4 = this.MGA;
                if (mga4 != null) {
                    mga4.setUserAgentString(QX.eli(mga4.getWebView(), BuildConfig.VERSION_CODE));
                }
                com.bytedance.sdk.component.FC.MGA mga5 = this.MGA;
                if (mga5 != null) {
                    mga5.setMixedContentMode(0);
                }
            }
            com.bytedance.sdk.openadsdk.aGH.Os.eli(this.QX, "landingpage", this.KM);
            com.bytedance.sdk.component.FC.MGA mga6 = this.MGA;
            if (mga6 != null) {
                bf.eli(mga6, this.bf);
                this.MGA.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.eli.aGH(this.aqO, this.eli, this.Cp) { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.5
                    @Override // android.webkit.WebChromeClient
                    public void onReceivedTitle(WebView webView, String str) {
                        super.onReceivedTitle(webView, str);
                        if (TTLandingPageActivity.this.FC != null) {
                            TextView textView = TTLandingPageActivity.this.FC;
                            if (TextUtils.isEmpty(str)) {
                                str = com.bytedance.sdk.component.utils.ev.eli(TTLandingPageActivity.this, "tt_web_title_default");
                            }
                            textView.setText(str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.eli.aGH, android.webkit.WebChromeClient
                    public void onProgressChanged(WebView webView, int i) {
                        super.onProgressChanged(webView, i);
                        if (TTLandingPageActivity.this.GB != null) {
                            TTLandingPageActivity.this.GB.eli(i);
                        }
                        if (TTLandingPageActivity.this.NU == null || TTLandingPageActivity.this.isFinishing()) {
                            return;
                        }
                        if (i != 100 || !TTLandingPageActivity.this.NU.isShown()) {
                            TTLandingPageActivity.this.NU.setProgress(i);
                        } else {
                            TTLandingPageActivity.this.NU.setVisibility(8);
                        }
                    }
                });
                if (this.MGA.getWebView() != null) {
                    this.MGA.getWebView().setOnScrollChangeListener(new DbA(this.eli));
                    this.MGA.getWebView().setOnTouchListener(new Os(this.eli, this.Cp));
                }
                this.MGA.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.6
                    @Override // android.webkit.DownloadListener
                    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                        if (TTLandingPageActivity.this.Xb != null) {
                            TTLandingPageActivity.this.Xb.Os(TTLandingPageActivity.this.QX);
                        }
                    }
                });
            }
            ui();
            com.bytedance.sdk.openadsdk.utils.nn eli4 = com.bytedance.sdk.openadsdk.utils.FC.eli(this, new FC.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.7
                @Override // com.bytedance.sdk.openadsdk.utils.FC.eli
                public void DbA() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.FC.eli
                public View eli() {
                    return TTLandingPageActivity.this.kb;
                }
            });
            this.qj = eli4;
            eli4.eli(0L);
            Os.eli.eli(SystemClock.elapsedRealtime() - elapsedRealtime, this.QX, "landingpage", this.Vy, this.ev);
        } catch (Throwable unused2) {
            finish();
        }
    }

    public static class eli implements du {
        private final ev DbA;
        private final String Os;
        private final WeakReference<TTLandingPageActivity> aGH;
        private final int eli;

        public eli(int i, ev evVar, String str, TTLandingPageActivity tTLandingPageActivity) {
            this.eli = i;
            this.DbA = evVar;
            this.Os = str;
            this.aGH = new WeakReference<>(tTLandingPageActivity);
        }

        @Override // com.bytedance.sdk.openadsdk.aGH.du
        public void eli(int i) {
            TTLandingPageActivity tTLandingPageActivity = this.aGH.get();
            if (tTLandingPageActivity != null) {
                Os.eli.eli(this.eli, tTLandingPageActivity.ujq.get(), tTLandingPageActivity.VM.get(), tTLandingPageActivity.gG.get() - tTLandingPageActivity.VM.get(), this.DbA, this.Os, i);
            }
        }
    }

    private static class DbA implements View.OnScrollChangeListener {
        private final WeakReference<com.bytedance.sdk.openadsdk.aGH.nlS> eli;

        public DbA(com.bytedance.sdk.openadsdk.aGH.nlS nls) {
            this.eli = new WeakReference<>(nls);
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i, int i2, int i3, int i4) {
            com.bytedance.sdk.openadsdk.aGH.nlS nls = this.eli.get();
            if (nls != null) {
                nls.DbA(i2);
            }
        }
    }

    private static class Os implements View.OnTouchListener {
        private final WeakReference<com.bytedance.sdk.openadsdk.common.aGH> DbA;
        private final WeakReference<com.bytedance.sdk.openadsdk.aGH.nlS> eli;

        public Os(com.bytedance.sdk.openadsdk.aGH.nlS nls, com.bytedance.sdk.openadsdk.common.aGH agh) {
            this.eli = new WeakReference<>(nls);
            this.DbA = new WeakReference<>(agh);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.bytedance.sdk.openadsdk.aGH.nlS nls = this.eli.get();
            if (nls != null) {
                nls.eli(motionEvent);
            }
            com.bytedance.sdk.openadsdk.common.aGH agh = this.DbA.get();
            if (agh == null) {
                return false;
            }
            agh.eli(motionEvent);
            return false;
        }
    }

    private View aGH() {
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(this);
        if (Build.VERSION.SDK_INT >= 35) {
            os.setFitsSystemWindows(true);
        }
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(this);
        uiVar.setOrientation(1);
        os.addView(uiVar, new FrameLayout.LayoutParams(-1, -1));
        nn nnVar = new nn(this, new nn.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.8
            @Override // com.bytedance.sdk.openadsdk.common.nn.eli
            public View eli(Context context) {
                return new aAs(context);
            }
        });
        nnVar.setId(aqO.qyC);
        uiVar.addView(nnVar, new LinearLayout.LayoutParams(-1, SSo.DbA(this, 44.0f)));
        com.bytedance.sdk.openadsdk.core.ui.Os os2 = new com.bytedance.sdk.openadsdk.core.ui.Os(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        uiVar.addView(os2, layoutParams);
        com.bytedance.sdk.component.FC.MGA mga = new com.bytedance.sdk.component.FC.MGA(this);
        mga.setId(aqO.ikX);
        os2.addView(mga, new FrameLayout.LayoutParams(-1, -1));
        nn nnVar2 = new nn(this, new nn.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.common.nn.eli
            public View eli(Context context) {
                return new com.bytedance.sdk.openadsdk.common.kb(context);
            }
        });
        nnVar2.setId(aqO.rQ);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 81;
        os2.addView(nnVar2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ui.MGA mga2 = new com.bytedance.sdk.openadsdk.core.ui.MGA(this, null, R.style.Widget.ProgressBar.Horizontal);
        mga2.setId(aqO.tLO);
        mga2.setProgress(1);
        mga2.setVisibility(8);
        mga2.setProgressDrawable(com.bytedance.sdk.openadsdk.utils.du.eli(this, "tt_browser_progress_style"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, SSo.DbA(this, 3.0f));
        layoutParams3.gravity = 49;
        os2.addView(mga2, layoutParams3);
        nlS nls = new nlS(this);
        nls.setOnlyLoading(this.eU);
        nls.setId(520093721);
        os.addView(nls, new FrameLayout.LayoutParams(-1, -1));
        return os;
    }

    private void eli(int i) {
        if (i == 1) {
            return;
        }
        setRequestedOrientation(i);
    }

    private void ui() {
        ev evVar = this.QX;
        if (evVar == null || evVar.yw() != 4) {
            return;
        }
        nn nnVar = this.du;
        if (nnVar != null) {
            nnVar.setVisibility(0);
        }
        Button button = (Button) findViewById(aqO.Gjg);
        this.nlS = button;
        if (button != null) {
            eli(MGA());
            if (this.Xb == null) {
                this.Xb = com.bytedance.sdk.openadsdk.QX.eli.eli.kb.eli(this, TextUtils.isEmpty(this.nGm) ? dZ.DbA(this.dV) : this.nGm);
            }
            com.bytedance.sdk.openadsdk.core.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.core.DbA.eli(this, this.QX, this.nGm, this.dV);
            eliVar.eli(false);
            this.nlS.setOnClickListener(eliVar);
            this.nlS.setOnTouchListener(eliVar);
            eliVar.Os(true);
            eliVar.eli(this.Xb);
        }
    }

    private String MGA() {
        ev evVar = this.QX;
        if (evVar != null && !TextUtils.isEmpty(evVar.GMu())) {
            this.dZ = this.QX.GMu();
        }
        return this.dZ;
    }

    private void eli(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.nlS) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.10
            @Override // java.lang.Runnable
            public void run() {
                if (TTLandingPageActivity.this.nlS == null || TTLandingPageActivity.this.isFinishing()) {
                    return;
                }
                TTLandingPageActivity.this.nlS.setText(str);
            }
        });
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable unused) {
        }
        ui();
    }

    private void kb() {
        com.bytedance.sdk.component.FC.MGA mga = (com.bytedance.sdk.component.FC.MGA) findViewById(aqO.ikX);
        this.MGA = mga;
        dZ.eli(this.QX, mga);
        this.du = (nn) findViewById(aqO.rQ);
        nn nnVar = (nn) findViewById(aqO.qyC);
        nlS nls = (nlS) findViewById(520093721);
        this.GB = nls;
        if (nls != null) {
            nls.eli(this.QX);
            this.GB.eli();
        }
        if (nnVar != null) {
            nnVar.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(520093720);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTLandingPageActivity.this.MGA != null) {
                        if (TTLandingPageActivity.this.nro != null) {
                            TTLandingPageActivity.this.nro.eli();
                        }
                        if (TTLandingPageActivity.this.MGA.FC()) {
                            TTLandingPageActivity.this.MGA.aAs();
                        } else if (TTLandingPageActivity.this.aAs()) {
                            TTLandingPageActivity.this.onBackPressed();
                        } else {
                            TTLandingPageActivity.this.finish();
                        }
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(520093716);
        this.kb = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTLandingPageActivity.this.finish();
                }
            });
        }
        this.FC = (TextView) findViewById(aqO.Kp);
        com.bytedance.sdk.openadsdk.core.ui.MGA mga2 = (com.bytedance.sdk.openadsdk.core.ui.MGA) findViewById(aqO.tLO);
        this.NU = mga2;
        if (mga2 != null) {
            mga2.setVisibility(0);
        }
        View findViewById = findViewById(aqO.XU);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTLandingPageActivity.this.Os();
                }
            });
        }
    }

    private void wC() {
        qj qjVar = new qj(this);
        this.aqO = qjVar;
        qjVar.DbA(this.MGA).Os(this.nn).aGH(this.Dfc).eli(this.QX).DbA(this.dV).eli(this.QX.ND()).ui(this.QX.WA()).eli(this.MGA).DbA("landingpage");
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        qj qjVar = this.aqO;
        if (qjVar != null) {
            qjVar.du();
        }
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.eli;
        if (nls != null) {
            nls.kb();
        }
        if (!this.oWW) {
            this.oWW = true;
            eli(4);
        }
        com.bytedance.sdk.openadsdk.utils.nn nnVar = this.qj;
        if (nnVar != null) {
            nnVar.eli();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.eli;
        if (nls != null) {
            nls.wC();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.utils.nn nnVar = this.qj;
        if (nnVar != null) {
            nnVar.DbA();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        FC();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected void DbA() {
        FC();
    }

    private void FC() {
        if (aAs() && !this.CMM.getAndSet(true)) {
            du();
            DbA(0);
        } else {
            try {
                super.onBackPressed();
            } catch (Throwable th) {
                Xb.Os("TTAD.LandingPageAct", "onBackPressed: ", th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAs() {
        return !TextUtils.isEmpty(this.bf) && this.bf.contains("__luban_sdk");
    }

    private void DbA(final int i) {
        if (this.kb == null || !aAs()) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.3
            @Override // java.lang.Runnable
            public void run() {
                SSo.eli((View) TTLandingPageActivity.this.kb, i);
            }
        });
    }

    private void du() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", true);
            this.aqO.eli("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        com.bytedance.sdk.component.FC.MGA mga;
        super.onDestroy();
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.eli;
        if (nls != null && (mga = this.MGA) != null) {
            nls.eli(mga);
        }
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.FC.MGA mga2 = this.MGA;
        if (mga2 != null) {
            com.bytedance.sdk.openadsdk.core.cyF.eli(mga2.getWebView());
        }
        this.MGA = null;
        qj qjVar = this.aqO;
        if (qjVar != null) {
            qjVar.nlS();
        }
        com.bytedance.sdk.openadsdk.aGH.nlS nls2 = this.eli;
        if (nls2 != null) {
            nls2.aGH(true);
        }
        if (!TextUtils.isEmpty(this.ev)) {
            Os.eli.eli(this.VM.get(), this.gG.get(), this.QX);
        }
        com.bytedance.sdk.openadsdk.kb.DbA.eli().eli(this.Vy);
        com.bytedance.sdk.openadsdk.utils.nn nnVar = this.qj;
        if (nnVar != null) {
            nnVar.Os();
        }
    }

    protected void Os() {
        if (isFinishing()) {
            return;
        }
        if (this.ui.get()) {
            NU();
            return;
        }
        if (this.DbA == null) {
            nlS();
        }
        Dfc dfc = this.DbA;
        if (dfc != null) {
            dfc.eli();
        }
    }

    private void nlS() {
        try {
            if (this.DbA == null) {
                Dfc dfc = new Dfc(this.aAs, this.QX);
                this.DbA = dfc;
                dfc.setDislikeSource("landing_page");
                this.DbA.setCallback(new Dfc.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.4
                    @Override // com.bytedance.sdk.openadsdk.common.Dfc.eli
                    public void eli(View view) {
                        TTLandingPageActivity.this.aGH.set(true);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.Dfc.eli
                    public void DbA(View view) {
                        TTLandingPageActivity.this.aGH.set(false);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.Dfc.eli
                    public void eli(FilterWord filterWord) {
                        if (TTLandingPageActivity.this.ui.get() || filterWord == null || filterWord.hasSecondOptions()) {
                            return;
                        }
                        TTLandingPageActivity.this.ui.set(true);
                        TTLandingPageActivity.this.nn();
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
            frameLayout.addView(this.DbA);
            if (this.Os == null) {
                TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this.aAs);
                this.Os = tTAdDislikeToast;
                frameLayout.addView(tTAdDislikeToast);
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("initDislike error", "LandingPageActivity", th);
        }
    }

    private void NU() {
        TTAdDislikeToast tTAdDislikeToast = this.Os;
        if (tTAdDislikeToast == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeTip());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nn() {
        TTAdDislikeToast tTAdDislikeToast;
        if (isFinishing() || (tTAdDislikeToast = this.Os) == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.utils.aGH.eli(this, this.QX);
    }
}
