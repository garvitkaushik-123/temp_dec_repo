package io.adn.sdk.internal.thirdparty.omsdk;

import android.view.View;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.error.AdExceptionKt;
import io.adn.sdk.internal.domain.model.ad.PlaybackProgress;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.internal.domain.repository.AdMeasurementController;
import io.adn.sdk.internal.domain.repository.VideoAdTracking;
import io.adn.sdk.internal.thirdparty.omsdk.model.AdMeasurementVerificationResource;
import io.adn.sdk.internal.thirdparty.omsdk.model.QuartileEvent;
import io.adn.sdk.internal.thirdparty.omsdk.omid.OmidVideoSessionProvider;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoAdMeasurementController.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lio/adn/sdk/internal/thirdparty/omsdk/VideoAdMeasurementController;", "Lio/adn/sdk/internal/domain/repository/AdMeasurementController;", "Lio/adn/sdk/internal/domain/repository/VideoAdTracking;", "omidVideoSessionProvider", "Lio/adn/sdk/internal/thirdparty/omsdk/omid/OmidVideoSessionProvider;", "adMeasurementVerificationResources", "", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdMeasurementVerificationResource;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "<init>", "(Lio/adn/sdk/internal/thirdparty/omsdk/omid/OmidVideoSessionProvider;Ljava/util/List;Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;)V", "triggeredQuartiles", "", "Lio/adn/sdk/internal/thirdparty/omsdk/model/QuartileEvent;", "createAdSession", "", "sceneType", "", "startAdSession", "registerAdSessionView", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "trackImpression", "trackAdClick", "trackAdLoad", "stopSession", "trackMute", "isMuted", "", "trackPlaybackStateChange", "isPlaying", "trackPlaybackProgress", NotificationCompat.CATEGORY_PROGRESS, "Lio/adn/sdk/internal/domain/model/ad/PlaybackProgress;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VideoAdMeasurementController implements AdMeasurementController, VideoAdTracking {
    public static final int $stable = 8;
    private final List<AdMeasurementVerificationResource> adMeasurementVerificationResources;
    private final DiagnosticReporter diagnosticReporter;
    private final OmidVideoSessionProvider omidVideoSessionProvider;
    private final Set<QuartileEvent> triggeredQuartiles;

    public VideoAdMeasurementController(OmidVideoSessionProvider omidVideoSessionProvider, List<AdMeasurementVerificationResource> adMeasurementVerificationResources, DiagnosticReporter diagnosticReporter) {
        Intrinsics.checkNotNullParameter(omidVideoSessionProvider, "omidVideoSessionProvider");
        Intrinsics.checkNotNullParameter(adMeasurementVerificationResources, "adMeasurementVerificationResources");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        this.omidVideoSessionProvider = omidVideoSessionProvider;
        this.adMeasurementVerificationResources = adMeasurementVerificationResources;
        this.diagnosticReporter = diagnosticReporter;
        this.triggeredQuartiles = new LinkedHashSet();
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementController
    public void createAdSession(String sceneType) {
        Object m10241constructorimpl;
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        try {
            Result.Companion companion = Result.INSTANCE;
            VideoAdMeasurementController videoAdMeasurementController = this;
            this.triggeredQuartiles.clear();
            this.omidVideoSessionProvider.createVideoAdSession(this.adMeasurementVerificationResources);
            m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
            this.diagnosticReporter.reportFailure(new DiagnosticEventBuilder.OmidSession(sceneType), AdExceptionKt.toAdException(m10244exceptionOrNullimpl));
        }
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementController
    public void startAdSession(String sceneType) {
        Object m10241constructorimpl;
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        try {
            Result.Companion companion = Result.INSTANCE;
            VideoAdMeasurementController videoAdMeasurementController = this;
            this.omidVideoSessionProvider.startSession();
            this.diagnosticReporter.reportStart(new DiagnosticEventBuilder.OmidSession(sceneType));
            m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
            this.diagnosticReporter.reportSuccess(new DiagnosticEventBuilder.OmidSession(sceneType));
        }
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementController
    public void registerAdSessionView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.omidVideoSessionProvider.registerAdSessionView(view);
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementController
    public void trackImpression() {
        this.omidVideoSessionProvider.trackImpression();
    }

    @Override // io.adn.sdk.internal.domain.repository.VideoAdTracking
    public void trackAdClick() {
        this.omidVideoSessionProvider.trackAdClick();
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementController
    public void trackAdLoad() {
        this.omidVideoSessionProvider.trackVideoAdLoad();
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementController
    public void stopSession() {
        this.omidVideoSessionProvider.stopSession();
        this.triggeredQuartiles.clear();
    }

    @Override // io.adn.sdk.internal.domain.repository.VideoAdTracking
    public void trackMute(boolean isMuted) {
        this.omidVideoSessionProvider.trackMute(isMuted);
    }

    @Override // io.adn.sdk.internal.domain.repository.VideoAdTracking
    public void trackPlaybackStateChange(boolean isPlaying) {
        this.omidVideoSessionProvider.trackPlaybackStateChange(isPlaying);
    }

    @Override // io.adn.sdk.internal.domain.repository.VideoAdTracking
    public void trackPlaybackProgress(PlaybackProgress progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        if (!this.triggeredQuartiles.contains(QuartileEvent.START)) {
            this.omidVideoSessionProvider.trackVideoStart(progress.getTotalDuration());
            this.triggeredQuartiles.add(QuartileEvent.START);
        }
        int percentage = (int) (progress.getPercentage() * 100);
        if (percentage >= 25 && !this.triggeredQuartiles.contains(QuartileEvent.FIRST_QUARTILE)) {
            this.omidVideoSessionProvider.trackFirstQuartile();
            this.triggeredQuartiles.add(QuartileEvent.FIRST_QUARTILE);
            return;
        }
        if (percentage >= 50 && !this.triggeredQuartiles.contains(QuartileEvent.MIDPOINT)) {
            this.omidVideoSessionProvider.trackMidpoint();
            this.triggeredQuartiles.add(QuartileEvent.MIDPOINT);
        } else if (percentage >= 75 && !this.triggeredQuartiles.contains(QuartileEvent.THIRD_QUARTILE)) {
            this.omidVideoSessionProvider.trackThirdQuartile();
            this.triggeredQuartiles.add(QuartileEvent.THIRD_QUARTILE);
        } else {
            if (percentage < 100 || this.triggeredQuartiles.contains(QuartileEvent.COMPLETE)) {
                return;
            }
            this.omidVideoSessionProvider.trackComplete();
            this.triggeredQuartiles.add(QuartileEvent.COMPLETE);
        }
    }
}
