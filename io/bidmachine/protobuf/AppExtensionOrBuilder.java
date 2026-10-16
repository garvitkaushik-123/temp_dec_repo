package io.bidmachine.protobuf;

import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.Timestamp;
import com.explorestack.protobuf.TimestampOrBuilder;

@Deprecated
/* loaded from: classes8.dex */
public interface AppExtensionOrBuilder extends MessageOrBuilder {
    Timestamp getInstallTime();

    TimestampOrBuilder getInstallTimeOrBuilder();

    long getUptime();

    boolean hasInstallTime();
}
