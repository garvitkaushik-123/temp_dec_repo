package com.sourcepoint.cmplibrary.core.web;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.MessageSubCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* compiled from: CampaignModel.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/sourcepoint/cmplibrary/core/web/CampaignModel;", "", PglCryptUtils.KEY_MESSAGE, "Lorg/json/JSONObject;", "messageMetaData", "type", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "url", "Lokhttp3/HttpUrl;", "messageSubCategory", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;", "(Lorg/json/JSONObject;Lorg/json/JSONObject;Lcom/sourcepoint/cmplibrary/exception/CampaignType;Lokhttp3/HttpUrl;Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;)V", "getMessage", "()Lorg/json/JSONObject;", "getMessageMetaData", "getMessageSubCategory", "()Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;", "getType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getUrl", "()Lokhttp3/HttpUrl;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CampaignModel {
    private final JSONObject message;
    private final JSONObject messageMetaData;
    private final MessageSubCategory messageSubCategory;
    private final CampaignType type;
    private final HttpUrl url;

    public static /* synthetic */ CampaignModel copy$default(CampaignModel campaignModel, JSONObject jSONObject, JSONObject jSONObject2, CampaignType campaignType, HttpUrl httpUrl, MessageSubCategory messageSubCategory, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = campaignModel.message;
        }
        if ((i & 2) != 0) {
            jSONObject2 = campaignModel.messageMetaData;
        }
        if ((i & 4) != 0) {
            campaignType = campaignModel.type;
        }
        if ((i & 8) != 0) {
            httpUrl = campaignModel.url;
        }
        if ((i & 16) != 0) {
            messageSubCategory = campaignModel.messageSubCategory;
        }
        MessageSubCategory messageSubCategory2 = messageSubCategory;
        CampaignType campaignType2 = campaignType;
        return campaignModel.copy(jSONObject, jSONObject2, campaignType2, httpUrl, messageSubCategory2);
    }

    /* renamed from: component1, reason: from getter */
    public final JSONObject getMessage() {
        return this.message;
    }

    /* renamed from: component2, reason: from getter */
    public final JSONObject getMessageMetaData() {
        return this.messageMetaData;
    }

    /* renamed from: component3, reason: from getter */
    public final CampaignType getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final HttpUrl getUrl() {
        return this.url;
    }

    /* renamed from: component5, reason: from getter */
    public final MessageSubCategory getMessageSubCategory() {
        return this.messageSubCategory;
    }

    public final CampaignModel copy(JSONObject message, JSONObject messageMetaData, CampaignType type, HttpUrl url, MessageSubCategory messageSubCategory) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(messageMetaData, "messageMetaData");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(messageSubCategory, "messageSubCategory");
        return new CampaignModel(message, messageMetaData, type, url, messageSubCategory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CampaignModel)) {
            return false;
        }
        CampaignModel campaignModel = (CampaignModel) other;
        return Intrinsics.areEqual(this.message, campaignModel.message) && Intrinsics.areEqual(this.messageMetaData, campaignModel.messageMetaData) && this.type == campaignModel.type && Intrinsics.areEqual(this.url, campaignModel.url) && this.messageSubCategory == campaignModel.messageSubCategory;
    }

    public int hashCode() {
        return (((((((this.message.hashCode() * 31) + this.messageMetaData.hashCode()) * 31) + this.type.hashCode()) * 31) + this.url.hashCode()) * 31) + this.messageSubCategory.hashCode();
    }

    public String toString() {
        return "CampaignModel(message=" + this.message + ", messageMetaData=" + this.messageMetaData + ", type=" + this.type + ", url=" + this.url + ", messageSubCategory=" + this.messageSubCategory + ")";
    }

    public CampaignModel(JSONObject message, JSONObject messageMetaData, CampaignType type, HttpUrl url, MessageSubCategory messageSubCategory) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(messageMetaData, "messageMetaData");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(messageSubCategory, "messageSubCategory");
        this.message = message;
        this.messageMetaData = messageMetaData;
        this.type = type;
        this.url = url;
        this.messageSubCategory = messageSubCategory;
    }

    public final JSONObject getMessage() {
        return this.message;
    }

    public final JSONObject getMessageMetaData() {
        return this.messageMetaData;
    }

    public final CampaignType getType() {
        return this.type;
    }

    public final HttpUrl getUrl() {
        return this.url;
    }

    public final MessageSubCategory getMessageSubCategory() {
        return this.messageSubCategory;
    }
}
