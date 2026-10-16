package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.aGH.eli;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.CMM;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.model.aqO;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C3040d4;
import com.ironsource.C3114ha;
import com.ironsource.C3207n2;
import com.ironsource.sdk.controller.f;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.ktor.client.utils.CacheControl;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class qj implements com.bytedance.sdk.component.adexpress.ui.DbA, Ue.eli, com.bytedance.sdk.openadsdk.aAs.DbA {
    private static final Map<String, Boolean> FC;
    private JSONObject CMM;
    boolean DbA;
    private String Dfc;
    private com.bytedance.sdk.openadsdk.core.widget.eli.eli FS;
    private com.bytedance.sdk.openadsdk.nlS.aAs GB;
    private com.bytedance.sdk.openadsdk.core.DbA.aGH KM;
    private String NU;
    private JSONObject QX;
    private String SSo;
    private Os TfR;
    private JSONObject Ue;
    private com.bytedance.sdk.openadsdk.nlS.Os VM;
    private com.bytedance.sdk.openadsdk.nlS.eli Vy;
    private com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA WfR;
    private com.bytedance.sdk.component.adexpress.DbA.du Xb;
    private boolean Za;
    private com.bytedance.sdk.openadsdk.aAs.Os aAs;
    private int aqO;
    private com.bytedance.sdk.openadsdk.core.wC.Dfc bf;
    private com.bytedance.sdk.openadsdk.aGH.aGH.ui cyF;
    private com.bytedance.sdk.openadsdk.nlS.DbA dZ;
    private String du;
    private com.bytedance.sdk.component.eli.dV eU;
    protected Map<String, Object> eli;
    private com.bytedance.sdk.openadsdk.aAs.aGH ev;
    private com.bytedance.sdk.openadsdk.nlS.MGA gG;
    private boolean ikX;
    private com.bytedance.sdk.openadsdk.nlS.kb jh;
    private String kb;
    private com.bytedance.sdk.openadsdk.core.model.ev nGm;
    private WeakReference<View> nlS;
    private int nn;
    private eli ow;
    private HashMap<String, aAs> qj;
    private Context tGZ;
    private WeakReference<com.bytedance.sdk.component.FC.MGA> ui;
    private com.bytedance.sdk.openadsdk.nlS.ui ujq;
    private com.bytedance.sdk.openadsdk.core.widget.ui wC;
    private boolean dV = true;
    private boolean oWW = true;
    private boolean nro = false;
    private boolean Cp = false;
    boolean Os = false;
    boolean aGH = false;
    private boolean Uv = false;
    private final com.bytedance.sdk.component.utils.Ue MGA = new com.bytedance.sdk.component.utils.Ue(Looper.getMainLooper(), this);

    public static class DbA {
        public String DbA;
        public String Os;
        public JSONObject aGH;
        public String eli;
        public int ui;
    }

    public interface eli {
        void eli();
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        FC = concurrentHashMap;
        concurrentHashMap.put("log_event", Boolean.TRUE);
        concurrentHashMap.put(CacheControl.PRIVATE, Boolean.TRUE);
        concurrentHashMap.put("dispatch_message", Boolean.TRUE);
        concurrentHashMap.put("custom_event", Boolean.TRUE);
        concurrentHashMap.put("log_event_v3", Boolean.TRUE);
    }

    public qj eli(com.bytedance.sdk.openadsdk.core.widget.eli.eli eliVar) {
        this.FS = eliVar;
        return this;
    }

    public qj(Context context) {
        this.tGZ = context;
    }

    public qj DbA(String str) {
        this.kb = str;
        return this;
    }

    public qj eli(com.bytedance.sdk.openadsdk.core.widget.ui uiVar) {
        this.wC = uiVar;
        return this;
    }

    public com.bytedance.sdk.openadsdk.nlS.DbA eli() {
        return this.dZ;
    }

    public void eli(com.bytedance.sdk.openadsdk.nlS.DbA dbA) {
        this.dZ = dbA;
    }

    public qj eli(com.bytedance.sdk.component.FC.MGA mga) {
        WebView webView;
        if (mga != null && (webView = mga.getWebView()) != null) {
            try {
                com.bytedance.sdk.component.eli.dV DbA2 = com.bytedance.sdk.component.eli.dV.eli(webView).eli(new com.bytedance.sdk.openadsdk.du.eli()).eli("ToutiaoJSBridge").eli(new com.bytedance.sdk.component.eli.nlS() { // from class: com.bytedance.sdk.openadsdk.core.qj.1
                    @Override // com.bytedance.sdk.component.eli.nlS
                    public <T> T eli(String str, Type type) {
                        return null;
                    }

                    @Override // com.bytedance.sdk.component.eli.nlS
                    public <T> String eli(T t) {
                        return null;
                    }
                }).eli(FC.DbA().dV()).DbA(true).eli().DbA();
                this.eU = DbA2;
                com.bytedance.sdk.openadsdk.du.eli.kb.eli(DbA2, this);
                com.bytedance.sdk.openadsdk.du.eli.eli.eli(this.eU, this);
                com.bytedance.sdk.openadsdk.du.eli.DbA.eli(this.eU, this);
                com.bytedance.sdk.openadsdk.du.eli.Os.eli(this.eU, this);
                com.bytedance.sdk.openadsdk.du.eli.MGA.eli(this.eU, this);
                com.bytedance.sdk.openadsdk.du.eli.FC.eli(this.eU, this);
                com.bytedance.sdk.openadsdk.du.eli.nlS.eli(this.eU, this);
                com.bytedance.sdk.openadsdk.du.eli.aAs.eli(this.eU, mga);
                com.bytedance.sdk.openadsdk.du.eli.wC.eli(this.eU, this);
                com.bytedance.sdk.openadsdk.du.eli.ui.eli(this.eU, this.CMM);
                com.bytedance.sdk.openadsdk.du.eli.aGH.eli(this.eU, this);
                com.bytedance.sdk.openadsdk.du.eli.Dfc.eli(this.eU, mga, this, this.nGm);
                com.bytedance.sdk.openadsdk.du.eli.du.eli(this.eU, this, this.nGm);
                com.bytedance.sdk.openadsdk.du.eli.NU.eli(this.eU, this);
                com.bytedance.sdk.openadsdk.du.eli.nn.eli(this.eU, this);
            } catch (Exception unused) {
            }
        }
        return this;
    }

    public com.bytedance.sdk.component.eli.dV DbA() {
        return this.eU;
    }

    private WebView aqO() {
        com.bytedance.sdk.component.FC.MGA mga;
        WeakReference<com.bytedance.sdk.component.FC.MGA> weakReference = this.ui;
        if (weakReference == null || (mga = weakReference.get()) == null) {
            return null;
        }
        return mga.getWebView();
    }

    public qj DbA(com.bytedance.sdk.component.FC.MGA mga) {
        this.ui = new WeakReference<>(mga);
        return this;
    }

    public qj eli(com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar) {
        this.cyF = uiVar;
        return this;
    }

    public qj eli(boolean z) {
        this.DbA = z;
        return this;
    }

    public qj DbA(boolean z) {
        this.Cp = z;
        return this;
    }

    public qj Os(String str) {
        this.du = str;
        return this;
    }

    public qj eli(View view) {
        this.nlS = new WeakReference<>(view);
        return this;
    }

    private JSONObject dV() {
        try {
            View view = this.nlS.get();
            com.bytedance.sdk.component.FC.MGA mga = this.ui.get();
            if (view != null && mga != null) {
                int[] DbA2 = SSo.DbA(view);
                int[] DbA3 = SSo.DbA((View) mga);
                if (DbA2 != null && DbA3 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(VastAttributes.HORIZONTAL_POSITION, SSo.Os(dV.eli(), DbA2[0] - DbA3[0]));
                    jSONObject.put(VastAttributes.VERTICAL_POSITION, SSo.Os(dV.eli(), DbA2[1] - DbA3[1]));
                    jSONObject.put("w", SSo.Os(dV.eli(), view.getWidth()));
                    jSONObject.put("h", SSo.Os(dV.eli(), view.getHeight()));
                    jSONObject.put("isExist", true);
                    return jSONObject;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public qj eli(int i) {
        this.aqO = i;
        return this;
    }

    public void Os() {
        com.bytedance.sdk.component.eli.dV dVVar = this.eU;
        if (dVVar == null) {
            return;
        }
        dVVar.eli();
        this.eU = null;
    }

    public qj eli(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        this.nGm = evVar;
        if (evVar != null) {
            this.QX = evVar.nW();
        }
        return this;
    }

    public qj eli(com.bytedance.sdk.openadsdk.nlS.Os os) {
        this.VM = os;
        return this;
    }

    public qj eli(com.bytedance.sdk.openadsdk.nlS.aAs aas) {
        this.GB = aas;
        return this;
    }

    public com.bytedance.sdk.openadsdk.core.model.ev aGH() {
        return this.nGm;
    }

    public boolean ui() {
        com.bytedance.sdk.openadsdk.core.model.ev evVar = this.nGm;
        return evVar != null && evVar.DE();
    }

    public qj aGH(String str) {
        this.NU = str;
        return this;
    }

    public qj DbA(int i) {
        this.nn = i;
        return this;
    }

    public qj ui(String str) {
        this.Dfc = str;
        return this;
    }

    private static List<String> nGm() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    public qj eli(Map<String, Object> map) {
        this.eli = map;
        return this;
    }

    public qj eli(com.bytedance.sdk.component.adexpress.DbA.du duVar) {
        this.Xb = duVar;
        return this;
    }

    public qj eli(com.bytedance.sdk.openadsdk.core.wC.Dfc dfc) {
        this.bf = dfc;
        return this;
    }

    public qj eli(JSONObject jSONObject) {
        this.CMM = jSONObject;
        return this;
    }

    public qj eli(com.bytedance.sdk.openadsdk.nlS.eli eliVar) {
        this.Vy = eliVar;
        return this;
    }

    public qj eli(com.bytedance.sdk.openadsdk.nlS.MGA mga) {
        this.gG = mga;
        return this;
    }

    public qj eli(com.bytedance.sdk.openadsdk.nlS.ui uiVar) {
        this.ujq = uiVar;
        return this;
    }

    public qj eli(com.bytedance.sdk.openadsdk.nlS.kb kbVar) {
        this.jh = kbVar;
        return this;
    }

    public boolean MGA() {
        return this.Os;
    }

    public static void DbA(JSONObject jSONObject) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = nGm().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.common.DbA.eli());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.common.DbA.ui());
        jSONObject.put(C3114ha.b, com.bytedance.sdk.openadsdk.common.DbA.DbA());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.common.DbA.Os());
        jSONObject.put(C3040d4.i.W, com.bytedance.sdk.openadsdk.common.DbA.aGH());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.common.DbA.MGA());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.common.DbA.eli(dV.eli()));
        if (DeviceUtils.DbA(dV.eli())) {
            jSONObject.put("device_platform", "Android_Pad");
        } else {
            jSONObject.put("device_platform", C3040d4.d);
        }
        jSONObject.put("device_type", Build.VERSION.RELEASE);
    }

    private void nlS(JSONObject jSONObject) throws Exception {
        eli(jSONObject, this.nGm);
    }

    public static void eli(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.ev evVar) throws Exception {
        String umh = evVar.umh();
        if (!TextUtils.isEmpty(umh)) {
            jSONObject.put("cid", umh);
        }
        String eu = evVar.eu();
        if (!TextUtils.isEmpty(eu)) {
            jSONObject.put("log_extra", eu);
        }
        String WA = evVar.WA();
        if (!TextUtils.isEmpty(WA)) {
            jSONObject.put(DownloadModel.DOWNLOAD_URL, WA);
        }
        jSONObject.put("dc", TextUtils.isEmpty(dV.aGH().Cp()) ? dV.aGH().Cp() : "TX");
        jSONObject.put("language", nlS.DbA());
        jSONObject.put("isRTL", com.bytedance.sdk.openadsdk.core.settings.NU.nY().rQ());
    }

    private void NU(JSONObject jSONObject) throws Exception {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.model.KM.du(this.nGm))) {
            return;
        }
        jSONObject.put("playable_style", com.bytedance.sdk.openadsdk.core.model.KM.du(this.nGm));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0367, code lost:
    
        if (r4 != null) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x03b4, code lost:
    
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x03b2, code lost:
    
        if (r4 != null) goto L229;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject eli(DbA dbA, int i) throws Exception {
        char c;
        JSONObject jSONObject;
        Context context;
        JSONObject jSONObject2;
        if (!NotificationCompat.CATEGORY_CALL.equals(dbA.eli)) {
            return null;
        }
        if (FC.DbA().dV()) {
            Log.d("TTAD.AndroidObject", "[JSB-REQ] version:" + i + " method:" + dbA.Os);
        }
        JSONObject jSONObject3 = new JSONObject();
        String str = dbA.Os;
        str.hashCode();
        switch (str.hashCode()) {
            case -2036781162:
                if (str.equals("subscribe_app_ad")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1423303823:
                if (str.equals("adInfo")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1330994877:
                if (str.equals("pauseWebView")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1169135450:
                if (str.equals("changeVideoState")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1023873614:
                if (str.equals("openAdLandPageLinks")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -844321441:
                if (str.equals("webview_time_track")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -800853518:
                if (str.equals("clickEvent")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -794273169:
                if (str.equals("appInfo")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -715147645:
                if (str.equals("getScreenSize")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -511324706:
                if (str.equals("openPrivacy")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -278382602:
                if (str.equals("send_temai_product_ids")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -173752734:
                if (str.equals("getTeMaiAds")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 27837080:
                if (str.equals("download_app_ad")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 94756344:
                if (str.equals("close")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 105049135:
                if (str.equals("unsubscribe_app_ad")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 399543522:
                if (str.equals("getCloseButtonInfo")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 402955465:
                if (str.equals(C3040d4.h.o)) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 425443791:
                if (str.equals("getNativeSiteCustomData")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 442647767:
                if (str.equals("sendReward")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 571273292:
                if (str.equals("dynamicTrack")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 650209982:
                if (str.equals("getTemplateInfo")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 672928467:
                if (str.equals("cancel_download_app_ad")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 711635577:
                if (str.equals("getCurrentVideoState")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 885131792:
                if (str.equals("getVolume")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 1107374321:
                if (str.equals("pauseWebViewTimers")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 1151744482:
                if (str.equals("muteVideo")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 1237100796:
                if (str.equals("renderDidFinish")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 1532142616:
                if (str.equals("removeLoading")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case 1634511418:
                if (str.equals("endcard_load")) {
                    c = 28;
                    break;
                }
                c = 65535;
                break;
            case 1713585602:
                if (str.equals("getNetworkData")) {
                    c = 29;
                    break;
                }
                c = 65535;
                break;
            case 1731806400:
                if (str.equals("playable_style")) {
                    c = 30;
                    break;
                }
                c = 65535;
                break;
            case 1979895452:
                if (str.equals("sendLog")) {
                    c = 31;
                    break;
                }
                c = 65535;
                break;
            case 2086000188:
                if (str.equals("skipVideo")) {
                    c = ' ';
                    break;
                }
                c = 65535;
                break;
            case 2105008900:
                if (str.equals("landscape_click")) {
                    c = '!';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                ujq();
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.nGm, this.SSo, 0, (JSONObject) null);
                Context context2 = this.tGZ;
                if (context2 != null) {
                    this.aAs.eli(context2, dbA.aGH, this.NU, this.nn, this.dV);
                    break;
                } else {
                    com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.nGm, this.SSo, -1, (JSONObject) null);
                    break;
                }
            case 1:
                nlS(jSONObject3);
                break;
            case 2:
                Xb();
                break;
            case 3:
                aqO(dbA.aGH);
                break;
            case 4:
                JSONObject jSONObject4 = dbA.aGH;
                if (eli(jSONObject4, jSONObject3)) {
                    Os(jSONObject4);
                    break;
                }
                break;
            case 5:
                nn(dbA.aGH);
                break;
            case 6:
                ui(dbA.aGH);
                break;
            case 7:
                DbA(jSONObject3);
                break;
            case '\b':
                com.bytedance.sdk.openadsdk.nlS.eli eliVar = this.Vy;
                if (eliVar != null) {
                    int DbA2 = eliVar.DbA();
                    int eli2 = this.Vy.eli();
                    jSONObject3.put("width", DbA2);
                    jSONObject3.put("height", eli2);
                    break;
                }
                break;
            case '\t':
                ev();
                break;
            case '\n':
                bf(dbA.aGH);
                break;
            case 11:
                jSONObject = this.Ue;
                break;
            case '\f':
                this.Uv = true;
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.nGm, this.SSo, 1, (JSONObject) null);
                com.bytedance.sdk.openadsdk.core.DbA.aGH agh = this.KM;
                if (agh != null) {
                    agh.ui(this.oWW);
                    break;
                } else {
                    com.bytedance.sdk.openadsdk.aAs.Os os = this.aAs;
                    if (os != null && (context = this.tGZ) != null) {
                        os.eli(context, dbA.aGH, this.SSo);
                        com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA2 = this.WfR;
                        if (dbA2 != null) {
                            dbA2.MGA();
                            break;
                        }
                    } else {
                        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.nGm, this.SSo, -2, (JSONObject) null);
                        break;
                    }
                }
                break;
            case '\r':
                kb();
                break;
            case 14:
                com.bytedance.sdk.openadsdk.aAs.Os os2 = this.aAs;
                if (os2 != null) {
                    os2.eli(dbA.aGH);
                    break;
                }
                break;
            case 15:
                jSONObject = dV();
                break;
            case 16:
                jSONObject3.put("viewStatus", this.Cp ? 1 : 0);
                break;
            case 17:
                com.bytedance.sdk.openadsdk.core.model.ev evVar = this.nGm;
                if (evVar != null && !TextUtils.isEmpty(evVar.Hm())) {
                    jSONObject3.put("data", this.nGm.Hm());
                    break;
                }
                break;
            case 18:
                this.Os = true;
                this.WfR.eli(true);
                com.bytedance.sdk.openadsdk.nlS.MGA mga = this.gG;
                if (mga != null) {
                    mga.eli();
                    break;
                } else {
                    com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA3 = this.WfR;
                    if (dbA3 != null) {
                        dbA3.f_();
                        break;
                    }
                }
                break;
            case 19:
                Xb(dbA.aGH);
                break;
            case 20:
                JSONObject jSONObject5 = this.CMM;
                if (jSONObject5 != null) {
                    jSONObject5.put("setting", Vy());
                    com.bytedance.sdk.openadsdk.core.model.ev evVar2 = this.nGm;
                    if (evVar2 != null && evVar2.wc() != null) {
                        this.CMM.put("dynamic_configs", this.nGm.wc());
                    }
                    com.bytedance.sdk.openadsdk.core.model.ev evVar3 = this.nGm;
                    if (evVar3 != null) {
                        this.CMM.put("extension", evVar3.ikx());
                    }
                }
                jSONObject3 = this.CMM;
                break;
            case 22:
                dV(jSONObject3);
                break;
            case 23:
                AudioManager audioManager = (AudioManager) dV.eli().getSystemService("audio");
                jSONObject3.put("endcard_mute", (audioManager != null ? audioManager.getStreamVolume(3) : -1) <= 0);
                break;
            case 24:
                bf();
                break;
            case 25:
                DbA(this.bf, dbA.aGH);
                break;
            case 26:
                nGm(dbA.aGH);
                break;
            case 27:
                com.bytedance.sdk.openadsdk.nlS.ui uiVar = this.ujq;
                if (uiVar != null) {
                    uiVar.eli();
                    break;
                }
                break;
            case 28:
                Dfc(dbA.aGH);
                break;
            case 29:
                eli(dbA, jSONObject3);
                break;
            case 30:
                NU(jSONObject3);
                break;
            case 31:
                JSONObject jSONObject6 = dbA.aGH;
                if (jSONObject6 != null && (jSONObject2 = jSONObject6.getJSONObject("extJson")) != null && jSONObject2.has("category") && jSONObject2.has("tag") && jSONObject2.has("label")) {
                    String optString = jSONObject2.optString("category");
                    String optString2 = jSONObject2.optString("tag");
                    String optString3 = jSONObject2.optString("label");
                    long optLong = jSONObject6.optLong("value");
                    long optLong2 = jSONObject6.optLong("extValue");
                    try {
                        jSONObject2.putOpt("ua_policy", Integer.valueOf(this.aqO));
                    } catch (Exception unused) {
                    }
                    if ("click".equals(optString3)) {
                        jSONObject2 = ev(jSONObject2);
                    }
                    String eli3 = eli(optString2, optString3);
                    boolean ui = com.bytedance.sdk.openadsdk.core.model.Xb.ui(this.nGm);
                    eli(jSONObject2, ui, optString3);
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(this.nGm, optString, eli3, optString3, optLong, optLong2, jSONObject2, ui);
                    break;
                }
                break;
            case ' ':
                CMM();
                break;
            case '!':
                Context context3 = this.tGZ;
                if (context3 instanceof com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA) {
                    ((com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA) context3).MGA();
                    break;
                }
                break;
        }
        if (i == 1 && !TextUtils.isEmpty(dbA.DbA)) {
            DbA(dbA.DbA, jSONObject3);
            if (FC.DbA().dV()) {
                Log.d("TTAD.AndroidObject", "[JSB-RSP] version:" + i + " data=" + jSONObject3);
            }
        }
        return jSONObject3;
    }

    private void eli(JSONObject jSONObject, boolean z, String str) {
        com.bytedance.sdk.openadsdk.core.widget.ui uiVar;
        if (z) {
            try {
                String optString = jSONObject.optString("ad_extra_data");
                if (TextUtils.isEmpty(optString) || new JSONObject(optString).optInt("agg_request_type", -1) != 1 || !"click".equals(str) || (uiVar = this.wC) == null) {
                    return;
                }
                uiVar.eli();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.eli("TTAD.AndroidObject", "callAggClickListener faile", th);
            }
        }
    }

    private boolean eli(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        int i;
        String str2;
        if (jSONObject != null) {
            i = jSONObject.optInt("landingStyle");
            str = jSONObject.optString("url");
            str2 = jSONObject.optString("fallback_url");
        } else {
            str = null;
            i = -1;
            str2 = null;
        }
        if (i == 1) {
            if (!com.bytedance.sdk.component.utils.nGm.eli(str)) {
                try {
                    jSONObject2.put("invalid_url", 1);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.Xb.eli("TTAD.AndroidObject", "handleUrl, EX1->: ", e);
                }
                return false;
            }
        } else if (i == 2) {
            try {
                if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                    jSONObject2.put("empty_url", 1);
                    return false;
                }
                if (!com.bytedance.sdk.component.utils.nGm.eli(str2)) {
                    jSONObject2.put("invalid_url", 1);
                    return false;
                }
            } catch (JSONException e2) {
                com.bytedance.sdk.component.utils.Xb.eli("TTAD.AndroidObject", "handleUrl, EX2->: ", e2);
            }
        }
        return true;
    }

    public void kb() {
        com.bytedance.sdk.openadsdk.nlS.Os os;
        if (this.ikX && (os = this.VM) != null) {
            os.eli();
            return;
        }
        Context context = this.tGZ;
        if ((context instanceof Activity) && com.bytedance.sdk.openadsdk.utils.CMM.eli((Activity) context)) {
            ((Activity) this.tGZ).finish();
        }
    }

    public void Os(JSONObject jSONObject) {
        nGm.eli(QX(), this.tGZ instanceof Activity, jSONObject, this.nGm, this.SSo, this.nn, aqO(), this.wC);
    }

    private Context QX() {
        WeakReference<com.bytedance.sdk.component.FC.MGA> weakReference = this.ui;
        Activity eli2 = (weakReference == null || weakReference.get() == null) ? null : com.bytedance.sdk.component.utils.DbA.eli(this.ui.get());
        return eli2 == null ? this.tGZ : eli2;
    }

    private void nn(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar;
        if (jSONObject == null || (uiVar = this.cyF) == null) {
            return;
        }
        uiVar.DbA(jSONObject);
    }

    private void eli(String str, boolean z) {
        if (this.cyF == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.cyF.eli(str);
        } else {
            this.cyF.DbA(str);
        }
    }

    private void Xb() {
        com.bytedance.sdk.openadsdk.nlS.aAs aas = this.GB;
        if (aas == null) {
            return;
        }
        aas.eli();
    }

    private void bf() {
        com.bytedance.sdk.openadsdk.nlS.aAs aas = this.GB;
        if (aas == null) {
            return;
        }
        aas.DbA();
    }

    private void Dfc(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.nlS.Os os = this.VM;
        if (os == null || jSONObject == null) {
            return;
        }
        os.eli(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, ""));
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.DbA
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            nlS(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.DbA
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            DbA(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.DbA
    @JavascriptInterface
    public String getTemplateInfo() {
        eli("getTemplateInfo", true);
        try {
            JSONObject jSONObject = this.CMM;
            if (jSONObject != null) {
                jSONObject.put("setting", Vy());
                com.bytedance.sdk.openadsdk.core.model.ev evVar = this.nGm;
                if (evVar != null && evVar.wc() != null) {
                    this.CMM.put("dynamic_configs", this.nGm.wc());
                }
                com.bytedance.sdk.openadsdk.core.model.ev evVar2 = this.nGm;
                if (evVar2 != null) {
                    this.CMM.put("extension", evVar2.ikx());
                }
            }
            eli("getTemplateInfo", false);
            return this.CMM.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.DbA
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            nGm(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.DbA
    @JavascriptInterface
    public void muteVideo(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Os os = this.TfR;
            if (os != null) {
                com.bytedance.sdk.openadsdk.utils.cyF.DbA(os);
            }
            Os os2 = new Os(this.bf, jSONObject);
            this.TfR = os2;
            com.bytedance.sdk.openadsdk.utils.cyF.eli(os2);
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.AndroidObject", "");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.DbA
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            Xb(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.DbA
    @JavascriptInterface
    public void changeVideoState(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            com.bytedance.sdk.openadsdk.utils.cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qj.4
                @Override // java.lang.Runnable
                public void run() {
                    qj.this.aqO(jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.DbA
    @JavascriptInterface
    public void clickEvent(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            com.bytedance.sdk.openadsdk.utils.cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qj.5
                @Override // java.lang.Runnable
                public void run() {
                    qj.this.ui(jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.DbA
    @JavascriptInterface
    public void skipVideo() {
        com.bytedance.sdk.openadsdk.utils.cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qj.6
            @Override // java.lang.Runnable
            public void run() {
                qj.this.CMM();
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.DbA
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        dV(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.DbA
    @JavascriptInterface
    public void initRenderFinish() {
        com.bytedance.sdk.openadsdk.utils.cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qj.7
            @Override // java.lang.Runnable
            public void run() {
                if (qj.this.FS != null) {
                    qj.this.FS.eli();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.DbA
    public void eli(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("time");
            String optString = jSONObject.optString("flag");
            com.bytedance.sdk.openadsdk.core.wC.Dfc dfc = this.bf;
            if (dfc != null) {
                dfc.eli(optInt, optString);
            }
        } catch (JSONException unused) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.AndroidObject", "requestPauseVideo json exception");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.DbA
    @JavascriptInterface
    public String getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.CMM.toString();
        }
        try {
            JSONObject eli2 = com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli(this.CMM, new JSONObject(str));
            if (eli2 == null) {
                return this.CMM.toString();
            }
            return eli2.toString();
        } catch (Exception unused) {
            return this.CMM.toString();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.DbA
    @JavascriptInterface
    public void videoFrameChanged(String str) {
        if (this.jh == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.bytedance.sdk.component.adexpress.DbA.nn nnVar = new com.bytedance.sdk.component.adexpress.DbA.nn();
            JSONObject optJSONObject = jSONObject.optJSONObject("videoInfo");
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble(VastAttributes.HORIZONTAL_POSITION);
                double optDouble2 = optJSONObject.optDouble(VastAttributes.VERTICAL_POSITION);
                double optDouble3 = optJSONObject.optDouble("width");
                double optDouble4 = optJSONObject.optDouble("height");
                if (QX(optJSONObject)) {
                    nnVar.eli((float) optJSONObject.optDouble("borderRadiusTopLeft"));
                    nnVar.DbA((float) optJSONObject.optDouble("borderRadiusTopRight"));
                    nnVar.Os((float) optJSONObject.optDouble("borderRadiusBottomLeft"));
                    nnVar.aGH((float) optJSONObject.optDouble("borderRadiusBottomRight"));
                }
                nnVar.Os(optDouble);
                nnVar.aGH(optDouble2);
                nnVar.ui(optDouble3);
                nnVar.MGA(optDouble4);
            }
            com.bytedance.sdk.openadsdk.nlS.kb kbVar = this.jh;
            if (kbVar != null) {
                kbVar.eli(nnVar);
            }
        } catch (Throwable unused) {
        }
    }

    public void aGH(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("zoom_type", 1);
        JSONObject optJSONObject = jSONObject.optJSONObject("videoInfo");
        com.bytedance.sdk.component.adexpress.DbA.nn nnVar = new com.bytedance.sdk.component.adexpress.DbA.nn();
        if (optJSONObject != null) {
            double optDouble = optJSONObject.optDouble(VastAttributes.HORIZONTAL_POSITION);
            double optDouble2 = optJSONObject.optDouble(VastAttributes.VERTICAL_POSITION);
            double optDouble3 = optJSONObject.optDouble("width");
            double optDouble4 = optJSONObject.optDouble("height");
            nnVar.Os(optDouble);
            nnVar.aGH(optDouble2);
            nnVar.ui(optDouble3);
            nnVar.MGA(optDouble4);
        }
        com.bytedance.sdk.openadsdk.core.wC.Dfc dfc = this.bf;
        if (dfc != null) {
            dfc.eli(optInt, nnVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CMM() {
        com.bytedance.sdk.openadsdk.core.wC.Dfc dfc = this.bf;
        if (dfc != null) {
            dfc.eli();
        }
    }

    private void ev() {
        if (this.tGZ == null || TextUtils.isEmpty(dV.aGH().oWW())) {
            return;
        }
        TTWebsiteActivity.eli(this.tGZ, this.nGm, this.SSo);
    }

    public void wC() {
        com.bytedance.sdk.openadsdk.core.wC.Dfc dfc = this.bf;
        if (dfc != null) {
            dfc.DbA();
        }
    }

    public void MGA(String str) {
        this.SSo = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(com.bytedance.sdk.openadsdk.core.wC.Dfc dfc, JSONObject jSONObject) {
        if (dfc == null || jSONObject == null) {
            return;
        }
        try {
            dfc.eli(jSONObject.optBoolean(CampaignEx.JSON_NATIVE_VIDEO_MUTE, false), !jSONObject.has(CampaignEx.JSON_NATIVE_VIDEO_MUTE) ? "jsb_def" : "jsb_web");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqO(JSONObject jSONObject) {
        if (this.bf == null || jSONObject == null) {
            return;
        }
        try {
            this.bf.eli(jSONObject.optInt("stateType", -1));
        } catch (Exception unused) {
        }
    }

    private boolean dV(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.wC.Dfc dfc = this.bf;
        if (dfc != null && jSONObject != null) {
            double Os2 = dfc.Os();
            double aGH = this.bf.aGH();
            int ui = this.bf.ui();
            com.bytedance.sdk.component.utils.Xb.eli("TTAD.TopLayoutHelper", "current:", Double.valueOf(Os2), "state", Integer.valueOf(ui), "countdownTime", Double.valueOf(aGH));
            try {
                jSONObject.put("currentTime", Os2 / 1000.0d);
                if (aGH > 0.0d) {
                    jSONObject.put("countDownTime", aGH / 1000.0d);
                }
                jSONObject.put("state", ui);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private JSONObject Vy() {
        return DbA(this.nGm);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0095 A[Catch: Exception -> 0x00c5, TryCatch #0 {Exception -> 0x00c5, blocks: (B:49:0x0010, B:7:0x0018, B:9:0x0020, B:11:0x0028, B:12:0x002e, B:20:0x0054, B:21:0x006d, B:23:0x0085, B:26:0x008e, B:28:0x0095, B:29:0x0099, B:31:0x009e, B:33:0x00a4, B:34:0x00ad, B:37:0x00b5, B:38:0x00bc, B:41:0x00b9, B:43:0x0061), top: B:48:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b5 A[Catch: Exception -> 0x00c5, TRY_ENTER, TryCatch #0 {Exception -> 0x00c5, blocks: (B:49:0x0010, B:7:0x0018, B:9:0x0020, B:11:0x0028, B:12:0x002e, B:20:0x0054, B:21:0x006d, B:23:0x0085, B:26:0x008e, B:28:0x0095, B:29:0x0099, B:31:0x009e, B:33:0x00a4, B:34:0x00ad, B:37:0x00b5, B:38:0x00bc, B:41:0x00b9, B:43:0x0061), top: B:48:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b9 A[Catch: Exception -> 0x00c5, TryCatch #0 {Exception -> 0x00c5, blocks: (B:49:0x0010, B:7:0x0018, B:9:0x0020, B:11:0x0028, B:12:0x002e, B:20:0x0054, B:21:0x006d, B:23:0x0085, B:26:0x008e, B:28:0x0095, B:29:0x0099, B:31:0x009e, B:33:0x00a4, B:34:0x00ad, B:37:0x00b5, B:38:0x00bc, B:41:0x00b9, B:43:0x0061), top: B:48:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject DbA(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        int RTg;
        boolean aqO;
        JSONObject jSONObject = new JSONObject();
        if (dV.aGH() != null) {
            if (evVar != null) {
                try {
                    RTg = evVar.RTg();
                } catch (Exception unused) {
                }
            } else {
                RTg = 0;
            }
            int cK = evVar != null ? evVar.cK() : 0;
            int YO = evVar != null ? evVar.YO() : 0;
            int Fxk = evVar != null ? evVar.Fxk() : 0;
            boolean ui = dV.aGH().ui(String.valueOf(RTg));
            boolean z = dV.aGH().nlS(String.valueOf(RTg)) == 1;
            if (cK != 7 && cK != 8) {
                aqO = dV.aGH().DbA(String.valueOf(RTg));
                jSONObject.put("voice_control", aqO);
                jSONObject.put("rv_skip_time", YO);
                jSONObject.put("fv_skip_show", ui);
                jSONObject.put("iv_skip_time", Fxk);
                jSONObject.put("show_dislike", evVar == null && evVar.iiz());
                jSONObject.put("video_adaptation", evVar != null ? evVar.Ca() : 0);
                if (evVar != null && evVar.wc() != null) {
                    jSONObject.put("dynamic_configs", evVar.wc());
                }
                if (!com.bytedance.sdk.openadsdk.core.model.Xb.Os(evVar)) {
                    jSONObject.put("skip_change_to_close", true);
                } else {
                    jSONObject.put("skip_change_to_close", z);
                }
                jSONObject.put("bar_render_platform", evVar.dZ() ? 1 : 0);
            }
            aqO = dV.aGH().aqO(String.valueOf(RTg));
            jSONObject.put("voice_control", aqO);
            jSONObject.put("rv_skip_time", YO);
            jSONObject.put("fv_skip_show", ui);
            jSONObject.put("iv_skip_time", Fxk);
            jSONObject.put("show_dislike", evVar == null && evVar.iiz());
            jSONObject.put("video_adaptation", evVar != null ? evVar.Ca() : 0);
            if (evVar != null) {
                jSONObject.put("dynamic_configs", evVar.wc());
            }
            if (!com.bytedance.sdk.openadsdk.core.model.Xb.Os(evVar)) {
            }
            jSONObject.put("bar_render_platform", evVar.dZ() ? 1 : 0);
        }
        return jSONObject;
    }

    public void ui(JSONObject jSONObject) {
        String str;
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.component.utils.Xb.eli("TTAD.AndroidObject", "trigger Class1 method1");
        try {
            String optString = jSONObject.optString(f.b.c);
            int optInt = jSONObject.optInt("areaType", 1);
            String optString2 = jSONObject.optString("clickAreaType");
            JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
            double d10 = 0.0d;
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("down_x", 0.0d);
                d3 = optJSONObject.optDouble("down_y", 0.0d);
                double optDouble2 = optJSONObject.optDouble("up_x", 0.0d);
                double optDouble3 = optJSONObject.optDouble("up_y", 0.0d);
                double optDouble4 = optJSONObject.optDouble("down_time", 0.0d);
                double optDouble5 = optJSONObject.optDouble("up_time", 0.0d);
                double optDouble6 = optJSONObject.optDouble("button_x", 0.0d);
                double optDouble7 = optJSONObject.optDouble("button_y", 0.0d);
                double optDouble8 = optJSONObject.optDouble("button_width", 0.0d);
                double optDouble9 = optJSONObject.optDouble("button_height", 0.0d);
                jSONObject2 = optJSONObject.optJSONObject("rectInfo");
                d9 = optDouble9;
                d10 = optDouble;
                d2 = optDouble2;
                d4 = optDouble4;
                d5 = optDouble5;
                d6 = optDouble6;
                d7 = optDouble7;
                d8 = optDouble8;
                str = optString;
                d = optDouble3;
            } else {
                str = optString;
                d = 0.0d;
                d2 = 0.0d;
                d3 = 0.0d;
                d4 = 0.0d;
                d5 = 0.0d;
                d6 = 0.0d;
                d7 = 0.0d;
                d8 = 0.0d;
                d9 = 0.0d;
                jSONObject2 = null;
            }
            com.bytedance.sdk.openadsdk.core.model.aqO eli2 = new aqO.eli().aGH((float) d10).Os((float) d3).DbA((float) d2).eli((float) d).DbA((long) d4).eli((long) d5).aGH((int) d6).ui((int) d7).MGA((int) d8).kb((int) d9).eli(optString2).eli((SparseArray<Os.eli>) null).eli(true).DbA(optInt).eli(jSONObject2).eli(jSONObject.optInt("clickAreaCategory", -1)).DbA(optJSONObject).eli();
            com.bytedance.sdk.component.adexpress.DbA.du duVar = this.Xb;
            if (duVar != null) {
                duVar.eli(null, optInt, eli2);
            }
            eli(str, optInt, eli2);
        } catch (Exception unused) {
            com.bytedance.sdk.component.adexpress.DbA.du duVar2 = this.Xb;
            if (duVar2 != null) {
                duVar2.eli(null, -1, null);
            }
        }
    }

    private void nGm(JSONObject jSONObject) {
        int i;
        double d;
        double d2;
        double optDouble;
        double optDouble2;
        boolean z;
        int i2;
        double d3;
        String optString;
        qj qjVar = this;
        if (qjVar.Xb == null || jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar = qjVar.cyF;
        if (uiVar != null) {
            uiVar.aqO();
        }
        com.bytedance.sdk.component.adexpress.DbA.nn nnVar = new com.bytedance.sdk.component.adexpress.DbA.nn();
        nnVar.eli(1);
        try {
            boolean optBoolean = jSONObject.optBoolean("isRenderSuc");
            JSONObject optJSONObject = jSONObject.optJSONObject("AdSize");
            if (optJSONObject != null) {
                d = optJSONObject.optDouble("width");
                d2 = optJSONObject.optDouble("height");
            } else {
                d = 0.0d;
                d2 = 0.0d;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("videoInfo");
            if (optJSONObject2 != null) {
                try {
                    optDouble = optJSONObject2.optDouble(VastAttributes.HORIZONTAL_POSITION);
                    optDouble2 = optJSONObject2.optDouble(VastAttributes.VERTICAL_POSITION);
                    z = optBoolean;
                    i2 = 101;
                } catch (Exception unused) {
                    i = 101;
                    qjVar = this;
                    nnVar.DbA(i);
                    nnVar.eli(wC.eli(i));
                    qjVar.Xb.eli(nnVar);
                }
                try {
                    double optDouble3 = optJSONObject2.optDouble("width");
                    double optDouble4 = optJSONObject2.optDouble("height");
                    if (qjVar.QX(optJSONObject2)) {
                        d3 = d2;
                        nnVar.eli((float) optJSONObject2.optDouble("borderRadiusTopLeft"));
                        nnVar.DbA((float) optJSONObject2.optDouble("borderRadiusTopRight"));
                        nnVar.Os((float) optJSONObject2.optDouble("borderRadiusBottomLeft"));
                        nnVar.aGH((float) optJSONObject2.optDouble("borderRadiusBottomRight"));
                    } else {
                        d3 = d2;
                    }
                    nnVar.Os(optDouble);
                    nnVar.aGH(optDouble2);
                    nnVar.ui(optDouble3);
                    nnVar.MGA(optDouble4);
                } catch (Exception unused2) {
                    qjVar = this;
                    i = 101;
                    nnVar.DbA(i);
                    nnVar.eli(wC.eli(i));
                    qjVar.Xb.eli(nnVar);
                }
            } else {
                z = optBoolean;
                d3 = d2;
                i2 = 101;
            }
        } catch (Exception unused3) {
        }
        try {
            optString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, wC.eli(i2));
            i = i2;
        } catch (Exception unused4) {
            qjVar = this;
            i = 101;
            nnVar.DbA(i);
            nnVar.eli(wC.eli(i));
            qjVar.Xb.eli(nnVar);
        }
        try {
            int optInt = jSONObject.optInt("code", i);
            nnVar.eli(z);
            nnVar.eli(d);
            nnVar.DbA(d3);
            nnVar.eli(optString);
            nnVar.DbA(optInt);
            qjVar = this;
            qjVar.Xb.eli(nnVar);
        } catch (Exception unused5) {
            qjVar = this;
            nnVar.DbA(i);
            nnVar.eli(wC.eli(i));
            qjVar.Xb.eli(nnVar);
        }
    }

    private boolean QX(JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    private void Xb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri parse = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.utils.QX.eli(parse, this);
            }
        } catch (Exception unused) {
        }
    }

    private void bf(JSONObject jSONObject) {
        if (jSONObject == null || this.ev == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.ev.eli(true, optJSONArray);
            } else {
                this.ev.eli(false, null);
            }
        } catch (Exception unused) {
            this.ev.eli(false, null);
        }
    }

    public void eli(final DbA dbA, final JSONObject jSONObject) {
        if (dbA == null) {
            return;
        }
        try {
            eli(dbA.aGH, new com.bytedance.sdk.openadsdk.nlS.aGH() { // from class: com.bytedance.sdk.openadsdk.core.qj.8
                @Override // com.bytedance.sdk.openadsdk.nlS.aGH
                public void eli(boolean z, com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
                    if (!z) {
                        qj.this.DbA(dbA.DbA, jSONObject);
                        return;
                    }
                    try {
                        jSONObject.put("creatives", qj.eli(eliVar));
                        qj.this.DbA(dbA.DbA, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private boolean eli(String str, int i, com.bytedance.sdk.openadsdk.core.model.aqO aqo) {
        HashMap<String, aAs> hashMap;
        if (TextUtils.isEmpty(str) || (hashMap = this.qj) == null || hashMap.get(str) == null) {
            return false;
        }
        throw null;
    }

    public void eli(JSONObject jSONObject, final com.bytedance.sdk.openadsdk.nlS.aGH agh) {
        JSONObject optJSONObject;
        if (agh == null) {
            return;
        }
        try {
            final com.bytedance.sdk.openadsdk.nlS.aGH agh2 = new com.bytedance.sdk.openadsdk.nlS.aGH() { // from class: com.bytedance.sdk.openadsdk.core.qj.9
                @Override // com.bytedance.sdk.openadsdk.nlS.aGH
                public void eli(final boolean z, final com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
                    com.bytedance.sdk.openadsdk.utils.cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qj.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            agh.eli(z, eliVar);
                        }
                    });
                }
            };
            if (this.nGm != null && !TextUtils.isEmpty(this.NU)) {
                int cK = this.nGm.cK();
                AdSlot XU = this.nGm.XU();
                com.bytedance.sdk.openadsdk.core.model.ujq ujqVar = new com.bytedance.sdk.openadsdk.core.model.ujq();
                ujqVar.MGA = true;
                if (this.nGm.RY() != null || this.nGm.hg() != null) {
                    ujqVar.FC = 2;
                }
                JSONObject jSONObject2 = this.QX;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                if (jSONObject != null && jSONObject.has("session_params") && (optJSONObject = jSONObject.optJSONObject("session_params")) != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject2.put(next, optJSONObject.opt(next));
                    }
                }
                ujqVar.kb = jSONObject2;
                if (jSONObject != null && jSONObject.has("common_params")) {
                    if (ujqVar.wC == null) {
                        ujqVar.wC = new JSONObject();
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("common_params");
                    if (optJSONObject2 != null) {
                        Iterator<String> keys2 = optJSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            ujqVar.wC.put(next2, optJSONObject2.opt(next2));
                        }
                    }
                }
                if (com.bytedance.sdk.openadsdk.utils.DbA.eli()) {
                    dV.Os().eli(XU, ujqVar, cK, (Xb) new bf() { // from class: com.bytedance.sdk.openadsdk.core.qj.10
                        @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
                        public void eli(int i, String str) {
                            agh2.eli(false, null);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
                        public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                            qj.this.eli(eliVar, os, agh2);
                        }
                    });
                    return;
                } else {
                    dV.Os().eli(XU, ujqVar, cK, new CMM.eli() { // from class: com.bytedance.sdk.openadsdk.core.qj.11
                        @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
                        public void eli(int i, String str) {
                            agh2.eli(false, null);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
                        public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                            qj.this.eli(eliVar, os, agh2);
                        }
                    });
                    return;
                }
            }
            agh2.eli(false, null);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.Xb.eli("TTAD.AndroidObject", "get ads error", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os, com.bytedance.sdk.openadsdk.nlS.aGH agh) {
        if (eliVar.aGH() != null && !eliVar.aGH().isEmpty()) {
            com.bytedance.sdk.openadsdk.core.model.ev evVar = eliVar.aGH().get(0);
            if (evVar != null) {
                this.QX = evVar.nW();
            }
            agh.eli(true, eliVar);
            return;
        }
        agh.eli(false, null);
        os.eli(-3);
        os.Os(7);
        com.bytedance.sdk.openadsdk.core.model.Os.eli(os);
    }

    public static JSONArray eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        com.bytedance.sdk.openadsdk.core.model.ev MGA;
        if (eliVar == null || !eliVar.ui() || (MGA = eliVar.MGA()) == null || TextUtils.isEmpty(MGA.eD())) {
            return null;
        }
        try {
            return new JSONObject(MGA.eD()).optJSONArray("creatives");
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean gG() {
        com.bytedance.sdk.openadsdk.core.model.ev evVar = this.nGm;
        if (evVar == null || evVar.nW() == null || com.bytedance.sdk.openadsdk.core.model.KM.DbA(this.nGm) || this.nro || this.nGm.nW().optInt("parent_type") != 2) {
            return false;
        }
        int cK = this.nGm.cK();
        if (cK != 8 && cK != 7) {
            return false;
        }
        this.nro = true;
        return true;
    }

    public void Os(boolean z) {
        this.Os = z;
    }

    public boolean FC() {
        return this.Uv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            CMM(jSONObject2);
        } catch (Exception unused) {
        }
    }

    private void CMM(JSONObject jSONObject) {
        WebView aqO;
        if (jSONObject == null || (aqO = aqO()) == null) {
            return;
        }
        com.bytedance.sdk.component.utils.nn.eli(aqO, "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject + ")");
    }

    private void Os(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "event");
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            CMM(jSONObject2);
        } catch (Exception unused) {
        }
    }

    private void kb(String str) {
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 2)));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                DbA dbA = new DbA();
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        dbA.eli = optJSONObject.optString("__msg_type", null);
                        dbA.DbA = optJSONObject.optString("__callback_id", null);
                        dbA.Os = optJSONObject.optString("func");
                        dbA.aGH = optJSONObject.optJSONObject("params");
                        dbA.ui = optJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(dbA.eli) && !TextUtils.isEmpty(dbA.Os)) {
                    Message obtainMessage = this.MGA.obtainMessage(11);
                    obtainMessage.obj = dbA;
                    this.MGA.sendMessage(obtainMessage);
                }
            }
        } catch (Exception unused2) {
        }
    }

    public boolean eli(Uri uri) {
        if (uri == null) {
            return false;
        }
        if ("bytedance".equals(uri.getScheme())) {
            return FC.containsKey(uri.getHost());
        }
        return false;
    }

    public void DbA(final Uri uri) {
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if (CacheControl.PRIVATE.equals(host) || "dispatch_message".equals(host)) {
                    FC(uri.toString());
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.aGH.Os.eli(new com.bytedance.sdk.component.wC.wC("log_event_handleUri") { // from class: com.bytedance.sdk.openadsdk.core.qj.2
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    String str;
                    String queryParameter = uri.getQueryParameter("category");
                    String queryParameter2 = uri.getQueryParameter("tag");
                    qj.this.SSo = queryParameter2;
                    String queryParameter3 = uri.getQueryParameter("label");
                    if (qj.this.wC(queryParameter3)) {
                        long j2 = 0;
                        try {
                            j = Long.parseLong(uri.getQueryParameter("value"));
                        } catch (Exception unused) {
                            j = 0;
                        }
                        try {
                            j2 = Long.parseLong(uri.getQueryParameter("ext_value"));
                        } catch (Exception unused2) {
                        }
                        long j3 = j2;
                        JSONObject jSONObject = null;
                        try {
                            String queryParameter4 = uri.getQueryParameter("extra");
                            if (!TextUtils.isEmpty(queryParameter4)) {
                                JSONObject jSONObject2 = new JSONObject(queryParameter4);
                                try {
                                    jSONObject2.putOpt("ua_policy", Integer.valueOf(qj.this.aqO));
                                } catch (Throwable unused3) {
                                }
                                jSONObject = jSONObject2;
                            }
                        } catch (Throwable unused4) {
                        }
                        if ("click".equals(queryParameter3)) {
                            jSONObject = qj.this.ev(jSONObject);
                        }
                        if (!"landing_perf_error".equals(queryParameter3) && !"landing_perf_stats".equals(queryParameter3)) {
                            str = qj.this.eli(queryParameter2, queryParameter3);
                        } else {
                            try {
                                jSONObject = new JSONObject();
                                for (String str2 : uri.getQueryParameterNames()) {
                                    try {
                                        if ("extra".equals(str2)) {
                                            jSONObject.put("ad_extra_data", new JSONObject(uri.getQueryParameter(str2)).optString("ad_extra_data"));
                                        } else {
                                            jSONObject.put(str2, uri.getQueryParameter(str2));
                                        }
                                    } catch (Exception unused5) {
                                    }
                                }
                                str = qj.this.kb;
                            } catch (Exception unused6) {
                                return;
                            }
                        }
                        com.bytedance.sdk.openadsdk.aGH.Os.eli(qj.this.nGm, queryParameter, str, queryParameter3, j, j3, jSONObject, com.bytedance.sdk.openadsdk.core.model.Xb.ui(qj.this.nGm));
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wC(String str) {
        if (!TextUtils.isEmpty(str) && "click_other".equals(str)) {
            return aAs();
        }
        return true;
    }

    boolean aAs() {
        com.bytedance.sdk.openadsdk.core.model.ev evVar = this.nGm;
        return evVar != null && evVar.QW() == 1;
    }

    public void Os(int i) {
        com.bytedance.sdk.openadsdk.core.wC.Dfc dfc = this.bf;
        if (dfc != null) {
            dfc.DbA(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject ev(JSONObject jSONObject) {
        if (this.eli != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String optString = jSONObject.optString("ad_extra_data", null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                for (Map.Entry<String, Object> entry : this.eli.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.Xb.Os(e.toString(), new Object[0]);
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String eli(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.core.model.Xb.ui(this.nGm)) {
            if (C3207n2.v.equals(str2)) {
                return dZ.eli(this.nn);
            }
            return "aggregate_page";
        }
        if (com.bytedance.sdk.openadsdk.core.model.KM.ui(this.nGm)) {
            return this.kb;
        }
        if (this.VM != null) {
            return dZ.eli(this.nn);
        }
        return this.Xb == null ? dZ.DbA(this.nn) : str;
    }

    private void FC(String str) {
        int length;
        int indexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView aqO = aqO();
                    if (aqO != null) {
                        com.bytedance.sdk.component.utils.nn.eli(aqO, "javascript:ToutiaoJSBridge._fetchQueue()");
                        return;
                    }
                    return;
                }
                if (str.startsWith("bytedance://private/setresult/") && (indexOf = str.indexOf(38, (length = "bytedance://private/setresult/".length()))) > 0) {
                    String substring = str.substring(length, indexOf);
                    String substring2 = str.substring(indexOf + 1);
                    if (!substring.equals("SCENE_FETCHQUEUE") || substring2.length() <= 0) {
                        return;
                    }
                    kb(substring2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void du() {
        gG();
    }

    public void nlS() {
        com.bytedance.sdk.openadsdk.aAs.Os os = this.aAs;
        if (os != null) {
            os.eli();
        }
        Os os2 = this.TfR;
        if (os2 != null) {
            com.bytedance.sdk.openadsdk.utils.cyF.DbA(os2);
            this.TfR = null;
        }
        this.tGZ = null;
        this.WfR = null;
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
        if (message != null && message.what == 11 && (message.obj instanceof DbA)) {
            try {
                eli((DbA) message.obj, 1);
            } catch (Exception unused) {
            }
        }
    }

    private void ujq() {
        if (this.aAs == null) {
            this.aAs = com.bytedance.sdk.openadsdk.aAs.eli.eli(this, this.nGm);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.aAs.DbA
    public void eli(String str, JSONObject jSONObject) {
        Os(str, jSONObject);
    }

    public void NU() {
        eli eliVar = this.ow;
        if (eliVar != null) {
            eliVar.eli();
        }
    }

    public void aGH(boolean z) {
        this.Za = z;
    }

    public void ui(boolean z) {
        this.ikX = z;
    }

    public void MGA(JSONObject jSONObject) {
        new Object[]{"trigger common convert", jSONObject};
        com.bytedance.sdk.openadsdk.core.model.ev eli2 = com.bytedance.sdk.openadsdk.core.DbA.eli(jSONObject);
        if (eli2 != null) {
            boolean ui = com.bytedance.sdk.openadsdk.core.model.Xb.ui(this.nGm);
            eli(eli2, ui ? dZ.DbA(this.nn) : this.SSo, !ui);
        }
    }

    private void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.core.DbA.eli(dV.eli(), evVar, str, this.nn);
        eliVar.eli(com.bytedance.sdk.openadsdk.QX.eli.eli.kb.eli(dV.eli(), str));
        if (!z) {
            eliVar.eli(false);
        }
        eliVar.onClick(null);
    }

    public JSONObject kb(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        com.bytedance.sdk.openadsdk.core.wC.Dfc dfc = this.bf;
        if (dfc != null) {
            try {
                jSONObject2.put("state", dfc.DbA(jSONObject) ? 1 : 0);
            } catch (Throwable unused) {
            }
        }
        return jSONObject2;
    }

    public JSONObject wC(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        com.bytedance.sdk.openadsdk.core.wC.Dfc dfc = this.bf;
        if (dfc != null) {
            try {
                jSONObject2.put("state", dfc.eli(jSONObject) ? 1 : 0);
            } catch (Throwable unused) {
            }
        }
        return jSONObject2;
    }

    public JSONObject FC(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA = this.WfR;
            if (dbA != null) {
                List<com.bytedance.sdk.openadsdk.core.model.ev> KM = dbA.KM();
                for (int i = 0; i < KM.size(); i++) {
                    jSONArray.put(Os(KM.get(i)));
                }
            }
            jSONObject2.put("creatives", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    private JSONObject Os(com.bytedance.sdk.openadsdk.core.model.ev evVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("is_ad_event", "1");
        jSONObject2.put("cid", evVar.Uv());
        jSONObject2.put("req_id", evVar.fO());
        jSONObject2.put("ad_id", evVar.umh());
        jSONObject2.put("log_extra", evVar.eu());
        jSONObject2.put("isRTL", com.bytedance.sdk.openadsdk.core.settings.NU.nY().rQ());
        jSONObject.put("ad_info", jSONObject2);
        jSONObject.put("endcard_creative", evVar.FS());
        jSONObject.put("dynamic_creative", evVar.vb());
        jSONObject.put("title", evVar.Pf());
        com.bytedance.sdk.openadsdk.core.model.ev.eli(evVar, jSONObject);
        com.bytedance.sdk.openadsdk.core.model.ev.DbA(evVar, jSONObject);
        jSONObject.put("source", evVar.kEI());
        jSONObject.put("button_text", evVar.lkd());
        com.bytedance.sdk.openadsdk.core.model.NU Eh = evVar.Eh();
        if (Eh != null) {
            jSONObject.put("deeplink_url", Eh.eli());
        }
        jSONObject.put("app_name", evVar.Tju());
        jSONObject.put("has_show", evVar.eU() ? 1 : 0);
        jSONObject.put("has_click", evVar.ip() ? 1 : 0);
        return jSONObject;
    }

    public void aAs(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.eli Os2;
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt(FirebaseAnalytics.Param.INDEX);
        com.bytedance.sdk.openadsdk.core.model.ev evVar = this.nGm;
        if (evVar == null || (Os2 = evVar.Os()) == null) {
            return;
        }
        List<com.bytedance.sdk.openadsdk.core.model.ev> aGH = Os2.aGH();
        if (optInt < 0 || optInt >= aGH.size()) {
            return;
        }
        eli(aGH.get(optInt), this.SSo, false);
        com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA = this.WfR;
        if (dbA != null) {
            dbA.MGA();
        }
    }

    public void eli(JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.wC.Dfc dfc = this.bf;
        if (dfc != null) {
            dfc.eli(str, jSONObject);
            return;
        }
        com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA = this.WfR;
        if (dbA != null) {
            dbA.eli(str, jSONObject);
        }
    }

    public void eli(com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA) {
        this.WfR = dbA;
    }

    public com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA nn() {
        return this.WfR;
    }

    public void eli(eli eliVar) {
        this.ow = eliVar;
    }

    private static class Os implements Runnable {
        private final JSONObject DbA;
        private final com.bytedance.sdk.openadsdk.core.wC.Dfc eli;

        public Os(com.bytedance.sdk.openadsdk.core.wC.Dfc dfc, JSONObject jSONObject) {
            this.eli = dfc;
            this.DbA = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            qj.DbA(this.eli, this.DbA);
        }
    }

    public void du(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(new com.bytedance.sdk.component.wC.wC("sendLogV3") { // from class: com.bytedance.sdk.openadsdk.core.qj.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject optJSONObject = jSONObject.optJSONObject("extJson");
                if (optJSONObject != null && optJSONObject.has("category") && optJSONObject.has("tag") && optJSONObject.has("label")) {
                    String optString = optJSONObject.optString("category");
                    String optString2 = optJSONObject.optString("tag");
                    String optString3 = optJSONObject.optString("label");
                    long optLong = jSONObject.optLong("value");
                    long optLong2 = jSONObject.optLong("extValue");
                    try {
                        optJSONObject.put("ua_policy", qj.this.aqO);
                    } catch (Exception unused) {
                    }
                    new Object[]{"trigger sendLogV3, extJson is:", optJSONObject};
                    new eli.C0165eli(System.currentTimeMillis(), qj.this.nGm).aGH(optString).DbA(optString2).Os(optString3).ui(String.valueOf(optLong)).MGA(String.valueOf(optLong2)).eli(optJSONObject).eli((com.bytedance.sdk.openadsdk.aGH.DbA.eli) null);
                }
            }
        });
    }

    public void Dfc() {
        com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA = this.WfR;
        if (dbA != null) {
            dbA.Cp();
        }
    }
}
