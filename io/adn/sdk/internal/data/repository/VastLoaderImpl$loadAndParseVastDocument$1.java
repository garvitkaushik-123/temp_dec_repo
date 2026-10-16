package io.adn.sdk.internal.data.repository;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastLoader.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.VastLoaderImpl", f = "VastLoader.kt", i = {0, 0, 1}, l = {128, Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE}, m = "loadAndParseVastDocument", n = {"this", "errorUrls", "errorUrls"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes7.dex */
final class VastLoaderImpl$loadAndParseVastDocument$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VastLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VastLoaderImpl$loadAndParseVastDocument$1(VastLoaderImpl vastLoaderImpl, Continuation<? super VastLoaderImpl$loadAndParseVastDocument$1> continuation) {
        super(continuation);
        this.this$0 = vastLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadAndParseVastDocument;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadAndParseVastDocument = this.this$0.loadAndParseVastDocument(null, null, this);
        return loadAndParseVastDocument;
    }
}
