package com.sourcepoint.cmplibrary.model;

import com.sourcepoint.cmplibrary.exception.CampaignType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ConsentReq.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006!"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/ConsentResp;", "", "content", "Lorg/json/JSONObject;", "userConsent", "", "uuid", "localState", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/exception/CampaignType;)V", "getCampaignType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "setCampaignType", "(Lcom/sourcepoint/cmplibrary/exception/CampaignType;)V", "getContent", "()Lorg/json/JSONObject;", "getLocalState", "()Ljava/lang/String;", "getUserConsent", "getUuid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ConsentResp {
    private CampaignType campaignType;
    private final JSONObject content;
    private final String localState;
    private final String userConsent;
    private final String uuid;

    public static /* synthetic */ ConsentResp copy$default(ConsentResp consentResp, JSONObject jSONObject, String str, String str2, String str3, CampaignType campaignType, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = consentResp.content;
        }
        if ((i & 2) != 0) {
            str = consentResp.userConsent;
        }
        if ((i & 4) != 0) {
            str2 = consentResp.uuid;
        }
        if ((i & 8) != 0) {
            str3 = consentResp.localState;
        }
        if ((i & 16) != 0) {
            campaignType = consentResp.campaignType;
        }
        CampaignType campaignType2 = campaignType;
        String str4 = str2;
        return consentResp.copy(jSONObject, str, str4, str3, campaignType2);
    }

    /* renamed from: component1, reason: from getter */
    public final JSONObject getContent() {
        return this.content;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUserConsent() {
        return this.userConsent;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLocalState() {
        return this.localState;
    }

    /* renamed from: component5, reason: from getter */
    public final CampaignType getCampaignType() {
        return this.campaignType;
    }

    public final ConsentResp copy(JSONObject content, String userConsent, String uuid, String localState, CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(localState, "localState");
        return new ConsentResp(content, userConsent, uuid, localState, campaignType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsentResp)) {
            return false;
        }
        ConsentResp consentResp = (ConsentResp) other;
        return Intrinsics.areEqual(this.content, consentResp.content) && Intrinsics.areEqual(this.userConsent, consentResp.userConsent) && Intrinsics.areEqual(this.uuid, consentResp.uuid) && Intrinsics.areEqual(this.localState, consentResp.localState) && this.campaignType == consentResp.campaignType;
    }

    public int hashCode() {
        int hashCode = this.content.hashCode() * 31;
        String str = this.userConsent;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.uuid;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.localState.hashCode()) * 31;
        CampaignType campaignType = this.campaignType;
        return hashCode3 + (campaignType != null ? campaignType.hashCode() : 0);
    }

    public String toString() {
        return "ConsentResp(content=" + this.content + ", userConsent=" + this.userConsent + ", uuid=" + this.uuid + ", localState=" + this.localState + ", campaignType=" + this.campaignType + ")";
    }

    public ConsentResp(JSONObject content, String str, String str2, String localState, CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(localState, "localState");
        this.content = content;
        this.userConsent = str;
        this.uuid = str2;
        this.localState = localState;
        this.campaignType = campaignType;
    }

    public /* synthetic */ ConsentResp(JSONObject jSONObject, String str, String str2, String str3, CampaignType campaignType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject, str, str2, str3, (i & 16) != 0 ? null : campaignType);
    }

    public final JSONObject getContent() {
        return this.content;
    }

    public final String getUserConsent() {
        return this.userConsent;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getLocalState() {
        return this.localState;
    }

    public final CampaignType getCampaignType() {
        return this.campaignType;
    }

    public final void setCampaignType(CampaignType campaignType) {
        this.campaignType = campaignType;
    }
}
