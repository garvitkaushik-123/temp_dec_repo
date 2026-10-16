package com.unity3d.ads.adplayer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidFullscreenWebViewAdPlayer.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer", f = "AndroidFullscreenWebViewAdPlayer.kt", i = {0, 1, 2}, l = {170, 175, 179, 181}, m = "destroy", n = {"this", "this", "this"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes6.dex */
final class AndroidFullscreenWebViewAdPlayer$destroy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidFullscreenWebViewAdPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidFullscreenWebViewAdPlayer$destroy$1(AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer, Continuation<? super AndroidFullscreenWebViewAdPlayer$destroy$1> continuation) {
        super(continuation);
        this.this$0 = androidFullscreenWebViewAdPlayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.destroy(this);
    }
}
