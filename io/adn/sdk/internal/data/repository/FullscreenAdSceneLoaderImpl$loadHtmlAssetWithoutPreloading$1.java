package io.adn.sdk.internal.data.repository;

import adn.analytics.Analytics;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FullscreenAdSceneLoader.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.FullscreenAdSceneLoaderImpl", f = "FullscreenAdSceneLoader.kt", i = {0}, l = {Analytics.AnalyticsData.COUNT_IMP_FIELD_NUMBER}, m = "loadHtmlAssetWithoutPreloading-gIAlu-s", n = {"controller"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class FullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FullscreenAdSceneLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1(FullscreenAdSceneLoaderImpl fullscreenAdSceneLoaderImpl, Continuation<? super FullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1> continuation) {
        super(continuation);
        this.this$0 = fullscreenAdSceneLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9489loadHtmlAssetWithoutPreloadinggIAlus;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m9489loadHtmlAssetWithoutPreloadinggIAlus = this.this$0.m9489loadHtmlAssetWithoutPreloadinggIAlus(null, this);
        return m9489loadHtmlAssetWithoutPreloadinggIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9489loadHtmlAssetWithoutPreloadinggIAlus : Result.m10240boximpl(m9489loadHtmlAssetWithoutPreloadinggIAlus);
    }
}
