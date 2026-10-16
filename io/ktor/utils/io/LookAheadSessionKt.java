package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LookAheadSession.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0086\bø\u0001\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\"\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0086Hø\u0001\u0001¢\u0006\u0002\u0010\u000b\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"consumeEachRemaining", "", "Lio/ktor/utils/io/LookAheadSession;", "visitor", "Lkotlin/Function1;", "Ljava/nio/ByteBuffer;", "", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/utils/io/LookAheadSuspendSession;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class LookAheadSessionKt {
    public static final void consumeEachRemaining(LookAheadSession lookAheadSession, Function1<? super ByteBuffer, Boolean> visitor) {
        boolean z;
        Intrinsics.checkNotNullParameter(lookAheadSession, "<this>");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        do {
            z = false;
            ByteBuffer request = lookAheadSession.request(0, 1);
            if (request != null) {
                int remaining = request.remaining();
                boolean booleanValue = visitor.invoke(request).booleanValue();
                lookAheadSession.mo10232consumed(remaining);
                z = booleanValue;
            }
        } while (z);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006d -> B:14:0x004e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0084 -> B:11:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object consumeEachRemaining(LookAheadSuspendSession lookAheadSuspendSession, Function2<? super ByteBuffer, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        LookAheadSessionKt$consumeEachRemaining$1 lookAheadSessionKt$consumeEachRemaining$1;
        int i;
        LookAheadSuspendSession lookAheadSuspendSession2;
        Function2<? super ByteBuffer, ? super Continuation<? super Boolean>, ? extends Object> function22;
        ByteBuffer request;
        if (continuation instanceof LookAheadSessionKt$consumeEachRemaining$1) {
            lookAheadSessionKt$consumeEachRemaining$1 = (LookAheadSessionKt$consumeEachRemaining$1) continuation;
            if ((lookAheadSessionKt$consumeEachRemaining$1.label & Integer.MIN_VALUE) != 0) {
                lookAheadSessionKt$consumeEachRemaining$1.label -= Integer.MIN_VALUE;
                Object obj = lookAheadSessionKt$consumeEachRemaining$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = lookAheadSessionKt$consumeEachRemaining$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    request = lookAheadSuspendSession.request(0, 1);
                    if (request == null) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    function22 = (Function2) lookAheadSessionKt$consumeEachRemaining$1.L$1;
                    lookAheadSuspendSession2 = (LookAheadSuspendSession) lookAheadSessionKt$consumeEachRemaining$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = lookAheadSessionKt$consumeEachRemaining$1.I$0;
                function2 = (Function2) lookAheadSessionKt$consumeEachRemaining$1.L$1;
                LookAheadSuspendSession lookAheadSuspendSession3 = (LookAheadSuspendSession) lookAheadSessionKt$consumeEachRemaining$1.L$0;
                ResultKt.throwOnFailure(obj);
                boolean booleanValue = ((Boolean) obj).booleanValue();
                lookAheadSuspendSession3.mo10232consumed(i2);
                if (booleanValue) {
                    lookAheadSuspendSession = lookAheadSuspendSession3;
                    request = lookAheadSuspendSession.request(0, 1);
                    if (request == null) {
                        lookAheadSessionKt$consumeEachRemaining$1.L$0 = lookAheadSuspendSession;
                        lookAheadSessionKt$consumeEachRemaining$1.L$1 = function2;
                        lookAheadSessionKt$consumeEachRemaining$1.label = 1;
                        obj = lookAheadSuspendSession.awaitAtLeast(1, lookAheadSessionKt$consumeEachRemaining$1);
                        if (obj != coroutine_suspended) {
                            Function2<? super ByteBuffer, ? super Continuation<? super Boolean>, ? extends Object> function23 = function2;
                            lookAheadSuspendSession2 = lookAheadSuspendSession;
                            function22 = function23;
                            if (((Boolean) obj).booleanValue()) {
                                LookAheadSuspendSession lookAheadSuspendSession4 = lookAheadSuspendSession2;
                                function2 = function22;
                                lookAheadSuspendSession = lookAheadSuspendSession4;
                                request = lookAheadSuspendSession.request(0, 1);
                                if (request == null) {
                                    int remaining = request.remaining();
                                    lookAheadSessionKt$consumeEachRemaining$1.L$0 = lookAheadSuspendSession;
                                    lookAheadSessionKt$consumeEachRemaining$1.L$1 = function2;
                                    lookAheadSessionKt$consumeEachRemaining$1.I$0 = remaining;
                                    lookAheadSessionKt$consumeEachRemaining$1.label = 2;
                                    obj = function2.invoke(request, lookAheadSessionKt$consumeEachRemaining$1);
                                    if (obj != coroutine_suspended) {
                                        lookAheadSuspendSession3 = lookAheadSuspendSession;
                                        i2 = remaining;
                                        boolean booleanValue2 = ((Boolean) obj).booleanValue();
                                        lookAheadSuspendSession3.mo10232consumed(i2);
                                        if (booleanValue2) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        lookAheadSessionKt$consumeEachRemaining$1 = new LookAheadSessionKt$consumeEachRemaining$1(continuation);
        Object obj2 = lookAheadSessionKt$consumeEachRemaining$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = lookAheadSessionKt$consumeEachRemaining$1.label;
        if (i != 0) {
        }
    }

    private static final Object consumeEachRemaining$$forInline(LookAheadSuspendSession lookAheadSuspendSession, Function2<? super ByteBuffer, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        while (true) {
            ByteBuffer request = lookAheadSuspendSession.request(0, 1);
            if (request == null) {
                if (!((Boolean) lookAheadSuspendSession.awaitAtLeast(1, continuation)).booleanValue()) {
                    break;
                }
            } else {
                int remaining = request.remaining();
                boolean booleanValue = ((Boolean) function2.invoke(request, continuation)).booleanValue();
                lookAheadSuspendSession.mo10232consumed(remaining);
                if (!booleanValue) {
                    break;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
