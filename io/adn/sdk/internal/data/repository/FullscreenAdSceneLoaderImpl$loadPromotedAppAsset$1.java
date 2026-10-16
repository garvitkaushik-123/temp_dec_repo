package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FullscreenAdSceneLoader.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.FullscreenAdSceneLoaderImpl", f = "FullscreenAdSceneLoader.kt", i = {}, l = {39}, m = "loadPromotedAppAsset-gIAlu-s", n = {}, s = {})
/* loaded from: classes7.dex */
final class FullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FullscreenAdSceneLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1(FullscreenAdSceneLoaderImpl fullscreenAdSceneLoaderImpl, Continuation<? super FullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1> continuation) {
        super(continuation);
        this.this$0 = fullscreenAdSceneLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo9492loadPromotedAppAssetgIAlus = this.this$0.mo9492loadPromotedAppAssetgIAlus(null, this);
        return mo9492loadPromotedAppAssetgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo9492loadPromotedAppAssetgIAlus : Result.m10240boximpl(mo9492loadPromotedAppAssetgIAlus);
    }
}
