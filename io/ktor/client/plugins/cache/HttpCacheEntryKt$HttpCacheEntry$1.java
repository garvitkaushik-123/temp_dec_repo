package io.ktor.client.plugins.cache;

import com.ironsource.C3337ue;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpCacheEntry.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCacheEntryKt", f = "HttpCacheEntry.kt", i = {0, 0}, l = {18}, m = "HttpCacheEntry", n = {C3337ue.n, "isShared"}, s = {"L$0", "Z$0"})
/* loaded from: classes8.dex */
final class HttpCacheEntryKt$HttpCacheEntry$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    HttpCacheEntryKt$HttpCacheEntry$1(Continuation<? super HttpCacheEntryKt$HttpCacheEntry$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpCacheEntryKt.HttpCacheEntry(false, null, this);
    }
}
