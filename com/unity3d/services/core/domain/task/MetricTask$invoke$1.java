package com.unity3d.services.core.domain.task;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MetricTask.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.MetricTask", f = "MetricTask.kt", i = {0, 0, 0}, l = {24}, m = "invoke-gIAlu-s$suspendImpl", n = {"$this", "result", "start$iv"}, s = {"L$0", "L$1", "J$0"})
/* loaded from: classes7.dex */
final class MetricTask$invoke$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MetricTask<P, R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MetricTask$invoke$1(MetricTask<? super P, R> metricTask, Continuation<? super MetricTask$invoke$1> continuation) {
        super(continuation);
        this.this$0 = metricTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m9289invokegIAlus$suspendImpl = MetricTask.m9289invokegIAlus$suspendImpl(this.this$0, null, this);
        return m9289invokegIAlus$suspendImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9289invokegIAlus$suspendImpl : Result.m10240boximpl(m9289invokegIAlus$suspendImpl);
    }
}
