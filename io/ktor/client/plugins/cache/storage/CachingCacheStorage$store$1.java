package io.ktor.client.plugins.cache.storage;

import com.ironsource.C3040d4;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FileCacheStorage.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", i = {0, 0}, l = {37, 38}, m = C3040d4.h.U, n = {"this", "url"}, s = {"L$0", "L$1"})
/* loaded from: classes8.dex */
final class CachingCacheStorage$store$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CachingCacheStorage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachingCacheStorage$store$1(CachingCacheStorage cachingCacheStorage, Continuation<? super CachingCacheStorage$store$1> continuation) {
        super(continuation);
        this.this$0 = cachingCacheStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.store(null, null, this);
    }
}
