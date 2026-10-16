package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.data.network.converter.CcpaStatusSerializer;
import com.sourcepoint.cmplibrary.data.network.converter.JsonMapSerializer;
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
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: ConsentStatusApiModel.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 d2\u00020\u0001:\u0002cdBã\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r\u0012\u0010\b\u0001\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0016\b\u0001\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cB¹\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u001dJ\u0010\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010G\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0017\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010N\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\rHÆ\u0003J\u0011\u0010S\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\rHÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJÚ\u0001\u0010U\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010VJ\u0013\u0010W\u001a\u00020\u00052\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Y\u001a\u00020\u0003HÖ\u0001J\t\u0010Z\u001a\u00020\bHÖ\u0001J&\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aHÁ\u0001¢\u0006\u0002\bbR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010 \u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u001fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\"\u001a\u0004\b%\u0010&R&\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\"\u001a\u0004\b(\u0010&\"\u0004\b)\u0010*R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010 \u0012\u0004\b+\u0010\"\u001a\u0004\b,\u0010\u001fR*\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\"\u001a\u0004\b.\u0010/R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010 \u0012\u0004\b0\u0010\"\u001a\u0004\b1\u0010\u001fR \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010 \u0012\u0004\b2\u0010\"\u001a\u0004\b3\u0010\u001fR$\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\"\u001a\u0004\b5\u00106R$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\"\u001a\u0004\b8\u00106R \u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010 \u0012\u0004\b9\u0010\"\u001a\u0004\b:\u0010\u001fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010\"\u001a\u0004\b<\u0010=R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010\"\u001a\u0004\b?\u0010&R&\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b@\u0010\"\u001a\u0004\bA\u0010&\"\u0004\bB\u0010*R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010\"\u001a\u0004\bD\u0010E¨\u0006e"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "", "seen1", "", "applies", "", "consentedAll", "dateCreated", "", "gpcEnabled", "newUser", "rejectedAll", "rejectedCategories", "", "rejectedVendors", "signedLspa", "uspstring", "status", "Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;", "gppData", "", "Lkotlinx/serialization/json/JsonElement;", "uuid", "webConsentPayload", "Lkotlinx/serialization/json/JsonObject;", "expirationDate", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;Ljava/util/Map;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;Ljava/util/Map;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)V", "getApplies", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getConsentedAll$annotations", "()V", "getConsentedAll", "getDateCreated$annotations", "getDateCreated", "()Ljava/lang/String;", "getExpirationDate$annotations", "getExpirationDate", "setExpirationDate", "(Ljava/lang/String;)V", "getGpcEnabled$annotations", "getGpcEnabled", "getGppData$annotations", "getGppData", "()Ljava/util/Map;", "getNewUser$annotations", "getNewUser", "getRejectedAll$annotations", "getRejectedAll", "getRejectedCategories$annotations", "getRejectedCategories", "()Ljava/util/List;", "getRejectedVendors$annotations", "getRejectedVendors", "getSignedLspa$annotations", "getSignedLspa", "getStatus$annotations", "getStatus", "()Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;", "getUspstring$annotations", "getUspstring", "getUuid$annotations", "getUuid", "setUuid", "getWebConsentPayload$annotations", "getWebConsentPayload", "()Lkotlinx/serialization/json/JsonObject;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;Ljava/util/Map;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class CcpaCS {
    private final Boolean applies;
    private final Boolean consentedAll;
    private final String dateCreated;
    private String expirationDate;
    private final Boolean gpcEnabled;
    private final Map<String, JsonElement> gppData;
    private final Boolean newUser;
    private final Boolean rejectedAll;
    private final List<String> rejectedCategories;
    private final List<String> rejectedVendors;
    private final Boolean signedLspa;
    private final CcpaStatus status;
    private final String uspstring;
    private String uuid;
    private final JsonObject webConsentPayload;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, null, null, null};

    @SerialName("consentedAll")
    public static /* synthetic */ void getConsentedAll$annotations() {
    }

    @SerialName("dateCreated")
    public static /* synthetic */ void getDateCreated$annotations() {
    }

    @SerialName("expirationDate")
    public static /* synthetic */ void getExpirationDate$annotations() {
    }

    @SerialName("gpcEnabled")
    public static /* synthetic */ void getGpcEnabled$annotations() {
    }

    @SerialName("GPPData")
    @Serializable(with = JsonMapSerializer.class)
    public static /* synthetic */ void getGppData$annotations() {
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

    @SerialName("uspstring")
    public static /* synthetic */ void getUspstring$annotations() {
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
    public final String getUspstring() {
        return this.uspstring;
    }

    /* renamed from: component11, reason: from getter */
    public final CcpaStatus getStatus() {
        return this.status;
    }

    public final Map<String, JsonElement> component12() {
        return this.gppData;
    }

    /* renamed from: component13, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component14, reason: from getter */
    public final JsonObject getWebConsentPayload() {
        return this.webConsentPayload;
    }

    /* renamed from: component15, reason: from getter */
    public final String getExpirationDate() {
        return this.expirationDate;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getConsentedAll() {
        return this.consentedAll;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDateCreated() {
        return this.dateCreated;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getGpcEnabled() {
        return this.gpcEnabled;
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

    public final CcpaCS copy(Boolean applies, Boolean consentedAll, String dateCreated, Boolean gpcEnabled, Boolean newUser, Boolean rejectedAll, List<String> rejectedCategories, List<String> rejectedVendors, Boolean signedLspa, String uspstring, CcpaStatus status, Map<String, ? extends JsonElement> gppData, String uuid, JsonObject webConsentPayload, String expirationDate) {
        return new CcpaCS(applies, consentedAll, dateCreated, gpcEnabled, newUser, rejectedAll, rejectedCategories, rejectedVendors, signedLspa, uspstring, status, gppData, uuid, webConsentPayload, expirationDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CcpaCS)) {
            return false;
        }
        CcpaCS ccpaCS = (CcpaCS) other;
        return Intrinsics.areEqual(this.applies, ccpaCS.applies) && Intrinsics.areEqual(this.consentedAll, ccpaCS.consentedAll) && Intrinsics.areEqual(this.dateCreated, ccpaCS.dateCreated) && Intrinsics.areEqual(this.gpcEnabled, ccpaCS.gpcEnabled) && Intrinsics.areEqual(this.newUser, ccpaCS.newUser) && Intrinsics.areEqual(this.rejectedAll, ccpaCS.rejectedAll) && Intrinsics.areEqual(this.rejectedCategories, ccpaCS.rejectedCategories) && Intrinsics.areEqual(this.rejectedVendors, ccpaCS.rejectedVendors) && Intrinsics.areEqual(this.signedLspa, ccpaCS.signedLspa) && Intrinsics.areEqual(this.uspstring, ccpaCS.uspstring) && this.status == ccpaCS.status && Intrinsics.areEqual(this.gppData, ccpaCS.gppData) && Intrinsics.areEqual(this.uuid, ccpaCS.uuid) && Intrinsics.areEqual(this.webConsentPayload, ccpaCS.webConsentPayload) && Intrinsics.areEqual(this.expirationDate, ccpaCS.expirationDate);
    }

    public int hashCode() {
        Boolean bool = this.applies;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.consentedAll;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str = this.dateCreated;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool3 = this.gpcEnabled;
        int hashCode4 = (hashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.newUser;
        int hashCode5 = (hashCode4 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.rejectedAll;
        int hashCode6 = (hashCode5 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        List<String> list = this.rejectedCategories;
        int hashCode7 = (hashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.rejectedVendors;
        int hashCode8 = (hashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Boolean bool6 = this.signedLspa;
        int hashCode9 = (hashCode8 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        String str2 = this.uspstring;
        int hashCode10 = (hashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
        CcpaStatus ccpaStatus = this.status;
        int hashCode11 = (hashCode10 + (ccpaStatus == null ? 0 : ccpaStatus.hashCode())) * 31;
        Map<String, JsonElement> map = this.gppData;
        int hashCode12 = (hashCode11 + (map == null ? 0 : map.hashCode())) * 31;
        String str3 = this.uuid;
        int hashCode13 = (hashCode12 + (str3 == null ? 0 : str3.hashCode())) * 31;
        JsonObject jsonObject = this.webConsentPayload;
        int hashCode14 = (hashCode13 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
        String str4 = this.expirationDate;
        return hashCode14 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "CcpaCS(applies=" + this.applies + ", consentedAll=" + this.consentedAll + ", dateCreated=" + this.dateCreated + ", gpcEnabled=" + this.gpcEnabled + ", newUser=" + this.newUser + ", rejectedAll=" + this.rejectedAll + ", rejectedCategories=" + this.rejectedCategories + ", rejectedVendors=" + this.rejectedVendors + ", signedLspa=" + this.signedLspa + ", uspstring=" + this.uspstring + ", status=" + this.status + ", gppData=" + this.gppData + ", uuid=" + this.uuid + ", webConsentPayload=" + this.webConsentPayload + ", expirationDate=" + this.expirationDate + ")";
    }

    /* compiled from: ConsentStatusApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CcpaCS> serializer() {
            return CcpaCS$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CcpaCS(int i, Boolean bool, @SerialName("consentedAll") Boolean bool2, @SerialName("dateCreated") String str, @SerialName("gpcEnabled") Boolean bool3, @SerialName("newUser") Boolean bool4, @SerialName("rejectedAll") Boolean bool5, @SerialName("rejectedCategories") List list, @SerialName("rejectedVendors") List list2, @SerialName("signedLspa") Boolean bool6, @SerialName("uspstring") String str2, @Serializable(with = CcpaStatusSerializer.class) CcpaStatus ccpaStatus, @SerialName("GPPData") @Serializable(with = JsonMapSerializer.class) Map map, @SerialName("uuid") String str3, @SerialName("webConsentPayload") JsonObject jsonObject, @SerialName("expirationDate") String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (22015 != (i & 22015)) {
            PluginExceptionsKt.throwMissingFieldException(i, 22015, CcpaCS$$serializer.INSTANCE.getDescriptor());
        }
        this.applies = bool;
        this.consentedAll = bool2;
        this.dateCreated = str;
        this.gpcEnabled = bool3;
        this.newUser = bool4;
        this.rejectedAll = bool5;
        this.rejectedCategories = list;
        this.rejectedVendors = list2;
        this.signedLspa = bool6;
        if ((i & 512) == 0) {
            this.uspstring = null;
        } else {
            this.uspstring = str2;
        }
        this.status = ccpaStatus;
        if ((i & 2048) == 0) {
            this.gppData = null;
        } else {
            this.gppData = map;
        }
        this.uuid = str3;
        if ((i & 8192) == 0) {
            this.webConsentPayload = null;
        } else {
            this.webConsentPayload = jsonObject;
        }
        this.expirationDate = str4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CcpaCS(Boolean bool, Boolean bool2, String str, Boolean bool3, Boolean bool4, Boolean bool5, List<String> list, List<String> list2, Boolean bool6, String str2, CcpaStatus ccpaStatus, Map<String, ? extends JsonElement> map, String str3, JsonObject jsonObject, String str4) {
        this.applies = bool;
        this.consentedAll = bool2;
        this.dateCreated = str;
        this.gpcEnabled = bool3;
        this.newUser = bool4;
        this.rejectedAll = bool5;
        this.rejectedCategories = list;
        this.rejectedVendors = list2;
        this.signedLspa = bool6;
        this.uspstring = str2;
        this.status = ccpaStatus;
        this.gppData = map;
        this.uuid = str3;
        this.webConsentPayload = jsonObject;
        this.expirationDate = str4;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(CcpaCS self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.applies);
        output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.consentedAll);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.dateCreated);
        output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.gpcEnabled);
        output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.newUser);
        output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.rejectedAll);
        output.encodeNullableSerializableElement(serialDesc, 6, kSerializerArr[6], self.rejectedCategories);
        output.encodeNullableSerializableElement(serialDesc, 7, kSerializerArr[7], self.rejectedVendors);
        output.encodeNullableSerializableElement(serialDesc, 8, BooleanSerializer.INSTANCE, self.signedLspa);
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.uspstring != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.uspstring);
        }
        output.encodeNullableSerializableElement(serialDesc, 10, CcpaStatusSerializer.INSTANCE, self.status);
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.gppData != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, JsonMapSerializer.INSTANCE, self.gppData);
        }
        output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.uuid);
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.webConsentPayload != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, JsonObjectSerializer.INSTANCE, self.webConsentPayload);
        }
        output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.expirationDate);
    }

    public /* synthetic */ CcpaCS(Boolean bool, Boolean bool2, String str, Boolean bool3, Boolean bool4, Boolean bool5, List list, List list2, Boolean bool6, String str2, CcpaStatus ccpaStatus, Map map, String str3, JsonObject jsonObject, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, bool2, str, bool3, bool4, bool5, list, list2, bool6, (i & 512) != 0 ? null : str2, ccpaStatus, (i & 2048) != 0 ? null : map, str3, (i & 8192) != 0 ? null : jsonObject, str4);
    }

    public final Boolean getApplies() {
        return this.applies;
    }

    public final Boolean getConsentedAll() {
        return this.consentedAll;
    }

    public final String getDateCreated() {
        return this.dateCreated;
    }

    public final Boolean getGpcEnabled() {
        return this.gpcEnabled;
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

    public final CcpaStatus getStatus() {
        return this.status;
    }

    public final Map<String, JsonElement> getGppData() {
        return this.gppData;
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

    public final String getExpirationDate() {
        return this.expirationDate;
    }

    public final void setExpirationDate(String str) {
        this.expirationDate = str;
    }
}
