package com.sourcepoint.cmplibrary.campaign;

import com.sourcepoint.cmplibrary.campaign.CampaignManager;
import com.sourcepoint.cmplibrary.data.local.DataStorage;
import com.sourcepoint.cmplibrary.model.exposed.SpConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignManager.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"create", "Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "Lcom/sourcepoint/cmplibrary/campaign/CampaignManager$Companion;", "dataStorage", "Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "spConfig", "Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CampaignManagerKt {
    public static final CampaignManager create(CampaignManager.Companion companion, DataStorage dataStorage, SpConfig spConfig) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(dataStorage, "dataStorage");
        Intrinsics.checkNotNullParameter(spConfig, "spConfig");
        return new CampaignManagerImpl(dataStorage, spConfig);
    }
}
