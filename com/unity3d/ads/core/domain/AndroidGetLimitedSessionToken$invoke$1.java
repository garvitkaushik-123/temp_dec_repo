package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidGetLimitedSessionToken.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidGetLimitedSessionToken", f = "AndroidGetLimitedSessionToken.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {19, 20, 21, 22}, m = "invoke", n = {"this", "$this$invoke_u24lambda_u243", "this", "$this$invoke_u24lambda_u243", "this", "$this$invoke_u24lambda_u243", "this", "$this$invoke_u24lambda_u243"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
/* loaded from: classes7.dex */
final class AndroidGetLimitedSessionToken$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidGetLimitedSessionToken this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidGetLimitedSessionToken$invoke$1(AndroidGetLimitedSessionToken androidGetLimitedSessionToken, Continuation<? super AndroidGetLimitedSessionToken$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidGetLimitedSessionToken;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(this);
    }
}
