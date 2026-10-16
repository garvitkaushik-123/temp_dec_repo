package io.adn.sdk.internal.domain.repository;

import io.adn.sdk.internal.domain.model.analytics.DiagnosticEvent;
import kotlin.Metadata;

/* compiled from: DiagnosticTracker.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lio/adn/sdk/internal/domain/repository/DiagnosticTracker;", "", "trackEvent", "", "diagnosticEvent", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEvent;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface DiagnosticTracker {
    void trackEvent(DiagnosticEvent diagnosticEvent);
}
