package com.fyber.inneractive.sdk.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.d1;
import com.fyber.inneractive.sdk.util.m0;
import com.fyber.inneractive.sdk.util.t;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class FyberReportAdActivity extends InneractiveBaseActivity {
    public static com.fyber.inneractive.sdk.flow.h f;
    public WebView b;
    public String c;
    public String d;
    public String e;

    public static Intent createIntent(Context context, String str, String str2, Long l) {
        Intent intent = new Intent(context, (Class<?>) FyberReportAdActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        Bundle bundle = new Bundle();
        bundle.putString("advertiser_domain", str);
        bundle.putString("dsp_name", str2);
        bundle.putString("dsp_id", l != null ? Long.toString(l.longValue()) : null);
        intent.putExtras(bundle);
        return intent;
    }

    public static void disableWebviewZoomControls(WebView webView) {
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        new m0(webView).run();
    }

    public static com.fyber.inneractive.sdk.flow.h getAdReporter() {
        return f;
    }

    public static void start(Context context, com.fyber.inneractive.sdk.flow.h hVar, String str, String str2, Long l) {
        f = hVar;
        try {
            context.startActivity(createIntent(context, str, str2, l));
        } catch (Exception e) {
            IAlog.a("failed starting fyber report ad activity", e, new Object[0]);
        }
    }

    public final FrameLayout a() {
        WebView webView;
        FrameLayout frameLayout = new FrameLayout(this);
        try {
            webView = new WebView(IAConfigManager.O.v.a());
            webView.setWebViewClient(new a(this));
            webView.setId(R.id.ia_inneractive_webview_report_ad);
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            disableWebviewZoomControls(webView);
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.c)) {
                hashMap.put("advertiser_domain", this.c);
            }
            if (!TextUtils.isEmpty(this.d)) {
                hashMap.put("dsp_name", this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
                hashMap.put("dsp_id", this.e);
            }
            webView.loadUrl(d1.a("https://cdn2.inner-active.mobi/client/fyber-i-icon/index.html", hashMap));
        } catch (Exception unused) {
            IAlog.b("failed creating webivew for report ad", new Object[0]);
            finish();
            webView = null;
        }
        this.b = webView;
        frameLayout.addView(webView, -1, -1);
        return frameLayout;
    }

    public String getAdDomain() {
        return this.c;
    }

    public String getAdNetwork() {
        return this.d;
    }

    public String getAdNetworkId() {
        return this.e;
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        getWindow().addFlags(1024);
        super.onCreate(bundle);
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.c = extras.getString("advertiser_domain");
                this.d = extras.getString("dsp_name");
                this.e = extras.getString("dsp_id");
            }
            setContentView(a());
        } catch (Exception e) {
            IAlog.a("failed creating fyber report ad activity", e, new Object[0]);
            finish();
        }
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveBaseActivity, android.app.Activity
    public void onDestroy() {
        WebView webView = this.b;
        if (webView != null) {
            webView.removeAllViews();
            t.a(this.b);
            this.b.destroy();
            this.b = null;
        }
        f = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setVisible(false);
    }
}
