package com.sourcepoint.cmplibrary.model.exposed;

import com.sourcepoint.cmplibrary.creation.ConfigOption;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpConfig.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007B+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000fB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÀ\u0003¢\u0006\u0002\b\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\rHÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/SpCampaign;", "", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "targetingParams", "", "Lcom/sourcepoint/cmplibrary/model/exposed/TargetingParam;", "(Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/util/List;)V", "configParams", "", "Lcom/sourcepoint/cmplibrary/creation/ConfigOption;", "(Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/util/List;Ljava/util/Set;)V", "groupPmId", "", "(Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;)V", "(Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;Ljava/util/Set;)V", "(Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/util/List;Ljava/lang/String;Ljava/util/Set;)V", "component1", "component2", "component2$cmplibrary_release", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SpCampaign {
    public final CampaignType campaignType;
    public Set<? extends ConfigOption> configParams;
    public String groupPmId;
    public List<TargetingParam> targetingParams;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpCampaign copy$default(SpCampaign spCampaign, CampaignType campaignType, List list, String str, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            campaignType = spCampaign.campaignType;
        }
        if ((i & 2) != 0) {
            list = spCampaign.targetingParams;
        }
        if ((i & 4) != 0) {
            str = spCampaign.groupPmId;
        }
        if ((i & 8) != 0) {
            set = spCampaign.configParams;
        }
        return spCampaign.copy(campaignType, list, str, set);
    }

    /* renamed from: component1, reason: from getter */
    public final CampaignType getCampaignType() {
        return this.campaignType;
    }

    public final List<TargetingParam> component2$cmplibrary_release() {
        return this.targetingParams;
    }

    /* renamed from: component3, reason: from getter */
    public final String getGroupPmId() {
        return this.groupPmId;
    }

    public final Set<ConfigOption> component4() {
        return this.configParams;
    }

    public final SpCampaign copy(CampaignType campaignType, List<TargetingParam> targetingParams, String groupPmId, Set<? extends ConfigOption> configParams) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(targetingParams, "targetingParams");
        Intrinsics.checkNotNullParameter(configParams, "configParams");
        return new SpCampaign(campaignType, targetingParams, groupPmId, configParams);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpCampaign)) {
            return false;
        }
        SpCampaign spCampaign = (SpCampaign) other;
        return this.campaignType == spCampaign.campaignType && Intrinsics.areEqual(this.targetingParams, spCampaign.targetingParams) && Intrinsics.areEqual(this.groupPmId, spCampaign.groupPmId) && Intrinsics.areEqual(this.configParams, spCampaign.configParams);
    }

    public int hashCode() {
        int hashCode = ((this.campaignType.hashCode() * 31) + this.targetingParams.hashCode()) * 31;
        String str = this.groupPmId;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.configParams.hashCode();
    }

    public String toString() {
        return "SpCampaign(campaignType=" + this.campaignType + ", targetingParams=" + this.targetingParams + ", groupPmId=" + this.groupPmId + ", configParams=" + this.configParams + ")";
    }

    public SpCampaign(CampaignType campaignType, List<TargetingParam> targetingParams, String str, Set<? extends ConfigOption> configParams) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(targetingParams, "targetingParams");
        Intrinsics.checkNotNullParameter(configParams, "configParams");
        this.campaignType = campaignType;
        this.targetingParams = targetingParams;
        this.groupPmId = str;
        this.configParams = configParams;
    }

    public /* synthetic */ SpCampaign(CampaignType campaignType, List list, String str, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(campaignType, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : str, (i & 8) != 0 ? SetsKt.emptySet() : set);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpCampaign(CampaignType campaignType, List<TargetingParam> targetingParams) {
        this(campaignType, targetingParams, null, null, 8, null);
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(targetingParams, "targetingParams");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpCampaign(CampaignType campaignType, List<TargetingParam> targetingParams, Set<? extends ConfigOption> configParams) {
        this(campaignType, targetingParams, null, configParams);
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(targetingParams, "targetingParams");
        Intrinsics.checkNotNullParameter(configParams, "configParams");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpCampaign(CampaignType campaignType, String groupPmId) {
        this(campaignType, CollectionsKt.emptyList(), groupPmId, null, 8, null);
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(groupPmId, "groupPmId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpCampaign(CampaignType campaignType, String groupPmId, Set<? extends ConfigOption> configParams) {
        this(campaignType, CollectionsKt.emptyList(), groupPmId, configParams);
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(groupPmId, "groupPmId");
        Intrinsics.checkNotNullParameter(configParams, "configParams");
    }
}
