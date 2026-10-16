package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.common.Dfc;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.common.aqO;
import com.bytedance.sdk.openadsdk.common.nlS;
import com.bytedance.sdk.openadsdk.common.nn;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.bytedance.sdk.openadsdk.utils.du;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TTVideoLandingPageLink2Activity extends TTVideoLandingPageActivity implements com.bytedance.sdk.openadsdk.aAs.aGH {
    private long BH;
    private com.bytedance.sdk.openadsdk.common.aGH DE;
    private PAGLogoView GMY;
    private LinearLayout Mc;
    private nlS QI;
    TTAdDislikeToast WfR;
    private TextView Yw;
    private aqO gHb;
    private View mm;
    private View oc;
    private TextView qyC;
    private com.bytedance.sdk.openadsdk.core.widget.eli.ui rH;
    private boolean rQ;
    Dfc tGZ;
    private boolean tLO;
    private boolean BDs = false;
    final AtomicBoolean ow = new AtomicBoolean(false);
    final AtomicBoolean TfR = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!nn.ui() || this.Dfc == null || this.eli == null) {
            finish();
            return;
        }
        com.bytedance.sdk.openadsdk.common.aGH eli = dZ.eli(this.Dfc, this.eli, this.ui, this.GB);
        this.DE = eli;
        if (eli != null) {
            eli.eli("landingpage_split_screen");
        }
        this.tLO = dV.aGH().QX();
        if (this.eli.getWebView() != null) {
            this.eli.getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.1
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    if (TTVideoLandingPageLink2Activity.this.dZ != null) {
                        TTVideoLandingPageLink2Activity.this.dZ.DbA(i2);
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.widget.eli.ui uiVar = new com.bytedance.sdk.openadsdk.core.widget.eli.ui(this.ui, this.FC, this.MGA, this.DE, this.dZ, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTVideoLandingPageLink2Activity.this.mm != null && !TTVideoLandingPageLink2Activity.this.rQ) {
                        TTVideoLandingPageLink2Activity.this.mm.setVisibility(8);
                    }
                    if (TTVideoLandingPageLink2Activity.this.Mc != null) {
                        TTVideoLandingPageLink2Activity.this.Mc.setVisibility(0);
                    }
                    TTVideoLandingPageLink2Activity.this.BDs = true;
                    TTVideoLandingPageLink2Activity.this.aqO();
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(TTVideoLandingPageLink2Activity.this.Dfc, TTVideoLandingPageLink2Activity.this.GB, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.BH, true);
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                TTVideoLandingPageLink2Activity.this.BH = System.currentTimeMillis();
            }
        };
        this.rH = uiVar;
        uiVar.eli(this.Dfc);
        this.eli.setWebViewClient(this.rH);
        this.eli.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.eli.aGH(this.FC, this.dZ, this.DE) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.8
            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.aGH, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTVideoLandingPageLink2Activity.this.tLO && TTVideoLandingPageLink2Activity.this.gHb != null && i == 100) {
                    TTVideoLandingPageLink2Activity.this.gHb.eli(webView, TTVideoLandingPageLink2Activity.this.jh);
                }
                if (TTVideoLandingPageLink2Activity.this.QI != null) {
                    TTVideoLandingPageLink2Activity.this.QI.eli(i);
                }
            }
        });
        TextView textView = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.aqO.fnE);
        if (textView != null && this.Dfc.QX() != null) {
            textView.setText(this.Dfc.QX().ui());
        }
        nn.Os().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTVideoLandingPageLink2Activity.this.rQ = true;
                    if (TTVideoLandingPageLink2Activity.this.QI != null) {
                        TTVideoLandingPageLink2Activity.this.QI.DbA();
                    }
                    TTVideoLandingPageLink2Activity.this.oc.setVisibility(0);
                    if (TTVideoLandingPageLink2Activity.this.GMY != null) {
                        TTVideoLandingPageLink2Activity.this.GMY.setVisibility(0);
                    }
                    if (TTVideoLandingPageLink2Activity.this.BDs) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(TTVideoLandingPageLink2Activity.this.Dfc, TTVideoLandingPageLink2Activity.this.GB, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.BH, false);
                } catch (Exception unused) {
                }
            }
        }, (this.Dfc == null || this.Dfc.QX() == null) ? 10000L : this.Dfc.QX().eli() * 1000);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected View Os() {
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(this);
        if (Build.VERSION.SDK_INT >= 35) {
            uiVar.setFitsSystemWindows(true);
        }
        uiVar.setOrientation(1);
        uiVar.setBackgroundColor(-1);
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(this);
        uiVar.addView(os, new LinearLayout.LayoutParams(-1, SSo.DbA(this, 220.0f)));
        com.bytedance.sdk.openadsdk.core.ui.Os os2 = new com.bytedance.sdk.openadsdk.core.ui.Os(this);
        os2.setId(com.bytedance.sdk.openadsdk.utils.aqO.eU);
        os.addView(os2, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar2 = new com.bytedance.sdk.openadsdk.core.ui.ui(this);
        uiVar2.setOrientation(0);
        uiVar2.setPadding(0, SSo.DbA(this, 20.0f), 0, 0);
        os.addView(uiVar2, new FrameLayout.LayoutParams(-1, -2));
        View view = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        uiVar2.addView(view, layoutParams);
        com.bytedance.sdk.openadsdk.core.widget.Dfc dfc = new com.bytedance.sdk.openadsdk.core.widget.Dfc(this);
        dfc.setId(520093713);
        dfc.setGravity(17);
        dfc.setText(ev.eli(this, "tt_reward_feedback"));
        dfc.setTextColor(-1);
        dfc.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, SSo.DbA(this, 28.0f));
        int DbA = SSo.DbA(this, 16.0f);
        layoutParams2.rightMargin = DbA;
        layoutParams2.leftMargin = DbA;
        uiVar2.addView(dfc, layoutParams2);
        com.bytedance.sdk.openadsdk.core.widget.nn nnVar = new com.bytedance.sdk.openadsdk.core.widget.nn(this);
        nnVar.setId(com.bytedance.sdk.openadsdk.utils.aqO.dZ);
        nnVar.setPadding(SSo.DbA(this, 7.0f), SSo.DbA(this, 7.0f), SSo.DbA(this, 7.0f), SSo.DbA(this, 7.0f));
        nnVar.setImageResource(ev.aGH(this, "tt_video_close_drawable"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(SSo.DbA(this, 28.0f), SSo.DbA(this, 28.0f));
        layoutParams3.rightMargin = SSo.DbA(this, 12.0f);
        uiVar2.addView(nnVar, layoutParams3);
        com.bytedance.sdk.openadsdk.core.ui.kb kbVar = new com.bytedance.sdk.openadsdk.core.ui.kb(this);
        kbVar.setVisibility(8);
        kbVar.setId(com.bytedance.sdk.openadsdk.utils.aqO.SSo);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = SSo.DbA(this, 10.0f);
        uiVar.addView(kbVar, layoutParams4);
        com.bytedance.sdk.openadsdk.core.widget.eli eliVar = new com.bytedance.sdk.openadsdk.core.widget.eli(this);
        eliVar.setId(com.bytedance.sdk.openadsdk.utils.aqO.Uv);
        eliVar.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        eliVar.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(SSo.DbA(this, 44.0f), SSo.DbA(this, 44.0f));
        layoutParams5.addRule(9);
        layoutParams5.leftMargin = SSo.DbA(this, 5.0f);
        kbVar.addView(eliVar, layoutParams5);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(this);
        wCVar.setId(com.bytedance.sdk.openadsdk.utils.aqO.FS);
        wCVar.setBackground(du.eli(this, "tt_circle_solid_mian"));
        wCVar.setGravity(17);
        wCVar.setTextColor(-1);
        wCVar.setTextSize(2, 19.0f);
        wCVar.setTypeface(Typeface.DEFAULT_BOLD);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(SSo.DbA(this, 44.0f), SSo.DbA(this, 44.0f));
        layoutParams6.addRule(9);
        layoutParams6.leftMargin = SSo.DbA(this, 5.0f);
        kbVar.addView(wCVar, layoutParams6);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar2 = new com.bytedance.sdk.openadsdk.core.ui.wC(this);
        wCVar2.setId(com.bytedance.sdk.openadsdk.utils.aqO.jh);
        wCVar2.setMaxLines(1);
        wCVar2.setEllipsize(TextUtils.TruncateAt.END);
        wCVar2.setTextColor(Color.parseColor("#e5000000"));
        wCVar2.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(15);
        layoutParams7.leftMargin = SSo.DbA(this, 5.0f);
        layoutParams7.rightMargin = SSo.DbA(this, 80.0f);
        layoutParams7.addRule(1, com.bytedance.sdk.openadsdk.utils.aqO.FS);
        kbVar.addView(wCVar2, layoutParams7);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar3 = new com.bytedance.sdk.openadsdk.core.ui.wC(this);
        wCVar3.setId(com.bytedance.sdk.openadsdk.utils.aqO.Za);
        wCVar3.setClickable(true);
        wCVar3.setMaxLines(1);
        wCVar3.setEllipsize(TextUtils.TruncateAt.END);
        wCVar3.setFocusable(true);
        wCVar3.setGravity(17);
        wCVar3.setText(ev.eli(this, "tt_video_mobile_go_detail"));
        wCVar3.setTextColor(-1);
        wCVar3.setTextSize(2, 14.0f);
        wCVar3.setPadding(SSo.DbA(this, 2.0f), SSo.DbA(this, 2.0f), SSo.DbA(this, 2.0f), SSo.DbA(this, 2.0f));
        wCVar3.setBackground(du.eli(this, "tt_ad_cover_btn_begin_bg"));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(SSo.DbA(this, 90.0f), SSo.DbA(this, 36.0f));
        layoutParams8.addRule(11);
        layoutParams8.addRule(15);
        layoutParams8.rightMargin = SSo.DbA(this, 5.0f);
        kbVar.addView(wCVar3, layoutParams8);
        com.bytedance.sdk.openadsdk.core.ui.Os os3 = new com.bytedance.sdk.openadsdk.core.ui.Os(this);
        uiVar.addView(os3, new LinearLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.component.FC.MGA mga = new com.bytedance.sdk.component.FC.MGA(this);
        mga.setId(com.bytedance.sdk.openadsdk.utils.aqO.ikX);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams9.topMargin = SSo.DbA(this, 2.0f);
        os3.addView(mga, layoutParams9);
        com.bytedance.sdk.openadsdk.core.ui.kb kbVar2 = new com.bytedance.sdk.openadsdk.core.ui.kb(this);
        kbVar2.setId(com.bytedance.sdk.openadsdk.utils.aqO.tGZ);
        kbVar2.setBackgroundColor(Color.parseColor("#F8F8F8"));
        os3.addView(kbVar2, new FrameLayout.LayoutParams(-1, -1));
        nlS nls = new nlS(this);
        nls.setId(com.bytedance.sdk.openadsdk.utils.aqO.WfR);
        kbVar2.addView(nls, new RelativeLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar3 = new com.bytedance.sdk.openadsdk.core.ui.ui(this);
        uiVar3.setId(com.bytedance.sdk.openadsdk.utils.aqO.cyF);
        uiVar3.setOrientation(1);
        uiVar3.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams10.addRule(13);
        kbVar2.addView(uiVar3, layoutParams10);
        com.bytedance.sdk.openadsdk.core.widget.dV dVVar = new com.bytedance.sdk.openadsdk.core.widget.dV(this);
        dVVar.setId(com.bytedance.sdk.openadsdk.utils.aqO.ow);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(SSo.DbA(this, 80.0f), SSo.DbA(this, 80.0f));
        layoutParams11.gravity = 17;
        uiVar3.addView(dVVar, layoutParams11);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar4 = new com.bytedance.sdk.openadsdk.core.ui.wC(this);
        wCVar4.setId(com.bytedance.sdk.openadsdk.utils.aqO.TfR);
        wCVar4.setTextColor(Color.parseColor("#161823"));
        wCVar4.setTextSize(0, SSo.DbA(this, 24.0f));
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.gravity = 17;
        layoutParams12.topMargin = SSo.DbA(this, 12.0f);
        uiVar3.addView(wCVar4, layoutParams12);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar5 = new com.bytedance.sdk.openadsdk.core.ui.wC(this);
        wCVar5.setId(com.bytedance.sdk.openadsdk.utils.aqO.QI);
        wCVar5.setTextColor(Color.parseColor("#80161823"));
        wCVar5.setTextSize(0, SSo.DbA(this, 16.0f));
        wCVar5.setTextAlignment(4);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.gravity = 17;
        int DbA2 = SSo.DbA(this, 60.0f);
        layoutParams13.rightMargin = DbA2;
        layoutParams13.leftMargin = DbA2;
        layoutParams13.topMargin = SSo.DbA(this, 8.0f);
        uiVar3.addView(wCVar5, layoutParams13);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar6 = new com.bytedance.sdk.openadsdk.core.ui.wC(this);
        wCVar6.setId(com.bytedance.sdk.openadsdk.utils.aqO.mm);
        wCVar6.setGravity(17);
        wCVar6.setTextColor(-1);
        wCVar6.setText(ev.eli(this, "tt_video_mobile_go_detail"));
        wCVar6.setBackground(du.eli(this, "tt_reward_video_download_btn_bg"));
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(SSo.DbA(this, 255.0f), SSo.DbA(this, 44.0f));
        layoutParams14.gravity = 17;
        layoutParams14.topMargin = SSo.DbA(this, 32.0f);
        uiVar3.addView(wCVar6, layoutParams14);
        PAGLogoView pAGLogoView = new PAGLogoView(this);
        this.GMY = pAGLogoView;
        pAGLogoView.setId(com.bytedance.sdk.openadsdk.utils.aqO.oc);
        this.GMY.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, SSo.DbA(this, 14.0f));
        layoutParams15.addRule(12);
        layoutParams15.leftMargin = SSo.DbA(this, 18.0f);
        layoutParams15.bottomMargin = SSo.DbA(this, 61.0f);
        kbVar2.addView(this.GMY, layoutParams15);
        com.bytedance.sdk.openadsdk.common.nn nnVar2 = new com.bytedance.sdk.openadsdk.common.nn(this, new nn.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.10
            @Override // com.bytedance.sdk.openadsdk.common.nn.eli
            public View eli(Context context) {
                return new com.bytedance.sdk.openadsdk.common.kb(context);
            }
        });
        nnVar2.setId(com.bytedance.sdk.openadsdk.utils.aqO.rQ);
        FrameLayout.LayoutParams layoutParams16 = new FrameLayout.LayoutParams(-1, SSo.DbA(this, 48.0f));
        layoutParams16.gravity = 81;
        os3.addView(nnVar2, layoutParams16);
        com.bytedance.sdk.openadsdk.common.nn nnVar3 = new com.bytedance.sdk.openadsdk.common.nn(this, new nn.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.11
            @Override // com.bytedance.sdk.openadsdk.common.nn.eli
            public View eli(Context context) {
                return new com.bytedance.sdk.openadsdk.common.wC(context);
            }
        });
        nnVar3.setId(com.bytedance.sdk.openadsdk.utils.aqO.Yw);
        FrameLayout.LayoutParams layoutParams17 = new FrameLayout.LayoutParams(-1, SSo.DbA(this, 44.0f));
        layoutParams17.gravity = 80;
        os3.addView(nnVar3, layoutParams17);
        return uiVar;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected void ui() {
        TTVideoLandingPageLink2Activity tTVideoLandingPageLink2Activity;
        super.ui();
        TextView textView = (TextView) findViewById(520093713);
        if (textView != null) {
            textView.setText(ev.eli(dV.eli(), "tt_reward_feedback"));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoLandingPageLink2Activity.this.nn();
                }
            });
        }
        this.Yw = (TextView) findViewById(520093714);
        this.QI = (nlS) findViewById(com.bytedance.sdk.openadsdk.utils.aqO.WfR);
        this.mm = findViewById(com.bytedance.sdk.openadsdk.utils.aqO.tGZ);
        this.oc = findViewById(com.bytedance.sdk.openadsdk.utils.aqO.cyF);
        TextView textView2 = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.aqO.TfR);
        TextView textView3 = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.aqO.QI);
        com.bytedance.sdk.openadsdk.core.widget.dV dVVar = (com.bytedance.sdk.openadsdk.core.widget.dV) findViewById(com.bytedance.sdk.openadsdk.utils.aqO.ow);
        this.qyC = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.aqO.mm);
        if (this.Dfc.SjY() != null && !TextUtils.isEmpty(this.Dfc.SjY().eli())) {
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.Dfc.SjY(), dVVar, this.Dfc);
        }
        textView2.setText(this.Dfc.kEI());
        textView3.setText(this.Dfc.bU());
        View findViewById = findViewById(com.bytedance.sdk.openadsdk.utils.aqO.oc);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTWebsiteActivity.eli(TTVideoLandingPageLink2Activity.this.ui, TTVideoLandingPageLink2Activity.this.Dfc, TTVideoLandingPageLink2Activity.this.GB);
            }
        });
        if (findViewById instanceof PAGLogoView) {
            ((PAGLogoView) findViewById).initData(this.Dfc);
        }
        if (this.eli != null && this.eli.getWebView() != null) {
            dZ.eli(this.Dfc, this.eli);
        }
        boolean QX = dV.aGH().QX();
        this.tLO = QX;
        if (QX) {
            ((com.bytedance.sdk.openadsdk.common.nn) findViewById(com.bytedance.sdk.openadsdk.utils.aqO.Yw)).setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) findViewById(com.bytedance.sdk.openadsdk.utils.aqO.eEH);
            this.Mc = linearLayout;
            linearLayout.setVisibility(8);
            tTVideoLandingPageLink2Activity = this;
            tTVideoLandingPageLink2Activity.gHb = new aqO(tTVideoLandingPageLink2Activity, this.Mc, this.eli, this.Dfc, "landingpage_split_screen");
            if (tTVideoLandingPageLink2Activity.eli.getWebView() != null) {
                tTVideoLandingPageLink2Activity.eli.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.14
                    float eli = 0.0f;

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            this.eli = motionEvent.getY();
                        }
                        if (TTVideoLandingPageLink2Activity.this.dZ != null) {
                            TTVideoLandingPageLink2Activity.this.dZ.eli(motionEvent);
                        }
                        if (TTVideoLandingPageLink2Activity.this.DE != null) {
                            TTVideoLandingPageLink2Activity.this.DE.eli(motionEvent);
                        }
                        if (motionEvent.getAction() == 2) {
                            float y = motionEvent.getY();
                            float f = this.eli;
                            if (y - f > 8.0f) {
                                if (TTVideoLandingPageLink2Activity.this.gHb != null) {
                                    TTVideoLandingPageLink2Activity.this.gHb.eli();
                                }
                                return false;
                            }
                            if (y - f < -8.0f && TTVideoLandingPageLink2Activity.this.gHb != null) {
                                TTVideoLandingPageLink2Activity.this.gHb.DbA();
                            }
                        }
                        return false;
                    }
                });
            }
        } else {
            tTVideoLandingPageLink2Activity = this;
            if (tTVideoLandingPageLink2Activity.eli.getWebView() != null) {
                tTVideoLandingPageLink2Activity.eli.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.2
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (TTVideoLandingPageLink2Activity.this.dZ != null) {
                            TTVideoLandingPageLink2Activity.this.dZ.eli(motionEvent);
                        }
                        if (TTVideoLandingPageLink2Activity.this.DE == null) {
                            return false;
                        }
                        TTVideoLandingPageLink2Activity.this.DE.eli(motionEvent);
                        return false;
                    }
                });
            }
        }
        nlS nls = tTVideoLandingPageLink2Activity.QI;
        if (nls != null) {
            nls.eli(tTVideoLandingPageLink2Activity.Dfc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dfc() {
        com.bytedance.sdk.openadsdk.aGH.Os.eli(this.Dfc, "landingpage_split_screen", "click_video", (JSONObject) null);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        nlS nls = this.QI;
        if (nls != null) {
            nls.eli();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected void MGA() {
        if (kb()) {
            super.MGA();
            if (this.NU != null) {
                if (this.NU.getNativeVideoController() != null) {
                    this.NU.getNativeVideoController().eli(false);
                    this.NU.getNativeVideoController().MGA(false);
                    this.du.setClickable(true);
                    this.du.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.3
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() != 0) {
                                return false;
                            }
                            TTVideoLandingPageLink2Activity.this.Dfc();
                            return false;
                        }
                    });
                }
                this.NU.getNativeVideoController().eli(new Os.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.4
                    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
                    public void DbA(long j, int i) {
                    }

                    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
                    public void eli() {
                    }

                    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
                    public void eli(long j, int i) {
                    }

                    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
                    public void eli(long j, long j2) {
                        if (TTVideoLandingPageLink2Activity.this.Yw != null) {
                            int max = (int) Math.max(0L, (j2 - j) / 1000);
                            TTVideoLandingPageLink2Activity.this.Yw.setText(String.valueOf(max));
                            if (max <= 0) {
                                TTVideoLandingPageLink2Activity.this.Yw.setVisibility(8);
                            }
                        }
                    }
                });
                return;
            }
            return;
        }
        try {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.Dfc.an().get(0), imageView, this.Dfc);
            this.du.setVisibility(0);
            this.du.removeAllViews();
            this.du.addView(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.bytedance.sdk.openadsdk.aGH.Os.DbA(TTVideoLandingPageLink2Activity.this.Dfc, "landingpage_split_screen");
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected boolean kb() {
        return this.nlS == 5 || this.nlS == 15 || this.nlS == 50;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    public void du() {
        super.du();
        if (this.Dfc != null) {
            this.Dfc.aAs(true);
        }
        TextView textView = this.qyC;
        if (textView != null) {
            textView.setText(aGH());
            this.qyC.setClickable(true);
            this.qyC.setOnClickListener(this.ikX);
            this.qyC.setOnTouchListener(this.ikX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqO() {
        nlS nls = this.QI;
        if (nls != null) {
            nls.DbA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        aqO();
        if (!this.rQ && this.dZ != null && this.eli != null && this.QI.getVisibility() == 8) {
            this.dZ.eli(this.eli);
        }
        super.onDestroy();
    }

    private void dV() {
        TTAdDislikeToast tTAdDislikeToast = this.WfR;
        if (tTAdDislikeToast == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeTip());
    }

    protected void nn() {
        if (isFinishing()) {
            return;
        }
        if (this.TfR.get()) {
            dV();
            return;
        }
        if (this.tGZ == null) {
            nGm();
        }
        Dfc dfc = this.tGZ;
        if (dfc != null) {
            dfc.eli();
        }
    }

    private void nGm() {
        try {
            if (this.tGZ == null) {
                Dfc dfc = new Dfc(this.ui, this.Dfc);
                this.tGZ = dfc;
                dfc.setDislikeSource("landing_page");
                this.tGZ.setCallback(new Dfc.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.6
                    @Override // com.bytedance.sdk.openadsdk.common.Dfc.eli
                    public void eli(View view) {
                        TTVideoLandingPageLink2Activity.this.ow.set(true);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.Dfc.eli
                    public void DbA(View view) {
                        TTVideoLandingPageLink2Activity.this.ow.set(false);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.Dfc.eli
                    public void eli(FilterWord filterWord) {
                        if (TTVideoLandingPageLink2Activity.this.TfR.get() || filterWord == null || filterWord.hasSecondOptions()) {
                            return;
                        }
                        TTVideoLandingPageLink2Activity.this.TfR.set(true);
                        TTVideoLandingPageLink2Activity.this.QX();
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
            frameLayout.addView(this.tGZ);
            if (this.WfR == null) {
                TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this.ui);
                this.WfR = tTAdDislikeToast;
                frameLayout.addView(tTAdDislikeToast);
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("initDislike error", "TTVideoLandingPageLink2Activity", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QX() {
        TTAdDislikeToast tTAdDislikeToast;
        if (isFinishing() || (tTAdDislikeToast = this.WfR) == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
    }
}
