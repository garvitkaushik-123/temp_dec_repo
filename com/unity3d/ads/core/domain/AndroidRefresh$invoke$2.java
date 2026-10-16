package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.ads.gatewayclient.RequestPolicy;
import gatewayprotocol.v1.AdDataRefreshResponseOuterClass;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidRefresh.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lgatewayprotocol/v1/AdDataRefreshResponseOuterClass$AdDataRefreshResponse;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidRefresh$invoke$2", f = "AndroidRefresh.kt", i = {}, l = {26, 28}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidRefresh$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AdDataRefreshResponseOuterClass.AdDataRefreshResponse>, Object> {
    final /* synthetic */ ByteString $adDataRefreshToken;
    final /* synthetic */ ByteString $opportunityId;
    int label;
    final /* synthetic */ AndroidRefresh this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidRefresh$invoke$2(AndroidRefresh androidRefresh, ByteString byteString, ByteString byteString2, Continuation<? super AndroidRefresh$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = androidRefresh;
        this.$adDataRefreshToken = byteString;
        this.$opportunityId = byteString2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidRefresh$invoke$2(this.this$0, this.$adDataRefreshToken, this.$opportunityId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AdDataRefreshResponseOuterClass.AdDataRefreshResponse> continuation) {
        return ((AndroidRefresh$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
    
        if (r12 == r0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        if (r12 == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        GetAdDataRefreshRequest getAdDataRefreshRequest;
        GetRequestPolicy getRequestPolicy;
        GatewayClient gatewayClient;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            getAdDataRefreshRequest = this.this$0.getAdDataRefreshRequest;
            this.label = 1;
            obj = getAdDataRefreshRequest.invoke(this.$adDataRefreshToken, this.$opportunityId, this);
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return ((UniversalResponseOuterClass.UniversalResponse) obj).getPayload().getAdDataRefreshResponse();
            }
            ResultKt.throwOnFailure(obj);
        }
        UniversalRequestOuterClass.UniversalRequest universalRequest = (UniversalRequestOuterClass.UniversalRequest) obj;
        getRequestPolicy = this.this$0.getRequestPolicy;
        RequestPolicy invoke = getRequestPolicy.invoke();
        gatewayClient = this.this$0.gatewayClient;
        this.label = 2;
        obj = GatewayClient.DefaultImpls.request$default(gatewayClient, null, universalRequest, invoke, OperationType.REFRESH, this, 1, null);
    }
}
