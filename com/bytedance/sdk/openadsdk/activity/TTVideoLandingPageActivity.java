package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.component.utils.ujq;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.aGH.Os;
import com.bytedance.sdk.openadsdk.aGH.du;
import com.bytedance.sdk.openadsdk.aGH.nlS;
import com.bytedance.sdk.openadsdk.common.nn;
import com.bytedance.sdk.openadsdk.core.Ue;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.core.widget.eli.MGA;
import com.bytedance.sdk.openadsdk.utils.QX;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;
import com.bytedance.sdk.openadsdk.utils.bf;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class TTVideoLandingPageActivity extends TTBaseLandingPageActivity implements com.bytedance.sdk.openadsdk.aAs.aGH {
    protected TextView CMM;
    protected ImageView DbA;
    protected ev Dfc;
    protected qj FC;
    protected String FS;
    protected String GB;
    protected com.bytedance.sdk.openadsdk.QX.eli.eli.MGA KM;
    protected String MGA;
    protected com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA NU;
    protected ImageView Os;
    private int QI;
    protected Button Ue;
    protected TextView Vy;
    protected int aAs;
    protected TextView aGH;
    protected RelativeLayout bf;
    protected int cyF;
    protected nlS dZ;
    protected FrameLayout du;
    protected com.bytedance.sdk.openadsdk.multipro.DbA.eli eU;
    protected com.bytedance.sdk.component.FC.MGA eli;
    protected com.bytedance.sdk.openadsdk.core.widget.eli ev;
    protected TextView gG;
    protected MGA.eli jh;
    protected String kb;
    private int mm;
    protected long nn;
    private ILoader tGZ;
    protected Context ui;
    protected nn ujq;
    protected int nlS = -1;
    protected int aqO = 0;
    protected int dV = 0;
    protected int nGm = 0;
    protected int QX = 0;
    protected String Xb = "ダウンロード";
    protected boolean VM = false;
    protected boolean oWW = false;
    protected boolean qj = true;
    protected boolean nro = false;
    protected String Cp = null;
    protected AtomicBoolean SSo = new AtomicBoolean(true);
    protected JSONArray Uv = null;
    private final AtomicInteger WfR = new AtomicInteger(0);
    private final AtomicInteger ow = new AtomicInteger(0);
    private final AtomicInteger TfR = new AtomicInteger(0);
    int Za = -1;
    protected com.bytedance.sdk.openadsdk.core.DbA.eli ikX = null;
    private final Os.DbA oc = new Os.DbA() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.11
        @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.DbA
        public void eli(boolean z) {
            TTVideoLandingPageActivity.this.VM = z;
            if (TTVideoLandingPageActivity.this.isFinishing()) {
                return;
            }
            if (z) {
                SSo.eli((View) TTVideoLandingPageActivity.this.eli, 8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.du.getLayoutParams();
                TTVideoLandingPageActivity.this.dV = marginLayoutParams.leftMargin;
                TTVideoLandingPageActivity.this.aqO = marginLayoutParams.topMargin;
                TTVideoLandingPageActivity.this.nGm = marginLayoutParams.width;
                TTVideoLandingPageActivity.this.QX = marginLayoutParams.height;
                marginLayoutParams.width = -1;
                marginLayoutParams.height = -1;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                TTVideoLandingPageActivity.this.du.setLayoutParams(marginLayoutParams);
                return;
            }
            SSo.eli((View) TTVideoLandingPageActivity.this.eli, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.du.getLayoutParams();
            marginLayoutParams2.width = TTVideoLandingPageActivity.this.nGm;
            marginLayoutParams2.height = TTVideoLandingPageActivity.this.QX;
            marginLayoutParams2.leftMargin = TTVideoLandingPageActivity.this.dV;
            marginLayoutParams2.topMargin = TTVideoLandingPageActivity.this.aqO;
            TTVideoLandingPageActivity.this.du.setLayoutParams(marginLayoutParams2);
        }
    };
    private final ujq.eli rQ = new ujq.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.2
        @Override // com.bytedance.sdk.component.utils.ujq.eli
        public void eli(Context context, Intent intent, boolean z, final int i) {
            cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    eli(i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eli(int i) {
            if (TTVideoLandingPageActivity.this.cyF == 0 && i != 0 && TTVideoLandingPageActivity.this.eli != null && TTVideoLandingPageActivity.this.Cp != null) {
                TTVideoLandingPageActivity.this.eli.a_(TTVideoLandingPageActivity.this.Cp);
            }
            if (TTVideoLandingPageActivity.this.NU != null && TTVideoLandingPageActivity.this.NU.getNativeVideoController() != null && !TTVideoLandingPageActivity.this.oWW && TTVideoLandingPageActivity.this.cyF != i) {
                TTVideoLandingPageActivity.this.NU.getNativeVideoController().Os(i);
            }
            TTVideoLandingPageActivity.this.cyF = i;
        }
    };

    protected abstract View Os();

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected boolean eli() {
        return true;
    }

    protected abstract boolean kb();

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.nn.ui()) {
            finish();
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        try {
            dV.DbA(this);
        } catch (Throwable unused2) {
        }
        this.cyF = nGm.Os(getApplicationContext());
        try {
            setContentView(Os());
            this.ui = this;
            Intent intent = getIntent();
            this.nro = intent.getBooleanExtra("video_is_auto_play", true);
            if (bundle != null && bundle.getLong("video_play_position") > 0) {
                this.nn = bundle.getLong("video_play_position", 0L);
            }
            String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_DATA);
            if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                String stringExtra2 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra2 != null) {
                    try {
                        this.Dfc = com.bytedance.sdk.openadsdk.core.DbA.eli(new JSONObject(stringExtra2));
                    } catch (Exception unused3) {
                    }
                }
                ev evVar = this.Dfc;
                if (evVar != null) {
                    this.nlS = evVar.GR();
                }
                this.MGA = intent.getStringExtra("adid");
                this.kb = intent.getStringExtra("log_extra");
                str = intent.getStringExtra("web_title");
                this.FS = intent.getStringExtra("gecko_id");
                this.GB = intent.getStringExtra("event_tag");
                this.aAs = intent.getIntExtra("source", -1);
                this.Cp = intent.getStringExtra("url");
            } else {
                ev eli2 = Ue.eli().eli(Ue.eli(intent));
                this.Dfc = eli2;
                if (eli2 != null) {
                    this.nlS = eli2.GR();
                    this.MGA = this.Dfc.umh();
                    this.kb = this.Dfc.eu();
                    str = this.Dfc.Pf();
                    this.FS = this.Dfc.QxD();
                    this.Cp = this.Dfc.wC();
                    this.aAs = this.Dfc.aAs();
                    this.GB = this.Dfc.FC();
                } else {
                    str = null;
                }
            }
            if (this.Dfc == null) {
                finish();
                return;
            }
            if (!TextUtils.isEmpty(this.FS)) {
                this.tGZ = com.bytedance.sdk.openadsdk.kb.DbA.eli().DbA();
                int eli3 = com.bytedance.sdk.openadsdk.kb.DbA.eli().eli(this.tGZ, this.FS);
                this.QI = eli3;
                this.mm = eli3 > 0 ? 2 : 0;
            }
            if (stringExtra != null) {
                try {
                    this.eU = com.bytedance.sdk.openadsdk.multipro.DbA.eli.eli(new JSONObject(stringExtra));
                } catch (Exception unused4) {
                }
                com.bytedance.sdk.openadsdk.multipro.DbA.eli eliVar = this.eU;
                if (eliVar != null) {
                    this.nn = eliVar.kb;
                }
            }
            if (bundle != null) {
                this.Dfc = Ue.eli().eli(bundle.getInt("meta_index", -1));
                long j = bundle.getLong("video_play_position");
                if (j > 0) {
                    this.nn = j;
                }
            }
            ui();
            du();
            Dfc();
            eli(4);
            if (this.eli != null) {
                com.bytedance.sdk.openadsdk.core.widget.eli.Os.eli(this.ui).eli(true).DbA(false).eli(this.eli.getWebView());
                nlS DbA = new nlS(this.Dfc, this.eli.getWebView(), new du() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.1
                    @Override // com.bytedance.sdk.openadsdk.aGH.du
                    public void eli(int i) {
                        Os.eli.eli(TTVideoLandingPageActivity.this.QI, TTVideoLandingPageActivity.this.TfR.get(), TTVideoLandingPageActivity.this.ow.get(), TTVideoLandingPageActivity.this.WfR.get() - TTVideoLandingPageActivity.this.ow.get(), TTVideoLandingPageActivity.this.Dfc, "landingpage_split_screen", i);
                    }
                }, this.mm).DbA(true);
                this.dZ = DbA;
                this.jh = DbA.eli;
                this.dZ.eli("landingpage_split_screen");
            }
            com.bytedance.sdk.component.FC.MGA mga = this.eli;
            if (mga != null) {
                mga.setLandingPage(true);
                this.eli.setTag("landingpage_split_screen");
                this.eli.setMaterialMeta(this.Dfc.sO());
                this.eli.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.eli.ui(this.ui, this.FC, this.MGA, this.dZ, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.4
                    @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                    public WebResourceResponse shouldInterceptRequest(WebView webView, String str2) {
                        try {
                            if (!TextUtils.isEmpty(TTVideoLandingPageActivity.this.FS)) {
                                TTVideoLandingPageActivity.this.WfR.incrementAndGet();
                                WebResourceResponseModel eli4 = com.bytedance.sdk.openadsdk.kb.DbA.eli().eli(TTVideoLandingPageActivity.this.tGZ, TTVideoLandingPageActivity.this.FS, str2);
                                if (eli4 != null && eli4.getWebResourceResponse() != null) {
                                    TTVideoLandingPageActivity.this.ow.incrementAndGet();
                                    return eli4.getWebResourceResponse();
                                }
                                if (eli4 != null && eli4.getMsg() == 2) {
                                    TTVideoLandingPageActivity.this.TfR.incrementAndGet();
                                }
                                return super.shouldInterceptRequest(webView, str2);
                            }
                            return super.shouldInterceptRequest(webView, str2);
                        } catch (Throwable th) {
                            Xb.eli("TTVideoLandingPage", "shouldInterceptRequest url error", th);
                            return super.shouldInterceptRequest(webView, str2);
                        }
                    }
                });
                com.bytedance.sdk.component.FC.MGA mga2 = this.eli;
                mga2.setUserAgentString(QX.eli(mga2.getWebView(), BuildConfig.VERSION_CODE));
            }
            com.bytedance.sdk.component.FC.MGA mga3 = this.eli;
            if (mga3 != null) {
                mga3.setMixedContentMode(0);
            }
            com.bytedance.sdk.openadsdk.aGH.Os.eli(this.Dfc, "landingpage_split_screen", this.mm);
            bf.eli(this.eli, this.Cp);
            this.eli.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.eli.aGH(this.FC, this.dZ) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.5
                @Override // com.bytedance.sdk.openadsdk.core.widget.eli.aGH, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                }
            });
            this.eli.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.6
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str2, String str3, String str4, String str5, long j2) {
                    if (TTVideoLandingPageActivity.this.KM != null) {
                        TTVideoLandingPageActivity.this.KM.Os(TTVideoLandingPageActivity.this.Dfc);
                    }
                }
            });
            TextView textView = this.aGH;
            if (textView != null) {
                if (TextUtils.isEmpty(str)) {
                    str = com.bytedance.sdk.component.utils.ev.eli(this, "tt_web_title_default");
                }
                textView.setText(str);
            }
            nlS();
            MGA();
            nn();
            Os.eli.eli(SystemClock.elapsedRealtime() - elapsedRealtime, this.Dfc, "landingpage_split_screen", this.tGZ, this.FS);
        } catch (Throwable unused5) {
            finish();
        }
    }

    private void nn() {
        ev evVar = this.Dfc;
        if (evVar == null || evVar.yw() != 4) {
            return;
        }
        this.ujq.setVisibility(0);
        Button button = (Button) findViewById(aqO.Gjg);
        this.Ue = button;
        if (button != null) {
            eli(aGH());
            this.Ue.setOnClickListener(this.ikX);
            this.Ue.setOnTouchListener(this.ikX);
        }
    }

    protected String aGH() {
        ev evVar = this.Dfc;
        if (evVar != null && !TextUtils.isEmpty(evVar.GMu())) {
            this.Xb = this.Dfc.GMu();
        }
        return this.Xb;
    }

    private void eli(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.Ue) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.7
            @Override // java.lang.Runnable
            public void run() {
                if (TTVideoLandingPageActivity.this.Ue == null || TTVideoLandingPageActivity.this.isFinishing()) {
                    return;
                }
                TTVideoLandingPageActivity.this.Ue.setText(str);
            }
        });
    }

    protected void ui() {
        this.ujq = (nn) findViewById(aqO.rQ);
        this.eli = (com.bytedance.sdk.component.FC.MGA) findViewById(aqO.ikX);
        ImageView imageView = (ImageView) findViewById(520093720);
        this.DbA = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTVideoLandingPageActivity.this.eli != null) {
                        if (TTVideoLandingPageActivity.this.jh != null) {
                            TTVideoLandingPageActivity.this.jh.eli();
                        }
                        if (!TTVideoLandingPageActivity.this.eli.FC()) {
                            if (TTVideoLandingPageActivity.this.Xb()) {
                                TTVideoLandingPageActivity.this.onBackPressed();
                                return;
                            } else {
                                com.bytedance.sdk.openadsdk.aGH.Os.eli(TTVideoLandingPageActivity.this.Dfc, "embeded_ad", "detail_back", TTVideoLandingPageActivity.this.wC(), TTVideoLandingPageActivity.this.FC(), (TTVideoLandingPageActivity.this.NU == null || TTVideoLandingPageActivity.this.NU.getNativeVideoController() == null) ? null : dZ.eli(TTVideoLandingPageActivity.this.Dfc, TTVideoLandingPageActivity.this.NU.getNativeVideoController().kb(), TTVideoLandingPageActivity.this.NU.getNativeVideoController().du()), (com.bytedance.sdk.openadsdk.aGH.kb) null);
                                TTVideoLandingPageActivity.this.finish();
                                return;
                            }
                        }
                        TTVideoLandingPageActivity.this.eli.aAs();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga = this.NU;
        if (mga != null) {
            mga.setIsAutoPlay(this.nro);
        }
        ImageView imageView2 = (ImageView) findViewById(aqO.dZ);
        this.Os = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTVideoLandingPageActivity.this.NU != null) {
                        com.bytedance.sdk.openadsdk.aGH.Os.eli(TTVideoLandingPageActivity.this.Dfc, "embeded_ad", "detail_skip", TTVideoLandingPageActivity.this.wC(), TTVideoLandingPageActivity.this.FC(), TTVideoLandingPageActivity.this.NU.getNativeVideoController() != null ? dZ.eli(TTVideoLandingPageActivity.this.Dfc, TTVideoLandingPageActivity.this.NU.getNativeVideoController().kb(), TTVideoLandingPageActivity.this.NU.getNativeVideoController().du()) : null, (com.bytedance.sdk.openadsdk.aGH.kb) null);
                    }
                    TTVideoLandingPageActivity.this.finish();
                }
            });
        }
        this.aGH = (TextView) findViewById(aqO.Kp);
        this.du = (FrameLayout) findViewById(aqO.eU);
        this.bf = (RelativeLayout) findViewById(aqO.SSo);
        this.CMM = (TextView) findViewById(aqO.FS);
        this.Vy = (TextView) findViewById(aqO.jh);
        this.gG = (TextView) findViewById(aqO.Za);
        this.ev = (com.bytedance.sdk.openadsdk.core.widget.eli) findViewById(aqO.Uv);
        aAs();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        nn();
    }

    protected void MGA() {
        if (kb()) {
            try {
                com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga = new com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA(this.ui, this.Dfc, true, null);
                this.NU = mga;
                if (mga.getNativeVideoController() != null) {
                    this.NU.getNativeVideoController().eli(false);
                }
                if (this.oWW) {
                    this.du.setVisibility(0);
                    this.du.removeAllViews();
                    this.du.addView(this.NU);
                    this.NU.DbA(true);
                } else {
                    if (!this.nro) {
                        this.nn = 0L;
                    }
                    if (this.eU != null && this.NU.getNativeVideoController() != null) {
                        this.NU.getNativeVideoController().Os(this.eU.kb);
                        this.NU.getNativeVideoController().aGH(this.eU.ui);
                        this.NU.eli(dV.aGH().DbA(String.valueOf(this.Dfc.RTg())), "landingPageInit");
                    }
                    if (this.NU.eli(this.nn, this.qj, this.oWW)) {
                        this.du.setVisibility(0);
                        this.du.removeAllViews();
                        this.du.addView(this.NU);
                    }
                    if (this.NU.getNativeVideoController() != null) {
                        this.NU.getNativeVideoController().eli(false);
                        this.NU.getNativeVideoController().eli(this.oc);
                    }
                }
                String eli2 = this.Dfc.an().get(0).eli();
                com.bytedance.sdk.openadsdk.FC.aGH.eli().eli(eli2).eli(this.Dfc.an().get(0).DbA()).DbA(this.Dfc.an().get(0).Os()).ui(SSo.ui(dV.eli())).aGH(SSo.Os(dV.eli())).Os(2).eli(new com.bytedance.sdk.openadsdk.FC.DbA(this.Dfc, eli2, new com.bytedance.sdk.component.ui.aqO() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.10
                    @Override // com.bytedance.sdk.component.ui.aqO
                    public void eli(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.ui.aqO
                    public void eli(com.bytedance.sdk.component.ui.du duVar) {
                        try {
                            Object DbA = duVar.DbA();
                            if (DbA instanceof Bitmap) {
                                new eli((Bitmap) DbA, TTVideoLandingPageActivity.this.NU.getNativeVideoController().nlS()).execute(new Void[0]);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }), 4);
                this.NU.findViewById(520093726).setOnTouchListener(null);
                this.NU.findViewById(520093726).setOnClickListener(null);
            } catch (Exception e) {
                Xb.Os("TTVideoLandingPage", e.getMessage());
                if (this.NU == null) {
                    ApmHelper.reportCustomError("mNativeVideoTsView is null", "FUNCTION EXCEPTION", e);
                }
            }
            if (this.cyF == 0) {
                try {
                    Toast.makeText(this, com.bytedance.sdk.component.utils.ev.eli(this, "tt_no_network"), 0).show();
                } catch (Throwable unused) {
                }
            }
        }
    }

    protected long wC() {
        com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga = this.NU;
        if (mga == null || mga.getNativeVideoController() == null) {
            return 0L;
        }
        return this.NU.getNativeVideoController().FC();
    }

    protected int FC() {
        com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga = this.NU;
        if (mga == null || mga.getNativeVideoController() == null) {
            return 0;
        }
        return this.NU.getNativeVideoController().aAs();
    }

    protected void aAs() {
        String str;
        ev evVar = this.Dfc;
        if (evVar == null || evVar.yw() != 4) {
            return;
        }
        SSo.eli((View) this.bf, 0);
        if (!TextUtils.isEmpty(this.Dfc.Pf())) {
            str = this.Dfc.Pf();
        } else if (!TextUtils.isEmpty(this.Dfc.bU())) {
            str = this.Dfc.bU();
        } else if (TextUtils.isEmpty(this.Dfc.kEI())) {
            str = "";
        } else {
            str = this.Dfc.kEI();
        }
        if (this.Dfc.SjY() != null && this.Dfc.SjY().eli() != null) {
            SSo.eli((View) this.ev, 0);
            SSo.eli((View) this.CMM, 4);
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.Dfc.SjY(), this.ev, this.Dfc);
        } else if (!TextUtils.isEmpty(str)) {
            SSo.eli((View) this.ev, 4);
            SSo.eli((View) this.CMM, 0);
            this.CMM.setText(str.substring(0, 1));
        }
        if (!TextUtils.isEmpty(this.Dfc.GMu())) {
            this.gG.setText(this.Dfc.GMu());
        }
        if (!TextUtils.isEmpty(str)) {
            this.Vy.setText(str);
        }
        SSo.eli((View) this.Vy, 0);
        SSo.eli((View) this.gG, 0);
    }

    public void du() {
        if (this.Dfc == null) {
            return;
        }
        this.KM = com.bytedance.sdk.openadsdk.QX.eli.eli.kb.eli(this, this.GB);
        com.bytedance.sdk.openadsdk.core.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.core.DbA.eli(this, this.Dfc, this.GB, this.aAs);
        this.ikX = eliVar;
        eliVar.eli(false);
        this.ikX.Os(true);
        this.gG.setOnClickListener(this.ikX);
        this.gG.setOnTouchListener(this.ikX);
        this.ikX.eli(this.KM);
    }

    private void Dfc() {
        qj qjVar = new qj(this);
        this.FC = qjVar;
        qjVar.DbA(this.eli).Os(this.MGA).aGH(this.kb).DbA(this.aAs).eli(this.Dfc).eli(this.Dfc.ND()).eli(this.eli).DbA("landingpage_split_screen").ui(this.Dfc.WA());
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        aqO();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected void DbA() {
        aqO();
    }

    private void aqO() {
        com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga;
        if (this.VM && (mga = this.NU) != null && mga.getNativeVideoController() != null) {
            this.NU.getNativeVideoController().ui(null, null);
            this.VM = false;
        } else if (Xb() && !this.SSo.getAndSet(true)) {
            bf();
            eli(0);
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        int eli2 = this.Dfc != null ? Ue.eli().eli(this.Dfc) : -1;
        this.Za = eli2;
        bundle.putInt("meta_index", eli2);
        bundle.putLong("video_play_position", this.nn);
        bundle.putBoolean("is_complete", this.oWW);
        long j = this.nn;
        com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga = this.NU;
        if (mga != null && mga.getNativeVideoController() != null) {
            j = this.NU.getNativeVideoController().MGA();
        }
        bundle.putLong("video_play_position", j);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.qj) {
            dV();
        }
        this.qj = false;
        qj qjVar = this.FC;
        if (qjVar != null) {
            qjVar.du();
        }
        nlS nls = this.dZ;
        if (nls != null) {
            nls.kb();
        }
    }

    private void dV() {
        com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga = this.NU;
        if (mga == null || mga.getNativeVideoController() == null || QX()) {
            return;
        }
        this.NU.nn();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        nGm();
        com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga = this.NU;
        if (mga == null || mga.getNativeVideoController() == null) {
            return;
        }
        eli(this.NU.getNativeVideoController());
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        nlS nls = this.dZ;
        if (nls != null) {
            nls.wC();
        }
    }

    private void eli(com.bykv.vk.openvk.eli.eli.eli.aGH.Os os) {
        this.oWW = this.oWW || os.NU();
        com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.TRUE);
        com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_video_isfromvideodetailpage", Boolean.TRUE);
        com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(this.oWW));
        com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(os.MGA()));
        com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(os.FC() + os.kb()));
        com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_native_video_data", "key_video_duration", Long.valueOf(os.FC()));
    }

    private void nGm() {
        if (this.NU == null || QX()) {
            return;
        }
        this.NU.nn();
    }

    private boolean QX() {
        com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga = this.NU;
        if (mga == null || mga.getNativeVideoController() == null) {
            return true;
        }
        return this.NU.getNativeVideoController().NU();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        NU();
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
            this.Dfc.aAs(false);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.FC.MGA mga = this.eli;
        if (mga != null) {
            com.bytedance.sdk.openadsdk.core.cyF.eli(mga.getWebView());
        }
        this.eli = null;
        qj qjVar = this.FC;
        if (qjVar != null) {
            qjVar.nlS();
        }
        com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga2 = this.NU;
        if (mga2 != null && mga2.getNativeVideoController() != null) {
            this.NU.getNativeVideoController().ui();
        }
        this.NU = null;
        this.Dfc = null;
        nlS nls = this.dZ;
        if (nls != null) {
            nls.aGH(true);
        }
        if (!TextUtils.isEmpty(this.FS)) {
            Os.eli.eli(this.ow.get(), this.WfR.get(), this.Dfc);
        }
        com.bytedance.sdk.openadsdk.kb.DbA.eli().eli(this.tGZ);
    }

    protected void nlS() {
        ujq.eli(this.rQ, this.ui);
    }

    protected void NU() {
        try {
            ujq.eli(this.rQ);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Xb() {
        return !TextUtils.isEmpty(this.Cp) && this.Cp.contains("__luban_sdk");
    }

    private void eli(final int i) {
        if (this.Os == null || !Xb()) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.3
            @Override // java.lang.Runnable
            public void run() {
                SSo.eli((View) TTVideoLandingPageActivity.this.Os, i);
            }
        });
    }

    private void bf() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", true);
            this.FC.eli("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.aAs.aGH
    public void eli(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.Uv = jSONArray;
    }

    private static class eli extends AsyncTask<Void, Void, Drawable> {
        private final WeakReference<com.bykv.vk.openvk.eli.eli.eli.aGH.DbA> DbA;
        private final Bitmap eli;

        private eli(Bitmap bitmap, com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA) {
            this.eli = bitmap;
            this.DbA = new WeakReference<>(dbA);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public Drawable doInBackground(Void... voidArr) {
            try {
                Bitmap eli = com.bytedance.sdk.component.adexpress.aGH.eli.eli(dV.eli(), this.eli, 25);
                if (eli == null) {
                    return null;
                }
                return new BitmapDrawable(dV.eli().getResources(), eli);
            } catch (Throwable th) {
                Xb.Os("TTVideoLandingPage", th.getMessage());
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Drawable drawable) {
            WeakReference<com.bykv.vk.openvk.eli.eli.eli.aGH.DbA> weakReference;
            if (drawable == null || (weakReference = this.DbA) == null || weakReference.get() == null) {
                return;
            }
            this.DbA.get().eli(drawable);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.Za >= 0) {
            Ue.eli().Os(this.Za);
            this.Za = -1;
        }
        com.bytedance.sdk.openadsdk.utils.aGH.eli(this, this.Dfc);
    }
}
