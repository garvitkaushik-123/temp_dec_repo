package io.adn.sdk.internal.ui.fullscreen.viewmodel;

import com.ironsource.C3040d4;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.model.ad.AdCloseConfig;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import io.adn.sdk.internal.domain.usecase.PrepareFullscreenSceneAssetsUseCase;
import io.adn.sdk.internal.ui.fullscreen.mapper.FullscreenAdUiMapperKt;
import io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState;
import io.adn.sdk.internal.ui.fullscreen.model.PromotedAppUiState;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: FullscreenPromotedAppCardViewModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenPromotedAppCardViewModel;", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenSceneViewModel;", "promotedAppCardScene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$PromotedAppCard;", "prepareAssetsUseCase", "Lio/adn/sdk/internal/domain/usecase/PrepareFullscreenSceneAssetsUseCase;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$PromotedAppCard;Lio/adn/sdk/internal/domain/usecase/PrepareFullscreenSceneAssetsUseCase;Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;)V", "sceneUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$PromotedAppCard;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "updateAssetState", "", "asset", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset;", "updateClickState", "updateErrorState", "updatePromotedAppState", C3040d4.h.b, "Ljava/io/File;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenPromotedAppCardViewModel extends FullscreenSceneViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<FullscreenAdSceneUiState.PromotedAppCard> sceneUiState;
    private final StateFlow<FullscreenAdSceneUiState.PromotedAppCard> uiState;

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel
    public void updateAssetState(SceneAsset asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenPromotedAppCardViewModel(FullscreenAdScene.PromotedAppCard promotedAppCardScene, PrepareFullscreenSceneAssetsUseCase prepareAssetsUseCase, DiagnosticReporter diagnosticReporter) {
        super(promotedAppCardScene, prepareAssetsUseCase, diagnosticReporter);
        Intrinsics.checkNotNullParameter(promotedAppCardScene, "promotedAppCardScene");
        Intrinsics.checkNotNullParameter(prepareAssetsUseCase, "prepareAssetsUseCase");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        MutableStateFlow<FullscreenAdSceneUiState.PromotedAppCard> MutableStateFlow = StateFlowKt.MutableStateFlow(FullscreenAdUiMapperKt.mapToFullscreenPromotedAppCardUiState(promotedAppCardScene));
        this.sceneUiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<FullscreenAdSceneUiState.PromotedAppCard> getUiState() {
        return this.uiState;
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel
    public void updateClickState() {
        FullscreenAdSceneUiState.PromotedAppCard value;
        FullscreenAdSceneUiState.PromotedAppCard promotedAppCard;
        MutableStateFlow<FullscreenAdSceneUiState.PromotedAppCard> mutableStateFlow = this.sceneUiState;
        do {
            value = mutableStateFlow.getValue();
            promotedAppCard = value;
        } while (!mutableStateFlow.compareAndSet(value, FullscreenAdSceneUiState.PromotedAppCard.m9579copyBx497Mc$default(promotedAppCard, null, AdCloseConfig.copy$default(promotedAppCard.getEffectiveCloseConfig(), null, 0, 1.0f, null, 0, 0, 59, null), 0, 0L, false, null, 61, null)));
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel
    public void updateErrorState() {
        FullscreenAdSceneUiState.PromotedAppCard value;
        FullscreenAdSceneUiState.PromotedAppCard promotedAppCard;
        MutableStateFlow<FullscreenAdSceneUiState.PromotedAppCard> mutableStateFlow = this.sceneUiState;
        do {
            value = mutableStateFlow.getValue();
            promotedAppCard = value;
        } while (!mutableStateFlow.compareAndSet(value, FullscreenAdSceneUiState.PromotedAppCard.m9579copyBx497Mc$default(promotedAppCard, null, AdCloseConfig.copy$default(promotedAppCard.getEffectiveCloseConfig(), null, 0, 1.0f, null, 0, 0, 57, null), 0, 0L, false, null, 61, null)));
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel
    public void updatePromotedAppState(File file) {
        FullscreenAdSceneUiState.PromotedAppCard value;
        FullscreenAdSceneUiState.PromotedAppCard promotedAppCard;
        Intrinsics.checkNotNullParameter(file, "file");
        MutableStateFlow<FullscreenAdSceneUiState.PromotedAppCard> mutableStateFlow = this.sceneUiState;
        do {
            value = mutableStateFlow.getValue();
            promotedAppCard = value;
        } while (!mutableStateFlow.compareAndSet(value, FullscreenAdSceneUiState.PromotedAppCard.m9579copyBx497Mc$default(promotedAppCard, PromotedAppUiState.copy$default(promotedAppCard.getPromotedAppUiState(), file, null, null, null, 14, null), null, 0, 0L, false, null, 62, null)));
    }
}
