package com.unity3d.ads.adplayer;

import android.webkit.JavascriptInterface;
import com.unity3d.ads.adplayer.model.WebViewBridgeInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidWebViewContainer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.adplayer.AndroidWebViewContainer$addJavascriptInterface$2", f = "AndroidWebViewContainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class AndroidWebViewContainer$addJavascriptInterface$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ WebViewBridge $webViewBridgeInterface;
    int label;
    final /* synthetic */ AndroidWebViewContainer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidWebViewContainer$addJavascriptInterface$2(AndroidWebViewContainer androidWebViewContainer, String str, WebViewBridge webViewBridge, Continuation<? super AndroidWebViewContainer$addJavascriptInterface$2> continuation) {
        super(2, continuation);
        this.this$0 = androidWebViewContainer;
        this.$name = str;
        this.$webViewBridgeInterface = webViewBridge;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidWebViewContainer$addJavascriptInterface$2(this.this$0, this.$name, this.$webViewBridgeInterface, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidWebViewContainer$addJavascriptInterface$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final WebViewBridge webViewBridge = this.$webViewBridgeInterface;
        this.this$0.getWebView().addJavascriptInterface(new WebViewBridgeInterface() { // from class: com.unity3d.ads.adplayer.AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1
            @Override // com.unity3d.ads.adplayer.model.WebViewBridgeInterface
            @JavascriptInterface
            public void handleInvocation(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                WebViewBridge.this.handleInvocation(message);
            }

            @Override // com.unity3d.ads.adplayer.model.WebViewBridgeInterface
            @JavascriptInterface
            public void handleCallback(String callbackId, String callbackStatus, String rawParameters) {
                Intrinsics.checkNotNullParameter(callbackId, "callbackId");
                Intrinsics.checkNotNullParameter(callbackStatus, "callbackStatus");
                Intrinsics.checkNotNullParameter(rawParameters, "rawParameters");
                WebViewBridge.this.handleCallback(callbackId, callbackStatus, rawParameters);
            }
        }, this.$name);
        return Unit.INSTANCE;
    }
}
