package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BidTokenRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.BidTokenRepositoryImpl", f = "BidTokenRepository.kt", i = {0, 0, 0, 0}, l = {106}, m = "addSystemInfo", n = {"this", "jsonObject", "systemInfo", "$this$addSystemInfo_u24lambda_u244"}, s = {"L$0", "L$1", "L$2", "L$4"})
/* loaded from: classes7.dex */
final class BidTokenRepositoryImpl$addSystemInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BidTokenRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BidTokenRepositoryImpl$addSystemInfo$1(BidTokenRepositoryImpl bidTokenRepositoryImpl, Continuation<? super BidTokenRepositoryImpl$addSystemInfo$1> continuation) {
        super(continuation);
        this.this$0 = bidTokenRepositoryImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object addSystemInfo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        addSystemInfo = this.this$0.addSystemInfo(null, this);
        return addSystemInfo;
    }
}
