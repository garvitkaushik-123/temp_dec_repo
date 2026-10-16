package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CommonInitAwaitingGetHeaderBiddingToken.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken", f = "CommonInitAwaitingGetHeaderBiddingToken.kt", i = {0, 0, 0}, l = {54, 66}, m = "invoke", n = {"this", "tokenConfiguration", "tokenNumber"}, s = {"L$0", "L$1", "I$0"})
/* loaded from: classes7.dex */
final class CommonInitAwaitingGetHeaderBiddingToken$invoke$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonInitAwaitingGetHeaderBiddingToken this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonInitAwaitingGetHeaderBiddingToken$invoke$1(CommonInitAwaitingGetHeaderBiddingToken commonInitAwaitingGetHeaderBiddingToken, Continuation<? super CommonInitAwaitingGetHeaderBiddingToken$invoke$1> continuation) {
        super(continuation);
        this.this$0 = commonInitAwaitingGetHeaderBiddingToken;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(0, null, null, this);
    }
}
