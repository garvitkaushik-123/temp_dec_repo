package io.adn.sdk.internal.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FetchBidResponseUseCase.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.usecase.FetchBidResponseUseCase", f = "FetchBidResponseUseCase.kt", i = {}, l = {34}, m = "fetchPayloadWithDiagnostics", n = {}, s = {})
/* loaded from: classes7.dex */
final class FetchBidResponseUseCase$fetchPayloadWithDiagnostics$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FetchBidResponseUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FetchBidResponseUseCase$fetchPayloadWithDiagnostics$1(FetchBidResponseUseCase fetchBidResponseUseCase, Continuation<? super FetchBidResponseUseCase$fetchPayloadWithDiagnostics$1> continuation) {
        super(continuation);
        this.this$0 = fetchBidResponseUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fetchPayloadWithDiagnostics;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchPayloadWithDiagnostics = this.this$0.fetchPayloadWithDiagnostics(null, this);
        return fetchPayloadWithDiagnostics;
    }
}
