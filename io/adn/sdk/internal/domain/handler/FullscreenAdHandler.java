package io.adn.sdk.internal.domain.handler;

import android.app.Activity;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3207n2;
import com.ironsource.C3355vf;
import com.vungle.ads.internal.ui.AdActivity;
import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.common.utils.ConversionsKt;
import io.adn.sdk.internal.common.utils.Timer;
import io.adn.sdk.internal.di.DependencyInjectorKt;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.ad.AdState;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEntity;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEntityKt;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEvent;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEventKt;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.internal.domain.usecase.FetchBidResponseUseCase;
import io.adn.sdk.internal.domain.usecase.LoadFullscreenAdUseCase;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenAdViewModel;
import io.adn.sdk.publisher.AdnAdInfo;
import io.adn.sdk.publisher.AdnAdPlacement;
import io.adn.sdk.publisher.AdnAdRequest;
import io.adn.sdk.publisher.AdnAdRequestKt;
import io.adn.sdk.publisher.AdnFullscreenAd;
import io.adn.sdk.publisher.AdnFullscreenAdListener;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;

/* compiled from: FullscreenAdHandler.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\"\u001a\u00020#2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020#H\u0016J\b\u00100\u001a\u00020#H\u0002J\u0010\u00101\u001a\u00020#2\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020#H\u0002J\b\u00105\u001a\u00020#H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00066"}, d2 = {"Lio/adn/sdk/internal/domain/handler/FullscreenAdHandler;", "Lio/adn/sdk/publisher/AdnFullscreenAd;", "activity", "Landroid/app/Activity;", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "fetchBidUseCase", "Lio/adn/sdk/internal/domain/usecase/FetchBidResponseUseCase;", "loadAdUseCase", "Lio/adn/sdk/internal/domain/usecase/LoadFullscreenAdUseCase;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/app/Activity;Lio/adn/sdk/publisher/AdnAdPlacement;Lio/adn/sdk/internal/domain/usecase/FetchBidResponseUseCase;Lio/adn/sdk/internal/domain/usecase/LoadFullscreenAdUseCase;Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;Lkotlinx/coroutines/CoroutineScope;)V", "adState", "Ljava/util/concurrent/atomic/AtomicReference;", "Lio/adn/sdk/internal/domain/model/ad/AdState;", "kotlin.jvm.PlatformType", "loadTimer", "Lio/adn/sdk/internal/common/utils/Timer;", "diagnosticAdLoading", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$AdLoading;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/adn/sdk/publisher/AdnFullscreenAdListener;", "viewModel", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenAdViewModel;", "adInfo", "Lio/adn/sdk/publisher/AdnAdInfo;", "uuid", "", "getUuid", "()Ljava/lang/String;", "setListener", "", "load", AdActivity.REQUEST_KEY_EXTRA, "Lio/adn/sdk/publisher/AdnAdRequest;", C3355vf.j, "ad", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEntity;", C3355vf.b, "exception", "Lio/adn/sdk/internal/domain/error/AdException;", "isReady", "", C3207n2.v, "collectAdEvents", "onAdEvent", "event", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent;", "onDismiss", "destroy", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdHandler implements AdnFullscreenAd {
    public static final int $stable = 8;
    private final Activity activity;
    private AdnAdInfo adInfo;
    private final AtomicReference<AdState> adState;
    private final DiagnosticEventBuilder.AdLoading diagnosticAdLoading;
    private final DiagnosticReporter diagnosticReporter;
    private final FetchBidResponseUseCase fetchBidUseCase;
    private AdnFullscreenAdListener listener;
    private final LoadFullscreenAdUseCase loadAdUseCase;
    private final Timer loadTimer;
    private final AdnAdPlacement placement;
    private final CoroutineScope scope;
    private final String uuid;
    private FullscreenAdViewModel viewModel;

    public FullscreenAdHandler(Activity activity, AdnAdPlacement placement, FetchBidResponseUseCase fetchBidUseCase, LoadFullscreenAdUseCase loadAdUseCase, DiagnosticReporter diagnosticReporter, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(fetchBidUseCase, "fetchBidUseCase");
        Intrinsics.checkNotNullParameter(loadAdUseCase, "loadAdUseCase");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.activity = activity;
        this.placement = placement;
        this.fetchBidUseCase = fetchBidUseCase;
        this.loadAdUseCase = loadAdUseCase;
        this.diagnosticReporter = diagnosticReporter;
        this.scope = scope;
        this.adState = new AtomicReference<>(AdState.None);
        this.loadTimer = new Timer();
        this.diagnosticAdLoading = new DiagnosticEventBuilder.AdLoading();
        this.uuid = ConversionsKt.randomUUID();
    }

    public /* synthetic */ FullscreenAdHandler(Activity activity, AdnAdPlacement adnAdPlacement, FetchBidResponseUseCase fetchBidResponseUseCase, LoadFullscreenAdUseCase loadFullscreenAdUseCase, DiagnosticReporter diagnosticReporter, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, adnAdPlacement, fetchBidResponseUseCase, loadFullscreenAdUseCase, diagnosticReporter, (i & 32) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()) : coroutineScope);
    }

    @Override // io.adn.sdk.publisher.AdnAd
    public String getUuid() {
        return this.uuid;
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAd
    public void setListener(AdnFullscreenAdListener listener) {
        this.listener = listener;
    }

    @Override // io.adn.sdk.publisher.AdnAd
    public void load(AdnAdRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.adState, AdState.None, AdState.Loading)) {
            Logger.INSTANCE.external("Loading " + this.placement.getValue() + " ad...");
            this.loadTimer.start(AdnAdRequestKt.getTimeoutMs(request), new Function0() { // from class: io.adn.sdk.internal.domain.handler.FullscreenAdHandler$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit load$lambda$0;
                    load$lambda$0 = FullscreenAdHandler.load$lambda$0(FullscreenAdHandler.this);
                    return load$lambda$0;
                }
            });
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FullscreenAdHandler$load$2(this, request, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$0(FullscreenAdHandler fullscreenAdHandler) {
        fullscreenAdHandler.onAdLoadFailed(new AdException(AdError.LoadTimeout, null, 2, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAdLoaded(FullscreenAdEntity ad) {
        if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.adState, AdState.Loading, AdState.LoadSuccess)) {
            this.loadTimer.cancel();
            this.viewModel = DependencyInjectorKt.sdkComponents().createFullscreenAdViewModel(this.activity, ad, this.diagnosticReporter);
            AdnAdInfo publicAdInfo = FullscreenAdEntityKt.toPublicAdInfo(ad);
            AdnFullscreenAdListener adnFullscreenAdListener = this.listener;
            if (adnFullscreenAdListener != null) {
                adnFullscreenAdListener.onAdLoaded(publicAdInfo);
            }
            this.adInfo = publicAdInfo;
            this.diagnosticReporter.reportSuccess(this.diagnosticAdLoading);
            Logger.INSTANCE.external(this.placement.getValue() + " ad loaded successfully");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAdLoadFailed(AdException exception) {
        if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.adState, AdState.Loading, AdState.LoadFailure)) {
            this.loadTimer.cancel();
            AdnFullscreenAdListener adnFullscreenAdListener = this.listener;
            if (adnFullscreenAdListener != null) {
                adnFullscreenAdListener.onAdLoadFailed(exception.toExternalError());
            }
            this.diagnosticReporter.reportFailure(this.diagnosticAdLoading, exception);
            Logger.INSTANCE.external("Failed to load " + this.placement.getValue() + " ad: " + exception.getError().getCode());
            destroy();
        }
    }

    @Override // io.adn.sdk.publisher.AdnAd
    public boolean isReady() {
        return this.adState.get() == AdState.LoadSuccess;
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAd
    public void show() {
        if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.adState, AdState.LoadSuccess, AdState.Showing)) {
            AdnFullscreenAdListener adnFullscreenAdListener = this.listener;
            if (adnFullscreenAdListener != null) {
                adnFullscreenAdListener.onAdShown(this.adInfo);
            }
            FullscreenAdViewModel fullscreenAdViewModel = this.viewModel;
            if (fullscreenAdViewModel != null) {
                fullscreenAdViewModel.show(this.activity);
            }
            collectAdEvents();
        }
    }

    private final void collectAdEvents() {
        Flow<FullscreenAdEvent> adEvent;
        FullscreenAdViewModel fullscreenAdViewModel = this.viewModel;
        if (fullscreenAdViewModel == null || (adEvent = fullscreenAdViewModel.getAdEvent()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FullscreenAdHandler$collectAdEvents$1$1(adEvent, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAdEvent(FullscreenAdEvent event) {
        AdnFullscreenAdListener adnFullscreenAdListener;
        if (Intrinsics.areEqual(event, FullscreenAdEvent.Impression.INSTANCE)) {
            AdnFullscreenAdListener adnFullscreenAdListener2 = this.listener;
            if (adnFullscreenAdListener2 != null) {
                adnFullscreenAdListener2.onAdImpression(this.adInfo);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(event, FullscreenAdEvent.ClickThrough.INSTANCE)) {
            AdnFullscreenAdListener adnFullscreenAdListener3 = this.listener;
            if (adnFullscreenAdListener3 != null) {
                adnFullscreenAdListener3.onAdClicked(this.adInfo);
                return;
            }
            return;
        }
        if (!(event instanceof FullscreenAdEvent.Dismiss)) {
            throw new NoWhenBranchMatchedException();
        }
        if (this.placement == AdnAdPlacement.REWARDED && FullscreenAdEventKt.isClosedByUser((FullscreenAdEvent.Dismiss) event) && (adnFullscreenAdListener = this.listener) != null) {
            adnFullscreenAdListener.onAdRewarded(this.adInfo);
        }
        onDismiss();
    }

    private final void onDismiss() {
        AdnFullscreenAdListener adnFullscreenAdListener = this.listener;
        if (adnFullscreenAdListener != null) {
            adnFullscreenAdListener.onAdClosed(this.adInfo);
        }
        destroy();
    }

    @Override // io.adn.sdk.publisher.AdnAd
    public void destroy() {
        if (this.adState.get() != AdState.Destroyed) {
            this.adState.set(AdState.Destroyed);
            FullscreenAdViewModel fullscreenAdViewModel = this.viewModel;
            if (fullscreenAdViewModel != null) {
                fullscreenAdViewModel.destroy();
            }
            this.viewModel = null;
            this.adInfo = null;
        }
    }
}
