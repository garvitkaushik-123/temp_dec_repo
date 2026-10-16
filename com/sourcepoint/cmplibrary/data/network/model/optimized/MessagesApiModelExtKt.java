package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.ironsource.C3040d4;
import com.ironsource.N6;
import com.ironsource.adapters.inmobi.InMobiAdapter;
import com.sourcepoint.cmplibrary.campaign.CampaignManager;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataMetaDataParam;
import com.sourcepoint.cmplibrary.data.network.model.optimized.includeData.IncludeDataKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.messages.OperatingSystemInfoParam;
import com.sourcepoint.cmplibrary.data.network.util.CampaignsEnv;
import com.sourcepoint.cmplibrary.data.network.util.Env;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.CampaignReq;
import com.sourcepoint.cmplibrary.model.exposed.TargetingParam;
import com.sourcepoint.cmplibrary.util.extensions.SpConfigExtKt;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: MessagesApiModelExt.kt */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aj\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u001b\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000\u001a\u001b\u0010\u001f\u001a\u00020 *\u00020!2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\u0010\"\u001a\u001a\u0010#\u001a\u00020$*\u00020\u001c2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u001a\u0012\u0010%\u001a\u00020&*\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u001a6\u0010'\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0000¨\u0006("}, d2 = {"getMessageBody", "Lkotlinx/serialization/json/JsonObject;", "propertyHref", "", InMobiAdapter.ACCOUNT_ID, "", "campaigns", "", "Lcom/sourcepoint/cmplibrary/model/CampaignReq;", C3040d4.i.a0, "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "ccpaConsentStatus", "usNatConsentStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;", "consentLanguage", "campaignEnv", "Lcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;", "includeData", N6.F, "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/messages/OperatingSystemInfoParam;", "toCcpaCS", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CCPA;", "applies", "", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CCPA;Ljava/lang/Boolean;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "toConsentStatusParamReq", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusParamReq;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesParamReq;", "campaignManager", "Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "toGdprCS", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GDPR;", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GDPR;Ljava/lang/Boolean;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "toMetaDataParamReq", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataParamReq;", "toMetadataArgs", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg;", "toMetadataBody", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MessagesApiModelExtKt {
    public static /* synthetic */ JsonObject toMetadataBody$default(List list, ConsentStatus consentStatus, String str, USNatConsentStatus uSNatConsentStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            consentStatus = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            uSNatConsentStatus = null;
        }
        return toMetadataBody(list, consentStatus, str, uSNatConsentStatus);
    }

    public static final MetaDataParamReq toMetaDataParamReq(MessagesParamReq messagesParamReq, List<? extends CampaignReq> campaigns) {
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.checkNotNullParameter(messagesParamReq, "<this>");
        Intrinsics.checkNotNullParameter(campaigns, "campaigns");
        Env env = messagesParamReq.getEnv();
        long accountId = messagesParamReq.getAccountId();
        long propertyId = messagesParamReq.getPropertyId();
        Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
        List<? extends CampaignReq> list = campaigns;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((CampaignReq) obj).getCampaignType() == CampaignType.GDPR) {
                break;
            }
        }
        CampaignReq campaignReq = (CampaignReq) obj;
        MetaDataMetaDataParam.MetaDataCampaign metaDataCampaign = campaignReq != null ? new MetaDataMetaDataParam.MetaDataCampaign(campaignReq.getGroupPmId()) : null;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            if (((CampaignReq) obj2).getCampaignType() == CampaignType.CCPA) {
                break;
            }
        }
        CampaignReq campaignReq2 = (CampaignReq) obj2;
        MetaDataMetaDataParam.MetaDataCampaign metaDataCampaign2 = campaignReq2 != null ? new MetaDataMetaDataParam.MetaDataCampaign(campaignReq2.getGroupPmId()) : null;
        Iterator<T> it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it3.next();
            if (((CampaignReq) obj3).getCampaignType() == CampaignType.USNAT) {
                break;
            }
        }
        CampaignReq campaignReq3 = (CampaignReq) obj3;
        MetaDataMetaDataParam metaDataMetaDataParam = new MetaDataMetaDataParam(metaDataCampaign, metaDataCampaign2, campaignReq3 != null ? new MetaDataMetaDataParam.MetaDataCampaign(campaignReq3.getGroupPmId()) : null);
        converter.getSerializersModule();
        return new MetaDataParamReq(env, propertyId, accountId, converter.encodeToString(MetaDataMetaDataParam.INSTANCE.serializer(), metaDataMetaDataParam));
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x009a, code lost:
    
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ConsentStatusParamReq toConsentStatusParamReq(MessagesParamReq messagesParamReq, CampaignManager campaignManager) {
        String str;
        MetaDataArg metadataArg;
        String str2;
        Intrinsics.checkNotNullParameter(messagesParamReq, "<this>");
        Intrinsics.checkNotNullParameter(campaignManager, "campaignManager");
        String gdprUuid = campaignManager.getGdprUuid();
        String ccpaUuid = campaignManager.getCcpaUuid();
        MetaDataArg metaDataArg = null;
        if (ccpaUuid == null) {
            CcpaCS ccpaConsentStatus = campaignManager.getCcpaConsentStatus();
            if (ccpaConsentStatus == null) {
                str = null;
                JsonElement messagesOptimizedLocalState = campaignManager.getMessagesOptimizedLocalState();
                metadataArg = messagesParamReq.getMetadataArg();
                if (metadataArg != null) {
                    MetaDataArg.GdprArg gdpr = messagesParamReq.getMetadataArg().getGdpr();
                    MetaDataArg.GdprArg copy$default = gdpr != null ? MetaDataArg.GdprArg.copy$default(gdpr, null, null, null, null, gdprUuid, 15, null) : null;
                    MetaDataArg.CcpaArg ccpa = messagesParamReq.getMetadataArg().getCcpa();
                    MetaDataArg.CcpaArg copy$default2 = ccpa != null ? MetaDataArg.CcpaArg.copy$default(ccpa, null, null, null, null, str, 15, null) : null;
                    MetaDataArg.UsNatArg usNat = messagesParamReq.getMetadataArg().getUsNat();
                    metaDataArg = metadataArg.copy(copy$default2, copy$default, usNat != null ? MetaDataApiModelExtKt.createMetadataArg(usNat, campaignManager) : null);
                }
                Env env = messagesParamReq.getEnv();
                long accountId = messagesParamReq.getAccountId();
                long propertyId = messagesParamReq.getPropertyId();
                if (metaDataArg != null) {
                    Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                    converter.getSerializersModule();
                    str2 = converter.encodeToString(MetaDataArg.INSTANCE.serializer(), metaDataArg);
                }
                str2 = "{}";
                return new ConsentStatusParamReq(env, str2, propertyId, accountId, messagesParamReq.getAuthId(), messagesOptimizedLocalState, IncludeDataKt.buildIncludeData(SpConfigExtKt.getGppCustomOption(campaignManager.getSpConfig())));
            }
            ccpaUuid = ccpaConsentStatus.getUuid();
        }
        str = ccpaUuid;
        JsonElement messagesOptimizedLocalState2 = campaignManager.getMessagesOptimizedLocalState();
        metadataArg = messagesParamReq.getMetadataArg();
        if (metadataArg != null) {
        }
        Env env2 = messagesParamReq.getEnv();
        long accountId2 = messagesParamReq.getAccountId();
        long propertyId2 = messagesParamReq.getPropertyId();
        if (metaDataArg != null) {
        }
        str2 = "{}";
        return new ConsentStatusParamReq(env2, str2, propertyId2, accountId2, messagesParamReq.getAuthId(), messagesOptimizedLocalState2, IncludeDataKt.buildIncludeData(SpConfigExtKt.getGppCustomOption(campaignManager.getSpConfig())));
    }

    public static final CcpaCS toCcpaCS(CCPA ccpa, Boolean bool) {
        Intrinsics.checkNotNullParameter(ccpa, "<this>");
        return new CcpaCS(bool, ccpa.getConsentedAll(), ccpa.getDateCreated(), null, ccpa.getNewUser(), ccpa.getRejectedAll(), ccpa.getRejectedCategories(), ccpa.getRejectedVendors(), ccpa.getSignedLspa(), ccpa.getUspstring(), ccpa.getStatus(), ccpa.getGppData(), null, ccpa.getWebConsentPayload(), ccpa.getExpirationDate());
    }

    public static final GdprCS toGdprCS(GDPR gdpr, Boolean bool) {
        Intrinsics.checkNotNullParameter(gdpr, "<this>");
        return new GdprCS(bool, null, null, null, null, null, null, null, null, null, gdpr.getAddtlConsent(), gdpr.getConsentStatus(), null, gdpr.getCustomVendorsResponse(), gdpr.getDateCreated(), gdpr.getEuconsent(), gdpr.getGrants(), gdpr.getTCData(), null, null, null, gdpr.getWebConsentPayload(), gdpr.getExpirationDate(), gdpr.getGoogleConsentMode());
    }

    public static final JsonObject getMessageBody(String propertyHref, long j, List<? extends CampaignReq> campaigns, ConsentStatus consentStatus, String str, USNatConsentStatus uSNatConsentStatus, String str2, CampaignsEnv campaignsEnv, JsonObject includeData, final OperatingSystemInfoParam os) {
        String env;
        Intrinsics.checkNotNullParameter(propertyHref, "propertyHref");
        Intrinsics.checkNotNullParameter(campaigns, "campaigns");
        Intrinsics.checkNotNullParameter(includeData, "includeData");
        Intrinsics.checkNotNullParameter(os, "os");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder, InMobiAdapter.ACCOUNT_ID, Long.valueOf(j));
        if (campaignsEnv != null && (env = campaignsEnv.getEnv()) != null) {
            JsonElementBuildersKt.put(jsonObjectBuilder, "campaignEnv", env);
        }
        jsonObjectBuilder.put("includeData", includeData);
        JsonElementBuildersKt.put(jsonObjectBuilder, "propertyHref", "https://" + propertyHref);
        JsonElementBuildersKt.put(jsonObjectBuilder, "hasCSP", (Boolean) true);
        jsonObjectBuilder.put("campaigns", toMetadataBody(campaigns, consentStatus, str, uSNatConsentStatus));
        JsonElementBuildersKt.put(jsonObjectBuilder, "consentLanguage", str2);
        JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, N6.F, new Function1<JsonObjectBuilder, Unit>() { // from class: com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesApiModelExtKt$getMessageBody$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                invoke2(jsonObjectBuilder2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonObjectBuilder putJsonObject) {
                Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
                JsonElementBuildersKt.put(putJsonObject, "name", OperatingSystemInfoParam.this.getName());
                JsonElementBuildersKt.put(putJsonObject, "version", OperatingSystemInfoParam.this.getVersion());
            }
        });
        return jsonObjectBuilder.build();
    }

    public static final JsonObject toMetadataBody(List<? extends CampaignReq> list, final ConsentStatus consentStatus, final String str, final USNatConsentStatus uSNatConsentStatus) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        for (final CampaignReq campaignReq : list) {
            String lowerCase = campaignReq.getCampaignType().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, lowerCase, new Function1<JsonObjectBuilder, Unit>() { // from class: com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesApiModelExtKt$toMetadataBody$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                    invoke2(jsonObjectBuilder2);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:28:0x0092, code lost:
                
                    if (r0 == null) goto L30;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:6:0x002e, code lost:
                
                    if (r0 == null) goto L8;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(JsonObjectBuilder putJsonObject) {
                    JsonObject jsonObject;
                    JsonObject jsonObject2;
                    Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
                    if (CampaignReq.this.getCampaignType() == CampaignType.GDPR) {
                        ConsentStatus consentStatus2 = consentStatus;
                        if (consentStatus2 != null) {
                            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                            converter.getSerializersModule();
                            jsonObject2 = converter.encodeToJsonElement(ConsentStatus.INSTANCE.serializer(), consentStatus2);
                        }
                        jsonObject2 = new JsonObject(MapsKt.emptyMap());
                        putJsonObject.put("consentStatus", jsonObject2);
                        JsonElementBuildersKt.put(putJsonObject, "hasLocalData", Boolean.valueOf(consentStatus != null));
                    }
                    if (CampaignReq.this.getCampaignType() == CampaignType.CCPA) {
                        String str2 = str;
                        if (str2 == null) {
                            str2 = "";
                        }
                        JsonElementBuildersKt.put(putJsonObject, "status", str2);
                        JsonElementBuildersKt.put(putJsonObject, "hasLocalData", Boolean.valueOf(str != null));
                    }
                    if (CampaignReq.this.getCampaignType() == CampaignType.USNAT) {
                        USNatConsentStatus uSNatConsentStatus2 = uSNatConsentStatus;
                        if (uSNatConsentStatus2 != null) {
                            Json converter2 = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                            converter2.getSerializersModule();
                            jsonObject = converter2.encodeToJsonElement(USNatConsentStatus.INSTANCE.serializer(), uSNatConsentStatus2);
                        }
                        jsonObject = new JsonObject(MapsKt.emptyMap());
                        putJsonObject.put("consentStatus", jsonObject);
                        JsonElementBuildersKt.put(putJsonObject, "hasLocalData", Boolean.valueOf(uSNatConsentStatus != null));
                    }
                    final CampaignReq campaignReq2 = CampaignReq.this;
                    JsonElementBuildersKt.putJsonObject(putJsonObject, "targetingParams", new Function1<JsonObjectBuilder, Unit>() { // from class: com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesApiModelExtKt$toMetadataBody$1$1$1.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                            invoke2(jsonObjectBuilder2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(JsonObjectBuilder putJsonObject2) {
                            Intrinsics.checkNotNullParameter(putJsonObject2, "$this$putJsonObject");
                            for (TargetingParam targetingParam : CampaignReq.this.getTargetingParams()) {
                                JsonElementBuildersKt.put(putJsonObject2, targetingParam.getKey(), targetingParam.getValue());
                            }
                        }
                    });
                }
            });
        }
        return jsonObjectBuilder.build();
    }

    public static final MetaDataArg toMetadataArgs(List<? extends CampaignReq> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        for (final CampaignReq campaignReq : list) {
            String lowerCase = campaignReq.getCampaignType().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, lowerCase, new Function1<JsonObjectBuilder, Unit>() { // from class: com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesApiModelExtKt$toMetadataArgs$json$1$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                    invoke2(jsonObjectBuilder2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(JsonObjectBuilder putJsonObject) {
                    Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
                    final CampaignReq campaignReq2 = CampaignReq.this;
                    JsonElementBuildersKt.putJsonObject(putJsonObject, "targetingParams", new Function1<JsonObjectBuilder, Unit>() { // from class: com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesApiModelExtKt$toMetadataArgs$json$1$1$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                            invoke2(jsonObjectBuilder2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(JsonObjectBuilder putJsonObject2) {
                            Intrinsics.checkNotNullParameter(putJsonObject2, "$this$putJsonObject");
                            for (TargetingParam targetingParam : CampaignReq.this.getTargetingParams()) {
                                JsonElementBuildersKt.put(putJsonObject2, targetingParam.getKey(), targetingParam.getValue());
                            }
                        }
                    });
                    JsonElementBuildersKt.put(putJsonObject, "groupPmId", CampaignReq.this.getGroupPmId());
                }
            });
        }
        JsonObject build = jsonObjectBuilder.build();
        Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
        converter.getSerializersModule();
        return (MetaDataArg) converter.decodeFromJsonElement(MetaDataArg.INSTANCE.serializer(), build);
    }
}
