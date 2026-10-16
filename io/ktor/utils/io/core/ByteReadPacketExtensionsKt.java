package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteReadPacketExtensions.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\bø\u0001\u0000\u001a*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"ByteReadPacket", "Lio/ktor/utils/io/core/ByteReadPacket;", "bb", "Ljava/nio/ByteBuffer;", "release", "Lkotlin/Function1;", "", "array", "", "offset", "", "length", "block", "poolFor", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ByteReadPacketExtensionsKt {
    public static final ByteReadPacket ByteReadPacket(byte[] array, int i, int i2, Function1<? super byte[], Unit> block) {
        Intrinsics.checkNotNullParameter(array, "array");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteBuffer wrap = ByteBuffer.wrap(array, i, i2);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(array, offset, length)");
        return ByteReadPacket(wrap, new ByteReadPacketExtensionsKt$ByteReadPacket$1(block, array));
    }

    public static /* synthetic */ ByteReadPacket ByteReadPacket$default(ByteBuffer byteBuffer, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<ByteBuffer, Unit>() { // from class: io.ktor.utils.io.core.ByteReadPacketExtensionsKt$ByteReadPacket$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ByteBuffer it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer2) {
                    invoke2(byteBuffer2);
                    return Unit.INSTANCE;
                }
            };
        }
        return ByteReadPacket(byteBuffer, function1);
    }

    public static final ByteReadPacket ByteReadPacket(ByteBuffer bb, Function1<? super ByteBuffer, Unit> release) {
        Intrinsics.checkNotNullParameter(bb, "bb");
        Intrinsics.checkNotNullParameter(release, "release");
        ObjectPool<ChunkBuffer> poolFor = poolFor(bb, release);
        ChunkBuffer borrow = poolFor.borrow();
        borrow.resetForRead();
        return new ByteReadPacket(borrow, poolFor);
    }

    private static final ObjectPool<ChunkBuffer> poolFor(ByteBuffer byteBuffer, Function1<? super ByteBuffer, Unit> function1) {
        return new SingleByteBufferPool(byteBuffer, function1);
    }

    public static /* synthetic */ ByteReadPacket ByteReadPacket$default(byte[] array, int i, int i2, Function1 block, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = array.length;
        }
        Intrinsics.checkNotNullParameter(array, "array");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteBuffer wrap = ByteBuffer.wrap(array, i, i2);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(array, offset, length)");
        return ByteReadPacket(wrap, new ByteReadPacketExtensionsKt$ByteReadPacket$1(block, array));
    }
}
