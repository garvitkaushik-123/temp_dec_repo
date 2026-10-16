package com.mbridge.msdk.mbbanner.common.communication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbsignalcommon.communication.c;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BannerSignalCommunicationImpl.java */
/* loaded from: classes6.dex */
public class b extends c {
    private WeakReference<Context> b;
    private List<CampaignEx> c;
    private String d;
    private String e;
    private int f;
    private com.mbridge.msdk.mbbanner.common.listener.a g;
    private BannerExpandDialog h;
    private boolean i = false;

    /* compiled from: BannerSignalCommunicationImpl.java */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f4442a;

        a(ArrayList arrayList) {
            this.f4442a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j a2 = j.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                Iterator it = this.f4442a.iterator();
                while (it.hasNext()) {
                    a2.b((String) it.next());
                }
            } catch (Exception e) {
                p0.b("BannerSignalCommunicationImpl", e.getMessage());
            }
        }
    }

    public b(Context context, String str, String str2) {
        this.d = str;
        this.e = str2;
        this.b = new WeakReference<>(context);
    }

    public void a(com.mbridge.msdk.mbbanner.common.listener.a aVar) {
        if (aVar != null) {
            this.g = aVar;
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void click(Object obj, String str) {
        p0.b("BannerSignalCommunicationImpl", "click");
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
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.g;
            if (aVar != null) {
                aVar.a(campaignEx);
            }
        } catch (Throwable th) {
            p0.b("BannerSignalCommunicationImpl", "click", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        p0.b("BannerSignalCommunicationImpl", "close");
        try {
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.g;
            if (aVar != null) {
                aVar.close();
            }
        } catch (Throwable th) {
            p0.b("BannerSignalCommunicationImpl", "close", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void d(Object obj, String str) {
        p0.a("BannerSignalCommunicationImpl", "sendImpressions:" + str);
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
                        com.mbridge.msdk.foundation.same.buffer.b.a(this.e, campaignEx, "banner");
                        arrayList.add(string);
                    }
                }
            }
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new a(arrayList));
        } catch (Throwable th) {
            p0.b("BannerSignalCommunicationImpl", "sendImpressions", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z) {
        Context context;
        try {
            String str2 = "";
            if (getMraidCampaign() != null) {
                str2 = TextUtils.isEmpty(getMraidCampaign().getBannerHtml()) ? getMraidCampaign().getBannerUrl() : "file:////" + getMraidCampaign().getBannerHtml();
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
            }
            bundle.putString("url", str2);
            bundle.putBoolean("shouldUseCustomClose", z);
            WeakReference<Context> weakReference = this.b;
            if (weakReference != null && (context = weakReference.get()) != null) {
                BannerExpandDialog bannerExpandDialog = this.h;
                if (bannerExpandDialog != null && bannerExpandDialog.isShowing()) {
                    return;
                }
                BannerExpandDialog bannerExpandDialog2 = new BannerExpandDialog(context, bundle, this.g);
                this.h = bannerExpandDialog2;
                bannerExpandDialog2.setCampaignList(this.e, this.c);
                this.h.show();
            }
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.g;
            if (aVar != null) {
                aVar.a(true);
            }
            com.mbridge.msdk.mbbanner.common.report.a.a(this.e, getMraidCampaign(), str);
        } catch (Throwable th) {
            p0.b("BannerSignalCommunicationImpl", n.e, th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void getFileInfo(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is empty");
            return;
        }
        try {
            a(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.a("BannerSignalCommunicationImpl", th.getMessage());
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

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void init(Object obj, String str) {
        p0.b("BannerSignalCommunicationImpl", "BANNER INIT INVOKE");
        try {
            JSONObject jSONObject = new JSONObject();
            t tVar = new t(com.mbridge.msdk.foundation.controller.c.m().d());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put(C3040d4.h.G, tVar.a());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.c));
            l e = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), this.e);
            if (e == null) {
                e = l.i(this.e);
            }
            if (!TextUtils.isEmpty(this.d)) {
                e.d(this.d);
            }
            jSONObject.put("unitSetting", e.M());
            String e2 = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b());
            if (!TextUtils.isEmpty(e2)) {
                jSONObject.put("appSetting", new JSONObject(e2));
            }
            jSONObject.put("sdk_info", com.mbridge.msdk.mbsignalcommon.base.d.f4534a);
            p0.b("BannerSignalCommunicationImpl", C3040d4.a.f + jSONObject.toString());
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            p0.b("BannerSignalCommunicationImpl", C3040d4.a.f, th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        p0.b("BannerSignalCommunicationImpl", "open");
        try {
            p0.b("BannerSignalCommunicationImpl", str);
            if (this.c.size() > 1) {
                com.mbridge.msdk.foundation.controller.c.m().d().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                str = null;
            }
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.g;
            if (aVar != null) {
                aVar.a(true, str);
            }
        } catch (Throwable th) {
            p0.b("BannerSignalCommunicationImpl", "open", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                int optInt = new JSONObject(str).optInt("isReady", 1);
                f.a().b(obj, d.a(0));
                com.mbridge.msdk.mbbanner.common.listener.a aVar = this.g;
                if (aVar != null) {
                    aVar.readyStatus(optInt);
                }
            } catch (Throwable th) {
                p0.b("BannerSignalCommunicationImpl", "readyStatus", th);
            }
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void reportUrls(Object obj, String str) {
        p0.a("BannerSignalCommunicationImpl", "reportUrls:" + str);
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
                    List<CampaignEx> list = this.c;
                    com.mbridge.msdk.click.a.a(d, list != null ? list.get(0) : null, "", a2, false, optInt != 0);
                } else {
                    Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
                    List<CampaignEx> list2 = this.c;
                    com.mbridge.msdk.click.a.a(d2, list2 != null ? list2.get(0) : null, "", a2, false, optInt != 0, optInt2);
                }
            }
            f.a().b(obj, d.a(0));
        } catch (Throwable th) {
            p0.b("BannerSignalCommunicationImpl", "reportUrls", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void toggleCloseBtn(Object obj, String str) {
        p0.b("BannerSignalCommunicationImpl", "toggleCloseBtn");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.g;
            if (aVar != null) {
                aVar.toggleCloseBtn(optInt);
            }
        } catch (Throwable th) {
            p0.b("BannerSignalCommunicationImpl", "toggleCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void triggerCloseBtn(Object obj, String str) {
        p0.b("BannerSignalCommunicationImpl", "triggerCloseBtn");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String optString = new JSONObject(str).optString("state");
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.g;
            if (aVar != null) {
                aVar.triggerCloseBtn(optString);
            }
            f.a().b(obj, d.a(0));
        } catch (Throwable th) {
            p0.b("BannerSignalCommunicationImpl", "triggerCloseBtn", th);
            f.a().b(obj, d.a(-1));
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
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.g;
            if (aVar != null) {
                aVar.toggleCloseBtn(i);
            }
        } catch (Throwable th) {
            p0.b("BannerSignalCommunicationImpl", "useCustomClose", th);
        }
    }

    public void a(List<CampaignEx> list) {
        this.c = list;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a() {
        if (this.g != null) {
            this.g = null;
        }
        if (this.h != null) {
            this.h = null;
        }
    }

    public static void a(Object obj, JSONObject jSONObject) {
        String str;
        int i;
        boolean z;
        String str2;
        File file;
        String str3 = "";
        JSONObject jSONObject2 = new JSONObject();
        int i2 = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put("code", 1);
                jSONObject2.put(PglCryptUtils.KEY_MESSAGE, "params is null");
                f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e) {
                p0.a("BannerSignalCommunicationImpl", e.getMessage());
                return;
            }
        }
        try {
            try {
                jSONObject2.put("code", 0);
                jSONObject2.put(PglCryptUtils.KEY_MESSAGE, "");
                JSONArray jSONArray = jSONObject.getJSONArray("resource");
                if (jSONArray != null && jSONArray.length() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    int length = jSONArray.length();
                    int i3 = 0;
                    while (i3 < length) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                        String optString = jSONObject3.optString("ref", str3);
                        int i4 = jSONObject3.getInt("type");
                        JSONObject jSONObject4 = new JSONObject();
                        JSONArray jSONArray3 = jSONArray;
                        if (i4 == i2 && !TextUtils.isEmpty(optString)) {
                            JSONObject jSONObject5 = new JSONObject();
                            m b = com.mbridge.msdk.foundation.db.m.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d())).b(optString);
                            if (b != null) {
                                p0.a("BannerSignalCommunicationImpl", "VideoBean not null");
                                jSONObject5.put("type", 1);
                                i = length;
                                jSONObject5.put("videoDataLength", b.d());
                                String e2 = b.e();
                                if (TextUtils.isEmpty(e2)) {
                                    p0.a("BannerSignalCommunicationImpl", "VideoPath null");
                                    jSONObject5.put("path", str3);
                                    jSONObject5.put("path4Web", str3);
                                    str = str3;
                                } else {
                                    str = str3;
                                    p0.a("BannerSignalCommunicationImpl", "VideoPath not null");
                                    jSONObject5.put("path", e2);
                                    jSONObject5.put("path4Web", e2);
                                }
                                if (b.b() == 5) {
                                    jSONObject5.put("downloaded", 1);
                                    z = false;
                                } else {
                                    z = false;
                                    jSONObject5.put("downloaded", 0);
                                }
                                jSONObject4.put(optString, jSONObject5);
                                jSONArray2.put(jSONObject4);
                            } else {
                                str = str3;
                                i = length;
                                z = false;
                                p0.a("BannerSignalCommunicationImpl", "VideoBean null");
                            }
                        } else {
                            str = str3;
                            i = length;
                            z = false;
                            if (i4 == 2 && !TextUtils.isEmpty(optString)) {
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("type", 2);
                                jSONObject6.put("path", H5DownLoadManager.getInstance().getResAddress(optString) == null ? str : H5DownLoadManager.getInstance().getH5ResAddress(optString));
                                jSONObject4.put(optString, jSONObject6);
                                jSONArray2.put(jSONObject4);
                            } else if (i4 == 3 && !TextUtils.isEmpty(optString)) {
                                try {
                                    file = new File(optString);
                                } catch (Throwable th) {
                                    if (MBridgeConstans.DEBUG) {
                                        th.printStackTrace();
                                    }
                                }
                                if (file.exists() && file.isFile() && file.canRead()) {
                                    p0.a("BannerSignalCommunicationImpl", "getFileInfo Mraid file " + optString);
                                    str2 = "file:////" + optString;
                                    JSONObject jSONObject7 = new JSONObject();
                                    jSONObject7.put("type", 3);
                                    jSONObject7.put("path", str2);
                                    jSONObject4.put(optString, jSONObject7);
                                    jSONArray2.put(jSONObject4);
                                }
                                str2 = str;
                                JSONObject jSONObject72 = new JSONObject();
                                jSONObject72.put("type", 3);
                                jSONObject72.put("path", str2);
                                jSONObject4.put(optString, jSONObject72);
                                jSONArray2.put(jSONObject4);
                            } else if (i4 == 4 && !TextUtils.isEmpty(optString)) {
                                JSONObject jSONObject8 = new JSONObject();
                                jSONObject8.put("type", 4);
                                jSONObject8.put("path", t0.a(optString) == null ? str : t0.a(optString));
                                jSONObject4.put(optString, jSONObject8);
                                jSONArray2.put(jSONObject4);
                            }
                        }
                        i3++;
                        jSONArray = jSONArray3;
                        length = i;
                        str3 = str;
                        i2 = 1;
                    }
                    jSONObject2.put("resource", jSONArray2);
                    f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    return;
                }
                try {
                    jSONObject2.put("code", 1);
                    jSONObject2.put(PglCryptUtils.KEY_MESSAGE, "resource is null");
                    f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    return;
                } catch (JSONException e3) {
                    p0.a("BannerSignalCommunicationImpl", e3.getMessage());
                    return;
                }
            } catch (Throwable th2) {
                jSONObject2.put("code", 1);
                jSONObject2.put(PglCryptUtils.KEY_MESSAGE, th2.getLocalizedMessage());
                f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            }
            jSONObject2.put("code", 1);
            jSONObject2.put(PglCryptUtils.KEY_MESSAGE, th2.getLocalizedMessage());
            f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            return;
        } catch (JSONException e4) {
            p0.a("BannerSignalCommunicationImpl", e4.getMessage());
            return;
        }
    }
}
