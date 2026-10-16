package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.FC.MGA;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.dV;
import com.bytedance.sdk.openadsdk.core.Ue;
import com.bytedance.sdk.openadsdk.core.cyF;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;
import com.bytedance.sdk.openadsdk.utils.du;
import com.google.common.net.HttpHeaders;
import java.net.URLEncoder;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class TTWebsiteActivity extends TTBaseActivity {
    private dV DbA;
    private WebView Os;
    private String eli = null;

    public static void eli(Context context, ev evVar, String str) {
        if (context == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), evVar, str, "open_policy");
        if (TextUtils.isEmpty(evVar.EM().Os())) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) TTWebsiteActivity.class);
        if (evVar != null) {
            if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                intent.putExtra("_extra_meta", evVar.QYI().toString());
                intent.putExtra("_extra_glo_d", evVar.ev());
                intent.putExtra("_privacy_url", evVar.EM().Os());
                intent.putExtra("_privacy_title", evVar.EM().aGH());
            } else {
                intent.putExtra("meta_index", Ue.eli().eli(evVar));
            }
        }
        com.bytedance.sdk.component.utils.DbA.eli(context, intent, null);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        String aGH;
        String str;
        String str2;
        ev evVar;
        String str3;
        super.onCreate(bundle);
        com.bytedance.sdk.openadsdk.core.dV.DbA(getApplicationContext());
        if (!nn.ui()) {
            finish();
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            str3 = getIntent().getStringExtra("_extra_meta");
            String stringExtra = getIntent().getStringExtra("_extra_glo_d");
            String stringExtra2 = getIntent().getStringExtra("_privacy_url");
            aGH = getIntent().getStringExtra("_privacy_title");
            str = stringExtra2;
            str2 = stringExtra;
            evVar = null;
        } else {
            ev eli = Ue.eli().eli(Ue.eli(getIntent()));
            if (eli == null) {
                finish();
                return;
            }
            String ev = eli.ev();
            String Os = eli.EM().Os();
            aGH = eli.EM().aGH();
            str = Os;
            str2 = ev;
            evVar = eli;
            str3 = null;
        }
        if (TextUtils.isEmpty(str)) {
            finish();
            return;
        }
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(this);
        if (Build.VERSION.SDK_INT >= 35) {
            uiVar.setFitsSystemWindows(true);
        }
        uiVar.setBackgroundColor(-1);
        uiVar.setId(520093726);
        uiVar.setOrientation(1);
        uiVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        try {
            setContentView(uiVar);
            int DbA = SSo.DbA(this, 5.0f);
            int DbA2 = SSo.DbA(this, 8.0f);
            int DbA3 = SSo.DbA(this, 10.0f);
            int DbA4 = SSo.DbA(this, 12.0f);
            int DbA5 = SSo.DbA(this, 14.0f);
            int DbA6 = SSo.DbA(this, 20.0f);
            int DbA7 = SSo.DbA(this, 24.0f);
            int DbA8 = SSo.DbA(this, 40.0f);
            int DbA9 = SSo.DbA(this, 44.0f);
            String str4 = str2;
            int DbA10 = SSo.DbA(this, 191.0f);
            String str5 = str;
            com.bytedance.sdk.openadsdk.core.ui.kb kbVar = new com.bytedance.sdk.openadsdk.core.ui.kb(this);
            final String str6 = str3;
            kbVar.setGravity(15);
            final ev evVar2 = evVar;
            kbVar.setLayoutParams(new LinearLayout.LayoutParams(-1, DbA9));
            com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(this);
            agh.setId(520093720);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DbA8, DbA9);
            layoutParams.setMarginStart(DbA2);
            agh.setLayoutParams(layoutParams);
            agh.setClickable(true);
            agh.setFocusable(true);
            agh.setPadding(DbA5, DbA4, DbA5, DbA4);
            agh.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(this, "tt_ad_arrow_backward"));
            final com.bytedance.sdk.openadsdk.core.ui.aGH agh2 = new com.bytedance.sdk.openadsdk.core.ui.aGH(this);
            String str7 = aGH;
            agh2.setId(520093716);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(DbA8, DbA9);
            layoutParams2.addRule(17, 520093720);
            agh2.setLayoutParams(layoutParams2);
            agh2.setClickable(true);
            agh2.setFocusable(true);
            agh2.setPadding(DbA4, DbA5, DbA4, DbA5);
            agh2.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(this, "tt_ad_xmark"));
            com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(this);
            wCVar.setId(aqO.Kp);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(DbA10, DbA7);
            layoutParams3.setMarginStart(DbA);
            layoutParams3.addRule(15);
            layoutParams3.addRule(16, 520093741);
            layoutParams3.addRule(17, 520093716);
            wCVar.setLayoutParams(layoutParams3);
            wCVar.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            wCVar.setGravity(17);
            wCVar.setSingleLine(true);
            wCVar.setTextColor(Color.parseColor("#222222"));
            wCVar.setTextSize(17.0f);
            com.bytedance.sdk.openadsdk.core.ui.aGH agh3 = new com.bytedance.sdk.openadsdk.core.ui.aGH(this);
            agh3.setId(520093741);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(DbA8, DbA9);
            layoutParams4.addRule(16, 520093742);
            agh3.setLayoutParams(layoutParams4);
            agh3.setPadding(DbA3, DbA4, DbA3, DbA4);
            agh3.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(this, "tt_ad_link"));
            com.bytedance.sdk.openadsdk.core.ui.aGH agh4 = new com.bytedance.sdk.openadsdk.core.ui.aGH(this);
            agh4.setId(520093742);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(DbA8, DbA9);
            layoutParams5.addRule(21);
            layoutParams5.setMarginEnd(DbA2);
            agh4.setLayoutParams(layoutParams5);
            agh4.setPadding(DbA4, DbA6, DbA4, DbA6);
            agh4.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(this, "tt_ad_threedots"));
            final com.bytedance.sdk.openadsdk.core.ui.MGA mga = new com.bytedance.sdk.openadsdk.core.ui.MGA(this, null, R.style.Widget.ProgressBar.Horizontal);
            mga.setId(520093743);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, SSo.DbA(this, 2.0f));
            layoutParams6.addRule(12);
            mga.setLayoutParams(layoutParams6);
            mga.setProgress(1);
            mga.setProgressDrawable(du.eli(this, "tt_privacy_progress_style"));
            View view = new View(this);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, SSo.DbA(this, 1.0f));
            layoutParams7.addRule(12);
            view.setLayoutParams(layoutParams7);
            kbVar.addView(agh);
            kbVar.addView(agh2);
            kbVar.addView(wCVar);
            kbVar.addView(agh3);
            kbVar.addView(agh4);
            kbVar.addView(mga);
            kbVar.addView(view);
            uiVar.addView(kbVar);
            try {
                WebView webView = new WebView(getApplicationContext());
                this.Os = webView;
                webView.setBackgroundColor(-1);
                uiVar.addView(this.Os, new ViewGroup.LayoutParams(-1, -1));
                agh.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TTWebsiteActivity.this.Os.canGoBack()) {
                            TTWebsiteActivity.this.Os.goBack();
                        } else {
                            TTWebsiteActivity.this.finish();
                        }
                    }
                });
                agh2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TTWebsiteActivity.this.finish();
                    }
                });
                agh2.setVisibility(4);
                agh2.setClickable(false);
                if (!TextUtils.isEmpty(str7)) {
                    wCVar.setText(str7);
                }
                agh3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        String url = TTWebsiteActivity.this.Os.getUrl();
                        if (TextUtils.isEmpty(url)) {
                            return;
                        }
                        intent.setData(Uri.parse(url));
                        com.bytedance.sdk.component.utils.DbA.eli(TTWebsiteActivity.this, intent, null);
                    }
                });
                agh4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TTWebsiteActivity.this.DbA == null) {
                            TTWebsiteActivity.this.DbA = new dV(TTWebsiteActivity.this);
                            TTWebsiteActivity.this.DbA.eli(str6, evVar2);
                            TTWebsiteActivity.this.DbA.setCanceledOnTouchOutside(false);
                        }
                        TTWebsiteActivity.this.DbA.show();
                    }
                });
                this.eli = str5;
                if (!TextUtils.isEmpty(str4)) {
                    String encode = URLEncoder.encode(str4);
                    if (this.eli.contains("?")) {
                        this.eli += "&gdid_encrypted=" + encode;
                    } else {
                        this.eli += "?gdid_encrypted=" + encode;
                    }
                }
                if (this.eli != null) {
                    WebSettings settings = this.Os.getSettings();
                    settings.setMixedContentMode(0);
                    try {
                        settings.setJavaScriptEnabled(true);
                        settings.setDomStorageEnabled(true);
                        settings.setSavePassword(false);
                        settings.setAllowFileAccess(false);
                    } catch (Throwable unused) {
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(HttpHeaders.REFERER, TTAdConstant.REQUEST_HEAD_REFERER);
                    try {
                        this.Os.loadUrl(this.eli, hashMap);
                    } catch (Throwable unused2) {
                        this.Os.loadUrl(this.eli);
                    }
                    this.Os.setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.5
                        @Override // android.webkit.WebChromeClient
                        public void onProgressChanged(WebView webView2, int i) {
                            super.onProgressChanged(webView2, i);
                            if (mga == null || TTWebsiteActivity.this.isFinishing()) {
                                return;
                            }
                            if (i == 100) {
                                mga.setVisibility(8);
                                if (webView2.canGoBack()) {
                                    agh2.setVisibility(0);
                                    agh2.setClickable(true);
                                    return;
                                } else {
                                    agh2.setVisibility(4);
                                    agh2.setClickable(false);
                                    return;
                                }
                            }
                            mga.setVisibility(0);
                            mga.setProgress(i);
                        }
                    });
                    this.Os.setWebViewClient(new MGA.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.6
                        @Override // android.webkit.WebViewClient
                        public boolean shouldOverrideUrlLoading(WebView webView2, String str8) {
                            try {
                                Uri parse = Uri.parse(str8);
                                if (!nGm.eli(str8)) {
                                    try {
                                        Intent intent = new Intent("android.intent.action.VIEW");
                                        intent.setData(parse);
                                        intent.addFlags(268435456);
                                        com.bytedance.sdk.component.utils.DbA.eli(TTWebsiteActivity.this, intent, null);
                                        return true;
                                    } catch (Throwable unused3) {
                                        return true;
                                    }
                                }
                            } catch (Throwable unused4) {
                            }
                            return super.shouldOverrideUrlLoading(webView2, str8);
                        }

                        @Override // android.webkit.WebViewClient
                        public void onPageFinished(WebView webView2, String str8) {
                            super.onPageFinished(webView2, str8);
                        }

                        @Override // android.webkit.WebViewClient
                        public void onReceivedHttpError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                            super.onReceivedHttpError(webView2, webResourceRequest, webResourceResponse);
                            new StringBuilder("onReceivedHttpError invoke....errorResponse=").append(webResourceResponse);
                        }

                        @Override // android.webkit.WebViewClient
                        public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                            super.onReceivedError(webView2, webResourceRequest, webResourceError);
                            webResourceError.getErrorCode();
                        }

                        @Override // android.webkit.WebViewClient
                        public void onReceivedError(WebView webView2, int i, String str8, String str9) {
                            super.onReceivedError(webView2, i, str8, str9);
                        }
                    });
                    com.bytedance.sdk.openadsdk.core.widget.eli.Os.DbA(this.Os);
                    return;
                }
                finish();
            } catch (Exception e) {
                Xb.eli("TTAD.TTWebsiteActivity", "onCreate: ", e);
                finish();
            }
        } catch (Throwable unused3) {
            finish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        cyF.eli(this.Os);
        super.onDestroy();
    }
}
