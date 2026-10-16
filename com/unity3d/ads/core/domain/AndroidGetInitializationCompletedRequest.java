package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import gatewayprotocol.v1.InitializationCompletedEventRequestKt;
import gatewayprotocol.v1.InitializationCompletedEventRequestOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import gatewayprotocol.v1.UniversalRequestKt;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidGetInitializationCompletedRequest.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidGetInitializationCompletedRequest;", "Lcom/unity3d/ads/core/domain/GetInitializationCompletedRequest;", "getUniversalRequestForPayLoad", "Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "(Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;)V", "invoke", "Lgatewayprotocol/v1/UniversalRequestOuterClass$UniversalRequest;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidGetInitializationCompletedRequest implements GetInitializationCompletedRequest {
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    public AndroidGetInitializationCompletedRequest(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, DeviceInfoRepository deviceInfoRepository) {
        Intrinsics.checkNotNullParameter(getUniversalRequestForPayLoad, "getUniversalRequestForPayLoad");
        Intrinsics.checkNotNullParameter(deviceInfoRepository, "deviceInfoRepository");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad;
        this.deviceInfoRepository = deviceInfoRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ad A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // com.unity3d.ads.core.domain.GetInitializationCompletedRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(Continuation<? super UniversalRequestOuterClass.UniversalRequest> continuation) {
        AndroidGetInitializationCompletedRequest$invoke$1 androidGetInitializationCompletedRequest$invoke$1;
        int i;
        InitializationCompletedEventRequestKt.Dsl _create;
        AndroidGetInitializationCompletedRequest androidGetInitializationCompletedRequest;
        InitializationCompletedEventRequestKt.Dsl dsl;
        InitializationCompletedEventRequestKt.Dsl dsl2;
        if (continuation instanceof AndroidGetInitializationCompletedRequest$invoke$1) {
            androidGetInitializationCompletedRequest$invoke$1 = (AndroidGetInitializationCompletedRequest$invoke$1) continuation;
            if ((androidGetInitializationCompletedRequest$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidGetInitializationCompletedRequest$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = androidGetInitializationCompletedRequest$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidGetInitializationCompletedRequest$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    InitializationCompletedEventRequestKt.Dsl.Companion companion = InitializationCompletedEventRequestKt.Dsl.INSTANCE;
                    InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.Builder newBuilder = InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                    _create = companion._create(newBuilder);
                    DeviceInfoRepository deviceInfoRepository = this.deviceInfoRepository;
                    androidGetInitializationCompletedRequest$invoke$1.L$0 = this;
                    androidGetInitializationCompletedRequest$invoke$1.L$1 = _create;
                    androidGetInitializationCompletedRequest$invoke$1.L$2 = _create;
                    androidGetInitializationCompletedRequest$invoke$1.L$3 = _create;
                    androidGetInitializationCompletedRequest$invoke$1.label = 1;
                    obj = deviceInfoRepository.staticDeviceInfo(androidGetInitializationCompletedRequest$invoke$1);
                    if (obj != coroutine_suspended) {
                        androidGetInitializationCompletedRequest = this;
                        dsl = _create;
                        dsl2 = dsl;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _create = (InitializationCompletedEventRequestKt.Dsl) androidGetInitializationCompletedRequest$invoke$1.L$3;
                dsl = (InitializationCompletedEventRequestKt.Dsl) androidGetInitializationCompletedRequest$invoke$1.L$2;
                dsl2 = (InitializationCompletedEventRequestKt.Dsl) androidGetInitializationCompletedRequest$invoke$1.L$1;
                androidGetInitializationCompletedRequest = (AndroidGetInitializationCompletedRequest) androidGetInitializationCompletedRequest$invoke$1.L$0;
                ResultKt.throwOnFailure(obj);
                _create.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj);
                dsl.setDynamicDeviceInfo(androidGetInitializationCompletedRequest.deviceInfoRepository.getDynamicDeviceInfo());
                InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest _build = dsl2._build();
                UniversalRequestKt universalRequestKt = UniversalRequestKt.INSTANCE;
                UniversalRequestKt.PayloadKt.Dsl.Companion companion2 = UniversalRequestKt.PayloadKt.Dsl.INSTANCE;
                UniversalRequestOuterClass.UniversalRequest.Payload.Builder newBuilder2 = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
                Intrinsics.checkNotNullExpressionValue(newBuilder2, "newBuilder()");
                UniversalRequestKt.PayloadKt.Dsl _create2 = companion2._create(newBuilder2);
                _create2.setInitializationCompletedEventRequest(_build);
                UniversalRequestOuterClass.UniversalRequest.Payload _build2 = _create2._build();
                GetUniversalRequestForPayLoad getUniversalRequestForPayLoad = androidGetInitializationCompletedRequest.getUniversalRequestForPayLoad;
                androidGetInitializationCompletedRequest$invoke$1.L$0 = null;
                androidGetInitializationCompletedRequest$invoke$1.L$1 = null;
                androidGetInitializationCompletedRequest$invoke$1.L$2 = null;
                androidGetInitializationCompletedRequest$invoke$1.L$3 = null;
                androidGetInitializationCompletedRequest$invoke$1.label = 2;
                Object invoke = getUniversalRequestForPayLoad.invoke(_build2, androidGetInitializationCompletedRequest$invoke$1);
                return invoke != coroutine_suspended ? coroutine_suspended : invoke;
            }
        }
        androidGetInitializationCompletedRequest$invoke$1 = new AndroidGetInitializationCompletedRequest$invoke$1(this, continuation);
        Object obj2 = androidGetInitializationCompletedRequest$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidGetInitializationCompletedRequest$invoke$1.label;
        if (i != 0) {
        }
        _create.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj2);
        dsl.setDynamicDeviceInfo(androidGetInitializationCompletedRequest.deviceInfoRepository.getDynamicDeviceInfo());
        InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest _build3 = dsl2._build();
        UniversalRequestKt universalRequestKt2 = UniversalRequestKt.INSTANCE;
        UniversalRequestKt.PayloadKt.Dsl.Companion companion22 = UniversalRequestKt.PayloadKt.Dsl.INSTANCE;
        UniversalRequestOuterClass.UniversalRequest.Payload.Builder newBuilder22 = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder22, "newBuilder()");
        UniversalRequestKt.PayloadKt.Dsl _create22 = companion22._create(newBuilder22);
        _create22.setInitializationCompletedEventRequest(_build3);
        UniversalRequestOuterClass.UniversalRequest.Payload _build22 = _create22._build();
        GetUniversalRequestForPayLoad getUniversalRequestForPayLoad2 = androidGetInitializationCompletedRequest.getUniversalRequestForPayLoad;
        androidGetInitializationCompletedRequest$invoke$1.L$0 = null;
        androidGetInitializationCompletedRequest$invoke$1.L$1 = null;
        androidGetInitializationCompletedRequest$invoke$1.L$2 = null;
        androidGetInitializationCompletedRequest$invoke$1.L$3 = null;
        androidGetInitializationCompletedRequest$invoke$1.label = 2;
        Object invoke2 = getUniversalRequestForPayLoad2.invoke(_build22, androidGetInitializationCompletedRequest$invoke$1);
        if (invoke2 != coroutine_suspended2) {
        }
    }
}
