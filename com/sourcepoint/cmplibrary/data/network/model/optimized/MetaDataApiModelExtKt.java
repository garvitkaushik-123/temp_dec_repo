package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.campaign.CampaignManager;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.CcpaStatus;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import com.sourcepoint.cmplibrary.util.extensions.SpConfigExtKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* compiled from: MetaDataApiModelExt.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"createMetadataArg", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$UsNatArg;", "campaignManager", "Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "stringify", "", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataParamReq;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MetaDataApiModelExtKt {
    public static final MetaDataArg.UsNatArg createMetadataArg(MetaDataArg.UsNatArg usNatArg, CampaignManager campaignManager) {
        Intrinsics.checkNotNullParameter(usNatArg, "<this>");
        Intrinsics.checkNotNullParameter(campaignManager, "campaignManager");
        boolean transitionCCPAAuth = usNatArg.getTransitionCCPAAuth();
        boolean optedOut = usNatArg.getOptedOut();
        String dateCreated = usNatArg.getDateCreated();
        USNatConsentData usNatConsentData = campaignManager.getUsNatConsentData();
        String uuid = usNatConsentData != null ? usNatConsentData.getUuid() : null;
        CcpaCS ccpaConsentStatus = campaignManager.getCcpaConsentStatus();
        if (SpConfigExtKt.isIncluded(campaignManager.getSpConfig(), CampaignType.USNAT)) {
            if (campaignManager.getAuthId() != null && SpConfigExtKt.hasTransitionCCPAAuth(campaignManager.getSpConfig())) {
                transitionCCPAAuth = true;
            } else if (ccpaConsentStatus != null && campaignManager.getUsNatConsentData() == null && (ccpaConsentStatus.getStatus() == CcpaStatus.rejectedSome || ccpaConsentStatus.getStatus() == CcpaStatus.rejectedAll)) {
                optedOut = true;
                dateCreated = ccpaConsentStatus.getDateCreated();
            }
        }
        String str = dateCreated;
        return new MetaDataArg.UsNatArg(usNatArg.getApplies(), usNatArg.getHasLocalData(), usNatArg.getGroupPmId(), usNatArg.getTargetingParams(), uuid, str, transitionCCPAAuth, optedOut);
    }

    public static final String stringify(final MetaDataParamReq metaDataParamReq) {
        Object obj;
        Intrinsics.checkNotNullParameter(metaDataParamReq, "<this>");
        Either check = FunctionalUtilsKt.check(new Function0<String>() { // from class: com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataApiModelExtKt$stringify$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                MetaDataParamReq metaDataParamReq2 = MetaDataParamReq.this;
                converter.getSerializersModule();
                return converter.encodeToString(MetaDataParamReq.INSTANCE.serializer(), metaDataParamReq2);
            }
        });
        if (check instanceof Either.Right) {
            obj = ((Either.Right) check).getR();
        } else {
            if (!(check instanceof Either.Left)) {
                throw new NoWhenBranchMatchedException();
            }
            obj = null;
        }
        String str = (String) obj;
        return str == null ? "{}" : str;
    }
}
