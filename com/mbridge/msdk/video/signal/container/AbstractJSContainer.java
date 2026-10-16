package com.mbridge.msdk.video.signal.container;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.widget.FrameLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.video.signal.b;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.factory.a;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.video.signal.impl.k;
import com.mbridge.msdk.video.signal.j;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.setting.c;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public abstract class AbstractJSContainer extends FrameLayout implements IJSFactory {

    /* renamed from: a, reason: collision with root package name */
    private int f5253a;
    private int b;
    protected Activity c;
    protected String d;
    protected String e;
    protected c f;
    protected String g;
    protected com.mbridge.msdk.videocommon.entity.c h;
    protected String i;
    protected int j;
    protected boolean k;
    protected boolean l;
    protected int m;
    protected int n;
    protected int o;
    protected boolean p;
    protected IJSFactory q;

    public AbstractJSContainer(Context context) {
        super(context);
        this.f5253a = 0;
        this.b = 1;
        this.j = 2;
        this.k = false;
        this.l = false;
        this.p = false;
        this.q = new a();
    }

    protected void a(Object obj) {
        f.a().b(obj, h(this.f5253a));
    }

    protected void b(Object obj, String str) {
        f.a().b(obj, Base64.encodeToString(str.getBytes(), 2));
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public b getActivityProxy() {
        return this.q.getActivityProxy();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        return this.q.getIJSRewardVideoV1();
    }

    protected String getInnerPlacementId() {
        c cVar;
        return (!TextUtils.isEmpty(this.e) || (cVar = this.f) == null || TextUtils.isEmpty(cVar.t())) ? this.e : this.f.t();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.c getJSBTModule() {
        return this.q.getJSBTModule();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public d getJSCommon() {
        return this.q.getJSCommon();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.f getJSContainerModule() {
        return this.q.getJSContainerModule();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        return this.q.getJSNotifyProxy();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public j getJSVideoModule() {
        return this.q.getJSVideoModule();
    }

    public String getPlacementId() {
        return this.e;
    }

    public String getUnitId() {
        return this.d;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (getJSCommon().a()) {
            getActivityProxy().a(configuration);
        }
    }

    public void onDestroy() {
        if (getJSCommon().a()) {
            getActivityProxy().b();
        }
    }

    public void onPause() {
        if (getJSCommon().a()) {
            getActivityProxy().g();
        }
        getActivityProxy().a(1);
    }

    public void onRestart() {
        if (getJSCommon().a()) {
            getActivityProxy().f();
        }
        getActivityProxy().a(4);
    }

    public void onResume() {
        if (com.mbridge.msdk.foundation.feedback.b.f) {
            return;
        }
        if (getJSCommon().a()) {
            getActivityProxy().d();
        }
        getActivityProxy().a(0);
    }

    public void onStart() {
        if (getJSCommon().a()) {
            getActivityProxy().h();
        }
        getActivityProxy().a(2);
    }

    public void onStop() {
        if (getJSCommon().a()) {
            getActivityProxy().c();
        }
        getActivityProxy().a(3);
    }

    public void registerJsFactory(IJSFactory iJSFactory) {
        this.q = iJSFactory;
    }

    public void setActivity(Activity activity) {
        this.c = activity;
    }

    public void setBidCampaign(boolean z) {
        this.l = z;
    }

    public void setBigOffer(boolean z) {
        this.p = z;
    }

    public void setIV(boolean z) {
        this.k = z;
    }

    public void setIVRewardEnable(int i, int i2, int i3) {
        this.m = i;
        this.n = i2;
        this.o = i3;
    }

    public void setMute(int i) {
        this.j = i;
    }

    public void setPlacementId(String str) {
        this.e = str;
    }

    public void setReward(com.mbridge.msdk.videocommon.entity.c cVar) {
        this.h = cVar;
    }

    public void setRewardId(String str) {
        this.i = str;
    }

    public void setRewardUnitSetting(c cVar) {
        this.f = cVar;
    }

    public void setUnitId(String str) {
        this.d = str;
    }

    public void setUserId(String str) {
        this.g = str;
    }

    private boolean i(int i) {
        try {
            if (i == 1) {
                this.c.setRequestedOrientation(12);
            } else {
                if (i != 2) {
                    return false;
                }
                this.c.setRequestedOrientation(11);
            }
            return true;
        } catch (Throwable th) {
            p0.b("AbstractJSContainer", th.getMessage(), th);
            return false;
        }
    }

    protected void a(Object obj, String str) {
        f.a().a(obj, Base64.encodeToString(str.getBytes(), 2));
    }

    protected void b(String str) {
        p0.b("AbstractJSContainer", str);
        Activity activity = this.c;
        if (activity != null) {
            activity.finish();
        }
    }

    protected int a(CampaignEx campaignEx) {
        k b = b(campaignEx);
        if (b != null) {
            return b.n();
        }
        return 0;
    }

    protected String h(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable unused) {
            p0.b("AbstractJSContainer", "code to string is error");
            return "";
        }
    }

    protected k b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        a.C0420a a2 = com.mbridge.msdk.videocommon.a.a(this.k ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94, campaignEx);
        if (a2 != null && a2.c()) {
            WindVaneWebView b = a2.b();
            if (b.getObject() instanceof k) {
                return (k) b.getObject();
            }
        }
        return null;
    }

    protected void a(c cVar, CampaignEx campaignEx) {
        CampaignEx.c rewardTemplateMode;
        if (a(campaignEx) == 1) {
            return;
        }
        if (((campaignEx == null || (rewardTemplateMode = campaignEx.getRewardTemplateMode()) == null) ? false : i(rewardTemplateMode.b())) || cVar == null) {
            return;
        }
        i(this.f.y());
    }

    public AbstractJSContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5253a = 0;
        this.b = 1;
        this.j = 2;
        this.k = false;
        this.l = false;
        this.p = false;
        this.q = new com.mbridge.msdk.video.signal.factory.a();
    }
}
