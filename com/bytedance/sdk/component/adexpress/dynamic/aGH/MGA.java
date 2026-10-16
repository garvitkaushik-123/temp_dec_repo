package com.bytedance.sdk.component.adexpress.dynamic.aGH;

import com.ironsource.C3040d4;
import com.ironsource.D5;
import io.ktor.util.date.GMTDateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA {
    private boolean BDs;
    private int BH;
    private int Bnk;
    private int CH;
    private String CMM;
    private boolean Ca;
    private String Cp;
    private int DE;
    private float DbA;
    private String Dfc;
    private float FC;
    private int FS;
    private String GB;
    private int GMY;
    private String GMu;
    private int Gjg;
    private boolean HN;
    private boolean Hm;
    private String ID;
    private String Ib;
    private double KM;
    private int Kp;
    private float MGA;
    private int MQ;
    private int Mc;
    private int ND;
    private String NU;
    private int OJ;
    private float Os;
    private long Pf = -1;
    private String PfW;
    private boolean QI;
    private int QMZ;
    private String QW;
    private String QX;
    private boolean RY;
    private int SSo;
    private boolean SjY;
    private String TfR;
    private String TiA;
    private int Tju;
    private int Ue;
    private int Uv;
    private double VM;
    private String Vy;
    private boolean WfR;
    private List<eli> XU;
    private String Xb;
    private int XlF;
    private boolean XxP;
    private String Yw;
    private String ZLD;
    private int Za;
    private float aAs;
    private float aGH;
    private int an;
    private String aqO;
    private String bU;
    private String bf;
    private boolean cyF;
    private boolean dM;
    private String dV;
    private int dZ;
    private double du;
    private String eEH;
    private int eU;
    private float eli;
    private String ev;
    private int gAc;
    private boolean gG;
    private int gHb;
    private JSONObject hg;
    private boolean ikX;
    private int iuv;
    private double jh;
    private JSONObject kEI;
    private float kb;
    private int lYL;
    private boolean mm;
    private String nGm;
    private boolean nY;
    private double nlS;
    private String nn;
    private String nro;
    private String oWW;
    private boolean oc;
    private int ow;
    private double qWy;
    private String qj;
    private JSONObject qyC;
    private int rH;
    private boolean rQ;
    private int rn;
    private int tGZ;
    private int tLO;
    private int tpZ;
    private boolean ui;
    private int ujq;
    private JSONObject vb;
    private float wC;
    private int yKf;
    private int yw;

    public static MGA eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        MGA mga = new MGA();
        mga.DbA(jSONObject.optString("adType", "embeded"));
        mga.Dfc(jSONObject.optString("clickArea", "creative"));
        mga.aqO(jSONObject.optString("clickTigger", "click"));
        mga.Os(jSONObject.optString("fontFamily", "PingFangSC"));
        mga.aGH(jSONObject.optString("textAlign", "left"));
        mga.ui(jSONObject.optString("color", "#999999"));
        mga.MGA(jSONObject.optString("bgColor", C3040d4.h.T));
        mga.kb(jSONObject.optString("bgImgUrl", ""));
        mga.Ue(jSONObject.optString("bgImgData", ""));
        mga.wC(jSONObject.optString("borderColor", "#000000"));
        mga.FC(jSONObject.optString("borderStyle", "solid"));
        mga.aAs(jSONObject.optString("heightMode", "auto"));
        mga.du(jSONObject.optString("widthMode", "fixed"));
        mga.nlS(jSONObject.optString("interactText", ""));
        mga.Os(jSONObject.optBoolean("isShowBgControl", false));
        mga.NU(jSONObject.optString("interactBgColor", ""));
        JSONObject optJSONObject = jSONObject.optJSONObject("interactPosition");
        if (optJSONObject != null) {
            mga.kb(optJSONObject.optInt("translateY", 0));
            mga.wC(optJSONObject.optInt("translateX", 0));
            mga.aGH(optJSONObject.optDouble("scaleX", 0.0d));
            mga.ui(optJSONObject.optDouble("scaleY", 0.0d));
        }
        mga.nn(jSONObject.optString("interactType", ""));
        mga.ui(jSONObject.optInt("interactSlideDirection", -1));
        mga.dV(jSONObject.optString("justifyHorizontal", "space-around"));
        mga.nGm(jSONObject.optString("justifyVertical", "flex-start"));
        mga.DbA(jSONObject.optDouble("timingStart"));
        mga.Os(jSONObject.optDouble("timingEnd"));
        mga.aGH((float) jSONObject.optDouble("width", 0.0d));
        mga.Os((float) jSONObject.optDouble("height", 0.0d));
        mga.eli((float) jSONObject.optDouble("borderRadius", 0.0d));
        mga.DbA((float) jSONObject.optDouble("borderSize", 0.0d));
        mga.DbA(jSONObject.optBoolean("interactValidate", false));
        mga.FC((float) jSONObject.optDouble("fontSize", 0.0d));
        mga.ui((float) jSONObject.optDouble("paddingBottom", 0.0d));
        mga.MGA((float) jSONObject.optDouble("paddingLeft", 0.0d));
        mga.kb((float) jSONObject.optDouble("paddingRight", 0.0d));
        mga.wC((float) jSONObject.optDouble("paddingTop", 0.0d));
        mga.aGH(jSONObject.optBoolean("lineFeed", false));
        mga.FC(jSONObject.optInt("lineCount", 0));
        mga.MGA(jSONObject.optDouble("lineHeight", 1.2d));
        mga.nn(jSONObject.optInt("letterSpacing", 0));
        mga.ui(jSONObject.optBoolean("isDataFixed", false));
        mga.Dfc(jSONObject.optInt("fontWeight"));
        mga.MGA(jSONObject.optBoolean("lineLimit"));
        mga.aqO(jSONObject.optInt(C3040d4.h.L));
        mga.QX(jSONObject.optString("align"));
        mga.kb(jSONObject.optBoolean("useLeft"));
        mga.wC(jSONObject.optBoolean("useRight"));
        mga.FC(jSONObject.optBoolean("useTop"));
        mga.aAs(jSONObject.optBoolean("useBottom"));
        mga.Xb(jSONObject.optString("data"));
        mga.DbA(jSONObject.optJSONObject("i18n"));
        mga.nlS(jSONObject.optInt("marginLeft"));
        mga.NU(jSONObject.optInt("marginRight"));
        mga.aAs(jSONObject.optInt("marginTop"));
        mga.du(jSONObject.optInt("marginBottom"));
        mga.dV(jSONObject.optInt("tagMaxCount"));
        mga.du(jSONObject.optBoolean("allowTextFlow"));
        mga.nGm(jSONObject.optInt("textFlowType"));
        mga.QX(jSONObject.optInt("textFlowDuration"));
        mga.Xb(jSONObject.optInt("left"));
        mga.bf(jSONObject.optInt("right"));
        mga.CMM(jSONObject.optInt("top"));
        mga.ev(jSONObject.optInt("bottom"));
        mga.bf(jSONObject.optString("alignItems", "flex-start"));
        mga.CMM(jSONObject.optString("direction", ""));
        mga.eli(jSONObject.optBoolean("loop", false));
        mga.Vy(jSONObject.optInt("zIndex"));
        mga.VM(jSONObject.optInt("interactVisibleTime"));
        mga.gG(jSONObject.optInt("interactHiddenTime"));
        mga.NU(jSONObject.optBoolean("interactEnableMask"));
        mga.nn(jSONObject.optBoolean("interactWontHide"));
        mga.eli(jSONObject.optString("bgGradient"));
        mga.oWW(jSONObject.optInt("areaType"));
        mga.qj(jSONObject.optInt("interactSlideThreshold", 0));
        mga.cyF(jSONObject.optInt("interactBottomDistance", com.bytedance.sdk.component.adexpress.aGH.DbA() ? 0 : 120));
        mga.nGm(jSONObject.optBoolean("openPlayableLandingPage", false));
        mga.Os(jSONObject.optJSONObject("video"));
        mga.aGH(jSONObject.optJSONObject("image"));
        mga.nro(jSONObject.optInt("borderShadowExtent"));
        mga.Dfc(jSONObject.optBoolean("bgGauseBlur"));
        mga.Cp(jSONObject.optInt("bgGauseBlurRadius"));
        mga.aqO(jSONObject.optBoolean("showTimeProgress", false));
        mga.dV(jSONObject.optBoolean("showPlayButton", false));
        mga.eli(jSONObject.optDouble("bgColorCg", 0.0d));
        mga.MGA(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        mga.DbA(jSONObject.optInt("borderTopLeftRadius", 0));
        mga.eli(jSONObject.optInt("borderTopRightRadius", 0));
        mga.aGH(jSONObject.optInt("borderBottomLeftRadius", 0));
        mga.Os(jSONObject.optInt("borderBottomRightRadius", 0));
        mga.ui(jSONObject.optJSONObject("interactI18n"));
        mga.Vy(jSONObject.optString("imageObjectFit"));
        mga.gG(jSONObject.optString("interactTitle"));
        mga.GB(jSONObject.optInt("interactTextPositionTop"));
        mga.ev(jSONObject.optString("imageLottieTosPath"));
        mga.nlS(jSONObject.optBoolean("animationsLoop"));
        mga.ujq(jSONObject.optInt("lottieAppNameMaxLength"));
        mga.KM(jSONObject.optInt("lottieAdDescMaxLength"));
        mga.Ue(jSONObject.optInt("lottieAdTitleMaxLength"));
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("animations");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    eli eliVar = new eli();
                    eliVar.Os(jSONObject2.optString("animationType"));
                    eliVar.eli(jSONObject2.optDouble("animationDuration"));
                    eliVar.DbA(jSONObject2.optDouble("animationScaleX"));
                    eliVar.Os(jSONObject2.optDouble("animationScaleY"));
                    eliVar.aGH(jSONObject2.optString("animationTimeFunction"));
                    eliVar.aGH(jSONObject2.optDouble("animationDelay"));
                    eliVar.MGA(jSONObject2.optInt("animationIterationCount"));
                    eliVar.ui(jSONObject2.optString("animationDirection"));
                    eliVar.ui(jSONObject2.optDouble("animationInterval"));
                    eliVar.eli(jSONObject2.optInt("animationBorderWidth"));
                    eliVar.eli(jSONObject2.optLong(C3040d4.h.W));
                    eliVar.DbA(jSONObject2.optInt("animationEffectWidth"));
                    eliVar.Os(jSONObject2.optInt("animationSwing", 1));
                    eliVar.aGH(jSONObject2.optInt("animationTranslateX"));
                    eliVar.ui(jSONObject2.optInt("animationTranslateY"));
                    eliVar.DbA(jSONObject2.optString("animationRippleBackgroundColor"));
                    eliVar.eli(jSONObject2.optString("animationScaleDirection"));
                    eliVar.kb(jSONObject2.optInt("animationFadeStart"));
                    eliVar.wC(jSONObject2.optInt("animationFadeEnd"));
                    eliVar.MGA(jSONObject2.optString("animationFillMode"));
                    eliVar.FC(jSONObject2.optInt("animationBounceHeight"));
                    if (mga.QX() > 0.0d) {
                        eliVar.aGH(eliVar.nn() + mga.QX());
                    }
                    arrayList.add(eliVar);
                }
                mga.eli(arrayList);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                mga.ujq(jSONObject.optString("triggerSlideDirection", "0"));
                mga.eli(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception unused) {
        }
        return mga;
    }

    public boolean eli() {
        return this.Ca;
    }

    public void eli(boolean z) {
        this.Ca = z;
    }

    public int DbA() {
        return this.yw;
    }

    public void eli(int i) {
        this.yw = i;
    }

    public int Os() {
        return this.CH;
    }

    public void DbA(int i) {
        this.CH = i;
    }

    public int aGH() {
        return this.QMZ;
    }

    public void Os(int i) {
        this.QMZ = i;
    }

    public int ui() {
        return this.OJ;
    }

    public void aGH(int i) {
        this.OJ = i;
    }

    public JSONObject MGA() {
        return this.kEI;
    }

    public int kb() {
        return this.Bnk;
    }

    public void ui(int i) {
        this.Bnk = i;
    }

    public double wC() {
        return this.qWy;
    }

    public void eli(double d) {
        this.qWy = d;
    }

    public int FC() {
        return this.Tju;
    }

    public void MGA(int i) {
        this.Tju = i;
    }

    public String aAs() {
        return this.GMu;
    }

    public void eli(String str) {
        this.GMu = str;
    }

    public float du() {
        return this.eli;
    }

    public void eli(float f) {
        this.eli = f;
    }

    public float nlS() {
        return this.DbA;
    }

    public void DbA(float f) {
        this.DbA = f;
    }

    public void Os(float f) {
        this.Os = f;
    }

    public void aGH(float f) {
        this.aGH = f;
    }

    public boolean NU() {
        return this.ui;
    }

    public void DbA(boolean z) {
        this.ui = z;
    }

    public float nn() {
        return this.MGA;
    }

    public void ui(float f) {
        this.MGA = f;
    }

    public float Dfc() {
        return this.kb;
    }

    public void MGA(float f) {
        this.kb = f;
    }

    public float aqO() {
        return this.wC;
    }

    public void kb(float f) {
        this.wC = f;
    }

    public float dV() {
        return this.FC;
    }

    public void wC(float f) {
        this.FC = f;
    }

    public float nGm() {
        return this.aAs;
    }

    public void FC(float f) {
        this.aAs = f;
    }

    public double QX() {
        return this.du;
    }

    public void DbA(double d) {
        this.du = d;
    }

    public double Xb() {
        return this.nlS;
    }

    public void Os(double d) {
        this.nlS = d;
    }

    public void DbA(String str) {
        this.NU = str;
    }

    public void Os(String str) {
        this.nn = str;
    }

    public String bf() {
        return this.Dfc;
    }

    public void aGH(String str) {
        this.Dfc = str;
    }

    public String CMM() {
        return this.aqO;
    }

    public void ui(String str) {
        this.aqO = str;
    }

    public String ev() {
        return this.dV;
    }

    public void MGA(String str) {
        this.dV = str;
    }

    public void kb(String str) {
        this.nGm = str;
    }

    public String Vy() {
        return this.nGm;
    }

    private void Ue(String str) {
        this.bU = str;
    }

    public String gG() {
        return this.bU;
    }

    public String ujq() {
        return this.QX;
    }

    public void wC(String str) {
        this.QX = str;
    }

    public void FC(String str) {
        this.Xb = str;
    }

    public String Ue() {
        return this.bf;
    }

    public void aAs(String str) {
        this.bf = str;
    }

    public String KM() {
        return this.CMM;
    }

    public void du(String str) {
        this.CMM = str;
    }

    public String VM() {
        return this.ev;
    }

    public void nlS(String str) {
        this.ev = str;
    }

    public String GB() {
        return this.Vy;
    }

    public void NU(String str) {
        this.Vy = str;
    }

    public boolean oWW() {
        return this.gG;
    }

    public void Os(boolean z) {
        this.gG = z;
    }

    public int qj() {
        return this.ujq;
    }

    public void kb(int i) {
        this.ujq = i;
    }

    public int nro() {
        return this.Ue;
    }

    public void wC(int i) {
        this.Ue = i;
    }

    public double Cp() {
        return this.KM;
    }

    public void aGH(double d) {
        this.KM = d;
    }

    public double cyF() {
        return this.VM;
    }

    public void ui(double d) {
        this.VM = d;
    }

    public String eU() {
        return this.GB;
    }

    public void nn(String str) {
        this.GB = str;
    }

    public String dZ() {
        return this.oWW;
    }

    public void Dfc(String str) {
        this.oWW = str;
    }

    public String SSo() {
        return this.qj;
    }

    public void aqO(String str) {
        this.qj = str;
    }

    public String Uv() {
        return this.nro;
    }

    public void dV(String str) {
        this.nro = str;
    }

    public String FS() {
        return this.Cp;
    }

    public void nGm(String str) {
        this.Cp = str;
    }

    public boolean jh() {
        return this.cyF;
    }

    public void aGH(boolean z) {
        this.cyF = z;
    }

    public void FC(int i) {
        this.eU = i;
    }

    public int Za() {
        return this.eU;
    }

    public int ikX() {
        return this.dZ;
    }

    public void aAs(int i) {
        this.dZ = i;
    }

    public int tGZ() {
        return this.SSo;
    }

    public void du(int i) {
        this.SSo = i;
    }

    public int WfR() {
        return this.Uv;
    }

    public void nlS(int i) {
        this.Uv = i;
    }

    public int ow() {
        return this.FS;
    }

    public void NU(int i) {
        this.FS = i;
    }

    public double TfR() {
        return this.jh;
    }

    public void MGA(double d) {
        this.jh = d;
    }

    public int QI() {
        return this.Za;
    }

    public void nn(int i) {
        this.Za = i;
    }

    public boolean mm() {
        return this.ikX;
    }

    public void ui(boolean z) {
        this.ikX = z;
    }

    public int oc() {
        return this.tGZ;
    }

    public void Dfc(int i) {
        this.tGZ = i;
    }

    public boolean rQ() {
        return this.WfR;
    }

    public void MGA(boolean z) {
        this.WfR = z;
    }

    public int Yw() {
        return this.ow;
    }

    public void aqO(int i) {
        this.ow = i;
    }

    public String qyC() {
        return this.TfR;
    }

    public void QX(String str) {
        this.TfR = str;
    }

    public boolean BH() {
        return this.QI;
    }

    public void kb(boolean z) {
        this.QI = z;
    }

    public boolean BDs() {
        return this.mm;
    }

    public void wC(boolean z) {
        this.mm = z;
    }

    public boolean tLO() {
        return this.oc;
    }

    public void FC(boolean z) {
        this.oc = z;
    }

    public boolean gHb() {
        return this.rQ;
    }

    public void aAs(boolean z) {
        this.rQ = z;
    }

    public String Mc() {
        return this.Yw;
    }

    public void Xb(String str) {
        this.Yw = str;
    }

    public void DbA(JSONObject jSONObject) {
        this.qyC = jSONObject;
    }

    public JSONObject DE() {
        return this.qyC;
    }

    public int GMY() {
        return this.BH;
    }

    public void dV(int i) {
        this.BH = i;
    }

    public boolean rH() {
        return this.BDs;
    }

    public void du(boolean z) {
        this.BDs = z;
    }

    public int eEH() {
        return this.tLO;
    }

    public void nGm(int i) {
        this.tLO = i;
    }

    public int PfW() {
        return this.gHb;
    }

    public void QX(int i) {
        this.gHb = i;
    }

    public int Ca() {
        return this.Mc;
    }

    public void Xb(int i) {
        this.Mc = i;
    }

    public int yKf() {
        return this.DE;
    }

    public void bf(int i) {
        this.DE = i;
    }

    public int rn() {
        return this.GMY;
    }

    public void CMM(int i) {
        this.GMY = i;
    }

    public int Gjg() {
        return this.rH;
    }

    public void ev(int i) {
        this.rH = i;
    }

    public String XU() {
        return this.eEH;
    }

    public void bf(String str) {
        this.eEH = str;
    }

    public String Kp() {
        return this.PfW;
    }

    public void CMM(String str) {
        this.PfW = str;
    }

    public int MQ() {
        return this.yKf;
    }

    public void Vy(int i) {
        this.yKf = i;
    }

    public int gAc() {
        return this.rn;
    }

    public void gG(int i) {
        this.rn = i;
    }

    public String iuv() {
        return this.TiA;
    }

    public void ev(String str) {
        this.TiA = str;
    }

    public boolean HN() {
        return this.dM;
    }

    public void nlS(boolean z) {
        this.dM = z;
    }

    public int Hm() {
        return this.an;
    }

    public void ujq(int i) {
        this.an = i;
    }

    public int XxP() {
        return this.lYL;
    }

    public void Ue(int i) {
        this.lYL = i;
    }

    public int ND() {
        return this.tpZ;
    }

    public void KM(int i) {
        this.tpZ = i;
    }

    public boolean RY() {
        return this.SjY;
    }

    public void NU(boolean z) {
        this.SjY = z;
    }

    public int qWy() {
        return this.Gjg;
    }

    public void VM(int i) {
        this.Gjg = i;
    }

    public void nn(boolean z) {
        this.nY = z;
    }

    public boolean vb() {
        return this.nY;
    }

    public void Vy(String str) {
        this.Ib = str;
    }

    public String hg() {
        return this.Ib;
    }

    public void GB(int i) {
        this.XlF = i;
    }

    public int Bnk() {
        return this.XlF;
    }

    public List<eli> QW() {
        return this.XU;
    }

    public int nY() {
        List<eli> list = this.XU;
        if (list == null) {
            return 0;
        }
        for (eli eliVar : list) {
            if ("translate".equals(eliVar.FC()) && eliVar.kb() < 0) {
                return -eliVar.kb();
            }
        }
        return 0;
    }

    public void eli(List<eli> list) {
        this.XU = list;
    }

    public int kEI() {
        return this.Kp;
    }

    public void oWW(int i) {
        this.Kp = i;
    }

    public int Tju() {
        return this.MQ;
    }

    public void qj(int i) {
        this.MQ = i;
    }

    public int yw() {
        return this.gAc;
    }

    public void nro(int i) {
        this.gAc = i;
    }

    public boolean CH() {
        return this.HN;
    }

    public void Dfc(boolean z) {
        this.HN = z;
    }

    public int QMZ() {
        return this.iuv;
    }

    public void Cp(int i) {
        this.iuv = i;
    }

    public boolean OJ() {
        return this.Hm;
    }

    public void aqO(boolean z) {
        this.Hm = z;
    }

    public boolean Ib() {
        return this.XxP;
    }

    public void dV(boolean z) {
        this.XxP = z;
    }

    public int XlF() {
        return this.ND;
    }

    public void cyF(int i) {
        this.ND = i;
    }

    public String SjY() {
        return this.QW;
    }

    public boolean TiA() {
        return this.RY;
    }

    public void nGm(boolean z) {
        this.RY = z;
    }

    public void Os(JSONObject jSONObject) {
        this.vb = jSONObject;
    }

    public JSONObject dM() {
        return this.hg;
    }

    public void aGH(JSONObject jSONObject) {
        this.hg = jSONObject;
    }

    public void ui(JSONObject jSONObject) {
        this.kEI = jSONObject;
    }

    public String an() {
        return this.ZLD;
    }

    public void gG(String str) {
        this.ZLD = str;
    }

    public void lYL() {
        eli(this, this.vb);
    }

    public void tpZ() {
        eli(this, this.hg);
    }

    public String ZLD() {
        return this.ID;
    }

    public void ujq(String str) {
        this.ID = str;
    }

    public long ID() {
        return this.Pf;
    }

    public void eli(long j) {
        this.Pf = j;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void eli(MGA mga, JSONObject jSONObject) {
        if (mga == null || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            next.hashCode();
            char c = 65535;
            switch (next.hashCode()) {
                case -2067713583:
                    if (next.equals("isShowBgControl")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1965619659:
                    if (next.equals("clickArea")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1912831834:
                    if (next.equals("triggerSlideDirection")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1885934767:
                    if (next.equals("bgImgUrl")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1822062213:
                    if (next.equals("lineCount")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1821293778:
                    if (next.equals("openPlayableLandingPage")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1813937113:
                    if (next.equals("lineLimit")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1578250488:
                    if (next.equals("interactBgColor")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1501175880:
                    if (next.equals("paddingLeft")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1422965251:
                    if (next.equals("adType")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1383228885:
                    if (next.equals("bottom")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1224696685:
                    if (next.equals("fontFamily")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1221029593:
                    if (next.equals("height")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1065511464:
                    if (next.equals("textAlign")) {
                        c = '\r';
                        break;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        c = 15;
                        break;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        c = 16;
                        break;
                    }
                    break;
                case -1019884910:
                    if (next.equals("useBottom")) {
                        c = 17;
                        break;
                    }
                    break;
                case -1005195314:
                    if (next.equals("triggerSlideMinDistance")) {
                        c = 18;
                        break;
                    }
                    break;
                case -962590849:
                    if (next.equals("direction")) {
                        c = 19;
                        break;
                    }
                    break;
                case -912366651:
                    if (next.equals("tagMaxCount")) {
                        c = 20;
                        break;
                    }
                    break;
                case -848877971:
                    if (next.equals("interactHiddenTime")) {
                        c = 21;
                        break;
                    }
                    break;
                case -836058546:
                    if (next.equals("useTop")) {
                        c = 22;
                        break;
                    }
                    break;
                case -734428249:
                    if (next.equals("fontWeight")) {
                        c = 23;
                        break;
                    }
                    break;
                case -731417480:
                    if (next.equals("zIndex")) {
                        c = 24;
                        break;
                    }
                    break;
                case -709393864:
                    if (next.equals("timingStart")) {
                        c = 25;
                        break;
                    }
                    break;
                case -515807685:
                    if (next.equals("lineHeight")) {
                        c = 26;
                        break;
                    }
                    break;
                case -321658193:
                    if (next.equals("textFlowDuration")) {
                        c = 27;
                        break;
                    }
                    break;
                case -295409451:
                    if (next.equals("useRight")) {
                        c = 28;
                        break;
                    }
                    break;
                case -289173127:
                    if (next.equals("marginBottom")) {
                        c = 29;
                        break;
                    }
                    break;
                case -204859874:
                    if (next.equals("bgColor")) {
                        c = 30;
                        break;
                    }
                    break;
                case -148259282:
                    if (next.equals("useLeft")) {
                        c = 31;
                        break;
                    }
                    break;
                case -51738487:
                    if (next.equals("widthMode")) {
                        c = ' ';
                        break;
                    }
                    break;
                case 115029:
                    if (next.equals("top")) {
                        c = '!';
                        break;
                    }
                    break;
                case 3076010:
                    if (next.equals("data")) {
                        c = '\"';
                        break;
                    }
                    break;
                case 3317767:
                    if (next.equals("left")) {
                        c = '#';
                        break;
                    }
                    break;
                case 3327652:
                    if (next.equals("loop")) {
                        c = Typography.dollar;
                        break;
                    }
                    break;
                case 90130308:
                    if (next.equals("paddingTop")) {
                        c = '%';
                        break;
                    }
                    break;
                case 92903173:
                    if (next.equals("align")) {
                        c = Typography.amp;
                        break;
                    }
                    break;
                case 94842723:
                    if (next.equals("color")) {
                        c = '\'';
                        break;
                    }
                    break;
                case 108511772:
                    if (next.equals("right")) {
                        c = '(';
                        break;
                    }
                    break;
                case 113126854:
                    if (next.equals("width")) {
                        c = ')';
                        break;
                    }
                    break;
                case 164611121:
                    if (next.equals("timingEnd")) {
                        c = GMTDateParser.ANY;
                        break;
                    }
                    break;
                case 202355100:
                    if (next.equals("paddingBottom")) {
                        c = '+';
                        break;
                    }
                    break;
                case 247204452:
                    if (next.equals("allowTextFlow")) {
                        c = AbstractJsonLexerKt.COMMA;
                        break;
                    }
                    break;
                case 302841174:
                    if (next.equals("interactWontHide")) {
                        c = '-';
                        break;
                    }
                    break;
                case 365601008:
                    if (next.equals("fontSize")) {
                        c = '.';
                        break;
                    }
                    break;
                case 428975654:
                    if (next.equals("justifyVertical")) {
                        c = '/';
                        break;
                    }
                    break;
                case 439444041:
                    if (next.equals("interactVisibleTime")) {
                        c = '0';
                        break;
                    }
                    break;
                case 713848971:
                    if (next.equals("paddingRight")) {
                        c = '1';
                        break;
                    }
                    break;
                case 722830999:
                    if (next.equals("borderColor")) {
                        c = '2';
                        break;
                    }
                    break;
                case 737768677:
                    if (next.equals("borderStyle")) {
                        c = '3';
                        break;
                    }
                    break;
                case 747804969:
                    if (next.equals(C3040d4.h.L)) {
                        c = '4';
                        break;
                    }
                    break;
                case 791643104:
                    if (next.equals("isDataFixed")) {
                        c = '5';
                        break;
                    }
                    break;
                case 975087886:
                    if (next.equals("marginRight")) {
                        c = '6';
                        break;
                    }
                    break;
                case 1110826708:
                    if (next.equals("justifyHorizontal")) {
                        c = '7';
                        break;
                    }
                    break;
                case 1122368895:
                    if (next.equals("interactPosition")) {
                        c = '8';
                        break;
                    }
                    break;
                case 1188229042:
                    if (next.equals("lineFeed")) {
                        c = '9';
                        break;
                    }
                    break;
                case 1332036739:
                    if (next.equals("interactText")) {
                        c = AbstractJsonLexerKt.COLON;
                        break;
                    }
                    break;
                case 1332055696:
                    if (next.equals("interactType")) {
                        c = ';';
                        break;
                    }
                    break;
                case 1349188574:
                    if (next.equals("borderRadius")) {
                        c = Typography.less;
                        break;
                    }
                    break;
                case 1360828714:
                    if (next.equals("clickTigger")) {
                        c = D5.T;
                        break;
                    }
                    break;
                case 1490178922:
                    if (next.equals("heightMode")) {
                        c = Typography.greater;
                        break;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        c = '?';
                        break;
                    }
                    break;
                case 1824903757:
                    if (next.equals("borderSize")) {
                        c = '@';
                        break;
                    }
                    break;
                case 1970934485:
                    if (next.equals("marginLeft")) {
                        c = 'A';
                        break;
                    }
                    break;
                case 2111078717:
                    if (next.equals("letterSpacing")) {
                        c = 'B';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    mga.Os(jSONObject.optBoolean(next, false));
                    break;
                case 1:
                    mga.Dfc(jSONObject.optString(next));
                    break;
                case 2:
                    mga.ujq(jSONObject.optString(next));
                    break;
                case 3:
                    mga.kb(jSONObject.optString(next));
                    break;
                case 4:
                    mga.FC(jSONObject.optInt(next));
                    break;
                case 5:
                    mga.nGm(jSONObject.optBoolean(next));
                    break;
                case 6:
                    mga.MGA(jSONObject.optBoolean(next));
                    break;
                case 7:
                    mga.NU(jSONObject.optString(next));
                    break;
                case '\b':
                    mga.MGA((float) jSONObject.optDouble(next));
                    break;
                case '\t':
                    mga.DbA(jSONObject.optString(next));
                    break;
                case '\n':
                    mga.ev(jSONObject.optInt(next));
                    break;
                case 11:
                    mga.Os(jSONObject.optString(next));
                    break;
                case '\f':
                    mga.Os((float) jSONObject.optDouble(next));
                    break;
                case '\r':
                    mga.aGH(jSONObject.optString(next));
                    break;
                case 14:
                    mga.bf(jSONObject.optString(next));
                    break;
                case 15:
                    mga.DbA(jSONObject.optBoolean(next));
                    break;
                case 16:
                    mga.aAs(jSONObject.optInt(next));
                    break;
                case 17:
                    mga.aAs(jSONObject.optBoolean(next));
                    break;
                case 18:
                    mga.eli(jSONObject.optLong(next));
                    break;
                case 19:
                    mga.CMM(jSONObject.optString(next));
                    break;
                case 20:
                    mga.dV(jSONObject.optInt(next));
                    break;
                case 21:
                    mga.gG(jSONObject.optInt(next));
                    break;
                case 22:
                    mga.FC(jSONObject.optBoolean(next));
                    break;
                case 23:
                    mga.Dfc(jSONObject.optInt(next));
                    break;
                case 24:
                    mga.Vy(jSONObject.optInt(next));
                    break;
                case 25:
                    mga.DbA(jSONObject.optDouble(next));
                    break;
                case 26:
                    mga.MGA(jSONObject.optDouble(next));
                    break;
                case 27:
                    mga.QX(jSONObject.optInt(next));
                    break;
                case 28:
                    mga.wC(jSONObject.optBoolean(next));
                    break;
                case 29:
                    mga.du(jSONObject.optInt(next));
                    break;
                case 30:
                    mga.MGA(jSONObject.optString(next));
                    break;
                case 31:
                    mga.kb(jSONObject.optBoolean(next));
                    break;
                case ' ':
                    mga.du(jSONObject.optString(next));
                    break;
                case '!':
                    mga.CMM(jSONObject.optInt(next));
                    break;
                case '\"':
                    mga.Xb(jSONObject.optString(next));
                    break;
                case '#':
                    mga.Xb(jSONObject.optInt(next));
                    break;
                case '$':
                    mga.eli(jSONObject.optBoolean(next));
                    break;
                case '%':
                    mga.wC((float) jSONObject.optDouble(next));
                    break;
                case '&':
                    mga.QX(jSONObject.optString(next));
                    break;
                case '\'':
                    mga.ui(jSONObject.optString(next));
                    break;
                case '(':
                    mga.bf(jSONObject.optInt(next));
                    break;
                case ')':
                    mga.aGH((float) jSONObject.optDouble(next));
                    break;
                case '*':
                    mga.Os(jSONObject.optDouble(next));
                    break;
                case '+':
                    mga.ui((float) jSONObject.optDouble(next));
                    break;
                case ',':
                    mga.du(jSONObject.optBoolean(next));
                    break;
                case '-':
                    mga.nn(jSONObject.optBoolean(next));
                    break;
                case '.':
                    mga.FC((float) jSONObject.optDouble(next));
                    break;
                case '/':
                    mga.nGm(jSONObject.optString(next));
                    break;
                case '0':
                    mga.VM(jSONObject.optInt(next));
                    break;
                case '1':
                    mga.kb((float) jSONObject.optDouble(next));
                    break;
                case '2':
                    mga.wC(jSONObject.optString(next));
                    break;
                case '3':
                    mga.FC(jSONObject.optString(next));
                    break;
                case '4':
                    mga.aqO(jSONObject.optInt(next));
                    break;
                case '5':
                    mga.ui(jSONObject.optBoolean(next));
                    break;
                case '6':
                    mga.NU(jSONObject.optInt(next));
                    break;
                case '7':
                    mga.dV(jSONObject.optString(next));
                    break;
                case '8':
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject == null) {
                        break;
                    } else {
                        mga.kb(optJSONObject.optInt("translateY", 0));
                        mga.wC(optJSONObject.optInt("translateX", 0));
                        mga.aGH(optJSONObject.optDouble("scaleX", 0.0d));
                        mga.ui(optJSONObject.optDouble("scaleY", 0.0d));
                        break;
                    }
                case '9':
                    mga.aGH(jSONObject.optBoolean(next));
                    break;
                case ':':
                    mga.nlS(jSONObject.optString(next));
                    break;
                case ';':
                    mga.nn(jSONObject.optString(next));
                    break;
                case '<':
                    mga.eli((float) jSONObject.optDouble(next));
                    break;
                case '=':
                    mga.aqO(jSONObject.optString(next));
                    break;
                case '>':
                    mga.aAs(jSONObject.optString(next));
                    break;
                case '?':
                    mga.nGm(jSONObject.optInt(next));
                    break;
                case '@':
                    mga.DbA((float) jSONObject.optDouble(next));
                    break;
                case 'A':
                    mga.nlS(jSONObject.optInt(next));
                    break;
                case 'B':
                    mga.nn(jSONObject.optInt(next));
                    break;
            }
        }
    }
}
