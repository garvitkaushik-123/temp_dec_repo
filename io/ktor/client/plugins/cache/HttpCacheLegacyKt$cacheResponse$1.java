package io.ktor.client.plugins.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpCacheLegacy.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCacheLegacyKt", f = "HttpCacheLegacy.kt", i = {}, l = {111}, m = "cacheResponse", n = {}, s = {})
/* loaded from: classes8.dex */
final class HttpCacheLegacyKt$cacheResponse$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    HttpCacheLegacyKt$cacheResponse$1(Continuation<? super HttpCacheLegacyKt$cacheResponse$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object cacheResponse;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        cacheResponse = HttpCacheLegacyKt.cacheResponse(null, null, this);
        return cacheResponse;
    }
}
