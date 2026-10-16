package io.bidmachine.protobuf.sdk;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.MessageOrBuilder;
import io.bidmachine.protobuf.sdk.Error;

/* loaded from: classes8.dex */
public interface ErrorOrBuilder extends MessageOrBuilder {
    Error.Data getError();

    Error.DataOrBuilder getErrorOrBuilder();

    String getName();

    ByteString getNameBytes();

    Error.Data getReason();

    Error.DataOrBuilder getReasonOrBuilder();

    boolean hasError();

    boolean hasReason();
}
