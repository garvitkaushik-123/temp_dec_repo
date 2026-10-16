package com.mbridge.msdk.video.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdError;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.a1;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.Campaign;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.rendering.model.EventTaskParams;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MBridgeH5EndCardView extends MBridgeH5EndCardViewDiff {
    private int A;
    private long B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private String K;
    Handler L;
    private boolean M;
    private boolean N;
    boolean O;
    protected View m;
    protected RelativeLayout n;
    protected ImageView o;
    protected WindVaneWebView p;
    private boolean q;
    protected Handler r;
    protected String s;
    protected boolean t;
    protected boolean u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;
    private boolean z;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 100) {
                return;
            }
            if (MBridgeH5EndCardView.this.C) {
                MBridgeH5EndCardView.this.notifyListener.a(Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, "");
            }
            MBridgeH5EndCardView.this.notifyListener.a(103, "");
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeH5EndCardView.this.onCloseViewClick();
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            try {
                p0.a(MBridgeBaseView.TAG, "webviewshow");
                try {
                    int[] iArr = new int[2];
                    MBridgeH5EndCardView.this.p.getLocationOnScreen(iArr);
                    p0.b(MBridgeBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                    JSONObject jSONObject = new JSONObject();
                    Context d = com.mbridge.msdk.foundation.controller.c.m().d();
                    if (d != null) {
                        jSONObject.put("startX", u0.b(d, iArr[0]));
                        jSONObject.put("startY", u0.b(d, iArr[1]));
                        jSONObject.put(com.mbridge.msdk.foundation.same.a.l, u0.d(d));
                    }
                    str = jSONObject.toString();
                } catch (Throwable th) {
                    p0.b(MBridgeBaseView.TAG, th.getMessage(), th);
                    str = "";
                }
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeH5EndCardView.this.p, "webviewshow", Base64.encodeToString(str.toString().getBytes(), 2));
                MBridgeH5EndCardView.this.notifyListener.a(109, "");
                MBridgeH5EndCardView.this.i();
                MBridgeH5EndCardView.this.startCounterEndCardShowTimer();
                com.mbridge.msdk.mbsignalcommon.windvane.f a2 = com.mbridge.msdk.mbsignalcommon.windvane.f.a();
                MBridgeH5EndCardView mBridgeH5EndCardView = MBridgeH5EndCardView.this;
                a2.a((WebView) mBridgeH5EndCardView.p, "oncutoutfetched", Base64.encodeToString(mBridgeH5EndCardView.K.getBytes(), 0));
                MBridgeH5EndCardView.this.e();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeH5EndCardView f5100a;

        public f(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f5100a = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Handler handler;
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                p0.b("CloseRunnable", e.getMessage());
            }
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f5100a;
            if (mBridgeH5EndCardView == null || (handler = mBridgeH5EndCardView.L) == null) {
                return;
            }
            handler.sendEmptyMessage(100);
        }
    }

    private class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeH5EndCardView f5101a;

        public g(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f5101a = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f5101a;
            if (mBridgeH5EndCardView == null || mBridgeH5EndCardView.z) {
                return;
            }
            this.f5101a.z = true;
            this.f5101a.t = false;
            MBridgeH5EndCardView.this.reportRenderResult("timeout", 5);
            this.f5101a.notifyListener.a(127, "");
            p0.a(MBridgeBaseView.TAG, "notify TYPE_NOTIFY_SHOW_NATIVE_ENDCARD");
        }
    }

    private static class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeH5EndCardView f5102a;
        private int b;

        public h(MBridgeH5EndCardView mBridgeH5EndCardView, int i) {
            this.f5102a = mBridgeH5EndCardView;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f5102a;
            if (mBridgeH5EndCardView == null || mBridgeH5EndCardView.b == null) {
                return;
            }
            try {
                if (mBridgeH5EndCardView.y) {
                    p0.c(MBridgeBaseView.TAG, "insertEndCardReadyState hasInsertLoadEndCardReport true return");
                    return;
                }
                this.f5102a.y = true;
                n nVar = new n("m_download_end", 12, (this.b * 1000) + "", this.f5102a.b.getendcard_url(), this.f5102a.b.getId(), this.f5102a.unitId, "ready timeout", (z0.b(this.f5102a.b.getendcard_url()) && this.f5102a.b.getendcard_url().contains(".zip")) ? "1" : "2");
                try {
                    if (this.f5102a.b.getAdType() == 287) {
                        nVar.a("3");
                    } else if (this.f5102a.b.getAdType() == 94) {
                        nVar.a("1");
                    } else if (this.f5102a.b.getAdType() == 42) {
                        nVar.a("2");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                nVar.n(this.f5102a.b.getRequestId());
                nVar.k(this.f5102a.b.getCurrentLocalRid());
                nVar.o(this.f5102a.b.getRequestIdNotice());
                nVar.a(this.f5102a.b.getAdSpaceT());
                this.f5102a.isLoadSuccess();
            } catch (Throwable th) {
                p0.b(MBridgeBaseView.TAG, th.getMessage(), th);
            }
        }
    }

    private class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeH5EndCardView f5103a;

        public i(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f5103a = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f5103a;
            if (mBridgeH5EndCardView != null) {
                mBridgeH5EndCardView.G = true;
            }
        }
    }

    private class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeH5EndCardView f5104a;

        public j(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f5104a = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f5104a;
            if (mBridgeH5EndCardView != null) {
                mBridgeH5EndCardView.H = true;
            }
        }
    }

    private class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeH5EndCardView f5105a;

        public k(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f5105a = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f5105a;
            if (mBridgeH5EndCardView != null) {
                if (!mBridgeH5EndCardView.I) {
                    MBridgeH5EndCardView.this.setCloseVisible(0);
                }
                this.f5105a.D = true;
            }
        }
    }

    public MBridgeH5EndCardView(Context context) {
        super(context);
        this.q = false;
        this.r = new Handler();
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 1;
        this.x = 1;
        this.y = false;
        this.z = false;
        this.A = 1;
        this.B = 0L;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = "";
        this.L = new a(Looper.getMainLooper());
        this.M = false;
        this.N = false;
        this.O = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        CampaignEx campaignEx = this.b;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        int i2 = getResources().getConfiguration().orientation;
        String str = AdError.UNDEFINED_DOMAIN;
        if (i2 != 0) {
            if (i2 == 1) {
                str = C3040d4.h.D;
            } else if (i2 == 2) {
                str = C3040d4.h.C;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("placementType", "Interstitial");
        hashMap.put("state", EventTaskParams.STATE_GROUP_DEFAULT);
        hashMap.put("viewable", "true");
        hashMap.put("currentAppOrientation", jSONObject);
        if (getContext() instanceof Activity) {
            float n = l0.n(getContext());
            float m = l0.m(getContext());
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float f2 = displayMetrics.widthPixels;
            float f3 = displayMetrics.heightPixels;
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.p, n, m);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.p, f2, f3);
        }
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.p, r7.getLeft(), this.p.getTop(), this.p.getWidth(), this.p.getHeight());
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.p, r13.getLeft(), this.p.getTop(), this.p.getWidth(), this.p.getHeight());
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.p, hashMap);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.p, com.mbridge.msdk.mbsignalcommon.mraid.d.f);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.p);
    }

    public boolean canBackPress() {
        ImageView imageView = this.o;
        return imageView != null && imageView.getVisibility() == 0;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        try {
            onCloseViewClick();
        } catch (Exception e2) {
            p0.b(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void defaultShow() {
        super.defaultShow();
    }

    public void excuteEndCardShowTask(int i2) {
        this.r.postDelayed(new h(this, i2), i2 * 1000);
    }

    public void excuteTask() {
        if (this.v || this.w <= -1) {
            return;
        }
        this.r.postDelayed(new k(this), this.w * 1000);
    }

    public void executeEndCardShow(int i2) {
        this.r.postDelayed(new g(this), i2 * 1000);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z) {
    }

    protected RelativeLayout.LayoutParams getContentLayoutParams() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.mbsignalcommon.mraid.b
    public CampaignEx getMraidCampaign() {
        return this.b;
    }

    protected String getURL() {
        CampaignEx campaignEx = this.b;
        if (campaignEx == null) {
            this.C = false;
            return null;
        }
        this.C = true;
        if (campaignEx.isMraid()) {
            this.v = false;
            String mraid = this.b.getMraid();
            if (TextUtils.isEmpty(mraid)) {
                return this.b.getEndScreenUrl();
            }
            File file = new File(mraid);
            try {
                return (file.exists() && file.isFile() && file.canRead()) ? "file:////" + mraid : this.b.getEndScreenUrl();
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
                return mraid;
            }
        }
        String str = this.b.getendcard_url();
        if (z0.a(str)) {
            this.v = false;
            return this.b.getEndScreenUrl();
        }
        this.v = true;
        String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(str);
        if (!TextUtils.isEmpty(h5ResAddress)) {
            return h5ResAddress + "&native_adtype=" + this.b.getAdType();
        }
        try {
            String path = Uri.parse(str).getPath();
            if (!TextUtils.isEmpty(path) && path.toLowerCase().endsWith(".zip")) {
                String endScreenUrl = this.b.getEndScreenUrl();
                if (TextUtils.isEmpty(endScreenUrl)) {
                    return null;
                }
                this.v = false;
                excuteTask();
                return endScreenUrl;
            }
        } catch (Throwable th2) {
            p0.b(MBridgeBaseView.TAG, th2.getMessage());
        }
        return str + "&native_adtype=" + this.b.getAdType();
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void handlerPlayableException(String str) {
        if (this.u) {
            return;
        }
        this.u = true;
        this.t = false;
        if (this.b != null) {
            n nVar = new n();
            nVar.n(this.b.getRequestId());
            nVar.o(this.b.getRequestIdNotice());
            nVar.b(this.b.getId());
            nVar.m(str);
            com.mbridge.msdk.foundation.same.report.g.a(nVar, this.f5088a.getApplicationContext(), this.unitId);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_endcard_h5");
        if (h0.a(findLayout)) {
            View inflate = this.c.inflate(findLayout, (ViewGroup) null);
            this.m = inflate;
            try {
                this.e = a(inflate);
            } catch (Exception unused) {
                this.e = false;
            }
            addView(this.m, getContentLayoutParams());
            d();
            j();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void install(CampaignEx campaignEx) {
    }

    public boolean isLoadSuccess() {
        return this.t;
    }

    public boolean isPlayable() {
        return this.v;
    }

    protected void j() {
        if (this.e) {
            setMatchParent();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.video.signal.h
    public void notifyCloseBtn(int i2) {
        if (i2 == 0) {
            this.E = true;
        } else {
            if (i2 != 1) {
                return;
            }
            this.F = true;
        }
    }

    public void onBackPress() {
        boolean z;
        if (this.D || (((z = this.E) && this.F) || (!(z || !this.G || this.O) || (!z && this.H && this.O)))) {
            onCloseViewClick();
        }
    }

    public void onCloseViewClick() {
        try {
            if (this.p != null) {
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.p, "onSystemDestory", "");
                new Thread(new f(this)).start();
            } else {
                this.notifyListener.a(103, "");
                this.notifyListener.a(Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, "webview is null when closing webview");
            }
        } catch (Exception e2) {
            this.notifyListener.a(103, "");
            this.notifyListener.a(Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, "close webview exception" + e2.getMessage());
            p0.a(MBridgeBaseView.TAG, e2.getMessage());
        }
        try {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("type", 2);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000152", eVar);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000134", this.b);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onFinishRedirection(Campaign campaign, String str) {
        if (campaign == null) {
            return;
        }
        t0.a(campaign, this);
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onRedirectionFailed(Campaign campaign, String str) {
        if (campaign == null) {
            return;
        }
        t0.a(campaign, this);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        orientation(configuration);
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onStartRedirection(Campaign campaign, String str) {
        t0.b(campaign, this);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 != 0 || this.J) {
            return;
        }
        this.J = true;
        setFocusableInTouchMode(true);
        requestFocus();
        requestFocusFromTouch();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        CampaignEx campaignEx = this.b;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        if (z) {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(this.p, "true");
        } else {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(this.p, "false");
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        super.open(str);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void orientation(Configuration configuration) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", C3040d4.h.C);
            } else {
                jSONObject.put("orientation", C3040d4.h.D);
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.p, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        String url = getURL();
        if (!this.e || this.b == null || TextUtils.isEmpty(url) || this.p == null) {
            reportRenderResult("PL URL IS NULL", 3);
            this.notifyListener.a(127, "");
            this.notifyListener.a(129, "");
        } else {
            this.B = System.currentTimeMillis();
            try {
                reportRenderResult("start", 0);
            } catch (Exception unused) {
            }
            com.mbridge.msdk.foundation.same.webview.a aVar = new com.mbridge.msdk.foundation.same.webview.a(this.b);
            aVar.a(this.b.getAppName());
            this.p.setDownloadListener(aVar);
            this.p.setCampaignId(this.b.getId());
            this.p.setTempTypeForMetrics(3);
            CampaignEx campaignEx = this.b;
            if (campaignEx != null) {
                this.p.setCampaignEx(campaignEx);
            }
            setCloseVisible(8);
            this.p.setApiManagerJSFactory(bVar);
            if (this.b.isMraid()) {
                this.p.setMraidObject(this);
            }
            boolean z = url.contains("wfr=1") || url.contains("wfl=1");
            a1.a(this.p, this.b.getLocalRequestId(), this.b.getLocalAllowTrackClick());
            this.p.setWebViewListener(new c(z));
            if (TextUtils.isEmpty(this.b.getMraid())) {
                h();
            }
            setHtmlSource(HTMLResourceManager.getInstance().getHtmlContentFromUrl(url));
            if (TextUtils.isEmpty(this.s)) {
                this.p.loadUrl(url);
            } else {
                this.p.loadDataWithBaseURL(url, this.s, "text/html", "UTF-8", null);
            }
        }
        this.O = false;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void readyStatus(int i2) {
    }

    public void release() {
        Handler handler = this.r;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.r = null;
        }
        Handler handler2 = this.L;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.L = null;
        }
        this.n.removeAllViews();
        this.p.release();
        this.p = null;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void reportOpen(String str) {
        CampaignEx mraidCampaign = getMraidCampaign();
        if (mraidCampaign != null) {
            new com.mbridge.msdk.foundation.same.report.h(getContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.unitId, str, this.b.isBidCampaign());
        }
    }

    public void reportRenderResult(String str, int i2) {
        if (this.b == null || this.u) {
            return;
        }
        n nVar = new n();
        nVar.n(this.b.getRequestId());
        nVar.o(this.b.getRequestIdNotice());
        nVar.b(this.b.getId());
        nVar.d(i2);
        nVar.e(String.valueOf(System.currentTimeMillis() - this.B));
        nVar.m(str);
        String str2 = "2";
        if (this.b.getAdType() == 287) {
            nVar.a("3");
        } else if (this.b.getAdType() == 94) {
            nVar.a("1");
        } else if (this.b.getAdType() == 42) {
            nVar.a("2");
        }
        if (this.b.isMraid()) {
            nVar.b(n.N);
        } else {
            nVar.g(this.b.getendcard_url());
            if (z0.b(this.b.getendcard_url()) && this.b.getendcard_url().contains(".zip")) {
                str2 = "1";
            }
            nVar.f(str2);
            nVar.b(n.O);
        }
        com.mbridge.msdk.foundation.same.report.g.b(nVar, this.unitId, this.b);
    }

    public void setCloseDelayShowTime(int i2) {
        this.w = i2;
    }

    public void setCloseVisible(int i2) {
        if (this.e) {
            this.o.setVisibility(i2);
        }
    }

    public void setCloseVisibleForMraid(int i2) {
        if (this.e) {
            this.I = true;
            if (i2 == 4) {
                this.o.setImageDrawable(new ColorDrawable(16711680));
            } else {
                this.o.setImageResource(findDrawable("mbridge_reward_close"));
            }
            this.o.setVisibility(0);
        }
    }

    public void setError(boolean z) {
        this.u = z;
    }

    public void setHtmlSource(String str) {
        this.s = str;
    }

    public void setLoadPlayable(boolean z) {
        this.O = z;
    }

    public void setNotchValue(String str, int i2, int i3, int i4, int i5) {
        if (!TextUtils.isEmpty(str)) {
            this.K = str;
        }
        CampaignEx campaignEx = this.b;
        if (campaignEx == null || campaignEx.getAdSpaceT() == 2) {
            return;
        }
        p0.b(MBridgeBaseView.TAG, "NOTCH H5ENDCARD " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        int a2 = u0.a(getContext(), 20.0f);
        layoutParams.setMargins(i2 + a2, i4 + a2, i3 + a2, i5 + a2);
        this.o.setLayoutParams(layoutParams);
    }

    public void setPlayCloseBtnTm(int i2) {
        this.x = i2;
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    public void startCounterEndCardShowTimer() {
        try {
            String str = this.b.getendcard_url();
            if (z0.b(str) && str.contains("wfl=1")) {
                String[] split = str.split(C3040d4.i.c);
                int i2 = 15;
                if (split != null && split.length > 0) {
                    for (String str2 : split) {
                        if (z0.b(str2) && str2.contains("timeout") && str2.split(C3040d4.i.b) != null && str2.split(C3040d4.i.b).length > 0) {
                            i2 = u0.a((Object) str2.split(C3040d4.i.b)[1]);
                        }
                    }
                }
                executeEndCardShow(i2);
            }
        } catch (Throwable th) {
            p0.a(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.video.signal.h
    public void toggleCloseBtn(int i2) {
        int visibility = this.o.getVisibility();
        if (i2 == 1) {
            this.D = true;
            visibility = 0;
        } else if (i2 == 2) {
            this.D = false;
            if (this.O) {
                g();
            } else {
                f();
            }
            visibility = 8;
        }
        setCloseVisible(visibility);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.mbsignalcommon.mraid.b
    public void unload() {
        close();
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.mbsignalcommon.mraid.b
    public void useCustomClose(boolean z) {
        try {
            setCloseVisibleForMraid(z ? 4 : 0);
        } catch (Exception e2) {
            p0.b(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    public void volumeChange(double d2) {
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.p, d2);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void webviewshow() {
        WindVaneWebView windVaneWebView = this.p;
        if (windVaneWebView != null) {
            windVaneWebView.post(new d());
        }
    }

    class e implements com.mbridge.msdk.foundation.feedback.a {
        e() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                p0.b(MBridgeBaseView.TAG, th.getMessage(), th);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeH5EndCardView.this.p, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                p0.b(MBridgeBaseView.TAG, th.getMessage(), th);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeH5EndCardView.this.p, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            String str2;
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 2);
                }
                str2 = jSONObject.toString();
            } catch (Throwable th) {
                p0.b(MBridgeBaseView.TAG, th.getMessage(), th);
                str2 = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeH5EndCardView.this.p, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
        }
    }

    private void f() {
        if (this.M || this.E) {
            return;
        }
        this.M = true;
        int i2 = this.w;
        if (i2 == 0) {
            this.G = true;
            return;
        }
        this.G = false;
        if (i2 > -1) {
            this.r.postDelayed(new i(this), this.w * 1000);
        }
    }

    private void g() {
        if (this.N || this.E) {
            return;
        }
        this.N = true;
        int i2 = this.x;
        if (i2 == 0) {
            this.H = true;
            return;
        }
        this.H = false;
        if (i2 > -1) {
            this.r.postDelayed(new j(this), this.x * 1000);
        }
    }

    private void h() {
        int v;
        try {
            this.B = System.currentTimeMillis();
            String str = this.b.getendcard_url();
            com.mbridge.msdk.videocommon.setting.c c2 = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), this.unitId);
            if (this.v && z0.b(str)) {
                if (str.contains("wfr=1") || (c2 != null && c2.v() > 0)) {
                    if (str.contains("wfr=1")) {
                        String[] split = str.split(C3040d4.i.c);
                        if (split != null && split.length > 0) {
                            for (String str2 : split) {
                                if (z0.b(str2) && str2.contains("to") && str2.split(C3040d4.i.b) != null && str2.split(C3040d4.i.b).length > 0) {
                                    v = u0.a((Object) str2.split(C3040d4.i.b)[1]);
                                    break;
                                }
                            }
                        }
                        v = 20;
                    } else {
                        if (c2 != null && c2.v() > 0) {
                            v = c2.v();
                        }
                        v = 20;
                    }
                    if (v >= 0) {
                        excuteEndCardShowTask(v);
                    } else {
                        excuteEndCardShowTask(20);
                    }
                }
            }
        } catch (Throwable th) {
            p0.b(MBridgeBaseView.TAG, th.getMessage(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            CampaignEx campaignEx = this.b;
            if (campaignEx != null) {
                campaignEx.setCampaignUnitId(this.unitId);
                com.mbridge.msdk.foundation.feedback.b.b().d(this.unitId + "_1");
                com.mbridge.msdk.foundation.feedback.b.b().a(this.unitId + "_2", this.b);
            }
            CampaignEx campaignEx2 = this.b;
            if (campaignEx2 == null || !campaignEx2.isMraid()) {
                return;
            }
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().d());
            imageView.setBackgroundResource(h0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_notice", "drawable"));
            ImageView imageView2 = this.o;
            RelativeLayout.LayoutParams layoutParams = imageView2 != null ? (RelativeLayout.LayoutParams) imageView2.getLayoutParams() : null;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f), u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f));
            layoutParams2.addRule(9);
            layoutParams2.addRule(10);
            if (layoutParams != null) {
                layoutParams2.leftMargin = layoutParams.rightMargin;
                layoutParams2.topMargin = layoutParams.topMargin;
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
            } else {
                layoutParams2.leftMargin = u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f);
                layoutParams2.topMargin = u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f);
            }
            addView(imageView, layoutParams2);
            u0.a(4, imageView, this.b, com.mbridge.msdk.foundation.controller.c.m().d(), false, new e());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    protected void d() {
        super.d();
        if (this.e) {
            this.o.setOnClickListener(new b());
        }
    }

    private boolean a(View view) {
        this.o = (ImageView) view.findViewById(findID("mbridge_windwv_close"));
        this.n = (RelativeLayout) view.findViewById(findID("mbridge_windwv_content_rl"));
        WindVaneWebView windVaneWebView = new WindVaneWebView(getContext());
        this.p = windVaneWebView;
        CampaignEx campaignEx = this.b;
        if (campaignEx != null) {
            windVaneWebView.setLocalRequestId(campaignEx.getCurrentLocalRid());
        }
        this.p.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.n.addView(this.p);
        return isNotNULL(this.o, this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(13:7|8|(1:48)(1:12)|13|(1:15)(2:44|(1:46)(8:47|17|18|19|(1:21)(2:36|(1:38)(2:39|(1:41)))|22|23|(1:33)(4:26|(1:28)(1:32)|29|31)))|16|17|18|19|(0)(0)|22|23|(1:33)(1:34)) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009d, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a A[Catch: NullPointerException -> 0x009c, all -> 0x010e, TryCatch #0 {NullPointerException -> 0x009c, blocks: (B:19:0x0070, B:21:0x007a, B:36:0x0080, B:38:0x008a, B:39:0x008e, B:41:0x0098), top: B:18:0x0070, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0080 A[Catch: NullPointerException -> 0x009c, all -> 0x010e, TryCatch #0 {NullPointerException -> 0x009c, blocks: (B:19:0x0070, B:21:0x007a, B:36:0x0080, B:38:0x008a, B:39:0x008e, B:41:0x0098), top: B:18:0x0070, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(long j2, boolean z) {
        int i2;
        int i3;
        try {
            if (this.y) {
                return;
            }
            this.y = true;
            String str = (z0.b(this.b.getendcard_url()) && this.b.getendcard_url().contains(".zip")) ? "1" : "2";
            String str2 = "ready yes";
            int i4 = 2;
            if (z) {
                str2 = "ready timeout";
                i2 = 12;
            } else if (this.A == 2) {
                str2 = "ready no";
                i4 = 3;
                i2 = 11;
            } else {
                i2 = 10;
                i3 = 1;
                String str3 = str2;
                n nVar = new n("m_download_end", i2, j2 + "", this.b.getendcard_url(), this.b.getId(), this.unitId, str3, str);
                if (this.b.getAdType() != 287) {
                    nVar.a("3");
                } else if (this.b.getAdType() == 94) {
                    nVar.a("1");
                } else if (this.b.getAdType() == 42) {
                    nVar.a("2");
                }
                nVar.n(this.b.getRequestId());
                nVar.k(this.b.getCurrentLocalRid());
                nVar.o(this.b.getRequestIdNotice());
                nVar.a(this.b.getAdSpaceT());
                a(nVar, this.b);
                if (isLoadSuccess() && i3 == 1) {
                    nVar.d(i3);
                    nVar.e(String.valueOf(j2));
                    nVar.b(this.b.getId());
                    nVar.m(str3);
                    if (this.b.isMraid()) {
                        nVar.b(n.N);
                    } else {
                        nVar.g(this.b.getendcard_url());
                        nVar.f(str);
                        nVar.b(n.O);
                    }
                    com.mbridge.msdk.foundation.same.report.g.b(nVar, this.unitId, this.b);
                    return;
                }
            }
            i3 = i4;
            String str32 = str2;
            n nVar2 = new n("m_download_end", i2, j2 + "", this.b.getendcard_url(), this.b.getId(), this.unitId, str32, str);
            if (this.b.getAdType() != 287) {
            }
            nVar2.n(this.b.getRequestId());
            nVar2.k(this.b.getCurrentLocalRid());
            nVar2.o(this.b.getRequestIdNotice());
            nVar2.a(this.b.getAdSpaceT());
            a(nVar2, this.b);
            if (isLoadSuccess()) {
            }
        } catch (Throwable th) {
            p0.b(MBridgeBaseView.TAG, th.getMessage(), th);
        }
    }

    class c extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f5097a;

        c(boolean z) {
            this.f5097a = z;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            super.a(webView, str);
            MBridgeH5EndCardView mBridgeH5EndCardView = MBridgeH5EndCardView.this;
            if (mBridgeH5EndCardView.u) {
                return;
            }
            mBridgeH5EndCardView.t = true;
            mBridgeH5EndCardView.notifyListener.a(100, "");
            if (MBridgeH5EndCardView.this.b != null) {
                n nVar = new n();
                nVar.n(MBridgeH5EndCardView.this.b.getRequestId());
                nVar.o(MBridgeH5EndCardView.this.b.getRequestIdNotice());
                nVar.b(MBridgeH5EndCardView.this.b.getId());
                nVar.d(1);
                nVar.e(String.valueOf(System.currentTimeMillis() - MBridgeH5EndCardView.this.B));
                nVar.m("onPageFinished");
                String str2 = "2";
                if (MBridgeH5EndCardView.this.b.getAdType() == 287) {
                    nVar.a("3");
                } else if (MBridgeH5EndCardView.this.b.getAdType() == 94) {
                    nVar.a("1");
                } else if (MBridgeH5EndCardView.this.b.getAdType() == 42) {
                    nVar.a("2");
                }
                if (MBridgeH5EndCardView.this.b.isMraid()) {
                    nVar.b(n.N);
                } else {
                    nVar.g(MBridgeH5EndCardView.this.b.getendcard_url());
                    if (z0.b(MBridgeH5EndCardView.this.b.getendcard_url()) && MBridgeH5EndCardView.this.b.getendcard_url().contains(".zip")) {
                        str2 = "1";
                    }
                    nVar.f(str2);
                    nVar.b(n.O);
                }
                MBridgeH5EndCardView mBridgeH5EndCardView2 = MBridgeH5EndCardView.this;
                com.mbridge.msdk.foundation.same.report.g.b(nVar, mBridgeH5EndCardView2.unitId, mBridgeH5EndCardView2.b);
            }
            MBridgeH5EndCardView.this.notifyListener.a(120, "");
            if (this.f5097a) {
                return;
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("type", 3);
                eVar.a("result", 1);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000155", MBridgeH5EndCardView.this.b, eVar);
            } catch (Throwable th) {
                p0.b("WindVaneWebView", th.getMessage());
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void b(WebView webView, int i) {
            super.b(webView, i);
            MBridgeH5EndCardView.this.A = i;
            if (MBridgeH5EndCardView.this.z) {
                return;
            }
            MBridgeH5EndCardView.this.z = true;
            if (i == 1) {
                MBridgeH5EndCardView.this.reportRenderResult("success", 4);
            } else {
                MBridgeH5EndCardView.this.notifyListener.a(127, "");
                MBridgeH5EndCardView.this.reportRenderResult(C3040d4.h.t, 6);
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i, String str, String str2) {
            super.a(webView, i, str, str2);
            MBridgeH5EndCardView mBridgeH5EndCardView = MBridgeH5EndCardView.this;
            if (mBridgeH5EndCardView.u) {
                return;
            }
            mBridgeH5EndCardView.notifyListener.a(Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, "onReceivedError " + i + str);
            MBridgeH5EndCardView.this.reportRenderResult(str, 3);
            MBridgeH5EndCardView.this.notifyListener.a(127, "");
            MBridgeH5EndCardView.this.notifyListener.a(129, "");
            MBridgeH5EndCardView.this.u = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i) {
            super.a(webView, i);
            p0.c("WindVaneWebView", "h5EncardView readyStatus:" + i + "- isError" + MBridgeH5EndCardView.this.u);
            MBridgeH5EndCardView.this.A = i;
            if (!MBridgeH5EndCardView.this.u) {
                MBridgeH5EndCardView.this.a(System.currentTimeMillis() - MBridgeH5EndCardView.this.B, false);
            }
            if (this.f5097a) {
                try {
                    com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                    eVar.a("type", 3);
                    eVar.a("result", Integer.valueOf(i));
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000155", MBridgeH5EndCardView.this.b, eVar);
                } catch (Throwable th) {
                    p0.b("WindVaneWebView", th.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView) {
            super.a(webView);
            MBridgeH5EndCardView.this.setCloseVisible(0);
        }
    }

    private static void a(n nVar, CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.setting.c c2 = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), campaignEx.getCampaignUnitId());
            if (c2 != null) {
                nVar.s(c2.x());
            }
            com.mbridge.msdk.videocommon.setting.a c3 = com.mbridge.msdk.videocommon.setting.b.b().c();
            if (c3 != null) {
                nVar.r(c3.f());
            }
        } catch (Exception e2) {
            p0.b(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    public MBridgeH5EndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = false;
        this.r = new Handler();
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 1;
        this.x = 1;
        this.y = false;
        this.z = false;
        this.A = 1;
        this.B = 0L;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = "";
        this.L = new a(Looper.getMainLooper());
        this.M = false;
        this.N = false;
        this.O = false;
    }
}
