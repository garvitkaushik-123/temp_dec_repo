package com.mbridge.msdk.video.signal.communication;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.inmobi.media.C2947y0;
import com.inmobi.unification.sdk.InitializationStatus;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.buffer.b;
import com.mbridge.msdk.foundation.same.directory.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.video.bt.component.d;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.impl.j;
import com.mbridge.msdk.video.signal.impl.k;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class BaseVideoCommunication extends AbsFeedBackForH5 implements IVideoCommunication {
    protected IJSFactory g;
    private FastKV h = null;

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void appendSubView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "appendSubView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void appendViewTo(Object obj, String str) {
        a(obj, str);
        try {
            d.c().b(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "appendViewTo error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void bringViewToFront(Object obj, String str) {
        a(obj, str);
        try {
            d.c().c(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "bringViewToFront error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void broadcast(Object obj, String str) {
        a(obj, str);
        try {
            d.c().d(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "broadcast error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void cai(Object obj, String str) {
        p0.a("JS-Video-Brigde", "cai:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                String optString = new JSONObject(str).optString(HandleInvocationsFromAdViewer.KEY_PACKAGE_NAME);
                if (TextUtils.isEmpty(optString)) {
                    com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "packageName is empty");
                }
                int i = u0.c(c.m().d(), optString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", com.mbridge.msdk.mbsignalcommon.communication.d.b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i);
                    jSONObject.put("data", jSONObject2);
                    f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, e.getMessage());
                    p0.a("JS-Video-Brigde", e.getMessage());
                }
            } catch (Throwable th) {
                com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "exception: " + th.getLocalizedMessage());
                p0.b("JS-Video-Brigde", "cai", th);
            }
        } catch (JSONException e2) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "exception: " + e2.getLocalizedMessage());
            p0.b("JS-Video-Brigde", "cai", e2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void clearAllCache(Object obj, String str) {
        if (com.mbridge.msdk.foundation.controller.d.a().e() && this.h == null) {
            try {
                this.h = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG), "MBridgeH5CacheSP").build();
            } catch (Exception unused) {
                this.h = null;
            }
        }
        FastKV fastKV = this.h;
        if (fastKV != null) {
            try {
                try {
                    fastKV.clear();
                } catch (Exception unused2) {
                }
                if (obj != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 0);
                    jSONObject.put(PglCryptUtils.KEY_MESSAGE, InitializationStatus.SUCCESS);
                    f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    return;
                }
                return;
            } catch (Throwable th) {
                p0.b("JS-Video-Brigde", "getAllCache error " + th);
                return;
            }
        }
        try {
            c.m().d().getSharedPreferences("MBridgeH5CacheSP", 0).edit().clear().apply();
            if (obj != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 0);
                jSONObject2.put(PglCryptUtils.KEY_MESSAGE, InitializationStatus.SUCCESS);
                f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            }
        } catch (Throwable th2) {
            p0.b("JS-Video-Brigde", "getAllCache error " + th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void click(Object obj, String str) {
        String str2;
        int i;
        k kVar;
        p0.c("JS-Video-Brigde", "click");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                i = jSONObject.optInt("type");
                str2 = jSONObject.optString("pt");
            } catch (JSONException e) {
                str2 = "";
                e.printStackTrace();
                i = 1;
            }
            IJSFactory iJSFactory = this.g;
            if (iJSFactory != null) {
                iJSFactory.getJSCommon().click(i, str2);
                return;
            }
            if (obj != null) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (!(aVar.b.getObject() instanceof k) || (kVar = (k) aVar.b.getObject()) == null) {
                    return;
                }
                kVar.click(i, str2);
            }
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "click error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void closeAd(Object obj, String str) {
        a(obj, str);
        try {
            d.c().e(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "closeAd error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void closeVideoOperte(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("close");
            int optInt2 = jSONObject.optInt("view_visible");
            p0.c("JS-Video-Brigde", "closeVideoOperte,close:" + optInt + ",viewVisible:" + optInt2);
            this.g.getJSVideoModule().closeVideoOperate(optInt, optInt2);
            f.a().b(obj, a(0));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "closeOperte error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void closeWeb(Object obj, String str) {
        p0.b("JS-Video-Brigde", "type" + str);
        try {
            if (TextUtils.isEmpty(str) || this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("status");
            this.g.getJSContainerModule().hideAlertWebview();
            this.g.getJSVideoModule().hideAlertView(optInt);
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "closeWeb", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createNativeEC(Object obj, String str) {
        a(obj, str);
        try {
            d.c().f(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "createNativeEC error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createPlayerView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().g(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "createPlayerView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createSubPlayTemplateView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().h(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "createSubPlayTemplateView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().i(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "createView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createWebview(Object obj, String str) {
        a(obj, str);
        try {
            d.c().j(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "createWebview error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void destroyComponent(Object obj, String str) {
        a(obj, str);
        try {
            d.c().k(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "destroyComponent error " + th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fd A[Catch: all -> 0x011d, TRY_ENTER, TryCatch #5 {all -> 0x011d, blocks: (B:24:0x00ea, B:27:0x00fd, B:29:0x0108, B:34:0x0101), top: B:23:0x00ea }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0108 A[Catch: all -> 0x011d, TRY_LEAVE, TryCatch #5 {all -> 0x011d, blocks: (B:24:0x00ea, B:27:0x00fd, B:29:0x0108, B:34:0x0101), top: B:23:0x00ea }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0101 A[Catch: all -> 0x011d, TryCatch #5 {all -> 0x011d, blocks: (B:24:0x00ea, B:27:0x00fd, B:29:0x0108, B:34:0x0101), top: B:23:0x00ea }] */
    /* JADX WARN: Type inference failed for: r0v5, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v30, types: [org.json.JSONObject] */
    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getAllCache(Object obj, String str) {
        String str2;
        ?? r9;
        Throwable th;
        Map<String, Object> map = null;
        if (com.mbridge.msdk.foundation.controller.d.a().e() && this.h == null) {
            try {
                this.h = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG), "MBridgeH5CacheSP").build();
            } catch (Exception unused) {
                this.h = null;
            }
        }
        if (this.h != null) {
            try {
                r9 = new JSONObject();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                try {
                    map = this.h.getAll();
                } catch (Exception unused2) {
                }
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        r9.put(entry.getKey(), entry.getValue());
                    }
                }
                map = r9;
                str2 = "getAllCache Success";
            } catch (Throwable th3) {
                th = th3;
                map = r9;
                p0.b("JS-Video-Brigde", "getAllCache error " + th);
                str2 = "getAllCache Error, reason is : " + th.getMessage();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 0);
                jSONObject.put(PglCryptUtils.KEY_MESSAGE, str2);
                if (map != null) {
                }
                if (obj != null) {
                }
            }
        } else {
            try {
                SharedPreferences sharedPreferences = c.m().d().getSharedPreferences("MBridgeH5CacheSP", 0);
                ?? jSONObject2 = new JSONObject();
                try {
                    for (Map.Entry<String, ?> entry2 : sharedPreferences.getAll().entrySet()) {
                        jSONObject2.put(entry2.getKey(), entry2.getValue());
                    }
                    r9 = jSONObject2;
                    map = r9;
                    str2 = "getAllCache Success";
                } catch (Throwable th4) {
                    th = th4;
                    map = jSONObject2;
                    p0.b("JS-Video-Brigde", "getAllCache error " + th);
                    str2 = "getAllCache Error, reason is : " + th.getMessage();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("code", 0);
                    jSONObject3.put(PglCryptUtils.KEY_MESSAGE, str2);
                    if (map != null) {
                    }
                    if (obj != null) {
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
        try {
            JSONObject jSONObject32 = new JSONObject();
            jSONObject32.put("code", 0);
            jSONObject32.put(PglCryptUtils.KEY_MESSAGE, str2);
            if (map != null) {
                jSONObject32.put("data", map);
            } else {
                jSONObject32.put("data", "{}");
            }
            if (obj != null) {
                f.a().b(obj, Base64.encodeToString(jSONObject32.toString().getBytes(), 2));
            }
        } catch (Throwable th6) {
            p0.b("JS-Video-Brigde", "getAllCache error " + th6);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getAppSetting(Object obj, String str) {
        JSONObject jSONObject;
        try {
            String optString = new JSONObject(str).optString("appid", "");
            JSONObject jSONObject2 = new JSONObject();
            if (TextUtils.isEmpty(optString)) {
                jSONObject2.put("code", 1);
                jSONObject2.put(PglCryptUtils.KEY_MESSAGE, "Get App Setting error, because must give a appId.");
            } else {
                String e = h.b().e(optString);
                if (TextUtils.isEmpty(e)) {
                    jSONObject = new JSONObject(h.b().a().L0());
                } else {
                    jSONObject = new JSONObject(e);
                    jSONObject.put("isDefault", 0);
                }
                if (obj != null) {
                    jSONObject2.put("code", 0);
                    jSONObject2.put(PglCryptUtils.KEY_MESSAGE, InitializationStatus.SUCCESS);
                    jSONObject2.put("data", jSONObject);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put(PglCryptUtils.KEY_MESSAGE, "Get App Setting error, plz try again later.");
                }
            }
            f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "getAppSetting error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getComponentOptions(Object obj, String str) {
        a(obj, str);
        try {
            d.c().l(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "getComponentOptions error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getCurrentProgress(Object obj, String str) {
        try {
            IJSFactory iJSFactory = this.g;
            if (iJSFactory != null) {
                String currentProgress = iJSFactory.getJSVideoModule().getCurrentProgress();
                p0.c("JS-Video-Brigde", "getCurrentProgress:" + currentProgress);
                if (!TextUtils.isEmpty(currentProgress)) {
                    currentProgress = Base64.encodeToString(currentProgress.getBytes(), 2);
                }
                f.a().b(obj, currentProgress);
            }
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "getCurrentProgress error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getCutout(Object obj, String str) {
        try {
            String e = this.g.getJSCommon().e();
            p0.b("JS-Video-Brigde", e);
            if (obj != null && !TextUtils.isEmpty(e)) {
                f.a().b(obj, Base64.encodeToString(e.getBytes(), 2));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, "No notch data, plz try again later.");
            f.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "getCutout error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getEncryptPrice(Object obj, String str) {
        String str2;
        try {
            String str3 = "not replaced";
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            int i = 1;
            if (TextUtils.isEmpty(str)) {
                str2 = "params is null";
            } else {
                JSONObject jSONObject3 = new JSONObject(str);
                String optString = jSONObject3.optString("unitid", "");
                String optString2 = jSONObject3.optString(C2947y0.KEY_REQUEST_ID, "");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    com.mbridge.msdk.foundation.entity.d b = b.b(optString, optString2);
                    if (b != null && b.c() == 1) {
                        str3 = "success";
                        jSONObject2.put("encrypt_p", b.b());
                        jSONObject2.put(com.mbridge.msdk.foundation.entity.b.KEY_IRLFA, 1);
                        i = 0;
                    }
                    jSONObject.put("code", i);
                    jSONObject.put(PglCryptUtils.KEY_MESSAGE, str3);
                    jSONObject.put("data", jSONObject2);
                    f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                }
                str2 = "params parsing exception";
            }
            str3 = str2;
            jSONObject.put("code", i);
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, str3);
            jSONObject.put("data", jSONObject2);
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "getEncryptPrice error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getFileInfo(Object obj, String str) {
        a(obj, str);
        try {
            d.c().m(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "getFileInfo error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getMuteStatus(Object obj, String str) {
        p0.c("JS-Video-Brigde", "getMuteStatus");
        IJSFactory iJSFactory = this.g;
        if (iJSFactory != null) {
            String g = iJSFactory.getJSCommon().g();
            if (!TextUtils.isEmpty(g)) {
                g = Base64.encodeToString(g.getBytes(), 2);
            }
            f.a().b(obj, g);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getRewardSetting(Object obj, String str) {
        try {
            JSONObject k = com.mbridge.msdk.videocommon.setting.b.b().c().k();
            JSONObject jSONObject = new JSONObject();
            if (obj == null || k == null) {
                jSONObject.put("code", 1);
                jSONObject.put(PglCryptUtils.KEY_MESSAGE, "Get Reward Setting error, plz try again later.");
            } else {
                jSONObject.put("code", 0);
                jSONObject.put(PglCryptUtils.KEY_MESSAGE, InitializationStatus.SUCCESS);
                jSONObject.put("data", k);
            }
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "getRewardSetting error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getRewardUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appid", "");
            String optString2 = jSONObject.optString("unitid", "");
            JSONObject jSONObject2 = new JSONObject();
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                jSONObject2.put("code", 1);
                jSONObject2.put(PglCryptUtils.KEY_MESSAGE, "Get reward unit Setting error, because must give appId and unitId.");
            } else {
                JSONObject H = com.mbridge.msdk.videocommon.setting.b.b().c(optString, optString2).H();
                if (obj == null || H == null) {
                    jSONObject2.put("code", 1);
                    jSONObject2.put(PglCryptUtils.KEY_MESSAGE, "Get Reward Unit Setting error, plz try again later.");
                } else {
                    jSONObject2.put("code", 0);
                    jSONObject2.put(PglCryptUtils.KEY_MESSAGE, InitializationStatus.SUCCESS);
                    jSONObject2.put("data", H);
                }
            }
            f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "getRewardUnitSetting error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getSDKInfo(Object obj, String str) {
        p0.c("JS-Video-Brigde", "getSDKInfo");
        try {
            if (TextUtils.isEmpty(str)) {
                f.a().a(obj, "params is null");
                return;
            }
            JSONArray jSONArray = new JSONObject(str).getJSONArray("type");
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (this.g != null) {
                while (i < jSONArray.length()) {
                    int i2 = jSONArray.getInt(i);
                    jSONObject.put(b(i2), this.g.getJSCommon().f(i2));
                    i++;
                }
            } else if (obj != null) {
                while (i < jSONArray.length()) {
                    int i3 = jSONArray.getInt(i);
                    com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                    if (aVar.b.getObject() instanceof k) {
                        jSONObject.put(b(i3), ((k) aVar.b.getObject()).f(i3));
                    }
                    i++;
                }
            }
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "getSDKInfo error", th);
            f.a().a(obj, "exception");
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, "Get Unit Setting error, RV/IV can not support this method.");
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "getUnitSetting error : " + th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void handleNativeObject(Object obj, String str) {
        a(obj, str);
        try {
            com.mbridge.msdk.video.bt.component.c.a().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "handleNativeObject error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void handlerH5Exception(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            p0.c("JS-Video-Brigde", "handlerH5Exception,params:" + str);
            this.g.getJSCommon().handlerH5Exception(jSONObject.optInt("code", -999), jSONObject.optString(PglCryptUtils.KEY_MESSAGE, "h5 error"));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "handlerH5Exception", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void hideView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().n(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "hideView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void increaseOfferFrequence(Object obj, String str) {
        a(obj, str);
        try {
            d.c().o(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "increaseOfferFrequence error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void init(Object obj, String str) {
        p0.c("JS-Video-Brigde", C3040d4.a.f);
        try {
            IJSFactory iJSFactory = this.g;
            int i = 1;
            if (iJSFactory != null) {
                String c = iJSFactory.getJSCommon().c();
                if (!TextUtils.isEmpty(c)) {
                    c = Base64.encodeToString(c.getBytes(), 2);
                }
                f.a().b(obj, c);
                this.g.getJSCommon().b(true);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("showTransparent");
                int optInt2 = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                int optInt3 = jSONObject.optInt("closeType");
                int optInt4 = jSONObject.optInt("orientationType");
                int optInt5 = jSONObject.optInt("webfront");
                int optInt6 = jSONObject.optInt("showAlertRole");
                this.g.getJSCommon().a(optInt == 1);
                this.g.getJSCommon().e(optInt2);
                this.g.getJSCommon().b(optInt3);
                this.g.getJSCommon().c(optInt4);
                this.g.getJSCommon().setWebViewFront(optInt5);
                com.mbridge.msdk.video.signal.d jSCommon = this.g.getJSCommon();
                if (optInt6 != 0) {
                    i = optInt6;
                }
                jSCommon.d(i);
                return;
            }
            if (obj != null) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.b.getObject() instanceof k) {
                    k kVar = (k) aVar.b.getObject();
                    String c2 = kVar.c();
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject jSONObject2 = new JSONObject(str);
                        int optInt7 = jSONObject2.optInt("showTransparent");
                        int optInt8 = jSONObject2.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                        int optInt9 = jSONObject2.optInt("closeType");
                        int optInt10 = jSONObject2.optInt("orientationType");
                        int optInt11 = jSONObject2.optInt("webfront");
                        int optInt12 = jSONObject2.optInt("showAlertRole");
                        kVar.a(optInt7 == 1);
                        kVar.e(optInt8);
                        kVar.b(optInt9);
                        kVar.c(optInt10);
                        kVar.setWebViewFront(optInt11);
                        if (optInt12 != 0) {
                            i = optInt12;
                        }
                        kVar.d(i);
                        p0.c("JS-Video-Brigde", "init jsCommon.setIsShowingTransparent = " + optInt7);
                    }
                    f.a().b(obj, Base64.encodeToString(c2.getBytes(), 2));
                }
            }
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "init error", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.g
    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        super.initialize(obj, windVaneWebView);
        if (obj instanceof IJSFactory) {
            this.g = (IJSFactory) obj;
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void insertViewAbove(Object obj, String str) {
        a(obj, str);
        try {
            d.c().a(obj, new JSONObject(str), true);
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "insertViewAbove error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void insertViewBelow(Object obj, String str) {
        a(obj, str);
        try {
            d.c().b(obj, new JSONObject(str), true);
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "insertViewBelow error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void isSystemResume(Object obj, String str) {
        try {
            if (this.g != null) {
                p0.c("JS-Video-Brigde", "isSystemResume,params:" + str);
                f.a().b(obj, a(this.g.getActivityProxy().a()));
            }
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "isSystemResume", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void ivRewardAdsWithoutVideo(Object obj, String str) {
        p0.b("JS-Video-Brigde", "ivRewardAdsWithoutVideo ： params" + str);
        try {
            if (TextUtils.isEmpty(str) || this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.g.getJSContainerModule().ivRewardAdsWithoutVideo(str);
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "ivRewardAdsWithoutVideo", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void loadads(Object obj, String str) {
        String str2;
        String str3;
        int i;
        int i2;
        p0.c("JS-Video-Brigde", "loadads");
        try {
            if (TextUtils.isEmpty(str)) {
                str2 = "";
                str3 = str2;
                i = 1;
                i2 = 1;
            } else {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(MBridgeConstans.PLACEMENT_ID);
                String optString2 = jSONObject.optString("unitId");
                int optInt = jSONObject.optInt("type", 1);
                if (optInt > 2) {
                    optInt = 1;
                }
                str2 = optString;
                i2 = jSONObject.optInt("adtype", 1);
                str3 = optString2;
                i = optInt;
            }
            if (TextUtils.isEmpty(str3)) {
                f.a().b(obj, a(1));
                return;
            }
            if (obj != null) {
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b;
                if ((windVaneWebView instanceof WindVaneWebView) && windVaneWebView.getWebViewListener() != null) {
                    ((com.mbridge.msdk.mbsignalcommon.listener.a) windVaneWebView.getWebViewListener()).a(windVaneWebView, str2, str3, i, i2);
                }
            }
            f.a().b(obj, a(0));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "loadads error", th);
            f.a().b(obj, a(1));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void loadingResourceStatus(Object obj, String str) {
        a(obj, str);
        if (obj != null) {
            try {
                int optInt = new JSONObject(str).optInt("isReady", 1);
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().b(windVaneWebView, optInt);
            } catch (Throwable th) {
                p0.b("JS-Video-Brigde", "loadingResourceStatus error " + th);
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            p0.c("JS-Video-Brigde", "notifyCloseBtn,result:" + optInt);
            this.g.getJSVideoModule().notifyCloseBtn(optInt);
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "notifyCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyAppendSubView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().p(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "appendSubView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyAppendViewTo(Object obj, String str) {
        a(obj, str);
        try {
            d.c().q(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "appendViewTo error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyInsertViewAbove(Object obj, String str) {
        a(obj, str);
        try {
            d.c().r(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "insertViewAbove error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyInsertViewBelow(Object obj, String str) {
        a(obj, str);
        try {
            d.c().b(obj, new JSONObject(str), false);
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "insertViewBelow error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void openURL(Object obj, String str) {
        p0.b("JS-Video-Brigde", "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("type");
            if (optInt == 1) {
                com.mbridge.msdk.click.c.c(this.f4571a, optString);
            } else if (optInt == 2) {
                com.mbridge.msdk.click.c.e(this.f4571a, optString);
            }
        } catch (JSONException e) {
            p0.b("JS-Video-Brigde", e.getMessage());
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playVideoFinishOperate(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str) || this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("type");
            p0.c("JS-Video-Brigde", "playVideoFinishOperate,type: " + optInt);
            this.g.getJSCommon().a(optInt);
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "playVideoFinishOperate error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerGetMuteState(Object obj, String str) {
        a(obj, str);
        try {
            d.c().s(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "playerGetMuteState error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerMute(Object obj, String str) {
        a(obj, str);
        try {
            d.c().t(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "playerMute error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerPause(Object obj, String str) {
        a(obj, str);
        try {
            d.c().u(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "playerPause error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerPlay(Object obj, String str) {
        a(obj, str);
        try {
            d.c().v(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "playerPlay error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerResume(Object obj, String str) {
        a(obj, str);
        try {
            d.c().w(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "playerResume error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerSetRenderType(Object obj, String str) {
        a(obj, str);
        try {
            d.c().x(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "playerSetRenderType error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerSetSource(Object obj, String str) {
        a(obj, str);
        try {
            d.c().y(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "playerSetSource error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerStop(Object obj, String str) {
        a(obj, str);
        try {
            d.c().z(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "playerStop error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerUnmute(Object obj, String str) {
        a(obj, str);
        try {
            d.c().A(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "playerUnmute error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerUpdateFrame(Object obj, String str) {
        a(obj, str);
        try {
            d.c().B(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "playerUpdateFrame error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void preloadSubPlayTemplateView(Object obj, String str) {
        a(obj, str);
        try {
            if (this.g != null) {
                d.c().C(obj, new JSONObject(str));
                return;
            }
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b;
            if (windVaneWebView instanceof WindVaneWebView) {
                if (windVaneWebView.getWebViewListener() == null) {
                    p0.a("JS-Video-Brigde", "preloadSubPlayTemplateView: failed");
                } else {
                    ((com.mbridge.msdk.mbsignalcommon.listener.a) windVaneWebView.getWebViewListener()).a(obj, str);
                    p0.a("JS-Video-Brigde", "preloadSubPlayTemplateView: RVWebViewListener");
                }
            }
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "preloadSubPlayTemplateView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void progressBarOperate(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.g.getJSVideoModule().progressBarOperate(new JSONObject(str).optInt("view_visible"));
            f.a().b(obj, a(0));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "progressOperate error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void progressOperate(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS);
            int optInt2 = jSONObject.optInt("view_visible");
            p0.c("JS-Video-Brigde", "progressOperate,progress:" + optInt + ",viewVisible:" + optInt2);
            this.g.getJSVideoModule().progressOperate(optInt, optInt2);
            f.a().b(obj, a(0));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "progressOperate error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void reactDeveloper(Object obj, String str) {
        p0.a("JS-Video-Brigde", "reactDeveloper");
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                f.a().a(obj, a(1));
            } else {
                this.g.getJSBTModule().reactDeveloper(obj, str);
            }
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "reactDeveloper error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                int optInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.b.getObject() instanceof k) {
                    ((k) aVar.b.getObject()).h(optInt);
                }
                WindVaneWebView windVaneWebView = aVar.b;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().a(windVaneWebView, optInt);
            } catch (Throwable th) {
                p0.b("JS-Video-Brigde", "readyStatus", th);
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void removeFromSuperView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().D(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "removeFromSuperView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void reportData(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void reportUrls(Object obj, String str) {
        p0.a("JS-Video-Brigde", "reportUrls");
        try {
            if (TextUtils.isEmpty(str)) {
                f.a().a(obj, a(1));
                return;
            }
            IJSFactory iJSFactory = this.g;
            if (iJSFactory == null || iJSFactory.getJSBTModule() == null) {
                d.c().c(obj, str);
            } else if (this.g.getJSBTModule() instanceof j) {
                this.g.getJSBTModule().reportUrls(obj, str);
            } else {
                d.c().c(obj, str);
            }
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "reportUrls error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setScaleFitXY(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("fitxy");
            p0.c("JS-Video-Brigde", "setScaleFitXY,type:" + optInt);
            this.g.getJSVideoModule().setScaleFitXY(optInt);
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "showVideoClickView error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setSubPlayTemplateInfo(Object obj, String str) {
        p0.b("JS-Video-Brigde", "setSubPlayTemplateInfo : " + str);
        a(obj, str);
        try {
            d.c().E(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "setSubPlayTemplateInfo error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewAlpha(Object obj, String str) {
        a(obj, str);
        try {
            d.c().F(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "setViewAlpha error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewBgColor(Object obj, String str) {
        a(obj, str);
        try {
            d.c().G(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "setViewBgColor error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewRect(Object obj, String str) {
        a(obj, str);
        try {
            d.c().H(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "setViewRect error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewScale(Object obj, String str) {
        a(obj, str);
        try {
            d.c().I(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "setViewScale error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showAlertView(Object obj, String str) {
        p0.c("JS-Video-Brigde", "showAlertView");
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.g.getJSVideoModule().showIVRewardAlertView(str);
            f.a().a(obj, "showAlertView", "");
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "showAlertView", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showVideoClickView(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("type");
            p0.c("JS-Video-Brigde", "showVideoClickView,type:" + optInt);
            this.g.getJSContainerModule().showVideoClickView(optInt);
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "showVideoClickView error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showVideoLocation(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("margin_top", 0);
            int optInt2 = jSONObject.optInt("margin_left", 0);
            int optInt3 = jSONObject.optInt("view_width", 0);
            int optInt4 = jSONObject.optInt("view_height", 0);
            int optInt5 = jSONObject.optInt("radius", 0);
            int optInt6 = jSONObject.optInt("border_top", 0);
            int optInt7 = jSONObject.optInt("border_left", 0);
            int optInt8 = jSONObject.optInt("border_width", 0);
            int optInt9 = jSONObject.optInt("border_height", 0);
            p0.c("JS-Video-Brigde", "showVideoLocation,margin_top:" + optInt + ",marginLeft:" + optInt2 + ",viewWidth:" + optInt3 + ",viewHeight:" + optInt4 + ",radius:" + optInt5 + ",borderTop: " + optInt6 + ",borderLeft: " + optInt7 + ",borderWidth: " + optInt8 + ",borderHeight: " + optInt9);
            this.g.getJSVideoModule().showVideoLocation(optInt, optInt2, optInt3, optInt4, optInt5, optInt6, optInt7, optInt8, optInt9);
            this.g.getJSCommon().h();
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "showVideoLocation error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showView(Object obj, String str) {
        a(obj, str);
        try {
            d.c().J(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "showView error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void soundOperate(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
            int optInt2 = jSONObject.optInt("view_visible");
            String optString = jSONObject.optString("pt", "");
            p0.c("JS-Video-Brigde", "soundOperate,mute:" + optInt + ",viewVisible:" + optInt2 + ",pt:" + optString);
            if (TextUtils.isEmpty(optString)) {
                this.g.getJSVideoModule().soundOperate(optInt, optInt2);
            } else {
                this.g.getJSVideoModule().soundOperate(optInt, optInt2, optString);
            }
            f.a().b(obj, a(0));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "soundOperate error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void statistics(Object obj, String str) {
        p0.c("JS-Video-Brigde", "statistics,params:" + str);
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.g.getJSCommon().a(jSONObject.optInt("type"), jSONObject.optString("data"));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "statistics error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            p0.c("JS-Video-Brigde", "toggleCloseBtn,result:" + optInt);
            int i = 2;
            if (optInt != 1) {
                i = optInt == 2 ? 1 : 0;
            }
            this.g.getJSVideoModule().closeVideoOperate(0, i);
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "toggleCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void triggerCloseBtn(Object obj, String str) {
        p0.c("JS-Video-Brigde", "triggerCloseBtn");
        try {
            if (this.g == null || TextUtils.isEmpty(str) || !new JSONObject(str).optString("state").equals("click")) {
                return;
            }
            this.g.getJSVideoModule().closeVideoOperate(1, -1);
            f.a().b(obj, a(0));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "triggerCloseBtn error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void videoOperate(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("pause_or_resume");
            p0.c("JS-Video-Brigde", "videoOperate,pauseOrResume:" + optInt);
            this.g.getJSVideoModule().videoOperate(optInt);
            f.a().b(obj, a(0));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "videoOperate error", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewFireEvent(Object obj, String str) {
        a(obj, str);
        try {
            d.c().K(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "setSubPlayTemplateInfo error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewGoBack(Object obj, String str) {
        a(obj, str);
        try {
            d.c().L(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "webviewGoBack error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewGoForward(Object obj, String str) {
        a(obj, str);
        try {
            d.c().M(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "webviewGoForward error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewLoad(Object obj, String str) {
        a(obj, str);
        try {
            d.c().N(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "webviewLoad error " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewReload(Object obj, String str) {
        a(obj, str);
        try {
            d.c().O(obj, new JSONObject(str));
        } catch (Throwable th) {
            p0.b("JS-Video-Brigde", "webviewReload error " + th);
        }
    }

    private String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable unused) {
            p0.b("JS-Video-Brigde", "code to string is error");
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d9 A[ADDED_TO_REGION] */
    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void removeCacheItem(Object obj, String str) {
        String str2;
        JSONObject jSONObject;
        SharedPreferences sharedPreferences;
        if (com.mbridge.msdk.foundation.controller.d.a().e() && this.h == null) {
            try {
                this.h = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG), "MBridgeH5CacheSP").build();
            } catch (Exception unused) {
                this.h = null;
            }
        }
        int i = 0;
        try {
            if (this.h != null) {
                try {
                } catch (Throwable th) {
                    p0.b("JS-Video-Brigde", "removeCacheItem error " + th);
                    str2 = "Delete Error, reason is : " + th.getMessage();
                }
                if (!TextUtils.isEmpty(str)) {
                    String string = new JSONObject(str).getString(C3040d4.h.W);
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            this.h.remove(string);
                        } catch (Exception unused2) {
                        }
                    }
                    str2 = "Delete Success";
                    i = 1;
                    jSONObject = new JSONObject();
                    jSONObject.put("code", i ^ 1);
                    jSONObject.put(PglCryptUtils.KEY_MESSAGE, str2);
                    if (obj == null && i != 0) {
                        f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        return;
                    } else {
                        f.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        return;
                    }
                }
            } else {
                try {
                    sharedPreferences = c.m().d().getSharedPreferences("MBridgeH5CacheSP", 0);
                } catch (Throwable th2) {
                    p0.b("JS-Video-Brigde", "removeCacheItem error " + th2);
                    str2 = "Delete Error, reason is : " + th2.getMessage();
                }
                if (!TextUtils.isEmpty(str)) {
                    String string2 = new JSONObject(str).getString(C3040d4.h.W);
                    if (!TextUtils.isEmpty(string2)) {
                        sharedPreferences.edit().remove(string2).apply();
                    }
                    str2 = "Delete Success";
                    i = 1;
                    jSONObject = new JSONObject();
                    jSONObject.put("code", i ^ 1);
                    jSONObject.put(PglCryptUtils.KEY_MESSAGE, str2);
                    if (obj == null) {
                    }
                    f.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    return;
                }
            }
            jSONObject = new JSONObject();
            jSONObject.put("code", i ^ 1);
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, str2);
            if (obj == null) {
            }
            f.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            return;
        } catch (Throwable unused3) {
            p0.b("JS-Video-Brigde", "removeCacheItem error ");
            return;
        }
        str2 = "";
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ef A[ADDED_TO_REGION] */
    @Override // com.mbridge.msdk.video.signal.communication.IVideoCommunication
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setCacheItem(Object obj, String str) {
        String str2;
        JSONObject jSONObject;
        SharedPreferences sharedPreferences;
        if (com.mbridge.msdk.foundation.controller.d.a().e() && this.h == null) {
            try {
                this.h = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG), "MBridgeH5CacheSP").build();
            } catch (Exception unused) {
                this.h = null;
            }
        }
        int i = 0;
        try {
            if (this.h != null) {
                try {
                } catch (Throwable th) {
                    p0.b("JS-Video-Brigde", "setCacheItem error " + th);
                    str2 = "Save Error, reason is : " + th.getMessage();
                }
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject2 = new JSONObject(str);
                    String string = jSONObject2.getString(C3040d4.h.W);
                    String string2 = jSONObject2.getString("value");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        try {
                            this.h.putString(string, string2);
                        } catch (Exception unused2) {
                        }
                    }
                    str2 = "Save Success";
                    i = 1;
                    jSONObject = new JSONObject();
                    jSONObject.put("code", i ^ 1);
                    jSONObject.put(PglCryptUtils.KEY_MESSAGE, str2);
                    if (obj == null && i != 0) {
                        f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        return;
                    } else {
                        f.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        return;
                    }
                }
            } else {
                try {
                    sharedPreferences = c.m().d().getSharedPreferences("MBridgeH5CacheSP", 0);
                } catch (Throwable th2) {
                    p0.b("JS-Video-Brigde", "setCacheItem error " + th2);
                    str2 = "Save Error, reason is : " + th2.getMessage();
                }
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject3 = new JSONObject(str);
                    String string3 = jSONObject3.getString(C3040d4.h.W);
                    String string4 = jSONObject3.getString("value");
                    if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                        sharedPreferences.edit().putString(string3, string4).apply();
                    }
                    str2 = "Save Success";
                    i = 1;
                    jSONObject = new JSONObject();
                    jSONObject.put("code", i ^ 1);
                    jSONObject.put(PglCryptUtils.KEY_MESSAGE, str2);
                    if (obj == null) {
                    }
                    f.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    return;
                }
            }
            jSONObject = new JSONObject();
            jSONObject.put("code", i ^ 1);
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, str2);
            if (obj == null) {
            }
            f.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            return;
        } catch (Throwable unused3) {
            p0.b("JS-Video-Brigde", "setCacheItem error ");
            return;
        }
        str2 = "";
    }

    private void a(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 1);
                jSONObject.put(PglCryptUtils.KEY_MESSAGE, "params is null");
                f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Exception e) {
            p0.a("JS-Video-Brigde", e.getMessage());
        }
    }

    private String b(int i) {
        switch (i) {
            case 1:
                return "sdk_info";
            case 2:
                return MBridgeConstans.PROPERTIES_UNIT_ID;
            case 3:
                return "appSetting";
            case 4:
                return "unitSetting";
            case 5:
                return C3040d4.h.G;
            case 6:
                return "sdkSetting";
            default:
                return "";
        }
    }
}
