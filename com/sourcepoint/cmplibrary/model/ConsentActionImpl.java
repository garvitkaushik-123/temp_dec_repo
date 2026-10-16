package com.sourcepoint.cmplibrary.model;

import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.ActionType;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONObject;

/* compiled from: ConsentActionImpl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u00104\u001a\u00020\u000fHÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u0095\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u0005HÆ\u0001J\u0013\u00107\u001a\u00020\u000f2\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\u000bHÖ\u0001R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0016\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\u0010\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!¨\u0006="}, d2 = {"Lcom/sourcepoint/cmplibrary/model/ConsentActionImpl;", "Lcom/sourcepoint/cmplibrary/model/ConsentAction;", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "pubData", "Lorg/json/JSONObject;", "pubData2", "Lkotlinx/serialization/json/JsonObject;", "actionType", "Lcom/sourcepoint/cmplibrary/model/exposed/ActionType;", "customActionId", "", "privacyManagerId", "choiceId", "requestFromPm", "", "saveAndExitVariables", "consentLanguage", "saveAndExitVariablesOptimized", "pmTab", "thisContent", "(Lcom/sourcepoint/cmplibrary/exception/CampaignType;Lorg/json/JSONObject;Lkotlinx/serialization/json/JsonObject;Lcom/sourcepoint/cmplibrary/model/exposed/ActionType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLorg/json/JSONObject;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lorg/json/JSONObject;)V", "getActionType", "()Lcom/sourcepoint/cmplibrary/model/exposed/ActionType;", "getCampaignType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getChoiceId", "()Ljava/lang/String;", "getConsentLanguage", "getCustomActionId", "getPmTab", "getPrivacyManagerId", "getPubData", "()Lorg/json/JSONObject;", "getPubData2", "()Lkotlinx/serialization/json/JsonObject;", "getRequestFromPm", "()Z", "getSaveAndExitVariables", "getSaveAndExitVariablesOptimized", "getThisContent", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ConsentActionImpl implements ConsentAction {
    private final ActionType actionType;
    private final CampaignType campaignType;
    private final String choiceId;
    private final String consentLanguage;
    private final String customActionId;
    private final String pmTab;
    private final String privacyManagerId;
    private final JSONObject pubData;
    private final JsonObject pubData2;
    private final boolean requestFromPm;
    private final JSONObject saveAndExitVariables;
    private final JsonObject saveAndExitVariablesOptimized;
    private final JSONObject thisContent;

    public static /* synthetic */ ConsentActionImpl copy$default(ConsentActionImpl consentActionImpl, CampaignType campaignType, JSONObject jSONObject, JsonObject jsonObject, ActionType actionType, String str, String str2, String str3, boolean z, JSONObject jSONObject2, String str4, JsonObject jsonObject2, String str5, JSONObject jSONObject3, int i, Object obj) {
        if ((i & 1) != 0) {
            campaignType = consentActionImpl.campaignType;
        }
        return consentActionImpl.copy(campaignType, (i & 2) != 0 ? consentActionImpl.pubData : jSONObject, (i & 4) != 0 ? consentActionImpl.pubData2 : jsonObject, (i & 8) != 0 ? consentActionImpl.actionType : actionType, (i & 16) != 0 ? consentActionImpl.customActionId : str, (i & 32) != 0 ? consentActionImpl.privacyManagerId : str2, (i & 64) != 0 ? consentActionImpl.choiceId : str3, (i & 128) != 0 ? consentActionImpl.requestFromPm : z, (i & 256) != 0 ? consentActionImpl.saveAndExitVariables : jSONObject2, (i & 512) != 0 ? consentActionImpl.consentLanguage : str4, (i & 1024) != 0 ? consentActionImpl.saveAndExitVariablesOptimized : jsonObject2, (i & 2048) != 0 ? consentActionImpl.pmTab : str5, (i & 4096) != 0 ? consentActionImpl.thisContent : jSONObject3);
    }

    /* renamed from: component1, reason: from getter */
    public final CampaignType getCampaignType() {
        return this.campaignType;
    }

    /* renamed from: component10, reason: from getter */
    public final String getConsentLanguage() {
        return this.consentLanguage;
    }

    /* renamed from: component11, reason: from getter */
    public final JsonObject getSaveAndExitVariablesOptimized() {
        return this.saveAndExitVariablesOptimized;
    }

    /* renamed from: component12, reason: from getter */
    public final String getPmTab() {
        return this.pmTab;
    }

    /* renamed from: component13, reason: from getter */
    public final JSONObject getThisContent() {
        return this.thisContent;
    }

    /* renamed from: component2, reason: from getter */
    public final JSONObject getPubData() {
        return this.pubData;
    }

    /* renamed from: component3, reason: from getter */
    public final JsonObject getPubData2() {
        return this.pubData2;
    }

    /* renamed from: component4, reason: from getter */
    public final ActionType getActionType() {
        return this.actionType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCustomActionId() {
        return this.customActionId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPrivacyManagerId() {
        return this.privacyManagerId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getChoiceId() {
        return this.choiceId;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getRequestFromPm() {
        return this.requestFromPm;
    }

    /* renamed from: component9, reason: from getter */
    public final JSONObject getSaveAndExitVariables() {
        return this.saveAndExitVariables;
    }

    public final ConsentActionImpl copy(CampaignType campaignType, JSONObject pubData, JsonObject pubData2, ActionType actionType, String customActionId, String privacyManagerId, String choiceId, boolean requestFromPm, JSONObject saveAndExitVariables, String consentLanguage, JsonObject saveAndExitVariablesOptimized, String pmTab, JSONObject thisContent) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(pubData, "pubData");
        Intrinsics.checkNotNullParameter(pubData2, "pubData2");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(saveAndExitVariables, "saveAndExitVariables");
        Intrinsics.checkNotNullParameter(saveAndExitVariablesOptimized, "saveAndExitVariablesOptimized");
        Intrinsics.checkNotNullParameter(thisContent, "thisContent");
        return new ConsentActionImpl(campaignType, pubData, pubData2, actionType, customActionId, privacyManagerId, choiceId, requestFromPm, saveAndExitVariables, consentLanguage, saveAndExitVariablesOptimized, pmTab, thisContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsentActionImpl)) {
            return false;
        }
        ConsentActionImpl consentActionImpl = (ConsentActionImpl) other;
        return this.campaignType == consentActionImpl.campaignType && Intrinsics.areEqual(this.pubData, consentActionImpl.pubData) && Intrinsics.areEqual(this.pubData2, consentActionImpl.pubData2) && this.actionType == consentActionImpl.actionType && Intrinsics.areEqual(this.customActionId, consentActionImpl.customActionId) && Intrinsics.areEqual(this.privacyManagerId, consentActionImpl.privacyManagerId) && Intrinsics.areEqual(this.choiceId, consentActionImpl.choiceId) && this.requestFromPm == consentActionImpl.requestFromPm && Intrinsics.areEqual(this.saveAndExitVariables, consentActionImpl.saveAndExitVariables) && Intrinsics.areEqual(this.consentLanguage, consentActionImpl.consentLanguage) && Intrinsics.areEqual(this.saveAndExitVariablesOptimized, consentActionImpl.saveAndExitVariablesOptimized) && Intrinsics.areEqual(this.pmTab, consentActionImpl.pmTab) && Intrinsics.areEqual(this.thisContent, consentActionImpl.thisContent);
    }

    public int hashCode() {
        int hashCode = ((((((this.campaignType.hashCode() * 31) + this.pubData.hashCode()) * 31) + this.pubData2.hashCode()) * 31) + this.actionType.hashCode()) * 31;
        String str = this.customActionId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.privacyManagerId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.choiceId;
        int hashCode4 = (((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.requestFromPm)) * 31) + this.saveAndExitVariables.hashCode()) * 31;
        String str4 = this.consentLanguage;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.saveAndExitVariablesOptimized.hashCode()) * 31;
        String str5 = this.pmTab;
        return ((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.thisContent.hashCode();
    }

    public String toString() {
        return "ConsentActionImpl(campaignType=" + this.campaignType + ", pubData=" + this.pubData + ", pubData2=" + this.pubData2 + ", actionType=" + this.actionType + ", customActionId=" + this.customActionId + ", privacyManagerId=" + this.privacyManagerId + ", choiceId=" + this.choiceId + ", requestFromPm=" + this.requestFromPm + ", saveAndExitVariables=" + this.saveAndExitVariables + ", consentLanguage=" + this.consentLanguage + ", saveAndExitVariablesOptimized=" + this.saveAndExitVariablesOptimized + ", pmTab=" + this.pmTab + ", thisContent=" + this.thisContent + ")";
    }

    public ConsentActionImpl(CampaignType campaignType, JSONObject pubData, JsonObject pubData2, ActionType actionType, String str, String str2, String str3, boolean z, JSONObject saveAndExitVariables, String str4, JsonObject saveAndExitVariablesOptimized, String str5, JSONObject thisContent) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(pubData, "pubData");
        Intrinsics.checkNotNullParameter(pubData2, "pubData2");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(saveAndExitVariables, "saveAndExitVariables");
        Intrinsics.checkNotNullParameter(saveAndExitVariablesOptimized, "saveAndExitVariablesOptimized");
        Intrinsics.checkNotNullParameter(thisContent, "thisContent");
        this.campaignType = campaignType;
        this.pubData = pubData;
        this.pubData2 = pubData2;
        this.actionType = actionType;
        this.customActionId = str;
        this.privacyManagerId = str2;
        this.choiceId = str3;
        this.requestFromPm = z;
        this.saveAndExitVariables = saveAndExitVariables;
        this.consentLanguage = str4;
        this.saveAndExitVariablesOptimized = saveAndExitVariablesOptimized;
        this.pmTab = str5;
        this.thisContent = thisContent;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public CampaignType getCampaignType() {
        return this.campaignType;
    }

    public /* synthetic */ ConsentActionImpl(CampaignType campaignType, JSONObject jSONObject, JsonObject jsonObject, ActionType actionType, String str, String str2, String str3, boolean z, JSONObject jSONObject2, String str4, JsonObject jsonObject2, String str5, JSONObject jSONObject3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(campaignType, (i & 2) != 0 ? new JSONObject() : jSONObject, (i & 4) != 0 ? new JsonObject(MapsKt.emptyMap()) : jsonObject, actionType, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3, z, (i & 256) != 0 ? new JSONObject() : jSONObject2, (i & 512) != 0 ? MessageLanguage.ENGLISH.getValue() : str4, (i & 1024) != 0 ? new JsonObject(MapsKt.emptyMap()) : jsonObject2, (i & 2048) != 0 ? null : str5, (i & 4096) != 0 ? new JSONObject() : jSONObject3);
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public JSONObject getPubData() {
        return this.pubData;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public JsonObject getPubData2() {
        return this.pubData2;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public ActionType getActionType() {
        return this.actionType;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public String getCustomActionId() {
        return this.customActionId;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public String getPrivacyManagerId() {
        return this.privacyManagerId;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public String getChoiceId() {
        return this.choiceId;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public boolean getRequestFromPm() {
        return this.requestFromPm;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public JSONObject getSaveAndExitVariables() {
        return this.saveAndExitVariables;
    }

    @Override // com.sourcepoint.cmplibrary.model.ConsentAction
    public String getConsentLanguage() {
        return this.consentLanguage;
    }

    public final JsonObject getSaveAndExitVariablesOptimized() {
        return this.saveAndExitVariablesOptimized;
    }

    public final String getPmTab() {
        return this.pmTab;
    }

    public final JSONObject getThisContent() {
        return this.thisContent;
    }
}
