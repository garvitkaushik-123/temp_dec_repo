package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeStateLoadWeb.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb", f = "InitializeStateLoadWeb.kt", i = {}, l = {39}, m = "doWork-gIAlu-s", n = {}, s = {})
/* loaded from: classes7.dex */
final class InitializeStateLoadWeb$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$1(InitializeStateLoadWeb initializeStateLoadWeb, Continuation<? super InitializeStateLoadWeb$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateLoadWeb;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m9285doWorkgIAlus = this.this$0.m9285doWorkgIAlus((InitializeStateLoadWeb.Params) null, (Continuation<? super Result<InitializeStateLoadWeb.LoadWebResult>>) this);
        return m9285doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9285doWorkgIAlus : Result.m10240boximpl(m9285doWorkgIAlus);
    }
}
