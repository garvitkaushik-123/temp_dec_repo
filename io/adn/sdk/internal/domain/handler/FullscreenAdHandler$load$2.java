package io.adn.sdk.internal.domain.handler;

import android.app.Activity;
import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.error.AdExceptionKt;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEntity;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.internal.domain.usecase.FetchBidResponseUseCase;
import io.adn.sdk.internal.domain.usecase.LoadFullscreenAdUseCase;
import io.adn.sdk.publisher.AdnAdRequest;
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

/* compiled from: FullscreenAdHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.handler.FullscreenAdHandler$load$2", f = "FullscreenAdHandler.kt", i = {}, l = {62, 64}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class FullscreenAdHandler$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AdnAdRequest $request;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FullscreenAdHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenAdHandler$load$2(FullscreenAdHandler fullscreenAdHandler, AdnAdRequest adnAdRequest, Continuation<? super FullscreenAdHandler$load$2> continuation) {
        super(2, continuation);
        this.this$0 = fullscreenAdHandler;
        this.$request = adnAdRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FullscreenAdHandler$load$2 fullscreenAdHandler$load$2 = new FullscreenAdHandler$load$2(this.this$0, this.$request, continuation);
        fullscreenAdHandler$load$2.L$0 = obj;
        return fullscreenAdHandler$load$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FullscreenAdHandler$load$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        if (r6 == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object m10241constructorimpl;
        DiagnosticReporter diagnosticReporter;
        DiagnosticEventBuilder.AdLoading adLoading;
        FullscreenAdHandler fullscreenAdHandler;
        FetchBidResponseUseCase fetchBidResponseUseCase;
        DiagnosticReporter diagnosticReporter2;
        DiagnosticEventBuilder.AdLoading adLoading2;
        LoadFullscreenAdUseCase loadFullscreenAdUseCase;
        Activity activity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            fullscreenAdHandler = this.this$0;
            AdnAdRequest adnAdRequest = this.$request;
            Result.Companion companion2 = Result.INSTANCE;
            fetchBidResponseUseCase = fullscreenAdHandler.fetchBidUseCase;
            this.L$0 = fullscreenAdHandler;
            this.label = 1;
            obj = fetchBidResponseUseCase.invoke(adnAdRequest, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                m10241constructorimpl = Result.m10241constructorimpl((FullscreenAdEntity) obj);
                FullscreenAdHandler fullscreenAdHandler2 = this.this$0;
                Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                if (m10244exceptionOrNullimpl == null) {
                    fullscreenAdHandler2.onAdLoaded((FullscreenAdEntity) m10241constructorimpl);
                } else {
                    diagnosticReporter = fullscreenAdHandler2.diagnosticReporter;
                    adLoading = fullscreenAdHandler2.diagnosticAdLoading;
                    diagnosticReporter.reportStart(adLoading);
                    Logger.INSTANCE.e("FullscreenAdHandler", m10244exceptionOrNullimpl);
                    fullscreenAdHandler2.onAdLoadFailed(AdExceptionKt.toAdException(m10244exceptionOrNullimpl));
                }
                return Unit.INSTANCE;
            }
            fullscreenAdHandler = (FullscreenAdHandler) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        diagnosticReporter2 = fullscreenAdHandler.diagnosticReporter;
        adLoading2 = fullscreenAdHandler.diagnosticAdLoading;
        diagnosticReporter2.reportStart(adLoading2);
        loadFullscreenAdUseCase = fullscreenAdHandler.loadAdUseCase;
        activity = fullscreenAdHandler.activity;
        this.L$0 = null;
        this.label = 2;
        obj = loadFullscreenAdUseCase.invoke(activity, (BidResponse) obj, this);
    }
}
