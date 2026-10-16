package com.unity3d.ads.core.domain;

import gatewayprotocol.v1.InitializationDataKt;
import gatewayprotocol.v1.InitializationDataOuterClass;
import gatewayprotocol.v1.InitializationRequestOuterClass;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidGetInitializationData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidGetInitializationData;", "Lcom/unity3d/ads/core/domain/GetInitializationData;", "getInitializeRequestPayload", "Lcom/unity3d/ads/core/domain/GetInitializationRequestPayload;", "getUniversalRequestSharedData", "Lcom/unity3d/ads/core/domain/GetUniversalRequestSharedData;", "(Lcom/unity3d/ads/core/domain/GetInitializationRequestPayload;Lcom/unity3d/ads/core/domain/GetUniversalRequestSharedData;)V", "invoke", "Lgatewayprotocol/v1/InitializationDataOuterClass$InitializationData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidGetInitializationData implements GetInitializationData {
    private final GetInitializationRequestPayload getInitializeRequestPayload;
    private final GetUniversalRequestSharedData getUniversalRequestSharedData;

    public AndroidGetInitializationData(GetInitializationRequestPayload getInitializeRequestPayload, GetUniversalRequestSharedData getUniversalRequestSharedData) {
        Intrinsics.checkNotNullParameter(getInitializeRequestPayload, "getInitializeRequestPayload");
        Intrinsics.checkNotNullParameter(getUniversalRequestSharedData, "getUniversalRequestSharedData");
        this.getInitializeRequestPayload = getInitializeRequestPayload;
        this.getUniversalRequestSharedData = getUniversalRequestSharedData;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.unity3d.ads.core.domain.GetInitializationData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(Continuation<? super InitializationDataOuterClass.InitializationData> continuation) {
        AndroidGetInitializationData$invoke$1 androidGetInitializationData$invoke$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        InitializationDataKt.Dsl _create;
        AndroidGetInitializationData androidGetInitializationData;
        InitializationDataKt.Dsl dsl;
        InitializationDataKt.Dsl dsl2;
        InitializationDataKt.Dsl dsl3;
        InitializationDataKt.Dsl dsl4;
        if (continuation instanceof AndroidGetInitializationData$invoke$1) {
            androidGetInitializationData$invoke$1 = (AndroidGetInitializationData$invoke$1) continuation;
            if ((androidGetInitializationData$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidGetInitializationData$invoke$1.label -= Integer.MIN_VALUE;
                obj = androidGetInitializationData$invoke$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidGetInitializationData$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    InitializationDataKt.Dsl.Companion companion = InitializationDataKt.Dsl.INSTANCE;
                    InitializationDataOuterClass.InitializationData.Builder newBuilder = InitializationDataOuterClass.InitializationData.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                    _create = companion._create(newBuilder);
                    GetInitializationRequestPayload getInitializationRequestPayload = this.getInitializeRequestPayload;
                    androidGetInitializationData$invoke$1.L$0 = this;
                    androidGetInitializationData$invoke$1.L$1 = _create;
                    androidGetInitializationData$invoke$1.L$2 = _create;
                    androidGetInitializationData$invoke$1.L$3 = _create;
                    androidGetInitializationData$invoke$1.label = 1;
                    obj = getInitializationRequestPayload.invoke(androidGetInitializationData$invoke$1);
                    if (obj != coroutine_suspended) {
                        androidGetInitializationData = this;
                        dsl = _create;
                        dsl2 = dsl;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    dsl4 = (InitializationDataKt.Dsl) androidGetInitializationData$invoke$1.L$1;
                    dsl3 = (InitializationDataKt.Dsl) androidGetInitializationData$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    dsl4.setSharedData((UniversalRequestOuterClass.UniversalRequest.SharedData) obj);
                    return dsl3._build();
                }
                InitializationDataKt.Dsl dsl5 = (InitializationDataKt.Dsl) androidGetInitializationData$invoke$1.L$3;
                dsl = (InitializationDataKt.Dsl) androidGetInitializationData$invoke$1.L$2;
                InitializationDataKt.Dsl dsl6 = (InitializationDataKt.Dsl) androidGetInitializationData$invoke$1.L$1;
                androidGetInitializationData = (AndroidGetInitializationData) androidGetInitializationData$invoke$1.L$0;
                ResultKt.throwOnFailure(obj);
                dsl2 = dsl5;
                _create = dsl6;
                dsl2.setInitializationRequest((InitializationRequestOuterClass.InitializationRequest) obj);
                GetUniversalRequestSharedData getUniversalRequestSharedData = androidGetInitializationData.getUniversalRequestSharedData;
                androidGetInitializationData$invoke$1.L$0 = _create;
                androidGetInitializationData$invoke$1.L$1 = dsl;
                androidGetInitializationData$invoke$1.L$2 = null;
                androidGetInitializationData$invoke$1.L$3 = null;
                androidGetInitializationData$invoke$1.label = 2;
                obj = getUniversalRequestSharedData.invoke(androidGetInitializationData$invoke$1);
                if (obj != coroutine_suspended) {
                    dsl3 = _create;
                    dsl4 = dsl;
                    dsl4.setSharedData((UniversalRequestOuterClass.UniversalRequest.SharedData) obj);
                    return dsl3._build();
                }
                return coroutine_suspended;
            }
        }
        androidGetInitializationData$invoke$1 = new AndroidGetInitializationData$invoke$1(this, continuation);
        obj = androidGetInitializationData$invoke$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidGetInitializationData$invoke$1.label;
        if (i != 0) {
        }
        dsl2.setInitializationRequest((InitializationRequestOuterClass.InitializationRequest) obj);
        GetUniversalRequestSharedData getUniversalRequestSharedData2 = androidGetInitializationData.getUniversalRequestSharedData;
        androidGetInitializationData$invoke$1.L$0 = _create;
        androidGetInitializationData$invoke$1.L$1 = dsl;
        androidGetInitializationData$invoke$1.L$2 = null;
        androidGetInitializationData$invoke$1.L$3 = null;
        androidGetInitializationData$invoke$1.label = 2;
        obj = getUniversalRequestSharedData2.invoke(androidGetInitializationData$invoke$1);
        if (obj != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
