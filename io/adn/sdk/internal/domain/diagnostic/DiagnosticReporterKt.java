package io.adn.sdk.internal.domain.diagnostic;

import io.adn.sdk.internal.domain.error.AdExceptionKt;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: DiagnosticReporter.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0080@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"runWithReport", "Lkotlin/Result;", "T", "diagnosticEventBuilder", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DiagnosticReporterKt {
    /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object runWithReport(DiagnosticEventBuilder diagnosticEventBuilder, DiagnosticReporter diagnosticReporter, Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, Continuation<? super Result<? extends T>> continuation) {
        DiagnosticReporterKt$runWithReport$1 diagnosticReporterKt$runWithReport$1;
        int i;
        Throwable m10244exceptionOrNullimpl;
        if (continuation instanceof DiagnosticReporterKt$runWithReport$1) {
            diagnosticReporterKt$runWithReport$1 = (DiagnosticReporterKt$runWithReport$1) continuation;
            if ((diagnosticReporterKt$runWithReport$1.label & Integer.MIN_VALUE) != 0) {
                diagnosticReporterKt$runWithReport$1.label -= Integer.MIN_VALUE;
                Object obj = diagnosticReporterKt$runWithReport$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = diagnosticReporterKt$runWithReport$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    diagnosticReporter.reportStart(diagnosticEventBuilder);
                    diagnosticReporterKt$runWithReport$1.L$0 = diagnosticEventBuilder;
                    diagnosticReporterKt$runWithReport$1.L$1 = diagnosticReporter;
                    diagnosticReporterKt$runWithReport$1.label = 1;
                    obj = function1.invoke(diagnosticReporterKt$runWithReport$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    diagnosticReporter = (DiagnosticReporter) diagnosticReporterKt$runWithReport$1.L$1;
                    diagnosticEventBuilder = (DiagnosticEventBuilder) diagnosticReporterKt$runWithReport$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Object value = ((Result) obj).getValue();
                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(value);
                if (m10244exceptionOrNullimpl != null) {
                    diagnosticReporter.reportSuccess(diagnosticEventBuilder);
                    return value;
                }
                diagnosticReporter.reportFailure(diagnosticEventBuilder, AdExceptionKt.toAdException(m10244exceptionOrNullimpl));
                return value;
            }
        }
        diagnosticReporterKt$runWithReport$1 = new DiagnosticReporterKt$runWithReport$1(continuation);
        Object obj2 = diagnosticReporterKt$runWithReport$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = diagnosticReporterKt$runWithReport$1.label;
        if (i != 0) {
        }
        Object value2 = ((Result) obj2).getValue();
        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(value2);
        if (m10244exceptionOrNullimpl != null) {
        }
    }
}
