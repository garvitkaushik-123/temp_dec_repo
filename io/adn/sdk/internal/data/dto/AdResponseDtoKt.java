package io.adn.sdk.internal.data.dto;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdResponseDto.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"bidPayload", "", "Lio/adn/sdk/internal/data/dto/AdResponseDto;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdResponseDtoKt {
    public static final String bidPayload(AdResponseDto adResponseDto) {
        List<BidDto> bids;
        BidDto bidDto;
        Intrinsics.checkNotNullParameter(adResponseDto, "<this>");
        SeatBidDto seatBidDto = (SeatBidDto) CollectionsKt.firstOrNull((List) adResponseDto.getSeatBid());
        if (seatBidDto == null || (bids = seatBidDto.getBids()) == null || (bidDto = (BidDto) CollectionsKt.firstOrNull((List) bids)) == null) {
            return null;
        }
        return bidDto.getBidPayload();
    }
}
