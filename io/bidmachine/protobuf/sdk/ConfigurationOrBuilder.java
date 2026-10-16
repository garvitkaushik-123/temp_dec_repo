package io.bidmachine.protobuf.sdk;

import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.StringValue;
import com.explorestack.protobuf.StringValueOrBuilder;
import io.bidmachine.protobuf.sdk.Monitor;
import io.bidmachine.protobuf.sdk.Reader;
import java.util.List;

/* loaded from: classes8.dex */
public interface ConfigurationOrBuilder extends MessageOrBuilder {
    StringValue getBpk();

    StringValueOrBuilder getBpkOrBuilder();

    Monitor.Configuration getMonitors(int i);

    int getMonitorsCount();

    List<Monitor.Configuration> getMonitorsList();

    Monitor.ConfigurationOrBuilder getMonitorsOrBuilder(int i);

    List<? extends Monitor.ConfigurationOrBuilder> getMonitorsOrBuilderList();

    Reader.Configuration getReaders(int i);

    int getReadersCount();

    List<Reader.Configuration> getReadersList();

    Reader.ConfigurationOrBuilder getReadersOrBuilder(int i);

    List<? extends Reader.ConfigurationOrBuilder> getReadersOrBuilderList();

    boolean hasBpk();
}
