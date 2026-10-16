package io.adn.sdk.internal.domain.management;

import android.content.Context;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.di.DependencyInjectorKt;
import io.adn.sdk.publisher.AdnInitializationCallback;
import io.adn.sdk.publisher.AdnInitializationStatus;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: SdkInitializer.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lio/adn/sdk/internal/domain/management/SdkInitializer;", "", "<init>", "()V", "initializationStatus", "Ljava/util/concurrent/atomic/AtomicReference;", "Lio/adn/sdk/publisher/AdnInitializationStatus;", "kotlin.jvm.PlatformType", "initializationStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", MobileAdsBridgeBase.initializeMethodName, "", "context", "Landroid/content/Context;", "initializationCallback", "Lio/adn/sdk/publisher/AdnInitializationCallback;", "awaitInitializationComplete", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isInitialized", "", "updateAndGetStatus", "status", "wasInitializeAlreadyCalled", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class SdkInitializer {
    public static final int $stable = 8;
    private final AtomicReference<AdnInitializationStatus> initializationStatus = new AtomicReference<>(AdnInitializationStatus.NOT_INITIALIZED);
    private final MutableStateFlow<AdnInitializationStatus> initializationStateFlow = StateFlowKt.MutableStateFlow(AdnInitializationStatus.NOT_INITIALIZED);

    public final void initialize(Context context, AdnInitializationCallback initializationCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initializationCallback, "initializationCallback");
        Logger.INSTANCE.external("Sdk initializing ...");
        AdnInitializationStatus initialize = initialize(context);
        initializationCallback.onCompletion(initialize);
        Logger.INSTANCE.external("Sdk initialization completed: " + initialize);
    }

    public final AdnInitializationStatus initialize(Context context) {
        Object m10241constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        if (wasInitializeAlreadyCalled()) {
            AdnInitializationStatus adnInitializationStatus = this.initializationStatus.get();
            Intrinsics.checkNotNullExpressionValue(adnInitializationStatus, "get(...)");
            return adnInitializationStatus;
        }
        updateAndGetStatus(AdnInitializationStatus.INITIALIZING);
        try {
            Result.Companion companion = Result.INSTANCE;
            SdkInitializer sdkInitializer = this;
            DependencyInjectorKt.initSdkComponents(context);
            DependencyInjectorKt.sdkComponents().postInitializationUseCase().m9509invoked1pmJ48();
            m10241constructorimpl = Result.m10241constructorimpl(AdnInitializationStatus.INITIALIZED_SUCCESS);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
            Logger.INSTANCE.e("SdkInitializer", m10244exceptionOrNullimpl);
        }
        AdnInitializationStatus adnInitializationStatus2 = AdnInitializationStatus.INITIALIZED_FAILURE;
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = adnInitializationStatus2;
        }
        return updateAndGetStatus((AdnInitializationStatus) m10241constructorimpl);
    }

    public final Object awaitInitializationComplete(Continuation<? super AdnInitializationStatus> continuation) {
        return FlowKt.first(this.initializationStateFlow, new SdkInitializer$awaitInitializationComplete$2(null), continuation);
    }

    public final boolean isInitialized() {
        return this.initializationStatus.get() == AdnInitializationStatus.INITIALIZED_SUCCESS;
    }

    private final AdnInitializationStatus updateAndGetStatus(AdnInitializationStatus status) {
        this.initializationStatus.set(status);
        this.initializationStateFlow.setValue(status);
        return status;
    }

    private final boolean wasInitializeAlreadyCalled() {
        return this.initializationStatus.get() != AdnInitializationStatus.NOT_INITIALIZED;
    }
}
