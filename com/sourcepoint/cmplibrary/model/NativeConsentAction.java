package com.sourcepoint.cmplibrary.model;

import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.NativeMessageActionType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConsentActionImpl.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/NativeConsentAction;", "", "actionType", "Lcom/sourcepoint/cmplibrary/model/exposed/NativeMessageActionType;", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "privacyManagerId", "", "(Lcom/sourcepoint/cmplibrary/model/exposed/NativeMessageActionType;Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;)V", "getActionType", "()Lcom/sourcepoint/cmplibrary/model/exposed/NativeMessageActionType;", "getCampaignType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getPrivacyManagerId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NativeConsentAction {
    private final NativeMessageActionType actionType;
    private final CampaignType campaignType;
    private final String privacyManagerId;

    public static /* synthetic */ NativeConsentAction copy$default(NativeConsentAction nativeConsentAction, NativeMessageActionType nativeMessageActionType, CampaignType campaignType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            nativeMessageActionType = nativeConsentAction.actionType;
        }
        if ((i & 2) != 0) {
            campaignType = nativeConsentAction.campaignType;
        }
        if ((i & 4) != 0) {
            str = nativeConsentAction.privacyManagerId;
        }
        return nativeConsentAction.copy(nativeMessageActionType, campaignType, str);
    }

    /* renamed from: component1, reason: from getter */
    public final NativeMessageActionType getActionType() {
        return this.actionType;
    }

    /* renamed from: component2, reason: from getter */
    public final CampaignType getCampaignType() {
        return this.campaignType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPrivacyManagerId() {
        return this.privacyManagerId;
    }

    public final NativeConsentAction copy(NativeMessageActionType actionType, CampaignType campaignType, String privacyManagerId) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        return new NativeConsentAction(actionType, campaignType, privacyManagerId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeConsentAction)) {
            return false;
        }
        NativeConsentAction nativeConsentAction = (NativeConsentAction) other;
        return this.actionType == nativeConsentAction.actionType && this.campaignType == nativeConsentAction.campaignType && Intrinsics.areEqual(this.privacyManagerId, nativeConsentAction.privacyManagerId);
    }

    public int hashCode() {
        int hashCode = ((this.actionType.hashCode() * 31) + this.campaignType.hashCode()) * 31;
        String str = this.privacyManagerId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "NativeConsentAction(actionType=" + this.actionType + ", campaignType=" + this.campaignType + ", privacyManagerId=" + this.privacyManagerId + ")";
    }

    public NativeConsentAction(NativeMessageActionType actionType, CampaignType campaignType, String str) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        this.actionType = actionType;
        this.campaignType = campaignType;
        this.privacyManagerId = str;
    }

    public /* synthetic */ NativeConsentAction(NativeMessageActionType nativeMessageActionType, CampaignType campaignType, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nativeMessageActionType, campaignType, (i & 4) != 0 ? null : str);
    }

    public final NativeMessageActionType getActionType() {
        return this.actionType;
    }

    public final CampaignType getCampaignType() {
        return this.campaignType;
    }

    public final String getPrivacyManagerId() {
        return this.privacyManagerId;
    }
}
