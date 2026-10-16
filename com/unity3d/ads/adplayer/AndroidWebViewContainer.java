package com.unity3d.ads.adplayer;

import android.content.Context;
import android.view.InputEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.unity3d.ads.adplayer.model.ErrorReason;
import com.unity3d.ads.adplayer.model.WebViewClientError;
import com.unity3d.ads.core.domain.SendWebViewClientErrorDiagnostics;
import com.vungle.ads.internal.protos.Sdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AndroidWebViewContainer.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ!\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u001fH\u0002J\u0011\u0010&\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020#H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0019\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020#H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0011\u0010-\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010'R\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/unity3d/ads/adplayer/AndroidWebViewContainer;", "Lcom/unity3d/ads/adplayer/WebViewContainer;", "webView", "Landroid/webkit/WebView;", "webViewClient", "Lcom/unity3d/ads/adplayer/AndroidWebViewClient;", "sendWebViewClientErrorDiagnostics", "Lcom/unity3d/ads/core/domain/SendWebViewClientErrorDiagnostics;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "defaultDispatcher", "adPlayerScope", "Lkotlinx/coroutines/CoroutineScope;", "context", "Landroid/content/Context;", "(Landroid/webkit/WebView;Lcom/unity3d/ads/adplayer/AndroidWebViewClient;Lcom/unity3d/ads/core/domain/SendWebViewClientErrorDiagnostics;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineScope;Landroid/content/Context;)V", "_lastInputEvent", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroid/view/InputEvent;", "get_lastInputEvent", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "lastInputEvent", "Lkotlinx/coroutines/flow/StateFlow;", "getLastInputEvent", "()Lkotlinx/coroutines/flow/StateFlow;", "scope", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getWebView", "()Landroid/webkit/WebView;", "addJavascriptInterface", "", "webViewBridgeInterface", "Lcom/unity3d/ads/adplayer/WebViewBridge;", "name", "", "(Lcom/unity3d/ads/adplayer/WebViewBridge;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applySafeAreaInsets", "destroy", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "evaluateJavascript", "script", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadUrl", "url", "onRenderProcessGone", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AndroidWebViewContainer implements WebViewContainer {
    private final MutableStateFlow<InputEvent> _lastInputEvent;
    private final Context context;
    private final StateFlow<InputEvent> lastInputEvent;
    private final CoroutineScope scope;
    private final SendWebViewClientErrorDiagnostics sendWebViewClientErrorDiagnostics;
    private final WebView webView;
    private final AndroidWebViewClient webViewClient;

    private static final int applySafeAreaInsets$lambda$3$toPx(int i, float f) {
        return (int) (i / f);
    }

    public AndroidWebViewContainer(WebView webView, AndroidWebViewClient webViewClient, SendWebViewClientErrorDiagnostics sendWebViewClientErrorDiagnostics, CoroutineDispatcher mainDispatcher, CoroutineDispatcher defaultDispatcher, CoroutineScope adPlayerScope, Context context) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(webViewClient, "webViewClient");
        Intrinsics.checkNotNullParameter(sendWebViewClientErrorDiagnostics, "sendWebViewClientErrorDiagnostics");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(defaultDispatcher, "defaultDispatcher");
        Intrinsics.checkNotNullParameter(adPlayerScope, "adPlayerScope");
        Intrinsics.checkNotNullParameter(context, "context");
        this.webView = webView;
        this.webViewClient = webViewClient;
        this.sendWebViewClientErrorDiagnostics = sendWebViewClientErrorDiagnostics;
        this.context = context;
        CoroutineScope plus = CoroutineScopeKt.plus(CoroutineScopeKt.plus(adPlayerScope, mainDispatcher), new CoroutineName("AndroidWebViewContainer"));
        this.scope = plus;
        MutableStateFlow<InputEvent> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._lastInputEvent = MutableStateFlow;
        this.lastInputEvent = FlowKt.asStateFlow(MutableStateFlow);
        final StateFlow<Boolean> isRenderProcessGone = webViewClient.isRenderProcessGone();
        FlowKt.launchIn(FlowKt.onEach(new Flow<Boolean>() { // from class: com.unity3d.ads.adplayer.AndroidWebViewContainer$special$$inlined$filter$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.unity3d.ads.adplayer.AndroidWebViewContainer$special$$inlined$filter$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.unity3d.ads.adplayer.AndroidWebViewContainer$special$$inlined$filter$1$2", f = "AndroidWebViewContainer.kt", i = {}, l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {}, s = {})
                /* renamed from: com.unity3d.ads.adplayer.AndroidWebViewContainer$special$$inlined$filter$1$2$1, reason: invalid class name */
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
                                if (((Boolean) obj).booleanValue()) {
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
            public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, new AnonymousClass2(null)), CoroutineScopeKt.plus(plus, defaultDispatcher));
        webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.unity3d.ads.adplayer.AndroidWebViewContainer$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean _init_$lambda$1;
                _init_$lambda$1 = AndroidWebViewContainer._init_$lambda$1(AndroidWebViewContainer.this, view, motionEvent);
                return _init_$lambda$1;
            }
        });
        applySafeAreaInsets();
    }

    public final WebView getWebView() {
        return this.webView;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final MutableStateFlow<InputEvent> get_lastInputEvent() {
        return this._lastInputEvent;
    }

    @Override // com.unity3d.ads.adplayer.WebViewContainer
    public StateFlow<InputEvent> getLastInputEvent() {
        return this.lastInputEvent;
    }

    /* compiled from: AndroidWebViewContainer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.adplayer.AndroidWebViewContainer$2", f = "AndroidWebViewContainer.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.unity3d.ads.adplayer.AndroidWebViewContainer$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AndroidWebViewContainer.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return invoke(bool.booleanValue(), continuation);
        }

        public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AndroidWebViewContainer.this.onRenderProcessGone(this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(AndroidWebViewContainer this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 1 && actionMasked != 5 && actionMasked != 6) {
            return false;
        }
        this$0._lastInputEvent.setValue(motionEvent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onRenderProcessGone(Continuation<? super Unit> continuation) {
        AndroidWebViewContainer$onRenderProcessGone$1 androidWebViewContainer$onRenderProcessGone$1;
        int i;
        AndroidWebViewContainer androidWebViewContainer;
        if (continuation instanceof AndroidWebViewContainer$onRenderProcessGone$1) {
            androidWebViewContainer$onRenderProcessGone$1 = (AndroidWebViewContainer$onRenderProcessGone$1) continuation;
            if ((androidWebViewContainer$onRenderProcessGone$1.label & Integer.MIN_VALUE) != 0) {
                androidWebViewContainer$onRenderProcessGone$1.label -= Integer.MIN_VALUE;
                Object obj = androidWebViewContainer$onRenderProcessGone$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidWebViewContainer$onRenderProcessGone$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    androidWebViewContainer$onRenderProcessGone$1.L$0 = this;
                    androidWebViewContainer$onRenderProcessGone$1.label = 1;
                    if (destroy(androidWebViewContainer$onRenderProcessGone$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    androidWebViewContainer = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    androidWebViewContainer = (AndroidWebViewContainer) androidWebViewContainer$onRenderProcessGone$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                androidWebViewContainer.sendWebViewClientErrorDiagnostics.invoke(CollectionsKt.listOf(new WebViewClientError("Render process gone", ErrorReason.REASON_WEBVIEW_RENDER_PROCESS_GONE, null, 4, null)));
                return Unit.INSTANCE;
            }
        }
        androidWebViewContainer$onRenderProcessGone$1 = new AndroidWebViewContainer$onRenderProcessGone$1(this, continuation);
        Object obj2 = androidWebViewContainer$onRenderProcessGone$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidWebViewContainer$onRenderProcessGone$1.label;
        if (i != 0) {
        }
        androidWebViewContainer.sendWebViewClientErrorDiagnostics.invoke(CollectionsKt.listOf(new WebViewClientError("Render process gone", ErrorReason.REASON_WEBVIEW_RENDER_PROCESS_GONE, null, 4, null)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
    
        if (r9 != r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.unity3d.ads.adplayer.WebViewContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadUrl(String str, Continuation<? super Unit> continuation) {
        AndroidWebViewContainer$loadUrl$1 androidWebViewContainer$loadUrl$1;
        int i;
        AndroidWebViewContainer androidWebViewContainer;
        AndroidWebViewContainer androidWebViewContainer2;
        List<WebViewClientError> list;
        if (continuation instanceof AndroidWebViewContainer$loadUrl$1) {
            androidWebViewContainer$loadUrl$1 = (AndroidWebViewContainer$loadUrl$1) continuation;
            if ((androidWebViewContainer$loadUrl$1.label & Integer.MIN_VALUE) != 0) {
                androidWebViewContainer$loadUrl$1.label -= Integer.MIN_VALUE;
                Object obj = androidWebViewContainer$loadUrl$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidWebViewContainer$loadUrl$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext coroutineContext = this.scope.getCoroutineContext();
                    AndroidWebViewContainer$loadUrl$2 androidWebViewContainer$loadUrl$2 = new AndroidWebViewContainer$loadUrl$2(this, str, null);
                    androidWebViewContainer$loadUrl$1.L$0 = this;
                    androidWebViewContainer$loadUrl$1.label = 1;
                    if (BuildersKt.withContext(coroutineContext, androidWebViewContainer$loadUrl$2, androidWebViewContainer$loadUrl$1) != coroutine_suspended) {
                        androidWebViewContainer = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        list = (List) androidWebViewContainer$loadUrl$1.L$1;
                        androidWebViewContainer2 = (AndroidWebViewContainer) androidWebViewContainer$loadUrl$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        androidWebViewContainer2.sendWebViewClientErrorDiagnostics.invoke(list);
                        throw new LoadWebViewError(list);
                    }
                    androidWebViewContainer = (AndroidWebViewContainer) androidWebViewContainer$loadUrl$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    List<WebViewClientError> list2 = (List) obj;
                    if (!list2.isEmpty()) {
                        androidWebViewContainer$loadUrl$1.L$0 = androidWebViewContainer;
                        androidWebViewContainer$loadUrl$1.L$1 = list2;
                        androidWebViewContainer$loadUrl$1.label = 3;
                        if (androidWebViewContainer.destroy(androidWebViewContainer$loadUrl$1) != coroutine_suspended) {
                            androidWebViewContainer2 = androidWebViewContainer;
                            list = list2;
                            androidWebViewContainer2.sendWebViewClientErrorDiagnostics.invoke(list);
                            throw new LoadWebViewError(list);
                        }
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                androidWebViewContainer = (AndroidWebViewContainer) androidWebViewContainer$loadUrl$1.L$0;
                ResultKt.throwOnFailure(obj);
                Deferred<List<WebViewClientError>> onLoadFinished = androidWebViewContainer.webViewClient.getOnLoadFinished();
                androidWebViewContainer$loadUrl$1.L$0 = androidWebViewContainer;
                androidWebViewContainer$loadUrl$1.label = 2;
                obj = onLoadFinished.await(androidWebViewContainer$loadUrl$1);
            }
        }
        androidWebViewContainer$loadUrl$1 = new AndroidWebViewContainer$loadUrl$1(this, continuation);
        Object obj2 = androidWebViewContainer$loadUrl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidWebViewContainer$loadUrl$1.label;
        if (i != 0) {
        }
        Deferred<List<WebViewClientError>> onLoadFinished2 = androidWebViewContainer.webViewClient.getOnLoadFinished();
        androidWebViewContainer$loadUrl$1.L$0 = androidWebViewContainer;
        androidWebViewContainer$loadUrl$1.label = 2;
        obj2 = onLoadFinished2.await(androidWebViewContainer$loadUrl$1);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|23|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @Override // com.unity3d.ads.adplayer.WebViewContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object evaluateJavascript(String str, Continuation<? super Unit> continuation) {
        AndroidWebViewContainer$evaluateJavascript$1 androidWebViewContainer$evaluateJavascript$1;
        int i;
        if (continuation instanceof AndroidWebViewContainer$evaluateJavascript$1) {
            androidWebViewContainer$evaluateJavascript$1 = (AndroidWebViewContainer$evaluateJavascript$1) continuation;
            if ((androidWebViewContainer$evaluateJavascript$1.label & Integer.MIN_VALUE) != 0) {
                androidWebViewContainer$evaluateJavascript$1.label -= Integer.MIN_VALUE;
                Object obj = androidWebViewContainer$evaluateJavascript$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidWebViewContainer$evaluateJavascript$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext coroutineContext = this.scope.getCoroutineContext();
                    AndroidWebViewContainer$evaluateJavascript$2 androidWebViewContainer$evaluateJavascript$2 = new AndroidWebViewContainer$evaluateJavascript$2(this, str, null);
                    androidWebViewContainer$evaluateJavascript$1.label = 1;
                    if (BuildersKt.withContext(coroutineContext, androidWebViewContainer$evaluateJavascript$2, androidWebViewContainer$evaluateJavascript$1) == coroutine_suspended) {
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
        androidWebViewContainer$evaluateJavascript$1 = new AndroidWebViewContainer$evaluateJavascript$1(this, continuation);
        Object obj2 = androidWebViewContainer$evaluateJavascript$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidWebViewContainer$evaluateJavascript$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|23|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @Override // com.unity3d.ads.adplayer.WebViewContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object addJavascriptInterface(WebViewBridge webViewBridge, String str, Continuation<? super Unit> continuation) {
        AndroidWebViewContainer$addJavascriptInterface$1 androidWebViewContainer$addJavascriptInterface$1;
        int i;
        if (continuation instanceof AndroidWebViewContainer$addJavascriptInterface$1) {
            androidWebViewContainer$addJavascriptInterface$1 = (AndroidWebViewContainer$addJavascriptInterface$1) continuation;
            if ((androidWebViewContainer$addJavascriptInterface$1.label & Integer.MIN_VALUE) != 0) {
                androidWebViewContainer$addJavascriptInterface$1.label -= Integer.MIN_VALUE;
                Object obj = androidWebViewContainer$addJavascriptInterface$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidWebViewContainer$addJavascriptInterface$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext coroutineContext = this.scope.getCoroutineContext();
                    AndroidWebViewContainer$addJavascriptInterface$2 androidWebViewContainer$addJavascriptInterface$2 = new AndroidWebViewContainer$addJavascriptInterface$2(this, str, webViewBridge, null);
                    androidWebViewContainer$addJavascriptInterface$1.label = 1;
                    if (BuildersKt.withContext(coroutineContext, androidWebViewContainer$addJavascriptInterface$2, androidWebViewContainer$addJavascriptInterface$1) == coroutine_suspended) {
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
        androidWebViewContainer$addJavascriptInterface$1 = new AndroidWebViewContainer$addJavascriptInterface$1(this, continuation);
        Object obj2 = androidWebViewContainer$addJavascriptInterface$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidWebViewContainer$addJavascriptInterface$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.unity3d.ads.adplayer.WebViewContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object destroy(Continuation<? super Unit> continuation) {
        AndroidWebViewContainer$destroy$1 androidWebViewContainer$destroy$1;
        int i;
        AndroidWebViewContainer androidWebViewContainer;
        if (continuation instanceof AndroidWebViewContainer$destroy$1) {
            androidWebViewContainer$destroy$1 = (AndroidWebViewContainer$destroy$1) continuation;
            if ((androidWebViewContainer$destroy$1.label & Integer.MIN_VALUE) != 0) {
                androidWebViewContainer$destroy$1.label -= Integer.MIN_VALUE;
                Object obj = androidWebViewContainer$destroy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidWebViewContainer$destroy$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext plus = this.scope.getCoroutineContext().plus(NonCancellable.INSTANCE);
                    AndroidWebViewContainer$destroy$2 androidWebViewContainer$destroy$2 = new AndroidWebViewContainer$destroy$2(this, null);
                    androidWebViewContainer$destroy$1.L$0 = this;
                    androidWebViewContainer$destroy$1.label = 1;
                    if (BuildersKt.withContext(plus, androidWebViewContainer$destroy$2, androidWebViewContainer$destroy$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    androidWebViewContainer = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    androidWebViewContainer = (AndroidWebViewContainer) androidWebViewContainer$destroy$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                CoroutineScopeKt.cancel$default(androidWebViewContainer.scope, null, 1, null);
                return Unit.INSTANCE;
            }
        }
        androidWebViewContainer$destroy$1 = new AndroidWebViewContainer$destroy$1(this, continuation);
        Object obj2 = androidWebViewContainer$destroy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidWebViewContainer$destroy$1.label;
        if (i != 0) {
        }
        CoroutineScopeKt.cancel$default(androidWebViewContainer.scope, null, 1, null);
        return Unit.INSTANCE;
    }

    private final void applySafeAreaInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(this.webView, new OnApplyWindowInsetsListener() { // from class: com.unity3d.ads.adplayer.AndroidWebViewContainer$$ExternalSyntheticLambda1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat applySafeAreaInsets$lambda$3;
                applySafeAreaInsets$lambda$3 = AndroidWebViewContainer.applySafeAreaInsets$lambda$3(AndroidWebViewContainer.this, view, windowInsetsCompat);
                return applySafeAreaInsets$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat applySafeAreaInsets$lambda$3(AndroidWebViewContainer this$0, View v, WindowInsetsCompat insets) {
        Object m10241constructorimpl;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "insets.getInsets(WindowI…Compat.Type.systemBars())");
        Insets insets3 = insets.getInsets(WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets3, "insets.getInsets(WindowI…pat.Type.displayCutout())");
        try {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(Float.valueOf(this$0.context.getResources().getDisplayMetrics().density));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Float valueOf = Float.valueOf(1.0f);
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = valueOf;
        }
        float floatValue = ((Number) m10241constructorimpl).floatValue();
        int applySafeAreaInsets$lambda$3$toPx = applySafeAreaInsets$lambda$3$toPx(Math.max(insets2.left, insets3.left), floatValue);
        int applySafeAreaInsets$lambda$3$toPx2 = applySafeAreaInsets$lambda$3$toPx(Math.max(insets2.top, insets3.top), floatValue);
        BuildersKt__Builders_commonKt.launch$default(this$0.scope, null, null, new AndroidWebViewContainer$applySafeAreaInsets$1$1(this$0, StringsKt.trimIndent("\n                (function() {\n                    const root = document.documentElement;\n                    root.style.setProperty('--safe-area-inset-left', '" + applySafeAreaInsets$lambda$3$toPx + "px');\n                    root.style.setProperty('--safe-area-inset-right', '" + applySafeAreaInsets$lambda$3$toPx(Math.max(insets2.right, insets3.right), floatValue) + "px');\n                    root.style.setProperty('--safe-area-inset-top', '" + applySafeAreaInsets$lambda$3$toPx2 + "px');\n                    root.style.setProperty('--safe-area-inset-bottom', '" + applySafeAreaInsets$lambda$3$toPx(Math.max(insets2.bottom, insets3.bottom), floatValue) + "px');\n                })();\n            "), null), 3, null);
        return insets;
    }
}
