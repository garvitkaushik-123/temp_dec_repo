package com.sourcepoint.cmplibrary.util.extensions;

import com.sourcepoint.cmplibrary.creation.ConfigOption;
import com.sourcepoint.cmplibrary.data.network.model.optimized.includeData.IncludeDataGppParam;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.SpCampaign;
import com.sourcepoint.cmplibrary.model.exposed.SpConfig;
import com.sourcepoint.cmplibrary.model.exposed.SpGppConfig;
import com.sourcepoint.cmplibrary.model.exposed.SpGppOptionBinary;
import com.sourcepoint.cmplibrary.model.exposed.SpGppOptionTernary;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;

/* compiled from: SpConfigExt.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u001f\u0010\n\u001a\u00020\u0004*\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"getGppCustomOption", "Lkotlinx/serialization/json/JsonElement;", "Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;", "hasSupportForLegacyUSPString", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/includeData/IncludeDataGppParam;", "hasTransitionCCPAAuth", "", "isIncluded", "campaign", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "toIncludeDataGppParam", "Lcom/sourcepoint/cmplibrary/model/exposed/SpGppConfig;", "supportLegacyUSPString", "(Lcom/sourcepoint/cmplibrary/model/exposed/SpGppConfig;Ljava/lang/Boolean;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/includeData/IncludeDataGppParam;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpConfigExtKt {
    public static final boolean isIncluded(SpConfig spConfig, CampaignType campaign) {
        Object obj;
        Intrinsics.checkNotNullParameter(spConfig, "<this>");
        Intrinsics.checkNotNullParameter(campaign, "campaign");
        Iterator<T> it = spConfig.campaigns.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SpCampaign) obj).campaignType == campaign) {
                break;
            }
        }
        return obj != null;
    }

    public static final boolean hasTransitionCCPAAuth(SpConfig spConfig) {
        Object obj;
        Object obj2;
        Set<? extends ConfigOption> set;
        Intrinsics.checkNotNullParameter(spConfig, "<this>");
        Iterator<T> it = spConfig.campaigns.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((SpCampaign) obj2).campaignType == CampaignType.USNAT) {
                break;
            }
        }
        SpCampaign spCampaign = (SpCampaign) obj2;
        if (spCampaign != null && (set = spCampaign.configParams) != null) {
            Iterator<T> it2 = set.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (((ConfigOption) next) == ConfigOption.TRANSITION_CCPA_AUTH) {
                    obj = next;
                    break;
                }
            }
            obj = (ConfigOption) obj;
        }
        return obj != null;
    }

    public static final IncludeDataGppParam hasSupportForLegacyUSPString(SpConfig spConfig) {
        Object obj;
        Set<? extends ConfigOption> set;
        Object obj2;
        Intrinsics.checkNotNullParameter(spConfig, "<this>");
        Iterator<T> it = spConfig.campaigns.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SpCampaign) obj).campaignType == CampaignType.USNAT) {
                break;
            }
        }
        SpCampaign spCampaign = (SpCampaign) obj;
        if (spCampaign != null && (set = spCampaign.configParams) != null) {
            Iterator<T> it2 = set.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (((ConfigOption) obj2) == ConfigOption.SUPPORT_LEGACY_USPSTRING) {
                    break;
                }
            }
            if (((ConfigOption) obj2) != null) {
                return new IncludeDataGppParam((String) null, (String) null, (String) null, (Boolean) true, 7, (DefaultConstructorMarker) null);
            }
        }
        return null;
    }

    public static final IncludeDataGppParam toIncludeDataGppParam(SpGppConfig spGppConfig, Boolean bool) {
        SpGppOptionTernary serviceProviderMode;
        SpGppOptionTernary optOutOptionMode;
        SpGppOptionBinary coveredTransaction;
        String str = null;
        String type = (spGppConfig == null || (coveredTransaction = spGppConfig.getCoveredTransaction()) == null) ? null : coveredTransaction.getType();
        String type2 = (spGppConfig == null || (optOutOptionMode = spGppConfig.getOptOutOptionMode()) == null) ? null : optOutOptionMode.getType();
        if (spGppConfig != null && (serviceProviderMode = spGppConfig.getServiceProviderMode()) != null) {
            str = serviceProviderMode.getType();
        }
        return new IncludeDataGppParam(type, type2, str, bool);
    }

    public static /* synthetic */ IncludeDataGppParam toIncludeDataGppParam$default(SpGppConfig spGppConfig, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        return toIncludeDataGppParam(spGppConfig, bool);
    }

    public static final JsonElement getGppCustomOption(SpConfig spConfig) {
        IncludeDataGppParam hasSupportForLegacyUSPString;
        IncludeDataGppParam includeDataGppParam$default;
        Intrinsics.checkNotNullParameter(spConfig, "<this>");
        if (isIncluded(spConfig, CampaignType.CCPA)) {
            SpGppConfig spGppConfig = spConfig.spGppConfig;
            if (spGppConfig == null || (includeDataGppParam$default = toIncludeDataGppParam$default(spGppConfig, null, 1, null)) == null) {
                return null;
            }
            Json.Companion companion = Json.INSTANCE;
            companion.getSerializersModule();
            return companion.encodeToJsonElement(IncludeDataGppParam.INSTANCE.serializer(), includeDataGppParam$default);
        }
        if (!isIncluded(spConfig, CampaignType.USNAT) || (hasSupportForLegacyUSPString = hasSupportForLegacyUSPString(spConfig)) == null) {
            return null;
        }
        Json.Companion companion2 = Json.INSTANCE;
        companion2.getSerializersModule();
        return companion2.encodeToJsonElement(IncludeDataGppParam.INSTANCE.serializer(), hasSupportForLegacyUSPString);
    }
}
