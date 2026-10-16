package com.mbridge.msdk.splash.manager;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.mbridge.msdk.click.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.tools.a1;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: BaseSplashShowManager.java */
/* loaded from: classes6.dex */
public class b {
    private CampaignEx b;
    protected MBSplashView c;
    protected com.mbridge.msdk.splash.middle.d d;
    protected com.mbridge.msdk.click.a e;
    private boolean f;
    private TextView g;
    private View h;
    protected String i;
    private String j;
    protected MBridgeIds k;
    protected boolean q;
    private boolean r;
    protected Context s;
    private ImageView u;
    private i v;
    private AdSession w;

    /* renamed from: a, reason: collision with root package name */
    protected final String f4721a = "SplashShowManager";
    protected int l = 5;
    protected String m = "点击跳过|";
    protected String n = "点击跳过|";
    protected String o = "秒";
    protected String p = "秒后自动关闭";
    protected boolean t = true;
    private View.OnClickListener x = new a();
    public Handler y = new HandlerC0389b(Looper.getMainLooper());
    private boolean z = true;
    protected j A = new e();

    /* compiled from: BaseSplashShowManager.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f) {
                b.this.b(1);
                b.this.d(-1);
            }
        }
    }

    /* compiled from: BaseSplashShowManager.java */
    /* renamed from: com.mbridge.msdk.splash.manager.b$b, reason: collision with other inner class name */
    class HandlerC0389b extends Handler {
        HandlerC0389b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MBSplashView mBSplashView;
            MBSplashWebview splashWebview;
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i != 2 || b.this.b == null || !b.this.b.isActiveOm() || (mBSplashView = b.this.c) == null || (splashWebview = mBSplashView.getSplashWebview()) == null) {
                    return;
                }
                try {
                    b.this.w = splashWebview.getAdSession();
                    if (b.this.w != null) {
                        AdEvents createAdEvents = AdEvents.createAdEvents(b.this.w);
                        createAdEvents.loaded();
                        createAdEvents.impressionOccurred();
                    }
                    p0.a("OMSDK", "adSession.impressionOccurred()");
                    return;
                } catch (Throwable th) {
                    p0.a("OMSDK", th.getMessage());
                    if (b.this.b != null) {
                        new com.mbridge.msdk.foundation.same.report.h(splashWebview.getContext()).a(b.this.b.getRequestId(), b.this.b.getRequestIdNotice(), b.this.b.getId(), b.this.i, "fetch OM failed, exception" + th.getMessage());
                        return;
                    }
                    return;
                }
            }
            if (!b.this.r) {
                b.this.i();
            }
            b bVar = b.this;
            if (bVar.l <= 0) {
                bVar.b(2);
                return;
            }
            if (!com.mbridge.msdk.foundation.feedback.b.f) {
                b bVar2 = b.this;
                if (!bVar2.q) {
                    int i2 = bVar2.l - 1;
                    bVar2.l = i2;
                    bVar2.d(i2);
                    b bVar3 = b.this;
                    if (!bVar3.t) {
                        bVar3.g();
                    }
                    b.this.y.removeMessages(1);
                    sendEmptyMessageDelayed(1, 1000L);
                }
            }
            b.this.f();
            b.this.y.removeMessages(1);
            sendEmptyMessageDelayed(1, 1000L);
        }
    }

    /* compiled from: BaseSplashShowManager.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.k();
        }
    }

    /* compiled from: BaseSplashShowManager.java */
    class e implements j {
        e() {
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            t0.a(campaign, b.this.c);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            t0.a(campaign, b.this.c);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            t0.b(campaign, b.this.c);
        }
    }

    /* compiled from: BaseSplashShowManager.java */
    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4727a;

        f(int i) {
            this.f4727a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f4727a);
        }
    }

    /* compiled from: BaseSplashShowManager.java */
    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4728a;
        final /* synthetic */ CampaignEx b;

        g(Context context, CampaignEx campaignEx) {
            this.f4728a = context;
            this.b = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(this.f4728a)).b(this.b.getId());
            } catch (Exception unused) {
                p0.b("SplashShowManager", "campain can't insert db");
            }
        }
    }

    /* compiled from: BaseSplashShowManager.java */
    class h implements com.mbridge.msdk.foundation.feedback.a {
        h() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            b.this.f();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            b.this.g();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            b.this.g();
        }
    }

    /* compiled from: BaseSplashShowManager.java */
    private class i implements com.mbridge.msdk.splash.middle.a {
        private i() {
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void a(CampaignEx campaignEx) {
            b.this.b(campaignEx, false, "");
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void close() {
            b.this.b(1);
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void toggleCloseBtn(int i) {
            MBSplashView mBSplashView = b.this.c;
            if (mBSplashView != null) {
                mBSplashView.changeCloseBtnState(i);
            }
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void triggerCloseBtn(Object obj, String str) {
            b.this.b(1);
        }

        /* synthetic */ i(b bVar, a aVar) {
            this();
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void a(int i) {
            p0.b("SplashShowManager", "resetCountdown" + i);
            b bVar = b.this;
            bVar.l = i;
            bVar.y.removeMessages(1);
            b.this.y.sendEmptyMessageDelayed(1, 1000L);
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void a(boolean z) {
            if (z) {
                b.this.y.removeMessages(1);
            }
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void a(boolean z, String str) {
            try {
                if (b.this.d != null) {
                    if (TextUtils.isEmpty(str)) {
                        b bVar = b.this;
                        bVar.d.a(bVar.k);
                        return;
                    }
                    CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(b.this.b));
                    parseCampaignWithBackData.setClickTempSource(2);
                    parseCampaignWithBackData.setClickType(2);
                    parseCampaignWithBackData.setTriggerClickSource(2);
                    parseCampaignWithBackData.setClickURL(str);
                    b.this.b(parseCampaignWithBackData, true, str);
                }
            } catch (Exception e) {
                p0.b("SplashShowManager", e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void a(int i, int i2) {
            if (i == 1) {
                b.this.y.removeMessages(1);
            }
            if (i == 2) {
                b bVar = b.this;
                bVar.l = i2;
                bVar.y.removeMessages(1);
                b.this.y.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    public b(Context context, String str, String str2) {
        this.i = str2;
        this.j = str;
        this.k = new MBridgeIds(str, str2);
        this.s = context;
        if (this.g == null) {
            TextView textView = new TextView(context);
            this.g = textView;
            textView.setGravity(1);
            this.g.setTextIsSelectable(false);
            this.g.setPadding(u0.a(context, 5.0f), u0.a(context, 5.0f), u0.a(context, 5.0f), u0.a(context, 5.0f));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            this.g.setLayoutParams(layoutParams == null ? new RelativeLayout.LayoutParams(u0.a(context, 100.0f), u0.a(context, 50.0f)) : layoutParams);
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        MBSplashView mBSplashView;
        if (this.b == null) {
            return;
        }
        this.r = true;
        if (this.d != null && (mBSplashView = this.c) != null) {
            if (mBSplashView.getContext() != null && (this.c.getContext() instanceof Activity) && ((Activity) this.c.getContext()).isFinishing()) {
                p0.a("SplashShowManager", "Activity is finishing");
            }
            if (this.c.isShown()) {
                this.d.b(this.k);
            } else {
                this.d.a(this.k, "SplashView or container is not visibility");
            }
        }
        if (!this.b.isReport()) {
            MBSplashView mBSplashView2 = this.c;
            if (mBSplashView2 == null || mBSplashView2.isDynamicView()) {
                a(this.b);
            } else {
                b(this.b);
            }
            com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, this.i);
        }
    }

    private void j() {
        this.g.setText(this.f ? this.n + this.l + this.o : this.l + this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        MBSplashView mBSplashView;
        MBSplashWebview splashWebview;
        View splashWebview2 = this.c.getSplashWebview();
        if (splashWebview2 == null) {
            splashWebview2 = this.c.getSplashNativeView();
        }
        l a2 = com.mbridge.msdk.foundation.tools.g.a(splashWebview2, this.b.getImpReportType());
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.b);
        if (a2.a()) {
            com.mbridge.msdk.foundation.tools.g.a(arrayList, a2);
        } else if (this.z) {
            this.z = false;
            this.c.postDelayed(new c(), 200L);
            return;
        } else {
            com.mbridge.msdk.foundation.tools.g.a(arrayList, a2);
            if (this.b.getLocalCheckShow() == 1) {
                a("ad env is not available");
                return;
            }
        }
        CampaignEx campaignEx = this.b;
        if (campaignEx != null && campaignEx.isActiveOm() && (mBSplashView = this.c) != null && (splashWebview = mBSplashView.getSplashWebview()) != null) {
            try {
                AdSession a3 = com.mbridge.msdk.omsdk.b.a(com.mbridge.msdk.foundation.controller.c.m().d(), splashWebview, splashWebview.getUrl(), this.b);
                this.w = a3;
                if (a3 != null) {
                    splashWebview.setAdSession(a3);
                    this.w.registerAdView(splashWebview);
                    this.w.start();
                }
                p0.a("OMSDK", "adSession.start()");
            } catch (Throwable th) {
                p0.a("OMSDK", th.getMessage());
                CampaignEx campaignEx2 = this.b;
                if (campaignEx2 != null) {
                    new com.mbridge.msdk.foundation.same.report.h(splashWebview.getContext()).a(campaignEx2.getRequestId(), this.b.getRequestIdNotice(), this.b.getId(), this.i, "fetch OM failed, exception" + th.getMessage());
                }
            }
        }
        com.mbridge.msdk.splash.manager.d.b(this.i);
        this.y.removeMessages(1);
        this.y.sendEmptyMessageDelayed(1, 1000L);
        this.y.sendEmptyMessageDelayed(2, 1000L);
        b();
        if (!this.b.isMraid()) {
            a();
        }
        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b.getMaitve(), this.b.getMaitve_src());
        try {
            BitmapDrawable a4 = com.mbridge.msdk.foundation.controller.c.m().a(this.i, this.b.getAdType());
            if (a4 != null) {
                if (this.u == null) {
                    this.u = new ImageView(com.mbridge.msdk.foundation.controller.c.m().d());
                }
                if (this.u.getVisibility() != 0) {
                    this.u.setVisibility(0);
                }
                u0.a(this.u, a4, this.c.getResources().getDisplayMetrics());
                if (this.u.getParent() == null) {
                    this.c.addView(this.u, new ViewGroup.LayoutParams(-1, -1));
                }
                AdSession adSession = this.w;
                if (adSession != null) {
                    adSession.addFriendlyObstruction(this.u, FriendlyObstructionPurpose.OTHER, null);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(CampaignEx campaignEx, boolean z, String str) {
        throw null;
    }

    public void g() {
        MBSplashView mBSplashView;
        Handler handler;
        this.t = true;
        if (this.c != null && this.l > 0 && (handler = this.y) != null) {
            handler.removeMessages(1);
            View splashWebview = this.c.getSplashWebview();
            if (splashWebview == null) {
                splashWebview = this.c.getSplashNativeView();
            }
            CampaignEx campaignEx = this.b;
            if (campaignEx != null ? com.mbridge.msdk.foundation.tools.g.b(campaignEx, null, splashWebview, campaignEx.getImpReportType()) : true) {
                this.y.sendEmptyMessageDelayed(1, 1000L);
            }
        }
        if (com.mbridge.msdk.foundation.feedback.b.f || (mBSplashView = this.c) == null) {
            return;
        }
        mBSplashView.onResume();
        MBSplashWebview splashWebview2 = this.c.getSplashWebview();
        if (splashWebview2 == null || splashWebview2.isDestoryed()) {
            return;
        }
        com.mbridge.msdk.splash.signal.c.a(splashWebview2, "onSystemPause", "");
    }

    public void h() {
        if (this.d != null) {
            this.d = null;
        }
        if (this.v != null) {
            this.v = null;
        }
        if (this.x != null) {
            this.x = null;
        }
        MBSplashView mBSplashView = this.c;
        if (mBSplashView != null) {
            mBSplashView.destroy();
        }
        com.mbridge.msdk.foundation.feedback.b.b().d(this.i);
    }

    private void e() {
        Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
        if (d2 != null) {
            String h2 = com.mbridge.msdk.foundation.controller.c.m().h();
            int identifier = d2.getResources().getIdentifier("mbridge_splash_count_time_can_skip", "string", h2);
            int identifier2 = d2.getResources().getIdentifier("mbridge_splash_count_time_can_skip_not", "string", h2);
            int identifier3 = d2.getResources().getIdentifier("mbridge_splash_count_time_can_skip_s", "string", h2);
            this.n = d2.getResources().getString(identifier);
            String string = d2.getResources().getString(identifier2);
            this.p = string;
            this.m = string;
            this.o = d2.getResources().getString(identifier3);
            this.g.setBackgroundResource(d2.getResources().getIdentifier("mbridge_splash_close_bg", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
            this.g.setTextColor(d2.getResources().getColor(d2.getResources().getIdentifier("mbridge_splash_count_time_skip_text_color", "color", h2)));
        }
    }

    public void c(int i2) {
        this.l = i2;
    }

    public String d() {
        CampaignEx campaignEx = this.b;
        return (campaignEx == null || campaignEx.getRequestId() == null) ? "" : this.b.getRequestId();
    }

    public void f() {
        Handler handler;
        this.t = false;
        if (this.c != null && this.l > 0 && (handler = this.y) != null) {
            handler.removeMessages(1);
        }
        MBSplashView mBSplashView = this.c;
        if (mBSplashView != null) {
            mBSplashView.onPause();
            MBSplashWebview splashWebview = this.c.getSplashWebview();
            if (splashWebview == null || splashWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.splash.signal.c.a(splashWebview, "onSystemPause", "");
        }
    }

    private void b(CampaignEx campaignEx) {
        if (campaignEx.isHasMBTplMark()) {
            return;
        }
        a(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.i);
        campaignEx.setReport(true);
        com.mbridge.msdk.foundation.same.buffer.b.a(this.i, campaignEx, "splash");
        b(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.i);
        c(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.i);
    }

    public String c() {
        ArrayList arrayList = new ArrayList();
        CampaignEx campaignEx = this.b;
        if (campaignEx != null) {
            arrayList.add(campaignEx);
        }
        return com.mbridge.msdk.foundation.same.c.b(arrayList);
    }

    public void a(com.mbridge.msdk.splash.middle.d dVar) {
        this.d = dVar;
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this.x);
        }
        this.h = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        MBSplashView mBSplashView = this.c;
        if (mBSplashView != null) {
            mBSplashView.updateCountdown(i2);
            if (this.c.getSplashSignalCommunicationImpl() != null) {
                this.c.getSplashSignalCommunicationImpl().c(i2);
            }
        }
        if (i2 < 0) {
            this.l = i2;
            return;
        }
        com.mbridge.msdk.splash.middle.d dVar = this.d;
        if (dVar != null) {
            dVar.a(this.k, i2 * 1000);
        }
        if (this.h == null) {
            j();
        }
    }

    public void a(CampaignEx campaignEx, MBSplashView mBSplashView) {
        a(this.f);
        this.b = campaignEx;
        this.c = mBSplashView;
        com.mbridge.msdk.splash.signal.b splashSignalCommunicationImpl = mBSplashView.getSplashSignalCommunicationImpl();
        if (splashSignalCommunicationImpl == null) {
            splashSignalCommunicationImpl = new com.mbridge.msdk.splash.signal.b(mBSplashView.getContext(), this.j, this.i);
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            splashSignalCommunicationImpl.a(arrayList);
        }
        splashSignalCommunicationImpl.b(this.l);
        splashSignalCommunicationImpl.a(this.f ? 1 : 0);
        if (this.v == null) {
            this.v = new i(this, null);
        }
        splashSignalCommunicationImpl.a(this.v);
        mBSplashView.setSplashSignalCommunicationImpl(splashSignalCommunicationImpl);
        boolean isHasMBTplMark = campaignEx.isHasMBTplMark();
        View view = this.h;
        if (view == null) {
            if (isHasMBTplMark) {
                this.g.setVisibility(8);
            }
            j();
            a(this.g);
            mBSplashView.setCloseView(this.g);
        } else {
            if (isHasMBTplMark) {
                view.setVisibility(8);
            }
            a(this.h);
            mBSplashView.setCloseView(this.h);
        }
        a1.a(mBSplashView.getSplashWebview() != null ? mBSplashView.getSplashWebview() : mBSplashView.getSplashNativeView(), this.b.getLocalRequestId(), this.b.getLocalAllowTrackClick(), mBSplashView.getAllowClickSplashTouchListener());
        mBSplashView.show(campaignEx);
        this.z = true;
        k();
    }

    private void c(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls == null || pv_urls.size() <= 0) {
                    return;
                }
                Iterator<String> it = pv_urls.iterator();
                while (it.hasNext()) {
                    CampaignEx campaignEx2 = campaignEx;
                    Context context2 = context;
                    String str2 = str;
                    com.mbridge.msdk.click.a.a(context2, campaignEx2, str2, it.next(), false, true);
                    context = context2;
                    campaignEx = campaignEx2;
                    str = str2;
                }
            } catch (Throwable th) {
                p0.b("SplashShowManager", th.getMessage());
            }
        }
    }

    /* compiled from: BaseSplashShowManager.java */
    class d implements com.mbridge.msdk.foundation.feedback.a {
        d() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            String str;
            b.this.f();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                p0.b("SplashShowManager", th.getMessage(), th);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) b.this.c.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            String str;
            b.this.g();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                p0.b("SplashShowManager", th.getMessage(), th);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) b.this.c.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            String str2;
            b.this.g();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 2);
                }
                str2 = jSONObject.toString();
            } catch (Throwable th) {
                p0.b("SplashShowManager", th.getMessage(), th);
                str2 = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) b.this.c.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
        }
    }

    protected void b(int i2) {
        CampaignEx campaignEx;
        MBSplashWebview splashWebview;
        MBSplashView mBSplashView = this.c;
        if (mBSplashView != null && (splashWebview = mBSplashView.getSplashWebview()) != null) {
            splashWebview.finishAdSession();
        }
        if (this.y != null && (campaignEx = this.b) != null && campaignEx.isActiveOm()) {
            this.y.postDelayed(new f(i2), 1500L);
        } else {
            a(i2);
        }
    }

    private void b(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getOnlyImpressionURL())) {
                    return;
                }
                com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.retry.a.n);
            } catch (Throwable th) {
                p0.b("SplashShowManager", th.getMessage());
            }
        }
    }

    public void b() {
        MBSplashView mBSplashView;
        Context context;
        CampaignEx campaignEx = this.b;
        if (campaignEx == null || campaignEx.getPrivacyButtonTemplateVisibility() != 1 || (mBSplashView = this.c) == null || mBSplashView.getSplashWebview() == null || this.c.isDynamicView() || !this.b.isMraid() || (context = this.c.getContext()) == null) {
            return;
        }
        try {
            int a2 = h0.a(context, "mbridge_splash_notice", "drawable");
            int a3 = u0.a(context, 35.0f);
            int a4 = u0.a(context, 9.0f);
            ImageView imageView = new ImageView(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a3, a3);
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.setMargins(a4, a4, a4, a4);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setBackgroundResource(a2);
            u0.a(3, imageView, this.b, context, true, new h());
            this.c.addView(imageView);
        } catch (Throwable th) {
            p0.b("SplashShowManager", th.getMessage());
        }
    }

    private void a() {
        RelativeLayout.LayoutParams layoutParams;
        CampaignEx campaignEx = this.b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.i);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.i, 3);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.i, this.b);
        }
        if (com.mbridge.msdk.foundation.feedback.b.b().a()) {
            MBSplashView mBSplashView = this.c;
            if (mBSplashView == null || !mBSplashView.isDynamicView()) {
                com.mbridge.msdk.foundation.feedback.b.b().a(this.i, new d());
                FeedBackButton a2 = com.mbridge.msdk.foundation.feedback.b.b().a(this.i);
                if (a2 != null) {
                    try {
                        layoutParams = (RelativeLayout.LayoutParams) a2.getLayoutParams();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        layoutParams = null;
                    }
                    if (layoutParams == null) {
                        layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.feedback.b.e, com.mbridge.msdk.foundation.feedback.b.d);
                    }
                    layoutParams.topMargin = u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 10.0f);
                    layoutParams.leftMargin = u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 10.0f);
                    ViewGroup viewGroup = (ViewGroup) a2.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(a2);
                    }
                    MBSplashView mBSplashView2 = this.c;
                    if (mBSplashView2 != null) {
                        mBSplashView2.addView(a2, layoutParams);
                    }
                }
            }
        }
    }

    private void a(CampaignEx campaignEx) {
        b(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.i);
        a(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.i);
        c(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.i);
        campaignEx.setReport(true);
        com.mbridge.msdk.foundation.same.buffer.b.a(this.i, campaignEx, "splash");
    }

    private void a(String str) {
        com.mbridge.msdk.splash.middle.d dVar = this.d;
        if (dVar != null) {
            dVar.a(this.k, "web show failed:" + str);
        }
        MBSplashView mBSplashView = this.c;
        if (mBSplashView == null || mBSplashView.getParent() == null || !(this.c.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) this.c.getParent()).removeView(this.c);
    }

    public void a(boolean z) {
        this.f = z;
        if (z) {
            this.m = this.n;
        } else {
            this.m = this.p;
        }
    }

    protected void a(CampaignEx campaignEx, boolean z, String str) {
        if (this.e == null) {
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.i);
            this.e = aVar;
            aVar.a(this.A);
        }
        campaignEx.setCampaignUnitId(this.i);
        this.e.a(campaignEx);
        if (!this.b.isReportClick()) {
            this.b.setReportClick(true);
            com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx);
        }
        com.mbridge.msdk.splash.middle.d dVar = this.d;
        if (dVar != null) {
            dVar.a(this.k);
            b(3);
        }
        if (!z || TextUtils.isEmpty(str)) {
            return;
        }
        com.mbridge.msdk.splash.report.a.a(campaignEx, this.i, str);
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(this.x);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        MBSplashView mBSplashView;
        try {
            com.mbridge.msdk.splash.middle.d dVar = this.d;
            if (dVar != null) {
                dVar.a(this.k, i2);
                this.d = null;
                com.mbridge.msdk.splash.report.a.a(this.i, this.b);
            }
            ImageView imageView = this.u;
            if (imageView != null && imageView.getParent() != null && (mBSplashView = this.c) != null) {
                mBSplashView.removeView(this.u);
                this.u.setVisibility(8);
            }
            this.r = false;
            com.mbridge.msdk.splash.report.a.a(this.i, i2, this.b);
            Handler handler = this.y;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Exception e2) {
            p0.b("SplashShowManager", e2.getMessage());
        }
    }

    private void a(CampaignEx campaignEx, Context context, String str) {
        com.mbridge.msdk.foundation.controller.c.m().a(context);
        if (!TextUtils.isEmpty(campaignEx.getImpressionURL())) {
            new Thread(new g(context, campaignEx)).start();
            com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getImpressionURL(), false, true, com.mbridge.msdk.click.retry.a.m);
        }
        if (TextUtils.isEmpty(str) || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().k() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getNativeVideoTracking().k(), false, false);
    }
}
