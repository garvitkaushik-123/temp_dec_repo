package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FullscreenAdLoader.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.FullscreenAdLoaderImpl", f = "FullscreenAdLoader.kt", i = {}, l = {31}, m = "loadScene-0E7RQCE", n = {}, s = {})
/* loaded from: classes7.dex */
final class FullscreenAdLoaderImpl$loadScene$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FullscreenAdLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenAdLoaderImpl$loadScene$1(FullscreenAdLoaderImpl fullscreenAdLoaderImpl, Continuation<? super FullscreenAdLoaderImpl$loadScene$1> continuation) {
        super(continuation);
        this.this$0 = fullscreenAdLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo9481loadScene0E7RQCE = this.this$0.mo9481loadScene0E7RQCE(null, null, this);
        return mo9481loadScene0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo9481loadScene0E7RQCE : Result.m10240boximpl(mo9481loadScene0E7RQCE);
    }
}
