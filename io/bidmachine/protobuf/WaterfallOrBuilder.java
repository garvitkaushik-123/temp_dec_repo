package io.bidmachine.protobuf;

import com.explorestack.protobuf.MessageOrBuilder;
import io.bidmachine.protobuf.Waterfall;

/* loaded from: classes8.dex */
public interface WaterfallOrBuilder extends MessageOrBuilder {
    Waterfall.PayloadCase getPayloadCase();

    Waterfall.Result getRequest();

    Waterfall.ResultOrBuilder getRequestOrBuilder();

    Waterfall.Configuration getResponse();

    Waterfall.ConfigurationOrBuilder getResponseOrBuilder();

    boolean hasRequest();

    boolean hasResponse();
}
