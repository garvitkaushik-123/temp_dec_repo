package com.sourcepoint.cmplibrary.data;

import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.sourcepoint.cmplibrary.campaign.CampaignManager;
import com.sourcepoint.cmplibrary.consent.ConsentManagerUtils;
import com.sourcepoint.cmplibrary.core.ExecutorManager;
import com.sourcepoint.cmplibrary.data.Service;
import com.sourcepoint.cmplibrary.data.local.DataStorage;
import com.sourcepoint.cmplibrary.data.network.NetworkClient;
import com.sourcepoint.cmplibrary.data.network.connection.ConnectionManager;
import com.sourcepoint.cmplibrary.exception.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServiceImpl.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¨\u0006\u0011"}, d2 = {"create", "Lcom/sourcepoint/cmplibrary/data/Service;", "Lcom/sourcepoint/cmplibrary/data/Service$Companion;", ResourceManager.KEY_MD5CHECK, "Lcom/sourcepoint/cmplibrary/data/network/NetworkClient;", "campaignManager", "Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "consentManagerUtils", "Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils;", "dataStorage", "Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "execManager", "Lcom/sourcepoint/cmplibrary/core/ExecutorManager;", "connectionManager", "Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServiceImplKt {
    public static final Service create(Service.Companion companion, NetworkClient nc, CampaignManager campaignManager, ConsentManagerUtils consentManagerUtils, DataStorage dataStorage, Logger logger, ExecutorManager execManager, ConnectionManager connectionManager) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(nc, "nc");
        Intrinsics.checkNotNullParameter(campaignManager, "campaignManager");
        Intrinsics.checkNotNullParameter(consentManagerUtils, "consentManagerUtils");
        Intrinsics.checkNotNullParameter(dataStorage, "dataStorage");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(execManager, "execManager");
        Intrinsics.checkNotNullParameter(connectionManager, "connectionManager");
        return new ServiceImpl(nc, campaignManager, consentManagerUtils, dataStorage, logger, execManager, connectionManager);
    }
}
