package io.adn.sdk.internal.ui.common.mraid;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ironsource.C3040d4;
import com.ironsource.C3061e8;
import com.ironsource.C3207n2;
import io.adn.sdk.internal.domain.model.ad.RedirectionStrategy;
import io.adn.sdk.internal.ui.common.model.ClickPosition;
import io.adn.sdk.internal.ui.common.mraid.MraidControllerEvent;
import io.adn.sdk.internal.ui.common.mraid.MraidWebViewEvent;
import io.adn.sdk.internal.ui.utils.ActivityKt;
import io.adn.sdk.internal.ui.utils.ViewKt;
import io.adn.sdk.publisher.AdnClickElement;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: MraidController.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0096@¢\u0006\u0004\b*\u0010+J&\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010,\u001a\u00020-H\u0096@¢\u0006\u0004\b*\u0010.J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u0014H\u0016J\b\u00102\u001a\u00020\u0014H\u0016J\n\u00103\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u00104\u001a\u00020\u0014H\u0016J\u0010\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u00020\u001bH\u0016J\u0010\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u000200H\u0016J\u0010\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u000200H\u0016J\u0012\u0010;\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010=\u001a\u00020\u0014H\u0002J\u0010\u0010>\u001a\u00020\u00142\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010?\u001a\u00020\u0014H\u0002J\u001b\u0010@\u001a\u00020\u00142\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0002\u0010BJ\u0010\u0010C\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010D\u001a\u00020\u0014H\u0002J\b\u0010E\u001a\u00020\u0014H\u0002J\u0010\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u000200H\u0002J\b\u0010H\u001a\u00020\u0014H\u0002J\u0010\u0010I\u001a\u00020\u00142\u0006\u0010!\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020\u00142\u0006\u0010!\u001a\u00020LH\u0002J\u0010\u0010M\u001a\u00020\u00142\u0006\u0010!\u001a\u00020NH\u0002J\u001a\u0010O\u001a\u0002002\b\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010R\u001a\u000200H\u0002J\b\u0010S\u001a\u000200H\u0002J\u0010\u0010T\u001a\u00020\u00142\u0006\u0010!\u001a\u00020JH\u0002J\u0010\u0010U\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006W"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidControllerImpl;", "Lio/adn/sdk/internal/ui/common/mraid/MraidController;", "placementType", "Lio/adn/sdk/internal/ui/common/mraid/MraidPlacementType;", "mraidBridge", "Lio/adn/sdk/internal/ui/common/mraid/MraidBridge;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lio/adn/sdk/internal/ui/common/mraid/MraidPlacementType;Lio/adn/sdk/internal/ui/common/mraid/MraidBridge;Lkotlinx/coroutines/CoroutineScope;)V", "adContainer", "Landroid/widget/FrameLayout;", "loadAdContainer", "Landroid/view/ViewGroup;", "mraidWebView", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebView;", "redirectionStrategy", "Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "loadResult", "Lkotlin/Result;", "", "lastUserClickDate", "", "Ljava/lang/Long;", "lastUserClickPosition", "Lio/adn/sdk/internal/ui/common/model/ClickPosition;", "layoutMetrics", "Lio/adn/sdk/internal/ui/common/mraid/MraidLayoutMetrics;", "mraidViewState", "Lio/adn/sdk/internal/ui/common/mraid/MraidViewState;", "_event", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/adn/sdk/internal/ui/common/mraid/MraidControllerEvent;", "event", "Lkotlinx/coroutines/flow/Flow;", "getEvent", "()Lkotlinx/coroutines/flow/Flow;", "load", "activity", "Landroid/app/Activity;", "content", "", "load-0E7RQCE", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", C3040d4.h.b, "Ljava/io/File;", "(Landroid/app/Activity;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isLoaded", "", "prepareForDisplay", C3207n2.v, "getView", "destroy", "updateLayoutMetrics", "metrics", "updateForegroundState", "isForeground", "awaitHtmlLoadEvent", "enabled", "setRedirectionStrategy", "strategy", "setupClickObservation", "emitEvent", "onLoadStarted", "onLoadComplete", "result", "(Ljava/lang/Object;)V", "createAndAttachAdView", "detachAdView", "setMraidSettings", "updateVisibility", C3061e8.k, "observeWebviewEvents", "handleAdEvent", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent;", "handleOpenEvent", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$Open;", "handleCloseEvent", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent$Close;", "isRedirectionAllowed", "clickElement", "Lio/adn/sdk/publisher/AdnClickElement;", "userClicked", "hasUserClickedRecently", "fireWebEventError", "setMraidViewState", "state", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MraidControllerImpl implements MraidController {
    public static final int $stable = 8;
    private final MutableSharedFlow<MraidControllerEvent> _event;
    private FrameLayout adContainer;
    private final Flow<MraidControllerEvent> event;
    private Long lastUserClickDate;
    private ClickPosition lastUserClickPosition;
    private MraidLayoutMetrics layoutMetrics;
    private ViewGroup loadAdContainer;
    private Result<Unit> loadResult;
    private final MraidBridge mraidBridge;
    private MraidViewState mraidViewState;
    private MraidWebView mraidWebView;
    private final MraidPlacementType placementType;
    private RedirectionStrategy redirectionStrategy;
    private final CoroutineScope scope;

    /* compiled from: MraidController.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RedirectionStrategy.values().length];
            try {
                iArr[RedirectionStrategy.DisableAll.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RedirectionStrategy.OnlyClick.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MraidControllerImpl(MraidPlacementType placementType, MraidBridge mraidBridge, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        Intrinsics.checkNotNullParameter(mraidBridge, "mraidBridge");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.placementType = placementType;
        this.mraidBridge = mraidBridge;
        this.scope = scope;
        this.layoutMetrics = new MraidLayoutMetrics(null, null, null, null, 15, null);
        this.mraidViewState = MraidViewState.Loading;
        MutableSharedFlow<MraidControllerEvent> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._event = MutableSharedFlow$default;
        this.event = MutableSharedFlow$default;
    }

    public /* synthetic */ MraidControllerImpl(MraidPlacementType mraidPlacementType, MraidBridgeImpl mraidBridgeImpl, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mraidPlacementType, (i & 2) != 0 ? new MraidBridgeImpl(null, 1, null) : mraidBridgeImpl, (i & 4) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()) : coroutineScope);
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidController
    public Flow<MraidControllerEvent> getEvent() {
        return this.event;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // io.adn.sdk.internal.ui.common.mraid.MraidController
    /* renamed from: load-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo9558load0E7RQCE(Activity activity, String str, Continuation<? super Result<Unit>> continuation) {
        MraidControllerImpl$load$1 mraidControllerImpl$load$1;
        int i;
        if (continuation instanceof MraidControllerImpl$load$1) {
            mraidControllerImpl$load$1 = (MraidControllerImpl$load$1) continuation;
            if ((mraidControllerImpl$load$1.label & Integer.MIN_VALUE) != 0) {
                mraidControllerImpl$load$1.label -= Integer.MIN_VALUE;
                Object obj = mraidControllerImpl$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = mraidControllerImpl$load$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    MraidControllerImpl$load$2 mraidControllerImpl$load$2 = new MraidControllerImpl$load$2(this, activity, str, null);
                    mraidControllerImpl$load$1.label = 1;
                    obj = BuildersKt.withContext(main, mraidControllerImpl$load$2, mraidControllerImpl$load$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        mraidControllerImpl$load$1 = new MraidControllerImpl$load$1(this, continuation);
        Object obj2 = mraidControllerImpl$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = mraidControllerImpl$load$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // io.adn.sdk.internal.ui.common.mraid.MraidController
    /* renamed from: load-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo9557load0E7RQCE(Activity activity, File file, Continuation<? super Result<Unit>> continuation) {
        MraidControllerImpl$load$3 mraidControllerImpl$load$3;
        int i;
        MraidControllerImpl mraidControllerImpl;
        Object m10241constructorimpl;
        Throwable m10244exceptionOrNullimpl;
        if (continuation instanceof MraidControllerImpl$load$3) {
            mraidControllerImpl$load$3 = (MraidControllerImpl$load$3) continuation;
            if ((mraidControllerImpl$load$3.label & Integer.MIN_VALUE) != 0) {
                mraidControllerImpl$load$3.label -= Integer.MIN_VALUE;
                Object obj = mraidControllerImpl$load$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = mraidControllerImpl$load$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        MraidControllerImpl mraidControllerImpl2 = this;
                        CoroutineDispatcher io2 = Dispatchers.getIO();
                        MraidControllerImpl$load$4$1 mraidControllerImpl$load$4$1 = new MraidControllerImpl$load$4$1(file, null);
                        mraidControllerImpl$load$3.L$0 = this;
                        mraidControllerImpl$load$3.L$1 = activity;
                        mraidControllerImpl$load$3.label = 1;
                        obj = BuildersKt.withContext(io2, mraidControllerImpl$load$4$1, mraidControllerImpl$load$3);
                        if (obj != coroutine_suspended) {
                            mraidControllerImpl = this;
                        }
                    } catch (Throwable th) {
                        th = th;
                        mraidControllerImpl = this;
                        Result.Companion companion2 = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                        if (m10244exceptionOrNullimpl != null) {
                        }
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return ((Result) obj).getValue();
                }
                activity = (Activity) mraidControllerImpl$load$3.L$1;
                mraidControllerImpl = (MraidControllerImpl) mraidControllerImpl$load$3.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion22 = Result.INSTANCE;
                    m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                    m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                    if (m10244exceptionOrNullimpl != null) {
                    }
                }
                m10241constructorimpl = Result.m10241constructorimpl((String) obj);
                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                if (m10244exceptionOrNullimpl != null) {
                    mraidControllerImpl$load$3.L$0 = null;
                    mraidControllerImpl$load$3.L$1 = null;
                    mraidControllerImpl$load$3.label = 2;
                    Object mo9558load0E7RQCE = mraidControllerImpl.mo9558load0E7RQCE(activity, (String) m10241constructorimpl, mraidControllerImpl$load$3);
                    return mo9558load0E7RQCE == coroutine_suspended ? coroutine_suspended : mo9558load0E7RQCE;
                }
                Result.Companion companion3 = Result.INSTANCE;
                return Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl));
            }
        }
        mraidControllerImpl$load$3 = new MraidControllerImpl$load$3(this, continuation);
        Object obj2 = mraidControllerImpl$load$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = mraidControllerImpl$load$3.label;
        if (i != 0) {
        }
        m10241constructorimpl = Result.m10241constructorimpl((String) obj2);
        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
        }
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidController
    public boolean isLoaded() {
        Result<Unit> result = this.loadResult;
        return result != null && Result.m10248isSuccessimpl(result.getValue());
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidController
    public void prepareForDisplay() {
        if (isLoaded()) {
            updateVisibility(true);
        }
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidController
    public void show() {
        if (isLoaded()) {
            observeWebviewEvents();
            emitEvent(MraidControllerEvent.Displayed.INSTANCE);
        }
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidController
    /* renamed from: getView, reason: from getter */
    public FrameLayout getAdContainer() {
        return this.adContainer;
    }

    @Override // io.adn.sdk.internal.common.model.Destroyable
    public void destroy() {
        try {
            Result.Companion companion = Result.INSTANCE;
            MraidControllerImpl mraidControllerImpl = this;
            CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
            MraidWebView mraidWebView = this.mraidWebView;
            if (mraidWebView != null) {
                mraidWebView.destroy();
            }
            this.mraidWebView = null;
            this.mraidBridge.destroy();
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidController
    public void updateLayoutMetrics(MraidLayoutMetrics metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        if (Intrinsics.areEqual(this.layoutMetrics, metrics)) {
            return;
        }
        this.layoutMetrics = metrics;
        this.mraidBridge.sendLayoutMetrics(metrics);
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidController
    public void updateForegroundState(boolean isForeground) {
        this.mraidBridge.sendIsViewable(isForeground);
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidController
    public void awaitHtmlLoadEvent(boolean enabled) {
        this.mraidBridge.awaitHtmlLoadEvent(enabled);
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidController
    public void setRedirectionStrategy(RedirectionStrategy strategy) {
        this.redirectionStrategy = strategy;
        setupClickObservation();
    }

    private final void setupClickObservation() {
        MraidWebView mraidWebView = this.mraidWebView;
        if (mraidWebView != null) {
            mraidWebView.observeOnClick(new Function1() { // from class: io.adn.sdk.internal.ui.common.mraid.MraidControllerImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit unit;
                    unit = MraidControllerImpl.setupClickObservation$lambda$3(MraidControllerImpl.this, (ClickPosition) obj);
                    return unit;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupClickObservation$lambda$3(MraidControllerImpl mraidControllerImpl, ClickPosition clickPosition) {
        mraidControllerImpl.lastUserClickDate = Long.valueOf(System.currentTimeMillis());
        mraidControllerImpl.lastUserClickPosition = clickPosition;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitEvent(MraidControllerEvent event) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new MraidControllerImpl$emitEvent$1(this, event, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadStarted() {
        this.mraidViewState = MraidViewState.Loading;
        this.loadResult = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadComplete(Object result) {
        if (this.loadResult != null) {
            return;
        }
        this.loadResult = Result.m10240boximpl(result);
        if (Result.m10248isSuccessimpl(result)) {
            setMraidSettings();
            updateForegroundState(false);
        }
        updateVisibility(false);
        detachAdView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createAndAttachAdView(Activity activity) {
        Activity activity2 = activity;
        FrameLayout frameLayout = new FrameLayout(activity2);
        MraidWebView mraidWebView = new MraidWebView(activity2);
        this.mraidWebView = mraidWebView;
        this.mraidBridge.attachView(mraidWebView);
        ViewKt.addViewWithMatchParent(frameLayout, mraidWebView);
        FrameLayout frameLayout2 = this.adContainer;
        if (frameLayout2 != null) {
            frameLayout2.removeAllViews();
        }
        this.adContainer = frameLayout;
        ViewGroup rootContainer = ActivityKt.rootContainer(activity2);
        if (rootContainer != null) {
            rootContainer.addView(frameLayout, 0);
            this.layoutMetrics = MraidLayoutMetricsKt.toAdLayoutMetrics(rootContainer);
        } else {
            rootContainer = null;
        }
        this.loadAdContainer = rootContainer;
    }

    private final void detachAdView() {
        ViewKt.detachView(this.loadAdContainer, this.adContainer);
    }

    private final void setMraidSettings() {
        MraidBridge mraidBridge = this.mraidBridge;
        mraidBridge.sendSupports(false, false, false, false, false);
        mraidBridge.sendPlacementType(this.placementType);
        mraidBridge.sendLayoutMetrics(this.layoutMetrics);
        setMraidViewState(MraidViewState.Default);
        mraidBridge.sendIsViewable(true);
        mraidBridge.sendReady();
    }

    private final void updateVisibility(boolean isVisible) {
        FrameLayout frameLayout = this.adContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(isVisible ? 0 : 4);
        }
        MraidWebView mraidWebView = this.mraidWebView;
        if (mraidWebView != null) {
            mraidWebView.setVisibility(isVisible ? 0 : 4);
        }
    }

    private final void observeWebviewEvents() {
        Flow onEach;
        SharedFlow<MraidWebViewEvent> event = this.mraidBridge.event();
        if (event == null || (onEach = FlowKt.onEach(event, new MraidControllerImpl$observeWebviewEvents$1(this, null))) == null) {
            return;
        }
        FlowKt.launchIn(onEach, this.scope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAdEvent(MraidWebViewEvent event) {
        if (event instanceof MraidWebViewEvent.Close) {
            handleCloseEvent((MraidWebViewEvent.Close) event);
        } else if (event instanceof MraidWebViewEvent.Open) {
            handleOpenEvent((MraidWebViewEvent.Open) event);
        } else {
            fireWebEventError(event);
        }
    }

    private final void handleOpenEvent(MraidWebViewEvent.Open event) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new MraidControllerImpl$handleOpenEvent$1(this, event, null), 3, null);
    }

    private final void handleCloseEvent(MraidWebViewEvent.Close event) {
        if (event.getOrigin() == MraidEventOrigin.MRAID) {
            setMraidViewState(MraidViewState.Hidden);
        }
        emitEvent(MraidControllerEvent.Dismiss.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRedirectionAllowed(AdnClickElement clickElement, boolean userClicked) {
        if (clickElement instanceof AdnClickElement.Cta) {
            return true;
        }
        RedirectionStrategy redirectionStrategy = this.redirectionStrategy;
        int i = redirectionStrategy == null ? -1 : WhenMappings.$EnumSwitchMapping$0[redirectionStrategy.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return true;
        }
        return userClicked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasUserClickedRecently() {
        Long l = this.lastUserClickDate;
        if (l != null) {
            if (System.currentTimeMillis() - l.longValue() < 500) {
                return true;
            }
        }
        return false;
    }

    private final void fireWebEventError(MraidWebViewEvent event) {
        if (event.getOrigin() == MraidEventOrigin.MRAID) {
            this.mraidBridge.sendError(event.getCommand(), "Not implemented yet");
        }
    }

    private final void setMraidViewState(MraidViewState state) {
        this.mraidViewState = state;
        this.mraidBridge.sendViewState(state);
    }
}
