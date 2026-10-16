package io.ktor.client.utils;

import com.ironsource.C3040d4;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ByteArrayPoolKt;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: ByteChannelUtils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.utils.ByteChannelUtilsKt$observable$1", f = "ByteChannelUtils.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3}, l = {23, 24, 26, 31}, m = "invokeSuspend", n = {"$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", C3040d4.h.l, "bytesSend", "$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", C3040d4.h.l, "bytesSend", "read", "$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", C3040d4.h.l, "bytesSend", "$this$useInstance$iv", "instance$iv"}, s = {"L$0", "L$1", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1", "L$4", "L$5", "J$0", "J$1", "I$0", "L$0", "L$1", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1"})
/* loaded from: classes8.dex */
final class ByteChannelUtilsKt$observable$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $contentLength;
    final /* synthetic */ Function3<Long, Long, Continuation<? super Unit>, Object> $listener;
    final /* synthetic */ ByteReadChannel $this_observable;
    int I$0;
    long J$0;
    long J$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ByteChannelUtilsKt$observable$1(Long l, ByteReadChannel byteReadChannel, Function3<? super Long, ? super Long, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super ByteChannelUtilsKt$observable$1> continuation) {
        super(2, continuation);
        this.$contentLength = l;
        this.$this_observable = byteReadChannel;
        this.$listener = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ByteChannelUtilsKt$observable$1 byteChannelUtilsKt$observable$1 = new ByteChannelUtilsKt$observable$1(this.$contentLength, this.$this_observable, this.$listener, continuation);
        byteChannelUtilsKt$observable$1.L$0 = obj;
        return byteChannelUtilsKt$observable$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((ByteChannelUtilsKt$observable$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0198, code lost:
    
        if (r11.invoke(r6, r4, r22) == r0) goto L61;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ef A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:9:0x001d, B:10:0x019b, B:23:0x00e9, B:25:0x00ef, B:29:0x0109, B:42:0x016b, B:46:0x017c), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016b A[Catch: all -> 0x0022, TRY_ENTER, TryCatch #0 {all -> 0x0022, blocks: (B:9:0x001d, B:10:0x019b, B:23:0x00e9, B:25:0x00ef, B:29:0x0109, B:42:0x016b, B:46:0x017c), top: B:2:0x000c }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x015d -> B:21:0x0059). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ObjectPool objectPool;
        long j;
        ByteReadChannel byteReadChannel;
        long longValue;
        Function3<Long, Long, Continuation<? super Unit>, Object> function3;
        byte[] bArr;
        WriterScope writerScope;
        Object obj2;
        long j2;
        long j3;
        Object obj3;
        ByteReadChannel byteReadChannel2;
        long j4;
        ObjectPool objectPool2;
        int i;
        long j5;
        Long boxLong;
        Long boxLong2;
        Object obj4;
        Object obj5;
        int intValue;
        ByteWriteChannel channel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = this.label;
        int i2 = 1;
        try {
            if (r2 == 0) {
                j = 0;
                ResultKt.throwOnFailure(obj);
                WriterScope writerScope2 = (WriterScope) this.L$0;
                objectPool = ByteArrayPoolKt.getByteArrayPool();
                Long l = this.$contentLength;
                ByteReadChannel byteReadChannel3 = this.$this_observable;
                Function3<Long, Long, Continuation<? super Unit>, Object> function32 = this.$listener;
                Object borrow = objectPool.borrow();
                try {
                    byte[] bArr2 = (byte[]) borrow;
                    byteReadChannel = byteReadChannel3;
                    longValue = l != null ? l.longValue() : -1L;
                    function3 = function32;
                    bArr = bArr2;
                    writerScope = writerScope2;
                    obj2 = borrow;
                    j2 = 0;
                    if (!byteReadChannel.isClosedForRead()) {
                    }
                    return coroutine_suspended;
                } catch (Throwable th) {
                    th = th;
                    r2 = borrow;
                }
            } else if (r2 == 1) {
                j = 0;
                long j6 = this.J$1;
                longValue = this.J$0;
                bArr = (byte[]) this.L$5;
                Object obj6 = this.L$4;
                function3 = (Function3) this.L$3;
                byteReadChannel = (ByteReadChannel) this.L$2;
                ObjectPool objectPool3 = (ObjectPool) this.L$1;
                writerScope = (WriterScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    j2 = j6;
                    obj5 = obj6;
                    objectPool = objectPool3;
                    obj4 = obj;
                    intValue = ((Number) obj4).intValue();
                    channel = writerScope.getChannel();
                    this.L$0 = writerScope;
                    this.L$1 = objectPool;
                    this.L$2 = byteReadChannel;
                    this.L$3 = function3;
                    this.L$4 = obj5;
                    this.L$5 = bArr;
                    this.J$0 = longValue;
                    this.J$1 = j2;
                    this.I$0 = intValue;
                    this.label = 2;
                    if (channel.writeFully(bArr, 0, intValue, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } catch (Throwable th2) {
                    th = th2;
                    r2 = obj6;
                    objectPool = objectPool3;
                }
            } else if (r2 == 2) {
                j = 0;
                i = this.I$0;
                long j7 = this.J$1;
                long j8 = this.J$0;
                byte[] bArr3 = (byte[]) this.L$5;
                obj3 = this.L$4;
                Function3<Long, Long, Continuation<? super Unit>, Object> function33 = (Function3) this.L$3;
                ByteReadChannel byteReadChannel4 = (ByteReadChannel) this.L$2;
                ObjectPool objectPool4 = (ObjectPool) this.L$1;
                WriterScope writerScope3 = (WriterScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    j3 = j7;
                    byteReadChannel2 = byteReadChannel4;
                    writerScope = writerScope3;
                    objectPool2 = objectPool4;
                    j4 = j8;
                    bArr = bArr3;
                    function3 = function33;
                    j5 = j3 + i;
                    boxLong = Boxing.boxLong(j5);
                    boxLong2 = Boxing.boxLong(j4);
                    this.L$0 = writerScope;
                    this.L$1 = objectPool2;
                    this.L$2 = byteReadChannel2;
                    this.L$3 = function3;
                    this.L$4 = obj3;
                    this.L$5 = bArr;
                    this.J$0 = j4;
                    this.J$1 = j5;
                    this.label = 3;
                    if (function3.invoke(boxLong, boxLong2, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } catch (Throwable th3) {
                    th = th3;
                    r2 = obj3;
                    objectPool = objectPool4;
                }
            } else {
                if (r2 != 3) {
                    if (r2 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Object obj7 = this.L$1;
                    objectPool = (ObjectPool) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r2 = obj7;
                    Unit unit = Unit.INSTANCE;
                    objectPool.recycle(r2);
                    return Unit.INSTANCE;
                }
                long j9 = this.J$1;
                long j10 = this.J$0;
                byte[] bArr4 = (byte[]) this.L$5;
                Object obj8 = this.L$4;
                Function3<Long, Long, Continuation<? super Unit>, Object> function34 = (Function3) this.L$3;
                ByteReadChannel byteReadChannel5 = (ByteReadChannel) this.L$2;
                j = 0;
                objectPool = (ObjectPool) this.L$1;
                WriterScope writerScope4 = (WriterScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    writerScope = writerScope4;
                    longValue = j10;
                    function3 = function34;
                    byteReadChannel = byteReadChannel5;
                    long j11 = j9;
                    bArr = bArr4;
                    Object obj9 = obj8;
                    j2 = j11;
                    i2 = 1;
                    obj2 = obj9;
                    if (!byteReadChannel.isClosedForRead()) {
                        this.L$0 = writerScope;
                        this.L$1 = objectPool;
                        this.L$2 = byteReadChannel;
                        this.L$3 = function3;
                        this.L$4 = obj2;
                        this.L$5 = bArr;
                        this.J$0 = longValue;
                        this.J$1 = j2;
                        this.label = i2;
                        obj4 = ByteReadChannelKt.readAvailable(byteReadChannel, bArr, this);
                        obj5 = obj2;
                        if (obj4 == coroutine_suspended) {
                        }
                        intValue = ((Number) obj4).intValue();
                        channel = writerScope.getChannel();
                        this.L$0 = writerScope;
                        this.L$1 = objectPool;
                        this.L$2 = byteReadChannel;
                        this.L$3 = function3;
                        this.L$4 = obj5;
                        this.L$5 = bArr;
                        this.J$0 = longValue;
                        this.J$1 = j2;
                        this.I$0 = intValue;
                        this.label = 2;
                        if (channel.writeFully(bArr, 0, intValue, this) != coroutine_suspended) {
                            try {
                                j3 = j2;
                                byteReadChannel2 = byteReadChannel;
                                obj3 = obj5;
                                j4 = longValue;
                                i = intValue;
                                objectPool2 = objectPool;
                                boxLong = Boxing.boxLong(j5);
                                boxLong2 = Boxing.boxLong(j4);
                                this.L$0 = writerScope;
                                this.L$1 = objectPool2;
                                this.L$2 = byteReadChannel2;
                                this.L$3 = function3;
                                this.L$4 = obj3;
                                this.L$5 = bArr;
                                this.J$0 = j4;
                                this.J$1 = j5;
                                this.label = 3;
                                if (function3.invoke(boxLong, boxLong2, this) != coroutine_suspended) {
                                    j11 = j5;
                                    objectPool = objectPool2;
                                    longValue = j4;
                                    obj9 = obj3;
                                    byteReadChannel = byteReadChannel2;
                                    j2 = j11;
                                    i2 = 1;
                                    obj2 = obj9;
                                    if (!byteReadChannel.isClosedForRead()) {
                                        Throwable closedCause = byteReadChannel.getClosedCause();
                                        writerScope.getChannel().close(closedCause);
                                        r2 = obj2;
                                        if (closedCause == null) {
                                            r2 = obj2;
                                            if (j2 == j) {
                                                Long boxLong3 = Boxing.boxLong(j2);
                                                Long boxLong4 = Boxing.boxLong(longValue);
                                                this.L$0 = objectPool;
                                                this.L$1 = obj2;
                                                this.L$2 = null;
                                                this.L$3 = null;
                                                this.L$4 = null;
                                                this.L$5 = null;
                                                this.label = 4;
                                                r2 = obj2;
                                            }
                                        }
                                        Unit unit2 = Unit.INSTANCE;
                                        objectPool.recycle(r2);
                                        return Unit.INSTANCE;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                objectPool = objectPool2;
                                r2 = obj3;
                            }
                            j5 = j3 + i;
                        }
                    }
                    return coroutine_suspended;
                } catch (Throwable th5) {
                    th = th5;
                    r2 = obj8;
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
        objectPool.recycle(r2);
        throw th;
    }
}
