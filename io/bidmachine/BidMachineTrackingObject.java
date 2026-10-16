package io.bidmachine;

import io.bidmachine.models.AdObject;
import io.bidmachine.tracking.EventData;
import io.bidmachine.tracking.SessionTrackingObject;
import io.bidmachine.utils.BMError;
import java.util.Map;

/* loaded from: classes7.dex */
public class BidMachineTrackingObject extends SessionTrackingObject {
    public BidMachineTrackingObject() {
        super(BidMachineImpl.get().getSessionTracker());
    }

    public BidMachineTrackingObject(Object trackingKey) {
        super(trackingKey, BidMachineImpl.get().getSessionTracker());
    }

    public void eventFinish(TrackEventType trackEventType, AdsType adsType, AdResponse adResponse, BMError bmError) {
        eventFinish(trackEventType, adsType, adResponse, bmError, null);
    }

    public void eventFinish(TrackEventType trackEventType, AdsType adsType, AdResponse adResponse, BMError bmError, Map<String, Object> customParams) {
        EventData eventData;
        if (adResponse != null) {
            eventData = new EventData().setNetworkName(adResponse.getAuctionResult().getNetworkKey()).setPrice(Double.valueOf(adResponse.getPrice()));
            if (customParams != null) {
                eventData.addCustomParams(customParams);
            }
            AdObject adObject = adResponse.getAdObject();
            if (adObject != null) {
                eventData.addCustomParams(adObject.getCustomParams());
            }
        } else {
            eventData = null;
        }
        eventFinish(trackEventType, adsType, eventData, bmError);
    }
}
