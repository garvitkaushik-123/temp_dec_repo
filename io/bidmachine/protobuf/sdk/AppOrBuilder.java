package io.bidmachine.protobuf.sdk;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.Timestamp;
import com.explorestack.protobuf.TimestampOrBuilder;
import com.explorestack.protobuf.adcom.Context;
import java.util.List;

/* loaded from: classes8.dex */
public interface AppOrBuilder extends MessageOrBuilder {
    String getAppName();

    ByteString getAppNameBytes();

    String getAppVer();

    ByteString getAppVerBytes();

    Timestamp getFirstLaunchTime();

    TimestampOrBuilder getFirstLaunchTimeOrBuilder();

    String getFmwname();

    ByteString getFmwnameBytes();

    Timestamp getInstallTime();

    TimestampOrBuilder getInstallTimeOrBuilder();

    Context.App.Release getRelease();

    Context.App.ReleaseOrBuilder getReleaseOrBuilder();

    String getStorecat();

    ByteString getStorecatBytes();

    String getStoresubcat(int i);

    ByteString getStoresubcatBytes(int i);

    int getStoresubcatCount();

    List<String> getStoresubcatList();

    boolean hasFirstLaunchTime();

    boolean hasInstallTime();

    boolean hasRelease();
}
