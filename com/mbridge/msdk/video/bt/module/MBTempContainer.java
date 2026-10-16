package com.mbridge.msdk.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mmadbridge.adsession.media.InteractionType;
import com.iab.omid.library.mmadbridge.adsession.media.MediaEvents;
import com.iab.omid.library.mmadbridge.adsession.media.Position;
import com.iab.omid.library.mmadbridge.adsession.media.VastProperties;
import com.ironsource.C3288s;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.a1;
import com.mbridge.msdk.foundation.tools.c0;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.r0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbsignalcommon.mraid.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.container.AbstractJSContainer;
import com.mbridge.msdk.video.signal.impl.a;
import com.mbridge.msdk.videocommon.a;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MBTempContainer extends MBTempContainerDiff {
    private static final String s0 = "MBTempContainer";
    private int A;
    private int B;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private String I;
    private String J;
    private List<CampaignEx> K;
    private int L;
    private com.mbridge.msdk.foundation.same.report.metrics.c M;
    protected boolean N;
    private LayoutInflater O;
    protected boolean P;
    protected k Q;
    protected WindVaneWebView R;
    protected MBridgeContainerView S;
    protected Handler T;
    private int U;
    private int V;
    protected Runnable W;
    protected Runnable a0;
    private View b0;
    private boolean c0;
    private boolean d0;
    private boolean e0;
    private boolean f0;
    private boolean g0;
    private boolean h0;
    private boolean i0;
    private boolean j0;
    private boolean k0;
    private boolean l0;
    private com.mbridge.msdk.mbsignalcommon.mraid.d m0;
    private AdSession n0;
    private MediaEvents o0;
    private AdEvents p0;
    private Runnable q0;
    private View r;
    private boolean r0;
    private CampaignEx s;
    private com.mbridge.msdk.videocommon.download.a t;
    private com.mbridge.msdk.video.bt.module.orglistener.h u;
    private com.mbridge.msdk.video.bt.module.listener.b v;
    private com.mbridge.msdk.video.dynview.listener.a w;
    private int x;
    private String y;
    private com.mbridge.msdk.video.signal.factory.b z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MBTempContainer.this.b0.setVisibility(8);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBTempContainer.this.getActivityProxy().a() == 0) {
                MBTempContainer.this.defaultLoad(-1, "WebView load timeout");
            } else {
                MBTempContainer.this.U = -3;
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBTempContainer.this.getActivityProxy().a() == 0) {
                MBTempContainer.this.defaultLoad(-3, "Signal Communication connect timeout");
            } else {
                MBTempContainer.this.U = -4;
            }
        }
    }

    class d implements MBridgeVideoView.u {
        d() {
        }

        @Override // com.mbridge.msdk.video.module.MBridgeVideoView.u
        public void a() {
            if (MBTempContainer.this.s != null) {
                MBTempContainer.this.l();
                if (!MBTempContainer.this.s.isDynamicView()) {
                    MBTempContainer.this.u.a(MBTempContainer.this.M);
                } else if (!((AbstractJSContainer) MBTempContainer.this).p) {
                    MBTempContainer.this.u.a(MBTempContainer.this.M);
                } else if (MBTempContainer.this.s.isCampaignIsFiltered()) {
                    MBTempContainer.this.u.a(MBTempContainer.this.M);
                }
                com.mbridge.msdk.video.bt.module.orglistener.f.a(MBTempContainer.this.getContext(), MBTempContainer.this.s, ((AbstractJSContainer) MBTempContainer.this).d, MBTempContainer.this.x);
            }
        }
    }

    class e implements com.mbridge.msdk.video.dynview.listener.f {
        e() {
        }

        @Override // com.mbridge.msdk.video.dynview.listener.f
        public void a() {
            MBTempContainer.this.w();
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBTempContainer.this.b0 != null) {
                MBTempContainer.this.b0.setVisibility(8);
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((AbstractJSContainer) MBTempContainer.this).c != null) {
                ((AbstractJSContainer) MBTempContainer.this).c.finish();
            }
        }
    }

    class i implements d.b {
        i() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.d.b
        public void a(double d) {
            MBridgeContainerView mBridgeContainerView;
            p0.b(MBTempContainer.s0, "volume is : " + d);
            try {
                if (!MBTempContainer.this.s.isMraid() || (mBridgeContainerView = MBTempContainer.this.S) == null || mBridgeContainerView.getH5EndCardView() == null) {
                    return;
                }
                MBTempContainer.this.S.getH5EndCardView().volumeChange(d);
            } catch (Exception e) {
                p0.b(MBTempContainer.s0, e.getMessage());
            }
        }
    }

    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MBTempContainer.this.b0.setBackgroundColor(0);
            MBTempContainer.this.b0.setVisibility(0);
            MBTempContainer.this.b0.bringToFront();
        }
    }

    public interface k {

        public static class a implements k {

            /* renamed from: a, reason: collision with root package name */
            private boolean f5002a = false;

            @Override // com.mbridge.msdk.video.bt.module.MBTempContainer.k
            public void a(boolean z) {
                this.f5002a = z;
            }

            @Override // com.mbridge.msdk.video.bt.module.MBTempContainer.k
            public void onError(String str) {
                p0.b("ActivityErrorListener", str);
                this.f5002a = true;
            }
        }

        void a(boolean z);

        void onError(String str);
    }

    private static final class l extends AppletSchemeCallBack {

        /* renamed from: a, reason: collision with root package name */
        private CampaignEx f5003a;

        public l(CampaignEx campaignEx) {
            this.f5003a = campaignEx;
        }

        @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
        protected void onRequestFailed(int i, String str, String str2) {
            if (MBridgeConstans.DEBUG) {
                p0.a(MBTempContainer.s0, "request wx scheme failed: errorCode: " + i + " errorMessage: " + str);
            }
            try {
                CampaignEx campaignEx = this.f5003a;
                if (campaignEx != null) {
                    campaignEx.setClickURL(str2);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b(MBTempContainer.s0, e.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
        protected void onRequestStart() {
            if (MBridgeConstans.DEBUG) {
                p0.a(MBTempContainer.s0, "start request wx scheme");
            }
        }

        @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
        protected void onRequestSuccess(String str) {
            if (MBridgeConstans.DEBUG) {
                p0.a(MBTempContainer.s0, "request wx scheme success");
            }
            try {
                CampaignEx campaignEx = this.f5003a;
                if (campaignEx != null) {
                    campaignEx.setDeepLinkUrl(str);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b(MBTempContainer.s0, e.getMessage());
                }
            }
        }
    }

    private final class m extends com.mbridge.msdk.video.module.listener.impl.a {
        public m(Activity activity, CampaignEx campaignEx) {
            super(activity, campaignEx);
        }

        @Override // com.mbridge.msdk.video.module.listener.impl.a, com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
        public void a(int i, Object obj) {
            if (com.mbridge.msdk.util.b.a()) {
                MBTempContainer.this.setChinaJsCommonContext();
            }
            if (i != 108) {
                if (i != 113) {
                    if (i == 117) {
                        MBridgeVideoView mBridgeVideoView = MBTempContainer.this.mbridgeVideoView;
                        if (mBridgeVideoView != null) {
                            mBridgeVideoView.setVisible(4);
                        }
                        MBTempContainer.this.j0 = true;
                        MBTempContainer.this.u.a(((AbstractJSContainer) MBTempContainer.this).e, ((AbstractJSContainer) MBTempContainer.this).d);
                    } else if (i == 126 || i == 128) {
                        MBTempContainer.this.u.a(false, ((AbstractJSContainer) MBTempContainer.this).e, ((AbstractJSContainer) MBTempContainer.this).d);
                    } else if (i != 131) {
                        switch (i) {
                            case 103:
                            case 104:
                                MBTempContainer.this.onAdClose();
                                break;
                            case 105:
                                if (com.mbridge.msdk.util.b.a()) {
                                    MBTempContainer.this.setChinaCTACallBack();
                                }
                                MBTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                                break;
                            case 106:
                                if (com.mbridge.msdk.util.b.a()) {
                                    MBTempContainer mBTempContainer = MBTempContainer.this;
                                    mBTempContainer.setChinaBrowserCallBack(mBTempContainer.v, MBTempContainer.this.y, MBTempContainer.this.u, MBTempContainer.this.s);
                                    if (((AbstractJSContainer) MBTempContainer.this).c != null && MBTempContainer.this.s != null) {
                                        MBTempContainer.this.onAdClose();
                                        break;
                                    }
                                }
                                break;
                        }
                    } else {
                        MBTempContainer.this.u.a(true, ((AbstractJSContainer) MBTempContainer.this).e, ((AbstractJSContainer) MBTempContainer.this).d);
                    }
                }
                MBTempContainer.this.u.a(true, ((AbstractJSContainer) MBTempContainer.this).e, ((AbstractJSContainer) MBTempContainer.this).d);
            } else {
                if (com.mbridge.msdk.util.b.a()) {
                    MBTempContainer mBTempContainer2 = MBTempContainer.this;
                    mBTempContainer2.setChinaCallBackStatus(mBTempContainer2.R);
                }
                MBTempContainer.this.getJSCommon().a(new a.b(MBTempContainer.this.getJSCommon(), new o(MBTempContainer.this, null)));
                MBTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
            }
            super.a(i, obj);
        }
    }

    private final class n extends com.mbridge.msdk.video.module.listener.impl.f {
        private n() {
        }

        @Override // com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
        public void a(int i, Object obj) {
            super.a(i, obj);
            try {
                String obj2 = obj instanceof JSONObject ? obj.toString() : (String) obj;
                if (((AbstractJSContainer) MBTempContainer.this).k && !TextUtils.isEmpty(obj2)) {
                    JSONObject jSONObject = new JSONObject(obj2);
                    int optInt = jSONObject.optInt("type");
                    int optInt2 = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
                    if (optInt == 2) {
                        MBTempContainer.this.A = com.mbridge.msdk.foundation.same.a.D;
                    } else if (optInt != 3) {
                        MBTempContainer.this.A = com.mbridge.msdk.foundation.same.a.F;
                    } else {
                        MBTempContainer.this.A = com.mbridge.msdk.foundation.same.a.E;
                    }
                    MBTempContainer.this.B = optInt2;
                }
            } catch (Exception unused) {
                p0.b("NotifyListener", "PlayableResultListener ERROR");
            }
            if (i == 120) {
                MBTempContainer.this.u.a(((AbstractJSContainer) MBTempContainer.this).e, ((AbstractJSContainer) MBTempContainer.this).d);
            }
            if (i == 131) {
                MBTempContainer.this.getJSCommon().click(4, obj != null ? obj.toString() : "");
                return;
            }
            if (i == 126) {
                MBTempContainer.this.u.a(false, ((AbstractJSContainer) MBTempContainer.this).e, ((AbstractJSContainer) MBTempContainer.this).d);
                return;
            }
            if (i == 127) {
                MBTempContainer.this.d0 = true;
                MBTempContainer.this.u.a(MBTempContainer.this.M);
                MBTempContainer.this.u.a(((AbstractJSContainer) MBTempContainer.this).e, ((AbstractJSContainer) MBTempContainer.this).d);
                MBTempContainer.this.getJSContainerModule().showEndcard(100);
                return;
            }
            switch (i) {
                case 100:
                    MBTempContainer.this.k0 = true;
                    MBTempContainer mBTempContainer = MBTempContainer.this;
                    mBTempContainer.T.postDelayed(mBTempContainer.q0, 250L);
                    MBTempContainer.this.u.a(MBTempContainer.this.M);
                    break;
                case 101:
                case 102:
                    MBTempContainer.this.getJSCommon().f();
                    break;
                case 103:
                    MBTempContainer.this.d0 = true;
                    if (!MBTempContainer.this.s.isMraid()) {
                        MBTempContainer.this.getJSCommon().f();
                        break;
                    } else {
                        MBTempContainer.this.onAdClose();
                        break;
                    }
                case 104:
                    MBTempContainer.this.onAdClose();
                    break;
                case 105:
                    if (com.mbridge.msdk.util.b.a()) {
                        MBTempContainer.this.setChinaCTACallBack();
                    }
                    MBTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                    break;
            }
        }

        /* synthetic */ n(MBTempContainer mBTempContainer, b bVar) {
            this();
        }
    }

    private class o extends a.C0419a {
        private o() {
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0419a, com.mbridge.msdk.video.signal.a.InterfaceC0418a
        public void a(boolean z) {
            if (MBTempContainer.this.o0 != null) {
                try {
                    MBTempContainer.this.o0.adUserInteraction(InteractionType.CLICK);
                    p0.a("omsdk", "mbtc adUserInteraction click");
                } catch (Exception e) {
                    p0.b("omsdk", e.getMessage());
                }
            }
            super.a(z);
            MBTempContainer.this.u.a(z, ((AbstractJSContainer) MBTempContainer.this).e, ((AbstractJSContainer) MBTempContainer.this).d);
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0419a, com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            super.onFinishRedirection(campaign, str);
            MBTempContainer.this.h0 = true;
            MBTempContainer.this.m();
            if (campaign != null && (campaign instanceof CampaignEx)) {
                try {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    String optString = new JSONObject(MBTempContainer.this.getJSVideoModule().getCurrentProgress()).optString(NotificationCompat.CATEGORY_PROGRESS, "");
                    if (campaignEx.getLinkType() == 3 && campaignEx.getEndcard_click_result() == 2 && optString.equals("1.0") && ((AbstractJSContainer) MBTempContainer.this).c != null) {
                        if (((AbstractJSContainer) MBTempContainer.this).p) {
                            MBTempContainer.this.onAdClose();
                        } else {
                            ((AbstractJSContainer) MBTempContainer.this).c.finish();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (MBTempContainer.this.r0) {
                MBTempContainer.this.onResume();
            }
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0419a, com.mbridge.msdk.video.signal.a.InterfaceC0418a
        public void onInitSuccess() {
            super.onInitSuccess();
            MBTempContainer.this.receiveSuccess();
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0419a, com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            super.onRedirectionFailed(campaign, str);
            MBTempContainer.this.m();
            MBTempContainer.this.h0 = true;
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0419a, com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            super.onStartRedirection(campaign, str);
            MBTempContainer.this.y();
            if (MBTempContainer.this.r0) {
                MBTempContainer.this.onPause();
            }
        }

        /* synthetic */ o(MBTempContainer mBTempContainer, b bVar) {
            this();
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0419a, com.mbridge.msdk.video.signal.a.InterfaceC0418a
        public void a(int i, String str) {
            super.a(i, str);
            MBTempContainer.this.defaultLoad(i, str);
        }

        @Override // com.mbridge.msdk.video.signal.impl.a.C0419a, com.mbridge.msdk.video.signal.a.InterfaceC0418a
        public void a() {
            super.a();
            MBTempContainer mBTempContainer = MBTempContainer.this;
            Handler handler = mBTempContainer.T;
            if (handler != null) {
                handler.removeCallbacks(mBTempContainer.W);
            }
        }
    }

    private final class p extends com.mbridge.msdk.video.module.listener.impl.f {
        private p() {
        }

        /* JADX WARN: Removed duplicated region for block: B:69:0x0161  */
        @Override // com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(int i, Object obj) {
            String str;
            super.a(i, obj);
            if (((AbstractJSContainer) MBTempContainer.this).k) {
                try {
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (!TextUtils.isEmpty(str2)) {
                            JSONObject jSONObject = new JSONObject(str2);
                            MBTempContainer.this.A = jSONObject.getInt("Alert_window_status");
                            MBTempContainer.this.B = jSONObject.getInt("complete_info");
                        }
                    }
                } catch (Exception e) {
                    p0.b("NotifyListener", e.getMessage());
                }
            }
            if (i != 2) {
                if (i == 121) {
                    MBTempContainer.this.d0 = true;
                    MBTempContainer.this.u.b(((AbstractJSContainer) MBTempContainer.this).e, ((AbstractJSContainer) MBTempContainer.this).d);
                    MBTempContainer.this.i0 = false;
                    return;
                }
                if (i == 16) {
                    if (com.mbridge.msdk.util.b.a()) {
                        MBTempContainer.this.onAdClose();
                        return;
                    } else {
                        MBTempContainer.this.getJSCommon().f();
                        return;
                    }
                }
                if (i == 17) {
                    MBTempContainer.this.d0 = true;
                    MBridgeContainerView mBridgeContainerView = MBTempContainer.this.S;
                    if (mBridgeContainerView != null) {
                        mBridgeContainerView.setRewardStatus(true);
                        return;
                    }
                    return;
                }
                switch (i) {
                    case 10:
                        MBTempContainer.this.i0 = true;
                        if (MBTempContainer.this.s != null && !r0.a().a("i_l_s_t_r_i", false)) {
                            MBTempContainer.this.l();
                            if (!MBTempContainer.this.s.isDynamicView()) {
                                MBTempContainer.this.u.a(MBTempContainer.this.M);
                            } else if (!((AbstractJSContainer) MBTempContainer.this).p) {
                                MBTempContainer.this.u.a(MBTempContainer.this.M);
                            } else if (MBTempContainer.this.s.isCampaignIsFiltered()) {
                                MBTempContainer.this.u.a(MBTempContainer.this.M);
                            }
                            com.mbridge.msdk.video.bt.module.orglistener.f.a(MBTempContainer.this.getContext(), MBTempContainer.this.s, ((AbstractJSContainer) MBTempContainer.this).d, MBTempContainer.this.x);
                            break;
                        }
                        break;
                }
            }
            if (i == 12) {
                try {
                } catch (Throwable th) {
                    p0.b("NotifyListener", th.getMessage());
                }
                if (obj instanceof String) {
                    str = obj.toString();
                    com.mbridge.msdk.video.bt.module.orglistener.f.a(MBTempContainer.this.getContext(), MBTempContainer.this.s, ((AbstractJSContainer) MBTempContainer.this).d, str, MBTempContainer.this.x);
                    if (!MBTempContainer.this.i0) {
                        if (((AbstractJSContainer) MBTempContainer.this).f.C() == 0) {
                            MBTempContainer.this.u.a(MBTempContainer.this.M, "play error");
                            MBTempContainer.this.i0 = false;
                            MBTempContainer.this.onAdClose();
                            return;
                        }
                        MBTempContainer.this.l();
                        if (MBTempContainer.this.s == null || !MBTempContainer.this.s.isDynamicView()) {
                            MBTempContainer.this.u.a(MBTempContainer.this.M);
                        } else if (!((AbstractJSContainer) MBTempContainer.this).p) {
                            MBTempContainer.this.u.a(MBTempContainer.this.M);
                        } else if (MBTempContainer.this.s.isCampaignIsFiltered()) {
                            MBTempContainer.this.u.a(MBTempContainer.this.M);
                        }
                    }
                }
                str = "Play error but has no message.";
                com.mbridge.msdk.video.bt.module.orglistener.f.a(MBTempContainer.this.getContext(), MBTempContainer.this.s, ((AbstractJSContainer) MBTempContainer.this).d, str, MBTempContainer.this.x);
                if (!MBTempContainer.this.i0) {
                }
            }
            MBTempContainer.this.getJSVideoModule().videoOperate(i == 2 ? 6 : 3);
            MBTempContainer.this.i0 = false;
            if (MBTempContainer.this.o0 == null || i != 2) {
                return;
            }
            p0.b("omsdk", "mbtc skip");
            try {
                MBTempContainer.this.o0.skipped();
                MBTempContainer.this.o0 = null;
            } catch (Exception e2) {
                p0.a("omsdk", e2.getMessage());
            }
        }

        /* synthetic */ p(MBTempContainer mBTempContainer, b bVar) {
            this();
        }
    }

    public MBTempContainer(Context context) {
        super(context);
        this.x = 1;
        this.y = "";
        this.A = com.mbridge.msdk.foundation.same.a.F;
        this.C = false;
        this.I = "";
        this.K = new ArrayList();
        this.L = 0;
        this.N = false;
        this.P = false;
        this.Q = new k.a();
        this.T = new Handler();
        this.U = 0;
        this.V = 0;
        this.W = new b();
        this.a0 = new c();
        this.c0 = false;
        this.d0 = false;
        this.e0 = false;
        this.g0 = false;
        this.h0 = false;
        this.i0 = false;
        this.j0 = false;
        this.k0 = false;
        this.l0 = false;
        this.n0 = null;
        this.o0 = null;
        this.p0 = null;
        this.q0 = new f();
        this.r0 = false;
        init(context);
    }

    private int getBufferTimeout() {
        try {
            com.mbridge.msdk.videocommon.setting.a c2 = com.mbridge.msdk.videocommon.setting.b.b().c();
            if (c2 == null) {
                com.mbridge.msdk.videocommon.setting.b.b().a();
            }
            if (c2 != null) {
                return (int) c2.i();
            }
            return 5;
        } catch (Throwable th) {
            th.printStackTrace();
            return 5;
        }
    }

    private int getCloseBtnTime() {
        CampaignEx campaignEx = this.s;
        if (campaignEx == null) {
            return 1;
        }
        boolean a2 = u0.a(MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE, campaignEx.getendcard_url());
        int c2 = u0.c(this.s.getendcard_url(), MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE);
        return (!a2 || c2 < 0) ? this.s.getCbd() > -2 ? this.s.getCbd() : this.f.i() : c2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdClose() {
        int i2;
        try {
            com.mbridge.msdk.video.bt.module.listener.b bVar = this.v;
            if (bVar == null) {
                Activity activity = this.c;
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            if (this.k && ((i2 = this.m) == com.mbridge.msdk.foundation.same.a.H || i2 == com.mbridge.msdk.foundation.same.a.I)) {
                boolean z = true;
                if (this.B != 1) {
                    z = false;
                }
                bVar.a(z, this.A);
            }
            this.v.a(this.y, this.d0, this.h);
        } catch (Exception unused) {
            Activity activity2 = this.c;
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    public boolean canBackPress() {
        MBridgeContainerView mBridgeContainerView = this.S;
        return mBridgeContainerView == null || mBridgeContainerView.canBackPress();
    }

    public void defaultLoad(int i2, String str) {
        int i3;
        superDefaultLoad(i2, str);
        CampaignEx campaignEx = this.s;
        if (campaignEx != null && !campaignEx.isDynamicView()) {
            this.s.setTemplateRenderSucc(false);
        }
        if (!isLoadSuccess()) {
            b(i2, str);
            Activity activity = this.c;
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        b bVar = null;
        if (this.s.getPlayable_ads_without_video() == 2) {
            this.S.setCampaign(this.s);
            this.S.addOrderViewData(this.K);
            this.S.setUnitID(this.d);
            this.S.setCloseDelayTime(getCloseBtnTime());
            this.S.setPlayCloseBtnTm(this.f.u());
            this.S.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.h(this.s, this.t, this.h, getInnerPlacementId(), this.d, new n(this, bVar), this.f.A(), this.p));
            this.S.preLoadData(this.z);
            this.z.getJSCommon().g(this.j);
            this.S.showPlayableView();
        } else {
            b(i2, str);
            this.b0.setVisibility(8);
            loadModuleDatas();
            int E = this.f.E();
            int h5CloseType = getH5CloseType();
            int i4 = h5CloseType != 0 ? h5CloseType : E;
            CampaignEx campaignEx2 = this.s;
            if (campaignEx2 != null && campaignEx2.isDynamicView()) {
                this.mbridgeVideoView.setContainerViewOnNotifyListener(new m(this.c, this.s));
            }
            CampaignEx campaignEx3 = this.s;
            int F = (campaignEx3 == null || campaignEx3.getVst() <= -2) ? this.f.F() : this.s.getVst();
            CampaignEx campaignEx4 = this.s;
            if (campaignEx4 != null && campaignEx4.getDynamicTempCode() == 5 && (i3 = this.x) > 1) {
                F = a(F, i3);
                this.s.setVst(F);
            }
            int i5 = F;
            this.mbridgeVideoView.setVideoSkipTime(i5);
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            mBridgeVideoView.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.m(mBridgeVideoView, this.S, this.s, this.h, this.t, getInnerPlacementId(), this.d, i4, i5, new p(this, bVar), this.f.A(), this.p, this.f.C()));
            this.mbridgeVideoView.setAdSession(this.n0);
            this.mbridgeVideoView.setVideoEvents(this.o0);
            this.mbridgeVideoView.defaultShow();
            MBridgeContainerView mBridgeContainerView = this.S;
            mBridgeContainerView.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.b(this.mbridgeVideoView, mBridgeContainerView, this.s, this.h, this.t, getInnerPlacementId(), this.d, new m(this.c, this.s), this.f.A(), this.p));
            this.S.defaultShow();
        }
        q();
    }

    public int findID(String str) {
        return h0.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return h0.a(getContext(), str, "layout");
    }

    public MBridgeContainerView findMBridgeContainerView() {
        return (MBridgeContainerView) findViewById(findID("mbridge_video_templete_container"));
    }

    public MBridgeVideoView findMBridgeVideoView() {
        return (MBridgeVideoView) findViewById(findID("mbridge_video_templete_videoview"));
    }

    public WindVaneWebView findWindVaneWebView() {
        a.C0420a b2;
        try {
            if (this.p) {
                CampaignEx campaignEx = this.s;
                if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || (b2 = com.mbridge.msdk.videocommon.a.b(this.d + "_" + this.s.getId() + "_" + this.s.getRequestId() + "_" + this.s.getRewardTemplateMode().e())) == null) {
                    return null;
                }
                return b2.b();
            }
            a.C0420a a2 = this.k ? com.mbridge.msdk.videocommon.a.a(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.s) : com.mbridge.msdk.videocommon.a.a(94, this.s);
            if (a2 == null || !a2.c()) {
                return null;
            }
            if (this.k) {
                com.mbridge.msdk.videocommon.a.b(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.s);
            } else {
                com.mbridge.msdk.videocommon.a.b(94, this.s);
            }
            WindVaneWebView b3 = a2.b();
            if (this.g0) {
                b3.setWebViewTransparent();
            }
            return b3;
        } catch (Exception e2) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public AdEvents getAdEvents() {
        return this.p0;
    }

    public AdSession getAdSession() {
        return this.n0;
    }

    public CampaignEx getCampaign() {
        return this.s;
    }

    protected RelativeLayout.LayoutParams getContentLayoutParams() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    protected int getH5CloseType() {
        com.mbridge.msdk.video.signal.impl.k b2 = b(this.s);
        if (b2 != null) {
            return b2.l();
        }
        return 0;
    }

    protected int getH5DialogRole() {
        if (getJSCommon() != null) {
            return getJSCommon().d();
        }
        return 1;
    }

    protected int getH5MuteState() {
        com.mbridge.msdk.video.signal.impl.k b2 = b(this.s);
        if (b2 != null) {
            return b2.m();
        }
        return 0;
    }

    public String getInstanceId() {
        return this.y;
    }

    protected boolean getIsShowingTransparent() {
        com.mbridge.msdk.video.signal.impl.k b2 = b(this.s);
        if (b2 != null) {
            return b2.p();
        }
        return false;
    }

    public int getLayoutID() {
        return findLayout(this.g0 ? "mbridge_reward_activity_video_templete_transparent" : "mbridge_reward_activity_video_templete");
    }

    public MediaEvents getVideoEvents() {
        return this.o0;
    }

    public void init(Context context) {
        this.O = LayoutInflater.from(context);
    }

    public boolean initViews() {
        View findViewById = findViewById(findID("mbridge_video_templete_progressbar"));
        this.b0 = findViewById;
        return findViewById != null;
    }

    public boolean isHasDestoryed() {
        return this.C;
    }

    public boolean isLoadSuccess() {
        return this.P;
    }

    public void loadModuleDatas() {
        int i2;
        int i3;
        int h5MuteState = getH5MuteState();
        if (h5MuteState != 0) {
            this.j = h5MuteState;
        }
        int E = this.f.E();
        int h5CloseType = getH5CloseType();
        int i4 = h5CloseType != 0 ? h5CloseType : E;
        this.mbridgeVideoView.setSoundState(this.j);
        this.mbridgeVideoView.setCampaign(this.s);
        this.mbridgeVideoView.setPlayURL(this.t.g());
        CampaignEx campaignEx = this.s;
        int F = (campaignEx == null || campaignEx.getVst() <= -2) ? this.f.F() : this.s.getVst();
        CampaignEx campaignEx2 = this.s;
        if (campaignEx2 != null && campaignEx2.getDynamicTempCode() == 5 && (i3 = this.x) > 1) {
            F = a(F, i3);
            this.s.setVst(F);
        }
        int i5 = F;
        this.mbridgeVideoView.setVideoSkipTime(i5);
        this.mbridgeVideoView.setCloseAlert(this.f.h());
        this.mbridgeVideoView.setBufferTimeout(getBufferTimeout());
        b bVar = null;
        this.mbridgeVideoView.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.n(this.z, this.s, this.h, this.t, getInnerPlacementId(), this.d, i4, i5, new p(this, bVar), this.f.A(), this.p, this.f.C()));
        this.mbridgeVideoView.setShowingTransparent(this.g0);
        this.mbridgeVideoView.setAdSession(this.n0);
        if (this.k && ((i2 = this.m) == com.mbridge.msdk.foundation.same.a.H || i2 == com.mbridge.msdk.foundation.same.a.I)) {
            this.mbridgeVideoView.setIVRewardEnable(i2, this.n, this.o);
            this.mbridgeVideoView.setDialogRole(getH5DialogRole());
        }
        this.S.setCampaign(this.s);
        this.S.addOrderViewData(this.K);
        this.S.setUnitID(this.d);
        this.S.setCloseDelayTime(getCloseBtnTime());
        this.S.setPlayCloseBtnTm(this.f.u());
        this.S.setVideoInteractiveType(this.f.D());
        this.S.setEndscreenType(this.f.m());
        this.S.setVideoSkipTime(i5);
        this.S.setShowingTransparent(this.g0);
        this.S.setJSFactory(this.z);
        this.z.getJSCommon().g(this.j);
        if (this.s.getPlayable_ads_without_video() == 2) {
            this.S.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.h(this.s, this.t, this.h, getInnerPlacementId(), this.d, new n(this, bVar), this.f.A(), this.p));
            this.S.preLoadData(this.z);
            this.S.showPlayableView();
        } else {
            this.S.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.c(this.z, this.s, this.h, this.t, getInnerPlacementId(), this.d, new m(this.c, this.s), this.f.A(), this.p));
            this.S.preLoadData(this.z);
            this.mbridgeVideoView.preLoadData(this.z);
        }
        if (this.g0) {
            this.S.setMBridgeClickMiniCardViewTransparent();
        }
    }

    public void onBackPressed() {
        MBridgeContainerView mBridgeContainerView;
        MBridgeContainerView mBridgeContainerView2;
        MBridgeVideoView mBridgeVideoView;
        MBridgeVideoView mBridgeVideoView2;
        if (this.g0 && (mBridgeVideoView2 = this.mbridgeVideoView) != null) {
            mBridgeVideoView2.notifyVideoClose();
            return;
        }
        CampaignEx campaignEx = this.s;
        if (((campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.s.getRewardTemplateMode().f() == 5002010) || this.i0) && (mBridgeVideoView = this.mbridgeVideoView) != null) {
            if (!mBridgeVideoView.isMiniCardShowing()) {
                this.mbridgeVideoView.onBackPress();
                return;
            }
            MBridgeContainerView mBridgeContainerView3 = this.S;
            if (mBridgeContainerView3 != null) {
                mBridgeContainerView3.onMiniEndcardBackPress();
                return;
            }
            return;
        }
        if (this.k0 && (mBridgeContainerView2 = this.S) != null) {
            mBridgeContainerView2.onPlayableBackPress();
            return;
        }
        if (this.j0 && (mBridgeContainerView = this.S) != null) {
            mBridgeContainerView.onEndcardBackPress();
        }
        if (getJSCommon().a()) {
            if (getJSContainerModule() == null || !getJSContainerModule().miniCardShowing()) {
                getActivityProxy().e();
                return;
            }
            return;
        }
        if (!canBackPress()) {
            p0.a(s0, "onBackPressed can't excute");
            return;
        }
        Activity activity = this.c;
        if (activity == null || this.p || this.l0) {
            return;
        }
        this.l0 = true;
        activity.onBackPressed();
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate() {
        k();
        try {
            A();
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
        this.l0 = false;
        try {
            if (this.p) {
                CampaignEx campaignEx = this.s;
                if (campaignEx == null || !campaignEx.isDynamicView()) {
                    this.u = new com.mbridge.msdk.video.bt.module.orglistener.c(this.v, this.y);
                } else {
                    this.u = new com.mbridge.msdk.video.bt.module.orglistener.d(getContext(), this.k, this.f, this.s, this.u, getInnerPlacementId(), this.d);
                }
            } else {
                this.u = new com.mbridge.msdk.video.bt.module.orglistener.d(getContext(), this.k, this.f, this.s, this.u, getInnerPlacementId(), this.d);
            }
            registerErrorListener(new com.mbridge.msdk.video.bt.module.orglistener.e(this.M, this.u));
            a(this.f, this.s);
            setShowingTransparent();
            int layoutID = getLayoutID();
            if (!h0.a(layoutID)) {
                b("layoutID not found");
                return;
            }
            View inflate = this.O.inflate(layoutID, (ViewGroup) null);
            this.r = inflate;
            addView(inflate, getContentLayoutParams());
            x();
            if (n()) {
                this.P = true;
                p();
                return;
            }
            this.Q.onError("not found View IDS");
            Activity activity = this.c;
            if (activity != null) {
                activity.finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            b("onCreate error" + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onDestroy() {
        if (this.C) {
            return;
        }
        this.C = true;
        super.onDestroy();
        try {
            if (com.mbridge.msdk.util.b.a()) {
                setChinaDestroy();
            }
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.releasePlayer();
            }
            WindVaneWebView windVaneWebView = this.R;
            if (windVaneWebView != null) {
                ViewGroup viewGroup = (ViewGroup) windVaneWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.R.clearWebView();
                this.R.release();
            }
            if (this.v != null) {
                this.v = null;
            }
            this.T.removeCallbacks(this.W);
            this.T.removeCallbacks(this.a0);
            getJSCommon().release();
            if (this.k) {
                com.mbridge.msdk.setting.h.b().g(this.d);
            }
            if (!this.c0) {
                r();
            }
            if (!this.f0) {
                s();
            }
            com.mbridge.msdk.mbsignalcommon.mraid.d dVar = this.m0;
            if (dVar != null) {
                dVar.d();
            }
            if (this.n0 != null) {
                p0.b("omsdk", "tc onDestroy");
                this.n0.removeAllFriendlyObstructions();
                this.n0.finish();
                this.n0 = null;
            }
            if (!this.p) {
                if (isLoadSuccess()) {
                    this.T.postDelayed(new g(), 100L);
                } else {
                    Activity activity = this.c;
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }
            if (!this.f0) {
                s();
            }
            com.mbridge.msdk.video.bt.component.d.c().a(this.y);
        } catch (Throwable th) {
            p0.a(s0, th.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onPause() {
        super.onPause();
        this.e0 = true;
        try {
            getJSVideoModule().videoOperate(2);
            MBridgeContainerView mBridgeContainerView = this.S;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setOnPause();
            }
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.onActivityPause();
            }
        } catch (Throwable th) {
            p0.b(s0, th.getMessage(), th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onResume() {
        Activity activity;
        super.onResume();
        t();
        try {
            if (this.mbridgeVideoView != null && !o() && !this.mbridgeVideoView.isMiniCardShowing() && !com.mbridge.msdk.foundation.feedback.b.f) {
                this.mbridgeVideoView.setCover(false);
            }
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.onActivityResume();
            }
            MBridgeContainerView mBridgeContainerView = this.S;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setOnResume();
            }
            if (this.e0 && !o() && !com.mbridge.msdk.foundation.feedback.b.f) {
                getJSVideoModule().videoOperate(1);
            }
            Activity activity2 = this.c;
            if (activity2 != null) {
                u0.a(activity2.getWindow().getDecorView());
            }
            if (this.g0 && this.h0 && (activity = this.c) != null) {
                activity.finish();
            }
        } catch (Throwable th) {
            p0.b(s0, th.getMessage(), th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onStop() {
        super.onStop();
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setCover(true);
            this.mbridgeVideoView.onActivityStop();
        }
    }

    public void preload() {
    }

    public void receiveSuccess() {
        p0.a(s0, "receiveSuccess ,start hybrid");
        this.T.removeCallbacks(this.a0);
        this.T.postDelayed(this.q0, 250L);
    }

    public void registerErrorListener(k kVar) {
        this.Q = kVar;
    }

    public void setAdEvents(AdEvents adEvents) {
        this.p0 = adEvents;
        com.mbridge.msdk.video.signal.factory.b bVar = this.z;
        if (bVar == null || bVar.getJSCommon() == null) {
            return;
        }
        this.z.getJSCommon().setAdEvents(adEvents);
    }

    public void setAdSession(AdSession adSession) {
        this.n0 = adSession;
        com.mbridge.msdk.video.signal.factory.b bVar = this.z;
        if (bVar != null && bVar.getJSCommon() != null) {
            this.z.getJSCommon().setAdSession(adSession);
        }
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setAdSession(adSession);
        }
    }

    public void setCamPlayOrderCallback(com.mbridge.msdk.video.dynview.listener.a aVar, int i2) {
        this.w = aVar;
        this.x = i2;
    }

    public void setCampOrderViewData(List<CampaignEx> list, int i2) {
        if (list != null) {
            this.K = list;
        }
        this.L = i2;
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.s = campaignEx;
        if (campaignEx != null) {
            com.mbridge.msdk.foundation.same.report.metrics.c b2 = com.mbridge.msdk.foundation.same.report.metrics.d.b().b(campaignEx.getCurrentLocalRid());
            this.M = b2;
            if (b2 == null) {
                this.M = new com.mbridge.msdk.foundation.same.report.metrics.c();
            }
            this.M.i(campaignEx.getCurrentLocalRid());
            this.M.a(campaignEx);
            if (TextUtils.isEmpty(campaignEx.getCampaignUnitId()) && !TextUtils.isEmpty(this.d)) {
                campaignEx.setCampaignUnitId(this.d);
            }
            AppletsModel appletsModel = AppletModelManager.getInstance().get(campaignEx);
            if (appletsModel != null) {
                this.r0 = appletsModel.isSupportWxScheme();
            }
            com.mbridge.msdk.foundation.feedback.b.b().a(campaignEx.getCampaignUnitId() + "_1", campaignEx);
        }
    }

    public void setCampaignDownLoadTask(com.mbridge.msdk.videocommon.download.a aVar) {
        this.t = aVar;
    }

    public void setCampaignExpired(boolean z) {
        try {
            CampaignEx campaignEx = this.s;
            if (campaignEx != null) {
                if (!z) {
                    campaignEx.setSpareOfferFlag(0);
                    this.s.setCbt(0);
                    return;
                }
                campaignEx.setSpareOfferFlag(1);
                if (!com.mbridge.msdk.util.b.a()) {
                    com.mbridge.msdk.videocommon.setting.c cVar = this.f;
                    if (cVar != null) {
                        if (cVar.A() == 1) {
                            this.s.setCbt(1);
                            return;
                        } else {
                            this.s.setCbt(0);
                            return;
                        }
                    }
                    return;
                }
                if (this.l) {
                    this.s.setCbt(0);
                    return;
                }
                com.mbridge.msdk.videocommon.setting.c cVar2 = this.f;
                if (cVar2 != null) {
                    if (cVar2.A() == 1) {
                        this.s.setCbt(1);
                    } else {
                        this.s.setCbt(0);
                    }
                }
            }
        } catch (Exception e2) {
            p0.b(s0, e2.getMessage());
        }
    }

    public void setDeveloperExtraData(String str) {
        this.J = str;
    }

    public void setInstanceId(String str) {
        this.y = str;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.z = bVar;
    }

    public void setMBridgeTempCallback(com.mbridge.msdk.video.bt.module.listener.b bVar) {
        this.v = bVar;
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
    }

    public void setMediaPlayerUrl(String str) {
    }

    public void setNotchPadding(int i2, int i3, int i4, int i5, int i6) {
        this.D = i2;
        this.E = i3;
        this.F = i4;
        this.G = i5;
        this.H = i6;
        String a2 = c0.a(i2, i3, i4, i5, i6);
        this.I = a2;
        p0.b(s0, a2);
        if (getJSCommon() != null && !TextUtils.isEmpty(this.I)) {
            getJSCommon().a(this.I);
            if (this.R != null && !TextUtils.isEmpty(this.I)) {
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.R, "oncutoutfetched", Base64.encodeToString(this.I.getBytes(), 0));
            }
        }
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setNotchPadding(i3, i4, i5, i6);
        }
        MBridgeContainerView mBridgeContainerView = this.S;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.setNotchPadding(i2, i3, i4, i5, i6);
        }
    }

    public void setShowRewardListener(com.mbridge.msdk.video.bt.module.orglistener.h hVar) {
        this.u = hVar;
    }

    public void setShowingTransparent() {
        Activity activity;
        boolean isShowingTransparent = getIsShowingTransparent();
        this.g0 = isShowingTransparent;
        if (isShowingTransparent) {
            return;
        }
        int a2 = h0.a(getContext(), "mbridge_reward_theme", "style");
        if (!h0.a(a2) || (activity = this.c) == null) {
            return;
        }
        activity.setTheme(a2);
    }

    public void setVideoEvents(MediaEvents mediaEvents) {
        this.o0 = mediaEvents;
        com.mbridge.msdk.video.signal.factory.b bVar = this.z;
        if (bVar != null && bVar.getJSCommon() != null) {
            this.z.getJSCommon().setVideoEvents(mediaEvents);
        }
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setVideoEvents(mediaEvents);
        }
    }

    public void setWebViewFront(int i2) {
        this.V = i2;
    }

    public void superDefaultLoad(int i2, String str) {
        this.T.removeCallbacks(this.W);
        this.T.removeCallbacks(this.a0);
        this.Q.a(true);
        WindVaneWebView windVaneWebView = this.R;
        if (windVaneWebView != null) {
            windVaneWebView.setVisibility(8);
        }
    }

    private void A() {
        AppletsModel appletsModel;
        if (this.s == null) {
            return;
        }
        try {
            appletsModel = AppletModelManager.getInstance().get(this.s);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
            appletsModel = null;
        }
        if (appletsModel != null) {
            try {
                if (appletsModel.can(0)) {
                    appletsModel.setUserClick(false);
                    appletsModel.requestWxAppletsScheme(0, new l(this.s));
                }
            } catch (Exception e3) {
                appletsModel.clearRequestState();
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private void k() {
        if (this.f == null) {
            this.f = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.d, this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView == null || mBridgeVideoView.notifyListener == null) {
                eVar.a("notify_listener", 0);
            } else {
                eVar.a("notify_listener", 1);
                com.mbridge.msdk.video.module.listener.a aVar = this.mbridgeVideoView.notifyListener;
                if (aVar instanceof com.mbridge.msdk.video.module.listener.impl.n) {
                    eVar.a("listener_type", 1);
                } else if (aVar instanceof com.mbridge.msdk.video.module.listener.impl.m) {
                    eVar.a("listener_type", 2);
                } else {
                    eVar.a("listener_type", 3);
                }
            }
            com.mbridge.msdk.foundation.same.report.metrics.c cVar = this.M;
            if (cVar != null) {
                cVar.a("2000130", eVar);
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (isLoadSuccess()) {
            this.c.runOnUiThread(new a());
        }
    }

    private void q() {
        AdSession adSession = this.n0;
        if (adSession != null) {
            try {
                MBridgeContainerView mBridgeContainerView = this.S;
                FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
                adSession.addFriendlyObstruction(mBridgeContainerView, friendlyObstructionPurpose, null);
                View view = this.b0;
                if (view != null) {
                    this.n0.addFriendlyObstruction(view, friendlyObstructionPurpose, null);
                }
                WindVaneWebView windVaneWebView = this.R;
                if (windVaneWebView != null) {
                    this.n0.addFriendlyObstruction(windVaneWebView, friendlyObstructionPurpose, null);
                }
                this.mbridgeVideoView.setVideoEvents(this.o0);
                this.n0.start();
                if (this.p0 != null) {
                    VastProperties createVastPropertiesForNonSkippableMedia = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
                    p0.a("omsdk", "bt:   adEvents.loaded");
                    this.p0.loaded(createVastPropertiesForNonSkippableMedia);
                    this.p0.impressionOccurred();
                }
            } catch (Exception e2) {
                p0.a("omsdk", e2.getMessage());
            }
        }
    }

    private void r() {
        CampaignEx campaignEx;
        int i2;
        boolean z = true;
        try {
            this.c0 = true;
            CampaignEx campaignEx2 = this.s;
            if (campaignEx2 != null && campaignEx2.getPlayable_ads_without_video() == 2) {
                this.d0 = true;
            }
            MediaEvents mediaEvents = this.o0;
            if (mediaEvents != null && !this.d0) {
                try {
                    mediaEvents.skipped();
                    this.o0 = null;
                } catch (Exception e2) {
                    p0.a("omsdk", e2.getMessage());
                }
            }
            com.mbridge.msdk.video.bt.module.orglistener.h hVar = this.u;
            if (hVar != null) {
                if (this.k && ((i2 = this.m) == com.mbridge.msdk.foundation.same.a.H || i2 == com.mbridge.msdk.foundation.same.a.I)) {
                    if (this.B != 1) {
                        z = false;
                    }
                    hVar.a(z, this.A);
                }
                if (!this.d0) {
                    this.h.a(0);
                }
                this.M.a(this.s);
                this.u.a(this.M, this.d0, this.h);
            }
            this.T.removeCallbacks(this.q0);
            if ((!this.k && !this.p) || ((campaignEx = this.s) != null && campaignEx.isDynamicView())) {
                u();
            }
            if (!this.p) {
                if (this.k) {
                    com.mbridge.msdk.videocommon.a.b(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.s);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, this.s);
                }
            }
            MBridgeContainerView mBridgeContainerView = this.S;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.release();
            }
        } catch (Throwable th) {
            p0.b(s0, th.getMessage(), th);
        }
    }

    private void s() {
        com.mbridge.msdk.foundation.same.report.h hVar = new com.mbridge.msdk.foundation.same.report.h(getContext());
        CampaignEx campaignEx = this.s;
        if (campaignEx != null) {
            hVar.b(campaignEx.getRequestId(), this.s.getRequestIdNotice(), this.s.getId(), this.d, com.mbridge.msdk.mbsignalcommon.mraid.c.b(this.s.getId()), this.s.isBidCampaign());
            com.mbridge.msdk.mbsignalcommon.mraid.c.a(this.s.getId());
            this.f0 = true;
        }
    }

    private void t() {
        int i2 = this.U;
        Runnable runnable = i2 == -3 ? this.W : i2 == -4 ? this.a0 : null;
        if (runnable != null) {
            runnable.run();
            this.U = 0;
        }
    }

    private void u() {
        if (this.d0) {
            if (com.mbridge.msdk.util.b.a() && checkChinaSendToServerDiff(this.u)) {
                return;
            }
            p0.a(s0, "sendToServerRewardInfo");
            com.mbridge.msdk.video.module.report.b.a(this.s, this.h, this.d, this.g, this.J);
        }
    }

    private void v() {
        getJSCommon().setAdEvents(this.p0);
        getJSCommon().setAdSession(this.n0);
        getJSCommon().setVideoEvents(this.o0);
        getJSCommon().g(this.j);
        getJSCommon().setUnitId(this.d);
        getJSCommon().setRewardUnitSetting(this.f);
        getJSCommon().a(new o(this, null));
        CampaignEx campaignEx = this.s;
        if (campaignEx != null) {
            if (campaignEx.isMraid() || this.s.isActiveOm()) {
                com.mbridge.msdk.mbsignalcommon.mraid.d dVar = new com.mbridge.msdk.mbsignalcommon.mraid.d(getContext());
                this.m0 = dVar;
                dVar.c();
                this.m0.a();
                this.m0.a(new i());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        try {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("temp_container", getWidth() + VastAttributes.HORIZONTAL_POSITION + getHeight());
            if (this.R != null) {
                eVar.a("web_view", this.R.getWidth() + VastAttributes.HORIZONTAL_POSITION + this.R.getHeight());
            }
            if (this.mbridgeVideoView != null) {
                eVar.a("mbridge_video_view", this.mbridgeVideoView.getWidth() + VastAttributes.HORIZONTAL_POSITION + this.mbridgeVideoView.getHeight());
                if (this.mbridgeVideoView.mPlayerView != null) {
                    eVar.a("player_view", this.mbridgeVideoView.mPlayerView.getWidth() + VastAttributes.HORIZONTAL_POSITION + this.mbridgeVideoView.mPlayerView.getHeight());
                }
            }
            com.mbridge.msdk.foundation.same.report.metrics.c cVar = this.M;
            if (cVar != null) {
                cVar.a("2000136", eVar);
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (isLoadSuccess()) {
            this.c.runOnUiThread(new j());
        }
    }

    protected boolean n() {
        this.R = findWindVaneWebView();
        MBridgeVideoView findMBridgeVideoView = findMBridgeVideoView();
        this.mbridgeVideoView = findMBridgeVideoView;
        findMBridgeVideoView.setVideoLayout(this.s);
        this.mbridgeVideoView.setIsIV(this.k);
        this.mbridgeVideoView.setUnitId(this.d);
        this.mbridgeVideoView.setCamPlayOrderCallback(this.w, this.K, this.x, this.L);
        if (this.p) {
            this.mbridgeVideoView.setNotchPadding(this.E, this.F, this.G, this.H);
        }
        MBridgeContainerView findMBridgeContainerView = findMBridgeContainerView();
        this.S = findMBridgeContainerView;
        if (this.p) {
            findMBridgeContainerView.setNotchPadding(this.D, this.E, this.F, this.G, this.H);
        }
        if (r0.a().a("i_l_s_t_r_i", false)) {
            this.mbridgeVideoView.setPlayerViewAttachListener(new d());
        }
        this.mbridgeVideoView.setIPlayVideoViewLayoutCallBack(new e());
        return (this.mbridgeVideoView == null || this.S == null || !initViews()) ? false : true;
    }

    protected boolean o() {
        if (this.mbridgeVideoView != null) {
            return com.mbridge.msdk.util.b.a() ? this.mbridgeVideoView.isShowingAlertView() || checkChinaShowingAlertViewState() || this.mbridgeVideoView.isRewardPopViewShowing() : this.mbridgeVideoView.isShowingAlertView() || this.mbridgeVideoView.isRewardPopViewShowing();
        }
        return false;
    }

    protected void p() {
        ViewGroup viewGroup;
        List<CampaignEx> list;
        WindVaneWebView windVaneWebView = this.R;
        CampaignEx campaignEx = this.s;
        if (campaignEx != null) {
            a1.a(windVaneWebView, campaignEx.getLocalRequestId(), this.s.getLocalAllowTrackClick());
        }
        this.z = new com.mbridge.msdk.video.signal.factory.b(this.c, windVaneWebView, this.mbridgeVideoView, this.S, this.s, new o(this, null));
        CampaignEx campaignEx2 = this.s;
        if (campaignEx2 != null && campaignEx2.getDynamicTempCode() == 5 && (list = this.K) != null) {
            this.z.a(list);
        }
        registerJsFactory(this.z);
        com.mbridge.msdk.foundation.feedback.b.b().a(this.d + "_1", new h());
        q();
        if (windVaneWebView == null) {
            defaultLoad(0, "preload template webview is null or load error");
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.r.findViewById(h0.a(getContext(), "mbridge_video_templete_webview_parent", "id"));
        windVaneWebView.setApiManagerJSFactory(this.z);
        if (windVaneWebView.getParent() != null) {
            defaultLoad(0, "preload template webview is null or load error");
            return;
        }
        if (windVaneWebView.getObject() instanceof com.mbridge.msdk.video.signal.impl.k) {
            v();
            getJSContainerModule().readyStatus(((com.mbridge.msdk.video.signal.impl.k) windVaneWebView.getObject()).v());
            z();
            ((com.mbridge.msdk.video.signal.impl.k) windVaneWebView.getObject()).m.onInitSuccess();
            if (this.p) {
                getJSCommon().setWebViewFront(this.V);
            }
        }
        if (getJSCommon().b() == 1 && (viewGroup = (ViewGroup) this.r.findViewById(h0.a(getContext(), "mbridge_video_templete_webview_parent", "id"))) != null) {
            ((ViewGroup) this.r).removeView(viewGroup);
            ((ViewGroup) this.r).addView(viewGroup, 1);
        }
        viewGroup2.addView(windVaneWebView, new ViewGroup.LayoutParams(-1, -1));
    }

    protected void x() {
        if (this.N) {
            setMatchParent();
        }
    }

    protected void z() {
        int g2;
        int f2;
        try {
            if (this.R != null) {
                int i2 = getResources().getConfiguration().orientation;
                if (getIsShowingTransparent()) {
                    g2 = u0.i(getContext());
                    f2 = u0.h(getContext());
                    if (com.mbridge.msdk.foundation.tools.e.a(getContext())) {
                        int c2 = u0.c(getContext());
                        if (i2 == 2) {
                            g2 += c2;
                        } else {
                            f2 += c2;
                        }
                    }
                } else {
                    g2 = u0.g(getContext());
                    f2 = u0.f(getContext());
                }
                int b2 = this.s.getRewardTemplateMode().b();
                if (a(this.s) == 1) {
                    b2 = i2;
                }
                getJSNotifyProxy().a(i2, b2, g2, f2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.mbridge.msdk.foundation.same.a.l, u0.d(getContext()));
                try {
                    if (this.h != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", this.h.c());
                        jSONObject2.put("amount", this.h.a());
                        jSONObject2.put("id", this.i);
                        jSONObject.put("userId", this.g);
                        jSONObject.put(C3288s.j, jSONObject2);
                        jSONObject.put("playVideoMute", this.j);
                        jSONObject.put("extra", this.J);
                    }
                } catch (JSONException e2) {
                    p0.a(s0, e2.getMessage());
                } catch (Exception e3) {
                    p0.a(s0, e3.getMessage());
                }
                String jSONObject3 = jSONObject.toString();
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("type", 2);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000133", this.s, eVar);
                getJSNotifyProxy().a(jSONObject3);
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.R, "oncutoutfetched", Base64.encodeToString(this.I.getBytes(), 0));
                getJSCommon().b(true);
                if (com.mbridge.msdk.util.b.a()) {
                    setChinaCallBackStatus(this.R);
                }
                loadModuleDatas();
                this.T.postDelayed(this.W, 2000L);
            }
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    protected void b(String str) {
        com.mbridge.msdk.video.bt.module.orglistener.h hVar = this.u;
        if (hVar != null) {
            hVar.a(this.M, str);
        }
        super.b(str);
    }

    private int a(int i2, int i3) {
        List<CampaignEx> list;
        if (i2 < 0 || (list = this.K) == null || list.size() == 0 || i3 <= 1) {
            return i2;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i3 - 1; i5++) {
            if (this.K.get(i5) != null) {
                i4 += this.K.get(i5).getVideoLength();
            }
        }
        if (i2 > i4) {
            return i2 - i4;
        }
        return 0;
    }

    private void b(int i2, String str) {
        try {
            com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n();
            nVar.j("2000037");
            nVar.h("code=" + i2 + ",desc=" + str);
            CampaignEx campaignEx = this.s;
            nVar.t((campaignEx == null || campaignEx.getRewardTemplateMode() == null) ? "" : this.s.getRewardTemplateMode().e());
            nVar.u(this.d);
            CampaignEx campaignEx2 = this.s;
            nVar.b(campaignEx2 != null ? campaignEx2.getId() : "");
            CampaignEx campaignEx3 = this.s;
            if (campaignEx3 != null && !TextUtils.isEmpty(campaignEx3.getRequestId())) {
                nVar.n(this.s.getRequestId());
            }
            CampaignEx campaignEx4 = this.s;
            if (campaignEx4 != null && !TextUtils.isEmpty(campaignEx4.getRequestIdNotice())) {
                nVar.o(this.s.getRequestIdNotice());
            }
            int s = l0.s(getContext());
            nVar.c(s);
            nVar.l(l0.a(getContext(), s));
            com.mbridge.msdk.foundation.same.report.o.i(nVar);
        } catch (Throwable th) {
            p0.b(s0, th.getMessage(), th);
        }
    }

    class h implements com.mbridge.msdk.foundation.feedback.a {
        h() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            String str;
            MBTempContainer.this.onPause();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                p0.b(MBTempContainer.s0, th.getMessage(), th);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBTempContainer.this.R, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            String str;
            MBTempContainer.this.onResume();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                p0.b(MBTempContainer.s0, th.getMessage(), th);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBTempContainer.this.R, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            String str2;
            MBTempContainer.this.onResume();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 2);
                }
                str2 = jSONObject.toString();
            } catch (Throwable th) {
                p0.b(MBTempContainer.s0, th.getMessage(), th);
                str2 = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBTempContainer.this.R, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
        }
    }

    public MBTempContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = 1;
        this.y = "";
        this.A = com.mbridge.msdk.foundation.same.a.F;
        this.C = false;
        this.I = "";
        this.K = new ArrayList();
        this.L = 0;
        this.N = false;
        this.P = false;
        this.Q = new k.a();
        this.T = new Handler();
        this.U = 0;
        this.V = 0;
        this.W = new b();
        this.a0 = new c();
        this.c0 = false;
        this.d0 = false;
        this.e0 = false;
        this.g0 = false;
        this.h0 = false;
        this.i0 = false;
        this.j0 = false;
        this.k0 = false;
        this.l0 = false;
        this.n0 = null;
        this.o0 = null;
        this.p0 = null;
        this.q0 = new f();
        this.r0 = false;
        init(context);
    }
}
