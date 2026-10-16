package com.unity3d.services.core.domain.task;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeSDK.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeSDK", f = "InitializeSDK.kt", i = {0}, l = {111}, m = "handleInitializationException", n = {"exception"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class InitializeSDK$handleInitializationException$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeSDK$handleInitializationException$1(InitializeSDK initializeSDK, Continuation<? super InitializeSDK$handleInitializationException$1> continuation) {
        super(continuation);
        this.this$0 = initializeSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object handleInitializationException;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleInitializationException = this.this$0.handleInitializationException(null, this);
        return handleInitializationException;
    }
}
