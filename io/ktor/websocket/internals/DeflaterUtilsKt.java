package io.ktor.websocket.internals;

import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeflaterUtils.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a$\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"EMPTY_CHUNK", "", "PADDED_EMPTY_CHUNK", "deflateFully", "Ljava/util/zip/Deflater;", "data", "deflateTo", "", "Lio/ktor/utils/io/core/BytePacketBuilder;", "deflater", "buffer", "Ljava/nio/ByteBuffer;", "flush", "", "inflateFully", "Ljava/util/zip/Inflater;", "ktor-websockets"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DeflaterUtilsKt {
    private static final byte[] PADDED_EMPTY_CHUNK = {0, 0, 0, -1, -1};
    private static final byte[] EMPTY_CHUNK = {0, 0, -1, -1};

    public static final byte[] deflateFully(Deflater deflater, byte[] data) {
        Intrinsics.checkNotNullParameter(deflater, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        deflater.setInput(data);
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        try {
            ObjectPool<ByteBuffer> ktorDefaultPool = ByteBufferPoolKt.getKtorDefaultPool();
            ByteBuffer borrow = ktorDefaultPool.borrow();
            try {
                ByteBuffer byteBuffer = borrow;
                while (!deflater.needsInput()) {
                    deflateTo(bytePacketBuilder, deflater, byteBuffer, false);
                }
                while (deflateTo(bytePacketBuilder, deflater, byteBuffer, true) != 0) {
                }
                Unit unit = Unit.INSTANCE;
                ktorDefaultPool.recycle(borrow);
                ByteReadPacket build = bytePacketBuilder.build();
                if (BytePacketUtilsKt.endsWith(build, PADDED_EMPTY_CHUNK)) {
                    byte[] readBytes = StringsKt.readBytes(build, ((int) build.getRemaining()) - EMPTY_CHUNK.length);
                    build.release();
                    return readBytes;
                }
                bytePacketBuilder = new BytePacketBuilder(null, 1, null);
                try {
                    bytePacketBuilder.writePacket(build);
                    bytePacketBuilder.writeByte((byte) 0);
                    return StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, null);
                } finally {
                }
            } catch (Throwable th) {
                ktorDefaultPool.recycle(borrow);
                throw th;
            }
        } finally {
        }
    }

    public static final byte[] inflateFully(Inflater inflater, byte[] data) {
        Intrinsics.checkNotNullParameter(inflater, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        inflater.setInput(ArraysKt.plus(data, EMPTY_CHUNK));
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        try {
            ObjectPool<ByteBuffer> ktorDefaultPool = ByteBufferPoolKt.getKtorDefaultPool();
            ByteBuffer borrow = ktorDefaultPool.borrow();
            try {
                ByteBuffer byteBuffer = borrow;
                long length = r11.length + inflater.getBytesRead();
                while (inflater.getBytesRead() < length) {
                    byteBuffer.clear();
                    byteBuffer.position(byteBuffer.position() + inflater.inflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit()));
                    byteBuffer.flip();
                    OutputArraysJVMKt.writeFully(bytePacketBuilder, byteBuffer);
                }
                Unit unit = Unit.INSTANCE;
                ktorDefaultPool.recycle(borrow);
                return StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, null);
            } catch (Throwable th) {
                ktorDefaultPool.recycle(borrow);
                throw th;
            }
        } catch (Throwable th2) {
            bytePacketBuilder.release();
            throw th2;
        }
    }

    private static final int deflateTo(BytePacketBuilder bytePacketBuilder, Deflater deflater, ByteBuffer byteBuffer, boolean z) {
        int deflate;
        byteBuffer.clear();
        if (z) {
            deflate = deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit(), 2);
        } else {
            deflate = deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
        }
        if (deflate == 0) {
            return 0;
        }
        byteBuffer.position(byteBuffer.position() + deflate);
        byteBuffer.flip();
        OutputArraysJVMKt.writeFully(bytePacketBuilder, byteBuffer);
        return deflate;
    }
}
