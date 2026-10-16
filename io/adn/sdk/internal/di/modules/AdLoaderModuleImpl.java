package io.adn.sdk.internal.di.modules;

import io.adn.sdk.internal.data.parser.VastParser;
import io.adn.sdk.internal.data.repository.AdFileLoaderImpl;
import io.adn.sdk.internal.data.repository.FullscreenAdSceneLoaderImpl;
import io.adn.sdk.internal.data.repository.VastLoaderImpl;
import io.adn.sdk.internal.data.repository.VastTrackerImpl;
import io.adn.sdk.internal.di.SdkInjector;
import io.adn.sdk.internal.domain.repository.AdFileLoader;
import io.adn.sdk.internal.domain.repository.FullscreenAdSceneLoader;
import io.adn.sdk.internal.domain.repository.VastLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: AdLoaderModule.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lio/adn/sdk/internal/di/modules/AdLoaderModuleImpl;", "Lio/adn/sdk/internal/di/modules/AdLoaderModule;", "<init>", "()V", "fileLoader", "Lio/adn/sdk/internal/domain/repository/AdFileLoader;", "getFileLoader", "()Lio/adn/sdk/internal/domain/repository/AdFileLoader;", "fileLoader$delegate", "Lkotlin/Lazy;", "vastParser", "Lio/adn/sdk/internal/data/parser/VastParser;", "getVastParser", "()Lio/adn/sdk/internal/data/parser/VastParser;", "vastParser$delegate", "vastAdLoader", "Lio/adn/sdk/internal/domain/repository/VastLoader;", "getVastAdLoader", "()Lio/adn/sdk/internal/domain/repository/VastLoader;", "vastAdLoader$delegate", "adSceneLoader", "Lio/adn/sdk/internal/domain/repository/FullscreenAdSceneLoader;", "getAdSceneLoader", "()Lio/adn/sdk/internal/domain/repository/FullscreenAdSceneLoader;", "adSceneLoader$delegate", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdLoaderModuleImpl implements AdLoaderModule {
    public static final int $stable = 8;

    /* renamed from: fileLoader$delegate, reason: from kotlin metadata */
    private final Lazy fileLoader = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.AdLoaderModuleImpl$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            AdFileLoaderImpl fileLoader_delegate$lambda$1;
            fileLoader_delegate$lambda$1 = AdLoaderModuleImpl.fileLoader_delegate$lambda$1();
            return fileLoader_delegate$lambda$1;
        }
    });

    /* renamed from: vastParser$delegate, reason: from kotlin metadata */
    private final Lazy vastParser = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.AdLoaderModuleImpl$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            VastParser vastParser_delegate$lambda$2;
            vastParser_delegate$lambda$2 = AdLoaderModuleImpl.vastParser_delegate$lambda$2();
            return vastParser_delegate$lambda$2;
        }
    });

    /* renamed from: vastAdLoader$delegate, reason: from kotlin metadata */
    private final Lazy vastAdLoader = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.AdLoaderModuleImpl$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            VastLoaderImpl vastAdLoader_delegate$lambda$4;
            vastAdLoader_delegate$lambda$4 = AdLoaderModuleImpl.vastAdLoader_delegate$lambda$4(AdLoaderModuleImpl.this);
            return vastAdLoader_delegate$lambda$4;
        }
    });

    /* renamed from: adSceneLoader$delegate, reason: from kotlin metadata */
    private final Lazy adSceneLoader = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.AdLoaderModuleImpl$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            FullscreenAdSceneLoaderImpl adSceneLoader_delegate$lambda$5;
            adSceneLoader_delegate$lambda$5 = AdLoaderModuleImpl.adSceneLoader_delegate$lambda$5(AdLoaderModuleImpl.this);
            return adSceneLoader_delegate$lambda$5;
        }
    });

    @Override // io.adn.sdk.internal.di.modules.AdLoaderModule
    public AdFileLoader getFileLoader() {
        return (AdFileLoader) this.fileLoader.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AdFileLoaderImpl fileLoader_delegate$lambda$1() {
        SdkModule sdkModule = SdkInjector.INSTANCE.getSdkModule();
        return new AdFileLoaderImpl(sdkModule.getRemoteDataSource(), sdkModule.getStorageRepository(), null, 4, null);
    }

    private final VastParser getVastParser() {
        return (VastParser) this.vastParser.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VastParser vastParser_delegate$lambda$2() {
        return new VastParser();
    }

    @Override // io.adn.sdk.internal.di.modules.AdLoaderModule
    public VastLoader getVastAdLoader() {
        return (VastLoader) this.vastAdLoader.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VastLoaderImpl vastAdLoader_delegate$lambda$4(AdLoaderModuleImpl adLoaderModuleImpl) {
        SdkModule sdkModule = SdkInjector.INSTANCE.getSdkModule();
        return new VastLoaderImpl(adLoaderModuleImpl.getVastParser(), sdkModule.getRemoteDataSource(), new VastTrackerImpl(sdkModule.getAdTrackerSender()));
    }

    @Override // io.adn.sdk.internal.di.modules.AdLoaderModule
    public FullscreenAdSceneLoader getAdSceneLoader() {
        return (FullscreenAdSceneLoader) this.adSceneLoader.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FullscreenAdSceneLoaderImpl adSceneLoader_delegate$lambda$5(AdLoaderModuleImpl adLoaderModuleImpl) {
        return new FullscreenAdSceneLoaderImpl(adLoaderModuleImpl.getFileLoader());
    }
}
