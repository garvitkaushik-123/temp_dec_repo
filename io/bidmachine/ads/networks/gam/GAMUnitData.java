package io.bidmachine.ads.networks.gam;

import java.util.Map;

/* loaded from: classes7.dex */
public class GAMUnitData {
    private final String adUnitId;
    private final Map<String, String> customTargeting;
    private final float price;
    private final float score;

    public GAMUnitData(String adUnitId, float score, float price, Map<String, String> customTargeting) {
        this.adUnitId = adUnitId;
        this.score = score;
        this.price = price;
        this.customTargeting = customTargeting;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public float getScore() {
        return this.score;
    }

    public float getPrice() {
        return this.price;
    }

    public Map<String, String> getCustomTargeting() {
        return this.customTargeting;
    }

    public String toString() {
        return "adUnitId - " + this.adUnitId + ", score - " + this.score + ", price - " + this.price;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass()) {
            GAMUnitData gAMUnitData = (GAMUnitData) o;
            if (this.adUnitId.equals(gAMUnitData.adUnitId) && Float.compare(gAMUnitData.score, this.score) == 0 && Float.compare(gAMUnitData.price, this.price) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.adUnitId.hashCode() * 31) + Float.floatToIntBits(this.score)) * 31) + Float.floatToIntBits(this.price);
    }
}
