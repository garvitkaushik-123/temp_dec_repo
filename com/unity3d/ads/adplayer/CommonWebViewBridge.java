package com.unity3d.ads.adplayer;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.ironsource.C3040d4;
import com.unity3d.ads.adplayer.model.WebViewEvent;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.JSONArrayExtensionsKt;
import com.unity3d.services.core.log.DeviceLog;
import com.vungle.ads.internal.ui.AdActivity;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: CommonWebViewBridge.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ!\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\"J \u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u0012H\u0016J;\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00122\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010-J5\u0010.\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00122\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0019\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u000202H\u0096@ø\u0001\u0000¢\u0006\u0002\u00103R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u000e\u001a&\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00130\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lcom/unity3d/ads/adplayer/CommonWebViewBridge;", "Lcom/unity3d/ads/adplayer/WebViewBridge;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "webViewContainer", "Lcom/unity3d/ads/adplayer/WebViewContainer;", "adPlayerScope", "Lkotlinx/coroutines/CoroutineScope;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/adplayer/WebViewContainer;Lkotlinx/coroutines/CoroutineScope;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;)V", "_onInvocation", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/unity3d/ads/adplayer/Invocation;", "callbacks", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CompletableDeferred;", "", "", "onInvocation", "Lkotlinx/coroutines/flow/SharedFlow;", "getOnInvocation", "()Lkotlinx/coroutines/flow/SharedFlow;", "scope", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "execute", "", "handlerType", "Lcom/unity3d/ads/adplayer/HandlerType;", "arguments", "(Lcom/unity3d/ads/adplayer/HandlerType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleCallback", "callbackId", "callbackStatus", "rawParameters", "handleInvocation", PglCryptUtils.KEY_MESSAGE, AdActivity.REQUEST_KEY_EXTRA, "className", "method", "params", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "respond", "status", "sendEvent", "event", "Lcom/unity3d/ads/adplayer/model/WebViewEvent;", "(Lcom/unity3d/ads/adplayer/model/WebViewEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CommonWebViewBridge implements WebViewBridge {
    private final MutableSharedFlow<Invocation> _onInvocation;
    private final MutableStateFlow<Set<Pair<String, CompletableDeferred<Object[]>>>> callbacks;
    private final SharedFlow<Invocation> onInvocation;
    private final CoroutineScope scope;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final WebViewContainer webViewContainer;

    public CommonWebViewBridge(CoroutineDispatcher dispatcher, WebViewContainer webViewContainer, CoroutineScope adPlayerScope, SendDiagnosticEvent sendDiagnosticEvent) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(webViewContainer, "webViewContainer");
        Intrinsics.checkNotNullParameter(adPlayerScope, "adPlayerScope");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.webViewContainer = webViewContainer;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        CoroutineScope plus = CoroutineScopeKt.plus(CoroutineScopeKt.plus(adPlayerScope, dispatcher), new CoroutineName("CommonWebViewBridge"));
        this.scope = plus;
        this.callbacks = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        MutableSharedFlow<Invocation> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 64, null, 5, null);
        this._onInvocation = MutableSharedFlow$default;
        this.onInvocation = FlowKt.asSharedFlow(MutableSharedFlow$default);
        BuildersKt__Builders_commonKt.launch$default(plus, null, null, new AnonymousClass1(null), 3, null);
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    @Override // com.unity3d.ads.adplayer.WebViewBridge
    public SharedFlow<Invocation> getOnInvocation() {
        return this.onInvocation;
    }

    /* compiled from: CommonWebViewBridge.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.adplayer.CommonWebViewBridge$1", f = "CommonWebViewBridge.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.unity3d.ads.adplayer.CommonWebViewBridge$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CommonWebViewBridge.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CommonWebViewBridge.this.webViewContainer.addJavascriptInterface(CommonWebViewBridge.this, "webviewbridge", this) == coroutine_suspended) {
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
    public final Object execute(HandlerType handlerType, String str, Continuation<? super Unit> continuation) {
        Object evaluateJavascript = this.webViewContainer.evaluateJavascript("window.nativebridge." + handlerType.getJsPath() + '(' + str + ");", continuation);
        return evaluateJavascript == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? evaluateJavascript : Unit.INSTANCE;
    }

    @Override // com.unity3d.ads.adplayer.WebViewBridge
    public Object sendEvent(WebViewEvent webViewEvent, Continuation<? super Unit> continuation) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(webViewEvent.getCategory());
        jSONArray.put(webViewEvent.getName());
        for (Object obj : webViewEvent.getParameters()) {
            jSONArray.put(obj);
        }
        HandlerType handlerType = HandlerType.EVENT;
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "arguments.toString()");
        Object execute = execute(handlerType, jSONArray2, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.unity3d.ads.adplayer.WebViewBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object request(String str, String str2, Object[] objArr, Continuation<? super Object[]> continuation) {
        CommonWebViewBridge$request$1 commonWebViewBridge$request$1;
        int i;
        Set<Pair<String, CompletableDeferred<Object[]>>> value;
        CompletableDeferred completableDeferred;
        if (continuation instanceof CommonWebViewBridge$request$1) {
            commonWebViewBridge$request$1 = (CommonWebViewBridge$request$1) continuation;
            if ((commonWebViewBridge$request$1.label & Integer.MIN_VALUE) != 0) {
                commonWebViewBridge$request$1.label -= Integer.MIN_VALUE;
                Object obj = commonWebViewBridge$request$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = commonWebViewBridge$request$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                    String valueOf = String.valueOf(CompletableDeferred$default.hashCode());
                    MutableStateFlow<Set<Pair<String, CompletableDeferred<Object[]>>>> mutableStateFlow = this.callbacks;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, SetsKt.plus(value, TuplesKt.to(valueOf, CompletableDeferred$default))));
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str);
                    jSONArray.put(str2);
                    jSONArray.put(valueOf);
                    for (Object obj2 : objArr) {
                        jSONArray.put(obj2);
                    }
                    HandlerType handlerType = HandlerType.INVOCATION;
                    String jSONArray2 = jSONArray.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONArray2, "arguments.toString()");
                    commonWebViewBridge$request$1.L$0 = CompletableDeferred$default;
                    commonWebViewBridge$request$1.label = 1;
                    if (execute(handlerType, jSONArray2, commonWebViewBridge$request$1) != coroutine_suspended) {
                        completableDeferred = CompletableDeferred$default;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                completableDeferred = (CompletableDeferred) commonWebViewBridge$request$1.L$0;
                ResultKt.throwOnFailure(obj);
                commonWebViewBridge$request$1.L$0 = null;
                commonWebViewBridge$request$1.label = 2;
                Object await = completableDeferred.await(commonWebViewBridge$request$1);
                return await != coroutine_suspended ? coroutine_suspended : await;
            }
        }
        commonWebViewBridge$request$1 = new CommonWebViewBridge$request$1(this, continuation);
        Object obj3 = commonWebViewBridge$request$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = commonWebViewBridge$request$1.label;
        if (i != 0) {
        }
        commonWebViewBridge$request$1.L$0 = null;
        commonWebViewBridge$request$1.label = 2;
        Object await2 = completableDeferred.await(commonWebViewBridge$request$1);
        if (await2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bd, code lost:
    
        if (r21.equals("OK") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c7, code lost:
    
        r1.complete(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c4, code lost:
    
        if (r21.equals("success") == false) goto L38;
     */
    @Override // com.unity3d.ads.adplayer.WebViewBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleCallback(String callbackId, String callbackStatus, String rawParameters) {
        Object obj;
        Set<Pair<String, CompletableDeferred<Object[]>>> value;
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(callbackStatus, "callbackStatus");
        Intrinsics.checkNotNullParameter(rawParameters, "rawParameters");
        Object[] typedArray = JSONArrayExtensionsKt.toTypedArray(new JSONArray(rawParameters));
        Iterator<T> it = this.callbacks.getValue().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual((String) ((Pair) obj).component1(), callbackId)) {
                    break;
                }
            }
        }
        Pair pair = (Pair) obj;
        if (pair == null) {
            return;
        }
        CompletableDeferred completableDeferred = (CompletableDeferred) pair.component2();
        if (SetsKt.setOf((Object[]) new String[]{"success", "error"}).contains(callbackStatus)) {
            SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "old_callback_status", null, null, null, null, null, 62, null);
        }
        int hashCode = callbackStatus.hashCode();
        if (hashCode != -1867169789) {
            if (hashCode != 2524) {
                if (hashCode == 66247144 ? callbackStatus.equals("ERROR") : hashCode == 96784904 && callbackStatus.equals("error")) {
                    Object obj2 = typedArray[0];
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                    completableDeferred.completeExceptionally(new Exception((String) obj2));
                }
            }
        }
        MutableStateFlow<Set<Pair<String, CompletableDeferred<Object[]>>>> mutableStateFlow = this.callbacks;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SetsKt.minus(value, pair)));
    }

    @Override // com.unity3d.ads.adplayer.WebViewBridge
    public void handleInvocation(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        try {
            try {
                JSONArray jSONArray = new JSONArray(message);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    Object obj = jSONArray.get(i);
                    JSONArray jSONArray2 = obj instanceof JSONArray ? (JSONArray) obj : null;
                    if (jSONArray2 == null) {
                        throw new IllegalArgumentException(("Invalid invocation passed to CommonWebViewBridge: " + message).toString());
                    }
                    if (jSONArray2.length() != 4) {
                        throw new IllegalArgumentException(("Invocation must have 4 elements: " + jSONArray2).toString());
                    }
                    Object obj2 = jSONArray2.get(0);
                    String str = obj2 instanceof String ? (String) obj2 : null;
                    if (str == null) {
                        throw new IllegalArgumentException(("Invalid class name passed to CommonWebViewBridge: " + message).toString());
                    }
                    Object obj3 = jSONArray2.get(1);
                    String str2 = obj3 instanceof String ? (String) obj3 : null;
                    if (str2 == null) {
                        throw new IllegalArgumentException(("Invalid method name passed to CommonWebViewBridge: " + message).toString());
                    }
                    Object obj4 = jSONArray2.get(2);
                    JSONArray jSONArray3 = obj4 instanceof JSONArray ? (JSONArray) obj4 : null;
                    if (jSONArray3 == null) {
                        throw new IllegalArgumentException(("Invalid parameters passed to CommonWebViewBridge: " + message).toString());
                    }
                    Object obj5 = jSONArray2.get(3);
                    String str3 = obj5 instanceof String ? (String) obj5 : null;
                    if (str3 == null) {
                        throw new IllegalArgumentException(("Invalid callback id passed to CommonWebViewBridge: " + message).toString());
                    }
                    String str4 = str + '.' + str2;
                    DeviceLog.debug("Unity Ads WebView calling for: " + str4 + '(' + jSONArray3 + ')');
                    BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new CommonWebViewBridge$handleInvocation$7(str4, jSONArray3, this, str3, null), 3, null);
                }
            } catch (JSONException e) {
                throw new IllegalArgumentException("Invalid JSON array passed to CommonWebViewBridge: " + message, e);
            }
        } catch (Exception e2) {
            DeviceLog.error("Error handling invocation from webview (" + message + ')');
            SendDiagnosticEvent sendDiagnosticEvent = this.sendDiagnosticEvent;
            Pair[] pairArr = new Pair[2];
            String message2 = e2.getMessage();
            if (message2 == null) {
                message2 = e2.getClass().getSimpleName();
            }
            pairArr[0] = TuplesKt.to("reason_debug", message2);
            pairArr[1] = TuplesKt.to("webview_invocation", message);
            SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_webview_invocation_error", null, MapsKt.mapOf(pairArr), null, null, null, 58, null);
            throw new IllegalArgumentException("Invalid message passed to CommonWebViewBridge: " + message, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object respond(String str, String str2, Object[] objArr, Continuation<? super Unit> continuation) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(str);
        jSONArray.put(str2);
        jSONArray.put(new JSONArray(objArr));
        Object execute = execute(HandlerType.CALLBACK, C3040d4.i.d + jSONArray + AbstractJsonLexerKt.END_LIST, continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }
}
