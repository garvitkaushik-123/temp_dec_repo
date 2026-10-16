package io.bidmachine.protobuf.headerbidding;

import com.explorestack.protobuf.MessageOrBuilder;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacement;
import java.util.List;

/* loaded from: classes8.dex */
public interface HeaderBiddingPlacementOrBuilder extends MessageOrBuilder {
    HeaderBiddingPlacement.AdUnit getAdUnits(int i);

    int getAdUnitsCount();

    List<HeaderBiddingPlacement.AdUnit> getAdUnitsList();

    HeaderBiddingPlacement.AdUnitOrBuilder getAdUnitsOrBuilder(int i);

    List<? extends HeaderBiddingPlacement.AdUnitOrBuilder> getAdUnitsOrBuilderList();
}
