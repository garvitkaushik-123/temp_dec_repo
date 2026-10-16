package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.f0;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.out.Frame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BaseCampaignUnit.java */
/* loaded from: classes6.dex */
public abstract class b {
    public static final String JSON_KEY_ADS = "ads";
    public static final String JSON_KEY_AD_HTML = "cam_html";
    public static final String JSON_KEY_AD_TYPE = "ad_type";
    public static final String JSON_KEY_AD_ZIP = "cam_tpl_url";
    public static final String JSON_KEY_BANNER_HTML = "cam_html";
    public static final String JSON_KEY_BANNER_URL = "cam_tpl_url";
    public static final String JSON_KEY_CSP = "csp";
    public static final String JSON_KEY_C_I = "c_i";
    public static final String JSON_KEY_DO = "do";
    public static final String JSON_KEY_ENCRYPT_PRICE = "encrypt_p";
    public static final String JSON_KEY_END_SCREEN_URL = "end_screen_url";
    public static final String JSON_KEY_FRAME_ADS = "frames";
    public static final String JSON_KEY_HTML_URL = "html_url";
    public static final String JSON_KEY_IA_EXT1 = "ia_all_ext1";
    public static final String JSON_KEY_IA_EXT2 = "ia_all_ext2";
    public static final String JSON_KEY_IA_ICON = "ia_icon";
    public static final String JSON_KEY_IA_ORI = "ia_ori";
    public static final String JSON_KEY_IA_RST = "ia_rst";
    public static final String JSON_KEY_IA_URL = "ia_url";
    public static final String JSON_KEY_JM_DO = "jm_do";
    public static final String JSON_KEY_MOF_TEMPLATE_URL = "mof_template_url";
    public static final String JSON_KEY_MOF_TPLID = "mof_tplid";
    public static final String JSON_KEY_NSCPT = "nscpt";
    public static final String JSON_KEY_ONLY_IMPRESSION_URL = "only_impression_url";
    public static final String JSON_KEY_PARENT_SESSION_ID = "parent_session_id";
    public static final String JSON_KEY_PV_URLS = "pv_urls";
    public static final String JSON_KEY_REPLACE_TMP = "replace_tmp";
    public static final String JSON_KEY_REQ_EXT_DATA = "req_ext_data";
    public static final String JSON_KEY_RKS = "rks";
    public static final String JSON_KEY_SECOND_REQUEST_INDEX = "r_index";
    public static final String JSON_KEY_SECOND_SHOW_INDEX = "s_show_index";
    public static final String JSON_KEY_SESSION_ID = "a";
    public static final String JSON_KEY_SH = "sh";
    public static final String JSON_KEY_TEMPLATE = "template";
    public static final String JSON_KEY_TK_TCP_PORT = "tk_tcp_port";
    public static final String JSON_KEY_TOKEN_RULE = "token_r";
    public static final String JSON_KEY_UNIT_SIZE = "unit_size";
    public static final String JSON_KEY_VCN = "vcn";
    public static final String KEY_IRLFA = "irlfa";
    private static final String TAG = "b";
    private String adHtml;
    private int adType;
    private String adZip;
    public ArrayList<CampaignEx> ads;
    private String bannerHtml;
    private String bannerUrl;
    private String csp;
    private String domain;
    private double ecppv;
    private HashMap<String, String> epMap;
    private String htmlUrl;
    private String ia_all_ext1;
    private String ia_all_ext2;
    private String ia_icon;
    private int ia_ori;
    private int ia_rst;
    private String ia_url;
    private int jmDo;
    private List<Frame> listFrames;
    private String localRequestId;
    private com.mbridge.msdk.foundation.same.report.metrics.c metricsData;
    private String onlyImpressionUrl;
    private String parentSessionId;
    private String requestId;
    private HashMap<String, String> rks;
    private String sessionId;
    private String sh;
    private int template;
    private int tokenRule;
    private String unitSize;
    private int vcn;
    protected StringBuffer cParams = new StringBuffer();
    private String encryptPrice = "";
    private String msg = "";
    private int activitySwitch = 1;
    private int secondRequestIndex = 0;
    private int secondShowIndex = 0;

    private static void getSysIDAndBKUPID(JSONObject jSONObject) {
        FastKV fastKV = null;
        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
            try {
                fastKV = new FastKV.Builder(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG), j0.a("H+tU+FeXHM==")).build();
            } catch (Exception unused) {
            }
        }
        if (fastKV != null) {
            try {
                Context d = com.mbridge.msdk.foundation.controller.c.m().d();
                if (jSONObject == null || d == null) {
                    return;
                }
                String optString = jSONObject.optString("b");
                if (!TextUtils.isEmpty(optString) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.V, optString)) {
                    com.mbridge.msdk.foundation.same.a.V = optString;
                    com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("b", com.mbridge.msdk.foundation.same.a.V);
                    try {
                        fastKV.putString(j0.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                    } catch (Exception unused2) {
                    }
                }
                String optString2 = jSONObject.optString("c");
                if (TextUtils.isEmpty(optString2) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.g, optString2)) {
                    return;
                }
                com.mbridge.msdk.foundation.same.a.g = optString2;
                com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c", com.mbridge.msdk.foundation.same.a.g);
                try {
                    fastKV.putString(j0.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.g);
                    return;
                } catch (Exception unused3) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
            if (jSONObject == null || d2 == null) {
                return;
            }
            String optString3 = jSONObject.optString("b");
            if (!TextUtils.isEmpty(optString3) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.V, optString3)) {
                com.mbridge.msdk.foundation.same.a.V = optString3;
                com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("b", com.mbridge.msdk.foundation.same.a.V);
                SharedPreferences sharedPreferences = d2.getSharedPreferences(j0.a("H+tU+FeXHM=="), 0);
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(j0.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                    edit.apply();
                }
            }
            String optString4 = jSONObject.optString("c");
            if (TextUtils.isEmpty(optString4) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.g, optString4)) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.g = optString4;
            com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c", com.mbridge.msdk.foundation.same.a.g);
            SharedPreferences sharedPreferences2 = d2.getSharedPreferences(j0.a("H+tU+FeXHM=="), 0);
            if (sharedPreferences2 != null) {
                SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                edit2.putString(j0.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.g);
                edit2.apply();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject) {
        return parseCampaignUnit(jSONObject, "");
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject) {
        return parseV5CampaignUnit(jSONObject, "");
    }

    public abstract String assembCParams();

    public int getActivitySwitch() {
        return this.activitySwitch;
    }

    public String getAdHtml() {
        return this.adHtml;
    }

    public int getAdType() {
        return this.adType;
    }

    public String getAdZip() {
        return this.adZip;
    }

    public ArrayList<CampaignEx> getAds() {
        return this.ads;
    }

    public String getBannerHtml() {
        return this.bannerHtml;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public String getCsp() {
        return this.csp;
    }

    public String getDomain() {
        return this.domain;
    }

    public double getEcppv() {
        return this.ecppv;
    }

    public String getEncryptPrice() {
        return this.encryptPrice;
    }

    public HashMap<String, String> getEpMap() {
        return this.epMap;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public String getIa_all_ext1() {
        return this.ia_all_ext1;
    }

    public String getIa_all_ext2() {
        return this.ia_all_ext2;
    }

    public String getIa_icon() {
        return this.ia_icon;
    }

    public int getIa_ori() {
        return this.ia_ori;
    }

    public int getIa_rst() {
        return this.ia_rst;
    }

    public String getIa_url() {
        return this.ia_url;
    }

    public int getJmDo() {
        return this.jmDo;
    }

    public List<Frame> getListFrames() {
        return this.listFrames;
    }

    public String getLocalRequestId() {
        return this.localRequestId;
    }

    public com.mbridge.msdk.foundation.same.report.metrics.c getMetricsData() {
        return this.metricsData;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getOnlyImpressionUrl() {
        return this.onlyImpressionUrl;
    }

    public String getParentSessionId() {
        return this.parentSessionId;
    }

    public String getRequestId() {
        try {
            if (!TextUtils.isEmpty(this.requestId)) {
                return this.requestId;
            }
            if (TextUtils.isEmpty(this.onlyImpressionUrl)) {
                return "";
            }
            Uri parse = Uri.parse(this.onlyImpressionUrl);
            if (parse != null) {
                this.requestId = parse.getQueryParameter(CampaignEx.JSON_KEY_AD_K);
            }
            return this.requestId;
        } catch (Exception unused) {
            return "";
        }
    }

    public HashMap<String, String> getRks() {
        return this.rks;
    }

    public int getSecondRequestIndex() {
        return this.secondRequestIndex;
    }

    public int getSecondShowIndex() {
        return this.secondShowIndex;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSh() {
        return this.sh;
    }

    public int getTemplate() {
        return this.template;
    }

    public int getTokenRule() {
        int i = this.tokenRule;
        if (i == 1) {
            return i;
        }
        return 0;
    }

    public String getUnitSize() {
        return this.unitSize;
    }

    public int getVcn() {
        int i = this.vcn;
        if (i > 1) {
            return i;
        }
        return 1;
    }

    protected Object nullToEmpty(Object obj) {
        return obj == null ? "" : obj;
    }

    public void setActivitySwitch(int i) {
        this.activitySwitch = i;
    }

    public void setAdHtml(String str) {
        this.adHtml = str;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public void setAdZip(String str) {
        this.adZip = str;
    }

    public void setAds(ArrayList<CampaignEx> arrayList) {
        this.ads = arrayList;
    }

    public void setBannerHtml(String str) {
        this.bannerHtml = str;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public void setCsp(String str) {
        this.csp = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setEcppv(double d) {
        this.ecppv = d;
    }

    public void setEncryptPrice(String str) {
        this.encryptPrice = str;
    }

    public void setEpMap(HashMap<String, String> hashMap) {
        this.epMap = hashMap;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public void setIa_all_ext1(String str) {
        this.ia_all_ext1 = str;
    }

    public void setIa_all_ext2(String str) {
        this.ia_all_ext2 = str;
    }

    public void setIa_icon(String str) {
        this.ia_icon = str;
    }

    public void setIa_ori(int i) {
        this.ia_ori = i;
    }

    public void setIa_rst(int i) {
        this.ia_rst = i;
    }

    public void setIa_url(String str) {
        this.ia_url = str;
    }

    public void setJmDo(int i) {
        this.jmDo = i;
    }

    public void setListFrames(List<Frame> list) {
        this.listFrames = list;
    }

    public void setLocalRequestId(String str) {
        this.localRequestId = str;
        Iterator<CampaignEx> it = getAds().iterator();
        while (it.hasNext()) {
            it.next().setLocalRequestId(str);
        }
    }

    public void setMetricsData(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        this.metricsData = cVar;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setOnlyImpressionUrl(String str) {
        this.onlyImpressionUrl = str;
    }

    public void setParentSessionId(String str) {
        this.parentSessionId = str;
    }

    public void setRks(HashMap<String, String> hashMap) {
        this.rks = hashMap;
    }

    public void setSecondRequestIndex(int i) {
        this.secondRequestIndex = i;
    }

    public void setSecondShowIndex(int i) {
        this.secondShowIndex = i;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSh(String str) {
        this.sh = str;
    }

    public void setTemplate(int i) {
        this.template = i;
    }

    public void setTokenRule(int i) {
        this.tokenRule = i;
    }

    public void setUnitSize(String str) {
        this.unitSize = str;
    }

    public void setVcn(int i) {
        this.vcn = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v36, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v37 */
    /* JADX WARN: Type inference failed for: r13v38 */
    /* JADX WARN: Type inference failed for: r13v39, types: [com.mbridge.msdk.foundation.entity.b] */
    /* JADX WARN: Type inference failed for: r13v40 */
    /* JADX WARN: Type inference failed for: r13v44 */
    /* JADX WARN: Type inference failed for: r13v45, types: [com.mbridge.msdk.foundation.entity.b] */
    /* JADX WARN: Type inference failed for: r13v57 */
    /* JADX WARN: Type inference failed for: r13v58 */
    /* JADX WARN: Type inference failed for: r15v8, types: [com.mbridge.msdk.foundation.tools.f0] */
    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject, String str) {
        CampaignUnit campaignUnit;
        int i;
        String str2;
        int i2;
        ArrayList arrayList;
        String str3;
        int i3;
        String str4 = JSON_KEY_ADS;
        String str5 = "a";
        String str6 = CampaignEx.JSON_KEY_ECPPV;
        String str7 = JSON_KEY_ONLY_IMPRESSION_URL;
        String str8 = JSON_KEY_HTML_URL;
        if (jSONObject != null) {
            try {
                CampaignUnit campaignUnit2 = new CampaignUnit();
                try {
                    String optString = jSONObject.optString(JSON_KEY_RKS);
                    if (!TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject2 = new JSONObject(optString);
                        Iterator<String> keys = jSONObject2.keys();
                        HashMap<String, String> hashMap = new HashMap<>();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, jSONObject2.optString(next));
                        }
                        campaignUnit2.setRks(hashMap);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        hashMap2.put("encrypt_p", "");
                        hashMap2.put(KEY_IRLFA, "");
                        campaignUnit2.setEpMap(hashMap2);
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(JSON_KEY_REQ_EXT_DATA);
                    int optInt = jSONObject.optInt(JSON_KEY_NSCPT, 1);
                    String optString2 = jSONObject.optString(JSON_KEY_MOF_TEMPLATE_URL, "");
                    int optInt2 = jSONObject.optInt(JSON_KEY_MOF_TPLID, 0);
                    String jSONObject3 = optJSONObject != null ? optJSONObject.toString() : "";
                    new JSONArray();
                    JSONArray optJSONArray = jSONObject.optJSONArray("pv_urls");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        i = optInt2;
                        str2 = "";
                        i2 = optInt;
                        arrayList = null;
                    } else {
                        i2 = optInt;
                        i = optInt2;
                        ArrayList arrayList2 = new ArrayList(optJSONArray.length());
                        str2 = "";
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            arrayList2.add(optJSONArray.getString(i4));
                        }
                        arrayList = arrayList2;
                    }
                    com.mbridge.msdk.foundation.db.middle.b.a().a(jSONObject.optJSONObject(JSON_KEY_REPLACE_TMP), true);
                    getSysIDAndBKUPID(jSONObject);
                    campaignUnit2.setSessionId(jSONObject.optString("a"));
                    campaignUnit2.setParentSessionId(jSONObject.optString(JSON_KEY_PARENT_SESSION_ID));
                    campaignUnit2.setAdType(jSONObject.optInt("ad_type"));
                    campaignUnit2.setUnitSize(jSONObject.optString(JSON_KEY_UNIT_SIZE));
                    campaignUnit2.setHtmlUrl(jSONObject.optString(JSON_KEY_HTML_URL));
                    campaignUnit2.setOnlyImpressionUrl(jSONObject.optString(JSON_KEY_ONLY_IMPRESSION_URL));
                    campaignUnit2.setActivitySwitch(jSONObject.optInt(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH));
                    campaignUnit2.setEcppv(jSONObject.optDouble(CampaignEx.JSON_KEY_ECPPV));
                    campaignUnit2.setTemplate(jSONObject.optInt("template"));
                    campaignUnit2.setJmDo(jSONObject.optInt(JSON_KEY_JM_DO));
                    campaignUnit2.setIa_icon(jSONObject.optString("ia_icon"));
                    campaignUnit2.setIa_rst(jSONObject.optInt("ia_rst"));
                    campaignUnit2.setIa_url(jSONObject.optString("ia_url"));
                    campaignUnit2.setIa_ori(jSONObject.optInt("ia_ori"));
                    campaignUnit2.setIa_all_ext1(jSONObject.optString(JSON_KEY_IA_EXT1));
                    campaignUnit2.setIa_all_ext2(jSONObject.optString(JSON_KEY_IA_EXT2));
                    campaignUnit2.setVcn(jSONObject.optInt("vcn"));
                    campaignUnit2.setTokenRule(jSONObject.optInt("token_r"));
                    campaignUnit2.setEncryptPrice(jSONObject.optString("encrypt_p"));
                    campaignUnit2.setSecondRequestIndex(jSONObject.optInt("r_index", 0));
                    campaignUnit2.setSecondShowIndex(jSONObject.optInt("s_show_index", 0));
                    JSONArray optJSONArray2 = jSONObject.optJSONArray(JSON_KEY_ADS);
                    JSONArray optJSONArray3 = jSONObject.optJSONArray(JSON_KEY_FRAME_ADS);
                    campaignUnit = jSONObject.optString(JSON_KEY_C_I, str2);
                    f0.a().a(campaignUnit);
                    String str9 = "web env is not support";
                    String str10 = JSON_KEY_END_SCREEN_URL;
                    try {
                        try {
                            if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                                String str11 = CampaignEx.JSON_KEY_ECPPV;
                                String str12 = JSON_KEY_ONLY_IMPRESSION_URL;
                                String str13 = JSON_KEY_HTML_URL;
                                String str14 = JSON_KEY_END_SCREEN_URL;
                                String str15 = jSONObject3;
                                int i5 = i2;
                                int i6 = i;
                                campaignUnit = campaignUnit2;
                                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                    ArrayList arrayList3 = new ArrayList();
                                    int i7 = 0;
                                    campaignUnit = campaignUnit;
                                    while (i7 < optJSONArray2.length()) {
                                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i7);
                                        JSONArray jSONArray = optJSONArray2;
                                        String str16 = str12;
                                        String optString3 = jSONObject.optString(str16);
                                        CampaignUnit campaignUnit3 = campaignUnit;
                                        String str17 = str15;
                                        String str18 = str13;
                                        try {
                                            String optString4 = jSONObject.optString(str18);
                                            int i8 = i6;
                                            str13 = str18;
                                            String str19 = str14;
                                            String optString5 = jSONObject.optString(str19);
                                            String str20 = str11;
                                            str11 = str20;
                                            int i9 = i7;
                                            ?? parseCampaign = CampaignEx.parseCampaign(optJSONObject2, optString3, optString4, optString5, false, campaignUnit3, str, jSONObject.optString(str20));
                                            CampaignUnit campaignUnit4 = campaignUnit3;
                                            if (parseCampaign != 0) {
                                                parseCampaign.setNetAddress(campaignUnit);
                                                parseCampaign.setMof_tplid(i8);
                                                parseCampaign.setMof_template_url(optString2);
                                                parseCampaign.setNscpt(i5);
                                                parseCampaign.setPv_urls(arrayList);
                                                parseCampaign.setReq_ext_data(str17);
                                                parseCampaign.setVcn(campaignUnit4.getVcn());
                                                parseCampaign.setTokenRule(campaignUnit4.getTokenRule());
                                                parseCampaign.setEncryptPrice(campaignUnit4.getEncryptPrice());
                                                parseCampaign.setAc_s(jSONObject.optInt(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH, 1));
                                                arrayList3.add(parseCampaign);
                                            } else {
                                                campaignUnit4.setMsg(str9);
                                            }
                                            str15 = str17;
                                            str12 = str16;
                                            i6 = i8;
                                            i7 = i9 + 1;
                                            optJSONArray2 = jSONArray;
                                            str14 = str19;
                                            campaignUnit = campaignUnit4;
                                        } catch (Exception unused) {
                                            campaignUnit = campaignUnit3;
                                        }
                                    }
                                    campaignUnit.setAds(arrayList3);
                                }
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                String str21 = "template";
                                CampaignUnit campaignUnit5 = campaignUnit2;
                                int i10 = 0;
                                String str22 = campaignUnit;
                                while (i10 < optJSONArray3.length()) {
                                    try {
                                        JSONObject optJSONObject3 = optJSONArray3.optJSONObject(i10);
                                        int i11 = i10;
                                        JSONArray jSONArray2 = optJSONObject3.getJSONArray(str4);
                                        String str23 = str4;
                                        ArrayList arrayList5 = new ArrayList();
                                        String str24 = str5;
                                        JSONObject jSONObject4 = optJSONObject3;
                                        int i12 = 0;
                                        String str25 = str22;
                                        while (i12 < jSONArray2.length()) {
                                            JSONObject optJSONObject4 = jSONArray2.optJSONObject(i12);
                                            ArrayList arrayList6 = arrayList4;
                                            String optString6 = jSONObject.optString(str7);
                                            String str26 = str25;
                                            String optString7 = jSONObject.optString(str8);
                                            JSONArray jSONArray3 = optJSONArray3;
                                            String str27 = str10;
                                            String str28 = optString2;
                                            JSONArray jSONArray4 = jSONArray2;
                                            int i13 = i2;
                                            int i14 = i12;
                                            JSONObject jSONObject5 = jSONObject4;
                                            String str29 = str8;
                                            String str30 = str9;
                                            CampaignUnit campaignUnit6 = campaignUnit5;
                                            String str31 = str6;
                                            String str32 = str7;
                                            CampaignEx parseCampaign2 = CampaignEx.parseCampaign(optJSONObject4, optString6, optString7, jSONObject.optString(str10), false, campaignUnit6, str, jSONObject.optString(str6));
                                            if (parseCampaign2 != null) {
                                                parseCampaign2.setNetAddress(str26);
                                                parseCampaign2.setKeyIaUrl(campaignUnit6.getIa_url());
                                                parseCampaign2.setKeyIaOri(campaignUnit6.getIa_ori());
                                                parseCampaign2.setKeyIaRst(campaignUnit6.getIa_rst());
                                                parseCampaign2.setKeyIaIcon(campaignUnit6.getIa_icon());
                                                parseCampaign2.setAdType(jSONObject.optInt("ad_type"));
                                                parseCampaign2.setIa_ext1(jSONObject.optString(CampaignEx.KEY_IA_EXT1));
                                                parseCampaign2.setIa_ext2(jSONObject.optString(CampaignEx.KEY_IA_EXT2));
                                                parseCampaign2.setAc_s(jSONObject.optInt(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH, 1));
                                                parseCampaign2.setVcn(campaignUnit6.getVcn());
                                                parseCampaign2.setTokenRule(campaignUnit6.getTokenRule());
                                                parseCampaign2.setEncryptPrice(campaignUnit6.getEncryptPrice());
                                                i3 = i;
                                                parseCampaign2.setMof_tplid(i3);
                                                parseCampaign2.setMof_template_url(str28);
                                                parseCampaign2.setNscpt(i13);
                                                parseCampaign2.setPv_urls(arrayList);
                                                str3 = jSONObject3;
                                                parseCampaign2.setReq_ext_data(str3);
                                                arrayList5.add(parseCampaign2);
                                            } else {
                                                str3 = jSONObject3;
                                                i3 = i;
                                                campaignUnit6.setMsg(str30);
                                            }
                                            int i15 = i14 + 1;
                                            str25 = str26;
                                            str6 = str31;
                                            campaignUnit5 = campaignUnit6;
                                            i2 = i13;
                                            str9 = str30;
                                            i = i3;
                                            jSONObject3 = str3;
                                            jSONArray2 = jSONArray4;
                                            str8 = str29;
                                            str7 = str32;
                                            arrayList4 = arrayList6;
                                            optJSONArray3 = jSONArray3;
                                            jSONObject4 = jSONObject5;
                                            str10 = str27;
                                            optString2 = str28;
                                            i12 = i15;
                                        }
                                        String str33 = str7;
                                        ArrayList arrayList7 = arrayList4;
                                        Frame frame = new Frame();
                                        frame.setParentSessionId(jSONObject.optString(JSON_KEY_PARENT_SESSION_ID));
                                        frame.setSessionId(jSONObject.optString(str24));
                                        frame.setCampaigns(arrayList5);
                                        String str34 = str21;
                                        frame.setTemplate(jSONObject4.optInt(str34));
                                        arrayList7.add(frame);
                                        str22 = str25;
                                        str6 = str6;
                                        campaignUnit5 = campaignUnit5;
                                        i2 = i2;
                                        optString2 = optString2;
                                        str21 = str34;
                                        str9 = str9;
                                        i10 = i11 + 1;
                                        str5 = str24;
                                        i = i;
                                        jSONObject3 = jSONObject3;
                                        str8 = str8;
                                        str7 = str33;
                                        optJSONArray3 = optJSONArray3;
                                        str10 = str10;
                                        arrayList4 = arrayList7;
                                        str4 = str23;
                                    } catch (Exception unused2) {
                                        campaignUnit = campaignUnit5;
                                    }
                                }
                                campaignUnit = campaignUnit5;
                                campaignUnit.setListFrames(arrayList4);
                            }
                        } catch (Exception unused3) {
                            campaignUnit = str9;
                        }
                    } catch (Exception unused4) {
                    }
                } catch (Exception unused5) {
                    campaignUnit = campaignUnit2;
                }
                return campaignUnit;
            } catch (Exception unused6) {
            }
        }
        return null;
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject, String str) {
        return parseCampaignUnit(jSONObject, str);
    }
}
