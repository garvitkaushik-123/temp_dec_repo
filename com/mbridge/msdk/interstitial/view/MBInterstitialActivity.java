package com.mbridge.msdk.interstitial.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdError;
import com.ironsource.C3040d4;
import com.mbridge.msdk.activity.MBBaseActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.interstitial.controller.a;
import com.mbridge.msdk.mbsignalcommon.mraid.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import io.bidmachine.rendering.model.EventTaskParams;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MBInterstitialActivity extends MBBaseActivity implements com.mbridge.msdk.mbsignalcommon.mraid.b {
    public static final String INTENT_CAMAPIGN = "campaign";
    public static final String INTENT_UNIT_ID = "unitId";
    public static final long WATI_JS_INVOKE = 2000;
    public static final long WEB_LOAD_TIME = 15000;
    private CampaignEx h;
    private WindVaneWebView i;
    private ImageView j;
    private a.d k;
    private boolean l;
    private com.mbridge.msdk.mbsignalcommon.mraid.d m;
    public ProgressBar mProgressBar;
    public String mUnitid;
    private long n;
    private boolean o;
    private boolean p;
    private com.mbridge.msdk.click.a t;
    private boolean f = false;
    private boolean g = false;
    public boolean mIsMBPage = false;
    private Handler q = new f();
    Runnable r = new j();
    Runnable s = new k();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgressBar progressBar = MBInterstitialActivity.this.mProgressBar;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgressBar progressBar = MBInterstitialActivity.this.mProgressBar;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }
    }

    class c implements NativeListener.NativeTrackingListener {
        c() {
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDismissLoading(Campaign campaign) {
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadFinish(Campaign campaign) {
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadProgress(int i) {
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadStart(Campaign campaign) {
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            try {
                MBInterstitialActivity.this.hideLoading();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public boolean onInterceptDefaultLoadingDialog() {
            return false;
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            MBInterstitialActivity.this.hideLoading();
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onShowLoading(Campaign campaign) {
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            try {
                MBInterstitialActivity.this.showLoading();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(MBInterstitialActivity.this.i, MBInterstitialActivity.this.i.getLeft(), MBInterstitialActivity.this.i.getTop(), MBInterstitialActivity.this.i.getWidth(), MBInterstitialActivity.this.i.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(MBInterstitialActivity.this.i, MBInterstitialActivity.this.i.getLeft(), MBInterstitialActivity.this.i.getTop(), MBInterstitialActivity.this.i.getWidth(), MBInterstitialActivity.this.i.getHeight());
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(MBInterstitialActivity.this)).b(MBInterstitialActivity.this.h.getId());
        }
    }

    class f extends Handler {
        f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBInterstitialActivity.this.finish();
        }
    }

    class i extends com.mbridge.msdk.mbsignalcommon.listener.b {
        i() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i) {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            MBInterstitialActivity.this.l = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str, Bitmap bitmap) {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void b(WebView webView, int i) {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public boolean b(WebView webView, String str) {
            return true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void c(WebView webView, int i) {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i, String str, String str2) {
            try {
                MBInterstitialActivity.this.l = true;
                if (MBInterstitialActivity.this.k != null) {
                    MBInterstitialActivity.this.k.a(str);
                }
                MBInterstitialActivity.this.a(3, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            try {
                if (MBInterstitialActivity.this.l) {
                    return;
                }
                MBInterstitialActivity.this.a(1, "");
                MBInterstitialActivity mBInterstitialActivity = MBInterstitialActivity.this;
                if (mBInterstitialActivity.r != null && mBInterstitialActivity.q != null) {
                    MBInterstitialActivity.this.q.removeCallbacks(MBInterstitialActivity.this.r);
                }
                if (MBInterstitialActivity.this.k != null) {
                    MBInterstitialActivity.this.k.c();
                }
                MBInterstitialActivity mBInterstitialActivity2 = MBInterstitialActivity.this;
                if (!mBInterstitialActivity2.mIsMBPage) {
                    mBInterstitialActivity2.q.postDelayed(MBInterstitialActivity.this.s, 2000L);
                }
                MBInterstitialActivity.this.i();
            } catch (Exception e) {
                e.printStackTrace();
                if (MBInterstitialActivity.this.k != null) {
                    MBInterstitialActivity.this.k.a("load page failed");
                }
            }
        }
    }

    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBInterstitialActivity.this.g) {
                return;
            }
            MBInterstitialActivity.this.f = true;
            if (MBInterstitialActivity.this.k != null) {
                MBInterstitialActivity.this.k.a("load page timeout");
                if (MBInterstitialActivity.this.i != null) {
                    MBInterstitialActivity.this.i.setVisibility(8);
                    MBInterstitialActivity.this.i.setWebViewListener(null);
                    MBInterstitialActivity.this.i.release();
                }
                MBInterstitialActivity.this.hideLoading();
            }
        }
    }

    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MBInterstitialActivity mBInterstitialActivity = MBInterstitialActivity.this;
            if (mBInterstitialActivity.mIsMBPage) {
                return;
            }
            if (mBInterstitialActivity.h != null && MBInterstitialActivity.this.h.isMraid()) {
                MBInterstitialActivity.this.m();
            }
            com.mbridge.msdk.interstitial.cache.a.a().a(MBInterstitialActivity.this.h, MBInterstitialActivity.this.mUnitid);
            if (MBInterstitialActivity.this.f) {
                return;
            }
            MBInterstitialActivity.this.g = true;
            MBInterstitialActivity.this.hideLoading();
            MBInterstitialActivity.this.showWebView();
        }
    }

    class l implements d.b {
        l() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.d.b
        public void a(double d) {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(MBInterstitialActivity.this.i, d);
        }
    }

    class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (MBInterstitialActivity.this.i != null && MBInterstitialActivity.this.h != null) {
                    MBInterstitialActivity.this.i.setVisibility(0);
                    if (MBInterstitialActivity.this.h.isMraid()) {
                        MBInterstitialActivity.this.k();
                    }
                    MBInterstitialActivity.this.j();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBInterstitialActivity.this.i != null) {
                MBInterstitialActivity.this.i.setVisibility(8);
            }
        }
    }

    private void l() {
        com.mbridge.msdk.foundation.same.report.h hVar = new com.mbridge.msdk.foundation.same.report.h(getApplicationContext());
        CampaignEx campaignEx = this.h;
        if (campaignEx != null) {
            hVar.b(campaignEx.getRequestId(), this.h.getRequestIdNotice(), this.h.getId(), this.mUnitid, com.mbridge.msdk.mbsignalcommon.mraid.c.b(this.h.getId()), this.h.isBidCampaign());
            com.mbridge.msdk.mbsignalcommon.mraid.c.a(this.h.getId());
            this.o = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        List<String> pv_urls;
        try {
            com.mbridge.msdk.foundation.controller.c.m().a(this);
            if (!TextUtils.isEmpty(this.h.getImpressionURL())) {
                Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
                CampaignEx campaignEx = this.h;
                com.mbridge.msdk.click.a.a(d2, campaignEx, this.mUnitid, campaignEx.getImpressionURL(), false, true, com.mbridge.msdk.click.retry.a.m);
            }
            if (!TextUtils.isEmpty(this.h.getOnlyImpressionURL())) {
                Context d3 = com.mbridge.msdk.foundation.controller.c.m().d();
                CampaignEx campaignEx2 = this.h;
                com.mbridge.msdk.click.a.a(d3, campaignEx2, this.mUnitid, campaignEx2.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.retry.a.n);
            }
            com.mbridge.msdk.foundation.same.buffer.b.a(this.mUnitid, this.h, "interstitial");
            e eVar = new e();
            if (com.mbridge.msdk.foundation.controller.d.a().e()) {
                com.mbridge.msdk.foundation.same.threadpool.a.b().execute(eVar);
            } else {
                eVar.run();
            }
            CampaignEx campaignEx3 = this.h;
            if (campaignEx3 == null || (pv_urls = campaignEx3.getPv_urls()) == null || pv_urls.size() <= 0) {
                return;
            }
            Iterator<String> it = pv_urls.iterator();
            while (it.hasNext()) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.h, this.mUnitid, it.next(), false, true);
            }
        } catch (Throwable th) {
            p0.a("MBInterstitialActivity", th.getMessage());
        }
    }

    private void n() {
        CampaignEx campaignEx;
        this.j.setOnClickListener(new h());
        if (this.i == null || (campaignEx = this.h) == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.webview.a aVar = new com.mbridge.msdk.foundation.same.webview.a(campaignEx);
        aVar.a(this.h.getAppName());
        this.i.setCampaignId(this.h.getId());
        this.i.setDownloadListener(aVar);
    }

    public void clickTracking() {
        try {
            if (this.h != null && !z0.a(this.mUnitid)) {
                onIntersClick();
                com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(getApplicationContext(), this.mUnitid);
                this.t = aVar;
                aVar.a(new c());
                this.t.a(this.h);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        finish();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z) {
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (!this.o) {
            l();
        }
        if (this.p) {
            return;
        }
        reportPlayableClosed();
    }

    public com.mbridge.msdk.setting.l getIntersUnitSetting() {
        try {
            if (TextUtils.isEmpty(this.mUnitid)) {
                return null;
            }
            com.mbridge.msdk.setting.l e2 = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), this.mUnitid);
            return e2 == null ? com.mbridge.msdk.setting.l.h(this.mUnitid) : e2;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public CampaignEx getMraidCampaign() {
        return this.h;
    }

    public void goneWebView() {
        try {
            runOnUiThread(new n());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void hideLoading() {
        try {
            runOnUiThread(new b());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void initView() {
        this.i = (WindVaneWebView) findViewById(h0.a(getApplicationContext(), "mbridge_interstitial_wv", "id"));
        this.mProgressBar = (ProgressBar) findViewById(h0.a(getApplicationContext(), "mbridge_interstitial_pb", "id"));
        this.j = (ImageView) findViewById(h0.a(getApplicationContext(), "mbridge_interstitial_iv_close", "id"));
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int a2;
        super.onCreate(bundle);
        try {
            a2 = h0.a(getApplicationContext(), "mbridge_interstitial_activity", "layout");
        } catch (Exception e2) {
            e = e2;
        }
        try {
            if (!h0.a(a2)) {
                g();
                f();
                a.d dVar = this.k;
                if (dVar != null) {
                    dVar.a("not found resource");
                }
                finish();
                return;
            }
            setContentView(a2);
            initView();
            e();
            com.mbridge.msdk.foundation.controller.c.m().a(this);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.mUnitid, this, (ViewGroup) null, (ViewGroup.LayoutParams) null, new g());
            this.h.setCampaignUnitId(this.mUnitid);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.mUnitid, this.h);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            a.d dVar = this.k;
            if (dVar != null) {
                dVar.b();
            }
            com.mbridge.msdk.click.a aVar = this.t;
            if (aVar != null) {
                aVar.a(false);
                this.t.a((NativeListener.NativeTrackingListener) null);
                this.t.c();
            }
            com.mbridge.msdk.mbsignalcommon.mraid.d dVar2 = this.m;
            if (dVar2 != null) {
                dVar2.d();
            }
            if (!this.o) {
                l();
            }
            if (com.mbridge.msdk.interstitial.controller.a.r != null && !TextUtils.isEmpty(this.mUnitid)) {
                com.mbridge.msdk.interstitial.controller.a.r.remove(this.mUnitid);
            }
            this.k = null;
            com.mbridge.msdk.foundation.feedback.b.b().d(this.mUnitid);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onIntersClick() {
        try {
            a.d dVar = this.k;
            if (dVar != null) {
                dVar.a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        CampaignEx campaignEx = this.h;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(this.i, "false");
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CampaignEx campaignEx = this.h;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(this.i, "true");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.h.setClickURL(str);
            a(str);
        }
        this.h.setClickTempSource(2);
        this.h.setClickType(2);
        this.h.setTriggerClickSource(2);
        clickTracking();
    }

    public void reportPlayableClosed() {
        if (this.h != null) {
            com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n("2000061", this.h.getId(), this.h.getRequestId(), this.h.getRequestIdNotice(), this.mUnitid, l0.s(com.mbridge.msdk.foundation.controller.c.m().d()));
            nVar.b(this.h.isMraid() ? com.mbridge.msdk.foundation.entity.n.N : com.mbridge.msdk.foundation.entity.n.O);
            com.mbridge.msdk.foundation.same.report.g.b(nVar, com.mbridge.msdk.foundation.controller.c.m().d(), this.mUnitid);
            this.p = true;
        }
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity
    public void setTopControllerPadding(int i2, int i3, int i4, int i5, int i6) {
        int a2 = u0.a(this, 10.0f);
        if (i3 <= 0) {
            i3 = a2;
        }
        if (i4 <= 0) {
            i4 = a2;
        }
        if (i5 <= 0) {
            i5 = a2;
        }
        if (i6 <= 0) {
            i6 = a2;
        }
        if (this.j != null) {
            int a3 = u0.a(this, 25.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a3, a3);
            layoutParams.addRule(11);
            layoutParams.setMargins(i3, i5, i4, i6);
            this.j.setLayoutParams(layoutParams);
        }
    }

    public void showLoading() {
        try {
            runOnUiThread(new a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void showWebView() {
        runOnUiThread(new m());
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void useCustomClose(boolean z) {
        if (z) {
            this.j.setImageDrawable(new ColorDrawable(0));
        } else {
            this.j.setImageResource(h0.a(getApplicationContext(), "mbridge_interstitial_close", "drawable"));
        }
    }

    private void e() {
        g();
        n();
        f();
        h();
    }

    private void f() {
        try {
            if (com.mbridge.msdk.interstitial.controller.a.r == null || TextUtils.isEmpty(this.mUnitid) || !com.mbridge.msdk.interstitial.controller.a.r.containsKey(this.mUnitid)) {
                return;
            }
            this.k = com.mbridge.msdk.interstitial.controller.a.r.get(this.mUnitid);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void g() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mUnitid = intent.getStringExtra("unitId");
            this.h = (CampaignEx) intent.getSerializableExtra("campaign");
        }
        CampaignEx campaignEx = this.h;
        if (campaignEx != null && campaignEx.isMraid()) {
            com.mbridge.msdk.mbsignalcommon.mraid.d dVar = new com.mbridge.msdk.mbsignalcommon.mraid.d(this);
            this.m = dVar;
            dVar.c();
            this.m.a(new l());
        }
        CampaignEx campaignEx2 = this.h;
        if (campaignEx2 != null) {
            com.mbridge.msdk.click.c.a(this, campaignEx2.getMaitve(), this.h.getMaitve_src());
        }
    }

    private void h() {
        try {
            CampaignEx campaignEx = this.h;
            if (campaignEx == null || (TextUtils.isEmpty(campaignEx.getHtmlUrl()) && !this.h.isMraid())) {
                a.d dVar = this.k;
                if (dVar != null) {
                    dVar.a("htmlurl is null");
                    return;
                }
                return;
            }
            p0.c("MBInterstitialActivity", "url:" + this.h.getHtmlUrl());
            goneWebView();
            this.i.setWebViewListener(new i());
            String htmlUrl = this.h.getHtmlUrl();
            if (this.h.isMraid()) {
                File file = new File(this.h.getMraid());
                if (file.exists() && file.isFile() && file.canRead()) {
                    htmlUrl = "file:////" + this.h.getMraid();
                }
            }
            this.n = System.currentTimeMillis();
            this.i.loadUrl(htmlUrl);
            this.q.postDelayed(this.r, 15000L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        CampaignEx campaignEx = this.h;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        int i2 = getResources().getConfiguration().orientation;
        String str = i2 != 0 ? i2 != 1 ? i2 != 2 ? "UNDEFINED" : C3040d4.h.C : C3040d4.h.D : AdError.UNDEFINED_DOMAIN;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        float n2 = l0.n(this);
        float m2 = l0.m(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float f2 = displayMetrics.widthPixels;
        float f3 = displayMetrics.heightPixels;
        HashMap hashMap = new HashMap();
        hashMap.put("placementType", "Interstitial");
        hashMap.put("state", EventTaskParams.STATE_GROUP_DEFAULT);
        hashMap.put("viewable", "true");
        hashMap.put("currentAppOrientation", jSONObject);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.i, n2, m2);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.i, f2, f3);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.i, hashMap);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.i, this.m.a());
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        CampaignEx campaignEx = this.h;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        this.i.post(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n();
            nVar.n(this.h.getRequestId());
            nVar.o(this.h.getRequestIdNotice());
            nVar.b(this.h.getId());
            nVar.b(this.h.isMraid() ? com.mbridge.msdk.foundation.entity.n.N : com.mbridge.msdk.foundation.entity.n.O);
            com.mbridge.msdk.foundation.same.report.g.d(nVar, getApplicationContext(), this.mUnitid);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        CampaignEx campaignEx = this.h;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n();
        nVar.n(this.h.getRequestId());
        nVar.o(this.h.getRequestIdNotice());
        nVar.b(this.h.getId());
        nVar.d(i2);
        nVar.e(String.valueOf(System.currentTimeMillis() - this.n));
        nVar.g("");
        nVar.m(str);
        nVar.a(CampaignEx.CLICKMODE_ON);
        nVar.b(this.h.isMraid() ? com.mbridge.msdk.foundation.entity.n.N : com.mbridge.msdk.foundation.entity.n.O);
        com.mbridge.msdk.foundation.same.report.g.b(nVar, this.mUnitid, this.h);
    }

    class g implements com.mbridge.msdk.foundation.feedback.a {
        g() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            String str;
            MBInterstitialActivity.this.onPause();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                p0.b("MBInterstitialActivity", th.getMessage(), th);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBInterstitialActivity.this.i, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            String str;
            MBInterstitialActivity.this.onResume();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                p0.b("MBInterstitialActivity", th.getMessage(), th);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBInterstitialActivity.this.i, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            String str2;
            MBInterstitialActivity.this.onResume();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 2);
                }
                str2 = jSONObject.toString();
            } catch (Throwable th) {
                p0.b("MBInterstitialActivity", th.getMessage(), th);
                str2 = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBInterstitialActivity.this.i, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
        }
    }

    private void a(String str) {
        CampaignEx mraidCampaign = getMraidCampaign();
        if (mraidCampaign != null) {
            new com.mbridge.msdk.foundation.same.report.h(getApplicationContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.mUnitid, str, mraidCampaign.isBidCampaign());
        }
    }
}
