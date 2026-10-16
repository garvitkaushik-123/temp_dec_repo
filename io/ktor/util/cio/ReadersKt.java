package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Readers.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a6\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"toByteArray", "", "Lio/ktor/utils/io/ByteReadChannel;", "limit", "", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "use", "", "Lio/ktor/utils/io/ByteWriteChannel;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ReadersKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object toByteArray(ByteReadChannel byteReadChannel, int i, Continuation<? super byte[]> continuation) {
        ReadersKt$toByteArray$1 readersKt$toByteArray$1;
        int i2;
        if (continuation instanceof ReadersKt$toByteArray$1) {
            readersKt$toByteArray$1 = (ReadersKt$toByteArray$1) continuation;
            if ((readersKt$toByteArray$1.label & Integer.MIN_VALUE) != 0) {
                readersKt$toByteArray$1.label -= Integer.MIN_VALUE;
                Object obj = readersKt$toByteArray$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = readersKt$toByteArray$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    readersKt$toByteArray$1.label = 1;
                    obj = byteReadChannel.readRemaining(i, readersKt$toByteArray$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return StringsKt.readBytes$default((ByteReadPacket) obj, 0, 1, null);
            }
        }
        readersKt$toByteArray$1 = new ReadersKt$toByteArray$1(continuation);
        Object obj2 = readersKt$toByteArray$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = readersKt$toByteArray$1.label;
        if (i2 != 0) {
        }
        return StringsKt.readBytes$default((ByteReadPacket) obj2, 0, 1, null);
    }

    public static /* synthetic */ Object toByteArray$default(ByteReadChannel byteReadChannel, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        return toByteArray(byteReadChannel, i, continuation);
    }

    public static final void use(ByteWriteChannel byteWriteChannel, Function1<? super ByteWriteChannel, Unit> block) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            block.invoke(byteWriteChannel);
        } finally {
        }
    }
}
