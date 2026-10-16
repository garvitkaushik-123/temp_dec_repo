package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ByteArrayPoolKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: Reading.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a+\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000e0\fH\u0007¢\u0006\u0002\b\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"copyTo", "", "Ljava/io/InputStream;", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "limit", "(Ljava/io/InputStream;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toByteReadChannel", "Lio/ktor/utils/io/ByteReadChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "", "toByteReadChannelWithArrayPool", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ReadingKt {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[LOOP:0: B:16:0x0073->B:28:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a0 -> B:13:0x00a7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyTo(InputStream inputStream, ByteWriteChannel byteWriteChannel, long j, Continuation<? super Long> continuation) {
        ReadingKt$copyTo$1 readingKt$copyTo$1;
        int i;
        byte[] bArr;
        long length;
        byte[] bArr2;
        long j2;
        ReadingKt$copyTo$1 readingKt$copyTo$12;
        long j3;
        InputStream inputStream2;
        ByteWriteChannel byteWriteChannel2;
        int read;
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
                    byte[] borrow = ByteArrayPoolKt.getByteArrayPool().borrow();
                    try {
                        length = borrow.length;
                        bArr2 = borrow;
                        j2 = 0;
                        readingKt$copyTo$12 = readingKt$copyTo$1;
                        j3 = j;
                        inputStream2 = inputStream;
                        byteWriteChannel2 = byteWriteChannel;
                        while (j2 < j3) {
                        }
                        Long boxLong = Boxing.boxLong(j2);
                        ByteArrayPoolKt.getByteArrayPool().recycle(bArr2);
                        return boxLong;
                    } catch (Throwable th) {
                        th = th;
                        bArr = borrow;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i2 = readingKt$copyTo$1.I$0;
                    long j4 = readingKt$copyTo$1.J$2;
                    long j5 = readingKt$copyTo$1.J$1;
                    long j6 = readingKt$copyTo$1.J$0;
                    bArr = (byte[]) readingKt$copyTo$1.L$2;
                    ByteWriteChannel byteWriteChannel3 = (ByteWriteChannel) readingKt$copyTo$1.L$1;
                    InputStream inputStream3 = (InputStream) readingKt$copyTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        bArr2 = bArr;
                        byteWriteChannel2 = byteWriteChannel3;
                        readingKt$copyTo$12 = readingKt$copyTo$1;
                        j3 = j6;
                        long j7 = j4;
                        try {
                            long j8 = j7;
                            j2 = j5 + i2;
                            length = j8;
                            inputStream2 = inputStream3;
                            while (j2 < j3 && (read = inputStream2.read(bArr2, 0, (int) Math.min(j3 - j2, length))) != -1) {
                                if (read <= 0) {
                                    readingKt$copyTo$12.L$0 = inputStream2;
                                    readingKt$copyTo$12.L$1 = byteWriteChannel2;
                                    readingKt$copyTo$12.L$2 = bArr2;
                                    readingKt$copyTo$12.J$0 = j3;
                                    readingKt$copyTo$12.J$1 = j2;
                                    readingKt$copyTo$12.J$2 = length;
                                    readingKt$copyTo$12.I$0 = read;
                                    readingKt$copyTo$12.label = 1;
                                    if (byteWriteChannel2.writeFully(bArr2, 0, read, readingKt$copyTo$12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    long j9 = j2;
                                    j7 = length;
                                    j5 = j9;
                                    inputStream3 = inputStream2;
                                    i2 = read;
                                    long j82 = j7;
                                    j2 = j5 + i2;
                                    length = j82;
                                    inputStream2 = inputStream3;
                                    while (j2 < j3) {
                                        if (read <= 0) {
                                        }
                                    }
                                }
                            }
                            Long boxLong2 = Boxing.boxLong(j2);
                            ByteArrayPoolKt.getByteArrayPool().recycle(bArr2);
                            return boxLong2;
                        } catch (Throwable th2) {
                            th = th2;
                            bArr = bArr2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                ByteArrayPoolKt.getByteArrayPool().recycle(bArr);
                throw th;
            }
        }
        readingKt$copyTo$1 = new ReadingKt$copyTo$1(continuation);
        Object obj2 = readingKt$copyTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = readingKt$copyTo$1.label;
        if (i != 0) {
        }
        ByteArrayPoolKt.getByteArrayPool().recycle(bArr);
        throw th;
    }

    public static /* synthetic */ Object copyTo$default(InputStream inputStream, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(inputStream, byteWriteChannel, j, continuation);
    }

    public static /* synthetic */ ByteReadChannel toByteReadChannel$default(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool objectPool, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getIO();
        }
        return toByteReadChannel(inputStream, coroutineContext, objectPool);
    }

    public static final ByteReadChannel toByteReadChannel(InputStream inputStream, CoroutineContext context, ObjectPool<ByteBuffer> pool) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pool, "pool");
        return CoroutinesKt.writer((CoroutineScope) GlobalScope.INSTANCE, context, true, (Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object>) new ReadingKt$toByteReadChannel$1(pool, inputStream, null)).getChannel();
    }

    public static /* synthetic */ ByteReadChannel toByteReadChannelWithArrayPool$default(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool objectPool, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getIO();
        }
        if ((i & 2) != 0) {
            objectPool = ByteArrayPoolKt.getByteArrayPool();
        }
        return toByteReadChannelWithArrayPool(inputStream, coroutineContext, objectPool);
    }

    public static final ByteReadChannel toByteReadChannelWithArrayPool(InputStream inputStream, CoroutineContext context, ObjectPool<byte[]> pool) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pool, "pool");
        return CoroutinesKt.writer((CoroutineScope) GlobalScope.INSTANCE, context, true, (Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object>) new ReadingKt$toByteReadChannel$2(pool, inputStream, null)).getChannel();
    }
}
