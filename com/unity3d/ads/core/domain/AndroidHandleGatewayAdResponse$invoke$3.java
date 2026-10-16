package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.AndroidWebViewContainer;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;

/* compiled from: AndroidHandleGatewayAdResponse.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$3", f = "AndroidHandleGatewayAdResponse.kt", i = {0}, l = {176}, m = "invokeSuspend", n = {"mark$iv$iv"}, s = {"J$0"})
/* loaded from: classes7.dex */
final class AndroidHandleGatewayAdResponse$invoke$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ AdObject $tmpAdObject;
    final /* synthetic */ String $webViewUrl;
    final /* synthetic */ AndroidWebViewContainer $webviewContainer;
    long J$0;
    int label;
    final /* synthetic */ AndroidHandleGatewayAdResponse this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidHandleGatewayAdResponse$invoke$3(AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse, AndroidWebViewContainer androidWebViewContainer, String str, AdObject adObject, Continuation<? super AndroidHandleGatewayAdResponse$invoke$3> continuation) {
        super(1, continuation);
        this.this$0 = androidHandleGatewayAdResponse;
        this.$webviewContainer = androidWebViewContainer;
        this.$webViewUrl = str;
        this.$tmpAdObject = adObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AndroidHandleGatewayAdResponse$invoke$3(this.this$0, this.$webviewContainer, this.$webViewUrl, this.$tmpAdObject, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((AndroidHandleGatewayAdResponse$invoke$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0078  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        long j;
        Object m10241constructorimpl;
        SendDiagnosticEvent sendDiagnosticEvent;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AndroidWebViewContainer androidWebViewContainer = this.$webviewContainer;
            String str = this.$webViewUrl;
            long m11706markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
            try {
                Result.Companion companion = Result.INSTANCE;
                this.J$0 = m11706markNowz9LOYto;
                this.label = 1;
                if (androidWebViewContainer.loadUrl(str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j = m11706markNowz9LOYto;
            } catch (Throwable th2) {
                th = th2;
                j = m11706markNowz9LOYto;
                Result.Companion companion2 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                TimedValue timedValue = new TimedValue(Result.m10240boximpl(m10241constructorimpl), TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(j), null);
                AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse = this.this$0;
                AdObject adObject = this.$tmpAdObject;
                Object value = ((Result) timedValue.component1()).getValue();
                long duration = timedValue.getDuration();
                sendDiagnosticEvent = androidHandleGatewayAdResponse.sendDiagnosticEvent;
                SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, Result.m10248isSuccessimpl(value) ? "native_load_file_task_success_time" : "native_load_file_task_failure_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(duration, DurationUnit.MILLISECONDS)), null, null, adObject, null, 44, null);
                ResultKt.throwOnFailure(value);
                return Unit.INSTANCE;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = this.J$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                Result.Companion companion22 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                TimedValue timedValue2 = new TimedValue(Result.m10240boximpl(m10241constructorimpl), TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(j), null);
                AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse2 = this.this$0;
                AdObject adObject2 = this.$tmpAdObject;
                Object value2 = ((Result) timedValue2.component1()).getValue();
                long duration2 = timedValue2.getDuration();
                sendDiagnosticEvent = androidHandleGatewayAdResponse2.sendDiagnosticEvent;
                SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, Result.m10248isSuccessimpl(value2) ? "native_load_file_task_success_time" : "native_load_file_task_failure_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(duration2, DurationUnit.MILLISECONDS)), null, null, adObject2, null, 44, null);
                ResultKt.throwOnFailure(value2);
                return Unit.INSTANCE;
            }
        }
        m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
        TimedValue timedValue22 = new TimedValue(Result.m10240boximpl(m10241constructorimpl), TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(j), null);
        AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse22 = this.this$0;
        AdObject adObject22 = this.$tmpAdObject;
        Object value22 = ((Result) timedValue22.component1()).getValue();
        long duration22 = timedValue22.getDuration();
        sendDiagnosticEvent = androidHandleGatewayAdResponse22.sendDiagnosticEvent;
        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, Result.m10248isSuccessimpl(value22) ? "native_load_file_task_success_time" : "native_load_file_task_failure_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(duration22, DurationUnit.MILLISECONDS)), null, null, adObject22, null, 44, null);
        ResultKt.throwOnFailure(value22);
        return Unit.INSTANCE;
    }
}
