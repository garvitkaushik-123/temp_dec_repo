package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.ads.gatewayclient.RequestPolicy;
import gatewayprotocol.v1.PrivacyUpdateResponseOuterClass;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SendPrivacyUpdateRequest.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ!\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086Bø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/unity3d/ads/core/domain/SendPrivacyUpdateRequest;", "", "getPrivacyUpdateRequest", "Lcom/unity3d/ads/core/domain/GetPrivacyUpdateRequest;", "getRequestPolicy", "Lcom/unity3d/ads/core/domain/GetRequestPolicy;", "gatewayClient", "Lcom/unity3d/ads/gatewayclient/GatewayClient;", "(Lcom/unity3d/ads/core/domain/GetPrivacyUpdateRequest;Lcom/unity3d/ads/core/domain/GetRequestPolicy;Lcom/unity3d/ads/gatewayclient/GatewayClient;)V", "invoke", "Lgatewayprotocol/v1/PrivacyUpdateResponseOuterClass$PrivacyUpdateResponse;", "privacyUpdateVersion", "", "privacyUpdateContent", "Lcom/google/protobuf/ByteString;", "(ILcom/google/protobuf/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class SendPrivacyUpdateRequest {
    private final GatewayClient gatewayClient;
    private final GetPrivacyUpdateRequest getPrivacyUpdateRequest;
    private final GetRequestPolicy getRequestPolicy;

    public SendPrivacyUpdateRequest(GetPrivacyUpdateRequest getPrivacyUpdateRequest, GetRequestPolicy getRequestPolicy, GatewayClient gatewayClient) {
        Intrinsics.checkNotNullParameter(getPrivacyUpdateRequest, "getPrivacyUpdateRequest");
        Intrinsics.checkNotNullParameter(getRequestPolicy, "getRequestPolicy");
        Intrinsics.checkNotNullParameter(gatewayClient, "gatewayClient");
        this.getPrivacyUpdateRequest = getPrivacyUpdateRequest;
        this.getRequestPolicy = getRequestPolicy;
        this.gatewayClient = gatewayClient;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
    
        if (r12 != r0) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(int i, ByteString byteString, Continuation<? super PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse> continuation) {
        SendPrivacyUpdateRequest$invoke$1 sendPrivacyUpdateRequest$invoke$1;
        int i2;
        SendPrivacyUpdateRequest sendPrivacyUpdateRequest;
        if (continuation instanceof SendPrivacyUpdateRequest$invoke$1) {
            sendPrivacyUpdateRequest$invoke$1 = (SendPrivacyUpdateRequest$invoke$1) continuation;
            if ((sendPrivacyUpdateRequest$invoke$1.label & Integer.MIN_VALUE) != 0) {
                sendPrivacyUpdateRequest$invoke$1.label -= Integer.MIN_VALUE;
                SendPrivacyUpdateRequest$invoke$1 sendPrivacyUpdateRequest$invoke$12 = sendPrivacyUpdateRequest$invoke$1;
                Object obj = sendPrivacyUpdateRequest$invoke$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = sendPrivacyUpdateRequest$invoke$12.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    GetPrivacyUpdateRequest getPrivacyUpdateRequest = this.getPrivacyUpdateRequest;
                    sendPrivacyUpdateRequest$invoke$12.L$0 = this;
                    sendPrivacyUpdateRequest$invoke$12.label = 1;
                    obj = getPrivacyUpdateRequest.invoke(i, byteString, sendPrivacyUpdateRequest$invoke$12);
                    if (obj != coroutine_suspended) {
                        sendPrivacyUpdateRequest = this;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse privacyUpdateResponse = ((UniversalResponseOuterClass.UniversalResponse) obj).getPayload().getPrivacyUpdateResponse();
                    Intrinsics.checkNotNullExpressionValue(privacyUpdateResponse, "response.payload.privacyUpdateResponse");
                    return privacyUpdateResponse;
                }
                sendPrivacyUpdateRequest = (SendPrivacyUpdateRequest) sendPrivacyUpdateRequest$invoke$12.L$0;
                ResultKt.throwOnFailure(obj);
                RequestPolicy invoke = sendPrivacyUpdateRequest.getRequestPolicy.invoke();
                GatewayClient gatewayClient = sendPrivacyUpdateRequest.gatewayClient;
                OperationType operationType = OperationType.PRIVACY_UPDATE;
                sendPrivacyUpdateRequest$invoke$12.L$0 = null;
                sendPrivacyUpdateRequest$invoke$12.label = 2;
                obj = GatewayClient.DefaultImpls.request$default(gatewayClient, null, (UniversalRequestOuterClass.UniversalRequest) obj, invoke, operationType, sendPrivacyUpdateRequest$invoke$12, 1, null);
            }
        }
        sendPrivacyUpdateRequest$invoke$1 = new SendPrivacyUpdateRequest$invoke$1(this, continuation);
        SendPrivacyUpdateRequest$invoke$1 sendPrivacyUpdateRequest$invoke$122 = sendPrivacyUpdateRequest$invoke$1;
        Object obj2 = sendPrivacyUpdateRequest$invoke$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = sendPrivacyUpdateRequest$invoke$122.label;
        if (i2 != 0) {
        }
        RequestPolicy invoke2 = sendPrivacyUpdateRequest.getRequestPolicy.invoke();
        GatewayClient gatewayClient2 = sendPrivacyUpdateRequest.gatewayClient;
        OperationType operationType2 = OperationType.PRIVACY_UPDATE;
        sendPrivacyUpdateRequest$invoke$122.L$0 = null;
        sendPrivacyUpdateRequest$invoke$122.label = 2;
        obj2 = GatewayClient.DefaultImpls.request$default(gatewayClient2, null, (UniversalRequestOuterClass.UniversalRequest) obj2, invoke2, operationType2, sendPrivacyUpdateRequest$invoke$122, 1, null);
    }
}
