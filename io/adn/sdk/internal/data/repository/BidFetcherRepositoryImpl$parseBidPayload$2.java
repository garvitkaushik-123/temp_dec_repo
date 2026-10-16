package io.adn.sdk.internal.data.repository;

import io.adn.sdk.internal.data.mapper.BidResponseMapperKt;
import io.adn.sdk.internal.data.parser.AdJsonParser;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.publisher.AdnAdPlacement;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BidFetcherRepositoryImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.BidFetcherRepositoryImpl$parseBidPayload$2", f = "BidFetcherRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class BidFetcherRepositoryImpl$parseBidPayload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BidResponse>, Object> {
    final /* synthetic */ String $bidPayload;
    final /* synthetic */ AdnAdPlacement $placement;
    int label;
    final /* synthetic */ BidFetcherRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BidFetcherRepositoryImpl$parseBidPayload$2(BidFetcherRepositoryImpl bidFetcherRepositoryImpl, String str, AdnAdPlacement adnAdPlacement, Continuation<? super BidFetcherRepositoryImpl$parseBidPayload$2> continuation) {
        super(2, continuation);
        this.this$0 = bidFetcherRepositoryImpl;
        this.$bidPayload = str;
        this.$placement = adnAdPlacement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BidFetcherRepositoryImpl$parseBidPayload$2(this.this$0, this.$bidPayload, this.$placement, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BidResponse> continuation) {
        return ((BidFetcherRepositoryImpl$parseBidPayload$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AdJsonParser adJsonParser;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            adJsonParser = this.this$0.jsonParser;
            return BidResponseMapperKt.mapToBidResponse(this.$placement, adJsonParser.parseBidResponse(this.$bidPayload));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
