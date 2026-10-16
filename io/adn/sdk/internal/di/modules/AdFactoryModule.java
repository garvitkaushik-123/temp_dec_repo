package io.adn.sdk.internal.di.modules;

import android.app.Activity;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.handler.FullscreenAdHandler;
import io.adn.sdk.internal.domain.handler.NativeAdHandler;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEntity;
import io.adn.sdk.internal.domain.model.ad.NativeAdEntity;
import io.adn.sdk.internal.domain.repository.BidFetcherRepository;
import io.adn.sdk.internal.domain.repository.FullscreenAdLoader;
import io.adn.sdk.internal.domain.repository.NativeAdLoader;
import io.adn.sdk.internal.domain.usecase.FetchBidResponseUseCase;
import io.adn.sdk.internal.domain.usecase.GetBidTokenUseCase;
import io.adn.sdk.internal.domain.usecase.LoadFullscreenAdUseCase;
import io.adn.sdk.internal.domain.usecase.LoadNativeAdAssetsUseCase;
import io.adn.sdk.internal.domain.usecase.LoadNativeAdMetadataUseCase;
import io.adn.sdk.internal.domain.usecase.PostInitializationUseCase;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenAdViewModel;
import io.adn.sdk.internal.ui.nativead.NativeAdViewModel;
import io.adn.sdk.publisher.AdnAdPlacement;
import io.adn.sdk.publisher.inappbrowser.AdnInAppBrowserLauncher;
import kotlin.Metadata;

/* compiled from: AdFactoryModule.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020!H&J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020!H&J\b\u0010$\u001a\u00020%H&¨\u0006&"}, d2 = {"Lio/adn/sdk/internal/di/modules/AdFactoryModule;", "", "createFullscreenAd", "Lio/adn/sdk/internal/domain/handler/FullscreenAdHandler;", "activity", "Landroid/app/Activity;", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "createNativeAd", "Lio/adn/sdk/internal/domain/handler/NativeAdHandler;", "createFullscreenAdViewModel", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenAdViewModel;", "ad", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEntity;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "createNativeAdViewModel", "Lio/adn/sdk/internal/ui/nativead/NativeAdViewModel;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "inAppBrowserLauncher", "Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowserLauncher;", "getBidTokenUseCase", "Lio/adn/sdk/internal/domain/usecase/GetBidTokenUseCase;", "loadFullscreenAdUseCase", "Lio/adn/sdk/internal/domain/usecase/LoadFullscreenAdUseCase;", "adLoader", "Lio/adn/sdk/internal/domain/repository/FullscreenAdLoader;", "fetchBidResponseUseCase", "Lio/adn/sdk/internal/domain/usecase/FetchBidResponseUseCase;", "bidFetcherRepository", "Lio/adn/sdk/internal/domain/repository/BidFetcherRepository;", "loadNativeAdUseCase", "Lio/adn/sdk/internal/domain/usecase/LoadNativeAdAssetsUseCase;", "Lio/adn/sdk/internal/domain/repository/NativeAdLoader;", "loadNativeAdMetadataUseCase", "Lio/adn/sdk/internal/domain/usecase/LoadNativeAdMetadataUseCase;", "postInitializationUseCase", "Lio/adn/sdk/internal/domain/usecase/PostInitializationUseCase;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdFactoryModule {
    FullscreenAdHandler createFullscreenAd(Activity activity, AdnAdPlacement placement);

    FullscreenAdViewModel createFullscreenAdViewModel(Activity activity, FullscreenAdEntity ad, DiagnosticReporter diagnosticReporter);

    NativeAdHandler createNativeAd(Activity activity);

    NativeAdViewModel createNativeAdViewModel(Activity activity, NativeAdEntity ad, AdnInAppBrowserLauncher inAppBrowserLauncher, DiagnosticReporter diagnosticReporter);

    FetchBidResponseUseCase fetchBidResponseUseCase(BidFetcherRepository bidFetcherRepository, DiagnosticReporter diagnosticReporter);

    GetBidTokenUseCase getBidTokenUseCase(AdnAdPlacement placement);

    LoadFullscreenAdUseCase loadFullscreenAdUseCase(FullscreenAdLoader adLoader, DiagnosticReporter diagnosticReporter);

    LoadNativeAdMetadataUseCase loadNativeAdMetadataUseCase(NativeAdLoader adLoader);

    LoadNativeAdAssetsUseCase loadNativeAdUseCase(NativeAdLoader adLoader);

    PostInitializationUseCase postInitializationUseCase();
}
