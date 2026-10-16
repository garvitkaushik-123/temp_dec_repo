package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CommonGetIsFileCache.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.CommonGetIsFileCache", f = "CommonGetIsFileCache.kt", i = {0, 0}, l = {18}, m = "invoke", n = {"this", "startTime"}, s = {"L$0", "J$0"})
/* loaded from: classes7.dex */
final class CommonGetIsFileCache$invoke$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonGetIsFileCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonGetIsFileCache$invoke$1(CommonGetIsFileCache commonGetIsFileCache, Continuation<? super CommonGetIsFileCache$invoke$1> continuation) {
        super(continuation);
        this.this$0 = commonGetIsFileCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, this);
    }
}
