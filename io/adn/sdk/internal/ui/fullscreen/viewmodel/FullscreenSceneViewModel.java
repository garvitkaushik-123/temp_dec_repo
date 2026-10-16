package io.adn.sdk.internal.ui.fullscreen.viewmodel;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.common.model.Destroyable;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.ad.AdPromotedApp;
import io.adn.sdk.internal.domain.model.ad.ClickData;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEntityKt;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.internal.domain.model.ui.RenderingState;
import io.adn.sdk.internal.domain.usecase.PrepareFullscreenSceneAssetsUseCase;
import io.adn.sdk.internal.ui.common.model.ClickPosition;
import io.adn.sdk.internal.ui.fullscreen.mapper.FullscreenAdUiMapperKt;
import io.adn.sdk.publisher.AdnClickElement;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenSceneViewModel.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000fJ\u0016\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010&\u001a\u00020 J\b\u0010'\u001a\u00020 H\u0002J\u0016\u0010(\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0082@¢\u0006\u0002\u0010%J\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0004J\u0006\u0010,\u001a\u00020 J\u0006\u0010-\u001a\u00020 J\u0006\u0010.\u001a\u00020 J$\u0010/\u001a\u00020 2\u0006\u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\b\b\u0002\u00104\u001a\u00020\u0011J\u000e\u00105\u001a\u00020 2\u0006\u00106\u001a\u000207J\u000e\u00105\u001a\u00020 2\u0006\u00106\u001a\u000208J\u0010\u00109\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020\u0011J\b\u0010;\u001a\u00020 H\u0002J\u0010\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020 H\u0016J\b\u0010@\u001a\u00020 H\u0016J\u0010\u0010A\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010B\u001a\u00020 H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenSceneViewModel;", "Lio/adn/sdk/internal/common/model/Destroyable;", "scene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "prepareAssetsUseCase", "Lio/adn/sdk/internal/domain/usecase/PrepareFullscreenSceneAssetsUseCase;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;Lio/adn/sdk/internal/domain/usecase/PrepareFullscreenSceneAssetsUseCase;Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;)V", "getScene", "()Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "getPrepareAssetsUseCase", "()Lio/adn/sdk/internal/domain/usecase/PrepareFullscreenSceneAssetsUseCase;", "sceneListener", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenSceneListener;", "adAlreadyClicked", "", "getAdAlreadyClicked", "()Z", "setAdAlreadyClicked", "(Z)V", "renderingState", "Lio/adn/sdk/internal/domain/model/ui/RenderingState;", "showTime", "", "Ljava/lang/Long;", "diagnosticSceneShow", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$FullscreenSceneShow;", "diagnosticAdClick", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$FullscreenAdClick;", "setListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "loadScene", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPeerSceneClicked", "loadPromotedAppAssets", "loadSceneAssets", "onLoadSceneSuccess", "asset", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset;", "onShow", "onDisplayed", "onPrivacyPolicyClicked", "onClicked", "element", "Lio/adn/sdk/publisher/AdnClickElement;", "clickPosition", "Lio/adn/sdk/internal/ui/common/model/ClickPosition;", "isUserInitiated", "onError", "error", "", "Lio/adn/sdk/internal/domain/error/AdException;", "onClose", "autoClose", "checkAndUpdateClickState", "updatePromotedAppState", C3040d4.h.b, "Ljava/io/File;", "updateClickState", "updateErrorState", "updateAssetState", "destroy", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public class FullscreenSceneViewModel implements Destroyable {
    public static final int $stable = 8;
    private boolean adAlreadyClicked;
    private final DiagnosticEventBuilder.FullscreenAdClick diagnosticAdClick;
    private final DiagnosticReporter diagnosticReporter;
    private final DiagnosticEventBuilder.FullscreenSceneShow diagnosticSceneShow;
    private final PrepareFullscreenSceneAssetsUseCase prepareAssetsUseCase;
    private RenderingState renderingState;
    private final FullscreenAdScene scene;
    private FullscreenSceneListener sceneListener;
    private Long showTime;

    public Object loadScene(Activity activity, Continuation<? super Unit> continuation) {
        return loadScene$suspendImpl(this, activity, continuation);
    }

    public void updateAssetState(SceneAsset asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
    }

    public void updateClickState() {
    }

    public void updateErrorState() {
    }

    public void updatePromotedAppState(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
    }

    public FullscreenSceneViewModel(FullscreenAdScene scene, PrepareFullscreenSceneAssetsUseCase prepareAssetsUseCase, DiagnosticReporter diagnosticReporter) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(prepareAssetsUseCase, "prepareAssetsUseCase");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        this.scene = scene;
        this.prepareAssetsUseCase = prepareAssetsUseCase;
        this.diagnosticReporter = diagnosticReporter;
        this.renderingState = RenderingState.Progress.INSTANCE;
        this.diagnosticSceneShow = new DiagnosticEventBuilder.FullscreenSceneShow(scene);
        this.diagnosticAdClick = new DiagnosticEventBuilder.FullscreenAdClick(scene);
    }

    public final FullscreenAdScene getScene() {
        return this.scene;
    }

    protected final PrepareFullscreenSceneAssetsUseCase getPrepareAssetsUseCase() {
        return this.prepareAssetsUseCase;
    }

    protected final boolean getAdAlreadyClicked() {
        return this.adAlreadyClicked;
    }

    protected final void setAdAlreadyClicked(boolean z) {
        this.adAlreadyClicked = z;
    }

    public final void setListener(FullscreenSceneListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.sceneListener = listener;
    }

    static /* synthetic */ Object loadScene$suspendImpl(FullscreenSceneViewModel fullscreenSceneViewModel, Activity activity, Continuation<? super Unit> continuation) {
        fullscreenSceneViewModel.loadPromotedAppAssets();
        Object loadSceneAssets = fullscreenSceneViewModel.loadSceneAssets(activity, continuation);
        return loadSceneAssets == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? loadSceneAssets : Unit.INSTANCE;
    }

    /* renamed from: renderingState, reason: from getter */
    public final RenderingState getRenderingState() {
        return this.renderingState;
    }

    public final void onPeerSceneClicked() {
        checkAndUpdateClickState();
    }

    private final void loadPromotedAppAssets() {
        File loadPromotedAppAsset;
        AdPromotedApp promotedApp = this.scene.getPromotedApp();
        if (promotedApp == null || (loadPromotedAppAsset = this.prepareAssetsUseCase.loadPromotedAppAsset(promotedApp)) == null) {
            return;
        }
        updatePromotedAppState(loadPromotedAppAsset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadSceneAssets(Activity activity, Continuation<? super Unit> continuation) {
        FullscreenSceneViewModel$loadSceneAssets$1 fullscreenSceneViewModel$loadSceneAssets$1;
        int i;
        Object m9510loadSceneAsset0E7RQCE;
        FullscreenSceneViewModel fullscreenSceneViewModel;
        Throwable m10244exceptionOrNullimpl;
        if (continuation instanceof FullscreenSceneViewModel$loadSceneAssets$1) {
            fullscreenSceneViewModel$loadSceneAssets$1 = (FullscreenSceneViewModel$loadSceneAssets$1) continuation;
            if ((fullscreenSceneViewModel$loadSceneAssets$1.label & Integer.MIN_VALUE) != 0) {
                fullscreenSceneViewModel$loadSceneAssets$1.label -= Integer.MIN_VALUE;
                Object obj = fullscreenSceneViewModel$loadSceneAssets$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fullscreenSceneViewModel$loadSceneAssets$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    PrepareFullscreenSceneAssetsUseCase prepareFullscreenSceneAssetsUseCase = this.prepareAssetsUseCase;
                    FullscreenAdScene fullscreenAdScene = this.scene;
                    fullscreenSceneViewModel$loadSceneAssets$1.L$0 = this;
                    fullscreenSceneViewModel$loadSceneAssets$1.label = 1;
                    m9510loadSceneAsset0E7RQCE = prepareFullscreenSceneAssetsUseCase.m9510loadSceneAsset0E7RQCE(activity, fullscreenAdScene, fullscreenSceneViewModel$loadSceneAssets$1);
                    if (m9510loadSceneAsset0E7RQCE == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    fullscreenSceneViewModel = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    fullscreenSceneViewModel = (FullscreenSceneViewModel) fullscreenSceneViewModel$loadSceneAssets$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    m9510loadSceneAsset0E7RQCE = ((Result) obj).getValue();
                }
                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m9510loadSceneAsset0E7RQCE);
                if (m10244exceptionOrNullimpl != null) {
                    fullscreenSceneViewModel.onLoadSceneSuccess((SceneAsset) m9510loadSceneAsset0E7RQCE);
                } else {
                    Logger.INSTANCE.e("FullscreenSceneViewModel", m10244exceptionOrNullimpl);
                    fullscreenSceneViewModel.onError(new AdException(AdError.AssetDownloadError, null, 2, null));
                }
                return Unit.INSTANCE;
            }
        }
        fullscreenSceneViewModel$loadSceneAssets$1 = new FullscreenSceneViewModel$loadSceneAssets$1(this, continuation);
        Object obj2 = fullscreenSceneViewModel$loadSceneAssets$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fullscreenSceneViewModel$loadSceneAssets$1.label;
        if (i != 0) {
        }
        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m9510loadSceneAsset0E7RQCE);
        if (m10244exceptionOrNullimpl != null) {
        }
        return Unit.INSTANCE;
    }

    protected final void onLoadSceneSuccess(SceneAsset asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        this.renderingState = RenderingState.Success.INSTANCE;
        updateAssetState(asset);
    }

    public final void onShow() {
        this.showTime = Long.valueOf(System.currentTimeMillis());
        this.diagnosticReporter.reportStart(this.diagnosticSceneShow);
    }

    public final void onDisplayed() {
        FullscreenSceneListener fullscreenSceneListener = this.sceneListener;
        if (fullscreenSceneListener != null) {
            fullscreenSceneListener.onSceneDisplayed(this.scene);
        }
    }

    public final void onPrivacyPolicyClicked() {
        FullscreenSceneListener fullscreenSceneListener = this.sceneListener;
        if (fullscreenSceneListener != null) {
            fullscreenSceneListener.onPrivacyPolicyClicked();
        }
    }

    public static /* synthetic */ void onClicked$default(FullscreenSceneViewModel fullscreenSceneViewModel, AdnClickElement adnClickElement, ClickPosition clickPosition, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onClicked");
        }
        if ((i & 2) != 0) {
            clickPosition = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        fullscreenSceneViewModel.onClicked(adnClickElement, clickPosition, z);
    }

    public final void onClicked(AdnClickElement element, ClickPosition clickPosition, boolean isUserInitiated) {
        Intrinsics.checkNotNullParameter(element, "element");
        ClickData mapToClickData$default = FullscreenAdUiMapperKt.mapToClickData$default(this.scene.getId(), FullscreenAdEntityKt.creativeAnalyticsType(this.scene), element, clickPosition, !isUserInitiated, false, this.showTime, 32, null);
        FullscreenSceneListener fullscreenSceneListener = this.sceneListener;
        if (fullscreenSceneListener != null) {
            fullscreenSceneListener.onSceneClicked(this.scene, mapToClickData$default);
        }
        checkAndUpdateClickState();
        this.diagnosticAdClick.updateElementIdProperty(element);
        this.diagnosticReporter.reportEvent(this.diagnosticAdClick);
    }

    public final void onError(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        onError(new AdException(AdError.AssetRenderingError, error));
    }

    public final void onError(AdException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.renderingState = new RenderingState.Failure(error);
        updateErrorState();
        FullscreenSceneListener fullscreenSceneListener = this.sceneListener;
        if (fullscreenSceneListener != null) {
            fullscreenSceneListener.onSceneError(this.scene, error);
        }
    }

    public static /* synthetic */ void onClose$default(FullscreenSceneViewModel fullscreenSceneViewModel, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onClose");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        fullscreenSceneViewModel.onClose(z);
    }

    public final void onClose(boolean autoClose) {
        this.diagnosticSceneShow.updateAutoCloseProperty(autoClose);
        RenderingState renderingState = this.renderingState;
        if (renderingState instanceof RenderingState.Failure) {
            this.diagnosticReporter.reportFailure(this.diagnosticSceneShow, ((RenderingState.Failure) renderingState).getException());
        } else if (Intrinsics.areEqual(renderingState, RenderingState.Success.INSTANCE)) {
            this.diagnosticReporter.reportSuccess(this.diagnosticSceneShow);
        }
        FullscreenSceneListener fullscreenSceneListener = this.sceneListener;
        if (fullscreenSceneListener != null) {
            fullscreenSceneListener.onSceneClose(this.scene);
        }
        this.sceneListener = null;
    }

    private final void checkAndUpdateClickState() {
        if (this.adAlreadyClicked) {
            return;
        }
        this.adAlreadyClicked = true;
        updateClickState();
    }

    @Override // io.adn.sdk.internal.common.model.Destroyable
    public void destroy() {
        this.sceneListener = null;
        this.prepareAssetsUseCase.clearSceneAssets(this.scene);
    }
}
