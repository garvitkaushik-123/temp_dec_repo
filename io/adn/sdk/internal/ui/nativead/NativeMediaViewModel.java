package io.adn.sdk.internal.ui.nativead;

import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3061e8;
import com.mbridge.msdk.MBridgeConstans;
import io.adn.sdk.internal.common.model.Destroyable;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.ad.NativeAdAsset;
import io.adn.sdk.internal.domain.model.ad.NativeAdEntityKt;
import io.adn.sdk.internal.domain.model.ui.RenderingState;
import io.adn.sdk.internal.domain.repository.AdMeasurementController;
import io.adn.sdk.internal.ui.utils.ViewVisibilityTracker;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeMediaViewModel.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eJ\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u0016H\u0004J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0016H\u0016J\b\u0010'\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lio/adn/sdk/internal/ui/nativead/NativeMediaViewModel;", "Lio/adn/sdk/internal/common/model/Destroyable;", "visibilityTracker", "Lio/adn/sdk/internal/ui/utils/ViewVisibilityTracker;", "adMeasurementController", "Lio/adn/sdk/internal/domain/repository/AdMeasurementController;", "asset", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media;", "<init>", "(Lio/adn/sdk/internal/ui/utils/ViewVisibilityTracker;Lio/adn/sdk/internal/domain/repository/AdMeasurementController;Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media;)V", "mediaDisplayedNotified", "", "lastIsVisible", "mediaListener", "Lio/adn/sdk/internal/ui/nativead/NativeAdMediaListener;", "renderingState", "Lio/adn/sdk/internal/domain/model/ui/RenderingState;", "getRenderingState", "()Lio/adn/sdk/internal/domain/model/ui/RenderingState;", "setRenderingState", "(Lio/adn/sdk/internal/domain/model/ui/RenderingState;)V", "createAndLoadAdMeasurementSession", "", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onViewVisibilityChanged", "visiblePercent", "", "onViewAttached", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "onViewDetached", "notifyMediaDisplayed", "notifyMediaVisibilityChange", C3061e8.k, "onError", "error", "", "onClicked", "destroy", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public class NativeMediaViewModel implements Destroyable {
    public static final int $stable = 8;
    private final AdMeasurementController adMeasurementController;
    private final NativeAdAsset.Media asset;
    private boolean lastIsVisible;
    private boolean mediaDisplayedNotified;
    private NativeAdMediaListener mediaListener;
    private RenderingState renderingState;
    private final ViewVisibilityTracker visibilityTracker;

    public void onClicked() {
    }

    public NativeMediaViewModel(ViewVisibilityTracker visibilityTracker, AdMeasurementController adMeasurementController, NativeAdAsset.Media asset) {
        Intrinsics.checkNotNullParameter(visibilityTracker, "visibilityTracker");
        Intrinsics.checkNotNullParameter(adMeasurementController, "adMeasurementController");
        Intrinsics.checkNotNullParameter(asset, "asset");
        this.visibilityTracker = visibilityTracker;
        this.adMeasurementController = adMeasurementController;
        this.asset = asset;
        this.renderingState = RenderingState.Progress.INSTANCE;
        createAndLoadAdMeasurementSession();
    }

    protected final RenderingState getRenderingState() {
        return this.renderingState;
    }

    protected final void setRenderingState(RenderingState renderingState) {
        Intrinsics.checkNotNullParameter(renderingState, "<set-?>");
        this.renderingState = renderingState;
    }

    private final void createAndLoadAdMeasurementSession() {
        String analyticsType = NativeAdEntityKt.toAnalyticsType(this.asset);
        this.adMeasurementController.createAdSession(analyticsType);
        this.adMeasurementController.startAdSession(analyticsType);
        this.adMeasurementController.trackAdLoad();
    }

    public final void setListener(NativeAdMediaListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mediaListener = listener;
    }

    protected void onViewVisibilityChanged(float visiblePercent) {
        notifyMediaVisibilityChange(visiblePercent > 0.01f);
    }

    public final void onViewAttached(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.adMeasurementController.registerAdSessionView(view);
        this.visibilityTracker.start(view, new Function1() { // from class: io.adn.sdk.internal.ui.nativead.NativeMediaViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit onViewAttached$lambda$0;
                onViewAttached$lambda$0 = NativeMediaViewModel.onViewAttached$lambda$0(NativeMediaViewModel.this, ((Float) obj).floatValue());
                return onViewAttached$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewAttached$lambda$0(NativeMediaViewModel nativeMediaViewModel, float f) {
        nativeMediaViewModel.onViewVisibilityChanged(f);
        return Unit.INSTANCE;
    }

    public void onViewDetached() {
        this.visibilityTracker.stop();
        notifyMediaVisibilityChange(false);
    }

    protected final void notifyMediaDisplayed() {
        if (this.mediaDisplayedNotified || !(this.renderingState instanceof RenderingState.Success)) {
            return;
        }
        this.mediaDisplayedNotified = true;
        NativeAdMediaListener nativeAdMediaListener = this.mediaListener;
        if (nativeAdMediaListener != null) {
            nativeAdMediaListener.onMediaDisplayed();
        }
        this.adMeasurementController.trackImpression();
    }

    private final void notifyMediaVisibilityChange(boolean isVisible) {
        if (isVisible != this.lastIsVisible) {
            this.lastIsVisible = isVisible;
            NativeAdMediaListener nativeAdMediaListener = this.mediaListener;
            if (nativeAdMediaListener != null) {
                nativeAdMediaListener.onMediaVisibilityChange(isVisible, this.renderingState);
            }
        }
    }

    public void onError(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.renderingState = new RenderingState.Failure(new AdException(AdError.AssetRenderingError, error));
    }

    @Override // io.adn.sdk.internal.common.model.Destroyable
    public void destroy() {
        try {
            Result.Companion companion = Result.INSTANCE;
            NativeMediaViewModel nativeMediaViewModel = this;
            this.visibilityTracker.destroy();
            this.adMeasurementController.stopSession();
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }
}
