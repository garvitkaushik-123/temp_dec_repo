package io.bidmachine;

import io.bidmachine.protobuf.EventTypeExtended;

/* loaded from: classes7.dex */
public enum TrackEventType {
    GetBidToken(513),
    InitLoading(506),
    AuctionRequest(507),
    AuctionRequestCancel(508),
    AuctionRequestExpired(509),
    AuctionRequestDestroy(510),
    BrokenCreativeDetector(EventTypeExtended.EVENT_TYPE_EXTENDED_BROKEN_CREATIVE_DETECTOR_VALUE),
    Load(500),
    FillAd(512),
    Impression(502),
    Show(501),
    Click(503),
    Close(504),
    Expired(511),
    Destroy(505),
    Error(1000),
    TrackingError(1001),
    HeaderBiddingNetworksPrepare(703),
    HeaderBiddingNetworkInitialize(701),
    HeaderBiddingNetworkPrepare(702),
    MediationWin(EventTypeExtended.EVENT_TYPE_EXTENDED_CUSTOM_WIN_VALUE),
    MediationLoss(EventTypeExtended.EVENT_TYPE_EXTENDED_CUSTOM_LOSS_VALUE),
    WaterfallLoadStart(EventTypeExtended.EVENT_TYPE_EXTENDED_WATERFALL_STARTED_VALUE),
    WaterfallLoadFinish(EventTypeExtended.EVENT_TYPE_EXTENDED_WATERFALL_FINISHED_VALUE),
    AdUnitLoadStart(EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_LOADED_VALUE),
    AdUnitLoadFinish(EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_FINISHED_VALUE),
    AdUnitExpired(EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_EXPIRED_VALUE),
    AdUnitCheapestDequeued(EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_INVALIDATED_VALUE),
    AdUnitShown(EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_IMPRESSION_VALUE),
    AdUnitWin(EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_WIN_VALUE),
    AdUnitLoss(EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_LOSS_VALUE),
    AdUnitPaidEvent(EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE),
    ImpressionOpportunity(EventTypeExtended.EVENT_TYPE_EXTENDED_IMPRESSION_OPPORTUNITY_VALUE);

    private final int actionValue;

    TrackEventType(int actionValue) {
        this.actionValue = actionValue;
    }

    public int getActionValue() {
        return this.actionValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + " (" + this.actionValue + ")";
    }

    public static TrackEventType fromNumber(int number) {
        for (TrackEventType trackEventType : values()) {
            if (trackEventType.actionValue == number) {
                return trackEventType;
            }
        }
        return null;
    }
}
