package io.adn.sdk.internal.data.repository;

import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FullscreenAdSceneLoader.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.FullscreenAdSceneLoaderImpl", f = "FullscreenAdSceneLoader.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {106, 107, 114, 120}, m = "loadHtmlAssetWithPreloading-0E7RQCE", n = {"activity", "controller", "controller", "loadedFile", AnalyticsConstants.CREATIVE_TYPE_HTML, "controller", AnalyticsConstants.CREATIVE_TYPE_HTML, "controller"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes7.dex */
final class FullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FullscreenAdSceneLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1(FullscreenAdSceneLoaderImpl fullscreenAdSceneLoaderImpl, Continuation<? super FullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1> continuation) {
        super(continuation);
        this.this$0 = fullscreenAdSceneLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9488loadHtmlAssetWithPreloading0E7RQCE;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m9488loadHtmlAssetWithPreloading0E7RQCE = this.this$0.m9488loadHtmlAssetWithPreloading0E7RQCE(null, null, this);
        return m9488loadHtmlAssetWithPreloading0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9488loadHtmlAssetWithPreloading0E7RQCE : Result.m10240boximpl(m9488loadHtmlAssetWithPreloading0E7RQCE);
    }
}
