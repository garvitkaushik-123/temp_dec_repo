package io.adn.sdk.internal.data.repository;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastLoader.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.VastLoaderImpl", f = "VastLoader.kt", i = {0, 0, 0, 0, 0}, l = {113, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE}, m = "loadVastWrapperAd", n = {"this", "wrapper", "wrapperChainParams", "aggregatedErrorUrls", "currentWrapperDepth"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
/* loaded from: classes7.dex */
final class VastLoaderImpl$loadVastWrapperAd$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VastLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VastLoaderImpl$loadVastWrapperAd$1(VastLoaderImpl vastLoaderImpl, Continuation<? super VastLoaderImpl$loadVastWrapperAd$1> continuation) {
        super(continuation);
        this.this$0 = vastLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadVastWrapperAd;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadVastWrapperAd = this.this$0.loadVastWrapperAd(null, null, this);
        return loadVastWrapperAd;
    }
}
