package io.adn.sdk.internal.thirdparty.omsdk.omid;

import android.view.View;
import com.iab.omid.library.voodooio.adsession.AdEvents;
import com.iab.omid.library.voodooio.adsession.AdSession;
import com.iab.omid.library.voodooio.adsession.AdSessionConfiguration;
import com.iab.omid.library.voodooio.adsession.AdSessionContext;
import com.iab.omid.library.voodooio.adsession.CreativeType;
import com.iab.omid.library.voodooio.adsession.ImpressionType;
import com.iab.omid.library.voodooio.adsession.Owner;
import com.iab.omid.library.voodooio.adsession.Partner;
import com.iab.omid.library.voodooio.adsession.VerificationScriptResource;
import com.mbridge.msdk.MBridgeConstans;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.repository.AdMeasurementSessionProvider;
import io.adn.sdk.internal.domain.repository.StorageRepository;
import io.adn.sdk.internal.thirdparty.omsdk.model.AdMeasurementVerificationResource;
import io.adn.sdk.internal.thirdparty.omsdk.model.AdSessionWithEvents;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OmidNativeSessionProvider.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0014\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b \u0010!J\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b\"\u0010#J\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b$\u0010#J(\u0010%\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0012H\u0002J\b\u0010,\u001a\u00020\u0017H\u0002J\u001d\u0010-\u001a\u00020\t2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0/H\u0082\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lio/adn/sdk/internal/thirdparty/omsdk/omid/OmidNativeSessionProvider;", "Lio/adn/sdk/internal/domain/repository/AdMeasurementSessionProvider;", "storageRepository", "Lio/adn/sdk/internal/domain/repository/StorageRepository;", "<init>", "(Lio/adn/sdk/internal/domain/repository/StorageRepository;)V", "activeSession", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdSessionWithEvents$NativeDisplayAdSessionWithEvents;", "startSession", "", "registerAdSessionView", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "trackImpression", "trackAdLoad", "stopSession", "createNativeAdSession", "adMeasurementVerificationResources", "", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdMeasurementVerificationResource;", "createAdSession", "Lcom/iab/omid/library/voodooio/adsession/AdSession;", "adSessionConfiguration", "Lcom/iab/omid/library/voodooio/adsession/AdSessionConfiguration;", "adSessionContext", "Lcom/iab/omid/library/voodooio/adsession/AdSessionContext;", "createAdEvents", "Lcom/iab/omid/library/voodooio/adsession/AdEvents;", "adSession", "Lkotlin/Result;", "adSessionWithEvents", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdSessionWithEvents;", "registerAdSessionView-gIAlu-s", "(Lio/adn/sdk/internal/thirdparty/omsdk/model/AdSessionWithEvents;Landroid/view/View;)Ljava/lang/Object;", "trackImpression-IoAF18A", "(Lio/adn/sdk/internal/thirdparty/omsdk/model/AdSessionWithEvents;)Ljava/lang/Object;", "stopSession-IoAF18A", "createAdSessionContext", "partner", "Lcom/iab/omid/library/voodooio/adsession/Partner;", "omidJs", "", "verificationScripts", "Lcom/iab/omid/library/voodooio/adsession/VerificationScriptResource;", "createNativeSessionConfiguration", "runOnSession", "action", "Lkotlin/Function1;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class OmidNativeSessionProvider implements AdMeasurementSessionProvider {
    public static final int $stable = 8;
    private AdSessionWithEvents.NativeDisplayAdSessionWithEvents activeSession;
    private final StorageRepository storageRepository;

    public OmidNativeSessionProvider(StorageRepository storageRepository) {
        Intrinsics.checkNotNullParameter(storageRepository, "storageRepository");
        this.storageRepository = storageRepository;
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementSessionProvider
    public void startSession() {
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidNativeSessionProvider omidNativeSessionProvider = this;
            AdSessionWithEvents.NativeDisplayAdSessionWithEvents nativeDisplayAdSessionWithEvents = this.activeSession;
            if (nativeDisplayAdSessionWithEvents == null) {
                throw new IllegalArgumentException("No active session to start".toString());
            }
            nativeDisplayAdSessionWithEvents.getAdSession().start();
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void createNativeAdSession(List<AdMeasurementVerificationResource> adMeasurementVerificationResources) {
        Intrinsics.checkNotNullParameter(adMeasurementVerificationResources, "adMeasurementVerificationResources");
        AdSession createAdSession = createAdSession(createNativeSessionConfiguration(), createAdSessionContext(Partner.createPartner(OmidParametersKt.PARTNER_NAME, "4.25.2"), FilesKt.readText$default(this.storageRepository.getCachedFile(OmidParametersKt.OMID_SDK_JS_URL, OmidParametersKt.FALLBACK_OMID_SDK_JS_FILE_NAME), null, 1, null), OmidVerificationResourcesProviderKt.getVerificationScriptResources(adMeasurementVerificationResources)));
        this.activeSession = new AdSessionWithEvents.NativeDisplayAdSessionWithEvents(createAdSession, createAdEvents(createAdSession));
    }

    private final AdSession createAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidNativeSessionProvider omidNativeSessionProvider = this;
            m10241constructorimpl = Result.m10241constructorimpl(AdSession.createAdSession(adSessionConfiguration, adSessionContext));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
            throw new AdException(AdError.OmidSessionFailure, m10244exceptionOrNullimpl.getMessage());
        }
        Intrinsics.checkNotNullExpressionValue(m10241constructorimpl, "getOrElse(...)");
        return (AdSession) m10241constructorimpl;
    }

    private final AdEvents createAdEvents(AdSession adSession) {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidNativeSessionProvider omidNativeSessionProvider = this;
            m10241constructorimpl = Result.m10241constructorimpl(AdEvents.createAdEvents(adSession));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
            throw new AdException(AdError.OmidAdEventFailure, m10244exceptionOrNullimpl.getMessage());
        }
        Intrinsics.checkNotNullExpressionValue(m10241constructorimpl, "getOrElse(...)");
        return (AdEvents) m10241constructorimpl;
    }

    /* renamed from: registerAdSessionView-gIAlu-s, reason: not valid java name */
    public final Object m9511registerAdSessionViewgIAlus(AdSessionWithEvents adSessionWithEvents, View view) {
        Intrinsics.checkNotNullParameter(adSessionWithEvents, "adSessionWithEvents");
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidNativeSessionProvider omidNativeSessionProvider = this;
            adSessionWithEvents.getAdSession().registerAdView(view);
            return Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* renamed from: trackImpression-IoAF18A, reason: not valid java name */
    public final Object m9513trackImpressionIoAF18A(AdSessionWithEvents adSessionWithEvents) {
        Intrinsics.checkNotNullParameter(adSessionWithEvents, "adSessionWithEvents");
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidNativeSessionProvider omidNativeSessionProvider = this;
            adSessionWithEvents.getAdEvents().impressionOccurred();
            return Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* renamed from: stopSession-IoAF18A, reason: not valid java name */
    public final Object m9512stopSessionIoAF18A(AdSessionWithEvents adSessionWithEvents) {
        Intrinsics.checkNotNullParameter(adSessionWithEvents, "adSessionWithEvents");
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidNativeSessionProvider omidNativeSessionProvider = this;
            adSessionWithEvents.getAdSession().finish();
            return Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final AdSessionContext createAdSessionContext(Partner partner, String omidJs, List<VerificationScriptResource> verificationScripts) {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidNativeSessionProvider omidNativeSessionProvider = this;
            m10241constructorimpl = Result.m10241constructorimpl(AdSessionContext.createNativeAdSessionContext(partner, omidJs, verificationScripts, null, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) != null) {
            throw new AdException(AdError.OmidContextFailure, null, 2, null);
        }
        Intrinsics.checkNotNullExpressionValue(m10241constructorimpl, "getOrElse(...)");
        return (AdSessionContext) m10241constructorimpl;
    }

    private final AdSessionConfiguration createNativeSessionConfiguration() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidNativeSessionProvider omidNativeSessionProvider = this;
            m10241constructorimpl = Result.m10241constructorimpl(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.NATIVE_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) != null) {
            throw new AdException(AdError.OmidConfigurationFailure, null, 2, null);
        }
        Intrinsics.checkNotNullExpressionValue(m10241constructorimpl, "getOrElse(...)");
        return (AdSessionConfiguration) m10241constructorimpl;
    }

    private final void runOnSession(Function1<? super AdSessionWithEvents.NativeDisplayAdSessionWithEvents, Unit> action) {
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidNativeSessionProvider omidNativeSessionProvider = this;
            AdSessionWithEvents.NativeDisplayAdSessionWithEvents nativeDisplayAdSessionWithEvents = this.activeSession;
            if (nativeDisplayAdSessionWithEvents == null) {
                throw new IllegalArgumentException("No active session".toString());
            }
            action.invoke(nativeDisplayAdSessionWithEvents);
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementSessionProvider
    public void registerAdSessionView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidNativeSessionProvider omidNativeSessionProvider = this;
            AdSessionWithEvents.NativeDisplayAdSessionWithEvents nativeDisplayAdSessionWithEvents = this.activeSession;
            if (nativeDisplayAdSessionWithEvents != null) {
                nativeDisplayAdSessionWithEvents.getAdSession().registerAdView(view);
                Result.m10241constructorimpl(Unit.INSTANCE);
                return;
            }
            throw new IllegalArgumentException("No active session".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementSessionProvider
    public void trackImpression() {
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidNativeSessionProvider omidNativeSessionProvider = this;
            AdSessionWithEvents.NativeDisplayAdSessionWithEvents nativeDisplayAdSessionWithEvents = this.activeSession;
            if (nativeDisplayAdSessionWithEvents != null) {
                nativeDisplayAdSessionWithEvents.getAdEvents().impressionOccurred();
                Result.m10241constructorimpl(Unit.INSTANCE);
                return;
            }
            throw new IllegalArgumentException("No active session".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementSessionProvider
    public void trackAdLoad() {
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidNativeSessionProvider omidNativeSessionProvider = this;
            AdSessionWithEvents.NativeDisplayAdSessionWithEvents nativeDisplayAdSessionWithEvents = this.activeSession;
            if (nativeDisplayAdSessionWithEvents != null) {
                nativeDisplayAdSessionWithEvents.getAdEvents().loaded();
                Result.m10241constructorimpl(Unit.INSTANCE);
                return;
            }
            throw new IllegalArgumentException("No active session".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementSessionProvider
    public void stopSession() {
        AdSessionWithEvents.NativeDisplayAdSessionWithEvents nativeDisplayAdSessionWithEvents;
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidNativeSessionProvider omidNativeSessionProvider = this;
            nativeDisplayAdSessionWithEvents = this.activeSession;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (nativeDisplayAdSessionWithEvents != null) {
            nativeDisplayAdSessionWithEvents.getAdSession().finish();
            Result.m10241constructorimpl(Unit.INSTANCE);
            this.activeSession = null;
            return;
        }
        throw new IllegalArgumentException("No active session".toString());
    }
}
