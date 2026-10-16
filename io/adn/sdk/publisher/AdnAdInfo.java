package io.adn.sdk.publisher;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdnAdInfo.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001b\u001a\u00020\u001cH×\u0001J\t\u0010\u001d\u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lio/adn/sdk/publisher/AdnAdInfo;", "", "creativeId", "", "creativeType", "campaignId", "price", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;)V", "getCreativeId", "()Ljava/lang/String;", "getCreativeType", "getCampaignId", "getPrice", "()D", "getId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class AdnAdInfo {
    public static final int $stable = 0;
    private final String campaignId;
    private final String creativeId;
    private final String creativeType;
    private final String id;
    private final double price;

    public static /* synthetic */ AdnAdInfo copy$default(AdnAdInfo adnAdInfo, String str, String str2, String str3, double d, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adnAdInfo.creativeId;
        }
        if ((i & 2) != 0) {
            str2 = adnAdInfo.creativeType;
        }
        if ((i & 4) != 0) {
            str3 = adnAdInfo.campaignId;
        }
        if ((i & 8) != 0) {
            d = adnAdInfo.price;
        }
        if ((i & 16) != 0) {
            str4 = adnAdInfo.id;
        }
        String str5 = str4;
        String str6 = str3;
        return adnAdInfo.copy(str, str2, str6, d, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCreativeId() {
        return this.creativeId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCreativeType() {
        return this.creativeType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCampaignId() {
        return this.campaignId;
    }

    /* renamed from: component4, reason: from getter */
    public final double getPrice() {
        return this.price;
    }

    /* renamed from: component5, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final AdnAdInfo copy(String creativeId, String creativeType, String campaignId, double price, String id) {
        return new AdnAdInfo(creativeId, creativeType, campaignId, price, id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdnAdInfo)) {
            return false;
        }
        AdnAdInfo adnAdInfo = (AdnAdInfo) other;
        return Intrinsics.areEqual(this.creativeId, adnAdInfo.creativeId) && Intrinsics.areEqual(this.creativeType, adnAdInfo.creativeType) && Intrinsics.areEqual(this.campaignId, adnAdInfo.campaignId) && Double.compare(this.price, adnAdInfo.price) == 0 && Intrinsics.areEqual(this.id, adnAdInfo.id);
    }

    public int hashCode() {
        String str = this.creativeId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.creativeType;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.campaignId;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + Double.hashCode(this.price)) * 31;
        String str4 = this.id;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "AdnAdInfo(creativeId=" + this.creativeId + ", creativeType=" + this.creativeType + ", campaignId=" + this.campaignId + ", price=" + this.price + ", id=" + this.id + ')';
    }

    public AdnAdInfo(String str, String str2, String str3, double d, String str4) {
        this.creativeId = str;
        this.creativeType = str2;
        this.campaignId = str3;
        this.price = d;
        this.id = str4;
    }

    public /* synthetic */ AdnAdInfo(String str, String str2, String str3, double d, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, d, (i & 16) != 0 ? null : str4);
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getCreativeType() {
        return this.creativeType;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final double getPrice() {
        return this.price;
    }

    public final String getId() {
        return this.id;
    }
}
