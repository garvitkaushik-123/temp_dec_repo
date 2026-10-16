package io.ktor.utils.io.core;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.utils.io.bits.MemoryJvmKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferPrimitivesJvm.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"readFully", "", "Lio/ktor/utils/io/core/Buffer;", FirebaseAnalytics.Param.DESTINATION, "Ljava/nio/ByteBuffer;", "writeFully", "source", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class BufferPrimitivesJvmKt {
    public static final void readFully(Buffer buffer, ByteBuffer destination) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int remaining = destination.remaining();
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= remaining) {
            MemoryJvmKt.m9983copyTo62zg_DM(memory, destination, readPosition);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(remaining);
            return;
        }
        throw new EOFException("Not enough bytes to read a buffer content of size " + remaining + '.');
    }

    public static final void writeFully(Buffer buffer, ByteBuffer source) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int remaining = source.remaining();
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= remaining) {
            MemoryJvmKt.m9987copyToSG11BkQ(source, memory, writePosition);
            buffer.commitWritten(remaining);
            return;
        }
        throw new InsufficientSpaceException("buffer content", remaining, limit);
    }
}
