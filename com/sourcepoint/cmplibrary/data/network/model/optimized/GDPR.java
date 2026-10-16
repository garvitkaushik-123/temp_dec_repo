package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.sourcepoint.cmplibrary.data.network.converter.CampaignTypeSerializer;
import com.sourcepoint.cmplibrary.data.network.converter.GrantsSerializer;
import com.sourcepoint.cmplibrary.data.network.converter.JsonMapSerializer;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.GDPRPurposeGrants;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bD\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 q2\u00020\u0001:\u0002pqBñ\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0001\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0016\b\u0001\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010!B»\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010\"J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0017\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eHÆ\u0003J\t\u0010T\u001a\u00020\u0018HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010AJ\u000b\u0010`\u001a\u0004\u0018\u00010\u0013HÆ\u0003Jä\u0001\u0010a\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÆ\u0001¢\u0006\u0002\u0010bJ\u0013\u0010c\u001a\u00020\u00112\b\u0010d\u001a\u0004\u0018\u00010eHÖ\u0003J\t\u0010f\u001a\u00020\u0003HÖ\u0001J\t\u0010g\u001a\u00020\u0005HÖ\u0001J&\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\u00002\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020nHÁ\u0001¢\u0006\u0002\boR*\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010$\u001a\u0004\b(\u0010)R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010$\u001a\u0004\b+\u0010)R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010$\u001a\u0004\b-\u0010.R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010$\u001a\u0004\b0\u00101R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010$\u001a\u0004\b3\u0010)R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010$\u001a\u0004\b5\u0010)R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010$\u001a\u0004\b7\u0010)R&\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u0010$\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R*\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010$\u001a\u0004\b>\u0010&R \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010B\u0012\u0004\b?\u0010$\u001a\u0004\b@\u0010AR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010$\u001a\u0004\bD\u0010ER\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010$\u001a\u0004\bG\u0010HR\u001c\u0010\u0017\u001a\u00020\u00188\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010$\u001a\u0004\bJ\u0010KR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010$\u001a\u0004\bM\u0010)R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bN\u0010$\u001a\u0004\bO\u0010P¨\u0006r"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GDPR;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CampaignMessage;", "seen1", "", "addtlConsent", "", "childPmId", "consentStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "customVendorsResponse", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse;", "dateCreated", "euconsent", "grants", "", "Lcom/sourcepoint/cmplibrary/model/exposed/GDPRPurposeGrants;", "hasLocalData", "", PglCryptUtils.KEY_MESSAGE, "Lkotlinx/serialization/json/JsonElement;", "messageMetaData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "TCData", "type", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "url", "expirationDate", "webConsentPayload", "Lkotlinx/serialization/json/JsonObject;", "googleConsentMode", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;Lkotlinx/serialization/json/JsonElement;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;Ljava/util/Map;Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;Lkotlinx/serialization/json/JsonElement;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;Ljava/util/Map;Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;)V", "getTCData$annotations", "()V", "getTCData", "()Ljava/util/Map;", "getAddtlConsent$annotations", "getAddtlConsent", "()Ljava/lang/String;", "getChildPmId$annotations", "getChildPmId", "getConsentStatus$annotations", "getConsentStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "getCustomVendorsResponse$annotations", "getCustomVendorsResponse", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse;", "getDateCreated$annotations", "getDateCreated", "getEuconsent$annotations", "getEuconsent", "getExpirationDate$annotations", "getExpirationDate", "getGoogleConsentMode$annotations", "getGoogleConsentMode", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;", "setGoogleConsentMode", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;)V", "getGrants$annotations", "getGrants", "getHasLocalData$annotations", "getHasLocalData", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMessage$annotations", "getMessage", "()Lkotlinx/serialization/json/JsonElement;", "getMessageMetaData$annotations", "getMessageMetaData", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "getType$annotations", "getType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getUrl$annotations", "getUrl", "getWebConsentPayload$annotations", "getWebConsentPayload", "()Lkotlinx/serialization/json/JsonObject;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS$CustomVendorsResponse;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;Lkotlinx/serialization/json/JsonElement;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;Ljava/util/Map;Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GDPR;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class GDPR implements CampaignMessage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, JsonElement> TCData;
    private final String addtlConsent;
    private final String childPmId;
    private final ConsentStatus consentStatus;
    private final GdprCS.CustomVendorsResponse customVendorsResponse;
    private final String dateCreated;
    private final String euconsent;
    private final String expirationDate;
    private GoogleConsentMode googleConsentMode;
    private final Map<String, GDPRPurposeGrants> grants;
    private final Boolean hasLocalData;
    private final JsonElement message;
    private final MessageMetaData messageMetaData;
    private final CampaignType type;
    private final String url;
    private final JsonObject webConsentPayload;

    public static /* synthetic */ GDPR copy$default(GDPR gdpr, String str, String str2, ConsentStatus consentStatus, GdprCS.CustomVendorsResponse customVendorsResponse, String str3, String str4, Map map, Boolean bool, JsonElement jsonElement, MessageMetaData messageMetaData, Map map2, CampaignType campaignType, String str5, String str6, JsonObject jsonObject, GoogleConsentMode googleConsentMode, int i, Object obj) {
        String str7 = (i & 1) != 0 ? gdpr.addtlConsent : str;
        return gdpr.copy(str7, (i & 2) != 0 ? gdpr.childPmId : str2, (i & 4) != 0 ? gdpr.consentStatus : consentStatus, (i & 8) != 0 ? gdpr.customVendorsResponse : customVendorsResponse, (i & 16) != 0 ? gdpr.dateCreated : str3, (i & 32) != 0 ? gdpr.euconsent : str4, (i & 64) != 0 ? gdpr.grants : map, (i & 128) != 0 ? gdpr.hasLocalData : bool, (i & 256) != 0 ? gdpr.message : jsonElement, (i & 512) != 0 ? gdpr.messageMetaData : messageMetaData, (i & 1024) != 0 ? gdpr.TCData : map2, (i & 2048) != 0 ? gdpr.type : campaignType, (i & 4096) != 0 ? gdpr.url : str5, (i & 8192) != 0 ? gdpr.expirationDate : str6, (i & 16384) != 0 ? gdpr.webConsentPayload : jsonObject, (i & 32768) != 0 ? gdpr.googleConsentMode : googleConsentMode);
    }

    @SerialName("addtlConsent")
    public static /* synthetic */ void getAddtlConsent$annotations() {
    }

    @SerialName("childPmId")
    public static /* synthetic */ void getChildPmId$annotations() {
    }

    @SerialName("consentStatus")
    public static /* synthetic */ void getConsentStatus$annotations() {
    }

    @SerialName("customVendorsResponse")
    public static /* synthetic */ void getCustomVendorsResponse$annotations() {
    }

    @SerialName("dateCreated")
    public static /* synthetic */ void getDateCreated$annotations() {
    }

    @SerialName("euconsent")
    public static /* synthetic */ void getEuconsent$annotations() {
    }

    @SerialName("expirationDate")
    public static /* synthetic */ void getExpirationDate$annotations() {
    }

    @SerialName("gcmStatus")
    public static /* synthetic */ void getGoogleConsentMode$annotations() {
    }

    @Serializable(with = GrantsSerializer.class)
    public static /* synthetic */ void getGrants$annotations() {
    }

    @SerialName("hasLocalData")
    public static /* synthetic */ void getHasLocalData$annotations() {
    }

    @SerialName(PglCryptUtils.KEY_MESSAGE)
    public static /* synthetic */ void getMessage$annotations() {
    }

    @SerialName("messageMetaData")
    public static /* synthetic */ void getMessageMetaData$annotations() {
    }

    @Serializable(with = JsonMapSerializer.class)
    public static /* synthetic */ void getTCData$annotations() {
    }

    @Serializable(with = CampaignTypeSerializer.class)
    public static /* synthetic */ void getType$annotations() {
    }

    @SerialName("url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    @SerialName("webConsentPayload")
    public static /* synthetic */ void getWebConsentPayload$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getAddtlConsent() {
        return this.addtlConsent;
    }

    /* renamed from: component10, reason: from getter */
    public final MessageMetaData getMessageMetaData() {
        return this.messageMetaData;
    }

    public final Map<String, JsonElement> component11() {
        return this.TCData;
    }

    /* renamed from: component12, reason: from getter */
    public final CampaignType getType() {
        return this.type;
    }

    /* renamed from: component13, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component14, reason: from getter */
    public final String getExpirationDate() {
        return this.expirationDate;
    }

    /* renamed from: component15, reason: from getter */
    public final JsonObject getWebConsentPayload() {
        return this.webConsentPayload;
    }

    /* renamed from: component16, reason: from getter */
    public final GoogleConsentMode getGoogleConsentMode() {
        return this.googleConsentMode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getChildPmId() {
        return this.childPmId;
    }

    /* renamed from: component3, reason: from getter */
    public final ConsentStatus getConsentStatus() {
        return this.consentStatus;
    }

    /* renamed from: component4, reason: from getter */
    public final GdprCS.CustomVendorsResponse getCustomVendorsResponse() {
        return this.customVendorsResponse;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDateCreated() {
        return this.dateCreated;
    }

    /* renamed from: component6, reason: from getter */
    public final String getEuconsent() {
        return this.euconsent;
    }

    public final Map<String, GDPRPurposeGrants> component7() {
        return this.grants;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getHasLocalData() {
        return this.hasLocalData;
    }

    /* renamed from: component9, reason: from getter */
    public final JsonElement getMessage() {
        return this.message;
    }

    public final GDPR copy(String addtlConsent, String childPmId, ConsentStatus consentStatus, GdprCS.CustomVendorsResponse customVendorsResponse, String dateCreated, String euconsent, Map<String, GDPRPurposeGrants> grants, Boolean hasLocalData, JsonElement message, MessageMetaData messageMetaData, Map<String, ? extends JsonElement> TCData, CampaignType type, String url, String expirationDate, JsonObject webConsentPayload, GoogleConsentMode googleConsentMode) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new GDPR(addtlConsent, childPmId, consentStatus, customVendorsResponse, dateCreated, euconsent, grants, hasLocalData, message, messageMetaData, TCData, type, url, expirationDate, webConsentPayload, googleConsentMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GDPR)) {
            return false;
        }
        GDPR gdpr = (GDPR) other;
        return Intrinsics.areEqual(this.addtlConsent, gdpr.addtlConsent) && Intrinsics.areEqual(this.childPmId, gdpr.childPmId) && Intrinsics.areEqual(this.consentStatus, gdpr.consentStatus) && Intrinsics.areEqual(this.customVendorsResponse, gdpr.customVendorsResponse) && Intrinsics.areEqual(this.dateCreated, gdpr.dateCreated) && Intrinsics.areEqual(this.euconsent, gdpr.euconsent) && Intrinsics.areEqual(this.grants, gdpr.grants) && Intrinsics.areEqual(this.hasLocalData, gdpr.hasLocalData) && Intrinsics.areEqual(this.message, gdpr.message) && Intrinsics.areEqual(this.messageMetaData, gdpr.messageMetaData) && Intrinsics.areEqual(this.TCData, gdpr.TCData) && this.type == gdpr.type && Intrinsics.areEqual(this.url, gdpr.url) && Intrinsics.areEqual(this.expirationDate, gdpr.expirationDate) && Intrinsics.areEqual(this.webConsentPayload, gdpr.webConsentPayload) && Intrinsics.areEqual(this.googleConsentMode, gdpr.googleConsentMode);
    }

    public int hashCode() {
        String str = this.addtlConsent;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.childPmId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ConsentStatus consentStatus = this.consentStatus;
        int hashCode3 = (hashCode2 + (consentStatus == null ? 0 : consentStatus.hashCode())) * 31;
        GdprCS.CustomVendorsResponse customVendorsResponse = this.customVendorsResponse;
        int hashCode4 = (hashCode3 + (customVendorsResponse == null ? 0 : customVendorsResponse.hashCode())) * 31;
        String str3 = this.dateCreated;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.euconsent;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Map<String, GDPRPurposeGrants> map = this.grants;
        int hashCode7 = (hashCode6 + (map == null ? 0 : map.hashCode())) * 31;
        Boolean bool = this.hasLocalData;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        JsonElement jsonElement = this.message;
        int hashCode9 = (hashCode8 + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        MessageMetaData messageMetaData = this.messageMetaData;
        int hashCode10 = (hashCode9 + (messageMetaData == null ? 0 : messageMetaData.hashCode())) * 31;
        Map<String, JsonElement> map2 = this.TCData;
        int hashCode11 = (((hashCode10 + (map2 == null ? 0 : map2.hashCode())) * 31) + this.type.hashCode()) * 31;
        String str5 = this.url;
        int hashCode12 = (hashCode11 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.expirationDate;
        int hashCode13 = (hashCode12 + (str6 == null ? 0 : str6.hashCode())) * 31;
        JsonObject jsonObject = this.webConsentPayload;
        int hashCode14 = (hashCode13 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
        GoogleConsentMode googleConsentMode = this.googleConsentMode;
        return hashCode14 + (googleConsentMode != null ? googleConsentMode.hashCode() : 0);
    }

    public String toString() {
        return "GDPR(addtlConsent=" + this.addtlConsent + ", childPmId=" + this.childPmId + ", consentStatus=" + this.consentStatus + ", customVendorsResponse=" + this.customVendorsResponse + ", dateCreated=" + this.dateCreated + ", euconsent=" + this.euconsent + ", grants=" + this.grants + ", hasLocalData=" + this.hasLocalData + ", message=" + this.message + ", messageMetaData=" + this.messageMetaData + ", TCData=" + this.TCData + ", type=" + this.type + ", url=" + this.url + ", expirationDate=" + this.expirationDate + ", webConsentPayload=" + this.webConsentPayload + ", googleConsentMode=" + this.googleConsentMode + ")";
    }

    /* compiled from: MessagesApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GDPR$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GDPR;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GDPR> serializer() {
            return GDPR$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ GDPR(int i, @SerialName("addtlConsent") String str, @SerialName("childPmId") String str2, @SerialName("consentStatus") ConsentStatus consentStatus, @SerialName("customVendorsResponse") GdprCS.CustomVendorsResponse customVendorsResponse, @SerialName("dateCreated") String str3, @SerialName("euconsent") String str4, @Serializable(with = GrantsSerializer.class) Map map, @SerialName("hasLocalData") Boolean bool, @SerialName("message") JsonElement jsonElement, @SerialName("messageMetaData") MessageMetaData messageMetaData, @Serializable(with = JsonMapSerializer.class) Map map2, @Serializable(with = CampaignTypeSerializer.class) CampaignType campaignType, @SerialName("url") String str5, @SerialName("expirationDate") String str6, @SerialName("webConsentPayload") JsonObject jsonObject, @SerialName("gcmStatus") GoogleConsentMode googleConsentMode, SerializationConstructorMarker serializationConstructorMarker) {
        if (65535 != (i & 65535)) {
            PluginExceptionsKt.throwMissingFieldException(i, 65535, GDPR$$serializer.INSTANCE.getDescriptor());
        }
        this.addtlConsent = str;
        this.childPmId = str2;
        this.consentStatus = consentStatus;
        this.customVendorsResponse = customVendorsResponse;
        this.dateCreated = str3;
        this.euconsent = str4;
        this.grants = map;
        this.hasLocalData = bool;
        this.message = jsonElement;
        this.messageMetaData = messageMetaData;
        this.TCData = map2;
        this.type = campaignType;
        this.url = str5;
        this.expirationDate = str6;
        this.webConsentPayload = jsonObject;
        this.googleConsentMode = googleConsentMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GDPR(String str, String str2, ConsentStatus consentStatus, GdprCS.CustomVendorsResponse customVendorsResponse, String str3, String str4, Map<String, GDPRPurposeGrants> map, Boolean bool, JsonElement jsonElement, MessageMetaData messageMetaData, Map<String, ? extends JsonElement> map2, CampaignType type, String str5, String str6, JsonObject jsonObject, GoogleConsentMode googleConsentMode) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.addtlConsent = str;
        this.childPmId = str2;
        this.consentStatus = consentStatus;
        this.customVendorsResponse = customVendorsResponse;
        this.dateCreated = str3;
        this.euconsent = str4;
        this.grants = map;
        this.hasLocalData = bool;
        this.message = jsonElement;
        this.messageMetaData = messageMetaData;
        this.TCData = map2;
        this.type = type;
        this.url = str5;
        this.expirationDate = str6;
        this.webConsentPayload = jsonObject;
        this.googleConsentMode = googleConsentMode;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(GDPR self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.addtlConsent);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.childPmId);
        output.encodeNullableSerializableElement(serialDesc, 2, ConsentStatus$$serializer.INSTANCE, self.consentStatus);
        output.encodeNullableSerializableElement(serialDesc, 3, GdprCS$CustomVendorsResponse$$serializer.INSTANCE, self.customVendorsResponse);
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.getDateCreated());
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.euconsent);
        output.encodeNullableSerializableElement(serialDesc, 6, GrantsSerializer.INSTANCE, self.grants);
        output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.hasLocalData);
        output.encodeNullableSerializableElement(serialDesc, 8, JsonElementSerializer.INSTANCE, self.getMessage());
        output.encodeNullableSerializableElement(serialDesc, 9, MessageMetaData$$serializer.INSTANCE, self.getMessageMetaData());
        output.encodeNullableSerializableElement(serialDesc, 10, JsonMapSerializer.INSTANCE, self.TCData);
        output.encodeSerializableElement(serialDesc, 11, CampaignTypeSerializer.INSTANCE, self.getType());
        output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.getUrl());
        output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.getExpirationDate());
        output.encodeNullableSerializableElement(serialDesc, 14, JsonObjectSerializer.INSTANCE, self.webConsentPayload);
        output.encodeNullableSerializableElement(serialDesc, 15, GoogleConsentMode$$serializer.INSTANCE, self.googleConsentMode);
    }

    public final String getAddtlConsent() {
        return this.addtlConsent;
    }

    public final String getChildPmId() {
        return this.childPmId;
    }

    public final ConsentStatus getConsentStatus() {
        return this.consentStatus;
    }

    public final GdprCS.CustomVendorsResponse getCustomVendorsResponse() {
        return this.customVendorsResponse;
    }

    @Override // com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage
    public String getDateCreated() {
        return this.dateCreated;
    }

    public final String getEuconsent() {
        return this.euconsent;
    }

    public final Map<String, GDPRPurposeGrants> getGrants() {
        return this.grants;
    }

    public final Boolean getHasLocalData() {
        return this.hasLocalData;
    }

    @Override // com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage
    public JsonElement getMessage() {
        return this.message;
    }

    @Override // com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage
    public MessageMetaData getMessageMetaData() {
        return this.messageMetaData;
    }

    public final Map<String, JsonElement> getTCData() {
        return this.TCData;
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

    public final JsonObject getWebConsentPayload() {
        return this.webConsentPayload;
    }

    public final GoogleConsentMode getGoogleConsentMode() {
        return this.googleConsentMode;
    }

    public final void setGoogleConsentMode(GoogleConsentMode googleConsentMode) {
        this.googleConsentMode = googleConsentMode;
    }
}
