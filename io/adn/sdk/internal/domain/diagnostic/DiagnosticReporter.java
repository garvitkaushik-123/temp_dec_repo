package io.adn.sdk.internal.domain.diagnostic;

import com.ironsource.C3337ue;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.publisher.AdnAdPlacement;
import kotlin.Metadata;

/* compiled from: DiagnosticReporter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "", "updateAdPlacement", "", "adPlacement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "updateBidInfo", C3337ue.n, "Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "updateShowStartedDate", "updateExpectedSceneCount", "sceneCount", "", "reportStart", "diagnosticEventBuilder", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "reportSuccess", "reportFailure", "exception", "Lio/adn/sdk/internal/domain/error/AdException;", "reportEvent", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface DiagnosticReporter {
    void reportEvent(DiagnosticEventBuilder diagnosticEventBuilder);

    void reportFailure(DiagnosticEventBuilder diagnosticEventBuilder, AdException exception);

    void reportStart(DiagnosticEventBuilder diagnosticEventBuilder);

    void reportSuccess(DiagnosticEventBuilder diagnosticEventBuilder);

    void updateAdPlacement(AdnAdPlacement adPlacement);

    void updateBidInfo(BidResponse response);

    void updateExpectedSceneCount(int sceneCount);

    void updateShowStartedDate();
}
