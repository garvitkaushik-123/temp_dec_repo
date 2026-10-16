package com.unity3d.ads.core.domain.work;

import com.unity3d.ads.core.domain.work.DownloadPriorityQueue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: DownloadPriorityQueue.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/unity3d/ads/core/domain/work/DownloadPriorityQueue$PriorityItem;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.work.DownloadPriorityQueue$invoke$3", f = "DownloadPriorityQueue.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class DownloadPriorityQueue$invoke$3 extends SuspendLambda implements Function2<DownloadPriorityQueue.PriorityItem, Continuation<? super Boolean>, Object> {
    final /* synthetic */ DownloadPriorityQueue.PriorityItem $priorityItem;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadPriorityQueue$invoke$3(DownloadPriorityQueue.PriorityItem priorityItem, Continuation<? super DownloadPriorityQueue$invoke$3> continuation) {
        super(2, continuation);
        this.$priorityItem = priorityItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DownloadPriorityQueue$invoke$3 downloadPriorityQueue$invoke$3 = new DownloadPriorityQueue$invoke$3(this.$priorityItem, continuation);
        downloadPriorityQueue$invoke$3.L$0 = obj;
        return downloadPriorityQueue$invoke$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DownloadPriorityQueue.PriorityItem priorityItem, Continuation<? super Boolean> continuation) {
        return ((DownloadPriorityQueue$invoke$3) create(priorityItem, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Boxing.boxBoolean(((DownloadPriorityQueue.PriorityItem) this.L$0) == this.$priorityItem);
    }
}
