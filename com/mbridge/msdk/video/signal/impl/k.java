package com.mbridge.msdk.video.signal.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.ironsource.Y1;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.foundation.tools.x0;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import com.mbridge.msdk.video.signal.a;
import com.mbridge.msdk.video.signal.impl.a;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JSCommon.java */
/* loaded from: classes6.dex */
public class k extends l {
    private Activity t;
    private String u;
    private String v;
    private CampaignEx x;
    private List<CampaignEx> y;
    private int z;
    private int w = 0;
    private String A = "";
    private String B = "";
    private boolean C = false;
    private boolean D = false;

    /* compiled from: JSCommon.java */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5259a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ int e;

        a(String str, String str2, String str3, String str4, int i) {
            this.f5259a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.g.a(k.this.t.getApplication())).a(new com.mbridge.msdk.foundation.entity.n("2000039", this.f5259a, this.b, this.c, this.d, k.this.x.getId(), this.e, l0.a(k.this.t.getApplication(), this.e)));
        }
    }

    public k(Activity activity, CampaignEx campaignEx) {
        this.t = activity;
        this.x = campaignEx;
    }

    private String A() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.j);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("instanceId", this.A);
            jSONObject2.put("rootViewInstanceId", this.B);
            jSONObject2.put("isRootTemplateWebView", this.C);
            jSONObject.put("sdk_info", "MAL_16.9.91,3.0.1");
            jSONObject2.put("playVideoMute", this.n);
            jSONObject.put("sdkSetting", jSONObject2);
            a(jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<CampaignEx> list = this.y;
            if (list == null || list.size() <= 0) {
                jSONArray.put(CampaignEx.campaignToJsonObject(this.x));
            } else {
                for (CampaignEx campaignEx : this.y) {
                    jSONArray.put(CampaignEx.campaignToJsonObject(campaignEx, campaignEx.isReady(), b(campaignEx)));
                }
            }
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", x());
            String e = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b());
            if (!TextUtils.isEmpty(e)) {
                JSONObject jSONObject3 = new JSONObject(e);
                c(jSONObject3);
                String c = com.mbridge.msdk.setting.h.b().c(this.j);
                if (!TextUtils.isEmpty(c)) {
                    jSONObject3.put("ivreward", new JSONObject(c));
                }
                jSONObject.put("appSetting", jSONObject3);
            }
            jSONObject.put("rewardSetting", w());
            if (!TextUtils.isEmpty(this.j)) {
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.j);
            }
            jSONObject.put("rw_plus", this.D ? "1" : "0");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    private JSONObject B() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.j)) {
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.j);
                return jSONObject;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject C() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.mbridge.msdk.videocommon.setting.c cVar = this.k;
            if (cVar != null) {
                jSONObject.put("unitSetting", cVar.H());
                return jSONObject;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            String e = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b());
            if (!TextUtils.isEmpty(e)) {
                jSONObject.put("appSetting", new JSONObject(e));
                return jSONObject;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.n);
            jSONObject.put("sdkSetting", jSONObject2);
            a(jSONObject);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(CampaignEx.campaignToJsonObject(this.x));
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", x());
            String e = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b());
            if (!TextUtils.isEmpty(e)) {
                JSONObject jSONObject3 = new JSONObject(e);
                c(jSONObject3);
                String c = com.mbridge.msdk.setting.h.b().c(this.j);
                if (!TextUtils.isEmpty(c)) {
                    jSONObject3.put("ivreward", c);
                }
                jSONObject.put("appSetting", jSONObject3.toString());
            }
            jSONObject.put("rewardSetting", w());
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        com.mbridge.msdk.videocommon.setting.a c = com.mbridge.msdk.videocommon.setting.b.b().c();
        return c != null ? c.k() : jSONObject;
    }

    private JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        com.mbridge.msdk.videocommon.setting.c cVar = this.k;
        return cVar != null ? cVar.H() : jSONObject;
    }

    private JSONObject y() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_info", "MAL_16.9.91,3.0.1");
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.n);
            jSONObject2.put("instanceId", this.A);
            jSONObject.put("sdkSetting", jSONObject2);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public void c(CampaignEx campaignEx) {
        this.x = campaignEx;
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.e
    public void click(int i, String str) {
        AppletsModel appletsModel;
        List<CampaignEx> list;
        int i2;
        super.click(i, str);
        CampaignEx campaignEx = this.x;
        if (campaignEx != null && campaignEx.getDynamicTempCode() == 5) {
            b(str);
        }
        try {
            if (i != 1) {
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                    this.m.a(true);
                    return;
                }
                CampaignEx campaignEx2 = this.x;
                if (campaignEx2 == null || campaignEx2.getCbd() <= -2) {
                    com.mbridge.msdk.videocommon.setting.c cVar = this.k;
                    i2 = cVar != null ? cVar.i() : 1;
                } else {
                    i2 = this.x.getCbd();
                }
                if (i2 == -1) {
                    a(new a.b(this, this.m));
                }
                this.w = i;
                click(1, str);
                return;
            }
            if (this.x == null && (list = this.y) != null && list.size() > 0) {
                this.x = this.y.get(0);
            }
            CampaignEx campaignEx3 = this.x;
            if (campaignEx3 == null) {
                return;
            }
            CampaignEx a2 = a(str, campaignEx3);
            if (this.w != 3) {
                this.w = i;
            }
            a(a2);
            if (a2 != null && (appletsModel = AppletModelManager.getInstance().get(a2)) != null) {
                appletsModel.setUserClick(true);
                AppletModelManager.getInstance().replace(appletsModel, a2);
            }
            a(a2, this.t);
        } catch (Throwable th) {
            p0.b("DefaultJSCommon", th.getMessage(), th);
        }
    }

    public void d(String str) {
        this.B = str;
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public String e() {
        p0.a("DefaultJSCommon", "getNotchArea");
        return this.v;
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public void f() {
        super.f();
        try {
            Activity activity = this.t;
            if (activity != null) {
                activity.finish();
            }
        } catch (Throwable th) {
            p0.b("DefaultJSCommon", th.getMessage(), th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public String g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playVideoMute", this.n);
            jSONObject.put("userVideoMute", this.o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void h(int i) {
        this.z = i;
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.e
    public void handlerH5Exception(int i, String str) {
        super.handlerH5Exception(i, str);
        try {
            this.m.a(i, str);
        } catch (Throwable th) {
            p0.b("DefaultJSCommon", th.getMessage(), th);
        }
    }

    public void r() {
        this.u = "";
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public void setActivity(Activity activity) {
        this.t = activity;
    }

    public int v() {
        return this.z;
    }

    private void b(String str) {
        List<CampaignEx> list;
        if (this.x == null || (list = this.y) == null || list.size() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("camp_position")) {
                this.x = this.y.get(jSONObject.getInt("camp_position"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(List<CampaignEx> list) {
        this.y = list;
    }

    public void c(boolean z) {
        this.C = z;
    }

    public void d(boolean z) {
        this.D = z;
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public void h() {
        super.h();
        a.InterfaceC0418a interfaceC0418a = this.m;
        if (interfaceC0418a != null) {
            interfaceC0418a.a();
        }
    }

    private CampaignEx a(String str, CampaignEx campaignEx) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return campaignEx;
        }
        if (TextUtils.isEmpty(str) && campaignEx == null) {
            return null;
        }
        if (!str.contains("notice")) {
            try {
                JSONObject campaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(campaignToJsonObject);
                if (parseCampaignWithBackData == null) {
                    parseCampaignWithBackData = campaignEx;
                }
                if (!TextUtils.isEmpty(str)) {
                    a(campaignToJsonObject, parseCampaignWithBackData);
                    JSONObject optJSONObject = new JSONObject(str).optJSONObject(com.mbridge.msdk.foundation.same.a.j);
                    if (optJSONObject == null) {
                        str2 = "-999";
                        str3 = "-999";
                    } else {
                        str2 = String.valueOf(u0.a(this.t, Integer.valueOf(optJSONObject.getString(com.mbridge.msdk.foundation.same.a.h)).intValue()));
                        str3 = String.valueOf(u0.a(this.t, Integer.valueOf(optJSONObject.getString(com.mbridge.msdk.foundation.same.a.i)).intValue()));
                    }
                    parseCampaignWithBackData.setClickURL(com.mbridge.msdk.click.c.a(parseCampaignWithBackData.getClickURL(), str2, str3));
                    String noticeUrl = parseCampaignWithBackData.getNoticeUrl();
                    if (optJSONObject != null) {
                        Iterator<String> keys = optJSONObject.keys();
                        StringBuilder sb = new StringBuilder();
                        while (keys.hasNext()) {
                            StringBuilder append = sb.append(C3040d4.i.c);
                            String next = keys.next();
                            String optString = optJSONObject.optString(next);
                            if (com.mbridge.msdk.foundation.same.a.h.equals(next) || com.mbridge.msdk.foundation.same.a.i.equals(next)) {
                                optString = String.valueOf(u0.a(this.t, Integer.valueOf(optString).intValue()));
                            }
                            sb = append.append(next).append(C3040d4.i.b).append(optString);
                        }
                        parseCampaignWithBackData.setNoticeUrl(noticeUrl + ((Object) sb));
                    }
                }
                return parseCampaignWithBackData;
            } catch (JSONException e) {
                e.printStackTrace();
                return campaignEx;
            } catch (Throwable th) {
                th.printStackTrace();
                return campaignEx;
            }
        }
        try {
            JSONObject campaignToJsonObject2 = CampaignEx.campaignToJsonObject(campaignEx);
            JSONObject jSONObject = new JSONObject(str);
            b(jSONObject);
            try {
                if (!jSONObject.has(CampaignEx.JSON_KEY_DEEP_LINK_URL)) {
                    campaignToJsonObject2.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, "");
                }
            } catch (Exception unused) {
            }
            Iterator<String> keys2 = jSONObject.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                campaignToJsonObject2.put(next2, jSONObject.getString(next2));
            }
            CampaignEx parseCampaignWithBackData2 = CampaignEx.parseCampaignWithBackData(campaignToJsonObject2);
            a(campaignToJsonObject2, parseCampaignWithBackData2);
            return parseCampaignWithBackData2;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return campaignEx;
        }
    }

    public void c(String str) {
        this.A = str;
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public String c() {
        this.m.onInitSuccess();
        this.f5255a = true;
        if (TextUtils.isEmpty(this.u)) {
            this.u = A();
        } else {
            this.u = u0.b(this.u, "tun", l0.y() + "");
        }
        return this.u;
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public String f(int i) {
        switch (i) {
            case 1:
                return y().toString();
            case 2:
                return B().toString();
            case 3:
                return s().toString();
            case 4:
                return C().toString();
            case 5:
                return u().toString();
            case 6:
                return z().toString();
            default:
                return t().toString();
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            Context d = com.mbridge.msdk.foundation.controller.c.m().d();
            String obj = x0.a(d, "MBridge_ConfirmTitle" + this.j, "").toString();
            String obj2 = x0.a(d, "MBridge_ConfirmContent" + this.j, "").toString();
            String obj3 = x0.a(d, "MBridge_CancelText" + this.j, "").toString();
            String obj4 = x0.a(d, "MBridge_ConfirmText" + this.j, "").toString();
            if (!TextUtils.isEmpty(obj)) {
                jSONObject.put("confirm_title", obj);
            }
            if (!TextUtils.isEmpty(obj2)) {
                jSONObject.put("confirm_description", obj2);
            }
            if (!TextUtils.isEmpty(obj3)) {
                jSONObject.put("confirm_t", obj3);
            }
            if (!TextUtils.isEmpty(obj4)) {
                jSONObject.put("confirm_c_play", obj4);
            }
            if (TextUtils.isEmpty(obj4)) {
                return;
            }
            jSONObject.put("confirm_c_rv", obj4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean b(CampaignEx campaignEx) {
        com.mbridge.msdk.setting.g d;
        try {
            String b = com.mbridge.msdk.foundation.controller.c.m().b();
            long a0 = (TextUtils.isEmpty(b) || (d = com.mbridge.msdk.setting.h.b().d(b)) == null) ? 0L : d.a0() * 1000;
            com.mbridge.msdk.videocommon.setting.a c = com.mbridge.msdk.videocommon.setting.b.b().c();
            long e = c != null ? c.e() : 0L;
            if (campaignEx != null) {
                return campaignEx.isSpareOffer(e, a0);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public k(Activity activity, CampaignEx campaignEx, List<CampaignEx> list) {
        this.t = activity;
        this.x = campaignEx;
        this.y = list;
    }

    public void a(JSONObject jSONObject, CampaignEx campaignEx) {
        try {
            String optString = jSONObject.optString("unitId");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            campaignEx.setCampaignUnitId(optString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public void a(int i, String str) {
        super.a(i, str);
        if (i != 2) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a(jSONObject.optString("event", "event"), jSONObject.optString("template", Y1.f), jSONObject.optString("layout", Y1.f), jSONObject.optString(MBridgeConstans.PROPERTIES_UNIT_ID, this.j), l0.s(this.t.getApplication()));
            if (com.mbridge.msdk.foundation.controller.d.a().e()) {
                com.mbridge.msdk.foundation.same.threadpool.a.b().execute(aVar);
            } else {
                aVar.run();
            }
        } catch (Throwable th) {
            p0.b("DefaultJSCommon", th.getMessage(), th);
        }
    }

    private void a(CampaignEx campaignEx) {
        try {
            int i = this.w;
            if (i == 3) {
                campaignEx.setClickTempSource(2);
                if (campaignEx.getTriggerClickSource() == 0) {
                    campaignEx.setTriggerClickSource(2);
                    return;
                }
                return;
            }
            if (i != 1 || campaignEx.getClickTempSource() == 2) {
                return;
            }
            campaignEx.setClickTempSource(1);
        } catch (Exception e) {
            p0.b("DefaultJSCommon", e.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.v = str;
    }
}
