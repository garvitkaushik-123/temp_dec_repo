package com.unity3d.ads.core.domain;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.protobuf.ByteString;
import com.ironsource.C3040d4;
import com.ironsource.L2;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.AdObjectState;
import com.unity3d.ads.core.data.model.LoadResult;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.GetInitializationState;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.ExceptionExtensionsKt;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.core.log.DeviceLog;
import gatewayprotocol.v1.AdRequestOuterClass;
import gatewayprotocol.v1.BannerSizeKt;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.HeaderBiddingAdMarkupOuterClass;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONObject;

/* compiled from: LegacyLoadUseCase.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 @2\u00020\u0001:\u0001@BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0012\u0010!\u001a\u0004\u0018\u00010\u00142\u0006\u0010\"\u001a\u00020\u001bH\u0002J\b\u0010#\u001a\u00020$H\u0002J\u0014\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0014\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010\u00142\u0006\u0010\"\u001a\u00020\u001bH\u0002J,\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0014H\u0002J\u001a\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00142\b\b\u0002\u00103\u001a\u00020\u0016H\u0002JA\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\b\u0010\u001e\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\b\u00108\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(H\u0086Bø\u0001\u0000¢\u0006\u0002\u00109J\u0018\u0010:\u001a\u0002052\u0006\u00102\u001a\u00020\u00142\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020 2\u0006\u00102\u001a\u00020\u0014H\u0002J\u0010\u0010>\u001a\u0002052\u0006\u0010?\u001a\u000201H\u0002R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006A"}, d2 = {"Lcom/unity3d/ads/core/domain/LegacyLoadUseCase;", "", "load", "Lcom/unity3d/ads/core/domain/Load;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "getInitializationState", "Lcom/unity3d/ads/core/domain/GetInitializationState;", "awaitInitialization", "Lcom/unity3d/ads/core/domain/AwaitInitialization;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "adRepository", "Lcom/unity3d/ads/core/data/repository/AdRepository;", "safeCallbackInvoke", "Lcom/unity3d/ads/core/domain/SafeCallbackInvoke;", "cleanUpWhenOpportunityExpires", "Lcom/unity3d/ads/core/domain/CleanUpWhenOpportunityExpires;", "(Lcom/unity3d/ads/core/domain/Load;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;Lcom/unity3d/ads/core/domain/GetInitializationState;Lcom/unity3d/ads/core/domain/AwaitInitialization;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/AdRepository;Lcom/unity3d/ads/core/domain/SafeCallbackInvoke;Lcom/unity3d/ads/core/domain/CleanUpWhenOpportunityExpires;)V", "adMarkup", "", C3040d4.v, "", HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/unity3d/ads/IUnityAdsLoadListener;", HandleInvocationsFromAdViewer.KEY_LOAD_OPTIONS, "Lcom/unity3d/ads/UnityAdsLoadOptions;", "opportunity", "Lcom/google/protobuf/ByteString;", "placement", "startTime", "Lkotlin/time/TimeMark;", "getAdMarkup", "unityAdsLoadOptions", "getAdType", "Lgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticAdType;", "getBannerSize", "Lgatewayprotocol/v1/AdRequestOuterClass$BannerSize;", L2.u, "Lcom/unity3d/services/banners/UnityBannerSize;", "getHeaderBiddingAdMarkup", "Lgatewayprotocol/v1/HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup;", "getOpportunityId", "getTags", "", "reason", "reasonDebug", "getTmpAdObject", "Lcom/unity3d/ads/core/data/model/AdObject;", "opportunityId", "isScarAd", "invoke", "", "context", "Landroid/content/Context;", "unityLoadListener", "(Landroid/content/Context;Ljava/lang/String;Lcom/unity3d/ads/UnityAdsLoadOptions;Lcom/unity3d/ads/IUnityAdsLoadListener;Lcom/unity3d/services/banners/UnityBannerSize;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFailure", "loadResult", "Lcom/unity3d/ads/core/data/model/LoadResult$Failure;", "loadStart", "loadSuccess", "adObject", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LegacyLoadUseCase {
    public static final String KEY_AD_MARKUP = "adMarkup";
    public static final String KEY_OBJECT_ID = "objectId";
    private String adMarkup;
    private final AdRepository adRepository;
    private final AwaitInitialization awaitInitialization;
    private final CleanUpWhenOpportunityExpires cleanUpWhenOpportunityExpires;
    private final GetInitializationState getInitializationState;
    private boolean isBanner;
    private boolean isHeaderBidding;
    private IUnityAdsLoadListener listener;
    private final Load load;
    private UnityAdsLoadOptions loadOptions;
    private ByteString opportunity;
    private String placement;
    private final SafeCallbackInvoke safeCallbackInvoke;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private TimeMark startTime;

    public LegacyLoadUseCase(Load load, SendDiagnosticEvent sendDiagnosticEvent, GetInitializationState getInitializationState, AwaitInitialization awaitInitialization, SessionRepository sessionRepository, AdRepository adRepository, SafeCallbackInvoke safeCallbackInvoke, CleanUpWhenOpportunityExpires cleanUpWhenOpportunityExpires) {
        Intrinsics.checkNotNullParameter(load, "load");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        Intrinsics.checkNotNullParameter(getInitializationState, "getInitializationState");
        Intrinsics.checkNotNullParameter(awaitInitialization, "awaitInitialization");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(adRepository, "adRepository");
        Intrinsics.checkNotNullParameter(safeCallbackInvoke, "safeCallbackInvoke");
        Intrinsics.checkNotNullParameter(cleanUpWhenOpportunityExpires, "cleanUpWhenOpportunityExpires");
        this.load = load;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.getInitializationState = getInitializationState;
        this.awaitInitialization = awaitInitialization;
        this.sessionRepository = sessionRepository;
        this.adRepository = adRepository;
        this.safeCallbackInvoke = safeCallbackInvoke;
        this.cleanUpWhenOpportunityExpires = cleanUpWhenOpportunityExpires;
    }

    public static /* synthetic */ Object invoke$default(LegacyLoadUseCase legacyLoadUseCase, Context context, String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener, UnityBannerSize unityBannerSize, Continuation continuation, int i, Object obj) {
        if ((i & 16) != 0) {
            unityBannerSize = null;
        }
        return legacyLoadUseCase.invoke(context, str, unityAdsLoadOptions, iUnityAdsLoadListener, unityBannerSize, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00db A[Catch: all -> 0x0046, TryCatch #1 {all -> 0x0046, blocks: (B:11:0x0041, B:12:0x00d7, B:14:0x00db, B:15:0x00fe, B:17:0x0102, B:21:0x010c, B:23:0x0110), top: B:10:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0102 A[Catch: all -> 0x0046, TryCatch #1 {all -> 0x0046, blocks: (B:11:0x0041, B:12:0x00d7, B:14:0x00db, B:15:0x00fe, B:17:0x0102, B:21:0x010c, B:23:0x0110), top: B:10:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x010c A[Catch: all -> 0x0046, TryCatch #1 {all -> 0x0046, blocks: (B:11:0x0041, B:12:0x00d7, B:14:0x00db, B:15:0x00fe, B:17:0x0102, B:21:0x010c, B:23:0x0110), top: B:10:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(Context context, String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener, UnityBannerSize unityBannerSize, Continuation<? super Unit> continuation) {
        LegacyLoadUseCase$invoke$1 legacyLoadUseCase$invoke$1;
        int i;
        String str2;
        LegacyLoadUseCase legacyLoadUseCase;
        String str3;
        LoadResult.Failure failure;
        if (continuation instanceof LegacyLoadUseCase$invoke$1) {
            legacyLoadUseCase$invoke$1 = (LegacyLoadUseCase$invoke$1) continuation;
            if ((legacyLoadUseCase$invoke$1.label & Integer.MIN_VALUE) != 0) {
                legacyLoadUseCase$invoke$1.label -= Integer.MIN_VALUE;
                LegacyLoadUseCase$invoke$1 legacyLoadUseCase$invoke$12 = legacyLoadUseCase$invoke$1;
                Object obj = legacyLoadUseCase$invoke$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = legacyLoadUseCase$invoke$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    DeviceLog.debug("Unity Ads Load Start for placement " + str);
                    long loadTimeoutMs = this.sessionRepository.getNativeConfiguration().getAdOperations().getLoadTimeoutMs();
                    AdRequestOuterClass.BannerSize bannerSize = getBannerSize(unityBannerSize);
                    this.loadOptions = unityAdsLoadOptions;
                    String adMarkup = getAdMarkup(unityAdsLoadOptions);
                    this.adMarkup = adMarkup;
                    String str4 = adMarkup;
                    this.isHeaderBidding = !(str4 == null || StringsKt.isBlank(str4));
                    this.isBanner = unityBannerSize != null;
                    this.listener = iUnityAdsLoadListener;
                    this.placement = str;
                    String opportunityId = getOpportunityId(unityAdsLoadOptions);
                    if (opportunityId == null) {
                        opportunityId = UUID.randomUUID().toString();
                        Intrinsics.checkNotNullExpressionValue(opportunityId, "randomUUID().toString()");
                    }
                    String str5 = opportunityId;
                    this.startTime = loadStart(str5);
                    try {
                        LegacyLoadUseCase$invoke$loadResult$1 legacyLoadUseCase$invoke$loadResult$1 = new LegacyLoadUseCase$invoke$loadResult$1(str, str5, this, context, bannerSize, unityAdsLoadOptions, null);
                        legacyLoadUseCase$invoke$12.L$0 = this;
                        legacyLoadUseCase$invoke$12.L$1 = str;
                        legacyLoadUseCase$invoke$12.L$2 = str5;
                        legacyLoadUseCase$invoke$12.label = 1;
                        Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(loadTimeoutMs, legacyLoadUseCase$invoke$loadResult$1, legacyLoadUseCase$invoke$12);
                        if (withTimeoutOrNull == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = withTimeoutOrNull;
                        str3 = str;
                        str2 = str5;
                        legacyLoadUseCase = this;
                    } catch (Throwable th) {
                        th = th;
                        str2 = str5;
                        legacyLoadUseCase = this;
                        legacyLoadUseCase.loadFailure(str2, new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, th, "uncaught_exception", ExceptionExtensionsKt.getShortenedStackTrace$default(th, 0, 1, null), false, 32, null));
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str2 = (String) legacyLoadUseCase$invoke$12.L$2;
                    str3 = (String) legacyLoadUseCase$invoke$12.L$1;
                    legacyLoadUseCase = (LegacyLoadUseCase) legacyLoadUseCase$invoke$12.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        legacyLoadUseCase.loadFailure(str2, new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, th, "uncaught_exception", ExceptionExtensionsKt.getShortenedStackTrace$default(th, 0, 1, null), false, 32, null));
                        return Unit.INSTANCE;
                    }
                }
                failure = (LoadResult) obj;
                if (failure == null) {
                    failure = new LoadResult.Failure(UnityAds.UnityAdsLoadError.TIMEOUT, LoadResult.MSG_TIMEOUT + str3, null, "timeout", null, false, 52, null);
                }
                if (!(failure instanceof LoadResult.Success)) {
                    legacyLoadUseCase.loadSuccess(((LoadResult.Success) failure).getAdObject());
                } else if (failure instanceof LoadResult.Failure) {
                    legacyLoadUseCase.loadFailure(str2, (LoadResult.Failure) failure);
                }
                return Unit.INSTANCE;
            }
        }
        legacyLoadUseCase$invoke$1 = new LegacyLoadUseCase$invoke$1(this, continuation);
        LegacyLoadUseCase$invoke$1 legacyLoadUseCase$invoke$122 = legacyLoadUseCase$invoke$1;
        Object obj2 = legacyLoadUseCase$invoke$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = legacyLoadUseCase$invoke$122.label;
        if (i != 0) {
        }
        failure = (LoadResult) obj2;
        if (failure == null) {
        }
        if (!(failure instanceof LoadResult.Success)) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup getHeaderBiddingAdMarkup(String adMarkup) {
        String str = adMarkup;
        if (str != null && !StringsKt.isBlank(str)) {
            try {
                return HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup.parseFrom(ProtobufExtensionsKt.fromBase64$default(adMarkup, false, 1, null).toByteArray());
            } catch (Exception unused) {
                return null;
            }
        }
        return HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup.getDefaultInstance();
    }

    private final String getOpportunityId(UnityAdsLoadOptions unityAdsLoadOptions) {
        Object opt;
        JSONObject data = unityAdsLoadOptions.getData();
        if (data == null || (opt = data.opt("objectId")) == null) {
            return null;
        }
        return opt.toString();
    }

    private final String getAdMarkup(UnityAdsLoadOptions unityAdsLoadOptions) {
        Object opt;
        JSONObject data = unityAdsLoadOptions.getData();
        if (data == null || (opt = data.opt("adMarkup")) == null) {
            return null;
        }
        return opt.toString();
    }

    private final TimeMark loadStart(String opportunityId) {
        long m11706markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_load_started", null, getTags$default(this, null, null, 3, null), null, getTmpAdObject$default(this, opportunityId, false, 2, null), null, 42, null);
        return TimeSource.Monotonic.ValueTimeMark.m11707boximpl(m11706markNowz9LOYto);
    }

    private final void loadSuccess(AdObject adObject) {
        DeviceLog.debug("Unity Ads Load Success for placement: " + this.placement);
        adObject.getState().setValue(AdObjectState.LOADED);
        this.cleanUpWhenOpportunityExpires.invoke(adObject);
        SendDiagnosticEvent sendDiagnosticEvent = this.sendDiagnosticEvent;
        TimeMark timeMark = this.startTime;
        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_load_success_time", timeMark != null ? Double.valueOf(TimeExtensionsKt.elapsedMillis(timeMark)) : null, getTags$default(this, null, null, 3, null), null, adObject, null, 40, null);
        this.safeCallbackInvoke.invoke(new Function0<Unit>() { // from class: com.unity3d.ads.core.domain.LegacyLoadUseCase$loadSuccess$1
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
                IUnityAdsLoadListener iUnityAdsLoadListener;
                String str;
                iUnityAdsLoadListener = LegacyLoadUseCase.this.listener;
                if (iUnityAdsLoadListener != null) {
                    str = LegacyLoadUseCase.this.placement;
                    iUnityAdsLoadListener.onUnityAdsAdLoaded(str);
                }
            }
        });
    }

    private final void loadFailure(String opportunityId, final LoadResult.Failure loadResult) {
        DeviceLog.debug("Unity Ads Load Failure for placement: " + this.placement + " reason: " + loadResult.getError() + " :: " + loadResult.getMessage());
        SendDiagnosticEvent sendDiagnosticEvent = this.sendDiagnosticEvent;
        TimeMark timeMark = this.startTime;
        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_load_failure_time", timeMark != null ? Double.valueOf(TimeExtensionsKt.elapsedMillis(timeMark)) : null, getTags(loadResult.getReason(), loadResult.getReasonDebug()), null, getTmpAdObject(opportunityId, loadResult.isScarAd()), null, 40, null);
        this.safeCallbackInvoke.invoke(new Function0<Unit>() { // from class: com.unity3d.ads.core.domain.LegacyLoadUseCase$loadFailure$1
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
                IUnityAdsLoadListener iUnityAdsLoadListener;
                String str;
                iUnityAdsLoadListener = LegacyLoadUseCase.this.listener;
                if (iUnityAdsLoadListener != null) {
                    str = LegacyLoadUseCase.this.placement;
                    iUnityAdsLoadListener.onUnityAdsFailedToLoad(str, loadResult.getError(), loadResult.getMessage());
                }
            }
        });
    }

    static /* synthetic */ Map getTags$default(LegacyLoadUseCase legacyLoadUseCase, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return legacyLoadUseCase.getTags(str, str2);
    }

    private final Map<String, String> getTags(String reason, String reasonDebug) {
        Map<String, String> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("state", GetInitializationState.DefaultImpls.invoke$default(this.getInitializationState, false, 1, null).toString()), TuplesKt.to("operation", OperationType.LOAD.toString()));
        String str = reason;
        if (str != null && str.length() != 0) {
            mutableMapOf.put("reason", reason);
        }
        String str2 = reasonDebug;
        if (str2 != null && str2.length() != 0) {
            mutableMapOf.put("reason_debug", reasonDebug);
        }
        return mutableMapOf;
    }

    private final DiagnosticEventRequestOuterClass.DiagnosticAdType getAdType() {
        return this.isBanner ? DiagnosticEventRequestOuterClass.DiagnosticAdType.DIAGNOSTIC_AD_TYPE_BANNER : DiagnosticEventRequestOuterClass.DiagnosticAdType.DIAGNOSTIC_AD_TYPE_FULLSCREEN;
    }

    static /* synthetic */ AdObject getTmpAdObject$default(LegacyLoadUseCase legacyLoadUseCase, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return legacyLoadUseCase.getTmpAdObject(str, z);
    }

    private final AdObject getTmpAdObject(String opportunityId, boolean isScarAd) {
        UUID fromString = UUID.fromString(opportunityId);
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(opportunityId)");
        ByteString byteString = ProtobufExtensionsKt.toByteString(fromString);
        String str = this.placement;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        ByteString EMPTY = ByteString.EMPTY;
        UnityAdsLoadOptions unityAdsLoadOptions = this.loadOptions;
        if (unityAdsLoadOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException(HandleInvocationsFromAdViewer.KEY_LOAD_OPTIONS);
            unityAdsLoadOptions = null;
        }
        UnityAdsLoadOptions unityAdsLoadOptions2 = unityAdsLoadOptions;
        boolean z = this.isHeaderBidding;
        DiagnosticEventRequestOuterClass.DiagnosticAdType adType = getAdType();
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        return new AdObject(byteString, str2, EMPTY, isScarAd, null, null, null, false, null, null, null, unityAdsLoadOptions2, z, adType, null, null, 50672, null);
    }

    private final AdRequestOuterClass.BannerSize getBannerSize(UnityBannerSize bannerSize) {
        if (bannerSize == null) {
            return null;
        }
        BannerSizeKt.Dsl.Companion companion = BannerSizeKt.Dsl.INSTANCE;
        AdRequestOuterClass.BannerSize.Builder newBuilder = AdRequestOuterClass.BannerSize.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        BannerSizeKt.Dsl _create = companion._create(newBuilder);
        _create.setWidth(bannerSize.getWidth());
        _create.setHeight(bannerSize.getHeight());
        return _create._build();
    }
}
