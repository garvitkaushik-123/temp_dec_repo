package com.unity3d.ads.core.domain;

import android.content.Context;
import android.util.Base64;
import com.google.protobuf.ByteString;
import com.ironsource.C3337ue;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.adplayer.AdPlayerScope;
import com.unity3d.ads.adplayer.AndroidWebViewContainer;
import com.unity3d.ads.adplayer.Invocation;
import com.unity3d.ads.adplayer.WebViewBridge;
import com.unity3d.ads.adplayer.model.LoadEvent;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.LoadResult;
import com.unity3d.ads.core.data.model.WebViewConfiguration;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.properties.SdkProperties;
import gatewayprotocol.v1.AdResponseOuterClass;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.OperativeEventErrorDataKt;
import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import java.net.URI;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import org.json.JSONObject;

/* compiled from: AndroidHandleGatewayAdResponse.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ3\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%JI\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0096Bø\u0001\u0000¢\u0006\u0002\u00102R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidHandleGatewayAdResponse;", "Lcom/unity3d/ads/core/domain/HandleGatewayAdResponse;", "adRepository", "Lcom/unity3d/ads/core/data/repository/AdRepository;", "getWebViewContainerUseCase", "Lcom/unity3d/ads/core/domain/AndroidGetWebViewContainerUseCase;", "getWebViewBridge", "Lcom/unity3d/ads/core/domain/GetWebViewBridgeUseCase;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "getHandleInvocationsFromAdViewer", "Lcom/unity3d/ads/core/domain/HandleInvocationsFromAdViewer;", "campaignRepository", "Lcom/unity3d/ads/core/data/repository/CampaignRepository;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "getOperativeEventApi", "Lcom/unity3d/ads/core/domain/events/GetOperativeEventApi;", "getLatestWebViewConfiguration", "Lcom/unity3d/ads/core/domain/GetLatestWebViewConfiguration;", "adPlayerScope", "Lcom/unity3d/ads/adplayer/AdPlayerScope;", "getAdPlayer", "Lcom/unity3d/ads/core/domain/GetAdPlayer;", "cacheWebViewAssets", "Lcom/unity3d/ads/core/domain/CacheWebViewAssets;", "(Lcom/unity3d/ads/core/data/repository/AdRepository;Lcom/unity3d/ads/core/domain/AndroidGetWebViewContainerUseCase;Lcom/unity3d/ads/core/domain/GetWebViewBridgeUseCase;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/domain/HandleInvocationsFromAdViewer;Lcom/unity3d/ads/core/data/repository/CampaignRepository;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;Lcom/unity3d/ads/core/domain/events/GetOperativeEventApi;Lcom/unity3d/ads/core/domain/GetLatestWebViewConfiguration;Lcom/unity3d/ads/adplayer/AdPlayerScope;Lcom/unity3d/ads/core/domain/GetAdPlayer;Lcom/unity3d/ads/core/domain/CacheWebViewAssets;)V", "cleanup", "", "t", "", "opportunityId", "Lcom/google/protobuf/ByteString;", C3337ue.n, "Lgatewayprotocol/v1/AdResponseOuterClass$AdResponse;", "adPlayer", "Lcom/unity3d/ads/adplayer/AdPlayer;", "(Ljava/lang/Throwable;Lcom/google/protobuf/ByteString;Lgatewayprotocol/v1/AdResponseOuterClass$AdResponse;Lcom/unity3d/ads/adplayer/AdPlayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "Lcom/unity3d/ads/core/data/model/LoadResult;", HandleInvocationsFromAdViewer.KEY_LOAD_OPTIONS, "Lcom/unity3d/ads/UnityAdsLoadOptions;", "context", "Landroid/content/Context;", "placementId", "", "adType", "Lgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticAdType;", HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, "", "(Lcom/unity3d/ads/UnityAdsLoadOptions;Lcom/google/protobuf/ByteString;Lgatewayprotocol/v1/AdResponseOuterClass$AdResponse;Landroid/content/Context;Ljava/lang/String;Lgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticAdType;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidHandleGatewayAdResponse implements HandleGatewayAdResponse {
    private final AdPlayerScope adPlayerScope;
    private final AdRepository adRepository;
    private final CacheWebViewAssets cacheWebViewAssets;
    private final CampaignRepository campaignRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetAdPlayer getAdPlayer;
    private final HandleInvocationsFromAdViewer getHandleInvocationsFromAdViewer;
    private final GetLatestWebViewConfiguration getLatestWebViewConfiguration;
    private final GetOperativeEventApi getOperativeEventApi;
    private final GetWebViewBridgeUseCase getWebViewBridge;
    private final AndroidGetWebViewContainerUseCase getWebViewContainerUseCase;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public AndroidHandleGatewayAdResponse(AdRepository adRepository, AndroidGetWebViewContainerUseCase getWebViewContainerUseCase, GetWebViewBridgeUseCase getWebViewBridge, DeviceInfoRepository deviceInfoRepository, HandleInvocationsFromAdViewer getHandleInvocationsFromAdViewer, CampaignRepository campaignRepository, SendDiagnosticEvent sendDiagnosticEvent, GetOperativeEventApi getOperativeEventApi, GetLatestWebViewConfiguration getLatestWebViewConfiguration, AdPlayerScope adPlayerScope, GetAdPlayer getAdPlayer, CacheWebViewAssets cacheWebViewAssets) {
        Intrinsics.checkNotNullParameter(adRepository, "adRepository");
        Intrinsics.checkNotNullParameter(getWebViewContainerUseCase, "getWebViewContainerUseCase");
        Intrinsics.checkNotNullParameter(getWebViewBridge, "getWebViewBridge");
        Intrinsics.checkNotNullParameter(deviceInfoRepository, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(getHandleInvocationsFromAdViewer, "getHandleInvocationsFromAdViewer");
        Intrinsics.checkNotNullParameter(campaignRepository, "campaignRepository");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        Intrinsics.checkNotNullParameter(getOperativeEventApi, "getOperativeEventApi");
        Intrinsics.checkNotNullParameter(getLatestWebViewConfiguration, "getLatestWebViewConfiguration");
        Intrinsics.checkNotNullParameter(adPlayerScope, "adPlayerScope");
        Intrinsics.checkNotNullParameter(getAdPlayer, "getAdPlayer");
        Intrinsics.checkNotNullParameter(cacheWebViewAssets, "cacheWebViewAssets");
        this.adRepository = adRepository;
        this.getWebViewContainerUseCase = getWebViewContainerUseCase;
        this.getWebViewBridge = getWebViewBridge;
        this.deviceInfoRepository = deviceInfoRepository;
        this.getHandleInvocationsFromAdViewer = getHandleInvocationsFromAdViewer;
        this.campaignRepository = campaignRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.getOperativeEventApi = getOperativeEventApi;
        this.getLatestWebViewConfiguration = getLatestWebViewConfiguration;
        this.adPlayerScope = adPlayerScope;
        this.getAdPlayer = getAdPlayer;
        this.cacheWebViewAssets = cacheWebViewAssets;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x05be, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r1, r0, r9) == r3) goto L162;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x022b A[Catch: CancellationException -> 0x00e8, TryCatch #15 {CancellationException -> 0x00e8, blocks: (B:117:0x02ef, B:121:0x00e1, B:123:0x021f, B:125:0x022b, B:127:0x0241, B:131:0x0259, B:134:0x0262, B:137:0x027d, B:145:0x055d, B:133:0x025d), top: B:120:0x00e1, inners: #18 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0241 A[Catch: CancellationException -> 0x00e8, TryCatch #15 {CancellationException -> 0x00e8, blocks: (B:117:0x02ef, B:121:0x00e1, B:123:0x021f, B:125:0x022b, B:127:0x0241, B:131:0x0259, B:134:0x0262, B:137:0x027d, B:145:0x055d, B:133:0x025d), top: B:120:0x00e1, inners: #18 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0462 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0324  */
    /* JADX WARN: Type inference failed for: r4v23, types: [T, com.unity3d.ads.adplayer.AdPlayer] */
    @Override // com.unity3d.ads.core.domain.HandleGatewayAdResponse
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(UnityAdsLoadOptions unityAdsLoadOptions, ByteString byteString, AdResponseOuterClass.AdResponse adResponse, Context context, String str, DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType, boolean z, Continuation<? super LoadResult> continuation) {
        AndroidHandleGatewayAdResponse$invoke$1 androidHandleGatewayAdResponse$invoke$1;
        AndroidHandleGatewayAdResponse$invoke$1 androidHandleGatewayAdResponse$invoke$12;
        ByteString byteString2;
        AdResponseOuterClass.AdResponse adResponse2;
        Ref.ObjectRef objectRef;
        ByteString byteString3;
        AdResponseOuterClass.AdResponse adResponse3;
        AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse;
        UnityAdsLoadOptions unityAdsLoadOptions2;
        DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType2;
        boolean z2;
        ByteString byteString4;
        String str2;
        AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse2;
        WebViewConfiguration webViewConfiguration;
        UnityAdsLoadOptions unityAdsLoadOptions3;
        CacheWebViewAssets cacheWebViewAssets;
        Ref.ObjectRef objectRef2;
        String str3;
        WebViewConfiguration webViewConfiguration2;
        AdObject adObject;
        String str4;
        String base64ImpressionConfiguration;
        long m11706markNowz9LOYto;
        ByteString byteString5;
        UnityAdsLoadOptions unityAdsLoadOptions4;
        AdResponseOuterClass.AdResponse adResponse4;
        Ref.ObjectRef objectRef3;
        String str5;
        Object m10241constructorimpl;
        String str6;
        UnityAdsLoadOptions unityAdsLoadOptions5;
        String str7;
        long m11706markNowz9LOYto2;
        AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse3;
        AdObject adObject2;
        ByteString byteString6;
        AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse4;
        AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse5;
        AdResponseOuterClass.AdResponse adResponse5;
        LoadEvent loadEvent;
        AdResponseOuterClass.AdResponse adResponse6;
        AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse6;
        LoadEvent loadEvent2;
        ByteString byteString7;
        AdObject adObject3;
        JSONObject data;
        CancellationException cancellationException;
        if (continuation instanceof AndroidHandleGatewayAdResponse$invoke$1) {
            androidHandleGatewayAdResponse$invoke$1 = (AndroidHandleGatewayAdResponse$invoke$1) continuation;
            if ((androidHandleGatewayAdResponse$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidHandleGatewayAdResponse$invoke$1.label -= Integer.MIN_VALUE;
                androidHandleGatewayAdResponse$invoke$12 = androidHandleGatewayAdResponse$invoke$1;
                Object obj = androidHandleGatewayAdResponse$invoke$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (androidHandleGatewayAdResponse$invoke$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
                        try {
                        } catch (CancellationException e) {
                            e = e;
                            byteString2 = byteString;
                        }
                        try {
                        } catch (CancellationException e2) {
                            e = e2;
                            adResponse3 = adResponse;
                            androidHandleGatewayAdResponse = this;
                            objectRef = objectRef4;
                            byteString3 = byteString;
                            NonCancellable nonCancellable = NonCancellable.INSTANCE;
                            CancellationException cancellationException2 = e;
                            cancellationException = cancellationException2;
                            AndroidHandleGatewayAdResponse$invoke$5 androidHandleGatewayAdResponse$invoke$5 = new AndroidHandleGatewayAdResponse$invoke$5(androidHandleGatewayAdResponse, cancellationException2, byteString3, adResponse3, objectRef, null);
                            androidHandleGatewayAdResponse$invoke$12.L$0 = cancellationException;
                            androidHandleGatewayAdResponse$invoke$12.L$1 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$2 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$3 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$4 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$5 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$6 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                            androidHandleGatewayAdResponse$invoke$12.label = 6;
                            break;
                        }
                        if (adResponse.hasError()) {
                            return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, LoadResult.MSG_COMMUNICATION_FAILURE, null, "gateway", adResponse.getError().getErrorText(), false, 36, null);
                        }
                        if (adResponse.getAdData().isEmpty()) {
                            return new LoadResult.Failure(UnityAds.UnityAdsLoadError.NO_FILL, LoadResult.MSG_NO_FILL, null, "no_fill", null, false, 52, null);
                        }
                        GetLatestWebViewConfiguration getLatestWebViewConfiguration = this.getLatestWebViewConfiguration;
                        String entryPoint = adResponse.getWebviewConfiguration().getEntryPoint();
                        Integer boxInt = Boxing.boxInt(adResponse.getWebviewConfiguration().getVersion());
                        List<String> additionalFilesList = adResponse.getWebviewConfiguration().getAdditionalFilesList();
                        String type = adResponse.getWebviewConfiguration().getType();
                        androidHandleGatewayAdResponse$invoke$12.L$0 = this;
                        androidHandleGatewayAdResponse$invoke$12.L$1 = unityAdsLoadOptions;
                        byteString2 = byteString;
                        try {
                            androidHandleGatewayAdResponse$invoke$12.L$2 = byteString2;
                            adResponse2 = adResponse;
                            try {
                                androidHandleGatewayAdResponse$invoke$12.L$3 = adResponse2;
                                androidHandleGatewayAdResponse$invoke$12.L$4 = str;
                                androidHandleGatewayAdResponse$invoke$12.L$5 = diagnosticAdType;
                                androidHandleGatewayAdResponse$invoke$12.L$6 = objectRef4;
                                androidHandleGatewayAdResponse$invoke$12.Z$0 = z;
                                androidHandleGatewayAdResponse$invoke$12.label = 1;
                                Object invoke = getLatestWebViewConfiguration.invoke(entryPoint, boxInt, additionalFilesList, type, androidHandleGatewayAdResponse$invoke$12);
                                if (invoke != coroutine_suspended) {
                                    unityAdsLoadOptions2 = unityAdsLoadOptions;
                                    obj = invoke;
                                    diagnosticAdType2 = diagnosticAdType;
                                    z2 = z;
                                    objectRef = objectRef4;
                                    byteString4 = byteString2;
                                    adResponse3 = adResponse2;
                                    str2 = str;
                                    androidHandleGatewayAdResponse2 = this;
                                    try {
                                        webViewConfiguration = (WebViewConfiguration) obj;
                                        ByteString trackingToken = adResponse3.getTrackingToken();
                                        Intrinsics.checkNotNullExpressionValue(trackingToken, "trackingToken");
                                        AdObject adObject4 = new AdObject(byteString4, str2, trackingToken, false, null, null, null, false, null, null, null, unityAdsLoadOptions2, z2, diagnosticAdType2, null, null, 51192, null);
                                        byteString3 = byteString4;
                                        String str8 = str2;
                                        unityAdsLoadOptions3 = unityAdsLoadOptions2;
                                        cacheWebViewAssets = androidHandleGatewayAdResponse2.cacheWebViewAssets;
                                        androidHandleGatewayAdResponse$invoke$12.L$0 = androidHandleGatewayAdResponse2;
                                        androidHandleGatewayAdResponse$invoke$12.L$1 = unityAdsLoadOptions3;
                                        androidHandleGatewayAdResponse$invoke$12.L$2 = byteString3;
                                        androidHandleGatewayAdResponse$invoke$12.L$3 = adResponse3;
                                        androidHandleGatewayAdResponse$invoke$12.L$4 = str8;
                                        androidHandleGatewayAdResponse$invoke$12.L$5 = objectRef;
                                        androidHandleGatewayAdResponse$invoke$12.L$6 = webViewConfiguration;
                                        androidHandleGatewayAdResponse$invoke$12.L$7 = adObject4;
                                        androidHandleGatewayAdResponse$invoke$12.label = 2;
                                        if (cacheWebViewAssets.invoke(webViewConfiguration, androidHandleGatewayAdResponse$invoke$12) != coroutine_suspended) {
                                            objectRef2 = objectRef;
                                            str3 = str8;
                                            webViewConfiguration2 = webViewConfiguration;
                                            adObject = adObject4;
                                            if (webViewConfiguration2.getEntryPoint().length() != 0) {
                                                return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, LoadResult.MSG_COMMUNICATION_FAILURE, null, "no_webview_entry_point", null, false, 52, null);
                                            }
                                            String it = SdkProperties.getConfigUrl();
                                            Intrinsics.checkNotNullExpressionValue(it, "it");
                                            if (!StringsKt.endsWith$default(it, ".html", false, 2, (Object) null)) {
                                                it = null;
                                            }
                                            if (it == null) {
                                                it = webViewConfiguration2.getEntryPoint();
                                            }
                                            try {
                                                URI uri = new URI(it);
                                                StringBuilder append = new StringBuilder("?platform=android&mode=ad-viewer&webviewType=").append(webViewConfiguration2.getType()).append(Typography.amp);
                                                String query = uri.getQuery();
                                                if (query == null) {
                                                    query = "";
                                                }
                                                str4 = StringsKt.substringBeforeLast$default(it, "?", (String) null, 2, (Object) null) + append.append(query).toString();
                                                base64ImpressionConfiguration = Base64.encodeToString(adResponse3.getImpressionConfiguration().toByteArray(), 2);
                                                m11706markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                                                try {
                                                    Result.Companion companion = Result.INSTANCE;
                                                    AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse7 = androidHandleGatewayAdResponse2;
                                                    AndroidGetWebViewContainerUseCase androidGetWebViewContainerUseCase = androidHandleGatewayAdResponse2.getWebViewContainerUseCase;
                                                    AdPlayerScope adPlayerScope = androidHandleGatewayAdResponse2.adPlayerScope;
                                                    androidHandleGatewayAdResponse$invoke$12.L$0 = androidHandleGatewayAdResponse2;
                                                    androidHandleGatewayAdResponse$invoke$12.L$1 = unityAdsLoadOptions3;
                                                    androidHandleGatewayAdResponse$invoke$12.L$2 = byteString3;
                                                    androidHandleGatewayAdResponse$invoke$12.L$3 = adResponse3;
                                                    androidHandleGatewayAdResponse$invoke$12.L$4 = str3;
                                                    androidHandleGatewayAdResponse$invoke$12.L$5 = objectRef2;
                                                    androidHandleGatewayAdResponse$invoke$12.L$6 = adObject;
                                                    androidHandleGatewayAdResponse$invoke$12.L$7 = str4;
                                                    androidHandleGatewayAdResponse$invoke$12.L$8 = base64ImpressionConfiguration;
                                                    androidHandleGatewayAdResponse$invoke$12.J$0 = m11706markNowz9LOYto;
                                                    androidHandleGatewayAdResponse$invoke$12.label = 3;
                                                    obj = androidGetWebViewContainerUseCase.invoke(adPlayerScope, androidHandleGatewayAdResponse$invoke$12);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    Result.Companion companion2 = Result.INSTANCE;
                                                    m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                                                    str6 = str4;
                                                    unityAdsLoadOptions5 = unityAdsLoadOptions3;
                                                    androidHandleGatewayAdResponse = androidHandleGatewayAdResponse2;
                                                    AdObject adObject5 = adObject;
                                                    str7 = str3;
                                                    try {
                                                        TimedValue timedValue = new TimedValue(Result.m10240boximpl(m10241constructorimpl), TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(m11706markNowz9LOYto), null);
                                                        SendDiagnosticEvent.DefaultImpls.invoke$default(androidHandleGatewayAdResponse.sendDiagnosticEvent, !Result.m10248isSuccessimpl(((Result) timedValue.component1()).getValue()) ? "native_webview_success_time" : "native_webview_failure_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(timedValue.getDuration(), DurationUnit.MILLISECONDS)), null, null, adObject5, null, 44, null);
                                                        Object value = ((Result) timedValue.getValue()).getValue();
                                                        ResultKt.throwOnFailure(value);
                                                        AndroidWebViewContainer androidWebViewContainer = (AndroidWebViewContainer) value;
                                                        WebViewBridge invoke2 = androidHandleGatewayAdResponse.getWebViewBridge.invoke(androidWebViewContainer, androidHandleGatewayAdResponse.adPlayerScope);
                                                        objectRef2.element = androidHandleGatewayAdResponse.getAdPlayer.invoke(invoke2, androidWebViewContainer, byteString3);
                                                        AdObject copy$default = AdObject.copy$default(adObject5, null, null, null, false, null, null, null, false, null, (AdPlayer) objectRef2.element, null, null, false, null, null, null, 65023, null);
                                                        FlowKt.launchIn(FlowKt.onEach(androidHandleGatewayAdResponse.deviceInfoRepository.getAllowedPii(), new AndroidHandleGatewayAdResponse$invoke$2(objectRef2, null)), ((AdPlayer) objectRef2.element).getScope());
                                                        m11706markNowz9LOYto2 = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                                                        SendDiagnosticEvent.DefaultImpls.invoke$default(androidHandleGatewayAdResponse.sendDiagnosticEvent, "native_load_started_ad_viewer", null, null, null, copy$default, null, 46, null);
                                                        HandleInvocationsFromAdViewer handleInvocationsFromAdViewer = androidHandleGatewayAdResponse.getHandleInvocationsFromAdViewer;
                                                        SharedFlow<Invocation> onInvocation = invoke2.getOnInvocation();
                                                        ByteString adData = adResponse3.getAdData();
                                                        Intrinsics.checkNotNullExpressionValue(adData, "response.adData");
                                                        String base64$default = ProtobufExtensionsKt.toBase64$default(adData, false, 1, null);
                                                        ByteString adDataRefreshToken = adResponse3.getAdDataRefreshToken();
                                                        Intrinsics.checkNotNullExpressionValue(adDataRefreshToken, "response.adDataRefreshToken");
                                                        androidHandleGatewayAdResponse3 = androidHandleGatewayAdResponse;
                                                    } catch (CancellationException e3) {
                                                        e = e3;
                                                    }
                                                    try {
                                                        String base64$default2 = ProtobufExtensionsKt.toBase64$default(adDataRefreshToken, false, 1, null);
                                                        Intrinsics.checkNotNullExpressionValue(base64ImpressionConfiguration, "base64ImpressionConfiguration");
                                                        androidHandleGatewayAdResponse = androidHandleGatewayAdResponse3;
                                                        FlowKt.launchIn(handleInvocationsFromAdViewer.invoke(onInvocation, base64$default, base64$default2, base64ImpressionConfiguration, copy$default, new AndroidHandleGatewayAdResponse$invoke$3(androidHandleGatewayAdResponse3, androidWebViewContainer, str6, adObject5, null)), ((AdPlayer) objectRef2.element).getScope());
                                                        Flow<LoadEvent> onLoadEvent = ((AdPlayer) objectRef2.element).getOnLoadEvent();
                                                        androidHandleGatewayAdResponse$invoke$12.L$0 = androidHandleGatewayAdResponse;
                                                        androidHandleGatewayAdResponse$invoke$12.L$1 = unityAdsLoadOptions5;
                                                        androidHandleGatewayAdResponse$invoke$12.L$2 = byteString3;
                                                        androidHandleGatewayAdResponse$invoke$12.L$3 = adResponse3;
                                                        androidHandleGatewayAdResponse$invoke$12.L$4 = str7;
                                                        androidHandleGatewayAdResponse$invoke$12.L$5 = objectRef2;
                                                        androidHandleGatewayAdResponse$invoke$12.L$6 = copy$default;
                                                        androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                                                        androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                                                        androidHandleGatewayAdResponse$invoke$12.J$0 = m11706markNowz9LOYto2;
                                                        androidHandleGatewayAdResponse$invoke$12.label = 4;
                                                        obj = FlowKt.single(onLoadEvent, androidHandleGatewayAdResponse$invoke$12);
                                                        if (obj != coroutine_suspended) {
                                                        }
                                                    } catch (CancellationException e4) {
                                                        e = e4;
                                                        androidHandleGatewayAdResponse = androidHandleGatewayAdResponse3;
                                                        objectRef = objectRef2;
                                                        NonCancellable nonCancellable2 = NonCancellable.INSTANCE;
                                                        CancellationException cancellationException22 = e;
                                                        cancellationException = cancellationException22;
                                                        AndroidHandleGatewayAdResponse$invoke$5 androidHandleGatewayAdResponse$invoke$52 = new AndroidHandleGatewayAdResponse$invoke$5(androidHandleGatewayAdResponse, cancellationException22, byteString3, adResponse3, objectRef, null);
                                                        androidHandleGatewayAdResponse$invoke$12.L$0 = cancellationException;
                                                        androidHandleGatewayAdResponse$invoke$12.L$1 = null;
                                                        androidHandleGatewayAdResponse$invoke$12.L$2 = null;
                                                        androidHandleGatewayAdResponse$invoke$12.L$3 = null;
                                                        androidHandleGatewayAdResponse$invoke$12.L$4 = null;
                                                        androidHandleGatewayAdResponse$invoke$12.L$5 = null;
                                                        androidHandleGatewayAdResponse$invoke$12.L$6 = null;
                                                        androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                                                        androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                                                        androidHandleGatewayAdResponse$invoke$12.label = 6;
                                                    }
                                                    return coroutine_suspended;
                                                }
                                                if (obj != coroutine_suspended) {
                                                    byteString5 = byteString3;
                                                    unityAdsLoadOptions4 = unityAdsLoadOptions3;
                                                    androidHandleGatewayAdResponse = androidHandleGatewayAdResponse2;
                                                    adResponse4 = adResponse3;
                                                    objectRef3 = objectRef2;
                                                    str5 = str4;
                                                    m10241constructorimpl = Result.m10241constructorimpl((AndroidWebViewContainer) obj);
                                                    str6 = str5;
                                                    objectRef2 = objectRef3;
                                                    unityAdsLoadOptions5 = unityAdsLoadOptions4;
                                                    adResponse3 = adResponse4;
                                                    byteString3 = byteString5;
                                                    AdObject adObject52 = adObject;
                                                    str7 = str3;
                                                    TimedValue timedValue2 = new TimedValue(Result.m10240boximpl(m10241constructorimpl), TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(m11706markNowz9LOYto), null);
                                                    SendDiagnosticEvent.DefaultImpls.invoke$default(androidHandleGatewayAdResponse.sendDiagnosticEvent, !Result.m10248isSuccessimpl(((Result) timedValue2.component1()).getValue()) ? "native_webview_success_time" : "native_webview_failure_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(timedValue2.getDuration(), DurationUnit.MILLISECONDS)), null, null, adObject52, null, 44, null);
                                                    Object value2 = ((Result) timedValue2.getValue()).getValue();
                                                    ResultKt.throwOnFailure(value2);
                                                    AndroidWebViewContainer androidWebViewContainer2 = (AndroidWebViewContainer) value2;
                                                    WebViewBridge invoke22 = androidHandleGatewayAdResponse.getWebViewBridge.invoke(androidWebViewContainer2, androidHandleGatewayAdResponse.adPlayerScope);
                                                    objectRef2.element = androidHandleGatewayAdResponse.getAdPlayer.invoke(invoke22, androidWebViewContainer2, byteString3);
                                                    AdObject copy$default2 = AdObject.copy$default(adObject52, null, null, null, false, null, null, null, false, null, (AdPlayer) objectRef2.element, null, null, false, null, null, null, 65023, null);
                                                    FlowKt.launchIn(FlowKt.onEach(androidHandleGatewayAdResponse.deviceInfoRepository.getAllowedPii(), new AndroidHandleGatewayAdResponse$invoke$2(objectRef2, null)), ((AdPlayer) objectRef2.element).getScope());
                                                    m11706markNowz9LOYto2 = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                                                    SendDiagnosticEvent.DefaultImpls.invoke$default(androidHandleGatewayAdResponse.sendDiagnosticEvent, "native_load_started_ad_viewer", null, null, null, copy$default2, null, 46, null);
                                                    HandleInvocationsFromAdViewer handleInvocationsFromAdViewer2 = androidHandleGatewayAdResponse.getHandleInvocationsFromAdViewer;
                                                    SharedFlow<Invocation> onInvocation2 = invoke22.getOnInvocation();
                                                    ByteString adData2 = adResponse3.getAdData();
                                                    Intrinsics.checkNotNullExpressionValue(adData2, "response.adData");
                                                    String base64$default3 = ProtobufExtensionsKt.toBase64$default(adData2, false, 1, null);
                                                    ByteString adDataRefreshToken2 = adResponse3.getAdDataRefreshToken();
                                                    Intrinsics.checkNotNullExpressionValue(adDataRefreshToken2, "response.adDataRefreshToken");
                                                    androidHandleGatewayAdResponse3 = androidHandleGatewayAdResponse;
                                                    String base64$default22 = ProtobufExtensionsKt.toBase64$default(adDataRefreshToken2, false, 1, null);
                                                    Intrinsics.checkNotNullExpressionValue(base64ImpressionConfiguration, "base64ImpressionConfiguration");
                                                    androidHandleGatewayAdResponse = androidHandleGatewayAdResponse3;
                                                    FlowKt.launchIn(handleInvocationsFromAdViewer2.invoke(onInvocation2, base64$default3, base64$default22, base64ImpressionConfiguration, copy$default2, new AndroidHandleGatewayAdResponse$invoke$3(androidHandleGatewayAdResponse3, androidWebViewContainer2, str6, adObject52, null)), ((AdPlayer) objectRef2.element).getScope());
                                                    Flow<LoadEvent> onLoadEvent2 = ((AdPlayer) objectRef2.element).getOnLoadEvent();
                                                    androidHandleGatewayAdResponse$invoke$12.L$0 = androidHandleGatewayAdResponse;
                                                    androidHandleGatewayAdResponse$invoke$12.L$1 = unityAdsLoadOptions5;
                                                    androidHandleGatewayAdResponse$invoke$12.L$2 = byteString3;
                                                    androidHandleGatewayAdResponse$invoke$12.L$3 = adResponse3;
                                                    androidHandleGatewayAdResponse$invoke$12.L$4 = str7;
                                                    androidHandleGatewayAdResponse$invoke$12.L$5 = objectRef2;
                                                    androidHandleGatewayAdResponse$invoke$12.L$6 = copy$default2;
                                                    androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                                                    androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                                                    androidHandleGatewayAdResponse$invoke$12.J$0 = m11706markNowz9LOYto2;
                                                    androidHandleGatewayAdResponse$invoke$12.label = 4;
                                                    obj = FlowKt.single(onLoadEvent2, androidHandleGatewayAdResponse$invoke$12);
                                                    if (obj != coroutine_suspended) {
                                                        adObject2 = copy$default2;
                                                        byteString6 = byteString3;
                                                        androidHandleGatewayAdResponse4 = androidHandleGatewayAdResponse;
                                                        UnityAdsLoadOptions unityAdsLoadOptions6 = unityAdsLoadOptions5;
                                                        try {
                                                            loadEvent = (LoadEvent) obj;
                                                            if (!(loadEvent instanceof LoadEvent.Error)) {
                                                                try {
                                                                    SendDiagnosticEvent.DefaultImpls.invoke$default(androidHandleGatewayAdResponse4.sendDiagnosticEvent, "native_create_ad_object_failure_time", Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(m11706markNowz9LOYto2))), null, null, adObject2, null, 44, null);
                                                                    AdObject adObject6 = adObject2;
                                                                    NonCancellable nonCancellable3 = NonCancellable.INSTANCE;
                                                                    AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse8 = androidHandleGatewayAdResponse4;
                                                                    Ref.ObjectRef objectRef5 = objectRef2;
                                                                    AdResponseOuterClass.AdResponse adResponse7 = adResponse3;
                                                                    ByteString byteString8 = byteString6;
                                                                    try {
                                                                        androidHandleGatewayAdResponse6 = androidHandleGatewayAdResponse8;
                                                                        loadEvent2 = loadEvent;
                                                                        adResponse6 = adResponse7;
                                                                        try {
                                                                            AndroidHandleGatewayAdResponse$invoke$4 androidHandleGatewayAdResponse$invoke$4 = new AndroidHandleGatewayAdResponse$invoke$4(androidHandleGatewayAdResponse8, loadEvent, byteString8, adResponse7, objectRef5, null);
                                                                            androidHandleGatewayAdResponse$invoke$12.L$0 = androidHandleGatewayAdResponse6;
                                                                            androidHandleGatewayAdResponse$invoke$12.L$1 = byteString6;
                                                                            androidHandleGatewayAdResponse$invoke$12.L$2 = adResponse6;
                                                                            androidHandleGatewayAdResponse$invoke$12.L$3 = objectRef2;
                                                                            androidHandleGatewayAdResponse$invoke$12.L$4 = adObject6;
                                                                            androidHandleGatewayAdResponse$invoke$12.L$5 = loadEvent2;
                                                                            androidHandleGatewayAdResponse$invoke$12.L$6 = null;
                                                                            androidHandleGatewayAdResponse$invoke$12.label = 5;
                                                                            if (BuildersKt.withContext(nonCancellable3, androidHandleGatewayAdResponse$invoke$4, androidHandleGatewayAdResponse$invoke$12) != coroutine_suspended) {
                                                                                objectRef = objectRef2;
                                                                                byteString7 = byteString6;
                                                                                adObject3 = adObject6;
                                                                                try {
                                                                                    return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, null, "adviewer", ((LoadEvent.Error) loadEvent2).getMessage(), adObject3.isScarAd(), 4, null);
                                                                                } catch (CancellationException e5) {
                                                                                    e = e5;
                                                                                    androidHandleGatewayAdResponse = androidHandleGatewayAdResponse6;
                                                                                    adResponse3 = adResponse6;
                                                                                    byteString3 = byteString7;
                                                                                    NonCancellable nonCancellable22 = NonCancellable.INSTANCE;
                                                                                    CancellationException cancellationException222 = e;
                                                                                    cancellationException = cancellationException222;
                                                                                    AndroidHandleGatewayAdResponse$invoke$5 androidHandleGatewayAdResponse$invoke$522 = new AndroidHandleGatewayAdResponse$invoke$5(androidHandleGatewayAdResponse, cancellationException222, byteString3, adResponse3, objectRef, null);
                                                                                    androidHandleGatewayAdResponse$invoke$12.L$0 = cancellationException;
                                                                                    androidHandleGatewayAdResponse$invoke$12.L$1 = null;
                                                                                    androidHandleGatewayAdResponse$invoke$12.L$2 = null;
                                                                                    androidHandleGatewayAdResponse$invoke$12.L$3 = null;
                                                                                    androidHandleGatewayAdResponse$invoke$12.L$4 = null;
                                                                                    androidHandleGatewayAdResponse$invoke$12.L$5 = null;
                                                                                    androidHandleGatewayAdResponse$invoke$12.L$6 = null;
                                                                                    androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                                                                                    androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                                                                                    androidHandleGatewayAdResponse$invoke$12.label = 6;
                                                                                }
                                                                            }
                                                                        } catch (CancellationException e6) {
                                                                            e = e6;
                                                                            objectRef = objectRef2;
                                                                            androidHandleGatewayAdResponse = androidHandleGatewayAdResponse6;
                                                                            adResponse3 = adResponse6;
                                                                            byteString3 = byteString6;
                                                                            NonCancellable nonCancellable222 = NonCancellable.INSTANCE;
                                                                            CancellationException cancellationException2222 = e;
                                                                            cancellationException = cancellationException2222;
                                                                            AndroidHandleGatewayAdResponse$invoke$5 androidHandleGatewayAdResponse$invoke$5222 = new AndroidHandleGatewayAdResponse$invoke$5(androidHandleGatewayAdResponse, cancellationException2222, byteString3, adResponse3, objectRef, null);
                                                                            androidHandleGatewayAdResponse$invoke$12.L$0 = cancellationException;
                                                                            androidHandleGatewayAdResponse$invoke$12.L$1 = null;
                                                                            androidHandleGatewayAdResponse$invoke$12.L$2 = null;
                                                                            androidHandleGatewayAdResponse$invoke$12.L$3 = null;
                                                                            androidHandleGatewayAdResponse$invoke$12.L$4 = null;
                                                                            androidHandleGatewayAdResponse$invoke$12.L$5 = null;
                                                                            androidHandleGatewayAdResponse$invoke$12.L$6 = null;
                                                                            androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                                                                            androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                                                                            androidHandleGatewayAdResponse$invoke$12.label = 6;
                                                                        }
                                                                    } catch (CancellationException e7) {
                                                                        e = e7;
                                                                        androidHandleGatewayAdResponse6 = androidHandleGatewayAdResponse8;
                                                                        byteString6 = byteString8;
                                                                        adResponse6 = adResponse7;
                                                                        objectRef2 = objectRef5;
                                                                    }
                                                                } catch (CancellationException e8) {
                                                                    e = e8;
                                                                    adResponse6 = adResponse3;
                                                                    androidHandleGatewayAdResponse6 = androidHandleGatewayAdResponse4;
                                                                }
                                                            } else {
                                                                AdResponseOuterClass.AdResponse adResponse8 = adResponse3;
                                                                androidHandleGatewayAdResponse5 = androidHandleGatewayAdResponse4;
                                                                try {
                                                                    adResponse5 = adResponse8;
                                                                } catch (CancellationException e9) {
                                                                    e = e9;
                                                                    adResponse5 = adResponse8;
                                                                }
                                                                try {
                                                                    SendDiagnosticEvent.DefaultImpls.invoke$default(androidHandleGatewayAdResponse5.sendDiagnosticEvent, "native_create_ad_object_success_time", Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(m11706markNowz9LOYto2))), null, null, adObject2, null, 44, null);
                                                                    AdObject adObject7 = adObject2;
                                                                    androidHandleGatewayAdResponse5.campaignRepository.setLoadTimestamp(byteString6);
                                                                    androidHandleGatewayAdResponse5.adRepository.addAd(byteString6, adObject7);
                                                                    String objectId = unityAdsLoadOptions6.getObjectId();
                                                                    if ((objectId == null || StringsKt.isBlank(objectId)) && (data = unityAdsLoadOptions6.getData()) != null && !data.has("adMarkup")) {
                                                                        androidHandleGatewayAdResponse5.adRepository.enqueueOpportunityForPlacement(str7, byteString6);
                                                                    }
                                                                    return new LoadResult.Success(adObject7);
                                                                } catch (CancellationException e10) {
                                                                    e = e10;
                                                                    objectRef = objectRef2;
                                                                    androidHandleGatewayAdResponse = androidHandleGatewayAdResponse5;
                                                                    byteString3 = byteString6;
                                                                    adResponse3 = adResponse5;
                                                                    NonCancellable nonCancellable2222 = NonCancellable.INSTANCE;
                                                                    CancellationException cancellationException22222 = e;
                                                                    cancellationException = cancellationException22222;
                                                                    AndroidHandleGatewayAdResponse$invoke$5 androidHandleGatewayAdResponse$invoke$52222 = new AndroidHandleGatewayAdResponse$invoke$5(androidHandleGatewayAdResponse, cancellationException22222, byteString3, adResponse3, objectRef, null);
                                                                    androidHandleGatewayAdResponse$invoke$12.L$0 = cancellationException;
                                                                    androidHandleGatewayAdResponse$invoke$12.L$1 = null;
                                                                    androidHandleGatewayAdResponse$invoke$12.L$2 = null;
                                                                    androidHandleGatewayAdResponse$invoke$12.L$3 = null;
                                                                    androidHandleGatewayAdResponse$invoke$12.L$4 = null;
                                                                    androidHandleGatewayAdResponse$invoke$12.L$5 = null;
                                                                    androidHandleGatewayAdResponse$invoke$12.L$6 = null;
                                                                    androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                                                                    androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                                                                    androidHandleGatewayAdResponse$invoke$12.label = 6;
                                                                }
                                                            }
                                                        } catch (CancellationException e11) {
                                                            e = e11;
                                                            AdResponseOuterClass.AdResponse adResponse9 = adResponse3;
                                                            androidHandleGatewayAdResponse5 = androidHandleGatewayAdResponse4;
                                                            adResponse5 = adResponse9;
                                                        }
                                                    }
                                                }
                                            } catch (Throwable unused) {
                                                return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, LoadResult.MSG_COMMUNICATION_FAILURE, null, "invalid_url", it, false, 36, null);
                                            }
                                        }
                                    } catch (CancellationException e12) {
                                        e = e12;
                                        byteString3 = byteString4;
                                        androidHandleGatewayAdResponse = androidHandleGatewayAdResponse2;
                                        NonCancellable nonCancellable22222 = NonCancellable.INSTANCE;
                                        CancellationException cancellationException222222 = e;
                                        cancellationException = cancellationException222222;
                                        AndroidHandleGatewayAdResponse$invoke$5 androidHandleGatewayAdResponse$invoke$522222 = new AndroidHandleGatewayAdResponse$invoke$5(androidHandleGatewayAdResponse, cancellationException222222, byteString3, adResponse3, objectRef, null);
                                        androidHandleGatewayAdResponse$invoke$12.L$0 = cancellationException;
                                        androidHandleGatewayAdResponse$invoke$12.L$1 = null;
                                        androidHandleGatewayAdResponse$invoke$12.L$2 = null;
                                        androidHandleGatewayAdResponse$invoke$12.L$3 = null;
                                        androidHandleGatewayAdResponse$invoke$12.L$4 = null;
                                        androidHandleGatewayAdResponse$invoke$12.L$5 = null;
                                        androidHandleGatewayAdResponse$invoke$12.L$6 = null;
                                        androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                                        androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                                        androidHandleGatewayAdResponse$invoke$12.label = 6;
                                    }
                                }
                            } catch (CancellationException e13) {
                                e = e13;
                                objectRef = objectRef4;
                                byteString3 = byteString2;
                                adResponse3 = adResponse2;
                                androidHandleGatewayAdResponse = this;
                                NonCancellable nonCancellable222222 = NonCancellable.INSTANCE;
                                CancellationException cancellationException2222222 = e;
                                cancellationException = cancellationException2222222;
                                AndroidHandleGatewayAdResponse$invoke$5 androidHandleGatewayAdResponse$invoke$5222222 = new AndroidHandleGatewayAdResponse$invoke$5(androidHandleGatewayAdResponse, cancellationException2222222, byteString3, adResponse3, objectRef, null);
                                androidHandleGatewayAdResponse$invoke$12.L$0 = cancellationException;
                                androidHandleGatewayAdResponse$invoke$12.L$1 = null;
                                androidHandleGatewayAdResponse$invoke$12.L$2 = null;
                                androidHandleGatewayAdResponse$invoke$12.L$3 = null;
                                androidHandleGatewayAdResponse$invoke$12.L$4 = null;
                                androidHandleGatewayAdResponse$invoke$12.L$5 = null;
                                androidHandleGatewayAdResponse$invoke$12.L$6 = null;
                                androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                                androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                                androidHandleGatewayAdResponse$invoke$12.label = 6;
                            }
                        } catch (CancellationException e14) {
                            e = e14;
                            adResponse2 = adResponse;
                            objectRef = objectRef4;
                            byteString3 = byteString2;
                            adResponse3 = adResponse2;
                            androidHandleGatewayAdResponse = this;
                            NonCancellable nonCancellable2222222 = NonCancellable.INSTANCE;
                            CancellationException cancellationException22222222 = e;
                            cancellationException = cancellationException22222222;
                            AndroidHandleGatewayAdResponse$invoke$5 androidHandleGatewayAdResponse$invoke$52222222 = new AndroidHandleGatewayAdResponse$invoke$5(androidHandleGatewayAdResponse, cancellationException22222222, byteString3, adResponse3, objectRef, null);
                            androidHandleGatewayAdResponse$invoke$12.L$0 = cancellationException;
                            androidHandleGatewayAdResponse$invoke$12.L$1 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$2 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$3 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$4 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$5 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$6 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                            androidHandleGatewayAdResponse$invoke$12.label = 6;
                        }
                        return coroutine_suspended;
                    case 1:
                        boolean z3 = androidHandleGatewayAdResponse$invoke$12.Z$0;
                        objectRef = (Ref.ObjectRef) androidHandleGatewayAdResponse$invoke$12.L$6;
                        DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType3 = (DiagnosticEventRequestOuterClass.DiagnosticAdType) androidHandleGatewayAdResponse$invoke$12.L$5;
                        String str9 = (String) androidHandleGatewayAdResponse$invoke$12.L$4;
                        adResponse3 = (AdResponseOuterClass.AdResponse) androidHandleGatewayAdResponse$invoke$12.L$3;
                        byteString3 = (ByteString) androidHandleGatewayAdResponse$invoke$12.L$2;
                        UnityAdsLoadOptions unityAdsLoadOptions7 = (UnityAdsLoadOptions) androidHandleGatewayAdResponse$invoke$12.L$1;
                        androidHandleGatewayAdResponse2 = (AndroidHandleGatewayAdResponse) androidHandleGatewayAdResponse$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            z2 = z3;
                            diagnosticAdType2 = diagnosticAdType3;
                            str2 = str9;
                            byteString4 = byteString3;
                            unityAdsLoadOptions2 = unityAdsLoadOptions7;
                            webViewConfiguration = (WebViewConfiguration) obj;
                            ByteString trackingToken2 = adResponse3.getTrackingToken();
                            Intrinsics.checkNotNullExpressionValue(trackingToken2, "trackingToken");
                            AdObject adObject42 = new AdObject(byteString4, str2, trackingToken2, false, null, null, null, false, null, null, null, unityAdsLoadOptions2, z2, diagnosticAdType2, null, null, 51192, null);
                            byteString3 = byteString4;
                            String str82 = str2;
                            unityAdsLoadOptions3 = unityAdsLoadOptions2;
                            cacheWebViewAssets = androidHandleGatewayAdResponse2.cacheWebViewAssets;
                            androidHandleGatewayAdResponse$invoke$12.L$0 = androidHandleGatewayAdResponse2;
                            androidHandleGatewayAdResponse$invoke$12.L$1 = unityAdsLoadOptions3;
                            androidHandleGatewayAdResponse$invoke$12.L$2 = byteString3;
                            androidHandleGatewayAdResponse$invoke$12.L$3 = adResponse3;
                            androidHandleGatewayAdResponse$invoke$12.L$4 = str82;
                            androidHandleGatewayAdResponse$invoke$12.L$5 = objectRef;
                            androidHandleGatewayAdResponse$invoke$12.L$6 = webViewConfiguration;
                            androidHandleGatewayAdResponse$invoke$12.L$7 = adObject42;
                            androidHandleGatewayAdResponse$invoke$12.label = 2;
                            if (cacheWebViewAssets.invoke(webViewConfiguration, androidHandleGatewayAdResponse$invoke$12) != coroutine_suspended) {
                            }
                        } catch (CancellationException e15) {
                            e = e15;
                            androidHandleGatewayAdResponse = androidHandleGatewayAdResponse2;
                            NonCancellable nonCancellable22222222 = NonCancellable.INSTANCE;
                            CancellationException cancellationException222222222 = e;
                            cancellationException = cancellationException222222222;
                            AndroidHandleGatewayAdResponse$invoke$5 androidHandleGatewayAdResponse$invoke$522222222 = new AndroidHandleGatewayAdResponse$invoke$5(androidHandleGatewayAdResponse, cancellationException222222222, byteString3, adResponse3, objectRef, null);
                            androidHandleGatewayAdResponse$invoke$12.L$0 = cancellationException;
                            androidHandleGatewayAdResponse$invoke$12.L$1 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$2 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$3 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$4 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$5 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$6 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                            androidHandleGatewayAdResponse$invoke$12.label = 6;
                            break;
                        }
                        return coroutine_suspended;
                    case 2:
                        AdObject adObject8 = (AdObject) androidHandleGatewayAdResponse$invoke$12.L$7;
                        webViewConfiguration2 = (WebViewConfiguration) androidHandleGatewayAdResponse$invoke$12.L$6;
                        objectRef2 = (Ref.ObjectRef) androidHandleGatewayAdResponse$invoke$12.L$5;
                        String str10 = (String) androidHandleGatewayAdResponse$invoke$12.L$4;
                        adResponse3 = (AdResponseOuterClass.AdResponse) androidHandleGatewayAdResponse$invoke$12.L$3;
                        byteString3 = (ByteString) androidHandleGatewayAdResponse$invoke$12.L$2;
                        unityAdsLoadOptions3 = (UnityAdsLoadOptions) androidHandleGatewayAdResponse$invoke$12.L$1;
                        androidHandleGatewayAdResponse2 = (AndroidHandleGatewayAdResponse) androidHandleGatewayAdResponse$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            str3 = str10;
                            adObject = adObject8;
                            if (webViewConfiguration2.getEntryPoint().length() != 0) {
                            }
                        } catch (CancellationException e16) {
                            e = e16;
                            objectRef = objectRef2;
                            androidHandleGatewayAdResponse = androidHandleGatewayAdResponse2;
                            NonCancellable nonCancellable222222222 = NonCancellable.INSTANCE;
                            CancellationException cancellationException2222222222 = e;
                            cancellationException = cancellationException2222222222;
                            AndroidHandleGatewayAdResponse$invoke$5 androidHandleGatewayAdResponse$invoke$5222222222 = new AndroidHandleGatewayAdResponse$invoke$5(androidHandleGatewayAdResponse, cancellationException2222222222, byteString3, adResponse3, objectRef, null);
                            androidHandleGatewayAdResponse$invoke$12.L$0 = cancellationException;
                            androidHandleGatewayAdResponse$invoke$12.L$1 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$2 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$3 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$4 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$5 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$6 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                            androidHandleGatewayAdResponse$invoke$12.label = 6;
                            break;
                        }
                        break;
                    case 3:
                        m11706markNowz9LOYto = androidHandleGatewayAdResponse$invoke$12.J$0;
                        base64ImpressionConfiguration = (String) androidHandleGatewayAdResponse$invoke$12.L$8;
                        str5 = (String) androidHandleGatewayAdResponse$invoke$12.L$7;
                        adObject = (AdObject) androidHandleGatewayAdResponse$invoke$12.L$6;
                        objectRef3 = (Ref.ObjectRef) androidHandleGatewayAdResponse$invoke$12.L$5;
                        str3 = (String) androidHandleGatewayAdResponse$invoke$12.L$4;
                        adResponse4 = (AdResponseOuterClass.AdResponse) androidHandleGatewayAdResponse$invoke$12.L$3;
                        byteString5 = (ByteString) androidHandleGatewayAdResponse$invoke$12.L$2;
                        unityAdsLoadOptions4 = (UnityAdsLoadOptions) androidHandleGatewayAdResponse$invoke$12.L$1;
                        androidHandleGatewayAdResponse = (AndroidHandleGatewayAdResponse) androidHandleGatewayAdResponse$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            m10241constructorimpl = Result.m10241constructorimpl((AndroidWebViewContainer) obj);
                            str6 = str5;
                            objectRef2 = objectRef3;
                            unityAdsLoadOptions5 = unityAdsLoadOptions4;
                            adResponse3 = adResponse4;
                            byteString3 = byteString5;
                        } catch (Throwable th2) {
                            th = th2;
                            str4 = str5;
                            objectRef2 = objectRef3;
                            adResponse3 = adResponse4;
                            androidHandleGatewayAdResponse2 = androidHandleGatewayAdResponse;
                            unityAdsLoadOptions3 = unityAdsLoadOptions4;
                            byteString3 = byteString5;
                            Result.Companion companion22 = Result.INSTANCE;
                            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                            str6 = str4;
                            unityAdsLoadOptions5 = unityAdsLoadOptions3;
                            androidHandleGatewayAdResponse = androidHandleGatewayAdResponse2;
                            AdObject adObject522 = adObject;
                            str7 = str3;
                            TimedValue timedValue22 = new TimedValue(Result.m10240boximpl(m10241constructorimpl), TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(m11706markNowz9LOYto), null);
                            SendDiagnosticEvent.DefaultImpls.invoke$default(androidHandleGatewayAdResponse.sendDiagnosticEvent, !Result.m10248isSuccessimpl(((Result) timedValue22.component1()).getValue()) ? "native_webview_success_time" : "native_webview_failure_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(timedValue22.getDuration(), DurationUnit.MILLISECONDS)), null, null, adObject522, null, 44, null);
                            Object value22 = ((Result) timedValue22.getValue()).getValue();
                            ResultKt.throwOnFailure(value22);
                            AndroidWebViewContainer androidWebViewContainer22 = (AndroidWebViewContainer) value22;
                            WebViewBridge invoke222 = androidHandleGatewayAdResponse.getWebViewBridge.invoke(androidWebViewContainer22, androidHandleGatewayAdResponse.adPlayerScope);
                            objectRef2.element = androidHandleGatewayAdResponse.getAdPlayer.invoke(invoke222, androidWebViewContainer22, byteString3);
                            AdObject copy$default22 = AdObject.copy$default(adObject522, null, null, null, false, null, null, null, false, null, (AdPlayer) objectRef2.element, null, null, false, null, null, null, 65023, null);
                            FlowKt.launchIn(FlowKt.onEach(androidHandleGatewayAdResponse.deviceInfoRepository.getAllowedPii(), new AndroidHandleGatewayAdResponse$invoke$2(objectRef2, null)), ((AdPlayer) objectRef2.element).getScope());
                            m11706markNowz9LOYto2 = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                            SendDiagnosticEvent.DefaultImpls.invoke$default(androidHandleGatewayAdResponse.sendDiagnosticEvent, "native_load_started_ad_viewer", null, null, null, copy$default22, null, 46, null);
                            HandleInvocationsFromAdViewer handleInvocationsFromAdViewer22 = androidHandleGatewayAdResponse.getHandleInvocationsFromAdViewer;
                            SharedFlow<Invocation> onInvocation22 = invoke222.getOnInvocation();
                            ByteString adData22 = adResponse3.getAdData();
                            Intrinsics.checkNotNullExpressionValue(adData22, "response.adData");
                            String base64$default32 = ProtobufExtensionsKt.toBase64$default(adData22, false, 1, null);
                            ByteString adDataRefreshToken22 = adResponse3.getAdDataRefreshToken();
                            Intrinsics.checkNotNullExpressionValue(adDataRefreshToken22, "response.adDataRefreshToken");
                            androidHandleGatewayAdResponse3 = androidHandleGatewayAdResponse;
                            String base64$default222 = ProtobufExtensionsKt.toBase64$default(adDataRefreshToken22, false, 1, null);
                            Intrinsics.checkNotNullExpressionValue(base64ImpressionConfiguration, "base64ImpressionConfiguration");
                            androidHandleGatewayAdResponse = androidHandleGatewayAdResponse3;
                            FlowKt.launchIn(handleInvocationsFromAdViewer22.invoke(onInvocation22, base64$default32, base64$default222, base64ImpressionConfiguration, copy$default22, new AndroidHandleGatewayAdResponse$invoke$3(androidHandleGatewayAdResponse3, androidWebViewContainer22, str6, adObject522, null)), ((AdPlayer) objectRef2.element).getScope());
                            Flow<LoadEvent> onLoadEvent22 = ((AdPlayer) objectRef2.element).getOnLoadEvent();
                            androidHandleGatewayAdResponse$invoke$12.L$0 = androidHandleGatewayAdResponse;
                            androidHandleGatewayAdResponse$invoke$12.L$1 = unityAdsLoadOptions5;
                            androidHandleGatewayAdResponse$invoke$12.L$2 = byteString3;
                            androidHandleGatewayAdResponse$invoke$12.L$3 = adResponse3;
                            androidHandleGatewayAdResponse$invoke$12.L$4 = str7;
                            androidHandleGatewayAdResponse$invoke$12.L$5 = objectRef2;
                            androidHandleGatewayAdResponse$invoke$12.L$6 = copy$default22;
                            androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                            androidHandleGatewayAdResponse$invoke$12.J$0 = m11706markNowz9LOYto2;
                            androidHandleGatewayAdResponse$invoke$12.label = 4;
                            obj = FlowKt.single(onLoadEvent22, androidHandleGatewayAdResponse$invoke$12);
                            if (obj != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                        AdObject adObject5222 = adObject;
                        str7 = str3;
                        TimedValue timedValue222 = new TimedValue(Result.m10240boximpl(m10241constructorimpl), TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(m11706markNowz9LOYto), null);
                        SendDiagnosticEvent.DefaultImpls.invoke$default(androidHandleGatewayAdResponse.sendDiagnosticEvent, !Result.m10248isSuccessimpl(((Result) timedValue222.component1()).getValue()) ? "native_webview_success_time" : "native_webview_failure_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(timedValue222.getDuration(), DurationUnit.MILLISECONDS)), null, null, adObject5222, null, 44, null);
                        Object value222 = ((Result) timedValue222.getValue()).getValue();
                        ResultKt.throwOnFailure(value222);
                        AndroidWebViewContainer androidWebViewContainer222 = (AndroidWebViewContainer) value222;
                        WebViewBridge invoke2222 = androidHandleGatewayAdResponse.getWebViewBridge.invoke(androidWebViewContainer222, androidHandleGatewayAdResponse.adPlayerScope);
                        objectRef2.element = androidHandleGatewayAdResponse.getAdPlayer.invoke(invoke2222, androidWebViewContainer222, byteString3);
                        AdObject copy$default222 = AdObject.copy$default(adObject5222, null, null, null, false, null, null, null, false, null, (AdPlayer) objectRef2.element, null, null, false, null, null, null, 65023, null);
                        FlowKt.launchIn(FlowKt.onEach(androidHandleGatewayAdResponse.deviceInfoRepository.getAllowedPii(), new AndroidHandleGatewayAdResponse$invoke$2(objectRef2, null)), ((AdPlayer) objectRef2.element).getScope());
                        m11706markNowz9LOYto2 = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                        SendDiagnosticEvent.DefaultImpls.invoke$default(androidHandleGatewayAdResponse.sendDiagnosticEvent, "native_load_started_ad_viewer", null, null, null, copy$default222, null, 46, null);
                        HandleInvocationsFromAdViewer handleInvocationsFromAdViewer222 = androidHandleGatewayAdResponse.getHandleInvocationsFromAdViewer;
                        SharedFlow<Invocation> onInvocation222 = invoke2222.getOnInvocation();
                        ByteString adData222 = adResponse3.getAdData();
                        Intrinsics.checkNotNullExpressionValue(adData222, "response.adData");
                        String base64$default322 = ProtobufExtensionsKt.toBase64$default(adData222, false, 1, null);
                        ByteString adDataRefreshToken222 = adResponse3.getAdDataRefreshToken();
                        Intrinsics.checkNotNullExpressionValue(adDataRefreshToken222, "response.adDataRefreshToken");
                        androidHandleGatewayAdResponse3 = androidHandleGatewayAdResponse;
                        String base64$default2222 = ProtobufExtensionsKt.toBase64$default(adDataRefreshToken222, false, 1, null);
                        Intrinsics.checkNotNullExpressionValue(base64ImpressionConfiguration, "base64ImpressionConfiguration");
                        androidHandleGatewayAdResponse = androidHandleGatewayAdResponse3;
                        FlowKt.launchIn(handleInvocationsFromAdViewer222.invoke(onInvocation222, base64$default322, base64$default2222, base64ImpressionConfiguration, copy$default222, new AndroidHandleGatewayAdResponse$invoke$3(androidHandleGatewayAdResponse3, androidWebViewContainer222, str6, adObject5222, null)), ((AdPlayer) objectRef2.element).getScope());
                        Flow<LoadEvent> onLoadEvent222 = ((AdPlayer) objectRef2.element).getOnLoadEvent();
                        androidHandleGatewayAdResponse$invoke$12.L$0 = androidHandleGatewayAdResponse;
                        androidHandleGatewayAdResponse$invoke$12.L$1 = unityAdsLoadOptions5;
                        androidHandleGatewayAdResponse$invoke$12.L$2 = byteString3;
                        androidHandleGatewayAdResponse$invoke$12.L$3 = adResponse3;
                        androidHandleGatewayAdResponse$invoke$12.L$4 = str7;
                        androidHandleGatewayAdResponse$invoke$12.L$5 = objectRef2;
                        androidHandleGatewayAdResponse$invoke$12.L$6 = copy$default222;
                        androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                        androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                        androidHandleGatewayAdResponse$invoke$12.J$0 = m11706markNowz9LOYto2;
                        androidHandleGatewayAdResponse$invoke$12.label = 4;
                        obj = FlowKt.single(onLoadEvent222, androidHandleGatewayAdResponse$invoke$12);
                        if (obj != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 4:
                        m11706markNowz9LOYto2 = androidHandleGatewayAdResponse$invoke$12.J$0;
                        AdObject adObject9 = (AdObject) androidHandleGatewayAdResponse$invoke$12.L$6;
                        objectRef2 = (Ref.ObjectRef) androidHandleGatewayAdResponse$invoke$12.L$5;
                        str7 = (String) androidHandleGatewayAdResponse$invoke$12.L$4;
                        adResponse3 = (AdResponseOuterClass.AdResponse) androidHandleGatewayAdResponse$invoke$12.L$3;
                        byteString6 = (ByteString) androidHandleGatewayAdResponse$invoke$12.L$2;
                        unityAdsLoadOptions5 = (UnityAdsLoadOptions) androidHandleGatewayAdResponse$invoke$12.L$1;
                        AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse9 = (AndroidHandleGatewayAdResponse) androidHandleGatewayAdResponse$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            adObject2 = adObject9;
                            androidHandleGatewayAdResponse4 = androidHandleGatewayAdResponse9;
                            UnityAdsLoadOptions unityAdsLoadOptions62 = unityAdsLoadOptions5;
                            loadEvent = (LoadEvent) obj;
                            if (!(loadEvent instanceof LoadEvent.Error)) {
                            }
                        } catch (CancellationException e17) {
                            e = e17;
                            objectRef = objectRef2;
                            androidHandleGatewayAdResponse = androidHandleGatewayAdResponse9;
                            byteString3 = byteString6;
                            NonCancellable nonCancellable2222222222 = NonCancellable.INSTANCE;
                            CancellationException cancellationException22222222222 = e;
                            cancellationException = cancellationException22222222222;
                            AndroidHandleGatewayAdResponse$invoke$5 androidHandleGatewayAdResponse$invoke$52222222222 = new AndroidHandleGatewayAdResponse$invoke$5(androidHandleGatewayAdResponse, cancellationException22222222222, byteString3, adResponse3, objectRef, null);
                            androidHandleGatewayAdResponse$invoke$12.L$0 = cancellationException;
                            androidHandleGatewayAdResponse$invoke$12.L$1 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$2 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$3 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$4 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$5 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$6 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                            androidHandleGatewayAdResponse$invoke$12.label = 6;
                            break;
                        }
                        break;
                    case 5:
                        loadEvent2 = (LoadEvent) androidHandleGatewayAdResponse$invoke$12.L$5;
                        adObject3 = (AdObject) androidHandleGatewayAdResponse$invoke$12.L$4;
                        objectRef = (Ref.ObjectRef) androidHandleGatewayAdResponse$invoke$12.L$3;
                        AdResponseOuterClass.AdResponse adResponse10 = (AdResponseOuterClass.AdResponse) androidHandleGatewayAdResponse$invoke$12.L$2;
                        byteString7 = (ByteString) androidHandleGatewayAdResponse$invoke$12.L$1;
                        androidHandleGatewayAdResponse6 = (AndroidHandleGatewayAdResponse) androidHandleGatewayAdResponse$invoke$12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            adResponse6 = adResponse10;
                            return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, null, "adviewer", ((LoadEvent.Error) loadEvent2).getMessage(), adObject3.isScarAd(), 4, null);
                        } catch (CancellationException e18) {
                            e = e18;
                            byteString3 = byteString7;
                            androidHandleGatewayAdResponse = androidHandleGatewayAdResponse6;
                            adResponse3 = adResponse10;
                            NonCancellable nonCancellable22222222222 = NonCancellable.INSTANCE;
                            CancellationException cancellationException222222222222 = e;
                            cancellationException = cancellationException222222222222;
                            AndroidHandleGatewayAdResponse$invoke$5 androidHandleGatewayAdResponse$invoke$522222222222 = new AndroidHandleGatewayAdResponse$invoke$5(androidHandleGatewayAdResponse, cancellationException222222222222, byteString3, adResponse3, objectRef, null);
                            androidHandleGatewayAdResponse$invoke$12.L$0 = cancellationException;
                            androidHandleGatewayAdResponse$invoke$12.L$1 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$2 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$3 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$4 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$5 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$6 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$7 = null;
                            androidHandleGatewayAdResponse$invoke$12.L$8 = null;
                            androidHandleGatewayAdResponse$invoke$12.label = 6;
                            break;
                        }
                    case 6:
                        cancellationException = (CancellationException) androidHandleGatewayAdResponse$invoke$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        Throwable cause = cancellationException.getCause();
                        if (cause == null) {
                            throw cancellationException;
                        }
                        throw cause;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        androidHandleGatewayAdResponse$invoke$1 = new AndroidHandleGatewayAdResponse$invoke$1(this, continuation);
        androidHandleGatewayAdResponse$invoke$12 = androidHandleGatewayAdResponse$invoke$1;
        Object obj2 = androidHandleGatewayAdResponse$invoke$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (androidHandleGatewayAdResponse$invoke$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a8, code lost:
    
        if (r14.destroy(r9) == r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00aa, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009a, code lost:
    
        if (com.unity3d.ads.core.domain.events.GetOperativeEventApi.invoke$default(r2, r0, r15, r5, r6, null, null, r9, 48, null) == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object cleanup(Throwable th, ByteString byteString, AdResponseOuterClass.AdResponse adResponse, AdPlayer adPlayer, Continuation<? super Unit> continuation) {
        AndroidHandleGatewayAdResponse$cleanup$1 androidHandleGatewayAdResponse$cleanup$1;
        int i;
        String message;
        AdPlayer adPlayer2;
        if (continuation instanceof AndroidHandleGatewayAdResponse$cleanup$1) {
            androidHandleGatewayAdResponse$cleanup$1 = (AndroidHandleGatewayAdResponse$cleanup$1) continuation;
            if ((androidHandleGatewayAdResponse$cleanup$1.label & Integer.MIN_VALUE) != 0) {
                androidHandleGatewayAdResponse$cleanup$1.label -= Integer.MIN_VALUE;
                AndroidHandleGatewayAdResponse$cleanup$1 androidHandleGatewayAdResponse$cleanup$12 = androidHandleGatewayAdResponse$cleanup$1;
                Object obj = androidHandleGatewayAdResponse$cleanup$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidHandleGatewayAdResponse$cleanup$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    OperativeEventErrorDataKt.Dsl.Companion companion = OperativeEventErrorDataKt.Dsl.INSTANCE;
                    OperativeEventRequestOuterClass.OperativeEventErrorData.Builder newBuilder = OperativeEventRequestOuterClass.OperativeEventErrorData.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                    OperativeEventErrorDataKt.Dsl _create = companion._create(newBuilder);
                    _create.setErrorType(OperativeEventRequestOuterClass.OperativeEventErrorType.OPERATIVE_EVENT_ERROR_TYPE_UNSPECIFIED);
                    Throwable cause = th.getCause();
                    if ((cause == null || (message = cause.getMessage()) == null) && (message = th.getMessage()) == null) {
                        message = "";
                    }
                    _create.setMessage(message);
                    OperativeEventRequestOuterClass.OperativeEventErrorData _build = _create._build();
                    GetOperativeEventApi getOperativeEventApi = this.getOperativeEventApi;
                    OperativeEventRequestOuterClass.OperativeEventType operativeEventType = OperativeEventRequestOuterClass.OperativeEventType.OPERATIVE_EVENT_TYPE_LOAD_ERROR;
                    ByteString trackingToken = adResponse.getTrackingToken();
                    Intrinsics.checkNotNullExpressionValue(trackingToken, "response.trackingToken");
                    ByteString byteString2 = _build.toByteString();
                    Intrinsics.checkNotNullExpressionValue(byteString2, "operativeEventErrorData.toByteString()");
                    adPlayer2 = adPlayer;
                    androidHandleGatewayAdResponse$cleanup$12.L$0 = adPlayer2;
                    androidHandleGatewayAdResponse$cleanup$12.label = 1;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    adPlayer2 = (AdPlayer) androidHandleGatewayAdResponse$cleanup$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (adPlayer2 != null) {
                    return Unit.INSTANCE;
                }
                androidHandleGatewayAdResponse$cleanup$12.L$0 = null;
                androidHandleGatewayAdResponse$cleanup$12.label = 2;
            }
        }
        androidHandleGatewayAdResponse$cleanup$1 = new AndroidHandleGatewayAdResponse$cleanup$1(this, continuation);
        AndroidHandleGatewayAdResponse$cleanup$1 androidHandleGatewayAdResponse$cleanup$122 = androidHandleGatewayAdResponse$cleanup$1;
        Object obj2 = androidHandleGatewayAdResponse$cleanup$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidHandleGatewayAdResponse$cleanup$122.label;
        if (i != 0) {
        }
        if (adPlayer2 != null) {
        }
    }
}
