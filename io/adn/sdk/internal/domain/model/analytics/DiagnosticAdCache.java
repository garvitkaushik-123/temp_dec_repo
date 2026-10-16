package io.adn.sdk.internal.domain.model.analytics;

import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import io.adn.sdk.internal.domain.model.ad.BidExtra;
import io.adn.sdk.publisher.AdnAdPlacement;
import kotlin.Metadata;

/* compiled from: DiagnosticAdCache.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticAdCache;", "", "<init>", "()V", "adPlacement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "getAdPlacement", "()Lio/adn/sdk/publisher/AdnAdPlacement;", "setAdPlacement", "(Lio/adn/sdk/publisher/AdnAdPlacement;)V", "bidExtra", "Lio/adn/sdk/internal/domain/model/ad/BidExtra;", "getBidExtra", "()Lio/adn/sdk/internal/domain/model/ad/BidExtra;", "setBidExtra", "(Lio/adn/sdk/internal/domain/model/ad/BidExtra;)V", "initStartDate", "", "getInitStartDate", "()Ljava/lang/String;", "setInitStartDate", "(Ljava/lang/String;)V", JsonStorageKeyNames.SESSION_ID_KEY, "getSessionId", "setSessionId", "showStartDate", "getShowStartDate", "setShowStartDate", "expectedSceneCount", "", "getExpectedSceneCount", "()Ljava/lang/Integer;", "setExpectedSceneCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DiagnosticAdCache {
    public static final int $stable = 8;
    private AdnAdPlacement adPlacement;
    private BidExtra bidExtra;
    private Integer expectedSceneCount;
    private String initStartDate;
    private String sessionId;
    private String showStartDate;

    public final AdnAdPlacement getAdPlacement() {
        return this.adPlacement;
    }

    public final void setAdPlacement(AdnAdPlacement adnAdPlacement) {
        this.adPlacement = adnAdPlacement;
    }

    public final BidExtra getBidExtra() {
        return this.bidExtra;
    }

    public final void setBidExtra(BidExtra bidExtra) {
        this.bidExtra = bidExtra;
    }

    public final String getInitStartDate() {
        return this.initStartDate;
    }

    public final void setInitStartDate(String str) {
        this.initStartDate = str;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final String getShowStartDate() {
        return this.showStartDate;
    }

    public final void setShowStartDate(String str) {
        this.showStartDate = str;
    }

    public final Integer getExpectedSceneCount() {
        return this.expectedSceneCount;
    }

    public final void setExpectedSceneCount(Integer num) {
        this.expectedSceneCount = num;
    }
}
