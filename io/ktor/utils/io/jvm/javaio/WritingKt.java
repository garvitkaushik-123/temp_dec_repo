package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.pool.ByteArrayPoolKt;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* compiled from: Writing.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"copyTo", "", "Lio/ktor/utils/io/ByteReadChannel;", "out", "Ljava/io/OutputStream;", "limit", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/io/OutputStream;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class WritingKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0093 -> B:13:0x0097). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyTo(ByteReadChannel byteReadChannel, OutputStream outputStream, long j, Continuation<? super Long> continuation) {
        WritingKt$copyTo$1 writingKt$copyTo$1;
        ?? r5;
        long length;
        long j2;
        byte[] bArr;
        WritingKt$copyTo$1 writingKt$copyTo$12;
        long j3;
        ByteReadChannel byteReadChannel2;
        OutputStream outputStream2;
        try {
            if (continuation instanceof WritingKt$copyTo$1) {
                writingKt$copyTo$1 = (WritingKt$copyTo$1) continuation;
                if ((writingKt$copyTo$1.label & Integer.MIN_VALUE) != 0) {
                    writingKt$copyTo$1.label -= Integer.MIN_VALUE;
                    Object obj = writingKt$copyTo$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r5 = writingKt$copyTo$1.label;
                    if (r5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (j < 0) {
                            throw new IllegalArgumentException(("Limit shouldn't be negative: " + j).toString());
                        }
                        byte[] borrow = ByteArrayPoolKt.getByteArrayPool().borrow();
                        length = borrow.length;
                        j2 = 0;
                        bArr = borrow;
                        writingKt$copyTo$12 = writingKt$copyTo$1;
                        j3 = j;
                        byteReadChannel2 = byteReadChannel;
                        outputStream2 = outputStream;
                        if (j2 < j3) {
                        }
                        r5 = bArr;
                        Long boxLong = Boxing.boxLong(j2);
                        ByteArrayPoolKt.getByteArrayPool().recycle(r5);
                        return boxLong;
                    }
                    if (r5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j4 = writingKt$copyTo$1.J$2;
                    long j5 = writingKt$copyTo$1.J$1;
                    long j6 = writingKt$copyTo$1.J$0;
                    byte[] bArr2 = (byte[]) writingKt$copyTo$1.L$2;
                    OutputStream outputStream3 = (OutputStream) writingKt$copyTo$1.L$1;
                    ByteReadChannel byteReadChannel3 = (ByteReadChannel) writingKt$copyTo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    long j7 = j5;
                    bArr = bArr2;
                    writingKt$copyTo$12 = writingKt$copyTo$1;
                    outputStream2 = outputStream3;
                    byteReadChannel2 = byteReadChannel3;
                    long j8 = j4;
                    try {
                        int intValue = ((Number) obj).intValue();
                        if (intValue == -1) {
                            j2 = j7;
                            r5 = bArr;
                            Long boxLong2 = Boxing.boxLong(j2);
                            ByteArrayPoolKt.getByteArrayPool().recycle(r5);
                            return boxLong2;
                        }
                        if (intValue > 0) {
                            outputStream2.write(bArr, 0, intValue);
                            long j9 = j8;
                            j2 = intValue + j7;
                            j3 = j6;
                            length = j9;
                        } else {
                            j3 = j6;
                            length = j8;
                            j2 = j7;
                        }
                        if (j2 < j3) {
                            int min = (int) Math.min(j3 - j2, length);
                            writingKt$copyTo$12.L$0 = byteReadChannel2;
                            writingKt$copyTo$12.L$1 = outputStream2;
                            writingKt$copyTo$12.L$2 = bArr;
                            writingKt$copyTo$12.J$0 = j3;
                            writingKt$copyTo$12.J$1 = j2;
                            writingKt$copyTo$12.J$2 = length;
                            writingKt$copyTo$12.label = 1;
                            Object readAvailable = byteReadChannel2.readAvailable(bArr, 0, min, writingKt$copyTo$12);
                            if (readAvailable == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            j7 = j2;
                            j8 = length;
                            j6 = j3;
                            obj = readAvailable;
                            int intValue2 = ((Number) obj).intValue();
                            if (intValue2 == -1) {
                            }
                        }
                        r5 = bArr;
                        Long boxLong22 = Boxing.boxLong(j2);
                        ByteArrayPoolKt.getByteArrayPool().recycle(r5);
                        return boxLong22;
                    } catch (Throwable th) {
                        th = th;
                        r5 = bArr;
                        ByteArrayPoolKt.getByteArrayPool().recycle(r5);
                        throw th;
                    }
                }
            }
            if (r5 != 0) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        writingKt$copyTo$1 = new WritingKt$copyTo$1(continuation);
        Object obj2 = writingKt$copyTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r5 = writingKt$copyTo$1.label;
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, OutputStream outputStream, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(byteReadChannel, outputStream, j, continuation);
    }
}
