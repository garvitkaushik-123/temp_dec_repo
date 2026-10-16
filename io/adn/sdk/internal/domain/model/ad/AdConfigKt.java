package io.adn.sdk.internal.domain.model.ad;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.adn.sdk.internal.domain.constants.LayoutConfigDefaults;
import io.adn.sdk.publisher.AdnAdPlacement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdConfig.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"getCreativeConfigOrDefault", "Lio/adn/sdk/internal/domain/model/ad/AdCreativeConfig;", "Lio/adn/sdk/internal/domain/model/ad/AdConfig;", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", FirebaseAnalytics.Param.INDEX, "", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdConfigKt {
    public static final AdCreativeConfig getCreativeConfigOrDefault(AdConfig adConfig, AdnAdPlacement placement, int i) {
        Intrinsics.checkNotNullParameter(adConfig, "<this>");
        Intrinsics.checkNotNullParameter(placement, "placement");
        List<AdCreativeConfig> creativesConfig = adConfig.getCreativesConfig();
        return (i < 0 || i >= creativesConfig.size()) ? new AdCreativeConfig(i, true, new AdCloseConfig(null, LayoutConfigDefaults.INSTANCE.closeDelay(placement, i), 0.0f, null, 0, 0, 61, null), new AdMuteConfig(false, null, 0, 0, 15, null), new AdPrivacyConfig(false, null, 0, 0, 15, null), new AdCtaConfig(false, null, 0, null, 0, 0, 63, null), new AdProgressConfig(false, null, 0, 7, null), new AdStoreConfig(0.0d, false, false, 7, null), LayoutConfigDefaults.INSTANCE.getREDIRECTION_STRATEGY(), LayoutConfigDefaults.INSTANCE.loadingStrategy(i), false) : creativesConfig.get(i);
    }
}
