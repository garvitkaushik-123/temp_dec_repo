package com.ironsource.mediationsdk.adunit.adapter.utility;

import com.ironsource.C3132ib;
import com.ironsource.C3260q4;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.logger.IronLog;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class AdInfo {
    private final ImpressionData mImpressionData;
    private final C3132ib mLoadArmData;

    public AdInfo(ImpressionData impressionData) {
        this.mImpressionData = impressionData;
        this.mLoadArmData = null;
    }

    public String getAb() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getAb() == null) ? "" : this.mImpressionData.getAb();
    }

    public String getAdNetwork() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getAdNetwork() == null) ? "" : this.mImpressionData.getAdNetwork();
    }

    public String getAdUnit() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getAdUnit() == null) ? "" : this.mImpressionData.getAdUnit();
    }

    public String getAuctionId() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getAuctionId() == null) ? "" : this.mImpressionData.getAuctionId();
    }

    public String getCountry() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getCountry() == null) ? "" : this.mImpressionData.getCountry();
    }

    public String getEncryptedCPM() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getEncryptedCPM() == null) ? "" : this.mImpressionData.getEncryptedCPM();
    }

    public String getInstanceId() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getInstanceId() == null) ? "" : this.mImpressionData.getInstanceId();
    }

    public String getInstanceName() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getInstanceName() == null) ? "" : this.mImpressionData.getInstanceName();
    }

    public Double getLifetimeRevenue() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getLifetimeRevenue() == null) ? Double.valueOf(0.0d) : this.mImpressionData.getLifetimeRevenue();
    }

    public String getPrecision() {
        C3132ib c3132ib = this.mLoadArmData;
        if (c3132ib != null) {
            return c3132ib.c();
        }
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getPrecision() == null) ? "" : this.mImpressionData.getPrecision();
    }

    public Double getRevenue() {
        C3132ib c3132ib = this.mLoadArmData;
        if (c3132ib != null) {
            return Double.valueOf(c3132ib.d());
        }
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getRevenue() == null) ? Double.valueOf(0.0d) : this.mImpressionData.getRevenue();
    }

    public String getSegmentName() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getSegmentName() == null) ? "" : this.mImpressionData.getSegmentName();
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("auctionId", getAuctionId());
            jSONObject.put("adUnit", getAdUnit());
            jSONObject.put("country", getCountry());
            jSONObject.put("ab", getAb());
            jSONObject.put("segmentName", getSegmentName());
            jSONObject.put("adNetwork", getAdNetwork());
            jSONObject.put("instanceName", getInstanceName());
            jSONObject.put("instanceId", getInstanceId());
            jSONObject.put("revenue", getRevenue());
            jSONObject.put("precision", getPrecision());
            jSONObject.put(ImpressionData.IMPRESSION_DATA_KEY_LIFETIME_REVENUE, getLifetimeRevenue());
            jSONObject.put("encryptedCPM", getEncryptedCPM());
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error("error while parsing ad info " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public AdInfo(ImpressionData impressionData, C3132ib c3132ib) {
        this.mImpressionData = impressionData;
        this.mLoadArmData = c3132ib;
    }

    public AdInfo() {
        this.mImpressionData = null;
        this.mLoadArmData = null;
    }
}
