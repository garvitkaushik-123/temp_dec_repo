package io.adn.sdk.internal.domain.diagnostic;

import com.ironsource.C3337ue;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.publisher.AdnAdPlacement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoOpDiagnosticReporterImpl.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0017"}, d2 = {"Lio/adn/sdk/internal/domain/diagnostic/NoOpDiagnosticReporterImpl;", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "<init>", "()V", "updateAdPlacement", "", "adPlacement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "updateBidInfo", C3337ue.n, "Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "updateShowStartedDate", "updateExpectedSceneCount", "sceneCount", "", "reportStart", "diagnosticEventBuilder", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "reportSuccess", "reportFailure", "exception", "Lio/adn/sdk/internal/domain/error/AdException;", "reportEvent", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NoOpDiagnosticReporterImpl implements DiagnosticReporter {
    public static final int $stable = 0;

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void reportEvent(DiagnosticEventBuilder diagnosticEventBuilder) {
        Intrinsics.checkNotNullParameter(diagnosticEventBuilder, "diagnosticEventBuilder");
    }

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void reportFailure(DiagnosticEventBuilder diagnosticEventBuilder, AdException exception) {
        Intrinsics.checkNotNullParameter(diagnosticEventBuilder, "diagnosticEventBuilder");
        Intrinsics.checkNotNullParameter(exception, "exception");
    }

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void reportStart(DiagnosticEventBuilder diagnosticEventBuilder) {
        Intrinsics.checkNotNullParameter(diagnosticEventBuilder, "diagnosticEventBuilder");
    }

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void reportSuccess(DiagnosticEventBuilder diagnosticEventBuilder) {
        Intrinsics.checkNotNullParameter(diagnosticEventBuilder, "diagnosticEventBuilder");
    }

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void updateAdPlacement(AdnAdPlacement adPlacement) {
        Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
    }

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void updateBidInfo(BidResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
    }

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void updateExpectedSceneCount(int sceneCount) {
    }

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void updateShowStartedDate() {
    }
}
