package io.ktor.util.cio;

import io.ktor.util.InternalAPI;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: ReadersJvm.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"pass", "", "Lio/ktor/utils/io/ByteReadChannel;", "buffer", "Ljava/nio/ByteBuffer;", "block", "Lkotlin/Function1;", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/ByteBuffer;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ReadersJvmKt {
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0059 -> B:10:0x005c). Please report as a decompilation issue!!! */
    @InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object pass(ByteReadChannel byteReadChannel, ByteBuffer byteBuffer, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        ReadersJvmKt$pass$1 readersJvmKt$pass$1;
        int i;
        if (continuation instanceof ReadersJvmKt$pass$1) {
            readersJvmKt$pass$1 = (ReadersJvmKt$pass$1) continuation;
            if ((readersJvmKt$pass$1.label & Integer.MIN_VALUE) != 0) {
                readersJvmKt$pass$1.label -= Integer.MIN_VALUE;
                Object obj = readersJvmKt$pass$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = readersJvmKt$pass$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!byteReadChannel.isClosedForRead()) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Function1<? super ByteBuffer, Unit> function12 = (Function1) readersJvmKt$pass$1.L$2;
                    byteBuffer = (ByteBuffer) readersJvmKt$pass$1.L$1;
                    ByteReadChannel byteReadChannel2 = (ByteReadChannel) readersJvmKt$pass$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    function1 = function12;
                    byteReadChannel = byteReadChannel2;
                    byteBuffer.flip();
                    function1.invoke(byteBuffer);
                    if (!byteReadChannel.isClosedForRead()) {
                        byteBuffer.clear();
                        readersJvmKt$pass$1.L$0 = byteReadChannel;
                        readersJvmKt$pass$1.L$1 = byteBuffer;
                        readersJvmKt$pass$1.L$2 = function1;
                        readersJvmKt$pass$1.label = 1;
                        if (byteReadChannel.readAvailable(byteBuffer, readersJvmKt$pass$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        byteBuffer.flip();
                        function1.invoke(byteBuffer);
                        if (!byteReadChannel.isClosedForRead()) {
                            Throwable closedCause = byteReadChannel.getClosedCause();
                            if (closedCause != null) {
                                throw closedCause;
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        readersJvmKt$pass$1 = new ReadersJvmKt$pass$1(continuation);
        Object obj2 = readersJvmKt$pass$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = readersJvmKt$pass$1.label;
        if (i != 0) {
        }
    }

    @InternalAPI
    private static final Object pass$$forInline(ByteReadChannel byteReadChannel, ByteBuffer byteBuffer, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        while (!byteReadChannel.isClosedForRead()) {
            byteBuffer.clear();
            byteReadChannel.readAvailable(byteBuffer, (Continuation<? super Integer>) continuation);
            byteBuffer.flip();
            function1.invoke(byteBuffer);
        }
        Throwable closedCause = byteReadChannel.getClosedCause();
        if (closedCause == null) {
            return Unit.INSTANCE;
        }
        throw closedCause;
    }
}
