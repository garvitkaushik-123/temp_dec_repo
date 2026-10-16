package com.sourcepoint.cmplibrary.exception;

import com.sourcepoint.cmplibrary.campaign.CampaignManager;
import com.sourcepoint.cmplibrary.model.exposed.SpConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ErrorMessageManager.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/sourcepoint/cmplibrary/exception/ErrorMessageManagerImpl;", "Lcom/sourcepoint/cmplibrary/exception/ErrorMessageManager;", "campaignManager", "Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "clientInfo", "Lcom/sourcepoint/cmplibrary/exception/ClientInfo;", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "(Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;Lcom/sourcepoint/cmplibrary/exception/ClientInfo;Lcom/sourcepoint/cmplibrary/exception/CampaignType;)V", "getCampaignManager", "()Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "getCampaignType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getClientInfo", "()Lcom/sourcepoint/cmplibrary/exception/ClientInfo;", "build", "", "exception", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ErrorMessageManagerImpl implements ErrorMessageManager {
    private final CampaignManager campaignManager;
    private final CampaignType campaignType;
    private final ClientInfo clientInfo;

    public ErrorMessageManagerImpl(CampaignManager campaignManager, ClientInfo clientInfo, CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(campaignManager, "campaignManager");
        Intrinsics.checkNotNullParameter(clientInfo, "clientInfo");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        this.campaignManager = campaignManager;
        this.clientInfo = clientInfo;
        this.campaignType = campaignType;
    }

    public final CampaignManager getCampaignManager() {
        return this.campaignManager;
    }

    public final ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public /* synthetic */ ErrorMessageManagerImpl(CampaignManager campaignManager, ClientInfo clientInfo, CampaignType campaignType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(campaignManager, clientInfo, (i & 4) != 0 ? CampaignType.GDPR : campaignType);
    }

    public final CampaignType getCampaignType() {
        return this.campaignType;
    }

    @Override // com.sourcepoint.cmplibrary.exception.ErrorMessageManager
    public String build(RuntimeException exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if ((exception instanceof ConsentLibExceptionK ? (ConsentLibExceptionK) exception : null) != null) {
            SpConfig spConfig = this.campaignManager.getSpConfig();
            ConsentLibExceptionK consentLibExceptionK = (ConsentLibExceptionK) exception;
            String trimIndent = StringsKt.trimIndent("\n            {\n                \"code\" : \"" + consentLibExceptionK.getCode() + "\",\n                \"accountId\" : \"" + spConfig.accountId + "\",\n                \"propertyId\" : \"" + spConfig.propertyId + "\",\n                \"propertyHref\" : \"" + spConfig.propertyName + "\",\n                \"description\" : \"" + consentLibExceptionK.getDescription() + "\",\n                \"clientVersion\" : \"" + this.clientInfo.getClientVersion() + "\",\n                \"OSVersion\" : \"" + this.clientInfo.getOsVersion() + "\",\n                \"deviceFamily\" : \"" + this.clientInfo.getDeviceFamily() + "\",\n                \"legislation\" : \"" + this.campaignType.name() + "\"\n            }\n            ");
            return trimIndent == null ? "" : trimIndent;
        }
        return "";
    }
}
