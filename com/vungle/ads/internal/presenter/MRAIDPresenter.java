package com.vungle.ads.internal.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import com.ironsource.sdk.controller.f;
import com.mbridge.msdk.MBridgeConstans;
import com.vungle.ads.AdConfig;
import com.vungle.ads.AdNotLoadedCantPlay;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.HeartbeatMissingError;
import com.vungle.ads.IndexHtmlError;
import com.vungle.ads.MraidJsError;
import com.vungle.ads.MraidTemplateError;
import com.vungle.ads.NetworkUnreachable;
import com.vungle.ads.PrivacyUrlError;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.TpatError;
import com.vungle.ads.VungleError;
import com.vungle.ads.WebViewError;
import com.vungle.ads.WebViewRenderProcessUnresponsive;
import com.vungle.ads.WebViewRenderingProcessGone;
import com.vungle.ads.internal.ClickCoordinateTracker;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.Call;
import com.vungle.ads.internal.network.Callback;
import com.vungle.ads.internal.network.Response;
import com.vungle.ads.internal.network.TpatRequest;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMTracker;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.privacy.PrivacyConsent;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.ui.VungleWebClient;
import com.vungle.ads.internal.ui.view.MRAIDAdWidget;
import com.vungle.ads.internal.ui.view.WebViewAPI;
import com.vungle.ads.internal.util.ExternalRouter;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.HandlerScheduler;
import com.vungle.ads.internal.util.JsonUtil;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import com.vungle.ads.internal.util.SuspendableTimer;
import com.vungle.ads.internal.util.ThreadUtil;
import com.vungle.ads.internal.util.Utils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;

/* compiled from: MRAIDPresenter.kt */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 §\u00012\u00020\u00012\u00020\u0002:\u0002§\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\b\u0010u\u001a\u00020vH\u0002J\u0010\u0010w\u001a\u00020v2\b\b\u0001\u0010x\u001a\u00020yJ\r\u0010z\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0019J\u0006\u0010{\u001a\u00020vJ%\u0010|\u001a\u00020v2\u0006\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020\u001e2\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010fH\u0002J\u0015\u0010\u0081\u0001\u001a\u0004\u0018\u00010~2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\u0011\u0010\u0084\u0001\u001a\u00020v2\u0006\u0010}\u001a\u00020~H\u0002J\u001b\u0010\u0085\u0001\u001a\u00020v2\u0007\u0010\u0086\u0001\u001a\u00020f2\u0007\u0010\u0087\u0001\u001a\u00020\u001eH\u0016J!\u0010\u0088\u0001\u001a\u00020v2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0016J\u0007\u0010\u008d\u0001\u001a\u00020vJ\u0013\u0010\u008e\u0001\u001a\u00020v2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001J&\u0010\u0091\u0001\u001a\u00020\u001e2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008a\u00012\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0003\u0010\u0093\u0001J\u0007\u0010\u0094\u0001\u001a\u00020vJ\u001c\u0010\u0095\u0001\u001a\u00020\u001e2\u0007\u0010\u0096\u0001\u001a\u00020f2\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0016J\t\u0010\u0099\u0001\u001a\u00020vH\u0002J\u0011\u0010\u009a\u0001\u001a\u00020v2\u0006\u0010}\u001a\u00020~H\u0002J\u0010\u0010\u009b\u0001\u001a\u00020v2\u0007\u0010\u009c\u0001\u001a\u00020\u001eJ\u0012\u0010\u009d\u0001\u001a\u00020v2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010&J\u0019\u0010\u009f\u0001\u001a\u00020v2\b\u0010M\u001a\u0004\u0018\u00010NH\u0000¢\u0006\u0003\b \u0001J\u000f\u0010¡\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0003\b¢\u0001J\u0007\u0010£\u0001\u001a\u00020vJ\u0007\u0010¤\u0001\u001a\u00020vJ\u0012\u0010¥\u0001\u001a\u00020v2\u0007\u0010¦\u0001\u001a\u00020fH\u0002R(\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0081\u000e¢\u0006\u0016\n\u0002\u0010\u001c\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u001e8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R!\u0010,\u001a\u00020-8@X\u0081\u0084\u0002¢\u0006\u0012\n\u0004\b1\u00102\u0012\u0004\b.\u0010\u0017\u001a\u0004\b/\u00100R\u000e\u00103\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u00104\u001a\u00020\u001e8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b5\u0010\u0017\u001a\u0004\b6\u0010\"\"\u0004\b7\u0010$R\u001c\u00108\u001a\u0002098\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u0017\u001a\u0004\b;\u0010<R$\u0010=\u001a\u00020\u00158\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b>\u0010\u0017\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001d\u0010C\u001a\u0004\u0018\u00010D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u00102\u001a\u0004\bE\u0010FR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010H\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u00102\u001a\u0004\bJ\u0010KR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010O\u001a\u00020P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u00102\u001a\u0004\bQ\u0010RR\u000e\u0010T\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010U\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u00102\u001a\u0004\bW\u0010XR!\u0010Z\u001a\u00020[8@X\u0081\u0084\u0002¢\u0006\u0012\n\u0004\b_\u00102\u0012\u0004\b\\\u0010\u0017\u001a\u0004\b]\u0010^R\u001b\u0010`\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u00102\u001a\u0004\bb\u0010cR&\u0010e\u001a\u0004\u0018\u00010f8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bg\u0010\u0017\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR$\u0010l\u001a\u00020\u00158\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bm\u0010\u0017\u001a\u0004\bn\u0010@\"\u0004\bo\u0010BR\u001b\u0010p\u001a\u00020q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u00102\u001a\u0004\br\u0010sR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¨\u0001"}, d2 = {"Lcom/vungle/ads/internal/presenter/MRAIDPresenter;", "Lcom/vungle/ads/internal/ui/view/WebViewAPI$MraidDelegate;", "Lcom/vungle/ads/internal/ui/view/WebViewAPI$WebClientErrorHandler;", "adWidget", "Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget;", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", "placement", "Lcom/vungle/ads/internal/model/Placement;", "vungleWebClient", "Lcom/vungle/ads/internal/ui/VungleWebClient;", "executor", "Ljava/util/concurrent/Executor;", "omTracker", "Lcom/vungle/ads/internal/omsdk/OMTracker;", "bidPayload", "Lcom/vungle/ads/internal/model/BidPayload;", N6.H, "Lcom/vungle/ads/internal/platform/Platform;", "(Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget;Lcom/vungle/ads/internal/model/AdPayload;Lcom/vungle/ads/internal/model/Placement;Lcom/vungle/ads/internal/ui/VungleWebClient;Ljava/util/concurrent/Executor;Lcom/vungle/ads/internal/omsdk/OMTracker;Lcom/vungle/ads/internal/model/BidPayload;Lcom/vungle/ads/internal/platform/Platform;)V", "adStartTime", "", "getAdStartTime$vungle_ads_release$annotations", "()V", "getAdStartTime$vungle_ads_release", "()Ljava/lang/Long;", "setAdStartTime$vungle_ads_release", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "adViewed", "", "backEnabled", "getBackEnabled$vungle_ads_release$annotations", "getBackEnabled$vungle_ads_release", "()Z", "setBackEnabled$vungle_ads_release", "(Z)V", "bus", "Lcom/vungle/ads/internal/presenter/AdEventListener;", "getBus$annotations", "getBus", "()Lcom/vungle/ads/internal/presenter/AdEventListener;", "setBus", "(Lcom/vungle/ads/internal/presenter/AdEventListener;)V", "clickCoordinateTracker", "Lcom/vungle/ads/internal/ClickCoordinateTracker;", "getClickCoordinateTracker$vungle_ads_release$annotations", "getClickCoordinateTracker$vungle_ads_release", "()Lcom/vungle/ads/internal/ClickCoordinateTracker;", "clickCoordinateTracker$delegate", "Lkotlin/Lazy;", "cp0Fired", "heartbeatEnabled", "getHeartbeatEnabled$vungle_ads_release$annotations", "getHeartbeatEnabled$vungle_ads_release", "setHeartbeatEnabled$vungle_ads_release", "isDestroying", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isDestroying$vungle_ads_release$annotations", "isDestroying$vungle_ads_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "lastUserInteractionTimestamp", "getLastUserInteractionTimestamp$vungle_ads_release$annotations", "getLastUserInteractionTimestamp$vungle_ads_release", "()J", "setLastUserInteractionTimestamp$vungle_ads_release", "(J)V", "logEntry", "Lcom/vungle/ads/internal/util/LogEntry;", "getLogEntry", "()Lcom/vungle/ads/internal/util/LogEntry;", "logEntry$delegate", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "getPathProvider", "()Lcom/vungle/ads/internal/util/PathProvider;", "pathProvider$delegate", "presenterDelegate", "Lcom/vungle/ads/internal/presenter/PresenterDelegate;", "scheduler", "Lcom/vungle/ads/internal/util/HandlerScheduler;", "getScheduler", "()Lcom/vungle/ads/internal/util/HandlerScheduler;", "scheduler$delegate", "sendReportIncentivized", "signalManager", "Lcom/vungle/ads/internal/signals/SignalManager;", "getSignalManager", "()Lcom/vungle/ads/internal/signals/SignalManager;", "signalManager$delegate", "suspendableTimer", "Lcom/vungle/ads/internal/util/SuspendableTimer;", "getSuspendableTimer$vungle_ads_release$annotations", "getSuspendableTimer$vungle_ads_release", "()Lcom/vungle/ads/internal/util/SuspendableTimer;", "suspendableTimer$delegate", "tpatSender", "Lcom/vungle/ads/internal/network/TpatSender;", "getTpatSender", "()Lcom/vungle/ads/internal/network/TpatSender;", "tpatSender$delegate", "userId", "", "getUserId$vungle_ads_release$annotations", "getUserId$vungle_ads_release", "()Ljava/lang/String;", "setUserId$vungle_ads_release", "(Ljava/lang/String;)V", "videoLength", "getVideoLength$vungle_ads_release$annotations", "getVideoLength$vungle_ads_release", "setVideoLength$vungle_ads_release", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "getVungleApiClient", "()Lcom/vungle/ads/internal/network/VungleApiClient;", "vungleApiClient$delegate", "closeView", "", "detach", "stopReason", "", "getViewStatus", "handleExit", "handleWebViewException", "reason", "Lcom/vungle/ads/VungleError;", "fatal", "errorMessage", "loadMraidAd", "dest", "Ljava/io/File;", "makeBusError", "onReceivedError", "errorDesc", "didCrash", "onRenderProcessUnresponsive", "webView", "Landroid/webkit/WebView;", "webViewRenderProcess", "Landroid/webkit/WebViewRenderProcess;", "onViewConfigurationChanged", "onViewTouched", "event", "Landroid/view/MotionEvent;", "onWebRenderingProcessGone", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "(Landroid/webkit/WebView;Ljava/lang/Boolean;)Z", "prepare", "processCommand", f.b.g, "arguments", "Lkotlinx/serialization/json/JsonObject;", "recordPlayAssetMetric", "reportErrorAndCloseAd", "setAdVisibility", C3040d4.h.o, "setEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPresenterDelegate", "setPresenterDelegate$vungle_ads_release", "shouldBlockAutoRedirect", "shouldBlockAutoRedirect$vungle_ads_release", "start", "stop", "triggerEventMetricForTpat", C3040d4.h.W, "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class MRAIDPresenter implements WebViewAPI.MraidDelegate, WebViewAPI.WebClientErrorHandler {
    private static final String ACTION = "action";
    public static final String ACTION_WITH_VALUE = "actionWithValue";
    public static final String CLOSE = "close";
    public static final String CONSENT_ACTION = "consentAction";
    public static final String CREATIVE_HEARTBEAT = "creativeHeartbeat";
    public static final String ERROR = "error";
    public static final String GET_AVAILABLE_DISK_SPACE = "getAvailableDiskSpace";
    private static final double HEARTBEAT_INTERVAL = 6.0d;
    public static final String OPEN = "open";
    private static final String OPEN_NON_MRAID = "openNonMraid";
    public static final String OPEN_PRIVACY = "openPrivacy";
    public static final String PING_URL = "pingUrl";
    public static final String SET_ORIENTATION_PROPERTIES = "setOrientationProperties";
    public static final String SUCCESSFUL_VIEW = "successfulView";
    private static final String TAG = "MRAIDPresenter";
    public static final String TPAT = "tpat";
    public static final String UPDATE_SIGNALS = "updateSignals";
    private static final String USE_CUSTOM_CLOSE = "useCustomClose";
    private static final String USE_CUSTOM_PRIVACY = "useCustomPrivacy";
    public static final String VIDEO_LENGTH = "videoLength";
    public static final String VIDEO_VIEWED = "videoViewed";
    private Long adStartTime;
    private boolean adViewed;
    private final MRAIDAdWidget adWidget;
    private final AdPayload advertisement;
    private boolean backEnabled;
    private final BidPayload bidPayload;
    private AdEventListener bus;

    /* renamed from: clickCoordinateTracker$delegate, reason: from kotlin metadata */
    private final Lazy clickCoordinateTracker;
    private boolean cp0Fired;
    private Executor executor;
    private boolean heartbeatEnabled;
    private final AtomicBoolean isDestroying;
    private long lastUserInteractionTimestamp;

    /* renamed from: logEntry$delegate, reason: from kotlin metadata */
    private final Lazy logEntry;
    private final OMTracker omTracker;

    /* renamed from: pathProvider$delegate, reason: from kotlin metadata */
    private final Lazy pathProvider;
    private final Placement placement;
    private final Platform platform;
    private PresenterDelegate presenterDelegate;

    /* renamed from: scheduler$delegate, reason: from kotlin metadata */
    private final Lazy scheduler;
    private final AtomicBoolean sendReportIncentivized;

    /* renamed from: signalManager$delegate, reason: from kotlin metadata */
    private final Lazy signalManager;

    /* renamed from: suspendableTimer$delegate, reason: from kotlin metadata */
    private final Lazy suspendableTimer;

    /* renamed from: tpatSender$delegate, reason: from kotlin metadata */
    private final Lazy tpatSender;
    private String userId;
    private long videoLength;

    /* renamed from: vungleApiClient$delegate, reason: from kotlin metadata */
    private final Lazy vungleApiClient;
    private final VungleWebClient vungleWebClient;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Sdk.SDKMetric.SDKMetricType> eventMap = MapsKt.mapOf(TuplesKt.to(Constants.CHECKPOINT_0, Sdk.SDKMetric.SDKMetricType.AD_START_EVENT), TuplesKt.to("clickUrl", Sdk.SDKMetric.SDKMetricType.AD_CLICK_EVENT));

    public static /* synthetic */ void getAdStartTime$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getBackEnabled$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getBus$annotations() {
    }

    public static /* synthetic */ void getClickCoordinateTracker$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getHeartbeatEnabled$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getLastUserInteractionTimestamp$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getSuspendableTimer$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getUserId$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getVideoLength$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void isDestroying$vungle_ads_release$annotations() {
    }

    public MRAIDPresenter(MRAIDAdWidget adWidget, AdPayload advertisement, Placement placement, VungleWebClient vungleWebClient, Executor executor, OMTracker omTracker, BidPayload bidPayload, Platform platform) {
        Intrinsics.checkNotNullParameter(adWidget, "adWidget");
        Intrinsics.checkNotNullParameter(advertisement, "advertisement");
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(vungleWebClient, "vungleWebClient");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(omTracker, "omTracker");
        Intrinsics.checkNotNullParameter(platform, "platform");
        this.adWidget = adWidget;
        this.advertisement = advertisement;
        this.placement = placement;
        this.vungleWebClient = vungleWebClient;
        this.executor = executor;
        this.omTracker = omTracker;
        this.bidPayload = bidPayload;
        this.platform = platform;
        this.isDestroying = new AtomicBoolean(false);
        this.sendReportIncentivized = new AtomicBoolean(false);
        ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
        final Context context = adWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "adWidget.context");
        this.vungleApiClient = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<VungleApiClient>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$special$$inlined$inject$1
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
        ServiceLocator.Companion companion2 = ServiceLocator.INSTANCE;
        final Context context2 = adWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "adWidget.context");
        this.pathProvider = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<PathProvider>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$special$$inlined$inject$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.util.PathProvider, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final PathProvider invoke() {
                return ServiceLocator.INSTANCE.getInstance(context2).getService(PathProvider.class);
            }
        });
        ServiceLocator.Companion companion3 = ServiceLocator.INSTANCE;
        final Context context3 = adWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "adWidget.context");
        this.signalManager = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<SignalManager>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$special$$inlined$inject$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.signals.SignalManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SignalManager invoke() {
                return ServiceLocator.INSTANCE.getInstance(context3).getService(SignalManager.class);
            }
        });
        ServiceLocator.Companion companion4 = ServiceLocator.INSTANCE;
        final Context context4 = adWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "adWidget.context");
        this.tpatSender = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<TpatSender>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$special$$inlined$inject$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.network.TpatSender, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TpatSender invoke() {
                return ServiceLocator.INSTANCE.getInstance(context4).getService(TpatSender.class);
            }
        });
        this.scheduler = LazyKt.lazy(new Function0<HandlerScheduler>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$scheduler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HandlerScheduler invoke() {
                return new HandlerScheduler();
            }
        });
        this.logEntry = LazyKt.lazy(new Function0<LogEntry>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$logEntry$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LogEntry invoke() {
                AdPayload adPayload;
                adPayload = MRAIDPresenter.this.advertisement;
                return adPayload.getLogEntry();
            }
        });
        this.suspendableTimer = LazyKt.lazy(new Function0<SuspendableTimer>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$suspendableTimer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuspendableTimer invoke() {
                final MRAIDPresenter mRAIDPresenter = MRAIDPresenter.this;
                return new SuspendableTimer(6.0d, true, null, new Function0<Unit>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$suspendableTimer$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MRAIDPresenter.this.reportErrorAndCloseAd(new HeartbeatMissingError());
                    }
                }, 4, null);
            }
        });
        this.clickCoordinateTracker = LazyKt.lazy(new Function0<ClickCoordinateTracker>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$clickCoordinateTracker$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ClickCoordinateTracker invoke() {
                MRAIDAdWidget mRAIDAdWidget;
                AdPayload adPayload;
                mRAIDAdWidget = MRAIDPresenter.this.adWidget;
                Context context5 = mRAIDAdWidget.getContext();
                Intrinsics.checkNotNullExpressionValue(context5, "adWidget.context");
                adPayload = MRAIDPresenter.this.advertisement;
                return new ClickCoordinateTracker(context5, adPayload);
            }
        });
    }

    /* renamed from: getLastUserInteractionTimestamp$vungle_ads_release, reason: from getter */
    public final long getLastUserInteractionTimestamp() {
        return this.lastUserInteractionTimestamp;
    }

    public final void setLastUserInteractionTimestamp$vungle_ads_release(long j) {
        this.lastUserInteractionTimestamp = j;
    }

    public final AdEventListener getBus() {
        return this.bus;
    }

    public final void setBus(AdEventListener adEventListener) {
        this.bus = adEventListener;
    }

    /* renamed from: isDestroying$vungle_ads_release, reason: from getter */
    public final AtomicBoolean getIsDestroying() {
        return this.isDestroying;
    }

    /* renamed from: getAdStartTime$vungle_ads_release, reason: from getter */
    public final Long getAdStartTime() {
        return this.adStartTime;
    }

    public final void setAdStartTime$vungle_ads_release(Long l) {
        this.adStartTime = l;
    }

    /* renamed from: getUserId$vungle_ads_release, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId$vungle_ads_release(String str) {
        this.userId = str;
    }

    private final VungleApiClient getVungleApiClient() {
        return (VungleApiClient) this.vungleApiClient.getValue();
    }

    private final PathProvider getPathProvider() {
        return (PathProvider) this.pathProvider.getValue();
    }

    private final SignalManager getSignalManager() {
        return (SignalManager) this.signalManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TpatSender getTpatSender() {
        return (TpatSender) this.tpatSender.getValue();
    }

    private final HandlerScheduler getScheduler() {
        return (HandlerScheduler) this.scheduler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LogEntry getLogEntry() {
        return (LogEntry) this.logEntry.getValue();
    }

    /* renamed from: getHeartbeatEnabled$vungle_ads_release, reason: from getter */
    public final boolean getHeartbeatEnabled() {
        return this.heartbeatEnabled;
    }

    public final void setHeartbeatEnabled$vungle_ads_release(boolean z) {
        this.heartbeatEnabled = z;
    }

    public final SuspendableTimer getSuspendableTimer$vungle_ads_release() {
        return (SuspendableTimer) this.suspendableTimer.getValue();
    }

    /* renamed from: getBackEnabled$vungle_ads_release, reason: from getter */
    public final boolean getBackEnabled() {
        return this.backEnabled;
    }

    public final void setBackEnabled$vungle_ads_release(boolean z) {
        this.backEnabled = z;
    }

    public final ClickCoordinateTracker getClickCoordinateTracker$vungle_ads_release() {
        return (ClickCoordinateTracker) this.clickCoordinateTracker.getValue();
    }

    /* renamed from: getVideoLength$vungle_ads_release, reason: from getter */
    public final long getVideoLength() {
        return this.videoLength;
    }

    public final void setVideoLength$vungle_ads_release(long j) {
        this.videoLength = j;
    }

    /* compiled from: MRAIDPresenter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0017\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002R\u0016\u0010\t\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0002R\u0016\u0010\u000b\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0002R\u0016\u0010\r\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0002R\u0016\u0010\u000f\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0002R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0002R\u0016\u0010\u0018\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0002R\u0016\u0010\u001a\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0002R\u0016\u0010\u001c\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0002R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u0002R\u0016\u0010!\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u0002R\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u0002R\u0016\u0010'\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b(\u0010\u0002R(\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+0*8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0002\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/vungle/ads/internal/presenter/MRAIDPresenter$Companion;", "", "()V", "ACTION", "", "ACTION_WITH_VALUE", "getACTION_WITH_VALUE$vungle_ads_release$annotations", "CLOSE", "getCLOSE$vungle_ads_release$annotations", "CONSENT_ACTION", "getCONSENT_ACTION$vungle_ads_release$annotations", "CREATIVE_HEARTBEAT", "getCREATIVE_HEARTBEAT$vungle_ads_release$annotations", "ERROR", "getERROR$vungle_ads_release$annotations", "GET_AVAILABLE_DISK_SPACE", "getGET_AVAILABLE_DISK_SPACE$vungle_ads_release$annotations", "HEARTBEAT_INTERVAL", "", "OPEN", "getOPEN$vungle_ads_release$annotations", "OPEN_NON_MRAID", "OPEN_PRIVACY", "getOPEN_PRIVACY$vungle_ads_release$annotations", "PING_URL", "getPING_URL$vungle_ads_release$annotations", "SET_ORIENTATION_PROPERTIES", "getSET_ORIENTATION_PROPERTIES$vungle_ads_release$annotations", "SUCCESSFUL_VIEW", "getSUCCESSFUL_VIEW$vungle_ads_release$annotations", "TAG", "TPAT", "getTPAT$vungle_ads_release$annotations", "UPDATE_SIGNALS", "getUPDATE_SIGNALS$vungle_ads_release$annotations", "USE_CUSTOM_CLOSE", "USE_CUSTOM_PRIVACY", "VIDEO_LENGTH", "getVIDEO_LENGTH$vungle_ads_release$annotations", "VIDEO_VIEWED", "getVIDEO_VIEWED$vungle_ads_release$annotations", "eventMap", "", "Lcom/vungle/ads/internal/protos/Sdk$SDKMetric$SDKMetricType;", "getEventMap$vungle_ads_release$annotations", "getEventMap$vungle_ads_release", "()Ljava/util/Map;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getACTION_WITH_VALUE$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getCLOSE$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getCONSENT_ACTION$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getCREATIVE_HEARTBEAT$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getERROR$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getEventMap$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getGET_AVAILABLE_DISK_SPACE$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getOPEN$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getOPEN_PRIVACY$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getPING_URL$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getSET_ORIENTATION_PROPERTIES$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getSUCCESSFUL_VIEW$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getTPAT$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getUPDATE_SIGNALS$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getVIDEO_LENGTH$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getVIDEO_VIEWED$vungle_ads_release$annotations() {
        }

        private Companion() {
        }

        public final Map<String, Sdk.SDKMetric.SDKMetricType> getEventMap$vungle_ads_release() {
            return MRAIDPresenter.eventMap;
        }
    }

    public final void setEventListener(AdEventListener listener) {
        this.bus = listener;
    }

    public final void setPresenterDelegate$vungle_ads_release(PresenterDelegate presenterDelegate) {
        this.presenterDelegate = presenterDelegate;
    }

    public final void onViewConfigurationChanged() {
        this.vungleWebClient.notifyPropertiesChange(true);
    }

    public final void start() {
        Logger.INSTANCE.d(TAG, "start()");
        this.adWidget.resumeWeb();
        setAdVisibility(true);
    }

    public final void stop() {
        Logger.INSTANCE.d(TAG, "stop()");
        this.adWidget.pauseWeb();
        setAdVisibility(false);
    }

    public final void detach(@MRAIDAdWidget.AdStopReason int stopReason) {
        AdEventListener adEventListener;
        Logger.INSTANCE.d(TAG, "detach()");
        boolean z = (stopReason & 1) != 0;
        boolean z2 = (stopReason & 2) != 0;
        this.vungleWebClient.setWebViewObserver(null);
        this.vungleWebClient.setMraidDelegate(null);
        if (!z && z2 && !this.isDestroying.getAndSet(true) && (adEventListener = this.bus) != null) {
            adEventListener.onNext("end", null, this.placement.getReferenceId());
        }
        this.adWidget.destroyWebView(this.omTracker.stop());
        if (this.heartbeatEnabled) {
            getSuspendableTimer$vungle_ads_release().cancel();
        }
    }

    public final void setAdVisibility(boolean isViewable) {
        this.vungleWebClient.setAdVisibility(isViewable);
    }

    public final void onViewTouched(MotionEvent event) {
        if (event != null) {
            Logger.INSTANCE.d(TAG, "user interaction");
            this.lastUserInteractionTimestamp = System.currentTimeMillis();
            getClickCoordinateTracker$vungle_ads_release().trackCoordinate(event);
        }
    }

    private final void closeView() {
        Long l = this.adStartTime;
        if (l != null) {
            List<String> tpatUrls = this.advertisement.getTpatUrls(Constants.AD_CLOSE, String.valueOf(System.currentTimeMillis() - l.longValue()), String.valueOf(this.platform.getVolumeLevel()));
            if (tpatUrls != null) {
                Iterator<T> it = tpatUrls.iterator();
                while (it.hasNext()) {
                    TpatSender.sendTpat$default(getTpatSender(), new TpatRequest.Builder((String) it.next()).tpatKey(Constants.AD_CLOSE).withLogEntry(getLogEntry()).build(), false, 2, null);
                }
            }
        }
        ThreadUtil.INSTANCE.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$closeView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MRAIDAdWidget mRAIDAdWidget;
                mRAIDAdWidget = MRAIDPresenter.this.adWidget;
                mRAIDAdWidget.close();
            }
        });
    }

    public final void handleExit() {
        if (this.backEnabled) {
            this.adWidget.showWebsite("javascript:window.vungle.mraidBridgeExt.requestMRAIDClose()");
        }
    }

    private final void triggerEventMetricForTpat(String key) {
        Sdk.SDKMetric.SDKMetricType sDKMetricType = eventMap.get(key);
        if (sDKMetricType != null) {
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(sDKMetricType), getLogEntry(), (String) null, 4, (Object) null);
        }
    }

    public final Long getViewStatus() {
        boolean z = this.adViewed;
        if (!z && !this.cp0Fired) {
            return 3L;
        }
        if (this.cp0Fired) {
            return !z ? 2L : null;
        }
        return 1L;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x023c, code lost:
    
        if (r23.equals(com.vungle.ads.internal.presenter.MRAIDPresenter.OPEN_NON_MRAID) == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0227, code lost:
    
        if (r23.equals("open") == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0240, code lost:
    
        r0 = r22.advertisement.adUnit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0246, code lost:
    
        if (r0 == null) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0248, code lost:
    
        r15 = r0.getDeeplinkUrl();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x024c, code lost:
    
        r0 = com.vungle.ads.internal.util.JsonUtil.INSTANCE.getContentStringValue(r24, "url");
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0258, code lost:
    
        if (com.vungle.ads.internal.util.FileUtility.INSTANCE.isValidUrl(r0) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x025a, code lost:
    
        new com.vungle.ads.InvalidCTAUrl("Unable to open CTA Url (" + r0 + ')').setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0283, code lost:
    
        if (shouldBlockAutoRedirect$vungle_ads_release() == false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0285, code lost:
    
        r22.lastUserInteractionTimestamp = 0;
        com.vungle.ads.AnalyticsClient.logMetric$vungle_ads_release$default(com.vungle.ads.AnalyticsClient.INSTANCE, new com.vungle.ads.SingleValueMetric(com.vungle.ads.internal.protos.Sdk.SDKMetric.SDKMetricType.BANNER_AUTO_REDIRECT), getLogEntry(), (java.lang.String) null, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02a2, code lost:
    
        r22.lastUserInteractionTimestamp = 0;
        r2 = r22.adWidget.getContext();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "adWidget.context");
        r0 = com.vungle.ads.internal.util.ExternalRouter.launch(r15, r0, r2, getLogEntry(), new com.vungle.ads.internal.presenter.MRAIDPresenter$processCommand$launched$1(r15, r22));
        r2 = r22.bus;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02c0, code lost:
    
        if (r2 == null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02c2, code lost:
    
        r2.onNext("open", "adClick", r22.placement.getReferenceId());
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02cf, code lost:
    
        if (r0 == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02d1, code lost:
    
        r0 = r22.bus;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02d3, code lost:
    
        if (r0 == null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02d5, code lost:
    
        r0.onNext("open", "adLeftApplication", r22.placement.getReferenceId());
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x058b A[LOOP:1: B:191:0x0585->B:193:0x058b, LOOP_END] */
    @Override // com.vungle.ads.internal.ui.view.WebViewAPI.MraidDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean processCommand(String command, JsonObject arguments) {
        Object m10241constructorimpl;
        float parseFloat;
        AdEventListener adEventListener;
        BidPayload bidPayload;
        List<String> impression;
        Iterator<T> it;
        String str;
        boolean z;
        Map<String, String> map;
        List<String> tpatUrls$default;
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Handler handler = new Handler(Looper.getMainLooper());
        final String str2 = null;
        switch (command.hashCode()) {
            case -1912374177:
                if (command.equals(SUCCESSFUL_VIEW)) {
                    AdEventListener adEventListener2 = this.bus;
                    if (adEventListener2 != null) {
                        adEventListener2.onNext(SUCCESSFUL_VIEW, null, this.placement.getReferenceId());
                        Unit unit = Unit.INSTANCE;
                    }
                    if (this.placement.isRewardedVideo() && ConfigManager.INSTANCE.isReportIncentivizedEnabled() && !this.sendReportIncentivized.getAndSet(true)) {
                        this.executor.execute(new Runnable() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                MRAIDPresenter.m9376processCommand$lambda10(MRAIDPresenter.this);
                            }
                        });
                        break;
                    }
                }
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
            case -1422950858:
                if (command.equals("action")) {
                }
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
            case -735200587:
                if (command.equals(ACTION_WITH_VALUE)) {
                    String contentStringValue = JsonUtil.INSTANCE.getContentStringValue(arguments, "event");
                    String contentStringValue2 = JsonUtil.INSTANCE.getContentStringValue(arguments, "value");
                    if (StringsKt.equals("videoLength", contentStringValue, true)) {
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            MRAIDPresenter mRAIDPresenter = this;
                            m10241constructorimpl = Result.m10241constructorimpl(contentStringValue2 != null ? Long.valueOf(Long.parseLong(contentStringValue2)) : null);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                        }
                        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
                            m10241constructorimpl = null;
                        }
                        Long l = (Long) m10241constructorimpl;
                        this.videoLength = l != null ? l.longValue() : 0L;
                    }
                    if (StringsKt.equals("videoViewed", contentStringValue, true)) {
                        if (contentStringValue2 != null) {
                            try {
                                parseFloat = Float.parseFloat(contentStringValue2);
                            } catch (NumberFormatException unused) {
                                Logger.INSTANCE.e(TAG, "value for videoViewed is null !");
                            }
                            adEventListener = this.bus;
                            if (adEventListener != null && parseFloat > 0.0f && !this.adViewed) {
                                this.adViewed = true;
                                if (adEventListener != null) {
                                    adEventListener.onNext("adViewed", null, this.placement.getReferenceId());
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                bidPayload = this.bidPayload;
                                if (bidPayload != null && (impression = bidPayload.getImpression()) != null) {
                                    it = impression.iterator();
                                    while (it.hasNext()) {
                                        TpatSender.sendTpat$default(getTpatSender(), new TpatRequest.Builder((String) it.next()).tpatKey("impression").withLogEntry(getLogEntry()).build(), false, 2, null);
                                    }
                                    Unit unit3 = Unit.INSTANCE;
                                }
                            }
                        }
                        parseFloat = 0.0f;
                        adEventListener = this.bus;
                        if (adEventListener != null) {
                            this.adViewed = true;
                            if (adEventListener != null) {
                            }
                            bidPayload = this.bidPayload;
                            if (bidPayload != null) {
                                it = impression.iterator();
                                while (it.hasNext()) {
                                }
                                Unit unit32 = Unit.INSTANCE;
                            }
                        }
                    }
                    handler.post(new Runnable() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            MRAIDPresenter.m9379processCommand$lambda5(MRAIDPresenter.this);
                        }
                    });
                    break;
                }
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
            case -660787472:
                if (command.equals(CONSENT_ACTION)) {
                    PrivacyManager.INSTANCE.updateGdprConsent((Intrinsics.areEqual(JsonUtil.INSTANCE.getContentStringValue(arguments, "event"), PrivacyConsent.OPT_OUT.getValue()) ? PrivacyConsent.OPT_OUT : PrivacyConsent.OPT_IN).getValue(), "vungle_modal", null);
                    break;
                }
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
            case -568000867:
                if (command.equals(PING_URL)) {
                    String contentStringValue3 = JsonUtil.INSTANCE.getContentStringValue(arguments, "requestType");
                    if (contentStringValue3 != null) {
                        str = contentStringValue3.toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    } else {
                        str = null;
                    }
                    if (!CollectionsKt.contains(CollectionsKt.listOf((Object[]) new String[]{"GET", "POST"}), str)) {
                        new TpatError(Sdk.SDKError.Reason.TPAT_ERROR, "Invalid request type: " + str + ". Only 'GET' and 'POST' are supported").setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                        break;
                    } else {
                        String contentStringValue4 = JsonUtil.INSTANCE.getContentStringValue(arguments, "url");
                        String contentStringValue5 = JsonUtil.INSTANCE.getContentStringValue(arguments, "requestData");
                        boolean parseBoolean = Boolean.parseBoolean(JsonUtil.INSTANCE.getContentStringValue(arguments, "retry"));
                        String contentStringValue6 = JsonUtil.INSTANCE.getContentStringValue(arguments, "headers");
                        if (contentStringValue6 != null) {
                            try {
                                Json.Companion companion3 = Json.INSTANCE;
                                z = true;
                                try {
                                    KSerializer<Object> serializer = SerializersKt.serializer(companion3.getSerializersModule(), Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                                    Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                    map = (Map) companion3.decodeFromString(serializer, contentStringValue6);
                                } catch (Exception unused2) {
                                    new TpatError(Sdk.SDKError.Reason.TPAT_ERROR, "Failed to decode header: " + contentStringValue6).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                                    return z;
                                }
                            } catch (Exception unused3) {
                                z = true;
                            }
                        } else {
                            z = true;
                            map = null;
                        }
                        if (!Utils.INSTANCE.isUrlValid(contentStringValue4)) {
                            new TpatError(Sdk.SDKError.Reason.EMPTY_TPAT_ERROR, "URL is missing in params from a template for generic tpat").setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                            break;
                        } else if (contentStringValue4 != null) {
                            TpatRequest.Builder withLogEntry = new TpatRequest.Builder(contentStringValue4).headers(map).body(contentStringValue5).regularRetry(parseBoolean).tpatKey(PING_URL).withLogEntry(getLogEntry());
                            if (Intrinsics.areEqual(str, "GET")) {
                                withLogEntry.get();
                            } else {
                                withLogEntry.post();
                            }
                            Unit unit4 = Unit.INSTANCE;
                            TpatSender.sendTpat$default(getTpatSender(), withLogEntry.build(), false, 2, null);
                            Unit unit5 = Unit.INSTANCE;
                            Unit unit6 = Unit.INSTANCE;
                            break;
                        }
                    }
                }
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
            case -511324706:
                if (command.equals("openPrivacy")) {
                    AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.PRIVACY_URL_OPENED), getLogEntry(), (String) null, 4, (Object) null);
                    String contentStringValue7 = JsonUtil.INSTANCE.getContentStringValue(arguments, "url");
                    String str3 = contentStringValue7;
                    if (str3 != null && str3.length() != 0 && FileUtility.INSTANCE.isValidUrl(contentStringValue7)) {
                        Context context = this.adWidget.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "adWidget.context");
                        if (!ExternalRouter.launch$default(null, contentStringValue7, context, getLogEntry(), null, 16, null)) {
                            new PrivacyUrlError(contentStringValue7).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                            break;
                        } else {
                            AdEventListener adEventListener3 = this.bus;
                            if (adEventListener3 != null) {
                                adEventListener3.onNext("open", "adLeftApplication", this.placement.getReferenceId());
                                Unit unit7 = Unit.INSTANCE;
                                break;
                            }
                        }
                    } else {
                        String str4 = contentStringValue7;
                        if (str4 == null) {
                            str4 = "nonePrivacyUrl";
                        }
                        new PrivacyUrlError(str4).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                        break;
                    }
                }
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
            case -418575596:
                break;
            case -348095344:
                if (command.equals(USE_CUSTOM_PRIVACY)) {
                }
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
            case 3417674:
                break;
            case 3566511:
                if (command.equals("tpat")) {
                    String contentStringValue8 = JsonUtil.INSTANCE.getContentStringValue(arguments, "event");
                    String str5 = contentStringValue8;
                    if (str5 != null && str5.length() != 0) {
                        triggerEventMetricForTpat(contentStringValue8);
                        if (Intrinsics.areEqual(contentStringValue8, Constants.CHECKPOINT_0)) {
                            tpatUrls$default = this.advertisement.getTpatUrls(contentStringValue8, this.platform.getCarrierName(), String.valueOf(this.platform.getVolumeLevel()));
                        } else if (Intrinsics.areEqual(contentStringValue8, Constants.VIDEO_LENGTH_TPAT)) {
                            tpatUrls$default = AdPayload.getTpatUrls$default(this.advertisement, contentStringValue8, String.valueOf(this.videoLength), null, 4, null);
                        } else {
                            tpatUrls$default = AdPayload.getTpatUrls$default(this.advertisement, contentStringValue8, null, null, 6, null);
                            contentStringValue8 = contentStringValue8;
                        }
                        if (tpatUrls$default != null) {
                            Iterator<T> it2 = tpatUrls$default.iterator();
                            while (it2.hasNext()) {
                                TpatSender.sendTpat$default(getTpatSender(), new TpatRequest.Builder((String) it2.next()).tpatKey(contentStringValue8).withLogEntry(getLogEntry()).build(), false, 2, null);
                            }
                            Unit unit8 = Unit.INSTANCE;
                        }
                        if (Intrinsics.areEqual(contentStringValue8, Constants.CHECKPOINT_0)) {
                            this.cp0Fired = true;
                            break;
                        }
                    } else {
                        new TpatError(Sdk.SDKError.Reason.EMPTY_TPAT_ERROR, "Empty tpat key").setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                        break;
                    }
                }
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
            case 94756344:
                if (command.equals("close")) {
                    closeView();
                    break;
                }
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
            case 96784904:
                if (command.equals("error")) {
                    String contentStringValue9 = JsonUtil.INSTANCE.getContentStringValue(arguments, "code");
                    final boolean parseBoolean2 = Boolean.parseBoolean(JsonUtil.INSTANCE.getContentStringValue(arguments, "fatal"));
                    String contentStringValue10 = JsonUtil.INSTANCE.getContentStringValue(arguments, "errorMessage");
                    final String str6 = contentStringValue9 + " : " + contentStringValue10;
                    final MraidTemplateError mraidTemplateError = new MraidTemplateError(parseBoolean2 ? Sdk.SDKError.Reason.AD_CLOSED_TEMPLATE_ERROR : Sdk.SDKError.Reason.MRAID_ERROR, str6);
                    ThreadUtil.INSTANCE.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$processCommand$8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MRAIDPresenter.this.handleWebViewException(mraidTemplateError, parseBoolean2, str6);
                        }
                    });
                    break;
                }
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
            case 133423073:
                if (command.equals("setOrientationProperties")) {
                    String contentStringValue11 = JsonUtil.INSTANCE.getContentStringValue(arguments, "forceOrientation");
                    String str7 = contentStringValue11;
                    if (str7 != null && str7.length() != 0) {
                        Locale ENGLISH = Locale.ENGLISH;
                        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                        String lowerCase = contentStringValue11.toLowerCase(ENGLISH);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                        if (!Intrinsics.areEqual(lowerCase, C3040d4.h.C)) {
                            if (Intrinsics.areEqual(lowerCase, C3040d4.h.D)) {
                                this.adWidget.setOrientation(7);
                                break;
                            }
                        } else {
                            this.adWidget.setOrientation(6);
                            break;
                        }
                    }
                }
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
            case 592314818:
                if (command.equals(UPDATE_SIGNALS)) {
                    String contentStringValue12 = JsonUtil.INSTANCE.getContentStringValue(arguments, "signals");
                    String str8 = contentStringValue12;
                    if (str8 != null && str8.length() != 0) {
                        getSignalManager().updateTemplateSignals(contentStringValue12);
                        break;
                    }
                }
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
            case 1496446614:
                if (command.equals(GET_AVAILABLE_DISK_SPACE)) {
                    try {
                        File noBackupFilesDir = this.adWidget.getContext().getNoBackupFilesDir();
                        PathProvider pathProvider = getPathProvider();
                        String path = noBackupFilesDir.getPath();
                        Intrinsics.checkNotNullExpressionValue(path, "dir.path");
                        final long availableBytes = pathProvider.getAvailableBytes(path);
                        handler.post(new Runnable() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$$ExternalSyntheticLambda3
                            @Override // java.lang.Runnable
                            public final void run() {
                                MRAIDPresenter.m9378processCommand$lambda12(MRAIDPresenter.this, availableBytes);
                            }
                        });
                        break;
                    } catch (Exception unused4) {
                        Logger.INSTANCE.e(TAG, "Failed to get available disk space");
                        break;
                    }
                }
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
            case 1614272768:
                if (command.equals(USE_CUSTOM_CLOSE)) {
                }
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
            case 1850430989:
                if (command.equals(CREATIVE_HEARTBEAT)) {
                    if (this.heartbeatEnabled) {
                        handler.post(new Runnable() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                MRAIDPresenter.m9377processCommand$lambda11(MRAIDPresenter.this);
                            }
                        });
                        break;
                    }
                }
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
            default:
                new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY, "Unknown MRAID Command: " + command).setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                Logger.INSTANCE.w(TAG, "processCommand# Unknown MRAID Command: " + command);
                break;
        }
        return true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processCommand$lambda-5, reason: not valid java name */
    public static final void m9379processCommand$lambda5(MRAIDPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.adWidget.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processCommand$lambda-10, reason: not valid java name */
    public static final void m9376processCommand$lambda10(final MRAIDPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list = null;
        CommonRequestBody.AdSizeParam adSizeParam = null;
        Call<Void> ri = this$0.getVungleApiClient().ri(new CommonRequestBody.RequestParam(list, adSizeParam, this$0.adStartTime, this$0.advertisement.advAppId(), this$0.placement.getReferenceId(), this$0.userId, 3, (DefaultConstructorMarker) null));
        if (ri == null) {
            Logger.INSTANCE.e(TAG, "Invalid ri call.");
            new NetworkUnreachable("Error RI API for placement: " + this$0.placement.getReferenceId()).setLogEntry$vungle_ads_release(this$0.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
        } else {
            ri.enqueue(new Callback<Void>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$processCommand$7$1
                @Override // com.vungle.ads.internal.network.Callback
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Logger.INSTANCE.d("MRAIDPresenter", "send RI success");
                }

                @Override // com.vungle.ads.internal.network.Callback
                public void onFailure(Call<Void> call, Throwable t) {
                    LogEntry logEntry;
                    Logger.INSTANCE.d("MRAIDPresenter", "send RI Failure");
                    NetworkUnreachable networkUnreachable = new NetworkUnreachable("Error RI API calls: " + (t != null ? t.getLocalizedMessage() : null));
                    logEntry = MRAIDPresenter.this.getLogEntry();
                    networkUnreachable.setLogEntry$vungle_ads_release(logEntry).logErrorNoReturnValue$vungle_ads_release();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processCommand$lambda-11, reason: not valid java name */
    public static final void m9377processCommand$lambda11(MRAIDPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSuspendableTimer$vungle_ads_release().reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processCommand$lambda-12, reason: not valid java name */
    public static final void m9378processCommand$lambda12(MRAIDPresenter this$0, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.vungleWebClient.notifyDiskAvailableSize(j);
    }

    private final void makeBusError(VungleError reason) {
        AdEventListener adEventListener = this.bus;
        if (adEventListener != null) {
            adEventListener.onError(reason, this.placement.getReferenceId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportErrorAndCloseAd(VungleError reason) {
        reason.setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
        makeBusError(reason);
        closeView();
    }

    @Override // com.vungle.ads.internal.ui.view.WebViewAPI.WebClientErrorHandler
    public void onReceivedError(String errorDesc, boolean didCrash) {
        Intrinsics.checkNotNullParameter(errorDesc, "errorDesc");
        if (didCrash) {
            reportErrorAndCloseAd(new WebViewError(errorDesc));
        }
    }

    @Override // com.vungle.ads.internal.ui.view.WebViewAPI.WebClientErrorHandler
    public boolean onWebRenderingProcessGone(WebView view, Boolean didCrash) {
        boolean booleanValue = didCrash != null ? didCrash.booleanValue() : true;
        handleWebViewException$default(this, new WebViewRenderingProcessGone("didCrash=" + booleanValue), booleanValue, null, 4, null);
        return true;
    }

    @Override // com.vungle.ads.internal.ui.view.WebViewAPI.WebClientErrorHandler
    public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        handleWebViewException$default(this, new WebViewRenderProcessUnresponsive("fatal=true"), true, null, 4, null);
    }

    static /* synthetic */ void handleWebViewException$default(MRAIDPresenter mRAIDPresenter, VungleError vungleError, boolean z, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        mRAIDPresenter.handleWebViewException(vungleError, z, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleWebViewException(VungleError reason, boolean fatal, String errorMessage) {
        Logger.INSTANCE.e(TAG, "handleWebViewException: " + reason.getLocalizedMessage() + ", fatal: " + fatal + ", errorMsg: " + errorMessage);
        reason.setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
        if (fatal) {
            makeBusError(reason);
            closeView();
        }
    }

    private final VungleError loadMraidAd(File dest) {
        File file = new File(dest.getPath(), Constants.AD_INDEX_FILE_NAME);
        if (!file.exists()) {
            return new IndexHtmlError(Sdk.SDKError.Reason.AD_HTML_FAILED_TO_LOAD, "Fail to load html " + file.getPath());
        }
        this.adWidget.showWebsite(AdPayload.FILE_SCHEME + file.getPath());
        return null;
    }

    public final void prepare() {
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        int settings;
        this.isDestroying.set(false);
        this.adWidget.linkWebView(this.vungleWebClient, this.advertisement.getWebViewSettings());
        AdConfig adConfig = this.advertisement.getAdConfig();
        if (adConfig != null && (settings = adConfig.getSettings()) > 0) {
            this.backEnabled = (settings & 2) == 2;
        }
        this.heartbeatEnabled = this.advertisement.heartbeatEnabled();
        AdConfig adConfig2 = this.advertisement.getAdConfig();
        Integer valueOf = adConfig2 != null ? Integer.valueOf(adConfig2.getAdOrientation()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            i = 7;
        } else {
            i = (valueOf != null && valueOf.intValue() == 1) ? 6 : 4;
        }
        this.adWidget.setOrientation(i);
        this.omTracker.start();
        this.vungleWebClient.setMraidDelegate(this);
        this.vungleWebClient.setErrorHandler(this);
        File assetDirectory = this.advertisement.getAssetDirectory();
        if (assetDirectory == null || !assetDirectory.exists()) {
            reportErrorAndCloseAd(new AdNotLoadedCantPlay("adv dir not exists: " + (assetDirectory != null ? assetDirectory.getPath() : null)));
            return;
        }
        VungleError loadMraidAd = loadMraidAd(assetDirectory);
        if (loadMraidAd != null) {
            reportErrorAndCloseAd(loadMraidAd);
            return;
        }
        this.adStartTime = Long.valueOf(System.currentTimeMillis());
        PresenterDelegate presenterDelegate = this.presenterDelegate;
        this.userId = presenterDelegate != null ? presenterDelegate.getUserId() : null;
        PresenterDelegate presenterDelegate2 = this.presenterDelegate;
        if (presenterDelegate2 == null || (str = presenterDelegate2.getAlertTitleText()) == null) {
            str = "";
        }
        PresenterDelegate presenterDelegate3 = this.presenterDelegate;
        if (presenterDelegate3 == null || (str2 = presenterDelegate3.getAlertBodyText()) == null) {
            str2 = "";
        }
        PresenterDelegate presenterDelegate4 = this.presenterDelegate;
        if (presenterDelegate4 == null || (str3 = presenterDelegate4.getAlertContinueButtonText()) == null) {
            str3 = "";
        }
        PresenterDelegate presenterDelegate5 = this.presenterDelegate;
        if (presenterDelegate5 == null || (str4 = presenterDelegate5.getAlertCloseButtonText()) == null) {
            str4 = "";
        }
        this.advertisement.setIncentivizedText(str, str2, str3, str4);
        boolean z = ConfigManager.INSTANCE.getGDPRIsCountryDataProtected() && Intrinsics.areEqual("unknown", PrivacyManager.INSTANCE.getConsentStatus());
        this.vungleWebClient.setConsentStatus(z, ConfigManager.INSTANCE.getGDPRConsentTitle(), ConfigManager.INSTANCE.getGDPRConsentMessage(), ConfigManager.INSTANCE.getGDPRButtonAccept(), ConfigManager.INSTANCE.getGDPRButtonDeny());
        if (z) {
            PrivacyManager.INSTANCE.updateGdprConsent("opted_out_by_timeout", "vungle_modal", "");
        }
        int showCloseDelay = this.advertisement.getShowCloseDelay(Boolean.valueOf(this.placement.isRewardedVideo()));
        if (showCloseDelay > 0) {
            getScheduler().schedule(new Runnable() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    MRAIDPresenter.m9375prepare$lambda14(MRAIDPresenter.this);
                }
            }, showCloseDelay);
        } else {
            this.backEnabled = true;
        }
        AdEventListener adEventListener = this.bus;
        if (adEventListener != null) {
            adEventListener.onNext("start", null, this.placement.getReferenceId());
        }
        if (this.heartbeatEnabled) {
            getSuspendableTimer$vungle_ads_release().start();
        }
        if (this.advertisement.adLoadOptimizationEnabled()) {
            recordPlayAssetMetric();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: prepare$lambda-14, reason: not valid java name */
    public static final void m9375prepare$lambda14(MRAIDPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.backEnabled = true;
    }

    private final void recordPlayAssetMetric() {
        Sdk.SDKMetric.SDKMetricType sDKMetricType;
        if (this.advertisement.getAssetsFullyDownloaded()) {
            sDKMetricType = Sdk.SDKMetric.SDKMetricType.LOCAL_ASSETS_USED;
        } else {
            sDKMetricType = Sdk.SDKMetric.SDKMetricType.REMOTE_ASSETS_USED;
        }
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(sDKMetricType), getLogEntry(), (String) null, 4, (Object) null);
    }

    public final boolean shouldBlockAutoRedirect$vungle_ads_release() {
        return !ConfigManager.INSTANCE.allowAutoRedirects() && (this.lastUserInteractionTimestamp == 0 || System.currentTimeMillis() - this.lastUserInteractionTimestamp > ConfigManager.INSTANCE.afterClickDuration());
    }
}
