package io.bidmachine.protobuf.sdk;

import com.explorestack.protobuf.MessageOrBuilder;
import io.bidmachine.protobuf.sdk.OSLog;
import java.util.List;

/* loaded from: classes8.dex */
public interface OSLogOrBuilder extends MessageOrBuilder {
    OSLog.Record getRecords(int i);

    int getRecordsCount();

    List<OSLog.Record> getRecordsList();

    OSLog.RecordOrBuilder getRecordsOrBuilder(int i);

    List<? extends OSLog.RecordOrBuilder> getRecordsOrBuilderList();
}
