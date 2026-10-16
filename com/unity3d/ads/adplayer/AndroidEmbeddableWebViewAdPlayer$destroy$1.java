package com.unity3d.ads.adplayer;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidEmbeddableWebViewAdPlayer.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer", f = "AndroidEmbeddableWebViewAdPlayer.kt", i = {0, 1}, l = {Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 128, 130}, m = "destroy", n = {"this", "this"}, s = {"L$0", "L$0"})
/* loaded from: classes6.dex */
final class AndroidEmbeddableWebViewAdPlayer$destroy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidEmbeddableWebViewAdPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidEmbeddableWebViewAdPlayer$destroy$1(AndroidEmbeddableWebViewAdPlayer androidEmbeddableWebViewAdPlayer, Continuation<? super AndroidEmbeddableWebViewAdPlayer$destroy$1> continuation) {
        super(continuation);
        this.this$0 = androidEmbeddableWebViewAdPlayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.destroy(this);
    }
}
