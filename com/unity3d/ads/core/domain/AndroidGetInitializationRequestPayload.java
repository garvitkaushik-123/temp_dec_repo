package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ByteStringsKt;
import com.unity3d.ads.core.configuration.MediationInitBlobMetadataReader;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.LegacyUserConsentRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.services.core.device.Storage;
import com.unity3d.services.core.device.StorageManager;
import gatewayprotocol.v1.ClientInfoOuterClass;
import gatewayprotocol.v1.InitializationDeviceInfoKt;
import gatewayprotocol.v1.InitializationRequestKt;
import gatewayprotocol.v1.InitializationRequestOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidGetInitializationRequestPayload.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidGetInitializationRequestPayload;", "Lcom/unity3d/ads/core/domain/GetInitializationRequestPayload;", "getClientInfo", "Lcom/unity3d/ads/core/domain/GetClientInfo;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "legacyUserConsentRepository", "Lcom/unity3d/ads/core/data/repository/LegacyUserConsentRepository;", "mediationInitBlobMetadataReader", "Lcom/unity3d/ads/core/configuration/MediationInitBlobMetadataReader;", "(Lcom/unity3d/ads/core/domain/GetClientInfo;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/LegacyUserConsentRepository;Lcom/unity3d/ads/core/configuration/MediationInitBlobMetadataReader;)V", "invoke", "Lgatewayprotocol/v1/InitializationRequestOuterClass$InitializationRequest;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidGetInitializationRequestPayload implements GetInitializationRequestPayload {
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetClientInfo getClientInfo;
    private final LegacyUserConsentRepository legacyUserConsentRepository;
    private final MediationInitBlobMetadataReader mediationInitBlobMetadataReader;
    private final SessionRepository sessionRepository;

    public AndroidGetInitializationRequestPayload(GetClientInfo getClientInfo, SessionRepository sessionRepository, DeviceInfoRepository deviceInfoRepository, LegacyUserConsentRepository legacyUserConsentRepository, MediationInitBlobMetadataReader mediationInitBlobMetadataReader) {
        Intrinsics.checkNotNullParameter(getClientInfo, "getClientInfo");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(deviceInfoRepository, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(legacyUserConsentRepository, "legacyUserConsentRepository");
        Intrinsics.checkNotNullParameter(mediationInitBlobMetadataReader, "mediationInitBlobMetadataReader");
        this.getClientInfo = getClientInfo;
        this.sessionRepository = sessionRepository;
        this.deviceInfoRepository = deviceInfoRepository;
        this.legacyUserConsentRepository = legacyUserConsentRepository;
        this.mediationInitBlobMetadataReader = mediationInitBlobMetadataReader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x02c0, code lost:
    
        if (r1 == r3) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x029d, code lost:
    
        if (r1 != r3) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // com.unity3d.ads.core.domain.GetInitializationRequestPayload
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(Continuation<? super InitializationRequestOuterClass.InitializationRequest> continuation) {
        AndroidGetInitializationRequestPayload$invoke$1 androidGetInitializationRequestPayload$invoke$1;
        InitializationRequestKt.Dsl _create;
        AndroidGetInitializationRequestPayload androidGetInitializationRequestPayload;
        InitializationRequestKt.Dsl dsl;
        InitializationRequestKt.Dsl dsl2;
        InitializationRequestKt.Dsl dsl3;
        String analyticsUserId;
        InitializationDeviceInfoKt.Dsl _create2;
        InitializationDeviceInfoKt.Dsl dsl4;
        InitializationRequestKt.Dsl dsl5;
        AndroidGetInitializationRequestPayload androidGetInitializationRequestPayload2;
        InitializationDeviceInfoKt.Dsl dsl6;
        InitializationRequestKt.Dsl dsl7;
        InitializationDeviceInfoKt.Dsl dsl8;
        InitializationRequestKt.Dsl dsl9;
        InitializationRequestKt.Dsl dsl10;
        AndroidGetInitializationRequestPayload androidGetInitializationRequestPayload3;
        ByteString byteString;
        InitializationRequestKt.Dsl dsl11;
        InitializationRequestKt.Dsl dsl12;
        AndroidGetInitializationRequestPayload androidGetInitializationRequestPayload4;
        ByteString byteString2;
        Object obj;
        String str;
        String legacyFlowUserConsent;
        if (continuation instanceof AndroidGetInitializationRequestPayload$invoke$1) {
            androidGetInitializationRequestPayload$invoke$1 = (AndroidGetInitializationRequestPayload$invoke$1) continuation;
            if ((androidGetInitializationRequestPayload$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidGetInitializationRequestPayload$invoke$1.label -= Integer.MIN_VALUE;
                Object obj2 = androidGetInitializationRequestPayload$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                Object obj3 = null;
                switch (androidGetInitializationRequestPayload$invoke$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj2);
                        InitializationRequestKt.Dsl.Companion companion = InitializationRequestKt.Dsl.INSTANCE;
                        InitializationRequestOuterClass.InitializationRequest.Builder newBuilder = InitializationRequestOuterClass.InitializationRequest.newBuilder();
                        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                        _create = companion._create(newBuilder);
                        Storage storage = StorageManager.getStorage(StorageManager.StorageType.PRIVATE);
                        boolean z = false;
                        if (storage.readStorage()) {
                            Object obj4 = storage.get("configuration.hasInitialized");
                            Boolean bool = obj4 instanceof Boolean ? (Boolean) obj4 : null;
                            if (bool != null ? bool.booleanValue() : false) {
                                z = true;
                            }
                        }
                        _create.setIsFirstInit(!z);
                        GetClientInfo getClientInfo = this.getClientInfo;
                        androidGetInitializationRequestPayload$invoke$1.L$0 = this;
                        androidGetInitializationRequestPayload$invoke$1.L$1 = _create;
                        androidGetInitializationRequestPayload$invoke$1.L$2 = _create;
                        androidGetInitializationRequestPayload$invoke$1.L$3 = _create;
                        androidGetInitializationRequestPayload$invoke$1.label = 1;
                        obj2 = getClientInfo.invoke(androidGetInitializationRequestPayload$invoke$1);
                        if (obj2 != coroutine_suspended) {
                            androidGetInitializationRequestPayload = this;
                            dsl = _create;
                            dsl2 = dsl;
                            _create.setClientInfo((ClientInfoOuterClass.ClientInfo) obj2);
                            DeviceInfoRepository deviceInfoRepository = androidGetInitializationRequestPayload.deviceInfoRepository;
                            androidGetInitializationRequestPayload$invoke$1.L$0 = androidGetInitializationRequestPayload;
                            androidGetInitializationRequestPayload$invoke$1.L$1 = dsl2;
                            androidGetInitializationRequestPayload$invoke$1.L$2 = dsl;
                            androidGetInitializationRequestPayload$invoke$1.L$3 = dsl;
                            androidGetInitializationRequestPayload$invoke$1.label = 2;
                            obj2 = deviceInfoRepository.getIdfi(androidGetInitializationRequestPayload$invoke$1);
                            if (obj2 != coroutine_suspended) {
                                dsl3 = dsl;
                                dsl3.setIdfi((String) obj2);
                                analyticsUserId = androidGetInitializationRequestPayload.deviceInfoRepository.getAnalyticsUserId();
                                if (analyticsUserId != null) {
                                    dsl.setAnalyticsUserId(analyticsUserId);
                                }
                                dsl.setSessionId(androidGetInitializationRequestPayload.sessionRepository.getSessionId());
                                InitializationDeviceInfoKt.Dsl.Companion companion2 = InitializationDeviceInfoKt.Dsl.INSTANCE;
                                InitializationRequestOuterClass.InitializationDeviceInfo.Builder newBuilder2 = InitializationRequestOuterClass.InitializationDeviceInfo.newBuilder();
                                Intrinsics.checkNotNullExpressionValue(newBuilder2, "newBuilder()");
                                _create2 = companion2._create(newBuilder2);
                                _create2.setBundleId(androidGetInitializationRequestPayload.deviceInfoRepository.getAppName());
                                _create2.setDeviceModel(androidGetInitializationRequestPayload.deviceInfoRepository.getModel());
                                _create2.setDeviceMake(androidGetInitializationRequestPayload.deviceInfoRepository.getManufacturer());
                                _create2.setOsVersion(androidGetInitializationRequestPayload.deviceInfoRepository.getOsVersion());
                                DeviceInfoRepository deviceInfoRepository2 = androidGetInitializationRequestPayload.deviceInfoRepository;
                                androidGetInitializationRequestPayload$invoke$1.L$0 = androidGetInitializationRequestPayload;
                                androidGetInitializationRequestPayload$invoke$1.L$1 = dsl2;
                                androidGetInitializationRequestPayload$invoke$1.L$2 = dsl;
                                androidGetInitializationRequestPayload$invoke$1.L$3 = _create2;
                                androidGetInitializationRequestPayload$invoke$1.L$4 = dsl;
                                androidGetInitializationRequestPayload$invoke$1.L$5 = _create2;
                                androidGetInitializationRequestPayload$invoke$1.L$6 = _create2;
                                androidGetInitializationRequestPayload$invoke$1.label = 3;
                                obj2 = deviceInfoRepository2.staticDeviceInfo(androidGetInitializationRequestPayload$invoke$1);
                                if (obj2 != coroutine_suspended) {
                                    dsl4 = _create2;
                                    dsl5 = dsl2;
                                    androidGetInitializationRequestPayload2 = androidGetInitializationRequestPayload;
                                    dsl6 = dsl4;
                                    dsl7 = dsl;
                                    _create2.setTotalDiskSpace(((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj2).getTotalDiskSpace());
                                    DeviceInfoRepository deviceInfoRepository3 = androidGetInitializationRequestPayload2.deviceInfoRepository;
                                    androidGetInitializationRequestPayload$invoke$1.L$0 = androidGetInitializationRequestPayload2;
                                    androidGetInitializationRequestPayload$invoke$1.L$1 = dsl5;
                                    androidGetInitializationRequestPayload$invoke$1.L$2 = dsl7;
                                    androidGetInitializationRequestPayload$invoke$1.L$3 = dsl6;
                                    androidGetInitializationRequestPayload$invoke$1.L$4 = dsl;
                                    androidGetInitializationRequestPayload$invoke$1.L$5 = dsl4;
                                    androidGetInitializationRequestPayload$invoke$1.L$6 = dsl4;
                                    androidGetInitializationRequestPayload$invoke$1.label = 4;
                                    obj2 = deviceInfoRepository3.staticDeviceInfo(androidGetInitializationRequestPayload$invoke$1);
                                    if (obj2 != coroutine_suspended) {
                                        dsl8 = dsl4;
                                        dsl8.setTotalRamMemory(((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj2).getTotalRamMemory());
                                        dsl4.setCurrentUiTheme(androidGetInitializationRequestPayload2.deviceInfoRepository.getCurrentUiTheme());
                                        String networkOperator = androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getNetworkOperator();
                                        Intrinsics.checkNotNullExpressionValue(networkOperator, "deviceInfoRepository.dyn…eviceInfo.networkOperator");
                                        dsl4.setNetworkOperator(networkOperator);
                                        dsl4.setBatteryLevel(androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getBatteryLevel());
                                        dsl4.setBatteryStatus(androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getBatteryStatus());
                                        dsl4.setSystemBootTime(androidGetInitializationRequestPayload2.deviceInfoRepository.getSystemBootTime());
                                        String language = androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getLanguage();
                                        Intrinsics.checkNotNullExpressionValue(language, "deviceInfoRepository.dynamicDeviceInfo.language");
                                        dsl4.setLanguage(language);
                                        dsl4.setLocalList(CollectionsKt.joinToString$default(androidGetInitializationRequestPayload2.deviceInfoRepository.getLocaleList(), ",", null, null, 0, null, null, 62, null));
                                        dsl4.setConnectionType(androidGetInitializationRequestPayload2.deviceInfoRepository.getConnectionTypeStr());
                                        dsl.setDeviceInfo(dsl6._build());
                                        DeviceInfoRepository deviceInfoRepository4 = androidGetInitializationRequestPayload2.deviceInfoRepository;
                                        androidGetInitializationRequestPayload$invoke$1.L$0 = androidGetInitializationRequestPayload2;
                                        androidGetInitializationRequestPayload$invoke$1.L$1 = dsl5;
                                        androidGetInitializationRequestPayload$invoke$1.L$2 = dsl7;
                                        androidGetInitializationRequestPayload$invoke$1.L$3 = null;
                                        androidGetInitializationRequestPayload$invoke$1.L$4 = null;
                                        androidGetInitializationRequestPayload$invoke$1.L$5 = null;
                                        androidGetInitializationRequestPayload$invoke$1.L$6 = null;
                                        androidGetInitializationRequestPayload$invoke$1.label = 5;
                                        obj2 = deviceInfoRepository4.getAuidByteString(androidGetInitializationRequestPayload$invoke$1);
                                        if (obj2 != coroutine_suspended) {
                                            dsl9 = dsl7;
                                            dsl10 = dsl5;
                                            androidGetInitializationRequestPayload3 = androidGetInitializationRequestPayload2;
                                            byteString = (ByteString) obj2;
                                            if (byteString != null) {
                                                dsl9.setAuid(byteString);
                                            }
                                            DeviceInfoRepository deviceInfoRepository5 = androidGetInitializationRequestPayload3.deviceInfoRepository;
                                            androidGetInitializationRequestPayload$invoke$1.L$0 = androidGetInitializationRequestPayload3;
                                            androidGetInitializationRequestPayload$invoke$1.L$1 = dsl10;
                                            androidGetInitializationRequestPayload$invoke$1.L$2 = dsl9;
                                            androidGetInitializationRequestPayload$invoke$1.label = 6;
                                            obj2 = deviceInfoRepository5.getAuidString(androidGetInitializationRequestPayload$invoke$1);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 1:
                        _create = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$3;
                        dsl = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$2;
                        dsl2 = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$1;
                        androidGetInitializationRequestPayload = (AndroidGetInitializationRequestPayload) androidGetInitializationRequestPayload$invoke$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        _create.setClientInfo((ClientInfoOuterClass.ClientInfo) obj2);
                        DeviceInfoRepository deviceInfoRepository6 = androidGetInitializationRequestPayload.deviceInfoRepository;
                        androidGetInitializationRequestPayload$invoke$1.L$0 = androidGetInitializationRequestPayload;
                        androidGetInitializationRequestPayload$invoke$1.L$1 = dsl2;
                        androidGetInitializationRequestPayload$invoke$1.L$2 = dsl;
                        androidGetInitializationRequestPayload$invoke$1.L$3 = dsl;
                        androidGetInitializationRequestPayload$invoke$1.label = 2;
                        obj2 = deviceInfoRepository6.getIdfi(androidGetInitializationRequestPayload$invoke$1);
                        if (obj2 != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 2:
                        dsl3 = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$3;
                        dsl = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$2;
                        dsl2 = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$1;
                        androidGetInitializationRequestPayload = (AndroidGetInitializationRequestPayload) androidGetInitializationRequestPayload$invoke$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        dsl3.setIdfi((String) obj2);
                        analyticsUserId = androidGetInitializationRequestPayload.deviceInfoRepository.getAnalyticsUserId();
                        if (analyticsUserId != null) {
                        }
                        dsl.setSessionId(androidGetInitializationRequestPayload.sessionRepository.getSessionId());
                        InitializationDeviceInfoKt.Dsl.Companion companion22 = InitializationDeviceInfoKt.Dsl.INSTANCE;
                        InitializationRequestOuterClass.InitializationDeviceInfo.Builder newBuilder22 = InitializationRequestOuterClass.InitializationDeviceInfo.newBuilder();
                        Intrinsics.checkNotNullExpressionValue(newBuilder22, "newBuilder()");
                        _create2 = companion22._create(newBuilder22);
                        _create2.setBundleId(androidGetInitializationRequestPayload.deviceInfoRepository.getAppName());
                        _create2.setDeviceModel(androidGetInitializationRequestPayload.deviceInfoRepository.getModel());
                        _create2.setDeviceMake(androidGetInitializationRequestPayload.deviceInfoRepository.getManufacturer());
                        _create2.setOsVersion(androidGetInitializationRequestPayload.deviceInfoRepository.getOsVersion());
                        DeviceInfoRepository deviceInfoRepository22 = androidGetInitializationRequestPayload.deviceInfoRepository;
                        androidGetInitializationRequestPayload$invoke$1.L$0 = androidGetInitializationRequestPayload;
                        androidGetInitializationRequestPayload$invoke$1.L$1 = dsl2;
                        androidGetInitializationRequestPayload$invoke$1.L$2 = dsl;
                        androidGetInitializationRequestPayload$invoke$1.L$3 = _create2;
                        androidGetInitializationRequestPayload$invoke$1.L$4 = dsl;
                        androidGetInitializationRequestPayload$invoke$1.L$5 = _create2;
                        androidGetInitializationRequestPayload$invoke$1.L$6 = _create2;
                        androidGetInitializationRequestPayload$invoke$1.label = 3;
                        obj2 = deviceInfoRepository22.staticDeviceInfo(androidGetInitializationRequestPayload$invoke$1);
                        if (obj2 != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 3:
                        _create2 = (InitializationDeviceInfoKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$6;
                        dsl4 = (InitializationDeviceInfoKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$5;
                        dsl = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$4;
                        dsl6 = (InitializationDeviceInfoKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$3;
                        dsl7 = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$2;
                        dsl5 = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$1;
                        androidGetInitializationRequestPayload2 = (AndroidGetInitializationRequestPayload) androidGetInitializationRequestPayload$invoke$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        _create2.setTotalDiskSpace(((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj2).getTotalDiskSpace());
                        DeviceInfoRepository deviceInfoRepository32 = androidGetInitializationRequestPayload2.deviceInfoRepository;
                        androidGetInitializationRequestPayload$invoke$1.L$0 = androidGetInitializationRequestPayload2;
                        androidGetInitializationRequestPayload$invoke$1.L$1 = dsl5;
                        androidGetInitializationRequestPayload$invoke$1.L$2 = dsl7;
                        androidGetInitializationRequestPayload$invoke$1.L$3 = dsl6;
                        androidGetInitializationRequestPayload$invoke$1.L$4 = dsl;
                        androidGetInitializationRequestPayload$invoke$1.L$5 = dsl4;
                        androidGetInitializationRequestPayload$invoke$1.L$6 = dsl4;
                        androidGetInitializationRequestPayload$invoke$1.label = 4;
                        obj2 = deviceInfoRepository32.staticDeviceInfo(androidGetInitializationRequestPayload$invoke$1);
                        if (obj2 != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 4:
                        dsl8 = (InitializationDeviceInfoKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$6;
                        dsl4 = (InitializationDeviceInfoKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$5;
                        dsl = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$4;
                        dsl6 = (InitializationDeviceInfoKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$3;
                        dsl7 = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$2;
                        dsl5 = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$1;
                        androidGetInitializationRequestPayload2 = (AndroidGetInitializationRequestPayload) androidGetInitializationRequestPayload$invoke$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        dsl8.setTotalRamMemory(((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj2).getTotalRamMemory());
                        dsl4.setCurrentUiTheme(androidGetInitializationRequestPayload2.deviceInfoRepository.getCurrentUiTheme());
                        String networkOperator2 = androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getNetworkOperator();
                        Intrinsics.checkNotNullExpressionValue(networkOperator2, "deviceInfoRepository.dyn…eviceInfo.networkOperator");
                        dsl4.setNetworkOperator(networkOperator2);
                        dsl4.setBatteryLevel(androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getBatteryLevel());
                        dsl4.setBatteryStatus(androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getBatteryStatus());
                        dsl4.setSystemBootTime(androidGetInitializationRequestPayload2.deviceInfoRepository.getSystemBootTime());
                        String language2 = androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getLanguage();
                        Intrinsics.checkNotNullExpressionValue(language2, "deviceInfoRepository.dynamicDeviceInfo.language");
                        dsl4.setLanguage(language2);
                        dsl4.setLocalList(CollectionsKt.joinToString$default(androidGetInitializationRequestPayload2.deviceInfoRepository.getLocaleList(), ",", null, null, 0, null, null, 62, null));
                        dsl4.setConnectionType(androidGetInitializationRequestPayload2.deviceInfoRepository.getConnectionTypeStr());
                        dsl.setDeviceInfo(dsl6._build());
                        DeviceInfoRepository deviceInfoRepository42 = androidGetInitializationRequestPayload2.deviceInfoRepository;
                        androidGetInitializationRequestPayload$invoke$1.L$0 = androidGetInitializationRequestPayload2;
                        androidGetInitializationRequestPayload$invoke$1.L$1 = dsl5;
                        androidGetInitializationRequestPayload$invoke$1.L$2 = dsl7;
                        androidGetInitializationRequestPayload$invoke$1.L$3 = null;
                        androidGetInitializationRequestPayload$invoke$1.L$4 = null;
                        androidGetInitializationRequestPayload$invoke$1.L$5 = null;
                        androidGetInitializationRequestPayload$invoke$1.L$6 = null;
                        androidGetInitializationRequestPayload$invoke$1.label = 5;
                        obj2 = deviceInfoRepository42.getAuidByteString(androidGetInitializationRequestPayload$invoke$1);
                        if (obj2 != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 5:
                        dsl9 = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$2;
                        dsl10 = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$1;
                        androidGetInitializationRequestPayload3 = (AndroidGetInitializationRequestPayload) androidGetInitializationRequestPayload$invoke$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        byteString = (ByteString) obj2;
                        if (byteString != null) {
                        }
                        DeviceInfoRepository deviceInfoRepository52 = androidGetInitializationRequestPayload3.deviceInfoRepository;
                        androidGetInitializationRequestPayload$invoke$1.L$0 = androidGetInitializationRequestPayload3;
                        androidGetInitializationRequestPayload$invoke$1.L$1 = dsl10;
                        androidGetInitializationRequestPayload$invoke$1.L$2 = dsl9;
                        androidGetInitializationRequestPayload$invoke$1.label = 6;
                        obj2 = deviceInfoRepository52.getAuidString(androidGetInitializationRequestPayload$invoke$1);
                        break;
                    case 6:
                        dsl9 = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$2;
                        dsl10 = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$1;
                        androidGetInitializationRequestPayload3 = (AndroidGetInitializationRequestPayload) androidGetInitializationRequestPayload$invoke$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        String str2 = (String) obj2;
                        String str3 = str2;
                        if (str3 != null && str3.length() != 0) {
                            dsl9.setAuidString(str2);
                        }
                        SessionRepository sessionRepository = androidGetInitializationRequestPayload3.sessionRepository;
                        androidGetInitializationRequestPayload$invoke$1.L$0 = androidGetInitializationRequestPayload3;
                        androidGetInitializationRequestPayload$invoke$1.L$1 = dsl10;
                        androidGetInitializationRequestPayload$invoke$1.L$2 = dsl9;
                        androidGetInitializationRequestPayload$invoke$1.label = 7;
                        obj2 = sessionRepository.getPrivacy(androidGetInitializationRequestPayload$invoke$1);
                        break;
                    case 7:
                        dsl9 = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$2;
                        dsl10 = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$1;
                        androidGetInitializationRequestPayload3 = (AndroidGetInitializationRequestPayload) androidGetInitializationRequestPayload$invoke$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        ByteString byteString3 = (ByteString) obj2;
                        if (!byteString3.isEmpty()) {
                            dsl9.setPrivacy(byteString3);
                        }
                        SessionRepository sessionRepository2 = androidGetInitializationRequestPayload3.sessionRepository;
                        androidGetInitializationRequestPayload$invoke$1.L$0 = androidGetInitializationRequestPayload3;
                        androidGetInitializationRequestPayload$invoke$1.L$1 = dsl10;
                        androidGetInitializationRequestPayload$invoke$1.L$2 = dsl9;
                        androidGetInitializationRequestPayload$invoke$1.label = 8;
                        obj2 = sessionRepository2.getGatewayCache(androidGetInitializationRequestPayload$invoke$1);
                        if (obj2 != coroutine_suspended) {
                            dsl11 = dsl9;
                            dsl12 = dsl10;
                            androidGetInitializationRequestPayload4 = androidGetInitializationRequestPayload3;
                            byteString2 = (ByteString) obj2;
                            if (!byteString2.isEmpty()) {
                                dsl11.setCache(byteString2);
                            }
                            MediationInitBlobMetadataReader mediationInitBlobMetadataReader = androidGetInitializationRequestPayload4.mediationInitBlobMetadataReader;
                            obj = mediationInitBlobMetadataReader.getJsonStorage().get(mediationInitBlobMetadataReader.getKey());
                            if (obj != null) {
                                Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
                                if (!(obj instanceof String)) {
                                    obj = null;
                                }
                                if (obj != null) {
                                    obj3 = obj;
                                }
                            }
                            str = (String) obj3;
                            if (str != null) {
                                dsl11.setUadsInitBlob(ByteStringsKt.toByteStringUtf8(str));
                            }
                            legacyFlowUserConsent = androidGetInitializationRequestPayload4.legacyUserConsentRepository.getLegacyFlowUserConsent();
                            if (legacyFlowUserConsent != null) {
                                dsl11.setLegacyFlowUserConsent(legacyFlowUserConsent);
                            }
                            return dsl12._build();
                        }
                        return coroutine_suspended;
                    case 8:
                        dsl11 = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$2;
                        dsl12 = (InitializationRequestKt.Dsl) androidGetInitializationRequestPayload$invoke$1.L$1;
                        androidGetInitializationRequestPayload4 = (AndroidGetInitializationRequestPayload) androidGetInitializationRequestPayload$invoke$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        byteString2 = (ByteString) obj2;
                        if (!byteString2.isEmpty()) {
                        }
                        MediationInitBlobMetadataReader mediationInitBlobMetadataReader2 = androidGetInitializationRequestPayload4.mediationInitBlobMetadataReader;
                        obj = mediationInitBlobMetadataReader2.getJsonStorage().get(mediationInitBlobMetadataReader2.getKey());
                        if (obj != null) {
                        }
                        str = (String) obj3;
                        if (str != null) {
                        }
                        legacyFlowUserConsent = androidGetInitializationRequestPayload4.legacyUserConsentRepository.getLegacyFlowUserConsent();
                        if (legacyFlowUserConsent != null) {
                        }
                        return dsl12._build();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        androidGetInitializationRequestPayload$invoke$1 = new AndroidGetInitializationRequestPayload$invoke$1(this, continuation);
        Object obj22 = androidGetInitializationRequestPayload$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object obj32 = null;
        switch (androidGetInitializationRequestPayload$invoke$1.label) {
        }
    }
}
