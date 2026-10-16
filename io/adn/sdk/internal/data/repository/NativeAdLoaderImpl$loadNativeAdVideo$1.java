package io.adn.sdk.internal.data.repository;

import io.bidmachine.ads.networks.vast.VastAdapter;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: NativeAdLoaderImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.NativeAdLoaderImpl", f = "NativeAdLoaderImpl.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {134, 136}, m = "loadNativeAdVideo", n = {"this", "aspectRatio", "impTrackers", "clickTrackers", "id", "aspectRatio", "impTrackers", "clickTrackers", VastAdapter.KEY, "creative", "id"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
/* loaded from: classes7.dex */
final class NativeAdLoaderImpl$loadNativeAdVideo$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NativeAdLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NativeAdLoaderImpl$loadNativeAdVideo$1(NativeAdLoaderImpl nativeAdLoaderImpl, Continuation<? super NativeAdLoaderImpl$loadNativeAdVideo$1> continuation) {
        super(continuation);
        this.this$0 = nativeAdLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadNativeAdVideo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadNativeAdVideo = this.this$0.loadNativeAdVideo(0, null, null, null, null, this);
        return loadNativeAdVideo;
    }
}
