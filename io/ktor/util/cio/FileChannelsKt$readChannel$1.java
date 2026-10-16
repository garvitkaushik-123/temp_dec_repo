package io.ktor.util.cio;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.core.CloseableJVMKt;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: FileChannels.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$readChannel$1", f = "FileChannels.kt", i = {0, 0, 1, 1}, l = {44, 63}, m = "invokeSuspend", n = {"$this$use$iv", "closed$iv", "$this$use$iv", "closed$iv"}, s = {"L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes8.dex */
final class FileChannelsKt$readChannel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $endInclusive;
    final /* synthetic */ long $fileLength;
    final /* synthetic */ long $start;
    final /* synthetic */ File $this_readChannel;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileChannelsKt$readChannel$1(long j, long j2, long j3, File file, Continuation<? super FileChannelsKt$readChannel$1> continuation) {
        super(2, continuation);
        this.$start = j;
        this.$endInclusive = j2;
        this.$fileLength = j3;
        this.$this_readChannel = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FileChannelsKt$readChannel$1 fileChannelsKt$readChannel$1 = new FileChannelsKt$readChannel$1(this.$start, this.$endInclusive, this.$fileLength, this.$this_readChannel, continuation);
        fileChannelsKt$readChannel$1.L$0 = obj;
        return fileChannelsKt$readChannel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((FileChannelsKt$readChannel$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ac, code lost:
    
        if (r14.writeWhile(r4, r13) == r0) goto L36;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Closeable closeable;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WriterScope writerScope = (WriterScope) this.L$0;
            long j = this.$start;
            if (!(j >= 0)) {
                throw new IllegalArgumentException(("start position shouldn't be negative but it is " + j).toString());
            }
            long j2 = this.$endInclusive;
            long j3 = this.$fileLength;
            if (!(j2 <= j3 - 1)) {
                throw new IllegalArgumentException(("endInclusive points to the position out of the file: file size = " + j3 + ", endInclusive = " + j2).toString());
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.$this_readChannel, "r");
            long j4 = this.$start;
            final long j5 = this.$endInclusive;
            try {
                final FileChannel channel = randomAccessFile.getChannel();
                Intrinsics.checkNotNullExpressionValue(channel, "file.channel");
                if (j4 > 0) {
                    channel.position(j4);
                }
                if (j5 == -1) {
                    ByteWriteChannel channel2 = writerScope.getChannel();
                    FileChannelsKt$readChannel$1$3$1 fileChannelsKt$readChannel$1$3$1 = new FileChannelsKt$readChannel$1$3$1(writerScope, channel, null);
                    this.L$0 = randomAccessFile;
                    this.I$0 = 0;
                    this.label = 1;
                    if (channel2.writeSuspendSession(fileChannelsKt$readChannel$1$3$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    closeable = randomAccessFile;
                } else {
                    final Ref.LongRef longRef = new Ref.LongRef();
                    longRef.element = j4;
                    ByteWriteChannel channel3 = writerScope.getChannel();
                    Function1<ByteBuffer, Boolean> function1 = new Function1<ByteBuffer, Boolean>() { // from class: io.ktor.util.cio.FileChannelsKt$readChannel$1$3$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(ByteBuffer buffer) {
                            int read;
                            Intrinsics.checkNotNullParameter(buffer, "buffer");
                            long j6 = (j5 - longRef.element) + 1;
                            if (j6 < buffer.remaining()) {
                                int limit = buffer.limit();
                                buffer.limit(buffer.position() + ((int) j6));
                                read = channel.read(buffer);
                                buffer.limit(limit);
                            } else {
                                read = channel.read(buffer);
                            }
                            if (read > 0) {
                                longRef.element += read;
                            }
                            return Boolean.valueOf(read != -1 && longRef.element <= j5);
                        }
                    };
                    this.L$0 = randomAccessFile;
                    this.I$0 = 0;
                    this.label = 2;
                }
            } catch (Throwable th) {
                th = th;
                closeable = randomAccessFile;
                closeable.close();
                throw th;
            }
        } else {
            if (i == 1) {
                closeable = (Closeable) this.L$0;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) this.L$0;
            }
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                try {
                    closeable.close();
                } catch (Throwable th3) {
                    CloseableJVMKt.addSuppressedInternal(th, th3);
                }
                throw th;
            }
        }
        Unit unit = Unit.INSTANCE;
        closeable.close();
        return Unit.INSTANCE;
    }
}
