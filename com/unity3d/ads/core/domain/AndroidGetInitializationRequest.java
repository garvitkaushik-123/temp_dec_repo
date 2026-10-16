package com.unity3d.ads.core.domain;

import gatewayprotocol.v1.InitializationRequestOuterClass;
import gatewayprotocol.v1.UniversalRequestKt;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidGetInitializationRequest.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidGetInitializationRequest;", "Lcom/unity3d/ads/core/domain/GetInitializationRequest;", "getInitializationRequestPayload", "Lcom/unity3d/ads/core/domain/GetInitializationRequestPayload;", "getUniversalRequestForPayLoad", "Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;", "(Lcom/unity3d/ads/core/domain/GetInitializationRequestPayload;Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;)V", "invoke", "Lgatewayprotocol/v1/UniversalRequestOuterClass$UniversalRequest;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidGetInitializationRequest implements GetInitializationRequest {
    private final GetInitializationRequestPayload getInitializationRequestPayload;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    public AndroidGetInitializationRequest(GetInitializationRequestPayload getInitializationRequestPayload, GetUniversalRequestForPayLoad getUniversalRequestForPayLoad) {
        Intrinsics.checkNotNullParameter(getInitializationRequestPayload, "getInitializationRequestPayload");
        Intrinsics.checkNotNullParameter(getUniversalRequestForPayLoad, "getUniversalRequestForPayLoad");
        this.getInitializationRequestPayload = getInitializationRequestPayload;
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.unity3d.ads.core.domain.GetInitializationRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(Continuation<? super UniversalRequestOuterClass.UniversalRequest> continuation) {
        AndroidGetInitializationRequest$invoke$1 androidGetInitializationRequest$invoke$1;
        int i;
        AndroidGetInitializationRequest androidGetInitializationRequest;
        if (continuation instanceof AndroidGetInitializationRequest$invoke$1) {
            androidGetInitializationRequest$invoke$1 = (AndroidGetInitializationRequest$invoke$1) continuation;
            if ((androidGetInitializationRequest$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidGetInitializationRequest$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = androidGetInitializationRequest$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidGetInitializationRequest$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    GetInitializationRequestPayload getInitializationRequestPayload = this.getInitializationRequestPayload;
                    androidGetInitializationRequest$invoke$1.L$0 = this;
                    androidGetInitializationRequest$invoke$1.label = 1;
                    obj = getInitializationRequestPayload.invoke(androidGetInitializationRequest$invoke$1);
                    if (obj != coroutine_suspended) {
                        androidGetInitializationRequest = this;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                androidGetInitializationRequest = (AndroidGetInitializationRequest) androidGetInitializationRequest$invoke$1.L$0;
                ResultKt.throwOnFailure(obj);
                UniversalRequestKt universalRequestKt = UniversalRequestKt.INSTANCE;
                UniversalRequestKt.PayloadKt.Dsl.Companion companion = UniversalRequestKt.PayloadKt.Dsl.INSTANCE;
                UniversalRequestOuterClass.UniversalRequest.Payload.Builder newBuilder = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
                Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                UniversalRequestKt.PayloadKt.Dsl _create = companion._create(newBuilder);
                _create.setInitializationRequest((InitializationRequestOuterClass.InitializationRequest) obj);
                UniversalRequestOuterClass.UniversalRequest.Payload _build = _create._build();
                GetUniversalRequestForPayLoad getUniversalRequestForPayLoad = androidGetInitializationRequest.getUniversalRequestForPayLoad;
                androidGetInitializationRequest$invoke$1.L$0 = null;
                androidGetInitializationRequest$invoke$1.label = 2;
                Object invoke = getUniversalRequestForPayLoad.invoke(_build, androidGetInitializationRequest$invoke$1);
                return invoke != coroutine_suspended ? coroutine_suspended : invoke;
            }
        }
        androidGetInitializationRequest$invoke$1 = new AndroidGetInitializationRequest$invoke$1(this, continuation);
        Object obj2 = androidGetInitializationRequest$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidGetInitializationRequest$invoke$1.label;
        if (i != 0) {
        }
        UniversalRequestKt universalRequestKt2 = UniversalRequestKt.INSTANCE;
        UniversalRequestKt.PayloadKt.Dsl.Companion companion2 = UniversalRequestKt.PayloadKt.Dsl.INSTANCE;
        UniversalRequestOuterClass.UniversalRequest.Payload.Builder newBuilder2 = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder2, "newBuilder()");
        UniversalRequestKt.PayloadKt.Dsl _create2 = companion2._create(newBuilder2);
        _create2.setInitializationRequest((InitializationRequestOuterClass.InitializationRequest) obj2);
        UniversalRequestOuterClass.UniversalRequest.Payload _build2 = _create2._build();
        GetUniversalRequestForPayLoad getUniversalRequestForPayLoad2 = androidGetInitializationRequest.getUniversalRequestForPayLoad;
        androidGetInitializationRequest$invoke$1.L$0 = null;
        androidGetInitializationRequest$invoke$1.label = 2;
        Object invoke2 = getUniversalRequestForPayLoad2.invoke(_build2, androidGetInitializationRequest$invoke$1);
        if (invoke2 != coroutine_suspended2) {
        }
    }
}
