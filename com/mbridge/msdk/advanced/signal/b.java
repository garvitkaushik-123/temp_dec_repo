package com.mbridge.msdk.advanced.signal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbsignalcommon.communication.c;
import com.mbridge.msdk.mbsignalcommon.communication.d;
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

/* compiled from: NativeAdvancedSignalCommunicationImpl.java */
/* loaded from: classes6.dex */
public class b extends c {
    private WeakReference<Context> c;
    private List<CampaignEx> d;
    private String e;
    private String f;
    private int g;
    private int h;
    private com.mbridge.msdk.advanced.middle.a j;
    private NativeAdvancedExpandDialog k;
    private String b = "NativeAdvancedJSBridgeImpl";
    private int i = 5;

    /* compiled from: NativeAdvancedSignalCommunicationImpl.java */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f4025a;

        a(ArrayList arrayList) {
            this.f4025a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j a2 = j.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                Iterator it = this.f4025a.iterator();
                while (it.hasNext()) {
                    a2.b((String) it.next());
                }
            } catch (Exception unused) {
                p0.b(b.this.b, "campain can't insert db");
            }
        }
    }

    public b(Context context, String str, String str2) {
        this.f = str;
        this.e = str2;
        this.c = new WeakReference<>(context);
    }

    public void b(int i) {
        this.i = i;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public void c(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
                f.a().a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b);
            }
        } catch (Throwable th) {
            p0.b(this.b, "onSignalCommunicationConnect", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void click(Object obj, String str) {
        try {
            List<CampaignEx> list = this.d;
            CampaignEx campaignEx = (list == null || list.size() <= 0) ? null : this.d.get(0);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject campaignToJsonObject = campaignEx != null ? CampaignEx.campaignToJsonObject(campaignEx) : new JSONObject();
                JSONObject jSONObject = new JSONObject(str).getJSONObject("pt");
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
                p0.b(this.b, e.getMessage());
            }
            com.mbridge.msdk.advanced.middle.a aVar = this.j;
            if (aVar != null) {
                aVar.a(campaignEx);
            }
        } catch (Throwable th) {
            p0.b(this.b, "click", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        p0.b(this.b, "close");
        try {
            com.mbridge.msdk.advanced.middle.a aVar = this.j;
            if (aVar != null) {
                aVar.close();
            }
        } catch (Throwable th) {
            p0.b(this.b, "close", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void d(Object obj, String str) {
        p0.a(this.b, "sendImpressions:" + str);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                for (CampaignEx campaignEx : this.d) {
                    if (campaignEx.getId().equals(string)) {
                        com.mbridge.msdk.foundation.same.buffer.b.a(this.e, campaignEx, "h5_native");
                        arrayList.add(string);
                    }
                }
            }
            new Thread(new a(arrayList)).start();
        } catch (Throwable th) {
            p0.b(this.b, "sendImpressions", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z);
            WeakReference<Context> weakReference = this.c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            NativeAdvancedExpandDialog nativeAdvancedExpandDialog = this.k;
            if (nativeAdvancedExpandDialog == null || !nativeAdvancedExpandDialog.isShowing()) {
                NativeAdvancedExpandDialog nativeAdvancedExpandDialog2 = new NativeAdvancedExpandDialog(this.c.get(), bundle, this.j);
                this.k = nativeAdvancedExpandDialog2;
                nativeAdvancedExpandDialog2.setCampaignList(this.e, this.d);
                this.k.show();
                com.mbridge.msdk.advanced.middle.a aVar = this.j;
                if (aVar != null) {
                    aVar.a(true);
                }
                com.mbridge.msdk.advanced.report.a.a(this.e, getMraidCampaign(), str);
            }
        } catch (Throwable th) {
            p0.b(this.b, n.e, th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void getFileInfo(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is empty");
            return;
        }
        try {
            com.mbridge.msdk.advanced.signal.a.a(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.a(this.b, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public CampaignEx getMraidCampaign() {
        List<CampaignEx> list = this.d;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.d.get(0);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void init(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            com.mbridge.msdk.advanced.common.b bVar = new com.mbridge.msdk.advanced.common.b(com.mbridge.msdk.foundation.controller.c.m().d());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.g);
            jSONObject2.put("customURLScheme", 1);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put(C3040d4.h.G, bVar.b());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.d));
            l a2 = h.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.e);
            if (a2 == null) {
                a2 = l.k(this.e);
            }
            if (!TextUtils.isEmpty(this.f)) {
                a2.d(this.f);
            }
            a2.e(this.e);
            a2.j(this.i);
            a2.a(this.h);
            jSONObject.put("unitSetting", a2.M());
            String e = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b());
            if (!TextUtils.isEmpty(e)) {
                jSONObject.put("appSetting", new JSONObject(e));
            }
            jSONObject.put("sdk_info", com.mbridge.msdk.mbsignalcommon.base.d.f4534a);
            p0.b(this.b, C3040d4.a.f + jSONObject.toString());
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            p0.b(this.b, C3040d4.a.f, th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public void install(Object obj, String str) {
        p0.b(this.b, "install");
        try {
            List<CampaignEx> list = this.d;
            CampaignEx campaignEx = (list == null || list.size() <= 0) ? null : this.d.get(0);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject campaignToJsonObject = campaignEx != null ? CampaignEx.campaignToJsonObject(campaignEx) : new JSONObject();
                JSONObject jSONObject = new JSONObject(str).getJSONObject("pt");
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
            com.mbridge.msdk.advanced.middle.a aVar = this.j;
            if (aVar != null) {
                aVar.a(campaignEx);
            }
        } catch (Throwable th) {
            p0.b(this.b, "install", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        com.mbridge.msdk.advanced.middle.a aVar = this.j;
        if (aVar != null) {
            aVar.a(true, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void readyStatus(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        try {
            if (!(obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) || (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) == null) {
                return;
            }
            try {
                windVaneWebView.getWebViewListener().a(windVaneWebView, new JSONObject(str).getInt("isReady"));
            } catch (Exception unused) {
                windVaneWebView.getWebViewListener().a(windVaneWebView, 2);
            }
        } catch (Throwable th) {
            p0.a(this.b, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void reportUrls(Object obj, String str) {
        p0.a(this.b, "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
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
                    List<CampaignEx> list = this.d;
                    com.mbridge.msdk.click.a.a(d, list != null ? list.get(0) : null, "", a2, false, optInt != 0);
                } else {
                    Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
                    List<CampaignEx> list2 = this.d;
                    com.mbridge.msdk.click.a.a(d2, list2 != null ? list2.get(0) : null, "", a2, false, optInt != 0, optInt2);
                }
            }
            f.a().b(obj, d.a(0));
        } catch (Throwable th) {
            p0.b(this.b, "reportUrls", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            com.mbridge.msdk.advanced.middle.a aVar = this.j;
            if (aVar != null) {
                aVar.toggleCloseBtn(optInt);
            }
        } catch (Throwable th) {
            p0.b(this.b, "toggleCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void triggerCloseBtn(Object obj, String str) {
        if (this.j != null) {
            com.mbridge.msdk.advanced.signal.a.a(obj);
            this.j.triggerCloseBtn(obj, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void useCustomClose(boolean z) {
        try {
            if (this.h == -1) {
                int i = z ? 2 : 1;
                com.mbridge.msdk.advanced.middle.a aVar = this.j;
                if (aVar != null) {
                    aVar.toggleCloseBtn(i);
                }
            }
        } catch (Throwable th) {
            p0.b(this.b, "useCustomClose", th);
        }
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(com.mbridge.msdk.advanced.middle.a aVar) {
        if (aVar != null) {
            this.j = aVar;
        }
    }

    public void a(List<CampaignEx> list) {
        this.d = list;
    }

    public List<CampaignEx> a() {
        return this.d;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public void a(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i = new JSONObject(str).getInt("countdown");
            com.mbridge.msdk.advanced.middle.a aVar = this.j;
            if (aVar != null) {
                aVar.a(i);
            }
        } catch (JSONException e) {
            p0.b(this.b, "resetCountdown", e);
        }
    }
}
