package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.sourcepoint.cmplibrary.data.network.converter.JsonMapSerializer;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.ConsentableImpl;
import com.sourcepoint.cmplibrary.model.exposed.ConsentableImpl$$serializer;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: ConsentStatusApiModel.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 i2\u00020\u0001:\u0004hijkBÃ\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0016\b\u0001\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eB±\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001fJ\u0010\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010M\u001a\u00020\u0017HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0017\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0015HÆ\u0003Jº\u0001\u0010Y\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÆ\u0001¢\u0006\u0002\u0010ZJ\u0013\u0010[\u001a\u00020\u00052\b\u0010\\\u001a\u0004\u0018\u00010]HÖ\u0003J\t\u0010^\u001a\u00020\u0003HÖ\u0001J\t\u0010_\u001a\u00020\fHÖ\u0001J&\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u00002\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020fHÁ\u0001¢\u0006\u0002\bgR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\t8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010*R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010(\u001a\u0004\b,\u0010&R&\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010(\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010(\u001a\u0004\b3\u0010/R*\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010(\u001a\u0004\b5\u00106R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010(\u001a\u0004\b8\u00109R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010(\u001a\u0004\b;\u0010<R\u001c\u0010\u0016\u001a\u00020\u00178\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010(\u001a\u0004\b>\u0010?R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010(\u001a\u0004\bA\u0010/R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR&\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bD\u0010(\u001a\u0004\bE\u0010/\"\u0004\bF\u00101R\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020$0\t8F¢\u0006\u0006\u001a\u0004\bH\u0010&R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010(\u001a\u0004\bJ\u0010K¨\u0006l"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CampaignMessage;", "seen1", "", "applies", "", "consentStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;", "consentStrings", "", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$ConsentString;", "dateCreated", "", "uuid", "webConsentPayload", "Lkotlinx/serialization/json/JsonObject;", PglCryptUtils.KEY_MESSAGE, "Lkotlinx/serialization/json/JsonElement;", "gppData", "", "messageMetaData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "type", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "url", "expirationDate", "userConsents", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$UserConsents;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonElement;Ljava/util/Map;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$UserConsents;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonElement;Ljava/util/Map;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$UserConsents;)V", "getApplies", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "categories", "Lcom/sourcepoint/cmplibrary/model/exposed/ConsentableImpl;", "getCategories", "()Ljava/util/List;", "getConsentStatus$annotations", "()V", "getConsentStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;", "getConsentStrings$annotations", "getConsentStrings", "getDateCreated$annotations", "getDateCreated", "()Ljava/lang/String;", "setDateCreated", "(Ljava/lang/String;)V", "getExpirationDate$annotations", "getExpirationDate", "getGppData$annotations", "getGppData", "()Ljava/util/Map;", "getMessage$annotations", "getMessage", "()Lkotlinx/serialization/json/JsonElement;", "getMessageMetaData$annotations", "getMessageMetaData", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "getType$annotations", "getType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getUrl$annotations", "getUrl", "getUserConsents", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$UserConsents;", "getUuid$annotations", "getUuid", "setUuid", "vendors", "getVendors", "getWebConsentPayload$annotations", "getWebConsentPayload", "()Lkotlinx/serialization/json/JsonObject;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonElement;Ljava/util/Map;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$UserConsents;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "ConsentString", "UserConsents", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class USNatConsentData implements CampaignMessage {
    private final Boolean applies;
    private final USNatConsentStatus consentStatus;
    private final List<ConsentString> consentStrings;
    private String dateCreated;
    private final String expirationDate;
    private final Map<String, JsonElement> gppData;
    private final JsonElement message;
    private final MessageMetaData messageMetaData;
    private final CampaignType type;
    private final String url;
    private final UserConsents userConsents;
    private String uuid;
    private final JsonObject webConsentPayload;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(USNatConsentData$ConsentString$$serializer.INSTANCE), null, null, null, null, null, null, EnumsKt.createSimpleEnumSerializer("com.sourcepoint.cmplibrary.exception.CampaignType", CampaignType.values()), null, null, null};

    public USNatConsentData() {
        this((Boolean) null, (USNatConsentStatus) null, (List) null, (String) null, (String) null, (JsonObject) null, (JsonElement) null, (Map) null, (MessageMetaData) null, (CampaignType) null, (String) null, (String) null, (UserConsents) null, 8191, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ USNatConsentData copy$default(USNatConsentData uSNatConsentData, Boolean bool, USNatConsentStatus uSNatConsentStatus, List list, String str, String str2, JsonObject jsonObject, JsonElement jsonElement, Map map, MessageMetaData messageMetaData, CampaignType campaignType, String str3, String str4, UserConsents userConsents, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = uSNatConsentData.applies;
        }
        return uSNatConsentData.copy(bool, (i & 2) != 0 ? uSNatConsentData.consentStatus : uSNatConsentStatus, (i & 4) != 0 ? uSNatConsentData.consentStrings : list, (i & 8) != 0 ? uSNatConsentData.dateCreated : str, (i & 16) != 0 ? uSNatConsentData.uuid : str2, (i & 32) != 0 ? uSNatConsentData.webConsentPayload : jsonObject, (i & 64) != 0 ? uSNatConsentData.message : jsonElement, (i & 128) != 0 ? uSNatConsentData.gppData : map, (i & 256) != 0 ? uSNatConsentData.messageMetaData : messageMetaData, (i & 512) != 0 ? uSNatConsentData.type : campaignType, (i & 1024) != 0 ? uSNatConsentData.url : str3, (i & 2048) != 0 ? uSNatConsentData.expirationDate : str4, (i & 4096) != 0 ? uSNatConsentData.userConsents : userConsents);
    }

    @SerialName("consentStatus")
    public static /* synthetic */ void getConsentStatus$annotations() {
    }

    @SerialName("consentStrings")
    public static /* synthetic */ void getConsentStrings$annotations() {
    }

    @SerialName("dateCreated")
    public static /* synthetic */ void getDateCreated$annotations() {
    }

    @SerialName("expirationDate")
    public static /* synthetic */ void getExpirationDate$annotations() {
    }

    @SerialName("GPPData")
    @Serializable(with = JsonMapSerializer.class)
    public static /* synthetic */ void getGppData$annotations() {
    }

    @SerialName(PglCryptUtils.KEY_MESSAGE)
    public static /* synthetic */ void getMessage$annotations() {
    }

    @SerialName("messageMetaData")
    public static /* synthetic */ void getMessageMetaData$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    @SerialName("url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    @SerialName("uuid")
    public static /* synthetic */ void getUuid$annotations() {
    }

    @SerialName("webConsentPayload")
    public static /* synthetic */ void getWebConsentPayload$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getApplies() {
        return this.applies;
    }

    /* renamed from: component10, reason: from getter */
    public final CampaignType getType() {
        return this.type;
    }

    /* renamed from: component11, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component12, reason: from getter */
    public final String getExpirationDate() {
        return this.expirationDate;
    }

    /* renamed from: component13, reason: from getter */
    public final UserConsents getUserConsents() {
        return this.userConsents;
    }

    /* renamed from: component2, reason: from getter */
    public final USNatConsentStatus getConsentStatus() {
        return this.consentStatus;
    }

    public final List<ConsentString> component3() {
        return this.consentStrings;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDateCreated() {
        return this.dateCreated;
    }

    /* renamed from: component5, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component6, reason: from getter */
    public final JsonObject getWebConsentPayload() {
        return this.webConsentPayload;
    }

    /* renamed from: component7, reason: from getter */
    public final JsonElement getMessage() {
        return this.message;
    }

    public final Map<String, JsonElement> component8() {
        return this.gppData;
    }

    /* renamed from: component9, reason: from getter */
    public final MessageMetaData getMessageMetaData() {
        return this.messageMetaData;
    }

    public final USNatConsentData copy(Boolean applies, USNatConsentStatus consentStatus, List<ConsentString> consentStrings, String dateCreated, String uuid, JsonObject webConsentPayload, JsonElement message, Map<String, ? extends JsonElement> gppData, MessageMetaData messageMetaData, CampaignType type, String url, String expirationDate, UserConsents userConsents) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new USNatConsentData(applies, consentStatus, consentStrings, dateCreated, uuid, webConsentPayload, message, gppData, messageMetaData, type, url, expirationDate, userConsents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof USNatConsentData)) {
            return false;
        }
        USNatConsentData uSNatConsentData = (USNatConsentData) other;
        return Intrinsics.areEqual(this.applies, uSNatConsentData.applies) && Intrinsics.areEqual(this.consentStatus, uSNatConsentData.consentStatus) && Intrinsics.areEqual(this.consentStrings, uSNatConsentData.consentStrings) && Intrinsics.areEqual(this.dateCreated, uSNatConsentData.dateCreated) && Intrinsics.areEqual(this.uuid, uSNatConsentData.uuid) && Intrinsics.areEqual(this.webConsentPayload, uSNatConsentData.webConsentPayload) && Intrinsics.areEqual(this.message, uSNatConsentData.message) && Intrinsics.areEqual(this.gppData, uSNatConsentData.gppData) && Intrinsics.areEqual(this.messageMetaData, uSNatConsentData.messageMetaData) && this.type == uSNatConsentData.type && Intrinsics.areEqual(this.url, uSNatConsentData.url) && Intrinsics.areEqual(this.expirationDate, uSNatConsentData.expirationDate) && Intrinsics.areEqual(this.userConsents, uSNatConsentData.userConsents);
    }

    public int hashCode() {
        Boolean bool = this.applies;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        USNatConsentStatus uSNatConsentStatus = this.consentStatus;
        int hashCode2 = (hashCode + (uSNatConsentStatus == null ? 0 : uSNatConsentStatus.hashCode())) * 31;
        List<ConsentString> list = this.consentStrings;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.dateCreated;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.uuid;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        JsonObject jsonObject = this.webConsentPayload;
        int hashCode6 = (hashCode5 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
        JsonElement jsonElement = this.message;
        int hashCode7 = (hashCode6 + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        Map<String, JsonElement> map = this.gppData;
        int hashCode8 = (hashCode7 + (map == null ? 0 : map.hashCode())) * 31;
        MessageMetaData messageMetaData = this.messageMetaData;
        int hashCode9 = (((hashCode8 + (messageMetaData == null ? 0 : messageMetaData.hashCode())) * 31) + this.type.hashCode()) * 31;
        String str3 = this.url;
        int hashCode10 = (hashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.expirationDate;
        int hashCode11 = (hashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        UserConsents userConsents = this.userConsents;
        return hashCode11 + (userConsents != null ? userConsents.hashCode() : 0);
    }

    public String toString() {
        return "USNatConsentData(applies=" + this.applies + ", consentStatus=" + this.consentStatus + ", consentStrings=" + this.consentStrings + ", dateCreated=" + this.dateCreated + ", uuid=" + this.uuid + ", webConsentPayload=" + this.webConsentPayload + ", message=" + this.message + ", gppData=" + this.gppData + ", messageMetaData=" + this.messageMetaData + ", type=" + this.type + ", url=" + this.url + ", expirationDate=" + this.expirationDate + ", userConsents=" + this.userConsents + ")";
    }

    /* compiled from: ConsentStatusApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<USNatConsentData> serializer() {
            return USNatConsentData$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ USNatConsentData(int i, Boolean bool, @SerialName("consentStatus") USNatConsentStatus uSNatConsentStatus, @SerialName("consentStrings") List list, @SerialName("dateCreated") String str, @SerialName("uuid") String str2, @SerialName("webConsentPayload") JsonObject jsonObject, @SerialName("message") JsonElement jsonElement, @SerialName("GPPData") @Serializable(with = JsonMapSerializer.class) Map map, @SerialName("messageMetaData") MessageMetaData messageMetaData, @SerialName("type") CampaignType campaignType, @SerialName("url") String str3, @SerialName("expirationDate") String str4, UserConsents userConsents, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.applies = null;
        } else {
            this.applies = bool;
        }
        if ((i & 2) == 0) {
            this.consentStatus = null;
        } else {
            this.consentStatus = uSNatConsentStatus;
        }
        if ((i & 4) == 0) {
            this.consentStrings = null;
        } else {
            this.consentStrings = list;
        }
        if ((i & 8) == 0) {
            this.dateCreated = null;
        } else {
            this.dateCreated = str;
        }
        if ((i & 16) == 0) {
            this.uuid = null;
        } else {
            this.uuid = str2;
        }
        if ((i & 32) == 0) {
            this.webConsentPayload = null;
        } else {
            this.webConsentPayload = jsonObject;
        }
        if ((i & 64) == 0) {
            this.message = null;
        } else {
            this.message = jsonElement;
        }
        if ((i & 128) == 0) {
            this.gppData = null;
        } else {
            this.gppData = map;
        }
        if ((i & 256) == 0) {
            this.messageMetaData = null;
        } else {
            this.messageMetaData = messageMetaData;
        }
        if ((i & 512) == 0) {
            this.type = CampaignType.USNAT;
        } else {
            this.type = campaignType;
        }
        if ((i & 1024) == 0) {
            this.url = null;
        } else {
            this.url = str3;
        }
        if ((i & 2048) == 0) {
            this.expirationDate = null;
        } else {
            this.expirationDate = str4;
        }
        if ((i & 4096) == 0) {
            this.userConsents = null;
        } else {
            this.userConsents = userConsents;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public USNatConsentData(Boolean bool, USNatConsentStatus uSNatConsentStatus, List<ConsentString> list, String str, String str2, JsonObject jsonObject, JsonElement jsonElement, Map<String, ? extends JsonElement> map, MessageMetaData messageMetaData, CampaignType type, String str3, String str4, UserConsents userConsents) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.applies = bool;
        this.consentStatus = uSNatConsentStatus;
        this.consentStrings = list;
        this.dateCreated = str;
        this.uuid = str2;
        this.webConsentPayload = jsonObject;
        this.message = jsonElement;
        this.gppData = map;
        this.messageMetaData = messageMetaData;
        this.type = type;
        this.url = str3;
        this.expirationDate = str4;
        this.userConsents = userConsents;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(USNatConsentData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.applies != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.applies);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.consentStatus != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, USNatConsentStatus$$serializer.INSTANCE, self.consentStatus);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.consentStrings != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.consentStrings);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.getDateCreated() != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.getDateCreated());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.uuid != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.uuid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.webConsentPayload != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, JsonObjectSerializer.INSTANCE, self.webConsentPayload);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.getMessage() != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, JsonElementSerializer.INSTANCE, self.getMessage());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.gppData != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, JsonMapSerializer.INSTANCE, self.gppData);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.getMessageMetaData() != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, MessageMetaData$$serializer.INSTANCE, self.getMessageMetaData());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.getType() != CampaignType.USNAT) {
            output.encodeSerializableElement(serialDesc, 9, kSerializerArr[9], self.getType());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.getUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.getUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.getExpirationDate() != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.getExpirationDate());
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 12) && self.userConsents == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 12, USNatConsentData$UserConsents$$serializer.INSTANCE, self.userConsents);
    }

    public final Boolean getApplies() {
        return this.applies;
    }

    public final USNatConsentStatus getConsentStatus() {
        return this.consentStatus;
    }

    public final List<ConsentString> getConsentStrings() {
        return this.consentStrings;
    }

    @Override // com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage
    public String getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(String str) {
        this.dateCreated = str;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final void setUuid(String str) {
        this.uuid = str;
    }

    public final JsonObject getWebConsentPayload() {
        return this.webConsentPayload;
    }

    @Override // com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage
    public JsonElement getMessage() {
        return this.message;
    }

    public final Map<String, JsonElement> getGppData() {
        return this.gppData;
    }

    @Override // com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage
    public MessageMetaData getMessageMetaData() {
        return this.messageMetaData;
    }

    public /* synthetic */ USNatConsentData(Boolean bool, USNatConsentStatus uSNatConsentStatus, List list, String str, String str2, JsonObject jsonObject, JsonElement jsonElement, Map map, MessageMetaData messageMetaData, CampaignType campaignType, String str3, String str4, UserConsents userConsents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : uSNatConsentStatus, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : jsonObject, (i & 64) != 0 ? null : jsonElement, (i & 128) != 0 ? null : map, (i & 256) != 0 ? null : messageMetaData, (i & 512) != 0 ? CampaignType.USNAT : campaignType, (i & 1024) != 0 ? null : str3, (i & 2048) != 0 ? null : str4, (i & 4096) != 0 ? null : userConsents);
    }

    @Override // com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage
    public CampaignType getType() {
        return this.type;
    }

    @Override // com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage
    public String getUrl() {
        return this.url;
    }

    @Override // com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage
    public String getExpirationDate() {
        return this.expirationDate;
    }

    /* compiled from: ConsentStatusApiModel.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&HÁ\u0001¢\u0006\u0002\b'R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f¨\u0006*"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$ConsentString;", "", "seen1", "", "sectionId", "sectionName", "", "consentString", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getConsentString$annotations", "()V", "getConsentString", "()Ljava/lang/String;", "getSectionId$annotations", "getSectionId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSectionName$annotations", "getSectionName", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$ConsentString;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ConsentString {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String consentString;
        private final Integer sectionId;
        private final String sectionName;

        public static /* synthetic */ ConsentString copy$default(ConsentString consentString, Integer num, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = consentString.sectionId;
            }
            if ((i & 2) != 0) {
                str = consentString.sectionName;
            }
            if ((i & 4) != 0) {
                str2 = consentString.consentString;
            }
            return consentString.copy(num, str, str2);
        }

        @SerialName("consentString")
        public static /* synthetic */ void getConsentString$annotations() {
        }

        @SerialName("sectionId")
        public static /* synthetic */ void getSectionId$annotations() {
        }

        @SerialName("sectionName")
        public static /* synthetic */ void getSectionName$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getSectionId() {
            return this.sectionId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSectionName() {
            return this.sectionName;
        }

        /* renamed from: component3, reason: from getter */
        public final String getConsentString() {
            return this.consentString;
        }

        public final ConsentString copy(Integer sectionId, String sectionName, String consentString) {
            return new ConsentString(sectionId, sectionName, consentString);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConsentString)) {
                return false;
            }
            ConsentString consentString = (ConsentString) other;
            return Intrinsics.areEqual(this.sectionId, consentString.sectionId) && Intrinsics.areEqual(this.sectionName, consentString.sectionName) && Intrinsics.areEqual(this.consentString, consentString.consentString);
        }

        public int hashCode() {
            Integer num = this.sectionId;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.sectionName;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.consentString;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "ConsentString(sectionId=" + this.sectionId + ", sectionName=" + this.sectionName + ", consentString=" + this.consentString + ")";
        }

        /* compiled from: ConsentStatusApiModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$ConsentString$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$ConsentString;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ConsentString> serializer() {
                return USNatConsentData$ConsentString$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ConsentString(int i, @SerialName("sectionId") Integer num, @SerialName("sectionName") String str, @SerialName("consentString") String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, USNatConsentData$ConsentString$$serializer.INSTANCE.getDescriptor());
            }
            this.sectionId = num;
            this.sectionName = str;
            this.consentString = str2;
        }

        public ConsentString(Integer num, String str, String str2) {
            this.sectionId = num;
            this.sectionName = str;
            this.consentString = str2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$cmplibrary_release(ConsentString self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.sectionId);
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.sectionName);
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.consentString);
        }

        public final Integer getSectionId() {
            return this.sectionId;
        }

        public final String getSectionName() {
            return this.sectionName;
        }

        public final String getConsentString() {
            return this.consentString;
        }
    }

    public final UserConsents getUserConsents() {
        return this.userConsents;
    }

    /* compiled from: ConsentStatusApiModel.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B9\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eHÁ\u0001¢\u0006\u0002\b\u001fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\""}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$UserConsents;", "", "seen1", "", "vendors", "", "Lcom/sourcepoint/cmplibrary/model/exposed/ConsentableImpl;", "categories", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/util/List;)V", "getCategories", "()Ljava/util/List;", "getVendors", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class UserConsents {
        private final List<ConsentableImpl> categories;
        private final List<ConsentableImpl> vendors;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(ConsentableImpl$$serializer.INSTANCE), new ArrayListSerializer(ConsentableImpl$$serializer.INSTANCE)};

        /* JADX WARN: Multi-variable type inference failed */
        public UserConsents() {
            this((List) null, (List) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UserConsents copy$default(UserConsents userConsents, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = userConsents.vendors;
            }
            if ((i & 2) != 0) {
                list2 = userConsents.categories;
            }
            return userConsents.copy(list, list2);
        }

        public final List<ConsentableImpl> component1() {
            return this.vendors;
        }

        public final List<ConsentableImpl> component2() {
            return this.categories;
        }

        public final UserConsents copy(List<ConsentableImpl> vendors, List<ConsentableImpl> categories) {
            return new UserConsents(vendors, categories);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserConsents)) {
                return false;
            }
            UserConsents userConsents = (UserConsents) other;
            return Intrinsics.areEqual(this.vendors, userConsents.vendors) && Intrinsics.areEqual(this.categories, userConsents.categories);
        }

        public int hashCode() {
            List<ConsentableImpl> list = this.vendors;
            int hashCode = (list == null ? 0 : list.hashCode()) * 31;
            List<ConsentableImpl> list2 = this.categories;
            return hashCode + (list2 != null ? list2.hashCode() : 0);
        }

        public String toString() {
            return "UserConsents(vendors=" + this.vendors + ", categories=" + this.categories + ")";
        }

        /* compiled from: ConsentStatusApiModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$UserConsents$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$UserConsents;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<UserConsents> serializer() {
                return USNatConsentData$UserConsents$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ UserConsents(int i, List list, List list2, SerializationConstructorMarker serializationConstructorMarker) {
            this.vendors = (i & 1) == 0 ? CollectionsKt.emptyList() : list;
            if ((i & 2) == 0) {
                this.categories = CollectionsKt.emptyList();
            } else {
                this.categories = list2;
            }
        }

        public UserConsents(List<ConsentableImpl> list, List<ConsentableImpl> list2) {
            this.vendors = list;
            this.categories = list2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$cmplibrary_release(UserConsents self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.vendors, CollectionsKt.emptyList())) {
                output.encodeNullableSerializableElement(serialDesc, 0, kSerializerArr[0], self.vendors);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.categories, CollectionsKt.emptyList())) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.categories);
        }

        public /* synthetic */ UserConsents(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
        }

        public final List<ConsentableImpl> getVendors() {
            return this.vendors;
        }

        public final List<ConsentableImpl> getCategories() {
            return this.categories;
        }
    }

    public final List<ConsentableImpl> getVendors() {
        List<ConsentableImpl> vendors;
        UserConsents userConsents = this.userConsents;
        return (userConsents == null || (vendors = userConsents.getVendors()) == null) ? CollectionsKt.emptyList() : vendors;
    }

    public final List<ConsentableImpl> getCategories() {
        List<ConsentableImpl> categories;
        UserConsents userConsents = this.userConsents;
        return (userConsents == null || (categories = userConsents.getCategories()) == null) ? CollectionsKt.emptyList() : categories;
    }
}
