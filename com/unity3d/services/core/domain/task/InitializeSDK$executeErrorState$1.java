package com.unity3d.services.core.domain.task;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeSDK.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeSDK", f = "InitializeSDK.kt", i = {}, l = {120}, m = "executeErrorState-BWLJW6A", n = {}, s = {})
/* loaded from: classes7.dex */
final class InitializeSDK$executeErrorState$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeSDK$executeErrorState$1(InitializeSDK initializeSDK, Continuation<? super InitializeSDK$executeErrorState$1> continuation) {
        super(continuation);
        this.this$0 = initializeSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9276executeErrorStateBWLJW6A;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m9276executeErrorStateBWLJW6A = this.this$0.m9276executeErrorStateBWLJW6A(null, null, null, this);
        return m9276executeErrorStateBWLJW6A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9276executeErrorStateBWLJW6A : Result.m10240boximpl(m9276executeErrorStateBWLJW6A);
    }
}
