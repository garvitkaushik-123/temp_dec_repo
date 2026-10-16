package io.adn.sdk.internal.common.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Task.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.common.utils.TaskKt", f = "Task.kt", i = {0}, l = {35, 37}, m = "retryOperation", n = {"operation"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class TaskKt$retryOperation$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    TaskKt$retryOperation$1(Continuation<? super TaskKt$retryOperation$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TaskKt.retryOperation(0, null, this);
    }
}
