package com.sourcepoint.cmplibrary.model;

import com.sourcepoint.cmplibrary.data.network.util.CampaignsEnv;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.TargetingParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Campaign.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0010\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/CampaignTemplate;", "", "campaignsEnv", "Lcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;", "targetingParams", "", "Lcom/sourcepoint/cmplibrary/model/exposed/TargetingParam;", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "groupPmId", "", "(Lcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;Ljava/util/List;Lcom/sourcepoint/cmplibrary/exception/CampaignType;Ljava/lang/String;)V", "getCampaignType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getCampaignsEnv", "()Lcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;", "getGroupPmId", "()Ljava/lang/String;", "getTargetingParams", "()Ljava/util/List;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public class CampaignTemplate {
    private final CampaignType campaignType;
    private final CampaignsEnv campaignsEnv;
    private final String groupPmId;
    private final List<TargetingParam> targetingParams;

    public CampaignTemplate(CampaignsEnv campaignsEnv, List<TargetingParam> targetingParams, CampaignType campaignType, String str) {
        Intrinsics.checkNotNullParameter(campaignsEnv, "campaignsEnv");
        Intrinsics.checkNotNullParameter(targetingParams, "targetingParams");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        this.campaignsEnv = campaignsEnv;
        this.targetingParams = targetingParams;
        this.campaignType = campaignType;
        this.groupPmId = str;
    }

    public CampaignsEnv getCampaignsEnv() {
        return this.campaignsEnv;
    }

    public List<TargetingParam> getTargetingParams() {
        return this.targetingParams;
    }

    public CampaignType getCampaignType() {
        return this.campaignType;
    }

    public String getGroupPmId() {
        return this.groupPmId;
    }
}
