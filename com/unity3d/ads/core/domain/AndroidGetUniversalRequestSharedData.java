package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.repository.DeveloperConsentRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.extensions.TimestampExtensionsKt;
import com.unity3d.services.core.properties.SdkProperties;
import gatewayprotocol.v1.PiiOuterClass;
import gatewayprotocol.v1.UniversalRequestKt;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidGetUniversalRequestSharedData.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidGetUniversalRequestSharedData;", "Lcom/unity3d/ads/core/domain/GetUniversalRequestSharedData;", "getSharedDataTimestamps", "Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "getLimitedSessionToken", "Lcom/unity3d/ads/core/domain/GetLimitedSessionToken;", "developerConsentRepository", "Lcom/unity3d/ads/core/data/repository/DeveloperConsentRepository;", "(Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/domain/GetLimitedSessionToken;Lcom/unity3d/ads/core/data/repository/DeveloperConsentRepository;)V", "invoke", "Lgatewayprotocol/v1/UniversalRequestOuterClass$UniversalRequest$SharedData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidGetUniversalRequestSharedData implements GetUniversalRequestSharedData {
    private final DeveloperConsentRepository developerConsentRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetLimitedSessionToken getLimitedSessionToken;
    private final GetSharedDataTimestamps getSharedDataTimestamps;
    private final SessionRepository sessionRepository;

    public AndroidGetUniversalRequestSharedData(GetSharedDataTimestamps getSharedDataTimestamps, SessionRepository sessionRepository, DeviceInfoRepository deviceInfoRepository, GetLimitedSessionToken getLimitedSessionToken, DeveloperConsentRepository developerConsentRepository) {
        Intrinsics.checkNotNullParameter(getSharedDataTimestamps, "getSharedDataTimestamps");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(deviceInfoRepository, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(getLimitedSessionToken, "getLimitedSessionToken");
        Intrinsics.checkNotNullParameter(developerConsentRepository, "developerConsentRepository");
        this.getSharedDataTimestamps = getSharedDataTimestamps;
        this.sessionRepository = sessionRepository;
        this.deviceInfoRepository = deviceInfoRepository;
        this.getLimitedSessionToken = getLimitedSessionToken;
        this.developerConsentRepository = developerConsentRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.unity3d.ads.core.domain.GetUniversalRequestSharedData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(Continuation<? super UniversalRequestOuterClass.UniversalRequest.SharedData> continuation) {
        AndroidGetUniversalRequestSharedData$invoke$1 androidGetUniversalRequestSharedData$invoke$1;
        int i;
        UniversalRequestKt.SharedDataKt.Dsl _create;
        UniversalRequestKt.SharedDataKt.Dsl dsl;
        UniversalRequestKt.SharedDataKt.Dsl dsl2;
        UniversalRequestKt.SharedDataKt.Dsl dsl3;
        AndroidGetUniversalRequestSharedData androidGetUniversalRequestSharedData;
        PiiOuterClass.Pii piiData;
        if (continuation instanceof AndroidGetUniversalRequestSharedData$invoke$1) {
            androidGetUniversalRequestSharedData$invoke$1 = (AndroidGetUniversalRequestSharedData$invoke$1) continuation;
            if ((androidGetUniversalRequestSharedData$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidGetUniversalRequestSharedData$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = androidGetUniversalRequestSharedData$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidGetUniversalRequestSharedData$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    UniversalRequestKt universalRequestKt = UniversalRequestKt.INSTANCE;
                    UniversalRequestKt.SharedDataKt.Dsl.Companion companion = UniversalRequestKt.SharedDataKt.Dsl.INSTANCE;
                    UniversalRequestOuterClass.UniversalRequest.SharedData.Builder newBuilder = UniversalRequestOuterClass.UniversalRequest.SharedData.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                    _create = companion._create(newBuilder);
                    ByteString sessionToken = this.sessionRepository.getSessionToken();
                    if (!sessionToken.isEmpty()) {
                        _create.setSessionToken(sessionToken);
                        androidGetUniversalRequestSharedData = this;
                        dsl3 = _create;
                        _create.setTimestamps(androidGetUniversalRequestSharedData.getSharedDataTimestamps.invoke());
                        _create.setSdkStartTime(TimestampExtensionsKt.fromMillis(SdkProperties.getInitializationTimeEpoch()));
                        _create.setAppStartTime(TimestampExtensionsKt.fromMillis(SdkProperties.getAppInitializationTimeSinceEpoch()));
                        _create.setDeveloperConsent(androidGetUniversalRequestSharedData.developerConsentRepository.getDeveloperConsent());
                        piiData = androidGetUniversalRequestSharedData.deviceInfoRepository.getPiiData();
                        if (piiData.getAdvertisingId().isEmpty() || !piiData.getOpenAdvertisingTrackingId().isEmpty()) {
                            _create.setPii(piiData);
                        }
                        return dsl3._build();
                    }
                    GetLimitedSessionToken getLimitedSessionToken = this.getLimitedSessionToken;
                    androidGetUniversalRequestSharedData$invoke$1.L$0 = this;
                    androidGetUniversalRequestSharedData$invoke$1.L$1 = _create;
                    androidGetUniversalRequestSharedData$invoke$1.L$2 = _create;
                    androidGetUniversalRequestSharedData$invoke$1.L$3 = _create;
                    androidGetUniversalRequestSharedData$invoke$1.label = 1;
                    Object invoke = getLimitedSessionToken.invoke(androidGetUniversalRequestSharedData$invoke$1);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    dsl = _create;
                    dsl2 = dsl;
                    dsl3 = dsl2;
                    obj = invoke;
                    androidGetUniversalRequestSharedData = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    dsl = (UniversalRequestKt.SharedDataKt.Dsl) androidGetUniversalRequestSharedData$invoke$1.L$3;
                    dsl2 = (UniversalRequestKt.SharedDataKt.Dsl) androidGetUniversalRequestSharedData$invoke$1.L$2;
                    dsl3 = (UniversalRequestKt.SharedDataKt.Dsl) androidGetUniversalRequestSharedData$invoke$1.L$1;
                    androidGetUniversalRequestSharedData = (AndroidGetUniversalRequestSharedData) androidGetUniversalRequestSharedData$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                dsl.setLimitedSessionToken((UniversalRequestOuterClass.LimitedSessionToken) obj);
                _create = dsl2;
                _create.setTimestamps(androidGetUniversalRequestSharedData.getSharedDataTimestamps.invoke());
                _create.setSdkStartTime(TimestampExtensionsKt.fromMillis(SdkProperties.getInitializationTimeEpoch()));
                _create.setAppStartTime(TimestampExtensionsKt.fromMillis(SdkProperties.getAppInitializationTimeSinceEpoch()));
                _create.setDeveloperConsent(androidGetUniversalRequestSharedData.developerConsentRepository.getDeveloperConsent());
                piiData = androidGetUniversalRequestSharedData.deviceInfoRepository.getPiiData();
                if (piiData.getAdvertisingId().isEmpty()) {
                }
                _create.setPii(piiData);
                return dsl3._build();
            }
        }
        androidGetUniversalRequestSharedData$invoke$1 = new AndroidGetUniversalRequestSharedData$invoke$1(this, continuation);
        Object obj2 = androidGetUniversalRequestSharedData$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidGetUniversalRequestSharedData$invoke$1.label;
        if (i != 0) {
        }
        dsl.setLimitedSessionToken((UniversalRequestOuterClass.LimitedSessionToken) obj2);
        _create = dsl2;
        _create.setTimestamps(androidGetUniversalRequestSharedData.getSharedDataTimestamps.invoke());
        _create.setSdkStartTime(TimestampExtensionsKt.fromMillis(SdkProperties.getInitializationTimeEpoch()));
        _create.setAppStartTime(TimestampExtensionsKt.fromMillis(SdkProperties.getAppInitializationTimeSinceEpoch()));
        _create.setDeveloperConsent(androidGetUniversalRequestSharedData.developerConsentRepository.getDeveloperConsent());
        piiData = androidGetUniversalRequestSharedData.deviceInfoRepository.getPiiData();
        if (piiData.getAdvertisingId().isEmpty()) {
        }
        _create.setPii(piiData);
        return dsl3._build();
    }
}
