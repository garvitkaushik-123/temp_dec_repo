package io.adn.sdk.internal.di.modules;

import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.common.utils.ConversionsKt;
import io.adn.sdk.internal.common.utils.DateKt;
import io.adn.sdk.internal.data.repository.AdTrackerSenderImpl;
import io.adn.sdk.internal.data.repository.DiagnosticTrackerImpl;
import io.adn.sdk.internal.di.SdkInjector;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporterImpl;
import io.adn.sdk.internal.domain.diagnostic.NoOpDiagnosticReporterImpl;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticAdCache;
import io.adn.sdk.internal.domain.model.config.SdkParameterKey;
import io.adn.sdk.internal.domain.repository.AdTrackerSender;
import io.adn.sdk.internal.domain.repository.DiagnosticTracker;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: AnalyticsModule.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lio/adn/sdk/internal/di/modules/AnalyticsModuleImpl;", "Lio/adn/sdk/internal/di/modules/AnalyticsModule;", "<init>", "()V", "sdkInitDate", "", "sdkSessionId", "isInDiagnosticCohort", "", "createDiagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "diagnosticTracker", "Lio/adn/sdk/internal/domain/repository/DiagnosticTracker;", "getDiagnosticTracker", "()Lio/adn/sdk/internal/domain/repository/DiagnosticTracker;", "diagnosticTracker$delegate", "Lkotlin/Lazy;", "adTrackerSender", "Lio/adn/sdk/internal/domain/repository/AdTrackerSender;", "getAdTrackerSender", "()Lio/adn/sdk/internal/domain/repository/AdTrackerSender;", "adTrackerSender$delegate", "isDiagnosticEnabled", "diagnosticSamplingRate", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AnalyticsModuleImpl implements AnalyticsModule {
    public static final int $stable = 8;

    /* renamed from: adTrackerSender$delegate, reason: from kotlin metadata */
    private final Lazy adTrackerSender;

    /* renamed from: diagnosticTracker$delegate, reason: from kotlin metadata */
    private final Lazy diagnosticTracker;
    private final boolean isInDiagnosticCohort;
    private final String sdkInitDate;
    private final String sdkSessionId;

    public AnalyticsModuleImpl() {
        String utcNow = DateKt.utcNow();
        Intrinsics.checkNotNullExpressionValue(utcNow, "utcNow(...)");
        this.sdkInitDate = utcNow;
        this.sdkSessionId = ConversionsKt.randomUUID();
        this.isInDiagnosticCohort = Random.INSTANCE.nextInt(100) <= diagnosticSamplingRate();
        this.diagnosticTracker = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.AnalyticsModuleImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DiagnosticTrackerImpl diagnosticTracker_delegate$lambda$2;
                diagnosticTracker_delegate$lambda$2 = AnalyticsModuleImpl.diagnosticTracker_delegate$lambda$2();
                return diagnosticTracker_delegate$lambda$2;
            }
        });
        this.adTrackerSender = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.AnalyticsModuleImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AdTrackerSenderImpl adTrackerSender_delegate$lambda$4;
                adTrackerSender_delegate$lambda$4 = AnalyticsModuleImpl.adTrackerSender_delegate$lambda$4();
                return adTrackerSender_delegate$lambda$4;
            }
        });
    }

    @Override // io.adn.sdk.internal.di.modules.AnalyticsModule
    public DiagnosticReporter createDiagnosticReporter() {
        if (isDiagnosticEnabled()) {
            DiagnosticTracker diagnosticTracker = getDiagnosticTracker();
            DiagnosticAdCache diagnosticAdCache = new DiagnosticAdCache();
            diagnosticAdCache.setInitStartDate(this.sdkInitDate);
            diagnosticAdCache.setSessionId(this.sdkSessionId);
            return new DiagnosticReporterImpl(diagnosticTracker, diagnosticAdCache, SdkInjector.INSTANCE.getSdkModule().getDeviceMetricsRepository());
        }
        return new NoOpDiagnosticReporterImpl();
    }

    private final DiagnosticTracker getDiagnosticTracker() {
        return (DiagnosticTracker) this.diagnosticTracker.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiagnosticTrackerImpl diagnosticTracker_delegate$lambda$2() {
        SdkModule sdkModule = SdkInjector.INSTANCE.getSdkModule();
        return new DiagnosticTrackerImpl(sdkModule.getRemoteDataSource(), sdkModule.getLocalDataSource(), null, 4, null);
    }

    @Override // io.adn.sdk.internal.di.modules.AnalyticsModule
    public AdTrackerSender getAdTrackerSender() {
        return (AdTrackerSender) this.adTrackerSender.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AdTrackerSenderImpl adTrackerSender_delegate$lambda$4() {
        return new AdTrackerSenderImpl(SdkInjector.INSTANCE.getSdkModule().getRemoteDataSource(), null, 2, null);
    }

    private final boolean isDiagnosticEnabled() {
        return Logger.INSTANCE.isVerbose() || this.isInDiagnosticCohort;
    }

    private final int diagnosticSamplingRate() {
        return ((Number) DataSourceModuleKt.externalData().getSdkParameter(SdkParameterKey.DIAGNOSTIC_SAMPLING_PERCENTAGE, 5)).intValue();
    }
}
