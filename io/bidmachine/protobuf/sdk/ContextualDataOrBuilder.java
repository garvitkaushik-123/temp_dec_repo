package io.bidmachine.protobuf.sdk;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.MessageOrBuilder;
import io.bidmachine.protobuf.sdk.ContextualData;

/* loaded from: classes8.dex */
public interface ContextualDataOrBuilder extends MessageOrBuilder {
    ContextualData.ImpressionData getData();

    ContextualData.ImpressionDataOrBuilder getDataOrBuilder();

    String getMediatorName();

    ByteString getMediatorNameBytes();

    String getPlacement();

    ByteString getPlacementBytes();

    boolean hasData();
}
