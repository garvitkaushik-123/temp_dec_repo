package io.adn.sdk.internal.ui.fullscreen.viewmodel;

import androidx.core.app.NotificationCompat;
import com.ironsource.C3040d4;
import com.vungle.ads.internal.protos.Sdk;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.model.ad.AdCloseConfig;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.ad.PlaybackProgress;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import io.adn.sdk.internal.domain.model.ui.VideoState;
import io.adn.sdk.internal.domain.repository.AdVideoTracker;
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

/* compiled from: FullscreenSceneVideoViewModel.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenVideoSceneViewModel;", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenSceneViewModel;", "videoScene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$Video;", "prepareAssetsUseCase", "Lio/adn/sdk/internal/domain/usecase/PrepareFullscreenSceneAssetsUseCase;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "videoTracker", "Lio/adn/sdk/internal/domain/repository/AdVideoTracker;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$Video;Lio/adn/sdk/internal/domain/usecase/PrepareFullscreenSceneAssetsUseCase;Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;Lio/adn/sdk/internal/domain/repository/AdVideoTracker;)V", "sceneUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$Video;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "onPlayerProgress", "", NotificationCompat.CATEGORY_PROGRESS, "Lio/adn/sdk/internal/domain/model/ad/PlaybackProgress;", "onPlaybackStateChange", "state", "Lio/adn/sdk/internal/domain/model/ui/VideoState;", "canAutoClose", "", "onMuteToggle", "isMuted", "updateAssetState", "asset", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset;", "updateClickState", "updateErrorState", "updatePromotedAppState", C3040d4.h.b, "Ljava/io/File;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenVideoSceneViewModel extends FullscreenSceneViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<FullscreenAdSceneUiState.Video> sceneUiState;
    private final StateFlow<FullscreenAdSceneUiState.Video> uiState;
    private final FullscreenAdScene.Video videoScene;
    private final AdVideoTracker videoTracker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenVideoSceneViewModel(FullscreenAdScene.Video videoScene, PrepareFullscreenSceneAssetsUseCase prepareAssetsUseCase, DiagnosticReporter diagnosticReporter, AdVideoTracker adVideoTracker) {
        super(videoScene, prepareAssetsUseCase, diagnosticReporter);
        Intrinsics.checkNotNullParameter(videoScene, "videoScene");
        Intrinsics.checkNotNullParameter(prepareAssetsUseCase, "prepareAssetsUseCase");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        this.videoScene = videoScene;
        this.videoTracker = adVideoTracker;
        MutableStateFlow<FullscreenAdSceneUiState.Video> MutableStateFlow = StateFlowKt.MutableStateFlow(FullscreenAdUiMapperKt.mapToFullscreenVideoSceneUiState(videoScene));
        this.sceneUiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<FullscreenAdSceneUiState.Video> getUiState() {
        return this.uiState;
    }

    public final void onPlayerProgress(PlaybackProgress progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        AdVideoTracker adVideoTracker = this.videoTracker;
        if (adVideoTracker != null) {
            adVideoTracker.trackProgress(progress);
        }
    }

    public final void onPlaybackStateChange(VideoState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (Intrinsics.areEqual(state, VideoState.Finished.INSTANCE) && canAutoClose()) {
            onClose(true);
        }
    }

    private final boolean canAutoClose() {
        return getAdAlreadyClicked() || this.videoScene.getConfig().getAutoCloseEnabled();
    }

    public final void onMuteToggle(boolean isMuted) {
        AdVideoTracker adVideoTracker = this.videoTracker;
        if (adVideoTracker != null) {
            adVideoTracker.trackMuteState(isMuted);
        }
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel
    public void updateAssetState(SceneAsset asset) {
        FullscreenAdSceneUiState.Video value;
        Intrinsics.checkNotNullParameter(asset, "asset");
        MutableStateFlow<FullscreenAdSceneUiState.Video> mutableStateFlow = this.sceneUiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, FullscreenAdSceneUiState.Video.copy$default(value, null, null, 0, false, asset instanceof SceneAsset.Media ? (SceneAsset.Media) asset : null, false, null, 111, null)));
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel
    public void updateClickState() {
        FullscreenAdSceneUiState.Video value;
        FullscreenAdSceneUiState.Video video;
        MutableStateFlow<FullscreenAdSceneUiState.Video> mutableStateFlow = this.sceneUiState;
        do {
            value = mutableStateFlow.getValue();
            video = value;
        } while (!mutableStateFlow.compareAndSet(value, FullscreenAdSceneUiState.Video.copy$default(video, null, AdCloseConfig.copy$default(video.getEffectiveCloseConfig(), null, 0, 1.0f, null, 0, 0, 59, null), 0, false, null, false, null, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, null)));
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel
    public void updateErrorState() {
        FullscreenAdSceneUiState.Video value;
        FullscreenAdSceneUiState.Video video;
        MutableStateFlow<FullscreenAdSceneUiState.Video> mutableStateFlow = this.sceneUiState;
        do {
            value = mutableStateFlow.getValue();
            video = value;
        } while (!mutableStateFlow.compareAndSet(value, FullscreenAdSceneUiState.Video.copy$default(video, null, AdCloseConfig.copy$default(video.getEffectiveCloseConfig(), null, 0, 1.0f, null, 0, 0, 57, null), 0, false, null, false, null, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, null)));
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel
    public void updatePromotedAppState(File file) {
        File file2;
        PromotedAppUiState promotedAppUiState;
        Intrinsics.checkNotNullParameter(file, "file");
        MutableStateFlow<FullscreenAdSceneUiState.Video> mutableStateFlow = this.sceneUiState;
        while (true) {
            FullscreenAdSceneUiState.Video value = mutableStateFlow.getValue();
            FullscreenAdSceneUiState.Video video = value;
            PromotedAppUiState promotedAppUiState2 = video.getPromotedAppUiState();
            if (promotedAppUiState2 != null) {
                File file3 = file;
                promotedAppUiState = PromotedAppUiState.copy$default(promotedAppUiState2, file3, null, null, null, 14, null);
                file2 = file3;
            } else {
                file2 = file;
                promotedAppUiState = null;
            }
            if (mutableStateFlow.compareAndSet(value, FullscreenAdSceneUiState.Video.copy$default(video, promotedAppUiState, null, 0, false, null, false, null, 126, null))) {
                return;
            } else {
                file = file2;
            }
        }
    }
}
