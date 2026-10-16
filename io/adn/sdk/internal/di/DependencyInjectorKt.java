package io.adn.sdk.internal.di;

import android.content.Context;
import io.adn.sdk.internal.di.modules.AdFactoryModuleImpl;
import io.adn.sdk.internal.di.modules.AdLoaderModuleImpl;
import io.adn.sdk.internal.di.modules.AnalyticsModuleImpl;
import io.adn.sdk.internal.di.modules.DataSourceModuleImpl;
import io.adn.sdk.internal.di.modules.NetworkModuleImpl;
import io.adn.sdk.internal.di.modules.ProviderModuleImpl;
import io.adn.sdk.internal.di.modules.RepositoryModuleImpl;
import io.adn.sdk.internal.di.modules.SdkModule;
import io.adn.sdk.internal.di.modules.SdkModuleImpl;
import io.adn.sdk.internal.di.modules.ServicesModuleImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DependencyInjector.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\b\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"initSdkComponents", "", "context", "Landroid/content/Context;", "sdkComponents", "Lio/adn/sdk/internal/di/modules/SdkModule;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DependencyInjectorKt {
    public static final void initSdkComponents(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SdkInjector sdkInjector = SdkInjector.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        sdkInjector.setSdkModule(new SdkModuleImpl(new ProviderModuleImpl(applicationContext), new NetworkModuleImpl(), new DataSourceModuleImpl(), new ServicesModuleImpl(), new AdLoaderModuleImpl(), new RepositoryModuleImpl(), new AnalyticsModuleImpl(), new AdFactoryModuleImpl()));
    }

    public static final SdkModule sdkComponents() {
        return SdkInjector.INSTANCE.getSdkModule();
    }
}
