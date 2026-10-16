package com.vungle.ads.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.AdExpiredError;
import com.vungle.ads.AdExpiredOnPlayError;
import com.vungle.ads.AdMarkupInvalidError;
import com.vungle.ads.AdMarkupJsonError;
import com.vungle.ads.AdNotLoadedCantPlay;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.InvalidAdStateError;
import com.vungle.ads.InvalidBannerSizeError;
import com.vungle.ads.InvalidWaterfallPlacementError;
import com.vungle.ads.PlacementAdTypeMismatchError;
import com.vungle.ads.PlacementNotFoundError;
import com.vungle.ads.SdkNotInitialized;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.VungleAdSize;
import com.vungle.ads.VungleAds;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.AdInternal;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.SDKExecutors;
import com.vungle.ads.internal.load.AdLoaderCallback;
import com.vungle.ads.internal.load.AdRequest;
import com.vungle.ads.internal.load.BaseAdLoader;
import com.vungle.ads.internal.load.DefaultAdLoader;
import com.vungle.ads.internal.load.RealtimeAdLoader;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.TpatRequest;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.presenter.AdEventListener;
import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.presenter.AdPlayCallbackWrapper;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.task.CleanupJob;
import com.vungle.ads.internal.task.JobRunner;
import com.vungle.ads.internal.ui.AdActivity;
import com.vungle.ads.internal.util.ActivityManager;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: AdInternal.kt */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b&\u0018\u0000 ^2\u00020\u0001:\u0002]^B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010>\u001a\u00020?2\u0006\u0010\r\u001a\u00020\u000eH\u0010¢\u0006\u0002\b@J\u0012\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020DJ\r\u0010E\u001a\u00020?H\u0000¢\u0006\u0002\bFJ\n\u0010G\u001a\u0004\u0018\u00010HH&J\u0015\u0010I\u001a\u00020D2\u0006\u0010J\u001a\u00020KH\u0000¢\u0006\u0002\bLJ\u0012\u0010M\u001a\u00020D2\b\u0010N\u001a\u0004\u0018\u00010HH&J\u0010\u0010O\u001a\u00020D2\u0006\u0010%\u001a\u00020&H&J \u0010P\u001a\u00020?2\u0006\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010R2\u0006\u0010\u0005\u001a\u00020\u0001J\u0010\u0010T\u001a\u00020?2\u0006\u0010U\u001a\u00020BH\u0016J\u0010\u0010V\u001a\u00020?2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010W\u001a\u00020?2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010X\u001a\u00020YJ\u001f\u0010Z\u001a\u00020?2\b\u0010[\u001a\u0004\u0018\u00010Y2\u0006\u0010\r\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\\R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020\u001eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b3\u00104R\u0014\u00107\u001a\u00020\u001eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00100R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u00106\u001a\u0004\b;\u0010<¨\u0006_²\u0006\n\u0010`\u001a\u00020aX\u008a\u0084\u0002²\u0006\n\u0010b\u001a\u00020cX\u008a\u0084\u0002²\u0006\n\u0010d\u001a\u00020eX\u008a\u0084\u0002²\u0006\n\u0010f\u001a\u00020gX\u008a\u0084\u0002²\u0006\n\u0010h\u001a\u00020iX\u008a\u0084\u0002²\u0006\n\u0010j\u001a\u00020kX\u008a\u0084\u0002"}, d2 = {"Lcom/vungle/ads/internal/AdInternal;", "Lcom/vungle/ads/internal/load/AdLoaderCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adLoaderCallback", "value", "Lcom/vungle/ads/internal/AdInternal$AdState;", "adState", "getAdState", "()Lcom/vungle/ads/internal/AdInternal$AdState;", "setAdState", "(Lcom/vungle/ads/internal/AdInternal$AdState;)V", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", "getAdvertisement", "()Lcom/vungle/ads/internal/model/AdPayload;", "setAdvertisement", "(Lcom/vungle/ads/internal/model/AdPayload;)V", "baseAdLoader", "Lcom/vungle/ads/internal/load/BaseAdLoader;", "bidPayload", "Lcom/vungle/ads/internal/model/BidPayload;", "getBidPayload", "()Lcom/vungle/ads/internal/model/BidPayload;", "setBidPayload", "(Lcom/vungle/ads/internal/model/BidPayload;)V", "getContext", "()Landroid/content/Context;", "loadMetric", "Lcom/vungle/ads/TimeIntervalMetric;", "logEntry", "Lcom/vungle/ads/internal/util/LogEntry;", "getLogEntry$vungle_ads_release", "()Lcom/vungle/ads/internal/util/LogEntry;", "setLogEntry$vungle_ads_release", "(Lcom/vungle/ads/internal/util/LogEntry;)V", "placement", "Lcom/vungle/ads/internal/model/Placement;", "getPlacement", "()Lcom/vungle/ads/internal/model/Placement;", "setPlacement", "(Lcom/vungle/ads/internal/model/Placement;)V", "playContext", "Ljava/lang/ref/WeakReference;", "requestMetric", "showToValidationMetric", "getShowToValidationMetric$vungle_ads_release", "()Lcom/vungle/ads/TimeIntervalMetric;", "signalManager", "Lcom/vungle/ads/internal/signals/SignalManager;", "getSignalManager", "()Lcom/vungle/ads/internal/signals/SignalManager;", "signalManager$delegate", "Lkotlin/Lazy;", "validationToPresentMetric", "getValidationToPresentMetric$vungle_ads_release", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "getVungleApiClient", "()Lcom/vungle/ads/internal/network/VungleApiClient;", "vungleApiClient$delegate", "adLoadedAndUpdateConfigure", "", "adLoadedAndUpdateConfigure$vungle_ads_release", "canPlayAd", "Lcom/vungle/ads/VungleError;", "onPlay", "", "cancelDownload", "cancelDownload$vungle_ads_release", "getAdSizeForAdRequest", "Lcom/vungle/ads/VungleAdSize;", "isErrorTerminal", IronSourceConstants.EVENTS_ERROR_CODE, "", "isErrorTerminal$vungle_ads_release", "isValidAdSize", C3040d4.h.O, "isValidAdTypeForPlacement", "loadAd", "placementId", "", "adMarkup", "onFailure", "error", "onSuccess", "play", "adPlayCallback", "Lcom/vungle/ads/internal/presenter/AdPlayCallback;", "renderAd", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "renderAd$vungle_ads_release", "AdState", "Companion", "vungle-ads_release", "jobRunner", "Lcom/vungle/ads/internal/task/JobRunner;", "omInjector", "Lcom/vungle/ads/internal/omsdk/OMInjector;", "sdkExecutors", "Lcom/vungle/ads/internal/executor/SDKExecutors;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "downloader", "Lcom/vungle/ads/internal/downloader/Downloader;", "tpatSender", "Lcom/vungle/ads/internal/network/TpatSender;"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public abstract class AdInternal implements AdLoaderCallback {
    private static final String TAG = "AdInternal";
    private static final boolean THROW_ON_ILLEGAL_TRANSITION = false;
    private AdLoaderCallback adLoaderCallback;
    private AdState adState;
    private AdPayload advertisement;
    private BaseAdLoader baseAdLoader;
    private BidPayload bidPayload;
    private final Context context;
    private TimeIntervalMetric loadMetric;
    private LogEntry logEntry;
    private Placement placement;
    private WeakReference<Context> playContext;
    private TimeIntervalMetric requestMetric;
    private final TimeIntervalMetric showToValidationMetric;

    /* renamed from: signalManager$delegate, reason: from kotlin metadata */
    private final Lazy signalManager;
    private final TimeIntervalMetric validationToPresentMetric;

    /* renamed from: vungleApiClient$delegate, reason: from kotlin metadata */
    private final Lazy vungleApiClient;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Json json = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.vungle.ads.internal.AdInternal$Companion$json$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setIgnoreUnknownKeys(true);
            Json.setEncodeDefaults(true);
            Json.setExplicitNulls(false);
        }
    }, 1, null);

    /* compiled from: AdInternal.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdState.values().length];
            iArr[AdState.NEW.ordinal()] = 1;
            iArr[AdState.LOADING.ordinal()] = 2;
            iArr[AdState.READY.ordinal()] = 3;
            iArr[AdState.PLAYING.ordinal()] = 4;
            iArr[AdState.FINISHED.ordinal()] = 5;
            iArr[AdState.ERROR.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void adLoadedAndUpdateConfigure$vungle_ads_release(AdPayload advertisement) {
        Intrinsics.checkNotNullParameter(advertisement, "advertisement");
    }

    public abstract VungleAdSize getAdSizeForAdRequest();

    public abstract boolean isValidAdSize(VungleAdSize adSize);

    public abstract boolean isValidAdTypeForPlacement(Placement placement);

    /* compiled from: AdInternal.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$Companion;", "", "()V", "TAG", "", "THROW_ON_ILLEGAL_TRANSITION", "", "json", "Lkotlinx/serialization/json/Json;", "getJson$annotations", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static /* synthetic */ void getJson$annotations() {
        }

        private Companion() {
        }
    }

    public AdInternal(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.adState = AdState.NEW;
        ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
        this.vungleApiClient = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<VungleApiClient>() { // from class: com.vungle.ads.internal.AdInternal$special$$inlined$inject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.network.VungleApiClient, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final VungleApiClient invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(VungleApiClient.class);
            }
        });
        this.showToValidationMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS);
        this.validationToPresentMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_VALIDATION_TO_PRESENT_DURATION_MS);
        ServiceLocator.Companion companion2 = ServiceLocator.INSTANCE;
        this.signalManager = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<SignalManager>() { // from class: com.vungle.ads.internal.AdInternal$special$$inlined$inject$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.signals.SignalManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SignalManager invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(SignalManager.class);
            }
        });
    }

    public final Context getContext() {
        return this.context;
    }

    public final AdState getAdState() {
        return this.adState;
    }

    public final void setAdState(AdState value) {
        AdPayload adPayload;
        String eventId;
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.isTerminalState() && (adPayload = this.advertisement) != null && (eventId = adPayload.eventId()) != null) {
            ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
            final Context context = this.context;
            m9309_set_adState_$lambda1$lambda0(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<JobRunner>() { // from class: com.vungle.ads.internal.AdInternal$_set_adState_$lambda-1$$inlined$inject$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.task.JobRunner, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final JobRunner invoke() {
                    return ServiceLocator.INSTANCE.getInstance(context).getService(JobRunner.class);
                }
            })).execute(CleanupJob.INSTANCE.makeJobInfo(eventId));
        }
        this.adState = this.adState.transitionTo(value);
    }

    /* renamed from: _set_adState_$lambda-1$lambda-0, reason: not valid java name */
    private static final JobRunner m9309_set_adState_$lambda1$lambda0(Lazy<? extends JobRunner> lazy) {
        return lazy.getValue();
    }

    public final AdPayload getAdvertisement() {
        return this.advertisement;
    }

    public final void setAdvertisement(AdPayload adPayload) {
        this.advertisement = adPayload;
    }

    public final Placement getPlacement() {
        return this.placement;
    }

    public final void setPlacement(Placement placement) {
        this.placement = placement;
    }

    public final BidPayload getBidPayload() {
        return this.bidPayload;
    }

    public final void setBidPayload(BidPayload bidPayload) {
        this.bidPayload = bidPayload;
    }

    private final VungleApiClient getVungleApiClient() {
        return (VungleApiClient) this.vungleApiClient.getValue();
    }

    /* renamed from: getShowToValidationMetric$vungle_ads_release, reason: from getter */
    public final TimeIntervalMetric getShowToValidationMetric() {
        return this.showToValidationMetric;
    }

    /* renamed from: getValidationToPresentMetric$vungle_ads_release, reason: from getter */
    public final TimeIntervalMetric getValidationToPresentMetric() {
        return this.validationToPresentMetric;
    }

    private final SignalManager getSignalManager() {
        return (SignalManager) this.signalManager.getValue();
    }

    /* renamed from: getLogEntry$vungle_ads_release, reason: from getter */
    public final LogEntry getLogEntry() {
        return this.logEntry;
    }

    public final void setLogEntry$vungle_ads_release(LogEntry logEntry) {
        this.logEntry = logEntry;
    }

    public static /* synthetic */ VungleError canPlayAd$default(AdInternal adInternal, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: canPlayAd");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        return adInternal.canPlayAd(z);
    }

    public final VungleError canPlayAd(boolean onPlay) {
        AdExpiredError adExpiredError;
        if (this.advertisement == null) {
            adExpiredError = new AdNotLoadedCantPlay("adv is null on onPlay=" + onPlay);
        } else if (this.adState == AdState.PLAYING) {
            adExpiredError = new InvalidAdStateError(Sdk.SDKError.Reason.AD_IS_PLAYING, "Current ad is playing");
        } else if (this.adState != AdState.READY) {
            adExpiredError = new InvalidAdStateError(Sdk.SDKError.Reason.AD_NOT_LOADED, this.adState + " is not READY");
        } else {
            AdPayload adPayload = this.advertisement;
            if (adPayload == null || !adPayload.hasExpired()) {
                return null;
            }
            if (onPlay) {
                adExpiredError = new AdExpiredOnPlayError();
            } else {
                adExpiredError = new AdExpiredError("adv has expired on canPlayAd()");
            }
        }
        if (onPlay) {
            adExpiredError.setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
        }
        return adExpiredError;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void loadAd(String placementId, String adMarkup, AdLoaderCallback adLoaderCallback) {
        Sdk.SDKError.Reason reason;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        Intrinsics.checkNotNullParameter(adLoaderCallback, "adLoaderCallback");
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, Sdk.SDKMetric.SDKMetricType.LOAD_AD_API, 0L, this.logEntry, null, 10, null);
        TimeIntervalMetric timeIntervalMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_LOAD_TO_CALLBACK_ADO_DURATION_MS);
        this.loadMetric = timeIntervalMetric;
        timeIntervalMetric.markStart();
        this.adLoaderCallback = adLoaderCallback;
        if (!VungleAds.INSTANCE.isInitialized()) {
            adLoaderCallback.onFailure(new SdkNotInitialized("SDK not initialized").setLogEntry$vungle_ads_release(this.logEntry).logError$vungle_ads_release());
            return;
        }
        Placement placement = ConfigManager.INSTANCE.getPlacement(placementId);
        if (placement != null) {
            this.placement = placement;
            if (!isValidAdTypeForPlacement(placement)) {
                adLoaderCallback.onFailure(new PlacementAdTypeMismatchError(placement.getReferenceId()).setLogEntry$vungle_ads_release(this.logEntry).logError$vungle_ads_release());
                return;
            }
            if ((placement.getHeaderBidding() && ((str2 = adMarkup) == null || str2.length() == 0)) || (!placement.getHeaderBidding() && (str = adMarkup) != null && str.length() != 0)) {
                adLoaderCallback.onFailure(new InvalidWaterfallPlacementError(placementId).setLogEntry$vungle_ads_release(this.logEntry).logError$vungle_ads_release());
                return;
            }
        } else if (ConfigManager.INSTANCE.configLastValidatedTimestamp() == -1) {
            placement = new Placement(placementId, false, (String) null, 6, (DefaultConstructorMarker) null);
            this.placement = placement;
        } else {
            adLoaderCallback.onFailure(new PlacementNotFoundError(placementId).setLogEntry$vungle_ads_release(this.logEntry).logError$vungle_ads_release());
            return;
        }
        VungleAdSize adSizeForAdRequest = getAdSizeForAdRequest();
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (!isValidAdSize(adSizeForAdRequest)) {
            adLoaderCallback.onFailure(new InvalidBannerSizeError(adSizeForAdRequest != null ? adSizeForAdRequest.toString() : null).setLogEntry$vungle_ads_release(this.logEntry).logError$vungle_ads_release());
            return;
        }
        if (this.adState != AdState.NEW) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.adState.ordinal()]) {
                case 1:
                    throw new NotImplementedError(objArr2 == true ? 1 : 0, 1, objArr == true ? 1 : 0);
                case 2:
                    reason = Sdk.SDKError.Reason.AD_IS_LOADING;
                    break;
                case 3:
                    reason = Sdk.SDKError.Reason.AD_ALREADY_LOADED;
                    break;
                case 4:
                    reason = Sdk.SDKError.Reason.AD_IS_PLAYING;
                    break;
                case 5:
                    reason = Sdk.SDKError.Reason.AD_CONSUMED;
                    break;
                case 6:
                    reason = Sdk.SDKError.Reason.AD_ALREADY_FAILED;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            adLoaderCallback.onFailure(new InvalidAdStateError(reason, this.adState + " state is incorrect for load").setLogEntry$vungle_ads_release(this.logEntry).logError$vungle_ads_release());
            return;
        }
        TimeIntervalMetric timeIntervalMetric2 = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_REQUEST_TO_CALLBACK_ADO_DURATION_MS);
        this.requestMetric = timeIntervalMetric2;
        timeIntervalMetric2.markStart();
        String str3 = adMarkup;
        if (str3 != null && str3.length() != 0) {
            try {
                Json json2 = json;
                KSerializer<Object> serializer = SerializersKt.serializer(json2.getSerializersModule(), Reflection.typeOf(BidPayload.class));
                Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                this.bidPayload = (BidPayload) json2.decodeFromString(serializer, adMarkup);
            } catch (IllegalArgumentException e) {
                adLoaderCallback.onFailure(new AdMarkupInvalidError("Unable to decode payload into BidPayload object. Error: " + e.getLocalizedMessage()).setLogEntry$vungle_ads_release(this.logEntry).logError$vungle_ads_release());
                return;
            } catch (Throwable th) {
                adLoaderCallback.onFailure(new AdMarkupJsonError(th.getLocalizedMessage()).setLogEntry$vungle_ads_release(this.logEntry).logError$vungle_ads_release());
                return;
            }
        }
        setAdState(AdState.LOADING);
        ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
        final Context context = this.context;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<OMInjector>() { // from class: com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.omsdk.OMInjector, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final OMInjector invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(OMInjector.class);
            }
        });
        ServiceLocator.Companion companion2 = ServiceLocator.INSTANCE;
        final Context context2 = this.context;
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<SDKExecutors>() { // from class: com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.SDKExecutors, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SDKExecutors invoke() {
                return ServiceLocator.INSTANCE.getInstance(context2).getService(SDKExecutors.class);
            }
        });
        ServiceLocator.Companion companion3 = ServiceLocator.INSTANCE;
        final Context context3 = this.context;
        Lazy lazy3 = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<PathProvider>() { // from class: com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.util.PathProvider, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final PathProvider invoke() {
                return ServiceLocator.INSTANCE.getInstance(context3).getService(PathProvider.class);
            }
        });
        ServiceLocator.Companion companion4 = ServiceLocator.INSTANCE;
        final Context context4 = this.context;
        Lazy lazy4 = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Downloader>() { // from class: com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.downloader.Downloader, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final Downloader invoke() {
                return ServiceLocator.INSTANCE.getInstance(context4).getService(Downloader.class);
            }
        });
        if (str3 == null || str3.length() == 0) {
            this.baseAdLoader = new DefaultAdLoader(this.context, getVungleApiClient(), m9311loadAd$lambda3(lazy2), m9310loadAd$lambda2(lazy), m9313loadAd$lambda5(lazy4), m9312loadAd$lambda4(lazy3), new AdRequest(placement, null, adSizeForAdRequest));
        } else {
            this.baseAdLoader = new RealtimeAdLoader(this.context, getVungleApiClient(), m9311loadAd$lambda3(lazy2), m9310loadAd$lambda2(lazy), m9313loadAd$lambda5(lazy4), m9312loadAd$lambda4(lazy3), new AdRequest(placement, this.bidPayload, adSizeForAdRequest));
        }
        BaseAdLoader baseAdLoader = this.baseAdLoader;
        if (baseAdLoader != null) {
            baseAdLoader.setLogEntry$vungle_ads_release(this.logEntry);
        }
        BaseAdLoader baseAdLoader2 = this.baseAdLoader;
        if (baseAdLoader2 != null) {
            baseAdLoader2.loadAd(this);
        }
    }

    /* renamed from: loadAd$lambda-2, reason: not valid java name */
    private static final OMInjector m9310loadAd$lambda2(Lazy<OMInjector> lazy) {
        return lazy.getValue();
    }

    /* renamed from: loadAd$lambda-3, reason: not valid java name */
    private static final SDKExecutors m9311loadAd$lambda3(Lazy<SDKExecutors> lazy) {
        return lazy.getValue();
    }

    /* renamed from: loadAd$lambda-4, reason: not valid java name */
    private static final PathProvider m9312loadAd$lambda4(Lazy<PathProvider> lazy) {
        return lazy.getValue();
    }

    /* renamed from: loadAd$lambda-5, reason: not valid java name */
    private static final Downloader m9313loadAd$lambda5(Lazy<? extends Downloader> lazy) {
        return lazy.getValue();
    }

    public final void cancelDownload$vungle_ads_release() {
        BaseAdLoader baseAdLoader = this.baseAdLoader;
        if (baseAdLoader != null) {
            baseAdLoader.cancel();
        }
    }

    public final void play(Context context, final AdPlayCallback adPlayCallback) {
        WeakReference<Context> weakReference;
        Intrinsics.checkNotNullParameter(adPlayCallback, "adPlayCallback");
        this.showToValidationMetric.markStart();
        if (context != null) {
            weakReference = new WeakReference<>(context);
        } else {
            weakReference = null;
        }
        this.playContext = weakReference;
        VungleError canPlayAd = canPlayAd(true);
        if (canPlayAd != null) {
            adPlayCallback.onFailure(canPlayAd);
            if (isErrorTerminal$vungle_ads_release(canPlayAd.getCode())) {
                setAdState(AdState.ERROR);
                return;
            }
            return;
        }
        AdPayload adPayload = this.advertisement;
        if (adPayload == null) {
            return;
        }
        AdPlayCallbackWrapper adPlayCallbackWrapper = new AdPlayCallbackWrapper(adPlayCallback) { // from class: com.vungle.ads.internal.AdInternal$play$callbackWrapper$1
            @Override // com.vungle.ads.internal.presenter.AdPlayCallbackWrapper, com.vungle.ads.internal.presenter.AdPlayCallback
            public void onAdStart(String id) {
                this.setAdState(AdInternal.AdState.PLAYING);
                this.getValidationToPresentMetric().markEnd();
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.getValidationToPresentMetric(), this.getLogEntry(), (String) null, 4, (Object) null);
                super.onAdStart(id);
            }

            @Override // com.vungle.ads.internal.presenter.AdPlayCallbackWrapper, com.vungle.ads.internal.presenter.AdPlayCallback
            public void onAdEnd(String id) {
                this.setAdState(AdInternal.AdState.FINISHED);
                super.onAdEnd(id);
            }

            @Override // com.vungle.ads.internal.presenter.AdPlayCallbackWrapper, com.vungle.ads.internal.presenter.AdPlayCallback
            public void onFailure(VungleError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                this.setAdState(AdInternal.AdState.ERROR);
                super.onFailure(error);
            }
        };
        cancelDownload$vungle_ads_release();
        renderAd$vungle_ads_release(adPlayCallbackWrapper, adPayload);
    }

    public void renderAd$vungle_ads_release(final AdPlayCallback listener, AdPayload advertisement) {
        Context context;
        Intrinsics.checkNotNullParameter(advertisement, "advertisement");
        AdActivity.Companion companion = AdActivity.INSTANCE;
        final Placement placement = this.placement;
        companion.setEventListener$vungle_ads_release(new AdEventListener(listener, placement) { // from class: com.vungle.ads.internal.AdInternal$renderAd$1
        });
        AdActivity.INSTANCE.setAdvertisement$vungle_ads_release(advertisement);
        AdActivity.INSTANCE.setBidPayload$vungle_ads_release(this.bidPayload);
        WeakReference<Context> weakReference = this.playContext;
        if (weakReference == null || (context = weakReference.get()) == null) {
            context = this.context;
        }
        Intrinsics.checkNotNullExpressionValue(context, "playContext?.get() ?: context");
        Placement placement2 = this.placement;
        if (placement2 == null) {
            return;
        }
        Intent createIntent = AdActivity.INSTANCE.createIntent(context, placement2.getReferenceId(), advertisement.eventId());
        if (!ActivityManager.INSTANCE.isForeground()) {
            Logger.INSTANCE.d(TAG, "The ad activity is in background on play.");
            createIntent.putExtra(AdActivity.AD_INVISIBLE_LOGGED_KEY, true);
            AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.AD_VISIBILITY), this.logEntry, "1");
        }
        this.showToValidationMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.showToValidationMetric, this.logEntry, (String) null, 4, (Object) null);
        this.validationToPresentMetric.markStart();
        ActivityManager.INSTANCE.startWhenForeground(context, null, createIntent, null);
    }

    @Override // com.vungle.ads.internal.load.AdLoaderCallback
    public void onSuccess(AdPayload advertisement) {
        Intrinsics.checkNotNullParameter(advertisement, "advertisement");
        this.advertisement = advertisement;
        setAdState(AdState.READY);
        adLoadedAndUpdateConfigure$vungle_ads_release(advertisement);
        AdLoaderCallback adLoaderCallback = this.adLoaderCallback;
        if (adLoaderCallback != null) {
            adLoaderCallback.onSuccess(advertisement);
        }
        TimeIntervalMetric timeIntervalMetric = this.loadMetric;
        if (timeIntervalMetric != null) {
            if (!advertisement.adLoadOptimizationEnabled()) {
                timeIntervalMetric.setMetricType(Sdk.SDKMetric.SDKMetricType.AD_LOAD_TO_CALLBACK_DURATION_MS);
            }
            timeIntervalMetric.markEnd();
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, timeIntervalMetric, this.logEntry, (String) null, 4, (Object) null);
        }
        TimeIntervalMetric timeIntervalMetric2 = this.requestMetric;
        if (timeIntervalMetric2 != null) {
            if (!advertisement.adLoadOptimizationEnabled()) {
                timeIntervalMetric2.setMetricType(Sdk.SDKMetric.SDKMetricType.AD_REQUEST_TO_CALLBACK_DURATION_MS);
            }
            timeIntervalMetric2.markEnd();
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, timeIntervalMetric2, this.logEntry, (String) null, 4, (Object) null);
            ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
            final Context context = this.context;
            Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<TpatSender>() { // from class: com.vungle.ads.internal.AdInternal$onSuccess$lambda-10$$inlined$inject$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.network.TpatSender, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final TpatSender invoke() {
                    return ServiceLocator.INSTANCE.getInstance(context).getService(TpatSender.class);
                }
            });
            List tpatUrls$default = AdPayload.getTpatUrls$default(advertisement, Constants.AD_LOAD_DURATION, String.valueOf(timeIntervalMetric2.getValue()), null, 4, null);
            if (tpatUrls$default != null) {
                Iterator it = tpatUrls$default.iterator();
                while (it.hasNext()) {
                    TpatSender.sendTpat$default(m9314onSuccess$lambda10$lambda8(lazy), new TpatRequest.Builder((String) it.next()).tpatKey(Constants.AD_LOAD_DURATION).withLogEntry(this.logEntry).build(), false, 2, null);
                }
            }
        }
    }

    /* renamed from: onSuccess$lambda-10$lambda-8, reason: not valid java name */
    private static final TpatSender m9314onSuccess$lambda10$lambda8(Lazy<TpatSender> lazy) {
        return lazy.getValue();
    }

    @Override // com.vungle.ads.internal.load.AdLoaderCallback
    public void onFailure(VungleError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        setAdState(AdState.ERROR);
        TimeIntervalMetric timeIntervalMetric = this.loadMetric;
        if (timeIntervalMetric != null) {
            timeIntervalMetric.setMetricType(Sdk.SDKMetric.SDKMetricType.AD_LOAD_TO_FAIL_CALLBACK_DURATION_MS);
            timeIntervalMetric.markEnd();
            AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(timeIntervalMetric, this.logEntry, String.valueOf(error.getCode()));
        }
        AdLoaderCallback adLoaderCallback = this.adLoaderCallback;
        if (adLoaderCallback != null) {
            adLoaderCallback.onFailure(error);
        }
    }

    public final boolean isErrorTerminal$vungle_ads_release(int errorCode) {
        return this.adState == AdState.READY && errorCode == 304;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AdInternal.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0000H&J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$AdState;", "", "(Ljava/lang/String;I)V", "canTransitionTo", "", "adState", "isTerminalState", "transitionTo", "NEW", "LOADING", "READY", "PLAYING", "FINISHED", "ERROR", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AdState {
        public static final AdState NEW = new NEW("NEW", 0);
        public static final AdState LOADING = new LOADING("LOADING", 1);
        public static final AdState READY = new READY("READY", 2);
        public static final AdState PLAYING = new PLAYING("PLAYING", 3);
        public static final AdState FINISHED = new FINISHED("FINISHED", 4);
        public static final AdState ERROR = new ERROR("ERROR", 5);
        private static final /* synthetic */ AdState[] $VALUES = $values();

        private static final /* synthetic */ AdState[] $values() {
            return new AdState[]{NEW, LOADING, READY, PLAYING, FINISHED, ERROR};
        }

        public /* synthetic */ AdState(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static AdState valueOf(String str) {
            return (AdState) Enum.valueOf(AdState.class, str);
        }

        public static AdState[] values() {
            return (AdState[]) $VALUES.clone();
        }

        public abstract boolean canTransitionTo(AdState adState);

        /* compiled from: AdInternal.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$AdState$NEW;", "Lcom/vungle/ads/internal/AdInternal$AdState;", "canTransitionTo", "", "adState", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        static final class NEW extends AdState {
            NEW(String str, int i) {
                super(str, i, null);
            }

            @Override // com.vungle.ads.internal.AdInternal.AdState
            public boolean canTransitionTo(AdState adState) {
                Intrinsics.checkNotNullParameter(adState, "adState");
                return adState == AdState.LOADING || adState == AdState.READY || adState == AdState.ERROR;
            }
        }

        private AdState(String str, int i) {
        }

        /* compiled from: AdInternal.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$AdState$LOADING;", "Lcom/vungle/ads/internal/AdInternal$AdState;", "canTransitionTo", "", "adState", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        static final class LOADING extends AdState {
            LOADING(String str, int i) {
                super(str, i, null);
            }

            @Override // com.vungle.ads.internal.AdInternal.AdState
            public boolean canTransitionTo(AdState adState) {
                Intrinsics.checkNotNullParameter(adState, "adState");
                return adState == AdState.READY || adState == AdState.ERROR;
            }
        }

        /* compiled from: AdInternal.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$AdState$READY;", "Lcom/vungle/ads/internal/AdInternal$AdState;", "canTransitionTo", "", "adState", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        static final class READY extends AdState {
            READY(String str, int i) {
                super(str, i, null);
            }

            @Override // com.vungle.ads.internal.AdInternal.AdState
            public boolean canTransitionTo(AdState adState) {
                Intrinsics.checkNotNullParameter(adState, "adState");
                return adState == AdState.PLAYING || adState == AdState.FINISHED || adState == AdState.ERROR;
            }
        }

        /* compiled from: AdInternal.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$AdState$PLAYING;", "Lcom/vungle/ads/internal/AdInternal$AdState;", "canTransitionTo", "", "adState", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        static final class PLAYING extends AdState {
            PLAYING(String str, int i) {
                super(str, i, null);
            }

            @Override // com.vungle.ads.internal.AdInternal.AdState
            public boolean canTransitionTo(AdState adState) {
                Intrinsics.checkNotNullParameter(adState, "adState");
                return adState == AdState.FINISHED || adState == AdState.ERROR;
            }
        }

        /* compiled from: AdInternal.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$AdState$FINISHED;", "Lcom/vungle/ads/internal/AdInternal$AdState;", "canTransitionTo", "", "adState", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        static final class FINISHED extends AdState {
            @Override // com.vungle.ads.internal.AdInternal.AdState
            public boolean canTransitionTo(AdState adState) {
                Intrinsics.checkNotNullParameter(adState, "adState");
                return false;
            }

            FINISHED(String str, int i) {
                super(str, i, null);
            }
        }

        /* compiled from: AdInternal.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/AdInternal$AdState$ERROR;", "Lcom/vungle/ads/internal/AdInternal$AdState;", "canTransitionTo", "", "adState", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        static final class ERROR extends AdState {
            ERROR(String str, int i) {
                super(str, i, null);
            }

            @Override // com.vungle.ads.internal.AdInternal.AdState
            public boolean canTransitionTo(AdState adState) {
                Intrinsics.checkNotNullParameter(adState, "adState");
                return adState == AdState.FINISHED;
            }
        }

        public final AdState transitionTo(AdState adState) {
            Intrinsics.checkNotNullParameter(adState, "adState");
            if (this == adState || canTransitionTo(adState)) {
                return adState;
            }
            String str = "Cannot transition from " + name() + " to " + adState.name();
            if (AdInternal.THROW_ON_ILLEGAL_TRANSITION) {
                throw new IllegalStateException(str);
            }
            Logger.INSTANCE.e(AdInternal.TAG, "Illegal state transition", new IllegalStateException(str));
            return adState;
        }

        public final boolean isTerminalState() {
            return CollectionsKt.listOf((Object[]) new AdState[]{FINISHED, ERROR}).contains(this);
        }
    }
}
