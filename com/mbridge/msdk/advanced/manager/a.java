package com.mbridge.msdk.advanced.manager;

import android.content.Context;
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
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.a1;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: BaseNativeAdvancedShowManager.java */
/* loaded from: classes6.dex */
public class a {
    protected CampaignEx b;
    protected MBNativeAdvancedView c;
    protected com.mbridge.msdk.advanced.middle.d d;
    protected com.mbridge.msdk.click.a e;
    private com.mbridge.msdk.advanced.middle.c f;
    private boolean g;
    private ImageView i;
    protected String j;
    private String k;
    protected MBridgeIds l;
    private boolean m;

    /* renamed from: a, reason: collision with root package name */
    private String f3980a = "NativeAdvancedShowManager";
    private int h = -1;
    private View.OnClickListener n = new ViewOnClickListenerC0314a();
    public Handler o = new b(Looper.getMainLooper());
    private com.mbridge.msdk.advanced.middle.a p = new c();

    /* compiled from: BaseNativeAdvancedShowManager.java */
    /* renamed from: com.mbridge.msdk.advanced.manager.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0314a implements View.OnClickListener {
        ViewOnClickListenerC0314a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.g) {
                a.this.a(1);
            }
        }
    }

    /* compiled from: BaseNativeAdvancedShowManager.java */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CampaignEx campaignEx;
            MBNativeAdvancedView mBNativeAdvancedView;
            MBNativeAdvancedWebview advancedNativeWebview;
            super.handleMessage(message);
            if (message.what != 2 || (campaignEx = a.this.b) == null || !campaignEx.isActiveOm() || (mBNativeAdvancedView = a.this.c) == null || (advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview()) == null) {
                return;
            }
            try {
                AdSession adSession = advancedNativeWebview.getAdSession();
                if (adSession != null) {
                    AdEvents createAdEvents = AdEvents.createAdEvents(adSession);
                    createAdEvents.loaded();
                    createAdEvents.impressionOccurred();
                    p0.a("OMSDK", "adSession.impressionOccurred()");
                }
            } catch (Throwable th) {
                p0.a("OMSDK", th.getMessage());
                CampaignEx campaignEx2 = a.this.b;
                if (campaignEx2 != null) {
                    new h(advancedNativeWebview.getContext()).a(campaignEx2.getRequestId(), a.this.b.getRequestIdNotice(), a.this.b.getId(), a.this.j, "fetch OM failed, exception" + th.getMessage());
                }
            }
        }
    }

    /* compiled from: BaseNativeAdvancedShowManager.java */
    class c implements com.mbridge.msdk.advanced.middle.a {
        c() {
        }

        @Override // com.mbridge.msdk.advanced.middle.a
        public void a(CampaignEx campaignEx) {
            a.this.a(campaignEx, false, "");
        }

        @Override // com.mbridge.msdk.advanced.middle.a
        public void close() {
            a.this.a(1);
        }

        @Override // com.mbridge.msdk.advanced.middle.a
        public void toggleCloseBtn(int i) {
            a.this.h = i;
            MBNativeAdvancedView mBNativeAdvancedView = a.this.c;
            if (mBNativeAdvancedView != null) {
                mBNativeAdvancedView.changeCloseBtnState(i);
            }
        }

        @Override // com.mbridge.msdk.advanced.middle.a
        public void triggerCloseBtn(Object obj, String str) {
            MBNativeAdvancedView mBNativeAdvancedView = a.this.c;
            if (mBNativeAdvancedView != null) {
                mBNativeAdvancedView.setVisibility(8);
            }
            a.this.a(1);
        }

        @Override // com.mbridge.msdk.advanced.middle.a
        public void a(int i) {
            p0.b(a.this.f3980a, "resetCountdown" + i);
        }

        @Override // com.mbridge.msdk.advanced.middle.a
        public void a(boolean z) {
            a aVar = a.this;
            if (aVar.d != null) {
                aVar.m = z;
                if (z) {
                    a aVar2 = a.this;
                    aVar2.d.f(aVar2.l);
                } else {
                    a aVar3 = a.this;
                    aVar3.d.a(aVar3.l);
                }
            }
        }

        @Override // com.mbridge.msdk.advanced.middle.a
        public void a(boolean z, String str) {
            try {
                if (a.this.d != null) {
                    if (TextUtils.isEmpty(str)) {
                        a aVar = a.this;
                        aVar.d.b(aVar.l);
                        a aVar2 = a.this;
                        aVar2.d.d(aVar2.l);
                        return;
                    }
                    CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(a.this.b));
                    parseCampaignWithBackData.setClickTempSource(2);
                    parseCampaignWithBackData.setClickType(2);
                    parseCampaignWithBackData.setTriggerClickSource(2);
                    parseCampaignWithBackData.setClickURL(str);
                    a.this.a(parseCampaignWithBackData, z, str);
                }
            } catch (Exception e) {
                p0.b(a.this.f3980a, e.getMessage());
            }
        }
    }

    /* compiled from: BaseNativeAdvancedShowManager.java */
    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f3985a;
        final /* synthetic */ MBNativeAdvancedView b;

        e(CampaignEx campaignEx, MBNativeAdvancedView mBNativeAdvancedView) {
            this.f3985a = campaignEx;
            this.b = mBNativeAdvancedView;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.f3985a, this.b, false);
        }
    }

    /* compiled from: BaseNativeAdvancedShowManager.java */
    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3986a;
        final /* synthetic */ CampaignEx b;

        f(Context context, CampaignEx campaignEx) {
            this.f3986a = context;
            this.b = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j.a(g.a(this.f3986a)).b(this.b.getId());
            } catch (Exception unused) {
                p0.b(a.this.f3980a, "campain can't insert db");
            }
        }
    }

    public a(Context context, String str, String str2) {
        this.j = str2;
        this.k = str;
        this.l = new MBridgeIds(str, str2);
        if (this.i == null) {
            ImageView imageView = new ImageView(context);
            this.i = imageView;
            imageView.setPadding(u0.a(context, 2.0f), u0.a(context, 2.0f), u0.a(context, 2.0f), u0.a(context, 2.0f));
            d();
        }
    }

    private void d() {
        Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
        this.i.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(u0.a(d2, 29.0f), u0.a(d2, 16.0f));
        }
        this.i.setLayoutParams(layoutParams);
        this.i.setImageResource(d2.getResources().getIdentifier("mbridge_native_advanced_close_icon", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
    }

    private void h() {
        if (this.b.isReport()) {
            return;
        }
        a(this.b);
        com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, this.j);
        com.mbridge.msdk.advanced.middle.d dVar = this.d;
        if (dVar != null) {
            dVar.e(this.l);
        }
    }

    private void i() {
        CampaignEx campaignEx;
        MBNativeAdvancedView mBNativeAdvancedView = this.c;
        if (mBNativeAdvancedView == null || (campaignEx = this.b) == null) {
            return;
        }
        mBNativeAdvancedView.setAdChoiceCampaign(campaignEx);
    }

    public void a(CampaignEx campaignEx, boolean z, String str) {
        throw null;
    }

    public String c() {
        CampaignEx campaignEx = this.b;
        return (campaignEx == null || campaignEx.getRequestId() == null) ? "" : this.b.getRequestId();
    }

    public void e() {
        MBNativeAdvancedWebview advancedNativeWebview;
        MBNativeAdvancedView mBNativeAdvancedView = this.c;
        if (mBNativeAdvancedView == null || (advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview()) == null || advancedNativeWebview.isDestoryed()) {
            return;
        }
        com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) advancedNativeWebview, "onViewDisappeared", "");
    }

    public void f() {
        MBNativeAdvancedWebview advancedNativeWebview;
        if (this.c == null || com.mbridge.msdk.foundation.feedback.b.f || (advancedNativeWebview = this.c.getAdvancedNativeWebview()) == null || advancedNativeWebview.isDestoryed()) {
            return;
        }
        com.mbridge.msdk.advanced.signal.a.a(advancedNativeWebview, "onViewAppeared", "");
    }

    public void g() {
        if (this.d != null) {
            this.d = null;
        }
        if (this.p != null) {
            this.p = null;
        }
        if (this.n != null) {
            this.n = null;
        }
        MBNativeAdvancedView mBNativeAdvancedView = this.c;
        if (mBNativeAdvancedView != null) {
            MBNativeAdvancedWebview advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview();
            if (advancedNativeWebview != null) {
                advancedNativeWebview.finishAdSession();
            }
            this.c.destroy();
        }
        if (this.f != null) {
            this.f = null;
        }
        com.mbridge.msdk.foundation.feedback.b.b().d(this.j);
    }

    public com.mbridge.msdk.advanced.middle.a b() {
        return this.p;
    }

    private void b(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getOnlyImpressionURL())) {
                    return;
                }
                com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.retry.a.n);
            } catch (Throwable th) {
                p0.b(this.f3980a, th.getMessage());
            }
        }
    }

    public void a(com.mbridge.msdk.advanced.middle.c cVar) {
        this.f = cVar;
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
                p0.b(this.f3980a, th.getMessage());
            }
        }
    }

    public void a(com.mbridge.msdk.advanced.middle.d dVar) {
        this.d = dVar;
    }

    public String a() {
        ArrayList arrayList = new ArrayList();
        CampaignEx campaignEx = this.b;
        if (campaignEx != null) {
            arrayList.add(campaignEx);
        }
        return com.mbridge.msdk.foundation.same.c.b(arrayList);
    }

    public void a(CampaignEx campaignEx, MBNativeAdvancedView mBNativeAdvancedView, boolean z) {
        MBNativeAdvancedWebview advancedNativeWebview;
        View a2;
        RelativeLayout.LayoutParams layoutParams;
        if (mBNativeAdvancedView == null) {
            return;
        }
        this.b = campaignEx;
        this.c = mBNativeAdvancedView;
        com.mbridge.msdk.foundation.feedback.b.b().a(this.j, new d(mBNativeAdvancedView));
        if (campaignEx.isMraid() && com.mbridge.msdk.foundation.feedback.b.b().a() && (a2 = com.mbridge.msdk.foundation.feedback.b.b().a(this.j)) != null) {
            try {
                layoutParams = (RelativeLayout.LayoutParams) a2.getLayoutParams();
            } catch (Exception e2) {
                e2.printStackTrace();
                layoutParams = null;
            }
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.feedback.b.e, com.mbridge.msdk.foundation.feedback.b.d);
            }
            layoutParams.addRule(12);
            ViewGroup viewGroup = (ViewGroup) a2.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(a2);
            }
            mBNativeAdvancedView.addView(a2, layoutParams);
        }
        a(this.g);
        com.mbridge.msdk.advanced.signal.b advancedNativeSignalCommunicationImpl = mBNativeAdvancedView.getAdvancedNativeSignalCommunicationImpl();
        campaignEx.setLocalRequestId(campaignEx.getCurrentLocalRid());
        List<CampaignEx> arrayList = new ArrayList<>();
        arrayList.add(campaignEx);
        if (advancedNativeSignalCommunicationImpl == null) {
            advancedNativeSignalCommunicationImpl = new com.mbridge.msdk.advanced.signal.b(mBNativeAdvancedView.getContext(), this.k, this.j);
            advancedNativeSignalCommunicationImpl.a(arrayList);
        }
        advancedNativeSignalCommunicationImpl.a(this.g ? 1 : 0);
        advancedNativeSignalCommunicationImpl.a(this.p);
        mBNativeAdvancedView.setAdvancedNativeSignalCommunicationImpl(advancedNativeSignalCommunicationImpl);
        a1.a(mBNativeAdvancedView.getAdvancedNativeWebview(), campaignEx.getLocalRequestId(), campaignEx.getLocalAllowTrackClick());
        if (campaignEx.isHasMBTplMark() || !this.g) {
            this.i.setVisibility(8);
        }
        a(this.i);
        mBNativeAdvancedView.setCloseView(this.i);
        if (mBNativeAdvancedView.getVisibility() != 0) {
            mBNativeAdvancedView.setVisibility(0);
        }
        l a3 = com.mbridge.msdk.foundation.tools.g.a(mBNativeAdvancedView.getAdvancedNativeWebview(), campaignEx.getImpReportType());
        if (this.f == null || !a3.a() || this.f.d() == null || this.f.d().getAlpha() < 0.5f || this.f.d().getVisibility() != 0 || this.m) {
            if (z) {
                mBNativeAdvancedView.postDelayed(new e(campaignEx, mBNativeAdvancedView), 200L);
                return;
            }
            return;
        }
        com.mbridge.msdk.foundation.tools.g.a(arrayList, a3);
        mBNativeAdvancedView.show();
        com.mbridge.msdk.foundation.controller.c.m().a(mBNativeAdvancedView.getContext());
        campaignEx.setCampaignUnitId(this.j);
        com.mbridge.msdk.foundation.feedback.b.b().a(this.j, campaignEx);
        CampaignEx campaignEx2 = this.b;
        if (campaignEx2 != null && campaignEx2.isActiveOm() && (advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview()) != null) {
            try {
                AdSession a4 = com.mbridge.msdk.omsdk.b.a(com.mbridge.msdk.foundation.controller.c.m().d(), advancedNativeWebview, advancedNativeWebview.getUrl(), this.b);
                if (a4 != null) {
                    advancedNativeWebview.setAdSession(a4);
                    a4.registerAdView(advancedNativeWebview);
                    a4.start();
                    p0.a("OMSDK", "adSession.start()");
                }
            } catch (Throwable th) {
                p0.a("OMSDK", th.getMessage());
                CampaignEx campaignEx3 = this.b;
                if (campaignEx3 != null) {
                    new h(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx3.getRequestId(), this.b.getRequestIdNotice(), this.b.getId(), this.j, "fetch OM failed, exception" + th.getMessage());
                }
            }
        }
        h();
        if (campaignEx.isMraid()) {
            i();
        }
        int i = this.h;
        if (i != -1) {
            mBNativeAdvancedView.changeCloseBtnState(i);
        }
        com.mbridge.msdk.advanced.manager.d.b(this.j);
        com.mbridge.msdk.advanced.common.c.b(this.k + this.j + campaignEx.getRequestId());
        this.o.sendEmptyMessageDelayed(2, 1000L);
        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b.getMaitve(), this.b.getMaitve_src());
    }

    /* compiled from: BaseNativeAdvancedShowManager.java */
    class d implements com.mbridge.msdk.foundation.feedback.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MBNativeAdvancedView f3984a;

        d(MBNativeAdvancedView mBNativeAdvancedView) {
            this.f3984a = mBNativeAdvancedView;
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            String str;
            a.this.e();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                p0.b(a.this.f3980a, th.getMessage(), th);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.f3984a.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            String str;
            a.this.f();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                p0.b(a.this.f3980a, th.getMessage(), th);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.f3984a.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            String str2;
            a.this.f();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 2);
                }
                str2 = jSONObject.toString();
            } catch (Throwable th) {
                p0.b(a.this.f3980a, th.getMessage(), th);
                str2 = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.f3984a.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
        }
    }

    private void a(CampaignEx campaignEx) {
        if (campaignEx.isHasMBTplMark()) {
            return;
        }
        a(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.j);
        campaignEx.setReport(true);
        com.mbridge.msdk.foundation.same.buffer.b.a(this.j, campaignEx, "h5_native");
        b(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.j);
        c(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.j);
    }

    public void a(boolean z) {
        this.g = z;
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.mbridge.msdk.advanced.middle.d dVar = this.d;
        if (dVar != null) {
            dVar.c(this.l);
            this.d = null;
            com.mbridge.msdk.advanced.report.a.a(this.j, this.b);
        }
        com.mbridge.msdk.advanced.report.a.a(this.j, i, this.b);
        MBNativeAdvancedView mBNativeAdvancedView = this.c;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.setVisibility(8);
            e();
            MBNativeAdvancedWebview advancedNativeWebview = this.c.getAdvancedNativeWebview();
            if (advancedNativeWebview != null) {
                advancedNativeWebview.finishAdSession();
            }
        }
        Handler handler = this.o;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private void a(CampaignEx campaignEx, Context context, String str) {
        com.mbridge.msdk.foundation.controller.c.m().a(context);
        if (!TextUtils.isEmpty(campaignEx.getImpressionURL())) {
            new Thread(new f(context, campaignEx)).start();
            com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getImpressionURL(), false, true, com.mbridge.msdk.click.retry.a.m);
        }
        if (TextUtils.isEmpty(str) || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().k() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getNativeVideoTracking().k(), false, false);
    }
}
