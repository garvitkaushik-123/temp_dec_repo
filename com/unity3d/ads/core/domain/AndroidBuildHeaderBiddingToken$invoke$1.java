package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidBuildHeaderBiddingToken.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidBuildHeaderBiddingToken", f = "AndroidBuildHeaderBiddingToken.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {40, 52, 57, 60, 62}, m = "invoke", n = {"this", "tokenConfiguration", "currentTokenCounters", "sToken", "$this$invoke_u24lambda_u244", "scarSignalsCollected", "this", "currentTokenCounters", "sToken", "$this$invoke_u24lambda_u244", "this", "currentTokenCounters", "$this$invoke_u24lambda_u244", "this", "currentTokenCounters", "$this$invoke_u24lambda_u244", "this", "currentTokenCounters", "$this$invoke_u24lambda_u244"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
/* loaded from: classes7.dex */
final class AndroidBuildHeaderBiddingToken$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidBuildHeaderBiddingToken this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidBuildHeaderBiddingToken$invoke$1(AndroidBuildHeaderBiddingToken androidBuildHeaderBiddingToken, Continuation<? super AndroidBuildHeaderBiddingToken$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidBuildHeaderBiddingToken;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(0, null, false, this);
    }
}
