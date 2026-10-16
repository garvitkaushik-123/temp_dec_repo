package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ByteStringsKt;
import com.unity3d.ads.TokenConfiguration;
import com.unity3d.ads.core.data.manager.OfferwallManager;
import com.unity3d.ads.core.data.model.TokenCounters;
import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.data.repository.TcfRepository;
import com.unity3d.ads.core.extensions.AdFormatExtensions;
import gatewayprotocol.v1.ClientInfoOuterClass;
import gatewayprotocol.v1.HeaderBiddingTokenKt;
import gatewayprotocol.v1.HeaderBiddingTokenOuterClass;
import gatewayprotocol.v1.InitializationDataOuterClass;
import gatewayprotocol.v1.PiiOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import gatewayprotocol.v1.TestDataOuterClass;
import gatewayprotocol.v1.TokenCountersKt;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidBuildHeaderBiddingToken.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J+\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0096Bø\u0001\u0000¢\u0006\u0002\u0010!R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidBuildHeaderBiddingToken;", "Lcom/unity3d/ads/core/domain/BuildHeaderBiddingToken;", "generateId", "Lcom/unity3d/ads/core/domain/GetByteStringId;", "getClientInfo", "Lcom/unity3d/ads/core/domain/GetClientInfo;", "getTimestamps", "Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;", "getLimitedSessionToken", "Lcom/unity3d/ads/core/domain/GetLimitedSessionToken;", "getInitializationData", "Lcom/unity3d/ads/core/domain/GetInitializationData;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "campaignRepository", "Lcom/unity3d/ads/core/data/repository/CampaignRepository;", "tcfRepository", "Lcom/unity3d/ads/core/data/repository/TcfRepository;", "testDataInfo", "Lcom/unity3d/ads/core/domain/AndroidTestDataInfo;", "offerwallManager", "Lcom/unity3d/ads/core/data/manager/OfferwallManager;", "(Lcom/unity3d/ads/core/domain/GetByteStringId;Lcom/unity3d/ads/core/domain/GetClientInfo;Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;Lcom/unity3d/ads/core/domain/GetLimitedSessionToken;Lcom/unity3d/ads/core/domain/GetInitializationData;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/CampaignRepository;Lcom/unity3d/ads/core/data/repository/TcfRepository;Lcom/unity3d/ads/core/domain/AndroidTestDataInfo;Lcom/unity3d/ads/core/data/manager/OfferwallManager;)V", "invoke", "Lgatewayprotocol/v1/HeaderBiddingTokenOuterClass$HeaderBiddingToken;", "tokenNumber", "", "tokenConfiguration", "Lcom/unity3d/ads/TokenConfiguration;", "scarSignalsCollected", "", "(ILcom/unity3d/ads/TokenConfiguration;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidBuildHeaderBiddingToken implements BuildHeaderBiddingToken {
    private final CampaignRepository campaignRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetByteStringId generateId;
    private final GetClientInfo getClientInfo;
    private final GetInitializationData getInitializationData;
    private final GetLimitedSessionToken getLimitedSessionToken;
    private final GetSharedDataTimestamps getTimestamps;
    private final OfferwallManager offerwallManager;
    private final SessionRepository sessionRepository;
    private final TcfRepository tcfRepository;
    private final AndroidTestDataInfo testDataInfo;

    public AndroidBuildHeaderBiddingToken(GetByteStringId generateId, GetClientInfo getClientInfo, GetSharedDataTimestamps getTimestamps, GetLimitedSessionToken getLimitedSessionToken, GetInitializationData getInitializationData, DeviceInfoRepository deviceInfoRepository, SessionRepository sessionRepository, CampaignRepository campaignRepository, TcfRepository tcfRepository, AndroidTestDataInfo testDataInfo, OfferwallManager offerwallManager) {
        Intrinsics.checkNotNullParameter(generateId, "generateId");
        Intrinsics.checkNotNullParameter(getClientInfo, "getClientInfo");
        Intrinsics.checkNotNullParameter(getTimestamps, "getTimestamps");
        Intrinsics.checkNotNullParameter(getLimitedSessionToken, "getLimitedSessionToken");
        Intrinsics.checkNotNullParameter(getInitializationData, "getInitializationData");
        Intrinsics.checkNotNullParameter(deviceInfoRepository, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(campaignRepository, "campaignRepository");
        Intrinsics.checkNotNullParameter(tcfRepository, "tcfRepository");
        Intrinsics.checkNotNullParameter(testDataInfo, "testDataInfo");
        Intrinsics.checkNotNullParameter(offerwallManager, "offerwallManager");
        this.generateId = generateId;
        this.getClientInfo = getClientInfo;
        this.getTimestamps = getTimestamps;
        this.getLimitedSessionToken = getLimitedSessionToken;
        this.getInitializationData = getInitializationData;
        this.deviceInfoRepository = deviceInfoRepository;
        this.sessionRepository = sessionRepository;
        this.campaignRepository = campaignRepository;
        this.tcfRepository = tcfRepository;
        this.testDataInfo = testDataInfo;
        this.offerwallManager = offerwallManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    @Override // com.unity3d.ads.core.domain.BuildHeaderBiddingToken
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(int i, TokenConfiguration tokenConfiguration, boolean z, Continuation<? super HeaderBiddingTokenOuterClass.HeaderBiddingToken> continuation) {
        AndroidBuildHeaderBiddingToken$invoke$1 androidBuildHeaderBiddingToken$invoke$1;
        Object obj;
        Object coroutine_suspended;
        int i2;
        TokenCounters tokenCounters;
        HeaderBiddingTokenKt.Dsl _create;
        boolean z2;
        ByteString byteString;
        HeaderBiddingTokenKt.Dsl dsl;
        HeaderBiddingTokenKt.Dsl dsl2;
        TokenConfiguration tokenConfiguration2;
        AndroidBuildHeaderBiddingToken androidBuildHeaderBiddingToken;
        PiiOuterClass.Pii piiData;
        String tcfString;
        HeaderBiddingTokenKt.Dsl dsl3;
        AndroidBuildHeaderBiddingToken androidBuildHeaderBiddingToken2;
        ByteString byteString2;
        HeaderBiddingTokenKt.Dsl dsl4;
        HeaderBiddingTokenKt.Dsl dsl5;
        HeaderBiddingTokenKt.Dsl dsl6;
        TokenCounters tokenCounters2;
        HeaderBiddingTokenKt.Dsl dsl7;
        HeaderBiddingTokenKt.Dsl dsl8;
        HeaderBiddingTokenKt.Dsl dsl9;
        HeaderBiddingTokenKt.Dsl dsl10;
        TokenCounters tokenCounters3;
        AndroidBuildHeaderBiddingToken androidBuildHeaderBiddingToken3;
        TestDataOuterClass.TestData invoke;
        if (continuation instanceof AndroidBuildHeaderBiddingToken$invoke$1) {
            androidBuildHeaderBiddingToken$invoke$1 = (AndroidBuildHeaderBiddingToken$invoke$1) continuation;
            if ((androidBuildHeaderBiddingToken$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidBuildHeaderBiddingToken$invoke$1.label -= Integer.MIN_VALUE;
                obj = androidBuildHeaderBiddingToken$invoke$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = androidBuildHeaderBiddingToken$invoke$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    tokenCounters = this.sessionRepository.getTokenCounters();
                    ByteString sessionToken = this.sessionRepository.getSessionToken();
                    this.sessionRepository.incrementTokenSequenceNumber();
                    HeaderBiddingTokenKt.Dsl.Companion companion = HeaderBiddingTokenKt.Dsl.INSTANCE;
                    HeaderBiddingTokenOuterClass.HeaderBiddingToken.Builder newBuilder = HeaderBiddingTokenOuterClass.HeaderBiddingToken.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                    _create = companion._create(newBuilder);
                    _create.setTokenId(this.generateId.invoke());
                    _create.setTokenNumber(i);
                    GetClientInfo getClientInfo = this.getClientInfo;
                    androidBuildHeaderBiddingToken$invoke$1.L$0 = this;
                    androidBuildHeaderBiddingToken$invoke$1.L$1 = tokenConfiguration;
                    androidBuildHeaderBiddingToken$invoke$1.L$2 = tokenCounters;
                    androidBuildHeaderBiddingToken$invoke$1.L$3 = sessionToken;
                    androidBuildHeaderBiddingToken$invoke$1.L$4 = _create;
                    androidBuildHeaderBiddingToken$invoke$1.L$5 = _create;
                    androidBuildHeaderBiddingToken$invoke$1.L$6 = _create;
                    z2 = z;
                    androidBuildHeaderBiddingToken$invoke$1.Z$0 = z2;
                    androidBuildHeaderBiddingToken$invoke$1.label = 1;
                    Object invoke2 = getClientInfo.invoke(androidBuildHeaderBiddingToken$invoke$1);
                    if (invoke2 != coroutine_suspended) {
                        byteString = sessionToken;
                        dsl = _create;
                        dsl2 = dsl;
                        obj = invoke2;
                        tokenConfiguration2 = tokenConfiguration;
                        androidBuildHeaderBiddingToken = this;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 == 2) {
                        _create = (HeaderBiddingTokenKt.Dsl) androidBuildHeaderBiddingToken$invoke$1.L$5;
                        dsl3 = (HeaderBiddingTokenKt.Dsl) androidBuildHeaderBiddingToken$invoke$1.L$4;
                        HeaderBiddingTokenKt.Dsl dsl11 = (HeaderBiddingTokenKt.Dsl) androidBuildHeaderBiddingToken$invoke$1.L$3;
                        byteString2 = (ByteString) androidBuildHeaderBiddingToken$invoke$1.L$2;
                        TokenCounters tokenCounters4 = (TokenCounters) androidBuildHeaderBiddingToken$invoke$1.L$1;
                        AndroidBuildHeaderBiddingToken androidBuildHeaderBiddingToken4 = (AndroidBuildHeaderBiddingToken) androidBuildHeaderBiddingToken$invoke$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        tokenCounters = tokenCounters4;
                        dsl2 = dsl11;
                        androidBuildHeaderBiddingToken2 = androidBuildHeaderBiddingToken4;
                        _create.setOfferwallEnabled(((Boolean) obj).booleanValue());
                        if (!byteString2.isEmpty()) {
                            String gameId = androidBuildHeaderBiddingToken2.sessionRepository.getGameId();
                            if (gameId != null && gameId.length() > 0) {
                                GetInitializationData getInitializationData = androidBuildHeaderBiddingToken2.getInitializationData;
                                androidBuildHeaderBiddingToken$invoke$1.L$0 = androidBuildHeaderBiddingToken2;
                                androidBuildHeaderBiddingToken$invoke$1.L$1 = tokenCounters;
                                androidBuildHeaderBiddingToken$invoke$1.L$2 = dsl2;
                                androidBuildHeaderBiddingToken$invoke$1.L$3 = dsl3;
                                androidBuildHeaderBiddingToken$invoke$1.L$4 = dsl3;
                                androidBuildHeaderBiddingToken$invoke$1.L$5 = null;
                                androidBuildHeaderBiddingToken$invoke$1.label = 3;
                                obj = getInitializationData.invoke(androidBuildHeaderBiddingToken$invoke$1);
                                if (obj != coroutine_suspended) {
                                    dsl7 = dsl3;
                                    dsl5 = dsl7;
                                    dsl6 = dsl2;
                                    tokenCounters2 = tokenCounters;
                                    dsl7.setInitializationData((InitializationDataOuterClass.InitializationData) obj);
                                    dsl8 = dsl6;
                                    DeviceInfoRepository deviceInfoRepository = androidBuildHeaderBiddingToken2.deviceInfoRepository;
                                    androidBuildHeaderBiddingToken$invoke$1.L$0 = androidBuildHeaderBiddingToken2;
                                    androidBuildHeaderBiddingToken$invoke$1.L$1 = tokenCounters2;
                                    androidBuildHeaderBiddingToken$invoke$1.L$2 = dsl8;
                                    androidBuildHeaderBiddingToken$invoke$1.L$3 = dsl5;
                                    androidBuildHeaderBiddingToken$invoke$1.L$4 = dsl5;
                                    androidBuildHeaderBiddingToken$invoke$1.label = 5;
                                    obj = deviceInfoRepository.staticDeviceInfo(androidBuildHeaderBiddingToken$invoke$1);
                                    if (obj != coroutine_suspended) {
                                    }
                                }
                            } else {
                                GetLimitedSessionToken getLimitedSessionToken = androidBuildHeaderBiddingToken2.getLimitedSessionToken;
                                androidBuildHeaderBiddingToken$invoke$1.L$0 = androidBuildHeaderBiddingToken2;
                                androidBuildHeaderBiddingToken$invoke$1.L$1 = tokenCounters;
                                androidBuildHeaderBiddingToken$invoke$1.L$2 = dsl2;
                                androidBuildHeaderBiddingToken$invoke$1.L$3 = dsl3;
                                androidBuildHeaderBiddingToken$invoke$1.L$4 = dsl3;
                                androidBuildHeaderBiddingToken$invoke$1.L$5 = null;
                                androidBuildHeaderBiddingToken$invoke$1.label = 4;
                                obj = getLimitedSessionToken.invoke(androidBuildHeaderBiddingToken$invoke$1);
                                if (obj != coroutine_suspended) {
                                    dsl4 = dsl3;
                                    dsl5 = dsl4;
                                    dsl6 = dsl2;
                                    tokenCounters2 = tokenCounters;
                                    dsl4.setLimitedSessionToken((UniversalRequestOuterClass.LimitedSessionToken) obj);
                                    dsl8 = dsl6;
                                    DeviceInfoRepository deviceInfoRepository2 = androidBuildHeaderBiddingToken2.deviceInfoRepository;
                                    androidBuildHeaderBiddingToken$invoke$1.L$0 = androidBuildHeaderBiddingToken2;
                                    androidBuildHeaderBiddingToken$invoke$1.L$1 = tokenCounters2;
                                    androidBuildHeaderBiddingToken$invoke$1.L$2 = dsl8;
                                    androidBuildHeaderBiddingToken$invoke$1.L$3 = dsl5;
                                    androidBuildHeaderBiddingToken$invoke$1.L$4 = dsl5;
                                    androidBuildHeaderBiddingToken$invoke$1.label = 5;
                                    obj = deviceInfoRepository2.staticDeviceInfo(androidBuildHeaderBiddingToken$invoke$1);
                                    if (obj != coroutine_suspended) {
                                    }
                                }
                            }
                            return coroutine_suspended;
                        }
                        dsl3.setSessionToken(androidBuildHeaderBiddingToken2.sessionRepository.getSessionToken());
                        dsl3.setStaticDeviceInfo(androidBuildHeaderBiddingToken2.deviceInfoRepository.cachedStaticDeviceInfo());
                        invoke = androidBuildHeaderBiddingToken2.testDataInfo.invoke();
                        if (invoke != null) {
                        }
                        TokenCountersKt.Dsl.Companion companion2 = TokenCountersKt.Dsl.INSTANCE;
                        HeaderBiddingTokenOuterClass.TokenCounters.Builder newBuilder2 = HeaderBiddingTokenOuterClass.TokenCounters.newBuilder();
                        Intrinsics.checkNotNullExpressionValue(newBuilder2, "newBuilder()");
                        TokenCountersKt.Dsl _create2 = companion2._create(newBuilder2);
                        _create2.setSeq(tokenCounters.getSeq());
                        _create2.setWins(tokenCounters.getWins());
                        _create2.setStarts(tokenCounters.getStarts());
                        dsl3.setTokenCounters(_create2._build());
                        return dsl2._build();
                    }
                    if (i2 == 3) {
                        dsl7 = (HeaderBiddingTokenKt.Dsl) androidBuildHeaderBiddingToken$invoke$1.L$4;
                        dsl5 = (HeaderBiddingTokenKt.Dsl) androidBuildHeaderBiddingToken$invoke$1.L$3;
                        dsl6 = (HeaderBiddingTokenKt.Dsl) androidBuildHeaderBiddingToken$invoke$1.L$2;
                        tokenCounters2 = (TokenCounters) androidBuildHeaderBiddingToken$invoke$1.L$1;
                        androidBuildHeaderBiddingToken2 = (AndroidBuildHeaderBiddingToken) androidBuildHeaderBiddingToken$invoke$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        dsl7.setInitializationData((InitializationDataOuterClass.InitializationData) obj);
                        dsl8 = dsl6;
                        DeviceInfoRepository deviceInfoRepository22 = androidBuildHeaderBiddingToken2.deviceInfoRepository;
                        androidBuildHeaderBiddingToken$invoke$1.L$0 = androidBuildHeaderBiddingToken2;
                        androidBuildHeaderBiddingToken$invoke$1.L$1 = tokenCounters2;
                        androidBuildHeaderBiddingToken$invoke$1.L$2 = dsl8;
                        androidBuildHeaderBiddingToken$invoke$1.L$3 = dsl5;
                        androidBuildHeaderBiddingToken$invoke$1.L$4 = dsl5;
                        androidBuildHeaderBiddingToken$invoke$1.label = 5;
                        obj = deviceInfoRepository22.staticDeviceInfo(androidBuildHeaderBiddingToken$invoke$1);
                        if (obj != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i2 != 4) {
                        if (i2 != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        dsl9 = (HeaderBiddingTokenKt.Dsl) androidBuildHeaderBiddingToken$invoke$1.L$4;
                        dsl10 = (HeaderBiddingTokenKt.Dsl) androidBuildHeaderBiddingToken$invoke$1.L$3;
                        dsl8 = (HeaderBiddingTokenKt.Dsl) androidBuildHeaderBiddingToken$invoke$1.L$2;
                        tokenCounters3 = (TokenCounters) androidBuildHeaderBiddingToken$invoke$1.L$1;
                        androidBuildHeaderBiddingToken3 = (AndroidBuildHeaderBiddingToken) androidBuildHeaderBiddingToken$invoke$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        dsl9.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj);
                        androidBuildHeaderBiddingToken2 = androidBuildHeaderBiddingToken3;
                        dsl3 = dsl10;
                        dsl2 = dsl8;
                        tokenCounters = tokenCounters3;
                        invoke = androidBuildHeaderBiddingToken2.testDataInfo.invoke();
                        if (invoke != null) {
                            dsl3.setTestData(invoke);
                        }
                        TokenCountersKt.Dsl.Companion companion22 = TokenCountersKt.Dsl.INSTANCE;
                        HeaderBiddingTokenOuterClass.TokenCounters.Builder newBuilder22 = HeaderBiddingTokenOuterClass.TokenCounters.newBuilder();
                        Intrinsics.checkNotNullExpressionValue(newBuilder22, "newBuilder()");
                        TokenCountersKt.Dsl _create22 = companion22._create(newBuilder22);
                        _create22.setSeq(tokenCounters.getSeq());
                        _create22.setWins(tokenCounters.getWins());
                        _create22.setStarts(tokenCounters.getStarts());
                        dsl3.setTokenCounters(_create22._build());
                        return dsl2._build();
                    }
                    dsl4 = (HeaderBiddingTokenKt.Dsl) androidBuildHeaderBiddingToken$invoke$1.L$4;
                    dsl5 = (HeaderBiddingTokenKt.Dsl) androidBuildHeaderBiddingToken$invoke$1.L$3;
                    dsl6 = (HeaderBiddingTokenKt.Dsl) androidBuildHeaderBiddingToken$invoke$1.L$2;
                    tokenCounters2 = (TokenCounters) androidBuildHeaderBiddingToken$invoke$1.L$1;
                    androidBuildHeaderBiddingToken2 = (AndroidBuildHeaderBiddingToken) androidBuildHeaderBiddingToken$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    dsl4.setLimitedSessionToken((UniversalRequestOuterClass.LimitedSessionToken) obj);
                    dsl8 = dsl6;
                    DeviceInfoRepository deviceInfoRepository222 = androidBuildHeaderBiddingToken2.deviceInfoRepository;
                    androidBuildHeaderBiddingToken$invoke$1.L$0 = androidBuildHeaderBiddingToken2;
                    androidBuildHeaderBiddingToken$invoke$1.L$1 = tokenCounters2;
                    androidBuildHeaderBiddingToken$invoke$1.L$2 = dsl8;
                    androidBuildHeaderBiddingToken$invoke$1.L$3 = dsl5;
                    androidBuildHeaderBiddingToken$invoke$1.L$4 = dsl5;
                    androidBuildHeaderBiddingToken$invoke$1.label = 5;
                    obj = deviceInfoRepository222.staticDeviceInfo(androidBuildHeaderBiddingToken$invoke$1);
                    if (obj != coroutine_suspended) {
                        dsl9 = dsl5;
                        dsl10 = dsl9;
                        tokenCounters3 = tokenCounters2;
                        androidBuildHeaderBiddingToken3 = androidBuildHeaderBiddingToken2;
                        dsl9.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj);
                        androidBuildHeaderBiddingToken2 = androidBuildHeaderBiddingToken3;
                        dsl3 = dsl10;
                        dsl2 = dsl8;
                        tokenCounters = tokenCounters3;
                        invoke = androidBuildHeaderBiddingToken2.testDataInfo.invoke();
                        if (invoke != null) {
                        }
                        TokenCountersKt.Dsl.Companion companion222 = TokenCountersKt.Dsl.INSTANCE;
                        HeaderBiddingTokenOuterClass.TokenCounters.Builder newBuilder222 = HeaderBiddingTokenOuterClass.TokenCounters.newBuilder();
                        Intrinsics.checkNotNullExpressionValue(newBuilder222, "newBuilder()");
                        TokenCountersKt.Dsl _create222 = companion222._create(newBuilder222);
                        _create222.setSeq(tokenCounters.getSeq());
                        _create222.setWins(tokenCounters.getWins());
                        _create222.setStarts(tokenCounters.getStarts());
                        dsl3.setTokenCounters(_create222._build());
                        return dsl2._build();
                    }
                    return coroutine_suspended;
                }
                boolean z3 = androidBuildHeaderBiddingToken$invoke$1.Z$0;
                dsl = (HeaderBiddingTokenKt.Dsl) androidBuildHeaderBiddingToken$invoke$1.L$6;
                HeaderBiddingTokenKt.Dsl dsl12 = (HeaderBiddingTokenKt.Dsl) androidBuildHeaderBiddingToken$invoke$1.L$5;
                dsl2 = (HeaderBiddingTokenKt.Dsl) androidBuildHeaderBiddingToken$invoke$1.L$4;
                byteString = (ByteString) androidBuildHeaderBiddingToken$invoke$1.L$3;
                tokenCounters = (TokenCounters) androidBuildHeaderBiddingToken$invoke$1.L$2;
                tokenConfiguration2 = (TokenConfiguration) androidBuildHeaderBiddingToken$invoke$1.L$1;
                androidBuildHeaderBiddingToken = (AndroidBuildHeaderBiddingToken) androidBuildHeaderBiddingToken$invoke$1.L$0;
                ResultKt.throwOnFailure(obj);
                z2 = z3;
                _create = dsl12;
                dsl.setClientInfo((ClientInfoOuterClass.ClientInfo) obj);
                _create.setTimestamps(androidBuildHeaderBiddingToken.getTimestamps.invoke());
                if (tokenConfiguration2 != null) {
                    _create.setAdFormat(AdFormatExtensions.toProtoAdFormat(tokenConfiguration2.getAdFormat()));
                }
                _create.setSessionCounters(androidBuildHeaderBiddingToken.sessionRepository.getSessionCounters());
                _create.setDynamicDeviceInfo(androidBuildHeaderBiddingToken.deviceInfoRepository.getDynamicDeviceInfo());
                piiData = androidBuildHeaderBiddingToken.deviceInfoRepository.getPiiData();
                if (piiData.getAdvertisingId().isEmpty() || !piiData.getOpenAdvertisingTrackingId().isEmpty()) {
                    _create.setPii(piiData);
                }
                _create.setCampaignState(androidBuildHeaderBiddingToken.campaignRepository.getCampaignState());
                tcfString = androidBuildHeaderBiddingToken.tcfRepository.getTcfString();
                if (tcfString != null) {
                    _create.setTcf(ByteStringsKt.toByteStringUtf8(tcfString));
                }
                _create.setScarSignalsCollected(z2);
                OfferwallManager offerwallManager = androidBuildHeaderBiddingToken.offerwallManager;
                androidBuildHeaderBiddingToken$invoke$1.L$0 = androidBuildHeaderBiddingToken;
                androidBuildHeaderBiddingToken$invoke$1.L$1 = tokenCounters;
                androidBuildHeaderBiddingToken$invoke$1.L$2 = byteString;
                androidBuildHeaderBiddingToken$invoke$1.L$3 = dsl2;
                androidBuildHeaderBiddingToken$invoke$1.L$4 = _create;
                androidBuildHeaderBiddingToken$invoke$1.L$5 = _create;
                androidBuildHeaderBiddingToken$invoke$1.L$6 = null;
                androidBuildHeaderBiddingToken$invoke$1.label = 2;
                obj = offerwallManager.isConnected(androidBuildHeaderBiddingToken$invoke$1);
                if (obj != coroutine_suspended) {
                    dsl3 = _create;
                    androidBuildHeaderBiddingToken2 = androidBuildHeaderBiddingToken;
                    byteString2 = byteString;
                    _create.setOfferwallEnabled(((Boolean) obj).booleanValue());
                    if (!byteString2.isEmpty()) {
                    }
                }
                return coroutine_suspended;
            }
        }
        androidBuildHeaderBiddingToken$invoke$1 = new AndroidBuildHeaderBiddingToken$invoke$1(this, continuation);
        obj = androidBuildHeaderBiddingToken$invoke$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = androidBuildHeaderBiddingToken$invoke$1.label;
        if (i2 != 0) {
        }
        dsl.setClientInfo((ClientInfoOuterClass.ClientInfo) obj);
        _create.setTimestamps(androidBuildHeaderBiddingToken.getTimestamps.invoke());
        if (tokenConfiguration2 != null) {
        }
        _create.setSessionCounters(androidBuildHeaderBiddingToken.sessionRepository.getSessionCounters());
        _create.setDynamicDeviceInfo(androidBuildHeaderBiddingToken.deviceInfoRepository.getDynamicDeviceInfo());
        piiData = androidBuildHeaderBiddingToken.deviceInfoRepository.getPiiData();
        if (piiData.getAdvertisingId().isEmpty()) {
        }
        _create.setPii(piiData);
        _create.setCampaignState(androidBuildHeaderBiddingToken.campaignRepository.getCampaignState());
        tcfString = androidBuildHeaderBiddingToken.tcfRepository.getTcfString();
        if (tcfString != null) {
        }
        _create.setScarSignalsCollected(z2);
        OfferwallManager offerwallManager2 = androidBuildHeaderBiddingToken.offerwallManager;
        androidBuildHeaderBiddingToken$invoke$1.L$0 = androidBuildHeaderBiddingToken;
        androidBuildHeaderBiddingToken$invoke$1.L$1 = tokenCounters;
        androidBuildHeaderBiddingToken$invoke$1.L$2 = byteString;
        androidBuildHeaderBiddingToken$invoke$1.L$3 = dsl2;
        androidBuildHeaderBiddingToken$invoke$1.L$4 = _create;
        androidBuildHeaderBiddingToken$invoke$1.L$5 = _create;
        androidBuildHeaderBiddingToken$invoke$1.L$6 = null;
        androidBuildHeaderBiddingToken$invoke$1.label = 2;
        obj = offerwallManager2.isConnected(androidBuildHeaderBiddingToken$invoke$1);
        if (obj != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
