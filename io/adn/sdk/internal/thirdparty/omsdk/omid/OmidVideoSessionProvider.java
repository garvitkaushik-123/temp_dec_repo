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
import com.iab.omid.library.voodooio.adsession.media.InteractionType;
import com.iab.omid.library.voodooio.adsession.media.MediaEvents;
import com.iab.omid.library.voodooio.adsession.media.Position;
import com.iab.omid.library.voodooio.adsession.media.VastProperties;
import com.mbridge.msdk.MBridgeConstans;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.repository.AdMeasurementSessionProvider;
import io.adn.sdk.internal.domain.repository.StorageRepository;
import io.adn.sdk.internal.thirdparty.omsdk.model.AdMeasurementConfiguration;
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

/* compiled from: OmidVideoSessionProvider.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0014\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001c\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\u0006\u0010\"\u001a\u00020\u000bJ\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020%J\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u000bJ\u0006\u0010,\u001a\u00020\u000bJ\u0006\u0010-\u001a\u00020\u000bJ\u0006\u0010.\u001a\u00020\u000bJ\u0006\u0010/\u001a\u00020\u000bJ(\u00100\u001a\u00020\u001e2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0014H\u0002J\u001d\u00107\u001a\u00020\u000b2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b09H\u0082\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lio/adn/sdk/internal/thirdparty/omsdk/omid/OmidVideoSessionProvider;", "Lio/adn/sdk/internal/domain/repository/AdMeasurementSessionProvider;", "storageRepository", "Lio/adn/sdk/internal/domain/repository/StorageRepository;", "adMeasurementConfiguration", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdMeasurementConfiguration;", "<init>", "(Lio/adn/sdk/internal/domain/repository/StorageRepository;Lio/adn/sdk/internal/thirdparty/omsdk/model/AdMeasurementConfiguration;)V", "activeSession", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdSessionWithEvents$VideoAdSessionWithEvents;", "startSession", "", "registerAdSessionView", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "trackImpression", "trackAdLoad", "stopSession", "createVideoAdSession", "adMeasurementVerificationResources", "", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdMeasurementVerificationResource;", "createMediaEvents", "Lcom/iab/omid/library/voodooio/adsession/media/MediaEvents;", "adSession", "Lcom/iab/omid/library/voodooio/adsession/AdSession;", "createAdSession", "adSessionConfiguration", "Lcom/iab/omid/library/voodooio/adsession/AdSessionConfiguration;", "adSessionContext", "Lcom/iab/omid/library/voodooio/adsession/AdSessionContext;", "createAdEvents", "Lcom/iab/omid/library/voodooio/adsession/AdEvents;", "createVideoAdSessionConfiguration", "trackVideoAdLoad", "trackMute", "isMuted", "", "trackPlaybackStateChange", "isPlaying", "trackVideoStart", "totalDuration", "", "trackFirstQuartile", "trackMidpoint", "trackThirdQuartile", "trackComplete", "trackAdClick", "createAdSessionContext", "partner", "Lcom/iab/omid/library/voodooio/adsession/Partner;", "omidJs", "", "verificationScripts", "Lcom/iab/omid/library/voodooio/adsession/VerificationScriptResource;", "runOnSession", "action", "Lkotlin/Function1;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class OmidVideoSessionProvider implements AdMeasurementSessionProvider {
    public static final int $stable = 8;
    private AdSessionWithEvents.VideoAdSessionWithEvents activeSession;
    private final AdMeasurementConfiguration adMeasurementConfiguration;
    private final StorageRepository storageRepository;

    public OmidVideoSessionProvider(StorageRepository storageRepository, AdMeasurementConfiguration adMeasurementConfiguration) {
        Intrinsics.checkNotNullParameter(storageRepository, "storageRepository");
        Intrinsics.checkNotNullParameter(adMeasurementConfiguration, "adMeasurementConfiguration");
        this.storageRepository = storageRepository;
        this.adMeasurementConfiguration = adMeasurementConfiguration;
    }

    @Override // io.adn.sdk.internal.domain.repository.AdMeasurementSessionProvider
    public void startSession() {
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            AdSessionWithEvents.VideoAdSessionWithEvents videoAdSessionWithEvents = this.activeSession;
            if (videoAdSessionWithEvents == null) {
                throw new IllegalArgumentException("No active session to start".toString());
            }
            videoAdSessionWithEvents.getAdSession().start();
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void createVideoAdSession(List<AdMeasurementVerificationResource> adMeasurementVerificationResources) {
        Intrinsics.checkNotNullParameter(adMeasurementVerificationResources, "adMeasurementVerificationResources");
        AdSession createAdSession = createAdSession(createVideoAdSessionConfiguration(), createAdSessionContext(Partner.createPartner(OmidParametersKt.PARTNER_NAME, "4.25.2"), FilesKt.readText$default(this.storageRepository.getCachedFile(OmidParametersKt.OMID_SDK_JS_URL, OmidParametersKt.FALLBACK_OMID_SDK_JS_FILE_NAME), null, 1, null), OmidVerificationResourcesProviderKt.getVerificationScriptResources(adMeasurementVerificationResources)));
        this.activeSession = new AdSessionWithEvents.VideoAdSessionWithEvents(createAdSession, createAdEvents(createAdSession), createMediaEvents(createAdSession));
    }

    private final MediaEvents createMediaEvents(AdSession adSession) {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            m10241constructorimpl = Result.m10241constructorimpl(MediaEvents.createMediaEvents(adSession));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
            throw new AdException(AdError.OmidMediaEventFailure, m10244exceptionOrNullimpl.getMessage());
        }
        Intrinsics.checkNotNullExpressionValue(m10241constructorimpl, "getOrElse(...)");
        return (MediaEvents) m10241constructorimpl;
    }

    private final AdSession createAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
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
            OmidVideoSessionProvider omidVideoSessionProvider = this;
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

    private final AdSessionConfiguration createVideoAdSessionConfiguration() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            m10241constructorimpl = Result.m10241constructorimpl(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.VIDEO, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NATIVE, false));
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

    private final AdSessionContext createAdSessionContext(Partner partner, String omidJs, List<VerificationScriptResource> verificationScripts) {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
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

    private final void runOnSession(Function1<? super AdSessionWithEvents.VideoAdSessionWithEvents, Unit> action) {
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            AdSessionWithEvents.VideoAdSessionWithEvents videoAdSessionWithEvents = this.activeSession;
            if (videoAdSessionWithEvents == null) {
                throw new IllegalArgumentException("No active session".toString());
            }
            action.invoke(videoAdSessionWithEvents);
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
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            AdSessionWithEvents.VideoAdSessionWithEvents videoAdSessionWithEvents = this.activeSession;
            if (videoAdSessionWithEvents != null) {
                videoAdSessionWithEvents.getAdSession().registerAdView(view);
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
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            AdSessionWithEvents.VideoAdSessionWithEvents videoAdSessionWithEvents = this.activeSession;
            if (videoAdSessionWithEvents != null) {
                videoAdSessionWithEvents.getAdEvents().impressionOccurred();
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
        VastProperties createVastPropertiesForNonSkippableMedia;
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            AdSessionWithEvents.VideoAdSessionWithEvents videoAdSessionWithEvents = this.activeSession;
            if (videoAdSessionWithEvents != null) {
                if (this.adMeasurementConfiguration.isSkippable()) {
                    createVastPropertiesForNonSkippableMedia = VastProperties.createVastPropertiesForSkippableMedia(this.adMeasurementConfiguration.getSkipOffset(), true, Position.STANDALONE);
                } else {
                    createVastPropertiesForNonSkippableMedia = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
                }
                videoAdSessionWithEvents.getAdEvents().loaded(createVastPropertiesForNonSkippableMedia);
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
        AdSessionWithEvents.VideoAdSessionWithEvents videoAdSessionWithEvents;
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            videoAdSessionWithEvents = this.activeSession;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (videoAdSessionWithEvents != null) {
            videoAdSessionWithEvents.getAdSession().finish();
            Result.m10241constructorimpl(Unit.INSTANCE);
            this.activeSession = null;
            return;
        }
        throw new IllegalArgumentException("No active session".toString());
    }

    public final void trackVideoAdLoad() {
        VastProperties createVastPropertiesForNonSkippableMedia;
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            AdSessionWithEvents.VideoAdSessionWithEvents videoAdSessionWithEvents = this.activeSession;
            if (videoAdSessionWithEvents != null) {
                if (this.adMeasurementConfiguration.isSkippable()) {
                    createVastPropertiesForNonSkippableMedia = VastProperties.createVastPropertiesForSkippableMedia(this.adMeasurementConfiguration.getSkipOffset(), true, Position.STANDALONE);
                } else {
                    createVastPropertiesForNonSkippableMedia = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
                }
                videoAdSessionWithEvents.getAdEvents().loaded(createVastPropertiesForNonSkippableMedia);
                Result.m10241constructorimpl(Unit.INSTANCE);
                return;
            }
            throw new IllegalArgumentException("No active session".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void trackMute(boolean isMuted) {
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            AdSessionWithEvents.VideoAdSessionWithEvents videoAdSessionWithEvents = this.activeSession;
            if (videoAdSessionWithEvents != null) {
                videoAdSessionWithEvents.getMediaEvents().volumeChange(isMuted ? 0.0f : 1.0f);
                Result.m10241constructorimpl(Unit.INSTANCE);
                return;
            }
            throw new IllegalArgumentException("No active session".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void trackPlaybackStateChange(boolean isPlaying) {
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            AdSessionWithEvents.VideoAdSessionWithEvents videoAdSessionWithEvents = this.activeSession;
            if (videoAdSessionWithEvents != null) {
                if (isPlaying) {
                    videoAdSessionWithEvents.getMediaEvents().resume();
                } else {
                    videoAdSessionWithEvents.getMediaEvents().pause();
                }
                Result.m10241constructorimpl(Unit.INSTANCE);
                return;
            }
            throw new IllegalArgumentException("No active session".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void trackVideoStart(float totalDuration) {
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            AdSessionWithEvents.VideoAdSessionWithEvents videoAdSessionWithEvents = this.activeSession;
            if (videoAdSessionWithEvents != null) {
                videoAdSessionWithEvents.getMediaEvents().start(totalDuration, 0.0f);
                Result.m10241constructorimpl(Unit.INSTANCE);
                return;
            }
            throw new IllegalArgumentException("No active session".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void trackFirstQuartile() {
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            AdSessionWithEvents.VideoAdSessionWithEvents videoAdSessionWithEvents = this.activeSession;
            if (videoAdSessionWithEvents != null) {
                videoAdSessionWithEvents.getMediaEvents().firstQuartile();
                Result.m10241constructorimpl(Unit.INSTANCE);
                return;
            }
            throw new IllegalArgumentException("No active session".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void trackMidpoint() {
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            AdSessionWithEvents.VideoAdSessionWithEvents videoAdSessionWithEvents = this.activeSession;
            if (videoAdSessionWithEvents != null) {
                videoAdSessionWithEvents.getMediaEvents().midpoint();
                Result.m10241constructorimpl(Unit.INSTANCE);
                return;
            }
            throw new IllegalArgumentException("No active session".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void trackThirdQuartile() {
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            AdSessionWithEvents.VideoAdSessionWithEvents videoAdSessionWithEvents = this.activeSession;
            if (videoAdSessionWithEvents != null) {
                videoAdSessionWithEvents.getMediaEvents().thirdQuartile();
                Result.m10241constructorimpl(Unit.INSTANCE);
                return;
            }
            throw new IllegalArgumentException("No active session".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void trackComplete() {
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            AdSessionWithEvents.VideoAdSessionWithEvents videoAdSessionWithEvents = this.activeSession;
            if (videoAdSessionWithEvents != null) {
                videoAdSessionWithEvents.getMediaEvents().complete();
                Result.m10241constructorimpl(Unit.INSTANCE);
                return;
            }
            throw new IllegalArgumentException("No active session".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void trackAdClick() {
        try {
            Result.Companion companion = Result.INSTANCE;
            OmidVideoSessionProvider omidVideoSessionProvider = this;
            AdSessionWithEvents.VideoAdSessionWithEvents videoAdSessionWithEvents = this.activeSession;
            if (videoAdSessionWithEvents != null) {
                videoAdSessionWithEvents.getMediaEvents().adUserInteraction(InteractionType.CLICK);
                Result.m10241constructorimpl(Unit.INSTANCE);
                return;
            }
            throw new IllegalArgumentException("No active session".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }
}
