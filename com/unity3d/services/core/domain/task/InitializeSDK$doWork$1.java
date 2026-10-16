package com.unity3d.services.core.domain.task;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeSDK.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeSDK", f = "InitializeSDK.kt", i = {}, l = {40}, m = "doWork-gIAlu-s", n = {}, s = {})
/* loaded from: classes7.dex */
final class InitializeSDK$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeSDK$doWork$1(InitializeSDK initializeSDK, Continuation<? super InitializeSDK$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m9277doWorkgIAlus = this.this$0.m9277doWorkgIAlus((EmptyParams) null, (Continuation<? super Result<Unit>>) this);
        return m9277doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9277doWorkgIAlus : Result.m10240boximpl(m9277doWorkgIAlus);
    }
}
