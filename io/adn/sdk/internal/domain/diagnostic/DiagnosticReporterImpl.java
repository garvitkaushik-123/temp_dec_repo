package io.adn.sdk.internal.domain.diagnostic;

import com.ironsource.C3337ue;
import io.adn.sdk.internal.common.utils.DateKt;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticAdCache;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticReportState;
import io.adn.sdk.internal.domain.repository.DeviceMetricsRepository;
import io.adn.sdk.internal.domain.repository.DiagnosticTracker;
import io.adn.sdk.publisher.AdnAdPlacement;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DiagnosticReporterImpl.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J2\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00172\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0%H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporterImpl;", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "tracker", "Lio/adn/sdk/internal/domain/repository/DiagnosticTracker;", "cache", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticAdCache;", "deviceMetricsRepository", "Lio/adn/sdk/internal/domain/repository/DeviceMetricsRepository;", "<init>", "(Lio/adn/sdk/internal/domain/repository/DiagnosticTracker;Lio/adn/sdk/internal/domain/model/analytics/DiagnosticAdCache;Lio/adn/sdk/internal/domain/repository/DeviceMetricsRepository;)V", "updateAdPlacement", "", "adPlacement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "updateBidInfo", C3337ue.n, "Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "updateShowStartedDate", "updateExpectedSceneCount", "sceneCount", "", "reportStart", "diagnosticEventBuilder", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder;", "reportSuccess", "reportFailure", "exception", "Lio/adn/sdk/internal/domain/error/AdException;", "reportEvent", "shouldIncludeDeviceMetrics", "", "report", "builder", "expectedState", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticReportState;", "newState", "block", "Lkotlin/Function0;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DiagnosticReporterImpl implements DiagnosticReporter {
    public static final int $stable = 8;
    private final DiagnosticAdCache cache;
    private final DeviceMetricsRepository deviceMetricsRepository;
    private final DiagnosticTracker tracker;

    public DiagnosticReporterImpl(DiagnosticTracker tracker, DiagnosticAdCache cache, DeviceMetricsRepository deviceMetricsRepository) {
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(deviceMetricsRepository, "deviceMetricsRepository");
        this.tracker = tracker;
        this.cache = cache;
        this.deviceMetricsRepository = deviceMetricsRepository;
    }

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void updateAdPlacement(AdnAdPlacement adPlacement) {
        Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
        this.cache.setAdPlacement(adPlacement);
    }

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void updateBidInfo(BidResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.cache.setBidExtra(response.getExtras());
    }

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void updateShowStartedDate() {
        this.cache.setShowStartDate(DateKt.utcNow());
    }

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void updateExpectedSceneCount(int sceneCount) {
        this.cache.setExpectedSceneCount(Integer.valueOf(sceneCount));
    }

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void reportStart(final DiagnosticEventBuilder diagnosticEventBuilder) {
        Intrinsics.checkNotNullParameter(diagnosticEventBuilder, "diagnosticEventBuilder");
        report(diagnosticEventBuilder, DiagnosticReportState.None, DiagnosticReportState.Start, new Function0() { // from class: io.adn.sdk.internal.domain.diagnostic.DiagnosticReporterImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit reportStart$lambda$0;
                reportStart$lambda$0 = DiagnosticReporterImpl.reportStart$lambda$0(DiagnosticReporterImpl.this, diagnosticEventBuilder);
                return reportStart$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportStart$lambda$0(DiagnosticReporterImpl diagnosticReporterImpl, DiagnosticEventBuilder diagnosticEventBuilder) {
        if (diagnosticReporterImpl.shouldIncludeDeviceMetrics(diagnosticEventBuilder)) {
            diagnosticEventBuilder.enrichWithThermalState(diagnosticReporterImpl.deviceMetricsRepository.getCurrentThermalState());
        }
        diagnosticReporterImpl.tracker.trackEvent(diagnosticEventBuilder.buildStart());
        return Unit.INSTANCE;
    }

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void reportSuccess(final DiagnosticEventBuilder diagnosticEventBuilder) {
        Intrinsics.checkNotNullParameter(diagnosticEventBuilder, "diagnosticEventBuilder");
        report$default(this, diagnosticEventBuilder, null, DiagnosticReportState.End, new Function0() { // from class: io.adn.sdk.internal.domain.diagnostic.DiagnosticReporterImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit reportSuccess$lambda$1;
                reportSuccess$lambda$1 = DiagnosticReporterImpl.reportSuccess$lambda$1(DiagnosticReporterImpl.this, diagnosticEventBuilder);
                return reportSuccess$lambda$1;
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportSuccess$lambda$1(DiagnosticReporterImpl diagnosticReporterImpl, DiagnosticEventBuilder diagnosticEventBuilder) {
        if (diagnosticReporterImpl.shouldIncludeDeviceMetrics(diagnosticEventBuilder)) {
            diagnosticEventBuilder.enrichWithThermalState(diagnosticReporterImpl.deviceMetricsRepository.getCurrentThermalState());
        }
        diagnosticReporterImpl.tracker.trackEvent(diagnosticEventBuilder.buildSuccess());
        return Unit.INSTANCE;
    }

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void reportFailure(final DiagnosticEventBuilder diagnosticEventBuilder, final AdException exception) {
        Intrinsics.checkNotNullParameter(diagnosticEventBuilder, "diagnosticEventBuilder");
        Intrinsics.checkNotNullParameter(exception, "exception");
        report$default(this, diagnosticEventBuilder, null, DiagnosticReportState.End, new Function0() { // from class: io.adn.sdk.internal.domain.diagnostic.DiagnosticReporterImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit reportFailure$lambda$2;
                reportFailure$lambda$2 = DiagnosticReporterImpl.reportFailure$lambda$2(DiagnosticReporterImpl.this, diagnosticEventBuilder, exception);
                return reportFailure$lambda$2;
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportFailure$lambda$2(DiagnosticReporterImpl diagnosticReporterImpl, DiagnosticEventBuilder diagnosticEventBuilder, AdException adException) {
        if (diagnosticReporterImpl.shouldIncludeDeviceMetrics(diagnosticEventBuilder)) {
            diagnosticEventBuilder.enrichWithThermalState(diagnosticReporterImpl.deviceMetricsRepository.getCurrentThermalState());
        }
        diagnosticReporterImpl.tracker.trackEvent(diagnosticEventBuilder.buildFailure(adException));
        return Unit.INSTANCE;
    }

    @Override // io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter
    public void reportEvent(DiagnosticEventBuilder diagnosticEventBuilder) {
        Intrinsics.checkNotNullParameter(diagnosticEventBuilder, "diagnosticEventBuilder");
        diagnosticEventBuilder.updateData(this.cache);
        this.tracker.trackEvent(diagnosticEventBuilder.build());
    }

    private final boolean shouldIncludeDeviceMetrics(DiagnosticEventBuilder diagnosticEventBuilder) {
        return (diagnosticEventBuilder instanceof DiagnosticEventBuilder.AdLoading) || (diagnosticEventBuilder instanceof DiagnosticEventBuilder.FullscreenSceneShow);
    }

    static /* synthetic */ void report$default(DiagnosticReporterImpl diagnosticReporterImpl, DiagnosticEventBuilder diagnosticEventBuilder, DiagnosticReportState diagnosticReportState, DiagnosticReportState diagnosticReportState2, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            diagnosticReportState = null;
        }
        diagnosticReporterImpl.report(diagnosticEventBuilder, diagnosticReportState, diagnosticReportState2, function0);
    }

    private final void report(DiagnosticEventBuilder builder, DiagnosticReportState expectedState, DiagnosticReportState newState, Function0<Unit> block) {
        if ((expectedState == null || builder.getReportState() == expectedState) && builder.getReportState() != newState) {
            try {
                Result.Companion companion = Result.INSTANCE;
                DiagnosticReporterImpl diagnosticReporterImpl = this;
                builder.setReportState(newState);
                builder.updateData(this.cache);
                block.invoke();
                Result.m10241constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
        }
    }
}
