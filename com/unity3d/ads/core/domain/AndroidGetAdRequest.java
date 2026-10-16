package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ByteStringsKt;
import com.unity3d.ads.core.data.datasource.WebviewConfigurationDataSource;
import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.data.repository.TcfRepository;
import com.unity3d.ads.datastore.WebviewConfigurationStore;
import gatewayprotocol.v1.AdRequestKt;
import gatewayprotocol.v1.AdRequestOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import gatewayprotocol.v1.UniversalRequestKt;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidGetAdRequest.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidGetAdRequest;", "Lcom/unity3d/ads/core/domain/GetAdRequest;", "getUniversalRequestForPayLoad", "Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "campaignRepository", "Lcom/unity3d/ads/core/data/repository/CampaignRepository;", "webViewConfigurationDataSource", "Lcom/unity3d/ads/core/data/datasource/WebviewConfigurationDataSource;", "tcfRepository", "Lcom/unity3d/ads/core/data/repository/TcfRepository;", "(Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/CampaignRepository;Lcom/unity3d/ads/core/data/datasource/WebviewConfigurationDataSource;Lcom/unity3d/ads/core/data/repository/TcfRepository;)V", "invoke", "Lgatewayprotocol/v1/UniversalRequestOuterClass$UniversalRequest;", "placement", "", "impressionOpportunity", "Lcom/google/protobuf/ByteString;", ContentDisposition.Parameters.Size, "Lgatewayprotocol/v1/AdRequestOuterClass$BannerSize;", "(Ljava/lang/String;Lcom/google/protobuf/ByteString;Lgatewayprotocol/v1/AdRequestOuterClass$BannerSize;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidGetAdRequest implements GetAdRequest {
    private final CampaignRepository campaignRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;
    private final SessionRepository sessionRepository;
    private final TcfRepository tcfRepository;
    private final WebviewConfigurationDataSource webViewConfigurationDataSource;

    public AndroidGetAdRequest(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, SessionRepository sessionRepository, DeviceInfoRepository deviceInfoRepository, CampaignRepository campaignRepository, WebviewConfigurationDataSource webViewConfigurationDataSource, TcfRepository tcfRepository) {
        Intrinsics.checkNotNullParameter(getUniversalRequestForPayLoad, "getUniversalRequestForPayLoad");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(deviceInfoRepository, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(campaignRepository, "campaignRepository");
        Intrinsics.checkNotNullParameter(webViewConfigurationDataSource, "webViewConfigurationDataSource");
        Intrinsics.checkNotNullParameter(tcfRepository, "tcfRepository");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad;
        this.sessionRepository = sessionRepository;
        this.deviceInfoRepository = deviceInfoRepository;
        this.campaignRepository = campaignRepository;
        this.webViewConfigurationDataSource = webViewConfigurationDataSource;
        this.tcfRepository = tcfRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x014f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    @Override // com.unity3d.ads.core.domain.GetAdRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(String str, ByteString byteString, AdRequestOuterClass.BannerSize bannerSize, Continuation<? super UniversalRequestOuterClass.UniversalRequest> continuation) {
        AndroidGetAdRequest$invoke$1 androidGetAdRequest$invoke$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        AdRequestKt.Dsl _create;
        ByteString byteString2;
        AdRequestOuterClass.BannerSize bannerSize2;
        AndroidGetAdRequest androidGetAdRequest;
        AdRequestKt.Dsl dsl;
        String str2;
        AdRequestKt.Dsl dsl2;
        AdRequestKt.Dsl dsl3;
        AdRequestKt.Dsl dsl4;
        AdRequestOuterClass.BannerSize bannerSize3;
        AdRequestKt.Dsl dsl5;
        AndroidGetAdRequest androidGetAdRequest2;
        String tcfString;
        if (continuation instanceof AndroidGetAdRequest$invoke$1) {
            androidGetAdRequest$invoke$1 = (AndroidGetAdRequest$invoke$1) continuation;
            if ((androidGetAdRequest$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidGetAdRequest$invoke$1.label -= Integer.MIN_VALUE;
                obj = androidGetAdRequest$invoke$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidGetAdRequest$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AdRequestKt.Dsl.Companion companion = AdRequestKt.Dsl.INSTANCE;
                    AdRequestOuterClass.AdRequest.Builder newBuilder = AdRequestOuterClass.AdRequest.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                    _create = companion._create(newBuilder);
                    _create.setSessionCounters(this.sessionRepository.getSessionCounters());
                    DeviceInfoRepository deviceInfoRepository = this.deviceInfoRepository;
                    androidGetAdRequest$invoke$1.L$0 = this;
                    androidGetAdRequest$invoke$1.L$1 = str;
                    byteString2 = byteString;
                    androidGetAdRequest$invoke$1.L$2 = byteString2;
                    bannerSize2 = bannerSize;
                    androidGetAdRequest$invoke$1.L$3 = bannerSize2;
                    androidGetAdRequest$invoke$1.L$4 = _create;
                    androidGetAdRequest$invoke$1.L$5 = _create;
                    androidGetAdRequest$invoke$1.L$6 = _create;
                    androidGetAdRequest$invoke$1.label = 1;
                    obj = deviceInfoRepository.staticDeviceInfo(androidGetAdRequest$invoke$1);
                    if (obj != coroutine_suspended) {
                        androidGetAdRequest = this;
                        dsl = _create;
                        str2 = str;
                        dsl2 = dsl;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    dsl3 = (AdRequestKt.Dsl) androidGetAdRequest$invoke$1.L$4;
                    dsl4 = (AdRequestKt.Dsl) androidGetAdRequest$invoke$1.L$3;
                    dsl5 = (AdRequestKt.Dsl) androidGetAdRequest$invoke$1.L$2;
                    bannerSize3 = (AdRequestOuterClass.BannerSize) androidGetAdRequest$invoke$1.L$1;
                    androidGetAdRequest2 = (AndroidGetAdRequest) androidGetAdRequest$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    dsl3.setWebviewVersion(((WebviewConfigurationStore.WebViewConfigurationStore) obj).getVersion());
                    dsl4.setCampaignState(androidGetAdRequest2.campaignRepository.getCampaignState());
                    if (bannerSize3 != null) {
                        dsl4.setAdRequestType(AdRequestOuterClass.AdRequestType.AD_REQUEST_TYPE_FULLSCREEN);
                    } else {
                        dsl4.setAdRequestType(AdRequestOuterClass.AdRequestType.AD_REQUEST_TYPE_BANNER);
                        dsl4.setBannerSize(bannerSize3);
                    }
                    tcfString = androidGetAdRequest2.tcfRepository.getTcfString();
                    if (tcfString != null) {
                        dsl4.setTcf(ByteStringsKt.toByteStringUtf8(tcfString));
                    }
                    AdRequestOuterClass.AdRequest _build = dsl5._build();
                    UniversalRequestKt universalRequestKt = UniversalRequestKt.INSTANCE;
                    UniversalRequestKt.PayloadKt.Dsl.Companion companion2 = UniversalRequestKt.PayloadKt.Dsl.INSTANCE;
                    UniversalRequestOuterClass.UniversalRequest.Payload.Builder newBuilder2 = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder2, "newBuilder()");
                    UniversalRequestKt.PayloadKt.Dsl _create2 = companion2._create(newBuilder2);
                    _create2.setAdRequest(_build);
                    UniversalRequestOuterClass.UniversalRequest.Payload _build2 = _create2._build();
                    GetUniversalRequestForPayLoad getUniversalRequestForPayLoad = androidGetAdRequest2.getUniversalRequestForPayLoad;
                    androidGetAdRequest$invoke$1.L$0 = null;
                    androidGetAdRequest$invoke$1.L$1 = null;
                    androidGetAdRequest$invoke$1.L$2 = null;
                    androidGetAdRequest$invoke$1.L$3 = null;
                    androidGetAdRequest$invoke$1.L$4 = null;
                    androidGetAdRequest$invoke$1.label = 3;
                    Object invoke = getUniversalRequestForPayLoad.invoke(_build2, androidGetAdRequest$invoke$1);
                    return invoke != coroutine_suspended ? coroutine_suspended : invoke;
                }
                _create = (AdRequestKt.Dsl) androidGetAdRequest$invoke$1.L$6;
                dsl2 = (AdRequestKt.Dsl) androidGetAdRequest$invoke$1.L$5;
                AdRequestKt.Dsl dsl6 = (AdRequestKt.Dsl) androidGetAdRequest$invoke$1.L$4;
                bannerSize2 = (AdRequestOuterClass.BannerSize) androidGetAdRequest$invoke$1.L$3;
                ByteString byteString3 = (ByteString) androidGetAdRequest$invoke$1.L$2;
                str2 = (String) androidGetAdRequest$invoke$1.L$1;
                androidGetAdRequest = (AndroidGetAdRequest) androidGetAdRequest$invoke$1.L$0;
                ResultKt.throwOnFailure(obj);
                dsl = dsl6;
                byteString2 = byteString3;
                _create.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj);
                dsl2.setDynamicDeviceInfo(androidGetAdRequest.deviceInfoRepository.getDynamicDeviceInfo());
                dsl2.setImpressionOpportunityId(byteString2);
                dsl2.setPlacementId(str2);
                dsl2.setRequestImpressionConfiguration(true);
                WebviewConfigurationDataSource webviewConfigurationDataSource = androidGetAdRequest.webViewConfigurationDataSource;
                androidGetAdRequest$invoke$1.L$0 = androidGetAdRequest;
                androidGetAdRequest$invoke$1.L$1 = bannerSize2;
                androidGetAdRequest$invoke$1.L$2 = dsl;
                androidGetAdRequest$invoke$1.L$3 = dsl2;
                androidGetAdRequest$invoke$1.L$4 = dsl2;
                androidGetAdRequest$invoke$1.L$5 = null;
                androidGetAdRequest$invoke$1.L$6 = null;
                androidGetAdRequest$invoke$1.label = 2;
                obj = webviewConfigurationDataSource.get(androidGetAdRequest$invoke$1);
                if (obj != coroutine_suspended) {
                    dsl3 = dsl2;
                    dsl4 = dsl3;
                    bannerSize3 = bannerSize2;
                    dsl5 = dsl;
                    androidGetAdRequest2 = androidGetAdRequest;
                    dsl3.setWebviewVersion(((WebviewConfigurationStore.WebViewConfigurationStore) obj).getVersion());
                    dsl4.setCampaignState(androidGetAdRequest2.campaignRepository.getCampaignState());
                    if (bannerSize3 != null) {
                    }
                    tcfString = androidGetAdRequest2.tcfRepository.getTcfString();
                    if (tcfString != null) {
                    }
                    AdRequestOuterClass.AdRequest _build3 = dsl5._build();
                    UniversalRequestKt universalRequestKt2 = UniversalRequestKt.INSTANCE;
                    UniversalRequestKt.PayloadKt.Dsl.Companion companion22 = UniversalRequestKt.PayloadKt.Dsl.INSTANCE;
                    UniversalRequestOuterClass.UniversalRequest.Payload.Builder newBuilder22 = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder22, "newBuilder()");
                    UniversalRequestKt.PayloadKt.Dsl _create22 = companion22._create(newBuilder22);
                    _create22.setAdRequest(_build3);
                    UniversalRequestOuterClass.UniversalRequest.Payload _build22 = _create22._build();
                    GetUniversalRequestForPayLoad getUniversalRequestForPayLoad2 = androidGetAdRequest2.getUniversalRequestForPayLoad;
                    androidGetAdRequest$invoke$1.L$0 = null;
                    androidGetAdRequest$invoke$1.L$1 = null;
                    androidGetAdRequest$invoke$1.L$2 = null;
                    androidGetAdRequest$invoke$1.L$3 = null;
                    androidGetAdRequest$invoke$1.L$4 = null;
                    androidGetAdRequest$invoke$1.label = 3;
                    Object invoke2 = getUniversalRequestForPayLoad2.invoke(_build22, androidGetAdRequest$invoke$1);
                    if (invoke2 != coroutine_suspended) {
                    }
                }
            }
        }
        androidGetAdRequest$invoke$1 = new AndroidGetAdRequest$invoke$1(this, continuation);
        obj = androidGetAdRequest$invoke$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidGetAdRequest$invoke$1.label;
        if (i != 0) {
        }
        _create.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) obj);
        dsl2.setDynamicDeviceInfo(androidGetAdRequest.deviceInfoRepository.getDynamicDeviceInfo());
        dsl2.setImpressionOpportunityId(byteString2);
        dsl2.setPlacementId(str2);
        dsl2.setRequestImpressionConfiguration(true);
        WebviewConfigurationDataSource webviewConfigurationDataSource2 = androidGetAdRequest.webViewConfigurationDataSource;
        androidGetAdRequest$invoke$1.L$0 = androidGetAdRequest;
        androidGetAdRequest$invoke$1.L$1 = bannerSize2;
        androidGetAdRequest$invoke$1.L$2 = dsl;
        androidGetAdRequest$invoke$1.L$3 = dsl2;
        androidGetAdRequest$invoke$1.L$4 = dsl2;
        androidGetAdRequest$invoke$1.L$5 = null;
        androidGetAdRequest$invoke$1.L$6 = null;
        androidGetAdRequest$invoke$1.label = 2;
        obj = webviewConfigurationDataSource2.get(androidGetAdRequest$invoke$1);
        if (obj != coroutine_suspended) {
        }
    }
}
