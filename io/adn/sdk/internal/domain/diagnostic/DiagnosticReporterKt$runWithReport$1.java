package io.adn.sdk.internal.domain.diagnostic;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DiagnosticReporter.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.diagnostic.DiagnosticReporterKt", f = "DiagnosticReporter.kt", i = {0, 0}, l = {26}, m = "runWithReport", n = {"diagnosticEventBuilder", "diagnosticReporter"}, s = {"L$0", "L$1"})
/* loaded from: classes7.dex */
final class DiagnosticReporterKt$runWithReport$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    DiagnosticReporterKt$runWithReport$1(Continuation<? super DiagnosticReporterKt$runWithReport$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object runWithReport = DiagnosticReporterKt.runWithReport(null, null, null, this);
        return runWithReport == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? runWithReport : Result.m10240boximpl(runWithReport);
    }
}
