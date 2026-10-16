package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FullscreenAdSceneLoader.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.FullscreenAdSceneLoaderImpl", f = "FullscreenAdSceneLoader.kt", i = {0, 0}, l = {31}, m = "loadSceneAssets-0E7RQCE", n = {"$this$getOrPut$iv", "key$iv"}, s = {"L$0", "L$1"})
/* loaded from: classes7.dex */
final class FullscreenAdSceneLoaderImpl$loadSceneAssets$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FullscreenAdSceneLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenAdSceneLoaderImpl$loadSceneAssets$1(FullscreenAdSceneLoaderImpl fullscreenAdSceneLoaderImpl, Continuation<? super FullscreenAdSceneLoaderImpl$loadSceneAssets$1> continuation) {
        super(continuation);
        this.this$0 = fullscreenAdSceneLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo9493loadSceneAssets0E7RQCE = this.this$0.mo9493loadSceneAssets0E7RQCE(null, null, this);
        return mo9493loadSceneAssets0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo9493loadSceneAssets0E7RQCE : Result.m10240boximpl(mo9493loadSceneAssets0E7RQCE);
    }
}
