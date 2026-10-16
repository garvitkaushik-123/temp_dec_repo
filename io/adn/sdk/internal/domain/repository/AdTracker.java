package io.adn.sdk.internal.domain.repository;

import com.adjust.sdk.Constants;
import io.adn.sdk.internal.domain.model.ad.AdLink;
import io.adn.sdk.internal.domain.model.ad.ClickData;
import io.adn.sdk.internal.domain.model.ad.PostClickData;
import java.util.List;
import kotlin.Metadata;

/* compiled from: AdTracker.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u001e\u0010\r\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lio/adn/sdk/internal/domain/repository/AdTracker;", "", "trackImpression", "", "impressionTrackers", "", "", "trackClick", "", "link", "Lio/adn/sdk/internal/domain/model/ad/AdLink;", "clickData", "Lio/adn/sdk/internal/domain/model/ad/ClickData;", "trackPostClick", Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH, "postClickData", "Lio/adn/sdk/internal/domain/model/ad/PostClickData;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdTracker {
    void trackClick(AdLink link, ClickData clickData);

    boolean trackImpression(List<String> impressionTrackers);

    void trackPostClick(List<String> trackers, PostClickData postClickData);

    /* compiled from: AdTracker.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void trackClick$default(AdTracker adTracker, AdLink adLink, ClickData clickData, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackClick");
            }
            if ((i & 2) != 0) {
                clickData = null;
            }
            adTracker.trackClick(adLink, clickData);
        }
    }
}
