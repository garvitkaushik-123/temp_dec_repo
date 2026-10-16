package io.bidmachine.protobuf;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: classes8.dex */
public interface TokenConfigurationOrBuilder extends MessageOrBuilder {
    String getAdNetworks(int i);

    ByteString getAdNetworksBytes(int i);

    int getAdNetworksCount();

    List<String> getAdNetworksList();

    int getExpirationTime();

    String getType();

    ByteString getTypeBytes();
}
