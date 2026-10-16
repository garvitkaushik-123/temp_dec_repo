package io.bidmachine.protobuf.sdk;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.MessageOrBuilder;
import io.bidmachine.protobuf.sdk.Session;

/* loaded from: classes8.dex */
public interface SessionOrBuilder extends MessageOrBuilder {
    Session.Context getContext();

    Session.ContextOrBuilder getContextOrBuilder();

    String getSessionId();

    ByteString getSessionIdBytes();

    boolean hasContext();
}
