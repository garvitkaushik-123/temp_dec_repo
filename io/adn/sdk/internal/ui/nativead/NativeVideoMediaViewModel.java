package io.adn.sdk.internal.ui.nativead;

import androidx.core.app.NotificationCompat;
import com.vungle.ads.internal.protos.Sdk;
import io.adn.sdk.internal.domain.model.ad.NativeAdAsset;
import io.adn.sdk.internal.domain.model.ad.PlaybackProgress;
import io.adn.sdk.internal.domain.model.ui.RenderingState;
import io.adn.sdk.internal.domain.model.ui.VideoState;
import io.adn.sdk.internal.domain.repository.AdVideoTracker;
import io.adn.sdk.internal.thirdparty.omsdk.VideoAdMeasurementController;
import io.adn.sdk.internal.ui.nativead.mapper.NativeAdUiMapperKt;
import io.adn.sdk.internal.ui.nativead.state.NativeAdVideoUiState;
import io.adn.sdk.internal.ui.utils.ViewVisibilityTracker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: NativeMediaViewModel.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u0016H\u0016J\"\u0010'\u001a\u00020\u00162\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100)¢\u0006\u0002\b*H\u0082\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006+"}, d2 = {"Lio/adn/sdk/internal/ui/nativead/NativeVideoMediaViewModel;", "Lio/adn/sdk/internal/ui/nativead/NativeMediaViewModel;", "asset", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Video;", "videoTracker", "Lio/adn/sdk/internal/domain/repository/AdVideoTracker;", "adMeasurementController", "Lio/adn/sdk/internal/thirdparty/omsdk/VideoAdMeasurementController;", "visibilityTracker", "Lio/adn/sdk/internal/ui/utils/ViewVisibilityTracker;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Video;Lio/adn/sdk/internal/domain/repository/AdVideoTracker;Lio/adn/sdk/internal/thirdparty/omsdk/VideoAdMeasurementController;Lio/adn/sdk/internal/ui/utils/ViewVisibilityTracker;)V", "getAsset", "()Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Video;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/adn/sdk/internal/ui/nativead/state/NativeAdVideoUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "onViewVisibilityChanged", "", "visiblePercent", "", "onViewDetached", "onVideoRendered", "onMuteToggle", "isMuted", "", "onPlayToggle", "shouldPlay", "onPlaybackStateChange", "state", "Lio/adn/sdk/internal/domain/model/ui/VideoState;", "onPlayerProgress", NotificationCompat.CATEGORY_PROGRESS, "Lio/adn/sdk/internal/domain/model/ad/PlaybackProgress;", "onClicked", "updateUiState", "update", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NativeVideoMediaViewModel extends NativeMediaViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<NativeAdVideoUiState> _uiState;
    private final VideoAdMeasurementController adMeasurementController;
    private final NativeAdAsset.Media.Video asset;
    private final StateFlow<NativeAdVideoUiState> uiState;
    private final AdVideoTracker videoTracker;

    public final NativeAdAsset.Media.Video getAsset() {
        return this.asset;
    }

    public /* synthetic */ NativeVideoMediaViewModel(NativeAdAsset.Media.Video video, AdVideoTracker adVideoTracker, VideoAdMeasurementController videoAdMeasurementController, ViewVisibilityTracker viewVisibilityTracker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(video, adVideoTracker, videoAdMeasurementController, (i & 8) != 0 ? new ViewVisibilityTracker(0L, null, 3, null) : viewVisibilityTracker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeVideoMediaViewModel(NativeAdAsset.Media.Video asset, AdVideoTracker videoTracker, VideoAdMeasurementController adMeasurementController, ViewVisibilityTracker visibilityTracker) {
        super(visibilityTracker, adMeasurementController, asset);
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(adMeasurementController, "adMeasurementController");
        Intrinsics.checkNotNullParameter(visibilityTracker, "visibilityTracker");
        this.asset = asset;
        this.videoTracker = videoTracker;
        this.adMeasurementController = adMeasurementController;
        MutableStateFlow<NativeAdVideoUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(NativeAdUiMapperKt.mapToNativeAdVideoUiState(asset));
        this._uiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<NativeAdVideoUiState> getUiState() {
        return this.uiState;
    }

    @Override // io.adn.sdk.internal.ui.nativead.NativeMediaViewModel
    protected void onViewVisibilityChanged(float visiblePercent) {
        NativeAdVideoUiState value;
        super.onViewVisibilityChanged(visiblePercent);
        MutableStateFlow<NativeAdVideoUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, NativeAdVideoUiState.copy$default(value, null, null, false, false, false, visiblePercent > 0.5f, 0L, 95, null)));
    }

    @Override // io.adn.sdk.internal.ui.nativead.NativeMediaViewModel
    public void onViewDetached() {
        NativeAdVideoUiState value;
        super.onViewDetached();
        MutableStateFlow<NativeAdVideoUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, NativeAdVideoUiState.copy$default(value, null, null, false, false, false, false, 0L, 79, null)));
    }

    public final void onVideoRendered() {
        setRenderingState(RenderingState.Success.INSTANCE);
    }

    public final void onPlaybackStateChange(VideoState state) {
        NativeAdVideoUiState value;
        NativeAdVideoUiState value2;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof VideoState.Paused) {
            MutableStateFlow<NativeAdVideoUiState> mutableStateFlow = this._uiState;
            do {
                value2 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value2, NativeAdVideoUiState.copy$default(value2, null, null, false, false, false, false, ((VideoState.Paused) state).getLastPosition(), 63, null)));
        }
        MutableStateFlow<NativeAdVideoUiState> mutableStateFlow2 = this._uiState;
        do {
            value = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value, NativeAdVideoUiState.copy$default(value, null, null, false, false, state instanceof VideoState.Playing, false, 0L, 111, null)));
    }

    public final void onPlayerProgress(PlaybackProgress progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        if (progress.getPercentage() > 0.0f) {
            setRenderingState(RenderingState.Success.INSTANCE);
            notifyMediaDisplayed();
        }
        this.videoTracker.trackProgress(progress);
        this.adMeasurementController.trackPlaybackProgress(progress);
    }

    @Override // io.adn.sdk.internal.ui.nativead.NativeMediaViewModel
    public void onClicked() {
        super.onClicked();
        this.adMeasurementController.trackAdClick();
    }

    private final void updateUiState(Function1<? super NativeAdVideoUiState, NativeAdVideoUiState> update) {
        NativeAdVideoUiState value;
        MutableStateFlow<NativeAdVideoUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, update.invoke(value)));
    }

    public final void onMuteToggle(boolean isMuted) {
        MutableStateFlow<NativeAdVideoUiState> mutableStateFlow = this._uiState;
        while (true) {
            NativeAdVideoUiState value = mutableStateFlow.getValue();
            boolean z = isMuted;
            if (mutableStateFlow.compareAndSet(value, NativeAdVideoUiState.copy$default(value, null, null, false, z, false, false, 0L, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, null))) {
                this.videoTracker.trackMuteState(z);
                this.adMeasurementController.trackMute(z);
                return;
            }
            isMuted = z;
        }
    }

    public final void onPlayToggle(boolean shouldPlay) {
        MutableStateFlow<NativeAdVideoUiState> mutableStateFlow = this._uiState;
        while (true) {
            NativeAdVideoUiState value = mutableStateFlow.getValue();
            boolean z = shouldPlay;
            if (mutableStateFlow.compareAndSet(value, NativeAdVideoUiState.copy$default(value, null, null, z, false, false, false, 0L, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, null))) {
                this.videoTracker.trackPlaybackState(z);
                this.adMeasurementController.trackPlaybackStateChange(z);
                return;
            }
            shouldPlay = z;
        }
    }
}
