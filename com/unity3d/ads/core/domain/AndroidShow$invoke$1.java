package com.unity3d.ads.core.domain;

import android.app.Activity;
import com.google.protobuf.ByteString;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.adplayer.AndroidShowOptions;
import com.unity3d.ads.core.configuration.GameServerIdReader;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.AdObjectState;
import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.JSONObjectExtensionsKt;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.json.JSONObject;

/* compiled from: AndroidShow.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/unity3d/ads/core/data/model/ShowEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidShow$invoke$1", f = "AndroidShow.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidShow$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super ShowEvent>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ AdObject $adObject;
    final /* synthetic */ UnityAdsShowOptions $showOptions;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidShow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidShow$invoke$1(AdObject adObject, AndroidShow androidShow, Activity activity, UnityAdsShowOptions unityAdsShowOptions, Continuation<? super AndroidShow$invoke$1> continuation) {
        super(2, continuation);
        this.$adObject = adObject;
        this.this$0 = androidShow;
        this.$activity = activity;
        this.$showOptions = unityAdsShowOptions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidShow$invoke$1 androidShow$invoke$1 = new AndroidShow$invoke$1(this.$adObject, this.this$0, this.$activity, this.$showOptions, continuation);
        androidShow$invoke$1.L$0 = obj;
        return androidShow$invoke$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ShowEvent> flowCollector, Continuation<? super Unit> continuation) {
        return ((AndroidShow$invoke$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AdRepository adRepository;
        SendDiagnosticEvent sendDiagnosticEvent;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final FlowCollector flowCollector = (FlowCollector) this.L$0;
            if (this.$adObject.getOpportunityId().isEmpty()) {
                throw new IllegalArgumentException("No opportunityId".toString());
            }
            ByteString opportunityId = this.$adObject.getOpportunityId();
            adRepository = this.this$0.adRepository;
            AdObject ad = adRepository.getAd(opportunityId);
            if (ad != null) {
                sendDiagnosticEvent = this.this$0.sendDiagnosticEvent;
                SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_show_started_ad_viewer", null, null, null, this.$adObject, null, 46, null);
                AdPlayer adPlayer = ad.getAdPlayer();
                if (adPlayer == null) {
                    throw new IllegalStateException("No adPlayer associated with ad");
                }
                Flow transformWhile = FlowKt.transformWhile(FlowKt.onCompletion(FlowKt.onStart(adPlayer.getOnShowEvent(), new AnonymousClass2(ad, this.this$0, this.$adObject, this.$activity, this.$showOptions, null)), new AnonymousClass3(this.this$0, this.$adObject, opportunityId, null)), new AnonymousClass4(null));
                final AndroidShow androidShow = this.this$0;
                final AdObject adObject = this.$adObject;
                this.label = 1;
                if (transformWhile.collect(new FlowCollector() { // from class: com.unity3d.ads.core.domain.AndroidShow$invoke$1.5
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((ShowEvent) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(ShowEvent showEvent, Continuation<? super Unit> continuation) {
                        SendDiagnosticEvent sendDiagnosticEvent2;
                        sendDiagnosticEvent2 = AndroidShow.this.sendDiagnosticEvent;
                        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent2, "native_show_event_flow_collected", null, MapsKt.mapOf(TuplesKt.to("event", showEvent.getClass().getSimpleName())), null, adObject, null, 42, null);
                        Object emit = flowCollector.emit(showEvent, continuation);
                        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw new IllegalStateException("No ad associated with opportunityId");
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: AndroidShow.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/unity3d/ads/core/data/model/ShowEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidShow$invoke$1$2", f = "AndroidShow.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.unity3d.ads.core.domain.AndroidShow$invoke$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super ShowEvent>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ AdObject $ad;
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ UnityAdsShowOptions $showOptions;
        int label;
        final /* synthetic */ AndroidShow this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AdObject adObject, AndroidShow androidShow, AdObject adObject2, Activity activity, UnityAdsShowOptions unityAdsShowOptions, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$ad = adObject;
            this.this$0 = androidShow;
            this.$adObject = adObject2;
            this.$activity = activity;
            this.$showOptions = unityAdsShowOptions;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$ad, this.this$0, this.$adObject, this.$activity, this.$showOptions, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ShowEvent> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
        
            if (r1 == null) goto L11;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            GameServerIdReader gameServerIdReader;
            SendDiagnosticEvent sendDiagnosticEvent;
            JSONObject data;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AdObject adObject = this.$ad;
            gameServerIdReader = this.this$0.gameServerIdReader;
            GameServerIdReader gameServerIdReader2 = gameServerIdReader;
            Object obj2 = gameServerIdReader2.getJsonStorage().get(gameServerIdReader2.getKey());
            Map<String, Object> map = null;
            if (obj2 != null) {
                Intrinsics.checkNotNullExpressionValue(obj2, "get(key)");
                if (!(obj2 instanceof String)) {
                    obj2 = null;
                }
            }
            obj2 = null;
            Object obj3 = gameServerIdReader2.getJsonStorage().get(gameServerIdReader2.getKey());
            if (obj3 != null) {
                Intrinsics.checkNotNullExpressionValue(obj3, "get(key)");
                gameServerIdReader2.getJsonStorage().delete(gameServerIdReader2.getKey());
            }
            adObject.setPlayerServerId((String) obj2);
            this.$adObject.getState().setValue(AdObjectState.SHOWING);
            sendDiagnosticEvent = this.this$0.sendDiagnosticEvent;
            SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_show_event_flow_started", null, null, null, this.$adObject, null, 46, null);
            AdPlayer adPlayer = this.$ad.getAdPlayer();
            WeakReference weakReference = new WeakReference(this.$activity);
            UnityAdsShowOptions unityAdsShowOptions = this.$showOptions;
            if (unityAdsShowOptions != null && (data = unityAdsShowOptions.getData()) != null) {
                map = JSONObjectExtensionsKt.toBuiltInMap(data);
            }
            adPlayer.show(new AndroidShowOptions(weakReference, map, this.$ad.getPlacementId(), this.$ad.isScarAd(), this.$ad.getScarQueryId(), this.$ad.getScarAdString(), this.$ad.getScarAdUnitId(), this.$ad.isOfferwallAd(), this.$ad.getOfferwallPlacementName()));
            return Unit.INSTANCE;
        }
    }

    /* compiled from: AndroidShow.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/unity3d/ads/core/data/model/ShowEvent;", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidShow$invoke$1$3", f = "AndroidShow.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.unity3d.ads.core.domain.AndroidShow$invoke$1$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super ShowEvent>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ AdObject $adObject;
        final /* synthetic */ ByteString $opportunityId;
        int label;
        final /* synthetic */ AndroidShow this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AndroidShow androidShow, AdObject adObject, ByteString byteString, Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
            this.this$0 = androidShow;
            this.$adObject = adObject;
            this.$opportunityId = byteString;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super ShowEvent> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return new AnonymousClass3(this.this$0, this.$adObject, this.$opportunityId, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SendDiagnosticEvent sendDiagnosticEvent;
            AdRepository adRepository;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                sendDiagnosticEvent = this.this$0.sendDiagnosticEvent;
                SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_show_event_flow_completed", null, null, null, this.$adObject, null, 46, null);
                this.$adObject.getState().setValue(AdObjectState.COMPLETED);
                adRepository = this.this$0.adRepository;
                adRepository.removeAd(this.$opportunityId);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: AndroidShow.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/unity3d/ads/core/data/model/ShowEvent;", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidShow$invoke$1$4", f = "AndroidShow.kt", i = {0}, l = {59}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
    /* renamed from: com.unity3d.ads.core.domain.AndroidShow$invoke$1$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function3<FlowCollector<? super ShowEvent>, ShowEvent, Continuation<? super Boolean>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super ShowEvent> flowCollector, ShowEvent showEvent, Continuation<? super Boolean> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(continuation);
            anonymousClass4.L$0 = flowCollector;
            anonymousClass4.L$1 = showEvent;
            return anonymousClass4.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ShowEvent showEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                ShowEvent showEvent2 = (ShowEvent) this.L$1;
                this.L$0 = showEvent2;
                this.label = 1;
                if (flowCollector.emit(showEvent2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                showEvent = showEvent2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                showEvent = (ShowEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return Boxing.boxBoolean(((showEvent instanceof ShowEvent.Completed) || (showEvent instanceof ShowEvent.Error)) ? false : true);
        }
    }
}
