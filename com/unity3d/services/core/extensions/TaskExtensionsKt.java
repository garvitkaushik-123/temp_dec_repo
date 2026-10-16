package com.unity3d.services.core.extensions;

import com.unity3d.services.core.log.DeviceLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DelayKt;

/* compiled from: TaskExtensions.kt */
@Metadata(d1 = {"\u00008\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001at\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\n21\u0010\u000b\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"withRetry", "T", "retryDelay", "", "retries", "", "scalingFactor", "", "fallbackException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "attempt", "Lkotlin/coroutines/Continuation;", "", "(JIDLjava/lang/Exception;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class TaskExtensionsKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0122 -> B:11:0x0128). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x013f -> B:12:0x014a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withRetry(long j, int i, double d, Exception exc, Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        TaskExtensionsKt$withRetry$1 taskExtensionsKt$withRetry$1;
        int i2;
        long j2;
        double d2;
        Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> function22;
        Ref.LongRef longRef;
        TaskExtensionsKt$withRetry$1 taskExtensionsKt$withRetry$12;
        int i3;
        int i4;
        Exception exc2;
        Exception exc3;
        Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> function23;
        Ref.LongRef longRef2;
        long j3;
        int i5;
        double d3;
        int i6;
        int i7;
        Throwable th;
        Object m10241constructorimpl;
        int i8;
        if (continuation instanceof TaskExtensionsKt$withRetry$1) {
            taskExtensionsKt$withRetry$1 = (TaskExtensionsKt$withRetry$1) continuation;
            if ((taskExtensionsKt$withRetry$1.label & Integer.MIN_VALUE) != 0) {
                taskExtensionsKt$withRetry$1.label -= Integer.MIN_VALUE;
                Object obj = taskExtensionsKt$withRetry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = taskExtensionsKt$withRetry$1.label;
                int i9 = 1;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.LongRef longRef3 = new Ref.LongRef();
                    j2 = j;
                    longRef3.element = j2;
                    d2 = d;
                    function22 = function2;
                    longRef = longRef3;
                    taskExtensionsKt$withRetry$12 = taskExtensionsKt$withRetry$1;
                    i3 = 0;
                    i4 = i;
                    exc2 = exc;
                    if (i3 >= i4) {
                    }
                } else if (i2 == 1) {
                    i7 = taskExtensionsKt$withRetry$1.I$2;
                    i6 = taskExtensionsKt$withRetry$1.I$1;
                    d3 = taskExtensionsKt$withRetry$1.D$0;
                    i5 = taskExtensionsKt$withRetry$1.I$0;
                    j3 = taskExtensionsKt$withRetry$1.J$0;
                    longRef2 = (Ref.LongRef) taskExtensionsKt$withRetry$1.L$2;
                    function23 = (Function2) taskExtensionsKt$withRetry$1.L$1;
                    exc3 = (Exception) taskExtensionsKt$withRetry$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                        int i10 = i6;
                        int i11 = i7;
                        i8 = i10;
                        if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
                        }
                    }
                    m10241constructorimpl = Result.m10241constructorimpl(obj);
                    int i102 = i6;
                    int i112 = i7;
                    i8 = i102;
                    if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
                    }
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i8 = taskExtensionsKt$withRetry$1.I$1;
                    double d4 = taskExtensionsKt$withRetry$1.D$0;
                    int i12 = taskExtensionsKt$withRetry$1.I$0;
                    long j4 = taskExtensionsKt$withRetry$1.J$0;
                    Ref.LongRef longRef4 = (Ref.LongRef) taskExtensionsKt$withRetry$1.L$2;
                    Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> function24 = (Function2) taskExtensionsKt$withRetry$1.L$1;
                    Exception exc4 = (Exception) taskExtensionsKt$withRetry$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    int i13 = 1;
                    longRef4.element = (long) (j4 * d4);
                    Ref.LongRef longRef5 = longRef4;
                    taskExtensionsKt$withRetry$12 = taskExtensionsKt$withRetry$1;
                    i4 = i12;
                    Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> function25 = function24;
                    longRef2 = longRef5;
                    function22 = function25;
                    d2 = d4;
                    j2 = j4;
                    int i14 = i8 + 1;
                    i9 = i13;
                    exc2 = exc4;
                    longRef = longRef2;
                    i3 = i14;
                    if (i3 >= i4) {
                        try {
                        } catch (Throwable th3) {
                            th = th3;
                            exc3 = exc2;
                            i7 = i3;
                            longRef2 = longRef;
                            function23 = function22;
                            i5 = i4;
                            taskExtensionsKt$withRetry$1 = taskExtensionsKt$withRetry$12;
                            j3 = j2;
                            d3 = d2;
                            i6 = i7;
                            Result.Companion companion2 = Result.INSTANCE;
                            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                            int i1022 = i6;
                            int i1122 = i7;
                            i8 = i1022;
                            if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
                            }
                        }
                        Result.Companion companion3 = Result.INSTANCE;
                        Integer boxInt = Boxing.boxInt(i3);
                        taskExtensionsKt$withRetry$12.L$0 = exc2;
                        taskExtensionsKt$withRetry$12.L$1 = function22;
                        taskExtensionsKt$withRetry$12.L$2 = longRef;
                        taskExtensionsKt$withRetry$12.J$0 = j2;
                        taskExtensionsKt$withRetry$12.I$0 = i4;
                        taskExtensionsKt$withRetry$12.D$0 = d2;
                        taskExtensionsKt$withRetry$12.I$1 = i3;
                        taskExtensionsKt$withRetry$12.I$2 = i3;
                        taskExtensionsKt$withRetry$12.label = i9;
                        obj = function22.invoke(boxInt, taskExtensionsKt$withRetry$12);
                        if (obj != coroutine_suspended) {
                            exc3 = exc2;
                            i7 = i3;
                            longRef2 = longRef;
                            function23 = function22;
                            i5 = i4;
                            taskExtensionsKt$withRetry$1 = taskExtensionsKt$withRetry$12;
                            j3 = j2;
                            d3 = d2;
                            i6 = i7;
                            m10241constructorimpl = Result.m10241constructorimpl(obj);
                            int i10222 = i6;
                            int i11222 = i7;
                            i8 = i10222;
                            if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
                                ResultKt.throwOnFailure(m10241constructorimpl);
                                return m10241constructorimpl;
                            }
                            if (Result.m10247isFailureimpl(m10241constructorimpl)) {
                                Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                                if (m10244exceptionOrNullimpl instanceof AbortRetryException) {
                                    throw m10244exceptionOrNullimpl;
                                }
                                if (i11222 + i9 == i5) {
                                    throw exc3;
                                }
                                i13 = i9;
                                DeviceLog.debug("Unity Ads init: retrying in " + longRef2.element + " milliseconds");
                                long j5 = longRef2.element;
                                taskExtensionsKt$withRetry$1.L$0 = exc3;
                                taskExtensionsKt$withRetry$1.L$1 = function23;
                                taskExtensionsKt$withRetry$1.L$2 = longRef2;
                                taskExtensionsKt$withRetry$1.J$0 = j3;
                                taskExtensionsKt$withRetry$1.I$0 = i5;
                                taskExtensionsKt$withRetry$1.D$0 = d3;
                                taskExtensionsKt$withRetry$1.I$1 = i8;
                                taskExtensionsKt$withRetry$1.label = 2;
                                if (DelayKt.delay(j5, taskExtensionsKt$withRetry$1) != coroutine_suspended) {
                                    d4 = d3;
                                    i12 = i5;
                                    j4 = j3;
                                    longRef4 = longRef2;
                                    function24 = function23;
                                    exc4 = exc3;
                                    longRef4.element = (long) (j4 * d4);
                                    Ref.LongRef longRef52 = longRef4;
                                    taskExtensionsKt$withRetry$12 = taskExtensionsKt$withRetry$1;
                                    i4 = i12;
                                    Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> function252 = function24;
                                    longRef2 = longRef52;
                                    function22 = function252;
                                    d2 = d4;
                                    j2 = j4;
                                    int i142 = i8 + 1;
                                    i9 = i13;
                                    exc2 = exc4;
                                    longRef = longRef2;
                                    i3 = i142;
                                    if (i3 >= i4) {
                                        throw new IllegalStateException("Unknown exception from withRetry");
                                    }
                                }
                            } else {
                                i13 = i9;
                                taskExtensionsKt$withRetry$12 = taskExtensionsKt$withRetry$1;
                                i4 = i5;
                                d2 = d3;
                                j2 = j3;
                                function22 = function23;
                                exc4 = exc3;
                                int i1422 = i8 + 1;
                                i9 = i13;
                                exc2 = exc4;
                                longRef = longRef2;
                                i3 = i1422;
                                if (i3 >= i4) {
                                }
                            }
                        }
                        return coroutine_suspended;
                    }
                }
            }
        }
        taskExtensionsKt$withRetry$1 = new TaskExtensionsKt$withRetry$1(continuation);
        Object obj2 = taskExtensionsKt$withRetry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = taskExtensionsKt$withRetry$1.label;
        int i92 = 1;
        if (i2 != 0) {
        }
    }

    public static /* synthetic */ Object withRetry$default(long j, int i, double d, Exception exc, Function2 function2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = 5000;
        }
        if ((i2 & 2) != 0) {
            i = 6;
        }
        if ((i2 & 4) != 0) {
            d = 2.0d;
        }
        int i3 = i;
        return withRetry(j, i3, d, exc, function2, continuation);
    }
}
