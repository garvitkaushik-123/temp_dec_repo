package io.adn.sdk.internal.di.modules;

import io.adn.sdk.internal.data.service.AudioService;
import io.adn.sdk.internal.data.service.AudioServiceImpl;
import io.adn.sdk.internal.data.service.NetworkStatusService;
import io.adn.sdk.internal.data.service.NetworkStatusServiceImpl;
import io.adn.sdk.internal.di.SdkInjector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ServicesModule.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lio/adn/sdk/internal/di/modules/ServicesModuleImpl;", "Lio/adn/sdk/internal/di/modules/ServicesModule;", "<init>", "()V", "networkStatusService", "Lio/adn/sdk/internal/data/service/NetworkStatusService;", "getNetworkStatusService", "()Lio/adn/sdk/internal/data/service/NetworkStatusService;", "networkStatusService$delegate", "Lkotlin/Lazy;", "audioService", "Lio/adn/sdk/internal/data/service/AudioService;", "getAudioService", "()Lio/adn/sdk/internal/data/service/AudioService;", "audioService$delegate", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ServicesModuleImpl implements ServicesModule {
    public static final int $stable = 8;

    /* renamed from: networkStatusService$delegate, reason: from kotlin metadata */
    private final Lazy networkStatusService = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.ServicesModuleImpl$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            NetworkStatusServiceImpl networkStatusService_delegate$lambda$1;
            networkStatusService_delegate$lambda$1 = ServicesModuleImpl.networkStatusService_delegate$lambda$1();
            return networkStatusService_delegate$lambda$1;
        }
    });

    /* renamed from: audioService$delegate, reason: from kotlin metadata */
    private final Lazy audioService = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.ServicesModuleImpl$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            AudioServiceImpl audioService_delegate$lambda$3;
            audioService_delegate$lambda$3 = ServicesModuleImpl.audioService_delegate$lambda$3();
            return audioService_delegate$lambda$3;
        }
    });

    @Override // io.adn.sdk.internal.di.modules.ServicesModule
    public NetworkStatusService getNetworkStatusService() {
        return (NetworkStatusService) this.networkStatusService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NetworkStatusServiceImpl networkStatusService_delegate$lambda$1() {
        return new NetworkStatusServiceImpl(SdkInjector.INSTANCE.getSdkModule().getAppContext());
    }

    @Override // io.adn.sdk.internal.di.modules.ServicesModule
    public AudioService getAudioService() {
        return (AudioService) this.audioService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AudioServiceImpl audioService_delegate$lambda$3() {
        return new AudioServiceImpl(SdkInjector.INSTANCE.getSdkModule().getAppContext(), null, 2, null);
    }
}
