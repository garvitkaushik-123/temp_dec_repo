package com.unity3d.ads.core.domain.privacy;

import com.inmobi.sdk.InMobiSdk;
import com.unity3d.services.core.misc.JsonFlattenerRules;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: DeveloperConsentFlattenerRulesUseCase.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0096\u0002¨\u0006\u0005"}, d2 = {"Lcom/unity3d/ads/core/domain/privacy/DeveloperConsentFlattenerRulesUseCase;", "Lcom/unity3d/ads/core/domain/privacy/FlattenerRulesUseCase;", "()V", "invoke", "Lcom/unity3d/services/core/misc/JsonFlattenerRules;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DeveloperConsentFlattenerRulesUseCase implements FlattenerRulesUseCase {
    @Override // com.unity3d.ads.core.domain.privacy.FlattenerRulesUseCase
    public JsonFlattenerRules invoke() {
        return new JsonFlattenerRules(CollectionsKt.mutableListOf("privacy", InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, "pipl", AnalyticsConstants.SOURCE_USER_TYPE), CollectionsKt.listOf("value"), CollectionsKt.mutableListOf("ts"));
    }
}
