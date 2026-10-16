package com.unity3d.ads.core.domain.work;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: UniversalRequestJob.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.work.UniversalRequestJob", f = "UniversalRequestJob.kt", i = {0, 0, 1, 1}, l = {25, 28, 31}, m = "doWork$suspendImpl", n = {"$this", UniversalRequestWorkerData.KEY_UNIVERSAL_REQUEST_ID, "$this", UniversalRequestWorkerData.KEY_UNIVERSAL_REQUEST_ID}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes7.dex */
final class UniversalRequestJob$doWork$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UniversalRequestJob this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UniversalRequestJob$doWork$1(UniversalRequestJob universalRequestJob, Continuation<? super UniversalRequestJob$doWork$1> continuation) {
        super(continuation);
        this.this$0 = universalRequestJob;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UniversalRequestJob.doWork$suspendImpl(this.this$0, this);
    }
}
