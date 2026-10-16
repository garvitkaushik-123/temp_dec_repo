package io.adn.sdk.internal.data.repository;

import io.adn.sdk.internal.data.api.local.LocalDataSource;
import io.adn.sdk.internal.data.api.remote.RemoteDataSource;
import io.adn.sdk.internal.data.dto.AdRequestBody;
import io.adn.sdk.internal.data.dto.AdResponseDto;
import io.adn.sdk.internal.data.dto.AdResponseDtoKt;
import io.adn.sdk.internal.data.mapper.AdRequestMapperKt;
import io.adn.sdk.internal.domain.repository.BidTokenRepository;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.BidFetcherRepositoryImpl$fetchBidFromNetwork$2", f = "BidFetcherRepositoryImpl.kt", i = {}, l = {34, 36}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class BidFetcherRepositoryImpl$fetchBidFromNetwork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ AdnAdPlacement $placement;
    int label;
    final /* synthetic */ BidFetcherRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BidFetcherRepositoryImpl$fetchBidFromNetwork$2(BidFetcherRepositoryImpl bidFetcherRepositoryImpl, AdnAdPlacement adnAdPlacement, Continuation<? super BidFetcherRepositoryImpl$fetchBidFromNetwork$2> continuation) {
        super(2, continuation);
        this.this$0 = bidFetcherRepositoryImpl;
        this.$placement = adnAdPlacement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BidFetcherRepositoryImpl$fetchBidFromNetwork$2(this.this$0, this.$placement, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((BidFetcherRepositoryImpl$fetchBidFromNetwork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0052, code lost:
    
        if (r6 == r0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r6 == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        BidTokenRepository bidTokenRepository;
        LocalDataSource localDataSource;
        RemoteDataSource remoteDataSource;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            bidTokenRepository = this.this$0.bidTokenRepository;
            this.label = 1;
            obj = bidTokenRepository.buildBidToken(this.$placement, this);
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return AdResponseDtoKt.bidPayload((AdResponseDto) obj);
            }
            ResultKt.throwOnFailure(obj);
        }
        localDataSource = this.this$0.localDataSource;
        AdRequestBody buildAdRequestBody = AdRequestMapperKt.buildAdRequestBody(localDataSource, (String) obj, this.$placement);
        remoteDataSource = this.this$0.remoteDataSource;
        this.label = 2;
        obj = remoteDataSource.fetchAd(buildAdRequestBody, this);
    }
}
