package com.mbridge.msdk.splash.signal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbsignalcommon.base.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseSplashSignalCommunicationImpl.java */
/* loaded from: classes6.dex */
public class a implements com.mbridge.msdk.mbsignalcommon.mraid.b {
    private WeakReference<Context> b;
    private List<CampaignEx> c;
    private String d;
    private String e;
    private int f;
    private int g;
    private int i;
    private com.mbridge.msdk.splash.middle.a j;
    private SplashExpandDialog k;

    /* renamed from: a, reason: collision with root package name */
    protected String f4768a = "SplashSignalCommunicationImpl";
    private int h = 5;

    /* compiled from: BaseSplashSignalCommunicationImpl.java */
    /* renamed from: com.mbridge.msdk.splash.signal.a$a, reason: collision with other inner class name */
    class RunnableC0393a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f4769a;

        RunnableC0393a(ArrayList arrayList) {
            this.f4769a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j a2 = j.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                Iterator it = this.f4769a.iterator();
                while (it.hasNext()) {
                    a2.b((String) it.next());
                }
            } catch (Exception unused) {
                p0.b(a.this.f4768a, "campain can't insert db");
            }
        }
    }

    public a(Context context, String str, String str2) {
        this.e = str;
        this.d = str2;
        this.b = new WeakReference<>(context);
    }

    public void a(Context context) {
        this.b = new WeakReference<>(context);
    }

    public void b(int i) {
        this.h = i;
    }

    public void c(int i) {
        this.i = i;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        p0.b(this.f4768a, "close");
        try {
            com.mbridge.msdk.splash.middle.a aVar = this.j;
            if (aVar != null) {
                aVar.close();
            }
        } catch (Throwable th) {
            p0.b(this.f4768a, "close", th);
        }
    }

    public void d(Object obj, String str) {
        p0.a(this.f4768a, "sendImpressions:" + str);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                for (CampaignEx campaignEx : this.c) {
                    if (campaignEx.getId().equals(string)) {
                        com.mbridge.msdk.foundation.same.buffer.b.a(this.d, campaignEx, "splash");
                        arrayList.add(string);
                    }
                }
            }
            new Thread(new RunnableC0393a(arrayList)).start();
        } catch (Throwable th) {
            p0.b(this.f4768a, "sendImpressions", th);
        }
    }

    public void e(Object obj, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", 0);
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, "Call pause count down success.");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("countdown", this.i);
            jSONObject.put("data", jSONObject2);
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            p0.b(this.f4768a, e.getMessage());
        }
        com.mbridge.msdk.splash.middle.a aVar = this.j;
        if (aVar != null) {
            aVar.a(1, -1);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z);
            WeakReference<Context> weakReference = this.b;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            SplashExpandDialog splashExpandDialog = this.k;
            if (splashExpandDialog == null || !splashExpandDialog.isShowing()) {
                SplashExpandDialog splashExpandDialog2 = new SplashExpandDialog(this.b.get(), bundle, this.j);
                this.k = splashExpandDialog2;
                splashExpandDialog2.setCampaignList(this.d, this.c);
                this.k.show();
                com.mbridge.msdk.splash.middle.a aVar = this.j;
                if (aVar != null) {
                    aVar.a(true);
                }
                com.mbridge.msdk.splash.report.a.a(this.d, getMraidCampaign(), str);
            }
        } catch (Throwable th) {
            p0.b(this.f4768a, n.e, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(Object obj, String str) {
        com.mbridge.msdk.splash.middle.a aVar;
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                int optInt = new JSONObject(str).optInt("countdown");
                try {
                    f.a().b(obj, c.a(0));
                    i = optInt;
                } catch (Exception e) {
                    e = e;
                    i = optInt;
                    p0.b(this.f4768a, e.getMessage());
                    aVar = this.j;
                    if (aVar == null) {
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        aVar = this.j;
        if (aVar == null) {
            aVar.a(2, i);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public CampaignEx getMraidCampaign() {
        List<CampaignEx> list = this.c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.c.get(0);
    }

    public void init(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            com.mbridge.msdk.splash.common.b bVar = new com.mbridge.msdk.splash.common.b(com.mbridge.msdk.foundation.controller.c.m().d());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put(C3040d4.h.G, bVar.b());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.c));
            l e = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), this.d);
            if (e == null) {
                e = l.i(this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
                e.d(this.e);
            }
            e.e(this.d);
            e.j(this.h);
            e.a(this.g);
            jSONObject.put("unitSetting", e.M());
            String e2 = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b());
            if (!TextUtils.isEmpty(e2)) {
                jSONObject.put("appSetting", new JSONObject(e2));
            }
            jSONObject.put("sdk_info", d.f4534a);
            p0.b(this.f4768a, C3040d4.a.f + jSONObject.toString());
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            p0.b(this.f4768a, C3040d4.a.f, th);
        }
    }

    public void install(Object obj, String str) {
        p0.b(this.f4768a, "install");
        try {
            List<CampaignEx> list = this.c;
            if (list == null) {
                return;
            }
            CampaignEx campaignEx = (list == null || list.size() <= 0) ? null : this.c.get(0);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject campaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    campaignToJsonObject.put(next, jSONObject.getString(next));
                }
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(campaignToJsonObject);
                String optString = campaignToJsonObject.optString("unitId");
                if (!TextUtils.isEmpty(optString)) {
                    parseCampaignWithBackData.setCampaignUnitId(optString);
                }
                campaignEx = parseCampaignWithBackData;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.mbridge.msdk.splash.middle.a aVar = this.j;
            if (aVar != null) {
                aVar.a(campaignEx);
            }
        } catch (Throwable th) {
            p0.b(this.f4768a, "click", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        com.mbridge.msdk.splash.middle.a aVar = this.j;
        if (aVar != null) {
            aVar.a(true, str);
        }
    }

    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        p0.b(this.f4768a, "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "params is null");
            return;
        }
        Context d = com.mbridge.msdk.foundation.controller.c.m().d();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (d == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                    d = windVaneWebView.getContext();
                }
            } catch (Exception e) {
                p0.b(this.f4768a, e.getMessage());
            }
        }
        if (d == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("type");
            if (optInt == 1) {
                com.mbridge.msdk.click.c.c(d, optString);
            } else if (optInt == 2) {
                com.mbridge.msdk.click.c.e(d, optString);
            }
        } catch (JSONException e2) {
            p0.b(this.f4768a, e2.getMessage());
        } catch (Throwable th) {
            p0.b(this.f4768a, th.getMessage());
        }
    }

    public void reportUrls(Object obj, String str) {
        p0.a(this.f4768a, "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int optInt = jSONObject.optInt("type");
                String a2 = u0.a(jSONObject.optString("url"), "&tun=", l0.y() + "");
                int optInt2 = jSONObject.optInt("report");
                if (optInt2 == 0) {
                    Context d = com.mbridge.msdk.foundation.controller.c.m().d();
                    List<CampaignEx> list = this.c;
                    com.mbridge.msdk.click.a.a(d, list != null ? list.get(0) : null, "", a2, false, optInt != 0);
                } else {
                    Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
                    List<CampaignEx> list2 = this.c;
                    com.mbridge.msdk.click.a.a(d2, list2 != null ? list2.get(0) : null, "", a2, false, optInt != 0, optInt2);
                }
            }
            f.a().b(obj, c.a(0));
        } catch (Throwable th) {
            p0.b(this.f4768a, "reportUrls", th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            com.mbridge.msdk.splash.middle.a aVar = this.j;
            if (aVar != null) {
                aVar.toggleCloseBtn(optInt);
            }
        } catch (Throwable th) {
            p0.b(this.f4768a, "toggleCloseBtn", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        com.mbridge.msdk.splash.middle.a aVar = this.j;
        if (aVar != null) {
            aVar.triggerCloseBtn(obj, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void useCustomClose(boolean z) {
        int i = z ? 2 : 1;
        try {
            com.mbridge.msdk.splash.middle.a aVar = this.j;
            if (aVar != null) {
                aVar.toggleCloseBtn(i);
            }
        } catch (Throwable th) {
            p0.b(this.f4768a, "useCustomClose", th);
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public List<CampaignEx> b() {
        return this.c;
    }

    public void c(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
                f.a().a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b);
            }
        } catch (Throwable th) {
            p0.b(this.f4768a, "onJSBridgeConnect", th);
        }
    }

    public void a(com.mbridge.msdk.splash.middle.a aVar) {
        if (aVar != null) {
            this.j = aVar;
        }
    }

    public com.mbridge.msdk.splash.middle.a a() {
        return this.j;
    }

    public void a(List<CampaignEx> list) {
        this.c = list;
    }

    public void a(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i = new JSONObject(str).getInt("countdown");
            com.mbridge.msdk.splash.middle.a aVar = this.j;
            if (aVar != null) {
                aVar.a(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
