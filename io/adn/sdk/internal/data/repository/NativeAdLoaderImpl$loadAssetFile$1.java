package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: NativeAdLoaderImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.NativeAdLoaderImpl", f = "NativeAdLoaderImpl.kt", i = {}, l = {114}, m = "loadAssetFile", n = {}, s = {})
/* loaded from: classes7.dex */
final class NativeAdLoaderImpl$loadAssetFile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NativeAdLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NativeAdLoaderImpl$loadAssetFile$1(NativeAdLoaderImpl nativeAdLoaderImpl, Continuation<? super NativeAdLoaderImpl$loadAssetFile$1> continuation) {
        super(continuation);
        this.this$0 = nativeAdLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadAssetFile;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadAssetFile = this.this$0.loadAssetFile(null, null, this);
        return loadAssetFile;
    }
}
