package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DiagnosticTrackerImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.DiagnosticTrackerImpl", f = "DiagnosticTrackerImpl.kt", i = {0, 0}, l = {46}, m = "flushEvents", n = {"$this$flushEvents_u24lambda_u244", "eventsToSend"}, s = {"L$0", "L$1"})
/* loaded from: classes7.dex */
final class DiagnosticTrackerImpl$flushEvents$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DiagnosticTrackerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiagnosticTrackerImpl$flushEvents$1(DiagnosticTrackerImpl diagnosticTrackerImpl, Continuation<? super DiagnosticTrackerImpl$flushEvents$1> continuation) {
        super(continuation);
        this.this$0 = diagnosticTrackerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.flushEvents(this);
    }
}
