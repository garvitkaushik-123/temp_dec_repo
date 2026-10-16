package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.sourcepoint.cmplibrary.data.network.converter.CampaignTypeSerializer;
import com.sourcepoint.cmplibrary.data.network.converter.CcpaStatusSerializer;
import com.sourcepoint.cmplibrary.data.network.converter.JsonMapSerializer;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.CcpaStatus;
import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 l2\u00020\u0001:\u0002klBñ\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f\u0012\u0010\b\u0001\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0001\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010\u001fB¿\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010 J\u0010\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010M\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010P\u001a\u00020\u0018HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fHÆ\u0003J\u0011\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fHÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$Jä\u0001\u0010\\\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010]J\u0013\u0010^\u001a\u00020\u00052\b\u0010_\u001a\u0004\u0018\u00010`HÖ\u0003J\t\u0010a\u001a\u00020\u0003HÖ\u0001J\t\u0010b\u001a\u00020\u0007HÖ\u0001J&\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u00002\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020iHÁ\u0001¢\u0006\u0002\bjR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\"\u001a\u0004\b'\u0010(R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\"\u001a\u0004\b*\u0010(R*\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\"\u001a\u0004\b,\u0010-R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\"\u001a\u0004\b/\u00100R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\"\u001a\u0004\b2\u00103R \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b4\u0010\"\u001a\u0004\b5\u0010$R \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b6\u0010\"\u001a\u0004\b7\u0010$R$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\"\u001a\u0004\b9\u0010:R$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010\"\u001a\u0004\b<\u0010:R \u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b=\u0010\"\u001a\u0004\b>\u0010$R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010\"\u001a\u0004\b@\u0010AR\u001c\u0010\u0017\u001a\u00020\u00188\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010\"\u001a\u0004\bC\u0010DR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010\"\u001a\u0004\bF\u0010(R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010\"\u001a\u0004\bH\u0010(R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010\"\u001a\u0004\bJ\u0010K¨\u0006m"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CCPA;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CampaignMessage;", "seen1", "", "consentedAll", "", "dateCreated", "", PglCryptUtils.KEY_MESSAGE, "Lkotlinx/serialization/json/JsonElement;", "messageMetaData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "newUser", "rejectedAll", "rejectedCategories", "", "rejectedVendors", "signedLspa", "uspstring", "gppData", "", "status", "Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;", "type", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "url", "webConsentPayload", "Lkotlinx/serialization/json/JsonObject;", "expirationDate", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Map;Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Map;Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)V", "getConsentedAll$annotations", "()V", "getConsentedAll", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDateCreated$annotations", "getDateCreated", "()Ljava/lang/String;", "getExpirationDate$annotations", "getExpirationDate", "getGppData$annotations", "getGppData", "()Ljava/util/Map;", "getMessage$annotations", "getMessage", "()Lkotlinx/serialization/json/JsonElement;", "getMessageMetaData$annotations", "getMessageMetaData", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "getNewUser$annotations", "getNewUser", "getRejectedAll$annotations", "getRejectedAll", "getRejectedCategories$annotations", "getRejectedCategories", "()Ljava/util/List;", "getRejectedVendors$annotations", "getRejectedVendors", "getSignedLspa$annotations", "getSignedLspa", "getStatus$annotations", "getStatus", "()Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;", "getType$annotations", "getType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getUrl$annotations", "getUrl", "getUspstring$annotations", "getUspstring", "getWebConsentPayload$annotations", "getWebConsentPayload", "()Lkotlinx/serialization/json/JsonObject;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Map;Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CCPA;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class CCPA implements CampaignMessage {
    private final Boolean consentedAll;
    private final String dateCreated;
    private final String expirationDate;
    private final Map<String, JsonElement> gppData;
    private final JsonElement message;
    private final MessageMetaData messageMetaData;
    private final Boolean newUser;
    private final Boolean rejectedAll;
    private final List<String> rejectedCategories;
    private final List<String> rejectedVendors;
    private final Boolean signedLspa;
    private final CcpaStatus status;
    private final CampaignType type;
    private final String url;
    private final String uspstring;
    private final JsonObject webConsentPayload;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, null, null, null, null};

    public static /* synthetic */ CCPA copy$default(CCPA ccpa, Boolean bool, String str, JsonElement jsonElement, MessageMetaData messageMetaData, Boolean bool2, Boolean bool3, List list, List list2, Boolean bool4, String str2, Map map, CcpaStatus ccpaStatus, CampaignType campaignType, String str3, JsonObject jsonObject, String str4, int i, Object obj) {
        Boolean bool5 = (i & 1) != 0 ? ccpa.consentedAll : bool;
        return ccpa.copy(bool5, (i & 2) != 0 ? ccpa.dateCreated : str, (i & 4) != 0 ? ccpa.message : jsonElement, (i & 8) != 0 ? ccpa.messageMetaData : messageMetaData, (i & 16) != 0 ? ccpa.newUser : bool2, (i & 32) != 0 ? ccpa.rejectedAll : bool3, (i & 64) != 0 ? ccpa.rejectedCategories : list, (i & 128) != 0 ? ccpa.rejectedVendors : list2, (i & 256) != 0 ? ccpa.signedLspa : bool4, (i & 512) != 0 ? ccpa.uspstring : str2, (i & 1024) != 0 ? ccpa.gppData : map, (i & 2048) != 0 ? ccpa.status : ccpaStatus, (i & 4096) != 0 ? ccpa.type : campaignType, (i & 8192) != 0 ? ccpa.url : str3, (i & 16384) != 0 ? ccpa.webConsentPayload : jsonObject, (i & 32768) != 0 ? ccpa.expirationDate : str4);
    }

    @SerialName("consentedAll")
    public static /* synthetic */ void getConsentedAll$annotations() {
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

    @SerialName("newUser")
    public static /* synthetic */ void getNewUser$annotations() {
    }

    @SerialName("rejectedAll")
    public static /* synthetic */ void getRejectedAll$annotations() {
    }

    @SerialName("rejectedCategories")
    public static /* synthetic */ void getRejectedCategories$annotations() {
    }

    @SerialName("rejectedVendors")
    public static /* synthetic */ void getRejectedVendors$annotations() {
    }

    @SerialName("signedLspa")
    public static /* synthetic */ void getSignedLspa$annotations() {
    }

    @Serializable(with = CcpaStatusSerializer.class)
    public static /* synthetic */ void getStatus$annotations() {
    }

    @Serializable(with = CampaignTypeSerializer.class)
    public static /* synthetic */ void getType$annotations() {
    }

    @SerialName("url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    @SerialName("uspstring")
    public static /* synthetic */ void getUspstring$annotations() {
    }

    @SerialName("webConsentPayload")
    public static /* synthetic */ void getWebConsentPayload$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getConsentedAll() {
        return this.consentedAll;
    }

    /* renamed from: component10, reason: from getter */
    public final String getUspstring() {
        return this.uspstring;
    }

    public final Map<String, JsonElement> component11() {
        return this.gppData;
    }

    /* renamed from: component12, reason: from getter */
    public final CcpaStatus getStatus() {
        return this.status;
    }

    /* renamed from: component13, reason: from getter */
    public final CampaignType getType() {
        return this.type;
    }

    /* renamed from: component14, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component15, reason: from getter */
    public final JsonObject getWebConsentPayload() {
        return this.webConsentPayload;
    }

    /* renamed from: component16, reason: from getter */
    public final String getExpirationDate() {
        return this.expirationDate;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDateCreated() {
        return this.dateCreated;
    }

    /* renamed from: component3, reason: from getter */
    public final JsonElement getMessage() {
        return this.message;
    }

    /* renamed from: component4, reason: from getter */
    public final MessageMetaData getMessageMetaData() {
        return this.messageMetaData;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getNewUser() {
        return this.newUser;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getRejectedAll() {
        return this.rejectedAll;
    }

    public final List<String> component7() {
        return this.rejectedCategories;
    }

    public final List<String> component8() {
        return this.rejectedVendors;
    }

    /* renamed from: component9, reason: from getter */
    public final Boolean getSignedLspa() {
        return this.signedLspa;
    }

    public final CCPA copy(Boolean consentedAll, String dateCreated, JsonElement message, MessageMetaData messageMetaData, Boolean newUser, Boolean rejectedAll, List<String> rejectedCategories, List<String> rejectedVendors, Boolean signedLspa, String uspstring, Map<String, ? extends JsonElement> gppData, CcpaStatus status, CampaignType type, String url, JsonObject webConsentPayload, String expirationDate) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new CCPA(consentedAll, dateCreated, message, messageMetaData, newUser, rejectedAll, rejectedCategories, rejectedVendors, signedLspa, uspstring, gppData, status, type, url, webConsentPayload, expirationDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CCPA)) {
            return false;
        }
        CCPA ccpa = (CCPA) other;
        return Intrinsics.areEqual(this.consentedAll, ccpa.consentedAll) && Intrinsics.areEqual(this.dateCreated, ccpa.dateCreated) && Intrinsics.areEqual(this.message, ccpa.message) && Intrinsics.areEqual(this.messageMetaData, ccpa.messageMetaData) && Intrinsics.areEqual(this.newUser, ccpa.newUser) && Intrinsics.areEqual(this.rejectedAll, ccpa.rejectedAll) && Intrinsics.areEqual(this.rejectedCategories, ccpa.rejectedCategories) && Intrinsics.areEqual(this.rejectedVendors, ccpa.rejectedVendors) && Intrinsics.areEqual(this.signedLspa, ccpa.signedLspa) && Intrinsics.areEqual(this.uspstring, ccpa.uspstring) && Intrinsics.areEqual(this.gppData, ccpa.gppData) && this.status == ccpa.status && this.type == ccpa.type && Intrinsics.areEqual(this.url, ccpa.url) && Intrinsics.areEqual(this.webConsentPayload, ccpa.webConsentPayload) && Intrinsics.areEqual(this.expirationDate, ccpa.expirationDate);
    }

    public int hashCode() {
        Boolean bool = this.consentedAll;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.dateCreated;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        JsonElement jsonElement = this.message;
        int hashCode3 = (hashCode2 + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        MessageMetaData messageMetaData = this.messageMetaData;
        int hashCode4 = (hashCode3 + (messageMetaData == null ? 0 : messageMetaData.hashCode())) * 31;
        Boolean bool2 = this.newUser;
        int hashCode5 = (hashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.rejectedAll;
        int hashCode6 = (hashCode5 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        List<String> list = this.rejectedCategories;
        int hashCode7 = (hashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.rejectedVendors;
        int hashCode8 = (hashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Boolean bool4 = this.signedLspa;
        int hashCode9 = (hashCode8 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        String str2 = this.uspstring;
        int hashCode10 = (hashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, JsonElement> map = this.gppData;
        int hashCode11 = (hashCode10 + (map == null ? 0 : map.hashCode())) * 31;
        CcpaStatus ccpaStatus = this.status;
        int hashCode12 = (((hashCode11 + (ccpaStatus == null ? 0 : ccpaStatus.hashCode())) * 31) + this.type.hashCode()) * 31;
        String str3 = this.url;
        int hashCode13 = (hashCode12 + (str3 == null ? 0 : str3.hashCode())) * 31;
        JsonObject jsonObject = this.webConsentPayload;
        int hashCode14 = (hashCode13 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
        String str4 = this.expirationDate;
        return hashCode14 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "CCPA(consentedAll=" + this.consentedAll + ", dateCreated=" + this.dateCreated + ", message=" + this.message + ", messageMetaData=" + this.messageMetaData + ", newUser=" + this.newUser + ", rejectedAll=" + this.rejectedAll + ", rejectedCategories=" + this.rejectedCategories + ", rejectedVendors=" + this.rejectedVendors + ", signedLspa=" + this.signedLspa + ", uspstring=" + this.uspstring + ", gppData=" + this.gppData + ", status=" + this.status + ", type=" + this.type + ", url=" + this.url + ", webConsentPayload=" + this.webConsentPayload + ", expirationDate=" + this.expirationDate + ")";
    }

    /* compiled from: MessagesApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CCPA$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CCPA;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CCPA> serializer() {
            return CCPA$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CCPA(int i, @SerialName("consentedAll") Boolean bool, @SerialName("dateCreated") String str, @SerialName("message") JsonElement jsonElement, @SerialName("messageMetaData") MessageMetaData messageMetaData, @SerialName("newUser") Boolean bool2, @SerialName("rejectedAll") Boolean bool3, @SerialName("rejectedCategories") List list, @SerialName("rejectedVendors") List list2, @SerialName("signedLspa") Boolean bool4, @SerialName("uspstring") String str2, @SerialName("GPPData") @Serializable(with = JsonMapSerializer.class) Map map, @Serializable(with = CcpaStatusSerializer.class) CcpaStatus ccpaStatus, @Serializable(with = CampaignTypeSerializer.class) CampaignType campaignType, @SerialName("url") String str3, @SerialName("webConsentPayload") JsonObject jsonObject, @SerialName("expirationDate") String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (63999 != (i & 63999)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63999, CCPA$$serializer.INSTANCE.getDescriptor());
        }
        this.consentedAll = bool;
        this.dateCreated = str;
        this.message = jsonElement;
        this.messageMetaData = messageMetaData;
        this.newUser = bool2;
        this.rejectedAll = bool3;
        this.rejectedCategories = list;
        this.rejectedVendors = list2;
        this.signedLspa = bool4;
        if ((i & 512) == 0) {
            this.uspstring = null;
        } else {
            this.uspstring = str2;
        }
        if ((i & 1024) == 0) {
            this.gppData = null;
        } else {
            this.gppData = map;
        }
        this.status = ccpaStatus;
        this.type = campaignType;
        this.url = str3;
        this.webConsentPayload = jsonObject;
        this.expirationDate = str4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CCPA(Boolean bool, String str, JsonElement jsonElement, MessageMetaData messageMetaData, Boolean bool2, Boolean bool3, List<String> list, List<String> list2, Boolean bool4, String str2, Map<String, ? extends JsonElement> map, CcpaStatus ccpaStatus, CampaignType type, String str3, JsonObject jsonObject, String str4) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.consentedAll = bool;
        this.dateCreated = str;
        this.message = jsonElement;
        this.messageMetaData = messageMetaData;
        this.newUser = bool2;
        this.rejectedAll = bool3;
        this.rejectedCategories = list;
        this.rejectedVendors = list2;
        this.signedLspa = bool4;
        this.uspstring = str2;
        this.gppData = map;
        this.status = ccpaStatus;
        this.type = type;
        this.url = str3;
        this.webConsentPayload = jsonObject;
        this.expirationDate = str4;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(CCPA self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.consentedAll);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getDateCreated());
        output.encodeNullableSerializableElement(serialDesc, 2, JsonElementSerializer.INSTANCE, self.getMessage());
        output.encodeNullableSerializableElement(serialDesc, 3, MessageMetaData$$serializer.INSTANCE, self.getMessageMetaData());
        output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.newUser);
        output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.rejectedAll);
        output.encodeNullableSerializableElement(serialDesc, 6, kSerializerArr[6], self.rejectedCategories);
        output.encodeNullableSerializableElement(serialDesc, 7, kSerializerArr[7], self.rejectedVendors);
        output.encodeNullableSerializableElement(serialDesc, 8, BooleanSerializer.INSTANCE, self.signedLspa);
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.uspstring != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.uspstring);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.gppData != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, JsonMapSerializer.INSTANCE, self.gppData);
        }
        output.encodeNullableSerializableElement(serialDesc, 11, CcpaStatusSerializer.INSTANCE, self.status);
        output.encodeSerializableElement(serialDesc, 12, CampaignTypeSerializer.INSTANCE, self.getType());
        output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.getUrl());
        output.encodeNullableSerializableElement(serialDesc, 14, JsonObjectSerializer.INSTANCE, self.webConsentPayload);
        output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.getExpirationDate());
    }

    public /* synthetic */ CCPA(Boolean bool, String str, JsonElement jsonElement, MessageMetaData messageMetaData, Boolean bool2, Boolean bool3, List list, List list2, Boolean bool4, String str2, Map map, CcpaStatus ccpaStatus, CampaignType campaignType, String str3, JsonObject jsonObject, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, str, jsonElement, messageMetaData, bool2, bool3, list, list2, bool4, (i & 512) != 0 ? null : str2, (i & 1024) != 0 ? null : map, ccpaStatus, campaignType, str3, jsonObject, str4);
    }

    public final Boolean getConsentedAll() {
        return this.consentedAll;
    }

    @Override // com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage
    public String getDateCreated() {
        return this.dateCreated;
    }

    @Override // com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage
    public JsonElement getMessage() {
        return this.message;
    }

    @Override // com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage
    public MessageMetaData getMessageMetaData() {
        return this.messageMetaData;
    }

    public final Boolean getNewUser() {
        return this.newUser;
    }

    public final Boolean getRejectedAll() {
        return this.rejectedAll;
    }

    public final List<String> getRejectedCategories() {
        return this.rejectedCategories;
    }

    public final List<String> getRejectedVendors() {
        return this.rejectedVendors;
    }

    public final Boolean getSignedLspa() {
        return this.signedLspa;
    }

    public final String getUspstring() {
        return this.uspstring;
    }

    public final Map<String, JsonElement> getGppData() {
        return this.gppData;
    }

    public final CcpaStatus getStatus() {
        return this.status;
    }

    @Override // com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage
    public CampaignType getType() {
        return this.type;
    }

    @Override // com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage
    public String getUrl() {
        return this.url;
    }

    public final JsonObject getWebConsentPayload() {
        return this.webConsentPayload;
    }

    @Override // com.sourcepoint.cmplibrary.data.network.model.optimized.CampaignMessage
    public String getExpirationDate() {
        return this.expirationDate;
    }
}
