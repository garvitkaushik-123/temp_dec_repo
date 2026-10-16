package com.sourcepoint.cmplibrary.model;

import com.ironsource.adapters.inmobi.InMobiAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Campaign.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\t\u0010\n\u001a\u00020\u0005HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/Campaign;", "", InMobiAdapter.ACCOUNT_ID, "", "propertyName", "", "pmId", "(ILjava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Campaign {
    public final int accountId;
    public final String pmId;
    public final String propertyName;

    public static /* synthetic */ Campaign copy$default(Campaign campaign, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = campaign.accountId;
        }
        if ((i2 & 2) != 0) {
            str = campaign.propertyName;
        }
        if ((i2 & 4) != 0) {
            str2 = campaign.pmId;
        }
        return campaign.copy(i, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAccountId() {
        return this.accountId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPropertyName() {
        return this.propertyName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPmId() {
        return this.pmId;
    }

    public final Campaign copy(int accountId, String propertyName, String pmId) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        Intrinsics.checkNotNullParameter(pmId, "pmId");
        return new Campaign(accountId, propertyName, pmId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Campaign)) {
            return false;
        }
        Campaign campaign = (Campaign) other;
        return this.accountId == campaign.accountId && Intrinsics.areEqual(this.propertyName, campaign.propertyName) && Intrinsics.areEqual(this.pmId, campaign.pmId);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.accountId) * 31) + this.propertyName.hashCode()) * 31) + this.pmId.hashCode();
    }

    public String toString() {
        return "Campaign(accountId=" + this.accountId + ", propertyName=" + this.propertyName + ", pmId=" + this.pmId + ")";
    }

    public Campaign(int i, String propertyName, String pmId) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        Intrinsics.checkNotNullParameter(pmId, "pmId");
        this.accountId = i;
        this.propertyName = propertyName;
        this.pmId = pmId;
    }
}
