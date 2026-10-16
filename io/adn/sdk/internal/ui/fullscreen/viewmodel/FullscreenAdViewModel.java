package io.adn.sdk.internal.ui.fullscreen.viewmodel;

import android.app.Activity;
import com.ironsource.C3207n2;
import io.adn.sdk.internal.common.model.Destroyable;
import io.adn.sdk.internal.data.service.ExternalLinkNavigator;
import io.adn.sdk.internal.domain.constants.Constants;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.ad.AdLink;
import io.adn.sdk.internal.domain.model.ad.ClickData;
import io.adn.sdk.internal.domain.model.ad.DismissOrigin;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEntity;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEvent;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.internal.domain.model.ui.RenderingState;
import io.adn.sdk.internal.domain.repository.AdTracker;
import io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdUiState;
import io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdUiStateKt;
import io.adn.sdk.internal.ui.fullscreen.model.OverlayMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: FullscreenAdViewModel.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001fH\u0002J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u00020/2\u0006\u00100\u001a\u000201J\u0006\u00103\u001a\u00020/J\u0010\u00104\u001a\u00020/2\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020/H\u0016J\u0018\u00108\u001a\u00020/2\u0006\u00105\u001a\u0002062\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020=2\u0006\u00109\u001a\u00020:H\u0002J\u0018\u0010>\u001a\u00020/2\u0006\u00105\u001a\u0002062\u0006\u0010?\u001a\u00020\u0019H\u0016J\u0010\u0010@\u001a\u00020/2\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020\u0007H\u0002J\u0010\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020\u0018H\u0002J\b\u0010H\u001a\u00020/H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020&0(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006I"}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenAdViewModel;", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenSceneListener;", "Lio/adn/sdk/internal/common/model/Destroyable;", "ad", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEntity;", "sceneViewModels", "", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenSceneViewModel;", "linkNavigator", "Lio/adn/sdk/internal/data/service/ExternalLinkNavigator;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "adTracker", "Lio/adn/sdk/internal/domain/repository/AdTracker;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEntity;Ljava/util/List;Lio/adn/sdk/internal/data/service/ExternalLinkNavigator;Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;Lio/adn/sdk/internal/domain/repository/AdTracker;Lkotlinx/coroutines/CoroutineScope;)V", "getSceneViewModels", "()Ljava/util/List;", "diagnosticAdShow", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$FullscreenAdShow;", "failedScenes", "Ljava/util/HashMap;", "", "Lio/adn/sdk/internal/domain/error/AdException;", "Lkotlin/collections/HashMap;", "isDismissHandled", "", "_adEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent;", "adEvent", "Lkotlinx/coroutines/flow/Flow;", "getAdEvent", "()Lkotlinx/coroutines/flow/Flow;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "emitAdEvent", "Lkotlinx/coroutines/Job;", "event", C3207n2.v, "", "activity", "Landroid/app/Activity;", "onActivityCreated", "onActivityDestroyed", "onSceneDisplayed", "scene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "onPrivacyPolicyClicked", "onSceneClicked", "clickData", "Lio/adn/sdk/internal/domain/model/ad/ClickData;", "handleClick", "link", "Lio/adn/sdk/internal/domain/model/ad/AdLink;", "onSceneError", "exception", "onSceneClose", "showScene", "sceneViewModel", "onAdDismiss", "origin", "Lio/adn/sdk/internal/domain/model/ad/DismissOrigin;", "notifyNextScenesOfAdClick", "currentSceneIndex", "destroy", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdViewModel implements FullscreenSceneListener, Destroyable {
    public static final int $stable = 8;
    private final MutableSharedFlow<FullscreenAdEvent> _adEvent;
    private final MutableStateFlow<FullscreenAdUiState> _uiState;
    private final FullscreenAdEntity ad;
    private final Flow<FullscreenAdEvent> adEvent;
    private final AdTracker adTracker;
    private final DiagnosticEventBuilder.FullscreenAdShow diagnosticAdShow;
    private final DiagnosticReporter diagnosticReporter;
    private final HashMap<Integer, AdException> failedScenes;
    private boolean isDismissHandled;
    private final ExternalLinkNavigator linkNavigator;
    private final List<FullscreenSceneViewModel> sceneViewModels;
    private final CoroutineScope scope;
    private final StateFlow<FullscreenAdUiState> uiState;

    /* JADX WARN: Multi-variable type inference failed */
    public FullscreenAdViewModel(FullscreenAdEntity ad, List<? extends FullscreenSceneViewModel> sceneViewModels, ExternalLinkNavigator linkNavigator, DiagnosticReporter diagnosticReporter, AdTracker adTracker, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(sceneViewModels, "sceneViewModels");
        Intrinsics.checkNotNullParameter(linkNavigator, "linkNavigator");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.ad = ad;
        this.sceneViewModels = sceneViewModels;
        this.linkNavigator = linkNavigator;
        this.diagnosticReporter = diagnosticReporter;
        this.adTracker = adTracker;
        this.scope = scope;
        this.diagnosticAdShow = new DiagnosticEventBuilder.FullscreenAdShow();
        this.failedScenes = new HashMap<>();
        MutableSharedFlow<FullscreenAdEvent> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._adEvent = MutableSharedFlow$default;
        this.adEvent = MutableSharedFlow$default;
        MutableStateFlow<FullscreenAdUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(new FullscreenAdUiState(0, 0L, 0, null, 15, null));
        this._uiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final List<FullscreenSceneViewModel> getSceneViewModels() {
        return this.sceneViewModels;
    }

    public /* synthetic */ FullscreenAdViewModel(FullscreenAdEntity fullscreenAdEntity, List list, ExternalLinkNavigator externalLinkNavigator, DiagnosticReporter diagnosticReporter, AdTracker adTracker, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fullscreenAdEntity, list, externalLinkNavigator, diagnosticReporter, adTracker, (i & 32) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()) : coroutineScope);
    }

    public final Flow<FullscreenAdEvent> getAdEvent() {
        return this.adEvent;
    }

    public final StateFlow<FullscreenAdUiState> getUiState() {
        return this.uiState;
    }

    private final Job emitAdEvent(FullscreenAdEvent event) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FullscreenAdViewModel$emitAdEvent$1(this, event, null), 3, null);
        return launch$default;
    }

    public final void show(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.diagnosticReporter.updateShowStartedDate();
        this.diagnosticReporter.reportStart(this.diagnosticAdShow);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FullscreenAdViewModel$show$1(activity, this, null), 3, null);
    }

    public final void onActivityCreated(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        for (FullscreenSceneViewModel fullscreenSceneViewModel : this.sceneViewModels) {
            fullscreenSceneViewModel.setListener(this);
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FullscreenAdViewModel$onActivityCreated$1$1(fullscreenSceneViewModel, activity, null), 3, null);
        }
        FullscreenSceneViewModel fullscreenSceneViewModel2 = (FullscreenSceneViewModel) CollectionsKt.firstOrNull((List) this.sceneViewModels);
        if (fullscreenSceneViewModel2 != null) {
            fullscreenSceneViewModel2.onShow();
        }
    }

    public final void onActivityDestroyed() {
        onAdDismiss(DismissOrigin.System);
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneListener
    public void onSceneDisplayed(FullscreenAdScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (this.adTracker.trackImpression(this.ad.getImpressionTrackers())) {
            emitAdEvent(FullscreenAdEvent.Impression.INSTANCE);
        }
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneListener
    public void onPrivacyPolicyClicked() {
        this.linkNavigator.open(Constants.DEFAULT_PRIVACY_URL);
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneListener
    public void onSceneClicked(FullscreenAdScene scene, ClickData clickData) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(clickData, "clickData");
        handleClick(scene.getLink(), clickData);
        notifyNextScenesOfAdClick(scene.getIndex());
    }

    private final void handleClick(AdLink link, ClickData clickData) {
        this.adTracker.trackClick(link, clickData);
        String url = link.getUrl();
        if (url != null) {
            this.linkNavigator.open(url);
        }
        emitAdEvent(FullscreenAdEvent.ClickThrough.INSTANCE);
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneListener
    public void onSceneError(FullscreenAdScene scene, AdException exception) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.failedScenes.put(Integer.valueOf(scene.getIndex()), exception);
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneListener
    public void onSceneClose(FullscreenAdScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        FullscreenSceneViewModel fullscreenSceneViewModel = (FullscreenSceneViewModel) CollectionsKt.getOrNull(this.sceneViewModels, scene.getIndex() + 1);
        if (fullscreenSceneViewModel == null) {
            onAdDismiss(DismissOrigin.User);
            return;
        }
        RenderingState renderingState = fullscreenSceneViewModel.getRenderingState();
        if (Intrinsics.areEqual(renderingState, RenderingState.Success.INSTANCE)) {
            showScene(fullscreenSceneViewModel);
        } else {
            this.diagnosticReporter.reportEvent(new DiagnosticEventBuilder.FullscreenSceneSkipped(fullscreenSceneViewModel.getScene(), renderingState));
            onSceneClose(fullscreenSceneViewModel.getScene());
        }
    }

    private final void showScene(FullscreenSceneViewModel sceneViewModel) {
        FullscreenAdUiState value;
        FullscreenAdUiState m9583copyRPmYEkk$default;
        sceneViewModel.onShow();
        FullscreenAdScene scene = sceneViewModel.getScene();
        OverlayMode overlayMode = FullscreenAdUiStateKt.toOverlayMode(scene.getConfig().getDisplayMode());
        MutableStateFlow<FullscreenAdUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            FullscreenAdUiState fullscreenAdUiState = value;
            if (overlayMode != OverlayMode.None) {
                m9583copyRPmYEkk$default = FullscreenAdUiState.m9583copyRPmYEkk$default(fullscreenAdUiState, 0, 0L, scene.getIndex(), overlayMode, 3, null);
            } else {
                m9583copyRPmYEkk$default = FullscreenAdUiState.m9583copyRPmYEkk$default(fullscreenAdUiState, scene.getIndex(), 0L, 0, null, 14, null);
            }
        } while (!mutableStateFlow.compareAndSet(value, m9583copyRPmYEkk$default));
    }

    private final void onAdDismiss(DismissOrigin origin) {
        if (this.isDismissHandled) {
            return;
        }
        this.isDismissHandled = true;
        this.diagnosticAdShow.updateCloseSourceProperty(origin);
        if (this.failedScenes.size() < this.ad.getScenes().size()) {
            this.diagnosticReporter.reportSuccess(this.diagnosticAdShow);
        } else {
            this.diagnosticReporter.reportFailure(this.diagnosticAdShow, new AdException(AdError.AdRenderingError, null, 2, null));
        }
        emitAdEvent(new FullscreenAdEvent.Dismiss(origin));
    }

    private final void notifyNextScenesOfAdClick(int currentSceneIndex) {
        int i = 0;
        for (Object obj : this.sceneViewModels) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            FullscreenSceneViewModel fullscreenSceneViewModel = (FullscreenSceneViewModel) obj;
            if (i > currentSceneIndex) {
                fullscreenSceneViewModel.onPeerSceneClicked();
            }
            i = i2;
        }
    }

    @Override // io.adn.sdk.internal.common.model.Destroyable
    public void destroy() {
        Iterator<T> it = this.sceneViewModels.iterator();
        while (it.hasNext()) {
            ((FullscreenSceneViewModel) it.next()).destroy();
        }
    }
}
