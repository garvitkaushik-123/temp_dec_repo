package com.bytedance.sdk.openadsdk.Xb;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class wC {
    private int BDs;
    private int BH;
    private float Bnk;
    private int CH;
    private boolean CMM;
    private WeakReference<View> Ca;
    private long Cp;
    private int DE;
    private List<JSONObject> Daf;
    public final String DbA;
    private DbA Dfc;
    private volatile boolean Eh;
    private Runnable FC;
    private String FS;
    private long GB;
    private int GMY;
    private String GMu;
    private ViewTreeObserver.OnGlobalLayoutListener GR;
    private Os Gjg;
    private String HN;
    private Map<String, String> Hm;
    private boolean ID;
    private int Ib;
    private int KM;
    private int Kp;
    private final String MGA;
    private JSONObject MQ;
    private JSONObject Mc;
    private String ND;
    private Runnable NU;
    private int OJ;
    public final String Os;
    private boolean Pf;
    private WebView PfW;
    private int QI;
    private int QMZ;
    private float QW;
    private Set<String> QX;
    private boolean QxD;
    private String RY;
    private String SSo;
    private int SjY;
    private int TfR;
    private int TiA;
    private int Tju;
    private long Ue;
    private String Uv;
    private long VM;
    private boolean Vy;
    private int WfR;
    private int XU;
    private String Xb;
    private int XlF;
    private JSONObject XxP;
    private int Yw;
    private boolean ZLD;
    private int Za;
    private Runnable aAs;
    public final String aGH;
    private boolean an;
    private boolean aqO;
    private String bU;
    private String bf;
    private boolean cvo;
    private long cyF;
    private String dM;
    private boolean dV;
    private long dZ;
    private Runnable du;
    private Context eEH;
    private long eU;
    public final String eli;
    private volatile boolean eu;
    private boolean ev;
    private String gAc;
    private String gG;
    private long gHb;
    private JSONObject hg;
    private int ikX;
    private String iuv;
    private String jh;
    private int kEI;
    private final String kb;
    private boolean lYL;
    private String lkd;
    private int mS;
    private int mm;
    private boolean nGm;
    private float nY;
    private final Handler nlS;
    private Runnable nn;
    private long nro;
    private long oWW;
    private String oc;
    private int ow;
    private boolean pu;
    private String qWy;
    private long qj;
    private int qyC;
    private eli rH;
    private boolean rQ;
    private com.bytedance.sdk.openadsdk.Xb.eli rn;
    private boolean tGZ;
    private long tLO;
    private boolean tpZ;
    public final String ui;
    private long ujq;
    private String umh;
    private String vb;
    private final Handler wC;
    private MGA yKf;
    private int yw;

    public enum eli {
        LAND_PAGE,
        FEED,
        OTHER,
        FEED_AWEME
    }

    static /* synthetic */ int NU(wC wCVar) {
        int i = wCVar.ikX;
        wCVar.ikX = i + 1;
        return i;
    }

    static /* synthetic */ int nlS(wC wCVar) {
        int i = wCVar.Za;
        wCVar.Za = i + 1;
        return i;
    }

    private wC(Context context, WebView webView, Os os, com.bytedance.sdk.openadsdk.Xb.eli eliVar, eli eliVar2) {
        this.MGA = "playable_stuck_check_ping";
        this.kb = "playable_apply_media_permission_callback";
        this.wC = new Handler(Looper.getMainLooper());
        this.nlS = new Handler(Looper.getMainLooper());
        this.aqO = true;
        this.dV = true;
        this.nGm = true;
        this.eli = "PL_sdk_playable_global_viewable";
        this.DbA = "PL_sdk_page_screen_blank";
        this.Os = "PL_sdk_playable_destroy_analyze_summary";
        this.aGH = "PL_sdk_playable_hardware_dialog_cancel";
        this.ui = "PL_sdk_playable_hardware_dialog_setting";
        this.QX = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.Xb = null;
        this.bf = "embeded_ad";
        this.CMM = true;
        this.ev = true;
        this.Vy = false;
        this.gG = "";
        this.ujq = 10L;
        this.Ue = 10L;
        this.KM = IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED;
        this.VM = 0L;
        this.GB = 0L;
        this.oWW = -1L;
        this.qj = -1L;
        this.nro = -1L;
        this.Cp = -1L;
        this.cyF = -1L;
        this.eU = -1L;
        this.dZ = -1L;
        this.SSo = "";
        this.Uv = "";
        this.FS = "";
        this.jh = "";
        this.Za = 0;
        this.ikX = 0;
        this.tGZ = false;
        this.WfR = 0;
        this.ow = -1;
        this.TfR = 0;
        this.QI = 0;
        this.mm = 0;
        this.oc = null;
        this.rQ = false;
        this.Yw = 0;
        this.qyC = 0;
        this.BH = 0;
        this.BDs = 0;
        this.tLO = 0L;
        this.gHb = 0L;
        this.DE = -2;
        this.GMY = 0;
        this.XU = 0;
        this.Kp = 0;
        this.MQ = new JSONObject();
        this.Hm = new HashMap();
        this.XxP = new JSONObject();
        this.vb = "";
        this.Bnk = 0.0f;
        this.QW = 0.0f;
        this.tpZ = false;
        this.Pf = false;
        this.cvo = false;
        this.Daf = new ArrayList();
        this.pu = true;
        this.Eh = true;
        this.eu = true;
        this.GR = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.Xb.wC.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) wC.this.Ca.get();
                    if (view == null) {
                        return;
                    }
                    wC.this.DbA(view);
                } catch (Throwable th) {
                    kb.eli("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.mS = -1;
        this.DE = 0;
        this.rH = eliVar2;
        this.PfW = webView;
        FC.eli(webView);
        eli(webView);
        eli(context, os, eliVar);
    }

    private wC(Context context, int i, Os os, com.bytedance.sdk.openadsdk.Xb.eli eliVar) {
        this.MGA = "playable_stuck_check_ping";
        this.kb = "playable_apply_media_permission_callback";
        this.wC = new Handler(Looper.getMainLooper());
        this.nlS = new Handler(Looper.getMainLooper());
        this.aqO = true;
        this.dV = true;
        this.nGm = true;
        this.eli = "PL_sdk_playable_global_viewable";
        this.DbA = "PL_sdk_page_screen_blank";
        this.Os = "PL_sdk_playable_destroy_analyze_summary";
        this.aGH = "PL_sdk_playable_hardware_dialog_cancel";
        this.ui = "PL_sdk_playable_hardware_dialog_setting";
        this.QX = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.Xb = null;
        this.bf = "embeded_ad";
        this.CMM = true;
        this.ev = true;
        this.Vy = false;
        this.gG = "";
        this.ujq = 10L;
        this.Ue = 10L;
        this.KM = IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED;
        this.VM = 0L;
        this.GB = 0L;
        this.oWW = -1L;
        this.qj = -1L;
        this.nro = -1L;
        this.Cp = -1L;
        this.cyF = -1L;
        this.eU = -1L;
        this.dZ = -1L;
        this.SSo = "";
        this.Uv = "";
        this.FS = "";
        this.jh = "";
        this.Za = 0;
        this.ikX = 0;
        this.tGZ = false;
        this.WfR = 0;
        this.ow = -1;
        this.TfR = 0;
        this.QI = 0;
        this.mm = 0;
        this.oc = null;
        this.rQ = false;
        this.Yw = 0;
        this.qyC = 0;
        this.BH = 0;
        this.BDs = 0;
        this.tLO = 0L;
        this.gHb = 0L;
        this.DE = -2;
        this.GMY = 0;
        this.XU = 0;
        this.Kp = 0;
        this.MQ = new JSONObject();
        this.Hm = new HashMap();
        this.XxP = new JSONObject();
        this.vb = "";
        this.Bnk = 0.0f;
        this.QW = 0.0f;
        this.tpZ = false;
        this.Pf = false;
        this.cvo = false;
        this.Daf = new ArrayList();
        this.pu = true;
        this.Eh = true;
        this.eu = true;
        this.GR = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.Xb.wC.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) wC.this.Ca.get();
                    if (view == null) {
                        return;
                    }
                    wC.this.DbA(view);
                } catch (Throwable th) {
                    kb.eli("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.mS = -1;
        this.DE = i;
        this.rH = eli.LAND_PAGE;
        eli(context, os, eliVar);
    }

    private void eli(Context context, Os os, com.bytedance.sdk.openadsdk.Xb.eli eliVar) {
        this.Xb = UUID.randomUUID().toString();
        this.eEH = context;
        this.rn = eliVar;
        this.Gjg = os;
        aAs.eli(eliVar);
        this.yKf = new MGA(this);
        Uv();
        if (this.PfW == null) {
            this.mS = 4;
            this.wC.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Xb.wC.4
                @Override // java.lang.Runnable
                public void run() {
                    wC.this.eli(5, "webview is null");
                }
            });
        }
    }

    private void Uv() {
        this.Dfc = new DbA(this, this.KM);
        this.FC = new Runnable() { // from class: com.bytedance.sdk.openadsdk.Xb.wC.5
            @Override // java.lang.Runnable
            public void run() {
                if (wC.this.CMM) {
                    wC.this.CMM = false;
                    wC.this.wC.removeCallbacks(wC.this.aAs);
                    wC.this.eli(2, "ContainerLoadTimeOut");
                }
            }
        };
        this.aAs = new Runnable() { // from class: com.bytedance.sdk.openadsdk.Xb.wC.6
            @Override // java.lang.Runnable
            public void run() {
                if (wC.this.CMM) {
                    wC.this.CMM = false;
                    wC.this.Eh = false;
                    wC.this.wC.removeCallbacks(wC.this.FC);
                    wC.this.eli(3, "JSSDKLoadTimeOut");
                }
            }
        };
        this.NU = new Runnable() { // from class: com.bytedance.sdk.openadsdk.Xb.wC.7
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (wC.this.PfW != null) {
                    wC.this.PfW.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.Xb.wC.7.1
                        @Override // android.webkit.ValueCallback
                        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            if (wC.this.Dfc != null) {
                                wC.this.Dfc.eli(System.currentTimeMillis());
                            }
                        }
                    });
                }
                if (wC.this.nlS != null) {
                    wC.this.nlS.postDelayed(this, 500L);
                }
            }
        };
        this.nn = new Runnable() { // from class: com.bytedance.sdk.openadsdk.Xb.wC.8
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                wC.this.eli("playable_stuck_check_ping", new JSONObject());
                if (wC.this.nlS != null) {
                    wC.this.nlS.postDelayed(this, 500L);
                }
            }
        };
        this.du = new Runnable() { // from class: com.bytedance.sdk.openadsdk.Xb.wC.9
            @Override // java.lang.Runnable
            public void run() {
                if (wC.this.gHb <= 0) {
                    wC.this.DbA(1, "Clicking on the hot zone causes the program to freeze.");
                } else {
                    if (wC.this.gHb - wC.this.tLO <= wC.this.KM) {
                        wC.this.qj();
                        wC.this.tLO = 0L;
                        wC.this.gHb = 0L;
                        return;
                    }
                    wC.this.DbA(1, "Clicking on the hot zone causes the program to freeze.");
                }
            }
        };
    }

    private boolean nlS(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/union-fe/playable/") || str.contains("/union-fe-sg/playable/") || str.contains("/union-fe-i18n/playable/");
    }

    public void eli(View view) {
        if (view == null) {
            return;
        }
        try {
            this.Ca = new WeakReference<>(view);
            DbA(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.GR);
        } catch (Throwable th) {
            kb.eli("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.XU == view.getWidth() && this.Kp == view.getHeight()) {
                return;
            }
            this.XU = view.getWidth();
            this.Kp = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.XU);
            jSONObject.put("height", this.Kp);
            eli(n.g, jSONObject);
            this.MQ = jSONObject;
        } catch (Throwable th) {
            kb.eli("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public Context eli() {
        return this.eEH;
    }

    public wC eli(String str, String str2) {
        this.Hm.put(str, str2);
        return this;
    }

    public Map<String, String> DbA() {
        return this.Hm;
    }

    public wC eli(String str) {
        this.gAc = str;
        return this;
    }

    public wC DbA(String str) {
        this.iuv = str;
        return this;
    }

    public JSONObject Os() {
        return this.hg;
    }

    public wC Os(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playable_style", str);
            this.hg = jSONObject;
            return this;
        } catch (Throwable th) {
            kb.eli("PlayablePlugin", "setPlayableStyle error", th);
            return this;
        }
    }

    public String aGH() {
        return this.iuv;
    }

    public String ui() {
        return this.gAc;
    }

    public wC aGH(String str) {
        this.HN = str;
        return this;
    }

    public String MGA() {
        return this.HN;
    }

    public wC ui(String str) {
        this.dM = str;
        return this;
    }

    public String kb() {
        return this.dM;
    }

    public wC eli(boolean z) {
        this.an = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.an);
            eli("volumeChange", jSONObject);
            return this;
        } catch (Throwable th) {
            kb.eli("PlayablePlugin", "setIsMute error", th);
            return this;
        }
    }

    public boolean wC() {
        return this.an;
    }

    public wC DbA(boolean z) {
        this.ID = z;
        return this;
    }

    public wC eli(long j) {
        if (j <= 0) {
            this.ujq = 10L;
            return this;
        }
        this.ujq = j;
        return this;
    }

    public wC DbA(long j) {
        if (j <= 0) {
            this.Ue = 10L;
            return this;
        }
        this.Ue = j;
        return this;
    }

    public void eli(int i) {
        this.mS = i;
    }

    public wC Os(boolean z) {
        if (this.mS != -1 && this.lYL != z) {
            this.lYL = z;
            JSONObject jSONObject = new JSONObject();
            try {
                if (!this.lYL) {
                    jSONObject.put("playable_background_show_type", this.qyC);
                }
            } catch (JSONException unused) {
            }
            Os(this.lYL ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", jSONObject);
            if (this.qj == -1 && this.lYL) {
                this.qj = System.currentTimeMillis();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("render_type", this.mS == 1 ? 1 : 2);
                    int i = this.mS;
                    if (i != -1) {
                        jSONObject2.put("webview_state", i);
                    }
                } catch (JSONException unused2) {
                }
                Os("PL_sdk_page_show", jSONObject2);
            }
            if (this.qj != -1 && !this.lYL && !this.tpZ) {
                this.tpZ = true;
            }
            if (this.lYL) {
                this.oWW = System.currentTimeMillis();
            } else if (this.oWW != -1) {
                this.VM += System.currentTimeMillis() - this.oWW;
                this.oWW = -1L;
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("viewStatus", this.lYL);
                eli(C3040d4.g.V, jSONObject3);
            } catch (Throwable th) {
                kb.eli("PlayablePlugin", "setViewable error", th);
            }
            if (this.lYL) {
                qj();
            } else {
                nro();
            }
        }
        return this;
    }

    public boolean FC() {
        return this.lYL;
    }

    public wC aGH(boolean z) {
        this.ZLD = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.ZLD);
            eli("change_playable_click", jSONObject);
            return this;
        } catch (Throwable th) {
            kb.eli("PlayablePlugin", "setPlayableClick error", th);
            return this;
        }
    }

    public JSONObject aAs() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.ZLD);
            return jSONObject;
        } catch (Throwable th) {
            kb.eli("PlayablePlugin", "getPlayableClickStatus error", th);
            return new JSONObject();
        }
    }

    public Set<String> du() {
        return this.yKf.eli();
    }

    public JSONObject nlS() {
        try {
            boolean eli2 = ui.eli(this.eEH, "android.permission.RECORD_AUDIO");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", eli2);
            return jSONObject;
        } catch (Throwable th) {
            kb.eli("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject NU() {
        try {
            boolean eli2 = ui.eli(this.eEH, "android.permission.CAMERA");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", eli2);
            return jSONObject;
        } catch (Throwable th) {
            kb.eli("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject nn() {
        boolean eli2;
        boolean eli3;
        try {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 33) {
                eli2 = ui.eli(this.eEH, "android.permission.READ_MEDIA_IMAGES");
                eli3 = true;
            } else {
                eli2 = ui.eli(this.eEH, "android.permission.READ_EXTERNAL_STORAGE");
                eli3 = ui.eli(this.eEH, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHasRead", eli2);
            jSONObject.put("isHasWrite", eli3);
            if (!eli2 || !eli3) {
                z = false;
            }
            jSONObject.put("result", z);
            return jSONObject;
        } catch (Throwable th) {
            kb.eli("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public void eli(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.Xb.eli eliVar = this.rn;
        if (eliVar == null || eliVar.DbA(jSONObject) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("resource_base64");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        int optInt = jSONObject.optInt("resource_type", -1);
        String optString2 = jSONObject.optString("resource_name", "playable_media");
        if (optInt == 1) {
            DbA(optString2, optString);
        }
    }

    public void DbA(JSONObject jSONObject) {
        if (this.rn != null) {
            try {
                jSONObject.optBoolean("isPrevent", false);
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject Dfc() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AnalyticsConstants.SCENE_TYPE, this.rH.ordinal());
            jSONObject.put("safe_area_top_height", this.Bnk);
            jSONObject.put("safe_area_bottom_height", this.QW);
            jSONObject.put("playable_enter_from", this.QI);
            jSONObject.put("playable_retry_count", this.TfR);
            jSONObject.put("playable_card_session", this.SSo);
            jSONObject.put("playable_video_session", this.Uv);
            jSONObject.put("playable_network_type", aqO());
            jSONObject.put("aweme_id", this.jh);
            return jSONObject;
        } catch (Throwable th) {
            kb.eli("PlayablePlugin", "playableInfo error", th);
            return new JSONObject();
        }
    }

    public void eli(String str, JSONObject jSONObject) {
        if (kb.eli() && jSONObject != null) {
            jSONObject.toString();
        }
        Os os = this.Gjg;
        if (os != null) {
            os.eli(str, jSONObject);
        }
    }

    public void DbA(String str, String str2) {
        Bitmap eli2;
        if (TextUtils.isEmpty(str2) || (eli2 = ui.eli(str2)) == null) {
            return;
        }
        MediaStore.Images.Media.insertImage(this.eEH.getContentResolver(), eli2, str, "");
    }

    public String aqO() {
        com.bytedance.sdk.openadsdk.Xb.eli eliVar;
        if (TextUtils.isEmpty(this.FS) && (eliVar = this.rn) != null) {
            this.FS = eliVar.eli().toString();
        }
        return this.FS;
    }

    public com.bytedance.sdk.openadsdk.Xb.eli dV() {
        return this.rn;
    }

    public JSONObject nGm() {
        if (this.MQ.isNull("width")) {
            View view = this.Ca.get();
            if (view == null) {
                return this.MQ;
            }
            DbA(view);
        }
        return this.MQ;
    }

    public JSONObject QX() {
        return this.XxP;
    }

    public wC Os(JSONObject jSONObject) {
        this.XxP = jSONObject;
        return this;
    }

    public wC MGA(String str) {
        this.bf = str;
        return this;
    }

    public wC kb(String str) {
        Uri parse;
        String scheme;
        int indexOf;
        String decode;
        this.vb = str;
        try {
            parse = Uri.parse(str);
            scheme = parse.getScheme();
        } catch (Throwable unused) {
        }
        if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
            String host = parse.getHost();
            if (!C3040d4.h.K.equalsIgnoreCase(host) && (host == null || !host.contains(C3040d4.h.K))) {
                if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                    if (this.DE == -1) {
                        DbA(2);
                    } else {
                        DbA(1);
                    }
                }
                this.ND = str;
                return this;
            }
            DbA(0);
            String queryParameter = parse.getQueryParameter("url");
            if (!TextUtils.isEmpty(queryParameter) && (decode = Uri.decode(queryParameter)) != null) {
                int indexOf2 = decode.indexOf("?");
                str = indexOf2 != -1 ? decode.substring(0, indexOf2) : decode;
            }
            this.ND = str;
            return this;
        }
        DbA(0);
        if (str != null && (indexOf = str.indexOf("?")) != -1) {
            str = str.substring(0, indexOf);
        }
        this.ND = str;
        return this;
    }

    public wC DbA(int i) {
        this.DE = i;
        return this;
    }

    public wC eli(float f) {
        this.nY = f;
        return this;
    }

    public JSONObject Xb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.nY);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.kEI);
            jSONObject2.put("height", this.Tju);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(VastAttributes.HORIZONTAL_POSITION, this.CH);
            jSONObject3.put(VastAttributes.VERTICAL_POSITION, this.yw);
            jSONObject3.put("width", this.QMZ);
            jSONObject3.put("height", this.OJ);
            jSONObject.put(C3040d4.h.K, jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(VastAttributes.HORIZONTAL_POSITION, this.XlF);
            jSONObject4.put(VastAttributes.VERTICAL_POSITION, this.Ib);
            jSONObject4.put("width", this.SjY);
            jSONObject4.put("height", this.TiA);
            jSONObject.put(VastAttributes.VISIBLE, jSONObject4);
            return jSONObject;
        } catch (Throwable th) {
            kb.eli("PlayablePlugin", "getViewport error", th);
            return jSONObject;
        }
    }

    public void bf() {
        com.bytedance.sdk.openadsdk.Xb.eli eliVar = this.rn;
        if (eliVar != null) {
            eliVar.DbA();
        }
    }

    public void CMM() {
        com.bytedance.sdk.openadsdk.Xb.eli eliVar = this.rn;
        if (eliVar != null) {
            eliVar.Os();
        }
    }

    public void ev() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.cyF > 0) {
                jSONObject.put("playable_material_interactable_duration", System.currentTimeMillis() - this.cyF);
            } else {
                jSONObject.put("playable_material_interactable_duration", 0L);
            }
            if (this.nro > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.nro;
                this.dZ = currentTimeMillis;
                jSONObject.put("playable_material_interactable_load_duration", currentTimeMillis);
            } else {
                jSONObject.put("playable_material_interactable_load_duration", 0L);
            }
            Os("PL_sdk_material_interactable", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void aGH(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.oc = jSONObject.optString("section");
        }
    }

    public void Vy() {
        this.ow = 2;
    }

    public void gG() {
        this.rQ = true;
    }

    public void ujq() {
        if (this.rn != null) {
            eli eliVar = eli.FEED_AWEME;
        }
    }

    public void Ue() {
        if (this.rn != null) {
            eli eliVar = eli.FEED_AWEME;
        }
    }

    public void ui(JSONObject jSONObject) {
        this.Mc = jSONObject;
        this.mm++;
        nro();
        this.wC.removeCallbacks(this.du);
        if (this.ev) {
            this.eU = System.currentTimeMillis();
            this.tLO = System.currentTimeMillis();
            this.gHb = 0L;
            int i = this.DE;
            if (i == 0) {
                WebView webView = this.PfW;
                if (webView != null) {
                    webView.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.Xb.wC.10
                        @Override // android.webkit.ValueCallback
                        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            wC.this.gHb = System.currentTimeMillis();
                        }
                    });
                }
            } else if (i == 1 || i == 2) {
                eli("playable_stuck_check_ping", new JSONObject());
            }
            this.wC.postDelayed(this.du, this.KM);
        }
    }

    public void KM() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.cyF > 0) {
                jSONObject.put("playable_material_first_frame_show_duration", System.currentTimeMillis() - this.cyF);
            } else {
                jSONObject.put("playable_material_first_frame_show_duration", 0L);
            }
            if (this.nro > 0) {
                jSONObject.put("playable_material_first_frame_load_duration", System.currentTimeMillis() - this.nro);
            } else {
                jSONObject.put("playable_material_first_frame_load_duration", 0L);
            }
            Os("PL_sdk_material_first_frame_show", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void MGA(JSONObject jSONObject) {
        DbA(2, jSONObject != null ? jSONObject.optString("error_msg", "The material directly invokes the exception pocket mask on the client") : "The material directly invokes the exception pocket mask on the client");
    }

    public void VM() {
        DbA dbA;
        this.gHb = System.currentTimeMillis();
        int i = this.DE;
        if ((i == 1 || i == 2) && (dbA = this.Dfc) != null) {
            dbA.eli(System.currentTimeMillis());
        }
    }

    public JSONObject kb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int optInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (optInt == 1) {
            return nlS();
        }
        if (optInt != 2) {
            return optInt != 3 ? jSONObject2 : nn();
        }
        return NU();
    }

    public JSONObject wC(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int optInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (optInt == 1) {
                jSONObject2.put("result", ui.DbA(this.eEH, "android.permission.RECORD_AUDIO"));
            } else {
                if (optInt == 2) {
                    jSONObject2.put("result", ui.DbA(this.eEH, "android.permission.CAMERA"));
                    return jSONObject2;
                }
                if (optInt == 3) {
                    jSONObject2.put("result", ui.eli(this.eEH));
                    return jSONObject2;
                }
            }
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public void wC(String str) {
        this.GMY = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.nro = currentTimeMillis;
            long j = this.qj;
            jSONObject.put("playable_page_show_duration", j != -1 ? currentTimeMillis - j : 0L);
        } catch (Throwable th) {
            kb.eli("PlayablePlugin", "reportUrlLoadStart error", th);
        }
        Os("PL_sdk_html_load_start", jSONObject);
        this.Eh = true;
        this.eu = true;
        if (this.pu) {
            GB();
            this.Eh = false;
            this.eu = false;
        }
        if (this.dV) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                if (ui.eli(this.eEH, ui.nlS)) {
                    stringBuffer.append("Microphone_");
                    stringBuffer2.append("1");
                    if (ui.DbA(this.eEH, "android.permission.RECORD_AUDIO")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ui.eli(this.eEH, ui.du)) {
                    stringBuffer.append("Magetometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ui.eli(this.eEH, ui.aAs)) {
                    stringBuffer.append("Accelerometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ui.eli(this.eEH, ui.FC)) {
                    stringBuffer.append("Gyro_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ui.eli(this.eEH, ui.wC)) {
                    stringBuffer.append("Camera_");
                    stringBuffer2.append("1");
                    if (ui.DbA(this.eEH, "android.permission.CAMERA")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ui.eli(this.eEH, ui.kb)) {
                    stringBuffer.append("Photo");
                    stringBuffer2.append("1");
                    if (ui.eli(this.eEH)) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_available_hardware_name", stringBuffer.toString());
                jSONObject2.put("playable_available_hardware_code", stringBuffer2.toString());
                jSONObject2.put("playable_available_hardware_auth_code", stringBuffer3.toString());
                Os("PL_sdk_hardware_detect", jSONObject2);
                this.dV = false;
            } catch (Throwable th2) {
                kb.eli("PlayablePlugin", "Hardware detect error", th2);
            }
        }
    }

    public void GB() {
        int i;
        int i2 = this.DE;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            if (this.Eh) {
                this.wC.postDelayed(this.FC, this.ujq * 1000);
            }
            if ((this.eu && nlS(this.ND)) || (i = this.DE) == 1 || i == 2) {
                this.wC.postDelayed(this.aAs, this.Ue * 1000);
            }
        }
    }

    public void FC(String str) {
        WebView webView;
        boolean z = this.GMY == -1;
        this.GMY = 2;
        if (!z) {
            this.RY = str;
            JSONObject jSONObject = new JSONObject();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.Cp = currentTimeMillis;
                long j = this.nro;
                jSONObject.put("playable_html_load_start_duration", j != -1 ? currentTimeMillis - j : 0L);
                jSONObject.put("playable_has_show", eU());
            } catch (Throwable th) {
                kb.eli("PlayablePlugin", "reportUrlLoadFinish error", th);
            }
            Os("PL_sdk_html_load_finish", jSONObject);
        }
        this.Eh = false;
        this.wC.removeCallbacks(this.FC);
        try {
            if (this.DE == 0) {
                if (this.aqO && (webView = this.PfW) != null) {
                    this.aqO = false;
                    webView.evaluateJavascript(dZ(), new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.Xb.wC.11
                        @Override // android.webkit.ValueCallback
                        public /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                qj();
            }
        } catch (Throwable th2) {
            kb.eli("PlayablePlugin", "crashMonitor error", th2);
        }
    }

    public void oWW() {
        this.eu = false;
        this.wC.removeCallbacks(this.aAs);
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.nro > 0) {
                jSONObject.put("playable_jssdk_load_success_duration", System.currentTimeMillis() - this.nro);
            } else {
                jSONObject.put("playable_jssdk_load_success_duration", 0L);
            }
            Os("PL_sdk_jssdk_load_success", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void FC(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean optBoolean = jSONObject.optBoolean("success", true);
            if (optBoolean) {
                this.GMY = 3;
                qj();
            } else {
                this.GMY = -2;
            }
            if (optBoolean || !this.CMM) {
                return;
            }
            this.CMM = false;
            this.Eh = false;
            this.eu = false;
            this.wC.removeCallbacks(this.FC);
            this.wC.removeCallbacks(this.aAs);
            eli(4, "CaseRenderFail");
        }
    }

    private void Os(int i, String str) {
        com.bytedance.sdk.openadsdk.Xb.eli eliVar = this.rn;
        if (eliVar != null) {
            eliVar.eli(i, str);
        }
    }

    protected void eli(int i, String str) {
        nro();
        Os(i, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th) {
            kb.eli("PlayablePlugin", "reportRenderFatal error", th);
        }
        Os("PL_sdk_global_faild", jSONObject);
    }

    public void DbA(int i, String str) {
        this.ow = i;
        if (this.Mc == null) {
            this.Mc = new JSONObject();
        }
        try {
            this.Mc.put("playable_stuck_type", i);
            this.Mc.put("playable_stuck_reason", str);
            if (this.eU > 0) {
                this.Mc.put("playable_stuck_duration", System.currentTimeMillis() - this.eU);
            } else {
                this.Mc.put("playable_stuck_duration", 0L);
            }
        } catch (Throwable unused) {
        }
        Os("PL_sdk_page_stuck", this.Mc);
        nro();
        if (this.rn == null || i != 2) {
            return;
        }
        this.Mc = new JSONObject();
    }

    protected void DbA(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ui(str, jSONObject);
    }

    private String Os(String str, String str2) {
        String queryParameter;
        String queryParameter2;
        if (TextUtils.isEmpty(this.qWy) && !TextUtils.isEmpty(this.vb)) {
            Uri parse = Uri.parse(this.vb);
            String host = parse.getHost();
            if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                queryParameter = parse.getQueryParameter("surl");
                queryParameter2 = parse.getQueryParameter("playable_hash");
            } else {
                queryParameter = "";
                queryParameter2 = "";
            }
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme(parse.getScheme()).authority(host).appendQueryParameter("surl", queryParameter);
            if (!TextUtils.isEmpty(queryParameter2)) {
                appendQueryParameter.appendQueryParameter("playable_hash", queryParameter2);
            }
            this.qWy = appendQueryParameter.toString();
        }
        return this.qWy;
    }

    private String aGH(String str, String str2) {
        String format = String.format("rubeex://playable-minigamelite?id=%1s&schema=%2s", str, Uri.encode(str2));
        this.ND = format;
        return format;
    }

    private void FS() {
        String str;
        if (this.XxP == null || (str = this.ND) == null || str.contains("/cid_")) {
            return;
        }
        String optString = this.XxP.optString("cid");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        String host = Uri.parse(this.ND).getHost();
        if (TextUtils.isEmpty(host)) {
            this.ND += "/cid_" + optString;
        } else {
            this.ND = this.ND.replace(host, host + "/cid_" + optString);
        }
    }

    private void ui(String str, JSONObject jSONObject) {
        try {
            int i = this.DE;
            if (i == 0) {
                if (this.rH != eli.LAND_PAGE && !nlS(this.ND)) {
                    FS();
                }
                jSONObject.put("playable_url", this.ND);
            } else {
                if (i != 3 && i != 4) {
                    if (i == 1 || i == 2) {
                        jSONObject.put("playable_url", Os(this.bU, this.GMu));
                    }
                }
                jSONObject.put("playable_url", aGH(this.lkd, this.umh));
            }
            jSONObject.put("playable_render_type", this.DE);
            if (this.rn != null) {
                if (this.DE == 0 && (this.rH != eli.LAND_PAGE || nlS(this.ND))) {
                    this.rn.eli(jSONObject);
                } else if (this.DE != 0) {
                    this.rn.eli(jSONObject);
                }
            }
        } catch (JSONException unused) {
        }
    }

    public void Os(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!this.tGZ && this.ikX > 0) {
                this.tGZ = true;
            }
            if ("PL_sdk_html_load_start".equals(str) || "PL_sdk_html_load_finish".equals(str) || "PL_sdk_html_load_error".equals(str)) {
                jSONObject.put("usecache", this.QxD ? 1 : 0);
            }
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.lYL);
            jSONObject.put("playable_session_id", this.Xb);
            int i = this.DE;
            if (i == 0) {
                if (this.rH != eli.LAND_PAGE && !nlS(this.ND)) {
                    FS();
                }
                jSONObject.put("playable_url", this.ND);
            } else {
                if (i != 3 && i != 4) {
                    if (i == 1 || i == 2) {
                        jSONObject.put("playable_url", Os(this.bU, this.GMu));
                    }
                }
                jSONObject.put("playable_url", aGH(this.lkd, this.umh));
            }
            jSONObject.put("playable_full_url", this.vb);
            jSONObject.put("playable_replay_count", this.WfR);
            jSONObject.put("playable_is_prerender", this.ID);
            jSONObject.put("playable_is_preload", this.tGZ);
            jSONObject.put("playable_render_type", this.DE);
            jSONObject.put("playable_scenes_type", this.rH.ordinal());
            String str2 = "";
            jSONObject.put("playable_gecko_key", TextUtils.isEmpty(this.bU) ? "" : this.bU);
            if (!TextUtils.isEmpty(this.GMu)) {
                str2 = this.GMu;
            }
            jSONObject.put("playable_gecko_channel", str2);
            jSONObject.put("playable_sdk_version", "6.6.0");
            jSONObject.put("playable_minigamelite_id", this.lkd);
            jSONObject.put("playable_minigamelite_schema", this.umh);
            jSONObject.put("playable_is_debug", this.Pf);
            jSONObject.put("playable_retry_count", this.TfR);
            jSONObject.put("playable_enter_from", this.QI);
            jSONObject.put("playable_sequence", this.mm);
            jSONObject.put("playable_current_section", this.oc);
            jSONObject.put("is_playable_finish", this.rQ);
            jSONObject.put("playable_card_session", this.SSo);
            jSONObject.put("playable_video_session", this.Uv);
            jSONObject.put("playable_network_type", aqO());
            jSONObject.put("playable_lynx_version", this.gG);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad_extra_data", jSONObject);
            jSONObject2.put("tag", this.bf);
            jSONObject2.put("nt", 4);
            jSONObject2.put("category", "umeng");
            jSONObject2.put("is_ad_event", "1");
            jSONObject2.put("refer", "playable");
            jSONObject2.put("value", this.XxP.opt("cid"));
            jSONObject2.put("log_extra", this.XxP.opt("log_extra"));
            int i2 = this.DE;
            if (i2 != -1 && i2 != -2) {
                if (this.rn != null) {
                    List<JSONObject> list = this.Daf;
                    if (list != null && !list.isEmpty()) {
                        Iterator<JSONObject> it = this.Daf.iterator();
                        while (it.hasNext()) {
                            JSONObject optJSONObject = it.next().optJSONObject("ad_extra_data");
                            if (optJSONObject != null) {
                                optJSONObject.put("playable_render_type", this.DE);
                                optJSONObject.put("playable_url", this.ND);
                            }
                            this.rn.eli(optJSONObject);
                        }
                        this.Daf.clear();
                    }
                    if (this.DE == 0 && (this.rH != eli.LAND_PAGE || nlS(this.ND))) {
                        this.rn.eli(jSONObject);
                        return;
                    } else {
                        if (this.DE != 0) {
                            this.rn.eli(jSONObject);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.Daf == null) {
                this.Daf = new ArrayList();
            }
            this.Daf.add(jSONObject2);
        } catch (Throwable th) {
            kb.eli("PlayablePlugin", "reportEvent error", th);
        }
    }

    public void aAs(String str) {
        this.wC.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Xb.wC.2
            @Override // java.lang.Runnable
            public void run() {
                wC.nlS(wC.this);
            }
        });
    }

    public void du(String str) {
        this.wC.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Xb.wC.3
            @Override // java.lang.Runnable
            public void run() {
                wC.NU(wC.this);
            }
        });
    }

    public void qj() {
        if (this.ev) {
            this.eU = System.currentTimeMillis();
            if (this.rH == eli.FEED_AWEME) {
                if (this.lYL && this.GMY == 3) {
                    DbA dbA = this.Dfc;
                    if (dbA != null && dbA.DbA()) {
                        jh();
                        return;
                    } else {
                        if (this.Dfc == null) {
                            this.Dfc = new DbA(this, this.KM);
                            jh();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.lYL && this.GMY == 2) {
                DbA dbA2 = this.Dfc;
                if (dbA2 != null && dbA2.DbA()) {
                    jh();
                } else if (this.Dfc == null) {
                    this.Dfc = new DbA(this, this.KM);
                    jh();
                }
            }
        }
    }

    private void jh() {
        Runnable runnable;
        Runnable runnable2;
        this.Dfc.eli(System.currentTimeMillis());
        Handler handler = this.nlS;
        if (handler != null) {
            int i = this.DE;
            if (i == 0 && (runnable2 = this.NU) != null) {
                handler.post(runnable2);
            } else if ((i == 1 || i == 2) && (runnable = this.nn) != null) {
                handler.post(runnable);
            }
            this.Dfc.eli(500);
        }
    }

    public void nro() {
        try {
            DbA dbA = this.Dfc;
            if (dbA != null) {
                dbA.eli();
            }
            Handler handler = this.nlS;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th) {
            new StringBuilder("The stuttering detection has been paused due to a crash.-- ").append(th);
        }
    }

    public void Cp() {
        this.XU = 0;
        this.Kp = 0;
        this.nY = 0.0f;
        this.kEI = 0;
        this.Tju = 0;
        this.yw = 0;
        this.CH = 0;
        this.QMZ = 0;
        this.OJ = 0;
        this.Ib = 0;
        this.XlF = 0;
        this.SjY = 0;
        this.TiA = 0;
    }

    public void cyF() {
        if (this.cvo) {
            return;
        }
        this.cvo = true;
        this.GB = 0L;
        this.dV = true;
        Cp();
        try {
            View view = this.Ca.get();
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.GR);
            }
        } catch (Throwable unused) {
        }
        try {
            this.yKf.DbA();
        } catch (Throwable unused2) {
        }
        try {
            DbA dbA = this.Dfc;
            if (dbA != null) {
                dbA.eli();
                this.Dfc = null;
            }
            Handler handler = this.nlS;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th) {
            new StringBuilder("crash -- ").append(th);
        }
        try {
            if (!TextUtils.isEmpty(this.ND)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_all_times", this.Za);
                jSONObject.put("playable_hit_times", this.ikX);
                int i = this.Za;
                if (i > 0) {
                    jSONObject.put("playable_hit_ratio", this.ikX / (i * 1.0d));
                } else {
                    jSONObject.put("playable_hit_ratio", 0);
                }
                Os("PL_sdk_preload_times", jSONObject);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (!TextUtils.isEmpty(this.ND)) {
                if (this.oWW != -1) {
                    this.VM += System.currentTimeMillis() - this.oWW;
                    this.oWW = -1L;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_user_play_duration", this.VM);
                Os("PL_sdk_user_play_duration", jSONObject2);
            }
        } catch (Throwable unused4) {
        }
        this.Eh = false;
        this.eu = false;
        this.wC.removeCallbacks(this.FC);
        this.wC.removeCallbacks(this.aAs);
        this.wC.removeCallbacksAndMessages(null);
    }

    public void eli(int i, String str, String str2) {
        this.GMY = -1;
        this.RY = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
            jSONObject.put("playable_fail_url", str2);
            jSONObject.put("playable_has_show", eU());
        } catch (Throwable th) {
            kb.eli("PlayablePlugin", "onWebReceivedError error", th);
        }
        Os("PL_sdk_html_load_error", jSONObject);
        if (this.CMM) {
            this.CMM = false;
            this.Eh = false;
            this.eu = false;
            this.wC.removeCallbacks(this.FC);
            this.wC.removeCallbacks(this.aAs);
            eli(1, "ContainerLoadFail");
        }
    }

    public int eU() {
        return (this.qj == -1 || !this.lYL) ? 1 : 2;
    }

    public void eli(boolean z, String str, int i) {
        if (z) {
            this.GMY = -1;
            this.RY = str;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_code", i);
                jSONObject.put("playable_msg", "url load error");
                jSONObject.put("playable_fail_url", str);
                jSONObject.put("playable_has_show", eU());
            } catch (Throwable th) {
                kb.eli("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            Os("PL_sdk_html_load_error", jSONObject);
            if (this.CMM) {
                this.CMM = false;
                this.Eh = false;
                this.eu = false;
                this.wC.removeCallbacks(this.FC);
                this.wC.removeCallbacks(this.aAs);
                eli(1, "ContainerLoadFail");
            }
        }
    }

    public String dZ() {
        return "function playable_callJS(){return \"Android call the JS method is callJS\";}";
    }

    public int SSo() {
        return this.mS;
    }

    public JSONObject aGH(String str, JSONObject jSONObject) {
        System.currentTimeMillis();
        if (kb.eli() && jSONObject != null) {
            jSONObject.toString();
        }
        JSONObject eli2 = this.yKf.eli(str, jSONObject);
        if (kb.eli()) {
            System.currentTimeMillis();
            if (eli2 != null) {
                eli2.toString();
            }
        }
        return eli2;
    }

    public wC ui(boolean z) {
        this.pu = z;
        return this;
    }

    public void MGA(boolean z) {
        this.QxD = z;
    }

    public static wC eli(Context context, WebView webView, Os os, com.bytedance.sdk.openadsdk.Xb.eli eliVar) {
        if (os == null || eliVar == null) {
            return null;
        }
        if (webView == null) {
            return new wC(context, 0, os, eliVar);
        }
        return new wC(context, webView, os, eliVar, eli.LAND_PAGE);
    }
}
