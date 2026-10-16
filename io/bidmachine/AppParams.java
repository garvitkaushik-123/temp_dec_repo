package io.bidmachine;

import android.content.Context;
import android.text.TextUtils;
import com.explorestack.protobuf.adcom.Context;
import io.bidmachine.core.Utils;
import io.bidmachine.protobuf.sdk.App;
import io.bidmachine.utils.ProtoUtils;

/* loaded from: classes7.dex */
final class AppParams {
    private final AppReleaseParams appReleaseParams;

    public AppParams(AppReleaseParams appReleaseParams) {
        this.appReleaseParams = appReleaseParams;
    }

    void build(Context context, Context.App.Builder builder) {
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            builder.setBundle(packageName);
        }
        String appVersion = Utils.getAppVersion(context);
        if (!TextUtils.isEmpty(appVersion)) {
            builder.setVer(appVersion);
        }
        String appName = Utils.getAppName(context);
        if (!TextUtils.isEmpty(appName)) {
            builder.setName(appName);
        }
        this.appReleaseParams.build(context, builder);
    }

    void build(android.content.Context context, App.Builder builder) {
        String appVersion = Utils.getAppVersion(context);
        if (!TextUtils.isEmpty(appVersion)) {
            builder.setAppVer(appVersion);
        }
        String appName = Utils.getAppName(context);
        if (!TextUtils.isEmpty(appName)) {
            builder.setAppName(appName);
        }
        builder.setInstallTime(ProtoUtils.msToProtobufTimestamp(InstallInfoProvider.getInstallTimeMs()));
        builder.setFirstLaunchTime(ProtoUtils.msToProtobufTimestamp(BidMachineImpl.get().obtainFirstLaunchTimeMs(context)));
        this.appReleaseParams.build(context, builder);
    }
}
