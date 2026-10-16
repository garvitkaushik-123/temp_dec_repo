package io.bidmachine;

import android.content.Context;
import android.text.TextUtils;
import com.explorestack.protobuf.adcom.Context;
import io.bidmachine.protobuf.sdk.App;

/* loaded from: classes7.dex */
final class AppReleaseParams {
    AppReleaseParams() {
    }

    void build(Context context, Context.App.Builder appBuilder) {
        appBuilder.setRelease(buildReleaseInfo(context));
    }

    void build(android.content.Context context, App.Builder appBuilder) {
        appBuilder.setRelease(buildReleaseInfo(context));
    }

    private Context.App.Release buildReleaseInfo(android.content.Context context) {
        BuildInfo obtain = BuildInfo.obtain(context);
        Context.App.Release.Builder newBuilder = Context.App.Release.newBuilder();
        newBuilder.setType(getBuildType(obtain));
        String sha1Signature = obtain.getSha1Signature(context);
        if (!TextUtils.isEmpty(sha1Signature)) {
            newBuilder.setSignatureSHA1(sha1Signature);
        }
        String sha256Signature = obtain.getSha256Signature(context);
        if (!TextUtils.isEmpty(sha256Signature)) {
            newBuilder.setSignatureSHA256(sha256Signature);
        }
        return newBuilder.build();
    }

    private String getBuildType(BuildInfo buildInfo) {
        if (buildInfo.isDebuggable()) {
            return "debug";
        }
        return "release";
    }
}
