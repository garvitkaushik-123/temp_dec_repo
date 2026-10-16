package io.adn.sdk.internal.domain.usecase;

import io.adn.sdk.internal.di.DependencyInjectorKt;
import io.adn.sdk.internal.domain.error.AdExceptionKt;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.internal.domain.repository.AdMeasurementInitializer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeAdMeasurementUseCase.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.usecase.InitializeAdMeasurementUseCase$invoke$1", f = "InitializeAdMeasurementUseCase.kt", i = {}, l = {21, 22}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class InitializeAdMeasurementUseCase$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InitializeAdMeasurementUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeAdMeasurementUseCase$invoke$1(InitializeAdMeasurementUseCase initializeAdMeasurementUseCase, Continuation<? super InitializeAdMeasurementUseCase$invoke$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeAdMeasurementUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeAdMeasurementUseCase$invoke$1 initializeAdMeasurementUseCase$invoke$1 = new InitializeAdMeasurementUseCase$invoke$1(this.this$0, continuation);
        initializeAdMeasurementUseCase$invoke$1.L$0 = obj;
        return initializeAdMeasurementUseCase$invoke$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeAdMeasurementUseCase$invoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
    
        if (r5.invoke(io.adn.sdk.internal.thirdparty.omsdk.omid.OmidParametersKt.OMID_SDK_JS_URL, 604800000, r4) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object m10241constructorimpl;
        InitializeAdMeasurementUseCase initializeAdMeasurementUseCase;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            initializeAdMeasurementUseCase = this.this$0;
            Result.Companion companion2 = Result.INSTANCE;
            AdMeasurementInitializer adMeasurementInitializer = initializeAdMeasurementUseCase.getAdMeasurementInitializer();
            this.L$0 = initializeAdMeasurementUseCase;
            this.label = 1;
            if (adMeasurementInitializer.initialize(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
                Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                if (m10244exceptionOrNullimpl != null) {
                    DependencyInjectorKt.sdkComponents().createDiagnosticReporter().reportFailure(new DiagnosticEventBuilder.OmidSdkInit(), AdExceptionKt.toAdException(m10244exceptionOrNullimpl));
                }
                return Unit.INSTANCE;
            }
            initializeAdMeasurementUseCase = (InitializeAdMeasurementUseCase) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        FetchOmSdkJsUseCase fetchOmSdkJsUseCase = initializeAdMeasurementUseCase.getFetchOmSdkJsUseCase();
        this.L$0 = null;
        this.label = 2;
    }
}
