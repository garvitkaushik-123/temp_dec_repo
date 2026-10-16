package com.ironsource.mediationsdk.impressionData;

import com.ironsource.C3260q4;
import com.ironsource.mediationsdk.logger.IronLog;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes6.dex */
public class ImpressionData {
    public static final String IMPRESSION_DATA_KEY_ABTEST = "ab";
    public static final String IMPRESSION_DATA_KEY_AD_FORMAT = "adFormat";
    public static final String IMPRESSION_DATA_KEY_AD_NETWORK = "adNetwork";
    public static final String IMPRESSION_DATA_KEY_AD_UNIT = "adUnit";
    public static final String IMPRESSION_DATA_KEY_AUCTION_ID = "auctionId";
    public static final String IMPRESSION_DATA_KEY_COUNTRY = "country";
    public static final String IMPRESSION_DATA_KEY_CREATIVE_ID = "creativeId";
    public static final String IMPRESSION_DATA_KEY_ENCRYPTED_CPM = "encryptedCPM";
    public static final String IMPRESSION_DATA_KEY_INSTANCE_ID = "instanceId";
    public static final String IMPRESSION_DATA_KEY_INSTANCE_NAME = "instanceName";
    public static final String IMPRESSION_DATA_KEY_LIFETIME_REVENUE = "lifetimeRevenue";
    public static final String IMPRESSION_DATA_KEY_MEDIATION_AD_UNIT_ID = "mediationAdUnitId";
    public static final String IMPRESSION_DATA_KEY_MEDIATION_AD_UNIT_NAME = "mediationAdUnitName";
    public static final String IMPRESSION_DATA_KEY_PLACEMENT = "placement";
    public static final String IMPRESSION_DATA_KEY_PRECISION = "precision";
    public static final String IMPRESSION_DATA_KEY_REVENUE = "revenue";
    public static final String IMPRESSION_DATA_KEY_SEGMENT_NAME = "segmentName";

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f3536a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private Double n;
    private String o;
    private Double p;
    private String q;
    private String r;
    private DecimalFormat s = new DecimalFormat("#.#####");

    public ImpressionData(JSONObject jSONObject) {
        Double d = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        if (jSONObject != null) {
            try {
                this.f3536a = jSONObject;
                this.b = jSONObject.optString("auctionId", null);
                this.c = jSONObject.optString("adUnit", null);
                this.d = jSONObject.optString("mediationAdUnitName", null);
                this.e = jSONObject.optString("mediationAdUnitId", null);
                this.f = jSONObject.optString("adFormat", null);
                this.g = jSONObject.optString("country", null);
                this.h = jSONObject.optString("ab", null);
                this.i = jSONObject.optString("segmentName", null);
                this.j = jSONObject.optString("placement", null);
                this.k = jSONObject.optString("adNetwork", null);
                this.l = jSONObject.optString("instanceName", null);
                this.m = jSONObject.optString("instanceId", null);
                this.o = jSONObject.optString("precision", null);
                this.q = jSONObject.optString("encryptedCPM", null);
                this.r = jSONObject.optString("creativeId", null);
                double optDouble = jSONObject.optDouble(IMPRESSION_DATA_KEY_LIFETIME_REVENUE);
                this.p = Double.isNaN(optDouble) ? null : Double.valueOf(optDouble);
                double optDouble2 = jSONObject.optDouble("revenue");
                if (!Double.isNaN(optDouble2)) {
                    d = Double.valueOf(optDouble2);
                }
                this.n = d;
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error("error parsing impression " + e.getMessage());
            }
        }
    }

    public String getAb() {
        return this.h;
    }

    public String getAdFormat() {
        return this.f;
    }

    public String getAdNetwork() {
        return this.k;
    }

    @Deprecated
    public String getAdUnit() {
        return this.c;
    }

    public JSONObject getAllData() {
        return this.f3536a;
    }

    public String getAuctionId() {
        return this.b;
    }

    public String getCountry() {
        return this.g;
    }

    public String getCreativeId() {
        return this.r;
    }

    public String getEncryptedCPM() {
        return this.q;
    }

    public String getInstanceId() {
        return this.m;
    }

    public String getInstanceName() {
        return this.l;
    }

    @Deprecated
    public Double getLifetimeRevenue() {
        return this.p;
    }

    public String getMediationAdUnitId() {
        return this.e;
    }

    public String getMediationAdUnitName() {
        return this.d;
    }

    public String getPlacement() {
        return this.j;
    }

    public String getPrecision() {
        return this.o;
    }

    public Double getRevenue() {
        return this.n;
    }

    public String getSegmentName() {
        return this.i;
    }

    public void replaceMacroForPlacementWithValue(String str, String str2) {
        String str3 = this.j;
        if (str3 != null) {
            String replace = str3.replace(str, str2);
            this.j = replace;
            JSONObject jSONObject = this.f3536a;
            if (jSONObject != null) {
                try {
                    jSONObject.put("placement", replace);
                } catch (JSONException e) {
                    C3260q4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        }
    }

    public String toString() {
        StringBuilder append = new StringBuilder("auctionId: '").append(this.b).append("', adUnit: '").append(this.c).append("', mediationAdUnitName: '").append(this.d).append("', mediationAdUnitId: '").append(this.e).append("', adFormat: '").append(this.f).append("', country: '").append(this.g).append("', ab: '").append(this.h).append("', segmentName: '").append(this.i).append("', placement: '").append(this.j).append("', adNetwork: '").append(this.k).append("', instanceName: '").append(this.l).append("', instanceId: '").append(this.m).append("', revenue: ");
        Double d = this.n;
        StringBuilder append2 = append.append(d == null ? null : this.s.format(d)).append(", precision: '").append(this.o).append("', lifetimeRevenue: ");
        Double d2 = this.p;
        return append2.append(d2 != null ? this.s.format(d2) : null).append(", encryptedCPM: '").append(this.q).append("', creativeId: '").append(this.r).append('\'').toString();
    }

    public ImpressionData(ImpressionData impressionData) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.f3536a = impressionData.f3536a;
        this.b = impressionData.b;
        this.c = impressionData.c;
        this.d = impressionData.d;
        this.e = impressionData.e;
        this.f = impressionData.f;
        this.g = impressionData.g;
        this.h = impressionData.h;
        this.i = impressionData.i;
        this.j = impressionData.j;
        this.k = impressionData.k;
        this.l = impressionData.l;
        this.m = impressionData.m;
        this.o = impressionData.o;
        this.q = impressionData.q;
        this.p = impressionData.p;
        this.n = impressionData.n;
        this.r = impressionData.r;
    }
}
