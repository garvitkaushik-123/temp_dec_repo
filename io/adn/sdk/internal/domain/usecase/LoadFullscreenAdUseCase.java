package io.adn.sdk.internal.domain.usecase;

import android.app.Activity;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.error.AdExceptionKt;
import io.adn.sdk.internal.domain.model.ad.AdLinkKt;
import io.adn.sdk.internal.domain.model.ad.AdPromotedApp;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEntity;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.internal.domain.repository.FullscreenAdLoader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: LoadFullscreenAdUseCase.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086B¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0016H\u0082@¢\u0006\u0004\b\"\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lio/adn/sdk/internal/domain/usecase/LoadFullscreenAdUseCase;", "", "fullScreenAdLoader", "Lio/adn/sdk/internal/domain/repository/FullscreenAdLoader;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lio/adn/sdk/internal/domain/repository/FullscreenAdLoader;Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;Lkotlinx/coroutines/CoroutineScope;)V", "invoke", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEntity;", "activity", "Landroid/app/Activity;", "bidResponse", "Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "(Landroid/app/Activity;Lio/adn/sdk/internal/domain/model/ad/BidResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAndValidateAd", "(Lio/adn/sdk/internal/domain/model/ad/BidResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPrimaryScene", "", "firstScene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "(Landroid/app/Activity;Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadRemainingScenes", "remainingScenes", "", "preloadPromotedApp", "promotedApp", "Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "loadSceneWithDiagnostics", "Lkotlin/Result;", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset;", "scene", "loadSceneWithDiagnostics-0E7RQCE", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LoadFullscreenAdUseCase {
    public static final int $stable = 8;
    private final DiagnosticReporter diagnosticReporter;
    private final FullscreenAdLoader fullScreenAdLoader;
    private final CoroutineScope scope;

    public LoadFullscreenAdUseCase(FullscreenAdLoader fullScreenAdLoader, DiagnosticReporter diagnosticReporter, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(fullScreenAdLoader, "fullScreenAdLoader");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.fullScreenAdLoader = fullScreenAdLoader;
        this.diagnosticReporter = diagnosticReporter;
        this.scope = scope;
    }

    public /* synthetic */ LoadFullscreenAdUseCase(FullscreenAdLoader fullscreenAdLoader, DiagnosticReporter diagnosticReporter, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fullscreenAdLoader, diagnosticReporter, (i & 4) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain())) : coroutineScope);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(Activity activity, BidResponse bidResponse, Continuation<? super FullscreenAdEntity> continuation) {
        LoadFullscreenAdUseCase$invoke$1 loadFullscreenAdUseCase$invoke$1;
        Object coroutine_suspended;
        int i;
        LoadFullscreenAdUseCase loadFullscreenAdUseCase;
        FullscreenAdScene fullscreenAdScene;
        Activity activity2;
        FullscreenAdEntity fullscreenAdEntity;
        LoadFullscreenAdUseCase loadFullscreenAdUseCase2;
        if (continuation instanceof LoadFullscreenAdUseCase$invoke$1) {
            loadFullscreenAdUseCase$invoke$1 = (LoadFullscreenAdUseCase$invoke$1) continuation;
            if ((loadFullscreenAdUseCase$invoke$1.label & Integer.MIN_VALUE) != 0) {
                loadFullscreenAdUseCase$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = loadFullscreenAdUseCase$invoke$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = loadFullscreenAdUseCase$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    loadFullscreenAdUseCase$invoke$1.L$0 = this;
                    loadFullscreenAdUseCase$invoke$1.L$1 = activity;
                    loadFullscreenAdUseCase$invoke$1.L$2 = bidResponse;
                    loadFullscreenAdUseCase$invoke$1.label = 1;
                    obj = loadAndValidateAd(bidResponse, loadFullscreenAdUseCase$invoke$1);
                    if (obj != coroutine_suspended) {
                        loadFullscreenAdUseCase = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    fullscreenAdEntity = (FullscreenAdEntity) loadFullscreenAdUseCase$invoke$1.L$3;
                    bidResponse = (BidResponse) loadFullscreenAdUseCase$invoke$1.L$2;
                    activity2 = (Activity) loadFullscreenAdUseCase$invoke$1.L$1;
                    loadFullscreenAdUseCase2 = (LoadFullscreenAdUseCase) loadFullscreenAdUseCase$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    loadFullscreenAdUseCase2.preloadRemainingScenes(activity2, CollectionsKt.drop(fullscreenAdEntity.getScenes(), 1));
                    loadFullscreenAdUseCase2.preloadPromotedApp(bidResponse.getPromotedApp());
                    return fullscreenAdEntity;
                }
                bidResponse = (BidResponse) loadFullscreenAdUseCase$invoke$1.L$2;
                activity = (Activity) loadFullscreenAdUseCase$invoke$1.L$1;
                loadFullscreenAdUseCase = (LoadFullscreenAdUseCase) loadFullscreenAdUseCase$invoke$1.L$0;
                ResultKt.throwOnFailure(obj);
                FullscreenAdEntity fullscreenAdEntity2 = (FullscreenAdEntity) obj;
                fullscreenAdScene = (FullscreenAdScene) CollectionsKt.first((List) fullscreenAdEntity2.getScenes());
                loadFullscreenAdUseCase$invoke$1.L$0 = loadFullscreenAdUseCase;
                loadFullscreenAdUseCase$invoke$1.L$1 = activity;
                loadFullscreenAdUseCase$invoke$1.L$2 = bidResponse;
                loadFullscreenAdUseCase$invoke$1.L$3 = fullscreenAdEntity2;
                loadFullscreenAdUseCase$invoke$1.label = 2;
                if (loadFullscreenAdUseCase.loadPrimaryScene(activity, fullscreenAdScene, loadFullscreenAdUseCase$invoke$1) != coroutine_suspended) {
                    activity2 = activity;
                    fullscreenAdEntity = fullscreenAdEntity2;
                    loadFullscreenAdUseCase2 = loadFullscreenAdUseCase;
                    loadFullscreenAdUseCase2.preloadRemainingScenes(activity2, CollectionsKt.drop(fullscreenAdEntity.getScenes(), 1));
                    loadFullscreenAdUseCase2.preloadPromotedApp(bidResponse.getPromotedApp());
                    return fullscreenAdEntity;
                }
                return coroutine_suspended;
            }
        }
        loadFullscreenAdUseCase$invoke$1 = new LoadFullscreenAdUseCase$invoke$1(this, continuation);
        Object obj2 = loadFullscreenAdUseCase$invoke$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = loadFullscreenAdUseCase$invoke$1.label;
        if (i != 0) {
        }
        FullscreenAdEntity fullscreenAdEntity22 = (FullscreenAdEntity) obj2;
        fullscreenAdScene = (FullscreenAdScene) CollectionsKt.first((List) fullscreenAdEntity22.getScenes());
        loadFullscreenAdUseCase$invoke$1.L$0 = loadFullscreenAdUseCase;
        loadFullscreenAdUseCase$invoke$1.L$1 = activity;
        loadFullscreenAdUseCase$invoke$1.L$2 = bidResponse;
        loadFullscreenAdUseCase$invoke$1.L$3 = fullscreenAdEntity22;
        loadFullscreenAdUseCase$invoke$1.label = 2;
        if (loadFullscreenAdUseCase.loadPrimaryScene(activity, fullscreenAdScene, loadFullscreenAdUseCase$invoke$1) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadAndValidateAd(BidResponse bidResponse, Continuation<? super FullscreenAdEntity> continuation) {
        LoadFullscreenAdUseCase$loadAndValidateAd$1 loadFullscreenAdUseCase$loadAndValidateAd$1;
        int i;
        LoadFullscreenAdUseCase loadFullscreenAdUseCase;
        FullscreenAdEntity fullscreenAdEntity;
        if (continuation instanceof LoadFullscreenAdUseCase$loadAndValidateAd$1) {
            loadFullscreenAdUseCase$loadAndValidateAd$1 = (LoadFullscreenAdUseCase$loadAndValidateAd$1) continuation;
            if ((loadFullscreenAdUseCase$loadAndValidateAd$1.label & Integer.MIN_VALUE) != 0) {
                loadFullscreenAdUseCase$loadAndValidateAd$1.label -= Integer.MIN_VALUE;
                Object obj = loadFullscreenAdUseCase$loadAndValidateAd$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = loadFullscreenAdUseCase$loadAndValidateAd$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    FullscreenAdLoader fullscreenAdLoader = this.fullScreenAdLoader;
                    loadFullscreenAdUseCase$loadAndValidateAd$1.L$0 = this;
                    loadFullscreenAdUseCase$loadAndValidateAd$1.label = 1;
                    obj = fullscreenAdLoader.loadAd(bidResponse, loadFullscreenAdUseCase$loadAndValidateAd$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    loadFullscreenAdUseCase = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    loadFullscreenAdUseCase = (LoadFullscreenAdUseCase) loadFullscreenAdUseCase$loadAndValidateAd$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                fullscreenAdEntity = (FullscreenAdEntity) obj;
                if (!fullscreenAdEntity.getScenes().isEmpty()) {
                    throw new AdException(AdError.NoCreativesError, null, 2, null);
                }
                if (fullscreenAdEntity.getImpressionTrackers().isEmpty()) {
                    throw new AdException(AdError.NoImpressionTrackersError, null, 2, null);
                }
                List<FullscreenAdScene> scenes = fullscreenAdEntity.getScenes();
                if (!(scenes instanceof Collection) || !scenes.isEmpty()) {
                    Iterator<T> it = scenes.iterator();
                    while (it.hasNext()) {
                        if (!AdLinkKt.isValid(((FullscreenAdScene) it.next()).getLink())) {
                            throw new AdException(AdError.NoClickTrackingError, null, 2, null);
                        }
                    }
                }
                loadFullscreenAdUseCase.diagnosticReporter.updateExpectedSceneCount(fullscreenAdEntity.getScenes().size());
                return fullscreenAdEntity;
            }
        }
        loadFullscreenAdUseCase$loadAndValidateAd$1 = new LoadFullscreenAdUseCase$loadAndValidateAd$1(this, continuation);
        Object obj2 = loadFullscreenAdUseCase$loadAndValidateAd$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = loadFullscreenAdUseCase$loadAndValidateAd$1.label;
        if (i != 0) {
        }
        fullscreenAdEntity = (FullscreenAdEntity) obj2;
        if (!fullscreenAdEntity.getScenes().isEmpty()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadPrimaryScene(Activity activity, FullscreenAdScene fullscreenAdScene, Continuation<? super Unit> continuation) {
        LoadFullscreenAdUseCase$loadPrimaryScene$1 loadFullscreenAdUseCase$loadPrimaryScene$1;
        int i;
        Object m9508loadSceneWithDiagnostics0E7RQCE;
        if (continuation instanceof LoadFullscreenAdUseCase$loadPrimaryScene$1) {
            loadFullscreenAdUseCase$loadPrimaryScene$1 = (LoadFullscreenAdUseCase$loadPrimaryScene$1) continuation;
            if ((loadFullscreenAdUseCase$loadPrimaryScene$1.label & Integer.MIN_VALUE) != 0) {
                loadFullscreenAdUseCase$loadPrimaryScene$1.label -= Integer.MIN_VALUE;
                Object obj = loadFullscreenAdUseCase$loadPrimaryScene$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = loadFullscreenAdUseCase$loadPrimaryScene$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    loadFullscreenAdUseCase$loadPrimaryScene$1.label = 1;
                    m9508loadSceneWithDiagnostics0E7RQCE = m9508loadSceneWithDiagnostics0E7RQCE(activity, fullscreenAdScene, loadFullscreenAdUseCase$loadPrimaryScene$1);
                    if (m9508loadSceneWithDiagnostics0E7RQCE == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    m9508loadSceneWithDiagnostics0E7RQCE = ((Result) obj).getValue();
                }
                ResultKt.throwOnFailure(m9508loadSceneWithDiagnostics0E7RQCE);
                return Unit.INSTANCE;
            }
        }
        loadFullscreenAdUseCase$loadPrimaryScene$1 = new LoadFullscreenAdUseCase$loadPrimaryScene$1(this, continuation);
        Object obj2 = loadFullscreenAdUseCase$loadPrimaryScene$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = loadFullscreenAdUseCase$loadPrimaryScene$1.label;
        if (i != 0) {
        }
        ResultKt.throwOnFailure(m9508loadSceneWithDiagnostics0E7RQCE);
        return Unit.INSTANCE;
    }

    private final void preloadRemainingScenes(Activity activity, List<? extends FullscreenAdScene> remainingScenes) {
        Iterator<T> it = remainingScenes.iterator();
        while (it.hasNext()) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LoadFullscreenAdUseCase$preloadRemainingScenes$1$1(this, activity, (FullscreenAdScene) it.next(), null), 3, null);
        }
    }

    private final void preloadPromotedApp(AdPromotedApp promotedApp) {
        if (promotedApp != null) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LoadFullscreenAdUseCase$preloadPromotedApp$1$1(this, promotedApp, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: loadSceneWithDiagnostics-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9508loadSceneWithDiagnostics0E7RQCE(Activity activity, FullscreenAdScene fullscreenAdScene, Continuation<? super Result<? extends SceneAsset>> continuation) {
        LoadFullscreenAdUseCase$loadSceneWithDiagnostics$1 loadFullscreenAdUseCase$loadSceneWithDiagnostics$1;
        int i;
        Object obj;
        DiagnosticEventBuilder.FullscreenSceneLoading fullscreenSceneLoading;
        LoadFullscreenAdUseCase loadFullscreenAdUseCase;
        Throwable m10244exceptionOrNullimpl;
        if (continuation instanceof LoadFullscreenAdUseCase$loadSceneWithDiagnostics$1) {
            loadFullscreenAdUseCase$loadSceneWithDiagnostics$1 = (LoadFullscreenAdUseCase$loadSceneWithDiagnostics$1) continuation;
            if ((loadFullscreenAdUseCase$loadSceneWithDiagnostics$1.label & Integer.MIN_VALUE) != 0) {
                loadFullscreenAdUseCase$loadSceneWithDiagnostics$1.label -= Integer.MIN_VALUE;
                Object obj2 = loadFullscreenAdUseCase$loadSceneWithDiagnostics$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = loadFullscreenAdUseCase$loadSceneWithDiagnostics$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    DiagnosticEventBuilder.FullscreenSceneLoading fullscreenSceneLoading2 = new DiagnosticEventBuilder.FullscreenSceneLoading(fullscreenAdScene);
                    this.diagnosticReporter.reportStart(fullscreenSceneLoading2);
                    FullscreenAdLoader fullscreenAdLoader = this.fullScreenAdLoader;
                    loadFullscreenAdUseCase$loadSceneWithDiagnostics$1.L$0 = this;
                    loadFullscreenAdUseCase$loadSceneWithDiagnostics$1.L$1 = fullscreenSceneLoading2;
                    loadFullscreenAdUseCase$loadSceneWithDiagnostics$1.label = 1;
                    Object mo9481loadScene0E7RQCE = fullscreenAdLoader.mo9481loadScene0E7RQCE(activity, fullscreenAdScene, loadFullscreenAdUseCase$loadSceneWithDiagnostics$1);
                    if (mo9481loadScene0E7RQCE == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = mo9481loadScene0E7RQCE;
                    fullscreenSceneLoading = fullscreenSceneLoading2;
                    loadFullscreenAdUseCase = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    fullscreenSceneLoading = (DiagnosticEventBuilder.FullscreenSceneLoading) loadFullscreenAdUseCase$loadSceneWithDiagnostics$1.L$1;
                    loadFullscreenAdUseCase = (LoadFullscreenAdUseCase) loadFullscreenAdUseCase$loadSceneWithDiagnostics$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    obj = ((Result) obj2).getValue();
                }
                if (Result.m10248isSuccessimpl(obj)) {
                    fullscreenSceneLoading.updateIsCachedProperty((SceneAsset) obj);
                    loadFullscreenAdUseCase.diagnosticReporter.reportSuccess(fullscreenSceneLoading);
                }
                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(obj);
                if (m10244exceptionOrNullimpl != null) {
                    loadFullscreenAdUseCase.diagnosticReporter.reportFailure(fullscreenSceneLoading, AdExceptionKt.toAdException(m10244exceptionOrNullimpl));
                }
                return obj;
            }
        }
        loadFullscreenAdUseCase$loadSceneWithDiagnostics$1 = new LoadFullscreenAdUseCase$loadSceneWithDiagnostics$1(this, continuation);
        Object obj22 = loadFullscreenAdUseCase$loadSceneWithDiagnostics$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = loadFullscreenAdUseCase$loadSceneWithDiagnostics$1.label;
        if (i != 0) {
        }
        if (Result.m10248isSuccessimpl(obj)) {
        }
        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(obj);
        if (m10244exceptionOrNullimpl != null) {
        }
        return obj;
    }
}
