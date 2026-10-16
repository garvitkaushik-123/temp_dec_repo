package io.adn.sdk.internal.domain.usecase;

import io.adn.sdk.internal.domain.repository.BidFetcherRepository;
import io.adn.sdk.publisher.AdnAdPlacement;
import io.adn.sdk.publisher.AdnAdRequest;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: FetchBidResponseUseCase.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.usecase.FetchBidResponseUseCase$fetchPayloadWithDiagnostics$2", f = "FetchBidResponseUseCase.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class FetchBidResponseUseCase$fetchPayloadWithDiagnostics$2 extends SuspendLambda implements Function1<Continuation<? super Result<? extends String>>, Object> {
    final /* synthetic */ AdnAdRequest.AdBidFetchRequest $request;
    int label;
    final /* synthetic */ FetchBidResponseUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FetchBidResponseUseCase$fetchPayloadWithDiagnostics$2(FetchBidResponseUseCase fetchBidResponseUseCase, AdnAdRequest.AdBidFetchRequest adBidFetchRequest, Continuation<? super FetchBidResponseUseCase$fetchPayloadWithDiagnostics$2> continuation) {
        super(1, continuation);
        this.this$0 = fetchBidResponseUseCase;
        this.$request = adBidFetchRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new FetchBidResponseUseCase$fetchPayloadWithDiagnostics$2(this.this$0, this.$request, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Result<? extends String>> continuation) {
        return invoke2((Continuation<? super Result<String>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Result<String>> continuation) {
        return ((FetchBidResponseUseCase$fetchPayloadWithDiagnostics$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m10241constructorimpl;
        BidFetcherRepository bidFetcherRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FetchBidResponseUseCase fetchBidResponseUseCase = this.this$0;
                AdnAdRequest.AdBidFetchRequest adBidFetchRequest = this.$request;
                Result.Companion companion = Result.INSTANCE;
                bidFetcherRepository = fetchBidResponseUseCase.bidFetcherRepository;
                AdnAdPlacement placement = adBidFetchRequest.getPlacement();
                this.label = 1;
                obj = bidFetcherRepository.fetchBidFromNetwork(placement, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            m10241constructorimpl = Result.m10241constructorimpl((String) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m10240boximpl(m10241constructorimpl);
    }
}
