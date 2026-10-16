package com.vungle.ads.internal.presenter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.LinkError;
import com.vungle.ads.PrivacyUrlError;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.TpatError;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.network.TpatRequest;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.omsdk.NativeOMTracker;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.privacy.PrivacyConsent;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.ui.PresenterAdOpenCallback;
import com.vungle.ads.internal.util.ExternalRouter;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeAdPresenter.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u0018\u0000 92\u00020\u0001:\u00019B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u000fH\u0002J\u0012\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010%H\u0002J\u0006\u0010)\u001a\u00020\"J\u0012\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010%H\u0002J\u0006\u0010,\u001a\u00020\"J\u001a\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020%2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010%J\u0010\u00100\u001a\u00020\"2\b\u00101\u001a\u0004\u0018\u00010\u0011J\b\u00102\u001a\u00020\"H\u0002J\b\u00103\u001a\u00020\"H\u0002J\u000e\u00104\u001a\u00020\"2\u0006\u00105\u001a\u000206J\u0010\u00107\u001a\u00020\"2\u0006\u00108\u001a\u00020%H\u0002R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b\u001e\u0010\u001f¨\u0006:²\u0006\n\u0010;\u001a\u00020<X\u008a\u0084\u0002"}, d2 = {"Lcom/vungle/ads/internal/presenter/NativeAdPresenter;", "", "context", "Landroid/content/Context;", "delegate", "Lcom/vungle/ads/internal/presenter/NativePresenterDelegate;", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", N6.H, "Lcom/vungle/ads/internal/platform/Platform;", "(Landroid/content/Context;Lcom/vungle/ads/internal/presenter/NativePresenterDelegate;Lcom/vungle/ads/internal/model/AdPayload;Lcom/vungle/ads/internal/platform/Platform;)V", "adStartTime", "", "Ljava/lang/Long;", "adViewed", "", "bus", "Lcom/vungle/ads/internal/presenter/AdEventListener;", "currentDialog", "Landroid/app/Dialog;", "logEntry", "Lcom/vungle/ads/internal/util/LogEntry;", "getLogEntry", "()Lcom/vungle/ads/internal/util/LogEntry;", "logEntry$delegate", "Lkotlin/Lazy;", "omTracker", "Lcom/vungle/ads/internal/omsdk/NativeOMTracker;", "tpatSender", "Lcom/vungle/ads/internal/network/TpatSender;", "getTpatSender", "()Lcom/vungle/ads/internal/network/TpatSender;", "tpatSender$delegate", "detach", "", "initOMTracker", "omSdkData", "", "needShowGdpr", "onDownload", "ctaUrl", "onImpression", "onPrivacy", "privacyUrl", "prepare", "processCommand", "action", "value", "setEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showGdpr", "start", "startTracking", "rootView", "Landroid/view/View;", "triggerEventMetricForTpat", C3040d4.h.W, "Companion", "vungle-ads_release", "omInjector", "Lcom/vungle/ads/internal/omsdk/OMInjector;"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class NativeAdPresenter {
    public static final String DOWNLOAD = "download";
    public static final String OPEN_PRIVACY = "openPrivacy";
    private static final String TAG = "NativeAdPresenter";
    public static final String TPAT = "tpat";
    public static final String VIDEO_VIEWED = "videoViewed";
    private Long adStartTime;
    private boolean adViewed;
    private final AdPayload advertisement;
    private AdEventListener bus;
    private final Context context;
    private Dialog currentDialog;
    private final NativePresenterDelegate delegate;

    /* renamed from: logEntry$delegate, reason: from kotlin metadata */
    private final Lazy logEntry;
    private NativeOMTracker omTracker;
    private final Platform platform;

    /* renamed from: tpatSender$delegate, reason: from kotlin metadata */
    private final Lazy tpatSender;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Sdk.SDKMetric.SDKMetricType> eventMap = MapsKt.mapOf(TuplesKt.to(Constants.CHECKPOINT_0, Sdk.SDKMetric.SDKMetricType.AD_START_EVENT), TuplesKt.to("clickUrl", Sdk.SDKMetric.SDKMetricType.AD_CLICK_EVENT));

    public NativeAdPresenter(final Context context, NativePresenterDelegate delegate, AdPayload adPayload, Platform platform) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(platform, "platform");
        this.context = context;
        this.delegate = delegate;
        this.advertisement = adPayload;
        this.platform = platform;
        ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
        this.tpatSender = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<TpatSender>() { // from class: com.vungle.ads.internal.presenter.NativeAdPresenter$special$$inlined$inject$1
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
        this.logEntry = LazyKt.lazy(new Function0<LogEntry>() { // from class: com.vungle.ads.internal.presenter.NativeAdPresenter$logEntry$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LogEntry invoke() {
                AdPayload adPayload2;
                adPayload2 = NativeAdPresenter.this.advertisement;
                if (adPayload2 != null) {
                    return adPayload2.getLogEntry();
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TpatSender getTpatSender() {
        return (TpatSender) this.tpatSender.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LogEntry getLogEntry() {
        return (LogEntry) this.logEntry.getValue();
    }

    /* compiled from: NativeAdPresenter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/vungle/ads/internal/presenter/NativeAdPresenter$Companion;", "", "()V", "DOWNLOAD", "", "OPEN_PRIVACY", "TAG", "TPAT", "VIDEO_VIEWED", "eventMap", "", "Lcom/vungle/ads/internal/protos/Sdk$SDKMetric$SDKMetricType;", "getEventMap$vungle_ads_release$annotations", "getEventMap$vungle_ads_release", "()Ljava/util/Map;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getEventMap$vungle_ads_release$annotations() {
        }

        private Companion() {
        }

        public final Map<String, Sdk.SDKMetric.SDKMetricType> getEventMap$vungle_ads_release() {
            return NativeAdPresenter.eventMap;
        }
    }

    public final void setEventListener(AdEventListener listener) {
        this.bus = listener;
    }

    public static /* synthetic */ void processCommand$default(NativeAdPresenter nativeAdPresenter, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        nativeAdPresenter.processCommand(str, str2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void processCommand(String action, String value) {
        String str;
        List<String> tpatUrls$default;
        Intrinsics.checkNotNullParameter(action, "action");
        switch (action.hashCode()) {
            case -511324706:
                if (action.equals("openPrivacy")) {
                    onPrivacy(value);
                    return;
                }
                break;
            case 3566511:
                if (action.equals("tpat")) {
                    String str2 = value;
                    if (str2 == null || str2.length() == 0) {
                        new TpatError(Sdk.SDKError.Reason.EMPTY_TPAT_ERROR, "Empty tpat key").setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                        return;
                    }
                    triggerEventMetricForTpat(value);
                    if (Intrinsics.areEqual(value, Constants.CHECKPOINT_0)) {
                        AdPayload adPayload = this.advertisement;
                        if (adPayload != null) {
                            tpatUrls$default = adPayload.getTpatUrls(value, this.platform.getCarrierName(), String.valueOf(this.platform.getVolumeLevel()));
                            str = value;
                        }
                        str = value;
                        tpatUrls$default = null;
                    } else {
                        AdPayload adPayload2 = this.advertisement;
                        if (adPayload2 != null) {
                            str = value;
                            tpatUrls$default = AdPayload.getTpatUrls$default(adPayload2, str, null, null, 6, null);
                        }
                        str = value;
                        tpatUrls$default = null;
                    }
                    List<String> list = tpatUrls$default;
                    if (list == null || list.isEmpty()) {
                        new TpatError(Sdk.SDKError.Reason.INVALID_TPAT_KEY, "Empty urls for tpat: " + str).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                        return;
                    }
                    Iterator<T> it = tpatUrls$default.iterator();
                    while (it.hasNext()) {
                        TpatSender.sendTpat$default(getTpatSender(), new TpatRequest.Builder((String) it.next()).tpatKey(str).withLogEntry(getLogEntry()).build(), false, 2, null);
                    }
                    return;
                }
                break;
            case 1118284383:
                if (action.equals("videoViewed")) {
                    AdEventListener adEventListener = this.bus;
                    if (adEventListener == null || this.adViewed) {
                        return;
                    }
                    this.adViewed = true;
                    if (adEventListener != null) {
                        adEventListener.onNext("adViewed", null, this.delegate.getPlacementRefId());
                    }
                    List<String> impressionUrls = this.delegate.getImpressionUrls();
                    if (impressionUrls != null) {
                        Iterator<T> it2 = impressionUrls.iterator();
                        while (it2.hasNext()) {
                            TpatSender.sendTpat$default(getTpatSender(), new TpatRequest.Builder((String) it2.next()).tpatKey("impression").withLogEntry(getLogEntry()).build(), false, 2, null);
                        }
                        return;
                    }
                    return;
                }
                break;
            case 1427818632:
                if (action.equals(DOWNLOAD)) {
                    onDownload(value);
                    return;
                }
                break;
        }
        Logger.INSTANCE.w(TAG, "Unknown native ad action: " + action);
    }

    private final void onDownload(String ctaUrl) {
        AdEventListener adEventListener;
        AdPayload.AdUnit adUnit;
        AdPayload adPayload = this.advertisement;
        final String str = null;
        List tpatUrls$default = adPayload != null ? AdPayload.getTpatUrls$default(adPayload, "clickUrl", null, null, 6, null) : null;
        List list = tpatUrls$default;
        if (list == null || list.isEmpty()) {
            new TpatError(Sdk.SDKError.Reason.EMPTY_TPAT_ERROR, "Empty tpat key: clickUrl").setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
        } else {
            Iterator it = tpatUrls$default.iterator();
            while (it.hasNext()) {
                TpatSender.sendTpat$default(getTpatSender(), new TpatRequest.Builder((String) it.next()).tpatKey("clickUrl").withLogEntry(getLogEntry()).build(), false, 2, null);
            }
        }
        if (ctaUrl != null) {
            TpatSender.sendTpat$default(getTpatSender(), new TpatRequest.Builder(ctaUrl).tpatKey(Constants.CTA_URL).withLogEntry(getLogEntry()).build(), false, 2, null);
        }
        AdPayload adPayload2 = this.advertisement;
        if (adPayload2 != null && (adUnit = adPayload2.adUnit()) != null) {
            str = adUnit.getDeeplinkUrl();
        }
        boolean launch = ExternalRouter.launch(str, ctaUrl, this.context, getLogEntry(), new PresenterAdOpenCallback() { // from class: com.vungle.ads.internal.presenter.NativeAdPresenter$onDownload$launched$1
            @Override // com.vungle.ads.internal.ui.PresenterAdOpenCallback
            public void onDeeplinkClick(boolean opened) {
                AdPayload adPayload3;
                LogEntry logEntry;
                TpatSender tpatSender;
                LogEntry logEntry2;
                if (!opened) {
                    LinkError linkError = new LinkError(Sdk.SDKError.Reason.DEEPLINK_OPEN_FAILED, "Fail to open " + str);
                    logEntry2 = this.getLogEntry();
                    linkError.setLogEntry$vungle_ads_release(logEntry2).logErrorNoReturnValue$vungle_ads_release();
                }
                adPayload3 = this.advertisement;
                List tpatUrls$default2 = adPayload3 != null ? AdPayload.getTpatUrls$default(adPayload3, Constants.DEEPLINK_CLICK, String.valueOf(opened), null, 4, null) : null;
                if (tpatUrls$default2 != null) {
                    NativeAdPresenter nativeAdPresenter = this;
                    Iterator it2 = tpatUrls$default2.iterator();
                    while (it2.hasNext()) {
                        TpatRequest.Builder tpatKey = new TpatRequest.Builder((String) it2.next()).tpatKey(Constants.DEEPLINK_CLICK);
                        logEntry = nativeAdPresenter.getLogEntry();
                        TpatRequest build = tpatKey.withLogEntry(logEntry).build();
                        tpatSender = nativeAdPresenter.getTpatSender();
                        TpatSender.sendTpat$default(tpatSender, build, false, 2, null);
                    }
                }
            }
        });
        AdEventListener adEventListener2 = this.bus;
        if (adEventListener2 != null) {
            adEventListener2.onNext("open", "adClick", this.delegate.getPlacementRefId());
        }
        if (!launch || (adEventListener = this.bus) == null) {
            return;
        }
        adEventListener.onNext("open", "adLeftApplication", this.delegate.getPlacementRefId());
    }

    private final void onPrivacy(String privacyUrl) {
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.PRIVACY_URL_OPENED), getLogEntry(), (String) null, 4, (Object) null);
        if (privacyUrl != null) {
            if (!FileUtility.INSTANCE.isValidUrl(privacyUrl)) {
                new PrivacyUrlError(privacyUrl).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                return;
            }
            if (ExternalRouter.launch$default(null, privacyUrl, this.context, getLogEntry(), null, 16, null)) {
                AdEventListener adEventListener = this.bus;
                if (adEventListener != null) {
                    adEventListener.onNext("open", "adLeftApplication", this.delegate.getPlacementRefId());
                    return;
                }
                return;
            }
            new PrivacyUrlError(privacyUrl).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
        }
    }

    public final void prepare() {
        start();
        AdEventListener adEventListener = this.bus;
        if (adEventListener != null) {
            adEventListener.onNext("start", null, this.delegate.getPlacementRefId());
        }
        this.adStartTime = Long.valueOf(System.currentTimeMillis());
    }

    private final void start() {
        if (needShowGdpr()) {
            showGdpr();
        }
    }

    public final void detach() {
        List<String> tpatUrls;
        NativeOMTracker nativeOMTracker = this.omTracker;
        if (nativeOMTracker != null) {
            nativeOMTracker.stop();
        }
        Dialog dialog = this.currentDialog;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        Long l = this.adStartTime;
        if (l != null) {
            long currentTimeMillis = System.currentTimeMillis() - l.longValue();
            AdPayload adPayload = this.advertisement;
            if (adPayload != null && (tpatUrls = adPayload.getTpatUrls(Constants.AD_CLOSE, String.valueOf(currentTimeMillis), String.valueOf(this.platform.getVolumeLevel()))) != null) {
                Iterator<T> it = tpatUrls.iterator();
                while (it.hasNext()) {
                    TpatSender.sendTpat$default(getTpatSender(), new TpatRequest.Builder((String) it.next()).tpatKey(Constants.AD_CLOSE).withLogEntry(getLogEntry()).build(), false, 2, null);
                }
            }
        }
        AdEventListener adEventListener = this.bus;
        if (adEventListener != null) {
            adEventListener.onNext("end", null, this.delegate.getPlacementRefId());
        }
    }

    private final boolean needShowGdpr() {
        return ConfigManager.INSTANCE.getGDPRIsCountryDataProtected() && Intrinsics.areEqual("unknown", PrivacyManager.INSTANCE.getConsentStatus());
    }

    private final void showGdpr() {
        PrivacyManager.INSTANCE.updateGdprConsent("opted_out_by_timeout", "vungle_modal", null);
        if (!(this.context instanceof Activity)) {
            Logger.INSTANCE.w(TAG, "We can not show GDPR dialog with application context.");
            return;
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.vungle.ads.internal.presenter.NativeAdPresenter$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                NativeAdPresenter.m9382showGdpr$lambda8(NativeAdPresenter.this, dialogInterface, i);
            }
        };
        String gDPRConsentTitle = ConfigManager.INSTANCE.getGDPRConsentTitle();
        String gDPRConsentMessage = ConfigManager.INSTANCE.getGDPRConsentMessage();
        String gDPRButtonAccept = ConfigManager.INSTANCE.getGDPRButtonAccept();
        String gDPRButtonDeny = ConfigManager.INSTANCE.getGDPRButtonDeny();
        Context context = this.context;
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, ((Activity) context).getApplicationInfo().theme));
        String str = gDPRConsentTitle;
        if (str != null && str.length() != 0) {
            builder.setTitle(str);
        }
        String str2 = gDPRConsentMessage;
        if (str2 != null && str2.length() != 0) {
            builder.setMessage(str2);
        }
        builder.setPositiveButton(gDPRButtonAccept, onClickListener);
        builder.setNegativeButton(gDPRButtonDeny, onClickListener);
        builder.setCancelable(false);
        AlertDialog create = builder.create();
        create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.vungle.ads.internal.presenter.NativeAdPresenter$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                NativeAdPresenter.m9383showGdpr$lambda9(NativeAdPresenter.this, dialogInterface);
            }
        });
        this.currentDialog = create;
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showGdpr$lambda-8, reason: not valid java name */
    public static final void m9382showGdpr$lambda8(NativeAdPresenter this$0, DialogInterface dialogInterface, int i) {
        String value;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == -2) {
            value = PrivacyConsent.OPT_OUT.getValue();
        } else if (i != -1) {
            value = "opted_out_by_timeout";
        } else {
            value = PrivacyConsent.OPT_IN.getValue();
        }
        PrivacyManager.INSTANCE.updateGdprConsent(value, "vungle_modal", null);
        this$0.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showGdpr$lambda-9, reason: not valid java name */
    public static final void m9383showGdpr$lambda9(NativeAdPresenter this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentDialog = null;
    }

    public final void initOMTracker(String omSdkData) {
        Intrinsics.checkNotNullParameter(omSdkData, "omSdkData");
        AdPayload adPayload = this.advertisement;
        boolean omEnabled = adPayload != null ? adPayload.omEnabled() : false;
        if (omSdkData.length() <= 0 || !omEnabled) {
            return;
        }
        ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
        final Context context = this.context;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<OMInjector>() { // from class: com.vungle.ads.internal.presenter.NativeAdPresenter$initOMTracker$$inlined$inject$1
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
        m9381initOMTracker$lambda10(lazy).init();
        String oMSDKJS$vungle_ads_release = m9381initOMTracker$lambda10(lazy).getOMSDKJS$vungle_ads_release();
        if (oMSDKJS$vungle_ads_release != null) {
            this.omTracker = new NativeOMTracker(omSdkData, oMSDKJS$vungle_ads_release);
        }
    }

    /* renamed from: initOMTracker$lambda-10, reason: not valid java name */
    private static final OMInjector m9381initOMTracker$lambda10(Lazy<OMInjector> lazy) {
        return lazy.getValue();
    }

    public final void startTracking(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        NativeOMTracker nativeOMTracker = this.omTracker;
        if (nativeOMTracker != null) {
            nativeOMTracker.start(rootView);
        }
    }

    public final void onImpression() {
        NativeOMTracker nativeOMTracker = this.omTracker;
        if (nativeOMTracker != null) {
            nativeOMTracker.impressionOccurred();
        }
    }

    private final void triggerEventMetricForTpat(String key) {
        Sdk.SDKMetric.SDKMetricType sDKMetricType = eventMap.get(key);
        if (sDKMetricType != null) {
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(sDKMetricType), getLogEntry(), (String) null, 4, (Object) null);
        }
    }
}
