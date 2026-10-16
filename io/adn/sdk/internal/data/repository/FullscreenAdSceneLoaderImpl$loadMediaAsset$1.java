package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FullscreenAdSceneLoader.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.FullscreenAdSceneLoaderImpl", f = "FullscreenAdSceneLoader.kt", i = {}, l = {54}, m = "loadMediaAsset-0E7RQCE", n = {}, s = {})
/* loaded from: classes7.dex */
final class FullscreenAdSceneLoaderImpl$loadMediaAsset$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FullscreenAdSceneLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenAdSceneLoaderImpl$loadMediaAsset$1(FullscreenAdSceneLoaderImpl fullscreenAdSceneLoaderImpl, Continuation<? super FullscreenAdSceneLoaderImpl$loadMediaAsset$1> continuation) {
        super(continuation);
        this.this$0 = fullscreenAdSceneLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9490loadMediaAsset0E7RQCE;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m9490loadMediaAsset0E7RQCE = this.this$0.m9490loadMediaAsset0E7RQCE(null, null, this);
        return m9490loadMediaAsset0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9490loadMediaAsset0E7RQCE : Result.m10240boximpl(m9490loadMediaAsset0E7RQCE);
    }
}
