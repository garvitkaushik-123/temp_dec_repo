package io.bidmachine.protobuf.sdk;

import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.StructOrBuilder;
import io.bidmachine.protobuf.sdk.Event;

/* loaded from: classes8.dex */
public interface EventOrBuilder extends MessageOrBuilder {
    Struct getExtrasPrivate();

    StructOrBuilder getExtrasPrivateOrBuilder();

    Monitor getMonitor();

    MonitorOrBuilder getMonitorOrBuilder();

    Event.PayloadCase getPayloadCase();

    Reader getReader();

    ReaderOrBuilder getReaderOrBuilder();

    boolean hasExtrasPrivate();

    boolean hasMonitor();

    boolean hasReader();
}
