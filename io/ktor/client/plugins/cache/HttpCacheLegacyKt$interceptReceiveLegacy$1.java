package io.ktor.client.plugins.cache;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpCacheLegacy.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCacheLegacyKt", f = "HttpCacheLegacy.kt", i = {0}, l = {62, 63, TokenParametersOuterClass$TokenParameters.APPSETID_FIELD_NUMBER}, m = "interceptReceiveLegacy", n = {"$this$interceptReceiveLegacy"}, s = {"L$0"})
/* loaded from: classes8.dex */
final class HttpCacheLegacyKt$interceptReceiveLegacy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    HttpCacheLegacyKt$interceptReceiveLegacy$1(Continuation<? super HttpCacheLegacyKt$interceptReceiveLegacy$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpCacheLegacyKt.interceptReceiveLegacy(null, null, null, null, this);
    }
}
