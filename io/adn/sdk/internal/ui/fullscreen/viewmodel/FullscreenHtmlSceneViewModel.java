package io.adn.sdk.internal.ui.fullscreen.viewmodel;

import android.app.Activity;
import com.ironsource.C3040d4;
import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.ad.AdCloseConfig;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import io.adn.sdk.internal.domain.usecase.PrepareFullscreenSceneAssetsUseCase;
import io.adn.sdk.internal.ui.common.mraid.MraidController;
import io.adn.sdk.internal.ui.fullscreen.mapper.FullscreenAdUiMapperKt;
import io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState;
import io.adn.sdk.internal.ui.fullscreen.model.PromotedAppUiState;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: FullscreenSceneHtmlViewModel.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\u0014H\u0016J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006("}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenHtmlSceneViewModel;", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenSceneViewModel;", "htmlScene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$Html;", "prepareAssetsUseCase", "Lio/adn/sdk/internal/domain/usecase/PrepareFullscreenSceneAssetsUseCase;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene$Html;Lio/adn/sdk/internal/domain/usecase/PrepareFullscreenSceneAssetsUseCase;Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;)V", "mraidController", "Lio/adn/sdk/internal/ui/common/mraid/MraidController;", "sceneUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$Html;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadScene", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadSceneAsset", "asset", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Html;", "(Landroid/app/Activity;Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Html;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLoadingCardVisibility", VastAttributes.VISIBLE, "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAssetState", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset;", "updateClickState", "updateErrorState", "updatePromotedAppState", C3040d4.h.b, "Ljava/io/File;", "destroy", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenHtmlSceneViewModel extends FullscreenSceneViewModel {
    public static final int $stable = 8;
    private final FullscreenAdScene.Html htmlScene;
    private MraidController mraidController;
    private final MutableStateFlow<FullscreenAdSceneUiState.Html> sceneUiState;
    private final StateFlow<FullscreenAdSceneUiState.Html> uiState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenHtmlSceneViewModel(FullscreenAdScene.Html htmlScene, PrepareFullscreenSceneAssetsUseCase prepareAssetsUseCase, DiagnosticReporter diagnosticReporter) {
        super(htmlScene, prepareAssetsUseCase, diagnosticReporter);
        Intrinsics.checkNotNullParameter(htmlScene, "htmlScene");
        Intrinsics.checkNotNullParameter(prepareAssetsUseCase, "prepareAssetsUseCase");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        this.htmlScene = htmlScene;
        MutableStateFlow<FullscreenAdSceneUiState.Html> MutableStateFlow = StateFlowKt.MutableStateFlow(FullscreenAdUiMapperKt.mapToFullscreenHtmlSceneUiState(htmlScene));
        this.sceneUiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<FullscreenAdSceneUiState.Html> getUiState() {
        return this.uiState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0096, code lost:
    
        if (r2.loadSceneAsset(r8, (io.adn.sdk.internal.domain.model.ad.SceneAsset.Html) r9, r0) == r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
    
        if (r9 != r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadScene(Activity activity, Continuation<? super Unit> continuation) {
        FullscreenHtmlSceneViewModel$loadScene$1 fullscreenHtmlSceneViewModel$loadScene$1;
        int i;
        FullscreenHtmlSceneViewModel fullscreenHtmlSceneViewModel;
        Object m9510loadSceneAsset0E7RQCE;
        if (continuation instanceof FullscreenHtmlSceneViewModel$loadScene$1) {
            fullscreenHtmlSceneViewModel$loadScene$1 = (FullscreenHtmlSceneViewModel$loadScene$1) continuation;
            if ((fullscreenHtmlSceneViewModel$loadScene$1.label & Integer.MIN_VALUE) != 0) {
                fullscreenHtmlSceneViewModel$loadScene$1.label -= Integer.MIN_VALUE;
                Object obj = fullscreenHtmlSceneViewModel$loadScene$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fullscreenHtmlSceneViewModel$loadScene$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    fullscreenHtmlSceneViewModel$loadScene$1.L$0 = this;
                    fullscreenHtmlSceneViewModel$loadScene$1.L$1 = activity;
                    fullscreenHtmlSceneViewModel$loadScene$1.label = 1;
                    if (updateLoadingCardVisibility(true, fullscreenHtmlSceneViewModel$loadScene$1) != coroutine_suspended) {
                        fullscreenHtmlSceneViewModel = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    activity = (Activity) fullscreenHtmlSceneViewModel$loadScene$1.L$1;
                    fullscreenHtmlSceneViewModel = (FullscreenHtmlSceneViewModel) fullscreenHtmlSceneViewModel$loadScene$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    m9510loadSceneAsset0E7RQCE = ((Result) obj).getValue();
                    Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m9510loadSceneAsset0E7RQCE);
                    if (m10244exceptionOrNullimpl == null) {
                        SceneAsset sceneAsset = (SceneAsset) m9510loadSceneAsset0E7RQCE;
                        if (sceneAsset instanceof SceneAsset.Html) {
                            fullscreenHtmlSceneViewModel$loadScene$1.L$0 = null;
                            fullscreenHtmlSceneViewModel$loadScene$1.L$1 = null;
                            fullscreenHtmlSceneViewModel$loadScene$1.label = 3;
                        }
                    } else {
                        Logger.INSTANCE.e("FullscreenHtmlSceneViewModel", m10244exceptionOrNullimpl);
                        fullscreenHtmlSceneViewModel.onError(new AdException(AdError.AssetDownloadError, null, 2, null));
                    }
                    return Unit.INSTANCE;
                }
                activity = (Activity) fullscreenHtmlSceneViewModel$loadScene$1.L$1;
                fullscreenHtmlSceneViewModel = (FullscreenHtmlSceneViewModel) fullscreenHtmlSceneViewModel$loadScene$1.L$0;
                ResultKt.throwOnFailure(obj);
                PrepareFullscreenSceneAssetsUseCase prepareAssetsUseCase = fullscreenHtmlSceneViewModel.getPrepareAssetsUseCase();
                FullscreenAdScene.Html html = fullscreenHtmlSceneViewModel.htmlScene;
                fullscreenHtmlSceneViewModel$loadScene$1.L$0 = fullscreenHtmlSceneViewModel;
                fullscreenHtmlSceneViewModel$loadScene$1.L$1 = activity;
                fullscreenHtmlSceneViewModel$loadScene$1.label = 2;
                m9510loadSceneAsset0E7RQCE = prepareAssetsUseCase.m9510loadSceneAsset0E7RQCE(activity, html, fullscreenHtmlSceneViewModel$loadScene$1);
            }
        }
        fullscreenHtmlSceneViewModel$loadScene$1 = new FullscreenHtmlSceneViewModel$loadScene$1(this, continuation);
        Object obj2 = fullscreenHtmlSceneViewModel$loadScene$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fullscreenHtmlSceneViewModel$loadScene$1.label;
        if (i != 0) {
        }
        PrepareFullscreenSceneAssetsUseCase prepareAssetsUseCase2 = fullscreenHtmlSceneViewModel.getPrepareAssetsUseCase();
        FullscreenAdScene.Html html2 = fullscreenHtmlSceneViewModel.htmlScene;
        fullscreenHtmlSceneViewModel$loadScene$1.L$0 = fullscreenHtmlSceneViewModel;
        fullscreenHtmlSceneViewModel$loadScene$1.L$1 = activity;
        fullscreenHtmlSceneViewModel$loadScene$1.label = 2;
        m9510loadSceneAsset0E7RQCE = prepareAssetsUseCase2.m9510loadSceneAsset0E7RQCE(activity, html2, fullscreenHtmlSceneViewModel$loadScene$1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d1, code lost:
    
        if (r2.updateLoadingCardVisibility(false, r0) == r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00d3, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
    
        if (r9 == r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
    
        r11 = r9;
        r9 = r11;
        r2 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a5, code lost:
    
        if (r9 == r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadSceneAsset(Activity activity, SceneAsset.Html html, Continuation<? super Unit> continuation) {
        FullscreenHtmlSceneViewModel$loadSceneAsset$1 fullscreenHtmlSceneViewModel$loadSceneAsset$1;
        int i;
        MraidController controller;
        Object mo9558load0E7RQCE;
        Object obj;
        MraidController mraidController;
        FullscreenHtmlSceneViewModel fullscreenHtmlSceneViewModel;
        Object m10241constructorimpl;
        if (continuation instanceof FullscreenHtmlSceneViewModel$loadSceneAsset$1) {
            fullscreenHtmlSceneViewModel$loadSceneAsset$1 = (FullscreenHtmlSceneViewModel$loadSceneAsset$1) continuation;
            if ((fullscreenHtmlSceneViewModel$loadSceneAsset$1.label & Integer.MIN_VALUE) != 0) {
                fullscreenHtmlSceneViewModel$loadSceneAsset$1.label -= Integer.MIN_VALUE;
                Object obj2 = fullscreenHtmlSceneViewModel$loadSceneAsset$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fullscreenHtmlSceneViewModel$loadSceneAsset$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    controller = html.getController();
                    this.mraidController = controller;
                    if (html.isPreloaded()) {
                        Result.Companion companion = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
                        fullscreenHtmlSceneViewModel = this;
                        if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) == null) {
                            fullscreenHtmlSceneViewModel.onLoadSceneSuccess(html);
                            controller.prepareForDisplay();
                        } else {
                            fullscreenHtmlSceneViewModel.onError(new AdException(AdError.AssetPreloadError, null, 2, null));
                        }
                        fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$0 = null;
                        fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$1 = null;
                        fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$2 = null;
                        fullscreenHtmlSceneViewModel$loadSceneAsset$1.label = 3;
                    } else if (html instanceof SceneAsset.Html.FileBased) {
                        File file = ((SceneAsset.Html.FileBased) html).getResource().getFile();
                        fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$0 = this;
                        fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$1 = html;
                        fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$2 = controller;
                        fullscreenHtmlSceneViewModel$loadSceneAsset$1.label = 1;
                        mo9558load0E7RQCE = controller.mo9557load0E7RQCE(activity, file, fullscreenHtmlSceneViewModel$loadSceneAsset$1);
                    } else {
                        if (!(html instanceof SceneAsset.Html.ContentBased)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        String content = ((SceneAsset.Html.ContentBased) html).getContent();
                        fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$0 = this;
                        fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$1 = html;
                        fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$2 = controller;
                        fullscreenHtmlSceneViewModel$loadSceneAsset$1.label = 2;
                        mo9558load0E7RQCE = controller.mo9558load0E7RQCE(activity, content, fullscreenHtmlSceneViewModel$loadSceneAsset$1);
                    }
                } else {
                    if (i != 1 && i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                        return Unit.INSTANCE;
                    }
                    mraidController = (MraidController) fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$2;
                    html = (SceneAsset.Html) fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$1;
                    fullscreenHtmlSceneViewModel = (FullscreenHtmlSceneViewModel) fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    obj = ((Result) obj2).getValue();
                }
                Object obj3 = obj;
                controller = mraidController;
                m10241constructorimpl = obj3;
                if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) == null) {
                }
                fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$0 = null;
                fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$1 = null;
                fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$2 = null;
                fullscreenHtmlSceneViewModel$loadSceneAsset$1.label = 3;
            }
        }
        fullscreenHtmlSceneViewModel$loadSceneAsset$1 = new FullscreenHtmlSceneViewModel$loadSceneAsset$1(this, continuation);
        Object obj22 = fullscreenHtmlSceneViewModel$loadSceneAsset$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fullscreenHtmlSceneViewModel$loadSceneAsset$1.label;
        if (i != 0) {
        }
        Object obj32 = obj;
        controller = mraidController;
        m10241constructorimpl = obj32;
        if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) == null) {
        }
        fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$0 = null;
        fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$1 = null;
        fullscreenHtmlSceneViewModel$loadSceneAsset$1.L$2 = null;
        fullscreenHtmlSceneViewModel$loadSceneAsset$1.label = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateLoadingCardVisibility(boolean z, Continuation<? super Unit> continuation) {
        FullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1 fullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1;
        int i;
        FullscreenHtmlSceneViewModel fullscreenHtmlSceneViewModel;
        boolean z2;
        MutableStateFlow<FullscreenAdSceneUiState.Html> mutableStateFlow;
        FullscreenAdSceneUiState.Html value;
        if (continuation instanceof FullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1) {
            fullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1 = (FullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1) continuation;
            if ((fullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1.label & Integer.MIN_VALUE) != 0) {
                fullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1.label -= Integer.MIN_VALUE;
                Object obj = fullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.htmlScene.getConfig().getLoadingCardEnabled()) {
                        return Unit.INSTANCE;
                    }
                    if (!z) {
                        fullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1.L$0 = this;
                        fullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1.Z$0 = z;
                        fullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1.label = 1;
                        if (DelayKt.delay(600L, fullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    fullscreenHtmlSceneViewModel = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z = fullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1.Z$0;
                    fullscreenHtmlSceneViewModel = (FullscreenHtmlSceneViewModel) fullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                z2 = z;
                mutableStateFlow = fullscreenHtmlSceneViewModel.sceneUiState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, FullscreenAdSceneUiState.Html.copy$default(value, null, null, 0, null, z2, null, 47, null)));
                return Unit.INSTANCE;
            }
        }
        fullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1 = new FullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1(this, continuation);
        Object obj2 = fullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fullscreenHtmlSceneViewModel$updateLoadingCardVisibility$1.label;
        if (i != 0) {
        }
        z2 = z;
        mutableStateFlow = fullscreenHtmlSceneViewModel.sceneUiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, FullscreenAdSceneUiState.Html.copy$default(value, null, null, 0, null, z2, null, 47, null)));
        return Unit.INSTANCE;
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel
    public void updateAssetState(SceneAsset asset) {
        FullscreenAdSceneUiState.Html value;
        Intrinsics.checkNotNullParameter(asset, "asset");
        MutableStateFlow<FullscreenAdSceneUiState.Html> mutableStateFlow = this.sceneUiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, FullscreenAdSceneUiState.Html.copy$default(value, null, null, 0, asset instanceof SceneAsset.Html ? (SceneAsset.Html) asset : null, false, null, 55, null)));
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel
    public void updateClickState() {
        FullscreenAdSceneUiState.Html value;
        FullscreenAdSceneUiState.Html html;
        MutableStateFlow<FullscreenAdSceneUiState.Html> mutableStateFlow = this.sceneUiState;
        do {
            value = mutableStateFlow.getValue();
            html = value;
        } while (!mutableStateFlow.compareAndSet(value, FullscreenAdSceneUiState.Html.copy$default(html, null, AdCloseConfig.copy$default(html.getEffectiveCloseConfig(), null, 0, 1.0f, null, 0, 0, 59, null), 0, null, false, null, 61, null)));
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel
    public void updateErrorState() {
        FullscreenAdSceneUiState.Html value;
        FullscreenAdSceneUiState.Html html;
        MutableStateFlow<FullscreenAdSceneUiState.Html> mutableStateFlow = this.sceneUiState;
        do {
            value = mutableStateFlow.getValue();
            html = value;
        } while (!mutableStateFlow.compareAndSet(value, FullscreenAdSceneUiState.Html.copy$default(html, null, AdCloseConfig.copy$default(html.getEffectiveCloseConfig(), null, 0, 1.0f, null, 0, 0, 57, null), 0, null, false, null, 61, null)));
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel
    public void updatePromotedAppState(File file) {
        File file2;
        PromotedAppUiState promotedAppUiState;
        Intrinsics.checkNotNullParameter(file, "file");
        MutableStateFlow<FullscreenAdSceneUiState.Html> mutableStateFlow = this.sceneUiState;
        while (true) {
            FullscreenAdSceneUiState.Html value = mutableStateFlow.getValue();
            FullscreenAdSceneUiState.Html html = value;
            PromotedAppUiState promotedAppUiState2 = html.getPromotedAppUiState();
            if (promotedAppUiState2 != null) {
                File file3 = file;
                promotedAppUiState = PromotedAppUiState.copy$default(promotedAppUiState2, file3, null, null, null, 14, null);
                file2 = file3;
            } else {
                file2 = file;
                promotedAppUiState = null;
            }
            if (mutableStateFlow.compareAndSet(value, FullscreenAdSceneUiState.Html.copy$default(html, promotedAppUiState, null, 0, null, false, null, 62, null))) {
                return;
            } else {
                file = file2;
            }
        }
    }

    @Override // io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel, io.adn.sdk.internal.common.model.Destroyable
    public void destroy() {
        MraidController mraidController = this.mraidController;
        if (mraidController != null) {
            mraidController.destroy();
        }
        super.destroy();
    }
}
