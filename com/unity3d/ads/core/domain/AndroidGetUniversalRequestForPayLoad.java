package com.unity3d.ads.core.domain;

import gatewayprotocol.v1.UniversalRequestKt;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidGetUniversalRequestForPayLoad.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidGetUniversalRequestForPayLoad;", "Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;", "getUniversalRequestSharedData", "Lcom/unity3d/ads/core/domain/GetUniversalRequestSharedData;", "(Lcom/unity3d/ads/core/domain/GetUniversalRequestSharedData;)V", "invoke", "Lgatewayprotocol/v1/UniversalRequestOuterClass$UniversalRequest;", "payload", "Lgatewayprotocol/v1/UniversalRequestOuterClass$UniversalRequest$Payload;", "(Lgatewayprotocol/v1/UniversalRequestOuterClass$UniversalRequest$Payload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidGetUniversalRequestForPayLoad implements GetUniversalRequestForPayLoad {
    private final GetUniversalRequestSharedData getUniversalRequestSharedData;

    public AndroidGetUniversalRequestForPayLoad(GetUniversalRequestSharedData getUniversalRequestSharedData) {
        Intrinsics.checkNotNullParameter(getUniversalRequestSharedData, "getUniversalRequestSharedData");
        this.getUniversalRequestSharedData = getUniversalRequestSharedData;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(UniversalRequestOuterClass.UniversalRequest.Payload payload, Continuation<? super UniversalRequestOuterClass.UniversalRequest> continuation) {
        AndroidGetUniversalRequestForPayLoad$invoke$1 androidGetUniversalRequestForPayLoad$invoke$1;
        int i;
        UniversalRequestKt.Dsl dsl;
        UniversalRequestKt.Dsl dsl2;
        UniversalRequestOuterClass.UniversalRequest.Payload payload2;
        UniversalRequestKt.Dsl dsl3;
        if (continuation instanceof AndroidGetUniversalRequestForPayLoad$invoke$1) {
            androidGetUniversalRequestForPayLoad$invoke$1 = (AndroidGetUniversalRequestForPayLoad$invoke$1) continuation;
            if ((androidGetUniversalRequestForPayLoad$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidGetUniversalRequestForPayLoad$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = androidGetUniversalRequestForPayLoad$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidGetUniversalRequestForPayLoad$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    UniversalRequestKt.Dsl.Companion companion = UniversalRequestKt.Dsl.INSTANCE;
                    UniversalRequestOuterClass.UniversalRequest.Builder newBuilder = UniversalRequestOuterClass.UniversalRequest.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                    UniversalRequestKt.Dsl _create = companion._create(newBuilder);
                    GetUniversalRequestSharedData getUniversalRequestSharedData = this.getUniversalRequestSharedData;
                    androidGetUniversalRequestForPayLoad$invoke$1.L$0 = payload;
                    androidGetUniversalRequestForPayLoad$invoke$1.L$1 = _create;
                    androidGetUniversalRequestForPayLoad$invoke$1.L$2 = _create;
                    androidGetUniversalRequestForPayLoad$invoke$1.L$3 = _create;
                    androidGetUniversalRequestForPayLoad$invoke$1.label = 1;
                    Object invoke = getUniversalRequestSharedData.invoke(androidGetUniversalRequestForPayLoad$invoke$1);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    dsl = _create;
                    dsl2 = dsl;
                    obj = invoke;
                    payload2 = payload;
                    dsl3 = dsl2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    dsl3 = (UniversalRequestKt.Dsl) androidGetUniversalRequestForPayLoad$invoke$1.L$3;
                    dsl = (UniversalRequestKt.Dsl) androidGetUniversalRequestForPayLoad$invoke$1.L$2;
                    dsl2 = (UniversalRequestKt.Dsl) androidGetUniversalRequestForPayLoad$invoke$1.L$1;
                    payload2 = (UniversalRequestOuterClass.UniversalRequest.Payload) androidGetUniversalRequestForPayLoad$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                dsl3.setSharedData((UniversalRequestOuterClass.UniversalRequest.SharedData) obj);
                dsl.setPayload(payload2);
                return dsl2._build();
            }
        }
        androidGetUniversalRequestForPayLoad$invoke$1 = new AndroidGetUniversalRequestForPayLoad$invoke$1(this, continuation);
        Object obj2 = androidGetUniversalRequestForPayLoad$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidGetUniversalRequestForPayLoad$invoke$1.label;
        if (i != 0) {
        }
        dsl3.setSharedData((UniversalRequestOuterClass.UniversalRequest.SharedData) obj2);
        dsl.setPayload(payload2);
        return dsl2._build();
    }
}
