package com.sourcepoint.cmplibrary.consent;

import com.sourcepoint.cmplibrary.campaign.CampaignManager;
import com.sourcepoint.cmplibrary.consent.ConsentManagerUtils;
import com.sourcepoint.cmplibrary.data.local.DataStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConsentManagerUtils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"create", "Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils;", "Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils$Companion;", "campaignManager", "Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "dataStorage", "Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConsentManagerUtilsKt {
    public static final ConsentManagerUtils create(ConsentManagerUtils.Companion companion, CampaignManager campaignManager, DataStorage dataStorage) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(campaignManager, "campaignManager");
        Intrinsics.checkNotNullParameter(dataStorage, "dataStorage");
        return new ConsentManagerUtilsImpl(campaignManager, dataStorage);
    }
}
