package io.bidmachine;

import android.content.Context;
import com.explorestack.protobuf.adcom.ConnectionType;
import com.explorestack.protobuf.adcom.Context;
import io.bidmachine.protobuf.sdk.Device;
import io.bidmachine.utils.DeviceUtils;

/* loaded from: classes7.dex */
final class DeviceConnectionParams {
    DeviceConnectionParams() {
    }

    void build(Context context, Context.Device.Builder deviceBuilder, ConnectionType connectionType) {
        deviceBuilder.setConnection(buildConnection(context, connectionType));
    }

    void build(android.content.Context context, Device.Builder deviceBuilder, ConnectionType connectionType) {
        deviceBuilder.setConnection(buildConnection(context, connectionType));
    }

    private Context.Device.Connection buildConnection(android.content.Context context, ConnectionType connectionType) {
        Context.Device.Connection.Builder newBuilder = Context.Device.Connection.newBuilder();
        newBuilder.setType(connectionType);
        newBuilder.setVpn(DeviceUtils.getVpnStatus(context));
        newBuilder.setProxy(DeviceUtils.getProxyStatus(context));
        return newBuilder.build();
    }
}
