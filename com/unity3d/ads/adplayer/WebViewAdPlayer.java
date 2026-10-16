package com.unity3d.ads.adplayer;

import android.util.Base64;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.google.protobuf.ByteString;
import com.ironsource.C3061e8;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.adplayer.model.LoadEvent;
import com.unity3d.ads.adplayer.model.OnActivityDestroyedEvent;
import com.unity3d.ads.adplayer.model.OnAllowedPiiChangeEvent;
import com.unity3d.ads.adplayer.model.OnBroadcastEvent;
import com.unity3d.ads.adplayer.model.OnFocusChangeEvent;
import com.unity3d.ads.adplayer.model.OnGmaEvent;
import com.unity3d.ads.adplayer.model.OnMuteChangeEvent;
import com.unity3d.ads.adplayer.model.OnOfferwallEvent;
import com.unity3d.ads.adplayer.model.OnPrivacyFsmChangeEvent;
import com.unity3d.ads.adplayer.model.OnScarBannerEvent;
import com.unity3d.ads.adplayer.model.OnStorageEvent;
import com.unity3d.ads.adplayer.model.OnUserConsentChangeEvent;
import com.unity3d.ads.adplayer.model.OnVisibilityChangeEvent;
import com.unity3d.ads.adplayer.model.OnVolumeChangeEvent;
import com.unity3d.ads.adplayer.model.ShowStatus;
import com.unity3d.ads.adplayer.model.WebViewEvent;
import com.unity3d.ads.core.data.model.OfferwallShowEvent;
import com.unity3d.ads.core.data.model.ScarEvent;
import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.services.ads.offerwall.OfferwallEvent;
import com.unity3d.services.banners.bridge.BannerBridge;
import com.unity3d.services.core.device.Storage;
import com.unity3d.services.core.device.StorageEventInfo;
import com.vungle.ads.internal.protos.Sdk;
import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONObject;

/* compiled from: WebViewAdPlayer.kt */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010/\u001a\u00020,H\u0016J\u0019\u00100\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0096@ø\u0001\u0000¢\u0006\u0002\u00103J\u0019\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020\u0016H\u0096@ø\u0001\u0000¢\u0006\u0002\u00106J)\u00107\u001a\u00020,2\u0016\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010:\u0018\u000109H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010;J\u0011\u0010<\u001a\u00020,H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010=J\u001f\u0010>\u001a\u00020,2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010BJ\u0019\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020\u0013H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010EJ\u0019\u0010F\u001a\u00020,2\u0006\u00105\u001a\u00020GH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010HJ\u0019\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u00020\u0013H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010EJ\u0019\u0010K\u001a\u00020,2\u0006\u00105\u001a\u00020LH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010MJ\u0019\u0010N\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0096@ø\u0001\u0000¢\u0006\u0002\u00103J\u0019\u0010O\u001a\u00020,2\u0006\u00105\u001a\u00020PH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010QJ\u0019\u0010R\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0096@ø\u0001\u0000¢\u0006\u0002\u00103J\u0019\u0010S\u001a\u00020,2\u0006\u0010T\u001a\u00020\u0013H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010EJ\u0019\u0010U\u001a\u00020,2\u0006\u0010V\u001a\u00020WH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010XR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0014\u0010$\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Y"}, d2 = {"Lcom/unity3d/ads/adplayer/WebViewAdPlayer;", "Lcom/unity3d/ads/adplayer/AdPlayer;", "bridge", "Lcom/unity3d/ads/adplayer/WebViewBridge;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "webViewContainer", "Lcom/unity3d/ads/adplayer/WebViewContainer;", "adPlayerScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lcom/unity3d/ads/adplayer/WebViewBridge;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;Lcom/unity3d/ads/adplayer/WebViewContainer;Lkotlinx/coroutines/CoroutineScope;)V", "isCompletedManually", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "onBroadcastEvents", "Lkotlinx/coroutines/flow/Flow;", "", "onLoadEvent", "Lcom/unity3d/ads/adplayer/model/LoadEvent;", "getOnLoadEvent", "()Lkotlinx/coroutines/flow/Flow;", "onOfferwallEvent", "Lcom/unity3d/ads/core/data/model/OfferwallShowEvent$Show;", "getOnOfferwallEvent", "onScarEvent", "Lcom/unity3d/ads/core/data/model/ScarEvent$Show;", "getOnScarEvent", "onShowEvent", "Lcom/unity3d/ads/core/data/model/ShowEvent;", "getOnShowEvent", "scope", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scopeCancellationHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "storageEventCallback", "Lkotlin/Function1;", "Lcom/unity3d/services/core/device/StorageEventInfo;", "", "getWebViewContainer", "()Lcom/unity3d/ads/adplayer/WebViewContainer;", "dispatchShowCompleted", "onAllowedPiiChange", "value", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBroadcastEvent", "event", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestShow", "unityAdsShowOptions", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendActivityDestroyed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendEvent", "getEvent", "Lkotlin/Function0;", "Lcom/unity3d/ads/adplayer/model/WebViewEvent;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendFocusChange", "isFocused", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendGmaEvent", "Lcom/unity3d/scar/adapter/common/GMAEvent;", "(Lcom/unity3d/scar/adapter/common/GMAEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMuteChange", "isMuted", "sendOfferwallEvent", "Lcom/unity3d/services/ads/offerwall/OfferwallEvent;", "(Lcom/unity3d/services/ads/offerwall/OfferwallEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPrivacyFsmChange", "sendScarBannerEvent", "Lcom/unity3d/services/banners/bridge/BannerBridge$BannerEvent;", "(Lcom/unity3d/services/banners/bridge/BannerBridge$BannerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendUserConsentChange", "sendVisibilityChange", C3061e8.k, "sendVolumeChange", "volume", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WebViewAdPlayer implements AdPlayer {
    private final WebViewBridge bridge;
    private final DeviceInfoRepository deviceInfoRepository;
    private final CoroutineDispatcher dispatcher;
    private final MutableStateFlow<Boolean> isCompletedManually;
    private final Flow<String> onBroadcastEvents;
    private final Flow<LoadEvent> onLoadEvent;
    private final Flow<OfferwallShowEvent.Show> onOfferwallEvent;
    private final Flow<ScarEvent.Show> onScarEvent;
    private final Flow<ShowEvent> onShowEvent;
    private final CoroutineScope scope;
    private final CoroutineExceptionHandler scopeCancellationHandler;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private final Function1<StorageEventInfo, Unit> storageEventCallback;
    private final WebViewContainer webViewContainer;

    public WebViewAdPlayer(WebViewBridge bridge, DeviceInfoRepository deviceInfoRepository, SessionRepository sessionRepository, CoroutineDispatcher dispatcher, SendDiagnosticEvent sendDiagnosticEvent, WebViewContainer webViewContainer, CoroutineScope adPlayerScope) {
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        Intrinsics.checkNotNullParameter(deviceInfoRepository, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        Intrinsics.checkNotNullParameter(webViewContainer, "webViewContainer");
        Intrinsics.checkNotNullParameter(adPlayerScope, "adPlayerScope");
        this.bridge = bridge;
        this.deviceInfoRepository = deviceInfoRepository;
        this.sessionRepository = sessionRepository;
        this.dispatcher = dispatcher;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.webViewContainer = webViewContainer;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this.isCompletedManually = MutableStateFlow;
        Function1<StorageEventInfo, Unit> function1 = new Function1<StorageEventInfo, Unit>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$storageEventCallback$1
            {
                super(1);
            }

            /* compiled from: WebViewAdPlayer.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$storageEventCallback$1$1", f = "WebViewAdPlayer.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$storageEventCallback$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ StorageEventInfo $it;
                int label;
                final /* synthetic */ WebViewAdPlayer this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(WebViewAdPlayer webViewAdPlayer, StorageEventInfo storageEventInfo, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = webViewAdPlayer;
                    this.$it = storageEventInfo;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$it, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    WebViewBridge webViewBridge;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        webViewBridge = this.this$0.bridge;
                        this.label = 1;
                        if (webViewBridge.sendEvent(new OnStorageEvent(this.$it.getEventType(), this.$it.getStorageType(), this.$it.getValue()), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StorageEventInfo storageEventInfo) {
                invoke2(storageEventInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StorageEventInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                BuildersKt__Builders_commonKt.launch$default(WebViewAdPlayer.this.getScope(), null, null, new AnonymousClass1(WebViewAdPlayer.this, it, null), 3, null);
            }
        };
        this.storageEventCallback = function1;
        WebViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1 webViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1 = new WebViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this);
        this.scopeCancellationHandler = webViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1;
        this.scope = CoroutineScopeKt.plus(CoroutineScopeKt.plus(CoroutineScopeKt.plus(adPlayerScope, dispatcher), new CoroutineName("WebViewAdPlayer")), webViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1);
        final SharedFlow<Invocation> onInvocation = bridge.getOnInvocation();
        final Flow<Invocation> flow = new Flow<Invocation>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1$2", f = "WebViewAdPlayer.kt", i = {}, l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {}, s = {})
                /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                if (ArraysKt.contains(new String[]{ExposedFunctionLocation.SHOW_SCAR_AD}, ((Invocation) obj).getLocation())) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Invocation> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        this.onScarEvent = new Flow<ScarEvent.Show>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1$2", f = "WebViewAdPlayer.kt", i = {0}, l = {224, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {"it"}, s = {"L$1"})
                /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code restructure failed: missing block: B:20:0x0071, code lost:
                
                    if (r2.emit(r7, r0) == r1) goto L23;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:21:0x0073, code lost:
                
                    return r1;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
                
                    if (com.unity3d.ads.adplayer.Invocation.handle$default(r7, null, r0, 1, null) == r1) goto L23;
                 */
                /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
                /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    FlowCollector flowCollector;
                    Invocation invocation;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                flowCollector = this.$this_unsafeFlow;
                                invocation = (Invocation) obj;
                                anonymousClass1.L$0 = flowCollector;
                                anonymousClass1.L$1 = invocation;
                                anonymousClass1.label = 1;
                            } else {
                                if (i != 1) {
                                    if (i != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj2);
                                    return Unit.INSTANCE;
                                }
                                invocation = (Invocation) anonymousClass1.L$1;
                                flowCollector = (FlowCollector) anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            if (Intrinsics.areEqual(invocation.getLocation(), ExposedFunctionLocation.SHOW_SCAR_AD)) {
                                throw new IllegalStateException(("Unexpected location: " + invocation.getLocation()).toString());
                            }
                            ScarEvent.Show show = ScarEvent.Show.INSTANCE;
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.label = 2;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    if (Intrinsics.areEqual(invocation.getLocation(), ExposedFunctionLocation.SHOW_SCAR_AD)) {
                    }
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super ScarEvent.Show> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        final SharedFlow<Invocation> onInvocation2 = bridge.getOnInvocation();
        final Flow<Invocation> flow2 = new Flow<Invocation>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2$2", f = "WebViewAdPlayer.kt", i = {}, l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {}, s = {})
                /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                if (ArraysKt.contains(new String[]{ExposedFunctionLocation.SHOW_OFFERWALL_AD}, ((Invocation) obj).getLocation())) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Invocation> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        this.onOfferwallEvent = new Flow<OfferwallShowEvent.Show>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2$2", f = "WebViewAdPlayer.kt", i = {0}, l = {224, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {"it"}, s = {"L$1"})
                /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code restructure failed: missing block: B:20:0x0071, code lost:
                
                    if (r2.emit(r7, r0) == r1) goto L23;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:21:0x0073, code lost:
                
                    return r1;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
                
                    if (com.unity3d.ads.adplayer.Invocation.handle$default(r7, null, r0, 1, null) == r1) goto L23;
                 */
                /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
                /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    FlowCollector flowCollector;
                    Invocation invocation;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                flowCollector = this.$this_unsafeFlow;
                                invocation = (Invocation) obj;
                                anonymousClass1.L$0 = flowCollector;
                                anonymousClass1.L$1 = invocation;
                                anonymousClass1.label = 1;
                            } else {
                                if (i != 1) {
                                    if (i != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj2);
                                    return Unit.INSTANCE;
                                }
                                invocation = (Invocation) anonymousClass1.L$1;
                                flowCollector = (FlowCollector) anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            if (Intrinsics.areEqual(invocation.getLocation(), ExposedFunctionLocation.SHOW_OFFERWALL_AD)) {
                                throw new IllegalStateException(("Unexpected location: " + invocation.getLocation()).toString());
                            }
                            OfferwallShowEvent.Show show = OfferwallShowEvent.Show.INSTANCE;
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.label = 2;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    if (Intrinsics.areEqual(invocation.getLocation(), ExposedFunctionLocation.SHOW_OFFERWALL_AD)) {
                    }
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super OfferwallShowEvent.Show> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        final SharedFlow<Invocation> onInvocation3 = bridge.getOnInvocation();
        final Flow<Invocation> flow3 = new Flow<Invocation>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3$2", f = "WebViewAdPlayer.kt", i = {}, l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {}, s = {})
                /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    String[] strArr;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                strArr = WebViewAdPlayerKt.SHOW_EVENTS;
                                if (ArraysKt.contains(strArr, ((Invocation) obj).getLocation())) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Invocation> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        this.onShowEvent = FlowKt.flowCombine(new Flow<ShowEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3$2", f = "WebViewAdPlayer.kt", i = {0}, l = {244, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {"event"}, s = {"L$1"})
                /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Code restructure failed: missing block: B:18:0x011a, code lost:
                
                    if (r2.emit(r13, r0) != r1) goto L56;
                 */
                /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x010f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    FlowCollector flowCollector;
                    ShowEvent.CancelTimeout cancelTimeout;
                    ShowEvent showEvent;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                flowCollector = this.$this_unsafeFlow;
                                Invocation invocation = (Invocation) obj;
                                String location = invocation.getLocation();
                                switch (location.hashCode()) {
                                    case -1250843874:
                                        if (location.equals(ExposedFunctionLocation.CANCEL_SHOW_TIMEOUT)) {
                                            cancelTimeout = ShowEvent.CancelTimeout.INSTANCE;
                                            anonymousClass1.L$0 = flowCollector;
                                            anonymousClass1.L$1 = cancelTimeout;
                                            anonymousClass1.label = 1;
                                            if (Invocation.handle$default(invocation, null, anonymousClass1, 1, null) != coroutine_suspended) {
                                                showEvent = cancelTimeout;
                                                break;
                                            }
                                            return coroutine_suspended;
                                        }
                                        throw new IllegalStateException("Unexpected location: " + invocation.getLocation());
                                    case -928612193:
                                        if (location.equals(ExposedFunctionLocation.COMPLETED)) {
                                            Object first = ArraysKt.first(invocation.getParameters());
                                            String str = first instanceof String ? (String) first : null;
                                            cancelTimeout = new ShowEvent.Completed(Intrinsics.areEqual(str, "COMPLETED") ? ShowStatus.COMPLETED : Intrinsics.areEqual(str, "SKIPPED") ? ShowStatus.SKIPPED : ShowStatus.ERROR, null, null, 6, null);
                                            anonymousClass1.L$0 = flowCollector;
                                            anonymousClass1.L$1 = cancelTimeout;
                                            anonymousClass1.label = 1;
                                            if (Invocation.handle$default(invocation, null, anonymousClass1, 1, null) != coroutine_suspended) {
                                            }
                                            return coroutine_suspended;
                                        }
                                        throw new IllegalStateException("Unexpected location: " + invocation.getLocation());
                                    case -707523043:
                                        if (location.equals(ExposedFunctionLocation.LEFT_APPLICATION)) {
                                            cancelTimeout = ShowEvent.LeftApplication.INSTANCE;
                                            anonymousClass1.L$0 = flowCollector;
                                            anonymousClass1.L$1 = cancelTimeout;
                                            anonymousClass1.label = 1;
                                            if (Invocation.handle$default(invocation, null, anonymousClass1, 1, null) != coroutine_suspended) {
                                            }
                                            return coroutine_suspended;
                                        }
                                        throw new IllegalStateException("Unexpected location: " + invocation.getLocation());
                                    case -497639557:
                                        if (location.equals(ExposedFunctionLocation.CLICKED)) {
                                            cancelTimeout = ShowEvent.Clicked.INSTANCE;
                                            anonymousClass1.L$0 = flowCollector;
                                            anonymousClass1.L$1 = cancelTimeout;
                                            anonymousClass1.label = 1;
                                            if (Invocation.handle$default(invocation, null, anonymousClass1, 1, null) != coroutine_suspended) {
                                            }
                                            return coroutine_suspended;
                                        }
                                        throw new IllegalStateException("Unexpected location: " + invocation.getLocation());
                                    case 1039618005:
                                        if (location.equals(ExposedFunctionLocation.STARTED)) {
                                            cancelTimeout = ShowEvent.Started.INSTANCE;
                                            anonymousClass1.L$0 = flowCollector;
                                            anonymousClass1.L$1 = cancelTimeout;
                                            anonymousClass1.label = 1;
                                            if (Invocation.handle$default(invocation, null, anonymousClass1, 1, null) != coroutine_suspended) {
                                            }
                                            return coroutine_suspended;
                                        }
                                        throw new IllegalStateException("Unexpected location: " + invocation.getLocation());
                                    case 1306610281:
                                        if (location.equals(ExposedFunctionLocation.FAILED)) {
                                            Object first2 = ArraysKt.first(invocation.getParameters());
                                            Intrinsics.checkNotNull(first2, "null cannot be cast to non-null type org.json.JSONObject");
                                            JSONObject jSONObject = (JSONObject) first2;
                                            int optInt = jSONObject.optInt("code");
                                            String errorMessage = jSONObject.optString(PglCryptUtils.KEY_MESSAGE);
                                            Intrinsics.checkNotNullExpressionValue(errorMessage, "errorMessage");
                                            cancelTimeout = new ShowEvent.Error(errorMessage, optInt, "adviewer");
                                            anonymousClass1.L$0 = flowCollector;
                                            anonymousClass1.L$1 = cancelTimeout;
                                            anonymousClass1.label = 1;
                                            if (Invocation.handle$default(invocation, null, anonymousClass1, 1, null) != coroutine_suspended) {
                                            }
                                            return coroutine_suspended;
                                        }
                                        throw new IllegalStateException("Unexpected location: " + invocation.getLocation());
                                    default:
                                        throw new IllegalStateException("Unexpected location: " + invocation.getLocation());
                                }
                            }
                            if (i != 1) {
                                if (i != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                                return Unit.INSTANCE;
                            }
                            showEvent = (ShowEvent) anonymousClass1.L$1;
                            flowCollector = (FlowCollector) anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.label = 2;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.label = 2;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super ShowEvent> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, MutableStateFlow, new WebViewAdPlayer$onShowEvent$3(null));
        final SharedFlow<Invocation> onInvocation4 = bridge.getOnInvocation();
        final Flow<Invocation> flow4 = new Flow<Invocation>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4$2", f = "WebViewAdPlayer.kt", i = {}, l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {}, s = {})
                /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    String[] strArr;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                strArr = WebViewAdPlayerKt.LOAD_EVENTS;
                                if (ArraysKt.contains(strArr, ((Invocation) obj).getLocation())) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Invocation> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        this.onLoadEvent = FlowKt.take(FlowKt.shareIn(new Flow<LoadEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4$2", f = "WebViewAdPlayer.kt", i = {0}, l = {224, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {"it"}, s = {"L$1"})
                /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code restructure failed: missing block: B:21:0x009c, code lost:
                
                    if (r2.emit(r4, r0) != r1) goto L26;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:22:0x009e, code lost:
                
                    return r1;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
                
                    if (com.unity3d.ads.adplayer.Invocation.handle$default(r8, null, r0, 1, null) == r1) goto L25;
                 */
                /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
                /* JADX WARN: Removed duplicated region for block: B:23:0x008d  */
                /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    FlowCollector flowCollector;
                    Invocation invocation;
                    LoadEvent loadEvent;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                flowCollector = this.$this_unsafeFlow;
                                invocation = (Invocation) obj;
                                anonymousClass1.L$0 = flowCollector;
                                anonymousClass1.L$1 = invocation;
                                anonymousClass1.label = 1;
                            } else {
                                if (i != 1) {
                                    if (i != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj2);
                                    return Unit.INSTANCE;
                                }
                                invocation = (Invocation) anonymousClass1.L$1;
                                flowCollector = (FlowCollector) anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            if (Intrinsics.areEqual(invocation.getLocation(), ExposedFunctionLocation.LOAD_ERROR)) {
                                loadEvent = LoadEvent.Completed.INSTANCE;
                            } else {
                                Object first = ArraysKt.first(invocation.getParameters());
                                Intrinsics.checkNotNull(first, "null cannot be cast to non-null type org.json.JSONObject");
                                JSONObject jSONObject = (JSONObject) first;
                                int optInt = jSONObject.optInt("code");
                                String errorMessage = jSONObject.optString(PglCryptUtils.KEY_MESSAGE);
                                Intrinsics.checkNotNullExpressionValue(errorMessage, "errorMessage");
                                loadEvent = new LoadEvent.Error(errorMessage, optInt);
                            }
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.label = 2;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    if (Intrinsics.areEqual(invocation.getLocation(), ExposedFunctionLocation.LOAD_ERROR)) {
                    }
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.label = 2;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super LoadEvent> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, getScope(), SharingStarted.INSTANCE.getEagerly(), 1), 1);
        final SharedFlow<Invocation> onInvocation5 = bridge.getOnInvocation();
        final Flow<Invocation> flow5 = new Flow<Invocation>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5$2", f = "WebViewAdPlayer.kt", i = {}, l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {}, s = {})
                /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                if (Intrinsics.areEqual(((Invocation) obj).getLocation(), ExposedFunctionLocation.BROADCAST_EVENT)) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Invocation> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        Flow<String> flow6 = new Flow<String>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5$2", f = "WebViewAdPlayer.kt", i = {0}, l = {224, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {"it"}, s = {"L$1"})
                /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
                
                    if (r2.emit(r7, r0) != r1) goto L22;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:19:0x0071, code lost:
                
                    return r1;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
                
                    if (com.unity3d.ads.adplayer.Invocation.handle$default(r7, null, r0, 1, null) == r1) goto L21;
                 */
                /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    FlowCollector flowCollector;
                    Invocation invocation;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                flowCollector = this.$this_unsafeFlow;
                                invocation = (Invocation) obj;
                                anonymousClass1.L$0 = flowCollector;
                                anonymousClass1.L$1 = invocation;
                                anonymousClass1.label = 1;
                            } else {
                                if (i != 1) {
                                    if (i != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj2);
                                    return Unit.INSTANCE;
                                }
                                invocation = (Invocation) anonymousClass1.L$1;
                                flowCollector = (FlowCollector) anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            String obj3 = ArraysKt.first(invocation.getParameters()).toString();
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.label = 2;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    String obj32 = ArraysKt.first(invocation.getParameters()).toString();
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.label = 2;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super String> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        this.onBroadcastEvents = flow6;
        Storage.INSTANCE.addStorageEventCallback(function1);
        FlowKt.launchIn(FlowKt.onEach(flow6, new AnonymousClass1(AdPlayer.INSTANCE.getBroadcastEventChannel())), getScope());
        FlowKt.launchIn(FlowKt.onEach(AdPlayer.INSTANCE.getBroadcastEventChannel(), new AnonymousClass2(this)), getScope());
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object destroy(Continuation<? super Unit> continuation) {
        return AdPlayer.DefaultImpls.destroy(this, continuation);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public void show(ShowOptions showOptions) {
        AdPlayer.DefaultImpls.show(this, showOptions);
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public WebViewContainer getWebViewContainer() {
        return this.webViewContainer;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public CoroutineScope getScope() {
        return this.scope;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Flow<ScarEvent.Show> getOnScarEvent() {
        return this.onScarEvent;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Flow<OfferwallShowEvent.Show> getOnOfferwallEvent() {
        return this.onOfferwallEvent;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Flow<ShowEvent> getOnShowEvent() {
        return this.onShowEvent;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Flow<LoadEvent> getOnLoadEvent() {
        return this.onLoadEvent;
    }

    /* compiled from: WebViewAdPlayer.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<String, Continuation<? super Unit>, Object>, SuspendFunction {
        AnonymousClass1(Object obj) {
            super(2, obj, MutableSharedFlow.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return ((MutableSharedFlow) this.receiver).emit(str, continuation);
        }
    }

    /* compiled from: WebViewAdPlayer.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.unity3d.ads.adplayer.WebViewAdPlayer$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<String, Continuation<? super Unit>, Object>, SuspendFunction {
        AnonymousClass2(Object obj) {
            super(2, obj, WebViewAdPlayer.class, "onBroadcastEvent", "onBroadcastEvent(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return ((WebViewAdPlayer) this.receiver).onBroadcastEvent(str, continuation);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0188, code lost:
    
        if (r10.bridge.request(com.ironsource.C3040d4.h.K, com.ironsource.C3207n2.v, new java.lang.Object[]{r8}, r0) != r1) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.unity3d.ads.adplayer.AdPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object requestShow(Map<String, ? extends Object> map, Continuation<? super Unit> continuation) {
        WebViewAdPlayer$requestShow$1 webViewAdPlayer$requestShow$1;
        Object coroutine_suspended;
        int i;
        JSONObject jSONObject;
        String str;
        WebViewAdPlayer webViewAdPlayer;
        Map<String, ? extends Object> map2;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        Object privacyFsm;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        Map<String, ? extends Object> map3;
        WebViewAdPlayer webViewAdPlayer2;
        String str2;
        JSONObject jSONObject6;
        if (continuation instanceof WebViewAdPlayer$requestShow$1) {
            webViewAdPlayer$requestShow$1 = (WebViewAdPlayer$requestShow$1) continuation;
            if ((webViewAdPlayer$requestShow$1.label & Integer.MIN_VALUE) != 0) {
                webViewAdPlayer$requestShow$1.label -= Integer.MIN_VALUE;
                Object obj = webViewAdPlayer$requestShow$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = webViewAdPlayer$requestShow$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo = this.deviceInfoRepository.getDynamicDeviceInfo();
                    jSONObject = new JSONObject();
                    jSONObject.put("orientation", this.deviceInfoRepository.getOrientation());
                    jSONObject.put("connectionType", this.deviceInfoRepository.getConnectionTypeStr());
                    jSONObject.put("isMuted", this.deviceInfoRepository.getRingerMode() != 2);
                    jSONObject.put("volume", dynamicDeviceInfo.getAndroid().getVolume());
                    SessionRepository sessionRepository = this.sessionRepository;
                    webViewAdPlayer$requestShow$1.L$0 = this;
                    webViewAdPlayer$requestShow$1.L$1 = map;
                    webViewAdPlayer$requestShow$1.L$2 = jSONObject;
                    webViewAdPlayer$requestShow$1.L$3 = jSONObject;
                    str = "privacy";
                    webViewAdPlayer$requestShow$1.L$4 = "privacy";
                    webViewAdPlayer$requestShow$1.L$5 = jSONObject;
                    webViewAdPlayer$requestShow$1.label = 1;
                    obj = sessionRepository.getPrivacy(webViewAdPlayer$requestShow$1);
                    if (obj != coroutine_suspended) {
                        webViewAdPlayer = this;
                        map2 = map;
                        jSONObject2 = jSONObject;
                        jSONObject3 = jSONObject2;
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    jSONObject2 = (JSONObject) webViewAdPlayer$requestShow$1.L$5;
                    String str3 = (String) webViewAdPlayer$requestShow$1.L$4;
                    JSONObject jSONObject7 = (JSONObject) webViewAdPlayer$requestShow$1.L$3;
                    jSONObject3 = (JSONObject) webViewAdPlayer$requestShow$1.L$2;
                    map2 = (Map) webViewAdPlayer$requestShow$1.L$1;
                    webViewAdPlayer = (WebViewAdPlayer) webViewAdPlayer$requestShow$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str = str3;
                    jSONObject = jSONObject7;
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    jSONObject6 = (JSONObject) webViewAdPlayer$requestShow$1.L$5;
                    str2 = (String) webViewAdPlayer$requestShow$1.L$4;
                    jSONObject4 = (JSONObject) webViewAdPlayer$requestShow$1.L$3;
                    jSONObject5 = (JSONObject) webViewAdPlayer$requestShow$1.L$2;
                    map3 = (Map) webViewAdPlayer$requestShow$1.L$1;
                    webViewAdPlayer2 = (WebViewAdPlayer) webViewAdPlayer$requestShow$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    jSONObject6.put(str2, ProtobufExtensionsKt.toBase64$default((ByteString) obj, false, 1, null));
                    ByteString byteString = webViewAdPlayer2.deviceInfoRepository.getAllowedPii().getValue().toByteString();
                    Intrinsics.checkNotNullExpressionValue(byteString, "deviceInfoRepository.all…dPii.value.toByteString()");
                    jSONObject4.put("allowedPii", ProtobufExtensionsKt.toBase64$default(byteString, false, 1, null));
                    if (map3 != null) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (Map.Entry<String, ? extends Object> entry : map3.entrySet()) {
                            if (!Intrinsics.areEqual(entry.getKey(), "objectId")) {
                                linkedHashMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                        if (!linkedHashMap.isEmpty()) {
                            jSONObject4.put("showOptions", new JSONObject(linkedHashMap));
                        }
                    }
                    webViewAdPlayer$requestShow$1.L$0 = null;
                    webViewAdPlayer$requestShow$1.L$1 = null;
                    webViewAdPlayer$requestShow$1.L$2 = null;
                    webViewAdPlayer$requestShow$1.L$3 = null;
                    webViewAdPlayer$requestShow$1.L$4 = null;
                    webViewAdPlayer$requestShow$1.L$5 = null;
                    webViewAdPlayer$requestShow$1.label = 3;
                }
                jSONObject2.put(str, ProtobufExtensionsKt.toBase64$default((ByteString) obj, false, 1, null));
                SessionRepository sessionRepository2 = webViewAdPlayer.sessionRepository;
                webViewAdPlayer$requestShow$1.L$0 = webViewAdPlayer;
                webViewAdPlayer$requestShow$1.L$1 = map2;
                webViewAdPlayer$requestShow$1.L$2 = jSONObject3;
                webViewAdPlayer$requestShow$1.L$3 = jSONObject;
                webViewAdPlayer$requestShow$1.L$4 = "privacyFsm";
                webViewAdPlayer$requestShow$1.L$5 = jSONObject;
                webViewAdPlayer$requestShow$1.label = 2;
                privacyFsm = sessionRepository2.getPrivacyFsm(webViewAdPlayer$requestShow$1);
                if (privacyFsm != coroutine_suspended) {
                    jSONObject4 = jSONObject;
                    jSONObject5 = jSONObject3;
                    map3 = map2;
                    webViewAdPlayer2 = webViewAdPlayer;
                    str2 = "privacyFsm";
                    obj = privacyFsm;
                    jSONObject6 = jSONObject4;
                    jSONObject6.put(str2, ProtobufExtensionsKt.toBase64$default((ByteString) obj, false, 1, null));
                    ByteString byteString2 = webViewAdPlayer2.deviceInfoRepository.getAllowedPii().getValue().toByteString();
                    Intrinsics.checkNotNullExpressionValue(byteString2, "deviceInfoRepository.all…dPii.value.toByteString()");
                    jSONObject4.put("allowedPii", ProtobufExtensionsKt.toBase64$default(byteString2, false, 1, null));
                    if (map3 != null) {
                    }
                    webViewAdPlayer$requestShow$1.L$0 = null;
                    webViewAdPlayer$requestShow$1.L$1 = null;
                    webViewAdPlayer$requestShow$1.L$2 = null;
                    webViewAdPlayer$requestShow$1.L$3 = null;
                    webViewAdPlayer$requestShow$1.L$4 = null;
                    webViewAdPlayer$requestShow$1.L$5 = null;
                    webViewAdPlayer$requestShow$1.label = 3;
                }
                return coroutine_suspended;
            }
        }
        webViewAdPlayer$requestShow$1 = new WebViewAdPlayer$requestShow$1(this, continuation);
        Object obj2 = webViewAdPlayer$requestShow$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = webViewAdPlayer$requestShow$1.label;
        if (i != 0) {
        }
        jSONObject2.put(str, ProtobufExtensionsKt.toBase64$default((ByteString) obj2, false, 1, null));
        SessionRepository sessionRepository22 = webViewAdPlayer.sessionRepository;
        webViewAdPlayer$requestShow$1.L$0 = webViewAdPlayer;
        webViewAdPlayer$requestShow$1.L$1 = map2;
        webViewAdPlayer$requestShow$1.L$2 = jSONObject3;
        webViewAdPlayer$requestShow$1.L$3 = jSONObject;
        webViewAdPlayer$requestShow$1.L$4 = "privacyFsm";
        webViewAdPlayer$requestShow$1.L$5 = jSONObject;
        webViewAdPlayer$requestShow$1.label = 2;
        privacyFsm = sessionRepository22.getPrivacyFsm(webViewAdPlayer$requestShow$1);
        if (privacyFsm != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public void dispatchShowCompleted() {
        this.isCompletedManually.setValue(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b8, code lost:
    
        if (r4.sendEvent(r1, r2) == r3) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendEvent(Function0<? extends WebViewEvent> function0, Continuation<? super Unit> continuation) {
        WebViewAdPlayer$sendEvent$1 webViewAdPlayer$sendEvent$1;
        int i;
        Function0<? extends WebViewEvent> function02;
        WebViewAdPlayer webViewAdPlayer;
        LoadEvent loadEvent;
        if (continuation instanceof WebViewAdPlayer$sendEvent$1) {
            webViewAdPlayer$sendEvent$1 = (WebViewAdPlayer$sendEvent$1) continuation;
            if ((webViewAdPlayer$sendEvent$1.label & Integer.MIN_VALUE) != 0) {
                webViewAdPlayer$sendEvent$1.label -= Integer.MIN_VALUE;
                Object obj = webViewAdPlayer$sendEvent$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = webViewAdPlayer$sendEvent$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow<LoadEvent> onLoadEvent = getOnLoadEvent();
                    webViewAdPlayer$sendEvent$1.L$0 = this;
                    function02 = function0;
                    webViewAdPlayer$sendEvent$1.L$1 = function02;
                    webViewAdPlayer$sendEvent$1.label = 1;
                    obj = FlowKt.single(onLoadEvent, webViewAdPlayer$sendEvent$1);
                    if (obj != coroutine_suspended) {
                        webViewAdPlayer = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                function02 = (Function0) webViewAdPlayer$sendEvent$1.L$1;
                webViewAdPlayer = (WebViewAdPlayer) webViewAdPlayer$sendEvent$1.L$0;
                ResultKt.throwOnFailure(obj);
                loadEvent = (LoadEvent) obj;
                if (!(loadEvent instanceof LoadEvent.Error)) {
                    LoadEvent.Error error = (LoadEvent.Error) loadEvent;
                    SendDiagnosticEvent.DefaultImpls.invoke$default(webViewAdPlayer.sendDiagnosticEvent, "bridge_send_event_failed", null, MapsKt.mapOf(TuplesKt.to("reason", "adviewer"), TuplesKt.to("reason_debug", error.getMessage()), TuplesKt.to("reason_code", String.valueOf(error.getErrorCode()))), null, null, null, 58, null);
                    return Unit.INSTANCE;
                }
                WebViewEvent invoke = function02.invoke();
                WebViewBridge webViewBridge = webViewAdPlayer.bridge;
                webViewAdPlayer$sendEvent$1.L$0 = null;
                webViewAdPlayer$sendEvent$1.L$1 = null;
                webViewAdPlayer$sendEvent$1.label = 2;
            }
        }
        webViewAdPlayer$sendEvent$1 = new WebViewAdPlayer$sendEvent$1(this, continuation);
        Object obj2 = webViewAdPlayer$sendEvent$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = webViewAdPlayer$sendEvent$1.label;
        if (i != 0) {
        }
        loadEvent = (LoadEvent) obj2;
        if (!(loadEvent instanceof LoadEvent.Error)) {
        }
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendScarBannerEvent(final BannerBridge.BannerEvent bannerEvent, Continuation<? super Unit> continuation) {
        Object sendEvent = sendEvent(new Function0<WebViewEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$sendScarBannerEvent$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebViewEvent invoke() {
                return new OnScarBannerEvent(BannerBridge.BannerEvent.this);
            }
        }, continuation);
        return sendEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendEvent : Unit.INSTANCE;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendGmaEvent(final GMAEvent gMAEvent, Continuation<? super Unit> continuation) {
        Object sendEvent = sendEvent(new Function0<WebViewEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$sendGmaEvent$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebViewEvent invoke() {
                return new OnGmaEvent(GMAEvent.this);
            }
        }, continuation);
        return sendEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendEvent : Unit.INSTANCE;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendOfferwallEvent(final OfferwallEvent offerwallEvent, Continuation<? super Unit> continuation) {
        Object sendEvent = sendEvent(new Function0<WebViewEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$sendOfferwallEvent$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebViewEvent invoke() {
                return new OnOfferwallEvent(OfferwallEvent.this);
            }
        }, continuation);
        return sendEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendEvent : Unit.INSTANCE;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendMuteChange(final boolean z, Continuation<? super Unit> continuation) {
        Object sendEvent = sendEvent(new Function0<WebViewEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$sendMuteChange$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebViewEvent invoke() {
                return new OnMuteChangeEvent(z);
            }
        }, continuation);
        return sendEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendEvent : Unit.INSTANCE;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendVisibilityChange(final boolean z, Continuation<? super Unit> continuation) {
        Object sendEvent = sendEvent(new Function0<WebViewEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$sendVisibilityChange$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebViewEvent invoke() {
                return new OnVisibilityChangeEvent(z);
            }
        }, continuation);
        return sendEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendEvent : Unit.INSTANCE;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendFocusChange(final boolean z, Continuation<? super Unit> continuation) {
        Object sendEvent = sendEvent(new Function0<WebViewEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$sendFocusChange$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebViewEvent invoke() {
                return new OnFocusChangeEvent(z);
            }
        }, continuation);
        return sendEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendEvent : Unit.INSTANCE;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendActivityDestroyed(Continuation<? super Unit> continuation) {
        Object sendEvent = sendEvent(new Function0<WebViewEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$sendActivityDestroyed$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebViewEvent invoke() {
                return new OnActivityDestroyedEvent();
            }
        }, continuation);
        return sendEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendEvent : Unit.INSTANCE;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendVolumeChange(final double d, Continuation<? super Unit> continuation) {
        Object sendEvent = sendEvent(new Function0<WebViewEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$sendVolumeChange$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebViewEvent invoke() {
                return new OnVolumeChangeEvent(d);
            }
        }, continuation);
        return sendEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendEvent : Unit.INSTANCE;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendUserConsentChange(final byte[] bArr, Continuation<? super Unit> continuation) {
        Object sendEvent = sendEvent(new Function0<WebViewEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$sendUserConsentChange$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebViewEvent invoke() {
                String encodeToString = Base64.encodeToString(bArr, 2);
                Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(value, Base64.NO_WRAP)");
                return new OnUserConsentChangeEvent(encodeToString);
            }
        }, continuation);
        return sendEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendEvent : Unit.INSTANCE;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object sendPrivacyFsmChange(final byte[] bArr, Continuation<? super Unit> continuation) {
        Object sendEvent = sendEvent(new Function0<WebViewEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$sendPrivacyFsmChange$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebViewEvent invoke() {
                String encodeToString = Base64.encodeToString(bArr, 2);
                Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(value, Base64.NO_WRAP)");
                return new OnPrivacyFsmChangeEvent(encodeToString);
            }
        }, continuation);
        return sendEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendEvent : Unit.INSTANCE;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object onBroadcastEvent(final String str, Continuation<? super Unit> continuation) {
        Object sendEvent = sendEvent(new Function0<WebViewEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$onBroadcastEvent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebViewEvent invoke() {
                JSONObject jSONObject = new JSONObject(str);
                String eventType = jSONObject.getString("eventType");
                String optString = jSONObject.optString("data");
                Intrinsics.checkNotNullExpressionValue(eventType, "eventType");
                return new OnBroadcastEvent(eventType, optString);
            }
        }, continuation);
        return sendEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendEvent : Unit.INSTANCE;
    }

    @Override // com.unity3d.ads.adplayer.AdPlayer
    public Object onAllowedPiiChange(final byte[] bArr, Continuation<? super Unit> continuation) {
        Object sendEvent = sendEvent(new Function0<WebViewEvent>() { // from class: com.unity3d.ads.adplayer.WebViewAdPlayer$onAllowedPiiChange$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebViewEvent invoke() {
                String encodeToString = Base64.encodeToString(bArr, 2);
                Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(value, Base64.NO_WRAP)");
                return new OnAllowedPiiChangeEvent(encodeToString);
            }
        }, continuation);
        return sendEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendEvent : Unit.INSTANCE;
    }
}
