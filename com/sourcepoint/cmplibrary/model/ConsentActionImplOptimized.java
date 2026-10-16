package com.sourcepoint.cmplibrary.model;

import com.sourcepoint.cmplibrary.data.network.converter.ActionTypeSerializer;
import com.sourcepoint.cmplibrary.data.network.converter.CampaignTypeSerializer;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.ActionType;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;
import org.json.JSONObject;

/* compiled from: ConsentActionImplOptimized.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ^2\u00020\u0001:\u0002]^B³\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018B\u008b\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0019J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0011HÆ\u0003J\t\u0010D\u001a\u00020\u0013HÆ\u0003J\t\u0010E\u001a\u00020\u0013HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010J\u001a\u00020\u000bHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u009b\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010P\u001a\u00020\u00112\b\u0010Q\u001a\u0004\u0018\u00010RHÖ\u0003J\t\u0010S\u001a\u00020\u0003HÖ\u0001J\t\u0010T\u001a\u00020\u0007HÖ\u0001J&\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u00002\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[HÁ\u0001¢\u0006\u0002\b\\R\u001c\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010#R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010#R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010#R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010 R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001b\u001a\u0004\b+\u0010#R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010#R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010#R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001b\u001a\u0004\b1\u0010#R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u001b\u001a\u0004\b3\u0010#R\u0014\u00104\u001a\u0002058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001c\u0010\u0014\u001a\u00020\u00138\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\u001b\u001a\u0004\b9\u0010:R\u001c\u0010\u0010\u001a\u00020\u00118\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010\u001b\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\u0002058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u00107R\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010\u001b\u001a\u0004\bA\u0010:¨\u0006_"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/ConsentActionImplOptimized;", "Lcom/sourcepoint/cmplibrary/model/ConsentAction;", "seen1", "", "actionType", "Lcom/sourcepoint/cmplibrary/model/exposed/ActionType;", "choiceId", "", "consentLanguage", "customActionId", "legislation", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "localPmId", "name", "pmId", "pmTab", "requestFromPm", "", "saveAndExitVariablesOptimized", "Lkotlinx/serialization/json/JsonObject;", "pubData2", "privacyManagerId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/sourcepoint/cmplibrary/model/exposed/ActionType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/sourcepoint/cmplibrary/model/exposed/ActionType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)V", "getActionType$annotations", "()V", "getActionType", "()Lcom/sourcepoint/cmplibrary/model/exposed/ActionType;", "campaignType", "getCampaignType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getChoiceId$annotations", "getChoiceId", "()Ljava/lang/String;", "getConsentLanguage$annotations", "getConsentLanguage", "getCustomActionId$annotations", "getCustomActionId", "getLegislation$annotations", "getLegislation", "getLocalPmId$annotations", "getLocalPmId", "getName$annotations", "getName", "getPmId$annotations", "getPmId", "getPmTab$annotations", "getPmTab", "getPrivacyManagerId$annotations", "getPrivacyManagerId", "pubData", "Lorg/json/JSONObject;", "getPubData", "()Lorg/json/JSONObject;", "getPubData2$annotations", "getPubData2", "()Lkotlinx/serialization/json/JsonObject;", "getRequestFromPm$annotations", "getRequestFromPm", "()Z", "saveAndExitVariables", "getSaveAndExitVariables", "getSaveAndExitVariablesOptimized$annotations", "getSaveAndExitVariablesOptimized", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class ConsentActionImplOptimized implements ConsentAction {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ActionType actionType;
    private final String choiceId;
    private final String consentLanguage;
    private final String customActionId;
    private final CampaignType legislation;
    private final String localPmId;
    private final String name;
    private final String pmId;
    private final String pmTab;
    private final String privacyManagerId;
    private final JsonObject pubData2;
    private final boolean requestFromPm;
    private final JsonObject saveAndExitVariablesOptimized;

    public static /* synthetic */ ConsentActionImplOptimized copy$default(ConsentActionImplOptimized consentActionImplOptimized, ActionType actionType, String str, String str2, String str3, CampaignType campaignType, String str4, String str5, String str6, String str7, boolean z, JsonObject jsonObject, JsonObject jsonObject2, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            actionType = consentActionImplOptimized.actionType;
        }
        return consentActionImplOptimized.copy(actionType, (i & 2) != 0 ? consentActionImplOptimized.choiceId : str, (i & 4) != 0 ? consentActionImplOptimized.consentLanguage : str2, (i & 8) != 0 ? consentActionImplOptimized.customActionId : str3, (i & 16) != 0 ? consentActionImplOptimized.legislation : campaignType, (i & 32) != 0 ? consentActionImplOptimized.localPmId : str4, (i & 64) != 0 ? consentActionImplOptimized.name : str5, (i & 128) != 0 ? consentActionImplOptimized.pmId : str6, (i & 256) != 0 ? consentActionImplOptimized.pmTab : str7, (i & 512) != 0 ? consentActionImplOptimized.requestFromPm : z, (i & 1024) != 0 ? consentActionImplOptimized.saveAndExitVariablesOptimized : jsonObject, (i & 2048) != 0 ? consentActionImplOptimized.pubData2 : jsonObject2, (i & 4096) != 0 ? consentActionImplOptimized.privacyManagerId : str8);
    }

    @Serializable(with = ActionTypeSerializer.class)
    public static /* synthetic */ void getActionType$annotations() {
    }

    @SerialName("choiceId")
    public static /* synthetic */ void getChoiceId$annotations() {
    }

    @SerialName("consentLanguage")
    public static /* synthetic */ void getConsentLanguage$annotations() {
    }

    @SerialName("customActionId")
    public static /* synthetic */ void getCustomActionId$annotations() {
    }

    @Serializable(with = CampaignTypeSerializer.class)
    public static /* synthetic */ void getLegislation$annotations() {
    }

    @SerialName("localPmId")
    public static /* synthetic */ void getLocalPmId$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("pmId")
    public static /* synthetic */ void getPmId$annotations() {
    }

    @SerialName("pmTab")
    public static /* synthetic */ void getPmTab$annotations() {
    }

    @SerialName("privacyManagerId")
    public static /* synthetic */ void getPrivacyManagerId$annotations() {
    }

    @SerialName("pubData")
    public static /* synthetic */ void getPubData2$annotations() {
    }

    @SerialName("requestFromPm")
    public static /* synthetic */ void getRequestFromPm$annotations() {
    }

    @SerialName("saveAndExitVariables")
    public static /* synthetic */ void getSaveAndExitVariablesOptimized$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final ActionType getActionType() {
        return this.actionType;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getRequestFromPm() {
        return this.requestFromPm;
    }

    /* renamed from: component11, reason: from getter */
    public final JsonObject getSaveAndExitVariablesOptimized() {
        return this.saveAndExitVariablesOptimized;
    }

    /* renamed from: component12, reason: from getter */
    public final JsonObject getPubData2() {
        return this.pubData2;
    }

    /* renamed from: component13, reason: from getter */
    public final String getPrivacyManagerId() {
        return this.privacyManagerId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getChoiceId() {
        return this.choiceId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getConsentLanguage() {
        return this.consentLanguage;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCustomActionId() {
        return this.customActionId;
    }

    /* renamed from: component5, reason: from getter */
    public final CampaignType getLegislation() {
        return this.legislation;
    }

    /* renamed from: component6, reason: from getter */
    public final String getLocalPmId() {
        return this.localPmId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPmId() {
        return this.pmId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getPmTab() {
        return this.pmTab;
    }

    public final ConsentActionImplOptimized copy(ActionType actionType, String choiceId, String consentLanguage, String customActionId, CampaignType legislation, String localPmId, String name, String pmId, String pmTab, boolean requestFromPm, JsonObject saveAndExitVariablesOptimized, JsonObject pubData2, String privacyManagerId) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(legislation, "legislation");
        Intrinsics.checkNotNullParameter(saveAndExitVariablesOptimized, "saveAndExitVariablesOptimized");
        Intrinsics.checkNotNullParameter(pubData2, "pubData2");
        return new ConsentActionImplOptimized(actionType, choiceId, consentLanguage, customActionId, legislation, localPmId, name, pmId, pmTab, requestFromPm, saveAndExitVariablesOptimized, pubData2, privacyManagerId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsentActionImplOptimized)) {
            return false;
        }
        ConsentActionImplOptimized consentActionImplOptimized = (ConsentActionImplOptimized) other;
        return this.actionType == consentActionImplOptimized.actionType && Intrinsics.areEqual(this.choiceId, consentActionImplOptimized.choiceId) && Intrinsics.areEqual(this.consentLanguage, consentActionImplOptimized.consentLanguage) && Intrinsics.areEqual(this.customActionId, consentActionImplOptimized.customActionId) && this.legislation == consentActionImplOptimized.legislation && Intrinsics.areEqual(this.localPmId, consentActionImplOptimized.localPmId) && Intrinsics.areEqual(this.name, consentActionImplOptimized.name) && Intrinsics.areEqual(this.pmId, consentActionImplOptimized.pmId) && Intrinsics.areEqual(this.pmTab, consentActionImplOptimized.pmTab) && this.requestFromPm == consentActionImplOptimized.requestFromPm && Intrinsics.areEqual(this.saveAndExitVariablesOptimized, consentActionImplOptimized.saveAndExitVariablesOptimized) && Intrinsics.areEqual(this.pubData2, consentActionImplOptimized.pubData2) && Intrinsics.areEqual(this.privacyManagerId, consentActionImplOptimized.privacyManagerId);
    }

    public int hashCode() {
        int hashCode = this.actionType.hashCode() * 31;
        String str = this.choiceId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.consentLanguage;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.customActionId;
        int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.legislation.hashCode()) * 31;
        String str4 = this.localPmId;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.name;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.pmId;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.pmTab;
        int hashCode8 = (((((((hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + Boolean.hashCode(this.requestFromPm)) * 31) + this.saveAndExitVariablesOptimized.hashCode()) * 31) + this.pubData2.hashCode()) * 31;
        String str8 = this.privacyManagerId;
        return hashCode8 + (str8 != null ? str8.hashCode() : 0);
    }

    public String toString() {
        return "ConsentActionImplOptimized(actionType=" + this.actionType + ", choiceId=" + this.choiceId + ", consentLanguage=" + this.consentLanguage + ", customActionId=" + this.customActionId + ", legislation=" + this.legislation + ", localPmId=" + this.localPmId + ", name=" + this.name + ", pmId=" + this.pmId + ", pmTab=" + this.pmTab + ", requestFromPm=" + this.requestFromPm + ", saveAndExitVariablesOptimized=" + this.saveAndExitVariablesOptimized + ", pubData2=" + this.pubData2 + ", privacyManagerId=" + this.privacyManagerId + ")";
    }

    /* compiled from: ConsentActionImplOptimized.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/ConsentActionImplOptimized$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/model/ConsentActionImplOptimized;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ConsentActionImplOptimized> serializer() {
            return ConsentActionImplOptimized$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ConsentActionImplOptimized(int i, @Serializable(with = ActionTypeSerializer.class) ActionType actionType, @SerialName("choiceId") String str, @SerialName("consentLanguage") String str2, @SerialName("customActionId") String str3, @Serializable(with = CampaignTypeSerializer.class) CampaignType campaignType, @SerialName("localPmId") String str4, @SerialName("name") String str5, @SerialName("pmId") String str6, @SerialName("pmTab") String str7, @SerialName("requestFromPm") boolean z, @SerialName("saveAndExitVariables") JsonObject jsonObject, @SerialName("pubData") JsonObject jsonObject2, @SerialName("privacyManagerId") String str8, SerializationConstructorMarker serializationConstructorMarker) {
        if (753 != (i & 753)) {
            PluginExceptionsKt.throwMissingFieldException(i, 753, ConsentActionImplOptimized$$serializer.INSTANCE.getDescriptor());
        }
        this.actionType = actionType;
        if ((i & 2) == 0) {
            this.choiceId = null;
        } else {
            this.choiceId = str;
        }
        if ((i & 4) == 0) {
            this.consentLanguage = MessageLanguage.ENGLISH.getValue();
        } else {
            this.consentLanguage = str2;
        }
        if ((i & 8) == 0) {
            this.customActionId = null;
        } else {
            this.customActionId = str3;
        }
        this.legislation = campaignType;
        this.localPmId = str4;
        this.name = str5;
        this.pmId = str6;
        if ((i & 256) == 0) {
            this.pmTab = null;
        } else {
            this.pmTab = str7;
        }
        this.requestFromPm = z;
        if ((i & 1024) == 0) {
            this.saveAndExitVariablesOptimized = new JsonObject(MapsKt.emptyMap());
        } else {
            this.saveAndExitVariablesOptimized = jsonObject;
        }
        if ((i & 2048) == 0) {
            this.pubData2 = new JsonObject(MapsKt.emptyMap());
        } else {
            this.pubData2 = jsonObject2;
        }
        if ((i & 4096) == 0) {
            this.privacyManagerId = null;
        } else {
            this.privacyManagerId = str8;
        }
    }

    public ConsentActionImplOptimized(ActionType actionType, String str, String str2, String str3, CampaignType legislation, String str4, String str5, String str6, String str7, boolean z, JsonObject saveAndExitVariablesOptimized, JsonObject pubData2, String str8) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(legislation, "legislation");
        Intrinsics.checkNotNullParameter(saveAndExitVariablesOptimized, "saveAndExitVariablesOptimized");
        Intrinsics.checkNotNullParameter(pubData2, "pubData2");
        this.actionType = actionType;
        this.choiceId = str;
        this.consentLanguage = str2;
        this.customActionId = str3;
        this.legislation = legislation;
        this.localPmId = str4;
        this.name = str5;
        this.pmId = str6;
        this.pmTab = str7;
        this.requestFromPm = z;
        this.saveAndExitVariablesOptimized = saveAndExitVariablesOptimized;
        this.pubData2 = pubData2;
        this.privacyManagerId = str8;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(ConsentActionImplOptimized self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, ActionTypeSerializer.INSTANCE, self.getActionType());
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getChoiceId() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getChoiceId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.getConsentLanguage(), MessageLanguage.ENGLISH.getValue())) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getConsentLanguage());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.getCustomActionId() != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.getCustomActionId());
        }
        output.encodeSerializableElement(serialDesc, 4, CampaignTypeSerializer.INSTANCE, self.legislation);
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.localPmId);
        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.name);
        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.pmId);
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.pmTab != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.pmTab);
        }
        output.encodeBooleanElement(serialDesc, 9, self.getRequestFromPm());
        if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual(self.saveAndExitVariablesOptimized, new JsonObject(MapsKt.emptyMap()))) {
            output.encodeSerializableElement(serialDesc, 10, JsonObjectSerializer.INSTANCE, self.saveAndExitVariablesOptimized);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || !Intrinsics.areEqual(self.getPubData2(), new JsonObject(MapsKt.emptyMap()))) {
            output.encodeSerializableElement(serialDesc, 11, JsonObjectSerializer.INSTANCE, self.getPubData2());
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 12) && self.getPrivacyManagerId() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.getPrivacyManagerId());
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public ActionType getActionType() {
        return this.actionType;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public String getChoiceId() {
        return this.choiceId;
    }

    public /* synthetic */ ConsentActionImplOptimized(ActionType actionType, String str, String str2, String str3, CampaignType campaignType, String str4, String str5, String str6, String str7, boolean z, JsonObject jsonObject, JsonObject jsonObject2, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(actionType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? MessageLanguage.ENGLISH.getValue() : str2, (i & 8) != 0 ? null : str3, campaignType, str4, str5, str6, (i & 256) != 0 ? null : str7, z, (i & 1024) != 0 ? new JsonObject(MapsKt.emptyMap()) : jsonObject, (i & 2048) != 0 ? new JsonObject(MapsKt.emptyMap()) : jsonObject2, (i & 4096) != 0 ? null : str8);
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public String getConsentLanguage() {
        return this.consentLanguage;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public String getCustomActionId() {
        return this.customActionId;
    }

    public final CampaignType getLegislation() {
        return this.legislation;
    }

    public final String getLocalPmId() {
        return this.localPmId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPmId() {
        return this.pmId;
    }

    public final String getPmTab() {
        return this.pmTab;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public boolean getRequestFromPm() {
        return this.requestFromPm;
    }

    public final JsonObject getSaveAndExitVariablesOptimized() {
        return this.saveAndExitVariablesOptimized;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public JsonObject getPubData2() {
        return this.pubData2;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public String getPrivacyManagerId() {
        return this.privacyManagerId;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public JSONObject getPubData() {
        return new JSONObject(getPubData2());
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public CampaignType getCampaignType() {
        return this.legislation;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public JSONObject getSaveAndExitVariables() {
        return new JSONObject(this.saveAndExitVariablesOptimized);
    }
}
