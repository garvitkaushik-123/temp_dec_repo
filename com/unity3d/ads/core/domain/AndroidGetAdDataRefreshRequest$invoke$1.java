package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidGetAdDataRefreshRequest.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidGetAdDataRefreshRequest", f = "AndroidGetAdDataRefreshRequest.kt", i = {0, 0, 0, 0}, l = {25, 34}, m = "invoke", n = {"this", "opportunityId", "refreshToken", "$this$invoke_u24lambda_u240"}, s = {"L$0", "L$1", "L$2", "L$4"})
/* loaded from: classes7.dex */
final class AndroidGetAdDataRefreshRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidGetAdDataRefreshRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidGetAdDataRefreshRequest$invoke$1(AndroidGetAdDataRefreshRequest androidGetAdDataRefreshRequest, Continuation<? super AndroidGetAdDataRefreshRequest$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidGetAdDataRefreshRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, null, this);
    }
}
