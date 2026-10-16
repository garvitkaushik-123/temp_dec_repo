package io.adn.sdk.internal.data.api.local;

import android.content.Context;
import com.ironsource.C3040d4;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppInfoApi.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lio/adn/sdk/internal/data/api/local/AppInfoApiImpl;", "Lio/adn/sdk/internal/data/api/local/AppInfoApi;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", C3040d4.i.W, "", "getAppVersion", "()Ljava/lang/String;", "appBundleId", "getAppBundleId", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AppInfoApiImpl implements AppInfoApi {
    public static final int $stable = 8;
    private final String appBundleId;
    private final String appVersion;
    private final Context context;

    public AppInfoApiImpl(Context context) {
        String m10241constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        try {
            Result.Companion companion = Result.INSTANCE;
            AppInfoApiImpl appInfoApiImpl = this;
            m10241constructorimpl = Result.m10241constructorimpl(this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        this.appVersion = (String) (Result.m10247isFailureimpl(m10241constructorimpl) ? "" : m10241constructorimpl);
        String packageName = this.context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        this.appBundleId = packageName;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // io.adn.sdk.internal.data.api.local.AppInfoApi
    public String getAppVersion() {
        return this.appVersion;
    }

    @Override // io.adn.sdk.internal.data.api.local.AppInfoApi
    public String getAppBundleId() {
        return this.appBundleId;
    }
}
