package com.moloco.sdk.publisher;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÇ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0017\u001a\u00020\u0018H×\u0001J\t\u0010\u0019\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/moloco/sdk/publisher/MolocoAd;", "", "networkName", "", "adUnitId", "revenue", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;)V", "getNetworkName", "()Ljava/lang/String;", "getAdUnitId", "getRevenue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;)Lcom/moloco/sdk/publisher/MolocoAd;", "equals", "", "other", "hashCode", "", "toString", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class MolocoAd {
    public static final int $stable = 0;
    private final String adUnitId;
    private final String networkName;
    private final Float revenue;

    public MolocoAd(String networkName, String adUnitId, Float f) {
        Intrinsics.checkNotNullParameter(networkName, "networkName");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        this.networkName = networkName;
        this.adUnitId = adUnitId;
        this.revenue = f;
    }

    public static /* synthetic */ MolocoAd copy$default(MolocoAd molocoAd, String str, String str2, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = molocoAd.networkName;
        }
        if ((i & 2) != 0) {
            str2 = molocoAd.adUnitId;
        }
        if ((i & 4) != 0) {
            f = molocoAd.revenue;
        }
        return molocoAd.copy(str, str2, f);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNetworkName() {
        return this.networkName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAdUnitId() {
        return this.adUnitId;
    }

    /* renamed from: component3, reason: from getter */
    public final Float getRevenue() {
        return this.revenue;
    }

    public final MolocoAd copy(String networkName, String adUnitId, Float revenue) {
        Intrinsics.checkNotNullParameter(networkName, "networkName");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        return new MolocoAd(networkName, adUnitId, revenue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MolocoAd)) {
            return false;
        }
        MolocoAd molocoAd = (MolocoAd) other;
        return Intrinsics.areEqual(this.networkName, molocoAd.networkName) && Intrinsics.areEqual(this.adUnitId, molocoAd.adUnitId) && Intrinsics.areEqual((Object) this.revenue, (Object) molocoAd.revenue);
    }

    public final String getAdUnitId() {
        return this.adUnitId;
    }

    public final String getNetworkName() {
        return this.networkName;
    }

    public final Float getRevenue() {
        return this.revenue;
    }

    public int hashCode() {
        int hashCode = ((this.networkName.hashCode() * 31) + this.adUnitId.hashCode()) * 31;
        Float f = this.revenue;
        return hashCode + (f == null ? 0 : f.hashCode());
    }

    public String toString() {
        return "MolocoAd(networkName=" + this.networkName + ", adUnitId=" + this.adUnitId + ", revenue=" + this.revenue + ')';
    }

    public /* synthetic */ MolocoAd(String str, String str2, Float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : f);
    }
}
