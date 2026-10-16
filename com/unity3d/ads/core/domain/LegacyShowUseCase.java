package com.unity3d.ads.core.domain;

import android.app.Activity;
import com.google.protobuf.ByteString;
import com.ironsource.C3207n2;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.adplayer.EmbeddableAdPlayer;
import com.unity3d.ads.adplayer.model.ShowStatus;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.AdObjectState;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.model.Listeners;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.GetInitializationState;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import com.unity3d.ads.core.extensions.FlowExtensionsKt;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.ads.core.extensions.ShowStatusExtensionsKt;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.services.core.log.DeviceLog;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import gatewayprotocol.v1.OperativeEventErrorDataKt;
import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONObject;

/* compiled from: LegacyShowUseCase.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 B2\u00020\u0001:\u0001BB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J5\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170$2\u0006\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0017H\u0002J5\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0086Bø\u0001\u0000¢\u0006\u0002\u0010/J)\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u00104J \u00105\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J@\u00106\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00107\u001a\u0002082\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0017H\u0002Jh\u0010;\u001a:\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0>\u0012\u0006\u0012\u0004\u0018\u00010\u00010<2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002ø\u0001\u0000¢\u0006\u0002\u0010?J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u0017H\u0002J \u0010A\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006C"}, d2 = {"Lcom/unity3d/ads/core/domain/LegacyShowUseCase;", "", C3207n2.v, "Lcom/unity3d/ads/core/domain/Show;", "adRepository", "Lcom/unity3d/ads/core/data/repository/AdRepository;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "getOperativeEventApi", "Lcom/unity3d/ads/core/domain/events/GetOperativeEventApi;", "getInitializationState", "Lcom/unity3d/ads/core/domain/GetInitializationState;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "safeCallbackInvoke", "Lcom/unity3d/ads/core/domain/SafeCallbackInvoke;", "(Lcom/unity3d/ads/core/domain/Show;Lcom/unity3d/ads/core/data/repository/AdRepository;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;Lcom/unity3d/ads/core/domain/events/GetOperativeEventApi;Lcom/unity3d/ads/core/domain/GetInitializationState;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/domain/SafeCallbackInvoke;)V", "adObject", "Lcom/unity3d/ads/core/data/model/AdObject;", "hasStarted", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "placement", "", "timeoutCancellationRequested", "unityAdsShowOptions", "Lcom/unity3d/ads/UnityAdsShowOptions;", "bannerLeftApplication", "", "startTime", "Lkotlin/time/TimeMark;", "listeners", "Lcom/unity3d/ads/core/data/model/Listeners;", "cancelTimeout", "getOpportunityId", "getTags", "", "diagnosticReason", "code", "", "debugMessage", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Ljava/util/Map;", "getTmpAdObject", "opportunityId", "invoke", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/unity3d/ads/UnityAdsShowOptions;Lcom/unity3d/ads/core/data/model/Listeners;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendOperativeError", "operativeEvent", "Lgatewayprotocol/v1/OperativeEventRequestOuterClass$OperativeEventErrorType;", "operativeMessage", "(Lgatewayprotocol/v1/OperativeEventRequestOuterClass$OperativeEventErrorType;Ljava/lang/String;Lcom/unity3d/ads/core/data/model/AdObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showClicked", "showCompleted", "status", "Lcom/unity3d/ads/adplayer/model/ShowStatus;", "reason", "reasonDebug", "showError", "Lkotlin/Function6;", "Lcom/unity3d/ads/UnityAds$UnityAdsShowError;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/time/TimeMark;Ljava/lang/String;Ljava/lang/String;Lcom/unity3d/ads/core/data/model/Listeners;)Lkotlin/jvm/functions/Function6;", "showStart", "showStarted", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LegacyShowUseCase {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_OBJECT_ID = "objectId";
    public static final String MESSAGE_AD_OBJECT_EXPIRED = "The ad has expired";
    public static final String MESSAGE_AD_PLAYER_UNAVAILABLE = "Ad player is unavailable.";
    public static final String MESSAGE_ALREADY_SHOWING = "Can't show a new ad unit when ad unit is already open";
    public static final String MESSAGE_NO_AD_OBJECT = "No ad object found for opportunity id: ";
    public static final String MESSAGE_OPPORTUNITY_ID = "No valid opportunity id provided";
    public static final String MESSAGE_OPT_TIMEOUT = "timeout";
    public static final String MESSAGE_PLACEMENT_NOT_LOADED = "Placement %s must be Loaded before calling Show";
    public static final String MESSAGE_TIMEOUT = "[UnityAds] Timeout while trying to show ";
    public static final String MSG_OPPORTUNITY_AND_PLACEMENT_NOT_MATCHING = "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad";
    private static volatile boolean isFullscreenAdShowing;
    private AdObject adObject;
    private final AdRepository adRepository;
    private final GetInitializationState getInitializationState;
    private final GetOperativeEventApi getOperativeEventApi;
    private final MutableStateFlow<Boolean> hasStarted;
    private String placement;
    private final SafeCallbackInvoke safeCallbackInvoke;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private final Show show;
    private final MutableStateFlow<Boolean> timeoutCancellationRequested;
    private UnityAdsShowOptions unityAdsShowOptions;

    public LegacyShowUseCase(Show show, AdRepository adRepository, SendDiagnosticEvent sendDiagnosticEvent, GetOperativeEventApi getOperativeEventApi, GetInitializationState getInitializationState, SessionRepository sessionRepository, SafeCallbackInvoke safeCallbackInvoke) {
        Intrinsics.checkNotNullParameter(show, "show");
        Intrinsics.checkNotNullParameter(adRepository, "adRepository");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        Intrinsics.checkNotNullParameter(getOperativeEventApi, "getOperativeEventApi");
        Intrinsics.checkNotNullParameter(getInitializationState, "getInitializationState");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(safeCallbackInvoke, "safeCallbackInvoke");
        this.show = show;
        this.adRepository = adRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.getOperativeEventApi = getOperativeEventApi;
        this.getInitializationState = getInitializationState;
        this.sessionRepository = sessionRepository;
        this.safeCallbackInvoke = safeCallbackInvoke;
        this.hasStarted = StateFlowKt.MutableStateFlow(false);
        this.timeoutCancellationRequested = StateFlowKt.MutableStateFlow(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x023c, code lost:
    
        if (r6.invoke("ad_player_scope_not_active", r6, com.unity3d.ads.core.domain.LegacyShowUseCase.MESSAGE_AD_PLAYER_UNAVAILABLE, null, null, r10) == r11) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x025f, code lost:
    
        if (r6.invoke("already_showing", r6, com.unity3d.ads.core.domain.LegacyShowUseCase.MESSAGE_ALREADY_SHOWING, null, null, r10) == r11) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0290, code lost:
    
        if (r6.invoke("placement_validation", r6, com.unity3d.ads.core.domain.LegacyShowUseCase.MSG_OPPORTUNITY_AND_PLACEMENT_NOT_MATCHING, null, null, r10) == r11) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0132, code lost:
    
        if (r6.invoke("not_initialized", r6, com.unity3d.ads.core.data.model.LoadResult.MSG_NOT_INITIALIZED, null, null, r10) == r11) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x014b, code lost:
    
        if (r6.invoke("placement_null", r6, com.unity3d.ads.core.data.model.LoadResult.MSG_PLACEMENT_NULL, null, null, r10) == r11) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0178, code lost:
    
        if (r6.invoke("no_opportunity_id", r6, com.unity3d.ads.core.domain.LegacyShowUseCase.MESSAGE_OPPORTUNITY_ID, null, r9, r10) == r11) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01a5, code lost:
    
        if (r6.invoke("placement_not_loaded", r6, r7, null, null, r10) == r11) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e1, code lost:
    
        if (r6.invoke("ad_object_not_found", r6, r7, null, null, r10) == r11) goto L139;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(Activity activity, String str, UnityAdsShowOptions unityAdsShowOptions, Listeners listeners, Continuation<? super Unit> continuation) {
        LegacyShowUseCase$invoke$1 legacyShowUseCase$invoke$1;
        LegacyShowUseCase$invoke$1 legacyShowUseCase$invoke$12;
        Object m10241constructorimpl;
        boolean z;
        int i;
        CoroutineScope scope;
        LegacyShowUseCase legacyShowUseCase;
        ByteString byteString;
        JSONObject data;
        Object opt;
        UUID uuid;
        if (continuation instanceof LegacyShowUseCase$invoke$1) {
            legacyShowUseCase$invoke$1 = (LegacyShowUseCase$invoke$1) continuation;
            if ((legacyShowUseCase$invoke$1.label & Integer.MIN_VALUE) != 0) {
                legacyShowUseCase$invoke$1.label -= Integer.MIN_VALUE;
                legacyShowUseCase$invoke$12 = legacyShowUseCase$invoke$1;
                Object obj = legacyShowUseCase$invoke$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (legacyShowUseCase$invoke$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        long m11706markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                        this.placement = str;
                        this.unityAdsShowOptions = unityAdsShowOptions;
                        DeviceLog.debug("Unity Ads Show Start for placement " + str);
                        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                        String str2 = null;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            LegacyShowUseCase legacyShowUseCase2 = this;
                            m10241constructorimpl = Result.m10241constructorimpl(unityAdsShowOptions != null ? getOpportunityId(unityAdsShowOptions) : null);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                        }
                        if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) != null) {
                            booleanRef.element = true;
                            m10241constructorimpl = UUID.randomUUID().toString();
                        }
                        String str3 = (String) m10241constructorimpl;
                        if (str3 == null) {
                            if (str != null) {
                                ByteString pollOpportunityIdForPlacement = this.adRepository.pollOpportunityIdForPlacement(str);
                                str3 = (pollOpportunityIdForPlacement == null || (uuid = ProtobufExtensionsKt.toUUID(pollOpportunityIdForPlacement)) == null) ? null : uuid.toString();
                                if (str3 == null) {
                                    booleanRef2.element = true;
                                    str3 = UUID.randomUUID().toString();
                                }
                            } else {
                                str3 = UUID.randomUUID().toString();
                            }
                            Intrinsics.checkNotNullExpressionValue(str3, "if (placement != null) {….toString()\n            }");
                        }
                        showStart(str3);
                        Function6<String, UnityAds.UnityAdsShowError, String, Integer, String, Continuation<? super Unit>, Object> showError = showError(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(m11706markNowz9LOYto), str == null ? "" : str, str3, listeners);
                        z = false;
                        if (GetInitializationState.DefaultImpls.invoke$default(this.getInitializationState, false, 1, null) == InitializationState.INITIALIZED) {
                            if (str == null) {
                                UnityAds.UnityAdsShowError unityAdsShowError = UnityAds.UnityAdsShowError.INVALID_ARGUMENT;
                                legacyShowUseCase$invoke$12.label = 2;
                                break;
                            } else if (booleanRef.element) {
                                if (unityAdsShowOptions != null && (data = unityAdsShowOptions.getData()) != null && (opt = data.opt("objectId")) != null) {
                                    str2 = opt.toString();
                                }
                                UnityAds.UnityAdsShowError unityAdsShowError2 = UnityAds.UnityAdsShowError.INVALID_ARGUMENT;
                                legacyShowUseCase$invoke$12.label = 3;
                                break;
                            } else if (booleanRef2.element) {
                                UnityAds.UnityAdsShowError unityAdsShowError3 = UnityAds.UnityAdsShowError.INVALID_ARGUMENT;
                                String format = String.format(MESSAGE_PLACEMENT_NOT_LOADED, Arrays.copyOf(new Object[]{str}, 1));
                                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                                legacyShowUseCase$invoke$12.label = 4;
                                break;
                            } else {
                                UUID fromString = UUID.fromString(str3);
                                Intrinsics.checkNotNullExpressionValue(fromString, "fromString(opportunityId)");
                                ByteString byteString2 = ProtobufExtensionsKt.toByteString(fromString);
                                AdObject ad = this.adRepository.getAd(byteString2);
                                this.adObject = ad;
                                if (ad == null) {
                                    UnityAds.UnityAdsShowError unityAdsShowError4 = UnityAds.UnityAdsShowError.INTERNAL_ERROR;
                                    String str4 = MESSAGE_NO_AD_OBJECT + str3;
                                    legacyShowUseCase$invoke$12.label = 5;
                                    break;
                                } else if (ad.getState().getValue() == AdObjectState.EXPIRED) {
                                    UnityAds.UnityAdsShowError unityAdsShowError5 = UnityAds.UnityAdsShowError.INTERNAL_ERROR;
                                    legacyShowUseCase$invoke$12.L$0 = this;
                                    legacyShowUseCase$invoke$12.L$1 = byteString2;
                                    legacyShowUseCase$invoke$12.label = 6;
                                    if (showError.invoke("ad_object_expired", unityAdsShowError5, MESSAGE_AD_OBJECT_EXPIRED, null, null, legacyShowUseCase$invoke$12) != coroutine_suspended) {
                                        legacyShowUseCase = this;
                                        byteString = byteString2;
                                        legacyShowUseCase.adRepository.removeAd(byteString);
                                        return Unit.INSTANCE;
                                    }
                                } else {
                                    AdPlayer adPlayer = ad.getAdPlayer();
                                    if (((adPlayer == null || (scope = adPlayer.getScope()) == null || CoroutineScopeKt.isActive(scope)) ? false : true) != false) {
                                        UnityAds.UnityAdsShowError unityAdsShowError6 = UnityAds.UnityAdsShowError.INTERNAL_ERROR;
                                        legacyShowUseCase$invoke$12.label = 7;
                                        break;
                                    } else {
                                        boolean z2 = ad.getAdPlayer() instanceof EmbeddableAdPlayer;
                                        if (!z2 && isFullscreenAdShowing) {
                                            UnityAds.UnityAdsShowError unityAdsShowError7 = UnityAds.UnityAdsShowError.ALREADY_SHOWING;
                                            legacyShowUseCase$invoke$12.label = 8;
                                            break;
                                        } else if (this.sessionRepository.getNativeConfiguration().getFeatureFlags().getOpportunityIdPlacementValidation() && !Intrinsics.areEqual(ad.getPlacementId(), str)) {
                                            UnityAds.UnityAdsShowError unityAdsShowError8 = UnityAds.UnityAdsShowError.INVALID_ARGUMENT;
                                            legacyShowUseCase$invoke$12.label = 9;
                                            break;
                                        } else {
                                            long showTimeoutMs = this.sessionRepository.getNativeConfiguration().getAdOperations().getShowTimeoutMs();
                                            if (!z2) {
                                                isFullscreenAdShowing = true;
                                            }
                                            Flow m11782catch = FlowKt.m11782catch(FlowExtensionsKt.timeoutAfter$default(this.show.invoke(activity, ad, unityAdsShowOptions), showTimeoutMs, false, new LegacyShowUseCase$invoke$2(this, z2, ad, true, showError, str, null), 2, null), new LegacyShowUseCase$invoke$3(showError, z2, null));
                                            LegacyShowUseCase$invoke$4 legacyShowUseCase$invoke$4 = new LegacyShowUseCase$invoke$4(this, m11706markNowz9LOYto, str, listeners, ad, showError);
                                            legacyShowUseCase$invoke$12.I$0 = z2 ? 1 : 0;
                                            legacyShowUseCase$invoke$12.label = 10;
                                            if (m11782catch.collect(legacyShowUseCase$invoke$4, legacyShowUseCase$invoke$12) != coroutine_suspended) {
                                                i = z2 ? 1 : 0;
                                                if (i == 0) {
                                                    isFullscreenAdShowing = z;
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            UnityAds.UnityAdsShowError unityAdsShowError9 = UnityAds.UnityAdsShowError.NOT_INITIALIZED;
                            legacyShowUseCase$invoke$12.label = 1;
                            break;
                        }
                        return coroutine_suspended;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 3:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 4:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 5:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 6:
                        byteString = (ByteString) legacyShowUseCase$invoke$12.L$1;
                        legacyShowUseCase = (LegacyShowUseCase) legacyShowUseCase$invoke$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        legacyShowUseCase.adRepository.removeAd(byteString);
                        return Unit.INSTANCE;
                    case 7:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 8:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 9:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 10:
                        i = legacyShowUseCase$invoke$12.I$0;
                        ResultKt.throwOnFailure(obj);
                        z = false;
                        if (i == 0) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        legacyShowUseCase$invoke$1 = new LegacyShowUseCase$invoke$1(this, continuation);
        legacyShowUseCase$invoke$12 = legacyShowUseCase$invoke$1;
        Object obj2 = legacyShowUseCase$invoke$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (legacyShowUseCase$invoke$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bannerLeftApplication(TimeMark startTime, String placement, Listeners listeners) {
        DeviceLog.debug("Unity Ads Show Left Application for placement " + placement);
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_left_app", Double.valueOf(TimeExtensionsKt.elapsedMillis(startTime)), null, null, this.adObject, null, 44, null);
        listeners.onLeftApplication(placement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelTimeout(TimeMark startTime) {
        this.timeoutCancellationRequested.setValue(true);
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_cancel_timeout", Double.valueOf(TimeExtensionsKt.elapsedMillis(startTime)), null, null, this.adObject, null, 44, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showStarted(TimeMark startTime, final String placement, final Listeners listeners) {
        DeviceLog.debug("Unity Ads Show WV Start for placement " + placement);
        this.hasStarted.setValue(true);
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_wv_started", Double.valueOf(TimeExtensionsKt.elapsedMillis(startTime)), null, null, this.adObject, null, 44, null);
        this.safeCallbackInvoke.invoke(new Function0<Unit>() { // from class: com.unity3d.ads.core.domain.LegacyShowUseCase$showStarted$1
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
                Listeners.this.onStart(placement);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showClicked(TimeMark startTime, final String placement, final Listeners listeners) {
        DeviceLog.debug("Unity Ads Show Clicked for placement " + placement);
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_clicked", Double.valueOf(TimeExtensionsKt.elapsedMillis(startTime)), null, null, this.adObject, null, 44, null);
        this.safeCallbackInvoke.invoke(new Function0<Unit>() { // from class: com.unity3d.ads.core.domain.LegacyShowUseCase$showClicked$1
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
                Listeners.this.onClick(placement);
            }
        });
    }

    private final String getOpportunityId(UnityAdsShowOptions unityAdsShowOptions) throws IllegalArgumentException {
        Object opt;
        String obj;
        JSONObject data = unityAdsShowOptions.getData();
        if (data == null || (opt = data.opt("objectId")) == null || (obj = opt.toString()) == null) {
            return null;
        }
        return UUID.fromString(obj).toString();
    }

    private final void showStart(String opportunityId) {
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_started", null, null, null, getTmpAdObject(opportunityId), null, 46, null);
    }

    static /* synthetic */ void showCompleted$default(LegacyShowUseCase legacyShowUseCase, TimeMark timeMark, String str, ShowStatus showStatus, Listeners listeners, String str2, String str3, int i, Object obj) {
        if ((i & 16) != 0) {
            str2 = null;
        }
        if ((i & 32) != 0) {
            str3 = null;
        }
        legacyShowUseCase.showCompleted(timeMark, str, showStatus, listeners, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCompleted(TimeMark startTime, final String placement, final ShowStatus status, final Listeners listeners, String reason, String reasonDebug) {
        DeviceLog.debug("Unity Ads Show Completed for placement " + placement);
        Map createMapBuilder = MapsKt.createMapBuilder();
        if (reason != null) {
        }
        if (reasonDebug != null) {
            createMapBuilder.put("reason_debug", reasonDebug);
        }
        Map build = MapsKt.build(createMapBuilder);
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_success_time", Double.valueOf(TimeExtensionsKt.elapsedMillis(startTime)), build, null, this.adObject, null, 40, null);
        this.safeCallbackInvoke.invoke(new Function0<Unit>() { // from class: com.unity3d.ads.core.domain.LegacyShowUseCase$showCompleted$1
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
                SessionRepository sessionRepository;
                Listeners listeners2 = Listeners.this;
                String str = placement;
                ShowStatus showStatus = status;
                sessionRepository = this.sessionRepository;
                NativeConfigurationOuterClass.ShowCompletionState defaultShowCompletionState = sessionRepository.getNativeConfiguration().getDefaultShowCompletionState();
                Intrinsics.checkNotNullExpressionValue(defaultShowCompletionState, "sessionRepository.native…efaultShowCompletionState");
                listeners2.onComplete(str, ShowStatusExtensionsKt.toUnityAdsShowCompletionState(showStatus, defaultShowCompletionState));
            }
        });
    }

    private final Function6<String, UnityAds.UnityAdsShowError, String, Integer, String, Continuation<? super Unit>, Object> showError(TimeMark startTime, String placement, String opportunityId, Listeners listeners) {
        return new LegacyShowUseCase$showError$1(placement, this, opportunityId, startTime, listeners, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> getTags(String diagnosticReason, Integer code, String debugMessage) {
        Map<String, String> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("operation", OperationType.SHOW.toString()), TuplesKt.to("reason", diagnosticReason));
        if (code != null) {
            mutableMapOf.put("reason_code", String.valueOf(code.intValue()));
        }
        if (debugMessage != null) {
            mutableMapOf.put("reason_debug", debugMessage);
        }
        return mutableMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdObject getTmpAdObject(String opportunityId) {
        UUID fromString = UUID.fromString(opportunityId);
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(opportunityId)");
        ByteString byteString = ProtobufExtensionsKt.toByteString(fromString);
        AdObject ad = this.adRepository.getAd(byteString);
        if (ad != null) {
            return ad;
        }
        String str = this.placement;
        if (str == null) {
            str = "";
        }
        ByteString EMPTY = ByteString.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        return new AdObject(byteString, str, EMPTY, false, null, null, null, false, null, null, null, new UnityAdsLoadOptions(), false, DiagnosticEventRequestOuterClass.DiagnosticAdType.DIAGNOSTIC_AD_TYPE_UNSPECIFIED, null, null, 50680, null);
    }

    /* compiled from: LegacyShowUseCase.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/unity3d/ads/core/domain/LegacyShowUseCase$Companion;", "", "()V", "KEY_OBJECT_ID", "", "MESSAGE_AD_OBJECT_EXPIRED", "MESSAGE_AD_PLAYER_UNAVAILABLE", "MESSAGE_ALREADY_SHOWING", "MESSAGE_NO_AD_OBJECT", "MESSAGE_OPPORTUNITY_ID", "MESSAGE_OPT_TIMEOUT", "MESSAGE_PLACEMENT_NOT_LOADED", "MESSAGE_TIMEOUT", "MSG_OPPORTUNITY_AND_PLACEMENT_NOT_MATCHING", "isFullscreenAdShowing", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object sendOperativeError(OperativeEventRequestOuterClass.OperativeEventErrorType operativeEventErrorType, String str, AdObject adObject, Continuation<? super Unit> continuation) {
        OperativeEventErrorDataKt.Dsl.Companion companion = OperativeEventErrorDataKt.Dsl.INSTANCE;
        OperativeEventRequestOuterClass.OperativeEventErrorData.Builder newBuilder = OperativeEventRequestOuterClass.OperativeEventErrorData.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        OperativeEventErrorDataKt.Dsl _create = companion._create(newBuilder);
        _create.setErrorType(operativeEventErrorType);
        _create.setMessage(str);
        OperativeEventRequestOuterClass.OperativeEventErrorData _build = _create._build();
        GetOperativeEventApi getOperativeEventApi = this.getOperativeEventApi;
        OperativeEventRequestOuterClass.OperativeEventType operativeEventType = OperativeEventRequestOuterClass.OperativeEventType.OPERATIVE_EVENT_TYPE_SHOW_ERROR;
        ByteString byteString = _build.toByteString();
        Intrinsics.checkNotNullExpressionValue(byteString, "errorData.toByteString()");
        Object invoke = getOperativeEventApi.invoke(operativeEventType, adObject, byteString, continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }
}
