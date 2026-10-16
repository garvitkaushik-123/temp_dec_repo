package io.bidmachine.protobuf;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.StructOrBuilder;
import io.bidmachine.protobuf.RequestTokenPayload;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacement;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacementOrBuilder;
import io.bidmachine.protobuf.sdk.App;
import io.bidmachine.protobuf.sdk.AppOrBuilder;
import io.bidmachine.protobuf.sdk.Device;
import io.bidmachine.protobuf.sdk.DeviceOrBuilder;
import io.bidmachine.protobuf.sdk.Placement;
import io.bidmachine.protobuf.sdk.PlacementOrBuilder;
import io.bidmachine.protobuf.sdk.SDK;
import io.bidmachine.protobuf.sdk.SDKOrBuilder;
import io.bidmachine.protobuf.sdk.User;
import io.bidmachine.protobuf.sdk.UserOrBuilder;
import java.util.Map;

/* loaded from: classes8.dex */
public interface RequestTokenPayloadOrBuilder extends MessageOrBuilder {
    @Deprecated
    boolean containsCustomData(String str);

    @Deprecated
    String getAdType();

    @Deprecated
    ByteString getAdTypeBytes();

    App getAppData();

    AppOrBuilder getAppDataOrBuilder();

    @Deprecated
    Map<String, String> getCustomData();

    @Deprecated
    int getCustomDataCount();

    @Deprecated
    Map<String, String> getCustomDataMap();

    @Deprecated
    String getCustomDataOrDefault(String str, String str2);

    @Deprecated
    String getCustomDataOrThrow(String str);

    Device getDeviceData();

    DeviceOrBuilder getDeviceDataOrBuilder();

    Struct getExt();

    StructOrBuilder getExtOrBuilder();

    @Deprecated
    HeaderBiddingPlacement getHbPlacement();

    @Deprecated
    HeaderBiddingPlacementOrBuilder getHbPlacementOrBuilder();

    Placement getPlacement();

    SDK getPlacementData();

    SDKOrBuilder getPlacementDataOrBuilder();

    PlacementOrBuilder getPlacementOrBuilder();

    io.bidmachine.protobuf.sdk.Session getSession();

    @Deprecated
    RequestTokenPayload.SessionData getSessionData();

    @Deprecated
    RequestTokenPayload.SessionDataOrBuilder getSessionDataOrBuilder();

    io.bidmachine.protobuf.sdk.SessionOrBuilder getSessionOrBuilder();

    String getTokenHashValue();

    ByteString getTokenHashValueBytes();

    User getUserData();

    UserOrBuilder getUserDataOrBuilder();

    boolean hasAppData();

    boolean hasDeviceData();

    boolean hasExt();

    @Deprecated
    boolean hasHbPlacement();

    boolean hasPlacement();

    boolean hasPlacementData();

    boolean hasSession();

    @Deprecated
    boolean hasSessionData();

    boolean hasUserData();
}
