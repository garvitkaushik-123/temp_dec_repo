package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeStateConfigWithLoader.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader", f = "InitializeStateConfigWithLoader.kt", i = {}, l = {33}, m = "doWork-gIAlu-s", n = {}, s = {})
/* loaded from: classes7.dex */
final class InitializeStateConfigWithLoader$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateConfigWithLoader$doWork$1(InitializeStateConfigWithLoader initializeStateConfigWithLoader, Continuation<? super InitializeStateConfigWithLoader$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateConfigWithLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo9271doWorkgIAlus = this.this$0.mo9271doWorkgIAlus((InitializeStateConfigWithLoader.Params) null, (Continuation<? super Result<? extends Configuration>>) this);
        return mo9271doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo9271doWorkgIAlus : Result.m10240boximpl(mo9271doWorkgIAlus);
    }
}
