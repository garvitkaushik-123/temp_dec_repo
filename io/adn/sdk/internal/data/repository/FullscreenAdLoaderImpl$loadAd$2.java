package io.adn.sdk.internal.data.repository;

import io.adn.sdk.internal.data.mapper.FullscreenAdMapperKt;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEntity;
import io.adn.sdk.internal.domain.model.ad.VastAdEntity;
import io.adn.sdk.internal.domain.repository.VastLoader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FullscreenAdLoader.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.FullscreenAdLoaderImpl$loadAd$2", f = "FullscreenAdLoader.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class FullscreenAdLoaderImpl$loadAd$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FullscreenAdEntity>, Object> {
    final /* synthetic */ BidResponse $bidResponse;
    int label;
    final /* synthetic */ FullscreenAdLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenAdLoaderImpl$loadAd$2(FullscreenAdLoaderImpl fullscreenAdLoaderImpl, BidResponse bidResponse, Continuation<? super FullscreenAdLoaderImpl$loadAd$2> continuation) {
        super(2, continuation);
        this.this$0 = fullscreenAdLoaderImpl;
        this.$bidResponse = bidResponse;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FullscreenAdLoaderImpl$loadAd$2(this.this$0, this.$bidResponse, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FullscreenAdEntity> continuation) {
        return ((FullscreenAdLoaderImpl$loadAd$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        VastLoader vastLoader;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            vastLoader = this.this$0.vastLoader;
            this.label = 1;
            obj = vastLoader.invoke(this.$bidResponse.getAdm(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return FullscreenAdMapperKt.mapToFullscreenAd((VastAdEntity) obj, this.$bidResponse);
    }
}
