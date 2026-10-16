package io.adn.sdk.internal.data.repository;

import com.adjust.sdk.Constants;
import io.adn.sdk.internal.domain.model.ad.AdLink;
import io.adn.sdk.internal.domain.model.ad.AdTrackingState;
import io.adn.sdk.internal.domain.model.ad.ClickData;
import io.adn.sdk.internal.domain.model.ad.PostClickData;
import io.adn.sdk.internal.domain.repository.AdTracker;
import io.adn.sdk.internal.domain.repository.AdTrackerSender;
import io.adn.sdk.internal.ui.fullscreen.mapper.AdTrackingMapperKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdTrackerImpl.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001e\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lio/adn/sdk/internal/data/repository/AdTrackerImpl;", "Lio/adn/sdk/internal/domain/repository/AdTracker;", "adTrackerSender", "Lio/adn/sdk/internal/domain/repository/AdTrackerSender;", "<init>", "(Lio/adn/sdk/internal/domain/repository/AdTrackerSender;)V", "trackingState", "Lio/adn/sdk/internal/domain/model/ad/AdTrackingState;", "trackImpression", "", "impressionTrackers", "", "", "trackClick", "", "link", "Lio/adn/sdk/internal/domain/model/ad/AdLink;", "clickData", "Lio/adn/sdk/internal/domain/model/ad/ClickData;", "trackPostClick", Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH, "postClickData", "Lio/adn/sdk/internal/domain/model/ad/PostClickData;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdTrackerImpl implements AdTracker {
    public static final int $stable = 8;
    private final AdTrackerSender adTrackerSender;
    private final AdTrackingState trackingState;

    public AdTrackerImpl(AdTrackerSender adTrackerSender) {
        Intrinsics.checkNotNullParameter(adTrackerSender, "adTrackerSender");
        this.adTrackerSender = adTrackerSender;
        this.trackingState = new AdTrackingState(false, false, 3, null);
    }

    @Override // io.adn.sdk.internal.domain.repository.AdTracker
    public boolean trackImpression(List<String> impressionTrackers) {
        Intrinsics.checkNotNullParameter(impressionTrackers, "impressionTrackers");
        if (this.trackingState.isImpressionTracked()) {
            return false;
        }
        this.adTrackerSender.track(impressionTrackers, MapsKt.emptyMap());
        this.trackingState.setImpressionTracked(true);
        return true;
    }

    @Override // io.adn.sdk.internal.domain.repository.AdTracker
    public void trackClick(AdLink link, ClickData clickData) {
        Intrinsics.checkNotNullParameter(link, "link");
        Map<String, String> buildClickMacros = AdTrackingMapperKt.buildClickMacros(clickData);
        if (!this.trackingState.isClickTracked() && this.adTrackerSender.track(link.getClickTrackers(), buildClickMacros)) {
            this.trackingState.setClickTracked(true);
        }
        if (link instanceof AdLink.Fullscreen) {
            this.adTrackerSender.track(((AdLink.Fullscreen) link).getRedirectionTrackers(), buildClickMacros);
        }
    }

    @Override // io.adn.sdk.internal.domain.repository.AdTracker
    public void trackPostClick(List<String> trackers, PostClickData postClickData) {
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        Intrinsics.checkNotNullParameter(postClickData, "postClickData");
        this.adTrackerSender.track(trackers, AdTrackingMapperKt.buildPostClickMacros(postClickData));
    }
}
