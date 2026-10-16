package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.inmobi.sdk.InMobiSdk;
import com.ironsource.adapters.inmobi.InMobiAdapter;
import com.ironsource.sdk.controller.f;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp;
import com.sourcepoint.cmplibrary.model.exposed.MessageCategory;
import com.sourcepoint.cmplibrary.model.exposed.MessageSubCategory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: PvDataApiModelExt.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ag\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"toPvDataBody", "Lkotlinx/serialization/json/JsonObject;", "gdprCs", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", InMobiAdapter.ACCOUNT_ID, "", "propertyId", "gdprMessageMetaData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "ccpaMessageMetaData", "ccpaCS", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "usNatCS", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "metaDataResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "pubData", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;Ljava/lang/Long;Ljava/lang/Long;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;Lkotlinx/serialization/json/JsonObject;)Lkotlinx/serialization/json/JsonObject;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PvDataApiModelExtKt {
    public static final JsonObject toPvDataBody(GdprCS gdprCS, Long l, Long l2, MessageMetaData messageMetaData, MessageMetaData messageMetaData2, CcpaCS ccpaCS, USNatConsentData uSNatConsentData, MetaDataResp metaDataResp, JsonObject pubData) {
        MetaDataResp.USNat usNat;
        Double sampleRate;
        MetaDataResp.USNat usNat2;
        MetaDataResp.Ccpa ccpa;
        Double sampleRate2;
        MetaDataResp.Ccpa ccpa2;
        MetaDataResp.Gdpr gdpr;
        Double sampleRate3;
        MessageSubCategory subCategoryId;
        MessageCategory categoryId;
        MetaDataResp.Gdpr gdpr2;
        Intrinsics.checkNotNullParameter(pubData, "pubData");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        if (gdprCS != null) {
            JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
            JsonElementBuildersKt.put(jsonObjectBuilder2, "uuid", gdprCS.getUuid());
            JsonElementBuildersKt.put(jsonObjectBuilder2, "euconsent", gdprCS.getEuconsent());
            JsonElementBuildersKt.put(jsonObjectBuilder2, InMobiAdapter.ACCOUNT_ID, l);
            JsonElementBuildersKt.put(jsonObjectBuilder2, "applies", (metaDataResp == null || (gdpr2 = metaDataResp.getGdpr()) == null) ? null : gdpr2.getApplies());
            JsonElementBuildersKt.put(jsonObjectBuilder2, "siteId", l2);
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            ConsentStatus consentStatus = gdprCS.getConsentStatus();
            converter.getSerializersModule();
            jsonObjectBuilder2.put("consentStatus", converter.encodeToJsonElement(BuiltinSerializersKt.getNullable(ConsentStatus.INSTANCE.serializer()), consentStatus));
            JsonElementBuildersKt.put(jsonObjectBuilder2, f.b.b, messageMetaData != null ? messageMetaData.getMessageId() : null);
            JsonElementBuildersKt.put(jsonObjectBuilder2, "categoryId", (messageMetaData == null || (categoryId = messageMetaData.getCategoryId()) == null) ? null : Integer.valueOf(categoryId.getCode()));
            JsonElementBuildersKt.put(jsonObjectBuilder2, "subCategoryId", (messageMetaData == null || (subCategoryId = messageMetaData.getSubCategoryId()) == null) ? null : Integer.valueOf(subCategoryId.getCode()));
            JsonElementBuildersKt.put(jsonObjectBuilder2, "prtnUUID", messageMetaData != null ? messageMetaData.getPrtnUUID() : null);
            JsonElementBuildersKt.put(jsonObjectBuilder2, "sampleRate", Double.valueOf((metaDataResp == null || (gdpr = metaDataResp.getGdpr()) == null || (sampleRate3 = gdpr.getSampleRate()) == null) ? 1.0d : sampleRate3.doubleValue()));
            jsonObjectBuilder2.put("pubData", pubData);
            Unit unit = Unit.INSTANCE;
            jsonObjectBuilder.put(InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, jsonObjectBuilder2.build());
        }
        if (ccpaCS != null) {
            JsonObjectBuilder jsonObjectBuilder3 = new JsonObjectBuilder();
            JsonElementBuildersKt.put(jsonObjectBuilder3, "uuid", ccpaCS.getUuid());
            JsonElementBuildersKt.put(jsonObjectBuilder3, InMobiAdapter.ACCOUNT_ID, l);
            JsonElementBuildersKt.put(jsonObjectBuilder3, "applies", (metaDataResp == null || (ccpa2 = metaDataResp.getCcpa()) == null) ? null : ccpa2.getApplies());
            JsonElementBuildersKt.put(jsonObjectBuilder3, "siteId", l2);
            Json converter2 = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter2.getSerializersModule();
            jsonObjectBuilder3.put("consentStatus", converter2.encodeToJsonElement(CcpaCS.INSTANCE.serializer(), ccpaCS));
            JsonElementBuildersKt.put(jsonObjectBuilder3, "messageId", messageMetaData2 != null ? messageMetaData2.getMessageId() : null);
            JsonElementBuildersKt.put(jsonObjectBuilder3, "uuid", ccpaCS.getUuid());
            JsonElementBuildersKt.put(jsonObjectBuilder3, "sampleRate", Double.valueOf((metaDataResp == null || (ccpa = metaDataResp.getCcpa()) == null || (sampleRate2 = ccpa.getSampleRate()) == null) ? 1.0d : sampleRate2.doubleValue()));
            jsonObjectBuilder3.put("pubData", pubData);
            Unit unit2 = Unit.INSTANCE;
            jsonObjectBuilder.put("ccpa", jsonObjectBuilder3.build());
        }
        if (uSNatConsentData != null) {
            JsonObjectBuilder jsonObjectBuilder4 = new JsonObjectBuilder();
            JsonElementBuildersKt.put(jsonObjectBuilder4, "uuid", uSNatConsentData.getUuid());
            JsonElementBuildersKt.put(jsonObjectBuilder4, InMobiAdapter.ACCOUNT_ID, l);
            JsonElementBuildersKt.put(jsonObjectBuilder4, "applies", (metaDataResp == null || (usNat2 = metaDataResp.getUsNat()) == null) ? null : usNat2.getApplies());
            JsonElementBuildersKt.put(jsonObjectBuilder4, "siteId", l2);
            USNatConsentStatus consentStatus2 = uSNatConsentData.getConsentStatus();
            if (consentStatus2 != null) {
                Json converter3 = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                converter3.getSerializersModule();
                jsonObjectBuilder4.put("consentStatus", converter3.encodeToJsonElement(USNatConsentStatus.INSTANCE.serializer(), consentStatus2));
            }
            MessageMetaData messageMetaData3 = uSNatConsentData.getMessageMetaData();
            JsonElementBuildersKt.put(jsonObjectBuilder4, "messageId", messageMetaData3 != null ? messageMetaData3.getMessageId() : null);
            JsonElementBuildersKt.put(jsonObjectBuilder4, "uuid", uSNatConsentData.getUuid());
            JsonElementBuildersKt.put(jsonObjectBuilder4, "sampleRate", Double.valueOf((metaDataResp == null || (usNat = metaDataResp.getUsNat()) == null || (sampleRate = usNat.getSampleRate()) == null) ? 1.0d : sampleRate.doubleValue()));
            jsonObjectBuilder4.put("pubData", pubData);
            Unit unit3 = Unit.INSTANCE;
            jsonObjectBuilder.put("usnat", jsonObjectBuilder4.build());
        }
        return jsonObjectBuilder.build();
    }
}
