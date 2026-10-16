package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.ExceptionExtensionsKt;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.ads.gatewayclient.RequestPolicy;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeSource;

/* compiled from: AndroidTriggerInitializationCompletedRequest.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\fH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidTriggerInitializationCompletedRequest;", "Lcom/unity3d/ads/core/domain/TriggerInitializationCompletedRequest;", "getInitializationCompletedRequest", "Lcom/unity3d/ads/core/domain/GetInitializationCompletedRequest;", "getRequestPolicy", "Lcom/unity3d/ads/core/domain/GetRequestPolicy;", "gatewayClient", "Lcom/unity3d/ads/gatewayclient/GatewayClient;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "(Lcom/unity3d/ads/core/domain/GetInitializationCompletedRequest;Lcom/unity3d/ads/core/domain/GetRequestPolicy;Lcom/unity3d/ads/gatewayclient/GatewayClient;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidTriggerInitializationCompletedRequest implements TriggerInitializationCompletedRequest {
    private final GatewayClient gatewayClient;
    private final GetInitializationCompletedRequest getInitializationCompletedRequest;
    private final GetRequestPolicy getRequestPolicy;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public AndroidTriggerInitializationCompletedRequest(GetInitializationCompletedRequest getInitializationCompletedRequest, GetRequestPolicy getRequestPolicy, GatewayClient gatewayClient, SendDiagnosticEvent sendDiagnosticEvent) {
        Intrinsics.checkNotNullParameter(getInitializationCompletedRequest, "getInitializationCompletedRequest");
        Intrinsics.checkNotNullParameter(getRequestPolicy, "getRequestPolicy");
        Intrinsics.checkNotNullParameter(gatewayClient, "gatewayClient");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.getInitializationCompletedRequest = getInitializationCompletedRequest;
        this.getRequestPolicy = getRequestPolicy;
        this.gatewayClient = gatewayClient;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|1|(2:3|(10:5|6|(4:(1:(7:10|11|12|13|14|15|(2:17|18)(2:21|22))(2:29|30))(3:31|32|33)|28|24|25)(5:51|52|53|(1:55)|41)|35|36|37|38|39|(4:42|14|15|(0)(0))|41))|59|6|(0)(0)|35|36|37|38|39|(0)|41|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x013f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x014b, code lost:
    
        r6 = r16;
        r2 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0141, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0142, code lost:
    
        r16 = r3;
        r17 = 2;
        r15 = 1;
        r18 = r6;
        r30 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cf A[Catch: Exception -> 0x013d, TRY_LEAVE, TryCatch #2 {Exception -> 0x013d, blocks: (B:15:0x00c7, B:17:0x00cf), top: B:14:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    @Override // com.unity3d.ads.core.domain.TriggerInitializationCompletedRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(Continuation<? super Unit> continuation) {
        AndroidTriggerInitializationCompletedRequest$invoke$1 androidTriggerInitializationCompletedRequest$invoke$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        long m11706markNowz9LOYto;
        char c;
        int i2;
        int i3;
        long j;
        AndroidTriggerInitializationCompletedRequest androidTriggerInitializationCompletedRequest;
        AndroidTriggerInitializationCompletedRequest androidTriggerInitializationCompletedRequest2;
        UniversalResponseOuterClass.UniversalResponse universalResponse;
        if (continuation instanceof AndroidTriggerInitializationCompletedRequest$invoke$1) {
            androidTriggerInitializationCompletedRequest$invoke$1 = (AndroidTriggerInitializationCompletedRequest$invoke$1) continuation;
            if ((androidTriggerInitializationCompletedRequest$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidTriggerInitializationCompletedRequest$invoke$1.label -= Integer.MIN_VALUE;
                AndroidTriggerInitializationCompletedRequest$invoke$1 androidTriggerInitializationCompletedRequest$invoke$12 = androidTriggerInitializationCompletedRequest$invoke$1;
                obj = androidTriggerInitializationCompletedRequest$invoke$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidTriggerInitializationCompletedRequest$invoke$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    m11706markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                    SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_initialization_completed_event_request_started", null, null, null, null, null, 62, null);
                    try {
                        GetInitializationCompletedRequest getInitializationCompletedRequest = this.getInitializationCompletedRequest;
                        androidTriggerInitializationCompletedRequest$invoke$12.L$0 = this;
                        androidTriggerInitializationCompletedRequest$invoke$12.J$0 = m11706markNowz9LOYto;
                        androidTriggerInitializationCompletedRequest$invoke$12.label = 1;
                        obj = getInitializationCompletedRequest.invoke(androidTriggerInitializationCompletedRequest$invoke$12);
                        if (obj != coroutine_suspended) {
                            androidTriggerInitializationCompletedRequest2 = this;
                        }
                        return coroutine_suspended;
                    } catch (Exception e) {
                        e = e;
                        c = 2;
                        i2 = 1;
                        i3 = 0;
                        j = m11706markNowz9LOYto;
                        androidTriggerInitializationCompletedRequest = this;
                    }
                } else {
                    if (i == 1) {
                        m11706markNowz9LOYto = androidTriggerInitializationCompletedRequest$invoke$12.J$0;
                        androidTriggerInitializationCompletedRequest2 = (AndroidTriggerInitializationCompletedRequest) androidTriggerInitializationCompletedRequest$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Exception e2) {
                            e = e2;
                            androidTriggerInitializationCompletedRequest = androidTriggerInitializationCompletedRequest2;
                            j = m11706markNowz9LOYto;
                        }
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        j = androidTriggerInitializationCompletedRequest$invoke$12.J$0;
                        androidTriggerInitializationCompletedRequest = (AndroidTriggerInitializationCompletedRequest) androidTriggerInitializationCompletedRequest$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            c = 2;
                            i2 = 1;
                            i3 = 0;
                            try {
                                universalResponse = (UniversalResponseOuterClass.UniversalResponse) obj;
                                if (!universalResponse.hasError()) {
                                    SendDiagnosticEvent sendDiagnosticEvent = androidTriggerInitializationCompletedRequest.sendDiagnosticEvent;
                                    Double boxDouble = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j)));
                                    Pair[] pairArr = new Pair[3];
                                    pairArr[i3] = TuplesKt.to("operation", OperationType.INITIALIZATION_COMPLETED.toString());
                                    pairArr[i2] = TuplesKt.to("reason", "gateway");
                                    pairArr[c] = TuplesKt.to("reason_debug", universalResponse.getError().getErrorText());
                                    SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_initialization_completed_event_request_failure_time", boxDouble, MapsKt.mapOf(pairArr), null, null, null, 56, null);
                                    return Unit.INSTANCE;
                                }
                                SendDiagnosticEvent.DefaultImpls.invoke$default(androidTriggerInitializationCompletedRequest.sendDiagnosticEvent, "native_initialization_completed_event_request_success_time", Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j))), null, null, null, null, 60, null);
                                return Unit.INSTANCE;
                            } catch (Exception e3) {
                                e = e3;
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                    }
                    c = 2;
                    i2 = 1;
                    i3 = 0;
                    SendDiagnosticEvent sendDiagnosticEvent2 = androidTriggerInitializationCompletedRequest.sendDiagnosticEvent;
                    Double boxDouble2 = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j)));
                    Pair[] pairArr2 = new Pair[3];
                    pairArr2[i3] = TuplesKt.to("operation", OperationType.INITIALIZATION_COMPLETED.toString());
                    pairArr2[i2] = TuplesKt.to("reason", "uncaught_exception");
                    pairArr2[c] = TuplesKt.to("reason_debug", ExceptionExtensionsKt.getShortenedStackTrace$default(e, i3, i2, null));
                    SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent2, "native_initialization_completed_event_request_failure_time", boxDouble2, MapsKt.mapOf(pairArr2), null, null, null, 56, null);
                    return Unit.INSTANCE;
                }
                UniversalRequestOuterClass.UniversalRequest universalRequest = (UniversalRequestOuterClass.UniversalRequest) obj;
                RequestPolicy invoke = androidTriggerInitializationCompletedRequest2.getRequestPolicy.invoke();
                GatewayClient gatewayClient = androidTriggerInitializationCompletedRequest2.gatewayClient;
                OperationType operationType = OperationType.INITIALIZATION_COMPLETED;
                androidTriggerInitializationCompletedRequest$invoke$12.L$0 = androidTriggerInitializationCompletedRequest2;
                androidTriggerInitializationCompletedRequest$invoke$12.J$0 = m11706markNowz9LOYto;
                androidTriggerInitializationCompletedRequest$invoke$12.label = 2;
                c = 2;
                long j2 = m11706markNowz9LOYto;
                AndroidTriggerInitializationCompletedRequest androidTriggerInitializationCompletedRequest3 = androidTriggerInitializationCompletedRequest2;
                i2 = 1;
                i3 = 0;
                obj = GatewayClient.DefaultImpls.request$default(gatewayClient, null, universalRequest, invoke, operationType, androidTriggerInitializationCompletedRequest$invoke$12, 1, null);
                if (obj != coroutine_suspended) {
                    androidTriggerInitializationCompletedRequest = androidTriggerInitializationCompletedRequest3;
                    j = j2;
                    universalResponse = (UniversalResponseOuterClass.UniversalResponse) obj;
                    if (!universalResponse.hasError()) {
                    }
                }
                return coroutine_suspended;
            }
        }
        androidTriggerInitializationCompletedRequest$invoke$1 = new AndroidTriggerInitializationCompletedRequest$invoke$1(this, continuation);
        AndroidTriggerInitializationCompletedRequest$invoke$1 androidTriggerInitializationCompletedRequest$invoke$122 = androidTriggerInitializationCompletedRequest$invoke$1;
        obj = androidTriggerInitializationCompletedRequest$invoke$122.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidTriggerInitializationCompletedRequest$invoke$122.label;
        if (i != 0) {
        }
        UniversalRequestOuterClass.UniversalRequest universalRequest2 = (UniversalRequestOuterClass.UniversalRequest) obj;
        RequestPolicy invoke2 = androidTriggerInitializationCompletedRequest2.getRequestPolicy.invoke();
        GatewayClient gatewayClient2 = androidTriggerInitializationCompletedRequest2.gatewayClient;
        OperationType operationType2 = OperationType.INITIALIZATION_COMPLETED;
        androidTriggerInitializationCompletedRequest$invoke$122.L$0 = androidTriggerInitializationCompletedRequest2;
        androidTriggerInitializationCompletedRequest$invoke$122.J$0 = m11706markNowz9LOYto;
        androidTriggerInitializationCompletedRequest$invoke$122.label = 2;
        c = 2;
        long j22 = m11706markNowz9LOYto;
        AndroidTriggerInitializationCompletedRequest androidTriggerInitializationCompletedRequest32 = androidTriggerInitializationCompletedRequest2;
        i2 = 1;
        i3 = 0;
        obj = GatewayClient.DefaultImpls.request$default(gatewayClient2, null, universalRequest2, invoke2, operationType2, androidTriggerInitializationCompletedRequest$invoke$122, 1, null);
        if (obj != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
