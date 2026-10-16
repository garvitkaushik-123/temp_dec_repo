package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.MediationRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import gatewayprotocol.v1.ClientInfoOuterClass;
import gatewayprotocol.v1.LimitedSessionTokenKt;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidGetLimitedSessionToken.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidGetLimitedSessionToken;", "Lcom/unity3d/ads/core/domain/GetLimitedSessionToken;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "mediationRepository", "Lcom/unity3d/ads/core/data/repository/MediationRepository;", "(Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/MediationRepository;)V", "invoke", "Lgatewayprotocol/v1/UniversalRequestOuterClass$LimitedSessionToken;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidGetLimitedSessionToken implements GetLimitedSessionToken {
    private final DeviceInfoRepository deviceInfoRepository;
    private final MediationRepository mediationRepository;
    private final SessionRepository sessionRepository;

    public AndroidGetLimitedSessionToken(DeviceInfoRepository deviceInfoRepository, SessionRepository sessionRepository, MediationRepository mediationRepository) {
        Intrinsics.checkNotNullParameter(deviceInfoRepository, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(mediationRepository, "mediationRepository");
        this.deviceInfoRepository = deviceInfoRepository;
        this.sessionRepository = sessionRepository;
        this.mediationRepository = mediationRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // com.unity3d.ads.core.domain.GetLimitedSessionToken
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(Continuation<? super UniversalRequestOuterClass.LimitedSessionToken> continuation) {
        AndroidGetLimitedSessionToken$invoke$1 androidGetLimitedSessionToken$invoke$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        LimitedSessionTokenKt.Dsl _create;
        AndroidGetLimitedSessionToken androidGetLimitedSessionToken;
        LimitedSessionTokenKt.Dsl dsl;
        LimitedSessionTokenKt.Dsl dsl2;
        LimitedSessionTokenKt.Dsl dsl3;
        LimitedSessionTokenKt.Dsl dsl4;
        LimitedSessionTokenKt.Dsl dsl5;
        AndroidGetLimitedSessionToken androidGetLimitedSessionToken2;
        LimitedSessionTokenKt.Dsl dsl6;
        LimitedSessionTokenKt.Dsl dsl7;
        LimitedSessionTokenKt.Dsl dsl8;
        AndroidGetLimitedSessionToken androidGetLimitedSessionToken3;
        LimitedSessionTokenKt.Dsl dsl9;
        LimitedSessionTokenKt.Dsl dsl10;
        LimitedSessionTokenKt.Dsl dsl11;
        AndroidGetLimitedSessionToken androidGetLimitedSessionToken4;
        String gameId;
        String name;
        String version;
        if (continuation instanceof AndroidGetLimitedSessionToken$invoke$1) {
            androidGetLimitedSessionToken$invoke$1 = (AndroidGetLimitedSessionToken$invoke$1) continuation;
            if ((androidGetLimitedSessionToken$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidGetLimitedSessionToken$invoke$1.label -= Integer.MIN_VALUE;
                obj = androidGetLimitedSessionToken$invoke$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidGetLimitedSessionToken$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    LimitedSessionTokenKt.Dsl.Companion companion = LimitedSessionTokenKt.Dsl.INSTANCE;
                    UniversalRequestOuterClass.LimitedSessionToken.Builder newBuilder = UniversalRequestOuterClass.LimitedSessionToken.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                    _create = companion._create(newBuilder);
                    _create.setSessionId(this.sessionRepository.getSessionId());
                    DeviceInfoRepository deviceInfoRepository = this.deviceInfoRepository;
                    androidGetLimitedSessionToken$invoke$1.L$0 = this;
                    androidGetLimitedSessionToken$invoke$1.L$1 = _create;
                    androidGetLimitedSessionToken$invoke$1.L$2 = _create;
                    androidGetLimitedSessionToken$invoke$1.L$3 = _create;
                    androidGetLimitedSessionToken$invoke$1.label = 1;
                    obj = deviceInfoRepository.staticDeviceInfo(androidGetLimitedSessionToken$invoke$1);
                    if (obj != coroutine_suspended) {
                        androidGetLimitedSessionToken = this;
                        dsl = _create;
                        dsl2 = dsl;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i == 2) {
                        dsl3 = (LimitedSessionTokenKt.Dsl) androidGetLimitedSessionToken$invoke$1.L$3;
                        dsl4 = (LimitedSessionTokenKt.Dsl) androidGetLimitedSessionToken$invoke$1.L$2;
                        dsl5 = (LimitedSessionTokenKt.Dsl) androidGetLimitedSessionToken$invoke$1.L$1;
                        androidGetLimitedSessionToken2 = (AndroidGetLimitedSessionToken) androidGetLimitedSessionToken$invoke$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        String deviceModel = ((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj).getDeviceModel();
                        Intrinsics.checkNotNullExpressionValue(deviceModel, "deviceInfoRepository.sta…cDeviceInfo().deviceModel");
                        dsl3.setDeviceModel(deviceModel);
                        DeviceInfoRepository deviceInfoRepository2 = androidGetLimitedSessionToken2.deviceInfoRepository;
                        androidGetLimitedSessionToken$invoke$1.L$0 = androidGetLimitedSessionToken2;
                        androidGetLimitedSessionToken$invoke$1.L$1 = dsl5;
                        androidGetLimitedSessionToken$invoke$1.L$2 = dsl4;
                        androidGetLimitedSessionToken$invoke$1.L$3 = dsl4;
                        androidGetLimitedSessionToken$invoke$1.label = 3;
                        obj = deviceInfoRepository2.staticDeviceInfo(androidGetLimitedSessionToken$invoke$1);
                        if (obj != coroutine_suspended) {
                            dsl6 = dsl4;
                            dsl7 = dsl6;
                            dsl8 = dsl5;
                            androidGetLimitedSessionToken3 = androidGetLimitedSessionToken2;
                            String osVersion = ((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj).getOsVersion();
                            Intrinsics.checkNotNullExpressionValue(osVersion, "deviceInfoRepository.staticDeviceInfo().osVersion");
                            dsl6.setOsVersion(osVersion);
                            DeviceInfoRepository deviceInfoRepository3 = androidGetLimitedSessionToken3.deviceInfoRepository;
                            androidGetLimitedSessionToken$invoke$1.L$0 = androidGetLimitedSessionToken3;
                            androidGetLimitedSessionToken$invoke$1.L$1 = dsl8;
                            androidGetLimitedSessionToken$invoke$1.L$2 = dsl7;
                            androidGetLimitedSessionToken$invoke$1.L$3 = dsl7;
                            androidGetLimitedSessionToken$invoke$1.label = 4;
                            obj = deviceInfoRepository3.getIdfi(androidGetLimitedSessionToken$invoke$1);
                            if (obj != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    }
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        dsl9 = (LimitedSessionTokenKt.Dsl) androidGetLimitedSessionToken$invoke$1.L$3;
                        dsl10 = (LimitedSessionTokenKt.Dsl) androidGetLimitedSessionToken$invoke$1.L$2;
                        dsl11 = (LimitedSessionTokenKt.Dsl) androidGetLimitedSessionToken$invoke$1.L$1;
                        androidGetLimitedSessionToken4 = (AndroidGetLimitedSessionToken) androidGetLimitedSessionToken$invoke$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        dsl9.setIdfi((String) obj);
                        dsl10.setSdkVersion(41601);
                        dsl10.setSdkVersionName("4.16.1");
                        gameId = androidGetLimitedSessionToken4.sessionRepository.getGameId();
                        if (gameId != null) {
                            dsl10.setGameId(gameId);
                        }
                        dsl10.setPlatform(ClientInfoOuterClass.Platform.PLATFORM_ANDROID);
                        dsl10.setMediationProvider(androidGetLimitedSessionToken4.mediationRepository.getMediationProvider().invoke());
                        name = androidGetLimitedSessionToken4.mediationRepository.getName();
                        if (name != null && dsl10.getMediationProvider() == ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_CUSTOM) {
                            dsl10.setCustomMediationName(name);
                        }
                        version = androidGetLimitedSessionToken4.mediationRepository.getVersion();
                        if (version != null) {
                            dsl10.setMediationVersion(version);
                        }
                        return dsl11._build();
                    }
                    dsl6 = (LimitedSessionTokenKt.Dsl) androidGetLimitedSessionToken$invoke$1.L$3;
                    dsl7 = (LimitedSessionTokenKt.Dsl) androidGetLimitedSessionToken$invoke$1.L$2;
                    dsl8 = (LimitedSessionTokenKt.Dsl) androidGetLimitedSessionToken$invoke$1.L$1;
                    androidGetLimitedSessionToken3 = (AndroidGetLimitedSessionToken) androidGetLimitedSessionToken$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    String osVersion2 = ((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj).getOsVersion();
                    Intrinsics.checkNotNullExpressionValue(osVersion2, "deviceInfoRepository.staticDeviceInfo().osVersion");
                    dsl6.setOsVersion(osVersion2);
                    DeviceInfoRepository deviceInfoRepository32 = androidGetLimitedSessionToken3.deviceInfoRepository;
                    androidGetLimitedSessionToken$invoke$1.L$0 = androidGetLimitedSessionToken3;
                    androidGetLimitedSessionToken$invoke$1.L$1 = dsl8;
                    androidGetLimitedSessionToken$invoke$1.L$2 = dsl7;
                    androidGetLimitedSessionToken$invoke$1.L$3 = dsl7;
                    androidGetLimitedSessionToken$invoke$1.label = 4;
                    obj = deviceInfoRepository32.getIdfi(androidGetLimitedSessionToken$invoke$1);
                    if (obj != coroutine_suspended) {
                        dsl9 = dsl7;
                        dsl10 = dsl9;
                        dsl11 = dsl8;
                        androidGetLimitedSessionToken4 = androidGetLimitedSessionToken3;
                        dsl9.setIdfi((String) obj);
                        dsl10.setSdkVersion(41601);
                        dsl10.setSdkVersionName("4.16.1");
                        gameId = androidGetLimitedSessionToken4.sessionRepository.getGameId();
                        if (gameId != null) {
                        }
                        dsl10.setPlatform(ClientInfoOuterClass.Platform.PLATFORM_ANDROID);
                        dsl10.setMediationProvider(androidGetLimitedSessionToken4.mediationRepository.getMediationProvider().invoke());
                        name = androidGetLimitedSessionToken4.mediationRepository.getName();
                        if (name != null) {
                            dsl10.setCustomMediationName(name);
                        }
                        version = androidGetLimitedSessionToken4.mediationRepository.getVersion();
                        if (version != null) {
                        }
                        return dsl11._build();
                    }
                    return coroutine_suspended;
                }
                _create = (LimitedSessionTokenKt.Dsl) androidGetLimitedSessionToken$invoke$1.L$3;
                dsl = (LimitedSessionTokenKt.Dsl) androidGetLimitedSessionToken$invoke$1.L$2;
                dsl2 = (LimitedSessionTokenKt.Dsl) androidGetLimitedSessionToken$invoke$1.L$1;
                androidGetLimitedSessionToken = (AndroidGetLimitedSessionToken) androidGetLimitedSessionToken$invoke$1.L$0;
                ResultKt.throwOnFailure(obj);
                String deviceMake = ((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj).getDeviceMake();
                Intrinsics.checkNotNullExpressionValue(deviceMake, "deviceInfoRepository.staticDeviceInfo().deviceMake");
                _create.setDeviceMake(deviceMake);
                DeviceInfoRepository deviceInfoRepository4 = androidGetLimitedSessionToken.deviceInfoRepository;
                androidGetLimitedSessionToken$invoke$1.L$0 = androidGetLimitedSessionToken;
                androidGetLimitedSessionToken$invoke$1.L$1 = dsl2;
                androidGetLimitedSessionToken$invoke$1.L$2 = dsl;
                androidGetLimitedSessionToken$invoke$1.L$3 = dsl;
                androidGetLimitedSessionToken$invoke$1.label = 2;
                obj = deviceInfoRepository4.staticDeviceInfo(androidGetLimitedSessionToken$invoke$1);
                if (obj != coroutine_suspended) {
                    dsl3 = dsl;
                    dsl4 = dsl3;
                    dsl5 = dsl2;
                    androidGetLimitedSessionToken2 = androidGetLimitedSessionToken;
                    String deviceModel2 = ((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj).getDeviceModel();
                    Intrinsics.checkNotNullExpressionValue(deviceModel2, "deviceInfoRepository.sta…cDeviceInfo().deviceModel");
                    dsl3.setDeviceModel(deviceModel2);
                    DeviceInfoRepository deviceInfoRepository22 = androidGetLimitedSessionToken2.deviceInfoRepository;
                    androidGetLimitedSessionToken$invoke$1.L$0 = androidGetLimitedSessionToken2;
                    androidGetLimitedSessionToken$invoke$1.L$1 = dsl5;
                    androidGetLimitedSessionToken$invoke$1.L$2 = dsl4;
                    androidGetLimitedSessionToken$invoke$1.L$3 = dsl4;
                    androidGetLimitedSessionToken$invoke$1.label = 3;
                    obj = deviceInfoRepository22.staticDeviceInfo(androidGetLimitedSessionToken$invoke$1);
                    if (obj != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
        }
        androidGetLimitedSessionToken$invoke$1 = new AndroidGetLimitedSessionToken$invoke$1(this, continuation);
        obj = androidGetLimitedSessionToken$invoke$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidGetLimitedSessionToken$invoke$1.label;
        if (i != 0) {
        }
        String deviceMake2 = ((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj).getDeviceMake();
        Intrinsics.checkNotNullExpressionValue(deviceMake2, "deviceInfoRepository.staticDeviceInfo().deviceMake");
        _create.setDeviceMake(deviceMake2);
        DeviceInfoRepository deviceInfoRepository42 = androidGetLimitedSessionToken.deviceInfoRepository;
        androidGetLimitedSessionToken$invoke$1.L$0 = androidGetLimitedSessionToken;
        androidGetLimitedSessionToken$invoke$1.L$1 = dsl2;
        androidGetLimitedSessionToken$invoke$1.L$2 = dsl;
        androidGetLimitedSessionToken$invoke$1.L$3 = dsl;
        androidGetLimitedSessionToken$invoke$1.label = 2;
        obj = deviceInfoRepository42.staticDeviceInfo(androidGetLimitedSessionToken$invoke$1);
        if (obj != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
