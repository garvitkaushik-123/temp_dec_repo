package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BidResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001b\u001a\u00020\u001cH×\u0001J\t\u0010\u001d\u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/BidExtra;", "", "id", "", "bidId", "price", "", "creativeId", "campaignId", "<init>", "(Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getBidId", "getPrice", "()D", "getCreativeId", "getCampaignId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class BidExtra {
    public static final int $stable = 0;
    private final String bidId;
    private final String campaignId;
    private final String creativeId;
    private final String id;
    private final double price;

    public static /* synthetic */ BidExtra copy$default(BidExtra bidExtra, String str, String str2, double d, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bidExtra.id;
        }
        if ((i & 2) != 0) {
            str2 = bidExtra.bidId;
        }
        if ((i & 4) != 0) {
            d = bidExtra.price;
        }
        if ((i & 8) != 0) {
            str3 = bidExtra.creativeId;
        }
        if ((i & 16) != 0) {
            str4 = bidExtra.campaignId;
        }
        double d2 = d;
        return bidExtra.copy(str, str2, d2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBidId() {
        return this.bidId;
    }

    /* renamed from: component3, reason: from getter */
    public final double getPrice() {
        return this.price;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCreativeId() {
        return this.creativeId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCampaignId() {
        return this.campaignId;
    }

    public final BidExtra copy(String id, String bidId, double price, String creativeId, String campaignId) {
        return new BidExtra(id, bidId, price, creativeId, campaignId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BidExtra)) {
            return false;
        }
        BidExtra bidExtra = (BidExtra) other;
        return Intrinsics.areEqual(this.id, bidExtra.id) && Intrinsics.areEqual(this.bidId, bidExtra.bidId) && Double.compare(this.price, bidExtra.price) == 0 && Intrinsics.areEqual(this.creativeId, bidExtra.creativeId) && Intrinsics.areEqual(this.campaignId, bidExtra.campaignId);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.bidId;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Double.hashCode(this.price)) * 31;
        String str3 = this.creativeId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.campaignId;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "BidExtra(id=" + this.id + ", bidId=" + this.bidId + ", price=" + this.price + ", creativeId=" + this.creativeId + ", campaignId=" + this.campaignId + ')';
    }

    public BidExtra(String str, String str2, double d, String str3, String str4) {
        this.id = str;
        this.bidId = str2;
        this.price = d;
        this.creativeId = str3;
        this.campaignId = str4;
    }

    public /* synthetic */ BidExtra(String str, String str2, double d, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, d, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    public final String getId() {
        return this.id;
    }

    public final String getBidId() {
        return this.bidId;
    }

    public final double getPrice() {
        return this.price;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }
}
