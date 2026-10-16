package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.datasource.FIdExistenceDataSource;
import com.unity3d.ads.core.data.manager.OfferwallManager;
import com.unity3d.ads.core.data.manager.OmidManager;
import com.unity3d.ads.core.data.manager.ScarManager;
import com.unity3d.ads.core.data.repository.MediationRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import gatewayprotocol.v1.ClientInfoKt;
import gatewayprotocol.v1.ClientInfoOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidGetClientInfo.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0010H\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidGetClientInfo;", "Lcom/unity3d/ads/core/domain/GetClientInfo;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "mediationRepository", "Lcom/unity3d/ads/core/data/repository/MediationRepository;", "omidManager", "Lcom/unity3d/ads/core/data/manager/OmidManager;", "scarManager", "Lcom/unity3d/ads/core/data/manager/ScarManager;", "offerwallManager", "Lcom/unity3d/ads/core/data/manager/OfferwallManager;", "fIdExistenceDataSource", "Lcom/unity3d/ads/core/data/datasource/FIdExistenceDataSource;", "(Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/MediationRepository;Lcom/unity3d/ads/core/data/manager/OmidManager;Lcom/unity3d/ads/core/data/manager/ScarManager;Lcom/unity3d/ads/core/data/manager/OfferwallManager;Lcom/unity3d/ads/core/data/datasource/FIdExistenceDataSource;)V", "invoke", "Lgatewayprotocol/v1/ClientInfoOuterClass$ClientInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidGetClientInfo implements GetClientInfo {
    private final FIdExistenceDataSource fIdExistenceDataSource;
    private final MediationRepository mediationRepository;
    private final OfferwallManager offerwallManager;
    private final OmidManager omidManager;
    private final ScarManager scarManager;
    private final SessionRepository sessionRepository;

    public AndroidGetClientInfo(SessionRepository sessionRepository, MediationRepository mediationRepository, OmidManager omidManager, ScarManager scarManager, OfferwallManager offerwallManager, FIdExistenceDataSource fIdExistenceDataSource) {
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(mediationRepository, "mediationRepository");
        Intrinsics.checkNotNullParameter(omidManager, "omidManager");
        Intrinsics.checkNotNullParameter(scarManager, "scarManager");
        Intrinsics.checkNotNullParameter(offerwallManager, "offerwallManager");
        Intrinsics.checkNotNullParameter(fIdExistenceDataSource, "fIdExistenceDataSource");
        this.sessionRepository = sessionRepository;
        this.mediationRepository = mediationRepository;
        this.omidManager = omidManager;
        this.scarManager = scarManager;
        this.offerwallManager = offerwallManager;
        this.fIdExistenceDataSource = fIdExistenceDataSource;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.unity3d.ads.core.domain.GetClientInfo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(Continuation<? super ClientInfoOuterClass.ClientInfo> continuation) {
        AndroidGetClientInfo$invoke$1 androidGetClientInfo$invoke$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        AndroidGetClientInfo androidGetClientInfo;
        ClientInfoKt.Dsl dsl;
        ClientInfoKt.Dsl dsl2;
        String str;
        ClientInfoKt.Dsl dsl3;
        ClientInfoKt.Dsl dsl4;
        AndroidGetClientInfo androidGetClientInfo2;
        String str2;
        if (continuation instanceof AndroidGetClientInfo$invoke$1) {
            androidGetClientInfo$invoke$1 = (AndroidGetClientInfo$invoke$1) continuation;
            if ((androidGetClientInfo$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidGetClientInfo$invoke$1.label -= Integer.MIN_VALUE;
                obj = androidGetClientInfo$invoke$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidGetClientInfo$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ClientInfoKt.Dsl.Companion companion = ClientInfoKt.Dsl.INSTANCE;
                    ClientInfoOuterClass.ClientInfo.Builder newBuilder = ClientInfoOuterClass.ClientInfo.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                    ClientInfoKt.Dsl _create = companion._create(newBuilder);
                    _create.setSdkVersion(41601);
                    _create.setSdkVersionName("4.16.1");
                    String gameId = this.sessionRepository.getGameId();
                    if (gameId != null) {
                        _create.setGameId(gameId);
                    }
                    _create.setTest(this.sessionRepository.isTestModeEnabled());
                    _create.setPlatform(ClientInfoOuterClass.Platform.PLATFORM_ANDROID);
                    _create.setMediationProvider(this.mediationRepository.getMediationProvider().invoke());
                    String name = this.mediationRepository.getName();
                    if (name != null && _create.getMediationProvider() == ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_CUSTOM) {
                        _create.setCustomMediationName(name);
                    }
                    String version = this.mediationRepository.getVersion();
                    if (version != null) {
                        _create.setMediationVersion(version);
                    }
                    ScarManager scarManager = this.scarManager;
                    androidGetClientInfo$invoke$1.L$0 = this;
                    androidGetClientInfo$invoke$1.L$1 = _create;
                    androidGetClientInfo$invoke$1.L$2 = _create;
                    androidGetClientInfo$invoke$1.label = 1;
                    Object version2 = scarManager.getVersion(androidGetClientInfo$invoke$1);
                    if (version2 != coroutine_suspended) {
                        androidGetClientInfo = this;
                        dsl = _create;
                        obj = version2;
                        dsl2 = dsl;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    dsl3 = (ClientInfoKt.Dsl) androidGetClientInfo$invoke$1.L$2;
                    dsl4 = (ClientInfoKt.Dsl) androidGetClientInfo$invoke$1.L$1;
                    androidGetClientInfo2 = (AndroidGetClientInfo) androidGetClientInfo$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str2 = (String) obj;
                    if (str2 != null) {
                        dsl3.setOfferwallVersion(str2);
                    }
                    dsl3.setOmidVersion(androidGetClientInfo2.omidManager.getVersion());
                    dsl3.setOmidPartnerVersion("1");
                    dsl3.setSdkDevelopmentPlatform(!MadeWithUnityDetector.isMadeWithUnity() ? "Unity" : "");
                    dsl3.setIsFidAvailable(androidGetClientInfo2.fIdExistenceDataSource.invoke());
                    return dsl4._build();
                }
                dsl2 = (ClientInfoKt.Dsl) androidGetClientInfo$invoke$1.L$2;
                dsl = (ClientInfoKt.Dsl) androidGetClientInfo$invoke$1.L$1;
                androidGetClientInfo = (AndroidGetClientInfo) androidGetClientInfo$invoke$1.L$0;
                ResultKt.throwOnFailure(obj);
                str = (String) obj;
                if (str != null) {
                    dsl2.setScarVersionName(str);
                }
                OfferwallManager offerwallManager = androidGetClientInfo.offerwallManager;
                androidGetClientInfo$invoke$1.L$0 = androidGetClientInfo;
                androidGetClientInfo$invoke$1.L$1 = dsl;
                androidGetClientInfo$invoke$1.L$2 = dsl2;
                androidGetClientInfo$invoke$1.label = 2;
                obj = offerwallManager.getVersion(androidGetClientInfo$invoke$1);
                if (obj != coroutine_suspended) {
                    dsl3 = dsl2;
                    dsl4 = dsl;
                    androidGetClientInfo2 = androidGetClientInfo;
                    str2 = (String) obj;
                    if (str2 != null) {
                    }
                    dsl3.setOmidVersion(androidGetClientInfo2.omidManager.getVersion());
                    dsl3.setOmidPartnerVersion("1");
                    dsl3.setSdkDevelopmentPlatform(!MadeWithUnityDetector.isMadeWithUnity() ? "Unity" : "");
                    dsl3.setIsFidAvailable(androidGetClientInfo2.fIdExistenceDataSource.invoke());
                    return dsl4._build();
                }
                return coroutine_suspended;
            }
        }
        androidGetClientInfo$invoke$1 = new AndroidGetClientInfo$invoke$1(this, continuation);
        obj = androidGetClientInfo$invoke$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidGetClientInfo$invoke$1.label;
        if (i != 0) {
        }
        str = (String) obj;
        if (str != null) {
        }
        OfferwallManager offerwallManager2 = androidGetClientInfo.offerwallManager;
        androidGetClientInfo$invoke$1.L$0 = androidGetClientInfo;
        androidGetClientInfo$invoke$1.L$1 = dsl;
        androidGetClientInfo$invoke$1.L$2 = dsl2;
        androidGetClientInfo$invoke$1.label = 2;
        obj = offerwallManager2.getVersion(androidGetClientInfo$invoke$1);
        if (obj != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
