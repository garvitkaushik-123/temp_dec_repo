package com.unity3d.ads.adplayer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidWebViewContainer.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.adplayer.AndroidWebViewContainer", f = "AndroidWebViewContainer.kt", i = {}, l = {98}, m = "addJavascriptInterface", n = {}, s = {})
/* loaded from: classes6.dex */
final class AndroidWebViewContainer$addJavascriptInterface$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidWebViewContainer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidWebViewContainer$addJavascriptInterface$1(AndroidWebViewContainer androidWebViewContainer, Continuation<? super AndroidWebViewContainer$addJavascriptInterface$1> continuation) {
        super(continuation);
        this.this$0 = androidWebViewContainer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addJavascriptInterface(null, null, this);
    }
}
