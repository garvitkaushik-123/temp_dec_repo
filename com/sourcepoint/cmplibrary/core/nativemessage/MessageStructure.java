package com.sourcepoint.cmplibrary.core.nativemessage;

import com.sourcepoint.cmplibrary.exception.CampaignType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/nativemessage/MessageStructure;", "", "messageComponents", "Lcom/sourcepoint/cmplibrary/core/nativemessage/MessageComponents;", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "(Lcom/sourcepoint/cmplibrary/core/nativemessage/MessageComponents;Lcom/sourcepoint/cmplibrary/exception/CampaignType;)V", "getCampaignType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getMessageComponents", "()Lcom/sourcepoint/cmplibrary/core/nativemessage/MessageComponents;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MessageStructure {
    private final CampaignType campaignType;
    private final MessageComponents messageComponents;

    public static /* synthetic */ MessageStructure copy$default(MessageStructure messageStructure, MessageComponents messageComponents, CampaignType campaignType, int i, Object obj) {
        if ((i & 1) != 0) {
            messageComponents = messageStructure.messageComponents;
        }
        if ((i & 2) != 0) {
            campaignType = messageStructure.campaignType;
        }
        return messageStructure.copy(messageComponents, campaignType);
    }

    /* renamed from: component1, reason: from getter */
    public final MessageComponents getMessageComponents() {
        return this.messageComponents;
    }

    /* renamed from: component2, reason: from getter */
    public final CampaignType getCampaignType() {
        return this.campaignType;
    }

    public final MessageStructure copy(MessageComponents messageComponents, CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        return new MessageStructure(messageComponents, campaignType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageStructure)) {
            return false;
        }
        MessageStructure messageStructure = (MessageStructure) other;
        return Intrinsics.areEqual(this.messageComponents, messageStructure.messageComponents) && this.campaignType == messageStructure.campaignType;
    }

    public int hashCode() {
        MessageComponents messageComponents = this.messageComponents;
        return ((messageComponents == null ? 0 : messageComponents.hashCode()) * 31) + this.campaignType.hashCode();
    }

    public String toString() {
        return "MessageStructure(messageComponents=" + this.messageComponents + ", campaignType=" + this.campaignType + ")";
    }

    public MessageStructure(MessageComponents messageComponents, CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        this.messageComponents = messageComponents;
        this.campaignType = campaignType;
    }

    public final MessageComponents getMessageComponents() {
        return this.messageComponents;
    }

    public final CampaignType getCampaignType() {
        return this.campaignType;
    }
}
