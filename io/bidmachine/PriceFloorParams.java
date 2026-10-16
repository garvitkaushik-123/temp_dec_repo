package io.bidmachine;

import io.bidmachine.models.IPriceFloorParams;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes7.dex */
public final class PriceFloorParams implements IPriceFloorParams<PriceFloorParams> {
    private final Map<String, Double> priceFloorsMap = new HashMap();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.IPriceFloorParams
    public PriceFloorParams addPriceFloor(double price) {
        addPriceFloor(UUID.randomUUID().toString(), price);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.IPriceFloorParams
    public PriceFloorParams addPriceFloor(String id, double price) {
        this.priceFloorsMap.put(id, Double.valueOf(price));
        return this;
    }

    Map<String, Double> getPriceFloors() {
        return this.priceFloorsMap;
    }
}
