package io.ktor.utils.io.jvm.nio;

import io.ktor.utils.io.ByteWriteChannel;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SelectableChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: Reading.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"copyTo", "", "Ljava/nio/channels/Pipe;", "ch", "Lio/ktor/utils/io/ByteWriteChannel;", "limit", "(Ljava/nio/channels/Pipe;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/channels/ReadableByteChannel;", "(Ljava/nio/channels/ReadableByteChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ReadingKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x009f -> B:10:0x00a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyTo(final ReadableByteChannel readableByteChannel, ByteWriteChannel byteWriteChannel, final long j, Continuation<? super Long> continuation) {
        ReadingKt$copyTo$1 readingKt$copyTo$1;
        int i;
        final Ref.LongRef longRef;
        Function1<ByteBuffer, Unit> function1;
        int i2;
        long j2;
        Ref.BooleanRef booleanRef;
        if (continuation instanceof ReadingKt$copyTo$1) {
            readingKt$copyTo$1 = (ReadingKt$copyTo$1) continuation;
            if ((readingKt$copyTo$1.label & Integer.MIN_VALUE) != 0) {
                readingKt$copyTo$1.label -= Integer.MIN_VALUE;
                Object obj = readingKt$copyTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = readingKt$copyTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (j < 0) {
                        throw new IllegalArgumentException(("Limit shouldn't be negative: " + j).toString());
                    }
                    if ((readableByteChannel instanceof SelectableChannel) && !((SelectableChannel) readableByteChannel).isBlocking()) {
                        throw new IllegalArgumentException("Non-blocking channels are not supported");
                    }
                    longRef = new Ref.LongRef();
                    final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    function1 = new Function1<ByteBuffer, Unit>() { // from class: io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$copy$1
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
                            long j3 = j - longRef.element;
                            if (j3 < bb.remaining()) {
                                int limit = bb.limit();
                                bb.limit(bb.position() + ((int) j3));
                                int read = readableByteChannel.read(bb);
                                if (read == -1) {
                                    booleanRef2.element = true;
                                } else {
                                    longRef.element += read;
                                }
                                bb.limit(limit);
                                return;
                            }
                            int read2 = readableByteChannel.read(bb);
                            if (read2 == -1) {
                                booleanRef2.element = true;
                            } else {
                                longRef.element += read2;
                            }
                        }
                    };
                    i2 = !byteWriteChannel.getAutoFlush() ? 1 : 0;
                    j2 = j;
                    booleanRef = booleanRef2;
                    if (longRef.element >= j2) {
                    }
                    return Boxing.boxLong(longRef.element);
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = readingKt$copyTo$1.I$0;
                long j3 = readingKt$copyTo$1.J$0;
                Function1<ByteBuffer, Unit> function12 = (Function1) readingKt$copyTo$1.L$3;
                booleanRef = (Ref.BooleanRef) readingKt$copyTo$1.L$2;
                Ref.LongRef longRef2 = (Ref.LongRef) readingKt$copyTo$1.L$1;
                ByteWriteChannel byteWriteChannel2 = (ByteWriteChannel) readingKt$copyTo$1.L$0;
                ResultKt.throwOnFailure(obj);
                longRef = longRef2;
                function1 = function12;
                j2 = j3;
                byteWriteChannel = byteWriteChannel2;
                if (i2 != 0) {
                    byteWriteChannel.flush();
                }
                if (longRef.element >= j2 && !booleanRef.element) {
                    readingKt$copyTo$1.L$0 = byteWriteChannel;
                    readingKt$copyTo$1.L$1 = longRef;
                    readingKt$copyTo$1.L$2 = booleanRef;
                    readingKt$copyTo$1.L$3 = function1;
                    readingKt$copyTo$1.J$0 = j2;
                    readingKt$copyTo$1.I$0 = i2;
                    readingKt$copyTo$1.label = 1;
                    if (byteWriteChannel.write(1, function1, readingKt$copyTo$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (i2 != 0) {
                    }
                    if (longRef.element >= j2) {
                    }
                    return Boxing.boxLong(longRef.element);
                }
                return Boxing.boxLong(longRef.element);
            }
        }
        readingKt$copyTo$1 = new ReadingKt$copyTo$1(continuation);
        Object obj2 = readingKt$copyTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = readingKt$copyTo$1.label;
        if (i != 0) {
        }
    }

    public static /* synthetic */ Object copyTo$default(ReadableByteChannel readableByteChannel, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(readableByteChannel, byteWriteChannel, j, (Continuation<? super Long>) continuation);
    }

    public static final Object copyTo(Pipe pipe, ByteWriteChannel byteWriteChannel, long j, Continuation<? super Long> continuation) {
        Pipe.SourceChannel source = pipe.source();
        Intrinsics.checkNotNullExpressionValue(source, "source()");
        return copyTo(source, byteWriteChannel, j, continuation);
    }

    public static /* synthetic */ Object copyTo$default(Pipe pipe, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(pipe, byteWriteChannel, j, (Continuation<? super Long>) continuation);
    }
}
