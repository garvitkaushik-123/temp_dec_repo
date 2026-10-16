package com.sourcepoint.cmplibrary.exception;

import com.sourcepoint.cmplibrary.campaign.CampaignManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorMessageManager.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"createErrorManager", "Lcom/sourcepoint/cmplibrary/exception/ErrorMessageManager;", "campaignManager", "Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "clientInfo", "Lcom/sourcepoint/cmplibrary/exception/ClientInfo;", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorMessageManagerKt {
    public static /* synthetic */ ErrorMessageManager createErrorManager$default(CampaignManager campaignManager, ClientInfo clientInfo, CampaignType campaignType, int i, Object obj) {
        if ((i & 4) != 0) {
            campaignType = CampaignType.GDPR;
        }
        return createErrorManager(campaignManager, clientInfo, campaignType);
    }

    public static final ErrorMessageManager createErrorManager(CampaignManager campaignManager, ClientInfo clientInfo, CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(campaignManager, "campaignManager");
        Intrinsics.checkNotNullParameter(clientInfo, "clientInfo");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        return new ErrorMessageManagerImpl(campaignManager, clientInfo, campaignType);
    }
}
