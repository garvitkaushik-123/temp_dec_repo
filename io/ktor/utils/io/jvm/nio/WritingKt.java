package io.ktor.utils.io.jvm.nio;

import io.ktor.utils.io.ByteReadChannel;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.SelectableChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: Writing.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"copyTo", "", "Lio/ktor/utils/io/ByteReadChannel;", "pipe", "Ljava/nio/channels/Pipe;", "limit", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/channels/Pipe;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channel", "Ljava/nio/channels/WritableByteChannel;", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/channels/WritableByteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class WritingKt {
    /* JADX WARN: Code restructure failed: missing block: B:11:0x009e, code lost:
    
        if (r7.isClosedForRead() == false) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0097 -> B:10:0x009a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyTo(ByteReadChannel byteReadChannel, final WritableByteChannel writableByteChannel, final long j, Continuation<? super Long> continuation) {
        WritingKt$copyTo$1 writingKt$copyTo$1;
        int i;
        final Ref.LongRef longRef;
        Function1<ByteBuffer, Unit> function1;
        if (continuation instanceof WritingKt$copyTo$1) {
            writingKt$copyTo$1 = (WritingKt$copyTo$1) continuation;
            if ((writingKt$copyTo$1.label & Integer.MIN_VALUE) != 0) {
                writingKt$copyTo$1.label -= Integer.MIN_VALUE;
                Object obj = writingKt$copyTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = writingKt$copyTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (j < 0) {
                        throw new IllegalArgumentException(("Limit shouldn't be negative: " + j).toString());
                    }
                    if ((writableByteChannel instanceof SelectableChannel) && !((SelectableChannel) writableByteChannel).isBlocking()) {
                        throw new IllegalArgumentException("Non-blocking channels are not supported");
                    }
                    if (byteReadChannel.isClosedForRead()) {
                        Throwable closedCause = byteReadChannel.getClosedCause();
                        if (closedCause != null) {
                            throw closedCause;
                        }
                        return Boxing.boxLong(0L);
                    }
                    longRef = new Ref.LongRef();
                    function1 = new Function1<ByteBuffer, Unit>() { // from class: io.ktor.utils.io.jvm.nio.WritingKt$copyTo$copy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
                            invoke2(byteBuffer);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ByteBuffer bb) {
                            Intrinsics.checkNotNullParameter(bb, "bb");
                            long j2 = j - longRef.element;
                            if (j2 < bb.remaining()) {
                                int limit = bb.limit();
                                bb.limit(bb.position() + ((int) j2));
                                while (bb.hasRemaining()) {
                                    writableByteChannel.write(bb);
                                }
                                bb.limit(limit);
                                longRef.element += j2;
                                return;
                            }
                            long j3 = 0;
                            while (bb.hasRemaining()) {
                                j3 += writableByteChannel.write(bb);
                            }
                            longRef.element += j3;
                        }
                    };
                    if (longRef.element < j) {
                        writingKt$copyTo$1.L$0 = byteReadChannel;
                        writingKt$copyTo$1.L$1 = longRef;
                        writingKt$copyTo$1.L$2 = function1;
                        writingKt$copyTo$1.J$0 = j;
                        writingKt$copyTo$1.label = 1;
                        if (byteReadChannel.read(0, function1, writingKt$copyTo$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    Throwable closedCause2 = byteReadChannel.getClosedCause();
                    if (closedCause2 != null) {
                        throw closedCause2;
                    }
                    return Boxing.boxLong(longRef.element);
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j2 = writingKt$copyTo$1.J$0;
                Function1<ByteBuffer, Unit> function12 = (Function1) writingKt$copyTo$1.L$2;
                Ref.LongRef longRef2 = (Ref.LongRef) writingKt$copyTo$1.L$1;
                ByteReadChannel byteReadChannel2 = (ByteReadChannel) writingKt$copyTo$1.L$0;
                ResultKt.throwOnFailure(obj);
                longRef = longRef2;
                function1 = function12;
                j = j2;
                byteReadChannel = byteReadChannel2;
            }
        }
        writingKt$copyTo$1 = new WritingKt$copyTo$1(continuation);
        Object obj2 = writingKt$copyTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = writingKt$copyTo$1.label;
        if (i != 0) {
        }
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, WritableByteChannel writableByteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(byteReadChannel, writableByteChannel, j, (Continuation<? super Long>) continuation);
    }

    public static final Object copyTo(ByteReadChannel byteReadChannel, Pipe pipe, long j, Continuation<? super Long> continuation) {
        Pipe.SinkChannel sink = pipe.sink();
        Intrinsics.checkNotNullExpressionValue(sink, "pipe.sink()");
        return copyTo(byteReadChannel, sink, j, continuation);
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, Pipe pipe, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(byteReadChannel, pipe, j, (Continuation<? super Long>) continuation);
    }
}
