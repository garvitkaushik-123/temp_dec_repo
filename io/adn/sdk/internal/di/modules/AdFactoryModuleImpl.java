package io.adn.sdk.internal.di.modules;

import android.app.Activity;
import io.adn.sdk.internal.data.parser.AdJsonParser;
import io.adn.sdk.internal.data.repository.AdTrackerImpl;
import io.adn.sdk.internal.data.repository.AdVideoTrackerImpl;
import io.adn.sdk.internal.data.repository.BidFetcherRepositoryImpl;
import io.adn.sdk.internal.data.repository.FullscreenAdLoaderImpl;
import io.adn.sdk.internal.data.repository.NativeAdLoaderImpl;
import io.adn.sdk.internal.data.service.ExternalLinkNavigatorImpl;
import io.adn.sdk.internal.di.SdkInjector;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.handler.FullscreenAdHandler;
import io.adn.sdk.internal.domain.handler.NativeAdHandler;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEntity;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.ad.NativeAdAsset;
import io.adn.sdk.internal.domain.model.ad.NativeAdEntity;
import io.adn.sdk.internal.domain.repository.BidFetcherRepository;
import io.adn.sdk.internal.domain.repository.FullscreenAdLoader;
import io.adn.sdk.internal.domain.repository.NativeAdLoader;
import io.adn.sdk.internal.domain.usecase.FetchBidResponseUseCase;
import io.adn.sdk.internal.domain.usecase.FetchOmSdkJsUseCase;
import io.adn.sdk.internal.domain.usecase.GetBidTokenUseCase;
import io.adn.sdk.internal.domain.usecase.InitializeAdMeasurementUseCase;
import io.adn.sdk.internal.domain.usecase.LoadFullscreenAdUseCase;
import io.adn.sdk.internal.domain.usecase.LoadNativeAdAssetsUseCase;
import io.adn.sdk.internal.domain.usecase.LoadNativeAdMetadataUseCase;
import io.adn.sdk.internal.domain.usecase.PostInitializationUseCase;
import io.adn.sdk.internal.domain.usecase.PrepareFullscreenSceneAssetsUseCase;
import io.adn.sdk.internal.domain.usecase.TrackAttributionUseCase;
import io.adn.sdk.internal.thirdparty.omsdk.NativeDisplayAdMeasurementController;
import io.adn.sdk.internal.thirdparty.omsdk.VideoAdMeasurementController;
import io.adn.sdk.internal.thirdparty.omsdk.model.AdMeasurementConfiguration;
import io.adn.sdk.internal.thirdparty.omsdk.model.AdMeasurementVerificationResource;
import io.adn.sdk.internal.thirdparty.omsdk.omid.OmidInitializer;
import io.adn.sdk.internal.thirdparty.omsdk.omid.OmidNativeSessionProvider;
import io.adn.sdk.internal.thirdparty.omsdk.omid.OmidVideoSessionProvider;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenAdViewModel;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenHtmlSceneViewModel;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenImageSceneViewModel;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenPromotedAppCardViewModel;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenVideoSceneViewModel;
import io.adn.sdk.internal.ui.nativead.NativeAdViewModel;
import io.adn.sdk.internal.ui.nativead.NativeImageMediaViewModel;
import io.adn.sdk.internal.ui.nativead.NativeMediaViewModel;
import io.adn.sdk.internal.ui.nativead.NativeVideoMediaViewModel;
import io.adn.sdk.publisher.AdnAdPlacement;
import io.adn.sdk.publisher.inappbrowser.AdnInAppBrowserLauncher;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdFactoryModule.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020+H\u0016J,\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000-2\u0006\u00101\u001a\u0002022\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J*\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001062\f\u00107\u001a\b\u0012\u0004\u0012\u0002080-2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u00069"}, d2 = {"Lio/adn/sdk/internal/di/modules/AdFactoryModuleImpl;", "Lio/adn/sdk/internal/di/modules/AdFactoryModule;", "<init>", "()V", "createFullscreenAd", "Lio/adn/sdk/internal/domain/handler/FullscreenAdHandler;", "activity", "Landroid/app/Activity;", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "createNativeAd", "Lio/adn/sdk/internal/domain/handler/NativeAdHandler;", "createFullscreenAdViewModel", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenAdViewModel;", "ad", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEntity;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "createNativeAdViewModel", "Lio/adn/sdk/internal/ui/nativead/NativeAdViewModel;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "inAppBrowserLauncher", "Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowserLauncher;", "getBidTokenUseCase", "Lio/adn/sdk/internal/domain/usecase/GetBidTokenUseCase;", "loadFullscreenAdUseCase", "Lio/adn/sdk/internal/domain/usecase/LoadFullscreenAdUseCase;", "adLoader", "Lio/adn/sdk/internal/domain/repository/FullscreenAdLoader;", "fetchBidResponseUseCase", "Lio/adn/sdk/internal/domain/usecase/FetchBidResponseUseCase;", "bidFetcherRepository", "Lio/adn/sdk/internal/domain/repository/BidFetcherRepository;", "loadNativeAdMetadataUseCase", "Lio/adn/sdk/internal/domain/usecase/LoadNativeAdMetadataUseCase;", "Lio/adn/sdk/internal/domain/repository/NativeAdLoader;", "loadNativeAdUseCase", "Lio/adn/sdk/internal/domain/usecase/LoadNativeAdAssetsUseCase;", "fetchOmSdkJsUseCase", "Lio/adn/sdk/internal/domain/usecase/FetchOmSdkJsUseCase;", "trackAttributionUseCase", "Lio/adn/sdk/internal/domain/usecase/TrackAttributionUseCase;", "postInitializationUseCase", "Lio/adn/sdk/internal/domain/usecase/PostInitializationUseCase;", "createFullscreenSceneViewModels", "", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenSceneViewModel;", "scenes", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "prepareAssetsUseCase", "Lio/adn/sdk/internal/domain/usecase/PrepareFullscreenSceneAssetsUseCase;", "createNativeAdMediaViewModel", "Lio/adn/sdk/internal/ui/nativead/NativeMediaViewModel;", "asset", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media;", "adMeasurementVerificationResources", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdMeasurementVerificationResource;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdFactoryModuleImpl implements AdFactoryModule {
    public static final int $stable = 0;

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public FullscreenAdHandler createFullscreenAd(Activity activity, AdnAdPlacement placement) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(placement, "placement");
        SdkModule sdkModule = SdkInjector.INSTANCE.getSdkModule();
        DiagnosticReporter createDiagnosticReporter = sdkModule.createDiagnosticReporter();
        createDiagnosticReporter.updateAdPlacement(placement);
        return new FullscreenAdHandler(activity, placement, sdkModule.fetchBidResponseUseCase(new BidFetcherRepositoryImpl(sdkModule.getRemoteDataSource(), sdkModule.getLocalDataSource(), new AdJsonParser(sdkModule.getJson()), sdkModule.getBidTokenRepository(), null, 16, null), createDiagnosticReporter), sdkModule.loadFullscreenAdUseCase(new FullscreenAdLoaderImpl(sdkModule.getVastAdLoader(), sdkModule.getAdSceneLoader(), null, 4, null), createDiagnosticReporter), createDiagnosticReporter, null, 32, null);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public NativeAdHandler createNativeAd(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        SdkModule sdkModule = SdkInjector.INSTANCE.getSdkModule();
        DiagnosticReporter createDiagnosticReporter = sdkModule.createDiagnosticReporter();
        createDiagnosticReporter.updateAdPlacement(AdnAdPlacement.NATIVE);
        NativeAdLoaderImpl nativeAdLoaderImpl = new NativeAdLoaderImpl(new AdJsonParser(sdkModule.getJson()), sdkModule.getVastAdLoader(), sdkModule.getFileLoader(), null, 8, null);
        return new NativeAdHandler(activity, sdkModule.fetchBidResponseUseCase(new BidFetcherRepositoryImpl(sdkModule.getRemoteDataSource(), sdkModule.getLocalDataSource(), new AdJsonParser(sdkModule.getJson()), sdkModule.getBidTokenRepository(), null, 16, null), createDiagnosticReporter), sdkModule.loadNativeAdMetadataUseCase(nativeAdLoaderImpl), sdkModule.loadNativeAdUseCase(nativeAdLoaderImpl), createDiagnosticReporter, null, 32, null);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public FullscreenAdViewModel createFullscreenAdViewModel(Activity activity, FullscreenAdEntity ad, DiagnosticReporter diagnosticReporter) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        SdkModule sdkModule = SdkInjector.INSTANCE.getSdkModule();
        return new FullscreenAdViewModel(ad, createFullscreenSceneViewModels(ad.getScenes(), new PrepareFullscreenSceneAssetsUseCase(sdkModule.getAdSceneLoader()), diagnosticReporter), new ExternalLinkNavigatorImpl(activity), diagnosticReporter, new AdTrackerImpl(sdkModule.getAdTrackerSender()), null, 32, null);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public NativeAdViewModel createNativeAdViewModel(Activity activity, NativeAdEntity ad, AdnInAppBrowserLauncher inAppBrowserLauncher, DiagnosticReporter diagnosticReporter) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        return new NativeAdViewModel(activity, ad, createNativeAdMediaViewModel(ad.getMainMedia(), ad.getAdMeasurementVerificationResources(), diagnosticReporter), new AdTrackerImpl(SdkInjector.INSTANCE.getSdkModule().getAdTrackerSender()), new ExternalLinkNavigatorImpl(activity), inAppBrowserLauncher, diagnosticReporter, null, 128, null);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public GetBidTokenUseCase getBidTokenUseCase(AdnAdPlacement placement) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        SdkModule sdkModule = SdkInjector.INSTANCE.getSdkModule();
        DiagnosticReporter createDiagnosticReporter = sdkModule.createDiagnosticReporter();
        createDiagnosticReporter.updateAdPlacement(placement);
        return new GetBidTokenUseCase(placement, sdkModule.getBidTokenRepository(), createDiagnosticReporter);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public LoadFullscreenAdUseCase loadFullscreenAdUseCase(FullscreenAdLoader adLoader, DiagnosticReporter diagnosticReporter) {
        Intrinsics.checkNotNullParameter(adLoader, "adLoader");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        return new LoadFullscreenAdUseCase(adLoader, diagnosticReporter, null, 4, null);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public FetchBidResponseUseCase fetchBidResponseUseCase(BidFetcherRepository bidFetcherRepository, DiagnosticReporter diagnosticReporter) {
        Intrinsics.checkNotNullParameter(bidFetcherRepository, "bidFetcherRepository");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        return new FetchBidResponseUseCase(bidFetcherRepository, diagnosticReporter);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public LoadNativeAdMetadataUseCase loadNativeAdMetadataUseCase(NativeAdLoader adLoader) {
        Intrinsics.checkNotNullParameter(adLoader, "adLoader");
        return new LoadNativeAdMetadataUseCase(adLoader);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public LoadNativeAdAssetsUseCase loadNativeAdUseCase(NativeAdLoader adLoader) {
        Intrinsics.checkNotNullParameter(adLoader, "adLoader");
        return new LoadNativeAdAssetsUseCase(adLoader);
    }

    private final FetchOmSdkJsUseCase fetchOmSdkJsUseCase() {
        SdkModule sdkModule = SdkInjector.INSTANCE.getSdkModule();
        return new FetchOmSdkJsUseCase(sdkModule.getStorageRepository(), sdkModule.getFileLoader(), sdkModule.createDiagnosticReporter());
    }

    private final TrackAttributionUseCase trackAttributionUseCase() {
        SdkModule sdkModule = SdkInjector.INSTANCE.getSdkModule();
        return new TrackAttributionUseCase(sdkModule.getInstallReferrerRepository(), sdkModule.getRemoteDataRepository(), sdkModule.getInstallReferrerStorage(), null, 8, null);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public PostInitializationUseCase postInitializationUseCase() {
        SdkModule sdkModule = SdkInjector.INSTANCE.getSdkModule();
        return new PostInitializationUseCase(new InitializeAdMeasurementUseCase(new OmidInitializer(sdkModule.getAppContext()), fetchOmSdkJsUseCase(), null, 4, null), trackAttributionUseCase(), sdkModule.getStorageRepository(), DataSourceModuleKt.externalData());
    }

    private final List<FullscreenSceneViewModel> createFullscreenSceneViewModels(List<? extends FullscreenAdScene> scenes, PrepareFullscreenSceneAssetsUseCase prepareAssetsUseCase, DiagnosticReporter diagnosticReporter) {
        FullscreenSceneViewModel fullscreenPromotedAppCardViewModel;
        SdkModule sdkModule = SdkInjector.INSTANCE.getSdkModule();
        List<? extends FullscreenAdScene> list = scenes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (FullscreenAdScene fullscreenAdScene : list) {
            if (fullscreenAdScene instanceof FullscreenAdScene.Html) {
                fullscreenPromotedAppCardViewModel = new FullscreenHtmlSceneViewModel((FullscreenAdScene.Html) fullscreenAdScene, prepareAssetsUseCase, diagnosticReporter);
            } else if (fullscreenAdScene instanceof FullscreenAdScene.Image) {
                fullscreenPromotedAppCardViewModel = new FullscreenImageSceneViewModel((FullscreenAdScene.Image) fullscreenAdScene, prepareAssetsUseCase, diagnosticReporter);
            } else if (fullscreenAdScene instanceof FullscreenAdScene.Video) {
                FullscreenAdScene.Video video = (FullscreenAdScene.Video) fullscreenAdScene;
                fullscreenPromotedAppCardViewModel = new FullscreenVideoSceneViewModel(video, prepareAssetsUseCase, diagnosticReporter, new AdVideoTrackerImpl(video.getUrl(), video.getTracking(), sdkModule.getAdTrackerSender()));
            } else {
                if (!(fullscreenAdScene instanceof FullscreenAdScene.PromotedAppCard)) {
                    throw new NoWhenBranchMatchedException();
                }
                fullscreenPromotedAppCardViewModel = new FullscreenPromotedAppCardViewModel((FullscreenAdScene.PromotedAppCard) fullscreenAdScene, prepareAssetsUseCase, diagnosticReporter);
            }
            arrayList.add(fullscreenPromotedAppCardViewModel);
        }
        return arrayList;
    }

    private final NativeMediaViewModel createNativeAdMediaViewModel(NativeAdAsset.Media asset, List<AdMeasurementVerificationResource> adMeasurementVerificationResources, DiagnosticReporter diagnosticReporter) {
        SdkModule sdkModule = SdkInjector.INSTANCE.getSdkModule();
        if (asset instanceof NativeAdAsset.Media.Video) {
            NativeAdAsset.Media.Video video = (NativeAdAsset.Media.Video) asset;
            return new NativeVideoMediaViewModel(video, new AdVideoTrackerImpl(video.getUrl(), video.getTracking(), sdkModule.getAdTrackerSender()), new VideoAdMeasurementController(new OmidVideoSessionProvider(sdkModule.getStorageRepository(), new AdMeasurementConfiguration(false, 0.0f)), adMeasurementVerificationResources, diagnosticReporter), null, 8, null);
        }
        if (asset instanceof NativeAdAsset.Media.Image) {
            return new NativeImageMediaViewModel((NativeAdAsset.Media.Image) asset, new NativeDisplayAdMeasurementController(new OmidNativeSessionProvider(sdkModule.getStorageRepository()), adMeasurementVerificationResources, diagnosticReporter), null, 4, null);
        }
        return null;
    }
}
