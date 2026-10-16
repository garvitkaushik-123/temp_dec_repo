package com.sourcepoint.cmplibrary.model;

import com.sourcepoint.cmplibrary.data.network.util.CampaignsEnv;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.TargetingParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageModelReq.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/sourcepoint/cmplibrary/model/CampaignReqImpl;", "Lcom/sourcepoint/cmplibrary/model/CampaignReq;", "targetingParams", "", "Lcom/sourcepoint/cmplibrary/model/exposed/TargetingParam;", "campaignsEnv", "Lcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "groupPmId", "", "(Ljava/util/List;Lcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;)V", "getCampaignType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getCampaignsEnv", "()Lcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;", "getGroupPmId", "()Ljava/lang/String;", "getTargetingParams", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CampaignReqImpl implements CampaignReq {
    private final CampaignType campaignType;
    private final CampaignsEnv campaignsEnv;
    private final String groupPmId;
    private final List<TargetingParam> targetingParams;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CampaignReqImpl copy$default(CampaignReqImpl campaignReqImpl, List list, CampaignsEnv campaignsEnv, CampaignType campaignType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = campaignReqImpl.targetingParams;
        }
        if ((i & 2) != 0) {
            campaignsEnv = campaignReqImpl.campaignsEnv;
        }
        if ((i & 4) != 0) {
            campaignType = campaignReqImpl.campaignType;
        }
        if ((i & 8) != 0) {
            str = campaignReqImpl.groupPmId;
        }
        return campaignReqImpl.copy(list, campaignsEnv, campaignType, str);
    }

    public final List<TargetingParam> component1() {
        return this.targetingParams;
    }

    /* renamed from: component2, reason: from getter */
    public final CampaignsEnv getCampaignsEnv() {
        return this.campaignsEnv;
    }

    /* renamed from: component3, reason: from getter */
    public final CampaignType getCampaignType() {
        return this.campaignType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getGroupPmId() {
        return this.groupPmId;
    }

    public final CampaignReqImpl copy(List<TargetingParam> targetingParams, CampaignsEnv campaignsEnv, CampaignType campaignType, String groupPmId) {
        Intrinsics.checkNotNullParameter(targetingParams, "targetingParams");
        Intrinsics.checkNotNullParameter(campaignsEnv, "campaignsEnv");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        return new CampaignReqImpl(targetingParams, campaignsEnv, campaignType, groupPmId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CampaignReqImpl)) {
            return false;
        }
        CampaignReqImpl campaignReqImpl = (CampaignReqImpl) other;
        return Intrinsics.areEqual(this.targetingParams, campaignReqImpl.targetingParams) && this.campaignsEnv == campaignReqImpl.campaignsEnv && this.campaignType == campaignReqImpl.campaignType && Intrinsics.areEqual(this.groupPmId, campaignReqImpl.groupPmId);
    }

    public int hashCode() {
        int hashCode = ((((this.targetingParams.hashCode() * 31) + this.campaignsEnv.hashCode()) * 31) + this.campaignType.hashCode()) * 31;
        String str = this.groupPmId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CampaignReqImpl(targetingParams=" + this.targetingParams + ", campaignsEnv=" + this.campaignsEnv + ", campaignType=" + this.campaignType + ", groupPmId=" + this.groupPmId + ")";
    }

    public CampaignReqImpl(List<TargetingParam> targetingParams, CampaignsEnv campaignsEnv, CampaignType campaignType, String str) {
        Intrinsics.checkNotNullParameter(targetingParams, "targetingParams");
        Intrinsics.checkNotNullParameter(campaignsEnv, "campaignsEnv");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        this.targetingParams = targetingParams;
        this.campaignsEnv = campaignsEnv;
        this.campaignType = campaignType;
        this.groupPmId = str;
    }

    public /* synthetic */ CampaignReqImpl(List list, CampaignsEnv campaignsEnv, CampaignType campaignType, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, campaignsEnv, campaignType, (i & 8) != 0 ? null : str);
    }

    @Override // com.sourcepoint.cmplibrary.model.CampaignReq
    public List<TargetingParam> getTargetingParams() {
        return this.targetingParams;
    }

    @Override // com.sourcepoint.cmplibrary.model.CampaignReq
    public CampaignsEnv getCampaignsEnv() {
        return this.campaignsEnv;
    }

    @Override // com.sourcepoint.cmplibrary.model.CampaignReq
    public CampaignType getCampaignType() {
        return this.campaignType;
    }

    @Override // com.sourcepoint.cmplibrary.model.CampaignReq
    public String getGroupPmId() {
        return this.groupPmId;
    }
}
