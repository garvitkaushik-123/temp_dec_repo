package com.unity3d.ads.gatewayclient;

import com.vungle.ads.internal.ui.AdActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CommonGatewayClient.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.gatewayclient.CommonGatewayClient", f = "CommonGatewayClient.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2}, l = {75, 81, 105}, m = "executeWithRetry", n = {"this", AdActivity.REQUEST_KEY_EXTRA, "requestPolicy", "operationType", "gatewayUrl", "retryCount", "timer", "delayTime", "this", AdActivity.REQUEST_KEY_EXTRA, "requestPolicy", "operationType", "gatewayUrl", "retryCount", "timer", "delayTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "J$0", "J$1"})
/* loaded from: classes7.dex */
final class CommonGatewayClient$executeWithRetry$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonGatewayClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonGatewayClient$executeWithRetry$1(CommonGatewayClient commonGatewayClient, Continuation<? super CommonGatewayClient$executeWithRetry$1> continuation) {
        super(continuation);
        this.this$0 = commonGatewayClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object executeWithRetry;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        executeWithRetry = this.this$0.executeWithRetry(null, null, null, null, this);
        return executeWithRetry;
    }
}
