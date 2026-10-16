package com.unity3d.ads.core.domain.work;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DiagnosticEventJob.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.work.DiagnosticEventJob", f = "DiagnosticEventJob.kt", i = {0, 0, 1}, l = {22, 25, 27}, m = "doWork", n = {"this", UniversalRequestWorkerData.KEY_UNIVERSAL_REQUEST_ID, "this"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes7.dex */
final class DiagnosticEventJob$doWork$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DiagnosticEventJob this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiagnosticEventJob$doWork$1(DiagnosticEventJob diagnosticEventJob, Continuation<? super DiagnosticEventJob$doWork$1> continuation) {
        super(continuation);
        this.this$0 = diagnosticEventJob;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork(this);
    }
}
