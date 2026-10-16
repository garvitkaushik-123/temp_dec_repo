package com.bytedance.sdk.openadsdk.core.model;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.bytedance.sdk.openadsdk.utils.eU;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.mediationsdk.metadata.a;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ev {
    public static final String DbA = String.join("_", "is", dZ.VM());
    public static final String Os = String.join("_", "is", dZ.VM(), "sample");
    public static final String aGH = String.join("_", dZ.VM(), "strategy");
    protected static int du = 330;
    private String Bnk;
    private String CMM;
    private boolean CSp;
    private boolean Ca;
    private nGm Cp;
    private int DE;
    private String Daf;
    private dV Eh;
    protected long FC;
    private String FS;
    private Dfc FYe;
    private int GB;
    private int GCU;
    private com.bykv.vk.openvk.eli.eli.eli.Os.DbA GMY;
    private int GMu;
    private volatile boolean GR;
    private QX GXP;
    private boolean Gjg;
    private String ILu;
    private String Ib;
    private boolean Jt;
    private JSONObject KUA;
    private Map<String, Object> Kp;
    private eli MQ;
    private int Mc;
    private int Mkx;
    public long NU;
    private String Nvn;
    private String OJ;
    private boolean PfW;
    private wC Pw;
    private int QI;
    private int QMZ;
    private String QX;
    private com.bytedance.sdk.openadsdk.core.aAs.wC.eli QYI;
    private int Spd;
    private gG Sz;
    private NU TfR;
    private JSONObject Tju;
    private int UJ;
    private String Uv;
    private boolean Vy;
    private boolean WO;
    private int XU;
    private com.bytedance.sdk.openadsdk.core.model.eli Xb;
    private nn XlF;
    private int ZLD;
    private String Za;
    private int Zo;
    private int an;
    private String bf;
    private boolean cmk;
    private com.bytedance.sdk.openadsdk.core.du.eli cvo;
    private String cyF;
    private String dM;
    private boolean dV;
    private com.bykv.vk.openvk.eli.eli.eli.Os.DbA eEH;
    private String eU;
    private String ehi;
    private int eu;
    private int ev;
    private com.bytedance.sdk.openadsdk.core.aAs.wC.eli fnE;
    private String gAc;
    private int gG;
    private long gHb;
    private boolean iOb;
    private String iiz;
    private String ikX;
    private String ikx;

    /* renamed from: io, reason: collision with root package name */
    private boolean f982io;
    private JSONObject iuv;
    private String jh;
    private int lYL;
    private bf lkd;
    private kb mA;
    private String mm;
    private ui nGm;
    private String nW;
    private nGm nro;
    private oWW oT;
    private int oWW;
    private String oc;
    private MGA ow;
    private int ox;
    private PAGBannerSize ptH;
    private JSONObject pu;
    private AdSlot qWy;
    private int qj;
    private com.bykv.vk.openvk.eli.eli.eli.Os.DbA rH;
    private String rQ;
    private int rn;
    private Ue sO;
    private int tGZ;
    private String tl;
    private int tpZ;
    private KM umh;
    private int vb;
    private String vsm;
    protected int wC;
    private String wc;
    private boolean yKf;
    private JSONObject yw;
    private VM zr;
    private long aqO = 0;
    protected boolean eli = false;
    protected boolean ui = com.bytedance.sdk.openadsdk.Vy.eli.Os.eli;
    protected int MGA = com.bytedance.sdk.openadsdk.Vy.eli.Os.DbA;
    protected String kb = com.bytedance.sdk.openadsdk.Vy.eli.Os.Os;
    protected int aAs = 0;
    private final List<nGm> ujq = new ArrayList();
    private final List<String> Ue = new ArrayList();
    private final List<FilterWord> KM = new ArrayList();
    private final eU VM = eU.Os();
    public boolean nlS = false;
    private List<String> dZ = new ArrayList();
    private List<String> SSo = new ArrayList();
    private String WfR = "0";
    private String Yw = "";
    private int qyC = 0;
    private int BH = 2;
    private int BDs = -1;
    private int tLO = 0;
    private int HN = 0;
    private int Hm = 1;
    private du XxP = new du();
    private int ND = AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES;
    private int RY = 0;
    private int hg = 1;
    private int QW = 0;
    private int nY = 0;
    private int kEI = 0;
    private int CH = 1;
    private int SjY = 1;
    private float TiA = 100.0f;
    private int ID = 2;
    private int Pf = 1;
    private int bU = 0;
    private int mS = -1;
    private long QxD = -1;
    private int qnB = 0;
    private boolean rfG = false;
    private int Kv = 0;
    private int OPT = 50;
    private int fa = -1;
    private final DbA AD = new DbA();
    private boolean Ww = false;
    private com.bytedance.sdk.openadsdk.Vy.eli.DbA CJ = null;
    protected int nn = -1;
    protected int Dfc = -1;
    private float sIY = -1.0f;

    public static String DbA(Context context, ev evVar) {
        return null;
    }

    public static boolean mm(int i) {
        return i == 44 || i == 43 || i == 30 || i == 40 || i == 41 || i == 39;
    }

    public boolean CQP() {
        return true;
    }

    public int eli() {
        kb tGZ = tGZ();
        if (tGZ != null) {
            return tGZ.eli();
        }
        return -1;
    }

    public ev() {
        com.bytedance.sdk.openadsdk.core.model.eli eliVar = new com.bytedance.sdk.openadsdk.core.model.eli();
        this.Xb = eliVar;
        eliVar.eli(this);
    }

    public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        if (eliVar != null) {
            this.Xb = eliVar;
        }
    }

    public void eli(int i) {
        this.gG = i;
    }

    public int DbA() {
        return this.gG;
    }

    public com.bytedance.sdk.openadsdk.core.model.eli Os() {
        return this.Xb;
    }

    public String aGH() {
        int bBQ = bBQ();
        if (bBQ == 1) {
            return "banner_ad";
        }
        if (bBQ == 3) {
            return "open_ad";
        }
        if (bBQ == 5) {
            return "embeded_ad";
        }
        if (bBQ == 7) {
            return "rewarded_video";
        }
        if (bBQ == 8) {
            return "fullscreen_interstitial_ad";
        }
        return "unknown";
    }

    public boolean ui() {
        int mm = mm();
        return ((dZ() && KM.Os(this) && mm != 43 && mm != 44) || BDs() != 2 || mm == 33 || mm == 5 || mm == 6 || mm == 19 || mm == 12) ? false : true;
    }

    public String MGA() {
        Vy nlS;
        com.bytedance.sdk.openadsdk.core.model.eli Os2 = Os();
        if (Os2 == null || (nlS = Os2.nlS()) == null) {
            return null;
        }
        return nlS.kb();
    }

    public long kb() {
        return this.aqO;
    }

    public void eli(long j) {
        this.aqO = j;
    }

    public static boolean eli(ev evVar, boolean z, boolean z2, boolean z3, boolean z4) {
        if (eli(evVar) || z4 || evVar == null || evVar.nY() == null || TextUtils.isEmpty(evVar.nY().nlS())) {
            return false;
        }
        return Os(evVar) ? z3 : (evVar.nY() == null || evVar.nY().eli() != 1) ? z : z2;
    }

    public static boolean eli(ev evVar) {
        return (evVar == null || evVar.nY() == null || evVar.nY().aGH() != 1) ? false : true;
    }

    public static boolean DbA(ev evVar) {
        return (eli(evVar) || Os(evVar)) ? false : true;
    }

    public static boolean Os(ev evVar) {
        return (evVar == null || evVar.nY() == null || evVar.nY().aGH() != 7 || KM.kb(evVar)) ? false : true;
    }

    public static boolean aGH(ev evVar) {
        return (evVar == null || evVar.nY() == null || evVar.nY().eli() != 1) ? false : true;
    }

    public static boolean ui(ev evVar) {
        if (evVar == null) {
            return false;
        }
        int GR = evVar.GR();
        return evVar.Kv() || GR == 5 || GR == 15 || GR == 50;
    }

    public static boolean MGA(ev evVar) {
        if (evVar == null) {
            return false;
        }
        int GR = evVar.GR();
        return GR == 5 || GR == 15 || GR == 50;
    }

    public static com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli(String str, ev evVar) {
        evVar.jh(0);
        int cK = evVar.cK();
        int i = 3;
        if (cK == 3) {
            i = 4;
        } else if (cK == 7) {
            i = 1;
        } else if (cK == 8) {
            i = 2;
        }
        com.bytedance.sdk.openadsdk.core.nlS.eli.DbA dbA = new com.bytedance.sdk.openadsdk.core.nlS.eli.DbA(str, evVar.AD(), evVar.Ww(), evVar.Sz(), evVar.zr(), i);
        dbA.eli(com.bytedance.sdk.openadsdk.bf.eli.eli("video_error_conf", 0));
        return dbA;
    }

    public static long eli(String str) {
        return wC(Os(str));
    }

    private static long wC(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optLong("uid", 0L);
        }
        return 0L;
    }

    public static double DbA(String str) {
        return FC(Os(str));
    }

    private static double FC(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static JSONObject Os(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.Xb.Os("MaterialMeta", e.getMessage());
            return null;
        }
    }

    public static int aGH(String str) {
        return eli(Os(str));
    }

    public static int eli(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("ut", 0);
        }
        return 0;
    }

    public static String eli(Context context, ev evVar) {
        if (context == null || evVar == null || !((evVar.cK() == 8 || evVar.cK() == 7) && evVar.XxP())) {
            return null;
        }
        String DbA2 = DbA(context, evVar);
        if (TextUtils.isEmpty(DbA2) || com.bytedance.sdk.openadsdk.core.act.eli.eli() != 1) {
            return null;
        }
        return DbA2;
    }

    public static boolean kb(ev evVar) {
        Object obj;
        if (evVar == null) {
            return false;
        }
        try {
            Map<String, Object> FYe = evVar.FYe();
            if (FYe == null || (obj = FYe.get(TTAdConstant.SDK_BIDDING_TYPE)) == null) {
                return false;
            }
            return 2 == Integer.parseInt(obj.toString());
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }

    public String wC() {
        return this.bf;
    }

    public void ui(String str) {
        this.bf = str;
    }

    public String FC() {
        return this.CMM;
    }

    public void MGA(String str) {
        this.CMM = str;
    }

    public int aAs() {
        return this.ev;
    }

    public void DbA(int i) {
        this.ev = i;
    }

    public void eli(boolean z) {
        this.dV = z;
    }

    public boolean du() {
        return this.dV;
    }

    public boolean nlS() {
        return this.Vy;
    }

    public void DbA(boolean z) {
        this.Vy = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ev evVar = (ev) obj;
            if (this.WfR.equals(evVar.umh()) && this.rQ.equals(evVar.eu())) {
                return true;
            }
        }
        return false;
    }

    public void Os(int i) {
        this.aAs = i;
    }

    public int NU() {
        return this.aAs;
    }

    public boolean nn() {
        return this.PfW;
    }

    public void Os(boolean z) {
        this.PfW = z;
    }

    public boolean Dfc() {
        return this.Ca;
    }

    public void aGH(boolean z) {
        this.Ca = z;
    }

    public void ui(boolean z) {
        this.yKf = z;
    }

    public String aqO() {
        return this.nW;
    }

    public void kb(String str) {
        this.nW = str;
    }

    public String dV() {
        return this.wc;
    }

    public void wC(String str) {
        this.wc = str;
    }

    public boolean nGm() {
        return (TextUtils.isEmpty(aqO()) || TextUtils.isEmpty(dV())) ? false : true;
    }

    public bf QX() {
        return this.lkd;
    }

    public void eli(wC wCVar) {
        this.Pw = wCVar;
    }

    public wC Xb() {
        return this.Pw;
    }

    public void eli(bf bfVar) {
        this.lkd = bfVar;
    }

    public void eli(QX qx) {
        this.GXP = qx;
    }

    public QX bf() {
        return this.GXP;
    }

    public boolean CMM() {
        return this.WO;
    }

    public void MGA(boolean z) {
        this.WO = z;
    }

    public void FC(String str) {
        this.Nvn = str;
    }

    public String ev() {
        return this.Nvn;
    }

    public void aAs(String str) {
        this.iiz = str;
    }

    public String Vy() {
        return this.iiz;
    }

    public boolean gG() {
        List<Integer> eli2;
        return (RY() == null || (eli2 = RY().eli()) == null || !eli2.contains(57)) ? false : true;
    }

    public String ujq() {
        return this.vsm;
    }

    public boolean Ue() {
        return this.iOb;
    }

    public com.bytedance.sdk.openadsdk.core.aAs.wC.eli KM() {
        return this.QYI;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.aAs.wC.eli eliVar) {
        this.QYI = eliVar;
        com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.eli().eli(eliVar, "endcard");
    }

    public void DbA(com.bytedance.sdk.openadsdk.core.aAs.wC.eli eliVar) {
        this.fnE = eliVar;
        com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.eli().eli(eliVar, "endcard");
    }

    public com.bytedance.sdk.openadsdk.core.aAs.wC.eli VM() {
        return this.fnE;
    }

    public void aGH(int i) {
        this.Kv = i;
    }

    public int GB() {
        return this.Kv;
    }

    public void oWW() {
        this.CSp = true;
    }

    public boolean qj() {
        return this.CSp;
    }

    public void nro() {
        this.f982io = true;
    }

    public boolean Cp() {
        return this.f982io;
    }

    public int cyF() {
        try {
            JSONObject sIY = sIY();
            if (sIY != null) {
                return sIY.optInt("rec_clk", 0);
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean eU() {
        return this.Jt;
    }

    public void kb(boolean z) {
        this.Jt = z;
    }

    public boolean dZ() {
        return this.cmk;
    }

    public void wC(boolean z) {
        this.cmk = z;
    }

    public void ui(int i) {
        this.OPT = i;
    }

    public int SSo() {
        return this.OPT;
    }

    public String Uv() {
        JSONObject sIY;
        if (this.ikx == null && (sIY = sIY()) != null) {
            this.ikx = sIY.optString("cid", "");
        }
        return this.ikx;
    }

    public void du(String str) {
        this.ehi = str;
    }

    public String FS() {
        return this.ehi;
    }

    public int jh() {
        if (this.fa < 0) {
            try {
                JSONObject sIY = sIY();
                if (sIY != null) {
                    this.fa = sIY.optInt("is_drop_to_retargeting_sample", 0);
                } else {
                    this.fa = 0;
                }
            } catch (Throwable unused) {
                this.fa = 0;
            }
        }
        return this.fa;
    }

    public void MGA(int i) {
        this.Spd = i;
    }

    public boolean Za() {
        if (this.mS <= 0) {
            this.mS = cK();
        }
        int i = this.mS;
        return (i == 7 || i == 8) && !ui(this) && oc() != 21 && this.Spd == 1;
    }

    public void ikX() {
        com.bykv.vk.openvk.eli.eli.eli.Os.DbA dbA = this.GMY;
        if (dbA == null || TextUtils.isEmpty(dbA.nlS())) {
            return;
        }
        try {
            if (this.GMY.nlS().contains("style_id")) {
                this.iOb = true;
                this.vsm = Uri.parse(this.GMY.nlS()).getQueryParameters("style_id").get(0);
            } else {
                this.iOb = false;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os(th.getMessage(), new Object[0]);
        }
    }

    public kb tGZ() {
        return this.mA;
    }

    public void eli(kb kbVar) {
        this.mA = kbVar;
    }

    public int WfR() {
        kb kbVar = this.mA;
        if (kbVar == null) {
            return 2;
        }
        return kbVar.DbA();
    }

    public int ow() {
        if (gG()) {
            return 5;
        }
        if (Jt()) {
            return 4;
        }
        kb kbVar = this.mA;
        if (kbVar == null) {
            return 1;
        }
        return kbVar.Os();
    }

    public long TfR() {
        kb kbVar = this.mA;
        if (kbVar == null) {
            return 0L;
        }
        return kbVar.aGH();
    }

    public KM QI() {
        return this.umh;
    }

    public void eli(KM km) {
        this.umh = km;
    }

    public int mm() {
        return this.oWW;
    }

    public void kb(int i) {
        eli(i, -1);
    }

    public int oc() {
        return this.qj;
    }

    public void wC(int i) {
        this.oWW = i;
    }

    public void eli(int i, int i2) {
        this.qj = i;
        this.oWW = i;
        if (this.qWy == null) {
            this.oWW = 0;
            return;
        }
        if (i2 <= 0) {
            i2 = cK();
        }
        if (this.qWy.getDurationSlotType() == 3 || i2 == 3) {
            this.oWW = 14;
            return;
        }
        if (this.qWy.getDurationSlotType() == 7 || this.qWy.getDurationSlotType() == 8 || i2 == 7 || i2 == 8) {
            if (!this.cmk) {
                if (KM.Os(this)) {
                    this.oWW = 12;
                    return;
                } else if (KM.DbA(this)) {
                    this.oWW = 9;
                    return;
                }
            }
            if (this.qj == 5 && !Xb.aGH(this)) {
                this.oWW = 7;
            }
            if (this.qj == 6 && !Xb.DbA(this)) {
                this.oWW = 7;
            }
            if (this.qj == 8 && HN() != 100) {
                this.oWW = 7;
            }
            if (this.qj == 19 && TextUtils.isEmpty(this.cyF)) {
                this.oWW = 7;
            }
            if (this.qj == 20 && TextUtils.isEmpty(this.cyF)) {
                this.oWW = 7;
            }
            if (this.qj == 38 && !Xb.Os(this)) {
                this.oWW = 7;
            }
            if (i < 5) {
                this.oWW = 7;
                return;
            }
            return;
        }
        if (!this.cmk && KM.DbA(this)) {
            this.oWW = 4;
            return;
        }
        if (this.qj == 4 && !KM.DbA(this)) {
            this.oWW = 0;
        }
        int i3 = this.qj;
        if (i3 == 41) {
            this.oWW = 41;
            return;
        }
        if (i >= 5) {
            this.oWW = 0;
            return;
        }
        if (i3 == 2 && yw() != 3) {
            this.oWW = 0;
        } else if (i == 0 || (i == 1 && yw() != 3)) {
            this.oWW = 0;
        }
    }

    public int rQ() {
        return this.Pf;
    }

    public void eli(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.Pf = 1;
        } else {
            this.Pf = (int) d;
        }
    }

    public int Yw() {
        return this.ID;
    }

    public void DbA(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.ID = 2;
        } else {
            this.ID = (int) d;
        }
    }

    public String qyC() {
        return this.Yw;
    }

    public void nlS(String str) {
        this.Yw = str;
    }

    public int BH() {
        return this.qyC;
    }

    public void FC(int i) {
        this.qyC = i;
    }

    public int BDs() {
        int i = this.oWW;
        if (i == 5 || i == 6 || i == 33) {
            return 1;
        }
        if (nie()) {
            return 2;
        }
        return this.BH;
    }

    public void aAs(int i) {
        this.BDs = i;
    }

    public int tLO() {
        return this.BDs;
    }

    public void du(int i) {
        this.BH = i;
    }

    public int gHb() {
        return this.QW;
    }

    public void nlS(int i) {
        this.QW = i;
    }

    public String Mc() {
        return this.dM;
    }

    public void NU(String str) {
        this.dM = str;
    }

    public boolean DE() {
        return this.QW == 1;
    }

    public int GMY() {
        return this.kEI;
    }

    public void NU(int i) {
        this.kEI = i;
    }

    public int rH() {
        return this.HN;
    }

    public void nn(int i) {
        this.HN = i;
    }

    public int eEH() {
        return this.Hm;
    }

    public void Dfc(int i) {
        this.Hm = i;
    }

    public String PfW() {
        return this.OJ;
    }

    public void nn(String str) {
        this.OJ = str;
    }

    public int Ca() {
        return this.nY;
    }

    public void aqO(int i) {
        this.nY = i;
    }

    public int yKf() {
        return this.hg;
    }

    public void dV(int i) {
        this.hg = i;
    }

    public int rn() {
        if (Kv()) {
            return 5;
        }
        if (Nvn() != 100.0f || BDs() == 2) {
            return 0;
        }
        return this.RY;
    }

    public void nGm(int i) {
        this.RY = i;
    }

    public du Gjg() {
        return this.XxP;
    }

    public void eli(du duVar) {
        this.XxP = duVar;
    }

    public AdSlot XU() {
        return this.qWy;
    }

    public void eli(AdSlot adSlot) {
        this.qWy = adSlot;
    }

    public int Kp() {
        return this.vb;
    }

    public void QX(int i) {
        this.vb = i;
    }

    public int MQ() {
        return this.ND;
    }

    public void Xb(int i) {
        this.ND = i;
    }

    public int gAc() {
        return this.CH;
    }

    public void bf(int i) {
        this.CH = i;
    }

    public int iuv() {
        return this.QMZ;
    }

    public void CMM(int i) {
        this.QMZ = i;
    }

    public int HN() {
        return this.DE;
    }

    public void ev(int i) {
        this.DE = i;
    }

    public String Hm() {
        return this.gAc;
    }

    public void Dfc(String str) {
        this.gAc = str;
    }

    public boolean XxP() {
        return HN() == 100 || this.oWW == 20;
    }

    public int ND() {
        return this.XU;
    }

    public void Vy(int i) {
        this.XU = i;
    }

    public eli RY() {
        return this.MQ;
    }

    public void eli(eli eliVar) {
        this.MQ = eliVar;
        com.bytedance.sdk.component.adexpress.eli.Os.aGH Bnk = Bnk();
        if (Bnk != null && !qWy()) {
            com.bytedance.sdk.component.adexpress.eli.DbA.DbA.eli(Bnk);
        }
        if (eliVar == null || TextUtils.isEmpty(eliVar.NU())) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.eli().eli(Rkl(), "ad");
    }

    public void eli(oWW oww) {
        this.oT = oww;
        if (oww == null || TextUtils.isEmpty(oww.Os())) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.eli().eli(TKE(), "adv3");
    }

    public boolean qWy() {
        eli eliVar = this.MQ;
        if (eliVar != null) {
            return !TextUtils.isEmpty(eliVar.du());
        }
        int i = this.HN;
        return i == 9 || i == 10;
    }

    public void DbA(JSONObject jSONObject) {
        this.KUA = jSONObject;
    }

    public JSONObject vb() {
        return this.KUA;
    }

    public oWW hg() {
        return this.oT;
    }

    private com.bytedance.sdk.openadsdk.core.aAs.wC.eli Rkl() {
        eli RY = RY();
        if (RY == null) {
            return null;
        }
        return eli.DbA(RY, String.valueOf(RTg()));
    }

    private com.bytedance.sdk.openadsdk.core.aAs.wC.eli TKE() {
        oWW hg = hg();
        if (hg == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.aAs.wC.eli().eli(hg.eli()).DbA(hg.DbA()).Os(hg.Os()).aGH(hg.aGH()).ui(RTg() + "_v3");
    }

    public com.bytedance.sdk.component.adexpress.eli.Os.aGH Bnk() {
        eli RY = RY();
        if (RY == null) {
            return null;
        }
        return eli.eli(RY, String.valueOf(RTg()));
    }

    public int QW() {
        nn nnVar = this.XlF;
        if (nnVar == null) {
            return 0;
        }
        return nnVar.eli();
    }

    public com.bykv.vk.openvk.eli.eli.eli.Os.DbA nY() {
        return this.GMY;
    }

    public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.DbA dbA) {
        this.GMY = dbA;
    }

    public void eli(nn nnVar) {
        this.XlF = nnVar;
    }

    public String kEI() {
        return this.mm;
    }

    public void aqO(String str) {
        this.mm = str;
    }

    public void dV(String str) {
        this.ikX = str;
    }

    public String Tju() {
        return this.ikX;
    }

    public int yw() {
        return this.GB;
    }

    public boolean CH() {
        return this.GCU == 1;
    }

    public void gG(int i) {
        this.GCU = i;
    }

    public int QMZ() {
        return this.GCU;
    }

    public void ujq(int i) {
        this.GB = i;
    }

    public boolean OJ() {
        return this.ox == 1;
    }

    public void Ue(int i) {
        this.ox = i;
    }

    public int Ib() {
        return this.ox;
    }

    public void KM(int i) {
        this.UJ = i;
    }

    public int XlF() {
        return this.UJ;
    }

    public nGm SjY() {
        return this.nro;
    }

    public void eli(nGm ngm) {
        eli(ngm, du);
        String cyF = cyF(ngm.eli());
        if (!TextUtils.isEmpty(cyF)) {
            ngm.DbA(cyF);
        }
        this.nro = ngm;
    }

    private String cyF(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return com.bytedance.sdk.component.utils.aqO.eli(str);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("MaterialMeta", "generate icon key error", th.getMessage());
            return null;
        }
    }

    private void eli(nGm ngm, int i) {
        if (ngm != null) {
            try {
                if (TextUtils.isEmpty(ngm.eli())) {
                    return;
                }
                if (ngm.DbA() == 0 && ngm.Os() == 0) {
                    ngm.eli(i);
                    ngm.DbA(i);
                    return;
                }
                if (ngm.DbA() == 0) {
                    if (ngm.Os() > i) {
                        ngm.DbA(i);
                        ngm.eli(i);
                        return;
                    } else {
                        ngm.eli(ngm.Os());
                        return;
                    }
                }
                if (ngm.Os() == 0) {
                    if (ngm.DbA() > i) {
                        ngm.DbA(i);
                        ngm.eli(i);
                        return;
                    } else {
                        ngm.DbA(ngm.DbA());
                        return;
                    }
                }
                if (ngm.DbA() > ngm.Os()) {
                    if (ngm.DbA() > i) {
                        ngm.DbA((int) (i / (ngm.DbA() / ngm.Os())));
                        ngm.eli(i);
                        return;
                    }
                    return;
                }
                if (ngm.Os() > i) {
                    ngm.eli((int) (i * (ngm.DbA() / ngm.Os())));
                    ngm.DbA(i);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public nGm TiA() {
        return this.Cp;
    }

    public void DbA(nGm ngm) {
        this.Cp = ngm;
    }

    public String dM() {
        return this.cyF;
    }

    public void nGm(String str) {
        this.cyF = str;
    }

    public List<nGm> an() {
        return this.ujq;
    }

    public void Os(nGm ngm) {
        this.ujq.add(ngm);
    }

    public String lYL() {
        return this.eU;
    }

    public void QX(String str) {
        this.eU = str;
    }

    public List<String> tpZ() {
        return this.dZ;
    }

    public List<String> ZLD() {
        return this.SSo;
    }

    public List<String> ID() {
        return this.Ue;
    }

    public String Pf() {
        return this.Uv;
    }

    public void Xb(String str) {
        this.Uv = str;
    }

    public String bU() {
        return this.FS;
    }

    public void bf(String str) {
        this.FS = str;
    }

    public String GMu() {
        if (!TextUtils.isEmpty(this.jh)) {
            return this.jh;
        }
        Context eli2 = com.bytedance.sdk.openadsdk.core.dV.eli();
        int yw = yw();
        if (yw != 2 && yw != 3) {
            if (yw == 4) {
                if (eli2 != null) {
                    return com.bytedance.sdk.component.utils.ev.eli(eli2, "tt_video_download_apk");
                }
                return this.jh;
            }
            if (yw != 8) {
                return this.jh;
            }
        }
        if (eli2 != null) {
            return com.bytedance.sdk.component.utils.ev.eli(eli2, "tt_video_mobile_go_detail");
        }
        return this.jh;
    }

    public void CMM(String str) {
        this.jh = str;
    }

    public String lkd() {
        return this.jh;
    }

    public String umh() {
        return this.WfR;
    }

    public void ev(String str) {
        this.WfR = str;
    }

    public String cvo() {
        return this.oc;
    }

    public void Vy(String str) {
        this.oc = str;
    }

    public void gG(String str) {
        this.QX = str;
    }

    public String Daf() {
        return this.QX;
    }

    public MGA pu() {
        return this.ow;
    }

    public void eli(MGA mga) {
        this.ow = mga;
    }

    public NU Eh() {
        return this.TfR;
    }

    public void eli(NU nu) {
        this.TfR = nu;
    }

    public String eu() {
        return this.rQ;
    }

    public void ujq(String str) {
        this.rQ = str;
    }

    public int GR() {
        return this.QI;
    }

    public void VM(int i) {
        this.QI = i;
    }

    public List<FilterWord> mS() {
        return this.KM;
    }

    public void eli(FilterWord filterWord) {
        this.KM.add(filterWord);
    }

    public String QxD() {
        return this.Ib;
    }

    public void Ue(String str) {
        this.Ib = str;
    }

    public long ILu() {
        return this.gHb;
    }

    public void DbA(long j) {
        this.gHb = j;
    }

    public int Mkx() {
        return this.Mc;
    }

    public void GB(int i) {
        this.Mc = i;
    }

    public boolean Zo() {
        return this.Gjg;
    }

    public void FC(boolean z) {
        this.Gjg = z;
    }

    public Map<String, Object> FYe() {
        return this.Kp;
    }

    public void eli(Map<String, Object> map) {
        this.Kp = map;
    }

    public JSONObject nW() {
        return this.Tju;
    }

    public void Os(JSONObject jSONObject) {
        this.Tju = jSONObject;
    }

    public JSONObject wc() {
        return this.yw;
    }

    public void aGH(JSONObject jSONObject) {
        this.yw = jSONObject;
    }

    public String mA() {
        return this.Bnk;
    }

    public void KM(String str) {
        this.Bnk = str;
    }

    public int WO() {
        if (this.SjY != 2) {
            this.SjY = 1;
        }
        return this.SjY;
    }

    public void oWW(int i) {
        this.SjY = i;
    }

    public float Nvn() {
        if (this.TiA <= 0.0f) {
            this.TiA = 100.0f;
        }
        return (this.TiA * 1000.0f) / 1000.0f;
    }

    public void eli(float f) {
        this.TiA = f;
    }

    public boolean qnB() {
        if (this.ujq.isEmpty()) {
            return false;
        }
        if (this.QI == 4 && this.ujq.size() < 3) {
            return false;
        }
        Iterator<nGm> it = this.ujq.iterator();
        while (it.hasNext()) {
            if (!it.next().ui()) {
                return false;
            }
        }
        return true;
    }

    public boolean iiz() {
        return !Kv() && vsm() == 1;
    }

    public int vsm() {
        return this.tLO;
    }

    public void qj(int i) {
        this.tLO = i;
    }

    public void ui(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.GB = 4;
        this.WfR = jSONObject.optString("id");
        this.mm = jSONObject.optString("source");
        MGA mga = new MGA();
        this.ow = mga;
        mga.Os(jSONObject.optString("pkg_name"));
        this.ow.DbA(jSONObject.optString("name"));
        this.ow.eli(jSONObject.optString(DownloadModel.DOWNLOAD_URL));
    }

    public JSONObject iOb() {
        JSONObject aGH2;
        JSONObject aAs;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("raw_response_info", eD());
            jSONObject.put("interaction_type", yw());
            jSONObject.put("iv_skip_time", this.nn);
            jSONObject.put("rv_skip_time", this.Dfc);
            jSONObject.put(Os, QMZ());
            jSONObject.put("interaction_method", oc());
            jSONObject.put("lp_click_type", mWE());
            jSONObject.put("lp_click_interval", aak());
            jSONObject.put("proportion_watching", tLO());
            jSONObject.put(DbA, Ib());
            jSONObject.put(aGH, XlF());
            jSONObject.put("target_url", dM());
            jSONObject.put("app_log_url", cvo());
            jSONObject.put("settings_url", this.QX);
            jSONObject.put("gecko_id", QxD());
            jSONObject.put("extension", ikx());
            jSONObject.put("ad_id", umh());
            jSONObject.put("source", kEI());
            jSONObject.put("app_name", Tju());
            jSONObject.put("screenshot", Zo());
            jSONObject.put("dislike_control", vsm());
            jSONObject.put("play_bar_show_time", MQ());
            jSONObject.put("play_bar_style", rn());
            jSONObject.put("if_block_lp", gHb());
            jSONObject.put("cache_sort", gAc());
            jSONObject.put("if_sp_cache", iuv());
            jSONObject.put("render_control", BDs());
            jSONObject.put("mrc_report", this.eu);
            jSONObject.put("isMrcReportFinish", this.GR);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cta", Yw());
            jSONObject2.put("other", rQ());
            jSONObject.put("set_click_type", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("reward_name", qyC());
            jSONObject3.put("reward_amount", BH());
            jSONObject.put("reward_data", jSONObject3);
            if (!TextUtils.isEmpty(aqO()) && !TextUtils.isEmpty(dV())) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("adchoices_icon", aqO());
                jSONObject4.put("adchoices_url", dV());
                jSONObject.put("dsp_adchoices", jSONObject4);
            }
            nGm SjY = SjY();
            if (SjY != null && !TextUtils.isEmpty(SjY.eli())) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("url", SjY.eli());
                jSONObject5.put("height", SjY.Os());
                jSONObject5.put("width", SjY.DbA());
                jSONObject.put("icon", jSONObject5);
            }
            nGm TiA = TiA();
            if (TiA != null && !TextUtils.isEmpty(TiA.eli())) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("url", TiA.eli());
                jSONObject6.put("height", TiA.Os());
                jSONObject6.put("width", TiA.DbA());
                jSONObject.put("cover_image", jSONObject6);
            }
            JSONObject nW = nW();
            if (nW != null) {
                jSONObject.put("session_params", nW);
            }
            JSONObject wc = wc();
            if (wc != null) {
                jSONObject.put("dynamic_configs", wc);
            }
            du Gjg = Gjg();
            if (Gjg != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("click_upper_content_area", Gjg.eli);
                jSONObject7.put("click_upper_non_content_area", Gjg.DbA);
                jSONObject7.put("click_lower_content_area", Gjg.Os);
                jSONObject7.put("click_lower_non_content_area", Gjg.aGH);
                jSONObject7.put("click_button_area", Gjg.ui);
                jSONObject7.put("click_video_area", Gjg.MGA);
                jSONObject.put("click_area", jSONObject7);
            }
            wC Xb = Xb();
            if (Xb != null) {
                jSONObject.put("arbitrage_interceptor_params", Xb.kb());
            }
            AdSlot XU = XU();
            if (XU != null) {
                jSONObject.put("adslot", XU.toJsonObj());
            }
            eli(this, jSONObject);
            List<String> tpZ = tpZ();
            if (tpZ != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = tpZ.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("show_url", jSONArray);
            }
            List<String> ZLD = ZLD();
            if (ZLD != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it2 = ZLD.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(it2.next());
                }
                jSONObject.put(CampaignEx.JSON_KEY_CLICK_URL, jSONArray2);
            }
            List<String> ID = ID();
            if (ID != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator<String> it3 = ID.iterator();
                while (it3.hasNext()) {
                    jSONArray3.put(it3.next());
                }
                jSONObject.put("play_start", jSONArray3);
            }
            jSONObject.put("phone_num", lYL());
            jSONObject.put("title", Pf());
            jSONObject.put("description", bU());
            jSONObject.put("ext", eu());
            jSONObject.put("image_mode", GR());
            jSONObject.put("cover_click_area", HN());
            jSONObject.put("intercept_flag", Kp());
            jSONObject.put("button_text", GMu());
            jSONObject.put("ad_logo", yKf());
            jSONObject.put("video_adaptation", Ca());
            jSONObject.put("feed_video_opentype", GMY());
            jSONObject.put("orientation", WO());
            jSONObject.put("aspect_ratio", Nvn());
            DbA(this, jSONObject);
            NU Eh = Eh();
            if (Eh != null) {
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("deeplink_url", Eh.eli());
                jSONObject8.put("fallback_url", Eh.DbA());
                jSONObject8.put("fallback_type", Eh.Os());
                jSONObject.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, jSONObject8);
            }
            jSONObject.put("is_web_jump_ip", this.aAs);
            Ue Mn = Mn();
            if (Mn != null && (aAs = Mn.aAs()) != null) {
                jSONObject.put("oem", aAs);
            }
            gG ke = ke();
            if (ke != null && (aGH2 = ke.aGH()) != null) {
                jSONObject.put("multi_ad_scene", aGH2);
            }
            List<FilterWord> mS = mS();
            if (mS != null) {
                JSONArray jSONArray4 = new JSONArray();
                Iterator<FilterWord> it4 = mS.iterator();
                while (it4.hasNext()) {
                    JSONObject DbA2 = DbA(it4.next());
                    if (DbA2 != null) {
                        jSONArray4.put(DbA2);
                    }
                }
                jSONObject.put("filter_words", jSONArray4);
            }
            QI().eli(jSONObject);
            jSONObject.put("count_down", Mkx());
            jSONObject.put("expiration_time", ILu());
            com.bykv.vk.openvk.eli.eli.eli.Os.DbA AD = AD();
            if (AD != null) {
                jSONObject.put("video", AD.nGm());
            }
            com.bykv.vk.openvk.eli.eli.eli.Os.DbA Ww = Ww();
            if (Ww != null) {
                jSONObject.put("h265_video", Ww.nGm());
            }
            jSONObject.put("video_encode_type", zr());
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("if_send_click", QW());
            jSONObject.put("download_conf", jSONObject9);
            if (FYe() != null) {
                JSONObject jSONObject10 = new JSONObject();
                Set<Map.Entry<String, Object>> entrySet = FYe().entrySet();
                if (!entrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : entrySet) {
                        jSONObject10.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject10);
            }
            eli RY = RY();
            if (RY != null) {
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("id", RY.aGH());
                jSONObject11.put("md5", RY.ui());
                jSONObject11.put("url", RY.MGA());
                jSONObject11.put("data", RY.kb());
                jSONObject11.put("diff_data", RY.wC());
                jSONObject11.put("version", RY.Os());
                jSONObject11.put("dynamic_creative", RY.FC());
                jSONObject11.put("engine_version", RY.du());
                jSONObject11.put("ugen_data", RY.Dfc());
                jSONObject11.put("ugen_md5", RY.nn());
                jSONObject11.put("ugen_url", RY.NU());
                jSONObject.put("tpl_info", jSONObject11);
            }
            oWW oww = this.oT;
            if (oww != null) {
                jSONObject.put("tpl_info_v3", oww.kb());
            }
            jSONObject.put("dynamic_creative", vb());
            jSONObject.put("creative_extra", Hm());
            jSONObject.put("market_url", mA());
            jSONObject.put("auction_price", PfW());
            jSONObject.put("ad_info", Mc());
            jSONObject.put("is_package_open", fnE());
            jSONObject.put("playable_duration_time", oT());
            jSONObject.put("playable_endcard_close_time", KUA());
            jSONObject.put("endcard_close_time", rfG());
            JSONObject jSONObject12 = new JSONObject();
            jSONObject12.put("render_sequence", rH());
            jSONObject12.put("backup_render_control", eEH());
            jSONObject12.put("reserve_time", ox());
            jSONObject12.put("render_thread", UJ());
            jSONObject.put("render", jSONObject12);
            if (this.lkd == null) {
                bf bfVar = new bf();
                this.lkd = bfVar;
                bfVar.eli("");
                this.lkd.eli(10L);
                this.lkd.DbA(20L);
                this.lkd.Os(10L);
                this.lkd.aGH(20L);
            }
            JSONObject jSONObject13 = new JSONObject();
            jSONObject13.put("onlylp_loading_maxtime", this.lkd.eli());
            jSONObject13.put("straight_lp_showtime", this.lkd.DbA());
            jSONObject13.put("onlyagg_loading_maxtime", this.lkd.Os());
            jSONObject13.put("straight_agg_showtime", this.lkd.aGH());
            jSONObject13.put("loading_text", this.lkd.ui());
            QX qx = this.GXP;
            if (qx != null) {
                jSONObject13 = qx.eli(jSONObject13);
            }
            new Object[]{"interaction_method_params is:", jSONObject13};
            jSONObject.put("interaction_method_params", jSONObject13);
            JSONObject jSONObject14 = new JSONObject();
            jSONObject14.put("splash_clickarea", WfR());
            jSONObject14.put("splash_layout_id", ow());
            jSONObject14.put("load_wait_time", TfR());
            kb kbVar = this.mA;
            jSONObject14.put("skip_time", kbVar != null ? kbVar.eli() : 0);
            jSONObject.put("splash_control", jSONObject14);
            if (Jt()) {
                jSONObject.put("dsp_html", this.Daf);
            }
            if (Kv()) {
                jSONObject.put("vast_json", this.cvo.aAs());
            }
            jSONObject.put("dsp_material_type", MKR());
            jSONObject.put("deep_link_appname", this.Za);
            jSONObject.put("landing_page_download_clicktype", this.tGZ);
            Dfc dfc = this.FYe;
            if (dfc != null) {
                jSONObject.put("dsp_style", dfc.Os());
            }
            jSONObject.put("identificationOverlayContent", this.iiz);
            if (this.QYI != null) {
                JSONObject jSONObject15 = new JSONObject();
                jSONObject15.put("endcard", this.QYI.eli(this.fnE));
                jSONObject.put("ugen", jSONObject15);
            }
            jSONObject.put("preload_h5_type", GB());
            jSONObject.put("hasReportShow", this.Jt);
            jSONObject.put("endcard_creative", this.ehi);
            jSONObject.put("image_stay", this.Spd);
            jSONObject.put("ad_label", this.AD.MGA());
            JSONObject jSONObject16 = new JSONObject();
            jSONObject16.put(a.j, this.ui);
            jSONObject16.put("wait_time", this.MGA);
            jSONObject16.put("label", this.kb);
            jSONObject.put("ev", jSONObject16);
            jSONObject.put("ad_label", this.AD.MGA());
            if (this.ptH != null) {
                JSONObject jSONObject17 = new JSONObject();
                jSONObject17.put("width", this.ptH.getWidth());
                jSONObject17.put("height", this.ptH.getHeight());
                jSONObject.put("banner", jSONObject17);
            }
            if (!TextUtils.isEmpty(this.Nvn)) {
                jSONObject.put("gdid_encrypted", this.Nvn);
            }
            ui uiVar = this.nGm;
            if (uiVar != null) {
                jSONObject.put("ad_tracks", uiVar.DbA());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public JSONObject QYI() {
        JSONObject iOb = iOb();
        JSONObject dV = com.bytedance.sdk.openadsdk.core.settings.NU.nY().dV(String.valueOf(RTg()));
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(iOb);
            jSONObject.put("creatives", jSONArray);
            jSONObject.put("did", 1);
            jSONObject.put("processing_time_ms", 100);
            jSONObject.put("request_id", "aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");
            jSONObject.put("s_receive_ts", 1);
            jSONObject.put("s_send_ts", 1);
            jSONObject.put("status_code", 20000);
            jSONObject.put("core_settings", dV);
            return jSONObject;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.Xb.Os("MaterialMeta", "toJsonObjPlus", e.getMessage());
            return jSONObject;
        }
    }

    private JSONObject DbA(FilterWord filterWord) {
        if (filterWord == null) {
            return null;
        }
        try {
            if (filterWord.isValid()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", filterWord.getId());
                jSONObject.put("name", filterWord.getName());
                jSONObject.put("is_selected", filterWord.getIsSelected());
                if (filterWord.hasSecondOptions()) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<FilterWord> it = filterWord.getOptions().iterator();
                    while (it.hasNext()) {
                        jSONArray.put(DbA(it.next()));
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("options", jSONArray);
                    }
                }
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public int fnE() {
        return this.an;
    }

    public void nro(int i) {
        this.an = i;
    }

    public int oT() {
        int i = this.lYL;
        if (i > 0) {
            return i;
        }
        return 20;
    }

    public void Cp(int i) {
        this.lYL = i;
    }

    public int KUA() {
        return this.tpZ;
    }

    public void cyF(int i) {
        this.tpZ = i;
    }

    public int rfG() {
        return this.ZLD;
    }

    public void eU(int i) {
        this.ZLD = i;
    }

    public boolean Kv() {
        int i = this.qnB;
        return (i == 1 || i == 3) && io() != null;
    }

    public boolean CSp() {
        return Kv() || this.nGm != null;
    }

    public com.bytedance.sdk.openadsdk.core.du.eli io() {
        return this.cvo;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.du.eli eliVar) {
        this.cvo = eliVar;
    }

    public boolean Jt() {
        return this.qnB == 2;
    }

    public String cmk() {
        return this.Daf;
    }

    public void VM(String str) {
        this.Daf = str;
    }

    public int OPT() {
        JSONObject jSONObject = this.pu;
        if (jSONObject != null) {
            return jSONObject.optInt("easy_playable_skip_duration", 0);
        }
        return 0;
    }

    public JSONObject ikx() {
        return this.pu;
    }

    public void MGA(JSONObject jSONObject) {
        this.pu = jSONObject;
    }

    public void eli(dV dVVar) {
        this.Eh = dVVar;
    }

    public dV ehi() {
        return this.Eh;
    }

    public boolean fa() {
        return this.eu == 1;
    }

    public void dZ(int i) {
        this.eu = i;
    }

    public void Spd() {
        this.GR = true;
    }

    public boolean GCU() {
        return this.GR;
    }

    public int ox() {
        return this.Mkx;
    }

    public void SSo(int i) {
        this.Mkx = Math.max(0, i);
    }

    public int UJ() {
        return this.Zo;
    }

    public void Uv(int i) {
        this.Zo = i;
    }

    public void eli(Dfc dfc) {
        this.FYe = dfc;
    }

    public Dfc Pw() {
        return this.FYe;
    }

    public void FS(int i) {
        this.rn = i;
    }

    public int ptH() {
        return this.rn;
    }

    public com.bytedance.sdk.component.FC.DbA.eli sO() {
        com.bytedance.sdk.component.FC.DbA.eli eliVar = new com.bytedance.sdk.component.FC.DbA.eli();
        eliVar.eli(this.XU);
        eliVar.DbA(this.WfR);
        eliVar.eli(eu());
        return eliVar;
    }

    public int Sz() {
        return this.bU;
    }

    public void jh(int i) {
        this.bU = i;
    }

    public int zr() {
        return this.GMu;
    }

    public void Za(int i) {
        this.GMu = i;
    }

    public com.bykv.vk.openvk.eli.eli.eli.Os.DbA AD() {
        return this.eEH;
    }

    public void DbA(com.bykv.vk.openvk.eli.eli.eli.Os.DbA dbA) {
        this.eEH = dbA;
    }

    public com.bykv.vk.openvk.eli.eli.eli.Os.DbA Ww() {
        return this.rH;
    }

    public void Os(com.bykv.vk.openvk.eli.eli.eli.Os.DbA dbA) {
        this.rH = dbA;
    }

    public String GXP() {
        return this.Za;
    }

    public void GB(String str) {
        this.Za = str;
    }

    public int tl() {
        return this.tGZ;
    }

    public void ikX(int i) {
        this.tGZ = i;
    }

    public boolean CJ() {
        com.bykv.vk.openvk.eli.eli.eli.Os.DbA dbA = this.GMY;
        return dbA == null || dbA.QX() != 1;
    }

    public JSONObject sIY() {
        if (this.iuv == null) {
            try {
                if (!TextUtils.isEmpty(this.rQ)) {
                    this.iuv = new JSONObject(this.rQ);
                }
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.Xb.Os("MaterialMeta", e.getMessage());
            }
        }
        return this.iuv;
    }

    public int cK() {
        if (this.mS < 0) {
            JSONObject sIY = sIY();
            if (sIY != null) {
                this.mS = sIY.optInt("ad_slot_type", 0);
            } else {
                this.mS = 0;
            }
        }
        return this.mS;
    }

    public int bBQ() {
        return this.mS;
    }

    public long jSY() {
        if (this.QxD < 0) {
            JSONObject sIY = sIY();
            if (sIY != null) {
                this.QxD = sIY.optLong("ad_id", 0L);
            } else {
                this.QxD = 0L;
            }
        }
        return this.QxD;
    }

    public boolean fI() {
        return cK() == 3 || cK() == 4;
    }

    public boolean Txb() {
        return cK() == 7;
    }

    public boolean Bno() {
        return cK() == 8;
    }

    public boolean FtK() {
        return cK() == 1;
    }

    public boolean Dg() {
        return cK() == 5;
    }

    public int RTg() {
        JSONObject sIY = sIY();
        if (sIY != null) {
            return sIY.optInt("rit", 0);
        }
        return 0;
    }

    public double QP() {
        return FC(sIY());
    }

    public String oWW(String str) {
        JSONObject sIY = sIY();
        return sIY != null ? sIY.optString("rit", str) : str;
    }

    public String WA() {
        MGA pu = pu();
        if (pu == null || TextUtils.isEmpty(pu.eli())) {
            return null;
        }
        return pu.eli();
    }

    public String fO() {
        JSONObject sIY;
        String str = this.ILu;
        if (TextUtils.isEmpty(str) && (sIY = sIY()) != null) {
            str = sIY.optString("req_id", "");
            qj(str);
        }
        return str == null ? "" : str;
    }

    public void qj(String str) {
        this.ILu = str;
    }

    public boolean nie() {
        return XU() != null && XU().getDurationSlotType() == 8 && Jt();
    }

    public int MKR() {
        return this.qnB;
    }

    public void tGZ(int i) {
        this.qnB = i;
    }

    public boolean MBb() {
        int i = this.oWW;
        return (i == 2 || i == 1) && 3 == this.GB;
    }

    public boolean vOq() {
        Dfc dfc;
        return Kv() && !ip() && (dfc = this.FYe) != null && dfc.eli() == 1;
    }

    public boolean ip() {
        return this.VM.eli > 0;
    }

    public eU nU() {
        return this.VM;
    }

    public void oI() {
        this.VM.ui();
        MGA(false);
    }

    public long apl() {
        return this.NU;
    }

    public void Os(long j) {
        this.NU = j;
    }

    public boolean tEU() {
        return this.nlS;
    }

    public void aAs(boolean z) {
        this.nlS = z;
    }

    public void du(boolean z) {
        this.rfG = z;
    }

    public boolean QmN() {
        return this.rfG;
    }

    public void eli(Ue ue) {
        this.sO = ue;
    }

    public Ue Mn() {
        return this.sO;
    }

    public boolean UUL() {
        return this.eli;
    }

    public void nlS(boolean z) {
        this.eli = z;
    }

    public void eli(PAGBannerSize pAGBannerSize) {
        this.ptH = pAGBannerSize;
    }

    public PAGBannerSize dbH() {
        return this.ptH;
    }

    public String eD() {
        return this.tl;
    }

    public void nro(String str) {
        this.tl = str;
    }

    public void kb(JSONObject jSONObject) {
        this.AD.eli(jSONObject);
    }

    public DbA EM() {
        return this.AD;
    }

    public void NU(boolean z) {
        this.Ww = z;
    }

    public boolean JF() {
        return this.Ww;
    }

    public boolean SE() {
        QX qx;
        if (this.qWy == null || (qx = this.GXP) == null) {
            return false;
        }
        return qx.eli(!TextUtils.isEmpty(r0.getBidAdm()));
    }

    public int mWE() {
        return this.wC;
    }

    public void WfR(int i) {
        this.wC = i;
    }

    public long aak() {
        return this.FC;
    }

    public void aGH(long j) {
        this.FC = j;
    }

    public void eli(gG gGVar) {
        this.Sz = gGVar;
    }

    public gG ke() {
        return this.Sz;
    }

    public int tmf() {
        Map<String, Object> map = this.Kp;
        if (map == null) {
            return 0;
        }
        try {
            Object obj = map.get(TTAdConstant.SDK_BIDDING_TYPE);
            if (obj != null) {
                return Integer.parseInt(obj.toString());
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void nn(boolean z) {
        this.ui = z;
    }

    public boolean VR() {
        return this.ui;
    }

    public void ow(int i) {
        if (i < 0 || i > 30) {
            i = 6;
        }
        this.MGA = i;
    }

    public int RX() {
        return this.MGA;
    }

    public void Cp(String str) {
        if (TextUtils.isEmpty(str)) {
            this.kb = com.bytedance.sdk.openadsdk.Vy.eli.Os.Os;
        } else {
            this.kb = str;
        }
    }

    public String Zor() {
        return this.kb;
    }

    public com.bytedance.sdk.openadsdk.Vy.eli.DbA mV() {
        return this.CJ;
    }

    public void eli(com.bytedance.sdk.openadsdk.Vy.eli.DbA dbA) {
        this.CJ = dbA;
    }

    public int bnh() {
        String valueOf;
        com.bytedance.sdk.openadsdk.core.model.eli Os2 = Os();
        if (Os2 != null && Os2.nlS() != null) {
            return Os2.nlS().FC();
        }
        if (XU() != null) {
            valueOf = XU().getCodeId();
        } else {
            int RTg = RTg();
            valueOf = RTg != 0 ? String.valueOf(RTg) : null;
        }
        if (valueOf != null) {
            return com.bytedance.sdk.openadsdk.core.dV.aGH().nGm(valueOf);
        }
        return 5;
    }

    public int YP() {
        String valueOf;
        com.bytedance.sdk.openadsdk.core.model.eli Os2 = Os();
        if (Os2 != null && Os2.nlS() != null) {
            return Os2.nlS().FC();
        }
        if (XU() != null) {
            valueOf = XU().getCodeId();
        } else {
            int RTg = RTg();
            valueOf = RTg != 0 ? String.valueOf(RTg) : null;
        }
        if (valueOf != null) {
            return com.bytedance.sdk.openadsdk.core.dV.aGH().aAs(valueOf);
        }
        return 30;
    }

    public void TfR(int i) {
        this.nn = i;
    }

    public void QI(int i) {
        this.Dfc = i;
    }

    public int Fxk() {
        int i = this.nn;
        return i >= 0 ? i : com.bytedance.sdk.openadsdk.core.dV.aGH().nGm(String.valueOf(RTg()));
    }

    public int YO() {
        int i = this.Dfc;
        return i >= 0 ? i : com.bytedance.sdk.openadsdk.core.dV.aGH().FC(String.valueOf(RTg()));
    }

    public int fbF() {
        return this.Dfc;
    }

    public List<ev> ro() {
        return this.Xb.aGH();
    }

    public VM CI() {
        return this.zr;
    }

    public void eli(VM vm) {
        this.zr = vm;
    }

    public float akP() {
        float f = this.sIY;
        if (f > 0.0f) {
            return f;
        }
        oWW oww = this.oT;
        if (oww != null) {
            String aGH2 = oww.aGH();
            if (TextUtils.isEmpty(aGH2)) {
                aGH2 = com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.eli().eli("adv3", this.oT.eli(), this.oT.DbA());
            }
            if (aGH2 != null) {
                try {
                    JSONObject optJSONObject = new JSONObject(aGH2).optJSONObject("body");
                    if (optJSONObject != null) {
                        float optDouble = (float) optJSONObject.optDouble("ratio");
                        this.sIY = optDouble;
                        return optDouble;
                    }
                } catch (JSONException unused) {
                }
            }
        }
        this.sIY = 0.0f;
        return 0.0f;
    }

    public void cxQ() {
        if (!TextUtils.isEmpty(PfW())) {
            nn("0");
        }
        Map<String, Object> FYe = FYe();
        if (FYe == null || !FYe.containsKey("price")) {
            return;
        }
        FYe.put("price", "0");
    }

    public void eli(ui uiVar) {
        this.nGm = uiVar;
    }

    public ui XJc() {
        return this.nGm;
    }

    public aGH UCq() {
        aGH nn;
        ui uiVar = this.nGm;
        if (uiVar != null) {
            nn = uiVar.Os();
        } else {
            com.bytedance.sdk.openadsdk.core.du.eli eliVar = this.cvo;
            nn = eliVar != null ? eliVar.nn() : null;
        }
        if (nn != null) {
            nn.eli(this);
        }
        return nn;
    }

    public static class eli {
        private String DbA;
        private String FC;
        private String MGA;
        private String NU;
        private String Os;
        private String aAs;
        private String aGH;
        private String du;
        private String eli;
        private String kb;
        private String nlS;
        private String nn;
        private String ui;
        private List<Integer> wC;

        public static com.bytedance.sdk.component.adexpress.eli.Os.aGH eli(eli eliVar, String str) {
            return com.bytedance.sdk.component.adexpress.eli.Os.aGH.eli().eli(eliVar.aGH()).DbA(eliVar.ui()).Os(eliVar.MGA()).aGH(eliVar.kb()).ui(eliVar.Os()).MGA(str);
        }

        public static com.bytedance.sdk.openadsdk.core.aAs.wC.eli DbA(eli eliVar, String str) {
            return new com.bytedance.sdk.openadsdk.core.aAs.wC.eli().eli(eliVar.aGH()).DbA(eliVar.nn()).Os(eliVar.NU()).aGH(eliVar.Dfc()).ui(str);
        }

        public List<Integer> eli() {
            return this.wC;
        }

        public void eli(List<Integer> list) {
            this.wC = list;
        }

        public String DbA() {
            return this.FC;
        }

        public void eli(String str) {
            this.FC = str;
        }

        public String Os() {
            return this.MGA;
        }

        public void DbA(String str) {
            this.MGA = str;
        }

        public String aGH() {
            return this.eli;
        }

        public void Os(String str) {
            this.eli = str;
        }

        public String ui() {
            return this.DbA;
        }

        public void aGH(String str) {
            this.DbA = str;
        }

        public String MGA() {
            return this.Os;
        }

        public void ui(String str) {
            this.Os = str;
        }

        public String kb() {
            return this.aGH;
        }

        public void MGA(String str) {
            this.aGH = str;
        }

        public String wC() {
            return this.ui;
        }

        public void kb(String str) {
            this.ui = str;
        }

        public String FC() {
            return this.kb;
        }

        public void wC(String str) {
            this.kb = str;
        }

        public String aAs() {
            return this.du;
        }

        public void FC(String str) {
            this.du = str;
        }

        public String du() {
            return this.aAs;
        }

        public void aAs(String str) {
            this.aAs = str;
        }

        public boolean nlS() {
            return !TextUtils.isEmpty(this.aAs) && this.aAs.equals("v3");
        }

        public String NU() {
            return this.nlS;
        }

        public void du(String str) {
            this.nlS = str;
        }

        public String nn() {
            return this.NU;
        }

        public void nlS(String str) {
            this.NU = str;
        }

        public String Dfc() {
            return this.nn;
        }

        public void NU(String str) {
            this.nn = str;
        }
    }

    public static void eli(ev evVar, JSONObject jSONObject) throws JSONException {
        List<nGm> an = evVar.an();
        if (an != null) {
            JSONArray jSONArray = new JSONArray();
            for (nGm ngm : an) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", ngm.eli());
                jSONObject2.put("height", ngm.Os());
                jSONObject2.put("width", ngm.DbA());
                jSONObject2.put("image_preview", ngm.MGA());
                jSONObject2.put("image_key", ngm.kb());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("image", jSONArray);
        }
    }

    public static void DbA(ev evVar, JSONObject jSONObject) throws JSONException {
        MGA pu = evVar.pu();
        if (pu != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_name", pu.DbA());
            jSONObject2.put("package_name", pu.Os());
            jSONObject2.put(DownloadModel.DOWNLOAD_URL, pu.eli());
            jSONObject2.put(FirebaseAnalytics.Param.SCORE, pu.aGH());
            jSONObject2.put("comment_num", pu.ui());
            jSONObject2.put(CampaignEx.JSON_KEY_APP_SIZE, pu.MGA());
            jSONObject2.put("app_category", pu.kb());
            jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, jSONObject2);
        }
    }

    public boolean OI() {
        gG gGVar = this.Sz;
        return gGVar != null && gGVar.eli() == 1;
    }

    public boolean gnF() {
        int i = this.qj;
        return i == 44 || i == 43;
    }
}
