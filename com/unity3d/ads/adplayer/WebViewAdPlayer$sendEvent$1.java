package com.unity3d.ads.adplayer;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WebViewAdPlayer.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.adplayer.WebViewAdPlayer", f = "WebViewAdPlayer.kt", i = {0, 0}, l = {206, Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE}, m = "sendEvent", n = {"this", "getEvent"}, s = {"L$0", "L$1"})
/* loaded from: classes6.dex */
final class WebViewAdPlayer$sendEvent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebViewAdPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebViewAdPlayer$sendEvent$1(WebViewAdPlayer webViewAdPlayer, Continuation<? super WebViewAdPlayer$sendEvent$1> continuation) {
        super(continuation);
        this.this$0 = webViewAdPlayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object sendEvent;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        sendEvent = this.this$0.sendEvent(null, this);
        return sendEvent;
    }
}
