package io.adn.sdk.internal.di;

import io.adn.sdk.internal.di.modules.SdkModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DependencyInjector.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/adn/sdk/internal/di/SdkInjector;", "", "<init>", "()V", "sdkModule", "Lio/adn/sdk/internal/di/modules/SdkModule;", "getSdkModule", "()Lio/adn/sdk/internal/di/modules/SdkModule;", "setSdkModule", "(Lio/adn/sdk/internal/di/modules/SdkModule;)V", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class SdkInjector {
    public static SdkModule sdkModule;
    public static final SdkInjector INSTANCE = new SdkInjector();
    public static final int $stable = 8;

    private SdkInjector() {
    }

    public final SdkModule getSdkModule() {
        SdkModule sdkModule2 = sdkModule;
        if (sdkModule2 != null) {
            return sdkModule2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sdkModule");
        return null;
    }

    public final void setSdkModule(SdkModule sdkModule2) {
        Intrinsics.checkNotNullParameter(sdkModule2, "<set-?>");
        sdkModule = sdkModule2;
    }
}
