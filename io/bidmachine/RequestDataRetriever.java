package io.bidmachine;

import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.adcom.ConnectionType;
import com.explorestack.protobuf.adcom.Context;
import io.bidmachine.protobuf.sdk.App;
import io.bidmachine.utils.ProtoUtils;

/* loaded from: classes7.dex */
public class RequestDataRetriever {
    public static Context collectContext(android.content.Context context, BidMachineImpl bidMachineImpl, UserRestrictionParams userRestrictionParams, TargetingParams targetingParams, ConnectionType connectionType, AdsType adsType) {
        Context.Builder newBuilder = Context.newBuilder();
        Context.App.Builder newBuilder2 = Context.App.newBuilder();
        Publisher publisher = bidMachineImpl.getPublisher();
        if (publisher != null) {
            publisher.build(newBuilder2);
        }
        bidMachineImpl.getAppParams().build(context, newBuilder2);
        targetingParams.build(newBuilder2);
        App.Builder newBuilder3 = App.newBuilder();
        targetingParams.fillAppExtension(newBuilder3);
        newBuilder3.setInstallTime(ProtoUtils.msToProtobufTimestamp(InstallInfoProvider.getInstallTimeMs()));
        newBuilder3.setFirstLaunchTime(ProtoUtils.msToProtobufTimestamp(bidMachineImpl.obtainFirstLaunchTimeMs(context)));
        newBuilder2.addExtProto(Any.pack(newBuilder3.build()));
        newBuilder.setApp(newBuilder2);
        BlockedParams blockedParams = targetingParams.getBlockedParams();
        if (blockedParams != null) {
            Context.Restrictions.Builder newBuilder4 = Context.Restrictions.newBuilder();
            blockedParams.build(newBuilder4);
            newBuilder.setRestrictions(newBuilder4);
        }
        Context.User.Builder newBuilder5 = Context.User.newBuilder();
        userRestrictionParams.build(newBuilder5);
        if (userRestrictionParams.canSendUserInfo()) {
            targetingParams.build(newBuilder5);
        }
        bidMachineImpl.getSessionParams().build(context, newBuilder5, adsType);
        newBuilder.setUser(newBuilder5);
        Context.Regs.Builder newBuilder6 = Context.Regs.newBuilder();
        userRestrictionParams.build(newBuilder6);
        newBuilder.setRegs(newBuilder6);
        bidMachineImpl.getDeviceParams().build(context, newBuilder, targetingParams, bidMachineImpl.getTargetingParams(), userRestrictionParams, connectionType);
        return newBuilder.build();
    }
}
