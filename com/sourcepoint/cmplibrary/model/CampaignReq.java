package com.sourcepoint.cmplibrary.model;

import com.sourcepoint.cmplibrary.data.network.util.CampaignsEnv;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.TargetingParam;
import java.util.List;
import kotlin.Metadata;

/* compiled from: MessageModelReq.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/CampaignReq;", "", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getCampaignType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "campaignsEnv", "Lcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;", "getCampaignsEnv", "()Lcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;", "groupPmId", "", "getGroupPmId", "()Ljava/lang/String;", "targetingParams", "", "Lcom/sourcepoint/cmplibrary/model/exposed/TargetingParam;", "getTargetingParams", "()Ljava/util/List;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CampaignReq {
    CampaignType getCampaignType();

    CampaignsEnv getCampaignsEnv();

    String getGroupPmId();

    List<TargetingParam> getTargetingParams();
}
