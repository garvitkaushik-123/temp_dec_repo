package io.adn.sdk.internal.thirdparty.omsdk;

import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.error.AdExceptionKt;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.internal.domain.repository.AdMeasurementController;
import io.adn.sdk.internal.thirdparty.omsdk.model.AdMeasurementVerificationResource;
import io.adn.sdk.internal.thirdparty.omsdk.omid.OmidNativeSessionProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeDisplayAdMeasurementController.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lio/adn/sdk/internal/thirdparty/omsdk/NativeDisplayAdMeasurementController;", "Lio/adn/sdk/internal/domain/repository/AdMeasurementController;", "omidNativeSessionProvider", "Lio/adn/sdk/internal/thirdparty/omsdk/omid/OmidNativeSessionProvider;", "adMeasurementVerificationResources", "", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdMeasurementVerificationResource;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "<init>", "(Lio/adn/sdk/internal/thirdparty/omsdk/omid/OmidNativeSessionProvider;Ljava/util/List;Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;)V", "createAdSession", "", "sceneType", "", "startAdSession", "registerAdSessionView", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "trackImpression", "trackAdLoad", "stopSession", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NativeDisplayAdMeasurementController implements AdMeasurementController {
    public static final int $stable = 8;
    private final List<AdMeasurementVerificationResource> adMeasurementVerificationResources;
    private final DiagnosticReporter diagnosticReporter;
    private final OmidNativeSessionProvider omidNativeSessionProvider;

    public NativeDisplayAdMeasurementController(OmidNativeSessionProvider omidNativeSessionProvider, List<AdMeasurementVerificationResource> adMeasurementVerificationResources, DiagnosticReporter diagnosticReporter) {
        Intrinsics.checkNotNullParameter(omidNativeSessionProvider, "omidNativeSessionProvider");
        Intrinsics.checkNotNullParameter(adMeasurementVerificationResources, "adMeasurementVerificationResources");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        this.omidNativeSessionProvider = omidNativeSessionProvider;
        this.adMeasurementVerificationResources = adMeasurementVerificationResources;
        this.diagnosticReporter = diagnosticReporter;
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementController
    public void createAdSession(String sceneType) {
        Object m10241constructorimpl;
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        try {
            Result.Companion companion = Result.INSTANCE;
            NativeDisplayAdMeasurementController nativeDisplayAdMeasurementController = this;
            this.omidNativeSessionProvider.createNativeAdSession(this.adMeasurementVerificationResources);
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
            NativeDisplayAdMeasurementController nativeDisplayAdMeasurementController = this;
            this.omidNativeSessionProvider.startSession();
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
        this.omidNativeSessionProvider.registerAdSessionView(view);
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementController
    public void trackImpression() {
        this.omidNativeSessionProvider.trackImpression();
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementController
    public void trackAdLoad() {
        this.omidNativeSessionProvider.trackAdLoad();
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementController
    public void stopSession() {
        this.omidNativeSessionProvider.stopSession();
    }
}
