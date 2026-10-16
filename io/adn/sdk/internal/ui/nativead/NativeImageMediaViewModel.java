package io.adn.sdk.internal.ui.nativead;

import io.adn.sdk.internal.domain.model.ad.NativeAdAsset;
import io.adn.sdk.internal.domain.model.ui.RenderingState;
import io.adn.sdk.internal.domain.repository.AdMeasurementController;
import io.adn.sdk.internal.ui.nativead.mapper.NativeAdUiMapperKt;
import io.adn.sdk.internal.ui.nativead.state.NativeAdImageUiState;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\"\u0010\u001b\u001a\u00020\u00142\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001d¢\u0006\u0002\b\u001eH\u0082\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lio/adn/sdk/internal/ui/nativead/NativeImageMediaViewModel;", "Lio/adn/sdk/internal/ui/nativead/NativeMediaViewModel;", "asset", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Image;", "adMeasurementController", "Lio/adn/sdk/internal/domain/repository/AdMeasurementController;", "visibilityTracker", "Lio/adn/sdk/internal/ui/utils/ViewVisibilityTracker;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Image;Lio/adn/sdk/internal/domain/repository/AdMeasurementController;Lio/adn/sdk/internal/ui/utils/ViewVisibilityTracker;)V", "getAsset", "()Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Image;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/adn/sdk/internal/ui/nativead/state/NativeAdImageUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "onImageRendered", "", "onError", "error", "", "onViewVisibilityChanged", "visiblePercent", "", "updateUiState", "update", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NativeImageMediaViewModel extends NativeMediaViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<NativeAdImageUiState> _uiState;
    private final NativeAdAsset.Media.Image asset;
    private final StateFlow<NativeAdImageUiState> uiState;

    public final NativeAdAsset.Media.Image getAsset() {
        return this.asset;
    }

    public /* synthetic */ NativeImageMediaViewModel(NativeAdAsset.Media.Image image, AdMeasurementController adMeasurementController, ViewVisibilityTracker viewVisibilityTracker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(image, adMeasurementController, (i & 4) != 0 ? new ViewVisibilityTracker(0L, null, 3, null) : viewVisibilityTracker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeImageMediaViewModel(NativeAdAsset.Media.Image asset, AdMeasurementController adMeasurementController, ViewVisibilityTracker visibilityTracker) {
        super(visibilityTracker, adMeasurementController, asset);
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adMeasurementController, "adMeasurementController");
        Intrinsics.checkNotNullParameter(visibilityTracker, "visibilityTracker");
        this.asset = asset;
        MutableStateFlow<NativeAdImageUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(NativeAdUiMapperKt.mapToNativeAdImageUiState(asset));
        this._uiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<NativeAdImageUiState> getUiState() {
        return this.uiState;
    }

    public final void onImageRendered() {
        setRenderingState(RenderingState.Success.INSTANCE);
    }

    @Override // io.adn.sdk.internal.ui.nativead.NativeMediaViewModel
    public void onError(String error) {
        NativeAdImageUiState value;
        Intrinsics.checkNotNullParameter(error, "error");
        super.onError(error);
        MutableStateFlow<NativeAdImageUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, NativeAdImageUiState.copy$default(value, null, this.asset.getUrl(), 1, null)));
    }

    @Override // io.adn.sdk.internal.ui.nativead.NativeMediaViewModel
    protected void onViewVisibilityChanged(float visiblePercent) {
        super.onViewVisibilityChanged(visiblePercent);
        if (visiblePercent > 0.01f) {
            notifyMediaDisplayed();
        }
    }

    private final void updateUiState(Function1<? super NativeAdImageUiState, NativeAdImageUiState> update) {
        NativeAdImageUiState value;
        MutableStateFlow<NativeAdImageUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, update.invoke(value)));
    }
}
