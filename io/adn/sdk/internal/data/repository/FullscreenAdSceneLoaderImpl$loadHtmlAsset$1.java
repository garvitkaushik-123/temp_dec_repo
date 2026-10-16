package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FullscreenAdSceneLoader.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.FullscreenAdSceneLoaderImpl", f = "FullscreenAdSceneLoader.kt", i = {}, l = {64, 65}, m = "loadHtmlAsset-BWLJW6A", n = {}, s = {})
/* loaded from: classes7.dex */
final class FullscreenAdSceneLoaderImpl$loadHtmlAsset$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FullscreenAdSceneLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenAdSceneLoaderImpl$loadHtmlAsset$1(FullscreenAdSceneLoaderImpl fullscreenAdSceneLoaderImpl, Continuation<? super FullscreenAdSceneLoaderImpl$loadHtmlAsset$1> continuation) {
        super(continuation);
        this.this$0 = fullscreenAdSceneLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9487loadHtmlAssetBWLJW6A;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m9487loadHtmlAssetBWLJW6A = this.this$0.m9487loadHtmlAssetBWLJW6A(null, null, null, this);
        return m9487loadHtmlAssetBWLJW6A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9487loadHtmlAssetBWLJW6A : Result.m10240boximpl(m9487loadHtmlAssetBWLJW6A);
    }
}
