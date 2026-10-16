package com.tiktok.appevents.contents;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class TTContentParams {
    private String brand;
    private String contentCategory;
    private String contentId;
    private String contentName;
    private float price;
    private int quantity;
    private boolean priceAvailable = false;
    private boolean quantityAvailable = false;

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String brand;
        private String contentCategory;
        private String contentId;
        private String contentName;
        private float price = Float.NaN;
        private int quantity = -1;
        private boolean priceAvailable = false;
        private boolean quantityAvailable = false;

        public Builder setPrice(float price) {
            this.price = price;
            this.priceAvailable = true;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            this.quantityAvailable = true;
            return this;
        }

        public Builder setContentId(String contentId) {
            this.contentId = contentId;
            return this;
        }

        public Builder setContentCategory(String contentCategory) {
            this.contentCategory = contentCategory;
            return this;
        }

        public Builder setContentName(String contentName) {
            this.contentName = contentName;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public TTContentParams build() {
            TTContentParams tTContentParams = new TTContentParams();
            tTContentParams.price = this.price;
            tTContentParams.priceAvailable = this.priceAvailable;
            tTContentParams.quantity = this.quantity;
            tTContentParams.quantityAvailable = this.quantityAvailable;
            tTContentParams.contentId = this.contentId;
            tTContentParams.contentCategory = this.contentCategory;
            tTContentParams.contentName = this.contentName;
            tTContentParams.brand = this.brand;
            return tTContentParams;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject;
        Throwable th;
        try {
            jSONObject = new JSONObject();
            try {
                if (this.quantityAvailable) {
                    jSONObject.put(FirebaseAnalytics.Param.QUANTITY, this.quantity);
                }
                if (!TextUtils.isEmpty(this.contentId)) {
                    jSONObject.put("content_id", this.contentId);
                }
                if (!TextUtils.isEmpty(this.contentCategory)) {
                    jSONObject.put("content_category", this.contentCategory);
                }
                if (!TextUtils.isEmpty(this.contentName)) {
                    jSONObject.put("content_name", this.contentName);
                }
                if (!TextUtils.isEmpty(this.brand)) {
                    jSONObject.put("brand", this.brand);
                }
                if (this.priceAvailable) {
                    float f = this.price;
                    if (f != Float.NaN) {
                        jSONObject.put("price", Double.parseDouble(String.valueOf(f)));
                    }
                }
                return jSONObject;
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return jSONObject;
            }
        } catch (Throwable th3) {
            jSONObject = null;
            th = th3;
        }
    }
}
