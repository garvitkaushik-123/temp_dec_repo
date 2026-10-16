package io.bidmachine.displays;

import com.explorestack.protobuf.adcom.Ad;

/* loaded from: classes7.dex */
class DisplayAdObjectParams extends IabAdObjectParams {
    DisplayAdObjectParams(Ad ad) {
        super(ad);
        prepareEvents(ad.getDisplay().getEventList());
    }

    void setWidth(int width) {
        getData().put("width", Integer.valueOf(width));
    }

    void setHeight(int height) {
        getData().put("height", Integer.valueOf(height));
    }
}
