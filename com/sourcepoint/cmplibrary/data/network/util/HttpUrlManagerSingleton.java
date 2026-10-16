package com.sourcepoint.cmplibrary.data.network.util;

import com.google.firebase.messaging.Constants;
import com.ironsource.D5;
import com.ironsource.adapters.inmobi.InMobiAdapter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PostChoiceParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.GetChoiceParamReq;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.CustomConsentReq;
import com.sourcepoint.cmplibrary.model.PMTab;
import com.sourcepoint.cmplibrary.model.PmUrlConfig;
import com.sourcepoint.cmplibrary.model.exposed.MessageType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import okhttp3.HttpUrl;

/* compiled from: HttpUrlManager.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J(\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0002J \u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0002J \u0010'\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/util/HttpUrlManagerSingleton;", "Lcom/sourcepoint/cmplibrary/data/network/util/HttpUrlManager;", "()V", "scriptType", "", "scriptVersion", "deleteCustomConsentToUrl", "Lokhttp3/HttpUrl;", "host", "params", "Lcom/sourcepoint/cmplibrary/model/CustomConsentReq;", "getCcpaChoiceUrl", "param", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PostChoiceParamReq;", "getChoiceUrl", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/GetChoiceParamReq;", "getConsentStatusUrl", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusParamReq;", "getGdprChoiceUrl", "getMessagesUrl", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesParamReq;", "getMetaDataUrl", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataParamReq;", "getPvDataUrl", D5.o, "Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "inAppMessageUrl", "pmUrl", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "pmConfig", "Lcom/sourcepoint/cmplibrary/model/PmUrlConfig;", "messageType", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageType;", "postUsNatChoiceUrl", "sendCustomConsentUrl", "urlPmCcpa", "pmConf", "urlPmGdpr", "urlPmUsNat", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpUrlManagerSingleton implements HttpUrlManager {
    public static final HttpUrlManagerSingleton INSTANCE = new HttpUrlManagerSingleton();
    private static final String scriptType = "android";
    private static final String scriptVersion = "7.10.1";

    /* compiled from: HttpUrlManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CampaignType.values().length];
            try {
                iArr[CampaignType.GDPR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CampaignType.CCPA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CampaignType.USNAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MessageType.values().length];
            try {
                iArr2[MessageType.LEGACY_OTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[MessageType.OTT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[MessageType.MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private HttpUrlManagerSingleton() {
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.HttpUrlManager
    public HttpUrl inAppMessageUrl(Env env) {
        Intrinsics.checkNotNullParameter(env, "env");
        return new HttpUrl.Builder().scheme("https").host(env.getHost()).addPathSegments("wrapper/v2/get_messages").addQueryParameter(D5.o, env.getQueryParam()).build();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.HttpUrlManager
    public HttpUrl pmUrl(Env env, CampaignType campaignType, PmUrlConfig pmConfig, MessageType messageType) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(pmConfig, "pmConfig");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        int i = WhenMappings.$EnumSwitchMapping$0[campaignType.ordinal()];
        if (i == 1) {
            return urlPmGdpr(pmConfig, env, messageType);
        }
        if (i == 2) {
            return urlPmCcpa(pmConfig, env, messageType);
        }
        if (i == 3) {
            return urlPmUsNat(pmConfig, env, messageType);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.HttpUrlManager
    public HttpUrl sendCustomConsentUrl(Env env) {
        Intrinsics.checkNotNullParameter(env, "env");
        return new HttpUrl.Builder().scheme("https").host(env.getHost()).addPathSegments("wrapper/tcfv2/v1/gdpr/custom-consent").addQueryParameter(D5.o, env.getQueryParam()).addQueryParameter("inApp", "true").addQueryParameter("scriptType", "android").addQueryParameter("scriptVersion", "7.10.1").build();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.HttpUrlManager
    public HttpUrl deleteCustomConsentToUrl(String host, CustomConsentReq params) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(params, "params");
        return new HttpUrl.Builder().scheme("https").host(host).addPathSegments("consent/tcfv2/consent/v3/custom/" + params.getPropertyId()).addQueryParameter("consentUUID", params.getConsentUUID()).addQueryParameter("scriptType", "android").addQueryParameter("scriptVersion", "7.10.1").build();
    }

    private final HttpUrl urlPmGdpr(PmUrlConfig pmConf, Env env, MessageType messageType) {
        String str;
        int i = WhenMappings.$EnumSwitchMapping$1[messageType.ordinal()];
        if (i == 1) {
            str = "privacy-manager-ott/index.html";
        } else if (i == 2) {
            str = "native-ott/index.html";
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = "privacy-manager/index.html";
        }
        HttpUrl.Builder addPathSegments = new HttpUrl.Builder().scheme("https").host(env.getPmHostGdpr()).addPathSegments(str);
        PMTab pmTab = pmConf.getPmTab();
        HttpUrl.Builder addQueryParameter = addPathSegments.addQueryParameter("pmTab", pmTab != null ? pmTab.getKey() : null).addQueryParameter("site_id", pmConf.getSiteId()).addQueryParameter("preload_consent", "true");
        String consentLanguage = pmConf.getConsentLanguage();
        if (consentLanguage != null) {
            addQueryParameter.addQueryParameter("consentLanguage", consentLanguage);
        }
        String uuid = pmConf.getUuid();
        if (uuid != null) {
            addQueryParameter.addQueryParameter("consentUUID", uuid);
        }
        String siteId = pmConf.getSiteId();
        if (siteId != null) {
            addQueryParameter.addQueryParameter("site_id", siteId);
        }
        String messageId = pmConf.getMessageId();
        if (messageId != null) {
            addQueryParameter.addQueryParameter(Constants.MessagePayloadKeys.MSGID_SERVER, messageId);
        }
        return addQueryParameter.addQueryParameter("scriptType", "android").addQueryParameter("scriptVersion", "7.10.1").build();
    }

    private final HttpUrl urlPmCcpa(PmUrlConfig pmConf, Env env, MessageType messageType) {
        String str;
        int i = WhenMappings.$EnumSwitchMapping$1[messageType.ordinal()];
        if (i == 1) {
            str = "ccpa_ott/index.html";
        } else if (i == 2) {
            str = "native-ott/index.html";
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = "ccpa_pm/index.html";
        }
        HttpUrl.Builder addQueryParameter = new HttpUrl.Builder().scheme("https").host(env.getPmHostCcpa()).addPathSegments(str).addQueryParameter("site_id", pmConf.getSiteId()).addQueryParameter("preload_consent", "true").addQueryParameter("is_ccpa", "true");
        String consentLanguage = pmConf.getConsentLanguage();
        if (consentLanguage != null) {
            addQueryParameter.addQueryParameter("consentLanguage", consentLanguage);
        }
        String uuid = pmConf.getUuid();
        if (uuid != null) {
            addQueryParameter.addQueryParameter("ccpaUUID", uuid);
        }
        String messageId = pmConf.getMessageId();
        if (messageId != null) {
            addQueryParameter.addQueryParameter(Constants.MessagePayloadKeys.MSGID_SERVER, messageId);
        }
        return addQueryParameter.addQueryParameter("scriptType", "android").addQueryParameter("scriptVersion", "7.10.1").build();
    }

    private final HttpUrl urlPmUsNat(PmUrlConfig pmConf, Env env, MessageType messageType) {
        String str;
        int i = WhenMappings.$EnumSwitchMapping$1[messageType.ordinal()];
        if (i == 1) {
            str = "ccpa_ott/index.html";
        } else if (i == 2) {
            str = "native-ott/index.html";
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = "us_pm/index.html";
        }
        HttpUrl.Builder addQueryParameter = new HttpUrl.Builder().scheme("https").host(env.getPmHostUSNat()).addPathSegments(str).addQueryParameter("site_id", pmConf.getSiteId()).addQueryParameter("preload_consent", "true");
        String consentLanguage = pmConf.getConsentLanguage();
        if (consentLanguage != null) {
            addQueryParameter.addQueryParameter("consentLanguage", consentLanguage);
        }
        String uuid = pmConf.getUuid();
        if (uuid != null) {
            addQueryParameter.addQueryParameter("uuid", uuid);
        }
        String messageId = pmConf.getMessageId();
        if (messageId != null) {
            addQueryParameter.addQueryParameter(Constants.MessagePayloadKeys.MSGID_SERVER, messageId);
        }
        return addQueryParameter.addQueryParameter("scriptType", "android").addQueryParameter("scriptVersion", "7.10.1").build();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.HttpUrlManager
    public HttpUrl getMetaDataUrl(MetaDataParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return new HttpUrl.Builder().scheme("https").host(param.getEnv().getHost()).addPathSegments("wrapper/v2/meta-data").addQueryParameter(D5.o, param.getEnv().getQueryParam()).addQueryParameter(InMobiAdapter.ACCOUNT_ID, String.valueOf(param.getAccountId())).addQueryParameter("propertyId", String.valueOf(param.getPropertyId())).addEncodedQueryParameter("metadata", param.getMetadata()).addQueryParameter("scriptType", "android").addQueryParameter("scriptVersion", "7.10.1").build();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.HttpUrlManager
    public HttpUrl getConsentStatusUrl(ConsentStatusParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        HttpUrl.Builder addQueryParameter = new HttpUrl.Builder().scheme("https").host(param.getEnv().getHost()).addPathSegments("wrapper/v2/consent-status").addQueryParameter(D5.o, param.getEnv().getQueryParam()).addQueryParameter(InMobiAdapter.ACCOUNT_ID, String.valueOf(param.getAccountId())).addQueryParameter("propertyId", String.valueOf(param.getPropertyId())).addQueryParameter("hasCsp", "true").addQueryParameter("withSiteActions", "false").addQueryParameter("includeData", param.getIncludeData().toString());
        String authId = param.getAuthId();
        if (authId != null) {
            addQueryParameter.addQueryParameter("authId", authId);
        }
        return addQueryParameter.addEncodedQueryParameter("metadata", param.getMetadata()).addQueryParameter("scriptType", "android").addQueryParameter("scriptVersion", "7.10.1").build();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.HttpUrlManager
    public HttpUrl getChoiceUrl(GetChoiceParamReq param) {
        String str;
        Intrinsics.checkNotNullParameter(param, "param");
        MetaDataArg metadataArg = param.getMetadataArg();
        if (metadataArg != null) {
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter.getSerializersModule();
            str = converter.encodeToString(MetaDataArg.INSTANCE.serializer(), metadataArg);
        } else {
            str = null;
        }
        Json converter2 = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
        JsonObject includeData = param.getIncludeData();
        converter2.getSerializersModule();
        return new HttpUrl.Builder().scheme("https").host(param.getEnv().getHost()).addPathSegments("wrapper/v2/choice").addPathSegments(param.getChoiceType().getType()).addQueryParameter(D5.o, param.getEnv().getQueryParam()).addQueryParameter(InMobiAdapter.ACCOUNT_ID, String.valueOf(param.getAccountId())).addQueryParameter("propertyId", String.valueOf(param.getPropertyId())).addQueryParameter("hasCsp", String.valueOf(param.getHasCsp())).addQueryParameter("withSiteActions", String.valueOf(param.getWithSiteActions())).addQueryParameter("includeCustomVendorsRes", String.valueOf(param.getIncludeCustomVendorsRes())).addEncodedQueryParameter("metadata", str).addQueryParameter("includeData", converter2.encodeToString(JsonObject.INSTANCE.serializer(), includeData)).addQueryParameter("scriptType", "android").addQueryParameter("scriptVersion", "7.10.1").build();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.HttpUrlManager
    public HttpUrl getGdprChoiceUrl(PostChoiceParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return new HttpUrl.Builder().scheme("https").host(param.getEnv().getHost()).addPathSegments("wrapper/v2/choice/gdpr/" + param.getActionType().getCode()).addQueryParameter(D5.o, param.getEnv().getQueryParam()).addQueryParameter("hasCsp", "true").addQueryParameter("scriptType", "android").addQueryParameter("scriptVersion", "7.10.1").build();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.HttpUrlManager
    public HttpUrl getCcpaChoiceUrl(PostChoiceParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return new HttpUrl.Builder().scheme("https").host(param.getEnv().getHost()).addPathSegments("wrapper/v2/choice/ccpa/" + param.getActionType().getCode()).addQueryParameter(D5.o, param.getEnv().getQueryParam()).addQueryParameter("hasCsp", "true").addQueryParameter("scriptType", "android").addQueryParameter("scriptVersion", "7.10.1").build();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.HttpUrlManager
    public HttpUrl postUsNatChoiceUrl(PostChoiceParamReq param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return new HttpUrl.Builder().scheme("https").host(param.getEnv().getHost()).addPathSegments("wrapper/v2/choice/usnat/" + param.getActionType().getCode()).addQueryParameter(D5.o, param.getEnv().getQueryParam()).addQueryParameter("hasCsp", "true").addQueryParameter("scriptType", "android").addQueryParameter("scriptVersion", "7.10.1").build();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.HttpUrlManager
    public HttpUrl getPvDataUrl(Env env) {
        Intrinsics.checkNotNullParameter(env, "env");
        return new HttpUrl.Builder().scheme("https").host(env.getHost()).addPathSegments("wrapper/v2/pv-data").addQueryParameter(D5.o, env.getQueryParam()).addQueryParameter("scriptType", "android").addQueryParameter("scriptVersion", "7.10.1").build();
    }

    @Override // com.sourcepoint.cmplibrary.data.network.util.HttpUrlManager
    public HttpUrl getMessagesUrl(MessagesParamReq param) {
        String str;
        Intrinsics.checkNotNullParameter(param, "param");
        MetaDataArg metadataArg = param.getMetadataArg();
        if (metadataArg != null) {
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter.getSerializersModule();
            str = converter.encodeToString(MetaDataArg.INSTANCE.serializer(), metadataArg);
        } else {
            str = null;
        }
        return new HttpUrl.Builder().scheme("https").host(param.getEnv().getHost()).addPathSegments("wrapper/v2/messages").addQueryParameter(D5.o, param.getEnv().getQueryParam()).addQueryParameter("nonKeyedLocalState", String.valueOf(param.getNonKeyedLocalState())).addQueryParameter("localState", String.valueOf(param.getLocalState())).addEncodedQueryParameter("body", param.getBody()).addEncodedQueryParameter("metadata", str).addQueryParameter("scriptType", "android").addQueryParameter("scriptVersion", "7.10.1").build();
    }
}
