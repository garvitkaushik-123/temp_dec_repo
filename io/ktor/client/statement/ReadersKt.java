package io.ktor.client.statement;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: Readers.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"discardRemaining", "", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readBytes", "", "count", "", "(Lio/ktor/client/statement/HttpResponse;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ReadersKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readBytes(HttpResponse httpResponse, int i, Continuation<? super byte[]> continuation) {
        ReadersKt$readBytes$1 readersKt$readBytes$1;
        int i2;
        if (continuation instanceof ReadersKt$readBytes$1) {
            readersKt$readBytes$1 = (ReadersKt$readBytes$1) continuation;
            if ((readersKt$readBytes$1.label & Integer.MIN_VALUE) != 0) {
                readersKt$readBytes$1.label -= Integer.MIN_VALUE;
                Object obj = readersKt$readBytes$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = readersKt$readBytes$1.label;
                if (i2 == 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byte[] bArr = (byte[]) readersKt$readBytes$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return bArr;
                }
                ResultKt.throwOnFailure(obj);
                byte[] bArr2 = new byte[i];
                ByteReadChannel content = httpResponse.getContent();
                readersKt$readBytes$1.L$0 = bArr2;
                readersKt$readBytes$1.label = 1;
                return ByteReadChannelKt.readFully(content, bArr2, readersKt$readBytes$1) == coroutine_suspended ? coroutine_suspended : bArr2;
            }
        }
        readersKt$readBytes$1 = new ReadersKt$readBytes$1(continuation);
        Object obj2 = readersKt$readBytes$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = readersKt$readBytes$1.label;
        if (i2 == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readBytes(HttpResponse httpResponse, Continuation<? super byte[]> continuation) {
        ReadersKt$readBytes$3 readersKt$readBytes$3;
        int i;
        if (continuation instanceof ReadersKt$readBytes$3) {
            readersKt$readBytes$3 = (ReadersKt$readBytes$3) continuation;
            if ((readersKt$readBytes$3.label & Integer.MIN_VALUE) != 0) {
                readersKt$readBytes$3.label -= Integer.MIN_VALUE;
                ReadersKt$readBytes$3 readersKt$readBytes$32 = readersKt$readBytes$3;
                Object obj = readersKt$readBytes$32.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = readersKt$readBytes$32.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ByteReadChannel content = httpResponse.getContent();
                    readersKt$readBytes$32.label = 1;
                    obj = ByteReadChannel.DefaultImpls.readRemaining$default(content, 0L, readersKt$readBytes$32, 1, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return StringsKt.readBytes$default((ByteReadPacket) obj, 0, 1, null);
            }
        }
        readersKt$readBytes$3 = new ReadersKt$readBytes$3(continuation);
        ReadersKt$readBytes$3 readersKt$readBytes$322 = readersKt$readBytes$3;
        Object obj2 = readersKt$readBytes$322.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = readersKt$readBytes$322.label;
        if (i != 0) {
        }
        return StringsKt.readBytes$default((ByteReadPacket) obj2, 0, 1, null);
    }

    public static final Object discardRemaining(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        Object discard = ByteReadChannelKt.discard(httpResponse.getContent(), continuation);
        return discard == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? discard : Unit.INSTANCE;
    }
}
