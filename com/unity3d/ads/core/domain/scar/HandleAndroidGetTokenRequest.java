package com.unity3d.ads.core.domain.scar;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.domain.GetRequestPolicy;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.ads.gatewayclient.RequestPolicy;
import com.unity3d.services.ads.gmascar.models.BiddingSignals;
import gatewayprotocol.v1.GetTokenEventRequestOuterClass;
import gatewayprotocol.v1.UniversalRequestKt;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HandleAndroidGetTokenRequest.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/unity3d/ads/core/domain/scar/HandleAndroidGetTokenRequest;", "Lcom/unity3d/ads/core/domain/scar/HandleGetTokenRequest;", "getUniversalRequestForPayLoad", "Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;", "getHbTokenEventRequest", "Lcom/unity3d/ads/core/domain/scar/GetHbTokenEventRequest;", "getRequestPolicy", "Lcom/unity3d/ads/core/domain/GetRequestPolicy;", "gatewayClient", "Lcom/unity3d/ads/gatewayclient/GatewayClient;", "(Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;Lcom/unity3d/ads/core/domain/scar/GetHbTokenEventRequest;Lcom/unity3d/ads/core/domain/GetRequestPolicy;Lcom/unity3d/ads/gatewayclient/GatewayClient;)V", "invoke", "Lgatewayprotocol/v1/UniversalResponseOuterClass$UniversalResponse;", "tokenId", "Lcom/google/protobuf/ByteString;", "biddingSignals", "Lcom/unity3d/services/ads/gmascar/models/BiddingSignals;", "(Lcom/google/protobuf/ByteString;Lcom/unity3d/services/ads/gmascar/models/BiddingSignals;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class HandleAndroidGetTokenRequest implements HandleGetTokenRequest {
    private final GatewayClient gatewayClient;
    private final GetHbTokenEventRequest getHbTokenEventRequest;
    private final GetRequestPolicy getRequestPolicy;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    public HandleAndroidGetTokenRequest(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, GetHbTokenEventRequest getHbTokenEventRequest, GetRequestPolicy getRequestPolicy, GatewayClient gatewayClient) {
        Intrinsics.checkNotNullParameter(getUniversalRequestForPayLoad, "getUniversalRequestForPayLoad");
        Intrinsics.checkNotNullParameter(getHbTokenEventRequest, "getHbTokenEventRequest");
        Intrinsics.checkNotNullParameter(getRequestPolicy, "getRequestPolicy");
        Intrinsics.checkNotNullParameter(gatewayClient, "gatewayClient");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad;
        this.getHbTokenEventRequest = getHbTokenEventRequest;
        this.getRequestPolicy = getRequestPolicy;
        this.gatewayClient = gatewayClient;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
    
        if (r12 != r0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // com.unity3d.ads.core.domain.scar.HandleGetTokenRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(ByteString byteString, BiddingSignals biddingSignals, Continuation<? super UniversalResponseOuterClass.UniversalResponse> continuation) {
        HandleAndroidGetTokenRequest$invoke$1 handleAndroidGetTokenRequest$invoke$1;
        int i;
        HandleAndroidGetTokenRequest handleAndroidGetTokenRequest;
        if (continuation instanceof HandleAndroidGetTokenRequest$invoke$1) {
            handleAndroidGetTokenRequest$invoke$1 = (HandleAndroidGetTokenRequest$invoke$1) continuation;
            if ((handleAndroidGetTokenRequest$invoke$1.label & Integer.MIN_VALUE) != 0) {
                handleAndroidGetTokenRequest$invoke$1.label -= Integer.MIN_VALUE;
                HandleAndroidGetTokenRequest$invoke$1 handleAndroidGetTokenRequest$invoke$12 = handleAndroidGetTokenRequest$invoke$1;
                Object obj = handleAndroidGetTokenRequest$invoke$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = handleAndroidGetTokenRequest$invoke$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    GetHbTokenEventRequest getHbTokenEventRequest = this.getHbTokenEventRequest;
                    handleAndroidGetTokenRequest$invoke$12.L$0 = this;
                    handleAndroidGetTokenRequest$invoke$12.label = 1;
                    obj = getHbTokenEventRequest.invoke(byteString, biddingSignals, handleAndroidGetTokenRequest$invoke$12);
                    if (obj != coroutine_suspended) {
                        handleAndroidGetTokenRequest = this;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    handleAndroidGetTokenRequest = (HandleAndroidGetTokenRequest) handleAndroidGetTokenRequest$invoke$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    RequestPolicy invoke = handleAndroidGetTokenRequest.getRequestPolicy.invoke();
                    GatewayClient gatewayClient = handleAndroidGetTokenRequest.gatewayClient;
                    OperationType operationType = OperationType.GET_TOKEN;
                    handleAndroidGetTokenRequest$invoke$12.L$0 = null;
                    handleAndroidGetTokenRequest$invoke$12.label = 3;
                    Object request$default = GatewayClient.DefaultImpls.request$default(gatewayClient, null, (UniversalRequestOuterClass.UniversalRequest) obj, invoke, operationType, handleAndroidGetTokenRequest$invoke$12, 1, null);
                    return request$default == coroutine_suspended ? coroutine_suspended : request$default;
                }
                handleAndroidGetTokenRequest = (HandleAndroidGetTokenRequest) handleAndroidGetTokenRequest$invoke$12.L$0;
                ResultKt.throwOnFailure(obj);
                UniversalRequestKt universalRequestKt = UniversalRequestKt.INSTANCE;
                UniversalRequestKt.PayloadKt.Dsl.Companion companion = UniversalRequestKt.PayloadKt.Dsl.INSTANCE;
                UniversalRequestOuterClass.UniversalRequest.Payload.Builder newBuilder = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
                Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                UniversalRequestKt.PayloadKt.Dsl _create = companion._create(newBuilder);
                _create.setGetTokenEventRequest((GetTokenEventRequestOuterClass.GetTokenEventRequest) obj);
                UniversalRequestOuterClass.UniversalRequest.Payload _build = _create._build();
                GetUniversalRequestForPayLoad getUniversalRequestForPayLoad = handleAndroidGetTokenRequest.getUniversalRequestForPayLoad;
                handleAndroidGetTokenRequest$invoke$12.L$0 = handleAndroidGetTokenRequest;
                handleAndroidGetTokenRequest$invoke$12.label = 2;
                obj = getUniversalRequestForPayLoad.invoke(_build, handleAndroidGetTokenRequest$invoke$12);
            }
        }
        handleAndroidGetTokenRequest$invoke$1 = new HandleAndroidGetTokenRequest$invoke$1(this, continuation);
        HandleAndroidGetTokenRequest$invoke$1 handleAndroidGetTokenRequest$invoke$122 = handleAndroidGetTokenRequest$invoke$1;
        Object obj2 = handleAndroidGetTokenRequest$invoke$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = handleAndroidGetTokenRequest$invoke$122.label;
        if (i != 0) {
        }
        UniversalRequestKt universalRequestKt2 = UniversalRequestKt.INSTANCE;
        UniversalRequestKt.PayloadKt.Dsl.Companion companion2 = UniversalRequestKt.PayloadKt.Dsl.INSTANCE;
        UniversalRequestOuterClass.UniversalRequest.Payload.Builder newBuilder2 = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder2, "newBuilder()");
        UniversalRequestKt.PayloadKt.Dsl _create2 = companion2._create(newBuilder2);
        _create2.setGetTokenEventRequest((GetTokenEventRequestOuterClass.GetTokenEventRequest) obj2);
        UniversalRequestOuterClass.UniversalRequest.Payload _build2 = _create2._build();
        GetUniversalRequestForPayLoad getUniversalRequestForPayLoad2 = handleAndroidGetTokenRequest.getUniversalRequestForPayLoad;
        handleAndroidGetTokenRequest$invoke$122.L$0 = handleAndroidGetTokenRequest;
        handleAndroidGetTokenRequest$invoke$122.label = 2;
        obj2 = getUniversalRequestForPayLoad2.invoke(_build2, handleAndroidGetTokenRequest$invoke$122);
    }
}
