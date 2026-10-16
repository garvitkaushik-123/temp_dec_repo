package com.unity3d.services;

import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SDKErrorHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.SDKErrorHandler$sendDiagnostic$1", f = "SDKErrorHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class SDKErrorHandler$sendDiagnostic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ String $reason;
    final /* synthetic */ String $scopeName;
    final /* synthetic */ String $stackTrace;
    int label;
    final /* synthetic */ SDKErrorHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SDKErrorHandler$sendDiagnostic$1(SDKErrorHandler sDKErrorHandler, String str, String str2, String str3, String str4, Continuation<? super SDKErrorHandler$sendDiagnostic$1> continuation) {
        super(2, continuation);
        this.this$0 = sDKErrorHandler;
        this.$name = str;
        this.$reason = str2;
        this.$stackTrace = str3;
        this.$scopeName = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SDKErrorHandler$sendDiagnostic$1(this.this$0, this.$name, this.$reason, this.$stackTrace, this.$scopeName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SDKErrorHandler$sendDiagnostic$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SendDiagnosticEvent sendDiagnosticEvent;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            sendDiagnosticEvent = this.this$0.sendDiagnosticEvent;
            SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, this.$name, null, MapsKt.mapOf(TuplesKt.to("reason", this.$reason), TuplesKt.to("reason_debug", this.$stackTrace), TuplesKt.to("coroutine_name", this.$scopeName)), null, null, null, 58, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
