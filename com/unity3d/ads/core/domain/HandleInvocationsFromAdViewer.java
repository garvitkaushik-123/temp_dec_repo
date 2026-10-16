package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.adplayer.ExposedFunctionLocation;
import com.unity3d.ads.adplayer.Invocation;
import com.unity3d.ads.core.data.model.AdData;
import com.unity3d.ads.core.data.model.AdDataRefreshToken;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.ImpressionConfig;
import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.attribution.AndroidAttribution;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt;
import com.unity3d.ads.core.domain.offerwall.GetIsOfferwallAdReady;
import com.unity3d.ads.core.domain.offerwall.LoadOfferwallAd;
import com.unity3d.ads.core.domain.om.AndroidOmStartSession;
import com.unity3d.ads.core.domain.om.GetOmData;
import com.unity3d.ads.core.domain.om.IsOMActivated;
import com.unity3d.ads.core.domain.om.OmFinishSession;
import com.unity3d.ads.core.domain.om.OmImpressionOccurred;
import com.unity3d.ads.core.domain.scar.LoadScarAd;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.network.model.RequestType;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: HandleInvocationsFromAdViewer.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002Jc\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000fH\u0086\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/unity3d/ads/core/domain/HandleInvocationsFromAdViewer;", "Lcom/unity3d/services/core/di/IServiceComponent;", "()V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/unity3d/ads/adplayer/Invocation;", "onInvocations", "Lkotlinx/coroutines/flow/SharedFlow;", "adData", "", HandleInvocationsFromAdViewer.KEY_AD_DATA_REFRESH_TOKEN, HandleInvocationsFromAdViewer.KEY_IMPRESSION_CONFIG, "adObject", "Lcom/unity3d/ads/core/data/model/AdObject;", "onSubscription", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/SharedFlow;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/unity3d/ads/core/data/model/AdObject;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class HandleInvocationsFromAdViewer implements IServiceComponent {
    public static final String KEY_AD_DATA = "adData";
    public static final String KEY_AD_DATA_REFRESH_TOKEN = "adDataRefreshToken";
    public static final String KEY_AD_STRING = "adString";
    public static final String KEY_AD_TYPE = "type";
    public static final String KEY_AD_UNIT_ID = "adUnitId";
    public static final String KEY_DOWNLOAD_PRIORITY = "priority";
    public static final String KEY_DOWNLOAD_URL = "url";
    public static final String KEY_IMPRESSION_CONFIG = "impressionConfig";
    public static final String KEY_IS_HEADER_BIDDING = "isHeaderBidding";
    public static final String KEY_LOAD_OPTIONS = "loadOptions";
    public static final String KEY_NATIVE_CONTEXT = "nativeContext";
    public static final String KEY_OMID = "openMeasurement";
    public static final String KEY_OMJS_SERVICE = "serviceFilePath";
    public static final String KEY_OMJS_SESSION = "sessionFilePath";
    public static final String KEY_OM_PARTNER = "partnerName";
    public static final String KEY_OM_PARTNER_VERSION = "partnerVersion";
    public static final String KEY_OM_VERSION = "version";
    public static final String KEY_PACKAGE_NAME = "packageName";
    public static final String KEY_PLACEMENT_ID = "placementId";
    public static final String KEY_PLACEMENT_NAME = "placementName";
    public static final String KEY_PRIVACY_UPDATE_CONTENT = "content";
    public static final String KEY_PRIVACY_UPDATE_VERSION = "version";
    public static final String KEY_QUERY_ID = "queryId";
    public static final String KEY_TRACKING_TOKEN = "trackingToken";
    public static final String KEY_VIDEO_LENGTH = "videoLength";

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    public final Flow<Invocation> invoke(SharedFlow<Invocation> onInvocations, String adData, String adDataRefreshToken, String impressionConfig, final AdObject adObject, Function1<? super Continuation<? super Unit>, ? extends Object> onSubscription) {
        Intrinsics.checkNotNullParameter(onInvocations, "onInvocations");
        Intrinsics.checkNotNullParameter(adData, "adData");
        Intrinsics.checkNotNullParameter(adDataRefreshToken, "adDataRefreshToken");
        Intrinsics.checkNotNullParameter(impressionConfig, "impressionConfig");
        Intrinsics.checkNotNullParameter(adObject, "adObject");
        Intrinsics.checkNotNullParameter(onSubscription, "onSubscription");
        final String m9171constructorimpl = AdData.m9171constructorimpl(adData);
        final String m9185constructorimpl = ImpressionConfig.m9185constructorimpl(impressionConfig);
        final String m9178constructorimpl = AdDataRefreshToken.m9178constructorimpl(adDataRefreshToken);
        return FlowKt.onEach(FlowKt.onSubscription(onInvocations, new HandleInvocationsFromAdViewer$invoke$1(onSubscription, null)), new HandleInvocationsFromAdViewer$invoke$2(MapsKt.mapOf(TuplesKt.to(ExposedFunctionLocation.GET_AD_CONTEXT, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.m9193getAdContextyLuu4LI((AndroidGetAdPlayerContext) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(AndroidGetAdPlayerContext.class)), m9171constructorimpl, m9185constructorimpl, m9178constructorimpl, (IsOMActivated) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(IsOMActivated.class)), adObject);
            }
        }), TuplesKt.to(ExposedFunctionLocation.GET_CONNECTION_TYPE, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.getConnectionType((DeviceInfoRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.GET_DEVICE_VOLUME, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.getDeviceVolume((DeviceInfoRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.GET_DEVICE_MAX_VOLUME, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.getDeviceMaxVolume((DeviceInfoRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.GET_SCREEN_HEIGHT, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$5
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.getScreenHeight((DeviceInfoRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.GET_SCREEN_WIDTH, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$6
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.getScreenWidth((DeviceInfoRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.OPEN_URL, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.openUrl((HandleOpenUrl) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(HandleOpenUrl.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.SET_ORIENTATION, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$8
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.setOrientation(AdObject.this);
            }
        }), TuplesKt.to(ExposedFunctionLocation.SEND_OPERATIVE_EVENT, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.sendOperativeEvent((GetOperativeEventApi) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(GetOperativeEventApi.class)), adObject);
            }
        }), TuplesKt.to(ExposedFunctionLocation.STORAGE_WRITE, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.writeStorage();
            }
        }), TuplesKt.to(ExposedFunctionLocation.STORAGE_READ, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.readStorage();
            }
        }), TuplesKt.to(ExposedFunctionLocation.STORAGE_DELETE, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.deleteStorage();
            }
        }), TuplesKt.to(ExposedFunctionLocation.STORAGE_CLEAR, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.clearStorage();
            }
        }), TuplesKt.to(ExposedFunctionLocation.STORAGE_GET_KEYS, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.getKeysStorage();
            }
        }), TuplesKt.to(ExposedFunctionLocation.STORAGE_GET, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.getStorage();
            }
        }), TuplesKt.to(ExposedFunctionLocation.STORAGE_SET, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.setStorage();
            }
        }), TuplesKt.to(ExposedFunctionLocation.GET_PRIVACY_FSM, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$17
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.getPrivacyFsm((SessionRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(SessionRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.SET_PRIVACY_FSM, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$18
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.setPrivacyFsm((SessionRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(SessionRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.GET_PRIVACY, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$19
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.getPrivacy((SessionRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(SessionRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.SET_PRIVACY, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$20
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.setPrivacy((SessionRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(SessionRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.GET_ALLOWED_PII, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$21
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.getAllowedPii((DeviceInfoRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.SET_ALLOWED_PII, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$22
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.setAllowedPii((DeviceInfoRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.GET_SESSION_TOKEN, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$23
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.getSessionToken((SessionRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(SessionRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.MARK_CAMPAIGN_STATE_SHOWN, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$24
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.markCampaignStateShown((CampaignRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(CampaignRepository.class)), adObject);
            }
        }), TuplesKt.to(ExposedFunctionLocation.REFRESH_AD_DATA, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$25
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.refreshAdData((Refresh) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(Refresh.class)), adObject);
            }
        }), TuplesKt.to(ExposedFunctionLocation.UPDATE_CAMPAIGN_STATE, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$26
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.updateCampaignState((CampaignRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(CampaignRepository.class)), adObject);
            }
        }), TuplesKt.to(ExposedFunctionLocation.UPDATE_TRACKING_TOKEN, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$27
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.updateTrackingToken(AdObject.this);
            }
        }), TuplesKt.to(ExposedFunctionLocation.SEND_PRIVACY_UPDATE_REQUEST, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$28
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.sendPrivacyUpdateRequest((SendPrivacyUpdateRequest) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(SendPrivacyUpdateRequest.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.SEND_DIAGNOSTIC_EVENT, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$29
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.sendDiagnosticEvent((SendDiagnosticEvent) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class)), adObject);
            }
        }), TuplesKt.to(ExposedFunctionLocation.INCREMENT_BANNER_IMPRESSION_COUNT, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$30
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.incrementBannerImpressionCount((SessionRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(SessionRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.DOWNLOAD, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$31
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.download((CacheFile) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(CacheFile.class)), adObject);
            }
        }), TuplesKt.to(ExposedFunctionLocation.IS_FILE_CACHED, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$32
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.isFileCached((GetIsFileCache) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(GetIsFileCache.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.OM_START_SESSION, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$33
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.omStartSession((AndroidOmStartSession) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(AndroidOmStartSession.class)), adObject);
            }
        }), TuplesKt.to(ExposedFunctionLocation.OM_FINISH_SESSION, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$34
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.omFinishSession((OmFinishSession) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(OmFinishSession.class)), adObject);
            }
        }), TuplesKt.to(ExposedFunctionLocation.OM_IMPRESSION, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$35
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.omImpression((OmImpressionOccurred) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(OmImpressionOccurred.class)), adObject);
            }
        }), TuplesKt.to(ExposedFunctionLocation.OM_GET_DATA, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$36
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.omGetData((GetOmData) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(GetOmData.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.IS_ATTRIBUTION_AVAILABLE, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$37
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.isAttributionAvailable((AndroidAttribution) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(AndroidAttribution.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.ATTRIBUTION_REGISTER_VIEW, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$38
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.attributionRegisterView((AndroidAttribution) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(AndroidAttribution.class)), adObject);
            }
        }), TuplesKt.to(ExposedFunctionLocation.ATTRIBUTION_REGISTER_CLICK, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$39
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.attributionRegisterClick((AndroidAttribution) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(AndroidAttribution.class)), adObject);
            }
        }), TuplesKt.to(ExposedFunctionLocation.LOAD_SCAR_AD, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$40
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.loadScarAd((LoadScarAd) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(LoadScarAd.class)), adObject);
            }
        }), TuplesKt.to(ExposedFunctionLocation.SHOW_SCAR_AD, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$41
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.showScarAd();
            }
        }), TuplesKt.to(ExposedFunctionLocation.HEADER_BIDDING_TOKEN_INCREMENT_WINS, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$42
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.hbTokenIncrementWins((SessionRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(SessionRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.HEADER_BIDDING_TOKEN_INCREMENT_STARTS, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$43
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.hbTokenIncrementStarts((SessionRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(SessionRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.HEADER_BIDDING_TOKEN_RESET, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$44
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.hbTokenReset((SessionRepository) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(SessionRepository.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.LOAD_OFFERWALL_AD, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$45
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.loadOfferwallAd((LoadOfferwallAd) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(LoadOfferwallAd.class)), adObject);
            }
        }), TuplesKt.to(ExposedFunctionLocation.SHOW_OFFERWALL_AD, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$46
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.showOfferwallAd();
            }
        }), TuplesKt.to(ExposedFunctionLocation.IS_OFFERWALL_AD_READY, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$47
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.isOfferwallAdReady((GetIsOfferwallAdReady) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(GetIsOfferwallAdReady.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.REQUEST_GET, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$48
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.request(RequestType.GET, (ExecuteAdViewerRequest) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(ExecuteAdViewerRequest.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.REQUEST_POST, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$49
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.request(RequestType.POST, (ExecuteAdViewerRequest) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(ExecuteAdViewerRequest.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.REQUEST_HEAD, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$50
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.request(RequestType.HEAD, (ExecuteAdViewerRequest) HandleInvocationsFromAdViewer.this.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(ExecuteAdViewerRequest.class)));
            }
        }), TuplesKt.to(ExposedFunctionLocation.SET_OPPORTUNITY_TTL, new Function0<ExposedFunction>() { // from class: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$51
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExposedFunction invoke() {
                return CommonAdViewerExposedFunctionsKt.setOpportunityTTL(AdObject.this);
            }
        })), null));
    }
}
