package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: Reading.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$1", f = "Reading.kt", i = {0, 0}, l = {61}, m = "invokeSuspend", n = {"$this$writer", "buffer"}, s = {"L$0", "L$1"})
/* loaded from: classes8.dex */
final class ReadingKt$toByteReadChannel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObjectPool<ByteBuffer> $pool;
    final /* synthetic */ InputStream $this_toByteReadChannel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReadingKt$toByteReadChannel$1(ObjectPool<ByteBuffer> objectPool, InputStream inputStream, Continuation<? super ReadingKt$toByteReadChannel$1> continuation) {
        super(2, continuation);
        this.$pool = objectPool;
        this.$this_toByteReadChannel = inputStream;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ReadingKt$toByteReadChannel$1 readingKt$toByteReadChannel$1 = new ReadingKt$toByteReadChannel$1(this.$pool, this.$this_toByteReadChannel, continuation);
        readingKt$toByteReadChannel$1.L$0 = obj;
        return readingKt$toByteReadChannel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((ReadingKt$toByteReadChannel$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ByteBuffer borrow;
        WriterScope writerScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WriterScope writerScope2 = (WriterScope) this.L$0;
            borrow = this.$pool.borrow();
            writerScope = writerScope2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            borrow = (ByteBuffer) this.L$1;
            writerScope = (WriterScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } finally {
                try {
                    this.$pool.recycle(borrow);
                    this.$this_toByteReadChannel.close();
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                }
            }
        }
        while (true) {
            borrow.clear();
            int read = this.$this_toByteReadChannel.read(borrow.array(), borrow.arrayOffset() + borrow.position(), borrow.remaining());
            if (read < 0) {
                break;
            }
            if (read != 0) {
                borrow.position(borrow.position() + read);
                borrow.flip();
                this.L$0 = writerScope;
                this.L$1 = borrow;
                this.label = 1;
                if (writerScope.getChannel().writeFully(borrow, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
    }
}
