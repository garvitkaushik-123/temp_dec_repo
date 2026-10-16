package io.adn.sdk.internal.domain.model.ad;

import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.publisher.AdnAdInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdEntity.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"creativeAnalyticsType", "", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "toPublicAdInfo", "Lio/adn/sdk/publisher/AdnAdInfo;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEntity;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdEntityKt {
    public static final String creativeAnalyticsType(FullscreenAdScene fullscreenAdScene) {
        Intrinsics.checkNotNullParameter(fullscreenAdScene, "<this>");
        if (fullscreenAdScene instanceof FullscreenAdScene.Html) {
            return ((FullscreenAdScene.Html) fullscreenAdScene).isEndCard() ? "endcard" : AnalyticsConstants.CREATIVE_TYPE_HTML;
        }
        if (fullscreenAdScene instanceof FullscreenAdScene.Image) {
            return "image";
        }
        if (fullscreenAdScene instanceof FullscreenAdScene.Video) {
            return "video";
        }
        if (fullscreenAdScene instanceof FullscreenAdScene.PromotedAppCard) {
            return "endcard";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final AdnAdInfo toPublicAdInfo(FullscreenAdEntity fullscreenAdEntity) {
        Intrinsics.checkNotNullParameter(fullscreenAdEntity, "<this>");
        return new AdnAdInfo(fullscreenAdEntity.getExtra().getCreativeId(), null, fullscreenAdEntity.getExtra().getCampaignId(), fullscreenAdEntity.getExtra().getPrice(), fullscreenAdEntity.getExtra().getId(), 2, null);
    }
}
