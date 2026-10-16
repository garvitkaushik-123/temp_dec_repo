package com.unity3d.ads.core.domain.work;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DownloadPriorityQueue.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.work.DownloadPriorityQueue", f = "DownloadPriorityQueue.kt", i = {0, 0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 3}, l = {47, 28, 31, 57}, m = "invoke", n = {"this", "downloadAction", "priorityItem", "$this$withLock_u24default$iv", "this", "downloadAction", "priorityItem", "this", "priorityItem", "this", "priorityItem", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$2"})
/* loaded from: classes7.dex */
final class DownloadPriorityQueue$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadPriorityQueue this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadPriorityQueue$invoke$1(DownloadPriorityQueue downloadPriorityQueue, Continuation<? super DownloadPriorityQueue$invoke$1> continuation) {
        super(continuation);
        this.this$0 = downloadPriorityQueue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(0, null, this);
    }
}
