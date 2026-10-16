package androidx.work;

import androidx.work.Operation;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: Operation.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"await", "Landroidx/work/Operation$State$SUCCESS;", "Landroidx/work/Operation;", "(Landroidx/work/Operation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "work-runtime-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class OperationKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object await(Operation operation, Continuation<? super Operation.State.SUCCESS> continuation) {
        OperationKt$await$1 operationKt$await$1;
        int i;
        Operation.State.SUCCESS success;
        if (continuation instanceof OperationKt$await$1) {
            operationKt$await$1 = (OperationKt$await$1) continuation;
            if ((operationKt$await$1.label & Integer.MIN_VALUE) != 0) {
                operationKt$await$1.label -= Integer.MIN_VALUE;
                ?? r6 = operationKt$await$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = operationKt$await$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(r6);
                    ListenableFuture<Operation.State.SUCCESS> result = operation.getResult();
                    Intrinsics.checkNotNullExpressionValue(result, "result");
                    if (result.isDone()) {
                        try {
                            success = result.get();
                            Intrinsics.checkNotNullExpressionValue(success, "result.await()");
                            return success;
                        } catch (ExecutionException e) {
                            Throwable cause = e.getCause();
                            if (cause == null) {
                                throw e;
                            }
                            throw cause;
                        }
                    }
                    operationKt$await$1.L$0 = result;
                    operationKt$await$1.label = 1;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(operationKt$await$1), 1);
                    cancellableContinuationImpl.initCancellability();
                    CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                    result.addListener(new ListenableFutureKt$await$2$1(cancellableContinuationImpl2, result), DirectExecutor.INSTANCE);
                    cancellableContinuationImpl2.invokeOnCancellation(new ListenableFutureKt$await$2$2(result));
                    r6 = cancellableContinuationImpl.getResult();
                    if (r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(operationKt$await$1);
                    }
                    if (r6 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(r6);
                }
                success = r6;
                Intrinsics.checkNotNullExpressionValue(success, "result.await()");
                return success;
            }
        }
        operationKt$await$1 = new OperationKt$await$1(continuation);
        ?? r62 = operationKt$await$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = operationKt$await$1.label;
        if (i != 0) {
        }
        success = r62;
        Intrinsics.checkNotNullExpressionValue(success, "result.await()");
        return success;
    }

    private static final Object await$$forInline(Operation operation, Continuation<? super Operation.State.SUCCESS> continuation) {
        Object obj;
        ListenableFuture<Operation.State.SUCCESS> result = operation.getResult();
        Intrinsics.checkNotNullExpressionValue(result, "result");
        if (result.isDone()) {
            try {
                obj = result.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        } else {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            result.addListener(new ListenableFutureKt$await$2$1(cancellableContinuationImpl2, result), DirectExecutor.INSTANCE);
            cancellableContinuationImpl2.invokeOnCancellation(new ListenableFutureKt$await$2$2(result));
            Unit unit = Unit.INSTANCE;
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
        }
        Intrinsics.checkNotNullExpressionValue(obj, "result.await()");
        return obj;
    }
}
