package io.adn.sdk.internal.domain.usecase;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GetBidTokenUseCase.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.usecase.GetBidTokenUseCase", f = "GetBidTokenUseCase.kt", i = {0}, l = {17}, m = "invoke-IoAF18A", n = {"this"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class GetBidTokenUseCase$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetBidTokenUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GetBidTokenUseCase$invoke$1(GetBidTokenUseCase getBidTokenUseCase, Continuation<? super GetBidTokenUseCase$invoke$1> continuation) {
        super(continuation);
        this.this$0 = getBidTokenUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m9506invokeIoAF18A = this.this$0.m9506invokeIoAF18A(this);
        return m9506invokeIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9506invokeIoAF18A : Result.m10240boximpl(m9506invokeIoAF18A);
    }
}
