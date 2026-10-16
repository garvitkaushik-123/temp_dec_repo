package io.adn.sdk.internal.data.repository;

import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.unified.UnifiedMediationParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: NativeAdLoaderImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.NativeAdLoaderImpl", f = "NativeAdLoaderImpl.kt", i = {0, 0, 0}, l = {Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE}, m = "loadNativeAdImage", n = {UnifiedMediationParams.KEY_IMAGE_URL, "imageAspectRatio", "id"}, s = {"L$0", "L$1", "I$0"})
/* loaded from: classes7.dex */
final class NativeAdLoaderImpl$loadNativeAdImage$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NativeAdLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NativeAdLoaderImpl$loadNativeAdImage$1(NativeAdLoaderImpl nativeAdLoaderImpl, Continuation<? super NativeAdLoaderImpl$loadNativeAdImage$1> continuation) {
        super(continuation);
        this.this$0 = nativeAdLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadNativeAdImage;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadNativeAdImage = this.this$0.loadNativeAdImage(0, null, null, this);
        return loadNativeAdImage;
    }
}
