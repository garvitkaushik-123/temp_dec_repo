package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.bykv.vk.openvk.eli.eli.eli.kb.DbA;
import com.bytedance.sdk.component.utils.Dfc;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AdSlot {
    public static final int ANCHORED_BANNER = 2;
    public static final int FIX_BANNER = 1;
    public static final int INLINE_BANNER = 3;
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_OPEN_AD = 3;
    public static final int TYPE_REWARD_VIDEO = 7;
    private int CMM;
    private int DbA;
    private String Dfc;
    private int FC;
    private int MGA;
    private boolean NU;
    private int Os;
    private String QX;
    private int Vy;
    private int Xb;
    private String aAs;
    private float aGH;
    private String aqO;
    private int bf;
    private String dV;
    private String du;
    private String eli;
    private int ev;
    private boolean gG;
    private boolean kb;
    private String nGm;
    private int nlS;
    private boolean nn;
    private float ui;
    private Map<String, Object> ujq;
    private String wC;

    public static int getPosition(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return (i == 3 || i == 4 || i == 7 || i == 8) ? 5 : 3;
        }
        return 4;
    }

    private AdSlot() {
        this.NU = true;
        this.nn = false;
        this.Xb = 0;
        this.bf = 0;
        this.CMM = 0;
        this.Vy = 1;
    }

    public void setUserData(String str) {
        this.QX = str;
    }

    public String getUserData() {
        return this.QX;
    }

    public String getCodeId() {
        return this.eli;
    }

    public boolean isAutoPlay() {
        return this.NU;
    }

    public boolean isExpressAd() {
        return this.nn;
    }

    public String getBidAdm() {
        return this.Dfc;
    }

    public int getImgAcceptedWidth() {
        return this.DbA;
    }

    public int getImgAcceptedHeight() {
        return this.Os;
    }

    public float getExpressViewAcceptedWidth() {
        return this.aGH;
    }

    public float getExpressViewAcceptedHeight() {
        return this.ui;
    }

    public void setExpressViewAccepted(float f, float f2) {
        this.aGH = f;
        this.ui = f2;
    }

    public boolean isSupportDeepLink() {
        return this.kb;
    }

    public int getAdCount() {
        return this.MGA;
    }

    public void setAdCount(int i) {
        this.MGA = i;
    }

    public String getRewardName() {
        return this.wC;
    }

    public int getRewardAmount() {
        return this.FC;
    }

    public String getMediaExtra() {
        return this.aAs;
    }

    public String getUserID() {
        return this.du;
    }

    public String getAdId() {
        return this.aqO;
    }

    public String getCreativeId() {
        return this.dV;
    }

    public String getExt() {
        return this.nGm;
    }

    public int getIsRotateBanner() {
        return this.Xb;
    }

    public void setIsRotateBanner(int i) {
        this.Xb = i;
    }

    public int getRotateTime() {
        return this.bf;
    }

    public void setRotateTime(int i) {
        this.bf = i;
    }

    public int getRotateOrder() {
        return this.CMM;
    }

    public void setRotateOrder(int i) {
        this.CMM = i;
    }

    public void setDurationSlotType(int i) {
        this.ev = i;
    }

    public int getDurationSlotType() {
        return this.ev;
    }

    public Map<String, Object> getRequestExtraMap() {
        return this.ujq;
    }

    public void setPreload(boolean z) {
        this.gG = z;
    }

    public boolean isPreload() {
        return this.gG;
    }

    public String toString() {
        return super.toString();
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.eli);
            jSONObject.put("mAdCount", this.MGA);
            jSONObject.put("mIsAutoPlay", this.NU);
            jSONObject.put("mImgAcceptedWidth", this.DbA);
            jSONObject.put("mImgAcceptedHeight", this.Os);
            jSONObject.put("mExpressViewAcceptedWidth", this.aGH);
            jSONObject.put("mExpressViewAcceptedHeight", this.ui);
            jSONObject.put("mSupportDeepLink", this.kb);
            jSONObject.put("mRewardName", this.wC);
            jSONObject.put("mRewardAmount", this.FC);
            jSONObject.put("mMediaExtra", this.aAs);
            jSONObject.put("mUserID", this.du);
            jSONObject.put("mNativeAdType", this.nlS);
            jSONObject.put("mIsExpressAd", this.nn);
            jSONObject.put("mAdId", this.aqO);
            jSONObject.put("mCreativeId", this.dV);
            jSONObject.put("mExt", this.nGm);
            jSONObject.put("mBidAdm", this.Dfc);
            jSONObject.put("mUserData", this.QX);
            jSONObject.put("mDurationSlotType", this.ev);
            jSONObject.put("mBannerType", this.Vy);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int getBannerType() {
        return this.Vy;
    }

    public static AdSlot getSlot(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            int optInt = jSONObject.optInt("mImgAcceptedWidth", 640);
            int optInt2 = jSONObject.optInt("mImgAcceptedHeight", Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE);
            double optDouble = jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
            double optDouble2 = jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
            builder.setCodeId(jSONObject.optString("mCodeId", null));
            builder.setAdCount(jSONObject.optInt("mAdCount", 1));
            builder.setIsAutoPlay(jSONObject.optBoolean("mIsAutoPlay"));
            builder.setImageAcceptedSize(optInt, optInt2);
            builder.setExpressViewAcceptedSize(Double.valueOf(optDouble).floatValue(), Double.valueOf(optDouble2).floatValue());
            builder.setSupportDeepLink(jSONObject.optBoolean("mSupportDeepLink", false));
            builder.setRewardName(jSONObject.optString("mRewardName", null));
            builder.setRewardAmount(jSONObject.optInt("mRewardAmount"));
            builder.setMediaExtra(jSONObject.optString("mMediaExtra", null));
            builder.setUserID(jSONObject.optString("mUserID", null));
            builder.setNativeAdType(jSONObject.optInt("mNativeAdType"));
            builder.isExpressAd(jSONObject.optBoolean("mIsExpressAd"));
            builder.withBid(jSONObject.optString("mBidAdm"));
            builder.setAdId(jSONObject.optString("mAdId"));
            builder.setCreativeId(jSONObject.optString("mCreativeId"));
            builder.setExt(jSONObject.optString("mExt"));
            builder.setMediaExtra(jSONObject.optString("mMediaExtra"));
            builder.setBannerType(jSONObject.optInt("mBannerType"));
        } catch (Exception unused) {
        }
        AdSlot build = builder.build();
        build.setDurationSlotType(jSONObject.optInt("mDurationSlotType"));
        return build;
    }

    public static class Builder {
        private String Dfc;
        private boolean NU;
        private int aAs;
        private String aqO;
        private int bf;
        private String dV;
        private float du;
        private String eli;
        private String nGm;
        private float nlS;
        private String nn;
        private String wC;
        private int DbA = 640;
        private int Os = Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE;
        private final boolean aGH = true;
        private int ui = 1;
        private final String MGA = "";
        private final int kb = 0;
        private String FC = "defaultUser";
        private boolean QX = true;
        private Map<String, Object> Xb = null;
        private int CMM = 1;

        public Builder setRewardAmount(int i) {
            return this;
        }

        public Builder setRewardName(String str) {
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            return this;
        }

        public Builder setAdId(String str) {
            this.Dfc = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.aqO = str;
            return this;
        }

        public Builder setExt(String str) {
            this.dV = str;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.QX = z;
            return this;
        }

        public Builder setCodeId(String str) {
            this.eli = str;
            return this;
        }

        public Builder isExpressAd(boolean z) {
            this.NU = z;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.DbA = i;
            this.Os = i2;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.du = f;
            this.nlS = f2;
            return this;
        }

        public Builder setDurationSlotType(int i) {
            this.bf = i;
            return this;
        }

        public Builder setAdCount(int i) {
            if (i <= 0) {
                i = 1;
            }
            if (i > 20) {
                i = 20;
            }
            this.ui = i;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.wC = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.FC = str;
            return this;
        }

        public Builder setNativeAdType(int i) {
            this.aAs = i;
            return this;
        }

        public Builder withBid(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            if (Dfc.aGH()) {
                DbA.eli(str);
            }
            this.nn = str;
            return this;
        }

        public Builder setUserData(String str) {
            this.nGm = str;
            return this;
        }

        public Builder setRequestExtraMap(Map<String, Object> map) {
            this.Xb = map;
            return this;
        }

        public Builder setBannerType(int i) {
            this.CMM = i;
            return this;
        }

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.eli = this.eli;
            adSlot.MGA = this.ui;
            adSlot.kb = true;
            adSlot.DbA = this.DbA;
            adSlot.Os = this.Os;
            float f = this.du;
            if (f <= 0.0f) {
                adSlot.aGH = this.DbA;
                adSlot.ui = this.Os;
            } else {
                adSlot.aGH = f;
                adSlot.ui = this.nlS;
            }
            adSlot.wC = "";
            adSlot.FC = 0;
            adSlot.aAs = this.wC;
            adSlot.du = this.FC;
            adSlot.nlS = this.aAs;
            adSlot.NU = this.QX;
            adSlot.nn = this.NU;
            adSlot.Dfc = this.nn;
            adSlot.aqO = this.Dfc;
            adSlot.dV = this.aqO;
            adSlot.nGm = this.dV;
            adSlot.QX = this.nGm;
            adSlot.ujq = this.Xb;
            adSlot.ev = this.bf;
            adSlot.Vy = this.CMM;
            return adSlot;
        }
    }
}
