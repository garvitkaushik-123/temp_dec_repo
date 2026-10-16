package io.adn.sdk.internal.common.utils;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Task.kt */
@Metadata(d1 = {"\u0000@\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0080@¢\u0006\u0002\u0010\u0003\u001aa\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007\"\b\b\u0001\u0010\b*\u00020\u0007\"\b\b\u0002\u0010\u0005*\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u0001H\u00062\b\u0010\n\u001a\u0004\u0018\u0001H\b2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\b\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\fH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\r\u001a{\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007\"\b\b\u0001\u0010\b*\u00020\u0007\"\b\b\u0002\u0010\u000e*\u00020\u0007\"\b\b\u0003\u0010\u0005*\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u0001H\u00062\b\u0010\n\u001a\u0004\u0018\u0001H\b2\b\u0010\u000f\u001a\u0004\u0018\u0001H\u000e2 \u0010\u000b\u001a\u001c\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u0010H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001aG\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0013\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00010\u00132\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00130\u0015H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a<\u0010\u0017\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u001a\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0015H\u0080@¢\u0006\u0002\u0010\u001c\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"await", "T", "Lcom/google/android/gms/tasks/Task;", "(Lcom/google/android/gms/tasks/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeLet", "R", "T1", "", "T2", "p1", "p2", "block", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "flatMap", "Lkotlin/Result;", "transform", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "retryOperation", "attempts", "", "operation", "Lkotlin/coroutines/Continuation;", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class TaskKt {
    public static final <T> Object await(Task<T> task, Continuation<? super T> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        task.addOnCompleteListener(new OnCompleteListener() { // from class: io.adn.sdk.internal.common.utils.TaskKt$await$2$1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task<T> task2) {
                Intrinsics.checkNotNullParameter(task2, "task");
                if (task2.isSuccessful()) {
                    Continuation<T> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m10241constructorimpl(task2.getResult()));
                } else {
                    Continuation<T> continuation3 = safeContinuation2;
                    RuntimeException exception = task2.getException();
                    if (exception == null) {
                        exception = new RuntimeException("Unknown task exception");
                    }
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation3.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(exception)));
                }
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final <T1, T2, R> R safeLet(T1 t1, T2 t2, Function2<? super T1, ? super T2, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (t1 == null || t2 == null) {
            return null;
        }
        return block.invoke(t1, t2);
    }

    public static final <T1, T2, T3, R> R safeLet(T1 t1, T2 t2, T3 t3, Function3<? super T1, ? super T2, ? super T3, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (t1 == null || t2 == null || t3 == null) {
            return null;
        }
        return block.invoke(t1, t2, t3);
    }

    public static final <T, R> Object flatMap(Object obj, Function1<? super T, ? extends Result<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(obj);
        if (m10244exceptionOrNullimpl == null) {
            return transform.invoke(obj).getValue();
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0061 -> B:21:0x0064). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object retryOperation(int i, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        TaskKt$retryOperation$1 taskKt$retryOperation$1;
        int i2;
        int i3;
        int i4;
        Function1<? super Continuation<? super T>, ? extends Object> function12;
        Function1<? super Continuation<? super T>, ? extends Object> function13;
        Throwable th;
        if (continuation instanceof TaskKt$retryOperation$1) {
            taskKt$retryOperation$1 = (TaskKt$retryOperation$1) continuation;
            if ((taskKt$retryOperation$1.label & Integer.MIN_VALUE) != 0) {
                taskKt$retryOperation$1.label -= Integer.MIN_VALUE;
                Object obj = taskKt$retryOperation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = taskKt$retryOperation$1.label;
                if (i2 == 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    i4 = taskKt$retryOperation$1.I$1;
                    i3 = taskKt$retryOperation$1.I$0;
                    function13 = (Function1) taskKt$retryOperation$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion = Result.INSTANCE;
                        Result.m10241constructorimpl(ResultKt.createFailure(th));
                        i4++;
                        function12 = function13;
                        if (i4 < i3) {
                        }
                        return coroutine_suspended;
                    }
                }
                ResultKt.throwOnFailure(obj);
                i3 = i - 1;
                i4 = 0;
                function12 = function1;
                if (i4 < i3) {
                    try {
                    } catch (Throwable th3) {
                        function13 = function12;
                        th = th3;
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.m10241constructorimpl(ResultKt.createFailure(th));
                        i4++;
                        function12 = function13;
                        if (i4 < i3) {
                        }
                        return coroutine_suspended;
                    }
                    Result.Companion companion3 = Result.INSTANCE;
                    taskKt$retryOperation$1.L$0 = function12;
                    taskKt$retryOperation$1.I$0 = i3;
                    taskKt$retryOperation$1.I$1 = i4;
                    taskKt$retryOperation$1.label = 1;
                    Object invoke = function12.invoke(taskKt$retryOperation$1);
                    if (invoke != coroutine_suspended) {
                        return invoke;
                    }
                } else {
                    taskKt$retryOperation$1.L$0 = null;
                    taskKt$retryOperation$1.label = 2;
                    Object invoke2 = function12.invoke(taskKt$retryOperation$1);
                    if (invoke2 != coroutine_suspended) {
                        return invoke2;
                    }
                }
                return coroutine_suspended;
            }
        }
        taskKt$retryOperation$1 = new TaskKt$retryOperation$1(continuation);
        Object obj2 = taskKt$retryOperation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = taskKt$retryOperation$1.label;
        if (i2 == 0) {
        }
    }

    public static /* synthetic */ Object retryOperation$default(int i, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        return retryOperation(i, function1, continuation);
    }
}
