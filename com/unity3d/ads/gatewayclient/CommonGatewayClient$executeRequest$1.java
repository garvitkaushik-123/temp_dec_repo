package com.unity3d.ads.gatewayclient;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CommonGatewayClient.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.gatewayclient.CommonGatewayClient", f = "CommonGatewayClient.kt", i = {0, 0, 0, 0}, l = {Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE}, m = "executeRequest", n = {"this", "operationType", "retryCount", "startTime"}, s = {"L$0", "L$1", "I$0", "J$0"})
/* loaded from: classes7.dex */
final class CommonGatewayClient$executeRequest$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonGatewayClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonGatewayClient$executeRequest$1(CommonGatewayClient commonGatewayClient, Continuation<? super CommonGatewayClient$executeRequest$1> continuation) {
        super(continuation);
        this.this$0 = commonGatewayClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object executeRequest;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        executeRequest = this.this$0.executeRequest(null, 0, null, this);
        return executeRequest;
    }
}
