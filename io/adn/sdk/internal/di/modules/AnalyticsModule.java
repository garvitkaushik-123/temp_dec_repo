package io.adn.sdk.internal.di.modules;

import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.repository.AdTrackerSender;
import kotlin.Metadata;

/* compiled from: AnalyticsModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/di/modules/AnalyticsModule;", "", "adTrackerSender", "Lio/adn/sdk/internal/domain/repository/AdTrackerSender;", "getAdTrackerSender", "()Lio/adn/sdk/internal/domain/repository/AdTrackerSender;", "createDiagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AnalyticsModule {
    DiagnosticReporter createDiagnosticReporter();

    AdTrackerSender getAdTrackerSender();
}
