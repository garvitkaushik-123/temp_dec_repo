package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DiagnosticTrackerImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.DiagnosticTrackerImpl", f = "DiagnosticTrackerImpl.kt", i = {}, l = {61}, m = "sendEvents-gIAlu-s", n = {}, s = {})
/* loaded from: classes7.dex */
final class DiagnosticTrackerImpl$sendEvents$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DiagnosticTrackerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiagnosticTrackerImpl$sendEvents$1(DiagnosticTrackerImpl diagnosticTrackerImpl, Continuation<? super DiagnosticTrackerImpl$sendEvents$1> continuation) {
        super(continuation);
        this.this$0 = diagnosticTrackerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9480sendEventsgIAlus;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m9480sendEventsgIAlus = this.this$0.m9480sendEventsgIAlus(null, this);
        return m9480sendEventsgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9480sendEventsgIAlus : Result.m10240boximpl(m9480sendEventsgIAlus);
    }
}
