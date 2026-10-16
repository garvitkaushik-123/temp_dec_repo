package com.unity3d.ads.core.domain.events;

import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import gatewayprotocol.v1.TransactionEventRequestKt;
import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonGetTransactionRequest.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/unity3d/ads/core/domain/events/CommonGetTransactionRequest;", "Lcom/unity3d/ads/core/domain/events/GetTransactionRequest;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "(Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;)V", "invoke", "Lgatewayprotocol/v1/TransactionEventRequestOuterClass$TransactionEventRequest;", "transactionDataList", "", "Lgatewayprotocol/v1/TransactionEventRequestOuterClass$TransactionData;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CommonGetTransactionRequest implements GetTransactionRequest {
    private final DeviceInfoRepository deviceInfoRepository;

    public CommonGetTransactionRequest(DeviceInfoRepository deviceInfoRepository) {
        Intrinsics.checkNotNullParameter(deviceInfoRepository, "deviceInfoRepository");
        this.deviceInfoRepository = deviceInfoRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.unity3d.ads.core.domain.events.GetTransactionRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(List<TransactionEventRequestOuterClass.TransactionData> list, Continuation<? super TransactionEventRequestOuterClass.TransactionEventRequest> continuation) {
        CommonGetTransactionRequest$invoke$1 commonGetTransactionRequest$invoke$1;
        int i;
        List<TransactionEventRequestOuterClass.TransactionData> list2;
        TransactionEventRequestKt.Dsl dsl;
        TransactionEventRequestKt.Dsl dsl2;
        TransactionEventRequestKt.Dsl dsl3;
        CommonGetTransactionRequest commonGetTransactionRequest;
        if (continuation instanceof CommonGetTransactionRequest$invoke$1) {
            commonGetTransactionRequest$invoke$1 = (CommonGetTransactionRequest$invoke$1) continuation;
            if ((commonGetTransactionRequest$invoke$1.label & Integer.MIN_VALUE) != 0) {
                commonGetTransactionRequest$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = commonGetTransactionRequest$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = commonGetTransactionRequest$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    TransactionEventRequestKt.Dsl.Companion companion = TransactionEventRequestKt.Dsl.INSTANCE;
                    TransactionEventRequestOuterClass.TransactionEventRequest.Builder newBuilder = TransactionEventRequestOuterClass.TransactionEventRequest.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                    TransactionEventRequestKt.Dsl _create = companion._create(newBuilder);
                    DeviceInfoRepository deviceInfoRepository = this.deviceInfoRepository;
                    commonGetTransactionRequest$invoke$1.L$0 = this;
                    commonGetTransactionRequest$invoke$1.L$1 = list;
                    commonGetTransactionRequest$invoke$1.L$2 = _create;
                    commonGetTransactionRequest$invoke$1.L$3 = _create;
                    commonGetTransactionRequest$invoke$1.L$4 = _create;
                    commonGetTransactionRequest$invoke$1.label = 1;
                    Object staticDeviceInfo = deviceInfoRepository.staticDeviceInfo(commonGetTransactionRequest$invoke$1);
                    if (staticDeviceInfo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list2 = list;
                    dsl = _create;
                    dsl2 = dsl;
                    dsl3 = dsl2;
                    obj = staticDeviceInfo;
                    commonGetTransactionRequest = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    dsl = (TransactionEventRequestKt.Dsl) commonGetTransactionRequest$invoke$1.L$4;
                    dsl2 = (TransactionEventRequestKt.Dsl) commonGetTransactionRequest$invoke$1.L$3;
                    dsl3 = (TransactionEventRequestKt.Dsl) commonGetTransactionRequest$invoke$1.L$2;
                    list2 = (List) commonGetTransactionRequest$invoke$1.L$1;
                    commonGetTransactionRequest = (CommonGetTransactionRequest) commonGetTransactionRequest$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                dsl.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj);
                dsl2.setDynamicDeviceInfo(commonGetTransactionRequest.deviceInfoRepository.getDynamicDeviceInfo());
                dsl2.setAppStore(TransactionEventRequestOuterClass.StoreType.STORE_TYPE_GOOGLE_PLAY);
                dsl2.addAllTransactionData(dsl2.getTransactionData(), list2);
                return dsl3._build();
            }
        }
        commonGetTransactionRequest$invoke$1 = new CommonGetTransactionRequest$invoke$1(this, continuation);
        Object obj2 = commonGetTransactionRequest$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = commonGetTransactionRequest$invoke$1.label;
        if (i != 0) {
        }
        dsl.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj2);
        dsl2.setDynamicDeviceInfo(commonGetTransactionRequest.deviceInfoRepository.getDynamicDeviceInfo());
        dsl2.setAppStore(TransactionEventRequestOuterClass.StoreType.STORE_TYPE_GOOGLE_PLAY);
        dsl2.addAllTransactionData(dsl2.getTransactionData(), list2);
        return dsl3._build();
    }
}
