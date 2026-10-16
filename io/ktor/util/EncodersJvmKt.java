package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.zip.Checksum;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: EncodersJvm.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\b\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0082\u0004\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\tH\u0002\u001a-\u0010\u0010\u001a\u00020\u0005*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Deflate", "Lio/ktor/util/Encoder;", "getDeflate", "()Lio/ktor/util/Encoder;", "GZIP_HEADER_SIZE", "", "GZip", "getGZip", "has", "", "flag", "inflate", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/coroutines/CoroutineScope;", "source", "gzip", "inflateTo", "Ljava/util/zip/Inflater;", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "buffer", "Ljava/nio/ByteBuffer;", "checksum", "Ljava/util/zip/Checksum;", "(Ljava/util/zip/Inflater;Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/ByteBuffer;Ljava/util/zip/Checksum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class EncodersJvmKt {
    private static final int GZIP_HEADER_SIZE = 10;
    private static final Encoder Deflate = new Encoder() { // from class: io.ktor.util.EncodersJvmKt$Deflate$1
        @Override // io.ktor.util.Encoder
        public ByteReadChannel encode(CoroutineScope coroutineScope, ByteReadChannel source) {
            Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
            Intrinsics.checkNotNullParameter(source, "source");
            return DeflaterKt.deflated$default(source, true, (ObjectPool) null, coroutineScope.getCoroutineContext(), 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteReadChannel decode(CoroutineScope coroutineScope, ByteReadChannel source) {
            ByteReadChannel inflate;
            Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
            Intrinsics.checkNotNullParameter(source, "source");
            inflate = EncodersJvmKt.inflate(coroutineScope, source, false);
            return inflate;
        }
    };
    private static final Encoder GZip = new Encoder() { // from class: io.ktor.util.EncodersJvmKt$GZip$1
        @Override // io.ktor.util.Encoder
        public ByteReadChannel encode(CoroutineScope coroutineScope, ByteReadChannel source) {
            Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
            Intrinsics.checkNotNullParameter(source, "source");
            return DeflaterKt.deflated$default(source, true, (ObjectPool) null, coroutineScope.getCoroutineContext(), 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteReadChannel decode(CoroutineScope coroutineScope, ByteReadChannel source) {
            Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
            Intrinsics.checkNotNullParameter(source, "source");
            return EncodersJvmKt.inflate$default(coroutineScope, source, false, 2, null);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean has(int i, int i2) {
        return (i & i2) != 0;
    }

    public static final Encoder getDeflate() {
        return Deflate;
    }

    public static final Encoder getGZip() {
        return GZip;
    }

    static /* synthetic */ ByteReadChannel inflate$default(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return inflate(coroutineScope, byteReadChannel, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel inflate(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel, boolean z) {
        return CoroutinesKt.writer$default(coroutineScope, (CoroutineContext) null, false, (Function2) new EncodersJvmKt$inflate$1(z, byteReadChannel, null), 3, (Object) null).getChannel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object inflateTo(Inflater inflater, ByteWriteChannel byteWriteChannel, ByteBuffer byteBuffer, Checksum checksum, Continuation<? super Integer> continuation) {
        EncodersJvmKt$inflateTo$1 encodersJvmKt$inflateTo$1;
        int i;
        int inflate;
        if (continuation instanceof EncodersJvmKt$inflateTo$1) {
            encodersJvmKt$inflateTo$1 = (EncodersJvmKt$inflateTo$1) continuation;
            if ((encodersJvmKt$inflateTo$1.label & Integer.MIN_VALUE) != 0) {
                encodersJvmKt$inflateTo$1.label -= Integer.MIN_VALUE;
                Object obj = encodersJvmKt$inflateTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = encodersJvmKt$inflateTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBuffer.clear();
                    inflate = inflater.inflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
                    byteBuffer.position(byteBuffer.position() + inflate);
                    byteBuffer.flip();
                    DeflaterKt.updateKeepPosition(checksum, byteBuffer);
                    encodersJvmKt$inflateTo$1.I$0 = inflate;
                    encodersJvmKt$inflateTo$1.label = 1;
                    if (byteWriteChannel.writeFully(byteBuffer, encodersJvmKt$inflateTo$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    inflate = encodersJvmKt$inflateTo$1.I$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxInt(inflate);
            }
        }
        encodersJvmKt$inflateTo$1 = new EncodersJvmKt$inflateTo$1(continuation);
        Object obj2 = encodersJvmKt$inflateTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = encodersJvmKt$inflateTo$1.label;
        if (i != 0) {
        }
        return Boxing.boxInt(inflate);
    }
}
