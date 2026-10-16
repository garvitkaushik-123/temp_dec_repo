package com.sourcepoint.cmplibrary.data.network;

import com.ironsource.D5;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.CcpaCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataApiModelExtKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PostChoiceParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PvDataParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PvDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.GetChoiceParamReq;
import com.sourcepoint.cmplibrary.data.network.util.Env;
import com.sourcepoint.cmplibrary.data.network.util.HttpUrlManager;
import com.sourcepoint.cmplibrary.data.network.util.HttpUrlManagerSingleton;
import com.sourcepoint.cmplibrary.data.network.util.ResponseManager;
import com.sourcepoint.cmplibrary.data.network.util.ResponseManagerImplKt;
import com.sourcepoint.cmplibrary.exception.ApiRequestPostfix;
import com.sourcepoint.cmplibrary.exception.Logger;
import com.sourcepoint.cmplibrary.model.ConsentReqKt;
import com.sourcepoint.cmplibrary.model.CustomConsentReq;
import com.sourcepoint.cmplibrary.model.CustomConsentResp;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* compiled from: NetworkClientImpl.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\f2\u0006\u0010\u0014\u001a\u00020\u0018H\u0016J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\f2\u0006\u0010\u0014\u001a\u00020\u001bH\u0016J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\f2\u0006\u0010\u0014\u001a\u00020\u001eH\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\f2\u0006\u0010\u0014\u001a\u00020!H\u0016J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\f2\u0006\u0010\u0014\u001a\u00020%H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\f2\u0006\u0010\u0014\u001a\u00020%H\u0016J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\f2\u0006\u0010\u0014\u001a\u00020%H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/NetworkClientImpl;", "Lcom/sourcepoint/cmplibrary/data/network/NetworkClient;", "httpClient", "Lokhttp3/OkHttpClient;", "urlManager", "Lcom/sourcepoint/cmplibrary/data/network/util/HttpUrlManager;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "responseManager", "Lcom/sourcepoint/cmplibrary/data/network/util/ResponseManager;", "(Lokhttp3/OkHttpClient;Lcom/sourcepoint/cmplibrary/data/network/util/HttpUrlManager;Lcom/sourcepoint/cmplibrary/exception/Logger;Lcom/sourcepoint/cmplibrary/data/network/util/ResponseManager;)V", "deleteCustomConsentTo", "Lcom/sourcepoint/cmplibrary/core/Either;", "Lcom/sourcepoint/cmplibrary/model/CustomConsentResp;", "customConsentReq", "Lcom/sourcepoint/cmplibrary/model/CustomConsentReq;", D5.o, "Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "getChoice", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;", "param", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/GetChoiceParamReq;", "getConsentStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusParamReq;", "getMessages", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesResp;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesParamReq;", "getMetaData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataParamReq;", "postPvData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataParamReq;", "sendCustomConsent", "storeCcpaChoice", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PostChoiceParamReq;", "storeGdprChoice", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "storeUsNatChoice", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
final class NetworkClientImpl implements NetworkClient {
    private final OkHttpClient httpClient;
    private final Logger logger;
    private final ResponseManager responseManager;
    private final HttpUrlManager urlManager;

    public NetworkClientImpl(OkHttpClient httpClient, HttpUrlManager urlManager, Logger logger, ResponseManager responseManager) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(urlManager, "urlManager");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(responseManager, "responseManager");
        this.httpClient = httpClient;
        this.urlManager = urlManager;
        this.logger = logger;
        this.responseManager = responseManager;
    }

    public /* synthetic */ NetworkClientImpl(OkHttpClient okHttpClient, HttpUrlManagerSingleton httpUrlManagerSingleton, Logger logger, ResponseManager responseManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new OkHttpClient() : okHttpClient, (i & 2) != 0 ? HttpUrlManagerSingleton.INSTANCE : httpUrlManagerSingleton, logger, (i & 8) != 0 ? ResponseManagerImplKt.create(ResponseManager.INSTANCE, JsonConverterImplKt.create(JsonConverter.INSTANCE), logger) : responseManager);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<CustomConsentResp> sendCustomConsent(final CustomConsentReq customConsentReq, final Env env) {
        Intrinsics.checkNotNullParameter(customConsentReq, "customConsentReq");
        Intrinsics.checkNotNullParameter(env, "env");
        return FunctionalUtilsKt.check(new Function0<CustomConsentResp>() { // from class: com.sourcepoint.cmplibrary.data.network.NetworkClientImpl$sendCustomConsent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CustomConsentResp invoke() {
                HttpUrlManager httpUrlManager;
                Logger logger;
                OkHttpClient okHttpClient;
                ResponseManager responseManager;
                MediaType mediaType = MediaType.INSTANCE.get(D5.L);
                String bodyRequest = ConsentReqKt.toBodyRequest(CustomConsentReq.this);
                RequestBody create = RequestBody.INSTANCE.create(mediaType, bodyRequest);
                httpUrlManager = this.urlManager;
                HttpUrl sendCustomConsentUrl = httpUrlManager.sendCustomConsentUrl(env);
                logger = this.logger;
                logger.req("CustomConsentReq", sendCustomConsentUrl.getUrl(), "POST", bodyRequest);
                Request build = new Request.Builder().url(sendCustomConsentUrl).post(create).build();
                okHttpClient = this.httpClient;
                Response execute = okHttpClient.newCall(build).execute();
                responseManager = this.responseManager;
                return responseManager.parseCustomConsentRes(execute);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<CustomConsentResp> deleteCustomConsentTo(final CustomConsentReq customConsentReq, final Env env) {
        Intrinsics.checkNotNullParameter(customConsentReq, "customConsentReq");
        Intrinsics.checkNotNullParameter(env, "env");
        return FunctionalUtilsKt.check(new Function0<CustomConsentResp>() { // from class: com.sourcepoint.cmplibrary.data.network.NetworkClientImpl$deleteCustomConsentTo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CustomConsentResp invoke() {
                HttpUrlManager httpUrlManager;
                Logger logger;
                OkHttpClient okHttpClient;
                ResponseManager responseManager;
                MediaType mediaType = MediaType.INSTANCE.get(D5.L);
                String bodyRequestDeleteCustomConsentTo = ConsentReqKt.toBodyRequestDeleteCustomConsentTo(CustomConsentReq.this);
                RequestBody create = RequestBody.INSTANCE.create(mediaType, bodyRequestDeleteCustomConsentTo);
                httpUrlManager = this.urlManager;
                HttpUrl deleteCustomConsentToUrl = httpUrlManager.deleteCustomConsentToUrl(env.getHost(), CustomConsentReq.this);
                logger = this.logger;
                logger.req("DeleteCustomConsentReq", deleteCustomConsentToUrl.getUrl(), "DELETE", bodyRequestDeleteCustomConsentTo);
                Request build = new Request.Builder().url(deleteCustomConsentToUrl).delete(create).build();
                okHttpClient = this.httpClient;
                Response execute = okHttpClient.newCall(build).execute();
                responseManager = this.responseManager;
                return responseManager.parseCustomConsentRes(execute);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<MetaDataResp> getMetaData(final MetaDataParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return FunctionalUtilsKt.check(ApiRequestPostfix.META_DATA, new Function0<MetaDataResp>() { // from class: com.sourcepoint.cmplibrary.data.network.NetworkClientImpl$getMetaData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MetaDataResp invoke() {
                HttpUrlManager httpUrlManager;
                Logger logger;
                OkHttpClient okHttpClient;
                ResponseManager responseManager;
                httpUrlManager = NetworkClientImpl.this.urlManager;
                HttpUrl metaDataUrl = httpUrlManager.getMetaDataUrl(param);
                logger = NetworkClientImpl.this.logger;
                logger.req("getMetaData", metaDataUrl.getUrl(), "GET", MetaDataApiModelExtKt.stringify(param));
                Request build = new Request.Builder().url(metaDataUrl).get().build();
                okHttpClient = NetworkClientImpl.this.httpClient;
                Response execute = okHttpClient.newCall(build).execute();
                responseManager = NetworkClientImpl.this.responseManager;
                return responseManager.parseMetaDataRes(execute);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<ConsentStatusResp> getConsentStatus(final ConsentStatusParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return FunctionalUtilsKt.check(ApiRequestPostfix.CONSENT_STATUS, new Function0<ConsentStatusResp>() { // from class: com.sourcepoint.cmplibrary.data.network.NetworkClientImpl$getConsentStatus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConsentStatusResp invoke() {
                HttpUrlManager httpUrlManager;
                Logger logger;
                Object obj;
                OkHttpClient okHttpClient;
                ResponseManager responseManager;
                httpUrlManager = NetworkClientImpl.this.urlManager;
                HttpUrl consentStatusUrl = httpUrlManager.getConsentStatusUrl(param);
                logger = NetworkClientImpl.this.logger;
                String url = consentStatusUrl.getUrl();
                final ConsentStatusParamReq consentStatusParamReq = param;
                Either check = FunctionalUtilsKt.check(new Function0<String>() { // from class: com.sourcepoint.cmplibrary.data.network.NetworkClientImpl$getConsentStatus$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                        ConsentStatusParamReq consentStatusParamReq2 = ConsentStatusParamReq.this;
                        converter.getSerializersModule();
                        return converter.encodeToString(ConsentStatusParamReq.INSTANCE.serializer(), consentStatusParamReq2);
                    }
                });
                if (check instanceof Either.Right) {
                    obj = ((Either.Right) check).getR();
                } else {
                    if (!(check instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    obj = null;
                }
                String str = (String) obj;
                if (str == null) {
                    str = "";
                }
                logger.req("getConsentStatus", url, "GET", str);
                Request build = new Request.Builder().url(consentStatusUrl).get().build();
                okHttpClient = NetworkClientImpl.this.httpClient;
                Response execute = okHttpClient.newCall(build).execute();
                responseManager = NetworkClientImpl.this.responseManager;
                return responseManager.parseConsentStatusResp(execute);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<MessagesResp> getMessages(final MessagesParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return FunctionalUtilsKt.check(ApiRequestPostfix.MESSAGES, new Function0<MessagesResp>() { // from class: com.sourcepoint.cmplibrary.data.network.NetworkClientImpl$getMessages$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MessagesResp invoke() {
                HttpUrlManager httpUrlManager;
                Logger logger;
                OkHttpClient okHttpClient;
                ResponseManager responseManager;
                httpUrlManager = NetworkClientImpl.this.urlManager;
                HttpUrl messagesUrl = httpUrlManager.getMessagesUrl(param);
                logger = NetworkClientImpl.this.logger;
                logger.req("getMessages", messagesUrl.getUrl(), "GET", param.getBody());
                Request build = new Request.Builder().url(messagesUrl).get().build();
                okHttpClient = NetworkClientImpl.this.httpClient;
                Response execute = okHttpClient.newCall(build).execute();
                responseManager = NetworkClientImpl.this.responseManager;
                return responseManager.parseMessagesResp(execute);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<PvDataResp> postPvData(final PvDataParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return FunctionalUtilsKt.check(ApiRequestPostfix.PV_DATA, new Function0<PvDataResp>() { // from class: com.sourcepoint.cmplibrary.data.network.NetworkClientImpl$postPvData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PvDataResp invoke() {
                HttpUrlManager httpUrlManager;
                Logger logger;
                OkHttpClient okHttpClient;
                ResponseManager responseManager;
                httpUrlManager = NetworkClientImpl.this.urlManager;
                HttpUrl pvDataUrl = httpUrlManager.getPvDataUrl(param.getEnv());
                MediaType mediaType = MediaType.INSTANCE.get(D5.L);
                String jsonObject = param.getBody().toString();
                RequestBody create = RequestBody.INSTANCE.create(mediaType, jsonObject);
                logger = NetworkClientImpl.this.logger;
                logger.req("PvDataRequest - " + param.getCampaignType().name(), pvDataUrl.getUrl(), "POST", jsonObject);
                Request build = new Request.Builder().url(pvDataUrl).post(create).build();
                okHttpClient = NetworkClientImpl.this.httpClient;
                Response execute = okHttpClient.newCall(build).execute();
                responseManager = NetworkClientImpl.this.responseManager;
                return responseManager.parsePvDataResp(execute);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<ChoiceResp> getChoice(final GetChoiceParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return FunctionalUtilsKt.check(ApiRequestPostfix.GET_CHOICE, new Function0<ChoiceResp>() { // from class: com.sourcepoint.cmplibrary.data.network.NetworkClientImpl$getChoice$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ChoiceResp invoke() {
                HttpUrlManager httpUrlManager;
                Logger logger;
                Object obj;
                OkHttpClient okHttpClient;
                ResponseManager responseManager;
                httpUrlManager = NetworkClientImpl.this.urlManager;
                HttpUrl choiceUrl = httpUrlManager.getChoiceUrl(param);
                logger = NetworkClientImpl.this.logger;
                String url = choiceUrl.getUrl();
                final GetChoiceParamReq getChoiceParamReq = param;
                Either check = FunctionalUtilsKt.check(new Function0<String>() { // from class: com.sourcepoint.cmplibrary.data.network.NetworkClientImpl$getChoice$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                        GetChoiceParamReq getChoiceParamReq2 = GetChoiceParamReq.this;
                        converter.getSerializersModule();
                        return converter.encodeToString(GetChoiceParamReq.INSTANCE.serializer(), getChoiceParamReq2);
                    }
                });
                if (check instanceof Either.Right) {
                    obj = ((Either.Right) check).getR();
                } else {
                    if (!(check instanceof Either.Left)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    obj = null;
                }
                String str = (String) obj;
                if (str == null) {
                    str = "";
                }
                logger.req("getChoiceUrl", url, "GET", str);
                Request build = new Request.Builder().url(choiceUrl).get().build();
                okHttpClient = NetworkClientImpl.this.httpClient;
                Response execute = okHttpClient.newCall(build).execute();
                responseManager = NetworkClientImpl.this.responseManager;
                return responseManager.parseGetChoiceResp(execute, param.getChoiceType());
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<GdprCS> storeGdprChoice(final PostChoiceParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return FunctionalUtilsKt.check(ApiRequestPostfix.POST_CHOICE_GDPR, new Function0<GdprCS>() { // from class: com.sourcepoint.cmplibrary.data.network.NetworkClientImpl$storeGdprChoice$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GdprCS invoke() {
                HttpUrlManager httpUrlManager;
                Logger logger;
                OkHttpClient okHttpClient;
                ResponseManager responseManager;
                httpUrlManager = NetworkClientImpl.this.urlManager;
                HttpUrl gdprChoiceUrl = httpUrlManager.getGdprChoiceUrl(param);
                MediaType mediaType = MediaType.INSTANCE.get(D5.L);
                String jsonObject = param.getBody().toString();
                RequestBody create = RequestBody.INSTANCE.create(mediaType, jsonObject);
                logger = NetworkClientImpl.this.logger;
                logger.req("storeGdprChoice", gdprChoiceUrl.getUrl(), "POST", jsonObject);
                Request build = new Request.Builder().url(gdprChoiceUrl).post(create).build();
                okHttpClient = NetworkClientImpl.this.httpClient;
                Response execute = okHttpClient.newCall(build).execute();
                responseManager = NetworkClientImpl.this.responseManager;
                return responseManager.parsePostGdprChoiceResp(execute);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<CcpaCS> storeCcpaChoice(final PostChoiceParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return FunctionalUtilsKt.check(ApiRequestPostfix.POST_CHOICE_CCPA, new Function0<CcpaCS>() { // from class: com.sourcepoint.cmplibrary.data.network.NetworkClientImpl$storeCcpaChoice$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CcpaCS invoke() {
                HttpUrlManager httpUrlManager;
                Logger logger;
                OkHttpClient okHttpClient;
                ResponseManager responseManager;
                httpUrlManager = NetworkClientImpl.this.urlManager;
                HttpUrl ccpaChoiceUrl = httpUrlManager.getCcpaChoiceUrl(param);
                MediaType mediaType = MediaType.INSTANCE.get(D5.L);
                String jsonObject = param.getBody().toString();
                RequestBody create = RequestBody.INSTANCE.create(mediaType, jsonObject);
                logger = NetworkClientImpl.this.logger;
                logger.req("storeCcpaChoice", ccpaChoiceUrl.getUrl(), "POST", jsonObject);
                Request build = new Request.Builder().url(ccpaChoiceUrl).post(create).build();
                okHttpClient = NetworkClientImpl.this.httpClient;
                Response execute = okHttpClient.newCall(build).execute();
                responseManager = NetworkClientImpl.this.responseManager;
                return responseManager.parsePostCcpaChoiceResp(execute);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.NetworkClient
    public Either<USNatConsentData> storeUsNatChoice(final PostChoiceParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return FunctionalUtilsKt.check(ApiRequestPostfix.POST_CHOICE_USNAT, new Function0<USNatConsentData>() { // from class: com.sourcepoint.cmplibrary.data.network.NetworkClientImpl$storeUsNatChoice$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final USNatConsentData invoke() {
                HttpUrlManager httpUrlManager;
                Logger logger;
                OkHttpClient okHttpClient;
                ResponseManager responseManager;
                httpUrlManager = NetworkClientImpl.this.urlManager;
                HttpUrl postUsNatChoiceUrl = httpUrlManager.postUsNatChoiceUrl(param);
                MediaType mediaType = MediaType.INSTANCE.get(D5.L);
                String jsonObject = param.getBody().toString();
                RequestBody create = RequestBody.INSTANCE.create(mediaType, jsonObject);
                logger = NetworkClientImpl.this.logger;
                logger.req("storeUsNatChoice", postUsNatChoiceUrl.getUrl(), "POST", jsonObject);
                Request build = new Request.Builder().url(postUsNatChoiceUrl).post(create).build();
                okHttpClient = NetworkClientImpl.this.httpClient;
                Response execute = okHttpClient.newCall(build).execute();
                responseManager = NetworkClientImpl.this.responseManager;
                return responseManager.parsePostUsNatChoiceResp(execute);
            }
        });
    }
}
