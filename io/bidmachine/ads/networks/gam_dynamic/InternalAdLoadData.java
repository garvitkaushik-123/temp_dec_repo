package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.protobuf.Waterfall;

/* loaded from: classes7.dex */
public class InternalAdLoadData {
    private final String adResponse;
    private final Waterfall.Result.EstimatedPrice price;

    public InternalAdLoadData(Waterfall.Result.EstimatedPrice price, String adResponse) {
        this.price = price;
        this.adResponse = adResponse;
    }

    public Waterfall.Result.EstimatedPrice getPrice() {
        return this.price;
    }

    public String getAdResponse() {
        return this.adResponse;
    }
}
