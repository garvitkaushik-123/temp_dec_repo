package io.ktor.client.plugins.cache;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpCache.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache", f = "HttpCache.kt", i = {1}, l = {Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY_VALUE, Sdk.SDKError.Reason.GENERATE_JSON_DATA_ERROR_VALUE}, m = "findResponse", n = {"requestHeaders"}, s = {"L$0"})
/* loaded from: classes8.dex */
final class HttpCache$findResponse$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpCache$findResponse$1(HttpCache httpCache, Continuation<? super HttpCache$findResponse$1> continuation) {
        super(continuation);
        this.this$0 = httpCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object findResponse;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        findResponse = this.this$0.findResponse(null, null, null, null, this);
        return findResponse;
    }
}
