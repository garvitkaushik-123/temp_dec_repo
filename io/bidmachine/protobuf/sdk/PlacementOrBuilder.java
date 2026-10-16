package io.bidmachine.protobuf.sdk;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.StringValue;
import com.explorestack.protobuf.StringValueOrBuilder;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.StructOrBuilder;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacement;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacementOrBuilder;

/* loaded from: classes8.dex */
public interface PlacementOrBuilder extends MessageOrBuilder {
    String getAdType();

    ByteString getAdTypeBytes();

    Struct getCustomData();

    StructOrBuilder getCustomDataOrBuilder();

    HeaderBiddingPlacement getHbPlacement();

    HeaderBiddingPlacementOrBuilder getHbPlacementOrBuilder();

    StringValue getPlacementId();

    StringValueOrBuilder getPlacementIdOrBuilder();

    boolean hasCustomData();

    boolean hasHbPlacement();

    boolean hasPlacementId();
}
