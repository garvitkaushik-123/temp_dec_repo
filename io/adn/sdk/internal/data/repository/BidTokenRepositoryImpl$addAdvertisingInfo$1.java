package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BidTokenRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.BidTokenRepositoryImpl", f = "BidTokenRepository.kt", i = {0}, l = {149}, m = "addAdvertisingInfo", n = {"jsonObject"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class BidTokenRepositoryImpl$addAdvertisingInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BidTokenRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BidTokenRepositoryImpl$addAdvertisingInfo$1(BidTokenRepositoryImpl bidTokenRepositoryImpl, Continuation<? super BidTokenRepositoryImpl$addAdvertisingInfo$1> continuation) {
        super(continuation);
        this.this$0 = bidTokenRepositoryImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object addAdvertisingInfo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        addAdvertisingInfo = this.this$0.addAdvertisingInfo(null, this);
        return addAdvertisingInfo;
    }
}
