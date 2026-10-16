package com.unity3d.ads.core.domain.work;

import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.domain.work.DownloadPriorityQueue;
import java.util.Comparator;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: DownloadPriorityQueue.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J7\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH\u0086Bø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/unity3d/ads/core/domain/work/DownloadPriorityQueue;", "", "()V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "nextTurn", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/unity3d/ads/core/domain/work/DownloadPriorityQueue$PriorityItem;", "queue", "Ljava/util/PriorityQueue;", "invoke", "", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "downloadAction", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PriorityItem", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DownloadPriorityQueue {
    private final Mutex mutex = MutexKt.Mutex(false);
    private final MutableStateFlow<PriorityItem> nextTurn = StateFlowKt.MutableStateFlow(null);
    private final PriorityQueue<PriorityItem> queue = new PriorityQueue<>(50, new Comparator() { // from class: com.unity3d.ads.core.domain.work.DownloadPriorityQueue$special$$inlined$compareBy$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((DownloadPriorityQueue.PriorityItem) t).getPriority()), Integer.valueOf(((DownloadPriorityQueue.PriorityItem) t2).getPriority()));
        }
    });

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00de, code lost:
    
        if (r12.invoke(r0) != r1) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(int i, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        DownloadPriorityQueue$invoke$1 downloadPriorityQueue$invoke$1;
        Object coroutine_suspended;
        int i2;
        DownloadPriorityQueue downloadPriorityQueue;
        Function1<? super Continuation<? super Unit>, ? extends Object> function12;
        Mutex mutex;
        PriorityItem priorityItem;
        MutableStateFlow<PriorityItem> mutableStateFlow;
        DownloadPriorityQueue$invoke$3 downloadPriorityQueue$invoke$3;
        Function1<? super Continuation<? super Unit>, ? extends Object> function13;
        DownloadPriorityQueue downloadPriorityQueue2;
        PriorityItem priorityItem2;
        Mutex mutex2;
        DownloadPriorityQueue downloadPriorityQueue3;
        try {
            if (continuation instanceof DownloadPriorityQueue$invoke$1) {
                downloadPriorityQueue$invoke$1 = (DownloadPriorityQueue$invoke$1) continuation;
                if ((downloadPriorityQueue$invoke$1.label & Integer.MIN_VALUE) != 0) {
                    downloadPriorityQueue$invoke$1.label -= Integer.MIN_VALUE;
                    Object obj = downloadPriorityQueue$invoke$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = downloadPriorityQueue$invoke$1.label;
                    if (i2 != 0) {
                        ResultKt.throwOnFailure(obj);
                        PriorityItem priorityItem3 = new PriorityItem(i);
                        Mutex mutex3 = this.mutex;
                        downloadPriorityQueue$invoke$1.L$0 = this;
                        downloadPriorityQueue$invoke$1.L$1 = function1;
                        downloadPriorityQueue$invoke$1.L$2 = priorityItem3;
                        downloadPriorityQueue$invoke$1.L$3 = mutex3;
                        downloadPriorityQueue$invoke$1.label = 1;
                        if (mutex3.lock(null, downloadPriorityQueue$invoke$1) != coroutine_suspended) {
                            downloadPriorityQueue = this;
                            function12 = function1;
                            mutex = mutex3;
                            priorityItem = priorityItem3;
                        }
                        return coroutine_suspended;
                    }
                    if (i2 == 1) {
                        Mutex mutex4 = (Mutex) downloadPriorityQueue$invoke$1.L$3;
                        PriorityItem priorityItem4 = (PriorityItem) downloadPriorityQueue$invoke$1.L$2;
                        function12 = (Function1) downloadPriorityQueue$invoke$1.L$1;
                        downloadPriorityQueue = (DownloadPriorityQueue) downloadPriorityQueue$invoke$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex4;
                        priorityItem = priorityItem4;
                    } else {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 4) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                mutex2 = (Mutex) downloadPriorityQueue$invoke$1.L$2;
                                priorityItem2 = (PriorityItem) downloadPriorityQueue$invoke$1.L$1;
                                downloadPriorityQueue3 = (DownloadPriorityQueue) downloadPriorityQueue$invoke$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                try {
                                    downloadPriorityQueue3.queue.remove(priorityItem2);
                                    downloadPriorityQueue3.nextTurn.setValue(downloadPriorityQueue3.queue.peek());
                                    Unit unit = Unit.INSTANCE;
                                    mutex.unlock(null);
                                    return Unit.INSTANCE;
                                } finally {
                                }
                            }
                            priorityItem = (PriorityItem) downloadPriorityQueue$invoke$1.L$1;
                            DownloadPriorityQueue downloadPriorityQueue4 = (DownloadPriorityQueue) downloadPriorityQueue$invoke$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            downloadPriorityQueue2 = downloadPriorityQueue4;
                            priorityItem2 = priorityItem;
                            mutex2 = downloadPriorityQueue2.mutex;
                            downloadPriorityQueue$invoke$1.L$0 = downloadPriorityQueue2;
                            downloadPriorityQueue$invoke$1.L$1 = priorityItem2;
                            downloadPriorityQueue$invoke$1.L$2 = mutex2;
                            downloadPriorityQueue$invoke$1.label = 4;
                            if (mutex2.lock(null, downloadPriorityQueue$invoke$1) != coroutine_suspended) {
                                downloadPriorityQueue3 = downloadPriorityQueue2;
                                downloadPriorityQueue3.queue.remove(priorityItem2);
                                downloadPriorityQueue3.nextTurn.setValue(downloadPriorityQueue3.queue.peek());
                                Unit unit2 = Unit.INSTANCE;
                                mutex.unlock(null);
                                return Unit.INSTANCE;
                            }
                            return coroutine_suspended;
                        }
                        priorityItem = (PriorityItem) downloadPriorityQueue$invoke$1.L$2;
                        function13 = (Function1) downloadPriorityQueue$invoke$1.L$1;
                        downloadPriorityQueue2 = (DownloadPriorityQueue) downloadPriorityQueue$invoke$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        downloadPriorityQueue$invoke$1.L$0 = downloadPriorityQueue2;
                        downloadPriorityQueue$invoke$1.L$1 = priorityItem;
                        downloadPriorityQueue$invoke$1.L$2 = null;
                        downloadPriorityQueue$invoke$1.label = 3;
                    }
                    downloadPriorityQueue.queue.offer(priorityItem);
                    downloadPriorityQueue.nextTurn.setValue(downloadPriorityQueue.queue.peek());
                    Unit unit3 = Unit.INSTANCE;
                    mutex.unlock(null);
                    mutableStateFlow = downloadPriorityQueue.nextTurn;
                    downloadPriorityQueue$invoke$3 = new DownloadPriorityQueue$invoke$3(priorityItem, null);
                    downloadPriorityQueue$invoke$1.L$0 = downloadPriorityQueue;
                    downloadPriorityQueue$invoke$1.L$1 = function12;
                    downloadPriorityQueue$invoke$1.L$2 = priorityItem;
                    downloadPriorityQueue$invoke$1.L$3 = null;
                    downloadPriorityQueue$invoke$1.label = 2;
                    if (FlowKt.first(mutableStateFlow, downloadPriorityQueue$invoke$3, downloadPriorityQueue$invoke$1) != coroutine_suspended) {
                        function13 = function12;
                        downloadPriorityQueue2 = downloadPriorityQueue;
                        downloadPriorityQueue$invoke$1.L$0 = downloadPriorityQueue2;
                        downloadPriorityQueue$invoke$1.L$1 = priorityItem;
                        downloadPriorityQueue$invoke$1.L$2 = null;
                        downloadPriorityQueue$invoke$1.label = 3;
                    }
                    return coroutine_suspended;
                }
            }
            downloadPriorityQueue.queue.offer(priorityItem);
            downloadPriorityQueue.nextTurn.setValue(downloadPriorityQueue.queue.peek());
            Unit unit32 = Unit.INSTANCE;
            mutex.unlock(null);
            mutableStateFlow = downloadPriorityQueue.nextTurn;
            downloadPriorityQueue$invoke$3 = new DownloadPriorityQueue$invoke$3(priorityItem, null);
            downloadPriorityQueue$invoke$1.L$0 = downloadPriorityQueue;
            downloadPriorityQueue$invoke$1.L$1 = function12;
            downloadPriorityQueue$invoke$1.L$2 = priorityItem;
            downloadPriorityQueue$invoke$1.L$3 = null;
            downloadPriorityQueue$invoke$1.label = 2;
            if (FlowKt.first(mutableStateFlow, downloadPriorityQueue$invoke$3, downloadPriorityQueue$invoke$1) != coroutine_suspended) {
            }
            return coroutine_suspended;
        } finally {
        }
        downloadPriorityQueue$invoke$1 = new DownloadPriorityQueue$invoke$1(this, continuation);
        Object obj2 = downloadPriorityQueue$invoke$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = downloadPriorityQueue$invoke$1.label;
        if (i2 != 0) {
        }
    }

    /* compiled from: DownloadPriorityQueue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/unity3d/ads/core/domain/work/DownloadPriorityQueue$PriorityItem;", "", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "(I)V", "getPriority", "()I", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PriorityItem {
        private final int priority;

        public PriorityItem(int i) {
            this.priority = i;
        }

        public final int getPriority() {
            return this.priority;
        }
    }
}
