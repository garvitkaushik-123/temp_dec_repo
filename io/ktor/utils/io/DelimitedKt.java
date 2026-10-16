package io.ktor.utils.io;

import io.ktor.utils.io.internal.UtilsKt;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* compiled from: Delimited.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a-\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u001d\u0010\r\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u0011\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"readUntilDelimiter", "", "Lio/ktor/utils/io/ByteReadChannel;", "delimiter", "Ljava/nio/ByteBuffer;", "dst", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readUntilDelimiterSuspend", "copied0", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "skipDelimiter", "", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "skipDelimiterSuspend", "startsWithDelimiter", "Lio/ktor/utils/io/LookAheadSession;", "tryCopyUntilDelimiter", "tryEnsureDelimiter", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DelimitedKt {
    public static final Object readUntilDelimiter(ByteReadChannel byteReadChannel, final ByteBuffer byteBuffer, final ByteBuffer byteBuffer2, Continuation<? super Integer> continuation) {
        int i;
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (byteBuffer == byteBuffer2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        byteReadChannel.lookAhead(new Function1<LookAheadSession, Unit>() { // from class: io.ktor.utils.io.DelimitedKt$readUntilDelimiter$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LookAheadSession lookAheadSession) {
                invoke2(lookAheadSession);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LookAheadSession lookAhead) {
                int tryCopyUntilDelimiter;
                Intrinsics.checkNotNullParameter(lookAhead, "$this$lookAhead");
                do {
                    tryCopyUntilDelimiter = DelimitedKt.tryCopyUntilDelimiter(lookAhead, byteBuffer, byteBuffer2);
                    if (tryCopyUntilDelimiter == 0) {
                        return;
                    }
                    if (tryCopyUntilDelimiter < 0) {
                        booleanRef.element = true;
                        tryCopyUntilDelimiter = -tryCopyUntilDelimiter;
                    }
                    intRef.element += tryCopyUntilDelimiter;
                    if (!byteBuffer2.hasRemaining()) {
                        return;
                    }
                } while (!booleanRef.element);
            }
        });
        if (intRef.element == 0 && byteReadChannel.isClosedForRead()) {
            i = -1;
        } else if (!byteBuffer2.hasRemaining() || booleanRef.element) {
            i = intRef.element;
        } else {
            return readUntilDelimiterSuspend(byteReadChannel, byteBuffer, byteBuffer2, intRef.element, continuation);
        }
        return Boxing.boxInt(i);
    }

    public static final Object skipDelimiter(ByteReadChannel byteReadChannel, final ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        byteReadChannel.lookAhead(new Function1<LookAheadSession, Unit>() { // from class: io.ktor.utils.io.DelimitedKt$skipDelimiter$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LookAheadSession lookAheadSession) {
                invoke2(lookAheadSession);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LookAheadSession lookAhead) {
                int tryEnsureDelimiter;
                Intrinsics.checkNotNullParameter(lookAhead, "$this$lookAhead");
                Ref.BooleanRef booleanRef2 = Ref.BooleanRef.this;
                tryEnsureDelimiter = DelimitedKt.tryEnsureDelimiter(lookAhead, byteBuffer);
                booleanRef2.element = tryEnsureDelimiter == byteBuffer.remaining();
            }
        });
        if (!booleanRef.element) {
            Object skipDelimiterSuspend = skipDelimiterSuspend(byteReadChannel, byteBuffer, continuation);
            return skipDelimiterSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? skipDelimiterSuspend : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object skipDelimiterSuspend(ByteReadChannel byteReadChannel, ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        Object lookAheadSuspend = byteReadChannel.lookAheadSuspend(new DelimitedKt$skipDelimiterSuspend$2(byteBuffer, null), continuation);
        return lookAheadSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? lookAheadSuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readUntilDelimiterSuspend(ByteReadChannel byteReadChannel, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, Continuation<? super Integer> continuation) {
        DelimitedKt$readUntilDelimiterSuspend$1 delimitedKt$readUntilDelimiterSuspend$1;
        int i2;
        ByteReadChannel byteReadChannel2;
        ByteBuffer byteBuffer3;
        Ref.BooleanRef booleanRef;
        int intValue;
        int i3;
        if (continuation instanceof DelimitedKt$readUntilDelimiterSuspend$1) {
            delimitedKt$readUntilDelimiterSuspend$1 = (DelimitedKt$readUntilDelimiterSuspend$1) continuation;
            if ((delimitedKt$readUntilDelimiterSuspend$1.label & Integer.MIN_VALUE) != 0) {
                delimitedKt$readUntilDelimiterSuspend$1.label -= Integer.MIN_VALUE;
                DelimitedKt$readUntilDelimiterSuspend$1 delimitedKt$readUntilDelimiterSuspend$12 = delimitedKt$readUntilDelimiterSuspend$1;
                Object obj = delimitedKt$readUntilDelimiterSuspend$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = delimitedKt$readUntilDelimiterSuspend$12.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (byteBuffer == byteBuffer2) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    if (i < 0) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    DelimitedKt$readUntilDelimiterSuspend$copied$1 delimitedKt$readUntilDelimiterSuspend$copied$1 = new DelimitedKt$readUntilDelimiterSuspend$copied$1(i, byteBuffer, byteBuffer2, booleanRef2, byteReadChannel, null);
                    delimitedKt$readUntilDelimiterSuspend$12.L$0 = byteReadChannel;
                    delimitedKt$readUntilDelimiterSuspend$12.L$1 = byteBuffer2;
                    delimitedKt$readUntilDelimiterSuspend$12.L$2 = booleanRef2;
                    delimitedKt$readUntilDelimiterSuspend$12.label = 1;
                    obj = byteReadChannel.lookAheadSuspend(delimitedKt$readUntilDelimiterSuspend$copied$1, delimitedKt$readUntilDelimiterSuspend$12);
                    if (obj != coroutine_suspended) {
                        byteReadChannel2 = byteReadChannel;
                        byteBuffer3 = byteBuffer2;
                        booleanRef = booleanRef2;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i3 = delimitedKt$readUntilDelimiterSuspend$12.I$0;
                    ResultKt.throwOnFailure(obj);
                    intValue = RangesKt.coerceAtLeast(((Number) obj).intValue(), 0) + i3;
                    return Boxing.boxInt(intValue);
                }
                booleanRef = (Ref.BooleanRef) delimitedKt$readUntilDelimiterSuspend$12.L$2;
                byteBuffer3 = (ByteBuffer) delimitedKt$readUntilDelimiterSuspend$12.L$1;
                byteReadChannel2 = (ByteReadChannel) delimitedKt$readUntilDelimiterSuspend$12.L$0;
                ResultKt.throwOnFailure(obj);
                intValue = ((Number) obj).intValue();
                if (intValue > 0 || !byteReadChannel2.isClosedForWrite() || booleanRef.element) {
                    if (intValue == 0 && byteReadChannel2.isClosedForRead()) {
                        intValue = -1;
                    }
                    return Boxing.boxInt(intValue);
                }
                delimitedKt$readUntilDelimiterSuspend$12.L$0 = null;
                delimitedKt$readUntilDelimiterSuspend$12.L$1 = null;
                delimitedKt$readUntilDelimiterSuspend$12.L$2 = null;
                delimitedKt$readUntilDelimiterSuspend$12.I$0 = intValue;
                delimitedKt$readUntilDelimiterSuspend$12.label = 2;
                Object readAvailable = byteReadChannel2.readAvailable(byteBuffer3, delimitedKt$readUntilDelimiterSuspend$12);
                if (readAvailable != coroutine_suspended) {
                    i3 = intValue;
                    obj = readAvailable;
                    intValue = RangesKt.coerceAtLeast(((Number) obj).intValue(), 0) + i3;
                    return Boxing.boxInt(intValue);
                }
                return coroutine_suspended;
            }
        }
        delimitedKt$readUntilDelimiterSuspend$1 = new DelimitedKt$readUntilDelimiterSuspend$1(continuation);
        DelimitedKt$readUntilDelimiterSuspend$1 delimitedKt$readUntilDelimiterSuspend$122 = delimitedKt$readUntilDelimiterSuspend$1;
        Object obj2 = delimitedKt$readUntilDelimiterSuspend$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = delimitedKt$readUntilDelimiterSuspend$122.label;
        if (i2 != 0) {
        }
        intValue = ((Number) obj2).intValue();
        if (intValue > 0) {
        }
        if (intValue == 0) {
            intValue = -1;
        }
        return Boxing.boxInt(intValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int tryCopyUntilDelimiter(LookAheadSession lookAheadSession, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int putAtMost$default;
        boolean z = false;
        ByteBuffer request = lookAheadSession.request(0, 1);
        if (request == null) {
            return 0;
        }
        int indexOfPartial = UtilsKt.indexOfPartial(request, byteBuffer);
        if (indexOfPartial != -1) {
            int min = Math.min(request.remaining() - indexOfPartial, byteBuffer.remaining());
            int remaining = byteBuffer.remaining() - min;
            if (remaining == 0) {
                putAtMost$default = UtilsKt.putLimited(byteBuffer2, request, request.position() + indexOfPartial);
            } else {
                ByteBuffer remembered = request.duplicate();
                ByteBuffer request2 = lookAheadSession.request(indexOfPartial + min, 1);
                if (request2 == null) {
                    Intrinsics.checkNotNullExpressionValue(remembered, "remembered");
                    putAtMost$default = UtilsKt.putLimited(byteBuffer2, remembered, remembered.position() + indexOfPartial);
                } else if (UtilsKt.startsWith(request2, byteBuffer, min)) {
                    if (request2.remaining() >= remaining) {
                        Intrinsics.checkNotNullExpressionValue(remembered, "remembered");
                        putAtMost$default = UtilsKt.putLimited(byteBuffer2, remembered, remembered.position() + indexOfPartial);
                    } else {
                        Intrinsics.checkNotNullExpressionValue(remembered, "remembered");
                        putAtMost$default = UtilsKt.putLimited(byteBuffer2, remembered, remembered.position() + indexOfPartial);
                    }
                } else {
                    Intrinsics.checkNotNullExpressionValue(remembered, "remembered");
                    putAtMost$default = UtilsKt.putLimited(byteBuffer2, remembered, remembered.position() + indexOfPartial + 1);
                }
            }
            z = true;
        } else {
            putAtMost$default = UtilsKt.putAtMost$default(byteBuffer2, request, 0, 2, null);
        }
        lookAheadSession.mo10232consumed(putAtMost$default);
        return z ? -putAtMost$default : putAtMost$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int tryEnsureDelimiter(LookAheadSession lookAheadSession, ByteBuffer byteBuffer) {
        int startsWithDelimiter = startsWithDelimiter(lookAheadSession, byteBuffer);
        if (startsWithDelimiter == -1) {
            throw new IOException("Failed to skip delimiter: actual bytes differ from delimiter bytes");
        }
        if (startsWithDelimiter < byteBuffer.remaining()) {
            return startsWithDelimiter;
        }
        lookAheadSession.mo10232consumed(byteBuffer.remaining());
        return byteBuffer.remaining();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int startsWithDelimiter(LookAheadSession lookAheadSession, ByteBuffer byteBuffer) {
        ByteBuffer request = lookAheadSession.request(0, 1);
        if (request == null) {
            return 0;
        }
        int indexOfPartial = UtilsKt.indexOfPartial(request, byteBuffer);
        if (indexOfPartial != 0) {
            return -1;
        }
        int min = Math.min(request.remaining() - indexOfPartial, byteBuffer.remaining());
        int remaining = byteBuffer.remaining() - min;
        if (remaining > 0) {
            ByteBuffer request2 = lookAheadSession.request(indexOfPartial + min, remaining);
            if (request2 == null) {
                return min;
            }
            if (!UtilsKt.startsWith(request2, byteBuffer, min)) {
                return -1;
            }
        }
        return byteBuffer.remaining();
    }
}
