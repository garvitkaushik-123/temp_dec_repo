package com.sourcepoint.cmplibrary.model;

import com.sourcepoint.cmplibrary.data.network.util.CampaignsEnv;
import com.sourcepoint.cmplibrary.model.exposed.TargetingParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Campaign.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0000¨\u0006\n"}, d2 = {"toCampaignReqImpl", "Lcom/sourcepoint/cmplibrary/model/CampaignReqImpl;", "Lcom/sourcepoint/cmplibrary/model/CampaignTemplate;", "targetingParams", "", "Lcom/sourcepoint/cmplibrary/model/exposed/TargetingParam;", "campaignsEnv", "Lcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;", "groupPmId", "", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CampaignKt {
    public static /* synthetic */ CampaignReqImpl toCampaignReqImpl$default(CampaignTemplate campaignTemplate, List list, CampaignsEnv campaignsEnv, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return toCampaignReqImpl(campaignTemplate, list, campaignsEnv, str);
    }

    public static final CampaignReqImpl toCampaignReqImpl(CampaignTemplate campaignTemplate, List<TargetingParam> targetingParams, CampaignsEnv campaignsEnv, String str) {
        Intrinsics.checkNotNullParameter(campaignTemplate, "<this>");
        Intrinsics.checkNotNullParameter(targetingParams, "targetingParams");
        Intrinsics.checkNotNullParameter(campaignsEnv, "campaignsEnv");
        List<TargetingParam> list = targetingParams;
        if (list.isEmpty()) {
            list = CollectionsKt.emptyList();
        }
        return new CampaignReqImpl(list, campaignsEnv, campaignTemplate.getCampaignType(), str);
    }
}
